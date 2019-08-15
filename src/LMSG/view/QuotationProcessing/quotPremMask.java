package LMSG.view.QuotationProcessing;

import java.math.BigDecimal;

public class quotPremMask {
  public quotPremMask() {
  }
    private BigDecimal PMAS_CODE; 
    private String PMAS_SHT_DESC,PMAS_DESC;

  public void setPMAS_CODE(BigDecimal PMAS_CODE) {
    this.PMAS_CODE = PMAS_CODE;
  }

  public BigDecimal getPMAS_CODE() {
    return PMAS_CODE;
  }

  public void setPMAS_SHT_DESC(String PMAS_SHT_DESC) {
    this.PMAS_SHT_DESC = PMAS_SHT_DESC;
  }

  public String getPMAS_SHT_DESC() {
    return PMAS_SHT_DESC;
  }

  public void setPMAS_DESC(String PMAS_DESC) {
    this.PMAS_DESC = PMAS_DESC;
  }

  public String getPMAS_DESC() {
    return PMAS_DESC;
  }
}
