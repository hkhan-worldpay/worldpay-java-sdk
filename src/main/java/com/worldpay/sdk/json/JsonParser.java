package com.worldpay.sdk.json;

import java.io.InputStream;

import org.codehaus.jackson.map.ObjectMapper;

/**
 * Class used for converting to and from JSON.
 */
public final class JsonParser {

    private static final ObjectMapper PARSER = new ObjectMapper();

    private JsonParser() {

    }

    /**
     * Convert an object to JSON representation.
     *
     * @param object
     * @return
     */
    public static String toJson(Object object) {
        try {
            return PARSER.writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Convert a string to Object representation.
     *
     * @param json
     * @param type
     * @return
     */
    public static <T> T toObject(String json, Class<T> type) {
        try {
            return PARSER.readValue(json, type);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Convert an input stream to Object representation.
     *
     * @param in
     * @param type
     * @return
     */
    public static <T> T toObject(InputStream in, Class<T> type) {
        try {
            return PARSER.readValue(in, type);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
