package LMSG.view.Policy;

import java.math.BigDecimal;

public class checkOffAgents {
  public checkOffAgents() {
  }
  private BigDecimal AGN_CODE, AGN_AGENT_COMMISSION, AGN_AGENT_WHT_TAX;
  private String  AGN_NAME, AGN_SHT_DESC;

  public void setAGN_CODE(BigDecimal AGN_CODE) {
    this.AGN_CODE = AGN_CODE;
  }

  public BigDecimal getAGN_CODE() {
    return AGN_CODE;
  }

  public void setAGN_AGENT_COMMISSION(BigDecimal AGN_AGENT_COMMISSION) {
    this.AGN_AGENT_COMMISSION = AGN_AGENT_COMMISSION;
  }

  public BigDecimal getAGN_AGENT_COMMISSION() {
    return AGN_AGENT_COMMISSION;
  }

  public void setAGN_AGENT_WHT_TAX(BigDecimal AGN_AGENT_WHT_TAX) {
    this.AGN_AGENT_WHT_TAX = AGN_AGENT_WHT_TAX;
  }

  public BigDecimal getAGN_AGENT_WHT_TAX() {
    return AGN_AGENT_WHT_TAX;
  }

  public void setAGN_NAME(String AGN_NAME) {
    this.AGN_NAME = AGN_NAME;
  }

  public String getAGN_NAME() {
    return AGN_NAME;
  }

  public void setAGN_SHT_DESC(String AGN_SHT_DESC) {
    this.AGN_SHT_DESC = AGN_SHT_DESC;
  }

  public String getAGN_SHT_DESC() {
    return AGN_SHT_DESC;
  }
}
