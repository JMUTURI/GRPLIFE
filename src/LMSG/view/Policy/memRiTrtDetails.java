package LMSG.view.Policy;

import java.math.BigDecimal;

import java.util.Date;

public class memRiTrtDetails {
  public memRiTrtDetails() {
  }
  private String COVER_DISPLAY, REI_TRS_SHT_DESC,PMRITD_remarks;
  private BigDecimal PMRITD_PREV_TRT_SA,PMRITD_TRT_SA,PMRITD_CESSION_RATE,PMRITD_TRT_PREM,
       PMRITD_TRT_COMM,PMRITD_STAMP_DUTY, PMRITD_CODE;
  
  private BigDecimal PMRITD_RATE;
  private BigDecimal PMRITD_RATE_DIV_FACTOR;
      
  //treaty cessions
  private String  CVT_SHT_DESC;
  private String GTRIC_AGN_SHT_DESC;
  private String GTRIC_TRS_SHT_DESC;
  private String GTRIC_TRT_SHT_DESC;
  private String GTRIC_CEDE_RATE;
  private String GTRIC_SI_AMT_PCUR;
  private String GTRIC_PREM_AMT_PCUR;
  private String GTRIC_COMM_AMT_PCUR;
  private String GTRIC_STAMP_DUTY;
  private String GTRIC_RPREM_TAX_PCUR;
  private String GTRIC_PREM_TAX_PCUR;
  private String GTRIC_UWYR;
  private String GTRIC_REFUND_PREM;
  
  private BigDecimal gfcCode;
  private String gfcAgnDesc;
  private String gfcAmtOrRate;
  private BigDecimal gfcAmt;
  private BigDecimal gfcRate;
  private BigDecimal gfcExcessRate;
  private BigDecimal gfcPremRate;
  private BigDecimal gfcPremDivFactor;
  private BigDecimal gfcPremAmt;
  private BigDecimal gfcCommRate;
  private BigDecimal gfcCommAmt;
  private Date gfcWef;
  private BigDecimal gfcAgnCode;
  
  private String agnShtDesc;
  private String agnName;
  private BigDecimal agnCode;
  
 private BigDecimal tot_sa; 
 private BigDecimal tot_ret;
 private BigDecimal tot_excess;
 
 private String memName;
 private BigDecimal rmal_amt_reassured;
 private BigDecimal rmal_tct_aal;
 
 private BigDecimal cvtCode;
 private String cvtDesc;
  

  public void setCOVER_DISPLAY(String COVER_DISPLAY) {
    this.COVER_DISPLAY = COVER_DISPLAY;
  }

  public String getCOVER_DISPLAY() {
    return COVER_DISPLAY;
  }

  public void setREI_TRS_SHT_DESC(String REI_TRS_SHT_DESC) {
    this.REI_TRS_SHT_DESC = REI_TRS_SHT_DESC;
  }

  public String getREI_TRS_SHT_DESC() {
    return REI_TRS_SHT_DESC;
  }

  public void setPMRITD_remarks(String PMRITD_remarks) {
    this.PMRITD_remarks = PMRITD_remarks;
  }

  public String getPMRITD_remarks() {
    return PMRITD_remarks;
  }

  public void setPMRITD_PREV_TRT_SA(BigDecimal PMRITD_PREV_TRT_SA) {
    this.PMRITD_PREV_TRT_SA = PMRITD_PREV_TRT_SA;
  }

  public BigDecimal getPMRITD_PREV_TRT_SA() {
    return PMRITD_PREV_TRT_SA;
  }

  public void setPMRITD_TRT_SA(BigDecimal PMRITD_TRT_SA) {
    this.PMRITD_TRT_SA = PMRITD_TRT_SA;
  }

  public BigDecimal getPMRITD_TRT_SA() {
    return PMRITD_TRT_SA;
  }

  public void setPMRITD_CESSION_RATE(BigDecimal PMRITD_CESSION_RATE) {
    this.PMRITD_CESSION_RATE = PMRITD_CESSION_RATE;
  }

  public BigDecimal getPMRITD_CESSION_RATE() {
    return PMRITD_CESSION_RATE;
  }

  public void setPMRITD_TRT_PREM(BigDecimal PMRITD_TRT_PREM) {
    this.PMRITD_TRT_PREM = PMRITD_TRT_PREM;
  }

  public BigDecimal getPMRITD_TRT_PREM() {
    return PMRITD_TRT_PREM;
  }

  public void setPMRITD_TRT_COMM(BigDecimal PMRITD_TRT_COMM) {
    this.PMRITD_TRT_COMM = PMRITD_TRT_COMM;
  }

  public BigDecimal getPMRITD_TRT_COMM() {
    return PMRITD_TRT_COMM;
  }

  public void setPMRITD_STAMP_DUTY(BigDecimal PMRITD_STAMP_DUTY) {
    this.PMRITD_STAMP_DUTY = PMRITD_STAMP_DUTY;
  }

  public BigDecimal getPMRITD_STAMP_DUTY() {
    return PMRITD_STAMP_DUTY;
  }

    public void setCVT_SHT_DESC(String CVT_SHT_DESC) {
        this.CVT_SHT_DESC = CVT_SHT_DESC;
    }

    public String getCVT_SHT_DESC() {
        return CVT_SHT_DESC;
    }

    public void setGTRIC_AGN_SHT_DESC(String GTRIC_AGN_SHT_DESC) {
        this.GTRIC_AGN_SHT_DESC = GTRIC_AGN_SHT_DESC;
    }

    public String getGTRIC_AGN_SHT_DESC() {
        return GTRIC_AGN_SHT_DESC;
    }

    public void setGTRIC_TRS_SHT_DESC(String GTRIC_TRS_SHT_DESC) {
        this.GTRIC_TRS_SHT_DESC = GTRIC_TRS_SHT_DESC;
    }

    public String getGTRIC_TRS_SHT_DESC() {
        return GTRIC_TRS_SHT_DESC;
    }

    public void setGTRIC_TRT_SHT_DESC(String GTRIC_TRT_SHT_DESC) {
        this.GTRIC_TRT_SHT_DESC = GTRIC_TRT_SHT_DESC;
    }

    public String getGTRIC_TRT_SHT_DESC() {
        return GTRIC_TRT_SHT_DESC;
    }

    public void setGTRIC_CEDE_RATE(String GTRIC_CEDE_RATE) {
        this.GTRIC_CEDE_RATE = GTRIC_CEDE_RATE;
    }

    public String getGTRIC_CEDE_RATE() {
        return GTRIC_CEDE_RATE;
    }

    public void setGTRIC_SI_AMT_PCUR(String GTRIC_SI_AMT_PCUR) {
        this.GTRIC_SI_AMT_PCUR = GTRIC_SI_AMT_PCUR;
    }

    public String getGTRIC_SI_AMT_PCUR() {
        return GTRIC_SI_AMT_PCUR;
    }

    public void setGTRIC_PREM_AMT_PCUR(String GTRIC_PREM_AMT_PCUR) {
        this.GTRIC_PREM_AMT_PCUR = GTRIC_PREM_AMT_PCUR;
    }

    public String getGTRIC_PREM_AMT_PCUR() {
        return GTRIC_PREM_AMT_PCUR;
    }

    public void setGTRIC_COMM_AMT_PCUR(String GTRIC_COMM_AMT_PCUR) {
        this.GTRIC_COMM_AMT_PCUR = GTRIC_COMM_AMT_PCUR;
    }

    public String getGTRIC_COMM_AMT_PCUR() {
        return GTRIC_COMM_AMT_PCUR;
    }

    public void setGTRIC_STAMP_DUTY(String GTRIC_STAMP_DUTY) {
        this.GTRIC_STAMP_DUTY = GTRIC_STAMP_DUTY;
    }

    public String getGTRIC_STAMP_DUTY() {
        return GTRIC_STAMP_DUTY;
    }

    public void setGTRIC_RPREM_TAX_PCUR(String GTRIC_RPREM_TAX_PCUR) {
        this.GTRIC_RPREM_TAX_PCUR = GTRIC_RPREM_TAX_PCUR;
    }

    public String getGTRIC_RPREM_TAX_PCUR() {
        return GTRIC_RPREM_TAX_PCUR;
    }

    public void setGTRIC_PREM_TAX_PCUR(String GTRIC_PREM_TAX_PCUR) {
        this.GTRIC_PREM_TAX_PCUR = GTRIC_PREM_TAX_PCUR;
    }

    public String getGTRIC_PREM_TAX_PCUR() {
        return GTRIC_PREM_TAX_PCUR;
    }

    public void setGTRIC_UWYR(String GTRIC_UWYR) {
        this.GTRIC_UWYR = GTRIC_UWYR;
    }

    public String getGTRIC_UWYR() {
        return GTRIC_UWYR;
    }

    public void setGTRIC_REFUND_PREM(String GTRIC_REFUND_PREM) {
        this.GTRIC_REFUND_PREM = GTRIC_REFUND_PREM;
    }

    public String getGTRIC_REFUND_PREM() {
        return GTRIC_REFUND_PREM;
    }

    public void setPMRITD_CODE(BigDecimal PMRITD_CODE) {
        this.PMRITD_CODE = PMRITD_CODE;
    }

    public BigDecimal getPMRITD_CODE() {
        return PMRITD_CODE;
    }

    public void setGfcCode(BigDecimal gfcCode) {
        this.gfcCode = gfcCode;
    }

    public BigDecimal getGfcCode() {
        return gfcCode;
    }

    public void setGfcAgnDesc(String gfcAgnDesc) {
        this.gfcAgnDesc = gfcAgnDesc;
    }

    public String getGfcAgnDesc() {
        return gfcAgnDesc;
    }

    public void setGfcAmtOrRate(String gfcAmtOrRate) {
        this.gfcAmtOrRate = gfcAmtOrRate;
    }

    public String getGfcAmtOrRate() {
        return gfcAmtOrRate;
    }

    public void setGfcAmt(BigDecimal gfcAmt) {
        this.gfcAmt = gfcAmt;
    }

    public BigDecimal getGfcAmt() {
        return gfcAmt;
    }

    public void setGfcRate(BigDecimal gfcRate) {
        this.gfcRate = gfcRate;
    }

    public BigDecimal getGfcRate() {
        return gfcRate;
    }

    public void setGfcExcessRate(BigDecimal gfcExcessRate) {
        this.gfcExcessRate = gfcExcessRate;
    }

    public BigDecimal getGfcExcessRate() {
        return gfcExcessRate;
    }

    public void setGfcPremRate(BigDecimal gfcPremRate) {
        this.gfcPremRate = gfcPremRate;
    }

    public BigDecimal getGfcPremRate() {
        return gfcPremRate;
    }

    public void setGfcPremDivFactor(BigDecimal gfcPremDivFactor) {
        this.gfcPremDivFactor = gfcPremDivFactor;
    }

    public BigDecimal getGfcPremDivFactor() {
        return gfcPremDivFactor;
    }

    public void setGfcPremAmt(BigDecimal gfcPremAmt) {
        this.gfcPremAmt = gfcPremAmt;
    }

    public BigDecimal getGfcPremAmt() {
        return gfcPremAmt;
    }

    public void setGfcCommRate(BigDecimal gfcCommRate) {
        this.gfcCommRate = gfcCommRate;
    }

    public BigDecimal getGfcCommRate() {
        return gfcCommRate;
    }

    public void setGfcCommAmt(BigDecimal gfcCommAmt) {
        this.gfcCommAmt = gfcCommAmt;
    }

    public BigDecimal getGfcCommAmt() {
        return gfcCommAmt;
    }

    public void setGfcWef(Date gfcWef) {
        this.gfcWef = gfcWef;
    }

    public Date getGfcWef() {
        return gfcWef;
    }

    public void setGfcAgnCode(BigDecimal gfcAgnCode) {
        this.gfcAgnCode = gfcAgnCode;
    }

    public BigDecimal getGfcAgnCode() {
        return gfcAgnCode;
    }

    public void setAgnShtDesc(String agnShtDesc) {
        this.agnShtDesc = agnShtDesc;
    }

    public String getAgnShtDesc() {
        return agnShtDesc;
    }

    public void setAgnName(String agnName) {
        this.agnName = agnName;
    }

    public String getAgnName() {
        return agnName;
    }

    public void setAgnCode(BigDecimal agnCode) {
        this.agnCode = agnCode;
    }

    public BigDecimal getAgnCode() {
        return agnCode;
    }

    public void setTot_sa(BigDecimal tot_sa) {
        this.tot_sa = tot_sa;
    }

    public BigDecimal getTot_sa() {
        return tot_sa;
    }

    public void setTot_ret(BigDecimal tot_ret) {
        this.tot_ret = tot_ret;
    }

    public BigDecimal getTot_ret() {
        return tot_ret;
    }

    public void setTot_excess(BigDecimal tot_excess) {
        this.tot_excess = tot_excess;
    }

    public BigDecimal getTot_excess() {
        return tot_excess;
    }

    public void setPMRITD_RATE(BigDecimal PMRITD_RATE) {
        this.PMRITD_RATE = PMRITD_RATE;
    }

    public BigDecimal getPMRITD_RATE() {
        return PMRITD_RATE;
    }

    public void setPMRITD_RATE_DIV_FACTOR(BigDecimal PMRITD_RATE_DIV_FACTOR) {
        this.PMRITD_RATE_DIV_FACTOR = PMRITD_RATE_DIV_FACTOR;
    }

    public BigDecimal getPMRITD_RATE_DIV_FACTOR() {
        return PMRITD_RATE_DIV_FACTOR;
    }

    public void setMemName(String memName) {
        this.memName = memName;
    }

    public String getMemName() {
        return memName;
    }

    public void setRmal_amt_reassured(BigDecimal rmal_amt_reassured) {
        this.rmal_amt_reassured = rmal_amt_reassured;
    }

    public BigDecimal getRmal_amt_reassured() {
        return rmal_amt_reassured;
    }

    public void setRmal_tct_aal(BigDecimal rmal_tct_aal) {
        this.rmal_tct_aal = rmal_tct_aal;
    }

    public BigDecimal getRmal_tct_aal() {
        return rmal_tct_aal;
    }

    public void setCvtCode(BigDecimal cvtCode) {
        this.cvtCode = cvtCode;
    }

    public BigDecimal getCvtCode() {
        return cvtCode;
    }

    public void setCvtDesc(String cvtDesc) {
        this.cvtDesc = cvtDesc;
    }

    public String getCvtDesc() {
        return cvtDesc;
    }
}
