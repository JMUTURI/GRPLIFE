package com.turnkey.setups;

import com.Ostermiller.util.CSVParser;

import java.io.InputStream;
import java.io.InputStreamReader;

import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.Connection;


import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import javax.servlet.http.HttpSession;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.data.RichTree;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputNumberSpinbox;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanRadio;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.layout.RichPanelSplitter;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.output.RichOutputLabel;
import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.Key;
import oracle.jbo.Row;

import oracle.jbo.uicli.binding.JUCtrlHierNodeBinding;


import oracle.jbo.uicli.binding.JUCtrlValueBinding;

import org.apache.myfaces.trinidad.event.SelectionEvent;
import org.apache.myfaces.trinidad.model.RowKeySet;

import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

import LMSG.view.Base.ADFUtils;

import LMSG.view.Base.GlobalCC;
import LMSG.view.Base.LOVCC;

import LMSG.view.connect.DBConnector;

import oracle.adf.view.rich.event.DialogEvent;

public class setupManipulation {
    private RichTable seqTypesLOV;
    private RichTable seqTempLOV;
    private RichTable prodSeqLOV;
    private RichInputText shortDesc;
    private RichInputText desc;
    private RichSelectOneChoice seqType;
    private RichInputText lengthSeqNo;
    private RichInputText separator;
    private RichInputDate wef;
    private RichInputDate wet;
    private RichInputText order;
    private RichInputText numComponent;
    private RichTable productsLOV;
    private RichTable agentsLOV;
    private RichInputText agentIDesc;
    private RichInputText agentTypeDesc;
    private RichTable ratesLOV;
    private RichInputText rangeFrom;
    private RichInputText rangeTo;
    private RichInputText rate;
    private RichSelectOneChoice rateDesc;
    private RichInputText divFactor;
    private RichSelectOneChoice payFreq;
    private RichSelectOneChoice rateType;
    private RichInputText yearFrom;
    private RichInputText anbFrom;
    private RichInputText anbTo;
    private RichInputText maturityAge;
    private RichInputText annualRate;
    private RichInputText annualBal;
    private RichInputText duration;
    private RichInputText balPymntMnth;
    private RichInputDate annWEF;
    private RichInputDate annWET;
    private RichInputText cbMnthFrom;
    private RichInputText cbMnthTo;
    private RichInputText cbRate;
    private RichSelectOneChoice cbRateType;
    private RichInputText cbDivFac;
    private RichInputDate cbWEF;
    private RichInputDate cbWET;
    private RichSelectOneChoice intPayElement;
    private RichInputText intCreditVal;
    private RichInputText intDebitVal;
    private RichInputDate intWEF;
    private RichInputDate intWET;
    private RichInputText intRate;
    private RichInputText intDivFac;
    private RichTable premiumMasksLOV;
    private RichInputText pmID;
    private RichInputText pmDesc;
    private RichSelectOneChoice pmDefault;
    private RichInputText pmComments;
    private RichTable parameterLOV;
    private RichInputText paramVal;
    private RichInputText paramDesc;
    private RichTable FCLLOV;
    private RichInputText fcLivesFrom;
    private RichInputText fcLivesTo;
    private RichInputText fcLFactor;
    private RichInputText fcLimit;
    private RichInputDate fcLWef;
    private RichInputDate fcLWet;
    private RichInputText ttId;
    private RichInputText ttDesc;
    private RichSelectOneChoice ttTaxType;
    private RichSelectOneChoice ttApplProd;
    private RichSelectOneChoice ttApplEndr;
    private RichSelectOneChoice ttApplLevel;
    private RichSelectOneChoice ttRefund;
    private RichTable taxesLOV;
    private RichInputText txRangeFrom;
    private RichInputText txRangeTo;
    private RichInputText txAgeFrm;
    private RichInputText txAgeTo;
    private RichInputText txRate;
    private RichInputText txDivFac;
    private RichSelectOneChoice txRateType;
    private RichSelectOneChoice txApplTo;
    private RichSelectOneChoice txApplFreq;
    private RichInputText txDuration;
    private RichInputText fee;
    private RichInputText validPeriod;
    private RichInputText facDesc;
    private RichInputText facFee;
    private RichInputDate facWEF;
    private RichInputDate facWET;
    private RichTable medTestsLOV;
    private RichTable facilitatorLOV;
    private RichTable medFacilLOV;
    private RichInputText sprDesc;
    private RichInputText sprTown;
    private RichTable testsLOV;
    private RichTable masksLOV;
    private RichTable dependantsLOV;
    private RichTable termsLOV;
    private RichTable interestLOV;
    private RichInputText singleRate;
    private RichInputText multiRate;
    private RichInputText multiDivFac;
    private RichInputText constant;
    private RichInputText constantDivFac;
    private RichSelectOneChoice refund;
    private RichSelectOneChoice prorate;
    private RichTable medGrpsLOV;
    private RichTable medGrpItemsLOV;
    private RichTree trtGrpsLOV;
    private RichInputText trtShortDesc;
    private RichInputText trtDesc;
    private RichTable treatiesLOV;
    private RichTable anbLOV;
    private RichTable requirementLOV;
    private RichInputText groupDesc;
    private RichInputText increase;
    private RichTable ratingsLOV;
    private RichInputText treatyProduct;
    private RichTable treatyProductsLOV;
    private RichInputText treatyProductDisplay;
    private RichTable classOfBusinessProdLOV;
    private RichSelectOneChoice defaultTreatyProduct;
    private RichTable clbTreatyProducts;
    private RichSelectOneChoice numCompType;
    private RichInputText loanTermTo;
    private RichInputText loanTermFrom;
    private RichInputText rateFrom;
    private RichInputText rateTo;
    private RichTable lifeClassLOV;
    private RichInputText rateShtDesc;
    private RichInputText rateDescription;
    private RichInputDate rateWEF;
    private RichInputDate rateWet;
    private RichSelectOneChoice specialRateType;
    private RichInputText rangelcFrom;
    private RichSelectOneChoice ratelcType;
    private RichSelectOneChoice lcPayFreq;
    private RichSelectOneChoice lcRateType;
    private RichInputText polTermFrom;
    private RichInputText polTermTo;
    private RichInputText yearNoFrom;
    private RichInputText yearNumberTo;
    private RichInputDate lcWET;
    private RichInputDate lcWetDate;
    private RichInputText lcAnbFrom;
    private RichInputText lcAnbTo;
    private RichTable lifeCommissionLOV;
    private RichInputText lcRangeTo;
    private RichInputText lcRate;
    private RichInputText pcRangeFrom;
    private RichInputText pcRangeTo;
    private RichInputText pcRate;
    private RichSelectOneChoice pcRateDesc;
    private RichSelectOneChoice pcPayFreq;
    private RichSelectOneChoice pcRateType;
    private RichInputText pcTermFrom;
    private RichInputText pcPolicyTermTo;
    private RichInputText pcYearNoFrom;
    private RichInputText pcYearNumberTo;
    private RichInputText pcWEF;
    private RichInputDate pcWef;
    private RichInputDate pcWet;
    private RichInputText pcAnbAtEntry;
    private RichInputText pcAnbAtEntryTo;
    private RichTable pensionCommissions;
    private RichTable annualCommissionsLOV;
    private RichTree productsTree;
    private RichInputText taxTypeDesc;
    private RichSelectOneChoice applLevel;
    private RichPanelSplitter splitterPanel;
    private RichInputText cvrTypeDepDesc;
    private RichInputText lifeClassDesc;
    private RichSelectBooleanRadio lapsation;
    private RichOutputLabel reinstatement;
    private RichSelectBooleanRadio contraTransaction;
    private HtmlPanelGrid loansPanel;
    private RichTree classesTree;
    private RichOutputLabel classesLabel;
    private HtmlPanelGrid educationPanel;
    private RichTable classesLOV;
    private RichInputText schClassDesc;
    private RichTable schoolLevels;
    private RichInputText levelShtDesc;
    private RichInputText levelDesc;
    private RichInputText levelPeriod;
    private RichInputText currentClass;
    private RichSelectOneChoice classSchLevel;
    private RichInputText levelTerms;
    private RichInputText levelTermDuration;
    private RichSelectOneChoice gender;
    private RichOutputText cloneFCLProduct;
    private RichSelectOneChoice newFCLProduct;
    private HtmlPanelGrid clonePanel;
    private HtmlPanelGrid confirmPanel;
    private RichInputText yrsOfService;
    private RichTable causationTable;
    private RichInputText causationDesc;
    private RichInputText yrsOfServiceTo;
    private RichSelectOneChoice applAtCause;
    private RichCommandButton causationButton;
    private RichSelectOneChoice txApplOn;
    private RichSelectOneChoice pmRateType;
    private RichTable loadingsLOV;
    private RichInputText loadingName;
    private RichTable prodloadingLOV;
    private RichSelectOneChoice grpSingleRate;
    private RichOutputLabel premRatesLab;
    private RichInputNumberSpinbox cratCode;
    private RichInputText text;
    private RichTable ratesExportLOV;
    private RichInputText coverTypeShtDesc;
    private RichInputText coverTypeDesc;
    private RichTable coverTypeTable;
    private RichSelectOneChoice paramProdSpecific;
    private RichTree parameterProductsTree;
    private RichTable productParamTable;
    private RichOutputText prodParameterName;
    private RichInputText prodParameterValue;
    private RichSelectOneChoice exciseDuty;
    
    private RichTable currencyLOV;
    private RichSelectOneChoice medProduct;

    public setupManipulation() {
        super();
    }
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    
    public void classListener(SelectionEvent selectionEvent) {
        // Add event code here...
        try{
            DCIteratorBinding dciter = ADFUtils.findIterator("findClassesofBusinessIterator");
            RowKeySet set = selectionEvent.getAddedSet();
            Iterator rowKeySetIter = set.iterator();
            
            //System.out.println(1);
            while (rowKeySetIter.hasNext()) 
            {
                List l = (List) rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                
                session.setAttribute("ClaCode", r.getAttribute("CLA_CODE"));

                ADFUtils.findIterator("findSequenceTypesIterator").executeQuery();
              AdfFacesContext.getCurrentInstance().addPartialTarget(seqTypesLOV);
        
                
         }     
            
            
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
    }

    public void setSeqTypesLOV(RichTable seqTypesLOV) {
        this.seqTypesLOV = seqTypesLOV;
    }

    public RichTable getSeqTypesLOV() {
        return seqTypesLOV;
    }

    public void seqTypeListener(SelectionEvent selectionEvent) {
        // Add event code here...
        try{
            DCIteratorBinding dciter = ADFUtils.findIterator("findSequenceTypesIterator");
            RowKeySet set = selectionEvent.getAddedSet();
            Iterator rowKeySetIter = set.iterator();
            
            //System.out.println(1);
            while (rowKeySetIter.hasNext()) 
            {
                List l = (List) rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                
                session.setAttribute("LstCode", r.getAttribute("LST_CODE"));

                ADFUtils.findIterator("findSequenceTemplatesIterator").executeQuery();
                ADFUtils.findIterator("findProductSeqTemplatesIterator").executeQuery();
              AdfFacesContext.getCurrentInstance().addPartialTarget(seqTempLOV);
              AdfFacesContext.getCurrentInstance().addPartialTarget(prodSeqLOV);
             
        
                
         }     
            
            
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
    }
    
    public String AddSequenceType(){
        try{
 
            shortDesc.setValue(null);
            desc.setValue(null);
            seqType.setValue(null);
            lengthSeqNo.setValue(null);
            separator.setValue(null);
            wet.setValue(null);
            session.setAttribute("LstCode", null);
           
            
            // Render Popup
            ExtendedRenderKitService erkService =
            Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
            ExtendedRenderKitService.class);
            erkService.addScript(FacesContext.getCurrentInstance(),
            "var hints = {autodismissNever:false}; " +
            "AdfPage.PAGE.findComponent('" + "lmsgroup:seqTyp" +
            "').show(hints);");
            
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }
    
    public String EditSequenceType(){
      
      DCIteratorBinding dciter = ADFUtils.findIterator("findSequenceTypesIterator");
      RowKeySet set =seqTypesLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      
      //System.out.println(1);
      while (rowKeySetIter.hasNext()) 
      {
          List l = (List) rowKeySetIter.next();
          Key key = (Key)l.get(0);
          dciter.setCurrentRowWithKey(key.toStringFormat(true));
          Row r = dciter.getCurrentRow();
        
          session.setAttribute("LstCode", r.getAttribute("LST_CODE"));
          shortDesc.setValue(r.getAttribute("LST_SHT_DESC"));
          desc.setValue(r.getAttribute("LST_DESC"));
          seqType.setValue(r.getAttribute("LST_TYPE"));
          lengthSeqNo.setValue(r.getAttribute("LST_SEQ_NO_LEN"));
          separator.setValue(r.getAttribute("LST_SEPARATOR"));
          wef.setValue(r.getAttribute("LST_WEF"));
          wet.setValue(r.getAttribute("LST_WET"));
         
          
          // Render Popup
          ExtendedRenderKitService erkService =
          Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
          ExtendedRenderKitService.class);
          erkService.addScript(FacesContext.getCurrentInstance(),
          "var hints = {autodismissNever:false}; " +
          "AdfPage.PAGE.findComponent('" + "lmsgroup:seqTyp" +
          "').show(hints);");

      }
        
         
      return null;
    }
    
    public String SaveSequenceTypes() {
      try 
      {
          Boolean WEFDateChanged = false;
          Boolean WETDateChanged = false;
          
          if(wef.getValue()==null){
          }else{
              WEFDateChanged = wef.getValue().toString().contains(":");
          }
          
          if(wet.getValue()==null){
          }else{
              WETDateChanged = wet.getValue().toString().contains(":");
          }
          
          if(shortDesc.getValue()==null){
              String Message = "Enter A Short Description";
              FacesContext.getCurrentInstance().addMessage(null, 
                                                           new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                            Message, 
                                                                            Message));
              return null;
          }
          
          if(seqType.getValue()==null){
              String Message = "Enter A Sequence Type";
              FacesContext.getCurrentInstance().addMessage(null, 
                                                           new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                            Message, 
                                                                            Message));
              return null;
          }
          
          if(desc.getValue()==null){
              String Message = "Enter A Sequence Length";
              FacesContext.getCurrentInstance().addMessage(null, 
                                                           new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                            Message, 
                                                                            Message));
              return null;
          }
          
          if(lengthSeqNo.getValue()==null){
              String Message = "Enter A Sequence Length";
              FacesContext.getCurrentInstance().addMessage(null, 
                                                           new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                            Message, 
                                                                            Message));
              return null;
          }
          
          if(separator.getValue()==null){
              String Message = "Enter A Separator";
              FacesContext.getCurrentInstance().addMessage(null, 
                                                           new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                            Message, 
                                                                            Message));
              return null;
          }
          
          
          String authQuery="BEGIN LMS_SETUPS_PKG.updateSequenceTypes(?,?,?,?,?,?,?,?,?,?);END;";
          Connection conn=new DBConnector().getDatabaseConn();
          
          CallableStatement cstmt=conn.prepareCall(authQuery);    
          cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("LstCode"));
          if(shortDesc.getValue()==null){
              cstmt.setString(2, null);
          }else{
              cstmt.setString(2, shortDesc.getValue().toString());  
          }
          if(desc.getValue()==null){
              cstmt.setString(3, null);
          }else{
              cstmt.setString(3, desc.getValue().toString());  
          }
          if(seqType.getValue()==null){
              cstmt.setString(4, null);
          }else{
              cstmt.setString(4, seqType.getValue().toString());  
          }
          if(lengthSeqNo.getValue()==null){
              cstmt.setString(5, null);
          }else{
              cstmt.setString(5, lengthSeqNo.getValue().toString());  
          }
          if(separator.getValue()==null){
              cstmt.setString(6, null);
          }else{
              cstmt.setString(6, separator.getValue().toString());  
          }
          
          if(wef.getValue()==null){
              cstmt.setString(7, null);
          }else{
              if(WEFDateChanged==false){
                  cstmt.setString(7, null); 
              }else{
                  cstmt.setString(7, LOVCC.parseDate(wef.getValue().toString()));   
              }
          }
          if(wet.getValue()==null){
              cstmt.setString(8, null);
          }else{
              if(WETDateChanged==false){
                  cstmt.setString(8, null); 
              }else{
                  cstmt.setString(8, LOVCC.parseDate(wet.getValue().toString()));   
              }
          }          
          cstmt.setBigDecimal(9, (BigDecimal)session.getAttribute("ClaCode"));
          if(text.getValue()==null){
            cstmt.setString(10, null); 
          }else{
            cstmt.setString(10, text.getValue().toString()); 
          }
          cstmt.execute();
          conn.close();
          
          String Message = "Sequence Type Saved succesfully.";
          FacesContext.getCurrentInstance().addMessage(null, 
                                                       new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                        Message, 
                                                                        Message));
          
          session.setAttribute("LstCode", null);
            ADFUtils.findIterator("findSequenceTypesIterator").executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(seqTypesLOV);
            ADFUtils.findIterator("findSequenceTemplatesIterator").executeQuery();
            ADFUtils.findIterator("findProductSeqTemplatesIterator").executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(seqTempLOV);
          AdfFacesContext.getCurrentInstance().addPartialTarget(prodSeqLOV);
        
      }
      catch(Exception ex)
      {
        GlobalCC.EXCEPTIONREPORTING(null, ex);
      }
      return null;
    }
    
    public String AddSequenceTemplate(){
        try{
    
            order.setValue(null);
            numCompType.setValue(null);
            session.setAttribute("LntCode", null);
           
            
            // Render Popup
            ExtendedRenderKitService erkService =
            Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
            ExtendedRenderKitService.class);
            erkService.addScript(FacesContext.getCurrentInstance(),
            "var hints = {autodismissNever:false}; " +
            "AdfPage.PAGE.findComponent('" + "lmsgroup:seqTemplate" +
            "').show(hints);");
            
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }
    
    public String EditSequenceTemplate(){
      
      DCIteratorBinding dciter = ADFUtils.findIterator("findSequenceTemplatesIterator");
      RowKeySet set =seqTempLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      
      //System.out.println(1);
      while (rowKeySetIter.hasNext()) 
      {
          List l = (List) rowKeySetIter.next();
          Key key = (Key)l.get(0);
          dciter.setCurrentRowWithKey(key.toStringFormat(true));
          Row r = dciter.getCurrentRow();
        
          session.setAttribute("LntCode", r.getAttribute("LNT_CODE"));
          order.setValue(r.getAttribute("LNT_ORDER"));
          numCompType.setValue(r.getAttribute("LNT_ITEM_ID"));

          // Render Popup
          ExtendedRenderKitService erkService =
          Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
          ExtendedRenderKitService.class);
          erkService.addScript(FacesContext.getCurrentInstance(),
          "var hints = {autodismissNever:false}; " +
          "AdfPage.PAGE.findComponent('" + "lmsgroup:seqTemplate" +
          "').show(hints);");

      }
        
         
      return null;
    }
    
    public String SaveSequenceTemplate() {
      Connection conn=new DBConnector().getDatabaseConn();
      try 
      {
          
          if(numCompType.getValue()==null){
              String Message = "Enter A Number Component";
              FacesContext.getCurrentInstance().addMessage(null, 
                                                           new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                            Message, 
                                                                            Message));
              return null;
          }
          
          if(order.getValue()==null){
              String Message = "Enter An Order";
              FacesContext.getCurrentInstance().addMessage(null, 
                                                           new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                            Message, 
                                                                            Message));
              return null;
          }
         
          
          String authQuery="BEGIN LMS_SETUPS_PKG.updateSequenceTemplate(?,?,?,?,?);END;";
         
          
          CallableStatement cstmt=conn.prepareCall(authQuery);    
          cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("LntCode"));
          if(order.getValue()==null){
              cstmt.setString(2, null);
          }else{
              cstmt.setString(2, order.getValue().toString());  
          }
          if(numCompType.getValue()==null){
              cstmt.setString(3, null);
          }else{
              cstmt.setString(3, numCompType.getValue().toString());  
          }
          cstmt.setBigDecimal(4, (BigDecimal)session.getAttribute("LstCode"));
          cstmt.setBigDecimal(5, (BigDecimal)session.getAttribute("ClaCode"));
          cstmt.execute();
          conn.close();
          
          String Message = "Sequence Template Saved succesfully.";
          FacesContext.getCurrentInstance().addMessage(null, 
                                                       new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                        Message, 
                                                                        Message));
          
          session.setAttribute("LntCode", null);
            ADFUtils.findIterator("findSequenceTemplatesIterator").executeQuery();
            ADFUtils.findIterator("findProductSeqTemplatesIterator").executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(seqTempLOV);
          AdfFacesContext.getCurrentInstance().addPartialTarget(prodSeqLOV);
        
      }
      catch(Exception ex)
      {
        GlobalCC.EXCEPTIONREPORTING(conn, ex);
      }
      return null;
    }
    
    public String SaveSequenceproduct() {
      try 
      {
          DCIteratorBinding dciter = ADFUtils.findIterator("findProductsIterator");
          RowKeySet set =productsLOV.getSelectedRowKeys();
          Iterator rowKeySetIter = set.iterator();
        Connection conn=new DBConnector().getDatabaseConn();
          
          //System.out.println(1);
          while (rowKeySetIter.hasNext()) 
          {
              List l = (List) rowKeySetIter.next();
              Key key = (Key)l.get(0);
              dciter.setCurrentRowWithKey(key.toStringFormat(true));
              Row r = dciter.getCurrentRow();
            
              session.setAttribute("ProductCode", r.getAttribute("PROD_CODE"));
              
              String authQuery="BEGIN LMS_SETUPS_PKG.add_product_sequence(?,?);END;";
              //Connection conn=new DBConnector().getDatabaseConn();
              
              CallableStatement cstmt=conn.prepareCall(authQuery);    
              cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("ProductCode"));
              cstmt.setBigDecimal(2, (BigDecimal)session.getAttribute("LstCode"));
           
              cstmt.execute();
             

          }
        conn.close();
          session.setAttribute("ProductCode", null);
            ADFUtils.findIterator("findSequenceTemplatesIterator").executeQuery();
            ADFUtils.findIterator("findProductSeqTemplatesIterator").executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(seqTempLOV);
          AdfFacesContext.getCurrentInstance().addPartialTarget(prodSeqLOV);
        
      }
      catch(Exception ex)
      {
        GlobalCC.EXCEPTIONREPORTING(null, ex);
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
              
          }else if(Value.equalsIgnoreCase("delSeqType")){
            //Delete The Sequence Type...
            Result = DeleteSequenceType();
          }else if(Value.equalsIgnoreCase("delSeqTemplate")){
              //Delete the Sequence Template...
            Result = DeleteSequenceTemplate();
          }else if(Value.equalsIgnoreCase("delSeqProduct")){
            //Deletes The Sequence Template..
            Result = DeleteSequenceproduct();
          }else if(Value.equalsIgnoreCase("delTaxTypes")){
            //Deletes the Tax Types..
            Result = DeleteTaxTypes();
          }else if(Value.equalsIgnoreCase("delTaxRates")){
            //Delete Tax Rates...
            Result = DeleteTaxRates();
          }else if(Value.equalsIgnoreCase("delMedTests")){
            //Delete Medical Tests...
            Result = DeleteMedicalTests();
          }else if(Value.equalsIgnoreCase("delFacilTests")){
            //Delete Facilitator Tests...
            Result = DeleteFacilitatorTests();
          }else if(Value.equalsIgnoreCase("delMedGroup")){
            //Delete Medical Group...
            Result = DeleteMedicalGroup();
          }else if(Value.equalsIgnoreCase("delMedGroupItem")){
              //Delete Medical Group Item...
            Result = DeleteMedicalGroupItem();
          }else if(Value.equalsIgnoreCase("delMedAnb")){
            //Delete Medical requirementment ANB
            Result = DeleteANB();
          }else if(Value.equalsIgnoreCase("delMedReq")){
            //Delete Medical Requirements...
            Result = DeleteMedRequirements();
          }else if(Value.equalsIgnoreCase("delMedRating")){
            //Delete Medical Ratings...
            Result = DeleteMedicalRating();
          }
            
            if (Result == null){
              return null;
            }else if(Result.equalsIgnoreCase("F")){
              return null;
            }else{
                GlobalCC.hidePopup("lmsgroup:confirmDel");
            }

          
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }
    
    public String DeleteSequenceType() {
        String Result = "F";
      try 
      {
          
          DCIteratorBinding dciter = ADFUtils.findIterator("findSequenceTypesIterator");
          RowKeySet set =seqTypesLOV.getSelectedRowKeys();
          Iterator rowKeySetIter = set.iterator();
          
          //System.out.println(1);
          while (rowKeySetIter.hasNext()) 
          {
              List l = (List) rowKeySetIter.next();
              Key key = (Key)l.get(0);
              dciter.setCurrentRowWithKey(key.toStringFormat(true));
              Row r = dciter.getCurrentRow();
            
              session.setAttribute("LstCode", r.getAttribute("LST_CODE"));
              
              String authQuery="BEGIN LMS_SETUPS_PKG.deleteseqtype(?);END;";
              Connection conn=new DBConnector().getDatabaseConn();
              
              CallableStatement cstmt=conn.prepareCall(authQuery);    
              cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("LstCode"));
           
              cstmt.execute();
              conn.close();

          }
          session.setAttribute("LstCode", null);
            ADFUtils.findIterator("findSequenceTypesIterator").executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(seqTypesLOV);
            ADFUtils.findIterator("findSequenceTemplatesIterator").executeQuery();
            ADFUtils.findIterator("findProductSeqTemplatesIterator").executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(seqTempLOV);
          AdfFacesContext.getCurrentInstance().addPartialTarget(prodSeqLOV);
            GlobalCC.INFORMATIONREPORTING("Record Successfully Deleted");
          Result = "S";
        
      }
      catch(Exception ex)
      {
        GlobalCC.EXCEPTIONREPORTING(null, ex);
      }
      return Result;
    }
    
    public String DeleteSequenceTemplate() {
        String Result = "F";
      try 
      {
          DCIteratorBinding dciter = ADFUtils.findIterator("findSequenceTemplatesIterator");
          RowKeySet set =seqTempLOV.getSelectedRowKeys();
          Iterator rowKeySetIter = set.iterator();
          
          //System.out.println(1);
          while (rowKeySetIter.hasNext()) 
          {
              List l = (List) rowKeySetIter.next();
              Key key = (Key)l.get(0);
              dciter.setCurrentRowWithKey(key.toStringFormat(true));
              Row r = dciter.getCurrentRow();
            
              session.setAttribute("LntCode", r.getAttribute("LNT_CODE"));
              
              String authQuery="BEGIN LMS_SETUPS_PKG.deleteseqtemplate(?);END;";
              Connection conn=new DBConnector().getDatabaseConn();
              
              CallableStatement cstmt=conn.prepareCall(authQuery);    
              cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("LntCode"));
           
              cstmt.execute();
              conn.close();

          }
          session.setAttribute("LntCode", null);
            ADFUtils.findIterator("findSequenceTypesIterator").executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(seqTypesLOV);
            ADFUtils.findIterator("findSequenceTemplatesIterator").executeQuery();
            ADFUtils.findIterator("findProductSeqTemplatesIterator").executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(seqTempLOV);
          AdfFacesContext.getCurrentInstance().addPartialTarget(prodSeqLOV);
            GlobalCC.INFORMATIONREPORTING("Record Successfully Deleted");
        Result = "S";
      }
      catch(Exception ex)
      {
        GlobalCC.EXCEPTIONREPORTING(null, ex);
      }
      return Result;
    }
    
    public String DeleteSequenceproduct() {
        String Result = "F";
      Connection conn=new DBConnector().getDatabaseConn();
      try 
      {
       
          DCIteratorBinding dciter = ADFUtils.findIterator("findProductSeqTemplatesIterator");
          RowKeySet set =prodSeqLOV.getSelectedRowKeys();
          Iterator rowKeySetIter = set.iterator();
        
          
          //System.out.println(1);
          while (rowKeySetIter.hasNext()) 
          {
              List l = (List) rowKeySetIter.next();
              Key key = (Key)l.get(0);
              dciter.setCurrentRowWithKey(key.toStringFormat(true));
              Row r = dciter.getCurrentRow();
            
              session.setAttribute("PstCode", r.getAttribute("PST_CODE"));
              
              String authQuery="BEGIN LMS_SETUPS_PKG.deleteprodseqtemplate(?);END;";
              
              CallableStatement cstmt=conn.prepareCall(authQuery);    
              cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("PstCode"));
           
              cstmt.execute();

          }
        conn.close();
          session.setAttribute("PstCode", null);
            ADFUtils.findIterator("findSequenceTypesIterator").executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(seqTypesLOV);
            ADFUtils.findIterator("findSequenceTemplatesIterator").executeQuery();
            ADFUtils.findIterator("findProductSeqTemplatesIterator").executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(seqTempLOV);
          AdfFacesContext.getCurrentInstance().addPartialTarget(prodSeqLOV);
            GlobalCC.INFORMATIONREPORTING("Record Successfully Deleted");
        Result = "S";
        
      }
      catch(Exception ex)
      {
        GlobalCC.EXCEPTIONREPORTING(conn, ex);
      }
      return Result;
    }
    
    public void class1Listener(SelectionEvent selectionEvent) {
        // Add event code here...
        try{
            DCIteratorBinding dciter = ADFUtils.findIterator("findClassesofBusinessIterator");
            RowKeySet set = selectionEvent.getAddedSet();
            Iterator rowKeySetIter = set.iterator();
            
            //System.out.println(1);
            while (rowKeySetIter.hasNext()) 
            {
                List l = (List) rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                
                session.setAttribute("ClaCode", r.getAttribute("CLA_CODE"));
               
             session.setAttribute("ProductCode", null);
                ADFUtils.findIterator("findProductsIterator").executeQuery();
              AdfFacesContext.getCurrentInstance().addPartialTarget(productsLOV);
            
             Integer SetupScreen = (Integer)session.getAttribute("SetupScrnID");
            //Premium Masks
             if(SetupScreen == 3){
                    ADFUtils.findIterator("findPremiumMasksIterator").executeQuery();
                 AdfFacesContext.getCurrentInstance().addPartialTarget(premiumMasksLOV);               
             }
             //FCL Factor Limits
             else if(SetupScreen == 5){
                    ADFUtils.findIterator("findFCLFactorsIterator").executeQuery();
                 AdfFacesContext.getCurrentInstance().addPartialTarget(FCLLOV);   
             }
        
                
         }     
            
            
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
    }
    
    public void productsListener(SelectionEvent selectionEvent) {
        // Add event code here...
        try{
            DCIteratorBinding dciter = ADFUtils.findIterator("findProductsIterator");
            RowKeySet set = selectionEvent.getAddedSet();
            Iterator rowKeySetIter = set.iterator();
            
            //System.out.println(1);
            while (rowKeySetIter.hasNext()) 
            {
                List l = (List) rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                
                session.setAttribute("ProductCode", r.getAttribute("PROD_CODE"));
                
                Integer SetupScreen = (Integer)session.getAttribute("SetupScrnID");
                
                //Premium Masks
                if(SetupScreen == 3){
                    ADFUtils.findIterator("findPremiumMasksIterator").executeQuery();
                    AdfFacesContext.getCurrentInstance().addPartialTarget(premiumMasksLOV);               
                }
                 //FCL Factor Limits
                 else if(SetupScreen == 5){
                    ADFUtils.findIterator("findFCLFactorsIterator").executeQuery();
                     AdfFacesContext.getCurrentInstance().addPartialTarget(FCLLOV);   
                 }
                 

         }     
            
            
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
    }
    
    public void ProductTreeListener(SelectionEvent selectionEvent) {
        // Add event code here...
        if (selectionEvent.getAddedSet() != selectionEvent.getRemovedSet()) {
               RowKeySet keys = selectionEvent.getAddedSet();
               if (keys != null && keys.getSize() > 0) {
                   for (Object treeRowKey : keys) {
                       productsTree.setRowKey(treeRowKey);
                       JUCtrlHierNodeBinding nd =
                           (JUCtrlHierNodeBinding)productsTree.getRowData();
                 
                   session.setAttribute("ProductCode", nd.getRow().getAttribute("PROD_CODE"));   
                  
                   Integer SetupScreen = (Integer)session.getAttribute("SetupScrnID");

                    //Premium Masks
                    if (SetupScreen == 3) {
                        ADFUtils.findIterator("findPremiumMasksIterator").executeQuery();
                        AdfFacesContext.getCurrentInstance().addPartialTarget(premiumMasksLOV);
                    }
                    //FCL Factor Limits
                    else if (SetupScreen == 5) {
                        cloneFCLProduct.setValue(nd.getRow().getAttribute("PROD_DESC"));
                        ADFUtils.findIterator("findFCLFactorsIterator").executeQuery();
                        AdfFacesContext.getCurrentInstance().addPartialTarget(FCLLOV);
                    }
                    //Tax Rates
                    else if (SetupScreen == 6) {
                        ADFUtils.findIterator("findTaxRatesIterator").executeQuery();
                        AdfFacesContext.getCurrentInstance().addPartialTarget(ratesLOV);
                    }
                    //Premium Rates
                    else if (SetupScreen == 7) {
                        ADFUtils.findIterator("findProductDependantsIterator").executeQuery();
                        AdfFacesContext.getCurrentInstance().addPartialTarget(dependantsLOV);
                        ADFUtils.findIterator("findPremiumMasksIterator").executeQuery();
                        AdfFacesContext.getCurrentInstance().addPartialTarget(masksLOV);
                    }
                  
                 }
               }
        }
    }
    
  public void ProductCoversTreeListener(SelectionEvent selectionEvent) {
      // Add event code here...
      if (selectionEvent.getAddedSet() != selectionEvent.getRemovedSet()) {
          RowKeySet keys = selectionEvent.getAddedSet(); 
          if (keys != null && keys.getSize() > 0) {
              for (Object treeRowKey : keys) {
                  productsTree.setRowKey(treeRowKey);
                  JUCtrlHierNodeBinding nd =
                      (JUCtrlHierNodeBinding)productsTree.getRowData();

                  if (nd.getRow().getAttribute("type").equals("P")) {
                      session.setAttribute("ProductCode", nd.getRow().getAttribute("PROD_CODE"));
                      session.setAttribute("pctCode", null);
                      
                  } else if (nd.getRow().getAttribute("type").equals("S")) {
                      session.setAttribute("ProductCode", nd.getParent().getRow().getAttribute("PROD_CODE"));
                      session.setAttribute("pctCode", nd.getRow().getAttribute("PCT_CODE"));
                      
                  }
                  
               Integer SetupScreen = (Integer)session.getAttribute("SetupScrnID");

               //Premium Masks
               if (SetupScreen == 3) {
                   ADFUtils.findIterator("findPremiumMasksIterator").executeQuery();
                   AdfFacesContext.getCurrentInstance().addPartialTarget(premiumMasksLOV);
               }
               //FCL Factor Limits
               else if (SetupScreen == 5) {
                   cloneFCLProduct.setValue(nd.getRow().getAttribute("PROD_DESC"));
                   ADFUtils.findIterator("findFCLFactorsIterator").executeQuery();
                   AdfFacesContext.getCurrentInstance().addPartialTarget(FCLLOV);
               }
               //Tax Rates
               else if (SetupScreen == 6) {
                   ADFUtils.findIterator("findTaxRatesIterator").executeQuery();
                   AdfFacesContext.getCurrentInstance().addPartialTarget(ratesLOV);
               }
               //Premium Rates
               else if (SetupScreen == 7) {
                   ADFUtils.findIterator("findProductDependantsIterator").executeQuery();
                   AdfFacesContext.getCurrentInstance().addPartialTarget(dependantsLOV);
                   ADFUtils.findIterator("findPremiumMasksIterator").executeQuery();
                   AdfFacesContext.getCurrentInstance().addPartialTarget(masksLOV);
               }
            }
          }
      }
      
  }
    
    
    public void CommProductTreeListener(SelectionEvent selectionEvent) {
        // Add event code here...
        if (selectionEvent.getAddedSet() != selectionEvent.getRemovedSet()) {
               RowKeySet keys = selectionEvent.getAddedSet();
               if (keys != null && keys.getSize() > 0) {
                   for (Object treeRowKey : keys) {
                       productsTree.setRowKey(treeRowKey);
                       JUCtrlHierNodeBinding nd =
                           (JUCtrlHierNodeBinding)productsTree.getRowData();
         
                     session.setAttribute("ProductCode", nd.getRow().getAttribute("PROD_CODE"));
                     session.setAttribute("ProductCommCvrParam", nd.getRow().getAttribute("PROD_COMM_CVR_PARAM"));
                     session.setAttribute("pctCode", null);
                    // coverTypeShtDesc.setValue(null);
                     //coverTypeDesc.setValue(null);

                    ADFUtils.findIterator("findCommissionRatesIterator").executeQuery();
                     AdfFacesContext.getCurrentInstance().addPartialTarget(lifeCommissionLOV);
                    ADFUtils.findIterator("findPensionCommissionRatesIterator").executeQuery();
                     AdfFacesContext.getCurrentInstance().addPartialTarget(pensionCommissions);
                    ADFUtils.findIterator("findCommissionAnnualisationIterator").executeQuery();
                     AdfFacesContext.getCurrentInstance().addPartialTarget(annualCommissionsLOV);
                   //ADFUtils.findIterator("findProdCoverTypesIterator").executeQuery();
                   // AdfFacesContext.getCurrentInstance().addPartialTarget(coverTypeTable);
                  //// AdfFacesContext.getCurrentInstance().addPartialTarget(coverTypeShtDesc);
                  // AdfFacesContext.getCurrentInstance().addPartialTarget(coverTypeDesc);
               }
        }
    }
    }
    
    public String AddSchoolClass(){
        try{
            if(session.getAttribute("ProductCode")==null){
                GlobalCC.INFORMATIONREPORTING("Select A Product");
              return null;
            }
          session.setAttribute("action", "A");
          shortDesc.setValue(null);
          desc.setValue(null);
          session.setAttribute("schCode", null);
          classSchLevel.setValue(null);
          currentClass.setValue(null);
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }
    
  public String AddSchoollevel(){
      try{
         
        session.setAttribute("action", "A");
        levelShtDesc.setValue(null);
        levelDesc.setValue(null);
        levelPeriod.setValue(null);
        session.setAttribute("schLevel", null);
      }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null, e);
      }
      return null;
  }
  public void schoolLevelListener(SelectionEvent selectionEvent) {
      // Add event code here...
      try {
      RowKeySet rowKeySet = schoolLevels.getSelectedRowKeys();
      if (rowKeySet == null) {
          return;
      }
      if (!rowKeySet.iterator().hasNext()) //no selection
      {
                GlobalCC.errorValueNotEntered("No Record Selected");
          return;
      }
      Object key2 = rowKeySet.iterator().next();
      schoolLevels.setRowKey(key2);
      JUCtrlValueBinding nodeBinding =
          (JUCtrlValueBinding)schoolLevels.getRowData();
      if (nodeBinding == null) {
                GlobalCC.errorValueNotEntered("No Record Selected");
          return;
      }
      
        
        session.setAttribute("action", "E");
        
        session.setAttribute("schLevel", nodeBinding.getAttribute("SLVL_CODE"));
        
        levelShtDesc.setValue(nodeBinding.getAttribute("SLVL_SHT_DESC"));
        levelDesc.setValue(nodeBinding.getAttribute("SLVL_DESC"));
        levelPeriod.setValue(nodeBinding.getAttribute("SLVL_PERIOD"));
        levelTerms.setValue(nodeBinding.getAttribute("SLVL_NO_TERMS"));
        levelTermDuration.setValue(nodeBinding.getAttribute("SLVL_TERM_DURATION"));
      
      }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null, e);
      }
  }
  
    public String DeleteSchoollevel(){
      try{
        RowKeySet rowKeySet = schoolLevels.getSelectedRowKeys();
        if (rowKeySet == null) {
            return null;
        }
        if (!rowKeySet.iterator().hasNext()) //no selection
        {
                GlobalCC.errorValueNotEntered("No Record Selected");
            return null;
        }
        Object key2 = rowKeySet.iterator().next();
        schoolLevels.setRowKey(key2);
        JUCtrlValueBinding nodeBinding =
            (JUCtrlValueBinding)schoolLevels.getRowData();
        if (nodeBinding == null) {
                GlobalCC.errorValueNotEntered("No Record Selected");
            return null;
        }
        session.setAttribute("schLevel", nodeBinding.getAttribute("SLVL_CODE"));
          
        session.setAttribute("action", "D");
        SaveSchoolLevel();
        levelShtDesc.setValue(null);
        levelDesc.setValue(null);
        levelPeriod.setValue(null);
      }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null, e);
      }
      return null;
    }
    
    public String SaveSchoolLevel(){
      Connection conn = null;
        try{
          String authQuery="BEGIN LMS_SETUPS_PKG.save_school_level(?,?,?,?,?,?,?);END;";
          conn=new DBConnector().getDatabaseConn();
          CallableStatement cstmt=conn.prepareCall(authQuery);  
          cstmt.setString(1, (String)session.getAttribute("action"));
          cstmt.setBigDecimal(2, (BigDecimal)session.getAttribute("schLevel"));
          if(levelShtDesc.getValue()==null){
            cstmt.setString(3, null);
          }else{
            cstmt.setString(3, levelShtDesc.getValue().toString());   
          }
          if(levelDesc.getValue()==null){
            cstmt.setString(4, null);
          }else{
            cstmt.setString(4, levelDesc.getValue().toString());   
          }
          if(levelPeriod.getValue()==null){
            cstmt.setString(5, null);
          }else{
            cstmt.setString(5, levelPeriod.getValue().toString());   
          }
          if(levelTerms.getValue()==null){
            cstmt.setString(6, null);
          }else{
            cstmt.setString(6, levelTerms.getValue().toString());   
          }
          if(levelTermDuration.getValue()==null){
            cstmt.setString(7, null);
          }else{
            cstmt.setString(7, levelTermDuration.getValue().toString());   
          }
          
          cstmt.execute();
            ADFUtils.findIterator("findSchoolLevelsIterator").executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(schoolLevels);
          AdfFacesContext.getCurrentInstance().addPartialTarget(classSchLevel);    
          conn.close();
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }
    
  public String DeleteSchoolClass() {
      try {
        if (this.session.getAttribute("schCode") == null) {
                GlobalCC.INFORMATIONREPORTING("Select A Class");
          return null;
        }
        this.session.setAttribute("action", "D");
        SaveSchoolClass();
        this.shortDesc.setValue(null);
        this.desc.setValue(null);
      } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
      }
      return null;
    }

    public String SaveSchoolClass() {
      Connection conn = null;
      try {
        String authQuery = "BEGIN LMS_SETUPS_PKG.save_school_class(?,?,?,?,?,?,?);END;";
        conn = new DBConnector().getDatabaseConn();
        CallableStatement cstmt = conn.prepareCall(authQuery);
        cstmt.setString(1, (String)session.getAttribute("action"));
        cstmt.setBigDecimal(2, (BigDecimal)session.getAttribute("schCode"));
        cstmt.setBigDecimal(3, (BigDecimal)session.getAttribute("ProductCode"));
        if (shortDesc.getValue() == null)
          cstmt.setString(4, null);
        else {
          cstmt.setString(4, shortDesc.getValue().toString());
        }
        if (desc.getValue() == null)
          cstmt.setString(5, null);
        else {
          cstmt.setString(5, desc.getValue().toString());
        }
        if (currentClass.getValue() == null)
          cstmt.setString(6, null);
        else {
          cstmt.setString(6, currentClass.getValue().toString());
        }
        cstmt.setBigDecimal(7, (BigDecimal)session.getAttribute("ClassSchLevel"));

        cstmt.execute();
            ADFUtils.findIterator("findAllProductsAndSchClassesIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.classesTree);
        conn.close();
      } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
      }
      return null;
    }
    
  public void ProductSchClassesTreeListener(SelectionEvent selectionEvent) {
      // Add event code here...
      if (selectionEvent.getAddedSet() != selectionEvent.getRemovedSet()) {
          RowKeySet keys = selectionEvent.getAddedSet(); 
          if (keys != null && keys.getSize() > 0) {
              for (Object treeRowKey : keys) {
                  classesTree.setRowKey(treeRowKey);
                  JUCtrlHierNodeBinding nd =
                      (JUCtrlHierNodeBinding)classesTree.getRowData();

                  if (nd.getRow().getAttribute("type").equals("P")) {
                      session.setAttribute("ProductCode", nd.getRow().getAttribute("PROD_CODE"));
                      session.setAttribute("productType", nd.getRow().getAttribute("PROD_TYPE"));
                      shortDesc.setValue(null);
                      desc.setValue(null);
                      session.setAttribute("schCode", null);
                      session.setAttribute("action", "A");
                      classSchLevel.setValue(null);
                      currentClass.setValue(null);
                  } else if (nd.getRow().getAttribute("type").equals("S")) {
                      session.setAttribute("ProductCode", nd.getParent().getRow().getAttribute("PROD_CODE"));
                      session.setAttribute("productType", nd.getParent().getRow().getAttribute("PROD_TYPE"));
                      session.setAttribute("schCode", nd.getRow().getAttribute("SCH_CODE"));
                      shortDesc.setValue(nd.getRow().getAttribute("SCH_SHT_DESC"));
                      desc.setValue(nd.getRow().getAttribute("SCH_DESC"));
                      
                      session.setAttribute("ClassSchLevel", nd.getRow().getAttribute("SCH_LEVEL"));
                      //classSchLevel.setValue(session.getAttribute("ClassSchLevel"));
                      //AdfFacesContext.getCurrentInstance().addPartialTarget(classSchLevel);
                      
                     
                      currentClass.setValue(nd.getRow().getAttribute("SCH_PERIOD"));
                      
                      session.setAttribute("action", "E");
                  }   
            }
          }
      }
      
  }
    
    public void ProductMaskTreeListener(SelectionEvent selectionEvent) {
        // Add event code here...
        if (selectionEvent.getAddedSet() != selectionEvent.getRemovedSet()) {
            RowKeySet keys = selectionEvent.getAddedSet(); 
            if (keys != null && keys.getSize() > 0) {
                for (Object treeRowKey : keys) {
                    productsTree.setRowKey(treeRowKey);
                    JUCtrlHierNodeBinding nd =
                        (JUCtrlHierNodeBinding)productsTree.getRowData();

                    if (nd.getRow().getAttribute("type").equals("P")) {
                        session.setAttribute("ProductCode", nd.getRow().getAttribute("PROD_CODE"));
                        session.setAttribute("productType", nd.getRow().getAttribute("PROD_TYPE"));
                        
                        session.setAttribute("pmasCode", null);
                    } else if (nd.getRow().getAttribute("type").equals("S")) {
                        session.setAttribute("saveprodstatus", "1");
                        session.setAttribute("ProductCode", nd.getParent().getRow().getAttribute("PROD_CODE"));
                        session.setAttribute("productType", nd.getParent().getRow().getAttribute("PROD_TYPE"));
                        session.setAttribute("pmasCode", nd.getRow().getAttribute("PMAS_CODE"));
                    }
                    
                   String ProdType = (String)session.getAttribute("productType");
                    if(ProdType.equalsIgnoreCase("LOAN")){
                        loansPanel.setRendered(true); 
                        educationPanel.setRendered(false); 
                        classesLabel.setRendered(false); 
                        session.setAttribute("schCode", null);
                    }else if(ProdType.equalsIgnoreCase("EDUC")){
                          educationPanel.setRendered(true); 
                          classesLabel.setRendered(true); 
                          loansPanel.setRendered(false);
                        ADFUtils.findIterator("findSchClassesIterator").executeQuery();
                        AdfFacesContext.getCurrentInstance().addPartialTarget(classesLOV);
                        session.setAttribute("schCode", null);
                        schClassDesc.setValue(null);
                      }else{
                        loansPanel.setRendered(false);
                        educationPanel.setRendered(false); 
                        classesLabel.setRendered(false); 
                        session.setAttribute("schCode", null);
                      }


                    ADFUtils.findIterator("findProductDependantsIterator").executeQuery();
                 AdfFacesContext.getCurrentInstance().addPartialTarget(dependantsLOV);
            
                  
                  
                  session.setAttribute("pctCode", null);
                  session.setAttribute("dtyCode", null);
                  session.setAttribute("dtyShtDesc",null);
                  session.setAttribute("cvtCode", null);
                  session.setAttribute("cvtShtDesc", null);
                  cvrTypeDepDesc.setValue(null);
                  session.setAttribute("pcdCode",null);
                  session.setAttribute("pctCode", null);
                  session.setAttribute("dtyCode", null);
                  session.setAttribute("dtyShtDesc", null);
                  session.setAttribute("cvtCode", null);
                  session.setAttribute("cvtShtDesc", null);

                    ADFUtils.findIterator("findPremiumInterestRatesIterator").executeQuery();
                    ADFUtils.findIterator("findPremiumRateTermsIterator").executeQuery();
                  AdfFacesContext.getCurrentInstance().addPartialTarget(interestLOV);
                  AdfFacesContext.getCurrentInstance().addPartialTarget(termsLOV);
                    ADFUtils.findIterator("findPremiumRatesIterator").executeQuery();
                  AdfFacesContext.getCurrentInstance().addPartialTarget(ratesLOV);
              }
            }
        }
        
    }
  public void ProductLoadingTreeListener(SelectionEvent selectionEvent) {
      // Add event code here...
      if (selectionEvent.getAddedSet() != selectionEvent.getRemovedSet()) {
          RowKeySet keys = selectionEvent.getAddedSet(); 
          if (keys != null && keys.getSize() > 0) {
              for (Object treeRowKey : keys) {
                  productsTree.setRowKey(treeRowKey);
                  JUCtrlHierNodeBinding nd =
                      (JUCtrlHierNodeBinding)productsTree.getRowData();

                  if (nd.getRow().getAttribute("type").equals("P")) {
                      session.setAttribute("ProductCode", nd.getRow().getAttribute("PROD_CODE"));
                      session.setAttribute("productType", nd.getRow().getAttribute("PROD_TYPE"));
                      
                      session.setAttribute("pmasCode", null);
                  } else if (nd.getRow().getAttribute("type").equals("S")) {
                      session.setAttribute("saveprodstatus", "1");
                      session.setAttribute("ProductCode", nd.getParent().getRow().getAttribute("PROD_CODE"));
                      session.setAttribute("productType", nd.getParent().getRow().getAttribute("PROD_TYPE"));
                      session.setAttribute("pmasCode", nd.getRow().getAttribute("PMAS_CODE"));
                  }
                  
                 String ProdType = (String)session.getAttribute("productType");
             
               ADFUtils.findIterator("findProductDependantsIterator").executeQuery();
               AdfFacesContext.getCurrentInstance().addPartialTarget(dependantsLOV);
          
                
                
                session.setAttribute("pctCode", null);
                session.setAttribute("dtyCode", null);
                session.setAttribute("dtyShtDesc",null);
                session.setAttribute("cvtCode", null);
                session.setAttribute("cvtShtDesc", null);
                cvrTypeDepDesc.setValue(null);
                session.setAttribute("pcdCode",null);
                session.setAttribute("pctCode", null);
                session.setAttribute("dtyCode", null);
                session.setAttribute("dtyShtDesc", null);
                session.setAttribute("cvtCode", null);
                session.setAttribute("cvtShtDesc", null);

                ADFUtils.findIterator("findImportLoadingRatesIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(loadingsLOV);
            }
          }
      }
      
  }
    
    public void AllproductsListener(SelectionEvent selectionEvent) {
        // Add event code here...
        try{
            DCIteratorBinding dciter = ADFUtils.findIterator("findAllProductsIterator");
            RowKeySet set = selectionEvent.getAddedSet();
            Iterator rowKeySetIter = set.iterator();
            
            //System.out.println(1);
            while (rowKeySetIter.hasNext()) 
            {
                List l = (List) rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                
                session.setAttribute("ProductCode", r.getAttribute("PROD_CODE"));
                
                Integer SetupScreen = (Integer)session.getAttribute("SetupScrnID");
                
                //Premium Masks
                if(SetupScreen == 3){
                    ADFUtils.findIterator("findPremiumMasksIterator").executeQuery();
                    AdfFacesContext.getCurrentInstance().addPartialTarget(premiumMasksLOV);               
                }
                 //FCL Factor Limits
                 else if(SetupScreen == 5){
                    ADFUtils.findIterator("findFCLFactorsIterator").executeQuery();
                     AdfFacesContext.getCurrentInstance().addPartialTarget(FCLLOV);   
                 } 
                //Tax Rates
                else if(SetupScreen == 6){
                    ADFUtils.findIterator("findTaxRatesIterator").executeQuery();
                     AdfFacesContext.getCurrentInstance().addPartialTarget(ratesLOV);   
                 }
             //Premium Rates
             else if(SetupScreen == 7){
                    ADFUtils.findIterator("findProductDependantsIterator").executeQuery();
                  AdfFacesContext.getCurrentInstance().addPartialTarget(dependantsLOV);
                    ADFUtils.findIterator("findPremiumMasksIterator").executeQuery();
                  AdfFacesContext.getCurrentInstance().addPartialTarget(masksLOV);
              }


         }     
            
            
        }catch(Exception e){
            e.printStackTrace();
           // GlobalCC.EXCEPTIONREPORTING(null,e);
        }
    }
    
    public String TaxTypeSelected(){
        try{
            DCIteratorBinding dciter = ADFUtils.findIterator("findTaxTypesbyAppLevelIterator");
            RowKeySet set =taxesLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();
            
            //System.out.println(1);
            while (rowKeySetIter.hasNext()) 
            {
                List l = (List) rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                
                session.setAttribute("ttCode", r.getAttribute("TT_CODE"));
                
                taxTypeDesc.setValue(r.getAttribute("TT_DESC"));
                
             //Tax Rates
                ADFUtils.findIterator("findTaxRatesIterator").executeQuery();
             AdfFacesContext.getCurrentInstance().addPartialTarget(ratesLOV);   

            }
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }
    
    public void TaxTypeListener(SelectionEvent selectionEvent) {
        // Add event code here...
        try{
            DCIteratorBinding dciter = ADFUtils.findIterator("findTaxTypesIterator");
            RowKeySet set = selectionEvent.getAddedSet();
            Iterator rowKeySetIter = set.iterator();
            
            //System.out.println(1);
            while (rowKeySetIter.hasNext()) 
            {
                List l = (List) rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                
                session.setAttribute("ttCode", r.getAttribute("TT_CODE"));
                
             //Tax Rates
                ADFUtils.findIterator("findTaxRatesIterator").executeQuery();
             AdfFacesContext.getCurrentInstance().addPartialTarget(ratesLOV);   

         }     
            
            
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
    }
    
    public String AgentTypeSelected(){
      
      DCIteratorBinding dciter = ADFUtils.findIterator("findAccountTypesIterator");
      RowKeySet set =agentsLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      
      //System.out.println(1);
      while (rowKeySetIter.hasNext()) 
      {
          List l = (List) rowKeySetIter.next();
          Key key = (Key)l.get(0);
          dciter.setCurrentRowWithKey(key.toStringFormat(true));
          Row r = dciter.getCurrentRow();
        
          session.setAttribute("ActCode", r.getAttribute("ACT_CODE"));
          session.setAttribute("ActShtDesc", r.getAttribute("ACT_TYPE_ID"));
          agentIDesc.setValue(r.getAttribute("ACT_TYPE_ID"));
          agentTypeDesc.setValue(r.getAttribute("ACT_ACCOUNT_TYPE"));

            ADFUtils.findIterator("findAccountRatesIterator").executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(ratesLOV);

            ADFUtils.findIterator("findCommissionRatesIterator").executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(lifeCommissionLOV);
            ADFUtils.findIterator("findPensionCommissionRatesIterator").executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(pensionCommissions);
            ADFUtils.findIterator("findCommissionAnnualisationIterator").executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(annualCommissionsLOV);
          

      }
        
         
      return null;
    }
    
    public String CoverTypeSelected(){
      
      DCIteratorBinding dciter = ADFUtils.findIterator("findProdCoverTypesIterator");
      RowKeySet set =coverTypeTable.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      
      //System.out.println(1);
      while (rowKeySetIter.hasNext()) 
      {
          List l = (List) rowKeySetIter.next();
          Key key = (Key)l.get(0);
          dciter.setCurrentRowWithKey(key.toStringFormat(true));
          Row r = dciter.getCurrentRow();
        
          session.setAttribute("pctCode", r.getAttribute("PCT_CODE"));
          coverTypeShtDesc.setValue(r.getAttribute("PCT_CVT_SHT_DESC"));
          coverTypeDesc.setValue(r.getAttribute("PCT_CVT_DESC"));

            ADFUtils.findIterator("findAccountRatesIterator").executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(ratesLOV);

            ADFUtils.findIterator("findCommissionRatesIterator").executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(lifeCommissionLOV);
            ADFUtils.findIterator("findPensionCommissionRatesIterator").executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(pensionCommissions);
            ADFUtils.findIterator("findCommissionAnnualisationIterator").executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(annualCommissionsLOV);
          

      }
        
         
      return null;
    }
    
    public String AddPremiumMask(){
        try{
    
            pmID.setValue(null);
            pmDesc.setValue(null);
            pmDefault.setValue("N");
            pmComments.setValue(null);
            session.setAttribute("pmasCode", null);
           
            
            // Render Popup
            ExtendedRenderKitService erkService =
            Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
            ExtendedRenderKitService.class);
            erkService.addScript(FacesContext.getCurrentInstance(),
            "var hints = {autodismissNever:false}; " +
            "AdfPage.PAGE.findComponent('" + "lmsgroup:premMask" +
            "').show(hints);");
            
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }
    
    public String EditPremiumMask(){
      
      DCIteratorBinding dciter = ADFUtils.findIterator("findPremiumMasksIterator");
      RowKeySet set =premiumMasksLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      
      //System.out.println(1);
      while (rowKeySetIter.hasNext()) 
      {
          List l = (List) rowKeySetIter.next();
          Key key = (Key)l.get(0);
          dciter.setCurrentRowWithKey(key.toStringFormat(true));
          Row r = dciter.getCurrentRow();
        
          session.setAttribute("pmasCode", r.getAttribute("PMAS_CODE"));
          pmID.setValue(r.getAttribute("PMAS_SHT_DESC"));
          pmDesc.setValue(r.getAttribute("PMAS_DESC"));
          pmDefault.setValue(r.getAttribute("PMAS_DEFAULT"));
          pmComments.setValue(r.getAttribute("PMAS_COMMENT"));
          pmRateType.setValue(r.getAttribute("PMAS_RATE_TYPE"));

          // Render Popup
          ExtendedRenderKitService erkService =
          Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
          ExtendedRenderKitService.class);
          erkService.addScript(FacesContext.getCurrentInstance(),
          "var hints = {autodismissNever:false}; " +
          "AdfPage.PAGE.findComponent('" + "lmsgroup:premMask" +
          "').show(hints);");

      }
        
         
      return null;
    }
    
    public String SavePremiumMask() {
        Connection conn=null;
        try 
        {
            
            if(pmID.getValue()==null){
                String Message = "Enter A Premium ID";
                FacesContext.getCurrentInstance().addMessage(null, 
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                              Message, 
                                                                              Message));
                return null;
            }
            
            if(pmDesc.getValue()==null){
                String Message = "Enter A Premium Description";
                FacesContext.getCurrentInstance().addMessage(null, 
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                              Message, 
                                                                              Message));
                return null;
            }
          if(pmRateType.getValue()==null){
              String Message = "Enter A Rate Type";
              FacesContext.getCurrentInstance().addMessage(null, 
                                                           new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                            Message, 
                                                                            Message));
              return null;
          }
           
            
            String authQuery="BEGIN LMS_SETUPS_PKG.updatePremiumMask(?,?,?,?,?,?,?,?);END;";
            conn=new DBConnector().getDatabaseConn();
            
            CallableStatement cstmt=conn.prepareCall(authQuery);    
            cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("pmasCode"));
            if(pmID.getValue()==null){
                cstmt.setString(2, null);
            }else{
                cstmt.setString(2, pmID.getValue().toString());  
            }
            if(pmDesc.getValue()==null){
                cstmt.setString(3, null);
            }else{
                cstmt.setString(3, pmDesc.getValue().toString());  
            }
            if(pmDefault.getValue()==null){
                cstmt.setString(4, "N");
            }else{
                cstmt.setString(4, pmDefault.getValue().toString());  
            }
            if(pmComments.getValue()==null){
                cstmt.setString(5, null);
            }else{
                cstmt.setString(5, pmComments.getValue().toString());  
            }
            cstmt.setBigDecimal(6, (BigDecimal)session.getAttribute("ProductCode"));
            cstmt.setBigDecimal(7, (BigDecimal)session.getAttribute("ClaCode"));
            cstmt.setString(8, pmRateType.getValue().toString());
            cstmt.execute();
            conn.close();
            
            String Message = "Premium Mask Saved succesfully.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            
            session.setAttribute("pmasCode", null);
            ADFUtils.findIterator("findPremiumMasksIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(premiumMasksLOV);    
          
        }
        catch(Exception ex)
        {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
        }
      return null;
    }
    
    public String DeletePremiumMask() {
        Connection conn=null;
      try 
      {
          DCIteratorBinding dciter = ADFUtils.findIterator("findPremiumMasksIterator");
          RowKeySet set =premiumMasksLOV.getSelectedRowKeys();
          Iterator rowKeySetIter = set.iterator();
          
          //System.out.println(1);
          while (rowKeySetIter.hasNext()) 
          {
              List l = (List) rowKeySetIter.next();
              Key key = (Key)l.get(0);
              dciter.setCurrentRowWithKey(key.toStringFormat(true));
              Row r = dciter.getCurrentRow();
            
              session.setAttribute("pmasCode", r.getAttribute("PMAS_CODE"));
              
              String authQuery="BEGIN LMS_SETUPS_PKG.deletepremiumMask(?);END;";
              conn=new DBConnector().getDatabaseConn();
              
              CallableStatement cstmt=conn.prepareCall(authQuery);    
              cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("pmasCode"));
           
              cstmt.execute();
              conn.close();

          }
          session.setAttribute("pmasCode", null);
            ADFUtils.findIterator("findPremiumMasksIterator").executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(premiumMasksLOV);    
        
      }
      catch(Exception ex)
      {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
      }
      return null;
    }
    
    public String EditParameter(){
      
      DCIteratorBinding dciter = ADFUtils.findIterator("findParametersIterator");
      RowKeySet set =parameterLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      
      //System.out.println(1);
      while (rowKeySetIter.hasNext()) 
      {
          List l = (List) rowKeySetIter.next();
          Key key = (Key)l.get(0);
          dciter.setCurrentRowWithKey(key.toStringFormat(true));
          Row r = dciter.getCurrentRow();
        
          session.setAttribute("parameterCode", r.getAttribute("PARAM_CODE"));
          paramVal.setValue(r.getAttribute("PARAM_VALUE"));
          paramDesc.setValue(r.getAttribute("PARAM_DESC"));
          paramProdSpecific.setValue(r.getAttribute("PARAM_PROD_SPECIFIC"));

          // Render Popup
          ExtendedRenderKitService erkService =
          Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
          ExtendedRenderKitService.class);
          erkService.addScript(FacesContext.getCurrentInstance(),
          "var hints = {autodismissNever:false}; " +
          "AdfPage.PAGE.findComponent('" + "lmsgroup:param" +
          "').show(hints);");

      }
        
         
      return null;
    }
    
    public String SaveParameter() {
        Connection conn=null;
        try 
        {
            
            if(paramVal.getValue()==null){
                String Message = "Enter A Parameter Value";
                FacesContext.getCurrentInstance().addMessage(null, 
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                              Message, 
                                                                              Message));
                return null;
            }
            
            if(paramDesc.getValue()==null){
                String Message = "Enter A Parameter Value";
                FacesContext.getCurrentInstance().addMessage(null, 
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                              Message, 
                                                                              Message));
                return null;
            }
           
            
            String authQuery="BEGIN LMS_SETUPS_PKG.updateParamter(?,?,?,?);END;";
            conn=new DBConnector().getDatabaseConn();
            
            CallableStatement cstmt=conn.prepareCall(authQuery);    
            cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("parameterCode"));
            if(paramDesc.getValue()==null){
                cstmt.setString(2, null);
            }else{
                cstmt.setString(2, paramDesc.getValue().toString());  
            }
            if(paramVal.getValue()==null){
                cstmt.setString(3, null);
            }else{
                cstmt.setString(3, paramVal.getValue().toString());  
            }
            
            if(paramProdSpecific.getValue()==null){
                cstmt.setString(4, null);
            }else{
                cstmt.setString(4, paramProdSpecific.getValue().toString());  
            }
            cstmt.execute();
            conn.close();
            
            String Message = "Parameter Saved succesfully.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            
            session.setAttribute("parameterCode", null);
            ADFUtils.findIterator("findParametersIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(parameterLOV);    
          
        }
        catch(Exception ex)
        {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
        }
      return null;
    }
    
    public String AddFCLFactor(){
        try{
    
            fcLivesFrom.setValue(null);
            fcLivesTo.setValue(null);
            fcLFactor.setValue(null);
            fcLimit.setValue(null);
            fcLWef.setValue(null);
            fcLWet.setValue(null);
            session.setAttribute("FCLCode", null);
           
            
            // Render Popup
            ExtendedRenderKitService erkService =
            Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
            ExtendedRenderKitService.class);
            erkService.addScript(FacesContext.getCurrentInstance(),
            "var hints = {autodismissNever:false}; " +
            "AdfPage.PAGE.findComponent('" + "lmsgroup:fclfactors" +
            "').show(hints);");
            
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }
    
    public String EditFCLFactor(){
      
      DCIteratorBinding dciter = ADFUtils.findIterator("findFCLFactorsIterator");
      RowKeySet set =FCLLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      
      //System.out.println(1);
      while (rowKeySetIter.hasNext()) 
      {
          List l = (List) rowKeySetIter.next();
          Key key = (Key)l.get(0);
          dciter.setCurrentRowWithKey(key.toStringFormat(true));
          Row r = dciter.getCurrentRow();
        
          session.setAttribute("FCLCode", r.getAttribute("FCL_CODE"));
          fcLivesFrom.setValue(r.getAttribute("FCL_LIVES_FROM"));
          fcLivesTo.setValue(r.getAttribute("FCL_LIVE_TO"));
          fcLFactor.setValue(r.getAttribute("FCL_FCL_FACTOR"));
          fcLimit.setValue(r.getAttribute("FCL_LIMIT"));
          fcLWef.setValue(r.getAttribute("FCL_WEF"));
          fcLWet.setValue(r.getAttribute("FCL_WET"));
        

          // Render Popup
          ExtendedRenderKitService erkService =
          Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
          ExtendedRenderKitService.class);
          erkService.addScript(FacesContext.getCurrentInstance(),
          "var hints = {autodismissNever:false}; " +
          "AdfPage.PAGE.findComponent('" + "lmsgroup:fclfactors" +
          "').show(hints);");

      }
        
         
      return null;
    }
    
    public String SaveFCLFactor() {
        Connection conn=null;
        try 
        {
            
            if(fcLimit.getValue()==null){
                String Message = "Enter A FCL Max Limit";
                FacesContext.getCurrentInstance().addMessage(null, 
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                              Message, 
                                                                              Message));
                return null;
            }
            
            Boolean WEFDateChanged = false;
            Boolean WETDateChanged = false;
            
            if(fcLWef.getValue()==null){
            }else{
                WEFDateChanged = fcLWef.getValue().toString().contains(":");
            }
            
            if(fcLWet.getValue()==null){
            }else{
                WETDateChanged = fcLWet.getValue().toString().contains(":");
            }
           
            
            String authQuery="BEGIN LMS_SETUPS_PKG.updateFCLFactor(?,?,?,?,?,?,?,?);END;";
            conn=new DBConnector().getDatabaseConn();
            
            CallableStatement cstmt=conn.prepareCall(authQuery);    
            cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("FCLCode"));
            if(fcLivesFrom.getValue()==null){
                cstmt.setString(2, null);
            }else{
                cstmt.setString(2, fcLivesFrom.getValue().toString());  
            }
            if(fcLivesTo.getValue()==null){
                cstmt.setString(3, null);
            }else{
                cstmt.setString(3, fcLivesTo.getValue().toString());  
            }
            if(fcLFactor.getValue()==null){
                cstmt.setString(4, null);
            }else{
                cstmt.setString(4, fcLFactor.getValue().toString());  
            }
            if(fcLimit.getValue()==null){
                cstmt.setString(5, null);
            }else{
                cstmt.setString(5, fcLimit.getValue().toString());  
            }
            if(fcLWef.getValue()==null){
                cstmt.setString(6, null);
            }else{
                if(WEFDateChanged==false){
                    cstmt.setString(6, null); 
                }else{
                    cstmt.setString(6, LOVCC.parseDate(fcLWef.getValue().toString()));   
                }
            }
            if(fcLWet.getValue()==null){
                cstmt.setString(7, null);
            }else{
                if(WETDateChanged==false){
                    cstmt.setString(7, null); 
                }else{
                    cstmt.setString(7, LOVCC.parseDate(fcLWet.getValue().toString()));   
                }
            }
            cstmt.setBigDecimal(8, (BigDecimal)session.getAttribute("ProductCode"));
            cstmt.execute();
            conn.close();
            
            String Message = "FCL Factor Saved succesfully.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            
            session.setAttribute("FCLCode", null);
            ADFUtils.findIterator("findFCLFactorsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(FCLLOV);    
          
        }
        catch(Exception ex)
        {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
        }
      return null;
    }
    public String DeleteFCLFactor() {
        Connection conn=null;
      try 
      {
          DCIteratorBinding dciter = ADFUtils.findIterator("findFCLFactorsIterator");
          RowKeySet set =FCLLOV.getSelectedRowKeys();
          Iterator rowKeySetIter = set.iterator();
          
          //System.out.println(1);
          while (rowKeySetIter.hasNext()) 
          {
              List l = (List) rowKeySetIter.next();
              Key key = (Key)l.get(0);
              dciter.setCurrentRowWithKey(key.toStringFormat(true));
              Row r = dciter.getCurrentRow();
            
              session.setAttribute("FCLCode", r.getAttribute("FCL_CODE"));
              
              String authQuery="BEGIN LMS_SETUPS_PKG.deleteFCLFactor(?);END;";
              conn=new DBConnector().getDatabaseConn();
              
              CallableStatement cstmt=conn.prepareCall(authQuery);    
              cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("FCLCode"));
           
              cstmt.execute();
              conn.close();

          }
          session.setAttribute("FCLCode", null);
            ADFUtils.findIterator("findFCLFactorsIterator").executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(FCLLOV);    
        
      }
      catch(Exception ex)
      {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
      }
      return null;
    }
    
  public String CloneFactors(){

    if(session.getAttribute("ProductCode")==null){
      GlobalCC.INFORMATIONREPORTING("Select A Product.");
      return null;
    }
    session.setAttribute("cloneProdCode", null);
    newFCLProduct.setValue(null);
    clonePanel.setRendered(true);
    confirmPanel.setRendered(false);
    
    GlobalCC.showPopup("lmsgroup:clonepopup");
    return null;
  }
  
  public String ValidateCloneFactors(){
    
    if(session.getAttribute("cloneProdCode")==null){
      GlobalCC.INFORMATIONREPORTING("Select A Product to Apply Factors");
      return null;
    }
    confirmPanel.setRendered(true);
    clonePanel.setRendered(false);
    AdfFacesContext.getCurrentInstance().addPartialTarget(confirmPanel);
    AdfFacesContext.getCurrentInstance().addPartialTarget(clonePanel);
    return null;
  }
  
  public String CancelValidate(){
    
    clonePanel.setRendered(true);
    confirmPanel.setRendered(false);
    AdfFacesContext.getCurrentInstance().addPartialTarget(confirmPanel);
    AdfFacesContext.getCurrentInstance().addPartialTarget(clonePanel);
    return null;
  }
  
  public String ProceedToCloneFCLFactors(){
    Connection conn=null;
    try{
      String deleteQuery="BEGIN LMS_SETUPS_PKG.replicateFCLFactors(?,?);END;";
      conn=new DBConnector().getDatabaseConn();
    
      CallableStatement cstmt=conn.prepareCall(deleteQuery); 
      cstmt.setBigDecimal(1,(BigDecimal)session.getAttribute("ProductCode"));
      cstmt.setBigDecimal(2,(BigDecimal)session.getAttribute("cloneProdCode"));
      cstmt.execute();
      cstmt.close();
        
      GlobalCC.hidePopup("lmsgroup:clonepopup");
        
      GlobalCC.INFORMATIONREPORTING("FCL Factors Successully Cloned");
        
    }catch(Exception e){
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
  }
    
    public String AddTaxTypes(){
        try{
            
            ttId.setValue(null);
            ttDesc.setValue(null);
            ttTaxType.setValue(null);
            ttApplProd.setValue(null);
            ttApplEndr.setValue(null);
            ttApplLevel.setValue(null);
            ttRefund.setValue(null);
           // session.setAttribute("ttCode", null);
           
            
            // Render Popup
            ExtendedRenderKitService erkService =
            Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
            ExtendedRenderKitService.class);
            erkService.addScript(FacesContext.getCurrentInstance(),
            "var hints = {autodismissNever:false}; " +
            "AdfPage.PAGE.findComponent('" + "lmsgroup:taxTypes" +
            "').show(hints);");
            
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }
    
    public String EditTaxTypes(){
      
      DCIteratorBinding dciter = ADFUtils.findIterator("findTaxTypesIterator");
      RowKeySet set =taxesLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      
      //System.out.println(1);
      while (rowKeySetIter.hasNext()) 
      {
          List l = (List) rowKeySetIter.next();
          Key key = (Key)l.get(0);
          dciter.setCurrentRowWithKey(key.toStringFormat(true));
          Row r = dciter.getCurrentRow();
        
          session.setAttribute("ttCode", r.getAttribute("TT_CODE"));
          
          ttId.setValue(r.getAttribute("TT_SHT_DESC"));
          ttDesc.setValue(r.getAttribute("TT_DESC"));
          ttTaxType.setValue(r.getAttribute("TT_TYPE"));
          ttApplProd.setValue(r.getAttribute("TT_APPLICABLE_AT_PROD"));
          ttApplEndr.setValue(r.getAttribute("TT_RENEWAL_ENDOS"));
          ttApplLevel.setValue(r.getAttribute("TT_APPLICATION_LEVEL"));
          ttRefund.setValue(r.getAttribute("TT_REFUND_ON_CANC"));
          exciseDuty.setValue(r.getAttribute("exciseDuty"));
          // Render Popup
          ExtendedRenderKitService erkService =
          Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
          ExtendedRenderKitService.class);
          erkService.addScript(FacesContext.getCurrentInstance(),
          "var hints = {autodismissNever:false}; " +
          "AdfPage.PAGE.findComponent('" + "lmsgroup:taxTypes" +
          "').show(hints);");

      }
        
         
      return null;
    }
    
    public String SaveTaxTypes() {
        Connection conn=null;
        try 
        {
            
            if(ttDesc.getValue()==null){
                String Message = "Enter A Tax Description";
                FacesContext.getCurrentInstance().addMessage(null, 
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                              Message, 
                                                                              Message));
                return null;
            }
            
            if(ttTaxType.getValue()==null){
                String Message = "Enter A Tax Type";
                FacesContext.getCurrentInstance().addMessage(null, 
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                              Message, 
                                                                              Message));
                return null;
            }

           
            
            String authQuery="BEGIN LMS_SETUPS_PKG.updateTaxTypes(?,?,?,?,?,?,?,?,?);END;";
            conn=new DBConnector().getDatabaseConn();
            
            CallableStatement cstmt=conn.prepareCall(authQuery);    
            cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("ttCode"));
            if(ttId.getValue()==null){
                cstmt.setString(2, null);
            }else{
                cstmt.setString(2, ttId.getValue().toString());  
            }
            if(ttDesc.getValue()==null){
                cstmt.setString(3, null);
            }else{
                cstmt.setString(3, ttDesc.getValue().toString());  
            }
            if(ttTaxType.getValue()==null){
                cstmt.setString(4, null);
            }else{
                cstmt.setString(4, ttTaxType.getValue().toString());  
            }
            if(ttApplProd.getValue()==null){
                cstmt.setString(5, null);
            }else{
                cstmt.setString(5, ttApplProd.getValue().toString());  
            }
            if(ttApplEndr.getValue()==null){
                cstmt.setString(6, null);
            }else{
                    cstmt.setString(6, ttApplEndr.getValue().toString());   
            }
            if(ttApplLevel.getValue()==null){
                cstmt.setString(7, null);
            }else{
                    cstmt.setString(7, ttApplLevel.getValue().toString());   
            }
            if(ttRefund.getValue()==null){
                cstmt.setString(8, null);
            }else{
                    cstmt.setString(8, ttRefund.getValue().toString());   
            }
            if(exciseDuty.getValue()==null){
               cstmt.setString(9, null);
            }else{
              cstmt.setString(9, exciseDuty.getValue().toString());
            }
            cstmt.execute();
            conn.close();
            
            String Message = "Tax Type Saved succesfully.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            
            session.setAttribute("ttCode", null);
            ADFUtils.findIterator("findTaxTypesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(taxesLOV);    
          
        }
        catch(Exception ex)
        {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
        }
      return null;
    }
    
    public String DeleteTaxTypes() {
        Connection conn=null;
        String Result = "F";
      try 
      {
          DCIteratorBinding dciter = ADFUtils.findIterator("findTaxTypesIterator");
          RowKeySet set =taxesLOV.getSelectedRowKeys();
          Iterator rowKeySetIter = set.iterator();
          
          //System.out.println(1);
          while (rowKeySetIter.hasNext()) 
          {
              List l = (List) rowKeySetIter.next();
              Key key = (Key)l.get(0);
              dciter.setCurrentRowWithKey(key.toStringFormat(true));
              Row r = dciter.getCurrentRow();
            
              session.setAttribute("ttCode", r.getAttribute("TT_CODE"));
              
              String authQuery="BEGIN LMS_SETUPS_PKG.deleteTaxTypes(?);END;";
             conn=new DBConnector().getDatabaseConn();
              
              CallableStatement cstmt=conn.prepareCall(authQuery);    
              cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("ttCode"));
           
              cstmt.execute();
              conn.close();
              String Message = "Tax Type Deleted succesfully.";
              FacesContext.getCurrentInstance().addMessage(null, 
                                                           new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                            Message, 
                                                                            Message));
          }
          session.setAttribute("ttCode", null);
            ADFUtils.findIterator("findTaxTypesIterator").executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(taxesLOV);
            GlobalCC.INFORMATIONREPORTING("Record Successfully Deleted");
        Result = "S";
        
      }
      catch(Exception ex)
      {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
      }
      return Result;
    }
    
    public String AddTaxRates(){
        try{
            
            txRangeFrom.setValue(null);
            txRangeTo.setValue(null);
            txAgeFrm.setValue(null);
            txAgeTo.setValue(null);
            txRate.setValue(null);
            txDivFac.setValue(null);
            txRateType.setValue(null);
            txApplTo.setValue(null);
            txApplFreq.setValue(null);
            txDuration.setValue(null);
            wef.setValue(null);
            wet.setValue(null);
            yrsOfService.setValue(null);
            yrsOfServiceTo.setValue(null);
            session.setAttribute("txrCode", null);
            session.setAttribute("CAUS_CODE", null);
            causationDesc.setValue(null);
            applAtCause.setValue("N");
           
            
            // Render Popup
            GlobalCC.showPopup("lmsgroup:taxRates");
            
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }
    
    public String EditTaxRates(){
      
      DCIteratorBinding dciter = ADFUtils.findIterator("findTaxRatesIterator");
      RowKeySet set =ratesLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      
      //System.out.println(1);
      while (rowKeySetIter.hasNext()) 
      {
          List l = (List) rowKeySetIter.next();
          Key key = (Key)l.get(0);
          dciter.setCurrentRowWithKey(key.toStringFormat(true));
          Row r = dciter.getCurrentRow();
        
          session.setAttribute("txrCode", r.getAttribute("TRT_CODE"));
          
          txRangeFrom.setValue(r.getAttribute("TRT_RANGE_FROM"));
          txRangeTo.setValue(r.getAttribute("TRT_RANGE_TO"));
          txAgeFrm.setValue(r.getAttribute("TRT_AGE_FROM"));
          txAgeTo.setValue(r.getAttribute("TRT_AGE_TO"));
          txRate.setValue(r.getAttribute("TRT_RATE"));
          txDivFac.setValue(r.getAttribute("TRT_DIVISION_FACTOR"));
          txRateType.setValue(r.getAttribute("TRT_RATE_TYPE"));
          txApplTo.setValue(r.getAttribute("TRT_APPLIED_TO"));
          txApplFreq.setValue(r.getAttribute("TRT_APPLICATION_FREQ"));
          txDuration.setValue(r.getAttribute("TRT_TAX_DURATION"));
          wef.setValue(r.getAttribute("TRT_WEF_DATE"));
          wet.setValue(r.getAttribute("TRT_WET_DATE"));
          yrsOfService.setValue(r.getAttribute("TRT_YRS_OF_SERVICE_FROM"));
          yrsOfServiceTo.setValue(r.getAttribute("TRT_YRS_OF_SERVICE_TO"));
          session.setAttribute("CAUS_CODE", r.getAttribute("TRT_CAUS_CODE"));
          causationDesc.setValue(r.getAttribute("CAUS_DESC"));
          applAtCause.setValue(r.getAttribute("TRT_APPLICABLE_AT_CAUS"));
          txApplOn.setValue(r.getAttribute("TRT_APPLIED_ON"));
         String Value = (String)r.getAttribute("TRT_APPLICABLE_AT_CAUS");
          if(Value.equalsIgnoreCase("Y")){
            causationButton.setDisabled(false);
          }else{
            causationButton.setDisabled(true);
          }

          // Render Popup
          GlobalCC.showPopup("lmsgroup:taxRates");
      }
        
         
      return null;
    }
    
    public String SaveTaxRates() {
        Connection conn=null;
        try 
        {
            
            if(txRangeFrom.getValue()==null){
                String Message = "Enter A Range From";
                FacesContext.getCurrentInstance().addMessage(null, 
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                              Message, 
                                                                              Message));
                return null;
            }
            
            if(txRangeTo.getValue()==null){
                String Message = "Enter A Range To";
                FacesContext.getCurrentInstance().addMessage(null, 
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                              Message, 
                                                                              Message));
                return null;
            }
            
            if(txRate.getValue()==null){
                String Message = "Enter A Tax Rate";
                FacesContext.getCurrentInstance().addMessage(null, 
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                              Message, 
                                                                              Message));
                return null;
            }
            
            Boolean WEFDateChanged = false;
            Boolean WETDateChanged = false;
            
            if(wef.getValue()==null){
            }else{
                WEFDateChanged = wef.getValue().toString().contains(":");
            }
            
            if(wet.getValue()==null){
            }else{
                WETDateChanged = wet.getValue().toString().contains(":");
            }
            
          if(applAtCause.getValue()==null){
              //continue...
          }else{
              if(applAtCause.getValue().toString().equalsIgnoreCase("Y") && session.getAttribute("CAUS_CODE")==null){
                GlobalCC.INFORMATIONREPORTING("Select A Causation");
                return null;
              }
          }

            String authQuery="BEGIN LMS_SETUPS_PKG.updateTaxRates(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);END;";
            conn=new DBConnector().getDatabaseConn();
            
            CallableStatement cstmt=conn.prepareCall(authQuery);    
            cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("txrCode"));
            if(txRangeFrom.getValue()==null){
                cstmt.setString(2, null);
            }else{
                cstmt.setString(2, txRangeFrom.getValue().toString());  
            }
            if(txRangeTo.getValue()==null){
                cstmt.setString(3, null);
            }else{
                cstmt.setString(3, txRangeTo.getValue().toString());  
            }
            if(txAgeFrm.getValue()==null){
                cstmt.setString(4, null);
            }else{
                cstmt.setString(4, txAgeFrm.getValue().toString());  
            }
            if(txAgeTo.getValue()==null){
                cstmt.setString(5, null);
            }else{
                cstmt.setString(5, txAgeTo.getValue().toString());  
            }
            if(txRate.getValue()==null){
                cstmt.setString(6, null);
            }else{
                    cstmt.setString(6, txRate.getValue().toString());   
            }
            if(txDivFac.getValue()==null){
                cstmt.setString(7, null);
            }else{
                    cstmt.setString(7, txDivFac.getValue().toString());   
            }
            if(txRateType.getValue()==null){
                cstmt.setString(8, null);
            }else{
                    cstmt.setString(8, txRateType.getValue().toString());   
            }
            if(txApplTo.getValue()==null){
                cstmt.setString(9, null);
            }else{
                    cstmt.setString(9, txApplTo.getValue().toString());   
            }
            if(txApplFreq.getValue()==null){
                cstmt.setString(10, null);
            }else{
                    cstmt.setString(10, txApplFreq.getValue().toString());   
            }
            if(txDuration.getValue()==null){
                cstmt.setString(11, null);
            }else{
                    cstmt.setString(11, txDuration.getValue().toString());   
            }
            if(wef.getValue()==null){
                cstmt.setString(12, null);
            }else{
                if(WEFDateChanged==false){
                    cstmt.setString(12, null); 
                }else{
                    cstmt.setString(12, LOVCC.parseDate(wef.getValue().toString()));   
                }
            }
            if(wet.getValue()==null){
                cstmt.setString(13, null);
            }else{
                if(WETDateChanged==false){
                    cstmt.setString(13, null); 
                }else{
                    cstmt.setString(13, LOVCC.parseDate(wet.getValue().toString()));   
                }
            }
            cstmt.setBigDecimal(14, (BigDecimal)session.getAttribute("ttCode"));
            cstmt.setBigDecimal(15, (BigDecimal)session.getAttribute("ProductCode"));
            if(yrsOfService.getValue()==null){
                cstmt.setString(16, null);
            }else{
                    cstmt.setString(16, yrsOfService.getValue().toString());   
            }
            if(yrsOfServiceTo.getValue()==null){
                cstmt.setString(17, null);
            }else{
                    cstmt.setString(17, yrsOfServiceTo.getValue().toString());   
            }
            cstmt.setBigDecimal(18, (BigDecimal)session.getAttribute("CAUS_CODE"));
            if(applAtCause.getValue()==null){
                cstmt.setString(19, null);
            }else{
                    cstmt.setString(19, applAtCause.getValue().toString());   
            }
            cstmt.setBigDecimal(20, (BigDecimal)session.getAttribute("pctCode"));
            
             if(txApplOn.getValue()==null){
              cstmt.setString(21, null);
             }else{
                  cstmt.setString(21, txApplOn.getValue().toString());   
             }
            
            cstmt.execute();
            cstmt.close();
            conn.close();
            
            GlobalCC.INFORMATIONREPORTING("Tax Rate Saved succesfully.");
            
            session.setAttribute("txrCode", null);
            ADFUtils.findIterator("findTaxRatesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(ratesLOV);   
            
            GlobalCC.hidePopup("lmsgroup:taxRates");
          
        }
        catch(Exception ex)
        {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
        }
      return null;
    }
    
    public String DeleteTaxRates() {
        Connection conn=null;
        String Result = "F";
      try 
      {
          DCIteratorBinding dciter = ADFUtils.findIterator("findTaxRatesIterator");
          RowKeySet set =ratesLOV.getSelectedRowKeys();
          Iterator rowKeySetIter = set.iterator();
          
          //System.out.println(1);
          while (rowKeySetIter.hasNext()) 
          {
              List l = (List) rowKeySetIter.next();
              Key key = (Key)l.get(0);
              dciter.setCurrentRowWithKey(key.toStringFormat(true));
              Row r = dciter.getCurrentRow();
            
              session.setAttribute("txrCode", r.getAttribute("TRT_CODE"));
              
              String authQuery="BEGIN LMS_SETUPS_PKG.deleteTaxRates(?);END;";
             conn=new DBConnector().getDatabaseConn();
              
              CallableStatement cstmt=conn.prepareCall(authQuery);    
              cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("txrCode"));
           
              cstmt.execute();
              conn.close();

          }
          session.setAttribute("txrCode", null);
            ADFUtils.findIterator("findTaxRatesIterator").executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(ratesLOV);
            GlobalCC.INFORMATIONREPORTING("Record Successfully Deleted");
        Result = "S";
        
      }
      catch(Exception ex)
      {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
      }
      return Result;
    }
    
    public String AddMedicalTests(){
        try{
            
            shortDesc.setValue(null);
            desc.setValue(null);
            fee.setValue(null);
            validPeriod.setValue(null);
            wef.setValue(null);
            wet.setValue(null);
            session.setAttribute("mtlCode", null);
           
            
            // Render Popup
            ExtendedRenderKitService erkService =
            Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
            ExtendedRenderKitService.class);
            erkService.addScript(FacesContext.getCurrentInstance(),
            "var hints = {autodismissNever:false}; " +
            "AdfPage.PAGE.findComponent('" + "lmsgroup:medTest" +
            "').show(hints);");
            
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }
    
    public String EditMedicalTests(){
      
      DCIteratorBinding dciter = ADFUtils.findIterator("findMedicalTestsIterator");
      RowKeySet set =medTestsLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      
      //System.out.println(1);
      while (rowKeySetIter.hasNext()) 
      {
          List l = (List) rowKeySetIter.next();
          Key key = (Key)l.get(0);
          dciter.setCurrentRowWithKey(key.toStringFormat(true));
          Row r = dciter.getCurrentRow();
        
          session.setAttribute("mtlCode", r.getAttribute("MTL_CODE"));
          
          shortDesc.setValue(r.getAttribute("MTL_SHT_DESC"));
          desc.setValue(r.getAttribute("MTL_DESC"));
          fee.setValue(r.getAttribute("MTL_FEES"));
          validPeriod.setValue(r.getAttribute("MTL_VALIDITY_PRD"));
          wef.setValue(r.getAttribute("MTL_WEF"));
          wet.setValue(r.getAttribute("MTL_WET"));
          

          // Render Popup
          ExtendedRenderKitService erkService =
          Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
          ExtendedRenderKitService.class);
          erkService.addScript(FacesContext.getCurrentInstance(),
          "var hints = {autodismissNever:false}; " +
          "AdfPage.PAGE.findComponent('" + "lmsgroup:medTest" +
          "').show(hints);");

      }
        
         
      return null;
    }
    
    public String SaveMedicalTests() {
        Connection conn=null;
        try 
        {
            
            if(desc.getValue()==null){
                String Message = "Enter A Description";
                FacesContext.getCurrentInstance().addMessage(null, 
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                              Message, 
                                                                              Message));
                return null;
            }
            
            if(fee.getValue()==null){
                String Message = "Enter A Fee";
                FacesContext.getCurrentInstance().addMessage(null, 
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                              Message, 
                                                                              Message));
                return null;
            }
            
            Boolean WEFDateChanged = false;
            Boolean WETDateChanged = false;
            
            if(wef.getValue()==null){
            }else{
                WEFDateChanged = wef.getValue().toString().contains(":");
            }
            
            if(wet.getValue()==null){
            }else{
                WETDateChanged = wet.getValue().toString().contains(":");
            }

           
            
            String authQuery="BEGIN LMS_SETUPS_PKG.updateMedTests(?,?,?,?,?,?,?,?);END;";
            conn=new DBConnector().getDatabaseConn();
            
            CallableStatement cstmt=conn.prepareCall(authQuery);    
            cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("mtlCode"));
            if(shortDesc.getValue()==null){
                cstmt.setString(2, null);
            }else{
                cstmt.setString(2, shortDesc.getValue().toString());  
            }
            if(desc.getValue()==null){
                cstmt.setString(3, null);
            }else{
                cstmt.setString(3, desc.getValue().toString());  
            }
            if(fee.getValue()==null){
                cstmt.setString(4, null);
            }else{
                cstmt.setString(4, fee.getValue().toString());  
            }
            if(wef.getValue()==null){
                    cstmt.setString(5, null);
            }else{
                    if(WEFDateChanged==false){
                        cstmt.setString(5, null); 
                }else{
                        cstmt.setString(5, LOVCC.parseDate(wef.getValue().toString()));   
                    }
            }
            if(wet.getValue()==null){
                    cstmt.setString(6, null);
            }else{
                    if(WETDateChanged==false){
                        cstmt.setString(6, null); 
                    }else{
                        cstmt.setString(6, LOVCC.parseDate(wet.getValue().toString()));   
                }
            }
            if(validPeriod.getValue()==null){
                cstmt.setString(7, null);
            }else{
                    cstmt.setString(7, validPeriod.getValue().toString());   
            }
            cstmt.setBigDecimal(8,(BigDecimal)session.getAttribute("currCode"));
           
            cstmt.execute();
            conn.close();
            
            String Message = "Medical Test Saved succesfully.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            
            session.setAttribute("mtlCode", null);
            ADFUtils.findIterator("findMedicalTestsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(medTestsLOV);
            GlobalCC.hidePopup("lmsgroup:medTest");
          
        }
        catch(Exception ex)
        {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
        }
      return null;
    }
    
    public String DeleteMedicalTests() {
        Connection conn=null;
        String Result = "F";
      try 
      {
          DCIteratorBinding dciter = ADFUtils.findIterator("findMedicalTestsIterator");
          RowKeySet set =medTestsLOV.getSelectedRowKeys();
          Iterator rowKeySetIter = set.iterator();
          
          //System.out.println(1);
          while (rowKeySetIter.hasNext()) 
          {
              List l = (List) rowKeySetIter.next();
              Key key = (Key)l.get(0);
              dciter.setCurrentRowWithKey(key.toStringFormat(true));
              Row r = dciter.getCurrentRow();
            
              session.setAttribute("mtlCode", r.getAttribute("MTL_CODE"));
              
              String authQuery="BEGIN LMS_SETUPS_PKG.deleteMedTests(?);END;";
              conn=new DBConnector().getDatabaseConn();
              
              CallableStatement cstmt=conn.prepareCall(authQuery);    
              cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("mtlCode"));
           
              cstmt.execute();
              conn.close();

          }
          session.setAttribute("mtlCode", null);
            ADFUtils.findIterator("findMedicalTestsIterator").executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(medTestsLOV);
            GlobalCC.INFORMATIONREPORTING("Record Successfully Deleted");
        Result = "S";
        
      }
      catch(Exception ex)
      {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
      }
      return Result;
    }
    
    public String AddFacilitatorTests(){
        try{
            
            facDesc.setValue(null);
            session.setAttribute("facCode", null);
            facFee.setValue(null);
            facWEF.setValue(null);
            facWET.setValue(null);
            session.setAttribute("ftlCode", null);
           
            
            // Render Popup
            ExtendedRenderKitService erkService =
            Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
            ExtendedRenderKitService.class);
            erkService.addScript(FacesContext.getCurrentInstance(),
            "var hints = {autodismissNever:false}; " +
            "AdfPage.PAGE.findComponent('" + "lmsgroup:facilTests" +
            "').show(hints);");
            
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }
    
    public String EditFacilitatorTests(){
      
      DCIteratorBinding dciter = ADFUtils.findIterator("findFacilitatorTestsIterator");
      RowKeySet set =medFacilLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      
      //System.out.println(1);
      while (rowKeySetIter.hasNext()) 
      {
          List l = (List) rowKeySetIter.next();
          Key key = (Key)l.get(0);
          dciter.setCurrentRowWithKey(key.toStringFormat(true));
          Row r = dciter.getCurrentRow();
        
          session.setAttribute("ftlCode", r.getAttribute("FTL_CODE"));
          
          facDesc.setValue(r.getAttribute("MTL_SHT_DESC"));
          facFee.setValue(r.getAttribute("FTL_FEES"));
          facWEF.setValue(r.getAttribute("FTL_WEF"));
          facWET.setValue(r.getAttribute("FTL_WET"));

          // Render Popup
          ExtendedRenderKitService erkService =
          Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
          ExtendedRenderKitService.class);
          erkService.addScript(FacesContext.getCurrentInstance(),
          "var hints = {autodismissNever:false}; " +
          "AdfPage.PAGE.findComponent('" + "lmsgroup:facilTests" +
          "').show(hints);");

      }
        
         
      return null;
    }
    
    public String SaveFacilitatorTests() {
        Connection conn=null;
        try 
        {
            
            if(facDesc.getValue()==null){
                String Message = "Select A Medical Test";
                FacesContext.getCurrentInstance().addMessage(null, 
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                              Message, 
                                                                              Message));
                return null;
            }
            
            if(facFee.getValue()==null){
                String Message = "Enter A Fee";
                FacesContext.getCurrentInstance().addMessage(null, 
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                              Message, 
                                                                              Message));
                return null;
            }
            
            Boolean WEFDateChanged = false;
            Boolean WETDateChanged = false;
            
            if(facWEF.getValue()==null){
            }else{
                WEFDateChanged = facWEF.getValue().toString().contains(":");
            }
            
            if(facWET.getValue()==null){
            }else{
                WETDateChanged = facWET.getValue().toString().contains(":");
            }

           
            
            String authQuery="BEGIN LMS_SETUPS_PKG.updateFacilTests(?,?,?,?,?,?);END;";
            conn=new DBConnector().getDatabaseConn();
            
            CallableStatement cstmt=conn.prepareCall(authQuery);    
            cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("ftlCode"));
            if(facFee.getValue()==null){
                cstmt.setString(2, null);
            }else{
                cstmt.setString(2, facFee.getValue().toString());  
            }
            if(facWEF.getValue()==null){
                    cstmt.setString(3, null);
            }else{
                    if(WEFDateChanged==false){
                        cstmt.setString(3, null); 
                }else{
                        cstmt.setString(3, LOVCC.parseDate(facWEF.getValue().toString()));   
                    }
            }
            if(facWET.getValue()==null){
                    cstmt.setString(4, null);
            }else{
                    if(WETDateChanged==false){
                        cstmt.setString(4, null); 
                    }else{
                        cstmt.setString(4, LOVCC.parseDate(facWET.getValue().toString()));   
                }
            }
            cstmt.setBigDecimal(5, (BigDecimal)session.getAttribute("sprCode"));
            cstmt.setBigDecimal(6, (BigDecimal)session.getAttribute("facCode"));
           
            cstmt.execute();
            conn.close();
            
            String Message = "Facilitator Medical Test Saved succesfully.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            
            session.setAttribute("ftlCode", null);
            session.setAttribute("facCode", null);
            ADFUtils.findIterator("findFacilitatorTestsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(medFacilLOV);    
          
        }
        catch(Exception ex)
        {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
        }
      return null;
    }
    
    public String DeleteFacilitatorTests() {
        Connection conn=null;
        String Result = "F";
      try 
      {
          DCIteratorBinding dciter = ADFUtils.findIterator("findFacilitatorTestsIterator");
          RowKeySet set =medFacilLOV.getSelectedRowKeys();
          Iterator rowKeySetIter = set.iterator();
          
          //System.out.println(1);
          while (rowKeySetIter.hasNext()) 
          {
              List l = (List) rowKeySetIter.next();
              Key key = (Key)l.get(0);
              dciter.setCurrentRowWithKey(key.toStringFormat(true));
              Row r = dciter.getCurrentRow();
            
              session.setAttribute("ftlCode", r.getAttribute("FTL_CODE"));
              
              String authQuery="BEGIN LMS_SETUPS_PKG.deleteFacilTests(?);END;";
              conn=new DBConnector().getDatabaseConn();
              
              CallableStatement cstmt=conn.prepareCall(authQuery);    
              cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("ftlCode"));
           
              cstmt.execute();
              conn.close();

          }
          session.setAttribute("ftlCode", null);
            ADFUtils.findIterator("findFacilitatorTestsIterator").executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(medFacilLOV);
            GlobalCC.INFORMATIONREPORTING("Record Successfully Deleted");
        Result = "S";
        
      }
      catch(Exception ex)
      {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
      }
      return Result;
    }
    
    public String FindFacilitatorSel(){
      
      DCIteratorBinding dciter = ADFUtils.findIterator("findFacilitatorsIterator");
      RowKeySet set =facilitatorLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      
      //System.out.println(1);
      while (rowKeySetIter.hasNext()) 
      {
          List l = (List) rowKeySetIter.next();
          Key key = (Key)l.get(0);
          dciter.setCurrentRowWithKey(key.toStringFormat(true));
          Row r = dciter.getCurrentRow();
        
          session.setAttribute("sprCode", r.getAttribute("SPR_CODE"));
          sprDesc.setValue(r.getAttribute("SPR_NAME"));
          sprTown.setValue(r.getAttribute("TWN_NAME"));

            ADFUtils.findIterator("findFacilitatorTestsIterator").executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(medFacilLOV); 

      }
        
         
      return null;
    }
    
    public String FindMedicalTestSel(){
      
      DCIteratorBinding dciter = ADFUtils.findIterator("findMedicalTestsIterator");
      RowKeySet set =testsLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      
      //System.out.println(1);
      while (rowKeySetIter.hasNext()) 
      {
          List l = (List) rowKeySetIter.next();
          Key key = (Key)l.get(0);
          dciter.setCurrentRowWithKey(key.toStringFormat(true));
          Row r = dciter.getCurrentRow();
        
          session.setAttribute("facCode", r.getAttribute("MTL_CODE"));
          facDesc.setValue(r.getAttribute("MTL_DESC"));
          
          // Render Popup
          ExtendedRenderKitService erkService =
          Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
          ExtendedRenderKitService.class);
          erkService.addScript(FacesContext.getCurrentInstance(),
          "var hints = {autodismissNever:false}; " +
          "AdfPage.PAGE.findComponent('" + "lmsgroup:facilTests" +
          "').show(hints);");

      }
        
         
      return null;
    }
    
    public String showMedicalsPopup(){
        try{

            ADFUtils.findIterator("findMedicalTestsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(testsLOV); 
            
            // Render Popup
            ExtendedRenderKitService erkService =
            Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
            ExtendedRenderKitService.class);
            erkService.addScript(FacesContext.getCurrentInstance(),
            "var hints = {autodismissNever:false}; " +
            "AdfPage.PAGE.findComponent('" + "lmsgroup:p3" +
            "').show(hints);");
            
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }
    
    public void MasksListener(SelectionEvent selectionEvent) {
        // Add event code here...
        try{
            DCIteratorBinding dciter = ADFUtils.findIterator("findPremiumMasksIterator");
            RowKeySet set = selectionEvent.getAddedSet();
            Iterator rowKeySetIter = set.iterator();            
            //System.out.println(1);
            while (rowKeySetIter.hasNext()) 
            {
                List l = (List) rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();                
              session.setAttribute("pmasCode", r.getAttribute("PMAS_CODE"));                
             session.setAttribute("pctCode", null);
             session.setAttribute("dtyCode", null);
             session.setAttribute("dtyShtDesc",null);
             session.setAttribute("cvtCode", null);
             session.setAttribute("cvtShtDesc", null);

                ADFUtils.findIterator("findPremiumInterestRatesIterator").executeQuery();
                ADFUtils.findIterator("findPremiumRateTermsIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(interestLOV);
                AdfFacesContext.getCurrentInstance().addPartialTarget(termsLOV);
                ADFUtils.findIterator("findPremiumRatesIterator").executeQuery();
             AdfFacesContext.getCurrentInstance().addPartialTarget(ratesLOV);

                 

         }     
            
            
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
    }
    public String CoverDepTypeSelected(){
        try{
            DCIteratorBinding dciter = ADFUtils.findIterator("findProductDependantsIterator");
            RowKeySet set =dependantsLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();
            
            //System.out.println(1);
            while (rowKeySetIter.hasNext()) 
            {
                List l = (List) rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                
                session.setAttribute("pcdCode", r.getAttribute("PCD_CODE"));
                session.setAttribute("pctCode", r.getAttribute("PCD_PCT_CODE"));
                session.setAttribute("dtyCode", r.getAttribute("DTY_CODE"));
                session.setAttribute("dtyShtDesc", r.getAttribute("DTY_SHT_DESC"));
                session.setAttribute("cvtCode", r.getAttribute("PCD_CVT_CODE"));
                session.setAttribute("cvtShtDesc", r.getAttribute("PCD_CVT_SHT_DESC"));

                cvrTypeDepDesc.setValue(r.getAttribute("PCD_DTY_DESCRIPTION"));


                ADFUtils.findIterator("findPremiumInterestRatesIterator").executeQuery();
                ADFUtils.findIterator("findPremiumRateTermsIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(interestLOV);
                AdfFacesContext.getCurrentInstance().addPartialTarget(termsLOV);
                ADFUtils.findIterator("findPremiumRatesIterator").executeQuery();
             AdfFacesContext.getCurrentInstance().addPartialTarget(ratesLOV);
             

                 

         }     
            
            
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }
  public String CoverDepTypeSelectedLoaded(){
      try{
          DCIteratorBinding dciter = ADFUtils.findIterator("findProductDependantsIterator");
          RowKeySet set =dependantsLOV.getSelectedRowKeys();
          Iterator rowKeySetIter = set.iterator();
          
          //System.out.println(1);
          while (rowKeySetIter.hasNext()) 
          {
              List l = (List) rowKeySetIter.next();
              Key key = (Key)l.get(0);
              dciter.setCurrentRowWithKey(key.toStringFormat(true));
              Row r = dciter.getCurrentRow();

              
              session.setAttribute("pcdCode", r.getAttribute("PCD_CODE"));
              session.setAttribute("pctCode", r.getAttribute("PCD_PCT_CODE"));
              session.setAttribute("dtyCode", r.getAttribute("DTY_CODE"));
              session.setAttribute("dtyShtDesc", r.getAttribute("DTY_SHT_DESC"));
              session.setAttribute("cvtCode", r.getAttribute("PCD_CVT_CODE"));
              session.setAttribute("cvtShtDesc", r.getAttribute("PCD_CVT_SHT_DESC"));

              cvrTypeDepDesc.setValue(r.getAttribute("PCD_DTY_DESCRIPTION"));
            ADFUtils.findIterator("findImportLoadingRatesIterator").executeQuery();
             AdfFacesContext.getCurrentInstance().addPartialTarget(loadingsLOV);
           

               

       }     
          
          
      }catch(Exception e){
          GlobalCC.EXCEPTIONREPORTING(null,e);
      }
      return null;
  }
    public void ProductDependantListener(SelectionEvent selectionEvent) {
        // Add event code here...
        try{
            DCIteratorBinding dciter = ADFUtils.findIterator("findProductDependantsIterator");
            RowKeySet set = selectionEvent.getAddedSet();
            Iterator rowKeySetIter = set.iterator();
            
            //System.out.println(1);
            while (rowKeySetIter.hasNext()) 
            {
                List l = (List) rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                
                session.setAttribute("pcdCode", r.getAttribute("PCD_CODE"));
                session.setAttribute("pctCode", r.getAttribute("PCD_PCT_CODE"));
                session.setAttribute("dtyCode", r.getAttribute("DTY_CODE"));
                session.setAttribute("dtyShtDesc", r.getAttribute("DTY_SHT_DESC"));
                session.setAttribute("cvtCode", r.getAttribute("PCD_CVT_CODE"));
                session.setAttribute("cvtShtDesc", r.getAttribute("PCD_CVT_SHT_DESC"));


                ADFUtils.findIterator("findPremiumInterestRatesIterator").executeQuery();
                ADFUtils.findIterator("findPremiumRateTermsIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(interestLOV);
                AdfFacesContext.getCurrentInstance().addPartialTarget(termsLOV);
                ADFUtils.findIterator("findPremiumRatesIterator").executeQuery();
             AdfFacesContext.getCurrentInstance().addPartialTarget(ratesLOV);
             

                 

         }     
            
            
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
    }
    
    public void PremiumTermsListener(SelectionEvent selectionEvent) {
        // Add event code here...
        try{
            DCIteratorBinding dciter = ADFUtils.findIterator("findPremiumRateTermsIterator");
            RowKeySet set = selectionEvent.getAddedSet();
            Iterator rowKeySetIter = set.iterator();
            
            //System.out.println(1);
            while (rowKeySetIter.hasNext()) 
            {
                List l = (List) rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                
                session.setAttribute("grptCode", r.getAttribute("GRPT_CODE"));


                ADFUtils.findIterator("findPremiumRatesIterator").executeQuery();
             AdfFacesContext.getCurrentInstance().addPartialTarget(ratesLOV);
             

                 

         }     
            
            
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
    }
    
    public void PremiumInterestRatesListener(SelectionEvent selectionEvent) {
        // Add event code here...
        if(selectionEvent.getAddedSet()!=selectionEvent.getRemovedSet()){
        try{
            DCIteratorBinding dciter = ADFUtils.findIterator("findPremiumInterestRatesIterator");
            RowKeySet set = selectionEvent.getAddedSet();
            Iterator rowKeySetIter = set.iterator();
            
            //System.out.println(1);
            while (rowKeySetIter.hasNext()) 
            {
                List l = (List) rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                
                session.setAttribute("gpirCode", r.getAttribute("GPIR_CODE"));


                    ADFUtils.findIterator("findPremiumRatesIterator").executeQuery();
             AdfFacesContext.getCurrentInstance().addPartialTarget(ratesLOV);
             

         }     
            
            
        }catch(Exception e){
                GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        }
    }
    
    public String AddPremiumRate(){
        try{
            
            anbFrom.setValue(null);
            anbTo.setValue(null);
            rangeFrom.setValue(null);
            rangeTo.setValue(null);
            rate.setValue(null);
            annualRate.setValue(null);
            singleRate.setValue(null);
            rateDesc.setValue(null);
            divFactor.setValue(null);
            rateType.setValue(null);
            prorate.setValue(null);
            multiRate.setValue(null);
            multiDivFac.setValue(null);
            constant.setValue(null);
            constantDivFac.setValue(null);
            refund.setValue(null);
            wet.setValue(null);
            session.setAttribute("gprCode", null);          
            
            // Render Popup
            ExtendedRenderKitService erkService =
            Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
            ExtendedRenderKitService.class);
            erkService.addScript(FacesContext.getCurrentInstance(),
            "var hints = {autodismissNever:false}; " +
            "AdfPage.PAGE.findComponent('" + "lmsgroup:premRates" +
            "').show(hints);");
            
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }
    
    public String EditPremiumRate(){
      
      DCIteratorBinding dciter = ADFUtils.findIterator("findPremiumRatesIterator");
      RowKeySet set =ratesLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      
      //System.out.println(1);
      while (rowKeySetIter.hasNext()) 
      {
          List l = (List) rowKeySetIter.next();
          Key key = (Key)l.get(0);
          dciter.setCurrentRowWithKey(key.toStringFormat(true));
          Row r = dciter.getCurrentRow();        
          session.setAttribute("gprCode", r.getAttribute("GPR_CODE"));          
          anbFrom.setValue(r.getAttribute("GPR_ANB_FROM"));
          anbTo.setValue(r.getAttribute("GPR_ANB_TO"));
          rangeFrom.setValue(r.getAttribute("GPR_RANGE_FROM"));
          rangeTo.setValue(r.getAttribute("GPR_RANGE_TO"));
          rate.setValue(r.getAttribute("GPR_RATE"));
          annualRate.setValue(r.getAttribute("GPR_ANNUAL_RATE"));
          singleRate.setValue(r.getAttribute("GPR_SINGLE_RATE"));
          rateDesc.setValue(r.getAttribute("GPR_RATE_DESC"));
          divFactor.setValue(r.getAttribute("GPR_DIVISION_FACTOR"));
          rateType.setValue(r.getAttribute("GPR_RATE_TYPE"));
          prorate.setValue(r.getAttribute("GPR_PRORATED_FULL"));
          multiRate.setValue(r.getAttribute("GPR_MULTIPLIER_RATE"));
          multiDivFac.setValue(r.getAttribute("GPR_MULTPLIER_DIV_FACT"));
          constant.setValue(r.getAttribute("GPR_CONSTANT"));
          constantDivFac.setValue(r.getAttribute("GPR_CONSTANT_DIV_FACT"));
          refund.setValue(r.getAttribute("GPR_NORMAL_REFUND"));
          wef.setValue(r.getAttribute("GPR_WEF"));
          wet.setValue(r.getAttribute("GPR_WET"));
          gender.setValue(r.getAttribute("GPR_SEX"));
          
          String RateDesc = (String)r.getAttribute("GPR_RATE_DESC");
          if(RateDesc==null){
              
          }else if(RateDesc.equalsIgnoreCase("Percent")){
            divFactor.setDisabled(true);
          }else if(RateDesc.equalsIgnoreCase("Per Mille")){
            divFactor.setDisabled(true);
          }else if(RateDesc.equalsIgnoreCase("Amount")){
            divFactor.setDisabled(true);
          }else if(RateDesc.equalsIgnoreCase("Others")){
            divFactor.setDisabled(false);
          }
        

          // Render Popup
          ExtendedRenderKitService erkService =
          Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
          ExtendedRenderKitService.class);
          erkService.addScript(FacesContext.getCurrentInstance(),
          "var hints = {autodismissNever:false}; " +
          "AdfPage.PAGE.findComponent('" + "lmsgroup:premRates" +
          "').show(hints);");

      }
        
         
      return null;
    }
    
    public String SavePremiumRate() {
        Connection conn=null;
        try 
        {            
            if(anbFrom.getValue()==null){
                String Message = "Enter A ANB From";
                FacesContext.getCurrentInstance().addMessage(null, 
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                              Message, 
                                                                              Message));
                return null;
            }
            
            if(anbFrom.getValue()==null){
                String Message = "Enter A ANB To";
                FacesContext.getCurrentInstance().addMessage(null, 
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                              Message, 
                                                                              Message));
                return null;
            }
            
            if(rate.getValue()==null && annualRate.getValue()==null&& singleRate.getValue()==null){
                String Message = "Enter A Rate";
                FacesContext.getCurrentInstance().addMessage(null, 
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                              Message, 
                                                                              Message));
                return null;
            }
            
            Boolean WEFDateChanged = false;
            Boolean WETDateChanged = false;
            
            if(wef.getValue()==null){
            }else{
                WEFDateChanged = wef.getValue().toString().contains(":");
            }
            
            if(wet.getValue()==null){
            }else{
                WETDateChanged = wet.getValue().toString().contains(":");
            }           
            
            String authQuery="BEGIN LMS_SETUPS_PKG.updatePremiumRates(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);END;";
           conn=new DBConnector().getDatabaseConn();            
            
            CallableStatement cstmt=conn.prepareCall(authQuery);    
            cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("gprCode"));
            //System.out.println("testing"+session.getAttribute("gprCode")+"pmas"+session.getAttribute("pmasCode"));
            if(anbFrom.getValue()==null){
                cstmt.setString(2, null);
            }else{
                cstmt.setString(2, anbFrom.getValue().toString());  
            }
            if(anbTo.getValue()==null){
                cstmt.setString(3, null);
            }else{
                cstmt.setString(3, anbTo.getValue().toString());  
            }
            if(rangeFrom.getValue()==null){
                cstmt.setString(4, null);
            }else{
                cstmt.setString(4, rangeFrom.getValue().toString());  
            }
            if(rangeTo.getValue()==null){
                cstmt.setString(5, null);
            }else{
                cstmt.setString(5, rangeTo.getValue().toString());  
            }
            if(rate.getValue()==null){
                cstmt.setString(6, null);
            }else{
                    cstmt.setString(6, rate.getValue().toString());   
            }
            if(annualRate.getValue()==null){
                cstmt.setString(7, null);
            }else{
                    cstmt.setString(7, annualRate.getValue().toString());   
            }
            if(singleRate.getValue()==null){
                cstmt.setString(8, null);
            }else{
                    cstmt.setString(8, singleRate.getValue().toString());   
            }
            if(rateDesc.getValue()==null){
                cstmt.setString(9, null);
            }else{
                    cstmt.setString(9, rateDesc.getValue().toString());   
            }
            if(divFactor.getValue()==null){
                cstmt.setString(10, null);
            }else{
                    cstmt.setString(10, divFactor.getValue().toString());   
            }
            if(rateType.getValue()==null){
                cstmt.setString(11, null);
            }else{
                    cstmt.setString(11, rateType.getValue().toString());   
            }
            if(prorate.getValue()==null){
                cstmt.setString(12, null);
            }else{
                    cstmt.setString(12, prorate.getValue().toString());   
            }
            if(multiRate.getValue()==null){
                cstmt.setString(13, null);
            }else{
                    cstmt.setString(13, multiRate.getValue().toString());   
            }
            if(multiDivFac.getValue()==null){
                cstmt.setString(14, null);
            }else{
                    cstmt.setString(14, multiDivFac.getValue().toString());   
            }
            if(constant.getValue()==null){
                cstmt.setString(15, null);
            }else{
                    cstmt.setString(15, constant.getValue().toString());   
            }
            if(constantDivFac.getValue()==null){
                cstmt.setString(16, null);
            }else{
                    cstmt.setString(16, constantDivFac.getValue().toString());   
            }
            if(refund.getValue()==null){
                cstmt.setString(17, null);
            }else{
                    cstmt.setString(17, refund.getValue().toString());   
            }
            if(wef.getValue()==null){
                cstmt.setString(18, null);
            }else{
                if(WEFDateChanged==false){
                    cstmt.setString(18, null); 
                }else{
                    cstmt.setString(18, LOVCC.parseDate(wef.getValue().toString()));   
                }
            }
            if(wet.getValue()==null){
                cstmt.setString(19, null);
            }else{
                if(WETDateChanged==false){
                    cstmt.setString(19, null); 
                }else{
                    cstmt.setString(19, LOVCC.parseDate(wet.getValue().toString()));   
                }
            }
            cstmt.setBigDecimal(20, (BigDecimal)session.getAttribute("pctCode"));
            cstmt.setBigDecimal(21, (BigDecimal)session.getAttribute("pmasCode"));
            cstmt.setBigDecimal(22, (BigDecimal)session.getAttribute("pcdCode"));
            cstmt.setBigDecimal(23, (BigDecimal)session.getAttribute("dtyCode"));
            cstmt.setString(24, (String)session.getAttribute("dtyShtDesc"));
            cstmt.setBigDecimal(25, (BigDecimal)session.getAttribute("grptCode"));
            cstmt.setBigDecimal(26, (BigDecimal)session.getAttribute("gpirCode"));
            cstmt.setBigDecimal(27, (BigDecimal)session.getAttribute("lcCode")); //lc Code
            cstmt.setBigDecimal(28, (BigDecimal)session.getAttribute("cvtCode"));
            cstmt.setString(29, (String)session.getAttribute("cvtShtDesc"));
            cstmt.setBigDecimal(30, (BigDecimal)session.getAttribute("schCode"));
            if(gender.getValue()==null){
                cstmt.setString(31, null);
            }else{
                    cstmt.setString(31, gender.getValue().toString());   
            }
            if(grpSingleRate.getValue()==null){
              cstmt.setString(32,null);
            }else{
              cstmt.setString(32,grpSingleRate.getValue().toString());
            }
         

            cstmt.execute();
            conn.close();
            
            String Message = "Premium Rate Rate Saved succesfully.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            
            session.setAttribute("gprCode", null);
            ADFUtils.findIterator("findPremiumRatesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(ratesLOV);    
          
        }
        catch(Exception ex)
        {
          ex.printStackTrace();
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
        }
      return null;
    }
    
  public String CreateImportedAnnuityRate(Integer TemplateCode) {
      Connection conn=null;
      try 
      {
          
          String authQuery="BEGIN LMS_SETUPS_PKG.createImpAnnRates(?,?);END;";
         conn=new DBConnector().getDatabaseConn();
          
          
          CallableStatement cstmt=conn.prepareCall(authQuery);   
          cstmt.setInt(1, TemplateCode);
          cstmt.setBigDecimal(2, (BigDecimal)session.getAttribute("ProductCode"));
         
          cstmt.execute();
          conn.close();
          
          String Message = "Annuity Rate Rate Saved succesfully.";
          FacesContext.getCurrentInstance().addMessage(null, 
                                                       new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                        Message, 
                                                                        Message));
      }
      catch(Exception ex)
      {
          GlobalCC.EXCEPTIONREPORTING(conn,ex);
      }
    return null;
  }
    
    public String CreateImportedPremiumRate(Integer TemplateCode) {
        Connection conn=null;
        try 
        {
            
            String authQuery="BEGIN LMS_SETUPS_PKG.CreateImportedPremiumRates(?,?,?,?,?,?,?,?,?,?,?,?,?);END;";
           conn=new DBConnector().getDatabaseConn();
            CallableStatement cstmt=conn.prepareCall(authQuery);   
            cstmt.setInt(1, TemplateCode);
            cstmt.setBigDecimal(2, (BigDecimal)session.getAttribute("gprCode"));
            System.out.println(session.getAttribute("gprCode"));
            cstmt.setBigDecimal(3, (BigDecimal)session.getAttribute("pctCode"));
            cstmt.setBigDecimal(4, (BigDecimal)session.getAttribute("pmasCode"));
            cstmt.setBigDecimal(5, (BigDecimal)session.getAttribute("pcdCode"));
            cstmt.setBigDecimal(6, (BigDecimal)session.getAttribute("dtyCode"));
            cstmt.setString(7, (String)session.getAttribute("dtyShtDesc"));
            cstmt.setBigDecimal(8, (BigDecimal)session.getAttribute("grptCode"));
            cstmt.setBigDecimal(9, (BigDecimal)session.getAttribute("gpirCode"));
            cstmt.setBigDecimal(10, (BigDecimal)session.getAttribute("lcCode")); //lc Code
            cstmt.setBigDecimal(11, (BigDecimal)session.getAttribute("cvtCode"));
            cstmt.setString(12, (String)session.getAttribute("cvtShtDesc"));
            cstmt.setString(13, (String)session.getAttribute("grp_single_rate"));
         

           
            cstmt.execute();
            conn.close();
            
            String Message = "Premium Rate Rate Saved succesfully.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            
            session.setAttribute("gprCode", null);
            //ADFUtils.findIterator("findPremiumRatesIterator").executeQuery();
            //AdfFacesContext.getCurrentInstance().addPartialTarget(ratesLOV);    
          
        }
        catch(Exception ex)
        {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
        }
      return null;
    }
  public String CreateImportedLoadings(Integer TemplateCode) {
      Connection conn=null;
      try 
      {
          
          String authQuery="BEGIN LMS_SETUPS_PKG.CreateImportedLoadings(?,?,?,?,?,?,?,?);END;";
         conn=new DBConnector().getDatabaseConn();
          
          
          CallableStatement cstmt=conn.prepareCall(authQuery);   
          cstmt.setInt(1, TemplateCode);
          cstmt.setBigDecimal(2, (BigDecimal)session.getAttribute("pctCode"));
          cstmt.setBigDecimal(3, (BigDecimal)session.getAttribute("pmasCode"));
          cstmt.setBigDecimal(4, (BigDecimal)session.getAttribute("pcdCode"));
          cstmt.setBigDecimal(5, (BigDecimal)session.getAttribute("lcCode"));
          cstmt.setBigDecimal(6, (BigDecimal)session.getAttribute("dtyCode"));
          cstmt.setString(7, (String)session.getAttribute("dtyShtDesc"));
          cstmt.setString(8, (String)session.getAttribute("grp_single_rate"));
          cstmt.execute();
          conn.close();
          
          String Message = "loading successful.";
          FacesContext.getCurrentInstance().addMessage(null, 
                                                       new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                        Message, 
                                                                        Message));
          
        /* ADFUtils.findIterator("findImportLoadingRatesIterator").executeQuery();
         AdfFacesContext.getCurrentInstance().addPartialTarget(loadingsLOV);  */  
        
      }
      catch(Exception ex)
      {
          GlobalCC.EXCEPTIONREPORTING(conn,ex);
      }
    return null;
  }
    
    
    public String RefreshRates(){
        try{
            ADFUtils.findIterator("findPremiumRatesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(ratesLOV);    
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
                return null;
    }
  public String RefreshLoadingRates(){
      try{
        ADFUtils.findIterator("findImportLoadingRatesIterator").executeQuery();
                 AdfFacesContext.getCurrentInstance().addPartialTarget(loadingsLOV); 
      }catch(Exception e){
          GlobalCC.EXCEPTIONREPORTING(null, e);
      }
              return null;
  }
    
    public void processCSVForRates(InputStream csvFile) {
        // Parse the data, using http://ostermiller.org/utils/download.html
        boolean addBatch = false;
        String[][] csvvalues = null;
        Integer RatesTemplate = null;
        try {
            List rows = new ArrayList();
            int numberOfColumns;
            
            Connection conn;
            conn = new DBConnector().getDatabaseConn();

            CallableStatement cst = null;
            CallableStatement inst = null;
            CallableStatement seq = null;
            String seleSeq = "SELECT LMS_LRID_CODE_SEQ.NEXTVAL FROM DUAL";
            seq = conn.prepareCall(seleSeq);
            ResultSet rs = seq.executeQuery();
            RatesTemplate = 0;
            while(rs.next()){
            RatesTemplate = rs.getInt(1);
            }
            String insertQuery = "INSERT INTO LMS_RATES_IMPORT_TRANS VALUES (?,?,?,?)";
            inst = conn.prepareCall(insertQuery);
            String importQuery =
                "INSERT INTO LMS_RATES_IMPORT_DETAILS (LRID_CODE,LRID_LRIT_CODE,LRID_ANB,LRID_ANB_TO,LRID_RATE,LRID_SINGLE_RATE,LRID_ANNUAL_RATE,LRID_RATE_DESC,\n" + 
                "LRID_DIV_FACTOR,LRID_WEF,LRID_WET,LRID_SEX,LRID_ANN_TYPE,LRID_GUARN_PRD,LRID_OPTION,\n" + 
                "LRID_RETIRE_AGE,LRID_RANGE_FROM,LRID_RANGE_TO,LRID_PRORATED_FULL)VALUES (LMS_LRIT_CODE_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            cst = conn.prepareCall(importQuery);

            //register out
            
           
            csvvalues = CSVParser.parse(new InputStreamReader(csvFile));
        
        rows = new ArrayList();

        numberOfColumns = 0;
            
        for (int i = 0; i < csvvalues.length; i++) {
            Map tablerow = new HashMap();
            int k = 0;
            for (int j = 0; j < csvvalues[i].length; j++) {
                
                if (j > numberOfColumns){
                    numberOfColumns = j;
                }
                    
                tablerow.put("cell" + (j + 1), csvvalues[i][j]);
                if(i==0){
                    if(j==0){
                       /* templateType = csvvalues[i][j];
                        if(templateType==null){
                            LOVCC.templayeTypeInt = 0;
                        }else{
                            if(templateType.equalsIgnoreCase("")){
                                LOVCC.templayeTypeInt = 0; 
                            }else if(templateType.equalsIgnoreCase("EARN")){
                                LOVCC.templayeTypeInt = 1;
                            }else if(templateType.equalsIgnoreCase("FUNE")){
                                LOVCC.templayeTypeInt = 2;
                            }else if(templateType.equalsIgnoreCase("LOAN")){
                                LOVCC.templayeTypeInt = 3;
                            }else if(templateType.equalsIgnoreCase("PENS")){
                                LOVCC.templayeTypeInt = 4;
                            }
                        }*/
                        inst.setInt(1, RatesTemplate);
                        Date now = new Date();
                        inst.setString(2, LOVCC.parseDate(now.toString()));
                        inst.setString(3,(String)session.getAttribute("Username"));
                        inst.setString(4, null);
                        //inst.setBigDecimal(5,(BigDecimal)session.getAttribute("policyCode"));
       
                        inst.execute();
                    }
                }
                if(i >=1){
                       
                        cst.setInt(1, RatesTemplate);// Member Code.
                        cst.setString(2,csvvalues[i][0]);//ANB FROM
                       if(GlobalCC.CheckNullExcelValues(csvvalues[i][1])==0){
                        cst.setBigDecimal(3,null);//ANB TO
                       }else{
                        cst.setBigDecimal(3,new BigDecimal(csvvalues[i][1]));//ANB TO
                         }
                       if(GlobalCC.CheckNullExcelValues(csvvalues[i][2])==0){
                        cst.setBigDecimal(4,null);//Rate
                       }else{
                        cst.setBigDecimal(4,new BigDecimal(csvvalues[i][2]));//Rate
                       }
                       if(GlobalCC.CheckNullExcelValues(csvvalues[i][3])==0){
                         cst.setBigDecimal(5,null);//Single Rate
                       }else{
                         cst.setString(5,csvvalues[i][3]);//Single Rate
                       }
                       if(GlobalCC.CheckNullExcelValues(csvvalues[i][4])==0){
                         cst.setBigDecimal(6,null);//Annual Rate
                       }else{
                         cst.setString(6,csvvalues[i][4]);//Annual Rate
                       }
                       if(GlobalCC.CheckNullExcelValues(csvvalues[i][5])==0){
                         cst.setBigDecimal(7,null);//Rate Description
                       }else{
                         cst.setString(7,csvvalues[i][5]);//Rate Description 
                       } 
                       if(GlobalCC.CheckNullExcelValues(csvvalues[i][6])==0){
                         cst.setBigDecimal(8,null);//Division Factor
                       }else{
                         cst.setString(8,csvvalues[i][6]);//Division Factor
                       } 
                       if(GlobalCC.CheckNullExcelValues(csvvalues[i][7])==0){
                         cst.setString(9,null);//WEF
                       }else{
                         cst.setString(9,csvvalues[i][7]);//WEF 
                       } 
                       if(GlobalCC.CheckNullExcelValues(csvvalues[i][8])==0){
                         cst.setString(10,null);//WET
                       }else{
                         cst.setString(10,csvvalues[i][8]);//WET
                       } 
                       if(GlobalCC.CheckNullExcelValues(csvvalues[i][9])==0){
                         cst.setString(11,null);//SEX
                       }else{
                         cst.setString(11,csvvalues[i][9]);//SEX
                       } 
                     cst.setString(12,null);//LRID_ANN_TYPE
                     cst.setString(13,null);//LRID_GUARN_PRD
                     cst.setString(14,null);//LRID_OPTION
                     cst.setString(15,null);//LRID_RETIRE_AGE
                     if(GlobalCC.CheckNullExcelValues(csvvalues[i][10])==0){
                       cst.setString(16,null);///RANGE FROM.
                     }else{
                       cst.setString(16,csvvalues[i][10]);//RANGE FROM.
                     } 
                     if(GlobalCC.CheckNullExcelValues(csvvalues[i][11])==0){
                       cst.setString(17,null);//RANGE TO.
                     }else{
                       cst.setString(17,csvvalues[i][11]);//RANGE TO.
                     } 
                     if(GlobalCC.CheckNullExcelValues(csvvalues[i][12])==0){
                       cst.setString(18,null);//PRORATED.
                     }else{
                       cst.setString(18,csvvalues[i][12]);//PRORATED
                     } 
                        addBatch = true;
                   }

                System.out.println("cell" + (j + 1));
                System.out.println(csvvalues[i][j]);
                System.out.println("Another");
                //k++;
            } // for cells
            rows.add(tablerow);
            if(addBatch==true){
                cst.addBatch();
                addBatch = false;
            }
            
        } // for rows
       
        cst.executeBatch();
        conn.close();
        CreateImportedPremiumRate(RatesTemplate);
       
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
            e.printStackTrace();
        }
        
    }
  public void processCSVForLoadings(InputStream csvFile) {
      // Parse the data, using http://ostermiller.org/utils/download.html
      boolean addBatch = false;
      String[][] csvvalues = null;
      Integer RatesTemplate = null;
      try {
          List rows = new ArrayList();
          int numberOfColumns;
          
          Connection conn;
          conn = new DBConnector().getDatabaseConn();

          CallableStatement cst = null;
          CallableStatement inst = null;
          CallableStatement seq = null;
          String seleSeq = "SELECT LMS_LLIT_CODE.NEXTVAL FROM DUAL";
          seq = conn.prepareCall(seleSeq);
          ResultSet rs = seq.executeQuery();
          RatesTemplate = 0;
          while(rs.next()){
          RatesTemplate = rs.getInt(1);
          }
          String insertQuery = "INSERT INTO LMS_LOADINGS_IMPORT_TRANS VALUES (?,?,?,?)";
          inst = conn.prepareCall(insertQuery);
          String importQuery =
              "INSERT INTO LMS_IMPORT_GRP_LOADING_RATES (IGLR_CODE,IGLR_AGE,IGLR_SEX,IGLR_CLASS,IGLR_RANGE_FROM,IGLR_RANGE_TO,IGLR_RATE," +
              "IGLR_DIV_FACT,IGLR_WEF,IGLR_WET,IGLR_PCTL_CODE,IGLR_LLIT_CODE) VALUES(LMS_LRIT_CODE_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?)";
          cst = conn.prepareCall(importQuery);
          
          //register out
          System.out.println(importQuery);
         
          csvvalues = CSVParser.parse(new InputStreamReader(csvFile));
      
      rows = new ArrayList();

      numberOfColumns = 0;
          
      for (int i = 0; i < csvvalues.length; i++) {
          Map tablerow = new HashMap();
          int k = 0;
          for (int j = 0; j < csvvalues[i].length; j++) {
              
              if (j > numberOfColumns){
                  numberOfColumns = j;
              }
                  
              tablerow.put("cell" + (j + 1), csvvalues[i][j]);
              if(i==0){
                  if(j==0){
                     /* templateType = csvvalues[i][j];
                      if(templateType==null){
                          LOVCC.templayeTypeInt = 0;
                      }else{
                          if(templateType.equalsIgnoreCase("")){
                              LOVCC.templayeTypeInt = 0; 
                          }else if(templateType.equalsIgnoreCase("EARN")){
                              LOVCC.templayeTypeInt = 1;
                          }else if(templateType.equalsIgnoreCase("FUNE")){
                              LOVCC.templayeTypeInt = 2;
                          }else if(templateType.equalsIgnoreCase("LOAN")){
                              LOVCC.templayeTypeInt = 3;
                          }else if(templateType.equalsIgnoreCase("PENS")){
                              LOVCC.templayeTypeInt = 4;
                          }
                      }*/
                      inst.setInt(1, RatesTemplate);
                      Date now = new Date();
                      inst.setString(2, LOVCC.parseDate(now.toString()));
                      inst.setString(3,(String)session.getAttribute("Username"));
                      inst.setString(4, null);
                      //inst.setBigDecimal(5,(BigDecimal)session.getAttribute("policyCode"));
     
                      inst.execute();
                  }
              }
              if(i >=1){
                     
                     if(GlobalCC.CheckNullExcelValues(csvvalues[i][0])==0){
                      cst.setBigDecimal(1,null);//Age
                     }else{
                      cst.setBigDecimal(1,new BigDecimal(csvvalues[i][0]));//Age
                     }
                     if(GlobalCC.CheckNullExcelValues(csvvalues[i][1])==0){
                       cst.setString(2,null);//Sex
                     }else{
                       cst.setString(2,csvvalues[i][1]);//Sex
                     }
                     if(GlobalCC.CheckNullExcelValues(csvvalues[i][2])==0){
                       cst.setBigDecimal(3,null);//class
                     }else{
                       cst.setString(3,csvvalues[i][2]);//class
                     }
                     if(GlobalCC.CheckNullExcelValues(csvvalues[i][3])==0){
                       cst.setBigDecimal(4,null);//Range From
                     }else{
                       cst.setString(4,csvvalues[i][3]);//Range From
                     } 
                     if(GlobalCC.CheckNullExcelValues(csvvalues[i][4])==0){
                       cst.setBigDecimal(5,null);//Range To
                     }else{
                       cst.setString(5,csvvalues[i][4]);//Range To
                     } 
                     if(GlobalCC.CheckNullExcelValues(csvvalues[i][5])==0){
                       cst.setString(6,null);//Rate
                     }else{
                       cst.setString(6,csvvalues[i][5]);//Rate
                     } 
                     if(GlobalCC.CheckNullExcelValues(csvvalues[i][6])==0){
                       cst.setString(7,null);//Rate div
                     }else{
                       cst.setString(7,csvvalues[i][6]);//Rate div
                     } 
                     if(GlobalCC.CheckNullExcelValues(csvvalues[i][7])==0){
                       cst.setString(8,null);//WEF
                     }else{
                       cst.setString(8,csvvalues[i][7]);//WEF
                     } 
                   if(GlobalCC.CheckNullExcelValues(csvvalues[i][8])==0){
                     cst.setString(9,null);//WEF
                   }else{
                     cst.setString(9,csvvalues[i][8]);//WEF
                   } 
                   cst.setBigDecimal(10,(BigDecimal)session.getAttribute("pctl_code"));
                   cst.setInt(11,RatesTemplate);
                  
                      addBatch = true;
                 }
  //k++;
          } // for cells
          rows.add(tablerow);
          if(addBatch==true){
              cst.addBatch();
              addBatch = false;
          }
          
      } // for rows
     
      cst.executeBatch();
      conn.close();

      CreateImportedLoadings(RatesTemplate);
     
      } catch (Exception e) {
          GlobalCC.EXCEPTIONREPORTING(null, e);
          e.printStackTrace();
      }
      
  }
    
  public void processCSVForAnnRates(InputStream csvFile) {
      // Parse the data, using http://ostermiller.org/utils/download.html
      boolean addBatch = false;
      String[][] csvvalues = null;
      Integer RatesTemplate = null;
      try {
          List rows = new ArrayList();
          int numberOfColumns;
          
          Connection conn;
          conn = new DBConnector().getDatabaseConn();

          CallableStatement cst = null;
          CallableStatement inst = null;
          CallableStatement seq = null;
          String seleSeq = "SELECT LMS_LRID_CODE_SEQ.NEXTVAL FROM DUAL";
          seq = conn.prepareCall(seleSeq);
          ResultSet rs = seq.executeQuery();
          RatesTemplate = 0;
          while(rs.next()){
          RatesTemplate = rs.getInt(1);
          }
          String insertQuery = "INSERT INTO LMS_RATES_IMPORT_TRANS VALUES (?,?,?,?)";
          inst = conn.prepareCall(insertQuery);
          String importQuery =
              "INSERT INTO LMS_RATES_IMPORT_DETAILS VALUES (LMS_LRIT_CODE_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
          cst = conn.prepareCall(importQuery);

          //register out
         
          csvvalues = CSVParser.parse(new InputStreamReader(csvFile));
      
      rows = new ArrayList();

      numberOfColumns = 0;
          
      for (int i = 0; i < csvvalues.length; i++) {
          Map tablerow = new HashMap();
          int k = 0;
          for (int j = 0; j < csvvalues[i].length; j++) {
              
              if (j > numberOfColumns){
                  numberOfColumns = j;
              }
                  
              tablerow.put("cell" + (j + 1), csvvalues[i][j]);
              if(i==0){
                  if(j==0){
                     /* templateType = csvvalues[i][j];
                      if(templateType==null){
                          LOVCC.templayeTypeInt = 0;
                      }else{
                          if(templateType.equalsIgnoreCase("")){
                              LOVCC.templayeTypeInt = 0; 
                          }else if(templateType.equalsIgnoreCase("EARN")){
                              LOVCC.templayeTypeInt = 1;
                          }else if(templateType.equalsIgnoreCase("FUNE")){
                              LOVCC.templayeTypeInt = 2;
                          }else if(templateType.equalsIgnoreCase("LOAN")){
                              LOVCC.templayeTypeInt = 3;
                          }else if(templateType.equalsIgnoreCase("PENS")){
                              LOVCC.templayeTypeInt = 4;
                          }
                      }*/
                      inst.setInt(1, RatesTemplate);
                      Date now = new Date();
                      inst.setString(2, LOVCC.parseDate(now.toString()));
                      inst.setString(3,(String)session.getAttribute("Username"));
                      inst.setString(4, null);
                      //inst.setBigDecimal(5,(BigDecimal)session.getAttribute("policyCode"));
     
                      inst.execute();
                  }
              }
              if(i >=1){
                     
                      cst.setInt(1, RatesTemplate);// Member Code.
                      cst.setString(2,csvvalues[i][4]);//ANB
                     if(GlobalCC.CheckNullExcelValues(csvvalues[i][5])==0){
                      cst.setBigDecimal(3,null);//Rate
                     }else{
                      cst.setBigDecimal(3,new BigDecimal(csvvalues[i][5]));//Rate
                     }
                     cst.setBigDecimal(4,null);//Single Rate
                     cst.setBigDecimal(5,null);//Annual Rate
                     cst.setBigDecimal(6,null);//Rate Description
                     cst.setBigDecimal(7,null);//Division Factor
                     cst.setString(8,null);//WEF
                     cst.setString(9,null);//WET
                     if(GlobalCC.CheckNullExcelValues(csvvalues[i][6])==0){
                      cst.setBigDecimal(10,null);//SEX
                     }else{
                      cst.setString(10,csvvalues[i][6]);//SEX
                     }
                     if(GlobalCC.CheckNullExcelValues(csvvalues[i][0])==0){
                      cst.setBigDecimal(11,null);//Ann Type
                     }else{
                      cst.setString(11,csvvalues[i][0]);//Ann Type
                     }
                     if(GlobalCC.CheckNullExcelValues(csvvalues[i][1])==0){
                      cst.setBigDecimal(12,null);//GUARANTEED PERIOD
                     }else{
                      cst.setBigDecimal(12,new BigDecimal(csvvalues[i][1]));//GUARANTEED PERIOD
                     }
                     if(GlobalCC.CheckNullExcelValues(csvvalues[i][2])==0){
                      cst.setBigDecimal(13,null);//Options 
                     }else{
                      cst.setString(13,csvvalues[i][2]);//Options 
                     }
                     if(GlobalCC.CheckNullExcelValues(csvvalues[i][3])==0){
                      cst.setBigDecimal(14,null);//RETIREMENT
                     }else{
                      cst.setBigDecimal(14,new BigDecimal(csvvalues[i][3]));//RETIREMENT
                     }
                      cst.setBigDecimal(15,null);//RANGE FROM
                      cst.setBigDecimal(16,null);//RANGE TO
                      addBatch = true;
                 }

              System.out.println("cell" + (j + 1));
              System.out.println(csvvalues[i][j]);
              System.out.println("Another");
              //k++;
          } // for cells
          rows.add(tablerow);
          if(addBatch==true){
              cst.addBatch();
              addBatch = false;
          }
          
      } // for rows
     
      cst.executeBatch();
          conn.close();

       CreateImportedAnnuityRate(RatesTemplate);
     
      } catch (Exception e) {
          GlobalCC.EXCEPTIONREPORTING(null, e);
      }
      
  }
    
   /* public String DeletePremiumRate() {
        Connection conn=null;
     
      try 
      {
          conn=new DBConnector().getDatabaseConn();
          DCIteratorBinding dciter = ADFUtils.findIterator("findPremiumRatesIterator");
          RowKeySet set =ratesLOV.getSelectedRowKeys();
          Iterator rowKeySetIter = set.iterator();
          
          //System.out.println(1);
          while (rowKeySetIter.hasNext()) 
          {
              List l = (List) rowKeySetIter.next();
              Key key = (Key)l.get(0);
              dciter.setCurrentRowWithKey(key.toStringFormat(true));
              Row r = dciter.getCurrentRow();
            
              session.setAttribute("gprCode", r.getAttribute("GPR_CODE"));
              
              String authQuery="BEGIN LMS_SETUPS_PKG.deletePremiumRates(?);END;";
            
              
              CallableStatement cstmt=conn.prepareCall(authQuery);    
              cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("gprCode"));
           
              cstmt.execute();
             

          }
          conn.close();
          session.setAttribute("gprCode", null);
            ADFUtils.findIterator("findPremiumRatesIterator").executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(ratesLOV);    
        
      }
      catch(Exception ex)
      {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
      }
      return null;
    }
    */
    public void MedicalGroupsListener(SelectionEvent selectionEvent) {
        // Add event code here...
        try{
            DCIteratorBinding dciter = ADFUtils.findIterator("findMedTestGroupsIterator");
            RowKeySet set = selectionEvent.getAddedSet();
            Iterator rowKeySetIter = set.iterator();
            
            //System.out.println(1);
            while (rowKeySetIter.hasNext()) 
            {
                List l = (List) rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                
                session.setAttribute("mtgCode", r.getAttribute("MTG_CODE"));


                ADFUtils.findIterator("findMedTestGroupTestsIterator").executeQuery();
             AdfFacesContext.getCurrentInstance().addPartialTarget(medGrpItemsLOV);
             

         }     
            
            
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
    }
    
    public String AddMedicalGroup(){
        try{
            
            shortDesc.setValue(null);
            desc.setValue(null);
            wef.setValue(null);
            wet.setValue(null);
            session.setAttribute("mtgCode", null);
           
            
            // Render Popup
            ExtendedRenderKitService erkService =
            Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
            ExtendedRenderKitService.class);
            erkService.addScript(FacesContext.getCurrentInstance(),
            "var hints = {autodismissNever:false}; " +
            "AdfPage.PAGE.findComponent('" + "lmsgroup:medGrps" +
            "').show(hints);");
            
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }
    
    public String EditMedicalGroup(){
      
      DCIteratorBinding dciter = ADFUtils.findIterator("findMedTestGroupsIterator");
      RowKeySet set =medGrpsLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      
      //System.out.println(1);
      while (rowKeySetIter.hasNext()) 
      {
          List l = (List) rowKeySetIter.next();
          Key key = (Key)l.get(0);
          dciter.setCurrentRowWithKey(key.toStringFormat(true));
          Row r = dciter.getCurrentRow();
        
          session.setAttribute("mtgCode", r.getAttribute("MTG_CODE"));
          
          shortDesc.setValue(r.getAttribute("MTL_SHT_DESC"));
          desc.setValue(r.getAttribute("MTG_DESC"));
          wef.setValue(r.getAttribute("MTG_WEF"));
          wet.setValue(r.getAttribute("MTG_WET"));

          // Render Popup
          ExtendedRenderKitService erkService =
          Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
          ExtendedRenderKitService.class);
          erkService.addScript(FacesContext.getCurrentInstance(),
          "var hints = {autodismissNever:false}; " +
          "AdfPage.PAGE.findComponent('" + "lmsgroup:medGrps" +
          "').show(hints);");

      }
        
         
      return null;
    }
    
    public String SaveMedicalGroup() {
        Connection conn=null;
        try 
        {
            
            if(shortDesc.getValue()==null){
                String Message = "Enter a Short Description";
                FacesContext.getCurrentInstance().addMessage(null, 
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                              Message, 
                                                                              Message));
                return null;
            }
            
            if(desc.getValue()==null){
                String Message = "Enter A Description";
                FacesContext.getCurrentInstance().addMessage(null, 
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                              Message, 
                                                                              Message));
                return null;
            }
            
            Boolean WEFDateChanged = false;
            Boolean WETDateChanged = false;
            
            if(wef.getValue()==null){
            }else{
                WEFDateChanged = wef.getValue().toString().contains(":");
            }
            
            if(wet.getValue()==null){
            }else{
                WETDateChanged = wet.getValue().toString().contains(":");
            }

           
            
            String authQuery="BEGIN LMS_SETUPS_PKG.updateMedicalTestGrp(?,?,?,?,?,?);END;";
            conn=new DBConnector().getDatabaseConn();
            
            CallableStatement cstmt=conn.prepareCall(authQuery);    
            cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("mtgCode"));
            if(shortDesc.getValue()==null){
                cstmt.setString(2, null);
            }else{
                cstmt.setString(2, shortDesc.getValue().toString());  
            }
            if(desc.getValue()==null){
                cstmt.setString(3, null);
            }else{
                cstmt.setString(3, desc.getValue().toString());  
            }
            if(wef.getValue()==null){
                    cstmt.setString(4, null);
            }else{
                    if(WEFDateChanged==false){
                        cstmt.setString(4, null); 
                }else{
                        cstmt.setString(4, LOVCC.parseDate(wef.getValue().toString()));   
                    }
            }
            if(wet.getValue()==null){
                    cstmt.setString(5, null);
            }else{
                    if(WETDateChanged==false){
                        cstmt.setString(5, null); 
                    }else{
                        cstmt.setString(5, LOVCC.parseDate(wet.getValue().toString()));   
                }
            }
            cstmt.setBigDecimal(6,(BigDecimal)session.getAttribute("currCode"));
            cstmt.execute();
            conn.close();
            
            String Message = "Medical Group Saved succesfully.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            
            session.setAttribute("mtgCode", null);
            ADFUtils.findIterator("findMedTestGroupsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(medGrpsLOV);    
          
        }
        catch(Exception ex)
        {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
        }
      return null;
    }
    
    public String DeleteMedicalGroup() {
        Connection conn=null;
        String Result = "F";
      try 
      {
          DCIteratorBinding dciter = ADFUtils.findIterator("findMedTestGroupsIterator");
          RowKeySet set =medGrpsLOV.getSelectedRowKeys();
          Iterator rowKeySetIter = set.iterator();
          
          //System.out.println(1);
          while (rowKeySetIter.hasNext()) 
          {
              List l = (List) rowKeySetIter.next();
              Key key = (Key)l.get(0);
              dciter.setCurrentRowWithKey(key.toStringFormat(true));
              Row r = dciter.getCurrentRow();
            
              session.setAttribute("mtgCode", r.getAttribute("MTG_CODE"));
              
              String authQuery="BEGIN LMS_SETUPS_PKG. deleteMedicalTestGrp(?);END;";
              conn=new DBConnector().getDatabaseConn();
              
              CallableStatement cstmt=conn.prepareCall(authQuery);    
              cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("mtgCode"));
           
              cstmt.execute();
              conn.close();

          }
          session.setAttribute("mtgCode", null);
            ADFUtils.findIterator("findMedTestGroupsIterator").executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(medGrpsLOV);
            GlobalCC.INFORMATIONREPORTING("Record Successfully Deleted");
        Result = "S";
        
      }
      catch(Exception ex)
      {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
      }
      return Result;
    }
    
    public String AddMedicalGroupItem() {
        Connection conn=null;
      try 
      {
          BigDecimal mtlCode = null;
          
          DCIteratorBinding dciter = ADFUtils.findIterator("findMedicalTestsIterator");
          RowKeySet set =testsLOV.getSelectedRowKeys();
          Iterator rowKeySetIter = set.iterator();
          
          //System.out.println(1);
          while (rowKeySetIter.hasNext()) 
          {
              List l = (List) rowKeySetIter.next();
              Key key = (Key)l.get(0);
              dciter.setCurrentRowWithKey(key.toStringFormat(true));
              Row r = dciter.getCurrentRow();
            
             
              mtlCode =  (BigDecimal)r.getAttribute("MTL_CODE");
              
              String authQuery="BEGIN LMS_SETUPS_PKG.addMedTestGrpitem(?,?);END;";
              conn=new DBConnector().getDatabaseConn();
              
              CallableStatement cstmt=conn.prepareCall(authQuery);    
              cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("mtgCode"));
              cstmt.setBigDecimal(2, mtlCode);
           
              cstmt.execute();
              conn.close();

          }
            ADFUtils.findIterator("findMedTestGroupTestsIterator").executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(medGrpItemsLOV);    
        
      }
      catch(Exception ex)
      {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
      }
      return null;
    }
    
    public String DeleteMedicalGroupItem() {
        Connection conn=null;
        String Result = "F";
      try 
      {
          BigDecimal Var = null;
          DCIteratorBinding dciter = ADFUtils.findIterator("findMedTestGroupTestsIterator");
          RowKeySet set =medGrpItemsLOV.getSelectedRowKeys();
          Iterator rowKeySetIter = set.iterator();
          
          //System.out.println(1);
          while (rowKeySetIter.hasNext()) 
          {
              List l = (List) rowKeySetIter.next();
              Key key = (Key)l.get(0);
              dciter.setCurrentRowWithKey(key.toStringFormat(true));
              Row r = dciter.getCurrentRow();
            
              Var = (BigDecimal)r.getAttribute("MGIT_CODE");
              String authQuery="BEGIN LMS_SETUPS_PKG.deleteMedTestGrpitem(?);END;";
              conn=new DBConnector().getDatabaseConn();
              
              CallableStatement cstmt=conn.prepareCall(authQuery);    
              cstmt.setBigDecimal(1, Var);
           
              cstmt.execute();
              conn.close();

          }

            ADFUtils.findIterator("findMedTestGroupTestsIterator").executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(medGrpItemsLOV);
            GlobalCC.INFORMATIONREPORTING("Record Successfully Deleted.");
        Result = "S";
        
      }
      catch(Exception ex)
      {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
      }
      return Result;
    }
    
    public String AddTreatyGroup(){
        try{
          if(session.getAttribute("trtCode")==null){
                GlobalCC.INFORMATIONREPORTING("Select A Treaty Type.");
            return null;  
          }
           shortDesc.setValue(null);
           desc.setValue(null);
           session.setAttribute("trtgCode", null);

            GlobalCC.showPopup("lmsgroup:treatyGrp");

        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }
    
    public String EditTreatyGroup(){  
        try{
            if(session.getAttribute("trtgCode")==null){
                GlobalCC.INFORMATIONREPORTING("Select A Treaty Group.");
              return null;
            }
            GlobalCC.showPopup("lmsgroup:treatyGrp");
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }   
      return null;
    }
    
    public String SaveTreatyGroup() {
        Connection conn=null;
        try 
        {
            
            if(shortDesc.getValue()==null){
                GlobalCC.INFORMATIONREPORTING("Enter a Short Description");
              return null;
            }
            
            if(desc.getValue()==null){
                GlobalCC.INFORMATIONREPORTING("Enter A Description");
              return null;
            }
 
            String authQuery="BEGIN LMS_SETUPS_PKG.updateTreatyTypeGrps(?,?,?,?);END;";
            conn=new DBConnector().getDatabaseConn();
            
            CallableStatement cstmt=conn.prepareCall(authQuery);    
            cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("trtgCode"));
            if(shortDesc.getValue()==null){
                cstmt.setString(2, null);
            }else{
                cstmt.setString(2, shortDesc.getValue().toString());  
            }
            if(desc.getValue()==null){
                cstmt.setString(3, null);
            }else{
                cstmt.setString(3, desc.getValue().toString());  
            }
            cstmt.setBigDecimal(4, (BigDecimal)session.getAttribute("trtCode"));
            cstmt.execute();
            cstmt.close();
            conn.close();


            GlobalCC.INFORMATIONREPORTING("Treaty Group Saved succesfully.");

            session.setAttribute("trtgCode", null);
            ADFUtils.findIterator("findTreatyTypesAndGroupsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(trtGrpsLOV);    
          
        }
        catch(Exception ex)
        {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
        }
      return null;
    }
    
    public String DeleteTreatyGroup() {
        Connection conn=null;
      try 
      {
        if(session.getAttribute("trtgCode")==null){
                GlobalCC.INFORMATIONREPORTING("Select A Treaty Group.");
          return null;
        }
          
        String authQuery="BEGIN LMS_SETUPS_PKG.deleteTreatyTypeGrps(?);END;";
        conn=new DBConnector().getDatabaseConn();
        
        CallableStatement cstmt=conn.prepareCall(authQuery);    
        cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("trtgCode"));
        
        cstmt.execute();
        cstmt.close();
        conn.close();
        
        session.setAttribute("trtgCode", null);
            ADFUtils.findIterator("findTreatyTypeGroupsIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(trtGrpsLOV);  
      }
      catch(Exception ex)
      {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
      }
      return null;
    }
    
    public void TreatyGroupsListener(SelectionEvent selectionEvent) {
        Connection conn=null;
        // Add event code here...
        try{
            DCIteratorBinding dciter = ADFUtils.findIterator("findTreatyTypesIterator");
            RowKeySet set = selectionEvent.getAddedSet();
            Iterator rowKeySetIter = set.iterator();
            
            //System.out.println(1);
            while (rowKeySetIter.hasNext()) 
            {
                List l = (List) rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                
                session.setAttribute("trtCode", r.getAttribute("TRT_CODE"));
             session.setAttribute("trtshtDesc", r.getAttribute("TRT_SHT_DESC"));
             session.setAttribute("trtgCode", null);
             session.setAttribute("trtgshtDesc", null);

                ADFUtils.findIterator("findTreatyTypeGroupsIterator").executeQuery();
             AdfFacesContext.getCurrentInstance().addPartialTarget(trtGrpsLOV);
             

         }     
            
            
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(conn,e);
        }
    }
    
    public void TreatiesListener(SelectionEvent selectionEvent) {
        // Add event code here...
        try{
            DCIteratorBinding dciter = ADFUtils.findIterator("findTreatyTypeGroupsIterator");
            RowKeySet set = selectionEvent.getAddedSet();
            Iterator rowKeySetIter = set.iterator();
            
            //System.out.println(1);
            while (rowKeySetIter.hasNext()) 
            {
                List l = (List) rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                
                session.setAttribute("trtgCode", r.getAttribute("TRTG_CODE"));
                session.setAttribute("trtgshtDesc", r.getAttribute("TRTG_SHT_DESC"));
                session.setAttribute("trsCode", null);

                ADFUtils.findIterator("findTreatiesIterator").executeQuery();
             AdfFacesContext.getCurrentInstance().addPartialTarget(treatiesLOV);
             

         }     
            
            
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
    }
    
  public void TreatiesListenerTree(SelectionEvent selectionEvent) {
      // Add event code here...
      if (selectionEvent.getAddedSet() != selectionEvent.getRemovedSet()) {
          RowKeySet keys = selectionEvent.getAddedSet(); 
          if (keys != null && keys.getSize() > 0) {
              for (Object treeRowKey : keys) {
                  trtGrpsLOV.setRowKey(treeRowKey);
                  JUCtrlHierNodeBinding nd =
                      (JUCtrlHierNodeBinding)trtGrpsLOV.getRowData();

                  if (nd.getRow().getAttribute("type").equals("P")) {
                    session.setAttribute("trtCode", nd.getRow().getAttribute("TRT_CODE"));
                    session.setAttribute("trtshtDesc", nd.getRow().getAttribute("TRT_SHT_DESC"));
                    session.setAttribute("trtgCode", null);
                    session.setAttribute("trtgshtDesc", null);
                    session.setAttribute("trsCode", null);
                    shortDesc.setValue(null);
                    desc.setValue(null);

                        ADFUtils.findIterator("findTreatiesIterator").executeQuery();
                    AdfFacesContext.getCurrentInstance().addPartialTarget(treatiesLOV);
                    
                  } else if (nd.getRow().getAttribute("type").equals("S")) {

                     session.setAttribute("trtCode", nd.getParent().getRow().getAttribute("TRT_CODE"));
                     session.setAttribute("trtshtDesc", nd.getParent().getRow().getAttribute("TRT_SHT_DESC"));
                     session.setAttribute("trtgCode", nd.getRow().getAttribute("TRTG_CODE"));
                     session.setAttribute("trtgshtDesc", nd.getRow().getAttribute("TRTG_SHT_DESC"));
                     session.setAttribute("trsCode", null);
                     shortDesc.setValue(nd.getRow().getAttribute("TRTG_SHT_DESC"));
                     desc.setValue(nd.getRow().getAttribute("TRTG_DESC"));

                        ADFUtils.findIterator("findTreatiesIterator").executeQuery();
                    AdfFacesContext.getCurrentInstance().addPartialTarget(treatiesLOV);

                  }   
            }
          }
      }
      
  }
    
    public String AddTreaty(){
        try{
            
            trtShortDesc.setValue(null);
            trtDesc.setValue(null);
            session.setAttribute("trsCode", null);
           
            
            // Render Popup
            ExtendedRenderKitService erkService =
            Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
            ExtendedRenderKitService.class);
            erkService.addScript(FacesContext.getCurrentInstance(),
            "var hints = {autodismissNever:false}; " +
            "AdfPage.PAGE.findComponent('" + "lmsgroup:treaty" +
            "').show(hints);");
            
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }
    
    public String EditTreaty(){
      
      DCIteratorBinding dciter = ADFUtils.findIterator("findTreatiesIterator");
      RowKeySet set =treatiesLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      
      //System.out.println(1);
      while (rowKeySetIter.hasNext()) 
      {
          List l = (List) rowKeySetIter.next();
          Key key = (Key)l.get(0);
          dciter.setCurrentRowWithKey(key.toStringFormat(true));
          Row r = dciter.getCurrentRow();
        
          session.setAttribute("trsCode", r.getAttribute("TRS_CODE"));
          
          trtShortDesc.setValue(r.getAttribute("TRS_SHT_DESC"));
          trtDesc.setValue(r.getAttribute("TRS_NAME"));

          // Render Popup
          ExtendedRenderKitService erkService =
          Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
          ExtendedRenderKitService.class);
          erkService.addScript(FacesContext.getCurrentInstance(),
          "var hints = {autodismissNever:false}; " +
          "AdfPage.PAGE.findComponent('" + "lmsgroup:treaty" +
          "').show(hints);");

      }
        
         
      return null;
    }
    
    public String SaveTreaty() {
        Connection conn=null;
        try 
        {
            
            if(trtShortDesc.getValue()==null){
                String Message = "Enter a Short Description";
                FacesContext.getCurrentInstance().addMessage(null, 
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                              Message, 
                                                                              Message));
                return null;
            }
            
            if(trtDesc.getValue()==null){
                String Message = "Enter A Description";
                FacesContext.getCurrentInstance().addMessage(null, 
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                              Message, 
                                                                              Message));
                return null;
            }
    
            String authQuery="BEGIN LMS_SETUPS_PKG.updateTreaties(?,?,?,?,?,?,?);END;";
             conn=new DBConnector().getDatabaseConn();
            
            CallableStatement cstmt=conn.prepareCall(authQuery);    
            cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("trsCode"));
            if(trtShortDesc.getValue()==null){
                cstmt.setString(2, null);
            }else{
                cstmt.setString(2, trtShortDesc.getValue().toString());  
            }
            if(trtDesc.getValue()==null){
                cstmt.setString(3, null);
            }else{
                cstmt.setString(3, trtDesc.getValue().toString());  
            }
            cstmt.setBigDecimal(4, (BigDecimal)session.getAttribute("trtCode"));
            cstmt.setString(5, (String)session.getAttribute("trtshtDesc"));
            cstmt.setBigDecimal(6, (BigDecimal)session.getAttribute("trtgCode"));
            cstmt.setString(7, (String)session.getAttribute("trtgshtDesc"));
            cstmt.execute();
            conn.close();
            
            String Message = "Treaty Saved succesfully.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            
            session.setAttribute("trsCode", null);
            ADFUtils.findIterator("findTreatiesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(treatiesLOV);    
          
        }
        catch(Exception ex)
        {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
        }
      return null;
    }
    
    public String DeleteTreaty() {
        Connection conn=null;
      try 
      {
          DCIteratorBinding dciter = ADFUtils.findIterator("findTreatiesIterator");
          RowKeySet set =treatiesLOV.getSelectedRowKeys();
          Iterator rowKeySetIter = set.iterator();
          
          //System.out.println(1);
          while (rowKeySetIter.hasNext()) 
          {
              List l = (List) rowKeySetIter.next();
              Key key = (Key)l.get(0);
              dciter.setCurrentRowWithKey(key.toStringFormat(true));
              Row r = dciter.getCurrentRow();
            
              session.setAttribute("trsCode", r.getAttribute("TRS_CODE"));
              
              String authQuery="BEGIN LMS_SETUPS_PKG.deleteTreaties(?);END;";
              conn=new DBConnector().getDatabaseConn();
              
              CallableStatement cstmt=conn.prepareCall(authQuery);    
              cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("trsCode"));
           
              cstmt.execute();
              conn.close();

          }
          session.setAttribute("trsCode", null);
            ADFUtils.findIterator("findTreatiesIterator").executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(treatiesLOV);      
        
      }
      catch(Exception ex)
      {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
      }
      return null;
    }

    public void ANBListener(SelectionEvent selectionEvent) {
        // Add event code here...
        try{
            DCIteratorBinding dciter = ADFUtils.findIterator("findMedicalANBIterator");
            RowKeySet set = selectionEvent.getAddedSet();
            Iterator rowKeySetIter = set.iterator();
            
            //System.out.println(1);
            while (rowKeySetIter.hasNext()) 
            {
                List l = (List) rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                
                session.setAttribute("manbCode", r.getAttribute("MANB_CODE"));
                session.setAttribute("mreqCode", null);

                ADFUtils.findIterator("findMedRequirementsIterator").executeQuery();
             AdfFacesContext.getCurrentInstance().addPartialTarget(requirementLOV);
             

         }     
            
            
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
    }
    
    public String AddANB(){
        try{
            
            anbFrom.setValue(null);
            anbTo.setValue(null);
            wet.setValue(null);
            session.setAttribute("manbCode", null);
           
            
            // Render Popup
            ExtendedRenderKitService erkService =
            Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
            ExtendedRenderKitService.class);
            erkService.addScript(FacesContext.getCurrentInstance(),
            "var hints = {autodismissNever:false}; " +
            "AdfPage.PAGE.findComponent('" + "lmsgroup:anbpopup" +
            "').show(hints);");
            
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }
    
    public String EditANB(){
      
      DCIteratorBinding dciter = ADFUtils.findIterator("findMedicalANBIterator");
      RowKeySet set =anbLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      
      //System.out.println(1);
      while (rowKeySetIter.hasNext()) 
      {
          List l = (List) rowKeySetIter.next();
          Key key = (Key)l.get(0);
          dciter.setCurrentRowWithKey(key.toStringFormat(true));
          Row r = dciter.getCurrentRow();
        
          session.setAttribute("manbCode", r.getAttribute("MANB_CODE"));
          
          anbFrom.setValue(r.getAttribute("MANB_ANB_FROM"));
          anbTo.setValue(r.getAttribute("MANB_ANB_TO"));
          wef.setValue(r.getAttribute("MANB_WEF"));
          wet.setValue(r.getAttribute("MANB_WET"));

          // Render Popup
          ExtendedRenderKitService erkService =
          Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
          ExtendedRenderKitService.class);
          erkService.addScript(FacesContext.getCurrentInstance(),
          "var hints = {autodismissNever:false}; " +
          "AdfPage.PAGE.findComponent('" + "lmsgroup:anbpopup" +
          "').show(hints);");

      }
        
         
      return null;
    }
    
    public String SaveANB() {
        Connection conn=null;
        try 
        {
            
            if(anbFrom.getValue()==null){
                String Message = "Enter a ANB From";
                FacesContext.getCurrentInstance().addMessage(null, 
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                              Message, 
                                                                              Message));
                return null;
            }
            
            if(anbTo.getValue()==null){
                String Message = "Enter A ANB To";
                FacesContext.getCurrentInstance().addMessage(null, 
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                              Message, 
                                                                              Message));
                return null;
            }
            Boolean WEFDateChanged = false;
            Boolean WETDateChanged = false;
            
            if(wef.getValue()==null){
            }else{
                WEFDateChanged = wef.getValue().toString().contains(":");
            }
            
            if(wet.getValue()==null){
            }else{
                WETDateChanged = wet.getValue().toString().contains(":");
            }
    
            String authQuery="BEGIN LMS_SETUPS_PKG.updateMedicalANB(?,?,?,?,?,?,?);END;";
            conn=new DBConnector().getDatabaseConn();
            
            CallableStatement cstmt=conn.prepareCall(authQuery);    
            cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("manbCode"));
            if(anbFrom.getValue()==null){
                cstmt.setString(2, null);
            }else{
                cstmt.setString(2, anbFrom.getValue().toString());  
            }
            if(anbTo.getValue()==null){
                cstmt.setString(3, null);
            }else{
                cstmt.setString(3, anbTo.getValue().toString());  
            }
          if(wef.getValue()==null) {
              cstmt.setString(4,null);
          }
          else {
              String WET = null;
              if(wef.getValue().toString().contains(":")){
                  WET = GlobalCC.parseDate(wef.getValue().toString());
              }else{
                  WET = GlobalCC.upDateParseDate(wef.getValue().toString());
              }
              cstmt.setString(4,WET);
          }
          if(wet.getValue()==null) {
              cstmt.setString(5,null);
          }
          else {
              String WET = null;
              if(wet.getValue().toString().contains(":")){
                  WET = GlobalCC.parseDate(wet.getValue().toString());
              }else{
                  WET = GlobalCC.upDateParseDate(wet.getValue().toString());
              }
              cstmt.setString(5,WET);
          }
            cstmt.setBigDecimal(6,(BigDecimal)session.getAttribute("ProductCode"));
            cstmt.setBigDecimal(7, (BigDecimal)session.getAttribute("currCode"));
            
            cstmt.execute();
            conn.close();
            
            String Message = "ANB Saved succesfully.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            
            session.setAttribute("manbCode", null);
            ADFUtils.findIterator("findMedicalANBIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(anbLOV);    
          
        }
        catch(Exception ex)
        {
            GlobalCC.EXCEPTIONREPORTING(null,ex);
        }
      return null;
    }
    
    public String DeleteANB() {
        Connection conn=null;
        String Result = "F";
      try 
      {
          DCIteratorBinding dciter = ADFUtils.findIterator("findMedicalANBIterator");
          RowKeySet set =anbLOV.getSelectedRowKeys();
          Iterator rowKeySetIter = set.iterator();
          
          //System.out.println(1);
          while (rowKeySetIter.hasNext()) 
          {
              List l = (List) rowKeySetIter.next();
              Key key = (Key)l.get(0);
              dciter.setCurrentRowWithKey(key.toStringFormat(true));
              Row r = dciter.getCurrentRow();
            
              session.setAttribute("manbCode", r.getAttribute("MANB_CODE"));
              
              String authQuery="BEGIN LMS_SETUPS_PKG.deleteMedicalANB(?);END;";
              conn=new DBConnector().getDatabaseConn();
              
              CallableStatement cstmt=conn.prepareCall(authQuery);    
              cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("manbCode"));
           
              cstmt.execute();
              conn.close();

          }
          session.setAttribute("manbCode", null);
            ADFUtils.findIterator("findMedicalANBIterator").executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(anbLOV);
            GlobalCC.INFORMATIONREPORTING("Record Successfully Deleted");
          Result = "S";
        
      }
      catch(Exception ex)
      {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
      }
      return Result;
    }
    
    public String AddMedRequirements(){
        try{
            
            rangeFrom.setValue(null);
            rangeTo.setValue(null);
            groupDesc.setValue(null);
            facWEF.setValue(null);
            facWET.setValue(null);
            session.setAttribute("mreqCode", null);
           
            
            // Render Popup
            ExtendedRenderKitService erkService =
            Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
            ExtendedRenderKitService.class);
            erkService.addScript(FacesContext.getCurrentInstance(),
            "var hints = {autodismissNever:false}; " +
            "AdfPage.PAGE.findComponent('" + "lmsgroup:reqpopup" +
            "').show(hints);");
            
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }
    
    public String EditMedRequirements(){
      
      DCIteratorBinding dciter = ADFUtils.findIterator("findMedRequirementsIterator");
      RowKeySet set =requirementLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      
      //System.out.println(1);
      while (rowKeySetIter.hasNext()) 
      {
          List l = (List) rowKeySetIter.next();
          Key key = (Key)l.get(0);
          dciter.setCurrentRowWithKey(key.toStringFormat(true));
          Row r = dciter.getCurrentRow();
        
          session.setAttribute("mreqCode", r.getAttribute("MREQ_CODE"));
          
          rangeFrom.setValue(r.getAttribute("MREQ_RANGE_FROM"));
          rangeTo.setValue(r.getAttribute("MREQ_RANGE_TO"));
          groupDesc.setValue(r.getAttribute("MREQ_MTG_DESC"));
          facWEF.setValue(r.getAttribute("MREQ_WEF"));
          facWET.setValue(r.getAttribute("MREQ_WET"));
          

          // Render Popup
          ExtendedRenderKitService erkService =
          Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
          ExtendedRenderKitService.class);
          erkService.addScript(FacesContext.getCurrentInstance(),
          "var hints = {autodismissNever:false}; " +
          "AdfPage.PAGE.findComponent('" + "lmsgroup:reqpopup" +
          "').show(hints);");

      }
        
         
      return null;
    }
    
    public String SaveMedRequirements() {
        Connection conn=null;
        try 
        {
            
            if(rangeFrom.getValue()==null){
                String Message = "Enter a Range From";
                FacesContext.getCurrentInstance().addMessage(null, 
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                              Message, 
                                                                              Message));
                return null;
            }
            
            if(rangeTo.getValue()==null){
                String Message = "Enter A Range To";
                FacesContext.getCurrentInstance().addMessage(null, 
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                              Message, 
                                                                              Message));
                return null;
            }
            Boolean WEFDateChanged = false;
            Boolean WETDateChanged = false;
            
            if(facWEF.getValue()==null){
            }else{
                WEFDateChanged = facWEF.getValue().toString().contains(":");
            }
            
            if(facWET.getValue()==null){
            }else{
                WETDateChanged = facWET.getValue().toString().contains(":");
            }
    
            String authQuery="BEGIN LMS_SETUPS_PKG.updateMedicalRequirements(?,?,?,?,?,?,?);END;";
            conn=new DBConnector().getDatabaseConn();
            
            CallableStatement cstmt=conn.prepareCall(authQuery);    
            cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("mreqCode"));
            if(rangeFrom.getValue()==null){
                cstmt.setString(2, null);
            }else{
                cstmt.setString(2, rangeFrom.getValue().toString());  
            }
            if(rangeTo.getValue()==null){
                cstmt.setString(3, null);
            }else{
                cstmt.setString(3, rangeTo.getValue().toString());  
            }
            if(facWEF.getValue()==null){
                    cstmt.setString(4, null);
            }else{
                    if(WEFDateChanged==false){
                        cstmt.setString(4, null); 
                }else{
                        cstmt.setString(4, LOVCC.parseDate(facWEF.getValue().toString()));   
                    }
            }
            if(facWET.getValue()==null){
                    cstmt.setString(5, null);
            }else{
                    if(WETDateChanged==false){
                        cstmt.setString(5, null); 
                    }else{
                        cstmt.setString(5, LOVCC.parseDate(facWET.getValue().toString()));   
                }
            }
            cstmt.setBigDecimal(6, (BigDecimal)session.getAttribute("mtgCode"));
            cstmt.setBigDecimal(7, (BigDecimal)session.getAttribute("manbCode"));
            cstmt.execute();
            conn.close();
            
            String Message = "Medical Requirement Saved succesfully.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            
            session.setAttribute("mreqCode", null);
            ADFUtils.findIterator("findMedRequirementsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(requirementLOV);    
          
        }
        catch(Exception ex)
        {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
        }
      return null;
    }
    
    public String DeleteMedRequirements() {
        Connection conn=null;
        String Result = "F";
      try 
      {
          DCIteratorBinding dciter = ADFUtils.findIterator("findMedRequirementsIterator");
          RowKeySet set =requirementLOV.getSelectedRowKeys();
          Iterator rowKeySetIter = set.iterator();
          
          //System.out.println(1);
          while (rowKeySetIter.hasNext()) 
          {
              List l = (List) rowKeySetIter.next();
              Key key = (Key)l.get(0);
              dciter.setCurrentRowWithKey(key.toStringFormat(true));
              Row r = dciter.getCurrentRow();
            
              session.setAttribute("mreqCode", r.getAttribute("MREQ_CODE"));
              
              String authQuery="BEGIN LMS_SETUPS_PKG.deleteMedicalRequirements(?);END;";
              conn=new DBConnector().getDatabaseConn();
              
              CallableStatement cstmt=conn.prepareCall(authQuery);    
              cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("mreqCode"));
           
              cstmt.execute();
              conn.close();

          }
          session.setAttribute("mreqCode", null);
            ADFUtils.findIterator("findMedRequirementsIterator").executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(requirementLOV);
            GlobalCC.INFORMATIONREPORTING("Record Successfully Deleted");
          Result = "S";
        
      }
      catch(Exception ex)
      {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
      }
      return Result;
    }
    
    public String MedGroupSel(){
        try{
            DCIteratorBinding dciter = ADFUtils.findIterator("findMedTestGroupsIterator");
            RowKeySet set =medTestsLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();
            
            //System.out.println(1);
            while (rowKeySetIter.hasNext()) 
            {
                List l = (List) rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();
              
                session.setAttribute("mtgCode", r.getAttribute("MTG_CODE"));
                groupDesc.setValue(r.getAttribute("MTG_DESC"));
                
            }
  
            
            // Render Popup
            ExtendedRenderKitService erkService =
            Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
            ExtendedRenderKitService.class);
            erkService.addScript(FacesContext.getCurrentInstance(),
            "var hints = {autodismissNever:false}; " +
            "AdfPage.PAGE.findComponent('" + "lmsgroup:reqpopup" +
            "').show(hints);");
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }
         
         public String RenderPopup(){
             try{
                 // Render Popup
                 ExtendedRenderKitService erkService =
                 Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                 ExtendedRenderKitService.class);
                 erkService.addScript(FacesContext.getCurrentInstance(),
                 "var hints = {autodismissNever:false}; " +
                 "AdfPage.PAGE.findComponent('" + "lmsgroup:p3" +
                 "').show(hints);");
             }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
             }
             return null;
         }
         
    public String AddMedicalRating(){
        try{
            
            anbFrom.setValue(null);
            anbTo.setValue(null);
            duration.setValue(null);
            increase.setValue(null);
            rateType.setValue(null);
            multiDivFac.setValue(null);
            session.setAttribute("gfmCode", null);
           
            
            // Render Popup
            ExtendedRenderKitService erkService =
            Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
            ExtendedRenderKitService.class);
            erkService.addScript(FacesContext.getCurrentInstance(),
            "var hints = {autodismissNever:false}; " +
            "AdfPage.PAGE.findComponent('" + "lmsgroup:renMedical" +
            "').show(hints);");
            
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }
    
    public String EditMedicalRating(){
      
      DCIteratorBinding dciter = ADFUtils.findIterator("findRenMedicalRatingsIterator");
      RowKeySet set =ratingsLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      
      //System.out.println(1);
      while (rowKeySetIter.hasNext()) 
      {
          List l = (List) rowKeySetIter.next();
          Key key = (Key)l.get(0);
          dciter.setCurrentRowWithKey(key.toStringFormat(true));
          Row r = dciter.getCurrentRow();
        
          session.setAttribute("gfmCode", r.getAttribute("GFM_CODE"));
          
          anbFrom.setValue(r.getAttribute("GFM_ANB_FROM"));
          anbTo.setValue(r.getAttribute("GFM_ANB_TO"));
          duration.setValue(r.getAttribute("GFM_LAST_MEDICAL_DURATION"));
          increase.setValue(r.getAttribute("GMF_INCREASE_SA_LAST_MED_PERC"));
          rateType.setValue(r.getAttribute("GFM_INCREASE_TYPE"));
          multiDivFac.setValue(r.getAttribute("GFM_INCREASE_MULT_DIV_FACT"));
          

          // Render Popup
          ExtendedRenderKitService erkService =
          Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
          ExtendedRenderKitService.class);
          erkService.addScript(FacesContext.getCurrentInstance(),
          "var hints = {autodismissNever:false}; " +
          "AdfPage.PAGE.findComponent('" + "lmsgroup:renMedical" +
          "').show(hints);");

      }
        
         
      return null;
    }
    
    public String SaveMedicalRating() {
        Connection conn=null;
        try 
        {
            
            if(anbFrom.getValue()==null){
                String Message = "Enter a ANB From";
                FacesContext.getCurrentInstance().addMessage(null, 
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                              Message, 
                                                                              Message));
                return null;
            }
            
            if(anbTo.getValue()==null){
                String Message = "Enter A ANB To";
                FacesContext.getCurrentInstance().addMessage(null, 
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                              Message, 
                                                                              Message));
                return null;
            }
          
    
            String authQuery="BEGIN LMS_SETUPS_PKG.updateRenMedicalReq(?,?,?,?,?,?,?);END;";
            conn=new DBConnector().getDatabaseConn();
            
            CallableStatement cstmt=conn.prepareCall(authQuery);    
            cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("gfmCode"));
            if(anbFrom.getValue()==null){
                cstmt.setString(2, null);
            }else{
                cstmt.setString(2, anbFrom.getValue().toString());  
            }
            if(anbTo.getValue()==null){
                cstmt.setString(3, null);
            }else{
                cstmt.setString(3, anbTo.getValue().toString());  
            }
            if(duration.getValue()==null){
                cstmt.setString(4, null);
            }else{
                cstmt.setString(4, duration.getValue().toString());  
            }
            if(increase.getValue()==null){
                cstmt.setString(5, null);
            }else{
                cstmt.setString(5, increase.getValue().toString());  
            }
            if(rateType.getValue()==null){
                cstmt.setString(6, null);
            }else{
                cstmt.setString(6, rateType.getValue().toString());  
            }
            if(multiDivFac.getValue()==null){
                cstmt.setString(7, null);
            }else{
                cstmt.setString(7, multiDivFac.getValue().toString());  
            }
          
          
            cstmt.execute();
            conn.close();
            
            String Message = "Medical Rating Saved succesfully.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            
            session.setAttribute("gfmCode", null);
            ADFUtils.findIterator("findRenMedicalRatingsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(ratingsLOV);    
          
        }
        catch(Exception ex)
        {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
        }
      return null;
    }
    
    public String DeleteMedicalRating() {
        Connection conn=null;
        String Result = "F";
      try 
      {
          DCIteratorBinding dciter = ADFUtils.findIterator("findRenMedicalRatingsIterator");
          RowKeySet set =ratingsLOV.getSelectedRowKeys();
          Iterator rowKeySetIter = set.iterator();
          
          //System.out.println(1);
          while (rowKeySetIter.hasNext()) 
          {
              List l = (List) rowKeySetIter.next();
              Key key = (Key)l.get(0);
              dciter.setCurrentRowWithKey(key.toStringFormat(true));
              Row r = dciter.getCurrentRow();
            
              session.setAttribute("gfmCode", r.getAttribute("GFM_CODE"));
              
              String authQuery="BEGIN LMS_SETUPS_PKG.deleteRenMedicalReq(?);END;";
              conn=new DBConnector().getDatabaseConn();
              
              CallableStatement cstmt=conn.prepareCall(authQuery);    
              cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("gfmCode"));
           
              cstmt.execute();
              conn.close();

          }
          session.setAttribute("gfmCode", null);
            ADFUtils.findIterator("findRenMedicalRatingsIterator").executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(ratingsLOV);
            GlobalCC.INFORMATIONREPORTING("Record Successfully Deleted");
          Result = "S";
        
      }
      catch(Exception ex)
      {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
      }
      return Result;
    }

    public void setSeqTempLOV(RichTable seqTempLOV) {
        this.seqTempLOV = seqTempLOV;
    }

    public RichTable getSeqTempLOV() {
        return seqTempLOV;
    }

    public void setProdSeqLOV(RichTable prodSeqLOV) {
        this.prodSeqLOV = prodSeqLOV;
    }

    public RichTable getProdSeqLOV() {
        return prodSeqLOV;
    }

    public void setShortDesc(RichInputText shortDesc) {
        this.shortDesc = shortDesc;
    }

    public RichInputText getShortDesc() {
        return shortDesc;
    }

    public void setDesc(RichInputText desc) {
        this.desc = desc;
    }

    public RichInputText getDesc() {
        return desc;
    }

    public void setSeqType(RichSelectOneChoice seqType) {
        this.seqType = seqType;
    }

    public RichSelectOneChoice getSeqType() {
        return seqType;
    }

    public void setLengthSeqNo(RichInputText lengthSeqNo) {
        this.lengthSeqNo = lengthSeqNo;
    }

    public RichInputText getLengthSeqNo() {
        return lengthSeqNo;
    }

    public void setSeparator(RichInputText separator) {
        this.separator = separator;
    }

    public RichInputText getSeparator() {
        return separator;
    }

    public void setWef(RichInputDate wef) {
        this.wef = wef;
    }

    public RichInputDate getWef() {
        return wef;
    }

    public void setWet(RichInputDate wet) {
        this.wet = wet;
    }

    public RichInputDate getWet() {
        return wet;
    }

    public void setOrder(RichInputText order) {
        this.order = order;
    }

    public RichInputText getOrder() {
        return order;
    }

    public void setNumComponent(RichInputText numComponent) {
        this.numComponent = numComponent;
    }

    public RichInputText getNumComponent() {
        return numComponent;
    }

    public void setProductsLOV(RichTable productsLOV) {
        this.productsLOV = productsLOV;
    }

    public RichTable getProductsLOV() {
        return productsLOV;
    }

    public void setAgentsLOV(RichTable agentsLOV) {
        this.agentsLOV = agentsLOV;
    }

    public RichTable getAgentsLOV() {
        return agentsLOV;
    }

    public void setAgentIDesc(RichInputText agentIDesc) {
        this.agentIDesc = agentIDesc;
    }

    public RichInputText getAgentIDesc() {
        return agentIDesc;
    }

    public void setAgentTypeDesc(RichInputText agentTypeDesc) {
        this.agentTypeDesc = agentTypeDesc;
    }

    public RichInputText getAgentTypeDesc() {
        return agentTypeDesc;
    }

    public void setRatesLOV(RichTable ratesLOV) {
        this.ratesLOV = ratesLOV;
    }

    public RichTable getRatesLOV() {
        return ratesLOV;
    }

    public void setRangeFrom(RichInputText rangeFrom) {
        this.rangeFrom = rangeFrom;
    }

    public RichInputText getRangeFrom() {
        return rangeFrom;
    }

    public void setRangeTo(RichInputText rangeTo) {
        this.rangeTo = rangeTo;
    }

    public RichInputText getRangeTo() {
        return rangeTo;
    }

    public void setRate(RichInputText rate) {
        this.rate = rate;
    }

    public RichInputText getRate() {
        return rate;
    }

    public void setRateDesc(RichSelectOneChoice rateDesc) {
        this.rateDesc = rateDesc;
    }

    public RichSelectOneChoice getRateDesc() {
        return rateDesc;
    }

    public void setDivFactor(RichInputText divFactor) {
        this.divFactor = divFactor;
    }

    public RichInputText getDivFactor() {
        return divFactor;
    }

    public void setPayFreq(RichSelectOneChoice payFreq) {
        this.payFreq = payFreq;
    }

    public RichSelectOneChoice getPayFreq() {
        return payFreq;
    }

    public void setRateType(RichSelectOneChoice rateType) {
        this.rateType = rateType;
    }

    public RichSelectOneChoice getRateType() {
        return rateType;
    }

    public void setYearFrom(RichInputText yearFrom) {
        this.yearFrom = yearFrom;
    }

    public RichInputText getYearFrom() {
        return yearFrom;
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

    public void setMaturityAge(RichInputText maturityAge) {
        this.maturityAge = maturityAge;
    }

    public RichInputText getMaturityAge() {
        return maturityAge;
    }

    public void setAnnualRate(RichInputText annualRate) {
        this.annualRate = annualRate;
    }

    public RichInputText getAnnualRate() {
        return annualRate;
    }

    public void setAnnualBal(RichInputText annualBal) {
        this.annualBal = annualBal;
    }

    public RichInputText getAnnualBal() {
        return annualBal;
    }

    public void setDuration(RichInputText duration) {
        this.duration = duration;
    }

    public RichInputText getDuration() {
        return duration;
    }

    public void setBalPymntMnth(RichInputText balPymntMnth) {
        this.balPymntMnth = balPymntMnth;
    }

    public RichInputText getBalPymntMnth() {
        return balPymntMnth;
    }

    public void setAnnWEF(RichInputDate annWEF) {
        this.annWEF = annWEF;
    }

    public RichInputDate getAnnWEF() {
        return annWEF;
    }

    public void setAnnWET(RichInputDate annWET) {
        this.annWET = annWET;
    }

    public RichInputDate getAnnWET() {
        return annWET;
    }

    public void setCbMnthFrom(RichInputText cbMnthFrom) {
        this.cbMnthFrom = cbMnthFrom;
    }

    public RichInputText getCbMnthFrom() {
        return cbMnthFrom;
    }

    public void setCbMnthTo(RichInputText cbMnthTo) {
        this.cbMnthTo = cbMnthTo;
    }

    public RichInputText getCbMnthTo() {
        return cbMnthTo;
    }

    public void setCbRate(RichInputText cbRate) {
        this.cbRate = cbRate;
    }

    public RichInputText getCbRate() {
        return cbRate;
    }

    public void setCbRateType(RichSelectOneChoice cbRateType) {
        this.cbRateType = cbRateType;
    }

    public RichSelectOneChoice getCbRateType() {
        return cbRateType;
    }

    public void setCbDivFac(RichInputText cbDivFac) {
        this.cbDivFac = cbDivFac;
    }

    public RichInputText getCbDivFac() {
        return cbDivFac;
    }

    public void setCbWEF(RichInputDate cbWEF) {
        this.cbWEF = cbWEF;
    }

    public RichInputDate getCbWEF() {
        return cbWEF;
    }

    public void setCbWET(RichInputDate cbWET) {
        this.cbWET = cbWET;
    }

    public RichInputDate getCbWET() {
        return cbWET;
    }

    public void setIntPayElement(RichSelectOneChoice intPayElement) {
        this.intPayElement = intPayElement;
    }

    public RichSelectOneChoice getIntPayElement() {
        return intPayElement;
    }

    public void setIntCreditVal(RichInputText intCreditVal) {
        this.intCreditVal = intCreditVal;
    }

    public RichInputText getIntCreditVal() {
        return intCreditVal;
    }

    public void setIntDebitVal(RichInputText intDebitVal) {
        this.intDebitVal = intDebitVal;
    }

    public RichInputText getIntDebitVal() {
        return intDebitVal;
    }

    public void setIntWEF(RichInputDate intWEF) {
        this.intWEF = intWEF;
    }

    public RichInputDate getIntWEF() {
        return intWEF;
    }

    public void setIntWET(RichInputDate intWET) {
        this.intWET = intWET;
    }

    public RichInputDate getIntWET() {
        return intWET;
    }

    public void setIntRate(RichInputText intRate) {
        this.intRate = intRate;
    }

    public RichInputText getIntRate() {
        return intRate;
    }

    public void setIntDivFac(RichInputText intDivFac) {
        this.intDivFac = intDivFac;
    }

    public RichInputText getIntDivFac() {
        return intDivFac;
    }

    public void setPremiumMasksLOV(RichTable premiumMasksLOV) {
        this.premiumMasksLOV = premiumMasksLOV;
    }

    public RichTable getPremiumMasksLOV() {
        return premiumMasksLOV;
    }

    public void setPmID(RichInputText pmID) {
        this.pmID = pmID;
    }

    public RichInputText getPmID() {
        return pmID;
    }

    public void setPmDesc(RichInputText pmDesc) {
        this.pmDesc = pmDesc;
    }

    public RichInputText getPmDesc() {
        return pmDesc;
    }

    public void setPmDefault(RichSelectOneChoice pmDefault) {
        this.pmDefault = pmDefault;
    }

    public RichSelectOneChoice getPmDefault() {
        return pmDefault;
    }

    public void setPmComments(RichInputText pmComments) {
        this.pmComments = pmComments;
    }

    public RichInputText getPmComments() {
        return pmComments;
    }

    public void setParameterLOV(RichTable parameterLOV) {
        this.parameterLOV = parameterLOV;
    }

    public RichTable getParameterLOV() {
        return parameterLOV;
    }

    public void setParamVal(RichInputText paramVal) {
        this.paramVal = paramVal;
    }

    public RichInputText getParamVal() {
        return paramVal;
    }

    public void setParamDesc(RichInputText paramDesc) {
        this.paramDesc = paramDesc;
    }

    public RichInputText getParamDesc() {
        return paramDesc;
    }

    public void setFCLLOV(RichTable FCLLOV) {
        this.FCLLOV = FCLLOV;
    }

    public RichTable getFCLLOV() {
        return FCLLOV;
    }

    public void setFcLivesFrom(RichInputText fcLivesFrom) {
        this.fcLivesFrom = fcLivesFrom;
    }

    public RichInputText getFcLivesFrom() {
        return fcLivesFrom;
    }

    public void setFcLivesTo(RichInputText fcLivesTo) {
        this.fcLivesTo = fcLivesTo;
    }

    public RichInputText getFcLivesTo() {
        return fcLivesTo;
    }

    public void setFcLFactor(RichInputText fcLFactor) {
        this.fcLFactor = fcLFactor;
    }

    public RichInputText getFcLFactor() {
        return fcLFactor;
    }

    public void setFcLimit(RichInputText fcLimit) {
        this.fcLimit = fcLimit;
    }

    public RichInputText getFcLimit() {
        return fcLimit;
    }

    public void setFcLWef(RichInputDate fcLWef) {
        this.fcLWef = fcLWef;
    }

    public RichInputDate getFcLWef() {
        return fcLWef;
    }

    public void setFcLWet(RichInputDate fcLWet) {
        this.fcLWet = fcLWet;
    }

    public RichInputDate getFcLWet() {
        return fcLWet;
    }

    public void setTtId(RichInputText ttId) {
        this.ttId = ttId;
    }

    public RichInputText getTtId() {
        return ttId;
    }

    public void setTtDesc(RichInputText ttDesc) {
        this.ttDesc = ttDesc;
    }

    public RichInputText getTtDesc() {
        return ttDesc;
    }

    public void setTtTaxType(RichSelectOneChoice ttTaxType) {
        this.ttTaxType = ttTaxType;
    }

    public RichSelectOneChoice getTtTaxType() {
        return ttTaxType;
    }

    public void setTtApplProd(RichSelectOneChoice ttApplProd) {
        this.ttApplProd = ttApplProd;
    }

    public RichSelectOneChoice getTtApplProd() {
        return ttApplProd;
    }

    public void setTtApplEndr(RichSelectOneChoice ttApplEndr) {
        this.ttApplEndr = ttApplEndr;
    }

    public RichSelectOneChoice getTtApplEndr() {
        return ttApplEndr;
    }

    public void setTtApplLevel(RichSelectOneChoice ttApplLevel) {
        this.ttApplLevel = ttApplLevel;
    }

    public RichSelectOneChoice getTtApplLevel() {
        return ttApplLevel;
    }

    public void setTtRefund(RichSelectOneChoice ttRefund) {
        this.ttRefund = ttRefund;
    }

    public RichSelectOneChoice getTtRefund() {
        return ttRefund;
    }

    public void setTaxesLOV(RichTable taxesLOV) {
        this.taxesLOV = taxesLOV;
    }

    public RichTable getTaxesLOV() {
        return taxesLOV;
    }

    public void setTxRangeFrom(RichInputText txRangeFrom) {
        this.txRangeFrom = txRangeFrom;
    }

    public RichInputText getTxRangeFrom() {
        return txRangeFrom;
    }

    public void setTxRangeTo(RichInputText txRangeTo) {
        this.txRangeTo = txRangeTo;
    }

    public RichInputText getTxRangeTo() {
        return txRangeTo;
    }

    public void setTxAgeFrm(RichInputText txAgeFrm) {
        this.txAgeFrm = txAgeFrm;
    }

    public RichInputText getTxAgeFrm() {
        return txAgeFrm;
    }

    public void setTxAgeTo(RichInputText txAgeTo) {
        this.txAgeTo = txAgeTo;
    }

    public RichInputText getTxAgeTo() {
        return txAgeTo;
    }

    public void setTxRate(RichInputText txRate) {
        this.txRate = txRate;
    }

    public RichInputText getTxRate() {
        return txRate;
    }

    public void setTxDivFac(RichInputText txDivFac) {
        this.txDivFac = txDivFac;
    }

    public RichInputText getTxDivFac() {
        return txDivFac;
    }

    public void setTxRateType(RichSelectOneChoice txRateType) {
        this.txRateType = txRateType;
    }

    public RichSelectOneChoice getTxRateType() {
        return txRateType;
    }

    public void setTxApplTo(RichSelectOneChoice txApplTo) {
        this.txApplTo = txApplTo;
    }

    public RichSelectOneChoice getTxApplTo() {
        return txApplTo;
    }

    public void setTxApplFreq(RichSelectOneChoice txApplFreq) {
        this.txApplFreq = txApplFreq;
    }

    public RichSelectOneChoice getTxApplFreq() {
        return txApplFreq;
    }

    public void setTxDuration(RichInputText txDuration) {
        this.txDuration = txDuration;
    }

    public RichInputText getTxDuration() {
        return txDuration;
    }

    public void setFee(RichInputText fee) {
        this.fee = fee;
    }

    public RichInputText getFee() {
        return fee;
    }

    public void setValidPeriod(RichInputText validPeriod) {
        this.validPeriod = validPeriod;
    }

    public RichInputText getValidPeriod() {
        return validPeriod;
    }

    public void setFacDesc(RichInputText facDesc) {
        this.facDesc = facDesc;
    }

    public RichInputText getFacDesc() {
        return facDesc;
    }

    public void setFacFee(RichInputText facFee) {
        this.facFee = facFee;
    }

    public RichInputText getFacFee() {
        return facFee;
    }

    public void setFacWEF(RichInputDate facWEF) {
        this.facWEF = facWEF;
    }

    public RichInputDate getFacWEF() {
        return facWEF;
    }

    public void setFacWET(RichInputDate facWET) {
        this.facWET = facWET;
    }

    public RichInputDate getFacWET() {
        return facWET;
    }

    public void setMedTestsLOV(RichTable medTestsLOV) {
        this.medTestsLOV = medTestsLOV;
    }

    public RichTable getMedTestsLOV() {
        return medTestsLOV;
    }

    public void setFacilitatorLOV(RichTable facilitatorLOV) {
        this.facilitatorLOV = facilitatorLOV;
    }

    public RichTable getFacilitatorLOV() {
        return facilitatorLOV;
    }

    public void setMedFacilLOV(RichTable medFacilLOV) {
        this.medFacilLOV = medFacilLOV;
    }

    public RichTable getMedFacilLOV() {
        return medFacilLOV;
    }

    public void setSprDesc(RichInputText sprDesc) {
        this.sprDesc = sprDesc;
    }

    public RichInputText getSprDesc() {
        return sprDesc;
    }

    public void setSprTown(RichInputText sprTown) {
        this.sprTown = sprTown;
    }

    public RichInputText getSprTown() {
        return sprTown;
    }

    public void setTestsLOV(RichTable testsLOV) {
        this.testsLOV = testsLOV;
    }

    public RichTable getTestsLOV() {
        return testsLOV;
    }

    public void setMasksLOV(RichTable masksLOV) {
        this.masksLOV = masksLOV;
    }

    public RichTable getMasksLOV() {
        return masksLOV;
    }

    public void setDependantsLOV(RichTable dependantsLOV) {
        this.dependantsLOV = dependantsLOV;
    }

    public RichTable getDependantsLOV() {
        return dependantsLOV;
    }

    public void setTermsLOV(RichTable termsLOV) {
        this.termsLOV = termsLOV;
    }

    public RichTable getTermsLOV() {
        return termsLOV;
    }

    public void setInterestLOV(RichTable interestLOV) {
        this.interestLOV = interestLOV;
    }

    public RichTable getInterestLOV() {
        return interestLOV;
    }

    public void setSingleRate(RichInputText singleRate) {
        this.singleRate = singleRate;
    }

    public RichInputText getSingleRate() {
        return singleRate;
    }

    public void setMultiRate(RichInputText multiRate) {
        this.multiRate = multiRate;
    }

    public RichInputText getMultiRate() {
        return multiRate;
    }

    public void setMultiDivFac(RichInputText multiDivFac) {
        this.multiDivFac = multiDivFac;
    }

    public RichInputText getMultiDivFac() {
        return multiDivFac;
    }

    public void setConstant(RichInputText constant) {
        this.constant = constant;
    }

    public RichInputText getConstant() {
        return constant;
    }

    public void setConstantDivFac(RichInputText constantDivFac) {
        this.constantDivFac = constantDivFac;
    }

    public RichInputText getConstantDivFac() {
        return constantDivFac;
    }

    public void setRefund(RichSelectOneChoice refund) {
        this.refund = refund;
    }

    public RichSelectOneChoice getRefund() {
        return refund;
    }

    public void setProrate(RichSelectOneChoice prorate) {
        this.prorate = prorate;
    }

    public RichSelectOneChoice getProrate() {
        return prorate;
    }

    public void setMedGrpsLOV(RichTable medGrpsLOV) {
        this.medGrpsLOV = medGrpsLOV;
    }

    public RichTable getMedGrpsLOV() {
        return medGrpsLOV;
    }

    public void setMedGrpItemsLOV(RichTable medGrpItemsLOV) {
        this.medGrpItemsLOV = medGrpItemsLOV;
    }

    public RichTable getMedGrpItemsLOV() {
        return medGrpItemsLOV;
    }

    public void setTrtGrpsLOV(RichTree trtGrpsLOV) {
        this.trtGrpsLOV = trtGrpsLOV;
    }

    public RichTree getTrtGrpsLOV() {
        return trtGrpsLOV;
    }

    public void setTrtShortDesc(RichInputText trtShortDesc) {
        this.trtShortDesc = trtShortDesc;
    }

    public RichInputText getTrtShortDesc() {
        return trtShortDesc;
    }

    public void setTrtDesc(RichInputText trtDesc) {
        this.trtDesc = trtDesc;
    }

    public RichInputText getTrtDesc() {
        return trtDesc;
    }

    public void setTreatiesLOV(RichTable treatiesLOV) {
        this.treatiesLOV = treatiesLOV;
    }

    public RichTable getTreatiesLOV() {
        return treatiesLOV;
    }

    public void setAnbLOV(RichTable anbLOV) {
        this.anbLOV = anbLOV;
    }

    public RichTable getAnbLOV() {
        return anbLOV;
    }

    public void setRequirementLOV(RichTable requirementLOV) {
        this.requirementLOV = requirementLOV;
    }

    public RichTable getRequirementLOV() {
        return requirementLOV;
    }

    public void setGroupDesc(RichInputText groupDesc) {
        this.groupDesc = groupDesc;
    }

    public RichInputText getGroupDesc() {
        return groupDesc;
    }

    public void setIncrease(RichInputText increase) {
        this.increase = increase;
    }

    public RichInputText getIncrease() {
        return increase;
    }

    public void setRatingsLOV(RichTable ratingsLOV) {
        this.ratingsLOV = ratingsLOV;
    }

    public RichTable getRatingsLOV() {
        return ratingsLOV;
    }

    public void setTreatyProduct(RichInputText treatyProduct) {
        this.treatyProduct = treatyProduct;
    }

    public RichInputText getTreatyProduct() {
        return treatyProduct;
    }

    public void setTreatyProductsLOV(RichTable treatyProductsLOV) {
        this.treatyProductsLOV = treatyProductsLOV;
    }

    public RichTable getTreatyProductsLOV() {
        return treatyProductsLOV;
    }

    public String GetTreatyProduct() {
        try 
        {
            DCIteratorBinding dciter = ADFUtils.findIterator("findTreatyProductsIterator");
            RowKeySet set =treatyProductsLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();
            
            //System.out.println(1);
            while (rowKeySetIter.hasNext()) 
            {
                List l = (List) rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();
              
                session.setAttribute("PROD_CODE", r.getAttribute("PROD_CODE"));
                treatyProduct.setValue(r.getAttribute("PROD_DESC"));
            

            }
          
                
          
        }
        catch(Exception ex)
        {
            GlobalCC.EXCEPTIONREPORTING(null,ex);
        }
        return null;
    }

    public String AddTreatyProduct() {
        Connection conn=null;
       String addQuery="BEGIN LMS_SETUPS_PKG.add_treaty_products(?,?,?,?,?,?,?,?);END;";
        if (treatyProductDisplay.getValue()==null)
        {
            String Message = "Select a product";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            return null; 
        }
        try
        {
            conn=new DBConnector().getDatabaseConn();
            
            CallableStatement cstmt=conn.prepareCall(addQuery); 
            cstmt.setBigDecimal(1,(BigDecimal)session.getAttribute("trpd_code"));
            cstmt.setBigDecimal(2,(BigDecimal)session.getAttribute("ta_code"));
            cstmt.setString(3,(String)session.getAttribute("ta_sht_desc"));
            cstmt.setString(4,defaultTreatyProduct.getValue().toString());
            cstmt.setString(5,(String)session.getAttribute("ta_type"));
            cstmt.setBigDecimal(6,(BigDecimal)session.getAttribute("uw_yr"));
            cstmt.setBigDecimal(7,(BigDecimal)session.getAttribute("PROD_CODE"));
            cstmt.setBigDecimal(8,(BigDecimal)session.getAttribute("as_code"));
           
            
            
            cstmt.execute();
            conn.close();
            String Message = "Treaty Product Saved succesfully.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            
            session.setAttribute("trpd_code", null);
            ADFUtils.findIterator("findArrangementSetups1Iterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(clbTreatyProducts);  
        }
        catch(Exception e)
        {
            GlobalCC.EXCEPTIONREPORTING(conn,e);
        }
        return null;
    }

    public String AssignTreatyProduct() {
        try 
        {
            DCIteratorBinding dciter = ADFUtils.findIterator("findProductsIterator");
            RowKeySet set =classOfBusinessProdLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();
            
            //System.out.println(1);
            while (rowKeySetIter.hasNext()) 
            {
                List l = (List) rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();
              
                session.setAttribute("PROD_CODE", r.getAttribute("PROD_CODE"));
                treatyProductDisplay.setValue(r.getAttribute("PROD_DESC"));
            

            }
            ExtendedRenderKitService erkService =
            Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
            ExtendedRenderKitService.class);
            erkService.addScript(FacesContext.getCurrentInstance(),
            "var hints = {autodismissNever:false}; " +
            "AdfPage.PAGE.findComponent('" + "lmsgroup:ClassOfBusinessProductsPopup" +
            "').show(hints);");
                
          
        }
        catch(Exception ex)
        {
            GlobalCC.EXCEPTIONREPORTING(null,ex);
        }
        return null;
        
    }

    public void setTreatyProductDisplay(RichInputText treatyProductDisplay) {
        this.treatyProductDisplay = treatyProductDisplay;
    }

    public RichInputText getTreatyProductDisplay() {
        return treatyProductDisplay;
    }

    public void setClassOfBusinessProdLOV(RichTable classOfBusinessProdLOV) {
        this.classOfBusinessProdLOV = classOfBusinessProdLOV;
    }

    public RichTable getClassOfBusinessProdLOV() {
        return classOfBusinessProdLOV;
    }

    public void setDefaultTreatyProduct(RichSelectOneChoice defaultTreatyProduct) {
        this.defaultTreatyProduct = defaultTreatyProduct;
    }

    public RichSelectOneChoice getDefaultTreatyProduct() {
        return defaultTreatyProduct;
    }

    public void setClbTreatyProducts(RichTable clbTreatyProducts) {
        this.clbTreatyProducts = clbTreatyProducts;
    }

    public RichTable getClbTreatyProducts() {
        return clbTreatyProducts;
    }

    public String EditTreatyProduct() {
        DCIteratorBinding dciter = ADFUtils.findIterator("findArrangementSetups1Iterator");
        RowKeySet set =clbTreatyProducts.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        
        //System.out.println(1);
        while (rowKeySetIter.hasNext()) 
        {
            List l = (List) rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
          
            session.setAttribute("trpd_code", r.getAttribute("TRPD_CODE"));
            
            treatyProductDisplay.setValue(r.getAttribute("PRODUCT_DISPLAY"));
            defaultTreatyProduct.setValue(r.getAttribute("TRTG_DEFAULT_TRTY"));

            // Render Popup
            ExtendedRenderKitService erkService =
            Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
            ExtendedRenderKitService.class);
            erkService.addScript(FacesContext.getCurrentInstance(),
            "var hints = {autodismissNever:false}; " +
            "AdfPage.PAGE.findComponent('" + "lmsgroup:ClassOfBusinessProductsPopup" +
            "').show(hints);");

        }
          
           
        
        return null;
    }

    public String DeleteTreatyProduct() {
        DCIteratorBinding dciter = ADFUtils.findIterator("findArrangementSetups1Iterator");
        RowKeySet set =clbTreatyProducts.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        
        //System.out.println(1);
        while (rowKeySetIter.hasNext()) 
        {
            List l = (List) rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
          
            session.setAttribute("trpd_code", r.getAttribute("TRPD_CODE"));
          

        }
        Connection conn=null;
        String addQuery="BEGIN LMS_SETUPS_PKG.delete_treaty_product(?);END;";
        try
        {
            conn=new DBConnector().getDatabaseConn();
            
            CallableStatement cstmt=conn.prepareCall(addQuery); 
            cstmt.setBigDecimal(1,(BigDecimal)session.getAttribute("trpd_code"));
                    
            
            
            cstmt.execute();
            conn.close();
            String Message = "Treaty Product Deleted succesfully.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            
            session.setAttribute("trpd_code", null);
            ADFUtils.findIterator("findArrangementSetups1Iterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(clbTreatyProducts);  
        }
        catch(Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn,e);
        }
        return null;
    }

    public void setNumCompType(RichSelectOneChoice numCompType) {
        this.numCompType = numCompType;
    }

    public RichSelectOneChoice getNumCompType() {
        return numCompType;
    }

    public String AddLoanInterestRate() {
        session.setAttribute("grptCode",null);
        loanTermTo.setValue(null);
        loanTermFrom.setValue(null);
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:LoanTermsPopup" +
        "').show(hints);");
        return null;
    }

    public void setLoanTermTo(RichInputText loanTermTo) {
        this.loanTermTo = loanTermTo;
    }

    public RichInputText getLoanTermTo() {
        return loanTermTo;
    }

    public String SaveLoanTerm() {
        Connection conn=null;
        String addQuery="BEGIN LMS_SETUPS_PKG.updateLoanterms(?,?,?,?,?);END;";
        if (loanTermTo.getValue()==null)
        {
            String Message = "Enter Loan Term To";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            return null; 
        }
        if (loanTermFrom.getValue()==null)
        {
            String Message = "Enter Loan Term From";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            return null; 
        }
        try
        {
            conn=new DBConnector().getDatabaseConn();
            
            CallableStatement cstmt=conn.prepareCall(addQuery); 
            cstmt.setBigDecimal(1,(BigDecimal)session.getAttribute("grptCode"));
            cstmt.setBigDecimal(2,(BigDecimal)session.getAttribute("pmasCode"));
            cstmt.setBigDecimal(3,(BigDecimal)session.getAttribute("pcdCode"));
            cstmt.setString(4,loanTermFrom.getValue().toString());
            cstmt.setString(5,loanTermTo.getValue().toString());
         
           
            
            
            cstmt.execute();
            conn.close();
            String Message = "Loan Term Saved succesfully.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            
            session.setAttribute("grptCode", null);
            ADFUtils.findIterator("findPremiumRateTermsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(termsLOV);
            ADFUtils.findIterator("findPremiumRatesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(ratesLOV);
        }
        catch(Exception e)
        {
            GlobalCC.EXCEPTIONREPORTING(conn,e);
        }
        return null;
    }

    public String EditLoanTerm() {
        DCIteratorBinding dciter = ADFUtils.findIterator("findPremiumRateTermsIterator");
        RowKeySet set =termsLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        
        //System.out.println(1);
        while (rowKeySetIter.hasNext()) 
        {
            List l = (List) rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
          
            session.setAttribute("grptCode", r.getAttribute("GRPT_CODE"));
            loanTermTo.setValue(r.getAttribute("GRPT_TERM_TO"));
            loanTermFrom.setValue(r.getAttribute("GRPT_TERM_FROM"));

        }
       
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:LoanTermsPopup" +
        "').show(hints);");
        return null;
    }

    public String DeleteLoanTerm() {
        DCIteratorBinding dciter = ADFUtils.findIterator("findPremiumRateTermsIterator");
        RowKeySet set =termsLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        
        //System.out.println(1);
        while (rowKeySetIter.hasNext()) 
        {
            List l = (List) rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
          
            session.setAttribute("grptCode", r.getAttribute("GRPT_CODE"));
           

        }
        Connection conn=null;
        String addQuery="BEGIN LMS_SETUPS_PKG.deleteLoanTerm(?);END;";
        try
        {
            conn=new DBConnector().getDatabaseConn();
            
            CallableStatement cstmt=conn.prepareCall(addQuery); 
            cstmt.setBigDecimal(1,(BigDecimal)session.getAttribute("grptCode"));
                    
            
            
            cstmt.execute();
            conn.close();
            String Message = "Loan Term Deleted succesfully.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            
            session.setAttribute("grptCode", null);
            ADFUtils.findIterator("findPremiumRateTermsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(termsLOV);
            ADFUtils.findIterator("findPremiumRatesIterator").executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(ratesLOV);
        }
        catch(Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn,e);
        }
        return null;
    }

    public void setLoanTermFrom(RichInputText loanTermFrom) {
        this.loanTermFrom = loanTermFrom;
    }

    public RichInputText getLoanTermFrom() {
        return loanTermFrom;
    }

    public String AddLoanInterestRates() {
        session.setAttribute("gpirCode",null);
        rateFrom.setValue(null);
        rateTo.setValue(null);
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:LoanInterestPopup" +
        "').show(hints);");
        return null;
       
    }

    public String EditLoanInterestRates() {
        DCIteratorBinding dciter = ADFUtils.findIterator("findPremiumInterestRatesIterator");
        RowKeySet set =interestLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        
        //System.out.println(1);
        while (rowKeySetIter.hasNext()) 
        {
            List l = (List) rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
          
            session.setAttribute("gpirCode", r.getAttribute("GPIR_CODE"));
            rateFrom.setValue(r.getAttribute("GPIR_RATE_FROM"));
            rateTo.setValue(r.getAttribute("GPIR_RATE_TO"));

        }
        
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:LoanInterestPopup" +
        "').show(hints);");
        return null;
        
    }

    public void setRateFrom(RichInputText rateFrom) {
        this.rateFrom = rateFrom;
    }

    public RichInputText getRateFrom() {
        return rateFrom;
    }

    public void setRateTo(RichInputText rateTo) {
        this.rateTo = rateTo;
    }

    public RichInputText getRateTo() {
        return rateTo;
    }

    public String SaveLoanInterestRate() {
        String addQuery="BEGIN LMS_SETUPS_PKG.updateLoanIneterestRates(?,?,?,?,?);END;";
        Connection conn=null;
        if (rateFrom.getValue()==null)
        {
            String Message = "Enter Loan Interest Rate From";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            return null; 
        }
        if (rateTo.getValue()==null)
        {
            String Message = "Enter Loan Interest Rate To";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            return null; 
        }
        try
        {
            conn=new DBConnector().getDatabaseConn();
            
            CallableStatement cstmt=conn.prepareCall(addQuery); 
            cstmt.setBigDecimal(1,(BigDecimal)session.getAttribute("gpirCode"));
            cstmt.setBigDecimal(2,(BigDecimal)session.getAttribute("pmasCode"));
            cstmt.setBigDecimal(3,(BigDecimal)session.getAttribute("pcdCode"));
            cstmt.setString(4,rateFrom.getValue().toString());
            cstmt.setString(5,rateTo.getValue().toString());
         
           
            
            
            cstmt.execute();
            conn.close();
            String Message = "Loan Interest Saved succesfully.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            
            session.setAttribute("gpirCode", null);
            ADFUtils.findIterator("findPremiumInterestRatesIterator").executeQuery();
            //ADFUtils.findIterator("findPremiumRateTermsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(interestLOV);
            ADFUtils.findIterator("findPremiumRatesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(ratesLOV);
        }
        catch(Exception e)
        {
            GlobalCC.EXCEPTIONREPORTING(conn,e);
        }
        return null;
    }

    public String DeleteLoanInterestRate() {
        DCIteratorBinding dciter = ADFUtils.findIterator("findPremiumInterestRatesIterator");
        RowKeySet set =interestLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        
        //System.out.println(1);
        while (rowKeySetIter.hasNext()) 
        {
            List l = (List) rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
          
            session.setAttribute("gpirCode", r.getAttribute("GPIR_CODE"));
           
        }
        Connection conn=null;
        String addQuery="BEGIN LMS_SETUPS_PKG.deleteLoanInterest(?);END;";
        try
        {
            conn=new DBConnector().getDatabaseConn();
            
            CallableStatement cstmt=conn.prepareCall(addQuery); 
            cstmt.setBigDecimal(1,(BigDecimal)session.getAttribute("gpirCode"));
                    
            
            
            cstmt.execute();
            conn.close();
            String Message = "Loan Interest Rate Deleted succesfully.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            
            session.setAttribute("gpirCode", null);
            ADFUtils.findIterator("findPremiumInterestRatesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(interestLOV);
            ADFUtils.findIterator("findPremiumRatesIterator").executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(ratesLOV);
        }
        catch(Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn,e);
        }
        return null;
    }

    public void setLifeClassLOV(RichTable lifeClassLOV) {
        this.lifeClassLOV = lifeClassLOV;
    }

    public RichTable getLifeClassLOV() {
        return lifeClassLOV;
    }
    
    public String LifeClassSelected(){
        try{
            DCIteratorBinding dciter = ADFUtils.findIterator("findLifeClassesIterator");
            RowKeySet set =lifeClassLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();
            
            //System.out.println(1);
            while (rowKeySetIter.hasNext()) 
            {
                List l = (List) rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();           
                session.setAttribute("lcCode", r.getAttribute("LC_CODE"));
                lifeClassDesc.setValue(r.getAttribute("LC_DESC"));

                ADFUtils.findIterator("findPremiumInterestRatesIterator").executeQuery();
                ADFUtils.findIterator("findPremiumRateTermsIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(interestLOV);
                AdfFacesContext.getCurrentInstance().addPartialTarget(termsLOV);
                ADFUtils.findIterator("findPremiumRatesIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(ratesLOV);
             

                 

         }     
            
            
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }
  public String LifeClassSelectedLoaded(){
      try{
          DCIteratorBinding dciter = ADFUtils.findIterator("findLifeClassesIterator");
          RowKeySet set =lifeClassLOV.getSelectedRowKeys();
          Iterator rowKeySetIter = set.iterator();
          
          //System.out.println(1);
          while (rowKeySetIter.hasNext()) 
          {
              List l = (List) rowKeySetIter.next();
              Key key = (Key)l.get(0);
              dciter.setCurrentRowWithKey(key.toStringFormat(true));
              Row r = dciter.getCurrentRow();           
              session.setAttribute("lcCode", r.getAttribute("LC_CODE"));
              lifeClassDesc.setValue(r.getAttribute("LC_DESC"));
              ADFUtils.findIterator("findImportLoadingRatesIterator").executeQuery();
              AdfFacesContext.getCurrentInstance().addPartialTarget(loadingsLOV);
           

               

       }     
          
          
      }catch(Exception e){
          GlobalCC.EXCEPTIONREPORTING(null,e);
      }
      return null;
  }
    
  public String SchoolClassSelected(){
      try{
          DCIteratorBinding dciter = ADFUtils.findIterator("findSchClassesIterator");
          RowKeySet set =classesLOV.getSelectedRowKeys();
          Iterator rowKeySetIter = set.iterator();
          
          //System.out.println(1);
          while (rowKeySetIter.hasNext()) 
          {
              List l = (List) rowKeySetIter.next();
              Key key = (Key)l.get(0);
              dciter.setCurrentRowWithKey(key.toStringFormat(true));
              Row r = dciter.getCurrentRow();           
              session.setAttribute("schCode", r.getAttribute("SCH_CODE"));
              schClassDesc.setValue(r.getAttribute("SCH_DESC"));

                ADFUtils.findIterator("findPremiumInterestRatesIterator").executeQuery();
                ADFUtils.findIterator("findPremiumRateTermsIterator").executeQuery();
              AdfFacesContext.getCurrentInstance().addPartialTarget(interestLOV);
              AdfFacesContext.getCurrentInstance().addPartialTarget(termsLOV);
                ADFUtils.findIterator("findPremiumRatesIterator").executeQuery();
              AdfFacesContext.getCurrentInstance().addPartialTarget(ratesLOV);

       }     
          
          
      }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
      }
      return null;
  }

    public void lifeClassListener(SelectionEvent selectionEvent) {
        try{
            DCIteratorBinding dciter = ADFUtils.findIterator("findLifeClassesIterator");
            RowKeySet set = selectionEvent.getAddedSet();
            Iterator rowKeySetIter = set.iterator();
            
            //System.out.println(1);
            while (rowKeySetIter.hasNext()) 
            {
                List l = (List) rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();
               
                session.setAttribute("lcCode", r.getAttribute("LC_CODE"));

                ADFUtils.findIterator("findPremiumInterestRatesIterator").executeQuery();
                ADFUtils.findIterator("findPremiumRateTermsIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(interestLOV);
                AdfFacesContext.getCurrentInstance().addPartialTarget(termsLOV);
                ADFUtils.findIterator("findPremiumRatesIterator").executeQuery();
             AdfFacesContext.getCurrentInstance().addPartialTarget(ratesLOV);
             

                 

         }     
            
            
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
    }

    public String AddNewSpecialRate() {
        if(session.getAttribute("ActCode")==null){
            GlobalCC.INFORMATIONREPORTING("Select An Agent");
            return null;
        }
        session.setAttribute("ATR_CODE",null);
        rateShtDesc.setValue(null);
        rateDescription.setValue(null);
        rateWEF.setValue(null);
        rateWet.setValue(null);
        specialRateType.setValue(null);
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:specialRatesPopup" +
        "').show(hints);");
        return null;
    }

    public String EditSpecialRate() {
        try{
            DCIteratorBinding dciter = ADFUtils.findIterator("findAccountRatesIterator");
            RowKeySet set = ratesLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();
            
            //System.out.println(1);
            while (rowKeySetIter.hasNext()) 
            {
                List l = (List) rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                
                session.setAttribute("ATR_CODE", r.getAttribute("ATR_CODE"));
                 rateShtDesc.setValue(r.getAttribute("ATR_SHT_DESC"));
                 rateDescription.setValue(r.getAttribute("ATR_DESC"));
                 rateWEF.setValue(r.getAttribute("ATR_WEF"));
                 rateWet.setValue(r.getAttribute("ATR_WET"));
                 specialRateType.setValue(r.getAttribute("ATR_TYPE"));
         }     
            ExtendedRenderKitService erkService =
            Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
            ExtendedRenderKitService.class);
            erkService.addScript(FacesContext.getCurrentInstance(),
            "var hints = {autodismissNever:false}; " +
            "AdfPage.PAGE.findComponent('" + "lmsgroup:specialRatesPopup" +
            "').show(hints);");   
            
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }

    public String DeleteSpecialRate() {
       
            DCIteratorBinding dciter = ADFUtils.findIterator("findAccountRatesIterator");
            RowKeySet set = ratesLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();
            
            //System.out.println(1);
            while (rowKeySetIter.hasNext()) 
            {
                List l = (List) rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                
                session.setAttribute("ATR_CODE", r.getAttribute("ATR_CODE"));

         }
        Connection conn=null;
        String addQuery="BEGIN LMS_SETUPS_PKG.deleteSpecialRates(?);END;";
        try
        {
            conn=new DBConnector().getDatabaseConn();
            
            CallableStatement cstmt=conn.prepareCall(addQuery); 
            cstmt.setBigDecimal(1,(BigDecimal)session.getAttribute("ATR_CODE"));
                    
            
            
            cstmt.execute();
            conn.close();
            String Message = "Special Rate Deleted succesfully.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            
            session.setAttribute("ATR_CODE", null);
            ADFUtils.findIterator("findAccountRatesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(ratesLOV);
        }
        catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
                }
        return null;
    }

    public void setRateShtDesc(RichInputText rateShtDesc) {
        this.rateShtDesc = rateShtDesc;
    }

    public RichInputText getRateShtDesc() {
        return rateShtDesc;
    }

    public void setRateDescription(RichInputText rateDescription) {
        this.rateDescription = rateDescription;
    }

    public RichInputText getRateDescription() {
        return rateDescription;
    }

    public void setRateWEF(RichInputDate rateWEF) {
        this.rateWEF = rateWEF;
    }

    public RichInputDate getRateWEF() {
        return rateWEF;
    }

    public void setRateWet(RichInputDate rateWet) {
        this.rateWet = rateWet;
    }

    public RichInputDate getRateWet() {
        return rateWet;
    }

    public String SaveSpecialRate() {
        String addQuery="BEGIN LMS_SETUPS_PKG.updateSpecialRates(?,?,?,?,?,?,?);END;";
        Connection conn=null;
        if (rateShtDesc.getValue()==null)
        {
            String Message = "Enter Rate Short Description";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            return null; 
        }
        if (rateDescription.getValue()==null)
        {
            String Message = "Enter Rate Description";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            return null; 
        }
        if (specialRateType.getValue()==null)
        {
            String Message = "Select Special Rate Type";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            return null; 
        }
        if (rateWEF.getValue()==null)
        {
            String Message = "Enter Rate WEF";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            return null; 
        }
        try
        {
            conn=new DBConnector().getDatabaseConn();
            
            CallableStatement cstmt=conn.prepareCall(addQuery); 
            cstmt.setBigDecimal(1,(BigDecimal)session.getAttribute("ATR_CODE"));
            cstmt.setBigDecimal(2,(BigDecimal)session.getAttribute("ActCode"));
            cstmt.setString(3,specialRateType.getValue().toString());
            cstmt.setString(4,rateShtDesc.getValue().toString());
            cstmt.setString(5,rateDescription.getValue().toString());
            if(rateWEF.getValue()==null) {
                cstmt.setString(6,null);
            }
            else {
                String WET = null;
                if(rateWEF.getValue().toString().contains(":")){
                    WET = GlobalCC.parseDate(rateWEF.getValue().toString());
                }else{
                    WET = GlobalCC.upDateParseDate(rateWEF.getValue().toString());
                }
                cstmt.setString(6,WET);
            }
            //cstmt.setString(6,GlobalCC.parseDate(rateWEF.getValue().toString()));
            if(rateWet.getValue()==null) {
                cstmt.setString(7,null);
            }
            else {
                cstmt.setString(7, GlobalCC.parseDate(rateWet.getValue().toString()));
            }
            
            
            cstmt.execute();
            conn.close();
            String Message = "Special Rate Saved succesfully.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            
            session.setAttribute("ATR_CODE", null);
            ADFUtils.findIterator("findAccountRatesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(ratesLOV);
        }
        catch(Exception e)
        {
            GlobalCC.EXCEPTIONREPORTING(conn,e);
        }
        return null;
    }

    public void setSpecialRateType(RichSelectOneChoice specialRateType) {
        this.specialRateType = specialRateType;
    }

    public RichSelectOneChoice getSpecialRateType() {
        return specialRateType;
    }

    public String AddLifeCommissionRates() {
        session.setAttribute("CRAT_CODE",null);
        rangelcFrom.setValue(null);
        lcRangeTo.setValue(null);
        lcRate.setValue(null);
        ratelcType.setValue(null);
        lcPayFreq.setValue(null);
        lcRateType.setValue(null);
        polTermFrom.setValue(null);
        polTermTo.setValue(null);
        yearNoFrom.setValue(null);
        yearNumberTo.setValue(null);
        lcWET.setValue(null);
        lcWetDate.setValue(null);
        lcAnbFrom.setValue(null);
        lcAnbTo.setValue(null);
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:lifeCommissionPopup" +
        "').show(hints);");
        return null;
    }

    public String EditLifeCommissionRates() {
        DCIteratorBinding dciter = ADFUtils.findIterator("findCommissionRatesIterator");
        RowKeySet set = lifeCommissionLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        
        //System.out.println(1);
        while (rowKeySetIter.hasNext()) 
        {
            List l = (List) rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            
            session.setAttribute("CRAT_CODE", r.getAttribute("CRAT_CODE"));
            rangelcFrom.setValue(r.getAttribute("CRAT_RANGE_FROM"));
            lcRangeTo.setValue(r.getAttribute("CRAT_RANGE_TO"));
            lcRate.setValue(r.getAttribute("CRAT_RATE"));
            lcRateType.setValue(r.getAttribute("CRAT_RATE_TYPE"));
            lcPayFreq.setValue(r.getAttribute("CRAT_PAY_FREQ"));
            ratelcType.setValue(r.getAttribute("CRAT_RATE_DESC"));
            polTermFrom.setValue(r.getAttribute("CRAT_TERM_FROM"));
            polTermTo.setValue(r.getAttribute("CRAT_TERM_TO"));
            yearNoFrom.setValue(r.getAttribute("CRAT_YR_NO_FROM"));
            yearNumberTo.setValue(r.getAttribute("CRAT_YR_NO_TO"));
            lcWET.setValue(r.getAttribute("CRAT_WEF_DATE"));
            lcWetDate.setValue(r.getAttribute("CRAT_WET_DATE"));
            lcAnbFrom.setValue(r.getAttribute("CRAT_ANB_FROM"));
            lcAnbTo.setValue(r.getAttribute("CRAT_ANB_TO"));
        }
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:lifeCommissionPopup" +
        "').show(hints);");
        return null;
    }

    public String DeleteLifeCommissionRates() {
        DCIteratorBinding dciter = ADFUtils.findIterator("findCommissionRatesIterator");
        RowKeySet set = lifeCommissionLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        
        //System.out.println(1);
        while (rowKeySetIter.hasNext()) 
        {
            List l = (List) rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            
            session.setAttribute("CRAT_CODE", r.getAttribute("CRAT_CODE"));

        }
        Connection conn=null;
        String addQuery="BEGIN LMS_SETUPS_PKG.delete_commission_rates(?);END;";
        try
        {
        conn=new DBConnector().getDatabaseConn();
        
        CallableStatement cstmt=conn.prepareCall(addQuery); 
        cstmt.setBigDecimal(1,(BigDecimal)session.getAttribute("CRAT_CODE"));
                
        
        
        cstmt.execute();
        conn.close();
        String Message = "Commission Rate Deleted succesfully.";
        FacesContext.getCurrentInstance().addMessage(null, 
                                                     new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                      Message, 
                                                                      Message));
        
        session.setAttribute("CRAT_CODE", null);
            ADFUtils.findIterator("findCommissionRatesIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(lifeCommissionLOV);
        }
        catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
            }
        return null;
    }

    public void setRangelcFrom(RichInputText rangelcFrom) {
        this.rangelcFrom = rangelcFrom;
    }

    public RichInputText getRangelcFrom() {
        return rangelcFrom;
    }

    public void setRatelcType(RichSelectOneChoice ratelcType) {
        this.ratelcType = ratelcType;
    }

    public RichSelectOneChoice getRatelcType() {
        return ratelcType;
    }

    public void setLcPayFreq(RichSelectOneChoice lcPayFreq) {
        this.lcPayFreq = lcPayFreq;
    }

    public RichSelectOneChoice getLcPayFreq() {
        return lcPayFreq;
    }

    public void setLcRateType(RichSelectOneChoice lcRateType) {
        this.lcRateType = lcRateType;
    }

    public RichSelectOneChoice getLcRateType() {
        return lcRateType;
    }

    public void setPolTermFrom(RichInputText polTermFrom) {
        this.polTermFrom = polTermFrom;
    }

    public RichInputText getPolTermFrom() {
        return polTermFrom;
    }

    public void setPolTermTo(RichInputText polTermTo) {
        this.polTermTo = polTermTo;
    }

    public RichInputText getPolTermTo() {
        return polTermTo;
    }

    public void setYearNoFrom(RichInputText yearNoFrom) {
        this.yearNoFrom = yearNoFrom;
    }

    public RichInputText getYearNoFrom() {
        return yearNoFrom;
    }

    public void setYearNumberTo(RichInputText yearNumberTo) {
        this.yearNumberTo = yearNumberTo;
    }

    public RichInputText getYearNumberTo() {
        return yearNumberTo;
    }

    public void setLcWET(RichInputDate lcWET) {
        this.lcWET = lcWET;
    }

    public RichInputDate getLcWET() {
        return lcWET;
    }

    public void setLcWetDate(RichInputDate lcWetDate) {
        this.lcWetDate = lcWetDate;
    }

    public RichInputDate getLcWetDate() {
        return lcWetDate;
    }

    public void setLcAnbFrom(RichInputText lcAnbFrom) {
        this.lcAnbFrom = lcAnbFrom;
    }

    public RichInputText getLcAnbFrom() {
        return lcAnbFrom;
    }

    public void setLcAnbTo(RichInputText lcAnbTo) {
        this.lcAnbTo = lcAnbTo;
    }

    public RichInputText getLcAnbTo() {
        return lcAnbTo;
    }

    public String SaveLifeCommissionRates() {
        String addQuery="BEGIN LMS_SETUPS_PKG.update_commission_rates(?,?,?,?,?,?,?,?,?,?," +
            "?,?,?,?,?,?,?,?,?,?,?);END;";
        /*,?,?" +
            "?,?,?,?,?,?,?,?,?,?,?*/
        Connection conn=null;
        if (lcRate.getValue()==null)
        {
            String Message = "Enter Commission Rate";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            return null; 
        }
        if (lcRateType.getValue()==null)
        {
            String Message = "Enter Rate Type";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            return null; 
        }
        if (polTermFrom.getValue()==null)
        {
            String Message = "Enter Policy Term From";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            return null; 
        }
        if (polTermTo.getValue()==null)
        {
            String Message = "Enter Policy Term To";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            return null; 
        }
        if (lcWET.getValue()==null)
        {
            String Message = "Enter Rate With Effect From Date";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            return null; 
        }
        if (lcPayFreq.getValue()==null)
        {
            String Message = "Enter Payment Frequency";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            return null; 
        }
        if (yearNoFrom.getValue()==null)
        {
            String Message = "Enter Year Number From";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            return null; 
        }
        if (yearNumberTo.getValue()==null)
        {
            String Message = "Enter Year Number To";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            return null; 
        }
        try
        {
            conn=new DBConnector().getDatabaseConn();
            
            CallableStatement cstmt=conn.prepareCall(addQuery); 
            cstmt.setBigDecimal(1,(BigDecimal)session.getAttribute("CRAT_CODE"));
            if(lcRate.getValue()==null) {
                cstmt.setString(2,null);
            }
            else {
                cstmt.setString(2,lcRate.getValue().toString());  
            }
            cstmt.setString(3,ratelcType.getValue().toString());
            if(lcWET.getValue()==null){
                cstmt.setString(4, null);
            }else{
                String WET = null;
                if(lcWET.getValue().toString().contains(":")){
                    WET = GlobalCC.parseDate(lcWET.getValue().toString());
                }else{
                    WET = GlobalCC.upDateParseDate(lcWET.getValue().toString());
                }
                cstmt.setString(4,WET);
            }
          
            if(lcWetDate.getValue()==null) {
                cstmt.setString(5,null);
            }
            else {
                String WET = null;
                if(lcWetDate.getValue().toString().contains(":")){
                    WET = GlobalCC.parseDate(lcWetDate.getValue().toString());
                }else{
                    WET = GlobalCC.upDateParseDate(lcWetDate.getValue().toString());
                }
                cstmt.setString(5,WET);
            }
            cstmt.setBigDecimal(6,(BigDecimal)session.getAttribute("ActCode"));
            cstmt.setString(7,null);
            cstmt.setString(8,lcRateType.getValue().toString());
            if(rangelcFrom.getValue()==null) {
                cstmt.setString(9,null);
            }
            else {
                cstmt.setString(9,rangelcFrom.getValue().toString());  
            }
            if(lcRangeTo.getValue()==null) {
                cstmt.setString(10,null);
            }
            else {
                cstmt.setString(10,lcRangeTo.getValue().toString());  
            }
           cstmt.setBigDecimal(11,(BigDecimal)session.getAttribute("ProductCode"));
            cstmt.setString(12,yearNoFrom.getValue().toString());
            cstmt.setString(13,yearNumberTo.getValue().toString());
            cstmt.setString(14,polTermFrom.getValue().toString());
            cstmt.setString(15,polTermTo.getValue().toString());
            cstmt.setString(16,lcPayFreq.getValue().toString());
            cstmt.setBigDecimal(17,(BigDecimal)session.getAttribute("pctCode"));
            cstmt.setBigDecimal(18,(BigDecimal)session.getAttribute("ATR_CODE"));
            if(lcAnbFrom.getValue()==null){
                cstmt.setString(19,null);
            }else{
                cstmt.setString(19,lcAnbFrom.getValue().toString());
            }
            if(lcAnbTo.getValue()==null){
                cstmt.setString(20,null);
            }else{
                cstmt.setString(20,lcAnbTo.getValue().toString());
            }
            cstmt.setString(21,null);
            cstmt.execute();
            conn.close();
            String Message = "Commission Rate Saved succesfully.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            
            session.setAttribute("CRAT_CODE", null);
            ADFUtils.findIterator("findCommissionRatesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(lifeCommissionLOV);
        }
        catch(Exception e)
        {
            // e.printStackTrace();
            GlobalCC.EXCEPTIONREPORTING(conn,e);
        }
        return null;
    }

    public void setLifeCommissionLOV(RichTable lifeCommissionLOV) {
        this.lifeCommissionLOV = lifeCommissionLOV;
    }

    public RichTable getLifeCommissionLOV() {
        return lifeCommissionLOV;
    }

    public void setLcRangeTo(RichInputText lcRangeTo) {
        this.lcRangeTo = lcRangeTo;
    }

    public RichInputText getLcRangeTo() {
        return lcRangeTo;
    }

    public void setLcRate(RichInputText lcRate) {
        this.lcRate = lcRate;
    }

    public RichInputText getLcRate() {
        return lcRate;
    }

    public void commratesProdListener(SelectionEvent selectionEvent) {
        DCIteratorBinding dciter = ADFUtils.findIterator("findProductsIterator");
        RowKeySet set = productsLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        
        //System.out.println(1);
        while (rowKeySetIter.hasNext()) 
        {
            List l = (List) rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            
            session.setAttribute("ProductCode", r.getAttribute("PROD_CODE"));
            ADFUtils.findIterator("findCommissionRatesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(lifeCommissionLOV);
            ADFUtils.findIterator("findPensionCommissionRatesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(pensionCommissions);
            ADFUtils.findIterator("findCommissionAnnualisationIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(annualCommissionsLOV);
        }
    }

    public void SpecialRatesListener(SelectionEvent selectionEvent) {
        DCIteratorBinding dciter = ADFUtils.findIterator("findAccountRatesIterator");
        RowKeySet set =ratesLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        
        //System.out.println(1);
        while (rowKeySetIter.hasNext()) 
        {
            List l = (List) rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            
            session.setAttribute("ATR_CODE", r.getAttribute("ATR_CODE"));
            ADFUtils.findIterator("findCommissionRatesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(lifeCommissionLOV);
            ADFUtils.findIterator("findPensionCommissionRatesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(pensionCommissions);
            ADFUtils.findIterator("findCommissionAnnualisationIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(annualCommissionsLOV);
        }
    }

    public void setPcRangeFrom(RichInputText pcRangeFrom) {
        this.pcRangeFrom = pcRangeFrom;
    }

    public RichInputText getPcRangeFrom() {
        return pcRangeFrom;
    }

    public void setPcRangeTo(RichInputText pcRangeTo) {
        this.pcRangeTo = pcRangeTo;
    }

    public RichInputText getPcRangeTo() {
        return pcRangeTo;
    }

    public void setPcRate(RichInputText pcRate) {
        this.pcRate = pcRate;
    }

    public RichInputText getPcRate() {
        return pcRate;
    }

    public void setPcRateDesc(RichSelectOneChoice pcRateDesc) {
        this.pcRateDesc = pcRateDesc;
    }

    public RichSelectOneChoice getPcRateDesc() {
        return pcRateDesc;
    }

    public void setPcPayFreq(RichSelectOneChoice pcPayFreq) {
        this.pcPayFreq = pcPayFreq;
    }

    public RichSelectOneChoice getPcPayFreq() {
        return pcPayFreq;
    }

    public void setPcRateType(RichSelectOneChoice pcRateType) {
        this.pcRateType = pcRateType;
    }

    public RichSelectOneChoice getPcRateType() {
        return pcRateType;
    }

    public void setPcTermFrom(RichInputText pcTermFrom) {
        this.pcTermFrom = pcTermFrom;
    }

    public RichInputText getPcTermFrom() {
        return pcTermFrom;
    }

    public void setPcPolicyTermTo(RichInputText pcPolicyTermTo) {
        this.pcPolicyTermTo = pcPolicyTermTo;
    }

    public RichInputText getPcPolicyTermTo() {
        return pcPolicyTermTo;
    }

    public void setPcYearNoFrom(RichInputText pcYearNoFrom) {
        this.pcYearNoFrom = pcYearNoFrom;
    }

    public RichInputText getPcYearNoFrom() {
        return pcYearNoFrom;
    }

    public void setPcYearNumberTo(RichInputText pcYearNumberTo) {
        this.pcYearNumberTo = pcYearNumberTo;
    }

    public RichInputText getPcYearNumberTo() {
        return pcYearNumberTo;
    }

    public void setPcWEF(RichInputText pcWEF) {
        this.pcWEF = pcWEF;
    }

    public RichInputText getPcWEF() {
        return pcWEF;
    }

    public void setPcWef(RichInputDate pcWef) {
        this.pcWef = pcWef;
    }

    public RichInputDate getPcWef() {
        return pcWef;
    }

    public void setPcWet(RichInputDate pcWet) {
        this.pcWet = pcWet;
    }

    public RichInputDate getPcWet() {
        return pcWet;
    }

    public void setPcAnbAtEntry(RichInputText pcAnbAtEntry) {
        this.pcAnbAtEntry = pcAnbAtEntry;
    }

    public RichInputText getPcAnbAtEntry() {
        return pcAnbAtEntry;
    }

    public void setPcAnbAtEntryTo(RichInputText pcAnbAtEntryTo) {
        this.pcAnbAtEntryTo = pcAnbAtEntryTo;
    }

    public RichInputText getPcAnbAtEntryTo() {
        return pcAnbAtEntryTo;
    }

    public String SavePensionCommissionrates() {
        Connection conn=null;
        String addQuery="BEGIN LMS_SETUPS_PKG.update_pens_comm_rates(?,?,?,?,?,?,?,?,?,?," +
            "?,?,?,?,?,?,?,?,?,?,?);END;";
        try
        {
            conn=new DBConnector().getDatabaseConn();
            
            CallableStatement cstmt=conn.prepareCall(addQuery); 
            cstmt.setBigDecimal(1,(BigDecimal)session.getAttribute("PCRAT_CODE"));
            if(pcRate.getValue()==null) {
                cstmt.setString(2,null);
            }
            else {
                cstmt.setString(2,pcRate.getValue().toString());  
            }
            cstmt.setString(3,pcRateDesc.getValue().toString());
           cstmt.setString(4, GlobalCC.parseDate(pcWef.getValue().toString()));
            if(pcWet.getValue()==null) {
                cstmt.setString(5,null);
            }
            else {
                cstmt.setString(5, GlobalCC.parseDate(pcWet.getValue().toString()));
            }
            cstmt.setBigDecimal(6,(BigDecimal)session.getAttribute("ActCode"));
            cstmt.setString(7,null);
            cstmt.setString(8,pcRateType.getValue().toString());
            if(pcRangeFrom.getValue()==null) {
                cstmt.setString(9,null);
            }
            else {
                cstmt.setString(9,pcRangeFrom.getValue().toString());  
            }
            if(pcRangeTo.getValue()==null) {
                cstmt.setString(10,null);
            }
            else {
                cstmt.setString(10,pcRangeTo.getValue().toString());  
            }
           cstmt.setBigDecimal(11,(BigDecimal)session.getAttribute("ProductCode"));
            cstmt.setString(12,pcYearNoFrom.getValue().toString());
            cstmt.setString(13,pcYearNumberTo.getValue().toString());
            cstmt.setString(14,pcTermFrom.getValue().toString());
            cstmt.setString(15,pcPolicyTermTo.getValue().toString());
            cstmt.setString(16,pcPayFreq.getValue().toString());
            cstmt.setBigDecimal(17,null);
            cstmt.setBigDecimal(18,(BigDecimal)session.getAttribute("ATR_CODE"));
            cstmt.setString(19,pcAnbAtEntry.getValue().toString());
            cstmt.setString(20,pcAnbAtEntryTo.getValue().toString());
              cstmt.setString(21,null);
            cstmt.execute();
            conn.close();
            String Message = " Pension Commission Rate Saved succesfully.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            
            session.setAttribute("PCRAT_CODE", null);
            ADFUtils.findIterator("findPensionCommissionRatesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(pensionCommissions);
        }
        catch(Exception e)
        {
            // e.printStackTrace();
            GlobalCC.EXCEPTIONREPORTING(conn,e);
        }
        return null;
    }

    public String AddPensionCommissionRates() {
        session.setAttribute("PCRAT_CODE",null);
        pcRangeFrom.setValue(null);
        pcRangeTo.setValue(null);
        pcRate.setValue(null);
        pcRateDesc.setValue(null);
        pcPayFreq.setValue(null);
        pcRateType.setValue(null);
        pcPolicyTermTo.setValue(null);
        pcTermFrom.setValue(null);
        pcYearNoFrom.setValue(null);
        pcYearNumberTo.setValue(null);
        pcWef.setValue(null);
        pcWet.setValue(null);
        pcAnbAtEntry.setValue(null);
        pcAnbAtEntryTo.setValue(null);
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:pensionCommRatesPopup" +
        "').show(hints);");
        return null;
    }

    public String EditPensionCommRates() {
        DCIteratorBinding dciter = ADFUtils.findIterator("findPensionCommissionRatesIterator");
        RowKeySet set = pensionCommissions.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        
        //System.out.println(1);
        while (rowKeySetIter.hasNext()) 
        {
            List l = (List) rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            
            session.setAttribute("PCRAT_CODE", r.getAttribute("CRAT_CODE"));
            pcRangeFrom.setValue(r.getAttribute("CRAT_RANGE_FROM"));
            pcRangeTo.setValue(r.getAttribute("CRAT_RANGE_TO"));
            pcRate.setValue(r.getAttribute("CRAT_RATE"));
            pcRateType.setValue(r.getAttribute("CRAT_RATE_TYPE"));
            pcPayFreq.setValue(r.getAttribute("CRAT_PAY_FREQ"));
            pcRateDesc.setValue(r.getAttribute("CRAT_RATE_DESC"));
            pcTermFrom.setValue(r.getAttribute("CRAT_TERM_FROM"));
            pcPolicyTermTo.setValue(r.getAttribute("CRAT_TERM_TO"));
            pcYearNoFrom.setValue(r.getAttribute("CRAT_YR_NO_FROM"));
            pcYearNumberTo.setValue(r.getAttribute("CRAT_YR_NO_TO"));
            pcWef.setValue(r.getAttribute("CRAT_WEF_DATE"));
            pcWet.setValue(r.getAttribute("CRAT_WET_DATE"));
            pcAnbAtEntry.setValue(r.getAttribute("CRAT_ANB_FROM"));
            pcAnbAtEntryTo.setValue(r.getAttribute("CRAT_ANB_TO"));
        }
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:pensionCommRatesPopup" +
        "').show(hints);");
        return null;
    }

    public String DeletePensionCommRates() {
        DCIteratorBinding dciter = ADFUtils.findIterator("findPensionCommissionRatesIterator");
        RowKeySet set = pensionCommissions.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        
        //System.out.println(1);
        while (rowKeySetIter.hasNext()) 
        {
            List l = (List) rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            
            session.setAttribute("PCRAT_CODE", r.getAttribute("CRAT_CODE"));

        }
        Connection conn=null;
        String addQuery="BEGIN LMS_SETUPS_PKG.delete_pens_commission_rates(?);END;";
        try
        {
        conn=new DBConnector().getDatabaseConn();
        
        CallableStatement cstmt=conn.prepareCall(addQuery); 
        cstmt.setBigDecimal(1,(BigDecimal)session.getAttribute("PCRAT_CODE"));
                
        
        
        cstmt.execute();
        conn.close();
        String Message = "Commission Rate Deleted succesfully.";
        FacesContext.getCurrentInstance().addMessage(null, 
                                                     new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                      Message, 
                                                                      Message));
        
        session.setAttribute("PCRAT_CODE", null);
            ADFUtils.findIterator("findPensionCommissionRatesIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(pensionCommissions);
        }
        catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
            }
        return null;
    }

    public void setPensionCommissions(RichTable pensionCommissions) {
        this.pensionCommissions = pensionCommissions;
    }

    public RichTable getPensionCommissions() {
        return pensionCommissions;
    }

    public String AddAnnualCommRates() {
        session.setAttribute("ACR_CODE",null);
        annualRate.setValue(null);
        annualBal.setValue(null);
        duration.setValue(null);
        balPymntMnth.setValue(null);
        annWEF.setValue(null);
        annWET.setValue(null);
       
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:AnnualCommissionsPopup" +
        "').show(hints);");
        return null;
    }

    public String EditAnnCommRates() {
        DCIteratorBinding dciter = ADFUtils.findIterator("findCommissionAnnualisationIterator");
        RowKeySet set = annualCommissionsLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        
        //System.out.println(1);
        while (rowKeySetIter.hasNext()) 
        {
            List l = (List) rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            
           // session.setAttribute("PCRAT_CODE", r.getAttribute("CRAT_CODE"));
            session.setAttribute("ACR_CODE", r.getAttribute("ACR_CODE"));
            annualRate.setValue(r.getAttribute("ACR_ANN_RATE"));
            annualBal.setValue(r.getAttribute("ACR_ANN_BAL_RATE"));
            duration.setValue(r.getAttribute("ACR_ANN_ANNUALISATION_DURATION"));
            balPymntMnth.setValue(r.getAttribute("ACR_ANN_BAL_PYMT_MNTH"));
            annWEF.setValue(r.getAttribute("ACR_WEF_DATE"));
            annWET.setValue(r.getAttribute("ACR_WET_DATE"));
        }
        ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
        ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
        "var hints = {autodismissNever:false}; " +
        "AdfPage.PAGE.findComponent('" + "lmsgroup:AnnualCommissionsPopup" +
        "').show(hints);");
        return null;
    }

    public String DeleteAnnCommRates() {
        DCIteratorBinding dciter = ADFUtils.findIterator("findCommissionAnnualisationIterator");
        RowKeySet set = annualCommissionsLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        
        //System.out.println(1);
        while (rowKeySetIter.hasNext()) 
        {
            List l = (List) rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            
           // session.setAttribute("PCRAT_CODE", r.getAttribute("CRAT_CODE"));
            session.setAttribute("ACR_CODE", r.getAttribute("ACR_CODE"));
           
        }
        Connection conn=null;
        String addQuery="BEGIN LMS_SETUPS_PKG.delete_ann_comm_rates(?);END;";
        try
        {
        conn=new DBConnector().getDatabaseConn();
        
        CallableStatement cstmt=conn.prepareCall(addQuery); 
        cstmt.setBigDecimal(1,(BigDecimal)session.getAttribute("ACR_CODE"));
                
        
        
        cstmt.execute();
        conn.close();
        String Message = "Commission Rate Deleted succesfully.";
        FacesContext.getCurrentInstance().addMessage(null, 
                                                     new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                      Message, 
                                                                      Message));
        
        session.setAttribute("ACR_CODE", null);
            ADFUtils.findIterator("findCommissionAnnualisationIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(annualCommissionsLOV);
        }
        catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
            }
        return null;
    }

    public void setAnnualCommissionsLOV(RichTable annualCommissionsLOV) {
        this.annualCommissionsLOV = annualCommissionsLOV;
    }

    public RichTable getAnnualCommissionsLOV() {
        return annualCommissionsLOV;
    }

    public String SaveAnnCommRates() {
        String addQuery="BEGIN LMS_SETUPS_PKG.update_ann_comm_rates(?,?,?,?,?,?,?,?,?);END;";
        Connection conn=null;
        try
        {
            conn=new DBConnector().getDatabaseConn();
            
            CallableStatement cstmt=conn.prepareCall(addQuery); 
            cstmt.setBigDecimal(1,(BigDecimal)session.getAttribute("ACR_CODE"));
            cstmt.setBigDecimal(2,(BigDecimal)session.getAttribute("ActCode"));
            cstmt.setString(3,annualRate.getValue().toString());
            cstmt.setString(4,annualBal.getValue().toString());
            cstmt.setString(5,duration.getValue().toString());
            cstmt.setString(6,balPymntMnth.getValue().toString());
            cstmt.setBigDecimal(7,(BigDecimal)session.getAttribute("ProductCode"));
            cstmt.setString(8, GlobalCC.parseDate(annWEF.getValue().toString()));
             if(pcWet.getValue()==null) {
                 cstmt.setString(9,null);
             }
             else {
                 cstmt.setString(9, GlobalCC.parseDate(annWET.getValue().toString()));
             }
            cstmt.execute();
            conn.close();
            String Message = "Commission Rate Saved succesfully.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            
          
            session.setAttribute("ACR_CODE", null);
            ADFUtils.findIterator("findCommissionAnnualisationIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(annualCommissionsLOV);
        }
        catch(Exception e)
        {
            // e.printStackTrace();
            GlobalCC.EXCEPTIONREPORTING(conn,e);
        }
        return null;
    }

    public String SaveGroupPremiumRates() {
        Connection conn=null;
        try 
        {
            
            if(anbFrom.getValue()==null){
                String Message = "Enter A ANB From";
                FacesContext.getCurrentInstance().addMessage(null, 
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                              Message, 
                                                                              Message));
                return null;
            }
            
            if(anbFrom.getValue()==null){
                String Message = "Enter A ANB To";
                FacesContext.getCurrentInstance().addMessage(null, 
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                              Message, 
                                                                              Message));
                return null;
            }
            
            if(rate.getValue()==null){
                String Message = "Enter A Rate";
                FacesContext.getCurrentInstance().addMessage(null, 
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                              Message, 
                                                                              Message));
                return null;
            }
            
            Boolean WEFDateChanged = false;
            Boolean WETDateChanged = false;
            
            if(wef.getValue()==null){
            }else{
                WEFDateChanged = wef.getValue().toString().contains(":");
            }
            
            if(wet.getValue()==null){
            }else{
                WETDateChanged = wet.getValue().toString().contains(":");
            }


           
            
            String authQuery="BEGIN LMS_SETUPS_PKG.updateGroupPremiumRates(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);END;";
           conn=new DBConnector().getDatabaseConn();
            
            
            CallableStatement cstmt=conn.prepareCall(authQuery);    
            cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("gprCode"));
            System.out.println(session.getAttribute("gprCode"));
            if(anbFrom.getValue()==null){
                cstmt.setString(2, null);
            }else{
                cstmt.setString(2, anbFrom.getValue().toString());  
            }
            if(anbTo.getValue()==null){
                cstmt.setString(3, null);
            }else{
                cstmt.setString(3, anbTo.getValue().toString());  
            }
            if(rangeFrom.getValue()==null){
                cstmt.setString(4, null);
            }else{
                cstmt.setString(4, rangeFrom.getValue().toString());  
            }
            if(rangeTo.getValue()==null){
                cstmt.setString(5, null);
            }else{
                cstmt.setString(5, rangeTo.getValue().toString());  
            }
            if(rate.getValue()==null){
                cstmt.setString(6, null);
            }else{
                    cstmt.setString(6, rate.getValue().toString());   
            }
            if(annualRate.getValue()==null){
                cstmt.setString(7, null);
            }else{
                    cstmt.setString(7, annualRate.getValue().toString());   
            }
            if(singleRate.getValue()==null){
                cstmt.setString(8, null);
            }else{
                    cstmt.setString(8, singleRate.getValue().toString());   
            }
            if(rateDesc.getValue()==null){
                cstmt.setString(9, null);
            }else{
                    cstmt.setString(9, rateDesc.getValue().toString());   
            }
            if(divFactor.getValue()==null){
                cstmt.setString(10, null);
            }else{
                    cstmt.setString(10, divFactor.getValue().toString());   
            }
            if(rateType.getValue()==null){
                cstmt.setString(11, null);
            }else{
                    cstmt.setString(11, rateType.getValue().toString());   
            }
            if(prorate.getValue()==null){
                cstmt.setString(12, null);
            }else{
                    cstmt.setString(12, prorate.getValue().toString());   
            }
            if(multiRate.getValue()==null){
                cstmt.setString(13, null);
            }else{
                    cstmt.setString(13, multiRate.getValue().toString());   
            }
            if(multiDivFac.getValue()==null){
                cstmt.setString(14, null);
            }else{
                    cstmt.setString(14, multiDivFac.getValue().toString());   
            }
            if(constant.getValue()==null){
                cstmt.setString(15, null);
            }else{
                    cstmt.setString(15, constant.getValue().toString());   
            }
            if(constantDivFac.getValue()==null){
                cstmt.setString(16, null);
            }else{
                    cstmt.setString(16, constantDivFac.getValue().toString());   
            }
            if(refund.getValue()==null){
                cstmt.setString(17, null);
            }else{
                    cstmt.setString(17, refund.getValue().toString());   
            }
            if(wef.getValue()==null){
                cstmt.setString(18, null);
            }else{
                if(WEFDateChanged==false){
                    cstmt.setString(18, null); 
                }else{
                    cstmt.setString(18, LOVCC.parseDate(wef.getValue().toString()));   
                }
            }
            if(wet.getValue()==null){
                cstmt.setString(19, null);
            }else{
                if(WETDateChanged==false){
                    cstmt.setString(19, null); 
                }else{
                    cstmt.setString(19, LOVCC.parseDate(wet.getValue().toString()));   
                }
            }
            cstmt.setBigDecimal(20, (BigDecimal)session.getAttribute("pctCode"));
            cstmt.setBigDecimal(21, (BigDecimal)session.getAttribute("pmasCode"));
            cstmt.setBigDecimal(22, (BigDecimal)session.getAttribute("pcdCode"));
            cstmt.setBigDecimal(23, (BigDecimal)session.getAttribute("dtyCode"));
            cstmt.setString(24, (String)session.getAttribute("dtyShtDesc"));
            cstmt.setBigDecimal(25, (BigDecimal)session.getAttribute("grptCode"));
            cstmt.setBigDecimal(26, (BigDecimal)session.getAttribute("gpirCode"));
            cstmt.setBigDecimal(27, (BigDecimal)session.getAttribute("lcCode")); //lc Code
            cstmt.setBigDecimal(28, (BigDecimal)session.getAttribute("cvtCode"));
            cstmt.setString(29, (String)session.getAttribute("cvtShtDesc"));
         

           
            cstmt.execute();
            conn.close();
            
            String Message = "Premium Rate Rate Saved succesfully.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            
            session.setAttribute("gprCode", null);
            ADFUtils.findIterator("findPremiumRatesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(ratesLOV);    
          
        }
        catch(Exception ex)
        {
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

    public void setTaxTypeDesc(RichInputText taxTypeDesc) {
        this.taxTypeDesc = taxTypeDesc;
    }

    public RichInputText getTaxTypeDesc() {
        return taxTypeDesc;
    }

    public void applicableLevelListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if(applLevel.getValue()==null){
            splitterPanel.setSplitterPosition(200);
        }else if(applLevel.getValue().toString().equalsIgnoreCase("Y")){
            session.setAttribute("taxtypeAppl", "Y");
            splitterPanel.setSplitterPosition(200);
        }else{
            session.setAttribute("taxtypeAppl", "N");
            splitterPanel.setSplitterPosition(0);
            
        }
        session.setAttribute("ProductCode", null);
        taxTypeDesc.setValue(null);
        session.setAttribute("ttCode", null);
        ADFUtils.findIterator("findTaxRatesIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(ratesLOV);
        ADFUtils.findIterator("findTaxTypesbyAppLevelIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(taxesLOV);
        ADFUtils.findIterator("findAllProductsIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(productsTree);  
        
    }

    public void setApplLevel(RichSelectOneChoice applLevel) {
        this.applLevel = applLevel;
    }

    public RichSelectOneChoice getApplLevel() {
        return applLevel;
    }

    public void setSplitterPanel(RichPanelSplitter splitterPanel) {
        this.splitterPanel = splitterPanel;
    }

    public RichPanelSplitter getSplitterPanel() {
        return splitterPanel;
    }

    public void setCvrTypeDepDesc(RichInputText cvrTypeDepDesc) {
        this.cvrTypeDepDesc = cvrTypeDepDesc;
    }

    public RichInputText getCvrTypeDepDesc() {
        return cvrTypeDepDesc;
    }

    public void setLifeClassDesc(RichInputText lifeClassDesc) {
        this.lifeClassDesc = lifeClassDesc;
    }

    public RichInputText getLifeClassDesc() {
        return lifeClassDesc;
    }

    public void setLapsation(RichSelectBooleanRadio lapsation) {
        this.lapsation = lapsation;
    }

    public RichSelectBooleanRadio getLapsation() {
        return lapsation;
    }

    public void setReinstatement(RichOutputLabel reinstatement) {
        this.reinstatement = reinstatement;
    }

    public RichOutputLabel getReinstatement() {
        return reinstatement;
    }

    public void setContraTransaction(RichSelectBooleanRadio contraTransaction) {
        this.contraTransaction = contraTransaction;
    }

    public RichSelectBooleanRadio getContraTransaction() {
        return contraTransaction;
    }

    public void setLoansPanel(HtmlPanelGrid loansPanel) {
        this.loansPanel = loansPanel;
    }

    public HtmlPanelGrid getLoansPanel() {
        return loansPanel;
    }

    public void setClassesTree(RichTree classesTree) {
        this.classesTree = classesTree;
    }

    public RichTree getClassesTree() {
        return classesTree;
    }

    public void setClassesLabel(RichOutputLabel classesLabel) {
        this.classesLabel = classesLabel;
    }

    public RichOutputLabel getClassesLabel() {
        return classesLabel;
    }

    public void setEducationPanel(HtmlPanelGrid educationPanel) {
        this.educationPanel = educationPanel;
    }

    public HtmlPanelGrid getEducationPanel() {
        return educationPanel;
    }

    public void setClassesLOV(RichTable classesLOV) {
        this.classesLOV = classesLOV;
    }

    public RichTable getClassesLOV() {
        return classesLOV;
    }

    public void setSchClassDesc(RichInputText schClassDesc) {
        this.schClassDesc = schClassDesc;
    }

    public RichInputText getSchClassDesc() {
        return schClassDesc;
    }

    public void setSchoolLevels(RichTable schoolLevels) {
        this.schoolLevels = schoolLevels;
    }

    public RichTable getSchoolLevels() {
        return schoolLevels;
    }

    public void setLevelShtDesc(RichInputText levelShtDesc) {
        this.levelShtDesc = levelShtDesc;
    }

    public RichInputText getLevelShtDesc() {
        return levelShtDesc;
    }

    public void setLevelDesc(RichInputText levelDesc) {
        this.levelDesc = levelDesc;
    }

    public RichInputText getLevelDesc() {
        return levelDesc;
    }

    public void setLevelPeriod(RichInputText levelPeriod) {
        this.levelPeriod = levelPeriod;
    }

    public RichInputText getLevelPeriod() {
        return levelPeriod;
    }


    public void setCurrentClass(RichInputText currentClass) {
        this.currentClass = currentClass;
    }

    public RichInputText getCurrentClass() {
        return currentClass;
    }

    public void setClassSchLevel(RichSelectOneChoice classSchLevel) {
        this.classSchLevel = classSchLevel;
    }

    public RichSelectOneChoice getClassSchLevel() {
        return classSchLevel;
    }

    public void setLevelTerms(RichInputText levelTerms) {
        this.levelTerms = levelTerms;
    }

    public RichInputText getLevelTerms() {
        return levelTerms;
    }

    public void setLevelTermDuration(RichInputText levelTermDuration) {
        this.levelTermDuration = levelTermDuration;
    }

    public RichInputText getLevelTermDuration() {
        return levelTermDuration;
    }

    public void setGender(RichSelectOneChoice gender) {
        this.gender = gender;
    }

    public RichSelectOneChoice getGender() {
        return gender;
    }

    public void rateDescListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        String RateDesc = null;
        if(valueChangeEvent.getOldValue()!=valueChangeEvent.getNewValue()){
            if(rateDesc.getValue()==null){
              RateDesc = null;
            }else{
              RateDesc = rateDesc.getValue().toString();
              if(RateDesc.equalsIgnoreCase("Percent")){
                divFactor.setValue("100");
                divFactor.setDisabled(true);
              }else if(RateDesc.equalsIgnoreCase("Per Mille")){
                divFactor.setValue("1000");  
                divFactor.setDisabled(true);
              }else if(RateDesc.equalsIgnoreCase("Amount")){
                divFactor.setValue("1"); 
                divFactor.setDisabled(true);
              }else if(RateDesc.equalsIgnoreCase("Others")){
                divFactor.setValue(null); 
                divFactor.setDisabled(false);
              }
            }
            
           
          
        }
    }

    public void setCloneFCLProduct(RichOutputText cloneFCLProduct) {
        this.cloneFCLProduct = cloneFCLProduct;
    }

    public RichOutputText getCloneFCLProduct() {
        return cloneFCLProduct;
    }

    public void setNewFCLProduct(RichSelectOneChoice newFCLProduct) {
        this.newFCLProduct = newFCLProduct;
    }

    public RichSelectOneChoice getNewFCLProduct() {
        return newFCLProduct;
    }

    public void setClonePanel(HtmlPanelGrid clonePanel) {
        this.clonePanel = clonePanel;
    }

    public HtmlPanelGrid getClonePanel() {
        return clonePanel;
    }

    public void setConfirmPanel(HtmlPanelGrid confirmPanel) {
        this.confirmPanel = confirmPanel;
    }

    public HtmlPanelGrid getConfirmPanel() {
        return confirmPanel;
    }
    
    public String DeletePremiumRate(){
        GlobalCC.showPopup("lmsgroup:confirmDelete");
        return null;
    }   
    
    public String deleteAllPremiumRate() {
        GlobalCC.showPopup("lmsgroup:confirmMultipleDelete");
        return null;
    }
  public String performPremiumMaskDelete() {
    GlobalCC.showPopup("lmsgroup:confirmDelete");
    this.session.setAttribute("ConfirmDelete", "Pmask");
    return null;
  }
    
    public void actionConfirmDeletePremRateRow(DialogEvent dialogEvent) {
        Connection conn = null;
        if (dialogEvent.getOutcome().equals(DialogEvent.Outcome.no)) {
            return;
        } else if (dialogEvent.getOutcome().equals(DialogEvent.Outcome.yes)) {
        try {
            conn = new DBConnector().getDatabaseConn();
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findPremiumRatesIterator");
            RowKeySet set = ratesLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();        
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();
  
                session.setAttribute("gprCode", r.getAttribute("GPR_CODE"));
  
                String authQuery =
                    "BEGIN LMS_SETUPS_PKG.deletePremiumRates(?);END;";
  
  
                CallableStatement cstmt = conn.prepareCall(authQuery);
                cstmt.setBigDecimal(1,
                                    (BigDecimal)session.getAttribute("gprCode"));
  
                cstmt.execute();
  
            }
            conn.close();
            session.setAttribute("gprCode", null);
            ADFUtils.findIterator("findPremiumRatesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(ratesLOV);
  
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        }
        }
          
      }
      public void actionConfirmDeletePremRate(DialogEvent dialogEvent) {
          Connection conn = null;
          CallableStatement cstmt = null;

          if (dialogEvent.getOutcome().equals(DialogEvent.Outcome.no)) {
              return;
          } else if (dialogEvent.getOutcome().equals(DialogEvent.Outcome.yes)) {
              try {
                  //ratesLOV.setFetchSize(1000000);
                  //String deleteQuery = "BEGIN LMS_SETUPS_PKG.deletePremiumRates(?);END;";
                  String deleteQuery =
                      "BEGIN LMS_SETUPS_PKG.deleteAllPremiumRates(?,?,?,?,?,?,?);END;";

                  conn = new DBConnector().getDatabaseConn();
                  cstmt = conn.prepareCall(deleteQuery);
                  cstmt.setBigDecimal(1,
                                      (BigDecimal)session.getAttribute("pmasCode"));
                  cstmt.setBigDecimal(2,
                                      (BigDecimal)session.getAttribute("pcdCode"));
                  cstmt.setBigDecimal(3,
                                      (BigDecimal)session.getAttribute("lcCode"));
                  cstmt.setBigDecimal(4,
                                      (BigDecimal)session.getAttribute("grptCode"));
                  cstmt.setBigDecimal(5,
                                      (BigDecimal)session.getAttribute("gpirCode"));
                  cstmt.setString(6, (String)session.getAttribute("GroupRates"));
                  cstmt.setBigDecimal(7,
                                      (BigDecimal)session.getAttribute("schCode"));
                  cstmt.execute();
                  //          DCBindingContainer bindings =
                  //              (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
                  //          DCIteratorBinding dcIteratorBindings =
                  //              bindings.findIteratorBinding("findPremiumRatesIterator");
                  //          // Get all the rows of a iterator
                  //          Row[] rows = dcIteratorBindings.getAllRowsInRange();
                  //          for (Row row : rows) {
                  //          cstmt = conn.prepareCall(deleteQuery);
                  //            cstmt.setBigDecimal(1, (BigDecimal)row.getAttribute("GPR_CODE"));
                  //            cstmt.execute();
                  //             System.out.println(row.getAttribute("GPR_CODE"));
                  //          }
                  cstmt.close();
                  conn.close();
                  GlobalCC.hidePopup("lmsgroup:confirmMultipleDelete");
                  ADFUtils.findIterator("findPremiumRatesIterator").executeQuery();
                  AdfFacesContext.getCurrentInstance().addPartialTarget(ratesLOV);
              } catch (Exception Ex) {
                  GlobalCC.EXCEPTIONREPORTING(conn, Ex);
              }
          }
      }
  public void actionConfirmDeleteLoadings(DialogEvent dialogEvent) {
      Connection conn = null;
      CallableStatement cstmt = null;

      if (dialogEvent.getOutcome().equals(DialogEvent.Outcome.no)) {
          return;
      } else if (dialogEvent.getOutcome().equals(DialogEvent.Outcome.yes)) {
          try {
              //ratesLOV.setFetchSize(1000000);
              //String deleteQuery = "BEGIN LMS_SETUPS_PKG.deletePremiumRates(?);END;";
              String deleteQuery =
                  "BEGIN LMS_SETUPS_PKG.deleteImportedLoadings(?,?,?,?,?);END;";

              conn = new DBConnector().getDatabaseConn();
              cstmt = conn.prepareCall(deleteQuery);
              cstmt.setBigDecimal(1,
                                  (BigDecimal)session.getAttribute("pctCode"));
              cstmt.setBigDecimal(2,
                                  (BigDecimal)session.getAttribute("pmasCode"));
              cstmt.setBigDecimal(3,
                                  (BigDecimal)session.getAttribute("pcdCode"));
              cstmt.setBigDecimal(4,
                                  (BigDecimal)session.getAttribute("lcCode"));
              cstmt.setBigDecimal(5,
                                  (BigDecimal)session.getAttribute("dtyCode"));
              
              cstmt.execute();
              //          }
              cstmt.close();
              conn.close();
            ADFUtils.findIterator("findImportLoadingRatesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(loadingsLOV);
          } catch (Exception Ex) {
              GlobalCC.EXCEPTIONREPORTING(conn, Ex);
          }
      }
  }
      

    public void setYrsOfService(RichInputText yrsOfService) {
        this.yrsOfService = yrsOfService;
    }

    public RichInputText getYrsOfService() {
        return yrsOfService;
    }

    public void setCausationTable(RichTable causationTable) {
        this.causationTable = causationTable;
    }

    public RichTable getCausationTable() {
        return causationTable;
    }

    public void setCausationDesc(RichInputText causationDesc) {
        this.causationDesc = causationDesc;
    }

    public RichInputText getCausationDesc() {
        return causationDesc;
    }
    
  public String findCausationSelected() {
      DCIteratorBinding dciter = ADFUtils.findIterator("findCausationsIterator");
      RowKeySet set = causationTable.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      
      while (rowKeySetIter.hasNext()) 
      {
          List l = (List) rowKeySetIter.next();
          Key key = (Key)l.get(0);
          dciter.setCurrentRowWithKey(key.toStringFormat(true));
          Row r = dciter.getCurrentRow();

          session.setAttribute("CAUS_CODE", r.getAttribute("causCode"));
          causationDesc.setValue(r.getAttribute("causDesc"));
      }
      AdfFacesContext.getCurrentInstance().addPartialTarget(causationDesc);
      GlobalCC.hidePopup("lmsgroup:p2");
      return null;
  }
  
  public String CancelCausation(){
    GlobalCC.hidePopup("lmsgroup:p2");
    return null;
  }

    public void setYrsOfServiceTo(RichInputText yrsOfServiceTo) {
        this.yrsOfServiceTo = yrsOfServiceTo;
    }

    public RichInputText getYrsOfServiceTo() {
        return yrsOfServiceTo;
    }

    public void setApplAtCause(RichSelectOneChoice applAtCause) {
        this.applAtCause = applAtCause;
    }

    public RichSelectOneChoice getApplAtCause() {
        return applAtCause;
    }

    public void ApplicableAtCauseListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if(valueChangeEvent.getOldValue()!=valueChangeEvent.getNewValue()){
          
            if(applAtCause.getValue()==null){
              causationButton.setDisabled(true);
            }else if(applAtCause.getValue().toString().equalsIgnoreCase("Y")){
              causationButton.setDisabled(false);
              session.setAttribute("CAUS_CODE", null);
              causationDesc.setValue(null);
            }else{
              causationButton.setDisabled(true);
            }
          AdfFacesContext.getCurrentInstance().addPartialTarget(causationButton);
          AdfFacesContext.getCurrentInstance().addPartialTarget(causationDesc);
        }
    }
  public void actionConfirmDelete(DialogEvent dialogEvent) {
      String confirmDelete = (String)this.session.getAttribute("ConfirmDelete");
      if (dialogEvent.getOutcome().equals(DialogEvent.Outcome.no)) {
          return;
      } else if (dialogEvent.getOutcome().equals(DialogEvent.Outcome.yes)) {
      if (confirmDelete.compareTo("Pmask") == 0)
        DeletePremiumMask();
      else if (confirmDelete.compareTo("Sprt") == 0) {
        DeleteSpecialRate();
      }
      else if (confirmDelete.compareTo("LComRate") == 0) {
        DeleteLifeCommissionRates();
      }
      else if (confirmDelete.compareTo("PenComRate") == 0) {
        DeletePensionCommRates();
      }
      else if (confirmDelete.compareTo("AnnComRate") == 0) {
        DeleteAnnCommRates();
      }
      else if (confirmDelete.compareTo("fclFact") == 0) {
        DeleteFCLFactor();
      }
      this.session.setAttribute("ConfirmDelete", null);
      GlobalCC.hidePopup("lmsgroup:confirmDelete");
      }
    }

    public String performLifeCommissionRatesDelete()
    {
      GlobalCC.showPopup("lmsgroup:confirmDelete");
      this.session.setAttribute("ConfirmDelete", "LComRate");
      return null;
    }
  public String performSpecialRateDelete() {
      GlobalCC.showPopup("lmsgroup:confirmDelete");
      this.session.setAttribute("ConfirmDelete", "Sprt");
      return null;
    }

    public String performPensionCommRatesDelete()
    {
      GlobalCC.showPopup("lmsgroup:confirmDelete");
      this.session.setAttribute("ConfirmDelete", "PenComRate");
      return null;
    }
  public String performFCLFactorDelete() {
    GlobalCC.showPopup("lmsgroup:confirmDelete");
    this.session.setAttribute("ConfirmDelete", "fclFact");
    return null;
  }
  public String performAnnCommRatesDelete() {
    GlobalCC.showPopup("lmsgroup:confirmDelete");
    this.session.setAttribute("ConfirmDelete", "AnnComRate");
    return null;
  }

    public void setCausationButton(RichCommandButton causationButton) {
        this.causationButton = causationButton;
    }

    public RichCommandButton getCausationButton() {
        return causationButton;
    }

    public void setTxApplOn(RichSelectOneChoice txApplOn) {
        this.txApplOn = txApplOn;
    }

    public RichSelectOneChoice getTxApplOn() {
        return txApplOn;
    }

    public void setPmRateType(RichSelectOneChoice pmRateType) {
        this.pmRateType = pmRateType;
    }

    public RichSelectOneChoice getPmRateType() {
        return pmRateType;
    }

    public void setLoadingsLOV(RichTable loadingsLOV) {
        this.loadingsLOV = loadingsLOV;
    }

    public RichTable getLoadingsLOV() {
        return loadingsLOV;
    }
  public String getLoadingDetailsButAction() {
      // Add event code here...
      try {
          DCIteratorBinding dciter =
              ADFUtils.findIterator("findImportLoadingTemplateIterator");
          RowKeySet set = prodloadingLOV.getSelectedRowKeys();
          Iterator rowKeySetIter = set.iterator();

          //System.out.println(1);
          while (rowKeySetIter.hasNext()) {
              List l = (List)rowKeySetIter.next();
              Key key = (Key)l.get(0);
              dciter.setCurrentRowWithKey(key.toStringFormat(true));
              Row r = dciter.getCurrentRow();
              session.setAttribute("pctl_code", r.getAttribute("PCTL_CODE"));
              loadingName.setValue(r.getAttribute("PCTL_NAME"));
             AdfFacesContext.getCurrentInstance().addPartialTarget(loadingName); 
            ADFUtils.findIterator("findImportLoadingRatesIterator").executeQuery();
           AdfFacesContext.getCurrentInstance().addPartialTarget(loadingsLOV);
          }
      } catch (Exception e) {
          GlobalCC.EXCEPTIONREPORTING(null, e);
          e.printStackTrace();
      }
      return null;
  }

    public void setLoadingName(RichInputText loadingName) {
        this.loadingName = loadingName;
    }

    public RichInputText getLoadingName() {
        return loadingName;
    }

    public void setProdloadingLOV(RichTable prodloadingLOV) {
        this.prodloadingLOV = prodloadingLOV;
    }

    public RichTable getProdloadingLOV() {
        return prodloadingLOV;
    }

    public void getOccupationCode(SelectionEvent selectionEvent) {
        // Add event code here...
    }

    public String deleteLoadings() {
        // Add event code here...
        return null;
    }


    public void setGrpSingleRate(RichSelectOneChoice grpSingleRate) {
        this.grpSingleRate = grpSingleRate;
    }

    public RichSelectOneChoice getGrpSingleRate() {
        return grpSingleRate;
    }

    public void grpSingleRateListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if(valueChangeEvent.getOldValue()!=valueChangeEvent.getNewValue()){
            if(grpSingleRate.getValue()!=null){
              session.setAttribute("grp_single_rate", grpSingleRate.getValue().toString());
            }
        }
      ADFUtils.findIterator("findImportLoadingRatesIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(loadingsLOV);
    }
  public void grpSingleRatePremListener(ValueChangeEvent valueChangeEvent) {
      // Add event code here...
      if(valueChangeEvent.getOldValue()!=valueChangeEvent.getNewValue()){
          if(grpSingleRate.getValue()!=null){
            session.setAttribute("grp_single_rate", grpSingleRate.getValue().toString());
            if(grpSingleRate.getValue().equals("G")){
              premRatesLab.setValue("Premium Rates For Policies above Group Minimum");  
              session.setAttribute("GroupRates","G");
              
            }else if(grpSingleRate.getValue().equals("S")){
              premRatesLab.setValue("Premium Rates For Policies below Group Minimum");  
              session.setAttribute("GroupRates","S");
            }
          }
      }
    AdfFacesContext.getCurrentInstance().addPartialTarget(premRatesLab);
    
    ADFUtils.findIterator("findPremiumRatesIterator").executeQuery();
    AdfFacesContext.getCurrentInstance().addPartialTarget(ratesLOV);
  }

    public void setPremRatesLab(RichOutputLabel premRatesLab) {
        this.premRatesLab = premRatesLab;
    }

    public RichOutputLabel getPremRatesLab() {
        return premRatesLab;
    }

    public void setCratCode(RichInputNumberSpinbox cratCode) {
        this.cratCode = cratCode;
    }

    public RichInputNumberSpinbox getCratCode() {
        return cratCode;
    }

    public void setText(RichInputText text) {
        this.text = text;
    }

    public RichInputText getText() {
        return text;
    }
  public String ShowPremiumRatesForExport() {

    try {
      // Add event code here...
      ADFUtils.findIterator("findPremiumRatesIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(ratesExportLOV);

      GlobalCC.showPopup("lmsgroup:importRates");

    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }

    return null;
  }

  public void setRatesExportLOV(RichTable ratesExportLOV) {
    this.ratesExportLOV = ratesExportLOV;
  }

  public RichTable getRatesExportLOV() {
    return ratesExportLOV;
  }

    public void setCoverTypeShtDesc(RichInputText coverTypeShtDesc) {
        this.coverTypeShtDesc = coverTypeShtDesc;
    }

    public RichInputText getCoverTypeShtDesc() {
        return coverTypeShtDesc;
    }

    public void setCoverTypeDesc(RichInputText coverTypeDesc) {
        this.coverTypeDesc = coverTypeDesc;
    }

    public RichInputText getCoverTypeDesc() {
        return coverTypeDesc;
    }

    public void setCoverTypeTable(RichTable coverTypeTable) {
        this.coverTypeTable = coverTypeTable;
    }

    public RichTable getCoverTypeTable() {
        return coverTypeTable;
    }

    public void setParamProdSpecific(RichSelectOneChoice paramProdSpecific) {
        this.paramProdSpecific = paramProdSpecific;
    }

    public RichSelectOneChoice getParamProdSpecific() {
        return paramProdSpecific;
    }
    
    public void parametersProductsListener(SelectionEvent selectionEvent) {
        if (selectionEvent.getAddedSet() != selectionEvent.getRemovedSet()) {
            RowKeySet rowKeySet = parameterProductsTree.getSelectedRowKeys();
            Object key2 = rowKeySet.iterator().next();
            parameterProductsTree.setRowKey(key2);
            JUCtrlValueBinding nodeBinding =
                (JUCtrlValueBinding)parameterProductsTree.getRowData();
                session.setAttribute("ProductCode",
                                     nodeBinding.getAttribute("PROD_CODE"));
                                 
            ADFUtils.findIterator("findProductParametersIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(productParamTable);
        }
    }

    public void setParameterProductsTree(RichTree parameterProductsTree) {
        this.parameterProductsTree = parameterProductsTree;
    }

    public RichTree getParameterProductsTree() {
        return parameterProductsTree;
    }

    public void setProductParamTable(RichTable productParamTable) {
        this.productParamTable = productParamTable;
    }

    public RichTable getProductParamTable() {
        return productParamTable;
    }

    public void setProdParameterName(RichOutputText prodParameterName) {
        this.prodParameterName = prodParameterName;
    }

    public RichOutputText getProdParameterName() {
        return prodParameterName;
    }

    public void setProdParameterValue(RichInputText prodParameterValue) {
        this.prodParameterValue = prodParameterValue;
    }

    public RichInputText getProdParameterValue() {
        return prodParameterValue;
    }

    public void parameterListener(SelectionEvent selectionEvent) {
        // Add event code here...
        DCIteratorBinding dciter = ADFUtils.findIterator("findParametersIterator");
        RowKeySet set =parameterLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        
        //System.out.println(1);
        while (rowKeySetIter.hasNext()) 
        {
            List l = (List) rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            
            session.setAttribute("parameterCode", r.getAttribute("PARAM_CODE"));

            ADFUtils.findIterator("findProductParametersIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(productParamTable);
        }
    }
    
    public String EditProductParameter(){
      
      DCIteratorBinding dciter = ADFUtils.findIterator("findProductParametersIterator");
      RowKeySet set =productParamTable.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      
      //System.out.println(1);
      while (rowKeySetIter.hasNext()) 
      {
          List l = (List) rowKeySetIter.next();
          Key key = (Key)l.get(0);
          dciter.setCurrentRowWithKey(key.toStringFormat(true));
          Row r = dciter.getCurrentRow();
        
          session.setAttribute("lppCode", r.getAttribute("LPP_CODE"));
          prodParameterName.setValue(r.getAttribute("LPP_NAME"));
          prodParameterValue.setValue(r.getAttribute("LPP_VALUE"));

          // Render Popup
          GlobalCC.showPopup("lmsgroup:prodParamPopup");

      }  
      return null;
    }
    
    public String SaveProductParameter() {
        Connection conn=null;
        try 
        {
            
            if((BigDecimal)session.getAttribute("parameterCode")==null){
                String Message = "Select A Parameter";
                FacesContext.getCurrentInstance().addMessage(null, 
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                              Message, 
                                                                              Message));
                return null;
            }
            
            if((BigDecimal)session.getAttribute("lppCode")==null){
                String Message = "Select A Product Parameter";
                FacesContext.getCurrentInstance().addMessage(null, 
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                              Message, 
                                                                              Message));
                return null;
            }
            
            if(prodParameterValue.getValue()==null){
                String Message = "Enter A Parameter Value";
                FacesContext.getCurrentInstance().addMessage(null, 
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                              Message, 
                                                                              Message));
                return null;
            }
           
            
            String authQuery="BEGIN LMS_SETUPS_PKG.updateprodparamter(?,?);END;";
            conn=new DBConnector().getDatabaseConn();
            
            CallableStatement cstmt=conn.prepareCall(authQuery);    
            cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("lppCode"));
            if(prodParameterValue.getValue()==null){
                cstmt.setString(2, null);
            }else{
                cstmt.setString(2, prodParameterValue.getValue().toString());  
            }
            
            cstmt.execute();
            conn.close();
            
            String Message = "Product Parameter Saved succesfully.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
            
            session.setAttribute("lppCode", null);
            ADFUtils.findIterator("findProductParametersIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(productParamTable);
            GlobalCC.hidePopup("lmsgroup:prodParamPopup");
          
        }
        catch(Exception ex)
        {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
        }
      return null;
    }

    public void setExciseDuty(RichSelectOneChoice exciseDuty) {
        this.exciseDuty = exciseDuty;
    }

    public RichSelectOneChoice getExciseDuty() {
        return exciseDuty;
    }
    
    public void setCurrencyLOV(RichTable currencyLOV) {
        this.currencyLOV = currencyLOV;
    }

    public RichTable getCurrencyLOV() {
        return currencyLOV;
    }
    public void selectCurrency(SelectionEvent selectionEvent) {
        // Add event code here...
        Object key2 = currencyLOV.getSelectedRowData();
        if (key2 == null) {
            GlobalCC.errorValueNotEntered("No Record Selected");
        }
        JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
        if (r == null) {
            GlobalCC.errorValueNotEntered("No Record Selected");
        }
        session.setAttribute("currCode",r.getAttribute("cur_code"));
        
      ADFUtils.findIterator("findMedicalTestsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(medTestsLOV);
    }
    
    public void selectMedGroupCurrency(SelectionEvent selectionEvent) {
        // Add event code here...
        Object key2 = currencyLOV.getSelectedRowData();
        if (key2 == null) {
            GlobalCC.errorValueNotEntered("No Record Selected");
        }
        JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
        if (r == null) {
            GlobalCC.errorValueNotEntered("No Record Selected");
        }
        session.setAttribute("currCode",r.getAttribute("cur_code"));
        session.setAttribute("mtgCode", null);        
        ADFUtils.findIterator("findMedTestGroupsIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(medGrpsLOV);
        
        ADFUtils.findIterator("findMedTestGroupTestsIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(medGrpItemsLOV);
        
      ADFUtils.findIterator("findMedicalTestsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(testsLOV);
     }
    
    public void selectMedGrpAnbs(SelectionEvent selectionEvent) {
        // Add event code here...
        Object key2 = currencyLOV.getSelectedRowData();
        if (key2 == null) {
            GlobalCC.errorValueNotEntered("No Record Selected");
        }
        JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
        if (r == null) {
            GlobalCC.errorValueNotEntered("No Record Selected");
        }
        session.setAttribute("currCode",r.getAttribute("cur_code"));  
        session.setAttribute("manbCode", null);
        ADFUtils.findIterator("findMedicalANBIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(anbLOV);
        
        ADFUtils.findIterator("findMedRequirementsIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(requirementLOV);
    }
    
    public void getMedicalProduct(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        try{
        if(valueChangeEvent.getNewValue()!=valueChangeEvent.getOldValue()){
            if(medProduct.getValue()!=null){
              Row row =
              ADFUtils.findIterator("findProductsIterator").getRowAtRangeIndex(new Integer(valueChangeEvent.getNewValue().toString()));              
              session.setAttribute("ProductCode", row.getAttribute("prodCode"));              //System.out.println("Product Code="+row.getAttribute("prodCode"));
              ADFUtils.findIterator("findMedicalANBIterator").executeQuery();
              AdfFacesContext.getCurrentInstance().addPartialTarget(anbLOV);  
            }
        }
        }catch(Exception e ){
          
        }
    }

    public void setMedProduct(RichSelectOneChoice medProduct) {
        this.medProduct = medProduct;
    }

    public RichSelectOneChoice getMedProduct() {
        return medProduct;
    }

}
