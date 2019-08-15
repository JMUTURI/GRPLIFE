package LMSG.view.Renewals;

import java.math.BigDecimal;

import java.util.Date;

public class Renewal {
    public Renewal() {
        super();
    }
    //Product Details
    private BigDecimal prodCode;
    private String prodDesc;
    private String prodshtDesc;
    private String prodType;
    private BigDecimal prod_lapse_prd_days;
    private BigDecimal PROD_MIN_EARNINGS_PRD;
    private String PROD_DEPENDT_COVERED;
    private String PROD_SAVINGS_COVERED;
    private String PROD_DEPENDT_COVERED2;
    
    //Product Premium Masks
    private BigDecimal RN_PRP_CLNT_CODE;
    private BigDecimal PMAS_CODE; 
    private String PMAS_SHT_DESC;
    private String PMAS_DESC;
    
    //Renewal Details
    private BigDecimal RN_POL_CODE;
    private String RN_POL_POLICY_NO;
    private Date RN_POL_INCEPTION_DATE;
    private Date RN_POL_EFFECTIVE_DATE;
    private String RN_POL_UNDERWRITING_YEAR;
    private BigDecimal RN_POL_PRP_CODE;
    private String RN_POL_PRP_SHT_DESC;
    private BigDecimal RN_POL_PROD_CODE;
    private String RN_POL_PROD_SHT_DESC;
    private BigDecimal RN_POL_CLIENT_PRP_CODE;
    private String RN_POL_SAVINGS_RIDER;
    private BigDecimal RN_POL_BRA_CODE;
    private Date RN_ENDR_RENEWAL_DATE;
    private BigDecimal RN_ENDR_CODE;
    private String ENDR_DURATION_TYPE;
    private String RN_CLIENT;
    private String RN_BRANCH_NAME;
    private String RN_POL_RENEWAL_AREA_STATUS;
    private String RN_POL_UMBRELLA;
    
    private boolean selected;

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

    public void setRN_POL_CODE(BigDecimal RN_POL_CODE) {
        this.RN_POL_CODE = RN_POL_CODE;
    }

    public BigDecimal getRN_POL_CODE() {
        return RN_POL_CODE;
    }

    public void setRN_POL_POLICY_NO(String RN_POL_POLICY_NO) {
        this.RN_POL_POLICY_NO = RN_POL_POLICY_NO;
    }

    public String getRN_POL_POLICY_NO() {
        return RN_POL_POLICY_NO;
    }

    public void setRN_POL_INCEPTION_DATE(Date RN_POL_INCEPTION_DATE) {
        this.RN_POL_INCEPTION_DATE = RN_POL_INCEPTION_DATE;
    }

    public Date getRN_POL_INCEPTION_DATE() {
        return RN_POL_INCEPTION_DATE;
    }

    public void setRN_POL_EFFECTIVE_DATE(Date RN_POL_EFFECTIVE_DATE) {
        this.RN_POL_EFFECTIVE_DATE = RN_POL_EFFECTIVE_DATE;
    }

    public Date getRN_POL_EFFECTIVE_DATE() {
        return RN_POL_EFFECTIVE_DATE;
    }

    public void setRN_POL_UNDERWRITING_YEAR(String RN_POL_UNDERWRITING_YEAR) {
        this.RN_POL_UNDERWRITING_YEAR = RN_POL_UNDERWRITING_YEAR;
    }

    public String getRN_POL_UNDERWRITING_YEAR() {
        return RN_POL_UNDERWRITING_YEAR;
    }

    public void setRN_POL_PRP_CODE(BigDecimal RN_POL_PRP_CODE) {
        this.RN_POL_PRP_CODE = RN_POL_PRP_CODE;
    }

    public BigDecimal getRN_POL_PRP_CODE() {
        return RN_POL_PRP_CODE;
    }

    public void setRN_POL_PRP_SHT_DESC(String RN_POL_PRP_SHT_DESC) {
        this.RN_POL_PRP_SHT_DESC = RN_POL_PRP_SHT_DESC;
    }

    public String getRN_POL_PRP_SHT_DESC() {
        return RN_POL_PRP_SHT_DESC;
    }

    public void setRN_POL_PROD_CODE(BigDecimal RN_POL_PROD_CODE) {
        this.RN_POL_PROD_CODE = RN_POL_PROD_CODE;
    }

    public BigDecimal getRN_POL_PROD_CODE() {
        return RN_POL_PROD_CODE;
    }

    public void setRN_POL_PROD_SHT_DESC(String RN_POL_PROD_SHT_DESC) {
        this.RN_POL_PROD_SHT_DESC = RN_POL_PROD_SHT_DESC;
    }

    public String getRN_POL_PROD_SHT_DESC() {
        return RN_POL_PROD_SHT_DESC;
    }

    public void setRN_POL_CLIENT_PRP_CODE(BigDecimal RN_POL_CLIENT_PRP_CODE) {
        this.RN_POL_CLIENT_PRP_CODE = RN_POL_CLIENT_PRP_CODE;
    }

    public BigDecimal getRN_POL_CLIENT_PRP_CODE() {
        return RN_POL_CLIENT_PRP_CODE;
    }

    public void setRN_POL_SAVINGS_RIDER(String RN_POL_SAVINGS_RIDER) {
        this.RN_POL_SAVINGS_RIDER = RN_POL_SAVINGS_RIDER;
    }

    public String getRN_POL_SAVINGS_RIDER() {
        return RN_POL_SAVINGS_RIDER;
    }

    public void setRN_POL_BRA_CODE(BigDecimal RN_POL_BRA_CODE) {
        this.RN_POL_BRA_CODE = RN_POL_BRA_CODE;
    }

    public BigDecimal getRN_POL_BRA_CODE() {
        return RN_POL_BRA_CODE;
    }

    public void setRN_ENDR_RENEWAL_DATE(Date RN_ENDR_RENEWAL_DATE) {
        this.RN_ENDR_RENEWAL_DATE = RN_ENDR_RENEWAL_DATE;
    }

    public Date getRN_ENDR_RENEWAL_DATE() {
        return RN_ENDR_RENEWAL_DATE;
    }

    public void setRN_ENDR_CODE(BigDecimal RN_ENDR_CODE) {
        this.RN_ENDR_CODE = RN_ENDR_CODE;
    }

    public BigDecimal getRN_ENDR_CODE() {
        return RN_ENDR_CODE;
    }

    public void setENDR_DURATION_TYPE(String ENDR_DURATION_TYPE) {
        this.ENDR_DURATION_TYPE = ENDR_DURATION_TYPE;
    }

    public String getENDR_DURATION_TYPE() {
        return ENDR_DURATION_TYPE;
    }

    public void setRN_CLIENT(String RN_CLIENT) {
        this.RN_CLIENT = RN_CLIENT;
    }

    public String getRN_CLIENT() {
        return RN_CLIENT;
    }

    public void setRN_BRANCH_NAME(String RN_BRANCH_NAME) {
        this.RN_BRANCH_NAME = RN_BRANCH_NAME;
    }

    public String getRN_BRANCH_NAME() {
        return RN_BRANCH_NAME;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean getSelected() {
        return selected;
    }

    public void setRN_POL_RENEWAL_AREA_STATUS(String RN_POL_RENEWAL_AREA_STATUS) {
        this.RN_POL_RENEWAL_AREA_STATUS = RN_POL_RENEWAL_AREA_STATUS;
    }

    public String getRN_POL_RENEWAL_AREA_STATUS() {
        return RN_POL_RENEWAL_AREA_STATUS;
    }

    public void setRN_PRP_CLNT_CODE(BigDecimal RN_PRP_CLNT_CODE) {
        this.RN_PRP_CLNT_CODE = RN_PRP_CLNT_CODE;
    }

    public BigDecimal getRN_PRP_CLNT_CODE() {
        return RN_PRP_CLNT_CODE;
    }

    public void setRN_POL_UMBRELLA(String RN_POL_UMBRELLA) {
        this.RN_POL_UMBRELLA = RN_POL_UMBRELLA;
    }

    public String getRN_POL_UMBRELLA() {
        return RN_POL_UMBRELLA;
    }
}
