package LMSG.view.Base;

import LMSG.view.BPM.workflowProcessing;
import java.math.BigDecimal;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class Rendering
  extends LOVCC
{
  public static int inputTextSize = LOVCC.screenWidth / 40;
  public static int inputNumberSize = LOVCC.screenWidth / 100;
  public static int splitterPos = LOVCC.screenWidth / 5;
  public static int dropDownButton = LOVCC.screenWidth / 60;
  public static String infoMessage = LOVCC.confirmMessage;
  private static String ProductType;
  private String test;
  private String beneficariesLabel;
  private String linkname;
  HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
  
  public boolean isExGratiaClaim()
  {
    String prodTy = (String)this.session.getAttribute("ExgRights");
    if (prodTy == null) {
      return false;
    }
    if (prodTy.equalsIgnoreCase("Y")) {
      return true;
    }
    return false;
  }
  
  public boolean isPensionproduct()
  {
    String prodTy = (String)this.session.getAttribute("productType");
    if (prodTy == null) {
      return false;
    }
    if (prodTy.equalsIgnoreCase("PENS")) {
      return true;
    }
    return false;
  }
  
  public boolean isLoansProduct()
  {
    String prodTy = (String)this.session.getAttribute("productType");
    if (prodTy == null) {
      return false;
    }
    if (prodTy.equalsIgnoreCase("LOAN")) {
      return true;
    }
    return false;
  }
  
  public boolean isLoansProductWithRider()
  {
    String prodTy = (String)this.session.getAttribute("productType");
    String Rider = (String)this.session.getAttribute("savingsRider");
    if (Rider == null) {
      Rider = "N";
    }
    if (prodTy == null) {
      return false;
    }
    if ((prodTy.equalsIgnoreCase("LOAN")) && (Rider.equalsIgnoreCase("N"))) {
      return true;
    }
    return false;
  }
  
  public boolean isReceiptsThruValuation()
  {
    String prodTy = (String)this.session.getAttribute("recptsThruVal");
    if (prodTy == null) {
      return false;
    }
    if (prodTy.equalsIgnoreCase("Y")) {
      return true;
    }
    return false;
  }
  
  public boolean isEarningsproduct()
  {
    String prodTy = (String)this.session.getAttribute("productType");
    if (prodTy == null) {
      return false;
    }
    if (prodTy.equalsIgnoreCase("EARN")) {
      return true;
    }
    return false;
  }
  
  public boolean isFuneralproduct()
  {
    String prodTy = (String)this.session.getAttribute("productType");
    if (prodTy == null) {
      return false;
    }
    if (prodTy.equalsIgnoreCase("FUNE")) {
      return true;
    }
    return false;
  }
  
  public boolean isAnnuityproduct()
  {
    String prodTy = (String)this.session.getAttribute("productType");
    if (prodTy == null) {
      return false;
    }
    if (prodTy.equalsIgnoreCase("ANN")) {
      return true;
    }
    return false;
  }
  
  public boolean isGratuityproduct()
  {
    String prodTy = (String)this.session.getAttribute("productType");
    if (prodTy == null) {
      return false;
    }
    if (prodTy.equalsIgnoreCase("GRAT")) {
      return true;
    }
    return false;
  }
  
  public boolean isPensAnnuityproduct()
  {
    String prodTy = (String)this.session.getAttribute("productType");
    if (prodTy == null) {
      return false;
    }
    if ((prodTy.equalsIgnoreCase("ANN")) || (prodTy.equalsIgnoreCase("PENS")) || (prodTy.equalsIgnoreCase("GRAT"))) {
      return true;
    }
    return false;
  }
  
  public boolean isEducationproduct()
  {
    String prodTy = (String)this.session.getAttribute("productType");
    if (prodTy == null) {
      return false;
    }
    if (prodTy.equalsIgnoreCase("EDUC")) {
      return true;
    }
    return false;
  }
  
  public boolean isQuotation()
  {
    if (LOVCC.RedirectPage == "Q") {
      return true;
    }
    return false;
  }
  
  public boolean isPremiumRatesAbove()
  {
    String PremVal = (String)this.session.getAttribute("PremiumRatesAbove");
    if (PremVal == null) {
      return true;
    }
    if (PremVal.equalsIgnoreCase("N")) {
      return false;
    }
    return true;
  }
  
  public boolean isHasGroupLife()
  {
    String prodTy = (String)this.session.getAttribute("productType");
    String LifeRider = (String)this.session.getAttribute("GrpLifeRider");
    if (LifeRider == null) {
      LifeRider = "N";
    }
    if (prodTy == null) {
      return true;
    }
    if ((prodTy.equalsIgnoreCase("PENS")) && (LifeRider.equalsIgnoreCase("N"))) {
      return false;
    }
    return true;
  }
  
  public boolean isHasLoanProduct()
  {
    String prodTy = (String)this.session.getAttribute("productType");
    if (prodTy == null) {
      return true;
    }
    if (prodTy.equalsIgnoreCase("LOAN")) {
      return false;
    }
    return true;
  }
  
  public boolean isHasGroupLifeExcAggr()
  {
    String prodTy = (String)this.session.getAttribute("productType");
    String LifeRider = (String)this.session.getAttribute("GrpLifeRider");
    if (LifeRider == null) {
      LifeRider = "N";
    }
    if (prodTy == null) {
      return true;
    }
    if ((prodTy.equalsIgnoreCase("PENS")) && (LifeRider.equalsIgnoreCase("N"))) {
      return false;
    }
    String QuotClac = (String)this.session.getAttribute("QuotCalcType");
    if (QuotClac == null) {
      return true;
    }
    if (QuotClac.equalsIgnoreCase("A")) {
      return true;
    }
    return true;
  }
  
  public boolean isPolicy()
  {
    if (LOVCC.RedirectPage == "P") {
      return true;
    }
    return false;
  }
  
  public boolean isReadOnly()
  {
    String Trans = (String)this.session.getAttribute("transType");
    if (Trans.equalsIgnoreCase("VQ")) {
      return false;
    }
    return true;
  }
  
  public boolean isCoinsurance()
  {
    String Coins = (String)this.session.getAttribute("CoinsPolicy");
    if (Coins == null) {
      return false;
    }
    if (Coins.equalsIgnoreCase("Y")) {
      return true;
    }
    return false;
  }
  
  public boolean isCoinsuranceLead()
  {
    String Coins = (String)this.session.getAttribute("CoinsPolicy");
    if (Coins == null) {
      return false;
    }
    if (Coins.equalsIgnoreCase("Y"))
    {
      String LeadFollow = (String)this.session.getAttribute("CoinsLeadFollow");
      if (LeadFollow == null) {
        return false;
      }
      if (LeadFollow.equalsIgnoreCase("L")) {
        return true;
      }
      return false;
    }
    return false;
  }
  
  public boolean isCoinsuranceFollow()
  {
    String Coins = (String)this.session.getAttribute("CoinsPolicy");
    if (Coins == null) {
      return true;
    }
    if (Coins.equalsIgnoreCase("Y"))
    {
      String LeadFollow = (String)this.session.getAttribute("CoinsLeadFollow");
      if (LeadFollow == null) {
        return true;
      }
      if (LeadFollow.equalsIgnoreCase("F")) {
        return true;
      }
      return false;
    }
    return true;
  }
  
  public boolean isAggregate()
  {
    String PalClac = (String)this.session.getAttribute("PolCalcType");
    String prodTy = (String)this.session.getAttribute("productType");
    if (PalClac == null) {
      return true;
    }
    if (PalClac.equalsIgnoreCase("A")) {
      return false;
    }
    return true;
  }
  
  public boolean isAggregatePension()
  {
    String PalClac = (String)this.session.getAttribute("PolCalcType");
    String prodTy = (String)this.session.getAttribute("productType");
    if (PalClac == null) {
      return true;
    }
    if ((PalClac.equalsIgnoreCase("A")) && (prodTy.equalsIgnoreCase("PENS"))) {
      return true;
    }
    if (PalClac.equalsIgnoreCase("D")) {
      return true;
    }
    return false;
  }
  
  public boolean isQuoteAggregate()
  {
    String QuotClac = (String)this.session.getAttribute("QuotCalcType");
    String prodTy = (String)this.session.getAttribute("productType");
    if ((QuotClac == null) || (prodTy == null)) {
      return true;
    }
    if ((QuotClac.equalsIgnoreCase("A")) && (prodTy.equalsIgnoreCase("PENS"))) {
      return true;
    }
    if (QuotClac.equalsIgnoreCase("A")) {
      return false;
    }
    return true;
  }
  
  public boolean isPolicyReadOnly()
  {
    String Auth = (String)this.session.getAttribute("Authorised");
    String EndrType = (String)this.session.getAttribute("endrValue");
    if (EndrType == null) {
      EndrType = "NB";
    }
    if (Auth == null) {
      return false;
    }
    if (Auth.equalsIgnoreCase("Y")) {
      return false;
    }
    if (EndrType.equalsIgnoreCase("CO")) {
      return false;
    }
    return true;
  }
  
  public boolean isPostReinsured()
  {
    String Auth = (String)this.session.getAttribute("Authorised");
    String EndrType = (String)this.session.getAttribute("endrValue");
    String postRein = (String)this.session.getAttribute("postReinsure");
    String RIAuth = (String)this.session.getAttribute("EndorseRIAuth");
    if (EndrType == null) {
      EndrType = "NB";
    }
    if (Auth == null) {
      return false;
    }
    if ((Auth.equalsIgnoreCase("Y")) && (postRein.equalsIgnoreCase("N"))) {
      return false;
    }
    if ((RIAuth.equalsIgnoreCase("N")) && (postRein.equalsIgnoreCase("Y"))) {
      return true;
    }
    if ((RIAuth.equalsIgnoreCase("Y")) && (postRein.equalsIgnoreCase("Y"))) {
      return false;
    }
    if (EndrType.equalsIgnoreCase("CO")) {
      return false;
    }
    return true;
  }
  
  public boolean isPolicyAuthorised()
  {
    String Auth = (String)this.session.getAttribute("Authorised");
    String EndrType = (String)this.session.getAttribute("endrValue");
    if (EndrType == null) {
      EndrType = "NB";
    }
    if (Auth == null) {
      return false;
    }
    if (Auth.equalsIgnoreCase("Y")) {
      return true;
    }
    if (EndrType.equalsIgnoreCase("CO")) {
      return false;
    }
    return false;
  }
  
  public boolean isContraAuthorisation()
  {
    String Auth = (String)this.session.getAttribute("Authorised");
    String EndrType = (String)this.session.getAttribute("endrValue");
    String postRein = (String)this.session.getAttribute("postReinsure");
    if (postRein == null) {
      postRein = "N";
    }
    if (EndrType == null) {
      EndrType = "NB";
    }
    if (Auth == null) {
      return false;
    }
    if ((Auth.equalsIgnoreCase("Y")) && (postRein.equalsIgnoreCase("N"))) {
      return false;
    }
    if ((Auth.equalsIgnoreCase("Y")) && (postRein.equalsIgnoreCase("Y"))) {
      return true;
    }
    if ((EndrType.equalsIgnoreCase("CO")) && (Auth.equalsIgnoreCase("N"))) {
      return true;
    }
    return true;
  }
  
  public boolean isRenContraAuthorisation()
  {
    String Auth = (String)this.session.getAttribute("Authorised");
    String EndrType = (String)this.session.getAttribute("endrValue");
    String Renewal = (String)this.session.getAttribute("RenewalArea");
    if (EndrType == null) {
      EndrType = "NB";
    }
    if (Renewal == null) {
      Renewal = "N";
    }
    if (Auth == null) {
      return false;
    }
    if (Renewal.equalsIgnoreCase("Y")) {
      return false;
    }
    if (Auth.equalsIgnoreCase("Y")) {
      return false;
    }
    if ((EndrType.equalsIgnoreCase("CO")) && (Auth.equalsIgnoreCase("N"))) {
      return true;
    }
    return true;
  }
  
  public boolean isRenArea()
  {
    String Renewal = (String)this.session.getAttribute("RenewalArea");
    if (Renewal == null) {
      Renewal = "N";
    }
    if (Renewal.equalsIgnoreCase("Y")) {
      return true;
    }
    return false;
  }
  
  public boolean isChangePremEndorse()
  {
    String Endorse = (String)this.session.getAttribute("endrValue");
    if (Endorse == null) {
      return true;
    }
    if (Endorse.equalsIgnoreCase("NB")) {
      return false;
    }
    if (Endorse.equalsIgnoreCase("CU")) {
      return false;
    }
    if (Endorse.equalsIgnoreCase("RN")) {
      return false;
    }
    return true;
  }
  
  public boolean isNbandRenewalOnly()
  {
    String Endorse = (String)this.session.getAttribute("endrValue");
    if (Endorse == null) {
      return true;
    }
    if (Endorse.equalsIgnoreCase("NB")) {
      return false;
    }
    if (Endorse.equalsIgnoreCase("RN")) {
      return false;
    }
    if (Endorse.equalsIgnoreCase("CT")) {
      return false;
    }
    if (Endorse.equalsIgnoreCase("EC")) {
      return false;
    }
    if ((Endorse.equalsIgnoreCase("AP")) || (Endorse.equalsIgnoreCase("CG"))) {
      return false;
    }
    if (Endorse.equalsIgnoreCase("SA")) {
      return false;
    }
    return true;
  }
  
  public boolean isExpressCB()
  {
    String Endorse = (String)this.session.getAttribute("endrValue");
    String siteParam = (String)this.session.getAttribute("siteParam");
    if (Endorse == null) {
      return false;
    }
    if ((Endorse.equalsIgnoreCase("CB")) && (siteParam.equals("12"))) {
      return true;
    }
    return false;
  }
  
  public boolean isCLAndNBRenOnly()
  {
    String Endorse = (String)this.session.getAttribute("endrValue");
    if (Endorse == null) {
      return true;
    }
    if (Endorse.equalsIgnoreCase("NB")) {
      return false;
    }
    if (Endorse.equalsIgnoreCase("CL")) {
      return false;
    }
    if (Endorse.equalsIgnoreCase("RN")) {
      return false;
    }
    if (Endorse.equalsIgnoreCase("CT")) {
      return false;
    }
    if (Endorse.equalsIgnoreCase("SA")) {
      return false;
    }
    if (Endorse.equalsIgnoreCase("CG")) {
      return false;
    }
    if (Endorse.equalsIgnoreCase("AP")) {
      return false;
    }
    return true;
  }
  
  public boolean isSAAndNBRenOnly()
  {
    String Endorse = (String)this.session.getAttribute("endrValue");
    if (Endorse == null) {
      return true;
    }
    if (Endorse.equalsIgnoreCase("NB")) {
      return false;
    }
    if (Endorse.equalsIgnoreCase("SA")) {
      return false;
    }
    if (Endorse.equalsIgnoreCase("RN")) {
      return false;
    }
    return true;
  }
  
  public boolean isAPAndNBRenOnly()
  {
    String Endorse = (String)this.session.getAttribute("endrValue");
    if (Endorse == null) {
      return true;
    }
    if (Endorse.equalsIgnoreCase("NB")) {
      return false;
    }
    if (Endorse.equalsIgnoreCase("AP")) {
      return false;
    }
    if (Endorse.equalsIgnoreCase("RN")) {
      return false;
    }
    return true;
  }
  
  public boolean isRPAndNBRenOnly()
  {
    String Endorse = (String)this.session.getAttribute("endrValue");
    if (Endorse == null) {
      return true;
    }
    if (Endorse.equalsIgnoreCase("NB")) {
      return false;
    }
    if (Endorse.equalsIgnoreCase("RP")) {
      return false;
    }
    if (Endorse.equalsIgnoreCase("RN")) {
      return false;
    }
    return true;
  }
  
  public boolean isPolicyEditOnly()
  {
    String Auth = (String)this.session.getAttribute("Authorised");
    if (Auth == null) {
      return false;
    }
    if (Auth.equalsIgnoreCase("N")) {
      return true;
    }
    return false;
  }
  
  public boolean isPolicyViewOnly()
  {
    String Auth = (String)this.session.getAttribute("Authorised");
    if (Auth == null) {
      return false;
    }
    if (Auth.equalsIgnoreCase("Y")) {
      return true;
    }
    return false;
  }
  
  public boolean isMedicals()
  {
    String Medic = (String)this.session.getAttribute("MedicalScrnRender");
    if (Medic == null) {
      return false;
    }
    if (Medic.equalsIgnoreCase("M")) {
      return true;
    }
    return false;
  }
  
  public boolean isMedicalpayments()
  {
    String Medic = (String)this.session.getAttribute("MedicalScrnRender");
    if (Medic == null) {
      return false;
    }
    if (Medic.equalsIgnoreCase("P")) {
      return true;
    }
    return false;
  }
  
  public boolean isEndorsementStatus()
  {
    String Auth = (String)this.session.getAttribute("EndorsementStatus");
    if (Auth == null) {
      return false;
    }
    if (Auth.equalsIgnoreCase("D")) {
      return false;
    }
    return true;
  }
  
  public boolean isQuoteModule()
  {
    String SysMdle = (String)this.session.getAttribute("sysModule");
    if (SysMdle == null) {
      return false;
    }
    if (SysMdle.equalsIgnoreCase("Q")) {
      return true;
    }
    return false;
  }
  
  public boolean isUnderwritingModule()
  {
    String SysMdle = (String)this.session.getAttribute("sysModule");
    if (SysMdle == null) {
      return false;
    }
    if (SysMdle.equalsIgnoreCase("U")) {
      return true;
    }
    return false;
  }
  
  public boolean isClaimsModule()
  {
    String SysMdle = (String)this.session.getAttribute("sysModule");
    if (SysMdle == null) {
      return false;
    }
    if (SysMdle.equalsIgnoreCase("C")) {
      return true;
    }
    return false;
  }
  
  public boolean isConvertPolicy()
  {
    String Taske = (String)this.session.getAttribute("TaskID");
    if (Taske == null) {
      return true;
    }
    return false;
  }
  
  public boolean isTaskConvertPolicy()
  {
    String Taske = (String)this.session.getAttribute("TaskID");
    if (Taske != null) {
      return true;
    }
    return false;
  }
  
  public boolean isClassSpecific()
  {
    String Taske = (String)this.session.getAttribute("classSpecific");
    if (Taske == null) {
      return false;
    }
    if (Taske.equalsIgnoreCase("Y")) {
      return true;
    }
    return false;
  }
  
  public boolean isCashBasis()
  {
    String Taske = (String)this.session.getAttribute("acrualCash");
    if (Taske == null) {
      return false;
    }
    return Taske.equalsIgnoreCase("C");
  }
  
  public boolean isCoinFollower()
  {
    String Follower = (String)this.session.getAttribute("FollowerBusiness");
    if (Follower == null) {
      return false;
    }
    if (Follower.equalsIgnoreCase("F")) {
      return true;
    }
    return false;
  }
  
  public boolean ishasRights()
  {
    String Rights = null;
    


    this.session.setAttribute("ProcessShtDesc", "QUOT");
    this.session.setAttribute("ProcessAreaShtDesc", "DENTR");
    this.session.setAttribute("ProcessSubAShtDesc", "CLNT");
    workflowProcessing wf = new workflowProcessing();
    Rights = wf.CheckUserRights();
    this.session.setAttribute("ClientCreationRights", Rights);
    if (Rights == null) {
      return false;
    }
    if (Rights.equalsIgnoreCase("N")) {
      return false;
    }
    return true;
  }
  
  public boolean isGlobalRights()
  {
    String Rights = null;
    


    this.session.setAttribute("ProcessShtDesc", "GBPM");
    this.session.setAttribute("ProcessAreaShtDesc", "VTCKT");
    this.session.setAttribute("ProcessSubAShtDesc", "VTCKT");
    workflowProcessing wf = new workflowProcessing();
    Rights = wf.CheckUserRights();
    if (Rights == null) {
      return false;
    }
    if (Rights.equalsIgnoreCase("N")) {
      return false;
    }
    return true;
  }
  
  public boolean isReverseEnabled()
  {
    String Rights = null;
    


    this.session.setAttribute("ProcessShtDesc", "GLPNS");
    this.session.setAttribute("ProcessAreaShtDesc", "RDED");
    this.session.setAttribute("ProcessSubAShtDesc", "RDED");
    workflowProcessing wf = new workflowProcessing();
    Rights = wf.CheckUserRights();
    if (Rights == null) {
      return false;
    }
    if (Rights.equalsIgnoreCase("N")) {
      return false;
    }
    return true;
  }
  
  public boolean isCreditNote()
  {
    BigDecimal Taske = (BigDecimal)this.session.getAttribute("instPrem");
    BigDecimal Zero = new BigDecimal("0");
    if ((Taske != null) && (Taske.compareTo(Zero) < 0)) {
      return true;
    }
    return false;
  }
  
  public boolean isDebitNote()
  {
    BigDecimal Taske = (BigDecimal)this.session.getAttribute("instPrem");
    BigDecimal Zero = new BigDecimal("0");
    if ((Taske != null) && (Taske.compareTo(Zero) > 0)) {
      return true;
    }
    return false;
  }
  
  public boolean isPensGratuityproduct()
  {
    String prodTy = (String)this.session.getAttribute("productType");
    if (prodTy == null) {
      return false;
    }
    if ((prodTy.equalsIgnoreCase("GRAT")) || (prodTy.equalsIgnoreCase("PENS")) || (prodTy.equalsIgnoreCase("GRAT"))) {
      return true;
    }
    return false;
  }
  
  public boolean isFollowerBusiness()
  {
    String follower = (String)this.session.getAttribute("FollowerBusiness");
    if (follower == null) {
      return false;
    }
    if (follower.equalsIgnoreCase("F")) {
      return true;
    }
    return false;
  }
  
  public boolean isWeeklyIndemnity()
  {
    String wklIndemnity = (String)this.session.getAttribute("WeeklyIndemnity");
    if (wklIndemnity == null) {
      return false;
    }
    if (wklIndemnity.equalsIgnoreCase("Y")) {
      return true;
    }
    return false;
  }
  
  public boolean notWeeklyIndemnity()
  {
    String wklIndemnity = (String)this.session.getAttribute("WeeklyIndemnity");
    if (wklIndemnity == null) {
      return false;
    }
    if (wklIndemnity.equalsIgnoreCase("Y")) {
      return false;
    }
    return true;
  }
  
  public boolean isHasQuotJointAgencies()
  {
    String quoJointAgn = (String)this.session.getAttribute("QuotJointAgen");
    if (quoJointAgn.equals("Y")) {
      return true;
    }
    return false;
  }
  
  public boolean isEnQuiryMode()
  {
    return LOVCC.enquiryMode;
  }
  
  public boolean isEnQuiryModeRendered()
  {
    return !LOVCC.enquiryMode;
  }
  
  public void setInputTextSize(int inputTextSize)
  {
    inputTextSize = inputTextSize;
  }
  
  public int getInputTextSize()
  {
    return inputTextSize;
  }
  
  public void setInputNumberSize(int inputNumberSize)
  {
    inputNumberSize = inputNumberSize;
  }
  
  public int getInputNumberSize()
  {
    return inputNumberSize;
  }
  
  public void setSplitterPos(int splitterPos)
  {
    splitterPos = splitterPos;
  }
  
  public int getSplitterPos()
  {
    return splitterPos;
  }
  
  public void setDropDownButton(int dropDownButton)
  {
    dropDownButton = dropDownButton;
  }
  
  public int getDropDownButton()
  {
    return dropDownButton;
  }
  
  public void setInfoMessage(String infoMessage)
  {
    infoMessage = infoMessage;
  }
  
  public String getInfoMessage()
  {
    return infoMessage;
  }
  
  public void setProductType(String ProductType)
  {
    String prodTy = (String)this.session.getAttribute("productType");
    if (prodTy == null) {
      ProductType = "Pension Details";
    } else if (prodTy.equalsIgnoreCase("ANN")) {
      ProductType = "Annuity Details";
    } else {
      ProductType = "Pension Details";
    }
  }
  
  public String getProductType()
  {
    String prodTy = (String)this.session.getAttribute("productType");
    if (prodTy == null) {
      ProductType = "Pension Details";
    } else if (prodTy.equalsIgnoreCase("ANN")) {
      ProductType = "Annuity Details";
    } else if (prodTy.equalsIgnoreCase("GRAT")) {
      ProductType = "Gratuity Details";
    } else {
      ProductType = "Pension Details";
    }
    return ProductType;
  }
  
  public String getDurationType()
  {
    String DurationType = (String)this.session.getAttribute("durationType");
    if (DurationType == null)
    {
      String prodTy = (String)this.session.getAttribute("productType");
      if (prodTy == null) {
        DurationType = "A";
      } else if (prodTy.equalsIgnoreCase("GRAT")) {
        DurationType = "O";
      } else {
        DurationType = "A";
      }
    }
    else
    {
      return DurationType;
    }
    return DurationType;
  }
  
  public void setBeneficariesLabel(String beneficariesLabel)
  {
    this.beneficariesLabel = beneficariesLabel;
    
    String prodTy = (String)this.session.getAttribute("productType");
    if (prodTy == null) {
      ProductType = "Beneficaries";
    } else if (prodTy.equalsIgnoreCase("EDUC")) {
      ProductType = "Students";
    } else {
      ProductType = "Beneficaries";
    }
  }
  
  public String getBeneficariesLabel()
  {
    String prodTy = (String)this.session.getAttribute("productType");
    if (prodTy == null) {
      this.beneficariesLabel = "Beneficiaries";
    } else if (prodTy.equalsIgnoreCase("EDUC")) {
      this.beneficariesLabel = "Students";
    } else {
      this.beneficariesLabel = "Beneficiaries";
    }
    return this.beneficariesLabel;
  }
  
  public boolean isMickVisible()
  {
    String siteParam = (String)this.session.getAttribute("siteParam");
    if (siteParam.equals("1")) {
      return true;
    }
    return false;
  }
  
  public boolean isAiicoVisible()
  {
    String siteParam = (String)this.session.getAttribute("siteParam");
    if (siteParam.equals("6")) {
      return true;
    }
    return false;
  }
  
  public boolean isApolloVisible()
  {
    String siteParam = (String)this.session.getAttribute("siteParam");
    if (siteParam.equals("11")) {
      return true;
    }
    return false;
  }
  
  public boolean isExpressVisible()
  {
    String siteParam = (String)this.session.getAttribute("siteParam");
    if (siteParam.equals("12")) {
      return true;
    }
    return false;
  }
  
  public boolean isUnionVisible()
  {
    String siteParam = (String)this.session.getAttribute("siteParam");
    if (siteParam.equals("7")) {
      return true;
    }
    return false;
  }
  
  public boolean isNigeria()
  {
    String siteParam = (String)this.session.getAttribute("siteParam");
    if ((siteParam.equals("6")) || (siteParam.equals("7"))) {
      return true;
    }
    return false;
  }
  
  public boolean isHospitalization()
  {
    String hsp = (String)this.session.getAttribute("CausationType");
    if (this.session.getAttribute("CausationType") == null) {
      return false;
    }
    if ((!hsp.equalsIgnoreCase("")) && (hsp.equals("HSP"))) {
      return true;
    }
    return false;
  }
  
  public boolean isEndorsementSA()
  {
    String endrType = (String)this.session.getAttribute("Endorsement");
    if (endrType == null) {
      return false;
    }
    if (endrType.equalsIgnoreCase("CG")) {
      return true;
    }
    return false;
  }
  
  public boolean isEndorsementAddMember()
  {
    String endrType = (String)this.session.getAttribute("Endorsement");
    if (endrType == null) {
      return false;
    }
    if (endrType.equalsIgnoreCase("AP")) {
      return true;
    }
    return false;
  }
  
  public boolean isDeletionEndorsement()
  {
    String endrType = (String)this.session.getAttribute("Endorsement");
    if (endrType == null) {
      return false;
    }
    if (endrType.equalsIgnoreCase("RP")) {
      return true;
    }
    return false;
  }
  
  public boolean isCompleteTask()
  {
    String activityName = (String)this.session.getAttribute("TaskActivityName");
    if (activityName == null) {
      return false;
    }
    if (activityName.trim().equalsIgnoreCase("New Business Data Entry")) {
      return true;
    }
    return false;
  }
  
  public boolean isQuotCompleteTask()
  {
    String activityName = (String)this.session.getAttribute("TaskActivityName");
    if (activityName == null) {
      return false;
    }
    if (activityName.trim().equalsIgnoreCase("Quotation Data Entry")) {
      return true;
    }
    return false;
  }
  
  public boolean isRimedTask()
  {
    String activityName = (String)this.session.getAttribute("TaskActivityName");
    if (activityName == null) {
      return false;
    }
    if (activityName.trim().equalsIgnoreCase("Refer to Reinsurer")) {
      return true;
    }
    return false;
  }
  
  public boolean isDmsEnabled()
  {
    String dmsEnabled = GlobalCC.findDMSEnabled();
    if (dmsEnabled == null) {
      return false;
    }
    if (dmsEnabled.trim().equalsIgnoreCase("Y")) {
      return true;
    }
    return false;
  }
  
  public String getScheduleLink()
  {
    if (isMickVisible()) {
      this.linkname = "Costing Schedule";
    } else {
      this.linkname = "Schedules";
    }
    return this.linkname;
  }
  
  public void setLinkname(String linkname)
  {
    this.linkname = linkname;
  }
  
  public boolean isShowQuote()
  {
    if ((!String.valueOf(this.session.getAttribute("dmsProcess")).equalsIgnoreCase("Y")) || (this.session.getAttribute("dmsProcess") == null)) {
      return false;
    }
    if (String.valueOf(this.session.getAttribute("dmsProcessType")).equalsIgnoreCase("Quot")) {
      return true;
    }
    return false;
  }
  
  public boolean isShowPolicy()
  {
    if ((!String.valueOf(this.session.getAttribute("dmsProcess")).equalsIgnoreCase("Y")) || (this.session.getAttribute("dmsProcess") == null)) {
      return false;
    }
    if (String.valueOf(this.session.getAttribute("dmsProcessType")).equalsIgnoreCase("Pol")) {
      return true;
    }
    return false;
  }
  
  public boolean isShowMedPolicy()
  {
    if ((!String.valueOf(this.session.getAttribute("dmsProcess")).equalsIgnoreCase("Y")) || (this.session.getAttribute("dmsProcess") == null)) {
      return false;
    }
    if (String.valueOf(this.session.getAttribute("dmsProcessType")).equalsIgnoreCase("PolMed")) {
      return true;
    }
    return false;
  }
  
  public boolean isShowClaim()
  {
    if ((!String.valueOf(this.session.getAttribute("dmsProcess")).equalsIgnoreCase("Y")) || (this.session.getAttribute("dmsProcess") == null)) {
      return false;
    }
    if (String.valueOf(this.session.getAttribute("dmsProcessType")).equalsIgnoreCase("PolClaim")) {
      return true;
    }
    return false;
  }
  
  public boolean isCoverTypes()
  {
    String coverTy = (String)this.session.getAttribute("covType");
    if (coverTy == null) {
      return false;
    }
    if ((coverTy.equalsIgnoreCase("FCG")) || (coverTy.equalsIgnoreCase("FFC(MB)")) || (coverTy.equalsIgnoreCase("FFC(MBR)"))) {
      return true;
    }
    return false;
  }
  
  public String labelText()
  {
    return String.valueOf(this.session.getAttribute("labelText"));
  }
  
  public boolean isCoinsuranceVisible()
  {
    String coverTy = (String)this.session.getAttribute("recTrans");
    if (coverTy == null) {
      return false;
    }
    if (coverTy.equalsIgnoreCase("coinRecovery")) {
      return false;
    }
    return true;
  }
  
  public boolean isRiCedingVisible()
  {
    String coverTy = (String)this.session.getAttribute("recTrans");
    if (coverTy == null) {
      return false;
    }
    if (coverTy.equalsIgnoreCase("riCeding")) {
      return true;
    }
    return false;
  }
  
  public boolean isRiRecoveryVisible()
  {
    String coverTy = (String)this.session.getAttribute("recTrans");
    if (coverTy == null) {
      return false;
    }
    if (coverTy.equalsIgnoreCase("riRecovery")) {
      return true;
    }
    return false;
  }
  
  public boolean isSourcePageAvailable()
  {
    String sourcePage = (String)this.session.getAttribute("sourcePage");
    if (sourcePage == null) {
      return false;
    }
    return true;
  }
}
