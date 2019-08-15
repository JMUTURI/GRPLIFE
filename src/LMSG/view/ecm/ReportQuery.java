package LMSG.view.ecm;



import LMSG.view.Base.GlobalCC;
import LMSG.view.connect.DBConnector;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.faces.el.MethodBinding;

import oracle.adf.view.rich.component.rich.RichDialog;
import oracle.adf.view.rich.component.rich.RichPopup;

import oracle.adf.view.rich.component.rich.data.RichTable;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.OracleResultSet;

import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import javax.servlet.http.HttpSession;

import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputNumberSpinbox;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectItem;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.nav.RichCommandLink;
import oracle.adf.view.rich.component.rich.output.RichOutputLabel;

import oracle.adf.view.rich.context.AdfFacesContext;


import oracle.jdbc.OracleTypes;

import org.apache.myfaces.trinidad.convert.DateTimeConverter;



public class ReportQuery {
    public static HtmlPanelGrid mainParent;
    private RichPanelGroupLayout dtls;
    private RichCommandLink rptlink;
    private RichInputDate myTest;
    private static RichPopup paramReport;
    private UIComponent comp;
    private HtmlPanelGrid childGrid;
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    private RichTable reportQueryTab;
    private RichInputText lovSelectedValue;
    private RichDialog queryLovDialog;
    private RichPopup repLov;


    public ReportQuery() {
        super();
        RichPanelGroupLayout dfd = new RichPanelGroupLayout();
        this.dtls = dfd;
        HtmlPanelGrid panel = new HtmlPanelGrid();
        this.mainParent = panel;


    }
    
    public void DynamicSelectListener(ValueChangeEvent valueChangeEvent) {
      // Add event code here...
       if(valueChangeEvent.getOldValue()!=valueChangeEvent.getNewValue()){
           DBConnector dbConnector = new DBConnector();
           Connection conn = null;
           CallableStatement cst = null;
           String ChildQuery = null;
           String ChildParamName = null;
           Integer ComponentPosition = null;
           String ChildParamPrompt = null;
           String ChildCode = null;
           String paramType=null;
           
           RichSelectOneChoice select =(RichSelectOneChoice)valueChangeEvent.getComponent();
           String ChildName = select.getShortDesc().toString();
           String ParentValue = select.getValue().toString();
           
           
           String jobquery = "select RPTP_CODE,RPTP_PARAM_PROMPT, RPTP_PARAM_TYPE, RPTP_PARENT_CODE, RPTP_QUERY,RPTP_PARAM_NAME, RPTP_PARAM_CLAUSE, \n" + 
           "RPTP_USER_REQUIRED, RPTP_CHILD_CODE from TQC_SYS_RPT_PARAMETERS where RPTP_CODE = ?";
          try {
              conn = dbConnector.getDatabaseConnection();
              cst = conn.prepareCall(jobquery);
              cst.setString(1, ChildName);
              ResultSet rs = cst.executeQuery();
              while(rs.next()){
                  ChildQuery = rs.getString(5);
                  ChildParamName = rs.getString(6);
                  ChildParamPrompt = rs.getString(2);
                  ChildCode = rs.getString(9);
                  paramType=rs.getString(3);
              }
              int t = 0;
              int k = 0;
              while(k < mainParent.getChildCount()){
              if(t==1){    
              UIComponent mine  = mainParent.getChildren().get(k);
              String label = mine.getId();
              if (ChildParamName.equalsIgnoreCase(label)){
                  mainParent.getChildren().remove(k);
                  ComponentPosition = k;
              }
               t--;
               }else{
                  t++;
               }
                  k++;
              }
              CallableStatement cst2 = null;
              cst2 = conn.prepareCall(ChildQuery);
              ResultSet rs2 = null;
              cst2.setString(1, ParentValue);
              rs2 = cst2.executeQuery();
              if (paramType.equalsIgnoreCase("PLOV")) {
                  session.setAttribute("RptReportQuery", ChildQuery);
                  session.setAttribute("rptParentValue", ParentValue);
                  session.removeAttribute("componentId");
                  queryLovDialog.setTitle("Select Item...");
                  Class[] params = new Class[] { ActionEvent.class };
                  MethodBinding rptQuerySelect =
                      FacesContext.getCurrentInstance().getApplication().createMethodBinding("#{ReportQuery.newSelectRptQuery}",
                                                                                             params);
                  //repLov.setId("pt_"+k);
                  HtmlPanelGrid grid = new HtmlPanelGrid();
                  grid.setColumns(2);
                  RichInputText textComp = new RichInputText();
                  textComp.setId(ChildParamName);
                  session.setAttribute("componentId", ChildParamName);
                  //System.out.println("Query " + ChildParamName);
                  textComp.setDisabled(true);
                  textComp.setValue(null);
                  RichCommandButton btn = new RichCommandButton();
                  btn.setPartialSubmit(true);
                  btn.setId("ptcmd1_" + ChildParamName);
                  btn.setIcon("/images/dropdown.gif");
                  btn.setActionListener(rptQuerySelect);
                  grid.getChildren().add(textComp);
                  grid.getChildren().add(btn);
                  mainParent.getChildren().add(ComponentPosition,grid);
              } else  if (paramType.equalsIgnoreCase("LOV")) {
              RichSelectOneChoice lov = new RichSelectOneChoice();
              while(rs2.next()){
                  RichSelectItem Newselect = new RichSelectItem();
                  Newselect.setLabel(rs2.getString(2));
                  Newselect.setValue(rs2.getString(1));
                  lov.getChildren().add(Newselect);
              }
              
              if(ChildCode==null){
                  //No Child Parameter Specified.
              }else{
                  FacesContext fc = FacesContext.getCurrentInstance();
                  Class[] klass = new Class[] { ValueChangeEvent.class};
                  MethodBinding mb = fc.getApplication().createMethodBinding("#{ReportQuery.DynamicSelectListener}", klass);
                  lov.setValueChangeListener(mb); 
                  lov.setShortDesc(ChildCode);
              }
              
              lov.setId(ChildParamName);
              lov.setSimple(true);
              lov.setAutoSubmit(true);
              lov.setUnselectedLabel(ChildParamPrompt);
              lov.setValue(null);
              mainParent.getChildren().add(ComponentPosition, lov);
              }
          AdfFacesContext.getCurrentInstance().addPartialTarget(dtls);
                  
          } catch (Exception e) {
              GlobalCC.EXCEPTIONREPORTING(null, e);
          }
         
           
       }
   }
    

    public String createComponents() {
        mainParent.getChildren().clear();
        mainParent.setColumns(2);
        if (session.getAttribute("rptCode") == null) {
            return null;
        }

        DBConnector dbConnector = new DBConnector();
        OracleConnection conn = null;
        OracleCallableStatement cst = null;
        String jobquery =
            "begin  TQC_WEB_CURSOR.get_report_parameters(?,?,?,?); end;";
        /*  String jobquery =
            "SELECT RPTP_PARAM_PROMPT, RPTP_PARAM_TYPE, RPTP_PARENT_CODE, RPTP_QUERY,RPTP_PARAM_NAME, " +
            " RPTP_PARAM_CLAUSE, RPTP_USER_REQUIRED, RPTP_CODE" +
            " FROM TQC_SYS_RPT_PARAMETERS " +
            " WHERE RPTP_RPT_CODE = ? ORDER BY RPTP_PARENT_CODE ASC NULLS FIRST,RPTP_CODE"; */

        try {
            conn = dbConnector.getDatabaseConnection();
            cst = (OracleCallableStatement)conn.prepareCall(jobquery);
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setString(2, (String)session.getAttribute("rptCode"));
            cst.setString(3, null);
            cst.setString(4, null);
            cst.execute();
            OracleResultSet rs = (OracleResultSet)cst.getObject(1);
        System.out.println("rpt code = "+(String)session.getAttribute("rptCode"));
            mainParent.getChildren().clear();
            int k = 0;
            while (rs.next()) {
                System.out.println("rs.getString(6)" + rs.getString(6)+"rs.getString(2)"+rs.getString(2));
                RichOutputLabel LabelArr = new RichOutputLabel();
                LabelArr.setValue(rs.getString(2));
                LabelArr.setId("ol" + rs.getString(1));
                //  System.out.println("paramLabel1=" + LabelArr.getId());
                mainParent.getChildren().add(LabelArr);
                if (rs.getString(3).equalsIgnoreCase("DATE")) {
                    RichInputDate dateComp = new RichInputDate();
                    DateTimeConverter test =
                        (DateTimeConverter)myTest.getConverter();
                    dateComp.setConverter(test);
                    dateComp.setId(rs.getString(6));
                    // dateComp.setLabel(rs.getString(1));
                    mainParent.getChildren().add(dateComp);
                } else if (rs.getString(3).equalsIgnoreCase("LOV")) {
                    OracleCallableStatement cst2 = null;
                    String query = rs.getString(5);
                    cst2 = (OracleCallableStatement)conn.prepareCall(query);
                    OracleResultSet rs2 = null;
                    rs2 = (OracleResultSet)cst2.executeQuery();
                    RichSelectOneChoice lov = new RichSelectOneChoice();
                    while (rs2.next()) {
                        RichSelectItem select = new RichSelectItem();
                        select.setLabel(rs2.getString(2));
                        select.setValue(rs2.getString(1));
                        lov.getChildren().add(select);
                    }
                    lov.setId(rs.getString(6));
                    lov.setSimple(true);
                    lov.setLabel(rs.getString(1));
                    lov.setAutoSubmit(true);
                    lov.setUnselectedLabel(rs.getString(2));
                    Class[] parms = new Class[] { ValueChangeEvent.class };
                    MethodBinding mb =
                        FacesContext.getCurrentInstance().getApplication().createMethodBinding("#{ReportQuery.queryLovChanged}",
                                                                                               parms);
                    lov.setValueChangeListener(mb);
                    //   mainParent.getChildren().add(lov);
                    if (rs.getString(6).equalsIgnoreCase("V_POL_CODE") ||
                        rs.getString(6).equalsIgnoreCase("V_ENDR_CODE") ||
                        rs.getString(6).equalsIgnoreCase("V_PRP_CODE") ||
                        rs.getString(6).equalsIgnoreCase("V_CLAIM_NO") ||
                        rs.getString(6).equalsIgnoreCase("V_CLM_NO") ||
                        rs.getString(6).equalsIgnoreCase("V_AGEN_CODE") ||
                        //rs.getString(6).equalsIgnoreCase("V_AGN_CODE") ||
                        rs.getString(6).equalsIgnoreCase("V_BRA_CODE") ||
                        //rs.getString(6).equalsIgnoreCase("V_BRN_CODE") ||
                        rs.getString(6).equalsIgnoreCase("V_BRU_CODE")) {
                        session.removeAttribute("componentId");
                        System.out.println("rs.getString(2)123"+rs.getString(2));
                        queryLovDialog.setTitle(rs.getString(2));
                        Class[] params = new Class[] { ActionEvent.class };
                        MethodBinding rptQuerySelect =
                            FacesContext.getCurrentInstance().getApplication().createMethodBinding("#{ReportQuery.newSelectRptQuery}",
                                                                                                   params);

                        HtmlPanelGrid grid = new HtmlPanelGrid();
                        grid.setColumns(2);
                        RichInputText textComp = new RichInputText();
                        textComp.setId(rs.getString(6));
                        session.setAttribute("componentId", rs.getString(6));
                        textComp.setDisabled(true);
                        //textComp.setContext(lovSelectedValue);
                        textComp.setValue(null);
                        //childGrid.setRendered(true);
                        //  lovSelectedValue.setLabel(rs.getString(1));
                        //  lovSelectedValue.setRendered(true);
                        // lovSelectedValue.setId(rs.getString(5));
                        RichCommandButton btn = new RichCommandButton();
                        btn.setPartialSubmit(true);
                        btn.setId("pt_cmd_" + rs.getString(6));
                        btn.setIcon("/images/dropdown.gif");
                        btn.setActionListener(rptQuerySelect);
                        grid.getChildren().add(textComp);
                        grid.getChildren().add(btn);
                        //mainParent.getChildren().add(textComp);
                        //  mainParent.getChildren().add(btn);
                        mainParent.getChildren().add(grid);
                    } else {
                        mainParent.getChildren().add(lov);
                    }
                    rs2.close();
                    cst2.close();
                } else if (rs.getString(3).equalsIgnoreCase("PLOV")) {
                    session.setAttribute("RptReportQuery", rs.getString(5));
                    session.removeAttribute("componentId");
                    queryLovDialog.setTitle("Select Item...");
                    Class[] params = new Class[] { ActionEvent.class };

                    MethodBinding rptQuerySelect =
                        FacesContext.getCurrentInstance().getApplication().createMethodBinding("#{ReportQuery.newSelectRptQuery}",
                                                                                               params);
                    //repLov.setId("pt_"+k);
                    HtmlPanelGrid grid = new HtmlPanelGrid();
                    grid.setColumns(2);
                    RichInputText textComp = new RichInputText();
                    textComp.setId(rs.getString(6));
                    session.setAttribute("componentId", rs.getString(6));
                  //  //System.out.println("Query " + rs.getString(6));
                    textComp.setDisabled(true);
                    //textComp.setContext(lovSelectedValue);
                    textComp.setValue(null);
                    //childGrid.setRendered(true);
                    //  lovSelectedValue.setLabel(rs.getString(1));
                    //  lovSelectedValue.setRendered(true);
                    // lovSelectedValue.setId(rs.getString(5));
                    RichCommandButton btn = new RichCommandButton();
                    btn.setPartialSubmit(true);
                    btn.setId("ptcmd1_" + rs.getString(6));
                    btn.setIcon("/images/dropdown.gif");
                    btn.setActionListener(rptQuerySelect);
                    grid.getChildren().add(textComp);
                    grid.getChildren().add(btn);

                    //mainParent.getChildren().add(textComp);
                    //  mainParent.getChildren().add(btn);
                    mainParent.getChildren().add(grid);

                } else if (rs.getString(3).equalsIgnoreCase("TEXT")) {
                    RichInputText textComp = new RichInputText();
                    textComp.setId(rs.getString(6));
                    // textComp.setLabel(rs.getString(1));
                    mainParent.getChildren().add(textComp);
                } else if (rs.getString(3).equalsIgnoreCase("NUMBER")) {
                    RichInputNumberSpinbox textComp =
                        new RichInputNumberSpinbox();
                    textComp.setId(rs.getString(6));
                    // textComp.setLabel(rs.getString(1));
                    mainParent.getChildren().add(textComp);
                }

            }
            conn.close();
            AdfFacesContext.getCurrentInstance().addPartialTarget(dtls);

        } catch (Exception e) {
            e.printStackTrace();
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return null;
    }
       
    public String cancelSelectRptQuery() {
        GlobalCC.hidePopup("demoTemplate:plate:queryLov");
        return null;
    }

    public String cancelSysReport() {
        mainParent.getChildren().clear();
        AdfFacesContext.getCurrentInstance().addPartialTarget(dtls);
        return null;
    }


    public String dialogTitle(String param) {
        String title = "Select Record";
        if (param.equalsIgnoreCase("V_POL_CODE") ||
            param.equalsIgnoreCase("V_ENDR_CODE")) {
            title = "Policies";
        } else if (param.equalsIgnoreCase("V_PRP_CODE")) {
            title = "Clients";
        } else if (param.equalsIgnoreCase("V_CLAIM_NO") ||
                   param.equalsIgnoreCase("V_CLM_NO")) {
            title = "Claims";
        }
        return title;
    }

    
    public void accAllSelec(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
    }

    public void paramReport(ActionEvent actionEvent) {
        String reportId = actionEvent.getComponent().getId();
        reportId = reportId.replace("rpt", "");
        if (reportId.equalsIgnoreCase("0")) {
            if (session.getAttribute("rptCode") == null) {
                GlobalCC.errorValueNotEntered("No Report Selected");
            } else {
                reportId = (String)session.getAttribute("rptCode");
                reportId = reportId.replace("rpt", "");
                session.setAttribute("rptCode", reportId);
                GlobalCC.showPopup("demoTemplate:paramReport");

            }
        } else {
            reportId = reportId.replace("rpt", "");
            session.setAttribute("rptCode", reportId);
            GlobalCC.showPopup("demoTemplate:paramReport");
        }
        createComponents();
        AdfFacesContext.getCurrentInstance().addPartialTarget(mainParent);
    }

    public void paramReport2() {
        String reportId = (String)(session.getAttribute("rptCode"));
        if (reportId.equalsIgnoreCase("0")) {
            if (session.getAttribute("rptCode") == null) {
                GlobalCC.errorValueNotEntered("No Report Selected");
            } else {
                reportId = (String)session.getAttribute("rptCode");
                session.setAttribute("rptCode", reportId);
                GlobalCC.showPopup("demoTemplate:paramReport");

            }
        } else {
            session.setAttribute("rptCode", reportId);
            GlobalCC.showPopup("demoTemplate:paramReport");
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
        public String genRpt() {
        int k = 0;
        int t = 0;
        while (k < mainParent.getChildCount()) {
            if (t == 1) {
                UIComponent mine = null;
                mine = mainParent.getChildren().get(k);
                String label = mine.getId();
                System.out.println("labelVal" + label);
                //  if (label != null) {
                //System.out.println("label=>"+ label);
                if (label == null) {

                } else if (label.equalsIgnoreCase("V_PROD_CODE")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("prodCode", value.getValue());
                    session.setAttribute("productCode", value.getValue());
                
                } else if (label.equalsIgnoreCase("V_PROD_CODE_1")){
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("prodCode2", value.getValue());
                    session.setAttribute("productCode2", value.getValue());
                }
                               
                else if (label.equalsIgnoreCase("V_CLA_CODE")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("claCode", value.getValue());
                } else if (label.equalsIgnoreCase("V_BRN_CODE") ||
                           label.equalsIgnoreCase("V_BRN_CODE_1") ||
                           label.equalsIgnoreCase("V_BRN") ||
                           label.equalsIgnoreCase("V_CHKPROPBRN") ||
                           label.equalsIgnoreCase("V_ProppremBRN")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    System.out.println("valuebrn" + value.getValue());
                    session.setAttribute("brnCode", value.getValue());
                } else if (label.equalsIgnoreCase("V_AGEN_CODE") ||
                           label.equalsIgnoreCase("V_AGN_CODE")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("agnCode", value.getValue());
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
                } else if (label.equalsIgnoreCase("V_TRANS_NO")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("vtransno", value.getValue());
                    System.out.println("<<ransn>>" + value.getValue());
                }

                else if (label.equalsIgnoreCase("V_TT_CODE")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("ttCode", value.getValue());
                } else if (label.equalsIgnoreCase("V_RATE_CODE")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("rateCode", value.getValue());
                } else if (label.equalsIgnoreCase("V_AGNT_TYPE")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("actCode", value.getValue());
                } else if (label.equalsIgnoreCase("V_MAT_TYPE") ||
                           label.equalsIgnoreCase("V_PM_MATURITY_TYPE")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("maturityType", value.getValue());
                } else if (label.equalsIgnoreCase("V_DATE")) {
                    RichInputDate value = (RichInputDate)mine;
                    if (value.getValue() != null) {
                        session.setAttribute("date",
                                             GlobalCC.parseDate(value.getValue().toString()));
                    }
                } else if (label.equalsIgnoreCase("V_LNA_NO")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("loanNo", value.getValue());
                } else if (label.equalsIgnoreCase("V_P_STATUS")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("policyStatus", value.getValue());
                } else if (label.equalsIgnoreCase("V_AUTHORIZED_BY")) {
                    RichInputText value = (RichInputText)mine;
                    session.setAttribute("authorizedBy", value.getValue());
                } else if (label.equalsIgnoreCase("V_CHECKED_BY")) {
                    RichInputText value = (RichInputText)mine;
                    session.setAttribute("checkedBy", value.getValue());
                } else if (label.equalsIgnoreCase("V_PVSOURCE")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("source", value.getValue());
                } else if (label.equalsIgnoreCase("V_DESCRIPTION")) {
                    RichInputText value = (RichInputText)mine;
                    session.setAttribute("description", value.getValue());
                } else if (label.equalsIgnoreCase("V_PERIOD")) {
                    RichInputNumberSpinbox value =
                        (RichInputNumberSpinbox)mine;
                    session.setAttribute("period", value.getValue());
                } else if (label.equalsIgnoreCase("V_PREPARED_BY")) {
                    RichInputText value = (RichInputText)mine;
                    session.setAttribute("preparedBy", value.getValue());
                } else if (label.equalsIgnoreCase("V_YEAR")) {
                    RichInputNumberSpinbox value =
                        (RichInputNumberSpinbox)mine;
                    session.setAttribute("year", value.getValue());
                } else if (label.equalsIgnoreCase("V_REG_CODE")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("regCode", value.getValue());
                } else if (label.equalsIgnoreCase("V_BRA_CODE")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("braCode", value.getValue());
                } else if (label.equalsIgnoreCase("V_BRU_CODE")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("bruCode", value.getValue());
                } else if (label.equalsIgnoreCase("V_MATURITY_DATE")) {
                    RichInputDate value = (RichInputDate)mine;
                    if (value.getValue() != null) {
                        session.setAttribute("maturityDate",
                                             GlobalCC.parseDate(value.getValue().toString()));
                    }
                } else if (label.equalsIgnoreCase("V_CLAIM_NO") ||
                           label.equalsIgnoreCase("V_CLM_NO")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("claimNumber", value.getValue());
                } else if (label.equalsIgnoreCase("V_BNK_CODE")) {
                      RichSelectOneChoice value = (RichSelectOneChoice)mine;
                      session.setAttribute("bankCode", value.getValue());
                } else if (label.equalsIgnoreCase("V_ENDR_CODE")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("endorsementCode", value.getValue());
                } else if (label.equalsIgnoreCase("V_SIGN_DESIG")) {
                    RichInputText value = (RichInputText)mine;
                    session.setAttribute("designation", value.getValue());
                } else if (label.equalsIgnoreCase("V_SIGN_NAME") ||
                           label.equalsIgnoreCase("V_SIGNATORY")) {
                    RichInputText value = (RichInputText)mine;
                    session.setAttribute("signatoryName", value.getValue());
                } else if (label.equalsIgnoreCase("V_REFERENCE")) {
                    RichInputText value = (RichInputText)mine;
                    session.setAttribute("reference", value.getValue());
                } else if (label.equalsIgnoreCase("V_SIGN_FOR")) {
                    RichInputText value = (RichInputText)mine;
                    session.setAttribute("signFor", value.getValue());
                } else if (label.equalsIgnoreCase("V_PRP_CODE")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("prpCode", value.getValue());
                } else if (label.equalsIgnoreCase("V_CHEQUE_NO")) {
                    RichInputText value = (RichInputText)mine;
                    session.setAttribute("chequeNo", value.getValue());
                } else if (label.equalsIgnoreCase("V_ENCLOSURE")) {
                    RichInputText value = (RichInputText)mine;
                    session.setAttribute("enclosure", value.getValue());
                } else if (label.equalsIgnoreCase("V_TOP_NUMBER")) {
                    RichInputNumberSpinbox value =
                        (RichInputNumberSpinbox)mine;
                    session.setAttribute("vtopnumber", value.getValue());
                } else if (label.equalsIgnoreCase("V_MATURITY_NO")) {
                    RichInputNumberSpinbox value =
                        (RichInputNumberSpinbox)mine;
                    session.setAttribute("marturityNo", value.getValue());
                } else if (label.equalsIgnoreCase("V_RENEW")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("renew", value.getValue());
                } else if (label.equalsIgnoreCase("V_LALT_CODE")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("loantype", value.getValue());
                } else if (label.equalsIgnoreCase("V_PROPOSAL_NO")) {
                    RichInputText value = (RichInputText)mine;
                    session.setAttribute("proposalno", value.getValue());
                } else if (label.equalsIgnoreCase("V_PAID_STATUS")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("paidStatus", value.getValue());
                } else if (label.equalsIgnoreCase("V_LOAN_TYPE")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("loantype", value.getValue());
                } else if (label.equalsIgnoreCase("V_STATUS")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("policyStatus", value.getValue());
                } else if (label.equalsIgnoreCase("V_AGCP_CODE")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("agnComp", value.getValue());
                }else if (label.equalsIgnoreCase("V_REPORT_TPE")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("reportVal", value.getValue());
                }else if (label.equalsIgnoreCase("V_MONTH")) {
                    RichSelectOneChoice value = (RichSelectOneChoice)mine;
                    session.setAttribute("month", value.getValue());
                 }

                t--;
            } else {
                t++;
            }

            k++;
        }
        String reportId = (String)session.getAttribute("rptCode");
        ReportEngine rpt = new ReportEngine();
        if(reportId.equalsIgnoreCase("2006")){
              Computesurrender(); 
            }
        if (reportId.equalsIgnoreCase("990")) {
            session.removeAttribute("rptCode");
           // rpt.reinsuranceAdviceReport();
        } else {
            rpt.reportOne(new BigDecimal(reportId));
        }

        return null;
    }

    public void activeRpt(ActionEvent actionEvent) {
        //public activeRpt(String rptName) {
        String reportId = actionEvent.getComponent().getId();
        //reportId = reportId.replace("rpt", "");
        DBConnector dbConn = new DBConnector();
        OracleConnection conn = null;
        conn = dbConn.getDatabaseConnection();
        String rptCode = null;
        OracleCallableStatement cst = null;
        try {
            String sysQuery = "begin LMS_WEB_PKG2.is_report_active(?,?); end;";
            cst = (OracleCallableStatement)conn.prepareCall(sysQuery);
            //register out
            cst.setString(1, reportId);
            cst.registerOutParameter(2, OracleTypes.VARCHAR);
            cst.execute();
            rptCode = cst.getString(2);
            session.setAttribute("rptCode", rptCode);
            paramReport2();
            cst.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
    }
  public  String Computesurrender() {
      DBConnector datahandler = null;
      datahandler = new DBConnector();
      OracleConnection connect = null;
      connect = datahandler.getDatabaseConnection();
      OracleCallableStatement cst = null;
      String Query = null;
      String surrValue = null;
      try {
          Query = "begin ?:= Lms_Reports_Pkg.compute_surrender(?,?); end;";
          cst = (OracleCallableStatement)connect.prepareCall(Query);
          cst.registerOutParameter(1, OracleTypes.NUMBER);
          cst.setString(2, (String)session.getAttribute("dateFrom"));
          cst.setString(3, (String)session.getAttribute("dateTo"));
          cst.execute();
          if (cst.getBigDecimal(1) != null) {
              surrValue = cst.getBigDecimal(1).toString();
          }
          cst.close();
          connect.commit();
          connect.close();

      } catch (Exception e) {
          e.printStackTrace();
          GlobalCC.EXCEPTIONREPORTING(connect, e);
      }

      return surrValue;
  }
    public void setMyTest(RichInputDate myTest) {
        this.myTest = myTest;
    }

    public RichInputDate getMyTest() {
        return myTest;
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

    public void setParamReport(RichPopup paramReport) {
        this.paramReport = paramReport;
    }

    public RichPopup getParamReport() {
        return paramReport;
    }


    public void setReportQueryTab(RichTable reportQueryTab) {
        this.reportQueryTab = reportQueryTab;
    }

    public RichTable getReportQueryTab() {
        return reportQueryTab;
    }


    public void setComp(UIComponent comp) {
        this.comp = comp;
    }

    public UIComponent getComp() {
        return comp;
    }

    public void setLovSelectedValue(RichInputText lovSelectedValue) {
        this.lovSelectedValue = lovSelectedValue;
    }

    public RichInputText getLovSelectedValue() {
        return lovSelectedValue;
    }

    public void setChildGrid(HtmlPanelGrid childGrid) {
        this.childGrid = childGrid;
    }

    public HtmlPanelGrid getChildGrid() {
        return childGrid;
    }

    public void setQueryLovDialog(RichDialog queryLovDialog) {
        this.queryLovDialog = queryLovDialog;
    }

    public RichDialog getQueryLovDialog() {
        return queryLovDialog;
    }

    public void setRepLov(RichPopup repLov) {
        this.repLov = repLov;
    }

    public RichPopup getRepLov() {
        return repLov;
    }
}
