package com.worldpay.sdk.model;

/**
 * Body content of the webhook notification messages.
 */
public class Notification implements Response {

    /**
     * Version id.
     */
    private static final long serialVersionUID = 2433875150856698029L;

    /**
     * The identifier of this notification request. Each time a delivery is attempted, this id will be updated.
     */
    private String id;

    /**
     * The webhook that triggered this notification.
     */
    private String webhookId;

    /**
     * The code of the {@code Order} whose status was updated.
     */
    private String orderCode;

    /**
     * The new {@code PaymentStatus}.
     */
    private String paymentStatus;

    /**
     * Which environment the order comes from.
     */
    private Environment environment;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWebhookId() {
        return webhookId;
    }

    public void setWebhookId(String webhookId) {
        this.webhookId = webhookId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
