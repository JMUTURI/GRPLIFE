package LMSG.view.Policy;

import java.math.BigDecimal;

public class documents {
  public documents() {
  }
  private BigDecimal RD_CODE;
 private String RD_SHT_DESC,RD_DESC;

  public void setRD_CODE(BigDecimal RD_CODE) {
    this.RD_CODE = RD_CODE;
  }

  public BigDecimal getRD_CODE() {
    return RD_CODE;
  }

  public void setRD_SHT_DESC(String RD_SHT_DESC) {
    this.RD_SHT_DESC = RD_SHT_DESC;
  }

  public String getRD_SHT_DESC() {
    return RD_SHT_DESC;
  }

  public void setRD_DESC(String RD_DESC) {
    this.RD_DESC = RD_DESC;
  }

  public String getRD_DESC() {
    return RD_DESC;
  }
}
