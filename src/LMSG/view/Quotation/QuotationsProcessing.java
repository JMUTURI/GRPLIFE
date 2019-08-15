package LMSG.view.Quotation;

import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanCheckbox;
import oracle.adf.view.rich.component.rich.layout.RichPanelBox;
import oracle.adf.view.rich.component.rich.layout.RichShowDetailItem;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.Key;
import oracle.jbo.Row;

import oracle.jdbc.internal.OracleTypes;

import org.apache.myfaces.trinidad.model.RowKeySet;

import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

import LMSG.view.Base.ADFUtils;

import LMSG.view.Base.GlobalCC;
import LMSG.view.Base.LOVCC;

import LMSG.view.connect.DBConnector;

import LMSG.view.BPM.workflowProcessing;

import LMSG.view.TableTypes.ConvertCategories;

import java.util.LinkedList;

import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;

import oracle.jbo.uicli.binding.JUCtrlValueBinding;

import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;

public class QuotationsProcessing extends LOVCC {
    private RichTable conProductsLOV;
    private RichInputText conProductDisplay;
    private RichInputText conQuotationNoDispl;
    private RichTable quotationsTable;
    private RichPanelBox searchResults;
    private RichInputText policyNumberDisplay;
    private RichPanelBox searchQuote;
    private RichCommandButton genButton;
    private RichCommandButton searchButton;
    private RichTable usersLOV;
    
    protected static boolean Position = false;
    
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    private RichTable resultsLOV;
    private RichPanelBox myTicketsTab;
    private RichSelectBooleanCheckbox effectiveCbox;
    private RichInputDate currEffectiveDate;
    private RichInputDate newEffectiveDate;
    private RichTable categoriesTable;
    private RichSelectBooleanCheckbox catConvCbox;
    private RichShowDetailItem categoriesTab;
    private RichInputDate polSignDate;

    public QuotationsProcessing() {
        super();
    }
    
    public String AssignQuotationProducts() {
      DCIteratorBinding dciter = ADFUtils.findIterator("findProductsIterator");
      RowKeySet set =conProductsLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      
      //System.out.println(1);
      while (rowKeySetIter.hasNext()) 
      {
          List l = (List) rowKeySetIter.next();
          Key key = (Key)l.get(0);
          dciter.setCurrentRowWithKey(key.toStringFormat(true));
          Row r = dciter.getCurrentRow();
    
          session.setAttribute("ProductCode", r.getAttribute("prodCode"));
          session.setAttribute("productType", r.getAttribute("prodType"));
          conProductDisplay.setValue(r.getAttribute("prodshtDesc"));
          conQuotationNoDispl.setValue(null);
          session.setAttribute("QuoteCode", null);


        ADFUtils.findIterator("findQuotationIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(quotationsTable);
        
      }
      return null;
    }
    
    public String findQuotNumber() {
      DCIteratorBinding dciter = ADFUtils.findIterator("findQuotationIterator");
      RowKeySet set;
      set = quotationsTable.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
             
             while (rowKeySetIter.hasNext()) {
             List l = (List) rowKeySetIter.next();
             Key key = (Key)l.get(0);
             dciter.setCurrentRowWithKey(key.toStringFormat(true));
               
                 
             Row r = dciter.getCurrentRow();

            session.setAttribute("QuoteCode", r.getAttribute("quoCode"));
            session.setAttribute("QuotationNo", r.getAttribute("quoNo"));
            session.setAttribute("prpCode",  r.getAttribute("PROP_CODE"));
            session.setAttribute("umbrellaCover", r.getAttribute("QUO_UMBRELLA"));
            conQuotationNoDispl.setValue(session.getAttribute("QuotationNo"));

            ADFUtils.findIterator("findQuotationIterator").executeQuery();

    }
             return null;
    }
    
    public String SearchResults(){
        
        if (conProductDisplay.getValue()==null){
          GlobalCC.INFORMATIONREPORTING("Select a Product");
          return null;
          
        }
        if (conQuotationNoDispl.getValue()==null){
          GlobalCC.INFORMATIONREPORTING("Select a Quotation");
          return null;
          
        }
          //LOVCC.policyNumber=null;
          //LOVCC.PolicyNumberSel = null;
        session.setAttribute("policyNumber", null);
        session.setAttribute("PolicyNumberSel", null);

        ADFUtils.findIterator("findTicketDetailsByUserIterator").executeQuery();   
          String MyTasks = (String)session.getAttribute("ModuleTickets");
          if(MyTasks.equalsIgnoreCase("Y")){
              myTicketsTab.setRendered(true);
              searchResults.setRendered(false); 
              searchButton.setDisabled(false);
            AdfFacesContext.getCurrentInstance().addPartialTarget(resultsLOV);     
          }else{
              myTicketsTab.setRendered(false);
              searchResults.setRendered(true); 
              searchButton.setDisabled(true);
              AdfFacesContext.getCurrentInstance().addPartialTarget(searchButton);
              
              session.setAttribute("booleanSelect", "T");
              ADFUtils.findIterator("findQuoteCategoriesIterator").executeQuery();
              AdfFacesContext.getCurrentInstance().addPartialTarget(categoriesTable);
            
          }
          
          
        //ADFUtils.findIterator("FindOkQuotationsIterator").executeQuery(); 
        return null;
      }
    
    public String findTicket2Selected(){
        try{
            
            DCIteratorBinding dciter = ADFUtils.findIterator("findTicketDetailsByUserIterator");
            RowKeySet set =resultsLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();
                   
                   while (rowKeySetIter.hasNext()) {
                   List l = (List) rowKeySetIter.next();
                   Key key = (Key)l.get(0);
                   dciter.setCurrentRowWithKey(key.toStringFormat(true));
                     
                       
                   Row r = dciter.getCurrentRow();
                       
                          //LOVCC.TaskID = (String)r.getAttribute("TCKT_CDE");
                          session.setAttribute("TaskID", r.getAttribute("TCKT_CDE"));
                          //taskselName= (String)r.getAttribute("TCKT_NAME");   
                          //taskselAssignee= (String)r.getAttribute("TCKT_TO");   
                          //taskselDueDate=(Date)r.getAttribute("TCKT_DUE_DATE");
                          //taskselID=(String)r.getAttribute("TCKT_CDE");
                          //taskselCreateDate=(Date)r.getAttribute("TCKT_DATE");
                          
                          //taskselName= (String)r.getAttribute("TCKT_NAME");  
                          session.setAttribute("taskselName", r.getAttribute("TCKT_NAME"));
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
    
  public String RollBackTicketTransaction(){
      /*
       * This is to RollBack Created Tickets When the Procedure Fails
       */
      DBConnector MyDB = new DBConnector();
      try{
          Connection conn = MyDB.getDatabaseConn();
          if(conn==null){
              GlobalCC.sysInformation("Unable to connect to database");
              return null;
          }
          CallableStatement cst = conn.prepareCall("begin TQC_WEB_PKG.remove_tickets(?);end;");
          cst.setString(1, (String)session.getAttribute("TaskID"));
          cst.execute();
          cst.close();
          conn.close();
          session.setAttribute("TaskID", null);
          session.setAttribute("workflowID", null);       
          
      }catch(Exception e){
          GlobalCC.EXCEPTIONREPORTING(null, e);
      }
      return null;
  }
  public String ConvertQuotationProcessFlow(){
      String Result = "F";
      try{
          /*
           * Begin BPM Transaction. This will depend on new parameter if enabled
           * Also certain validations should be done to eliminate common errors, such as datasource...
           */
          String Value = null;

          workflowProcessing ProcessFlow = new workflowProcessing();
          Value = ProcessFlow.CheckBPMParameter("QUOTATIONS_BPM");
          //If Y, Use Process Flow...
          if(Value.equalsIgnoreCase("Y")){
                      
             ProcessFlow.FindProcessDetails();
              
              if(session.getAttribute("ProcessBPMDef")==null){
                  GlobalCC.sysInformation("Theres is no Process Flow Defined for this Module. Cannot Proceed");
                  return Result;
              }
              
              //Confirm User has the rights.
              String Rights = null;
              Rights = ProcessFlow.CheckUserRights();
              if (Rights.equalsIgnoreCase("Y")) {
                  //Continue...
              }else{
                  //Assign the Task to Another User with Rights. Determines if there Any Users who can be Assigned.
                  //ADFUtils.findIterator("findTicketAssigneeIterator").executeQuery(); 
                  //String TaskAss = (String)session.getAttribute("TaskAssignee");
                  //if (TaskAss==null){
                      //Allow the User to Select A User to Assign the Task. i.e Render Popup. 
                      //GetAssignee(); 
                      GlobalCC.sysInformation("you do not have the rights to perform this Transaction.");
                      return Result;
                  //}else{
                  
                  //System Defaults a User to Perform the Task...
                  /*ProcessFlow.CreateWorkflowInstance();
                  if(session.getAttribute("workflowID")==null){
                      GlobalCC.sysInformation("There was a Problem Encountered when initializing the Process Flow" +
                              "Engine. Please Contact your Administrator.");
                      
                      return Result;
                  }else{
                  session.setAttribute("TaskID", null);
                  GlobalCC.sysInformation("The Task " + (String)session.getAttribute("TaskActivityName") +  " has been Successfully assigned to " + (String)session.getAttribute("TaskAssignee"));
                  Result = "R";
                  return Result;
                  }*/
                  }
              //Start BPM Process..
              session.setAttribute("TaskID", null);
              session.setAttribute("workflowID", null);
              
              ProcessFlow.CreateWorkflowInstance();
              if(session.getAttribute("workflowID")==null){
                  GlobalCC.sysInformation("There was a Problem Encountered when initializing the Process Flow" +
                      "Engine. Please Contact your Administrator.");
                  return Result;
              }
              Result = "S";
          
          }else{
             GlobalCC.sysInformation("Process Flow Functionality has been disabled. Please Contact Your Administrator");
              Result = "F";
              return Result;
          }
      }catch(Exception e){
          GlobalCC.EXCEPTIONREPORTING(null, e);
      }
      return Result;
  }
    
  public String GeneratePolicyNumber() {
   
    String genPolNumberQuery="BEGIN LMS_WEB_PKG_GRP.confirm_policy(?,?,?,?,?,?);END;";
    
    String EffectiveDateQuery="BEGIN LMS_WEB_PKG_GRP_UW.chnage_quot_effective_date(?,?,?);END;";
    Connection conn=new DBConnector().getDatabaseConn();
    try 
    {
        //Confirm you have the rights to perform this task.
        String Rights = null;
        workflowProcessing wf = new workflowProcessing();
        Rights = wf.CheckUserRights();
        
        /*if (Rights.equalsIgnoreCase("N")){
            //workflowProcessing bpm  = new workflowProcessing();
            //bpm.CreateWorkflowInstance(); 
            String Message = "You do not have rights to Perform this Task.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            //LOVCC.TaskID = null;
            return null;
        }*/
        
        //confirm that there is someone to perform the next task before completing 
        String NextUser = null;
        //LOVCC.ProcessShtDesc = "UWNB";
        //LOVCC.ProcessAreaShtDesc = "ACCS";
        //LOVCC.ProcessSubAShtDesc = "ACCS";
        //LOVCC.TaskAssignee = null;
        session.setAttribute("ProcessShtDesc", "UWNB");
        session.setAttribute("ProcessAreaShtDesc", "ACCS");
        session.setAttribute("ProcessSubAShtDesc", "ACCS");
        session.setAttribute("TaskAssignee", null);
        
        session.setAttribute("NextTaskAssignee", "N");
        ADFUtils.findIterator("findTicketAssigneeIterator").executeQuery(); 
        NextUser = (String)session.getAttribute("NextTaskAssignee");
        String TaskAss = (String)session.getAttribute("NextTaskAssignee");
        if (TaskAss == null && NextUser.equalsIgnoreCase("N")){
            String Message = "There is no User to Assign the Next Task. Consult the Administrator.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            return null;
                
        } 
        
        //Confirm that there is no other task.
        String Taske = (String)session.getAttribute("TaskID");
        if(Taske!=null){
            String Message = "A Task has been selected. Unselect it and try again.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            return null;
            
        }
      
        session.setAttribute("ClientExists", "Yes");
        
        session.setAttribute("TaskAssignee", session.getAttribute("Username"));
        String Result = ConvertQuotationProcessFlow();
         if(Result==null){
                return null;
         }else if(Result.equalsIgnoreCase("F")){
                return null;
         }else{
                //Continue...
         }
      
       //Check to see if Cover From Date has been changed first...
        if(effectiveCbox.isSelected()){
            if(newEffectiveDate.getValue()==null){
                GlobalCC.sysInformation("Enter A New Effective Date.");
                return null;
            }else{
                CallableStatement cstmt1=conn.prepareCall(EffectiveDateQuery);
                
                cstmt1.setBigDecimal(1, (BigDecimal)session.getAttribute("QuoteCode"));
                if(newEffectiveDate.getValue().toString().contains(":")){
                    cstmt1.setString(2, GlobalCC.parseDate(newEffectiveDate.getValue().toString()));  
                }else{
                    cstmt1.setString(2, GlobalCC.upDateParseDate(newEffectiveDate.getValue().toString()));  
                }
                cstmt1.setString(3, null);
                cstmt1.execute();
                cstmt1.close();
            }
        }
        
      //create the New Policy Record...  
      CallableStatement cstmt=conn.prepareCall(genPolNumberQuery);
      cstmt.setString(1,null);
      cstmt.setBigDecimal(2,(BigDecimal)session.getAttribute("ProductCode"));
      cstmt.setBigDecimal(3,(BigDecimal)session.getAttribute("QuoteCode"));
      cstmt.registerOutParameter(4,OracleTypes.DECIMAL);
      cstmt.setBigDecimal(5,new BigDecimal(001));
      cstmt.registerOutParameter(6,OracleTypes.VARCHAR);
      cstmt.execute();
         
        policyNumberDisplay.setValue(cstmt.getString(6));
        session.setAttribute("policyNumber", cstmt.getString(6));
        session.setAttribute("PolicyNumberSel", cstmt.getString(6));
        session.setAttribute("policyCode", cstmt.getBigDecimal(4));
        genButton.setDisabled(true);
        AdfFacesContext.getCurrentInstance().addPartialTarget(genButton);
        if(policyNumberDisplay==null){
            
        }else{
            AdfFacesContext.getCurrentInstance().addPartialTarget(policyNumberDisplay);
            
        }
        
        conn.close(); 
        Position = false;
        workflowProcessing ProcessFlow = new workflowProcessing();
        ProcessFlow.UpdateWorkflowAttributes();
        
        //workflowProcessing wf = new workflowProcessing();
        /*Rights = wf.CheckUserRights();
       
        if (Rights.equalsIgnoreCase("N")){
            //workflowProcessing bpm  = new workflowProcessing();
            //bpm.CreateWorkflowInstance(); 
            String Message = "You do not have rights to Perform this Task.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            session.setAttribute("TaskID", null);
            return null;
            
        }else{
           Taske = (String)session.getAttribute("TaskID");
            if (Taske== null){           
            //LOVCC.ClientExists = "Yes";
            session.setAttribute("ClientExists", "Yes");
             Position = false;
             //LOVCC.TaskAssignee = (String)session.getAttribute("Username");
             session.setAttribute("TaskAssignee", (String)session.getAttribute("Username"));
             workflowProcessing bpm  = new workflowProcessing();
             bpm.CreateWorkflowInstance();
            /*ADFUtils.findIterator("findTicketAssigneeIterator").executeQuery(); 
            if (LOVCC.TaskAssignee==null){
                Position = false;
                GetAssignee(); 
                System.out.println("Pol No." + LOVCC.policyNumber);
                return null;
            }else{
                workflowProcessing bpm  = new workflowProcessing();
                bpm.CreateWorkflowInstance();    
          }*/    
            /*}else{
             //do nothing   
            }
           
            System.out.println("Success");
        }*/
        
        
        }
        catch(Exception e) 
        {
            RollBackTicketTransaction();
             GlobalCC.EXCEPTIONREPORTING(conn,e);
        }
          
        return null;
      }
    
    /*public String GeneratePolicyNumber() {
     
      String genPolNumberQuery="BEGIN LMS_WEB_PKG_GRP.confirm_policy(?,?,?,?,?,?);END;";
      Connection conn=new DBConnector().getDatabaseConn();
      try 
      {
          //Confirm you have the rights to perform this task.
          String Rights = null;
          workflowProcessing wf = new workflowProcessing();
          Rights = wf.CheckUserRights();
          
          if (Rights.equalsIgnoreCase("N")){
              //workflowProcessing bpm  = new workflowProcessing();
              //bpm.CreateWorkflowInstance(); 
              String Message = "You do not have rights to Perform this Task.";
              FacesContext.getCurrentInstance().addMessage(null, 
                                                           new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                            Message, 
                                                                            Message));
              //LOVCC.TaskID = null;
              return null;
          }
          
          //confirm that there is someone to perform the next task before completing 
          String NextUser = null;
          //LOVCC.ProcessShtDesc = "UWNB";
          //LOVCC.ProcessAreaShtDesc = "ACCS";
          //LOVCC.ProcessSubAShtDesc = "ACCS";
          //LOVCC.TaskAssignee = null;
          session.setAttribute("ProcessShtDesc", "UWNB");
          session.setAttribute("ProcessAreaShtDesc", "ACCS");
          session.setAttribute("ProcessSubAShtDesc", "ACCS");
          session.setAttribute("TaskAssignee", null);
          
          session.setAttribute("NextTaskAssignee", "N");
            ADFUtils.findIterator("findTicketAssigneeIterator").executeQuery(); 
          NextUser = (String)session.getAttribute("NextTaskAssignee");
          String TaskAss = (String)session.getAttribute("NextTaskAssignee");
          if (TaskAss == null && NextUser.equalsIgnoreCase("N")){
              String Message = "There is no User to Assign the Next Task. Consult the Administrator.";
              FacesContext.getCurrentInstance().addMessage(null, 
                                                           new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                            Message, 
                                                                            Message));
              return null;
                  
          } 
          
          //Confirm that there is no other task.
          String Taske = (String)session.getAttribute("TaskID");
          if(Taske!=null){
              String Message = "A Task has been selected. Unselect it and try again.";
              FacesContext.getCurrentInstance().addMessage(null, 
                                                           new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                            Message, 
                                                                            Message));
              return null;
              
          }
          
        CallableStatement cstmt=conn.prepareCall(genPolNumberQuery);
        cstmt.setString(1,null);
        cstmt.setBigDecimal(2,(BigDecimal)session.getAttribute("ProductCode"));
        cstmt.setBigDecimal(3,(BigDecimal)session.getAttribute("QuoteCode"));
        cstmt.registerOutParameter(4,OracleTypes.DECIMAL);
        cstmt.setBigDecimal(5,new BigDecimal(001));
        cstmt.registerOutParameter(6,OracleTypes.VARCHAR);
        cstmt.execute();
           
          policyNumberDisplay.setValue(cstmt.getString(6));
          //LOVCC.policyNumber=cstmt.getString(6);
          //LOVCC.PolicyNumberSel = cstmt.getString(6);
          session.setAttribute("policyNumber", cstmt.getString(6));
          session.setAttribute("PolicyNumberSel", cstmt.getString(6));
          //LOVCC.policyCode=cstmt.getBigDecimal(4);
          session.setAttribute("policyCode", cstmt.getBigDecimal(4));
          genButton.setDisabled(true);
          AdfFacesContext.getCurrentInstance().addPartialTarget(genButton);
          if(policyNumberDisplay==null){
              
          }else{
              AdfFacesContext.getCurrentInstance().addPartialTarget(policyNumberDisplay);
              
          }
          
         
          //workflowProcessing wf = new workflowProcessing();
          Rights = wf.CheckUserRights();
          conn.close(); 
          if (Rights.equalsIgnoreCase("N")){
              //workflowProcessing bpm  = new workflowProcessing();
              //bpm.CreateWorkflowInstance(); 
              String Message = "You do not have rights to Perform this Task.";
              FacesContext.getCurrentInstance().addMessage(null, 
                                                           new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                            Message, 
                                                                            Message));
              session.setAttribute("TaskID", null);
              return null;
              
          }else{
             Taske = (String)session.getAttribute("TaskID");
              if (Taske== null){           
              //LOVCC.ClientExists = "Yes";
              session.setAttribute("ClientExists", "Yes");
               Position = false;
               //LOVCC.TaskAssignee = (String)session.getAttribute("Username");
               session.setAttribute("TaskAssignee", (String)session.getAttribute("Username"));
               workflowProcessing bpm  = new workflowProcessing();
               bpm.CreateWorkflowInstance();
              /*ADFUtils.findIterator("findTicketAssigneeIterator").executeQuery(); 
              if (LOVCC.TaskAssignee==null){
                  Position = false;
                  GetAssignee(); 
                  System.out.println("Pol No." + LOVCC.policyNumber);
                  return null;
              }else{
                  workflowProcessing bpm  = new workflowProcessing();
                  bpm.CreateWorkflowInstance();    
            }*/    
              /*}else{
               //do nothing   
              }
             
              System.out.println("Success");
          }
      }
      catch(Exception e) 
      {
            GlobalCC.EXCEPTIONREPORTING(conn,e);
      }
        
      return null;
    }*/
    
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
          workflowProcessing bpm  = new workflowProcessing();   
          if(Position == true){
              bpm.CompleteTask(); 
              session.setAttribute("editComponents", "N");
              GlobalCC.RedirectPage("/g_undwrt.jspx");  
          }else{
              bpm.CreateWorkflowInstance();
                    
          }
          String TaskAss = (String)session.getAttribute("TaskAssignee");    
          if (!TaskAss.equalsIgnoreCase((String)session.getAttribute("Username"))){
              
             
              String Message = "You have Successfully Completed this Task";
              FacesContext.getCurrentInstance().addMessage(null, 
                                                           new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                            Message, 
                                                                            Message));
              if(Position == true){
                  session.setAttribute("editComponents", "N");
                  GlobalCC.RedirectPage("/g_undwrt.jspx");  
              }
            
              return null;
              
          }else{
             
              
              String Message = "You have Successfully Completed this Task.";
              FacesContext.getCurrentInstance().addMessage(null, 
                                                           new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                            Message, 
                                                                            Message));
             
             
              return null;
              
          }
          


          
      }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
          }
        
        return null;
      }
    
    public String HideResults(){
        searchResults.setRendered(false); 
        searchButton.setDisabled(false);
        AdfFacesContext.getCurrentInstance().addPartialTarget(searchButton);
        return null;
    }
    
    public String ConvertPolicy() {
      String ConvertQuery="BEGIN LMS_WEB_PKG_GRP.convert_policy(?,?,?,?,?,?);END;";
      Connection conn=new DBConnector().getDatabaseConn();
      try 
      {
          //Get Categories...
          if(categoriesTab.isRendered()){
            //proceed..
          }else{
            session.setAttribute("booleanSelect", "T");
            ADFUtils.findIterator("findQuoteCategoriesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(categoriesTable);
          }
          ARRAY array = CategoriesToConvert(); 
          if(array==null){
            ConvertQuery="BEGIN LMS_WEB_PKG_GRP.convert_policy(?,?,?,?,?);END;";
          }
          
          //Confirm you have rights to perform this task.
          String Rights = null;

          session.setAttribute("ProcessShtDesc", "UWNB");
          session.setAttribute("ProcessAreaShtDesc", "ACCS");
          session.setAttribute("ProcessSubAShtDesc", "ACCS");
          workflowProcessing wf = new workflowProcessing();
          Rights = wf.CheckUserRights();
          
          if (Rights.equalsIgnoreCase("N")){
              //workflowProcessing bpm  = new workflowProcessing();
              //bpm.CreateWorkflowInstance(); 
              String Message = "You do not have rights to Perform this Task.";
              FacesContext.getCurrentInstance().addMessage(null, 
                                                           new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                            Message, 
                                                                            Message));
              //LOVCC.TaskID = null;
              return null;
          }
          
          //confirm that there is someone to perform the next task before completing 
          String NextUser = null;

          session.setAttribute("ProcessShtDesc", "UWNB");
          session.setAttribute("ProcessAreaShtDesc", "ACCS");
          session.setAttribute("ProcessSubAShtDesc", "ACCS");
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
          
          //ensure task is selected.
          String Taske = (String)session.getAttribute("TaskID");
          if (Taske == null){
              String Message = "No Task Selected";
              FacesContext.getCurrentInstance().addMessage(null, 
                                                           new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                            Message, 
                                                                            Message));
              return null;
              
          }
          
          //confirm it is the right task being completed
          String MyTask = null;
          CallableStatement cst3 = null;
          String Complete = "BEGIN TQC_WEB_PKG.check_task_completion(?,?,?,?);END;";
          cst3 = conn.prepareCall(Complete);
          cst3.setString(1,"UCONV"); 
          cst3.setString(2,(String)session.getAttribute("TaskID")); 
          cst3.setInt(3, (Integer)session.getAttribute("sysCode"));
          cst3.registerOutParameter(4, oracle.jdbc.OracleTypes.VARCHAR);
          cst3.execute();
          MyTask = cst3.getString(4);
          if(MyTask.equalsIgnoreCase("N")){
              String Message = "the Task Selected Does not Correspond to the Activity being Performed. Cannot Complete";
              FacesContext.getCurrentInstance().addMessage(null, 
                                                                       new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                                        Message, 
                                                                                        Message));
                  return null;  
          }

        CallableStatement cstmt=conn.prepareCall(ConvertQuery);
        cstmt.setString(1,(String)session.getAttribute("policyNumber"));
        cstmt.setBigDecimal(2,(BigDecimal)session.getAttribute("QuoteCode"));
        cstmt.setDate(3,null);
        cstmt.registerOutParameter(4,OracleTypes.DECIMAL);
        cstmt.registerOutParameter(5,OracleTypes.DECIMAL);
        if(array==null){
          //Proceed Without Container...
        }else{
          cstmt.setArray(6, array);
        }
        
          
        cstmt.execute();
         
              
        session.setAttribute("Authorised", "N");

        session.setAttribute("endorsementCode", cstmt.getBigDecimal(4));
        session.setAttribute("transactionNumber", cstmt.getBigDecimal(5));
        
          //LOVCC.ProcessShtDesc = "UWNB";
          //LOVCC.ProcessAreaShtDesc = "ACCS";
          //LOVCC.ProcessSubAShtDesc = "ACCS";
          session.setAttribute("ProcessShtDesc", "UWNB");
          session.setAttribute("ProcessAreaShtDesc", "ACCS");
          session.setAttribute("ProcessSubAShtDesc", "ACCS");
          Rights = wf.CheckUserRights(); 
          conn.close(); 
          if(Rights.equalsIgnoreCase("Y")){
              //LOVCC.taskselAssignee = (String)session.getAttribute("Username");
              session.setAttribute("taskselAssignee", (String)session.getAttribute("Username"));
              wf.CompleteTask();
              session.setAttribute("editComponents", "N");
              GlobalCC.RedirectPage("/g_undwrt.jspx");   
          }else{
                ADFUtils.findIterator("findTicketAssigneeIterator").executeQuery(); 
         TaskAss = (String)session.getAttribute("TaskAssignee");   
          if (TaskAss==null){
                  GetAssignee();
                 Position = true;
                  return null;
          }else{
              wf.CompleteTask();
              String Message = "Current Task Complete. The Next Task " + (String)session.getAttribute("TaskActivityName") +  " has been Successfully assigned to " + (String)session.getAttribute("TaskAssignee");
              FacesContext.getCurrentInstance().addMessage(null, 
                                                               new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                                Message, 
                                                                                Message));
              session.setAttribute("TaskID", null);
              return null;
          }
          }
        
      }
      catch(Exception e) 
      {
            GlobalCC.EXCEPTIONREPORTING(conn,e);
      }
      return null;
    }


    public void setConProductsLOV(RichTable conProductsLOV) {
        this.conProductsLOV = conProductsLOV;
    }

    public RichTable getConProductsLOV() {
        return conProductsLOV;
    }

    public void setConProductDisplay(RichInputText conProductDisplay) {
        this.conProductDisplay = conProductDisplay;
    }

    public RichInputText getConProductDisplay() {
        return conProductDisplay;
    }

    public void setConQuotationNoDispl(RichInputText conQuotationNoDispl) {
        this.conQuotationNoDispl = conQuotationNoDispl;
    }

    public RichInputText getConQuotationNoDispl() {
        return conQuotationNoDispl;
    }

    public void setQuotationsTable(RichTable quotationsTable) {
        this.quotationsTable = quotationsTable;
    }

    public RichTable getQuotationsTable() {
        return quotationsTable;
    }

    public void setSearchResults(RichPanelBox searchResults) {
        this.searchResults = searchResults;
    }

    public RichPanelBox getSearchResults() {
        return searchResults;
    }

    public void setPolicyNumberDisplay(RichInputText policyNumberDisplay) {
        this.policyNumberDisplay = policyNumberDisplay;
    }

    public RichInputText getPolicyNumberDisplay() {
        return policyNumberDisplay;
    }

    public void setSearchQuote(RichPanelBox searchQuote) {
        this.searchQuote = searchQuote;
    }

    public RichPanelBox getSearchQuote() {
        return searchQuote;
    }

    public void setGenButton(RichCommandButton genButton) {
        this.genButton = genButton;
    }

    public RichCommandButton getGenButton() {
        return genButton;
    }

    public void setSearchButton(RichCommandButton searchButton) {
        this.searchButton = searchButton;
    }

    public RichCommandButton getSearchButton() {
        return searchButton;
    }

    public void setUsersLOV(RichTable usersLOV) {
        this.usersLOV = usersLOV;
    }

    public RichTable getUsersLOV() {
        return usersLOV;
    }

    public void setPosition(boolean Position) {
        QuotationsProcessing.Position = Position;
    }

    public boolean isPosition() {
        return Position;
    }

    public void setResultsLOV(RichTable resultsLOV) {
        this.resultsLOV = resultsLOV;
    }

    public RichTable getResultsLOV() {
        return resultsLOV;
    }

    public void setMyTicketsTab(RichPanelBox myTicketsTab) {
        this.myTicketsTab = myTicketsTab;
    }

    public RichPanelBox getMyTicketsTab() {
        return myTicketsTab;
    }

    public void setEffectiveCbox(RichSelectBooleanCheckbox effectiveCbox) {
        this.effectiveCbox = effectiveCbox;
    }

    public RichSelectBooleanCheckbox getEffectiveCbox() {
        return effectiveCbox;
    }
  public void EffectiveDateListener(ValueChangeEvent valueChangeEvent) {
      // Add event code here...
      if(valueChangeEvent.getOldValue()!=valueChangeEvent.getNewValue()){
          if(effectiveCbox.isSelected()){
              newEffectiveDate.setDisabled(false); 
              newEffectiveDate.setValue(currEffectiveDate.getValue());
              
          }else{
              newEffectiveDate.setDisabled(true);
              newEffectiveDate.setValue(currEffectiveDate.getValue());
          }
      }
  }

    public void setCurrEffectiveDate(RichInputDate currEffectiveDate) {
        this.currEffectiveDate = currEffectiveDate;
    }

    public RichInputDate getCurrEffectiveDate() {
        return currEffectiveDate;
    }

    public void setNewEffectiveDate(RichInputDate newEffectiveDate) {
        this.newEffectiveDate = newEffectiveDate;
    }

    public RichInputDate getNewEffectiveDate() {
        return newEffectiveDate;
    }

    public void setCategoriesTable(RichTable categoriesTable) {
        this.categoriesTable = categoriesTable;
    }

    public RichTable getCategoriesTable() {
        return categoriesTable;
    }
    
  public String SelectAll(){
    
    session.setAttribute("booleanSelect", "T");
    ADFUtils.findIterator("findQuoteCategoriesIterator").executeQuery();
    AdfFacesContext.getCurrentInstance().addPartialTarget(categoriesTable);
    
    return null;
  }
  
  public String UnSelectAll(){
  session.setAttribute("booleanSelect", "F");
  ADFUtils.findIterator("findQuoteCategoriesIterator").executeQuery();
  AdfFacesContext.getCurrentInstance().addPartialTarget(categoriesTable);
  
  return null;
  }
  
  public ARRAY CategoriesToConvert(){
      Connection conn = null;
      CallableStatement cst = null;
      ARRAY array = null; 
      try{
         boolean MakeCall = false;
        DBConnector db = new DBConnector();
        conn = db.getDatabaseConn(); 
        
        
        List ReinstInfo = new LinkedList();
        
        
        ArrayDescriptor descriptor =
            ArrayDescriptor.createDescriptor("LMS_CONVERT_CATEGORIES_TAB", conn);
        
          
        int rowCount = 0;
        boolean Value = false;
        rowCount = categoriesTable.getRowCount();
        if (rowCount == 0){
            return array;
        }
          
        for (int i = 0; i < rowCount; i++) {
          categoriesTable.setRowIndex(i);
          JUCtrlValueBinding nodeBinding =
              (JUCtrlValueBinding)categoriesTable.getRowData();
          if (nodeBinding == null) {
              //do nothing...
          }else{
            Value = (Boolean)nodeBinding.getAttribute("selected");
              if (Value==true){
                MakeCall = true;
                
                ConvertCategories pn = new ConvertCategories();
                pn.setCAT_CODE((BigDecimal)nodeBinding.getAttribute("lcaCode"));
                pn.setCAT_DESC((String)nodeBinding.getAttribute("catDesc"));
                ReinstInfo.add(pn);
              }
          }
        }
        
        if(MakeCall==true){
          array = new ARRAY(descriptor, conn, ReinstInfo.toArray()); 
        }
      }catch(Exception e){
          GlobalCC.EXCEPTIONREPORTING(conn, e);
      }finally{
        GlobalCC.CloseConnections(null, cst, conn);
      } 
    return array;
  }

    public void setCatConvCbox(RichSelectBooleanCheckbox catConvCbox) {
        this.catConvCbox = catConvCbox;
    }

    public RichSelectBooleanCheckbox getCatConvCbox() {
        return catConvCbox;
    }

    public void setCategoriesTab(RichShowDetailItem categoriesTab) {
        this.categoriesTab = categoriesTab;
    }

    public RichShowDetailItem getCategoriesTab() {
        return categoriesTab;
    }

    public void setPolSignDate(RichInputDate polSignDate) {
        this.polSignDate = polSignDate;
    }

    public RichInputDate getPolSignDate() {
        return polSignDate;
    }

    public void dateChanged(ValueChangeEvent evt) {
        if (evt.getNewValue() != evt.getOldValue()) {
           RichInputDate myInput = (RichInputDate)evt.getComponent();
           Connection conn = null;
           DBConnector MyDB = new DBConnector();
           conn = MyDB.getDatabaseConn();
           CallableStatement lgcallStmt = null;
           
           String clmprocessiong =
               "begin LMS_WEB_PKG_GRP.updatePoldocDate(?,?); end;";
           try {
               lgcallStmt = conn.prepareCall(clmprocessiong);
               lgcallStmt.setBigDecimal(1,
                                        (BigDecimal)session.getAttribute("QuoteCode"));
               
               String Date = GlobalCC.checkNullValues(evt.getNewValue());
               if (Date == null) {
                   lgcallStmt.setString(2, null);
               } else {
                   if (Date.contains(":")) {
                       Date = GlobalCC.parseDate(Date);
                       lgcallStmt.setString(2, Date);
                   } else {
                       Date = GlobalCC.upDateParseDate(Date);
                       lgcallStmt.setString(2, Date);
                   }
               }
               lgcallStmt.execute();
               lgcallStmt.close();
               conn.close();
 
           } catch (Exception e) {
               GlobalCC.EXCEPTIONREPORTING(conn, e);
           }
       }
    }
}
