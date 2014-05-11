package com.worldpay.sdk.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonTypeInfo;

/**
 * Payment response wrapper
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
public class PaymentResponse implements Serializable {

    private static final long serialVersionUID = 5931341294728376349L;

    /**
     * Payment method used
     */
    private String paymentMethod;

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
