/**
 * MarkDebitNoteAsNotDeleted.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.leadway.projects.payment.endpoint;

public class MarkDebitNoteAsNotDeleted  implements java.io.Serializable {
    private com.leadway.projects.payment.endpoint.DebitCreditNote debitNote;

    private java.lang.String hostName;

    public MarkDebitNoteAsNotDeleted() {
    }

    public MarkDebitNoteAsNotDeleted(
           com.leadway.projects.payment.endpoint.DebitCreditNote debitNote,
           java.lang.String hostName) {
           this.debitNote = debitNote;
           this.hostName = hostName;
    }


    /**
     * Gets the debitNote value for this MarkDebitNoteAsNotDeleted.
     * 
     * @return debitNote
     */
    public com.leadway.projects.payment.endpoint.DebitCreditNote getDebitNote() {
        return debitNote;
    }


    /**
     * Sets the debitNote value for this MarkDebitNoteAsNotDeleted.
     * 
     * @param debitNote
     */
    public void setDebitNote(com.leadway.projects.payment.endpoint.DebitCreditNote debitNote) {
        this.debitNote = debitNote;
    }


    /**
     * Gets the hostName value for this MarkDebitNoteAsNotDeleted.
     * 
     * @return hostName
     */
    public java.lang.String getHostName() {
        return hostName;
    }


    /**
     * Sets the hostName value for this MarkDebitNoteAsNotDeleted.
     * 
     * @param hostName
     */
    public void setHostName(java.lang.String hostName) {
        this.hostName = hostName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MarkDebitNoteAsNotDeleted)) return false;
        MarkDebitNoteAsNotDeleted other = (MarkDebitNoteAsNotDeleted) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.debitNote==null && other.getDebitNote()==null) || 
             (this.debitNote!=null &&
              this.debitNote.equals(other.getDebitNote()))) &&
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
        if (getDebitNote() != null) {
            _hashCode += getDebitNote().hashCode();
        }
        if (getHostName() != null) {
            _hashCode += getHostName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MarkDebitNoteAsNotDeleted.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "markDebitNoteAsNotDeleted"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("debitNote");
        elemField.setXmlName(new javax.xml.namespace.QName("", "debitNote"));
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
