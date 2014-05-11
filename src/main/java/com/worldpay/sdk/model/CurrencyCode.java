package com.worldpay.sdk.model;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonCreator;

/**
 * Enum for currency code that we support
 */
public enum CurrencyCode {
    ARS(2),
    AUD(2),
    BRL(2),
    CAD(2),
    CHF(2),
    CLP(2),
    CNY(2),
    COP(2),
    CZK(2),
    DKK(2),
    EUR(2),
    GBP(2),
    HKD(2),
    HUF(2),
    IDR(0),
    ISK(2),
    JPY(0),
    KES(2),
    KRW(0),
    MXP(2),
    MYR(2),
    NOK(2),
    NZD(2),
    PHP(2),
    PLN(2),
    PTE(2),
    SEK(2),
    SGD(2),
    SKK(2),
    THB(2),
    TWD(2),
    USD(2),
    VND(2),
    ZAR(2),
    ILS(2);

    /**
     * Exponent
     */
    private final Integer exponent;

    /**
     * Static map for lookup later
     */
    private static final Map<String, CurrencyCode> CURRENCY_CODE_MAP = new HashMap<String, CurrencyCode>();

    /**
     * Builds map
     */
    static {
        for (CurrencyCode currencyCode : values()) {
            CURRENCY_CODE_MAP.put(currencyCode.name(), currencyCode);
        }
    }

    /**
     * Creates a token
     *
     * @param exponent exponent
     */
    private CurrencyCode(int exponent) {
        this.exponent = exponent;
    }

    public Integer getExponent() {
        return exponent;
    }

    /**
     * To support mixed case currency code
     *
     * @param value currency code
     *
     * @return {@code CurrencyCode}
     */
    @JsonCreator
    public static CurrencyCode fromValue(String value) {
        if (value == null || value.trim().length() == 0) {
            throw new IllegalArgumentException("Currency can't be null/empty");
        }
        String trimmedString = value.replaceAll("\\s+", "");
        return CURRENCY_CODE_MAP.get(trimmedString.toUpperCase());
    }
}
