package LMSG.view.Policy;

import java.math.BigDecimal;

public class RiTreaty {
  public RiTreaty() {
  }
  private BigDecimal TA_CODE;
  private String TA_SHT_DESC, TA_DESC;

  public void setTA_CODE(BigDecimal TA_CODE)
  {
    this.TA_CODE = TA_CODE;
  }

  public BigDecimal getTA_CODE() {
    return TA_CODE;
  }

  public void setTA_SHT_DESC(String TA_SHT_DESC) {
    this.TA_SHT_DESC = TA_SHT_DESC;
  }

  public String getTA_SHT_DESC() {
    return TA_SHT_DESC;
  }

  public void setTA_DESC(String TA_DESC) {
    this.TA_DESC = TA_DESC;
  }

  public String getTA_DESC() {
    return TA_DESC;
  }
}
