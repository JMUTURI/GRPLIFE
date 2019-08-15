/**
 * BasePayment.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.leadway.projects.payment.endpoint;

public class BasePayment  implements java.io.Serializable {
    private java.lang.String agentCode;

    private java.math.BigDecimal amount;

    private java.lang.String debitCreditSign;

    private boolean deleted;

    private java.lang.String denomination;

    private java.lang.String IAS_transmitStatus;

    private java.lang.String IS_transmitStatus;

    private java.lang.String iasTranConfig;

    private java.util.Calendar paymentDate;

    private java.lang.String paymentMode;

    private java.lang.String paymentSource;

    private java.lang.String policyNumber;

    private java.math.BigDecimal premiumDue;

    private java.lang.String receiptNumber;

    private boolean sealed;

    private java.lang.String subsystem;

    private java.util.Calendar timeStamp;

    private java.lang.String transmitStatus;

    public BasePayment() {
    }

    public BasePayment(
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
           java.lang.String transmitStatus) {
           this.agentCode = agentCode;
           this.amount = amount;
           this.debitCreditSign = debitCreditSign;
           this.deleted = deleted;
           this.denomination = denomination;
           this.IAS_transmitStatus = IAS_transmitStatus;
           this.IS_transmitStatus = IS_transmitStatus;
           this.iasTranConfig = iasTranConfig;
           this.paymentDate = paymentDate;
           this.paymentMode = paymentMode;
           this.paymentSource = paymentSource;
           this.policyNumber = policyNumber;
           this.premiumDue = premiumDue;
           this.receiptNumber = receiptNumber;
           this.sealed = sealed;
           this.subsystem = subsystem;
           this.timeStamp = timeStamp;
           this.transmitStatus = transmitStatus;
    }


    /**
     * Gets the agentCode value for this BasePayment.
     * 
     * @return agentCode
     */
    public java.lang.String getAgentCode() {
        return agentCode;
    }


    /**
     * Sets the agentCode value for this BasePayment.
     * 
     * @param agentCode
     */
    public void setAgentCode(java.lang.String agentCode) {
        this.agentCode = agentCode;
    }


    /**
     * Gets the amount value for this BasePayment.
     * 
     * @return amount
     */
    public java.math.BigDecimal getAmount() {
        return amount;
    }


    /**
     * Sets the amount value for this BasePayment.
     * 
     * @param amount
     */
    public void setAmount(java.math.BigDecimal amount) {
        this.amount = amount;
    }


    /**
     * Gets the debitCreditSign value for this BasePayment.
     * 
     * @return debitCreditSign
     */
    public java.lang.String getDebitCreditSign() {
        return debitCreditSign;
    }


    /**
     * Sets the debitCreditSign value for this BasePayment.
     * 
     * @param debitCreditSign
     */
    public void setDebitCreditSign(java.lang.String debitCreditSign) {
        this.debitCreditSign = debitCreditSign;
    }


    /**
     * Gets the deleted value for this BasePayment.
     * 
     * @return deleted
     */
    public boolean isDeleted() {
        return deleted;
    }


    /**
     * Sets the deleted value for this BasePayment.
     * 
     * @param deleted
     */
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }


    /**
     * Gets the denomination value for this BasePayment.
     * 
     * @return denomination
     */
    public java.lang.String getDenomination() {
        return denomination;
    }


    /**
     * Sets the denomination value for this BasePayment.
     * 
     * @param denomination
     */
    public void setDenomination(java.lang.String denomination) {
        this.denomination = denomination;
    }


    /**
     * Gets the IAS_transmitStatus value for this BasePayment.
     * 
     * @return IAS_transmitStatus
     */
    public java.lang.String getIAS_transmitStatus() {
        return IAS_transmitStatus;
    }


    /**
     * Sets the IAS_transmitStatus value for this BasePayment.
     * 
     * @param IAS_transmitStatus
     */
    public void setIAS_transmitStatus(java.lang.String IAS_transmitStatus) {
        this.IAS_transmitStatus = IAS_transmitStatus;
    }


    /**
     * Gets the IS_transmitStatus value for this BasePayment.
     * 
     * @return IS_transmitStatus
     */
    public java.lang.String getIS_transmitStatus() {
        return IS_transmitStatus;
    }


    /**
     * Sets the IS_transmitStatus value for this BasePayment.
     * 
     * @param IS_transmitStatus
     */
    public void setIS_transmitStatus(java.lang.String IS_transmitStatus) {
        this.IS_transmitStatus = IS_transmitStatus;
    }


    /**
     * Gets the iasTranConfig value for this BasePayment.
     * 
     * @return iasTranConfig
     */
    public java.lang.String getIasTranConfig() {
        return iasTranConfig;
    }


    /**
     * Sets the iasTranConfig value for this BasePayment.
     * 
     * @param iasTranConfig
     */
    public void setIasTranConfig(java.lang.String iasTranConfig) {
        this.iasTranConfig = iasTranConfig;
    }


    /**
     * Gets the paymentDate value for this BasePayment.
     * 
     * @return paymentDate
     */
    public java.util.Calendar getPaymentDate() {
        return paymentDate;
    }


    /**
     * Sets the paymentDate value for this BasePayment.
     * 
     * @param paymentDate
     */
    public void setPaymentDate(java.util.Calendar paymentDate) {
        this.paymentDate = paymentDate;
    }


    /**
     * Gets the paymentMode value for this BasePayment.
     * 
     * @return paymentMode
     */
    public java.lang.String getPaymentMode() {
        return paymentMode;
    }


    /**
     * Sets the paymentMode value for this BasePayment.
     * 
     * @param paymentMode
     */
    public void setPaymentMode(java.lang.String paymentMode) {
        this.paymentMode = paymentMode;
    }


    /**
     * Gets the paymentSource value for this BasePayment.
     * 
     * @return paymentSource
     */
    public java.lang.String getPaymentSource() {
        return paymentSource;
    }


    /**
     * Sets the paymentSource value for this BasePayment.
     * 
     * @param paymentSource
     */
    public void setPaymentSource(java.lang.String paymentSource) {
        this.paymentSource = paymentSource;
    }


    /**
     * Gets the policyNumber value for this BasePayment.
     * 
     * @return policyNumber
     */
    public java.lang.String getPolicyNumber() {
        return policyNumber;
    }


    /**
     * Sets the policyNumber value for this BasePayment.
     * 
     * @param policyNumber
     */
    public void setPolicyNumber(java.lang.String policyNumber) {
        this.policyNumber = policyNumber;
    }


    /**
     * Gets the premiumDue value for this BasePayment.
     * 
     * @return premiumDue
     */
    public java.math.BigDecimal getPremiumDue() {
        return premiumDue;
    }


    /**
     * Sets the premiumDue value for this BasePayment.
     * 
     * @param premiumDue
     */
    public void setPremiumDue(java.math.BigDecimal premiumDue) {
        this.premiumDue = premiumDue;
    }


    /**
     * Gets the receiptNumber value for this BasePayment.
     * 
     * @return receiptNumber
     */
    public java.lang.String getReceiptNumber() {
        return receiptNumber;
    }


    /**
     * Sets the receiptNumber value for this BasePayment.
     * 
     * @param receiptNumber
     */
    public void setReceiptNumber(java.lang.String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }


    /**
     * Gets the sealed value for this BasePayment.
     * 
     * @return sealed
     */
    public boolean isSealed() {
        return sealed;
    }


    /**
     * Sets the sealed value for this BasePayment.
     * 
     * @param sealed
     */
    public void setSealed(boolean sealed) {
        this.sealed = sealed;
    }


    /**
     * Gets the subsystem value for this BasePayment.
     * 
     * @return subsystem
     */
    public java.lang.String getSubsystem() {
        return subsystem;
    }


    /**
     * Sets the subsystem value for this BasePayment.
     * 
     * @param subsystem
     */
    public void setSubsystem(java.lang.String subsystem) {
        this.subsystem = subsystem;
    }


    /**
     * Gets the timeStamp value for this BasePayment.
     * 
     * @return timeStamp
     */
    public java.util.Calendar getTimeStamp() {
        return timeStamp;
    }


    /**
     * Sets the timeStamp value for this BasePayment.
     * 
     * @param timeStamp
     */
    public void setTimeStamp(java.util.Calendar timeStamp) {
        this.timeStamp = timeStamp;
    }


    /**
     * Gets the transmitStatus value for this BasePayment.
     * 
     * @return transmitStatus
     */
    public java.lang.String getTransmitStatus() {
        return transmitStatus;
    }


    /**
     * Sets the transmitStatus value for this BasePayment.
     * 
     * @param transmitStatus
     */
    public void setTransmitStatus(java.lang.String transmitStatus) {
        this.transmitStatus = transmitStatus;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BasePayment)) return false;
        BasePayment other = (BasePayment) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.agentCode==null && other.getAgentCode()==null) || 
             (this.agentCode!=null &&
              this.agentCode.equals(other.getAgentCode()))) &&
            ((this.amount==null && other.getAmount()==null) || 
             (this.amount!=null &&
              this.amount.equals(other.getAmount()))) &&
            ((this.debitCreditSign==null && other.getDebitCreditSign()==null) || 
             (this.debitCreditSign!=null &&
              this.debitCreditSign.equals(other.getDebitCreditSign()))) &&
            this.deleted == other.isDeleted() &&
            ((this.denomination==null && other.getDenomination()==null) || 
             (this.denomination!=null &&
              this.denomination.equals(other.getDenomination()))) &&
            ((this.IAS_transmitStatus==null && other.getIAS_transmitStatus()==null) || 
             (this.IAS_transmitStatus!=null &&
              this.IAS_transmitStatus.equals(other.getIAS_transmitStatus()))) &&
            ((this.IS_transmitStatus==null && other.getIS_transmitStatus()==null) || 
             (this.IS_transmitStatus!=null &&
              this.IS_transmitStatus.equals(other.getIS_transmitStatus()))) &&
            ((this.iasTranConfig==null && other.getIasTranConfig()==null) || 
             (this.iasTranConfig!=null &&
              this.iasTranConfig.equals(other.getIasTranConfig()))) &&
            ((this.paymentDate==null && other.getPaymentDate()==null) || 
             (this.paymentDate!=null &&
              this.paymentDate.equals(other.getPaymentDate()))) &&
            ((this.paymentMode==null && other.getPaymentMode()==null) || 
             (this.paymentMode!=null &&
              this.paymentMode.equals(other.getPaymentMode()))) &&
            ((this.paymentSource==null && other.getPaymentSource()==null) || 
             (this.paymentSource!=null &&
              this.paymentSource.equals(other.getPaymentSource()))) &&
            ((this.policyNumber==null && other.getPolicyNumber()==null) || 
             (this.policyNumber!=null &&
              this.policyNumber.equals(other.getPolicyNumber()))) &&
            ((this.premiumDue==null && other.getPremiumDue()==null) || 
             (this.premiumDue!=null &&
              this.premiumDue.equals(other.getPremiumDue()))) &&
            ((this.receiptNumber==null && other.getReceiptNumber()==null) || 
             (this.receiptNumber!=null &&
              this.receiptNumber.equals(other.getReceiptNumber()))) &&
            this.sealed == other.isSealed() &&
            ((this.subsystem==null && other.getSubsystem()==null) || 
             (this.subsystem!=null &&
              this.subsystem.equals(other.getSubsystem()))) &&
            ((this.timeStamp==null && other.getTimeStamp()==null) || 
             (this.timeStamp!=null &&
              this.timeStamp.equals(other.getTimeStamp()))) &&
            ((this.transmitStatus==null && other.getTransmitStatus()==null) || 
             (this.transmitStatus!=null &&
              this.transmitStatus.equals(other.getTransmitStatus())));
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
        if (getAgentCode() != null) {
            _hashCode += getAgentCode().hashCode();
        }
        if (getAmount() != null) {
            _hashCode += getAmount().hashCode();
        }
        if (getDebitCreditSign() != null) {
            _hashCode += getDebitCreditSign().hashCode();
        }
        _hashCode += (isDeleted() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getDenomination() != null) {
            _hashCode += getDenomination().hashCode();
        }
        if (getIAS_transmitStatus() != null) {
            _hashCode += getIAS_transmitStatus().hashCode();
        }
        if (getIS_transmitStatus() != null) {
            _hashCode += getIS_transmitStatus().hashCode();
        }
        if (getIasTranConfig() != null) {
            _hashCode += getIasTranConfig().hashCode();
        }
        if (getPaymentDate() != null) {
            _hashCode += getPaymentDate().hashCode();
        }
        if (getPaymentMode() != null) {
            _hashCode += getPaymentMode().hashCode();
        }
        if (getPaymentSource() != null) {
            _hashCode += getPaymentSource().hashCode();
        }
        if (getPolicyNumber() != null) {
            _hashCode += getPolicyNumber().hashCode();
        }
        if (getPremiumDue() != null) {
            _hashCode += getPremiumDue().hashCode();
        }
        if (getReceiptNumber() != null) {
            _hashCode += getReceiptNumber().hashCode();
        }
        _hashCode += (isSealed() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getSubsystem() != null) {
            _hashCode += getSubsystem().hashCode();
        }
        if (getTimeStamp() != null) {
            _hashCode += getTimeStamp().hashCode();
        }
        if (getTransmitStatus() != null) {
            _hashCode += getTransmitStatus().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BasePayment.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "basePayment"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("agentCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "agentCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("amount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "amount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
        elemField.setFieldName("denomination");
        elemField.setXmlName(new javax.xml.namespace.QName("", "denomination"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IAS_transmitStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "IAS_transmitStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IS_transmitStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "IS_transmitStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("iasTranConfig");
        elemField.setXmlName(new javax.xml.namespace.QName("", "iasTranConfig"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paymentDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "paymentDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paymentMode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "paymentMode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paymentSource");
        elemField.setXmlName(new javax.xml.namespace.QName("", "paymentSource"));
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
        elemField.setFieldName("premiumDue");
        elemField.setXmlName(new javax.xml.namespace.QName("", "premiumDue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("receiptNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "receiptNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sealed");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sealed"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
        elemField.setFieldName("timeStamp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "timeStamp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transmitStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "transmitStatus"));
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
