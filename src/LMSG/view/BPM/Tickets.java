package LMSG.view.BPM;

import java.math.BigDecimal;

import java.util.Date;

public class Tickets {
    public Tickets() {
        super();
    }
    
  private String client;
  private BigDecimal quoCode;
  private String quoNo;
  
  private String TaskName;
  
  private BigDecimal ENDR_CODE;
  private BigDecimal ENDR_POL_CODE;
  private String ENDR_POL_POLICY_NO;
  private String BTR_TRANS_TYPE;
  private Date ENDR_EFFECTIVE_DATE;
  private String CLIENT;
  private String BTR_TRANS_CODE;
  
  private Date QUO_EFFECTIVE_DATE;
  
  private BigDecimal PRP_CLNT_CODE;
  private BigDecimal ENDR_LTR_TRANS_NO; 
  private String POL_PROD_TYPE;

    public void setClient(String client) {
        this.client = client;
    }

    public String getClient() {
        return client;
    }

    public void setQuoCode(BigDecimal quoCode) {
        this.quoCode = quoCode;
    }

    public BigDecimal getQuoCode() {
        return quoCode;
    }

    public void setQuoNo(String quoNo) {
        this.quoNo = quoNo;
    }

    public String getQuoNo() {
        return quoNo;
    }

    public void setENDR_CODE(BigDecimal ENDR_CODE) {
        this.ENDR_CODE = ENDR_CODE;
    }

    public BigDecimal getENDR_CODE() {
        return ENDR_CODE;
    }

    public void setENDR_POL_CODE(BigDecimal ENDR_POL_CODE) {
        this.ENDR_POL_CODE = ENDR_POL_CODE;
    }

    public BigDecimal getENDR_POL_CODE() {
        return ENDR_POL_CODE;
    }

    public void setENDR_POL_POLICY_NO(String ENDR_POL_POLICY_NO) {
        this.ENDR_POL_POLICY_NO = ENDR_POL_POLICY_NO;
    }

    public String getENDR_POL_POLICY_NO() {
        return ENDR_POL_POLICY_NO;
    }

    public void setBTR_TRANS_TYPE(String BTR_TRANS_TYPE) {
        this.BTR_TRANS_TYPE = BTR_TRANS_TYPE;
    }

    public String getBTR_TRANS_TYPE() {
        return BTR_TRANS_TYPE;
    }

    public void setENDR_EFFECTIVE_DATE(Date ENDR_EFFECTIVE_DATE) {
        this.ENDR_EFFECTIVE_DATE = ENDR_EFFECTIVE_DATE;
    }

    public Date getENDR_EFFECTIVE_DATE() {
        return ENDR_EFFECTIVE_DATE;
    }

    public void setCLIENT(String CLIENT) {
        this.CLIENT = CLIENT;
    }

    public String getCLIENT() {
        return CLIENT;
    }

    public void setQUO_EFFECTIVE_DATE(Date QUO_EFFECTIVE_DATE) {
        this.QUO_EFFECTIVE_DATE = QUO_EFFECTIVE_DATE;
    }

    public Date getQUO_EFFECTIVE_DATE() {
        return QUO_EFFECTIVE_DATE;
    }

    public void setTaskName(String TaskName) {
        this.TaskName = TaskName;
    }

    public String getTaskName() {
        return TaskName;
    }

    public void setBTR_TRANS_CODE(String BTR_TRANS_CODE) {
        this.BTR_TRANS_CODE = BTR_TRANS_CODE;
    }

    public String getBTR_TRANS_CODE() {
        return BTR_TRANS_CODE;
    }

    public void setPRP_CLNT_CODE(BigDecimal PRP_CLNT_CODE) {
        this.PRP_CLNT_CODE = PRP_CLNT_CODE;
    }

    public BigDecimal getPRP_CLNT_CODE() {
        return PRP_CLNT_CODE;
    }

    public void setENDR_LTR_TRANS_NO(BigDecimal ENDR_LTR_TRANS_NO) {
        this.ENDR_LTR_TRANS_NO = ENDR_LTR_TRANS_NO;
    }

    public BigDecimal getENDR_LTR_TRANS_NO() {
        return ENDR_LTR_TRANS_NO;
    }

    public void setPOL_PROD_TYPE(String POL_PROD_TYPE) {
        this.POL_PROD_TYPE = POL_PROD_TYPE;
    }

    public String getPOL_PROD_TYPE() {
        return POL_PROD_TYPE;
    }
}
