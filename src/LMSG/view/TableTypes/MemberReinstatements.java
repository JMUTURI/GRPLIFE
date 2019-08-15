package LMSG.view.TableTypes;

import java.io.Serializable;

import java.math.BigDecimal;

import java.sql.Date;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class MemberReinstatements implements SQLData, Serializable {
    public MemberReinstatements() {
        super();
    }
 
  private BigDecimal POLM_CODE;
  private Date PCM_LOAN_ISSUE_DATE;
  private BigDecimal PCM_ORIG_LOAN_REPAYMENT_PRD;
  private BigDecimal PCM_ORIGINAL_LOAN_AMT;
  private BigDecimal PCM_EARNINGS;
  private BigDecimal PCM_SAVING_AMT;
  private BigDecimal PCM_MULT_EARNINGS_PRD;
  
  public String getSQLTypeName() {
      return "LMS_MEMBER_REINST_OBJ";
  }
  
  public void readSQL(SQLInput stream, String typeName) throws SQLException {
    this.POLM_CODE=stream.readBigDecimal();
    this.PCM_LOAN_ISSUE_DATE=stream.readDate();
    this.PCM_ORIG_LOAN_REPAYMENT_PRD=stream.readBigDecimal();
    this.PCM_ORIGINAL_LOAN_AMT=stream.readBigDecimal();
    this.PCM_EARNINGS=stream.readBigDecimal();
    this.PCM_SAVING_AMT=stream.readBigDecimal();
    this.PCM_MULT_EARNINGS_PRD=stream.readBigDecimal();
    
    
  }
  
  public void writeSQL(SQLOutput stream) throws SQLException {
    stream.writeBigDecimal(POLM_CODE);
    stream.writeDate(PCM_LOAN_ISSUE_DATE);
    stream.writeBigDecimal(PCM_ORIG_LOAN_REPAYMENT_PRD);
    stream.writeBigDecimal(PCM_ORIGINAL_LOAN_AMT);
    stream.writeBigDecimal(PCM_EARNINGS);
    stream.writeBigDecimal(PCM_SAVING_AMT);
    stream.writeBigDecimal(PCM_MULT_EARNINGS_PRD);
  }

    public void setPOLM_CODE(BigDecimal POLM_CODE) {
        this.POLM_CODE = POLM_CODE;
    }

    public BigDecimal getPOLM_CODE() {
        return POLM_CODE;
    }

    public void setPCM_LOAN_ISSUE_DATE(Date PCM_LOAN_ISSUE_DATE) {
        this.PCM_LOAN_ISSUE_DATE = PCM_LOAN_ISSUE_DATE;
    }

    public Date getPCM_LOAN_ISSUE_DATE() {
        return PCM_LOAN_ISSUE_DATE;
    }

    public void setPCM_ORIG_LOAN_REPAYMENT_PRD(BigDecimal PCM_ORIG_LOAN_REPAYMENT_PRD) {
        this.PCM_ORIG_LOAN_REPAYMENT_PRD = PCM_ORIG_LOAN_REPAYMENT_PRD;
    }

    public BigDecimal getPCM_ORIG_LOAN_REPAYMENT_PRD() {
        return PCM_ORIG_LOAN_REPAYMENT_PRD;
    }

    public void setPCM_ORIGINAL_LOAN_AMT(BigDecimal PCM_ORIGINAL_LOAN_AMT) {
        this.PCM_ORIGINAL_LOAN_AMT = PCM_ORIGINAL_LOAN_AMT;
    }

    public BigDecimal getPCM_ORIGINAL_LOAN_AMT() {
        return PCM_ORIGINAL_LOAN_AMT;
    }

    public void setPCM_EARNINGS(BigDecimal PCM_EARNINGS) {
        this.PCM_EARNINGS = PCM_EARNINGS;
    }

    public BigDecimal getPCM_EARNINGS() {
        return PCM_EARNINGS;
    }

    public void setPCM_SAVING_AMT(BigDecimal PCM_SAVING_AMT) {
        this.PCM_SAVING_AMT = PCM_SAVING_AMT;
    }

    public BigDecimal getPCM_SAVING_AMT() {
        return PCM_SAVING_AMT;
    }

    public void setPCM_MULT_EARNINGS_PRD(BigDecimal PCM_MULT_EARNINGS_PRD) {
        this.PCM_MULT_EARNINGS_PRD = PCM_MULT_EARNINGS_PRD;
    }

    public BigDecimal getPCM_MULT_EARNINGS_PRD() {
        return PCM_MULT_EARNINGS_PRD;
    }
}
