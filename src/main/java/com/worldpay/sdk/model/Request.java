package com.worldpay.sdk.model;

import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonTypeInfo;

import java.io.Serializable;

/**
 * A base for all request dtos
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({@JsonSubTypes.Type(TokenRequest.class), @JsonSubTypes.Type(OrderRequest.class)})
public interface Request extends Serializable {
}
