package LMSG.view.Reports;


import LMSG.view.connect.DBConnector;
import java.io.File;

import java.math.BigDecimal;

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

import LMSG.view.Base.GlobalCC;
import LMSG.view.Base.LOVCC;


import LMSG.view.BPM.workflowProcessing;

public class Reporting extends LOVCC {
  public Reporting() {
  }
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
  public String mockReports(){
      try
      {
          workflowProcessing wf = new workflowProcessing();
          wf.CompleteTask();
          
          String Message = "Reports Successfully Spooled.";
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
  public String QuotationPremiumReport(){
       // JasperPrint jasperPrint;
        JasperReport jasperReport;
        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();
        HashMap parameters = new HashMap();
        parameters = null;
        parameters = new HashMap();
       
        
          try {

            jasperReport = 
                JasperCompileManager.compileReport("Reports/QuotPrem.jrxml");
            
                parameters.put("quote_code", (BigDecimal)session.getAttribute("QuoteCode"));
                parameters.put("BRN_CONTACT",(BigDecimal)session.getAttribute("brnCode"));
                parameters.put("BRN_FAX",new String(""));
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
                           response.setHeader("Content-disposition", "attachment; filename=\"QuotationPremiumReport.pdf\"");
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
      
             } catch (Exception e) {
            String Message = e.getMessage();
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                                                                          Message, 
                                                                          Message));
            
        }
    
        return null;
    }
    public String GroupQuotLifeSchedule(){
       // JasperPrint jasperPrint;
        JasperReport jasperReport;
        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();
        HashMap parameters = new HashMap();
        parameters = null;
        parameters = new HashMap();
       
        
          try {

            jasperReport = 
                JasperCompileManager.compileReport("Reports/Glqtnsch.jrxml");
            
                parameters.put("QUO_CODE", (BigDecimal)session.getAttribute("QuoteCode"));
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
                           response.setHeader("Content-disposition", "attachment; filename=\"GroupQuotLifeSchedule.pdf\"");
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
      
             } catch (Exception e) {
            String Message = e.getMessage();
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                                                                          Message, 
                                                                          Message));
            
        }
    
        return null;
    }
    public String GroupLoansSchedule(){
       // JasperPrint jasperPrint;
        JasperReport jasperReport;
        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();
        HashMap parameters = new HashMap();
        parameters = null;
        parameters = new HashMap();
       
        
          try {

            jasperReport = 
                JasperCompileManager.compileReport("Reports/mepipund.jrxml");
            
                BigDecimal endr = (BigDecimal)session.getAttribute("endorsementCode");
               if(endr==null)
               {
                   parameters.put("endr_code", (BigDecimal)session.getAttribute("endorsementCode"));
               }
               else 
               {
                 parameters.put("endr_code", (BigDecimal)session.getAttribute("endorsementCode"));
               }
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
                           response.setHeader("Content-disposition", "attachment; filename=\"GroupLoansSchedule.pdf\"");
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

            jasperReport = 
                JasperCompileManager.compileReport("Reports/EGLendsm.jrxml");
            
                 BigDecimal endr = (BigDecimal)session.getAttribute("endorsementCode");
               if(endr==null)
               {
                   parameters.put("endr_code", (BigDecimal)session.getAttribute("endorsementCode"));
               }
               else 
               {
                 parameters.put("endr_code", (BigDecimal)session.getAttribute("endorsementCode"));
               }
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
      
             } catch (Exception e) {
            String Message = e.getMessage();
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                                                                          Message, 
                                                                          Message));
            
        }
    
        return null;
    }
    public String LoansNotice(){
       // JasperPrint jasperPrint;
        JasperReport jasperReport;
        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();
        HashMap parameters = new HashMap();
        parameters = null;
        parameters = new HashMap();
       
        
          try {

            jasperReport = 
                JasperCompileManager.compileReport("Reports/EGLansch.jrxml");
            
                 BigDecimal endr = (BigDecimal)session.getAttribute("endorsementCode");
               if(endr==null)
               {
                   parameters.put("endr_code", (BigDecimal)session.getAttribute("endorsementCode"));
               }
               else 
               {
                 parameters.put("endr_code", (BigDecimal)session.getAttribute("endorsementCode"));
               }
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
                           response.setHeader("Content-disposition", "attachment; filename=\"LoansNotice.pdf\"");
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
      
             } catch (Exception e) {
            String Message = e.getMessage();
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                                                                          Message, 
                                                                          Message));
            
        }
    
        return null;
    }
    public String GroupLifeSchedule(){
       // JasperPrint jasperPrint;
        JasperReport jasperReport;
        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();
        HashMap parameters = new HashMap();
        parameters = null;
        parameters = new HashMap();
       
        
          try {

            jasperReport = 
                JasperCompileManager.compileReport("Reports/GLschrep.jrxml");
                 BigDecimal endr = (BigDecimal)session.getAttribute("endorsementCode");
                if(endr==null)
                {
                    parameters.put("ENDR_CODE", (BigDecimal)session.getAttribute("endorsementCode"));
                }
                else 
                {
                  parameters.put("ENDR_CODE", (BigDecimal)session.getAttribute("endorsementCode"));
                }
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
                           response.setHeader("Content-disposition", "attachment; filename=\"GroupLifeSchedule.pdf\"");
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
      
             } catch (Exception e) {
            String Message = e.getMessage();
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                                                                          Message, 
                                                                          Message));
            
        }
    
        return null;
    }
    public String FuneralExpenseDocument(){
       // JasperPrint jasperPrint;
        JasperReport jasperReport;
        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();
        HashMap parameters = new HashMap();
        parameters = null;
        parameters = new HashMap();
       
        
          try {

            jasperReport = 
                JasperCompileManager.compileReport("Reports/Fexrrdoc.jrxml");
            
                parameters.put("POL_CODE", (BigDecimal)session.getAttribute("policyCode"));
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
                           response.setHeader("Content-disposition", "attachment; filename=\"FuneralExpenseDocument.pdf\"");
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
      
             } catch (Exception e) {
            String Message = e.getMessage();
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                                                                          Message, 
                                                                          Message));
            
        }
    
        return null;
    }
    public String ClaimsAdvice(){
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
                 path = sc.getRealPath("/Reports/Clmdisch.jrxml");
                 jasperReport =
                 JasperCompileManager.compileReport(path);
          
            
                parameters.put("clm_no",(String)session.getAttribute("ClaimNo"));
                //parameters.put("ORG_CODE",new BigDecimal(1));
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
                           response.setHeader("Content-disposition", "attachment; filename=\"ClaimsAdvice.pdf\"");
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
      
             } catch (Exception e) {
            String Message = e.getMessage();
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                                                                          Message, 
                                                                          Message));
            
        }
    
        return null;
    }
    public String ClaimsDischargeAnalysis(){
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
                 path = sc.getRealPath("/Reports/Clmdisch.jrxml");
            jasperReport = 
                JasperCompileManager.compileReport(path);
                 String subPath=null;
                  subPath = sc.getRealPath("/Reports/Clmdisch_subreport0.jrxml");
                  subReport = JasperCompileManager.compileReport(subPath);
                 parameters.put("subReport",subReport);
                parameters.put("CLM_NO", (String)session.getAttribute("ClaimNo"));
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
                           response.setHeader("Content-disposition", "attachment; filename=\"ClaimsDischargeAnalysis.pdf\"");
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
      
             } catch (Exception e) {
            String Message = e.getMessage();
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                                                                          Message, 
                                                                          Message));
            
        }
    
        return null;
    }
    public String ClaimsDischargeDA(){
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
                 path = sc.getRealPath("/Reports/ClmanDA.jrxml");
            jasperReport = 
                JasperCompileManager.compileReport(path);
            
                parameters.put("claim_no", (String)session.getAttribute("ClaimNo"));
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
                           response.setHeader("Content-disposition", "attachment; filename=\"ClaimsDischargeDA.pdf\"");
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
      
             } catch (Exception e) {
            String Message = e.getMessage();
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                                                                          Message, 
                                                                          Message));
            
        }
    
        return null;
    }
    public String ClaimsDischargeGL(){
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
                 path = sc.getRealPath("/Reports/ClmanGL.jrxml");
                 subPath = sc.getRealPath("/Reports/ClmanGL1.jrxml");
               //System.out.println("Long Disat"+LOVCC.ClaimNo);
            jasperReport = 
                JasperCompileManager.compileReport(path);
                 subReport = JasperCompileManager.compileReport(subPath);
                 
                parameters.put("claim_no", (String)session.getAttribute("ClaimNo"));
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
                           response.setHeader("Content-disposition", "attachment; filename=\"ClaimsDischargeGL.pdf\"");
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
      
             } catch (Exception e) {
            String Message = e.getMessage();
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                                                                          Message, 
                                                                          Message));
            
        }
    
        return null;
    }
    public String ClaimsDischarge(){
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
                 path = sc.getRealPath("/Reports/Clmanlys.jrxml");
                 //System.out.println("Long Disat"+LOVCC.ClaimNo);
                 jasperReport =
                 JasperCompileManager.compileReport(path);
       
            
                parameters.put("clm_no", (String)session.getAttribute("ClaimNo"));
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
                           response.setHeader("Content-disposition", "attachment; filename=\"ClaimsDischarge.pdf\"");
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
      
             } catch (Exception e) {
            String Message = e.getMessage();
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                                                                          Message, 
                                                                          Message));
            
        }
    
        return null;
    }
    public String ClaimsNotification(){
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
                 path = sc.getRealPath("/Reports/Clmntfcn.jrxml");
                 String subPath=null;
                  subPath = sc.getRealPath("/Reports/clmdiscfr_subreport0.jrxml");
                  subReport = JasperCompileManager.compileReport(subPath);
                 //System.out.println("Long Disat"+LOVCC.ClaimNo);
                 jasperReport =
                 JasperCompileManager.compileReport(path);
           
            
                parameters.put("clm_no", (String)session.getAttribute("ClaimNo"));
                parameters.put("sign_for",(String)session.getAttribute("Username"));
               parameters.put("sign_desig",null);
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
                           response.setHeader("Content-disposition", "attachment; filename=\"ClaimsNotification.pdf\"");
                         response.setContentLength(bytes.length);

                         servletOutputStream.write(bytes, 0, bytes.length);
                         servletOutputStream.flush();
                         servletOutputStream.close();
                       }
                       catch (Exception e)
                       {
                         e.printStackTrace();
                         String message = e.getMessage();
                         FacesContext.getCurrentInstance().addMessage(null, 
                                                                      new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                                                                                       message, 
                                                                                       message));
                       }
              conn.close();
      
             } catch (Exception e) {
            String Message = e.getMessage();
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                                                                          Message, 
                                                                          Message));
            
        }
    
        return null;
    }
    public String CreditNote(){
       // JasperPrint jasperPrint;
        JasperReport jasperReport;
        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();
        HashMap parameters = new HashMap();
        parameters = null;
        parameters = new HashMap();
       
        
          try {

            jasperReport = 
                JasperCompileManager.compileReport("Reports/Crednote.jrxml");
            
                 BigDecimal endr = (BigDecimal)session.getAttribute("endorsementCode");
               if(endr==null)
               {
                   parameters.put("ENDR_CODE", (BigDecimal)session.getAttribute("endorsementCode"));
               }
               else 
               {
                 parameters.put("ENDR_CODE", (BigDecimal)session.getAttribute("endorsementCode"));
               }
                parameters.put("sign_for",null);
               parameters.put("sign_desig",null);
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
                           response.setHeader("Content-disposition", "attachment; filename=\"CreditNote.pdf\"");
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
      
             } catch (Exception e) {
            String Message = e.getMessage();
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                                                                          Message, 
                                                                          Message));
            
        }
    
        return null;
    }
    public String DebitNote(){
       // JasperPrint jasperPrint;
        JasperReport jasperReport;
        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();
        HashMap parameters = new HashMap();
        parameters = null;
        parameters = new HashMap();
       
        
          try {

            jasperReport = 
                JasperCompileManager.compileReport("Reports/Debtnote.jrxml");
            
                 BigDecimal endr = (BigDecimal)session.getAttribute("endorsementCode");
               if(endr==null)
               {
                   parameters.put("ENDR_CODE", (BigDecimal)session.getAttribute("endorsementCode"));
               }
               else 
               {
                 parameters.put("ENDR_CODE", (BigDecimal)session.getAttribute("endorsementCode"));
               }
                parameters.put("sign_for",(String)session.getAttribute("Username"));
               parameters.put("sign_desig",null);
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
                           response.setHeader("Content-disposition", "attachment; filename=\"DebitNote.pdf\"");
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

  public String ClaimsAnalysisReport() {
    String ProdTy = (String)session.getAttribute("productType");
    if(ProdTy.equalsIgnoreCase("PENS")) 
    {
      ClaimsDischargeDA();
    }
    else if(ProdTy.equalsIgnoreCase("EARN")) 
    {
      ClaimsDischargeGL();
    }
    else 
    {
      ClaimsDischarge();
    }
    return null;
  }

  public String DebitCreditNotes() {
    // Add event code here...
    return null;
  }

  public String ProductSchedules() {
      String ProdTy = (String)session.getAttribute("productType");
    if(ProdTy.equalsIgnoreCase("LOAN"))
    {
      LoansNotice();
    }
    else if(ProdTy.equalsIgnoreCase("EARN")) 
    {
      GroupLifeSchedule();
    }
      
    return null;
  }

    public String DischargeFormLetter() {
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
                 path = sc.getRealPath("/Reports/clmdiscfr.jrxml");

                String subPath=null;
                 subPath = sc.getRealPath("/Reports/clmdiscfr_subreport0.jrxml");
                 subReport = JasperCompileManager.compileReport(subPath);
                 
                 //System.out.println("Long Disat"+LOVCC.ClaimNo);
                 jasperReport =
                 JasperCompileManager.compileReport(path);
           
            
                parameters.put("clm_no", (String)session.getAttribute("ClaimNo"));
                 parameters.put("subReport",subReport);
                parameters.put("sign_for",(String)session.getAttribute("Username"));
               parameters.put("sign_desig",null);
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
                           response.setHeader("Content-disposition", "attachment; filename=\"ClaimsNotification.pdf\"");
                         response.setContentLength(bytes.length);

                         servletOutputStream.write(bytes, 0, bytes.length);
                         servletOutputStream.flush();
                         servletOutputStream.close();
                       }
                       catch (Exception e)
                       {
                         e.printStackTrace();
                         String message = e.getMessage();
                         FacesContext.getCurrentInstance().addMessage(null, 
                                                                      new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                                                                                       message, 
                                                                                       message));
                       }
              conn.close();
        
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
