/**
 * PaymentData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.leadway.pf.service.ws;

public class PaymentData  extends com.leadway.pf.service.ws.BusinessData  implements java.io.Serializable {
    private java.math.BigDecimal amount;

    private java.lang.String clientCode;

    private java.lang.String collectionAcctNumber;

    private java.lang.String collectionSortCode;

    private java.lang.String ddReferenceNumber;

    private java.lang.Long defaultId;

    private java.util.Calendar effectiveDate;

    private java.lang.String installationNumber;

    private java.lang.String installmentType;

    private java.lang.String payAcctNumber;

    private java.lang.String paySortCode;

    private java.lang.String paymentIndicator;

    private java.lang.String policyRefNo;

    private java.lang.Long scheduleId;

    private java.lang.String subSystemCode;

    private java.util.Calendar transactionDate;

    private java.util.Calendar unclearedPaymentDate;

    public PaymentData() {
    }

    public PaymentData(
           java.util.Calendar createDate,
           java.lang.String createdBy,
           boolean deleted,
           boolean editable,
           boolean selected,
           java.lang.String status,
           java.lang.String statusDesc,
           java.lang.Short version,
           java.math.BigDecimal amount,
           java.lang.String clientCode,
           java.lang.String collectionAcctNumber,
           java.lang.String collectionSortCode,
           java.lang.String ddReferenceNumber,
           java.lang.Long defaultId,
           java.util.Calendar effectiveDate,
           java.lang.String installationNumber,
           java.lang.String installmentType,
           java.lang.String payAcctNumber,
           java.lang.String paySortCode,
           java.lang.String paymentIndicator,
           java.lang.String policyRefNo,
           java.lang.Long scheduleId,
           java.lang.String subSystemCode,
           java.util.Calendar transactionDate,
           java.util.Calendar unclearedPaymentDate) {
        super(
            createDate,
            createdBy,
            deleted,
            editable,
            selected,
            status,
            statusDesc,
            version);
        this.amount = amount;
        this.clientCode = clientCode;
        this.collectionAcctNumber = collectionAcctNumber;
        this.collectionSortCode = collectionSortCode;
        this.ddReferenceNumber = ddReferenceNumber;
        this.defaultId = defaultId;
        this.effectiveDate = effectiveDate;
        this.installationNumber = installationNumber;
        this.installmentType = installmentType;
        this.payAcctNumber = payAcctNumber;
        this.paySortCode = paySortCode;
        this.paymentIndicator = paymentIndicator;
        this.policyRefNo = policyRefNo;
        this.scheduleId = scheduleId;
        this.subSystemCode = subSystemCode;
        this.transactionDate = transactionDate;
        this.unclearedPaymentDate = unclearedPaymentDate;
    }


    /**
     * Gets the amount value for this PaymentData.
     * 
     * @return amount
     */
    public java.math.BigDecimal getAmount() {
        return amount;
    }


    /**
     * Sets the amount value for this PaymentData.
     * 
     * @param amount
     */
    public void setAmount(java.math.BigDecimal amount) {
        this.amount = amount;
    }


    /**
     * Gets the clientCode value for this PaymentData.
     * 
     * @return clientCode
     */
    public java.lang.String getClientCode() {
        return clientCode;
    }


    /**
     * Sets the clientCode value for this PaymentData.
     * 
     * @param clientCode
     */
    public void setClientCode(java.lang.String clientCode) {
        this.clientCode = clientCode;
    }


    /**
     * Gets the collectionAcctNumber value for this PaymentData.
     * 
     * @return collectionAcctNumber
     */
    public java.lang.String getCollectionAcctNumber() {
        return collectionAcctNumber;
    }


    /**
     * Sets the collectionAcctNumber value for this PaymentData.
     * 
     * @param collectionAcctNumber
     */
    public void setCollectionAcctNumber(java.lang.String collectionAcctNumber) {
        this.collectionAcctNumber = collectionAcctNumber;
    }


    /**
     * Gets the collectionSortCode value for this PaymentData.
     * 
     * @return collectionSortCode
     */
    public java.lang.String getCollectionSortCode() {
        return collectionSortCode;
    }


    /**
     * Sets the collectionSortCode value for this PaymentData.
     * 
     * @param collectionSortCode
     */
    public void setCollectionSortCode(java.lang.String collectionSortCode) {
        this.collectionSortCode = collectionSortCode;
    }


    /**
     * Gets the ddReferenceNumber value for this PaymentData.
     * 
     * @return ddReferenceNumber
     */
    public java.lang.String getDdReferenceNumber() {
        return ddReferenceNumber;
    }


    /**
     * Sets the ddReferenceNumber value for this PaymentData.
     * 
     * @param ddReferenceNumber
     */
    public void setDdReferenceNumber(java.lang.String ddReferenceNumber) {
        this.ddReferenceNumber = ddReferenceNumber;
    }


    /**
     * Gets the defaultId value for this PaymentData.
     * 
     * @return defaultId
     */
    public java.lang.Long getDefaultId() {
        return defaultId;
    }


    /**
     * Sets the defaultId value for this PaymentData.
     * 
     * @param defaultId
     */
    public void setDefaultId(java.lang.Long defaultId) {
        this.defaultId = defaultId;
    }


    /**
     * Gets the effectiveDate value for this PaymentData.
     * 
     * @return effectiveDate
     */
    public java.util.Calendar getEffectiveDate() {
        return effectiveDate;
    }


    /**
     * Sets the effectiveDate value for this PaymentData.
     * 
     * @param effectiveDate
     */
    public void setEffectiveDate(java.util.Calendar effectiveDate) {
        this.effectiveDate = effectiveDate;
    }


    /**
     * Gets the installationNumber value for this PaymentData.
     * 
     * @return installationNumber
     */
    public java.lang.String getInstallationNumber() {
        return installationNumber;
    }


    /**
     * Sets the installationNumber value for this PaymentData.
     * 
     * @param installationNumber
     */
    public void setInstallationNumber(java.lang.String installationNumber) {
        this.installationNumber = installationNumber;
    }


    /**
     * Gets the installmentType value for this PaymentData.
     * 
     * @return installmentType
     */
    public java.lang.String getInstallmentType() {
        return installmentType;
    }


    /**
     * Sets the installmentType value for this PaymentData.
     * 
     * @param installmentType
     */
    public void setInstallmentType(java.lang.String installmentType) {
        this.installmentType = installmentType;
    }


    /**
     * Gets the payAcctNumber value for this PaymentData.
     * 
     * @return payAcctNumber
     */
    public java.lang.String getPayAcctNumber() {
        return payAcctNumber;
    }


    /**
     * Sets the payAcctNumber value for this PaymentData.
     * 
     * @param payAcctNumber
     */
    public void setPayAcctNumber(java.lang.String payAcctNumber) {
        this.payAcctNumber = payAcctNumber;
    }


    /**
     * Gets the paySortCode value for this PaymentData.
     * 
     * @return paySortCode
     */
    public java.lang.String getPaySortCode() {
        return paySortCode;
    }


    /**
     * Sets the paySortCode value for this PaymentData.
     * 
     * @param paySortCode
     */
    public void setPaySortCode(java.lang.String paySortCode) {
        this.paySortCode = paySortCode;
    }


    /**
     * Gets the paymentIndicator value for this PaymentData.
     * 
     * @return paymentIndicator
     */
    public java.lang.String getPaymentIndicator() {
        return paymentIndicator;
    }


    /**
     * Sets the paymentIndicator value for this PaymentData.
     * 
     * @param paymentIndicator
     */
    public void setPaymentIndicator(java.lang.String paymentIndicator) {
        this.paymentIndicator = paymentIndicator;
    }


    /**
     * Gets the policyRefNo value for this PaymentData.
     * 
     * @return policyRefNo
     */
    public java.lang.String getPolicyRefNo() {
        return policyRefNo;
    }


    /**
     * Sets the policyRefNo value for this PaymentData.
     * 
     * @param policyRefNo
     */
    public void setPolicyRefNo(java.lang.String policyRefNo) {
        this.policyRefNo = policyRefNo;
    }


    /**
     * Gets the scheduleId value for this PaymentData.
     * 
     * @return scheduleId
     */
    public java.lang.Long getScheduleId() {
        return scheduleId;
    }


    /**
     * Sets the scheduleId value for this PaymentData.
     * 
     * @param scheduleId
     */
    public void setScheduleId(java.lang.Long scheduleId) {
        this.scheduleId = scheduleId;
    }


    /**
     * Gets the subSystemCode value for this PaymentData.
     * 
     * @return subSystemCode
     */
    public java.lang.String getSubSystemCode() {
        return subSystemCode;
    }


    /**
     * Sets the subSystemCode value for this PaymentData.
     * 
     * @param subSystemCode
     */
    public void setSubSystemCode(java.lang.String subSystemCode) {
        this.subSystemCode = subSystemCode;
    }


    /**
     * Gets the transactionDate value for this PaymentData.
     * 
     * @return transactionDate
     */
    public java.util.Calendar getTransactionDate() {
        return transactionDate;
    }


    /**
     * Sets the transactionDate value for this PaymentData.
     * 
     * @param transactionDate
     */
    public void setTransactionDate(java.util.Calendar transactionDate) {
        this.transactionDate = transactionDate;
    }


    /**
     * Gets the unclearedPaymentDate value for this PaymentData.
     * 
     * @return unclearedPaymentDate
     */
    public java.util.Calendar getUnclearedPaymentDate() {
        return unclearedPaymentDate;
    }


    /**
     * Sets the unclearedPaymentDate value for this PaymentData.
     * 
     * @param unclearedPaymentDate
     */
    public void setUnclearedPaymentDate(java.util.Calendar unclearedPaymentDate) {
        this.unclearedPaymentDate = unclearedPaymentDate;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PaymentData)) return false;
        PaymentData other = (PaymentData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.amount==null && other.getAmount()==null) || 
             (this.amount!=null &&
              this.amount.equals(other.getAmount()))) &&
            ((this.clientCode==null && other.getClientCode()==null) || 
             (this.clientCode!=null &&
              this.clientCode.equals(other.getClientCode()))) &&
            ((this.collectionAcctNumber==null && other.getCollectionAcctNumber()==null) || 
             (this.collectionAcctNumber!=null &&
              this.collectionAcctNumber.equals(other.getCollectionAcctNumber()))) &&
            ((this.collectionSortCode==null && other.getCollectionSortCode()==null) || 
             (this.collectionSortCode!=null &&
              this.collectionSortCode.equals(other.getCollectionSortCode()))) &&
            ((this.ddReferenceNumber==null && other.getDdReferenceNumber()==null) || 
             (this.ddReferenceNumber!=null &&
              this.ddReferenceNumber.equals(other.getDdReferenceNumber()))) &&
            ((this.defaultId==null && other.getDefaultId()==null) || 
             (this.defaultId!=null &&
              this.defaultId.equals(other.getDefaultId()))) &&
            ((this.effectiveDate==null && other.getEffectiveDate()==null) || 
             (this.effectiveDate!=null &&
              this.effectiveDate.equals(other.getEffectiveDate()))) &&
            ((this.installationNumber==null && other.getInstallationNumber()==null) || 
             (this.installationNumber!=null &&
              this.installationNumber.equals(other.getInstallationNumber()))) &&
            ((this.installmentType==null && other.getInstallmentType()==null) || 
             (this.installmentType!=null &&
              this.installmentType.equals(other.getInstallmentType()))) &&
            ((this.payAcctNumber==null && other.getPayAcctNumber()==null) || 
             (this.payAcctNumber!=null &&
              this.payAcctNumber.equals(other.getPayAcctNumber()))) &&
            ((this.paySortCode==null && other.getPaySortCode()==null) || 
             (this.paySortCode!=null &&
              this.paySortCode.equals(other.getPaySortCode()))) &&
            ((this.paymentIndicator==null && other.getPaymentIndicator()==null) || 
             (this.paymentIndicator!=null &&
              this.paymentIndicator.equals(other.getPaymentIndicator()))) &&
            ((this.policyRefNo==null && other.getPolicyRefNo()==null) || 
             (this.policyRefNo!=null &&
              this.policyRefNo.equals(other.getPolicyRefNo()))) &&
            ((this.scheduleId==null && other.getScheduleId()==null) || 
             (this.scheduleId!=null &&
              this.scheduleId.equals(other.getScheduleId()))) &&
            ((this.subSystemCode==null && other.getSubSystemCode()==null) || 
             (this.subSystemCode!=null &&
              this.subSystemCode.equals(other.getSubSystemCode()))) &&
            ((this.transactionDate==null && other.getTransactionDate()==null) || 
             (this.transactionDate!=null &&
              this.transactionDate.equals(other.getTransactionDate()))) &&
            ((this.unclearedPaymentDate==null && other.getUnclearedPaymentDate()==null) || 
             (this.unclearedPaymentDate!=null &&
              this.unclearedPaymentDate.equals(other.getUnclearedPaymentDate())));
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
        if (getAmount() != null) {
            _hashCode += getAmount().hashCode();
        }
        if (getClientCode() != null) {
            _hashCode += getClientCode().hashCode();
        }
        if (getCollectionAcctNumber() != null) {
            _hashCode += getCollectionAcctNumber().hashCode();
        }
        if (getCollectionSortCode() != null) {
            _hashCode += getCollectionSortCode().hashCode();
        }
        if (getDdReferenceNumber() != null) {
            _hashCode += getDdReferenceNumber().hashCode();
        }
        if (getDefaultId() != null) {
            _hashCode += getDefaultId().hashCode();
        }
        if (getEffectiveDate() != null) {
            _hashCode += getEffectiveDate().hashCode();
        }
        if (getInstallationNumber() != null) {
            _hashCode += getInstallationNumber().hashCode();
        }
        if (getInstallmentType() != null) {
            _hashCode += getInstallmentType().hashCode();
        }
        if (getPayAcctNumber() != null) {
            _hashCode += getPayAcctNumber().hashCode();
        }
        if (getPaySortCode() != null) {
            _hashCode += getPaySortCode().hashCode();
        }
        if (getPaymentIndicator() != null) {
            _hashCode += getPaymentIndicator().hashCode();
        }
        if (getPolicyRefNo() != null) {
            _hashCode += getPolicyRefNo().hashCode();
        }
        if (getScheduleId() != null) {
            _hashCode += getScheduleId().hashCode();
        }
        if (getSubSystemCode() != null) {
            _hashCode += getSubSystemCode().hashCode();
        }
        if (getTransactionDate() != null) {
            _hashCode += getTransactionDate().hashCode();
        }
        if (getUnclearedPaymentDate() != null) {
            _hashCode += getUnclearedPaymentDate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PaymentData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.service.pf.leadway.com/", "paymentData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("amount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "amount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
        elemField.setFieldName("collectionAcctNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "collectionAcctNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("collectionSortCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "collectionSortCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ddReferenceNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ddReferenceNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("defaultId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "defaultId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
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
        elemField.setFieldName("installationNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "installationNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("installmentType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "installmentType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("payAcctNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "payAcctNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paySortCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "paySortCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paymentIndicator");
        elemField.setXmlName(new javax.xml.namespace.QName("", "paymentIndicator"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("policyRefNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "policyRefNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scheduleId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "scheduleId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subSystemCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "subSystemCode"));
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
        elemField.setFieldName("unclearedPaymentDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "unclearedPaymentDate"));
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
