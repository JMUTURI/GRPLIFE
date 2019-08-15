package LMSG.view.TableTypes;

import java.io.Serializable;

import java.math.BigDecimal;

import java.sql.Date;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class MemberBeneficiaries implements SQLData, Serializable {
    public MemberBeneficiaries() {
        super();
    }
    
  private BigDecimal LMIB_CODE;
  private BigDecimal LMIB_LMIT_CODE;
  private String LMIB_MEM_NO;
  private String LMIB_MAIN_MEM_NO;
  private String LMIB_MEM_SURNAME;
  private String LMIB_MEM_OTHERNAMES;
  private Date LMIB_MEM_DOB;
  private String LMIB_MEM_SEX;
  private String LMIB_ID_NO;
  private String LMIB_RET_DESC;
  private String LMIB_COMMENTS;
  private BigDecimal LMIB_SHARE;
  
  
  public String getSQLTypeName() {
      return "LMS_MEMBER_BENEFICIARY_OBJ";
  }
  
  public void readSQL(SQLInput stream, String typeName) throws SQLException {
    this.LMIB_CODE=stream.readBigDecimal();
    this.LMIB_LMIT_CODE=stream.readBigDecimal();
    this.LMIB_MEM_NO=stream.readString();
    this.LMIB_MAIN_MEM_NO=stream.readString();
    this.LMIB_MEM_SURNAME=stream.readString();
    this.LMIB_MEM_OTHERNAMES=stream.readString();
    this.LMIB_MEM_DOB=stream.readDate();
    this.LMIB_MEM_SEX=stream.readString();
    this.LMIB_ID_NO=stream.readString();
    this.LMIB_RET_DESC=stream.readString();
    this.LMIB_COMMENTS=stream.readString();
    this.LMIB_SHARE=stream.readBigDecimal();
  }
  
  public void writeSQL(SQLOutput stream) throws SQLException {
    stream.writeBigDecimal(LMIB_CODE);
    stream.writeBigDecimal(LMIB_LMIT_CODE);
    stream.writeString(LMIB_MEM_NO);
    stream.writeString(LMIB_MAIN_MEM_NO);
    stream.writeString(LMIB_MEM_SURNAME);
    stream.writeString(LMIB_MEM_OTHERNAMES);
    stream.writeDate(LMIB_MEM_DOB);
    stream.writeString(LMIB_MEM_SEX);
    stream.writeString(LMIB_ID_NO);
    stream.writeString(LMIB_RET_DESC);
    stream.writeString(LMIB_COMMENTS);
    stream.writeBigDecimal(LMIB_SHARE);
    
  }

    public void setLMIB_CODE(BigDecimal LMIB_CODE) {
        this.LMIB_CODE = LMIB_CODE;
    }

    public BigDecimal getLMIB_CODE() {
        return LMIB_CODE;
    }

    public void setLMIB_LMIT_CODE(BigDecimal LMIB_LMIT_CODE) {
        this.LMIB_LMIT_CODE = LMIB_LMIT_CODE;
    }

    public BigDecimal getLMIB_LMIT_CODE() {
        return LMIB_LMIT_CODE;
    }

    public void setLMIB_MEM_NO(String LMIB_MEM_NO) {
        this.LMIB_MEM_NO = LMIB_MEM_NO;
    }

    public String getLMIB_MEM_NO() {
        return LMIB_MEM_NO;
    }

    public void setLMIB_MAIN_MEM_NO(String LMIB_MAIN_MEM_NO) {
        this.LMIB_MAIN_MEM_NO = LMIB_MAIN_MEM_NO;
    }

    public String getLMIB_MAIN_MEM_NO() {
        return LMIB_MAIN_MEM_NO;
    }

    public void setLMIB_MEM_SURNAME(String LMIB_MEM_SURNAME) {
        this.LMIB_MEM_SURNAME = LMIB_MEM_SURNAME;
    }

    public String getLMIB_MEM_SURNAME() {
        return LMIB_MEM_SURNAME;
    }

    public void setLMIB_MEM_OTHERNAMES(String LMIB_MEM_OTHERNAMES) {
        this.LMIB_MEM_OTHERNAMES = LMIB_MEM_OTHERNAMES;
    }

    public String getLMIB_MEM_OTHERNAMES() {
        return LMIB_MEM_OTHERNAMES;
    }

    public void setLMIB_MEM_DOB(Date LMIB_MEM_DOB) {
        this.LMIB_MEM_DOB = LMIB_MEM_DOB;
    }

    public Date getLMIB_MEM_DOB() {
        return LMIB_MEM_DOB;
    }

    public void setLMIB_MEM_SEX(String LMIB_MEM_SEX) {
        this.LMIB_MEM_SEX = LMIB_MEM_SEX;
    }

    public String getLMIB_MEM_SEX() {
        return LMIB_MEM_SEX;
    }

    public void setLMIB_ID_NO(String LMIB_ID_NO) {
        this.LMIB_ID_NO = LMIB_ID_NO;
    }

    public String getLMIB_ID_NO() {
        return LMIB_ID_NO;
    }

    public void setLMIB_RET_DESC(String LMIB_RET_DESC) {
        this.LMIB_RET_DESC = LMIB_RET_DESC;
    }

    public String getLMIB_RET_DESC() {
        return LMIB_RET_DESC;
    }

    public void setLMIB_COMMENTS(String LMIB_COMMENTS) {
        this.LMIB_COMMENTS = LMIB_COMMENTS;
    }

    public String getLMIB_COMMENTS() {
        return LMIB_COMMENTS;
    }

    public void setLMIB_SHARE(BigDecimal LMIB_SHARE) {
        this.LMIB_SHARE = LMIB_SHARE;
    }

    public BigDecimal getLMIB_SHARE() {
        return LMIB_SHARE;
    }
}
