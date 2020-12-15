package LMSG.view.BPM;

import LMSG.view.Base.ADFUtils;
import LMSG.view.Base.GlobalCC;

import LMSG.view.connect.DBConnector;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.util.Iterator;
import java.util.List;

import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.FacesContext;

import javax.faces.event.ValueChangeEvent;

import javax.servlet.http.HttpSession;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.layout.RichPanelBox;
import oracle.adf.view.rich.component.rich.output.RichOutputLabel;
import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.Key;
import oracle.jbo.Row;

import oracle.jdbc.OracleTypes;

import org.apache.myfaces.trinidad.model.RowKeySet;

public class TicketProcessing {
    private RichTable productsTable;
    private RichInputText policyDesc;
    private RichInputText prodDesc;
    private RichInputText quoteDesc;
    private RichTable quotationsTable;
    private RichTable policiesTable;
    private RichSelectOneChoice systemModule;
    private RichOutputLabel quoteLabel;
    private HtmlPanelGrid quotePanel;
    private RichOutputLabel policyLabel;
    private HtmlPanelGrid policyPanel;
    private RichPanelBox attachTicketPanel;
    private RichSelectOneChoice activity;
    private RichOutputLabel label1;
    private RichOutputText output1;
    private RichOutputLabel label2;
    private RichOutputText output2;
    private RichOutputLabel label3;
    private RichOutputText output3;
    private RichOutputLabel label4;
    private RichOutputText output4;
    private RichTable tasksTable;
    private RichTable usersTable;
    private RichInputText taskDesc;
    private RichInputText usersDesc;
    private RichTable policiesLOV;
    private RichInputText policiesDesc;
    private RichOutputLabel clmPolLabel;
    private HtmlPanelGrid clmPolPanel;
    private RichOutputLabel clmLabel;
    private HtmlPanelGrid clmPanel;
    private RichOutputLabel productLabel;
    private HtmlPanelGrid productPanel;
    private RichTable claimsLOV;
    private RichInputText claimNoDesc;

    public TicketProcessing() {
        super();
    }

    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);

    public String findProductSelected() {
        try {

            DCIteratorBinding dciter =
                ADFUtils.findIterator("findProductsIterator");
            RowKeySet set = productsTable.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                session.setAttribute("ProductCode",
                                     r.getAttribute("prodCode"));
                prodDesc.setValue(r.getAttribute("prodDesc"));

                session.setAttribute("policyCode", null);
                policyDesc.setValue(null);
                session.setAttribute("QuoteCode", null);
                quoteDesc.setValue(null);

                AdfFacesContext.getCurrentInstance().addPartialTarget(prodDesc);
                AdfFacesContext.getCurrentInstance().addPartialTarget(policyDesc);
                AdfFacesContext.getCurrentInstance().addPartialTarget(quoteDesc);

                ADFUtils.findIterator("findQuotationIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(quotationsTable);

                ADFUtils.findIterator("findPolicyTransactionsIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(policiesTable);

            }

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String findQuotationSelected() {
        try {

            DCIteratorBinding dciter =
                ADFUtils.findIterator("findQuotationIterator");
            RowKeySet set = quotationsTable.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                session.setAttribute("QuoteCode", r.getAttribute("quoCode"));
                session.setAttribute("QuotationNo", r.getAttribute("quoNo"));
                session.setAttribute("ProcessShtDesc", "QUOT");
                quoteDesc.setValue(r.getAttribute("quoNo"));


                label1.setValue("Quotation No:");
                output1.setValue(r.getAttribute("quoNo"));
                label2.setValue("Effective Date:");
                output2.setValue(r.getAttribute("QUO_EFFECTIVE_DATE"));
                label3.setValue("Client:");
                output3.setValue(r.getAttribute("client"));
                label4.setRendered(false);
                output4.setRendered(false);

                attachTicketPanel.setRendered(false);

            }

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String findPolicySelected() {
        try {

            DCIteratorBinding dciter =
                ADFUtils.findIterator("findPolicyTransactionsIterator");
            RowKeySet set = policiesTable.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                session.setAttribute("policyCode",
                                     r.getAttribute("ENDR_POL_CODE"));
                session.setAttribute("policyNumber",
                                     r.getAttribute("ENDR_POL_POLICY_NO"));
                session.setAttribute("endorsementCode",
                                     r.getAttribute("ENDR_CODE"));
                session.setAttribute("Endorsement",
                                     r.getAttribute("BTR_TRANS_CODE"));
                session.setAttribute("transactionNumber",
                                     r.getAttribute("ENDR_LTR_TRANS_NO"));
                session.setAttribute("ClientCode",
                                     r.getAttribute("PRP_CLNT_CODE"));
                session.setAttribute("productType",
                                     r.getAttribute("POL_PROD_TYPE"));


                String Process =
                    "UW" + (String)r.getAttribute("BTR_TRANS_CODE");
                session.setAttribute("ProcessShtDesc", Process);

                policyDesc.setValue(r.getAttribute("ENDR_POL_POLICY_NO"));

                label1.setValue("Policy No:");
                output1.setValue(r.getAttribute("ENDR_POL_POLICY_NO"));
                label2.setValue("Effective Date:");
                output2.setValue(r.getAttribute("ENDR_EFFECTIVE_DATE"));
                label3.setValue("Client:");
                output3.setValue(r.getAttribute("CLIENT"));
                label4.setValue("Transaction:");
                output4.setValue(r.getAttribute("BTR_TRANS_TYPE"));
                label4.setRendered(true);
                output4.setRendered(true);

                attachTicketPanel.setRendered(false);

            }

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String NextTransition() {

        if (activity.getValue() == null) {
            GlobalCC.INFORMATIONREPORTING("Select An Activity");
            return null;
        }
        if (session.getAttribute("TicketModule") == null) {
            GlobalCC.INFORMATIONREPORTING("Select An System Module");
            return null;
        }

        String Module = (String)session.getAttribute("TicketModule");
        if (Module.equalsIgnoreCase("P")) {
            if (session.getAttribute("policyCode") == null) {
                GlobalCC.INFORMATIONREPORTING("Select A Policy");
                return null;
            }
        } else if (Module.equalsIgnoreCase("E")) {
            if (session.getAttribute("policyCode") == null) {
                GlobalCC.INFORMATIONREPORTING("Select A Policy");
                return null;
            }
        } else if (Module.equalsIgnoreCase("Q")) {
            if (session.getAttribute("QuoteCode") == null) {
                GlobalCC.INFORMATIONREPORTING("Select A Quotation");
                return null;
            }
        } else if (Module.equalsIgnoreCase("C")) {
            if (session.getAttribute("ClaimNo") == null) {
                GlobalCC.INFORMATIONREPORTING("Select A Claim.");
                return null;
            }
        }

        ADFUtils.findIterator("ReadJPDLXmlIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(tasksTable);

        ADFUtils.findIterator("FindSystemUsersIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(usersTable);

        session.setAttribute("taskName", null);
        session.setAttribute("TaskAssignee", null);

        attachTicketPanel.setRendered(true);
        return null;
    }

    public String findTaskSelected() {
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("ReadJPDLXmlIterator");
            RowKeySet set = tasksTable.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));

                Row r = dciter.getCurrentRow();
                session.setAttribute("taskName", r.getAttribute("taskName"));
                taskDesc.setValue(r.getAttribute("taskName"));
            }

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String findUserSelected() {
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("FindSystemUsersIterator");
            RowKeySet set = usersTable.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));

                Row r = dciter.getCurrentRow();
                session.setAttribute("TaskAssignee",
                                     r.getAttribute("USR_USERNAME"));
                usersDesc.setValue(r.getAttribute("USR_USERNAME"));

            }

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String AttachTicket() {

        try {
            String CurrentTask = null;
            boolean status = false;

            if (session.getAttribute("taskName") == null) {
                GlobalCC.INFORMATIONREPORTING("Select A Task");
                return null;
            }

            if (session.getAttribute("TaskAssignee") == null) {
                GlobalCC.INFORMATIONREPORTING("Select A User to Assign");
                return null;
            }

            String Module = (String)session.getAttribute("TicketModule");

            session.setAttribute("CurrentStatus", Module);

            if (Module.equalsIgnoreCase("P") || Module.equalsIgnoreCase("E")) {
                status =
                        checkTicketIfExists(session.getAttribute("policyCode").toString(),
                                            Module);
                if (status) {
                    GlobalCC.INFORMATIONREPORTING("The Policy Selected has another Ticket Attached to it");
                    return null;
                }
                session.setAttribute("ProcessAreaShtDesc", "ACCS");
                session.setAttribute("ProcessSubAShtDesc", "ACCS");
            } else if (Module.equalsIgnoreCase("Q")) {
                status =
                        checkTicketIfExists(session.getAttribute("QuoteCode").toString(),
                                            Module);
                if (status) {
                    GlobalCC.INFORMATIONREPORTING("The Quotation Selected has another Ticket Attached to it");
                    return null;
                }
                session.setAttribute("ProcessAreaShtDesc", "DENTR");
                session.setAttribute("ProcessSubAShtDesc", "QUOTD");
            } else if (Module.equalsIgnoreCase("C")) {
                status =
                        checkTicketIfExists(session.getAttribute("ClaimNo").toString(),
                                            Module);
                if (status) {
                    GlobalCC.INFORMATIONREPORTING("The Claim Selected has another Ticket Attached to it");
                    return null;
                }
              this.session.setAttribute("ProcessShtDesc", "CLMS");
              this.session.setAttribute("ProcessAreaShtDesc", "ACCS");
              this.session.setAttribute("ProcessSubAShtDesc", "ACCS");
            }

            //We will need to create a For loop, to loop thru the nodes and return a Result...
            DCIteratorBinding dciter =
                ADFUtils.findIterator("ReadJPDLXmlIterator");
            int rowCount = tasksTable.getRowCount();

            workflowProcessing wf = new workflowProcessing();

            if (rowCount == 0) {
                GlobalCC.INFORMATIONREPORTING("There are No Task Points for this Process Flow.");
                return null;
            }

            String TaskName = (String)session.getAttribute("taskName");

            session.setAttribute("ClientExists", "No");
            session.setAttribute("UWStart", "No");
            session.setAttribute("Credit", "No");
            session.setAttribute("NextTransition", "A");

            wf.FindProcessDetails();
            wf.CreateWorkflowInstance();

            if (session.getAttribute("workflowID") == null) {
                GlobalCC.INFORMATIONREPORTING("There was a Problem Encountered when initializing the Process Flow" +
                                              "Engine. Please Contact your Administrator.");
                return null;
            }

            for (int i = 0; i < rowCount; i++) {

                tasksTable.setRowIndex(i);
                List l = (List)tasksTable.getRowKey();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();
                CurrentTask = (String)r.getAttribute("taskName");

                if (TaskName.equalsIgnoreCase(CurrentTask)) {
                    break;
                } else {
                    wf.CompleteTask();
                }
            }
            GlobalCC.INFORMATIONREPORTING("A Ticket has Successfully been attached");

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public boolean checkTicketIfExists(String code, String level) {

        DBConnector myConn = new DBConnector();
        CallableStatement cst = null;
        try {
            Connection conn = myConn.getDatabaseConn();
            String msgQuery =
                "begin ? := TQC_WEB_CURSOR.check_ticket_status(?,?); end;";
            cst = conn.prepareCall(msgQuery);
            cst.setString(2, code);
            cst.registerOutParameter(1, OracleTypes.VARCHAR);
            cst.setString(3, level);
            cst.execute();
            if (cst.getString(1) == null ||
                cst.getString(1).equalsIgnoreCase("N")) {
                return false;
            }
            cst.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return true;
    }

    public String CancelTransaction() {
        attachTicketPanel.setRendered(false);
        return null;
    }

    public void setProductsTable(RichTable productsTable) {
        this.productsTable = productsTable;
    }

    public RichTable getProductsTable() {
        return productsTable;
    }

    public void setPolicyDesc(RichInputText policyDesc) {
        this.policyDesc = policyDesc;
    }

    public RichInputText getPolicyDesc() {
        return policyDesc;
    }

    public void setProdDesc(RichInputText prodDesc) {
        this.prodDesc = prodDesc;
    }

    public RichInputText getProdDesc() {
        return prodDesc;
    }

    public void setQuoteDesc(RichInputText quoteDesc) {
        this.quoteDesc = quoteDesc;
    }

    public RichInputText getQuoteDesc() {
        return quoteDesc;
    }

    public void setQuotationsTable(RichTable quotationsTable) {
        this.quotationsTable = quotationsTable;
    }

    public RichTable getQuotationsTable() {
        return quotationsTable;
    }

    public void setPoliciesTable(RichTable policiesTable) {
        this.policiesTable = policiesTable;
    }

    public RichTable getPoliciesTable() {
        return policiesTable;
    }

    public void setSystemModule(RichSelectOneChoice systemModule) {
        this.systemModule = systemModule;
    }

    public RichSelectOneChoice getSystemModule() {
        return systemModule;
    }

    public void SystemModuleListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if (valueChangeEvent.getOldValue() != valueChangeEvent.getNewValue()) {
            if (systemModule.getValue() == null) {
                session.setAttribute("TicketModule", null);
            } else if (systemModule.getValue().toString().equalsIgnoreCase("Q")) {
                session.setAttribute("TicketModule",
                                     (systemModule.getValue().toString()));
                quoteLabel.setRendered(true);
                quotePanel.setRendered(true);
                policyLabel.setRendered(false);
                policyPanel.setRendered(false);
                clmPolLabel.setRendered(false);
                clmPolPanel.setRendered(false);
                clmLabel.setRendered(false);
                clmPanel.setRendered(false);
                productLabel.setRendered(true);
                productPanel.setRendered(true);
            } else if (systemModule.getValue().toString().equalsIgnoreCase("P")) {
                session.setAttribute("TicketModule",
                                     (systemModule.getValue().toString()));
                quoteLabel.setRendered(false);
                quotePanel.setRendered(false);
                policyLabel.setRendered(true);
                policyPanel.setRendered(true);
                clmPolLabel.setRendered(false);
                clmPolPanel.setRendered(false);
                clmLabel.setRendered(false);
                clmPanel.setRendered(false);
                productLabel.setRendered(true);
                productPanel.setRendered(true);
            } else if (systemModule.getValue().toString().equalsIgnoreCase("E")) {
                session.setAttribute("TicketModule",
                                     (systemModule.getValue().toString()));
                quoteLabel.setRendered(false);
                quotePanel.setRendered(false);
                policyLabel.setRendered(true);
                policyPanel.setRendered(true);
                clmPolLabel.setRendered(false);
                clmPolPanel.setRendered(false);
                clmLabel.setRendered(false);
                clmPanel.setRendered(false);
                productLabel.setRendered(true);
                productPanel.setRendered(true);
            } else if (systemModule.getValue().toString().equalsIgnoreCase("C")) {
                session.setAttribute("TicketModule",
                                     (systemModule.getValue().toString()));
                quoteLabel.setRendered(false);
                quotePanel.setRendered(false);
                policyLabel.setRendered(false);
                policyPanel.setRendered(false);
                clmPolLabel.setRendered(true);
                clmPolPanel.setRendered(true);
                clmLabel.setRendered(true);
                clmPanel.setRendered(true);
                productLabel.setRendered(false);
                productPanel.setRendered(false);
            }
        }
        session.setAttribute("ProductCode", null);
        prodDesc.setValue(null);
        AdfFacesContext.getCurrentInstance().addPartialTarget(quoteLabel);
        AdfFacesContext.getCurrentInstance().addPartialTarget(quotePanel);
        AdfFacesContext.getCurrentInstance().addPartialTarget(policyLabel);
        AdfFacesContext.getCurrentInstance().addPartialTarget(policyPanel);
        AdfFacesContext.getCurrentInstance().addPartialTarget(prodDesc);
        AdfFacesContext.getCurrentInstance().addPartialTarget(clmPolLabel);
        AdfFacesContext.getCurrentInstance().addPartialTarget(clmPolPanel);
        AdfFacesContext.getCurrentInstance().addPartialTarget(clmLabel);
        AdfFacesContext.getCurrentInstance().addPartialTarget(clmPanel);
        AdfFacesContext.getCurrentInstance().addPartialTarget(productLabel);
        AdfFacesContext.getCurrentInstance().addPartialTarget(productPanel);
        ResetVariables();

    }

    //Ticket saving method

    public String saveDmsDocuments(String docID, String user, String docType,
                                   String documentName) {

        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;

        try {

            String Updatewkflw =
                "BEGIN LMS_WEB_PKG_SETUP.create_dms_documents(?,?,?,?);END;";
            cst = conn.prepareCall(Updatewkflw);
            cst.setString(1, docID);
            cst.setString(2, user);
            cst.setString(3, docType);
            cst.setString(4, documentName);
            cst.execute();
            cst.close();
            conn.close();

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }


    public String ResetVariables() {

        session.setAttribute("policyCode", null);
        session.setAttribute("policyNumber", null);
        session.setAttribute("endorsementCode", null);
        session.setAttribute("Endorsement", null);
        session.setAttribute("transactionNumber", null);
        session.setAttribute("prpCode", null);
        session.setAttribute("productType", null);
        session.setAttribute("ProcessShtDesc", null);

        session.setAttribute("QuoteCode", null);
        session.setAttribute("QuotationNo", null);

        quoteDesc.setValue(null);
        policyDesc.setValue(null);
        AdfFacesContext.getCurrentInstance().addPartialTarget(quoteDesc);
        AdfFacesContext.getCurrentInstance().addPartialTarget(policyDesc);

        return null;
    }

    public void setQuoteLabel(RichOutputLabel quoteLabel) {
        this.quoteLabel = quoteLabel;
    }

    public RichOutputLabel getQuoteLabel() {
        return quoteLabel;
    }

    public void setQuotePanel(HtmlPanelGrid quotePanel) {
        this.quotePanel = quotePanel;
    }

    public HtmlPanelGrid getQuotePanel() {
        return quotePanel;
    }

    public void setPolicyLabel(RichOutputLabel policyLabel) {
        this.policyLabel = policyLabel;
    }

    public RichOutputLabel getPolicyLabel() {
        return policyLabel;
    }

    public void setPolicyPanel(HtmlPanelGrid policyPanel) {
        this.policyPanel = policyPanel;
    }

    public HtmlPanelGrid getPolicyPanel() {
        return policyPanel;
    }

    public void setAttachTicketPanel(RichPanelBox attachTicketPanel) {
        this.attachTicketPanel = attachTicketPanel;
    }

    public RichPanelBox getAttachTicketPanel() {
        return attachTicketPanel;
    }

    public void setActivity(RichSelectOneChoice activity) {
        this.activity = activity;
    }

    public RichSelectOneChoice getActivity() {
        return activity;
    }

    public void setLabel1(RichOutputLabel label1) {
        this.label1 = label1;
    }

    public RichOutputLabel getLabel1() {
        return label1;
    }

    public void setOutput1(RichOutputText output1) {
        this.output1 = output1;
    }

    public RichOutputText getOutput1() {
        return output1;
    }

    public void setLabel2(RichOutputLabel label2) {
        this.label2 = label2;
    }

    public RichOutputLabel getLabel2() {
        return label2;
    }

    public void setOutput2(RichOutputText output2) {
        this.output2 = output2;
    }

    public RichOutputText getOutput2() {
        return output2;
    }

    public void setLabel3(RichOutputLabel label3) {
        this.label3 = label3;
    }

    public RichOutputLabel getLabel3() {
        return label3;
    }

    public void setOutput3(RichOutputText output3) {
        this.output3 = output3;
    }

    public RichOutputText getOutput3() {
        return output3;
    }

    public void setLabel4(RichOutputLabel label4) {
        this.label4 = label4;
    }

    public RichOutputLabel getLabel4() {
        return label4;
    }

    public void setOutput4(RichOutputText output4) {
        this.output4 = output4;
    }

    public RichOutputText getOutput4() {
        return output4;
    }

    public void setTasksTable(RichTable tasksTable) {
        this.tasksTable = tasksTable;
    }

    public RichTable getTasksTable() {
        return tasksTable;
    }

    public void setUsersTable(RichTable usersTable) {
        this.usersTable = usersTable;
    }

    public RichTable getUsersTable() {
        return usersTable;
    }

    public void setTaskDesc(RichInputText taskDesc) {
        this.taskDesc = taskDesc;
    }

    public RichInputText getTaskDesc() {
        return taskDesc;
    }

    public void setUsersDesc(RichInputText usersDesc) {
        this.usersDesc = usersDesc;
    }

    public RichInputText getUsersDesc() {
        return usersDesc;
    }

    public void setPoliciesLOV(RichTable policiesLOV) {
        this.policiesLOV = policiesLOV;
    }

    public RichTable getPoliciesLOV() {
        return policiesLOV;
    }

    public void setPoliciesDesc(RichInputText policiesDesc) {
        this.policiesDesc = policiesDesc;
    }

    public RichInputText getPoliciesDesc() {
        return policiesDesc;
    }

    public String findPoliciesSelected() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindPoliciesIterator");


        RowKeySet set = this.policiesLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
            this.policiesDesc.setValue(r.getAttribute("POL_POLICY_NO"));

            this.session.setAttribute("policyCode",
                                      r.getAttribute("POL_CODE"));

            this.session.setAttribute("policyNumber",
                                      r.getAttribute("POL_POLICY_NO"));


            this.session.setAttribute("prpCode", r.getAttribute("prp_code"));
            this.session.setAttribute("ClientCode",
                                      r.getAttribute("prp_clnt_code"));
        }
        return null;
    }

    public void setClmPolLabel(RichOutputLabel clmPolLabel) {
        this.clmPolLabel = clmPolLabel;
    }

    public RichOutputLabel getClmPolLabel() {
        return clmPolLabel;
    }

    public void setClmPolPanel(HtmlPanelGrid clmPolPanel) {
        this.clmPolPanel = clmPolPanel;
    }

    public HtmlPanelGrid getClmPolPanel() {
        return clmPolPanel;
    }

    public void setClmLabel(RichOutputLabel clmLabel) {
        this.clmLabel = clmLabel;
    }

    public RichOutputLabel getClmLabel() {
        return clmLabel;
    }

    public void setClmPanel(HtmlPanelGrid clmPanel) {
        this.clmPanel = clmPanel;
    }

    public HtmlPanelGrid getClmPanel() {
        return clmPanel;
    }

    public void setProductLabel(RichOutputLabel productLabel) {
        this.productLabel = productLabel;
    }

    public RichOutputLabel getProductLabel() {
        return productLabel;
    }

    public void setProductPanel(HtmlPanelGrid productPanel) {
        this.productPanel = productPanel;
    }

    public HtmlPanelGrid getProductPanel() {
        return productPanel;
    }

    public void setClaimsLOV(RichTable claimsLOV) {
        this.claimsLOV = claimsLOV;
    }

    public RichTable getClaimsLOV() {
        return claimsLOV;
    }

    public String selectClaim() {
        // Add event code here...
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindClaimTransactionsIterator");


        RowKeySet set = this.claimsLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
            this.claimNoDesc.setValue(r.getAttribute("LTR_CLM_NO"));
            session.setAttribute("ClaimNo", r.getAttribute("LTR_CLM_NO"));
          session.setAttribute("ProcessShtDesc", "CLAIM");
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(claimNoDesc);
        return null;
    }

    public void setClaimNoDesc(RichInputText claimNoDesc) {
        this.claimNoDesc = claimNoDesc;
    }

    public RichInputText getClaimNoDesc() {
        return claimNoDesc;
    }
}
