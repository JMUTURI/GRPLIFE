package LMSG.view.TableTypes;

import java.io.Serializable;

import java.math.BigDecimal;

import java.sql.Date;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class policyLoading implements SQLData, Serializable {
    public policyLoading() {
        super();
    }
  private BigDecimal LGPL_SN;
  private String LGPL_CLIENT;
  private BigDecimal LGPL_NO_MEM;
  private String LGPL_COIN_LEADER;
  private String LGPL_SHARE;
  private Date LGPL_COMMENC_DT;
  private Date LGPL_RENEW_DT;
  private Date LGPL_NEXT_REN_DT;
  private String LGPL_RATES;
  private BigDecimal LGPL_TOT_SA; 
  private BigDecimal LGPL_TOT_PREM;
  private BigDecimal LGPL_TOT_PREM_PAID;
  private BigDecimal LGPL_OUTS_PREM;
  private String LGPL_PROD_NAME;
  private String LGPL_AGENT_NAME;
  private String LGPL_AGENT;
  private String LGPL_POL_NO;
  private String LGPL_BRANCH;
  private String LGPL_AOI;
  private String LGPL_COMM_RATE;
  private String LGPL_OV_COMM_RATE;
  private String LGPL_VAT_RATE;
  private String LGPL_DURATION;
  private String LGPL_FREQ_OF_PAY;
  private String LGPL_POL_CATEGORY;
  private BigDecimal LGPL_MULTI_EARNINGS;
  private BigDecimal LGPL_FCL;
  private String LGPL_REGISTERED;
  private String LGPL_REG_NO;
  private String LGPL_PENS_TYPE;
  private String LGPL_CONTRI_TYPE;
  private String LGPL_EMYE_CONTRI;
  private String LGPL_EMYR_CONTRI;
  private String LGPL_MALE_NRD;
  private String LGPL_FEMALE_NRD;  
  private BigDecimal LGPL_PENS_COMM_RATE;
  private String LGPL_PENS_PAYMENT_FREQ;  
  private BigDecimal LGPL_PENS_INTR_RATE;
  private String LGPL_GRNTD_PRD;
  private String LGPL_EARNINGS_ESC; 
  private String LGPL_VAL_YEAR; 
  private String LGPL_AGGREGATE;
  private String LGPL_FUND_BAL;
  
  
 
  
  
  public String getSQLTypeName() {
      return "LMS_POLICIES_LOADING";
  }
  
  public void readSQL(SQLInput stream, String typeName) throws SQLException {
    this.LGPL_SN=stream.readBigDecimal();
    this.LGPL_CLIENT=stream.readString();
    this.LGPL_NO_MEM=stream.readBigDecimal();
    this.LGPL_COIN_LEADER=stream.readString();
    this.LGPL_SHARE=stream.readString();
    this.LGPL_COMMENC_DT=stream.readDate();
    this.LGPL_RENEW_DT=stream.readDate();
    this.LGPL_NEXT_REN_DT=stream.readDate();
    this.LGPL_RATES=stream.readString();
    this.LGPL_TOT_SA=stream.readBigDecimal();
    this.LGPL_TOT_PREM=stream.readBigDecimal();
    this.LGPL_TOT_PREM_PAID=stream.readBigDecimal();
    this.LGPL_OUTS_PREM=stream.readBigDecimal();
    this.LGPL_PROD_NAME=stream.readString();
    this.LGPL_AGENT_NAME=stream.readString();
    this.LGPL_AGENT=stream.readString();
    this.LGPL_POL_NO=stream.readString();
    this.LGPL_BRANCH=stream.readString();
    this.LGPL_AOI=stream.readString();
    this.LGPL_COMM_RATE=stream.readString();
    this.LGPL_OV_COMM_RATE=stream.readString();
    this.LGPL_VAT_RATE=stream.readString();
    this.LGPL_DURATION=stream.readString();
    this.LGPL_FREQ_OF_PAY=stream.readString();
    this.LGPL_POL_CATEGORY=stream.readString();
    this.LGPL_MULTI_EARNINGS=stream.readBigDecimal();
    this.LGPL_FCL=stream.readBigDecimal();
    this.LGPL_REGISTERED=stream.readString();
    this.LGPL_REG_NO=stream.readString();
    this.LGPL_PENS_TYPE=stream.readString();
    this.LGPL_CONTRI_TYPE=stream.readString();
    this.LGPL_EMYE_CONTRI=stream.readString();
    this.LGPL_EMYR_CONTRI=stream.readString();
    this.LGPL_MALE_NRD=stream.readString();
    this.LGPL_FEMALE_NRD=stream.readString();
    this.LGPL_PENS_COMM_RATE=stream.readBigDecimal();
    this.LGPL_PENS_PAYMENT_FREQ=stream.readString();
    this.LGPL_PENS_INTR_RATE=stream.readBigDecimal();
    this.LGPL_GRNTD_PRD=stream.readString();
    this.LGPL_EARNINGS_ESC=stream.readString();
    this.LGPL_VAL_YEAR=stream.readString();
    this.LGPL_AGGREGATE=stream.readString();
    this.LGPL_FUND_BAL=stream.readString();     
         
  }
  
  public void writeSQL(SQLOutput stream) throws SQLException {
    stream.writeBigDecimal(LGPL_SN);
    stream.writeString(LGPL_CLIENT);
    stream.writeBigDecimal(LGPL_NO_MEM);
    stream.writeString(LGPL_COIN_LEADER);
    stream.writeString(LGPL_SHARE);
    stream.writeDate(LGPL_COMMENC_DT);
    stream.writeDate(LGPL_RENEW_DT);
    stream.writeDate(LGPL_NEXT_REN_DT);
    stream.writeString(LGPL_RATES);
    stream.writeBigDecimal(LGPL_TOT_SA);
    stream.writeBigDecimal(LGPL_TOT_PREM);
    stream.writeBigDecimal(LGPL_TOT_PREM_PAID);
    stream.writeBigDecimal(LGPL_OUTS_PREM);
    stream.writeString(LGPL_PROD_NAME);
    stream.writeString(LGPL_AGENT_NAME);
    stream.writeString(LGPL_AGENT);
    stream.writeString(LGPL_POL_NO);
    stream.writeString(LGPL_BRANCH);
    stream.writeString(LGPL_AOI);
    stream.writeString(LGPL_COMM_RATE);
    stream.writeString(LGPL_OV_COMM_RATE);
    stream.writeString(LGPL_VAT_RATE);
    stream.writeString(LGPL_DURATION);
    stream.writeString(LGPL_FREQ_OF_PAY);
    stream.writeString(LGPL_POL_CATEGORY);
    stream.writeBigDecimal(LGPL_MULTI_EARNINGS);
    stream.writeBigDecimal(LGPL_FCL);
    stream.writeString(LGPL_REGISTERED);
    stream.writeString(LGPL_REG_NO);
    stream.writeString(LGPL_PENS_TYPE);
    stream.writeString(LGPL_CONTRI_TYPE);
    stream.writeString(LGPL_EMYE_CONTRI);
    stream.writeString(LGPL_EMYR_CONTRI);
    stream.writeString(LGPL_MALE_NRD);
    stream.writeString(LGPL_FEMALE_NRD);
    stream.writeBigDecimal(LGPL_PENS_COMM_RATE);
    stream.writeString(LGPL_PENS_PAYMENT_FREQ);
    stream.writeBigDecimal(LGPL_PENS_INTR_RATE);
    stream.writeString(LGPL_GRNTD_PRD);
    stream.writeString(LGPL_EARNINGS_ESC);
    stream.writeString(LGPL_VAL_YEAR);
    stream.writeString(LGPL_AGGREGATE);
    stream.writeString(LGPL_FUND_BAL);
  }


    public void setLGPL_SN(BigDecimal LGPL_SN) {
        this.LGPL_SN = LGPL_SN;
    }

    public BigDecimal getLGPL_SN() {
        return LGPL_SN;
    }

    public void setLGPL_CLIENT(String LGPL_CLIENT) {
        this.LGPL_CLIENT = LGPL_CLIENT;
    }

    public String getLGPL_CLIENT() {
        return LGPL_CLIENT;
    }

    public void setLGPL_NO_MEM(BigDecimal LGPL_NO_MEM) {
        this.LGPL_NO_MEM = LGPL_NO_MEM;
    }

    public BigDecimal getLGPL_NO_MEM() {
        return LGPL_NO_MEM;
    }

    public void setLGPL_COIN_LEADER(String LGPL_COIN_LEADER) {
        this.LGPL_COIN_LEADER = LGPL_COIN_LEADER;
    }

    public String getLGPL_COIN_LEADER() {
        return LGPL_COIN_LEADER;
    }

    public void setLGPL_SHARE(String LGPL_SHARE) {
        this.LGPL_SHARE = LGPL_SHARE;
    }

    public String getLGPL_SHARE() {
        return LGPL_SHARE;
    }

    public void setLGPL_COMMENC_DT(Date LGPL_COMMENC_DT) {
        this.LGPL_COMMENC_DT = LGPL_COMMENC_DT;
    }

    public Date getLGPL_COMMENC_DT() {
        return LGPL_COMMENC_DT;
    }

    public void setLGPL_RENEW_DT(Date LGPL_RENEW_DT) {
        this.LGPL_RENEW_DT = LGPL_RENEW_DT;
    }

    public Date getLGPL_RENEW_DT() {
        return LGPL_RENEW_DT;
    }

    public void setLGPL_NEXT_REN_DT(Date LGPL_NEXT_REN_DT) {
        this.LGPL_NEXT_REN_DT = LGPL_NEXT_REN_DT;
    }

    public Date getLGPL_NEXT_REN_DT() {
        return LGPL_NEXT_REN_DT;
    }

    public void setLGPL_RATES(String LGPL_RATES) {
        this.LGPL_RATES = LGPL_RATES;
    }

    public String getLGPL_RATES() {
        return LGPL_RATES;
    }

    public void setLGPL_TOT_SA(BigDecimal LGPL_TOT_SA) {
        this.LGPL_TOT_SA = LGPL_TOT_SA;
    }

    public BigDecimal getLGPL_TOT_SA() {
        return LGPL_TOT_SA;
    }

    public void setLGPL_TOT_PREM(BigDecimal LGPL_TOT_PREM) {
        this.LGPL_TOT_PREM = LGPL_TOT_PREM;
    }

    public BigDecimal getLGPL_TOT_PREM() {
        return LGPL_TOT_PREM;
    }

    public void setLGPL_TOT_PREM_PAID(BigDecimal LGPL_TOT_PREM_PAID) {
        this.LGPL_TOT_PREM_PAID = LGPL_TOT_PREM_PAID;
    }

    public BigDecimal getLGPL_TOT_PREM_PAID() {
        return LGPL_TOT_PREM_PAID;
    }

    public void setLGPL_OUTS_PREM(BigDecimal LGPL_OUTS_PREM) {
        this.LGPL_OUTS_PREM = LGPL_OUTS_PREM;
    }

    public BigDecimal getLGPL_OUTS_PREM() {
        return LGPL_OUTS_PREM;
    }

    public void setLGPL_PROD_NAME(String LGPL_PROD_NAME) {
        this.LGPL_PROD_NAME = LGPL_PROD_NAME;
    }

    public String getLGPL_PROD_NAME() {
        return LGPL_PROD_NAME;
    }

    public void setLGPL_AGENT_NAME(String LGPL_AGENT_NAME) {
        this.LGPL_AGENT_NAME = LGPL_AGENT_NAME;
    }

    public String getLGPL_AGENT_NAME() {
        return LGPL_AGENT_NAME;
    }

    public void setLGPL_AGENT(String LGPL_AGENT) {
        this.LGPL_AGENT = LGPL_AGENT;
    }

    public String getLGPL_AGENT() {
        return LGPL_AGENT;
    }

    public void setLGPL_POL_NO(String LGPL_POL_NO) {
        this.LGPL_POL_NO = LGPL_POL_NO;
    }

    public String getLGPL_POL_NO() {
        return LGPL_POL_NO;
    }

    public void setLGPL_BRANCH(String LGPL_BRANCH) {
        this.LGPL_BRANCH = LGPL_BRANCH;
    }

    public String getLGPL_BRANCH() {
        return LGPL_BRANCH;
    }

    public void setLGPL_AOI(String LGPL_AOI) {
        this.LGPL_AOI = LGPL_AOI;
    }

    public String getLGPL_AOI() {
        return LGPL_AOI;
    }

    public void setLGPL_COMM_RATE(String LGPL_COMM_RATE) {
        this.LGPL_COMM_RATE = LGPL_COMM_RATE;
    }

    public String getLGPL_COMM_RATE() {
        return LGPL_COMM_RATE;
    }

    public void setLGPL_OV_COMM_RATE(String LGPL_OV_COMM_RATE) {
        this.LGPL_OV_COMM_RATE = LGPL_OV_COMM_RATE;
    }

    public String getLGPL_OV_COMM_RATE() {
        return LGPL_OV_COMM_RATE;
    }

    public void setLGPL_VAT_RATE(String LGPL_VAT_RATE) {
        this.LGPL_VAT_RATE = LGPL_VAT_RATE;
    }

    public String getLGPL_VAT_RATE() {
        return LGPL_VAT_RATE;
    }

    public void setLGPL_DURATION(String LGPL_DURATION) {
        this.LGPL_DURATION = LGPL_DURATION;
    }

    public String getLGPL_DURATION() {
        return LGPL_DURATION;
    }

    public void setLGPL_FREQ_OF_PAY(String LGPL_FREQ_OF_PAY) {
        this.LGPL_FREQ_OF_PAY = LGPL_FREQ_OF_PAY;
    }

    public String getLGPL_FREQ_OF_PAY() {
        return LGPL_FREQ_OF_PAY;
    }

    public void setLGPL_POL_CATEGORY(String LGPL_POL_CATEGORY) {
        this.LGPL_POL_CATEGORY = LGPL_POL_CATEGORY;
    }

    public String getLGPL_POL_CATEGORY() {
        return LGPL_POL_CATEGORY;
    }

    public void setLGPL_MULTI_EARNINGS(BigDecimal LGPL_MULTI_EARNINGS) {
        this.LGPL_MULTI_EARNINGS = LGPL_MULTI_EARNINGS;
    }

    public BigDecimal getLGPL_MULTI_EARNINGS() {
        return LGPL_MULTI_EARNINGS;
    }

    public void setLGPL_FCL(BigDecimal LGPL_FCL) {
        this.LGPL_FCL = LGPL_FCL;
    }

    public BigDecimal getLGPL_FCL() {
        return LGPL_FCL;
    }

    public void setLGPL_REGISTERED(String LGPL_REGISTERED) {
        this.LGPL_REGISTERED = LGPL_REGISTERED;
    }

    public String getLGPL_REGISTERED() {
        return LGPL_REGISTERED;
    }

    public void setLGPL_REG_NO(String LGPL_REG_NO) {
        this.LGPL_REG_NO = LGPL_REG_NO;
    }

    public String getLGPL_REG_NO() {
        return LGPL_REG_NO;
    }

    public void setLGPL_PENS_TYPE(String LGPL_PENS_TYPE) {
        this.LGPL_PENS_TYPE = LGPL_PENS_TYPE;
    }

    public String getLGPL_PENS_TYPE() {
        return LGPL_PENS_TYPE;
    }

    public void setLGPL_CONTRI_TYPE(String LGPL_CONTRI_TYPE) {
        this.LGPL_CONTRI_TYPE = LGPL_CONTRI_TYPE;
    }

    public String getLGPL_CONTRI_TYPE() {
        return LGPL_CONTRI_TYPE;
    }

    public void setLGPL_EMYE_CONTRI(String LGPL_EMYE_CONTRI) {
        this.LGPL_EMYE_CONTRI = LGPL_EMYE_CONTRI;
    }

    public String getLGPL_EMYE_CONTRI() {
        return LGPL_EMYE_CONTRI;
    }

    public void setLGPL_EMYR_CONTRI(String LGPL_EMYR_CONTRI) {
        this.LGPL_EMYR_CONTRI = LGPL_EMYR_CONTRI;
    }

    public String getLGPL_EMYR_CONTRI() {
        return LGPL_EMYR_CONTRI;
    }

    public void setLGPL_MALE_NRD(String LGPL_MALE_NRD) {
        this.LGPL_MALE_NRD = LGPL_MALE_NRD;
    }

    public String getLGPL_MALE_NRD() {
        return LGPL_MALE_NRD;
    }

    public void setLGPL_FEMALE_NRD(String LGPL_FEMALE_NRD) {
        this.LGPL_FEMALE_NRD = LGPL_FEMALE_NRD;
    }

    public String getLGPL_FEMALE_NRD() {
        return LGPL_FEMALE_NRD;
    }

    public void setLGPL_PENS_COMM_RATE(BigDecimal LGPL_PENS_COMM_RATE) {
        this.LGPL_PENS_COMM_RATE = LGPL_PENS_COMM_RATE;
    }

    public BigDecimal getLGPL_PENS_COMM_RATE() {
        return LGPL_PENS_COMM_RATE;
    }

    public void setLGPL_PENS_PAYMENT_FREQ(String LGPL_PENS_PAYMENT_FREQ) {
        this.LGPL_PENS_PAYMENT_FREQ = LGPL_PENS_PAYMENT_FREQ;
    }

    public String getLGPL_PENS_PAYMENT_FREQ() {
        return LGPL_PENS_PAYMENT_FREQ;
    }

    public void setLGPL_PENS_INTR_RATE(BigDecimal LGPL_PENS_INTR_RATE) {
        this.LGPL_PENS_INTR_RATE = LGPL_PENS_INTR_RATE;
    }

    public BigDecimal getLGPL_PENS_INTR_RATE() {
        return LGPL_PENS_INTR_RATE;
    }

    public void setLGPL_GRNTD_PRD(String LGPL_GRNTD_PRD) {
        this.LGPL_GRNTD_PRD = LGPL_GRNTD_PRD;
    }

    public String getLGPL_GRNTD_PRD() {
        return LGPL_GRNTD_PRD;
    }

    public void setLGPL_EARNINGS_ESC(String LGPL_EARNINGS_ESC) {
        this.LGPL_EARNINGS_ESC = LGPL_EARNINGS_ESC;
    }

    public String getLGPL_EARNINGS_ESC() {
        return LGPL_EARNINGS_ESC;
    }

    public void setLGPL_VAL_YEAR(String LGPL_VAL_YEAR) {
        this.LGPL_VAL_YEAR = LGPL_VAL_YEAR;
    }

    public String getLGPL_VAL_YEAR() {
        return LGPL_VAL_YEAR;
    }

    public void setLGPL_AGGREGATE(String LGPL_AGGREGATE) {
        this.LGPL_AGGREGATE = LGPL_AGGREGATE;
    }

    public String getLGPL_AGGREGATE() {
        return LGPL_AGGREGATE;
    }

    public void setLGPL_FUND_BAL(String LGPL_FUND_BAL) {
        this.LGPL_FUND_BAL = LGPL_FUND_BAL;
    }

    public String getLGPL_FUND_BAL() {
        return LGPL_FUND_BAL;
    }
}
