package LMSG.view.GroupProducts;

import java.math.BigDecimal;

public class productDetails {
    public productDetails() {
        super();
    }
    //Product Details
    private BigDecimal pcd_max_sum_assured;
    private BigDecimal PCD_MIN_SUM_ASSURED;
    private BigDecimal prodCode;
    private String prodDesc;
    private String prodshtDesc;
    private String prodType;
    private BigDecimal prod_lapse_prd_days;
    private BigDecimal PROD_MIN_EARNINGS_PRD;
    private String PROD_DEPENDT_COVERED;
    private String PROD_SAVINGS_COVERED;
    private String PROD_DEPENDT_COVERED2;
    private String PROD_EARNING_PRD_TYPE;
    private BigDecimal pct_main_sa_perc;
    
    private Boolean Selected;
    
    //Product Premium Masks
    private BigDecimal PMAS_CODE; 
    private String PMAS_SHT_DESC;
    private String PMAS_DESC;
    
    //Product Covers
    private BigDecimal cvt_code;
    private BigDecimal pct_code;
    private String cvt_sht_desc;
    private String cvt_desc;
    private String cvt_main_cover;
    private String pct_formular;
    private String pct_refund_formular;
    private String cvt_duration_type;
    
    //Product Provisions
    private BigDecimal PPROV_CODE;
    private String PROV_SHT_DESC;
    private String PROV_DESC;
    private String PPROV_EDITABLE;
    private Integer PPROV_PROD_CODE;
    
    //Dependant Covers
    private BigDecimal DTY_CODE,max_allowed;
    private String  DTY_SHT_DESC, DTY_DESCRIPTION;
    
    //Lapsed Products
    private BigDecimal lp_prod_code;
    private String lp_prod_sht_desc;
    private String lp_prod_desc;
    private String lp_prod_type;
    private String lp_PROD_LAPSE_PRD_DAYS;
    private BigDecimal mempCode;
    private String pctInbuilt,pctAccelerator;


    public void setProdCode(BigDecimal prodCode) {
        this.prodCode = prodCode;
    }

    public BigDecimal getProdCode() {
        return prodCode;
    }

    public void setProdDesc(String prodDesc) {
        this.prodDesc = prodDesc;
    }

    public String getProdDesc() {
        return prodDesc;
    }

    public void setProdshtDesc(String prodshtDesc) {
        this.prodshtDesc = prodshtDesc;
    }

    public String getProdshtDesc() {
        return prodshtDesc;
    }
    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    public String getProdType() {
        return prodType;
    }

    public void setPMAS_CODE(BigDecimal PMAS_CODE) {
        this.PMAS_CODE = PMAS_CODE;
    }

    public BigDecimal getPMAS_CODE() {
        return PMAS_CODE;
    }

    public void setPMAS_SHT_DESC(String PMAS_SHT_DESC) {
        this.PMAS_SHT_DESC = PMAS_SHT_DESC;
    }

    public String getPMAS_SHT_DESC() {
        return PMAS_SHT_DESC;
    }

    public void setPMAS_DESC(String PMAS_DESC) {
        this.PMAS_DESC = PMAS_DESC;
    }

    public String getPMAS_DESC() {
        return PMAS_DESC;
    }

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

    public void setPPROV_CODE(BigDecimal PPROV_CODE) {
        this.PPROV_CODE = PPROV_CODE;
    }

    public BigDecimal getPPROV_CODE() {
        return PPROV_CODE;
    }

    public void setPROV_SHT_DESC(String PROV_SHT_DESC) {
        this.PROV_SHT_DESC = PROV_SHT_DESC;
    }

    public String getPROV_SHT_DESC() {
        return PROV_SHT_DESC;
    }

    public void setPROV_DESC(String PROV_DESC) {
        this.PROV_DESC = PROV_DESC;
    }

    public String getPROV_DESC() {
        return PROV_DESC;
    }

    public void setPPROV_EDITABLE(String PPROV_EDITABLE) {
        this.PPROV_EDITABLE = PPROV_EDITABLE;
    }

    public String getPPROV_EDITABLE() {
        return PPROV_EDITABLE;
    }

    public void setPPROV_PROD_CODE(Integer PPROV_PROD_CODE) {
        this.PPROV_PROD_CODE = PPROV_PROD_CODE;
    }

    public Integer getPPROV_PROD_CODE() {
        return PPROV_PROD_CODE;
    }

    public void setDTY_CODE(BigDecimal DTY_CODE) {
        this.DTY_CODE = DTY_CODE;
    }

    public BigDecimal getDTY_CODE() {
        return DTY_CODE;
    }

    public void setMax_allowed(BigDecimal max_allowed) {
        this.max_allowed = max_allowed;
    }

    public BigDecimal getMax_allowed() {
        return max_allowed;
    }

    public void setDTY_SHT_DESC(String DTY_SHT_DESC) {
        this.DTY_SHT_DESC = DTY_SHT_DESC;
    }

    public String getDTY_SHT_DESC() {
        return DTY_SHT_DESC;
    }

    public void setDTY_DESCRIPTION(String DTY_DESCRIPTION) {
        this.DTY_DESCRIPTION = DTY_DESCRIPTION;
    }

    public String getDTY_DESCRIPTION() {
        return DTY_DESCRIPTION;
    }

    public void setLp_prod_code(BigDecimal lp_prod_code) {
        this.lp_prod_code = lp_prod_code;
    }

    public BigDecimal getLp_prod_code() {
        return lp_prod_code;
    }

    public void setLp_prod_sht_desc(String lp_prod_sht_desc) {
        this.lp_prod_sht_desc = lp_prod_sht_desc;
    }

    public String getLp_prod_sht_desc() {
        return lp_prod_sht_desc;
    }

    public void setLp_prod_desc(String lp_prod_desc) {
        this.lp_prod_desc = lp_prod_desc;
    }

    public String getLp_prod_desc() {
        return lp_prod_desc;
    }

    public void setLp_prod_type(String lp_prod_type) {
        this.lp_prod_type = lp_prod_type;
    }

    public String getLp_prod_type() {
        return lp_prod_type;
    }

    public void setLp_PROD_LAPSE_PRD_DAYS(String lp_PROD_LAPSE_PRD_DAYS) {
        this.lp_PROD_LAPSE_PRD_DAYS = lp_PROD_LAPSE_PRD_DAYS;
    }

    public String getLp_PROD_LAPSE_PRD_DAYS() {
        return lp_PROD_LAPSE_PRD_DAYS;
    }

    public void setProd_lapse_prd_days(BigDecimal prod_lapse_prd_days) {
        this.prod_lapse_prd_days = prod_lapse_prd_days;
    }

    public BigDecimal getProd_lapse_prd_days() {
        return prod_lapse_prd_days;
    }

    public void setPROD_MIN_EARNINGS_PRD(BigDecimal PROD_MIN_EARNINGS_PRD) {
        this.PROD_MIN_EARNINGS_PRD = PROD_MIN_EARNINGS_PRD;
    }

    public BigDecimal getPROD_MIN_EARNINGS_PRD() {
        return PROD_MIN_EARNINGS_PRD;
    }

    public void setPROD_DEPENDT_COVERED(String PROD_DEPENDT_COVERED) {
        this.PROD_DEPENDT_COVERED = PROD_DEPENDT_COVERED;
    }

    public String getPROD_DEPENDT_COVERED() {
        return PROD_DEPENDT_COVERED;
    }

    public void setPROD_SAVINGS_COVERED(String PROD_SAVINGS_COVERED) {
        this.PROD_SAVINGS_COVERED = PROD_SAVINGS_COVERED;
    }

    public String getPROD_SAVINGS_COVERED() {
        return PROD_SAVINGS_COVERED;
    }

    public void setPROD_DEPENDT_COVERED2(String PROD_DEPENDT_COVERED2) {
        this.PROD_DEPENDT_COVERED2 = PROD_DEPENDT_COVERED2;
    }

    public String getPROD_DEPENDT_COVERED2() {
        return PROD_DEPENDT_COVERED2;
    }

    public void setSelected(Boolean Selected) {
        this.Selected = Selected;
    }

    public Boolean getSelected() {
        return Selected;
    }

    public void setPct_main_sa_perc(BigDecimal pct_main_sa_perc) {
        this.pct_main_sa_perc = pct_main_sa_perc;
    }

    public BigDecimal getPct_main_sa_perc() {
        return pct_main_sa_perc;
    }

    public void setPcd_max_sum_assured(BigDecimal pcd_max_sum_assured) {
        this.pcd_max_sum_assured = pcd_max_sum_assured;
    }

    public BigDecimal getPcd_max_sum_assured() {
        return pcd_max_sum_assured;
    }

    public void setPCD_MIN_SUM_ASSURED(BigDecimal PCD_MIN_SUM_ASSURED) {
        this.PCD_MIN_SUM_ASSURED = PCD_MIN_SUM_ASSURED;
    }

    public BigDecimal getPCD_MIN_SUM_ASSURED() {
        return PCD_MIN_SUM_ASSURED;
    }

    public void setMempCode(BigDecimal mempCode) {
        this.mempCode = mempCode;
    }

    public BigDecimal getMempCode() {
        return mempCode;
    }

    public void setPROD_EARNING_PRD_TYPE(String PROD_EARNING_PRD_TYPE) {
        this.PROD_EARNING_PRD_TYPE = PROD_EARNING_PRD_TYPE;
    }

    public String getPROD_EARNING_PRD_TYPE() {
        return PROD_EARNING_PRD_TYPE;
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
