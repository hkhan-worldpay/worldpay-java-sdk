package com.worldpay.sdk.model;

import java.io.Serializable;

/**
 * Common fields of {@code OrderRequest} and {@code OrderResponse}
 */
public class AbstractOrder implements Serializable {

    /**
     * Version id
     */
    private static final long serialVersionUID = -2075954248620205397L;

    /**
     * Single Use Token (Mandatory), for which order needs to be created
     */
    private String singleUseToken;

    /**
     * Optional order description
     */
    private String orderDescription;

    /**
     * Amount to authorize or capture, minimum of 1 cent
     */
    private Integer amount;

    /**
     * Currency code (optional, if its not provided in the request, currency associated with token is used)
     */
    private CurrencyCode currencyCode;

    /**
     * For JSON Requests
     */
    public AbstractOrder() {
    }

    /**
     * For JSON Responses
     *
     * @param singleUseToken   Single use token
     * @param orderDescription Order description
     * @param amount           amount
     * @param currencyCode     {@link CurrencyCode}
     */
    public AbstractOrder(String singleUseToken, String orderDescription, Integer amount, CurrencyCode currencyCode) {
        this.singleUseToken = singleUseToken;
        this.orderDescription = orderDescription;
        this.amount = amount;
        this.currencyCode = currencyCode;
    }

    public String getSingleUseToken() {
        return singleUseToken;
    }

    public void setSingleUseToken(String singleUseToken) {
        this.singleUseToken = singleUseToken;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public CurrencyCode getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(CurrencyCode currencyCode) {
        this.currencyCode = currencyCode;
    }

}
