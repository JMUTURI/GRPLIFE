package LMSG.view.TableTypes;

import java.io.Serializable;

import java.math.BigDecimal;

import java.sql.Date;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class PolicyClient implements SQLData, Serializable{
    public PolicyClient() {
        super();
    }
  private BigDecimal LGCD_SN;
  private String LGCD_CLIENT_ID; 
  private String LGCD_NAME;
  private String LGCD_CLIENT_ADDRESS;
  private String LGCD_AGENT_ADDRESS;
  private String LGCD_CLIENT_TOWN;
  private String LGCD_CLIENT_COUNTRY;
  private String LGCD_CLIENT_TEL;
  private String LGCD_AGENT_TEL;
  private String LGCD_CLIENT_FAX;
  private String LGCD_OCCUPATION;
  private String LGCD_CLIENT_BANK_NAME;
  private String LGCD_BANK_BRANCH;
  private String LGCD_ACC_NO; 

  public String getSQLTypeName() {
      return "LMS_POLICIES_CLIENT_LOADING";
  }
  
  public void readSQL(SQLInput stream, String typeName) throws SQLException {
    this.LGCD_SN=stream.readBigDecimal();
    this.LGCD_CLIENT_ID=stream.readString();
    this.LGCD_NAME=stream.readString();
    this.LGCD_CLIENT_ADDRESS=stream.readString();
    this.LGCD_AGENT_ADDRESS=stream.readString(); 
    this.LGCD_CLIENT_TOWN=stream.readString(); 
    this.LGCD_CLIENT_COUNTRY=stream.readString();
    this.LGCD_CLIENT_TEL=stream.readString();
    this.LGCD_AGENT_TEL=stream.readString();
    this.LGCD_CLIENT_FAX=stream.readString();
    this.LGCD_OCCUPATION=stream.readString();
    this.LGCD_CLIENT_BANK_NAME=stream.readString();   
    this.LGCD_BANK_BRANCH=stream.readString();  
    this.LGCD_ACC_NO=stream.readString();
  }
  
  public void writeSQL(SQLOutput stream) throws SQLException {
    stream.writeBigDecimal(LGCD_SN);
    stream.writeString(LGCD_CLIENT_ID);    
    stream.writeString(LGCD_NAME);
    stream.writeString(LGCD_CLIENT_ADDRESS);
    stream.writeString(LGCD_AGENT_ADDRESS);
    stream.writeString(LGCD_CLIENT_TOWN);
    stream.writeString(LGCD_CLIENT_COUNTRY);
    stream.writeString(LGCD_CLIENT_TEL);
    stream.writeString(LGCD_AGENT_TEL);
    stream.writeString(LGCD_CLIENT_FAX);
    stream.writeString(LGCD_OCCUPATION);
    stream.writeString(LGCD_CLIENT_BANK_NAME);
    stream.writeString(LGCD_BANK_BRANCH);  
    stream.writeString(LGCD_ACC_NO); 

  }


    public void setLGCD_SN(BigDecimal LGCD_SN) {
        this.LGCD_SN = LGCD_SN;
    }

    public BigDecimal getLGCD_SN() {
        return LGCD_SN;
    }

    public void setLGCD_CLIENT_ID(String LGCD_CLIENT_ID) {
        this.LGCD_CLIENT_ID = LGCD_CLIENT_ID;
    }

    public String getLGCD_CLIENT_ID() {
        return LGCD_CLIENT_ID;
    }

    public void setLGCD_NAME(String LGCD_NAME) {
        this.LGCD_NAME = LGCD_NAME;
    }

    public String getLGCD_NAME() {
        return LGCD_NAME;
    }

    public void setLGCD_CLIENT_ADDRESS(String LGCD_CLIENT_ADDRESS) {
        this.LGCD_CLIENT_ADDRESS = LGCD_CLIENT_ADDRESS;
    }

    public String getLGCD_CLIENT_ADDRESS() {
        return LGCD_CLIENT_ADDRESS;
    }

    public void setLGCD_AGENT_ADDRESS(String LGCD_AGENT_ADDRESS) {
        this.LGCD_AGENT_ADDRESS = LGCD_AGENT_ADDRESS;
    }

    public String getLGCD_AGENT_ADDRESS() {
        return LGCD_AGENT_ADDRESS;
    }

    public void setLGCD_CLIENT_TOWN(String LGCD_CLIENT_TOWN) {
        this.LGCD_CLIENT_TOWN = LGCD_CLIENT_TOWN;
    }

    public String getLGCD_CLIENT_TOWN() {
        return LGCD_CLIENT_TOWN;
    }

    public void setLGCD_CLIENT_COUNTRY(String LGCD_CLIENT_COUNTRY) {
        this.LGCD_CLIENT_COUNTRY = LGCD_CLIENT_COUNTRY;
    }

    public String getLGCD_CLIENT_COUNTRY() {
        return LGCD_CLIENT_COUNTRY;
    }

    public void setLGCD_CLIENT_TEL(String LGCD_CLIENT_TEL) {
        this.LGCD_CLIENT_TEL = LGCD_CLIENT_TEL;
    }

    public String getLGCD_CLIENT_TEL() {
        return LGCD_CLIENT_TEL;
    }

    public void setLGCD_AGENT_TEL(String LGCD_AGENT_TEL) {
        this.LGCD_AGENT_TEL = LGCD_AGENT_TEL;
    }

    public String getLGCD_AGENT_TEL() {
        return LGCD_AGENT_TEL;
    }

    public void setLGCD_CLIENT_FAX(String LGCD_CLIENT_FAX) {
        this.LGCD_CLIENT_FAX = LGCD_CLIENT_FAX;
    }

    public String getLGCD_CLIENT_FAX() {
        return LGCD_CLIENT_FAX;
    }

    public void setLGCD_OCCUPATION(String LGCD_OCCUPATION) {
        this.LGCD_OCCUPATION = LGCD_OCCUPATION;
    }

    public String getLGCD_OCCUPATION() {
        return LGCD_OCCUPATION;
    }

    public void setLGCD_CLIENT_BANK_NAME(String LGCD_CLIENT_BANK_NAME) {
        this.LGCD_CLIENT_BANK_NAME = LGCD_CLIENT_BANK_NAME;
    }

    public String getLGCD_CLIENT_BANK_NAME() {
        return LGCD_CLIENT_BANK_NAME;
    }

    public void setLGCD_BANK_BRANCH(String LGCD_BANK_BRANCH) {
        this.LGCD_BANK_BRANCH = LGCD_BANK_BRANCH;
    }

    public String getLGCD_BANK_BRANCH() {
        return LGCD_BANK_BRANCH;
    }

    public void setLGCD_ACC_NO(String LGCD_ACC_NO) {
        this.LGCD_ACC_NO = LGCD_ACC_NO;
    }

    public String getLGCD_ACC_NO() {
        return LGCD_ACC_NO;
    }
}
