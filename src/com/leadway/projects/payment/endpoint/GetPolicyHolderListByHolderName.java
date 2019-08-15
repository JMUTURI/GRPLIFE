/**
 * GetPolicyHolderListByHolderName.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.leadway.projects.payment.endpoint;

public class GetPolicyHolderListByHolderName  implements java.io.Serializable {
    private java.lang.String policyHolderName;

    private java.lang.String hostName;

    public GetPolicyHolderListByHolderName() {
    }

    public GetPolicyHolderListByHolderName(
           java.lang.String policyHolderName,
           java.lang.String hostName) {
           this.policyHolderName = policyHolderName;
           this.hostName = hostName;
    }


    /**
     * Gets the policyHolderName value for this GetPolicyHolderListByHolderName.
     * 
     * @return policyHolderName
     */
    public java.lang.String getPolicyHolderName() {
        return policyHolderName;
    }


    /**
     * Sets the policyHolderName value for this GetPolicyHolderListByHolderName.
     * 
     * @param policyHolderName
     */
    public void setPolicyHolderName(java.lang.String policyHolderName) {
        this.policyHolderName = policyHolderName;
    }


    /**
     * Gets the hostName value for this GetPolicyHolderListByHolderName.
     * 
     * @return hostName
     */
    public java.lang.String getHostName() {
        return hostName;
    }


    /**
     * Sets the hostName value for this GetPolicyHolderListByHolderName.
     * 
     * @param hostName
     */
    public void setHostName(java.lang.String hostName) {
        this.hostName = hostName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetPolicyHolderListByHolderName)) return false;
        GetPolicyHolderListByHolderName other = (GetPolicyHolderListByHolderName) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.policyHolderName==null && other.getPolicyHolderName()==null) || 
             (this.policyHolderName!=null &&
              this.policyHolderName.equals(other.getPolicyHolderName()))) &&
            ((this.hostName==null && other.getHostName()==null) || 
             (this.hostName!=null &&
              this.hostName.equals(other.getHostName())));
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
        if (getPolicyHolderName() != null) {
            _hashCode += getPolicyHolderName().hashCode();
        }
        if (getHostName() != null) {
            _hashCode += getHostName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetPolicyHolderListByHolderName.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "getPolicyHolderListByHolderName"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("policyHolderName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "policyHolderName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hostName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "hostName"));
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
