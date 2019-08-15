/**
 * IsPayment.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.leadway.projects.payment.endpoint;

public class IsPayment  extends com.leadway.projects.payment.endpoint.BasePayment  implements java.io.Serializable {
    private java.lang.String bankBranch;

    private java.lang.String bankName;

    private java.lang.String chequeNumber;

    private java.lang.String debitNoteNumber;

    private java.lang.String depositorName;

    private java.lang.String depositorPhone;

    private java.lang.String interswitchReferenceNumber;

    private java.lang.String leadwayReferenceNumber;

    private java.lang.String paymentType;

    private java.lang.String policyHolderName;

    private java.lang.String tellerDepositSlipNumber;

    private java.lang.String transactionDate;

    private java.util.Calendar valueDate;

    public IsPayment() {
    }

    public IsPayment(
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
           java.lang.String bankBranch,
           java.lang.String bankName,
           java.lang.String chequeNumber,
           java.lang.String debitNoteNumber,
           java.lang.String depositorName,
           java.lang.String depositorPhone,
           java.lang.String interswitchReferenceNumber,
           java.lang.String leadwayReferenceNumber,
           java.lang.String paymentType,
           java.lang.String policyHolderName,
           java.lang.String tellerDepositSlipNumber,
           java.lang.String transactionDate,
           java.util.Calendar valueDate) {
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
            transmitStatus);
        this.bankBranch = bankBranch;
        this.bankName = bankName;
        this.chequeNumber = chequeNumber;
        this.debitNoteNumber = debitNoteNumber;
        this.depositorName = depositorName;
        this.depositorPhone = depositorPhone;
        this.interswitchReferenceNumber = interswitchReferenceNumber;
        this.leadwayReferenceNumber = leadwayReferenceNumber;
        this.paymentType = paymentType;
        this.policyHolderName = policyHolderName;
        this.tellerDepositSlipNumber = tellerDepositSlipNumber;
        this.transactionDate = transactionDate;
        this.valueDate = valueDate;
    }


    /**
     * Gets the bankBranch value for this IsPayment.
     * 
     * @return bankBranch
     */
    public java.lang.String getBankBranch() {
        return bankBranch;
    }


    /**
     * Sets the bankBranch value for this IsPayment.
     * 
     * @param bankBranch
     */
    public void setBankBranch(java.lang.String bankBranch) {
        this.bankBranch = bankBranch;
    }


    /**
     * Gets the bankName value for this IsPayment.
     * 
     * @return bankName
     */
    public java.lang.String getBankName() {
        return bankName;
    }


    /**
     * Sets the bankName value for this IsPayment.
     * 
     * @param bankName
     */
    public void setBankName(java.lang.String bankName) {
        this.bankName = bankName;
    }


    /**
     * Gets the chequeNumber value for this IsPayment.
     * 
     * @return chequeNumber
     */
    public java.lang.String getChequeNumber() {
        return chequeNumber;
    }


    /**
     * Sets the chequeNumber value for this IsPayment.
     * 
     * @param chequeNumber
     */
    public void setChequeNumber(java.lang.String chequeNumber) {
        this.chequeNumber = chequeNumber;
    }


    /**
     * Gets the debitNoteNumber value for this IsPayment.
     * 
     * @return debitNoteNumber
     */
    public java.lang.String getDebitNoteNumber() {
        return debitNoteNumber;
    }


    /**
     * Sets the debitNoteNumber value for this IsPayment.
     * 
     * @param debitNoteNumber
     */
    public void setDebitNoteNumber(java.lang.String debitNoteNumber) {
        this.debitNoteNumber = debitNoteNumber;
    }


    /**
     * Gets the depositorName value for this IsPayment.
     * 
     * @return depositorName
     */
    public java.lang.String getDepositorName() {
        return depositorName;
    }


    /**
     * Sets the depositorName value for this IsPayment.
     * 
     * @param depositorName
     */
    public void setDepositorName(java.lang.String depositorName) {
        this.depositorName = depositorName;
    }


    /**
     * Gets the depositorPhone value for this IsPayment.
     * 
     * @return depositorPhone
     */
    public java.lang.String getDepositorPhone() {
        return depositorPhone;
    }


    /**
     * Sets the depositorPhone value for this IsPayment.
     * 
     * @param depositorPhone
     */
    public void setDepositorPhone(java.lang.String depositorPhone) {
        this.depositorPhone = depositorPhone;
    }


    /**
     * Gets the interswitchReferenceNumber value for this IsPayment.
     * 
     * @return interswitchReferenceNumber
     */
    public java.lang.String getInterswitchReferenceNumber() {
        return interswitchReferenceNumber;
    }


    /**
     * Sets the interswitchReferenceNumber value for this IsPayment.
     * 
     * @param interswitchReferenceNumber
     */
    public void setInterswitchReferenceNumber(java.lang.String interswitchReferenceNumber) {
        this.interswitchReferenceNumber = interswitchReferenceNumber;
    }


    /**
     * Gets the leadwayReferenceNumber value for this IsPayment.
     * 
     * @return leadwayReferenceNumber
     */
    public java.lang.String getLeadwayReferenceNumber() {
        return leadwayReferenceNumber;
    }


    /**
     * Sets the leadwayReferenceNumber value for this IsPayment.
     * 
     * @param leadwayReferenceNumber
     */
    public void setLeadwayReferenceNumber(java.lang.String leadwayReferenceNumber) {
        this.leadwayReferenceNumber = leadwayReferenceNumber;
    }


    /**
     * Gets the paymentType value for this IsPayment.
     * 
     * @return paymentType
     */
    public java.lang.String getPaymentType() {
        return paymentType;
    }


    /**
     * Sets the paymentType value for this IsPayment.
     * 
     * @param paymentType
     */
    public void setPaymentType(java.lang.String paymentType) {
        this.paymentType = paymentType;
    }


    /**
     * Gets the policyHolderName value for this IsPayment.
     * 
     * @return policyHolderName
     */
    public java.lang.String getPolicyHolderName() {
        return policyHolderName;
    }


    /**
     * Sets the policyHolderName value for this IsPayment.
     * 
     * @param policyHolderName
     */
    public void setPolicyHolderName(java.lang.String policyHolderName) {
        this.policyHolderName = policyHolderName;
    }


    /**
     * Gets the tellerDepositSlipNumber value for this IsPayment.
     * 
     * @return tellerDepositSlipNumber
     */
    public java.lang.String getTellerDepositSlipNumber() {
        return tellerDepositSlipNumber;
    }


    /**
     * Sets the tellerDepositSlipNumber value for this IsPayment.
     * 
     * @param tellerDepositSlipNumber
     */
    public void setTellerDepositSlipNumber(java.lang.String tellerDepositSlipNumber) {
        this.tellerDepositSlipNumber = tellerDepositSlipNumber;
    }


    /**
     * Gets the transactionDate value for this IsPayment.
     * 
     * @return transactionDate
     */
    public java.lang.String getTransactionDate() {
        return transactionDate;
    }


    /**
     * Sets the transactionDate value for this IsPayment.
     * 
     * @param transactionDate
     */
    public void setTransactionDate(java.lang.String transactionDate) {
        this.transactionDate = transactionDate;
    }


    /**
     * Gets the valueDate value for this IsPayment.
     * 
     * @return valueDate
     */
    public java.util.Calendar getValueDate() {
        return valueDate;
    }


    /**
     * Sets the valueDate value for this IsPayment.
     * 
     * @param valueDate
     */
    public void setValueDate(java.util.Calendar valueDate) {
        this.valueDate = valueDate;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IsPayment)) return false;
        IsPayment other = (IsPayment) obj;
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
            ((this.chequeNumber==null && other.getChequeNumber()==null) || 
             (this.chequeNumber!=null &&
              this.chequeNumber.equals(other.getChequeNumber()))) &&
            ((this.debitNoteNumber==null && other.getDebitNoteNumber()==null) || 
             (this.debitNoteNumber!=null &&
              this.debitNoteNumber.equals(other.getDebitNoteNumber()))) &&
            ((this.depositorName==null && other.getDepositorName()==null) || 
             (this.depositorName!=null &&
              this.depositorName.equals(other.getDepositorName()))) &&
            ((this.depositorPhone==null && other.getDepositorPhone()==null) || 
             (this.depositorPhone!=null &&
              this.depositorPhone.equals(other.getDepositorPhone()))) &&
            ((this.interswitchReferenceNumber==null && other.getInterswitchReferenceNumber()==null) || 
             (this.interswitchReferenceNumber!=null &&
              this.interswitchReferenceNumber.equals(other.getInterswitchReferenceNumber()))) &&
            ((this.leadwayReferenceNumber==null && other.getLeadwayReferenceNumber()==null) || 
             (this.leadwayReferenceNumber!=null &&
              this.leadwayReferenceNumber.equals(other.getLeadwayReferenceNumber()))) &&
            ((this.paymentType==null && other.getPaymentType()==null) || 
             (this.paymentType!=null &&
              this.paymentType.equals(other.getPaymentType()))) &&
            ((this.policyHolderName==null && other.getPolicyHolderName()==null) || 
             (this.policyHolderName!=null &&
              this.policyHolderName.equals(other.getPolicyHolderName()))) &&
            ((this.tellerDepositSlipNumber==null && other.getTellerDepositSlipNumber()==null) || 
             (this.tellerDepositSlipNumber!=null &&
              this.tellerDepositSlipNumber.equals(other.getTellerDepositSlipNumber()))) &&
            ((this.transactionDate==null && other.getTransactionDate()==null) || 
             (this.transactionDate!=null &&
              this.transactionDate.equals(other.getTransactionDate()))) &&
            ((this.valueDate==null && other.getValueDate()==null) || 
             (this.valueDate!=null &&
              this.valueDate.equals(other.getValueDate())));
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
        if (getChequeNumber() != null) {
            _hashCode += getChequeNumber().hashCode();
        }
        if (getDebitNoteNumber() != null) {
            _hashCode += getDebitNoteNumber().hashCode();
        }
        if (getDepositorName() != null) {
            _hashCode += getDepositorName().hashCode();
        }
        if (getDepositorPhone() != null) {
            _hashCode += getDepositorPhone().hashCode();
        }
        if (getInterswitchReferenceNumber() != null) {
            _hashCode += getInterswitchReferenceNumber().hashCode();
        }
        if (getLeadwayReferenceNumber() != null) {
            _hashCode += getLeadwayReferenceNumber().hashCode();
        }
        if (getPaymentType() != null) {
            _hashCode += getPaymentType().hashCode();
        }
        if (getPolicyHolderName() != null) {
            _hashCode += getPolicyHolderName().hashCode();
        }
        if (getTellerDepositSlipNumber() != null) {
            _hashCode += getTellerDepositSlipNumber().hashCode();
        }
        if (getTransactionDate() != null) {
            _hashCode += getTransactionDate().hashCode();
        }
        if (getValueDate() != null) {
            _hashCode += getValueDate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IsPayment.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "isPayment"));
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
        elemField.setFieldName("chequeNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "chequeNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("debitNoteNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "debitNoteNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("depositorName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "depositorName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("depositorPhone");
        elemField.setXmlName(new javax.xml.namespace.QName("", "depositorPhone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("interswitchReferenceNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "interswitchReferenceNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("leadwayReferenceNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "leadwayReferenceNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paymentType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "paymentType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("policyHolderName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "policyHolderName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tellerDepositSlipNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tellerDepositSlipNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transactionDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "transactionDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valueDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "valueDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
