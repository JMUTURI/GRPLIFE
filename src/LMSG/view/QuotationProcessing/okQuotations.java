package LMSG.view.QuotationProcessing;

import java.math.BigDecimal;

import java.util.Date;

public class okQuotations {
  public okQuotations() 
  {
  }
  private BigDecimal QUO_CODE,uwYear;
  private String  QUO_NO,Client,prod_sht_desc,product_display,branch,occupation,hazard,paymentFreq;
  private Date QUO_EFFECTIVE_DATE;

  public void setQUO_CODE(BigDecimal QUO_CODE) {
    this.QUO_CODE = QUO_CODE;
  }

  public BigDecimal getQUO_CODE() {
    return QUO_CODE;
  }

  public void setQUO_NO(String QUO_NO) {
    this.QUO_NO = QUO_NO;
  }

  public String getQUO_NO() {
    return QUO_NO;
  }

  public void setClient(String Client) {
    this.Client = Client;
  }

  public String getClient() {
    return Client;
  }

  public void setQUO_EFFECTIVE_DATE(Date QUO_EFFECTIVE_DATE) {
    this.QUO_EFFECTIVE_DATE = QUO_EFFECTIVE_DATE;
  }

  public Date getQUO_EFFECTIVE_DATE() {
    return QUO_EFFECTIVE_DATE;
  }

  public void setUwYear(BigDecimal uwYear) {
    this.uwYear = uwYear;
  }

  public BigDecimal getUwYear() {
    return uwYear;
  }

  public void setProd_sht_desc(String prod_sht_desc) {
    this.prod_sht_desc = prod_sht_desc;
  }

  public String getProd_sht_desc() {
    return prod_sht_desc;
  }

  public void setProduct_display(String product_display) {
    this.product_display = product_display;
  }

  public String getProduct_display() {
    return product_display;
  }

  public void setBranch(String branch) {
    this.branch = branch;
  }

  public String getBranch() {
    return branch;
  }

  public void setOccupation(String occupation) {
    this.occupation = occupation;
  }

  public String getOccupation() {
    return occupation;
  }

  public void setHazard(String hazard) {
    this.hazard = hazard;
  }

  public String getHazard() {
    return hazard;
  }

  public void setPaymentFreq(String paymentFreq) {
    this.paymentFreq = paymentFreq;
  }

  public String getPaymentFreq() {
    return paymentFreq;
  }
}
