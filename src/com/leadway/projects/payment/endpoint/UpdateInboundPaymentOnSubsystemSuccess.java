/**
 * UpdateInboundPaymentOnSubsystemSuccess.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.leadway.projects.payment.endpoint;

public class UpdateInboundPaymentOnSubsystemSuccess  implements java.io.Serializable {
    private java.lang.String receiptNumber;

    private java.lang.String hostName;

    public UpdateInboundPaymentOnSubsystemSuccess() {
    }

    public UpdateInboundPaymentOnSubsystemSuccess(
           java.lang.String receiptNumber,
           java.lang.String hostName) {
           this.receiptNumber = receiptNumber;
           this.hostName = hostName;
    }


    /**
     * Gets the receiptNumber value for this UpdateInboundPaymentOnSubsystemSuccess.
     * 
     * @return receiptNumber
     */
    public java.lang.String getReceiptNumber() {
        return receiptNumber;
    }


    /**
     * Sets the receiptNumber value for this UpdateInboundPaymentOnSubsystemSuccess.
     * 
     * @param receiptNumber
     */
    public void setReceiptNumber(java.lang.String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }


    /**
     * Gets the hostName value for this UpdateInboundPaymentOnSubsystemSuccess.
     * 
     * @return hostName
     */
    public java.lang.String getHostName() {
        return hostName;
    }


    /**
     * Sets the hostName value for this UpdateInboundPaymentOnSubsystemSuccess.
     * 
     * @param hostName
     */
    public void setHostName(java.lang.String hostName) {
        this.hostName = hostName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UpdateInboundPaymentOnSubsystemSuccess)) return false;
        UpdateInboundPaymentOnSubsystemSuccess other = (UpdateInboundPaymentOnSubsystemSuccess) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.receiptNumber==null && other.getReceiptNumber()==null) || 
             (this.receiptNumber!=null &&
              this.receiptNumber.equals(other.getReceiptNumber()))) &&
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
        if (getReceiptNumber() != null) {
            _hashCode += getReceiptNumber().hashCode();
        }
        if (getHostName() != null) {
            _hashCode += getHostName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UpdateInboundPaymentOnSubsystemSuccess.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "updateInboundPaymentOnSubsystemSuccess"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("receiptNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "receiptNumber"));
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
