package LMSG.view.QuotationProcessing;

import java.math.BigDecimal;

public class quotCategory {
  private String catShtDesc;
  private String catDesc;
  private String catPeriod;
  private BigDecimal lcaCode;
  
  private BigDecimal pca_sch_code;
  private BigDecimal pca_lpag_code;
  private String lpag_desc;
  
  private BigDecimal pmas_code; 
  private String pmas_sht_desc;
  
  //education classes term limits
  private BigDecimal ctlCode;
  private BigDecimal ctlQuoCode;
  private BigDecimal ctlFee;
  private String categDesc;
  private BigDecimal ctlLcaCode;
  
  private String PCA_USE_CVR_RATE;
  private BigDecimal PCA_RATE;
  private BigDecimal PCA_RATE_DIV_FACT;
  
  public quotCategory() {
  }

  public void setCatShtDesc(String catShtDesc) {
    this.catShtDesc = catShtDesc;
  }

  public String getCatShtDesc() {
    return catShtDesc;
  }

  public void setCatDesc(String catDesc) {
    this.catDesc = catDesc;
  }

  public String getCatDesc() {
    return catDesc;
  }

  public void setCatPeriod(String catPeriod) {
    this.catPeriod = catPeriod;
  }

  public String getCatPeriod() {
    return catPeriod;
  }

  public void setLcaCode(BigDecimal lcaCode) {
    this.lcaCode = lcaCode;
  }

  public BigDecimal getLcaCode() {
    return lcaCode;
  }

    public void setCtlCode(BigDecimal ctlCode) {
        this.ctlCode = ctlCode;
    }

    public BigDecimal getCtlCode() {
        return ctlCode;
    }

    public void setCtlQuoCode(BigDecimal ctlQuoCode) {
        this.ctlQuoCode = ctlQuoCode;
    }

    public BigDecimal getCtlQuoCode() {
        return ctlQuoCode;
    }

    public void setCtlFee(BigDecimal ctlFee) {
        this.ctlFee = ctlFee;
    }

    public BigDecimal getCtlFee() {
        return ctlFee;
    }

    public void setCategDesc(String categDesc) {
        this.categDesc = categDesc;
    }

    public String getCategDesc() {
        return categDesc;
    }

    public void setCtlLcaCode(BigDecimal ctlLcaCode) {
        this.ctlLcaCode = ctlLcaCode;
    }

    public BigDecimal getCtlLcaCode() {
        return ctlLcaCode;
    }

    public void setPca_sch_code(BigDecimal pca_sch_code) {
        this.pca_sch_code = pca_sch_code;
    }

    public BigDecimal getPca_sch_code() {
        return pca_sch_code;
    }

    public void setPca_lpag_code(BigDecimal pca_lpag_code) {
        this.pca_lpag_code = pca_lpag_code;
    }

    public BigDecimal getPca_lpag_code() {
        return pca_lpag_code;
    }

    public void setLpag_desc(String lpag_desc) {
        this.lpag_desc = lpag_desc;
    }

    public String getLpag_desc() {
        return lpag_desc;
    }

    public void setPmas_code(BigDecimal pmas_code) {
        this.pmas_code = pmas_code;
    }

    public BigDecimal getPmas_code() {
        return pmas_code;
    }

    public void setPmas_sht_desc(String pmas_sht_desc) {
        this.pmas_sht_desc = pmas_sht_desc;
    }

    public String getPmas_sht_desc() {
        return pmas_sht_desc;
    }
    
    public void setPCA_USE_CVR_RATE(String PCA_USE_CVR_RATE) {
        this.PCA_USE_CVR_RATE = PCA_USE_CVR_RATE;
    }

    public String getPCA_USE_CVR_RATE() {
        return PCA_USE_CVR_RATE;
    }
    
    public void setPCA_RATE(BigDecimal PCA_RATE) {
        this.PCA_RATE = PCA_RATE;
    }

    public BigDecimal getPCA_RATE() {
        return PCA_RATE;
    }
    
    public void setPCA_RATE_DIV_FACT(BigDecimal PCA_RATE_DIV_FACT) {
        this.PCA_RATE_DIV_FACT = PCA_RATE_DIV_FACT;
    }

    public BigDecimal getPCA_RATE_DIV_FACT() {
        return PCA_RATE_DIV_FACT;
    }
}
