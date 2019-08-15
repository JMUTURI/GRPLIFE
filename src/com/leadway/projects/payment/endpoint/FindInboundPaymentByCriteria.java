/**
 * FindInboundPaymentByCriteria.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.leadway.projects.payment.endpoint;

public class FindInboundPaymentByCriteria  implements java.io.Serializable {
    private com.leadway.projects.payment.endpoint.BasePayment paymentCriteria;

    private com.leadway.projects.payment.endpoint.DateRange tranDateRange;

    private com.leadway.projects.payment.endpoint.DateRange chequeDateRange;

    private java.lang.String hostName;

    public FindInboundPaymentByCriteria() {
    }

    public FindInboundPaymentByCriteria(
           com.leadway.projects.payment.endpoint.BasePayment paymentCriteria,
           com.leadway.projects.payment.endpoint.DateRange tranDateRange,
           com.leadway.projects.payment.endpoint.DateRange chequeDateRange,
           java.lang.String hostName) {
           this.paymentCriteria = paymentCriteria;
           this.tranDateRange = tranDateRange;
           this.chequeDateRange = chequeDateRange;
           this.hostName = hostName;
    }


    /**
     * Gets the paymentCriteria value for this FindInboundPaymentByCriteria.
     * 
     * @return paymentCriteria
     */
    public com.leadway.projects.payment.endpoint.BasePayment getPaymentCriteria() {
        return paymentCriteria;
    }


    /**
     * Sets the paymentCriteria value for this FindInboundPaymentByCriteria.
     * 
     * @param paymentCriteria
     */
    public void setPaymentCriteria(com.leadway.projects.payment.endpoint.BasePayment paymentCriteria) {
        this.paymentCriteria = paymentCriteria;
    }


    /**
     * Gets the tranDateRange value for this FindInboundPaymentByCriteria.
     * 
     * @return tranDateRange
     */
    public com.leadway.projects.payment.endpoint.DateRange getTranDateRange() {
        return tranDateRange;
    }


    /**
     * Sets the tranDateRange value for this FindInboundPaymentByCriteria.
     * 
     * @param tranDateRange
     */
    public void setTranDateRange(com.leadway.projects.payment.endpoint.DateRange tranDateRange) {
        this.tranDateRange = tranDateRange;
    }


    /**
     * Gets the chequeDateRange value for this FindInboundPaymentByCriteria.
     * 
     * @return chequeDateRange
     */
    public com.leadway.projects.payment.endpoint.DateRange getChequeDateRange() {
        return chequeDateRange;
    }


    /**
     * Sets the chequeDateRange value for this FindInboundPaymentByCriteria.
     * 
     * @param chequeDateRange
     */
    public void setChequeDateRange(com.leadway.projects.payment.endpoint.DateRange chequeDateRange) {
        this.chequeDateRange = chequeDateRange;
    }


    /**
     * Gets the hostName value for this FindInboundPaymentByCriteria.
     * 
     * @return hostName
     */
    public java.lang.String getHostName() {
        return hostName;
    }


    /**
     * Sets the hostName value for this FindInboundPaymentByCriteria.
     * 
     * @param hostName
     */
    public void setHostName(java.lang.String hostName) {
        this.hostName = hostName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FindInboundPaymentByCriteria)) return false;
        FindInboundPaymentByCriteria other = (FindInboundPaymentByCriteria) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.paymentCriteria==null && other.getPaymentCriteria()==null) || 
             (this.paymentCriteria!=null &&
              this.paymentCriteria.equals(other.getPaymentCriteria()))) &&
            ((this.tranDateRange==null && other.getTranDateRange()==null) || 
             (this.tranDateRange!=null &&
              this.tranDateRange.equals(other.getTranDateRange()))) &&
            ((this.chequeDateRange==null && other.getChequeDateRange()==null) || 
             (this.chequeDateRange!=null &&
              this.chequeDateRange.equals(other.getChequeDateRange()))) &&
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
        if (getPaymentCriteria() != null) {
            _hashCode += getPaymentCriteria().hashCode();
        }
        if (getTranDateRange() != null) {
            _hashCode += getTranDateRange().hashCode();
        }
        if (getChequeDateRange() != null) {
            _hashCode += getChequeDateRange().hashCode();
        }
        if (getHostName() != null) {
            _hashCode += getHostName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FindInboundPaymentByCriteria.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "findInboundPaymentByCriteria"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paymentCriteria");
        elemField.setXmlName(new javax.xml.namespace.QName("", "paymentCriteria"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "basePayment"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tranDateRange");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tranDateRange"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "dateRange"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("chequeDateRange");
        elemField.setXmlName(new javax.xml.namespace.QName("", "chequeDateRange"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "dateRange"));
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
