package com.worldpay.sdk.model;


/**
 * Card as a Payment type, (VISA, MASTERCARD etc)
 */
public class CardRequest extends AbstractCard {

    /**
     * Serial version id
     */
    private static final long serialVersionUID = -8918123603838457262L;

    /**
     * Card number
     */
    private String cardNumber;

    /**
     * CVC Code
     */
    private String cvc;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }
}
