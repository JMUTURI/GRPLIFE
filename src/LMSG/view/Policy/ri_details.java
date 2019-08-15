package LMSG.view.Policy;

import java.math.BigDecimal;

public class ri_details {
  public ri_details() {
  }
  private String  COVER_DISPLAY;
  //member Reinsurance Details
  private BigDecimal PMRID_PREV_SA,PMRID_TOT_SA,PMRID_ENDR_PREM,
       PMRID_GROSS_RETENTION,PMRID_NET_RETENTION,PMRID_EXCESS_AMT,PMRID_NET_RETENTION_RATE, PMRID_CODE;

  public void setCOVER_DISPLAY(String COVER_DISPLAY) {
    this.COVER_DISPLAY = COVER_DISPLAY;
  }

  public String getCOVER_DISPLAY() {
    return COVER_DISPLAY;
  }

  public void setPMRID_PREV_SA(BigDecimal PMRID_PREV_SA) {
    this.PMRID_PREV_SA = PMRID_PREV_SA;
  }

  public BigDecimal getPMRID_PREV_SA() {
    return PMRID_PREV_SA;
  }

  public void setPMRID_TOT_SA(BigDecimal PMRID_TOT_SA) {
    this.PMRID_TOT_SA = PMRID_TOT_SA;
  }

  public BigDecimal getPMRID_TOT_SA() {
    return PMRID_TOT_SA;
  }

  public void setPMRID_ENDR_PREM(BigDecimal PMRID_ENDR_PREM) {
    this.PMRID_ENDR_PREM = PMRID_ENDR_PREM;
  }

  public BigDecimal getPMRID_ENDR_PREM() {
    return PMRID_ENDR_PREM;
  }

  public void setPMRID_GROSS_RETENTION(BigDecimal PMRID_GROSS_RETENTION) {
    this.PMRID_GROSS_RETENTION = PMRID_GROSS_RETENTION;
  }

  public BigDecimal getPMRID_GROSS_RETENTION() {
    return PMRID_GROSS_RETENTION;
  }

 

 public void setPMRID_NET_RETENTION(BigDecimal PMRID_NET_RETENTION) {
    this.PMRID_NET_RETENTION = PMRID_NET_RETENTION;
  }

  public BigDecimal getPMRID_NET_RETENTION() {
    return PMRID_NET_RETENTION;
  }

  public void setPMRID_EXCESS_AMT(BigDecimal PMRID_EXCESS_AMT) {
    this.PMRID_EXCESS_AMT = PMRID_EXCESS_AMT;
  }

  public BigDecimal getPMRID_EXCESS_AMT() {
    return PMRID_EXCESS_AMT;
  }

  public void setPMRID_NET_RETENTION_RATE(BigDecimal PMRID_NET_RETENTION_RATE) {
    this.PMRID_NET_RETENTION_RATE = PMRID_NET_RETENTION_RATE;
  }

  public BigDecimal getPMRID_NET_RETENTION_RATE() {
    return PMRID_NET_RETENTION_RATE;
  }

    public void setPMRID_CODE(BigDecimal PMRID_CODE) {
        this.PMRID_CODE = PMRID_CODE;
    }

    public BigDecimal getPMRID_CODE() {
        return PMRID_CODE;
    }
}
