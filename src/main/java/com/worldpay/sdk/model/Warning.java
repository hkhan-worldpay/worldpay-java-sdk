package com.worldpay.sdk.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonTypeInfo;

/**
 * Warning type
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
public class Warning implements Serializable {

    /**
     * Serial version id
     */
    private static final long serialVersionUID = 1041943846989754270L;

    /**
     * {@code WarningCode}
     */
    private WarningCode code;

    /**
     * Message
     */
    private String message;

    /**
     * Default constructor
     */
    public Warning() {
    }

    /**
     * Parametrized constructor
     *
     * @param code    {@link WarningCode}
     * @param message warning message
     */
    public Warning(WarningCode code, String message) {
        this.code = code;
        this.message = message;
    }

    public WarningCode getCode() {
        return code;
    }

    public void setCode(WarningCode code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
