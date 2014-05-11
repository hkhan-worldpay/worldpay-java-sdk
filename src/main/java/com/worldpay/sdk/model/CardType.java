package com.worldpay.sdk.model;

import org.codehaus.jackson.annotate.JsonCreator;

import java.util.Arrays;

/**
 * Card type, e.g. VISA, MASTERCARD etc.
 */
public enum CardType {

    /**
     * Visa Credit card,
     * Covers switch
     */
    VISA(3, 16, new String[]{"4"}),

    /**
     * Master card
     * Carte Bleue
     */
    MASTERCARD(3, 16, new String[]{"51", "52", "53", "54", "55"}),
    BHS(3, 16, new String[]{"63191"}),
    IKEA(3, 16, new String[]{"627598"}),
    AMEX(4, 16, new String[]{"34", "37"}),
    DINERS(3, 16, new String[]{"36"}),
    DANKORT(3, 16, new String[]{"4571"}),
    DISCOVER(3, 16, new String[]{"6011", "65"}),
    JCB(3, 16, new String[]{"35"}),
    AIRPLUS(3, 15, new String[]{"122"}),
    UATP(3, 16, new String[]{"14983", "1777", "14653"}),
    MAESTRO(3, 19, new String[]{"56", "67"}),
    LASER(3, 19, new String[]{"6304", "6706", "6771", "6709"}),
    UNKNOWN(3, 16, new String[]{Constants.EMPTY_STRING});
    /*
    AURORE(3, 16),
    GECAPITAL(3, 16),
    SOLO_GB(3, 16), covered in Visa
    LASER(3, 16), covered in Visa
    NCPB2B(3, 16), ??
    NCPSEASON(3, 16), ??
    NCPGMM(3, 16), ??
    CARD(3, 16); ??
    */
    /**
     * Card Verification code
     */
    private int maxCvcLength;

    /**
     * Maximum length of card number supported
     */
    private int cardNumberLength;

    /**
     * First few identification digits in a card number, array of prefixes
     */
    private final String[] cardPrefixes;

    /**
     * Constructor for definiting a skeleton card type
     *
     * @param maxCvcLength     Max length of cvc
     * @param cardNumberLength Max length of a card
     * @param cardPrefixes     Card number initial digits
     */
    private CardType(int maxCvcLength, int cardNumberLength, String[] cardPrefixes) {
        this.maxCvcLength = maxCvcLength;
        this.cardNumberLength = cardNumberLength;
        this.cardPrefixes = Arrays.copyOf(cardPrefixes, cardPrefixes.length);
    }

    /**
     * Get CVC length
     *
     * @return max length of cvc
     */
    public int getMaxCvcLength() {
        return maxCvcLength;
    }

    /**
     * Maximum length of a card number
     *
     * @return length of card number
     */
    public int getCardNumberLength() {
        return cardNumberLength;
    }

    /**
     * Get card prefix
     *
     * @return card prefix string, containing a sequence of digit(s)
     */
    public String[] getCardPrefixes() {
        return cardPrefixes;
    }

    /**
     * To support mixed case currency code
     *
     * @param value currency code
     *
     * @return {@code CardType}
     */
    @JsonCreator
    public static CardType fromValue(String value) {
        if (value == null || value.trim().length() == 0) {
            throw new IllegalArgumentException("Card type can't be null/empty");
        }

        //Remove all spaces
        String trimmedString = value.replaceAll("\\s+", Constants.EMPTY_STRING);
        return CardType.valueOf(trimmedString.toUpperCase());
    }


}
