/**
 * Commission.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.leadway.projects.payment.endpoint;

public class Commission  implements java.io.Serializable {
    private java.lang.String agentCode;

    private java.lang.Long agentID;

    private java.lang.String agentName;

    private double amount;

    private java.lang.String debitCreditNumber;

    private boolean leader;

    private boolean nonTarrifAmount;

    private java.lang.String policyNumber;

    private double premium;

    private double ratePercent;

    public Commission() {
    }

    public Commission(
           java.lang.String agentCode,
           java.lang.Long agentID,
           java.lang.String agentName,
           double amount,
           java.lang.String debitCreditNumber,
           boolean leader,
           boolean nonTarrifAmount,
           java.lang.String policyNumber,
           double premium,
           double ratePercent) {
           this.agentCode = agentCode;
           this.agentID = agentID;
           this.agentName = agentName;
           this.amount = amount;
           this.debitCreditNumber = debitCreditNumber;
           this.leader = leader;
           this.nonTarrifAmount = nonTarrifAmount;
           this.policyNumber = policyNumber;
           this.premium = premium;
           this.ratePercent = ratePercent;
    }


    /**
     * Gets the agentCode value for this Commission.
     * 
     * @return agentCode
     */
    public java.lang.String getAgentCode() {
        return agentCode;
    }


    /**
     * Sets the agentCode value for this Commission.
     * 
     * @param agentCode
     */
    public void setAgentCode(java.lang.String agentCode) {
        this.agentCode = agentCode;
    }


    /**
     * Gets the agentID value for this Commission.
     * 
     * @return agentID
     */
    public java.lang.Long getAgentID() {
        return agentID;
    }


    /**
     * Sets the agentID value for this Commission.
     * 
     * @param agentID
     */
    public void setAgentID(java.lang.Long agentID) {
        this.agentID = agentID;
    }


    /**
     * Gets the agentName value for this Commission.
     * 
     * @return agentName
     */
    public java.lang.String getAgentName() {
        return agentName;
    }


    /**
     * Sets the agentName value for this Commission.
     * 
     * @param agentName
     */
    public void setAgentName(java.lang.String agentName) {
        this.agentName = agentName;
    }


    /**
     * Gets the amount value for this Commission.
     * 
     * @return amount
     */
    public double getAmount() {
        return amount;
    }


    /**
     * Sets the amount value for this Commission.
     * 
     * @param amount
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }


    /**
     * Gets the debitCreditNumber value for this Commission.
     * 
     * @return debitCreditNumber
     */
    public java.lang.String getDebitCreditNumber() {
        return debitCreditNumber;
    }


    /**
     * Sets the debitCreditNumber value for this Commission.
     * 
     * @param debitCreditNumber
     */
    public void setDebitCreditNumber(java.lang.String debitCreditNumber) {
        this.debitCreditNumber = debitCreditNumber;
    }


    /**
     * Gets the leader value for this Commission.
     * 
     * @return leader
     */
    public boolean isLeader() {
        return leader;
    }


    /**
     * Sets the leader value for this Commission.
     * 
     * @param leader
     */
    public void setLeader(boolean leader) {
        this.leader = leader;
    }


    /**
     * Gets the nonTarrifAmount value for this Commission.
     * 
     * @return nonTarrifAmount
     */
    public boolean isNonTarrifAmount() {
        return nonTarrifAmount;
    }


    /**
     * Sets the nonTarrifAmount value for this Commission.
     * 
     * @param nonTarrifAmount
     */
    public void setNonTarrifAmount(boolean nonTarrifAmount) {
        this.nonTarrifAmount = nonTarrifAmount;
    }


    /**
     * Gets the policyNumber value for this Commission.
     * 
     * @return policyNumber
     */
    public java.lang.String getPolicyNumber() {
        return policyNumber;
    }


    /**
     * Sets the policyNumber value for this Commission.
     * 
     * @param policyNumber
     */
    public void setPolicyNumber(java.lang.String policyNumber) {
        this.policyNumber = policyNumber;
    }


    /**
     * Gets the premium value for this Commission.
     * 
     * @return premium
     */
    public double getPremium() {
        return premium;
    }


    /**
     * Sets the premium value for this Commission.
     * 
     * @param premium
     */
    public void setPremium(double premium) {
        this.premium = premium;
    }


    /**
     * Gets the ratePercent value for this Commission.
     * 
     * @return ratePercent
     */
    public double getRatePercent() {
        return ratePercent;
    }


    /**
     * Sets the ratePercent value for this Commission.
     * 
     * @param ratePercent
     */
    public void setRatePercent(double ratePercent) {
        this.ratePercent = ratePercent;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Commission)) return false;
        Commission other = (Commission) obj;
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
            ((this.agentID==null && other.getAgentID()==null) || 
             (this.agentID!=null &&
              this.agentID.equals(other.getAgentID()))) &&
            ((this.agentName==null && other.getAgentName()==null) || 
             (this.agentName!=null &&
              this.agentName.equals(other.getAgentName()))) &&
            this.amount == other.getAmount() &&
            ((this.debitCreditNumber==null && other.getDebitCreditNumber()==null) || 
             (this.debitCreditNumber!=null &&
              this.debitCreditNumber.equals(other.getDebitCreditNumber()))) &&
            this.leader == other.isLeader() &&
            this.nonTarrifAmount == other.isNonTarrifAmount() &&
            ((this.policyNumber==null && other.getPolicyNumber()==null) || 
             (this.policyNumber!=null &&
              this.policyNumber.equals(other.getPolicyNumber()))) &&
            this.premium == other.getPremium() &&
            this.ratePercent == other.getRatePercent();
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
        if (getAgentID() != null) {
            _hashCode += getAgentID().hashCode();
        }
        if (getAgentName() != null) {
            _hashCode += getAgentName().hashCode();
        }
        _hashCode += new Double(getAmount()).hashCode();
        if (getDebitCreditNumber() != null) {
            _hashCode += getDebitCreditNumber().hashCode();
        }
        _hashCode += (isLeader() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isNonTarrifAmount() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getPolicyNumber() != null) {
            _hashCode += getPolicyNumber().hashCode();
        }
        _hashCode += new Double(getPremium()).hashCode();
        _hashCode += new Double(getRatePercent()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Commission.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "commission"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("agentCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "agentCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
        elemField.setFieldName("amount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "amount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("debitCreditNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "debitCreditNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("leader");
        elemField.setXmlName(new javax.xml.namespace.QName("", "leader"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nonTarrifAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nonTarrifAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
        elemField.setFieldName("premium");
        elemField.setXmlName(new javax.xml.namespace.QName("", "premium"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ratePercent");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ratePercent"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
