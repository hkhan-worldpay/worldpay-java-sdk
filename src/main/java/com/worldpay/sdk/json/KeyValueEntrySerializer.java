package com.worldpay.sdk.json;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import com.worldpay.sdk.model.Entry;

/**
 * Serializer for {@link Entry}
 */
public class KeyValueEntrySerializer extends JsonSerializer<List<Entry>> {

    /**
     * System Line separator
     */
    private String newLine = System.getProperty("line.separator");

    @Override
    public void serialize(List<Entry> value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        jgen.writeStartObject();
        int lastIndex = 0;
        for (Entry entry : value) {
            jgen.writeRaw(newLine);

            String entryKey = entry.getKey();
            if(entryKey != null){
                entryKey = "\"" + entryKey + "\"";
            }
            String entryValue = entry.getValue();
            if(entryValue != null){
                entryValue =  "\"" + entryValue  + "\"";
            }
            jgen.writeRaw(entryKey + " : " + entryValue);
            lastIndex++;
            if (lastIndex != value.size()) {
                jgen.writeRaw(",");
            }
        }
        jgen.writeEndObject();
    }
}
