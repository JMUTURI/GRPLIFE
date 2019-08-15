package LMSG.view.QuotationProcessing;

import java.math.BigDecimal;

public class dependents {
  public dependents() 
  {
  }
  private BigDecimal DTY_CODE,PCD_MAX_NO_ALLOWED, PCD_MAX_SUM_ASSURED,PCD_MIN_SUM_ASSURED,PCD_CVT_CODE ;
  private String DTY_SHT_DESC, DTY_DESCRIPTION;

  public void setDTY_CODE(BigDecimal DTY_CODE) {
    this.DTY_CODE = DTY_CODE;
  }

  public BigDecimal getDTY_CODE() {
    return DTY_CODE;
  }

  public void setPCD_MAX_NO_ALLOWED(BigDecimal PCD_MAX_NO_ALLOWED) {
    this.PCD_MAX_NO_ALLOWED = PCD_MAX_NO_ALLOWED;
  }

  public BigDecimal getPCD_MAX_NO_ALLOWED() {
    return PCD_MAX_NO_ALLOWED;
  }

  public void setDTY_SHT_DESC(String DTY_SHT_DESC) {
    this.DTY_SHT_DESC = DTY_SHT_DESC;
  }

  public String getDTY_SHT_DESC() {
    return DTY_SHT_DESC;
  }

  public void setDTY_DESCRIPTION(String DTY_DESCRIPTION) {
    this.DTY_DESCRIPTION = DTY_DESCRIPTION;
  }

  public String getDTY_DESCRIPTION() {
    return DTY_DESCRIPTION;
  }

    public void setPCD_MAX_SUM_ASSURED(BigDecimal PCD_MAX_SUM_ASSURED) {
        this.PCD_MAX_SUM_ASSURED = PCD_MAX_SUM_ASSURED;
    }

    public BigDecimal getPCD_MAX_SUM_ASSURED() {
        return PCD_MAX_SUM_ASSURED;
    }

    public void setPCD_MIN_SUM_ASSURED(BigDecimal PCD_MIN_SUM_ASSURED) {
        this.PCD_MIN_SUM_ASSURED = PCD_MIN_SUM_ASSURED;
    }

    public BigDecimal getPCD_MIN_SUM_ASSURED() {
        return PCD_MIN_SUM_ASSURED;
    }

    public void setPCD_CVT_CODE(BigDecimal PCD_CVT_CODE) {
        this.PCD_CVT_CODE = PCD_CVT_CODE;
    }

    public BigDecimal getPCD_CVT_CODE() {
        return PCD_CVT_CODE;
    }
}
