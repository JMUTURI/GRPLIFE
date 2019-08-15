/**
 * PfScheduleData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.leadway.pf.service.ws;

public class PfScheduleData  extends com.leadway.pf.service.ws.BusinessData  implements java.io.Serializable {
    private java.math.BigDecimal amountDue;

    private java.math.BigDecimal commission;

    private java.math.BigDecimal commissionInterest;

    private java.lang.String contextPath;

    private java.util.Calendar debitNoteDate;

    private java.lang.String debitNoteNumber;

    private java.util.Calendar dueDate;

    private java.lang.String installmentType;

    private java.lang.String installmentalNumber;

    private java.math.BigDecimal interest;

    private java.lang.String logoFilePath;

    private java.math.BigDecimal minimumDeposit;

    private java.math.BigDecimal outstandingAmount;

    private java.lang.String policyNumber;

    private java.lang.String policyRefNo;

    private java.math.BigDecimal premiumFinanced;

    private java.math.BigDecimal principal;

    private java.math.BigDecimal principalInterest;

    private java.lang.Long scheduleId;

    public PfScheduleData() {
    }

    public PfScheduleData(
           java.util.Calendar createDate,
           java.lang.String createdBy,
           boolean deleted,
           boolean editable,
           boolean selected,
           java.lang.String status,
           java.lang.String statusDesc,
           java.lang.Short version,
           java.math.BigDecimal amountDue,
           java.math.BigDecimal commission,
           java.math.BigDecimal commissionInterest,
           java.lang.String contextPath,
           java.util.Calendar debitNoteDate,
           java.lang.String debitNoteNumber,
           java.util.Calendar dueDate,
           java.lang.String installmentType,
           java.lang.String installmentalNumber,
           java.math.BigDecimal interest,
           java.lang.String logoFilePath,
           java.math.BigDecimal minimumDeposit,
           java.math.BigDecimal outstandingAmount,
           java.lang.String policyNumber,
           java.lang.String policyRefNo,
           java.math.BigDecimal premiumFinanced,
           java.math.BigDecimal principal,
           java.math.BigDecimal principalInterest,
           java.lang.Long scheduleId) {
        super(
            createDate,
            createdBy,
            deleted,
            editable,
            selected,
            status,
            statusDesc,
            version);
        this.amountDue = amountDue;
        this.commission = commission;
        this.commissionInterest = commissionInterest;
        this.contextPath = contextPath;
        this.debitNoteDate = debitNoteDate;
        this.debitNoteNumber = debitNoteNumber;
        this.dueDate = dueDate;
        this.installmentType = installmentType;
        this.installmentalNumber = installmentalNumber;
        this.interest = interest;
        this.logoFilePath = logoFilePath;
        this.minimumDeposit = minimumDeposit;
        this.outstandingAmount = outstandingAmount;
        this.policyNumber = policyNumber;
        this.policyRefNo = policyRefNo;
        this.premiumFinanced = premiumFinanced;
        this.principal = principal;
        this.principalInterest = principalInterest;
        this.scheduleId = scheduleId;
    }


    /**
     * Gets the amountDue value for this PfScheduleData.
     * 
     * @return amountDue
     */
    public java.math.BigDecimal getAmountDue() {
        return amountDue;
    }


    /**
     * Sets the amountDue value for this PfScheduleData.
     * 
     * @param amountDue
     */
    public void setAmountDue(java.math.BigDecimal amountDue) {
        this.amountDue = amountDue;
    }


    /**
     * Gets the commission value for this PfScheduleData.
     * 
     * @return commission
     */
    public java.math.BigDecimal getCommission() {
        return commission;
    }


    /**
     * Sets the commission value for this PfScheduleData.
     * 
     * @param commission
     */
    public void setCommission(java.math.BigDecimal commission) {
        this.commission = commission;
    }


    /**
     * Gets the commissionInterest value for this PfScheduleData.
     * 
     * @return commissionInterest
     */
    public java.math.BigDecimal getCommissionInterest() {
        return commissionInterest;
    }


    /**
     * Sets the commissionInterest value for this PfScheduleData.
     * 
     * @param commissionInterest
     */
    public void setCommissionInterest(java.math.BigDecimal commissionInterest) {
        this.commissionInterest = commissionInterest;
    }


    /**
     * Gets the contextPath value for this PfScheduleData.
     * 
     * @return contextPath
     */
    public java.lang.String getContextPath() {
        return contextPath;
    }


    /**
     * Sets the contextPath value for this PfScheduleData.
     * 
     * @param contextPath
     */
    public void setContextPath(java.lang.String contextPath) {
        this.contextPath = contextPath;
    }


    /**
     * Gets the debitNoteDate value for this PfScheduleData.
     * 
     * @return debitNoteDate
     */
    public java.util.Calendar getDebitNoteDate() {
        return debitNoteDate;
    }


    /**
     * Sets the debitNoteDate value for this PfScheduleData.
     * 
     * @param debitNoteDate
     */
    public void setDebitNoteDate(java.util.Calendar debitNoteDate) {
        this.debitNoteDate = debitNoteDate;
    }


    /**
     * Gets the debitNoteNumber value for this PfScheduleData.
     * 
     * @return debitNoteNumber
     */
    public java.lang.String getDebitNoteNumber() {
        return debitNoteNumber;
    }


    /**
     * Sets the debitNoteNumber value for this PfScheduleData.
     * 
     * @param debitNoteNumber
     */
    public void setDebitNoteNumber(java.lang.String debitNoteNumber) {
        this.debitNoteNumber = debitNoteNumber;
    }


    /**
     * Gets the dueDate value for this PfScheduleData.
     * 
     * @return dueDate
     */
    public java.util.Calendar getDueDate() {
        return dueDate;
    }


    /**
     * Sets the dueDate value for this PfScheduleData.
     * 
     * @param dueDate
     */
    public void setDueDate(java.util.Calendar dueDate) {
        this.dueDate = dueDate;
    }


    /**
     * Gets the installmentType value for this PfScheduleData.
     * 
     * @return installmentType
     */
    public java.lang.String getInstallmentType() {
        return installmentType;
    }


    /**
     * Sets the installmentType value for this PfScheduleData.
     * 
     * @param installmentType
     */
    public void setInstallmentType(java.lang.String installmentType) {
        this.installmentType = installmentType;
    }


    /**
     * Gets the installmentalNumber value for this PfScheduleData.
     * 
     * @return installmentalNumber
     */
    public java.lang.String getInstallmentalNumber() {
        return installmentalNumber;
    }


    /**
     * Sets the installmentalNumber value for this PfScheduleData.
     * 
     * @param installmentalNumber
     */
    public void setInstallmentalNumber(java.lang.String installmentalNumber) {
        this.installmentalNumber = installmentalNumber;
    }


    /**
     * Gets the interest value for this PfScheduleData.
     * 
     * @return interest
     */
    public java.math.BigDecimal getInterest() {
        return interest;
    }


    /**
     * Sets the interest value for this PfScheduleData.
     * 
     * @param interest
     */
    public void setInterest(java.math.BigDecimal interest) {
        this.interest = interest;
    }


    /**
     * Gets the logoFilePath value for this PfScheduleData.
     * 
     * @return logoFilePath
     */
    public java.lang.String getLogoFilePath() {
        return logoFilePath;
    }


    /**
     * Sets the logoFilePath value for this PfScheduleData.
     * 
     * @param logoFilePath
     */
    public void setLogoFilePath(java.lang.String logoFilePath) {
        this.logoFilePath = logoFilePath;
    }


    /**
     * Gets the minimumDeposit value for this PfScheduleData.
     * 
     * @return minimumDeposit
     */
    public java.math.BigDecimal getMinimumDeposit() {
        return minimumDeposit;
    }


    /**
     * Sets the minimumDeposit value for this PfScheduleData.
     * 
     * @param minimumDeposit
     */
    public void setMinimumDeposit(java.math.BigDecimal minimumDeposit) {
        this.minimumDeposit = minimumDeposit;
    }


    /**
     * Gets the outstandingAmount value for this PfScheduleData.
     * 
     * @return outstandingAmount
     */
    public java.math.BigDecimal getOutstandingAmount() {
        return outstandingAmount;
    }


    /**
     * Sets the outstandingAmount value for this PfScheduleData.
     * 
     * @param outstandingAmount
     */
    public void setOutstandingAmount(java.math.BigDecimal outstandingAmount) {
        this.outstandingAmount = outstandingAmount;
    }


    /**
     * Gets the policyNumber value for this PfScheduleData.
     * 
     * @return policyNumber
     */
    public java.lang.String getPolicyNumber() {
        return policyNumber;
    }


    /**
     * Sets the policyNumber value for this PfScheduleData.
     * 
     * @param policyNumber
     */
    public void setPolicyNumber(java.lang.String policyNumber) {
        this.policyNumber = policyNumber;
    }


    /**
     * Gets the policyRefNo value for this PfScheduleData.
     * 
     * @return policyRefNo
     */
    public java.lang.String getPolicyRefNo() {
        return policyRefNo;
    }


    /**
     * Sets the policyRefNo value for this PfScheduleData.
     * 
     * @param policyRefNo
     */
    public void setPolicyRefNo(java.lang.String policyRefNo) {
        this.policyRefNo = policyRefNo;
    }


    /**
     * Gets the premiumFinanced value for this PfScheduleData.
     * 
     * @return premiumFinanced
     */
    public java.math.BigDecimal getPremiumFinanced() {
        return premiumFinanced;
    }


    /**
     * Sets the premiumFinanced value for this PfScheduleData.
     * 
     * @param premiumFinanced
     */
    public void setPremiumFinanced(java.math.BigDecimal premiumFinanced) {
        this.premiumFinanced = premiumFinanced;
    }


    /**
     * Gets the principal value for this PfScheduleData.
     * 
     * @return principal
     */
    public java.math.BigDecimal getPrincipal() {
        return principal;
    }


    /**
     * Sets the principal value for this PfScheduleData.
     * 
     * @param principal
     */
    public void setPrincipal(java.math.BigDecimal principal) {
        this.principal = principal;
    }


    /**
     * Gets the principalInterest value for this PfScheduleData.
     * 
     * @return principalInterest
     */
    public java.math.BigDecimal getPrincipalInterest() {
        return principalInterest;
    }


    /**
     * Sets the principalInterest value for this PfScheduleData.
     * 
     * @param principalInterest
     */
    public void setPrincipalInterest(java.math.BigDecimal principalInterest) {
        this.principalInterest = principalInterest;
    }


    /**
     * Gets the scheduleId value for this PfScheduleData.
     * 
     * @return scheduleId
     */
    public java.lang.Long getScheduleId() {
        return scheduleId;
    }


    /**
     * Sets the scheduleId value for this PfScheduleData.
     * 
     * @param scheduleId
     */
    public void setScheduleId(java.lang.Long scheduleId) {
        this.scheduleId = scheduleId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PfScheduleData)) return false;
        PfScheduleData other = (PfScheduleData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.amountDue==null && other.getAmountDue()==null) || 
             (this.amountDue!=null &&
              this.amountDue.equals(other.getAmountDue()))) &&
            ((this.commission==null && other.getCommission()==null) || 
             (this.commission!=null &&
              this.commission.equals(other.getCommission()))) &&
            ((this.commissionInterest==null && other.getCommissionInterest()==null) || 
             (this.commissionInterest!=null &&
              this.commissionInterest.equals(other.getCommissionInterest()))) &&
            ((this.contextPath==null && other.getContextPath()==null) || 
             (this.contextPath!=null &&
              this.contextPath.equals(other.getContextPath()))) &&
            ((this.debitNoteDate==null && other.getDebitNoteDate()==null) || 
             (this.debitNoteDate!=null &&
              this.debitNoteDate.equals(other.getDebitNoteDate()))) &&
            ((this.debitNoteNumber==null && other.getDebitNoteNumber()==null) || 
             (this.debitNoteNumber!=null &&
              this.debitNoteNumber.equals(other.getDebitNoteNumber()))) &&
            ((this.dueDate==null && other.getDueDate()==null) || 
             (this.dueDate!=null &&
              this.dueDate.equals(other.getDueDate()))) &&
            ((this.installmentType==null && other.getInstallmentType()==null) || 
             (this.installmentType!=null &&
              this.installmentType.equals(other.getInstallmentType()))) &&
            ((this.installmentalNumber==null && other.getInstallmentalNumber()==null) || 
             (this.installmentalNumber!=null &&
              this.installmentalNumber.equals(other.getInstallmentalNumber()))) &&
            ((this.interest==null && other.getInterest()==null) || 
             (this.interest!=null &&
              this.interest.equals(other.getInterest()))) &&
            ((this.logoFilePath==null && other.getLogoFilePath()==null) || 
             (this.logoFilePath!=null &&
              this.logoFilePath.equals(other.getLogoFilePath()))) &&
            ((this.minimumDeposit==null && other.getMinimumDeposit()==null) || 
             (this.minimumDeposit!=null &&
              this.minimumDeposit.equals(other.getMinimumDeposit()))) &&
            ((this.outstandingAmount==null && other.getOutstandingAmount()==null) || 
             (this.outstandingAmount!=null &&
              this.outstandingAmount.equals(other.getOutstandingAmount()))) &&
            ((this.policyNumber==null && other.getPolicyNumber()==null) || 
             (this.policyNumber!=null &&
              this.policyNumber.equals(other.getPolicyNumber()))) &&
            ((this.policyRefNo==null && other.getPolicyRefNo()==null) || 
             (this.policyRefNo!=null &&
              this.policyRefNo.equals(other.getPolicyRefNo()))) &&
            ((this.premiumFinanced==null && other.getPremiumFinanced()==null) || 
             (this.premiumFinanced!=null &&
              this.premiumFinanced.equals(other.getPremiumFinanced()))) &&
            ((this.principal==null && other.getPrincipal()==null) || 
             (this.principal!=null &&
              this.principal.equals(other.getPrincipal()))) &&
            ((this.principalInterest==null && other.getPrincipalInterest()==null) || 
             (this.principalInterest!=null &&
              this.principalInterest.equals(other.getPrincipalInterest()))) &&
            ((this.scheduleId==null && other.getScheduleId()==null) || 
             (this.scheduleId!=null &&
              this.scheduleId.equals(other.getScheduleId())));
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
        if (getAmountDue() != null) {
            _hashCode += getAmountDue().hashCode();
        }
        if (getCommission() != null) {
            _hashCode += getCommission().hashCode();
        }
        if (getCommissionInterest() != null) {
            _hashCode += getCommissionInterest().hashCode();
        }
        if (getContextPath() != null) {
            _hashCode += getContextPath().hashCode();
        }
        if (getDebitNoteDate() != null) {
            _hashCode += getDebitNoteDate().hashCode();
        }
        if (getDebitNoteNumber() != null) {
            _hashCode += getDebitNoteNumber().hashCode();
        }
        if (getDueDate() != null) {
            _hashCode += getDueDate().hashCode();
        }
        if (getInstallmentType() != null) {
            _hashCode += getInstallmentType().hashCode();
        }
        if (getInstallmentalNumber() != null) {
            _hashCode += getInstallmentalNumber().hashCode();
        }
        if (getInterest() != null) {
            _hashCode += getInterest().hashCode();
        }
        if (getLogoFilePath() != null) {
            _hashCode += getLogoFilePath().hashCode();
        }
        if (getMinimumDeposit() != null) {
            _hashCode += getMinimumDeposit().hashCode();
        }
        if (getOutstandingAmount() != null) {
            _hashCode += getOutstandingAmount().hashCode();
        }
        if (getPolicyNumber() != null) {
            _hashCode += getPolicyNumber().hashCode();
        }
        if (getPolicyRefNo() != null) {
            _hashCode += getPolicyRefNo().hashCode();
        }
        if (getPremiumFinanced() != null) {
            _hashCode += getPremiumFinanced().hashCode();
        }
        if (getPrincipal() != null) {
            _hashCode += getPrincipal().hashCode();
        }
        if (getPrincipalInterest() != null) {
            _hashCode += getPrincipalInterest().hashCode();
        }
        if (getScheduleId() != null) {
            _hashCode += getScheduleId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PfScheduleData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.service.pf.leadway.com/", "pfScheduleData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("amountDue");
        elemField.setXmlName(new javax.xml.namespace.QName("", "amountDue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("commission");
        elemField.setXmlName(new javax.xml.namespace.QName("", "commission"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("commissionInterest");
        elemField.setXmlName(new javax.xml.namespace.QName("", "commissionInterest"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contextPath");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contextPath"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("debitNoteDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "debitNoteDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("debitNoteNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "debitNoteNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dueDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dueDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("installmentType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "installmentType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("installmentalNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "installmentalNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("interest");
        elemField.setXmlName(new javax.xml.namespace.QName("", "interest"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("logoFilePath");
        elemField.setXmlName(new javax.xml.namespace.QName("", "logoFilePath"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("minimumDeposit");
        elemField.setXmlName(new javax.xml.namespace.QName("", "minimumDeposit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("outstandingAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "outstandingAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("policyNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "policyNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("policyRefNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "policyRefNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("premiumFinanced");
        elemField.setXmlName(new javax.xml.namespace.QName("", "premiumFinanced"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("principal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "principal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("principalInterest");
        elemField.setXmlName(new javax.xml.namespace.QName("", "principalInterest"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scheduleId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "scheduleId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
