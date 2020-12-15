package com.turnkey.setups;

import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.Connection;


import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;

import javax.servlet.http.HttpSession;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.data.RichTree;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.output.RichOutputLabel;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.adf.view.rich.event.DialogEvent;

import oracle.jbo.Key;
import oracle.jbo.Row;

import oracle.jbo.uicli.binding.JUCtrlHierNodeBinding;
import oracle.jbo.uicli.binding.JUCtrlValueBinding;

import oracle.jdbc.OracleTypes;

import org.apache.myfaces.trinidad.event.SelectionEvent;
import org.apache.myfaces.trinidad.model.RowKeySet;

import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

import LMSG.view.Base.ADFUtils;

import LMSG.view.Base.GlobalCC;

import LMSG.view.connect.DBConnector;

import oracle.adf.view.rich.render.ClientEvent;

public class AgentsManipulation {
    private RichInputText actType;
    private RichTable accountTypeLOV;
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    private RichInputText actDescription;
    private RichTree agentsTree;
    private RichTable productsLOV;
    private RichTable annuityFactrDescriptionLOV;
    private RichInputText annuityDescription;
    private RichInputText interestRate;
    private RichTable annuityFactorsLOV;
    private RichInputText retirementAge;
    private RichInputText guaranteePeriod;
    private RichInputText maleRate;
    private RichInputText femaleRate;
    private RichInputText wef;
    private RichInputText wet;
    private RichPanelGroupLayout agentsPanGrp;
    private RichInputText agentID;
    private RichInputText agnIdentityNo;
    private RichInputText agnPhoneNo;
    private RichInputText pinNUmber;
    private RichSelectOneChoice financingType;
    private RichSelectOneChoice contractStatus;
    private RichInputText agentName;
    private RichInputText profCertNo;
    private RichInputDate contractDate;
    private RichInputDate agnDateJoined;
    private RichInputDate agnDateTerminated;
    private RichInputText agnBank;
    private RichTable banksLOV;
    private RichInputText agnBankAccNo;
    private RichInputText agnSmsNo;
    private RichInputText referenceNo;
    private RichSelectOneChoice agnPostLevel;
    private RichInputText agnEmailAddress;
    private RichSelectOneChoice agnReinsurer;
    private RichInputText agnGLAccountNo;
    private RichSelectOneChoice agnCreditAllowed;
    private RichInputText agnWthTax;
    private RichSelectOneChoice riDebitNote;
    private RichSelectOneChoice agnStatus;
    private RichSelectOneChoice agnRegStatus;
    private RichInputText agnRegNumber;
    private RichSelectOneChoice commissionPayroll;
    private RichSelectOneChoice commPaymentMethod;
    private RichTable commRatesLOV;
    private RichInputText commissionRates;
    private RichInputText agentsBranch;
    private RichTable branchesLOV;
    private RichTable contactsLOV;
    private RichInputDate wefAnn;
    private RichInputDate wetDate;
    private RichTable annProductsLOV;
    private RichTable annuityTypesLOV;
    private RichSelectOneChoice annuityType;
    private RichInputText annGuaranteePeriod;
    private RichSelectOneChoice annuityOption;
    private RichInputText anbAtEntry;
    private RichInputText annuityTypeRate;
    private RichTable annuityTypeRates;
    private RichTable cvtDpdProductsLOV;
    private RichTable coverTypesLOV;
    private RichTable prodCvtDependantsLOV;
    private RichTable dependentsLOV;
    private RichInputText dependentType;
    private RichInputText maxNoAllowed;
    private RichInputText minimumAge;
    private RichInputText maximumAge;
    private RichInputText maxSumAssured;
    private RichTable newAgentsLOV;
    private RichInputText contactTitle;
    private RichSelectOneChoice contactPerson;
    private RichInputText realtionId;
    private RichInputText relationDescription;
    private RichSelectOneChoice relationDOBRequired;
    private RichInputText relationComments;
    private RichTable relationTypesLOV;
    private RichTable dependentTypesLOV;
    private RichInputText dtyShtDesc;
    private RichInputText dtyDescription;
    private RichTable reinstatementRatesLOV;
    private RichTree productsTree;
    private RichInputDate reinWefDate;
    private RichInputDate reinWetDate;
    private RichInputText reinRates;
    private RichInputText loanRate;
    private RichInputText serviceChargeRate;
    private RichInputDate loanWefDate;
    private RichInputDate loanWET;
    private RichSelectOneChoice serviceChargeDivFact;
    private RichTable loanInterestRatesLOV;
    private RichTable generalInterestLOV;
    private RichSelectOneChoice generalType;
    private RichSelectOneChoice generalAppType;
    private RichInputText generalInterest;
    private RichOutputLabel generalDivFactor;
    private RichInputText genrlDivFactor;
    private RichSelectOneChoice freqOfPayment;
    private RichInputDate generalWEF;
    private RichInputDate genrlWetDate;
    private RichTree pensionProductsTree;
    private RichTable pensionCostingFactorsLOV;
    private RichInputText pcfsEscalation;
    private RichInputText pcfsInterest;
    private RichInputText pcfsWithholdingRate;
    private RichSelectOneChoice withholdingRateType;
    private RichInputText pcfsDivisionFactor;
    private RichTable pensContributionFactorsLOV;
    private RichInputText contrTaxExempt;
    private RichInputText taxExempt;
    private RichInputText pensIntrRate;
    private RichInputText taxMaxExemptAmount;
    private RichInputText taxRelief;
    private RichInputText femaleFactor;
    private RichInputText maleFactor;
    private RichSelectOneChoice factorType;
    private RichInputDate contrWEF;
    private RichInputDate contrWetDate;
    private boolean adding=false;
    private RichInputText emvErRetireAge;
    private RichSelectOneChoice emvErSex;
    private RichTable retirementAgesLOV;
    private RichTable emvErRatesLOV;
    private RichInputText emverANB;
    private RichInputText emverBasicPrem;
    private RichInputText emverBasicSA;
    private RichInputText emverEmvValue;
    private RichInputText term;
    private RichInputText emveeBasicPremium;
    private RichInputText emveeBasicSumAssured;
    private RichInputText emveeEMV;
    private RichTable employeeEmvRatesLOV;
    private RichInputText annRetirementAge;
    private RichTable gratuityLOV;
    private RichInputText serviceYears;
    private RichInputText pensionPct;
    private RichInputText gratuityPct;
    private RichTree productTransactionsTree;
    private RichTable productTransactionsLOV;
    private RichInputText prodTrnID;
    private RichInputText transactionDisplay;
    private RichTable transactionsLOV;
    private RichInputText glAccountCode;
    private RichTable glAccountsLOV;
    private RichInputText contraAccNumber;
    private RichTable contraGlLov;
    private RichTable otherProdsTransLOV;
    private RichInputDate memDateTo;
    private RichInputText contactName;
    private RichSelectOneChoice contactSex;
    private RichInputText contactTelephone;
    private RichInputText contactAddress;
    private RichInputText contactEmail;
    private RichTable pensPoliciesLOV;
    private RichInputText tableDescription;
    private RichInputText pensPoliciesDesc;
    private RichTable ratesTables;
    private RichTable tableRates;
    private RichInputText searchAgent;
    private RichInputText termFrom;
    private RichInputText termTo;
    private RichInputText benefitDiscount;
    private RichInputText contriFactor;
    private RichTable pensionCostingRates;
    private RichSelectOneChoice tablesDefault;
    private RichInputText yearFrom;
    private RichInputText yearTo;
    private RichInputText emyrEnt;
    private RichInputText emyeEnt;
    private RichTable vestingTable;
    private RichSelectOneChoice annuityTypeGender;
    private RichSelectOneChoice defaultVal;
    private RichInputText minSumAssured;
    private RichInputText empyr_lump_exempt;
    private RichInputText commRangeFrom;
    private RichInputText commRangeTo;
    private RichInputText commutationRate;
    private RichTable commutationLOV;
    private RichInputText postalAddress;
    private RichSelectOneChoice whtRetained;

    public AgentsManipulation() {
        super();
    }

    public void setActType(RichInputText actType) {
        this.actType = actType;
    }

    public RichInputText getActType() {
        return actType;
    }

    public String AssignAccountType() {
        try{
        DCIteratorBinding dciter = ADFUtils.findIterator("findAccountTypesIterator");
        RowKeySet set =accountTypeLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        
        //System.out.println(1);
        while (rowKeySetIter.hasNext()) 
        {
            List l = (List) rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
          
        
            session.setAttribute("ACT_CODE",r.getAttribute("ACT_CODE"));
            //session.setAttribute("TRT_CODE",r.getAttribute("REI_TRT_CODE"));
            actType.setValue(r.getAttribute("ACT_TYPE_SHT_DESC"));
            actDescription.setValue(r.getAttribute("ACT_ACCOUNT_TYPE"));
            session.setAttribute("agnNameSearch", null);
            searchAgent.setValue(null);
            
          ADFUtils.findIterator("findAgenciesIterator").executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(agentsTree); 
            
          ADFUtils.findIterator("findNewAgentsIterator").executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(newAgentsLOV); 
            
        }
        }catch(Exception e){
          GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public void setAccountTypeLOV(RichTable accountTypeLOV) {
        this.accountTypeLOV = accountTypeLOV;
    }

    public RichTable getAccountTypeLOV() {
        return accountTypeLOV;
    }

    public void setActDescription(RichInputText actDescription) {
        this.actDescription = actDescription;
    }

    public RichInputText getActDescription() {
        return actDescription;
    }

    public void setAgentsTree(RichTree agentsTree) {
        this.agentsTree = agentsTree;
    }

    public RichTree getAgentsTree() {
        return agentsTree;
    }

    public void ProductsListener(SelectionEvent selectionEvent) {
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
          
        
            session.setAttribute("ProductCode",r.getAttribute("PROD_CODE"));
            ADFUtils.findIterator("findAnnuityFactorsDescriptionIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(annuityFactrDescriptionLOV); 
           
            
        }
    }

    public void setProductsLOV(RichTable productsLOV) {
        this.productsLOV = productsLOV;
    }

    public RichTable getProductsLOV() {
        return productsLOV;
    }

    public void setAnnuityFactrDescriptionLOV(RichTable annuityFactrDescriptionLOV) {
        this.annuityFactrDescriptionLOV = annuityFactrDescriptionLOV;
    }

    public RichTable getAnnuityFactrDescriptionLOV() {
        return annuityFactrDescriptionLOV;
    }

    public String CreateAnnFacDesc() {
        session.setAttribute("ANNFD_CODE",null);
        // Render Popup
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:AnnFacDescPopup" +
        "').show(hints);");
        return null;
    }

    public String UpdateAnnFacDesc() {
        DCIteratorBinding dciter = ADFUtils.findIterator("findAnnuityFactorsDescriptionIterator");
        RowKeySet set =annuityFactrDescriptionLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        
        //System.out.println(1);
        while (rowKeySetIter.hasNext()) 
        {
            List l = (List) rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
          
            session.setAttribute("ANNFD_CODE",r.getAttribute("ANNFD_CODE"));
            session.setAttribute("ProductCode",r.getAttribute("ANNFD_PROD_CODE"));
            if(r.getAttribute("ANNFD_DESC")==null) {
                annuityDescription.setValue(null);
            }
            else {
                annuityDescription.setValue(r.getAttribute("ANNFD_DESC"));
            }
            if(r.getAttribute("ANNFD_INT_RATE")==null) {
                interestRate.setValue(null);
            }
            else {
                interestRate.setValue(r.getAttribute("ANNFD_INT_RATE"));
            }
            // Render Popup
            ExtendedRenderKitService erkService =
            Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
            ExtendedRenderKitService.class);
            erkService.addScript(FacesContext.getCurrentInstance(),
            "var hints = {autodismissNever:false}; " +
            "AdfPage.PAGE.findComponent('" + "lmsgroup:AnnFacDescPopup" +
            "').show(hints);");
           
            
        }
        return null;
    }
    
  public void DeleteListener(ActionEvent actionEvent) {
      // Add event code here...
      String DeletePosition = actionEvent.getComponent().getId();
      if(DeletePosition == null){
        return;
      }else{
        session.setAttribute("delAction", DeletePosition);
            GlobalCC.showPopup("lmsgroup:confirmDel");
      }
  }
  
  public String DeleteObject(){
      try{
    String Value = (String)session.getAttribute("delAction");
    String Result = "F";
    if(Value == null){
        
    }else if(Value.equalsIgnoreCase("delAnnTableDesc")){
      //Delete Annuity Table Description.
      Result = DeleteFacDesc();
    }else if(Value.equalsIgnoreCase("delAnnFactor")){
      //Delete Annuity Factor.
      Result = DeleteAnnuityFactor();
    }else if(Value.equalsIgnoreCase("delAnnTypes")){
      //Delete Annuity Types.
      Result = DeleteAnnuityType();
    }else if(Value.equalsIgnoreCase("delAnnTypeRates")){
      //Delete Annuity Type Rates.
      Result = DeleteAnnuityTypeRate();
    }else if(Value.equalsIgnoreCase("delReinsRates")){
      //Delete Interest Reinstatement Rates.
      Result = DeleteReinstatementRates();  
    }else if(Value.equalsIgnoreCase("delLoanIntRate")){
      //Delete Loan Interest Rate.
      Result = DeleteLoanInterestRates();  
    }else if(Value.equalsIgnoreCase("delGenRate")){
      //Delete General Interest Rate.
      Result = DeleteGeneralInterestRate();  
    }
          
    if (Result == null){
      return null;
    }else if(Result.equalsIgnoreCase("F")){
      return null;
    }else{
                GlobalCC.hidePopup("lmsgroup:confirmDel");
                GlobalCC.INFORMATIONREPORTING("Record Successfully Deleted.");
    }
          
  }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null, e);
  }
  return null;
  }

    public String DeleteFacDesc() {
        Connection conn=null;
        String Result = "F";
        try 
        {
            DCIteratorBinding dciter = ADFUtils.findIterator("findAnnuityFactorsDescriptionIterator");
            RowKeySet set =annuityFactrDescriptionLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();
            
            //System.out.println(1);
            while (rowKeySetIter.hasNext()) 
            {
                List l = (List) rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();
              
                session.setAttribute("ANNFD_CODE",r.getAttribute("ANNFD_CODE"));
                
                String authQuery="BEGIN LMS_SETUPS_PKG.deleteAnnFactorDesc(?);END;";
                conn=new DBConnector().getDatabaseConn();
                
                CallableStatement cstmt=conn.prepareCall(authQuery);    
                cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("ANNFD_CODE"));
             
                cstmt.execute();
                conn.close();

            }
            session.setAttribute("ANNFD_CODE", null);
            ADFUtils.findIterator("findAnnuityFactorsDescriptionIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(annuityFactrDescriptionLOV);      
            Result = "S";
        }
        catch(Exception ex)
        {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
        }
        return Result;
    }

    public void setAnnuityDescription(RichInputText annuityDescription) {
        this.annuityDescription = annuityDescription;
    }

    public RichInputText getAnnuityDescription() {
        return annuityDescription;
    }

    public void setInterestRate(RichInputText interestRate) {
        this.interestRate = interestRate;
    }

    public RichInputText getInterestRate() {
        return interestRate;
    }

    public String SaveAnnuityFactorDesc() {
        Connection conn=null;
        try 
        {
            
            if(annuityDescription.getValue()==null){
                String Message = "Enter Annuity Factor Description";
                FacesContext.getCurrentInstance().addMessage(null, 
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                              Message, 
                                                                              Message));
                return null;
            }
            
            if(interestRate.getValue()==null){
                String Message = "Enter Interest Rate";
                FacesContext.getCurrentInstance().addMessage(null, 
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                              Message, 
                                                                              Message));
                return null;
            }
           
            String authQuery="BEGIN LMS_SETUPS_PKG.updateAnnFactorDesc(?,?,?,?);END;";
            conn=new DBConnector().getDatabaseConn();
            
            CallableStatement cstmt=conn.prepareCall(authQuery);    
            cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("ANNFD_CODE"));
            if(annuityDescription.getValue()==null){
                cstmt.setString(2, null);
            }else{
                cstmt.setString(2, annuityDescription.getValue().toString());  
            }
            if(interestRate.getValue()==null){
                cstmt.setString(3, null);
            }else{
                cstmt.setString(3, interestRate.getValue().toString());  
            }
        
            cstmt.setBigDecimal(4,(BigDecimal)session.getAttribute("ProductCode"));   
            
          
            cstmt.execute();
            conn.close();
            
            String Message = "Annuity factor Description saved successfully.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            
            session.setAttribute("ANNFD_CODE", null);
            ADFUtils.findIterator("findAnnuityFactorsDescriptionIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(annuityFactrDescriptionLOV);     
          
        }
        catch(Exception ex)
        {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
        }
        return null;
    }

    public void AnnuityFactorsListener(SelectionEvent selectionEvent) {
        DCIteratorBinding dciter = ADFUtils.findIterator("findAnnuityFactorsDescriptionIterator");
        RowKeySet set =annuityFactrDescriptionLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        
        System.out.println(1);
        while (rowKeySetIter.hasNext()) 
        {
            List l = (List) rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
          
        System.out.println("OUT");
            session.setAttribute("ANNFD_CODE",r.getAttribute("ANNFD_CODE"));
             session.setAttribute("ANNF_ANNFD_CODE",r.getAttribute("ANNFD_CODE"));
            ADFUtils.findIterator("findAnnuityFactorsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(annuityFactorsLOV); 
           
            
        }
        System.out.println(2);
    }

    public void setAnnuityFactorsLOV(RichTable annuityFactorsLOV) {
        this.annuityFactorsLOV = annuityFactorsLOV;
    }

    public RichTable getAnnuityFactorsLOV() {
        return annuityFactorsLOV;
    }

    public void setRetirementAge(RichInputText retirementAge) {
        this.retirementAge = retirementAge;
    }

    public RichInputText getRetirementAge() {
        return retirementAge;
    }

    public void setGuaranteePeriod(RichInputText guaranteePeriod) {
        this.guaranteePeriod = guaranteePeriod;
    }

    public RichInputText getGuaranteePeriod() {
        return guaranteePeriod;
    }

    public void setMaleRate(RichInputText maleRate) {
        this.maleRate = maleRate;
    }

    public RichInputText getMaleRate() {
        return maleRate;
    }

    public void setFemaleRate(RichInputText femaleRate) {
        this.femaleRate = femaleRate;
    }

    public RichInputText getFemaleRate() {
        return femaleRate;
    }

    public void setWef(RichInputText wef) {
        this.wef = wef;
    }

    public RichInputText getWef() {
        return wef;
    }

    public void setWet(RichInputText wet) {
        this.wet = wet;
    }

    public RichInputText getWet() {
        return wet;
    }

    public String AddAnnuityFactors() {
        session.setAttribute("ANNF_CODE",null);
        // Render Popup
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:annuityFactorsPopup" +
        "').show(hints);");
        return null;
    }

    public String EditAnnuityFactors() {
        DCIteratorBinding dciter = ADFUtils.findIterator("findAnnuityFactorsIterator");
        RowKeySet set =annuityFactorsLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        
        //System.out.println(1);
        while (rowKeySetIter.hasNext()) 
        {
            List l = (List) rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
          
            session.setAttribute("ANNF_CODE",r.getAttribute("ANNF_CODE"));
            session.setAttribute("ANNFD_CODE",r.getAttribute("ANNF_ANNFD_CODE"));
            if(r.getAttribute("ANNF_RETIRE_AGE")==null) {
                retirementAge.setValue(null);
            }
            else {
                retirementAge.setValue(r.getAttribute("ANNF_RETIRE_AGE"));
            }
            if(r.getAttribute("ANNF_GUAR_PRD")==null) {
               guaranteePeriod.setValue(null);
            }
            else {
                guaranteePeriod.setValue(r.getAttribute("ANNF_GUAR_PRD"));
            }
            if(r.getAttribute("ANNF_MALE_RATE")==null) {
               maleRate.setValue(null);
            }
            else {
                maleRate.setValue(r.getAttribute("ANNF_MALE_RATE"));
            }
            if(r.getAttribute("ANNF_FEMALE_RATE")==null) {
               femaleRate.setValue(null);
            }
            else {
                femaleRate.setValue(r.getAttribute("ANNF_FEMALE_RATE"));
            }
           /* if(r.getAttribute("ANNF_WEF")==null) {
               wef.setValue(null);
            }
            else {
                wef.setValue((r.getAttribute("ANNF_WEF")));
            }*/
           /* if(r.getAttribute("ANNF_WET")==null) {
               wet.setValue(null);
            }
            else {
                wet.setValue((r.getAttribute("ANNF_WET")));
            }*/
            // Render Popup
            ExtendedRenderKitService erkService =
            Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
            ExtendedRenderKitService.class);
            erkService.addScript(FacesContext.getCurrentInstance(),
            "var hints = {autodismissNever:false}; " +
            "AdfPage.PAGE.findComponent('" + "lmsgroup:annuityFactorsPopup" +
            "').show(hints);");
           
            
        }
        return null;
    }

    public String DeleteAnnuityFactor() {
        String Result = "F";
        DCIteratorBinding dciter = ADFUtils.findIterator("findAnnuityFactorsIterator");
        RowKeySet set =annuityFactorsLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        
        //System.out.println(1);
        while (rowKeySetIter.hasNext()) 
        {
            List l = (List) rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
          
            session.setAttribute("ANNF_CODE",r.getAttribute("ANNF_CODE"));
            String authQuery="BEGIN LMS_SETUPS_PKG.deleteAnnFactor(?);END;";
            Connection conn=new DBConnector().getDatabaseConn();
            try
            {
            CallableStatement cstmt=conn.prepareCall(authQuery);    
            cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("ANNF_CODE"));
            cstmt.execute();
            conn.close();
                
                session.setAttribute("ANNF_CODE", null);
                ADFUtils.findIterator("findAnnuityFactorsIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(annuityFactorsLOV); 
                Result = "S";
            }
            catch(Exception ex) {
                GlobalCC.EXCEPTIONREPORTING(conn,ex);
            }
           
           
           
        }
        return Result;
    }
    
    public String SearchAgent(){
        try{
            if(searchAgent.getValue()==null){
              session.setAttribute("agnNameSearch", null);
            }else{
              session.setAttribute("agnNameSearch", searchAgent.getValue().toString());
            }
            
          ADFUtils.findIterator("findAgenciesIterator").executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(agentsTree); 
        }catch(Exception e){
          GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }
    
    public void agentsSelected(SelectionEvent selectionEvent)
      {
        if (selectionEvent.getAddedSet() != selectionEvent.getRemovedSet())
        {
          RowKeySet rowKeySet = this.agentsTree.getSelectedRowKeys();
          Object key2 = rowKeySet.iterator().next();
          this.agentsTree.setRowKey(key2);
          JUCtrlValueBinding nodeBinding = (JUCtrlValueBinding)this.agentsTree.getRowData();
          this.session.setAttribute("AGN_CODE", nodeBinding.getAttribute("agn_code"));
          this.session.setAttribute("agnCode", nodeBinding.getAttribute("agn_code"));
          this.session.setAttribute("agnShtDesc", nodeBinding.getAttribute("agn_sht_desc"));
          this.session.setAttribute("agnName", nodeBinding.getAttribute("agn_name"));
          this.session.setAttribute("action", "E");
          this.agentID.setValue(nodeBinding.getAttribute("agn_sht_desc"));
          this.agentName.setValue(nodeBinding.getAttribute("agn_name"));
          this.agnIdentityNo.setValue(nodeBinding.getAttribute("agn_id_no"));
          this.agnPhoneNo.setValue(nodeBinding.getAttribute("agn_phone_no"));
          this.pinNUmber.setValue(nodeBinding.getAttribute("agn_pin_no"));
          this.financingType.setValue(nodeBinding.getAttribute("agn_comm_allowed"));
          this.contractStatus.setValue(nodeBinding.getAttribute("agn_contracted"));
          this.profCertNo.setValue(nodeBinding.getAttribute("agn_proficiency_cert_no"));
          this.contractDate.setValue(nodeBinding.getAttribute("agn_contract_date"));
          this.agnDateJoined.setValue(nodeBinding.getAttribute("agn_date_joined"));
          this.agnBank.setValue(nodeBinding.getAttribute("agn_bank"));
          this.agnBankAccNo.setValue(nodeBinding.getAttribute("agn_bank_acc_no"));
          this.agnSmsNo.setValue(nodeBinding.getAttribute("agn_sms_tel"));
          this.referenceNo.setValue(nodeBinding.getAttribute("agn_reg_number"));
          this.agnPostLevel.setValue(nodeBinding.getAttribute("agn_reinsurer_desc"));
          this.agnEmailAddress.setValue(nodeBinding.getAttribute("agn_email_address"));
          this.agnReinsurer.setValue(nodeBinding.getAttribute("agn_reinsurer"));
          this.agnGLAccountNo.setValue(nodeBinding.getAttribute("agn_acc_no"));
          this.agnCreditAllowed.setValue(nodeBinding.getAttribute("agn_credit_allowed"));
          this.agnWthTax.setValue(nodeBinding.getAttribute("agn_wht_tax"));
          this.agnStatus.setValue(nodeBinding.getAttribute("agn_status"));
          this.agnRegNumber.setValue(nodeBinding.getAttribute("agn_reg_number"));
          this.commissionPayroll.setValue(nodeBinding.getAttribute("agn_comm_payable"));
          this.commPaymentMethod.setValue(nodeBinding.getAttribute("agn_comm_pymt_mthd"));
          this.commissionRates.setValue(nodeBinding.getAttribute("agn_comm_pymt_mthd_desc"));
          this.agentsBranch.setValue(nodeBinding.getAttribute("agn_comm_payable_desc"));
          this.postalAddress.setValue(nodeBinding.getAttribute("agn_postal_address"));
          this.whtRetained.setValue(nodeBinding.getAttribute("agn_retain_wthx"));
          AdfFacesContext.getCurrentInstance().addPartialTarget(this.agentID);
          AdfFacesContext.getCurrentInstance().addPartialTarget(this.agentName);
          AdfFacesContext.getCurrentInstance().addPartialTarget(this.postalAddress);
          AdfFacesContext.getCurrentInstance().addPartialTarget(this.whtRetained);
          AdfFacesContext.getCurrentInstance().addPartialTarget(this.agnIdentityNo);
          AdfFacesContext.getCurrentInstance().addPartialTarget(this.agnPhoneNo);
          AdfFacesContext.getCurrentInstance().addPartialTarget(this.pinNUmber);
          AdfFacesContext.getCurrentInstance().addPartialTarget(this.financingType);
          AdfFacesContext.getCurrentInstance().addPartialTarget(this.contractStatus);
          AdfFacesContext.getCurrentInstance().addPartialTarget(this.profCertNo);
          AdfFacesContext.getCurrentInstance().addPartialTarget(this.contractDate);
          AdfFacesContext.getCurrentInstance().addPartialTarget(this.agnDateJoined);
          AdfFacesContext.getCurrentInstance().addPartialTarget(this.agnBank);
          AdfFacesContext.getCurrentInstance().addPartialTarget(this.agnBankAccNo);
          AdfFacesContext.getCurrentInstance().addPartialTarget(this.agnSmsNo);
          AdfFacesContext.getCurrentInstance().addPartialTarget(this.referenceNo);
          AdfFacesContext.getCurrentInstance().addPartialTarget(this.agnPostLevel);
          AdfFacesContext.getCurrentInstance().addPartialTarget(this.agnEmailAddress);
          AdfFacesContext.getCurrentInstance().addPartialTarget(this.agnReinsurer);
          AdfFacesContext.getCurrentInstance().addPartialTarget(this.agnGLAccountNo);
          AdfFacesContext.getCurrentInstance().addPartialTarget(this.agnCreditAllowed);
          AdfFacesContext.getCurrentInstance().addPartialTarget(this.agnWthTax);
          AdfFacesContext.getCurrentInstance().addPartialTarget(this.agnStatus);
          AdfFacesContext.getCurrentInstance().addPartialTarget(this.postalAddress);
         AdfFacesContext.getCurrentInstance().addPartialTarget(this.whtRetained);
        }
      }

    public void setAgentsPanGrp(RichPanelGroupLayout agentsPanGrp) {
        this.agentsPanGrp = agentsPanGrp;
    }

    public RichPanelGroupLayout getAgentsPanGrp() {
        return agentsPanGrp;
    }

    public void setAgentID(RichInputText agentID) {
        this.agentID = agentID;
    }

    public RichInputText getAgentID() {
        return agentID;
    }

    public void setAgnIdentityNo(RichInputText agnIdentityNo) {
        this.agnIdentityNo = agnIdentityNo;
    }

    public RichInputText getAgnIdentityNo() {
        return agnIdentityNo;
    }

    public void setAgnPhoneNo(RichInputText agnPhoneNo) {
        this.agnPhoneNo = agnPhoneNo;
    }

    public RichInputText getAgnPhoneNo() {
        return agnPhoneNo;
    }

    public void setPinNUmber(RichInputText pinNUmber) {
        this.pinNUmber = pinNUmber;
    }

    public RichInputText getPinNUmber() {
        return pinNUmber;
    }

    public void setFinancingType(RichSelectOneChoice financingType) {
        this.financingType = financingType;
    }

    public RichSelectOneChoice getFinancingType() {
        return financingType;
    }

    public void setContractStatus(RichSelectOneChoice contractStatus) {
        this.contractStatus = contractStatus;
    }

    public RichSelectOneChoice getContractStatus() {
        return contractStatus;
    }

    public void setAgentName(RichInputText agentName) {
        this.agentName = agentName;
    }

    public RichInputText getAgentName() {
        return agentName;
    }

    public void setProfCertNo(RichInputText profCertNo) {
        this.profCertNo = profCertNo;
    }

    public RichInputText getProfCertNo() {
        return profCertNo;
    }

    public void setContractDate(RichInputDate contractDate) {
        this.contractDate = contractDate;
    }

    public RichInputDate getContractDate() {
        return contractDate;
    }

    public void setAgnDateJoined(RichInputDate agnDateJoined) {
        this.agnDateJoined = agnDateJoined;
    }

    public RichInputDate getAgnDateJoined() {
        return agnDateJoined;
    }

    public void setAgnDateTerminated(RichInputDate agnDateTerminated) {
        this.agnDateTerminated = agnDateTerminated;
    }

    public RichInputDate getAgnDateTerminated() {
        return agnDateTerminated;
    }

    public void setAgnBank(RichInputText agnBank) {
        this.agnBank = agnBank;
    }

    public RichInputText getAgnBank() {
        return agnBank;
    }

    public void setBanksLOV(RichTable banksLOV) {
        this.banksLOV = banksLOV;
    }

    public RichTable getBanksLOV() {
        return banksLOV;
    }

    public String AssignBank() {
        DCIteratorBinding dciter = ADFUtils.findIterator("findBankBranchesIterator");
        RowKeySet set =banksLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        
        //System.out.println(1);
        while (rowKeySetIter.hasNext()) 
        {
            List l = (List) rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
          
        
            session.setAttribute("BBR_CODE",r.getAttribute("bbrCode"));
            agnBank.setValue(r.getAttribute("bbrDescription"));
           
            
        }
        return null;
    }

    public void setAgnBankAccNo(RichInputText agnBankAccNo) {
        this.agnBankAccNo = agnBankAccNo;
    }

    public RichInputText getAgnBankAccNo() {
        return agnBankAccNo;
    }

    public void setAgnSmsNo(RichInputText agnSmsNo) {
        this.agnSmsNo = agnSmsNo;
    }

    public RichInputText getAgnSmsNo() {
        return agnSmsNo;
    }

    public void setReferenceNo(RichInputText referenceNo) {
        this.referenceNo = referenceNo;
    }

    public RichInputText getReferenceNo() {
        return referenceNo;
    }

    public void setAgnPostLevel(RichSelectOneChoice agnPostLevel) {
        this.agnPostLevel = agnPostLevel;
    }

    public RichSelectOneChoice getAgnPostLevel() {
        return agnPostLevel;
    }

    public void setAgnEmailAddress(RichInputText agnEmailAddress) {
        this.agnEmailAddress = agnEmailAddress;
    }

    public RichInputText getAgnEmailAddress() {
        return agnEmailAddress;
    }

    public void setAgnReinsurer(RichSelectOneChoice agnReinsurer) {
        this.agnReinsurer = agnReinsurer;
    }

    public RichSelectOneChoice getAgnReinsurer() {
        return agnReinsurer;
    }

    public void setAgnGLAccountNo(RichInputText agnGLAccountNo) {
        this.agnGLAccountNo = agnGLAccountNo;
    }

    public RichInputText getAgnGLAccountNo() {
        return agnGLAccountNo;
    }

    public void setAgnCreditAllowed(RichSelectOneChoice agnCreditAllowed) {
        this.agnCreditAllowed = agnCreditAllowed;
    }

    public RichSelectOneChoice getAgnCreditAllowed() {
        return agnCreditAllowed;
    }

    public void setAgnWthTax(RichInputText agnWthTax) {
        this.agnWthTax = agnWthTax;
    }

    public RichInputText getAgnWthTax() {
        return agnWthTax;
    }

    public void setRiDebitNote(RichSelectOneChoice riDebitNote) {
        this.riDebitNote = riDebitNote;
    }

    public RichSelectOneChoice getRiDebitNote() {
        return riDebitNote;
    }

    public void setAgnStatus(RichSelectOneChoice agnStatus) {
        this.agnStatus = agnStatus;
    }

    public RichSelectOneChoice getAgnStatus() {
        return agnStatus;
    }

    public void setAgnRegStatus(RichSelectOneChoice agnRegStatus) {
        this.agnRegStatus = agnRegStatus;
    }

    public RichSelectOneChoice getAgnRegStatus() {
        return agnRegStatus;
    }

    public void setAgnRegNumber(RichInputText agnRegNumber) {
        this.agnRegNumber = agnRegNumber;
    }

    public RichInputText getAgnRegNumber() {
        return agnRegNumber;
    }

    public void setCommissionPayroll(RichSelectOneChoice commissionPayroll) {
        this.commissionPayroll = commissionPayroll;
    }

    public RichSelectOneChoice getCommissionPayroll() {
        return commissionPayroll;
    }

    public void setCommPaymentMethod(RichSelectOneChoice commPaymentMethod) {
        this.commPaymentMethod = commPaymentMethod;
    }

    public RichSelectOneChoice getCommPaymentMethod() {
        return commPaymentMethod;
    }

    public void setCommRatesLOV(RichTable commRatesLOV) {
        this.commRatesLOV = commRatesLOV;
    }

    public RichTable getCommRatesLOV() {
        return commRatesLOV;
    }

    public String AssignCommissionRates() {
        DCIteratorBinding dciter = ADFUtils.findIterator("findCommissionRatesIterator");
        RowKeySet set =commRatesLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        
        //System.out.println(1);
        while (rowKeySetIter.hasNext()) 
        {
            List l = (List) rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
          
        
            session.setAttribute("ATR_CODE",r.getAttribute("atrCode"));
            commissionRates.setValue(r.getAttribute("atrDesc"));
           
            
        }
        return null;
    }

    public void setCommissionRates(RichInputText commissionRates) {
        this.commissionRates = commissionRates;
    }

    public RichInputText getCommissionRates() {
        return commissionRates;
    }

    public void setAgentsBranch(RichInputText agentsBranch) {
        this.agentsBranch = agentsBranch;
    }

    public RichInputText getAgentsBranch() {
        return agentsBranch;
    }

    public void setBranchesLOV(RichTable branchesLOV) {
        this.branchesLOV = branchesLOV;
    }

    public RichTable getBranchesLOV() {
        return branchesLOV;
    }

    public String AssignBranch() {
        DCIteratorBinding dciter = ADFUtils.findIterator("findBranchesIterator");
        RowKeySet set =branchesLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        
        //System.out.println(1);
        while (rowKeySetIter.hasNext()) 
        {
            List l = (List) rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
          
        
            session.setAttribute("BRN_CODE",r.getAttribute("brnCode"));
            agentsBranch.setValue(r.getAttribute("brnName"));
           
            
        }
        return null;
    }

    public void setContactsLOV(RichTable contactsLOV) {
        this.contactsLOV = contactsLOV;
    }

    public RichTable getContactsLOV() {
        return contactsLOV;
    }

    public String SaveAnnuityFactors() {
        if(retirementAge.getValue()==null) {
            String Message = "Enter Retirement Age.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
           return null;
        }
        if(guaranteePeriod.getValue()==null) {
            String Message = "Enter Guarantee Period.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
           return null;
        }
        if(maleRate.getValue()==null) {
            String Message = "Enter Male Rate.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
           return null;
        }
        if(femaleRate.getValue()==null) {
            String Message = "Enter Female Rate.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
           return null;
        }
        if(wefAnn.getValue()==null) {
            String Message = "Enter Wef date.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
           return null;
        }
        String updateQuery="BEGIN LMS_SETUPS_PKG.updateAnnFactor(?,?,?,?,?,?,?,?);END;";
        Connection conn=new DBConnector().getDatabaseConn();
        try
        {
        CallableStatement cstmt=conn.prepareCall(updateQuery);    
        cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("ANNF_CODE"));
        cstmt.setBigDecimal(2, (BigDecimal)session.getAttribute("ANNF_ANNFD_CODE"));
        cstmt.setString(3, retirementAge.getValue().toString());  
        cstmt.setString(4, guaranteePeriod.getValue().toString());  
        cstmt.setString(5,maleRate.getValue().toString());   
        cstmt.setString(6,femaleRate.getValue().toString());  
        cstmt.setString(7, GlobalCC.parseDate(wefAnn.getValue().toString()));
        if(wetDate.getValue()==null) {
            cstmt.setString(8,null);
        }
            else {
            cstmt.setString(8, GlobalCC.parseDate(wetDate.getValue().toString()));
        }
        cstmt.execute();
        conn.close();
        
        String Message = "Annuity factor  saved successfully.";
        FacesContext.getCurrentInstance().addMessage(null, 
                                                     new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                      Message, 
                                                                      Message));
        
        session.setAttribute("ANNF_CODE", null);
            ADFUtils.findIterator("findAnnuityFactorsIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(annuityFactorsLOV); 
        }
        catch(Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
        }
        return null;
    }

    public void setWefAnn(RichInputDate wefAnn) {
        this.wefAnn = wefAnn;
    }

    public RichInputDate getWefAnn() {
        return wefAnn;
    }

    public void setWetDate(RichInputDate wetDate) {
        this.wetDate = wetDate;
    }

    public RichInputDate getWetDate() {
        return wetDate;
    }

    public void setAnnProductsLOV(RichTable annProductsLOV) {
        this.annProductsLOV = annProductsLOV;
    }

    public RichTable getAnnProductsLOV() {
        return annProductsLOV;
    }

    public void annuityProductsLOV(SelectionEvent selectionEvent) {
        DCIteratorBinding dciter = ADFUtils.findIterator("findProductsIterator");
        RowKeySet set =annProductsLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        
        //System.out.println(1);
        while (rowKeySetIter.hasNext()) 
        {
            List l = (List) rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
          
        
            session.setAttribute("ProductCode",r.getAttribute("PROD_CODE"));
            ADFUtils.findIterator("findAnnuityTypesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(annuityTypesLOV); 
            
            session.setAttribute("ATY_CODE", null);

            ADFUtils.findIterator("findAnnuityTypesRatesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(annuityTypeRates);
           
            
        }
    }

    public void setAnnuityTypesLOV(RichTable annuityTypesLOV) {
        this.annuityTypesLOV = annuityTypesLOV;
    }

    public RichTable getAnnuityTypesLOV() {
        return annuityTypesLOV;
    }

    public String AddAnnuityType() {
        session.setAttribute("ATY_CODE",null);
        annuityType.setValue(null);
        annGuaranteePeriod.setValue(null);
        annuityOption.setValue(null);
        annRetirementAge.setValue(null);
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:annuityTypePopup" +
        "').show(hints);");
        return null;
    }

    public String EditAnnuityType() {
        DCIteratorBinding dciter = ADFUtils.findIterator("findAnnuityTypesIterator");
        RowKeySet set =annuityTypesLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        
        //System.out.println(1);
        while (rowKeySetIter.hasNext()) 
        {
            List l = (List) rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
          
            session.setAttribute("ATY_CODE",r.getAttribute("atyCode"));
           
            if(r.getAttribute("atyGuaranteePeriod")==null) {
                annGuaranteePeriod.setValue(null);
            }
            else {
                annGuaranteePeriod.setValue(r.getAttribute("atyGuaranteePeriod"));
            }
            if(r.getAttribute("atyOption")==null) {
               annuityOption.setValue(null);
            }
            else {
                annuityOption.setValue((String)r.getAttribute("atyOption"));
            }
            if(r.getAttribute("atyType")==null) {
               annuityType.setValue(null);
            }
            else {
                annuityType.setValue((String)r.getAttribute("atyType"));
            }
            
            // Render Popup
            ExtendedRenderKitService erkService =
            Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
            ExtendedRenderKitService.class);
            erkService.addScript(FacesContext.getCurrentInstance(),
            "var hints = {autodismissNever:false}; " +
            "AdfPage.PAGE.findComponent('" + "lmsgroup:annuityTypePopup" +
            "').show(hints);");
           
            
        }
       
        return null;
    }

    public String DeleteAnnuityType() {
        String Result = "F";
        DCIteratorBinding dciter = ADFUtils.findIterator("findAnnuityTypesIterator");
        RowKeySet set =annuityTypesLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        
        //System.out.println(1);
        while (rowKeySetIter.hasNext()) 
        {
            List l = (List) rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
          
            session.setAttribute("ATY_CODE",r.getAttribute("atyCode"));
            String authQuery="BEGIN LMS_SETUPS_PKG.deleteAnnuityType(?);END;";
            Connection conn=new DBConnector().getDatabaseConn();
            try
            {
            CallableStatement cstmt=conn.prepareCall(authQuery);    
            cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("ATY_CODE"));
            cstmt.execute();
            conn.close();

                session.setAttribute("ATY_CODE", null);
                ADFUtils.findIterator("findAnnuityTypesIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(annuityTypesLOV); 
                Result = "S";
            }
            catch(Exception ex) {
                GlobalCC.EXCEPTIONREPORTING(conn,ex);
            }
           
           
           
        }
        return Result;
    }

    public void setAnnuityType(RichSelectOneChoice annuityType) {
        this.annuityType = annuityType;
    }

    public RichSelectOneChoice getAnnuityType() {
        return annuityType;
    }

    public void setAnnGuaranteePeriod(RichInputText annGuaranteePeriod) {
        this.annGuaranteePeriod = annGuaranteePeriod;
    }

    public RichInputText getAnnGuaranteePeriod() {
        return annGuaranteePeriod;
    }

    public void setAnnuityOption(RichSelectOneChoice annuityOption) {
        this.annuityOption = annuityOption;
    }

    public RichSelectOneChoice getAnnuityOption() {
        return annuityOption;
    }

    public String SaveAnnuityType() {
        if(annuityType.getValue()==null) {
            String Message = "Please Select Annuity Type.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
           return null;
        }
        if(annGuaranteePeriod.getValue()==null) {
            String Message = "Enter Guarantee Period.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
           return null;
        }
        if(annuityType.getValue().toString().equalsIgnoreCase("IMMEDIATE")) {
            if(annuityOption.getValue()==null)
            {
                String Message = "Select Annuity Option.";
                FacesContext.getCurrentInstance().addMessage(null, 
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                              Message, 
                                                                              Message));
                return null;
            }
        }
        
        String saveQuery="BEGIN LMS_SETUPS_PKG.updateAnnuityType(?,?,?,?,?,?);END;";
        Connection conn=null;
        try
        {
            conn=new DBConnector().getDatabaseConn();
        CallableStatement cstmt=conn.prepareCall(saveQuery);    
        cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("ATY_CODE"));
        cstmt.setString(2, annGuaranteePeriod.getValue().toString());
            if(annuityOption.getValue()==null) {
                cstmt.setString(3, null);  
            }
            else {
                cstmt.setString(3, annuityOption.getValue().toString()); 
            }
        cstmt.setBigDecimal(4, (BigDecimal)session.getAttribute("ProductCode"));  
        cstmt.setString(5,annuityType.getValue().toString());   
        if(annRetirementAge.getValue()==null) {
            cstmt.setString(6, null);  
        }
        else {
            cstmt.setString(6, annRetirementAge.getValue().toString()); 
        }
        cstmt.execute();
        conn.close();
        
        String Message = "Annuity Type Saved successfully.";
        FacesContext.getCurrentInstance().addMessage(null, 
                                                     new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                      Message, 
                                                                      Message));
        
        session.setAttribute("ATY_CODE", null);
            ADFUtils.findIterator("findAnnuityTypesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(annuityTypesLOV); 
        }
        catch(Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
        }
        return null;
    }

    public String AddAnnuityRateType() {
        session.setAttribute("ANNTR_CODE",null);
        anbAtEntry.setValue(null);
        annuityTypeRate.setValue(null);
        annuityTypeGender.setValue(null);
        
        GlobalCC.showPopup("lmsgroup:AnnuityTypeRatesPopup");    
        return null;
    }

    public String EditAnnuityTypeRate() {
        DCIteratorBinding dciter = ADFUtils.findIterator("findAnnuityTypesRatesIterator");
        RowKeySet set =annuityTypeRates.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        
        //System.out.println(1);
        while (rowKeySetIter.hasNext()) 
        {
            List l = (List) rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
          
            session.setAttribute("ANNTR_CODE",r.getAttribute("anntrCode"));
            //session.setAttribute("ATY_CODE",r.getAttribute("atyCode"));
            if(r.getAttribute("anntrAnb")==null) {
               anbAtEntry.setValue(null);
            }
            else {
                anbAtEntry.setValue(r.getAttribute("anntrAnb"));
            }
            if(r.getAttribute("anntrRate")==null) {
               annuityTypeRate.setValue(null);
            }
            else {
                annuityTypeRate.setValue(r.getAttribute("anntrRate"));
            }
          annuityTypeGender.setValue(r.getAttribute("anntrGender"));
          GlobalCC.showPopup("lmsgroup:AnnuityTypeRatesPopup");         
        }
        return null;
    }

    public void setAnbAtEntry(RichInputText anbAtEntry) {
        this.anbAtEntry = anbAtEntry;
    }

    public RichInputText getAnbAtEntry() {
        return anbAtEntry;
    }

    public void setAnnuityTypeRate(RichInputText annuityTypeRate) {
        this.annuityTypeRate = annuityTypeRate;
    }

    public RichInputText getAnnuityTypeRate() {
        return annuityTypeRate;
    }

    public String SaveAnnuityTypeRate() {
        if(anbAtEntry.getValue()==null) {
            String Message = "Please Enter Anb At Entry.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
           return null;
        }
        if(annuityTypeRate.getValue()==null) {
            String Message = "Enter Annuity Type Rate.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
           return null;
        }
        
        Connection conn=null;
        String saveQuery="BEGIN LMS_SETUPS_PKG.updateAnnuityTypeRate(?,?,?,?,?);END;";
        try
        {
        conn=new DBConnector().getDatabaseConn();
        CallableStatement cstmt=conn.prepareCall(saveQuery);    
        cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("ANNTR_CODE"));
        cstmt.setBigDecimal(2, (BigDecimal)session.getAttribute("ATY_CODE"));
        if(anbAtEntry.getValue()==null){
            cstmt.setString(3,null);        
        }else{
            cstmt.setString(3,anbAtEntry.getValue().toString());       
        }
        if(annuityTypeRate.getValue()==null){
            cstmt.setString(4,null);        
        }else{
            cstmt.setString(4,annuityTypeRate.getValue().toString());       
        } 
        if(annuityTypeGender.getValue()==null){
          cstmt.setString(5,null);        
        }else{
          cstmt.setString(5,annuityTypeGender.getValue().toString());       
        }
          
        
        cstmt.execute();
        conn.close();
        
        String Message = "Annuity Type Rate  saved successfully.";
        FacesContext.getCurrentInstance().addMessage(null, 
                                                     new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                      Message, 
                                                                      Message));
        
        session.setAttribute("ANNTR_CODE", null);
            ADFUtils.findIterator("findAnnuityTypesRatesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(annuityTypeRates); 
        }
        catch(Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
        }
        return null;
    }

    public void setAnnuityTypeRates(RichTable annuityTypeRates) {
        this.annuityTypeRates = annuityTypeRates;
    }

    public RichTable getAnnuityTypeRates() {
        return annuityTypeRates;
    }

    public String DeleteAnnuityTypeRate() {
        String Result = "F";
        DCIteratorBinding dciter = ADFUtils.findIterator("findAnnuityTypesRatesIterator");
        RowKeySet set =annuityTypeRates.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        
        //System.out.println(1);
        while (rowKeySetIter.hasNext()) 
        {
            List l = (List) rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
          
            session.setAttribute("ANNTR_CODE",r.getAttribute("anntrCode"));
            String authQuery="BEGIN LMS_SETUPS_PKG.deleteAnnuityTypeRate(?);END;";
            Connection conn=new DBConnector().getDatabaseConn();
            try
            {
            CallableStatement cstmt=conn.prepareCall(authQuery);    
            cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("ANNTR_CODE"));
            cstmt.execute();
            conn.close();
          
                session.setAttribute("ANNTR_CODE", null);
                ADFUtils.findIterator("findAnnuityTypesRatesIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(annuityTypeRates);
              Result = "S";
            }
            catch(Exception ex) {
                GlobalCC.EXCEPTIONREPORTING(conn,ex);
            }
           
           
           
        }
        return Result;
    }

    public void AnnuityTypeListener(SelectionEvent selectionEvent) {
        DCIteratorBinding dciter = ADFUtils.findIterator("findAnnuityTypesIterator");
        RowKeySet set =annuityTypesLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        
        //System.out.println(1);
        while (rowKeySetIter.hasNext()) 
        {
            List l = (List) rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
          
            session.setAttribute("ATY_CODE",r.getAttribute("atyCode"));

            ADFUtils.findIterator("findAnnuityTypesRatesIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(annuityTypeRates);
           
           
           
           
        }
    }

    public void setCvtDpdProductsLOV(RichTable cvtDpdProductsLOV) {
        this.cvtDpdProductsLOV = cvtDpdProductsLOV;
    }

    public RichTable getCvtDpdProductsLOV() {
        return cvtDpdProductsLOV;
    }

    public void ProductsDpsListener(SelectionEvent selectionEvent) {
        DCIteratorBinding dciter = ADFUtils.findIterator("findProductsIterator");
        RowKeySet set =cvtDpdProductsLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        
        //System.out.println(1);
        while (rowKeySetIter.hasNext()) 
        {
            List l = (List) rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
          
        
            session.setAttribute("ProductCode",r.getAttribute("PROD_CODE"));
            ADFUtils.findIterator("findProdCoverTypesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(coverTypesLOV); 
           
            
        }
    }

    public void setCoverTypesLOV(RichTable coverTypesLOV) {
        this.coverTypesLOV = coverTypesLOV;
    }

    public RichTable getCoverTypesLOV() {
        return coverTypesLOV;
    }

    public void ProductCoverTypesListener(SelectionEvent selectionEvent) {
        DCIteratorBinding dciter = ADFUtils.findIterator("findProdCoverTypesIterator");
        RowKeySet set =coverTypesLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        
        //System.out.println(1);
        while (rowKeySetIter.hasNext()) 
        {
            List l = (List) rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
          
        
            session.setAttribute("PCT_CODE",r.getAttribute("PCT_CODE"));
            ADFUtils.findIterator("findTreatyLOVIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(prodCvtDependantsLOV); 
           
            
        }
    }

    public void setProdCvtDependantsLOV(RichTable prodCvtDependantsLOV) {
        this.prodCvtDependantsLOV = prodCvtDependantsLOV;
    }

    public RichTable getProdCvtDependantsLOV() {
        return prodCvtDependantsLOV;
    }

    public String AddDependentType() {
        session.setAttribute("PCD_CODE", null);
        session.setAttribute("DTY_CODE",null);
        dependentType.setValue(null);
        maxNoAllowed.setValue(null);
        maxSumAssured.setValue(null);
        minSumAssured.setValue(null);
        maximumAge.setValue(null);
        minimumAge.setValue(null);
        defaultVal.setValue(null);
        
        GlobalCC.showPopup("lmsgroup:CreateDepTypePopup");
        return null;
    }

    public String AssignDependentType() {
        DCIteratorBinding dciter = ADFUtils.findIterator("findDependentsLOVIterator");
        RowKeySet set =dependentsLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        
        //System.out.println(1);
        while (rowKeySetIter.hasNext()) 
        {
            List l = (List) rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
          
        
            session.setAttribute("DTY_CODE",r.getAttribute("dtyCode"));
            dependentType.setValue(r.getAttribute("dtyDesc"));
            
           
            
        }
      GlobalCC.showPopup("lmsgroup:CreateDepTypePopup");
     
        return null;
    }

    public void setDependentsLOV(RichTable dependentsLOV) {
        this.dependentsLOV = dependentsLOV;
    }

    public RichTable getDependentsLOV() {
        return dependentsLOV;
    }

    public void setDependentType(RichInputText dependentType) {
        this.dependentType = dependentType;
    }

    public RichInputText getDependentType() {
        return dependentType;
    }

    public void setMaxNoAllowed(RichInputText maxNoAllowed) {
        this.maxNoAllowed = maxNoAllowed;
    }

    public RichInputText getMaxNoAllowed() {
        return maxNoAllowed;
    }

    public void setMinimumAge(RichInputText minimumAge) {
        this.minimumAge = minimumAge;
    }

    public RichInputText getMinimumAge() {
        return minimumAge;
    }

    public void setMaximumAge(RichInputText maximumAge) {
        this.maximumAge = maximumAge;
    }

    public RichInputText getMaximumAge() {
        return maximumAge;
    }

    public void setMaxSumAssured(RichInputText maxSumAssured) {
        this.maxSumAssured = maxSumAssured;
    }

    public RichInputText getMaxSumAssured() {
        return maxSumAssured;
    }

    public String SaveDependentType() {
        if(maxNoAllowed.getValue()==null) {
            String Message = "Please Enter The Maximum Number Of Dependents Allowed.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
           return null;
        }
        if(minimumAge.getValue()==null) {
            String Message = "Enter Minimum Age.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
           return null;
        }
        if(maximumAge.getValue()==null) {
            String Message = "Enter Maximum Age.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
           return null;
        }
        /*if(maxSumAssured.getValue()==null) {
            String Message = "Enter Maximum Sum Assured.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
           return null;
        }*/
        Connection conn=null;
        String saveQuery="BEGIN LMS_SETUPS_PKG.updtprodcvtdependants(?,?,?,?,?,?,?,?,?);END;";
        try
        {
            conn=new DBConnector().getDatabaseConn();
        CallableStatement cstmt=conn.prepareCall(saveQuery);    
        cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("PCD_CODE"));
        cstmt.setBigDecimal(2, (BigDecimal)session.getAttribute("PCT_CODE"));
        cstmt.setBigDecimal(3, (BigDecimal)session.getAttribute("DTY_CODE"));
        cstmt.setString(4,maxNoAllowed.getValue().toString());   
        cstmt.setString(5,minimumAge.getValue().toString()); 
        cstmt.setString(6,maximumAge.getValue().toString()); 
        if(maxSumAssured.getValue()==null){
          cstmt.setString(7, null); 
        }else{
          cstmt.setString(7,maxSumAssured.getValue().toString()); 
        }
        if(minSumAssured.getValue()==null){
          cstmt.setString(8, null); 
        }else{
          cstmt.setString(8,minSumAssured.getValue().toString()); 
        }
        if(defaultVal.getValue()==null){
            cstmt.setString(9, null); 
        }else{
            cstmt.setString(9,defaultVal.getValue().toString()); 
        }
        cstmt.execute();
        conn.close();
        
        String Message = "Product Cover Type Dependent saved successfully.";
        FacesContext.getCurrentInstance().addMessage(null, 
                                                     new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                      Message, 
                                                                      Message));
        
            session.setAttribute("PCD_CODE",null);
            ADFUtils.findIterator("findTreatyLOVIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(prodCvtDependantsLOV); 
        }
        catch(Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
        }
        return null;
    }

    public String EditDependentType() {
        DCIteratorBinding dciter = ADFUtils.findIterator("findTreatyLOVIterator");
        RowKeySet set =prodCvtDependantsLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        
        //System.out.println(1);
        while (rowKeySetIter.hasNext()) 
        {
            List l = (List) rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
          
        
            session.setAttribute("PCD_CODE",r.getAttribute("pcdCode"));
            session.setAttribute("PCT_CODE",r.getAttribute("pcdPctcode"));
            session.setAttribute("DTY_CODE",r.getAttribute("pcdDtycode"));
            dependentType.setValue(r.getAttribute("dtyDescription"));
            maxNoAllowed.setValue(r.getAttribute("pcdMaxnoallowed"));
            maxSumAssured.setValue(r.getAttribute("pcdMaxsumassured"));
            minSumAssured.setValue(r.getAttribute("pcdMinsumassrd"));
            maximumAge.setValue(r.getAttribute("pcdMaxage"));
            minimumAge.setValue(r.getAttribute("pcdMinage"));
            defaultVal.setValue(r.getAttribute("pcd_default"));

        }
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:CreateDepTypePopup" +
        "').show(hints);");
        return null;
    }

    public String DeleteDependentType() {
        DCIteratorBinding dciter = ADFUtils.findIterator("findTreatyLOVIterator");
        RowKeySet set =prodCvtDependantsLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        
        //System.out.println(1);
        while (rowKeySetIter.hasNext()) 
        {
            List l = (List) rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
          
        
            
            session.setAttribute("PCD_CODE",r.getAttribute("pcdCode"));
            
           
           
            
        }
        String authQuery="BEGIN LMS_SETUPS_PKG.delprodcvtdependants(?);END;";
        Connection conn=new DBConnector().getDatabaseConn();
        try
        {
        CallableStatement cstmt=conn.prepareCall(authQuery);    
        cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("PCD_CODE"));
        cstmt.execute();
        conn.close();
            String Message = "Product Cover Type Dependent deleted successfully.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            
            session.setAttribute("PCT_CODE",null);
            ADFUtils.findIterator("findTreatyLOVIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(prodCvtDependantsLOV); 
        }
        catch(Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
        }
        return null;
    }
    
    public String AddAgent(){
        try{
            session.setAttribute("AGN_CODE", null);
            session.setAttribute("action", "A");
            agentID.setValue(null);
            agentName.setValue(null);
            agnIdentityNo.setValue(null);
            agnPhoneNo.setValue(null);
            pinNUmber.setValue(null);
            financingType.setValue(null);
            contractStatus.setValue(null);
            profCertNo.setValue(null);
            contractDate.setValue(null);
            agnDateJoined.setValue(null);
            agnBank.setValue(null);
            agnBankAccNo.setValue(null);
            agnSmsNo.setValue(null);
            referenceNo.setValue(null);
            agnPostLevel.setValue(null);
            agnEmailAddress.setValue(null);
            agnReinsurer.setValue(null);
            agnGLAccountNo.setValue(null);
            agnCreditAllowed.setValue(null);
            agnWthTax.setValue(null);
            //  riDebitNote.setValue(nodeBinding.getAttribute("agn_printdb_note"));
            agnStatus.setValue(null);
            agnRegNumber.setValue(null);
            commissionPayroll.setValue(null);
            commPaymentMethod.setValue(null);
            commissionRates.setValue(null);
            agentsBranch.setValue(null);

            ADFUtils.findIterator("findContactPersonsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(contactsLOV); 
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String SaveAgent() {
        String authQuery="BEGIN LMS_SETUPS_PKG.updateagenies(?,?,?,?,?,?,?,?,?,?,?," +
            "?,?,?,?,?,?,?,?,?,?," +
            "?,?,?,?,?,?,?,?,?,?," +
            "?,?);END;";
        Connection conn=new DBConnector().getDatabaseConn();
        try
        {
            CallableStatement cstmt=conn.prepareCall(authQuery);    
            cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("AGN_CODE"));
            if(agentID.getValue()==null) {
                cstmt.setString(2,null);
            }
            else {
                cstmt.setString(2,agentID.getValue().toString());
            }
            if(agentName.getValue()==null) {
                cstmt.setString(3,null);
            }
            else {
                cstmt.setString(3,agentName.getValue().toString());
            }
            if(agnIdentityNo.getValue()==null) {
                cstmt.setString(4,null);
            }
            else {
                cstmt.setString(4,agnIdentityNo.getValue().toString());
            }
            if(agnPhoneNo.getValue()==null) {
                cstmt.setString(5,null);
            }
            else {
                cstmt.setString(5,agnPhoneNo.getValue().toString());
            }
            if(financingType.getValue()==null) {
                cstmt.setString(6,null);
            }
            else {
                cstmt.setString(6,financingType.getValue().toString());
            }
            if(contractStatus.getValue()==null) {
                cstmt.setString(7,null);
            }
            else {
                cstmt.setString(7,contractStatus.getValue().toString());
            }
            if(profCertNo.getValue()==null) {
                cstmt.setString(8,null);
            }
            else {
                cstmt.setString(8,profCertNo.getValue().toString());
            }
            if (contractDate.getValue() == null) {
                cstmt.setString(9, null);
            } else {
                String todayString = null;
                if (contractDate.getValue().toString().contains(":")) {
                    todayString = GlobalCC.parseDate(contractDate.getValue().toString());
                } else {
                    todayString = GlobalCC.upDateParseDate(contractDate.getValue().toString());
                }
                cstmt.setString(9, todayString);
            }
            if (agnDateJoined.getValue() == null) {
                cstmt.setString(10, null);
            } else {
                String todayString = null;
                if (agnDateJoined.getValue().toString().contains(":")) {
                    todayString = GlobalCC.parseDate(agnDateJoined.getValue().toString());
                } else {
                    todayString = GlobalCC.upDateParseDate(agnDateJoined.getValue().toString());
                }
                cstmt.setString(10, todayString);
            }
            if (agnDateTerminated.getValue() == null) {
                cstmt.setString(11, null);
            } else {
                String todayString = null;
                if (agnDateTerminated.getValue().toString().contains(":")) {
                    todayString = GlobalCC.parseDate(agnDateTerminated.getValue().toString());
                } else {
                    todayString = GlobalCC.upDateParseDate(agnDateTerminated.getValue().toString());
                }
                cstmt.setString(11, todayString);
            }
            if(agnBank.getValue()==null) {
                cstmt.setString(12,null);
            }
            else {
                cstmt.setString(12,agnBank.getValue().toString());
            }
            if(agnBankAccNo.getValue()==null) {
                cstmt.setString(13,null);
            }
            else {
                cstmt.setString(13,agnBankAccNo.getValue().toString());
            }
            if(agnSmsNo.getValue()==null) {
                cstmt.setString(14,null);
            }
            else {
                cstmt.setString(14,agnSmsNo.getValue().toString());
            }
            if(agnEmailAddress.getValue()==null) {
                cstmt.setString(15,null);
            }
            else {
                cstmt.setString(15,agnEmailAddress.getValue().toString());
            }
            if(agnReinsurer.getValue()==null) {
                cstmt.setString(16,null);
            }
            else {
                cstmt.setString(16,agnReinsurer.getValue().toString());
            }
            if(agnGLAccountNo.getValue()==null) {
                cstmt.setString(17,null);
            }
            else {
                cstmt.setString(17,agnGLAccountNo.getValue().toString());
            }
            if(agnCreditAllowed.getValue()==null) {
                cstmt.setString(18,null);
            }
            else {
                cstmt.setString(18,agnCreditAllowed.getValue().toString());
            }
            if(agnWthTax.getValue()==null) {
                cstmt.setString(19,null);
            }
            else {
                cstmt.setString(19,agnWthTax.getValue().toString());
            }
            if(riDebitNote.getValue()==null) {
                cstmt.setString(20,null);
            }
            else {
                cstmt.setString(20,riDebitNote.getValue().toString());
            }
            if(agnStatus.getValue()==null) {
                cstmt.setString(21,null);
            }
            else {
                cstmt.setString(21,agnStatus.getValue().toString());
            }
            if(agnRegStatus.getValue()==null) {
                cstmt.setString(22,null);
            }
            else {
                cstmt.setString(22,agnRegStatus.getValue().toString());
            }
            if(agnRegNumber.getValue()==null) {
                cstmt.setString(23,null);
            }
            else {
                cstmt.setString(23,agnRegNumber.getValue().toString());
            }
            if(commissionPayroll.getValue()==null) {
                cstmt.setString(24,null);
            }
            else {
                cstmt.setString(24,commissionPayroll.getValue().toString());
            }
            if(commPaymentMethod.getValue()==null) {
                cstmt.setString(25,null);
            }
            else {
                cstmt.setString(25,commPaymentMethod.getValue().toString());
            }
            cstmt.setBigDecimal(26, (BigDecimal)session.getAttribute("ACT_CODE"));
            if(pinNUmber.getValue()==null) {
                cstmt.setString(27,null);
            }
            else {
                cstmt.setString(27,pinNUmber.getValue().toString());
            }
            cstmt.setBigDecimal(28, null);
            cstmt.setBigDecimal(29, (BigDecimal)session.getAttribute("BRN_CODE"));
            if(referenceNo.getValue()==null) {
                cstmt.setString(30,null);
            }
            else {
                cstmt.setString(30,referenceNo.getValue().toString());
            }
            if(agnPostLevel.getValue()==null) {
                cstmt.setString(31,null);
            }
            else {
                cstmt.setString(31,agnPostLevel.getValue().toString());
            }
            cstmt.setString(32,(String)session.getAttribute("action"));
            cstmt.registerOutParameter(33, OracleTypes.DECIMAL);
            cstmt.execute();
            session.setAttribute("AGN_CODE", cstmt.getBigDecimal(33));
            
            conn.close();
                String Message = "Agent Details Saved successfully.";
                FacesContext.getCurrentInstance().addMessage(null, 
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                              Message, 
                                                                              Message));
                
                //session.setAttribute("AGN_CODE",null);
            ADFUtils.findIterator("findAgenciesIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(agentsTree);
        }
        catch(Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
        }
        return null;
    }

    public String AssignNewAgents() {
      Connection conn=null;
    try{
        DCIteratorBinding dciter = ADFUtils.findIterator("findNewAgentsIterator");
        RowKeySet set =newAgentsLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        
        //System.out.println(1);
        while (rowKeySetIter.hasNext()) 
        {
            List l = (List) rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
            session.setAttribute("AGN_CODE",r.getAttribute("agnCode"));
        }
        String Action = (String)session.getAttribute("action");
        if(Action==null){
          Action = "A";
        }
        if (Action.equalsIgnoreCase("A")){
            
        String authQuery="BEGIN LMS_SETUPS_PKG.createNewAgent(?);END;";
        conn=new DBConnector().getDatabaseConn();
        
            CallableStatement cstmt=conn.prepareCall(authQuery);    
            cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("AGN_CODE"));
            cstmt.execute();
            conn.close();
                GlobalCC.INFORMATIONREPORTING("Agent Created successfully.");

            //session.setAttribute("AGN_CODE",null);
                ADFUtils.findIterator("findAgenciesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(agentsTree);
            session.setAttribute("action", "E");
        }
    }catch(Exception ex) {
                GlobalCC.EXCEPTIONREPORTING(conn,ex);
        }
        return null;
    }

    public void setNewAgentsLOV(RichTable newAgentsLOV) {
        this.newAgentsLOV = newAgentsLOV;
    }

    public RichTable getNewAgentsLOV() {
        return newAgentsLOV;
    }

    public String ShowNewAgents() {
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:NewAgentsPopup" +
        "').show(hints);");
        return null;
    }

    public void setContactTitle(RichInputText contactTitle) {
        this.contactTitle = contactTitle;
    }

    public RichInputText getContactTitle() {
        return contactTitle;
    }

    public void setContactPerson(RichSelectOneChoice contactPerson) {
        this.contactPerson = contactPerson;
    }

    public RichSelectOneChoice getContactPerson() {
        return contactPerson;
    }

    public String SaveContactPerson() {
        if(contactTitle.getValue()==null) {
            String Message = "Enter Contact Person's Title.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
           return null;
        }
        if(contactPerson.getValue()==null) {
            String Message = "Enter Contact Person.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
           return null;
        }
        String saveQuery="BEGIN LMS_SETUPS_PKG.update_agency_contacts(?,?,?,?,?,?,?,?,?);END;";
        Connection conn=null;
        try
        {
           conn=new DBConnector().getDatabaseConn();
        CallableStatement cstmt=conn.prepareCall(saveQuery);    
        cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("LAC_CODE"));
        cstmt.setBigDecimal(2, (BigDecimal)session.getAttribute("AGN_CODE"));
        cstmt.setString(3,contactPerson.getValue().toString());   
        cstmt.setString(4,contactTitle.getValue().toString()); 
        if(contactName.getValue()==null){
            cstmt.setString(5, null);      
        }else{
            cstmt.setString(5, contactName.getValue().toString());      
        }
            if(contactSex.getValue()==null){
                cstmt.setString(6, null);      
            }else{
                cstmt.setString(6, contactSex.getValue().toString());      
            }
            if(contactTelephone.getValue()==null){
                cstmt.setString(7, null);      
            }else{
                cstmt.setString(7, contactTelephone.getValue().toString());      
            }
            if(contactAddress.getValue()==null){
                cstmt.setString(8, null);      
            }else{
                cstmt.setString(8, contactAddress.getValue().toString());      
            }
            if(contactEmail.getValue()==null){
                cstmt.setString(9, null);      
            }else{
                cstmt.setString(9, contactEmail.getValue().toString());      
            }
         
        cstmt.execute();
        conn.close();
        
        String Message = "Contact Person saved successfully.";
        FacesContext.getCurrentInstance().addMessage(null, 
                                                     new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                      Message, 
                                                                      Message));
        
            session.setAttribute("LAC_CODE",null);
            ADFUtils.findIterator("findContactPersonsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(contactsLOV); 
        }
        catch(Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
        }
        return null;
    }

    public String CreateContactPerson() {
        session.setAttribute("LAC_CODE",null);
        contactPerson.setValue("Next of Kin");
        contactTitle.setValue(null);
        contactName.setValue(null);
        contactSex.setValue("M");
        contactTelephone.setValue(null);
        contactAddress.setValue(null);
        contactEmail.setValue(null);
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:ContactsPopup" +
        "').show(hints);");
        return null;
    }

    public String EditContactPerson() {
        DCIteratorBinding dciter = ADFUtils.findIterator("findContactPersonsIterator");
        RowKeySet set =contactsLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        
        //System.out.println(1);
        while (rowKeySetIter.hasNext()) 
        {
            List l = (List) rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
          
        
            
            session.setAttribute("LAC_CODE",r.getAttribute("lacCode"));
            if(r.getAttribute("lacContactPerson")==null) {
                contactPerson.setValue(null);
            }
            else {
                contactPerson.setValue(r.getAttribute("lacContactPerson"));
            }
            if(r.getAttribute("lacContactTitle")==null) {
                contactTitle.setValue(null);
            }
            else {
                contactTitle.setValue(r.getAttribute("lacContactTitle"));
            }
            contactName.setValue(r.getAttribute("lac_contact_name"));
            contactSex.setValue(r.getAttribute("lac_sex"));
            contactTelephone.setValue(r.getAttribute("lac_telephone"));
            contactAddress.setValue(r.getAttribute("lac_address"));
            contactEmail.setValue(r.getAttribute("lac_contact_email"));
            
        }
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:ContactsPopup" +
        "').show(hints);");
        return null;
    }

    public String DeleteContactPerson() {
        DCIteratorBinding dciter = ADFUtils.findIterator("findContactPersonsIterator");
        RowKeySet set =contactsLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        
        //System.out.println(1);
        while (rowKeySetIter.hasNext()) 
        {
            List l = (List) rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
            session.setAttribute("LAC_CODE",r.getAttribute("lacCode"));
        }
        String authQuery="BEGIN LMS_SETUPS_PKG.deleteagency_contacts(?);END;";
        Connection conn=new DBConnector().getDatabaseConn();
        try
        {
        CallableStatement cstmt=conn.prepareCall(authQuery);    
        cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("LAC_CODE"));
        cstmt.execute();
        conn.close();
            String Message = "Contact Person deleted successfully.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            
            session.setAttribute("LAC_CODE",null);
            ADFUtils.findIterator("findContactPersonsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(contactsLOV); 
        }
        catch(Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
        }
        return null;
    }

    public void setRealtionId(RichInputText realtionId) {
        this.realtionId = realtionId;
    }

    public RichInputText getRealtionId() {
        return realtionId;
    }

    public void setRelationDescription(RichInputText relationDescription) {
        this.relationDescription = relationDescription;
    }

    public RichInputText getRelationDescription() {
        return relationDescription;
    }

    public void setRelationDOBRequired(RichSelectOneChoice relationDOBRequired) {
        this.relationDOBRequired = relationDOBRequired;
    }

    public RichSelectOneChoice getRelationDOBRequired() {
        return relationDOBRequired;
    }

    public void setRelationComments(RichInputText relationComments) {
        this.relationComments = relationComments;
    }

    public RichInputText getRelationComments() {
        return relationComments;
    }

    public String SaveRelationType() {
        if(realtionId.getValue()==null) {
            String Message = "Enter Relation ID.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
           return null;
        }
        if(relationDescription.getValue()==null) {
            String Message = "Enter Relation Description.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
           return null;
        }
        String saveQuery="BEGIN LMS_SETUPS_PKG.update_relationtypes(?,?,?,?,?);END;";
        Connection conn=null;
        try
        {
            conn=new DBConnector().getDatabaseConn();
        CallableStatement cstmt=conn.prepareCall(saveQuery);    
        cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("RET_CODE"));
        cstmt.setString(2, realtionId.getValue().toString());
        cstmt.setString(3,relationDescription.getValue().toString());  
        if(relationComments.getValue()==null) {
            cstmt.setString(4,null);
        }
        else {
            cstmt.setString(4,relationComments.getValue().toString());  
        }
        if(relationDOBRequired.getValue()==null) {
                cstmt.setString(5,null);
        }
        else {
                cstmt.setString(5,relationDOBRequired.getValue().toString());  
            }
         
        cstmt.execute();
        conn.close();
        
        String Message = "Relation saved successfully.";
        FacesContext.getCurrentInstance().addMessage(null, 
                                                     new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                      Message, 
                                                                      Message));
        
            session.setAttribute("RET_CODE",null);
            ADFUtils.findIterator("findRelationTypesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(relationTypesLOV); 
        }
        catch(Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
        }
       
        return null;
    }

    public void setRelationTypesLOV(RichTable relationTypesLOV) {
        this.relationTypesLOV = relationTypesLOV;
    }

    public RichTable getRelationTypesLOV() {
        return relationTypesLOV;
    }

    public String AddNewRelationType() {
        session.setAttribute("RET_CODE",null);
        realtionId.setValue(null);
        relationDescription.setValue(null);
        relationComments.setValue(null);
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:RelationTypesPopup" +
        "').show(hints);");
        return null;
    }

    public String EditRelationType() {
        DCIteratorBinding dciter = ADFUtils.findIterator("findRelationTypesIterator");
        RowKeySet set =relationTypesLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        
        //System.out.println(1);
        while (rowKeySetIter.hasNext()) 
        {
            List l = (List) rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
          
        
            
            session.setAttribute("RET_CODE",r.getAttribute("retCode"));
            if(r.getAttribute("retShtDesc")==null) {
                realtionId.setValue(null);
            }
            else {
                realtionId.setValue(r.getAttribute("retShtDesc"));
            }
            if(r.getAttribute("retDesc")==null) {
               relationDescription.setValue(null);
            }
            else {
                relationDescription.setValue(r.getAttribute("retDesc"));
            }
            if(r.getAttribute("retComments")==null) {
               relationComments.setValue(null);
            }
            else {
                relationComments.setValue(r.getAttribute("retComments"));
            }
            if(r.getAttribute("dobRequired")==null) {
              relationDOBRequired.setValue(null);
            }
            else {
                relationDOBRequired.setValue(r.getAttribute("dobRequired"));
            }
           
            
        }
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:RelationTypesPopup" +
        "').show(hints);");
        return null;
    }

    public String DeleteRelationType() {
        DCIteratorBinding dciter = ADFUtils.findIterator("findRelationTypesIterator");
        RowKeySet set =relationTypesLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        
        //System.out.println(1);
        while (rowKeySetIter.hasNext()) 
        {
            List l = (List) rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
          
        
            
            session.setAttribute("RET_CODE",r.getAttribute("retCode"));
           
        }
        String authQuery="BEGIN LMS_SETUPS_PKG.delete_relationtypes(?);END;";
        Connection conn=new DBConnector().getDatabaseConn();
        try
        {
        CallableStatement cstmt=conn.prepareCall(authQuery);    
        cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("RET_CODE"));
        cstmt.execute();
        conn.close();
            String Message = "Relation deleted successfully.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            
            session.setAttribute("RET_CODE",null);
            ADFUtils.findIterator("findRelationTypesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(relationTypesLOV); 
        }
        catch(Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
        }   
            
       
        return null;
    }

    public void setDependentTypesLOV(RichTable dependentTypesLOV) {
        this.dependentTypesLOV = dependentTypesLOV;
    }

    public RichTable getDependentTypesLOV() {
        return dependentTypesLOV;
    }

    public String AddNewDependent() {
        session.setAttribute("DTY_CODE",null);
        dtyShtDesc.setValue(null);
        dtyDescription.setValue(null);
       
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:DependentTypesPopup" +
        "').show(hints);");
        return null;
    }

    public String EditNewDependentType() {
        DCIteratorBinding dciter = ADFUtils.findIterator("findDependentTypesIterator");
        RowKeySet set =dependentTypesLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        
        //System.out.println(1);
        while (rowKeySetIter.hasNext()) 
        {
            List l = (List) rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
          
        
            
            session.setAttribute("DTY_CODE",r.getAttribute("dtyCode"));
            if(r.getAttribute("dtyShtDesc")==null) {
               dtyShtDesc.setValue(null);
            }
            else {
                dtyShtDesc.setValue(r.getAttribute("dtyShtDesc"));
            }
            if(r.getAttribute("dtyDesc")==null) {
               dtyDescription.setValue(null);
            }
            else {
                dtyDescription.setValue(r.getAttribute("dtyDesc"));
            }
           
        }
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:DependentTypesPopup" +
        "').show(hints);");
        return null;
       // return null;
    }

    public String DeleteNewDependentType() {
        DCIteratorBinding dciter = ADFUtils.findIterator("findDependentTypesIterator");
        RowKeySet set =dependentTypesLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        
        //System.out.println(1);
        while (rowKeySetIter.hasNext()) 
        {
            List l = (List) rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
          
        
            
            session.setAttribute("DTY_CODE",r.getAttribute("dtyCode"));
      
        }
        String authQuery="BEGIN LMS_SETUPS_PKG.delete_dependenttypes(?);END;";
        Connection conn=new DBConnector().getDatabaseConn();
        try
        {
        CallableStatement cstmt=conn.prepareCall(authQuery);    
        cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("DTY_CODE"));
        cstmt.execute();
        conn.close();
            String Message = "Dependent Type deleted successfully.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            
           
            session.setAttribute("DTY_CODE",null);
            ADFUtils.findIterator("findDependentTypesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(dependentTypesLOV); 
        }
        catch(Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
        }  
        return null;
    }

    public void setDtyShtDesc(RichInputText dtyShtDesc) {
        this.dtyShtDesc = dtyShtDesc;
    }

    public RichInputText getDtyShtDesc() {
        return dtyShtDesc;
    }

    public void setDtyDescription(RichInputText dtyDescription) {
        this.dtyDescription = dtyDescription;
    }

    public RichInputText getDtyDescription() {
        return dtyDescription;
    }

    public String SaveNewDependentType() {
        if(dtyShtDesc.getValue()==null) {
            String Message = "Enter Dependent Type ID.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
           return null;
        }
        if(dtyDescription.getValue()==null) {
            String Message = "Enter Dependent Type Description.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
           return null;
        }
        String saveQuery="BEGIN LMS_SETUPS_PKG.update_dependenttypes(?,?,?);END;";
        Connection conn=null;
        try
        {
            conn=new DBConnector().getDatabaseConn();
        CallableStatement cstmt=conn.prepareCall(saveQuery);    
        cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("DTY_CODE"));
        cstmt.setString(2, dtyShtDesc.getValue().toString());
        cstmt.setString(3,dtyDescription.getValue().toString());  
       
        cstmt.execute();
        conn.close();
        
        String Message = "Dependent Type saved successfully.";
        FacesContext.getCurrentInstance().addMessage(null, 
                                                     new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                      Message, 
                                                                      Message));
        
            session.setAttribute("DTY_CODE",null);
            ADFUtils.findIterator("findDependentTypesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(dependentTypesLOV); 
        }
        catch(Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
        }
        return null;
    }

    public void setReinstatementRatesLOV(RichTable reinstatementRatesLOV) {
        this.reinstatementRatesLOV = reinstatementRatesLOV;
    }

    public RichTable getReinstatementRatesLOV() {
        return reinstatementRatesLOV;
    }

    public void productSelected(SelectionEvent selectionEvent) {
        if (selectionEvent.getAddedSet() != selectionEvent.getRemovedSet()) {
            RowKeySet rowKeySet = productsTree.getSelectedRowKeys();
            Object key2 = rowKeySet.iterator().next();
            productsTree.setRowKey(key2);
            JUCtrlValueBinding nodeBinding =
                (JUCtrlValueBinding)productsTree.getRowData();
                session.setAttribute("ProductCode",
                                     nodeBinding.getAttribute("PROD_CODE"));
            session.setAttribute("ProdShtDesc",
                                 nodeBinding.getAttribute("PROD_SHT_DESC"));
            ADFUtils.findIterator("findReinstatementRatesIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(reinstatementRatesLOV);

            ADFUtils.findIterator("findLoanInterestRatesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(loanInterestRatesLOV);

            ADFUtils.findIterator("findGeneralInterestRatesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(generalInterestLOV);
            
          ADFUtils.findIterator("findPensionTablesIterator").executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(ratesTables);
          
          ADFUtils.findIterator("findGeneralInterestRatesForTableIterator").executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(tableRates);

        }
    }
    
    public void productSelected1(SelectionEvent selectionEvent) {
        
        if (selectionEvent.getAddedSet() != selectionEvent.getRemovedSet()) {
               RowKeySet keys = selectionEvent.getAddedSet();
               if (keys != null && keys.getSize() > 0) {
                   for (Object treeRowKey : keys) {
                       productsTree.setRowKey(treeRowKey);
                       JUCtrlHierNodeBinding nd =
                           (JUCtrlHierNodeBinding)productsTree.getRowData();
         
                   session.setAttribute("ProductCode",
                                        nd.getRow().getAttribute("PROD_CODE"));
                   session.setAttribute("ProdShtDesc",
                                    nd.getRow().getAttribute("PROD_SHT_DESC"));
                       
                   session.setAttribute("ANNFD_CODE", null);
                    session.setAttribute("ANNF_ANNFD_CODE", null);

                    ADFUtils.findIterator("findAnnuityFactorsDescriptionIterator").executeQuery();
                   AdfFacesContext.getCurrentInstance().addPartialTarget(annuityFactrDescriptionLOV);

                    ADFUtils.findIterator("findAnnuityFactorsIterator").executeQuery();
                   AdfFacesContext.getCurrentInstance().addPartialTarget(annuityFactorsLOV);
               }
        }
        }
    }
    
  public void productSelected2(SelectionEvent selectionEvent) {
      
      if (selectionEvent.getAddedSet() != selectionEvent.getRemovedSet()) {
             RowKeySet keys = selectionEvent.getAddedSet();
             if (keys != null && keys.getSize() > 0) {
                 for (Object treeRowKey : keys) {
                     productsTree.setRowKey(treeRowKey);
                     JUCtrlHierNodeBinding nd =
                         (JUCtrlHierNodeBinding)productsTree.getRowData();
       
                 session.setAttribute("ProductCode",
                                      nd.getRow().getAttribute("PROD_CODE"));
                     
               ADFUtils.findIterator("findAnnuityTypesIterator").executeQuery();
               AdfFacesContext.getCurrentInstance().addPartialTarget(annuityTypesLOV); 
               
               session.setAttribute("ATY_CODE", null);

               ADFUtils.findIterator("findAnnuityTypesRatesIterator").executeQuery();
               AdfFacesContext.getCurrentInstance().addPartialTarget(annuityTypeRates);
             }
      }
      }
  }
  
  public String RefreshAnnuities(){
    
    ADFUtils.findIterator("findAnnuityTypesIterator").executeQuery();
    AdfFacesContext.getCurrentInstance().addPartialTarget(annuityTypesLOV); 
    

    ADFUtils.findIterator("findAnnuityTypesRatesIterator").executeQuery();
    AdfFacesContext.getCurrentInstance().addPartialTarget(annuityTypeRates);
    
    return null;
    
  }

    public void setProductsTree(RichTree productsTree) {
        this.productsTree = productsTree;
    }

    public RichTree getProductsTree() {
        return productsTree;
    }

    public String AddReinstatementRate() {
        session.setAttribute("RIR_CODE",null);
        reinWefDate.setValue(null);
        reinWetDate.setValue(null);
        reinRates.setValue(null);
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:reinstatementRatesPopup" +
        "').show(hints);");
        return null;
    }

    public String EditReinstatementRates() {
        RowKeySet rowKeySet = reinstatementRatesLOV.getSelectedRowKeys();
                if (!rowKeySet.iterator().hasNext()) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    return null;
                }

                Object key2 = rowKeySet.iterator().next();
               reinstatementRatesLOV.setRowKey(key2);

                JUCtrlValueBinding r = (JUCtrlValueBinding)reinstatementRatesLOV.getRowData();

                if (r == null) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    return null;
                } 
                session.setAttribute("RIR_CODE",r.getAttribute("rirCode"));
                reinWefDate.setValue(r.getAttribute("rirWef"));
                reinWetDate.setValue(r.getAttribute("rirWet"));
                reinRates.setValue(r.getAttribute("rirRate"));
                ExtendedRenderKitService erkService =
                Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                ExtendedRenderKitService.class);
                erkService.addScript(FacesContext.getCurrentInstance(),
                "var hints = {autodismissNever:false}; " +
                "AdfPage.PAGE.findComponent('" + "lmsgroup:reinstatementRatesPopup" +
                "').show(hints);");
        return null;
    }

    public String DeleteReinstatementRates() {
        String Result = "F";
        RowKeySet rowKeySet = reinstatementRatesLOV.getSelectedRowKeys();
                if (!rowKeySet.iterator().hasNext()) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    return null;
                }

                Object key2 = rowKeySet.iterator().next();
               reinstatementRatesLOV.setRowKey(key2);

                JUCtrlValueBinding r = (JUCtrlValueBinding)reinstatementRatesLOV.getRowData();

                if (r == null) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    return null;
                } 
                session.setAttribute("RIR_CODE",r.getAttribute("rirCode"));
                String authQuery="BEGIN LMS_SETUPS_PKG.delete_reinstintrstrates(?);END;";
                Connection conn=new DBConnector().getDatabaseConn();
                try
                {
                CallableStatement cstmt=conn.prepareCall(authQuery);    
                cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("RIR_CODE"));
                cstmt.execute();
                conn.close();
             
                    session.setAttribute("RIR_CODE",null);
            ADFUtils.findIterator("findReinstatementRatesIterator").executeQuery();
                    AdfFacesContext.getCurrentInstance().addPartialTarget(reinstatementRatesLOV);
                  Result = "S";
                }
                catch(Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
                }  
        return Result;
    }

    public void setReinWefDate(RichInputDate reinWefDate) {
        this.reinWefDate = reinWefDate;
    }

    public RichInputDate getReinWefDate() {
        return reinWefDate;
    }

    public void setReinWetDate(RichInputDate reinWetDate) {
        this.reinWetDate = reinWetDate;
    }

    public RichInputDate getReinWetDate() {
        return reinWetDate;
    }

    public void setReinRates(RichInputText reinRates) {
        this.reinRates = reinRates;
    }

    public RichInputText getReinRates() {
        return reinRates;
    }

    public String SaveReinstatementRates() {
        if(reinWefDate.getValue()==null) {
            String Message = "Enter WEF Date.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
           return null;
        }
        if(reinRates.getValue()==null) {
            String Message = "Enter Reinstatement Rate.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
           return null;
        }
        String saveQuery="BEGIN LMS_SETUPS_PKG.update_reinstintrstrates(?,?,?,?,?,?);END;";
        Connection conn=null;
        try
        {
            conn=new DBConnector().getDatabaseConn();
        CallableStatement cstmt=conn.prepareCall(saveQuery);    
        cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("RIR_CODE"));
        cstmt.setBigDecimal(2, (BigDecimal)session.getAttribute("ProductCode"));
        cstmt.setString(3, (String)session.getAttribute("ProdShtDesc"));
        cstmt.setString(4, reinRates.getValue().toString());
        //cstmt.setString(5,GlobalCC.parseDate(reinWefDate.getValue().toString()));  
        if (reinWefDate.getValue() == null) {
            cstmt.setString(5, null);
        } else {
            String todayString = null;
            if (reinWefDate.getValue().toString().contains(":")) {
                todayString = GlobalCC.parseDate(reinWefDate.getValue().toString());
            } else {
                todayString = GlobalCC.upDateParseDate(reinWefDate.getValue().toString());
            }
            cstmt.setString(5, todayString);
        }
        if (reinWetDate.getValue() == null) {
              cstmt.setString(6, null);
        } else {
              String todayString = null;
              if (reinWetDate.getValue().toString().contains(":")) {
                  todayString = GlobalCC.parseDate(reinWetDate.getValue().toString());
              } else {
                  todayString = GlobalCC.upDateParseDate(reinWetDate.getValue().toString());
              }
              cstmt.setString(6, todayString);
        }
        
        cstmt.execute();
        conn.close();
        
        String Message = "Reinstatement Rate saved successfully.";
        FacesContext.getCurrentInstance().addMessage(null, 
                                                     new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                      Message, 
                                                                      Message));
        
            session.setAttribute("RIR_CODE",null);
            ADFUtils.findIterator("findReinstatementRatesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(reinstatementRatesLOV);
        }
        catch(Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
        }
        return null;
    }

    public String AddLoanInterestRates() {
        session.setAttribute("LIR_CODE",null);
        loanRate.setValue(null);
        serviceChargeRate.setValue(null);
        loanWefDate.setValue(null);
        loanWET.setValue(null);
        serviceChargeDivFact.setValue(null);
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:LoanInterestRatesPopup" +
        "').show(hints);");
        return null;
    }

    public String EditLoanInterestRates() {
        RowKeySet rowKeySet = loanInterestRatesLOV.getSelectedRowKeys();
                if (!rowKeySet.iterator().hasNext()) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    return null;
                }

                Object key2 = rowKeySet.iterator().next();
               loanInterestRatesLOV.setRowKey(key2);

                JUCtrlValueBinding r = (JUCtrlValueBinding)loanInterestRatesLOV.getRowData();

                if (r == null) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    return null;
                } 
                session.setAttribute("LIR_CODE",r.getAttribute("lirCode"));
                loanRate.setValue(r.getAttribute("lirRate"));
                loanWefDate.setValue(r.getAttribute("lirWef"));
                loanWET.setValue(r.getAttribute("lirWet"));
                serviceChargeDivFact.setValue(r.getAttribute("serviceChargeDivFact"));
                serviceChargeRate.setValue(r.getAttribute("serviceCharge"));
                ExtendedRenderKitService erkService =
                Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                ExtendedRenderKitService.class);
                erkService.addScript(FacesContext.getCurrentInstance(),
                "var hints = {autodismissNever:false}; " +
                "AdfPage.PAGE.findComponent('" + "lmsgroup:LoanInterestRatesPopup" +
                "').show(hints);");
        return null;
    }

    public String DeleteLoanInterestRates() {
        String Result = "F";
        RowKeySet rowKeySet = loanInterestRatesLOV.getSelectedRowKeys();
                if (!rowKeySet.iterator().hasNext()) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    return null;
                }

                Object key2 = rowKeySet.iterator().next();
               loanInterestRatesLOV.setRowKey(key2);

                JUCtrlValueBinding r = (JUCtrlValueBinding)loanInterestRatesLOV.getRowData();

                if (r == null) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    return null;
                } 
                session.setAttribute("LIR_CODE",r.getAttribute("lirCode"));
        String authQuery="BEGIN LMS_SETUPS_PKG.delete_loanintrstrates(?);END;";
        Connection conn=new DBConnector().getDatabaseConn();
        try
        {
        CallableStatement cstmt=conn.prepareCall(authQuery);    
        cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("LIR_CODE"));
        cstmt.execute();
        conn.close();
            String Message = "Loan Interest Rate deleted successfully.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            
           
            session.setAttribute("LIR_CODE",null);
            ADFUtils.findIterator("findLoanInterestRatesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(loanInterestRatesLOV);
            Result = "S";
        }
        catch(Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
        } 
        return Result;
    }

    public void setLoanRate(RichInputText loanRate) {
        this.loanRate = loanRate;
    }

    public RichInputText getLoanRate() {
        return loanRate;
    }

    public void setServiceChargeRate(RichInputText serviceChargeRate) {
        this.serviceChargeRate = serviceChargeRate;
    }

    public RichInputText getServiceChargeRate() {
        return serviceChargeRate;
    }

    public void setLoanWefDate(RichInputDate loanWefDate) {
        this.loanWefDate = loanWefDate;
    }

    public RichInputDate getLoanWefDate() {
        return loanWefDate;
    }

    public void setLoanWET(RichInputDate loanWET) {
        this.loanWET = loanWET;
    }

    public RichInputDate getLoanWET() {
        return loanWET;
    }

    public String SaveLoanInterestRates() {
        if(loanWefDate.getValue()==null) {
            String Message = "Enter WEF Date.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
           return null;
        }
        if(loanRate.getValue()==null) {
            String Message = "Enter Reinstatement Rate.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
           return null;
        }
        String saveQuery="BEGIN LMS_SETUPS_PKG.update_loanintrstrates(?,?,?,?,?,?,?,?);END;";
        Connection conn=null;
        try
        {
            conn=new DBConnector().getDatabaseConn();
        CallableStatement cstmt=conn.prepareCall(saveQuery);    
        cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("LIR_CODE"));
        cstmt.setBigDecimal(2, (BigDecimal)session.getAttribute("ProductCode"));
        cstmt.setString(3, (String)session.getAttribute("ProdShtDesc"));
        if(loanRate.getValue()==null) {
            cstmt.setString(4,null);
        }
        else {
            cstmt.setString(4, loanRate.getValue().toString());  
        }
        if (loanWefDate.getValue() == null) {
            cstmt.setString(5, null);
        } else {
            String todayString = null;
            if (loanWefDate.getValue().toString().contains(":")) {
                todayString = GlobalCC.parseDate(loanWefDate.getValue().toString());
            } else {
                todayString = GlobalCC.upDateParseDate(loanWefDate.getValue().toString());
            }
            cstmt.setString(5, todayString);
        }
        if (loanWET.getValue() == null) {
            cstmt.setString(6, null);
        } else {
            String todayString = null;
            if (loanWET.getValue().toString().contains(":")) {
                todayString = GlobalCC.parseDate(loanWET.getValue().toString());
            } else {
                todayString = GlobalCC.upDateParseDate(loanWET.getValue().toString());
            }
            cstmt.setString(6, todayString);
        }
        if(serviceChargeRate.getValue()==null) {
            cstmt.setString(7,null);
        }
        else {
            cstmt.setString(7,serviceChargeRate.getValue().toString());     
        }
        if(serviceChargeDivFact.getValue()==null) {
            cstmt.setString(8,null);
        }
        else {
            cstmt.setString(8,serviceChargeDivFact.getValue().toString());     
        }
        cstmt.execute();
        conn.close();
        
        String Message = "Loan Interest Rate saved successfully.";
        FacesContext.getCurrentInstance().addMessage(null, 
                                                     new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                      Message, 
                                                                      Message));
        
            session.setAttribute("LIR_CODE",null);
            ADFUtils.findIterator("findLoanInterestRatesIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(loanInterestRatesLOV);
        
    }
    catch(Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
    } 
    return null;
    }
    public void setServiceChargeDivFact(RichSelectOneChoice serviceChargeDivFact) {
        this.serviceChargeDivFact = serviceChargeDivFact;
    }

    public RichSelectOneChoice getServiceChargeDivFact() {
        return serviceChargeDivFact;
    }

    public void setLoanInterestRatesLOV(RichTable loanInterestRatesLOV) {
        this.loanInterestRatesLOV = loanInterestRatesLOV;
    }

    public RichTable getLoanInterestRatesLOV() {
        return loanInterestRatesLOV;
    }

    public void setGeneralInterestLOV(RichTable generalInterestLOV) {
        this.generalInterestLOV = generalInterestLOV;
    }

    public RichTable getGeneralInterestLOV() {
        return generalInterestLOV;
    }

    public String AddGeneralInterestRates() {
        session.setAttribute("LGR_CODE",null);
        generalInterest.setValue(null);
        genrlDivFactor.setValue(null);
       generalWEF.setValue(null);
       genrlWetDate.setValue(null);
       
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:GeneralInterestRatesPopup" +
        "').show(hints);");
        return null;
    }

    public String EditGeneralInterestRate() {
        RowKeySet rowKeySet = generalInterestLOV.getSelectedRowKeys();
                if (!rowKeySet.iterator().hasNext()) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    return null;
                }

                Object key2 = rowKeySet.iterator().next();
               generalInterestLOV.setRowKey(key2);

                JUCtrlValueBinding r = (JUCtrlValueBinding)generalInterestLOV.getRowData();

                if (r == null) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    return null;
                } 
                session.setAttribute("LGR_CODE",r.getAttribute("lgrCode"));
                generalType.setValue(r.getAttribute("lgrType"));
                generalAppType.setValue(r.getAttribute("lgrApplicationType"));
                generalInterest.setValue(r.getAttribute("lgrRate"));
                genrlDivFactor.setValue(r.getAttribute("lgrDivFactor"));
                generalWEF.setValue(r.getAttribute("lgrWef"));
                genrlWetDate.setValue(r.getAttribute("lgrWet"));
                freqOfPayment.setValue(r.getAttribute("lgrDependsonFreq"));
                ExtendedRenderKitService erkService =
                Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                ExtendedRenderKitService.class);
                erkService.addScript(FacesContext.getCurrentInstance(),
                "var hints = {autodismissNever:false}; " +
                "AdfPage.PAGE.findComponent('" + "lmsgroup:GeneralInterestRatesPopup" +
                "').show(hints);");
        return null;
    }
    
  public String AddGeneralInterestRatesTbles() {
      session.setAttribute("LGR_CODE",null);
      if(session.getAttribute("lpnt_code")==null){
          GlobalCC.sysInformation("Select A Rate Table.");
          return null;
      }
      generalInterest.setValue(null);
      genrlDivFactor.setValue(null);
     generalWEF.setValue(null);
     genrlWetDate.setValue(null);
     
      ExtendedRenderKitService erkService =
      Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
      ExtendedRenderKitService.class);
      erkService.addScript(FacesContext.getCurrentInstance(),
      "var hints = {autodismissNever:false}; " +
      "AdfPage.PAGE.findComponent('" + "lmsgroup:GeneralInterestRatesPopup" +
      "').show(hints);");
      return null;
  }
    
  public String EditGeneralInterestRateTbles() {
      RowKeySet rowKeySet = tableRates.getSelectedRowKeys();
              if (!rowKeySet.iterator().hasNext()) {
                  GlobalCC.errorValueNotEntered("Error: No Record Selected");
                  return null;
              }

              Object key2 = rowKeySet.iterator().next();
             tableRates.setRowKey(key2);

              JUCtrlValueBinding r = (JUCtrlValueBinding)tableRates.getRowData();

              if (r == null) {
                  GlobalCC.errorValueNotEntered("Error: No Record Selected");
                  return null;
              } 
              session.setAttribute("LGR_CODE",r.getAttribute("lgrCode"));
              generalType.setValue(r.getAttribute("lgrType"));
              generalAppType.setValue(r.getAttribute("lgrApplicationType"));
              generalInterest.setValue(r.getAttribute("lgrRate"));
              genrlDivFactor.setValue(r.getAttribute("lgrDivFactor"));
              generalWEF.setValue(r.getAttribute("lgrWef"));
              genrlWetDate.setValue(r.getAttribute("lgrWet"));
              freqOfPayment.setValue(r.getAttribute("lgrDependsonFreq"));
              pensPoliciesDesc.setValue(r.getAttribute("POL_POLICY_NO"));
              session.setAttribute("policyCode", r.getAttribute("LPNT_POL_CODE"));
              
              ExtendedRenderKitService erkService =
              Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
              ExtendedRenderKitService.class);
              erkService.addScript(FacesContext.getCurrentInstance(),
              "var hints = {autodismissNever:false}; " +
              "AdfPage.PAGE.findComponent('" + "lmsgroup:GeneralInterestRatesPopup" +
              "').show(hints);");
      return null;
  }
    
  public String DeleteGeneralInterestRateTbl() {
      RowKeySet rowKeySet = tableRates.getSelectedRowKeys();
      if (!rowKeySet.iterator().hasNext()) {
          GlobalCC.errorValueNotEntered("Error: No Record Selected");
          return null;
      }

      Object key2 = rowKeySet.iterator().next();
     tableRates.setRowKey(key2);

      JUCtrlValueBinding r = (JUCtrlValueBinding)tableRates.getRowData();

      if (r == null) {
          GlobalCC.errorValueNotEntered("Error: No Record Selected");
          return null;
      }
      session.setAttribute("LGR_CODE",r.getAttribute("lgrCode"));
      String authQuery="BEGIN LMS_SETUPS_PKG.delete_genrlintrstrates(?);END;";
      Connection conn=new DBConnector().getDatabaseConn();
      try
      {
      CallableStatement cstmt=conn.prepareCall(authQuery);    
      cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("LGR_CODE"));
      cstmt.execute();
      conn.close();
          String Message = "General Interest Rate deleted successfully.";
          FacesContext.getCurrentInstance().addMessage(null, 
                                                       new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                        Message, 
                                                                        Message));
          
         
          session.setAttribute("LGR_CODE",null);
          ADFUtils.findIterator("findGeneralInterestRatesForTableIterator").executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(tableRates);
      }
      catch(Exception ex) {
          GlobalCC.EXCEPTIONREPORTING(conn,ex);
      } 
      return null;
  }

    public String DeleteGeneralInterestRate() {
        String Result = "F";
        RowKeySet rowKeySet = generalInterestLOV.getSelectedRowKeys();
        if (!rowKeySet.iterator().hasNext()) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
            return null;
        }

        Object key2 = rowKeySet.iterator().next();
       generalInterestLOV.setRowKey(key2);

        JUCtrlValueBinding r = (JUCtrlValueBinding)generalInterestLOV.getRowData();

        if (r == null) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
            return null;
        }
        session.setAttribute("LGR_CODE",r.getAttribute("lgrCode"));
        String authQuery="BEGIN LMS_SETUPS_PKG.delete_genrlintrstrates(?);END;";
        Connection conn=new DBConnector().getDatabaseConn();
        try
        {
        CallableStatement cstmt=conn.prepareCall(authQuery);    
        cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("LGR_CODE"));
        cstmt.execute();
        conn.close();
           
           
            session.setAttribute("LGR_CODE",null);
            ADFUtils.findIterator("findGeneralInterestRatesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(generalInterestLOV);
          Result = "S";
        }
        catch(Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
        } 
        return Result;
    }

    public void setGeneralType(RichSelectOneChoice generalType) {
        this.generalType = generalType;
    }

    public RichSelectOneChoice getGeneralType() {
        return generalType;
    }

    public void setGeneralAppType(RichSelectOneChoice generalAppType) {
        this.generalAppType = generalAppType;
    }

    public RichSelectOneChoice getGeneralAppType() {
        return generalAppType;
    }

    public void setGeneralInterest(RichInputText generalInterest) {
        this.generalInterest = generalInterest;
    }

    public RichInputText getGeneralInterest() {
        return generalInterest;
    }

    public void setGeneralDivFactor(RichOutputLabel generalDivFactor) {
        this.generalDivFactor = generalDivFactor;
    }

    public RichOutputLabel getGeneralDivFactor() {
        return generalDivFactor;
    }

    public void setGenrlDivFactor(RichInputText genrlDivFactor) {
        this.genrlDivFactor = genrlDivFactor;
    }

    public RichInputText getGenrlDivFactor() {
        return genrlDivFactor;
    }

    public void setFreqOfPayment(RichSelectOneChoice freqOfPayment) {
        this.freqOfPayment = freqOfPayment;
    }

    public RichSelectOneChoice getFreqOfPayment() {
        return freqOfPayment;
    }

    public void setGeneralWEF(RichInputDate generalWEF) {
        this.generalWEF = generalWEF;
    }

    public RichInputDate getGeneralWEF() {
        return generalWEF;
    }

    public void setGenrlWetDate(RichInputDate genrlWetDate) {
        this.genrlWetDate = genrlWetDate;
    }

    public RichInputDate getGenrlWetDate() {
        return genrlWetDate;
    }

  public String AddRateTable(){
      tableDescription.setValue(null);
      session.setAttribute("lpnt_code", null);
      pensPoliciesDesc.setValue(null);
      session.setAttribute("policyCode", null);
      session.setAttribute("action", "A");
      
      ExtendedRenderKitService erkService =
      Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
      ExtendedRenderKitService.class);
      erkService.addScript(FacesContext.getCurrentInstance(),
      "var hints = {autodismissNever:false}; " +
      "AdfPage.PAGE.findComponent('" + "lmsgroup:TableRtes" +
      "').show(hints);");
      
      return null;
  }
  
  public String EditRateTable() {
      try{
      RowKeySet rowKeySet = ratesTables.getSelectedRowKeys();
              if (!rowKeySet.iterator().hasNext()) {
                  GlobalCC.errorValueNotEntered("Error: No Record Selected");
                  return null;
              }

              Object key2 = rowKeySet.iterator().next();
             ratesTables.setRowKey(key2);

              JUCtrlValueBinding r = (JUCtrlValueBinding)ratesTables.getRowData();

              if (r == null) {
                  GlobalCC.errorValueNotEntered("Error: No Record Selected");
                  return null;
              } 
              session.setAttribute("lpnt_code", r.getAttribute("LPNT_CODE"));
              tableDescription.setValue(r.getAttribute("LPNT_DESC"));
              pensPoliciesDesc.setValue(r.getAttribute("POL_POLICY_NO"));
              session.setAttribute("policyCode", r.getAttribute("LPNT_POL_CODE"));
              tablesDefault.setValue(r.getAttribute("LPNT_DEFAULT"));
              session.setAttribute("action", "E");
             
              
              ExtendedRenderKitService erkService =
              Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
              ExtendedRenderKitService.class);
              erkService.addScript(FacesContext.getCurrentInstance(),
              "var hints = {autodismissNever:false}; " +
              "AdfPage.PAGE.findComponent('" + "lmsgroup:TableRtes" +
              "').show(hints);");
      }catch(Exception e){
          GlobalCC.EXCEPTIONREPORTING(null, e);
      }
      return null;
  }
  
  public String DeleteRateTable() {
      try{
      RowKeySet rowKeySet = ratesTables.getSelectedRowKeys();
      if (!rowKeySet.iterator().hasNext()) {
          GlobalCC.errorValueNotEntered("Error: No Record Selected");
          return null;
      }

      Object key2 = rowKeySet.iterator().next();
     ratesTables.setRowKey(key2);

      JUCtrlValueBinding r = (JUCtrlValueBinding)ratesTables.getRowData();

      if (r == null) {
          GlobalCC.errorValueNotEntered("Error: No Record Selected");
          return null;
      }
      session.setAttribute("lpnt_code", r.getAttribute("LPNT_CODE"));
      session.setAttribute("action", "D");
      SaveTableRate();
      
      
  }catch(Exception ex) {
          GlobalCC.EXCEPTIONREPORTING(null,ex);
      } 
      return null;
  }
  
  public void PensionTablesListener(SelectionEvent selectionEvent) {
      // Add event code here...
      RowKeySet rowKeySet =  ratesTables.getSelectedRowKeys();
              if (!rowKeySet.iterator().hasNext()) {
                  GlobalCC.errorValueNotEntered("Error: No Record Selected");
                  //return null;
              }

              Object key2 = rowKeySet.iterator().next();
              ratesTables.setRowKey(key2);

              JUCtrlValueBinding r = (JUCtrlValueBinding) ratesTables.getRowData();

              if (r == null) {
                  GlobalCC.errorValueNotEntered("Error: No Record Selected");
                  //return null;
              } 
      session.setAttribute("lpnt_code",r.getAttribute("LPNT_CODE"));
      ADFUtils.findIterator("findGeneralInterestRatesForTableIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(tableRates);
  }
  
  public String SaveTableRate(){
      Connection conn=null;
      try{
          String authQuery="BEGIN LMS_SETUPS_PKG.save_pens_rate_tables(?,?,?,?,?,?);END;";
          conn=new DBConnector().getDatabaseConn();

          CallableStatement cstmt=conn.prepareCall(authQuery);    
          cstmt.setString(1, (String)session.getAttribute("action"));
          cstmt.setBigDecimal(2, (BigDecimal)session.getAttribute("lpnt_code"));
          if(tableDescription.getValue()==null){
              cstmt.setString(3, null);     
          }else{
              cstmt.setString(3, tableDescription.getValue().toString());      
          }
          cstmt.setBigDecimal(4, (BigDecimal)session.getAttribute("ProductCode"));
          cstmt.setBigDecimal(5, (BigDecimal)session.getAttribute("policyCode"));
          if(tablesDefault.getValue()==null){
              cstmt.setString(6, null);     
          }else{
              cstmt.setString(6, tablesDefault.getValue().toString());      
          }
        
          cstmt.execute();
          conn.close();
              String Message = "Interest Rate Table Saved successfully.";
              FacesContext.getCurrentInstance().addMessage(null, 
                                                           new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                            Message, 
                                                                            Message));
              
             
              session.setAttribute("lpnt_code",null);
              ADFUtils.findIterator("findPensionTablesIterator").executeQuery();
              AdfFacesContext.getCurrentInstance().addPartialTarget(ratesTables);
          
          ADFUtils.findIterator("findGeneralInterestRatesForTableIterator").executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(tableRates);
      }catch(Exception e){
          GlobalCC.EXCEPTIONREPORTING(conn, e);
      }
      return null;
  }
  
  public String SaveGeneralInterestRate() {
      if(generalWEF.getValue()==null) {
          String Message = "Enter WEF Date.";
          FacesContext.getCurrentInstance().addMessage(null, 
                                                       new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                        Message, 
                                                                        Message));
         return null;
      }
      if(generalInterest.getValue()==null) {
          String Message = "Enter Interest Rate.";
          FacesContext.getCurrentInstance().addMessage(null, 
                                                       new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                        Message, 
                                                                        Message));
         return null;
      }
      String saveQuery="BEGIN LMS_SETUPS_PKG.update_genrlintrstrates(?,?,?,?,?,?,?,?,?,?);END;";
      Connection conn=null;
      try
      {
          conn=new DBConnector().getDatabaseConn();
      CallableStatement cstmt=conn.prepareCall(saveQuery);    
      cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("LGR_CODE"));
      cstmt.setBigDecimal(2, (BigDecimal)session.getAttribute("ProductCode"));
      cstmt.setString(3, generalType.getValue().toString());
      if(generalInterest.getValue()==null) {
          cstmt.setString(4,null);
      }
      else {
          cstmt.setString(4, generalInterest.getValue().toString());  
      }
      if(generalAppType.getValue()==null) {
          cstmt.setString(5,null);
      }
      else {
          cstmt.setString(5,generalAppType.getValue().toString());     
      }
      
      if(genrlDivFactor.getValue()==null) {
          cstmt.setString(6,null);
      }
      else {
          cstmt.setString(6,genrlDivFactor.getValue().toString());     
      }
      if(freqOfPayment.getValue()==null) {
          cstmt.setString(7,null);
      }
      else {
          cstmt.setString(7,freqOfPayment.getValue().toString());     
      }
          String todayString = null;
          if(generalWEF.getValue()==null){
                  
          }
          else if(generalWEF.getValue().toString().contains(":")){
                  todayString = GlobalCC.parseDate(generalWEF.getValue().toString());
          }else{
                  todayString = GlobalCC.upDateParseDate(generalWEF.getValue().toString());
          }
          cstmt.setString(8,todayString);
          String todayString1 = null;
          if(genrlWetDate.getValue()==null){
                  
          }
          else if(genrlWetDate.getValue().toString().contains(":")){
                  todayString1 = GlobalCC.parseDate(genrlWetDate.getValue().toString());
          }else{
                  todayString1 = GlobalCC.upDateParseDate(genrlWetDate.getValue().toString());
          }
          cstmt.setString(9,todayString1);
          cstmt.setBigDecimal(10, (BigDecimal)session.getAttribute("lpnt_code"));
      cstmt.execute();
      conn.close();
      
      String Message = "General Interest Rate saved successfully.";
      FacesContext.getCurrentInstance().addMessage(null, 
                                                   new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                    Message, 
                                                                    Message));
      
          session.setAttribute("LGR_CODE",null);
          ADFUtils.findIterator("findGeneralInterestRatesIterator").executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(generalInterestLOV);
          
          ADFUtils.findIterator("findGeneralInterestRatesForTableIterator").executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(tableRates);
      
      }
      catch(Exception ex) {
      GlobalCC.EXCEPTIONREPORTING(conn,ex);
      }
      return null;
  }
  
  public String PensionPolicySelected(){
      try{
          RowKeySet rowKeySet =  pensPoliciesLOV.getSelectedRowKeys();
                  if (!rowKeySet.iterator().hasNext()) {
                      GlobalCC.errorValueNotEntered("Error: No Record Selected");
                      //return null;
                  }

                  Object key2 = rowKeySet.iterator().next();
                  pensPoliciesLOV.setRowKey(key2);

                  JUCtrlValueBinding r = (JUCtrlValueBinding)pensPoliciesLOV.getRowData();

                  if (r == null) {
                      GlobalCC.errorValueNotEntered("Error: No Record Selected");
                      //return null;
                  } 
          pensPoliciesDesc.setValue(r.getAttribute("POL_POLICY_NO"));
          session.setAttribute("policyCode", r.getAttribute("LPNT_POL_CODE"));
          
          ExtendedRenderKitService erkService =
          Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
          ExtendedRenderKitService.class);
          erkService.addScript(FacesContext.getCurrentInstance(),
          "var hints = {autodismissNever:false}; " +
          "AdfPage.PAGE.findComponent('" + "lmsgroup:TableRtes" +
          "').show(hints);");

      }catch(Exception e){
          GlobalCC.EXCEPTIONREPORTING(null, e);
      }
      return null;
  }

    public void setPensionProductsTree(RichTree pensionProductsTree) {
        this.pensionProductsTree = pensionProductsTree;
    }

    public RichTree getPensionProductsTree() {
        return pensionProductsTree;
    }

    public void pensionProductsListener(SelectionEvent selectionEvent) {
        if (selectionEvent.getAddedSet() != selectionEvent.getRemovedSet()) {
            RowKeySet rowKeySet = pensionProductsTree.getSelectedRowKeys();
            Object key2 = rowKeySet.iterator().next();
            pensionProductsTree.setRowKey(key2);
            JUCtrlValueBinding nodeBinding =
                (JUCtrlValueBinding)pensionProductsTree.getRowData();
                session.setAttribute("ProductCode",
                                     nodeBinding.getAttribute("PROD_CODE"));
            session.setAttribute("ProdShtDesc",
                                 nodeBinding.getAttribute("PROD_SHT_DESC"));
            ADFUtils.findIterator("findPensionCostingFactorsIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(pensionCostingFactorsLOV);
            /*try
            {
                ADFUtils.findIterator("findPensionContributionFactorsIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(retirementAgesLOV);
            }
            catch(Exception ex) {
                ex.printStackTrace();
            }*/
            ADFUtils.findIterator("findRetirementAgesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(retirementAgesLOV);
            ADFUtils.findIterator("findEmvEERatesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(employeeEmvRatesLOV);
            ADFUtils.findIterator("findGratuityPensionratesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(gratuityLOV);
           ADFUtils.findIterator("findPensionContributionFactorsIterator").executeQuery();
           AdfFacesContext.getCurrentInstance().addPartialTarget(pensContributionFactorsLOV);
            ADFUtils.findIterator("findPensionCommutationFactorsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(commutationLOV);
        }
    }

    public void setPensionCostingFactorsLOV(RichTable pensionCostingFactorsLOV) {
        this.pensionCostingFactorsLOV = pensionCostingFactorsLOV;
    }

    public RichTable getPensionCostingFactorsLOV() {
        return pensionCostingFactorsLOV;
    }

    public String AddpensionCostingFactors() {
        session.setAttribute("PCFS_CODE",null);
        pcfsEscalation.setValue(null);
        pcfsEscalation.setValue(null);
        withholdingRateType.setValue(null);
        pcfsWithholdingRate.setValue(null);
        pcfsDivisionFactor.setValue(null);
        
        GlobalCC.showPopup("lmsgroup:pensionCostingFactorsPopup");
        
        return null;
    }
    
  public String AddpensionCostingFactorRates() {
      session.setAttribute("pcfrCode",null);
      session.setAttribute("action", "A");
      termFrom.setValue(null);
      termTo.setValue(null);
      benefitDiscount.setValue(null);
      contriFactor.setValue(null);
      
      GlobalCC.showPopup("lmsgroup:popup1");
      
      return null;
  }

    public void setPcfsEscalation(RichInputText pcfsEscalation) {
        this.pcfsEscalation = pcfsEscalation;
    }

    public RichInputText getPcfsEscalation() {
        return pcfsEscalation;
    }

    public void setPcfsInterest(RichInputText pcfsInterest) {
        this.pcfsInterest = pcfsInterest;
    }

    public RichInputText getPcfsInterest() {
        return pcfsInterest;
    }

    public void setPcfsWithholdingRate(RichInputText pcfsWithholdingRate) {
        this.pcfsWithholdingRate = pcfsWithholdingRate;
    }

    public RichInputText getPcfsWithholdingRate() {
        return pcfsWithholdingRate;
    }

    public void setWithholdingRateType(RichSelectOneChoice withholdingRateType) {
        this.withholdingRateType = withholdingRateType;
    }

    public RichSelectOneChoice getWithholdingRateType() {
        return withholdingRateType;
    }

    public void setPcfsDivisionFactor(RichInputText pcfsDivisionFactor) {
        this.pcfsDivisionFactor = pcfsDivisionFactor;
    }

    public RichInputText getPcfsDivisionFactor() {
        return pcfsDivisionFactor;
    }

    public String SavePensionCostingFactors() {
        String saveQuery="BEGIN LMS_SETUPS_PKG.updatePensionCostingFactors(?,?,?,?,?,?,?);END;";
        Connection conn=null;
        try
        {
            conn=new DBConnector().getDatabaseConn();
        CallableStatement cstmt=conn.prepareCall(saveQuery);    
        cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("PCFS_CODE"));
        if(pcfsEscalation.getValue()==null) {
            cstmt.setString(2,null);
        }
        else {
            cstmt.setString(2, pcfsEscalation.getValue().toString());  
        }
        if(pcfsInterest.getValue()==null) {
            cstmt.setString(3,null);
        }
        else {
            cstmt.setString(3, pcfsInterest.getValue().toString());  
        }
        cstmt.setBigDecimal(4, (BigDecimal)session.getAttribute("ProductCode"));
        if(pcfsWithholdingRate.getValue()==null) {
            cstmt.setString(5,null);
        }
        else {
            cstmt.setString(5, pcfsWithholdingRate.getValue().toString());  
        }
        if(withholdingRateType.getValue()==null) {
            cstmt.setString(6,null);
        }
        else {
            cstmt.setString(6,withholdingRateType.getValue().toString());     
        }
        
        if(pcfsDivisionFactor.getValue()==null) {
            cstmt.setString(7,null);
        }
        else {
            cstmt.setString(7,pcfsDivisionFactor.getValue().toString());     
        }
       
        cstmt.execute();
        conn.close();
        
        String Message = "Pension Factor saved successfully.";
        FacesContext.getCurrentInstance().addMessage(null, 
                                                     new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                      Message, 
                                                                      Message));
        
            session.setAttribute("PCFS_CODE",null);
            ADFUtils.findIterator("findPensionCostingFactorsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(pensionCostingFactorsLOV);
        
        }
        catch(Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
        }
        return null;
    }

    public String EditPensionCostingFactors() {
        RowKeySet rowKeySet = pensionCostingFactorsLOV.getSelectedRowKeys();
                if (!rowKeySet.iterator().hasNext()) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    return null;
                }

                Object key2 = rowKeySet.iterator().next();
               pensionCostingFactorsLOV.setRowKey(key2);

                JUCtrlValueBinding r = (JUCtrlValueBinding)pensionCostingFactorsLOV.getRowData();

                if (r == null) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    return null;
                } 
                session.setAttribute("PCFS_CODE",r.getAttribute("pcfsCode"));
                pcfsEscalation.setValue(r.getAttribute("pcfsEsca"));
                pcfsInterest.setValue(r.getAttribute("pcfsInterest"));
                pcfsWithholdingRate.setValue(r.getAttribute("pcfsWithRate"));
                withholdingRateType.setValue(r.getAttribute("pcfsRateType"));
                pcfsDivisionFactor.setValue(r.getAttribute("pcfsDivFact"));
                ExtendedRenderKitService erkService =
                Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                ExtendedRenderKitService.class);
                erkService.addScript(FacesContext.getCurrentInstance(),
                "var hints = {autodismissNever:false}; " +
                "AdfPage.PAGE.findComponent('" + "lmsgroup:pensionCostingFactorsPopup" +
                "').show(hints);");
        return null;
    }
    
  public String EditPensionCostingFactorRates() {
      RowKeySet rowKeySet = pensionCostingRates.getSelectedRowKeys();
              if (!rowKeySet.iterator().hasNext()) {
          GlobalCC.errorValueNotEntered("Error: No Record Selected");
                  return null;
              }

              Object key2 = rowKeySet.iterator().next();
             pensionCostingRates.setRowKey(key2);

              JUCtrlValueBinding r = (JUCtrlValueBinding)pensionCostingRates.getRowData();

              if (r == null) {
                GlobalCC.errorValueNotEntered("Error: No Record Selected");
                return null;
              } 
              session.setAttribute("pcfrCode",r.getAttribute("PCFR_CODE"));
              session.setAttribute("action", "E");
              termFrom.setValue(r.getAttribute("PCFR_TERM_FROM"));
              termTo.setValue(r.getAttribute("PCFR_TERM_TO"));
              benefitDiscount.setValue(r.getAttribute("PCFR_BENE_DISC_FACT"));
              contriFactor.setValue(r.getAttribute("PCFR_CONTR_FACT"));
            
              GlobalCC.showPopup("lmsgroup:popup1");
           
      return null;
  }
  
  public String DeletePensionCostingFactorRates() {
      RowKeySet rowKeySet = pensionCostingRates.getSelectedRowKeys();
              if (!rowKeySet.iterator().hasNext()) {
          GlobalCC.errorValueNotEntered("Error: No Record Selected");
                  return null;
              }

              Object key2 = rowKeySet.iterator().next();
             pensionCostingRates.setRowKey(key2);

              JUCtrlValueBinding r = (JUCtrlValueBinding)pensionCostingRates.getRowData();

              if (r == null) {
                GlobalCC.errorValueNotEntered("Error: No Record Selected");
                return null;
              } 
              session.setAttribute("pcfrCode",r.getAttribute("PCFR_CODE"));
              session.setAttribute("action", "D");
              termFrom.setValue(r.getAttribute("PCFR_TERM_FROM"));
              termTo.setValue(r.getAttribute("PCFR_TERM_TO"));
              benefitDiscount.setValue(r.getAttribute("PCFR_BENE_DISC_FACT"));
              contriFactor.setValue(r.getAttribute("PCFR_CONTR_FACT"));
            
              savePensionCostingRates();
    
      return null;
  }
  
  public String savePensionCostingRates(){
    Connection conn = null;
    try{
      conn=new DBConnector().getDatabaseConn();
      String authQuery="BEGIN LMS_SETUPS_PKG.save_pens_cost_fac_rates(?,?,?,?,?,?,?);END;";
      CallableStatement cstmt=conn.prepareCall(authQuery);    
      cstmt.setString(1, (String)session.getAttribute("action"));
      cstmt.setBigDecimal(2, (BigDecimal)session.getAttribute("pcfrCode"));
      cstmt.setBigDecimal(3, (BigDecimal)session.getAttribute("PCFS_CODE"));
      if(termFrom.getValue()==null){
        cstmt.setString(4, null);
      }else{
        cstmt.setString(4, termFrom.getValue().toString());
      }
      if(termTo.getValue()==null){
        cstmt.setString(5, null);
      }else{
        cstmt.setString(5, termTo.getValue().toString());
      }
      if(benefitDiscount.getValue()==null){
        cstmt.setString(6, null);
      }else{
        cstmt.setString(6, benefitDiscount.getValue().toString());
      }
      if(contriFactor.getValue()==null){
        cstmt.setString(7, null);
      }else{
        cstmt.setString(7, contriFactor.getValue().toString());
      }
      cstmt.execute();
      cstmt.close();
      conn.close();
        
      GlobalCC.INFORMATIONREPORTING("Transaction Successfully Completed.");
      
      ADFUtils.findIterator("findPensionCostingFactorRatesIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(pensionCostingRates); 
      GlobalCC.hidePopup("lmsgroup:popup1");
    }catch(Exception e){
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
  }

    public String DeletePensionCostingFactors() {
        RowKeySet rowKeySet = pensionCostingFactorsLOV.getSelectedRowKeys();
                if (!rowKeySet.iterator().hasNext()) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    return null;
                }

                Object key2 = rowKeySet.iterator().next();
               pensionCostingFactorsLOV.setRowKey(key2);

                JUCtrlValueBinding r = (JUCtrlValueBinding)pensionCostingFactorsLOV.getRowData();

                if (r == null) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    return null;
                } 
                session.setAttribute("PCFS_CODE",r.getAttribute("pcfsCode"));
                String authQuery="BEGIN LMS_SETUPS_PKG.deletePensionCostingFactors(?);END;";
                Connection conn=new DBConnector().getDatabaseConn();
                try
                {
                CallableStatement cstmt=conn.prepareCall(authQuery);    
                cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("PCFS_CODE"));
                cstmt.execute();
                conn.close();
                    String Message = "Pension Costing Factor deleted successfully.";
                    FacesContext.getCurrentInstance().addMessage(null, 
                                                                 new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                                  Message, 
                                                                                  Message));
                    
                   
                    session.setAttribute("PCFS_CODE",null);
            ADFUtils.findIterator("findPensionCostingFactorsIterator").executeQuery();
                    AdfFacesContext.getCurrentInstance().addPartialTarget(pensionCostingFactorsLOV);
                }
                catch(Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
                } 
        return null;
    }

    public void setPensContributionFactorsLOV(RichTable pensContributionFactorsLOV) {
        this.pensContributionFactorsLOV = pensContributionFactorsLOV;
    }

    public RichTable getPensContributionFactorsLOV() {
        return pensContributionFactorsLOV;
    }

    public String AddContributionFactors() {
        adding=true;
        session.setAttribute("PEIR_CODE",null);
        contrTaxExempt.setValue(null);
        taxExempt.setValue(null);
        pensIntrRate.setValue(null);
       taxMaxExemptAmount.setValue(null);
        taxRelief.setValue(null);
        femaleFactor.setValue(null);
        maleFactor.setValue(null);
        factorType.setValue(null);
        contrWEF.setValue(null);
        contrWetDate.setValue(null);
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:contributionFactorsPopup" +
        "').show(hints);");
        return null;
    }

    public void setContrTaxExempt(RichInputText contrTaxExempt) {
        this.contrTaxExempt = contrTaxExempt;
    }

    public RichInputText getContrTaxExempt() {
        return contrTaxExempt;
    }

    public void setTaxExempt(RichInputText taxExempt) {
        this.taxExempt = taxExempt;
    }

    public RichInputText getTaxExempt() {
        return taxExempt;
    }

    public void setPensIntrRate(RichInputText pensIntrRate) {
        this.pensIntrRate = pensIntrRate;
    }

    public RichInputText getPensIntrRate() {
        return pensIntrRate;
    }

    public void setTaxMaxExemptAmount(RichInputText taxMaxExemptAmount) {
        this.taxMaxExemptAmount = taxMaxExemptAmount;
    }

    public RichInputText getTaxMaxExemptAmount() {
        return taxMaxExemptAmount;
    }

    public void setTaxRelief(RichInputText taxRelief) {
        this.taxRelief = taxRelief;
    }

    public RichInputText getTaxRelief() {
        return taxRelief;
    }

    public void setFemaleFactor(RichInputText femaleFactor) {
        this.femaleFactor = femaleFactor;
    }

    public RichInputText getFemaleFactor() {
        return femaleFactor;
    }

    public void setMaleFactor(RichInputText maleFactor) {
        this.maleFactor = maleFactor;
    }

    public RichInputText getMaleFactor() {
        return maleFactor;
    }

    public void setFactorType(RichSelectOneChoice factorType) {
        this.factorType = factorType;
    }

    public RichSelectOneChoice getFactorType() {
        return factorType;
    }

    public void setContrWEF(RichInputDate contrWEF) {
        this.contrWEF = contrWEF;
    }

    public RichInputDate getContrWEF() {
        return contrWEF;
    }

    public void setContrWetDate(RichInputDate contrWetDate) {
        this.contrWetDate = contrWetDate;
    }

    public RichInputDate getContrWetDate() {
        return contrWetDate;
    }

    public String SaveContributionFactors() {
        String saveQuery="BEGIN LMS_SETUPS_PKG.updatePensionContrFactors(?,?,?,?,?,?,?,?,?,?,?,?,?);END;";
        Connection conn=null;
        try
        {
        conn=new DBConnector().getDatabaseConn();
        CallableStatement cstmt=conn.prepareCall(saveQuery);    
        cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("PEIR_CODE"));
        if(contrTaxExempt.getValue()==null) {
            cstmt.setString(2,null);
        }
        else {
            cstmt.setString(2, contrTaxExempt.getValue().toString());  
        }
        if(taxExempt.getValue()==null) {
            cstmt.setString(3,null);
        }
        else {
            cstmt.setString(3, taxExempt.getValue().toString());  
        }
        if(taxMaxExemptAmount.getValue()==null) {
            cstmt.setString(4,null);
        }
        else {
            cstmt.setString(4,taxMaxExemptAmount.getValue().toString());  
        }
        if(pensIntrRate.getValue()==null) {
            cstmt.setString(5,null);
        }
        else {
            cstmt.setString(5,pensIntrRate.getValue().toString());     
        }
        
        if(taxRelief.getValue()==null) {
            cstmt.setString(6,null);
        }
        else {
            cstmt.setString(6,taxRelief.getValue().toString());     
        }
        if(femaleFactor.getValue()==null) {
            cstmt.setString(7,null);
        }
        else {
            cstmt.setString(7,femaleFactor.getValue().toString());     
        }
        if(maleFactor.getValue()==null) {
            cstmt.setString(8,null);
        }
        else {
            cstmt.setString(8,maleFactor.getValue().toString());     
        }
        if(factorType.getValue()==null){
          cstmt.setString(9, null); 
        }else{
          cstmt.setString(9,factorType.getValue().toString()); 
        }
        if(contrWEF.getValue()==null){
          cstmt.setString(10, null); 
        }else{
            if(contrWEF.getValue().toString().contains(":")){
              cstmt.setString(10,GlobalCC.parseDate(contrWEF.getValue().toString())); 
            }else{
              cstmt.setString(10,GlobalCC.upDateParseDate(contrWEF.getValue().toString())); 
            }
          
        }
        if(contrWetDate.getValue()==null){
          cstmt.setString(11, null); 
        }else{
            if(contrWetDate.getValue().toString().contains(":")){
              cstmt.setString(11,GlobalCC.parseDate(contrWetDate.getValue().toString())); 
            }else{
              cstmt.setString(11,GlobalCC.upDateParseDate(contrWetDate.getValue().toString())); 
            }
          
        }
       cstmt.setBigDecimal(12, (BigDecimal)session.getAttribute("ProductCode"));
       cstmt.setString(13,empyr_lump_exempt.getValue().toString());
       cstmt.execute();
       cstmt.close();
       conn.close();
        
        GlobalCC.INFORMATIONREPORTING("Pension Contribution Factors saved successfully.");
         
        session.setAttribute("PEIR_CODE",null);
        ADFUtils.findIterator("findPensionContributionFactorsIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(pensContributionFactorsLOV);
        
        }
        catch(Exception ex) {
          GlobalCC.EXCEPTIONREPORTING(conn,ex);
        }
        return null;
    }

    public String EditPensionContrFactors() {
        adding=false;
        RowKeySet rowKeySet = pensContributionFactorsLOV.getSelectedRowKeys();
                if (!rowKeySet.iterator().hasNext()) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    return null;
                }

                Object key2 = rowKeySet.iterator().next();
               pensContributionFactorsLOV.setRowKey(key2);

                JUCtrlValueBinding r = (JUCtrlValueBinding)pensContributionFactorsLOV.getRowData();

                if (r == null) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    return null;
                } 
                session.setAttribute("PEIR_CODE",r.getAttribute("peirCode"));
                contrTaxExempt.setValue(r.getAttribute("peirCntrTaxExempt"));
                taxExempt.setValue(r.getAttribute("peirTaxExempt"));
                pensIntrRate.setValue(r.getAttribute("peirIntRate"));
                femaleFactor.setValue(r.getAttribute("peirUndwConvFactor"));
                maleFactor.setValue(r.getAttribute("peirDirConvFactor"));
                taxMaxExemptAmount.setValue(r.getAttribute("peirMaxTaxExempt"));
                taxRelief.setValue(r.getAttribute("peirTaxRelief"));
                factorType.setValue(r.getAttribute("peirFactorType"));
                contrWEF.setValue(r.getAttribute("peirWef"));
                contrWetDate.setValue(r.getAttribute("peirWet"));
                empyr_lump_exempt.setValue(r.getAttribute("peir_empyr_lump_tax_exmpt"));
                ExtendedRenderKitService erkService =
                Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                ExtendedRenderKitService.class);
                erkService.addScript(FacesContext.getCurrentInstance(),
                "var hints = {autodismissNever:false}; " +
                "AdfPage.PAGE.findComponent('" + "lmsgroup:contributionFactorsPopup" +
                "').show(hints);");
        return null;
    }

    public String DeletePensionContrFactors() {
        RowKeySet rowKeySet = pensContributionFactorsLOV.getSelectedRowKeys();
                if (!rowKeySet.iterator().hasNext()) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    return null;
                }

                Object key2 = rowKeySet.iterator().next();
               pensContributionFactorsLOV.setRowKey(key2);

                JUCtrlValueBinding r = (JUCtrlValueBinding)pensContributionFactorsLOV.getRowData();

                if (r == null) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    return null;
                } 
            session.setAttribute("PEIR_CODE",r.getAttribute("peirCode"));
            String authQuery="BEGIN LMS_SETUPS_PKG.deletePensionContrFactors(?);END;";
            Connection conn=new DBConnector().getDatabaseConn();
            try
            {
            CallableStatement cstmt=conn.prepareCall(authQuery);    
            cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("PEIR_CODE"));
            cstmt.execute();
            conn.close();
                String Message = "Pension Contribution Factors deleted successfully.";
                FacesContext.getCurrentInstance().addMessage(null, 
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                              Message, 
                                                                              Message));
                
               
                session.setAttribute("PEIR_CODE",null);
            ADFUtils.findIterator("findPensionContributionFactorsIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(pensContributionFactorsLOV);
            }
            catch(Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
            } 
        return null;
    }

    public String AddRetirementAges() {
        session.setAttribute("RET_CODE",null);
        emvErRetireAge.setValue(null);
        emvErSex.setValue(null);
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:retirementAgesPopup" +
        "').show(hints);");
        return null;
    }

    public String DeleteRetirementAges() {
        RowKeySet rowKeySet = retirementAgesLOV.getSelectedRowKeys();
                if (!rowKeySet.iterator().hasNext()) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    return null;
                }

                Object key2 = rowKeySet.iterator().next();
               retirementAgesLOV.setRowKey(key2);

                JUCtrlValueBinding r = (JUCtrlValueBinding)retirementAgesLOV.getRowData();

                if (r == null) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    return null;
                } 
            session.setAttribute("RET_CODE",r.getAttribute("retCode"));
            String authQuery="BEGIN LMS_SETUPS_PKG.deleteRetireAges(?);END;";
            Connection conn=new DBConnector().getDatabaseConn();
            try
            {
            CallableStatement cstmt=conn.prepareCall(authQuery);    
            cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("RET_CODE"));
            cstmt.execute();
            conn.close();
                String Message = "Retirement Age deleted successfully.";
                FacesContext.getCurrentInstance().addMessage(null, 
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                              Message, 
                                                                              Message));
                
               
                session.setAttribute("RET_CODE",null);
            ADFUtils.findIterator("findRetirementAgesIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(retirementAgesLOV);
            }
            catch(Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
            } 
        return null;
    }

    public String EditRetirementAges() {
        RowKeySet rowKeySet = retirementAgesLOV.getSelectedRowKeys();
                if (!rowKeySet.iterator().hasNext()) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    return null;
                }

                Object key2 = rowKeySet.iterator().next();
               retirementAgesLOV.setRowKey(key2);

                JUCtrlValueBinding r = (JUCtrlValueBinding)retirementAgesLOV.getRowData();

                if (r == null) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    return null;
                } 
            session.setAttribute("RET_CODE",r.getAttribute("retCode"));
        emvErRetireAge.setValue(r.getAttribute("retAge"));
        emvErSex.setValue(r.getAttribute("retSex"));
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:retirementAgesPopup" +
        "').show(hints);");
        return null;
    }

    public void setEmvErRetireAge(RichInputText emvErRetireAge) {
        this.emvErRetireAge = emvErRetireAge;
    }

    public RichInputText getEmvErRetireAge() {
        return emvErRetireAge;
    }

    public void setEmvErSex(RichSelectOneChoice emvErSex) {
        this.emvErSex = emvErSex;
    }

    public RichSelectOneChoice getEmvErSex() {
        return emvErSex;
    }

    public String SaveEmvErRates() {
         if(emvErRetireAge.getValue()==null) {
             String Message = "Enter Retirement Age.";
             FacesContext.getCurrentInstance().addMessage(null, 
                                                          new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                           Message, 
                                                                           Message));
             return null;
         }
        if(emvErSex.getValue()==null) {
            String Message = "Choose Gender.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            return null;
        }
         String updateQuery="BEGIN LMS_SETUPS_PKG.updateRetireAges(?,?,?,?);END;";
        Connection conn=null;
        try
        {
            conn=new DBConnector().getDatabaseConn();
        CallableStatement cstmt=conn.prepareCall(updateQuery);    
        cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("RET_CODE"));
        cstmt.setBigDecimal(2, (BigDecimal)session.getAttribute("ProductCode"));
        cstmt.setString(3, emvErRetireAge.getValue().toString());
        cstmt.setString(4,emvErSex.getValue().toString());  
        
        cstmt.execute();
        conn.close();
        
        String Message = "Retirement Age saved successfully.";
        FacesContext.getCurrentInstance().addMessage(null, 
                                                     new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                      Message, 
                                                                      Message));
        
            session.setAttribute("RET_CODE",null);
            ADFUtils.findIterator("findRetirementAgesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(retirementAgesLOV); 
        }
        catch(Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
        }
        return null;
    }

    public void setRetirementAgesLOV(RichTable retirementAgesLOV) {
        this.retirementAgesLOV = retirementAgesLOV;
    }

    public RichTable getRetirementAgesLOV() {
        return retirementAgesLOV;
    }

    public void setEmvErRatesLOV(RichTable emvErRatesLOV) {
        this.emvErRatesLOV = emvErRatesLOV;
    }

    public RichTable getEmvErRatesLOV() {
        return emvErRatesLOV;
    }

    public void RetirementAgesListener(SelectionEvent selectionEvent) {
        DCIteratorBinding dciter = ADFUtils.findIterator("findRetirementAgesIterator");
        RowKeySet set =retirementAgesLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        
        //System.out.println(1);
        while (rowKeySetIter.hasNext()) 
        {
            List l = (List) rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
          
        
            session.setAttribute("RET_CODE",r.getAttribute("retCode"));
            session.setAttribute("RET_AGE",r.getAttribute("retAge"));
        
        }
        /*RowKeySet rowKeySet = retirementAgesLOV.getSelectedRowKeys();
                if (!rowKeySet.iterator().hasNext()) {
                    GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                }

                Object key2 = rowKeySet.iterator().next();
               retirementAgesLOV.setRowKey(key2);

                JUCtrlValueBinding r = (JUCtrlValueBinding)retirementAgesLOV.getRowData();

                if (r == null) {
                    GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                }
            session.setAttribute("RET_CODE",r.getAttribute("retCode"));
            session.setAttribute("RET_AGE",r.getAttribute("retAge"));*/
        ADFUtils.findIterator("findEmvErRatesIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(emvErRatesLOV); 
    }

    public String AddEmvErRates() {
        session.setAttribute("EMVER_CODE",null);
        emverANB.setValue(null);
        emverBasicPrem.setValue(null);
        emverBasicSA.setValue(null);
        emverEmvValue.setValue(null);
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:EmvErRatesPopup" +
        "').show(hints);");
        return null;
    }

    public String EditEmvErRates() {
        RowKeySet rowKeySet = emvErRatesLOV.getSelectedRowKeys();
                if (!rowKeySet.iterator().hasNext()) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                }

                Object key2 = rowKeySet.iterator().next();
               emvErRatesLOV.setRowKey(key2);

                JUCtrlValueBinding r = (JUCtrlValueBinding)emvErRatesLOV.getRowData();

                if (r == null) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                } 
            session.setAttribute("EMVER_CODE",r.getAttribute("emverCode"));
            emverANB.setValue(r.getAttribute("emverAnb"));
            emverBasicPrem.setValue(r.getAttribute("emverBasicPrem"));
            emverBasicSA.setValue(r.getAttribute("emverBasicSa"));
            emverEmvValue.setValue(r.getAttribute("emverEmvValue"));
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:EmvErRatesPopup" +
        "').show(hints);");
        return null;
    }

    public String DeleteEmvErRates() {
        RowKeySet rowKeySet = emvErRatesLOV.getSelectedRowKeys();
                if (!rowKeySet.iterator().hasNext()) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                }

                Object key2 = rowKeySet.iterator().next();
               emvErRatesLOV.setRowKey(key2);

                JUCtrlValueBinding r = (JUCtrlValueBinding)emvErRatesLOV.getRowData();

                if (r == null) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                } 
            session.setAttribute("EMVER_CODE",r.getAttribute("emverCode"));
        String authQuery="BEGIN LMS_SETUPS_PKG.deleteEmvRates(?);END;";
        Connection conn=new DBConnector().getDatabaseConn();
        try
        {
        CallableStatement cstmt=conn.prepareCall(authQuery);    
        cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("EMVER_CODE"));
        cstmt.execute();
        conn.close();
            String Message = "EMV Rates deleted successfully.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            
           
            session.setAttribute("EMVER_CODE",null);
            ADFUtils.findIterator("findEmvErRatesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(emvErRatesLOV); 
        }
        catch(Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
        } 
        return null;
    }

    public void setEmverANB(RichInputText emverANB) {
        this.emverANB = emverANB;
    }

    public RichInputText getEmverANB() {
        return emverANB;
    }

    public void setEmverBasicPrem(RichInputText emverBasicPrem) {
        this.emverBasicPrem = emverBasicPrem;
    }

    public RichInputText getEmverBasicPrem() {
        return emverBasicPrem;
    }

    public void setEmverBasicSA(RichInputText emverBasicSA) {
        this.emverBasicSA = emverBasicSA;
    }

    public RichInputText getEmverBasicSA() {
        return emverBasicSA;
    }

    public void setEmverEmvValue(RichInputText emverEmvValue) {
        this.emverEmvValue = emverEmvValue;
    }

    public RichInputText getEmverEmvValue() {
        return emverEmvValue;
    }

    public String SaveEmvEmpyrRates() {
        if(emverANB.getValue()==null) {
            String Message = "Enter ANB.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            return null;
        }
        if(emverBasicPrem.getValue()==null) {
           String Message = "Enter Basic Premium.";
           FacesContext.getCurrentInstance().addMessage(null, 
                                                        new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                         Message, 
                                                                         Message));
           return null;
        }
        if(emverBasicSA.getValue()==null) {
           String Message = "Enter Basic Sum Assured.";
           FacesContext.getCurrentInstance().addMessage(null, 
                                                        new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                         Message, 
                                                                         Message));
           return null;
        }
        if(emverEmvValue.getValue()==null) {
           String Message = "Enter EMV Value.";
           FacesContext.getCurrentInstance().addMessage(null, 
                                                        new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                         Message, 
                                                                         Message));
           return null;
        }
        String updateQuery="BEGIN LMS_SETUPS_PKG.updateEmvErrates(?,?,?,?,?,?,?,?);END;";
        Connection conn=null;
        try
        {
           conn=new DBConnector().getDatabaseConn();
        CallableStatement cstmt=conn.prepareCall(updateQuery);
        cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("EMVER_CODE"));
        cstmt.setString(2, emverANB.getValue().toString());
        cstmt.setString(3, emverBasicPrem.getValue().toString());
        cstmt.setString(4, emverBasicSA.getValue().toString());
        cstmt.setString(5, emverEmvValue.getValue().toString());
        cstmt.setString(6, (String)session.getAttribute("RET_AGE"));
        cstmt.setBigDecimal(7, (BigDecimal)session.getAttribute("ProductCode"));
        cstmt.setBigDecimal(8, (BigDecimal)session.getAttribute("RET_CODE"));
          
        cstmt.execute();
        conn.close();
        
        String Message = "Employer EMV Rates saved successfully.";
        FacesContext.getCurrentInstance().addMessage(null,
                                                    new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                     Message, 
                                                                     Message));
        
            session.setAttribute("EMVER_CODE",null);
            ADFUtils.findIterator("findEmvErRatesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(emvErRatesLOV);
        }
        catch(Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
        }
        return null;
    }

    public String AddEMVeeRates() {
        session.setAttribute("EMVEE_CODE",null);
        term.setValue(null);
        emveeBasicPremium.setValue(null);
        emveeBasicSumAssured.setValue(null);
        emveeEMV.setValue(null);
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:EmployeeEMVRates" +
        "').show(hints);");
        return null;
    }

    public String EditEmvEeRates() {
        RowKeySet rowKeySet =  employeeEmvRatesLOV.getSelectedRowKeys();
                if (!rowKeySet.iterator().hasNext()) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                }

                Object key2 = rowKeySet.iterator().next();
                employeeEmvRatesLOV.setRowKey(key2);

                JUCtrlValueBinding r = (JUCtrlValueBinding) employeeEmvRatesLOV.getRowData();

                if (r == null) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                } 
            session.setAttribute("EMVEE_CODE",r.getAttribute("emveeCode"));
            term.setValue(r.getAttribute("emveeTerm"));
            emveeBasicPremium.setValue(r.getAttribute("emveeBasicPrem"));
            emveeBasicSumAssured.setValue(r.getAttribute("emveeBasicSa"));
            emveeEMV.setValue(r.getAttribute("emveeEmv"));
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:EmployeeEMVRates" +
        "').show(hints);");
        return null;
       
    }

    public String DeleteEmvEeRates() {
        RowKeySet rowKeySet =  employeeEmvRatesLOV.getSelectedRowKeys();
                if (!rowKeySet.iterator().hasNext()) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                }

                Object key2 = rowKeySet.iterator().next();
                employeeEmvRatesLOV.setRowKey(key2);

                JUCtrlValueBinding r = (JUCtrlValueBinding) employeeEmvRatesLOV.getRowData();

                if (r == null) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                } 
            session.setAttribute("EMVEE_CODE",r.getAttribute("emveeCode"));
        String authQuery="BEGIN LMS_SETUPS_PKG.deleteEmvEeRates(?);END;";
        Connection conn=new DBConnector().getDatabaseConn();
        try
        {
        CallableStatement cstmt=conn.prepareCall(authQuery);    
        cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("EMVEE_CODE"));
        cstmt.execute();
        conn.close();
            String Message = "EMV Rates deleted successfully.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            
           
            session.setAttribute("EMVEE_CODE",null);
            ADFUtils.findIterator("findEmvEERatesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(employeeEmvRatesLOV); 
        }
        catch(Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
        } 
        return null;
    }
    
  public String AddPensionScale(){
      
    session.setAttribute("pgvsCode", null);
    session.setAttribute("action", "A");
    yearFrom.setValue(null);
    yearTo.setValue(null);
    emyrEnt.setValue(null);
    emyeEnt.setValue(null);
    GlobalCC.showPopup("lmsgroup:popup2");
    
    return null;
  }
  
  public String EditPensionScale(){
      try{
        RowKeySet rowKeySet =  vestingTable.getSelectedRowKeys();
                if (!rowKeySet.iterator().hasNext()) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                }

              Object key2 = rowKeySet.iterator().next();
              vestingTable.setRowKey(key2);

                JUCtrlValueBinding r = (JUCtrlValueBinding) vestingTable.getRowData();
                if (r == null) {
                  GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                } 
        
        
          session.setAttribute("pgvsCode", r.getAttribute("PVGS_CODE"));
          yearFrom.setValue(r.getAttribute("PVGS_YRS_FROM"));
          yearTo.setValue(r.getAttribute("PVGS_YRS_TO"));
          emyrEnt.setValue(r.getAttribute("PVGS_EMYR_PCT_ENT"));
          emyeEnt.setValue(r.getAttribute("PVGS_EMYE_PCT_ENT"));
          session.setAttribute("action", "E");
          
        GlobalCC.showPopup("lmsgroup:popup2");
      }catch(Exception e){
        GlobalCC.EXCEPTIONREPORTING(null, e);
      }
      return null;
  }
  
  public String DeletePensionScale(){
    try{
      RowKeySet rowKeySet =  vestingTable.getSelectedRowKeys();
              if (!rowKeySet.iterator().hasNext()) {
          GlobalCC.errorValueNotEntered("Error: No Record Selected");
                  //return null;
              }

            Object key2 = rowKeySet.iterator().next();
            vestingTable.setRowKey(key2);

              JUCtrlValueBinding r = (JUCtrlValueBinding) vestingTable.getRowData();
              if (r == null) {
                GlobalCC.errorValueNotEntered("Error: No Record Selected");
                  //return null;
              } 
      
      
        session.setAttribute("pgvsCode", r.getAttribute("PVGS_CODE"));
        yearFrom.setValue(r.getAttribute("PVGS_YRS_FROM"));
        yearTo.setValue(r.getAttribute("PVGS_YRS_TO"));
        emyrEnt.setValue(r.getAttribute("PVGS_EMYR_PCT_ENT"));
        emyeEnt.setValue(r.getAttribute("PVGS_EMYE_PCT_ENT"));
        session.setAttribute("action", "D");
        
        SavePensionScale();
        
    }catch(Exception e){
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
    return null;
  }
  
  public String SavePensionScale(){
      Connection conn = null;
      try{
        DBConnector MyDB = new DBConnector();
        conn = MyDB.getDatabaseConn();
        CallableStatement cst = conn.prepareCall("BEGIN lms_web_pkg_grp_uw.save_pens_vesting_scale(?,?,?,?,?,?,?);END;");
        cst.setString(1, (String)session.getAttribute("action"));
        cst.setBigDecimal(2, (BigDecimal)session.getAttribute("pgvsCode"));
        cst.setBigDecimal(3, (BigDecimal)session.getAttribute("ProductCode"));
        if(yearFrom.getValue()==null){
          cst.setString(4, null);
        }else{
          cst.setString(4, yearFrom.getValue().toString());
        }
        if(yearTo.getValue()==null){
          cst.setString(5, null);
        }else{
          cst.setString(5, yearTo.getValue().toString());
        }
        if(emyrEnt.getValue()==null){
          cst.setString(6, null);
        }else{
          cst.setString(6, emyrEnt.getValue().toString());
        }
        if(emyeEnt.getValue()==null){
          cst.setString(7, null);
        }else{
          cst.setString(7, emyeEnt.getValue().toString());
        }
        cst.execute();
        cst.close();
        conn.close();
          
        GlobalCC.INFORMATIONREPORTING("Transaction Completed Successfully");
          
        ADFUtils.findIterator("findPensionVestingScalesIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(vestingTable);
        GlobalCC.hidePopup("lmsgroup:popup2");
        
      }catch(Exception e){
        GlobalCC.EXCEPTIONREPORTING(conn, e);
      }
      return null;
  }

    public void setTerm(RichInputText term) {
        this.term = term;
    }

    public RichInputText getTerm() {
        return term;
    }

    public void setEmveeBasicPremium(RichInputText emveeBasicPremium) {
        this.emveeBasicPremium = emveeBasicPremium;
    }

    public RichInputText getEmveeBasicPremium() {
        return emveeBasicPremium;
    }

    public void setEmveeBasicSumAssured(RichInputText emveeBasicSumAssured) {
        this.emveeBasicSumAssured = emveeBasicSumAssured;
    }

    public RichInputText getEmveeBasicSumAssured() {
        return emveeBasicSumAssured;
    }

    public void setEmveeEMV(RichInputText emveeEMV) {
        this.emveeEMV = emveeEMV;
    }

    public RichInputText getEmveeEMV() {
        return emveeEMV;
    }

    public String SaveEmvEERates() {
        if(term.getValue()==null) {
            String Message = "Enter Term.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            return null;
        }
        if(emveeBasicPremium.getValue()==null) {
           String Message = "Enter Basic Premium.";
           FacesContext.getCurrentInstance().addMessage(null, 
                                                        new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                         Message, 
                                                                         Message));
           return null;
        }
        if(emveeBasicSumAssured.getValue()==null) {
           String Message = "Enter Basic Sum Assured.";
           FacesContext.getCurrentInstance().addMessage(null, 
                                                        new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                         Message, 
                                                                         Message));
           return null;
        }
        if(emveeEMV.getValue()==null) {
           String Message = "Enter EMV Value.";
           FacesContext.getCurrentInstance().addMessage(null, 
                                                        new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                         Message, 
                                                                         Message));
           return null;
        }
        String updateQuery="BEGIN LMS_SETUPS_PKG.updateEmvEeRates(?,?,?,?,?,?);END;";
        Connection conn=null;
        try
        {
           conn=new DBConnector().getDatabaseConn();
        CallableStatement cstmt=conn.prepareCall(updateQuery);
        cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("EMVEE_CODE"));
        cstmt.setString(2, term.getValue().toString());
        cstmt.setString(3, emveeBasicPremium.getValue().toString());
        cstmt.setString(4, emveeBasicSumAssured.getValue().toString());
        cstmt.setString(5, emveeEMV.getValue().toString());
        cstmt.setBigDecimal(6, (BigDecimal)session.getAttribute("ProductCode"));
       
          
        cstmt.execute();
        conn.close();
        
        String Message = "Employee EMV Rates saved successfully.";
        FacesContext.getCurrentInstance().addMessage(null,
                                                    new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                     Message, 
                                                                     Message));
        
            session.setAttribute("EMVEE_CODE",null);
            ADFUtils.findIterator("findEmvEERatesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(employeeEmvRatesLOV); 
        }
        catch(Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
        }
        return null;
    }

    public void setEmployeeEmvRatesLOV(RichTable employeeEmvRatesLOV) {
        this.employeeEmvRatesLOV = employeeEmvRatesLOV;
    }

    public RichTable getEmployeeEmvRatesLOV() {
        return employeeEmvRatesLOV;
    }

    public void setAnnRetirementAge(RichInputText annRetirementAge) {
        this.annRetirementAge = annRetirementAge;
    }

    public RichInputText getAnnRetirementAge() {
        return annRetirementAge;
    }

    public void setGratuityLOV(RichTable gratuityLOV) {
        this.gratuityLOV = gratuityLOV;
    }

    public RichTable getGratuityLOV() {
        return gratuityLOV;
    }

    public String AddGratuityRates() {
        session.setAttribute("GRAP_CODE",null);
        serviceYears.setValue(null);
        pensionPct.setValue(null);
        gratuityPct.setValue(null);
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:GratuityPopup" +
        "').show(hints);");
        return null;
    }

    public String EditGratuityRates() {
        RowKeySet rowKeySet =  gratuityLOV.getSelectedRowKeys();
                if (!rowKeySet.iterator().hasNext()) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                }

                Object key2 = rowKeySet.iterator().next();
                gratuityLOV.setRowKey(key2);

                JUCtrlValueBinding r = (JUCtrlValueBinding) gratuityLOV.getRowData();

                if (r == null) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                } 
            session.setAttribute("GRAP_CODE",r.getAttribute("grapCode"));
            serviceYears.setValue(r.getAttribute("grapServiceYrs"));
            pensionPct.setValue(r.getAttribute("grapPensionPct"));
            gratuityPct.setValue(r.getAttribute("grapGratPct"));
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:GratuityPopup" +
        "').show(hints);");
        return null;
    }

    public String DeleteGratuityRates() {
        RowKeySet rowKeySet =  gratuityLOV.getSelectedRowKeys();
                if (!rowKeySet.iterator().hasNext()) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                }

                Object key2 = rowKeySet.iterator().next();
                gratuityLOV.setRowKey(key2);

                JUCtrlValueBinding r = (JUCtrlValueBinding) gratuityLOV.getRowData();

                if (r == null) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                } 
            session.setAttribute("GRAP_CODE",r.getAttribute("grapCode"));
            String authQuery="BEGIN LMS_SETUPS_PKG.deleteGratuity(?);END;";
            Connection conn=new DBConnector().getDatabaseConn();
            try
            {
            CallableStatement cstmt=conn.prepareCall(authQuery);    
            cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("GRAP_CODE"));
            cstmt.execute();
            conn.close();
                String Message = "Gratuity Rates deleted successfully.";
                FacesContext.getCurrentInstance().addMessage(null, 
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                              Message, 
                                                                              Message));
                
               
                session.setAttribute("GRAP_CODE",null);
            ADFUtils.findIterator("findGratuityPensionratesIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(gratuityLOV); 
            }
            catch(Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
            } 
            return null;
    }

    public void setServiceYears(RichInputText serviceYears) {
        this.serviceYears = serviceYears;
    }

    public RichInputText getServiceYears() {
        return serviceYears;
    }

    public void setPensionPct(RichInputText pensionPct) {
        this.pensionPct = pensionPct;
    }

    public RichInputText getPensionPct() {
        return pensionPct;
    }

    public void setGratuityPct(RichInputText gratuityPct) {
        this.gratuityPct = gratuityPct;
    }

    public RichInputText getGratuityPct() {
        return gratuityPct;
    }

    public String SaveGratuityPct() {
        if(serviceYears.getValue()==null) {
            String Message = "Enter Service Years.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            return null;
        }
        if(pensionPct.getValue()==null) {
           String Message = "Enter Pension Percentage.";
           FacesContext.getCurrentInstance().addMessage(null, 
                                                        new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                         Message, 
                                                                         Message));
           return null;
        }
        if(gratuityPct.getValue()==null) {
           String Message = "Enter Gratuity Percentage.";
           FacesContext.getCurrentInstance().addMessage(null, 
                                                        new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                         Message, 
                                                                         Message));
           return null;
        }
        String updateQuery="BEGIN LMS_SETUPS_PKG.updateGratuityRates(?,?,?,?,?);END;";
        Connection conn=null;
        try
        {
           conn=new DBConnector().getDatabaseConn();
        CallableStatement cstmt=conn.prepareCall(updateQuery);
        cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("GRAP_CODE"));
        cstmt.setString(2, serviceYears.getValue().toString());
        cstmt.setString(3, gratuityPct.getValue().toString());
        cstmt.setString(4, pensionPct.getValue().toString());
        cstmt.setBigDecimal(5, (BigDecimal)session.getAttribute("ProductCode"));
        cstmt.execute();
        conn.close();
        
        String Message = "Gratuity Percentage saved successfully.";
        FacesContext.getCurrentInstance().addMessage(null,
                                                    new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                     Message, 
                                                                     Message));
        
            session.setAttribute("GRAP_CODE",null);
            ADFUtils.findIterator("findGratuityPensionratesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(gratuityLOV); 
        }
        catch(Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
        }
        return null;
    }

    public void setProductTransactionsTree(RichTree productTransactionsTree) {
        this.productTransactionsTree = productTransactionsTree;
    }

    public RichTree getProductTransactionsTree() {
        return productTransactionsTree;
    }

    public void ProductTransactionSelected(SelectionEvent selectionEvent) {
        if (selectionEvent.getAddedSet() != selectionEvent.getRemovedSet()) {
            RowKeySet rowKeySet = productTransactionsTree.getSelectedRowKeys();
            Object key2 = rowKeySet.iterator().next();
           productTransactionsTree.setRowKey(key2);
            JUCtrlValueBinding nodeBinding =
                (JUCtrlValueBinding)productTransactionsTree.getRowData();
                session.setAttribute("ProductCode",
                                     nodeBinding.getAttribute("PROD_CODE"));
                System.out.println(session.getAttribute("ProductCode"));
            session.setAttribute("ProdShtDesc",
                                 nodeBinding.getAttribute("PROD_SHT_DESC"));
            ADFUtils.findIterator("findProductTransactionsIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(productTransactionsLOV);
            /*try
            {
                ADFUtils.findIterator("findPensionContributionFactorsIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(retirementAgesLOV);
            }
            catch(Exception ex) {
                ex.printStackTrace();
            }*/
          
        }
    }

    public void setProductTransactionsLOV(RichTable productTransactionsLOV) {
        this.productTransactionsLOV = productTransactionsLOV;
    }

    public RichTable getProductTransactionsLOV() {
        return productTransactionsLOV;
    }

    public String AddProductTransactions() {
        prodTrnID.setValue(null);
        transactionDisplay.setValue(null);
        contraAccNumber.setValue(null);
        glAccountCode.setValue(null);
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:prodTransactionsPopup" +
        "').show(hints);");
        return null;
    }

    public String EditProductTransactions() {
        
      try{
          DCIteratorBinding dciter = ADFUtils.findIterator("findProductTransactionsIterator");
          RowKeySet set = productTransactionsLOV.getSelectedRowKeys();
          Iterator rowKeySetIter = set.iterator();
          
          //System.out.println(1);
          while (rowKeySetIter.hasNext()) 
          {
              List l = (List) rowKeySetIter.next();
              Key key = (Key)l.get(0);
              dciter.setCurrentRowWithKey(key.toStringFormat(true));
              Row r = dciter.getCurrentRow();

              
         prodTrnID.setValue(r.getAttribute("trapTrntCode"));
         transactionDisplay.setValue(r.getAttribute("trntDesc"));
         session.setAttribute("trntCode",r.getAttribute("trapTrntCode"));
         contraAccNumber.setValue(r.getAttribute("trapContraAcc"));
         glAccountCode.setValue(r.getAttribute("trapAccno"));
          
         ExtendedRenderKitService erkService =
         Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
         ExtendedRenderKitService.class);
         erkService.addScript(FacesContext.getCurrentInstance(),
         "var hints = {autodismissNever:false}; " +
         "AdfPage.PAGE.findComponent('" + "lmsgroup:prodTransactionsPopup" +
         "').show(hints);");
           

       }     
          
          
      }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
      }
     return null;
    }

    public String DeleteProductTransactions() {
        RowKeySet rowKeySet =  productTransactionsLOV.getSelectedRowKeys();
                if (!rowKeySet.iterator().hasNext()) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                }

                Object key2 = rowKeySet.iterator().next();
                productTransactionsLOV.setRowKey(key2);

                JUCtrlValueBinding r = (JUCtrlValueBinding) productTransactionsLOV.getRowData();

                if (r == null) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                } 
        String authQuery="BEGIN LMS_SETUPS_PKG.delete_prodtranstypes(?,?);END;";
        Connection conn=new DBConnector().getDatabaseConn();
        try
        {
        CallableStatement cstmt=conn.prepareCall(authQuery);  
        cstmt.setString(1,(String)r.getAttribute("trapTrntCode"));
        cstmt.setBigDecimal(2, (BigDecimal)session.getAttribute("ProductCode"));
        cstmt.execute();
        conn.close();
            String Message = "Product Transaction  deleted successfully.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));


            ADFUtils.findIterator("findProductTransactionsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(productTransactionsLOV); 
        }
        catch(Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
        } 
        return null;
    }

    public void setProdTrnID(RichInputText prodTrnID) {
        this.prodTrnID = prodTrnID;
    }

    public RichInputText getProdTrnID() {
        return prodTrnID;
    }

    public void setTransactionDisplay(RichInputText transactionDisplay) {
        this.transactionDisplay = transactionDisplay;
    }

    public RichInputText getTransactionDisplay() {
        return transactionDisplay;
    }

    public String AssignTransactionType() {
        RowKeySet rowKeySet =  transactionsLOV.getSelectedRowKeys();
                if (!rowKeySet.iterator().hasNext()) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                }

                Object key2 = rowKeySet.iterator().next();
                transactionsLOV.setRowKey(key2);

                JUCtrlValueBinding r = (JUCtrlValueBinding)transactionsLOV.getRowData();

                if (r == null) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                } 
        prodTrnID.setValue(r.getAttribute("trntCode"));
        transactionDisplay.setValue(r.getAttribute("transactionDesc"));
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:prodTransactionsPopup" +
        "').show(hints);");
        return null;
    }

    public void setTransactionsLOV(RichTable transactionsLOV) {
        this.transactionsLOV = transactionsLOV;
    }

    public RichTable getTransactionsLOV() {
        return transactionsLOV;
    }

    public String ShowTransactionsPopup() {
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:transactionsPopup" +
        "').show(hints);");
        return null;
    }

    public String ShowGlAccountCodes() {
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:glAccountsPopup" +
        "').show(hints);");
        return null;
    }

    public void setGlAccountCode(RichInputText glAccountCode) {
        this.glAccountCode = glAccountCode;
    }

    public RichInputText getGlAccountCode() {
        return glAccountCode;
    }

    public void setGlAccountsLOV(RichTable glAccountsLOV) {
        this.glAccountsLOV = glAccountsLOV;
    }

    public RichTable getGlAccountsLOV() {
        return glAccountsLOV;
    }

    public String AssignGlCode() {
        RowKeySet rowKeySet =  glAccountsLOV.getSelectedRowKeys();
                if (!rowKeySet.iterator().hasNext()) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                }

                Object key2 = rowKeySet.iterator().next();
               glAccountsLOV.setRowKey(key2);

                JUCtrlValueBinding r = (JUCtrlValueBinding) glAccountsLOV.getRowData();

                if (r == null) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                } 
        glAccountCode.setValue(r.getAttribute("accNumber"));
        
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:prodTransactionsPopup" +
        "').show(hints);");
        return null;
    }

    public void setContraAccNumber(RichInputText contraAccNumber) {
        this.contraAccNumber = contraAccNumber;
    }

    public RichInputText getContraAccNumber() {
        return contraAccNumber;
    }

    public String ShowContraGLCodes() {
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:contraGLPopup" +
        "').show(hints);");
        return null;
    }

    public void setContraGlLov(RichTable contraGlLov) {
        this.contraGlLov = contraGlLov;
    }

    public RichTable getContraGlLov() {
        return contraGlLov;
    }

    public String AssignContraAccounts() {
        RowKeySet rowKeySet =  contraGlLov.getSelectedRowKeys();
                if (!rowKeySet.iterator().hasNext()) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                }

                Object key2 = rowKeySet.iterator().next();
              contraGlLov.setRowKey(key2);

                JUCtrlValueBinding r = (JUCtrlValueBinding) contraGlLov.getRowData();

                if (r == null) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                } 
        contraAccNumber.setValue(r.getAttribute("accNumber"));
        
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:prodTransactionsPopup" +
        "').show(hints);");
        return null;
    }

    public String SaveProductTransactionType() {
        String updateQuery="BEGIN LMS_SETUPS_PKG.update_prodtranstypes(?,?,?,?);END;";
        Connection conn=null;
        try
        {
           conn=new DBConnector().getDatabaseConn();
        CallableStatement cstmt=conn.prepareCall(updateQuery);
        cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("ProductCode"));
            if(glAccountCode.getValue()==null){
                cstmt.setString(2,null); 
            }else{
                cstmt.setString(2, glAccountCode.getValue().toString());
            }
            if(contraAccNumber.getValue()==null){
                cstmt.setString(3,null); 
            }else{
                cstmt.setString(3, contraAccNumber.getValue().toString());
            }
            if(prodTrnID.getValue()==null){
                cstmt.setString(4,null); 
            }else{
                cstmt.setString(4, prodTrnID.getValue().toString());
            }
             
        cstmt.execute();
        conn.close();
        
        String Message = "Product Transaction Account Saved Successfully.";
        FacesContext.getCurrentInstance().addMessage(null,
                                                    new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                     Message, 
                                                                     Message));

            ADFUtils.findIterator("findProductTransactionsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(productTransactionsLOV); 
        }
        catch(Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
        }
        return null;
    }

    public String PopulateRevenutItems() {
        String updateQuery="BEGIN LMS_SETUPS_PKG.populate_revenueitems(?,?);END;";
        Connection conn=null;
        try
        {
           conn=new DBConnector().getDatabaseConn();
        CallableStatement cstmt=conn.prepareCall(updateQuery);
        cstmt.setBigDecimal(1, null);
        cstmt.setBigDecimal(2, (BigDecimal)session.getAttribute("ProductCode"));
        
             
        cstmt.execute();
        conn.close();
        
        String Message = "Product Transaction Accounts Saved Successfully.";
        FacesContext.getCurrentInstance().addMessage(null,
                                                    new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                     Message, 
                                                                     Message));

            ADFUtils.findIterator("findProductTransactionsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(productTransactionsLOV); 
        }
        catch(Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
        }
        return null;
    }

    public void prodTransListener(SelectionEvent selectionEvent) {
        RowKeySet rowKeySet =  productTransactionsLOV.getSelectedRowKeys();
                if (!rowKeySet.iterator().hasNext()) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                }

                Object key2 = rowKeySet.iterator().next();
                productTransactionsLOV.setRowKey(key2);

                JUCtrlValueBinding r = (JUCtrlValueBinding) productTransactionsLOV.getRowData();

                if (r == null) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                } 
        session.setAttribute("trntCode",r.getAttribute("trapTrntCode"));
        ADFUtils.findIterator("findOtherProductsGLCodesIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(otherProdsTransLOV); 
    }

    public void setOtherProdsTransLOV(RichTable otherProdsTransLOV) {
        this.otherProdsTransLOV = otherProdsTransLOV;
    }

    public RichTable getOtherProdsTransLOV() {
        return otherProdsTransLOV;
    }

    public void setMemDateTo(RichInputDate memDateTo) {
        this.memDateTo = memDateTo;
    }

    public RichInputDate getMemDateTo() {
        return memDateTo;
    }

    public void setContactName(RichInputText contactName) {
        this.contactName = contactName;
    }

    public RichInputText getContactName() {
        return contactName;
    }

    public void setContactSex(RichSelectOneChoice contactSex) {
        this.contactSex = contactSex;
    }

    public RichSelectOneChoice getContactSex() {
        return contactSex;
    }

    public void setContactTelephone(RichInputText contactTelephone) {
        this.contactTelephone = contactTelephone;
    }

    public RichInputText getContactTelephone() {
        return contactTelephone;
    }

    public void setContactAddress(RichInputText contactAddress) {
        this.contactAddress = contactAddress;
    }

    public RichInputText getContactAddress() {
        return contactAddress;
    }

    public void setContactEmail(RichInputText contactEmail) {
        this.contactEmail = contactEmail;
    }

    public RichInputText getContactEmail() {
        return contactEmail;
    }

    public void setPensPoliciesLOV(RichTable pensPoliciesLOV) {
        this.pensPoliciesLOV = pensPoliciesLOV;
    }

    public RichTable getPensPoliciesLOV() {
        return pensPoliciesLOV;
    }

    public void setTableDescription(RichInputText tableDescription) {
        this.tableDescription = tableDescription;
    }

    public RichInputText getTableDescription() {
        return tableDescription;
    }

    public void setPensPoliciesDesc(RichInputText pensPoliciesDesc) {
        this.pensPoliciesDesc = pensPoliciesDesc;
    }

    public RichInputText getPensPoliciesDesc() {
        return pensPoliciesDesc;
    }

    public void setRatesTables(RichTable ratesTables) {
        this.ratesTables = ratesTables;
    }

    public RichTable getRatesTables() {
        return ratesTables;
    }

    public void setTableRates(RichTable tableRates) {
        this.tableRates = tableRates;
    }

    public RichTable getTableRates() {
        return tableRates;
    }

    public void setSearchAgent(RichInputText searchAgent) {
        this.searchAgent = searchAgent;
    }

    public RichInputText getSearchAgent() {
        return searchAgent;
    }

    public void setTermFrom(RichInputText termFrom) {
        this.termFrom = termFrom;
    }

    public RichInputText getTermFrom() {
        return termFrom;
    }

    public void setTermTo(RichInputText termTo) {
        this.termTo = termTo;
    }

    public RichInputText getTermTo() {
        return termTo;
    }

    public void setBenefitDiscount(RichInputText benefitDiscount) {
        this.benefitDiscount = benefitDiscount;
    }

    public RichInputText getBenefitDiscount() {
        return benefitDiscount;
    }

    public void setContriFactor(RichInputText contriFactor) {
        this.contriFactor = contriFactor;
    }

    public RichInputText getContriFactor() {
        return contriFactor;
    }

    public void setPensionCostingRates(RichTable pensionCostingRates) {
        this.pensionCostingRates = pensionCostingRates;
    }

    public RichTable getPensionCostingRates() {
        return pensionCostingRates;
    }

    public void costingFactorsListener(SelectionEvent selectionEvent) {
        // Add event code here...
        RowKeySet rowKeySet = pensionCostingFactorsLOV.getSelectedRowKeys();
        if (!rowKeySet.iterator().hasNext()) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    return;
        }

        Object key2 = rowKeySet.iterator().next();
         pensionCostingFactorsLOV.setRowKey(key2);

          JUCtrlValueBinding r = (JUCtrlValueBinding)pensionCostingFactorsLOV.getRowData();

          if (r == null) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
            return;
          } 
          session.setAttribute("PCFS_CODE",r.getAttribute("pcfsCode"));
          
         ADFUtils.findIterator("findPensionCostingFactorRatesIterator").executeQuery();
         AdfFacesContext.getCurrentInstance().addPartialTarget(pensionCostingRates); 
    }

    public void setTablesDefault(RichSelectOneChoice tablesDefault) {
        this.tablesDefault = tablesDefault;
    }

    public RichSelectOneChoice getTablesDefault() {
        return tablesDefault;
    }

    public void setYearFrom(RichInputText yearFrom) {
        this.yearFrom = yearFrom;
    }

    public RichInputText getYearFrom() {
        return yearFrom;
    }

    public void setYearTo(RichInputText yearTo) {
        this.yearTo = yearTo;
    }

    public RichInputText getYearTo() {
        return yearTo;
    }

    public void setEmyrEnt(RichInputText emyrEnt) {
        this.emyrEnt = emyrEnt;
    }

    public RichInputText getEmyrEnt() {
        return emyrEnt;
    }

    public void setEmyeEnt(RichInputText emyeEnt) {
        this.emyeEnt = emyeEnt;
    }

    public RichInputText getEmyeEnt() {
        return emyeEnt;
    }

    public void setVestingTable(RichTable vestingTable) {
        this.vestingTable = vestingTable;
    }

    public RichTable getVestingTable() {
        return vestingTable;
    }

    public void setAnnuityTypeGender(RichSelectOneChoice annuityTypeGender) {
        this.annuityTypeGender = annuityTypeGender;
    }

    public RichSelectOneChoice getAnnuityTypeGender() {
        return annuityTypeGender;
    }

    public void setDefaultVal(RichSelectOneChoice defaultVal) {
        this.defaultVal = defaultVal;
    }

    public RichSelectOneChoice getDefaultVal() {
        return defaultVal;
    }

    public void setMinSumAssured(RichInputText minSumAssured) {
        this.minSumAssured = minSumAssured;
    }

    public RichInputText getMinSumAssured() {
        return minSumAssured;
    }

    public void actionConfirmDelete(DialogEvent dialogEvent) {
      String confirmDelete = (String)session.getAttribute("confirmDelete");
      if (dialogEvent.getOutcome().equals(DialogEvent.Outcome.no)) {
          return;
      } else if (dialogEvent.getOutcome().equals(DialogEvent.Outcome.yes)) {
       
      if(confirmDelete.compareTo("CPD")==0){
      DeleteContactPerson();
      }  else if (confirmDelete.compareTo("PCFactor")==0){
        DeletePensionCostingFactors();
      }
      else if(confirmDelete.compareTo("PCFactorRates")==0){
        DeletePensionCostingFactorRates();
      }
      else if(confirmDelete.compareTo("PContrFactors")==0){
        DeletePensionContrFactors();
      }
      else if (confirmDelete.compareTo("RetireAges")==0){
        DeleteRetirementAges();
      }   else if (confirmDelete.compareTo("EmvErRates")==0){
        DeleteEmvErRates();
      } else if(confirmDelete.compareTo("EmvEeRates")==0){
        DeleteEmvEeRates();
      }else if (confirmDelete.compareTo("PensionScale")==0){
        DeletePensionScale();
      }else if(confirmDelete.compareTo("GratuityRates")==0){
        DeleteGratuityRates();
      }
      GlobalCC.hidePopup("lmsgroup:confirmDelete");
      }
    }

   //perform contact person delete
    public String performContactPersonDelete() {
      GlobalCC.showPopup("lmsgroup:confirmDelete");
      session.setAttribute("confirmDelete","CPD");
        return null;
    }
 //perform pension costing factors delete
    public String performPensionCostingFactorsDelete() {
      System.out.println("testing");
      GlobalCC.showPopup("lmsgroup:confirmDelete");
      session.setAttribute("confirmDelete","PCFactor");
        return null;
    }
//perform Pension costing factors rates delete
    public String performPensionCostingFactorRatesDelete() {
      GlobalCC.showPopup("lmsgroup:confirmDelete");
      session.setAttribute("confirmDelete","PCFactorRates");
        return null;
    }
//perform pension contributing factor delete
    public String performPensionContrFactorsDelete() {
      GlobalCC.showPopup("lmsgroup:confirmDelete");
      session.setAttribute("confirmDelete","PContrFactors");
        return null;
    }

   //perform retirement ages delete
    public String performRetirementAgesDelete() {
      GlobalCC.showPopup("lmsgroup:confirmDelete");
      session.setAttribute("confirmDelete","RetireAges");
        return null;
    }

    public String performDeleteEmvErRates() {
      GlobalCC.showPopup("lmsgroup:confirmDelete");
      session.setAttribute("confirmDelete","EmvErRates");
        return null;
    }

    public String performDeleteEmvEeRates() {
      GlobalCC.showPopup("lmsgroup:confirmDelete");
      session.setAttribute("confirmDelete","EmvEeRates");
        return null;
    }

    public String performDeletePensionScale() {
        GlobalCC.showPopup("lmsgroup:confirmDelete");
        session.setAttribute("confirmDelete","PensionScale");
        return null;
    }

    public String performDeleteGratuityRates() {
      GlobalCC.showPopup("lmsgroup:confirmDelete");
      session.setAttribute("confirmDelete","GratuityRates");
        return null;
    }

    public void setEmpyr_lump_exempt(RichInputText empyr_lump_exempt) {
        this.empyr_lump_exempt = empyr_lump_exempt;
    }

    public RichInputText getEmpyr_lump_exempt() {
        return empyr_lump_exempt;
    }

    public String DeleteAgent() {
        String updateQuery="BEGIN LMS_SETUPS_PKG.DeleteAgent(?);END;";
        Connection conn=new DBConnector().getDatabaseConn();
        try
        {
            CallableStatement cstmt=conn.prepareCall(updateQuery);
            cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("AGN_CODE"));
            cstmt.execute();
            conn.close();
            System.out.println("The agn code " + session.getAttribute("AGN_CODE"));
            agentID.setValue(null);
            agentName.setValue(null);
            agnIdentityNo.setValue(null);
            agnPhoneNo.setValue(null);
            pinNUmber.setValue(null);
            financingType.setValue(null);
            contractStatus.setValue(null);
            profCertNo.setValue(null);
            contractDate.setValue(null);
            agnDateJoined.setValue(null);
            agnBank.setValue(null);
            agnBankAccNo.setValue(null);
            agnSmsNo.setValue(null);
            referenceNo.setValue(null);
            agnPostLevel.setValue(null);
            agnEmailAddress.setValue(null);
            agnReinsurer.setValue(null);
            agnGLAccountNo.setValue(null);
            agnCreditAllowed.setValue(null);
            agnWthTax.setValue(null);
            
            agnStatus.setValue(null);
            agnRegNumber.setValue(null);
            commissionPayroll.setValue(null);
            commPaymentMethod.setValue(null);
            commissionRates.setValue(null);
            agentsBranch.setValue(null);
        } catch (Exception e){
           GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        
      ADFUtils.findIterator("findAgenciesIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(agentsTree);
      AdfFacesContext.getCurrentInstance().addPartialTarget(agentsPanGrp);  
      GlobalCC.sysInformation("Agent Deleted Succesfully!");
        return null;
    }
    
    public String saveCommutation() {
            String saveQuery =
                "BEGIN LMS_SETUPS_PKG.addEditCommutation(?,?,?,?,?);END;";
            Connection conn = null;
            try {
                conn = new DBConnector().getDatabaseConn();
                CallableStatement cstmt = conn.prepareCall(saveQuery);

                cstmt.setBigDecimal(1,
                                    (BigDecimal)session.getAttribute("pcomCode"));
                cstmt.setBigDecimal(2,
                                    (BigDecimal)session.getAttribute("ProductCode"));
                if (commRangeFrom.getValue() == null) {
                    cstmt.setString(3, null);
                } else {
                    cstmt.setString(3, (String)commRangeFrom.getValue());
                }
                if (commRangeTo.getValue() == null) {
                    cstmt.setString(4, null);
                } else {
                    cstmt.setString(4, (String)commRangeTo.getValue());
                }
                if (commutationRate.getValue() == null) {
                    cstmt.setString(5, null);
                } else {
                    cstmt.setString(5, (String)commutationRate.getValue());
                }

                cstmt.execute();
                cstmt.close();
                String Message = "Commutation saved sucessfully";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));
                ADFUtils.findIterator("findPensionCommutationFactorsIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(commutationLOV);
            } catch (Exception ex) {
                GlobalCC.EXCEPTIONREPORTING(conn, ex);
                ex.printStackTrace();
            }
            return null;
        }

        public String showCommutationPop() {
            // Add event code here...
            session.setAttribute("pcomCode", null);
            commRangeFrom.setValue(null);
            commRangeTo.setValue(null);
            commutationRate.setValue(null);
            GlobalCC.showPopup("lmsgroup:p1");
            return null;
        }

        public String editCommutation() {
            // Add event code here...
            Object key2 = commutationLOV.getSelectedRowData();
            if (key2 == null) {
                GlobalCC.errorValueNotEntered("No Record Selected");
                return null;
            }
            JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
            if (r == null) {
                GlobalCC.errorValueNotEntered("No Record Selected");
                return null;
            }
            session.setAttribute("pcomCode", r.getAttribute("PCOM_CODE"));
            commRangeFrom.setValue(r.getAttribute("PCOM_RANGE_FROM"));
            commRangeTo.setValue(r.getAttribute("PCOM_RANGE_TO"));
            commutationRate.setValue(r.getAttribute("PCOM_PERC"));
            GlobalCC.showPopup("lmsgroup:p1");

            return null;
        }

        public String deleteCommutation() {
            // Add event code here...
            Connection conn = null;
            CallableStatement cst = null;
            DBConnector connecter = new DBConnector();
            String query = "begin LMS_SETUPS_PKG.deleteCommutation(?); end;";
            try {
                conn = connecter.getDatabaseConn();
                Object key2 = commutationLOV.getSelectedRowData();
                if (key2 == null) {
                    GlobalCC.errorValueNotEntered("No Record Selected");
                    return null;
                }
                JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
                if (r == null) {
                    GlobalCC.errorValueNotEntered("No Record Selected");
                    return null;
                }
                cst = conn.prepareCall(query);
                cst.setBigDecimal(1, (BigDecimal)r.getAttribute("PCOM_CODE"));
                cst.execute();
                cst.close();
                conn.close();
                ADFUtils.findIterator("findPensionCommutationFactorsIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(commutationLOV);
            } catch (Exception e) {
                GlobalCC.EXCEPTIONREPORTING(conn, e);
                e.printStackTrace();
            }
            return null;
        }

    public void setCommRangeFrom(RichInputText commRangeFrom) {
        this.commRangeFrom = commRangeFrom;
    }

    public RichInputText getCommRangeFrom() {
        return commRangeFrom;
    }
    
    public void setCommRangeTo(RichInputText commRangeTo) {
        this.commRangeTo = commRangeTo;
    }

    public RichInputText getCommRangeTo() {
        return commRangeTo;
    }

    public void setCommutationRate(RichInputText commutationRate) {
        this.commutationRate = commutationRate;
    }

    public RichInputText getCommutationRate() {
        return commutationRate;
    }

    public void setCommutationLOV(RichTable commutationLOV) {
        this.commutationLOV = commutationLOV;
    }

    public RichTable getCommutationLOV() {
        return commutationLOV;
    }

    public void setPostalAddress(RichInputText postalAddress) {
        this.postalAddress = postalAddress;
    }

    public RichInputText getPostalAddress() {
        return postalAddress;
    }

    public void setWhtRetained(RichSelectOneChoice whtRetained) {
        this.whtRetained = whtRetained;
    }

    public RichSelectOneChoice getWhtRetained() {
        return whtRetained;
    }
}
