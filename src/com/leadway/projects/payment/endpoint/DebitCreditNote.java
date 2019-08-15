/**
 * DebitCreditNote.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.leadway.projects.payment.endpoint;

public class DebitCreditNote  implements java.io.Serializable {
    private java.lang.String address;

    private java.lang.String agentCode;

    private double agentCommission;

    private java.lang.Long agentID;

    private java.lang.String agentName;

    private java.lang.String branchCode;

    private java.lang.String brokerReference;

    private java.lang.String CDNNumber;

    private java.lang.String certificateNumber;

    private long cityId;

    private java.lang.String currency;

    private com.leadway.projects.payment.endpoint.CurrentInsurancePeriod currentInsurancePeriod;

    private java.lang.String debitCreditNoteNumber;

    private java.lang.String debitCreditSign;

    private boolean deleted;

    private java.util.Calendar effectiveDate;

    private java.util.Calendar entryDate;

    private java.lang.String ISTransmitStatus;

    private java.util.Calendar inceptionDate;

    private long lgaId;

    private java.lang.String linkDebitCreditNumber;

    private java.lang.String nameOfInsured;

    private java.lang.String narration;

    private double netAmount;

    private java.lang.String percentDistribution;

    private java.lang.String policyNumber;

    private double premiumAmount;

    private java.lang.String previousReference;

    private int prorata;

    private java.lang.String referenceNumber;

    private java.lang.String scheduleGroup;

    private java.lang.String stateCode;

    private java.lang.String subsystem;

    private java.lang.String transactionCode;

    private java.util.Calendar transactionDate;

    private long transactionLink;

    private java.lang.String transactionMode;

    private java.lang.String transactionSource;

    private java.lang.String transactionType;

    private java.lang.String userName;

    public DebitCreditNote() {
    }

    public DebitCreditNote(
           java.lang.String address,
           java.lang.String agentCode,
           double agentCommission,
           java.lang.Long agentID,
           java.lang.String agentName,
           java.lang.String branchCode,
           java.lang.String brokerReference,
           java.lang.String CDNNumber,
           java.lang.String certificateNumber,
           long cityId,
           java.lang.String currency,
           com.leadway.projects.payment.endpoint.CurrentInsurancePeriod currentInsurancePeriod,
           java.lang.String debitCreditNoteNumber,
           java.lang.String debitCreditSign,
           boolean deleted,
           java.util.Calendar effectiveDate,
           java.util.Calendar entryDate,
           java.lang.String ISTransmitStatus,
           java.util.Calendar inceptionDate,
           long lgaId,
           java.lang.String linkDebitCreditNumber,
           java.lang.String nameOfInsured,
           java.lang.String narration,
           double netAmount,
           java.lang.String percentDistribution,
           java.lang.String policyNumber,
           double premiumAmount,
           java.lang.String previousReference,
           int prorata,
           java.lang.String referenceNumber,
           java.lang.String scheduleGroup,
           java.lang.String stateCode,
           java.lang.String subsystem,
           java.lang.String transactionCode,
           java.util.Calendar transactionDate,
           long transactionLink,
           java.lang.String transactionMode,
           java.lang.String transactionSource,
           java.lang.String transactionType,
           java.lang.String userName) {
           this.address = address;
           this.agentCode = agentCode;
           this.agentCommission = agentCommission;
           this.agentID = agentID;
           this.agentName = agentName;
           this.branchCode = branchCode;
           this.brokerReference = brokerReference;
           this.CDNNumber = CDNNumber;
           this.certificateNumber = certificateNumber;
           this.cityId = cityId;
           this.currency = currency;
           this.currentInsurancePeriod = currentInsurancePeriod;
           this.debitCreditNoteNumber = debitCreditNoteNumber;
           this.debitCreditSign = debitCreditSign;
           this.deleted = deleted;
           this.effectiveDate = effectiveDate;
           this.entryDate = entryDate;
           this.ISTransmitStatus = ISTransmitStatus;
           this.inceptionDate = inceptionDate;
           this.lgaId = lgaId;
           this.linkDebitCreditNumber = linkDebitCreditNumber;
           this.nameOfInsured = nameOfInsured;
           this.narration = narration;
           this.netAmount = netAmount;
           this.percentDistribution = percentDistribution;
           this.policyNumber = policyNumber;
           this.premiumAmount = premiumAmount;
           this.previousReference = previousReference;
           this.prorata = prorata;
           this.referenceNumber = referenceNumber;
           this.scheduleGroup = scheduleGroup;
           this.stateCode = stateCode;
           this.subsystem = subsystem;
           this.transactionCode = transactionCode;
           this.transactionDate = transactionDate;
           this.transactionLink = transactionLink;
           this.transactionMode = transactionMode;
           this.transactionSource = transactionSource;
           this.transactionType = transactionType;
           this.userName = userName;
    }


    /**
     * Gets the address value for this DebitCreditNote.
     * 
     * @return address
     */
    public java.lang.String getAddress() {
        return address;
    }


    /**
     * Sets the address value for this DebitCreditNote.
     * 
     * @param address
     */
    public void setAddress(java.lang.String address) {
        this.address = address;
    }


    /**
     * Gets the agentCode value for this DebitCreditNote.
     * 
     * @return agentCode
     */
    public java.lang.String getAgentCode() {
        return agentCode;
    }


    /**
     * Sets the agentCode value for this DebitCreditNote.
     * 
     * @param agentCode
     */
    public void setAgentCode(java.lang.String agentCode) {
        this.agentCode = agentCode;
    }


    /**
     * Gets the agentCommission value for this DebitCreditNote.
     * 
     * @return agentCommission
     */
    public double getAgentCommission() {
        return agentCommission;
    }


    /**
     * Sets the agentCommission value for this DebitCreditNote.
     * 
     * @param agentCommission
     */
    public void setAgentCommission(double agentCommission) {
        this.agentCommission = agentCommission;
    }


    /**
     * Gets the agentID value for this DebitCreditNote.
     * 
     * @return agentID
     */
    public java.lang.Long getAgentID() {
        return agentID;
    }


    /**
     * Sets the agentID value for this DebitCreditNote.
     * 
     * @param agentID
     */
    public void setAgentID(java.lang.Long agentID) {
        this.agentID = agentID;
    }


    /**
     * Gets the agentName value for this DebitCreditNote.
     * 
     * @return agentName
     */
    public java.lang.String getAgentName() {
        return agentName;
    }


    /**
     * Sets the agentName value for this DebitCreditNote.
     * 
     * @param agentName
     */
    public void setAgentName(java.lang.String agentName) {
        this.agentName = agentName;
    }


    /**
     * Gets the branchCode value for this DebitCreditNote.
     * 
     * @return branchCode
     */
    public java.lang.String getBranchCode() {
        return branchCode;
    }


    /**
     * Sets the branchCode value for this DebitCreditNote.
     * 
     * @param branchCode
     */
    public void setBranchCode(java.lang.String branchCode) {
        this.branchCode = branchCode;
    }


    /**
     * Gets the brokerReference value for this DebitCreditNote.
     * 
     * @return brokerReference
     */
    public java.lang.String getBrokerReference() {
        return brokerReference;
    }


    /**
     * Sets the brokerReference value for this DebitCreditNote.
     * 
     * @param brokerReference
     */
    public void setBrokerReference(java.lang.String brokerReference) {
        this.brokerReference = brokerReference;
    }


    /**
     * Gets the CDNNumber value for this DebitCreditNote.
     * 
     * @return CDNNumber
     */
    public java.lang.String getCDNNumber() {
        return CDNNumber;
    }


    /**
     * Sets the CDNNumber value for this DebitCreditNote.
     * 
     * @param CDNNumber
     */
    public void setCDNNumber(java.lang.String CDNNumber) {
        this.CDNNumber = CDNNumber;
    }


    /**
     * Gets the certificateNumber value for this DebitCreditNote.
     * 
     * @return certificateNumber
     */
    public java.lang.String getCertificateNumber() {
        return certificateNumber;
    }


    /**
     * Sets the certificateNumber value for this DebitCreditNote.
     * 
     * @param certificateNumber
     */
    public void setCertificateNumber(java.lang.String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }


    /**
     * Gets the cityId value for this DebitCreditNote.
     * 
     * @return cityId
     */
    public long getCityId() {
        return cityId;
    }


    /**
     * Sets the cityId value for this DebitCreditNote.
     * 
     * @param cityId
     */
    public void setCityId(long cityId) {
        this.cityId = cityId;
    }


    /**
     * Gets the currency value for this DebitCreditNote.
     * 
     * @return currency
     */
    public java.lang.String getCurrency() {
        return currency;
    }


    /**
     * Sets the currency value for this DebitCreditNote.
     * 
     * @param currency
     */
    public void setCurrency(java.lang.String currency) {
        this.currency = currency;
    }


    /**
     * Gets the currentInsurancePeriod value for this DebitCreditNote.
     * 
     * @return currentInsurancePeriod
     */
    public com.leadway.projects.payment.endpoint.CurrentInsurancePeriod getCurrentInsurancePeriod() {
        return currentInsurancePeriod;
    }


    /**
     * Sets the currentInsurancePeriod value for this DebitCreditNote.
     * 
     * @param currentInsurancePeriod
     */
    public void setCurrentInsurancePeriod(com.leadway.projects.payment.endpoint.CurrentInsurancePeriod currentInsurancePeriod) {
        this.currentInsurancePeriod = currentInsurancePeriod;
    }


    /**
     * Gets the debitCreditNoteNumber value for this DebitCreditNote.
     * 
     * @return debitCreditNoteNumber
     */
    public java.lang.String getDebitCreditNoteNumber() {
        return debitCreditNoteNumber;
    }


    /**
     * Sets the debitCreditNoteNumber value for this DebitCreditNote.
     * 
     * @param debitCreditNoteNumber
     */
    public void setDebitCreditNoteNumber(java.lang.String debitCreditNoteNumber) {
        this.debitCreditNoteNumber = debitCreditNoteNumber;
    }


    /**
     * Gets the debitCreditSign value for this DebitCreditNote.
     * 
     * @return debitCreditSign
     */
    public java.lang.String getDebitCreditSign() {
        return debitCreditSign;
    }


    /**
     * Sets the debitCreditSign value for this DebitCreditNote.
     * 
     * @param debitCreditSign
     */
    public void setDebitCreditSign(java.lang.String debitCreditSign) {
        this.debitCreditSign = debitCreditSign;
    }


    /**
     * Gets the deleted value for this DebitCreditNote.
     * 
     * @return deleted
     */
    public boolean isDeleted() {
        return deleted;
    }


    /**
     * Sets the deleted value for this DebitCreditNote.
     * 
     * @param deleted
     */
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }


    /**
     * Gets the effectiveDate value for this DebitCreditNote.
     * 
     * @return effectiveDate
     */
    public java.util.Calendar getEffectiveDate() {
        return effectiveDate;
    }


    /**
     * Sets the effectiveDate value for this DebitCreditNote.
     * 
     * @param effectiveDate
     */
    public void setEffectiveDate(java.util.Calendar effectiveDate) {
        this.effectiveDate = effectiveDate;
    }


    /**
     * Gets the entryDate value for this DebitCreditNote.
     * 
     * @return entryDate
     */
    public java.util.Calendar getEntryDate() {
        return entryDate;
    }


    /**
     * Sets the entryDate value for this DebitCreditNote.
     * 
     * @param entryDate
     */
    public void setEntryDate(java.util.Calendar entryDate) {
        this.entryDate = entryDate;
    }


    /**
     * Gets the ISTransmitStatus value for this DebitCreditNote.
     * 
     * @return ISTransmitStatus
     */
    public java.lang.String getISTransmitStatus() {
        return ISTransmitStatus;
    }


    /**
     * Sets the ISTransmitStatus value for this DebitCreditNote.
     * 
     * @param ISTransmitStatus
     */
    public void setISTransmitStatus(java.lang.String ISTransmitStatus) {
        this.ISTransmitStatus = ISTransmitStatus;
    }


    /**
     * Gets the inceptionDate value for this DebitCreditNote.
     * 
     * @return inceptionDate
     */
    public java.util.Calendar getInceptionDate() {
        return inceptionDate;
    }


    /**
     * Sets the inceptionDate value for this DebitCreditNote.
     * 
     * @param inceptionDate
     */
    public void setInceptionDate(java.util.Calendar inceptionDate) {
        this.inceptionDate = inceptionDate;
    }


    /**
     * Gets the lgaId value for this DebitCreditNote.
     * 
     * @return lgaId
     */
    public long getLgaId() {
        return lgaId;
    }


    /**
     * Sets the lgaId value for this DebitCreditNote.
     * 
     * @param lgaId
     */
    public void setLgaId(long lgaId) {
        this.lgaId = lgaId;
    }


    /**
     * Gets the linkDebitCreditNumber value for this DebitCreditNote.
     * 
     * @return linkDebitCreditNumber
     */
    public java.lang.String getLinkDebitCreditNumber() {
        return linkDebitCreditNumber;
    }


    /**
     * Sets the linkDebitCreditNumber value for this DebitCreditNote.
     * 
     * @param linkDebitCreditNumber
     */
    public void setLinkDebitCreditNumber(java.lang.String linkDebitCreditNumber) {
        this.linkDebitCreditNumber = linkDebitCreditNumber;
    }


    /**
     * Gets the nameOfInsured value for this DebitCreditNote.
     * 
     * @return nameOfInsured
     */
    public java.lang.String getNameOfInsured() {
        return nameOfInsured;
    }


    /**
     * Sets the nameOfInsured value for this DebitCreditNote.
     * 
     * @param nameOfInsured
     */
    public void setNameOfInsured(java.lang.String nameOfInsured) {
        this.nameOfInsured = nameOfInsured;
    }


    /**
     * Gets the narration value for this DebitCreditNote.
     * 
     * @return narration
     */
    public java.lang.String getNarration() {
        return narration;
    }


    /**
     * Sets the narration value for this DebitCreditNote.
     * 
     * @param narration
     */
    public void setNarration(java.lang.String narration) {
        this.narration = narration;
    }


    /**
     * Gets the netAmount value for this DebitCreditNote.
     * 
     * @return netAmount
     */
    public double getNetAmount() {
        return netAmount;
    }


    /**
     * Sets the netAmount value for this DebitCreditNote.
     * 
     * @param netAmount
     */
    public void setNetAmount(double netAmount) {
        this.netAmount = netAmount;
    }


    /**
     * Gets the percentDistribution value for this DebitCreditNote.
     * 
     * @return percentDistribution
     */
    public java.lang.String getPercentDistribution() {
        return percentDistribution;
    }


    /**
     * Sets the percentDistribution value for this DebitCreditNote.
     * 
     * @param percentDistribution
     */
    public void setPercentDistribution(java.lang.String percentDistribution) {
        this.percentDistribution = percentDistribution;
    }


    /**
     * Gets the policyNumber value for this DebitCreditNote.
     * 
     * @return policyNumber
     */
    public java.lang.String getPolicyNumber() {
        return policyNumber;
    }


    /**
     * Sets the policyNumber value for this DebitCreditNote.
     * 
     * @param policyNumber
     */
    public void setPolicyNumber(java.lang.String policyNumber) {
        this.policyNumber = policyNumber;
    }


    /**
     * Gets the premiumAmount value for this DebitCreditNote.
     * 
     * @return premiumAmount
     */
    public double getPremiumAmount() {
        return premiumAmount;
    }


    /**
     * Sets the premiumAmount value for this DebitCreditNote.
     * 
     * @param premiumAmount
     */
    public void setPremiumAmount(double premiumAmount) {
        this.premiumAmount = premiumAmount;
    }


    /**
     * Gets the previousReference value for this DebitCreditNote.
     * 
     * @return previousReference
     */
    public java.lang.String getPreviousReference() {
        return previousReference;
    }


    /**
     * Sets the previousReference value for this DebitCreditNote.
     * 
     * @param previousReference
     */
    public void setPreviousReference(java.lang.String previousReference) {
        this.previousReference = previousReference;
    }


    /**
     * Gets the prorata value for this DebitCreditNote.
     * 
     * @return prorata
     */
    public int getProrata() {
        return prorata;
    }


    /**
     * Sets the prorata value for this DebitCreditNote.
     * 
     * @param prorata
     */
    public void setProrata(int prorata) {
        this.prorata = prorata;
    }


    /**
     * Gets the referenceNumber value for this DebitCreditNote.
     * 
     * @return referenceNumber
     */
    public java.lang.String getReferenceNumber() {
        return referenceNumber;
    }


    /**
     * Sets the referenceNumber value for this DebitCreditNote.
     * 
     * @param referenceNumber
     */
    public void setReferenceNumber(java.lang.String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }


    /**
     * Gets the scheduleGroup value for this DebitCreditNote.
     * 
     * @return scheduleGroup
     */
    public java.lang.String getScheduleGroup() {
        return scheduleGroup;
    }


    /**
     * Sets the scheduleGroup value for this DebitCreditNote.
     * 
     * @param scheduleGroup
     */
    public void setScheduleGroup(java.lang.String scheduleGroup) {
        this.scheduleGroup = scheduleGroup;
    }


    /**
     * Gets the stateCode value for this DebitCreditNote.
     * 
     * @return stateCode
     */
    public java.lang.String getStateCode() {
        return stateCode;
    }


    /**
     * Sets the stateCode value for this DebitCreditNote.
     * 
     * @param stateCode
     */
    public void setStateCode(java.lang.String stateCode) {
        this.stateCode = stateCode;
    }


    /**
     * Gets the subsystem value for this DebitCreditNote.
     * 
     * @return subsystem
     */
    public java.lang.String getSubsystem() {
        return subsystem;
    }


    /**
     * Sets the subsystem value for this DebitCreditNote.
     * 
     * @param subsystem
     */
    public void setSubsystem(java.lang.String subsystem) {
        this.subsystem = subsystem;
    }


    /**
     * Gets the transactionCode value for this DebitCreditNote.
     * 
     * @return transactionCode
     */
    public java.lang.String getTransactionCode() {
        return transactionCode;
    }


    /**
     * Sets the transactionCode value for this DebitCreditNote.
     * 
     * @param transactionCode
     */
    public void setTransactionCode(java.lang.String transactionCode) {
        this.transactionCode = transactionCode;
    }


    /**
     * Gets the transactionDate value for this DebitCreditNote.
     * 
     * @return transactionDate
     */
    public java.util.Calendar getTransactionDate() {
        return transactionDate;
    }


    /**
     * Sets the transactionDate value for this DebitCreditNote.
     * 
     * @param transactionDate
     */
    public void setTransactionDate(java.util.Calendar transactionDate) {
        this.transactionDate = transactionDate;
    }


    /**
     * Gets the transactionLink value for this DebitCreditNote.
     * 
     * @return transactionLink
     */
    public long getTransactionLink() {
        return transactionLink;
    }


    /**
     * Sets the transactionLink value for this DebitCreditNote.
     * 
     * @param transactionLink
     */
    public void setTransactionLink(long transactionLink) {
        this.transactionLink = transactionLink;
    }


    /**
     * Gets the transactionMode value for this DebitCreditNote.
     * 
     * @return transactionMode
     */
    public java.lang.String getTransactionMode() {
        return transactionMode;
    }


    /**
     * Sets the transactionMode value for this DebitCreditNote.
     * 
     * @param transactionMode
     */
    public void setTransactionMode(java.lang.String transactionMode) {
        this.transactionMode = transactionMode;
    }


    /**
     * Gets the transactionSource value for this DebitCreditNote.
     * 
     * @return transactionSource
     */
    public java.lang.String getTransactionSource() {
        return transactionSource;
    }


    /**
     * Sets the transactionSource value for this DebitCreditNote.
     * 
     * @param transactionSource
     */
    public void setTransactionSource(java.lang.String transactionSource) {
        this.transactionSource = transactionSource;
    }


    /**
     * Gets the transactionType value for this DebitCreditNote.
     * 
     * @return transactionType
     */
    public java.lang.String getTransactionType() {
        return transactionType;
    }


    /**
     * Sets the transactionType value for this DebitCreditNote.
     * 
     * @param transactionType
     */
    public void setTransactionType(java.lang.String transactionType) {
        this.transactionType = transactionType;
    }


    /**
     * Gets the userName value for this DebitCreditNote.
     * 
     * @return userName
     */
    public java.lang.String getUserName() {
        return userName;
    }


    /**
     * Sets the userName value for this DebitCreditNote.
     * 
     * @param userName
     */
    public void setUserName(java.lang.String userName) {
        this.userName = userName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DebitCreditNote)) return false;
        DebitCreditNote other = (DebitCreditNote) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.address==null && other.getAddress()==null) || 
             (this.address!=null &&
              this.address.equals(other.getAddress()))) &&
            ((this.agentCode==null && other.getAgentCode()==null) || 
             (this.agentCode!=null &&
              this.agentCode.equals(other.getAgentCode()))) &&
            this.agentCommission == other.getAgentCommission() &&
            ((this.agentID==null && other.getAgentID()==null) || 
             (this.agentID!=null &&
              this.agentID.equals(other.getAgentID()))) &&
            ((this.agentName==null && other.getAgentName()==null) || 
             (this.agentName!=null &&
              this.agentName.equals(other.getAgentName()))) &&
            ((this.branchCode==null && other.getBranchCode()==null) || 
             (this.branchCode!=null &&
              this.branchCode.equals(other.getBranchCode()))) &&
            ((this.brokerReference==null && other.getBrokerReference()==null) || 
             (this.brokerReference!=null &&
              this.brokerReference.equals(other.getBrokerReference()))) &&
            ((this.CDNNumber==null && other.getCDNNumber()==null) || 
             (this.CDNNumber!=null &&
              this.CDNNumber.equals(other.getCDNNumber()))) &&
            ((this.certificateNumber==null && other.getCertificateNumber()==null) || 
             (this.certificateNumber!=null &&
              this.certificateNumber.equals(other.getCertificateNumber()))) &&
            this.cityId == other.getCityId() &&
            ((this.currency==null && other.getCurrency()==null) || 
             (this.currency!=null &&
              this.currency.equals(other.getCurrency()))) &&
            ((this.currentInsurancePeriod==null && other.getCurrentInsurancePeriod()==null) || 
             (this.currentInsurancePeriod!=null &&
              this.currentInsurancePeriod.equals(other.getCurrentInsurancePeriod()))) &&
            ((this.debitCreditNoteNumber==null && other.getDebitCreditNoteNumber()==null) || 
             (this.debitCreditNoteNumber!=null &&
              this.debitCreditNoteNumber.equals(other.getDebitCreditNoteNumber()))) &&
            ((this.debitCreditSign==null && other.getDebitCreditSign()==null) || 
             (this.debitCreditSign!=null &&
              this.debitCreditSign.equals(other.getDebitCreditSign()))) &&
            this.deleted == other.isDeleted() &&
            ((this.effectiveDate==null && other.getEffectiveDate()==null) || 
             (this.effectiveDate!=null &&
              this.effectiveDate.equals(other.getEffectiveDate()))) &&
            ((this.entryDate==null && other.getEntryDate()==null) || 
             (this.entryDate!=null &&
              this.entryDate.equals(other.getEntryDate()))) &&
            ((this.ISTransmitStatus==null && other.getISTransmitStatus()==null) || 
             (this.ISTransmitStatus!=null &&
              this.ISTransmitStatus.equals(other.getISTransmitStatus()))) &&
            ((this.inceptionDate==null && other.getInceptionDate()==null) || 
             (this.inceptionDate!=null &&
              this.inceptionDate.equals(other.getInceptionDate()))) &&
            this.lgaId == other.getLgaId() &&
            ((this.linkDebitCreditNumber==null && other.getLinkDebitCreditNumber()==null) || 
             (this.linkDebitCreditNumber!=null &&
              this.linkDebitCreditNumber.equals(other.getLinkDebitCreditNumber()))) &&
            ((this.nameOfInsured==null && other.getNameOfInsured()==null) || 
             (this.nameOfInsured!=null &&
              this.nameOfInsured.equals(other.getNameOfInsured()))) &&
            ((this.narration==null && other.getNarration()==null) || 
             (this.narration!=null &&
              this.narration.equals(other.getNarration()))) &&
            this.netAmount == other.getNetAmount() &&
            ((this.percentDistribution==null && other.getPercentDistribution()==null) || 
             (this.percentDistribution!=null &&
              this.percentDistribution.equals(other.getPercentDistribution()))) &&
            ((this.policyNumber==null && other.getPolicyNumber()==null) || 
             (this.policyNumber!=null &&
              this.policyNumber.equals(other.getPolicyNumber()))) &&
            this.premiumAmount == other.getPremiumAmount() &&
            ((this.previousReference==null && other.getPreviousReference()==null) || 
             (this.previousReference!=null &&
              this.previousReference.equals(other.getPreviousReference()))) &&
            this.prorata == other.getProrata() &&
            ((this.referenceNumber==null && other.getReferenceNumber()==null) || 
             (this.referenceNumber!=null &&
              this.referenceNumber.equals(other.getReferenceNumber()))) &&
            ((this.scheduleGroup==null && other.getScheduleGroup()==null) || 
             (this.scheduleGroup!=null &&
              this.scheduleGroup.equals(other.getScheduleGroup()))) &&
            ((this.stateCode==null && other.getStateCode()==null) || 
             (this.stateCode!=null &&
              this.stateCode.equals(other.getStateCode()))) &&
            ((this.subsystem==null && other.getSubsystem()==null) || 
             (this.subsystem!=null &&
              this.subsystem.equals(other.getSubsystem()))) &&
            ((this.transactionCode==null && other.getTransactionCode()==null) || 
             (this.transactionCode!=null &&
              this.transactionCode.equals(other.getTransactionCode()))) &&
            ((this.transactionDate==null && other.getTransactionDate()==null) || 
             (this.transactionDate!=null &&
              this.transactionDate.equals(other.getTransactionDate()))) &&
            this.transactionLink == other.getTransactionLink() &&
            ((this.transactionMode==null && other.getTransactionMode()==null) || 
             (this.transactionMode!=null &&
              this.transactionMode.equals(other.getTransactionMode()))) &&
            ((this.transactionSource==null && other.getTransactionSource()==null) || 
             (this.transactionSource!=null &&
              this.transactionSource.equals(other.getTransactionSource()))) &&
            ((this.transactionType==null && other.getTransactionType()==null) || 
             (this.transactionType!=null &&
              this.transactionType.equals(other.getTransactionType()))) &&
            ((this.userName==null && other.getUserName()==null) || 
             (this.userName!=null &&
              this.userName.equals(other.getUserName())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getAddress() != null) {
            _hashCode += getAddress().hashCode();
        }
        if (getAgentCode() != null) {
            _hashCode += getAgentCode().hashCode();
        }
        _hashCode += new Double(getAgentCommission()).hashCode();
        if (getAgentID() != null) {
            _hashCode += getAgentID().hashCode();
        }
        if (getAgentName() != null) {
            _hashCode += getAgentName().hashCode();
        }
        if (getBranchCode() != null) {
            _hashCode += getBranchCode().hashCode();
        }
        if (getBrokerReference() != null) {
            _hashCode += getBrokerReference().hashCode();
        }
        if (getCDNNumber() != null) {
            _hashCode += getCDNNumber().hashCode();
        }
        if (getCertificateNumber() != null) {
            _hashCode += getCertificateNumber().hashCode();
        }
        _hashCode += new Long(getCityId()).hashCode();
        if (getCurrency() != null) {
            _hashCode += getCurrency().hashCode();
        }
        if (getCurrentInsurancePeriod() != null) {
            _hashCode += getCurrentInsurancePeriod().hashCode();
        }
        if (getDebitCreditNoteNumber() != null) {
            _hashCode += getDebitCreditNoteNumber().hashCode();
        }
        if (getDebitCreditSign() != null) {
            _hashCode += getDebitCreditSign().hashCode();
        }
        _hashCode += (isDeleted() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getEffectiveDate() != null) {
            _hashCode += getEffectiveDate().hashCode();
        }
        if (getEntryDate() != null) {
            _hashCode += getEntryDate().hashCode();
        }
        if (getISTransmitStatus() != null) {
            _hashCode += getISTransmitStatus().hashCode();
        }
        if (getInceptionDate() != null) {
            _hashCode += getInceptionDate().hashCode();
        }
        _hashCode += new Long(getLgaId()).hashCode();
        if (getLinkDebitCreditNumber() != null) {
            _hashCode += getLinkDebitCreditNumber().hashCode();
        }
        if (getNameOfInsured() != null) {
            _hashCode += getNameOfInsured().hashCode();
        }
        if (getNarration() != null) {
            _hashCode += getNarration().hashCode();
        }
        _hashCode += new Double(getNetAmount()).hashCode();
        if (getPercentDistribution() != null) {
            _hashCode += getPercentDistribution().hashCode();
        }
        if (getPolicyNumber() != null) {
            _hashCode += getPolicyNumber().hashCode();
        }
        _hashCode += new Double(getPremiumAmount()).hashCode();
        if (getPreviousReference() != null) {
            _hashCode += getPreviousReference().hashCode();
        }
        _hashCode += getProrata();
        if (getReferenceNumber() != null) {
            _hashCode += getReferenceNumber().hashCode();
        }
        if (getScheduleGroup() != null) {
            _hashCode += getScheduleGroup().hashCode();
        }
        if (getStateCode() != null) {
            _hashCode += getStateCode().hashCode();
        }
        if (getSubsystem() != null) {
            _hashCode += getSubsystem().hashCode();
        }
        if (getTransactionCode() != null) {
            _hashCode += getTransactionCode().hashCode();
        }
        if (getTransactionDate() != null) {
            _hashCode += getTransactionDate().hashCode();
        }
        _hashCode += new Long(getTransactionLink()).hashCode();
        if (getTransactionMode() != null) {
            _hashCode += getTransactionMode().hashCode();
        }
        if (getTransactionSource() != null) {
            _hashCode += getTransactionSource().hashCode();
        }
        if (getTransactionType() != null) {
            _hashCode += getTransactionType().hashCode();
        }
        if (getUserName() != null) {
            _hashCode += getUserName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DebitCreditNote.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "debitCreditNote"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("address");
        elemField.setXmlName(new javax.xml.namespace.QName("", "address"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("agentCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "agentCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("agentCommission");
        elemField.setXmlName(new javax.xml.namespace.QName("", "agentCommission"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("agentID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "agentID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("agentName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "agentName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("branchCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "branchCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("brokerReference");
        elemField.setXmlName(new javax.xml.namespace.QName("", "brokerReference"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CDNNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CDNNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("certificateNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "certificateNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cityId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cityId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("currency");
        elemField.setXmlName(new javax.xml.namespace.QName("", "currency"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("currentInsurancePeriod");
        elemField.setXmlName(new javax.xml.namespace.QName("", "currentInsurancePeriod"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "currentInsurancePeriod"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("debitCreditNoteNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "debitCreditNoteNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("debitCreditSign");
        elemField.setXmlName(new javax.xml.namespace.QName("", "debitCreditSign"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deleted");
        elemField.setXmlName(new javax.xml.namespace.QName("", "deleted"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("effectiveDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "effectiveDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("entryDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "entryDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ISTransmitStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ISTransmitStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inceptionDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "inceptionDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lgaId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lgaId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("linkDebitCreditNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "linkDebitCreditNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nameOfInsured");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nameOfInsured"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("narration");
        elemField.setXmlName(new javax.xml.namespace.QName("", "narration"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("netAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "netAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("percentDistribution");
        elemField.setXmlName(new javax.xml.namespace.QName("", "percentDistribution"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("policyNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "policyNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("premiumAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "premiumAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("previousReference");
        elemField.setXmlName(new javax.xml.namespace.QName("", "previousReference"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prorata");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prorata"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referenceNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "referenceNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scheduleGroup");
        elemField.setXmlName(new javax.xml.namespace.QName("", "scheduleGroup"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stateCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stateCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subsystem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "subsystem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transactionCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "transactionCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transactionDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "transactionDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transactionLink");
        elemField.setXmlName(new javax.xml.namespace.QName("", "transactionLink"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transactionMode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "transactionMode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transactionSource");
        elemField.setXmlName(new javax.xml.namespace.QName("", "transactionSource"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transactionType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "transactionType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
