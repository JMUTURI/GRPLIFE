package LMSG.view.TableTypes;

import java.io.Serializable;

import java.math.BigDecimal;

import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class AnnuityPayments  implements SQLData, Serializable {
    public AnnuityPayments() {
        super();
    }
    
  private String CLAIM_NO;
  private BigDecimal PCY_CODE;
  private BigDecimal POL_CODE;
  private BigDecimal TRANS_NO;
  private BigDecimal PMPNS_CODE;
  private String PMPNS_TAX_PAYABLE;
    
  public String getSQLTypeName() {
      return "LMS_PENSION_MATURITY_PYMT";
  }
  
  public void readSQL(SQLInput stream, String typeName) throws SQLException {
    this.CLAIM_NO=stream.readString();
    this.PCY_CODE=stream.readBigDecimal();
    this.POL_CODE=stream.readBigDecimal();
    this.TRANS_NO=stream.readBigDecimal();
    this.PMPNS_CODE=stream.readBigDecimal();
    this.PMPNS_TAX_PAYABLE=stream.readString();
  }
  
  public void writeSQL(SQLOutput stream) throws SQLException {
    stream.writeString(CLAIM_NO);
    stream.writeBigDecimal(PCY_CODE);
    stream.writeBigDecimal(POL_CODE);
    stream.writeBigDecimal(TRANS_NO);
    stream.writeBigDecimal(PMPNS_CODE);
    stream.writeString(PMPNS_TAX_PAYABLE);
  }

    public void setCLAIM_NO(String CLAIM_NO) {
        this.CLAIM_NO = CLAIM_NO;
    }

    public String getCLAIM_NO() {
        return CLAIM_NO;
    }

    public void setPCY_CODE(BigDecimal PCY_CODE) {
        this.PCY_CODE = PCY_CODE;
    }

    public BigDecimal getPCY_CODE() {
        return PCY_CODE;
    }

    public void setTRANS_NO(BigDecimal TRANS_NO) {
        this.TRANS_NO = TRANS_NO;
    }

    public BigDecimal getTRANS_NO() {
        return TRANS_NO;
    }

    public void setPMPNS_CODE(BigDecimal PMPNS_CODE) {
        this.PMPNS_CODE = PMPNS_CODE;
    }

    public BigDecimal getPMPNS_CODE() {
        return PMPNS_CODE;
    }

    public void setPMPNS_TAX_PAYABLE(String PMPNS_TAX_PAYABLE) {
        this.PMPNS_TAX_PAYABLE = PMPNS_TAX_PAYABLE;
    }

    public String getPMPNS_TAX_PAYABLE() {
        return PMPNS_TAX_PAYABLE;
    }

    public void setPOL_CODE(BigDecimal POL_CODE) {
        this.POL_CODE = POL_CODE;
    }

    public BigDecimal getPOL_CODE() {
        return POL_CODE;
    }
}
