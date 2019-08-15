/**
 * PfData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.leadway.pf.service.ws;

public class PfData  extends com.leadway.pf.service.ws.BusinessData  implements java.io.Serializable {
    private java.lang.String accountNumber;

    private java.lang.String agencyCode;

    private com.leadway.pf.service.ws.AgencyData agencyData;

    private java.util.Calendar approvalDate;

    private java.lang.String approvedBy;

    private java.lang.String bank;

    private java.util.Calendar bankConfirmDate;

    private java.lang.String bankConfirmRef;

    private java.lang.String bankSortCode;

    private java.lang.String branchCode;

    private java.lang.String calcRevisedPremium;

    private java.lang.String clientCode;

    private com.leadway.pf.service.ws.ClientData clientData;

    private java.math.BigDecimal commission;

    private java.util.Calendar debitNoteDate;

    private java.lang.String debitNoteNo;

    private java.math.BigDecimal depPremiumcommission;

    private java.lang.String depositPaymentMode;

    private java.lang.String depositPremiumIndicator;

    private java.math.BigDecimal depositPremiumMin;

    private java.math.BigDecimal depositPremiumPaid;

    private java.lang.String endorsementNumber;

    private java.lang.String errMsg;

    private java.util.Calendar firstRepaymentDate;

    private java.math.BigDecimal installPremium;

    private java.lang.Double interestRate;

    private java.lang.String manageMode;

    private java.lang.String paymentFrequency;

    private java.lang.String pfRefNo;

    private java.util.Calendar policyExpirationDate;

    private java.lang.String policyHolder;

    private java.lang.String policyNumber;

    private java.lang.Integer policyTenor;

    private java.math.BigDecimal premiumDue;

    private java.math.BigDecimal premiumFinanced;

    private java.lang.String premiumReceiptNo;

    private java.lang.String prevDDIndicator;

    private java.math.BigDecimal residualPremium;

    private java.lang.String riskClass;

    private java.lang.String riskClassCode;

    private java.lang.Integer riskItemCount;

    private java.lang.String subsystemCode;

    public PfData() {
    }

    public PfData(
           java.util.Calendar createDate,
           java.lang.String createdBy,
           boolean deleted,
           boolean editable,
           boolean selected,
           java.lang.String status,
           java.lang.String statusDesc,
           java.lang.Short version,
           java.lang.String accountNumber,
           java.lang.String agencyCode,
           com.leadway.pf.service.ws.AgencyData agencyData,
           java.util.Calendar approvalDate,
           java.lang.String approvedBy,
           java.lang.String bank,
           java.util.Calendar bankConfirmDate,
           java.lang.String bankConfirmRef,
           java.lang.String bankSortCode,
           java.lang.String branchCode,
           java.lang.String calcRevisedPremium,
           java.lang.String clientCode,
           com.leadway.pf.service.ws.ClientData clientData,
           java.math.BigDecimal commission,
           java.util.Calendar debitNoteDate,
           java.lang.String debitNoteNo,
           java.math.BigDecimal depPremiumcommission,
           java.lang.String depositPaymentMode,
           java.lang.String depositPremiumIndicator,
           java.math.BigDecimal depositPremiumMin,
           java.math.BigDecimal depositPremiumPaid,
           java.lang.String endorsementNumber,
           java.lang.String errMsg,
           java.util.Calendar firstRepaymentDate,
           java.math.BigDecimal installPremium,
           java.lang.Double interestRate,
           java.lang.String manageMode,
           java.lang.String paymentFrequency,
           java.lang.String pfRefNo,
           java.util.Calendar policyExpirationDate,
           java.lang.String policyHolder,
           java.lang.String policyNumber,
           java.lang.Integer policyTenor,
           java.math.BigDecimal premiumDue,
           java.math.BigDecimal premiumFinanced,
           java.lang.String premiumReceiptNo,
           java.lang.String prevDDIndicator,
           java.math.BigDecimal residualPremium,
           java.lang.String riskClass,
           java.lang.String riskClassCode,
           java.lang.Integer riskItemCount,
           java.lang.String subsystemCode) {
        super(
            createDate,
            createdBy,
            deleted,
            editable,
            selected,
            status,
            statusDesc,
            version);
        this.accountNumber = accountNumber;
        this.agencyCode = agencyCode;
        this.agencyData = agencyData;
        this.approvalDate = approvalDate;
        this.approvedBy = approvedBy;
        this.bank = bank;
        this.bankConfirmDate = bankConfirmDate;
        this.bankConfirmRef = bankConfirmRef;
        this.bankSortCode = bankSortCode;
        this.branchCode = branchCode;
        this.calcRevisedPremium = calcRevisedPremium;
        this.clientCode = clientCode;
        this.clientData = clientData;
        this.commission = commission;
        this.debitNoteDate = debitNoteDate;
        this.debitNoteNo = debitNoteNo;
        this.depPremiumcommission = depPremiumcommission;
        this.depositPaymentMode = depositPaymentMode;
        this.depositPremiumIndicator = depositPremiumIndicator;
        this.depositPremiumMin = depositPremiumMin;
        this.depositPremiumPaid = depositPremiumPaid;
        this.endorsementNumber = endorsementNumber;
        this.errMsg = errMsg;
        this.firstRepaymentDate = firstRepaymentDate;
        this.installPremium = installPremium;
        this.interestRate = interestRate;
        this.manageMode = manageMode;
        this.paymentFrequency = paymentFrequency;
        this.pfRefNo = pfRefNo;
        this.policyExpirationDate = policyExpirationDate;
        this.policyHolder = policyHolder;
        this.policyNumber = policyNumber;
        this.policyTenor = policyTenor;
        this.premiumDue = premiumDue;
        this.premiumFinanced = premiumFinanced;
        this.premiumReceiptNo = premiumReceiptNo;
        this.prevDDIndicator = prevDDIndicator;
        this.residualPremium = residualPremium;
        this.riskClass = riskClass;
        this.riskClassCode = riskClassCode;
        this.riskItemCount = riskItemCount;
        this.subsystemCode = subsystemCode;
    }


    /**
     * Gets the accountNumber value for this PfData.
     * 
     * @return accountNumber
     */
    public java.lang.String getAccountNumber() {
        return accountNumber;
    }


    /**
     * Sets the accountNumber value for this PfData.
     * 
     * @param accountNumber
     */
    public void setAccountNumber(java.lang.String accountNumber) {
        this.accountNumber = accountNumber;
    }


    /**
     * Gets the agencyCode value for this PfData.
     * 
     * @return agencyCode
     */
    public java.lang.String getAgencyCode() {
        return agencyCode;
    }


    /**
     * Sets the agencyCode value for this PfData.
     * 
     * @param agencyCode
     */
    public void setAgencyCode(java.lang.String agencyCode) {
        this.agencyCode = agencyCode;
    }


    /**
     * Gets the agencyData value for this PfData.
     * 
     * @return agencyData
     */
    public com.leadway.pf.service.ws.AgencyData getAgencyData() {
        return agencyData;
    }


    /**
     * Sets the agencyData value for this PfData.
     * 
     * @param agencyData
     */
    public void setAgencyData(com.leadway.pf.service.ws.AgencyData agencyData) {
        this.agencyData = agencyData;
    }


    /**
     * Gets the approvalDate value for this PfData.
     * 
     * @return approvalDate
     */
    public java.util.Calendar getApprovalDate() {
        return approvalDate;
    }


    /**
     * Sets the approvalDate value for this PfData.
     * 
     * @param approvalDate
     */
    public void setApprovalDate(java.util.Calendar approvalDate) {
        this.approvalDate = approvalDate;
    }


    /**
     * Gets the approvedBy value for this PfData.
     * 
     * @return approvedBy
     */
    public java.lang.String getApprovedBy() {
        return approvedBy;
    }


    /**
     * Sets the approvedBy value for this PfData.
     * 
     * @param approvedBy
     */
    public void setApprovedBy(java.lang.String approvedBy) {
        this.approvedBy = approvedBy;
    }


    /**
     * Gets the bank value for this PfData.
     * 
     * @return bank
     */
    public java.lang.String getBank() {
        return bank;
    }


    /**
     * Sets the bank value for this PfData.
     * 
     * @param bank
     */
    public void setBank(java.lang.String bank) {
        this.bank = bank;
    }


    /**
     * Gets the bankConfirmDate value for this PfData.
     * 
     * @return bankConfirmDate
     */
    public java.util.Calendar getBankConfirmDate() {
        return bankConfirmDate;
    }


    /**
     * Sets the bankConfirmDate value for this PfData.
     * 
     * @param bankConfirmDate
     */
    public void setBankConfirmDate(java.util.Calendar bankConfirmDate) {
        this.bankConfirmDate = bankConfirmDate;
    }


    /**
     * Gets the bankConfirmRef value for this PfData.
     * 
     * @return bankConfirmRef
     */
    public java.lang.String getBankConfirmRef() {
        return bankConfirmRef;
    }


    /**
     * Sets the bankConfirmRef value for this PfData.
     * 
     * @param bankConfirmRef
     */
    public void setBankConfirmRef(java.lang.String bankConfirmRef) {
        this.bankConfirmRef = bankConfirmRef;
    }


    /**
     * Gets the bankSortCode value for this PfData.
     * 
     * @return bankSortCode
     */
    public java.lang.String getBankSortCode() {
        return bankSortCode;
    }


    /**
     * Sets the bankSortCode value for this PfData.
     * 
     * @param bankSortCode
     */
    public void setBankSortCode(java.lang.String bankSortCode) {
        this.bankSortCode = bankSortCode;
    }


    /**
     * Gets the branchCode value for this PfData.
     * 
     * @return branchCode
     */
    public java.lang.String getBranchCode() {
        return branchCode;
    }


    /**
     * Sets the branchCode value for this PfData.
     * 
     * @param branchCode
     */
    public void setBranchCode(java.lang.String branchCode) {
        this.branchCode = branchCode;
    }


    /**
     * Gets the calcRevisedPremium value for this PfData.
     * 
     * @return calcRevisedPremium
     */
    public java.lang.String getCalcRevisedPremium() {
        return calcRevisedPremium;
    }


    /**
     * Sets the calcRevisedPremium value for this PfData.
     * 
     * @param calcRevisedPremium
     */
    public void setCalcRevisedPremium(java.lang.String calcRevisedPremium) {
        this.calcRevisedPremium = calcRevisedPremium;
    }


    /**
     * Gets the clientCode value for this PfData.
     * 
     * @return clientCode
     */
    public java.lang.String getClientCode() {
        return clientCode;
    }


    /**
     * Sets the clientCode value for this PfData.
     * 
     * @param clientCode
     */
    public void setClientCode(java.lang.String clientCode) {
        this.clientCode = clientCode;
    }


    /**
     * Gets the clientData value for this PfData.
     * 
     * @return clientData
     */
    public com.leadway.pf.service.ws.ClientData getClientData() {
        return clientData;
    }


    /**
     * Sets the clientData value for this PfData.
     * 
     * @param clientData
     */
    public void setClientData(com.leadway.pf.service.ws.ClientData clientData) {
        this.clientData = clientData;
    }


    /**
     * Gets the commission value for this PfData.
     * 
     * @return commission
     */
    public java.math.BigDecimal getCommission() {
        return commission;
    }


    /**
     * Sets the commission value for this PfData.
     * 
     * @param commission
     */
    public void setCommission(java.math.BigDecimal commission) {
        this.commission = commission;
    }


    /**
     * Gets the debitNoteDate value for this PfData.
     * 
     * @return debitNoteDate
     */
    public java.util.Calendar getDebitNoteDate() {
        return debitNoteDate;
    }


    /**
     * Sets the debitNoteDate value for this PfData.
     * 
     * @param debitNoteDate
     */
    public void setDebitNoteDate(java.util.Calendar debitNoteDate) {
        this.debitNoteDate = debitNoteDate;
    }


    /**
     * Gets the debitNoteNo value for this PfData.
     * 
     * @return debitNoteNo
     */
    public java.lang.String getDebitNoteNo() {
        return debitNoteNo;
    }


    /**
     * Sets the debitNoteNo value for this PfData.
     * 
     * @param debitNoteNo
     */
    public void setDebitNoteNo(java.lang.String debitNoteNo) {
        this.debitNoteNo = debitNoteNo;
    }


    /**
     * Gets the depPremiumcommission value for this PfData.
     * 
     * @return depPremiumcommission
     */
    public java.math.BigDecimal getDepPremiumcommission() {
        return depPremiumcommission;
    }


    /**
     * Sets the depPremiumcommission value for this PfData.
     * 
     * @param depPremiumcommission
     */
    public void setDepPremiumcommission(java.math.BigDecimal depPremiumcommission) {
        this.depPremiumcommission = depPremiumcommission;
    }


    /**
     * Gets the depositPaymentMode value for this PfData.
     * 
     * @return depositPaymentMode
     */
    public java.lang.String getDepositPaymentMode() {
        return depositPaymentMode;
    }


    /**
     * Sets the depositPaymentMode value for this PfData.
     * 
     * @param depositPaymentMode
     */
    public void setDepositPaymentMode(java.lang.String depositPaymentMode) {
        this.depositPaymentMode = depositPaymentMode;
    }


    /**
     * Gets the depositPremiumIndicator value for this PfData.
     * 
     * @return depositPremiumIndicator
     */
    public java.lang.String getDepositPremiumIndicator() {
        return depositPremiumIndicator;
    }


    /**
     * Sets the depositPremiumIndicator value for this PfData.
     * 
     * @param depositPremiumIndicator
     */
    public void setDepositPremiumIndicator(java.lang.String depositPremiumIndicator) {
        this.depositPremiumIndicator = depositPremiumIndicator;
    }


    /**
     * Gets the depositPremiumMin value for this PfData.
     * 
     * @return depositPremiumMin
     */
    public java.math.BigDecimal getDepositPremiumMin() {
        return depositPremiumMin;
    }


    /**
     * Sets the depositPremiumMin value for this PfData.
     * 
     * @param depositPremiumMin
     */
    public void setDepositPremiumMin(java.math.BigDecimal depositPremiumMin) {
        this.depositPremiumMin = depositPremiumMin;
    }


    /**
     * Gets the depositPremiumPaid value for this PfData.
     * 
     * @return depositPremiumPaid
     */
    public java.math.BigDecimal getDepositPremiumPaid() {
        return depositPremiumPaid;
    }


    /**
     * Sets the depositPremiumPaid value for this PfData.
     * 
     * @param depositPremiumPaid
     */
    public void setDepositPremiumPaid(java.math.BigDecimal depositPremiumPaid) {
        this.depositPremiumPaid = depositPremiumPaid;
    }


    /**
     * Gets the endorsementNumber value for this PfData.
     * 
     * @return endorsementNumber
     */
    public java.lang.String getEndorsementNumber() {
        return endorsementNumber;
    }


    /**
     * Sets the endorsementNumber value for this PfData.
     * 
     * @param endorsementNumber
     */
    public void setEndorsementNumber(java.lang.String endorsementNumber) {
        this.endorsementNumber = endorsementNumber;
    }


    /**
     * Gets the errMsg value for this PfData.
     * 
     * @return errMsg
     */
    public java.lang.String getErrMsg() {
        return errMsg;
    }


    /**
     * Sets the errMsg value for this PfData.
     * 
     * @param errMsg
     */
    public void setErrMsg(java.lang.String errMsg) {
        this.errMsg = errMsg;
    }


    /**
     * Gets the firstRepaymentDate value for this PfData.
     * 
     * @return firstRepaymentDate
     */
    public java.util.Calendar getFirstRepaymentDate() {
        return firstRepaymentDate;
    }


    /**
     * Sets the firstRepaymentDate value for this PfData.
     * 
     * @param firstRepaymentDate
     */
    public void setFirstRepaymentDate(java.util.Calendar firstRepaymentDate) {
        this.firstRepaymentDate = firstRepaymentDate;
    }


    /**
     * Gets the installPremium value for this PfData.
     * 
     * @return installPremium
     */
    public java.math.BigDecimal getInstallPremium() {
        return installPremium;
    }


    /**
     * Sets the installPremium value for this PfData.
     * 
     * @param installPremium
     */
    public void setInstallPremium(java.math.BigDecimal installPremium) {
        this.installPremium = installPremium;
    }


    /**
     * Gets the interestRate value for this PfData.
     * 
     * @return interestRate
     */
    public java.lang.Double getInterestRate() {
        return interestRate;
    }


    /**
     * Sets the interestRate value for this PfData.
     * 
     * @param interestRate
     */
    public void setInterestRate(java.lang.Double interestRate) {
        this.interestRate = interestRate;
    }


    /**
     * Gets the manageMode value for this PfData.
     * 
     * @return manageMode
     */
    public java.lang.String getManageMode() {
        return manageMode;
    }


    /**
     * Sets the manageMode value for this PfData.
     * 
     * @param manageMode
     */
    public void setManageMode(java.lang.String manageMode) {
        this.manageMode = manageMode;
    }


    /**
     * Gets the paymentFrequency value for this PfData.
     * 
     * @return paymentFrequency
     */
    public java.lang.String getPaymentFrequency() {
        return paymentFrequency;
    }


    /**
     * Sets the paymentFrequency value for this PfData.
     * 
     * @param paymentFrequency
     */
    public void setPaymentFrequency(java.lang.String paymentFrequency) {
        this.paymentFrequency = paymentFrequency;
    }


    /**
     * Gets the pfRefNo value for this PfData.
     * 
     * @return pfRefNo
     */
    public java.lang.String getPfRefNo() {
        return pfRefNo;
    }


    /**
     * Sets the pfRefNo value for this PfData.
     * 
     * @param pfRefNo
     */
    public void setPfRefNo(java.lang.String pfRefNo) {
        this.pfRefNo = pfRefNo;
    }


    /**
     * Gets the policyExpirationDate value for this PfData.
     * 
     * @return policyExpirationDate
     */
    public java.util.Calendar getPolicyExpirationDate() {
        return policyExpirationDate;
    }


    /**
     * Sets the policyExpirationDate value for this PfData.
     * 
     * @param policyExpirationDate
     */
    public void setPolicyExpirationDate(java.util.Calendar policyExpirationDate) {
        this.policyExpirationDate = policyExpirationDate;
    }


    /**
     * Gets the policyHolder value for this PfData.
     * 
     * @return policyHolder
     */
    public java.lang.String getPolicyHolder() {
        return policyHolder;
    }


    /**
     * Sets the policyHolder value for this PfData.
     * 
     * @param policyHolder
     */
    public void setPolicyHolder(java.lang.String policyHolder) {
        this.policyHolder = policyHolder;
    }


    /**
     * Gets the policyNumber value for this PfData.
     * 
     * @return policyNumber
     */
    public java.lang.String getPolicyNumber() {
        return policyNumber;
    }


    /**
     * Sets the policyNumber value for this PfData.
     * 
     * @param policyNumber
     */
    public void setPolicyNumber(java.lang.String policyNumber) {
        this.policyNumber = policyNumber;
    }


    /**
     * Gets the policyTenor value for this PfData.
     * 
     * @return policyTenor
     */
    public java.lang.Integer getPolicyTenor() {
        return policyTenor;
    }


    /**
     * Sets the policyTenor value for this PfData.
     * 
     * @param policyTenor
     */
    public void setPolicyTenor(java.lang.Integer policyTenor) {
        this.policyTenor = policyTenor;
    }


    /**
     * Gets the premiumDue value for this PfData.
     * 
     * @return premiumDue
     */
    public java.math.BigDecimal getPremiumDue() {
        return premiumDue;
    }


    /**
     * Sets the premiumDue value for this PfData.
     * 
     * @param premiumDue
     */
    public void setPremiumDue(java.math.BigDecimal premiumDue) {
        this.premiumDue = premiumDue;
    }


    /**
     * Gets the premiumFinanced value for this PfData.
     * 
     * @return premiumFinanced
     */
    public java.math.BigDecimal getPremiumFinanced() {
        return premiumFinanced;
    }


    /**
     * Sets the premiumFinanced value for this PfData.
     * 
     * @param premiumFinanced
     */
    public void setPremiumFinanced(java.math.BigDecimal premiumFinanced) {
        this.premiumFinanced = premiumFinanced;
    }


    /**
     * Gets the premiumReceiptNo value for this PfData.
     * 
     * @return premiumReceiptNo
     */
    public java.lang.String getPremiumReceiptNo() {
        return premiumReceiptNo;
    }


    /**
     * Sets the premiumReceiptNo value for this PfData.
     * 
     * @param premiumReceiptNo
     */
    public void setPremiumReceiptNo(java.lang.String premiumReceiptNo) {
        this.premiumReceiptNo = premiumReceiptNo;
    }


    /**
     * Gets the prevDDIndicator value for this PfData.
     * 
     * @return prevDDIndicator
     */
    public java.lang.String getPrevDDIndicator() {
        return prevDDIndicator;
    }


    /**
     * Sets the prevDDIndicator value for this PfData.
     * 
     * @param prevDDIndicator
     */
    public void setPrevDDIndicator(java.lang.String prevDDIndicator) {
        this.prevDDIndicator = prevDDIndicator;
    }


    /**
     * Gets the residualPremium value for this PfData.
     * 
     * @return residualPremium
     */
    public java.math.BigDecimal getResidualPremium() {
        return residualPremium;
    }


    /**
     * Sets the residualPremium value for this PfData.
     * 
     * @param residualPremium
     */
    public void setResidualPremium(java.math.BigDecimal residualPremium) {
        this.residualPremium = residualPremium;
    }


    /**
     * Gets the riskClass value for this PfData.
     * 
     * @return riskClass
     */
    public java.lang.String getRiskClass() {
        return riskClass;
    }


    /**
     * Sets the riskClass value for this PfData.
     * 
     * @param riskClass
     */
    public void setRiskClass(java.lang.String riskClass) {
        this.riskClass = riskClass;
    }


    /**
     * Gets the riskClassCode value for this PfData.
     * 
     * @return riskClassCode
     */
    public java.lang.String getRiskClassCode() {
        return riskClassCode;
    }


    /**
     * Sets the riskClassCode value for this PfData.
     * 
     * @param riskClassCode
     */
    public void setRiskClassCode(java.lang.String riskClassCode) {
        this.riskClassCode = riskClassCode;
    }


    /**
     * Gets the riskItemCount value for this PfData.
     * 
     * @return riskItemCount
     */
    public java.lang.Integer getRiskItemCount() {
        return riskItemCount;
    }


    /**
     * Sets the riskItemCount value for this PfData.
     * 
     * @param riskItemCount
     */
    public void setRiskItemCount(java.lang.Integer riskItemCount) {
        this.riskItemCount = riskItemCount;
    }


    /**
     * Gets the subsystemCode value for this PfData.
     * 
     * @return subsystemCode
     */
    public java.lang.String getSubsystemCode() {
        return subsystemCode;
    }


    /**
     * Sets the subsystemCode value for this PfData.
     * 
     * @param subsystemCode
     */
    public void setSubsystemCode(java.lang.String subsystemCode) {
        this.subsystemCode = subsystemCode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PfData)) return false;
        PfData other = (PfData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.accountNumber==null && other.getAccountNumber()==null) || 
             (this.accountNumber!=null &&
              this.accountNumber.equals(other.getAccountNumber()))) &&
            ((this.agencyCode==null && other.getAgencyCode()==null) || 
             (this.agencyCode!=null &&
              this.agencyCode.equals(other.getAgencyCode()))) &&
            ((this.agencyData==null && other.getAgencyData()==null) || 
             (this.agencyData!=null &&
              this.agencyData.equals(other.getAgencyData()))) &&
            ((this.approvalDate==null && other.getApprovalDate()==null) || 
             (this.approvalDate!=null &&
              this.approvalDate.equals(other.getApprovalDate()))) &&
            ((this.approvedBy==null && other.getApprovedBy()==null) || 
             (this.approvedBy!=null &&
              this.approvedBy.equals(other.getApprovedBy()))) &&
            ((this.bank==null && other.getBank()==null) || 
             (this.bank!=null &&
              this.bank.equals(other.getBank()))) &&
            ((this.bankConfirmDate==null && other.getBankConfirmDate()==null) || 
             (this.bankConfirmDate!=null &&
              this.bankConfirmDate.equals(other.getBankConfirmDate()))) &&
            ((this.bankConfirmRef==null && other.getBankConfirmRef()==null) || 
             (this.bankConfirmRef!=null &&
              this.bankConfirmRef.equals(other.getBankConfirmRef()))) &&
            ((this.bankSortCode==null && other.getBankSortCode()==null) || 
             (this.bankSortCode!=null &&
              this.bankSortCode.equals(other.getBankSortCode()))) &&
            ((this.branchCode==null && other.getBranchCode()==null) || 
             (this.branchCode!=null &&
              this.branchCode.equals(other.getBranchCode()))) &&
            ((this.calcRevisedPremium==null && other.getCalcRevisedPremium()==null) || 
             (this.calcRevisedPremium!=null &&
              this.calcRevisedPremium.equals(other.getCalcRevisedPremium()))) &&
            ((this.clientCode==null && other.getClientCode()==null) || 
             (this.clientCode!=null &&
              this.clientCode.equals(other.getClientCode()))) &&
            ((this.clientData==null && other.getClientData()==null) || 
             (this.clientData!=null &&
              this.clientData.equals(other.getClientData()))) &&
            ((this.commission==null && other.getCommission()==null) || 
             (this.commission!=null &&
              this.commission.equals(other.getCommission()))) &&
            ((this.debitNoteDate==null && other.getDebitNoteDate()==null) || 
             (this.debitNoteDate!=null &&
              this.debitNoteDate.equals(other.getDebitNoteDate()))) &&
            ((this.debitNoteNo==null && other.getDebitNoteNo()==null) || 
             (this.debitNoteNo!=null &&
              this.debitNoteNo.equals(other.getDebitNoteNo()))) &&
            ((this.depPremiumcommission==null && other.getDepPremiumcommission()==null) || 
             (this.depPremiumcommission!=null &&
              this.depPremiumcommission.equals(other.getDepPremiumcommission()))) &&
            ((this.depositPaymentMode==null && other.getDepositPaymentMode()==null) || 
             (this.depositPaymentMode!=null &&
              this.depositPaymentMode.equals(other.getDepositPaymentMode()))) &&
            ((this.depositPremiumIndicator==null && other.getDepositPremiumIndicator()==null) || 
             (this.depositPremiumIndicator!=null &&
              this.depositPremiumIndicator.equals(other.getDepositPremiumIndicator()))) &&
            ((this.depositPremiumMin==null && other.getDepositPremiumMin()==null) || 
             (this.depositPremiumMin!=null &&
              this.depositPremiumMin.equals(other.getDepositPremiumMin()))) &&
            ((this.depositPremiumPaid==null && other.getDepositPremiumPaid()==null) || 
             (this.depositPremiumPaid!=null &&
              this.depositPremiumPaid.equals(other.getDepositPremiumPaid()))) &&
            ((this.endorsementNumber==null && other.getEndorsementNumber()==null) || 
             (this.endorsementNumber!=null &&
              this.endorsementNumber.equals(other.getEndorsementNumber()))) &&
            ((this.errMsg==null && other.getErrMsg()==null) || 
             (this.errMsg!=null &&
              this.errMsg.equals(other.getErrMsg()))) &&
            ((this.firstRepaymentDate==null && other.getFirstRepaymentDate()==null) || 
             (this.firstRepaymentDate!=null &&
              this.firstRepaymentDate.equals(other.getFirstRepaymentDate()))) &&
            ((this.installPremium==null && other.getInstallPremium()==null) || 
             (this.installPremium!=null &&
              this.installPremium.equals(other.getInstallPremium()))) &&
            ((this.interestRate==null && other.getInterestRate()==null) || 
             (this.interestRate!=null &&
              this.interestRate.equals(other.getInterestRate()))) &&
            ((this.manageMode==null && other.getManageMode()==null) || 
             (this.manageMode!=null &&
              this.manageMode.equals(other.getManageMode()))) &&
            ((this.paymentFrequency==null && other.getPaymentFrequency()==null) || 
             (this.paymentFrequency!=null &&
              this.paymentFrequency.equals(other.getPaymentFrequency()))) &&
            ((this.pfRefNo==null && other.getPfRefNo()==null) || 
             (this.pfRefNo!=null &&
              this.pfRefNo.equals(other.getPfRefNo()))) &&
            ((this.policyExpirationDate==null && other.getPolicyExpirationDate()==null) || 
             (this.policyExpirationDate!=null &&
              this.policyExpirationDate.equals(other.getPolicyExpirationDate()))) &&
            ((this.policyHolder==null && other.getPolicyHolder()==null) || 
             (this.policyHolder!=null &&
              this.policyHolder.equals(other.getPolicyHolder()))) &&
            ((this.policyNumber==null && other.getPolicyNumber()==null) || 
             (this.policyNumber!=null &&
              this.policyNumber.equals(other.getPolicyNumber()))) &&
            ((this.policyTenor==null && other.getPolicyTenor()==null) || 
             (this.policyTenor!=null &&
              this.policyTenor.equals(other.getPolicyTenor()))) &&
            ((this.premiumDue==null && other.getPremiumDue()==null) || 
             (this.premiumDue!=null &&
              this.premiumDue.equals(other.getPremiumDue()))) &&
            ((this.premiumFinanced==null && other.getPremiumFinanced()==null) || 
             (this.premiumFinanced!=null &&
              this.premiumFinanced.equals(other.getPremiumFinanced()))) &&
            ((this.premiumReceiptNo==null && other.getPremiumReceiptNo()==null) || 
             (this.premiumReceiptNo!=null &&
              this.premiumReceiptNo.equals(other.getPremiumReceiptNo()))) &&
            ((this.prevDDIndicator==null && other.getPrevDDIndicator()==null) || 
             (this.prevDDIndicator!=null &&
              this.prevDDIndicator.equals(other.getPrevDDIndicator()))) &&
            ((this.residualPremium==null && other.getResidualPremium()==null) || 
             (this.residualPremium!=null &&
              this.residualPremium.equals(other.getResidualPremium()))) &&
            ((this.riskClass==null && other.getRiskClass()==null) || 
             (this.riskClass!=null &&
              this.riskClass.equals(other.getRiskClass()))) &&
            ((this.riskClassCode==null && other.getRiskClassCode()==null) || 
             (this.riskClassCode!=null &&
              this.riskClassCode.equals(other.getRiskClassCode()))) &&
            ((this.riskItemCount==null && other.getRiskItemCount()==null) || 
             (this.riskItemCount!=null &&
              this.riskItemCount.equals(other.getRiskItemCount()))) &&
            ((this.subsystemCode==null && other.getSubsystemCode()==null) || 
             (this.subsystemCode!=null &&
              this.subsystemCode.equals(other.getSubsystemCode())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getAccountNumber() != null) {
            _hashCode += getAccountNumber().hashCode();
        }
        if (getAgencyCode() != null) {
            _hashCode += getAgencyCode().hashCode();
        }
        if (getAgencyData() != null) {
            _hashCode += getAgencyData().hashCode();
        }
        if (getApprovalDate() != null) {
            _hashCode += getApprovalDate().hashCode();
        }
        if (getApprovedBy() != null) {
            _hashCode += getApprovedBy().hashCode();
        }
        if (getBank() != null) {
            _hashCode += getBank().hashCode();
        }
        if (getBankConfirmDate() != null) {
            _hashCode += getBankConfirmDate().hashCode();
        }
        if (getBankConfirmRef() != null) {
            _hashCode += getBankConfirmRef().hashCode();
        }
        if (getBankSortCode() != null) {
            _hashCode += getBankSortCode().hashCode();
        }
        if (getBranchCode() != null) {
            _hashCode += getBranchCode().hashCode();
        }
        if (getCalcRevisedPremium() != null) {
            _hashCode += getCalcRevisedPremium().hashCode();
        }
        if (getClientCode() != null) {
            _hashCode += getClientCode().hashCode();
        }
        if (getClientData() != null) {
            _hashCode += getClientData().hashCode();
        }
        if (getCommission() != null) {
            _hashCode += getCommission().hashCode();
        }
        if (getDebitNoteDate() != null) {
            _hashCode += getDebitNoteDate().hashCode();
        }
        if (getDebitNoteNo() != null) {
            _hashCode += getDebitNoteNo().hashCode();
        }
        if (getDepPremiumcommission() != null) {
            _hashCode += getDepPremiumcommission().hashCode();
        }
        if (getDepositPaymentMode() != null) {
            _hashCode += getDepositPaymentMode().hashCode();
        }
        if (getDepositPremiumIndicator() != null) {
            _hashCode += getDepositPremiumIndicator().hashCode();
        }
        if (getDepositPremiumMin() != null) {
            _hashCode += getDepositPremiumMin().hashCode();
        }
        if (getDepositPremiumPaid() != null) {
            _hashCode += getDepositPremiumPaid().hashCode();
        }
        if (getEndorsementNumber() != null) {
            _hashCode += getEndorsementNumber().hashCode();
        }
        if (getErrMsg() != null) {
            _hashCode += getErrMsg().hashCode();
        }
        if (getFirstRepaymentDate() != null) {
            _hashCode += getFirstRepaymentDate().hashCode();
        }
        if (getInstallPremium() != null) {
            _hashCode += getInstallPremium().hashCode();
        }
        if (getInterestRate() != null) {
            _hashCode += getInterestRate().hashCode();
        }
        if (getManageMode() != null) {
            _hashCode += getManageMode().hashCode();
        }
        if (getPaymentFrequency() != null) {
            _hashCode += getPaymentFrequency().hashCode();
        }
        if (getPfRefNo() != null) {
            _hashCode += getPfRefNo().hashCode();
        }
        if (getPolicyExpirationDate() != null) {
            _hashCode += getPolicyExpirationDate().hashCode();
        }
        if (getPolicyHolder() != null) {
            _hashCode += getPolicyHolder().hashCode();
        }
        if (getPolicyNumber() != null) {
            _hashCode += getPolicyNumber().hashCode();
        }
        if (getPolicyTenor() != null) {
            _hashCode += getPolicyTenor().hashCode();
        }
        if (getPremiumDue() != null) {
            _hashCode += getPremiumDue().hashCode();
        }
        if (getPremiumFinanced() != null) {
            _hashCode += getPremiumFinanced().hashCode();
        }
        if (getPremiumReceiptNo() != null) {
            _hashCode += getPremiumReceiptNo().hashCode();
        }
        if (getPrevDDIndicator() != null) {
            _hashCode += getPrevDDIndicator().hashCode();
        }
        if (getResidualPremium() != null) {
            _hashCode += getResidualPremium().hashCode();
        }
        if (getRiskClass() != null) {
            _hashCode += getRiskClass().hashCode();
        }
        if (getRiskClassCode() != null) {
            _hashCode += getRiskClassCode().hashCode();
        }
        if (getRiskItemCount() != null) {
            _hashCode += getRiskItemCount().hashCode();
        }
        if (getSubsystemCode() != null) {
            _hashCode += getSubsystemCode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PfData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.service.pf.leadway.com/", "pfData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accountNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "accountNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("agencyCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "agencyCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("agencyData");
        elemField.setXmlName(new javax.xml.namespace.QName("", "agencyData"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.service.pf.leadway.com/", "agencyData"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("approvalDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "approvalDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("approvedBy");
        elemField.setXmlName(new javax.xml.namespace.QName("", "approvedBy"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bank");
        elemField.setXmlName(new javax.xml.namespace.QName("", "bank"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bankConfirmDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "bankConfirmDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bankConfirmRef");
        elemField.setXmlName(new javax.xml.namespace.QName("", "bankConfirmRef"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bankSortCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "bankSortCode"));
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
        elemField.setFieldName("calcRevisedPremium");
        elemField.setXmlName(new javax.xml.namespace.QName("", "calcRevisedPremium"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clientCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "clientCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clientData");
        elemField.setXmlName(new javax.xml.namespace.QName("", "clientData"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.service.pf.leadway.com/", "clientData"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("commission");
        elemField.setXmlName(new javax.xml.namespace.QName("", "commission"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("debitNoteDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "debitNoteDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("debitNoteNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "debitNoteNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("depPremiumcommission");
        elemField.setXmlName(new javax.xml.namespace.QName("", "depPremiumcommission"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("depositPaymentMode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "depositPaymentMode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("depositPremiumIndicator");
        elemField.setXmlName(new javax.xml.namespace.QName("", "depositPremiumIndicator"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("depositPremiumMin");
        elemField.setXmlName(new javax.xml.namespace.QName("", "depositPremiumMin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("depositPremiumPaid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "depositPremiumPaid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endorsementNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "endorsementNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errMsg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "errMsg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("firstRepaymentDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "firstRepaymentDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("installPremium");
        elemField.setXmlName(new javax.xml.namespace.QName("", "installPremium"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("interestRate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "interestRate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("manageMode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "manageMode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paymentFrequency");
        elemField.setXmlName(new javax.xml.namespace.QName("", "paymentFrequency"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pfRefNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pfRefNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("policyExpirationDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "policyExpirationDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("policyHolder");
        elemField.setXmlName(new javax.xml.namespace.QName("", "policyHolder"));
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
        elemField.setFieldName("policyTenor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "policyTenor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("premiumDue");
        elemField.setXmlName(new javax.xml.namespace.QName("", "premiumDue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("premiumFinanced");
        elemField.setXmlName(new javax.xml.namespace.QName("", "premiumFinanced"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("premiumReceiptNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "premiumReceiptNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prevDDIndicator");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prevDDIndicator"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("residualPremium");
        elemField.setXmlName(new javax.xml.namespace.QName("", "residualPremium"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("riskClass");
        elemField.setXmlName(new javax.xml.namespace.QName("", "riskClass"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("riskClassCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "riskClassCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("riskItemCount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "riskItemCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subsystemCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "subsystemCode"));
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
