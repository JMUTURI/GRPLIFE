package LMSG.view.Clients;


import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import java.text.SimpleDateFormat;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.FacesContext;

import javax.faces.event.ValueChangeEvent;

import javax.servlet.http.HttpSession;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanRadio;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.layout.RichPanelBox;
import oracle.adf.view.rich.component.rich.layout.RichPanelTabbed;
import oracle.adf.view.rich.component.rich.layout.RichShowDetailItem;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.output.RichOutputLabel;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.Key;
import oracle.jbo.Row;

import oracle.jdbc.OracleTypes;

import org.apache.myfaces.trinidad.event.AttributeChangeEvent;
import org.apache.myfaces.trinidad.model.RowKeySet;

import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

import LMSG.view.Base.ADFUtils;

import LMSG.view.Base.GlobalCC;
import LMSG.view.Base.LOVCC;

import LMSG.view.Base.ReinitializeVar;

import LMSG.view.connect.DBConnector;

import LMSG.view.BPM.workflowProcessing;

import oracle.jbo.uicli.binding.JUCtrlValueBinding;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.internal.OracleResultSet;

public class ClientAddDetails extends LOVCC {

    private RichTable jointAssureds;
    private RichInputText jointAssuredDesc;
    private RichInputText objOccupationDesc;

    private RichInputText clientDesc;
    private RichTable clientLOV;
    private RichCommandButton clientButton;
    private RichTable countriesLOV;
    private RichInputText countryDesc;
    private RichTable townLOV;
    private RichInputText townDesc;
    private RichPanelTabbed clientsTab;
    private RichShowDetailItem selectClientAction;
    private RichShowDetailItem clientDetails;
    private RichShowDetailItem clientSystems;
    private RichCommandButton prevButton;
    private RichCommandButton nextButton;
    private RichTable sectorLOV;
    private RichInputText sectorDesc;
    private RichInputText domicileCountry;
    private RichTable domicilecountryLOV;
    private RichTable banksLOV;
    private RichInputText bankDesc;
    private RichTable searchClients;

    //protected static BigDecimal ClientCode;
    protected static String ClientshtCde;
    private RichInputText fullName;
    private RichInputText idRegNo;
    private RichInputDate doB;
    private RichInputText piNNumber;
    private RichInputText physicalAddress;
    private RichInputText postalAddress;
    private RichInputText emailAddress;
    private RichInputText telephone;
    private RichSelectOneChoice status;
    private RichInputText fax;
    private RichInputText remarks;
    private RichSelectOneChoice specialTerms;
    private RichSelectOneChoice declinedProposal;
    private RichSelectOneChoice increasedPremium;
    private RichSelectOneChoice cancelledPolicy;
    private RichInputText accNo;
    private RichInputDate wef;
    private RichInputDate wet;
    private RichInputText withdrawalReason;
    private RichInputText surname;
    private RichSelectBooleanRadio rdIndividual;
    private RichSelectBooleanRadio rdCorporate;
    private RichSelectOneChoice title;
    private RichInputText bankAccount;
    private RichSelectOneChoice direct;
    private RichInputText createdBy;
    private RichInputText smsNo;
    private RichInputDate dateCreated;
    private RichSelectOneChoice runOff;
    private RichShowDetailItem confirmClient;
    private RichInputText firstName;
    private RichInputText middleName;
    private RichSelectOneChoice searchCriteria;

    protected static String FirstName;
    protected static String MiddleName;
    protected static String LastName;
    protected static String PINNumber;
    protected static String PostalAddress;
    protected static String SearchCriteria;
    private RichTable availableSystems;
    private RichTable assignedsystems;
    private RichInputText id;
    private RichSelectOneChoice holdingCompany;

    //protected static String AddEdit = null;
    protected static String Direct;
    protected static String id1;
    protected static String RegNo;
    protected static String PhyAddress;
    protected static String TitleListener;
    protected static String email;
    protected static String telephone1;
    protected static String fax1;
    protected static String sms;
    protected static String bankAcc;
    protected static String remarks1;

    protected static String WEFDate;
    protected static String WETDate;
    protected static String DOBDate;
    private RichInputText userName;
    private RichInputText fullNames;
    private RichInputText password;
    private RichInputText personelRank;
    private RichSelectOneChoice userstatus;
    private RichSelectOneChoice allowLogin;
    private RichInputText webemailAddress;
    private RichTable webClientAccounts;
    private RichShowDetailItem webAccTab;
    private RichTable existingClients;
    private RichCommandButton useClientButton;
    private RichPanelBox clientTask;

    private RichSelectBooleanRadio rdEditClient;
    private RichPanelBox addClientDetails;
    private RichPanelBox confirmClientDetails;
    private RichOutputLabel firstnameLabel;
    private RichOutputLabel middleNameLabel;
    private RichCommandButton countryButton;
    private RichCommandButton townButton;
    private RichCommandButton sectorButton;
    private RichCommandButton domicileButton;
    private RichCommandButton branchButton;
    private RichTable editClientTable;
    private RichTable viewClientSelected;
    private RichCommandButton viewClientButton;
    private RichCommandButton editClientButton;
    private RichPanelBox selectClientToViewEdit;
    private RichTable occupation;
    private RichSelectOneChoice transType;
    private RichInputText allClientDesc;
    private HtmlPanelGrid clientsPanel;
    private HtmlPanelGrid clientsLabel;
    private RichOutputLabel fullnameLabel;
    private HtmlPanelGrid similarClientsPanel;
    private RichCommandButton saveButton;
    private RichCommandButton cancelButton;
    private RichTable usersLOV;

    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    private RichSelectOneChoice clientType;
    private RichOutputLabel titleLabel;
    private RichOutputLabel surnameLabel;
    private RichOutputLabel dobLabel;
    private RichInputText stateDesc;
    private RichTable statesLOV;
    private RichOutputLabel searchCriteriaLbl;
    private RichInputText branchDesc;
    private RichTable branchesTable;
    private RichPanelTabbed clientTabbedPanel;
    private RichInputText contPerName;
    private RichInputDate contPerDOB;
    private RichInputText contPerPhyAddr;
    private RichInputText contPerPostAddr;
    private RichInputText contPerTel;
    private RichInputText contPerEmail;
    private RichInputDate contPerWEF;
    private RichInputDate contPerWET;
    private RichTable contactPerLOV;
    private RichInputText clientAbbreviation;

    public String occupationSelected() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findClientOccupationsIterator");
        RowKeySet set = occupation.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));

            Row r = dciter.getCurrentRow();


            try {
                session.setAttribute("occupationDesc",
                                     r.getAttribute("occupationalDesc"));
                session.setAttribute("occupationCode",
                                     r.getAttribute("occupationCode"));
                session.setAttribute("occupationlifeClass",
                                     r.getAttribute("lifeClass"));
                objOccupationDesc.setValue(session.getAttribute("occupationDesc"));

            } catch (Exception e) {

                GlobalCC.EXCEPTIONREPORTING(null, e);
            }

        }

        return null;
    }

    public String BranchesSelected() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindBranchesIterator");
        RowKeySet set = branchesTable.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));

            Row r = dciter.getCurrentRow();


            try {
                session.setAttribute("brnCode", r.getAttribute("BRN_CODE"));
                branchDesc.setValue(r.getAttribute("BRN_NAME"));

            } catch (Exception e) {

                GlobalCC.EXCEPTIONREPORTING(null, e);
            }

        }

        return null;
    }

    public String findClientDetails() {
        String ClientType;

        DCIteratorBinding dciter =
            ADFUtils.findIterator("findAllClientsIterator");
        RowKeySet set = searchClients.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));

            Row r = dciter.getCurrentRow();
            //ClientCode = (BigDecimal)r.getAttribute("clientCode");
            session.setAttribute("ClientCode", r.getAttribute("clientCode"));
            allClientDesc.setValue(r.getAttribute("fullname"));
        }

        String query = "begin ? := tqc_clients_pkg.get_client_dtls(?); end;";
        CallableStatement cst = null;
        CallableStatement cst1 = null;

        Connection conn = null;
        try {
            DBConnector datahandler = new DBConnector();

            conn = datahandler.getDatabaseConn();

            cst = conn.prepareCall(query);
            cst.registerOutParameter(1,
                                     OracleTypes.CURSOR); //authorization code

            cst.setBigDecimal(2,
                              (BigDecimal)session.getAttribute("ClientCode"));

            cst.execute();

            ResultSet rs = (ResultSet)cst.getObject(1);

            while (rs.next()) {
                //add feild bindings
                ClientshtCde = rs.getString(2);
                id.setValue(rs.getString(2));
                firstName.setValue(rs.getString(4));
                FirstName = rs.getString(4);
                // fullName.setValue(rs.getString(3));
                surname.setValue(rs.getString(3));
                LastName = rs.getString(3);
                idRegNo.setValue(rs.getString(5));
                RegNo = rs.getString(5);
                doB.setValue(rs.getDate(6));
                piNNumber.setValue(rs.getString(7));
                PINNumber = rs.getString(7);
                physicalAddress.setValue(rs.getString(8));
                PhyAddress = rs.getString(8);
                postalAddress.setValue(rs.getString(9));
                PostalAddress = rs.getString(9);
                session.setAttribute("townCode", rs.getBigDecimal(10));
                townDesc.setValue(rs.getString(11));
                session.setAttribute("countryCode", rs.getBigDecimal(12));
                countryDesc.setValue(rs.getString(13));
                emailAddress.setValue(rs.getString(14));
                email = rs.getString(14);
                telephone.setValue(rs.getString(15));
                telephone1 = rs.getString(15);
                status.setValue(rs.getString(17));
                fax.setValue(rs.getString(18));
                fax1 = rs.getString(18);
                remarks.setValue(rs.getString(19));
                specialTerms.setValue(rs.getString(20));
                declinedProposal.setValue(rs.getString(21));
                increasedPremium.setValue(rs.getString(22));
                cancelledPolicy.setValue(rs.getString(23));
                accNo.setValue(rs.getString(25));
                id1 = rs.getString(2);
                wef.setValue(rs.getDate(27));
                wet.setValue(rs.getDate(28));
                withdrawalReason.setValue(rs.getString(29));
                session.setAttribute("sectorCode", rs.getBigDecimal(30));
                ClientType = rs.getString(32);
                clientType.setValue(ClientType);
                title.setValue(rs.getString(33));
                TitleListener = rs.getString(33);
                //LOVCC.branchCode = rs.getBigDecimal(36);
                session.setAttribute("branchcode", rs.getBigDecimal(36));
                bankAccount.setValue(rs.getString(37));
                bankAcc = rs.getString(37);
                direct.setValue(rs.getString(46));
                Direct = rs.getString(46);
                createdBy.setValue(rs.getString(40));
                smsNo.setValue(rs.getString(41));
                sms = rs.getString(41);
                dateCreated.setValue(rs.getDate(43));
                runOff.setValue(rs.getString(44));
                session.setAttribute("stateCode", rs.getBigDecimal(54));
                stateDesc.setValue(rs.getString(55));
                branchDesc.setValue(rs.getString(61));
               session.setAttribute("brnCode", rs.getBigDecimal(62));
            }

            //Get Occupation
            String query1 =
                "begin LMS_WEB_CURSOR_GRP.grp_client_occupation(?,?); end;";

            cst1 = conn.prepareCall(query1);
            cst1.registerOutParameter(1,
                                      OracleTypes.CURSOR); //authorization code
            cst1.setBigDecimal(2,
                               (BigDecimal)session.getAttribute("ClientCode"));
            cst1.execute();

            ResultSet rs1 = (ResultSet)cst1.getObject(1);
            while (rs1.next()) {
                //LOVCC.occupationCode = rs1.getBigDecimal(1);
                session.setAttribute("occupationCode", rs1.getBigDecimal(1));
                objOccupationDesc.setValue(rs1.getString(2));
                clientAbbreviation.setValue(rs1.getString(4));

            }
            conn.close();

            ADFUtils.findIterator("findContactPersonsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(contactPerLOV);
        } catch (Exception e) {
            e.printStackTrace();
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }

        return null;
    }

    public String saveClientWebAccount() {
        String PersonelRank = null;
        String Email = null;

        String Query =
            "begin tqc_clients_pkg.create_client_web_account(?,?,?,?,?,?,?,?,?,?,?,?); end;";

        CallableStatement cst = null;
        try {

            DBConnector datahandler = new DBConnector();
            Connection conn;
            conn = datahandler.getDatabaseConn();
            cst = conn.prepareCall(Query);

            if (personelRank.getValue() == null) {
                PersonelRank = personelRank.getValue().toString();
            } else {
                PersonelRank = null;
            }
            if (webemailAddress.getValue() == null) {
                Email = webemailAddress.getValue().toString();
            } else {
                Email = null;
            }


            cst.setString(1, userName.getValue().toString());
            cst.setString(2, password.getValue().toString());
            cst.setString(3, allowLogin.getValue().toString());
            cst.setString(4, null);
            cst.setString(5, null);
            cst.setString(6, PersonelRank);
            cst.setString(7, status.getValue().toString());
            cst.setBigDecimal(8,
                              (BigDecimal)session.getAttribute("ClientCode"));
            cst.setString(9, (String)session.getAttribute("Username"));
            cst.setString(10, Email);
            cst.setString(11, "A");
            cst.setBigDecimal(12, null);

            cst.execute();
            conn.close();

            String message = "Client Created.";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(message));

            ADFUtils.findIterator("findclientwebaccountsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(webClientAccounts);
            //ButtonSequence(0);

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String RemoveClientWebAccount() {
        BigDecimal ClientWebAccount = null;

        DCIteratorBinding dciter =
            ADFUtils.findIterator("findclientwebaccountsIterator");
        RowKeySet set = webClientAccounts.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));

            Row r = dciter.getCurrentRow();

            ClientWebAccount = (BigDecimal)r.getAttribute("clientAccCode");

        }

        String Query =
            "begin tqc_clients_pkg.create_client_web_account(?,?,?,?,?,?,?,?,?,?,?,?); end;";

        CallableStatement cst = null;
        try {

            DBConnector datahandler = new DBConnector();
            Connection conn;
            conn = datahandler.getDatabaseConn();
            cst = conn.prepareCall(Query);

            cst.setString(1, null);
            cst.setString(2, null);
            cst.setString(3, null);
            cst.setString(4, null);
            cst.setString(5, null);
            cst.setString(6, null);
            cst.setString(7, null);
            cst.setBigDecimal(8, null);
            cst.setString(9, null);
            cst.setString(10, null);
            cst.setString(11, "D");
            cst.setBigDecimal(12, ClientWebAccount);

            cst.execute();
            conn.close();

            ADFUtils.findIterator("findclientwebaccountsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(webClientAccounts);

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String SaveClientDetails() {
        try {
            if (clientType.getValue() == null) {
                String message = "Select A Client Type";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              message,
                                                                              message));
                return null;
            } 
            /*else {

            }*/
            
            if(surname.getValue() == null){
                String message = "Select a surname";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              message,
                                                                              message));
                return null;
            }
            if(objOccupationDesc.getValue() == null){
                String message = "Select an Occupation";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              message,
                                                                              message));
                return null;
            }
            if(wef.getValue() == null){
                String message = "Select a WEF date";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              message,
                                                                              message));
                return null;
            }
            if(branchDesc.getValue() == null){
                String message = "Select a branch";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              message,
                                                                              message));
                return null;
            }
            String Task2 = (String)session.getAttribute("TaskID");
            if (Task2 != null) {
                String Rights = null;
                String CurSta = (String)session.getAttribute("CurrentStatus");
                if (CurSta.equalsIgnoreCase("Q")) {
                    //LOVCC.ProcessShtDesc = "QUOT";
                    session.setAttribute("ProcessShtDesc", "QUOT");
                } else {
                    //LOVCC.ProcessShtDesc = "UWNB";
                    session.setAttribute("ProcessShtDesc", "UWNB");
                }
                //LOVCC.ProcessAreaShtDesc = "DENTR";
                //LOVCC.ProcessSubAShtDesc = "CLNT";
                session.setAttribute("ProcessAreaShtDesc", "DENTR");
                session.setAttribute("ProcessSubAShtDesc", "CLNT");
                workflowProcessing wf = new workflowProcessing();
                Rights = wf.CheckUserRights();

                if (Rights.equalsIgnoreCase("N")) {
                    String Message =
                        "You do not have rights to Perform this Task.";
                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                  Message,
                                                                                  Message));
                    return null;
                }

            }

            //java.util.Date Test = new java.util.Date();

            // Date coverFrom = new Date();
            SimpleDateFormat sdf1 =
                new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
            SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MMM-yyyy");

            String wefString = null;
            String wetString = null;
            String DOBString = null;
            java.util.Date lossDate = new java.util.Date();
            java.util.Date notificationDate = new java.util.Date();
            java.util.Date DOB = new java.util.Date();
            ;


            lossDate = null;
            notificationDate = null;


            String query =
                "begin ? := tqc_clients_pkg.create_clnt_proc(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," +
                "?,?,?,?,?,?,?,?,?,?,?); end;";
            CallableStatement cst = null;

            if (transType.getValue().toString().equalsIgnoreCase("C")) {
                if (wef.getValue() == null) {

                } else {
                    lossDate = sdf1.parse(wef.getValue().toString());
                    wefString = sdf2.format(lossDate);

                }
                if (wet.getValue() == null) {

                } else {
                    notificationDate = sdf1.parse(wet.getValue().toString());
                    wetString = sdf2.format(notificationDate);

                }
                if (doB.getValue() == null) {

                } else {
                    DOB = sdf1.parse(doB.getValue().toString());
                    DOBString = sdf2.format(DOB);

                }
            } else {

                wefString = WEFDate;
                wetString = WETDate;
                DOBString = DOBDate;
            }


            DBConnector datahandler = new DBConnector();
            Connection conn;
            conn = datahandler.getDatabaseConn();

            cst = conn.prepareCall(query);
            cst.registerOutParameter(1,
                                     OracleTypes.NUMBER); //authorization code
            Direct = direct.getValue().toString();

            cst.setString(2, Direct);
            if (id.getValue() == null) {
                cst.setString(3, null);
            } else {
                cst.setString(3, id.getValue().toString());
            }

            if (firstName.getValue() == null) {
                cst.setString(4, null);
            } else {
                cst.setString(4, ClientAddDetails.FirstName.toUpperCase());
            }

            if (middleName.getValue() == null) {
                cst.setString(5, null);
            } else {
                cst.setString(5, ClientAddDetails.MiddleName.toUpperCase());
            }

            if (surname.getValue() == null) {
                cst.setString(6, null);
            } else {
                cst.setString(6, surname.getValue().toString().toUpperCase());
            }


            cst.setString(7, ClientAddDetails.PINNumber);
            cst.setString(8, ClientAddDetails.PostalAddress);
            cst.setString(9, PhyAddress);
            if (idRegNo.getValue() == null) {
                cst.setString(10, null);
            } else {
                cst.setString(10, idRegNo.getValue().toString());
            }
          
            cst.setString(11, (String)session.getAttribute("Username"));
            cst.setString(12, wefString);
            cst.setString(13, wetString);
            cst.setString(14, TitleListener);
            cst.setString(15, DOBString);
            cst.setBigDecimal(16,
                              (BigDecimal)session.getAttribute("countryCode"));
            cst.setBigDecimal(17,
                              (BigDecimal)session.getAttribute("townCode"));
            cst.setString(18, (String)session.getAttribute("postalZIPCode"));
            cst.setString(19, email);
            cst.setString(20, telephone1);
            cst.setString(21, sms);
            cst.setString(22, fax1);
            cst.setBigDecimal(23,
                              (BigDecimal)session.getAttribute("sectorCode"));
            cst.setString(24, (String)session.getAttribute("sectorName"));
            cst.setBigDecimal(25,
                              (BigDecimal)session.getAttribute("domicileCountry"));
            cst.setString(26, holdingCompany.getValue().toString());
            cst.setString(27, status.getValue().toString());
            cst.setString(28, runOff.getValue().toString());
            cst.setString(29, null); //withdrawalReason.getValue().toString());
            cst.setString(30, remarks1);
            cst.setString(31, bankAcc);
            cst.setBigDecimal(32,
                              (BigDecimal)session.getAttribute("branchCode"));
            if (specialTerms.getValue() == null) {
                cst.setString(33, "N");
            } else {
                cst.setString(33, specialTerms.getValue().toString());
            }
            cst.setString(34, cancelledPolicy.getValue().toString());
            cst.setString(35, increasedPremium.getValue().toString());
            cst.setString(36, declinedProposal.getValue().toString());
            /*if (rdIndividual.isSelected()) {
                cst.setString(37, "I");
            } else {
                cst.setString(37, "C");
            }*/
            if (clientType.getValue() == null) {
                cst.setString(37, "I");
            } else {
                cst.setString(37, clientType.getValue().toString());
            }
            cst.setString(38, (String)session.getAttribute("AddEdit"));
            cst.setBigDecimal(39,
                              (BigDecimal)session.getAttribute("ClientCode"));
            cst.setString(40, null);
            cst.setString(41, null);
            cst.setString(42, null);
            cst.setString(43, null);
            cst.setString(44, null);
            cst.setString(45, null);
            cst.setString(46, null);
            
            //HERE 
            cst.setBigDecimal(47, (BigDecimal)session.getAttribute("stateCode"));
            cst.setString(48, null);
            cst.setString(49, null);
            cst.setBigDecimal(50, (BigDecimal)session.getAttribute("brnCode"));

            cst.execute();

            String AddEdit = (String)session.getAttribute("AddEdit");
            //ClientCode = cst.getBigDecimal(1);   ClientCode
            session.setAttribute("ClientCode", cst.getBigDecimal(1));
            System.out.println("ClientCode " + cst.getBigDecimal(1));
            //            if (AddEdit.equalsIgnoreCase("A")){
            //                //ClientCode = cst.getBigDecimal(1);
            //            session.setAttribute("ClientCode", cst.getBigDecimal(1));
            //            System.out.println("Client Code "+cst.getBigDecimal(1));
            //            }else{
            //            }


            if (AddEdit.equalsIgnoreCase("A")) {
                String createProposer =
                    "SELECT TO_NUMBER(TO_CHAR(SYSDATE,'YYYY'))||LMS_PRP_CODE_SEQ.NEXTVAL FROM DUAL";
                CallableStatement insProp = null;
                insProp = conn.prepareCall(createProposer);
                ResultSet rs = insProp.executeQuery();
                while (rs.next()) {
                    //LOVCC.PrpCode = rs.getBigDecimal(1);
                    session.setAttribute("prpCode", rs.getBigDecimal(1));
                }
            }

            String insertProposerDetails =
                "begin LMS_WEB_PKG_GRP.addProposer(?,?,?,?,?); end;";

            CallableStatement instprpDetails = null;
            instprpDetails = conn.prepareCall(insertProposerDetails);
            instprpDetails.setString(1, AddEdit);
            instprpDetails.setBigDecimal(2,
                                         (BigDecimal)session.getAttribute("ClientCode"));
            instprpDetails.setBigDecimal(3,
                                         (BigDecimal)session.getAttribute("occupationCode"));
            instprpDetails.setBigDecimal(4,
                                         (BigDecimal)session.getAttribute("prpCode"));
            if (clientAbbreviation.getValue() == null) {
                instprpDetails.setString(5, null);
            } else {
                instprpDetails.setString(5,
                                         clientAbbreviation.getValue().toString());
            }
            instprpDetails.execute();


            /* if (rdCreateClient.isSelected()){
                ADFUtils.findIterator("findAllClients1Iterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(searchClients);
            }*/
            String message = null;
            if (AddEdit.equalsIgnoreCase("A")) {
                message = "Client Details Captured";

                String Taske = (String)session.getAttribute("TaskID");
                if (Taske == null) {
                    message = "Client Details Captured.";
                } else {
                    workflowProcessing bpm = new workflowProcessing();
                    String NextAssignee =
                        (String)session.getAttribute("Username");
                    NextAssignee = (String)session.getAttribute("TicketFrom");
                    if (NextAssignee == null) {
                        NextAssignee =
                                (String)session.getAttribute("Username");
                    }
                    //LOVCC.TaskAssignee = NextAssignee;
                    session.setAttribute("TaskAssignee", null);
                    bpm.CompleteTask();

                    if (NextAssignee.equalsIgnoreCase((String)session.getAttribute("Username"))) {
                    
                    if (session.getAttribute("module")!=null&&session.getAttribute("module").equals("P"))
                      GlobalCC.RedirectPage("/undwrtone.jspx");
                    else
                        GlobalCC.RedirectPage("/g_qtrans.jspx");
                    } else {
                        String Message =
                            "Task Complete. The Next Task " + (String)session.getAttribute("TaskActivityName") +
                            " has been Successfully assigned to " +
                            (String)session.getAttribute("TaskAssignee");
                        FacesContext.getCurrentInstance().addMessage(null,
                                                                     new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                      Message,
                                                                                      Message));
                        return null;
                    }

                }
            } else {
                message = "Client Details updated";
            }
            conn.close();
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(message));

            if (AddEdit.equalsIgnoreCase("A")) {
                //ReinitializeVar var1 = new ReinitializeVar();
                //var1.ReinitializeVar2();
                //ScreenPosition = 0;
                saveButton.setText("Next");
                saveButton.setRendered(false);
            } else {

            }

            ADFUtils.findIterator("findContactPersonsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(contactPerLOV);
            //AdfFacesContext.getCurrentInstance().returnFromDialog(GlobalCC.dialogName,null);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
            e.printStackTrace();
        }


        return null;
    }

    public String GetAssignee() {
        try {
            // Render Popup
            System.out.println("enter popup");
            ExtendedRenderKitService erkService =
                Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                   ExtendedRenderKitService.class);
            erkService.addScript(FacesContext.getCurrentInstance(),
                                 "var hints = {autodismissNever:false}; " +
                                 "AdfPage.PAGE.findComponent('" +
                                 "demoTemplate:users" + "').show(hints);");

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String AssignTask() {

        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findTicketAssigneeIterator");
            RowKeySet set = usersLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            //System.out.println(1);
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();
                //clientsDisplay.setValue(r.getAttribute("CLIENT"));

                //LOVCC.TaskAssigneeID=(BigDecimal)r.getAttribute("taskUserID");
                //LOVCC.TaskAssignee = (String)r.getAttribute("taskUserShtDesc");
                session.setAttribute("TaskAssigneeID",
                                     r.getAttribute("taskUserID"));
                session.setAttribute("TaskAssignee",
                                     r.getAttribute("taskUserShtDesc"));


            }
            DBConnector datahandler = new DBConnector();
            Connection conn;
            conn = datahandler.getDatabaseConn();

            String MyTask = null;
            CallableStatement cst3 = null;
            String Complete =
                "BEGIN TQC_WEB_PKG.check_task_completion(?,?,?);END;";
            cst3 = conn.prepareCall(Complete);
            cst3.setString(1, "QCLNT");
            cst3.setString(2, (String)session.getAttribute("TaskID"));
            cst3.registerOutParameter(3, OracleTypes.VARCHAR);
            cst3.execute();
            MyTask = cst3.getString(3);
            if (MyTask.equalsIgnoreCase("Y")) {
                workflowProcessing bpm = new workflowProcessing();
                bpm.CompleteTask();
            } else {
                //do nothing
                return null;
            }
            String TaskAss = (String)session.getAttribute("TaskAssignee");
            if (TaskAss.equalsIgnoreCase((String)session.getAttribute("Username"))) {

                GlobalCC.RedirectPage("/g_qtrans.jspx");

            } else {
                session.setAttribute("TaskID", null);
                String Message =
                    "The Next Task " + (String)session.getAttribute("TaskActivityName") +
                    " has been Successfully assigned to " +
                    (String)session.getAttribute("TaskAssignee");
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));
            }
            System.out.println("Success");
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return null;
    }

    public String cancelClient() {
        saveButton.setRendered(false);
        allClientDesc.setValue(null);
        session.setAttribute("ClientCode", null);
        //ScreenPosition = 0;
        session.setAttribute("ScreenPosition", 0);
        ScreenRendering();
        return null;

    }

    /*public String editClientSelected() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findUsersCreatedByAgentIterator");
        RowKeySet set = editClientTable.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));

            Row r = dciter.getCurrentRow();
            //ClientCode = (BigDecimal)r.getAttribute("clientCode");
            session.setAttribute("ClientCode", r.getAttribute("clientCode"));


        }
        editClientDetails();
        return null;
    }*/

    /*public String viewClientSelected() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findUserByAgencyCodeIterator");
        RowKeySet set = viewClientSelected.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));

            Row r = dciter.getCurrentRow();
            //ClientCode = (BigDecimal)r.getAttribute("clientCode");
            session.setAttribute("ClientCode", r.getAttribute("clientCode"));



        }
        viewClientDetails();
        return null;
    }*/

    public String createPrpClient() {

        FacesContext context = FacesContext.getCurrentInstance();
        // Create the dialog UIViewRoot
        //ScreenPosition = 0;
        session.setAttribute("ScreenPosition", 0);
        ViewHandler viewHandler = context.getApplication().getViewHandler();
        GlobalCC.dialogName = "/createClient.jspx";
        UIViewRoot dialog =
            viewHandler.createView(context, GlobalCC.dialogName);

        HashMap properties = new HashMap();
        properties.put("width", 900);
        properties.put("height", 1000);

        AdfFacesContext afContext = AdfFacesContext.getCurrentInstance();

        afContext.launchDialog(dialog, null,
                // not launched from any component
                null, // no particular parameters
                true, //show in dialog
                properties);
        //setDefaultCauntry();
        return null;
    }

    public String setDefaultCauntry() {
        String couCodeVal = null;
        String couNameVal = null;
        DBConnector datahandler = new DBConnector();
        datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        String query = "begin LMS_WEB_CURSOR_SETUP.DefaultCountry(?,?); end;";
        //OracleConnection conn = null;

        try {
            CallableStatement cst1 = null;
            cst1 = conn.prepareCall(query);
            cst1.registerOutParameter(1,
                                      OracleTypes.CURSOR); //authorization code
            cst1.setInt(2, 1);
            cst1.execute();
            OracleResultSet rs = (OracleResultSet)cst1.getObject(1);

            while (rs.next()) {
                session.setAttribute("countryCode", rs.getBigDecimal(1));
                countryDesc.setValue(rs.getString(2));
                AdfFacesContext.getCurrentInstance().addPartialTarget(countryDesc);
            }
            rs.close();
            conn.commit();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public String useClient() {

        DCIteratorBinding dciter =
            ADFUtils.findIterator("findSimilarClientsIterator");
        RowKeySet set = existingClients.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));

            Row r = dciter.getCurrentRow();
            //ClientCode = (BigDecimal)r.getAttribute("clientCode");
            session.setAttribute("ClientCode", r.getAttribute("clientCode"));

        }

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        try {
            String createProposer =
                "SELECT TO_NUMBER(TO_CHAR(SYSDATE,'YYYY'))||LMS_PRP_CODE_SEQ.NEXTVAL FROM DUAL";
            CallableStatement insProp = null;
            insProp = conn.prepareCall(createProposer);
            ResultSet rs = insProp.executeQuery();
            while (rs.next()) {
                //LOVCC.PrpCode = rs.getBigDecimal(1);
                session.setAttribute("prpCode", rs.getBigDecimal(1));
            }

            String insertProposerDetails =
                "INSERT INTO LMS_PROPOSERS(PRP_ACC_NO, PRP_BANK_ACC_NO, PRP_BBR_CODE, PRP_BUSINESS,PRP_CODE,PRP_CLNT_CODE,\n" +
                "                               PRP_DECLINED_PROP, PRP_DOB, PRP_DOMICILE_COUNTRIES, PRP_EMAIL, PRP_FAX, PRP_ID_REG_NO, \n" +
                "                               PRP_INCREASED_PREMIUM, PRP_SURNAME, PRP_OTHER_NAMES, PRP_PHYSICAL_ADDR, PRP_PIN, \n" +
                "                               PRP_POLICY_CANCELLED, PRP_POSTAL_ADDRESS, PRP_PROPOSER, PRP_REMARKS, PRP_SHT_DESC, \n" +
                "                               PRP_SPCL_TERMS,PRP_TEL, PRP_TEL2, PRP_TITLE,PRP_TYPE,PRP_CLASS_TYPE,PRP_ZIP_CODE,PRP_TOWN, PRP_COUNTRY,PRP_CLNT_SMS_TEL,PRP_CO_CODE,PRP_DOB_ADMITTED)\n" +
                "                       SELECT CLNT_ACCNT_NO, CLNT_BANK_ACC_NO, CLNT_BBR_CODE, ?,?,CLNT_CODE, \n" +
                "                               CLNT_DECLINED_PROP, CLNT_DOB, COU_NAME, CLNT_EMAIL_ADDRS, CLNT_FAX, CLNT_ID_REG_NO, \n" +
                "                               CLNT_INCREASED_PREMIUM, CLNT_NAME, CLNT_OTHER_NAMES, CLNT_PHYSICAL_ADDRS, CLNT_PIN, \n" +
                "                               CLNT_POLICY_CANCELLED, CLNT_POSTAL_ADDRS, CLNT_PROPOSER, CLNT_REMARKS, CLNT_SHT_DESC, \n" +
                "                               CLNT_SPCL_TERMS, CLNT_TEL, CLNT_TEL2, CLNT_TITLE, 'Both','O',CLNT_ZIP_CODE,TWN_NAME, COU_NAME,CLNT_SMS_TEL, ?, 'Y'\n" +
                "                       FROM TQC_CLIENTS,TQC_TOWNS,TQC_COUNTRIES\n" +
                "                       WHERE CLNT_CODE = ?\n" +
                "                       AND COU_CODE(+) = CLNT_COU_CODE\n" +
                "                       AND TWN_CODE(+) = CLNT_TWN_CODE";

            CallableStatement instprpDetails = null;
            instprpDetails = conn.prepareCall(insertProposerDetails);
            instprpDetails.setString(1,
                                     (String)session.getAttribute("occupationDesc"));
            instprpDetails.setBigDecimal(2,
                                         (BigDecimal)session.getAttribute("prpCode"));
            instprpDetails.setBigDecimal(3,
                                         (BigDecimal)session.getAttribute("occupationCode"));
            instprpDetails.setBigDecimal(4,
                                         (BigDecimal)session.getAttribute("ClientCode"));
            instprpDetails.execute();

            String createProposerGrp =
                "SELECT TO_NUMBER(TO_CHAR(SYSDATE,'YYYY'))||LMS_PRP_CODE_SEQ.NEXTVAL FROM DUAL";
            CallableStatement insPropGrp = null;
            insPropGrp = conn.prepareCall(createProposerGrp);
            ResultSet rsGrp = insPropGrp.executeQuery();
            while (rs.next()) {
                //LOVCC.PrpCode = rsGrp.getBigDecimal(1);
                session.setAttribute("prpCode", rsGrp.getBigDecimal(1));
            }

            String insertProposerDetailsGrp =
                "INSERT INTO LMS_PROPOSERS(PRP_ACC_NO, PRP_BANK_ACC_NO, PRP_BBR_CODE, PRP_BUSINESS,PRP_CODE,PRP_CLNT_CODE,\n" +
                "                               PRP_DECLINED_PROP, PRP_DOB, PRP_DOMICILE_COUNTRIES, PRP_EMAIL, PRP_FAX, PRP_ID_REG_NO, \n" +
                "                               PRP_INCREASED_PREMIUM, PRP_SURNAME, PRP_OTHER_NAMES, PRP_PHYSICAL_ADDR, PRP_PIN, \n" +
                "                               PRP_POLICY_CANCELLED, PRP_POSTAL_ADDRESS, PRP_PROPOSER, PRP_REMARKS, PRP_SHT_DESC, \n" +
                "                               PRP_SPCL_TERMS,PRP_TEL, PRP_TEL2, PRP_TITLE,PRP_TYPE,PRP_CLASS_TYPE,PRP_ZIP_CODE,PRP_TOWN, PRP_COUNTRY,PRP_CLNT_SMS_TEL,PRP_CO_CODE,PRP_DOB_ADMITTED)\n" +
                "                       SELECT CLNT_ACCNT_NO, CLNT_BANK_ACC_NO, CLNT_BBR_CODE, ?,?,CLNT_CODE, \n" +
                "                               CLNT_DECLINED_PROP, CLNT_DOB, COU_NAME, CLNT_EMAIL_ADDRS, CLNT_FAX, CLNT_ID_REG_NO, \n" +
                "                               CLNT_INCREASED_PREMIUM, CLNT_NAME, CLNT_OTHER_NAMES, CLNT_PHYSICAL_ADDRS, CLNT_PIN, \n" +
                "                               CLNT_POLICY_CANCELLED, CLNT_POSTAL_ADDRS, CLNT_PROPOSER, CLNT_REMARKS, CLNT_SHT_DESC, \n" +
                "                               CLNT_SPCL_TERMS, CLNT_TEL, CLNT_TEL2, CLNT_TITLE, 'Both','G',CLNT_ZIP_CODE,TWN_NAME, COU_NAME,CLNT_SMS_TEL, ?, 'Y'\n" +
                "                       FROM TQC_CLIENTS,TQC_TOWNS,TQC_COUNTRIES\n" +
                "                       WHERE CLNT_CODE = ?\n" +
                "                       AND COU_CODE(+) = CLNT_COU_CODE\n" +
                "                       AND TWN_CODE(+) = CLNT_TWN_CODE";

            CallableStatement instprpDetailsGrp = null;
            instprpDetailsGrp = conn.prepareCall(insertProposerDetailsGrp);
            instprpDetailsGrp.setString(1,
                                        (String)session.getAttribute("occupationDesc"));
            instprpDetailsGrp.setBigDecimal(2,
                                            (BigDecimal)session.getAttribute("prpCode"));
            instprpDetailsGrp.setBigDecimal(3,
                                            (BigDecimal)session.getAttribute("occupationCode"));
            instprpDetailsGrp.setBigDecimal(4,
                                            (BigDecimal)session.getAttribute("ClientCode"));
            instprpDetailsGrp.execute();

            conn.close();
            //ScreenPosition = 0;
            session.setAttribute("ScreenPosition", 0);
            AdfFacesContext.getCurrentInstance().returnFromDialog(GlobalCC.dialogName,
                                                                  null);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }

        return null;
    }

    public String RefreshComponents() {

        direct.setValue("N");
        postalAddress.setValue(null);
        status.setValue(null);
        accNo.setValue(null);
        emailAddress.setValue(null);
        runOff.setValue("N");
        id.setValue(null);
        telephone.setValue(null);
        holdingCompany.setValue("N");
        title.setValue(null);
        smsNo.setValue(null);
        specialTerms.setValue("N");
        firstName.setValue(null);
        fax.setValue(null);
        cancelledPolicy.setValue("N");
        middleName.setValue(null);
        idRegNo.setValue(null);
        increasedPremium.setValue("N");
        surname.setValue(null);
        piNNumber.setValue(null);
        declinedProposal.setValue("N");
        physicalAddress.setValue(null);
        wef.setValue(null);
        wet.setValue(null);
        doB.setValue(null);
        status.setValue("A");
        remarks.setValue(null);
        withdrawalReason.setValue(null);
        objOccupationDesc.setValue(null);
        searchCriteriaLbl.setVisible(true);
        searchCriteria.setVisible(true);

        //LOVCC.occupationCode = null;
        session.setAttribute("occupationCode", null);
        //LOVCC.countryCode = null;
        session.setAttribute("countryCode", null);
        //LOVCC.countryShtDesc = null;
        session.setAttribute("countryShtDesc", null);
        countryDesc.setValue(null);
        //LOVCC.townCode = null;
        session.setAttribute("townCode", null);
        //LOVCC.townName = null;
        session.setAttribute("townName", null);
        townDesc.setValue(null);

        AdfFacesContext.getCurrentInstance().addPartialTarget(status);
        AdfFacesContext.getCurrentInstance().addPartialTarget(direct);
        AdfFacesContext.getCurrentInstance().addPartialTarget(postalAddress);
        AdfFacesContext.getCurrentInstance().addPartialTarget(status);
        AdfFacesContext.getCurrentInstance().addPartialTarget(accNo);
        AdfFacesContext.getCurrentInstance().addPartialTarget(emailAddress);
        AdfFacesContext.getCurrentInstance().addPartialTarget(runOff);
        AdfFacesContext.getCurrentInstance().addPartialTarget(id);
        AdfFacesContext.getCurrentInstance().addPartialTarget(telephone);
        AdfFacesContext.getCurrentInstance().addPartialTarget(holdingCompany);
        AdfFacesContext.getCurrentInstance().addPartialTarget(title);
        AdfFacesContext.getCurrentInstance().addPartialTarget(smsNo);
        AdfFacesContext.getCurrentInstance().addPartialTarget(specialTerms);
        AdfFacesContext.getCurrentInstance().addPartialTarget(firstName);
        AdfFacesContext.getCurrentInstance().addPartialTarget(fax);
        AdfFacesContext.getCurrentInstance().addPartialTarget(cancelledPolicy);
        AdfFacesContext.getCurrentInstance().addPartialTarget(middleName);
        AdfFacesContext.getCurrentInstance().addPartialTarget(idRegNo);
        AdfFacesContext.getCurrentInstance().addPartialTarget(increasedPremium);
        AdfFacesContext.getCurrentInstance().addPartialTarget(surname);
        AdfFacesContext.getCurrentInstance().addPartialTarget(piNNumber);
        AdfFacesContext.getCurrentInstance().addPartialTarget(declinedProposal);
        AdfFacesContext.getCurrentInstance().addPartialTarget(physicalAddress);
        AdfFacesContext.getCurrentInstance().addPartialTarget(wef);
        AdfFacesContext.getCurrentInstance().addPartialTarget(wet);
        AdfFacesContext.getCurrentInstance().addPartialTarget(doB);
        AdfFacesContext.getCurrentInstance().addPartialTarget(remarks);
        AdfFacesContext.getCurrentInstance().addPartialTarget(withdrawalReason);

        return null;
    }

    /*public String viewClientDetails() {
        String query = "begin ? := tqc_clients_pkg.get_client_dtls(?); end;";
        CallableStatement cst1 = null;
        Connection conn = null;

        try {
            DBConnector datahandler = new DBConnector();

            conn = datahandler.getDatabaseConn();

            cst1 = conn.prepareCall(query);
            cst1.registerOutParameter(1,
                                      OracleTypes.CURSOR); //authorization code
            cst1.setBigDecimal(2, (BigDecimal)session.getAttribute("ClientCode"));
            //cst1.setInt(2,842713);
            cst1.execute();

            ResultSet rs = (ResultSet)cst1.getObject(1);
            while (rs.next()) {
                if (rs.getString(32) == null) {
                    //rdCorporate.setDisabled(true);
                    //rdIndividual.setDisabled(true);
                    clientType.setDisabled(true);
                } else if (rs.getString(32).equalsIgnoreCase("I")) {
                    //rdIndividual.setSelected(true);
                    //rdCorporate.setSelected(false);
                    //rdCorporate.setDisabled(true);
                    //rdIndividual.setDisabled(true);
                    clientType.setDisabled(true);
                    clientType.setValue("I");
                } else if (rs.getString(32).equalsIgnoreCase("C")) {
                    //rdCorporate.setSelected(true);
                    //rdIndividual.setSelected(false);
                    //rdCorporate.setDisabled(true);
                    //rdIndividual.setDisabled(true);
                    clientType.setDisabled(true);
                    clientType.setValue("C");
                }
                dateCreated.setValue(rs.getDate(43));
                createdBy.setValue(rs.getString(40));
                direct.setValue(rs.getString(46));
                direct.setDisabled(false);
                postalAddress.setValue(rs.getString(9));
                postalAddress.setDisabled(true);
                surname.setValue(rs.getString(3));
                surname.setDisabled(true);
                wef.setValue(rs.getDate(27));
                wef.setDisabled(true);
                status.setValue(rs.getString(17));
                status.setDisabled(true);
                accNo.setValue(rs.getString(25));
                emailAddress.setValue(rs.getString(14));
                emailAddress.setDisabled(true);
                id.setValue(rs.getString(2));
                telephone.setValue(rs.getString(15));
                telephone.setDisabled(true);
                runOff.setValue(rs.getString(44));
                runOff.setDisabled(true);
                title.setValue(rs.getString(33));
                title.setDisabled(true);
                smsNo.setValue(rs.getString(41));
                firstName.setValue(rs.getString(4));
                firstnameLabel.setValue("Other Names");
                middleNameLabel.setVisible(false);
                middleName.setVisible(false);
                fax.setValue(rs.getString(18));
                idRegNo.setValue(rs.getString(5));
                piNNumber.setValue(rs.getString(7));
                physicalAddress.setValue(rs.getString(8));
                wet.setValue(rs.getDate(28));
                doB.setValue(rs.getDate(6));
                remarks.setValue(rs.getString(19));
                withdrawalReason.setValue(rs.getString(29));
                //searchCriteria.setValue(null);
                bankAccount.setValue(rs.getString(37));
                bankDesc.setValue(rs.getString(36));
                domicileCountry.setValue(rs.getString(26));
                sectorDesc.setValue(rs.getString(30));
                townDesc.setValue(rs.getString(11));
                countryDesc.setValue(rs.getString(13));
                specialTerms.setValue(rs.getString(20));
                declinedProposal.setValue(rs.getString(21));
                increasedPremium.setValue(rs.getString(22));
                cancelledPolicy.setValue(rs.getString(23));
                holdingCompany.setValue(rs.getString(24));

                session.setAttribute("stateCode", rs.getBigDecimal(54));
                stateDesc.setValue(rs.getString(55));
                session.setAttribute("occupationCode",  rs.getBigDecimal(56));
                objOccupationDesc.setValue(rs.getString(57));


                cancelledPolicy.setDisabled(true);
                holdingCompany.setDisabled(true);
                fax.setDisabled(true);
                increasedPremium.setDisabled(true);
                declinedProposal.setDisabled(true);
                specialTerms.setDisabled(true);
                firstName.setDisabled(true);
                smsNo.setDisabled(true);
                idRegNo.setDisabled(true);
                piNNumber.setDisabled(true);
                physicalAddress.setDisabled(true);
                wet.setDisabled(true);
                doB.setDisabled(true);
                remarks.setDisabled(true);
                withdrawalReason.setDisabled(true);
                //searchCriteria.setDisabled(true);
                countryButton.setDisabled(true);
                townButton.setDisabled(true);
                sectorButton.setDisabled(true);
                domicileButton.setDisabled(true);
                branchButton.setDisabled(true);
                bankAccount.setDisabled(true);
            }
            conn.close();
        } catch (Exception e) {
           GlobalCC.EXCEPTIONREPORTING(conn, e);
        }


        return null;
    }

    public String editClientDetails() {
        String query = "begin ? := tqc_clients_pkg.get_client_dtls(?); end;";
        CallableStatement cst1 = null;
        Connection conn=null;

        try {
            DBConnector datahandler = new DBConnector();

            conn = datahandler.getDatabaseConn();

            cst1 = conn.prepareCall(query);
            cst1.registerOutParameter(1,
                                      OracleTypes.CURSOR); //authorization code
            cst1.setBigDecimal(2, (BigDecimal)session.getAttribute("ClientCode"));
            cst1.execute();

            ResultSet rs = (ResultSet)cst1.getObject(1);
            while (rs.next()) {
                if (rs.getString(32) == null) {
                    clientType.setDisabled(false);
                } else if (rs.getString(32).equalsIgnoreCase("I")) {
                    clientType.setDisabled(false);
                    clientType.setValue("I");
                } else if (rs.getString(32).equalsIgnoreCase("C")) {
                    clientType.setDisabled(false);
                    clientType.setValue("C");
                }
                dateCreated.setValue(rs.getDate(43));
                createdBy.setValue(rs.getString(40));
                direct.setValue(rs.getString(46));
                direct.setDisabled(false);
                postalAddress.setValue(rs.getString(9));
                postalAddress.setDisabled(false);
                MiddleName = null;
                LastName = rs.getString(3);
                FirstName = rs.getString(4);
                PostalAddress = rs.getString(9);
                PINNumber = rs.getString(7);
                surname.setValue(rs.getString(3));
                surname.setDisabled(false);
                wef.setValue(rs.getDate(27));
                wef.setDisabled(false);
                status.setValue(rs.getString(17));
                status.setDisabled(false);
                accNo.setValue(rs.getString(25));
                emailAddress.setValue(rs.getString(14));
                emailAddress.setDisabled(false);
                id.setValue(rs.getString(2));
                telephone.setValue(rs.getString(15));
                telephone.setDisabled(false);
                runOff.setValue(rs.getString(44));
                runOff.setDisabled(false);
                title.setValue(rs.getString(33));
                title.setDisabled(false);
                smsNo.setValue(rs.getString(41));
                firstName.setValue(rs.getString(4));
                firstnameLabel.setValue("Firstname");
                middleNameLabel.setVisible(true);
                middleName.setVisible(true);
                fax.setValue(rs.getString(18));
                idRegNo.setValue(rs.getString(5));
                piNNumber.setValue(rs.getString(7));
                physicalAddress.setValue(rs.getString(8));
                wet.setValue(rs.getDate(28));
                doB.setValue(rs.getDate(6));
                remarks.setValue(rs.getString(19));
                withdrawalReason.setValue(rs.getString(29));

                bankAccount.setValue(rs.getString(37));
                bankDesc.setValue(rs.getString(36));
                domicileCountry.setValue(rs.getString(26));
                sectorDesc.setValue(rs.getString(30));
                townDesc.setValue(rs.getString(11));
                countryDesc.setValue(rs.getString(13));
                specialTerms.setValue(rs.getString(20));
                declinedProposal.setValue(rs.getString(21));
                increasedPremium.setValue(rs.getString(22));
                cancelledPolicy.setValue(rs.getString(23));
                holdingCompany.setValue(rs.getString(24));

                session.setAttribute("stateCode", rs.getBigDecimal(54));
                stateDesc.setValue(rs.getString(55));
                session.setAttribute("occupationCode",  rs.getBigDecimal(56));
                objOccupationDesc.setValue(rs.getString(57));


                cancelledPolicy.setDisabled(false);
                holdingCompany.setDisabled(false);
                fax.setDisabled(false);
                increasedPremium.setDisabled(false);
                declinedProposal.setDisabled(false);
                specialTerms.setDisabled(false);
                firstName.setDisabled(false);
                smsNo.setDisabled(false);
                idRegNo.setDisabled(false);
                piNNumber.setDisabled(false);
                physicalAddress.setDisabled(false);
                wet.setDisabled(false);
                doB.setDisabled(false);
                remarks.setDisabled(false);
                withdrawalReason.setDisabled(false);
                //searchCriteria.setDisabled(false);
                countryButton.setDisabled(false);
                townButton.setDisabled(false);
                sectorButton.setDisabled(false);
                domicileButton.setDisabled(false);
                branchButton.setDisabled(false);
                bankAccount.setDisabled(false);


            }

            conn.close();
        } catch (Exception e) {
           GlobalCC.EXCEPTIONREPORTING(conn, e);
        }

        return null;
    }
*/

    public String AddClientSystem() {
        BigDecimal SysCode = null;

        DCIteratorBinding dciter =
            ADFUtils.findIterator("findUnallocatedClientSystemsIterator");
        RowKeySet set = availableSystems.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));

            Row r = dciter.getCurrentRow();

            SysCode = (BigDecimal)r.getAttribute("unallocatedSystemCode");

        }


        String Query = "begin tqc_clients_pkg.alloc_clnt_system(?,?); end;";

        CallableStatement cst = null;
        try {

            DBConnector datahandler = new DBConnector();
            Connection conn;
            conn = datahandler.getDatabaseConn();
            cst = conn.prepareCall(Query);

            cst.setBigDecimal(1,
                              (BigDecimal)session.getAttribute("ClientCode"));
            cst.setBigDecimal(2, SysCode);

            cst.execute();
            conn.close();

            ADFUtils.findIterator("findUnallocatedClientSystemsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(availableSystems);
            ADFUtils.findIterator("findallocatedClientSystemsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(assignedsystems);

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String CheckSimilarClients() {

        if (!similarClientsPanel.isRendered()) {
            ADFUtils.findIterator("findSimilarClientsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(existingClients);
            similarClientsPanel.setRendered(true);
            saveButton.setText("Save Client");
        } else {
            similarClientsPanel.setRendered(false);
            SaveClientDetails();

        }

        return null;
    }

    public String RemoveClientSystem() {
        BigDecimal SysCode = null;

        DCIteratorBinding dciter =
            ADFUtils.findIterator("findallocatedClientSystemsIterator");
        RowKeySet set = assignedsystems.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));

            Row r = dciter.getCurrentRow();

            SysCode = (BigDecimal)r.getAttribute("allocatefSystemCode");

        }

        String Query = "begin tqc_clients_pkg.unalloc_clnt_system(?,?); end;";

        CallableStatement cst = null;
        try {

            DBConnector datahandler = new DBConnector();
            Connection conn;
            conn = datahandler.getDatabaseConn();
            cst = conn.prepareCall(Query);

            cst.setBigDecimal(1,
                              (BigDecimal)session.getAttribute("ClientCode"));
            cst.setBigDecimal(2, SysCode);

            cst.execute();
            conn.close();

            ADFUtils.findIterator("findUnallocatedClientSystemsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(availableSystems);
            ADFUtils.findIterator("findallocatedClientSystemsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(assignedsystems);

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String clientSelected() {

        DCIteratorBinding dciter =
            ADFUtils.findIterator("findUserByAgencyCodeIterator");
        RowKeySet set = clientLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));

            Row r = dciter.getCurrentRow();
            //LOVCC.PrpCode = (BigDecimal)r.getAttribute("clientCode");
            session.setAttribute("prpCode", r.getAttribute("clientCode"));

            LOVCC.clientName = (String)r.getAttribute("shortDescription");
            LOVCC.clientName = (String)r.getAttribute("fullname");

            clientDesc.setValue(LOVCC.clientName);
        }

        return null;
    }

    public String CountrySelected() {

        DCIteratorBinding dciter =
            ADFUtils.findIterator("findCountriesIterator");
        RowKeySet set = countriesLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));

            Row r = dciter.getCurrentRow();
            //LOVCC.countryCode = (BigDecimal)r.getAttribute("countryCode");
            //LOVCC.countryShtDesc = (String)r.getAttribute("countryShtDesc");
            session.setAttribute("countryCode", r.getAttribute("countryCode"));
            session.setAttribute("countryShtDesc",
                                 r.getAttribute("countryShtDesc"));

            countryDesc.setValue(r.getAttribute("countryName"));

            //LOVCC.townCode = null;
            //LOVCC.townName = null;
            session.setAttribute("stateCode", null);
            stateDesc.setValue(null);
            session.setAttribute("townCode", null);
            session.setAttribute("townName", null);
            townDesc.setValue(null);
        }
        ADFUtils.findIterator("FindStatesIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(statesLOV);
        return null;
    }

    public String DomicileCountrySelected() {

        DCIteratorBinding dciter =
            ADFUtils.findIterator("findCountries1Iterator");
        RowKeySet set = domicilecountryLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));

            Row r = dciter.getCurrentRow();
            //LOVCC.domicileCountry = (BigDecimal)r.getAttribute("countryCode");
            session.setAttribute("domicileCountry",
                                 r.getAttribute("countryCode"));

            domicileCountry.setValue(r.getAttribute("countryName"));
        }

        return null;
    }

    public String SectorSelected() {

        DCIteratorBinding dciter =
            ADFUtils.findIterator("findSectorsIterator");
        RowKeySet set = sectorLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));

            Row r = dciter.getCurrentRow();
            //LOVCC.sectorCode = (BigDecimal)r.getAttribute("sectorCode");
            //LOVCC.sectorName = (String)r.getAttribute("sectorName");
            session.setAttribute("sectorCode", r.getAttribute("sectorCode"));
            session.setAttribute("sectorName", r.getAttribute("sectorName"));

            sectorDesc.setValue(r.getAttribute("sectorName"));
        }
        ADFUtils.findIterator("findTownsIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(townLOV);
        return null;
    }

    public String TownSelected() {

        DCIteratorBinding dciter = ADFUtils.findIterator("findTownsIterator");
        RowKeySet set = townLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));

            Row r = dciter.getCurrentRow();
            //LOVCC.townCode = (BigDecimal)r.getAttribute("townCode");
            //LOVCC.townName = (String)r.getAttribute("townName");
            session.setAttribute("townCode", r.getAttribute("townCode"));
            session.setAttribute("townName", r.getAttribute("townName"));

            townDesc.setValue(r.getAttribute("townName"));
        }

        return null;
    }

    public String StatesSelected() {

        DCIteratorBinding dciter = ADFUtils.findIterator("FindStatesIterator");
        RowKeySet set = statesLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));

            Row r = dciter.getCurrentRow();
            session.setAttribute("stateCode", r.getAttribute("STS_CODE"));
            //LOVCC.townName = (String)r.getAttribute("STS_NAME");

            stateDesc.setValue(r.getAttribute("STS_NAME"));
        }
        session.setAttribute("townCode", null);
        session.setAttribute("townName", null);
        ADFUtils.findIterator("findTownsIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(townLOV);

        return null;
    }

    public String BankBranchSelected() {

        DCIteratorBinding dciter = ADFUtils.findIterator("findBanks1Iterator");
        RowKeySet set = banksLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));

            Row r = dciter.getCurrentRow();
            //LOVCC.branchCode = (BigDecimal)r.getAttribute("bankBranchCode");
            //LOVCC.branchName = (String)r.getAttribute("branchName");
            session.setAttribute("branchCode",
                                 r.getAttribute("bankBranchCode"));
            session.setAttribute("branchName", r.getAttribute("branchName"));

            bankDesc.setValue(r.getAttribute("branchName"));
        }

        return null;
    }

    public String resetValues() {

        //rdCorporate.setDisabled(false);
        //rdIndividual.setDisabled(false);
        clientType.setDisabled(false);
        direct.setDisabled(false);
        postalAddress.setDisabled(false);
        surname.setDisabled(false);
        wef.setDisabled(false);
        status.setDisabled(false);
        emailAddress.setDisabled(false);
        telephone.setDisabled(false);
        runOff.setDisabled(false);
        title.setDisabled(false);
        firstnameLabel.setValue("Firstname");
        middleNameLabel.setVisible(true);
        middleName.setVisible(true);
        cancelledPolicy.setDisabled(false);
        holdingCompany.setDisabled(false);
        fax.setDisabled(false);
        increasedPremium.setDisabled(false);
        declinedProposal.setDisabled(false);
        specialTerms.setDisabled(false);
        firstName.setDisabled(false);
        smsNo.setDisabled(false);
        idRegNo.setDisabled(false);
        piNNumber.setDisabled(false);
        physicalAddress.setDisabled(false);
        wet.setDisabled(false);
        doB.setDisabled(false);
        remarks.setDisabled(false);
        withdrawalReason.setDisabled(false);
        //searchCriteria.setDisabled(false);
        countryButton.setDisabled(false);
        townButton.setDisabled(false);
        sectorButton.setDisabled(false);
        domicileButton.setDisabled(false);
        branchButton.setDisabled(false);
        bankAccount.setDisabled(false);


        return null;
    }

    public String resetValuesEditView() {

        //rdCorporate.setDisabled(true);
        //rdIndividual.setDisabled(true);
        clientType.setDisabled(true);
        direct.setDisabled(true);
        postalAddress.setDisabled(true);
        surname.setDisabled(true);
        surnameLabel.setValue("Corporation Name");
        wef.setDisabled(true);
        status.setDisabled(true);
        emailAddress.setDisabled(true);
        telephone.setDisabled(true);
        runOff.setDisabled(true);
        title.setDisabled(true);
        //firstnameLabel.setValue("Other Names");
        firstnameLabel.setVisible(false);
        middleNameLabel.setVisible(false);
        middleName.setVisible(false);
        cancelledPolicy.setDisabled(true);
        holdingCompany.setDisabled(true);
        fax.setDisabled(true);
        increasedPremium.setDisabled(true);
        declinedProposal.setDisabled(true);
        specialTerms.setDisabled(true);
        firstName.setDisabled(true);
        smsNo.setDisabled(true);
        idRegNo.setDisabled(true);
        piNNumber.setDisabled(true);
        physicalAddress.setDisabled(true);
        wet.setDisabled(true);
        doB.setDisabled(true);
        remarks.setDisabled(true);
        withdrawalReason.setDisabled(true);
        //searchCriteria.setDisabled(true);
        countryButton.setDisabled(true);
        townButton.setDisabled(true);
        sectorButton.setDisabled(true);
        domicileButton.setDisabled(true);
        branchButton.setDisabled(true);
        bankAccount.setDisabled(true);

        searchCriteriaLbl.setVisible(false);
        searchCriteria.setVisible(false);

        return null;
    }

    public String cmdNext() {
        if (transType.getValue().toString().equalsIgnoreCase("C")) {
            //selectClientToViewEdit.setRendered(false);
            //AddEdit = "A";
            session.setAttribute("AddEdit", "A");
            saveButton.setRendered(true);
            nextButton.setRendered(false);
            resetValues();
            if (this.clientTask.isRendered()) {
                RefreshComponents();
                setDefaultCauntry();
            }
            //RefreshComponents();
        } else if (transType.getValue().toString().equalsIgnoreCase("E")) {
            if (allClientDesc.getValue() == null) {
                GlobalCC.INFORMATIONREPORTING("Select a Client");
                return null;
            }
            if (this.clientTask.isRendered()) {
                //RefreshComponents();
            }
            saveButton.setRendered(false);
            //AddEdit = "E";
            session.setAttribute("AddEdit", "E");
        }
        if (transType.getValue().toString().equalsIgnoreCase("V")) {
            if (allClientDesc.getValue() == null) {
                GlobalCC.INFORMATIONREPORTING("Select a Client");
                return null;
            }
            resetValuesEditView();

            this.clientTask.setRendered(false);
            this.addClientDetails.setRendered(true);
            this.confirmClientDetails.setRendered(false);
            this.nextButton.setRendered(false);
            this.prevButton.setRendered(false);
            this.clientTabbedPanel.setRendered(true);


        } else {

            if (this.clientTask.isRendered()) {
                Integer po = (Integer)session.getAttribute("ScreenPosition");
                po = po + 1;
                session.setAttribute("ScreenPosition", po);
            } else if (this.addClientDetails.isRendered()) {

                if (surname.getValue() == null) {
                    GlobalCC.INFORMATIONREPORTING("Enter Surname");
                    return null;
                }
                if (direct.getValue() == null) {
                    GlobalCC.INFORMATIONREPORTING("Direct Client?");
                    return null;
                }
                /*if (wef.getValue() == null) {
                    String message = "Enter WEF Date";
                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                  message,
                                                                                  message));

                    return null;
                }*/
                BigDecimal Occ =
                    (BigDecimal)session.getAttribute("occupationCode");
                if (Occ == null) {
                    GlobalCC.errorValueNotEntered("Select The Occupation");
                    return null;
                }
                /*if (telephone.getValue() == null) {
                    GlobalCC.INFORMATIONREPORTING("Enter a Telephone Number");
                    return null;
                }*/
                BigDecimal stat =
                    (BigDecimal)session.getAttribute("stateCode");
               /* if (stat == null) {
                    GlobalCC.errorValueNotEntered("Select The state");
                    return null;
                }*/

                if (session.getAttribute("brnCode") == null) {
                    GlobalCC.errorValueNotEntered("Select The Branch");
                    return null;
                }
                /*
                if(doB.getValue()==null){
                    GlobalCC.errorValueNotEntered("ENTER THE DATE OF BIRTH");
                    return null;
                }
                */
                String AddEdit = (String)session.getAttribute("AddEdit");
                if (AddEdit.equalsIgnoreCase("E")) {
                    similarClientsPanel.setRendered(false);
                    SaveClientDetails();
                    return null;
                } else if (!this.similarClientsPanel.isRendered()) {
                    ADFUtils.findIterator("findSimilarClientsIterator").executeQuery();
                    AdfFacesContext.getCurrentInstance().addPartialTarget(existingClients);
                    similarClientsPanel.setRendered(true);
                }
            } else if (this.similarClientsPanel.isRendered()) {
                SaveClientDetails();

            } else {
                //do nothing
            }
            ScreenRendering();

        }

        return null;
    }

    public String cmdPrevious() {
        saveButton.setRendered(false);
        nextButton.setRendered(true);
        //ScreenPosition = 0;
        session.setAttribute("ScreenPosition", 0);

        ScreenRendering();
        return null;
    }

    public String ScreenRendering() {
        if (this.searchCriteria.getValue() == null) {
            SearchCriteria = null;
        } else {
            SearchCriteria = this.searchCriteria.getValue().toString();
        }

        Integer Scrnposition = (Integer)session.getAttribute("ScreenPosition");
        switch (Scrnposition) {
        case 0:
            //this.selectClientToViewEdit.setRendered(false);
            this.addClientDetails.setRendered(false);
            this.clientTabbedPanel.setRendered(false);
            this.clientTask.setRendered(true);
            this.confirmClientDetails.setRendered(false);
            prevButton.setRendered(false);
            nextButton.setRendered(true);
            similarClientsPanel.setRendered(false);
            nextButton.setText("Next");
            break;
        case 1:
            this.addClientDetails.setRendered(true);
            this.clientTabbedPanel.setRendered(true);
            if ((transType.getValue().toString().equalsIgnoreCase("C")) ||
                (transType.getValue().toString().equalsIgnoreCase("E"))) {
                if (this.addClientDetails.isRendered()) {
                    clientTypeListener(null);
                } else {
                    RefreshComponents();
                }

                nextButton.setText("Save Client");
            } else {

                nextButton.setText("Save Client");
            }
            this.clientTask.setRendered(false);
            this.confirmClientDetails.setRendered(false);
            prevButton.setRendered(true);

            break;
        case 2:
            this.addClientDetails.setRendered(false);
            this.clientTabbedPanel.setRendered(false);
            if (transType.getValue().toString().equalsIgnoreCase("C")) {

            } else {

            }
            this.clientTask.setRendered(false);
            this.confirmClientDetails.setRendered(true);
            //this.selectClientToViewEdit.setRendered(false);
            prevButton.setRendered(true);
            nextButton.setText("Save Client");
            break;
        }

        return null;
    }

    public void CreateClientListener(AttributeChangeEvent attributeChangeEvent) {

    }

    public void SearchClientListener(AttributeChangeEvent attributeChangeEvent) {

    }

    public void CreateClientlsnr(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if (transType.getValue().toString().equalsIgnoreCase("C")) {
            //ClientCode = null;
            session.setAttribute("ClientCode", null);
            //searchClients.setVisible(false);
            //AddEdit = "A";
            session.setAttribute("AddEdit", "A");
            // AdfFacesContext.getCurrentInstance().addPartialTarget(searchClients);
        }
    }

    public void searchClientlsnr(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if (transType.getValue().toString().equalsIgnoreCase("E")) {
            searchClients.setVisible(true);
            //AddEdit = "E";
            session.setAttribute("AddEdit", "E");
            AdfFacesContext.getCurrentInstance().addPartialTarget(searchClients);
        }

    }

    public void firstNameListener(AttributeChangeEvent attributeChangeEvent) {
        // Add event code here...


    }

    public void middlenamelistener(AttributeChangeEvent attributeChangeEvent) {
        // Add event code here...


    }

    public void surnamelistener(AttributeChangeEvent attributeChangeEvent) {
        // Add event code here...


    }

    public void postalAddress(AttributeChangeEvent attributeChangeEvent) {
        // Add event code here...

    }

    public void pinnumberlistener(AttributeChangeEvent attributeChangeEvent) {
        // Add event code here...

    }

    public void searchlistener(AttributeChangeEvent attributeChangeEvent) {
        // Add event code here...

    }

    public void firstnameListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        FirstName = firstName.getValue().toString();
    }

    public void middlenamelistener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        MiddleName = middleName.getValue().toString();
    }

    public void lastnamelistener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        LastName = surname.getValue().toString();
    }

    public void postallistener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        PostalAddress = postalAddress.getValue().toString();
    }

    public void pinlistener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        PINNumber = piNNumber.getValue().toString();
    }

    public void searchlistener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        //SearchCriteria = searchCriteria.getValue().toString();
    }

    public void directListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if (direct.getValue() == null) {
            Direct = null;
        } else {
            Direct = direct.getValue().toString();
        }


    }

    public void idListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...

        id1 = id.getValue().toString();
    }

    public void physicalAddressListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        PhyAddress = physicalAddress.getValue().toString();

    }

    public void regListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        RegNo = idRegNo.getValue().toString();
    }

    public void titleListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        TitleListener = title.getValue().toString();
    }

    public void telephonelistener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...

        telephone1 = telephone.getValue().toString();


    }

    public void smslistener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        sms = smsNo.getValue().toString();
    }

    public void faxListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        fax1 = fax.getValue().toString();
    }

    public void emailListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        email = emailAddress.getValue().toString();
    }

    public void bankListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        bankAcc = bankAccount.getValue().toString();
    }

    public void remarksListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        remarks1 = remarks.getValue().toString();
    }

    public void WefListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        // Date coverFrom = new Date();
        SimpleDateFormat sdf1 =
            new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MMM-yyyy");

        java.util.Date lossDate = new java.util.Date();


        lossDate = null;


        try {
            lossDate = sdf1.parse(wef.getValue().toString());
            WEFDate = sdf2.format(lossDate);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }


    }

    public void wetlistener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        SimpleDateFormat sdf1 =
            new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MMM-yyyy");

        java.util.Date notificationDate = new java.util.Date();

        notificationDate = null;

        try {
            notificationDate = sdf1.parse(wet.getValue().toString());
            WETDate = sdf2.format(notificationDate);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }


    }

    public void dobListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        SimpleDateFormat sdf1 =
            new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MMM-yyyy");

        java.util.Date DOB = new java.util.Date();


        try {
            DOB = sdf1.parse(doB.getValue().toString());
            DOBDate = sdf2.format(DOB);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }


    }

    public void setClientDesc(RichInputText clientDesc) {
        this.clientDesc = clientDesc;
    }

    public RichInputText getClientDesc() {
        return clientDesc;
    }

    public void setClientLOV(RichTable clientLOV) {
        this.clientLOV = clientLOV;
    }

    public RichTable getClientLOV() {
        return clientLOV;
    }

    public void setClientButton(RichCommandButton clientButton) {
        this.clientButton = clientButton;
    }

    public RichCommandButton getClientButton() {
        return clientButton;
    }

    public void setCountriesLOV(RichTable countriesLOV) {
        this.countriesLOV = countriesLOV;
    }

    public RichTable getCountriesLOV() {
        return countriesLOV;
    }

    public void setCountryDesc(RichInputText countryDesc) {
        this.countryDesc = countryDesc;
    }

    public RichInputText getCountryDesc() {
        return countryDesc;
    }

    public void setTownLOV(RichTable townLOV) {
        this.townLOV = townLOV;
    }

    public RichTable getTownLOV() {
        return townLOV;
    }

    public void setTownDesc(RichInputText townDesc) {
        this.townDesc = townDesc;
    }

    public RichInputText getTownDesc() {
        return townDesc;
    }

    public void setClientsTab(RichPanelTabbed clientsTab) {
        this.clientsTab = clientsTab;
    }

    public RichPanelTabbed getClientsTab() {
        return clientsTab;
    }

    public void setSelectClientAction(RichShowDetailItem selectClientAction) {
        this.selectClientAction = selectClientAction;
    }

    public RichShowDetailItem getSelectClientAction() {
        return selectClientAction;
    }

    public void setClientDetails(RichShowDetailItem clientDetails) {
        this.clientDetails = clientDetails;
    }

    public RichShowDetailItem getClientDetails() {
        return clientDetails;
    }

    public void setClientSystems(RichShowDetailItem clientSystems) {
        this.clientSystems = clientSystems;
    }

    public RichShowDetailItem getClientSystems() {
        return clientSystems;
    }

    public void setPrevButton(RichCommandButton prevButton) {
        this.prevButton = prevButton;
    }

    public RichCommandButton getPrevButton() {
        return prevButton;
    }

    public void setNextButton(RichCommandButton nextButton) {
        this.nextButton = nextButton;
    }

    public RichCommandButton getNextButton() {
        return nextButton;
    }

    public void setSectorLOV(RichTable sectorLOV) {
        this.sectorLOV = sectorLOV;
    }

    public RichTable getSectorLOV() {
        return sectorLOV;
    }

    public void setSectorDesc(RichInputText sectorDesc) {
        this.sectorDesc = sectorDesc;
    }

    public RichInputText getSectorDesc() {
        return sectorDesc;
    }

    public void setDomicileCountry(RichInputText domicileCountry) {
        this.domicileCountry = domicileCountry;
    }

    public RichInputText getDomicileCountry() {
        return domicileCountry;
    }

    public void setDomicilecountryLOV(RichTable domicilecountryLOV) {
        this.domicilecountryLOV = domicilecountryLOV;
    }

    public RichTable getDomicilecountryLOV() {
        return domicilecountryLOV;
    }

    public void setBanksLOV(RichTable banksLOV) {
        this.banksLOV = banksLOV;
    }

    public RichTable getBanksLOV() {
        return banksLOV;
    }

    public void setBankDesc(RichInputText bankDesc) {
        this.bankDesc = bankDesc;
    }

    public RichInputText getBankDesc() {
        return bankDesc;
    }

    public void setSearchClients(RichTable searchClients) {
        this.searchClients = searchClients;
    }

    public RichTable getSearchClients() {
        return searchClients;
    }

    public void setFullName(RichInputText fullName) {
        this.fullName = fullName;
    }

    public RichInputText getFullName() {
        return fullName;
    }

    public void setIdRegNo(RichInputText idRegNo) {
        this.idRegNo = idRegNo;
    }

    public RichInputText getIdRegNo() {
        return idRegNo;
    }

    public void setDoB(RichInputDate doB) {
        this.doB = doB;
    }

    public RichInputDate getDoB() {
        return doB;
    }

    public void setPiNNumber(RichInputText piNNumber) {
        this.piNNumber = piNNumber;
    }

    public RichInputText getPiNNumber() {
        return piNNumber;
    }

    public void setPhysicalAddress(RichInputText physicalAddress) {
        this.physicalAddress = physicalAddress;
    }

    public RichInputText getPhysicalAddress() {
        return physicalAddress;
    }

    public void setPostalAddress(RichInputText postalAddress) {
        this.postalAddress = postalAddress;
    }

    public RichInputText getPostalAddress() {
        return postalAddress;
    }

    public void setEmailAddress(RichInputText emailAddress) {
        this.emailAddress = emailAddress;
    }

    public RichInputText getEmailAddress() {
        return emailAddress;
    }

    public void setTelephone(RichInputText telephone) {
        this.telephone = telephone;
    }

    public RichInputText getTelephone() {
        return telephone;
    }

    public void setStatus(RichSelectOneChoice status) {
        this.status = status;
    }

    public RichSelectOneChoice getStatus() {
        return status;
    }

    public void setFax(RichInputText fax) {
        this.fax = fax;
    }

    public RichInputText getFax() {
        return fax;
    }

    public void setRemarks(RichInputText remarks) {
        this.remarks = remarks;
    }

    public RichInputText getRemarks() {
        return remarks;
    }

    public void setSpecialTerms(RichSelectOneChoice specialTerms) {
        this.specialTerms = specialTerms;
    }

    public RichSelectOneChoice getSpecialTerms() {
        return specialTerms;
    }

    public void setDeclinedProposal(RichSelectOneChoice declinedProposal) {
        this.declinedProposal = declinedProposal;
    }

    public RichSelectOneChoice getDeclinedProposal() {
        return declinedProposal;
    }

    public void setIncreasedPremium(RichSelectOneChoice increasedPremium) {
        this.increasedPremium = increasedPremium;
    }

    public RichSelectOneChoice getIncreasedPremium() {
        return increasedPremium;
    }

    public void setCancelledPolicy(RichSelectOneChoice cancelledPolicy) {
        this.cancelledPolicy = cancelledPolicy;
    }

    public RichSelectOneChoice getCancelledPolicy() {
        return cancelledPolicy;
    }

    public void setAccNo(RichInputText accNo) {
        this.accNo = accNo;
    }

    public RichInputText getAccNo() {
        return accNo;
    }

    public void setWef(RichInputDate wef) {
        this.wef = wef;
    }

    public RichInputDate getWef() {
        return wef;
    }

    public void setWet(RichInputDate wet) {
        this.wet = wet;
    }

    public RichInputDate getWet() {
        return wet;
    }

    public void setWithdrawalReason(RichInputText withdrawalReason) {
        this.withdrawalReason = withdrawalReason;
    }

    public RichInputText getWithdrawalReason() {
        return withdrawalReason;
    }

    public void setSurname(RichInputText surname) {
        this.surname = surname;
    }

    public RichInputText getSurname() {
        return surname;
    }

    public void setRdIndividual(RichSelectBooleanRadio rdIndividual) {
        this.rdIndividual = rdIndividual;
    }

    public RichSelectBooleanRadio getRdIndividual() {
        return rdIndividual;
    }

    public void setRdCorporate(RichSelectBooleanRadio rdCorporate) {
        this.rdCorporate = rdCorporate;
    }

    public RichSelectBooleanRadio getRdCorporate() {
        return rdCorporate;
    }

    public void setTitle(RichSelectOneChoice title) {
        this.title = title;
    }

    public RichSelectOneChoice getTitle() {
        return title;
    }

    public void setBankAccount(RichInputText bankAccount) {
        this.bankAccount = bankAccount;
    }

    public RichInputText getBankAccount() {
        return bankAccount;
    }

    public void setDirect(RichSelectOneChoice direct) {
        this.direct = direct;
    }

    public RichSelectOneChoice getDirect() {
        return direct;
    }

    public void setCreatedBy(RichInputText createdBy) {
        this.createdBy = createdBy;
    }

    public RichInputText getCreatedBy() {
        return createdBy;
    }

    public void setSmsNo(RichInputText smsNo) {
        this.smsNo = smsNo;
    }

    public RichInputText getSmsNo() {
        return smsNo;
    }

    public void setDateCreated(RichInputDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public RichInputDate getDateCreated() {
        return dateCreated;
    }

    public void setRunOff(RichSelectOneChoice runOff) {
        this.runOff = runOff;
    }

    public RichSelectOneChoice getRunOff() {
        return runOff;
    }

    public void setConfirmClient(RichShowDetailItem confirmClient) {
        this.confirmClient = confirmClient;
    }

    public RichShowDetailItem getConfirmClient() {
        return confirmClient;
    }

    public void setFirstName(RichInputText firstName) {
        this.firstName = firstName;
    }

    public RichInputText getFirstName() {
        return firstName;
    }

    public void setMiddleName(RichInputText middleName) {
        this.middleName = middleName;
    }

    public RichInputText getMiddleName() {
        return middleName;
    }

    public void setSearchCriteria(RichSelectOneChoice searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    public RichSelectOneChoice getSearchCriteria() {
        return searchCriteria;
    }

    public void setAvailableSystems(RichTable availableSystems) {
        this.availableSystems = availableSystems;
    }

    public RichTable getAvailableSystems() {
        return availableSystems;
    }

    public void setAssignedsystems(RichTable assignedsystems) {
        this.assignedsystems = assignedsystems;
    }

    public RichTable getAssignedsystems() {
        return assignedsystems;
    }

    public void setId(RichInputText id) {
        this.id = id;
    }

    public RichInputText getId() {
        return id;
    }

    public void setHoldingCompany(RichSelectOneChoice holdingCompany) {
        this.holdingCompany = holdingCompany;
    }

    public RichSelectOneChoice getHoldingCompany() {
        return holdingCompany;
    }

    public void setScreenPosition(int ScreenPosition) {
        //ClientAddDetails.ScreenPosition = (Integer)session.getAttribute("ScreenPosition");
    }

    public int getScreenPosition() {
        return (Integer)session.getAttribute("ScreenPosition");
    }

    public static void setClientshtCde(String ClientshtCde) {
        ClientAddDetails.ClientshtCde = ClientshtCde;
    }

    public static String getClientshtCde() {
        return ClientshtCde;
    }

    public static void setFirstName(String FirstName) {
        ClientAddDetails.FirstName = FirstName;
    }

    public static String getFirstName1() {
        return FirstName;
    }

    public static void setMiddleName(String MiddleName) {
        ClientAddDetails.MiddleName = MiddleName;
    }

    public static String getMiddleName1() {
        return MiddleName;
    }

    public static void setLastName(String LastName) {
        ClientAddDetails.LastName = LastName;
    }

    public static String getLastName() {
        return LastName;
    }

    public static void setPINNumber(String PINNumber) {
        ClientAddDetails.PINNumber = PINNumber;
    }

    public static String getPINNumber() {
        return PINNumber;
    }

    public static void setPostalAddress(String PostalAddress) {
        ClientAddDetails.PostalAddress = PostalAddress;
    }

    public static String getPostalAddress1() {
        return PostalAddress;
    }

    public static void setSearchCriteria(String SearchCriteria) {
        ClientAddDetails.SearchCriteria = SearchCriteria;
    }

    public static String getSearchCriteria1() {
        return SearchCriteria;
    }

    public void setUserName(RichInputText userName) {
        this.userName = userName;
    }

    public RichInputText getUserName() {
        return userName;
    }

    public void setFullNames(RichInputText fullNames) {
        this.fullNames = fullNames;
    }

    public RichInputText getFullNames() {
        return fullNames;
    }

    public void setPassword(RichInputText password) {
        this.password = password;
    }

    public RichInputText getPassword() {
        return password;
    }

    public void setPersonelRank(RichInputText personelRank) {
        this.personelRank = personelRank;
    }

    public RichInputText getPersonelRank() {
        return personelRank;
    }

    public void setUserstatus(RichSelectOneChoice userstatus) {
        this.userstatus = userstatus;
    }

    public RichSelectOneChoice getUserstatus() {
        return userstatus;
    }

    public void setAllowLogin(RichSelectOneChoice allowLogin) {
        this.allowLogin = allowLogin;
    }

    public RichSelectOneChoice getAllowLogin() {
        return allowLogin;
    }

    public void setWebemailAddress(RichInputText webemailAddress) {
        this.webemailAddress = webemailAddress;
    }

    public RichInputText getWebemailAddress() {
        return webemailAddress;
    }

    public void setWebClientAccounts(RichTable webClientAccounts) {
        this.webClientAccounts = webClientAccounts;
    }

    public RichTable getWebClientAccounts() {
        return webClientAccounts;
    }

    public void setWebAccTab(RichShowDetailItem webAccTab) {
        this.webAccTab = webAccTab;
    }

    public RichShowDetailItem getWebAccTab() {
        return webAccTab;
    }

    public void setExistingClients(RichTable existingClients) {
        this.existingClients = existingClients;
    }

    public RichTable getExistingClients() {
        return existingClients;
    }

    public void setUseClientButton(RichCommandButton useClientButton) {
        this.useClientButton = useClientButton;
    }

    public RichCommandButton getUseClientButton() {
        return useClientButton;
    }

    public void setClientTask(RichPanelBox clientTask) {
        this.clientTask = clientTask;
    }

    public RichPanelBox getClientTask() {
        return clientTask;
    }

    public void setRdEditClient(RichSelectBooleanRadio rdEditClient) {
        this.rdEditClient = rdEditClient;
    }

    public RichSelectBooleanRadio getRdEditClient() {
        return rdEditClient;
    }

    public void setAddClientDetails(RichPanelBox addClientDetails) {
        this.addClientDetails = addClientDetails;
    }

    public RichPanelBox getAddClientDetails() {
        return addClientDetails;
    }

    public void setConfirmClientDetails(RichPanelBox confirmClientDetails) {
        this.confirmClientDetails = confirmClientDetails;
    }

    public RichPanelBox getConfirmClientDetails() {
        return confirmClientDetails;
    }

    public void setFirstnameLabel(RichOutputLabel firstnameLabel) {
        this.firstnameLabel = firstnameLabel;
    }

    public RichOutputLabel getFirstnameLabel() {
        return firstnameLabel;
    }

    public void setMiddleNameLabel(RichOutputLabel middleNameLabel) {
        this.middleNameLabel = middleNameLabel;
    }

    public RichOutputLabel getMiddleNameLabel() {
        return middleNameLabel;
    }

    public void setCountryButton(RichCommandButton countryButton) {
        this.countryButton = countryButton;
    }

    public RichCommandButton getCountryButton() {
        return countryButton;
    }

    public void setTownButton(RichCommandButton townButton) {
        this.townButton = townButton;
    }

    public RichCommandButton getTownButton() {
        return townButton;
    }

    public void setSectorButton(RichCommandButton sectorButton) {
        this.sectorButton = sectorButton;
    }

    public RichCommandButton getSectorButton() {
        return sectorButton;
    }

    public void setDomicileButton(RichCommandButton domicileButton) {
        this.domicileButton = domicileButton;
    }

    public RichCommandButton getDomicileButton() {
        return domicileButton;
    }

    public void setBranchButton(RichCommandButton branchButton) {
        this.branchButton = branchButton;
    }

    public RichCommandButton getBranchButton() {
        return branchButton;
    }

    public void setEditClientTable(RichTable editClientTable) {
        this.editClientTable = editClientTable;
    }

    public RichTable getEditClientTable() {
        return editClientTable;
    }

    public void setViewClientSelected(RichTable viewClientSelected) {
        this.viewClientSelected = viewClientSelected;
    }

    public RichTable getViewClientSelected() {
        return viewClientSelected;
    }

    public void setViewClientButton(RichCommandButton viewClientButton) {
        this.viewClientButton = viewClientButton;
    }

    public RichCommandButton getViewClientButton() {
        return viewClientButton;
    }

    public void setEditClientButton(RichCommandButton editClientButton) {
        this.editClientButton = editClientButton;
    }

    public RichCommandButton getEditClientButton() {
        return editClientButton;
    }

    public void setSelectClientToViewEdit(RichPanelBox selectClientToViewEdit) {
        this.selectClientToViewEdit = selectClientToViewEdit;
    }

    public RichPanelBox getSelectClientToViewEdit() {
        return selectClientToViewEdit;
    }

    public void setJointAssureds(RichTable jointAssureds) {
        this.jointAssureds = jointAssureds;
    }

    public RichTable getJointAssureds() {
        return jointAssureds;
    }

    public void setJointAssuredDesc(RichInputText jointAssuredDesc) {
        this.jointAssuredDesc = jointAssuredDesc;
    }

    public RichInputText getJointAssuredDesc() {
        return jointAssuredDesc;
    }

    public void setObjOccupationDesc(RichInputText objOccupationDesc) {
        this.objOccupationDesc = objOccupationDesc;
    }

    public RichInputText getObjOccupationDesc() {
        return objOccupationDesc;
    }

    public void setOccupation(RichTable occupation) {
        this.occupation = occupation;
    }

    public RichTable getOccupation() {
        return occupation;
    }

    public void setTransType(RichSelectOneChoice transType) {
        this.transType = transType;
    }

    public RichSelectOneChoice getTransType() {
        return transType;
    }

    public void transactionListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if (transType.getValue().toString().equalsIgnoreCase("C")) {
            clientsPanel.setRendered(false);
            clientsLabel.setRendered(false);
            //fullnameLabel.setRendered(false);
            //fullName.setRendered(false);
        } else {
            clientsPanel.setRendered(true);
            clientsLabel.setRendered(true);
            //fullnameLabel.setRendered(true);
            //fullName.setRendered(true);
        }
        allClientDesc.setValue(null);
        //ClientCode = null;
        session.setAttribute("ClientCode", null);
        AdfFacesContext.getCurrentInstance().addPartialTarget(clientsPanel);
        AdfFacesContext.getCurrentInstance().addPartialTarget(clientsLabel);
        AdfFacesContext.getCurrentInstance().addPartialTarget(allClientDesc);
        //AdfFacesContext.getCurrentInstance().addPartialTarget(fullnameLabel);
        //AdfFacesContext.getCurrentInstance().addPartialTarget(fullName);
    }

    public void setAllClientDesc(RichInputText allClientDesc) {
        this.allClientDesc = allClientDesc;
    }

    public RichInputText getAllClientDesc() {
        return allClientDesc;
    }

    public void setClientsPanel(HtmlPanelGrid clientsPanel) {
        this.clientsPanel = clientsPanel;
    }

    public HtmlPanelGrid getClientsPanel() {
        return clientsPanel;
    }

    public void setClientsLabel(HtmlPanelGrid clientsLabel) {
        this.clientsLabel = clientsLabel;
    }

    public HtmlPanelGrid getClientsLabel() {
        return clientsLabel;
    }

    public void setFullnameLabel(RichOutputLabel fullnameLabel) {
        this.fullnameLabel = fullnameLabel;
    }

    public RichOutputLabel getFullnameLabel() {
        return fullnameLabel;
    }

    public void setSimilarClientsPanel(HtmlPanelGrid similarClientsPanel) {
        this.similarClientsPanel = similarClientsPanel;
    }

    public HtmlPanelGrid getSimilarClientsPanel() {
        return similarClientsPanel;
    }

    public void setSaveButton(RichCommandButton saveButton) {
        this.saveButton = saveButton;
    }

    public RichCommandButton getSaveButton() {
        return saveButton;
    }

    public void setCancelButton(RichCommandButton cancelButton) {
        this.cancelButton = cancelButton;
    }

    public RichCommandButton getCancelButton() {
        return cancelButton;
    }

    public void setUsersLOV(RichTable usersLOV) {
        this.usersLOV = usersLOV;
    }

    public RichTable getUsersLOV() {
        return usersLOV;
    }

    public void clientTypeListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if (clientType.getValue() == null) {
            clientType.setValue("I");
        } else {
            //do nothing
        }
        if (clientType.getValue().toString().equalsIgnoreCase("C")) {
            firstnameLabel.setRendered(false);
            firstName.setRendered(false);
            firstName.setValue(null);
            middleNameLabel.setRendered(false);
            middleName.setRendered(false);
            middleName.setValue(null);
            titleLabel.setRendered(false);
            title.setRendered(false);
            title.setValue(null);
            surnameLabel.setValue("Corporation Name");
            dobLabel.setRendered(false);
            doB.setRendered(false);
            doB.setValue(null);
            searchCriteriaLbl.setVisible(true);
            searchCriteria.setVisible(true);
        } else {
            firstnameLabel.setRendered(true);
            firstName.setRendered(true);
            firstName.setValue(null);
            middleNameLabel.setRendered(true);
            middleName.setRendered(true);
            middleName.setValue(null);
            titleLabel.setRendered(true);
            title.setRendered(true);
            title.setValue(null);
            surnameLabel.setValue("Surname");
            dobLabel.setRendered(true);
            doB.setRendered(true);
            doB.setValue(null);
            searchCriteriaLbl.setVisible(true);
            searchCriteria.setVisible(true);
        }

        AdfFacesContext.getCurrentInstance().addPartialTarget(firstnameLabel);
        AdfFacesContext.getCurrentInstance().addPartialTarget(firstName);
        AdfFacesContext.getCurrentInstance().addPartialTarget(middleNameLabel);
        AdfFacesContext.getCurrentInstance().addPartialTarget(middleName);
        AdfFacesContext.getCurrentInstance().addPartialTarget(titleLabel);
        AdfFacesContext.getCurrentInstance().addPartialTarget(title);
        AdfFacesContext.getCurrentInstance().addPartialTarget(surnameLabel);
        AdfFacesContext.getCurrentInstance().addPartialTarget(dobLabel);
        AdfFacesContext.getCurrentInstance().addPartialTarget(doB);

    }

    public void setClientType(RichSelectOneChoice clientType) {
        this.clientType = clientType;
    }

    public RichSelectOneChoice getClientType() {
        return clientType;
    }

    public void setTitleLabel(RichOutputLabel titleLabel) {
        this.titleLabel = titleLabel;
    }

    public RichOutputLabel getTitleLabel() {
        return titleLabel;
    }

    public void setSurnameLabel(RichOutputLabel surnameLabel) {
        this.surnameLabel = surnameLabel;
    }

    public RichOutputLabel getSurnameLabel() {
        return surnameLabel;
    }

    public void setDobLabel(RichOutputLabel dobLabel) {
        this.dobLabel = dobLabel;
    }

    public RichOutputLabel getDobLabel() {
        return dobLabel;
    }

    public void setStateDesc(RichInputText stateDesc) {
        this.stateDesc = stateDesc;
    }

    public RichInputText getStateDesc() {
        return stateDesc;
    }

    public void setStatesLOV(RichTable statesLOV) {
        this.statesLOV = statesLOV;
    }

    public RichTable getStatesLOV() {
        return statesLOV;
    }

    public void setSearchCriteriaLbl(RichOutputLabel searchCriteriaLbl) {
        this.searchCriteriaLbl = searchCriteriaLbl;
    }

    public RichOutputLabel getSearchCriteriaLbl() {
        return searchCriteriaLbl;
    }

    public void setBranchDesc(RichInputText branchDesc) {
        this.branchDesc = branchDesc;
    }

    public RichInputText getBranchDesc() {
        return branchDesc;
    }

    public void setBranchesTable(RichTable branchesTable) {
        this.branchesTable = branchesTable;
    }

    public RichTable getBranchesTable() {
        return branchesTable;
    }

    public void setClientTabbedPanel(RichPanelTabbed clientTabbedPanel) {
        this.clientTabbedPanel = clientTabbedPanel;
    }

    public RichPanelTabbed getClientTabbedPanel() {
        return clientTabbedPanel;
    }

    public void setContPerName(RichInputText contPerName) {
        this.contPerName = contPerName;
    }

    public RichInputText getContPerName() {
        return contPerName;
    }

    public void setContPerDOB(RichInputDate contPerDOB) {
        this.contPerDOB = contPerDOB;
    }

    public RichInputDate getContPerDOB() {
        return contPerDOB;
    }

    public void setContPerPhyAddr(RichInputText contPerPhyAddr) {
        this.contPerPhyAddr = contPerPhyAddr;
    }

    public RichInputText getContPerPhyAddr() {
        return contPerPhyAddr;
    }

    public void setContPerPostAddr(RichInputText contPerPostAddr) {
        this.contPerPostAddr = contPerPostAddr;
    }

    public RichInputText getContPerPostAddr() {
        return contPerPostAddr;
    }

    public void setContPerTel(RichInputText contPerTel) {
        this.contPerTel = contPerTel;
    }

    public RichInputText getContPerTel() {
        return contPerTel;
    }

    public void setContPerEmail(RichInputText contPerEmail) {
        this.contPerEmail = contPerEmail;
    }

    public RichInputText getContPerEmail() {
        return contPerEmail;
    }

    public void setContPerWEF(RichInputDate contPerWEF) {
        this.contPerWEF = contPerWEF;
    }

    public RichInputDate getContPerWEF() {
        return contPerWEF;
    }

    public void setContPerWET(RichInputDate contPerWET) {
        this.contPerWET = contPerWET;
    }

    public RichInputDate getContPerWET() {
        return contPerWET;
    }

    public String saveContactDetails() {
        // Add event code here...

        String Query =
            "begin lms_setups_pkg.addEditContactPerson(?,?,?,?,?,?,?,?,?,?); end;";

        CallableStatement cst = null;
        try {

            DBConnector datahandler = new DBConnector();
            Connection conn;
            conn = datahandler.getDatabaseConn();
            cst = conn.prepareCall(Query);
            cst.setBigDecimal(1, (BigDecimal)session.getAttribute("pctcCode"));
            if (contPerName.getValue() == null) {
                GlobalCC.INFORMATIONREPORTING("Please provide the name of the contact person");
            } else {
                cst.setString(2, (String)contPerName.getValue());
            }
            if (contPerDOB.getValue() == null) {
                cst.setString(3, null);
            } else {
                cst.setString(3,
                              GlobalCC.parseDate(contPerDOB.getValue().toString()));
            }

            if (contPerPhyAddr.getValue() == null) {
                cst.setString(4, null);
            } else {
                cst.setString(4, (String)contPerPhyAddr.getValue());
            }
            if (contPerPostAddr.getValue() == null) {
                cst.setString(5, null);
            } else {
                cst.setString(5, (String)contPerPostAddr.getValue());
            }
            if (contPerTel.getValue() == null) {
                cst.setString(6, null);
            } else {
                cst.setString(6, (String)contPerTel.getValue());
            }
            if (contPerEmail.getValue() == null) {
                cst.setString(7, null);
            } else {
                cst.setString(7, (String)contPerEmail.getValue());
            }
            if (contPerWEF.getValue() == null) {
                cst.setString(8, null);
            } else {
                cst.setString(8,
                              GlobalCC.parseDate(contPerWEF.getValue().toString()));
            }
            if (contPerWET.getValue() == null) {
                cst.setString(9, null);
            } else {
                cst.setString(9,
                              GlobalCC.parseDate(contPerWET.getValue().toString()));
            }
            cst.setBigDecimal(10,
                              (BigDecimal)session.getAttribute("ClientCode"));


            cst.execute();
            conn.close();


            ADFUtils.findIterator("findContactPersonsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(contactPerLOV);

            GlobalCC.INFORMATIONREPORTING("Contact Person Saved Sucessfully");

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String showClientAddDetails() {
        // Add event code here...
        return null;
    }

    public String showClientAddPop() {
        // Add event code here...
        //resets all the components if they have values.
        contPerName.setValue(null);
        contPerPhyAddr.setValue(null);
        contPerPostAddr.setValue(null);
        contPerTel.setValue(null);
        contPerDOB.setValue(null);
        contPerEmail.setValue(null);
        contPerWEF.setValue(null);
        contPerWET.setValue(null);
        session.setAttribute("pctcCode", null);
        //Checks if there is any client that has been selected

        if (session.getAttribute("ClientCode") == null) {
            GlobalCC.INFORMATIONREPORTING("No client has been selected....please select client to proceed");
        }

        GlobalCC.showPopup("demoTemplate:p1");
        return null;
    }

    public void setContactPerLOV(RichTable contactPerLOV) {
        this.contactPerLOV = contactPerLOV;
    }

    public RichTable getContactPerLOV() {
        return contactPerLOV;
    }

    public String editContactPerson() {
        // Add event code here...
        Object key2 = contactPerLOV.getSelectedRowData();
        if (key2 == null) {
            GlobalCC.errorValueNotEntered("No Record Selected");
            return null;
        }
        JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
        if (r == null) {
            GlobalCC.errorValueNotEntered("No Record Selected");
            return null;
        }
        session.setAttribute("pctcCode", r.getAttribute("pctcCode"));
        contPerName.setValue(r.getAttribute("pctcName"));
        //contPerDOB.setValue(r.getAttribute("pctcDob"));
        contPerPhyAddr.setValue(r.getAttribute("pctcPhyAddr"));
        contPerPostAddr.setValue(r.getAttribute("pctcPostAddr"));
        contPerTel.setValue(r.getAttribute("pctcTel"));
        contPerEmail.setValue(r.getAttribute("pctcEmail"));
        //contPerWEF.setValue(r.getAttribute("pctcWef"));
        //contPerWET.setValue(r.getAttribute("pctcWet"));

        GlobalCC.showPopup("demoTemplate:p1");

        return null;
    }

    public String deleteContactPerson() {
        // Add event code here...
        Connection conn = null;
        String query = "begin lms_setups_pkg.deleteContactPerson(?); end;";
        try {
            DBConnector connecter = new DBConnector();
            conn = connecter.getDatabaseConn();
            CallableStatement cst = conn.prepareCall(query);
            Object key2 = contactPerLOV.getSelectedRowData();
            if (key2 == null) {
                GlobalCC.errorValueNotEntered("No Record Selected");
                return null;
            }
            JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
            if (r == null) {
                GlobalCC.errorValueNotEntered("No Record Selected");
                return null;
            }
            cst.setBigDecimal(1, (BigDecimal)r.getAttribute("pctcCode"));
            cst.execute();
            cst.close();
            conn.close();

            ADFUtils.findIterator("findContactPersonsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(contactPerLOV);

        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        }


        return null;
    }

    public void setClientAbbreviation(RichInputText clientAbbreviation) {
        this.clientAbbreviation = clientAbbreviation;
    }

    public RichInputText getClientAbbreviation() {
        return clientAbbreviation;
    }
}
