package LMSG.view.Policy;

import java.math.BigDecimal;

public class ProdCovers {
  public ProdCovers() {
  }
  private BigDecimal cvt_code,pct_code, pct_main_sa_perc;
  private String cvt_sht_desc, cvt_desc, cvt_main_cover,
                  pct_formular, pct_refund_formular,
                  cvt_duration_type;
  private String pctInbuilt,pctAccelerator;

  public void setCvt_code(BigDecimal cvt_code) {
    this.cvt_code = cvt_code;
  }

  public BigDecimal getCvt_code() {
    return cvt_code;
  }

  public void setPct_code(BigDecimal pct_code) {
    this.pct_code = pct_code;
  }

  public BigDecimal getPct_code() {
    return pct_code;
  }

  public void setCvt_sht_desc(String cvt_sht_desc) {
    this.cvt_sht_desc = cvt_sht_desc;
  }

  public String getCvt_sht_desc() {
    return cvt_sht_desc;
  }

  public void setCvt_desc(String cvt_desc) {
    this.cvt_desc = cvt_desc;
  }

  public String getCvt_desc() {
    return cvt_desc;
  }

  public void setCvt_main_cover(String cvt_main_cover) {
    this.cvt_main_cover = cvt_main_cover;
  }

  public String getCvt_main_cover() {
    return cvt_main_cover;
  }

  public void setPct_formular(String pct_formular) {
    this.pct_formular = pct_formular;
  }

  public String getPct_formular() {
    return pct_formular;
  }

  public void setPct_refund_formular(String pct_refund_formular) {
    this.pct_refund_formular = pct_refund_formular;
  }

  public String getPct_refund_formular() {
    return pct_refund_formular;
  }

  public void setCvt_duration_type(String cvt_duration_type) {
    this.cvt_duration_type = cvt_duration_type;
  }

  public String getCvt_duration_type() {
    return cvt_duration_type;
  }

    public void setPct_main_sa_perc(BigDecimal pct_main_sa_perc) {
        this.pct_main_sa_perc = pct_main_sa_perc;
    }

    public BigDecimal getPct_main_sa_perc() {
        return pct_main_sa_perc;
    }

    public void setPctInbuilt(String pctInbuilt) {
        this.pctInbuilt = pctInbuilt;
    }

    public String getPctInbuilt() {
        return pctInbuilt;
    }

    public void setPctAccelerator(String pctAccelerator) {
        this.pctAccelerator = pctAccelerator;
    }

    public String getPctAccelerator() {
        return pctAccelerator;
    }
}
