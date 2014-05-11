package com.worldpay.sdk.model;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.worldpay.sdk.json.KeyValueEntryDeSerializer;
import com.worldpay.sdk.json.KeyValueEntrySerializer;

/**
 * Holds Warnings and valid KV Pairs
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_EMPTY)
public class KeyValueResponse implements Serializable {

    /**
     * Serial version id
     */
    private static final long serialVersionUID = -3739141154045794660L;

    /**
     * {@code List} of {@link Warning}s
     */
    private List<Warning> warnings;

    /**
     * {@code Set} of Valid {@link Entry}s
     */
    private List<Entry> customerIdentifiers;

    /**
     * Build a Key Value response
     *
     * @param warnings {@code List} of {@link Warning}s
     * @param customerIdentifiers  {@code Set} of Valid {@link Entry}s
     */
    public KeyValueResponse(List<Warning> warnings, List<Entry> customerIdentifiers) {
        this.warnings = warnings;
        this.customerIdentifiers = customerIdentifiers;
    }

    /**
     * Hidden constructor
     */
    KeyValueResponse() {
    }


    public List<Warning> getWarnings() {
        return warnings;
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
