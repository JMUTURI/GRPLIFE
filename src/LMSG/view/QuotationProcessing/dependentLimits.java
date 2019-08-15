package LMSG.view.QuotationProcessing;

import java.math.BigDecimal;

public class dependentLimits {
  public dependentLimits() {
  }
  private BigDecimal QDL_CODE,QDL_QUO_CODE,QDL_MAX_TYPE_ALLOWED,QDL_LIMIT_AMT,QDL_MIN_AMT,QDL_DTY_CODE,QDL_PCVT_CODE;
  private String DTY_DESCRIPTION, PCA_CATEG_DESC, cvt_desc;
  private BigDecimal CVT_CODE;
  public void setQDL_CODE(BigDecimal QDL_CODE) {
    this.QDL_CODE = QDL_CODE;
  }

  public BigDecimal getQDL_CODE() {
    return QDL_CODE;
  }

  public void setQDL_QUO_CODE(BigDecimal QDL_QUO_CODE) {
    this.QDL_QUO_CODE = QDL_QUO_CODE;
  }

  public BigDecimal getQDL_QUO_CODE() {
    return QDL_QUO_CODE;
  }

  public void setQDL_MAX_TYPE_ALLOWED(BigDecimal QDL_MAX_TYPE_ALLOWED) {
    this.QDL_MAX_TYPE_ALLOWED = QDL_MAX_TYPE_ALLOWED;
  }

  public BigDecimal getQDL_MAX_TYPE_ALLOWED() {
    return QDL_MAX_TYPE_ALLOWED;
  }

  public void setQDL_LIMIT_AMT(BigDecimal QDL_LIMIT_AMT) {
    this.QDL_LIMIT_AMT = QDL_LIMIT_AMT;
  }

  public BigDecimal getQDL_LIMIT_AMT() {
    return QDL_LIMIT_AMT;
  }

  public void setDTY_DESCRIPTION(String DTY_DESCRIPTION) {
    this.DTY_DESCRIPTION = DTY_DESCRIPTION;
  }

  public String getDTY_DESCRIPTION() {
    return DTY_DESCRIPTION;
  }

    public void setPCA_CATEG_DESC(String PCA_CATEG_DESC) {
        this.PCA_CATEG_DESC = PCA_CATEG_DESC;
    }

    public String getPCA_CATEG_DESC() {
        return PCA_CATEG_DESC;
    }

    public void setCvt_desc(String cvt_desc) {
        this.cvt_desc = cvt_desc;
    }

    public String getCvt_desc() {
        return cvt_desc;
    }

    public void setQDL_MIN_AMT(BigDecimal QDL_MIN_AMT) {
        this.QDL_MIN_AMT = QDL_MIN_AMT;
    }

    public BigDecimal getQDL_MIN_AMT() {
        return QDL_MIN_AMT;
    }

    public void setQDL_DTY_CODE(BigDecimal QDL_DTY_CODE) {
        this.QDL_DTY_CODE = QDL_DTY_CODE;
    }

    public BigDecimal getQDL_DTY_CODE() {
        return QDL_DTY_CODE;
    }

    public void setQDL_PCVT_CODE(BigDecimal QDL_PCVT_CODE) {
        this.QDL_PCVT_CODE = QDL_PCVT_CODE;
    }

    public BigDecimal getQDL_PCVT_CODE() {
        return QDL_PCVT_CODE;
    }

    public void setCVT_CODE(BigDecimal CVT_CODE) {
        this.CVT_CODE = CVT_CODE;
    }

    public BigDecimal getCVT_CODE() {
        return CVT_CODE;
    }
}
