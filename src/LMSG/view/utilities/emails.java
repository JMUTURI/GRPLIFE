package LMSG.view.utilities;

import java.math.BigDecimal;

public class emails {
    public emails() {
        super();
    }  
    //Systems 
    private BigDecimal SYS_CODE;
    private String SYS_SHT_DESC;
    private String SYS_NAME;
    
    //email Clients
    private BigDecimal CLNT_CODE;
    private String CLNT_SHT_DESC;
    private String CLNT_NAME;
    private String CLNT_OTHER_NAMES;
    private String NAME;
    
    //email Agents 
    private BigDecimal AGN_CODE;
    private String  AGN_SHT_DESC;
    private String AGN_NAME;
    
    //SMS Quotations
    private BigDecimal QUOT_CODE;
    private String QUOT_NO;
    
    //SMS Agents
    private BigDecimal POL_BATCH_NO;
    private String POL_POLICY_NO;
    
    //Claims
    private String cmb_claim_no;

    public void setCLNT_CODE(BigDecimal CLNT_CODE) {
        this.CLNT_CODE = CLNT_CODE;
    }

    public BigDecimal getCLNT_CODE() {
        return CLNT_CODE;
    }

    public void setCLNT_SHT_DESC(String CLNT_SHT_DESC) {
        this.CLNT_SHT_DESC = CLNT_SHT_DESC;
    }

    public String getCLNT_SHT_DESC() {
        return CLNT_SHT_DESC;
    }

    public void setCLNT_NAME(String CLNT_NAME) {
        this.CLNT_NAME = CLNT_NAME;
    }

    public String getCLNT_NAME() {
        return CLNT_NAME;
    }

    public void setCLNT_OTHER_NAMES(String CLNT_OTHER_NAMES) {
        this.CLNT_OTHER_NAMES = CLNT_OTHER_NAMES;
    }

    public String getCLNT_OTHER_NAMES() {
        return CLNT_OTHER_NAMES;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getNAME() {
        return NAME;
    }

    public void setAGN_CODE(BigDecimal AGN_CODE) {
        this.AGN_CODE = AGN_CODE;
    }

    public BigDecimal getAGN_CODE() {
        return AGN_CODE;
    }

    public void setAGN_SHT_DESC(String AGN_SHT_DESC) {
        this.AGN_SHT_DESC = AGN_SHT_DESC;
    }

    public String getAGN_SHT_DESC() {
        return AGN_SHT_DESC;
    }

    public void setAGN_NAME(String AGN_NAME) {
        this.AGN_NAME = AGN_NAME;
    }

    public String getAGN_NAME() {
        return AGN_NAME;
    }

    public void setQUOT_CODE(BigDecimal QUOT_CODE) {
        this.QUOT_CODE = QUOT_CODE;
    }

    public BigDecimal getQUOT_CODE() {
        return QUOT_CODE;
    }

    public void setQUOT_NO(String QUOT_NO) {
        this.QUOT_NO = QUOT_NO;
    }

    public String getQUOT_NO() {
        return QUOT_NO;
    }

    public void setPOL_BATCH_NO(BigDecimal POL_BATCH_NO) {
        this.POL_BATCH_NO = POL_BATCH_NO;
    }

    public BigDecimal getPOL_BATCH_NO() {
        return POL_BATCH_NO;
    }

    public void setPOL_POLICY_NO(String POL_POLICY_NO) {
        this.POL_POLICY_NO = POL_POLICY_NO;
    }

    public String getPOL_POLICY_NO() {
        return POL_POLICY_NO;
    }

    public void setCmb_claim_no(String cmb_claim_no) {
        this.cmb_claim_no = cmb_claim_no;
    }

    public String getCmb_claim_no() {
        return cmb_claim_no;
    }

    public void setSYS_CODE(BigDecimal SYS_CODE) {
        this.SYS_CODE = SYS_CODE;
    }

    public BigDecimal getSYS_CODE() {
        return SYS_CODE;
    }

    public void setSYS_SHT_DESC(String SYS_SHT_DESC) {
        this.SYS_SHT_DESC = SYS_SHT_DESC;
    }

    public String getSYS_SHT_DESC() {
        return SYS_SHT_DESC;
    }

    public void setSYS_NAME(String SYS_NAME) {
        this.SYS_NAME = SYS_NAME;
    }

    public String getSYS_NAME() {
        return SYS_NAME;
    }
}
