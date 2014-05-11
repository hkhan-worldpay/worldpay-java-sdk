package com.worldpay.sdk;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.fluent.Request;
import org.apache.http.client.utils.URIBuilder;
import org.junit.Before;
import org.junit.Test;

import com.worldpay.sdk.OrderService;
import com.worldpay.sdk.WorldpayGateway;
import com.worldpay.sdk.exception.WorldpayException;
import com.worldpay.sdk.model.Address;
import com.worldpay.sdk.model.CountryCode;
import com.worldpay.sdk.model.CurrencyCode;
import com.worldpay.sdk.model.Entry;
import com.worldpay.sdk.model.OrderRequest;
import com.worldpay.sdk.model.OrderResponse;
import com.worldpay.sdk.model.PaymentStatus;
import com.worldpay.sdk.util.PropertyUtils;

public class OrderServiceTest {

    /**
     * A Token Json Template to be filled in with real values, this is done in WEB using worldpay.js,
     * we are here creating token so we can use it with orders
     */
    private static final String TOKEN_REQUEST_TEMPLATE =
        "{\"type\" : \"TokenRequest\", \"paymentMethod\" : {\"type\" : \"%s\",\"name\" : "
        + "\"%s\",\"expiryMonth\" : %s,\"expiryYear\" : %s" + ",\"cardNumber\" : \"%s\",\"cvc\" : \"%s\""
        + "},\"clientKey\" : \"%s\"}";

    /**
     * Test Master card number.
     */
    private static final String TEST_MASTERCARD_NUMBER = "5555 5555 5555 4444";

    /**
     * Card Verification code.
     */
    private static final String TEST_CVC = "123";

    private OrderService orderService;

    @Before
    public void setup() {
        orderService = new WorldpayGateway(PropertyUtils.serviceKey()).order();
    }

    @Test
    public void shouldCreateOrderForValidToken() {
        OrderRequest orderRequest = createOrderRequest();
        orderRequest.setSingleUseToken(createToken());

        OrderResponse response = orderService.create(orderRequest);

        assertThat(response.getOrderCode(), is(notNullValue()));
        assertThat(response.getAmount(), is(1999));
        assertThat(response.getKeyValueResponse().getCustomerIdentifiers(), is(notNullValue()));
    }

    @Test
    public void shouldRefundOrder() {
        OrderRequest orderRequest = createOrderRequest();
        orderRequest.setSingleUseToken(createToken());

        String orderCode = orderService.create(orderRequest).getOrderCode();
        assertThat(orderCode, is(notNullValue()));

        OrderResponse refundResponse = orderService.refund(orderCode);
        assertThat(refundResponse.getPaymentStatus(), is(equalTo(PaymentStatus.REFUNDED)));
    }

    @Test
    public void shouldThrowExceptionForInvalidToken() {
        OrderRequest orderRequest = createOrderRequest();
        orderRequest.setSingleUseToken("invalid token");

        try {
            orderService.create(orderRequest).getOrderCode();
        } catch (WorldpayException e) {
            assertThat(e.getError().getCustomCode(), is("TKN_NOT_FOUND"));
        }
    }

    private OrderRequest createOrderRequest() {
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setAmount(1999);
        orderRequest.setCurrencyCode(CurrencyCode.GBP);
        orderRequest.setName("test name");
        orderRequest.setOrderDescription("test description");

        Address address = new Address();
        address.setAddress1("line 1");
        address.setAddress2("line 2");
        address.setCity("city");
        address.setCountryCode(CountryCode.GB);
        address.setPostalCode("AB1 2CD");
        orderRequest.setBillingAddress(address);

        List<Entry> customerIdentifiers = new ArrayList<Entry>();
        Entry entry = new Entry("test key 1", "test value 1");
        customerIdentifiers.add(entry);

        orderRequest.setCustomerIdentifiers(customerIdentifiers );
        return orderRequest;
    }

   private String createToken() {
       String tokenJson = String.format(TOKEN_REQUEST_TEMPLATE, "Card", "javalib client", 2, 2018,
                                        TEST_MASTERCARD_NUMBER, TEST_CVC, PropertyUtils.getProperty("clientKey"));

       String response;
       try {
            URI uri = new URIBuilder(WorldpayGateway.API_BASE).setPath("/v1/createTokens")
                            .setParameter("data", tokenJson)
                            .setParameter("callback", "jsonpCallback")
                            .build();
            response = Request.Get(uri).execute().returnContent().asString();
       } catch (Exception e) {
           throw new RuntimeException(e);
       }

       return singleUseTokenFrom(response);
   }

    private String singleUseTokenFrom(String response) {
        final String startPattern = "\"singleUseToken\":\"";
        final int beginIndex = response.indexOf(startPattern) + startPattern.length();
        return response.substring(beginIndex, response.indexOf("\"", beginIndex));
    }

}
