package com.worldpay.sdk;

import com.worldpay.sdk.model.OrderRequest;
import com.worldpay.sdk.model.OrderResponse;

/**
 * Service used for the order related operations.
 */
public class OrderService extends AbstractService {

    OrderService(Http http) {
        super(http);
    }

    /**
     * Create an order with the specified request.
     *
     * @param the {@link OrderRequest} object
     * @return the {@link OrderResponse} object
     */
    public OrderResponse create(OrderRequest orderRequest) {
        return http.post("/orders", orderRequest, OrderResponse.class);
    }

    /**
     * Refund the order identified by order code.
     *
     * @param orderCode
     * @return the {@link OrderResponse} object
     */
    public OrderResponse refund(String orderCode) {
        return http.post("/orders/" + orderCode + "/refund", null, OrderResponse.class);
    }

}
