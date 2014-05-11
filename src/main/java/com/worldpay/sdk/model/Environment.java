package com.worldpay.sdk.model;

/**
 * Simple type to define environments
 */
public enum Environment {

    /**
     * Test Environment
     */
    TEST("T"),

    /**
     * Production/Live Environment
     */
    LIVE("L");

    /**
     * Create an instance
     *
     * @param prefix prefix
     */
    private Environment(String prefix) {
        this.prefix = prefix;
    }

    /**
     * Prefix
     */
    private String prefix;

    public String getPrefix() {
        return prefix;
    }
}