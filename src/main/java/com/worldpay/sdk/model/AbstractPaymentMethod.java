package com.worldpay.sdk.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * Payment method request
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({@JsonSubTypes.Type(value = CardRequest.class, name = "Card" ),
               @JsonSubTypes.Type(value = CardResponse.class, name = "ObfuscatedCard")})
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public abstract class AbstractPaymentMethod implements Serializable {

    /**
     * Version id for serialization
     */
    private static final long serialVersionUID = 8972174419432365975L;

    /**
     * Name that appear on payment method, e.g card holder name, bank account name etc
     */
    private String name;

    /**
     * Payment method address
     */
    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String billableShopperName) {
        this.name = billableShopperName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
