package com.worldpay.sdk.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Enum representing current payment status
 *
 */
public enum PaymentStatus {

    SENT_FOR_AUTHORISATION,
    AUTHORISED,
    REFUSED,
    CAPTURED,
    ERROR,
    CANCELLED,
    CHARGED_BACK,
    SETTLED,
    SENT_FOR_REFUND,
    REFUNDED,
    FAILED_TO_REFUND,
    EXPIRED,
    SUCCESS,
    FAILED,
    CHARGEBACK_REVERSED,
    UNKNOWN;


    /**
     * Static map for lookup later
     */
    private static final Map<String, PaymentStatus> PAYMENT_STATUS_CODE_MAP = new HashMap<String, PaymentStatus>();


    /**
     * Builds map
     */
    static {
        for (PaymentStatus paymentStatus : values()) {
            PAYMENT_STATUS_CODE_MAP.put(paymentStatus.name(), paymentStatus);
        }
    }
}
