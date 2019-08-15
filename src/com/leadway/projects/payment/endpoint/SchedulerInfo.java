/**
 * SchedulerInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.leadway.projects.payment.endpoint;

public class SchedulerInfo  implements java.io.Serializable {
    private int timeInterval;

    private java.lang.String timeOfLastSchedule;

    public SchedulerInfo() {
    }

    public SchedulerInfo(
           int timeInterval,
           java.lang.String timeOfLastSchedule) {
           this.timeInterval = timeInterval;
           this.timeOfLastSchedule = timeOfLastSchedule;
    }


    /**
     * Gets the timeInterval value for this SchedulerInfo.
     * 
     * @return timeInterval
     */
    public int getTimeInterval() {
        return timeInterval;
    }


    /**
     * Sets the timeInterval value for this SchedulerInfo.
     * 
     * @param timeInterval
     */
    public void setTimeInterval(int timeInterval) {
        this.timeInterval = timeInterval;
    }


    /**
     * Gets the timeOfLastSchedule value for this SchedulerInfo.
     * 
     * @return timeOfLastSchedule
     */
    public java.lang.String getTimeOfLastSchedule() {
        return timeOfLastSchedule;
    }


    /**
     * Sets the timeOfLastSchedule value for this SchedulerInfo.
     * 
     * @param timeOfLastSchedule
     */
    public void setTimeOfLastSchedule(java.lang.String timeOfLastSchedule) {
        this.timeOfLastSchedule = timeOfLastSchedule;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SchedulerInfo)) return false;
        SchedulerInfo other = (SchedulerInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.timeInterval == other.getTimeInterval() &&
            ((this.timeOfLastSchedule==null && other.getTimeOfLastSchedule()==null) || 
             (this.timeOfLastSchedule!=null &&
              this.timeOfLastSchedule.equals(other.getTimeOfLastSchedule())));
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
        _hashCode += getTimeInterval();
        if (getTimeOfLastSchedule() != null) {
            _hashCode += getTimeOfLastSchedule().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SchedulerInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "schedulerInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timeInterval");
        elemField.setXmlName(new javax.xml.namespace.QName("", "timeInterval"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timeOfLastSchedule");
        elemField.setXmlName(new javax.xml.namespace.QName("", "timeOfLastSchedule"));
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
