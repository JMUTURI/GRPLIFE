package LMSG.view.Policy;


import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.text.SimpleDateFormat;

import java.util.Date;
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

import oracle.adf.view.rich.component.rich.input.RichSelectBooleanRadio;

import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.layout.RichPanelBox;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
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
import LMSG.view.Base.LOVCC;

import LMSG.view.Navigation.Links;
import LMSG.view.connect.DBConnector;

import LMSG.view.BPM.workflowProcessing;

import javax.faces.event.ValueChangeEvent;


public class policyEndorsements extends LOVCC {
  private RichTable productLOV;
  private RichInputText productDesc;
  private RichInputText policiesDesc;
  private RichTable policiesLOV;
  public static RichInputDate Today = new RichInputDate();
  private RichInputDate polEffDate;
  private RichSelectBooleanRadio addMemSch;
  private RichSelectBooleanRadio refundPrem;
  private RichSelectBooleanRadio totalCancel;
  private RichSelectBooleanRadio totalCancellWithRefund;
  private RichSelectBooleanRadio partialCancel;
  private RichSelectBooleanRadio endorseCover;
  private RichSelectBooleanRadio lgInitialSch;
  private RichSelectBooleanRadio renewal;
  private RichSelectBooleanRadio schAdjustment;
  private RichSelectBooleanRadio addCoverType;
  private RichSelectBooleanRadio removeCoverType;
  private RichSelectBooleanRadio changePolEffDate;
  private RichSelectBooleanRadio freeCoverSch;
  private RichSelectBooleanRadio memberReinstatement;
  private RichInputText endorseDesc;
  private RichInputDate transEffDate;
  private RichTable fclLOV;
  private RichInputText fclDesc;
  private RichInputText schMonth;
  private RichInputText schYear;
  private RichInputDate newCoverTo;
  private RichPanelBox extOfCover;
  private RichPanelBox freeAdj;
  private RichPanelBox scheduleAdjust;
  private RichCommandButton endorseButton;
  private RichCommandButton policyButton;
  private RichCommandButton productButton;
  private RichInputDate oldCoverTo;
  private RichInputDate oldCoverFrom;
  private RichTable transLOV;
  private RichPanelBox transactions;
    private RichSelectBooleanRadio changeCategory;
    private RichTable usersLOV;
    private RichTable resultsLOV;
    private RichPanelBox changeOfPolEffectiveDate;
    private RichInputText oldEffectiveDate;
    private RichInputDate newEffectiveDate;
    private RichInputDate newPolEffectiveDate;
    private RichSelectBooleanRadio contraTrans;
    private RichSelectBooleanRadio premMask;
    private RichSelectBooleanRadio ageTrans;
    private RichSelectBooleanRadio coinPropTrans;
    private RichOutputLabel contraLabel;
    private HtmlPanelGrid contraPanel;
    private RichInputText contraDesc;
    private RichTable contraTable;
    private RichOutputLabel inceptionLabel;
    private RichSelectOneChoice inceptionSelection;
    private RichSelectOneChoice pastPeriodDrop;
    private RichOutputLabel prevTransLabel;
    private HtmlPanelGrid prevTransPanel;
    private RichInputText prevTransDesc;
    private RichTable prevTransTable;
    private RichSelectBooleanRadio chngeContriTrans;
    private RichSelectBooleanRadio chngeLifeFactor;
    private RichSelectBooleanRadio chngeLoanRepayment;
    private RichSelectBooleanRadio coverReduction;
    private RichSelectBooleanRadio loanTopup;
    private RichSelectBooleanRadio nonPremRevision;


    public policyEndorsements() {
  }
    
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
  public String SetDate(){
    Date now = new Date();
    Today.setValue(now);
    
    return null;
  }
  public String findProductSelected() {
    DCIteratorBinding dciter = ADFUtils.findIterator("findProductsIterator");
    RowKeySet set =productLOV.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();
    
    //System.out.println(1);
    while (rowKeySetIter.hasNext()) 
    {
        List l = (List) rowKeySetIter.next();
        Key key = (Key)l.get(0);
        dciter.setCurrentRowWithKey(key.toStringFormat(true));
        Row r = dciter.getCurrentRow();
        
        productDesc.setValue(r.getAttribute("prodDesc"));
        session.setAttribute("ProductCode", r.getAttribute("prodCode"));
        session.setAttribute("productType", r.getAttribute("prodType"));
        session.setAttribute("ProductCode", r.getAttribute("prodCode"));
        
        session.setAttribute("endorsementCode", null);
        policiesDesc.setValue(null);
        session.setAttribute("policyCode", null);
        session.setAttribute("prpCode", null);
        ADFUtils.findIterator("FindPoliciesIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(policiesLOV);
     
    }

    return null;
  }
  
  public String findPoliciesSelected() {
    DCIteratorBinding dciter = ADFUtils.findIterator("FindPoliciesIterator");
    RowKeySet set =policiesLOV.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();
    
    //System.out.println(1);
    while (rowKeySetIter.hasNext()) 
    {
        List l = (List) rowKeySetIter.next();
        Key key = (Key)l.get(0);
        dciter.setCurrentRowWithKey(key.toStringFormat(true));
        Row r = dciter.getCurrentRow();
        policiesDesc.setValue(r.getAttribute("POL_POLICY_NO"));
        //QuotDAO.endrCode=(BigDecimal)r.getAttribute("LTR_ENDR_CODE");
        //PolicyValues.endorsementCode = (BigDecimal)r.getAttribute("LTR_ENDR_CODE");
        polEffDate.setValue(r.getAttribute("POL_EFFECTIVE_DATE"));
        //LOVCC.policyCode=(BigDecimal)r.getAttribute("POL_CODE");
        //LOVCC.policyCode = (BigDecimal)r.getAttribute("POL_CODE");
        session.setAttribute("policyCode", r.getAttribute("POL_CODE"));
        session.setAttribute("policyCode", r.getAttribute("POL_CODE"));
        //LOVCC.PrpCode=(BigDecimal)r.getAttribute("prp_code"); //to be removed
        session.setAttribute("prpCode",  r.getAttribute("prp_code")); //LOVCC.prpCode=(BigDecimal)r.getAttribute("prp_code");
        //LOVCC.policyNumber = (String)r.getAttribute("POL_POLICY_NO");
        session.setAttribute("policyNumber", r.getAttribute("POL_POLICY_NO"));
        session.setAttribute("ClientCode", r.getAttribute("prp_clnt_code"));
      
        oldCoverTo.setValue(r.getAttribute("POL_COVER_TO"));
        oldCoverFrom.setValue(r.getAttribute("POL_COVER_FROM"));
        oldEffectiveDate.setValue(r.getAttribute("POL_EFFECTIVE_DATE"));
        //LOVCC.CoverFromDate = (Date)r.getAttribute("POL_COVER_FROM");
        //LOVCC.CoverToDate =  (Date)r.getAttribute("POL_COVER_TO");;
     
    }

    return null;
  }
  
  public String findFCLEndorsementSelected() {
    DCIteratorBinding dciter = ADFUtils.findIterator("FindFreeAdjLimitsIterator");
    RowKeySet set =fclLOV.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();
    
    //System.out.println(1);
    while (rowKeySetIter.hasNext()) 
    {
        List l = (List) rowKeySetIter.next();
        Key key = (Key)l.get(0);
        dciter.setCurrentRowWithKey(key.toStringFormat(true));
        Row r = dciter.getCurrentRow();
       fclDesc.setValue(r.getAttribute("FCL_ENDR_NO"));
            LOVCC.FCLEndorsNo = (BigDecimal)r.getAttribute("FCL_ENDR_CODE");
     
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
       //LOVCC.endorsementCode = (BigDecimal)r.getAttribute("PT_ENDR_CODE");
        //LOVCC.endorsementCode = (BigDecimal)r.getAttribute("PT_ENDR_CODE");
        session.setAttribute("endorsementCode", r.getAttribute("PT_ENDR_CODE"));
       
        //LOVCC.transactionNumber = (BigDecimal)r.getAttribute("PT_ENDR_LTR_TRANS_NO");
        session.setAttribute("transactionNumber", r.getAttribute("PT_ENDR_LTR_TRANS_NO"));
        
      
     try{
        GlobalCC.RedirectPage("/g_undwrt.jspx");   
      }      
    catch(Exception e) {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
     
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

      try{
        
         DBConnector myConn=new DBConnector();
        Connection conn=myConn.getDatabaseConn();

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
          
        String Message = "Endorsement Deleted";
        FacesContext.getCurrentInstance().addMessage(null, 
                                                     new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                      Message, 
                                                                      Message));
        
        CancelEndorsement();
       
          conn.close();        
      }      
    catch(Exception e) {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
     
    }

    return null;
  }
  
  public String findOldTransSelected() {
    DCIteratorBinding dciter = 
    ADFUtils.findIterator("FindOldTransactionsIterator");
    RowKeySet set =contraTable.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();
    
    //System.out.println(1);
    while (rowKeySetIter.hasNext()) 
    {
        List l = (List) rowKeySetIter.next();
        Key key = (Key)l.get(0);
        dciter.setCurrentRowWithKey(key.toStringFormat(true));
        Row r = dciter.getCurrentRow();
        contraDesc.setValue(r.getAttribute("TRANS"));
     
        session.setAttribute("oldEndrCode", r.getAttribute("ENDR_CODE"));
        session.setAttribute("oldTransNo", r.getAttribute("ENDR_LTR_TRANS_NO"));
    }

    return null;
  }
  
  public void inceptionListener(ValueChangeEvent valueChangeEvent) {
      // Add event code here...
      if(valueChangeEvent.getOldValue()!=valueChangeEvent.getNewValue()){
          if(inceptionSelection.getValue()==null){
              transEffDate.setDisabled(false);
              transEffDate.setValue(null);
          }else if(inceptionSelection.getValue().toString().equalsIgnoreCase("Y")){
              transEffDate.setDisabled(true);
              transEffDate.setValue(polEffDate.getValue());
          }else{
              transEffDate.setDisabled(false);
              transEffDate.setValue(null);
          }
      }
          
  }
  
  public String EndorsementSelected(){
    if(addMemSch.isSelected()){
      //LOVCC.Endorsement ="AP";
        session.setAttribute("Endorsement", "AP");
      //LOVCC.ProcessShtDesc = "UWAP";
      session.setAttribute("ProcessShtDesc", "UWAP");
      //LOVCC.ProcessAreaShtDesc = "EXPN";
      //LOVCC.ProcessSubAShtDesc = "NBMR";
      endorseDesc.setValue(session.getAttribute("Endorsement"));
      contraPanel.setRendered(false);
      contraLabel.setRendered(false);
      inceptionLabel.setRendered(false);
      inceptionSelection.setRendered(false);
    }else if(refundPrem.isSelected()){
      //LOVCC.Endorsement = "RP";
      session.setAttribute("Endorsement", "RP");
      //LOVCC.ProcessShtDesc = "UWRP";
      session.setAttribute("ProcessShtDesc", "UWRP");
      endorseDesc.setValue(session.getAttribute("Endorsement"));
      contraPanel.setRendered(false);
      contraLabel.setRendered(false);
      inceptionLabel.setRendered(false);
      inceptionSelection.setRendered(false);
    }else if(totalCancel.isSelected()){
      //LOVCC.Endorsement = "TC";
      session.setAttribute("Endorsement", "TC");
       //LOVCC.ProcessShtDesc = "UWTC";
       session.setAttribute("ProcessShtDesc", "UWTC");
      endorseDesc.setValue(session.getAttribute("Endorsement"));
      contraPanel.setRendered(false);
      contraLabel.setRendered(false);
      inceptionLabel.setRendered(false);
      inceptionSelection.setRendered(false);
    }else if(totalCancellWithRefund.isSelected()){
      //LOVCC.Endorsement = "TP";
      session.setAttribute("Endorsement", "TP");
      //LOVCC.ProcessShtDesc = "UWTP";
      session.setAttribute("ProcessShtDesc", "UWTP");
      endorseDesc.setValue(session.getAttribute("Endorsement"));
      contraPanel.setRendered(false);
      contraLabel.setRendered(false);
      inceptionLabel.setRendered(false);
      inceptionSelection.setRendered(false);
    }else if(partialCancel.isSelected()){
      //LOVCC.Endorsement = "PC";
      session.setAttribute("Endorsement", "PC");
        //LOVCC.ProcessShtDesc = "UWPC";
        session.setAttribute("ProcessShtDesc", "UWPC");
      endorseDesc.setValue(session.getAttribute("Endorsement"));
      contraPanel.setRendered(false);
      contraLabel.setRendered(false);
      inceptionLabel.setRendered(false);
      inceptionSelection.setRendered(false);
    }else if(endorseCover.isSelected()){
      //LOVCC.Endorsement = "EC";
      session.setAttribute("Endorsement", "EC");
      //LOVCC.ProcessShtDesc = "UWEC";
      session.setAttribute("ProcessShtDesc", "UWEC");
      endorseDesc.setValue(session.getAttribute("Endorsement"));
      contraPanel.setRendered(false);
      contraLabel.setRendered(false);
      inceptionLabel.setRendered(false);
      inceptionSelection.setRendered(false);
    } else if(coverReduction.isSelected()){
      //LOVCC.Endorsement = "EC";
      session.setAttribute("Endorsement", "RCP");
      //LOVCC.ProcessShtDesc = "UWEC";
      session.setAttribute("ProcessShtDesc", "UWRCP");
      endorseDesc.setValue(session.getAttribute("Endorsement"));
      contraPanel.setRendered(false);
      contraLabel.setRendered(false);
      inceptionLabel.setRendered(false);
      inceptionSelection.setRendered(false);
    }else if(lgInitialSch.isSelected()){
      //LOVCC.Endorsement = "CT";
      session.setAttribute("Endorsement", "CT");
      //LOVCC.ProcessShtDesc = "UWCT";
      session.setAttribute("ProcessShtDesc", "UWCT");
      endorseDesc.setValue(session.getAttribute("Endorsement"));
      contraPanel.setRendered(false);
      contraLabel.setRendered(false);
      inceptionLabel.setRendered(false);
      inceptionSelection.setRendered(false);
    }else if(renewal.isSelected()){
      //LOVCC.Endorsement = "RN";
      session.setAttribute("Endorsement", "RN");
      //LOVCC.ProcessShtDesc = "UWRN";
      session.setAttribute("ProcessShtDesc", "UWRN");
      endorseDesc.setValue(session.getAttribute("Endorsement"));
      contraPanel.setRendered(false);
      contraLabel.setRendered(false);
      inceptionLabel.setRendered(false);
      inceptionSelection.setRendered(false);
    }else if(schAdjustment.isSelected()){
      //LOVCC.Endorsement = "SA";
      session.setAttribute("Endorsement", "SA");
      //LOVCC.ProcessShtDesc = "UWSA";
      session.setAttribute("ProcessShtDesc", "UWSA");
      endorseDesc.setValue(session.getAttribute("Endorsement"));
      contraPanel.setRendered(false);
      contraLabel.setRendered(false);
      inceptionLabel.setRendered(false);
      inceptionSelection.setRendered(false);
    }else if(addCoverType.isSelected()){
      //LOVCC.Endorsement = "AC";
      session.setAttribute("Endorsement", "AC");
      //LOVCC.ProcessShtDesc = "UWAC";
      session.setAttribute("ProcessShtDesc", "UWAC");
      endorseDesc.setValue(session.getAttribute("Endorsement"));
      contraPanel.setRendered(false);
      contraLabel.setRendered(false);
      inceptionLabel.setRendered(false);
      inceptionSelection.setRendered(false);
    }else if(removeCoverType.isSelected()){
      //LOVCC.Endorsement = "RC";
      session.setAttribute("Endorsement", "RC");
      //LOVCC.ProcessShtDesc = "UWRC";
      session.setAttribute("ProcessShtDesc", "UWRC");
      endorseDesc.setValue(session.getAttribute("Endorsement"));
      contraPanel.setRendered(false);
      contraLabel.setRendered(false);
      inceptionLabel.setRendered(false);
      inceptionSelection.setRendered(false);
    }else if(changePolEffDate.isSelected()){
      //LOVCC.Endorsement = "CE";
      session.setAttribute("Endorsement", "CE");
      //LOVCC.ProcessShtDesc = "UWCE";
      session.setAttribute("ProcessShtDesc", "UWCE");
      endorseDesc.setValue(session.getAttribute("Endorsement"));
      contraPanel.setRendered(false);
      contraLabel.setRendered(false);
      inceptionLabel.setRendered(false);
      inceptionSelection.setRendered(false);
    }else if(freeCoverSch.isSelected()){
      //LOVCC.Endorsement = "FCL";
      session.setAttribute("Endorsement", "FCL");
      //LOVCC.ProcessShtDesc = "UWFCL";
      session.setAttribute("ProcessShtDesc", "UWFCL");
      endorseDesc.setValue(session.getAttribute("Endorsement"));
      contraPanel.setRendered(false);
      contraLabel.setRendered(false);
      inceptionLabel.setRendered(false);
      inceptionSelection.setRendered(false);
    }else if(memberReinstatement.isSelected()){
      //LOVCC.Endorsement = "MR";
      session.setAttribute("Endorsement", "MR");
      //LOVCC.ProcessShtDesc = "UWMR";
      session.setAttribute("ProcessShtDesc", "UWMR");
      endorseDesc.setValue(session.getAttribute("Endorsement"));
      contraPanel.setRendered(false);
      contraLabel.setRendered(false);
      inceptionLabel.setRendered(false);
      inceptionSelection.setRendered(false);
    }else if (changeCategory.isSelected()) {
        //LOVCC.Endorsement = "CG";
        session.setAttribute("Endorsement", "CG");
        //LOVCC.ProcessShtDesc = "UWCG";
        session.setAttribute("ProcessShtDesc", "UWCG");
        contraPanel.setRendered(false);
        contraLabel.setRendered(false);
        inceptionLabel.setRendered(false);
        inceptionSelection.setRendered(false);
        endorseDesc.setValue(session.getAttribute("Endorsement"));
    }else if(contraTrans.isSelected()){
        //LOVCC.Endorsement = "CO";
        session.setAttribute("Endorsement", "CO");
        //LOVCC.ProcessShtDesc = "UWCO";
        session.setAttribute("ProcessShtDesc", "UWCO");
        endorseDesc.setValue(session.getAttribute("Endorsement"));
        contraPanel.setRendered(true);
        contraLabel.setRendered(true);
        inceptionLabel.setRendered(false);
        inceptionSelection.setRendered(false);
    }else if (premMask.isSelected()) {
        //LOVCC.Endorsement = "CG";
        session.setAttribute("Endorsement", "CU");
        //LOVCC.ProcessShtDesc = "UWCG";
        session.setAttribute("ProcessShtDesc", "UWCU");
        endorseDesc.setValue(session.getAttribute("Endorsement"));
        contraPanel.setRendered(false);
        contraLabel.setRendered(false);
        inceptionLabel.setRendered(true);
        inceptionSelection.setRendered(true);
    }else if (ageTrans.isSelected()) {
        //LOVCC.Endorsement = "CG";
        session.setAttribute("Endorsement", "CB");
        //LOVCC.ProcessShtDesc = "UWCG";
        session.setAttribute("ProcessShtDesc", "UWCB");
        endorseDesc.setValue(session.getAttribute("Endorsement"));
        contraPanel.setRendered(false);
        contraLabel.setRendered(false);
        inceptionLabel.setRendered(false);
        inceptionSelection.setRendered(false);
    }else if(chngeContriTrans.isSelected()){
        //LOVCC.Endorsement = "CG";
        session.setAttribute("Endorsement", "CC");
        //LOVCC.ProcessShtDesc = "UWCG";
        session.setAttribute("ProcessShtDesc", "UWCC");
        endorseDesc.setValue(session.getAttribute("Endorsement"));
        contraPanel.setRendered(false);
        contraLabel.setRendered(false);
        inceptionLabel.setRendered(false);
        inceptionSelection.setRendered(false);
    }else if(coinPropTrans.isSelected()){
        //LOVCC.Endorsement = "CG";
        session.setAttribute("Endorsement", "CCP");
        //LOVCC.ProcessShtDesc = "UWCG";
        session.setAttribute("ProcessShtDesc", "UWCCP");
        endorseDesc.setValue(session.getAttribute("Endorsement"));
        contraPanel.setRendered(false);
        contraLabel.setRendered(false);
        inceptionLabel.setRendered(false);
        inceptionSelection.setRendered(false);
    }else if(chngeLifeFactor.isSelected()){
      //LOVCC.Endorsement = "CL";
      session.setAttribute("Endorsement", "CL");
      //LOVCC.ProcessShtDesc = "UWCL";
      session.setAttribute("ProcessShtDesc", "UWCL");
      endorseDesc.setValue(session.getAttribute("Endorsement"));
      contraPanel.setRendered(false);
      contraLabel.setRendered(false);
      inceptionLabel.setRendered(false);
      inceptionSelection.setRendered(false);
    }else if(chngeLoanRepayment.isSelected()){
      session.setAttribute("Endorsement", "CLR");

      session.setAttribute("ProcessShtDesc", "UWCLR");
      endorseDesc.setValue(session.getAttribute("Endorsement"));
      contraPanel.setRendered(false);
      contraLabel.setRendered(false);
      inceptionLabel.setRendered(false);
      inceptionSelection.setRendered(false);
    }
    
    
    
    //Determine if it is Past Period.
    if(pastPeriodDrop.getValue()==null){
        prevTransLabel.setRendered(false);
        prevTransPanel.setRendered(false);
        prevTransDesc.setValue(null);
        session.setAttribute("prevEndrCode", null);
        session.setAttribute("prevTransNo", null);
        session.setAttribute("pastPeriod", "N");
    }else if(pastPeriodDrop.getValue().toString().equalsIgnoreCase("Y")){
        prevTransLabel.setRendered(true);
        prevTransPanel.setRendered(true);
        prevTransDesc.setValue(null);
        session.setAttribute("pastPeriod", "Y");
        session.setAttribute("prevEndrCode", null);
        session.setAttribute("prevTransNo", null);
        ADFUtils.findIterator("FindPrevAuthTransactionsIterator").executeQuery();    
        AdfFacesContext.getCurrentInstance().addPartialTarget(prevTransTable);
    }else if(loanTopup.isSelected()){
      session.setAttribute("Endorsement", "LNT");
      session.setAttribute("ProcessShtDesc", "UWLNT");
      endorseDesc.setValue(session.getAttribute("Endorsement"));
      contraPanel.setRendered(false);
      contraLabel.setRendered(false);
      inceptionLabel.setRendered(false);
      inceptionSelection.setRendered(false);
    }else{        
        prevTransLabel.setRendered(false);
        prevTransPanel.setRendered(false);
        prevTransDesc.setValue(null);
        session.setAttribute("prevEndrCode", null);
        session.setAttribute("prevTransNo", null);
        session.setAttribute("pastPeriod", "N");
    }
    
    return null;
  }
  
  public String findPrevTransTransSelected() {
    DCIteratorBinding dciter = 
    ADFUtils.findIterator("FindPrevAuthTransactionsIterator");
    RowKeySet set =prevTransTable.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();
    
    //System.out.println(1);
    while (rowKeySetIter.hasNext()) 
    {
        List l = (List) rowKeySetIter.next();
        Key key = (Key)l.get(0);
        dciter.setCurrentRowWithKey(key.toStringFormat(true));
        Row r = dciter.getCurrentRow();
        prevTransDesc.setValue(r.getAttribute("TRANS"));
     
        session.setAttribute("prevEndrCode", r.getAttribute("ENDR_CODE"));
        session.setAttribute("prevTransNo", r.getAttribute("ENDR_LTR_TRANS_NO"));
    }

    return null;
  }
  
  public String EndorsementAction(){
    
    if(transEffDate.getValue()==null){
      GlobalCC.INFORMATIONREPORTING("Enter a Transaction Effective Date");
      return null;
    }
    
  
    
    try{
        
        //Confirm that u have rights to perform the endorsment
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
            //GlobalCC.RedirectPage("/undwrtone.jspx");
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
        
        int TotalTransactions = 0;
        
         DBConnector myConn=new DBConnector();
         Connection conn=myConn.getDatabaseConn();
  
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
          scheduleAdjust.setRendered(false);
          freeAdj.setRendered(false);
          extOfCover.setRendered(false);
          changeOfPolEffectiveDate.setRendered(false);
          conn.close();    
          return null;
          
        }
      
      
      }catch (Exception e) {
        GlobalCC.EXCEPTIONREPORTING(null, e);
      }
    
    transactions.setRendered(false);
    
    String EndType = (String)session.getAttribute("Endorsement");
    if (EndType.equalsIgnoreCase("EC") || EndType.equalsIgnoreCase("RCP")){
        extOfCover.setRendered(true);
        freeAdj.setRendered(false);
        scheduleAdjust.setRendered(false);
        changeOfPolEffectiveDate.setRendered(false);
      
        endorseButton.setDisabled(true);
        policyButton.setDisabled(true);
        productButton.setDisabled(true);
        transEffDate.setDisabled(true);
        Date date = new Date();
      
        SimpleDateFormat sdf1 =
            new SimpleDateFormat("yyyy-dd-mm");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MMMM/yyyy");
        try{
          date = sdf1.parse(oldCoverFrom.getValue().toString());
                  LOVCC.CoverFromDate = sdf2.format(date); 
          newCoverTo.setValue(null);
          
          schMonth.setValue(null);
          schYear.setValue(null);
        }catch (Exception e) {
          GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        LOVCC.FCLEndorsNo = null;
    }else if (EndType.equalsIgnoreCase("FCL")){
        extOfCover.setRendered(false);
        freeAdj.setRendered(true);
        scheduleAdjust.setRendered(false);
        changeOfPolEffectiveDate.setRendered(false);
        
        endorseButton.setDisabled(true);
        policyButton.setDisabled(true);
        productButton.setDisabled(true);
        transEffDate.setDisabled(true);
        
        oldCoverTo.setValue(null);
        oldCoverFrom.setValue(null);
        newCoverTo.setValue(null);
              LOVCC.FCLEndorsNo = null;
        fclDesc.setValue(null);
        
        schMonth.setValue(null);
        schYear.setValue(null);

        LOVCC.CoverFromDate = null; 
       newCoverTo.setValue(null);  
    }else if (EndType.equalsIgnoreCase("AP")){
        extOfCover.setRendered(false);
        freeAdj.setRendered(false);
        scheduleAdjust.setRendered(true);
        changeOfPolEffectiveDate.setRendered(false);
  
        LOVCC.FCLEndorsNo = null;
        
        endorseButton.setDisabled(true);
        policyButton.setDisabled(true);
        productButton.setDisabled(true);
        transEffDate.setDisabled(true);
        
        oldCoverTo.setValue(null);
        oldCoverFrom.setValue(null);
        newCoverTo.setValue(null);
        
        schMonth.setValue(new Integer(GlobalCC.parseMonthYear(transEffDate.getValue().toString()).split("/")[0]));
        schYear.setValue(GlobalCC.parseMonthYear(transEffDate.getValue().toString()).split("/")[1]);
  
        LOVCC.CoverFromDate = null; 
        newCoverTo.setValue(null);
    }else if (EndType.equalsIgnoreCase("CE")){
        extOfCover.setRendered(false);
        freeAdj.setRendered(false);
        changeOfPolEffectiveDate.setRendered(true);
        scheduleAdjust.setRendered(false);

        LOVCC.FCLEndorsNo = null;
        
        endorseButton.setDisabled(true);
        policyButton.setDisabled(true);
        productButton.setDisabled(true);
        transEffDate.setDisabled(true);
        
        oldCoverTo.setValue(null);
        oldCoverFrom.setValue(null);
        newCoverTo.setValue(null);
        
        schMonth.setValue(null);
        schYear.setValue(null);

        LOVCC.CoverFromDate = null; 
        newCoverTo.setValue(null);
    }else if(EndType.equalsIgnoreCase("CO")){
        schMonth.setValue(null);
        schYear.setValue(null);
        oldCoverFrom.setValue(null);
        
        LOVCC.FCLEndorsNo = null;
        fclDesc.setValue(null);
        
        LOVCC.CoverFromDate = null; 
        newCoverTo.setValue(null);
        
        CreateContraTransaction();
    }else{
        schMonth.setValue(null);
        schYear.setValue(null);
        oldCoverFrom.setValue(null);
  
        LOVCC.FCLEndorsNo = null;
        fclDesc.setValue(null);
  
        LOVCC.CoverFromDate = null; 
        newCoverTo.setValue(null);
        
        CreateNewEndorsement();
    }

    return null;
  }
  
  public String CancelEndorsement(){
    endorseButton.setDisabled(false);
    policyButton.setDisabled(false);
    productButton.setDisabled(false);
    transEffDate.setDisabled(false);
    
    extOfCover.setRendered(false);
    freeAdj.setRendered(false);
    scheduleAdjust.setRendered(false);
    transactions.setRendered(false);
    
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
  
  public String CreateEndorsementProcessFlow(){
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
  
  public String CreateContraTransaction(){
    
     DBConnector myConn=new DBConnector();
    Connection conn=myConn.getDatabaseConn();
    CallableStatement cst=null;

    int TotalTransactions = 0;
      String EndType = (String)session.getAttribute("Endorsement");
    if(LOVCC.FCLEndorsNo == null && EndType.equalsIgnoreCase("FCL")){
    
      String Message = "Select an Endorsement";
      FacesContext.getCurrentInstance().addMessage(null, 
                                                   new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                    Message, 
                                                                    Message));
      
      return null;
    }
    if(newCoverTo.getValue()==null && EndType.equalsIgnoreCase("EC")){
    
      String Message = "Enter a New Cover To Date";
      FacesContext.getCurrentInstance().addMessage(null, 
                                                   new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                    Message, 
                                                                    Message));
      
      return null;
    }
    if(schMonth.getValue()==null && EndType.equalsIgnoreCase("AP")){
    
      String Message = "Enter a Schedule Month";
      FacesContext.getCurrentInstance().addMessage(null, 
                                                   new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                    Message, 
                                                                    Message));
      
      return null;
    }
    if(schYear.getValue()==null && EndType.equalsIgnoreCase("AP")){
    
      String Message = "Enter a Schedule Year";
      FacesContext.getCurrentInstance().addMessage(null, 
                                                   new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                    Message, 
                                                                    Message));
      
      return null;
    }
    if(newEffectiveDate.getValue()==null && EndType.equalsIgnoreCase("CE")){
      
        String Message = "Select The New Policy Effective Date";
        FacesContext.getCurrentInstance().addMessage(null, 
                                                     new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                      Message, 
                                                                      Message));
        
        return null;
      } 
    if(transEffDate.getValue()==null){
   
      String Message = "Enter a Transaction Effective Date";
      FacesContext.getCurrentInstance().addMessage(null, 
                                                   new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                    Message, 
                                                                    Message));
      
      return null;
    }
    
    
    try {
      String PendingTrans = "begin LMS_WEB_CURSOR_GRP.getPendingTransactions(?,?);end;";
      CallableStatement cst1 = conn.prepareCall(PendingTrans);
      cst1.setBigDecimal(1, (BigDecimal)session.getAttribute("policyCode"));
      System.out.println(session.getAttribute("policyCode"));
      cst1.registerOutParameter(2, OracleTypes.INTEGER);
      cst1.execute(); 
      TotalTransactions = cst1.getInt(2);
      /*if (TotalTransactions > 0){
        String Message = "This Policy has Another Unfinished Transaction....";
        FacesContext.getCurrentInstance().addMessage(null, 
                                                     new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                      Message, 
                                                                      Message));
        
        return null;
        
      }*/
        
      String Result = CreateEndorsementProcessFlow();
       if(Result==null){
              return null;
       }else if(Result.equalsIgnoreCase("F")){
              return null;
       }else{
              //Continue...
       }
          
      String polQuery="begin LMS_GRP_WEB_PKG.create_contra_trans(?,?,?,?,?,?,?);end;";
      cst=conn.prepareCall(polQuery);
      
      
      cst.setBigDecimal(1, (BigDecimal)session.getAttribute("policyCode"));
       cst.setBigDecimal(2,(BigDecimal)session.getAttribute("oldEndrCode"));
      if(newEffectiveDate.getValue()==null) {
          cst.setString(3,null);
      }else {
          cst.setString(3, GlobalCC.parseDate(newEffectiveDate.getValue().toString())); //New Policy Effective Date
      }
      cst.setString(4, (String)session.getAttribute("oldTransNo"));
      cst.setString(5, "CO");
      cst.registerOutParameter(6, OracleTypes.DECIMAL);
      cst.registerOutParameter(7, OracleTypes.DECIMAL);
     
      cst.execute(); 
      //NewEndorsement = cst.getInt(6);
      //BigDecimal EndorsementNo = new BigDecimal(NewEndorsement);
      //LOVCC.endorsementCode = EndorsementNo;
      //LOVCC.endorsementCode = EndorsementNo;
      //LOVCC.transactionNumber = cst.getBigDecimal(15);
      session.setAttribute("endorsementCode", cst.getBigDecimal(6));
      session.setAttribute("transactionNumber", cst.getBigDecimal(7));
      cst.close();
      
        workflowProcessing ProcessFlow = new workflowProcessing();
        String UpdateResult = ProcessFlow.UpdateWorkflowAttributes();
        if(UpdateResult==null){
            return null;
        }else if(UpdateResult.equalsIgnoreCase("F")){
            return null;
        }else{
            //Continue..
            session.setAttribute("editComponents", "N");
            GlobalCC.RedirectPage("/g_undwrt.jspx");
        }
        
       /* workflowProcessing wf = new workflowProcessing();
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
        }*/

        conn.close();    
    }
    catch(Exception e) {
        RollBackTicketTransaction();
        GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    
    return null;
  }
  
  public String CreateNewEndorsement(){
    
     DBConnector myConn=new DBConnector();
    Connection conn=myConn.getDatabaseConn();
    CallableStatement cst=null;
    int TotalTransactions = 0;
    String EndType = (String)session.getAttribute("Endorsement");
    if(LOVCC.FCLEndorsNo == null && EndType.equalsIgnoreCase("FCL")){
    
      String Message = "Select an Endorsement";
      FacesContext.getCurrentInstance().addMessage(null, 
                                                   new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                    Message, 
                                                                    Message));
      
      return null;
    }
    if(newCoverTo.getValue()==null && (EndType.equalsIgnoreCase("EC")||EndType.equalsIgnoreCase("RCP"))){
    
      String Message = "Enter a New Cover To Date";
      FacesContext.getCurrentInstance().addMessage(null, 
                                                   new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                    Message, 
                                                                    Message));
      
      return null;
    }
    if(schMonth.getValue()==null && EndType.equalsIgnoreCase("AP")){
    
      String Message = "Enter a Schedule Month";
      FacesContext.getCurrentInstance().addMessage(null, 
                                                   new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                    Message, 
                                                                    Message));
      
      return null;
    }
    if(schYear.getValue()==null && EndType.equalsIgnoreCase("AP")){
    
      String Message = "Enter a Schedule Year";
      FacesContext.getCurrentInstance().addMessage(null, 
                                                   new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                    Message, 
                                                                    Message));
      
      return null;
    }
    if(newEffectiveDate.getValue()==null && EndType.equalsIgnoreCase("CE")){
      
        String Message = "Select The New Policy Effective Date";
        FacesContext.getCurrentInstance().addMessage(null, 
                                                     new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                      Message, 
                                                                      Message));
        
        return null;
      } 
    if(transEffDate.getValue()==null){
   
      String Message = "Enter a Transaction Effective Date";
      FacesContext.getCurrentInstance().addMessage(null, 
                                                   new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                    Message, 
                                                                    Message));
      
      return null;
    }
    String PastPeriod = (String)session.getAttribute("pastPeriod");
    if(PastPeriod==null){
        //Continue..
    }else if(PastPeriod.equalsIgnoreCase("Y")&& session.getAttribute("prevEndrCode")==null){
        GlobalCC.sysInformation("Select A Previous Transaction");  
        return null;
    }else{
         //Continue...
    }
    
    
    try { 
      
      String PendingTrans = "begin LMS_WEB_CURSOR_GRP.getPendingTransactions(?,?);end;";
      CallableStatement cst1 = conn.prepareCall(PendingTrans);
      cst1.setBigDecimal(1, (BigDecimal)session.getAttribute("policyCode"));
      System.out.println((BigDecimal)session.getAttribute("policyCode"));
      cst1.registerOutParameter(2, OracleTypes.INTEGER);
      cst1.execute(); 
      TotalTransactions = cst1.getInt(2);
      
      String Result = CreateEndorsementProcessFlow();
       if(Result==null){
              return null;
       }else if(Result.equalsIgnoreCase("F")){
              return null;
       }else{
              //Continue...
       }
        
      String polQuery="begin LMS_GRP_WEB_PKG.CREATE_NEW_ENDOS(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);end;";
      cst=conn.prepareCall(polQuery);
      
      
      cst.setBigDecimal(1, (BigDecimal)session.getAttribute("policyCode"));
      System.out.println((BigDecimal)session.getAttribute("policyCode"));
      cst.setString(2, "EN");
      cst.setString(3, (String)session.getAttribute("Endorsement"));
       if(transEffDate.getValue().toString().contains(":")){
           cst.setString(4, GlobalCC.parseDate(transEffDate.getValue().toString()));    
       }else{
           cst.setString(4, GlobalCC.upDateParseDate(transEffDate.getValue().toString()));  
       }
      cst.setString(5, "Y"); //INTRODUCE A DIALOG TO MANAGE THIS....
      cst.setString(6, "N");
      cst.setString(7, null);
      cst.setBigDecimal(8, LOVCC.FCLEndorsNo); //Funeral Endorsement Code
      if(schMonth.getValue()==null){
        cst.setString(9, null); //Schedule Adjustment Month
      }else{
        cst.setString(9, schMonth.getValue().toString()); //Schedule Adjustment Month
      }
      if(schYear.getValue()==null){
        cst.setString(10, null); //Schedule Adjustment Year
      }else{
        cst.setString(10, schYear.getValue().toString()); //Schedule Adjustment Year
      }    
      if(oldCoverTo.getValue()==null){
        cst.setString(11, null); //Extension Cover From Date 
      }else{
          if(oldCoverTo.getValue().toString().contains(":")){
              cst.setString(11, GlobalCC.parseDate(oldCoverTo.getValue().toString())); //Extension Cover From Date
          }else{
              cst.setString(11, GlobalCC.upDateParseDate(oldCoverTo.getValue().toString())); //Extension Cover From Date
          }
       
      }
      if (newCoverTo.getValue()==null){
        cst.setString(12, null);
      }else{
      cst.setString(12, GlobalCC.parseDate(newCoverTo.getValue().toString())); //Extension Cover To Date
      }
      cst.setString(13, null); //User
      if(newEffectiveDate.getValue()==null) {
          cst.setString(14,null);
      }
        else {
          if(newEffectiveDate.getValue().toString().contains(":")){
              cst.setString(14, GlobalCC.parseDate(newEffectiveDate.getValue().toString())); //New Policy Effective Date
          }else{
              cst.setString(14, GlobalCC.upDateParseDate(newEffectiveDate.getValue().toString())); //New Policy Effective Date 
          }
          
      }
      cst.registerOutParameter(15, OracleTypes.DECIMAL);
      cst.registerOutParameter(16, OracleTypes.DECIMAL);
      session.getAttribute("pastPeriod");
      cst.setString(17, (String)session.getAttribute("pastPeriod"));
     /*  if(pastPeriodDrop.getValue()==null){
          cst.setString(17, "N"); 
      }else{
          cst.setString(17, pastPeriodDrop.getValue().toString());   
      } */
      cst.setBigDecimal(18, (BigDecimal)session.getAttribute("prevEndrCode"));
     
      cst.execute(); 
      session.setAttribute("endorsementCode", cst.getBigDecimal(15));
      session.setAttribute("transactionNumber", cst.getBigDecimal(16));
      cst.close();
    
        workflowProcessing ProcessFlow = new workflowProcessing();
        String UpdateResult = ProcessFlow.UpdateWorkflowAttributes();
        if(UpdateResult==null){
            return null;
        }else if(UpdateResult.equalsIgnoreCase("F")){
            return null;
        }else{
            //Continue..
            session.setAttribute("editComponents", "N");
            GlobalCC.RedirectPage("/g_undwrt.jspx");
        }
        conn.close();    
    }
    catch(Exception e) {
        RollBackTicketTransaction();
        GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    
    return null;
  }
  
  /*public String CreateNewEndorsement(){
    
     DBConnector myConn=new DBConnector();
    Connection conn=myConn.getDatabaseConn();
    CallableStatement cst=null;
    int NewEndorsement = 0;
    int TotalTransactions = 0;
      String EndType = (String)session.getAttribute("Endorsement");
    if(LOVCC.FCLEndorsNo == null && EndType.equalsIgnoreCase("FCL")){
    
      String Message = "Select an Endorsement";
      FacesContext.getCurrentInstance().addMessage(null, 
                                                   new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                    Message, 
                                                                    Message));
      
      return null;
    }
    if(newCoverTo.getValue()==null && EndType.equalsIgnoreCase("EC")){
    
      String Message = "Enter a New Cover To Date";
      FacesContext.getCurrentInstance().addMessage(null, 
                                                   new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                    Message, 
                                                                    Message));
      
      return null;
    }
    if(schMonth.getValue()==null && EndType.equalsIgnoreCase("AP")){
    
      String Message = "Enter a Schedule Month";
      FacesContext.getCurrentInstance().addMessage(null, 
                                                   new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                    Message, 
                                                                    Message));
      
      return null;
    }
    if(schYear.getValue()==null && EndType.equalsIgnoreCase("AP")){
    
      String Message = "Enter a Schedule Year";
      FacesContext.getCurrentInstance().addMessage(null, 
                                                   new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                    Message, 
                                                                    Message));
      
      return null;
    }
    if(newPolEffectiveDate.getValue()==null && EndType.equalsIgnoreCase("CE")){
      
        String Message = "Select The New Policy Effective Date";
        FacesContext.getCurrentInstance().addMessage(null, 
                                                     new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                      Message, 
                                                                      Message));
        
        return null;
      }  
    if(transEffDate.getValue()==null){
   
      String Message = "Enter a Transaction Effective Date";
      FacesContext.getCurrentInstance().addMessage(null, 
                                                   new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                    Message, 
                                                                    Message));
      
      return null;
    }
    
    
    try {
      String PendingTrans = "begin LMS_WEB_CURSOR_GRP.getPendingTransactions(?,?);end;";
      CallableStatement cst1 = conn.prepareCall(PendingTrans);
      cst1.setBigDecimal(1, (BigDecimal)session.getAttribute("policyCode"));
      System.out.println(session.getAttribute("policyCode"));
      cst1.registerOutParameter(2, OracleTypes.INTEGER);
      cst1.execute(); 
      TotalTransactions = cst1.getInt(2);
      /*if (TotalTransactions > 0){
        String Message = "This Policy has Another Unfinished Transaction....";
        FacesContext.getCurrentInstance().addMessage(null, 
                                                     new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                      Message, 
                                                                      Message));
        
        return null;
        
      }*/
          
      /*String polQuery="begin LMS_GRP_WEB_PKG.CREATE_NEW_ENDOS(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);end;";
      cst=conn.prepareCall(polQuery);
      
      
      cst.setBigDecimal(1, (BigDecimal)session.getAttribute("policyCode"));
      System.out.println(session.getAttribute("policyCode"));
      cst.setString(2, "EN");
      cst.setString(3, (String)session.getAttribute("Endorsement"));
      cst.setString(4, GlobalCC.parseDate(transEffDate.getValue().toString()));
      String Test = GlobalCC.parseDate(transEffDate.getValue().toString());
      System.out.println(Test);
      cst.setString(5, "N");
      cst.setString(6, "N");
      cst.setString(7, null);
      cst.setBigDecimal(8, LOVCC.FCLEndorsNo); //Funeral Endorsement Code
      if(schMonth.getValue()==null){
        cst.setString(9, null); //Schedule Adjustment Month
      }else{
        cst.setString(9, schMonth.getValue().toString()); //Schedule Adjustment Month
      }
      if(schYear.getValue()==null){
        cst.setString(10, null); //Schedule Adjustment Year
      }else{
        cst.setString(10, schYear.getValue().toString()); //Schedule Adjustment Year
      }    
      if(oldCoverFrom.getValue()==null){
        cst.setString(11, null); //Extension Cover From Date 
      }else{
        cst.setString(11, new String("" + LOVCC.CoverFromDate)); //Extension Cover From Date
      }
      if (newCoverTo.getValue()==null){
        cst.setString(12, null);
      }else{
      cst.setString(12, GlobalCC.parseDate(newCoverTo.getValue().toString())); //Extension Cover To Date
      }
      cst.setString(13, null); //User
      if(newPolEffectiveDate.getValue()==null) {
          cst.setString(14,null);
      }
        else {
          cst.setString(14, GlobalCC.parseDate(newPolEffectiveDate.getValue().toString())); //New Policy Effective Date
      }
      cst.registerOutParameter(15, OracleTypes.INTEGER);
      cst.registerOutParameter(16, OracleTypes.INTEGER);
     
      cst.execute(); 
      NewEndorsement = cst.getInt(15);
      BigDecimal EndorsementNo = new BigDecimal(NewEndorsement);
      //LOVCC.endorsementCode = EndorsementNo;
      //LOVCC.endorsementCode = EndorsementNo;
      //LOVCC.transactionNumber = cst.getBigDecimal(15);
      session.setAttribute("endorsementCode", EndorsementNo);
      session.setAttribute("transactionNumber", cst.getBigDecimal(16));
      cst.close();
        
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

        conn.close();    
    }
    catch(Exception e) {
      FacesContext.getCurrentInstance().addMessage(null, 
                                                   new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                                                                    e.getMessage(), 
                                                                    e.getMessage()));
    }
    
    return null;
  }*/
  
  public String AuthoriseExceptions(){
      Connection conn=null;
      try{
          conn=new DBConnector().getDatabaseConn();
          
          //Confirm that the current user can complete this task.
          workflowProcessing bpm  = new workflowProcessing();
          String Rights = null;
          //LOVCC.ProcessAreaShtDesc = "EXPN";
          session.setAttribute("ProcessAreaShtDesc", "EXPN");
        //LOVCC.ProcessSubAShtDesc = LOVCC.Endorsement + "MR";  //Exception Sub Area sht desc   
          Rights = bpm.CheckUserRights();
          if(Rights.equalsIgnoreCase("N")){
              String Message = "You do not have rights to Complete this Task.";
              FacesContext.getCurrentInstance().addMessage(null, 
                                                           new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                            Message, 
                                                                            Message));
              return null;
              
          }  
          
          String NextUser = null;
          //LOVCC.ProcessAreaShtDesc = LOVCC.Endorsement + "MR";
          //LOVCC.ProcessSubAShtDesc = LOVCC.Endorsement + "MR";
          //LOVCC.TaskAssignee = null;
          session.setAttribute("ProcessAreaShtDesc", session.getAttribute("Endorsement") + "MR");
          session.setAttribute("ProcessSubAShtDesc", session.getAttribute("Endorsement") + "MR");
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
          String Taske = (String)session.getAttribute("TaskID"); 
          if (Taske == null){
              String Message = "No Task Selected";
              FacesContext.getCurrentInstance().addMessage(null, 
                                                           new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                            Message, 
                                                                            Message));
              return null;
              
          }
          
          workflowProcessing wf = new workflowProcessing();     
             String MyTask = null;
             CallableStatement cst3 = null;
             String Complete = "BEGIN TQC_WEB_PKG.check_task_completion(?,?,?);END;";
             cst3 = conn.prepareCall(Complete);
             cst3.setString(1,"ENAE"); 
             cst3.setString(2,(String)session.getAttribute("TaskID")); 
             cst3.registerOutParameter(3, oracle.jdbc.OracleTypes.VARCHAR);
             cst3.execute();
             MyTask = cst3.getString(3);
             if (MyTask.equalsIgnoreCase("Y")){
                 Rights = bpm.CheckUserRights();
                 if(Rights.equalsIgnoreCase("Y")){
                     wf.CompleteTask();
                     String Message = "Details Successfully Verified";
                     FacesContext.getCurrentInstance().addMessage(null, 
                                                                  new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                                   Message, 
                                                                                   Message));
                       
                 }else{
                     TaskAss = (String)session.getAttribute("TaskAssignee");
                     if (TaskAss==null){
                             GetAssignee(); 
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
             }else{
                 String Message = "the Task Selected Does not Correspond to the Activity being Performed. Cannot Complete";
                 FacesContext.getCurrentInstance().addMessage(null, 
                                                                      new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                                       Message, 
                                                                                       Message));
                 return null;
             }
          conn.close();      
      }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(conn,e);
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
            "AdfPage.PAGE.findComponent('" + "pt1:users" +
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
            "AdfPage.PAGE.findComponent('" + "pt1:p1" +
            "').show(hints);");
            
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null,e);
        }
        return null;
    }

  public void setProductLOV(RichTable productLOV) {
    this.productLOV = productLOV;
  }

  public RichTable getProductLOV() {
    return productLOV;
  }

  public void setProductDesc(RichInputText productDesc) {
    this.productDesc = productDesc;
  }

  public RichInputText getProductDesc() {
    return productDesc;
  }

  public void setPoliciesDesc(RichInputText policiesDesc) {
    this.policiesDesc = policiesDesc;
  }

  public RichInputText getPoliciesDesc() {
    return policiesDesc;
  }

  public void setPoliciesLOV(RichTable policiesLOV) {
    this.policiesLOV = policiesLOV;
  }

  public RichTable getPoliciesLOV() {
    return policiesLOV;
  }

  public void setToday(RichInputDate Today) {
        policyEndorsements.Today = Today;
  }

  public RichInputDate getToday() {
    return Today;
  }

  public void setPolEffDate(RichInputDate polEffDate) {
    this.polEffDate = polEffDate;
  }

  public RichInputDate getPolEffDate() {
    return polEffDate;
  }

  public void setAddMemSch(RichSelectBooleanRadio addMemSch) {
    this.addMemSch = addMemSch;
  }

  public RichSelectBooleanRadio getAddMemSch() {
    return addMemSch;
  }

  public void setRefundPrem(RichSelectBooleanRadio refundPrem) {
    this.refundPrem = refundPrem;
  }

  public RichSelectBooleanRadio getRefundPrem() {
    return refundPrem;
  }

  public void setTotalCancel(RichSelectBooleanRadio totalCancel) {
    this.totalCancel = totalCancel;
  }

  public RichSelectBooleanRadio getTotalCancel() {
    return totalCancel;
  }

  public void setTotalCancellWithRefund(RichSelectBooleanRadio totalCancellWithRefund) {
    this.totalCancellWithRefund = totalCancellWithRefund;
  }

  public RichSelectBooleanRadio getTotalCancellWithRefund() {
    return totalCancellWithRefund;
  }

  public void setPartialCancel(RichSelectBooleanRadio partialCancel) {
    this.partialCancel = partialCancel;
  }

  public RichSelectBooleanRadio getPartialCancel() {
    return partialCancel;
  }

  public void setEndorseCover(RichSelectBooleanRadio endorseCover) {
    this.endorseCover = endorseCover;
  }

  public RichSelectBooleanRadio getEndorseCover() {
    return endorseCover;
  }

  public void setLgInitialSch(RichSelectBooleanRadio lgInitialSch) {
    this.lgInitialSch = lgInitialSch;
  }

  public RichSelectBooleanRadio getLgInitialSch() {
    return lgInitialSch;
  }

  public void setRenewal(RichSelectBooleanRadio renewal) {
    this.renewal = renewal;
  }

  public RichSelectBooleanRadio getRenewal() {
    return renewal;
  }

  public void setSchAdjustment(RichSelectBooleanRadio schAdjustment) {
    this.schAdjustment = schAdjustment;
  }

  public RichSelectBooleanRadio getSchAdjustment() {
    return schAdjustment;
  }

  public void setAddCoverType(RichSelectBooleanRadio addCoverType) {
    this.addCoverType = addCoverType;
  }

  public RichSelectBooleanRadio getAddCoverType() {
    return addCoverType;
  }

  public void setRemoveCoverType(RichSelectBooleanRadio removeCoverType) {
    this.removeCoverType = removeCoverType;
  }

  public RichSelectBooleanRadio getRemoveCoverType() {
    return removeCoverType;
  }

  public void setChangePolEffDate(RichSelectBooleanRadio changePolEffDate) {
    this.changePolEffDate = changePolEffDate;
  }

  public RichSelectBooleanRadio getChangePolEffDate() {
    return changePolEffDate;
  }

  public void setFreeCoverSch(RichSelectBooleanRadio freeCoverSch) {
    this.freeCoverSch = freeCoverSch;
  }

  public RichSelectBooleanRadio getFreeCoverSch() {
    return freeCoverSch;
  }

  public void setMemberReinstatement(RichSelectBooleanRadio memberReinstatement) {
    this.memberReinstatement = memberReinstatement;
  }

  public RichSelectBooleanRadio getMemberReinstatement() {
    return memberReinstatement;
  }

  public void setEndorseDesc(RichInputText endorseDesc) {
    this.endorseDesc = endorseDesc;
  }

  public RichInputText getEndorseDesc() {
    return endorseDesc;
  }

  public void setTransEffDate(RichInputDate transEffDate) {
    this.transEffDate = transEffDate;
  }

  public RichInputDate getTransEffDate() {
    return transEffDate;
  }

  public void setFclLOV(RichTable fclLOV) {
    this.fclLOV = fclLOV;
  }

  public RichTable getFclLOV() {
    return fclLOV;
  }

  public void setFclDesc(RichInputText fclDesc) {
    this.fclDesc = fclDesc;
  }

  public RichInputText getFclDesc() {
    return fclDesc;
  }

  public void setSchMonth(RichInputText schMonth) {
    this.schMonth = schMonth;
  }

  public RichInputText getSchMonth() {
    return schMonth;
  }

  public void setSchYear(RichInputText schYear) {
    this.schYear = schYear;
  }

  public RichInputText getSchYear() {
    return schYear;
  }

  public void setNewCoverTo(RichInputDate newCoverTo) {
    this.newCoverTo = newCoverTo;
  }

  public RichInputDate getNewCoverTo() {
    return newCoverTo;
  }

  public void setExtOfCover(RichPanelBox extOfCover) {
    this.extOfCover = extOfCover;
  }

  public RichPanelBox getExtOfCover() {
    return extOfCover;
  }

  public void setFreeAdj(RichPanelBox freeAdj) {
    this.freeAdj = freeAdj;
  }

  public RichPanelBox getFreeAdj() {
    return freeAdj;
  }

  public void setScheduleAdjust(RichPanelBox scheduleAdjust) {
    this.scheduleAdjust = scheduleAdjust;
  }

  public RichPanelBox getScheduleAdjust() {
    return scheduleAdjust;
  }

  public void setEndorseButton(RichCommandButton endorseButton) {
    this.endorseButton = endorseButton;
  }

  public RichCommandButton getEndorseButton() {
    return endorseButton;
  }

  public void setPolicyButton(RichCommandButton policyButton) {
    this.policyButton = policyButton;
  }

  public RichCommandButton getPolicyButton() {
    return policyButton;
  }

  public void setProductButton(RichCommandButton productButton) {
    this.productButton = productButton;
  }

  public RichCommandButton getProductButton() {
    return productButton;
  }

  public void setOldCoverTo(RichInputDate oldCoverTo) {
    this.oldCoverTo = oldCoverTo;
  }

  public RichInputDate getOldCoverTo() {
    return oldCoverTo;
  }

  public void setOldCoverFrom(RichInputDate oldCoverFrom) {
    this.oldCoverFrom = oldCoverFrom;
  }

  public RichInputDate getOldCoverFrom() {
    return oldCoverFrom;
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

    public void setChangeCategory(RichSelectBooleanRadio changeCategory) {
        this.changeCategory = changeCategory;
    }

    public RichSelectBooleanRadio getChangeCategory() {
        return changeCategory;
    }

    public void setUsersLOV(RichTable usersLOV) {
        this.usersLOV = usersLOV;
    }

    public RichTable getUsersLOV() {
        return usersLOV;
    }

    public void setResultsLOV(RichTable resultsLOV) {
        this.resultsLOV = resultsLOV;
    }

    public RichTable getResultsLOV() {
        return resultsLOV;
    }

    public void setChangeOfPolEffectiveDate(RichPanelBox changeOfPolEffectiveDate) {
        this.changeOfPolEffectiveDate = changeOfPolEffectiveDate;
    }

    public RichPanelBox getChangeOfPolEffectiveDate() {
        return changeOfPolEffectiveDate;
    }

    public void setOldEffectiveDate(RichInputText oldEffectiveDate) {
        this.oldEffectiveDate = oldEffectiveDate;
    }

    public RichInputText getOldEffectiveDate() {
        return oldEffectiveDate;
    }

    public void setNewEffectiveDate(RichInputDate newEffectiveDate) {
        this.newEffectiveDate = newEffectiveDate;
    }

    public RichInputDate getNewEffectiveDate() {
        return newEffectiveDate;
    }

    public void setNewPolEffectiveDate(RichInputDate newPolEffectiveDate) {
        this.newPolEffectiveDate = newPolEffectiveDate;
    }

    public RichInputDate getNewPolEffectiveDate() {
        return newPolEffectiveDate;
    }

    public void setContraTrans(RichSelectBooleanRadio contraTrans) {
        this.contraTrans = contraTrans;
    }

    public RichSelectBooleanRadio getContraTrans() {
        return contraTrans;
    }

    public void setPremMask(RichSelectBooleanRadio premMask) {
        this.premMask = premMask;
    }

    public RichSelectBooleanRadio getPremMask() {
        return premMask;
    }

    public void setAgeTrans(RichSelectBooleanRadio ageTrans) {
        this.ageTrans = ageTrans;
    }

    public RichSelectBooleanRadio getAgeTrans() {
        return ageTrans;
    }

    public void setCoinPropTrans(RichSelectBooleanRadio coinPropTrans) {
        this.coinPropTrans = coinPropTrans;
    }

    public RichSelectBooleanRadio getCoinPropTrans() {
        return coinPropTrans;
    }

    public void setContraLabel(RichOutputLabel contraLabel) {
        this.contraLabel = contraLabel;
    }

    public RichOutputLabel getContraLabel() {
        return contraLabel;
    }

    public void setContraPanel(HtmlPanelGrid contraPanel) {
        this.contraPanel = contraPanel;
    }

    public HtmlPanelGrid getContraPanel() {
        return contraPanel;
    }

    public void setContraDesc(RichInputText contraDesc) {
        this.contraDesc = contraDesc;
    }

    public RichInputText getContraDesc() {
        return contraDesc;
    }

    public void setContraTable(RichTable contraTable) {
        this.contraTable = contraTable;
    }

    public RichTable getContraTable() {
        return contraTable;
    }

    public void setInceptionLabel(RichOutputLabel inceptionLabel) {
        this.inceptionLabel = inceptionLabel;
    }

    public RichOutputLabel getInceptionLabel() {
        return inceptionLabel;
    }

    public void setInceptionSelection(RichSelectOneChoice inceptionSelection) {
        this.inceptionSelection = inceptionSelection;
    }

    public RichSelectOneChoice getInceptionSelection() {
        return inceptionSelection;
    }

    public void setPastPeriodDrop(RichSelectOneChoice pastPeriodDrop) {
        this.pastPeriodDrop = pastPeriodDrop;
    }

    public RichSelectOneChoice getPastPeriodDrop() {
        return pastPeriodDrop;
    }

    public void setPrevTransLabel(RichOutputLabel prevTransLabel) {
        this.prevTransLabel = prevTransLabel;
    }

    public RichOutputLabel getPrevTransLabel() {
        return prevTransLabel;
    }

    public void setPrevTransPanel(HtmlPanelGrid prevTransPanel) {
        this.prevTransPanel = prevTransPanel;
    }

    public HtmlPanelGrid getPrevTransPanel() {
        return prevTransPanel;
    }

    public void setPrevTransDesc(RichInputText prevTransDesc) {
        this.prevTransDesc = prevTransDesc;
    }

    public RichInputText getPrevTransDesc() {
        return prevTransDesc;
    }

    public void setPrevTransTable(RichTable prevTransTable) {
        this.prevTransTable = prevTransTable;
    }

    public RichTable getPrevTransTable() {
        return prevTransTable;
    }

    public void setChngeContriTrans(RichSelectBooleanRadio chngeContriTrans) {
        this.chngeContriTrans = chngeContriTrans;
    }

    public RichSelectBooleanRadio getChngeContriTrans() {
        return chngeContriTrans;
    }

    public void setChngeLifeFactor(RichSelectBooleanRadio chngeLifeFactor) {
        this.chngeLifeFactor = chngeLifeFactor;
    }

    public RichSelectBooleanRadio getChngeLifeFactor() {
        return chngeLifeFactor;
    }

    public void setChngeLoanRepayment(RichSelectBooleanRadio chngeLoanRepayment) {
        this.chngeLoanRepayment = chngeLoanRepayment;
    }

    public RichSelectBooleanRadio getChngeLoanRepayment() {
        return chngeLoanRepayment;
    }

    public void setCoverReduction(RichSelectBooleanRadio coverReduction) {
        this.coverReduction = coverReduction;
    }

    public RichSelectBooleanRadio getCoverReduction() {
        return coverReduction;
    }
    public void setLoanTopup(RichSelectBooleanRadio loanTopup) {
            this.loanTopup = loanTopup;
        }

   public RichSelectBooleanRadio getLoanTopup() {
            return loanTopup;
    }
}
