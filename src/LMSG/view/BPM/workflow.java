package LMSG.view.BPM;

import java.math.BigDecimal;

import java.util.Date;

import LMSG.view.Base.LOVCC;

public class workflow {
 
 private String taskID;
 private String taskActivityName;
 private String taskAssignee;
 private Date taskDuedate;
 private Date taskCreateDate;
 
 private BigDecimal TCKT_CODE;
 private String USRSYSTEM;
 private String SYSMODULE;
 private BigDecimal TCKT_CLNT_CODE;
 private String CLIENT;
 private BigDecimal TCKT_AGN_CODE;
 private String AGENT;
 private BigDecimal TCKT_POL_CODE;
 private String TCKT_POL_NO;
 private String TCKT_CLM_NO;
 private BigDecimal TCKT_QUOT_CODE;
 private String QUO_NO;
 private String TCKT_BY;
 private Date TCKT_DATE;
 private String TCKT_PROCESS_ID;
 private String TCKT_SYS_MODULE_CODE;
 private BigDecimal TCKT_ENDR_CODE;
 private String TCKT_PROD_TYPE;
 private String TCKT_TO;
 private String TCKT_REMARKS;
 private String TCKT_NAME;
 private Date TCKT_DUE_DATE;
 private String TCKT_CDE;
 private String TCKT_ENDORSEMENT;
 private String TCKT_REF_NO;
 
 //Applicable Users
 private BigDecimal TaskUserID;
 private String TaskUserShtDesc;
 private String TaskUserDesc;
 

    public void setTaskID(String taskID) {
        this.taskID = taskID;
    }

    public String getTaskID() {
        return taskID;
    }

    public void setTaskActivityName(String taskActivityName) {
        this.taskActivityName = taskActivityName;
    }

    public String getTaskActivityName() {
        return taskActivityName;
    }

    public void setTaskAssignee(String taskAssignee) {
        this.taskAssignee = taskAssignee;
    }

    public String getTaskAssignee() {
        return taskAssignee;
    }

    public void setTaskDuedate(Date taskDuedate) {
        this.taskDuedate = taskDuedate;
    }

    public Date getTaskDuedate() {
        return taskDuedate;
    }

    public void setTaskCreateDate(Date taskCreateDate) {
        this.taskCreateDate = taskCreateDate;
    }

    public Date getTaskCreateDate() {
        return taskCreateDate;
    }

    public void setTCKT_CODE(BigDecimal TCKT_CODE) {
        this.TCKT_CODE = TCKT_CODE;
    }

    public BigDecimal getTCKT_CODE() {
        return TCKT_CODE;
    }

    public void setUSRSYSTEM(String USRSYSTEM) {
        this.USRSYSTEM = USRSYSTEM;
    }

    public String getUSRSYSTEM() {
        return USRSYSTEM;
    }

    public void setSYSMODULE(String SYSMODULE) {
        this.SYSMODULE = SYSMODULE;
    }

    public String getSYSMODULE() {
        return SYSMODULE;
    }

    public void setTCKT_CLNT_CODE(BigDecimal TCKT_CLNT_CODE) {
        this.TCKT_CLNT_CODE = TCKT_CLNT_CODE;
    }

    public BigDecimal getTCKT_CLNT_CODE() {
        return TCKT_CLNT_CODE;
    }

    public void setCLIENT(String CLIENT) {
        this.CLIENT = CLIENT;
    }

    public String getCLIENT() {
        return CLIENT;
    }

    public void setTCKT_AGN_CODE(BigDecimal TCKT_AGN_CODE) {
        this.TCKT_AGN_CODE = TCKT_AGN_CODE;
    }

    public BigDecimal getTCKT_AGN_CODE() {
        return TCKT_AGN_CODE;
    }

    public void setAGENT(String AGENT) {
        this.AGENT = AGENT;
    }

    public String getAGENT() {
        return AGENT;
    }

    public void setTCKT_POL_CODE(BigDecimal TCKT_POL_CODE) {
        this.TCKT_POL_CODE = TCKT_POL_CODE;
    }

    public BigDecimal getTCKT_POL_CODE() {
        return TCKT_POL_CODE;
    }

    public void setTCKT_POL_NO(String TCKT_POL_NO) {
        this.TCKT_POL_NO = TCKT_POL_NO;
    }

    public String getTCKT_POL_NO() {
        return TCKT_POL_NO;
    }

    public void setTCKT_CLM_NO(String TCKT_CLM_NO) {
        this.TCKT_CLM_NO = TCKT_CLM_NO;
    }

    public String getTCKT_CLM_NO() {
        return TCKT_CLM_NO;
    }

    public void setTCKT_QUOT_CODE(BigDecimal TCKT_QUOT_CODE) {
        this.TCKT_QUOT_CODE = TCKT_QUOT_CODE;
    }

    public BigDecimal getTCKT_QUOT_CODE() {
        return TCKT_QUOT_CODE;
    }

    public void setQUO_NO(String QUO_NO) {
        this.QUO_NO = QUO_NO;
    }

    public String getQUO_NO() {
        return QUO_NO;
    }

    public void setTCKT_DATE(Date TCKT_DATE) {
        this.TCKT_DATE = TCKT_DATE;
    }

    public Date getTCKT_DATE() {
        return TCKT_DATE;
    }

    public void setTCKT_BY(String TCKT_BY) {
        this.TCKT_BY = TCKT_BY;
    }

    public String getTCKT_BY() {
        return TCKT_BY;
    }

    public void setTCKT_PROCESS_ID(String TCKT_PROCESS_ID) {
        this.TCKT_PROCESS_ID = TCKT_PROCESS_ID;
    }

    public String getTCKT_PROCESS_ID() {
        return TCKT_PROCESS_ID;
    }

    public void setTCKT_SYS_MODULE_CODE(String TCKT_SYS_MODULE_CODE) {
        this.TCKT_SYS_MODULE_CODE = TCKT_SYS_MODULE_CODE;
    }

    public String getTCKT_SYS_MODULE_CODE() {
        return TCKT_SYS_MODULE_CODE;
    }

    public void setTCKT_ENDR_CODE(BigDecimal TCKT_ENDR_CODE) {
        this.TCKT_ENDR_CODE = TCKT_ENDR_CODE;
    }

    public BigDecimal getTCKT_ENDR_CODE() {
        return TCKT_ENDR_CODE;
    }

    public void setTaskUserID(BigDecimal TaskUserID) {
        this.TaskUserID = TaskUserID;
    }

    public BigDecimal getTaskUserID() {
        return TaskUserID;
    }

    public void setTaskUserShtDesc(String TaskUserShtDesc) {
        this.TaskUserShtDesc = TaskUserShtDesc;
    }

    public String getTaskUserShtDesc() {
        return TaskUserShtDesc;
    }

    public void setTaskUserDesc(String TaskUserDesc) {
        this.TaskUserDesc = TaskUserDesc;
    }

    public String getTaskUserDesc() {
        return TaskUserDesc;
    }

    public void setTCKT_PROD_TYPE(String TCKT_PROD_TYPE) {
        this.TCKT_PROD_TYPE = TCKT_PROD_TYPE;
    }

    public String getTCKT_PROD_TYPE() {
        return TCKT_PROD_TYPE;
    }

    public void setTCKT_TO(String TCKT_TO) {
        this.TCKT_TO = TCKT_TO;
    }

    public String getTCKT_TO() {
        return TCKT_TO;
    }

    public void setTCKT_REMARKS(String TCKT_REMARKS) {
        this.TCKT_REMARKS = TCKT_REMARKS;
    }

    public String getTCKT_REMARKS() {
        return TCKT_REMARKS;
    }

    public void setTCKT_NAME(String TCKT_NAME) {
        this.TCKT_NAME = TCKT_NAME;
    }

    public String getTCKT_NAME() {
        return TCKT_NAME;
    }

    public void setTCKT_DUE_DATE(Date TCKT_DUE_DATE) {
        this.TCKT_DUE_DATE = TCKT_DUE_DATE;
    }

    public Date getTCKT_DUE_DATE() {
        return TCKT_DUE_DATE;
    }

    public void setTCKT_CDE(String TCKT_CDE) {
        this.TCKT_CDE = TCKT_CDE;
    }

    public String getTCKT_CDE() {
        return TCKT_CDE;
    }

    public void setTCKT_ENDORSEMENT(String TCKT_ENDORSEMENT) {
        this.TCKT_ENDORSEMENT = TCKT_ENDORSEMENT;
    }

    public String getTCKT_ENDORSEMENT() {
        return TCKT_ENDORSEMENT;
    }

    public void setTCKT_REF_NO(String TCKT_REF_NO) {
        this.TCKT_REF_NO = TCKT_REF_NO;
    }

    public String getTCKT_REF_NO() {
        return TCKT_REF_NO;
    }
}
