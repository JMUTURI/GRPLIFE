/**
 * ClientData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.leadway.pf.service.ws;

public class ClientData  extends com.leadway.pf.service.ws.BaseClientData  implements java.io.Serializable {
    private java.lang.String bankAddress;

    private java.lang.String bankCity;

    private java.lang.Long bankCityId;

    private java.lang.String clientBranch;

    private java.lang.String clientContactOption;

    private java.lang.String clientName;

    private java.lang.String clientType;

    private java.lang.String clientTypeCode;

    private java.lang.String companyRegNumber;

    private java.lang.String corporateName;

    private java.lang.String creditLimit;

    private java.lang.Short creditLimitCode;

    private java.lang.String crmCode;

    private java.lang.String faxNumber;

    private java.lang.String firsNumber;

    private java.lang.String industryCode;

    private java.util.Calendar lastModified;

    private java.lang.String localGovernment;

    private java.lang.Long localGovernmentId;

    private java.lang.String mobileNumber2;

    private java.lang.String occupation;

    private java.lang.String occupationCode;

    private java.lang.String organizationTypeCode;

    private java.lang.String pencomNumber;

    private java.lang.String postCode;

    private java.lang.String postalPostCode;

    private java.lang.String postalState;

    private java.lang.String postalStateCode;

    private java.lang.String sameAsResidentialAddress;

    private java.lang.String stateCode;

    public ClientData() {
    }

    public ClientData(
           java.util.Calendar createDate,
           java.lang.String createdBy,
           boolean deleted,
           boolean editable,
           boolean selected,
           java.lang.String status,
           java.lang.String statusDesc,
           java.lang.Short version,
           java.lang.String accountNumber,
           java.lang.String bankName,
           java.util.Calendar birthDate,
           java.lang.String city,
           java.lang.Long cityId,
           java.lang.String clientCode,
           java.lang.String email,
           java.lang.String firstName,
           java.lang.String lastName,
           java.lang.String maritalStatus,
           java.lang.String maritalStatusCode,
           java.lang.String middleName,
           java.lang.String mobileNumber,
           java.lang.String phoneNumber,
           java.lang.String postalAddress,
           java.lang.String postalCity,
           java.lang.Long postalCityId,
           java.lang.String sex,
           java.lang.String sortCode,
           java.lang.String state,
           java.lang.String streetAddress,
           java.lang.String title,
           java.lang.String titleCode,
           java.lang.String bankAddress,
           java.lang.String bankCity,
           java.lang.Long bankCityId,
           java.lang.String clientBranch,
           java.lang.String clientContactOption,
           java.lang.String clientName,
           java.lang.String clientType,
           java.lang.String clientTypeCode,
           java.lang.String companyRegNumber,
           java.lang.String corporateName,
           java.lang.String creditLimit,
           java.lang.Short creditLimitCode,
           java.lang.String crmCode,
           java.lang.String faxNumber,
           java.lang.String firsNumber,
           java.lang.String industryCode,
           java.util.Calendar lastModified,
           java.lang.String localGovernment,
           java.lang.Long localGovernmentId,
           java.lang.String mobileNumber2,
           java.lang.String occupation,
           java.lang.String occupationCode,
           java.lang.String organizationTypeCode,
           java.lang.String pencomNumber,
           java.lang.String postCode,
           java.lang.String postalPostCode,
           java.lang.String postalState,
           java.lang.String postalStateCode,
           java.lang.String sameAsResidentialAddress,
           java.lang.String stateCode) {
        super(
            createDate,
            createdBy,
            deleted,
            editable,
            selected,
            status,
            statusDesc,
            version,
            accountNumber,
            bankName,
            birthDate,
            city,
            cityId,
            clientCode,
            email,
            firstName,
            lastName,
            maritalStatus,
            maritalStatusCode,
            middleName,
            mobileNumber,
            phoneNumber,
            postalAddress,
            postalCity,
            postalCityId,
            sex,
            sortCode,
            state,
            streetAddress,
            title,
            titleCode);
        this.bankAddress = bankAddress;
        this.bankCity = bankCity;
        this.bankCityId = bankCityId;
        this.clientBranch = clientBranch;
        this.clientContactOption = clientContactOption;
        this.clientName = clientName;
        this.clientType = clientType;
        this.clientTypeCode = clientTypeCode;
        this.companyRegNumber = companyRegNumber;
        this.corporateName = corporateName;
        this.creditLimit = creditLimit;
        this.creditLimitCode = creditLimitCode;
        this.crmCode = crmCode;
        this.faxNumber = faxNumber;
        this.firsNumber = firsNumber;
        this.industryCode = industryCode;
        this.lastModified = lastModified;
        this.localGovernment = localGovernment;
        this.localGovernmentId = localGovernmentId;
        this.mobileNumber2 = mobileNumber2;
        this.occupation = occupation;
        this.occupationCode = occupationCode;
        this.organizationTypeCode = organizationTypeCode;
        this.pencomNumber = pencomNumber;
        this.postCode = postCode;
        this.postalPostCode = postalPostCode;
        this.postalState = postalState;
        this.postalStateCode = postalStateCode;
        this.sameAsResidentialAddress = sameAsResidentialAddress;
        this.stateCode = stateCode;
    }


    /**
     * Gets the bankAddress value for this ClientData.
     * 
     * @return bankAddress
     */
    public java.lang.String getBankAddress() {
        return bankAddress;
    }


    /**
     * Sets the bankAddress value for this ClientData.
     * 
     * @param bankAddress
     */
    public void setBankAddress(java.lang.String bankAddress) {
        this.bankAddress = bankAddress;
    }


    /**
     * Gets the bankCity value for this ClientData.
     * 
     * @return bankCity
     */
    public java.lang.String getBankCity() {
        return bankCity;
    }


    /**
     * Sets the bankCity value for this ClientData.
     * 
     * @param bankCity
     */
    public void setBankCity(java.lang.String bankCity) {
        this.bankCity = bankCity;
    }


    /**
     * Gets the bankCityId value for this ClientData.
     * 
     * @return bankCityId
     */
    public java.lang.Long getBankCityId() {
        return bankCityId;
    }


    /**
     * Sets the bankCityId value for this ClientData.
     * 
     * @param bankCityId
     */
    public void setBankCityId(java.lang.Long bankCityId) {
        this.bankCityId = bankCityId;
    }


    /**
     * Gets the clientBranch value for this ClientData.
     * 
     * @return clientBranch
     */
    public java.lang.String getClientBranch() {
        return clientBranch;
    }


    /**
     * Sets the clientBranch value for this ClientData.
     * 
     * @param clientBranch
     */
    public void setClientBranch(java.lang.String clientBranch) {
        this.clientBranch = clientBranch;
    }


    /**
     * Gets the clientContactOption value for this ClientData.
     * 
     * @return clientContactOption
     */
    public java.lang.String getClientContactOption() {
        return clientContactOption;
    }


    /**
     * Sets the clientContactOption value for this ClientData.
     * 
     * @param clientContactOption
     */
    public void setClientContactOption(java.lang.String clientContactOption) {
        this.clientContactOption = clientContactOption;
    }


    /**
     * Gets the clientName value for this ClientData.
     * 
     * @return clientName
     */
    public java.lang.String getClientName() {
        return clientName;
    }


    /**
     * Sets the clientName value for this ClientData.
     * 
     * @param clientName
     */
    public void setClientName(java.lang.String clientName) {
        this.clientName = clientName;
    }


    /**
     * Gets the clientType value for this ClientData.
     * 
     * @return clientType
     */
    public java.lang.String getClientType() {
        return clientType;
    }


    /**
     * Sets the clientType value for this ClientData.
     * 
     * @param clientType
     */
    public void setClientType(java.lang.String clientType) {
        this.clientType = clientType;
    }


    /**
     * Gets the clientTypeCode value for this ClientData.
     * 
     * @return clientTypeCode
     */
    public java.lang.String getClientTypeCode() {
        return clientTypeCode;
    }


    /**
     * Sets the clientTypeCode value for this ClientData.
     * 
     * @param clientTypeCode
     */
    public void setClientTypeCode(java.lang.String clientTypeCode) {
        this.clientTypeCode = clientTypeCode;
    }


    /**
     * Gets the companyRegNumber value for this ClientData.
     * 
     * @return companyRegNumber
     */
    public java.lang.String getCompanyRegNumber() {
        return companyRegNumber;
    }


    /**
     * Sets the companyRegNumber value for this ClientData.
     * 
     * @param companyRegNumber
     */
    public void setCompanyRegNumber(java.lang.String companyRegNumber) {
        this.companyRegNumber = companyRegNumber;
    }


    /**
     * Gets the corporateName value for this ClientData.
     * 
     * @return corporateName
     */
    public java.lang.String getCorporateName() {
        return corporateName;
    }


    /**
     * Sets the corporateName value for this ClientData.
     * 
     * @param corporateName
     */
    public void setCorporateName(java.lang.String corporateName) {
        this.corporateName = corporateName;
    }


    /**
     * Gets the creditLimit value for this ClientData.
     * 
     * @return creditLimit
     */
    public java.lang.String getCreditLimit() {
        return creditLimit;
    }


    /**
     * Sets the creditLimit value for this ClientData.
     * 
     * @param creditLimit
     */
    public void setCreditLimit(java.lang.String creditLimit) {
        this.creditLimit = creditLimit;
    }


    /**
     * Gets the creditLimitCode value for this ClientData.
     * 
     * @return creditLimitCode
     */
    public java.lang.Short getCreditLimitCode() {
        return creditLimitCode;
    }


    /**
     * Sets the creditLimitCode value for this ClientData.
     * 
     * @param creditLimitCode
     */
    public void setCreditLimitCode(java.lang.Short creditLimitCode) {
        this.creditLimitCode = creditLimitCode;
    }


    /**
     * Gets the crmCode value for this ClientData.
     * 
     * @return crmCode
     */
    public java.lang.String getCrmCode() {
        return crmCode;
    }


    /**
     * Sets the crmCode value for this ClientData.
     * 
     * @param crmCode
     */
    public void setCrmCode(java.lang.String crmCode) {
        this.crmCode = crmCode;
    }


    /**
     * Gets the faxNumber value for this ClientData.
     * 
     * @return faxNumber
     */
    public java.lang.String getFaxNumber() {
        return faxNumber;
    }


    /**
     * Sets the faxNumber value for this ClientData.
     * 
     * @param faxNumber
     */
    public void setFaxNumber(java.lang.String faxNumber) {
        this.faxNumber = faxNumber;
    }


    /**
     * Gets the firsNumber value for this ClientData.
     * 
     * @return firsNumber
     */
    public java.lang.String getFirsNumber() {
        return firsNumber;
    }


    /**
     * Sets the firsNumber value for this ClientData.
     * 
     * @param firsNumber
     */
    public void setFirsNumber(java.lang.String firsNumber) {
        this.firsNumber = firsNumber;
    }


    /**
     * Gets the industryCode value for this ClientData.
     * 
     * @return industryCode
     */
    public java.lang.String getIndustryCode() {
        return industryCode;
    }


    /**
     * Sets the industryCode value for this ClientData.
     * 
     * @param industryCode
     */
    public void setIndustryCode(java.lang.String industryCode) {
        this.industryCode = industryCode;
    }


    /**
     * Gets the lastModified value for this ClientData.
     * 
     * @return lastModified
     */
    public java.util.Calendar getLastModified() {
        return lastModified;
    }


    /**
     * Sets the lastModified value for this ClientData.
     * 
     * @param lastModified
     */
    public void setLastModified(java.util.Calendar lastModified) {
        this.lastModified = lastModified;
    }


    /**
     * Gets the localGovernment value for this ClientData.
     * 
     * @return localGovernment
     */
    public java.lang.String getLocalGovernment() {
        return localGovernment;
    }


    /**
     * Sets the localGovernment value for this ClientData.
     * 
     * @param localGovernment
     */
    public void setLocalGovernment(java.lang.String localGovernment) {
        this.localGovernment = localGovernment;
    }


    /**
     * Gets the localGovernmentId value for this ClientData.
     * 
     * @return localGovernmentId
     */
    public java.lang.Long getLocalGovernmentId() {
        return localGovernmentId;
    }


    /**
     * Sets the localGovernmentId value for this ClientData.
     * 
     * @param localGovernmentId
     */
    public void setLocalGovernmentId(java.lang.Long localGovernmentId) {
        this.localGovernmentId = localGovernmentId;
    }


    /**
     * Gets the mobileNumber2 value for this ClientData.
     * 
     * @return mobileNumber2
     */
    public java.lang.String getMobileNumber2() {
        return mobileNumber2;
    }


    /**
     * Sets the mobileNumber2 value for this ClientData.
     * 
     * @param mobileNumber2
     */
    public void setMobileNumber2(java.lang.String mobileNumber2) {
        this.mobileNumber2 = mobileNumber2;
    }


    /**
     * Gets the occupation value for this ClientData.
     * 
     * @return occupation
     */
    public java.lang.String getOccupation() {
        return occupation;
    }


    /**
     * Sets the occupation value for this ClientData.
     * 
     * @param occupation
     */
    public void setOccupation(java.lang.String occupation) {
        this.occupation = occupation;
    }


    /**
     * Gets the occupationCode value for this ClientData.
     * 
     * @return occupationCode
     */
    public java.lang.String getOccupationCode() {
        return occupationCode;
    }


    /**
     * Sets the occupationCode value for this ClientData.
     * 
     * @param occupationCode
     */
    public void setOccupationCode(java.lang.String occupationCode) {
        this.occupationCode = occupationCode;
    }


    /**
     * Gets the organizationTypeCode value for this ClientData.
     * 
     * @return organizationTypeCode
     */
    public java.lang.String getOrganizationTypeCode() {
        return organizationTypeCode;
    }


    /**
     * Sets the organizationTypeCode value for this ClientData.
     * 
     * @param organizationTypeCode
     */
    public void setOrganizationTypeCode(java.lang.String organizationTypeCode) {
        this.organizationTypeCode = organizationTypeCode;
    }


    /**
     * Gets the pencomNumber value for this ClientData.
     * 
     * @return pencomNumber
     */
    public java.lang.String getPencomNumber() {
        return pencomNumber;
    }


    /**
     * Sets the pencomNumber value for this ClientData.
     * 
     * @param pencomNumber
     */
    public void setPencomNumber(java.lang.String pencomNumber) {
        this.pencomNumber = pencomNumber;
    }


    /**
     * Gets the postCode value for this ClientData.
     * 
     * @return postCode
     */
    public java.lang.String getPostCode() {
        return postCode;
    }


    /**
     * Sets the postCode value for this ClientData.
     * 
     * @param postCode
     */
    public void setPostCode(java.lang.String postCode) {
        this.postCode = postCode;
    }


    /**
     * Gets the postalPostCode value for this ClientData.
     * 
     * @return postalPostCode
     */
    public java.lang.String getPostalPostCode() {
        return postalPostCode;
    }


    /**
     * Sets the postalPostCode value for this ClientData.
     * 
     * @param postalPostCode
     */
    public void setPostalPostCode(java.lang.String postalPostCode) {
        this.postalPostCode = postalPostCode;
    }


    /**
     * Gets the postalState value for this ClientData.
     * 
     * @return postalState
     */
    public java.lang.String getPostalState() {
        return postalState;
    }


    /**
     * Sets the postalState value for this ClientData.
     * 
     * @param postalState
     */
    public void setPostalState(java.lang.String postalState) {
        this.postalState = postalState;
    }


    /**
     * Gets the postalStateCode value for this ClientData.
     * 
     * @return postalStateCode
     */
    public java.lang.String getPostalStateCode() {
        return postalStateCode;
    }


    /**
     * Sets the postalStateCode value for this ClientData.
     * 
     * @param postalStateCode
     */
    public void setPostalStateCode(java.lang.String postalStateCode) {
        this.postalStateCode = postalStateCode;
    }


    /**
     * Gets the sameAsResidentialAddress value for this ClientData.
     * 
     * @return sameAsResidentialAddress
     */
    public java.lang.String getSameAsResidentialAddress() {
        return sameAsResidentialAddress;
    }


    /**
     * Sets the sameAsResidentialAddress value for this ClientData.
     * 
     * @param sameAsResidentialAddress
     */
    public void setSameAsResidentialAddress(java.lang.String sameAsResidentialAddress) {
        this.sameAsResidentialAddress = sameAsResidentialAddress;
    }


    /**
     * Gets the stateCode value for this ClientData.
     * 
     * @return stateCode
     */
    public java.lang.String getStateCode() {
        return stateCode;
    }


    /**
     * Sets the stateCode value for this ClientData.
     * 
     * @param stateCode
     */
    public void setStateCode(java.lang.String stateCode) {
        this.stateCode = stateCode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ClientData)) return false;
        ClientData other = (ClientData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.bankAddress==null && other.getBankAddress()==null) || 
             (this.bankAddress!=null &&
              this.bankAddress.equals(other.getBankAddress()))) &&
            ((this.bankCity==null && other.getBankCity()==null) || 
             (this.bankCity!=null &&
              this.bankCity.equals(other.getBankCity()))) &&
            ((this.bankCityId==null && other.getBankCityId()==null) || 
             (this.bankCityId!=null &&
              this.bankCityId.equals(other.getBankCityId()))) &&
            ((this.clientBranch==null && other.getClientBranch()==null) || 
             (this.clientBranch!=null &&
              this.clientBranch.equals(other.getClientBranch()))) &&
            ((this.clientContactOption==null && other.getClientContactOption()==null) || 
             (this.clientContactOption!=null &&
              this.clientContactOption.equals(other.getClientContactOption()))) &&
            ((this.clientName==null && other.getClientName()==null) || 
             (this.clientName!=null &&
              this.clientName.equals(other.getClientName()))) &&
            ((this.clientType==null && other.getClientType()==null) || 
             (this.clientType!=null &&
              this.clientType.equals(other.getClientType()))) &&
            ((this.clientTypeCode==null && other.getClientTypeCode()==null) || 
             (this.clientTypeCode!=null &&
              this.clientTypeCode.equals(other.getClientTypeCode()))) &&
            ((this.companyRegNumber==null && other.getCompanyRegNumber()==null) || 
             (this.companyRegNumber!=null &&
              this.companyRegNumber.equals(other.getCompanyRegNumber()))) &&
            ((this.corporateName==null && other.getCorporateName()==null) || 
             (this.corporateName!=null &&
              this.corporateName.equals(other.getCorporateName()))) &&
            ((this.creditLimit==null && other.getCreditLimit()==null) || 
             (this.creditLimit!=null &&
              this.creditLimit.equals(other.getCreditLimit()))) &&
            ((this.creditLimitCode==null && other.getCreditLimitCode()==null) || 
             (this.creditLimitCode!=null &&
              this.creditLimitCode.equals(other.getCreditLimitCode()))) &&
            ((this.crmCode==null && other.getCrmCode()==null) || 
             (this.crmCode!=null &&
              this.crmCode.equals(other.getCrmCode()))) &&
            ((this.faxNumber==null && other.getFaxNumber()==null) || 
             (this.faxNumber!=null &&
              this.faxNumber.equals(other.getFaxNumber()))) &&
            ((this.firsNumber==null && other.getFirsNumber()==null) || 
             (this.firsNumber!=null &&
              this.firsNumber.equals(other.getFirsNumber()))) &&
            ((this.industryCode==null && other.getIndustryCode()==null) || 
             (this.industryCode!=null &&
              this.industryCode.equals(other.getIndustryCode()))) &&
            ((this.lastModified==null && other.getLastModified()==null) || 
             (this.lastModified!=null &&
              this.lastModified.equals(other.getLastModified()))) &&
            ((this.localGovernment==null && other.getLocalGovernment()==null) || 
             (this.localGovernment!=null &&
              this.localGovernment.equals(other.getLocalGovernment()))) &&
            ((this.localGovernmentId==null && other.getLocalGovernmentId()==null) || 
             (this.localGovernmentId!=null &&
              this.localGovernmentId.equals(other.getLocalGovernmentId()))) &&
            ((this.mobileNumber2==null && other.getMobileNumber2()==null) || 
             (this.mobileNumber2!=null &&
              this.mobileNumber2.equals(other.getMobileNumber2()))) &&
            ((this.occupation==null && other.getOccupation()==null) || 
             (this.occupation!=null &&
              this.occupation.equals(other.getOccupation()))) &&
            ((this.occupationCode==null && other.getOccupationCode()==null) || 
             (this.occupationCode!=null &&
              this.occupationCode.equals(other.getOccupationCode()))) &&
            ((this.organizationTypeCode==null && other.getOrganizationTypeCode()==null) || 
             (this.organizationTypeCode!=null &&
              this.organizationTypeCode.equals(other.getOrganizationTypeCode()))) &&
            ((this.pencomNumber==null && other.getPencomNumber()==null) || 
             (this.pencomNumber!=null &&
              this.pencomNumber.equals(other.getPencomNumber()))) &&
            ((this.postCode==null && other.getPostCode()==null) || 
             (this.postCode!=null &&
              this.postCode.equals(other.getPostCode()))) &&
            ((this.postalPostCode==null && other.getPostalPostCode()==null) || 
             (this.postalPostCode!=null &&
              this.postalPostCode.equals(other.getPostalPostCode()))) &&
            ((this.postalState==null && other.getPostalState()==null) || 
             (this.postalState!=null &&
              this.postalState.equals(other.getPostalState()))) &&
            ((this.postalStateCode==null && other.getPostalStateCode()==null) || 
             (this.postalStateCode!=null &&
              this.postalStateCode.equals(other.getPostalStateCode()))) &&
            ((this.sameAsResidentialAddress==null && other.getSameAsResidentialAddress()==null) || 
             (this.sameAsResidentialAddress!=null &&
              this.sameAsResidentialAddress.equals(other.getSameAsResidentialAddress()))) &&
            ((this.stateCode==null && other.getStateCode()==null) || 
             (this.stateCode!=null &&
              this.stateCode.equals(other.getStateCode())));
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
        if (getBankAddress() != null) {
            _hashCode += getBankAddress().hashCode();
        }
        if (getBankCity() != null) {
            _hashCode += getBankCity().hashCode();
        }
        if (getBankCityId() != null) {
            _hashCode += getBankCityId().hashCode();
        }
        if (getClientBranch() != null) {
            _hashCode += getClientBranch().hashCode();
        }
        if (getClientContactOption() != null) {
            _hashCode += getClientContactOption().hashCode();
        }
        if (getClientName() != null) {
            _hashCode += getClientName().hashCode();
        }
        if (getClientType() != null) {
            _hashCode += getClientType().hashCode();
        }
        if (getClientTypeCode() != null) {
            _hashCode += getClientTypeCode().hashCode();
        }
        if (getCompanyRegNumber() != null) {
            _hashCode += getCompanyRegNumber().hashCode();
        }
        if (getCorporateName() != null) {
            _hashCode += getCorporateName().hashCode();
        }
        if (getCreditLimit() != null) {
            _hashCode += getCreditLimit().hashCode();
        }
        if (getCreditLimitCode() != null) {
            _hashCode += getCreditLimitCode().hashCode();
        }
        if (getCrmCode() != null) {
            _hashCode += getCrmCode().hashCode();
        }
        if (getFaxNumber() != null) {
            _hashCode += getFaxNumber().hashCode();
        }
        if (getFirsNumber() != null) {
            _hashCode += getFirsNumber().hashCode();
        }
        if (getIndustryCode() != null) {
            _hashCode += getIndustryCode().hashCode();
        }
        if (getLastModified() != null) {
            _hashCode += getLastModified().hashCode();
        }
        if (getLocalGovernment() != null) {
            _hashCode += getLocalGovernment().hashCode();
        }
        if (getLocalGovernmentId() != null) {
            _hashCode += getLocalGovernmentId().hashCode();
        }
        if (getMobileNumber2() != null) {
            _hashCode += getMobileNumber2().hashCode();
        }
        if (getOccupation() != null) {
            _hashCode += getOccupation().hashCode();
        }
        if (getOccupationCode() != null) {
            _hashCode += getOccupationCode().hashCode();
        }
        if (getOrganizationTypeCode() != null) {
            _hashCode += getOrganizationTypeCode().hashCode();
        }
        if (getPencomNumber() != null) {
            _hashCode += getPencomNumber().hashCode();
        }
        if (getPostCode() != null) {
            _hashCode += getPostCode().hashCode();
        }
        if (getPostalPostCode() != null) {
            _hashCode += getPostalPostCode().hashCode();
        }
        if (getPostalState() != null) {
            _hashCode += getPostalState().hashCode();
        }
        if (getPostalStateCode() != null) {
            _hashCode += getPostalStateCode().hashCode();
        }
        if (getSameAsResidentialAddress() != null) {
            _hashCode += getSameAsResidentialAddress().hashCode();
        }
        if (getStateCode() != null) {
            _hashCode += getStateCode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ClientData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.service.pf.leadway.com/", "clientData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bankAddress");
        elemField.setXmlName(new javax.xml.namespace.QName("", "bankAddress"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bankCity");
        elemField.setXmlName(new javax.xml.namespace.QName("", "bankCity"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bankCityId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "bankCityId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clientBranch");
        elemField.setXmlName(new javax.xml.namespace.QName("", "clientBranch"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clientContactOption");
        elemField.setXmlName(new javax.xml.namespace.QName("", "clientContactOption"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clientName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "clientName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clientType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "clientType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clientTypeCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "clientTypeCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("companyRegNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "companyRegNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("corporateName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "corporateName"));
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
        elemField.setFieldName("crmCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "crmCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("faxNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "faxNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("firsNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "firsNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("industryCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "industryCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastModified");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lastModified"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("localGovernment");
        elemField.setXmlName(new javax.xml.namespace.QName("", "localGovernment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("localGovernmentId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "localGovernmentId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mobileNumber2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mobileNumber2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("occupation");
        elemField.setXmlName(new javax.xml.namespace.QName("", "occupation"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("occupationCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "occupationCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("organizationTypeCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "organizationTypeCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pencomNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pencomNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("postCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "postCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("postalPostCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "postalPostCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("postalState");
        elemField.setXmlName(new javax.xml.namespace.QName("", "postalState"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("postalStateCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "postalStateCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sameAsResidentialAddress");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sameAsResidentialAddress"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stateCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stateCode"));
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
