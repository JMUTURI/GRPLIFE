package LMSG.view.Policy;

import java.math.BigDecimal;

import java.util.Date;

public class contraPolicies {
  public contraPolicies() {
  }
  private String POL_POLICY_NO,Client,POL_STATUS,POL_CALC_TYPE;
  private BigDecimal POL_INCEPTION_UWYR,POL_CODE,POL_CURRENT_ENDR_CODE;
  private Date POL_EFFECTIVE_DATE;

  public void setPOL_POLICY_NO(String POL_POLICY_NO) {
    this.POL_POLICY_NO = POL_POLICY_NO;
  }

  public String getPOL_POLICY_NO() {
    return POL_POLICY_NO;
  }

  public void setClient(String Client) {
    this.Client = Client;
  }

  public String getClient() {
    return Client;
  }

  public void setPOL_STATUS(String POL_STATUS) {
    this.POL_STATUS = POL_STATUS;
  }

  public String getPOL_STATUS() {
    return POL_STATUS;
  }

  public void setPOL_CALC_TYPE(String POL_CALC_TYPE) {
    this.POL_CALC_TYPE = POL_CALC_TYPE;
  }

  public String getPOL_CALC_TYPE() {
    return POL_CALC_TYPE;
  }

  public void setPOL_INCEPTION_UWYR(BigDecimal POL_INCEPTION_UWYR) {
    this.POL_INCEPTION_UWYR = POL_INCEPTION_UWYR;
  }

  public BigDecimal getPOL_INCEPTION_UWYR() {
    return POL_INCEPTION_UWYR;
  }

  public void setPOL_CODE(BigDecimal POL_CODE) {
    this.POL_CODE = POL_CODE;
  }

  public BigDecimal getPOL_CODE() {
    return POL_CODE;
  }

  public void setPOL_CURRENT_ENDR_CODE(BigDecimal POL_CURRENT_ENDR_CODE) {
    this.POL_CURRENT_ENDR_CODE = POL_CURRENT_ENDR_CODE;
  }

  public BigDecimal getPOL_CURRENT_ENDR_CODE() {
    return POL_CURRENT_ENDR_CODE;
  }

  public void setPOL_EFFECTIVE_DATE(Date POL_EFFECTIVE_DATE) {
    this.POL_EFFECTIVE_DATE = POL_EFFECTIVE_DATE;
  }

  public Date getPOL_EFFECTIVE_DATE() {
    return POL_EFFECTIVE_DATE;
  }
}
