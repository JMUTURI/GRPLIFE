package com.turnkey.setups;

import java.math.BigDecimal;

public class TreatyParticipants {
    public TreatyParticipants() {
        super();
    }
    private BigDecimal trpa_agen_code,trpa_rei_code, trpa_uw_year,trpa_comp_rate,trpa_trs_code; 
    private String trpa_agen_sht_desc, agn_name, trpa_gl_ctrl_account, trpa_trs_sht_desc,trpa_rei_prem_taxable;
    private BigDecimal AGEN_CODE;
    private String AGEN_SHT_DESC,AGEN_NAME;

    public void setTrpa_agen_code(BigDecimal trpa_agen_code) {
        this.trpa_agen_code = trpa_agen_code;
    }

    public BigDecimal getTrpa_agen_code() {
        return trpa_agen_code;
    }

    public void setTrpa_rei_code(BigDecimal trpa_rei_code) {
        this.trpa_rei_code = trpa_rei_code;
    }

    public BigDecimal getTrpa_rei_code() {
        return trpa_rei_code;
    }

    public void setTrpa_uw_year(BigDecimal trpa_uw_year) {
        this.trpa_uw_year = trpa_uw_year;
    }

    public BigDecimal getTrpa_uw_year() {
        return trpa_uw_year;
    }

    public void setTrpa_comp_rate(BigDecimal trpa_comp_rate) {
        this.trpa_comp_rate = trpa_comp_rate;
    }

    public BigDecimal getTrpa_comp_rate() {
        return trpa_comp_rate;
    }

    public void setTrpa_trs_code(BigDecimal trpa_trs_code) {
        this.trpa_trs_code = trpa_trs_code;
    }

    public BigDecimal getTrpa_trs_code() {
        return trpa_trs_code;
    }

    public void setTrpa_agen_sht_desc(String trpa_agen_sht_desc) {
        this.trpa_agen_sht_desc = trpa_agen_sht_desc;
    }

    public String getTrpa_agen_sht_desc() {
        return trpa_agen_sht_desc;
    }

    public void setAgn_name(String agn_name) {
        this.agn_name = agn_name;
    }

    public String getAgn_name() {
        return agn_name;
    }

    public void setTrpa_gl_ctrl_account(String trpa_gl_ctrl_account) {
        this.trpa_gl_ctrl_account = trpa_gl_ctrl_account;
    }

    public String getTrpa_gl_ctrl_account() {
        return trpa_gl_ctrl_account;
    }

    public void setTrpa_trs_sht_desc(String trpa_trs_sht_desc) {
        this.trpa_trs_sht_desc = trpa_trs_sht_desc;
    }

    public String getTrpa_trs_sht_desc() {
        return trpa_trs_sht_desc;
    }

    public void setTrpa_rei_prem_taxable(String trpa_rei_prem_taxable) {
        this.trpa_rei_prem_taxable = trpa_rei_prem_taxable;
    }

    public String getTrpa_rei_prem_taxable() {
        return trpa_rei_prem_taxable;
    }

    public void setAGEN_CODE(BigDecimal AGEN_CODE) {
        this.AGEN_CODE = AGEN_CODE;
    }

    public BigDecimal getAGEN_CODE() {
        return AGEN_CODE;
    }

    public void setAGEN_SHT_DESC(String AGEN_SHT_DESC) {
        this.AGEN_SHT_DESC = AGEN_SHT_DESC;
    }

    public String getAGEN_SHT_DESC() {
        return AGEN_SHT_DESC;
    }

    public void setAGEN_NAME(String AGEN_NAME) {
        this.AGEN_NAME = AGEN_NAME;
    }

    public String getAGEN_NAME() {
        return AGEN_NAME;
    }
}
