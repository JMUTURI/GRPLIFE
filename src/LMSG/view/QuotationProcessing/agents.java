package LMSG.view.QuotationProcessing;

import java.math.BigDecimal;

public class agents {
  public agents() 
  {
  }
  private BigDecimal AGN_CODE;
 private String  AGN_NAME,AGN_SHT_DESC,  AGN_POSTAL_ADDRESS,Agent;

  public void setAGN_CODE(BigDecimal AGN_CODE) {
    this.AGN_CODE = AGN_CODE;
  }

  public BigDecimal getAGN_CODE() {
    return AGN_CODE;
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

  public void setAGN_POSTAL_ADDRESS(String AGN_POSTAL_ADDRESS) {
    this.AGN_POSTAL_ADDRESS = AGN_POSTAL_ADDRESS;
  }

  public String getAGN_POSTAL_ADDRESS() {
    return AGN_POSTAL_ADDRESS;
  }

  public void setAgent(String Agent) {
    this.Agent = Agent;
  }

  public String getAgent() {
    return Agent;
  }
}
