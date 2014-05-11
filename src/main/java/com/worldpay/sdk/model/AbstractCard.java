package com.worldpay.sdk.model;


/**
 * Common properties of a Card in Request and responses
 */
public abstract class AbstractCard extends AbstractPaymentMethod {

    /**
     * Serial version id
     */
    private static final long serialVersionUID = 3180680883076837119L;

    /**
     * Card expiry month
     */
    private Integer expiryMonth;

    /**
     * Card expiry year, with maximum of 4 digits allowed
     */
    private Integer expiryYear;

    /**
     * Optional Card Issuer Number
     */
    private Integer issueNumber;

    /**
     * Card start month
     */
    private Integer startMonth;

    /**
     * Card start year, with maximum of 4 digits allowed
     */
    private Integer startYear;

    public Integer getExpiryMonth() {
        return expiryMonth;
    }

    public void setExpiryMonth(Integer expiryMonth) {
        this.expiryMonth = expiryMonth;
    }

    public Integer getExpiryYear() {
        return expiryYear;
    }

    public void setExpiryYear(Integer expiryYear) {
        this.expiryYear = expiryYear;
    }

    public Integer getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(Integer issueNumber) {
        this.issueNumber = issueNumber;
    }

    public Integer getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(Integer startMonth) {
        this.startMonth = startMonth;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }

}
