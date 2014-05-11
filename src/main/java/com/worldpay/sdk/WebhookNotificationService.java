package com.worldpay.sdk;

import com.worldpay.sdk.json.JsonParser;
import com.worldpay.sdk.model.Notification;

/**
 * Service for handling webhook notifications.
 */
public class WebhookNotificationService extends AbstractService {

    /**
     * @param http
     */
    WebhookNotificationService(Http http) {
        super(http);
    }

    /**
     * Convert a given string to a {@link Notification} object.
     *
     * @param payload
     * @return
     */
    public Notification parse(String payload) {
        return JsonParser.toObject(payload, Notification.class);
    }

}
