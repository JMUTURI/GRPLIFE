/**
 * PolicyHolder.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.leadway.projects.payment.endpoint;

public class PolicyHolder  implements java.io.Serializable {
    private java.lang.String addressString;

    private java.lang.String agentCode;

    private java.lang.String agentName;

    private java.lang.String branchCode;

    private long cityId;

    private boolean deleted;

    private java.lang.String holderName;

    private long lgaId;

    private java.lang.String policyNumber;

    private double premiumDue;

    private java.lang.String stateCode;

    private java.lang.String subsystem;

    private com.leadway.projects.payment.endpoint.DateVO transactionDate;

    private java.lang.String transmitStatus;

    public PolicyHolder() {
    }

    public PolicyHolder(
           java.lang.String addressString,
           java.lang.String agentCode,
           java.lang.String agentName,
           java.lang.String branchCode,
           long cityId,
           boolean deleted,
           java.lang.String holderName,
           long lgaId,
           java.lang.String policyNumber,
           double premiumDue,
           java.lang.String stateCode,
           java.lang.String subsystem,
           com.leadway.projects.payment.endpoint.DateVO transactionDate,
           java.lang.String transmitStatus) {
           this.addressString = addressString;
           this.agentCode = agentCode;
           this.agentName = agentName;
           this.branchCode = branchCode;
           this.cityId = cityId;
           this.deleted = deleted;
           this.holderName = holderName;
           this.lgaId = lgaId;
           this.policyNumber = policyNumber;
           this.premiumDue = premiumDue;
           this.stateCode = stateCode;
           this.subsystem = subsystem;
           this.transactionDate = transactionDate;
           this.transmitStatus = transmitStatus;
    }


    /**
     * Gets the addressString value for this PolicyHolder.
     * 
     * @return addressString
     */
    public java.lang.String getAddressString() {
        return addressString;
    }


    /**
     * Sets the addressString value for this PolicyHolder.
     * 
     * @param addressString
     */
    public void setAddressString(java.lang.String addressString) {
        this.addressString = addressString;
    }


    /**
     * Gets the agentCode value for this PolicyHolder.
     * 
     * @return agentCode
     */
    public java.lang.String getAgentCode() {
        return agentCode;
    }


    /**
     * Sets the agentCode value for this PolicyHolder.
     * 
     * @param agentCode
     */
    public void setAgentCode(java.lang.String agentCode) {
        this.agentCode = agentCode;
    }


    /**
     * Gets the agentName value for this PolicyHolder.
     * 
     * @return agentName
     */
    public java.lang.String getAgentName() {
        return agentName;
    }


    /**
     * Sets the agentName value for this PolicyHolder.
     * 
     * @param agentName
     */
    public void setAgentName(java.lang.String agentName) {
        this.agentName = agentName;
    }


    /**
     * Gets the branchCode value for this PolicyHolder.
     * 
     * @return branchCode
     */
    public java.lang.String getBranchCode() {
        return branchCode;
    }


    /**
     * Sets the branchCode value for this PolicyHolder.
     * 
     * @param branchCode
     */
    public void setBranchCode(java.lang.String branchCode) {
        this.branchCode = branchCode;
    }


    /**
     * Gets the cityId value for this PolicyHolder.
     * 
     * @return cityId
     */
    public long getCityId() {
        return cityId;
    }


    /**
     * Sets the cityId value for this PolicyHolder.
     * 
     * @param cityId
     */
    public void setCityId(long cityId) {
        this.cityId = cityId;
    }


    /**
     * Gets the deleted value for this PolicyHolder.
     * 
     * @return deleted
     */
    public boolean isDeleted() {
        return deleted;
    }


    /**
     * Sets the deleted value for this PolicyHolder.
     * 
     * @param deleted
     */
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }


    /**
     * Gets the holderName value for this PolicyHolder.
     * 
     * @return holderName
     */
    public java.lang.String getHolderName() {
        return holderName;
    }


    /**
     * Sets the holderName value for this PolicyHolder.
     * 
     * @param holderName
     */
    public void setHolderName(java.lang.String holderName) {
        this.holderName = holderName;
    }


    /**
     * Gets the lgaId value for this PolicyHolder.
     * 
     * @return lgaId
     */
    public long getLgaId() {
        return lgaId;
    }


    /**
     * Sets the lgaId value for this PolicyHolder.
     * 
     * @param lgaId
     */
    public void setLgaId(long lgaId) {
        this.lgaId = lgaId;
    }


    /**
     * Gets the policyNumber value for this PolicyHolder.
     * 
     * @return policyNumber
     */
    public java.lang.String getPolicyNumber() {
        return policyNumber;
    }


    /**
     * Sets the policyNumber value for this PolicyHolder.
     * 
     * @param policyNumber
     */
    public void setPolicyNumber(java.lang.String policyNumber) {
        this.policyNumber = policyNumber;
    }


    /**
     * Gets the premiumDue value for this PolicyHolder.
     * 
     * @return premiumDue
     */
    public double getPremiumDue() {
        return premiumDue;
    }


    /**
     * Sets the premiumDue value for this PolicyHolder.
     * 
     * @param premiumDue
     */
    public void setPremiumDue(double premiumDue) {
        this.premiumDue = premiumDue;
    }


    /**
     * Gets the stateCode value for this PolicyHolder.
     * 
     * @return stateCode
     */
    public java.lang.String getStateCode() {
        return stateCode;
    }


    /**
     * Sets the stateCode value for this PolicyHolder.
     * 
     * @param stateCode
     */
    public void setStateCode(java.lang.String stateCode) {
        this.stateCode = stateCode;
    }


    /**
     * Gets the subsystem value for this PolicyHolder.
     * 
     * @return subsystem
     */
    public java.lang.String getSubsystem() {
        return subsystem;
    }


    /**
     * Sets the subsystem value for this PolicyHolder.
     * 
     * @param subsystem
     */
    public void setSubsystem(java.lang.String subsystem) {
        this.subsystem = subsystem;
    }


    /**
     * Gets the transactionDate value for this PolicyHolder.
     * 
     * @return transactionDate
     */
    public com.leadway.projects.payment.endpoint.DateVO getTransactionDate() {
        return transactionDate;
    }


    /**
     * Sets the transactionDate value for this PolicyHolder.
     * 
     * @param transactionDate
     */
    public void setTransactionDate(com.leadway.projects.payment.endpoint.DateVO transactionDate) {
        this.transactionDate = transactionDate;
    }


    /**
     * Gets the transmitStatus value for this PolicyHolder.
     * 
     * @return transmitStatus
     */
    public java.lang.String getTransmitStatus() {
        return transmitStatus;
    }


    /**
     * Sets the transmitStatus value for this PolicyHolder.
     * 
     * @param transmitStatus
     */
    public void setTransmitStatus(java.lang.String transmitStatus) {
        this.transmitStatus = transmitStatus;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PolicyHolder)) return false;
        PolicyHolder other = (PolicyHolder) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.addressString==null && other.getAddressString()==null) || 
             (this.addressString!=null &&
              this.addressString.equals(other.getAddressString()))) &&
            ((this.agentCode==null && other.getAgentCode()==null) || 
             (this.agentCode!=null &&
              this.agentCode.equals(other.getAgentCode()))) &&
            ((this.agentName==null && other.getAgentName()==null) || 
             (this.agentName!=null &&
              this.agentName.equals(other.getAgentName()))) &&
            ((this.branchCode==null && other.getBranchCode()==null) || 
             (this.branchCode!=null &&
              this.branchCode.equals(other.getBranchCode()))) &&
            this.cityId == other.getCityId() &&
            this.deleted == other.isDeleted() &&
            ((this.holderName==null && other.getHolderName()==null) || 
             (this.holderName!=null &&
              this.holderName.equals(other.getHolderName()))) &&
            this.lgaId == other.getLgaId() &&
            ((this.policyNumber==null && other.getPolicyNumber()==null) || 
             (this.policyNumber!=null &&
              this.policyNumber.equals(other.getPolicyNumber()))) &&
            this.premiumDue == other.getPremiumDue() &&
            ((this.stateCode==null && other.getStateCode()==null) || 
             (this.stateCode!=null &&
              this.stateCode.equals(other.getStateCode()))) &&
            ((this.subsystem==null && other.getSubsystem()==null) || 
             (this.subsystem!=null &&
              this.subsystem.equals(other.getSubsystem()))) &&
            ((this.transactionDate==null && other.getTransactionDate()==null) || 
             (this.transactionDate!=null &&
              this.transactionDate.equals(other.getTransactionDate()))) &&
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
        if (getAddressString() != null) {
            _hashCode += getAddressString().hashCode();
        }
        if (getAgentCode() != null) {
            _hashCode += getAgentCode().hashCode();
        }
        if (getAgentName() != null) {
            _hashCode += getAgentName().hashCode();
        }
        if (getBranchCode() != null) {
            _hashCode += getBranchCode().hashCode();
        }
        _hashCode += new Long(getCityId()).hashCode();
        _hashCode += (isDeleted() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getHolderName() != null) {
            _hashCode += getHolderName().hashCode();
        }
        _hashCode += new Long(getLgaId()).hashCode();
        if (getPolicyNumber() != null) {
            _hashCode += getPolicyNumber().hashCode();
        }
        _hashCode += new Double(getPremiumDue()).hashCode();
        if (getStateCode() != null) {
            _hashCode += getStateCode().hashCode();
        }
        if (getSubsystem() != null) {
            _hashCode += getSubsystem().hashCode();
        }
        if (getTransactionDate() != null) {
            _hashCode += getTransactionDate().hashCode();
        }
        if (getTransmitStatus() != null) {
            _hashCode += getTransmitStatus().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PolicyHolder.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "policyHolder"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("addressString");
        elemField.setXmlName(new javax.xml.namespace.QName("", "addressString"));
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
        elemField.setFieldName("cityId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cityId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deleted");
        elemField.setXmlName(new javax.xml.namespace.QName("", "deleted"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("holderName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "holderName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
        elemField.setFieldName("policyNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "policyNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("premiumDue");
        elemField.setXmlName(new javax.xml.namespace.QName("", "premiumDue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
        elemField.setFieldName("transactionDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "transactionDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "dateVO"));
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
