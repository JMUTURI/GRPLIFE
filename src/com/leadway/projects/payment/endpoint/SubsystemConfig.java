/**
 * SubsystemConfig.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.leadway.projects.payment.endpoint;

public class SubsystemConfig  implements java.io.Serializable {
    private java.lang.String databaseMetaName;

    private java.lang.String defaultNarration;

    private java.lang.String subsystem;

    private java.lang.String subsystemUrl;

    private java.util.Calendar timeOfLastVisit;

    private java.lang.String tranConfigCode;

    public SubsystemConfig() {
    }

    public SubsystemConfig(
           java.lang.String databaseMetaName,
           java.lang.String defaultNarration,
           java.lang.String subsystem,
           java.lang.String subsystemUrl,
           java.util.Calendar timeOfLastVisit,
           java.lang.String tranConfigCode) {
           this.databaseMetaName = databaseMetaName;
           this.defaultNarration = defaultNarration;
           this.subsystem = subsystem;
           this.subsystemUrl = subsystemUrl;
           this.timeOfLastVisit = timeOfLastVisit;
           this.tranConfigCode = tranConfigCode;
    }


    /**
     * Gets the databaseMetaName value for this SubsystemConfig.
     * 
     * @return databaseMetaName
     */
    public java.lang.String getDatabaseMetaName() {
        return databaseMetaName;
    }


    /**
     * Sets the databaseMetaName value for this SubsystemConfig.
     * 
     * @param databaseMetaName
     */
    public void setDatabaseMetaName(java.lang.String databaseMetaName) {
        this.databaseMetaName = databaseMetaName;
    }


    /**
     * Gets the defaultNarration value for this SubsystemConfig.
     * 
     * @return defaultNarration
     */
    public java.lang.String getDefaultNarration() {
        return defaultNarration;
    }


    /**
     * Sets the defaultNarration value for this SubsystemConfig.
     * 
     * @param defaultNarration
     */
    public void setDefaultNarration(java.lang.String defaultNarration) {
        this.defaultNarration = defaultNarration;
    }


    /**
     * Gets the subsystem value for this SubsystemConfig.
     * 
     * @return subsystem
     */
    public java.lang.String getSubsystem() {
        return subsystem;
    }


    /**
     * Sets the subsystem value for this SubsystemConfig.
     * 
     * @param subsystem
     */
    public void setSubsystem(java.lang.String subsystem) {
        this.subsystem = subsystem;
    }


    /**
     * Gets the subsystemUrl value for this SubsystemConfig.
     * 
     * @return subsystemUrl
     */
    public java.lang.String getSubsystemUrl() {
        return subsystemUrl;
    }


    /**
     * Sets the subsystemUrl value for this SubsystemConfig.
     * 
     * @param subsystemUrl
     */
    public void setSubsystemUrl(java.lang.String subsystemUrl) {
        this.subsystemUrl = subsystemUrl;
    }


    /**
     * Gets the timeOfLastVisit value for this SubsystemConfig.
     * 
     * @return timeOfLastVisit
     */
    public java.util.Calendar getTimeOfLastVisit() {
        return timeOfLastVisit;
    }


    /**
     * Sets the timeOfLastVisit value for this SubsystemConfig.
     * 
     * @param timeOfLastVisit
     */
    public void setTimeOfLastVisit(java.util.Calendar timeOfLastVisit) {
        this.timeOfLastVisit = timeOfLastVisit;
    }


    /**
     * Gets the tranConfigCode value for this SubsystemConfig.
     * 
     * @return tranConfigCode
     */
    public java.lang.String getTranConfigCode() {
        return tranConfigCode;
    }


    /**
     * Sets the tranConfigCode value for this SubsystemConfig.
     * 
     * @param tranConfigCode
     */
    public void setTranConfigCode(java.lang.String tranConfigCode) {
        this.tranConfigCode = tranConfigCode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SubsystemConfig)) return false;
        SubsystemConfig other = (SubsystemConfig) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.databaseMetaName==null && other.getDatabaseMetaName()==null) || 
             (this.databaseMetaName!=null &&
              this.databaseMetaName.equals(other.getDatabaseMetaName()))) &&
            ((this.defaultNarration==null && other.getDefaultNarration()==null) || 
             (this.defaultNarration!=null &&
              this.defaultNarration.equals(other.getDefaultNarration()))) &&
            ((this.subsystem==null && other.getSubsystem()==null) || 
             (this.subsystem!=null &&
              this.subsystem.equals(other.getSubsystem()))) &&
            ((this.subsystemUrl==null && other.getSubsystemUrl()==null) || 
             (this.subsystemUrl!=null &&
              this.subsystemUrl.equals(other.getSubsystemUrl()))) &&
            ((this.timeOfLastVisit==null && other.getTimeOfLastVisit()==null) || 
             (this.timeOfLastVisit!=null &&
              this.timeOfLastVisit.equals(other.getTimeOfLastVisit()))) &&
            ((this.tranConfigCode==null && other.getTranConfigCode()==null) || 
             (this.tranConfigCode!=null &&
              this.tranConfigCode.equals(other.getTranConfigCode())));
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
        if (getDatabaseMetaName() != null) {
            _hashCode += getDatabaseMetaName().hashCode();
        }
        if (getDefaultNarration() != null) {
            _hashCode += getDefaultNarration().hashCode();
        }
        if (getSubsystem() != null) {
            _hashCode += getSubsystem().hashCode();
        }
        if (getSubsystemUrl() != null) {
            _hashCode += getSubsystemUrl().hashCode();
        }
        if (getTimeOfLastVisit() != null) {
            _hashCode += getTimeOfLastVisit().hashCode();
        }
        if (getTranConfigCode() != null) {
            _hashCode += getTranConfigCode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SubsystemConfig.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "subsystemConfig"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("databaseMetaName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "databaseMetaName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("defaultNarration");
        elemField.setXmlName(new javax.xml.namespace.QName("", "defaultNarration"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subsystem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "subsystem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subsystemUrl");
        elemField.setXmlName(new javax.xml.namespace.QName("", "subsystemUrl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timeOfLastVisit");
        elemField.setXmlName(new javax.xml.namespace.QName("", "timeOfLastVisit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tranConfigCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tranConfigCode"));
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
