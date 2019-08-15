/**
 * FindInboundPaymentByReceiptNumberList.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.leadway.projects.payment.endpoint;

public class FindInboundPaymentByReceiptNumberList  implements java.io.Serializable {
    private java.lang.String[] receiptNumberList;

    private java.lang.String hostName;

    public FindInboundPaymentByReceiptNumberList() {
    }

    public FindInboundPaymentByReceiptNumberList(
           java.lang.String[] receiptNumberList,
           java.lang.String hostName) {
           this.receiptNumberList = receiptNumberList;
           this.hostName = hostName;
    }


    /**
     * Gets the receiptNumberList value for this FindInboundPaymentByReceiptNumberList.
     * 
     * @return receiptNumberList
     */
    public java.lang.String[] getReceiptNumberList() {
        return receiptNumberList;
    }


    /**
     * Sets the receiptNumberList value for this FindInboundPaymentByReceiptNumberList.
     * 
     * @param receiptNumberList
     */
    public void setReceiptNumberList(java.lang.String[] receiptNumberList) {
        this.receiptNumberList = receiptNumberList;
    }

    public java.lang.String getReceiptNumberList(int i) {
        return this.receiptNumberList[i];
    }

    public void setReceiptNumberList(int i, java.lang.String _value) {
        this.receiptNumberList[i] = _value;
    }


    /**
     * Gets the hostName value for this FindInboundPaymentByReceiptNumberList.
     * 
     * @return hostName
     */
    public java.lang.String getHostName() {
        return hostName;
    }


    /**
     * Sets the hostName value for this FindInboundPaymentByReceiptNumberList.
     * 
     * @param hostName
     */
    public void setHostName(java.lang.String hostName) {
        this.hostName = hostName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FindInboundPaymentByReceiptNumberList)) return false;
        FindInboundPaymentByReceiptNumberList other = (FindInboundPaymentByReceiptNumberList) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.receiptNumberList==null && other.getReceiptNumberList()==null) || 
             (this.receiptNumberList!=null &&
              java.util.Arrays.equals(this.receiptNumberList, other.getReceiptNumberList()))) &&
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
        if (getReceiptNumberList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getReceiptNumberList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getReceiptNumberList(), i);
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
        new org.apache.axis.description.TypeDesc(FindInboundPaymentByReceiptNumberList.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "findInboundPaymentByReceiptNumberList"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("receiptNumberList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "receiptNumberList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
