package com.turnkey.setups;

import LMSG.view.Base.ADFUtils;
import LMSG.view.Base.GlobalCC;

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
import oracle.adf.view.rich.component.rich.input.RichInputNumberSpinbox;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.adf.view.rich.event.DialogEvent;

import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.uicli.binding.JUCtrlValueBinding;

import org.apache.myfaces.trinidad.event.SelectionEvent;
import org.apache.myfaces.trinidad.model.RowKeySet;

import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;


import LMSG.view.connect.DBConnector;

public class causationsManipulation {
    private RichInputText causationID;
    private RichInputText causeDesc;
    private RichSelectOneChoice causationType;
    private RichSelectOneChoice withEmpyrFund;
    private RichInputText clmNoPrefix;
    private RichTable causationsLOV;
    private RichInputText deathID;
    private RichInputText deathDesc;
    private RichSelectOneChoice causationClass;
    private RichInputText waitingPeriod;
    private RichTable deathDisabilityLOV;
    private RichTable causationsCauseLOV;
    private RichTable causationsCausesLOV;
    private RichInputText causID;
    private RichTable addCausationsLOV;
    private RichSelectOneChoice causationGender;
    private RichInputText minClaimablePeriod;
    private RichInputText causDescription;
    private RichTable nonMedicalsClaimsLOV;
    private RichInputText yearFrom;
    private RichInputText yearTo;
    private RichInputText nmsRate;
    private RichSelectOneChoice nmsDivFact;
    private RichInputText nmsMaximumAmt;
    private RichInputDate nmsWEF;
    private RichInputDate nmsWet;
    private RichTree productsTree;
    private RichTable prodCoverTypesLOV;
    private RichTable coverTypeCausationsLOV;
    private RichInputText cvtcCausShtDesc;
    private RichTable cvCausationsLOV;
    private RichInputText cvtcCausDesc;
    private RichTable policyDocumentsLOV;
    private RichSelectOneChoice uwDocument;
    private RichSelectOneChoice deathClaimDocs;
    private RichSelectOneChoice disabilityClaimDocs;
    private RichSelectOneChoice withClaimDocs;
    private RichInputText rdShtDesc;
    private RichInputText rdDesc;
    private RichSelectOneChoice productLevel;
    private RichTable productDocumentsLOV;
    private RichInputText productDisp;
    private RichTable productsLOV;
    private RichOutputText transactionSelected;
    private RichTree transactionsTree;
    private RichTable narrativesLOV;
    private RichInputText drNarrative;
    private RichInputText crNarrative;
    private RichTable ratesDescLOV;
    private RichInputText ratesID;
    private RichInputText ratesDescription;
    private RichInputText anbFrom;
    private RichInputText anbTo;
    private RichInputText rate;
    private RichInputText divisionFactor;
    private RichSelectOneChoice rateType;
    private RichInputDate riWEf;
    private RichInputDate riWet;
    private RichTable ordReinRatesLOV;
    private RichTable disCausationsLOV;
    private RichInputText lossDescription;
    private RichInputText percentPayable;
    private RichSelectOneChoice closesPolicy;
    private RichTable disabilityLossesLOV;
    private RichSelectOneChoice weeklyIndemnity;
    private RichSelectOneChoice ldlDivisionFactor;
    private RichTable periodsLOV;
    private RichInputText periodName;
    private RichSelectOneChoice valFrequency;
    private RichInputDate periodWef;
    private RichInputDate periodWet;
    private RichInputText perID;
    private RichTable businessTransLOV;
    private RichInputText clauseEditor;
    private RichInputText drCoinNarrative;
    private RichInputText crCoinNarrative;
    private RichSelectOneChoice withEmpyeFund;
    private RichInputText ageFrom;
    private RichInputText ageTo;
    private RichSelectOneChoice maturityDocs;
    private RichInputText coinsurance_apportionment;
    private RichInputNumberSpinbox minClaimableDays;
    private RichInputNumberSpinbox maxClaimableDays;

    public causationsManipulation() {
        super();
    }
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    public void setCausationID(RichInputText causationID) {
        this.causationID = causationID;
    }

    public RichInputText getCausationID() {
        return causationID;
    }

    public void setCauseDesc(RichInputText causeDesc) {
        this.causeDesc = causeDesc;
    }

    public RichInputText getCauseDesc() {
        return causeDesc;
    }

    public void setCausationType(RichSelectOneChoice causationType) {
        this.causationType = causationType;
    }

    public RichSelectOneChoice getCausationType() {
        return causationType;
    }

    public void setWithEmpyrFund(RichSelectOneChoice withEmpyrFund) {
        this.withEmpyrFund = withEmpyrFund;
    }

    public RichSelectOneChoice getWithEmpyrFund() {
        return withEmpyrFund;
    }

    public void setClmNoPrefix(RichInputText clmNoPrefix) {
        this.clmNoPrefix = clmNoPrefix;
    }

    public RichInputText getClmNoPrefix() {
        return clmNoPrefix;
    }

    public String SaveCausation() {
        String updateQuery="BEGIN LMS_SETUPS_PKG.update_causations(?,?,?,?,?,?,?,?,?);END;";
        Connection conn=null;
        try
        {
           conn=new DBConnector().getDatabaseConn();
        CallableStatement cstmt=conn.prepareCall(updateQuery);
        cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("CAUS_CODE"));
        cstmt.setString(2, causationID.getValue().toString());
        cstmt.setString(3, causeDesc.getValue().toString());
        cstmt.setString(4, causationType.getValue().toString());
        cstmt.setString(5, withEmpyrFund.getValue().toString());
        if(clmNoPrefix.getValue()==null){
          cstmt.setString(6, null);   
        }else{
          cstmt.setString(6, clmNoPrefix.getValue().toString());   
        }
        if(withEmpyeFund.getValue()==null){
          cstmt.setString(7, null);   
        }else{
          cstmt.setString(7, withEmpyeFund.getValue().toString());   
        }
        if(ageFrom.getValue()==null){
          cstmt.setString(8, null);   
        }else{
          cstmt.setString(8, ageFrom.getValue().toString());   
        }
        if(ageTo.getValue()==null){
          cstmt.setString(9, null);   
        }else{
          cstmt.setString(9, ageTo.getValue().toString());   
        }
          
        cstmt.execute();
        conn.close();
        
        String Message = "Causation saved Successfully.";
        FacesContext.getCurrentInstance().addMessage(null,
                                                    new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                     Message, 
                                                                     Message));
            session.setAttribute("CAUS_CODE",null);
            ADFUtils.findIterator("findCausationsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(causationsLOV);
            GlobalCC.hidePopup("lmsgroup:causationsPopup");
        }
        catch(Exception ex) {
           GlobalCC.EXCEPTIONREPORTING(conn,ex);
        }
       
        return null;
    }

    public void setCausationsLOV(RichTable causationsLOV) {
        this.causationsLOV = causationsLOV;
    }

    public RichTable getCausationsLOV() {
        return causationsLOV;
    }

    public String addCausation() {
        session.setAttribute("CAUS_CODE",null);
        causationID.setValue(null);
        causeDesc.setValue(null);
        causationType.setValue(null);
        withEmpyrFund.setValue(null);
        clmNoPrefix.setValue(null);
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:causationsPopup" +
        "').show(hints);");
        return null;
    }

    public String editCausation() {
        try{
        RowKeySet rowKeySet =  causationsLOV.getSelectedRowKeys();
                if (!rowKeySet.iterator().hasNext()) {
                    GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                }

                Object key2 = rowKeySet.iterator().next();
              causationsLOV.setRowKey(key2);

                JUCtrlValueBinding r = (JUCtrlValueBinding) causationsLOV.getRowData();

                if (r == null) {
                    GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                } 
        session.setAttribute("CAUS_CODE",r.getAttribute("causCode"));
        causationID.setValue(r.getAttribute("causShtdesc"));
        causeDesc.setValue(r.getAttribute("causDesc"));
        causationType.setValue(r.getAttribute("causType"));
        withEmpyrFund.setValue(r.getAttribute("causWthld_emplr_fnd"));
        clmNoPrefix.setValue(r.getAttribute("causClm_prefix"));
        withEmpyeFund.setValue(r.getAttribute("caus_wthld_emple_fnd"));
        ageFrom.setValue(r.getAttribute("caus_age_from"));
        ageTo.setValue(r.getAttribute("caus_age_to"));   
        GlobalCC.showPopup("lmsgroup:causationsPopup");
        }catch(Exception ex){
            
          ex.printStackTrace();
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
        
    }else if(Value.equalsIgnoreCase("delCauseType")){
        //Delete Causation Type.
        Result = deleteCausation();
    }else if(Value.equalsIgnoreCase("delDeathCause")){
      //Delete Death/Disability Causation.
      Result = DeleteDeatchCausation();
    }else if(Value.equalsIgnoreCase("delCausaCause")){
      //Delete Causation Cause.
      Result = DeleteCausationCause();
    }else if(Value.equalsIgnoreCase("delNonMedClaim")){
      //Delete Non-Medical Claim.
      Result = DeleteNonMedicalClaim();
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

    public String deleteCausation() {
        String Result = "F";
        RowKeySet rowKeySet =  causationsLOV.getSelectedRowKeys();
                if (!rowKeySet.iterator().hasNext()) {
                    GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                }

                Object key2 = rowKeySet.iterator().next();
              causationsLOV.setRowKey(key2);

                JUCtrlValueBinding r = (JUCtrlValueBinding) causationsLOV.getRowData();

                if (r == null) {
                    GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                } 
        session.setAttribute("CAUS_CODE",r.getAttribute("causCode"));
        String authQuery="BEGIN LMS_SETUPS_PKG.delete_causations(?);END;";
        Connection conn=new DBConnector().getDatabaseConn();
        try
        {
        CallableStatement cstmt=conn.prepareCall(authQuery); 
        System.out.println((BigDecimal)session.getAttribute("CAUS_CODE"));
        cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("CAUS_CODE"));
        cstmt.execute();
        conn.close();
           
            
           
            
            session.setAttribute("CAUS_CODE",null);
            ADFUtils.findIterator("findCausationsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(causationsLOV);
           Result = "S";
        }
        catch(Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
        } 
        return Result;
    }

    public String AddDeathCausation() {
        deathID.setValue(null);
        deathDesc.setValue(null);
        causationClass.setValue(null);
        waitingPeriod.setValue(null);
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:deathDisCausesPopup" +
        "').show(hints);");
        return null;
    }

    public String EditCausation() {
        RowKeySet rowKeySet =  deathDisabilityLOV.getSelectedRowKeys();
                if (!rowKeySet.iterator().hasNext()) {
                    GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                }

                Object key2 = rowKeySet.iterator().next();
              deathDisabilityLOV.setRowKey(key2);

                JUCtrlValueBinding r = (JUCtrlValueBinding) deathDisabilityLOV.getRowData();

                if (r == null) {
                    GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                } 
        session.setAttribute("DDC_CODE",r.getAttribute("ddcCode"));
        deathID.setValue(r.getAttribute("ddcShtDesc"));
        deathDesc.setValue(r.getAttribute("ddcDesc"));
        causationClass.setValue(r.getAttribute("ddcHivDesc"));
        waitingPeriod.setValue(r.getAttribute("ddcWaitingPrd"));
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:deathDisCausesPopup" +
        "').show(hints);");
        return null;
    }

    public String DeleteDeatchCausation() {
        String Result = "F";
        RowKeySet rowKeySet =  deathDisabilityLOV.getSelectedRowKeys();
                if (!rowKeySet.iterator().hasNext()) {
                    GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                }

                Object key2 = rowKeySet.iterator().next();
              deathDisabilityLOV.setRowKey(key2);

                JUCtrlValueBinding r = (JUCtrlValueBinding) deathDisabilityLOV.getRowData();

                if (r == null) {
                    GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                } 
        session.setAttribute("DDC_CODE",r.getAttribute("ddcCode"));
        String authQuery="BEGIN LMS_SETUPS_PKG.delete_dth_dis_causes(?);END;";
        Connection conn=new DBConnector().getDatabaseConn();
        try
        {
        CallableStatement cstmt=conn.prepareCall(authQuery); 
       
        cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("DDC_CODE"));
        cstmt.execute();
        conn.close();
            String Message = "Death/Disability Cause deleted successfully.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            
           
            
            session.setAttribute("DDC_CODE",null);
            ADFUtils.findIterator("findDeathDisabilityCausesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(deathDisabilityLOV); 
            Result = "S";
        }
        catch(Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
        } 
        return Result;
    }

    public void setDeathID(RichInputText deathID) {
        this.deathID = deathID;
    }

    public RichInputText getDeathID() {
        return deathID;
    }

    public void setDeathDesc(RichInputText deathDesc) {
        this.deathDesc = deathDesc;
    }

    public RichInputText getDeathDesc() {
        return deathDesc;
    }

    public void setCausationClass(RichSelectOneChoice causationClass) {
        this.causationClass = causationClass;
    }

    public RichSelectOneChoice getCausationClass() {
        return causationClass;
    }

    public void setWaitingPeriod(RichInputText waitingPeriod) {
        this.waitingPeriod = waitingPeriod;
    }

    public RichInputText getWaitingPeriod() {
        return waitingPeriod;
    }

    public String SaveDeathDisability() {
        String updateQuery="BEGIN LMS_SETUPS_PKG.update_dth_dis_causes(?,?,?,?,?);END;";
        Connection conn=null;
        try
        {
           conn=new DBConnector().getDatabaseConn();
        CallableStatement cstmt=conn.prepareCall(updateQuery);
        cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("DDC_CODE"));
        if(deathID.getValue()==null){
          cstmt.setString(2, null);
        }else{
          cstmt.setString(2, deathID.getValue().toString());
        }
        if(deathDesc.getValue()==null){
          cstmt.setString(3, null);
        }else{
          cstmt.setString(3, deathDesc.getValue().toString());
        }
        if(causationClass.getValue()==null){
          cstmt.setString(4, null);
        }else{
          cstmt.setString(4, causationClass.getValue().toString());
        }
        if(waitingPeriod.getValue()==null){
          cstmt.setString(5, null);
        }else{
          cstmt.setString(5, waitingPeriod.getValue().toString());
        }
        
          
        cstmt.execute();
        conn.close();
        
        String Message = "Death/Disability saved Successfully.";
        FacesContext.getCurrentInstance().addMessage(null,
                                                    new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                     Message, 
                                                                     Message));
            session.setAttribute("DDC_CODE",null);
            ADFUtils.findIterator("findDeathDisabilityCausesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(deathDisabilityLOV);
            GlobalCC.hidePopup("lmsgroup:deathDisCausesPopup");
        }
        catch(Exception ex) {
           GlobalCC.EXCEPTIONREPORTING(conn,ex);
        }
        return null;
    }

    public void setDeathDisabilityLOV(RichTable deathDisabilityLOV) {
        this.deathDisabilityLOV = deathDisabilityLOV;
    }

    public RichTable getDeathDisabilityLOV() {
        return deathDisabilityLOV;
    }

    public void setCausationsCauseLOV(RichTable causationsCauseLOV) {
        this.causationsCauseLOV = causationsCauseLOV;
    }

    public RichTable getCausationsCauseLOV() {
        return causationsCauseLOV;
    }

    public void setCausationsCausesLOV(RichTable causationsCausesLOV) {
        this.causationsCausesLOV = causationsCausesLOV;
    }

    public RichTable getCausationsCausesLOV() {
        return causationsCausesLOV;
    }

    public void causationsListner(SelectionEvent selectionEvent) {
        RowKeySet rowKeySet =  causationsCauseLOV.getSelectedRowKeys();
                if (!rowKeySet.iterator().hasNext()) {
                    GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                }

                Object key2 = rowKeySet.iterator().next();
             causationsCauseLOV.setRowKey(key2);

                JUCtrlValueBinding r = (JUCtrlValueBinding)causationsCauseLOV.getRowData();

                if (r == null) {
                    GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                } 
        session.setAttribute("CAUS_CODE",r.getAttribute("causCode"));
        ADFUtils.findIterator("findCausationCausesIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(causationsCausesLOV);
    }

    public String AddCausationCause() {
        session.setAttribute("CSC_CODE",null);
        causID.setValue(null);
        causDescription.setValue(null);
        causationGender.setValue(null);
        minClaimablePeriod.setValue(null);
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:causationCausePopup" +
        "').show(hints);");
        return null;
    }

    public String EditCausationCause() {
        RowKeySet rowKeySet =  causationsCausesLOV.getSelectedRowKeys();
                if (!rowKeySet.iterator().hasNext()) {
                    GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                }

                Object key2 = rowKeySet.iterator().next();
             causationsCausesLOV.setRowKey(key2);

                JUCtrlValueBinding r = (JUCtrlValueBinding)causationsCausesLOV.getRowData();

                if (r == null) {
                    GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                } 
        session.setAttribute("CSC_CODE",r.getAttribute("cscCode"));
        session.setAttribute("DDC_CODE",r.getAttribute("cscDdcCode"));
        causID.setValue(r.getAttribute("ddsShtDesc"));
        causDescription.setValue(r.getAttribute("ddsDesc"));
        causationGender.setValue(r.getAttribute("cscSex"));
        minClaimablePeriod.setValue(r.getAttribute("cscMinClaimableprd"));
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:causationCausePopup" +
        "').show(hints);");
        return null;
    }

    public String DeleteCausationCause() {
        String Result = "F";
        RowKeySet rowKeySet =  causationsCausesLOV.getSelectedRowKeys();
                if (!rowKeySet.iterator().hasNext()) {
                    GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                }

                Object key2 = rowKeySet.iterator().next();
             causationsCausesLOV.setRowKey(key2);

                JUCtrlValueBinding r = (JUCtrlValueBinding)causationsCausesLOV.getRowData();

                if (r == null) {
                    GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                } 
        session.setAttribute("CSC_CODE",r.getAttribute("cscCode"));
        String authQuery="BEGIN LMS_SETUPS_PKG.delete_causation_causes(?);END;";
        Connection conn=new DBConnector().getDatabaseConn();
        try
        {
        CallableStatement cstmt=conn.prepareCall(authQuery); 
        
        cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("CSC_CODE"));
        cstmt.execute();
        conn.close();
           
            
           
            
            session.setAttribute("CSC_CODE",null);
            ADFUtils.findIterator("findCausationCausesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(causationsCausesLOV); 
          Result = "S";
        }
        catch(Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
        }
        return Result;
    }

    public void setCausID(RichInputText causID) {
        this.causID = causID;
    }

    public RichInputText getCausID() {
        return causID;
    }

    public void setAddCausationsLOV(RichTable addCausationsLOV) {
        this.addCausationsLOV = addCausationsLOV;
    }

    public RichTable getAddCausationsLOV() {
        return addCausationsLOV;
    }

    public void setCausationGender(RichSelectOneChoice causationGender) {
        this.causationGender = causationGender;
    }

    public RichSelectOneChoice getCausationGender() {
        return causationGender;
    }

    public void setMinClaimablePeriod(RichInputText minClaimablePeriod) {
        this.minClaimablePeriod = minClaimablePeriod;
    }

    public RichInputText getMinClaimablePeriod() {
        return minClaimablePeriod;
    }

    public void setCausDescription(RichInputText causDescription) {
        this.causDescription = causDescription;
    }

    public RichInputText getCausDescription() {
        return causDescription;
    }

    public String SaveCausationCause() {
        String updateQuery="BEGIN LMS_SETUPS_PKG.update_causation_causes(?,?,?,?,?);END;";
        Connection conn=null;
        try
        {
        
        conn=new DBConnector().getDatabaseConn();
        CallableStatement cstmt=conn.prepareCall(updateQuery);
        cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("CSC_CODE"));
        cstmt.setBigDecimal(2, (BigDecimal)session.getAttribute("CAUS_CODE"));
        cstmt.setBigDecimal(3, (BigDecimal)session.getAttribute("DDC_CODE"));
        if(causationGender.getValue()==null){
          cstmt.setString(4, null);
        }else{
          cstmt.setString(4, causationGender.getValue().toString());
        }
        if(minClaimablePeriod.getValue()==null){
          cstmt.setString(5, null);
        }else{
          cstmt.setString(5, minClaimablePeriod.getValue().toString());
        }        
        cstmt.execute();
        conn.close();
        
        GlobalCC.INFORMATIONREPORTING("Causation Cause saved Successfully.");
      
        session.setAttribute("DDC_CODE",null);
        session.setAttribute("CSC_CODE",null);
        ADFUtils.findIterator("findCausationCausesIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(causationsCausesLOV); 
        GlobalCC.hidePopup("lmsgroup:causationCausePopup");
            
        }
        catch(Exception ex) {
           GlobalCC.EXCEPTIONREPORTING(conn,ex);
        }
        return null;
    }

    public String AssignCaustionsCause() {
        
      try {
          DCIteratorBinding dciter = ADFUtils.findIterator("findDeathDisabilityCausesIterator");
          RowKeySet set = addCausationsLOV.getSelectedRowKeys();
          Iterator rowKeySetIter = set.iterator();
          
          while (rowKeySetIter.hasNext()) {
          List l = (List) rowKeySetIter.next();
          Key key = (Key)l.get(0);
          dciter.setCurrentRowWithKey(key.toStringFormat(true));
             
          Row r = dciter.getCurrentRow();
          session.setAttribute("DDC_CODE",r.getAttribute("ddcCode"));
          causID.setValue(r.getAttribute("ddcShtDesc"));
          causDescription.setValue(r.getAttribute("ddcDesc"));
          }
        AdfFacesContext.getCurrentInstance().addPartialTarget(causID); 
        AdfFacesContext.getCurrentInstance().addPartialTarget(causDescription);
        GlobalCC.hidePopup("lmsgroup:addCausationsPOPUP");
      }catch (Exception e) {
          GlobalCC.EXCEPTIONREPORTING(null,e);
      }
        return null;
    }

    public void setNonMedicalsClaimsLOV(RichTable nonMedicalsClaimsLOV) {
        this.nonMedicalsClaimsLOV = nonMedicalsClaimsLOV;
    }

    public RichTable getNonMedicalsClaimsLOV() {
        return nonMedicalsClaimsLOV;
    }

    public String AddNonMedicalClaim() {
        session.setAttribute("NMS_CODE",null);
        yearFrom.setValue(null);
        yearTo.setValue(null);
        nmsRate.setValue(null);
        nmsDivFact.setValue(null);
        nmsMaximumAmt.setValue(null);
        nmsWEF.setValue(null);
        nmsWet.setValue(null);
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:nonMedicalPopup" +
        "').show(hints);");
        return null;
    }

    public String EditNonMedicalClaim() {
        RowKeySet rowKeySet =  nonMedicalsClaimsLOV.getSelectedRowKeys();
                if (!rowKeySet.iterator().hasNext()) {
                    GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                }

                Object key2 = rowKeySet.iterator().next();
             nonMedicalsClaimsLOV.setRowKey(key2);

                JUCtrlValueBinding r = (JUCtrlValueBinding)nonMedicalsClaimsLOV.getRowData();

                if (r == null) {
                    GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                } 
        session.setAttribute("NMS_CODE",r.getAttribute("nmsCode"));
        yearFrom.setValue(r.getAttribute("mmsYearFrom"));
        yearTo.setValue(r.getAttribute("nmsYearTo"));
        nmsRate.setValue(r.getAttribute("nmsRate"));
        nmsDivFact.setValue(r.getAttribute("nmsDivFact"));
        nmsMaximumAmt.setValue(r.getAttribute("nmsMaxAmt"));
        nmsWEF.setValue(r.getAttribute("nmsWef"));
        nmsWet.setValue(r.getAttribute("nmsWet"));
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:nonMedicalPopup" +
        "').show(hints);");
        return null;
    }

    public String DeleteNonMedicalClaim() {
        String Result = "F";
        RowKeySet rowKeySet =  nonMedicalsClaimsLOV.getSelectedRowKeys();
                if (!rowKeySet.iterator().hasNext()) {
                    GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                }

                Object key2 = rowKeySet.iterator().next();
             nonMedicalsClaimsLOV.setRowKey(key2);

                JUCtrlValueBinding r = (JUCtrlValueBinding)nonMedicalsClaimsLOV.getRowData();

                if (r == null) {
                    GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                } 
        session.setAttribute("NMS_CODE",r.getAttribute("nmsCode"));
        String authQuery="BEGIN LMS_SETUPS_PKG.delete_non_medical_sa(?);END;";
        Connection conn=new DBConnector().getDatabaseConn();
        try
        {
        CallableStatement cstmt=conn.prepareCall(authQuery); 
        
        cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("NMS_CODE"));
        cstmt.execute();
        conn.close();

        session.setAttribute("NMS_CODE",null);
        ADFUtils.findIterator("findNonMedicalsSAIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(nonMedicalsClaimsLOV); 
        Result = "S";
        }
        catch(Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
        }
        return Result;
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

    public void setNmsRate(RichInputText nmsRate) {
        this.nmsRate = nmsRate;
    }

    public RichInputText getNmsRate() {
        return nmsRate;
    }

    public void setNmsDivFact(RichSelectOneChoice nmsDivFact) {
        this.nmsDivFact = nmsDivFact;
    }

    public RichSelectOneChoice getNmsDivFact() {
        return nmsDivFact;
    }

    public void setNmsMaximumAmt(RichInputText nmsMaximumAmt) {
        this.nmsMaximumAmt = nmsMaximumAmt;
    }

    public RichInputText getNmsMaximumAmt() {
        return nmsMaximumAmt;
    }

    public void setNmsWEF(RichInputDate nmsWEF) {
        this.nmsWEF = nmsWEF;
    }

    public RichInputDate getNmsWEF() {
        return nmsWEF;
    }

    public void setNmsWet(RichInputDate nmsWet) {
        this.nmsWet = nmsWet;
    }

    public RichInputDate getNmsWet() {
        return nmsWet;
    }

    public String saveNonMedicalClaims() {
        
        String updateQuery="BEGIN LMS_SETUPS_PKG.update_non_medical_sa(?,?,?,?,?,?,?,?);END;";
        Connection conn=null;
        try
        {
           conn=new DBConnector().getDatabaseConn();
        CallableStatement cstmt=conn.prepareCall(updateQuery);
        cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("NMS_CODE"));
        if(yearFrom.getValue()==null) {
            cstmt.setString(2, null);
        }
        else {
            cstmt.setBigDecimal(2, new BigDecimal(yearFrom.getValue().toString())); 
        }
        if(yearTo.getValue()==null) {
            cstmt.setString(3, null);  
        }
        else {
            cstmt.setBigDecimal(3, new BigDecimal(yearTo.getValue().toString()));  
        }
        if(nmsRate.getValue()==null) {
            cstmt.setString(4, null);  
        }
        else {
            cstmt.setBigDecimal(4, new BigDecimal(nmsRate.getValue().toString()));  
        }
        if(nmsMaximumAmt.getValue()==null) {
            cstmt.setString(5, null);  
        }
        else {
            cstmt.setBigDecimal(5, new BigDecimal(nmsMaximumAmt.getValue().toString()));  
        }
        if(nmsDivFact.getValue()==null) {
            cstmt.setString(6, null);  
        }
        else {
            cstmt.setBigDecimal(6, new BigDecimal(nmsDivFact.getValue().toString()));  
        }
        if(nmsWEF.getValue()==null) {
            cstmt.setString(7, null);  
        }
        else {
            if(nmsWEF.getValue().toString().contains(":")){
              cstmt.setString(7, GlobalCC.parseDate(nmsWEF.getValue().toString()));  
            }else{
              cstmt.setString(7, GlobalCC.upDateParseDate(nmsWEF.getValue().toString()));  
            }
           
        }
        if(nmsWet.getValue()==null) {
            cstmt.setString(8, null);  
        }
        else {
          if(nmsWet.getValue().toString().contains(":")){
            cstmt.setString(8, GlobalCC.parseDate(nmsWet.getValue().toString()));  
          }else{
            cstmt.setString(8, GlobalCC.upDateParseDate(nmsWet.getValue().toString()));  
          }
            
        }
                
        cstmt.execute();
        conn.close();
        
        GlobalCC.INFORMATIONREPORTING("Non Medical Claim saved Successfully.");
      
        session.setAttribute("NMS_CODE",null);
        ADFUtils.findIterator("findNonMedicalsSAIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(nonMedicalsClaimsLOV); 
        GlobalCC.hidePopup("lmsgroup:nonMedicalPopup");
        }
        catch(Exception ex) {
           GlobalCC.EXCEPTIONREPORTING(conn,ex);
        }
        return null;
    }

    public void setProductsTree(RichTree productsTree) {
        this.productsTree = productsTree;
    }

    public RichTree getProductsTree() {
        return productsTree;
    }

    public void productSelected(SelectionEvent evt) {
        if (evt.getAddedSet() != evt.getRemovedSet()) {
            RowKeySet rowKeySet = productsTree.getSelectedRowKeys();
            Object key2 = rowKeySet.iterator().next();
            productsTree.setRowKey(key2);
            JUCtrlValueBinding nodeBinding =
                (JUCtrlValueBinding)productsTree.getRowData();
            
                session.setAttribute("ProductCode",
                                     nodeBinding.getAttribute("PROD_CODE"));
            ADFUtils.findIterator("findProdCoverTypesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(prodCoverTypesLOV); 
        }
    }

    public void setProdCoverTypesLOV(RichTable prodCoverTypesLOV) {
        this.prodCoverTypesLOV = prodCoverTypesLOV;
    }

    public RichTable getProdCoverTypesLOV() {
        return prodCoverTypesLOV;
    }

    public void setCoverTypeCausationsLOV(RichTable coverTypeCausationsLOV) {
        this.coverTypeCausationsLOV = coverTypeCausationsLOV;
    }

    public RichTable getCoverTypeCausationsLOV() {
        return coverTypeCausationsLOV;
    }

    public void coverTypesListener(SelectionEvent selectionEvent) {
        DCIteratorBinding dciter = 
        ADFUtils.findIterator("findProdCoverTypesIterator");
        RowKeySet set =prodCoverTypesLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        
        //System.out.println(1);
        while (rowKeySetIter.hasNext()) 
        {
            List l = (List) rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
          
        
            session.setAttribute("PCT_CODE",r.getAttribute("PCT_CODE"));
            ADFUtils.findIterator("findCoverTypeCausationsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(coverTypeCausationsLOV); 
            ADFUtils.findIterator("findCoverTypeCausationsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(disCausationsLOV);
           
            
        }
    }

    public void setCvtcCausShtDesc(RichInputText cvtcCausShtDesc) {
        this.cvtcCausShtDesc = cvtcCausShtDesc;
    }

    public RichInputText getCvtcCausShtDesc() {
        return cvtcCausShtDesc;
    }

    public String AssignCoverTypeCausations() {
        RowKeySet rowKeySet =  cvCausationsLOV.getSelectedRowKeys();
                if (!rowKeySet.iterator().hasNext()) {
                    GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                }

                Object key2 = rowKeySet.iterator().next();
             cvCausationsLOV.setRowKey(key2);

                JUCtrlValueBinding r = (JUCtrlValueBinding)cvCausationsLOV.getRowData();

                if (r == null) {
                    GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                } 
        session.setAttribute("CAUS_CODE",r.getAttribute("causCode"));
        cvtcCausShtDesc.setValue(r.getAttribute("causShtdesc"));
        cvtcCausDesc.setValue(r.getAttribute("causDesc"));
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:coverTypeCausationsPopup" +
        "').show(hints);");
        return null;
    }

    public void setCvCausationsLOV(RichTable cvCausationsLOV) {
        this.cvCausationsLOV = cvCausationsLOV;
    }

    public RichTable getCvCausationsLOV() {
        return cvCausationsLOV;
    }

    public void setCvtcCausDesc(RichInputText cvtcCausDesc) {
        this.cvtcCausDesc = cvtcCausDesc;
    }

    public RichInputText getCvtcCausDesc() {
        return cvtcCausDesc;
    }

    public String SaveCoverTypeCausation() {
        if(cvtcCausShtDesc.getValue()==null) {
            String Message = "Select Causation.";
            FacesContext.getCurrentInstance().addMessage(null,
                                                        new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                         Message, 
                                                                         Message));
            return null;
        }
        String updateQuery="BEGIN LMS_SETUPS_PKG.updateCoverTypeCausation(?,?,?,?,?,?);END;";
        Connection conn=null;
        try
        {
           conn=new DBConnector().getDatabaseConn();
        CallableStatement cstmt=conn.prepareCall(updateQuery);
        cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("CVTC_CODE"));
        cstmt.setBigDecimal(2, (BigDecimal)session.getAttribute("PCT_CODE"));
        cstmt.setBigDecimal(3, (BigDecimal)session.getAttribute("CAUS_CODE"));
        cstmt.setString(4, cvtcCausShtDesc.getValue().toString());
         if(minClaimableDays.getValue()==null){
         cstmt.setString(5,null);   
            }else{
              cstmt.setString(5,minClaimableDays.getValue().toString()); 
            }
            if(maxClaimableDays.getValue()==null){
              cstmt.setString(6,null);
            }else{
              cstmt.setString(6,maxClaimableDays.getValue().toString());
            }
        cstmt.execute();
        conn.close();
        
        String Message = "Causation saved Successfully.";
        FacesContext.getCurrentInstance().addMessage(null,
                                                    new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                     Message, 
                                                                     Message));
            session.setAttribute("CAUS_CODE",null);
            session.setAttribute("CVTC_CODE",null);
            ADFUtils.findIterator("findCoverTypeCausationsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(coverTypeCausationsLOV); 
        }
        catch(Exception ex) {
           GlobalCC.EXCEPTIONREPORTING(conn,ex);
        }
        return null;
    }

    public String AddCoverTypeCausation() {
        session.setAttribute("CVTC_CODE",null);
        session.setAttribute("CAUS_CODE",null);
        cvtcCausShtDesc.setValue(null);
        cvtcCausDesc.setValue(null);
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:coverTypeCausationsPopup" +
        "').show(hints);");
        return null;
    }

    public String EditCoverTypeCausation() {
        RowKeySet rowKeySet =  coverTypeCausationsLOV.getSelectedRowKeys();
                if (!rowKeySet.iterator().hasNext()) {
                    GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                }

                Object key2 = rowKeySet.iterator().next();
             coverTypeCausationsLOV.setRowKey(key2);

                JUCtrlValueBinding r = (JUCtrlValueBinding)coverTypeCausationsLOV.getRowData();

                if (r == null) {
                    GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                } 
        session.setAttribute("CVTC_CODE",r.getAttribute("cvtcCode"));
        session.setAttribute("CAUS_CODE",r.getAttribute("cvtcCauseCode"));
        cvtcCausShtDesc.setValue(r.getAttribute("cvtcCausShtDesc"));
        cvtcCausDesc.setValue(r.getAttribute("cvtcCausDesc"));
        minClaimableDays.setValue(r.getAttribute("cvtcMinDaysClaimable"));
        maxClaimableDays.setValue(r.getAttribute("cvtcMaxDaysClaimable"));
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:coverTypeCausationsPopup" +
        "').show(hints);");
        return null;
    }

    public String DeleteCoverTypeCausation() {
        RowKeySet rowKeySet =  coverTypeCausationsLOV.getSelectedRowKeys();
                if (!rowKeySet.iterator().hasNext()) {
                    GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                }

                Object key2 = rowKeySet.iterator().next();
            coverTypeCausationsLOV.setRowKey(key2);

                JUCtrlValueBinding r = (JUCtrlValueBinding)coverTypeCausationsLOV.getRowData();

                if (r == null) {
                    GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                } 
        session.setAttribute("CVTC_CODE",r.getAttribute("cvtcCode"));
        String authQuery="BEGIN LMS_SETUPS_PKG.delete_cover_typ_causation(?);END;";
        Connection conn=new DBConnector().getDatabaseConn();
        try
        {
        CallableStatement cstmt=conn.prepareCall(authQuery); 
        
        cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("CVTC_CODE"));
        cstmt.execute();
        conn.close();
            String Message = "Record deleted successfully.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            
           
            
            session.setAttribute("CVTC_CODE",null);
            session.setAttribute("CAUS_CODE",null);
            ADFUtils.findIterator("findCoverTypeCausationsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(coverTypeCausationsLOV); 
        }
        catch(Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
        }
        return null;
    }

    public void setPolicyDocumentsLOV(RichTable policyDocumentsLOV) {
        this.policyDocumentsLOV = policyDocumentsLOV;
    }

    public RichTable getPolicyDocumentsLOV() {
        return policyDocumentsLOV;
    }

    public void documentsListener(SelectionEvent selectionEvent) {
        RowKeySet rowKeySet =  policyDocumentsLOV.getSelectedRowKeys();
                if (!rowKeySet.iterator().hasNext()) {
                    GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                }

                Object key2 = rowKeySet.iterator().next();
            policyDocumentsLOV.setRowKey(key2);

                JUCtrlValueBinding r = (JUCtrlValueBinding)policyDocumentsLOV.getRowData();

                if (r == null) {
                    GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                } 
        session.setAttribute("RD_CODE",r.getAttribute("rdCode"));
        ADFUtils.findIterator("findProductReuiredDocsIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(productDocumentsLOV);
    }

    public String AddPolicyDocument() {
        session.setAttribute("RD_CODE",null);
        rdShtDesc.setValue(null);
        rdDesc.setValue(null);
        productLevel.setValue(null);
        uwDocument.setValue(null);
        deathClaimDocs.setValue(null);
        disabilityClaimDocs.setValue(null);
        withClaimDocs.setValue(null);
        
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:polDocsPopup" +
        "').show(hints);");
        return null;
    }

    public String DeletePolDocument() {
        RowKeySet rowKeySet =  policyDocumentsLOV.getSelectedRowKeys();
                if (!rowKeySet.iterator().hasNext()) {
                    GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                }

                Object key2 = rowKeySet.iterator().next();
            policyDocumentsLOV.setRowKey(key2);

                JUCtrlValueBinding r = (JUCtrlValueBinding)policyDocumentsLOV.getRowData();

                if (r == null) {
                    GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                } 
        session.setAttribute("RD_CODE",r.getAttribute("rdCode"));
        String authQuery="BEGIN LMS_SETUPS_PKG.deletePolicyDoc(?);END;";
        Connection conn=new DBConnector().getDatabaseConn();
        try
        {
        CallableStatement cstmt=conn.prepareCall(authQuery); 
        
        cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("RD_CODE"));
        cstmt.execute();
        conn.close();
            String Message = "Record deleted successfully.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            
           
            
            session.setAttribute("RD_CODE",null);
            ADFUtils.findIterator("findPolicyDocumentsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(productDocumentsLOV); 
        }
        catch(Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
        }
        return null;
    }

    public String EditPolicyDocument() {
        RowKeySet rowKeySet =  policyDocumentsLOV.getSelectedRowKeys();
                if (!rowKeySet.iterator().hasNext()) {
                    GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                }

                Object key2 = rowKeySet.iterator().next();
            policyDocumentsLOV.setRowKey(key2);

                JUCtrlValueBinding r = (JUCtrlValueBinding)policyDocumentsLOV.getRowData();

                if (r == null) {
                    GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                } 
        session.setAttribute("RD_CODE",r.getAttribute("rdCode"));
        rdShtDesc.setValue(r.getAttribute("rdShtDesc"));
        rdDesc.setValue(r.getAttribute("rdDesc"));
        productLevel.setValue(r.getAttribute("rdByProd"));
        uwDocument.setValue(r.getAttribute("rdPolDoc"));
        deathClaimDocs.setValue(r.getAttribute("rdDthClmdoc"));
        disabilityClaimDocs.setValue(r.getAttribute("rdDisClmDoc"));
        withClaimDocs.setValue(r.getAttribute("rdWthrClmDoc"));
        maturityDocs.setValue(r.getAttribute("RD_MATURITY_DOC"));
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:polDocsPopup" +
        "').show(hints);");
        return null;
    }

    public void setUwDocument(RichSelectOneChoice uwDocument) {
        this.uwDocument = uwDocument;
    }

    public RichSelectOneChoice getUwDocument() {
        return uwDocument;
    }

    public void setDeathClaimDocs(RichSelectOneChoice deathClaimDocs) {
        this.deathClaimDocs = deathClaimDocs;
    }

    public RichSelectOneChoice getDeathClaimDocs() {
        return deathClaimDocs;
    }

    public void setDisabilityClaimDocs(RichSelectOneChoice disabilityClaimDocs) {
        this.disabilityClaimDocs = disabilityClaimDocs;
    }

    public RichSelectOneChoice getDisabilityClaimDocs() {
        return disabilityClaimDocs;
    }

    public void setWithClaimDocs(RichSelectOneChoice withClaimDocs) {
        this.withClaimDocs = withClaimDocs;
    }

    public RichSelectOneChoice getWithClaimDocs() {
        return withClaimDocs;
    }

    public void setRdShtDesc(RichInputText rdShtDesc) {
        this.rdShtDesc = rdShtDesc;
    }

    public RichInputText getRdShtDesc() {
        return rdShtDesc;
    }

    public void setRdDesc(RichInputText rdDesc) {
        this.rdDesc = rdDesc;
    }

    public RichInputText getRdDesc() {
        return rdDesc;
    }

    public void setProductLevel(RichSelectOneChoice productLevel) {
        this.productLevel = productLevel;
    }

    public RichSelectOneChoice getProductLevel() {
        return productLevel;
    }

    public String SavePolicyDocument() {
        String updateQuery="BEGIN LMS_SETUPS_PKG.update_reqrd_documents(?,?,?,?,?,?,?,?,?);END;";
        Connection conn=null;
        try
        {
           conn=new DBConnector().getDatabaseConn();
        CallableStatement cstmt=conn.prepareCall(updateQuery);
        cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("RD_CODE"));
        if(rdShtDesc.getValue()==null) {
            cstmt.setString(2, null);
        }
        else {
            cstmt.setString(2, rdShtDesc.getValue().toString()); 
        }
        if(rdDesc.getValue()==null) {
            cstmt.setString(3, null);  
        }
        else {
            cstmt.setString(3, rdDesc.getValue().toString());  
        }
        if(uwDocument.getValue()==null) {
            cstmt.setString(4, null);  
        }
        else {
            cstmt.setString(4, uwDocument.getValue().toString());  
        }
        if(deathClaimDocs.getValue()==null) {
            cstmt.setString(5, null);  
        }
        else {
            cstmt.setString(5, deathClaimDocs.getValue().toString());  
        }
        if(disabilityClaimDocs.getValue()==null) {
            cstmt.setString(6, null);  
        }
        else {
            cstmt.setString(6, disabilityClaimDocs.getValue().toString());  
        }
        if(withClaimDocs.getValue()==null) {
            cstmt.setString(7, null);  
        }
        else {
            cstmt.setString(7, withClaimDocs.getValue().toString());  
        }
        if(productLevel.getValue()==null) {
            cstmt.setString(8, null);  
        }
        else {
            cstmt.setString(8, productLevel.getValue().toString());  
        }
        if(maturityDocs.getValue()==null) {
            cstmt.setString(9, null);  
        }
        else {
            cstmt.setString(9, maturityDocs.getValue().toString());  
        }
                
        cstmt.execute();
        conn.close();
        
        String Message = "Document saved Successfully.";
        FacesContext.getCurrentInstance().addMessage(null,
                                                    new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                     Message, 
                                                                     Message));
          
            session.setAttribute("RD_CODE",null);
            ADFUtils.findIterator("findPolicyDocumentsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(policyDocumentsLOV);  
        }
        catch(Exception ex) {
           GlobalCC.EXCEPTIONREPORTING(conn,ex);
        }
        return null;
    }

    public void setProductDocumentsLOV(RichTable productDocumentsLOV) {
        this.productDocumentsLOV = productDocumentsLOV;
    }

    public RichTable getProductDocumentsLOV() {
        return productDocumentsLOV;
    }

    public String AddProductDocument() {
        session.setAttribute("ProductCode",null);
        productDisp.setValue(null);
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:prodDocsPopup" +
        "').show(hints);");
        return null;
    }

    public String deleteProductDocument() {
        RowKeySet rowKeySet = productDocumentsLOV.getSelectedRowKeys();
                if (!rowKeySet.iterator().hasNext()) {
                    GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                }

                Object key2 = rowKeySet.iterator().next();
            productDocumentsLOV.setRowKey(key2);

                JUCtrlValueBinding r = (JUCtrlValueBinding)productDocumentsLOV.getRowData();

                if (r == null) {
                    GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                } 
        session.setAttribute("ProductCode",r.getAttribute("rdpProdCode"));
        String authQuery="BEGIN LMS_SETUPS_PKG.delete_req_docs_products(?,?);END;";
        Connection conn=new DBConnector().getDatabaseConn();
        try
        {
        CallableStatement cstmt=conn.prepareCall(authQuery); 
        
        cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("RD_CODE"));
        cstmt.setBigDecimal(2, (BigDecimal)session.getAttribute("ProductCode"));
        cstmt.execute();
        conn.close();
            String Message = "Record deleted successfully.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            
           
            
           // session.setAttribute("RD_CODE",null);
           // session.setAttribute("ProductCode",null);
            ADFUtils.findIterator("findProductReuiredDocsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(productDocumentsLOV);
        }
        catch(Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
        }
        return null;
    }

    public String EditProductDocument() {
        RowKeySet rowKeySet = productDocumentsLOV.getSelectedRowKeys();
                if (!rowKeySet.iterator().hasNext()) {
                    GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                }

                Object key2 = rowKeySet.iterator().next();
            productDocumentsLOV.setRowKey(key2);

                JUCtrlValueBinding r = (JUCtrlValueBinding)productDocumentsLOV.getRowData();

                if (r == null) {
                    GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                } 
        session.setAttribute("ProductCode",r.getAttribute("rdpProdCode"));
        productDisp.setValue(r.getAttribute("productDisplay"));
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:prodDocsPopup" +
        "').show(hints);");
        return null;
    }

    public void setProductDisp(RichInputText productDisp) {
        this.productDisp = productDisp;
    }

    public RichInputText getProductDisp() {
        return productDisp;
    }

    public void setProductsLOV(RichTable productsLOV) {
        this.productsLOV = productsLOV;
    }

    public RichTable getProductsLOV() {
        return productsLOV;
    }

    public String AssignProducts() {
        RowKeySet rowKeySet =  productsLOV.getSelectedRowKeys();
                if (!rowKeySet.iterator().hasNext()) {
                    GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                }

                Object key2 = rowKeySet.iterator().next();
            productsLOV.setRowKey(key2);

                JUCtrlValueBinding r = (JUCtrlValueBinding)productsLOV.getRowData();

                if (r == null) {
                    GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                } 
        session.setAttribute("ProductCode",r.getAttribute("PROD_CODE"));
        productDisp.setValue(r.getAttribute("PROD_DESC"));
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:prodDocsPopup" +
        "').show(hints);");
        return null;
    }

    public String SaveProductDocument() {
        String authQuery="BEGIN LMS_SETUPS_PKG.update_req_docs_products(?,?);END;";
        Connection conn=new DBConnector().getDatabaseConn();
        try
        {
        CallableStatement cstmt=conn.prepareCall(authQuery); 
        
        cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("RD_CODE"));
        cstmt.setBigDecimal(2, (BigDecimal)session.getAttribute("ProductCode"));
        cstmt.execute();
        conn.close();
            String Message = "Record Saved successfully.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            
           
            
            //session.setAttribute("RD_CODE",null);
            //session.setAttribute("ProductCode",null);
            ADFUtils.findIterator("findProductReuiredDocsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(productDocumentsLOV);
        }
        catch(Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
        }
        return null;
    }

    public void setTransactionSelected(RichOutputText transactionSelected) {
        this.transactionSelected = transactionSelected;
    }

    public RichOutputText getTransactionSelected() {
        return transactionSelected;
    }

    public void setTransactionsTree(RichTree transactionsTree) {
        this.transactionsTree = transactionsTree;
    }

    public RichTree getTransactionsTree() {
        return transactionsTree;
    }

    public void transactionSelected(SelectionEvent selectionEvent) {
        if (selectionEvent.getAddedSet() != selectionEvent.getRemovedSet()) {
            RowKeySet rowKeySet = transactionsTree.getSelectedRowKeys();
            Object key2 = rowKeySet.iterator().next();
            transactionsTree.setRowKey(key2);
            JUCtrlValueBinding nodeBinding =
                (JUCtrlValueBinding)transactionsTree.getRowData();

           

         
                //termRangePan.setRendered(false);
              //  mortalityRatesPan.setRendered(false);
            
                session.setAttribute("BTR_TRANS_CODE",
                                     nodeBinding.getAttribute("BTR_TRANS_CODE"));
            ADFUtils.findIterator("findDrCrNarrativesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(narrativesLOV);
        }
    }

    public void setNarrativesLOV(RichTable narrativesLOV) {
        this.narrativesLOV = narrativesLOV;
    }

    public RichTable getNarrativesLOV() {
        return narrativesLOV;
    }

    public String AddNarrative() {
        session.setAttribute("DRCR_CODE",null);
        drNarrative.setValue(null);
        crNarrative.setValue(null);
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:narrativesPopup" +
        "').show(hints);");
        return null;
    }

    public String EditNarrative() {
        try{
        RowKeySet rowKeySet =  narrativesLOV.getSelectedRowKeys();
                if (!rowKeySet.iterator().hasNext()) {
                    GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                }

                Object key2 = rowKeySet.iterator().next();
            narrativesLOV.setRowKey(key2);

                JUCtrlValueBinding r = (JUCtrlValueBinding)narrativesLOV.getRowData();

                if (r == null) {
                    GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                } 
        session.setAttribute("DRCR_CODE",r.getAttribute("drcrCode"));
        drNarrative.setValue(r.getAttribute("drNarrative"));
        crNarrative.setValue(r.getAttribute("crNarrative"));
        drCoinNarrative.setValue(r.getAttribute("DRCR_DR_COIN_NARRATIVE"));
        crCoinNarrative.setValue(r.getAttribute("DRCR_CR_COIN_NARRATIVE"));
            
        GlobalCC.showPopup("lmsgroup:narrativesPopup");
        }catch(Exception e){
          GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }
    
  public String EditEndorsementNarrative() {
      try{
      RowKeySet rowKeySet =  narrativesLOV.getSelectedRowKeys();
              if (!rowKeySet.iterator().hasNext()) {
                  GlobalCC.errorValueNotEntered("Error: No Record Selected");
                  //return null;
              }
             Object key2 = rowKeySet.iterator().next();
             narrativesLOV.setRowKey(key2);

              JUCtrlValueBinding r = (JUCtrlValueBinding)narrativesLOV.getRowData();

              if (r == null) {
                  GlobalCC.errorValueNotEntered("Error: No Record Selected");
                  //return null;
              } 
      session.setAttribute("DRCR_CODE",r.getAttribute("drcrCode"));
      clauseEditor.setValue(r.getAttribute("DRCR_END_NARRATIVE"));
      
      GlobalCC.showPopup("lmsgroup:editPopup");
      }catch(Exception e){
        GlobalCC.EXCEPTIONREPORTING(null,e);
      }
      return null;
  }

  
    public String DeleteNarrative() {
      try{
        RowKeySet rowKeySet =  narrativesLOV.getSelectedRowKeys();
                if (!rowKeySet.iterator().hasNext()) {
                    GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                }

                Object key2 = rowKeySet.iterator().next();
            narrativesLOV.setRowKey(key2);

                JUCtrlValueBinding r = (JUCtrlValueBinding)narrativesLOV.getRowData();

                if (r == null) {
                    GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                } 
        session.setAttribute("DRCR_CODE",r.getAttribute("drcrCode"));
        String authQuery="BEGIN LMS_SETUPS_PKG.delete_narratives(?);END;";
        Connection conn=new DBConnector().getDatabaseConn();

        CallableStatement cstmt=conn.prepareCall(authQuery); 
        
        cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("DRCR_CODE"));
        
        cstmt.execute();
        conn.close();
            String Message = "Record deleted successfully.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            
           
            
           // session.setAttribute("RD_CODE",null);
            session.setAttribute("DRCR_CODE",null);
            ADFUtils.findIterator("findDrCrNarrativesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(narrativesLOV);
        }
        catch(Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(null,ex);
        }
        
        return null;
    }

    public void setDrNarrative(RichInputText drNarrative) {
        this.drNarrative = drNarrative;
    }

    public RichInputText getDrNarrative() {
        return drNarrative;
    }

    public void setCrNarrative(RichInputText crNarrative) {
        this.crNarrative = crNarrative;
    }

    public RichInputText getCrNarrative() {
        return crNarrative;
    }
   
  public String SaveEndorsementNarrative() {
    String updateQuery="BEGIN LMS_SETUPS_PKG.updateEndrNarrative(?,?);END;";
    Connection conn=null;
    try
    {
    conn=new DBConnector().getDatabaseConn();
    CallableStatement cstmt=conn.prepareCall(updateQuery);
    cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("DRCR_CODE"));
    if(clauseEditor.getValue()==null) {
        cstmt.setString(2,null);   
    }
    else {
        cstmt.setString(2,(String)clauseEditor.getValue());  
    }
      cstmt.execute();
      conn.close();
        
      GlobalCC.INFORMATIONREPORTING("Narrative saved Successfully.");
    
      session.setAttribute("DRCR_CODE",null);
      ADFUtils.findIterator("findDrCrNarrativesIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(narrativesLOV);
    }
    catch(Exception ex) {
       GlobalCC.EXCEPTIONREPORTING(conn,ex);
    }
    
    return null;
  }
    public String SaveNarrative() {
        String updateQuery="BEGIN LMS_SETUPS_PKG.updateNarratives(?,?,?,?,?,?,?);END;";
        Connection conn=null;
        try
        {
           conn=new DBConnector().getDatabaseConn();
        CallableStatement cstmt=conn.prepareCall(updateQuery);
        cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("DRCR_CODE"));
        cstmt.setString(2, (String)session.getAttribute("BTR_TRANS_CODE"));
        if(drNarrative.getValue()==null) {
            cstmt.setString(3,null);   
        }
        else {
            cstmt.setString(3,drNarrative.getValue().toString());  
        }
        if(crNarrative.getValue()==null) {
            cstmt.setString(4,null);   
        }
        else {
            cstmt.setString(4,crNarrative.getValue().toString());  
        }   
        if(drCoinNarrative.getValue()==null) {
            cstmt.setString(5,null);   
        }
        else {
            cstmt.setString(5,drCoinNarrative.getValue().toString());  
        }
        if(crCoinNarrative.getValue()==null) {
            cstmt.setString(6,null);   
        }
        else {
            cstmt.setString(6,crCoinNarrative.getValue().toString());  
        }  
        if(coinsurance_apportionment.getValue()==null){
          cstmt.setString(7,null);   
        }else{
          cstmt.setString(7,coinsurance_apportionment.getValue().toString());  
        }
        
                         
        cstmt.execute();
        conn.close();
        
        String Message = "Narrative saved Successfully.";
        FacesContext.getCurrentInstance().addMessage(null,
                                                    new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                     Message, 
                                                                     Message));
            session.setAttribute("DRCR_CODE",null);
            ADFUtils.findIterator("findDrCrNarrativesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(narrativesLOV);
        }
        catch(Exception ex) {
           GlobalCC.EXCEPTIONREPORTING(conn,ex);
        }
      
        return null;
    }

    public void setRatesDescLOV(RichTable ratesDescLOV) {
        this.ratesDescLOV = ratesDescLOV;
    }

    public RichTable getRatesDescLOV() {
        return ratesDescLOV;
    }

    public void setRatesID(RichInputText ratesID) {
        this.ratesID = ratesID;
    }

    public RichInputText getRatesID() {
        return ratesID;
    }

    public void setRatesDescription(RichInputText ratesDescription) {
        this.ratesDescription = ratesDescription;
    }

    public RichInputText getRatesDescription() {
        return ratesDescription;
    }

    public String SaveRiRates() {
        String updateQuery="BEGIN LMS_SETUPS_PKG.updateRIRateDesc(?,?,?,?);END;";
        Connection conn=null;
        try
        {
        conn=new DBConnector().getDatabaseConn();
        CallableStatement cstmt=conn.prepareCall(updateQuery);
        cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("OPPR_CODE"));
        cstmt.setString(2, ratesID.getValue().toString());
        if(ratesDescription.getValue()==null) {
            cstmt.setString(3,null);   
        }
        else {
            cstmt.setString(3,ratesDescription.getValue().toString());  
        }
     
        cstmt.setString(4,new String("N"));  
             
        cstmt.execute();
        cstmt.close();
        conn.close();
        
        GlobalCC.INFORMATIONREPORTING("Rate Description saved Successfully.");
        session.setAttribute("orrpCode",null);
            
        
        GlobalCC.hidePopup("lmsgroup:ordReinRatesPopup");
        ADFUtils.findIterator("findOrdReinsuranceRatesIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(ratesDescLOV);
        }
        catch(Exception ex) {
           GlobalCC.EXCEPTIONREPORTING(conn,ex);
        }
        return null;
    }

    public String AddNewRiRates() {
        session.setAttribute("orrpCode",null);
        ratesID.setValue(null);
        ratesDescription.setValue(null);
        GlobalCC.showPopup("lmsgroup:ordReinRatesPopup");
       
        return null;
    }

    public String EditRiRates() {
        RowKeySet rowKeySet =  ratesDescLOV.getSelectedRowKeys();
                if (!rowKeySet.iterator().hasNext()) {
                    GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                }

                Object key2 = rowKeySet.iterator().next();
            ratesDescLOV.setRowKey(key2);

                JUCtrlValueBinding r = (JUCtrlValueBinding)ratesDescLOV.getRowData();

                if (r == null) {
                    GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                } 
        session.setAttribute("orrpCode",r.getAttribute("orrpCode"));
        ratesID.setValue(r.getAttribute("orrpShtDesc"));
        ratesDescription.setValue(r.getAttribute("orrpDesc"));
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:ordReinRatesPopup" +
        "').show(hints);");
        return null;
    }

    public String DeleteRiRates() {
        RowKeySet rowKeySet =  ratesDescLOV.getSelectedRowKeys();
                if (!rowKeySet.iterator().hasNext()) {
                    GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                }

                Object key2 = rowKeySet.iterator().next();
            ratesDescLOV.setRowKey(key2);

                JUCtrlValueBinding r = (JUCtrlValueBinding)ratesDescLOV.getRowData();

                if (r == null) {
                    GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                } 
        session.setAttribute("orrpCode",r.getAttribute("orrpCode"));
        String authQuery="BEGIN LMS_SETUPS_PKG.deleteRIRateDesc(?);END;";
        Connection conn=new DBConnector().getDatabaseConn();
        try
        {
        CallableStatement cstmt=conn.prepareCall(authQuery); 
        
        cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("orrpCode"));
        
        cstmt.execute();
        conn.close();
            String Message = "Record deleted successfully.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            
           
            
           // session.setAttribute("RD_CODE",null);
            session.setAttribute("orrpCode",null);
            ADFUtils.findIterator("findOrdReinsuranceRatesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(ratesDescLOV);
        }
        catch(Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
        }
        
        return null;
    }

    public String AddRiRates() {
        session.setAttribute("orrtCode",null);
        anbFrom.setValue(null);
        anbTo.setValue(null);
        rate.setValue(null);
        divisionFactor.setValue(null);
        rateType.setValue(null);
        riWEf.setValue(null);
        riWet.setValue(null);
        
        GlobalCC.showPopup("lmsgroup:riRatesDescPopup");
     
        return null;
    }

    public String EditRiDescRates() {
        RowKeySet rowKeySet =  ordReinRatesLOV.getSelectedRowKeys();
                if (!rowKeySet.iterator().hasNext()) {
                    GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    return null;
                }

                Object key2 = rowKeySet.iterator().next();
            ordReinRatesLOV.setRowKey(key2);

                JUCtrlValueBinding r = (JUCtrlValueBinding)ordReinRatesLOV.getRowData();

                if (r == null) {
                    GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    return null;
                } 
        session.setAttribute("orrtCode",r.getAttribute("orrtCode"));
        anbFrom.setValue(r.getAttribute("orrtAnbFrom"));
        anbTo.setValue(r.getAttribute("orrtAnbTo"));
        rate.setValue(r.getAttribute("orrtRate"));
        divisionFactor.setValue(r.getAttribute("orrtDivFactor"));
        rateType.setValue(r.getAttribute("orrtRateType"));
        riWEf.setValue(r.getAttribute("orrtWef"));
        riWet.setValue(r.getAttribute("orrtWet"));
        
        GlobalCC.showPopup("lmsgroup:riRatesDescPopup");
     
        return null;
    }

    public String DeleteRiRatesDesc() {
        RowKeySet rowKeySet =  ordReinRatesLOV.getSelectedRowKeys();
                if (!rowKeySet.iterator().hasNext()) {
                    GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                }

                Object key2 = rowKeySet.iterator().next();
            ordReinRatesLOV.setRowKey(key2);

                JUCtrlValueBinding r = (JUCtrlValueBinding)ordReinRatesLOV.getRowData();

                if (r == null) {
                    GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                } 
        session.setAttribute("orrtCode",r.getAttribute("orrtCode"));
        String authQuery="BEGIN LMS_SETUPS_PKG.deleteRIRates(?);END;";
        Connection conn=new DBConnector().getDatabaseConn();
        try
        {
        CallableStatement cstmt=conn.prepareCall(authQuery); 
        
        cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("orrtCode"));
        
        cstmt.execute();
        conn.close();
            String Message = "Record deleted successfully.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            
           
            
           // session.setAttribute("RD_CODE",null);
            session.setAttribute("orrtCode",null);
            ADFUtils.findIterator("findOrdReinsuranceRatesDescriptionIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(ordReinRatesLOV);
        }
        catch(Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
        }
        return null;
    }

    public void setAnbFrom(RichInputText anbFrom) {
        this.anbFrom = anbFrom;
    }

    public RichInputText getAnbFrom() {
        return anbFrom;
    }

    public void setAnbTo(RichInputText anbTo) {
        this.anbTo = anbTo;
    }

    public RichInputText getAnbTo() {
        return anbTo;
    }

    public void setRate(RichInputText rate) {
        this.rate = rate;
    }

    public RichInputText getRate() {
        return rate;
    }

    public void setDivisionFactor(RichInputText divisionFactor) {
        this.divisionFactor = divisionFactor;
    }

    public RichInputText getDivisionFactor() {
        return divisionFactor;
    }

    public void setRateType(RichSelectOneChoice rateType) {
        this.rateType = rateType;
    }

    public RichSelectOneChoice getRateType() {
        return rateType;
    }

    public void setRiWEf(RichInputDate riWEf) {
        this.riWEf = riWEf;
    }

    public RichInputDate getRiWEf() {
        return riWEf;
    }

    public void setRiWet(RichInputDate riWet) {
        this.riWet = riWet;
    }

    public RichInputDate getRiWet() {
        return riWet;
    }

    public String SaveRiRatesDesc() {
        String updateQuery="BEGIN LMS_SETUPS_PKG.updateRIRates(?,?,?,?,?,?,?,?,?,?);END;";
        Connection conn=null;
        try
        {
           conn=new DBConnector().getDatabaseConn();
        CallableStatement cstmt=conn.prepareCall(updateQuery);
        cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("orrtCode"));
        if(anbFrom.getValue()==null) {
            cstmt.setString(2, null);
        }
        else {
            cstmt.setString(2, anbFrom.getValue().toString()); 
        }
        if(anbTo.getValue()==null) {
            cstmt.setString(3, null);  
        }
        else {
            cstmt.setString(3, anbTo.getValue().toString());  
        }
        if(rate.getValue()==null) {
            cstmt.setString(4, null);  
        }
        else {
            cstmt.setString(4, rate.getValue().toString());  
        }
        if(divisionFactor.getValue()==null) {
            cstmt.setString(5, null);  
        }
        else {
            cstmt.setString(5, divisionFactor.getValue().toString());  
        }
        if(rateType.getValue()==null) {
            cstmt.setString(6, null);  
        }
        else {
            cstmt.setString(6, rateType.getValue().toString());  
        }
        if(riWEf.getValue()==null) {
            cstmt.setString(7, null);  
        }
        else {
            String MyDate = null;
            if(riWEf.getValue().toString().contains(":")){
                MyDate = GlobalCC.parseDate(riWEf.getValue().toString());
            }else{
                MyDate = GlobalCC.upDateParseDate(riWEf.getValue().toString());
            }
            cstmt.setString(7, MyDate);
        }
        if(riWet.getValue()==null) {
            cstmt.setString(8, null);  
        }
        else {
            String MyDate = null;
            if(riWet.getValue().toString().contains(":")){
                MyDate = GlobalCC.parseDate(riWet.getValue().toString());
            }else{
                MyDate = GlobalCC.upDateParseDate(riWet.getValue().toString());
            }
            cstmt.setString(8, MyDate);
        }
        cstmt.setBigDecimal(9, (BigDecimal)session.getAttribute("orrpCode")); 
        cstmt.setBigDecimal(10, null);
        cstmt.execute();
        cstmt.close();
        conn.close();
        
        GlobalCC.INFORMATIONREPORTING("Rate saved Successfully.");
   
        session.setAttribute("orrtCode",null);
        GlobalCC.hidePopup("lmsgroup:riRatesDescPopup");
        ADFUtils.findIterator("findOrdReinsuranceRatesDescriptionIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(ordReinRatesLOV);  
        }
        catch(Exception ex) {
           GlobalCC.EXCEPTIONREPORTING(conn,ex);
        }
        return null;
    }

    public void RiRatesListener(SelectionEvent selectionEvent) {
        RowKeySet rowKeySet =  ratesDescLOV.getSelectedRowKeys();
                if (!rowKeySet.iterator().hasNext()) {
                    GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                }

                Object key2 = rowKeySet.iterator().next();
            ratesDescLOV.setRowKey(key2);

                JUCtrlValueBinding r = (JUCtrlValueBinding)ratesDescLOV.getRowData();

                if (r == null) {
                    GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                } 
        session.setAttribute("orrpCode",r.getAttribute("orrpCode"));
        session.removeAttribute("orrtCode");
        ADFUtils.findIterator("findOrdReinsuranceRatesDescriptionIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(ordReinRatesLOV);
    }

    public void setOrdReinRatesLOV(RichTable ordReinRatesLOV) {
        this.ordReinRatesLOV = ordReinRatesLOV;
    }

    public RichTable getOrdReinRatesLOV() {
        return ordReinRatesLOV;
    }

    public void setDisCausationsLOV(RichTable disCausationsLOV) {
        this.disCausationsLOV = disCausationsLOV;
    }

    public RichTable getDisCausationsLOV() {
        return disCausationsLOV;
    }

    public String AddDisabilityLosses() {
        session.setAttribute("LDL_CODE",null);
        lossDescription.setValue(null);
        percentPayable.setValue(null);
        closesPolicy.setValue(null);
        weeklyIndemnity.setValue(null);
        ldlDivisionFactor.setValue(null);
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:disabilityLossesPopup" +
        "').show(hints);");
        return null;
    }

    public String EditDisabilityLosses() {
        RowKeySet rowKeySet =  disabilityLossesLOV.getSelectedRowKeys();
                if (!rowKeySet.iterator().hasNext()) {
                    GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                }

                Object key2 = rowKeySet.iterator().next();
                disabilityLossesLOV.setRowKey(key2);

                JUCtrlValueBinding r = (JUCtrlValueBinding)disabilityLossesLOV.getRowData();

                if (r == null) {
                    GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                } 
        session.setAttribute("LDL_CODE",r.getAttribute("ldlCode"));
        lossDescription.setValue(r.getAttribute("ldlDesc"));
        percentPayable.setValue(r.getAttribute("ldlPerc"));
        closesPolicy.setValue(r.getAttribute("ldlClosePol"));
        weeklyIndemnity.setValue(r.getAttribute("ldlWklIndemnity"));
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:disabilityLossesPopup" +
        "').show(hints);");
        return null;
    }

    public String DeleteDisabilityLosses() {
        RowKeySet rowKeySet =  disabilityLossesLOV.getSelectedRowKeys();
                if (!rowKeySet.iterator().hasNext()) {
                    GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                }

                Object key2 = rowKeySet.iterator().next();
                disabilityLossesLOV.setRowKey(key2);

                JUCtrlValueBinding r = (JUCtrlValueBinding)disabilityLossesLOV.getRowData();

                if (r == null) {
                    GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                } 
        session.setAttribute("LDL_CODE",r.getAttribute("ldlCode"));
        String authQuery="BEGIN LMS_SETUPS_PKG.delete_disability_losses(?);END;";
        Connection conn=new DBConnector().getDatabaseConn();
        try
        {
        CallableStatement cstmt=conn.prepareCall(authQuery); 
        
        cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("LDL_CODE"));
        
        cstmt.execute();
        conn.close();
            String Message = "Record deleted successfully.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            
           
            
           // session.setAttribute("RD_CODE",null);
            session.setAttribute("LDL_CODE",null);
            ADFUtils.findIterator("findDisabilityLossesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(disabilityLossesLOV);
        }
        catch(Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
        }
        return null;
    }

    public void setLossDescription(RichInputText lossDescription) {
        this.lossDescription = lossDescription;
    }

    public RichInputText getLossDescription() {
        return lossDescription;
    }

    public void setPercentPayable(RichInputText percentPayable) {
        this.percentPayable = percentPayable;
    }

    public RichInputText getPercentPayable() {
        return percentPayable;
    }

    public void setClosesPolicy(RichSelectOneChoice closesPolicy) {
        this.closesPolicy = closesPolicy;
    }

    public RichSelectOneChoice getClosesPolicy() {
        return closesPolicy;
    }

    public String SaveDisabilityLoss() {
        if(lossDescription.getValue()==null) {
            String Message = "Enter Loss Description.";
            FacesContext.getCurrentInstance().addMessage(null,
                                                        new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                         Message, 
                                                                         Message));
            return null;
        }
        if(percentPayable.getValue()==null) {
            String Message = "Enter Rate";
            FacesContext.getCurrentInstance().addMessage(null,
                                                        new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                         Message, 
                                                                         Message));
            return null;
        }
        if(ldlDivisionFactor.getValue()==null) {
            String Message = "Choose Division Factor";
            FacesContext.getCurrentInstance().addMessage(null,
                                                        new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                         Message, 
                                                                         Message));
            return null;
        }
        if(weeklyIndemnity.getValue()==null) {
            String Message = "Specify if the loss is weekly indemnity or not";
            FacesContext.getCurrentInstance().addMessage(null,
                                                        new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                         Message, 
                                                                         Message));
            return null;
        }
        String updateQuery="BEGIN LMS_SETUPS_PKG.update_disability_losses(?,?,?,?,?,?,?,?);END;";
               Connection conn=null;
               try
               {
                  conn=new DBConnector().getDatabaseConn();
               CallableStatement cstmt=conn.prepareCall(updateQuery);
               cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("LDL_CODE"));
               if(lossDescription.getValue()==null) {
                   cstmt.setString(2, null);
               }
               else {
                   cstmt.setString(2, lossDescription.getValue().toString()); 
               }
               if(percentPayable.getValue()==null) {
                   cstmt.setString(3, null);  
               }
               else {
                   cstmt.setString(3, percentPayable.getValue().toString());  
               }
               if(closesPolicy.getValue()==null) {
                   cstmt.setString(4, null);  
               }
               else {
                   cstmt.setString(4, closesPolicy.getValue().toString());  
               }
               cstmt.setBigDecimal(5, (BigDecimal)session.getAttribute("PCT_CODE"));
               cstmt.setBigDecimal(6, (BigDecimal)session.getAttribute("CVTC_CODE"));
               if(weeklyIndemnity.getValue()==null) {
                   cstmt.setString(7, null);  
               }
               else {
                   cstmt.setString(7, weeklyIndemnity.getValue().toString());  
               }
               if(ldlDivisionFactor.getValue()==null) {
                   cstmt.setString(8, null);  
               }
               else {
                   cstmt.setString(8, ldlDivisionFactor.getValue().toString());  
                }
                cstmt.execute();
                cstmt.close();
                   String Message = "Record Saved successfully.";
                   FacesContext.getCurrentInstance().addMessage(null, 
                                                                new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                                 Message, 
                                                                                 Message));
                   
                   
                   
                   // session.setAttribute("RD_CODE",null);
                   session.setAttribute("LDL_CODE",null);
                   ADFUtils.findIterator("findDisabilityLossesIterator").executeQuery();
                   AdfFacesContext.getCurrentInstance().addPartialTarget(disabilityLossesLOV);
               }
               catch(Exception ex) {
                  ex.printStackTrace();
                  GlobalCC.EXCEPTIONREPORTING(conn,ex);
               }
        return null;
    }

    public void setDisabilityLossesLOV(RichTable disabilityLossesLOV) {
        this.disabilityLossesLOV = disabilityLossesLOV;
    }

    public RichTable getDisabilityLossesLOV() {
        return disabilityLossesLOV;
    }

    public void disabilityListener(SelectionEvent selectionEvent) {
        RowKeySet rowKeySet =  disCausationsLOV.getSelectedRowKeys();
                if (!rowKeySet.iterator().hasNext()) {
                    GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                }

                Object key2 = rowKeySet.iterator().next();
            disCausationsLOV.setRowKey(key2);

                JUCtrlValueBinding r = (JUCtrlValueBinding)disCausationsLOV.getRowData();

                if (r == null) {
                    GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                } 
        session.setAttribute("CVTC_CODE",r.getAttribute("cvtcCode"));
        ADFUtils.findIterator("findDisabilityLossesIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(disabilityLossesLOV);
    }

    public void setWeeklyIndemnity(RichSelectOneChoice weeklyIndemnity) {
        this.weeklyIndemnity = weeklyIndemnity;
    }

    public RichSelectOneChoice getWeeklyIndemnity() {
        return weeklyIndemnity;
    }

    public void setLdlDivisionFactor(RichSelectOneChoice ldlDivisionFactor) {
        this.ldlDivisionFactor = ldlDivisionFactor;
    }

    public RichSelectOneChoice getLdlDivisionFactor() {
        return ldlDivisionFactor;
    }

    public void setPeriodsLOV(RichTable periodsLOV) {
        this.periodsLOV = periodsLOV;
    }

    public RichTable getPeriodsLOV() {
        return periodsLOV;
    }

    public String AddPeriod() {
        session.setAttribute("PER_CODE",null);
        perID.setValue(null);
        periodName.setValue(null);
        valFrequency.setValue(null);
        periodWef.setValue(null);
        periodWet.setValue(null);
       
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:periodsPopup" +
        "').show(hints);");
        return null;
    }

    public String EditPeriod() {
        RowKeySet rowKeySet =  periodsLOV.getSelectedRowKeys();
                if (!rowKeySet.iterator().hasNext()) {
                    GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                }

                Object key2 = rowKeySet.iterator().next();
            periodsLOV.setRowKey(key2);

                JUCtrlValueBinding r = (JUCtrlValueBinding)periodsLOV.getRowData();

                if (r == null) {
                    GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                } 
        session.setAttribute("PER_CODE",r.getAttribute("perCode"));
        periodName.setValue(r.getAttribute("perName"));
        valFrequency.setValue(r.getAttribute("perValFreq"));
        periodWef.setValue(r.getAttribute("perWef"));
        periodWet.setValue(r.getAttribute("perWet"));
        perID.setValue(r.getAttribute("perId"));
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:periodsPopup" +
        "').show(hints);");
        return null;
    }

    public String DeletePeriod() {
        RowKeySet rowKeySet =  periodsLOV.getSelectedRowKeys();
                if (!rowKeySet.iterator().hasNext()) {
                    GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                }

                Object key2 = rowKeySet.iterator().next();
            periodsLOV.setRowKey(key2);

                JUCtrlValueBinding r = (JUCtrlValueBinding)periodsLOV.getRowData();

                if (r == null) {
                    GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                } 
        session.setAttribute("PER_CODE",r.getAttribute("perCode"));
        String authQuery="BEGIN LMS_SETUPS_PKG.delete_lms_period(?);END;";
        Connection conn=new DBConnector().getDatabaseConn();
        try
        {
        CallableStatement cstmt=conn.prepareCall(authQuery); 
        
        cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("PER_CODE"));
        
        cstmt.execute();
        conn.close();
            String Message = "Record deleted successfully.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            
           
            
           // session.setAttribute("RD_CODE",null);
            session.setAttribute("PER_CODE",null);
            ADFUtils.findIterator("findPeriodsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(periodsLOV);
        }
        catch(Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
        }
        return null;
    }

    public void setPeriodName(RichInputText periodName) {
        this.periodName = periodName;
    }

    public RichInputText getPeriodName() {
        return periodName;
    }

    public void setValFrequency(RichSelectOneChoice valFrequency) {
        this.valFrequency = valFrequency;
    }

    public RichSelectOneChoice getValFrequency() {
        return valFrequency;
    }

    public void setPeriodWef(RichInputDate periodWef) {
        this.periodWef = periodWef;
    }

    public RichInputDate getPeriodWef() {
        return periodWef;
    }

    public String SavePeriod() {
        String updateQuery="BEGIN LMS_SETUPS_PKG.update_lms_periods(?,?,?,?,?,?);END;";
        String wefDate=null;
        String wetDate=null;
        Connection conn=null;
        try
        {
           conn=new DBConnector().getDatabaseConn();
        CallableStatement cstmt=conn.prepareCall(updateQuery);
        cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("PER_CODE"));
        cstmt.setString(2, periodName.getValue().toString());
        if(valFrequency.getValue()==null) {
            cstmt.setString(3,null);   
        }
        else {
            cstmt.setString(3,valFrequency.getValue().toString());  
        }
            if(periodWef.getValue().toString().contains(":")){
                wefDate = GlobalCC.parseDate(periodWef.getValue().toString());
            }else{
                wefDate = GlobalCC.upDateParseDate(periodWef.getValue().toString());
            }
            if(periodWet.getValue().toString().contains(":")){
                wetDate = GlobalCC.parseDate(periodWet.getValue().toString());
            }else{
                wetDate = GlobalCC.upDateParseDate(periodWet.getValue().toString());
            }
        cstmt.setString(4, wefDate);   
        cstmt.setString(5, wetDate); 
        cstmt.setString(6,perID.getValue().toString());
                         
        cstmt.execute();
        conn.close();
        
        String Message = "Period saved Successfully.";
        FacesContext.getCurrentInstance().addMessage(null,
                                                    new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                     Message, 
                                                                     Message));
            session.setAttribute("PER_CODE",null);
            ADFUtils.findIterator("findPeriodsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(periodsLOV);
        }
        catch(Exception ex) {
           GlobalCC.EXCEPTIONREPORTING(conn,ex);
        }
        return null;
    }

    public void setPeriodWet(RichInputDate periodWet) {
        this.periodWet = periodWet;
    }

    public RichInputDate getPeriodWet() {
        return periodWet;
    }

    public void setPerID(RichInputText perID) {
        this.perID = perID;
    }

    public RichInputText getPerID() {
        return perID;
    }

    public void businessTransListener(SelectionEvent selectionEvent) {
        // Add event code here...
        RowKeySet rowKeySet =  businessTransLOV.getSelectedRowKeys();
                if (!rowKeySet.iterator().hasNext()) {
                    GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                }

                Object key2 = rowKeySet.iterator().next();
                businessTransLOV.setRowKey(key2);

                JUCtrlValueBinding r = (JUCtrlValueBinding)businessTransLOV.getRowData();

                if (r == null) {
                    GlobalCC.errorValueNotEntered("Error: No Record Selected");
                    //return null;
                } 
                
        session.setAttribute("BTR_TRANS_CODE",
                             r.getAttribute("BTR_TRANS_CODE"));
        ADFUtils.findIterator("findDrCrNarrativesIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(narrativesLOV);
    }

    public void setBusinessTransLOV(RichTable businessTransLOV) {
        this.businessTransLOV = businessTransLOV;
    }

    public RichTable getBusinessTransLOV() {
        return businessTransLOV;
    }

    public void setClauseEditor(RichInputText clauseEditor) {
        this.clauseEditor = clauseEditor;
    }

    public RichInputText getClauseEditor() {
        return clauseEditor;
    }

    public void setDrCoinNarrative(RichInputText drCoinNarrative) {
        this.drCoinNarrative = drCoinNarrative;
    }

    public RichInputText getDrCoinNarrative() {
        return drCoinNarrative;
    }

    public void setCrCoinNarrative(RichInputText crCoinNarrative) {
        this.crCoinNarrative = crCoinNarrative;
    }

    public RichInputText getCrCoinNarrative() {
        return crCoinNarrative;
    }

    public void setWithEmpyeFund(RichSelectOneChoice withEmpyeFund) {
        this.withEmpyeFund = withEmpyeFund;
    }

    public RichSelectOneChoice getWithEmpyeFund() {
        return withEmpyeFund;
    }

    public void setAgeFrom(RichInputText ageFrom) {
        this.ageFrom = ageFrom;
    }

    public RichInputText getAgeFrom() {
        return ageFrom;
    }

    public void setAgeTo(RichInputText ageTo) {
        this.ageTo = ageTo;
    }

    public RichInputText getAgeTo() {
        return ageTo;
    }

    public void setMaturityDocs(RichSelectOneChoice maturityDocs) {
        this.maturityDocs = maturityDocs;
    }

    public RichSelectOneChoice getMaturityDocs() {
        return maturityDocs;
    }

    public void actionConfirmDelete(DialogEvent dialogEvent) {
    String confirmDelete=(String)session.getAttribute("confirmDelete");
    if(confirmDelete.compareTo("RiRates")==0){
          DeleteRiRates();
    }else if(confirmDelete.compareTo("RiRatesDesc")==0){
        DeleteRiRatesDesc();
    }
    GlobalCC.hidePopup("lmsgroup:confirmDelete");
    }

    public String performDeleteRiRates() {
      GlobalCC.showPopup("lmsgroup:confirmDelete");
      session.setAttribute("confirmDelete","RiRates");
        return null;
    }

    public String performDeleteRiRatesDesc() {
        GlobalCC.showPopup("lmsgroup:confirmDelete");
        session.setAttribute("confirmDelete","RiRatesDesc");
        return null;
    }

    public void setCoinsurance_apportionment(RichInputText coinsurance_apportionment) {
        this.coinsurance_apportionment = coinsurance_apportionment;
    }

    public RichInputText getCoinsurance_apportionment() {
        return coinsurance_apportionment;
    }

    public void setMinClaimableDays(RichInputNumberSpinbox minClaimableDays) {
        this.minClaimableDays = minClaimableDays;
    }

    public RichInputNumberSpinbox getMinClaimableDays() {
        return minClaimableDays;
    }

    public void setMaxClaimableDays(RichInputNumberSpinbox maxClaimableDays) {
        this.maxClaimableDays = maxClaimableDays;
    }

    public RichInputNumberSpinbox getMaxClaimableDays() {
        return maxClaimableDays;
    }
}
