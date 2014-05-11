package com.worldpay.sdk.model;


/**
 * Request to create a token
 */
public class TokenRequest implements Request {

    /**
     * Serial version id
     */
    private static final long serialVersionUID = 7481422052421422035L;

    /**
     * Payment method for this order
     */
    private AbstractPaymentMethod paymentMethod;

    /**
     * Public key for the merchant
     */
    private String clientKey;

    public String getClientKey() {
        return clientKey;
    }

    public void setClientKey(String clientKey) {
        this.clientKey = clientKey;
    }

    public AbstractPaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(AbstractPaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
