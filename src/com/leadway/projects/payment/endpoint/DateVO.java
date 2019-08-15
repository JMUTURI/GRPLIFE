/**
 * DateVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.leadway.projects.payment.endpoint;

public class DateVO  implements java.io.Serializable {
    private java.util.Calendar date;

    private java.lang.String dateAsString;

    private com.leadway.projects.payment.endpoint.DateBean dateBeanHandle;

    private boolean synchUpdate;

    public DateVO() {
    }

    public DateVO(
           java.util.Calendar date,
           java.lang.String dateAsString,
           com.leadway.projects.payment.endpoint.DateBean dateBeanHandle,
           boolean synchUpdate) {
           this.date = date;
           this.dateAsString = dateAsString;
           this.dateBeanHandle = dateBeanHandle;
           this.synchUpdate = synchUpdate;
    }


    /**
     * Gets the date value for this DateVO.
     * 
     * @return date
     */
    public java.util.Calendar getDate() {
        return date;
    }


    /**
     * Sets the date value for this DateVO.
     * 
     * @param date
     */
    public void setDate(java.util.Calendar date) {
        this.date = date;
    }


    /**
     * Gets the dateAsString value for this DateVO.
     * 
     * @return dateAsString
     */
    public java.lang.String getDateAsString() {
        return dateAsString;
    }


    /**
     * Sets the dateAsString value for this DateVO.
     * 
     * @param dateAsString
     */
    public void setDateAsString(java.lang.String dateAsString) {
        this.dateAsString = dateAsString;
    }


    /**
     * Gets the dateBeanHandle value for this DateVO.
     * 
     * @return dateBeanHandle
     */
    public com.leadway.projects.payment.endpoint.DateBean getDateBeanHandle() {
        return dateBeanHandle;
    }


    /**
     * Sets the dateBeanHandle value for this DateVO.
     * 
     * @param dateBeanHandle
     */
    public void setDateBeanHandle(com.leadway.projects.payment.endpoint.DateBean dateBeanHandle) {
        this.dateBeanHandle = dateBeanHandle;
    }


    /**
     * Gets the synchUpdate value for this DateVO.
     * 
     * @return synchUpdate
     */
    public boolean isSynchUpdate() {
        return synchUpdate;
    }


    /**
     * Sets the synchUpdate value for this DateVO.
     * 
     * @param synchUpdate
     */
    public void setSynchUpdate(boolean synchUpdate) {
        this.synchUpdate = synchUpdate;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DateVO)) return false;
        DateVO other = (DateVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.date==null && other.getDate()==null) || 
             (this.date!=null &&
              this.date.equals(other.getDate()))) &&
            ((this.dateAsString==null && other.getDateAsString()==null) || 
             (this.dateAsString!=null &&
              this.dateAsString.equals(other.getDateAsString()))) &&
            ((this.dateBeanHandle==null && other.getDateBeanHandle()==null) || 
             (this.dateBeanHandle!=null &&
              this.dateBeanHandle.equals(other.getDateBeanHandle()))) &&
            this.synchUpdate == other.isSynchUpdate();
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
        if (getDate() != null) {
            _hashCode += getDate().hashCode();
        }
        if (getDateAsString() != null) {
            _hashCode += getDateAsString().hashCode();
        }
        if (getDateBeanHandle() != null) {
            _hashCode += getDateBeanHandle().hashCode();
        }
        _hashCode += (isSynchUpdate() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DateVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "dateVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("date");
        elemField.setXmlName(new javax.xml.namespace.QName("", "date"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dateAsString");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dateAsString"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dateBeanHandle");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dateBeanHandle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "dateBean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("synchUpdate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "synchUpdate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
