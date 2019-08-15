/**
 * PaymentForDC.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.leadway.projects.payment.endpoint;

public class PaymentForDC  extends com.leadway.projects.payment.endpoint.BasePayment  implements java.io.Serializable {
    private java.lang.String address1;

    private java.lang.String address2;

    private java.lang.String branchCode;

    private double commissionAmount;

    private java.lang.String debitCreditNumber;

    private java.lang.String IAS_autoRef;

    private java.lang.String narration;

    private java.lang.String netIndicator;

    private java.lang.String payer;

    private java.lang.String staffNumber;

    private java.lang.String tranTypeCode;

    public PaymentForDC() {
    }

    public PaymentForDC(
           java.lang.String agentCode,
           java.math.BigDecimal amount,
           java.lang.String debitCreditSign,
           boolean deleted,
           java.lang.String denomination,
           java.lang.String IAS_transmitStatus,
           java.lang.String IS_transmitStatus,
           java.lang.String iasTranConfig,
           java.util.Calendar paymentDate,
           java.lang.String paymentMode,
           java.lang.String paymentSource,
           java.lang.String policyNumber,
           java.math.BigDecimal premiumDue,
           java.lang.String receiptNumber,
           boolean sealed,
           java.lang.String subsystem,
           java.util.Calendar timeStamp,
           java.lang.String transmitStatus,
           java.lang.String address1,
           java.lang.String address2,
           java.lang.String branchCode,
           double commissionAmount,
           java.lang.String debitCreditNumber,
           java.lang.String IAS_autoRef,
           java.lang.String narration,
           java.lang.String netIndicator,
           java.lang.String payer,
           java.lang.String staffNumber,
           java.lang.String tranTypeCode) {
        super(
            agentCode,
            amount,
            debitCreditSign,
            deleted,
            denomination,
            IAS_transmitStatus,
            IS_transmitStatus,
            iasTranConfig,
            paymentDate,
            paymentMode,
            paymentSource,
            policyNumber,
            premiumDue,
            receiptNumber,
            sealed,
            subsystem,
            timeStamp,
            transmitStatus);
        this.address1 = address1;
        this.address2 = address2;
        this.branchCode = branchCode;
        this.commissionAmount = commissionAmount;
        this.debitCreditNumber = debitCreditNumber;
        this.IAS_autoRef = IAS_autoRef;
        this.narration = narration;
        this.netIndicator = netIndicator;
        this.payer = payer;
        this.staffNumber = staffNumber;
        this.tranTypeCode = tranTypeCode;
    }


    /**
     * Gets the address1 value for this PaymentForDC.
     * 
     * @return address1
     */
    public java.lang.String getAddress1() {
        return address1;
    }


    /**
     * Sets the address1 value for this PaymentForDC.
     * 
     * @param address1
     */
    public void setAddress1(java.lang.String address1) {
        this.address1 = address1;
    }


    /**
     * Gets the address2 value for this PaymentForDC.
     * 
     * @return address2
     */
    public java.lang.String getAddress2() {
        return address2;
    }


    /**
     * Sets the address2 value for this PaymentForDC.
     * 
     * @param address2
     */
    public void setAddress2(java.lang.String address2) {
        this.address2 = address2;
    }


    /**
     * Gets the branchCode value for this PaymentForDC.
     * 
     * @return branchCode
     */
    public java.lang.String getBranchCode() {
        return branchCode;
    }


    /**
     * Sets the branchCode value for this PaymentForDC.
     * 
     * @param branchCode
     */
    public void setBranchCode(java.lang.String branchCode) {
        this.branchCode = branchCode;
    }


    /**
     * Gets the commissionAmount value for this PaymentForDC.
     * 
     * @return commissionAmount
     */
    public double getCommissionAmount() {
        return commissionAmount;
    }


    /**
     * Sets the commissionAmount value for this PaymentForDC.
     * 
     * @param commissionAmount
     */
    public void setCommissionAmount(double commissionAmount) {
        this.commissionAmount = commissionAmount;
    }


    /**
     * Gets the debitCreditNumber value for this PaymentForDC.
     * 
     * @return debitCreditNumber
     */
    public java.lang.String getDebitCreditNumber() {
        return debitCreditNumber;
    }


    /**
     * Sets the debitCreditNumber value for this PaymentForDC.
     * 
     * @param debitCreditNumber
     */
    public void setDebitCreditNumber(java.lang.String debitCreditNumber) {
        this.debitCreditNumber = debitCreditNumber;
    }


    /**
     * Gets the IAS_autoRef value for this PaymentForDC.
     * 
     * @return IAS_autoRef
     */
    public java.lang.String getIAS_autoRef() {
        return IAS_autoRef;
    }


    /**
     * Sets the IAS_autoRef value for this PaymentForDC.
     * 
     * @param IAS_autoRef
     */
    public void setIAS_autoRef(java.lang.String IAS_autoRef) {
        this.IAS_autoRef = IAS_autoRef;
    }


    /**
     * Gets the narration value for this PaymentForDC.
     * 
     * @return narration
     */
    public java.lang.String getNarration() {
        return narration;
    }


    /**
     * Sets the narration value for this PaymentForDC.
     * 
     * @param narration
     */
    public void setNarration(java.lang.String narration) {
        this.narration = narration;
    }


    /**
     * Gets the netIndicator value for this PaymentForDC.
     * 
     * @return netIndicator
     */
    public java.lang.String getNetIndicator() {
        return netIndicator;
    }


    /**
     * Sets the netIndicator value for this PaymentForDC.
     * 
     * @param netIndicator
     */
    public void setNetIndicator(java.lang.String netIndicator) {
        this.netIndicator = netIndicator;
    }


    /**
     * Gets the payer value for this PaymentForDC.
     * 
     * @return payer
     */
    public java.lang.String getPayer() {
        return payer;
    }


    /**
     * Sets the payer value for this PaymentForDC.
     * 
     * @param payer
     */
    public void setPayer(java.lang.String payer) {
        this.payer = payer;
    }


    /**
     * Gets the staffNumber value for this PaymentForDC.
     * 
     * @return staffNumber
     */
    public java.lang.String getStaffNumber() {
        return staffNumber;
    }


    /**
     * Sets the staffNumber value for this PaymentForDC.
     * 
     * @param staffNumber
     */
    public void setStaffNumber(java.lang.String staffNumber) {
        this.staffNumber = staffNumber;
    }


    /**
     * Gets the tranTypeCode value for this PaymentForDC.
     * 
     * @return tranTypeCode
     */
    public java.lang.String getTranTypeCode() {
        return tranTypeCode;
    }


    /**
     * Sets the tranTypeCode value for this PaymentForDC.
     * 
     * @param tranTypeCode
     */
    public void setTranTypeCode(java.lang.String tranTypeCode) {
        this.tranTypeCode = tranTypeCode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PaymentForDC)) return false;
        PaymentForDC other = (PaymentForDC) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.address1==null && other.getAddress1()==null) || 
             (this.address1!=null &&
              this.address1.equals(other.getAddress1()))) &&
            ((this.address2==null && other.getAddress2()==null) || 
             (this.address2!=null &&
              this.address2.equals(other.getAddress2()))) &&
            ((this.branchCode==null && other.getBranchCode()==null) || 
             (this.branchCode!=null &&
              this.branchCode.equals(other.getBranchCode()))) &&
            this.commissionAmount == other.getCommissionAmount() &&
            ((this.debitCreditNumber==null && other.getDebitCreditNumber()==null) || 
             (this.debitCreditNumber!=null &&
              this.debitCreditNumber.equals(other.getDebitCreditNumber()))) &&
            ((this.IAS_autoRef==null && other.getIAS_autoRef()==null) || 
             (this.IAS_autoRef!=null &&
              this.IAS_autoRef.equals(other.getIAS_autoRef()))) &&
            ((this.narration==null && other.getNarration()==null) || 
             (this.narration!=null &&
              this.narration.equals(other.getNarration()))) &&
            ((this.netIndicator==null && other.getNetIndicator()==null) || 
             (this.netIndicator!=null &&
              this.netIndicator.equals(other.getNetIndicator()))) &&
            ((this.payer==null && other.getPayer()==null) || 
             (this.payer!=null &&
              this.payer.equals(other.getPayer()))) &&
            ((this.staffNumber==null && other.getStaffNumber()==null) || 
             (this.staffNumber!=null &&
              this.staffNumber.equals(other.getStaffNumber()))) &&
            ((this.tranTypeCode==null && other.getTranTypeCode()==null) || 
             (this.tranTypeCode!=null &&
              this.tranTypeCode.equals(other.getTranTypeCode())));
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
        if (getAddress1() != null) {
            _hashCode += getAddress1().hashCode();
        }
        if (getAddress2() != null) {
            _hashCode += getAddress2().hashCode();
        }
        if (getBranchCode() != null) {
            _hashCode += getBranchCode().hashCode();
        }
        _hashCode += new Double(getCommissionAmount()).hashCode();
        if (getDebitCreditNumber() != null) {
            _hashCode += getDebitCreditNumber().hashCode();
        }
        if (getIAS_autoRef() != null) {
            _hashCode += getIAS_autoRef().hashCode();
        }
        if (getNarration() != null) {
            _hashCode += getNarration().hashCode();
        }
        if (getNetIndicator() != null) {
            _hashCode += getNetIndicator().hashCode();
        }
        if (getPayer() != null) {
            _hashCode += getPayer().hashCode();
        }
        if (getStaffNumber() != null) {
            _hashCode += getStaffNumber().hashCode();
        }
        if (getTranTypeCode() != null) {
            _hashCode += getTranTypeCode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PaymentForDC.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "paymentForDC"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("address1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "address1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("address2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "address2"));
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
        elemField.setFieldName("commissionAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "commissionAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("debitCreditNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "debitCreditNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IAS_autoRef");
        elemField.setXmlName(new javax.xml.namespace.QName("", "IAS_autoRef"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("narration");
        elemField.setXmlName(new javax.xml.namespace.QName("", "narration"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("netIndicator");
        elemField.setXmlName(new javax.xml.namespace.QName("", "netIndicator"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("payer");
        elemField.setXmlName(new javax.xml.namespace.QName("", "payer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("staffNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "staffNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tranTypeCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tranTypeCode"));
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
