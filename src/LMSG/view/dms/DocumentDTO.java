package LMSG.view.dms;

import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

public class DocumentDTO {
    private String versionLabel;
    private String docType;
    private String modifiedBy;
    private String docComments;
    private String data;
    private String docAuditUser;
    private String folders;
    private String dateReceived;
    private String docCommentDate;
    private String actualName;
    private String id;
    private String errMessage;
    private String clientName;
    private String name;
    private String dateCreated;
    private String policyNo;
    private String claimNo;
    private String mimeType;
    private boolean selectDoc;
    private boolean selectFinanceDoc;
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);

    public void setVersionLabel(String versionLabel) {
        this.versionLabel = versionLabel;
    }

    public String getVersionLabel() {
        return this.versionLabel;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getDocType() {
        return this.docType;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getModifiedBy() {
        return this.modifiedBy;
    }

    public void setDocComments(String docComments) {
        this.docComments = docComments;
    }

    public String getDocComments() {
        return this.docComments;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return this.data;
    }

    public void setDocAuditUser(String docAuditUser) {
        this.docAuditUser = docAuditUser;
    }

    public String getDocAuditUser() {
        return this.docAuditUser;
    }

    public void setFolders(String folders) {
        this.folders = folders;
    }

    public String getFolders() {
        return this.folders;
    }

    public void setDateReceived(String dateReceived) {
        this.dateReceived = dateReceived;
    }

    public String getDateReceived() {
        return this.dateReceived;
    }

    public void setDocCommentDate(String docCommentDate) {
        this.docCommentDate = docCommentDate;
    }

    public String getDocCommentDate() {
        return this.docCommentDate;
    }

    public void setActualName(String actualName) {
        this.actualName = actualName;
    }

    public String getActualName() {
        return this.actualName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }

    public String getErrMessage() {
        return this.errMessage;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientName() {
        return this.clientName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateCreated() {
        return this.dateCreated;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getPolicyNo() {
        return this.policyNo;
    }

    public void setClaimNo(String claimNo) {
        this.claimNo = claimNo;
    }

    public String getClaimNo() {
        return this.claimNo;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public void setSelectDoc(boolean selectDoc) {
        this.selectDoc = selectDoc;
    }

    public boolean isSelectDoc() {
        return this.selectDoc;
    }

    public void setSelectFinanceDoc(boolean selectFinanceDoc) {
        this.selectFinanceDoc = selectFinanceDoc;
    }

    public boolean isSelectFinanceDoc() {
     return this.selectFinanceDoc;
    }
}
