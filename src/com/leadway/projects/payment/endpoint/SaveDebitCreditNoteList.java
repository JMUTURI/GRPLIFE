/**
 * SaveDebitCreditNoteList.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.leadway.projects.payment.endpoint;

public class SaveDebitCreditNoteList  implements java.io.Serializable {
    private com.leadway.projects.payment.endpoint.DebitCreditNote[] dcNoteList;

    private java.lang.String configCode;

    private java.lang.String hostName;

    public SaveDebitCreditNoteList() {
    }

    public SaveDebitCreditNoteList(
           com.leadway.projects.payment.endpoint.DebitCreditNote[] dcNoteList,
           java.lang.String configCode,
           java.lang.String hostName) {
           this.dcNoteList = dcNoteList;
           this.configCode = configCode;
           this.hostName = hostName;
    }


    /**
     * Gets the dcNoteList value for this SaveDebitCreditNoteList.
     * 
     * @return dcNoteList
     */
    public com.leadway.projects.payment.endpoint.DebitCreditNote[] getDcNoteList() {
        return dcNoteList;
    }


    /**
     * Sets the dcNoteList value for this SaveDebitCreditNoteList.
     * 
     * @param dcNoteList
     */
    public void setDcNoteList(com.leadway.projects.payment.endpoint.DebitCreditNote[] dcNoteList) {
        this.dcNoteList = dcNoteList;
    }

    public com.leadway.projects.payment.endpoint.DebitCreditNote getDcNoteList(int i) {
        return this.dcNoteList[i];
    }

    public void setDcNoteList(int i, com.leadway.projects.payment.endpoint.DebitCreditNote _value) {
        this.dcNoteList[i] = _value;
    }


    /**
     * Gets the configCode value for this SaveDebitCreditNoteList.
     * 
     * @return configCode
     */
    public java.lang.String getConfigCode() {
        return configCode;
    }


    /**
     * Sets the configCode value for this SaveDebitCreditNoteList.
     * 
     * @param configCode
     */
    public void setConfigCode(java.lang.String configCode) {
        this.configCode = configCode;
    }


    /**
     * Gets the hostName value for this SaveDebitCreditNoteList.
     * 
     * @return hostName
     */
    public java.lang.String getHostName() {
        return hostName;
    }


    /**
     * Sets the hostName value for this SaveDebitCreditNoteList.
     * 
     * @param hostName
     */
    public void setHostName(java.lang.String hostName) {
        this.hostName = hostName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SaveDebitCreditNoteList)) return false;
        SaveDebitCreditNoteList other = (SaveDebitCreditNoteList) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dcNoteList==null && other.getDcNoteList()==null) || 
             (this.dcNoteList!=null &&
              java.util.Arrays.equals(this.dcNoteList, other.getDcNoteList()))) &&
            ((this.configCode==null && other.getConfigCode()==null) || 
             (this.configCode!=null &&
              this.configCode.equals(other.getConfigCode()))) &&
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
        if (getDcNoteList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDcNoteList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDcNoteList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getConfigCode() != null) {
            _hashCode += getConfigCode().hashCode();
        }
        if (getHostName() != null) {
            _hashCode += getHostName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SaveDebitCreditNoteList.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "saveDebitCreditNoteList"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dcNoteList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dcNoteList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "debitCreditNote"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("configCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "configCode"));
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
