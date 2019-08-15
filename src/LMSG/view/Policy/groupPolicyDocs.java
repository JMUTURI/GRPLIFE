package LMSG.view.Policy;

import java.math.BigDecimal;

import java.util.Date;

public class groupPolicyDocs {
  public groupPolicyDocs() {
  }
  private BigDecimal GPD_CODE,GPD_RD_CODE;
  private String GPD_RD_SHT_DESC,DOCUMENT_DISPLAY,DOCUMENT_SUBMITTED,GPD_DOC_NO;
  private Date dateGiven;
  /*v_gpd_code                NUMBER DEFAULT NULL,
      v_gpd_rd_code             NUMBER,
      v_gpd_rd_sht_desc         VARCHAR2,
      v_is_document_submitted   VARCHAR2,
      v_date_given              DATE,
      v_doc_no                  VARCHAR2,
      v_endr_code   */

  public void setGPD_CODE(BigDecimal GPD_CODE) {
    this.GPD_CODE = GPD_CODE;
  }

  public BigDecimal getGPD_CODE() {
    return GPD_CODE;
  }

  public void setGPD_RD_CODE(BigDecimal GPD_RD_CODE) {
    this.GPD_RD_CODE = GPD_RD_CODE;
  }

  public BigDecimal getGPD_RD_CODE() {
    return GPD_RD_CODE;
  }

  public void setGPD_RD_SHT_DESC(String GPD_RD_SHT_DESC) {
    this.GPD_RD_SHT_DESC = GPD_RD_SHT_DESC;
  }

  public String getGPD_RD_SHT_DESC() {
    return GPD_RD_SHT_DESC;
  }

  public void setDOCUMENT_DISPLAY(String DOCUMENT_DISPLAY) {
    this.DOCUMENT_DISPLAY = DOCUMENT_DISPLAY;
  }

  public String getDOCUMENT_DISPLAY() {
    return DOCUMENT_DISPLAY;
  }

  public void setDOCUMENT_SUBMITTED(String DOCUMENT_SUBMITTED) {
    this.DOCUMENT_SUBMITTED = DOCUMENT_SUBMITTED;
  }

  public String getDOCUMENT_SUBMITTED() {
    return DOCUMENT_SUBMITTED;
  }

  public void setDateGiven(Date dateGiven) {
    this.dateGiven = dateGiven;
  }

  public Date getDateGiven() {
    return dateGiven;
  }

  public void setGPD_DOC_NO(String GPD_DOC_NO) {
    this.GPD_DOC_NO = GPD_DOC_NO;
  }

  public String getGPD_DOC_NO() {
    return GPD_DOC_NO;
  }
}
