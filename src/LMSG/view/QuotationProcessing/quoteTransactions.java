package LMSG.view.QuotationProcessing;

import java.io.IOException;

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
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.nav.RichCommandLink;
import oracle.adf.view.rich.component.rich.output.RichOutputLabel;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.Key;
import oracle.jbo.Row;

import oracle.jdbc.internal.OracleTypes;

import org.apache.myfaces.trinidad.model.RowKeySet;

import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

import LMSG.view.Base.ADFUtils;

import LMSG.view.Base.CurrentUser;
import LMSG.view.Base.GlobalCC;
import LMSG.view.Base.LOVCC;

import LMSG.view.connect.DBConnector;

import LMSG.view.BPM.workflowProcessing;

public class quoteTransactions extends LOVCC {
  private RichSelectOneChoice quotationTransType;
  private RichOutputLabel effDateLabel;
  private RichInputDate quotationDate;
  private RichPanelGroupLayout quoteButtonRender;
  private RichPanelGroupLayout effectDateRender;
  private RichCommandButton quoteButton;
  private RichInputText quotationNumber;
  private RichTable quotationsTable;
  private RichTable productsDisplayLOV;
  private RichInputText productDisplay;
  private RichOutputLabel quoteNoLabel;
    private RichTable clientsLOV;
    private RichInputText clientsDisplay;
    private RichCommandButton clientButton;
    private RichOutputLabel clientLabel;
    private RichTable usersLOV;
    private RichCommandLink clientLink;
    private RichInputText ticketRemarks;
    private RichPanelBox ticketsTab;
    private RichTable resultsLOV;
    private RichCommandLink assignCreation;
    private RichOutputLabel umbrellaLabel;
    private RichSelectBooleanCheckbox umbrellaCbox;

    public quoteTransactions() {
  }
    
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);

  public void setQuotationTransType(RichSelectOneChoice quotationTransType) {
    this.quotationTransType = quotationTransType;
  }

  public RichSelectOneChoice getQuotationTransType() {
    return quotationTransType;
  }
  public String CreateClient(){
      String Rights = null;
      try{
        session.setAttribute("ProcessShtDesc", "QUOT");
        session.setAttribute("ProcessAreaShtDesc", "DENTR");
        session.setAttribute("ProcessSubAShtDesc", "CLNT");
        
        session.setAttribute("ClientExists", "No");  
        String Result = CreateQuotationProcessFlow();
        if(Result==null){
            return null;
        }else if(Result.equalsIgnoreCase("F")){
            return null;
        }else{
            GlobalCC.RedirectPage("/createClient.jspx"); 
        }
      }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);   
      }
    return null;  
                        
  }
  
  public String AssignClientCreation(){
      try{
          session.setAttribute("ClientExists", "No");
            ADFUtils.findIterator("findTicketAssigneeIterator").executeQuery(); 
          GetAssignee();   
      }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
      }
      return null;
  }
  
  public String AssignProds() {
      
  try{
      DCIteratorBinding dciter = ADFUtils.findIterator("findProductsIterator");
      RowKeySet set =productsDisplayLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      
      while (rowKeySetIter.hasNext()) 
      {
          List l = (List) rowKeySetIter.next();
          Key key = (Key)l.get(0);
          dciter.setCurrentRowWithKey(key.toStringFormat(true));
          Row r = dciter.getCurrentRow();
          productDisplay.setValue(r.getAttribute("prodDesc"));
          
      
         session.setAttribute("productType", r.getAttribute("prodType"));
         session.setAttribute("ProductCode", r.getAttribute("prodCode"));
         session.setAttribute("depCovered", r.getAttribute("PROD_DEPENDT_COVERED2"));
         session.setAttribute("pmasCode", r.getAttribute("PMAS_CODE"));
         session.setAttribute("pmasShtDesc", r.getAttribute("PMAS_SHT_DESC"));
         session.setAttribute("earningsType", r.getAttribute("PROD_EARNING_PRD_TYPE"));
         
        String Trans = (String)session.getAttribute("transType");
        if (Trans.equalsIgnoreCase("NQ")){
          quotationNumber.setValue(null);  
        }else{
        ADFUtils.findIterator("findQuotation1Iterator").executeQuery();    
        AdfFacesContext.getCurrentInstance().addPartialTarget(quotationsTable);
        quotationNumber.setValue(null);
      
        session.setAttribute("QuoteCode", null);
        }
      }
    }catch(Exception e){
        GlobalCC.EXCEPTIONREPORTING(null, e);
    }
      
    return null;
  }
  public String findQuotNumber() {
    DCIteratorBinding dciter = ADFUtils.findIterator("findQuotation1Iterator");
    RowKeySet set;
    set = quotationsTable.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();
           
           while (rowKeySetIter.hasNext()) {
           List l = (List) rowKeySetIter.next();
           Key key = (Key)l.get(0);
           dciter.setCurrentRowWithKey(key.toStringFormat(true));
             
               
           Row r = dciter.getCurrentRow();
               
                  //LOVCC.QuoteCode = (BigDecimal)r.getAttribute("quoCode");
                  session.setAttribute("QuoteCode", r.getAttribute("quoCode"));
                  //LOVCC.PrpCode = (BigDecimal)r.getAttribute("PROP_CODE");
                  session.setAttribute("prpCode",  r.getAttribute("PROP_CODE"));
                  session.setAttribute("AgentCode", r.getAttribute("AGN_CODE"));
                  //To be Removed. Replaced
                  //Quotation.quotationNo = (String)r.getAttribute("quoNo");
                   session.setAttribute("quotationNo", r.getAttribute("quoNo"));
               
               
                  //LOVCC.QuotationNo = (String)r.getAttribute("quoNo");
                  session.setAttribute("QuotationNo", r.getAttribute("quoNo"));
                  quotationNumber.setValue(session.getAttribute("QuotationNo"));
                
    
  }
           return null;
  }

  public void transactionListener(ValueChangeEvent valueChangeEvent) {
    // Add event code here...
    if(quotationTransType.getValue()==null){
      
    }else{
        session.setAttribute("transType",quotationTransType.getValue().toString());
    }
    String Trans = (String)session.getAttribute("transType");
    if (Trans.equalsIgnoreCase("NQ")){

      session.setAttribute("RenderTab", 0);
      quoteButtonRender.setRendered(true);
      effDateLabel.setRendered(true);
      quoteButton.setRendered(false);
      quotationDate.setRendered(true);
      quotationNumber.setRendered(false);
      quotationNumber.setValue(null);
      quotationDate.setValue(null);
      quoteNoLabel.setRendered(false);
      clientsDisplay.setRendered(true);
      clientButton.setRendered(true);
      clientsDisplay.setValue(null);
      clientLabel.setRendered(true);
      clientLink.setRendered(true);
      assignCreation.setRendered(true);
      
      umbrellaLabel.setRendered(true);
      umbrellaCbox.setRendered(true);
      umbrellaCbox.setSelected(false);
         
      session.setAttribute("prpCode", null);
      session.setAttribute("prpDesc", null);
      session.setAttribute("gcoCode", null); //LOVCC.gcoCode=null;
      session.setAttribute("gcoDesc", null); 

      session.setAttribute("QuoteCode", null);

    }else{
      //Quotation.quotationCode = 0;
        session.setAttribute("QuoteCode", null);
      quoteButtonRender.setRendered(true);
      effDateLabel.setRendered(false);
      quoteButton.setRendered(true);
      quotationDate.setRendered(false);
      quoteNoLabel.setRendered(true);
      quotationNumber.setRendered(true);
      clientsDisplay.setRendered(false);
      clientButton.setRendered(false);
      clientLabel.setRendered(false);
      clientLink.setRendered(false);
      assignCreation.setRendered(false);
        
      umbrellaLabel.setRendered(false);
      umbrellaCbox.setRendered(false);
      umbrellaCbox.setSelected(false);

    }

    session.setAttribute("quotationNo", null);
    quotationNumber.setValue(null);
    
    productDisplay.setValue(null);
    session.setAttribute("ProductCode", null);
   
    AdfFacesContext.getCurrentInstance().addPartialTarget(productDisplay); 
    AdfFacesContext.getCurrentInstance().addPartialTarget(effectDateRender);
    AdfFacesContext.getCurrentInstance().addPartialTarget(quoteButtonRender);
    AdfFacesContext.getCurrentInstance().addPartialTarget(quoteButton);
    AdfFacesContext.getCurrentInstance().addPartialTarget(quotationDate);
    AdfFacesContext.getCurrentInstance().addPartialTarget(quotationNumber);
    AdfFacesContext.getCurrentInstance().addPartialTarget(clientsDisplay);
    AdfFacesContext.getCurrentInstance().addPartialTarget(clientButton);
    AdfFacesContext.getCurrentInstance().addPartialTarget(clientLink); 
    AdfFacesContext.getCurrentInstance().addPartialTarget(assignCreation); 
    AdfFacesContext.getCurrentInstance().addPartialTarget(umbrellaLabel); 
    AdfFacesContext.getCurrentInstance().addPartialTarget(umbrellaCbox); 
    
  }
  
  public String LoadQuotation() 
  {
      String Rights = null;
      String Trans = (String)session.getAttribute("transType");
      if(Trans.equals("NQ")){
          session.setAttribute("CoinsurerTotal", 0);
          ticketsTab.setRendered(false); 
        if(quotationDate.getValue()==null){
            GlobalCC.sysInformation("Enter An Effective Date");
            return null;
        }
        Connection conn=new DBConnector().getDatabaseConn();
        try{ 
            
            //Confirm you Have the Rights to Perform this Task
            session.setAttribute("ProcessShtDesc", "QUOT");
            session.setAttribute("ProcessAreaShtDesc", "DENTR");
            session.setAttribute("ProcessSubAShtDesc", "QUOTD");
            
         
          String saveQuery="BEGIN LMS_WEB_PKG_GRP.save_quotation(?,?,?,?,?);END;";
          CallableStatement cstmt=null;
          cstmt=conn.prepareCall(saveQuery);
          cstmt.registerOutParameter(1, OracleTypes.INTEGER);
          cstmt.registerOutParameter(2, OracleTypes.VARCHAR);
          if(quotationDate.getValue()==null){
              cstmt.setString(3, null); 
          }else{
              cstmt.setString(3, GlobalCC.parseDate(quotationDate.getValue().toString())); 
          }
          cstmt.setBigDecimal(4,(BigDecimal)session.getAttribute("ProductCode"));
          if(umbrellaCbox.isSelected()){
            cstmt.setString(5, "Y"); 
          }else{
            cstmt.setString(5, "N"); 
          }
         
          cstmt.execute();
           
          //To be Removed and Replaced with Global Variable  
          session.setAttribute("QuoteCode", cstmt.getBigDecimal(1));
            
          if(umbrellaCbox.isSelected()){
            session.setAttribute("umbrellaCover", "Y");
            session.setAttribute("disableDurationSel", "Y");
            session.setAttribute("policyDurationType", "O");
            session.setAttribute("umbrellaDurationType", "A");
          }else{
            session.setAttribute("umbrellaCover", "N");
            session.setAttribute("disableDurationSel", "N");
            session.setAttribute("policyDurationType", "A");
            session.removeAttribute("umbrellaDurationType");
          }

          //New Global Variable
          session.setAttribute("calcType", "D");
          session.setAttribute("QuotationNo", cstmt.getString(2));
          session.setAttribute("CurrentStatus", "Q");
          cstmt.close();
          conn.close();
          session.setAttribute("ProcessShtDesc", "QUOT");
          session.setAttribute("ProcessAreaShtDesc", "DENTR");
          session.setAttribute("ProcessSubAShtDesc", "QUOTD");
          session.setAttribute("ClientExists", "Yes");
          String Result = CreateQuotationProcessFlow();
          if(Result==null){
              return null;
          }else if(Result.equalsIgnoreCase("F")){
              return null;
          }else{
              GlobalCC.RedirectPage("/g_quotone.jspx"); 
          }
        }
        catch(Exception e) 
        {
            GlobalCC.EXCEPTIONREPORTING(conn,e);
        }
      }
      else if(Trans.equals("RQ"))
      {
          ticketsTab.setRendered(false); 
        if(quotationNumber.getValue()==null){
          GlobalCC.sysInformation("Select A Quotation");
          return null;
          
        }
      
        try {
          //Confirm you Have the Rights to Perform this Task
          session.setAttribute("ProcessShtDesc", "QUOT");
          session.setAttribute("ProcessAreaShtDesc", "DENTR");
          session.setAttribute("ProcessSubAShtDesc", "QUOTD");
            
          String reviseQuery="BEGIN LMS_WEB_PKG_GRP.revise_quotation(?,?,?);END;";
          Connection conn=new DBConnector().getDatabaseConn();
          CallableStatement cstmt=conn.prepareCall(reviseQuery);
          cstmt.setBigDecimal(1,(BigDecimal)session.getAttribute("QuoteCode"));
          cstmt.registerOutParameter(2,OracleTypes.DECIMAL);
          cstmt.registerOutParameter(3,OracleTypes.VARCHAR);
          
         
          cstmt.execute();
            
          //To be Removed and Replaced with Global Variable  
          //Quotation.quotationCode=cstmt.getInt(2);
        
            //New Global Variable
          //BigDecimal NewQuote = new BigDecimal(cstmt.getInt(2));
          session.setAttribute("QuoteCode", cstmt.getBigDecimal(2));  
          session.setAttribute("QuotationNo", cstmt.getString(3));
          session.setAttribute("transType", "EQ");
          session.setAttribute("CurrentStatus", "Q");
          conn.close(); 
          String Result = CreateQuotationProcessFlow();
          if(Result==null){
              return null;
          }else if(Result.equalsIgnoreCase("F")){
              return null;
          }else{
            workflowProcessing ProcessFlow = new workflowProcessing();
            ProcessFlow.CompleteTask();
            GlobalCC.RedirectPage("/gquoedt.jspx"); 
          }
        }
        catch(Exception e) 
        {
          GlobalCC.EXCEPTIONREPORTING(null, e);
        }
       
      }
      else
      {
      if(quotationNumber.getValue()==null){
        GlobalCC.sysInformation("Select A Quotation Number");
        return null;
        
      }
     
        if(quotationTransType.getValue()==null){
          GlobalCC.sysInformation("Select A Quotation Operation");
          return null;
          
        }
          
          
      if (quotationTransType.getValue().toString().equalsIgnoreCase("EQ")){
          ADFUtils.findIterator("findTicketDetailsByUserIterator").executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(resultsLOV);
          ticketsTab.setRendered(true); 
          return null;
      } 
        try 
        {
          GlobalCC.RedirectPage("/gquoedt.jspx");
        }
        catch(Exception e) 
        {
                GlobalCC.EXCEPTIONREPORTING(null,e);
        }
    }
    return null;
  }
  
  public String CreateQuotationProcessFlow(){
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
                  ADFUtils.findIterator("findTicketAssigneeIterator").executeQuery(); 
                  String TaskAss = (String)session.getAttribute("TaskAssignee");
                  if (TaskAss==null){
                      //Allow the User to Select A User to Assign the Task. i.e Render Popup. 
                      GetAssignee(); 
                      return Result;
                  }else{
                  
                  //System Defaults a User to Perform the Task...
                  ProcessFlow.CreateWorkflowInstance();
                  if(session.getAttribute("workflowID")==null){
                      GlobalCC.sysInformation("There was a Problem Encountered when initializing the Process Flow" +
                              "Engine. Please Contact your Administrator.");
                      return Result;
                  }else{
                  session.setAttribute("TaskID", null);
                  GlobalCC.sysInformation("The Task " + (String)session.getAttribute("TaskActivityName") +  " has been Successfully assigned to " + (String)session.getAttribute("TaskAssignee"));
                  return Result;
                  }
                  }
              }
              
              //Start BPM Process..
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
                          //taskselCreateDate=(Date)r.getAttribute("TCKT_DATE");d
                session.setAttribute("taskselName", r.getAttribute("TCKT_NAME"));
                session.setAttribute("TaskActivityName", r.getAttribute("TCKT_NAME"));
                session.setAttribute("taskselAssignee", r.getAttribute("TCKT_TO"));
                session.setAttribute("taskselDueDate", r.getAttribute("TCKT_DUE_DATE"));
                session.setAttribute("taskselID", r.getAttribute("TCKT_CDE"));
                session.setAttribute("taskselCreateDate", r.getAttribute("TCKT_DATE"));
                       
                GlobalCC.RedirectPage("/wfProcessing.jspx");
            
            }
            
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
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
        DCIteratorBinding dciter = 
        ADFUtils.findIterator("findTicketAssigneeIterator");
        RowKeySet set =usersLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        
        while (rowKeySetIter.hasNext()) 
        {
            List l = (List) rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
        
            session.setAttribute("TaskAssigneeID", r.getAttribute("taskUserID"));
            session.setAttribute("TaskAssignee", r.getAttribute("taskUserShtDesc"));
            
            session.setAttribute("TicketRemarks", null);
            if(ticketRemarks.getValue()==null || ticketRemarks.getValue().toString().equalsIgnoreCase("Add Remark...")) {
                session.setAttribute("TicketRemarks", null);
            }else{
                session.setAttribute("TicketRemarks", ticketRemarks.getValue().toString());
            }
        }
          String Taske = (String)session.getAttribute("TaskID");
          if (Taske == null){
              workflowProcessing bpm  = new workflowProcessing();
              bpm.CreateWorkflowInstance(); 
              if(session.getAttribute("workflowID")==null){
                  GlobalCC.sysInformation("There was a Problem Encountered when initializing the Process Flow" +
                          "Engine. Please Contact your Administrator.");
                  return null;
              }
          }else{
              DBConnector datahandler = new DBConnector();
              Connection conn;
              conn = datahandler.getDatabaseConn();
               
               String MyTask = null;
               CallableStatement cst3 = null;
               String Complete = "BEGIN TQC_WEB_PKG.check_task_completion(?,?,?,?);END;";
               cst3 = conn.prepareCall(Complete);
               cst3.setString(1,"CQUOT"); 
               cst3.setString(2,(String)session.getAttribute("TaskID")); 
               cst3.setInt(3,(Integer)session.getAttribute("sysCode"));
               cst3.registerOutParameter(4, oracle.jdbc.OracleTypes.VARCHAR);
               cst3.execute();
             
               MyTask = cst3.getString(4);
              conn.close();   
               if (MyTask.equalsIgnoreCase("Y")){
               workflowProcessing bpm  = new workflowProcessing();
               bpm.CompleteTask();
               }else{
                   //do nothing
                   return null;
               }
              
          }
          
          String TaskAss = (String)session.getAttribute("TaskAssignee");
          String Client = (String)session.getAttribute("ClientExists");
          if (TaskAss.equalsIgnoreCase((String)session.getAttribute("Username"))){
              if (Client.equalsIgnoreCase("No")){
                  GlobalCC.RedirectPage("/createClient.jspx");   
              }else{
                  GlobalCC.RedirectPage("/g_quotone.jspx");  
              }
          }else{
              session.setAttribute("TaskID", null);
              GlobalCC.sysInformation("The Next Task " + (String)session.getAttribute("TaskActivityName") +  " has been Successfully assigned to " + (String)session.getAttribute("TaskAssignee"));
           
          }
          GlobalCC.hidePopup("lmsgroup:users");
          System.out.println("Success");
        
    }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
      
      return null;
    }
    
  
    public String AssignNewClients() {
      DCIteratorBinding dciter = ADFUtils.findIterator("findProposers1Iterator");
      RowKeySet set =clientsLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      
      //System.out.println(1);
      while (rowKeySetIter.hasNext()) 
      {
          List l = (List) rowKeySetIter.next();
          Key key = (Key)l.get(0);
          dciter.setCurrentRowWithKey(key.toStringFormat(true));
          Row r = dciter.getCurrentRow();
          
         clientsDisplay.setValue(r.getAttribute("CLIENT"));
          
         session.setAttribute("prpCode", r.getAttribute("PRP_CODE")); //LOVCC.prpCode=(BigDecimal);
         session.setAttribute("prpDesc", r.getAttribute("CLIENT")); //LOVCC. = (String)r.getAttribute("CLIENT");
         session.setAttribute("gcoCode", r.getAttribute("GCO_CODE")); //LOVCC.gcoCode=(BigDecimal)r.getAttribute("GCO_CODE");
         session.setAttribute("gcoDesc", r.getAttribute("GCO_DESC")); //LOVCC.gcoDesc = (String)r.getAttribute("GCO_DESC");
         session.setAttribute("ClientCode", r.getAttribute("prp_clnt_code"));
          
        
         //occupationOneDisplay.setValue(Occupation);
         
        
      }
      
      return null;
    }
    

  public void setEffDateLabel(RichOutputLabel effDateLabel) {
    this.effDateLabel = effDateLabel;
  }

  public RichOutputLabel getEffDateLabel() {
    return effDateLabel;
  }

  public void setQuotationDate(RichInputDate quotationDate) {
    this.quotationDate = quotationDate;
  }

  public RichInputDate getQuotationDate() {
    return quotationDate;
  }

  public void setQuoteButtonRender(RichPanelGroupLayout quoteButtonRender) {
    this.quoteButtonRender = quoteButtonRender;
  }

  public RichPanelGroupLayout getQuoteButtonRender() {
    return quoteButtonRender;
  }

  public void setEffectDateRender(RichPanelGroupLayout effectDateRender) {
    this.effectDateRender = effectDateRender;
  }

  public RichPanelGroupLayout getEffectDateRender() {
    return effectDateRender;
  }

  public void setQuoteButton(RichCommandButton quoteButton) {
    this.quoteButton = quoteButton;
  }

  public RichCommandButton getQuoteButton() {
    return quoteButton;
  }

  public void setQuotationNumber(RichInputText quotationNumber) {
    this.quotationNumber = quotationNumber;
  }

  public RichInputText getQuotationNumber() {
    return quotationNumber;
  }

  public void setQuotationsTable(RichTable quotationsTable) {
    this.quotationsTable = quotationsTable;
  }

  public RichTable getQuotationsTable() {
    return quotationsTable;
  }

  public void setProductsDisplayLOV(RichTable productsDisplayLOV) {
    this.productsDisplayLOV = productsDisplayLOV;
  }

  public RichTable getProductsDisplayLOV() {
    return productsDisplayLOV;
  }

  public void setProductDisplay(RichInputText productDisplay) {
    this.productDisplay = productDisplay;
  }

  public RichInputText getProductDisplay() {
    return productDisplay;
  }

  public void setQuoteNoLabel(RichOutputLabel quoteNoLabel) {
    this.quoteNoLabel = quoteNoLabel;
  }

  public RichOutputLabel getQuoteNoLabel() {
    return quoteNoLabel;
  }

    public void setClientsLOV(RichTable clientsLOV) {
        this.clientsLOV = clientsLOV;
    }

    public RichTable getClientsLOV() {
        return clientsLOV;
    }

    public void setClientsDisplay(RichInputText clientsDisplay) {
        this.clientsDisplay = clientsDisplay;
    }

    public RichInputText getClientsDisplay() {
        return clientsDisplay;
    }

    public void setClientButton(RichCommandButton clientButton) {
        this.clientButton = clientButton;
    }

    public RichCommandButton getClientButton() {
        return clientButton;
    }

    public void setClientLabel(RichOutputLabel clientLabel) {
        this.clientLabel = clientLabel;
    }

    public RichOutputLabel getClientLabel() {
        return clientLabel;
    }

    public void setUsersLOV(RichTable usersLOV) {
        this.usersLOV = usersLOV;
    }

    public RichTable getUsersLOV() {
        return usersLOV;
    }

    public void setClientLink(RichCommandLink clientLink) {
        this.clientLink = clientLink;
    }

    public RichCommandLink getClientLink() {
        return clientLink;
    }

    public void setTicketRemarks(RichInputText ticketRemarks) {
        this.ticketRemarks = ticketRemarks;
    }

    public RichInputText getTicketRemarks() {
        return ticketRemarks;
    }

    public void setTicketsTab(RichPanelBox ticketsTab) {
        this.ticketsTab = ticketsTab;
    }

    public RichPanelBox getTicketsTab() {
        return ticketsTab;
    }

    public void setResultsLOV(RichTable resultsLOV) {
        this.resultsLOV = resultsLOV;
    }

    public RichTable getResultsLOV() {
        return resultsLOV;
    }

    public void setAssignCreation(RichCommandLink assignCreation) {
        this.assignCreation = assignCreation;
    }

    public RichCommandLink getAssignCreation() {
        return assignCreation;
    }

    public void setUmbrellaLabel(RichOutputLabel umbrellaLabel) {
        this.umbrellaLabel = umbrellaLabel;
    }

    public RichOutputLabel getUmbrellaLabel() {
        return umbrellaLabel;
    }

    public void setUmbrellaCbox(RichSelectBooleanCheckbox umbrellaCbox) {
        this.umbrellaCbox = umbrellaCbox;
    }

    public RichSelectBooleanCheckbox getUmbrellaCbox() {
        return umbrellaCbox;
    }
}
