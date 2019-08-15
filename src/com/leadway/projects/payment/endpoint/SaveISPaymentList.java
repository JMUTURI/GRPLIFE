/**
 * SaveISPaymentList.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.leadway.projects.payment.endpoint;

public class SaveISPaymentList  implements java.io.Serializable {
    private com.leadway.projects.payment.endpoint.BasePayment[] paymentList;

    private java.lang.String hostName;

    public SaveISPaymentList() {
    }

    public SaveISPaymentList(
           com.leadway.projects.payment.endpoint.BasePayment[] paymentList,
           java.lang.String hostName) {
           this.paymentList = paymentList;
           this.hostName = hostName;
    }


    /**
     * Gets the paymentList value for this SaveISPaymentList.
     * 
     * @return paymentList
     */
    public com.leadway.projects.payment.endpoint.BasePayment[] getPaymentList() {
        return paymentList;
    }


    /**
     * Sets the paymentList value for this SaveISPaymentList.
     * 
     * @param paymentList
     */
    public void setPaymentList(com.leadway.projects.payment.endpoint.BasePayment[] paymentList) {
        this.paymentList = paymentList;
    }

    public com.leadway.projects.payment.endpoint.BasePayment getPaymentList(int i) {
        return this.paymentList[i];
    }

    public void setPaymentList(int i, com.leadway.projects.payment.endpoint.BasePayment _value) {
        this.paymentList[i] = _value;
    }


    /**
     * Gets the hostName value for this SaveISPaymentList.
     * 
     * @return hostName
     */
    public java.lang.String getHostName() {
        return hostName;
    }


    /**
     * Sets the hostName value for this SaveISPaymentList.
     * 
     * @param hostName
     */
    public void setHostName(java.lang.String hostName) {
        this.hostName = hostName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SaveISPaymentList)) return false;
        SaveISPaymentList other = (SaveISPaymentList) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.paymentList==null && other.getPaymentList()==null) || 
             (this.paymentList!=null &&
              java.util.Arrays.equals(this.paymentList, other.getPaymentList()))) &&
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
        if (getPaymentList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPaymentList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPaymentList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getHostName() != null) {
            _hashCode += getHostName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SaveISPaymentList.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "saveISPaymentList"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paymentList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "paymentList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "basePayment"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
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
