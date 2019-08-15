/**
 * UserAccount.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.leadway.projects.payment.endpoint;

public class UserAccount  extends com.leadway.projects.payment.endpoint.Account  implements java.io.Serializable {
    private java.lang.String dateOfLastPasswordChange;

    private java.lang.String emailAddress;

    private boolean passwordExpired;

    private java.lang.String[] previousPasswordList;

    private java.lang.String roleName;

    public UserAccount() {
    }

    public UserAccount(
           boolean deleted,
           java.lang.String password,
           java.lang.String userName,
           java.lang.String dateOfLastPasswordChange,
           java.lang.String emailAddress,
           boolean passwordExpired,
           java.lang.String[] previousPasswordList,
           java.lang.String roleName) {
        super(
            deleted,
            password,
            userName);
        this.dateOfLastPasswordChange = dateOfLastPasswordChange;
        this.emailAddress = emailAddress;
        this.passwordExpired = passwordExpired;
        this.previousPasswordList = previousPasswordList;
        this.roleName = roleName;
    }


    /**
     * Gets the dateOfLastPasswordChange value for this UserAccount.
     * 
     * @return dateOfLastPasswordChange
     */
    public java.lang.String getDateOfLastPasswordChange() {
        return dateOfLastPasswordChange;
    }


    /**
     * Sets the dateOfLastPasswordChange value for this UserAccount.
     * 
     * @param dateOfLastPasswordChange
     */
    public void setDateOfLastPasswordChange(java.lang.String dateOfLastPasswordChange) {
        this.dateOfLastPasswordChange = dateOfLastPasswordChange;
    }


    /**
     * Gets the emailAddress value for this UserAccount.
     * 
     * @return emailAddress
     */
    public java.lang.String getEmailAddress() {
        return emailAddress;
    }


    /**
     * Sets the emailAddress value for this UserAccount.
     * 
     * @param emailAddress
     */
    public void setEmailAddress(java.lang.String emailAddress) {
        this.emailAddress = emailAddress;
    }


    /**
     * Gets the passwordExpired value for this UserAccount.
     * 
     * @return passwordExpired
     */
    public boolean isPasswordExpired() {
        return passwordExpired;
    }


    /**
     * Sets the passwordExpired value for this UserAccount.
     * 
     * @param passwordExpired
     */
    public void setPasswordExpired(boolean passwordExpired) {
        this.passwordExpired = passwordExpired;
    }


    /**
     * Gets the previousPasswordList value for this UserAccount.
     * 
     * @return previousPasswordList
     */
    public java.lang.String[] getPreviousPasswordList() {
        return previousPasswordList;
    }


    /**
     * Sets the previousPasswordList value for this UserAccount.
     * 
     * @param previousPasswordList
     */
    public void setPreviousPasswordList(java.lang.String[] previousPasswordList) {
        this.previousPasswordList = previousPasswordList;
    }

    public java.lang.String getPreviousPasswordList(int i) {
        return this.previousPasswordList[i];
    }

    public void setPreviousPasswordList(int i, java.lang.String _value) {
        this.previousPasswordList[i] = _value;
    }


    /**
     * Gets the roleName value for this UserAccount.
     * 
     * @return roleName
     */
    public java.lang.String getRoleName() {
        return roleName;
    }


    /**
     * Sets the roleName value for this UserAccount.
     * 
     * @param roleName
     */
    public void setRoleName(java.lang.String roleName) {
        this.roleName = roleName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UserAccount)) return false;
        UserAccount other = (UserAccount) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dateOfLastPasswordChange==null && other.getDateOfLastPasswordChange()==null) || 
             (this.dateOfLastPasswordChange!=null &&
              this.dateOfLastPasswordChange.equals(other.getDateOfLastPasswordChange()))) &&
            ((this.emailAddress==null && other.getEmailAddress()==null) || 
             (this.emailAddress!=null &&
              this.emailAddress.equals(other.getEmailAddress()))) &&
            this.passwordExpired == other.isPasswordExpired() &&
            ((this.previousPasswordList==null && other.getPreviousPasswordList()==null) || 
             (this.previousPasswordList!=null &&
              java.util.Arrays.equals(this.previousPasswordList, other.getPreviousPasswordList()))) &&
            ((this.roleName==null && other.getRoleName()==null) || 
             (this.roleName!=null &&
              this.roleName.equals(other.getRoleName())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getDateOfLastPasswordChange() != null) {
            _hashCode += getDateOfLastPasswordChange().hashCode();
        }
        if (getEmailAddress() != null) {
            _hashCode += getEmailAddress().hashCode();
        }
        _hashCode += (isPasswordExpired() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getPreviousPasswordList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPreviousPasswordList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPreviousPasswordList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getRoleName() != null) {
            _hashCode += getRoleName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UserAccount.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "userAccount"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dateOfLastPasswordChange");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dateOfLastPasswordChange"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("emailAddress");
        elemField.setXmlName(new javax.xml.namespace.QName("", "emailAddress"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("passwordExpired");
        elemField.setXmlName(new javax.xml.namespace.QName("", "passwordExpired"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("previousPasswordList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "previousPasswordList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("roleName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "roleName"));
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
