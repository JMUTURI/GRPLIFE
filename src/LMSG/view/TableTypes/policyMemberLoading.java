package LMSG.view.TableTypes;

import java.io.Serializable;

import java.math.BigDecimal;

import java.sql.Date;
import java.sql.SQLData;

import java.sql.SQLException;
import java.sql.SQLInput;

import java.sql.SQLOutput;


public class policyMemberLoading  implements SQLData, Serializable {
    public policyMemberLoading() {
        super();
    }
    
  private BigDecimal LGMD_SN;
  private String LGMD_SURNAME; 
  private Date LGMD_DOB;
  private BigDecimal LGMD_ANB;
  private String LGMD_CATEGORY;
  private BigDecimal LGMD_EARNINGS_PRD;
  private String LGMD_OCCUPATION;
  private String LGMD_BASIC; 
  private String LGMD_HOUSING; 
  private String LGMD_TRANSPORT;
  private String LGMD_MONTH_SAL;
  private BigDecimal LGMD_TOT_EMUL;
  private BigDecimal LGMD_SA;
  private BigDecimal LGMD_PREM;
  private BigDecimal LGMD_PREM_RATE;
  private String LGMD_POL_NO;
  private Date LGMD_DOJ; 
  private Date LGMD_COVER_FROM_DATE;
  private BigDecimal LGMD_EMYR_BAL_BF;
  private BigDecimal LGMD_EMYE_BAL_BF;
  private BigDecimal LGMD_EMPYR_CONTRI;
  private BigDecimal LGMD_EMYE_CONTRI;
  private BigDecimal LGMD_ORIG_LOAN_AMT;
  private Date LGMD_LOAN_ISSUE_DATE;
  private BigDecimal LGMD_ORIG_LN_PRD;
  private BigDecimal LGMD_LOAN_INT;  
  
  
  
  public String getSQLTypeName() {
      return "LMS_POLICIES_MEM_LOADING";
  }
  
  public void readSQL(SQLInput stream, String typeName) throws SQLException {
    this.LGMD_SN=stream.readBigDecimal();
    this.LGMD_SURNAME=stream.readString();
    this.LGMD_DOB=stream.readDate();
    this.LGMD_ANB=stream.readBigDecimal();
    this.LGMD_CATEGORY=stream.readString();
    this.LGMD_EARNINGS_PRD=stream.readBigDecimal();
    this.LGMD_OCCUPATION=stream.readString();
    this.LGMD_BASIC=stream.readString();
    this.LGMD_HOUSING=stream.readString();
    this.LGMD_TRANSPORT=stream.readString();
    this.LGMD_MONTH_SAL=stream.readString();
    this.LGMD_TOT_EMUL=stream.readBigDecimal();
    this.LGMD_SA=stream.readBigDecimal();
    this.LGMD_PREM=stream.readBigDecimal();
    this.LGMD_PREM_RATE=stream.readBigDecimal();
    this.LGMD_POL_NO=stream.readString();
    this.LGMD_DOJ=stream.readDate();
    this.LGMD_COVER_FROM_DATE=stream.readDate();
    this.LGMD_EMYR_BAL_BF=stream.readBigDecimal();
    this.LGMD_EMYE_BAL_BF=stream.readBigDecimal();
    this.LGMD_EMPYR_CONTRI=stream.readBigDecimal();
    this.LGMD_EMYE_CONTRI=stream.readBigDecimal();
    this.LGMD_ORIG_LOAN_AMT=stream.readBigDecimal();
    this.LGMD_LOAN_ISSUE_DATE=stream.readDate();
    this.LGMD_ORIG_LN_PRD=stream.readBigDecimal();
    this.LGMD_LOAN_INT=stream.readBigDecimal();   
    
    
    
  }
  
  public void writeSQL(SQLOutput stream) throws SQLException {
    stream.writeBigDecimal(LGMD_SN);
    stream.writeString(LGMD_SURNAME);
    stream.writeDate(LGMD_DOB);
    stream.writeBigDecimal(LGMD_ANB);
    stream.writeString(LGMD_CATEGORY);
    stream.writeBigDecimal(LGMD_EARNINGS_PRD);
    stream.writeString(LGMD_OCCUPATION);
    stream.writeString(LGMD_BASIC);
    stream.writeString(LGMD_HOUSING);
    stream.writeString(LGMD_TRANSPORT);
    stream.writeString(LGMD_MONTH_SAL);
    stream.writeBigDecimal(LGMD_TOT_EMUL);
    stream.writeBigDecimal(LGMD_SA);
    stream.writeBigDecimal(LGMD_PREM);
    stream.writeBigDecimal(LGMD_PREM_RATE);
    stream.writeString(LGMD_POL_NO);
    stream.writeDate(LGMD_DOJ);
    stream.writeDate(LGMD_COVER_FROM_DATE);
    stream.writeBigDecimal(LGMD_EMYR_BAL_BF);
    stream.writeBigDecimal(LGMD_EMYE_BAL_BF);
    stream.writeBigDecimal(LGMD_EMPYR_CONTRI);
    stream.writeBigDecimal(LGMD_EMYE_CONTRI);
    stream.writeBigDecimal(LGMD_ORIG_LOAN_AMT);
    stream.writeDate(LGMD_LOAN_ISSUE_DATE);
    stream.writeBigDecimal(LGMD_ORIG_LN_PRD);
    stream.writeBigDecimal(LGMD_LOAN_INT);    
   
  }

    public void setLGMD_SN(BigDecimal LGMD_SN) {
        this.LGMD_SN = LGMD_SN;
    }

    public BigDecimal getLGMD_SN() {
        return LGMD_SN;
    }

    public void setLGMD_SURNAME(String LGMD_SURNAME) {
        this.LGMD_SURNAME = LGMD_SURNAME;
    }

    public String getLGMD_SURNAME() {
        return LGMD_SURNAME;
    }

    public void setLGMD_DOB(Date LGMD_DOB) {
        this.LGMD_DOB = LGMD_DOB;
    }

    public Date getLGMD_DOB() {
        return LGMD_DOB;
    }

    public void setLGMD_ANB(BigDecimal LGMD_ANB) {
        this.LGMD_ANB = LGMD_ANB;
    }

    public BigDecimal getLGMD_ANB() {
        return LGMD_ANB;
    }

    public void setLGMD_BASIC(String LGMD_BASIC) {
        this.LGMD_BASIC = LGMD_BASIC;
    }

    public String getLGMD_BASIC() {
        return LGMD_BASIC;
    }

    public void setLGMD_HOUSING(String LGMD_HOUSING) {
        this.LGMD_HOUSING = LGMD_HOUSING;
    }

    public String getLGMD_HOUSING() {
        return LGMD_HOUSING;
    }

    public void setLGMD_TRANSPORT(String LGMD_TRANSPORT) {
        this.LGMD_TRANSPORT = LGMD_TRANSPORT;
    }

    public String getLGMD_TRANSPORT() {
        return LGMD_TRANSPORT;
    }

    public void setLGMD_MONTH_SAL(String LGMD_MONTH_SAL) {
        this.LGMD_MONTH_SAL = LGMD_MONTH_SAL;
    }

    public String getLGMD_MONTH_SAL() {
        return LGMD_MONTH_SAL;
    }

    public void setLGMD_TOT_EMUL(BigDecimal LGMD_TOT_EMUL) {
        this.LGMD_TOT_EMUL = LGMD_TOT_EMUL;
    }

    public BigDecimal getLGMD_TOT_EMUL() {
        return LGMD_TOT_EMUL;
    }

    public void setLGMD_SA(BigDecimal LGMD_SA) {
        this.LGMD_SA = LGMD_SA;
    }

    public BigDecimal getLGMD_SA() {
        return LGMD_SA;
    }

    public void setLGMD_PREM(BigDecimal LGMD_PREM) {
        this.LGMD_PREM = LGMD_PREM;
    }

    public BigDecimal getLGMD_PREM() {
        return LGMD_PREM;
    }

    public void setLGMD_PREM_RATE(BigDecimal LGMD_PREM_RATE) {
        this.LGMD_PREM_RATE = LGMD_PREM_RATE;
    }

    public BigDecimal getLGMD_PREM_RATE() {
        return LGMD_PREM_RATE;
    }

    public void setLGMD_DOJ(Date LGMD_DOJ) {
        this.LGMD_DOJ = LGMD_DOJ;
    }

    public Date getLGMD_DOJ() {
        return LGMD_DOJ;
    }

    public void setLGMD_COVER_FROM_DATE(Date LGMD_COVER_FROM_DATE) {
        this.LGMD_COVER_FROM_DATE = LGMD_COVER_FROM_DATE;
    }

    public Date getLGMD_COVER_FROM_DATE() {
        return LGMD_COVER_FROM_DATE;
    }

    public void setLGMD_EMYR_BAL_BF(BigDecimal LGMD_EMYR_BAL_BF) {
        this.LGMD_EMYR_BAL_BF = LGMD_EMYR_BAL_BF;
    }

    public BigDecimal getLGMD_EMYR_BAL_BF() {
        return LGMD_EMYR_BAL_BF;
    }

    public void setLGMD_EMYE_BAL_BF(BigDecimal LGMD_EMYE_BAL_BF) {
        this.LGMD_EMYE_BAL_BF = LGMD_EMYE_BAL_BF;
    }

    public BigDecimal getLGMD_EMYE_BAL_BF() {
        return LGMD_EMYE_BAL_BF;
    }

    public void setLGMD_EMPYR_CONTRI(BigDecimal LGMD_EMPYR_CONTRI) {
        this.LGMD_EMPYR_CONTRI = LGMD_EMPYR_CONTRI;
    }

    public BigDecimal getLGMD_EMPYR_CONTRI() {
        return LGMD_EMPYR_CONTRI;
    }

    public void setLGMD_EMYE_CONTRI(BigDecimal LGMD_EMYE_CONTRI) {
        this.LGMD_EMYE_CONTRI = LGMD_EMYE_CONTRI;
    }

    public BigDecimal getLGMD_EMYE_CONTRI() {
        return LGMD_EMYE_CONTRI;
    }

    public void setLGMD_LOAN_ISSUE_DATE(Date LGMD_LOAN_ISSUE_DATE) {
        this.LGMD_LOAN_ISSUE_DATE = LGMD_LOAN_ISSUE_DATE;
    }

    public Date getLGMD_LOAN_ISSUE_DATE() {
        return LGMD_LOAN_ISSUE_DATE;
    }

    public void setLGMD_ORIG_LN_PRD(BigDecimal LGMD_ORIG_LN_PRD) {
        this.LGMD_ORIG_LN_PRD = LGMD_ORIG_LN_PRD;
    }

    public BigDecimal getLGMD_ORIG_LN_PRD() {
        return LGMD_ORIG_LN_PRD;
    }

    public void setLGMD_LOAN_INT(BigDecimal LGMD_LOAN_INT) {
        this.LGMD_LOAN_INT = LGMD_LOAN_INT;
    }

    public BigDecimal getLGMD_LOAN_INT() {
        return LGMD_LOAN_INT;
    }

    public void setLGMD_ORIG_LOAN_AMT(BigDecimal LGMD_ORIG_LOAN_AMT) {
        this.LGMD_ORIG_LOAN_AMT = LGMD_ORIG_LOAN_AMT;
    }

    public BigDecimal getLGMD_ORIG_LOAN_AMT() {
        return LGMD_ORIG_LOAN_AMT;
    }

    public void setLGMD_CATEGORY(String LGMD_CATEGORY) {
        this.LGMD_CATEGORY = LGMD_CATEGORY;
    }

    public String getLGMD_CATEGORY() {
        return LGMD_CATEGORY;
    }

    public void setLGMD_EARNINGS_PRD(BigDecimal LGMD_EARNINGS_PRD) {
        this.LGMD_EARNINGS_PRD = LGMD_EARNINGS_PRD;
    }

    public BigDecimal getLGMD_EARNINGS_PRD() {
        return LGMD_EARNINGS_PRD;
    }

    public void setLGMD_OCCUPATION(String LGMD_OCCUPATION) {
        this.LGMD_OCCUPATION = LGMD_OCCUPATION;
    }

    public String getLGMD_OCCUPATION() {
        return LGMD_OCCUPATION;
    }

    public void setLGMD_POL_NO(String LGMD_POL_NO) {
        this.LGMD_POL_NO = LGMD_POL_NO;
    }

    public String getLGMD_POL_NO() {
        return LGMD_POL_NO;
    }
}
