package LMSG.view.Reports;

import java.io.File;

import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.util.HashMap;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;

import oracle.jdbc.OracleTypes;

import LMSG.view.Base.CurrentUser;
import LMSG.view.Base.GlobalCC;
import LMSG.view.Base.LOVCC;

import LMSG.view.connect.DBConnector;

import LMSG.view.connect.DBConnector;

import LMSG.view.BPM.wfEngine;
import LMSG.view.BPM.workflowProcessing;

public class quotationReports extends LOVCC {
    public quotationReports() {
        super();
    }
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    public String DispatchReports(){
        try
         {    
            String Taske = (String)session.getAttribute("TaskID");
            if (Taske == null){
                String Message = "No Task Selected";
                FacesContext.getCurrentInstance().addMessage(null, 
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                              Message, 
                                                                              Message));
                return null;
                
            }
           
         
                  Connection conn=new DBConnector().getDatabaseConn();
                    workflowProcessing wf = new workflowProcessing();
                    String MyTask = null;
                    CallableStatement cst3 = null;
                    String Complete = "BEGIN TQC_WEB_PKG.check_task_completion(?,?,?,?);END;";
                    cst3 = conn.prepareCall(Complete);
                    cst3.setString(1,"QDIS"); 
                    cst3.setString(2,(String)session.getAttribute("TaskID")); 
                    cst3.setInt(3, (Integer)session.getAttribute("sysCode"));
                    cst3.registerOutParameter(4, OracleTypes.VARCHAR);
                    cst3.execute();
                    MyTask = cst3.getString(4);
                    conn.close();   
                    if (MyTask.equalsIgnoreCase("Y")){
                    wfEngine end = new wfEngine();
                    end.CompleteTask((String)session.getAttribute("TaskID"));
                    session.setAttribute("TaskID", null);
                    }else{
                        String Message = "Task Incomplete. The Task Selected does not Correspond to the Activity being Performed.";
                        FacesContext.getCurrentInstance().addMessage(null, 
                                                                     new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                                      Message, 
                                                                                      Message));
                        return null;
                    }
                  session.setAttribute("TaskActivityName", null);
              /*
             workflowProcessing wf = new workflowProcessing();
             wf.CompleteTask(); */
            //LOVCC.TaskID = null;
            String Message = "Reports Successfully Dispatched.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
        }
        catch(Exception e) 
        {
            GlobalCC.EXCEPTIONREPORTING(null,e);
              
        
        }
        
        return null;
    }
    
    public String DispatchSchedule(){
        try
         {  
            String Taske = (String)session.getAttribute("TaskID");        
            if (Taske == null){
                String Message = "No Task Selected";
                FacesContext.getCurrentInstance().addMessage(null, 
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                              Message, 
                                                                              Message));
                return null;
                
            }
            
                  Connection conn=new DBConnector().getDatabaseConn();
                    workflowProcessing wf = new workflowProcessing();
                    String MyTask = null;
                    CallableStatement cst3 = null;
                    String Complete = "BEGIN TQC_WEB_PKG.check_task_completion(?,?,?);END;";
                    cst3 = conn.prepareCall(Complete);
                    cst3.setString(1,"SQUOTSCH"); 
                    cst3.setString(2,(String)session.getAttribute("TaskID")); 
                    cst3.registerOutParameter(3, OracleTypes.VARCHAR);
                    cst3.execute();
                     conn.close();   
                    MyTask = cst3.getString(3);
                    if (MyTask.equalsIgnoreCase("Y")){
                    wf.CompleteTask();
                        session.setAttribute("TaskID", null);
                    }else{
                        String Message = "Task Incomplete. The Task Selected does not Correspond to the Activity being Performed.";
                        FacesContext.getCurrentInstance().addMessage(null, 
                                                                     new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                                      Message, 
                                                                                      Message));
                        return null;
                    }
              /*
             workflowProcessing wf = new workflowProcessing();
             wf.CompleteTask(); */
           
            String Message = "Reports Successfully Dispatched.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
        }
        catch(Exception e) 
        {
            GlobalCC.EXCEPTIONREPORTING(null,e);
              
        
        }
        
        return null;
    }
    public String QuotationLetterReport(){
         // JasperPrint jasperPrint;
          JasperReport jasperReport;
          DBConnector datahandler = new DBConnector();
          Connection conn;
          conn = datahandler.getDatabaseConn();
          HashMap parameters = new HashMap();
          parameters = null;
          parameters = new HashMap();
         
          
            try {
                   FacesContext context = FacesContext.getCurrentInstance();
                   ServletContext sc = (ServletContext)context.getExternalContext().getContext();
                   String path = null;
                   String CalcType =  (String)session.getAttribute("QuotCalcType");
             if(CalcType.equalsIgnoreCase("D")){
                   path = sc.getRealPath("Reports/glquolet.jrxml");
             }
            else
             {
                     path = sc.getRealPath("Reports/glquolet.jrxml");
                 }
              System.out.println((BigDecimal)session.getAttribute("QuoteCode"));
            
            
                if(CalcType.equalsIgnoreCase("D")){
                    jasperReport = 
                        //JasperCompileManager.compileReport(GlobalCC.reportsPath + "/glquolet.jrxml");
                        JasperCompileManager.compileReport(path);
                    
                }else{
                    jasperReport = 
                        //JasperCompileManager.compileReport(GlobalCC.reportsPath + "/glquolet.jrxml");
                        JasperCompileManager.compileReport(path);
                    
                }
                
                        
             
              
                  parameters.put("up_quo_code", (BigDecimal)session.getAttribute("QuoteCode"));

                   HttpServletResponse response = 
                       (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
                   ServletOutputStream servletOutputStream;
                       //File reportFile = new File("D:/Program Files/JasperSoft/iReport-3.0.0/Header.jrxml");//(getServletConfig().getServletContext()
                           //.getRealPath("/Reports/Header.jasper"));
                    
                        servletOutputStream = response.getOutputStream();
                   
                    byte[] bytes = null;
                     try
                         {
                           bytes = JasperRunManager.runReportToPdf(jasperReport, parameters, conn);

                           response.setContentType("application/pdf");
                             response.setHeader("Content-disposition", "attachment; filename=\"QuotationLetterReport.pdf\"");
                           response.setContentLength(bytes.length);

                           servletOutputStream.write(bytes, 0, bytes.length);
                           servletOutputStream.flush();
                           servletOutputStream.close();
                         }
                         catch (Exception e)
                         {
                           // display stack trace in the browser
                           String message = e.getMessage();
                           FacesContext.getCurrentInstance().addMessage(null, 
                                                                        new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                                                                                         message, 
                                                                                         message));
                         }
                conn.close();
                   //DispatchReports();
        
               } catch (Exception e) {
              String Message = e.getMessage();
              FacesContext.getCurrentInstance().addMessage(null, 
                                                           new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                                                                            Message, 
                                                                            Message));
              
          }
      
          return null;
      }
    public String QuotationScheduleReport(){
         // JasperPrint jasperPrint;
          JasperReport jasperReport;
          JasperReport subReport;
          DBConnector datahandler = new DBConnector();
          Connection conn;
          conn = datahandler.getDatabaseConn();
          HashMap parameters = new HashMap();
          parameters = null;
          parameters = new HashMap();
         
          
            try {
                   System.out.println((BigDecimal)session.getAttribute("QuoteCode")); 
                   FacesContext context = FacesContext.getCurrentInstance();
                   ServletContext sc = (ServletContext)context.getExternalContext().getContext();
                   String path = null;
                String subPath = null;
            String ProdType = (String)session.getAttribute("productType");
                if(ProdType.equalsIgnoreCase("PENS")){
                    path = sc.getRealPath("Reports/daquosch.jrxml");
                    jasperReport = 
                        //JasperCompileManager.compileReport(GlobalCC.reportsPath + "/glquosch.jrxml");
                        JasperCompileManager.compileReport(path);
                        parameters.put("up_org_code", 2);
                    
                }else{
                    path = sc.getRealPath("Reports/glquosch.jrxml");
                    subPath = sc.getRealPath("Reports/glquoshsubreport.jrxml");
                    jasperReport = 
                        //JasperCompileManager.compileReport(GlobalCC.reportsPath + "/glquosch.jrxml");
                        JasperCompileManager.compileReport(path);
                    subReport = JasperCompileManager.compileReport(subPath);
                    parameters.put("subReport",subReport);
                    
                }
                if(ProdType.equalsIgnoreCase("LOAN")) {
                    path = sc.getRealPath("Reports/mepipqtn.jrxml");
                    subPath = sc.getRealPath("Reports/mepipqtn_subreport0.jrxml");
                    jasperReport = 
                        //JasperCompileManager.compileReport(GlobalCC.reportsPath + "/glquosch.jrxml");
                        JasperCompileManager.compileReport(path);
                    subReport = JasperCompileManager.compileReport(subPath);
                    parameters.put("subReport",subReport);
                }
              
              
                  parameters.put("up_quo_code", (BigDecimal)session.getAttribute("QuoteCode"));

                   HttpServletResponse response = 
                       (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
                   ServletOutputStream servletOutputStream;
                       //File reportFile = new File("D:/Program Files/JasperSoft/iReport-3.0.0/Header.jrxml");//(getServletConfig().getServletContext()
                           //.getRealPath("/Reports/Header.jasper"));
                    
                        servletOutputStream = response.getOutputStream();
                   
                    byte[] bytes = null;
                     try
                         {
                           bytes = JasperRunManager.runReportToPdf(jasperReport, parameters, conn);

                           response.setContentType("application/pdf");
                             response.setHeader("Content-disposition", "attachment; filename=\"QuotationScheduleReport.pdf\"");
                           response.setContentLength(bytes.length);

                           servletOutputStream.write(bytes, 0, bytes.length);
                           servletOutputStream.flush();
                           servletOutputStream.close();
                         }
                         catch (Exception e)
                         {
                           // display stack trace in the browser
                           String message = e.getMessage();
                           FacesContext.getCurrentInstance().addMessage(null, 
                                                                        new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                                                                                         message, 
                                                                                         message));
                         }
                conn.close();
                //DispatchReports();
        
               } catch (Exception e) {
              String Message = e.getMessage();
              FacesContext.getCurrentInstance().addMessage(null, 
                                                           new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                                                                            Message, 
                                                                            Message));
              
          }
      
          return null;
      }
    
    public String CoinsuranceScheduleReport(){
         // JasperPrint jasperPrint;
          JasperReport jasperReport;
          DBConnector datahandler = new DBConnector();
          Connection conn;
          conn = datahandler.getDatabaseConn();
          HashMap parameters = new HashMap();
          parameters = null;
          parameters = new HashMap();
         
          
            try {
                   System.out.println((BigDecimal)session.getAttribute("QuoteCode")); 
                   FacesContext context = FacesContext.getCurrentInstance();
                   ServletContext sc = (ServletContext)context.getExternalContext().getContext();
                                  String path = null;
                   path = sc.getRealPath("/Reports/qcoinsch.jrxml");
              jasperReport = 
                  JasperCompileManager.compileReport(path);
              
              
                  parameters.put("up_quo_code", (BigDecimal)session.getAttribute("QuoteCode"));

                   HttpServletResponse response = 
                       (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
                   ServletOutputStream servletOutputStream;
                       //File reportFile = new File("D:/Program Files/JasperSoft/iReport-3.0.0/Header.jrxml");//(getServletConfig().getServletContext()
                           //.getRealPath("/Reports/Header.jasper"));
                    
                        servletOutputStream = response.getOutputStream();
                   
                    byte[] bytes = null;
                     try
                         {
                           bytes = JasperRunManager.runReportToPdf(jasperReport, parameters, conn);

                           response.setContentType("application/pdf");
                             response.setHeader("Content-disposition", "attachment; filename=\"CoinsuranceScheduleReport.pdf\"");
                           response.setContentLength(bytes.length);

                           servletOutputStream.write(bytes, 0, bytes.length);
                           servletOutputStream.flush();
                           servletOutputStream.close();
                         }
                         catch (Exception e)
                         {
                           // display stack trace in the browser
                           String message = e.getMessage();
                           FacesContext.getCurrentInstance().addMessage(null, 
                                                                        new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                                                                                         message, 
                                                                                         message));
                         }
                conn.close();
                //DispatchReports();
        
               } catch (Exception e) {
              String Message = e.getMessage();
              FacesContext.getCurrentInstance().addMessage(null, 
                                                           new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                                                                            Message, 
                                                                            Message));
              
          }
      
          return null;
      }
    
    public String CoinsuranceFollowerReport(){
         // JasperPrint jasperPrint;
          JasperReport jasperReport;
          DBConnector datahandler = new DBConnector();
          Connection conn;
          conn = datahandler.getDatabaseConn();
          HashMap parameters = new HashMap();
          parameters = null;
          parameters = new HashMap();
         
          
            try {
                   //System.out.println((BigDecimal)session.getAttribute("QuoteCode")); 
                   System.out.println((BigDecimal)session.getAttribute("QuoteCode")); 
                   FacesContext context = FacesContext.getCurrentInstance();
                   ServletContext sc = (ServletContext)context.getExternalContext().getContext();
                                  String path = null;
                   path = sc.getRealPath("/Reports/qconschf.jrxml");  
              jasperReport = 
                  JasperCompileManager.compileReport(path);
              
              
                  parameters.put("up_quo_code", (BigDecimal)session.getAttribute("QuoteCode"));

                   HttpServletResponse response = 
                       (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
                   ServletOutputStream servletOutputStream;
                       //File reportFile = new File("D:/Program Files/JasperSoft/iReport-3.0.0/Header.jrxml");//(getServletConfig().getServletContext()
                           //.getRealPath("/Reports/Header.jasper"));
                    
                        servletOutputStream = response.getOutputStream();
                   
                    byte[] bytes = null;
                     try
                         {
                           bytes = JasperRunManager.runReportToPdf(jasperReport, parameters, conn);

                           response.setContentType("application/pdf");
                             response.setHeader("Content-disposition", "attachment; filename=\"CoinsuranceFollowerReport.pdf\"");
                           response.setContentLength(bytes.length);

                           servletOutputStream.write(bytes, 0, bytes.length);
                           servletOutputStream.flush();
                           servletOutputStream.close();
                         }
                         catch (Exception e)
                         {
                           // display stack trace in the browser
                           String message = e.getMessage();
                           FacesContext.getCurrentInstance().addMessage(null, 
                                                                        new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                                                                                         message, 
                                                                                         message));
                         }
                conn.close();
                //DispatchReports();
        
               } catch (Exception e) {
              String Message = e.getMessage();
              FacesContext.getCurrentInstance().addMessage(null, 
                                                           new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                                                                            Message, 
                                                                            Message));
              
          }
      
          return null;
      }
    
    public String AggregateQuotReport(){
         // JasperPrint jasperPrint;
          JasperReport jasperReport;
          DBConnector datahandler = new DBConnector();
          Connection conn;
          conn = datahandler.getDatabaseConn();
          HashMap parameters = new HashMap();
          parameters = null;
          parameters = new HashMap();
         
          
            try {
                   System.out.println((BigDecimal)session.getAttribute("QuoteCode")); 
                   FacesContext context = FacesContext.getCurrentInstance();
                   ServletContext sc = (ServletContext)context.getExternalContext().getContext();
                String path=null;
                path=sc.getRealPath("Reports/agquorpt.jrxml");
              jasperReport = 
                  JasperCompileManager.compileReport(path);
              
              
                  parameters.put("up_quo_code", (BigDecimal)session.getAttribute("QuoteCode"));

                   HttpServletResponse response = 
                       (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
                   ServletOutputStream servletOutputStream;
                       //File reportFile = new File("D:/Program Files/JasperSoft/iReport-3.0.0/Header.jrxml");//(getServletConfig().getServletContext()
                           //.getRealPath("/Reports/Header.jasper"));
                    
                        servletOutputStream = response.getOutputStream();
                   
                    byte[] bytes = null;
                     try
                         {
                           bytes = JasperRunManager.runReportToPdf(jasperReport, parameters, conn);

                           response.setContentType("application/pdf");
                             response.setHeader("Content-disposition", "attachment; filename=\"AggregateQuoteReport.pdf\"");
                           response.setContentLength(bytes.length);

                           servletOutputStream.write(bytes, 0, bytes.length);
                           servletOutputStream.flush();
                           servletOutputStream.close();
                         }
                         catch (Exception e)
                         {
                           // display stack trace in the browser
                           String message = e.getMessage();
                           FacesContext.getCurrentInstance().addMessage(null, 
                                                                        new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                                                                                         message, 
                                                                                         message));
                         }
                conn.close();
                //DispatchReports();
        
               } catch (Exception e) {
              String Message = e.getMessage();
              FacesContext.getCurrentInstance().addMessage(null, 
                                                           new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                                                                            Message, 
                                                                            Message));
              
          }
      
          return null;
      }
    public String getPublicFolderPath(){

    ExternalContext ectx = FacesContext.getCurrentInstance().getExternalContext();
    String requestPage = ((HttpServletRequest)ectx.getRequest()).getPathInfo();
    String requestPageOsTranslated = requestPage.replace('/',File.separatorChar);
    String requestPathTranslated = ((HttpServletRequest)ectx.getRequest()).getPathTranslated();
    int end = requestPathTranslated.indexOf(requestPageOsTranslated);
    String public_html_location = requestPathTranslated.substring(0,end);
    return public_html_location + File.separatorChar;
    }

}
