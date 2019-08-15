package LMSG.view.utilities;

import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.html.HtmlInputTextarea;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.data.RichTable;

import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.Key;
import oracle.jbo.Row;

import org.apache.myfaces.trinidad.model.RowKeySet;

import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

import LMSG.view.Base.ADFUtils;

import LMSG.view.Base.GlobalCC;

import LMSG.view.Base.LOVCC;
import LMSG.view.Base.Settings;


import LMSG.view.QuotationProcessing.QuotDAO;

import LMSG.view.connect.DBConnector;

import oracle.jdbc.OracleTypes;

public class systemsManipulation extends LOVCC {

    private static BigDecimal systemCode;
    private static BigDecimal quotationCode;
    private static String quotationNo;
    private static Integer email_Code;
    private static BigDecimal clientCode;
    private static BigDecimal agentCode;
    private static BigDecimal policyCode;
    private static String policyNumber;
    private static String claimNo;
    //protected static Integer email_Code;
    protected static BigDecimal smsCode;
    
    
    private RichTable systemsLOV;
    private RichInputText systemName;
    private RichTable emailClientsLOV;
    private RichInputText emailClient;
    private RichTable agentsEmailLOV;
    private RichInputText agentName1;
    private RichTable smsQuotationLOV;
    private RichInputText smsQuotationNumber;
    private RichTable policiesLOV;
    private RichInputText systemPolicyNumber;
    private RichTable emailClaimsLOV;
    private RichInputText claimNumber1;
    private RichInputText smsMessageStatus;
    private RichInputText smsTelephoneNumber;
    private HtmlInputTextarea smsMessage;
    private RichTable msgTemplate;
    private RichInputText msgTemplateDesc;
    
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    
    public String RenderTemplatePopup(){
        
        try{

            ADFUtils.findIterator("findMessageTemplatesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(msgTemplate);
            
            // Render Popup
            GlobalCC.showPopup("demoTemplate:msgTemplate");
         
              
        }catch(Exception e) 
      {
       GlobalCC.EXCEPTIONREPORTING(null, e);
      }
        
        return null;
    }

    public String msgTemplateSelected() {
        //valueChangeEvent.getNewValue();
        DCIteratorBinding dciter = ADFUtils.findIterator("findMessageTemplatesIterator");
        RowKeySet set = msgTemplate.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));

            Row r = dciter.getCurrentRow();

            session.setAttribute("msgTempCode", r.getAttribute("msgCode"));
            session.setAttribute("msgTempShtDesc", r.getAttribute("msgShtDesc"));
            String Result = ProcessMessage((String)r.getAttribute("msgDesc"));
            session.setAttribute("msgTempDesc", Result);
            msgTemplateDesc.setValue(r.getAttribute("msgShtDesc"));


        }
       
      
        return null;
    }
    
    public String ProcessMessage(String Message){
      String Result = null;
      Connection conn=new DBConnector().getDatabaseConn();
      try{
        String saveQuery="BEGIN ? := LMS_GRP_MISC.PROCESS_MSG(?,?,?,?,?);END;";
        CallableStatement cstmt=null;
        cstmt=conn.prepareCall(saveQuery);
        
        cstmt.registerOutParameter(1,
                                 OracleTypes.VARCHAR); //authorization code
        String SysMdl = (String)session.getAttribute("sysModule");
        if(SysMdl.equalsIgnoreCase("Q")){
          cstmt.setBigDecimal(2, (BigDecimal)session.getAttribute("QuoteCode")); 
        }else{
          cstmt.setBigDecimal(2, (BigDecimal)session.getAttribute("endorsementCode")); 
        }
        cstmt.setString(3, (String)session.getAttribute("ClaimNo"));
        cstmt.setString(4, Message);
        cstmt.setString(5, SysMdl);
        cstmt.setString(6, null);
        cstmt.execute();
        if(cstmt.getString(1)==null){
          Result = Message;
        }else{
          Result = cstmt.getString(1);
        }
        cstmt.close();
        conn.close();
      }catch(Exception e){
        GlobalCC.EXCEPTIONREPORTING(conn, e);
      }
      return Result;
    }

    public String AssignSystemsLOV() {
        Connection connCode=null;
     try 
        {
      DCIteratorBinding dciter = ADFUtils.findIterator("findSystemsIterator");
      RowKeySet set = systemsLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      
      //System.out.println(1);
      while (rowKeySetIter.hasNext()) 
      {
          List l = (List) rowKeySetIter.next();
          Key key = (Key)l.get(0);
          dciter.setCurrentRowWithKey(key.toStringFormat(true));
          Row r = dciter.getCurrentRow();
           systemName.setValue(r.getAttribute("SYS_NAME"));
           systemCode=(BigDecimal)r.getAttribute("SYS_CODE");
        
      }
      Statement cstCode=null;
      ResultSet rs=null;
      
        connCode=new DBConnector().getDatabaseConn();
        cstCode=connCode.createStatement();
        rs=cstCode.executeQuery("select TQC_SMS_CODE_SEQ.NEXTVAL FROM DUAL");
        while(rs.next()) 
        {
          email_Code=rs.getInt(1);
        }
      }
      catch(Exception ex) 
      {
            GlobalCC.EXCEPTIONREPORTING(connCode,ex);
      }
      return null;
     
    }
    
    public String AssignClientsLOV() {
    try{
      DCIteratorBinding dciter = ADFUtils.findIterator("findEmailClientsIterator");
      RowKeySet set = emailClientsLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      
      //System.out.println(1);
      while (rowKeySetIter.hasNext()) 
      {
          List l = (List) rowKeySetIter.next();
          Key key = (Key)l.get(0);
          dciter.setCurrentRowWithKey(key.toStringFormat(true));
          Row r = dciter.getCurrentRow();
           emailClient.setValue(r.getAttribute("NAME"));
           clientCode=(BigDecimal)r.getAttribute("CLNT_CODE");
        
      }
    }catch(Exception ex) 
        {
            GlobalCC.EXCEPTIONREPORTING(null,ex);
        }
      return null;
    }
    
    public String AssignAgentsLOV() {
    try{
      DCIteratorBinding dciter = ADFUtils.findIterator("findAgentsIterator");
      RowKeySet set = agentsEmailLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      
      //System.out.println(1);
      while (rowKeySetIter.hasNext()) 
      {
          List l = (List) rowKeySetIter.next();
          Key key = (Key)l.get(0);
          dciter.setCurrentRowWithKey(key.toStringFormat(true));
          Row r = dciter.getCurrentRow();
           agentName1.setValue(r.getAttribute("AGN_NAME"));
           agentCode=(BigDecimal)r.getAttribute("AGN_CODE");
        
      }
        }catch(Exception ex) 
            {
            GlobalCC.EXCEPTIONREPORTING(null,ex);
            }
      return null;
    }
    
    public String AssignSmsQuotation() {
        try{
      DCIteratorBinding dciter = ADFUtils.findIterator("findSmsQuotationIterator");
      RowKeySet set = smsQuotationLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      
      //System.out.println(1);
      while (rowKeySetIter.hasNext()) 
      {
          List l = (List) rowKeySetIter.next();
          Key key = (Key)l.get(0);
          dciter.setCurrentRowWithKey(key.toStringFormat(true));
          Row r = dciter.getCurrentRow();
           smsQuotationNumber.setValue(r.getAttribute("QUOT_NO"));
           quotationCode=(BigDecimal)r.getAttribute("QUOT_CODE");
          quotationNo = (String)r.getAttribute("QUOT_NO");
        
      }
    }catch(Exception ex) 
     {
            GlobalCC.EXCEPTIONREPORTING(null,ex);
     }
      return null;
    }
    
    public String AssignPoliciesLOV() {
    try{
      DCIteratorBinding dciter = ADFUtils.findIterator("findSmsPoliciesIterator");
      RowKeySet set = policiesLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      
      //System.out.println(1);
      while (rowKeySetIter.hasNext()) 
      {
          List l = (List) rowKeySetIter.next();
          Key key = (Key)l.get(0);
          dciter.setCurrentRowWithKey(key.toStringFormat(true));
          Row r = dciter.getCurrentRow();
          systemPolicyNumber.setValue(r.getAttribute("POL_POLICY_NO"));
          policyNumber = (String)r.getAttribute("POL_POLICY_NO");
          policyCode=(BigDecimal)r.getAttribute("POL_BATCH_NO");
        
      }
    }catch(Exception ex) 
         {
            GlobalCC.EXCEPTIONREPORTING(null,ex);
         }
      return null;
    }
    
    public String AssignClaimsLOV() {
        try{
      DCIteratorBinding dciter = ADFUtils.findIterator("findClaimsIterator");
      RowKeySet set = emailClaimsLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      
      //System.out.println(1);
      while (rowKeySetIter.hasNext()) 
      {
          List l = (List) rowKeySetIter.next();
          Key key = (Key)l.get(0);
          dciter.setCurrentRowWithKey(key.toStringFormat(true));
          Row r = dciter.getCurrentRow();
           claimNumber1.setValue(r.getAttribute("cmb_claim_no"));
          claimNo = (String)r.getAttribute("cmb_claim_no");
          
        
      }
    }catch(Exception ex) 
     {
            GlobalCC.EXCEPTIONREPORTING(null,ex);
      }
      return null;
    }
    
    public String saveSMSMessage(){
        String telNo = null;
        String message = null;
        
        telNo = GlobalCC.checkNullValues(smsTelephoneNumber.getValue());
        message = GlobalCC.checkNullValues(smsMessage.getValue());
        
        if(systemCode==null){
            GlobalCC.errorValueNotEntered("SELECT SYSTEM");
            return null;
        }
        if((clientCode==null)&&(agentCode==null)){
            GlobalCC.errorValueNotEntered("SELECT CLIENT OR AGENT");
      
            return null;
        }
        if((quotationCode==null)&&(policyCode==null)&&(claimNo==null)){
            GlobalCC.errorValueNotEntered("SELECT QUOTATION OR POLICY OR CLAIM");
            return null;
        }
        if(telNo==null){
            GlobalCC.errorValueNotEntered("ENTER THE TELEPHONE NUMBER");
            return null;
        }
        if(message==null){
            GlobalCC.errorValueNotEntered("ENTER THE SMS MESSAGAGE");
            return null;
        }
        String todayString = null;
        if(Settings.toDay.toString().contains(":")){
            todayString = GlobalCC.parseDate(Settings.toDay.toString());
        }else{
            todayString = GlobalCC.upDateParseDate(Settings.toDay.toString());
        }
        
        DBConnector connector=new DBConnector();
        Connection conn=connector.getDatabaseConn();
        try 
        {
          PreparedStatement pstUpdate=conn.prepareStatement("INSERT INTO TQC_SMS_MESSAGES VALUES (TQC_SMS_CODE_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pstUpdate.setBigDecimal(1, systemCode);
            pstUpdate.setString(2,"U");
            pstUpdate.setBigDecimal(3,clientCode);
            pstUpdate.setBigDecimal(4,agentCode);
            pstUpdate.setBigDecimal(5,policyCode);
            pstUpdate.setString(6,policyNumber);
            pstUpdate.setString(7,claimNo);
            pstUpdate.setString(8,telNo);
            pstUpdate.setString(9,message);
            pstUpdate.setString(10,"D");
            pstUpdate.setString(11,(String)session.getAttribute("Username"));
            pstUpdate.setString(12, todayString);
            pstUpdate.setString(13, todayString);
            pstUpdate.setBigDecimal(14,quotationCode);
            pstUpdate.setString(15,quotationNo);
            pstUpdate.setBigDecimal(16,(BigDecimal)session.getAttribute("UserCode"));
            //TODO
          //pstUpdate.setBigDecimal(2,smsCode);
          pstUpdate.execute();
            conn.close();    
          smsMessageStatus.setValue("Delivered");
          FacesContext.getCurrentInstance().addMessage(null, 
                                                                  new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                                   "SMS MESSAGE STATUS", 
                                                                                  "Message Sent"));
        }
        catch(Exception ex) 
        {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
        }
        return null;
    }
    
    public String SendMessage() {
      smsMessageStatus.setValue("Ready");
      DBConnector connector=new DBConnector();
      Connection conn=connector.getDatabaseConn();
      try
      {
        Statement stCode=conn.createStatement();
        ResultSet rs=stCode.executeQuery("SELECT TQC_SMS_CODE_SEQ.NEXTVAL FROM DUAL");
        while(rs.next()) 
        {
          smsCode=rs.getBigDecimal(1);
          System.out.println(smsCode);
          
        }
        rs.close();
        stCode.close();
        //conn.close();
      }
      catch(Exception ex) 
      {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
      }
      CallableStatement cst=null;
      try 
      {
        cst=conn.prepareCall("BEGIN TQC_SMS_PKG.SEND_SMS_MSG(?,?,?,?,?,?,?,?,?,?,?,?,?);END;");
        cst.setBigDecimal(1,clientCode);
        cst.setBigDecimal(2,agentCode);
        cst.setBigDecimal(3,quotationCode);
        cst.setString(4,smsQuotationNumber.getValue().toString());
        cst.setBigDecimal(5,policyCode);
        cst.setString(6,systemPolicyNumber.getValue().toString());
        cst.setString(7,claimNumber1.getValue().toString());
        cst.setString(8,smsTelephoneNumber.getValue().toString());
        cst.setString(9,smsMessage.getValue().toString());
        cst.setBigDecimal(10,systemCode);
        cst.setString(11,"U");
        cst.setString(12,"KIM");
        cst.setBigDecimal(13,smsCode);
        cst.execute();
        cst.close();
          conn.close();    
      }
      catch(Exception ex) 
      {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
      }
      try 
      {
        PreparedStatement pstUpdate=conn.prepareStatement("update TQC_SMS_MESSAGES set sms_status = ? WHERE SMS_CODE = ?");
        pstUpdate.setString(1,"R");
        pstUpdate.setBigDecimal(2,smsCode);
        pstUpdate.executeUpdate();
        cst=conn.prepareCall("BEGIN TQC_SMS_PKG.create_sms_xml(?);END;");
        cst.setBigDecimal(1,smsCode);
        cst.execute();
          conn.close();    
        //PreparedStatement pstStatusUpdate=conn.prepareStatement("update TQC_SMS_MESSAGES set sms_status = ? WHERE SMS_CODE = ?");
        pstUpdate.setString(1,"S");
        pstUpdate.setBigDecimal(2,smsCode);
        pstUpdate.executeUpdate();
      }
      catch(Exception ex) 
      {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
      }
      return null;
    }

    public void setSystemsLOV(RichTable systemsLOV) {
        this.systemsLOV = systemsLOV;
    }

    public RichTable getSystemsLOV() {
        return systemsLOV;
    }

    public void setSystemName(RichInputText systemName) {
        this.systemName = systemName;
    }

    public RichInputText getSystemName() {
        return systemName;
    }

    public void setEmailClientsLOV(RichTable emailClientsLOV) {
        this.emailClientsLOV = emailClientsLOV;
    }

    public RichTable getEmailClientsLOV() {
        return emailClientsLOV;
    }

    public void setEmailClient(RichInputText emailClient) {
        this.emailClient = emailClient;
    }

    public RichInputText getEmailClient() {
        return emailClient;
    }

    public void setAgentsEmailLOV(RichTable agentsEmailLOV) {
        this.agentsEmailLOV = agentsEmailLOV;
    }

    public RichTable getAgentsEmailLOV() {
        return agentsEmailLOV;
    }

    public void setAgentName1(RichInputText agentName1) {
        this.agentName1 = agentName1;
    }

    public RichInputText getAgentName1() {
        return agentName1;
    }

    public void setSmsQuotationLOV(RichTable smsQuotationLOV) {
        this.smsQuotationLOV = smsQuotationLOV;
    }

    public RichTable getSmsQuotationLOV() {
        return smsQuotationLOV;
    }

    public void setSmsQuotationNumber(RichInputText smsQuotationNumber) {
        this.smsQuotationNumber = smsQuotationNumber;
    }

    public RichInputText getSmsQuotationNumber() {
        return smsQuotationNumber;
    }

    public void setPoliciesLOV(RichTable policiesLOV) {
        this.policiesLOV = policiesLOV;
    }

    public RichTable getPoliciesLOV() {
        return policiesLOV;
    }

    public void setSystemPolicyNumber(RichInputText systemPolicyNumber) {
        this.systemPolicyNumber = systemPolicyNumber;
    }

    public RichInputText getSystemPolicyNumber() {
        return systemPolicyNumber;
    }

    public void setEmailClaimsLOV(RichTable emailClaimsLOV) {
        this.emailClaimsLOV = emailClaimsLOV;
    }

    public RichTable getEmailClaimsLOV() {
        return emailClaimsLOV;
    }

    public void setClaimNumber1(RichInputText claimNumber1) {
        this.claimNumber1 = claimNumber1;
    }

    public RichInputText getClaimNumber1() {
        return claimNumber1;
    }

    public void setSmsMessageStatus(RichInputText smsMessageStatus) {
        this.smsMessageStatus = smsMessageStatus;
    }

    public RichInputText getSmsMessageStatus() {
        return smsMessageStatus;
    }

    public void setSmsTelephoneNumber(RichInputText smsTelephoneNumber) {
        this.smsTelephoneNumber = smsTelephoneNumber;
    }

    public RichInputText getSmsTelephoneNumber() {
        return smsTelephoneNumber;
    }

    public void setSmsMessage(HtmlInputTextarea smsMessage) {
        this.smsMessage = smsMessage;
    }

    public HtmlInputTextarea getSmsMessage() {
        return smsMessage;
    }

    public void setMsgTemplate(RichTable msgTemplate) {
        this.msgTemplate = msgTemplate;
    }

    public RichTable getMsgTemplate() {
        return msgTemplate;
    }

    public void setMsgTemplateDesc(RichInputText msgTemplateDesc) {
        this.msgTemplateDesc = msgTemplateDesc;
    }

    public RichInputText getMsgTemplateDesc() {
        return msgTemplateDesc;
    }
}
