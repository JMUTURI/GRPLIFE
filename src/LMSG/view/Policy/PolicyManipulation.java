package LMSG.view.Policy;

import LMSG.view.BPM.workflowProcessing;
import LMSG.view.Base.ADFUtils;
import LMSG.view.Base.GlobalCC;
import LMSG.view.Base.LOVCC;
import LMSG.view.Correspondents.CorrespondenceManipulation;
import LMSG.view.Navigation.Links;
import LMSG.view.connect.DBConnector;
import com.turnkey.interfaces.ClientInterfaces;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpSession;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputNumberSpinbox;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanCheckbox;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanRadio;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.input.RichSelectOneRadio;
import oracle.adf.view.rich.component.rich.layout.RichPanelBox;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.output.RichOutputLabel;
import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.component.rich.output.RichSpacer;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.uicli.binding.JUCtrlValueBinding;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleResultSet;
import org.apache.myfaces.trinidad.model.RowKeySet;
import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

public class PolicyManipulation
  extends LOVCC
{
  private RichInputText cleintDisplay;
  private RichTable polClientsLOV;
  private RichInputText branchDisplay;
  private RichTable polBranchesLOV;
  private RichSelectOneChoice polPayFreq;
  private RichOutputText proposerDisplay;
  private RichSelectOneChoice polPensionCategory;
  private RichSelectOneChoice osLoanCalculation;
  private RichOutputText occupationDisplay;
  private RichOutputText hazardDisplay;
  private RichTable premiumMaskLOV;
  private RichTable checkOffAgentsLOV;
  private RichSelectOneChoice endrPayMethod;
  private RichInputText checkOffAgentDisplay;
  private RichInputText endrMaskDisplay;
  private RichTable policyCoversLOV;
  private RichOutputText endrTotSA;
  private RichOutputText endrTotPremium;
  private RichInputText endrCommRate;
  private RichInputText endrInstPremium;
  private RichInputText endrCommAmt;
  private RichTable productsLOV;
  private RichInputText productDisplay;
  private RichTable productCoverTypesLOV;
  private RichInputText coverDescDisplay;
  private RichInputText overridePremDisplay;
  private RichInputText sumAssuredDisplay;
  private RichSelectOneChoice loadingTypeSelect;
  private RichInputText discLoadRateDisplay;
  private RichOutputText edCoverlabel;
  private RichInputText edcoverButChargePremium;
  private RichSelectOneChoice eddiscLoadChoice;
  private RichInputText eddiscLoadRateDisplay;
  private RichInputText endrTotalSA;
  private RichInputText endrTotPremium2;
  private RichInputText avANB;
  private RichOutputLabel avANBLabel;
  private RichOutputLabel saLabel;
  private RichSelectOneChoice calcType;
  private RichSelectOneChoice durationType;
  private RichSelectOneChoice payFreq;
  private RichTable usersLOV;
  private RichSelectOneChoice unitRateOption;
  private RichSelectOneChoice earnPrdType;
  private RichInputNumberSpinbox VAT;
  private RichTable policyMembersLOV;
  private RichSelectBooleanRadio deleteSelected;
  private RichSelectBooleanRadio deleteSchedule;
  private RichInputText newCat;
  private RichInputText newCatPeriod;
  private RichInputText newCatID;
  private RichInputText newCatDesc;
  private RichInputText newEarningAmt;
  private RichInputText newEarningsPeriod;
  private RichTable policyCategoriesforChange;
  private HtmlPanelGrid newCategoryPanel;
  private RichOutputLabel newCatIDLabel;
  private RichOutputLabel newCatPeriodLabel;
  private RichOutputLabel newCategoryLabel;
  private RichSelectOneRadio categoryOptions;
  private RichOutputLabel newEarnAmountLabel;
  private RichOutputLabel newEarnPrdLabel;
  private RichOutputText memberDesc;
  private RichOutputText memberCode;
  HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
  private RichTable exceptionsLOV;
  private RichOutputText polStatus;
  private RichInputDate wetDate;
  private RichInputDate coverToDate;
  private RichInputText maleRtAge;
  private RichInputText femaleRtAge;
  private RichTable membersExportLOV;
  private RichInputText divFactor;
  private RichSelectBooleanCheckbox overrideMed;
  private RichInputText pensCommRate;
  private RichInputText pensionCommRate;
  private RichSelectOneChoice polCoinsuranceBusiness;
  private RichSelectOneChoice polCoinLeaderFollower;
  private RichSelectBooleanCheckbox delMemCover;
  private RichTable agentDisplayLOV;
  private RichInputText agentsDisplay;
  private RichInputDate coverFromDate;
  private RichOutputLabel mainCoverLabel;
  private RichSelectOneChoice mainCover;
  private RichOutputLabel percMainCvtLabel;
  private RichInputText percMainCvt;
  private RichInputText endrNo;
  private RichSpacer spacer1;
  private HtmlPanelGrid policyDetailPanel;
  private RichCommandButton editSaveButton;
  private RichCommandButton cancelSaveButton;
  private RichInputDate effectiveDate;
  private RichSelectOneChoice durationTermType;
  private RichSelectOneChoice renStatus;
  private RichOutputText policyNo;
  private RichSelectOneChoice coLeadFollow;
  private RichInputNumberSpinbox leaderShare;
  private RichSelectBooleanCheckbox ldrCombined;
  private RichOutputLabel premProvLabel;
  private RichSelectBooleanCheckbox premProvCbox;
  private RichSelectBooleanCheckbox jointAgent;
  private RichOutputLabel ldrCombinedLabel;
  private RichInputText addCoinsurerDisplay;
  private RichTable avaibaleCoinsurersLOV;
  private RichInputText sharePercentageDisplay;
  private RichInputText adminFeeDisplay;
  private RichSelectOneChoice laFollowerBusiness;
  private RichTable polCoinsurersLOV;
  private RichInputText coinLeaderShare;
  private RichSelectOneChoice discChoice;
  private RichInputText discRateDisplay;
  private RichInputText discDivFactor;
  private RichInputNumberSpinbox agentShare;
  private RichInputText jointAgentDesc;
  private RichTable jointAgentsTable;
  private RichTable endrAgentsTable;
  private RichInputNumberSpinbox leadAgentShare;
  private RichSelectOneChoice umbrelladurationType;
  private RichTable policyDivisionsTable;
  private RichSelectOneChoice subdivision;
  private RichInputText divShortDesc;
  private RichInputText divDesc;
  private RichSelectOneChoice rateSelection;
  private RichInputText maskDesc;
  private RichCommandButton maskButton;
  private RichInputNumberSpinbox coverRate;
  private RichInputNumberSpinbox coverRateDivFactor;
  private RichTable maskTable;
  private RichSelectBooleanRadio otherDebitOption;
  private RichSelectBooleanRadio cheqRequistionOption;
  private RichInputDate catEffectiveDate;
  private HtmlPanelGrid showTicketsTab;
  private RichInputText loadAgeFactorTF;
  private RichOutputLabel loadAgeFactorLab;
  private RichOutputLabel divFactorLab;
  private RichOutputLabel discLoadRateDisplayLab;
  private RichPanelBox coversPanelBox;
  private RichSelectOneChoice singleGrpRates;
  private RichInputDate txtWefDate;
  private RichInputDate txtWetDate;
  private RichTable claimExpLOV;
  private RichInputText srchMemNo;
  private RichInputText srchMemName;
  private RichInputText totalClaimPaid;
  private RichInputText totalPremiumPaid;
  private RichSelectOneChoice builtIn;
  private RichSelectOneChoice accelerator;
  private RichInputText sbuOneDisplay;
  private RichInputText locOneDisplay;
  private RichTable locOneLOV;
  private RichTable SBUOneLOV;
  private HtmlPanelGrid sbuOneDisplay1;
  private RichInputText ticketRemarks;
  private RichTable ticketsUserLOV;
  private RichInputText ovrCommRate;
  
  public void setCleintDisplay(RichInputText cleintDisplay)
  {
    this.cleintDisplay = cleintDisplay;
  }
  
  public RichInputText getCleintDisplay()
  {
    return this.cleintDisplay;
  }
  
  public void setPolClientsLOV(RichTable polClientsLOV)
  {
    this.polClientsLOV = polClientsLOV;
  }
  
  public RichTable getPolClientsLOV()
  {
    return this.polClientsLOV;
  }
  
  public String GetAssignee()
  {
    try
    {
      System.out.println("enter popup");
      ExtendedRenderKitService erkService = (ExtendedRenderKitService)Service.getService(FacesContext.getCurrentInstance().getRenderKit(), ExtendedRenderKitService.class);
      

      erkService.addScript(FacesContext.getCurrentInstance(), "var hints = {autodismissNever:false}; AdfPage.PAGE.findComponent('lmsgroup:users').show(hints);");
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
    return null;
  }
  
  public String AssignTask()
  {
    try
    {
      DCIteratorBinding dciter = ADFUtils.findIterator("findTicketAssigneeIterator");
      
      RowKeySet set = this.usersLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      while (rowKeySetIter.hasNext())
      {
        List l = (List)rowKeySetIter.next();
        Key key = (Key)l.get(0);
        dciter.setCurrentRowWithKey(key.toStringFormat(true));
        Row r = dciter.getCurrentRow();
        



        this.session.setAttribute("TaskAssigneeID", r.getAttribute("taskUserID"));
        
        this.session.setAttribute("TaskAssignee", r.getAttribute("taskUserShtDesc"));
      }
      workflowProcessing wf = new workflowProcessing();
      wf.CompleteTask();
      String Message = "Current Task Complete. The Next Task " + (String)this.session.getAttribute("TaskActivityName") + " has been Successfully assigned to " + (String)this.session.getAttribute("TaskAssignee");
      


      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Message, Message));
      


      this.session.setAttribute("TaskID", null);
      


      System.out.println("Success");
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
    return null;
  }
  
  public String AssignProposers()
  {
    DCIteratorBinding dciter = ADFUtils.findIterator("findProposersIterator");
    
    RowKeySet set = this.polClientsLOV.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();
    while (rowKeySetIter.hasNext())
    {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();
      this.cleintDisplay.setValue(r.getAttribute("CLIENT"));
      this.session.setAttribute("gcoCode", r.getAttribute("GCO_CODE"));
      
      this.occupationDisplay.setValue(r.getAttribute("GCO_DESC"));
      this.hazardDisplay.setValue(r.getAttribute("hazard"));
      this.proposerDisplay.setValue(r.getAttribute("CLIENT"));
    }
    return null;
  }
  
  public String AssignBranches()
  {
    DCIteratorBinding dciter = ADFUtils.findIterator("findBranchesIterator");
    
    RowKeySet set = this.polBranchesLOV.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();
    while (rowKeySetIter.hasNext())
    {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();
      this.branchDisplay.setValue(r.getAttribute("BRN_NAME"));
      this.session.setAttribute("brnCode", r.getAttribute("BRN_CODE"));
    }
    return null;
  }
  
  public void setBranchDisplay(RichInputText branchDisplay)
  {
    this.branchDisplay = branchDisplay;
  }
  
  public RichInputText getBranchDisplay()
  {
    return this.branchDisplay;
  }
  
  public void setPolBranchesLOV(RichTable polBranchesLOV)
  {
    this.polBranchesLOV = polBranchesLOV;
  }
  
  public RichTable getPolBranchesLOV()
  {
    return this.polBranchesLOV;
  }
  
  public void setPolPayFreq(RichSelectOneChoice polPayFreq)
  {
    this.polPayFreq = polPayFreq;
  }
  
  public RichSelectOneChoice getPolPayFreq()
  {
    return this.polPayFreq;
  }
  
  public void setProposerDisplay(RichOutputText proposerDisplay)
  {
    this.proposerDisplay = proposerDisplay;
  }
  
  public RichOutputText getProposerDisplay()
  {
    return this.proposerDisplay;
  }
  
  public void setPolPensionCategory(RichSelectOneChoice polPensionCategory)
  {
    this.polPensionCategory = polPensionCategory;
  }
  
  public RichSelectOneChoice getPolPensionCategory()
  {
    return this.polPensionCategory;
  }
  
  public void setOsLoanCalculation(RichSelectOneChoice osLoanCalculation)
  {
    this.osLoanCalculation = osLoanCalculation;
  }
  
  public RichSelectOneChoice getOsLoanCalculation()
  {
    return this.osLoanCalculation;
  }
  
  public void setOccupationDisplay(RichOutputText occupationDisplay)
  {
    this.occupationDisplay = occupationDisplay;
  }
  
  public RichOutputText getOccupationDisplay()
  {
    return this.occupationDisplay;
  }
  
  public void setHazardDisplay(RichOutputText hazardDisplay)
  {
    this.hazardDisplay = hazardDisplay;
  }
  
  public RichOutputText getHazardDisplay()
  {
    return this.hazardDisplay;
  }
  
  public void setPremiumMaskLOV(RichTable premiumMaskLOV)
  {
    this.premiumMaskLOV = premiumMaskLOV;
  }
  
  public RichTable getPremiumMaskLOV()
  {
    return this.premiumMaskLOV;
  }
  
  public void setCheckOffAgentsLOV(RichTable checkOffAgentsLOV)
  {
    this.checkOffAgentsLOV = checkOffAgentsLOV;
  }
  
  public RichTable getCheckOffAgentsLOV()
  {
    return this.checkOffAgentsLOV;
  }
  
  public void setEndrPayMethod(RichSelectOneChoice endrPayMethod)
  {
    this.endrPayMethod = endrPayMethod;
  }
  
  public RichSelectOneChoice getEndrPayMethod()
  {
    return this.endrPayMethod;
  }
  
  public String AssignCheckOffAgents()
  {
    DCIteratorBinding dciter = ADFUtils.findIterator("FindCheckOffAgentsIterator");
    
    RowKeySet set = this.checkOffAgentsLOV.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();
    while (rowKeySetIter.hasNext())
    {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();
      this.checkOffAgentDisplay.setValue(r.getAttribute("AGN_NAME"));
      this.session.setAttribute("agnCode", r.getAttribute("AGN_CODE"));
    }
    return null;
  }
  
  public void setCheckOffAgentDisplay(RichInputText checkOffAgentDisplay)
  {
    this.checkOffAgentDisplay = checkOffAgentDisplay;
  }
  
  public RichInputText getCheckOffAgentDisplay()
  {
    return this.checkOffAgentDisplay;
  }
  
  public String AssignPremiumMasks()
  {
    DCIteratorBinding dciter = ADFUtils.findIterator("findPremiumMaskIterator");
    
    RowKeySet set = this.premiumMaskLOV.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();
    while (rowKeySetIter.hasNext())
    {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();
      this.endrMaskDisplay.setValue(r.getAttribute("PMAS_DESC"));
      this.session.setAttribute("pmasCode", r.getAttribute("PMAS_CODE"));
      this.session.setAttribute("pmasShtDesc", r.getAttribute("PMAS_SHT_DESC"));
    }
    return null;
  }
  
  public void setEndrMaskDisplay(RichInputText endrMaskDisplay)
  {
    this.endrMaskDisplay = endrMaskDisplay;
  }
  
  public RichInputText getEndrMaskDisplay()
  {
    return this.endrMaskDisplay;
  }
  
  public void PensionCategory(String v_prod_type)
  {
    if (v_prod_type.equals("PENS")) {
      this.polPensionCategory.setRendered(true);
    } else {
      this.polPensionCategory.setRendered(false);
    }
  }
  
  public String DeletePolicyCover()
  {
    DCIteratorBinding dciter = ADFUtils.findIterator("FindCoverTypesIterator");
    
    RowKeySet set = this.policyCoversLOV.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();
    while (rowKeySetIter.hasNext())
    {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();
      

      this.session.setAttribute("pcvtCode", r.getAttribute("PCVT_CODE"));
    }
    String coverDeleteQuery = "BEGIN LMS_WEB_PKG_GRP.delete_policy_cover_type(?,?,?);END;";
    
    Connection conn = new DBConnector().getDatabaseConn();
    CallableStatement cstmt = null;
    try
    {
      cstmt = conn.prepareCall(coverDeleteQuery);
      cstmt.setBigDecimal(1, (BigDecimal)this.session.getAttribute("endorsementCode"));
      
      cstmt.setBigDecimal(2, (BigDecimal)this.session.getAttribute("policyCode"));
      
      cstmt.setBigDecimal(3, (BigDecimal)this.session.getAttribute("pcvtCode"));
      
      cstmt.execute();
      
      ADFUtils.findIterator("FindPureRateLoadingsIterator").executeQuery();
      ADFUtils.findIterator("FindCoverTypesIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.policyCoversLOV);
      conn.close();
    }
    catch (Exception ex)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, ex);
    }
    return null;
  }
  
  public String AuthoriseException()
  {
    BigDecimal Except = null;
    
    DCIteratorBinding dciter = ADFUtils.findIterator("FindPolicyExceptionsIterator");
    
    RowKeySet set = this.exceptionsLOV.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();
    while (rowKeySetIter.hasNext())
    {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();
      
      Except = (BigDecimal)r.getAttribute("QEXC_CODE");
    }
    String coverDeleteQuery = "BEGIN LMS_GRP_WEB_EXCEPTIONS.authorize_exception(?,?,?,?);END;";
    
    Connection conn = new DBConnector().getDatabaseConn();
    CallableStatement cstmt = null;
    try
    {
      cstmt = conn.prepareCall(coverDeleteQuery);
      cstmt.setString(1, (String)this.session.getAttribute("Username"));
      cstmt.setBigDecimal(2, Except);
      cstmt.setInt(3, 27);
      cstmt.setBigDecimal(4, (BigDecimal)this.session.getAttribute("endorsementCode"));
      
      cstmt.execute();
      
      ADFUtils.findIterator("FindPolicyExceptionsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.exceptionsLOV);
      conn.close();
    }
    catch (Exception ex)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, ex);
    }
    return null;
  }
  
  public void setPolicyCoversLOV(RichTable policyCoversLOV)
  {
    this.policyCoversLOV = policyCoversLOV;
  }
  
  public RichTable getPolicyCoversLOV()
  {
    return this.policyCoversLOV;
  }
  
  public String PopulateCoverTypes()
  {
    String PopulateQuery = "BEGIN LMS_WEB_PKG_GRP.populate_policy_cover_types(?,?,?);END;";
    
    Connection conn = new DBConnector().getDatabaseConn();
    CallableStatement cstmt = null;
    try
    {
      cstmt = conn.prepareCall(PopulateQuery);
      cstmt.setBigDecimal(1, (BigDecimal)this.session.getAttribute("ProductCode"));
      
      cstmt.setBigDecimal(2, (BigDecimal)this.session.getAttribute("policyCode"));
      
      cstmt.setBigDecimal(3, (BigDecimal)this.session.getAttribute("endorsementCode"));
      
      cstmt.execute();
      ADFUtils.findIterator("FindCoverTypesIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.policyCoversLOV);
      conn.close();
    }
    catch (Exception ex)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, ex);
    }
    return null;
  }
  
  public String ComputeCoverPremium()
  {
    String CalcType = null;
    Connection conn = null;
    try
    {
      conn = new DBConnector().getDatabaseConn();
      

      workflowProcessing bpm = new workflowProcessing();
      String Rights = null;
      String CurSta = (String)this.session.getAttribute("CurrentStatus");
      if (CurSta.equalsIgnoreCase("P"))
      {
        this.session.setAttribute("ProcessShtDesc", "UWNB");
        this.session.setAttribute("ProcessAreaShtDesc", "NBUW");
        this.session.setAttribute("ProcessSubAShtDesc", "NBUW");
      }
      else
      {
        this.session.setAttribute("ProcessShtDesc", "UW" + this.session.getAttribute("Endorsement"));
        
        this.session.setAttribute("ProcessAreaShtDesc", this.session.getAttribute("Endorsement") + "UW");
        

        this.session.setAttribute("ProcessSubAShtDesc", this.session.getAttribute("Endorsement") + "UW");
      }
      Rights = bpm.CheckUserRights();
      if (Rights.equalsIgnoreCase("N"))
      {
        String Message = "You do not have rights to Complete this Task.";
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Message, Message));
        


        return null;
      }
      String NextUser = null;
      CurSta = (String)this.session.getAttribute("CurrentStatus");
      if (CurSta.equalsIgnoreCase("P"))
      {
        this.session.setAttribute("ProcessShtDesc", "UWNB");
        this.session.setAttribute("ProcessAreaShtDesc", "NBUW");
        this.session.setAttribute("ProcessSubAShtDesc", "NBUW");
      }
      else
      {
        this.session.setAttribute("ProcessShtDesc", "UW" + this.session.getAttribute("Endorsement"));
        
        this.session.setAttribute("ProcessAreaShtDesc", this.session.getAttribute("Endorsement") + "UW");
        

        this.session.setAttribute("ProcessSubAShtDesc", this.session.getAttribute("Endorsement") + "UW");
      }
      this.session.setAttribute("TaskAssignee", null);
      this.session.setAttribute("NextTaskAssignee", "N");
      ADFUtils.findIterator("findTicketAssigneeIterator").executeQuery();
      NextUser = (String)this.session.getAttribute("NextTaskAssignee");
      String TaskAss = (String)this.session.getAttribute("TaskAssignee");
      if ((TaskAss == null) && (NextUser.equalsIgnoreCase("N")))
      {
        String Message = "There is no User to Assign the Next Task. Consult the Administrator.";
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Message, Message));
        


        return null;
      }
      String Taske = (String)this.session.getAttribute("TaskID");
      if (Taske == null)
      {
        subCompute();
        return null;
      }
      String MyTask = null;
      CallableStatement cst3 = null;
      String Complete = "BEGIN TQC_WEB_PKG.check_task_completion(?,?,?);END;";
      
      cst3 = conn.prepareCall(Complete);
      cst3.setString(1, "UWPOL");
      cst3.setString(2, (String)this.session.getAttribute("TaskID"));
      cst3.registerOutParameter(3, 12);
      cst3.execute();
      MyTask = cst3.getString(3);
      CurSta = (String)this.session.getAttribute("CurrentStatus");
      if ((MyTask.equalsIgnoreCase("N")) && (CurSta.equalsIgnoreCase("P")))
      {
        subCompute();
        return null;
      }
      if (this.calcType.getValue() != null)
      {
        CalcType = this.calcType.getValue().toString();
        if (CalcType.equalsIgnoreCase("A"))
        {
          ComputeAggregatePremium();
          return null;
        }
      }
      String PopulateQuery = "BEGIN LMS_WEB_PKG_GRP.compute_dtlgrp_premium(?,?,?);END;";
      
      CallableStatement cstmt = null;
      
      cstmt = conn.prepareCall(PopulateQuery);
      cstmt.setBigDecimal(1, (BigDecimal)this.session.getAttribute("endorsementCode"));
      
      cstmt.setBigDecimal(2, (BigDecimal)this.session.getAttribute("transactionNumber"));
      
      cstmt.setBigDecimal(3, (BigDecimal)this.session.getAttribute("TaCode"));
      cstmt.execute();
      

      ADFUtils.findIterator("FindEndorsementsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.endrTotalSA);
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.endrTotPremium2);
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.endrCommAmt);
      ADFUtils.findIterator("FindCoverTypesIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.policyCoversLOV);
      
      CurSta = (String)this.session.getAttribute("CurrentStatus");
      if (!CurSta.equalsIgnoreCase("P"))
      {
        String Message = "Premium Computed Successfully";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Message, Message));
        


        return null;
      }
      workflowProcessing wf = new workflowProcessing();
      Rights = bpm.CheckUserRights();
      if (Rights.equalsIgnoreCase("Y"))
      {
        wf.CompleteTask();
        String Message = "Premium Computed Successfully";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Message, Message));
      }
      else
      {
        TaskAss = (String)this.session.getAttribute("TaskAssignee");
        if (TaskAss == null)
        {
          GetAssignee();
          return null;
        }
        wf.CompleteTask();
        String Message = "Current Task Complete. The Next Task " + (String)this.session.getAttribute("TaskActivityName") + " has been Successfully assigned to " + (String)this.session.getAttribute("TaskAssignee");
        


        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Message, Message));
        


        this.session.setAttribute("TaskID", null);
        return null;
      }
      conn.close();
    }
    catch (Exception ex)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, ex);
    }
    return null;
  }
  
  public String subCompute()
  {
    String CalcType = null;
    if (this.calcType.getValue() != null)
    {
      CalcType = this.calcType.getValue().toString();
      if (CalcType.equalsIgnoreCase("A"))
      {
        ComputeAggregatePremium();
        return null;
      }
      ComputeDetailedPremium();
      return null;
    }
    return null;
  }
  
  public String ComputeAggregatePremium()
  {
    String Rights = null;
    String computePremium = "BEGIN LMS_WEB_PKG_GRP.compute_group_premium(?,?);END;";
    
    Connection conn = new DBConnector().getDatabaseConn();
    try
    {
      CallableStatement cstmt = conn.prepareCall(computePremium);
      cstmt.setBigDecimal(1, (BigDecimal)this.session.getAttribute("policyCode"));
      
      cstmt.setBigDecimal(2, (BigDecimal)this.session.getAttribute("endorsementCode"));
      

      cstmt.execute();
      
      ADFUtils.findIterator("FindEndorsementsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.endrTotalSA);
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.endrTotPremium2);
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.endrCommAmt);
      ADFUtils.findIterator("FindCoverTypesIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.policyCoversLOV);
      
      String Message = "Premium Computed Successfully";
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Message, Message));
      
































      conn.close();
    }
    catch (Exception ex)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, ex);
    }
    return null;
  }
  
  public String ComputeDetailedPremium()
  {
    Connection conn = new DBConnector().getDatabaseConn();
    try
    {
      String PopulateQuery = "BEGIN LMS_WEB_PKG_GRP.compute_dtlgrp_premium(?,?,?);END;";
      
      String RenewalArea = (String)this.session.getAttribute("RenewalArea");
      if (RenewalArea == null) {
        PopulateQuery = "BEGIN LMS_WEB_PKG_GRP.compute_dtlgrp_premium(?,?,?);END;";
      } else if (RenewalArea.equalsIgnoreCase("Y")) {
        PopulateQuery = "BEGIN LMS_WEB_PKG_GRP.compute_ren_dtlgrp_premium(?,?,?);END;";
      } else {
        PopulateQuery = "BEGIN LMS_WEB_PKG_GRP.compute_dtlgrp_premium(?,?,?);END;";
      }
      CallableStatement cstmt = null;
      
      cstmt = conn.prepareCall(PopulateQuery);
      cstmt.setBigDecimal(1, (BigDecimal)this.session.getAttribute("endorsementCode"));
      
      cstmt.setBigDecimal(2, (BigDecimal)this.session.getAttribute("transactionNumber"));
      
      cstmt.setBigDecimal(3, (BigDecimal)this.session.getAttribute("TaCode"));
      cstmt.execute();
      ADFUtils.findIterator("FindEndorsementsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.endrTotalSA);
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.endrTotPremium2);
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.endrCommAmt);
      ADFUtils.findIterator("FindCoverTypesIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.policyCoversLOV);
      ADFUtils.findIterator("FindPolicyCoinsurersIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.polCoinsurersLOV);
      ADFUtils.findIterator("FindPolicyFCLMembersIterator").executeQuery();
      ADFUtils.findIterator("FindPolicyTaxesIterator").executeQuery();
      String Message = "Premium Computed Successfully";
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Message, Message));
       conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
  }
  
  public String VerifyDetails()
  {
    Connection conn = null;
    try
    {
      workflowProcessing bpm = new workflowProcessing();
      String Rights = null;
      String siteParam = (String)this.session.getAttribute("siteParam");
      if (siteParam.equalsIgnoreCase("7"))
      {
        if (this.endrTotPremium2.getValue() == null)
        {
          this.session.setAttribute("SumAssured", "0");
        }
        else
        {
          String amt = getConvertedAmt(this.endrTotPremium2.getValue().toString());
          this.session.setAttribute("SumAssured", amt);
        }
      }
      else if (this.endrTotalSA.getValue() == null) {
        this.session.setAttribute("SumAssured", "0");
      } else {
        this.session.setAttribute("SumAssured", this.endrTotalSA.getValue().toString());
      }
      this.session.setAttribute("DebitCredit", "C");
      String CurSta = (String)this.session.getAttribute("CurrentStatus");
      if (CurSta.equalsIgnoreCase("P"))
      {
        this.session.setAttribute("ProcessShtDesc", "UWNB");
        this.session.setAttribute("ProcessAreaShtDesc", "NBUW");
        this.session.setAttribute("ProcessSubAShtDesc", "NBUW");
      }
      else
      {
        this.session.setAttribute("ProcessShtDesc", "UW" + this.session.getAttribute("Endorsement"));
        
        this.session.setAttribute("ProcessAreaShtDesc", "DENTR");
        this.session.setAttribute("ProcessSubAShtDesc", this.session.getAttribute("Endorsement") + "DAT");
      }
      Rights = bpm.CheckUserRights();
      if (Rights.equalsIgnoreCase("N"))
      {
        String Message = "You do not have rights to Complete this Task.";
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Message, Message));
        


        return null;
      }
      String NextUser = null;
      CurSta = (String)this.session.getAttribute("CurrentStatus");
      if (CurSta.equalsIgnoreCase("P"))
      {
        this.session.setAttribute("ProcessShtDesc", "UWNB");
        this.session.setAttribute("ProcessAreaShtDesc", "NBUW");
        this.session.setAttribute("ProcessSubAShtDesc", "NBMR");
      }
      else
      {
        this.session.setAttribute("ProcessShtDesc", "UW" + this.session.getAttribute("Endorsement"));
        
        this.session.setAttribute("ProcessAreaShtDesc", this.session.getAttribute("Endorsement") + "UW");
        

        this.session.setAttribute("ProcessSubAShtDesc", this.session.getAttribute("Endorsement") + "MR");
      }
      this.session.setAttribute("TaskAssignee", null);
      this.session.setAttribute("NextTaskAssignee", "N");
      ADFUtils.findIterator("findTicketAssigneeIterator").executeQuery();
      NextUser = (String)this.session.getAttribute("NextTaskAssignee");
      String TaskAss = (String)this.session.getAttribute("TaskAssignee");
      if ((TaskAss == null) && (NextUser.equalsIgnoreCase("N")))
      {
        String Message = "There is no User to Assign the Next Task. Consult the Administrator.";
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Message, Message));
        


        return null;
      }
      String Taske = (String)this.session.getAttribute("TaskID");
      if (Taske == null)
      {
        String Message = "No Task Selected";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Message, Message));
        


        return null;
      }
      conn = new DBConnector().getDatabaseConn();
      workflowProcessing wf = new workflowProcessing();
      String MyTask = null;
      CallableStatement cst3 = null;
      String Complete = "BEGIN TQC_WEB_PKG.check_task_completion(?,?,?);END;";
      
      cst3 = conn.prepareCall(Complete);
      CurSta = (String)this.session.getAttribute("CurrentStatus");
      if (CurSta.equalsIgnoreCase("P")) {
        cst3.setString(1, "VUWD");
      } else {
        cst3.setString(1, "ENDE");
      }
      cst3.setString(2, (String)this.session.getAttribute("TaskID"));
      cst3.registerOutParameter(3, 12);
      cst3.execute();
      MyTask = cst3.getString(3);
      if (MyTask.equalsIgnoreCase("Y"))
      {
        Rights = bpm.CheckUserRights();
        if (Rights.equalsIgnoreCase("Y"))
        {
          wf.CompleteTask();
          String Message = "Details Successfully Verified";
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Message, Message));
        }
        else
        {
          TaskAss = (String)this.session.getAttribute("TaskAssignee");
          if (TaskAss == null)
          {
            GetAssignee();
            return null;
          }
          wf.CompleteTask();
          String Message = "Current Task Complete. The Next Task " + (String)this.session.getAttribute("TaskActivityName") + " has been Successfully assigned to " + (String)this.session.getAttribute("TaskAssignee");
          



          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Message, Message));
          


          this.session.setAttribute("TaskID", null);
          return null;
        }
      }
      else
      {
        String Message = "the Task Selected Does not Correspond to the Activity being Performed. Cannot Complete please " + this.session.getAttribute("TaskActivityName");
        

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Message, Message));
        


        return null;
      }
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
  }
  
  public String MakeReady()
  {
    String MakeReadyQuery = "BEGIN LMS_GRP_WEB_PKG.make_ready(?,?,?,?,?,?);END;";
    

    String paramQuery = "BEGIN LMS_ORD_MISC.system_param_val(?,?);END;";
    String PostDebitNote = null;
    Connection conn = null;
    try
    {
      conn = new DBConnector().getDatabaseConn();
      

      workflowProcessing bpm = new workflowProcessing();
      String Rights = null;
      String siteParam = (String)this.session.getAttribute("siteParam");
      if (siteParam.equalsIgnoreCase("7"))
      {
        if (this.endrTotPremium2.getValue() == null)
        {
          this.session.setAttribute("SumAssured", "0");
        }
        else
        {
          String amt = getConvertedAmt(this.endrTotPremium2.getValue().toString());
          this.session.setAttribute("SumAssured", amt);
        }
      }
      else if (this.endrTotalSA.getValue() == null) {
        this.session.setAttribute("SumAssured", "0");
      } else {
        this.session.setAttribute("SumAssured", this.endrTotalSA.getValue().toString());
      }
      this.session.setAttribute("DebitCredit", "C");
      String CurSta = (String)this.session.getAttribute("CurrentStatus");
      if (CurSta.equalsIgnoreCase("P"))
      {
        this.session.setAttribute("ProcessShtDesc", "UWNB");
        this.session.setAttribute("ProcessAreaShtDesc", "NBUW");
        this.session.setAttribute("ProcessSubAShtDesc", "NBMR");
      }
      else
      {
        this.session.setAttribute("ProcessShtDesc", "UW" + this.session.getAttribute("Endorsement"));
        
        this.session.setAttribute("ProcessAreaShtDesc", this.session.getAttribute("Endorsement") + "UW");
        

        this.session.setAttribute("ProcessSubAShtDesc", this.session.getAttribute("Endorsement") + "MR");
      }
      Rights = bpm.CheckUserRights();
      if (Rights.equalsIgnoreCase("N"))
      {
        String Message = "You do not have rights to Complete this Task.";
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Message, Message));
        


        return null;
      }
      String NextUser = null;
      CurSta = (String)this.session.getAttribute("CurrentStatus");
      if (CurSta.equalsIgnoreCase("P"))
      {
        this.session.setAttribute("ProcessShtDesc", "UWNB");
        this.session.setAttribute("ProcessAreaShtDesc", "NBUW");
        this.session.setAttribute("ProcessSubAShtDesc", "NBUW");
      }
      else
      {
        this.session.setAttribute("ProcessShtDesc", "UW" + this.session.getAttribute("Endorsement"));
        
        this.session.setAttribute("ProcessAreaShtDesc", this.session.getAttribute("Endorsement") + "UW");
        

        this.session.setAttribute("ProcessSubAShtDesc", this.session.getAttribute("Endorsement") + "UW");
      }
      this.session.setAttribute("TaskAssignee", null);
      this.session.setAttribute("NextTaskAssignee", "N");
      ADFUtils.findIterator("findTicketAssigneeIterator").executeQuery();
      NextUser = (String)this.session.getAttribute("NextTaskAssignee");
      String TaskAss = (String)this.session.getAttribute("TaskAssignee");
      if ((TaskAss == null) && (NextUser.equalsIgnoreCase("N")))
      {
        String Message = "There is no User to Assign the Next Task. Consult the Administrator.";
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Message, Message));
        


        return null;
      }
      String Taske = (String)this.session.getAttribute("TaskID");
      if (Taske == null)
      {
        String Message = "No Task Selected";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Message, Message));
        


        return null;
      }
      workflowProcessing wf = new workflowProcessing();
      String MyTask = null;
      CallableStatement cst3 = null;
      String Complete = "BEGIN TQC_WEB_PKG.check_task_completion(?,?,?,?);END;";
      
      cst3 = conn.prepareCall(Complete);
      cst3.setString(1, "UWPOL");
      cst3.setString(2, (String)this.session.getAttribute("TaskID"));
      cst3.setInt(3, ((Integer)this.session.getAttribute("sysCode")).intValue());
      cst3.registerOutParameter(4, 12);
      cst3.execute();
      MyTask = cst3.getString(4);
      if (MyTask.equalsIgnoreCase("N"))
      {
        String Message = "the Task Selected Does not Correspond to the Activity being Performed. Cannot Complete please " + this.session.getAttribute("TaskActivityName");
        

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Message, Message));
        


        return null;
      }
      CallableStatement cstmt = conn.prepareCall(MakeReadyQuery);
      cstmt.setBigDecimal(1, (BigDecimal)this.session.getAttribute("policyCode"));
      
      cstmt.setBigDecimal(2, (BigDecimal)this.session.getAttribute("endorsementCode"));
      
      cstmt.setBigDecimal(3, (BigDecimal)this.session.getAttribute("transactionNumber"));
      
      cstmt.setString(4, (String)this.session.getAttribute("Username"));
      cstmt.setString(5, (String)this.session.getAttribute("OverrideMedicals"));
      
      cstmt.registerOutParameter(6, 12);
      cstmt.execute();
      
      ADFUtils.findIterator("FindPolicyExceptionsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.exceptionsLOV);
      ADFUtils.findIterator("FindEndorsementsIterator").executeQuery();
      
      Rights = bpm.CheckUserRights();
      DetermineNextTransition();
      
      Boolean result = Boolean.valueOf(false);
      Boolean result1 = Boolean.valueOf(false);
      


      CallableStatement cstParam = conn.prepareCall(paramQuery);
      cstParam.setString(1, "THIRD_PARTY_FMS_INTERFACE");
      cstParam.registerOutParameter(2, 12);
      cstParam.execute();
      PostDebitNote = (String)cstParam.getObject(2);
      if (PostDebitNote.equalsIgnoreCase("Y"))
      {
        ClientInterfaces NewInterface = new ClientInterfaces();
        result = Boolean.valueOf(NewInterface.SaveDebitCreditNote());
        if (!result.booleanValue()) {
          return null;
        }
      }
      if (Rights.equalsIgnoreCase("Y"))
      {
        wf.CompleteTask();
        String Message = "Transaction Made Ready";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Message, Message));
      }
      else
      {
        TaskAss = (String)this.session.getAttribute("TaskAssignee");
        if (TaskAss == null)
        {
          GetAssignee();
          return null;
        }
        wf.CompleteTask();
        String Message = "Current Task Complete. The Next Task " + (String)this.session.getAttribute("TaskActivityName") + " has been Successfully assigned to " + (String)this.session.getAttribute("TaskAssignee");
        


        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Message, Message));
        


        this.session.setAttribute("TaskID", null);
        return null;
      }
      conn.close();
    }
    catch (Exception ex)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, ex);
      ex.printStackTrace();
    }
    return null;
  }
  
  public String DetermineNextTransition()
  {
    Connection conn = null;
    try
    {
      conn = new DBConnector().getDatabaseConn();
      CallableStatement cst3 = null;
      String Complete = "BEGIN LMS_WEB_CURSOR_GRP.determinepolicytransition(?,?);END;";
      
      cst3 = conn.prepareCall(Complete);
      cst3.setBigDecimal(1, (BigDecimal)this.session.getAttribute("endorsementCode"));
      
      cst3.registerOutParameter(2, 12);
      cst3.execute();
      this.session.setAttribute("NextTransition", cst3.getString(2));
      System.out.println("NextTransition" + cst3.getString(2));
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
      e.printStackTrace();
    }
    return null;
  }
  
  public String DeterminePFTransition()
  {
    Connection conn = null;
    String Answer = "No";
    try
    {
      conn = new DBConnector().getDatabaseConn();
      CallableStatement cst3 = null;
      String Complete = "BEGIN  LMS_WEB_PKG_GRP_ITFC.get_payment_mode(?,?);END;";
      
      cst3 = conn.prepareCall(Complete);
      cst3.registerOutParameter(1, 12);
      cst3.setBigDecimal(2, (BigDecimal)this.session.getAttribute("endorsementCode"));
      

      cst3.execute();
      Answer = cst3.getString(1);
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return Answer;
  }
  
  public String WaitForPaymentComplete()
  {
    Connection conn = null;
    try
    {
      conn = new DBConnector().getDatabaseConn();
      

      workflowProcessing bpm = new workflowProcessing();
      String Rights = null;
      String siteParam = (String)this.session.getAttribute("siteParam");
      if (siteParam.equalsIgnoreCase("7"))
      {
        if (this.endrTotPremium2.getValue() == null)
        {
          this.session.setAttribute("SumAssured", "0");
        }
        else
        {
          String amt = getConvertedAmt(this.endrTotPremium2.getValue().toString());
          this.session.setAttribute("SumAssured", amt);
        }
      }
      else if (this.endrTotalSA.getValue() == null) {
        this.session.setAttribute("SumAssured", "0");
      } else {
        this.session.setAttribute("SumAssured", this.endrTotalSA.getValue().toString());
      }
      this.session.setAttribute("DebitCredit", "C");
      String CurSta = (String)this.session.getAttribute("CurrentStatus");
      if (CurSta.equalsIgnoreCase("P"))
      {
        this.session.setAttribute("ProcessShtDesc", "UWNB");
        this.session.setAttribute("ProcessAreaShtDesc", "NBUW");
        this.session.setAttribute("ProcessSubAShtDesc", "NBUW");
      }
      else
      {
        this.session.setAttribute("ProcessShtDesc", "UW" + this.session.getAttribute("Endorsement"));
        
        this.session.setAttribute("ProcessAreaShtDesc", this.session.getAttribute("Endorsement") + "UW");
        

        this.session.setAttribute("ProcessSubAShtDesc", this.session.getAttribute("Endorsement") + "UW");
      }
      Rights = bpm.CheckUserRights();
      if (Rights.equalsIgnoreCase("N"))
      {
        String Message = "You do not have rights to Complete this Task.";
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Message, Message));
        


        return null;
      }
      String NextUser = null;
      CurSta = (String)this.session.getAttribute("CurrentStatus");
      if (CurSta.equalsIgnoreCase("P"))
      {
        this.session.setAttribute("ProcessShtDesc", "UWNB");
        this.session.setAttribute("ProcessAreaShtDesc", "NBUW");
        this.session.setAttribute("ProcessSubAShtDesc", "NBUW");
      }
      else
      {
        this.session.setAttribute("ProcessShtDesc", "UW" + this.session.getAttribute("Endorsement"));
        
        this.session.setAttribute("ProcessAreaShtDesc", this.session.getAttribute("Endorsement") + "UW");
        

        this.session.setAttribute("ProcessSubAShtDesc", this.session.getAttribute("Endorsement") + "UW");
      }
      this.session.setAttribute("TaskAssignee", null);
      this.session.setAttribute("NextTaskAssignee", "N");
      ADFUtils.findIterator("findTicketAssigneeIterator").executeQuery();
      NextUser = (String)this.session.getAttribute("NextTaskAssignee");
      String TaskAss = (String)this.session.getAttribute("TaskAssignee");
      if ((TaskAss == null) && (NextUser.equalsIgnoreCase("N")))
      {
        String Message = "There is no User to Assign the Next Task. Consult the Administrator.";
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Message, Message));
        


        return null;
      }
      String Taske = (String)this.session.getAttribute("TaskID");
      if (Taske == null)
      {
        String Message = "No Task Selected";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Message, Message));
        


        return null;
      }
      workflowProcessing wf = new workflowProcessing();
      String MyTask = null;
      CallableStatement cst3 = null;
      String Complete = "BEGIN TQC_WEB_PKG.check_task_completion(?,?,?,?);END;";
      
      cst3 = conn.prepareCall(Complete);
      cst3.setString(1, "UWFP");
      cst3.setString(2, (String)this.session.getAttribute("TaskID"));
      cst3.setInt(3, ((Integer)this.session.getAttribute("sysCode")).intValue());
      cst3.registerOutParameter(4, 12);
      cst3.execute();
      MyTask = cst3.getString(4);
      DetermineNextTransition();
      if (MyTask.equalsIgnoreCase("Y"))
      {
        Rights = bpm.CheckUserRights();
        if (Rights.equalsIgnoreCase("Y"))
        {
          wf.CompleteTask();
          String Message = "Payments Recieved.";
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Message, Message));
        }
        else
        {
          TaskAss = (String)this.session.getAttribute("TaskAssignee");
          if (TaskAss == null)
          {
            GetAssignee();
            return null;
          }
          wf.CompleteTask();
          String Message = "Current Task Complete. The Next Task " + (String)this.session.getAttribute("TaskActivityName") + " has been Successfully assigned to " + (String)this.session.getAttribute("TaskAssignee");
          



          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Message, Message));
          


          this.session.setAttribute("TaskID", null);
          return null;
        }
      }
      else
      {
        String Message = "the Task Selected Does not Correspond to the Activity being Performed. Cannot Complete please " + this.session.getAttribute("TaskActivityName");
        

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Message, Message));
        


        return null;
      }
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
  }
  
  public String ValidateUserAccessForAuthorisation()
  {
    Connection conn = null;
    String Access = "N";
    try
    {
      String query = "begin ?:= LMS_WEB_PKG_GRP_UW.validate_user_access(?,?,?,?); end;";
      

      DBConnector datahandler = new DBConnector();
      
      conn = datahandler.getDatabaseConn();
      
      CallableStatement cst = null;
      cst = conn.prepareCall(query);
      cst.registerOutParameter(1, 12);
      
      cst.setBigDecimal(2, (BigDecimal)this.session.getAttribute("UserCode"));
      cst.setString(3, null);
      cst.setBigDecimal(4, null);
      cst.setBigDecimal(5, (BigDecimal)this.session.getAttribute("endorsementCode"));
      
      cst.execute();
      Access = cst.getString(1);
      cst.close();
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return Access;
  }
  
  public String AuthoriseRefundTransaction()
  {
    Connection conn = null;
    String ChequeRequisition = null;
    CallableStatement cstmt = null;
    String authQuery = "BEGIN LMS_GRP_WEB_PKG.grp_authorise(?,?,?,?,?);END;";
    try
    {
      if (this.cheqRequistionOption.isSelected()) {
        ChequeRequisition = "Y";
      } else {
        ChequeRequisition = "N";
      }
      conn = new DBConnector().getDatabaseConn();
      

      CallableStatement cstBal = null;
      String BalanceQuery = "BEGIN ? := LMS_GRP_WEB_PKG.validate_refund_transaction(?,?,?);END;";
      
      cstBal = conn.prepareCall(BalanceQuery);
      cstBal.registerOutParameter(1, 12);
      cstBal.setBigDecimal(2, (BigDecimal)this.session.getAttribute("endorsementCode"));
      
      cstBal.setBigDecimal(3, (BigDecimal)this.session.getAttribute("policyCode"));
      
      cstBal.setString(4, ChequeRequisition);
      
      cstBal.execute();
      
      String BalResult = cstBal.getString(1);
      if (BalResult.equalsIgnoreCase("Y"))
      {
        GlobalCC.errorValueNotEntered("Several Members on the Transaction have not fully settled their Balances. Cannot Proceed.");
        return null;
      }
      cstBal.close();
      

      String Access = ValidateUserAccessForAuthorisation();
      if (Access == null)
      {
        GlobalCC.errorValueNotEntered("You do not have rights to Authorise this Transaction. Cannot Proceed.");
        return null;
      }
      if (Access.equalsIgnoreCase("N"))
      {
        GlobalCC.errorValueNotEntered("You do not have rights to Authorise this Transaction. Cannot Proceed.");
        return null;
      }
      workflowProcessing bpm = new workflowProcessing();
      String Rights = null;
      String siteParam = (String)this.session.getAttribute("siteParam");
      if (siteParam.equalsIgnoreCase("7"))
      {
        if (this.endrTotPremium2.getValue() == null)
        {
          this.session.setAttribute("SumAssured", "0");
        }
        else
        {
          String amt = getConvertedAmt(this.endrTotPremium2.getValue().toString());
          this.session.setAttribute("SumAssured", amt);
        }
      }
      else if (this.endrTotalSA.getValue() == null) {
        this.session.setAttribute("SumAssured", "0");
      } else {
        this.session.setAttribute("SumAssured", this.endrTotalSA.getValue().toString());
      }
      this.session.setAttribute("DebitCredit", "C");
      String CurSta = (String)this.session.getAttribute("CurrentStatus");
      if (CurSta.equalsIgnoreCase("P"))
      {
        this.session.setAttribute("ProcessShtDesc", "UWNB");
        this.session.setAttribute("ProcessAreaShtDesc", "NBUW");
        this.session.setAttribute("ProcessSubAShtDesc", "NBAU");
      }
      else
      {
        this.session.setAttribute("ProcessShtDesc", "UW" + this.session.getAttribute("Endorsement"));
        
        this.session.setAttribute("ProcessAreaShtDesc", this.session.getAttribute("Endorsement") + "UW");
        

        this.session.setAttribute("ProcessSubAShtDesc", this.session.getAttribute("Endorsement") + "AU");
      }
      Rights = bpm.CheckUserRights();
      if (Rights.equalsIgnoreCase("N"))
      {
        GlobalCC.errorValueNotEntered("You do not have rights to Complete this Task.");
        return null;
      }
      String NextUser = null;
      CurSta = (String)this.session.getAttribute("CurrentStatus");
      if (CurSta.equalsIgnoreCase("P"))
      {
        this.session.setAttribute("ProcessShtDesc", "UWNB");
        this.session.setAttribute("ProcessAreaShtDesc", "UDISP");
        this.session.setAttribute("ProcessSubAShtDesc", "UDISP");
      }
      else
      {
        this.session.setAttribute("ProcessShtDesc", "UW" + this.session.getAttribute("Endorsement"));
        
        this.session.setAttribute("ProcessAreaShtDesc", "EDISP");
        this.session.setAttribute("ProcessSubAShtDesc", "EDISP");
      }
      this.session.setAttribute("TaskAssignee", null);
      this.session.setAttribute("NextTaskAssignee", "N");
      ADFUtils.findIterator("findTicketAssigneeIterator").executeQuery();
      NextUser = (String)this.session.getAttribute("NextTaskAssignee");
      String TaskAss = (String)this.session.getAttribute("TaskAssignee");
      if ((TaskAss == null) && (NextUser.equalsIgnoreCase("N")))
      {
        GlobalCC.errorValueNotEntered("There is no User to Assign the Next Task. Consult the Administrator.");
        return null;
      }
      String Taske = (String)this.session.getAttribute("TaskID");
      if (Taske == null)
      {
        GlobalCC.errorValueNotEntered("No Task Selected");
        return null;
      }
      workflowProcessing wf = new workflowProcessing();
      String MyTask = null;
      CallableStatement cst3 = null;
      String Complete = "BEGIN TQC_WEB_PKG.check_task_completion(?,?,?,?);END;";
      
      cst3 = conn.prepareCall(Complete);
      cst3.setString(1, "UAUTH");
      cst3.setString(2, (String)this.session.getAttribute("TaskID"));
      cst3.setInt(3, ((Integer)this.session.getAttribute("sysCode")).intValue());
      cst3.registerOutParameter(4, 12);
      cst3.execute();
      MyTask = cst3.getString(4);
      if (MyTask.equalsIgnoreCase("N"))
      {
        GlobalCC.errorValueNotEntered("the Task Selected Does not Correspond to the Activity being Performed. Cannot Complete please " + this.session.getAttribute("TaskActivityName"));
        
        return null;
      }
      cstmt = conn.prepareCall(authQuery);
      cstmt.setBigDecimal(1, (BigDecimal)this.session.getAttribute("policyCode"));
      
      cstmt.setBigDecimal(2, (BigDecimal)this.session.getAttribute("endorsementCode"));
      
      cstmt.setBigDecimal(3, (BigDecimal)this.session.getAttribute("transactionNumber"));
      
      cstmt.setString(4, "Y");
      cstmt.setString(5, ChequeRequisition);
      cstmt.execute();
      
      ADFUtils.findIterator("FindPoliciesIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.polStatus);
      this.session.setAttribute("Authorised", "Y");
      
      Rights = bpm.CheckUserRights();
      if (Rights.equalsIgnoreCase("Y"))
      {
        wf.CompleteTask();
        GlobalCC.INFORMATIONREPORTING("Transaction Successfully Authorised.");
      }
      else
      {
        TaskAss = (String)this.session.getAttribute("TaskAssignee");
        if (TaskAss == null)
        {
          GetAssignee();
          return null;
        }
        wf.CompleteTask();
        GlobalCC.INFORMATIONREPORTING("Current Task Complete. The Next Task " + (String)this.session.getAttribute("TaskActivityName") + " has been Successfully assigned to " + (String)this.session.getAttribute("TaskAssignee"));
        


        this.session.setAttribute("TaskID", null);
        return null;
      }
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
  }
  
  public String AuthoriseTransaction()
  {
    String authQuery = "BEGIN LMS_GRP_WEB_PKG.grp_authorise(?,?,?,?,?);END;";
    

    CallableStatement cstmt = null;
    CorrespondenceManipulation mail = new CorrespondenceManipulation();
    Connection conn = null;
    try
    {
      conn = new DBConnector().getDatabaseConn();
      

      String Access = ValidateUserAccessForAuthorisation();
      if (Access == null)
      {
        GlobalCC.errorValueNotEntered("You do not have rights to Authorise this Transaction. Cannot Proceed.");
        return null;
      }
      if (Access.equalsIgnoreCase("N"))
      {
        GlobalCC.errorValueNotEntered("You do not have rights to Authorise this Transaction. Cannot Proceed.");
        return null;
      }
      workflowProcessing bpm = new workflowProcessing();
      String Rights = null;
      String siteParam = (String)this.session.getAttribute("siteParam");
      System.out.println("site param=" + siteParam);
      if (siteParam.equalsIgnoreCase("7"))
      {
        if (this.endrTotPremium2.getValue() == null)
        {
          this.session.setAttribute("SumAssured", "0");
        }
        else
        {
          String amt = getConvertedAmt(this.endrTotPremium2.getValue().toString());
          this.session.setAttribute("SumAssured", amt);
        }
      }
      else if (this.endrTotalSA.getValue() == null) {
        this.session.setAttribute("SumAssured", "0");
      } else {
        this.session.setAttribute("SumAssured", this.endrTotalSA.getValue().toString());
      }
      this.session.setAttribute("DebitCredit", "C");
      String CurSta = (String)this.session.getAttribute("CurrentStatus");
      if (CurSta.equalsIgnoreCase("P"))
      {
        this.session.setAttribute("ProcessShtDesc", "UWNB");
        this.session.setAttribute("ProcessAreaShtDesc", "NBUW");
        this.session.setAttribute("ProcessSubAShtDesc", "NBAU");
      }
      else
      {
        this.session.setAttribute("ProcessShtDesc", "UW" + this.session.getAttribute("Endorsement"));
        
        this.session.setAttribute("ProcessAreaShtDesc", this.session.getAttribute("Endorsement") + "UW");
        

        this.session.setAttribute("ProcessSubAShtDesc", this.session.getAttribute("Endorsement") + "AU");
      }
      Rights = bpm.CheckUserRights();
      if (Rights.equalsIgnoreCase("N"))
      {
        String Message = "You do not have rights to Complete this Task.";
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Message, Message));
        


        return null;
      }
      String NextUser = null;
      CurSta = (String)this.session.getAttribute("CurrentStatus");
      if (CurSta.equalsIgnoreCase("P"))
      {
        this.session.setAttribute("ProcessShtDesc", "UWNB");
        this.session.setAttribute("ProcessAreaShtDesc", "UDISP");
        this.session.setAttribute("ProcessSubAShtDesc", "UDISP");
      }
      else
      {
        this.session.setAttribute("ProcessShtDesc", "UW" + this.session.getAttribute("Endorsement"));
        
        this.session.setAttribute("ProcessAreaShtDesc", "EDISP");
        this.session.setAttribute("ProcessSubAShtDesc", "EDISP");
      }
      this.session.setAttribute("TaskAssignee", null);
      this.session.setAttribute("NextTaskAssignee", "N");
      ADFUtils.findIterator("findTicketAssigneeIterator").executeQuery();
      NextUser = (String)this.session.getAttribute("NextTaskAssignee");
      String TaskAss = (String)this.session.getAttribute("TaskAssignee");
      if (TaskAss == null)
      {
        TaskAss = (String)this.session.getAttribute("Username");
        this.session.setAttribute("TaskAssignee", TaskAss);
      }
      if ((TaskAss == null) && (NextUser.equalsIgnoreCase("N")))
      {
        String Message = "There is no User to Assign the Next Task. Consult the Administrator.";
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Message, Message));
        


        return null;
      }
      String Taske = (String)this.session.getAttribute("TaskID");
      if (Taske == null)
      {
        String Message = "No Task Selected";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Message, Message));
        


        return null;
      }
      workflowProcessing wf = new workflowProcessing();
      String MyTask = null;
      CallableStatement cst3 = null;
      String Complete = "BEGIN TQC_WEB_PKG.check_task_completion(?,?,?,?);END;";
      
      cst3 = conn.prepareCall(Complete);
      cst3.setString(1, "UAUTH");
      cst3.setString(2, (String)this.session.getAttribute("TaskID"));
      cst3.setInt(3, ((Integer)this.session.getAttribute("sysCode")).intValue());
      cst3.registerOutParameter(4, 12);
      cst3.execute();
      MyTask = cst3.getString(4);
      if (MyTask.equalsIgnoreCase("N"))
      {
        String Message = "the Task Selected Does not Correspond to the Activity being Performed. Cannot Complete please " + this.session.getAttribute("TaskActivityName");
        

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Message, Message));
        


        return null;
      }
      cstmt = conn.prepareCall(authQuery);
      cstmt.setBigDecimal(1, (BigDecimal)this.session.getAttribute("policyCode"));
      
      cstmt.setBigDecimal(2, (BigDecimal)this.session.getAttribute("endorsementCode"));
      
      cstmt.setBigDecimal(3, (BigDecimal)this.session.getAttribute("transactionNumber"));
      
      cstmt.setString(4, "Y");
      cstmt.setString(5, "Y");
      cstmt.execute();
      ADFUtils.findIterator("FindPoliciesIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.polStatus);
      this.session.setAttribute("Authorised", "Y");
      
      Rights = bpm.CheckUserRights();
      if (Rights.equalsIgnoreCase("Y"))
      {
        wf.CompleteTask();
        String Msg = "Transaction Successfully Authorised.";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Msg, Msg));
      }
      else
      {
        TaskAss = (String)this.session.getAttribute("TaskAssignee");
        if (TaskAss == null)
        {
          GetAssignee();
          return null;
        }
        wf.CompleteTask();
        String Message = "Current Task Complete. The Next Task " + (String)this.session.getAttribute("TaskActivityName") + " has been Successfully assigned to " + (String)this.session.getAttribute("TaskAssignee");
        


        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Message, Message));
        


        this.session.setAttribute("TaskID", null);
        return null;
      }
      conn.close();
    }
    catch (Exception ex)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, ex);
    }
    mail.emailReport("POLAUTH");
    
    return null;
  }
  
  public String ChangeRenewalStatus()
  {
    Connection conn = null;
    try
    {
      String authQuery = "BEGIN LMS_WEB_PKG_GRP_UW.change_ren_status(?,?);END;";
      
      conn = new DBConnector().getDatabaseConn();
      CallableStatement cstmt = conn.prepareCall(authQuery);
      cstmt.setBigDecimal(1, (BigDecimal)this.session.getAttribute("policyCode"));
      if (this.renStatus.getValue() == null) {
        cstmt.setString(2, "N");
      } else {
        cstmt.setString(2, this.renStatus.getValue().toString());
      }
      cstmt.execute();
      cstmt.close();
      conn.close();
      
      GlobalCC.INFORMATIONREPORTING("Status Successfully Changed.");
      ADFUtils.findIterator("FindPoliciesIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.renStatus);
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
    return null;
  }
  
  public String AuthoriseRenewalStatus()
  {
    Connection conn = null;
    try
    {
      String authQuery = "BEGIN LMS_WEB_PKG_GRP_UW.authorise_ren_status(?,?);END;";
      
      conn = new DBConnector().getDatabaseConn();
      CallableStatement cstmt = conn.prepareCall(authQuery);
      cstmt.setBigDecimal(1, (BigDecimal)this.session.getAttribute("policyCode"));
      
      cstmt.setBigDecimal(2, (BigDecimal)this.session.getAttribute("endorsementCode"));
      
      cstmt.execute();
      cstmt.close();
      conn.close();
      
      GlobalCC.INFORMATIONREPORTING("Status Successfully Authorised.");
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
    return null;
  }
  
  public String TransferRenewal()
  {
    Connection conn = null;
    try
    {
      conn = new DBConnector().getDatabaseConn();
      this.session.setAttribute("Endorsement", "RN");
      this.session.setAttribute("ProcessShtDesc", "UWRN");
      this.session.setAttribute("ProcessAreaShtDesc", "ACCS");
      this.session.setAttribute("ProcessSubAShtDesc", "ACCS");
      this.session.setAttribute("UWStart", "No");
      
      String Rights = null;
      workflowProcessing wf = new workflowProcessing();
      Rights = wf.CheckUserRights();
      
      Links L1 = new Links();
      L1.FindProcessDetails();
      this.session.setAttribute("TaskID", null);
      if (!Rights.equalsIgnoreCase("Y"))
      {
        GlobalCC.INFORMATIONREPORTING("You do not have rights to access this Module");
        return null;
      }
      String NextUser = null;
      this.session.setAttribute("ProcessAreaShtDesc", "DENTR");
      this.session.setAttribute("ProcessSubAShtDesc", this.session.getAttribute("Endorsement") + "DAT");
      
      this.session.setAttribute("TaskAssignee", null);
      this.session.setAttribute("NextTaskAssignee", "N");
      ADFUtils.findIterator("findTicketAssigneeIterator").executeQuery();
      NextUser = (String)this.session.getAttribute("NextTaskAssignee");
      String TaskAss = (String)this.session.getAttribute("TaskAssignee");
      if ((TaskAss == null) && (NextUser.equalsIgnoreCase("N")))
      {
        GlobalCC.INFORMATIONREPORTING("There is no User to Assign the Next Task. Consult the Administrator.");
        return null;
      }
      String deleteMember = "BEGIN LMS_WEB_PKG_GRP_UW.renew_policies_direct(?,?,?,?,?,?);END;";
      
      CallableStatement cstmt = conn.prepareCall(deleteMember);
      
      cstmt.setBigDecimal(1, (BigDecimal)this.session.getAttribute("policyCode"));
      if (this.durationType.getValue() == null) {
        cstmt.setString(2, null);
      } else {
        cstmt.setString(2, this.durationType.getValue().toString());
      }
      if (this.effectiveDate.getValue() == null) {
        cstmt.setString(3, null);
      } else if (this.effectiveDate.getValue().toString().contains(":")) {
        cstmt.setString(3, GlobalCC.parseDate(this.effectiveDate.getValue().toString()));
      } else {
        cstmt.setString(3, GlobalCC.upDateParseDate(this.effectiveDate.getValue().toString()));
      }
      cstmt.registerOutParameter(4, 3);
      cstmt.registerOutParameter(5, 3);
      if (this.durationType.getValue().toString().equalsIgnoreCase("C")) {
        cstmt.setString(6, GlobalCC.parseDate(this.wetDate.getValue().toString()));
      } else {
        cstmt.setString(6, null);
      }
      cstmt.execute();
      
      this.session.setAttribute("endorsementCode", cstmt.getBigDecimal(5));
      this.session.setAttribute("transactionNumber", cstmt.getBigDecimal(4));
      this.session.setAttribute("policyNumber", this.policyNo.getValue().toString());
      
      this.session.setAttribute("Authorised", "N");
      this.session.setAttribute("RenewalArea", "N");
      
      Rights = wf.CheckUserRights();
      if (Rights.equalsIgnoreCase("Y"))
      {
        wf.CreateWorkflowInstance();
        GlobalCC.RedirectPage("/g_undwrt.jspx");
      }
      else
      {
        TaskAss = (String)this.session.getAttribute("TaskAssignee");
        if (TaskAss == null)
        {
          GetAssignee();
          return null;
        }
        wf.CreateWorkflowInstance();
        GlobalCC.INFORMATIONREPORTING("Current Task Complete. The Next Task " + (String)this.session.getAttribute("TaskActivityName") + " has been Successfully assigned to " + (String)this.session.getAttribute("TaskAssignee"));
        


        this.session.setAttribute("TaskID", null);
        return null;
      }
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
  }
  
  public String CompleteFCL2()
  {
    CorrespondenceManipulation mail = new CorrespondenceManipulation();
    BigDecimal overideFCL = null;
    
    Connection conn = null;
    CorrespondenceManipulation email = new CorrespondenceManipulation();
    try
    {
      DBConnector myConn = new DBConnector();
      conn = myConn.getDatabaseConn();
      









      workflowProcessing bpm = new workflowProcessing();
      String Rights = null;
      String siteParam = (String)this.session.getAttribute("siteParam");
      if (siteParam.equalsIgnoreCase("7"))
      {
        if (this.endrTotPremium2.getValue() == null)
        {
          this.session.setAttribute("SumAssured", "0");
        }
        else
        {
          String amt = getConvertedAmt(this.endrTotPremium2.getValue().toString());
          this.session.setAttribute("SumAssured", amt);
        }
      }
      else if (this.endrTotalSA.getValue() == null) {
        this.session.setAttribute("SumAssured", "0");
      } else {
        this.session.setAttribute("SumAssured", this.endrTotalSA.getValue().toString());
      }
      this.session.setAttribute("DebitCredit", "C");
      String Cursta = (String)this.session.getAttribute("CurrentStatus");
      if (Cursta.equalsIgnoreCase("P"))
      {
        this.session.setAttribute("ProcessShtDesc", "UWNB");
        this.session.setAttribute("ProcessAreaShtDesc", "NBUW");
        this.session.setAttribute("ProcessSubAShtDesc", "NBUW");
      }
      else
      {
        this.session.setAttribute("ProcessShtDesc", "UW" + this.session.getAttribute("Endorsement"));
        
        this.session.setAttribute("ProcessAreaShtDesc", this.session.getAttribute("Endorsement") + "UW");
        

        this.session.setAttribute("ProcessSubAShtDesc", this.session.getAttribute("Endorsement") + "UW");
      }
      Rights = bpm.CheckUserRights();
      if (Rights.equalsIgnoreCase("N"))
      {
        String Message = "You do not have rights to Complete this Task.";
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Message, Message));
        


        return null;
      }
      String NextUser = null;
      Cursta = (String)this.session.getAttribute("CurrentStatus");
      if (Cursta.equalsIgnoreCase("P"))
      {
        this.session.setAttribute("ProcessShtDesc", "UWNB");
        this.session.setAttribute("ProcessAreaShtDesc", "NBUW");
        this.session.setAttribute("ProcessSubAShtDesc", "NBAU");
      }
      else
      {
        this.session.setAttribute("ProcessShtDesc", "UW" + this.session.getAttribute("Endorsement"));
        
        this.session.setAttribute("ProcessAreaShtDesc", this.session.getAttribute("Endorsement") + "UW");
        

        this.session.setAttribute("ProcessSubAShtDesc", this.session.getAttribute("Endorsement") + "AU");
      }
      this.session.setAttribute("TaskAssignee", null);
      
      this.session.setAttribute("NextTaskAssignee", "N");
      ADFUtils.findIterator("findTicketAssigneeIterator").executeQuery();
      NextUser = (String)this.session.getAttribute("NextTaskAssignee");
      
      String TaskAss = (String)this.session.getAttribute("TaskAssignee");
      if (TaskAss == null)
      {
        TaskAss = (String)this.session.getAttribute("Username");
        this.session.setAttribute("TaskAssignee", TaskAss);
      }
      if ((TaskAss == null) && (NextUser.equalsIgnoreCase("N")))
      {
        String Message = "There is no User to Assign the Next Task. Consult the Administrator.";
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Message, Message));
        


        return null;
      }
      String Taske = (String)this.session.getAttribute("TaskID");
      if (Taske == null)
      {
        String Message = "No Task Selected";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Message, Message));
        


        return null;
      }
      String MyTask = null;
      CallableStatement cst3 = null;
      String Complete = "BEGIN TQC_WEB_PKG.check_task_completion(?,?,?,?);END;";
      
      cst3 = conn.prepareCall(Complete);
      cst3.setString(1, "UMEDI");
      cst3.setString(2, (String)this.session.getAttribute("TaskID"));
      cst3.setInt(3, ((Integer)this.session.getAttribute("sysCode")).intValue());
      cst3.registerOutParameter(4, 12);
      cst3.execute();
      MyTask = cst3.getString(4);
      if (MyTask.equalsIgnoreCase("N"))
      {
        String Message = "the Task Selected Does not Correspond to the Activity being Performed. Cannot Complete please " + this.session.getAttribute("TaskActivityName");
        

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Message, Message));
        


        return null;
      }
      workflowProcessing wf = new workflowProcessing();
      Rights = bpm.CheckUserRights();
      if (Rights.equalsIgnoreCase("Y"))
      {
        wf.CompleteTask();
        String Msg = "Medicals Completed Successfully";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Msg, Msg));
      }
      else
      {
        TaskAss = (String)this.session.getAttribute("TaskAssignee");
        if (TaskAss == null)
        {
          GetAssignee();
          return null;
        }
        if (postUnderwritingReinsurance().equals("Y")) {
          this.session.setAttribute("NextTransition", "PJ");
        } else {
          this.session.setAttribute("NextTransition", "RB");
        }
        wf.CompleteTask();
        String Message = "Current Task Complete. The Next Task " + (String)this.session.getAttribute("TaskActivityName") + " has been Successfully assigned to " + (String)this.session.getAttribute("TaskAssignee");
        


        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Message, Message));
        


        this.session.setAttribute("TaskID", null);
        return null;
      }
      conn.close();
    }
    catch (Exception ex)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, ex);
    }
    email.emailReport("MEDCOMP");
    return null;
  }
  
  public String CancelSave()
  {
    this.cancelSaveButton.setRendered(false);
    this.session.setAttribute("editComponents", "N");
    this.policyDetailPanel.setColumns(8);
    this.editSaveButton.setText("Edit");
    this.editSaveButton.setIcon("/images/update_ena.png");
    this.coverToDate.setDisabled(false);
    this.effectiveDate.setDisabled(false);
    this.coverFromDate.setDisabled(false);
    
    return null;
  }
  
  public String AssignSBUundwrt()
  {
    DCIteratorBinding dciter = ADFUtils.findIterator("FindSBUDetailsIterator");
    
    RowKeySet set = this.SBUOneLOV.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();
    while (rowKeySetIter.hasNext())
    {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();
      
      this.session.setAttribute("coverageAreaCode", r.getAttribute("COVERAGE_AREA_CODE"));
      


      this.session.setAttribute("spokeCode", r.getAttribute("SPOKE_CODE"));
      

      this.session.setAttribute("sbuCode", r.getAttribute("SBU_CODE"));
      

      this.sbuOneDisplay.setValue(r.getAttribute("COVERAGE_AREA"));
    }
    return null;
  }
  
  public String AssignLocUndwrt()
  {
    DCIteratorBinding dciter = ADFUtils.findIterator("FindOrgLocationsDetailsIterator");
    
    RowKeySet set = this.locOneLOV.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();
    while (rowKeySetIter.hasNext())
    {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();
      

      this.session.setAttribute("locationCode", r.getAttribute("LOCATION_CODE"));
      



      this.locOneDisplay.setValue(r.getAttribute("LOCATION"));
    }
    return null;
  }
  
  public String RenderEditSave()
  {
    try
    {
      String ButtonPosition = this.editSaveButton.getText();
      if (ButtonPosition.equalsIgnoreCase("Save"))
      {
        String Result = UpdateEndorsement();
        if (Result == "F") {
          return null;
        }
        this.session.setAttribute("editComponents", "N");
        this.policyDetailPanel.setColumns(8);
        this.editSaveButton.setText("Edit");
        this.editSaveButton.setIcon("/images/update_ena.png");
        this.cancelSaveButton.setRendered(false);
        

        this.coverFromDate.setDisabled(false);
      }
      else
      {
        this.session.setAttribute("editComponents", "Y");
        this.policyDetailPanel.setColumns(6);
        this.editSaveButton.setText("Save");
        this.editSaveButton.setIcon("/images/save.gif");
        this.cancelSaveButton.setRendered(true);
        

        this.coverFromDate.setDisabled(true);
      }
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
    return null;
  }
  
  public String UpdateEndorsement()
  {
    String Result = "F";
    String computePremium = "BEGIN LMS_WEB_PKG_GRP.update_calc_types(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);END;";
    
    String RenewalArea = (String)this.session.getAttribute("RenewalArea");
    if (RenewalArea == null) {
      computePremium = "BEGIN LMS_WEB_PKG_GRP.update_calc_types(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);END;";
    } else if (RenewalArea.equalsIgnoreCase("Y")) {
      computePremium = "BEGIN LMS_WEB_PKG_GRP.update_ren_calc_types(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);END;";
    } else {
      computePremium = "BEGIN LMS_WEB_PKG_GRP.update_calc_types(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);END;";
    }
    Connection conn = new DBConnector().getDatabaseConn();
    try
    {
      CallableStatement cstmt = conn.prepareCall(computePremium);
      cstmt.setString(1, "P");
      if (this.calcType.getValue() == null) {
        cstmt.setBigDecimal(2, null);
      } else {
        cstmt.setString(2, this.calcType.getValue().toString());
      }
      if (this.payFreq.getValue() == null) {
        cstmt.setBigDecimal(3, null);
      } else {
        cstmt.setString(3, this.payFreq.getValue().toString());
      }
      cstmt.setString(4, null);
      cstmt.setBigDecimal(5, (BigDecimal)this.session.getAttribute("endorsementCode"));
      
      System.out.println(this.session.getAttribute("FCLTotalAmt"));
      
      cstmt.setBigDecimal(6, (BigDecimal)this.session.getAttribute("FCLTotalAmt"));
      
      cstmt.setBigDecimal(7, (BigDecimal)this.session.getAttribute("pmasCode"));
      
      cstmt.setString(8, (String)this.session.getAttribute("pmasShtDesc"));
      if (this.maleRtAge.getValue() == null) {
        cstmt.setString(9, null);
      } else {
        cstmt.setString(9, this.maleRtAge.getValue().toString());
      }
      if (this.femaleRtAge.getValue() == null) {
        cstmt.setString(10, null);
      } else {
        cstmt.setString(10, this.femaleRtAge.getValue().toString());
      }
      if (this.durationType.getValue() == null) {
        cstmt.setBigDecimal(11, null);
      } else {
        cstmt.setString(11, this.durationType.getValue().toString());
      }
      cstmt.setBigDecimal(12, (BigDecimal)this.session.getAttribute("policyCode"));
      if (this.coverToDate.getValue() == null) {
        cstmt.setString(13, null);
      } else if (this.coverToDate.getValue().toString().contains(":")) {
        cstmt.setString(13, GlobalCC.parseDate(this.coverToDate.getValue().toString()));
      } else {
        cstmt.setString(13, GlobalCC.upDateParseDate(this.coverToDate.getValue().toString()));
      }
      if (this.unitRateOption.getValue() == null) {
        cstmt.setString(14, null);
      } else {
        cstmt.setString(14, this.unitRateOption.getValue().toString());
      }
      if (this.effectiveDate.getValue() == null) {
        cstmt.setString(15, null);
      } else if (this.effectiveDate.getValue().toString().contains(":")) {
        cstmt.setString(15, GlobalCC.parseDate(this.effectiveDate.getValue().toString()));
      } else {
        cstmt.setString(15, GlobalCC.upDateParseDate(this.effectiveDate.getValue().toString()));
      }
      if (this.VAT.getValue() == null) {
        cstmt.setString(16, null);
      } else {
        cstmt.setDouble(16, Double.parseDouble(this.VAT.getValue().toString()));
      }
      if (this.ovrCommRate.getValue() == null) {
        cstmt.setString(17, null);
      } else {
        cstmt.setDouble(17, Double.parseDouble(this.ovrCommRate.getValue().toString()));
      }
      if (this.endrCommRate.getValue() == null) {
        cstmt.setString(18, null);
      } else {
        cstmt.setDouble(18, Double.parseDouble(this.endrCommRate.getValue().toString()));
      }
      if (this.endrPayMethod.getValue() == null) {
        cstmt.setString(19, null);
      } else {
        cstmt.setString(19, this.endrPayMethod.getValue().toString());
      }
      cstmt.setBigDecimal(20, (BigDecimal)this.session.getAttribute("agnCode"));
      
      cstmt.setString(21, (String)this.session.getAttribute("agnShtDesc"));
      if (this.durationTermType.getValue() == null) {
        cstmt.setString(22, null);
      } else {
        cstmt.setString(22, this.durationTermType.getValue().toString());
      }
      cstmt.setBigDecimal(23, (BigDecimal)this.session.getAttribute("mktCode"));
      if (this.jointAgent.isSelected()) {
        cstmt.setString(24, "Y");
      } else {
        cstmt.setString(24, "N");
      }
      if (this.singleGrpRates.getValue() == null) {
        cstmt.setString(25, null);
      } else {
        cstmt.setString(25, (String)this.singleGrpRates.getValue());
      }
      cstmt.setString(26, null);
      if (this.totalPremiumPaid.getValue() == null) {
        cstmt.setString(27, null);
      } else {
        cstmt.setString(27, this.totalPremiumPaid.getValue().toString());
      }
      if (this.totalClaimPaid.getValue() == null) {
        cstmt.setString(28, null);
      } else {
        cstmt.setString(28, this.totalClaimPaid.getValue().toString());
      }
      cstmt.setString(29, null);
      cstmt.setString(30, null);
      cstmt.setString(31, null);
      cstmt.setString(32, null);
      if (this.earnPrdType.getValue() != null) {
        cstmt.setString(33, this.earnPrdType.getValue().toString());
      } else {
        cstmt.setString(33, "A");
      }
      cstmt.setBigDecimal(34, (BigDecimal)this.session.getAttribute("sbuCode"));
      
      cstmt.setBigDecimal(35, (BigDecimal)this.session.getAttribute("spokeCode"));
      
      cstmt.setBigDecimal(36, (BigDecimal)this.session.getAttribute("coverageAreaCode"));
      
      cstmt.setBigDecimal(37, (BigDecimal)this.session.getAttribute("locationCode"));
      

      cstmt.execute();
      
      ADFUtils.findIterator("FindEndorsementsIterator").executeQuery();
      ADFUtils.findIterator("FindPoliciesIterator").executeQuery();
      ADFUtils.findIterator("FindPolicyFCLMembersIterator").executeQuery();
      
      ADFUtils.findIterator("FindPolicyMembersIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.policyMembersLOV);
      
      GlobalCC.INFORMATIONREPORTING("Endorsement Successfully Updated");
      conn.close();
      Result = "S";
    }
    catch (Exception ex)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, ex);
    }
    return Result;
  }
  
  public String findCoversSel()
  {
    try
    {
      DCIteratorBinding dciter = ADFUtils.findIterator("FindProductCoversIterator");
      
      RowKeySet set = this.productCoverTypesLOV.getSelectedRowKeys();
      
      Iterator rowKeySetIter = set.iterator();
      while (rowKeySetIter.hasNext())
      {
        List l = (List)rowKeySetIter.next();
        Key key = (Key)l.get(0);
        dciter.setCurrentRowWithKey(key.toStringFormat(true));
        Row r = dciter.getCurrentRow();
        
        this.session.setAttribute("CVT_CODE", r.getAttribute("cvt_code"));
        
        this.session.setAttribute("PCT_CODE", r.getAttribute("pct_code"));
        
        LOVCC.RefundFormular = (String)r.getAttribute("pct_refund_formular");
        
        LOVCC.CoverFormular = (String)r.getAttribute("pct_formular");
        this.coverDescDisplay.setValue(r.getAttribute("cvt_desc"));
        
        this.session.setAttribute("pcvtCode", null);
        if (this.calcType.getValue() == null)
        {
          this.sumAssuredDisplay.setRendered(false);
          this.saLabel.setRendered(false);
          this.avANB.setRendered(false);
          this.avANBLabel.setRendered(false);
        }
        else if (this.calcType.getValue().toString().equalsIgnoreCase("A"))
        {
          this.sumAssuredDisplay.setRendered(true);
          this.saLabel.setRendered(true);
          this.avANB.setRendered(true);
          this.avANBLabel.setRendered(true);
        }
        else
        {
          this.sumAssuredDisplay.setRendered(false);
          this.saLabel.setRendered(false);
          this.avANB.setRendered(true);
          this.avANBLabel.setRendered(true);
        }
        String CmainCover = (String)r.getAttribute("cvt_main_cover");
        if (CmainCover == null)
        {
          this.percMainCvtLabel.setRendered(false);
          this.percMainCvt.setRendered(false);
          this.mainCoverLabel.setRendered(false);
          this.mainCover.setRendered(false);
          this.percMainCvt.setValue(null);
          this.mainCover.setValue(null);
        }
        else if (CmainCover.equalsIgnoreCase("M"))
        {
          this.percMainCvtLabel.setRendered(false);
          this.percMainCvt.setRendered(false);
          this.mainCoverLabel.setRendered(false);
          this.mainCover.setRendered(false);
          this.percMainCvt.setValue(null);
          this.mainCover.setValue(null);
        }
        else
        {
          if (CmainCover.equalsIgnoreCase("RL")) {
            this.percMainCvtLabel.setValue("Multiple of Loan Repayment");
          } else {
            this.percMainCvtLabel.setValue("% of  Main/Yr Earn");
          }
          this.percMainCvtLabel.setRendered(true);
          this.percMainCvt.setRendered(true);
          this.mainCoverLabel.setRendered(true);
          this.mainCover.setRendered(true);
          this.percMainCvt.setValue(r.getAttribute("pct_main_sa_perc"));
          this.mainCover.setValue(r.getAttribute("cvt_main_cover"));
        }
        this.session.setAttribute("coverMaskCode", this.session.getAttribute("pmasCode"));
        
        this.maskDesc.setValue(this.session.getAttribute("pmasShtDesc"));
        
        this.rateSelection.setValue("M");
        this.maskButton.setDisabled(true);
        this.coverRate.setDisabled(true);
        this.coverRate.setValue(null);
        this.coverRateDivFactor.setDisabled(true);
        this.coverRateDivFactor.setValue(null);
        
        this.overridePremDisplay.setValue(null);
        this.sumAssuredDisplay.setValue(null);
        this.avANB.setValue(null);
        this.discLoadRateDisplay.setValue(null);
        this.divFactor.setValue(null);
        this.loadingTypeSelect.setValue("N");
        this.discChoice.setValue("N");
        this.discRateDisplay.setValue(null);
        this.discDivFactor.setValue(null);
        populatePremMasks((BigDecimal)r.getAttribute("pct_code"), (BigDecimal)r.getAttribute("cvt_code"));
        
        this.builtIn.setValue(r.getAttribute("pctInbuilt"));
        this.accelerator.setValue(r.getAttribute("pctAccelerator"));
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.coverDescDisplay);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.sumAssuredDisplay);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.overridePremDisplay);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.discLoadRateDisplay);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.loadingTypeSelect);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.builtIn);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.mainCover);
        ExtendedRenderKitService erkService = (ExtendedRenderKitService)Service.getService(FacesContext.getCurrentInstance().getRenderKit(), ExtendedRenderKitService.class);
        

        erkService.addScript(FacesContext.getCurrentInstance(), "var hints = {autodismissNever:false}; AdfPage.PAGE.findComponent('lmsgroup:ldcvrdtls').show(hints);");
      }
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
    return null;
  }
  
  public void populatePremMasks(BigDecimal pctCode, BigDecimal cvtCode)
  {
    Connection conn = null;
    try
    {
      conn = new DBConnector().getDatabaseConn();
      
      String query = "begin LMS_WEB_PKG_GRP.getDefaultMask(?,?,?,?,?); end;";
      

      CallableStatement cstmt = conn.prepareCall(query);
      cstmt.setBigDecimal(1, cvtCode);
      cstmt.setBigDecimal(2, pctCode);
      cstmt.registerOutParameter(3, 2);
      cstmt.registerOutParameter(4, 12);
      cstmt.registerOutParameter(5, 12);
      cstmt.execute();
      if (cstmt.getBigDecimal(3) != null)
      {
        this.session.setAttribute("pmasCode", cstmt.getBigDecimal(3));
        this.session.setAttribute("coverMaskCode", cstmt.getBigDecimal(3));
      }
      if (cstmt.getString(4) != null)
      {
        this.session.setAttribute("pmasShtDesc", cstmt.getString(4));
        this.maskDesc.setValue(cstmt.getString(4));
      }
      if (cstmt.getString(5) != null) {
        this.rateSelection.setValue(cstmt.getString(5));
      }
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.maskDesc);
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.rateSelection);
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
  }
  
  public String SaveProductCoverTypes()
  {
    String saveQuery = "BEGIN LMS_WEB_PKG_GRP.populate_policy_cover_types(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);END;";
    
    String RenewalArea = (String)this.session.getAttribute("RenewalArea");
    if (RenewalArea == null) {
      saveQuery = "BEGIN LMS_WEB_PKG_GRP.populate_policy_cover_types(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);END;";
    } else if (RenewalArea.equalsIgnoreCase("Y")) {
      saveQuery = "BEGIN LMS_WEB_PKG_GRP.populate_renpolicy_cover_types(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);END;";
    } else {
      saveQuery = "BEGIN LMS_WEB_PKG_GRP.populate_policy_cover_types(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);END;";
    }
    Connection conn = new DBConnector().getDatabaseConn();
    CallableStatement cstmt = null;
    try
    {
      cstmt = conn.prepareCall(saveQuery);
      cstmt.setBigDecimal(1, (BigDecimal)this.session.getAttribute("CVT_CODE"));
      
      cstmt.setBigDecimal(2, (BigDecimal)this.session.getAttribute("policyCode"));
      
      cstmt.setBigDecimal(3, (BigDecimal)this.session.getAttribute("endorsementCode"));
      if (this.loadingTypeSelect.getValue() == null) {
        cstmt.setString(4, null);
      } else {
        cstmt.setString(4, this.loadingTypeSelect.getValue().toString());
      }
      if (this.overridePremDisplay.getValue() == null) {
        cstmt.setString(5, null);
      } else {
        cstmt.setString(5, this.overridePremDisplay.getValue().toString());
      }
      if (this.discLoadRateDisplay.getValue() == null) {
        cstmt.setBigDecimal(6, null);
      } else {
        cstmt.setString(6, this.discLoadRateDisplay.getValue().toString());
      }
      if (this.sumAssuredDisplay.getValue() == null) {
        cstmt.setBigDecimal(7, null);
      } else {
        cstmt.setString(7, this.sumAssuredDisplay.getValue().toString());
      }
      if (this.avANB.getValue() == null) {
        cstmt.setBigDecimal(8, null);
      } else {
        cstmt.setString(8, this.avANB.getValue().toString());
      }
      cstmt.setBigDecimal(9, (BigDecimal)this.session.getAttribute("pcvtCode"));
      
      cstmt.setBigDecimal(10, null);
      cstmt.setBigDecimal(11, null);
      if (this.divFactor.getValue() == null) {
        cstmt.setBigDecimal(12, null);
      } else {
        cstmt.setString(12, this.divFactor.getValue().toString());
      }
      if (this.percMainCvt.getValue() == null) {
        cstmt.setBigDecimal(13, null);
      } else {
        cstmt.setString(13, this.percMainCvt.getValue().toString());
      }
      if (this.mainCover.getValue() == null) {
        cstmt.setBigDecimal(14, null);
      } else {
        cstmt.setString(14, this.mainCover.getValue().toString());
      }
      if (this.discChoice.getValue() == null) {
        cstmt.setBigDecimal(15, null);
      } else {
        cstmt.setString(15, this.discChoice.getValue().toString());
      }
      if (this.discRateDisplay.getValue() == null) {
        cstmt.setBigDecimal(16, null);
      } else {
        cstmt.setString(16, this.discRateDisplay.getValue().toString());
      }
      if (this.discDivFactor.getValue() == null) {
        cstmt.setBigDecimal(17, null);
      } else {
        cstmt.setString(17, this.discDivFactor.getValue().toString());
      }
      if (this.rateSelection.getValue() == null) {
        cstmt.setBigDecimal(18, null);
      } else {
        cstmt.setString(18, this.rateSelection.getValue().toString());
      }
      cstmt.setBigDecimal(19, (BigDecimal)this.session.getAttribute("coverMaskCode"));
      if (this.maskDesc.getValue() == null) {
        cstmt.setBigDecimal(20, null);
      } else {
        cstmt.setString(20, this.maskDesc.getValue().toString());
      }
      if (this.coverRate.getValue() == null) {
        cstmt.setBigDecimal(21, null);
      } else {
        cstmt.setString(21, this.coverRate.getValue().toString());
      }
      if (this.coverRateDivFactor.getValue() == null) {
        cstmt.setBigDecimal(22, null);
      } else {
        cstmt.setString(22, this.coverRateDivFactor.getValue().toString());
      }
      if (this.loadAgeFactorTF.getValue() == null) {
        cstmt.setBigDecimal(23, null);
      } else {
        cstmt.setString(23, this.loadAgeFactorTF.getValue().toString());
      }
      if (this.builtIn.getValue() == null) {
        cstmt.setString(24, null);
      } else {
        cstmt.setString(24, this.builtIn.getValue().toString());
      }
      if (this.accelerator.getValue() == null) {
        cstmt.setString(25, null);
      } else {
        cstmt.setString(25, this.accelerator.getValue().toString());
      }
      cstmt.execute();
      
      this.session.setAttribute("pcvtCode", null);
      ADFUtils.findIterator("FindPureRateLoadingsIterator").executeQuery();
      ADFUtils.findIterator("FindCoverTypesIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.policyCoversLOV);
      conn.close();
    }
    catch (Exception ex)
    {
      this.session.setAttribute("pcvtCode", null);
      GlobalCC.EXCEPTIONREPORTING(conn, ex);
    }
    return null;
  }
  
  public String editPolCoverType()
  {
    DCIteratorBinding dciter = ADFUtils.findIterator("FindCoverTypesIterator");
    
    RowKeySet set = this.policyCoversLOV.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();
    while (rowKeySetIter.hasNext())
    {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();
      

      this.session.setAttribute("pcvtCode", r.getAttribute("PCVT_CODE"));
      
      this.session.setAttribute("CVT_CODE", r.getAttribute("PCVT_CVT_CODE"));
      
      this.coverDescDisplay.setValue(r.getAttribute("PCVT_CVT_SHT_DESC"));
      this.overridePremDisplay.setValue(r.getAttribute("PCVT_BUT_CHARGE_PREMIUM"));
      this.sumAssuredDisplay.setValue(r.getAttribute("PCVT_SA"));
      this.loadingTypeSelect.setValue(r.getAttribute("PCVT_LOAD_DISC"));
      this.discLoadRateDisplay.setValue(r.getAttribute("PCVT_DISC_LOAD_RATE"));
      this.divFactor.setValue(r.getAttribute("PCVT_DISC_LOAD_DIV_FACT"));
      this.avANB.setValue(r.getAttribute("PCVT_AVG_ANB"));
      this.discChoice.setValue(r.getAttribute("PCVT_DISC"));
      this.discRateDisplay.setValue(r.getAttribute("PCVT_DISC_RATE"));
      this.discDivFactor.setValue(r.getAttribute("PCVT_DISC_DIV_FACT"));
      
      this.percMainCvtLabel.setRendered(true);
      this.percMainCvt.setRendered(true);
      this.mainCoverLabel.setRendered(true);
      this.mainCover.setRendered(true);
      this.percMainCvt.setValue(r.getAttribute("PCVT_MAIN_SA_PERC"));
      this.mainCover.setValue(r.getAttribute("PCVT_MAIN_COVER"));
      
      this.session.setAttribute("coverMaskCode", r.getAttribute("pcvt_pmas_code"));
      
      this.rateSelection.setValue(r.getAttribute("pcvt_use_cvr_rate"));
      if (r.getAttribute("pcvt_use_cvr_rate") == null)
      {
        this.maskButton.setDisabled(true);
        this.coverRate.setDisabled(true);
        this.coverRateDivFactor.setDisabled(true);
      }
      else
      {
        String Val = (String)r.getAttribute("pcvt_use_cvr_rate");
        if (Val.equalsIgnoreCase("M"))
        {
          this.maskButton.setDisabled(true);
          this.coverRate.setDisabled(true);
          this.coverRateDivFactor.setDisabled(true);
        }
        else if (Val.equalsIgnoreCase("S"))
        {
          this.maskButton.setDisabled(false);
          this.coverRate.setDisabled(true);
          this.coverRateDivFactor.setDisabled(true);
        }
        else if (Val.equalsIgnoreCase("C"))
        {
          this.maskButton.setDisabled(true);
          this.coverRate.setDisabled(false);
          this.coverRateDivFactor.setDisabled(false);
        }
      }
      this.maskDesc.setValue(r.getAttribute("pcvt_pmas_sht_desc"));
      this.coverRate.setValue(r.getAttribute("pcvt_rate"));
      this.coverRateDivFactor.setValue(r.getAttribute("pcvt_rate_div_fact"));
      this.builtIn.setValue(r.getAttribute("pcvtPctInbuilt"));
      this.accelerator.setValue(r.getAttribute("pcvtAccelerator"));
      if (this.calcType.getValue() == null)
      {
        this.sumAssuredDisplay.setRendered(false);
        this.saLabel.setRendered(false);
        this.avANB.setRendered(false);
        this.avANBLabel.setRendered(false);
      }
      else if (this.calcType.getValue().toString().equalsIgnoreCase("A"))
      {
        this.sumAssuredDisplay.setRendered(true);
        this.saLabel.setRendered(true);
        this.avANB.setRendered(true);
        this.avANBLabel.setRendered(true);
      }
      else
      {
        this.sumAssuredDisplay.setRendered(false);
        this.saLabel.setRendered(false);
        this.avANB.setRendered(true);
        this.avANBLabel.setRendered(true);
      }
      ExtendedRenderKitService erkService = (ExtendedRenderKitService)Service.getService(FacesContext.getCurrentInstance().getRenderKit(), ExtendedRenderKitService.class);
      

      erkService.addScript(FacesContext.getCurrentInstance(), "var hints = {autodismissNever:false}; AdfPage.PAGE.findComponent('lmsgroup:ldcvrdtls').show(hints);");
    }
    return null;
  }
  
  public String ShowMembersForExport()
  {
    try
    {
      ADFUtils.findIterator("FindMembersForExportIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.membersExportLOV);
      
      GlobalCC.showPopup("lmsgroup:p1");
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
    return null;
  }
  
  public String ShowCoverDetails()
  {
    try
    {
      GlobalCC.RedirectPage("/coverdtls.jspx");
    }
    catch (Exception ex)
    {
      GlobalCC.EXCEPTIONREPORTING(null, ex);
    }
    return null;
  }
  
  public String ViewMemberForImport()
  {
    try
    {
      GlobalCC.RedirectPage("/members_import.jspx");
    }
    catch (Exception ex)
    {
      GlobalCC.EXCEPTIONREPORTING(null, ex);
    }
    return null;
  }
  
  public void setEndrTotSA(RichOutputText endrTotSA)
  {
    this.endrTotSA = endrTotSA;
  }
  
  public RichOutputText getEndrTotSA()
  {
    return this.endrTotSA;
  }
  
  public void setEndrTotPremium(RichOutputText endrTotPremium)
  {
    this.endrTotPremium = endrTotPremium;
  }
  
  public RichOutputText getEndrTotPremium()
  {
    return this.endrTotPremium;
  }
  
  public void setEndrCommRate(RichInputText endrCommRate)
  {
    this.endrCommRate = endrCommRate;
  }
  
  public RichInputText getEndrCommRate()
  {
    return this.endrCommRate;
  }
  
  public void setEndrInstPremium(RichInputText endrInstPremium)
  {
    this.endrInstPremium = endrInstPremium;
  }
  
  public RichInputText getEndrInstPremium()
  {
    return this.endrInstPremium;
  }
  
  public void setEndrCommAmt(RichInputText endrCommAmt)
  {
    this.endrCommAmt = endrCommAmt;
  }
  
  public RichInputText getEndrCommAmt()
  {
    return this.endrCommAmt;
  }
  
  public void setProductsLOV(RichTable productsLOV)
  {
    this.productsLOV = productsLOV;
  }
  
  public RichTable getProductsLOV()
  {
    return this.productsLOV;
  }
  
  public void setProductDisplay(RichInputText productDisplay)
  {
    this.productDisplay = productDisplay;
  }
  
  public RichInputText getProductDisplay()
  {
    return this.productDisplay;
  }
  
  public String AttachProducts()
  {
    return null;
  }
  
  public void setProductCoverTypesLOV(RichTable productCoverTypesLOV)
  {
    this.productCoverTypesLOV = productCoverTypesLOV;
  }
  
  public RichTable getProductCoverTypesLOV()
  {
    return this.productCoverTypesLOV;
  }
  
  public void setCoverDescDisplay(RichInputText coverDescDisplay)
  {
    this.coverDescDisplay = coverDescDisplay;
  }
  
  public RichInputText getCoverDescDisplay()
  {
    return this.coverDescDisplay;
  }
  
  public void setOverridePremDisplay(RichInputText overridePremDisplay)
  {
    this.overridePremDisplay = overridePremDisplay;
  }
  
  public RichInputText getOverridePremDisplay()
  {
    return this.overridePremDisplay;
  }
  
  public void setSumAssuredDisplay(RichInputText sumAssuredDisplay)
  {
    this.sumAssuredDisplay = sumAssuredDisplay;
  }
  
  public RichInputText getSumAssuredDisplay()
  {
    return this.sumAssuredDisplay;
  }
  
  public void setLoadingTypeSelect(RichSelectOneChoice loadingTypeSelect)
  {
    this.loadingTypeSelect = loadingTypeSelect;
  }
  
  public RichSelectOneChoice getLoadingTypeSelect()
  {
    return this.loadingTypeSelect;
  }
  
  public void setDiscLoadRateDisplay(RichInputText discLoadRateDisplay)
  {
    this.discLoadRateDisplay = discLoadRateDisplay;
  }
  
  public RichInputText getDiscLoadRateDisplay()
  {
    return this.discLoadRateDisplay;
  }
  
  public void setEdCoverlabel(RichOutputText edCoverlabel)
  {
    this.edCoverlabel = edCoverlabel;
  }
  
  public RichOutputText getEdCoverlabel()
  {
    return this.edCoverlabel;
  }
  
  public void setEdcoverButChargePremium(RichInputText edcoverButChargePremium)
  {
    this.edcoverButChargePremium = edcoverButChargePremium;
  }
  
  public RichInputText getEdcoverButChargePremium()
  {
    return this.edcoverButChargePremium;
  }
  
  public void setEddiscLoadChoice(RichSelectOneChoice eddiscLoadChoice)
  {
    this.eddiscLoadChoice = eddiscLoadChoice;
  }
  
  public RichSelectOneChoice getEddiscLoadChoice()
  {
    return this.eddiscLoadChoice;
  }
  
  public void setEddiscLoadRateDisplay(RichInputText eddiscLoadRateDisplay)
  {
    this.eddiscLoadRateDisplay = eddiscLoadRateDisplay;
  }
  
  public RichInputText getEddiscLoadRateDisplay()
  {
    return this.eddiscLoadRateDisplay;
  }
  
  public void setEndrTotalSA(RichInputText endrTotalSA)
  {
    this.endrTotalSA = endrTotalSA;
  }
  
  public RichInputText getEndrTotalSA()
  {
    return this.endrTotalSA;
  }
  
  public void setEndrTotPremium2(RichInputText endrTotPremium2)
  {
    this.endrTotPremium2 = endrTotPremium2;
  }
  
  public RichInputText getEndrTotPremium2()
  {
    return this.endrTotPremium2;
  }
  
  public void setAvANB(RichInputText avANB)
  {
    this.avANB = avANB;
  }
  
  public RichInputText getAvANB()
  {
    return this.avANB;
  }
  
  public void setAvANBLabel(RichOutputLabel avANBLabel)
  {
    this.avANBLabel = avANBLabel;
  }
  
  public RichOutputLabel getAvANBLabel()
  {
    return this.avANBLabel;
  }
  
  public void setSaLabel(RichOutputLabel saLabel)
  {
    this.saLabel = saLabel;
  }
  
  public RichOutputLabel getSaLabel()
  {
    return this.saLabel;
  }
  
  public void setCalcType(RichSelectOneChoice calcType)
  {
    this.calcType = calcType;
  }
  
  public RichSelectOneChoice getCalcType()
  {
    return this.calcType;
  }
  
  public void setDurationType(RichSelectOneChoice durationType)
  {
    this.durationType = durationType;
  }
  
  public RichSelectOneChoice getDurationType()
  {
    return this.durationType;
  }
  
  public void setPayFreq(RichSelectOneChoice payFreq)
  {
    this.payFreq = payFreq;
  }
  
  public RichSelectOneChoice getPayFreq()
  {
    return this.payFreq;
  }
  
  public void calcListener(ValueChangeEvent valueChangeEvent)
  {
    String Calc = null;
    if (this.calcType.getValue() != null)
    {
      Calc = this.calcType.getValue().toString();
      if (Calc.equalsIgnoreCase("A"))
      {
        String polClac = (String)this.session.getAttribute("PolCalcType");
        if (polClac.equalsIgnoreCase("D"))
        {
          this.calcType.setValue("D");
          AdfFacesContext.getCurrentInstance().addPartialTarget(this.calcType);
          String Message = "Policy Cannot be Changed from Detailed to Aggregate";
          
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Message, Message));
        }
      }
    }
  }
  
  public void durationTypeListener(ValueChangeEvent valueChangeEvent)
  {
    try
    {
      if (this.durationType.getValue() == null) {}
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.effectiveDate);
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.coverToDate);
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
  }
  
  public String saveDurationType(String DType)
  {
    Connection conn = null;
    try
    {
      String deleteQuery = "BEGIN LMS_WEB_PKG_GRP_UW.endorsement_duration_change(?,?,?,?);END;";
      
      conn = new DBConnector().getDatabaseConn();
      CallableStatement cstmt = conn.prepareCall(deleteQuery);
      cstmt.setBigDecimal(1, (BigDecimal)this.session.getAttribute("endorsementCode"));
      if (DType.equalsIgnoreCase("C")) {
        cstmt.setString(2, GlobalCC.parseDate(this.wetDate.getValue().toString()));
      } else {
        cstmt.setString(2, null);
      }
      cstmt.setString(3, DType);
      cstmt.registerOutParameter(4, 91);
      cstmt.execute();
      ADFUtils.findIterator("FindCoverTypesIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.policyCoversLOV);
      ADFUtils.findIterator("FindEndorsementsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.coverToDate);
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
  }
  
  public String saveWETDate()
  {
    try
    {
      if (this.wetDate.getValue() == null)
      {
        String Message = "Select A WET Date";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Message, Message));
        



        return null;
      }
      saveDurationType("C");
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
    return null;
  }
  
  public void setUsersLOV(RichTable usersLOV)
  {
    this.usersLOV = usersLOV;
  }
  
  public RichTable getUsersLOV()
  {
    return this.usersLOV;
  }
  
  public void setUnitRateOption(RichSelectOneChoice unitRateOption)
  {
    this.unitRateOption = unitRateOption;
  }
  
  public RichSelectOneChoice getUnitRateOption()
  {
    return this.unitRateOption;
  }
  
  public void setVAT(RichInputNumberSpinbox VAT)
  {
    this.VAT = VAT;
  }
  
  public RichInputNumberSpinbox getVAT()
  {
    return this.VAT;
  }
  
  public void setExceptionsLOV(RichTable exceptionsLOV)
  {
    this.exceptionsLOV = exceptionsLOV;
  }
  
  public RichTable getExceptionsLOV()
  {
    return this.exceptionsLOV;
  }
  
  public void setPolStatus(RichOutputText polStatus)
  {
    this.polStatus = polStatus;
  }
  
  public RichOutputText getPolStatus()
  {
    return this.polStatus;
  }
  
  public void setWetDate(RichInputDate wetDate)
  {
    this.wetDate = wetDate;
  }
  
  public RichInputDate getWetDate()
  {
    return this.wetDate;
  }
  
  public void setCoverToDate(RichInputDate coverToDate)
  {
    this.coverToDate = coverToDate;
  }
  
  public RichInputDate getCoverToDate()
  {
    return this.coverToDate;
  }
  
  public void setMaleRtAge(RichInputText maleRtAge)
  {
    this.maleRtAge = maleRtAge;
  }
  
  public RichInputText getMaleRtAge()
  {
    return this.maleRtAge;
  }
  
  public void setFemaleRtAge(RichInputText femaleRtAge)
  {
    this.femaleRtAge = femaleRtAge;
  }
  
  public RichInputText getFemaleRtAge()
  {
    return this.femaleRtAge;
  }
  
  public void setMembersExportLOV(RichTable membersExportLOV)
  {
    this.membersExportLOV = membersExportLOV;
  }
  
  public RichTable getMembersExportLOV()
  {
    return this.membersExportLOV;
  }
  
  public void setDivFactor(RichInputText divFactor)
  {
    this.divFactor = divFactor;
  }
  
  public RichInputText getDivFactor()
  {
    return this.divFactor;
  }
  
  public void setOverrideMed(RichSelectBooleanCheckbox overrideMed)
  {
    this.overrideMed = overrideMed;
  }
  
  public RichSelectBooleanCheckbox getOverrideMed()
  {
    return this.overrideMed;
  }
  
  public void CheckOverrideMedicals(ValueChangeEvent valueChangeEvent)
  {
    if (this.overrideMed.isSelected()) {
      this.session.setAttribute("OverrideMedicals", "Y");
    } else {
      this.session.setAttribute("OverrideMedicals", "N");
    }
  }
  
  public void setPensCommRate(RichInputText pensCommRate)
  {
    this.pensCommRate = pensCommRate;
  }
  
  public RichInputText getPensCommRate()
  {
    return this.pensCommRate;
  }
  
  public void setPensionCommRate(RichInputText pensionCommRate)
  {
    this.pensionCommRate = pensionCommRate;
  }
  
  public RichInputText getPensionCommRate()
  {
    return this.pensionCommRate;
  }
  
  public String EffectCoinsurance()
  {
    String coinsuranceQuery = "BEGIN LMS_GRP_MISC.mark_policy_coinsurance(?,?,?,?); END;";
    
    Connection conn = new DBConnector().getDatabaseConn();
    try
    {
      CallableStatement cstmt = conn.prepareCall(coinsuranceQuery);
      cstmt.setBigDecimal(1, (BigDecimal)this.session.getAttribute("endorsementCode"));
      if (this.polCoinsuranceBusiness.getValue() == null) {
        cstmt.setString(2, null);
      } else {
        cstmt.setString(2, this.polCoinsuranceBusiness.getValue().toString());
      }
      if (this.polCoinLeaderFollower.getValue() == null) {
        cstmt.setString(3, null);
      } else {
        cstmt.setString(3, this.polCoinLeaderFollower.getValue().toString());
      }
      if (this.coinLeaderShare.getValue() == null) {
        cstmt.setString(4, this.coinLeaderShare.getValue().toString());
      } else {
        cstmt.setString(4, this.coinLeaderShare.getValue().toString());
      }
      cstmt.execute();
      conn.close();
      GlobalCC.sysInformation("Policy marked as coinsurance Successfully");
      ADFUtils.findIterator("FindPolicyCoinsurersIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.polCoinsurersLOV);
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    ADFUtils.findIterator("FindEndorsementsIterator").executeQuery();
    ADFUtils.findIterator("FindPoliciesIterator").executeQuery();
    


    return null;
  }
  
  public String AttachAgents()
  {
    DCIteratorBinding dciter = ADFUtils.findIterator("FindAgentsIterator");
    RowKeySet set = this.agentDisplayLOV.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();
    while (rowKeySetIter.hasNext())
    {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();
      
      this.session.setAttribute("agnCode", r.getAttribute("AGN_CODE"));
      
      this.session.setAttribute("agnShtDesc", r.getAttribute("AGN_SHT_DESC"));
      
      this.session.setAttribute("agnName", r.getAttribute("AGN_NAME"));
      
      this.agentsDisplay.setValue(r.getAttribute("AGN_NAME"));
    }
    return null;
  }
  
  public String AttachJointAgents()
  {
    DCIteratorBinding dciter = ADFUtils.findIterator("FindAgentsIterator");
    RowKeySet set = this.jointAgentsTable.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();
    while (rowKeySetIter.hasNext())
    {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();
      
      this.session.setAttribute("JointagnCode", r.getAttribute("AGN_CODE"));
      
      this.jointAgentDesc.setValue(r.getAttribute("AGN_NAME"));
      
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.jointAgentDesc);
      
      GlobalCC.hidePopup("lmsgroup:popup8");
    }
    return null;
  }
  
  public void setPolCoinsuranceBusiness(RichSelectOneChoice polCoinsuranceBusiness)
  {
    this.polCoinsuranceBusiness = polCoinsuranceBusiness;
  }
  
  public RichSelectOneChoice getPolCoinsuranceBusiness()
  {
    return this.polCoinsuranceBusiness;
  }
  
  public void setPolCoinLeaderFollower(RichSelectOneChoice polCoinLeaderFollower)
  {
    this.polCoinLeaderFollower = polCoinLeaderFollower;
  }
  
  public RichSelectOneChoice getPolCoinLeaderFollower()
  {
    return this.polCoinLeaderFollower;
  }
  
  public void unitRateOptionListener(ValueChangeEvent valueChangeEvent)
  {
    if ((this.unitRateOption.getValue() != null) && 
      (this.unitRateOption.getValue().toString().equalsIgnoreCase("RATE"))) {
      GlobalCC.showPopup("lmsgroup:unitRatesPopup");
    }
  }
  
  public void DelExistingMemberListener(ValueChangeEvent valueChangeEvent)
  {
    if (this.delMemCover.isSelected()) {
      this.session.setAttribute("delExistMembers", "Y");
    } else {
      this.session.setAttribute("delExistMembers", "N");
    }
  }
  
  public void setDelMemCover(RichSelectBooleanCheckbox delMemCover)
  {
    this.delMemCover = delMemCover;
  }
  
  public RichSelectBooleanCheckbox getDelMemCover()
  {
    return this.delMemCover;
  }
  
  public void setAgentDisplayLOV(RichTable agentDisplayLOV)
  {
    this.agentDisplayLOV = agentDisplayLOV;
  }
  
  public RichTable getAgentDisplayLOV()
  {
    return this.agentDisplayLOV;
  }
  
  public void setAgentsDisplay(RichInputText agentsDisplay)
  {
    this.agentsDisplay = agentsDisplay;
  }
  
  public RichInputText getAgentsDisplay()
  {
    return this.agentsDisplay;
  }
  
  public void setCoverFromDate(RichInputDate coverFromDate)
  {
    this.coverFromDate = coverFromDate;
  }
  
  public RichInputDate getCoverFromDate()
  {
    return this.coverFromDate;
  }
  
  public void setMainCoverLabel(RichOutputLabel mainCoverLabel)
  {
    this.mainCoverLabel = mainCoverLabel;
  }
  
  public RichOutputLabel getMainCoverLabel()
  {
    return this.mainCoverLabel;
  }
  
  public void setMainCover(RichSelectOneChoice mainCover)
  {
    this.mainCover = mainCover;
  }
  
  public RichSelectOneChoice getMainCover()
  {
    return this.mainCover;
  }
  
  public void setPercMainCvtLabel(RichOutputLabel percMainCvtLabel)
  {
    this.percMainCvtLabel = percMainCvtLabel;
  }
  
  public RichOutputLabel getPercMainCvtLabel()
  {
    return this.percMainCvtLabel;
  }
  
  public void setPercMainCvt(RichInputText percMainCvt)
  {
    this.percMainCvt = percMainCvt;
  }
  
  public RichInputText getPercMainCvt()
  {
    return this.percMainCvt;
  }
  
  public void setEndrNo(RichInputText endrNo)
  {
    this.endrNo = endrNo;
  }
  
  public RichInputText getEndrNo()
  {
    return this.endrNo;
  }
  
  public void setSpacer1(RichSpacer spacer1)
  {
    this.spacer1 = spacer1;
  }
  
  public RichSpacer getSpacer1()
  {
    return this.spacer1;
  }
  
  public void setPolicyDetailPanel(HtmlPanelGrid policyDetailPanel)
  {
    this.policyDetailPanel = policyDetailPanel;
  }
  
  public HtmlPanelGrid getPolicyDetailPanel()
  {
    return this.policyDetailPanel;
  }
  
  public void setEditSaveButton(RichCommandButton editSaveButton)
  {
    this.editSaveButton = editSaveButton;
  }
  
  public RichCommandButton getEditSaveButton()
  {
    return this.editSaveButton;
  }
  
  public void setCancelSaveButton(RichCommandButton cancelSaveButton)
  {
    this.cancelSaveButton = cancelSaveButton;
  }
  
  public RichCommandButton getCancelSaveButton()
  {
    return this.cancelSaveButton;
  }
  
  public void setEffectiveDate(RichInputDate effectiveDate)
  {
    this.effectiveDate = effectiveDate;
  }
  
  public RichInputDate getEffectiveDate()
  {
    return this.effectiveDate;
  }
  
  public void setDurationTermType(RichSelectOneChoice durationTermType)
  {
    this.durationTermType = durationTermType;
  }
  
  public RichSelectOneChoice getDurationTermType()
  {
    return this.durationTermType;
  }
  
  public void setRenStatus(RichSelectOneChoice renStatus)
  {
    this.renStatus = renStatus;
  }
  
  public RichSelectOneChoice getRenStatus()
  {
    return this.renStatus;
  }
  
  public void setPolicyNo(RichOutputText policyNo)
  {
    this.policyNo = policyNo;
  }
  
  public RichOutputText getPolicyNo()
  {
    return this.policyNo;
  }
  
  public void setCoLeadFollow(RichSelectOneChoice coLeadFollow)
  {
    this.coLeadFollow = coLeadFollow;
  }
  
  public RichSelectOneChoice getCoLeadFollow()
  {
    return this.coLeadFollow;
  }
  
  public void coinsFollowerBusiness(ValueChangeEvent valueChangeEvent)
  {
    if (this.coLeadFollow.getValue() != null) {
      if (this.coLeadFollow.getValue().toString().equalsIgnoreCase("L"))
      {
        this.session.setAttribute("FollowerBusiness", "L");
        this.premProvCbox.setRendered(false);
        this.premProvLabel.setRendered(false);
        this.premProvCbox.setSelected(false);
        this.ldrCombined.setRendered(true);
        this.ldrCombinedLabel.setRendered(true);
      }
      else
      {
        this.session.setAttribute("FollowerBusiness", "F");
        this.premProvCbox.setRendered(true);
        this.premProvLabel.setRendered(true);
        this.premProvCbox.setSelected(false);
        this.ldrCombined.setRendered(false);
        this.ldrCombinedLabel.setRendered(false);
      }
    }
  }
  
  public void setLeaderShare(RichInputNumberSpinbox leaderShare)
  {
    this.leaderShare = leaderShare;
  }
  
  public RichInputNumberSpinbox getLeaderShare()
  {
    return this.leaderShare;
  }
  
  public void setLdrCombined(RichSelectBooleanCheckbox ldrCombined)
  {
    this.ldrCombined = ldrCombined;
  }
  
  public RichSelectBooleanCheckbox getLdrCombined()
  {
    return this.ldrCombined;
  }
  
  public void setPremProvLabel(RichOutputLabel premProvLabel)
  {
    this.premProvLabel = premProvLabel;
  }
  
  public RichOutputLabel getPremProvLabel()
  {
    return this.premProvLabel;
  }
  
  public void setPremProvCbox(RichSelectBooleanCheckbox premProvCbox)
  {
    this.premProvCbox = premProvCbox;
  }
  
  public RichSelectBooleanCheckbox getPremProvCbox()
  {
    return this.premProvCbox;
  }
  
  public String SaveCoinsurerShare()
  {
    if (this.leaderShare.getValue() == null)
    {
      String Message = "Enter a Share Percentage";
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Message, Message));
      


      return null;
    }
    if (this.coLeadFollow.getValue() == null)
    {
      String Message = "Select A Leader / Follower";
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Message, Message));
      


      return null;
    }
    String computeQuery = "BEGIN LMS_WEB_PKG_GRP.update_leader_share(?,?,?,?,?,?);END;";
    
    Connection conn = new DBConnector().getDatabaseConn();
    CallableStatement cstmt = null;
    try
    {
      cstmt = conn.prepareCall(computeQuery);
      cstmt.setBigDecimal(1, (BigDecimal)this.session.getAttribute("endorsementCode"));
      
      cstmt.setString(2, this.leaderShare.getValue().toString());
      cstmt.setString(3, this.coLeadFollow.getValue().toString());
      cstmt.setString(4, (String)this.session.getAttribute("CurrentStatus"));
      if (this.premProvCbox.isSelected()) {
        cstmt.setString(5, "Y");
      } else {
        cstmt.setString(5, "N");
      }
      if (this.ldrCombined.isSelected()) {
        cstmt.setString(6, "Y");
      } else {
        cstmt.setString(6, "N");
      }
      cstmt.execute();
      conn.close();
      GlobalCC.sysInformation("Coinsurer Share Saved");
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
  }
  
  public void setLdrCombinedLabel(RichOutputLabel ldrCombinedLabel)
  {
    this.ldrCombinedLabel = ldrCombinedLabel;
  }
  
  public RichOutputLabel getLdrCombinedLabel()
  {
    return this.ldrCombinedLabel;
  }
  
  public String AddNewJointAgent()
  {
    this.session.setAttribute("action", "A");
    this.session.setAttribute("jointAgentCode", null);
    this.session.setAttribute("JointagnCode", null);
    this.jointAgentDesc.setValue(null);
    this.agentShare.setValue(null);
    
    GlobalCC.showPopup("lmsgroup:jointAgentPopup");
    
    return null;
  }
  
  public String EditJointAgent()
  {
    try
    {
      DCIteratorBinding dciter = ADFUtils.findIterator("FindEndorsementJointAgentsIterator");
      
      RowKeySet set = this.endrAgentsTable.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      while (rowKeySetIter.hasNext())
      {
        List l = (List)rowKeySetIter.next();
        Key key = (Key)l.get(0);
        dciter.setCurrentRowWithKey(key.toStringFormat(true));
        Row r = dciter.getCurrentRow();
        this.session.setAttribute("jointAgentCode", r.getAttribute("joi_code"));
        
        this.session.setAttribute("JointagnCode", r.getAttribute("joi_agn_code"));
        
        this.jointAgentDesc.setValue(r.getAttribute("agn_name"));
        this.agentShare.setValue(r.getAttribute("joi_sub_agent_share"));
        
        this.session.setAttribute("action", "E");
        

        GlobalCC.showPopup("lmsgroup:jointAgentPopup");
      }
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
    return null;
  }
  
  public String DeleteJointAgent()
  {
    try
    {
      DCIteratorBinding dciter = ADFUtils.findIterator("FindEndorsementJointAgentsIterator");
      
      RowKeySet set = this.endrAgentsTable.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      while (rowKeySetIter.hasNext())
      {
        List l = (List)rowKeySetIter.next();
        Key key = (Key)l.get(0);
        dciter.setCurrentRowWithKey(key.toStringFormat(true));
        Row r = dciter.getCurrentRow();
        this.session.setAttribute("jointAgentCode", r.getAttribute("joi_code"));
        
        this.session.setAttribute("JointagnCode", r.getAttribute("joi_agn_code"));
        
        this.jointAgentDesc.setValue(r.getAttribute("agn_name"));
        this.agentShare.setValue(r.getAttribute("joi_sub_agent_share"));
        
        this.session.setAttribute("action", "D");
        
        SaveJointAgent();
      }
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
    return null;
  }
  
  public String SaveJointAgent()
  {
    Connection conn = null;
    try
    {
      String Action = (String)this.session.getAttribute("action");
      if ((Action.equalsIgnoreCase("A")) || (Action.equalsIgnoreCase("E")))
      {
        if (this.session.getAttribute("JointagnCode") == null)
        {
          GlobalCC.INFORMATIONREPORTING("Select An Agent");
          return null;
        }
        if (this.agentShare.getValue() == null)
        {
          GlobalCC.INFORMATIONREPORTING("Enter An Agent Share Percentage");
          return null;
        }
      }
      String computeQuery = "BEGIN LMS_WEB_PKG_GRP.save_joint_agents(?,?,?,?,?,?);END;";
      
      conn = new DBConnector().getDatabaseConn();
      CallableStatement cstmt = null;
      cstmt = conn.prepareCall(computeQuery);
      
      cstmt.setString(1, (String)this.session.getAttribute("action"));
      cstmt.setBigDecimal(2, (BigDecimal)this.session.getAttribute("jointAgentCode"));
      
      cstmt.setBigDecimal(3, (BigDecimal)this.session.getAttribute("endorsementCode"));
      
      cstmt.setBigDecimal(4, (BigDecimal)this.session.getAttribute("policyCode"));
      
      cstmt.setBigDecimal(5, (BigDecimal)this.session.getAttribute("JointagnCode"));
      if (this.agentShare.getValue() == null) {
        cstmt.setString(6, null);
      } else {
        cstmt.setString(6, this.agentShare.getValue().toString());
      }
      cstmt.execute();
      cstmt.close();
      conn.close();
      
      ADFUtils.findIterator("FindEndorsementJointAgentsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.endrAgentsTable);
      
      GlobalCC.INFORMATIONREPORTING("Transaction Successfully Completed");
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
  }
  
  public String SaveLeadAgentShare()
  {
    Connection conn = null;
    try
    {
      String computeQuery = "BEGIN LMS_WEB_PKG_GRP.update_joint_agent_share(?,?,?);END;";
      
      conn = new DBConnector().getDatabaseConn();
      CallableStatement cstmt = null;
      cstmt = conn.prepareCall(computeQuery);
      
      cstmt.setBigDecimal(1, (BigDecimal)this.session.getAttribute("endorsementCode"));
      
      cstmt.setString(2, "Y");
      if (this.leadAgentShare.getValue() == null) {
        cstmt.setString(3, null);
      } else {
        cstmt.setString(3, this.leadAgentShare.getValue().toString());
      }
      cstmt.execute();
      cstmt.close();
      conn.close();
      
      GlobalCC.INFORMATIONREPORTING("Transaction Successfully Completed");
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
  }
  
  public String AddNewCoinsurer()
  {
    this.session.setAttribute("pol_coin_code", null);
    this.addCoinsurerDisplay.setValue(null);
    this.sharePercentageDisplay.setValue(null);
    this.adminFeeDisplay.setValue(null);
    
    GlobalCC.showPopup("lmsgroup:addCoinsurerPopup");
    
    return null;
  }
  
  public void setAddCoinsurerDisplay(RichInputText addCoinsurerDisplay)
  {
    this.addCoinsurerDisplay = addCoinsurerDisplay;
  }
  
  public RichInputText getAddCoinsurerDisplay()
  {
    return this.addCoinsurerDisplay;
  }
  
  public void setAvaibaleCoinsurersLOV(RichTable avaibaleCoinsurersLOV)
  {
    this.avaibaleCoinsurersLOV = avaibaleCoinsurersLOV;
  }
  
  public RichTable getAvaibaleCoinsurersLOV()
  {
    return this.avaibaleCoinsurersLOV;
  }
  
  public String GetSelectedCoinsurer()
  {
    DCIteratorBinding dciter = ADFUtils.findIterator("FindCoinsurersIterator");
    
    RowKeySet set = this.avaibaleCoinsurersLOV.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();
    while (rowKeySetIter.hasNext())
    {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();
      
      this.session.setAttribute("coin_agn_code", r.getAttribute("CO_agn_code"));
      
      this.addCoinsurerDisplay.setValue(r.getAttribute("CO_agn_name"));
      System.out.println("upendo " + (BigDecimal)this.session.getAttribute("coin_agn_code"));
      

      AdfFacesContext.getCurrentInstance().addPartialTarget(this.addCoinsurerDisplay);
      
      GlobalCC.hidePopup("lmsgroup:coinsurersPopup");
    }
    return null;
  }
  
  public void setSharePercentageDisplay(RichInputText sharePercentageDisplay)
  {
    this.sharePercentageDisplay = sharePercentageDisplay;
  }
  
  public RichInputText getSharePercentageDisplay()
  {
    return this.sharePercentageDisplay;
  }
  
  public void setAdminFeeDisplay(RichInputText adminFeeDisplay)
  {
    this.adminFeeDisplay = adminFeeDisplay;
  }
  
  public RichInputText getAdminFeeDisplay()
  {
    return this.adminFeeDisplay;
  }
  
  public void setLaFollowerBusiness(RichSelectOneChoice laFollowerBusiness)
  {
    this.laFollowerBusiness = laFollowerBusiness;
  }
  
  public RichSelectOneChoice getLaFollowerBusiness()
  {
    return this.laFollowerBusiness;
  }
  
  public String SaveAddedCoinsurer()
  {
    if (this.sharePercentageDisplay.getValue() == null)
    {
      String Message = "Enter a Share Percentage";
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Message, Message));
      


      return null;
    }
    String computeQuery = "BEGIN LMS_WEB_PKG_GRP.updatepolicycoinsurers(?,?,?,?,?,?,?);END;";
    
    Connection conn = new DBConnector().getDatabaseConn();
    CallableStatement cstmt = null;
    try
    {
      cstmt = conn.prepareCall(computeQuery);
      cstmt.setBigDecimal(1, (BigDecimal)this.session.getAttribute("pol_coin_code"));
      
      cstmt.setBigDecimal(2, (BigDecimal)this.session.getAttribute("endorsementCode"));
      
      cstmt.setBigDecimal(3, (BigDecimal)this.session.getAttribute("policyCode"));
      
      cstmt.setBigDecimal(4, (BigDecimal)this.session.getAttribute("coin_agn_code"));
      
      cstmt.setString(5, this.sharePercentageDisplay.getValue().toString());
      if (this.adminFeeDisplay.getValue() == null) {
        cstmt.setBigDecimal(6, null);
      } else {
        cstmt.setString(6, this.adminFeeDisplay.getValue().toString());
      }
      if (this.laFollowerBusiness.getValue() == null) {
        cstmt.setString(7, null);
      } else {
        cstmt.setString(7, this.laFollowerBusiness.getValue().toString());
      }
      cstmt.execute();
      conn.close();
      GlobalCC.sysInformation("Coinsurer Saved");
      

      ADFUtils.findIterator("FindPolicyCoinsurersIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.polCoinsurersLOV);
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
  }
  
  public void setPolCoinsurersLOV(RichTable polCoinsurersLOV)
  {
    this.polCoinsurersLOV = polCoinsurersLOV;
  }
  
  public RichTable getPolCoinsurersLOV()
  {
    return this.polCoinsurersLOV;
  }
  
  public String EditCoinsurersSel()
  {
    String followerBus = (String)this.session.getAttribute("FollowerBusiness");
    try
    {
      DCIteratorBinding dciter = ADFUtils.findIterator("FindPolicyCoinsurersIterator");
      
      RowKeySet set = this.polCoinsurersLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      while (rowKeySetIter.hasNext())
      {
        List l = (List)rowKeySetIter.next();
        Key key = (Key)l.get(0);
        dciter.setCurrentRowWithKey(key.toStringFormat(true));
        Row r = dciter.getCurrentRow();
        this.session.setAttribute("pol_coin_code", r.getAttribute("pol_coin_code"));
        
        this.session.setAttribute("coin_agn_code", r.getAttribute("pol_coin_agn_code"));
        
        this.addCoinsurerDisplay.setValue(r.getAttribute("coinsurer_display"));
        this.sharePercentageDisplay.setValue(r.getAttribute("POL_COIN_SHARE_PCT"));
        this.adminFeeDisplay.setValue(r.getAttribute("pol_coin_admin_fee"));
        if (followerBus.equalsIgnoreCase("F"))
        {
          this.laFollowerBusiness.setValue(r.getAttribute("POL_COIN_FOLLOWER"));
          AdfFacesContext.getCurrentInstance().addPartialTarget(this.laFollowerBusiness);
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.addCoinsurerDisplay);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.sharePercentageDisplay);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.adminFeeDisplay);
        

        GlobalCC.showPopup("lmsgroup:addCoinsurerPopup");
      }
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
    return null;
  }
  
  public String DeleteCoinsurer()
  {
    BigDecimal CoinsurerCode = null;
    
    DCIteratorBinding dciter = ADFUtils.findIterator("FindPolicyCoinsurersIterator");
    
    RowKeySet set = this.polCoinsurersLOV.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();
    while (rowKeySetIter.hasNext())
    {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();
      
      CoinsurerCode = (BigDecimal)r.getAttribute("pol_coin_code");
    }
    String deleteQuery = "BEGIN LMS_WEB_PKG_GRP.deletepolicycoinsurer(?);END;";
    
    Connection conn = new DBConnector().getDatabaseConn();
    try
    {
      CallableStatement cstmt = conn.prepareCall(deleteQuery);
      cstmt.setBigDecimal(1, CoinsurerCode);
      cstmt.execute();
      
      ADFUtils.findIterator("FindPolicyCoinsurersIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.polCoinsurersLOV);
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
  }
  
  public String UpdateMembersToCover()
  {
    Connection conn = null;
    String PopulateQuery = "BEGIN LMS_WEB_PKG_GRP.update_members_to_cover(?,?);END;";
    try
    {
      conn = new DBConnector().getDatabaseConn();
      CallableStatement cstmt = null;
      cstmt = conn.prepareCall(PopulateQuery);
      cstmt.setBigDecimal(1, (BigDecimal)this.session.getAttribute("endorsementCode"));
      
      cstmt.setBigDecimal(2, (BigDecimal)this.session.getAttribute("policyCode"));
      
      cstmt.execute();
      cstmt.close();
      conn.close();
      
      GlobalCC.sysInformation("Members Successfully Updated.");
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
  }
  
  public void setCoinLeaderShare(RichInputText coinLeaderShare)
  {
    this.coinLeaderShare = coinLeaderShare;
  }
  
  public RichInputText getCoinLeaderShare()
  {
    return this.coinLeaderShare;
  }
  
  public void setDiscChoice(RichSelectOneChoice discChoice)
  {
    this.discChoice = discChoice;
  }
  
  public RichSelectOneChoice getDiscChoice()
  {
    return this.discChoice;
  }
  
  public void setDiscRateDisplay(RichInputText discRateDisplay)
  {
    this.discRateDisplay = discRateDisplay;
  }
  
  public RichInputText getDiscRateDisplay()
  {
    return this.discRateDisplay;
  }
  
  public void setDiscDivFactor(RichInputText discDivFactor)
  {
    this.discDivFactor = discDivFactor;
  }
  
  public RichInputText getDiscDivFactor()
  {
    return this.discDivFactor;
  }
  
  public void setJointAgent(RichSelectBooleanCheckbox jointAgent)
  {
    this.jointAgent = jointAgent;
  }
  
  public RichSelectBooleanCheckbox getJointAgent()
  {
    return this.jointAgent;
  }
  
  public void setAgentShare(RichInputNumberSpinbox agentShare)
  {
    this.agentShare = agentShare;
  }
  
  public RichInputNumberSpinbox getAgentShare()
  {
    return this.agentShare;
  }
  
  public void setJointAgentDesc(RichInputText jointAgentDesc)
  {
    this.jointAgentDesc = jointAgentDesc;
  }
  
  public RichInputText getJointAgentDesc()
  {
    return this.jointAgentDesc;
  }
  
  public void setJointAgentsTable(RichTable jointAgentsTable)
  {
    this.jointAgentsTable = jointAgentsTable;
  }
  
  public RichTable getJointAgentsTable()
  {
    return this.jointAgentsTable;
  }
  
  public void setEndrAgentsTable(RichTable endrAgentsTable)
  {
    this.endrAgentsTable = endrAgentsTable;
  }
  
  public RichTable getEndrAgentsTable()
  {
    return this.endrAgentsTable;
  }
  
  public void setLeadAgentShare(RichInputNumberSpinbox leadAgentShare)
  {
    this.leadAgentShare = leadAgentShare;
  }
  
  public RichInputNumberSpinbox getLeadAgentShare()
  {
    return this.leadAgentShare;
  }
  
  public void setUmbrelladurationType(RichSelectOneChoice umbrelladurationType)
  {
    this.umbrelladurationType = umbrelladurationType;
  }
  
  public RichSelectOneChoice getUmbrelladurationType()
  {
    return this.umbrelladurationType;
  }
  
  public void setPolicyDivisionsTable(RichTable policyDivisionsTable)
  {
    this.policyDivisionsTable = policyDivisionsTable;
  }
  
  public RichTable getPolicyDivisionsTable()
  {
    return this.policyDivisionsTable;
  }
  
  public String AddSubDivision()
  {
    this.session.setAttribute("subdivisionCode", null);
    this.session.setAttribute("PolicydivisionCode", null);
    this.session.setAttribute("action", "A");
    this.divShortDesc.setValue(null);
    this.divDesc.setValue(null);
    
    GlobalCC.showPopup("lmsgroup:PSDivPopup");
    return null;
  }
  
  public String EditSubDivision()
  {
    DCIteratorBinding dciter = ADFUtils.findIterator("findPolicySubdivisionsIterator");
    
    RowKeySet set = this.policyDivisionsTable.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();
    while (rowKeySetIter.hasNext())
    {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();
      
      this.session.setAttribute("subdivisionCode", r.getAttribute("PGSUB_GSUB_CODE"));
      
      this.session.setAttribute("PolicydivisionCode", r.getAttribute("PGSUB_CODE"));
      
      this.divShortDesc.setValue(r.getAttribute("PGSUB_SHT_DESC"));
      this.divDesc.setValue(r.getAttribute("PGSUB_DESC"));
      this.session.setAttribute("action", "E");
      
      GlobalCC.showPopup("lmsgroup:PSDivPopup");
    }
    return null;
  }
  
  public String DeleteSubDivision()
  {
    DCIteratorBinding dciter = ADFUtils.findIterator("findPolicySubdivisionsIterator");
    
    RowKeySet set = this.policyDivisionsTable.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();
    while (rowKeySetIter.hasNext())
    {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();
      
      this.session.setAttribute("subdivisionCode", r.getAttribute("PGSUB_GSUB_CODE"));
      
      this.session.setAttribute("PolicydivisionCode", r.getAttribute("PGSUB_CODE"));
      
      this.divShortDesc.setValue(r.getAttribute("PGSUB_SHT_DESC"));
      this.divDesc.setValue(r.getAttribute("PGSUB_DESC"));
      this.session.setAttribute("action", "D");
      
      SaveSubDivision();
    }
    return null;
  }
  
  public String SaveSubDivision()
  {
    Connection conn = null;
    try
    {
      String Task = (String)this.session.getAttribute("action");
      if ((Task.equalsIgnoreCase("A")) || (Task.equalsIgnoreCase("E")))
      {
        if (this.divShortDesc.getValue() == null)
        {
          GlobalCC.INFORMATIONREPORTING("Enter A Short Description");
          return null;
        }
        if (this.divDesc.getValue() == null)
        {
          GlobalCC.INFORMATIONREPORTING("Enter A Description");
          return null;
        }
      }
      else if (Task.equalsIgnoreCase("D"))
      {
        BigDecimal Code = (BigDecimal)this.session.getAttribute("PolicydivisionCode");
        if (Code == null)
        {
          GlobalCC.INFORMATIONREPORTING("Select A SubDivision");
          return null;
        }
      }
      String deleteQuery = "BEGIN LMS_WEB_PKG_GRP_UW.save_policy_subdivisions(?,?,?,?,?,?,?);END;";
      
      conn = new DBConnector().getDatabaseConn();
      CallableStatement cstmt = conn.prepareCall(deleteQuery);
      cstmt.setString(1, (String)this.session.getAttribute("action"));
      cstmt.setBigDecimal(2, (BigDecimal)this.session.getAttribute("policyCode"));
      
      cstmt.setBigDecimal(3, (BigDecimal)this.session.getAttribute("endorsementCode"));
      
      cstmt.setBigDecimal(4, (BigDecimal)this.session.getAttribute("PolicydivisionCode"));
      
      cstmt.setBigDecimal(5, (BigDecimal)this.session.getAttribute("subdivisionCode"));
      if (this.divShortDesc.getValue() == null) {
        cstmt.setString(6, null);
      } else {
        cstmt.setString(6, this.divShortDesc.getValue().toString());
      }
      if (this.divDesc.getValue() == null) {
        cstmt.setString(7, null);
      } else {
        cstmt.setString(7, this.divDesc.getValue().toString());
      }
      cstmt.execute();
      cstmt.close();
      conn.close();
      
      GlobalCC.INFORMATIONREPORTING("Transaction Successfully Completed");
      
      ADFUtils.findIterator("findPolicySubdivisionsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.policyDivisionsTable);
      
      GlobalCC.hidePopup("lmsgroup:PSDivPopup");
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
  }
  
  public void setSubdivision(RichSelectOneChoice subdivision)
  {
    this.subdivision = subdivision;
  }
  
  public RichSelectOneChoice getSubdivision()
  {
    return this.subdivision;
  }
  
  public void setDivShortDesc(RichInputText divShortDesc)
  {
    this.divShortDesc = divShortDesc;
  }
  
  public RichInputText getDivShortDesc()
  {
    return this.divShortDesc;
  }
  
  public void setDivDesc(RichInputText divDesc)
  {
    this.divDesc = divDesc;
  }
  
  public RichInputText getDivDesc()
  {
    return this.divDesc;
  }
  
  public void setRateSelection(RichSelectOneChoice rateSelection)
  {
    this.rateSelection = rateSelection;
  }
  
  public RichSelectOneChoice getRateSelection()
  {
    return this.rateSelection;
  }
  
  public void CoverRateListener(ValueChangeEvent valueChangeEvent)
  {
    if (valueChangeEvent.getOldValue() != valueChangeEvent.getNewValue())
    {
      if (this.rateSelection.getValue() == null)
      {
        this.session.setAttribute("coverMaskCode", (BigDecimal)this.session.getAttribute("pmasCode"));
        
        this.maskDesc.setValue((String)this.session.getAttribute("pmasShtDesc"));
        
        this.maskButton.setDisabled(true);
        this.coverRate.setDisabled(true);
        this.coverRate.setValue(null);
        this.coverRateDivFactor.setDisabled(true);
        this.coverRateDivFactor.setValue(null);
      }
      else if (this.rateSelection.getValue().toString().equalsIgnoreCase("M"))
      {
        this.session.setAttribute("coverMaskCode", (BigDecimal)this.session.getAttribute("pmasCode"));
        
        this.maskDesc.setValue((String)this.session.getAttribute("pmasShtDesc"));
        
        this.maskButton.setDisabled(true);
        this.coverRate.setDisabled(true);
        this.coverRate.setValue(null);
        this.coverRateDivFactor.setDisabled(true);
        this.coverRateDivFactor.setValue(null);
      }
      else if (this.rateSelection.getValue().toString().equalsIgnoreCase("S"))
      {
        this.session.setAttribute("coverMaskCode", null);
        this.maskDesc.setValue(null);
        this.maskButton.setDisabled(false);
        this.coverRate.setDisabled(true);
        this.coverRate.setValue(null);
        this.coverRateDivFactor.setDisabled(true);
        this.coverRateDivFactor.setValue(null);
      }
      else if (this.rateSelection.getValue().toString().equalsIgnoreCase("C"))
      {
        this.session.setAttribute("coverMaskCode", null);
        this.maskDesc.setValue(null);
        this.maskButton.setDisabled(true);
        this.coverRate.setDisabled(false);
        this.coverRate.setValue(null);
        this.coverRateDivFactor.setDisabled(false);
        this.coverRateDivFactor.setValue(null);
      }
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.maskDesc);
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.maskButton);
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.coverRate);
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.coverRateDivFactor);
    }
  }
  
  public void setMaskDesc(RichInputText maskDesc)
  {
    this.maskDesc = maskDesc;
  }
  
  public RichInputText getMaskDesc()
  {
    return this.maskDesc;
  }
  
  public void setMaskButton(RichCommandButton maskButton)
  {
    this.maskButton = maskButton;
  }
  
  public RichCommandButton getMaskButton()
  {
    return this.maskButton;
  }
  
  public void setCoverRate(RichInputNumberSpinbox coverRate)
  {
    this.coverRate = coverRate;
  }
  
  public RichInputNumberSpinbox getCoverRate()
  {
    return this.coverRate;
  }
  
  public void setCoverRateDivFactor(RichInputNumberSpinbox coverRateDivFactor)
  {
    this.coverRateDivFactor = coverRateDivFactor;
  }
  
  public RichInputNumberSpinbox getCoverRateDivFactor()
  {
    return this.coverRateDivFactor;
  }
  
  public void setMaskTable(RichTable maskTable)
  {
    this.maskTable = maskTable;
  }
  
  public RichTable getMaskTable()
  {
    return this.maskTable;
  }
  
  public String AssignCoverPremiumMask()
  {
    DCIteratorBinding dciter = ADFUtils.findIterator("findPremiumMaskIterator");
    
    RowKeySet set = this.maskTable.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();
    while (rowKeySetIter.hasNext())
    {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();
      
      this.session.setAttribute("coverMaskCode", r.getAttribute("PMAS_CODE"));
      this.maskDesc.setValue(r.getAttribute("PMAS_SHT_DESC"));
      
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.maskDesc);
      GlobalCC.hidePopup("lmsgroup:popup10");
    }
    return null;
  }
  
  public String DeleteAction()
  {
    try
    {
      if (this.deleteSelected.isSelected())
      {
        DeleteMemberCovers();
      }
      else if (this.deleteSchedule.isSelected())
      {
        this.session.removeAttribute("scheduleNo");
        GlobalCC.RedirectPage("/delPolicySchedule.jspx");
      }
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
    return null;
  }
  
  public String DeleteMemberCovers()
  {
    Connection conn = null;
    try
    {
      RowKeySet rowKeySet = this.policyMembersLOV.getSelectedRowKeys();
      if (!rowKeySet.iterator().hasNext())
      {
        GlobalCC.errorValueNotEntered("No Record Selected");
        return null;
      }
      Iterator rksIter = rowKeySet.iterator();
      while (rksIter.hasNext())
      {
        Object key2 = rksIter.next();
        this.policyMembersLOV.setRowKey(key2);
        JUCtrlValueBinding r = (JUCtrlValueBinding)this.policyMembersLOV.getRowData();
        if (r == null)
        {
          GlobalCC.errorValueNotEntered("No Record Selected");
          return null;
        }
        this.session.setAttribute("PolmCode", r.getAttribute("POLM_CODE"));
        this.session.setAttribute("PolmMemCode", r.getAttribute("MEM_CODE"));
        

        String endorseType = (String)this.session.getAttribute("endrValue");
        if (endorseType != null) {
          if ((endorseType.equalsIgnoreCase("NB")) || (endorseType.equalsIgnoreCase("AP")) || (endorseType.equalsIgnoreCase("RN")))
          {
            String deleteMember = "";
            if (this.session.getAttribute("RenewalArea").equals("Y")) {
              deleteMember = "BEGIN LMS_WEB_PKG_GRP.del_ren_mem_covers(?,?,?);END;";
            } else {
              deleteMember = "BEGIN LMS_WEB_PKG_GRP.del_mem_covers(?,?,?);END;";
            }
            conn = new DBConnector().getDatabaseConn();
            CallableStatement cstmt = conn.prepareCall(deleteMember);
            cstmt.setBigDecimal(1, (BigDecimal)this.session.getAttribute("endorsementCode"));
            
            cstmt.setBigDecimal(2, (BigDecimal)this.session.getAttribute("PolmCode"));
            
            cstmt.setBigDecimal(3, (BigDecimal)this.session.getAttribute("PolmMemCode"));
            

            cstmt.execute();
            conn.close();
          }
          else
          {
            DeleteMemberOnEndorsement();
          }
        }
      }
      ADFUtils.findIterator("FindPolicyMembersIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.policyMembersLOV);
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
  }
  
  public String DeleteMemberOnEndorsement()
  {
    Connection conn = null;
    try
    {
      String deleteMember = "BEGIN LMS_WEB_PKG_GRP_UW.delete_member_for_refund(?,?,?,?);END;";
      
      conn = new DBConnector().getDatabaseConn();
      CallableStatement cstmt = conn.prepareCall(deleteMember);
      cstmt.setBigDecimal(1, (BigDecimal)this.session.getAttribute("policyCode"));
      
      cstmt.setBigDecimal(2, (BigDecimal)this.session.getAttribute("endorsementCode"));
      
      cstmt.setBigDecimal(3, (BigDecimal)this.session.getAttribute("PolmCode"));
      
      cstmt.setBigDecimal(4, (BigDecimal)this.session.getAttribute("PolmMemCode"));
      

      cstmt.execute();
      cstmt.close();
      conn.close();
      
      ADFUtils.findIterator("FindPolicyMembersIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.policyMembersLOV);
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
  }
  
  public String LoadMembersForMedicals()
  {
    Connection conn = null;
    try
    {
      conn = new DBConnector().getDatabaseConn();
      String deleteMember = "BEGIN LMS_WEB_PKG_GRP_UW.load_member_medicals(?,?);END;";
      
      CallableStatement cstmt = conn.prepareCall(deleteMember);
      DCIteratorBinding dciter = ADFUtils.findIterator("FindPolicyMembersIterator");
      
      RowKeySet set = this.policyMembersLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      while (rowKeySetIter.hasNext())
      {
        List l = (List)rowKeySetIter.next();
        Key key = (Key)l.get(0);
        dciter.setCurrentRowWithKey(key.toStringFormat(true));
        Row r = dciter.getCurrentRow();
        this.session.setAttribute("PolmCode", r.getAttribute("POLM_CODE"));
        cstmt.setBigDecimal(1, (BigDecimal)this.session.getAttribute("PolmCode"));
        
        cstmt.setBigDecimal(2, (BigDecimal)this.session.getAttribute("endorsementCode"));
        
        cstmt.execute();
      }
      conn.close();
      GlobalCC.INFORMATIONREPORTING("Member Category Successfully Loaded.");
    }
    catch (Exception ex)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, ex);
    }
    return null;
  }
  
  public String AlterMemberCovers()
  {
    try
    {
      DCIteratorBinding dciter = ADFUtils.findIterator("FindPolicyMembersIterator");
      
      RowKeySet set = this.policyMembersLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      while (rowKeySetIter.hasNext())
      {
        List l = (List)rowKeySetIter.next();
        Key key = (Key)l.get(0);
        dciter.setCurrentRowWithKey(key.toStringFormat(true));
        Row r = dciter.getCurrentRow();
        this.session.setAttribute("PolmCode", r.getAttribute("POLM_CODE"));
        this.session.setAttribute("PolmMemCode", r.getAttribute("MEM_CODE"));
        
        GlobalCC.RedirectPage("/pmember_alter.jspx");
      }
    }
    catch (Exception ex)
    {
      GlobalCC.EXCEPTIONREPORTING(null, ex);
    }
    return null;
  }
  
  public String EditMemberCat()
  {
    BigDecimal PolmCode1 = null;
    Connection conn = null;
    try
    {
      RowKeySet rowKeySet = this.policyMembersLOV.getSelectedRowKeys();
      if (!rowKeySet.iterator().hasNext())
      {
        GlobalCC.errorValueNotEntered("No Record Selected");
        return null;
      }
      Iterator rksIter = rowKeySet.iterator();
      Object key2 = rksIter.next();
      this.policyMembersLOV.setRowKey(key2);
      JUCtrlValueBinding r = (JUCtrlValueBinding)this.policyMembersLOV.getRowData();
      if (r == null)
      {
        GlobalCC.errorValueNotEntered("No Record Selected");
        return null;
      }
      PolmCode1 = (BigDecimal)r.getAttribute("POLM_CODE");
      this.memberCode.setValue(r.getAttribute("POLM_CODE"));
      this.memberDesc.setValue(r.getAttribute("POLM_client"));
      
      String updateQuery = "BEGIN LMS_WEB_CURSOR_GRP.get_member_category(?,?);END;";
      
      conn = new DBConnector().getDatabaseConn();
      CallableStatement cstmt = conn.prepareCall(updateQuery);
      cstmt.registerOutParameter(1, -10);
      cstmt.setBigDecimal(2, PolmCode1);
      
      cstmt.execute();
      ResultSet rst = (ResultSet)cstmt.getObject(1);
      while (rst.next())
      {
        this.newCatDesc.setValue(rst.getString(2));
        this.newCatID.setValue(rst.getString(3));
        this.newCatPeriod.setValue(rst.getString(4));
        this.newEarningAmt.setValue(rst.getString(6));
        this.newEarningsPeriod.setValue(rst.getString(7));
        this.catEffectiveDate.setValue(null);
      }
      conn.close();
      

      GlobalCC.showPopup("lmsgroup:p4");
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
    return null;
  }
  
  public String findCategforChangeSel()
  {
    try
    {
      DCIteratorBinding dciter = ADFUtils.findIterator("FindPolicyCategoriesIterator");
      
      RowKeySet set = this.policyCategoriesforChange.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      while (rowKeySetIter.hasNext())
      {
        List l = (List)rowKeySetIter.next();
        Key key = (Key)l.get(0);
        dciter.setCurrentRowWithKey(key.toStringFormat(true));
        Row r = dciter.getCurrentRow();
        
        this.session.setAttribute("CategoryID", r.getAttribute("PCA_CODE"));
        
        this.newCatDesc.setValue(r.getAttribute("PCA_CATEG_DESC"));
        this.newCatID.setValue(r.getAttribute("PCA_SHT_DESC"));
        this.newCatPeriod.setValue(r.getAttribute("PCA_PERIOD"));
        this.newEarningsPeriod.setValue(r.getAttribute("PCA_PERIOD"));
        
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.newEarningsPeriod);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.newCatPeriod);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.newCatID);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.newCatDesc);
        

        GlobalCC.hidePopup("lmsgroup:p5");
      }
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
    return null;
  }
  
  public String SaveNewCategory()
  {
    BigDecimal PolmCode = null;
    try
    {
      if (this.memberCode.getValue() == null)
      {
        GlobalCC.INFORMATIONREPORTING("No Member Selected.");
        return null;
      }
      PolmCode = new BigDecimal(this.memberCode.getValue().toString());
      
      String updateQuery = "BEGIN LMS_WEB_PKG_GRP.effect_change_of_cate(?,?,?,?,?,?,?);END;";
      
      Connection conn = new DBConnector().getDatabaseConn();
      CallableStatement cstmt = conn.prepareCall(updateQuery);
      cstmt.setBigDecimal(1, (BigDecimal)this.session.getAttribute("endorsementCode"));
      
      cstmt.setBigDecimal(2, (BigDecimal)this.session.getAttribute("policyCode"));
      
      cstmt.setBigDecimal(3, PolmCode);
      cstmt.setBigDecimal(4, (BigDecimal)this.session.getAttribute("CategoryID"));
      if (this.newEarningsPeriod.getValue() == null) {
        cstmt.setString(5, null);
      } else {
        cstmt.setString(5, this.newEarningsPeriod.getValue().toString());
      }
      if (this.newEarningAmt.getValue() == null) {
        cstmt.setString(6, null);
      } else {
        cstmt.setString(6, this.newEarningAmt.getValue().toString());
      }
      if (this.catEffectiveDate.getValue() == null) {
        cstmt.setString(7, null);
      } else {
        cstmt.setString(7, GlobalCC.parseDate(this.catEffectiveDate.getValue().toString()));
      }
      cstmt.execute();
      conn.close();
      
      ADFUtils.findIterator("FindPolicyMembersIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.policyMembersLOV);
      
      GlobalCC.INFORMATIONREPORTING("Member Category Successfully Changed");
      
      GlobalCC.hidePopup("lmsgroup:p4");
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
    return null;
  }
  
  public void categoryChangeListener(ValueChangeEvent valueChangeEvent)
  {
    if ((valueChangeEvent.getOldValue() != valueChangeEvent.getNewValue()) && 
      (this.categoryOptions.getValue() != null)) {
      if (this.categoryOptions.getValue().toString().equalsIgnoreCase("S"))
      {
        this.newCategoryLabel.setRendered(false);
        this.newCategoryPanel.setRendered(false);
        this.newCatIDLabel.setRendered(false);
        this.newCatID.setRendered(false);
        this.newCatPeriodLabel.setRendered(false);
        this.newCatPeriod.setRendered(false);
        this.newEarnAmountLabel.setRendered(true);
        this.newEarningAmt.setRendered(true);
        this.newEarnPrdLabel.setRendered(true);
        this.newEarningsPeriod.setRendered(true);
      }
      else if (this.categoryOptions.getValue().toString().equalsIgnoreCase("C"))
      {
        this.newCategoryLabel.setRendered(true);
        this.newCategoryPanel.setRendered(true);
        this.newCatIDLabel.setRendered(true);
        this.newCatID.setRendered(true);
        this.newCatPeriodLabel.setRendered(true);
        this.newCatPeriod.setRendered(true);
        this.newEarnAmountLabel.setRendered(false);
        this.newEarningAmt.setRendered(false);
        this.newEarnPrdLabel.setRendered(false);
        this.newEarningsPeriod.setRendered(false);
      }
      else if (this.categoryOptions.getValue().toString().equalsIgnoreCase("B"))
      {
        this.newCategoryLabel.setRendered(true);
        this.newCategoryPanel.setRendered(true);
        this.newCatIDLabel.setRendered(true);
        this.newCatID.setRendered(true);
        this.newCatPeriodLabel.setRendered(true);
        this.newCatPeriod.setRendered(true);
        this.newEarnAmountLabel.setRendered(true);
        this.newEarningAmt.setRendered(true);
        this.newEarnPrdLabel.setRendered(true);
        this.newEarningsPeriod.setRendered(true);
      }
    }
  }
  
  public String postUnderwritingReinsurance()
  {
    String postUndReinsStat = "N";
    Connection conn = null;
    CallableStatement cst = null;
    String paramValue = "BEGIN lms_ord_misc.system_param_val(?,?);END;";
    conn = new DBConnector().getDatabaseConn();
    try
    {
      cst = conn.prepareCall(paramValue);
      cst.setString(1, "REINSURANCE_OUTSIDE_UNDERWRITING");
      cst.registerOutParameter(2, 12);
      cst.execute();
      postUndReinsStat = cst.getString(2);
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return postUndReinsStat;
  }
  
  public void setOtherDebitOption(RichSelectBooleanRadio otherDebitOption)
  {
    this.otherDebitOption = otherDebitOption;
  }
  
  public RichSelectBooleanRadio getOtherDebitOption()
  {
    return this.otherDebitOption;
  }
  
  public void setCheqRequistionOption(RichSelectBooleanRadio cheqRequistionOption)
  {
    this.cheqRequistionOption = cheqRequistionOption;
  }
  
  public RichSelectBooleanRadio getCheqRequistionOption()
  {
    return this.cheqRequistionOption;
  }
  
  public void setPolicyMembersLOV(RichTable policyMembersLOV)
  {
    this.policyMembersLOV = policyMembersLOV;
  }
  
  public RichTable getPolicyMembersLOV()
  {
    return this.policyMembersLOV;
  }
  
  public void setDeleteSelected(RichSelectBooleanRadio deleteSelected)
  {
    this.deleteSelected = deleteSelected;
  }
  
  public RichSelectBooleanRadio getDeleteSelected()
  {
    return this.deleteSelected;
  }
  
  public void setDeleteSchedule(RichSelectBooleanRadio deleteSchedule)
  {
    this.deleteSchedule = deleteSchedule;
  }
  
  public RichSelectBooleanRadio getDeleteSchedule()
  {
    return this.deleteSchedule;
  }
  
  public void setNewCat(RichInputText newCat)
  {
    this.newCat = newCat;
  }
  
  public RichInputText getNewCat()
  {
    return this.newCat;
  }
  
  public void setNewCatPeriod(RichInputText newCatPeriod)
  {
    this.newCatPeriod = newCatPeriod;
  }
  
  public RichInputText getNewCatPeriod()
  {
    return this.newCatPeriod;
  }
  
  public void setNewCatID(RichInputText newCatID)
  {
    this.newCatID = newCatID;
  }
  
  public RichInputText getNewCatID()
  {
    return this.newCatID;
  }
  
  public void setNewCatDesc(RichInputText newCatDesc)
  {
    this.newCatDesc = newCatDesc;
  }
  
  public RichInputText getNewCatDesc()
  {
    return this.newCatDesc;
  }
  
  public void setNewEarningAmt(RichInputText newEarningAmt)
  {
    this.newEarningAmt = newEarningAmt;
  }
  
  public RichInputText getNewEarningAmt()
  {
    return this.newEarningAmt;
  }
  
  public void setNewEarningsPeriod(RichInputText newEarningsPeriod)
  {
    this.newEarningsPeriod = newEarningsPeriod;
  }
  
  public RichInputText getNewEarningsPeriod()
  {
    return this.newEarningsPeriod;
  }
  
  public void setPolicyCategoriesforChange(RichTable policyCategoriesforChange)
  {
    this.policyCategoriesforChange = policyCategoriesforChange;
  }
  
  public RichTable getPolicyCategoriesforChange()
  {
    return this.policyCategoriesforChange;
  }
  
  public void setNewCategoryPanel(HtmlPanelGrid newCategoryPanel)
  {
    this.newCategoryPanel = newCategoryPanel;
  }
  
  public HtmlPanelGrid getNewCategoryPanel()
  {
    return this.newCategoryPanel;
  }
  
  public void setNewCatIDLabel(RichOutputLabel newCatIDLabel)
  {
    this.newCatIDLabel = newCatIDLabel;
  }
  
  public RichOutputLabel getNewCatIDLabel()
  {
    return this.newCatIDLabel;
  }
  
  public void setNewCatPeriodLabel(RichOutputLabel newCatPeriodLabel)
  {
    this.newCatPeriodLabel = newCatPeriodLabel;
  }
  
  public RichOutputLabel getNewCatPeriodLabel()
  {
    return this.newCatPeriodLabel;
  }
  
  public void setNewCategoryLabel(RichOutputLabel newCategoryLabel)
  {
    this.newCategoryLabel = newCategoryLabel;
  }
  
  public RichOutputLabel getNewCategoryLabel()
  {
    return this.newCategoryLabel;
  }
  
  public void setCategoryOptions(RichSelectOneRadio categoryOptions)
  {
    this.categoryOptions = categoryOptions;
  }
  
  public RichSelectOneRadio getCategoryOptions()
  {
    return this.categoryOptions;
  }
  
  public void setNewEarnAmountLabel(RichOutputLabel newEarnAmountLabel)
  {
    this.newEarnAmountLabel = newEarnAmountLabel;
  }
  
  public RichOutputLabel getNewEarnAmountLabel()
  {
    return this.newEarnAmountLabel;
  }
  
  public void setNewEarnPrdLabel(RichOutputLabel newEarnPrdLabel)
  {
    this.newEarnPrdLabel = newEarnPrdLabel;
  }
  
  public RichOutputLabel getNewEarnPrdLabel()
  {
    return this.newEarnPrdLabel;
  }
  
  public void setCatEffectiveDate(RichInputDate catEffectiveDate)
  {
    this.catEffectiveDate = catEffectiveDate;
  }
  
  public RichInputDate getCatEffectiveDate()
  {
    return this.catEffectiveDate;
  }
  
  public void setMemberCode(RichOutputText memberCode)
  {
    this.memberCode = memberCode;
  }
  
  public RichOutputText getMemberCode()
  {
    return this.memberCode;
  }
  
  public void setMemberDesc(RichOutputText memberDesc)
  {
    this.memberDesc = memberDesc;
  }
  
  public RichOutputText getMemberDesc()
  {
    return this.memberDesc;
  }
  
  public void setShowTicketsTab(HtmlPanelGrid showTicketsTab)
  {
    this.showTicketsTab = showTicketsTab;
  }
  
  public HtmlPanelGrid getShowTicketsTab()
  {
    return this.showTicketsTab;
  }
  
  public void setLoadAgeFactorTF(RichInputText loadAgeFactorTF)
  {
    this.loadAgeFactorTF = loadAgeFactorTF;
  }
  
  public RichInputText getLoadAgeFactorTF()
  {
    return this.loadAgeFactorTF;
  }
  
  public void setLoadAgeFactorLab(RichOutputLabel loadAgeFactorLab)
  {
    this.loadAgeFactorLab = loadAgeFactorLab;
  }
  
  public RichOutputLabel getLoadAgeFactorLab()
  {
    return this.loadAgeFactorLab;
  }
  
  public void setDivFactorLab(RichOutputLabel divFactorLab)
  {
    this.divFactorLab = divFactorLab;
  }
  
  public RichOutputLabel getDivFactorLab()
  {
    return this.divFactorLab;
  }
  
  public void setDiscLoadRateDisplayLab(RichOutputLabel discLoadRateDisplayLab)
  {
    this.discLoadRateDisplayLab = discLoadRateDisplayLab;
  }
  
  public RichOutputLabel getDiscLoadRateDisplayLab()
  {
    return this.discLoadRateDisplayLab;
  }
  
  public void loadingTypeSelectListener(ValueChangeEvent valueChangeEvent)
  {
    if ((valueChangeEvent.getNewValue() != valueChangeEvent.getOldValue()) && 
      (this.loadingTypeSelect.getValue() != null)) {
      if (this.loadingTypeSelect.getValue().toString().equalsIgnoreCase("A"))
      {
        this.discLoadRateDisplayLab.setRendered(false);
        this.discLoadRateDisplay.setRendered(false);
        this.divFactorLab.setRendered(false);
        this.divFactor.setRendered(false);
        this.loadAgeFactorLab.setRendered(true);
        this.loadAgeFactorTF.setRendered(true);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.coversPanelBox);
      }
      else
      {
        this.discLoadRateDisplayLab.setRendered(true);
        this.discLoadRateDisplay.setRendered(true);
        this.divFactorLab.setRendered(true);
        this.divFactor.setRendered(true);
        this.loadAgeFactorLab.setRendered(false);
        this.loadAgeFactorTF.setRendered(false);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.coversPanelBox);
      }
    }
  }
  
  public void setCoversPanelBox(RichPanelBox coversPanelBox)
  {
    this.coversPanelBox = coversPanelBox;
  }
  
  public RichPanelBox getCoversPanelBox()
  {
    return this.coversPanelBox;
  }
  
  public void emailReport()
  {
    Connection conn = null;
    OracleCallableStatement cst = null;
    OracleCallableStatement cs = null;
    conn = new DBConnector().getDatabaseConn();
    OracleResultSet rs = null;
    OracleResultSet rst = null;
    String reportName = "";
    String content = "";
    String emailAddress = "";
    BigDecimal rptCode = null;
    String mailType = new CorrespondenceManipulation().getMailType();
    try
    {
      String emailDetails = "SELECT EMD_RPT_NAME,EMD_MSGT_NARR,EMD_RPT_CODE,USR_EMAIL,LMS_GRP_MISC.PROCESS_MSG(" + (BigDecimal)this.session.getAttribute("endorsementCode") + ",NULL,EMD_MSGT_NARR,'P',NULL,NULL, NULL) " + "FROM LMS_EMAIL_DETAILS,TQC_USERS WHERE EMD_USR_CODE=USR_CODE " + "AND EMD_RPT_CODE IS NOT NULL";
      





      cs = (OracleCallableStatement)conn.prepareCall(emailDetails);
      rst = (OracleResultSet)cs.executeQuery();
      while (rst.next())
      {
        reportName = rst.getString(1);
        
        rptCode = rst.getBigDecimal(3);
        emailAddress = rst.getString(4);
        content = rst.getString(5);
        if (mailType.equalsIgnoreCase("NORMAL"))
        {
          new CorrespondenceManipulation().processEmailDebits(rptCode, emailAddress, reportName, content, reportName);
        }
        else if (mailType.equalsIgnoreCase("GOOGLE"))
        {
          String emailVal = null;
          String passVal = null;
          String emailQuery = "SELECT  MAIL_USERNAME, MAIL_PASSWORD, MAIL_SECURE FROM TQC_SYSTEM_MAILS WHERE MAIL_IN_OUT = 'O' AND MAIL_TYPE='GOOGLE'";
          


          cst = (OracleCallableStatement)conn.prepareCall(emailQuery);
          
          rs = (OracleResultSet)cst.executeQuery();
          while (rs.next())
          {
            emailVal = rs.getString(1);
            passVal = rs.getString(2);
            
            new CorrespondenceManipulation().sendMailDoc(rs.getString(1), emailAddress, null, reportName + " Report", content, reportName + ".pdf", reportName + ".pdf", rptCode, "");
          }
          cst.close();
          rs.close();
        }
      }
      cs.close();
      rst.close();
      
      conn.close();
    }
    catch (Exception e)
    {
      e.printStackTrace();
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
  }
  
  public void setSingleGrpRates(RichSelectOneChoice singleGrpRates)
  {
    this.singleGrpRates = singleGrpRates;
  }
  
  public RichSelectOneChoice getSingleGrpRates()
  {
    return this.singleGrpRates;
  }
  
  public String viewClaimExperience()
  {
    if (this.txtWefDate.getValue() == null) {
      this.session.setAttribute("wef", null);
    } else {
      this.session.setAttribute("wef", GlobalCC.parseDate(this.txtWefDate.getValue().toString()));
    }
    if (this.txtWetDate.getValue() == null) {
      this.session.setAttribute("wet", null);
    } else {
      this.session.setAttribute("wet", GlobalCC.parseDate(this.txtWetDate.getValue().toString()));
    }
    ADFUtils.findIterator("findClientClaimExpIterator").executeQuery();
    AdfFacesContext.getCurrentInstance().addPartialTarget(this.claimExpLOV);
    return null;
  }
  
  public void setTxtWefDate(RichInputDate txtWefDate)
  {
    this.txtWefDate = txtWefDate;
  }
  
  public RichInputDate getTxtWefDate()
  {
    return this.txtWefDate;
  }
  
  public void setTxtWetDate(RichInputDate txtWetDate)
  {
    this.txtWetDate = txtWetDate;
  }
  
  public RichInputDate getTxtWetDate()
  {
    return this.txtWetDate;
  }
  
  public void setClaimExpLOV(RichTable claimExpLOV)
  {
    this.claimExpLOV = claimExpLOV;
  }
  
  public RichTable getClaimExpLOV()
  {
    return this.claimExpLOV;
  }
  
  public String SearchMembers()
  {
    try
    {
      if (this.srchMemName.getValue() == null) {
        this.session.setAttribute("srchMemName", null);
      } else {
        this.session.setAttribute("srchMemName", this.srchMemName.getValue().toString());
      }
      if (this.srchMemNo.getValue() == null) {
        this.session.setAttribute("srchMemNo", null);
      } else {
        this.session.setAttribute("srchMemNo", this.srchMemNo.getValue().toString());
      }
      ADFUtils.findIterator("FindPolicyMembersIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.policyMembersLOV);
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(null, e);
      e.printStackTrace();
    }
    return null;
  }
  
  public String ClearSearchMembers()
  {
    try
    {
      this.session.setAttribute("srchMemName", null);
      this.session.setAttribute("srchMemNo", null);
      this.srchMemNo.setValue(null);
      this.srchMemName.setValue(null);
      
      ADFUtils.findIterator("FindPolicyMembersIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.policyMembersLOV);
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(null, e);
      e.printStackTrace();
    }
    return null;
  }
  
  public void setSrchMemNo(RichInputText srchMemNo)
  {
    this.srchMemNo = srchMemNo;
  }
  
  public RichInputText getSrchMemNo()
  {
    return this.srchMemNo;
  }
  
  public void setSrchMemName(RichInputText srchMemName)
  {
    this.srchMemName = srchMemName;
  }
  
  public RichInputText getSrchMemName()
  {
    return this.srchMemName;
  }
  
  public String completeDataEntry()
  {
    Connection conn = null;
    workflowProcessing wf = new workflowProcessing();
    this.session.setAttribute("ProcessShtDesc", "UWNB");
    this.session.setAttribute("ProcessAreaShtDesc", "NBUW");
    this.session.setAttribute("ProcessSubAShtDesc", "NBMR");
    try
    {
      conn = new DBConnector().getDatabaseConn();
      String MyTask = null;
      CallableStatement cst3 = null;
      String Complete = "BEGIN TQC_WEB_PKG.check_task_completion(?,?,?,?);END;";
      
      cst3 = conn.prepareCall(Complete);
      cst3.setString(1, "NBDE");
      cst3.setString(2, (String)this.session.getAttribute("TaskID"));
      cst3.setInt(3, ((Integer)this.session.getAttribute("sysCode")).intValue());
      cst3.registerOutParameter(4, 12);
      cst3.execute();
      MyTask = cst3.getString(4);
      if (MyTask.equalsIgnoreCase("N"))
      {
        String Message = "the Task Selected Does not Correspond to the Activity being Performed. Cannot Complete please " + this.session.getAttribute("TaskActivityName");
        

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Message, Message));
        


        return null;
      }
      GlobalCC.INFORMATIONREPORTING("Data entry completed successfully");
      wf.CompleteTask();
    }
    catch (Exception ex)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, ex);
    }
    return null;
  }
  
  public void setTotalClaimPaid(RichInputText totalClaimPaid)
  {
    this.totalClaimPaid = totalClaimPaid;
  }
  
  public RichInputText getTotalClaimPaid()
  {
    return this.totalClaimPaid;
  }
  
  public void setTotalPremiumPaid(RichInputText totalPremiumPaid)
  {
    this.totalPremiumPaid = totalPremiumPaid;
  }
  
  public RichInputText getTotalPremiumPaid()
  {
    return this.totalPremiumPaid;
  }
  
  public void setEarnPrdType(RichSelectOneChoice earnPrdType)
  {
    this.earnPrdType = earnPrdType;
  }
  
  public RichSelectOneChoice getEarnPrdType()
  {
    return this.earnPrdType;
  }
  
  public void setBuiltIn(RichSelectOneChoice builtIn)
  {
    this.builtIn = builtIn;
  }
  
  public RichSelectOneChoice getBuiltIn()
  {
    return this.builtIn;
  }
  
  public void setAccelerator(RichSelectOneChoice accelerator)
  {
    this.accelerator = accelerator;
  }
  
  public RichSelectOneChoice getAccelerator()
  {
    return this.accelerator;
  }
  
  public void setSbuOneDisplay(RichInputText sbuOneDisplay)
  {
    this.sbuOneDisplay = sbuOneDisplay;
  }
  
  public RichInputText getSbuOneDisplay()
  {
    return this.sbuOneDisplay;
  }
  
  public void setLocOneDisplay(RichInputText locOneDisplay)
  {
    this.locOneDisplay = locOneDisplay;
  }
  
  public RichInputText getLocOneDisplay()
  {
    return this.locOneDisplay;
  }
  
  public void setLocOneLOV(RichTable locOneLOV)
  {
    this.locOneLOV = locOneLOV;
  }
  
  public RichTable getLocOneLOV()
  {
    return this.locOneLOV;
  }
  
  public void setSBUOneLOV(RichTable SBUOneLOV)
  {
    this.SBUOneLOV = SBUOneLOV;
  }
  
  public RichTable getSBUOneLOV()
  {
    return this.SBUOneLOV;
  }
  
  public void setSbuOneDisplay1(HtmlPanelGrid sbuOneDisplay1)
  {
    this.sbuOneDisplay1 = sbuOneDisplay1;
  }
  
  public HtmlPanelGrid getSbuOneDisplay1()
  {
    return this.sbuOneDisplay1;
  }
  
  public void setSession(HttpSession session)
  {
    this.session = session;
  }
  
  public HttpSession getSession()
  {
    return this.session;
  }
  
  public void setTicketRemarks(RichInputText ticketRemarks)
  {
    this.ticketRemarks = ticketRemarks;
  }
  
  public RichInputText getTicketRemarks()
  {
    return this.ticketRemarks;
  }
  
  public String ticketAssignee()
  {
    Connection conn = new DBConnector().getDatabaseConn();
    CallableStatement cst3 = null;
    CorrespondenceManipulation mail = new CorrespondenceManipulation();
    try
    {
      Object key2 = this.ticketsUserLOV.getSelectedRowData();
      if (key2 == null)
      {
        GlobalCC.errorValueNotEntered("No Record Selected");
        return null;
      }
      JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
      if (r == null)
      {
        GlobalCC.errorValueNotEntered("No Record Selected");
        return null;
      }
      String Remarks = null;
      if (this.ticketRemarks.getValue() != null) {
        Remarks = this.ticketRemarks.getValue().toString();
      }
      String Complete = "BEGIN TQC_WEB_PKG.reassign_task(?,?,?);END;";
      cst3 = conn.prepareCall(Complete);
      cst3.setString(1, (String)this.session.getAttribute("TaskID"));
      cst3.setString(2, (String)r.getAttribute("USR_USERNAME"));
      cst3.setString(3, Remarks);
      cst3.execute();
      cst3.close();
      conn.close();
      GlobalCC.INFORMATIONREPORTING(this.session.getAttribute("TaskActivityName") + " Ticket Successfully assigned to " + r.getAttribute("USR_NAME"));
      

      GlobalCC.hidePopup("lmsgroup:p14");
      mail.ticketAlert((String)this.session.getAttribute("Username"), (String)r.getAttribute("USR_USERNAME"), (String)this.session.getAttribute("TaskActivityName"), Remarks);
    }
    catch (Exception ex)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, ex);
    }
    return null;
  }
  
  public void setTicketsUserLOV(RichTable ticketsUserLOV)
  {
    this.ticketsUserLOV = ticketsUserLOV;
  }
  
  public RichTable getTicketsUserLOV()
  {
    return this.ticketsUserLOV;
  }
  
  public String getConvertedAmt(String amt)
  {
    String amt_conv = null;
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    try
    {
      String connectionPackage = "begin ? := lms_grp_misc.convert_currency(?,?); end;";
      
      cst = conn.prepareCall(connectionPackage);
      
      cst.registerOutParameter(1, 12);
      cst.setBigDecimal(2, (BigDecimal)this.session.getAttribute("policyCode"));
      cst.setString(3, amt);
      
      cst.execute();
      amt_conv = cst.getString(1);
      cst.close();
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
    finally
    {
      GlobalCC.CloseConnections(null, cst, conn);
    }
    return amt_conv;
  }
  
  public void setOvrCommRate(RichInputText ovrCommRate)
  {
    this.ovrCommRate = ovrCommRate;
  }
  
  public RichInputText getOvrCommRate()
  {
    return this.ovrCommRate;
  }
}
