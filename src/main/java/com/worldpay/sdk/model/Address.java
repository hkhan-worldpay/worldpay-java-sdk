package com.worldpay.sdk.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonTypeInfo;

/**
 * Address type for different address parameters
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
public class Address implements Serializable {

    /**
     * Serial version id
     */
    private static final long serialVersionUID = 3293080852858785342L;

    /**
     * Address line 1 should be between 2 and 50 characters long, all alphanumeric.
     * This field is mandatory.
     */
    private String address1 = Constants.EMPTY_STRING;

    /**
     * Address line 2 should be between 2 and 50 characters long, all alphanumeric.
     * This field is optional.
     */
    private String address2 = Constants.EMPTY_STRING;

    /**
     * Address line 3 should be between 2 and 50 characters long, all alphanumeric.
     * This field is optional.
     */
    private String address3 = Constants.EMPTY_STRING;

    /**
     * Postcode should be between 2 and 50 characters long, all alphanumeric.
     * This field is mandatory.
     */
    private String postalCode = Constants.EMPTY_STRING;

    /**
     * City should be between 2 and 50 characters long, all alphanumeric.
     * This field is mandatory.
     */
    private String city = Constants.EMPTY_STRING;

    /**
     * State
     */
    private String state = Constants.EMPTY_STRING;

    /**
     * Country code should be in the ISO 3166-1 format
     * This field is mandatory
     */
    private CountryCode countryCode;

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public CountryCode getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(CountryCode countryCode) {
        this.countryCode = countryCode;
    }
}
