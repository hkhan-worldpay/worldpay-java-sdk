package com.worldpay.sdk.model;

/**
 * Types of warnings
 */
public enum WarningCode {

    /**
     * Invalid key format
     */
    INVALID_KEY_FORMAT("Key: %s is invalid, please make sure key is a valid UTF-8 or properly encoded string, and not more than 255 chars"),

    /**
     * Invalid value supplied for a key
     */
    INVALID_KEY_VALUE(
        "Value: %s is invalid for key: %s, please make sure key is a valid UTF-8 or properly encoded string, and not more than 255 chars"),

    /**
     * Key and value both are missing
     */
    INVALID_KEY_VALUE_ENTRY("Key and Value are invalid for key: '%s' and value: '%s'"),

    /**
     * Invalid value for a key
     */
    INVALID_VALUE_FOR_KEY("Key: %s does not have a value, please make sure every key provided has a value."),

    /**
     * Missing Key for a value
     */
    INVALID_KEY("Key for value: %s does not have a name."),

    /**
     * Invalid format for a value
     */
    KEY_VALUE_ENTRIES_LIMIT_EXCEEDED("Number of Valid Key Value entries exceeded the current limit of %d. Removed Entry(s) are: %s"),

    /**
     * In case of duplicate keys found
     */
    DUPLICATE_KEY_VALUE_ENTRIES_REMOVED("Duplicate Key Value Entries(s): %s are removed. Only the first occurrence of a key is considered.");

    /**
     * Warning message
     */
    private String message;

    /**
     * Constructor used by enum
     *
     * @param message warning message template for the code
     */
    WarningCode(String message) {
        this.message = message;
    }

    /**
     * Get the warning message
     *
     * @return message template
     */
    public String getMessage() {
        return message;
    }
}
