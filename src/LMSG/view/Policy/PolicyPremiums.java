package LMSG.view.Policy;

import java.math.BigDecimal;

public class PolicyPremiums {
  public PolicyPremiums() {
  }
  private String POL_POLICY_NO,Client,POL_INCEPTION_UWYR,POL_STATUS,PROD_TYPE;
  private BigDecimal POL_CODE;
  
  private BigDecimal ENDR_CODE;
  private String ENDR_TYPE;

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

  public void setPOL_INCEPTION_UWYR(String POL_INCEPTION_UWYR) {
    this.POL_INCEPTION_UWYR = POL_INCEPTION_UWYR;
  }

  public String getPOL_INCEPTION_UWYR() {
    return POL_INCEPTION_UWYR;
  }

  public void setPOL_STATUS(String POL_STATUS) {
    this.POL_STATUS = POL_STATUS;
  }

  public String getPOL_STATUS() {
    return POL_STATUS;
  }

  public void setPOL_CODE(BigDecimal POL_CODE) {
    this.POL_CODE = POL_CODE;
  }

  public BigDecimal getPOL_CODE() {
    return POL_CODE;
  }

  public void setPROD_TYPE(String PROD_TYPE) {
    this.PROD_TYPE = PROD_TYPE;
  }

  public String getPROD_TYPE() {
    return PROD_TYPE;
  }

    public void setENDR_CODE(BigDecimal ENDR_CODE) {
        this.ENDR_CODE = ENDR_CODE;
    }

    public BigDecimal getENDR_CODE() {
        return ENDR_CODE;
    }

    public void setENDR_TYPE(String ENDR_TYPE) {
        this.ENDR_TYPE = ENDR_TYPE;
    }

    public String getENDR_TYPE() {
        return ENDR_TYPE;
    }
}
