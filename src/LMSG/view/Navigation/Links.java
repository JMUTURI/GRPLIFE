package LMSG.view.Navigation;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import java.util.Iterator;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.layout.RichPanelBox;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;


import oracle.adf.view.rich.component.rich.nav.RichCommandImageLink;
import oracle.adf.view.rich.component.rich.nav.RichCommandLink;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.Key;
import oracle.jbo.Row;


import oracle.jdbc.OracleTypes;

import org.apache.myfaces.trinidad.model.RowKeySet;
import LMSG.view.Base.ADFUtils;

import LMSG.view.Base.GlobalCC;
import LMSG.view.Base.LOVCC;

import LMSG.view.Base.ReinitializeVar;


import LMSG.view.connect.DBConnector;

import LMSG.view.BPM.workflowProcessing;

public class Links extends LOVCC{
  private RichCommandButton loadQuotation;
  private RichInputText quotationNo1;
  private RichInputDate quotationDate;
  public static RichInputText quotationNumber;
  private RichInputText productDisplay;
  private RichCommandButton assignProducts;
  private RichTable productsDisplayLOV;
    private RichCommandLink clientLink;
    private RichCommandImageLink quotesMain;
    private RichCommandLink quotesDefinition;
    private RichCommandLink quotesEnq;
    private RichCommandLink convQuote;
    private RichCommandLink policies;
    private HtmlPanelGrid subpolicies;
    private HtmlPanelGrid quotationLinks;
    private HtmlPanelGrid policiesLinks;
    private HtmlPanelGrid subMedicals;
    private HtmlPanelGrid claimsLinks;
    private HtmlPanelGrid ticketLinks;
    private HtmlPanelGrid setupsLinks;
    private HtmlPanelGrid accountingLinks;
    private RichPanelBox quotePanel;
    private RichPanelBox uwPanel;
    private RichPanelBox claimsPanel;
    private RichPanelBox accountingPanel;
    private RichPanelBox ticketsPanel;
    private RichPanelBox setupsPanel;
    private RichPanelBox reportingPanel;

    public Links() {
  }
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
  
    public String closeDialog(){
        AdfFacesContext.getCurrentInstance().returnFromDialog(GlobalCC.dialogName,null);
        return null;
    }

  public String goHome() {
    try {
        ReinitializeVar Reset = new ReinitializeVar();
        Reset.ReinitializeVar2();
        session.setAttribute("UserSelected", session.getAttribute("Username"));
        session.setAttribute("TaskID", null);
      GlobalCC.RedirectPage("/lmsmain.jspx");
      //GlobalCC.RedirectPage("/lmsmain.jspx");
    } catch (Exception e) {
      FacesContext.getCurrentInstance().addMessage(null, 
                                                   new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                                                                    e.getMessage(), 
                                                                    e.getMessage()));
    }
    return null;
  }
  
    public String CreateClient() 
    {
      try {  
        ReinitializeVar Reset = new ReinitializeVar();
        Reset.ReinitializeVariables();

          session.setAttribute("TaskID", null);
        GlobalCC.RedirectPage("/createClient.jspx");
        //GlobalCC.RedirectPage("/createClient.jspx");
      } catch (Exception e) {
        FacesContext.getCurrentInstance().addMessage(null, 
                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                                                                      e.getMessage(), 
                                                                      e.getMessage()));
      }
      return null;
    }
  
  public String viewPolicies() 
  {
    try {
      ReinitializeVar Reset = new ReinitializeVar();
      Reset.ReinitializeVariables();
        //LOVCC.Authorised = "N";
        session.setAttribute("Authorised", "N");

        session.setAttribute("TaskID", null);
      GlobalCC.RedirectPage("/g_undedt.jspx");
      //GlobalCC.RedirectPage("/g_undedt.jspx");
    } catch (Exception e) {
      FacesContext.getCurrentInstance().addMessage(null, 
                                                   new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                                                                    e.getMessage(), 
                                                                    e.getMessage()));
    }
    return null;
  }
  
    public String PolicyMedicals() 
    {
      try {
        ReinitializeVar Reset = new ReinitializeVar();
        Reset.ReinitializeVariables();
          //LOVCC.MedicalScrnRender = "M";
          session.setAttribute("MedicalScrnRender", "M");

          session.setAttribute("TaskID", null);
        GlobalCC.RedirectPage("/medicals.jspx");
        //GlobalCC.RedirectPage("/medicals.jspx");
      } catch (Exception e) {
        FacesContext.getCurrentInstance().addMessage(null, 
                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                                                                      e.getMessage(), 
                                                                      e.getMessage()));
      }
      return null;
    }
    
    public String TransactionAllocation() 
    {
      try {
        ReinitializeVar Reset = new ReinitializeVar();
        Reset.ReinitializeVariables();

          session.setAttribute("TaskID", null);
        GlobalCC.RedirectPage("/g_alloctrans.jspx");
        //GlobalCC.RedirectPage("/g_alloctrans.jspx");
      } catch (Exception e) {
        FacesContext.getCurrentInstance().addMessage(null, 
                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                                                                      e.getMessage(), 
                                                                      e.getMessage()));
      }
      return null;
    }
    public String MedicalPayments() 
    {
      try {
        ReinitializeVar Reset = new ReinitializeVar();
        Reset.ReinitializeVariables();
          //LOVCC.MedicalScrnRender = "P";
          session.setAttribute("MedicalScrnRender", "P");

          session.setAttribute("TaskID", null);
        GlobalCC.RedirectPage("/medicals.jspx");
        //GlobalCC.RedirectPage("/medicals.jspx");
      } catch (Exception e) {
        FacesContext.getCurrentInstance().addMessage(null, 
                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                                                                      e.getMessage(), 
                                                                      e.getMessage()));
      }
      return null;
    }
    public String PensionAdministration() 
    {
      try {
        ReinitializeVar Reset = new ReinitializeVar();
        Reset.ReinitializeVariables();

          session.setAttribute("TaskID", null);
        GlobalCC.RedirectPage("/pensionValuation.jspx");
      } catch (Exception e) {
        FacesContext.getCurrentInstance().addMessage(null, 
                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                                                                      e.getMessage(), 
                                                                      e.getMessage()));
      }
      return null;
    }
    public String PolicyEnquiry() 
    {
      try {
        ReinitializeVar Reset = new ReinitializeVar();
        Reset.ReinitializeVariables();
        //LOVCC.Authorised = "Y";
        session.setAttribute("Authorised", "Y");

          session.setAttribute("TaskID", null);
        GlobalCC.RedirectPage("/g_undedt.jspx");
      } catch (Exception e) {
        FacesContext.getCurrentInstance().addMessage(null, 
                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                                                                      e.getMessage(), 
                                                                      e.getMessage()));
      }
      return null;
    }
    
    public String Receipting() 
    {
      try {
        ReinitializeVar Reset = new ReinitializeVar();
        Reset.ReinitializeVar2();

        session.setAttribute("TaskID", null);
        GlobalCC.RedirectPage("/g_receipting.jspx");
      } catch (Exception e) {
        FacesContext.getCurrentInstance().addMessage(null, 
                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                                                                      e.getMessage(), 
                                                                      e.getMessage()));
      }
      return null;
    }
    
  public String GoToOpeningBalances() 
  {
    try {
      ReinitializeVar Reset = new ReinitializeVar();
      Reset.ReinitializeVar2();

      session.setAttribute("TaskID", null);
      GlobalCC.RedirectPage("/loadBalances.jspx");
    } catch (Exception e) {
      FacesContext.getCurrentInstance().addMessage(null, 
                                                   new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                                                                    e.getMessage(), 
                                                                    e.getMessage()));
    }
    return null;
  }
  
  public String GoToCommissionPayments() 
  {
    try {
      ReinitializeVar Reset = new ReinitializeVar();
      Reset.ReinitializeVar2();

      session.setAttribute("TaskID", null);
      GlobalCC.RedirectPage("/commissionPayments.jspx");
    } catch (Exception e) {
      FacesContext.getCurrentInstance().addMessage(null, 
                                                   new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                                                                    e.getMessage(), 
                                                                    e.getMessage()));
    }
    return null;
  }
  
  public String GoToLoadPolicies() 
  {
    try {
      ReinitializeVar Reset = new ReinitializeVar();
      Reset.ReinitializeVar2();
      session.setAttribute("action", "A");

      session.setAttribute("TaskID", null);
      GlobalCC.RedirectPage("/loadPolicies.jspx");
    } catch (Exception e) {
      FacesContext.getCurrentInstance().addMessage(null, 
                                                   new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                                                                    e.getMessage(), 
                                                                    e.getMessage()));
    }
    return null;
  }
    
    public String Renewals() 
    {
      try {
        ReinitializeVar Reset = new ReinitializeVar();
        Reset.ReinitializeVar2();

        session.setAttribute("TaskID", null);
        session.setAttribute("CurrentStatus", "E");
        session.setAttribute("Authorised", "N");
        session.setAttribute("renewDirect", "Y");
        GlobalCC.RedirectPage("/g_renew.jspx");
      } catch (Exception e) {
        FacesContext.getCurrentInstance().addMessage(null, 
                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                                                                      e.getMessage(), 
                                                                      e.getMessage()));
      }
      return null;
    }
    
  public String RenewalWorkingArea() 
  {
    try {
      ReinitializeVar Reset = new ReinitializeVar();
      Reset.ReinitializeVar2();

      session.setAttribute("TaskID", null);
      session.setAttribute("CurrentStatus", "E");
      session.setAttribute("Authorised", "N");
      session.setAttribute("renewDirect", "N");
      session.setAttribute("RenewalArea", "Y");
      GlobalCC.RedirectPage("/g_renew.jspx");
    } catch (Exception e) {
      FacesContext.getCurrentInstance().addMessage(null, 
                                                   new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                                                                    e.getMessage(), 
                                                                    e.getMessage()));
    }
    return null;
  }
    
  public String PolicyLandingScreen() 
  {
    try {
      //ReinitializeVar Reset = new ReinitializeVar();
      //Reset.ReinitializeVariables();

        session.setAttribute("TaskID", null);
        session.setAttribute("editComponents", "N");
      GlobalCC.RedirectPage("/g_undwrt.jspx");
    } catch (Exception e) {
      FacesContext.getCurrentInstance().addMessage(null, 
                                                   new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                                                                    e.getMessage(), 
                                                                    e.getMessage()));
    }
    return null;
  }

  public String getQuotations() 
  {
      
    try {
        String Rights = null;
        ReinitializeVar Reset = new ReinitializeVar();
        Reset.ReinitializeVar2();
                                    
        //LOVCC.CurrentStatus = "Q";
        session.setAttribute("CurrentStatus", "Q");
        //LOVCC.ProcessShtDesc = "QUOT";
        //LOVCC.ProcessAreaShtDesc = "ACCS";
        //LOVCC.ProcessSubAShtDesc = "ACCS";
        session.setAttribute("ProcessShtDesc", "QUOT");
        session.setAttribute("ProcessAreaShtDesc", "ACCS");
        session.setAttribute("ProcessSubAShtDesc", "ACCS");
        
        workflowProcessing wf = new workflowProcessing();
        Rights = wf.CheckUserRights();
        
        FindProcessDetails();

        session.setAttribute("TaskID", null);
         //underwritingPolicy.UW = "Q";
        if(Rights==null){
          GlobalCC.INFORMATIONREPORTING("You do not have rights to access the Quotations Module");
          //GlobalCC.RedirectPage("/g_qtrans.jspx");
          GlobalCC.RedirectPage("/g_qtrans.jspx");
          
        }else if (Rights.equalsIgnoreCase("Y")){  
           //GlobalCC.RedirectPage("/g_qtrans.jspx");
           GlobalCC.RedirectPage("/g_qtrans.jspx");
        }else{
            GlobalCC.INFORMATIONREPORTING("You do not have rights to access the Quotations Module");
            //GlobalCC.RedirectPage("/g_qtrans.jspx");
            GlobalCC.RedirectPage("/g_qtrans.jspx");
        }
    
    } catch (Exception e) {
      FacesContext.getCurrentInstance().addMessage(null, 
                                                   new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                                                                    e.getMessage(), 
                                                                    e.getMessage()));
    }
    return null;
  }
  
    public String goToQuotationEnquiry() 
    {
        
      try {
          String Rights = null;
          ReinitializeVar Reset = new ReinitializeVar();
          Reset.ReinitializeVar2();

          session.setAttribute("ProcessShtDesc", "QUOT");
          session.setAttribute("ProcessAreaShtDesc", "ACCS");
          session.setAttribute("ProcessSubAShtDesc", "ACCS");
          
          workflowProcessing wf = new workflowProcessing();
          Rights = wf.CheckUserRights();
          
          FindProcessDetails();

          session.setAttribute("TaskID", null);
          if(Rights==null){
            GlobalCC.RedirectPage("/g_quoteEnquiry.jspx");
          }else if (Rights.equalsIgnoreCase("Y")){  
            GlobalCC.RedirectPage("/g_quoteEnquiry.jspx");
          }else{
              String Message = "You do not have rights to access the Quotations Module";
              FacesContext.getCurrentInstance().addMessage(null, 
                                                           new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                            Message, 
                                                                            Message));
              GlobalCC.RedirectPage("/g_quoteEnquiry.jspx");
              return null;
          }
      
      } catch (Exception e) {
        FacesContext.getCurrentInstance().addMessage(null, 
                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                                                                      e.getMessage(), 
                                                                      e.getMessage()));
      }
      return null;
    }
    
  public String goToQuotationStatuses() 
  {
    try {
      ReinitializeVar Reset = new ReinitializeVar();
       Reset.ReinitializeVar2();

        session.setAttribute("TaskID", null);
      GlobalCC.RedirectPage("/quoteStatuses.jspx");
    } catch (Exception e) {
          GlobalCC.EXCEPTIONREPORTING(null,e);
    }
    return null;
  }
  
    public String goToLapsations() 
    {
      try {
        ReinitializeVar Reset = new ReinitializeVar();
         Reset.ReinitializeVar2();

          session.setAttribute("TaskID", null);
        GlobalCC.RedirectPage("/g_lapse.jspx");
      } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null,e);
      }
      return null;
    }
    
    public String goToContraTrans() 
    {
      try {
        ReinitializeVar Reset = new ReinitializeVar();
         Reset.ReinitializeVar2();

          session.setAttribute("TaskID", null);
        GlobalCC.RedirectPage("/g_contra.jspx");
      } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null,e);
      }
      return null;
    }
    
    public String goToReinstatement() 
    {
      try {
        ReinitializeVar Reset = new ReinitializeVar();
         Reset.ReinitializeVar2();

          session.setAttribute("TaskID", null);
        GlobalCC.RedirectPage("/g_reinst.jspx");
      } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null,e);
      }
      return null;
    }
    
    public String goToTickets() 
    {
      try {
        ReinitializeVar Reset = new ReinitializeVar();
         Reset.ReinitializeVar2();

          session.setAttribute("TaskID", null);
          session.setAttribute("UserSelected", session.getAttribute("Username"));
          //LOVCC.UserSelected = CurrentUser.Username;
        GlobalCC.RedirectPage("/ticketMngmt.jspx");
      } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null,e);
      }
      return null;
    }
    
  public String goToTicketManagement() 
  {
    try {
      ReinitializeVar Reset = new ReinitializeVar();
      Reset.ReinitializeVar2();
        
      GlobalCC.RedirectPage("/createTickets.jspx");
    } catch (Exception e) {
          GlobalCC.EXCEPTIONREPORTING(null,e);
    }
    return null;
  }
    
    public String goToNumberFormats() 
    {
      try {
        ReinitializeVar Reset = new ReinitializeVar();
         Reset.ReinitializeVar2();

          session.setAttribute("TaskID", null);
          session.setAttribute("SetupScrnID", 1);
          //LOVCC.UserSelected = CurrentUser.Username;
        GlobalCC.RedirectPage("/seqtemps.jspx");
      } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null,e);
      }
      return null;
    }
    public String goToCommRates() 
    {
      try {
        ReinitializeVar Reset = new ReinitializeVar();
         Reset.ReinitializeVar2();

          session.setAttribute("TaskID", null);
          session.setAttribute("SetupScrnID", 2);
          //LOVCC.UserSelected = CurrentUser.Username;
        GlobalCC.RedirectPage("/commRates.jspx");
      } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null,e);
      }
      return null;
    }
  public String goToOvrCommRates() 
  {
    try {
      ReinitializeVar Reset = new ReinitializeVar();
       Reset.ReinitializeVar2();

        session.setAttribute("TaskID", null);
        session.setAttribute("SetupScrnID", 2);
        //LOVCC.UserSelected = CurrentUser.Username;
      GlobalCC.RedirectPage("/overrideCommRates.jspx");
    } catch (Exception e) {
          GlobalCC.EXCEPTIONREPORTING(null,e);
    }
    return null;
  }
    
    public String goToPremiumMasks() 
    {
      try {
        ReinitializeVar Reset = new ReinitializeVar();
         Reset.ReinitializeVar2();

          session.setAttribute("TaskID", null);
          session.setAttribute("SetupScrnID", 3);
          //LOVCC.UserSelected = CurrentUser.Username;
        GlobalCC.RedirectPage("/premiumMasks.jspx");
      } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null,e);
      }
      return null;
    }
    public String goToParameters() 
    {
      try {
        ReinitializeVar Reset = new ReinitializeVar();
         Reset.ReinitializeVar2();

          session.setAttribute("TaskID", null);
          session.setAttribute("SetupScrnID", 4);
          //LOVCC.UserSelected = CurrentUser.Username;
        GlobalCC.RedirectPage("/parameters.jspx");
      } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null,e);
      }
      return null;
    }
    
    public String goToFCLFactors() 
    {
      try {
        ReinitializeVar Reset = new ReinitializeVar();
         Reset.ReinitializeVar2();

          session.setAttribute("TaskID", null);
          session.setAttribute("SetupScrnID", 5);
          //LOVCC.UserSelected = CurrentUser.Username;
        GlobalCC.RedirectPage("/fclFactors.jspx");
      } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null,e);
      }
      return null;
    }
    
    public String goToTransactionCodes() 
    {
      try {
        ReinitializeVar Reset = new ReinitializeVar();
         Reset.ReinitializeVar2();

          session.setAttribute("TaskID", null);
        GlobalCC.RedirectPage("/businessTransactions.jspx");
      } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null,e);
      }
      return null;
    }
    
    public String goToTaxTypes() 
    {
      try {
        ReinitializeVar Reset = new ReinitializeVar();
         Reset.ReinitializeVar2();

          session.setAttribute("TaskID", null);
          //LOVCC.UserSelected = CurrentUser.Username;
        GlobalCC.RedirectPage("/taxTypes.jspx");
      } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null,e);
      }
      return null;
    }
    
    public String goToTaxRatesByProduct() 
    {
      try {
        ReinitializeVar Reset = new ReinitializeVar();
         Reset.ReinitializeVar2();

          session.setAttribute("TaskID", null);
          session.setAttribute("SetupScrnID", 6);
        GlobalCC.RedirectPage("/taxRatesProduct.jspx");
      } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null,e);
      }
      return null;
    }
    
    public String goToMedicalTests() 
    {
      try {
        ReinitializeVar Reset = new ReinitializeVar();
         Reset.ReinitializeVar2();

          session.setAttribute("TaskID", null);
        GlobalCC.RedirectPage("/medTests.jspx");
      } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null,e);
      }
      return null;
    }
    
    public String goToPremiumRates() 
    {/*Value set to null so that the premium rates cursor returns only premium rates for policies below group minimum*/
        session.setAttribute("GroupRates",null);
      try {
        ReinitializeVar Reset = new ReinitializeVar();
         Reset.ReinitializeVar2();

          session.setAttribute("TaskID", null);
          session.setAttribute("SetupScrnID", 7);
        GlobalCC.RedirectPage("/premiumRates.jspx");
      } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null,e);
      }
      return null;
    }
    
    public String goToMedicalGroups() 
    {
      try {
        ReinitializeVar Reset = new ReinitializeVar();
         Reset.ReinitializeVar2();

          session.setAttribute("TaskID", null);
          session.setAttribute("SetupScrnID", 8);
        GlobalCC.RedirectPage("/medTestGrouping.jspx");
      } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null,e);
      }
      return null;
    }
    public String goToTreaties() 
    {
      try {
        ReinitializeVar Reset = new ReinitializeVar();
         Reset.ReinitializeVar2();

          session.setAttribute("TaskID", null);
          session.setAttribute("SetupScrnID", 9);
        GlobalCC.RedirectPage("/treatyTypes.jspx");
      } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null,e);
      }
      return null;
    }
    public String goToMedicalRequirements() 
    {
      try {
        ReinitializeVar Reset = new ReinitializeVar();
         Reset.ReinitializeVar2();

          session.setAttribute("TaskID", null);
          session.setAttribute("SetupScrnID", 10);
        GlobalCC.RedirectPage("/medRequirements.jspx");
      } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null,e);
      }
      return null;
    }
    public String goToRenewalMedicalRatings() 
    {
      try {
        ReinitializeVar Reset = new ReinitializeVar();
         Reset.ReinitializeVar2();

          session.setAttribute("TaskID", null);
          session.setAttribute("SetupScrnID", 11);
        GlobalCC.RedirectPage("/renMedRatings.jspx");
      } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null,e);
      }
      return null;
    }
    
    public String goToOccupations() 
    {
      try {
        ReinitializeVar Reset = new ReinitializeVar();
         Reset.ReinitializeVar2();

          session.setAttribute("TaskID", null);
          session.setAttribute("SetupScrnID", 12);
        GlobalCC.RedirectPage("/occupations.jspx");
      } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null,e);
      }
      return null;
    }
    
    public String goToRIRates() 
    {
      try {
        ReinitializeVar Reset = new ReinitializeVar();
         Reset.ReinitializeVar2();

          session.setAttribute("TaskID", null);
          session.setAttribute("SetupScrnID", 13);
          session.setAttribute("classSpecific", "N");
        GlobalCC.RedirectPage("/reintab.jspx");
      } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null,e);
      }
      return null;
    }
    public String goToRIRiderRates() 
    {
      try {
        ReinitializeVar Reset = new ReinitializeVar();
         Reset.ReinitializeVar2();

          session.setAttribute("TaskID", null);
          session.setAttribute("SetupScrnID", 14);
          session.setAttribute("classSpecific", "Y");
        GlobalCC.RedirectPage("/riRatesTable.jspx");
      } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null,e);
      }
      return null;
    }
    
    public String goToRIOSTables() 
    {
      try {
        ReinitializeVar Reset = new ReinitializeVar();
         Reset.ReinitializeVar2();

          session.setAttribute("TaskID", null);
          session.setAttribute("SetupScrnID", 15);
        GlobalCC.RedirectPage("/osReinBalances.jspx");
      } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null,e);
      }
      return null;
    }

  public void setLoadQuotation(RichCommandButton loadQuotation) {
    this.loadQuotation = loadQuotation;
  }

  public RichCommandButton getLoadQuotation() {
    return loadQuotation;
  }

  public String ConvertQuot() {
      String Rights = null;
    try {
      ReinitializeVar Reset = new ReinitializeVar();
      Reset.ReinitializeVariables();
        //LOVDAO.transType = "VQ";
        session.setAttribute("transType", "RQ");
        //LOVCC.CurrentStatus = "P";
        session.setAttribute("CurrentStatus", "P");
        //LOVCC.UWStart = "No";
        
        //LOVCC.ProcessShtDesc = "UWNB";
        //LOVCC.ProcessAreaShtDesc = "ACCS";
        //LOVCC.ProcessSubAShtDesc = "ACCS";
        session.setAttribute("UWStart", "No");
        session.setAttribute("ProcessShtDesc", "UWNB");
        session.setAttribute("ProcessAreaShtDesc", "ACCS");
        session.setAttribute("ProcessSubAShtDesc", "ACCS");
        
        workflowProcessing wf = new workflowProcessing();
        Rights = wf.CheckUserRights();
        
        FindProcessDetails();
        session.setAttribute("TaskID", null);
        if (Rights.equalsIgnoreCase("Y")){  
            GlobalCC.RedirectPage("/g_conpol.jspx");
        }else{
            String Message = "You do not have rights to access this Module";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            GlobalCC.RedirectPage("/g_conpol.jspx");
            return null;
        }
     
    } catch (Exception e) {
      FacesContext.getCurrentInstance().addMessage(null, 
                                                   new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                                                                    e.getMessage(), 
                                                                    e.getMessage()));
    }
    return null;
  }
  
  public String ShowPolicyTransactions(){
      try{
          GlobalCC.RedirectPage("/selectPolicyTrans.jspx");
      }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null, e);
      }
      return null;
  }
  
    public String ShowGeneralSetups(){
        try{
          //Get Access Group Rights for the User.
          session.setAttribute("ProcessShtDesc", "GLST");
          session.setAttribute("ProcessAreaShtDesc", "ACCS");
          session.setAttribute("ProcessSubAShtDesc", "STAG");
            
          workflowProcessing wf = new workflowProcessing();
          String AccessgRights = wf.CheckUserRights();
          if(AccessgRights==null){
              session.setAttribute("AccessGrpRights", "N");
          }else{
              session.setAttribute("AccessGrpRights", AccessgRights);
          }
            
            GlobalCC.RedirectPage("/GeneralSetups.jspx");
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }
    
    public String ShowProductionReports(){
        try{
            //GlobalCC.RedirectPage("/GroupReports.jspx");
            GlobalCC.RedirectPage("/systemReports.jspx");
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }
    public String ShowNaicomReports(){
      try{
          //GlobalCC.RedirectPage("/GroupReports.jspx");
          GlobalCC.RedirectPage("/g_naicom_rpt.jspx");
      }catch(Exception e){
          GlobalCC.EXCEPTIONREPORTING(null, e);
      }
      return null;
    }
    
  public String ShowUWReports(){
      try{
          //GlobalCC.RedirectPage("/GroupReports.jspx");
          GlobalCC.RedirectPage("/uwReports.jspx");
      }catch(Exception e){
          GlobalCC.EXCEPTIONREPORTING(null, e);
      }
      return null;
  }
  
  public String ShowClaimsReports(){
      try{
          //GlobalCC.RedirectPage("/GroupReports.jspx");
          GlobalCC.RedirectPage("/claimsReports.jspx");
      }catch(Exception e){
          GlobalCC.EXCEPTIONREPORTING(null, e);
      }
      return null;
  }

  public void setQuotationNo1(RichInputText quotationNo1) {
    this.quotationNo1 = quotationNo1;
  }

  public RichInputText getQuotationNo1() {
    return quotationNo1;
  }

  public void setQuotationDate(RichInputDate quotationDate) {
    this.quotationDate = quotationDate;
  }

  public RichInputDate getQuotationDate() {
    return quotationDate;
  }

  public void setQuotationNumber(RichInputText quotationNumber) {
    this.quotationNumber = quotationNumber;
  }

  public RichInputText getQuotationNumber() {
    return quotationNumber;
  }

  public void setProductDisplay(RichInputText productDisplay) {
    this.productDisplay = productDisplay;
}

  public RichInputText getProductDisplay() {
    return productDisplay;
  }

  public void setAssignProducts(RichCommandButton assignProducts) {
    this.assignProducts = assignProducts;
  }

  public RichCommandButton getAssignProducts() {
    return assignProducts;
  }
  public String goToUWTransactions() {
      try {
        ReinitializeVar Reset = new ReinitializeVar();
        Reset.ReinitializeVariables();
          session.setAttribute("TaskID", null);
          //LOVCC.CurrentStatus = "E";
          session.setAttribute("CurrentStatus", "E");
          session.setAttribute("Authorised", "N");
        GlobalCC.RedirectPage("/g_trans.jspx");
      } catch (Exception e) {
        FacesContext.getCurrentInstance().addMessage(null, 
                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                                                                      e.getMessage(), 
                                                                      e.getMessage()));
      }
      return null;
    }
  public String goToClaimsBooking() {
       try {
         ReinitializeVar Reset = new ReinitializeVar();
         Reset.ReinitializeVariables();
         workflowProcessing wf = new workflowProcessing();
           
        //Get Ex-Gratia Rights for the User.
        session.setAttribute("ProcessShtDesc", "CLMS");
        session.setAttribute("ProcessAreaShtDesc", "ACCS");
        session.setAttribute("ProcessSubAShtDesc", "XGCS");
        String ExgRights = wf.CheckUserRights();
        if(ExgRights==null){
            session.setAttribute("ExgRights", "N");
        }else{
            session.setAttribute("ExgRights", ExgRights);
        }

         session.setAttribute("ProcessShtDesc", "CLMS");
         session.setAttribute("ProcessAreaShtDesc", "ACCS");
         session.setAttribute("ProcessSubAShtDesc", "ACCS");
         FindProcessDetails();
        
        //start BPM Process...
        String Rights = null;
        
        wf.StartNewWorkflowInstance();
        Rights = wf.CheckUserRights();
        
        if(Rights.equalsIgnoreCase("Y")){
            session.setAttribute("EditClaim", 0);
            
            
            //session.setAttribute("TaskID", null);
            session.setAttribute("CurrentStatus", "C");
             GlobalCC.RedirectPage("/g_clmtra.jspx");     
        }else{
            String Message = "You do not have rights to access this Module";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            
        }    
      
       } catch (Exception e) {
         FacesContext.getCurrentInstance().addMessage(null, 
                                                      new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                                                                       e.getMessage(), 
                                                                       e.getMessage()));
       }
       return null;
     }
  public String goToMultipleClaimsBooking() {
       try {
         ReinitializeVar Reset = new ReinitializeVar();
         Reset.ReinitializeVariables();
         workflowProcessing wf = new workflowProcessing();
           
        //Get Ex-Gratia Rights for the User.
        session.setAttribute("ProcessShtDesc", "CLMS");
        session.setAttribute("ProcessAreaShtDesc", "ACCS");
        session.setAttribute("ProcessSubAShtDesc", "XGCS");
        String ExgRights = wf.CheckUserRights();
        if(ExgRights==null){
            session.setAttribute("ExgRights", "N");
        }else{
            session.setAttribute("ExgRights", ExgRights);
        }

         session.setAttribute("ProcessShtDesc", "CLMS");
         session.setAttribute("ProcessAreaShtDesc", "ACCS");
         session.setAttribute("ProcessSubAShtDesc", "ACCS");
         FindProcessDetails();
        
        //start BPM Process...
        String Rights = null;
        
        wf.StartNewWorkflowInstance();
        Rights = wf.CheckUserRights();
        
        if(Rights.equalsIgnoreCase("Y")){
            session.setAttribute("EditClaim", 0);
            
            
            //session.setAttribute("TaskID", null);
            session.setAttribute("CurrentStatus", "C");
             GlobalCC.RedirectPage("/g_multiclmtra.jspx");     
        }else{
            String Message = "You do not have rights to access this Module";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            
        }    
      
       } catch (Exception e) {
         FacesContext.getCurrentInstance().addMessage(null, 
                                                      new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                                                                       e.getMessage(), 
                                                                       e.getMessage()));
       }
       return null;
     }
   public String goToClaimsEnquiry() {
       try {
         ReinitializeVar Reset = new ReinitializeVar();
         Reset.ReinitializeVariables();
         //LOVCC.EditClaim = 1;
         session.setAttribute("EditClaim", 1);
         session.setAttribute("TaskID", null);
         session.setAttribute("claimStatus", "N");
         GlobalCC.RedirectPage("/g_edtclm.jspx");
       } catch (Exception e) {
         FacesContext.getCurrentInstance().addMessage(null, 
                                                      new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                                                                       e.getMessage(), 
                                                                       e.getMessage()));
       }
       return null;
     }
   
  public String goToClaimsEnquiryII() {
      try {
        ReinitializeVar Reset = new ReinitializeVar();
        Reset.ReinitializeVariables();
        //LOVCC.EditClaim = 1;
        session.setAttribute("EditClaim", 1);
        session.setAttribute("TaskID", null);
        session.setAttribute("claimStatus", "Y");
        GlobalCC.RedirectPage("/g_edtclm.jspx");
      } catch (Exception e) {
        FacesContext.getCurrentInstance().addMessage(null, 
                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                                                                      e.getMessage(), 
                                                                      e.getMessage()));
      }
      return null;
    }


  public String AssignProds() {
    DCIteratorBinding dciter = ADFUtils.findIterator("prodIterator");
    RowKeySet set =productsDisplayLOV.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();
    
    //System.out.println(1);
    while (rowKeySetIter.hasNext()) 
    {
        List l = (List) rowKeySetIter.next();
        Key key = (Key)l.get(0);
        dciter.setCurrentRowWithKey(key.toStringFormat(true));
        Row r = dciter.getCurrentRow();
       productDisplay.setValue(r.getAttribute("prodDesc"));
       //LOVCC.ProductCode = (BigDecimal)r.getAttribute("prodCode");
        session.setAttribute("ProductCode", r.getAttribute("prodCode"));
        //Quotation.prodCode=Integer.parseInt(new String(""+(BigDecimal)r.getAttribute("prodCode")));
     
        session.setAttribute("productType", r.getAttribute("prodDesc"));
      
    }
    
    return null;
  }

  public void setProductsDisplayLOV(RichTable productsDisplayLOV) {
    this.productsDisplayLOV = productsDisplayLOV;
  }

  public RichTable getProductsDisplayLOV() {
    return productsDisplayLOV;
  }

  public String NewBusiness() {
    try {
      ReinitializeVar Reset = new ReinitializeVar();
      Reset.ReinitializeVar2();
        //underwritingPolicy.PageRender = 0;
        session.setAttribute("uwPageRender", 0);
      //LOVCC.templateTranSeq = 0;
        session.setAttribute("templateTranSeq", 0);
      //LOVCC.CurrentStatus = "P";
      session.setAttribute("CurrentStatus", "P");
      session.setAttribute("Authorised", "N");
        
        //LOVCC.ProcessShtDesc = "UWNB";
        //LOVCC.ProcessAreaShtDesc = "ACCS";
        //LOVCC.ProcessSubAShtDesc = "ACCS";
        //LOVCC.UWStart = "Yes";
        session.setAttribute("UWStart", "Yes");
        session.setAttribute("ProcessShtDesc", "UWNB");
        session.setAttribute("ProcessAreaShtDesc", "ACCS");
        session.setAttribute("ProcessSubAShtDesc", "ACCS");
        
        String Rights = null;
        workflowProcessing wf = new workflowProcessing();
        Rights = wf.CheckUserRights();
        
        FindProcessDetails();
        session.setAttribute("TaskID", null);
        if (Rights.equalsIgnoreCase("Y")){  
            GlobalCC.RedirectPage("/undwrtone.jspx");
        }else{
            String Message = "You do not have rights to access this Module";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            GlobalCC.RedirectPage("/undwrtone.jspx");
            return null;
        }
        
      
    } catch (Exception e) {
      FacesContext.getCurrentInstance().addMessage(null, 
                                                   new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                                                                    e.getMessage(), 
                                                                    e.getMessage()));
    }
    return null;
  }

  public String ShowPremiumCard() {
    try {
      ReinitializeVar Reset = new ReinitializeVar();
      Reset.ReinitializeVariables();
      session.setAttribute("TaskID", null);
      GlobalCC.RedirectPage("/recptrns.jspx");
    } catch (Exception e) {
      FacesContext.getCurrentInstance().addMessage(null, 
                                                   new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                                                                    e.getMessage(), 
                                                                    e.getMessage()));
    }
    return null;
  }
  
    public String FindProcessDetails() {
        DBConnector myConn=new DBConnector();
       Connection conn=myConn.getDatabaseConn();
       CallableStatement cst=null;
    
       
      
       try {
         String polQuery="begin TQC_WEB_PKG.get_process_dtls(?,?,?);end;";
         cst=conn.prepareCall(polQuery);
         cst.setInt(1, 27);
         cst.setString(2, (String)session.getAttribute("ProcessShtDesc"));
         cst.registerOutParameter(3,OracleTypes.CURSOR);
        
         cst.execute();
         ResultSet rst=(ResultSet)cst.getObject(3);
         while(rst.next()){
           //LOVCC.ProcessBPMDef = rst.getString(4);
             session.setAttribute("ProcessBPMDef", rst.getString(4));
         }
         rst.close();
         cst.close();
           conn.close();
         
       }
       catch(Exception e) {
         GlobalCC.EXCEPTIONREPORTING(conn, e);
       }
       return null;
     }

    public void setClientLink(RichCommandLink clientLink) {
        this.clientLink = clientLink;
    }

    public RichCommandLink getClientLink() {
        return clientLink;
    }
    public String RenderClient(){
        clientLink.setRendered(true);
        return null;
    }
    public String RenderHome(){
        try{
        clientLink.setRendered(false);
        GlobalCC.RedirectPage("/testHome.jspx");
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }
    
    public String RenderMenu(Integer Position){
        try{
            switch(Position){
            case 1:
                //quotesDefinition.setRendered(false);
                //quotesEnq.setRendered(false);
                quotationLinks.setRendered(false);
                policiesLinks.setRendered(false);
                subpolicies.setRendered(false);
                subMedicals.setRendered(false);
                claimsLinks.setRendered(false);
                accountingLinks.setRendered(false);
                setupsLinks.setRendered(false);
                ticketLinks.setRendered(false);
            case 2:
                //quotesDefinition.setRendered(true);
                //quotesEnq.setRendered(true);
                quotationLinks.setRendered(true);
                policiesLinks.setRendered(false);
                subpolicies.setRendered(false);
                subMedicals.setRendered(false);
                claimsLinks.setRendered(false);
                accountingLinks.setRendered(false);
                setupsLinks.setRendered(false);
                ticketLinks.setRendered(false);
                 break;
            case 3:
                policiesLinks.setRendered(true);
                quotationLinks.setRendered(false);
                subpolicies.setRendered(false);
                subMedicals.setRendered(false);
                claimsLinks.setRendered(false);
                accountingLinks.setRendered(false);
                setupsLinks.setRendered(false);
                ticketLinks.setRendered(false);
                break;
            case 4:
                    policiesLinks.setRendered(false);
                    quotationLinks.setRendered(false);
                    subpolicies.setRendered(false);
                    subMedicals.setRendered(false);
                    claimsLinks.setRendered(true);
                    accountingLinks.setRendered(false);
                    setupsLinks.setRendered(false);
                ticketLinks.setRendered(false);
                    break;
                case 5:
                        policiesLinks.setRendered(false);
                        quotationLinks.setRendered(false);
                        subpolicies.setRendered(false);
                        subMedicals.setRendered(false);
                        claimsLinks.setRendered(false);
                        accountingLinks.setRendered(true);
                        setupsLinks.setRendered(false);
                ticketLinks.setRendered(false);
                        break;
                case 6:
                        policiesLinks.setRendered(false);
                        quotationLinks.setRendered(false);
                        subpolicies.setRendered(false);
                        subMedicals.setRendered(false);
                        claimsLinks.setRendered(false);
                        accountingLinks.setRendered(false);
                        setupsLinks.setRendered(true);
                      ticketLinks.setRendered(false);
                        break;
                case 7:
                        policiesLinks.setRendered(false);
                        quotationLinks.setRendered(false);
                        subpolicies.setRendered(false);
                        subMedicals.setRendered(false);
                        claimsLinks.setRendered(false);
                        accountingLinks.setRendered(false);
                        setupsLinks.setRendered(false);
                        ticketLinks.setRendered(true);
                        break;
            }
            
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }
    
    public String QuoteMainSel(){
        try{
         Integer Position = 2;
         RenderMenu(Position); 
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }
    public String PoliciesMainSel(){
        try{
         Integer Position = 3;
         RenderMenu(Position); 
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }
    
    public String ClaimsMainSel(){
        try{
         Integer Position = 4;
         RenderMenu(Position); 
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }
    
    public String AccMainSel(){
        try{
         Integer Position = 5;
         RenderMenu(Position); 
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }
    
    public String SetupsMainSel(){
        try{
         Integer Position = 6;
         RenderMenu(Position); 
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }
    
    public String TicketsMainSel(){
        try{
         Integer Position = 7;
         RenderMenu(Position); 
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }
    
    public String PoliciesSubMenuSel(){
        try{
            subpolicies.setRendered(true);
           
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }
    public String MedicalsSubMenuSel(){
        try{
            subMedicals.setRendered(true);
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }

    public void setQuotesMain(RichCommandImageLink quotesMain) {
        this.quotesMain = quotesMain;
    }

    public RichCommandImageLink getQuotesMain() {
        return quotesMain;
    }

    public void setQuotesDefinition(RichCommandLink quotesDefinition) {
        this.quotesDefinition = quotesDefinition;
    }

    public RichCommandLink getQuotesDefinition() {
        return quotesDefinition;
    }

    public void setQuotesEnq(RichCommandLink quotesEnq) {
        this.quotesEnq = quotesEnq;
    }

    public RichCommandLink getQuotesEnq() {
        return quotesEnq;
    }

    public void setConvQuote(RichCommandLink convQuote) {
        this.convQuote = convQuote;
    }

    public RichCommandLink getConvQuote() {
        return convQuote;
    }

    public void setPolicies(RichCommandLink policies) {
        this.policies = policies;
    }

    public RichCommandLink getPolicies() {
        return policies;
    }

    public void setSubpolicies(HtmlPanelGrid subpolicies) {
        this.subpolicies = subpolicies;
    }

    public HtmlPanelGrid getSubpolicies() {
        return subpolicies;
    }

    public void setQuotationLinks(HtmlPanelGrid quotationLinks) {
        this.quotationLinks = quotationLinks;
    }

    public HtmlPanelGrid getQuotationLinks() {
        return quotationLinks;
    }

    public void setPoliciesLinks(HtmlPanelGrid policiesLinks) {
        this.policiesLinks = policiesLinks;
    }

    public HtmlPanelGrid getPoliciesLinks() {
        return policiesLinks;
    }

    public void setSubMedicals(HtmlPanelGrid subMedicals) {
        this.subMedicals = subMedicals;
    }

    public HtmlPanelGrid getSubMedicals() {
        return subMedicals;
    }

    public void setClaimsLinks(HtmlPanelGrid claimsLinks) {
        this.claimsLinks = claimsLinks;
    }

    public HtmlPanelGrid getClaimsLinks() {
        return claimsLinks;
    }

    public void setTicketLinks(HtmlPanelGrid ticketLinks) {
        this.ticketLinks = ticketLinks;
    }

    public HtmlPanelGrid getTicketLinks() {
        return ticketLinks;
    }

    public void setSetupsLinks(HtmlPanelGrid setupsLinks) {
        this.setupsLinks = setupsLinks;
    }

    public HtmlPanelGrid getSetupsLinks() {
        return setupsLinks;
    }

    public void setAccountingLinks(HtmlPanelGrid accountingLinks) {
        this.accountingLinks = accountingLinks;
    }

    public HtmlPanelGrid getAccountingLinks() {
        return accountingLinks;
    }

    public String goToClientCriterion() {
        try {
          ReinitializeVar Reset = new ReinitializeVar();
           Reset.ReinitializeVar2();

            session.setAttribute("TaskID", null);
            session.setAttribute("SetupScrnID", 16);
          GlobalCC.RedirectPage("/intermedgrp.jspx");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }

    public String goToClientAgentGrouping() {
        try {
          ReinitializeVar Reset = new ReinitializeVar();
           Reset.ReinitializeVar2();

            session.setAttribute("TaskID", null);
            session.setAttribute("SetupScrnID", 16);
          GlobalCC.RedirectPage("/clagngrp.jspx");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
       
        return null;
    }

    public String CoverTypes() {
        try {
          ReinitializeVar Reset = new ReinitializeVar();
           Reset.ReinitializeVar2();

            session.setAttribute("TaskID", null);
            session.setAttribute("SetupScrnID", 17);
          GlobalCC.RedirectPage("/covertyp.jspx");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }

    public String ProdCoverTypes() {
        try {
          ReinitializeVar Reset = new ReinitializeVar();
           Reset.ReinitializeVar2();

            session.setAttribute("TaskID", null);
            session.setAttribute("SetupScrnID", 18);
          GlobalCC.RedirectPage("/prod_cvt.jspx");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
       
        return null;
    }

    public String ProductsAndClasses() {
        try {
          ReinitializeVar Reset = new ReinitializeVar();
           Reset.ReinitializeVar2();

            session.setAttribute("TaskID", null);
            session.setAttribute("SetupScrnID", 18);
          GlobalCC.RedirectPage("/g_class.jspx");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }

    public String goToTreatySetups() {
        try {
          ReinitializeVar Reset = new ReinitializeVar();
           Reset.ReinitializeVar2();

            session.setAttribute("TaskID", null);
            session.setAttribute("SetupScrnID", 19);
          GlobalCC.RedirectPage("/tretstp.jspx");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }

    public String gotToAgents() {
        try {
          ReinitializeVar Reset = new ReinitializeVar();
           Reset.ReinitializeVar2();

            session.setAttribute("TaskID", null);
            session.setAttribute("SetupScrnID", 20);
          GlobalCC.RedirectPage("/agency.jspx");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }

    public String goToAnnuityFactors() {
        try {
          ReinitializeVar Reset = new ReinitializeVar();
           Reset.ReinitializeVar2();

            session.setAttribute("TaskID", null);
            session.setAttribute("SetupScrnID", 21);
          GlobalCC.RedirectPage("/annufact.jspx");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }

    public String goToAnnuityRatesByType() {
        try {
          ReinitializeVar Reset = new ReinitializeVar();
           Reset.ReinitializeVar2();

            session.setAttribute("TaskID", null);
            session.setAttribute("SetupScrnID", 22);
          GlobalCC.RedirectPage("/annrttyp.jspx");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }

    public String ProdCoverDependants() {
        try {
          ReinitializeVar Reset = new ReinitializeVar();
           Reset.ReinitializeVar2();

            session.setAttribute("TaskID", null);
            session.setAttribute("SetupScrnID", 23);
          GlobalCC.RedirectPage("/prod_ret.jspx");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }

    public String goToDependentTypes() {
        try {
          ReinitializeVar Reset = new ReinitializeVar();
           Reset.ReinitializeVar2();

            session.setAttribute("TaskID", null);
            session.setAttribute("SetupScrnID", 24);
          GlobalCC.RedirectPage("/def_type.jspx");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }

    public String gotoInterestRates() {
        try {
          ReinitializeVar Reset = new ReinitializeVar();
           Reset.ReinitializeVar2();

            session.setAttribute("TaskID", null);
            session.setAttribute("SetupScrnID", 25);
          GlobalCC.RedirectPage("/intrates.jspx");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }

    public String goToPensionFactors() {
        try {
          ReinitializeVar Reset = new ReinitializeVar();
           Reset.ReinitializeVar2();

            session.setAttribute("TaskID", null);
            session.setAttribute("SetupScrnID", 25);
          GlobalCC.RedirectPage("/pencfac.jspx");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }
    
  public String goToPremLoadings() {
      try {
        ReinitializeVar Reset = new ReinitializeVar();
         Reset.ReinitializeVar2();

          session.setAttribute("TaskID", null);
          session.setAttribute("SetupScrnID", 25);
        GlobalCC.RedirectPage("/prod_cvt_loadings.jspx");
      } catch (Exception e) {
          GlobalCC.EXCEPTIONREPORTING(null,e);
      }
      return null;
  }
  
  public String goToGroupSubDivisions() {
      try {
        ReinitializeVar Reset = new ReinitializeVar();
         Reset.ReinitializeVar2();

        GlobalCC.RedirectPage("/GroupSubdivisions.jspx");
      } catch (Exception e) {
          GlobalCC.EXCEPTIONREPORTING(null,e);
      }
      return null;
  }

    public String goReinsuranceReports() {
        try {
          ReinitializeVar Reset = new ReinitializeVar();
           Reset.ReinitializeVar2();

            session.setAttribute("TaskID", null);
            session.setAttribute("SetupScrnID", 26);
          GlobalCC.RedirectPage("/ri_reports.jspx");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }

    public String riMemberReports() {
        try {
          ReinitializeVar Reset = new ReinitializeVar();
           Reset.ReinitializeVar2();

            session.setAttribute("TaskID", null);
            session.setAttribute("SetupScrnID", 26);
          GlobalCC.RedirectPage("/ri_memrpt.jspx");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }

    public String goToProductionReports() {
        try {
          ReinitializeVar Reset = new ReinitializeVar();
           Reset.ReinitializeVar2();

            session.setAttribute("TaskID", null);
            session.setAttribute("SetupScrnID", 27);
          GlobalCC.RedirectPage("/pol_prdnrpt.jspx");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }

    public String goToProductTransactions() {
        try {
          ReinitializeVar Reset = new ReinitializeVar();
           Reset.ReinitializeVar2();

            session.setAttribute("TaskID", null);
            session.setAttribute("SetupScrnID", 28);
          GlobalCC.RedirectPage("/prod_trn.jspx");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }
    
  public String goToTransactionsTypes() {
      try {
        ReinitializeVar Reset = new ReinitializeVar();
         Reset.ReinitializeVar2();

          session.setAttribute("TaskID", null);
        GlobalCC.RedirectPage("/transTypes.jspx");
      } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null,e);
      }
      return null;
  }

    public String goToCausationsCauses() {
        try {
          ReinitializeVar Reset = new ReinitializeVar();
           Reset.ReinitializeVar2();

            session.setAttribute("TaskID", null);
            session.setAttribute("SetupScrnID", 28);
          GlobalCC.RedirectPage("/cvt_caus.jspx");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }

    public String goToClaimsGroupLife() {
        try {
          ReinitializeVar Reset = new ReinitializeVar();
           Reset.ReinitializeVar2();

            session.setAttribute("TaskID", null);
            session.setAttribute("SetupScrnID", 29);
          GlobalCC.RedirectPage("/prodcaus.jspx");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }

    public String goToPolicyDocuments() {
        try {
          ReinitializeVar Reset = new ReinitializeVar();
           Reset.ReinitializeVar2();

            session.setAttribute("TaskID", null);
            session.setAttribute("SetupScrnID", 30);
          GlobalCC.RedirectPage("/pol_docs.jspx");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }
    
  public String goToEducationClasses() {
      try {
        ReinitializeVar Reset = new ReinitializeVar();
         Reset.ReinitializeVar2();

          session.setAttribute("TaskID", null);
        GlobalCC.RedirectPage("/educRates.jspx");
      } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null,e);
      }
      return null;
  }

    public String goToNarratives() {
        try {
          ReinitializeVar Reset = new ReinitializeVar();
           Reset.ReinitializeVar2();

            session.setAttribute("TaskID", null);
            session.setAttribute("SetupScrnID", 31);
          GlobalCC.RedirectPage("/bdrcrnar.jspx");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }

    public String goToPremRatesAboveMin() {
        /*Value set to G so that the premium rates cursor returns only premium rates for policies above group minimum*/
        session.setAttribute("GroupRates","G");
        try {
          ReinitializeVar Reset = new ReinitializeVar();
           Reset.ReinitializeVar2();

            session.setAttribute("TaskID", null);
            session.setAttribute("SetupScrnID", 7);
          GlobalCC.RedirectPage("/premiumRates_g.jspx");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }

    public String goToBusinessGenerated() {
        try {
          ReinitializeVar Reset = new ReinitializeVar();
           Reset.ReinitializeVar2();

            session.setAttribute("TaskID", null);
            session.setAttribute("SetupScrnID", 32);
          GlobalCC.RedirectPage("/productionReports.jspx");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }

    public String gotToProductionReport() {
        try {
          ReinitializeVar Reset = new ReinitializeVar();
           Reset.ReinitializeVar2();

            session.setAttribute("TaskID", null);
            session.setAttribute("SetupScrnID", 33);
          GlobalCC.RedirectPage("/groupProduction.jspx");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }

    public String goToGroupProduction() {
        try {
          ReinitializeVar Reset = new ReinitializeVar();
           Reset.ReinitializeVar2();

            session.setAttribute("TaskID", null);
            session.setAttribute("SetupScrnID", 33);
          GlobalCC.RedirectPage("/groupProduction.jspx");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }

    public String goToPeriods() {
        try {
          ReinitializeVar Reset = new ReinitializeVar();
           Reset.ReinitializeVar2();

            session.setAttribute("TaskID", null);
            session.setAttribute("SetupScrnID", 35);
          GlobalCC.RedirectPage("/periods.jspx");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }
    
  public String goToProductImportTemplates() {
      try {
        ReinitializeVar Reset = new ReinitializeVar();
        Reset.ReinitializeVar2();

        GlobalCC.RedirectPage("/ProductImportTmplts.jspx");
      } catch (Exception e) {
          GlobalCC.EXCEPTIONREPORTING(null,e);
      }
      return null;
  }
  public String goToEmailSettingPage(){
    try {
      ReinitializeVar Reset = new ReinitializeVar();
      Reset.ReinitializeVar2();

      GlobalCC.RedirectPage("/report_email.jspx");
    } catch (Exception e) {
        GlobalCC.EXCEPTIONREPORTING(null,e);
    }
    return null;
  }
    
    public String goToProductProvisions() {
        try {
          ReinitializeVar Reset = new ReinitializeVar();
           Reset.ReinitializeVar2();

            session.setAttribute("TaskID", null);
          GlobalCC.RedirectPage("/productProvisions.jspx");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }
    
  public String goToAccessGroups() {
      try {
        ReinitializeVar Reset = new ReinitializeVar();
         Reset.ReinitializeVar2();
         
        GlobalCC.RedirectPage("/AccessGroups.jspx");
      } catch (Exception e) {
          GlobalCC.EXCEPTIONREPORTING(null,e);
      }
      return null;
  }
    
    public String QuotationsPanelRendered() {
        try {
            quotePanel.setRendered(true);
            uwPanel.setRendered(false);
            claimsPanel.setRendered(false);
            accountingPanel.setRendered(false);
            ticketsPanel.setRendered(false);
            setupsPanel.setRendered(false);
            reportingPanel.setRendered(false);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String UWPanelRendered() {
        try {
            quotePanel.setRendered(false);
            uwPanel.setRendered(true);
            claimsPanel.setRendered(false);
            accountingPanel.setRendered(false);
            ticketsPanel.setRendered(false);
            setupsPanel.setRendered(false);
            reportingPanel.setRendered(false);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String ClaimsPanelRendered() {
        try {
            quotePanel.setRendered(false);
            uwPanel.setRendered(false);
            claimsPanel.setRendered(true);
            accountingPanel.setRendered(false);
            ticketsPanel.setRendered(false);
            setupsPanel.setRendered(false);
            reportingPanel.setRendered(false);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }
    
    public String AccountingPanelRendered() {
        try {
            quotePanel.setRendered(false);
            uwPanel.setRendered(false);
            claimsPanel.setRendered(false);
            accountingPanel.setRendered(true);
            ticketsPanel.setRendered(false);
            setupsPanel.setRendered(false);
            reportingPanel.setRendered(false);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }
    
    public String TicketPanelRendered() {
        try {
            quotePanel.setRendered(false);
            uwPanel.setRendered(false);
            claimsPanel.setRendered(false);
            accountingPanel.setRendered(false);
            ticketsPanel.setRendered(true);
            setupsPanel.setRendered(false);
            reportingPanel.setRendered(false);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }
    
  public String ReportsPanelRendered() {
      try {
          quotePanel.setRendered(false);
          uwPanel.setRendered(false);
          claimsPanel.setRendered(false);
          accountingPanel.setRendered(false);
          ticketsPanel.setRendered(false);
          setupsPanel.setRendered(false);
          reportingPanel.setRendered(true);
      } catch (Exception e) {
          GlobalCC.EXCEPTIONREPORTING(null, e);
      }
      return null;
  }
  public String memBalEnquiry() {
     try {
       ReinitializeVar Reset = new ReinitializeVar();
       Reset.ReinitializeVariables();
       this.session.setAttribute("TaskID", null);
       this.session.setAttribute("productCode", null);
       this.session.setAttribute("policyCode", null);
       this.session.setAttribute("PolmCode", null);
       GlobalCC.RedirectPage("/memcvr.jspx");
     } catch (Exception e) {
       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage()));
     }

     return null;
   }
  public String goToClaimsAuthorisation() {
      try {
        ReinitializeVar Reset = new ReinitializeVar();
        Reset.ReinitializeVariables();
        this.session.setAttribute("TaskID", null);
        this.session.setAttribute("productCode", null);
        GlobalCC.RedirectPage("/g_autclm.jspx");
      } catch (Exception e) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage()));
      }

      return null;
    }
  public String EmassValuation() {
      try {       
        GlobalCC.RedirectPage("/emassValuation.jspx");
      } catch (Exception e) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage()));
      }

      return null;
    }

    public void setQuotePanel(RichPanelBox quotePanel) {
        this.quotePanel = quotePanel;
    }

    public RichPanelBox getQuotePanel() {
        return quotePanel;
    }

    public void setUwPanel(RichPanelBox uwPanel) {
        this.uwPanel = uwPanel;
    }

    public RichPanelBox getUwPanel() {
        return uwPanel;
    }

    public void setClaimsPanel(RichPanelBox claimsPanel) {
        this.claimsPanel = claimsPanel;
    }

    public RichPanelBox getClaimsPanel() {
        return claimsPanel;
    }

    public void setAccountingPanel(RichPanelBox accountingPanel) {
        this.accountingPanel = accountingPanel;
    }

    public RichPanelBox getAccountingPanel() {
        return accountingPanel;
    }

    public void setTicketsPanel(RichPanelBox ticketsPanel) {
        this.ticketsPanel = ticketsPanel;
    }

    public RichPanelBox getTicketsPanel() {
        return ticketsPanel;
    }

    public void setSetupsPanel(RichPanelBox setupsPanel) {
        this.setupsPanel = setupsPanel;
    }

    public RichPanelBox getSetupsPanel() {
        return setupsPanel;
    }

    public void setReportingPanel(RichPanelBox reportingPanel) {
        this.reportingPanel = reportingPanel;
    }

    public RichPanelBox getReportingPanel() {
        return reportingPanel;
    }

    public String goToLoadClients() {
        // Add event code here...
        GlobalCC.RedirectPage("/enmassclientloading.jspx");
        return null;
    }

    public String goToEnmassPolLoading() {
        GlobalCC.RedirectPage("/enmassloading.jspx");
        return null;
    }

    public String showCoreReports() {
        // Add event code here...
        try{
            //GlobalCC.RedirectPage("/GroupReports.jspx");
            GlobalCC.RedirectPage("/coresysReports.jspx");
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String showReinsuranceReports() {
        // Add event code here...
        try{
            //GlobalCC.RedirectPage("/GroupReports.jspx");
            GlobalCC.RedirectPage("/reinsuranceReports.jspx");
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }
    
  public String showManagementReports() {
      // Add event code here...
      try{
          //GlobalCC.RedirectPage("/GroupReports.jspx");
          GlobalCC.RedirectPage("/production.jspx");
      }catch(Exception e){
          GlobalCC.EXCEPTIONREPORTING(null, e);
      }
      return null;
  }

    public String getToBudgetPage() {
        // Add event code here...
      try{
          //GlobalCC.RedirectPage("/GroupReports.jspx");
          ReinitializeVar Reset = new ReinitializeVar();
          Reset.ReinitializeVariables();
          GlobalCC.RedirectPage("/prod_budget.jspx");
      }catch(Exception e){
          GlobalCC.EXCEPTIONREPORTING(null, e);
      }
        return null;
    }
  public String getToChequeTracking() {
      // Add event code here...
    try{
        //GlobalCC.RedirectPage("/GroupReports.jspx");
        ReinitializeVar Reset = new ReinitializeVar();
        Reset.ReinitializeVariables();
        GlobalCC.RedirectPage("/chqTracking.jspx");
    }catch(Exception e){
        GlobalCC.EXCEPTIONREPORTING(null, e);
    }
      return null;
  }
  public String goToPortfolioPocessing() {
      // Add event code here...
      try {
        ReinitializeVar Reset = new ReinitializeVar();
        Reset.ReinitializeVariables();
        this.session.setAttribute("TaskID", null);
        this.session.setAttribute("productCode", null);
        GlobalCC.RedirectPage("/recoveryTrans.jspx");
      } catch (Exception e) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage()));
      }
      return null;
  }
  
  public String goToUprPocessing() {
      // Add event code here...
      try {
        ReinitializeVar Reset = new ReinitializeVar();
        Reset.ReinitializeVariables();
        this.session.setAttribute("TaskID", null);
        this.session.setAttribute("productCode", null);
        GlobalCC.RedirectPage("/postUpr.jspx");
      } catch (Exception e) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage()));
      }
      return null;
  }


    public String goToPensionsReport() {
        // Add event code here...
        try {
          ReinitializeVar Reset = new ReinitializeVar();
          Reset.ReinitializeVariables();
          this.session.setAttribute("TaskID", null);
          this.session.setAttribute("productCode", null);
          GlobalCC.RedirectPage("/pensionreports.jspx");
        } catch (Exception e) {
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage()));
        }
        return null;
    }
  public String goToClaimOpening() {
      try {
        ReinitializeVar Reset = new ReinitializeVar();
        Reset.ReinitializeVariables();
          session.setAttribute("TaskID", null);
        GlobalCC.RedirectPage("/clmBookingTransactions.jspx");
      } catch (Exception e) {
        FacesContext.getCurrentInstance().addMessage(null, 
                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                                                                      e.getMessage(), 
                                                                      e.getMessage()));
      }
      return null;
    }
}
