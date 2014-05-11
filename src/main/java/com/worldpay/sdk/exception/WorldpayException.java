package com.worldpay.sdk.exception;

import com.worldpay.sdk.model.ApiError;

/**
 * Exception for wrapping Worldpay REST API errors.
 */
public class WorldpayException extends RuntimeException {

    private static final long serialVersionUID = -1422555226234297999L;

    private ApiError error;

    /**
     * Create with the specified {@link ApiError}.
     *
     * @param error
     */
    public WorldpayException(ApiError error) {
        super(error.getMessage());
        this.error = error;
    }

    /**
     * Return the wrapped error.
     *
     * @return
     */
    public ApiError getError() {
        return error;
    }

}
