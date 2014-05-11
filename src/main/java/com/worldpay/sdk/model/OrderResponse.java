package com.worldpay.sdk.model;

import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.annotate.JsonUnwrapped;

/**
 * Response for an order request
 */
@JsonPropertyOrder({"id", "orderCode", "singleUseToken", "orderDescription"})
public class OrderResponse extends AbstractOrder implements Response {

    /**
     * Serial version id
     */
    private static final long serialVersionUID = 3994282844871000659L;

    /**
     * Object identifier
     */
    private String id;

    /**
     * Generated order code
     */
    private String orderCode;

    /**
     * Current payment status
     */
    private PaymentStatus paymentStatus;

    /**
     * Payment status reason
     */
    private String paymentStatusReason;

    /**
     * Response for payment
     */
    private AbstractPaymentMethod paymentResponse;

    /**
     * {@link KeyValueResponse}
     */
    @JsonUnwrapped
    private KeyValueResponse keyValueResponse = new KeyValueResponse();

    /**
     * {@link Environment}
     */
    private Environment environment;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public AbstractPaymentMethod getPaymentResponse() {
        return paymentResponse;
    }

    public void setPaymentResponse(AbstractPaymentMethod paymentResponse) {
        this.paymentResponse = paymentResponse;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public KeyValueResponse getKeyValueResponse() {
        return keyValueResponse;
    }

    public void setKeyValueResponse(KeyValueResponse keyValueResponse) {
        this.keyValueResponse = keyValueResponse;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public String getPaymentStatusReason() {
        return paymentStatusReason;
    }

    public void setPaymentStatusReason(String paymentStatusReason) {
        this.paymentStatusReason = paymentStatusReason;
    }
}
