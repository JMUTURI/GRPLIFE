package LMSG.view.WebServices;

import java.math.BigDecimal;

public class BPMParams {
  private String taskID;
    private int sysCode;
    private String currentStatus;
    private BigDecimal agnCode;
    private BigDecimal policyCode;
    private String policyNumber;
    private String claimNo;
    private BigDecimal quoteCode;
    private String username;
    private String workflowID;
    private String quotationNo;
    private BigDecimal endorsementCode;
    private String productType;
    private String taskAssignee;
    private String ticketRemarks;
    private String endorsement;
    private BigDecimal transactionNumber;
    private BigDecimal prpCode;
    private BigDecimal clientCode;
    public BPMParams() {
        super();
    }

    public void setTaskID(String taskID) {
        this.taskID = taskID;
    }

    public String getTaskID() {
        return taskID;
    }

    public void setSysCode(int sysCode) {
        this.sysCode = sysCode;
    }

    public int getSysCode() {
        return sysCode;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setAgnCode(BigDecimal agnCode) {
        this.agnCode = agnCode;
    }

    public BigDecimal getAgnCode() {
        return agnCode;
    }

    public void setPolicyCode(BigDecimal policyCode) {
        this.policyCode = policyCode;
    }

    public BigDecimal getPolicyCode() {
        return policyCode;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setClaimNo(String claimNo) {
        this.claimNo = claimNo;
    }

    public String getClaimNo() {
        return claimNo;
    }

    public void setQuoteCode(BigDecimal quoteCode) {
        this.quoteCode = quoteCode;
    }

    public BigDecimal getQuoteCode() {
        return quoteCode;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setWorkflowID(String workflowID) {
        this.workflowID = workflowID;
    }

    public String getWorkflowID() {
        return workflowID;
    }

    public void setQuotationNo(String quotationNo) {
        this.quotationNo = quotationNo;
    }

    public String getQuotationNo() {
        return quotationNo;
    }

    public void setEndorsementCode(BigDecimal endorsementCode) {
        this.endorsementCode = endorsementCode;
    }

    public BigDecimal getEndorsementCode() {
        return endorsementCode;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductType() {
        return productType;
    }

    public void setTaskAssignee(String taskAssignee) {
        this.taskAssignee = taskAssignee;
    }

    public String getTaskAssignee() {
        return taskAssignee;
    }

    public void setTicketRemarks(String ticketRemarks) {
        this.ticketRemarks = ticketRemarks;
    }

    public String getTicketRemarks() {
        return ticketRemarks;
    }

    public void setEndorsement(String endorsement) {
        this.endorsement = endorsement;
    }

    public String getEndorsement() {
        return endorsement;
    }

    public void setTransactionNumber(BigDecimal transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public BigDecimal getTransactionNumber() {
        return transactionNumber;
    }

    public void setPrpCode(BigDecimal prpCode) {
        this.prpCode = prpCode;
    }

    public BigDecimal getPrpCode() {
        return prpCode;
    }

    public void setClientCode(BigDecimal clientCode) {
        this.clientCode = clientCode;
    }

    public BigDecimal getClientCode() {
        return clientCode;
    }
}
