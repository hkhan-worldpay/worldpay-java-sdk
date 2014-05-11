package com.worldpay.sdk.model;

import org.codehaus.jackson.annotate.JsonTypeInfo;

import java.io.Serializable;

/**
 * Error object.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
public class ApiError implements Serializable {

    private static final long serialVersionUID = 3946490182182240913L;

    /**
     * Http status code
     */
    private Integer httpStatusCode;

    /**
     * Our custom code
     */
    private String customCode;

    /**
     * Brief Error message
     */
    private String message;

    /**
     * Description of error
     */
    private String description;

    /**
     * Link to errors and descriptions etc.
     */
    private String errorHelpUrl;

    /**
     * Original request that cause this error
     */
    private String originalRequest;

    /**
     * Default constructor
     */
    public ApiError() {
    }

    public Integer getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(Integer httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public String getCustomCode() {
        return customCode;
    }

    public void setCustomCode(String customCode) {
        this.customCode = customCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getErrorHelpUrl() {
        return errorHelpUrl;
    }

    public void setErrorHelpUrl(String errorHelpUrl) {
        this.errorHelpUrl = errorHelpUrl;
    }

    public String getOriginalRequest() {
        return originalRequest;
    }

    public void setOriginalRequest(String originalRequest) {
        this.originalRequest = originalRequest;
    }

}
