package LMSG.view.Clients;

import java.math.BigDecimal;

import java.util.Date;

import weblogic.wsee.security.policy12.assertions.Strict;

public class Client {
    private BigDecimal prpCode;
    private String clientName;
    private String prpIDRegNo;
    private String clientPayrollNo;
    private BigDecimal prp_clnt_code;
    
    private BigDecimal occupationCode;
    private String occupationalDesc;
    private BigDecimal lifeClass;

    private BigDecimal ClientCode;
    private String PINNumber;
    private String PostalAddress;
    private String TelphoneOne;
    private String Othernames;
    private String Fullname;
    private String IdRegNumber;
    private String ShortDescription;
    private String ZIPCode;
    
    private BigDecimal PRP_CODE, GCO_CODE,  LC_CODE; 
    private String CLIENT,PRP_SHT_DESC,PRP_ID_REG_NO,
           PRP_DOB, GCO_SHT_DESC, GCO_DESC, 
           Hazard;
    
    //Client contact person details
    private BigDecimal pctcCode;
    private String pctcName;
    private Date pctcDob;
    private String pctcPhyAddr;
    private String pctcPostAddr;
    private String pctcTel;
    private String pctcEmail;
    private Date pctcWef;
    private Date pctcWet;
    
    

    public void setPrpCode(BigDecimal prpCode) {
        this.prpCode = prpCode;
    }

    public BigDecimal getPrpCode() {
        return prpCode;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setPrpIDRegNo(String prpIDRegNo) {
        this.prpIDRegNo = prpIDRegNo;
    }

    public String getPrpIDRegNo() {
        return prpIDRegNo;
    }

    public void setClientPayrollNo(String clientPayrollNo) {
        this.clientPayrollNo = clientPayrollNo;
    }

    public String getClientPayrollNo() {
        return clientPayrollNo;
    }

    public void setOccupationCode(BigDecimal occupationCode) {
        this.occupationCode = occupationCode;
    }

    public BigDecimal getOccupationCode() {
        return occupationCode;
    }

    public void setOccupationalDesc(String occupationalDesc) {
        this.occupationalDesc = occupationalDesc;
    }

    public String getOccupationalDesc() {
        return occupationalDesc;
    }

    public void setLifeClass(BigDecimal lifeClass) {
        this.lifeClass = lifeClass;
    }

    public BigDecimal getLifeClass() {
        return lifeClass;
    }

    public void setClientCode(BigDecimal ClientCode) {
        this.ClientCode = ClientCode;
    }

    public BigDecimal getClientCode() {
        return ClientCode;
    }

    public void setPINNumber(String PINNumber) {
        this.PINNumber = PINNumber;
    }

    public String getPINNumber() {
        return PINNumber;
    }

    public void setPostalAddress(String PostalAddress) {
        this.PostalAddress = PostalAddress;
    }

    public String getPostalAddress() {
        return PostalAddress;
    }

    public void setTelphoneOne(String TelphoneOne) {
        this.TelphoneOne = TelphoneOne;
    }

    public String getTelphoneOne() {
        return TelphoneOne;
    }

    public void setOthernames(String Othernames) {
        this.Othernames = Othernames;
    }

    public String getOthernames() {
        return Othernames;
    }

    public void setFullname(String Fullname) {
        this.Fullname = Fullname;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setIdRegNumber(String IdRegNumber) {
        this.IdRegNumber = IdRegNumber;
    }

    public String getIdRegNumber() {
        return IdRegNumber;
    }

    public void setShortDescription(String ShortDescription) {
        this.ShortDescription = ShortDescription;
    }

    public String getShortDescription() {
        return ShortDescription;
    }

    public void setZIPCode(String ZIPCode) {
        this.ZIPCode = ZIPCode;
    }

    public String getZIPCode() {
        return ZIPCode;
    }

    public void setPRP_CODE(BigDecimal PRP_CODE) {
        this.PRP_CODE = PRP_CODE;
    }

    public BigDecimal getPRP_CODE() {
        return PRP_CODE;
    }

    public void setGCO_CODE(BigDecimal GCO_CODE) {
        this.GCO_CODE = GCO_CODE;
    }

    public BigDecimal getGCO_CODE() {
        return GCO_CODE;
    }

    public void setLC_CODE(BigDecimal LC_CODE) {
        this.LC_CODE = LC_CODE;
    }

    public BigDecimal getLC_CODE() {
        return LC_CODE;
    }

    public void setCLIENT(String CLIENT) {
        this.CLIENT = CLIENT;
    }

    public String getCLIENT() {
        return CLIENT;
    }

    public void setPRP_SHT_DESC(String PRP_SHT_DESC) {
        this.PRP_SHT_DESC = PRP_SHT_DESC;
    }

    public String getPRP_SHT_DESC() {
        return PRP_SHT_DESC;
    }

    public void setPRP_ID_REG_NO(String PRP_ID_REG_NO) {
        this.PRP_ID_REG_NO = PRP_ID_REG_NO;
    }

    public String getPRP_ID_REG_NO() {
        return PRP_ID_REG_NO;
    }

    public void setPRP_DOB(String PRP_DOB) {
        this.PRP_DOB = PRP_DOB;
    }

    public String getPRP_DOB() {
        return PRP_DOB;
    }

    public void setGCO_SHT_DESC(String GCO_SHT_DESC) {
        this.GCO_SHT_DESC = GCO_SHT_DESC;
    }

    public String getGCO_SHT_DESC() {
        return GCO_SHT_DESC;
    }

    public void setGCO_DESC(String GCO_DESC) {
        this.GCO_DESC = GCO_DESC;
    }

    public String getGCO_DESC() {
        return GCO_DESC;
    }

    public void setHazard(String Hazard) {
        this.Hazard = Hazard;
    }

    public String getHazard() {
        return Hazard;
    }

    public void setPrp_clnt_code(BigDecimal prp_clnt_code) {
        this.prp_clnt_code = prp_clnt_code;
    }

    public BigDecimal getPrp_clnt_code() {
        return prp_clnt_code;
    }

    public void setPctcCode(BigDecimal pctcCode) {
        this.pctcCode = pctcCode;
    }

    public BigDecimal getPctcCode() {
        return pctcCode;
    }

    public void setPctcName(String pctcName) {
        this.pctcName = pctcName;
    }

    public String getPctcName() {
        return pctcName;
    }

    public void setPctcDob(Date pctcDob) {
        this.pctcDob = pctcDob;
    }

    public Date getPctcDob() {
        return pctcDob;
    }

    public void setPctcPhyAddr(String pctcPhyAddr) {
        this.pctcPhyAddr = pctcPhyAddr;
    }

    public String getPctcPhyAddr() {
        return pctcPhyAddr;
    }

    public void setPctcPostAddr(String pctcPostAddr) {
        this.pctcPostAddr = pctcPostAddr;
    }

    public String getPctcPostAddr() {
        return pctcPostAddr;
    }

    public void setPctcTel(String pctcTel) {
        this.pctcTel = pctcTel;
    }

    public String getPctcTel() {
        return pctcTel;
    }

    public void setPctcEmail(String pctcEmail) {
        this.pctcEmail = pctcEmail;
    }

    public String getPctcEmail() {
        return pctcEmail;
    }

    public void setPctcWef(Date pctcWef) {
        this.pctcWef = pctcWef;
    }

    public Date getPctcWef() {
        return pctcWef;
    }

    public void setPctcWet(Date pctcWet) {
        this.pctcWet = pctcWet;
    }

    public Date getPctcWet() {
        return pctcWet;
    }
}
