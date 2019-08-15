/**
 * DummyMethod.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.leadway.projects.payment.endpoint;

public class DummyMethod  implements java.io.Serializable {
    private com.leadway.projects.payment.endpoint.Subsystem subsystem;

    private com.leadway.projects.payment.endpoint.ExceptionMessage exceptionMssg;

    private com.leadway.projects.payment.endpoint.BankPaymentForDC bankPayment;

    private com.leadway.projects.payment.endpoint.PaymentForDC paymentForDC;

    private com.leadway.projects.payment.endpoint.IsPayment isPayment;

    public DummyMethod() {
    }

    public DummyMethod(
           com.leadway.projects.payment.endpoint.Subsystem subsystem,
           com.leadway.projects.payment.endpoint.ExceptionMessage exceptionMssg,
           com.leadway.projects.payment.endpoint.BankPaymentForDC bankPayment,
           com.leadway.projects.payment.endpoint.PaymentForDC paymentForDC,
           com.leadway.projects.payment.endpoint.IsPayment isPayment) {
           this.subsystem = subsystem;
           this.exceptionMssg = exceptionMssg;
           this.bankPayment = bankPayment;
           this.paymentForDC = paymentForDC;
           this.isPayment = isPayment;
    }


    /**
     * Gets the subsystem value for this DummyMethod.
     * 
     * @return subsystem
     */
    public com.leadway.projects.payment.endpoint.Subsystem getSubsystem() {
        return subsystem;
    }


    /**
     * Sets the subsystem value for this DummyMethod.
     * 
     * @param subsystem
     */
    public void setSubsystem(com.leadway.projects.payment.endpoint.Subsystem subsystem) {
        this.subsystem = subsystem;
    }


    /**
     * Gets the exceptionMssg value for this DummyMethod.
     * 
     * @return exceptionMssg
     */
    public com.leadway.projects.payment.endpoint.ExceptionMessage getExceptionMssg() {
        return exceptionMssg;
    }


    /**
     * Sets the exceptionMssg value for this DummyMethod.
     * 
     * @param exceptionMssg
     */
    public void setExceptionMssg(com.leadway.projects.payment.endpoint.ExceptionMessage exceptionMssg) {
        this.exceptionMssg = exceptionMssg;
    }


    /**
     * Gets the bankPayment value for this DummyMethod.
     * 
     * @return bankPayment
     */
    public com.leadway.projects.payment.endpoint.BankPaymentForDC getBankPayment() {
        return bankPayment;
    }


    /**
     * Sets the bankPayment value for this DummyMethod.
     * 
     * @param bankPayment
     */
    public void setBankPayment(com.leadway.projects.payment.endpoint.BankPaymentForDC bankPayment) {
        this.bankPayment = bankPayment;
    }


    /**
     * Gets the paymentForDC value for this DummyMethod.
     * 
     * @return paymentForDC
     */
    public com.leadway.projects.payment.endpoint.PaymentForDC getPaymentForDC() {
        return paymentForDC;
    }


    /**
     * Sets the paymentForDC value for this DummyMethod.
     * 
     * @param paymentForDC
     */
    public void setPaymentForDC(com.leadway.projects.payment.endpoint.PaymentForDC paymentForDC) {
        this.paymentForDC = paymentForDC;
    }


    /**
     * Gets the isPayment value for this DummyMethod.
     * 
     * @return isPayment
     */
    public com.leadway.projects.payment.endpoint.IsPayment getIsPayment() {
        return isPayment;
    }


    /**
     * Sets the isPayment value for this DummyMethod.
     * 
     * @param isPayment
     */
    public void setIsPayment(com.leadway.projects.payment.endpoint.IsPayment isPayment) {
        this.isPayment = isPayment;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DummyMethod)) return false;
        DummyMethod other = (DummyMethod) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.subsystem==null && other.getSubsystem()==null) || 
             (this.subsystem!=null &&
              this.subsystem.equals(other.getSubsystem()))) &&
            ((this.exceptionMssg==null && other.getExceptionMssg()==null) || 
             (this.exceptionMssg!=null &&
              this.exceptionMssg.equals(other.getExceptionMssg()))) &&
            ((this.bankPayment==null && other.getBankPayment()==null) || 
             (this.bankPayment!=null &&
              this.bankPayment.equals(other.getBankPayment()))) &&
            ((this.paymentForDC==null && other.getPaymentForDC()==null) || 
             (this.paymentForDC!=null &&
              this.paymentForDC.equals(other.getPaymentForDC()))) &&
            ((this.isPayment==null && other.getIsPayment()==null) || 
             (this.isPayment!=null &&
              this.isPayment.equals(other.getIsPayment())));
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
        if (getSubsystem() != null) {
            _hashCode += getSubsystem().hashCode();
        }
        if (getExceptionMssg() != null) {
            _hashCode += getExceptionMssg().hashCode();
        }
        if (getBankPayment() != null) {
            _hashCode += getBankPayment().hashCode();
        }
        if (getPaymentForDC() != null) {
            _hashCode += getPaymentForDC().hashCode();
        }
        if (getIsPayment() != null) {
            _hashCode += getIsPayment().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DummyMethod.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "dummyMethod"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subsystem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "subsystem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "subsystem"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("exceptionMssg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "exceptionMssg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "exceptionMessage"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bankPayment");
        elemField.setXmlName(new javax.xml.namespace.QName("", "bankPayment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "bankPaymentForDC"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paymentForDC");
        elemField.setXmlName(new javax.xml.namespace.QName("", "paymentForDC"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "paymentForDC"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isPayment");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isPayment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "isPayment"));
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
