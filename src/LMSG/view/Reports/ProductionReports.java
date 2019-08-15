package LMSG.view.Reports;
import java.io.File;

import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.util.HashMap;

import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.faces.event.ValueChangeEvent;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.data.RichTable;

import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.adf.view.rich.component.rich.input.RichSelectBooleanCheckbox;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanRadio;

import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.Key;
import oracle.jbo.Row;

import oracle.jbo.uicli.binding.JUCtrlValueBinding;

import oracle.jdbc.OracleTypes;

import org.apache.myfaces.trinidad.model.RowKeySet;

import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

import LMSG.view.Base.ADFUtils;

import LMSG.view.Base.GlobalCC;
import LMSG.view.Base.LOVCC;

import LMSG.view.connect.DBConnector;

import LMSG.view.connect.DBConnector;

import LMSG.view.BPM.workflowProcessing;

import LMSG.view.connect.DBConnector;
public class ProductionReports {
    private RichTable productsLOV;
    private RichInputText productsDesc;
    private RichInputText endrDescription;
    private RichTable endosrsementsLOV;
    private RichInputText memProductDesc;
    private RichTable products2Lov;
    private RichInputText policyNumber;
    private RichTable policiesLOV;
    private RichInputText endrDescription2;
    private RichTable endorsementsLOV;
    private RichInputText polProductsDesc;
    private RichTable prodnProductsLOV;
    private RichInputText productionPolicy;
    private RichTable prodctionPoliciesLOV;
    private RichSelectBooleanRadio perPolicy;
    private RichSelectBooleanRadio allPolicies;
    private RichCommandButton policiesBtn;
    private RichSelectBooleanRadio perTransaction;
    private RichSelectBooleanRadio allTransactions;
    private RichInputText productionTransactions;
    private RichCommandButton transactionsBtn;
    private RichTable productionTransactionsLOV;
    private RichSelectBooleanCheckbox perPolicyBox;
    private RichSelectBooleanCheckbox allPoliciesBox;
    private RichSelectBooleanCheckbox perTransactionBox;
    private RichSelectBooleanCheckbox allTranactionsBox;
    private RichInputDate dateFrom;
    private RichInputDate dateTo;
    private RichInputDate memDateFrom;
    private RichInputDate memDateTo;
    private RichInputDate prdnDateFrom;
    private RichInputDate prdnDateTo;
    private RichInputDate grpDateFrom;
    private RichInputText grpTransactionType;
    private RichTable grpTransactionsLOV;
    private RichInputDate grpDateTo;
    private RichSelectOneChoice trntType;
    private RichSelectOneChoice trntProdApplicable;
    private RichSelectOneChoice trntAppLevel;
    private RichTable usersTable;

    public ProductionReports() {
        super();
    }
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    public String ProductReports() {
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
            //System.out.println((BigDecimal)session.getAttribute("endorsementCode"));
                 String path = null;
                 path = sc.getRealPath("/Reports/Clasprod.jrxml");
            jasperReport = 
                //JasperCompileManager.compileReport(GlobalCC.reportsPath + "/glquolet.jrxml");
                
                JasperCompileManager.compileReport(path);
            
                //parameters.put("up_endr_code", (BigDecimal)session.getAttribute("endorsementCode"));

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
                         GlobalCC.EXCEPTIONREPORTING(conn, e);
                       }
              conn.close();
                 //DispatchReports();
        
             } catch (Exception e) {
          GlobalCC.EXCEPTIONREPORTING(conn, e);
            
        }
        
        return null;
        //return null;
    }

    public String ProductCoverTypesList() {
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
            //System.out.println((BigDecimal)session.getAttribute("endorsementCode"));
                 String path = null;
                 path = sc.getRealPath("/Reports/prdcvttyp.jrxml");
            jasperReport = 
                //JasperCompileManager.compileReport(GlobalCC.reportsPath + "/glquolet.jrxml");
                
                JasperCompileManager.compileReport(path);
            
                //parameters.put("up_endr_code", (BigDecimal)session.getAttribute("endorsementCode"));

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
                           response.setHeader("Content-disposition", "attachment; filename=\"ProductCoverTypes.pdf\"");
                         response.setContentLength(bytes.length);

                         servletOutputStream.write(bytes, 0, bytes.length);
                         servletOutputStream.flush();
                         servletOutputStream.close();
                       }
                       catch (Exception e)
                       {
                         GlobalCC.EXCEPTIONREPORTING(conn, e);
                       }
              conn.close();
                 //DispatchReports();
        
             } catch (Exception e) {
          GlobalCC.EXCEPTIONREPORTING(conn, e);
            
        }
        return null;
    }

    public String CoverTypesReports() {
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
            //System.out.println((BigDecimal)session.getAttribute("endorsementCode"));
                 String path = null;
                 path = sc.getRealPath("/Reports/covertyp.jrxml");
            jasperReport = 
                //JasperCompileManager.compileReport(GlobalCC.reportsPath + "/glquolet.jrxml");
                
                JasperCompileManager.compileReport(path);
            
                //parameters.put("up_endr_code", (BigDecimal)session.getAttribute("endorsementCode"));

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
                           response.setHeader("Content-disposition", "attachment; filename=\"CoverTypes.pdf\"");
                         response.setContentLength(bytes.length);

                         servletOutputStream.write(bytes, 0, bytes.length);
                         servletOutputStream.flush();
                         servletOutputStream.close();
                       }
                       catch (Exception e)
                       {
                         GlobalCC.EXCEPTIONREPORTING(conn, e);
                       }
              conn.close();
                 //DispatchReports();
        
             } catch (Exception e) {
          GlobalCC.EXCEPTIONREPORTING(conn, e);
            
        }
        return null;
    }

    public String AgenciesList() {
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
            //System.out.println((BigDecimal)session.getAttribute("endorsementCode"));
                 String path = null;
                 path = sc.getRealPath("/Reports/agencies.jrxml");
            jasperReport = 
                //JasperCompileManager.compileReport(GlobalCC.reportsPath + "/glquolet.jrxml");
                
                JasperCompileManager.compileReport(path);
            
                //parameters.put("up_endr_code", (BigDecimal)session.getAttribute("endorsementCode"));

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
                           response.setHeader("Content-disposition", "attachment; filename=\"AgenciesList.pdf\"");
                         response.setContentLength(bytes.length);

                         servletOutputStream.write(bytes, 0, bytes.length);
                         servletOutputStream.flush();
                         servletOutputStream.close();
                       }
                       catch (Exception e)
                       {
                         GlobalCC.EXCEPTIONREPORTING(conn, e);
                       }
              conn.close();
                 //DispatchReports();
        
             } catch (Exception e) {
          GlobalCC.EXCEPTIONREPORTING(conn, e);
            
        }
        return null;
        //return null;
    }

    public String RelationsList() {
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
            //System.out.println((BigDecimal)session.getAttribute("endorsementCode"));
                 String path = null;
                 path = sc.getRealPath("/Reports/dependtyp.jrxml");
            jasperReport = 
                //JasperCompileManager.compileReport(GlobalCC.reportsPath + "/glquolet.jrxml");
                
                JasperCompileManager.compileReport(path);
            
                //parameters.put("up_endr_code", (BigDecimal)session.getAttribute("endorsementCode"));

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
                           response.setHeader("Content-disposition", "attachment; filename=\"DependentTypesList.pdf\"");
                         response.setContentLength(bytes.length);

                         servletOutputStream.write(bytes, 0, bytes.length);
                         servletOutputStream.flush();
                         servletOutputStream.close();
                       }
                       catch (Exception e)
                       {
                         GlobalCC.EXCEPTIONREPORTING(conn, e);
                       }
              conn.close();
                 //DispatchReports();
        
             } catch (Exception e) {
          GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public String AssignProducts() {
        DCIteratorBinding dciter = ADFUtils.findIterator("findProductsIterator");
        RowKeySet set =productsLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        
        //System.out.println(1);
        while (rowKeySetIter.hasNext()) 
        {
            List l = (List) rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
          
        
            
            session.setAttribute("PRODCode",r.getAttribute("PROD_CODE"));
            productsDesc.setValue(r.getAttribute("PROD_DESC"));
        
        }
        return null;
    }

    public void setProductsLOV(RichTable productsLOV) {
        this.productsLOV = productsLOV;
    }

    public RichTable getProductsLOV() {
        return productsLOV;
    }

    public void setProductsDesc(RichInputText productsDesc) {
        this.productsDesc = productsDesc;
    }

    public RichInputText getProductsDesc() {
        return productsDesc;
    }

    public void setEndrDescription(RichInputText endrDescription) {
        this.endrDescription = endrDescription;
    }

    public RichInputText getEndrDescription() {
        return endrDescription;
    }

    public void setEndosrsementsLOV(RichTable endosrsementsLOV) {
        this.endosrsementsLOV = endosrsementsLOV;
    }

    public RichTable getEndosrsementsLOV() {
        return endosrsementsLOV;
    }

    public String AssignTransTypes() {
        DCIteratorBinding dciter = ADFUtils.findIterator("findBusinessTransactionsIterator");
        RowKeySet set =endosrsementsLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        
        //System.out.println(1);
        while (rowKeySetIter.hasNext()) 
        {
            List l = (List) rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
          
        
            
            session.setAttribute("endrType",r.getAttribute("BTR_TRANS_CODE"));
            endrDescription.setValue(r.getAttribute("BTR_TRANS_TYPE"));
        
        }
        return null;
    }

    public String RunRiSchemeReport() {
        JasperReport jasperReport;
        DBConnector datahandler = new DBConnector();
        Connection conn;
        JasperReport subReport;
        conn = datahandler.getDatabaseConn();
        HashMap parameters = new HashMap();
        parameters = null;
        parameters = new HashMap();
        
        
        
          try {
                 FacesContext context = FacesContext.getCurrentInstance();
                 ServletContext sc = (ServletContext)context.getExternalContext().getContext();
            //System.out.println((BigDecimal)session.getAttribute("endorsementCode"));
                 String path = null;
                 String subPath = null;
                 path = sc.getRealPath("/Reports/scheme_ri.jrxml");
                 subPath = sc.getRealPath("/Reports/scheme_ri_subreport0.jrxml");
            jasperReport = 
                //JasperCompileManager.compileReport(GlobalCC.reportsPath + "/glquolet.jrxml");
                
                JasperCompileManager.compileReport(path);
                 subReport = JasperCompileManager.compileReport(subPath);
                 parameters.put("subReport",subReport);
                parameters.put("UP_ENDR_TYPE", (String)session.getAttribute("endrType"));
                parameters.put("UP_PROD_CODE", (BigDecimal)session.getAttribute("PRODCode"));
                parameters.put("UP_DATE_FROM", GlobalCC.parseDate(dateFrom.getValue().toString()));
                parameters.put("UP_DATE_TO", GlobalCC.parseDate(dateTo.getValue().toString()));
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
                           response.setHeader("Content-disposition", "attachment; filename=\"ReinsuranceSchemesBasis.pdf\"");
                         response.setContentLength(bytes.length);

                         servletOutputStream.write(bytes, 0, bytes.length);
                         servletOutputStream.flush();
                         servletOutputStream.close();
                       }
                       catch (Exception e)
                       {
                         GlobalCC.EXCEPTIONREPORTING(conn, e);
                       }
              conn.close();
                 //DispatchReports();
        
             } catch (Exception e) {
          GlobalCC.EXCEPTIONREPORTING(conn, e);
            
        }
        return null;
    }

    public String ShowTransactiontypes() {
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:transactionsPopup" +
        "').show(hints);");
        return null;
    }

    public void setMemProductDesc(RichInputText memProductDesc) {
        this.memProductDesc = memProductDesc;
    }

    public RichInputText getMemProductDesc() {
        return memProductDesc;
    }

    public void setProducts2Lov(RichTable products2Lov) {
        this.products2Lov = products2Lov;
    }

    public RichTable getProducts2Lov() {
        return products2Lov;
    }

    public String AssignProducts2() {
        RowKeySet rowKeySet = products2Lov.getSelectedRowKeys();
                if (!rowKeySet.iterator().hasNext()) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    return null;
                }

                Object key2 = rowKeySet.iterator().next();
               products2Lov.setRowKey(key2);

                JUCtrlValueBinding r = (JUCtrlValueBinding)products2Lov.getRowData();

                if (r == null) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    return null;
                } 
                session.setAttribute("ProductCode",r.getAttribute("PROD_CODE"));
                memProductDesc.setValue(r.getAttribute("PROD_DESC"));
        return null;
    }

    public void setPolicyNumber(RichInputText policyNumber) {
        this.policyNumber = policyNumber;
    }

    public RichInputText getPolicyNumber() {
        return policyNumber;
    }

    public String ShowProducts() {
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:products2Popup" +
        "').show(hints);");
        return null;
    }

    public String ShowPolicies() {
        session.setAttribute("policyCode",null);
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:policiesPopup" +
        "').show(hints);");
        return null;
    }

    public void setPoliciesLOV(RichTable policiesLOV) {
        this.policiesLOV = policiesLOV;
    }

    public RichTable getPoliciesLOV() {
        return policiesLOV;
    }

    public String AssignPolicies() {
        RowKeySet rowKeySet = policiesLOV.getSelectedRowKeys();
                if (!rowKeySet.iterator().hasNext()) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    return null;
                }

                Object key2 = rowKeySet.iterator().next();
               policiesLOV.setRowKey(key2);

                JUCtrlValueBinding r = (JUCtrlValueBinding)policiesLOV.getRowData();

                if (r == null) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    return null;
                } 
                session.setAttribute("policyCode",r.getAttribute("POL_CODE"));
                policyNumber.setValue(r.getAttribute("POL_POLICY_NO"));
        return null;
    }

    public void setEndrDescription2(RichInputText endrDescription2) {
        this.endrDescription2 = endrDescription2;
    }

    public RichInputText getEndrDescription2() {
        return endrDescription2;
    }

    public String ShowEndorsements() {
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:endrPopup" +
        "').show(hints);");
        return null;
    }

    public String AssignEndorsements() {
        RowKeySet rowKeySet = endorsementsLOV.getSelectedRowKeys();
                if (!rowKeySet.iterator().hasNext()) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    return null;
                }

                Object key2 = rowKeySet.iterator().next();
               endorsementsLOV.setRowKey(key2);

                JUCtrlValueBinding r = (JUCtrlValueBinding)endorsementsLOV.getRowData();

                if (r == null) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    return null;
                } 
        session.setAttribute("endrType",r.getAttribute("BTR_TRANS_CODE"));
        endrDescription2.setValue(r.getAttribute("BTR_TRANS_TYPE"));
        return null;
    }

    public void setEndorsementsLOV(RichTable endorsementsLOV) {
        this.endorsementsLOV = endorsementsLOV;
    }

    public RichTable getEndorsementsLOV() {
        return endorsementsLOV;
    }

    public String RunMemberRiReport() {
        JasperReport jasperReport;
        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();
        HashMap parameters = new HashMap();
        parameters = null;
        parameters = new HashMap();
        JasperReport subReport;
        
        
          try {
                 FacesContext context = FacesContext.getCurrentInstance();
                 ServletContext sc = (ServletContext)context.getExternalContext().getContext();
            //System.out.println((BigDecimal)session.getAttribute("endorsementCode"));
                 String path = null;
                 String subPath=null;
                 path = sc.getRealPath("/Reports/member_ri.jrxml");
                 subPath = sc.getRealPath("/Reports/scheme_ri_subreport0.jrxml");
            jasperReport = 
                //JasperCompileManager.compileReport(GlobalCC.reportsPath + "/glquolet.jrxml");
                
                JasperCompileManager.compileReport(path);
                 subReport = JasperCompileManager.compileReport(subPath);
                 parameters.put("subReport",subReport);
                parameters.put("UP_ENDR_TYPE", (String)session.getAttribute("endrType"));
                 parameters.put("UP_POL_CODE", (BigDecimal)session.getAttribute("policyCode"));
                 parameters.put("UP_DATE_FROM", GlobalCC.parseDate(memDateFrom.getValue().toString()));
                 parameters.put("UP_DATE_TO", GlobalCC.parseDate(memDateTo.getValue().toString()));
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
                           response.setHeader("Content-disposition", "attachment; filename=\"ReinsuranceMemberBasis.pdf\"");
                         response.setContentLength(bytes.length);

                         servletOutputStream.write(bytes, 0, bytes.length);
                         servletOutputStream.flush();
                         servletOutputStream.close();
                       }
                       catch (Exception e)
                       {
                         GlobalCC.EXCEPTIONREPORTING(conn, e);
                       }
              
              conn.close();
                 //DispatchReports();
        
             } catch (Exception e) {
          GlobalCC.EXCEPTIONREPORTING(conn, e);
            
        }
        return null;
    }

    public void setPolProductsDesc(RichInputText polProductsDesc) {
        this.polProductsDesc = polProductsDesc;
    }

    public RichInputText getPolProductsDesc() {
        return polProductsDesc;
    }

    public void setProdnProductsLOV(RichTable prodnProductsLOV) {
        this.prodnProductsLOV = prodnProductsLOV;
    }

    public RichTable getProdnProductsLOV() {
        return prodnProductsLOV;
    }

    public String AssignProductionProducts() {
        RowKeySet rowKeySet = prodnProductsLOV.getSelectedRowKeys();
                if (!rowKeySet.iterator().hasNext()) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    return null;
                }

                Object key2 = rowKeySet.iterator().next();
               prodnProductsLOV.setRowKey(key2);

                JUCtrlValueBinding r = (JUCtrlValueBinding)prodnProductsLOV.getRowData();

                if (r == null) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    return null;
                } 
                session.setAttribute("ProductCode",r.getAttribute("PROD_CODE"));
                polProductsDesc.setValue(r.getAttribute("PROD_DESC"));
        return null;
    }

    public String ShowProductionProducts() {
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:prodnProductsPopup" +
        "').show(hints);");
        return null;
    }

    public void setProductionPolicy(RichInputText productionPolicy) {
        this.productionPolicy = productionPolicy;
    }

    public RichInputText getProductionPolicy() {
        return productionPolicy;
    }

    public String ShowProdctionPolicies() {
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:productionPolicies" +
        "').show(hints);");
        return null;
    }

    public void setProdctionPoliciesLOV(RichTable prodctionPoliciesLOV) {
        this.prodctionPoliciesLOV = prodctionPoliciesLOV;
    }

    public RichTable getProdctionPoliciesLOV() {
        return prodctionPoliciesLOV;
    }

    public String AssignProductionPolicies() {
        RowKeySet rowKeySet = prodctionPoliciesLOV.getSelectedRowKeys();
                if (!rowKeySet.iterator().hasNext()) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    return null;
                }

                Object key2 = rowKeySet.iterator().next();
               prodctionPoliciesLOV.setRowKey(key2);

                JUCtrlValueBinding r = (JUCtrlValueBinding)prodctionPoliciesLOV.getRowData();

                if (r == null) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    return null;
                } 
                session.setAttribute("policyCode",r.getAttribute("POL_CODE"));
               productionPolicy.setValue(r.getAttribute("POL_POLICY_NO"));
        return null;
    }

    public void setPerPolicy(RichSelectBooleanRadio perPolicy) {
        this.perPolicy = perPolicy;
    }

    public RichSelectBooleanRadio getPerPolicy() {
        return perPolicy;
    }

    public void setAllPolicies(RichSelectBooleanRadio allPolicies) {
        this.allPolicies = allPolicies;
    }

    public RichSelectBooleanRadio getAllPolicies() {
        return allPolicies;
    }

    public void setPoliciesBtn(RichCommandButton policiesBtn) {
        this.policiesBtn = policiesBtn;
    }

    public RichCommandButton getPoliciesBtn() {
        return policiesBtn;
    }

    public void ShowPoliciesBtn(ValueChangeEvent valueChangeEvent) {
        
        if(perPolicyBox.isSelected()) {
            System.out.println("blah");
            policiesBtn.setRendered(true);
            productionPolicy.setRendered(true);
            AdfFacesContext.getCurrentInstance().addPartialTarget(policiesBtn);
            AdfFacesContext.getCurrentInstance().addPartialTarget(productionPolicy);
        }
    }

    public void showAllPolicies(ValueChangeEvent valueChangeEvent) {
        if(allPoliciesBox.isSelected()) {
            policiesBtn.setRendered(false);
            productionPolicy.setRendered(false);
            session.setAttribute("policyCode",null);
        }
    }

    public void setPerTransaction(RichSelectBooleanRadio perTransaction) {
        this.perTransaction = perTransaction;
    }

    public RichSelectBooleanRadio getPerTransaction() {
        return perTransaction;
    }

    public void setAllTransactions(RichSelectBooleanRadio allTransactions) {
        this.allTransactions = allTransactions;
    }

    public RichSelectBooleanRadio getAllTransactions() {
        return allTransactions;
    }

    public void setProductionTransactions(RichInputText productionTransactions) {
        this.productionTransactions = productionTransactions;
    }

    public RichInputText getProductionTransactions() {
        return productionTransactions;
    }

    public void setTransactionsBtn(RichCommandButton transactionsBtn) {
        this.transactionsBtn = transactionsBtn;
    }

    public RichCommandButton getTransactionsBtn() {
        return transactionsBtn;
    }

    public String ShowProductionTransactions() {
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:prodnTransactionsPopup" +
        "').show(hints);");
        return null;
    }

    public void setProductionTransactionsLOV(RichTable productionTransactionsLOV) {
        this.productionTransactionsLOV = productionTransactionsLOV;
    }

    public RichTable getProductionTransactionsLOV() {
        return productionTransactionsLOV;
    }

    public String AssignProductionTransactions() {
        RowKeySet rowKeySet = productionTransactionsLOV.getSelectedRowKeys();
                if (!rowKeySet.iterator().hasNext()) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    return null;
                }

                Object key2 = rowKeySet.iterator().next();
               productionTransactionsLOV.setRowKey(key2);

                JUCtrlValueBinding r = (JUCtrlValueBinding)productionTransactionsLOV.getRowData();

                if (r == null) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    return null;
                } 
        session.setAttribute("endrType",r.getAttribute("BTR_TRANS_CODE"));
        productionTransactions.setValue(r.getAttribute("BTR_TRANS_TYPE"));
        return null;
    }

    public void ShowTransactionsBtn(ValueChangeEvent valueChangeEvent) {
        if(perTransactionBox.isSelected()) {
            transactionsBtn.setRendered(true);
            productionTransactions.setRendered(true);
            AdfFacesContext.getCurrentInstance().addPartialTarget(transactionsBtn);
            AdfFacesContext.getCurrentInstance().addPartialTarget(productionTransactions);
        }
    }

    public void HideTransactionsBtn(ValueChangeEvent valueChangeEvent) {
        if(allTranactionsBox.isSelected()) {
            transactionsBtn.setRendered(false);
            productionTransactions.setRendered(false);
            session.setAttribute("endrType",null);
        }
    }

    public String RunProductionReport() {
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
            //System.out.println((BigDecimal)session.getAttribute("endorsementCode"));
                 String path = null;
                 path = sc.getRealPath("/Reports/pol_prod.jrxml");
            jasperReport = 
                //JasperCompileManager.compileReport(GlobalCC.reportsPath + "/glquolet.jrxml");
                
                JasperCompileManager.compileReport(path);
            
                parameters.put("UP_ENDR_TYPE", (String)session.getAttribute("endrType"));
                 parameters.put("UP_POL_CODE", (BigDecimal)session.getAttribute("policyCode"));
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
                           response.setHeader("Content-disposition", "attachment; filename=\"PolicyTransactionsListing.pdf\"");
                         response.setContentLength(bytes.length);

                         servletOutputStream.write(bytes, 0, bytes.length);
                         servletOutputStream.flush();
                         servletOutputStream.close();
                       }
                       catch (Exception e)
                       {
                         GlobalCC.EXCEPTIONREPORTING(conn, e);
                       }
              
              conn.close();
                 //DispatchReports();
        
             } catch (Exception e) {
          GlobalCC.EXCEPTIONREPORTING(conn, e);
            
        }
        return null;
    }

    public void setPerPolicyBox(RichSelectBooleanCheckbox perPolicyBox) {
        this.perPolicyBox = perPolicyBox;
    }

    public RichSelectBooleanCheckbox getPerPolicyBox() {
        return perPolicyBox;
    }

    public void setAllPoliciesBox(RichSelectBooleanCheckbox allPoliciesBox) {
        this.allPoliciesBox = allPoliciesBox;
    }

    public RichSelectBooleanCheckbox getAllPoliciesBox() {
        return allPoliciesBox;
    }

    public void setPerTransactionBox(RichSelectBooleanCheckbox perTransactionBox) {
        this.perTransactionBox = perTransactionBox;
    }

    public RichSelectBooleanCheckbox getPerTransactionBox() {
        return perTransactionBox;
    }

    public void setAllTranactionsBox(RichSelectBooleanCheckbox allTranactionsBox) {
        this.allTranactionsBox = allTranactionsBox;
    }

    public RichSelectBooleanCheckbox getAllTranactionsBox() {
        return allTranactionsBox;
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

    public void setMemDateFrom(RichInputDate memDateFrom) {
        this.memDateFrom = memDateFrom;
    }

    public RichInputDate getMemDateFrom() {
        return memDateFrom;
    }

    public void setMemDateTo(RichInputDate memDateTo) {
        this.memDateTo = memDateTo;
    }

    public RichInputDate getMemDateTo() {
        return memDateTo;
    }

    public void setPrdnDateFrom(RichInputDate prdnDateFrom) {
        this.prdnDateFrom = prdnDateFrom;
    }

    public RichInputDate getPrdnDateFrom() {
        return prdnDateFrom;
    }

    public void setPrdnDateTo(RichInputDate prdnDateTo) {
        this.prdnDateTo = prdnDateTo;
    }

    public RichInputDate getPrdnDateTo() {
        return prdnDateTo;
    }

    public String RunProductionReports() {
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
            //System.out.println((BigDecimal)session.getAttribute("endorsementCode"));
                 String path = null;
                 path = sc.getRealPath("/Reports/busgenert.jrxml");
            jasperReport = 
                //JasperCompileManager.compileReport(GlobalCC.reportsPath + "/glquolet.jrxml");
                
                JasperCompileManager.compileReport(path);
            
                 parameters.put("UP_DATE_FROM", GlobalCC.parseDate(prdnDateFrom.getValue().toString()));
                 parameters.put("UP_DATE_TO", GlobalCC.parseDate(prdnDateTo.getValue().toString()));
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
                           response.setHeader("Content-disposition", "attachment; filename=\"PolicyTransactionsListing.pdf\"");
                         response.setContentLength(bytes.length);

                         servletOutputStream.write(bytes, 0, bytes.length);
                         servletOutputStream.flush();
                         servletOutputStream.close();
                       }
                       catch (Exception e)
                       {
                         GlobalCC.EXCEPTIONREPORTING(conn, e);
                       }
              
              conn.close();
                 //DispatchReports();
        
             } catch (Exception e) {
          GlobalCC.EXCEPTIONREPORTING(conn, e);
            
        }
        return null;
    }

    public void setGrpDateFrom(RichInputDate grpDateFrom) {
        this.grpDateFrom = grpDateFrom;
    }

    public RichInputDate getGrpDateFrom() {
        return grpDateFrom;
    }

    public void setGrpTransactionType(RichInputText grpTransactionType) {
        this.grpTransactionType = grpTransactionType;
    }

    public RichInputText getGrpTransactionType() {
        return grpTransactionType;
    }

    public void setGrpTransactionsLOV(RichTable grpTransactionsLOV) {
        this.grpTransactionsLOV = grpTransactionsLOV;
    }

    public RichTable getGrpTransactionsLOV() {
        return grpTransactionsLOV;
    }

    public String AssignGroupProductionTransactions() {
        RowKeySet rowKeySet = grpTransactionsLOV.getSelectedRowKeys();
                if (!rowKeySet.iterator().hasNext()) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    return null;
                }

                Object key2 = rowKeySet.iterator().next();
               grpTransactionsLOV.setRowKey(key2);

                JUCtrlValueBinding r = (JUCtrlValueBinding)grpTransactionsLOV.getRowData();

                if (r == null) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    return null;
                } 
        session.setAttribute("endrType",r.getAttribute("BTR_TRANS_CODE"));
        grpTransactionType.setValue(r.getAttribute("BTR_TRANS_TYPE"));
        return null;
    }

    public String RunGroupProduction() {
        JasperReport jasperReport;
        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();
        HashMap parameters = new HashMap();
        parameters = null;
        parameters = new HashMap();
        JasperReport subReport;
        
        
          try {
                 FacesContext context = FacesContext.getCurrentInstance();
                 ServletContext sc = (ServletContext)context.getExternalContext().getContext();
            //System.out.println((BigDecimal)session.getAttribute("endorsementCode"));
                 String path = null;
                 String subPath=null;
                 path = sc.getRealPath("/Reports/grpbusprd.jrxml");
                 //subPath = sc.getRealPath("/Reports/scheme_ri_subreport0.jrxml");
            jasperReport = 
                //JasperCompileManager.compileReport(GlobalCC.reportsPath + "/glquolet.jrxml");
                
                JasperCompileManager.compileReport(path);
                 //subReport = JasperCompileManager.compileReport(subPath);
                
                parameters.put("UP_ENDR_TYPE", (String)session.getAttribute("endrType"));
                 //parameters.put("UP_POL_CODE", (BigDecimal)session.getAttribute("policyCode"));
                 parameters.put("UP_DATE_FROM", GlobalCC.parseDate(grpDateFrom.getValue().toString()));
                 parameters.put("UP_DATE_TO", GlobalCC.parseDate(grpDateTo.getValue().toString()));
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
                           response.setHeader("Content-disposition", "attachment; filename=\"GroupProduction.pdf\"");
                         response.setContentLength(bytes.length);

                         servletOutputStream.write(bytes, 0, bytes.length);
                         servletOutputStream.flush();
                         servletOutputStream.close();
                       }
                       catch (Exception e)
                       {
                         GlobalCC.EXCEPTIONREPORTING(conn, e);
                       }
              
              conn.close();
                 //DispatchReports();
        
             } catch (Exception e) {
          GlobalCC.EXCEPTIONREPORTING(conn, e);
            
        }
        return null;
    }

    public void setGrpDateTo(RichInputDate grpDateTo) {
        this.grpDateTo = grpDateTo;
    }

    public RichInputDate getGrpDateTo() {
        return grpDateTo;
    }

    public void setTrntType(RichSelectOneChoice trntType) {
        this.trntType = trntType;
    }

    public RichSelectOneChoice getTrntType() {
        return trntType;
    }

    public void setTrntProdApplicable(RichSelectOneChoice trntProdApplicable) {
        this.trntProdApplicable = trntProdApplicable;
    }

    public RichSelectOneChoice getTrntProdApplicable() {
        return trntProdApplicable;
    }

    public void setTrntAppLevel(RichSelectOneChoice trntAppLevel) {
        this.trntAppLevel = trntAppLevel;
    }

    public RichSelectOneChoice getTrntAppLevel() {
        return trntAppLevel;
    }

    public void setUsersTable(RichTable usersTable) {
        this.usersTable = usersTable;
    }

    public RichTable getUsersTable() {
        return usersTable;
    }
}
