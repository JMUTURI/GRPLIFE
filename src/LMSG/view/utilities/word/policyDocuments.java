package LMSG.view.utilities.word;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import java.io.OutputStream;

import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.ResultSet;

import java.util.HashMap;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;

import net.sf.jasperreports.engine.export.JRHtmlExporter;

import net.sf.jasperreports.engine.export.JRRtfExporter;

import oracle.jdbc.OracleTypes;

import LMSG.view.Base.GlobalCC;

import LMSG.view.Navigation.Links;
import LMSG.view.connect.DBConnector;

import LMSG.view.BPM.workflowProcessing;

public class policyDocuments {
    public policyDocuments() {
        super();
    }
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);

    public String PopulatePolicyDocument() {
        try {
            String ProdTy = (String)session.getAttribute("prodType");
            System.out.println(ProdTy);
            if (ProdTy.equalsIgnoreCase("PENS")) {
                DischargePensionDoc();
            } else if (ProdTy.equalsIgnoreCase("EARN")) {
                DischargeGLDoc();
            } else {
                DischargeGLDoc();
            }
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }

    public String DischargeGLDoc() {
             String proposerQuery="BEGIN LMS_GRP_WEB_PKG.getProposer(?,?);END;";
             String clubProposer=null;
              JasperReport jasperReport;
              JasperReport subReport;
              DBConnector datahandler = new DBConnector();
              Connection conn;
              conn = datahandler.getDatabaseConn();
              HashMap parameters = new HashMap();
              parameters = null;
              parameters = new HashMap();
             
              
                try {
                      CallableStatement cstmt=null;
                      cstmt=conn.prepareCall(proposerQuery);
                      cstmt.setBigDecimal(1,(BigDecimal)session.getAttribute("endorsementCode"));
                      cstmt.registerOutParameter(2,OracleTypes.VARCHAR);
                      cstmt.execute();
                      clubProposer=(String)cstmt.getObject(2);
                          
                       String Coins = (String)session.getAttribute("CoinsPolicy");
                   
                      
                       FacesContext context = FacesContext.getCurrentInstance();
                       ServletContext sc = (ServletContext)context.getExternalContext().getContext();
                       System.out.println((BigDecimal)session.getAttribute("endorsementCode"));
                       System.out.println((String)session.getAttribute("CoinsPolicy"));
                       String path = null;
                    String subPath=null;
                       if((Coins == null)&&!(clubProposer.equalsIgnoreCase("Y"))){
                           System.out.println((String)session.getAttribute("CoinsPolicy"));
                           path = sc.getRealPath("/Reports/glapolicydocument.jrxml");
                       }
                       else if(Coins.equalsIgnoreCase("Y")){
                            path = sc.getRealPath("/Reports/glapolicydocument_con.jrxml");
                            subPath=sc.getRealPath("/Reports/glapolicydocument_con_subreport1.jrxml");
                            subReport=JasperCompileManager.compileReport(subPath);
                            parameters.put("subReport", subReport);
                        }
                       else if(Coins.equalsIgnoreCase("N")&&!(clubProposer.equalsIgnoreCase("Y"))){
                            System.out.println((String)session.getAttribute("CoinsPolicy"));
                            path = sc.getRealPath("/Reports/glapolicydocument.jrxml");
                        }
                       else if((clubProposer.equalsIgnoreCase("Y"))) {
                           System.out.println((String)session.getAttribute("CoinsPolicy"));
                           path = sc.getRealPath("/Reports/glapolicydocument_club.jrxml"); 
                       }
                     /* if(path==null) 
                       {
                            System.out.println((String)session.getAttribute("CoinsPolicy"));
                            path = sc.getRealPath("/Reports/glapolicydocument.jrxml");
                        }*/
                      
                  System.out.println((BigDecimal)session.getAttribute("endorsementCode"));
                  jasperReport = 
                      //JasperCompileManager.compileReport(GlobalCC.reportsPath + "/glquolet.jrxml");
                      JasperCompileManager.compileReport(path);
                  
                      parameters.put("UP_ENDR_CODE", (BigDecimal)session.getAttribute("endorsementCode"));

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
                                 response.setHeader("Content-disposition", "attachment; filename=\"GLPolicyDocument.pdf\"");
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

    public String DischargePensionDoc() {
      
            JasperReport jasperReport;
            JasperReport subReport;
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
                     System.out.println((BigDecimal)session.getAttribute("endorsementCode"));
                     System.out.println((String)session.getAttribute("CoinsPolicy"));
                     String path = null;
                  String subPath=null;
                 
                         path = sc.getRealPath("/Reports/dapoldoc.jrxml");
                    
                    
                System.out.println((BigDecimal)session.getAttribute("endorsementCode"));
                jasperReport = 
                    //JasperCompileManager.compileReport(GlobalCC.reportsPath + "/glquolet.jrxml");
                    JasperCompileManager.compileReport(path);
                
                    parameters.put("UP_ENDR_CODE", (BigDecimal)session.getAttribute("endorsementCode"));

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
                               response.setHeader("Content-disposition", "attachment; filename=\"GLPolicyDocument.pdf\"");
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
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }
}
