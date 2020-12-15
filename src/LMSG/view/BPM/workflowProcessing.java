package LMSG.view.BPM;


import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.Connection;

import LMSG.view.ecm.EcmUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.sql.ResultSet;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.layout.RichPanelBox;
import oracle.adf.view.rich.component.rich.output.RichOutputText;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.Key;
import oracle.jbo.Row;

import oracle.jdbc.OracleTypes;

import org.apache.myfaces.trinidad.model.RowKeySet;

import org.jbpm.api.task.Task;

import LMSG.view.Base.ADFUtils;

import LMSG.view.Base.GlobalCC;
import LMSG.view.Base.LOVCC;

import LMSG.view.Correspondents.CorrespondenceManipulation;
import LMSG.view.connect.DBConnector;

import javax.faces.event.ValueChangeEvent;

import org.apache.chemistry.opencmis.client.api.Document;
import org.apache.chemistry.opencmis.client.api.Session;

import org.jbpm.pvm.internal.cfg.JbpmConfiguration;

public class workflowProcessing extends LOVCC {

    private RichOutputText taskName;
    private RichOutputText taskAssignee;
    private RichOutputText taskDueDate;
    private RichOutputText taskID;
    private RichTable ticketsLOV;


    private RichPanelBox reassignPanel;
    private RichInputText user;

    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    private RichTable allUsersLOV;
    private RichInputText allUsersDesc;
    private RichTable resultsLOV;
    private RichTable allUsers2LOV;
    private RichInputText ticketRemarks;
    private RichSelectOneChoice productCoverDropBox;
    private RichSelectOneChoice priorityLevel;

    public String CreateWorkflowInstance() {

        try {
            JbpmConfiguration pid = null;
            wfEngine wf = new wfEngine();
            //JBPMEngine test = new JBPMEngine();
            //Deploy the Workflow
            //wf.deployWorkflow((String)session.getAttribute("ProcessBPMDef") + ".jpdl.xml");

            //start the instance
            pid = wf.startWorkFlowInstance();

            //start workflow
            HashMap map = new HashMap();
            String Process = (String)session.getAttribute("ProcessShtDesc");
            String TaskAss = (String)session.getAttribute("TaskAssignee");
            String TransNext = (String)session.getAttribute("NextTransition");
            if (TransNext == null) {
                session.setAttribute("NextTransition", "A");
            }
            String ClientExists = (String)session.getAttribute("ClientExists");
            if (ClientExists == null) {
                session.setAttribute("content", "Yes");
            }

            if (Process.equalsIgnoreCase("QUOT")) {
                if (TaskAss == null) {
                    map.put("order", session.getAttribute("Username"));
                } else {
                    map.put("order", session.getAttribute("TaskAssignee"));
                }
                map.put("content", session.getAttribute("ClientExists"));
            } else if (Process.equalsIgnoreCase("UWNB")) {
                map.put("UWStart", session.getAttribute("UWStart"));
                map.put("Client", session.getAttribute("ClientExists"));
                if (TaskAss == null) {
                    map.put("order", session.getAttribute("Username"));
                } else {
                    map.put("order", session.getAttribute("TaskAssignee"));
                }
                map.put("Credit", session.getAttribute("Credit"));
                map.put("NextTrans", session.getAttribute("NextTransition"));
                if (session.getAttribute("riMedicals") == null) {
                    map.put("riMedicals", "N");
                } else {
                    map.put("riMedicals", session.getAttribute("riMedicals"));
                }
            } else {
                if (TaskAss == null) {
                    map.put("order", session.getAttribute("Username"));
                } else {
                    map.put("order", session.getAttribute("TaskAssignee"));
                }
                map.put("Credit", session.getAttribute("Credit"));
                map.put("NextTrans", session.getAttribute("NextTransition"));
                if (session.getAttribute("riMedicals") == null) {
                    map.put("riMedicals", "N");
                } else {
                    map.put("riMedicals", session.getAttribute("riMedicals"));
                }
                map.put("VoucherDecision",
                        session.getAttribute("VoucherDecision"));
                map.put("Transaction",
                        session.getAttribute("ClaimProcessTrans"));
            }
            String workflowID =
                wf.startWorkflow((String)session.getAttribute("ProcessBPMDef"),
                                 map);
            session.setAttribute("workflowID", workflowID);
            System.out.println("instance: " + workflowID);

            //Get Task List
            List<Task> Tasks = new ArrayList<Task>();
            Tasks = wf.findTasksForWorkflowPath(workflowID);
            int i = 0;
            for (Iterator iter = Tasks.iterator(); iter.hasNext(); ) {
                Task task = Tasks.get(i);
                //LOVCC.TaskID = task.getId();
                session.setAttribute("TaskID", task.getId());
                System.out.println(task.getId());
                //LOVCC.TaskActivityName = task.getActivityName();
                session.setAttribute("TaskActivityName",
                                     task.getActivityName());
                System.out.println(task.getActivityName());
                System.out.println(task.getAssignee());
                //System.out.println(task.getDuedate());
                //System.out.println((iter.next()));
                iter.next();
                i++;
            }

            UpdateWorkflowAttributes();
            wf.endWorkFlowInstance(pid);

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
            e.printStackTrace();
        }


        return null;
    }

    public String StartNewWorkflowInstance() {
        try {
            JbpmConfiguration pid = null;
            wfEngine wf = new wfEngine();
            pid = wf.startWorkFlowInstance();

            //To be fully Replaced with Decision Handlers
            HashMap map = new HashMap();
            map.put("DocsSubmitted", "Yes");
            map.put("clientDecision", "Accept");
            String workflowID =
                wf.startWorkflow((String)session.getAttribute("ProcessBPMDef"),
                                 map);
            session.setAttribute("workflowID", workflowID);

            System.out.println("instance: " + workflowID);

            //Get Task List
            List<Task> Tasks = new ArrayList<Task>();
            Tasks = wf.findTasksForWorkflowPath(workflowID);
            int i = 0;
            for (Iterator iter = Tasks.iterator(); iter.hasNext(); ) {
                Task task = Tasks.get(i);
                //LOVCC.TaskID = task.getId();
                session.setAttribute("TaskID", task.getId());
                System.out.println(task.getId());
                session.setAttribute("TaskActivityName",
                                     task.getActivityName());
                System.out.println(task.getActivityName());
                System.out.println(task.getAssignee());
                iter.next();
                i++;
            }
            wf.endWorkFlowInstance(pid);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String ReAssignTask() {
        try {
            wfEngine wf = new wfEngine();
            wf.AssignTask((String)session.getAttribute("TaskID"),
                          user.getValue().toString());

            String message = "Task Successfully ReAssigned";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          message,
                                                                          message));

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }


        return null;
    }

    public String CompleteTask() {

        try {
            String Taske = (String)session.getAttribute("TaskID");
            if (Taske == null) {
                return null;
            }
            wfEngine wf = new wfEngine();
            UpdateTaskAssignee();
            wf.CompleteTask((String)session.getAttribute("TaskID"));

            List<Task> Tasks2 = new ArrayList<Task>();
            Tasks2 =
                    wf.findTasksForWorkflowPath((String)session.getAttribute("workflowID"));
            System.out.println("Completing RI med " +
                               (String)session.getAttribute("RIMed") +
                               " The workflow Id is " +
                               (String)session.getAttribute("workflowID") +
                               " the task ID is " +
                               (String)session.getAttribute("TaskID"));
            int i = 0;
            for (Iterator iter = Tasks2.iterator(); iter.hasNext(); ) {
                Task task = Tasks2.get(i);
                //LOVCC.TaskID = task.getId();
                session.setAttribute("TaskID", task.getId());
                System.out.println(task.getId());
                //LOVCC.TaskActivityName = task.getActivityName();
                session.setAttribute("TaskActivityName",
                                     task.getActivityName());
                System.out.println("WORKFLOW TESTING" +
                                   task.getActivityName());
                System.out.println(task.getAssignee());
                //System.out.println(task.getDuedate());
                //System.out.println((iter.next()));
                iter.next();
                i++;
                System.out.println("Updating workflow attributes");
                UpdateWorkflowAttributes();
            }


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }


        return null;
    }

    public String findTicketSelected() {
        try {

            DCIteratorBinding dciter =
                ADFUtils.findIterator("findTicketsIterator");
            RowKeySet set = ticketsLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));


                Row r = dciter.getCurrentRow();

                //LOVCC.TaskID = (String)r.getAttribute("taskID");
                session.setAttribute("TaskID", r.getAttribute("taskID"));
                //taskselName= (String)r.getAttribute("taskActivityName");
                //taskselAssignee= (String)r.getAttribute("taskAssignee");
                //taskselDueDate=(Date)r.getAttribute("taskDuedate");
                //taskselID=(String)r.getAttribute("taskID");
                //taskselCreateDate=(Date)r.getAttribute("taskCreateDate");
                session.setAttribute("taskselName",
                                     r.getAttribute("taskActivityName"));
                session.setAttribute("TaskActivityName",
                                     r.getAttribute("taskActivityName"));
                session.setAttribute("taskselAssignee",
                                     r.getAttribute("taskAssignee"));
                session.setAttribute("taskselDueDate",
                                     r.getAttribute("taskDuedate"));
                session.setAttribute("taskselID", r.getAttribute("taskID"));
                session.setAttribute("taskselCreateDate",
                                     r.getAttribute("taskCreateDate"));

                GlobalCC.RedirectPage("/wfProcessing.jspx");

            }

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String UpdateWorkflowAttributes() {
        String Result = "F";
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        try {
            String TaskAss = (String)session.getAttribute("TaskAssignee");
            if (TaskAss == null) {
                session.setAttribute("TaskAssignee",
                                     session.getAttribute("Username"));
            }
            String Updatewkflw =
                "BEGIN Tqc_Web_Pkg.save_workflw_attributes(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);END;";

            cst = conn.prepareCall(Updatewkflw);
            cst.setString(1, (String)session.getAttribute("TaskID"));
            cst.setInt(2, (Integer)session.getAttribute("sysCode"));
            cst.setString(3, (String)session.getAttribute("CurrentStatus"));
            cst.setBigDecimal(4,
                              (BigDecimal)session.getAttribute("ClientCode")); //Client Code
            cst.setBigDecimal(5, (BigDecimal)session.getAttribute("agnCode"));
            cst.setBigDecimal(6,
                              (BigDecimal)session.getAttribute("policyCode"));
            cst.setString(7,
                          (String)session.getAttribute("policyNumber")); //Replace with Global Policy Number
            cst.setString(8, (String)session.getAttribute("ClaimNo"));
            cst.setBigDecimal(9,
                              (BigDecimal)session.getAttribute("QuoteCode"));
            cst.setString(10, (String)session.getAttribute("Username"));
            cst.setString(11, null);
            cst.setString(12, (String)session.getAttribute("workflowID"));
            cst.setString(13, (String)session.getAttribute("QuotationNo"));
            cst.setBigDecimal(14,
                              (BigDecimal)session.getAttribute("endorsementCode"));
            cst.setString(15, (String)session.getAttribute("productType"));
            cst.setString(16, (String)session.getAttribute("TaskAssignee"));
            cst.setString(17, (String)session.getAttribute("TicketRemarks"));
            cst.setString(18, (String)session.getAttribute("Endorsement"));
            cst.setBigDecimal(19,
                              (BigDecimal)session.getAttribute("transactionNumber"));
            cst.setBigDecimal(20,
                              (BigDecimal)session.getAttribute("prpCode")); //PRP Code...

            System.out.println("Done updating!");
            cst.execute();
            cst.close();
            conn.close();
            Result = "S";
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
        return Result;
    }

    public String ProcessTask() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        CallableStatement cst1 = null;

        try {
            String ScreenName;
            String Authorised = "VQ";


            session.setAttribute("editComponents", "N");


            String TaskScreen =
                "BEGIN Tqc_Web_Pkg.get_bpm_task_srn(?,?,?);END;";
            cst = conn.prepareCall(TaskScreen);
            cst.setString(1, (String)session.getAttribute("taskselName"));

            cst.registerOutParameter(2, OracleTypes.VARCHAR);
            cst.setBigDecimal(3, new BigDecimal(27));
            cst.execute();
            ScreenName = cst.getString(2);
            String Cursta = (String)session.getAttribute("CurrentStatus");
            System.out.println("The current status is " + Cursta);
            System.out.println("The current screen is " + ScreenName);
            if (ScreenName.equalsIgnoreCase("dmsDocView.jspx")) {
                Cursta = "DMS";
            }

            if (postUnderwritingReinsurance().equals("Y")) {
                session.setAttribute("postReinsure", "Y");
            } else {
                session.setAttribute("postReinsure", "N");
            }
            if (Cursta.equalsIgnoreCase("P")) {
                //LOVDAO.transType = "VQ";
                session.setAttribute("transType", "VQ");
                //underwritingPolicy.PageRender = 0;
                session.setAttribute("uwPageRender", 0);
                session.setAttribute("UWStart", "No");
                session.setAttribute("Credit", "No");
                session.setAttribute("ClientExists", "Yes");
                session.setAttribute("ProductCode", null);

                BigDecimal endrCode =
                    (BigDecimal)session.getAttribute("endorsementCode");
                if (endrCode != null) {
                    String auth =
                        "BEGIN LMS_WEB_CURSOR_GRP.get_pol_status(?,?,?);END;";
                    cst1 = conn.prepareCall(auth);
                    cst1.setBigDecimal(1,
                                       (BigDecimal)session.getAttribute("endorsementCode"));
                    cst1.registerOutParameter(2, OracleTypes.VARCHAR);
                    cst1.registerOutParameter(3, OracleTypes.NUMBER);
                    cst1.execute();
                    String Auth = cst1.getString(2);
                    if (Auth == null) {
                        session.setAttribute("Authorised", "N");
                    } else if (Auth.equalsIgnoreCase("A")) {
                        session.setAttribute("Authorised", "Y");
                    } else {
                        session.setAttribute("Authorised", "N");
                    }

                    session.setAttribute("ProductCode", cst1.getBigDecimal(3));
                    cst1.close();
                }

            } else if (Cursta.equalsIgnoreCase("E")) {
                BigDecimal endrCode =
                    (BigDecimal)session.getAttribute("endorsementCode");
                System.out.println("Endorsements Code=" + endrCode);
                if (endrCode != null) {
                    String auth =
                        "BEGIN LMS_WEB_CURSOR_GRP.get_pol_status(?,?,?);END;";
                    cst1 = conn.prepareCall(auth);
                    cst1.setBigDecimal(1,
                                       (BigDecimal)session.getAttribute("endorsementCode"));
                    cst1.registerOutParameter(2, OracleTypes.VARCHAR);
                    cst1.registerOutParameter(3, OracleTypes.NUMBER);
                    cst1.execute();
                    String Auth = cst1.getString(2);
                    if (Auth == null) {
                        session.setAttribute("Authorised", "N");
                    } else if (Auth.equalsIgnoreCase("A")) {
                        session.setAttribute("Authorised", "Y");
                    } else {
                        session.setAttribute("Authorised", "N");
                    }

                    session.setAttribute("ProductCode", cst1.getBigDecimal(3));
                }
                cst1.close();

                //cater for DMS module
            } else if (Cursta.equalsIgnoreCase("DMS")) {

                String dmsEnabled = GlobalCC.findDMSEnabled();
                if (dmsEnabled.equalsIgnoreCase("Y")) {

                    String id = (String)session.getAttribute("docId");
                    String docName = (String)session.getAttribute("docName");
                    try {

                        EcmUtil ecmUtil = new EcmUtil();
                        Session ecmSession = ecmUtil.Authentification();
                        session.setAttribute("dmsDocId", id);
                        Document document = (Document)ecmSession.getObject(id);
                        session.setAttribute("docName", document.getName());
                        session.setAttribute("dateCreated",
                                             new SimpleDateFormat("dd/MM/yyyy").format(document.getCreationDate().getTime()));
                        session.setAttribute("createdBy",
                                             document.getCreatedBy());
                        session.setAttribute("version",
                                             document.getVersionLabel());
                        InputStream inputStream =
                            document.getContentStream().getStream();
                        String file = "/Reports/" + docName;
                        FacesContext context =
                            FacesContext.getCurrentInstance();
                        ServletContext sc =
                            (ServletContext)context.getExternalContext().getContext();
                        file = sc.getRealPath(file);
                        File toPrint = new File(file);
                        OutputStream out;

                        out = new FileOutputStream(toPrint);
                        int read = 0;
                        byte[] bytes = new byte[1024];

                        while ((read = inputStream.read(bytes)) != -1) {
                            out.write(bytes, 0, read);
                        }

                        inputStream.close();
                        out.flush();
                        out.close();
                        if (toPrint != null) {
                            HttpServletRequest request =
                                (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
                            String scheme = request.getScheme();
                            String serverName = request.getServerName();
                            int portNumber = request.getServerPort();
                            String contextPath = request.getContextPath();
                            String url =
                                scheme + "://" + serverName + ":" + portNumber +
                                contextPath + "/viewer.html";
                            String pdf =
                                "?file=" + scheme + "://" + serverName + ":" +
                                portNumber + contextPath + "/Reports/" +
                                docName;
                            session.setAttribute("toPrint", url + pdf);

                            //GlobalCC.viewContext("marketingToUndewriting");
                            GlobalCC.RedirectPage("/" + ScreenName);
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    GlobalCC.errorValueNotEntered("DMS is not enabled. Please check your settings and try again!");
                }

            } else if (Cursta.equalsIgnoreCase("C")) {

                String auth =
                    "begin LMS_WEB_CURSOR_GRP.getclaimsbyclm(?,?);end;";
                cst1 = conn.prepareCall(auth);
                cst1.registerOutParameter(1, OracleTypes.CURSOR);
                cst1.setString(2, (String)session.getAttribute("ClaimNo"));

                cst1.execute();
                ResultSet rst = (ResultSet)cst1.getObject(1);
                while (rst.next()) {
                    session.setAttribute("ClaimNo", rst.getString(1));
                    session.setAttribute("ClaimTransNo", rst.getBigDecimal(5));
                    session.setAttribute("MemberNumber", rst.getBigDecimal(8));
                    session.setAttribute("CausationType", rst.getString(9));
                    session.setAttribute("PolmCode", rst.getBigDecimal(10));
                    session.setAttribute("ClaimTransactionType",
                                         rst.getString(6));
                    session.setAttribute("CAUS_CODE", rst.getString(11));
                }

                cst1.close();
            } else {
                String auth =
                    "BEGIN LMS_WEB_CURSOR_GRP.get_quote_status(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);END;";
                cst1 = conn.prepareCall(auth);
                cst1.setBigDecimal(1,
                                   (BigDecimal)session.getAttribute("QuoteCode"));
                cst1.registerOutParameter(2, OracleTypes.VARCHAR);
                cst1.registerOutParameter(3, OracleTypes.NUMBER);
                cst1.registerOutParameter(4, OracleTypes.NUMBER);
                cst1.registerOutParameter(5, OracleTypes.VARCHAR);
                cst1.registerOutParameter(6, OracleTypes.NUMBER);
                cst1.registerOutParameter(7, OracleTypes.VARCHAR);
                cst1.registerOutParameter(8, OracleTypes.DECIMAL);
                cst1.registerOutParameter(9, OracleTypes.VARCHAR);
                cst1.registerOutParameter(10, OracleTypes.DECIMAL);
                cst1.registerOutParameter(11, OracleTypes.VARCHAR);
                cst1.registerOutParameter(12, OracleTypes.DECIMAL);
                cst1.registerOutParameter(13, OracleTypes.VARCHAR);
                cst1.registerOutParameter(14, OracleTypes.VARCHAR);
                cst1.registerOutParameter(15, OracleTypes.DATE);
                cst1.registerOutParameter(16, OracleTypes.VARCHAR);
                cst1.registerOutParameter(17, OracleTypes.VARCHAR);
                cst1.registerOutParameter(18, OracleTypes.VARCHAR);
                cst1.registerOutParameter(19, OracleTypes.VARCHAR);
                cst1.registerOutParameter(20, OracleTypes.VARCHAR);
                cst1.registerOutParameter(21, OracleTypes.VARCHAR);
                cst1.registerOutParameter(22, OracleTypes.VARCHAR);
                cst1.execute();
                Authorised = cst1.getString(2);

                session.setAttribute("ProductCode", cst1.getBigDecimal(3));
                session.setAttribute("prpCode", cst1.getBigDecimal(4));
                session.setAttribute("prpDesc", cst1.getString(5));
                session.setAttribute("gcoCode", cst1.getBigDecimal(6));
                session.setAttribute("gcoDesc", cst1.getString(7));
                session.setAttribute("brnCode", cst1.getBigDecimal(8));
                session.setAttribute("brnName", cst1.getString(9));
                session.setAttribute("pmasCode", cst1.getBigDecimal(10));
                session.setAttribute("pmasShtDesc", cst1.getString(11));
                session.setAttribute("agnCode", cst1.getBigDecimal(12));
                session.setAttribute("agnShtDesc", cst1.getString(13));
                session.setAttribute("agnName", cst1.getString(14));
                session.setAttribute("newWETDate", cst1.getString(15));
                session.setAttribute("umbrellaCover", cst1.getString(16));
                if (cst1.getString(16) == null) {
                    session.setAttribute("disableDurationSel", "N");
                } else if (cst1.getString(16).equalsIgnoreCase("Y")) {
                    session.setAttribute("disableDurationSel", "Y");
                } else {
                    session.setAttribute("disableDurationSel", "N");
                }
                session.setAttribute("umbrellaDurationType",
                                     cst1.getString(17));
                session.setAttribute("policyDurationType", cst1.getString(18));


                if (Authorised.equalsIgnoreCase("D")) {
                    //LOVDAO.transType = "EQ";
                    session.setAttribute("transType", "EQ");
                    //QuotManipulation.RenderTab = 0;
                    session.setAttribute("RenderTab", 0);
                    session.setAttribute("RenderTab", 0);
                    session.setAttribute("calcType", cst1.getString(19));
                    session.setAttribute("depCovered", cst1.getString(20));
                } else if (Authorised.equalsIgnoreCase("S")) {
                    //LOVDAO.transType = "VQ";
                    session.setAttribute("transType", "VQ");
                } else {
                    //LOVDAO.transType = "NQ";
                    session.setAttribute("transType", "NQ");

                }
                //QuotManipulation.RenderTab = 0;

                session.setAttribute("depCovered", cst1.getString(20));
                session.setAttribute("loanCalcType", cst1.getString(21));
                session.setAttribute("earningsType", cst1.getString(22));
                cst1.close();
            }
            //ClientAddDetails.ScreenPosition = 0;
            session.setAttribute("allCovers", "N");
            session.setAttribute("ScreenPosition", 0);
            cst.close();
            conn.close();
            GlobalCC.RedirectPage("/" + ScreenName);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
            e.printStackTrace();
        } finally {
            GlobalCC.CloseConnections(null, cst1, conn);
        }

        return null;
    }

    public String postUnderwritingReinsurance() {
        String postUndReinsStat = "N";
        Connection conn = null;
        CallableStatement cst = null;
        String paramValue = "BEGIN lms_ord_misc.system_param_val(?,?);END;";
        conn = new DBConnector().getDatabaseConn();

        try {
            cst = conn.prepareCall(paramValue);
            cst.setString(1, "REINSURANCE_OUTSIDE_UNDERWRITING");
            cst.registerOutParameter(2,
                                     oracle.jdbc.internal.OracleTypes.VARCHAR);
            cst.execute();
            postUndReinsStat = cst.getString(2);

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return postUndReinsStat;
    }

    public String ProcessQuotaionTask() {
        try {

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String ProcessConvertTask() {
        try {

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return null;
    }

    public String CheckUserRights() {
        String ans = null;
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        try {
            String connectionPackage =
                "begin ? := tqc_interfaces_pkg.check_user_rights(?,?,?,?,?,?,?); end;";
            cst = conn.prepareCall(connectionPackage);

            cst.registerOutParameter(1, OracleTypes.VARCHAR);
            cst.setString(2, (String)session.getAttribute("Username"));
            cst.setInt(3, (Integer)session.getAttribute("sysCode"));
            cst.setString(4, (String)session.getAttribute("ProcessShtDesc"));
            cst.setString(5,
                          (String)session.getAttribute("ProcessAreaShtDesc"));
            cst.setString(6,
                          (String)session.getAttribute("ProcessSubAShtDesc"));
            cst.setString(7, (String)session.getAttribute("SumAssured"));
            cst.setString(8, (String)session.getAttribute("DebitCredit"));

            cst.execute();
            ans = cst.getString(1);
            cst.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
        return ans;

    }

    public String UpdateTaskAssignee() {
        try {
            String TaskAss = (String)session.getAttribute("TaskAssignee");
            if (TaskAss == null) {
                session.setAttribute("TaskAssignee",
                                     session.getAttribute("Username"));
            }
            String Cred = (String)session.getAttribute("Credit");
            if (Cred == null) {
                session.setAttribute("Credit", "No");
            }
            String TransNext = (String)session.getAttribute("NextTransition");
            if (TransNext == null) {
                session.setAttribute("NextTransition", "A");
            }


            wfEngine wf = new wfEngine();
            HashMap map = new HashMap();
            String Process = (String)session.getAttribute("ProcessShtDesc");
            System.out.println("process " + Process);
            if (Process.equalsIgnoreCase("QUOT")) {
                map.put("order", session.getAttribute("TaskAssignee"));
                map.put("content", session.getAttribute("ClientExists"));
            } else if (Process.equalsIgnoreCase("UWNB")) {
                map.put("UWStart", session.getAttribute("UWStart"));
                map.put("Client", session.getAttribute("ClientExists"));
                map.put("order", session.getAttribute("TaskAssignee"));
                map.put("Credit", session.getAttribute("Credit"));
                map.put("NextTrans", session.getAttribute("NextTransition"));
                map.put("performRein", session.getAttribute("performRein"));
                if (session.getAttribute("riMedicals") == null) {
                    map.put("riMedicals", "N");
                } else {
                    map.put("riMedicals", session.getAttribute("riMedicals"));
                }
            } else if (Process.equalsIgnoreCase("CLMS")) {
                map.put("DocsSubmitted", "Yes");
                map.put("clientDecision",
                        session.getAttribute("ClientAccept"));
                map.put("VoucherDecision",
                        session.getAttribute("VoucherDecision"));
                map.put("Transaction",
                        session.getAttribute("ClaimProcessTrans"));
            } else {
                map.put("order", session.getAttribute("TaskAssignee"));
                map.put("Credit", session.getAttribute("Credit"));
                map.put("NextTrans", session.getAttribute("NextTransition"));
                map.put("performRein", session.getAttribute("performRein"));
                if (session.getAttribute("riMedicals") == null) {
                    map.put("riMedicals", "N");
                } else {
                    map.put("riMedicals", session.getAttribute("riMedicals"));
                }
            }
            wf.updateTaskVariables((String)session.getAttribute("TaskID"),
                                   map);

            System.out.println("Order is here " +
                               String.valueOf(session.getAttribute("TaskAssignee")));
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
            e.printStackTrace();
        }
        return null;
    }

    public String findUserSelected() {
        try {

            DCIteratorBinding dciter =
                ADFUtils.findIterator("FindSystemUsersIterator");
            RowKeySet set = allUsersLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));


                Row r = dciter.getCurrentRow();
                System.out.println((String)session.getAttribute("Username"));
                session.setAttribute("UserSelected",
                                     r.getAttribute("USR_USERNAME"));
                allUsersDesc.setValue(r.getAttribute("USR_USERNAME"));
            }

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String findTicketForReassignSelected() {
        try {

            DCIteratorBinding dciter =
                ADFUtils.findIterator("findTicketDetailsByUserIterator");
            RowKeySet set = resultsLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));


                Row r = dciter.getCurrentRow();
                session.setAttribute("TaskID", r.getAttribute("TCKT_CDE"));
            }

            //Render Popup
            GlobalCC.showPopup("lmsgroup:popup1");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String findReAssigneeSelected() {
        Connection conn = new DBConnector().getDatabaseConn();
        CallableStatement cst3 = null;
        try {

            DCIteratorBinding dciter =
                ADFUtils.findIterator("FindSystemUsersIterator");
            RowKeySet set = allUsers2LOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));


                Row r = dciter.getCurrentRow();

                //session.setAttribute("ReassigneeCodeSelected", r.getAttribute("USR_CODE"));
                //session.setAttribute("ReassigneeNameSelected", r.getAttribute("USR_USERNAME"));
                //allUsersLOV.setValue(session.getAttribute("UserNameSelected"));
                String Usr = (String)r.getAttribute("USR_USERNAME");
                wfEngine wf = new wfEngine();
                wf.AssignTask((String)session.getAttribute("TaskID"), Usr);


                String Complete =
                    "BEGIN TQC_WEB_PKG.reassign_task(?,?,?);END;";
                cst3 = conn.prepareCall(Complete);
                cst3.setString(1, (String)session.getAttribute("TaskID"));
                cst3.setString(2, Usr);
                cst3.setString(3, null);
                cst3.execute();
                cst3.close();
                conn.close();

                ADFUtils.findIterator("findTicketDetailsByUserIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(resultsLOV);

                String message = "Task Successfully ReAssigned";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              message,
                                                                              message));


            }

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        } finally {
            GlobalCC.CloseConnections(null, cst3, conn);
        }
        return null;
    }

    public String findReAssignee2Selected() {
        try {

            DCIteratorBinding dciter =
                ADFUtils.findIterator("FindSystemUsersIterator");
            RowKeySet set = allUsers2LOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));


                Row r = dciter.getCurrentRow();

                //session.setAttribute("ReassigneeCodeSelected", r.getAttribute("USR_CODE"));
                //session.setAttribute("ReassigneeNameSelected", r.getAttribute("USR_USERNAME"));
                //allUsersLOV.setValue(session.getAttribute("UserNameSelected"));
                String Usr = (String)r.getAttribute("USR_USERNAME");
                user.setValue(Usr);


            }

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String Reassign2() {
        CorrespondenceManipulation mail = new CorrespondenceManipulation();
        Connection conn = new DBConnector().getDatabaseConn();
        CallableStatement cst3 = null;
        String priority = (String)session.getAttribute("priorityLevel");
        try {
            if (user.getValue() == null) {
                GlobalCC.INFORMATIONREPORTING("Select an Assignee");
                return null;

            }
            String Remarks = null;
            if (ticketRemarks.getValue() == null) {

            } else {
                Remarks = ticketRemarks.getValue().toString();
            }
            System.out.println("Priority Level is " + priority);

            String Complete =
                "BEGIN TQC_WEB_PKG.reassign_task(?,?,?,?,?);END;";
            cst3 = conn.prepareCall(Complete);
            cst3.setString(1, (String)session.getAttribute("TaskID"));
            cst3.setString(2, user.getValue().toString());
            cst3.setString(3, Remarks);
            cst3.setString(4, null);
            cst3.setString(5, priority);
            cst3.execute();
            cst3.close();
            conn.close();
            mail.ticketAlert((String)session.getAttribute("Username"),
                             user.getValue().toString(),
                             (String)session.getAttribute("TaskActivityName"),
                             Remarks);

            GlobalCC.RedirectPage("/lmsmain.jspx");

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        } finally {
            GlobalCC.CloseConnections(null, cst3, conn);
        }
        return null;
    }

    public String TakeTask() {
        Connection conn = new DBConnector().getDatabaseConn();
        CallableStatement cst3 = null;
        try {
            String Ticket = null;
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findTicketDetailsByUserIterator");
            RowKeySet set = resultsLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));


                Row r = dciter.getCurrentRow();

                Ticket = (String)r.getAttribute("TCKT_CDE");


                wfEngine wf = new wfEngine();
                wf.AssignTask(Ticket,
                              (String)session.getAttribute("Username"));


                String Complete =
                    "BEGIN TQC_WEB_PKG.reassign_task(?,?,?);END;";
                cst3 = conn.prepareCall(Complete);
                cst3.setString(1, Ticket);
                cst3.setString(2, (String)session.getAttribute("Username"));
                cst3.setString(3, null);
                cst3.execute();
                cst3.close();
                conn.close();

                ADFUtils.findIterator("findTicketDetailsByUserIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(resultsLOV);

                GlobalCC.INFORMATIONREPORTING("Task Successfully Taken");
            }

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        } finally {
            GlobalCC.CloseConnections(null, cst3, conn);
        }
        return null;
    }

    public String SearchResults() {
        try {
            ADFUtils.findIterator("findTicketDetailsByUserIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(resultsLOV);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String findTicket2Selected() {
        try {

            DCIteratorBinding dciter =
                ADFUtils.findIterator("findTicketDetailsByUserIterator");
            RowKeySet set = resultsLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));


                Row r = dciter.getCurrentRow();

                //LOVCC.TaskID = (String)r.getAttribute("TCKT_CDE");
                session.setAttribute("TaskID", r.getAttribute("TCKT_CDE"));
                //taskselName= (String)r.getAttribute("TCKT_NAME");
                //taskselAssignee= (String)r.getAttribute("TCKT_TO");
                //taskselDueDate=(Date)r.getAttribute("TCKT_DUE_DATE");
                //taskselID=(String)r.getAttribute("TCKT_CDE");
                //taskselCreateDate=(Date)r.getAttribute("TCKT_DATE");
                session.setAttribute("taskselName",
                                     r.getAttribute("TCKT_NAME"));
                session.setAttribute("taskselAssignee",
                                     r.getAttribute("TCKT_TO"));
                session.setAttribute("taskselDueDate",
                                     r.getAttribute("TCKT_DUE_DATE"));
                session.setAttribute("taskselID", r.getAttribute("TCKT_CDE"));
                session.setAttribute("taskselCreateDate",
                                     r.getAttribute("TCKT_DATE"));
                session.setAttribute("TaskActivityName",
                                     r.getAttribute("TCKT_NAME"));
                session.setAttribute("docId", r.getAttribute("TCKT_POL_NO"));
                session.setAttribute("docName", r.getAttribute("TCKT_REF_NO"));

                GlobalCC.RedirectPage("/wfProcessing.jspx");

            }

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }


    public String ShowReassign() {
        reassignPanel.setRendered(true);
        user.setValue(null);
        return null;
    }

    /**
     * CheckBPMParameter - Checks if BPM is enabled for the Module.
     * @parameter - module
     * @return value
     */

    public String CheckBPMParameter(String Module) {
        String Value = "N";
        Connection conn = null;
        CallableStatement cst = null;
        try {

            DBConnector myConn = new DBConnector();
            conn = myConn.getDatabaseConn();


            String connectionPackage =
                "begin tqc_web_pkg.bpm_process_flow(?,?); end;";
            cst = conn.prepareCall(connectionPackage);
            cst.setString(1, Module);
            cst.registerOutParameter(2, OracleTypes.VARCHAR);
            cst.execute();
            Value = cst.getString(2);
            cst.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
        return Value;
    }

    /**
     *FindProcessDetails - Find Details about a Certain Process.
     * @return
     **/

    public String FindProcessDetails() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;

        try {
            String polQuery = "begin TQC_WEB_PKG.get_process_dtls(?,?,?);end;";
            cst = conn.prepareCall(polQuery);
            cst.setInt(1, (Integer)session.getAttribute("sysCode"));
            cst.setString(2, (String)session.getAttribute("ProcessShtDesc"));
            cst.registerOutParameter(3, OracleTypes.CURSOR);

            cst.execute();
            ResultSet rst = (ResultSet)cst.getObject(3);
            while (rst.next()) {
                session.setAttribute("ProcessBPMDef", rst.getString(4));
            }
            rst.close();
            cst.close();
            conn.close();

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
        return null;
    }

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

    public String hideReassign() {
        reassignPanel.setRendered(false);
        return null;
    }

    public void setTaskName(RichOutputText taskName) {
        this.taskName = taskName;
    }

    public RichOutputText getTaskName() {
        return taskName;
    }

    public void setTaskAssignee(RichOutputText taskAssignee) {
        this.taskAssignee = taskAssignee;
    }

    public RichOutputText getTaskAssignee() {
        return taskAssignee;
    }

    public void setTaskDueDate(RichOutputText taskDueDate) {
        this.taskDueDate = taskDueDate;
    }

    public RichOutputText getTaskDueDate() {
        return taskDueDate;
    }

    public void setTaskID(RichOutputText taskID) {
        this.taskID = taskID;
    }

    public RichOutputText getTaskID() {
        return taskID;
    }

    public void setTicketsLOV(RichTable ticketsLOV) {
        this.ticketsLOV = ticketsLOV;
    }

    public RichTable getTicketsLOV() {
        return ticketsLOV;
    }

    public void setReassignPanel(RichPanelBox reassignPanel) {
        this.reassignPanel = reassignPanel;
    }

    public RichPanelBox getReassignPanel() {
        return reassignPanel;
    }

    public void setUser(RichInputText user) {
        this.user = user;
    }

    public RichInputText getUser() {
        return user;
    }

    public void setAllUsersLOV(RichTable allUsersLOV) {
        this.allUsersLOV = allUsersLOV;
    }

    public RichTable getAllUsersLOV() {
        return allUsersLOV;
    }

    public void setAllUsersDesc(RichInputText allUsersDesc) {
        this.allUsersDesc = allUsersDesc;
    }

    public RichInputText getAllUsersDesc() {
        return allUsersDesc;
    }

    public void setResultsLOV(RichTable resultsLOV) {
        this.resultsLOV = resultsLOV;
    }

    public RichTable getResultsLOV() {
        return resultsLOV;
    }

    public void setAllUsers2LOV(RichTable allUsers2LOV) {
        this.allUsers2LOV = allUsers2LOV;
    }

    public RichTable getAllUsers2LOV() {
        return allUsers2LOV;
    }

    public void setTicketRemarks(RichInputText ticketRemarks) {
        this.ticketRemarks = ticketRemarks;
    }

    public RichInputText getTicketRemarks() {
        return ticketRemarks;
    }

    public void ProductCoverTypeListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if (valueChangeEvent.getOldValue() != valueChangeEvent.getNewValue()) {
            if (productCoverDropBox.getValue() != null) {
                DCIteratorBinding dciter =
                    ADFUtils.findIterator("FindProductCoversIter");
                Row r =
                    dciter.getRowAtRangeIndex((Integer)valueChangeEvent.getNewValue());

                System.out.println("Attr names" + r.getAttribute("pct_code"));
                System.out.println("Attr names" + r.getAttribute("cvt_desc"));
                System.out.println("atr1");

                /*String Value = productCoverDropBox.getValue().toString();
            Integer Position = Integer.parseInt(Value);

            UIComponent MyComponent = productCoverDropBox.getChildren().get(0);
            UISelectItems MyItems = (UISelectItems)MyComponent;
            List<Object> selList = (List<Object>)MyItems.getValue();
            Iterator iter=selList.iterator();
            while(iter.hasNext()){
              SelectItem sel=(SelectItem)iter.next();
              System.out.println("The select item is "+sel.getLabel());
              System.out.println("The select item value "+sel.getValue());
            }*/
            }
        }
    }

    public void setProductCoverDropBox(RichSelectOneChoice productCoverDropBox) {
        this.productCoverDropBox = productCoverDropBox;
    }

    public RichSelectOneChoice getProductCoverDropBox() {
        return productCoverDropBox;
    }


    public void setPriorityLevel(RichSelectOneChoice priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    public RichSelectOneChoice getPriorityLevel() {
        return priorityLevel;
    }

    public void priorityLevelListener(ValueChangeEvent valueChangeEvent) {
        if (valueChangeEvent.getNewValue() != valueChangeEvent.getOldValue()) {
            if (priorityLevel.getValue() != null) {
                session.setAttribute("priorityLevel",
                                     priorityLevel.getValue());
            }
        }
    }
}
