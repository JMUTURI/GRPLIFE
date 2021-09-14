package LMSG.view.Medicals;

import LMSG.view.BPM.ProcessDMSTicket;
import LMSG.view.Base.ADFUtils;
import LMSG.view.Base.GlobalCC;
import LMSG.view.Base.LOVCC;
import LMSG.view.Base.Rendering;
import LMSG.view.Reports.ReportEngine;
import LMSG.view.connect.DBConnector;
import LMSG.view.dms.DMSUtils;
import LMSG.view.ecm.EcmProps;
import LMSG.view.ecm.EcmTrans;
import LMSG.view.ecm.EcmUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputFile;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanCheckbox;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanRadio;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.input.RichSelectOneRadio;
import oracle.adf.view.rich.component.rich.layout.RichPanelBox;
import oracle.adf.view.rich.component.rich.layout.RichShowDetailItem;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.output.RichInlineFrame;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.uicli.binding.JUCtrlValueBinding;
import oracle.jdbc.OracleConnection;
import org.alfresco.cmis.client.AlfrescoDocument;
import org.apache.chemistry.opencmis.client.api.CmisObject;
import org.apache.chemistry.opencmis.client.api.Document;
import org.apache.chemistry.opencmis.client.api.Folder;
import org.apache.chemistry.opencmis.client.api.Session;
import org.apache.chemistry.opencmis.commons.data.ContentStream;
import org.apache.myfaces.trinidad.event.SelectionEvent;
import org.apache.myfaces.trinidad.model.RowKeySet;
import org.apache.myfaces.trinidad.model.UploadedFile;
import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

public class medicalsManipulation
  extends LOVCC
{
  private RichInputText policiesDesc;
  private RichTable policiesLOV;
  private RichInputText memberDesc;
  private RichTable membersLOV;
  private RichTable medReqLOV;
  private RichInputText facDesc;
  private RichInputDate reqDate;
  private RichInputText invAmt;
  private RichInputDate cheqDate;
  private RichSelectOneChoice checkedDesc;
  private RichInputDate invDate;
  private RichInputText invNo;
  private RichInputText remarks;
  private RichTable facLOV;
  private RichTable facilitatorLOV;
  private RichSelectBooleanRadio rdFac;
  private RichSelectBooleanRadio rdPol;
  private RichSelectBooleanRadio rdAll;
  private RichCommandButton searchButton;
  private RichTable allPaymentsLOV;
  private RichPanelBox paymentsTab;
  private RichTable searchLOV;
  private RichInputText searchDesc;
  protected static BigDecimal[][] MedicalPay = new BigDecimal[20][2];
  protected static String[] MedicalPayDesc = new String[20];
  protected static int t = 0;
  private RichSelectBooleanCheckbox payCbox;
  private RichPanelBox facilitatorTab;
  private RichTable facPayLOV;
  private RichSelectOneChoice transType;
  private RichInputDate effDate;
  private RichTable existPolLOV;
  HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
  private RichTable decisionsLOV;
  private RichTable memDecisionsLOV;
  private RichSelectOneRadio rdSearch;
  private RichSelectBooleanRadio additionalMedicals;
  private RichSelectBooleanRadio unrequestedMedicals;
  private RichTable medTestsTable;
  private RichInputDate resultDate;
  private RichSelectOneChoice medQuestSelect;
  private RichShowDetailItem medReportDetail;
  private RichTable memDetailsTab;
  private RichInputText srchMemNo;
  private RichInputText srchMemName;
  private RichInputFile dmsFileToUpload;
  private RichSelectOneChoice lmsDocType;
  private RichShowDetailItem dmsDocTab;
  private RichTable dmsDocTable;
  private RichInlineFrame medViewer;
    private RichTable approvedMedicalLOV;

    public String findPoliciesSelected()
  {
    DCIteratorBinding dciter = ADFUtils.findIterator("FindMedicalPoliciesIterator");
    RowKeySet set = this.policiesLOV.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();
    while (rowKeySetIter.hasNext())
    {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();
      this.policiesDesc.setValue(r.getAttribute("pol_policy_no"));
      this.session.setAttribute("policyCode", r.getAttribute("pol_code"));
      this.session.setAttribute("endorsementCode", r.getAttribute("pol_current_endr_code"));
      
      this.memberDesc.setValue(null);
      this.session.setAttribute("MemberNumber", null);
    }
    return null;
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
      ADFUtils.findIterator("FindPolicyMemberMedicalsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.membersLOV);
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(null, e);
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
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.srchMemNo);
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.srchMemName);
      
      ADFUtils.findIterator("FindPolicyMemberMedicalsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.membersLOV);
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
    return null;
  }
  
  public String findPolicyMemberSelected()
  {
    DCIteratorBinding dciter = ADFUtils.findIterator("FindPolicyMemberMedicalsIterator");
    RowKeySet set = this.membersLOV.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();
    while (rowKeySetIter.hasNext())
    {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();
      this.memberDesc.setValue(r.getAttribute("MEM_NO"));
      
      this.session.setAttribute("PolmCode", r.getAttribute("POLM_CODE"));
      this.session.setAttribute("PolmMemCode", r.getAttribute("MEM_CODE"));
      this.session.setAttribute("MemberSel", r.getAttribute("POLM_CODE"));
    }
    return null;
  }
  
  public String SearchResults()
  {
    if (this.policiesDesc.getValue() == null)
    {
      String message = "Select a Policy";
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message));
      


      return null;
    }
    try
    {
      if (this.memberDesc.getValue() == null) {
        GlobalCC.RedirectPage("/policyMedicals.jspx");
      } else {
        GlobalCC.RedirectPage("/medDetails.jspx");
      }
    }
    catch (Exception ex)
    {
      GlobalCC.EXCEPTIONREPORTING(null, ex);
    }
    return null;
  }
  
  public String EditMedicalReq()
  {
    DCIteratorBinding dciter = ADFUtils.findIterator("FindClientMedicalsIterator");
    RowKeySet set = this.medReqLOV.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();
    while (rowKeySetIter.hasNext())
    {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();
      

      this.session.setAttribute("CMLCode", r.getAttribute("CML_CODE"));
      this.facDesc.setValue(r.getAttribute("SPR_NAME"));
      this.reqDate.setValue(r.getAttribute("CML_REQUEST_DATE"));
      this.invAmt.setValue(r.getAttribute("CML_CLAIM_AMT"));
      this.cheqDate.setValue(r.getAttribute("CML_DATE_RECEIVED"));
      this.checkedDesc.setValue(r.getAttribute("CML_RECEIVED"));
      this.invDate.setValue(r.getAttribute("CML_INVCE_DATE"));
      this.invNo.setValue(r.getAttribute("CML_INVCE_NO"));
      this.remarks.setValue(r.getAttribute("CML_REMARKS"));
      

      ExtendedRenderKitService erkService = (ExtendedRenderKitService)Service.getService(FacesContext.getCurrentInstance().getRenderKit(), ExtendedRenderKitService.class);
      

      erkService.addScript(FacesContext.getCurrentInstance(), "var hints = {autodismissNever:false}; AdfPage.PAGE.findComponent('lmsgroup:medpopup').show(hints);");
    }
    return null;
  }
  
  public String RenderFacilitators()
  {
    ExtendedRenderKitService erkService = (ExtendedRenderKitService)Service.getService(FacesContext.getCurrentInstance().getRenderKit(), ExtendedRenderKitService.class);
    

    erkService.addScript(FacesContext.getCurrentInstance(), "var hints = {autodismissNever:false}; AdfPage.PAGE.findComponent('lmsgroup:facPopup').show(hints);");
    



    return null;
  }
  
  public String findFacilitatorsSel()
  {
    DCIteratorBinding dciter = ADFUtils.findIterator("FindMedicalFacilitatorsIterator");
    RowKeySet set = this.facLOV.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();
    while (rowKeySetIter.hasNext())
    {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();
      

      this.session.setAttribute("FacilitatorCode", r.getAttribute("SPR_CODE"));
      this.facDesc.setValue(r.getAttribute("SPR_NAME"));
      


      ExtendedRenderKitService erkService = (ExtendedRenderKitService)Service.getService(FacesContext.getCurrentInstance().getRenderKit(), ExtendedRenderKitService.class);
      

      erkService.addScript(FacesContext.getCurrentInstance(), "var hints = {autodismissNever:false}; AdfPage.PAGE.findComponent('lmsgroup:medpopup').show(hints);");
    }
    return null;
  }
  
  public String findUWDecisionsSel()
  {
    try
    {
      ADFUtils.findIterator("FindUWDecisionViewIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.decisionsLOV);
      
      GlobalCC.showPopup("lmsgroup:decisi");
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
    return null;
  }
  
  public String SaveUWDecisionSel()
  {
    Connection conn = null;
    try
    {
      DBConnector myConn = new DBConnector();
      conn = myConn.getDatabaseConn();
      CallableStatement cst = null;
      
      BigDecimal Ud_Code = null;
      
      DCIteratorBinding dciter = ADFUtils.findIterator("FindUWDecisionViewIterator");
      RowKeySet set = this.decisionsLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      while (rowKeySetIter.hasNext())
      {
        List l = (List)rowKeySetIter.next();
        Key key = (Key)l.get(0);
        dciter.setCurrentRowWithKey(key.toStringFormat(true));
        Row r = dciter.getCurrentRow();
        

        Ud_Code = (BigDecimal)r.getAttribute("PUD_CODE");
        
        String polQuery = "begin LMS_WEB_PKG_GRP.attach_med_uw_decisions(?,?,?);end;";
        cst = conn.prepareCall(polQuery);
        cst.setBigDecimal(1, Ud_Code);
        cst.setBigDecimal(2, (BigDecimal)this.session.getAttribute("policyCode"));
        cst.setBigDecimal(3, (BigDecimal)this.session.getAttribute("PolmMemCode"));
        cst.execute();
        
        cst.close();
        ADFUtils.findIterator("FindMemberUWDecisionViewIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.memDecisionsLOV);
        conn.close();
      }
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
  }
  
  public String DeleteUWDecisions()
  {
    Connection conn = null;
    try
    {
      DBConnector myConn = new DBConnector();
      conn = myConn.getDatabaseConn();
      CallableStatement cst = null;
      
      BigDecimal Ud_Code = null;
      
      DCIteratorBinding dciter = ADFUtils.findIterator("FindMemberUWDecisionViewIterator");
      RowKeySet set = this.memDecisionsLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      while (rowKeySetIter.hasNext())
      {
        List l = (List)rowKeySetIter.next();
        Key key = (Key)l.get(0);
        dciter.setCurrentRowWithKey(key.toStringFormat(true));
        Row r = dciter.getCurrentRow();
        

        Ud_Code = (BigDecimal)r.getAttribute("MEM_PUD_CODE");
        
        String polQuery = "begin LMS_WEB_PKG_GRP.delete_und_decision(?);end;";
        cst = conn.prepareCall(polQuery);
        cst.setBigDecimal(1, Ud_Code);
        cst.execute();
        
        cst.close();
        
        ADFUtils.findIterator("FindMemberUWDecisionViewIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.memDecisionsLOV);
        conn.close();
      }
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
  }
  
  public String findPolicyFacSel()
  {
    DCIteratorBinding dciter = ADFUtils.findIterator("FindMedicalPaymentsQueryIterator");
    RowKeySet set = this.searchLOV.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();
    while (rowKeySetIter.hasNext())
    {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();
      
      String PayFlag = (String)this.session.getAttribute("PaymentsFlag");
      if (PayFlag.equalsIgnoreCase("P"))
      {
        this.session.setAttribute("MedPolicy", r.getAttribute("searchCode"));
        this.session.setAttribute("policyCode", r.getAttribute("searchCode"));
        
        this.session.setAttribute("FacilitatorCode", null);
      }
      else
      {
        this.session.setAttribute("FacilitatorCode", r.getAttribute("searchCode"));
        this.session.setAttribute("FacilitatorCode", r.getAttribute("searchCode"));
      }
      this.searchDesc.setValue(r.getAttribute("searchDesc"));
    }
    return null;
  }
  
  public String SaveMedicalRequirement()
  {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    Boolean ReqDateChanged = Boolean.valueOf(false);
    Boolean cheqDateChanged = Boolean.valueOf(false);
    Boolean invDateChanged = Boolean.valueOf(false);
    if (this.reqDate.getValue() != null) {
      ReqDateChanged = Boolean.valueOf(this.reqDate.getValue().toString().contains(":"));
    }
    if (this.cheqDate.getValue() != null) {
      cheqDateChanged = Boolean.valueOf(this.cheqDate.getValue().toString().contains(":"));
    }
    if (this.invDate.getValue() != null) {
      invDateChanged = Boolean.valueOf(this.invDate.getValue().toString().contains(":"));
    }
    try
    {
      String polQuery = "begin LMS_WEB_PKG_GRP.updatemedicals(?,?,?,?,?,?,?,?,?,?);end;";
      cst = conn.prepareCall(polQuery);
      if (this.reqDate.getValue() == null) {
        cst.setString(1, null);
      } else if (!ReqDateChanged.booleanValue()) {
        cst.setString(1, null);
      } else {
        cst.setString(1, LOVCC.parseDate(this.reqDate.getValue().toString()));
      }
      if (this.invAmt.getValue() == null) {
        cst.setString(2, null);
      } else {
        cst.setString(2, this.invAmt.getValue().toString());
      }
      if (this.cheqDate.getValue() == null) {
        cst.setString(3, null);
      } else if (!cheqDateChanged.booleanValue()) {
        cst.setString(3, null);
      } else {
        cst.setString(3, LOVCC.parseDate(this.cheqDate.getValue().toString()));
      }
      if (this.checkedDesc.getValue() == null) {
        cst.setString(4, null);
      } else {
        cst.setString(4, this.checkedDesc.getValue().toString());
      }
      if (this.invDate.getValue() == null) {
        cst.setString(5, null);
      } else if (!invDateChanged.booleanValue()) {
        cst.setString(5, null);
      } else {
        cst.setString(5, LOVCC.parseDate(this.invDate.getValue().toString()));
      }
      if (this.invNo.getValue() == null) {
        cst.setString(6, null);
      } else {
        cst.setString(6, this.invNo.getValue().toString());
      }
      if (this.remarks.getValue() == null) {
        cst.setString(7, null);
      } else {
        cst.setString(7, this.remarks.getValue().toString());
      }
      cst.setBigDecimal(8, (BigDecimal)this.session.getAttribute("CMLCode"));
      cst.setBigDecimal(9, (BigDecimal)this.session.getAttribute("FacilitatorCode"));
      if (this.resultDate.getValue() == null) {
        cst.setString(10, null);
      } else {
        cst.setString(10, LOVCC.parseDate(this.resultDate.getValue().toString()));
      }
      cst.execute();
      
      this.session.setAttribute("CMLCode", null);
      cst.close();
      
      String Message = "Medical Updated";
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Message, Message));
      



      ADFUtils.findIterator("FindClientMedicalsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.medReqLOV);
      



      GlobalCC.hidePopup("lmsgroup:medpopup");
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
      e.printStackTrace();
    }
    return null;
  }
  
  public String CreateTransaction()
  {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    try
    {
      String polQuery = "begin LMS_WEB_PKG_GRP.medpaymentstransaction(?);end;";
      cst = conn.prepareCall(polQuery);
      cst.registerOutParameter(1, 4);
      cst.execute();
      

      this.session.setAttribute("MedTransNo", cst.getBigDecimal(1));
      this.session.setAttribute("PaymentsFlag", "F");
      
      cst.close();
      conn.close();
      GlobalCC.RedirectPage("/medicalPayments.jspx");
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
  }
  
  public String SearchPaymentsResults()
  {
    ADFUtils.findIterator("FindMedicalPaymentsIterator").executeQuery();
    AdfFacesContext.getCurrentInstance().addPartialTarget(this.allPaymentsLOV);
    
    ADFUtils.findIterator("FindFacilitatorPaymentsIterator").executeQuery();
    AdfFacesContext.getCurrentInstance().addPartialTarget(this.facPayLOV);
    
    this.paymentsTab.setRendered(true);
    this.facilitatorTab.setRendered(true);
    AdfFacesContext.getCurrentInstance().addPartialTarget(this.paymentsTab);
    AdfFacesContext.getCurrentInstance().addPartialTarget(this.facilitatorTab);
    
    return null;
  }
  
  public String DeleteMedicalRequirement()
  {
    BigDecimal CMLCode = null;
    DCIteratorBinding dciter = ADFUtils.findIterator("FindClientMedicalsIterator");
    RowKeySet set = this.medReqLOV.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();
    while (rowKeySetIter.hasNext())
    {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();
      
      CMLCode = (BigDecimal)r.getAttribute("CML_CODE");
    }
    String deleteQuery = "BEGIN LMS_WEB_PKG_GRP.deletemedicals(?);END;";
    Connection conn = new DBConnector().getDatabaseConn();
    CallableStatement cstmt = null;
    try
    {
      cstmt = conn.prepareCall(deleteQuery);
      cstmt.setBigDecimal(1, CMLCode);
      cstmt.execute();
      
      cstmt.close();
      conn.close();
      
      ADFUtils.findIterator("FindClientMedicalsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.medReqLOV);
      
      ADFUtils.findIterator("findMedTestIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.medTestsTable);
    }
    catch (Exception ex)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, ex);
    }
    return null;
  }
  
  public String AddRow()
  {
    BigDecimal Code = null;
    
    DCIteratorBinding dciter = ADFUtils.findIterator("FindMedicalPaymentsIterator");
    RowKeySet set = this.allPaymentsLOV.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();
    while (rowKeySetIter.hasNext())
    {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      
      Row r = dciter.getCurrentRow();
      
      Code = (BigDecimal)r.getAttribute("MP_CML_CODE");
      
      MedicalPay[t][0] = Code;
      System.out.println(MedicalPay[t][0]);
      
      MedicalPayDesc[t] = "Y";
      

      t += 1;
    }
    return null;
  }
  
  public String RemoveRow()
  {
    BigDecimal Code = null;
    
    DCIteratorBinding dciter = ADFUtils.findIterator("FindMedicalPaymentsIterator");
    RowKeySet set = this.allPaymentsLOV.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();
    while (rowKeySetIter.hasNext())
    {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      
      Row r = dciter.getCurrentRow();
      
      Code = (BigDecimal)r.getAttribute("MP_CML_CODE");
      System.out.println(Code);
      
      int m = 0;
      while (m < t)
      {
        System.out.println(MedicalPay[m][0]);
        if (MedicalPay[m][0].equals(Code)) {
          MedicalPayDesc[m] = "N";
        }
        m++;
      }
    }
    return null;
  }
  
  public void PayMedicalListener(ValueChangeEvent valueChangeEvent)
  {
    if (valueChangeEvent.getOldValue() != valueChangeEvent.getNewValue())
    {
      RowKeySet rowKeySet = this.allPaymentsLOV.getSelectedRowKeys();
      if (rowKeySet == null) {
        return;
      }
      if (!rowKeySet.iterator().hasNext())
      {
        GlobalCC.errorValueNotEntered("No Record Selected");
        return;
      }
      Object key2 = rowKeySet.iterator().next();
      this.allPaymentsLOV.setRowKey(key2);
      JUCtrlValueBinding nodeBinding = (JUCtrlValueBinding)this.allPaymentsLOV.getRowData();
      if (nodeBinding == null)
      {
        GlobalCC.errorValueNotEntered("No Record Selected");
        return;
      }
      if (this.payCbox.isSelected()) {
        nodeBinding.setAttribute("selected", Boolean.valueOf(true));
      } else {
        nodeBinding.setAttribute("selected", Boolean.valueOf(false));
      }
    }
  }
  
  public String PreparePayments()
  {
    String fclQuery = "BEGIN LMS_WEB_PKG_GRP.preparemedpayments(?,?,?,?);END;";
    Connection conn = new DBConnector().getDatabaseConn();
    CallableStatement cst = null;
    
    BigDecimal BenPayment = null;
    try
    {
      int rowCount = 0;
      boolean Value = false;
      rowCount = this.allPaymentsLOV.getRowCount();
      if (rowCount == 0) {
        return null;
      }
      for (int i = 0; i < rowCount; i++)
      {
        this.allPaymentsLOV.setRowIndex(i);
        JUCtrlValueBinding nodeBinding = (JUCtrlValueBinding)this.allPaymentsLOV.getRowData();
        if (nodeBinding != null)
        {
          Value = ((Boolean)nodeBinding.getAttribute("selected")).booleanValue();
          if (Value == true)
          {
            BenPayment = (BigDecimal)nodeBinding.getAttribute("MP_CML_CODE");
            
            cst = conn.prepareCall(fclQuery);
            
            cst.setBigDecimal(1, (BigDecimal)this.session.getAttribute("MedTransNo"));
            cst.setString(2, "G");
            cst.setBigDecimal(3, BenPayment);
            cst.setBigDecimal(4, (BigDecimal)nodeBinding.getAttribute("SPR_CODE"));
            cst.execute();
            cst.close();
          }
        }
      }
      ADFUtils.findIterator("FindMedicalPaymentsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.allPaymentsLOV);
      
      ADFUtils.findIterator("FindFacilitatorPaymentsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.facPayLOV);
      
      GlobalCC.INFORMATIONREPORTING("Payments Prepared.");
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
  }
  
  public String ProcessMedicalPayments()
  {
    if (this.transType.getValue() == null)
    {
      String Message = "Select a Transaction Type.";
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Message, Message));
      



      return null;
    }
    String fclQuery = "BEGIN LMS_WEB_PKG_GRP.processmedicalpayments(?,?,?);END;";
    Connection conn = new DBConnector().getDatabaseConn();
    CallableStatement cst = null;
    try
    {
      cst = conn.prepareCall(fclQuery);
      
      cst.setString(1, this.transType.getValue().toString());
      if (this.effDate.getValue() == null) {
        cst.setString(2, null);
      } else {
        cst.setString(2, LOVCC.parseDate(this.effDate.getValue().toString()));
      }
      cst.registerOutParameter(3, 4);
      cst.execute();
      


      this.session.setAttribute("MedTransNo", cst.getBigDecimal(3));
      this.session.setAttribute("PaymentsFlag", "F");
      cst.close();
      conn.close();
      GlobalCC.RedirectPage("/medicalPayments.jspx");
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
  }
  
  public String AuthorisePayments()
  {
    Connection conn = null;
    CallableStatement cst = null;
    try
    {
      conn = new DBConnector().getDatabaseConn();
      String polQuery = "begin LMS_WEB_PKG_GRP.authorizemedpayments(?,?);end;";
      cst = conn.prepareCall(polQuery);
      cst.setBigDecimal(1, (BigDecimal)this.session.getAttribute("MedTransNo"));
      cst.setBigDecimal(2, (BigDecimal)this.session.getAttribute("fmptCode"));
      cst.execute();
      
      cst.close();
      conn.close();
      GlobalCC.INFORMATIONREPORTING("Payments Authorised Successfully.");
      
      ADFUtils.findIterator("FindMedicalPaymentsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.allPaymentsLOV);
      
      ADFUtils.findIterator("FindFacilitatorPaymentsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.facPayLOV);
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
  }
  
  public void setPoliciesDesc(RichInputText policiesDesc)
  {
    this.policiesDesc = policiesDesc;
  }
  
  public RichInputText getPoliciesDesc()
  {
    return this.policiesDesc;
  }
  
  public void setPoliciesLOV(RichTable policiesLOV)
  {
    this.policiesLOV = policiesLOV;
  }
  
  public RichTable getPoliciesLOV()
  {
    return this.policiesLOV;
  }
  
  public void setMemberDesc(RichInputText memberDesc)
  {
    this.memberDesc = memberDesc;
  }
  
  public RichInputText getMemberDesc()
  {
    return this.memberDesc;
  }
  
  public void setMembersLOV(RichTable membersLOV)
  {
    this.membersLOV = membersLOV;
  }
  
  public RichTable getMembersLOV()
  {
    return this.membersLOV;
  }
  
  public void setMedReqLOV(RichTable medReqLOV)
  {
    this.medReqLOV = medReqLOV;
  }
  
  public RichTable getMedReqLOV()
  {
    return this.medReqLOV;
  }
  
  public void setFacDesc(RichInputText facDesc)
  {
    this.facDesc = facDesc;
  }
  
  public RichInputText getFacDesc()
  {
    return this.facDesc;
  }
  
  public void setReqDate(RichInputDate reqDate)
  {
    this.reqDate = reqDate;
  }
  
  public RichInputDate getReqDate()
  {
    return this.reqDate;
  }
  
  public void setInvAmt(RichInputText invAmt)
  {
    this.invAmt = invAmt;
  }
  
  public RichInputText getInvAmt()
  {
    return this.invAmt;
  }
  
  public void setCheqDate(RichInputDate cheqDate)
  {
    this.cheqDate = cheqDate;
  }
  
  public RichInputDate getCheqDate()
  {
    return this.cheqDate;
  }
  
  public void setCheckedDesc(RichSelectOneChoice checkedDesc)
  {
    this.checkedDesc = checkedDesc;
  }
  
  public RichSelectOneChoice getCheckedDesc()
  {
    return this.checkedDesc;
  }
  
  public void setInvDate(RichInputDate invDate)
  {
    this.invDate = invDate;
  }
  
  public RichInputDate getInvDate()
  {
    return this.invDate;
  }
  
  public void setInvNo(RichInputText invNo)
  {
    this.invNo = invNo;
  }
  
  public RichInputText getInvNo()
  {
    return this.invNo;
  }
  
  public void setRemarks(RichInputText remarks)
  {
    this.remarks = remarks;
  }
  
  public RichInputText getRemarks()
  {
    return this.remarks;
  }
  
  public void setFacLOV(RichTable facLOV)
  {
    this.facLOV = facLOV;
  }
  
  public RichTable getFacLOV()
  {
    return this.facLOV;
  }
  
  public void setFacilitatorLOV(RichTable facilitatorLOV)
  {
    this.facilitatorLOV = facilitatorLOV;
  }
  
  public RichTable getFacilitatorLOV()
  {
    return this.facilitatorLOV;
  }
  
  public void facListener(ValueChangeEvent valueChangeEvent)
  {
    if (this.rdFac.getValue() != null) {
      if (this.rdFac.isSelected())
      {
        this.session.setAttribute("PaymentsFlag", "F");
        ADFUtils.findIterator("FindMedicalPaymentsQueryIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.searchLOV);
      }
    }
    this.searchButton.setDisabled(false);
    AdfFacesContext.getCurrentInstance().addPartialTarget(this.searchButton);
    



    this.session.setAttribute("FacilitatorCode", null);
    
    this.session.setAttribute("MedPolicy", null);
    this.searchDesc.setValue(null);
    AdfFacesContext.getCurrentInstance().addPartialTarget(this.searchDesc);
  }
  
  public void polListener(ValueChangeEvent valueChangeEvent)
  {
    if (this.rdPol.getValue() != null) {
      if (this.rdPol.isSelected())
      {
        this.session.setAttribute("PaymentsFlag", "P");
        ADFUtils.findIterator("FindMedicalPaymentsQueryIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.searchLOV);
      }
    }
    this.searchButton.setDisabled(false);
    AdfFacesContext.getCurrentInstance().addPartialTarget(this.searchButton);
    



    this.session.setAttribute("FacilitatorCode", null);
    
    this.session.setAttribute("MedPolicy", null);
    this.searchDesc.setValue(null);
    AdfFacesContext.getCurrentInstance().addPartialTarget(this.searchDesc);
  }
  
  public void allRecListener(ValueChangeEvent valueChangeEvent)
  {
    this.searchButton.setDisabled(true);
    AdfFacesContext.getCurrentInstance().addPartialTarget(this.searchButton);
    

    this.session.setAttribute("FacilitatorCode", null);
    
    this.session.setAttribute("MedPolicy", null);
    this.searchDesc.setValue(null);
    AdfFacesContext.getCurrentInstance().addPartialTarget(this.searchDesc);
  }
  
  public void MedPaymentsSearchListener(ValueChangeEvent valueChangeEvent)
  {
    if (valueChangeEvent.getOldValue() != valueChangeEvent.getNewValue()) {
      if (this.rdSearch.getValue().toString().equalsIgnoreCase("A"))
      {
        this.searchButton.setDisabled(true);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.searchButton);
        
        this.session.setAttribute("FacilitatorCode", null);
        this.session.setAttribute("MedPolicy", null);
        this.searchDesc.setValue(null);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.searchDesc);
      }
      else if (this.rdSearch.getValue().toString().equalsIgnoreCase("P"))
      {
        this.session.setAttribute("PaymentsFlag", "P");
        this.searchButton.setDisabled(false);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.searchButton);
        
        this.session.setAttribute("FacilitatorCode", null);
        this.session.setAttribute("MedPolicy", null);
        this.searchDesc.setValue(null);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.searchDesc);
      }
      else if (this.rdSearch.getValue().toString().equalsIgnoreCase("F"))
      {
        this.session.setAttribute("PaymentsFlag", "F");
        this.searchButton.setDisabled(false);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.searchButton);
        
        this.session.setAttribute("FacilitatorCode", null);
        this.session.setAttribute("MedPolicy", null);
        this.searchDesc.setValue(null);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.searchDesc);
      }
    }
  }
  
  public String ShowMedicalPopup()
  {
    ADFUtils.findIterator("FindMedicalPaymentsQueryIterator").executeQuery();
    AdfFacesContext.getCurrentInstance().addPartialTarget(this.searchLOV);
    
    GlobalCC.showPopup("lmsgroup:p1");
    return null;
  }
  
  public void setRdFac(RichSelectBooleanRadio rdFac)
  {
    this.rdFac = rdFac;
  }
  
  public RichSelectBooleanRadio getRdFac()
  {
    return this.rdFac;
  }
  
  public void setRdPol(RichSelectBooleanRadio rdPol)
  {
    this.rdPol = rdPol;
  }
  
  public RichSelectBooleanRadio getRdPol()
  {
    return this.rdPol;
  }
  
  public void setRdAll(RichSelectBooleanRadio rdAll)
  {
    this.rdAll = rdAll;
  }
  
  public RichSelectBooleanRadio getRdAll()
  {
    return this.rdAll;
  }
  
  public void setSearchButton(RichCommandButton searchButton)
  {
    this.searchButton = searchButton;
  }
  
  public RichCommandButton getSearchButton()
  {
    return this.searchButton;
  }
  
  public void setAllPaymentsLOV(RichTable allPaymentsLOV)
  {
    this.allPaymentsLOV = allPaymentsLOV;
  }
  
  public RichTable getAllPaymentsLOV()
  {
    return this.allPaymentsLOV;
  }
  
  public void setPaymentsTab(RichPanelBox paymentsTab)
  {
    this.paymentsTab = paymentsTab;
  }
  
  public RichPanelBox getPaymentsTab()
  {
    return this.paymentsTab;
  }
  
  public void setSearchLOV(RichTable searchLOV)
  {
    this.searchLOV = searchLOV;
  }
  
  public RichTable getSearchLOV()
  {
    return this.searchLOV;
  }
  
  public void setSearchDesc(RichInputText searchDesc)
  {
    this.searchDesc = searchDesc;
  }
  
  public RichInputText getSearchDesc()
  {
    return this.searchDesc;
  }
  
  public void setPayCbox(RichSelectBooleanCheckbox payCbox)
  {
    this.payCbox = payCbox;
  }
  
  public RichSelectBooleanCheckbox getPayCbox()
  {
    return this.payCbox;
  }
  
  public void payListener(ValueChangeEvent valueChangeEvent)
  {
    if (this.payCbox.isSelected()) {
      AddRow();
    } else {
      RemoveRow();
    }
  }
  
  public void setFacilitatorTab(RichPanelBox facilitatorTab)
  {
    this.facilitatorTab = facilitatorTab;
  }
  
  public RichPanelBox getFacilitatorTab()
  {
    return this.facilitatorTab;
  }
  
  public void setFacPayLOV(RichTable facPayLOV)
  {
    this.facPayLOV = facPayLOV;
  }
  
  public RichTable getFacPayLOV()
  {
    return this.facPayLOV;
  }
  
  public void setTransType(RichSelectOneChoice transType)
  {
    this.transType = transType;
  }
  
  public RichSelectOneChoice getTransType()
  {
    return this.transType;
  }
  
  public void setEffDate(RichInputDate effDate)
  {
    this.effDate = effDate;
  }
  
  public RichInputDate getEffDate()
  {
    return this.effDate;
  }
  
  public void policyMemberListener(SelectionEvent selectionEvent)
  {
    DCIteratorBinding dciter = ADFUtils.findIterator("FindPolicyFCLMembersIterator");
    RowKeySet set = selectionEvent.getAddedSet();
    Iterator rowKeySetIter = set.iterator();
    while (rowKeySetIter.hasNext())
    {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();
      


      this.session.setAttribute("PolmCode", r.getAttribute("POLM_CODE"));
      this.session.setAttribute("PolmMemCode", r.getAttribute("POLM_MEM_CODE"));
      this.session.setAttribute("dmsMemNo", r.getAttribute("POLM_MEM_NO"));
      this.session.setAttribute("dmsMemName", r.getAttribute("MEMBER_DISPLAY"));
      this.session.setAttribute("MemberSel", r.getAttribute("POLM_CODE"));
      
      ADFUtils.findIterator("FindExistingPoliciesViewIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.existPolLOV);
      
      ADFUtils.findIterator("FindClientMedicalsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.medReqLOV);
      Rendering rend = new Rendering();
      if (rend.isDmsEnabled())
      {
        ADFUtils.findIterator("findMedDocsIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.dmsDocTab);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.dmsDocTable);
      }
    }
  }
  
  public void setExistPolLOV(RichTable existPolLOV)
  {
    this.existPolLOV = existPolLOV;
  }
  
  public RichTable getExistPolLOV()
  {
    return this.existPolLOV;
  }
  
  public void setDecisionsLOV(RichTable decisionsLOV)
  {
    this.decisionsLOV = decisionsLOV;
  }
  
  public RichTable getDecisionsLOV()
  {
    return this.decisionsLOV;
  }
  
  public void setMemDecisionsLOV(RichTable memDecisionsLOV)
  {
    this.memDecisionsLOV = memDecisionsLOV;
  }
  
  public RichTable getMemDecisionsLOV()
  {
    return this.memDecisionsLOV;
  }
  
  public void setRdSearch(RichSelectOneRadio rdSearch)
  {
    this.rdSearch = rdSearch;
  }
  
  public RichSelectOneRadio getRdSearch()
  {
    return this.rdSearch;
  }
  
  public String getSelectedReport()
  {
    if (this.medQuestSelect.getValue() != null)
    {
      BigDecimal currCode = BigDecimal.valueOf(Long.valueOf(this.medQuestSelect.getValue().toString()).longValue());
      
      ReportEngine eng = new ReportEngine();
      eng.RunReportMed(currCode);
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.medReportDetail);
    }
    else
    {
      GlobalCC.errorValueNotEntered("Please select a valid medical questionnaire to generate!");
    }
    return null;
  }
  
  public String additionalMedicals()
  {
    Iterator selection = this.medTestsTable.getSelectedRowKeys().iterator();
    DCIteratorBinding rowiter = ADFUtils.findIterator("findMedTestIterator");
    
    RowSetIterator rsi = rowiter.getRowSetIterator();
    while (selection.hasNext())
    {
      Object rowKey = selection.next();
      Row row = rsi.getCurrentRow();
      this.medTestsTable.setRowKey(rowKey);
      
      BigDecimal mtlCode = (BigDecimal)row.getAttribute("MTLCode");
      DBConnector datahandler = null;
      datahandler = new DBConnector();
      
      Connection conn = datahandler.getDatabaseConn();
      
      CallableStatement cst = null;
      try
      {
        String medicalQuery = "begin LMS_WEB_PKG_GRP.Add_unreq_medicals(?,?,?,?,?,?); end;";
        
        cst = conn.prepareCall(medicalQuery);
        
        cst.setBigDecimal(1, (BigDecimal)this.session.getAttribute("policyCode"));
        
        cst.setBigDecimal(2, null);
        cst.setBigDecimal(3, mtlCode);
        cst.setBigDecimal(4, null);
        if (this.unrequestedMedicals.isSelected()) {
          cst.setString(5, "U");
        }
        if (this.additionalMedicals.isSelected()) {
          cst.setString(5, "A");
        }
        cst.setBigDecimal(6, (BigDecimal)this.session.getAttribute("PolmCode"));
        
        cst.execute();
        cst.close();
        conn.commit();
        conn.close();
        ADFUtils.findIterator("findMedTestIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.medTestsTable);
        
        ADFUtils.findIterator("FindClientMedicalsIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.medReqLOV);
      }
      catch (Exception e)
      {
        GlobalCC.EXCEPTIONREPORTING(conn, e);
      }
    }
    return null;
  }
  
  public void setAdditionalMedicals(RichSelectBooleanRadio additionalMedicals)
  {
    this.additionalMedicals = additionalMedicals;
  }
  
  public RichSelectBooleanRadio getAdditionalMedicals()
  {
    return this.additionalMedicals;
  }
  
  public void setUnrequestedMedicals(RichSelectBooleanRadio unrequestedMedicals)
  {
    this.unrequestedMedicals = unrequestedMedicals;
  }
  
  public RichSelectBooleanRadio getUnrequestedMedicals()
  {
    return this.unrequestedMedicals;
  }
  
  public void setMedTestsTable(RichTable medTestsTable)
  {
    this.medTestsTable = medTestsTable;
  }
  
  public RichTable getMedTestsTable()
  {
    return this.medTestsTable;
  }
  
  public void setResultDate(RichInputDate resultDate)
  {
    this.resultDate = resultDate;
  }
  
  public RichInputDate getResultDate()
  {
    return this.resultDate;
  }
  
  public void setMedQuestSelect(RichSelectOneChoice medQuestSelect)
  {
    this.medQuestSelect = medQuestSelect;
  }
  
  public RichSelectOneChoice getMedQuestSelect()
  {
    return this.medQuestSelect;
  }
  
  public void setMedReportDetail(RichShowDetailItem medReportDetail)
  {
    this.medReportDetail = medReportDetail;
  }
  
  public RichShowDetailItem getMedReportDetail()
  {
    return this.medReportDetail;
  }
  
  public String viewCoverDetails()
  {
    try
    {
      DCIteratorBinding dciter = ADFUtils.findIterator("FindPolicyMembersIterator");
      
      RowKeySet set = this.memDetailsTab.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      while (rowKeySetIter.hasNext())
      {
        List l = (List)rowKeySetIter.next();
        Key key = (Key)l.get(0);
        dciter.setCurrentRowWithKey(key.toStringFormat(true));
        Row r = dciter.getCurrentRow();
        this.session.setAttribute("memNoSearch", r.getAttribute("POLM_MEM_NO"));
        System.out.println("memNoSearch: " + this.session.getAttribute("memNoSearch").toString());
        
        GlobalCC.RedirectPage("/coverdtls.jspx");
      }
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
    return null;
  }
  
  public String upLoadDocToDms()
  {
    FacesContext context = FacesContext.getCurrentInstance();
    
    ServletContext sc = (ServletContext)context.getExternalContext().getContext();
    
    UploadedFile newFile = (UploadedFile)this.dmsFileToUpload.getValue();
    if (this.session.getAttribute("dmsMemNo") == null)
    {
      GlobalCC.errorValueNotEntered("Please select a member requiring medicals!");
    }
    else
    {
      if (this.session.getAttribute("rdCode") == null)
      {
        GlobalCC.errorValueNotEntered("Please select the document type being uploaded");
        return null;
      }
      BigDecimal rdCode = (BigDecimal)this.session.getAttribute("rdCode");
      
      EcmUtil ecmUtil = new EcmUtil();
      String fileName = newFile.getFilename();
      try
      {
        String file = "/Reports/" + fileName;
        
        file = sc.getRealPath(file);
        File toUpload = new File(file);
        InputStream inputStream = newFile.getInputStream();
        
        OutputStream out = new FileOutputStream(toUpload);
        int read = 0;
        
        byte[] bytes = new byte[1024];
        while ((read = inputStream.read(bytes)) != -1) {
          out.write(bytes, 0, read);
        }
        inputStream.close();
        out.flush();
        out.close();
        
        String mimetype = newFile.getContentType();
        String aspect = "D:tqlms:grpMedicalReportType, P:tqlms:medicalreportData";
        String clientName = (String)this.session.getAttribute("polClient");
        Session ecmSession = ecmUtil.Authentification();
        if (ecmSession == null)
        {
          GlobalCC.errorValueNotEntered("Please Check alfresco connection : Can't Connect to alfresco!!");
          return null;
        }
        String policyNo = String.valueOf(this.session.getAttribute("dmsPolNo"));
        String policyNo2 = String.valueOf(this.session.getAttribute("dmsPolNo"));
        String memNo = String.valueOf(this.session.getAttribute("dmsMemNo"));
        String memName = String.valueOf(this.session.getAttribute("dmsMemName"));
        
        policyNo = policyNo.replace("/", "_");
        boolean checkLms = ecmUtil.checkDir(ecmSession, "/TQLMSGRP");
        if (!checkLms) {
          ecmUtil.createDirInRootFolder(ecmSession, "TQLMSGRP");
        }
        String filePath = "/TQLMSGRP/MEDICALS/" + policyNo;
        boolean check = ecmUtil.checkDir(ecmSession, filePath);
        if (!check)
        {
          CmisObject objectLms = ecmSession.getObjectByPath("/TQLMSGRP/MEDICALS");
          Folder folderLms = (Folder)objectLms;
          String fpath = policyNo;
          ecmUtil.createDir(ecmSession, folderLms, fpath);
        }
        filePath = filePath + "/" + memNo.replace("/", "_");
        boolean check1 = ecmUtil.checkDir(ecmSession, filePath);
        if (!check1)
        {
          CmisObject objectPolAuth = ecmSession.getObjectByPath("/TQLMSGRP/MEDICALS/" + policyNo);
          
          Folder folderLms = (Folder)objectPolAuth;
          String fpath = memNo.replace("/", "_");
          ecmUtil.createDir(ecmSession, folderLms, fpath);
        }
        CmisObject object = ecmSession.getObjectByPath(filePath);
        Folder folder = (Folder)object;
        

        fileName = filePath + "/" + fileName;
        List<EcmProps> properties = new ArrayList();
        properties.add(new EcmProps("tqlms:grpPolicyNumber", policyNo2));
        properties.add(new EcmProps("tqlms:grpclientname", clientName));
        properties.add(new EcmProps("tqlms:grpMemberNumber", memNo));
        properties.add(new EcmProps("tqlms:grpMemberName", memName));
        properties.add(new EcmProps("tqlms:grpmedicalreportdate", null));
        properties.add(new EcmProps("tqlms:grpmeddoccode", rdCode.toString()));
        try
        {
          EcmTrans.UploadFile(ecmSession, folder, toUpload.getName(), toUpload, mimetype, aspect, properties);
        }
        catch (Exception e)
        {
          GlobalCC.hidePopup("lmsgroup:dmsUpdPop");
          AdfFacesContext.getCurrentInstance().addPartialTarget(this.dmsFileToUpload);
          GlobalCC.alfrescoError(e);
          return null;
        }
        this.dmsFileToUpload.setValue(null);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.dmsFileToUpload);
        ADFUtils.findIterator("findMedDocsIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.dmsDocTable);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.dmsDocTab);
        
        GlobalCC.hidePopup("lmsgroup:dmsUpdPop");
        GlobalCC.sysInformation("Record Saved Successfully!");
      }
      catch (NullPointerException e)
      {
        GlobalCC.hidePopup("lmsgroup:dmsUpdPop");
        this.dmsFileToUpload.setValue(null);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.dmsFileToUpload);
      }
      catch (IOException e)
      {
        this.dmsFileToUpload.setValue(null);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.dmsFileToUpload);
        GlobalCC.hidePopup("lmsgroup:dmsUpdPop");
        e.printStackTrace();
      }
      catch (Exception e)
      {
        this.dmsFileToUpload.setValue(null);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.dmsFileToUpload);
        GlobalCC.hidePopup("lmsgroup:dmsUpdPop");
        e.printStackTrace();
      }
    }
    return null;
  }
  
  public String upLoadDocToDms2()
  {
    FacesContext context = FacesContext.getCurrentInstance();
    
    ServletContext sc = (ServletContext)context.getExternalContext().getContext();
    
    UploadedFile newFile = (UploadedFile)this.dmsFileToUpload.getValue();
    if (this.session.getAttribute("dmsMemNo") == null)
    {
      GlobalCC.errorValueNotEntered("Please select a member requiring medicals!");
    }
    else
    {
      if (this.session.getAttribute("rdCode") == null)
      {
        GlobalCC.errorValueNotEntered("Please select the document type being uploaded");
        return null;
      }
      BigDecimal rdCode = (BigDecimal)this.session.getAttribute("rdCode");
      
      EcmUtil ecmUtil = new EcmUtil();
      String fileName = newFile.getFilename();
      try
      {
        String file = "/Reports/" + fileName;
        
        file = sc.getRealPath(file);
        File toUpload = new File(file);
        InputStream inputStream = newFile.getInputStream();
        
        OutputStream out = new FileOutputStream(toUpload);
        int read = 0;
        
        byte[] bytes = new byte[(int)toUpload.length()];
        while ((read = inputStream.read(bytes)) != -1) {
          out.write(bytes, 0, read);
        }
        String mimetype = newFile.getContentType();
        String aspect = "tqlms:medicalreportData";
        String clientName = (String)this.session.getAttribute("polClient");
        Session ecmSession = ecmUtil.Authentification();
        if (ecmSession == null)
        {
          GlobalCC.errorValueNotEntered("Please Check alfresco connection : Can't Connect to alfresco!!");
          return null;
        }
        String policyNo = String.valueOf(this.session.getAttribute("dmsPolNo"));
        String policyNo2 = String.valueOf(this.session.getAttribute("dmsPolNo"));
        String memNo = String.valueOf(this.session.getAttribute("dmsMemNo"));
        String memName = String.valueOf(this.session.getAttribute("dmsMemName"));
        
        policyNo = policyNo.replace("/", "_");
        boolean checkLms = ecmUtil.checkDir(ecmSession, "/TQLMSGRP");
        if (!checkLms) {
          ecmUtil.createDirInRootFolder(ecmSession, "TQLMSGRP");
        }
        String filePath = "/TQLMSGRP/MEDICALS/" + policyNo;
        boolean check = ecmUtil.checkDir(ecmSession, filePath);
        if (!check)
        {
          CmisObject objectLms = ecmSession.getObjectByPath("/TQLMSGRP/MEDICALS");
          Folder folderLms = (Folder)objectLms;
          String fpath = policyNo;
          ecmUtil.createDir(ecmSession, folderLms, fpath);
        }
        filePath = filePath + "/" + memNo.replace("/", "_");
        boolean check1 = ecmUtil.checkDir(ecmSession, filePath);
        if (!check1)
        {
          CmisObject objectPolAuth = ecmSession.getObjectByPath("/TQLMSGRP/MEDICALS/" + policyNo);
          
          Folder folderLms = (Folder)objectPolAuth;
          String fpath = memNo.replace("/", "_");
          ecmUtil.createDir(ecmSession, folderLms, fpath);
        }
        CmisObject object = ecmSession.getObjectByPath(filePath);
        Folder folder = (Folder)object;
        ecmUtil.upLoadFile(ecmSession, folder, fileName, mimetype, toUpload);
        
        fileName = filePath + "/" + fileName;
        Document docCov = ecmUtil.addAnAspectToDocument(aspect, fileName, ecmSession);
        

        ecmUtil.updateMetadata(docCov, aspect, "tqlms:grpPolicyNumber", policyNo2);
        
        ecmUtil.updateMetadata(docCov, aspect, "tqlms:grpclientname", clientName);
        
        ecmUtil.updateMetadata(docCov, aspect, "tqlms:grpMemberNumber", memNo);
        
        ecmUtil.updateMetadata(docCov, aspect, "tqlms:grpMemberName", memName);
        

        ecmUtil.updateMetadata(docCov, aspect, "tqlms:grpmedicalreportdate", rdCode.toString());
        

        ecmUtil.updateMetadata(docCov, aspect, "tqlms:grpmeddoccode", rdCode.toString());
        
        inputStream.close();
        out.flush();
        out.close();
        
        this.dmsFileToUpload.setValue(null);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.dmsFileToUpload);
        ADFUtils.findIterator("findMedDocsIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.dmsDocTable);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.dmsDocTab);
        
        GlobalCC.hidePopup("lmsgroup:dmsUpdPop");
        GlobalCC.sysInformation("Record Saved Successfully!");
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
    return null;
  }
  
  public String updateMedDocDms()
  {
    String docid = (String)this.session.getAttribute("docId");
    String memNum = null;
    try
    {
      DCIteratorBinding dciter = ADFUtils.findIterator("FindPolicyMembersIterator");
      
      RowKeySet set = this.memDetailsTab.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      while (rowKeySetIter.hasNext())
      {
        List l = (List)rowKeySetIter.next();
        Key key = (Key)l.get(0);
        dciter.setCurrentRowWithKey(key.toStringFormat(true));
        Row r = dciter.getCurrentRow();
        this.session.setAttribute("dmsMemNo", r.getAttribute("POLM_MEM_NO"));
        this.session.setAttribute("dmsMemName", r.getAttribute("MEMBER_DISPLAY"));
      }
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
    EcmUtil ecmUtil = new EcmUtil();
    if (docid != null)
    {
      Session ecmSession = ecmUtil.Authentification();
      if (ecmSession != null)
      {
        Document document = (Document)ecmSession.getObject(docid);
        AlfrescoDocument alfDoc = (AlfrescoDocument)document;
        String aspectname = "P:tqlms:medicalreportData";
        alfDoc.addAspect(new String[] { aspectname });
        Map<String, Object> properties = new HashMap();
        

        properties.put("tqlms:grpPolicyNumber", this.session.getAttribute("dmsPolNo"));
        
        properties.put("tqlms:grpclientname", this.session.getAttribute("polClient"));
        
        properties.put("tqlms:grpMemberNumber", this.session.getAttribute("dmsMemNo"));
        
        properties.put("tqlms:grpMemberName", this.session.getAttribute("dmsMemName"));
        

        alfDoc.updateProperties(properties);
      }
      ProcessDMSTicket dbConn = new ProcessDMSTicket();
      OracleConnection conn = null;
      conn = dbConn.getDatabaseConnection();
      PreparedStatement stmt = null;
      
      String query = "update lms_dms_documents set dd_processed = 'Y' where dd_doc_id = ?";
      try
      {
        stmt = conn.prepareStatement(query);
        stmt.setString(1, docid);
        stmt.execute();
        conn.commit();
        conn.close();
        this.session.removeAttribute("dmsDocId");
        this.session.setAttribute("dmsProcess", null);
        this.session.setAttribute("dmsProcessType", "");
        ADFUtils.findIterator("findMedDocsIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.dmsDocTable);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.dmsDocTab);
        
        GlobalCC.sysInformation("Document Updated Successfully!");
      }
      catch (SQLException e)
      {
        e.printStackTrace();
        GlobalCC.EXCEPTIONREPORTING(conn, e);
      }
    }
    return null;
  }
  
  public String newDmsDoc()
  {
    this.session.setAttribute("docType", "POLDOC");
    if (this.session.getAttribute("dmsMemNo") == null)
    {
      GlobalCC.errorValueNotEntered("Please select a member requiring medicals!");
    }
    else
    {
      ADFUtils.findIterator("FindOccupationIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.lmsDocType);
      GlobalCC.showPopup("lmsgroup:dmsUpdPop");
    }
    return null;
  }
  
  public String refreshDms()
  {
    ADFUtils.findIterator("findMedDocsIterator").executeQuery();
    AdfFacesContext.getCurrentInstance().addPartialTarget(this.dmsDocTab);
    AdfFacesContext.getCurrentInstance().addPartialTarget(this.dmsDocTable);
    return null;
  }
  
  public String generateDoc()
  {
    Object key2 = this.dmsDocTable.getSelectedRowData();
    
    JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
    if (r == null)
    {
      GlobalCC.errorValueNotEntered("No Record Selected");
      return null;
    }
    String filename = (String)r.getAttribute("actualName");
    String id = (String)r.getAttribute("id");
    System.out.println("Doc Id " + id + " file name " + filename);
    
    EcmUtil ecmUtil = new EcmUtil();
    try
    {
      Session sessions = ecmUtil.Authentification();
      
      Document document = (Document)sessions.getObject(id);
      InputStream inputStream = document.getContentStream().getStream();
      String file = "/Reports/" + filename;
      FacesContext context = FacesContext.getCurrentInstance();
      ServletContext sc = (ServletContext)context.getExternalContext().getContext();
      
      file = sc.getRealPath(file);
      System.out.println("");
      File toPrint = new File(file);
      

      OutputStream out = new FileOutputStream(toPrint);
      int read = 0;
      byte[] bytes = new byte[20480];
      while ((read = inputStream.read(bytes)) != -1) {
        out.write(bytes, 0, read);
      }
      inputStream.close();
      out.flush();
      out.close();
      if (toPrint != null)
      {
        HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        
        String scheme = request.getScheme();
        String serverName = request.getServerName();
        int portNumber = request.getServerPort();
        String contextPath = request.getContextPath();
        String url = scheme + "://" + serverName + ":" + portNumber + contextPath + "/viewer.html";
        

        String pdf = "?file=" + scheme + "://" + serverName + ":" + portNumber + contextPath + "/Reports/" + filename;
        

        this.session.setAttribute("toPrint", url + pdf);
        System.out.println(url + pdf);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.medViewer);
        
        ExtendedRenderKitService erkService = (ExtendedRenderKitService)Service.getService(FacesContext.getCurrentInstance().getRenderKit(), ExtendedRenderKitService.class);
        

        erkService.addScript(FacesContext.getCurrentInstance(), "var hints = {autodismissNever:false}; AdfPage.PAGE.findComponent('lmsgroup:viewdoc').show(hints);");
      }
    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    return null;
  }
  
  public void docTypeSelectionChanged(ValueChangeEvent valueChangeEvent)
  {
    try
    {
      if (valueChangeEvent.getNewValue() != valueChangeEvent.getOldValue())
      {
        BigDecimal rdCodeVal = new BigDecimal(0);
        System.out.print("rdCode = ");
        System.out.println(rdCodeVal);
        
        this.session.setAttribute("rdCode", rdCodeVal);
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
  
  public void setMemDetailsTab(RichTable memDetailsTab)
  {
    this.memDetailsTab = memDetailsTab;
  }
  
  public RichTable getMemDetailsTab()
  {
    return this.memDetailsTab;
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
  
  public void setDmsFileToUpload(RichInputFile dmsFileToUpload)
  {
    this.dmsFileToUpload = dmsFileToUpload;
  }
  
  public RichInputFile getDmsFileToUpload()
  {
    return this.dmsFileToUpload;
  }
  
  public void setLmsDocType(RichSelectOneChoice lmsDocType)
  {
    this.lmsDocType = lmsDocType;
  }
  
  public RichSelectOneChoice getLmsDocType()
  {
    return this.lmsDocType;
  }
  
  public void setDmsDocTab(RichShowDetailItem dmsDocTab)
  {
    this.dmsDocTab = dmsDocTab;
  }
  
  public RichShowDetailItem getDmsDocTab()
  {
    return this.dmsDocTab;
  }
  
  public void setDmsDocTable(RichTable dmsDocTable)
  {
    this.dmsDocTable = dmsDocTable;
  }
  
  public RichTable getDmsDocTable()
  {
    return this.dmsDocTable;
  }
  
  public void setMedViewer(RichInlineFrame medViewer)
  {
    this.medViewer = medViewer;
  }
  
  public RichInlineFrame getMedViewer()
  {
    return this.medViewer;
  }
  
  public void selectMedPayment(SelectionEvent selectionEvent)
  {
     DMSUtils utils = new DMSUtils();
    Object key2 = this.facPayLOV.getSelectedRowData();
    if (key2 == null) {
      GlobalCC.errorValueNotEntered("No Record Selected");
    }
    JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
    if (r == null) {
      GlobalCC.errorValueNotEntered("No Record Selected");
    }
    this.session.setAttribute("fmptCode", r.getAttribute("FPMT_CODE"));
    this.session.setAttribute("FacilitatorCode", utils.findFacilitatorCode()); 
  }

    public void approvedMedicalListener(SelectionEvent selectionEvent) {
        // Add event code here...
        DMSUtils utils = new DMSUtils();
        Object key2 = this.approvedMedicalLOV.getSelectedRowData();
        if (key2 == null) {
         GlobalCC.errorValueNotEntered("No Record Selected");
        }
        JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
        if (r == null) {
         GlobalCC.errorValueNotEntered("No Record Selected");
        }
        this.session.setAttribute("fmptCode", r.getAttribute("FPMT_CODE"));
        this.session.setAttribute("FacilitatorCode", utils.findFacilitatorCode());
        System.out.println("Facilitator Code is ====="+utils.findFacilitatorCode());
    }

    public void setApprovedMedicalLOV(RichTable approvedMedicalLOV) {
        this.approvedMedicalLOV = approvedMedicalLOV;
    }

    public RichTable getApprovedMedicalLOV() {
        return approvedMedicalLOV;
    }

    public String deletePendingPayment() {
      Connection conn=null;
      DBConnector datahandler = null;
      datahandler = new DBConnector();
      CallableStatement cstmt=null;
      String sql="begin lms_web_pkg_grp.deletependingmedpayment(?);end;";
      try{
       conn = datahandler.getDatabaseConn();
       cstmt=conn.prepareCall(sql);
         cstmt.setBigDecimal(1,(BigDecimal)session.getAttribute("fmptCode"));
         cstmt.execute();
        GlobalCC.CloseConnections(null, cstmt, conn);
        GlobalCC.INFORMATIONREPORTING("Record deleted successfully...");
        
         ADFUtils.findIterator("FindMedicalPaymentsIterator").executeQuery();
         AdfFacesContext.getCurrentInstance().addPartialTarget(this.allPaymentsLOV);         
         ADFUtils.findIterator("FindFacilitatorPaymentsIterator").executeQuery();
         AdfFacesContext.getCurrentInstance().addPartialTarget(this.facPayLOV);
        
       }catch(Exception ex){       
         ex.printStackTrace();
         GlobalCC.EXCEPTIONREPORTING(conn, ex);
         GlobalCC.CloseConnections(null, cstmt, conn);
         
       }finally{
         GlobalCC.CloseConnections(null, cstmt, conn);
       }
        // Add event code here...
        return null;
    }
}
