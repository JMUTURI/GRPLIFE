package LMSG.view.Accounts;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;


public class UprBean {
    private BigDecimal utrans_code, utrans_year, utrans_month;
    private List<UprBeans> uprs;
    private BigDecimal usum_code, usum_utrans_code, usum_scl_code, usum_brn_code, usum_cur_code, usum_gross_prem, usum_gross_comm, usum_mand_prem, usum_mand_comm, usum_quota_prem, usum_quota_comm, usum_fstsup_prem, usum_fstsup_comm, usum_secsup_prem, usum_secsup_comm, usum_facre_prem, usum_facre_comm, usum_facob_prem, usum_facob_comm, usum_pool_prem, usum_pool_comm, usum_prev_usum_code, ibnr_grs_ibnr_y1, ibnr_grs_ibnr_y2, ibnr_grs_ibnr_y3, ibnr_grs_ibnr_tot, ibnr_man_ibnr_y1, ibnr_man_ibnr_y2, ibnr_man_ibnr_y3, ibnr_man_ibnr_tot, ibnr_quota_ibnr_y1, ibnr_quota_ibnr_y2, ibnr_quota_ibnr_y3, ibnr_quota_ibnr_tot, ibnr_fstsup_ibnr_y1, ibnr_fstsup_ibnr_y2, ibnr_fstsup_ibnr_y3, ibnr_fstsup_ibnr_tot, ibnr_secsup_ibnr_y1, ibnr_secsup_ibnr_y2, ibnr_secsup_ibnr_y3, ibnr_secsup_ibnr_tot, ibnr_facre_ibnr_y1, ibnr_facre_ibnr_y2, ibnr_facre_ibnr_y3, ibnr_facre_ibnr_tot, ibnr_own_ibnr_y1, ibnr_own_ibnr_y2, ibnr_own_ibnr_y3, ibnr_own_ibnr_tot, ibnr_pool_ibnr_y1, ibnr_pool_ibnr_y2, ibnr_pool_ibnr_y3, ibnr_pool_ibnr_tot, ibnr_facre_obibnr_y1, ibnr_facre_obibnr_y2, ibnr_facre_obibnr_y3, ibnr_facre_obibnr_tot;
    private String type, agnName;

    private String scl_desc, brn_name, cur_desc, up_pol_policy_no, up_property_id;

    private Date up_policy_cover_from, up_policy_cover_to;

    private BigDecimal up_code, up_utrans_code, up_scl_code, up_brn_code, up_agn_code, up_cur_code, up_pol_batch_no, up_ipu_code, up_days_moths, up_earned_mnths_days, up_unearned_mnths_days, up_unearned_prem, up_gross_prem, up_gross_comm, up_mand_prem, up_mand_comm, up_quota_prem, up_quota_comm, up_fstsup_prem, up_fstsup_comm, up_secsup_prem, up_secsup_comm, up_facre_prem, up_facre_comm, up_facob_prem, up_facob_comm, up_pool_prem, up_pool_comm;

    private BigDecimal usum_unearned_prem, usum_unearned_com, up_unearned_com;
    private BigDecimal ibnr_code, ibnr_uirans_code, ibnr_scl_code, ibnr_brn_code, ibnr_cur_code, ibnr_prev_ibnr_code;

    private String prod_desc;
    private BigDecimal ibnrCode;
    private BigDecimal ibnrBatchNumber;
    private String ibnrType;
    private BigDecimal ibnrProvPct;
    private BigDecimal ibnrClaCode;
    private BigDecimal ibnrSclCode;
    private Date ibnrFromDate;
    private Date ibnrToDate;
    private BigDecimal ibnrBfGrossOs;
    private BigDecimal ibnrBfManOs;
    private BigDecimal ibnrBfQuotaOs;
    private BigDecimal ibnrBfFstSupOs;
    private BigDecimal ibnrBfSecSupOs;
    private BigDecimal ibnrBfFacreOs;
    private BigDecimal ibnrBfOwnOs;
    private String ibnrDoneBy;
    private Date ibnrDateDone;
    private String ibnrAuthBy;
    private Date ibnrAuthDate;
    private String ibnrAuthorised;
    private BigDecimal brnCode;
    private BigDecimal ibnrUtransCode;
    private BigDecimal ibnrCurrencyRate;
    private BigDecimal ibnrCurrencyCode;
    private BigDecimal ibnrPrevIbnrCode;

    private String ibnrBrnName;
    private String ibnrCurrSymbol;
    private String ibnrCurrDesc;
    private String sclDesc;


    private BigDecimal ibnrGrossPremium;
    private BigDecimal ibnrManPrem;
    private BigDecimal ibnrFstsupPrem;
    private BigDecimal ibnrQuotaPrem;
    private BigDecimal ibnrSecSupPrem;
    private BigDecimal ibnrFacrePrem;
    private BigDecimal ibnrOwnPrem;
    private BigDecimal ibnrbrnCode;
    private BigDecimal ibnrUiransCode;
    private BigDecimal ibnrCurrRate;
    private BigDecimal ibnrCurrCode;
    private BigDecimal ibnrPreviousIbnrCode;
    private String brnName;
    private String currSymbol;
    private String currDescription;
    private String currencyDesc;
    private BigDecimal up_unearned_comm;
    private BigDecimal up_ri_prem, 
    up_unearned_ri_prem, up_ricomm, up_unearned_ri_comm;

    public void setUtrans_code(BigDecimal utrans_code) {
        this.utrans_code = utrans_code;
    }

    public BigDecimal getUtrans_code() {
        return utrans_code;
    }

    public void setUtrans_year(BigDecimal utrans_year) {
        this.utrans_year = utrans_year;
    }

    public BigDecimal getUtrans_year() {
        return utrans_year;
    }

    public void setUtrans_month(BigDecimal utrans_month) {
        this.utrans_month = utrans_month;
    }

    public BigDecimal getUtrans_month() {
        return utrans_month;
    }

    public void setUprs(List<UprBeans> uprs) {
        this.uprs = uprs;
    }

    public List<UprBeans> getUprs() {
        return uprs;
    }

    public void setUsum_code(BigDecimal usum_code) {
        this.usum_code = usum_code;
    }

    public BigDecimal getUsum_code() {
        return usum_code;
    }

    public void setUsum_utrans_code(BigDecimal usum_utrans_code) {
        this.usum_utrans_code = usum_utrans_code;
    }

    public BigDecimal getUsum_utrans_code() {
        return usum_utrans_code;
    }

    public void setUsum_scl_code(BigDecimal usum_scl_code) {
        this.usum_scl_code = usum_scl_code;
    }

    public BigDecimal getUsum_scl_code() {
        return usum_scl_code;
    }

    public void setUsum_brn_code(BigDecimal usum_brn_code) {
        this.usum_brn_code = usum_brn_code;
    }

    public BigDecimal getUsum_brn_code() {
        return usum_brn_code;
    }

    public void setUsum_cur_code(BigDecimal usum_cur_code) {
        this.usum_cur_code = usum_cur_code;
    }

    public BigDecimal getUsum_cur_code() {
        return usum_cur_code;
    }

    public void setUsum_gross_prem(BigDecimal usum_gross_prem) {
        this.usum_gross_prem = usum_gross_prem;
    }

    public BigDecimal getUsum_gross_prem() {
        return usum_gross_prem;
    }

    public void setUsum_gross_comm(BigDecimal usum_gross_comm) {
        this.usum_gross_comm = usum_gross_comm;
    }

    public BigDecimal getUsum_gross_comm() {
        return usum_gross_comm;
    }

    public void setUsum_mand_prem(BigDecimal usum_mand_prem) {
        this.usum_mand_prem = usum_mand_prem;
    }

    public BigDecimal getUsum_mand_prem() {
        return usum_mand_prem;
    }

    public void setUsum_mand_comm(BigDecimal usum_mand_comm) {
        this.usum_mand_comm = usum_mand_comm;
    }

    public BigDecimal getUsum_mand_comm() {
        return usum_mand_comm;
    }

    public void setUsum_quota_prem(BigDecimal usum_quota_prem) {
        this.usum_quota_prem = usum_quota_prem;
    }

    public BigDecimal getUsum_quota_prem() {
        return usum_quota_prem;
    }

    public void setUsum_quota_comm(BigDecimal usum_quota_comm) {
        this.usum_quota_comm = usum_quota_comm;
    }

    public BigDecimal getUsum_quota_comm() {
        return usum_quota_comm;
    }

    public void setUsum_fstsup_prem(BigDecimal usum_fstsup_prem) {
        this.usum_fstsup_prem = usum_fstsup_prem;
    }

    public BigDecimal getUsum_fstsup_prem() {
        return usum_fstsup_prem;
    }

    public void setUsum_fstsup_comm(BigDecimal usum_fstsup_comm) {
        this.usum_fstsup_comm = usum_fstsup_comm;
    }

    public BigDecimal getUsum_fstsup_comm() {
        return usum_fstsup_comm;
    }

    public void setUsum_secsup_prem(BigDecimal usum_secsup_prem) {
        this.usum_secsup_prem = usum_secsup_prem;
    }

    public BigDecimal getUsum_secsup_prem() {
        return usum_secsup_prem;
    }

    public void setUsum_secsup_comm(BigDecimal usum_secsup_comm) {
        this.usum_secsup_comm = usum_secsup_comm;
    }

    public BigDecimal getUsum_secsup_comm() {
        return usum_secsup_comm;
    }

    public void setUsum_facre_prem(BigDecimal usum_facre_prem) {
        this.usum_facre_prem = usum_facre_prem;
    }

    public BigDecimal getUsum_facre_prem() {
        return usum_facre_prem;
    }

    public void setUsum_facre_comm(BigDecimal usum_facre_comm) {
        this.usum_facre_comm = usum_facre_comm;
    }

    public BigDecimal getUsum_facre_comm() {
        return usum_facre_comm;
    }

    public void setUsum_facob_prem(BigDecimal usum_facob_prem) {
        this.usum_facob_prem = usum_facob_prem;
    }

    public BigDecimal getUsum_facob_prem() {
        return usum_facob_prem;
    }

    public void setUsum_facob_comm(BigDecimal usum_facob_comm) {
        this.usum_facob_comm = usum_facob_comm;
    }

    public BigDecimal getUsum_facob_comm() {
        return usum_facob_comm;
    }

    public void setUsum_pool_prem(BigDecimal usum_pool_prem) {
        this.usum_pool_prem = usum_pool_prem;
    }

    public BigDecimal getUsum_pool_prem() {
        return usum_pool_prem;
    }

    public void setUsum_pool_comm(BigDecimal usum_pool_comm) {
        this.usum_pool_comm = usum_pool_comm;
    }

    public BigDecimal getUsum_pool_comm() {
        return usum_pool_comm;
    }

    public void setUsum_prev_usum_code(BigDecimal usum_prev_usum_code) {
        this.usum_prev_usum_code = usum_prev_usum_code;
    }

    public BigDecimal getUsum_prev_usum_code() {
        return usum_prev_usum_code;
    }

    public void setScl_desc(String scl_desc) {
        this.scl_desc = scl_desc;
    }

    public String getScl_desc() {
        return scl_desc;
    }

    public void setBrn_name(String brn_name) {
        this.brn_name = brn_name;
    }

    public String getBrn_name() {
        return brn_name;
    }

    public void setCur_desc(String cur_desc) {
        this.cur_desc = cur_desc;
    }

    public String getCur_desc() {
        return cur_desc;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setUp_pol_policy_no(String up_pol_policy_no) {
        this.up_pol_policy_no = up_pol_policy_no;
    }

    public String getUp_pol_policy_no() {
        return up_pol_policy_no;
    }

    public void setUp_property_id(String up_property_id) {
        this.up_property_id = up_property_id;
    }

    public String getUp_property_id() {
        return up_property_id;
    }

    public void setUp_policy_cover_from(Date up_policy_cover_from) {
        this.up_policy_cover_from = up_policy_cover_from;
    }

    public Date getUp_policy_cover_from() {
        return up_policy_cover_from;
    }

    public void setUp_policy_cover_to(Date up_policy_cover_to) {
        this.up_policy_cover_to = up_policy_cover_to;
    }

    public Date getUp_policy_cover_to() {
        return up_policy_cover_to;
    }

    public void setUp_code(BigDecimal up_code) {
        this.up_code = up_code;
    }

    public BigDecimal getUp_code() {
        return up_code;
    }

    public void setUp_utrans_code(BigDecimal up_utrans_code) {
        this.up_utrans_code = up_utrans_code;
    }

    public BigDecimal getUp_utrans_code() {
        return up_utrans_code;
    }

    public void setUp_scl_code(BigDecimal up_scl_code) {
        this.up_scl_code = up_scl_code;
    }

    public BigDecimal getUp_scl_code() {
        return up_scl_code;
    }

    public void setUp_brn_code(BigDecimal up_brn_code) {
        this.up_brn_code = up_brn_code;
    }

    public BigDecimal getUp_brn_code() {
        return up_brn_code;
    }

    public void setUp_agn_code(BigDecimal up_agn_code) {
        this.up_agn_code = up_agn_code;
    }

    public BigDecimal getUp_agn_code() {
        return up_agn_code;
    }

    public void setUp_cur_code(BigDecimal up_cur_code) {
        this.up_cur_code = up_cur_code;
    }

    public BigDecimal getUp_cur_code() {
        return up_cur_code;
    }

    public void setUp_pol_batch_no(BigDecimal up_pol_batch_no) {
        this.up_pol_batch_no = up_pol_batch_no;
    }

    public BigDecimal getUp_pol_batch_no() {
        return up_pol_batch_no;
    }

    public void setUp_ipu_code(BigDecimal up_ipu_code) {
        this.up_ipu_code = up_ipu_code;
    }

    public BigDecimal getUp_ipu_code() {
        return up_ipu_code;
    }

    public void setUp_days_moths(BigDecimal up_days_moths) {
        this.up_days_moths = up_days_moths;
    }

    public BigDecimal getUp_days_moths() {
        return up_days_moths;
    }

    public void setUp_earned_mnths_days(BigDecimal up_earned_mnths_days) {
        this.up_earned_mnths_days = up_earned_mnths_days;
    }

    public BigDecimal getUp_earned_mnths_days() {
        return up_earned_mnths_days;
    }

    public void setUp_unearned_mnths_days(BigDecimal up_unearned_mnths_days) {
        this.up_unearned_mnths_days = up_unearned_mnths_days;
    }

    public BigDecimal getUp_unearned_mnths_days() {
        return up_unearned_mnths_days;
    }

    public void setUp_unearned_prem(BigDecimal up_unearned_prem) {
        this.up_unearned_prem = up_unearned_prem;
    }

    public BigDecimal getUp_unearned_prem() {
        return up_unearned_prem;
    }

    public void setUp_gross_prem(BigDecimal up_gross_prem) {
        this.up_gross_prem = up_gross_prem;
    }

    public BigDecimal getUp_gross_prem() {
        return up_gross_prem;
    }

    public void setUp_gross_comm(BigDecimal up_gross_comm) {
        this.up_gross_comm = up_gross_comm;
    }

    public BigDecimal getUp_gross_comm() {
        return up_gross_comm;
    }

    public void setUp_mand_prem(BigDecimal up_mand_prem) {
        this.up_mand_prem = up_mand_prem;
    }

    public BigDecimal getUp_mand_prem() {
        return up_mand_prem;
    }

    public void setUp_mand_comm(BigDecimal up_mand_comm) {
        this.up_mand_comm = up_mand_comm;
    }

    public BigDecimal getUp_mand_comm() {
        return up_mand_comm;
    }

    public void setUp_quota_prem(BigDecimal up_quota_prem) {
        this.up_quota_prem = up_quota_prem;
    }

    public BigDecimal getUp_quota_prem() {
        return up_quota_prem;
    }

    public void setUp_quota_comm(BigDecimal up_quota_comm) {
        this.up_quota_comm = up_quota_comm;
    }

    public BigDecimal getUp_quota_comm() {
        return up_quota_comm;
    }

    public void setUp_fstsup_prem(BigDecimal up_fstsup_prem) {
        this.up_fstsup_prem = up_fstsup_prem;
    }

    public BigDecimal getUp_fstsup_prem() {
        return up_fstsup_prem;
    }

    public void setUp_fstsup_comm(BigDecimal up_fstsup_comm) {
        this.up_fstsup_comm = up_fstsup_comm;
    }

    public BigDecimal getUp_fstsup_comm() {
        return up_fstsup_comm;
    }

    public void setUp_secsup_prem(BigDecimal up_secsup_prem) {
        this.up_secsup_prem = up_secsup_prem;
    }

    public BigDecimal getUp_secsup_prem() {
        return up_secsup_prem;
    }

    public void setUp_secsup_comm(BigDecimal up_secsup_comm) {
        this.up_secsup_comm = up_secsup_comm;
    }

    public BigDecimal getUp_secsup_comm() {
        return up_secsup_comm;
    }

    public void setUp_facre_prem(BigDecimal up_facre_prem) {
        this.up_facre_prem = up_facre_prem;
    }

    public BigDecimal getUp_facre_prem() {
        return up_facre_prem;
    }

    public void setUp_facre_comm(BigDecimal up_facre_comm) {
        this.up_facre_comm = up_facre_comm;
    }

    public BigDecimal getUp_facre_comm() {
        return up_facre_comm;
    }

    public void setUp_facob_prem(BigDecimal up_facob_prem) {
        this.up_facob_prem = up_facob_prem;
    }

    public BigDecimal getUp_facob_prem() {
        return up_facob_prem;
    }

    public void setUp_facob_comm(BigDecimal up_facob_comm) {
        this.up_facob_comm = up_facob_comm;
    }

    public BigDecimal getUp_facob_comm() {
        return up_facob_comm;
    }

    public void setUp_pool_prem(BigDecimal up_pool_prem) {
        this.up_pool_prem = up_pool_prem;
    }

    public BigDecimal getUp_pool_prem() {
        return up_pool_prem;
    }

    public void setUp_pool_comm(BigDecimal up_pool_comm) {
        this.up_pool_comm = up_pool_comm;
    }

    public BigDecimal getUp_pool_comm() {
        return up_pool_comm;
    }

    public void setAgnName(String agnName) {
        this.agnName = agnName;
    }

    public String getAgnName() {
        return agnName;
    }

    public void setUsum_unearned_prem(BigDecimal usum_unearned_prem) {
        this.usum_unearned_prem = usum_unearned_prem;
    }

    public BigDecimal getUsum_unearned_prem() {
        return usum_unearned_prem;
    }

    public void setUsum_unearned_com(BigDecimal usum_unearned_com) {
        this.usum_unearned_com = usum_unearned_com;
    }

    public BigDecimal getUsum_unearned_com() {
        return usum_unearned_com;
    }

    public void setUp_unearned_com(BigDecimal up_unearned_com) {
        this.up_unearned_com = up_unearned_com;
    }

    public BigDecimal getUp_unearned_com() {
        return up_unearned_com;
    }

    public void setIbnrCode(BigDecimal ibnrCode) {
        this.ibnrCode = ibnrCode;
    }

    public BigDecimal getIbnrCode() {
        return ibnrCode;
    }

    public void setIbnrBatchNumber(BigDecimal ibnrBatchNumber) {
        this.ibnrBatchNumber = ibnrBatchNumber;
    }

    public BigDecimal getIbnrBatchNumber() {
        return ibnrBatchNumber;
    }

    public void setIbnrType(String ibnrType) {
        this.ibnrType = ibnrType;
    }

    public String getIbnrType() {
        return ibnrType;
    }

    public void setIbnrProvPct(BigDecimal ibnrProvPct) {
        this.ibnrProvPct = ibnrProvPct;
    }

    public BigDecimal getIbnrProvPct() {
        return ibnrProvPct;
    }

    public void setIbnrClaCode(BigDecimal ibnrClaCode) {
        this.ibnrClaCode = ibnrClaCode;
    }

    public BigDecimal getIbnrClaCode() {
        return ibnrClaCode;
    }

    public void setIbnrSclCode(BigDecimal ibnrSclCode) {
        this.ibnrSclCode = ibnrSclCode;
    }

    public BigDecimal getIbnrSclCode() {
        return ibnrSclCode;
    }

    public void setIbnrFromDate(Date ibnrFromDate) {
        this.ibnrFromDate = ibnrFromDate;
    }

    public Date getIbnrFromDate() {
        return ibnrFromDate;
    }

    public void setIbnrToDate(Date ibnrToDate) {
        this.ibnrToDate = ibnrToDate;
    }

    public Date getIbnrToDate() {
        return ibnrToDate;
    }

    public void setIbnrBfGrossOs(BigDecimal ibnrBfGrossOs) {
        this.ibnrBfGrossOs = ibnrBfGrossOs;
    }

    public BigDecimal getIbnrBfGrossOs() {
        return ibnrBfGrossOs;
    }

    public void setIbnrBfManOs(BigDecimal ibnrBfManOs) {
        this.ibnrBfManOs = ibnrBfManOs;
    }

    public BigDecimal getIbnrBfManOs() {
        return ibnrBfManOs;
    }

    public void setIbnrBfQuotaOs(BigDecimal ibnrBfQuotaOs) {
        this.ibnrBfQuotaOs = ibnrBfQuotaOs;
    }

    public BigDecimal getIbnrBfQuotaOs() {
        return ibnrBfQuotaOs;
    }

    public void setIbnrBfFstSupOs(BigDecimal ibnrBfFstSupOs) {
        this.ibnrBfFstSupOs = ibnrBfFstSupOs;
    }

    public BigDecimal getIbnrBfFstSupOs() {
        return ibnrBfFstSupOs;
    }

    public void setIbnrBfSecSupOs(BigDecimal ibnrBfSecSupOs) {
        this.ibnrBfSecSupOs = ibnrBfSecSupOs;
    }

    public BigDecimal getIbnrBfSecSupOs() {
        return ibnrBfSecSupOs;
    }

    public void setIbnrBfFacreOs(BigDecimal ibnrBfFacreOs) {
        this.ibnrBfFacreOs = ibnrBfFacreOs;
    }

    public BigDecimal getIbnrBfFacreOs() {
        return ibnrBfFacreOs;
    }

    public void setIbnrBfOwnOs(BigDecimal ibnrBfOwnOs) {
        this.ibnrBfOwnOs = ibnrBfOwnOs;
    }

    public BigDecimal getIbnrBfOwnOs() {
        return ibnrBfOwnOs;
    }

    public void setIbnrDoneBy(String ibnrDoneBy) {
        this.ibnrDoneBy = ibnrDoneBy;
    }

    public String getIbnrDoneBy() {
        return ibnrDoneBy;
    }

    public void setIbnrDateDone(Date ibnrDateDone) {
        this.ibnrDateDone = ibnrDateDone;
    }

    public Date getIbnrDateDone() {
        return ibnrDateDone;
    }

    public void setIbnrAuthBy(String ibnrAuthBy) {
        this.ibnrAuthBy = ibnrAuthBy;
    }

    public String getIbnrAuthBy() {
        return ibnrAuthBy;
    }

    public void setIbnrAuthDate(Date ibnrAuthDate) {
        this.ibnrAuthDate = ibnrAuthDate;
    }

    public Date getIbnrAuthDate() {
        return ibnrAuthDate;
    }

    public void setIbnrAuthorised(String ibnrAuthorised) {
        this.ibnrAuthorised = ibnrAuthorised;
    }

    public String getIbnrAuthorised() {
        return ibnrAuthorised;
    }

    public void setBrnCode(BigDecimal brnCode) {
        this.brnCode = brnCode;
    }

    public BigDecimal getBrnCode() {
        return brnCode;
    }

    public void setIbnrUtransCode(BigDecimal ibnrUtransCode) {
        this.ibnrUtransCode = ibnrUtransCode;
    }

    public BigDecimal getIbnrUtransCode() {
        return ibnrUtransCode;
    }

    public void setIbnrCurrencyRate(BigDecimal ibnrCurrencyRate) {
        this.ibnrCurrencyRate = ibnrCurrencyRate;
    }

    public BigDecimal getIbnrCurrencyRate() {
        return ibnrCurrencyRate;
    }

    public void setIbnrCurrencyCode(BigDecimal ibnrCurrencyCode) {
        this.ibnrCurrencyCode = ibnrCurrencyCode;
    }

    public BigDecimal getIbnrCurrencyCode() {
        return ibnrCurrencyCode;
    }

    public void setIbnrPrevIbnrCode(BigDecimal ibnrPrevIbnrCode) {
        this.ibnrPrevIbnrCode = ibnrPrevIbnrCode;
    }

    public BigDecimal getIbnrPrevIbnrCode() {
        return ibnrPrevIbnrCode;
    }

    public void setIbnrBrnName(String ibnrBrnName) {
        this.ibnrBrnName = ibnrBrnName;
    }

    public String getIbnrBrnName() {
        return ibnrBrnName;
    }

    public void setIbnrCurrSymbol(String ibnrCurrSymbol) {
        this.ibnrCurrSymbol = ibnrCurrSymbol;
    }

    public String getIbnrCurrSymbol() {
        return ibnrCurrSymbol;
    }

    public void setIbnrCurrDesc(String ibnrCurrDesc) {
        this.ibnrCurrDesc = ibnrCurrDesc;
    }

    public String getIbnrCurrDesc() {
        return ibnrCurrDesc;
    }

    public void setSclDesc(String sclDesc) {
        this.sclDesc = sclDesc;
    }

    public String getSclDesc() {
        return sclDesc;
    }

    public void setIbnrGrossPremium(BigDecimal ibnrGrossPremium) {
        this.ibnrGrossPremium = ibnrGrossPremium;
    }

    public BigDecimal getIbnrGrossPremium() {
        return ibnrGrossPremium;
    }

    public void setIbnrManPrem(BigDecimal ibnrManPrem) {
        this.ibnrManPrem = ibnrManPrem;
    }

    public BigDecimal getIbnrManPrem() {
        return ibnrManPrem;
    }

    public void setIbnrFstsupPrem(BigDecimal ibnrFstsupPrem) {
        this.ibnrFstsupPrem = ibnrFstsupPrem;
    }

    public BigDecimal getIbnrFstsupPrem() {
        return ibnrFstsupPrem;
    }

    public void setIbnrSecSupPrem(BigDecimal ibnrSecSupPrem) {
        this.ibnrSecSupPrem = ibnrSecSupPrem;
    }

    public BigDecimal getIbnrSecSupPrem() {
        return ibnrSecSupPrem;
    }

    public void setIbnrFacrePrem(BigDecimal ibnrFacrePrem) {
        this.ibnrFacrePrem = ibnrFacrePrem;
    }

    public BigDecimal getIbnrFacrePrem() {
        return ibnrFacrePrem;
    }

    public void setIbnrOwnPrem(BigDecimal ibnrOwnPrem) {
        this.ibnrOwnPrem = ibnrOwnPrem;
    }

    public BigDecimal getIbnrOwnPrem() {
        return ibnrOwnPrem;
    }

    public void setIbnrbrnCode(BigDecimal ibnrbrnCode) {
        this.ibnrbrnCode = ibnrbrnCode;
    }

    public BigDecimal getIbnrbrnCode() {
        return ibnrbrnCode;
    }

    public void setIbnrUiransCode(BigDecimal ibnrUiransCode) {
        this.ibnrUiransCode = ibnrUiransCode;
    }

    public BigDecimal getIbnrUiransCode() {
        return ibnrUiransCode;
    }

    public void setIbnrCurrRate(BigDecimal ibnrCurrRate) {
        this.ibnrCurrRate = ibnrCurrRate;
    }

    public BigDecimal getIbnrCurrRate() {
        return ibnrCurrRate;
    }

    public void setIbnrCurrCode(BigDecimal ibnrCurrCode) {
        this.ibnrCurrCode = ibnrCurrCode;
    }

    public BigDecimal getIbnrCurrCode() {
        return ibnrCurrCode;
    }

    public void setIbnrPreviousIbnrCode(BigDecimal ibnrPreviousIbnrCode) {
        this.ibnrPreviousIbnrCode = ibnrPreviousIbnrCode;
    }

    public BigDecimal getIbnrPreviousIbnrCode() {
        return ibnrPreviousIbnrCode;
    }

    public void setBrnName(String brnName) {
        this.brnName = brnName;
    }

    public String getBrnName() {
        return brnName;
    }

    public void setCurrSymbol(String currSymbol) {
        this.currSymbol = currSymbol;
    }

    public String getCurrSymbol() {
        return currSymbol;
    }

    public void setCurrDescription(String currDescription) {
        this.currDescription = currDescription;
    }

    public String getCurrDescription() {
        return currDescription;
    }

    public void setCurrencyDesc(String currencyDesc) {
        this.currencyDesc = currencyDesc;
    }

    public String getCurrencyDesc() {
        return currencyDesc;
    }

    public void setIbnrQuotaPrem(BigDecimal ibnrQuotaPrem) {
        this.ibnrQuotaPrem = ibnrQuotaPrem;
    }

    public BigDecimal getIbnrQuotaPrem() {
        return ibnrQuotaPrem;
    }

    public void setIbnr_code(BigDecimal ibnr_code) {
        this.ibnr_code = ibnr_code;
    }

    public BigDecimal getIbnr_code() {
        return ibnr_code;
    }

    public void setIbnr_uirans_code(BigDecimal ibnr_uirans_code) {
        this.ibnr_uirans_code = ibnr_uirans_code;
    }

    public BigDecimal getIbnr_uirans_code() {
        return ibnr_uirans_code;
    }

    public void setIbnr_scl_code(BigDecimal ibnr_scl_code) {
        this.ibnr_scl_code = ibnr_scl_code;
    }

    public BigDecimal getIbnr_scl_code() {
        return ibnr_scl_code;
    }

    public void setIbnr_brn_code(BigDecimal ibnr_brn_code) {
        this.ibnr_brn_code = ibnr_brn_code;
    }

    public BigDecimal getIbnr_brn_code() {
        return ibnr_brn_code;
    }

    public void setIbnr_cur_code(BigDecimal ibnr_cur_code) {
        this.ibnr_cur_code = ibnr_cur_code;
    }

    public BigDecimal getIbnr_cur_code() {
        return ibnr_cur_code;
    }

    public void setIbnr_grs_ibnr_y1(BigDecimal ibnr_grs_ibnr_y1) {
        this.ibnr_grs_ibnr_y1 = ibnr_grs_ibnr_y1;
    }

    public BigDecimal getIbnr_grs_ibnr_y1() {
        return ibnr_grs_ibnr_y1;
    }

    public void setIbnr_grs_ibnr_y2(BigDecimal ibnr_grs_ibnr_y2) {
        this.ibnr_grs_ibnr_y2 = ibnr_grs_ibnr_y2;
    }

    public BigDecimal getIbnr_grs_ibnr_y2() {
        return ibnr_grs_ibnr_y2;
    }

    public void setIbnr_grs_ibnr_y3(BigDecimal ibnr_grs_ibnr_y3) {
        this.ibnr_grs_ibnr_y3 = ibnr_grs_ibnr_y3;
    }

    public BigDecimal getIbnr_grs_ibnr_y3() {
        return ibnr_grs_ibnr_y3;
    }

    public void setIbnr_man_ibnr_y1(BigDecimal ibnr_man_ibnr_y1) {
        this.ibnr_man_ibnr_y1 = ibnr_man_ibnr_y1;
    }

    public BigDecimal getIbnr_man_ibnr_y1() {
        return ibnr_man_ibnr_y1;
    }

    public void setIbnr_man_ibnr_y2(BigDecimal ibnr_man_ibnr_y2) {
        this.ibnr_man_ibnr_y2 = ibnr_man_ibnr_y2;
    }

    public BigDecimal getIbnr_man_ibnr_y2() {
        return ibnr_man_ibnr_y2;
    }

    public void setIbnr_man_ibnr_y3(BigDecimal ibnr_man_ibnr_y3) {
        this.ibnr_man_ibnr_y3 = ibnr_man_ibnr_y3;
    }

    public BigDecimal getIbnr_man_ibnr_y3() {
        return ibnr_man_ibnr_y3;
    }

    public void setIbnr_quota_ibnr_y1(BigDecimal ibnr_quota_ibnr_y1) {
        this.ibnr_quota_ibnr_y1 = ibnr_quota_ibnr_y1;
    }

    public BigDecimal getIbnr_quota_ibnr_y1() {
        return ibnr_quota_ibnr_y1;
    }

    public void setIbnr_quota_ibnr_y2(BigDecimal ibnr_quota_ibnr_y2) {
        this.ibnr_quota_ibnr_y2 = ibnr_quota_ibnr_y2;
    }

    public BigDecimal getIbnr_quota_ibnr_y2() {
        return ibnr_quota_ibnr_y2;
    }

    public void setIbnr_quota_ibnr_y3(BigDecimal ibnr_quota_ibnr_y3) {
        this.ibnr_quota_ibnr_y3 = ibnr_quota_ibnr_y3;
    }

    public BigDecimal getIbnr_quota_ibnr_y3() {
        return ibnr_quota_ibnr_y3;
    }

    public void setIbnr_fstsup_ibnr_y1(BigDecimal ibnr_fstsup_ibnr_y1) {
        this.ibnr_fstsup_ibnr_y1 = ibnr_fstsup_ibnr_y1;
    }

    public BigDecimal getIbnr_fstsup_ibnr_y1() {
        return ibnr_fstsup_ibnr_y1;
    }

    public void setIbnr_fstsup_ibnr_y2(BigDecimal ibnr_fstsup_ibnr_y2) {
        this.ibnr_fstsup_ibnr_y2 = ibnr_fstsup_ibnr_y2;
    }

    public BigDecimal getIbnr_fstsup_ibnr_y2() {
        return ibnr_fstsup_ibnr_y2;
    }

    public void setIbnr_fstsup_ibnr_y3(BigDecimal ibnr_fstsup_ibnr_y3) {
        this.ibnr_fstsup_ibnr_y3 = ibnr_fstsup_ibnr_y3;
    }

    public BigDecimal getIbnr_fstsup_ibnr_y3() {
        return ibnr_fstsup_ibnr_y3;
    }

    public void setIbnr_secsup_ibnr_y1(BigDecimal ibnr_secsup_ibnr_y1) {
        this.ibnr_secsup_ibnr_y1 = ibnr_secsup_ibnr_y1;
    }

    public BigDecimal getIbnr_secsup_ibnr_y1() {
        return ibnr_secsup_ibnr_y1;
    }

    public void setIbnr_secsup_ibnr_y2(BigDecimal ibnr_secsup_ibnr_y2) {
        this.ibnr_secsup_ibnr_y2 = ibnr_secsup_ibnr_y2;
    }

    public BigDecimal getIbnr_secsup_ibnr_y2() {
        return ibnr_secsup_ibnr_y2;
    }

    public void setIbnr_secsup_ibnr_y3(BigDecimal ibnr_secsup_ibnr_y3) {
        this.ibnr_secsup_ibnr_y3 = ibnr_secsup_ibnr_y3;
    }

    public BigDecimal getIbnr_secsup_ibnr_y3() {
        return ibnr_secsup_ibnr_y3;
    }

    public void setIbnr_facre_ibnr_y1(BigDecimal ibnr_facre_ibnr_y1) {
        this.ibnr_facre_ibnr_y1 = ibnr_facre_ibnr_y1;
    }

    public BigDecimal getIbnr_facre_ibnr_y1() {
        return ibnr_facre_ibnr_y1;
    }

    public void setIbnr_facre_ibnr_y2(BigDecimal ibnr_facre_ibnr_y2) {
        this.ibnr_facre_ibnr_y2 = ibnr_facre_ibnr_y2;
    }

    public BigDecimal getIbnr_facre_ibnr_y2() {
        return ibnr_facre_ibnr_y2;
    }

    public void setIbnr_facre_ibnr_y3(BigDecimal ibnr_facre_ibnr_y3) {
        this.ibnr_facre_ibnr_y3 = ibnr_facre_ibnr_y3;
    }

    public BigDecimal getIbnr_facre_ibnr_y3() {
        return ibnr_facre_ibnr_y3;
    }

    public void setIbnr_own_ibnr_y1(BigDecimal ibnr_own_ibnr_y1) {
        this.ibnr_own_ibnr_y1 = ibnr_own_ibnr_y1;
    }

    public BigDecimal getIbnr_own_ibnr_y1() {
        return ibnr_own_ibnr_y1;
    }

    public void setIbnr_own_ibnr_y2(BigDecimal ibnr_own_ibnr_y2) {
        this.ibnr_own_ibnr_y2 = ibnr_own_ibnr_y2;
    }

    public BigDecimal getIbnr_own_ibnr_y2() {
        return ibnr_own_ibnr_y2;
    }

    public void setIbnr_own_ibnr_y3(BigDecimal ibnr_own_ibnr_y3) {
        this.ibnr_own_ibnr_y3 = ibnr_own_ibnr_y3;
    }

    public BigDecimal getIbnr_own_ibnr_y3() {
        return ibnr_own_ibnr_y3;
    }

    public void setIbnr_prev_ibnr_code(BigDecimal ibnr_prev_ibnr_code) {
        this.ibnr_prev_ibnr_code = ibnr_prev_ibnr_code;
    }

    public BigDecimal getIbnr_prev_ibnr_code() {
        return ibnr_prev_ibnr_code;
    }

    public void setIbnr_grs_ibnr_tot(BigDecimal ibnr_grs_ibnr_tot) {
        this.ibnr_grs_ibnr_tot = ibnr_grs_ibnr_tot;
    }

    public BigDecimal getIbnr_grs_ibnr_tot() {
        return ibnr_grs_ibnr_tot;
    }

    public void setIbnr_man_ibnr_tot(BigDecimal ibnr_man_ibnr_tot) {
        this.ibnr_man_ibnr_tot = ibnr_man_ibnr_tot;
    }

    public BigDecimal getIbnr_man_ibnr_tot() {
        return ibnr_man_ibnr_tot;
    }

    public void setIbnr_quota_ibnr_tot(BigDecimal ibnr_quota_ibnr_tot) {
        this.ibnr_quota_ibnr_tot = ibnr_quota_ibnr_tot;
    }

    public BigDecimal getIbnr_quota_ibnr_tot() {
        return ibnr_quota_ibnr_tot;
    }

    public void setIbnr_fstsup_ibnr_tot(BigDecimal ibnr_fstsup_ibnr_tot) {
        this.ibnr_fstsup_ibnr_tot = ibnr_fstsup_ibnr_tot;
    }

    public BigDecimal getIbnr_fstsup_ibnr_tot() {
        return ibnr_fstsup_ibnr_tot;
    }

    public void setIbnr_secsup_ibnr_tot(BigDecimal ibnr_secsup_ibnr_tot) {
        this.ibnr_secsup_ibnr_tot = ibnr_secsup_ibnr_tot;
    }

    public BigDecimal getIbnr_secsup_ibnr_tot() {
        return ibnr_secsup_ibnr_tot;
    }

    public void setIbnr_facre_ibnr_tot(BigDecimal ibnr_facre_ibnr_tot) {
        this.ibnr_facre_ibnr_tot = ibnr_facre_ibnr_tot;
    }

    public BigDecimal getIbnr_facre_ibnr_tot() {
        return ibnr_facre_ibnr_tot;
    }

    public void setIbnr_own_ibnr_tot(BigDecimal ibnr_own_ibnr_tot) {
        this.ibnr_own_ibnr_tot = ibnr_own_ibnr_tot;
    }

    public BigDecimal getIbnr_own_ibnr_tot() {
        return ibnr_own_ibnr_tot;
    }

    public void setIbnr_pool_ibnr_y1(BigDecimal ibnr_pool_ibnr_y1) {
        this.ibnr_pool_ibnr_y1 = ibnr_pool_ibnr_y1;
    }

    public BigDecimal getIbnr_pool_ibnr_y1() {
        return ibnr_pool_ibnr_y1;
    }

    public void setIbnr_pool_ibnr_y2(BigDecimal ibnr_pool_ibnr_y2) {
        this.ibnr_pool_ibnr_y2 = ibnr_pool_ibnr_y2;
    }

    public BigDecimal getIbnr_pool_ibnr_y2() {
        return ibnr_pool_ibnr_y2;
    }

    public void setIbnr_pool_ibnr_y3(BigDecimal ibnr_pool_ibnr_y3) {
        this.ibnr_pool_ibnr_y3 = ibnr_pool_ibnr_y3;
    }

    public BigDecimal getIbnr_pool_ibnr_y3() {
        return ibnr_pool_ibnr_y3;
    }

    public void setIbnr_pool_ibnr_tot(BigDecimal ibnr_pool_ibnr_tot) {
        this.ibnr_pool_ibnr_tot = ibnr_pool_ibnr_tot;
    }

    public BigDecimal getIbnr_pool_ibnr_tot() {
        return ibnr_pool_ibnr_tot;
    }

    public void setIbnr_facre_obibnr_y1(BigDecimal ibnr_facre_obibnr_y1) {
        this.ibnr_facre_obibnr_y1 = ibnr_facre_obibnr_y1;
    }

    public BigDecimal getIbnr_facre_obibnr_y1() {
        return ibnr_facre_obibnr_y1;
    }

    public void setIbnr_facre_obibnr_y2(BigDecimal ibnr_facre_obibnr_y2) {
        this.ibnr_facre_obibnr_y2 = ibnr_facre_obibnr_y2;
    }

    public BigDecimal getIbnr_facre_obibnr_y2() {
        return ibnr_facre_obibnr_y2;
    }

    public void setIbnr_facre_obibnr_y3(BigDecimal ibnr_facre_obibnr_y3) {
        this.ibnr_facre_obibnr_y3 = ibnr_facre_obibnr_y3;
    }

    public BigDecimal getIbnr_facre_obibnr_y3() {
        return ibnr_facre_obibnr_y3;
    }

    public void setIbnr_facre_obibnr_tot(BigDecimal ibnr_facre_obibnr_tot) {
        this.ibnr_facre_obibnr_tot = ibnr_facre_obibnr_tot;
    }

    public BigDecimal getIbnr_facre_obibnr_tot() {
        return ibnr_facre_obibnr_tot;
    }

    public void setProd_desc(String prod_desc) {
        this.prod_desc = prod_desc;
    }

    public String getProd_desc() {
        return prod_desc;
    }

    public void setUp_unearned_comm(BigDecimal up_unearned_comm) {
        this.up_unearned_comm = up_unearned_comm;
    }

    public BigDecimal getUp_unearned_comm() {
        return up_unearned_comm;
    }

    public void setUp_ri_prem(BigDecimal up_ri_prem) {
        this.up_ri_prem = up_ri_prem;
    }

    public BigDecimal getUp_ri_prem() {
        return up_ri_prem;
    }

    public void setUp_unearned_ri_prem(BigDecimal up_unearned_ri_prem) {
        this.up_unearned_ri_prem = up_unearned_ri_prem;
    }

    public BigDecimal getUp_unearned_ri_prem() {
        return up_unearned_ri_prem;
    }

    public void setUp_ricomm(BigDecimal up_ricomm) {
        this.up_ricomm = up_ricomm;
    }

    public BigDecimal getUp_ricomm() {
        return up_ricomm;
    }

    public void setUp_unearned_ri_comm(BigDecimal up_unearned_ri_comm) {
        this.up_unearned_ri_comm = up_unearned_ri_comm;
    }

    public BigDecimal getUp_unearned_ri_comm() {
        return up_unearned_ri_comm;
    }
}
