package com.worldpay.sdk.model;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.worldpay.sdk.json.KeyValueEntryDeSerializer;
import com.worldpay.sdk.json.KeyValueEntrySerializer;

/**
 * Order request object, to create an order
 */
public class OrderRequest extends AbstractOrder implements Request {

    /**
     * Serial version id
     */
    private static final long serialVersionUID = 608076913587836969L;

    /**
     * Shopper name to override shopper name on record if available
     */
    private String name;

    /**
     * List of key value entries, which can have duplicates
     */
    private List<Entry> customerIdentifiers = new ArrayList<Entry>();

    /**
     * Billing Address
     */
    private Address billingAddress;

    public String getName() {
        return name;
    }

    public void setName(String billableShopperName) {
        this.name = billableShopperName;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    @JsonSerialize(using = KeyValueEntrySerializer.class, include = JsonSerialize.Inclusion.NON_EMPTY)
    public List<Entry> getCustomerIdentifiers() {
        return customerIdentifiers;
    }

    @JsonDeserialize(using = KeyValueEntryDeSerializer.class)
    public void setCustomerIdentifiers(List<Entry> customerIdentifiers) {
        this.customerIdentifiers = customerIdentifiers;
    }
}

