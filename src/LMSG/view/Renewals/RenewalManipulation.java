package LMSG.view.Renewals;

import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.faces.event.ValueChangeEvent;

import javax.servlet.http.HttpSession;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanCheckbox;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.layout.RichPanelBox;
import oracle.adf.view.rich.component.rich.output.RichOutputLabel;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.Key;
import oracle.jbo.Row;

import oracle.jdbc.OracleTypes;

import org.apache.myfaces.trinidad.model.RowKeySet;

import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

import LMSG.view.Base.ADFUtils;

import LMSG.view.Base.GlobalCC;

import LMSG.view.Navigation.Links;

import LMSG.view.connect.DBConnector;
import LMSG.view.BPM.workflowProcessing;

import oracle.jbo.uicli.binding.JUCtrlValueBinding;


public class RenewalManipulation {
    private RichInputText productDesc;
    private RichTable productLOV;
    private RichInputText proposerDesc;
    private RichTable proposerLOV;
    private RichInputDate dateFrom;
    private RichInputDate dateTo;
    private RichPanelBox resultsTab;
    private RichTable resultsLOV;
    private RichTable transLOV;
    private RichPanelBox transactions;
    private RichInputDate wetDate;
    private String Ren;
    private RichSelectOneChoice unitRateOption;
    private RichTable usersLOV;
    private RichTable resultsLOV2;
    private RichTable policiesLOV;
    private RichInputText policiesDesc;
    private RichInputDate coverFromDate;
    private RichOutputLabel durationType;
    private RichSelectBooleanCheckbox transferCbox;
    private RichSelectBooleanCheckbox umbrellaCbox;

    public RenewalManipulation() {
        super();
    }
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);

  public String findProductSelected() {
      DCIteratorBinding dciter =
          ADFUtils.findIterator("findRenewalProductsIterator");
      RowKeySet set = productLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();

      while (rowKeySetIter.hasNext()) {
          List l = (List)rowKeySetIter.next();
          Key key = (Key)l.get(0);
          dciter.setCurrentRowWithKey(key.toStringFormat(true));
          Row r = dciter.getCurrentRow();

          productDesc.setValue(r.getAttribute("prodDesc"));
          session.setAttribute("ProductCode", r.getAttribute("prodCode"));
          
          policiesDesc.setValue(null);
          session.setAttribute("policyCode", null); 
          proposerDesc.setValue(null);
          session.setAttribute("prpCode", null);
          session.setAttribute("ClientCode", null);
          ADFUtils.findIterator("findRenewalPoliciesIterator").executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(policiesLOV);


      }

      return null;
  }

  public String findProposerSelected() {
      DCIteratorBinding dciter =
          ADFUtils.findIterator("findProposers1Iterator");
      RowKeySet set = proposerLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();

      while (rowKeySetIter.hasNext()) {
          List l = (List)rowKeySetIter.next();
          Key key = (Key)l.get(0);
          dciter.setCurrentRowWithKey(key.toStringFormat(true));
          Row r = dciter.getCurrentRow();

          proposerDesc.setValue(r.getAttribute("CLIENT"));
          session.setAttribute("prpCode", r.getAttribute("PRP_CODE"));

          policiesDesc.setValue(null);
          ADFUtils.findIterator("findRenewalPoliciesIterator").executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(policiesLOV);


      }

      return null;
  }
  
  public String findPoliciesSelected() {
    DCIteratorBinding dciter = 
    ADFUtils.findIterator("findRenewalPoliciesIterator");
    RowKeySet set =policiesLOV.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();
    
    //System.out.println(1);
    while (rowKeySetIter.hasNext()) 
    {
        List l = (List) rowKeySetIter.next();
        Key key = (Key)l.get(0);
        dciter.setCurrentRowWithKey(key.toStringFormat(true));
        Row r = dciter.getCurrentRow();
        policiesDesc.setValue(r.getAttribute("RN_POL_POLICY_NO"));
        session.setAttribute("policyCode", r.getAttribute("RN_POL_CODE"));  
        session.setAttribute("policyNumber", r.getAttribute("RN_POL_POLICY_NO"));  
        session.setAttribute("prpCode", r.getAttribute("RN_POL_PRP_CODE"));  
      
    }

    return null;
  }

    public String ClearResults() {
        try {

            if (productDesc.getValue() == null) {
                String Message = "Select a product.";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));
                return null;

            }
            ADFUtils.findIterator("findRenewalProductsIterator").executeQuery();
            ADFUtils.findIterator("findProposers1Iterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(proposerLOV);
            AdfFacesContext.getCurrentInstance().addPartialTarget(productLOV);

            productDesc.setValue(null);
            session.setAttribute("ProductCode", null);
            proposerDesc.setValue(null);
            session.setAttribute("prpCode", null);
            session.setAttribute("ClientCode", null);
            resultsTab.setRendered(false);
            
            policiesDesc.setValue(null);
            session.setAttribute("policyCode",null);  


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }

    public String ShowResults() {
        try {
            
            String Umbrella = (String)session.getAttribute("umbrellaCover");
            if(Umbrella.equalsIgnoreCase("Y")){
                if(session.getAttribute("RenDateFrom")==null || session.getAttribute("RenDateTo")==null){
                  GlobalCC.errorValueNotEntered("Select a Date From and a Date To.");
                  return null;
                }
            }
            

           ADFUtils.findIterator("findRenewalPoliciesIterator").executeQuery();
           AdfFacesContext.getCurrentInstance().addPartialTarget(policiesLOV);
            
            ADFUtils.findIterator("findRenewalQueryIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(resultsLOV);
            
            resultsTab.setRendered(true);
            transactions.setRendered(false);


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }

  public String RenewPolicy(String DurationType, String RenewalDate) {
       Connection conn=null;
      try {
        

          conn = new DBConnector().getDatabaseConn();
          String deleteMember =
              "BEGIN LMS_WEB_PKG_GRP_UW.renew_policies_direct(?,?,?,?,?,?);END;";
          CallableStatement cstmt = conn.prepareCall(deleteMember);

              cstmt.setBigDecimal(1,(BigDecimal)session.getAttribute("policyCode"));
              cstmt.setString(2, DurationType);
              cstmt.setString(3, RenewalDate);
              cstmt.registerOutParameter(4,OracleTypes.DECIMAL);
              cstmt.registerOutParameter(5,OracleTypes.DECIMAL);
               if(DurationType.equalsIgnoreCase("C")){
               cstmt.setString(6, GlobalCC.parseDate(wetDate.getValue().toString()));
               }else{
              cstmt.setString(6, null);   
               }
             
              cstmt.execute();

         
          session.setAttribute("endorsementCode", cstmt.getBigDecimal(5));
          session.setAttribute("transactionNumber", cstmt.getBigDecimal(4)); 
          session.setAttribute("Authorised", "N");
          
          workflowProcessing wf = new workflowProcessing();
          String Rights = wf.CheckUserRights();
          Links L1 = new Links();
          L1.FindProcessDetails();
          if(Rights.equalsIgnoreCase("Y")){
              wf.CreateWorkflowInstance();    
              GlobalCC.RedirectPage("/g_undwrt.jspx");
                
          }else{
              String TaskAss = (String)session.getAttribute("TaskAssignee"); 
              if (TaskAss==null){
                      GetAssignee(); 
                      return null;
              }else{
                  wf.CreateWorkflowInstance(); 
                  String Message = "Current Task Complete. The Next Task " + (String)session.getAttribute("TaskActivityName") +  " has been Successfully assigned to " + (String)session.getAttribute("TaskAssignee");
                  FacesContext.getCurrentInstance().addMessage(null, 
                                                                   new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                                    Message, 
                                                                                    Message));
                  session.setAttribute("TaskID", null);
                  return null;
              }
          }   
          cstmt.close();
          conn.close();
                   
      } catch (Exception ex) {
           GlobalCC.EXCEPTIONREPORTING(conn,ex);
      }
      return null;
  }
    
  public String saveWETDate(){
      try{
          if(wetDate.getValue()==null){
              String Message = "Select A WET Date";
              FacesContext.getCurrentInstance().addMessage(null, 
                                                           new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                            Message, 
                                                                            Message));
              
              return null;
          }else{
              String RenewalDate = null;
              if(coverFromDate.getValue()==null){
                  GlobalCC.sysInformation("Enter A Cover From Date.");
              }else{
                  if(coverFromDate.getValue().toString().contains(":")){
                      RenewalDate =  GlobalCC.parseDate(coverFromDate.getValue().toString());
                  }else{
                      RenewalDate =  GlobalCC.upDateParseDate(coverFromDate.getValue().toString());
                  }
                  RenewPolicy("C", RenewalDate); 
              }
              
              
          }
          
      }catch(Exception e){
          GlobalCC.EXCEPTIONREPORTING(null,e);
      }
      return null;
  }
  
  public String RenewCoverDate(){
      try{
          DCIteratorBinding dciter =
              ADFUtils.findIterator("findRenewalQueryIterator");
          RowKeySet set = resultsLOV.getSelectedRowKeys();
          Iterator rowKeySetIter = set.iterator();

          while (rowKeySetIter.hasNext()) {
              List l = (List)rowKeySetIter.next();
              Key key = (Key)l.get(0);
              dciter.setCurrentRowWithKey(key.toStringFormat(true));
              Row r = dciter.getCurrentRow();
              
              session.setAttribute("policyCode", r.getAttribute("RN_POL_CODE"));
              session.setAttribute("policyNumber", r.getAttribute("RN_POL_POLICY_NO"));
              session.setAttribute("prpCode", r.getAttribute("RN_POL_PRP_CODE"));
              session.setAttribute("ClientCode", r.getAttribute("RN_PRP_CLNT_CODE"));
            

              durationType.setValue(r.getAttribute("ENDR_DURATION_TYPE"));
              coverFromDate.setValue(r.getAttribute("RN_ENDR_RENEWAL_DATE"));
              
              GlobalCC.showPopup("lmsgroup:coverPopup");
          }
      }catch(Exception e){
          GlobalCC.EXCEPTIONREPORTING(null, e);
      }
      return null;
  }
  
  public String RenewUmbrellaPolicy(){
       Connection conn=null;
  try{
          session.setAttribute("Endorsement", "RN");
          session.setAttribute("ProcessShtDesc", "UWRN");
          session.setAttribute("ProcessAreaShtDesc", "ACCS");
          session.setAttribute("ProcessSubAShtDesc", "ACCS");
          session.setAttribute("UWStart", "No");
          
          String Rights = null;
          workflowProcessing wf = new workflowProcessing();
          Rights = wf.CheckUserRights();
          
          Links L1 = new Links();
          L1.FindProcessDetails();
          session.setAttribute("TaskID", null);
          if (Rights.equalsIgnoreCase("Y")){  
              //Continue with process...
          }else{
              GlobalCC.INFORMATIONREPORTING("You do not have rights to access this Module");
              return null;
          }
      
          //confirm that there is someone to perform the next task before completing
          String NextUser = null;
          session.setAttribute("ProcessAreaShtDesc", "DENTR");
          session.setAttribute("ProcessSubAShtDesc", session.getAttribute("Endorsement") + "DAT");
          session.setAttribute("TaskAssignee", null);
          session.setAttribute("NextTaskAssignee", "N");
          ADFUtils.findIterator("findTicketAssigneeIterator").executeQuery(); 
          NextUser = (String)session.getAttribute("NextTaskAssignee");
          String TaskAss = (String)session.getAttribute("TaskAssignee"); 
      
          if (TaskAss == null && NextUser.equalsIgnoreCase("N")){
              GlobalCC.INFORMATIONREPORTING("There is no User to Assign the Next Task. Consult the Administrator.");
              return null;  
          }
          
          conn = new DBConnector().getDatabaseConn();
          int TotalTransactions = 0;
          String PendingTrans = "begin LMS_WEB_CURSOR_GRP.getPendingTransactions(?,?);end;";
          CallableStatement cst1 = conn.prepareCall(PendingTrans);
          cst1.setBigDecimal(1, (BigDecimal)session.getAttribute("policyCode"));
          System.out.println(session.getAttribute("policyCode"));
          cst1.registerOutParameter(2, OracleTypes.INTEGER);
          cst1.execute(); 
          TotalTransactions = cst1.getInt(2);
          if (TotalTransactions > 0){
            GlobalCC.INFORMATIONREPORTING("This Policy has Another Unfinished Transaction....");
            
            ADFUtils.findIterator("FindPendingTransactionsIterator").executeQuery();    
            AdfFacesContext.getCurrentInstance().addPartialTarget(transLOV);
            transactions.setRendered(true);
            conn.close();    
            return null;
            
          }
      
          conn = new DBConnector().getDatabaseConn();
          String deleteMember =
              "BEGIN LMS_WEB_PKG_GRP_UW.renew_umbrella_direct(?,?,?,?,?,?);END;";
          CallableStatement cstmt = conn.prepareCall(deleteMember);
  
          cstmt.setBigDecimal(1,(BigDecimal)session.getAttribute("policyCode"));
          cstmt.registerOutParameter(2,OracleTypes.DECIMAL);
          cstmt.registerOutParameter(3,OracleTypes.DECIMAL);
          cstmt.setString(4, null);   
          cstmt.setString(5, GlobalCC.parseDate((String)session.getAttribute("RenDateFrom")));   
          cstmt.setString(6, GlobalCC.parseDate((String)session.getAttribute("RenDateTo")));   
        
             
          cstmt.execute();
  
          
          session.setAttribute("endorsementCode", cstmt.getBigDecimal(3));
          session.setAttribute("transactionNumber", cstmt.getBigDecimal(2)); 
          session.setAttribute("Authorised", "N");
          cstmt.close();
          
          String Rights1 = wf.CheckUserRights();
          L1.FindProcessDetails();
          if(Rights1.equalsIgnoreCase("Y")){
              wf.CreateWorkflowInstance();    
              GlobalCC.RedirectPage("/g_undwrt.jspx");
                
          }else{
              String TaskAss1 = (String)session.getAttribute("TaskAssignee"); 
              if (TaskAss1==null){
                      GetAssignee(); 
                      return null;
              }else{
                  wf.CreateWorkflowInstance(); 
                  GlobalCC.INFORMATIONREPORTING("Current Task Complete. The Next Task " + (String)session.getAttribute("TaskActivityName") +  " has been Successfully assigned to " + (String)session.getAttribute("TaskAssignee"));
                  session.setAttribute("TaskID", null);
                  return null;
              }
          }      
          conn.close();
      
      }catch (Exception e) {
        GlobalCC.EXCEPTIONREPORTING(conn, e);
      }
       return null;
  }
    
  public String GetPendingTransAndRenew(){
       Connection conn=null;
  try{
          session.setAttribute("Endorsement", "RN");
          session.setAttribute("ProcessShtDesc", "UWRN");
          session.setAttribute("ProcessAreaShtDesc", "ACCS");
          session.setAttribute("ProcessSubAShtDesc", "ACCS");
          session.setAttribute("UWStart", "No");
          
          String Rights = null;
          workflowProcessing wf = new workflowProcessing();
          Rights = wf.CheckUserRights();
          
          Links L1 = new Links();
          L1.FindProcessDetails();
          session.setAttribute("TaskID", null);
          if (Rights.equalsIgnoreCase("Y")){  
              //Continue with process...
          }else{
              String Message = "You do not have rights to access this Module";
              FacesContext.getCurrentInstance().addMessage(null, 
                                                           new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                            Message, 
                                                                            Message));
              return null;
          }
      
          //confirm that there is someone to perform the next task before completing
          String NextUser = null;
          session.setAttribute("ProcessAreaShtDesc", "DENTR");
          session.setAttribute("ProcessSubAShtDesc", session.getAttribute("Endorsement") + "DAT");
          session.setAttribute("TaskAssignee", null);
          session.setAttribute("NextTaskAssignee", "N");
          ADFUtils.findIterator("findTicketAssigneeIterator").executeQuery(); 
          NextUser = (String)session.getAttribute("NextTaskAssignee");
          String TaskAss = (String)session.getAttribute("TaskAssignee"); 
          if (TaskAss == null && NextUser.equalsIgnoreCase("N")){
              String Message = "There is no User to Assign the Next Task. Consult the Administrator.";
              FacesContext.getCurrentInstance().addMessage(null, 
                                                           new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                            Message, 
                                                                            Message));
              return null;
                  
          }
          
      
      String DurationType = null;
      String RenewalDate = null;
          /*DCIteratorBinding dciter =
              ADFUtils.findIterator("findRenewalQueryIterator");
          RowKeySet set = resultsLOV.getSelectedRowKeys();
          Iterator rowKeySetIter = set.iterator();

          while (rowKeySetIter.hasNext()) {
              List l = (List)rowKeySetIter.next();
              Key key = (Key)l.get(0);
              dciter.setCurrentRowWithKey(key.toStringFormat(true));
              Row r = dciter.getCurrentRow();
              
              session.setAttribute("policyCode", r.getAttribute("RN_POL_CODE"));
              DurationType = (String)r.getAttribute("ENDR_DURATION_TYPE");
              RenewalDate = (Date)r.getAttribute("RN_ENDR_RENEWAL_DATE");

          }*/
          if(coverFromDate.getValue()==null){
              GlobalCC.sysInformation("Enter A Cover From Date.");
          }else{
              if(coverFromDate.getValue().toString().contains(":")){
                  RenewalDate =  GlobalCC.parseDate(coverFromDate.getValue().toString());
              }else{
                  RenewalDate =  GlobalCC.upDateParseDate(coverFromDate.getValue().toString());
              }
          }
      
          if(durationType.getValue()==null){
              GlobalCC.sysInformation("The Policy Does not Have a Duration Type Specified.");
          }else{
              DurationType = durationType.getValue().toString();
          }
                                          
      
      conn = new DBConnector().getDatabaseConn();
      int TotalTransactions = 0;
      String PendingTrans = "begin LMS_WEB_CURSOR_GRP.getPendingTransactions(?,?);end;";
      CallableStatement cst1 = conn.prepareCall(PendingTrans);
      cst1.setBigDecimal(1, (BigDecimal)session.getAttribute("policyCode"));
      System.out.println(session.getAttribute("policyCode"));
      cst1.registerOutParameter(2, OracleTypes.INTEGER);
      cst1.execute(); 
      TotalTransactions = cst1.getInt(2);
      if (TotalTransactions > 0){
        GlobalCC.INFORMATIONREPORTING("This Policy has Another Unfinished Transaction....");
        
        ADFUtils.findIterator("FindPendingTransactionsIterator").executeQuery();    
        AdfFacesContext.getCurrentInstance().addPartialTarget(transLOV);
        transactions.setRendered(true);
        cst1.close();
        conn.close();    
        return null;
        
      }else{
          cst1.close();
          conn.close();   
          DetermineDuration(DurationType, RenewalDate);
      }
      }catch (Exception e) {
        GlobalCC.EXCEPTIONREPORTING(conn, e);
      }
       return null;
  }
  
  public String DetermineDuration(String DurationType, String RenewalDate){
      try{
          if(DurationType == null){
              GlobalCC.INFORMATIONREPORTING("The Policy Does not have a Duration Date...");
              return null;
              
          }else if(DurationType.equalsIgnoreCase("C")){
              //render Popup
        
             Ren = RenewalDate;
             GlobalCC.showPopup("lmsgroup:duraPopup");
          }else{
              //continue...
              RenewPolicy(DurationType, RenewalDate); 
          }
          
      }catch(Exception e){
          GlobalCC.EXCEPTIONREPORTING(null,e);
      }
      return null;
  }
         
    public String DeletePendingEndorsementSelected() {
      BigDecimal EndorsementCode = null;
      BigDecimal TransCode = null;
      
      DCIteratorBinding dciter = ADFUtils.findIterator("FindPendingTransactionsIterator");
      RowKeySet set =transLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      
      //System.out.println(1);
      while (rowKeySetIter.hasNext()) 
      {
          List l = (List) rowKeySetIter.next();
          Key key = (Key)l.get(0);
          dciter.setCurrentRowWithKey(key.toStringFormat(true));
          Row r = dciter.getCurrentRow();
          EndorsementCode = (BigDecimal)r.getAttribute("PT_ENDR_CODE");
          TransCode = (BigDecimal)r.getAttribute("PT_ENDR_LTR_TRANS_NO");
           Connection conn=null;
        try{
          
           DBConnector myConn=new DBConnector();
         conn=myConn.getDatabaseConn();

          String PendingTrans = "begin LMS_GRP_TRANSACTIONS.DEL_GRP_POL_DTLS_PROC(?,?,?);end;";
          CallableStatement cst1 = conn.prepareCall(PendingTrans);
          cst1.setBigDecimal(1, (BigDecimal)session.getAttribute("policyCode"));
          cst1.setBigDecimal(2, EndorsementCode);
          cst1.setBigDecimal(3, TransCode);
          cst1.execute(); 
            
          /*String UpateTrans = "begin TQC_WEB_PKG.inactivate_tickets(?);end;";
          CallableStatement cst2 = conn.prepareCall(UpateTrans);
          cst2.setBigDecimal(1, EndorsementCode);
          cst1.execute(); */
            
          String Message = "Transaction Deleted";
          FacesContext.getCurrentInstance().addMessage(null, 
                                                       new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                        Message, 
                                                                        Message));
          
            transactions.setRendered(false);
            conn.close();        
        }      
      catch(Exception e) {
        GlobalCC.EXCEPTIONREPORTING(conn, e);
      }
       
      }

      return null;
    }
    
    public String findPendingEndorsementSelected() {
      DCIteratorBinding dciter = ADFUtils.findIterator("FindPendingTransactionsIterator");
      RowKeySet set =transLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      
      //System.out.println(1);
      while (rowKeySetIter.hasNext()) 
      {
          List l = (List) rowKeySetIter.next();
          Key key = (Key)l.get(0);
          dciter.setCurrentRowWithKey(key.toStringFormat(true));
          Row r = dciter.getCurrentRow();
          session.setAttribute("endorsementCode", r.getAttribute("PT_ENDR_CODE"));
        
          session.setAttribute("transactionNumber", r.getAttribute("PT_ENDR_LTR_TRANS_NO"));
          
        
        try{
          session.setAttribute("Authorised", "N");
          session.setAttribute("editComponents", "N");
          GlobalCC.RedirectPage("/g_undwrt.jspx");   
        }      
      catch(Exception e) {
        GlobalCC.EXCEPTIONREPORTING(null, e);
      }
       
      }

      return null;
    }
    
    public String GetAssignee(){
        try{
            // Render Popup
             System.out.println("enter popup");
            ExtendedRenderKitService erkService =
            Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
            ExtendedRenderKitService.class);
            erkService.addScript(FacesContext.getCurrentInstance(),
            "var hints = {autodismissNever:false}; " +
            "AdfPage.PAGE.findComponent('" + "lmsgroup:users" +
            "').show(hints);");
            
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }
    
      public String AssignTask() {
          
      try{
        DCIteratorBinding dciter = ADFUtils.findIterator("findTicketAssigneeIterator");
        RowKeySet set =usersLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        
        //System.out.println(1);
        while (rowKeySetIter.hasNext()) 
        {
            List l = (List) rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
           //clientsDisplay.setValue(r.getAttribute("CLIENT"));
            
           //LOVCC.TaskAssigneeID=(BigDecimal)r.getAttribute("taskUserID");
           //LOVCC.TaskAssignee = (String)r.getAttribute("taskUserShtDesc");
            session.setAttribute("TaskAssigneeID", r.getAttribute("taskUserID"));
            session.setAttribute("TaskAssignee", r.getAttribute("taskUserShtDesc"));
            
          
        }
          workflowProcessing wf  = new workflowProcessing();
          wf.CreateWorkflowInstance(); 
          String Message = "Current Task Complete. The Next Task " + (String)session.getAttribute("TaskActivityName") +  " has been Successfully assigned to " + (String)session.getAttribute("TaskAssignee");
          FacesContext.getCurrentInstance().addMessage(null, 
                                                           new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                            Message, 
                                                                            Message));

          session.setAttribute("TaskID", null);
        
          
          //GlobalCC.RedirectPage("/g_quotone.jspx");
          System.out.println("Success");
          
      }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
          }
        
        return null;
      }
      
    public String findTicket2Selected(){
        try{
            
            DCIteratorBinding dciter = ADFUtils.findIterator("findTicketDetailsByUserIterator");
            RowKeySet set =resultsLOV2.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();
                   
                   while (rowKeySetIter.hasNext()) {
                   List l = (List) rowKeySetIter.next();
                   Key key = (Key)l.get(0);
                   dciter.setCurrentRowWithKey(key.toStringFormat(true));
                     
                       
                   Row r = dciter.getCurrentRow();
                       
                          //LOVCC.TaskID = (String)r.getAttribute("TCKT_CDE");
                          session.setAttribute("TaskID", r.getAttribute("TCKT_CDE"));
                          //taskselName= (String)r.getAttribute("TCKT_NAME");  
                          session.setAttribute("taskselName", r.getAttribute("TCKT_NAME"));
                          session.setAttribute("TaskActivityName", r.getAttribute("TCKT_NAME"));
                          //taskselAssignee= (String)r.getAttribute("TCKT_TO");
                         session.setAttribute("taskselAssignee", r.getAttribute("TCKT_TO"));
                          //taskselDueDate=(Date)r.getAttribute("TCKT_DUE_DATE");
                         session.setAttribute("taskselDueDate", r.getAttribute("TCKT_DUE_DATE"));
                          //taskselID=(String)r.getAttribute("TCKT_CDE");
                          session.setAttribute("taskselID", r.getAttribute("TCKT_CDE"));
                          //taskselCreateDate=(Date)r.getAttribute("TCKT_DATE");
                         session.setAttribute("taskselCreateDate", r.getAttribute("TCKT_DATE"));
                       
                GlobalCC.RedirectPage("/wfProcessing.jspx");
            
            }
            
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
       return null;
    }
    
    public String ShowPolicyTickets(){
        try{

            ADFUtils.findIterator("findTicketDetailsByUserIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(resultsLOV);
            
            // Render Popup
             System.out.println("enter popup");
            ExtendedRenderKitService erkService =
            Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
            ExtendedRenderKitService.class);
            erkService.addScript(FacesContext.getCurrentInstance(),
            "var hints = {autodismissNever:false}; " +
            "AdfPage.PAGE.findComponent('" + "lmsgroup:p1" +
            "').show(hints);");
            
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }

    public void setProductDesc(RichInputText productDesc) {
        this.productDesc = productDesc;
    }

    public String CancelEndorsement(){
        transactions.setRendered(false);
        return null;
    }
    public RichInputText getProductDesc() {
        return productDesc;
    }

    public void setProductLOV(RichTable productLOV) {
        this.productLOV = productLOV;
    }

    public RichTable getProductLOV() {
        return productLOV;
    }

    public void setProposerDesc(RichInputText proposerDesc) {
        this.proposerDesc = proposerDesc;
    }

    public RichInputText getProposerDesc() {
        return proposerDesc;
    }

    public void setProposerLOV(RichTable proposerLOV) {
        this.proposerLOV = proposerLOV;
    }

    public RichTable getProposerLOV() {
        return proposerLOV;
    }

    public void dateToListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if (dateTo.getValue() == null) {
            session.setAttribute("RenDateTo", null);
        } else {
            session.setAttribute("RenDateTo", dateTo.getValue().toString());
        }
    }

    public void dateFromListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if (dateFrom.getValue() == null) {
            session.setAttribute("RenDateFrom", null);
        } else {
            session.setAttribute("RenDateFrom",
                                 dateFrom.getValue().toString());
        }
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

    public void setResultsTab(RichPanelBox resultsTab) {
        this.resultsTab = resultsTab;
    }

    public RichPanelBox getResultsTab() {
        return resultsTab;
    }

    public void setResultsLOV(RichTable resultsLOV) {
        this.resultsLOV = resultsLOV;
    }

    public RichTable getResultsLOV() {
        return resultsLOV;
    }

    public void setTransLOV(RichTable transLOV) {
        this.transLOV = transLOV;
    }

    public RichTable getTransLOV() {
        return transLOV;
    }

    public void setTransactions(RichPanelBox transactions) {
        this.transactions = transactions;
    }

    public RichPanelBox getTransactions() {
        return transactions;
    }

    public void setWetDate(RichInputDate wetDate) {
        this.wetDate = wetDate;
    }

    public RichInputDate getWetDate() {
        return wetDate;
    }

    public void setUnitRateOption(RichSelectOneChoice unitRateOption) {
        this.unitRateOption = unitRateOption;
    }

    public RichSelectOneChoice getUnitRateOption() {
        return unitRateOption;
    }

    public void setUsersLOV(RichTable usersLOV) {
        this.usersLOV = usersLOV;
    }

    public RichTable getUsersLOV() {
        return usersLOV;
    }

    public void setResultsLOV2(RichTable resultsLOV2) {
        this.resultsLOV2 = resultsLOV2;
    }

    public RichTable getResultsLOV2() {
        return resultsLOV2;
    }

    public void setPoliciesLOV(RichTable policiesLOV) {
        this.policiesLOV = policiesLOV;
    }

    public RichTable getPoliciesLOV() {
        return policiesLOV;
    }

    public void setPoliciesDesc(RichInputText policiesDesc) {
        this.policiesDesc = policiesDesc;
    }

    public RichInputText getPoliciesDesc() {
        return policiesDesc;
    }

    public void setCoverFromDate(RichInputDate coverFromDate) {
        this.coverFromDate = coverFromDate;
    }

    public RichInputDate getCoverFromDate() {
        return coverFromDate;
    }

    public void setDurationType(RichOutputLabel durationType) {
        this.durationType = durationType;
    }

    public RichOutputLabel getDurationType() {
        return durationType;
    }

    public void TransferRenewalListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if(valueChangeEvent.getOldValue()!=valueChangeEvent.getNewValue()){
            
          RowKeySet rowKeySet = resultsLOV.getSelectedRowKeys();
          if (rowKeySet == null) {
              return;
          }
          if (!rowKeySet.iterator().hasNext()) //no selection
          {
                  GlobalCC.errorValueNotEntered("No Record Selected");
              return;
          }
          Object key2 = rowKeySet.iterator().next();
          resultsLOV.setRowKey(key2);
          JUCtrlValueBinding nodeBinding =
              (JUCtrlValueBinding)resultsLOV.getRowData();
          if (nodeBinding == null) {
                  GlobalCC.errorValueNotEntered("No Record Selected");
              return;
          }
          
          if(transferCbox.isSelected()){
            nodeBinding.setAttribute("selected", true);
          }else{
            nodeBinding.setAttribute("selected", false);
          }
        }
    }
    
    public String TransferSelectedPolicies(){
      Connection conn = null;
      try{
         boolean MakeCall = false;
        DBConnector db = new DBConnector();
        conn = db.getDatabaseConn(); 
        
        CallableStatement cst = null;
        //List ReinstInfo = new LinkedList();
        //ARRAY array = null; 
        
        //ArrayDescriptor descriptor =
         //   ArrayDescriptor.createDescriptor("LMS_PENSION_MATURITY_PYMT_TAB", conn);
        
        cst = conn.prepareCall("BEGIN LMS_WEB_PKG_GRP_UW.transfer_to_ren_work_area(?,?,?,?);end;");
         
          
        int rowCount = 0;
        boolean Value = false;
        rowCount = resultsLOV.getRowCount();
        if (rowCount == 0){
            return null;
        }
          
        for (int i = 0; i < rowCount; i++) {
          resultsLOV.setRowIndex(i);
          JUCtrlValueBinding nodeBinding =
              (JUCtrlValueBinding)resultsLOV.getRowData();
          if (nodeBinding == null) {
              //do nothing...
          }else{
            Value = (Boolean)nodeBinding.getAttribute("selected");
              if (Value==true){
                MakeCall = true;
                
                coverFromDate.setValue(nodeBinding.getAttribute("RN_ENDR_RENEWAL_DATE"));
                
                cst.setBigDecimal(1, (BigDecimal)nodeBinding.getAttribute("RN_POL_CODE"));
                cst.setString(2, GlobalCC.upDateParseDate(coverFromDate.getValue().toString()));
                cst.setString(3, (String)nodeBinding.getAttribute("RN_POL_POLICY_NO"));
                cst.registerOutParameter(4, OracleTypes.DECIMAL);
                cst.execute();
              }
          }
        }
        cst.close();
        conn.close();
          
        AdfFacesContext.getCurrentInstance().addPartialTarget(resultsTab);  
        ADFUtils.findIterator("findRenewalQueryIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(resultsLOV);
        
        
        GlobalCC.INFORMATIONREPORTING("Policies Successfully Transferred.");
       
      }catch(Exception e){
        ADFUtils.findIterator("findRenewalQueryIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(resultsLOV);
          GlobalCC.EXCEPTIONREPORTING(conn, e);
      }
        return null;
    }
    
    public String ViewTransferredPolicy(){
        try{
            
          RowKeySet rowKeySet = resultsLOV.getSelectedRowKeys();
          if (rowKeySet == null) {
              return null;
          }
          if (!rowKeySet.iterator().hasNext()) //no selection
          {
                  GlobalCC.errorValueNotEntered("No Record Selected");
              return null;
          }
          Object key2 = rowKeySet.iterator().next();
          resultsLOV.setRowKey(key2);
          JUCtrlValueBinding nodeBinding =
              (JUCtrlValueBinding)resultsLOV.getRowData();
          if (nodeBinding == null) {
                  GlobalCC.errorValueNotEntered("No Record Selected");
              return null;
          }   
          
          session.setAttribute("policyCode", nodeBinding.getAttribute("RN_POL_CODE"));
          session.setAttribute("endorsementCode", nodeBinding.getAttribute("RN_ENDR_CODE"));
          //session.setAttribute("transactionNumber", nodeBinding.getAttribute("RN_POL_CODE")); 
          session.setAttribute("Authorised", "N");
          GlobalCC.RedirectPage("/g_undwrt.jspx");   
        }catch(Exception e){
          GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public void setTransferCbox(RichSelectBooleanCheckbox transferCbox) {
        this.transferCbox = transferCbox;
    }

    public RichSelectBooleanCheckbox getTransferCbox() {
        return transferCbox;
    }

    public void setUmbrellaCbox(RichSelectBooleanCheckbox umbrellaCbox) {
        this.umbrellaCbox = umbrellaCbox;
    }

    public RichSelectBooleanCheckbox getUmbrellaCbox() {
        return umbrellaCbox;
    }

    public void umbrellaPolicyListner(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if(valueChangeEvent.getOldValue()!=valueChangeEvent.getNewValue()){
          if(umbrellaCbox.isSelected()){
            session.setAttribute("umbrellaCover", "Y");
          }else{
            session.setAttribute("umbrellaCover", "N");
          }
         
          policiesDesc.setValue(null);
          session.setAttribute("policyCode", null); 
          
          ADFUtils.findIterator("findRenewalPoliciesIterator").executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(policiesLOV);
          
        }
    }
}
