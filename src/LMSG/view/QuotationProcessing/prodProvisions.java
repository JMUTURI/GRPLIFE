package LMSG.view.QuotationProcessing;

import java.math.BigDecimal;

public class prodProvisions {
  public prodProvisions() {
  }
  private BigDecimal PPROV_CODE,PPROV_PROD_CODE;
  private String PROV_SHT_DESC, PROV_DESC,PPROV_EDITABLE;

  public void setPPROV_EDITABLE(String PPROV_EDITABLE) {
    this.PPROV_EDITABLE = PPROV_EDITABLE;
  }

  public String getPPROV_EDITABLE() {
    return PPROV_EDITABLE;
  }

  public void setPPROV_CODE(BigDecimal PPROV_CODE) {
    this.PPROV_CODE = PPROV_CODE;
  }

  public BigDecimal getPPROV_CODE() {
    return PPROV_CODE;
  }

  public void setPPROV_PROD_CODE(BigDecimal PPROV_PROD_CODE) {
    this.PPROV_PROD_CODE = PPROV_PROD_CODE;
  }

  public BigDecimal getPPROV_PROD_CODE() {
    return PPROV_PROD_CODE;
  }

  public void setPROV_SHT_DESC(String PROV_SHT_DESC) {
    this.PROV_SHT_DESC = PROV_SHT_DESC;
  }

  public String getPROV_SHT_DESC() {
    return PROV_SHT_DESC;
  }

  public void setPROV_DESC(String PROV_DESC) {
    this.PROV_DESC = PROV_DESC;
  }

  public String getPROV_DESC() {
    return PROV_DESC;
  }
}
