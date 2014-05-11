package com.worldpay.sdk.model;


/**
 * Response for a {@code TokenRequest}
 */
public class TokenResponse implements Response {

    /**
     * Serial version id
     */
    private static final long serialVersionUID = 3581465992028724997L;

    /**
     * Object identifier
     */
    private String id;

    /**
     * Token that was created using payment details, this is valid for single use
     */
    private String singleUseToken;

    /**
     * An instance of Payment method used (e.g. {@code CardResponse})
     */
    private AbstractPaymentMethod paymentMethod;

    /**
     * Constructor with all mandatory properties
     *
     * @param id             Object id
     * @param singleUseToken token String
     * @param paymentMethod  {@code AbstractPaymentMethod}
     */
    public TokenResponse(String id, String singleUseToken, AbstractPaymentMethod paymentMethod) {
        this.id = id;
        this.singleUseToken = singleUseToken;
        this.paymentMethod = paymentMethod;
    }

    public String getId() {
        return id;
    }

    public String getSingleUseToken() {
        return singleUseToken;
    }

    public AbstractPaymentMethod getPaymentMethod() {
        return paymentMethod;
    }
}
