/**
 * AgencyData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.leadway.pf.service.ws;

public class AgencyData  extends com.leadway.pf.service.ws.BusinessData  implements java.io.Serializable {
    private java.lang.String accountNo;

    private java.lang.String addressLine1;

    private java.lang.String addressLine2;

    private java.lang.String agencyClass;

    private java.lang.String agencyClassCode;

    private java.lang.String agencyCode;

    private java.lang.String agencyGroup;

    private java.lang.String agencyGroupCode;

    private java.lang.Long agencyId;

    private java.lang.String agencyName;

    private java.lang.String agencyType;

    private java.lang.String agencyTypeCode;

    private java.lang.String bank;

    private java.lang.String branchCode;

    private java.lang.String businessClassCode;

    private java.lang.Long cityId;

    private java.lang.String cityName;

    private java.lang.String creditLimit;

    private java.lang.Short creditLimitCode;

    private java.lang.String csdCode;

    private java.lang.String email;

    private java.lang.String mobileNumber;

    private java.lang.String phoneNumber;

    private java.lang.String registrationNumber;

    private java.util.Calendar renewalDate;

    private java.lang.String sortCode;

    private java.lang.String state;

    public AgencyData() {
    }

    public AgencyData(
           java.util.Calendar createDate,
           java.lang.String createdBy,
           boolean deleted,
           boolean editable,
           boolean selected,
           java.lang.String status,
           java.lang.String statusDesc,
           java.lang.Short version,
           java.lang.String accountNo,
           java.lang.String addressLine1,
           java.lang.String addressLine2,
           java.lang.String agencyClass,
           java.lang.String agencyClassCode,
           java.lang.String agencyCode,
           java.lang.String agencyGroup,
           java.lang.String agencyGroupCode,
           java.lang.Long agencyId,
           java.lang.String agencyName,
           java.lang.String agencyType,
           java.lang.String agencyTypeCode,
           java.lang.String bank,
           java.lang.String branchCode,
           java.lang.String businessClassCode,
           java.lang.Long cityId,
           java.lang.String cityName,
           java.lang.String creditLimit,
           java.lang.Short creditLimitCode,
           java.lang.String csdCode,
           java.lang.String email,
           java.lang.String mobileNumber,
           java.lang.String phoneNumber,
           java.lang.String registrationNumber,
           java.util.Calendar renewalDate,
           java.lang.String sortCode,
           java.lang.String state) {
        super(
            createDate,
            createdBy,
            deleted,
            editable,
            selected,
            status,
            statusDesc,
            version);
        this.accountNo = accountNo;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.agencyClass = agencyClass;
        this.agencyClassCode = agencyClassCode;
        this.agencyCode = agencyCode;
        this.agencyGroup = agencyGroup;
        this.agencyGroupCode = agencyGroupCode;
        this.agencyId = agencyId;
        this.agencyName = agencyName;
        this.agencyType = agencyType;
        this.agencyTypeCode = agencyTypeCode;
        this.bank = bank;
        this.branchCode = branchCode;
        this.businessClassCode = businessClassCode;
        this.cityId = cityId;
        this.cityName = cityName;
        this.creditLimit = creditLimit;
        this.creditLimitCode = creditLimitCode;
        this.csdCode = csdCode;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.phoneNumber = phoneNumber;
        this.registrationNumber = registrationNumber;
        this.renewalDate = renewalDate;
        this.sortCode = sortCode;
        this.state = state;
    }


    /**
     * Gets the accountNo value for this AgencyData.
     * 
     * @return accountNo
     */
    public java.lang.String getAccountNo() {
        return accountNo;
    }


    /**
     * Sets the accountNo value for this AgencyData.
     * 
     * @param accountNo
     */
    public void setAccountNo(java.lang.String accountNo) {
        this.accountNo = accountNo;
    }


    /**
     * Gets the addressLine1 value for this AgencyData.
     * 
     * @return addressLine1
     */
    public java.lang.String getAddressLine1() {
        return addressLine1;
    }


    /**
     * Sets the addressLine1 value for this AgencyData.
     * 
     * @param addressLine1
     */
    public void setAddressLine1(java.lang.String addressLine1) {
        this.addressLine1 = addressLine1;
    }


    /**
     * Gets the addressLine2 value for this AgencyData.
     * 
     * @return addressLine2
     */
    public java.lang.String getAddressLine2() {
        return addressLine2;
    }


    /**
     * Sets the addressLine2 value for this AgencyData.
     * 
     * @param addressLine2
     */
    public void setAddressLine2(java.lang.String addressLine2) {
        this.addressLine2 = addressLine2;
    }


    /**
     * Gets the agencyClass value for this AgencyData.
     * 
     * @return agencyClass
     */
    public java.lang.String getAgencyClass() {
        return agencyClass;
    }


    /**
     * Sets the agencyClass value for this AgencyData.
     * 
     * @param agencyClass
     */
    public void setAgencyClass(java.lang.String agencyClass) {
        this.agencyClass = agencyClass;
    }


    /**
     * Gets the agencyClassCode value for this AgencyData.
     * 
     * @return agencyClassCode
     */
    public java.lang.String getAgencyClassCode() {
        return agencyClassCode;
    }


    /**
     * Sets the agencyClassCode value for this AgencyData.
     * 
     * @param agencyClassCode
     */
    public void setAgencyClassCode(java.lang.String agencyClassCode) {
        this.agencyClassCode = agencyClassCode;
    }


    /**
     * Gets the agencyCode value for this AgencyData.
     * 
     * @return agencyCode
     */
    public java.lang.String getAgencyCode() {
        return agencyCode;
    }


    /**
     * Sets the agencyCode value for this AgencyData.
     * 
     * @param agencyCode
     */
    public void setAgencyCode(java.lang.String agencyCode) {
        this.agencyCode = agencyCode;
    }


    /**
     * Gets the agencyGroup value for this AgencyData.
     * 
     * @return agencyGroup
     */
    public java.lang.String getAgencyGroup() {
        return agencyGroup;
    }


    /**
     * Sets the agencyGroup value for this AgencyData.
     * 
     * @param agencyGroup
     */
    public void setAgencyGroup(java.lang.String agencyGroup) {
        this.agencyGroup = agencyGroup;
    }


    /**
     * Gets the agencyGroupCode value for this AgencyData.
     * 
     * @return agencyGroupCode
     */
    public java.lang.String getAgencyGroupCode() {
        return agencyGroupCode;
    }


    /**
     * Sets the agencyGroupCode value for this AgencyData.
     * 
     * @param agencyGroupCode
     */
    public void setAgencyGroupCode(java.lang.String agencyGroupCode) {
        this.agencyGroupCode = agencyGroupCode;
    }


    /**
     * Gets the agencyId value for this AgencyData.
     * 
     * @return agencyId
     */
    public java.lang.Long getAgencyId() {
        return agencyId;
    }


    /**
     * Sets the agencyId value for this AgencyData.
     * 
     * @param agencyId
     */
    public void setAgencyId(java.lang.Long agencyId) {
        this.agencyId = agencyId;
    }


    /**
     * Gets the agencyName value for this AgencyData.
     * 
     * @return agencyName
     */
    public java.lang.String getAgencyName() {
        return agencyName;
    }


    /**
     * Sets the agencyName value for this AgencyData.
     * 
     * @param agencyName
     */
    public void setAgencyName(java.lang.String agencyName) {
        this.agencyName = agencyName;
    }


    /**
     * Gets the agencyType value for this AgencyData.
     * 
     * @return agencyType
     */
    public java.lang.String getAgencyType() {
        return agencyType;
    }


    /**
     * Sets the agencyType value for this AgencyData.
     * 
     * @param agencyType
     */
    public void setAgencyType(java.lang.String agencyType) {
        this.agencyType = agencyType;
    }


    /**
     * Gets the agencyTypeCode value for this AgencyData.
     * 
     * @return agencyTypeCode
     */
    public java.lang.String getAgencyTypeCode() {
        return agencyTypeCode;
    }


    /**
     * Sets the agencyTypeCode value for this AgencyData.
     * 
     * @param agencyTypeCode
     */
    public void setAgencyTypeCode(java.lang.String agencyTypeCode) {
        this.agencyTypeCode = agencyTypeCode;
    }


    /**
     * Gets the bank value for this AgencyData.
     * 
     * @return bank
     */
    public java.lang.String getBank() {
        return bank;
    }


    /**
     * Sets the bank value for this AgencyData.
     * 
     * @param bank
     */
    public void setBank(java.lang.String bank) {
        this.bank = bank;
    }


    /**
     * Gets the branchCode value for this AgencyData.
     * 
     * @return branchCode
     */
    public java.lang.String getBranchCode() {
        return branchCode;
    }


    /**
     * Sets the branchCode value for this AgencyData.
     * 
     * @param branchCode
     */
    public void setBranchCode(java.lang.String branchCode) {
        this.branchCode = branchCode;
    }


    /**
     * Gets the businessClassCode value for this AgencyData.
     * 
     * @return businessClassCode
     */
    public java.lang.String getBusinessClassCode() {
        return businessClassCode;
    }


    /**
     * Sets the businessClassCode value for this AgencyData.
     * 
     * @param businessClassCode
     */
    public void setBusinessClassCode(java.lang.String businessClassCode) {
        this.businessClassCode = businessClassCode;
    }


    /**
     * Gets the cityId value for this AgencyData.
     * 
     * @return cityId
     */
    public java.lang.Long getCityId() {
        return cityId;
    }


    /**
     * Sets the cityId value for this AgencyData.
     * 
     * @param cityId
     */
    public void setCityId(java.lang.Long cityId) {
        this.cityId = cityId;
    }


    /**
     * Gets the cityName value for this AgencyData.
     * 
     * @return cityName
     */
    public java.lang.String getCityName() {
        return cityName;
    }


    /**
     * Sets the cityName value for this AgencyData.
     * 
     * @param cityName
     */
    public void setCityName(java.lang.String cityName) {
        this.cityName = cityName;
    }


    /**
     * Gets the creditLimit value for this AgencyData.
     * 
     * @return creditLimit
     */
    public java.lang.String getCreditLimit() {
        return creditLimit;
    }


    /**
     * Sets the creditLimit value for this AgencyData.
     * 
     * @param creditLimit
     */
    public void setCreditLimit(java.lang.String creditLimit) {
        this.creditLimit = creditLimit;
    }


    /**
     * Gets the creditLimitCode value for this AgencyData.
     * 
     * @return creditLimitCode
     */
    public java.lang.Short getCreditLimitCode() {
        return creditLimitCode;
    }


    /**
     * Sets the creditLimitCode value for this AgencyData.
     * 
     * @param creditLimitCode
     */
    public void setCreditLimitCode(java.lang.Short creditLimitCode) {
        this.creditLimitCode = creditLimitCode;
    }


    /**
     * Gets the csdCode value for this AgencyData.
     * 
     * @return csdCode
     */
    public java.lang.String getCsdCode() {
        return csdCode;
    }


    /**
     * Sets the csdCode value for this AgencyData.
     * 
     * @param csdCode
     */
    public void setCsdCode(java.lang.String csdCode) {
        this.csdCode = csdCode;
    }


    /**
     * Gets the email value for this AgencyData.
     * 
     * @return email
     */
    public java.lang.String getEmail() {
        return email;
    }


    /**
     * Sets the email value for this AgencyData.
     * 
     * @param email
     */
    public void setEmail(java.lang.String email) {
        this.email = email;
    }


    /**
     * Gets the mobileNumber value for this AgencyData.
     * 
     * @return mobileNumber
     */
    public java.lang.String getMobileNumber() {
        return mobileNumber;
    }


    /**
     * Sets the mobileNumber value for this AgencyData.
     * 
     * @param mobileNumber
     */
    public void setMobileNumber(java.lang.String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }


    /**
     * Gets the phoneNumber value for this AgencyData.
     * 
     * @return phoneNumber
     */
    public java.lang.String getPhoneNumber() {
        return phoneNumber;
    }


    /**
     * Sets the phoneNumber value for this AgencyData.
     * 
     * @param phoneNumber
     */
    public void setPhoneNumber(java.lang.String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    /**
     * Gets the registrationNumber value for this AgencyData.
     * 
     * @return registrationNumber
     */
    public java.lang.String getRegistrationNumber() {
        return registrationNumber;
    }


    /**
     * Sets the registrationNumber value for this AgencyData.
     * 
     * @param registrationNumber
     */
    public void setRegistrationNumber(java.lang.String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }


    /**
     * Gets the renewalDate value for this AgencyData.
     * 
     * @return renewalDate
     */
    public java.util.Calendar getRenewalDate() {
        return renewalDate;
    }


    /**
     * Sets the renewalDate value for this AgencyData.
     * 
     * @param renewalDate
     */
    public void setRenewalDate(java.util.Calendar renewalDate) {
        this.renewalDate = renewalDate;
    }


    /**
     * Gets the sortCode value for this AgencyData.
     * 
     * @return sortCode
     */
    public java.lang.String getSortCode() {
        return sortCode;
    }


    /**
     * Sets the sortCode value for this AgencyData.
     * 
     * @param sortCode
     */
    public void setSortCode(java.lang.String sortCode) {
        this.sortCode = sortCode;
    }


    /**
     * Gets the state value for this AgencyData.
     * 
     * @return state
     */
    public java.lang.String getState() {
        return state;
    }


    /**
     * Sets the state value for this AgencyData.
     * 
     * @param state
     */
    public void setState(java.lang.String state) {
        this.state = state;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AgencyData)) return false;
        AgencyData other = (AgencyData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.accountNo==null && other.getAccountNo()==null) || 
             (this.accountNo!=null &&
              this.accountNo.equals(other.getAccountNo()))) &&
            ((this.addressLine1==null && other.getAddressLine1()==null) || 
             (this.addressLine1!=null &&
              this.addressLine1.equals(other.getAddressLine1()))) &&
            ((this.addressLine2==null && other.getAddressLine2()==null) || 
             (this.addressLine2!=null &&
              this.addressLine2.equals(other.getAddressLine2()))) &&
            ((this.agencyClass==null && other.getAgencyClass()==null) || 
             (this.agencyClass!=null &&
              this.agencyClass.equals(other.getAgencyClass()))) &&
            ((this.agencyClassCode==null && other.getAgencyClassCode()==null) || 
             (this.agencyClassCode!=null &&
              this.agencyClassCode.equals(other.getAgencyClassCode()))) &&
            ((this.agencyCode==null && other.getAgencyCode()==null) || 
             (this.agencyCode!=null &&
              this.agencyCode.equals(other.getAgencyCode()))) &&
            ((this.agencyGroup==null && other.getAgencyGroup()==null) || 
             (this.agencyGroup!=null &&
              this.agencyGroup.equals(other.getAgencyGroup()))) &&
            ((this.agencyGroupCode==null && other.getAgencyGroupCode()==null) || 
             (this.agencyGroupCode!=null &&
              this.agencyGroupCode.equals(other.getAgencyGroupCode()))) &&
            ((this.agencyId==null && other.getAgencyId()==null) || 
             (this.agencyId!=null &&
              this.agencyId.equals(other.getAgencyId()))) &&
            ((this.agencyName==null && other.getAgencyName()==null) || 
             (this.agencyName!=null &&
              this.agencyName.equals(other.getAgencyName()))) &&
            ((this.agencyType==null && other.getAgencyType()==null) || 
             (this.agencyType!=null &&
              this.agencyType.equals(other.getAgencyType()))) &&
            ((this.agencyTypeCode==null && other.getAgencyTypeCode()==null) || 
             (this.agencyTypeCode!=null &&
              this.agencyTypeCode.equals(other.getAgencyTypeCode()))) &&
            ((this.bank==null && other.getBank()==null) || 
             (this.bank!=null &&
              this.bank.equals(other.getBank()))) &&
            ((this.branchCode==null && other.getBranchCode()==null) || 
             (this.branchCode!=null &&
              this.branchCode.equals(other.getBranchCode()))) &&
            ((this.businessClassCode==null && other.getBusinessClassCode()==null) || 
             (this.businessClassCode!=null &&
              this.businessClassCode.equals(other.getBusinessClassCode()))) &&
            ((this.cityId==null && other.getCityId()==null) || 
             (this.cityId!=null &&
              this.cityId.equals(other.getCityId()))) &&
            ((this.cityName==null && other.getCityName()==null) || 
             (this.cityName!=null &&
              this.cityName.equals(other.getCityName()))) &&
            ((this.creditLimit==null && other.getCreditLimit()==null) || 
             (this.creditLimit!=null &&
              this.creditLimit.equals(other.getCreditLimit()))) &&
            ((this.creditLimitCode==null && other.getCreditLimitCode()==null) || 
             (this.creditLimitCode!=null &&
              this.creditLimitCode.equals(other.getCreditLimitCode()))) &&
            ((this.csdCode==null && other.getCsdCode()==null) || 
             (this.csdCode!=null &&
              this.csdCode.equals(other.getCsdCode()))) &&
            ((this.email==null && other.getEmail()==null) || 
             (this.email!=null &&
              this.email.equals(other.getEmail()))) &&
            ((this.mobileNumber==null && other.getMobileNumber()==null) || 
             (this.mobileNumber!=null &&
              this.mobileNumber.equals(other.getMobileNumber()))) &&
            ((this.phoneNumber==null && other.getPhoneNumber()==null) || 
             (this.phoneNumber!=null &&
              this.phoneNumber.equals(other.getPhoneNumber()))) &&
            ((this.registrationNumber==null && other.getRegistrationNumber()==null) || 
             (this.registrationNumber!=null &&
              this.registrationNumber.equals(other.getRegistrationNumber()))) &&
            ((this.renewalDate==null && other.getRenewalDate()==null) || 
             (this.renewalDate!=null &&
              this.renewalDate.equals(other.getRenewalDate()))) &&
            ((this.sortCode==null && other.getSortCode()==null) || 
             (this.sortCode!=null &&
              this.sortCode.equals(other.getSortCode()))) &&
            ((this.state==null && other.getState()==null) || 
             (this.state!=null &&
              this.state.equals(other.getState())));
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
        if (getAccountNo() != null) {
            _hashCode += getAccountNo().hashCode();
        }
        if (getAddressLine1() != null) {
            _hashCode += getAddressLine1().hashCode();
        }
        if (getAddressLine2() != null) {
            _hashCode += getAddressLine2().hashCode();
        }
        if (getAgencyClass() != null) {
            _hashCode += getAgencyClass().hashCode();
        }
        if (getAgencyClassCode() != null) {
            _hashCode += getAgencyClassCode().hashCode();
        }
        if (getAgencyCode() != null) {
            _hashCode += getAgencyCode().hashCode();
        }
        if (getAgencyGroup() != null) {
            _hashCode += getAgencyGroup().hashCode();
        }
        if (getAgencyGroupCode() != null) {
            _hashCode += getAgencyGroupCode().hashCode();
        }
        if (getAgencyId() != null) {
            _hashCode += getAgencyId().hashCode();
        }
        if (getAgencyName() != null) {
            _hashCode += getAgencyName().hashCode();
        }
        if (getAgencyType() != null) {
            _hashCode += getAgencyType().hashCode();
        }
        if (getAgencyTypeCode() != null) {
            _hashCode += getAgencyTypeCode().hashCode();
        }
        if (getBank() != null) {
            _hashCode += getBank().hashCode();
        }
        if (getBranchCode() != null) {
            _hashCode += getBranchCode().hashCode();
        }
        if (getBusinessClassCode() != null) {
            _hashCode += getBusinessClassCode().hashCode();
        }
        if (getCityId() != null) {
            _hashCode += getCityId().hashCode();
        }
        if (getCityName() != null) {
            _hashCode += getCityName().hashCode();
        }
        if (getCreditLimit() != null) {
            _hashCode += getCreditLimit().hashCode();
        }
        if (getCreditLimitCode() != null) {
            _hashCode += getCreditLimitCode().hashCode();
        }
        if (getCsdCode() != null) {
            _hashCode += getCsdCode().hashCode();
        }
        if (getEmail() != null) {
            _hashCode += getEmail().hashCode();
        }
        if (getMobileNumber() != null) {
            _hashCode += getMobileNumber().hashCode();
        }
        if (getPhoneNumber() != null) {
            _hashCode += getPhoneNumber().hashCode();
        }
        if (getRegistrationNumber() != null) {
            _hashCode += getRegistrationNumber().hashCode();
        }
        if (getRenewalDate() != null) {
            _hashCode += getRenewalDate().hashCode();
        }
        if (getSortCode() != null) {
            _hashCode += getSortCode().hashCode();
        }
        if (getState() != null) {
            _hashCode += getState().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AgencyData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.service.pf.leadway.com/", "agencyData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accountNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "accountNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("addressLine1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "addressLine1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("addressLine2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "addressLine2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("agencyClass");
        elemField.setXmlName(new javax.xml.namespace.QName("", "agencyClass"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("agencyClassCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "agencyClassCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("agencyCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "agencyCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("agencyGroup");
        elemField.setXmlName(new javax.xml.namespace.QName("", "agencyGroup"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("agencyGroupCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "agencyGroupCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("agencyId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "agencyId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("agencyName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "agencyName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("agencyType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "agencyType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("agencyTypeCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "agencyTypeCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bank");
        elemField.setXmlName(new javax.xml.namespace.QName("", "bank"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("branchCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "branchCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("businessClassCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "businessClassCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cityId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cityId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cityName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cityName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("creditLimit");
        elemField.setXmlName(new javax.xml.namespace.QName("", "creditLimit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("creditLimitCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "creditLimitCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("csdCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "csdCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("email");
        elemField.setXmlName(new javax.xml.namespace.QName("", "email"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mobileNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mobileNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("phoneNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "phoneNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("registrationNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "registrationNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("renewalDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "renewalDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sortCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sortCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("state");
        elemField.setXmlName(new javax.xml.namespace.QName("", "state"));
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
