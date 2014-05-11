package com.worldpay.sdk.model;

import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;

/**
 * Base wrapper for all response dtos
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({@JsonSubTypes.Type(TokenResponse.class),
               @JsonSubTypes.Type(OrderResponse.class)})
@JsonSerialize(include = JsonSerialize.Inclusion.NON_EMPTY)
public interface Response extends Serializable {
}
