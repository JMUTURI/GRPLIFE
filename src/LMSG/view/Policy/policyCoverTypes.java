package LMSG.view.Policy;

import java.math.BigDecimal;

public class policyCoverTypes {
  public policyCoverTypes() {
  }
  private String PCVT_CVT_SHT_DESC,CVT_DEPEND_DISP, PCVT_LOAD_DISC,PCVT_USE_UNIT_RATE,PCVT_MAIN_RIDER,PCVT_AVG_ANB ;  
  private BigDecimal PCVT_SA,PCVT_PREMIUM,PCVT_BUT_CHARGE_PREMIUM,PCVT_TOT_MEMBERS,
  PCVT_DISC_LOAD_RATE,PCVT_DISC_LOAD_DIV_FACT,PCVT_AVERAGE_PERIOD,PCVT_SA_PER_MEMBER,
  PCVT_UNIT_RATE,PCVT_CODE,PCVT_CVT_CODE, PCVT_MAIN_SA_PERC, PCVT_PCT_CODE;
  
  private String PCVT_DISC;
  private BigDecimal PCVT_DISC_RATE;
  private BigDecimal PCVT_DISC_DIV_FACT;

  private String CVR_RATE_DESC;
  
  private BigDecimal pcvt_pmas_code;
  private String pcvt_pmas_sht_desc;
  private BigDecimal pcvt_rate;
  private BigDecimal pcvt_rate_div_fact;
  private String pcvt_use_cvr_rate;
  
  private BigDecimal PCVT_LOANAMT_PER_MEM;
  private BigDecimal PCVT_LOAN_RPYMT_PRD;
  private BigDecimal PCVT_LOANINT_PER_MEM;
  private BigDecimal PCVT_SAVINGS_PER_MEM;
  private BigDecimal pcvt_load_age_fact;
  private String pcvtPctInbuilt,pcvtAccelerator;
  
  private String PCVT_MAIN_COVER, MAIN_COVER_DESC;

  public void setPCVT_CVT_SHT_DESC(String PCVT_CVT_SHT_DESC) {
    this.PCVT_CVT_SHT_DESC = PCVT_CVT_SHT_DESC;
  }

  public String getPCVT_CVT_SHT_DESC() {
    return PCVT_CVT_SHT_DESC;
  }

  public void setCVT_DEPEND_DISP(String CVT_DEPEND_DISP) {
    this.CVT_DEPEND_DISP = CVT_DEPEND_DISP;
  }

  public String getCVT_DEPEND_DISP() {
    return CVT_DEPEND_DISP;
  }

  public void setPCVT_LOAD_DISC(String PCVT_LOAD_DISC) {
    this.PCVT_LOAD_DISC = PCVT_LOAD_DISC;
  }

  public String getPCVT_LOAD_DISC() {
    return PCVT_LOAD_DISC;
  }

  public void setPCVT_USE_UNIT_RATE(String PCVT_USE_UNIT_RATE) {
    this.PCVT_USE_UNIT_RATE = PCVT_USE_UNIT_RATE;
  }

  public String getPCVT_USE_UNIT_RATE() {
    return PCVT_USE_UNIT_RATE;
  }

  public void setPCVT_SA(BigDecimal PCVT_SA) {
    this.PCVT_SA = PCVT_SA;
  }

  public BigDecimal getPCVT_SA() {
    return PCVT_SA;
  }

  public void setPCVT_PREMIUM(BigDecimal PCVT_PREMIUM) {
    this.PCVT_PREMIUM = PCVT_PREMIUM;
  }

  public BigDecimal getPCVT_PREMIUM() {
    return PCVT_PREMIUM;
  }

  public void setPCVT_BUT_CHARGE_PREMIUM(BigDecimal PCVT_BUT_CHARGE_PREMIUM) {
    this.PCVT_BUT_CHARGE_PREMIUM = PCVT_BUT_CHARGE_PREMIUM;
  }

  public BigDecimal getPCVT_BUT_CHARGE_PREMIUM() {
    return PCVT_BUT_CHARGE_PREMIUM;
  }

  public void setPCVT_TOT_MEMBERS(BigDecimal PCVT_TOT_MEMBERS) {
    this.PCVT_TOT_MEMBERS = PCVT_TOT_MEMBERS;
  }

  public BigDecimal getPCVT_TOT_MEMBERS() {
    return PCVT_TOT_MEMBERS;
  }

  public void setPCVT_DISC_LOAD_RATE(BigDecimal PCVT_DISC_LOAD_RATE) {
    this.PCVT_DISC_LOAD_RATE = PCVT_DISC_LOAD_RATE;
  }

  public BigDecimal getPCVT_DISC_LOAD_RATE() {
    return PCVT_DISC_LOAD_RATE;
  }

  public void setPCVT_DISC_LOAD_DIV_FACT(BigDecimal PCVT_DISC_LOAD_DIV_FACT) {
    this.PCVT_DISC_LOAD_DIV_FACT = PCVT_DISC_LOAD_DIV_FACT;
  }

  public BigDecimal getPCVT_DISC_LOAD_DIV_FACT() {
    return PCVT_DISC_LOAD_DIV_FACT;
  }

  public void setPCVT_AVERAGE_PERIOD(BigDecimal PCVT_AVERAGE_PERIOD) {
    this.PCVT_AVERAGE_PERIOD = PCVT_AVERAGE_PERIOD;
  }

  public BigDecimal getPCVT_AVERAGE_PERIOD() {
    return PCVT_AVERAGE_PERIOD;
  }

  public void setPCVT_SA_PER_MEMBER(BigDecimal PCVT_SA_PER_MEMBER) {
    this.PCVT_SA_PER_MEMBER = PCVT_SA_PER_MEMBER;
  }

  public BigDecimal getPCVT_SA_PER_MEMBER() {
    return PCVT_SA_PER_MEMBER;
  }

  public void setPCVT_UNIT_RATE(BigDecimal PCVT_UNIT_RATE) {
    this.PCVT_UNIT_RATE = PCVT_UNIT_RATE;
  }

  public BigDecimal getPCVT_UNIT_RATE() {
    return PCVT_UNIT_RATE;
  }

  public void setPCVT_CODE(BigDecimal PCVT_CODE) {
    this.PCVT_CODE = PCVT_CODE;
  }

  public BigDecimal getPCVT_CODE() {
    return PCVT_CODE;
  }

  public void setPCVT_MAIN_RIDER(String PCVT_MAIN_RIDER) {
    this.PCVT_MAIN_RIDER = PCVT_MAIN_RIDER;
  }

  public String getPCVT_MAIN_RIDER() {
    return PCVT_MAIN_RIDER;
  }

  public void setPCVT_CVT_CODE(BigDecimal PCVT_CVT_CODE) {
    this.PCVT_CVT_CODE = PCVT_CVT_CODE;
  }

  public BigDecimal getPCVT_CVT_CODE() {
    return PCVT_CVT_CODE;
  }

    public void setPCVT_AVG_ANB(String PCVT_AVG_ANB) {
        this.PCVT_AVG_ANB = PCVT_AVG_ANB;
    }

    public String getPCVT_AVG_ANB() {
        return PCVT_AVG_ANB;
    }

    public void setPCVT_MAIN_SA_PERC(BigDecimal PCVT_MAIN_SA_PERC) {
        this.PCVT_MAIN_SA_PERC = PCVT_MAIN_SA_PERC;
    }

    public BigDecimal getPCVT_MAIN_SA_PERC() {
        return PCVT_MAIN_SA_PERC;
    }

    public void setPCVT_MAIN_COVER(String PCVT_MAIN_COVER) {
        this.PCVT_MAIN_COVER = PCVT_MAIN_COVER;
    }

    public String getPCVT_MAIN_COVER() {
        return PCVT_MAIN_COVER;
    }

    public void setMAIN_COVER_DESC(String MAIN_COVER_DESC) {
        this.MAIN_COVER_DESC = MAIN_COVER_DESC;
    }

    public String getMAIN_COVER_DESC() {
        return MAIN_COVER_DESC;
    }

    public void setPCVT_PCT_CODE(BigDecimal PCVT_PCT_CODE) {
        this.PCVT_PCT_CODE = PCVT_PCT_CODE;
    }

    public BigDecimal getPCVT_PCT_CODE() {
        return PCVT_PCT_CODE;
    }

    public void setPCVT_LOANAMT_PER_MEM(BigDecimal PCVT_LOANAMT_PER_MEM) {
        this.PCVT_LOANAMT_PER_MEM = PCVT_LOANAMT_PER_MEM;
    }

    public BigDecimal getPCVT_LOANAMT_PER_MEM() {
        return PCVT_LOANAMT_PER_MEM;
    }

    public void setPCVT_LOAN_RPYMT_PRD(BigDecimal PCVT_LOAN_RPYMT_PRD) {
        this.PCVT_LOAN_RPYMT_PRD = PCVT_LOAN_RPYMT_PRD;
    }

    public BigDecimal getPCVT_LOAN_RPYMT_PRD() {
        return PCVT_LOAN_RPYMT_PRD;
    }

    public void setPCVT_LOANINT_PER_MEM(BigDecimal PCVT_LOANINT_PER_MEM) {
        this.PCVT_LOANINT_PER_MEM = PCVT_LOANINT_PER_MEM;
    }

    public BigDecimal getPCVT_LOANINT_PER_MEM() {
        return PCVT_LOANINT_PER_MEM;
    }

    public void setPCVT_SAVINGS_PER_MEM(BigDecimal PCVT_SAVINGS_PER_MEM) {
        this.PCVT_SAVINGS_PER_MEM = PCVT_SAVINGS_PER_MEM;
    }

    public BigDecimal getPCVT_SAVINGS_PER_MEM() {
        return PCVT_SAVINGS_PER_MEM;
    }

    public void setPCVT_DISC(String PCVT_DISC) {
        this.PCVT_DISC = PCVT_DISC;
    }

    public String getPCVT_DISC() {
        return PCVT_DISC;
    }

    public void setPCVT_DISC_RATE(BigDecimal PCVT_DISC_RATE) {
        this.PCVT_DISC_RATE = PCVT_DISC_RATE;
    }

    public BigDecimal getPCVT_DISC_RATE() {
        return PCVT_DISC_RATE;
    }

    public void setPCVT_DISC_DIV_FACT(BigDecimal PCVT_DISC_DIV_FACT) {
        this.PCVT_DISC_DIV_FACT = PCVT_DISC_DIV_FACT;
    }

    public BigDecimal getPCVT_DISC_DIV_FACT() {
        return PCVT_DISC_DIV_FACT;
    }

    public void setPcvt_pmas_code(BigDecimal pcvt_pmas_code) {
        this.pcvt_pmas_code = pcvt_pmas_code;
    }

    public BigDecimal getPcvt_pmas_code() {
        return pcvt_pmas_code;
    }

    public void setPcvt_pmas_sht_desc(String pcvt_pmas_sht_desc) {
        this.pcvt_pmas_sht_desc = pcvt_pmas_sht_desc;
    }

    public String getPcvt_pmas_sht_desc() {
        return pcvt_pmas_sht_desc;
    }

    public void setPcvt_rate(BigDecimal pcvt_rate) {
        this.pcvt_rate = pcvt_rate;
    }

    public BigDecimal getPcvt_rate() {
        return pcvt_rate;
    }

    public void setPcvt_rate_div_fact(BigDecimal pcvt_rate_div_fact) {
        this.pcvt_rate_div_fact = pcvt_rate_div_fact;
    }

    public BigDecimal getPcvt_rate_div_fact() {
        return pcvt_rate_div_fact;
    }

    public void setPcvt_use_cvr_rate(String pcvt_use_cvr_rate) {
        this.pcvt_use_cvr_rate = pcvt_use_cvr_rate;
    }

    public String getPcvt_use_cvr_rate() {
        return pcvt_use_cvr_rate;
    }

    public void setCVR_RATE_DESC(String CVR_RATE_DESC) {
        this.CVR_RATE_DESC = CVR_RATE_DESC;
    }

    public String getCVR_RATE_DESC() {
        return CVR_RATE_DESC;
    }

    public void setPcvt_load_age_fact(BigDecimal pcvt_load_age_fact) {
        this.pcvt_load_age_fact = pcvt_load_age_fact;
    }

    public BigDecimal getPcvt_load_age_fact() {
        return pcvt_load_age_fact;
    }

    public void setPcvtPctInbuilt(String pcvtPctInbuilt) {
        this.pcvtPctInbuilt = pcvtPctInbuilt;
    }

    public String getPcvtPctInbuilt() {
        return pcvtPctInbuilt;
    }

    public void setPcvtAccelerator(String pcvtAccelerator) {
        this.pcvtAccelerator = pcvtAccelerator;
    }

    public String getPcvtAccelerator() {
        return pcvtAccelerator;
    }
}
