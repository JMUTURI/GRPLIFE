/**
 * PolicyPrefixConfig.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.leadway.projects.payment.endpoint;

public class PolicyPrefixConfig  implements java.io.Serializable {
    private java.lang.String division;

    private java.lang.String policyPrefix;

    private java.lang.String riskClass;

    private java.lang.String subsystem;

    public PolicyPrefixConfig() {
    }

    public PolicyPrefixConfig(
           java.lang.String division,
           java.lang.String policyPrefix,
           java.lang.String riskClass,
           java.lang.String subsystem) {
           this.division = division;
           this.policyPrefix = policyPrefix;
           this.riskClass = riskClass;
           this.subsystem = subsystem;
    }


    /**
     * Gets the division value for this PolicyPrefixConfig.
     * 
     * @return division
     */
    public java.lang.String getDivision() {
        return division;
    }


    /**
     * Sets the division value for this PolicyPrefixConfig.
     * 
     * @param division
     */
    public void setDivision(java.lang.String division) {
        this.division = division;
    }


    /**
     * Gets the policyPrefix value for this PolicyPrefixConfig.
     * 
     * @return policyPrefix
     */
    public java.lang.String getPolicyPrefix() {
        return policyPrefix;
    }


    /**
     * Sets the policyPrefix value for this PolicyPrefixConfig.
     * 
     * @param policyPrefix
     */
    public void setPolicyPrefix(java.lang.String policyPrefix) {
        this.policyPrefix = policyPrefix;
    }


    /**
     * Gets the riskClass value for this PolicyPrefixConfig.
     * 
     * @return riskClass
     */
    public java.lang.String getRiskClass() {
        return riskClass;
    }


    /**
     * Sets the riskClass value for this PolicyPrefixConfig.
     * 
     * @param riskClass
     */
    public void setRiskClass(java.lang.String riskClass) {
        this.riskClass = riskClass;
    }


    /**
     * Gets the subsystem value for this PolicyPrefixConfig.
     * 
     * @return subsystem
     */
    public java.lang.String getSubsystem() {
        return subsystem;
    }


    /**
     * Sets the subsystem value for this PolicyPrefixConfig.
     * 
     * @param subsystem
     */
    public void setSubsystem(java.lang.String subsystem) {
        this.subsystem = subsystem;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PolicyPrefixConfig)) return false;
        PolicyPrefixConfig other = (PolicyPrefixConfig) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.division==null && other.getDivision()==null) || 
             (this.division!=null &&
              this.division.equals(other.getDivision()))) &&
            ((this.policyPrefix==null && other.getPolicyPrefix()==null) || 
             (this.policyPrefix!=null &&
              this.policyPrefix.equals(other.getPolicyPrefix()))) &&
            ((this.riskClass==null && other.getRiskClass()==null) || 
             (this.riskClass!=null &&
              this.riskClass.equals(other.getRiskClass()))) &&
            ((this.subsystem==null && other.getSubsystem()==null) || 
             (this.subsystem!=null &&
              this.subsystem.equals(other.getSubsystem())));
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
        if (getDivision() != null) {
            _hashCode += getDivision().hashCode();
        }
        if (getPolicyPrefix() != null) {
            _hashCode += getPolicyPrefix().hashCode();
        }
        if (getRiskClass() != null) {
            _hashCode += getRiskClass().hashCode();
        }
        if (getSubsystem() != null) {
            _hashCode += getSubsystem().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PolicyPrefixConfig.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "policyPrefixConfig"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("division");
        elemField.setXmlName(new javax.xml.namespace.QName("", "division"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("policyPrefix");
        elemField.setXmlName(new javax.xml.namespace.QName("", "policyPrefix"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
        elemField.setFieldName("subsystem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "subsystem"));
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
