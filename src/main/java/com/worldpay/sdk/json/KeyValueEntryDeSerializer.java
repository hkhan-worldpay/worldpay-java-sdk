package com.worldpay.sdk.json;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

import com.worldpay.sdk.model.Entry;

/**
 * Deserializer for {@link Entry}
 */
public class KeyValueEntryDeSerializer extends JsonDeserializer<List<Entry>> {

    /**
     * Null as a string
     */
    public static final String NULL_AS_FIELD_NAME_VALUE = "null";

    @Override
    public List<Entry> deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        List<Entry> entries = new ArrayList<Entry>();
        JsonToken token = jp.getCurrentToken();
        if (!token.equals(JsonToken.START_OBJECT)) {
            return entries;
        } else {
            token = jp.nextToken();
        }
        while (!token.equals(JsonToken.END_OBJECT)) {
            if (token.equals(JsonToken.FIELD_NAME)) {
                // This String value looks like an object - try to parse $relative
                String key = jp.getText();
                if (key.equals(NULL_AS_FIELD_NAME_VALUE)) {
                    key = null;
                }
                String value = null;
                token = jp.nextToken();
                if (token.equals(JsonToken.VALUE_STRING) && !jp.getText().equals(NULL_AS_FIELD_NAME_VALUE)) {
                    value = jp.getText();
                }
                Entry entry = new Entry(key, value);
                entries.add(entry);
                token = jp.nextToken();
            }
        }
        return entries;
    }
}
