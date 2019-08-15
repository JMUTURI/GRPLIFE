package LMSG.view.TableTypes;

import java.io.Serializable;

import java.math.BigDecimal;

import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class ReceiptCommissions implements SQLData, Serializable {
    public ReceiptCommissions() {
        super();
    }
  private BigDecimal GRCT_CODE;
  private BigDecimal TRANS_CODE;
  private BigDecimal PCP_CODE;
  private BigDecimal CCL_CODE;
  
  public String getSQLTypeName() {
      return "LMS_RECEIPT_COMM";
  }
  
  public void readSQL(SQLInput stream, String typeName) throws SQLException {
    this.GRCT_CODE=stream.readBigDecimal();
    this.TRANS_CODE=stream.readBigDecimal();
    this.PCP_CODE=stream.readBigDecimal();
    this.CCL_CODE = stream.readBigDecimal();
  }
  
  public void writeSQL(SQLOutput stream) throws SQLException {
    stream.writeBigDecimal(GRCT_CODE);
    stream.writeBigDecimal(TRANS_CODE);
    stream.writeBigDecimal(PCP_CODE);
    stream.writeBigDecimal(CCL_CODE);
  }

    public void setGRCT_CODE(BigDecimal GRCT_CODE) {
        this.GRCT_CODE = GRCT_CODE;
    }

    public BigDecimal getGRCT_CODE() {
        return GRCT_CODE;
    }

    public void setTRANS_CODE(BigDecimal TRANS_CODE) {
        this.TRANS_CODE = TRANS_CODE;
    }

    public BigDecimal getTRANS_CODE() {
        return TRANS_CODE;
    }

    public void setPCP_CODE(BigDecimal PCP_CODE) {
        this.PCP_CODE = PCP_CODE;
    }

    public BigDecimal getPCP_CODE() {
        return PCP_CODE;
    }

    public void setCCL_CODE(BigDecimal CCL_CODE) {
        this.CCL_CODE = CCL_CODE;
    }

    public BigDecimal getCCL_CODE() {
        return CCL_CODE;
    }
}
