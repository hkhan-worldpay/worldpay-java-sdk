package com.worldpay.sdk.model;

import java.io.Serializable;

/**
 * Key Value entries
 */
public class Entry implements Serializable {

    /**
     * Serial version id
     */
    private static final long serialVersionUID = 6006264993361083972L;

    /**
     * Key name
     */
    private String key;

    /**
     * Value text
     */
    private String value;

    /**
     * Default constructor
     */
    public Entry() {
    }

    /**
     * Parametrized constructor for
     *
     * @param key Key
     * @param value Value
     */
    public Entry(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
