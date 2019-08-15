/**
 * Subsystem.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.leadway.projects.payment.endpoint;

public class Subsystem  implements java.io.Serializable {
    private com.leadway.projects.payment.endpoint.PolicyPrefixConfig[] policyPrefixConfigList;

    private com.leadway.projects.payment.endpoint.SubsystemConfig subsystemConfig;

    public Subsystem() {
    }

    public Subsystem(
           com.leadway.projects.payment.endpoint.PolicyPrefixConfig[] policyPrefixConfigList,
           com.leadway.projects.payment.endpoint.SubsystemConfig subsystemConfig) {
           this.policyPrefixConfigList = policyPrefixConfigList;
           this.subsystemConfig = subsystemConfig;
    }


    /**
     * Gets the policyPrefixConfigList value for this Subsystem.
     * 
     * @return policyPrefixConfigList
     */
    public com.leadway.projects.payment.endpoint.PolicyPrefixConfig[] getPolicyPrefixConfigList() {
        return policyPrefixConfigList;
    }


    /**
     * Sets the policyPrefixConfigList value for this Subsystem.
     * 
     * @param policyPrefixConfigList
     */
    public void setPolicyPrefixConfigList(com.leadway.projects.payment.endpoint.PolicyPrefixConfig[] policyPrefixConfigList) {
        this.policyPrefixConfigList = policyPrefixConfigList;
    }

    public com.leadway.projects.payment.endpoint.PolicyPrefixConfig getPolicyPrefixConfigList(int i) {
        return this.policyPrefixConfigList[i];
    }

    public void setPolicyPrefixConfigList(int i, com.leadway.projects.payment.endpoint.PolicyPrefixConfig _value) {
        this.policyPrefixConfigList[i] = _value;
    }


    /**
     * Gets the subsystemConfig value for this Subsystem.
     * 
     * @return subsystemConfig
     */
    public com.leadway.projects.payment.endpoint.SubsystemConfig getSubsystemConfig() {
        return subsystemConfig;
    }


    /**
     * Sets the subsystemConfig value for this Subsystem.
     * 
     * @param subsystemConfig
     */
    public void setSubsystemConfig(com.leadway.projects.payment.endpoint.SubsystemConfig subsystemConfig) {
        this.subsystemConfig = subsystemConfig;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Subsystem)) return false;
        Subsystem other = (Subsystem) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.policyPrefixConfigList==null && other.getPolicyPrefixConfigList()==null) || 
             (this.policyPrefixConfigList!=null &&
              java.util.Arrays.equals(this.policyPrefixConfigList, other.getPolicyPrefixConfigList()))) &&
            ((this.subsystemConfig==null && other.getSubsystemConfig()==null) || 
             (this.subsystemConfig!=null &&
              this.subsystemConfig.equals(other.getSubsystemConfig())));
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
        if (getPolicyPrefixConfigList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPolicyPrefixConfigList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPolicyPrefixConfigList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSubsystemConfig() != null) {
            _hashCode += getSubsystemConfig().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Subsystem.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "subsystem"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("policyPrefixConfigList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "policyPrefixConfigList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "policyPrefixConfig"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subsystemConfig");
        elemField.setXmlName(new javax.xml.namespace.QName("", "subsystemConfig"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "subsystemConfig"));
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
