/**
 * PaymentSourceConstants.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.leadway.projects.payment.endpoint;

public class PaymentSourceConstants  implements java.io.Serializable {
    private java.lang.String cashierSource;

    private java.lang.String cashierSourceBankMode;

    private java.lang.String ddmSource;

    private java.lang.String interswitchSource;

    public PaymentSourceConstants() {
    }

    public PaymentSourceConstants(
           java.lang.String cashierSource,
           java.lang.String cashierSourceBankMode,
           java.lang.String ddmSource,
           java.lang.String interswitchSource) {
           this.cashierSource = cashierSource;
           this.cashierSourceBankMode = cashierSourceBankMode;
           this.ddmSource = ddmSource;
           this.interswitchSource = interswitchSource;
    }


    /**
     * Gets the cashierSource value for this PaymentSourceConstants.
     * 
     * @return cashierSource
     */
    public java.lang.String getCashierSource() {
        return cashierSource;
    }


    /**
     * Sets the cashierSource value for this PaymentSourceConstants.
     * 
     * @param cashierSource
     */
    public void setCashierSource(java.lang.String cashierSource) {
        this.cashierSource = cashierSource;
    }


    /**
     * Gets the cashierSourceBankMode value for this PaymentSourceConstants.
     * 
     * @return cashierSourceBankMode
     */
    public java.lang.String getCashierSourceBankMode() {
        return cashierSourceBankMode;
    }


    /**
     * Sets the cashierSourceBankMode value for this PaymentSourceConstants.
     * 
     * @param cashierSourceBankMode
     */
    public void setCashierSourceBankMode(java.lang.String cashierSourceBankMode) {
        this.cashierSourceBankMode = cashierSourceBankMode;
    }


    /**
     * Gets the ddmSource value for this PaymentSourceConstants.
     * 
     * @return ddmSource
     */
    public java.lang.String getDdmSource() {
        return ddmSource;
    }


    /**
     * Sets the ddmSource value for this PaymentSourceConstants.
     * 
     * @param ddmSource
     */
    public void setDdmSource(java.lang.String ddmSource) {
        this.ddmSource = ddmSource;
    }


    /**
     * Gets the interswitchSource value for this PaymentSourceConstants.
     * 
     * @return interswitchSource
     */
    public java.lang.String getInterswitchSource() {
        return interswitchSource;
    }


    /**
     * Sets the interswitchSource value for this PaymentSourceConstants.
     * 
     * @param interswitchSource
     */
    public void setInterswitchSource(java.lang.String interswitchSource) {
        this.interswitchSource = interswitchSource;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PaymentSourceConstants)) return false;
        PaymentSourceConstants other = (PaymentSourceConstants) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cashierSource==null && other.getCashierSource()==null) || 
             (this.cashierSource!=null &&
              this.cashierSource.equals(other.getCashierSource()))) &&
            ((this.cashierSourceBankMode==null && other.getCashierSourceBankMode()==null) || 
             (this.cashierSourceBankMode!=null &&
              this.cashierSourceBankMode.equals(other.getCashierSourceBankMode()))) &&
            ((this.ddmSource==null && other.getDdmSource()==null) || 
             (this.ddmSource!=null &&
              this.ddmSource.equals(other.getDdmSource()))) &&
            ((this.interswitchSource==null && other.getInterswitchSource()==null) || 
             (this.interswitchSource!=null &&
              this.interswitchSource.equals(other.getInterswitchSource())));
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
        if (getCashierSource() != null) {
            _hashCode += getCashierSource().hashCode();
        }
        if (getCashierSourceBankMode() != null) {
            _hashCode += getCashierSourceBankMode().hashCode();
        }
        if (getDdmSource() != null) {
            _hashCode += getDdmSource().hashCode();
        }
        if (getInterswitchSource() != null) {
            _hashCode += getInterswitchSource().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PaymentSourceConstants.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "paymentSourceConstants"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cashierSource");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cashierSource"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cashierSourceBankMode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cashierSourceBankMode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ddmSource");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ddmSource"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("interswitchSource");
        elemField.setXmlName(new javax.xml.namespace.QName("", "interswitchSource"));
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
