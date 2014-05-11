package com.worldpay.sdk.model;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Card specific payment response
 */
public class CardResponse extends AbstractCard {

    /**
     * Serial Version Id
     */
    private static final long serialVersionUID = -2737251569236270085L;

    /**
     * Card type derived by card number in request
     */
    private CardType cardType;

    /**
     * Masked card number
     */
    private String maskedCardNumber = Constants.EMPTY_STRING;

    /**
     * No Arg constructor
     */
    public CardResponse() {
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public String getMaskedCardNumber() {
        return maskedCardNumber;
    }

    public void setMaskedCardNumber(String maskedCardNumber) {
        this.maskedCardNumber = maskedCardNumber;
    }

    @JsonProperty("billingAddress")
    public Address getAddress() {
        return super.getAddress();
    }
}
