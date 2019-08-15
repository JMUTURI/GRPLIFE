package LMSG.view.ecm;


import LMSG.view.BPM.ProcessDMSTicket;
import LMSG.view.Base.ADFUtils;
import LMSG.view.Base.GlobalCC;


import LMSG.view.Quotation.Quotations;
import LMSG.view.connect.DBConnector;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.FileOutputStream;
import java.io.InputStream;

import java.io.OutputStream;

import java.math.BigDecimal;
import java.math.BigInteger;

import java.sql.CallableStatement;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.List;

import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import javax.servlet.ServletContext;

import oracle.adf.view.rich.component.rich.RichDialog;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.layout.RichPanelBox;

import org.apache.chemistry.opencmis.commons.data.ContentStream;
import javax.servlet.http.HttpSession;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.Key;
import oracle.jbo.Row;

import oracle.jdbc.OracleConnection;
import oracle.jdbc.OracleTypes;

import org.alfresco.cmis.client.AlfrescoDocument;

import org.apache.chemistry.opencmis.client.api.CmisObject;
import org.apache.chemistry.opencmis.client.api.Folder;
import org.apache.chemistry.opencmis.client.api.Document;
import org.apache.chemistry.opencmis.client.api.Policy;
import org.apache.chemistry.opencmis.client.api.Session;
import org.apache.chemistry.opencmis.commons.PropertyIds;
import org.apache.chemistry.opencmis.commons.data.Ace;
import org.apache.chemistry.opencmis.commons.enums.VersioningState;
import org.apache.chemistry.opencmis.commons.impl.dataobjects.ContentStreamImpl;
import org.apache.myfaces.trinidad.model.RowKeySet;

public class EcmTrans {
    
    private String host = GlobalCC.findSysParam("AIICO_DMS_HOST",null);
    private String port = GlobalCC.findSysParam("AIICO_DMS_PORT",null);

    //All Docs in policy
    String alldocpath= "http://"+host+":"+port+"/omnidocs/webapi/ImageEnablement" +
                    "/ImageEnablement.jsp?Application=Underwriting&Policy_No=";
    
    //All Underwriting
    String poldocpath= "http://"+host+":"+port+"/omnidocs/webapi/ImageEnablement" +
                    "/ImageEnablement.jsp?Application=Underwriting&Policy_Number=";
    
    //All Claims
    String claimdocpath="http://"+host+":"+port+"/omnidocs/webapi/ImageEnablement" +
                    "/ImageEnablement.jsp?Application=Claims&Policy_Number=";
    private HtmlPanelGrid panelGridOne;
    private HtmlPanelGrid panelGridMulti;
    private RichPanelBox pnlBoxOne;
    private RichPanelBox pnlBoxTwo;
    private RichTable quoProdTab;
    private RichInputText productDesc;
    private RichTable quoQuotationTab;
    private RichDialog addedDocsTab;
    private RichDialog newDocsTab;
    private RichTable addDocTab;

    public EcmTrans() {
        super();
    }

    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);

    public String attachQuote() {
        
        session.setAttribute("dmsProcess","Y");
        session.setAttribute("dmsProcessType","Quot");
        String ScreenName = "g_qtrans.jspx";
        GlobalCC.RedirectPage("/" + ScreenName);
        return null;
    }

    public String attachPolicy() {
        session.setAttribute("dmsProcess","Y");
        session.setAttribute("dmsProcessType","Pol");
        String ScreenName = "selectPolicyTrans.jspx";
        GlobalCC.RedirectPage("/" + ScreenName);
        return null;
    }

    public String AttachMedPolicy() {
        session.setAttribute("dmsProcess","Y");
        session.setAttribute("medProcess","Y");
        session.setAttribute("dmsProcessType","PolMed");
        String ScreenName = "selectPolicyTrans.jspx";
        GlobalCC.RedirectPage("/" + ScreenName);
        return null;
    }

    public String attachClaim() {
        session.setAttribute("EditClaim",new Integer(1));
        session.setAttribute("dmsProcess","Y");
        session.setAttribute("dmsProcessType","PolClaim");
        String ScreenName = "g_edtclm.jspx";
        GlobalCC.RedirectPage("/" + ScreenName);
        return null;
    }
    
    public static String UploadFile(Session session, Folder ParentFolder,
                      String FileNameInDms, File file, String FileMimeType,
                      String aspectTypes,List<EcmProps> props)
                      throws FileNotFoundException {

          Map<String, Object> properties = new HashMap<String, Object>();
          //properties.put(PropertyIds.OBJECT_TYPE_ID, "cmis:document");
           properties.put(PropertyIds.OBJECT_TYPE_ID,aspectTypes);
          //properties.put(PropertyIds.OBJECT_TYPE_ID, "cmis:document,P:cm:titled");
          properties.put(PropertyIds.NAME, FileNameInDms);
                   for(EcmProps property:props)
                   properties.put(property.getName(), property.getValue());
              
             // properties.put("tqgib:UNWRDeptPolicyNumber", "101404010211");
              List<Ace> addAces = new LinkedList<Ace>();
              List<Ace> removeAces = new LinkedList<Ace>();
              List<Policy> policies = new LinkedList<Policy>();
              ContentStream contentStream;
              
              System.out.println("The file size " + String.valueOf(file.length()));
              contentStream = new ContentStreamImpl(FileNameInDms,
                              BigInteger.valueOf(file.length()), FileMimeType,
                              new FileInputStream(file));

              Document newDocument = ParentFolder.createDocument(properties,
                              contentStream, VersioningState.MAJOR, policies, addAces,
                              removeAces, session.getDefaultContext());
              return (newDocument.getName());
      }

    public void setAlldocpath(String alldocpath) {
        this.alldocpath = alldocpath;
    }

    public String getAlldocpath() {
        return alldocpath;
    }

    public void setPoldocpath(String poldocpath) {
        this.poldocpath = poldocpath;
    }

    public String getPoldocpath() {
        return poldocpath;
    }

    public void setClaimdocpath(String claimdocpath) {
        this.claimdocpath = claimdocpath;
    }

    public String getClaimdocpath() {
        return claimdocpath;
    }

    public void operationType(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        
        if (valueChangeEvent.getNewValue().toString().equalsIgnoreCase("SO")) {
            
            pnlBoxOne.setVisible(true);
            pnlBoxTwo.setVisible(false); 
        } else {
            pnlBoxTwo.setVisible(true);
            pnlBoxOne.setVisible(false);
            //panelGridOne.setRendered(false);
            System.out.println("Here we go!! MO");   
        }
        
        AdfFacesContext.getCurrentInstance().addPartialTarget(pnlBoxOne);
        AdfFacesContext.getCurrentInstance().addPartialTarget(pnlBoxTwo);
    }

    public void setPanelGridOne(HtmlPanelGrid panelGridOne) {
        this.panelGridOne = panelGridOne;
    }

    public HtmlPanelGrid getPanelGridOne() {
        return panelGridOne;
    }

    public void setPanelGridMulti(HtmlPanelGrid panelGridMulti) {
        this.panelGridMulti = panelGridMulti;
    }

    public HtmlPanelGrid getPanelGridMulti() {
        return panelGridMulti;
    }

    public void setPnlBoxOne(RichPanelBox pnlBoxOne) {
        this.pnlBoxOne = pnlBoxOne;
    }

    public RichPanelBox getPnlBoxOne() {
        return pnlBoxOne;
    }

    public void setPnlBoxTwo(RichPanelBox pnlBoxTwo) {
        this.pnlBoxTwo = pnlBoxTwo;
    }

    public RichPanelBox getPnlBoxTwo() {
        return pnlBoxTwo;
    }

    public String openQuoteDialog() {
        // Add event code here...
        GlobalCC.showPopup("lmsgroup:quots");
        return null;
    }

    public void setQuoProdTab(RichTable quoProdTab) {
        this.quoProdTab = quoProdTab;
    }

    public RichTable getQuoProdTab() {
        return quoProdTab;
    }

    public String AssignProduct() {
        // Add event code here...
        DCIteratorBinding dciter = ADFUtils.findIterator("findProductsIterator");
        RowKeySet set;
        set = quoProdTab.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
           
           while (rowKeySetIter.hasNext()) {
           List l = (List) rowKeySetIter.next();
           Key key = (Key)l.get(0);
           dciter.setCurrentRowWithKey(key.toStringFormat(true));
          
           Row r = dciter.getCurrentRow();
           session.setAttribute("ProductCode", r.getAttribute("prodCode"));
           session.setAttribute("transType","DMS");
           session.setAttribute("productDesc",  r.getAttribute("prodDesc"));
           session.setAttribute("QuoteCode",null);
           productDesc.setValue(session.getAttribute("productDesc"));
                    
        }
        GlobalCC.hidePopup("lmsgroup:productsPopup");
      
        AdfFacesContext.getCurrentInstance().addPartialTarget(productDesc);
        ADFUtils.findIterator("findQuotationIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(quoQuotationTab);
        
        ADFUtils.findIterator("findDMSProcessDocsIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(addDocTab);
        return null;
    }

    public void setProductDesc(RichInputText productDesc) {
        this.productDesc = productDesc;
    }

    public RichInputText getProductDesc() {
        return productDesc;
    }

    public void setQuoQuotationTab(RichTable quoQuotationTab) {
        this.quoQuotationTab = quoQuotationTab;
    }

    public RichTable getQuoQuotationTab() {
        return quoQuotationTab;
    }

    public String addQuote() {
        // Add event code here...
        //LMS_SETUPS_PKG.createUpdateDMS()
        Connection conn = null;
        DBConnector MyDB = new DBConnector();
        conn = MyDB.getDatabaseConn();
        CallableStatement lgcallStmt = null;
        
        DCIteratorBinding dciter = ADFUtils.findIterator("findQuotationIterator");
        RowKeySet set;
        set = quoQuotationTab.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
           
           while (rowKeySetIter.hasNext()) {
           List l = (List) rowKeySetIter.next();
           Key key = (Key)l.get(0);
           dciter.setCurrentRowWithKey(key.toStringFormat(true));
          
           Row r = dciter.getCurrentRow();
           session.setAttribute("quoNo", r.getAttribute("quoNo"));
           session.setAttribute("processCode",r.getAttribute("quoCode"));
          
        }
      
        String dmsprocessing =
            "begin LMS_SETUPS_PKG.createUpdateDMS(?,?,?,?); end;";
        try {
          
              lgcallStmt = conn.prepareCall(dmsprocessing);
              lgcallStmt.setBigDecimal(1,
                                       (BigDecimal)session.getAttribute("ddpCode"));
              lgcallStmt.setString(2,String.valueOf(session.getAttribute("quoNo")));
              lgcallStmt.setString(3,"QUOT");
              lgcallStmt.setBigDecimal(4,(BigDecimal)session.getAttribute("processCode"));
              
              lgcallStmt.execute();
              lgcallStmt.close();
              conn.close();
              GlobalCC.sysInformation("Record Added!");
        } catch (Exception e) {
            e.printStackTrace();
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        session.setAttribute("dmsTranstype","QUOT");
        
        ADFUtils.findIterator("findDMSProcessDocsIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(addDocTab);
        return null;
    }

    public void setAddDocTab(RichTable addDocTab) {
        this.addDocTab = addDocTab;
    }

    public RichTable getAddDocTab() {
        return addDocTab;
    }

    public String removeQuoteDoc() {
        // Add event code here...
        Connection conn = null;
        DBConnector MyDB = new DBConnector();
        conn = MyDB.getDatabaseConn();
        CallableStatement lgcallStmt = null;
        
        DCIteratorBinding dciter = ADFUtils.findIterator("findDMSProcessDocsIterator");
        RowKeySet set;
        set = addDocTab.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
           
           while (rowKeySetIter.hasNext()) {
           List l = (List) rowKeySetIter.next();
           Key key = (Key)l.get(0);
           dciter.setCurrentRowWithKey(key.toStringFormat(true));
          
           Row r = dciter.getCurrentRow();
           session.setAttribute("ddpCode", r.getAttribute("DDP_CODE"));
          
        }
        
        String dmsprocessing =
            "begin LMS_SETUPS_PKG.deleteDocDms(?); end;";
        try {
          
              lgcallStmt = conn.prepareCall(dmsprocessing);
              lgcallStmt.setBigDecimal(1,
                                       (BigDecimal)session.getAttribute("ddpCode"));
              
              lgcallStmt.execute();
              lgcallStmt.close();
              conn.close();
              GlobalCC.sysInformation("Document removed!");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        session.setAttribute("dmsTranstype","QUOT");
        
        ADFUtils.findIterator("findDMSProcessDocsIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(addDocTab);
        return null;
    }

    public String processDMSTicket() {
        // Add event code here...
        String docid = (String)session.getAttribute("docId");
        Connection conn = null;
        DBConnector MyDB = new DBConnector();
        conn = MyDB.getDatabaseConn();
        CallableStatement cst = null;
        
        try
        {
            String remarksQuery = "BEGIN LMS_WEB_CURSOR_GRP.getUnProccesedDMS(?,?);END;";
            cst = conn.prepareCall(remarksQuery);
            cst.registerOutParameter(1,OracleTypes.CURSOR);
            cst.setString(2, (String)session.getAttribute("dmsTranstype"));
            cst.execute();
              
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next())
            {
                session.setAttribute("ddpCode",rs.getBigDecimal(1));
                session.setAttribute("dmsQuoNo",rs.getString(2));
                session.setAttribute("quoClient",rs.getString(4));
                session.setAttribute("dmsQuoDate",rs.getString(5));
                session.setAttribute("QuoteCode",rs.getBigDecimal(9));
                updateQuotDocEnmass();
                
            }
  
            rs.close();
            cst.close();
            conn.close();
            
            //update ticket as processed
            ProcessDMSTicket dbConn = new ProcessDMSTicket();
            OracleConnection conn2 = null;
            conn2 = dbConn.getDatabaseConnection();
            PreparedStatement stmt = null;
            
            String query =
              "update lms_dms_documents set dd_processed = 'Y' where dd_doc_id = ?";
            try {
              stmt = conn2.prepareStatement(query);
              stmt.setString(1, docid);
              stmt.execute();
              conn2.commit();
              conn2.close();
              session.removeAttribute("docId");
              session.setAttribute("dmsProcess", null);
              session.setAttribute("dmsProcessType", "");
              
              ADFUtils.findIterator("findDMSProcessDocsIterator").executeQuery();
              AdfFacesContext.getCurrentInstance().addPartialTarget(addDocTab);
              GlobalCC.sysInformation("Documents Updated Successfully!");
              GlobalCC.hidePopup("lmsgroup:quotations");
                
              //implement redirect
              //VQ
              session.setAttribute("transType","VQ");              
              GlobalCC.RedirectPage("/gquoedt.jspx");
            } catch (SQLException e) {
              e.printStackTrace();
              GlobalCC.EXCEPTIONREPORTING(conn2, e);
            }
        }
        
        catch (Exception e) {
          e.printStackTrace();
          GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
                
        return null;
    }
    
    public String updateQuotDocEnmass() throws Exception{
        String docid = (String)session.getAttribute("docId");
        EcmUtil ecmUtil = new EcmUtil();
      org.apache.chemistry.opencmis.client.api.Session sessions =
        ecmUtil.Authentification();
      Document document = (Document)sessions.getObject(docid);
      
      //get the document name
      String fileName = document.getContentStreamFileName();
      fileName = fileName.replace(" ", "_").replace("/","_").replace("(", "").replace(")", "");
      //get the document mimetype
      String mimetype = document.getContentStreamMimeType();
        
        if (docid != null) {
          String aspect = "D:tqlms:tqlmsgrpDocumentType, P:tqlms:grpdocumentData";

          String clientName = (String)session.getAttribute("quoClient");
          Session ecmSession = ecmUtil.Authentification();

          if (ecmSession == null) {
            GlobalCC.errorValueNotEntered("Please Check alfresco connection : Can't Connect to alfresco!!");
            return null;
          }

          String policyNo = String.valueOf(session.getAttribute("dmsQuoNo"));
          String policyNo2 = String.valueOf(session.getAttribute("dmsQuoNo"));
          String quoDate = String.valueOf(session.getAttribute("dmsQuoDate"));

          policyNo = policyNo.replace("/", "_");
          boolean checkLms = ecmUtil.checkDir(ecmSession, "/TQLMSGRP");
          if (checkLms == false) {
            ecmUtil.createDirInRootFolder(ecmSession, "TQLMSGRP");
          }
          String filePath = "/TQLMSGRP/QUOT";
          boolean check = ecmUtil.checkDir(ecmSession, filePath);
          if (check == false) {
            CmisObject objectLms = ecmSession.getObjectByPath("/TQLMSGRP");
            Folder folderLms = (Folder)objectLms;
            String fpath = "QUOT";
            ecmUtil.createDir(ecmSession, folderLms, fpath);
          }

          filePath = filePath + "/" + policyNo;
          boolean check1 = ecmUtil.checkDir(ecmSession, filePath);
          if (check1 == false) {
            CmisObject objectPolAuth =
              ecmSession.getObjectByPath("/TQLMSGRP/QUOT");
            Folder folderLms = (Folder)objectPolAuth;
            String fpath = policyNo;
            ecmUtil.createDir(ecmSession, folderLms, fpath);
          }
          CmisObject object = ecmSession.getObjectByPath(filePath);
          Folder folder = (Folder)object;
          
          List<EcmProps> properties = new ArrayList<EcmProps>();
          properties.add(new EcmProps("tqlms:quotationno", policyNo2));
          properties.add(new EcmProps("tqlms:orgclientname", clientName));
          
          //quoDate
          //we should update but date format not worked out yet alfresco side
          properties.add(new EcmProps("tqlms:grpdate", null));
          properties.add(new EcmProps("tqlms:grpdoccode", "0"));
          
          try {
            EcmTrans.UploadFile(ecmSession, folder, fileName, this.getFileInfoFromDms(),
                                mimetype, aspect, properties);
              
            //update each updated quotation that was added for processing
            //update ticket as processed
            ProcessDMSTicket dbConn = new ProcessDMSTicket();
            OracleConnection conn2 = null;
            conn2 = dbConn.getDatabaseConnection();
            PreparedStatement stmt = null;

            String query =
              "update LMS_DMS_DOC_PROCESSING set DDP_PROCESSED = 'Y' where ddp_code = ?";
            try {
                stmt = conn2.prepareStatement(query);
                stmt.setBigDecimal(1, (BigDecimal)session.getAttribute("ddpCode"));
                stmt.execute();
                conn2.commit();
                conn2.close();
                
                session.setAttribute("ddpCode",null);

            } catch (SQLException e) {
              e.printStackTrace();
              GlobalCC.EXCEPTIONREPORTING(conn2, e);
            }
          } catch (Exception e) {
             e.printStackTrace();
             GlobalCC.alfrescoError(e);
             
             //Added to propergate the exception to the calling method
             throw new Exception("An Error occured!");
             
          }
       
        }
        return null;
    }
    
    public File getFileInfoFromDms(){
        String docid = (String)session.getAttribute("docId");
        File fl = new File("");
        EcmUtil ecmUtil = new EcmUtil();
        try {
            org.apache.chemistry.opencmis.client.api.Session sessions =
              ecmUtil.Authentification();
            Document document = (Document)sessions.getObject(docid);
            
            //get the document name
            String filename = document.getContentStreamFileName();
            filename = filename.replace(" ", "_").replace("/","_");
            //get the document mimetype
            String mimetype = document.getContentStreamMimeType();
            
            //get actual file
            InputStream inputStream = document.getContentStream().getStream();
            String file = "/Reports/" + filename;
            FacesContext context = FacesContext.getCurrentInstance();
            ServletContext sc =
              (ServletContext)context.getExternalContext().getContext();
            file = sc.getRealPath(file);
            System.out.println("");
            fl = new File(file);
            OutputStream out;
            out = new FileOutputStream(fl);
            int read = 0;
            byte[] bytes = new byte[1024];
        
            while ((read = inputStream.read(bytes)) != -1) {
              out.write(bytes, 0, read);
            }
        
            inputStream.close();
            out.flush();
            out.close();
          
        } catch (Exception e){
            e.printStackTrace();
            GlobalCC.sysInformation("Error occured! " + e.getMessage());
        }
        return fl;
    }

    public String openPolicyDialogue() {
        // Add event code here...
        GlobalCC.showPopup("lmsgroup:pols");
        return null;
    }

    public String openClaimDialog() {
        // Add event code here...
        GlobalCC.showPopup("lmsgroup:claimSelect");
        return null;
    }
}
