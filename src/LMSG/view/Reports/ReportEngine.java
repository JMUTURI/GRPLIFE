package LMSG.view.Reports;

import LMSG.view.Base.ADFUtils;

import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.ResultSet;

import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import javax.servlet.http.HttpSession;

import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;

import LMSG.view.Base.GlobalCC;

import LMSG.view.Base.Rendering;
import LMSG.view.Correspondents.CorrespondenceManipulation;

import javax.servlet.http.HttpServletResponse;

import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanRadio;
import oracle.adf.view.rich.component.rich.input.RichSelectOneRadio;

import LMSG.view.connect.DBConnector;

import java.io.BufferedOutputStream;

import java.util.Iterator;
import java.util.List;

import oracle.adf.view.rich.component.rich.nav.RichCommandButton;

import oracle.jdbc.OracleTypes;

import javax.servlet.ServletOutputStream;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.Key;
import oracle.jbo.Row;

import org.apache.myfaces.trinidad.model.RowKeySet;
import LMSG.view.Correspondents.CorrespondenceManipulation;

import java.io.File;

import javax.servlet.ServletContext;


public class ReportEngine {
    private RichInputDate dateFrom;
    private RichInputDate dateTo;
    private RichSelectOneRadio coinScheduleOption;
    private RichSelectBooleanRadio allMembersOption;
    private RichSelectBooleanRadio oneMemberOption;
    private RichCommandButton oneMemberButton;
    private RichInputText oneMemberDisp;
    private RichTable availMembersTable;
    private RichSelectOneRadio reinScheduleOption;

    public ReportEngine() {
        super();
    }
    private RichSelectOneRadio repFormat;
    
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    
    public String RunReport(BigDecimal rptCode) {
        XMLPublisher xmlPublisher = new XMLPublisher();

        String templateFile = null;
        String styleFile = null;
        String reportName = null;
        String dataFile = null;
        byte[] bytes = null;
        String reportFormat = null;
        if(repFormat==null){
          
        }
        else
        reportFormat = GlobalCC.checkNullValues(repFormat.getValue());
        if(reportFormat==null){
            if(session.getAttribute("reportformatprint")==null){
                //do nothing...
            }else{
                reportFormat = (String)session.getAttribute("reportformatprint");
            }
        }
        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();
        CallableStatement cst = null;
        String jobquery = "begin ? := tqc_web_cursor.getRptDetails(?); end;";
        System.out.println("AM HERE");

        try {
            cst = conn.prepareCall(jobquery);
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setBigDecimal(2, rptCode);
            cst.executeQuery();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                templateFile = rs.getString(5);
                styleFile = rs.getString(7);
                reportName = rs.getString(2);
                dataFile = rs.getString(3);
            }
            xmlPublisher.dataEngine(reportName, dataFile, conn, session);
            bytes =
                    xmlPublisher.processorEngine(reportFormat, templateFile, styleFile,
                                                 reportName);


            HttpServletResponse response =
                (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
            
            ServletOutputStream servletOutputStream;
            response.reset();
            response.resetBuffer();
            servletOutputStream = response.getOutputStream();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(servletOutputStream);

            
            //BufferedOutputStream bufferedOutputStream = null;


            String filename = null;
            filename = reportName;


            String output = null;
            if (reportFormat == null) {

                output = filename + ".pdf";
            } else {
                output = filename + "." + reportFormat;
            }

            
            response.setContentType("application/octet-stream");
            response.setHeader("Content-disposition",
                               "attachment; filename=" + output + "");


            response.setContentLength(bytes.length);
            
           bufferedOutputStream.write(bytes, 0, bytes.length);
           bufferedOutputStream.flush();
           bufferedOutputStream.close();

            //servletOutputStream.write(bytes, 0, bytes.length);
            //servletOutputStream.flush();
            //servletOutputStream.close();
            response.reset();
            response.resetBuffer();
            
            rs.close();
            cst.close();
            conn.close();
          
            //AdfFacesContext.getCurrentInstance().addPartialTarget(rptBtn);

        } catch (Exception e) {
            session.setAttribute("reportformatprint",null);
            GlobalCC.EXCEPTIONREPORTING(conn, e);
            e.printStackTrace();
        }
        session.setAttribute("reportformatprint",null);
        return null;
    }
    
  public String RunReportMed(BigDecimal rptCode) {
      XMLPublisher xmlPublisher = new XMLPublisher();

      String medFile = null;
      String medFileName = null;
      byte[] bytes = null;
      String output = null;
      String ext = null;
      
      /*if(repFormat==null){
        
      }
      else
      reportFormat = GlobalCC.checkNullValues(repFormat.getValue());
      if(reportFormat==null){
          if(session.getAttribute("reportformatprint")==null){
              //do nothing...
          }else{
              reportFormat = (String)session.getAttribute("reportformatprint");
          }
      }*/
      
      DBConnector datahandler = new DBConnector();
      Connection conn;
      conn = datahandler.getDatabaseConn();
      CallableStatement cst = null;
      String jobquery = "begin LMS_WEB_CURSOR_GRP.Get_Medical_Questionnaires(?,?); end;";

      try {
          cst = conn.prepareCall(jobquery);
          cst.registerOutParameter(1, OracleTypes.CURSOR);
          cst.setBigDecimal(2, rptCode);
          cst.executeQuery();
          ResultSet rs = (ResultSet)cst.getObject(1);
          while (rs.next()) {
              medFileName = rs.getString(2);
              medFile = rs.getString(3);
              ext = medFile.substring(medFile.indexOf(".")+1, medFile.length());
            System.out.println("The med file " + medFile);
              medFileName = medFileName.replace(" ","_")+"."+ext;
          }
        FacesContext context = FacesContext.getCurrentInstance();

        // ServletContext
        
        output = "Reports/"+medFile;
  
        ServletContext sc =
            (ServletContext)context.getExternalContext().getContext();
          output = sc.getRealPath(output);
          
          File file = new File(output);
          
          XMLPublisher xp = new XMLPublisher();
          bytes = xp.getBytesFromFile(file);
          HttpServletResponse response =
              (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
          
          ServletOutputStream servletOutputStream;
          response.reset();
          response.resetBuffer();
          servletOutputStream = response.getOutputStream();
          BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(servletOutputStream);

          
          //BufferedOutputStream bufferedOutputStream = null;
          
          //response.setContentType("application/octet-stream");
          response.setContentType("application/msword");
          
          response.setHeader("Content-disposition",
                             "attachment; filename=" + medFileName);


          response.setContentLength(bytes.length);
          
         bufferedOutputStream.write(bytes, 0, bytes.length);
         bufferedOutputStream.flush();
         bufferedOutputStream.close();

          //servletOutputStream.write(bytes, 0, bytes.length);
          //servletOutputStream.flush();
          //servletOutputStream.close();
          response.reset();
          response.resetBuffer();
          
          rs.close();
          cst.close();
          conn.close();
        
          //AdfFacesContext.getCurrentInstance().addPartialTarget(rptBtn);

      } catch (Exception e) {
          GlobalCC.EXCEPTIONREPORTING(conn, e);
          e.printStackTrace();
      }

      return null;
  }
    
    public void GetProductSpecificReports(ActionEvent actionEvent){
        Connection conn = null;
        BigDecimal Value = null;
        try{
          String reportId = actionEvent.getComponent().getId();
          reportId = reportId.replace("prpt", "");
          if(reportId==null){
              GlobalCC.errorValueNotEntered("No Report Selected");
           }
          if(reportId==null){
              GlobalCC.sysInformation("Problem Initializing the Report");
              return;
           }
           
           if(session.getAttribute("rptProductCode")==null){
             session.setAttribute("rptProductCode", session.getAttribute("ProductCode"));
           }
          if(session.getAttribute("endorsementCode")==null){
            session.setAttribute("endorsementCode", session.getAttribute("endorsementCode"));
          }
            
          conn=new DBConnector().getDatabaseConn();
          String dobQuery = "begin ? := LMS_WEB_PKG_GRP_UW.product_rpt_sch(?,?,?); end;";
          CallableStatement stmt = null;
          stmt = conn.prepareCall(dobQuery);
          stmt.registerOutParameter(1, oracle.jdbc.internal.OracleTypes.VARCHAR);
          stmt.setBigDecimal(2, (BigDecimal)session.getAttribute("rptProductCode"));
          stmt.setString(3, reportId);
          stmt.setBigDecimal(4, (BigDecimal)session.getAttribute("endorsementCode"));
          stmt.execute();
            
          Value = stmt.getBigDecimal(1);
          stmt.close();
          conn.close(); 
          if(Value==null){
            GlobalCC.sysInformation("There is no Report Defined for this Product in the Database.");
            return;
          }
          RunReport(Value);
        }catch(Exception e){
          GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
    }
    
  public void GetProductSpecificSchedules(ActionEvent actionEvent){
      Connection conn = null;
      BigDecimal Value = null;
      try{
        String reportId = actionEvent.getComponent().getId();
        reportId = reportId.replace("prpt", "");
        if(reportId==null){
            GlobalCC.errorValueNotEntered("No Report Selected");
         }
        if(reportId==null){
            GlobalCC.sysInformation("Problem Initializing the Report");
            return;
         }
         
         if(session.getAttribute("rptProductCode")==null){
           session.setAttribute("rptProductCode", session.getAttribute("ProductCode"));
         }
        if(session.getAttribute("endorsementCode")==null){
          session.setAttribute("endorsementCode", session.getAttribute("endorsementCode"));
        }
          
        conn=new DBConnector().getDatabaseConn();
        String dobQuery = "begin ? := LMS_WEB_PKG_GRP_UW.product_rpt_sch(?,?,?); end;";
        CallableStatement stmt = null;
        stmt = conn.prepareCall(dobQuery);
        stmt.registerOutParameter(1, oracle.jdbc.internal.OracleTypes.VARCHAR);
        stmt.setBigDecimal(2, (BigDecimal)session.getAttribute("rptProductCode"));
        stmt.setString(3, reportId);
        stmt.setBigDecimal(4, (BigDecimal)session.getAttribute("endorsementCode"));
        stmt.execute();
          
        Value = stmt.getBigDecimal(1);
        stmt.close();
        conn.close(); 
        if(Value==null){
          GlobalCC.sysInformation("There is no Report Defined for this Product in the Database.");
          return;
        }
        session.setAttribute("showRates", "N");
        session.setAttribute("rptCode", Value);
        Rendering render = new Rendering();
        
        if(!render.isMickVisible()){
            GlobalCC.showPopup("lmsgroup:schduleParams");
        } else {
            RunReport(Value);
        }
        
      }catch(Exception e){
        GlobalCC.EXCEPTIONREPORTING(conn, e);
      }
  }
    
    public void RunEndorsementReports(ActionEvent actionEvent){
      
        try{
            String Value = (String)session.getAttribute("endrValue");
            String Coins = (String)session.getAttribute("CoinsPolicy");
            if(Value.equalsIgnoreCase("RN")&& Coins.equalsIgnoreCase("Y")){
              RunReport(new BigDecimal("1000"));
            }else{
              RunReport(new BigDecimal("944"));
            }
        }catch(Exception e){
          GlobalCC.EXCEPTIONREPORTING(null, e);
        }
    }
    
  public void GetReportDetails(ActionEvent actionEvent) {
    Connection conn=null;    
    String rptCode = null;
    String reportId = actionEvent.getComponent().getId();
    reportId = reportId.replace("rpt", "");
    if(reportId.equalsIgnoreCase("0")){
        if(rptCode==null){
          GlobalCC.errorValueNotEntered("No Report Selected");
        }else{
      reportId = rptCode;
      reportId = reportId.replace("rpt", "");
      rptCode = reportId;
        }
    }else{
      reportId = reportId.replace("rpt", "");
      rptCode = reportId;
    
    }
      
      String Result = SetReportParameters(Integer.parseInt(rptCode));
      if(Result.equalsIgnoreCase("F")){
          return;
      }
      if(rptCode.equals("1001")||rptCode.equals("1002")||rptCode.equals("1458")){
        String printSEQ="BEGIN lms_web_pkg_grp_uw.incr_dcr_seq(?);END;";
        System.out.println("Endr_code"+session.getAttribute("endorsementCode"));
        try{
        conn=new DBConnector().getDatabaseConn();
        CallableStatement cstmt=conn.prepareCall(printSEQ);
        cstmt.setBigDecimal(1,(BigDecimal)session.getAttribute("endorsementCode"));        
        cstmt.execute();
        cstmt.close();
        conn.close();   
        }catch(Exception e){
          e.printStackTrace();
        }
        
      }
      RunReport(new BigDecimal(rptCode));
    
  }
    
    public void GetCoinScheduleRptParams(ActionEvent actionEvent) {
      String rptCode = null;
      String reportId = actionEvent.getComponent().getId();
      reportId = reportId.replace("rpt", "");
      if(reportId.equalsIgnoreCase("0")){
          if(rptCode==null){
            GlobalCC.errorValueNotEntered("No Report Selected");
          }else{
        reportId = rptCode;
        reportId = reportId.replace("rpt", "");
        rptCode = reportId;
          }
      }else{
        reportId = reportId.replace("rpt", "");
        rptCode = reportId;      
      }
        
        String Result = SetReportParameters(Integer.parseInt(rptCode));
        if(Result.equalsIgnoreCase("F")){
            return;
        }
        session.setAttribute("showRates", "N");
        session.setAttribute("rptCode", new BigDecimal(rptCode));
       GlobalCC.showPopup("lmsgroup:schduleParams");
    }
    
    public String RunCoinScheduleReport(){
      
        if(coinScheduleOption.getValue()==null){
          session.setAttribute("showRates", "N");
        }else if(coinScheduleOption.getValue().toString().equalsIgnoreCase("Y")){
          session.setAttribute("showRates", "Y");
        }else{
          session.setAttribute("showRates", "N");
        }
        RunReport((BigDecimal)session.getAttribute("rptCode"));
      return null;
    }
    
    public void RunValuationReports(ActionEvent actionEvent){
        Connection conn = null;
        try{
            String rptCode = null;
            String reportId = actionEvent.getComponent().getId();
            reportId = reportId.replace("rpt", "");
            if(reportId.equalsIgnoreCase("0")){
                if(rptCode==null){
                  GlobalCC.errorValueNotEntered("No Report Selected");
                }else{
              reportId = rptCode;
              reportId = reportId.replace("rpt", "");
              rptCode = reportId;
                }
            }else{
              reportId = reportId.replace("rpt", "");
              rptCode = reportId;
            
            }
            String authQuery="BEGIN lms_web_pkg_grp_uw.determine_next_WEF(?,?,?,?);END;";
            conn=new DBConnector().getDatabaseConn();
            CallableStatement cstmt=conn.prepareCall(authQuery);
            cstmt.setBigDecimal(1,(BigDecimal)session.getAttribute("policyCode"));
            cstmt.setString(2,(String)session.getAttribute("UWYear"));
            cstmt.setString(3, null);
            cstmt.registerOutParameter(4, oracle.jdbc.internal.OracleTypes.DATE);
            cstmt.execute();
            
            if(cstmt.getDate(4)==null){
                GlobalCC.sysInformation("Please do a Valuation First. ");
                return;
            }else{
                session.setAttribute("endDate", GlobalCC.upDateParseDate(cstmt.getDate(4).toString()));
            }
            cstmt.close();
            RunReport(new BigDecimal(rptCode));
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
    }
    
    public String SetReportParameters(Integer ReportRender){
        String Result = "F";
        try{
            switch(ReportRender){
            
            case 1://Reports that recieve only date parameters...
            case 2:
            case 3:
            case 4:
            case 13:
                if(dateFrom.getValue()==null){
                 GlobalCC.sysInformation("Select A Date From");
                 return Result;
                }else{
                    session.setAttribute("startDate", GlobalCC.parseDate(dateFrom.getValue().toString()));
                }
                if(dateTo.getValue()==null){
                 GlobalCC.sysInformation("Select A Date To");
                 return Result;
                }else{
                    session.setAttribute("endDate", GlobalCC.parseDate(dateTo.getValue().toString()));
                }
                Result = "S";
            break;
            default:
                //Do Nothing...
                    Result = "S";
            break;
            } 
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return Result;
    }
    
    public void setRepFormat(RichSelectOneRadio repFormat) {
        this.repFormat = repFormat;
    }

    public RichSelectOneRadio getRepFormat() {
        return repFormat;
    }

    public void setDateFrom(RichInputDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public RichInputDate getDateFrom() {
        return dateFrom;
    }

    public void setDateTo(RichInputDate dateTo) {
        this.dateTo = dateTo;
    }

    public RichInputDate getDateTo() {
        return dateTo;
    }

    public void setCoinScheduleOption(RichSelectOneRadio coinScheduleOption) {
        this.coinScheduleOption = coinScheduleOption;
    }

    public RichSelectOneRadio getCoinScheduleOption() {
        return coinScheduleOption;
    }

    public void setAllMembersOption(RichSelectBooleanRadio allMembersOption) {
        this.allMembersOption = allMembersOption;
    }

    public RichSelectBooleanRadio getAllMembersOption() {
        return allMembersOption;
    }

    public void setOneMemberOption(RichSelectBooleanRadio oneMemberOption) {
        this.oneMemberOption = oneMemberOption;
    }

    public RichSelectBooleanRadio getOneMemberOption() {
        return oneMemberOption;
    }

    public void MemberCertificatesListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if(valueChangeEvent.getNewValue()!=valueChangeEvent.getOldValue()){
            if(allMembersOption.isSelected()){
              oneMemberButton.setDisabled(true);
              oneMemberDisp.setValue(null);
              session.setAttribute("MemberSel", null);
            }else if(oneMemberOption.isSelected()){
              oneMemberButton.setDisabled(false);
              oneMemberDisp.setValue(null);
              session.setAttribute("MemberSel", null);
            }
        }
      AdfFacesContext.getCurrentInstance().addPartialTarget(oneMemberButton);
      AdfFacesContext.getCurrentInstance().addPartialTarget(oneMemberDisp);
    }
    
  public String MemberSelected() { 

    DCIteratorBinding dciter = ADFUtils.findIterator("FindPolicyMembersIterator");
    RowKeySet set =availMembersTable.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();

    while (rowKeySetIter.hasNext()) 
    {
        List l = (List) rowKeySetIter.next();
        Key key = (Key)l.get(0);
        dciter.setCurrentRowWithKey(key.toStringFormat(true));
        Row r = dciter.getCurrentRow();
       
       session.setAttribute("MemberSel", r.getAttribute("POLM_CODE"));
       oneMemberDisp.setValue(r.getAttribute("POLM_client"));
    }
     AdfFacesContext.getCurrentInstance().addPartialTarget(oneMemberDisp);
     GlobalCC.hidePopup("lmsgroup:p12");
    return null;
  }
  
  public String CancelMemberSelected(){
    GlobalCC.hidePopup("lmsgroup:p12");
    return null;
  }
  
  public String RunMemberCertificates(){
      RunReport(new BigDecimal((String)session.getAttribute("rptCode")));
    return null;
  }
  
  public void GetMemberCertRptParams(ActionEvent actionEvent) {
    String rptCode = null;
    String reportId = actionEvent.getComponent().getId();
    reportId = reportId.replace("rpt", "");
    String prodTy = (String)session.getAttribute("productType");
    if(reportId.equalsIgnoreCase("0")){
        if(rptCode==null){
          GlobalCC.errorValueNotEntered("No Report Selected");
        }else{
      reportId = rptCode;
      reportId = reportId.replace("rpt", "");
      rptCode = reportId;
        }
    }else{
      reportId = reportId.replace("rpt", "");
      rptCode = reportId;  
        if(prodTy.equalsIgnoreCase("LOAN")){
          rptCode ="3827";
        }
    }
      
      String Result = SetReportParameters(Integer.parseInt(rptCode));
      
      if(Result.equalsIgnoreCase("F")){
          return;
      }
      oneMemberButton.setDisabled(true);
      oneMemberDisp.setValue(null);
      session.setAttribute("MemberSel", null);
      session.setAttribute("rptCode", rptCode);
      GlobalCC.showPopup("lmsgroup:p11");
  }

    public void setOneMemberButton(RichCommandButton oneMemberButton) {
        this.oneMemberButton = oneMemberButton;
    }

    public RichCommandButton getOneMemberButton() {
        return oneMemberButton;
    }

    public void setOneMemberDisp(RichInputText oneMemberDisp) {
        this.oneMemberDisp = oneMemberDisp;
    }

    public RichInputText getOneMemberDisp() {
        return oneMemberDisp;
    }

    public void setAvailMembersTable(RichTable availMembersTable) {
        this.availMembersTable = availMembersTable;
    }

    public RichTable getAvailMembersTable() {
        return availMembersTable;
    }
  
    public String getReinSchDtls() {
      if(reinScheduleOption.getValue()==null){
        session.setAttribute("showRates", "n");
      }else if(reinScheduleOption.getValue().toString().equalsIgnoreCase("y")){
        session.setAttribute("showRates", "y");
      }else{
        session.setAttribute("showRates", "n");
      }
      RunReport(new BigDecimal((String)session.getAttribute("rptCode")));
        return null;
    }
     
    public void getReinReportParams(ActionEvent actionEvent) {
          String rptCode = null;
          String reportId = actionEvent.getComponent().getId();
          reportId = reportId.replace("rpt", "");
          if(reportId.equalsIgnoreCase("0")){
              if(rptCode==null){
                GlobalCC.errorValueNotEntered("No Report Selected");
              }else{
            reportId = rptCode;
            reportId = reportId.replace("rpt", "");
            rptCode = reportId;
              }
          }else{
            reportId = reportId.replace("rpt", "");
            rptCode = reportId;      
          }
            
            String Result = SetReportParameters(Integer.parseInt(rptCode));
            if(Result.equalsIgnoreCase("F")){
                return;
            }
            session.setAttribute("showRates", "N");
            session.setAttribute("rptCode", rptCode);         
           GlobalCC.showPopup("lmsgroup:reinparams");
      }

    public void setReinScheduleOption(RichSelectOneRadio reinScheduleOption) {
        this.reinScheduleOption = reinScheduleOption;
    }

    public RichSelectOneRadio getReinScheduleOption() {
        return reinScheduleOption;
    }
}
