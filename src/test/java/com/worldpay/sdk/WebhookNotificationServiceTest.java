package com.worldpay.sdk;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.worldpay.sdk.WebhookNotificationService;
import com.worldpay.sdk.WorldpayGateway;
import com.worldpay.sdk.model.Environment;
import com.worldpay.sdk.model.Notification;
import com.worldpay.sdk.util.PropertyUtils;

/**
 *
 */
public class WebhookNotificationServiceTest {

    private WebhookNotificationService webhookNotificationService;

    @Before
    public void setup() {
        webhookNotificationService = new WorldpayGateway(PropertyUtils.serviceKey()).webhookNotification();
    }

    @Test
    public void shouldConvertPayload() {
        String payload = "{\n" +
                        "        \"type\" : \"Notification\",\n" +
                        "        \"webhookId\" : \"c63d4e10-ba85-11e3-a4e2-0800200c9a66\",\n" +
                        "        \"orderCode\" : \"worldpay-order-code\",\n" +
                        "        \"paymentStatus\" : \"SUCCESS\",\n" +
                        "        \"environment\" : \"TEST\"\n" +
                        "}";
        Notification notification = webhookNotificationService.parse(payload);

        assertThat(notification.getWebhookId(), is(notNullValue()));
        assertThat(notification.getOrderCode(), is("worldpay-order-code"));
        assertThat(notification.getPaymentStatus(), is("SUCCESS"));
        assertThat(notification.getEnvironment(), is(Environment.TEST));
    }

}
