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

import LMSG.view.Base.GlobalCC;
import LMSG.view.Base.LOVCC;

import LMSG.view.connect.DBConnector;

import LMSG.view.connect.DBConnector;

import LMSG.view.BPM.workflowProcessing;

import LMSG.view.connect.DBConnector;

public class policyReports {
    public policyReports() {
        super();
    }
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    public String DebitNoteReport(){
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
              System.out.println((BigDecimal)session.getAttribute("endorsementCode"));
                   String path = null;
                   path = sc.getRealPath("/Reports/debtnote.jrxml");
              jasperReport = 
                  //JasperCompileManager.compileReport(GlobalCC.reportsPath + "/glquolet.jrxml");
                  
                  JasperCompileManager.compileReport(path);
              
                  parameters.put("up_endr_code", (BigDecimal)session.getAttribute("endorsementCode"));

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
                             //bytes = JasperRunManager.

                           response.setContentType("application/pdf");
                             response.setHeader("Content-disposition", "attachment; filename=\"DebitNoteReport.pdf\"");
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
    public String CreditNoteReport(){
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
                   path = sc.getRealPath("/Reports/Crednote.jrxml");
              System.out.println((BigDecimal)session.getAttribute("endorsementCode"));
              jasperReport = 
                  //JasperCompileManager.compileReport(GlobalCC.reportsPath + "/glquolet.jrxml");
                  JasperCompileManager.compileReport(path);
              
                  parameters.put("up_endr_code", (BigDecimal)session.getAttribute("endorsementCode"));

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
                             response.setHeader("Content-disposition", "attachment; filename=\"CreditNoteReport.pdf\"");
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
    public String GroupLifeCertReport(){
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
              System.out.println((BigDecimal)session.getAttribute("endorsementCode"));
                   String path = null;
                   path = sc.getRealPath("/Reports/glifecet.jrxml");
              jasperReport = 
                  //JasperCompileManager.compileReport(GlobalCC.reportsPath + "/glquolet.jrxml");
                  
                  JasperCompileManager.compileReport(path);
              
                  parameters.put("up_endr_code", (BigDecimal)session.getAttribute("endorsementCode"));

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
                             response.setHeader("Content-disposition", "attachment; filename=\"GLCertificateReport.pdf\"");
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
    public String ReinsuranceAdviceReport(){
         // JasperPrint jasperPrint;
          JasperReport jasperReport;
          DBConnector datahandler = new DBConnector();
          Connection conn;
          conn = datahandler.getDatabaseConn();
          HashMap parameters = new HashMap();
          parameters = null;
          parameters = new HashMap();
         
          
            try {
                   String Coins = (String)session.getAttribute("CoinsPolicy");
                   FacesContext context = FacesContext.getCurrentInstance();
                   ServletContext sc = (ServletContext)context.getExternalContext().getContext();
                   String path = null;
                   //path = sc.getRealPath("/Reports/rischedul.jrxml");
                   String subPath=null;
                      if(Coins == null){
                          System.out.println((String)session.getAttribute("CoinsPolicy"));
                          path = sc.getRealPath("/Reports/rischedul.jrxml");
                      
                      }
                      else if(Coins.equalsIgnoreCase("Y")){
                           path = sc.getRealPath("/Reports/rischcoin.jrxml");
                          
                       }
                       else if(Coins.equalsIgnoreCase("N")) {
                          path = sc.getRealPath("/Reports/rischedul.jrxml"); 
                      }
              System.out.println((BigDecimal)session.getAttribute("endorsementCode"));
              jasperReport = 
                  //JasperCompileManager.compileReport(GlobalCC.reportsPath + "/glquolet.jrxml");
                  JasperCompileManager.compileReport(path);
              
                  parameters.put("up_endr_code", (BigDecimal)session.getAttribute("endorsementCode"));

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
                             response.setHeader("Content-disposition", "attachment; filename=\"ReinsuranceAdviceReport.pdf\"");
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
    public String coinScheduleReport(){
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
                   path = sc.getRealPath("/Reports/coin_sch.jrxml");
              System.out.println((BigDecimal)session.getAttribute("endorsementCode"));
              jasperReport = 
                  //JasperCompileManager.compileReport(GlobalCC.reportsPath + "/glquolet.jrxml");
                  JasperCompileManager.compileReport(path);
              
                  parameters.put("up_endr_code", (BigDecimal)session.getAttribute("endorsementCode"));

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
                             response.setHeader("Content-disposition", "attachment; filename=\"CoinsuranceSchRpt.pdf\"");
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
    
    public String coinFollowerReport(){
         // JasperPrint jasperPrint;
          JasperReport jasperReport;
          DBConnector datahandler = new DBConnector();
          Connection conn;
          conn = datahandler.getDatabaseConn();
          HashMap parameters = new HashMap();
          parameters = null;
          parameters = new HashMap();
         
          
            try {
              System.out.println((BigDecimal)session.getAttribute("endorsementCode"));
                   FacesContext context = FacesContext.getCurrentInstance();
                   ServletContext sc = (ServletContext)context.getExternalContext().getContext();
                   System.out.println((BigDecimal)session.getAttribute("endorsementCode"));
                   String path = null;
                   path = sc.getRealPath("/Reports/pconschf.jrxml");
              jasperReport = 
                                JasperCompileManager.compileReport(path);
              
                  parameters.put("up_endr_code", (BigDecimal)session.getAttribute("endorsementCode"));

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
                             response.setHeader("Content-disposition", "attachment; filename=\"coinFollowerReport.pdf\"");
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
    
    public String coinPremScheduleReport(){
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
                   System.out.println((BigDecimal)session.getAttribute("endorsementCode"));
                   String path = null;
                   path = sc.getRealPath("/Reports/coinpres.jrxml");
              System.out.println((BigDecimal)session.getAttribute("endorsementCode"));
              jasperReport = 
                  //JasperCompileManager.compileReport(GlobalCC.reportsPath + "/glquolet.jrxml");
                  JasperCompileManager.compileReport(path);
              
                  parameters.put("up_endr_code", (BigDecimal)session.getAttribute("endorsementCode"));

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
                             response.setHeader("Content-disposition", "attachment; filename=\"CoinsurancePremiumRpt.pdf\"");
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
    public String PolicyScheduleReport(){
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
                   System.out.println((BigDecimal)session.getAttribute("endorsementCode"));
                   String path = null;
                   //path = sc.getRealPath("/Reports/coinpres.jrxml"); 
              System.out.println((String)session.getAttribute("productType"));
            
                if(session.getAttribute("prodType")==null){
                    path = sc.getRealPath("/Reports/dapolsch.jrxml"); 
                    jasperReport = 
                        //JasperCompileManager.compileReport(GlobalCC.reportsPath + "/glquolet.jrxml");
                        JasperCompileManager.compileReport(path);
                        parameters.put("up_org_code", 1);
                }else{
                    String prodTy = (String)session.getAttribute("prodType");
                    if(prodTy.equalsIgnoreCase("EARN"))
                    {
                        path = sc.getRealPath("/Reports/glpolsch.jrxml"); 
                        jasperReport = 
                            //JasperCompileManager.compileReport(GlobalCC.reportsPath + "/glquolet.jrxml");
                            JasperCompileManager.compileReport(path);
                    }
                    else 
                    {
                        path = sc.getRealPath("/Reports/dapolsch.jrxml"); 
                        jasperReport = 
                            //JasperCompileManager.compileReport(GlobalCC.reportsPath + "/glquolet.jrxml");
                            JasperCompileManager.compileReport(path);
                            parameters.put("up_org_code", 1);
                    }
                }
                
         
                  /* if(prodTy.equalsIgnoreCase("LOAN"))
                   {
                       JasperReport subReport;
                       String subPath=null;
                       path = sc.getRealPath("/Reports/mepipund.jrxml"); 
                       subPath = sc.getRealPath("Reports/mepipund_subreport0.jrxml");
                       jasperReport = 
                           //JasperCompileManager.compileReport(GlobalCC.reportsPath + "/glquolet.jrxml");
                           JasperCompileManager.compileReport(path);
                       subReport = JasperCompileManager.compileReport(subPath);
                       parameters.put("subReport",subReport);
                   } */     
              
                  parameters.put("up_endr_code", (BigDecimal)session.getAttribute("endorsementCode"));

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
                             response.setHeader("Content-disposition", "attachment; filename=\"PolicyScheduleReport.pdf\"");
                           response.setContentLength(bytes.length);

                           servletOutputStream.write(bytes, 0, bytes.length);
                           servletOutputStream.flush();
                           servletOutputStream.close();
                         }
                         catch (Exception e)
                         {
                           // display stack trace in the browser
                           System.out.println(e.getMessage());
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
    public String MedicalFacingReport(){
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
              System.out.println((BigDecimal)session.getAttribute("endorsementCode"));
                path=sc.getRealPath("Reports/med_face.jrxml");
              jasperReport = 
                  //JasperCompileManager.compileReport(GlobalCC.reportsPath + "/glquolet.jrxml");
                  JasperCompileManager.compileReport(path);
              
                  parameters.put("up_endr_code", (BigDecimal)session.getAttribute("endorsementCode"));
                  parameters.put("up_polm_code", (BigDecimal)session.getAttribute("PolmCode"));

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
                             response.setHeader("Content-disposition", "attachment; filename=\"MedicalFacingReport.pdf\"");
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
    public String MedicalLetterReport(){
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
                   System.out.println((BigDecimal)session.getAttribute("endorsementCode"));
                   String path = null;
                   path = sc.getRealPath("/Reports/medletter.jrxml"); 
              System.out.println((BigDecimal)session.getAttribute("endorsementCode"));
              jasperReport = 
                  //JasperCompileManager.compileReport(GlobalCC.reportsPath + "/glquolet.jrxml");
                  JasperCompileManager.compileReport(path);
              
                  parameters.put("up_endr_code", (BigDecimal)session.getAttribute("endorsementCode"));
                  //parameters.put("up_polm_code", (BigDecimal)session.getAttribute("endorsementCode"));

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
                             response.setHeader("Content-disposition", "attachment; filename=\"MedicalLetterReport.pdf\"");
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
    
    public String MedicalUWLetterReport(){
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
                   System.out.println((BigDecimal)session.getAttribute("endorsementCode"));
                   String path = null;
                   path = sc.getRealPath("/Reports/med_undl.jrxml"); 
              System.out.println((BigDecimal)session.getAttribute("endorsementCode"));
              jasperReport = 
                  //JasperCompileManager.compileReport(GlobalCC.reportsPath + "/glquolet.jrxml");
                  JasperCompileManager.compileReport(path);
              
                  parameters.put("up_endr_code", (BigDecimal)session.getAttribute("endorsementCode"));
                  //parameters.put("up_polm_code", (BigDecimal)session.getAttribute("endorsementCode"));

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
                             response.setHeader("Content-disposition", "attachment; filename=\"MedicalUWLetterReport.pdf\"");
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
   
    public String PremiumAccountLetter(){
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
                   path=sc.getRealPath("/Reports/premacco.jrxml");
              System.out.println((BigDecimal)session.getAttribute("endorsementCode"));
              jasperReport = 
                  //JasperCompileManager.compileReport(GlobalCC.reportsPath + "/glquolet.jrxml");
                  JasperCompileManager.compileReport(path);
              
                  parameters.put("up_endr_code", (BigDecimal)session.getAttribute("endorsementCode"));
                  //parameters.put("up_polm_code", (BigDecimal)session.getAttribute("endorsementCode"));

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
                             response.setHeader("Content-disposition", "attachment; filename=\"PremiumAccountLetter.pdf\"");
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
    public String RenewalNotice(){
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
                   path = sc.getRealPath("Reports/reduenot.jrxml");
              System.out.println((BigDecimal)session.getAttribute("endorsementCode"));
              jasperReport = 
                  //JasperCompileManager.compileReport(GlobalCC.reportsPath + "/glquolet.jrxml");
                  JasperCompileManager.compileReport(path);
              
                  parameters.put("up_endr_code", (BigDecimal)session.getAttribute("endorsementCode"));
                  //parameters.put("up_polm_code", (BigDecimal)session.getAttribute("endorsementCode"));

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
                             response.setHeader("Content-disposition", "attachment; filename=\"RenewalNotice.pdf\"");
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
   
    public String SumBenContribution(){
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
                   path = sc.getRealPath("/Reports/sumbenco.jrxml");
              System.out.println((BigDecimal)session.getAttribute("endorsementCode"));
              jasperReport = 
                  //JasperCompileManager.compileReport(GlobalCC.reportsPath + "/glquolet.jrxml");
                  JasperCompileManager.compileReport(path);
              
                  parameters.put("up_endr_code", (BigDecimal)session.getAttribute("endorsementCode"));
                  //parameters.put("up_polm_code", (BigDecimal)session.getAttribute("endorsementCode"));

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
                             response.setHeader("Content-disposition", "attachment; filename=\"SummaryofBenefitsContribution.pdf\"");
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
    public String CommissionStmtReport(){
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
                   path = sc.getRealPath("/Reports/commstmt.jrxml");
              System.out.println((BigDecimal)session.getAttribute("endorsementCode"));
              jasperReport = 
                  JasperCompileManager.compileReport(path);
              
                  parameters.put("up_endr_code", (BigDecimal)session.getAttribute("endorsementCode"));

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
                             response.setHeader("Content-disposition", "attachment; filename=\"CommissionStmtReport.pdf\"");
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
    public String MedicalTestsReport(){
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
                   FacesContext context = FacesContext.getCurrentInstance();
                   ServletContext sc = (ServletContext)context.getExternalContext().getContext();
                   String path = null;
                   String subPath=null;
                   path = sc.getRealPath("/Reports/med_tests.jrxml");
                   subPath=sc.getRealPath("/Reports/med_tests_subreport.jrxml");
              System.out.println((BigDecimal)session.getAttribute("endorsementCode"));
              jasperReport = 
                  JasperCompileManager.compileReport(path);
              subReport=JasperCompileManager.compileReport(subPath);
                  parameters.put("up_endr_code", (BigDecimal)session.getAttribute("endorsementCode"));
                  parameters.put("subReport",subReport);
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
                             response.setHeader("Content-disposition", "attachment; filename=\"MedicalTestsReport.pdf\"");
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
    public String MedicalTestsWithoutSAReport(){
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
                   path = sc.getRealPath("/Reports/med_test.jrxml"); 
              System.out.println((BigDecimal)session.getAttribute("endorsementCode"));
              jasperReport = 
                  JasperCompileManager.compileReport(path);
              
                  parameters.put("up_endr_code", (BigDecimal)session.getAttribute("endorsementCode"));

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
                             response.setHeader("Content-disposition", "attachment; filename=\"MedicalTestsWithoutSAReport.pdf\"");
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
    public String MedicalFacingSheetReport(){
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
                   path = sc.getRealPath("/Reports/med_face.jrxml"); 
              System.out.println((BigDecimal)session.getAttribute("endorsementCode"));
              jasperReport = 
                  JasperCompileManager.compileReport(path);
              
                  parameters.put("up_polm_code", (BigDecimal)session.getAttribute("PolmCode"));
                  parameters.put("up_endr_code", (BigDecimal)session.getAttribute("endorsementCode"));

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
                             response.setHeader("Content-disposition", "attachment; filename=\"MedicalFacingSheetReport.pdf\"");
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

    public String ValuationReport() {
        JasperReport jasperReport;
        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();
        HashMap parameters = new HashMap();
        parameters = null;
        parameters = new HashMap();
        BigDecimal pnbal_year;
        
        
          try {
                 FacesContext context = FacesContext.getCurrentInstance();
                 ServletContext sc = (ServletContext)context.getExternalContext().getContext();
            System.out.println((String)session.getAttribute("up_pnbal_year"));
                 String path = null;
                 path = sc.getRealPath("/Reports/dapolval.jrxml");
            jasperReport = 
                //JasperCompileManager.compileReport(GlobalCC.reportsPath + "/glquolet.jrxml");
                
                JasperCompileManager.compileReport(path);
                pnbal_year=new BigDecimal((String)session.getAttribute("up_pnbal_year"));
                parameters.put("UP_PNBAL_YEAR", pnbal_year);

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
                           //bytes = JasperRunManager.

                         response.setContentType("application/pdf");
                           response.setHeader("Content-disposition", "attachment; filename=\"DebitNoteReport.pdf\"");
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

    public String SchemeBalancesReport() {
        JasperReport jasperReport;
        JasperReport subReport;
        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();
        HashMap parameters = new HashMap();
        parameters = null;
        parameters = new HashMap();
        BigDecimal policy_code;
        
        
          try {
                 FacesContext context = FacesContext.getCurrentInstance();
                 ServletContext sc = (ServletContext)context.getExternalContext().getContext();
            System.out.println((BigDecimal)session.getAttribute("policyCode"));
                 String path = null;
                 String subPath=null;
                 path = sc.getRealPath("Reports/schembal.jrxml");
                 subPath = sc.getRealPath("Reports/schembal_subreport0.jrxml");
            jasperReport = 
                //JasperCompileManager.compileReport(GlobalCC.reportsPath + "/glquolet.jrxml");
                
                JasperCompileManager.compileReport(path);
                //policy_code=new BigDecimal((String)session.getAttribute("policyCode"));
                parameters.put("up_pol_code", (BigDecimal)session.getAttribute("policyCode"));
                 subReport = JasperCompileManager.compileReport(subPath);
                 parameters.put("subReport",subReport);
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
                           //bytes = JasperRunManager.

                         response.setContentType("application/pdf");
                           response.setHeader("Content-disposition", "attachment; filename=\"DebitNoteReport.pdf\"");
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

    public String GroupLifeValuationReport() {
        JasperReport jasperReport;
        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();
        HashMap parameters = new HashMap();
        parameters = null;
        parameters = new HashMap();
        BigDecimal pnbal_year;
        
        
          try {
                 FacesContext context = FacesContext.getCurrentInstance();
                 ServletContext sc = (ServletContext)context.getExternalContext().getContext();
            System.out.println((String)session.getAttribute("up_pnbal_year"));
                 String path = null;
                 path = sc.getRealPath("/Reports/grplifval.jrxml");
            jasperReport = 
                //JasperCompileManager.compileReport(GlobalCC.reportsPath + "/glquolet.jrxml");
                
                JasperCompileManager.compileReport(path);
                pnbal_year=new BigDecimal((String)session.getAttribute("up_pnbal_year"));
                parameters.put("UP_VAL_YEAR", pnbal_year);

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
                           //bytes = JasperRunManager.

                         response.setContentType("application/pdf");
                           response.setHeader("Content-disposition", "attachment; filename=\"DebitNoteReport.pdf\"");
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

    public String DebitNoteWithCommission() {
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
             System.out.println((BigDecimal)session.getAttribute("endorsementCode"));
                  String path = null;
                  path = sc.getRealPath("/Reports/debtnote_comm.jrxml");
             jasperReport = 
                 //JasperCompileManager.compileReport(GlobalCC.reportsPath + "/glquolet.jrxml");
                 
                 JasperCompileManager.compileReport(path);
             
                 parameters.put("up_endr_code", (BigDecimal)session.getAttribute("endorsementCode"));

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
                            //bytes = JasperRunManager.

                          response.setContentType("application/pdf");
                            response.setHeader("Content-disposition", "attachment; filename=\"DebitNoteReport.pdf\"");
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
}
