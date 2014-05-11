package com.worldpay.sdk;

/**
 * Main interface for interacting with the Worldpay Payment Gateway REST service.<br><br>
 *
 * Example:
 *
 * <pre>
 *
 *   WorldpayGateway worldpay = new WorldpayGateway("YOUR_SERVICE_KEY");
 *
 *   OrderRequest orderRequest = new OrderRequest();
 *   orderRequest.setSingleUseToken("valid-token");
 *   orderRequest.setAmount(1999);
 *   orderRequest.setCurrencyCode(CurrencyCode.GBP);
 *   orderRequest.setName("test name");
 *   orderRequest.setOrderDescription("test description");
 *
 *   try {
 *       OrderResponse orderResponse = worldpay.order().create(orderRequest);
 *       System.out.println("Order code: " + orderResponse.getOrderCode());
 *   } catch (WorldpayException wpe) {
 *       System.out.println("Error code: " + wpe.getError().getCustomCode());
 *       System.out.println("Error description: " + wpe.getError().getDescription());
 *       System.out.println("Error message: " + wpe.getError().getMessage());
 *   }
 * </pre>
 */
public class WorldpayGateway {

    /**
     * Default URL for Worldpay service.
     */
    public static final String API_BASE = "https://api.worldpay.com/v1";

    /**
     * Version.
     */
    public static final String VERSION = "0.1.0";

    private Http http;

    /**
     * Create a new gateway with the specified base URL and the service key.
     *
     * @param baseUrl URL for connecting to the service
     * @param serviceKey the service key for service authentication
     */
    public WorldpayGateway(String baseUrl, String serviceKey) {
        if (baseUrl == null) {
            throw new IllegalArgumentException("baseUrl cannot be null");
        }

        if(serviceKey == null) {
            throw new IllegalArgumentException("serviceKey cannot be null");
        }

        this.http = new Http(baseUrl, serviceKey);
    }

    /**
     * Create a new gateway with the default base URL and the service key.
     *
     * @param serviceKey the service key for service authentication
     */
    public WorldpayGateway(String serviceKey) {
        this(API_BASE, serviceKey);
    }

    /**
     * Returns an {@link OrderService} for interacting with order end point.
     *
     * @return the order service
     */
    public OrderService order() {
        return new OrderService(http);
    }

    /**
     * Returns a {@link WebhookNotificationService} for interacting with webhook notifications.
     *
     * @return
     */
    public WebhookNotificationService webhookNotification() {
        return new WebhookNotificationService(http);
    }
}
