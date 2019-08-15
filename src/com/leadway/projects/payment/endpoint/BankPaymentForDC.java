/**
 * BankPaymentForDC.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.leadway.projects.payment.endpoint;

public class BankPaymentForDC  extends com.leadway.projects.payment.endpoint.PaymentForDC  implements java.io.Serializable {
    private java.lang.String bankBranch;

    private java.lang.String bankName;

    private java.util.Calendar chequeDate;

    private java.lang.String chequeNumber;

    public BankPaymentForDC() {
    }

    public BankPaymentForDC(
           java.lang.String agentCode,
           java.math.BigDecimal amount,
           java.lang.String debitCreditSign,
           boolean deleted,
           java.lang.String denomination,
           java.lang.String IAS_transmitStatus,
           java.lang.String IS_transmitStatus,
           java.lang.String iasTranConfig,
           java.util.Calendar paymentDate,
           java.lang.String paymentMode,
           java.lang.String paymentSource,
           java.lang.String policyNumber,
           java.math.BigDecimal premiumDue,
           java.lang.String receiptNumber,
           boolean sealed,
           java.lang.String subsystem,
           java.util.Calendar timeStamp,
           java.lang.String transmitStatus,
           java.lang.String address1,
           java.lang.String address2,
           java.lang.String branchCode,
           double commissionAmount,
           java.lang.String debitCreditNumber,
           java.lang.String IAS_autoRef,
           java.lang.String narration,
           java.lang.String netIndicator,
           java.lang.String payer,
           java.lang.String staffNumber,
           java.lang.String tranTypeCode,
           java.lang.String bankBranch,
           java.lang.String bankName,
           java.util.Calendar chequeDate,
           java.lang.String chequeNumber) {
        super(
            agentCode,
            amount,
            debitCreditSign,
            deleted,
            denomination,
            IAS_transmitStatus,
            IS_transmitStatus,
            iasTranConfig,
            paymentDate,
            paymentMode,
            paymentSource,
            policyNumber,
            premiumDue,
            receiptNumber,
            sealed,
            subsystem,
            timeStamp,
            transmitStatus,
            address1,
            address2,
            branchCode,
            commissionAmount,
            debitCreditNumber,
            IAS_autoRef,
            narration,
            netIndicator,
            payer,
            staffNumber,
            tranTypeCode);
        this.bankBranch = bankBranch;
        this.bankName = bankName;
        this.chequeDate = chequeDate;
        this.chequeNumber = chequeNumber;
    }


    /**
     * Gets the bankBranch value for this BankPaymentForDC.
     * 
     * @return bankBranch
     */
    public java.lang.String getBankBranch() {
        return bankBranch;
    }


    /**
     * Sets the bankBranch value for this BankPaymentForDC.
     * 
     * @param bankBranch
     */
    public void setBankBranch(java.lang.String bankBranch) {
        this.bankBranch = bankBranch;
    }


    /**
     * Gets the bankName value for this BankPaymentForDC.
     * 
     * @return bankName
     */
    public java.lang.String getBankName() {
        return bankName;
    }


    /**
     * Sets the bankName value for this BankPaymentForDC.
     * 
     * @param bankName
     */
    public void setBankName(java.lang.String bankName) {
        this.bankName = bankName;
    }


    /**
     * Gets the chequeDate value for this BankPaymentForDC.
     * 
     * @return chequeDate
     */
    public java.util.Calendar getChequeDate() {
        return chequeDate;
    }


    /**
     * Sets the chequeDate value for this BankPaymentForDC.
     * 
     * @param chequeDate
     */
    public void setChequeDate(java.util.Calendar chequeDate) {
        this.chequeDate = chequeDate;
    }


    /**
     * Gets the chequeNumber value for this BankPaymentForDC.
     * 
     * @return chequeNumber
     */
    public java.lang.String getChequeNumber() {
        return chequeNumber;
    }


    /**
     * Sets the chequeNumber value for this BankPaymentForDC.
     * 
     * @param chequeNumber
     */
    public void setChequeNumber(java.lang.String chequeNumber) {
        this.chequeNumber = chequeNumber;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BankPaymentForDC)) return false;
        BankPaymentForDC other = (BankPaymentForDC) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.bankBranch==null && other.getBankBranch()==null) || 
             (this.bankBranch!=null &&
              this.bankBranch.equals(other.getBankBranch()))) &&
            ((this.bankName==null && other.getBankName()==null) || 
             (this.bankName!=null &&
              this.bankName.equals(other.getBankName()))) &&
            ((this.chequeDate==null && other.getChequeDate()==null) || 
             (this.chequeDate!=null &&
              this.chequeDate.equals(other.getChequeDate()))) &&
            ((this.chequeNumber==null && other.getChequeNumber()==null) || 
             (this.chequeNumber!=null &&
              this.chequeNumber.equals(other.getChequeNumber())));
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
        if (getBankBranch() != null) {
            _hashCode += getBankBranch().hashCode();
        }
        if (getBankName() != null) {
            _hashCode += getBankName().hashCode();
        }
        if (getChequeDate() != null) {
            _hashCode += getChequeDate().hashCode();
        }
        if (getChequeNumber() != null) {
            _hashCode += getChequeNumber().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BankPaymentForDC.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "bankPaymentForDC"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bankBranch");
        elemField.setXmlName(new javax.xml.namespace.QName("", "bankBranch"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bankName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "bankName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("chequeDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "chequeDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("chequeNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "chequeNumber"));
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
