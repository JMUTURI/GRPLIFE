/**
 * FindDebitCreditNoteByCriteria.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.leadway.projects.payment.endpoint;

public class FindDebitCreditNoteByCriteria  implements java.io.Serializable {
    private com.leadway.projects.payment.endpoint.DebitCreditNote debitNoteCriteria;

    private java.lang.String hostName;

    public FindDebitCreditNoteByCriteria() {
    }

    public FindDebitCreditNoteByCriteria(
           com.leadway.projects.payment.endpoint.DebitCreditNote debitNoteCriteria,
           java.lang.String hostName) {
           this.debitNoteCriteria = debitNoteCriteria;
           this.hostName = hostName;
    }


    /**
     * Gets the debitNoteCriteria value for this FindDebitCreditNoteByCriteria.
     * 
     * @return debitNoteCriteria
     */
    public com.leadway.projects.payment.endpoint.DebitCreditNote getDebitNoteCriteria() {
        return debitNoteCriteria;
    }


    /**
     * Sets the debitNoteCriteria value for this FindDebitCreditNoteByCriteria.
     * 
     * @param debitNoteCriteria
     */
    public void setDebitNoteCriteria(com.leadway.projects.payment.endpoint.DebitCreditNote debitNoteCriteria) {
        this.debitNoteCriteria = debitNoteCriteria;
    }


    /**
     * Gets the hostName value for this FindDebitCreditNoteByCriteria.
     * 
     * @return hostName
     */
    public java.lang.String getHostName() {
        return hostName;
    }


    /**
     * Sets the hostName value for this FindDebitCreditNoteByCriteria.
     * 
     * @param hostName
     */
    public void setHostName(java.lang.String hostName) {
        this.hostName = hostName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FindDebitCreditNoteByCriteria)) return false;
        FindDebitCreditNoteByCriteria other = (FindDebitCreditNoteByCriteria) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.debitNoteCriteria==null && other.getDebitNoteCriteria()==null) || 
             (this.debitNoteCriteria!=null &&
              this.debitNoteCriteria.equals(other.getDebitNoteCriteria()))) &&
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
        if (getDebitNoteCriteria() != null) {
            _hashCode += getDebitNoteCriteria().hashCode();
        }
        if (getHostName() != null) {
            _hashCode += getHostName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FindDebitCreditNoteByCriteria.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "findDebitCreditNoteByCriteria"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("debitNoteCriteria");
        elemField.setXmlName(new javax.xml.namespace.QName("", "debitNoteCriteria"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "debitCreditNote"));
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
