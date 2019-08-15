package com.turnkey.setups;

import java.math.BigDecimal;

import java.util.Date;

public class ArrangementCoverTypes {
    public ArrangementCoverTypes() {
        super();
    }
    private BigDecimal atct_code, atct_tct_code, atct_tprd_code, atct_ta_code,atct_rei_code, atct_pct_code,
                    atct_cvt_code, atct_as_code, atct_prod_code,atct_comm_rate, atct_cede_rate,atct_rate_div_fact, atct_orrp_code, atct_rate;
   private String atct_cvt_sht_desc, atct_cede_type,  atct_rate_type, atct_limit, atct_class_specific,cvt_desc,orrp_desc;
   private String atct_ta_sht_desc,ratetype_desc,cede_type_desc;


   //cover types lov
   private BigDecimal TCT_CODE;
   private BigDecimal TCT_CVT_CODE;
   private String TCT_CVT_SHT_DESC;
   private String CVT_DESC;
   private BigDecimal TCT_PCT_CODE;
   
   //ORD_REIN_RATES_LOV
   private BigDecimal ORRP_CODE; 
   private String ORRP_SHT_DESC; 
   private String ORRP_DESC;
   private String ORRP_CLASS_SPECIFIC;
    public void setAtct_code(BigDecimal atct_code) {
        this.atct_code = atct_code;
    }
   //arrange comissioon rates
   private BigDecimal tacr_code, tacr_atct_code, tacr_pct_code,tacr_comm_div_factr,tacr_comm_rate;
   private String tacr_yr_from, tacr_yr_to;
   private Date tacr_wef, tacr_wet;
    public BigDecimal getAtct_code() {
        return atct_code;
    }

    public void setAtct_tct_code(BigDecimal atct_tct_code) {
        this.atct_tct_code = atct_tct_code;
    }

    public BigDecimal getAtct_tct_code() {
        return atct_tct_code;
    }

    public void setAtct_tprd_code(BigDecimal atct_tprd_code) {
        this.atct_tprd_code = atct_tprd_code;
    }

    public BigDecimal getAtct_tprd_code() {
        return atct_tprd_code;
    }

    public void setAtct_ta_code(BigDecimal atct_ta_code) {
        this.atct_ta_code = atct_ta_code;
    }

    public BigDecimal getAtct_ta_code() {
        return atct_ta_code;
    }

    public void setAtct_rei_code(BigDecimal atct_rei_code) {
        this.atct_rei_code = atct_rei_code;
    }

    public BigDecimal getAtct_rei_code() {
        return atct_rei_code;
    }

    public void setAtct_pct_code(BigDecimal atct_pct_code) {
        this.atct_pct_code = atct_pct_code;
    }

    public BigDecimal getAtct_pct_code() {
        return atct_pct_code;
    }

    public void setAtct_cvt_code(BigDecimal atct_cvt_code) {
        this.atct_cvt_code = atct_cvt_code;
    }

    public BigDecimal getAtct_cvt_code() {
        return atct_cvt_code;
    }

    public void setAtct_as_code(BigDecimal atct_as_code) {
        this.atct_as_code = atct_as_code;
    }

    public BigDecimal getAtct_as_code() {
        return atct_as_code;
    }

    public void setAtct_prod_code(BigDecimal atct_prod_code) {
        this.atct_prod_code = atct_prod_code;
    }

    public BigDecimal getAtct_prod_code() {
        return atct_prod_code;
    }

    public void setAtct_comm_rate(BigDecimal atct_comm_rate) {
        this.atct_comm_rate = atct_comm_rate;
    }

    public BigDecimal getAtct_comm_rate() {
        return atct_comm_rate;
    }

    public void setAtct_cede_rate(BigDecimal atct_cede_rate) {
        this.atct_cede_rate = atct_cede_rate;
    }

    public BigDecimal getAtct_cede_rate() {
        return atct_cede_rate;
    }

    public void setAtct_rate_div_fact(BigDecimal atct_rate_div_fact) {
        this.atct_rate_div_fact = atct_rate_div_fact;
    }

    public BigDecimal getAtct_rate_div_fact() {
        return atct_rate_div_fact;
    }

    public void setAtct_orrp_code(BigDecimal atct_orrp_code) {
        this.atct_orrp_code = atct_orrp_code;
    }

    public BigDecimal getAtct_orrp_code() {
        return atct_orrp_code;
    }

    public void setAtct_rate(BigDecimal atct_rate) {
        this.atct_rate = atct_rate;
    }

    public BigDecimal getAtct_rate() {
        return atct_rate;
    }

    public void setAtct_cvt_sht_desc(String atct_cvt_sht_desc) {
        this.atct_cvt_sht_desc = atct_cvt_sht_desc;
    }

    public String getAtct_cvt_sht_desc() {
        return atct_cvt_sht_desc;
    }

    public void setAtct_cede_type(String atct_cede_type) {
        this.atct_cede_type = atct_cede_type;
    }

    public String getAtct_cede_type() {
        return atct_cede_type;
    }

    public void setAtct_rate_type(String atct_rate_type) {
        this.atct_rate_type = atct_rate_type;
    }

    public String getAtct_rate_type() {
        return atct_rate_type;
    }

    public void setAtct_limit(String atct_limit) {
        this.atct_limit = atct_limit;
    }

    public String getAtct_limit() {
        return atct_limit;
    }

    public void setAtct_class_specific(String atct_class_specific) {
        this.atct_class_specific = atct_class_specific;
    }

    public String getAtct_class_specific() {
        return atct_class_specific;
    }

    public void setCvt_desc(String cvt_desc) {
        this.cvt_desc = cvt_desc;
    }

    public String getCvt_desc() {
        return cvt_desc;
    }

    public void setAtct_ta_sht_desc(String atct_ta_sht_desc) {
        this.atct_ta_sht_desc = atct_ta_sht_desc;
    }

    public String getAtct_ta_sht_desc() {
        return atct_ta_sht_desc;
    }

    public void setOrrp_desc(String orrp_desc) {
        this.orrp_desc = orrp_desc;
    }

    public String getOrrp_desc() {
        return orrp_desc;
    }

    public void setRatetype_desc(String ratetype_desc) {
        this.ratetype_desc = ratetype_desc;
    }

    public String getRatetype_desc() {
        return ratetype_desc;
    }

    public void setCede_type_desc(String cede_type_desc) {
        this.cede_type_desc = cede_type_desc;
    }

    public String getCede_type_desc() {
        return cede_type_desc;
    }

    public void setTCT_CODE(BigDecimal TCT_CODE) {
        this.TCT_CODE = TCT_CODE;
    }

    public BigDecimal getTCT_CODE() {
        return TCT_CODE;
    }

    public void setTCT_CVT_CODE(BigDecimal TCT_CVT_CODE) {
        this.TCT_CVT_CODE = TCT_CVT_CODE;
    }

    public BigDecimal getTCT_CVT_CODE() {
        return TCT_CVT_CODE;
    }

    public void setTCT_CVT_SHT_DESC(String TCT_CVT_SHT_DESC) {
        this.TCT_CVT_SHT_DESC = TCT_CVT_SHT_DESC;
    }

    public String getTCT_CVT_SHT_DESC() {
        return TCT_CVT_SHT_DESC;
    }

    public void setCVT_DESC(String CVT_DESC) {
        this.CVT_DESC = CVT_DESC;
    }

    public String getCVT_DESC() {
        return CVT_DESC;
    }

    public void setTCT_PCT_CODE(BigDecimal TCT_PCT_CODE) {
        this.TCT_PCT_CODE = TCT_PCT_CODE;
    }

    public BigDecimal getTCT_PCT_CODE() {
        return TCT_PCT_CODE;
    }

    public void setORRP_CODE(BigDecimal ORRP_CODE) {
        this.ORRP_CODE = ORRP_CODE;
    }

    public BigDecimal getORRP_CODE() {
        return ORRP_CODE;
    }

    public void setORRP_SHT_DESC(String ORRP_SHT_DESC) {
        this.ORRP_SHT_DESC = ORRP_SHT_DESC;
    }

    public String getORRP_SHT_DESC() {
        return ORRP_SHT_DESC;
    }

    public void setORRP_DESC(String ORRP_DESC) {
        this.ORRP_DESC = ORRP_DESC;
    }

    public String getORRP_DESC() {
        return ORRP_DESC;
    }

    public void setORRP_CLASS_SPECIFIC(String ORRP_CLASS_SPECIFIC) {
        this.ORRP_CLASS_SPECIFIC = ORRP_CLASS_SPECIFIC;
    }

    public String getORRP_CLASS_SPECIFIC() {
        return ORRP_CLASS_SPECIFIC;
    }

    public void setTacr_code(BigDecimal tacr_code) {
        this.tacr_code = tacr_code;
    }

    public BigDecimal getTacr_code() {
        return tacr_code;
    }

    public void setTacr_atct_code(BigDecimal tacr_atct_code) {
        this.tacr_atct_code = tacr_atct_code;
    }

    public BigDecimal getTacr_atct_code() {
        return tacr_atct_code;
    }

    public void setTacr_pct_code(BigDecimal tacr_pct_code) {
        this.tacr_pct_code = tacr_pct_code;
    }

    public BigDecimal getTacr_pct_code() {
        return tacr_pct_code;
    }

    public void setTacr_comm_div_factr(BigDecimal tacr_comm_div_factr) {
        this.tacr_comm_div_factr = tacr_comm_div_factr;
    }

    public BigDecimal getTacr_comm_div_factr() {
        return tacr_comm_div_factr;
    }

    public void setTacr_comm_rate(BigDecimal tacr_comm_rate) {
        this.tacr_comm_rate = tacr_comm_rate;
    }

    public BigDecimal getTacr_comm_rate() {
        return tacr_comm_rate;
    }

    public void setTacr_yr_from(String tacr_yr_from) {
        this.tacr_yr_from = tacr_yr_from;
    }

    public String getTacr_yr_from() {
        return tacr_yr_from;
    }

    public void setTacr_yr_to(String tacr_yr_to) {
        this.tacr_yr_to = tacr_yr_to;
    }

    public String getTacr_yr_to() {
        return tacr_yr_to;
    }

    public void setTacr_wef(Date tacr_wef) {
        this.tacr_wef = tacr_wef;
    }

    public Date getTacr_wef() {
        return tacr_wef;
    }

    public void setTacr_wet(Date tacr_wet) {
        this.tacr_wet = tacr_wet;
    }

    public Date getTacr_wet() {
        return tacr_wet;
    }
}
