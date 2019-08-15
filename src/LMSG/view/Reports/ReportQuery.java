package LMSG.view.Reports;

import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.text.SimpleDateFormat;

import java.util.Date;

import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlPanelGrid;

import javax.faces.context.FacesContext;

import javax.faces.el.MethodBinding;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import javax.servlet.http.HttpSession;

import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichSelectItem;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.input.RichSelectOneRadio;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.nav.RichCommandLink;
import oracle.adf.view.rich.component.rich.output.RichOutputLabel;

import oracle.adf.view.rich.context.AdfFacesContext;

import org.apache.myfaces.trinidad.convert.DateTimeConverter;
import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

import LMSG.view.Base.GlobalCC;

import LMSG.view.connect.DBConnector;

import oracle.adf.view.rich.component.rich.input.RichInputNumberSpinbox;

import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.jdbc.OracleTypes;

public class ReportQuery {
    public static HtmlPanelGrid mainParent;
    private RichPanelGroupLayout dtls;
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    private RichCommandLink rptlink;
    private RichInputDate myTest;
    private RichSelectOneRadio reportType;


    public ReportQuery() {

        super();
        RichPanelGroupLayout dfd = new RichPanelGroupLayout();
        this.dtls = dfd;
        HtmlPanelGrid panel = new HtmlPanelGrid();
        this.mainParent = panel;

    }

    public String createComponents() {

        mainParent.getChildren().clear();
        mainParent.setColumns(2);
        if (session.getAttribute("rptCode") == null) {
            return null;
        }


        DBConnector dbConnector = new DBConnector();
        Connection conn = null;
        CallableStatement cst = null;
        String jobquery =
            "SELECT RPTP_PARAM_PROMPT, RPTP_PARAM_TYPE, RPTP_PARENT_CODE, RPTP_QUERY,RPTP_PARAM_NAME, RPTP_PARAM_CLAUSE, RPTP_USER_REQUIRED, RPTP_CHILD_CODE FROM TQC_SYS_RPT_PARAMETERS WHERE RPTP_RPT_CODE = ? ORDER BY RPTP_PARENT_CODE ASC NULLS FIRST,RPTP_CODE";

        try {
            conn = dbConnector.getDatabaseConn();
            cst = conn.prepareCall(jobquery);
            cst.setString(1, (String)session.getAttribute("rptCode"));
            cst.executeQuery();
            System.out.println("Report Code " +
                               (String)session.getAttribute("rptCode"));
            ResultSet rs = cst.executeQuery();
            mainParent.getChildren().clear();
            while (rs.next()) {


                RichOutputLabel LabelArr = new RichOutputLabel();
                LabelArr.setValue(rs.getString(1));
                mainParent.getChildren().add(LabelArr);

                if (rs.getString(2).equalsIgnoreCase("DATE")) {
                    RichInputDate dateComp = new RichInputDate();

                    DateTimeConverter test =
                        (DateTimeConverter)myTest.getConverter();
                    // test.setPattern("dd/MM/yyyy");
                    // test.setSecondaryPattern("ddMMyyyy");
                    dateComp.setConverter(test);
                    dateComp.setId(rs.getString(5));
                    mainParent.getChildren().add(dateComp);
                } else if (rs.getString(2).equalsIgnoreCase("LOV")) {
                    CallableStatement cst2 = null;
                    cst2 = conn.prepareCall(rs.getString(4));
                    ResultSet rs2 = null;

                    if (rs.getString(3) == null) {
                        //do nothing...
                    } else {
                        cst2.setString(1, null);
                    }
                    rs2 = cst2.executeQuery();
                    RichSelectOneChoice lov = new RichSelectOneChoice();
                    while (rs2.next()) {
                        RichSelectItem select = new RichSelectItem();
                        //System.out.println(rs2.getString(1));
                        //System.out.println(rs2.getString(2));
                        select.setLabel(rs2.getString(2));
                        select.setValue(rs2.getString(1));
                        lov.getChildren().add(select);
                    }

                    if (rs.getString(8) == null) {
                        //No Child Parameter Specified.
                    } else {
                        FacesContext fc = FacesContext.getCurrentInstance();
                        Class[] klass = new Class[] { ValueChangeEvent.class };
                        MethodBinding mb =
                            fc.getApplication().createMethodBinding("#{reportParameterBean.DynamicSelectListener}",
                                                                    klass);
                        lov.setValueChangeListener(mb);
                        lov.setShortDesc(rs.getString(8));
                    }

                    lov.setId(rs.getString(5));
                    lov.setSimple(true);
                    lov.setAutoSubmit(true);
                    lov.setUnselectedLabel(rs.getString(1));
                    lov.setValue(null);
                    mainParent.getChildren().add(lov);
                    rs2.close();
                    cst2.close();
                } else if (rs.getString(2).equalsIgnoreCase("NUMBER")) {
                    RichInputNumberSpinbox textComp =
                        new RichInputNumberSpinbox();
                    textComp.setId(rs.getString(5));
                    // textComp.setLabel(rs.getString(1));
                    mainParent.getChildren().add(textComp);
                }

            }

            AdfFacesContext.getCurrentInstance().addPartialTarget(dtls);
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }

        return null;
    }

    public void DynamicSelectListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if (valueChangeEvent.getOldValue() != valueChangeEvent.getNewValue()) {
            DBConnector dbConnector = new DBConnector();
            Connection conn = null;
            CallableStatement cst = null;
            String ChildQuery = null;
            String ChildParamName = null;
            Integer ComponentPosition = null;
            String ChildParamPrompt = null;
            String ChildCode = null;

            RichSelectOneChoice select =
                (RichSelectOneChoice)valueChangeEvent.getComponent();
            String ChildName = select.getShortDesc().toString();
            String ParentValue = select.getValue().toString();

            System.out.println("it works!!!" + ChildName);

            String jobquery =
                "select RPTP_QUERY, RPTP_PARAM_NAME, RPTP_PARAM_PROMPT, RPTP_CHILD_CODE from TQC_SYS_RPT_PARAMETERS where RPTP_CODE = ?";
            try {
                conn = dbConnector.getDatabaseConn();
                cst = conn.prepareCall(jobquery);
                cst.setString(1, ChildName);
                ResultSet rs = cst.executeQuery();
                while (rs.next()) {
                    ChildQuery = rs.getString(1);
                    ChildParamName = rs.getString(2);
                    ChildParamPrompt = rs.getString(3);
                    ChildCode = rs.getString(4);
                }
                int t = 0;
                int k = 0;
                while (k < mainParent.getChildCount()) {
                    if (t == 1) {
                        UIComponent mine = mainParent.getChildren().get(k);
                        String label = mine.getId();
                        if (ChildParamName.equalsIgnoreCase(label)) {
                            mainParent.getChildren().remove(k);
                            ComponentPosition = k;
                        }
                        t--;
                    } else {
                        t++;
                    }
                    k++;
                }
                CallableStatement cst2 = null;
                cst2 = conn.prepareCall(ChildQuery);
                ResultSet rs2 = null;
                cst2.setString(1, ParentValue);
                rs2 = cst2.executeQuery();
                RichSelectOneChoice lov = new RichSelectOneChoice();
                while (rs2.next()) {
                    //System.out.println("Val 1"+ rs2.getString(1));
                    //System.out.println("Val 2"+ rs2.getString(2));
                    RichSelectItem Newselect = new RichSelectItem();
                    Newselect.setLabel(rs2.getString(2));
                    Newselect.setValue(rs2.getString(1));
                    lov.getChildren().add(Newselect);
                }

                if (ChildCode == null) {
                    //No Child Parameter Specified.
                } else {
                    FacesContext fc = FacesContext.getCurrentInstance();
                    Class[] klass = new Class[] { ValueChangeEvent.class };
                    MethodBinding mb =
                        fc.getApplication().createMethodBinding("#{reportParameterBean.DynamicSelectListener}",
                                                                klass);
                    lov.setValueChangeListener(mb);
                    lov.setShortDesc(ChildCode);
                }

                lov.setId(ChildParamName);
                lov.setSimple(true);
                lov.setAutoSubmit(true);
                lov.setUnselectedLabel(ChildParamPrompt);
                lov.setValue(null);
                mainParent.getChildren().add(ComponentPosition, lov);
                AdfFacesContext.getCurrentInstance().addPartialTarget(dtls);
            } catch (Exception e) {
                GlobalCC.EXCEPTIONREPORTING(conn, e);
            }


        }
    }


    public void setMainParent(HtmlPanelGrid mainParent) {
        this.mainParent = mainParent;
    }

    public HtmlPanelGrid getMainParent() {
        return mainParent;
    }

    public void setDtls(RichPanelGroupLayout dtls) {
        this.dtls = dtls;
    }

    public RichPanelGroupLayout getDtls() {
        return dtls;
    }

    public void accAllSelec(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
    }

    public String RemoveReportComponents() {
        try {
            mainParent.getChildren().clear();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public void paramReport(ActionEvent actionEvent) {
        String reportId = actionEvent.getComponent().getId();

        session.setAttribute("prodSpecific", "N");
        session.setAttribute("OldrptCode", null);
        if (reportId.contains("prpt")) {
            reportId = reportId.replace("prpt", "rpt");
            session.setAttribute("prodSpecific", "Y");
            String OldreportId = reportId.replace("rpt", "");
            session.setAttribute("OldrptCode", OldreportId);
        }

        reportId = reportId.replace("rpt", "");
        if (reportId.equalsIgnoreCase("0")) {
            if (session.getAttribute("rptCode") == null) {
                GlobalCC.errorValueNotEntered("No Report Selected");
            } else {
                reportId = (String)session.getAttribute("rptCode");
                reportId = reportId.replace("rpt", "");
                session.setAttribute("rptCode", reportId);
                ExtendedRenderKitService erkService =
                    Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                       ExtendedRenderKitService.class);
                erkService.addScript(FacesContext.getCurrentInstance(),
                                     "var hints = {autodismissNever:false}; " +
                                     "AdfPage.PAGE.findComponent('" +
                                     "lmsgroup:paramReport" +
                                     "').show(hints);");
            }
        } else {
            reportId = reportId.replace("rpt", "");
            session.setAttribute("rptCode", reportId);
            ExtendedRenderKitService erkService =
                Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                   ExtendedRenderKitService.class);
            erkService.addScript(FacesContext.getCurrentInstance(),
                                 "var hints = {autodismissNever:false}; " +
                                 "AdfPage.PAGE.findComponent('" +
                                 "lmsgroup:paramReport" + "').show(hints);");
        }
        createComponents();
        AdfFacesContext.getCurrentInstance().addPartialTarget(mainParent);
    }

    public void setUpsReport(ActionEvent actionEvent) {
        String reportId = actionEvent.getComponent().getId();
        reportId = reportId.replace("rpt", "");
        if (reportId.equalsIgnoreCase("0")) {
            if (session.getAttribute("rptCode") == null) {
                GlobalCC.errorValueNotEntered("No Report Selected");
            } else {
                reportId = (String)session.getAttribute("rptCode");
                reportId = reportId.replace("rpt", "");
                session.setAttribute("rptCode", reportId);
                ExtendedRenderKitService erkService =
                    Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                       ExtendedRenderKitService.class);
                erkService.addScript(FacesContext.getCurrentInstance(),
                                     "var hints = {autodismissNever:false}; " +
                                     "AdfPage.PAGE.findComponent('" +
                                     "lmsgroup:paramReport" +
                                     "').show(hints);");
            }
        } else {
            reportId = reportId.replace("rpt", "");
            session.setAttribute("rptCode", reportId);
            ExtendedRenderKitService erkService =
                Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                   ExtendedRenderKitService.class);
            erkService.addScript(FacesContext.getCurrentInstance(),
                                 "var hints = {autodismissNever:false}; " +
                                 "AdfPage.PAGE.findComponent('" +
                                 "lmsgroup:paramReport" + "').show(hints);");
        }
        createComponents();
        AdfFacesContext.getCurrentInstance().addPartialTarget(mainParent);
    }


    public void setRptlink(RichCommandLink rptlink) {
        this.rptlink = rptlink;
    }

    public RichCommandLink getRptlink() {
        return rptlink;
    }

    public String GetProductSpecificReport() {
        String Result = "F";
        Connection conn = null;
        try {

            conn = new DBConnector().getDatabaseConn();
            String dobQuery =
                "begin ? := LMS_WEB_PKG_GRP_UW.product_rpt_sch(?,?); end;";
            CallableStatement stmt = null;
            stmt = conn.prepareCall(dobQuery);
            stmt.registerOutParameter(1, OracleTypes.NUMBER);
            stmt.setBigDecimal(2,
                               (BigDecimal)session.getAttribute("ProductCode"));
            stmt.setBigDecimal(3,
                               (BigDecimal)session.getAttribute("OldrptCode"));
            stmt.execute();

            String Value = stmt.getString(1);
            if (Value == null) {
                //Failed to Retrieve Report Code. Fail!
            } else {
                session.setAttribute("rptCode", Value);
                Result = "S";
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return Result;
    }

    public String genRpt() {


        int k = 0;
        int t = 0;
        while (k < mainParent.getChildCount()) {
            if (t == 1) {
                UIComponent mine = mainParent.getChildren().get(k);
                String label = mine.getId();
                if (label.equalsIgnoreCase("START_DATE")) {
                    RichInputDate value = (RichInputDate)mine;
                    session.setAttribute("startDate",
                                         GlobalCC.parseDate(value.getValue().toString()));

                } else if (label.equalsIgnoreCase("END_DATE")) {
                    RichInputDate value = (RichInputDate)mine;
                    session.setAttribute("endDate",
                                         GlobalCC.parseDate(value.getValue().toString()));

                } else if (label.equalsIgnoreCase("UP_DATE_TO")) {
                    RichInputDate value = (RichInputDate)mine;
                    session.setAttribute("endDate",
                                         GlobalCC.parseDate(value.getValue().toString()));

                } else if (label.equalsIgnoreCase("UP_DATE_FROM")) {
                    RichInputDate value = (RichInputDate)mine;
                    session.setAttribute("startDate",
                                         GlobalCC.parseDate(value.getValue().toString()));

                } else if (label.equalsIgnoreCase("V_DATE_1") ||
                           label.equalsIgnoreCase("V_DATE_FROM")) {
                    RichInputDate value = (RichInputDate)mine;
                    if (value.getValue() != null) {
                        session.setAttribute("dateFrom",
                                             GlobalCC.parseDate(value.getValue().toString()));
                    }

                } else if (label.equalsIgnoreCase("V_DATE_2") ||
                           label.equalsIgnoreCase("V_DATE_TO")) {
                    RichInputDate value = (RichInputDate)mine;
                    if (value.getValue() != null) {
                        session.setAttribute("dateTo",
                                             GlobalCC.parseDate(value.getValue().toString()));
                    }
                } else if (label.equalsIgnoreCase("FROMDT") ||
                           label.equalsIgnoreCase("FROMDT")) {
                    RichInputDate value = (RichInputDate)mine;
                    if (value.getValue() != null) {
                        System.out.println("From date " +
                                           GlobalCC.extractDate(value));
                        //session.setAttribute("datefrom", GlobalCC.extractDate(value));

                        session.setAttribute("datefrom",
                                             GlobalCC.parseDate(value.getValue().toString()));

                    }
                } else if (label.equalsIgnoreCase("TODT") ||
                           label.equalsIgnoreCase("TODT")) {
                    RichInputDate value = (RichInputDate)mine;
                    if (value.getValue() != null) {
                        System.out.println("To date " +
                                           GlobalCC.extractDate(value));
                        // session.setAttribute("dateTo", GlobalCC.extractDate(value));

                        session.setAttribute("dateTo",
                                             GlobalCC.parseDate(value.getValue().toString()));

                    }
                } else if (label.equalsIgnoreCase("ASOFDATE")) {
                    RichInputDate value = (RichInputDate)mine;
                    if (value.getValue() != null) {
                        // session.setAttribute("ofdate", GlobalCC.extractDate(value));
                        session.setAttribute("ofdate",
                                             GlobalCC.parseDate(value.getValue().toString()));
                    }
                } else if (label.equalsIgnoreCase("V_DATE_3")) {
                    RichInputDate value = (RichInputDate)mine;
                    if (value.getValue() != null) {
                        session.setAttribute("dateThree",
                                             GlobalCC.parseDate(value.getValue().toString()));
                    }
                } else if (label.equalsIgnoreCase("V_POL_CODE")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("policyProposalCode",
                                         value.getValue());
                    session.setAttribute("policyCode", value.getValue());
                } else if (label.equalsIgnoreCase("V_TT_CODE")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("ttCode", value.getValue());
                } else if (label.equalsIgnoreCase("V_RATE_CODE")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("rateCode", value.getValue());
                } else if (label.equalsIgnoreCase("V_AGNT_TYPE")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("actCode", value.getValue());
                } else if (label.equalsIgnoreCase("V_BRN_CODE")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("branchCode", value.getValue());
                } else if (label.equalsIgnoreCase("ZERO_BALANCE")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("zerobal", value.getValue());
                } else if (label.equalsIgnoreCase("ZERO_PREMIUM")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("zeropremium", value.getValue());
                } else if (label.equalsIgnoreCase("P_AGN_STATUS")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("agnstatus", value.getValue());
                } else if (label.equalsIgnoreCase("P_SHOW_AGN_STATUS")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("showagnstatus", value.getValue());
                } else if (label.equalsIgnoreCase("P_BRANCH")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("brncode", value.getValue());
                } else if (label.equalsIgnoreCase("P_AGENT")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("agncode", value.getValue());
                } else if (label.equalsIgnoreCase("P_CLIENT")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("clntcode", value.getValue());
                } else if (label.equalsIgnoreCase("P_SHOW_CLNT_STATUS")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("showclntstatus", value.getValue());
                } else if (label.equalsIgnoreCase("P_CLNT_STATUS")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("clntstatus", value.getValue());
                } else if (label.equalsIgnoreCase("P_ACCTYPE")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("accType", value.getValue());
                } else if (label.equalsIgnoreCase("P_AUTH")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("auth", value.getValue());
                } else if (label.equalsIgnoreCase("P_USER")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("user", value.getValue());
                } else if (label.equalsIgnoreCase("P_CONTROL_ACC")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("controlAcc", value.getValue());
                } else if (label.equalsIgnoreCase("P_AUTHBY")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("authby", value.getValue());
                } else if (label.equalsIgnoreCase("P_DONEBY")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("doneby", value.getValue());
                } else if (label.equalsIgnoreCase("V_POL_STATUS")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("polStatus", value.getValue());
                } else if (label.equalsIgnoreCase("P_PRODUCT_GROUP")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("productGroup", value.getValue());
                } else if (label.equalsIgnoreCase("P_PRODUCT")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("product", value.getValue());
                } else if (label.equalsIgnoreCase("P_CURRENCY")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("currency", value.getValue());
                } else if (label.equalsIgnoreCase("P_BUS_TYPE")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("bustype", value.getValue());
                } else if (label.equalsIgnoreCase("P_CLASS")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("class", value.getValue());
                } else if (label.equalsIgnoreCase("P_RPT_TYPE")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("reporttype", value.getValue());
                } else if (label.equalsIgnoreCase("P_LVL")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("reportlevel", value.getValue());
                } else if (label.equalsIgnoreCase("P_DIV_CODE")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("division", value.getValue());
                } else if (label.equalsIgnoreCase("P_DIVISION")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("division", value.getValue());
                } else if (label.equalsIgnoreCase("P_SUBCLASS")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("subclass", value.getValue());
                } else if (label.equalsIgnoreCase("P_SUMM")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("psumm", value.getValue());
                } else if (label.equalsIgnoreCase("P_HEADING")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("heading", value.getValue());
                } else if (label.equalsIgnoreCase("P_CRDR")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("crDr", value.getValue());
                } else if (label.equalsIgnoreCase("QUOTE_CODE1")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("QuoteCode", value.getValue());
                } else if (label.equalsIgnoreCase("P_CPROFM_CODE")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("cprofmCode", value.getValue());
                } else if (label.equalsIgnoreCase("P_RPROFM_CODE")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("crfmCode", value.getValue());
                } else if (label.equalsIgnoreCase("P_COMMTYPE")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("pcommtype", value.getValue());
                } else if (label.equalsIgnoreCase("P_BINDER_POLICY")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("pBinderPolicy", value.getValue());
                } else if (label.equalsIgnoreCase("GRP_CLIENT")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("clientPRPCode", value.getValue());
                } else if (label.equalsIgnoreCase("GRP_CLIENT_POLICIES")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("policyCode", value.getValue());
                } else if (label.equalsIgnoreCase("GRP_PRODUCTS")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("prodCode", value.getValue());
                } else if (label.equalsIgnoreCase("GRP_PRODUCT_POLICIES")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("policyCode", value.getValue());
                } else if (label.equalsIgnoreCase("GRP_POLICY_ENDR")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("endorsementCode", value.getValue());
                } else if (label.equalsIgnoreCase("GRP_CLIENT_AGENCIES")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("agnCode", value.getValue());
                } else if (label.equalsIgnoreCase("GRP_POLICY_CLAIMS")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("ClaimNo", value.getValue());
                } else if (label.equalsIgnoreCase("V_AGEN_CODE")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("agnCode", value.getValue());
                } else if (label.equalsIgnoreCase("GRP_AGENT_TYPES")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("agnTypes", value.getValue());
                } else if (label.equalsIgnoreCase("V_AGNT_TYPE")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("agnTypes", value.getValue());
                } else if (label.equalsIgnoreCase("GRP_TRANS_TYPE")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("endrType", value.getValue());
                } else if (label.equalsIgnoreCase("V_CLA_CODE")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("classCode", value.getValue());
                } else if (label.equalsIgnoreCase("V_RATE_CODE")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("rateCode", value.getValue());
                } else if (label.equalsIgnoreCase("V_AGNT_TYPE")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("agnTypes", value.getValue());
                } else if (label.equalsIgnoreCase("V_PROD_CODE")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("prodCode", value.getValue());
                } else if (label.equalsIgnoreCase("GRP_POLICY_CLAIMS")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("ClaimNo", value.getValue());
                } else if (label.equalsIgnoreCase("V_CLAIM_STATUS") ||
                           label.equalsIgnoreCase("CLAIM_STATUS")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("clmStatus", value.getValue());
                } else if (label.equalsIgnoreCase("V_FAC_CODE")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("FacCode", value.getValue());
                    //System.out.println("PASSED FAC CODE: "+session.getAttribute("FacCode"));
                } else if (label.equalsIgnoreCase("GRP_TRANS_CURRENCY")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("curCode", value.getValue());
                } else if (label.equalsIgnoreCase("V_BTS_CODE")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("btsCode", value.getValue());
                } else if (label.equalsIgnoreCase("V_SBU_CODE")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("sbuCode", value.getValue());
                } else if (label.equalsIgnoreCase("V_YEAR")) {
                    RichInputNumberSpinbox value =
                        (RichInputNumberSpinbox)mine;
                    session.setAttribute("year", value.getValue());
                } else if (label.equalsIgnoreCase("V_REPORT_TPE")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("reportVal", value.getValue());
                } else if (label.equalsIgnoreCase("V_MONTH")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("month", value.getValue());
                } else if (label.equalsIgnoreCase("V_CURRENCY_CODE")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("curCode", value.getValue());
                } else if (label.equalsIgnoreCase("V_REI_CODE")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    this.session.setAttribute("reiCode", value.getValue());
                } else if (label.equalsIgnoreCase("V_VOUCHER_NO")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    this.session.setAttribute("voucherNo", value.getValue());
                } else if (label.equalsIgnoreCase("V_FMPT_CODE")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    this.session.setAttribute("fmptCode", value.getValue());
                } else if (label.equalsIgnoreCase("V_GRCT_CODE")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    this.session.setAttribute("GrctCode", value.getValue());
                }


                t--;
            } else {
                t++;
            }

            k++;
        }

        String ProductSpecific = (String)session.getAttribute("prodSpecific");
        if (ProductSpecific.equalsIgnoreCase("Y")) {
            String Results = GetProductSpecificReport();
            if (Results.equalsIgnoreCase("F")) {
                RemoveReportComponents();
                return null;
            }
        }

        String reportId = (String)session.getAttribute("rptCode");
        ReportEngine rpt = new ReportEngine();
        rpt.RunReport(new BigDecimal(reportId));
        return null;
    }

    public void setMyTest(RichInputDate myTest) {
        this.myTest = myTest;
    }

    public RichInputDate getMyTest() {
        return myTest;
    }

    public void setReportType(RichSelectOneRadio reportType) {
        this.reportType = reportType;
    }

    public RichSelectOneRadio getReportType() {
        return reportType;
    }

    public void changeReportType(ValueChangeEvent valueChangeEvent) {
        if (reportType.getValue() == null) {
            session.setAttribute("reportformatprint", "pdf");
        } else {
            session.setAttribute("reportformatprint",
                                 reportType.getValue().toString());
        }
    }
}
