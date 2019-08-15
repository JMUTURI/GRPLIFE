package LMSG.view.Accounts;

import LMSG.view.Base.ADFUtils;
import LMSG.view.Base.GlobalCC;
import LMSG.view.Base.LOVCC;
import LMSG.view.TableTypes.ReceiptCommissions;
import LMSG.view.connect.DBConnector;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpSession;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanCheckbox;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanRadio;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.layout.RichPanelBox;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.output.RichOutputLabel;
import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.uicli.binding.JUCtrlValueBinding;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import org.apache.myfaces.trinidad.event.DisclosureEvent;
import org.apache.myfaces.trinidad.event.SelectionEvent;
import org.apache.myfaces.trinidad.model.RowKeySet;

public class TransactionAlloc
  extends LOVCC
{
  private RichTable productsLOV;
  private RichInputText productDesc;
  private RichInputText policiesDesc;
  private RichTable policiesLOV;
  private RichTable crdtTransLOV;
  private RichTable crdtAllocLOV;
  private RichTable dbtTransLOV;
  private RichTable dbtAllocLOV;
  private RichTable transSettledLOV;
  private RichTable commLOV;
  private RichPanelBox results;
  private static Integer Num = Integer.valueOf(0);
  protected static BigDecimal[][] DebitAllocationCode = new BigDecimal[20][2];
  protected static String[] DebitAllocation = new String[20];
  protected static int t = 0;
  private RichSelectBooleanCheckbox knockCbox;
  HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
  private RichInputDate dateFrom;
  private RichInputDate dateTo;
  private RichInputText agentsDisplay;
  private RichTable agentDisplayLOV;
  private RichOutputText refNo;
  private RichSelectOneChoice allocMode;
  private RichSelectBooleanCheckbox cknockCbox;
  private RichTable coinsAlloc;
  private RichTable refundsAlloc;
  private RichSelectOneChoice commPymtMode;
  private RichPanelBox recptInstallTab;
  private RichPanelBox commPymtTab;
  private RichInputText accountDisplay;
  private RichTable accountsLOV;
  private RichInputText agenDisplay;
  private RichCommandButton accountSelection;
  private RichTable agentsLOV;
  private RichSelectBooleanRadio policyRadio;
  private RichSelectBooleanRadio accountRadio;
  private RichOutputLabel accTypeLab;
  private HtmlPanelGrid accTypeGrid;
  private RichOutputLabel accLabel;
  private HtmlPanelGrid accGrid;
  private RichCommandButton accSearchBtn;
  private RichOutputLabel polSelectionLab;
  private HtmlPanelGrid polGrid;
  private RichPanelBox transAllocPanel;
  private RichSelectOneChoice chqTransType;
  private RichInputDate chqDateFrom;
  private RichInputDate chqDateTo;
  private RichTable chqStatusesLOV;
  private RichInputText memNo;
  private RichInputText payeeName;
  private RichInputText memName;
  private RichInputText clmNo;
  
  public String findPoliciesSelected()
  {
    DCIteratorBinding dciter = ADFUtils.findIterator("findPoliciesToAllocateIterator");
    RowKeySet set = this.policiesLOV.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();
    while (rowKeySetIter.hasNext())
    {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();
      
      this.policiesDesc.setValue(r.getAttribute("POL_POLICY_NO"));
      this.session.setAttribute("policyCode", r.getAttribute("POL_CODE"));
      this.session.setAttribute("CoinsPolicy", r.getAttribute("ENDR_COINSURANCE"));
      
      ADFUtils.findIterator("findCreditTransIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.crdtTransLOV);
      
      ADFUtils.findIterator("findCreditToAllocIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.crdtAllocLOV);
      
      ADFUtils.findIterator("findDebitTransactionsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.dbtTransLOV);
      
      ADFUtils.findIterator("findDebitToAllocIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.dbtAllocLOV);
      
      ADFUtils.findIterator("findTransactionsSettledIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.transSettledLOV);
      
      ADFUtils.findIterator("findPolicyCommissionIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.commLOV);
      
      this.session.setAttribute("coinsLevel", "T");
      ADFUtils.findIterator("FindPolicyCoinsurersIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.coinsAlloc);
      
      ADFUtils.findIterator("findCoinAllocRefundsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.refundsAlloc);
      
      t = 0;
      Num = Integer.valueOf(0);
      this.results.setRendered(true);
    }
    return null;
  }
  
  public String SaveAllocationMode()
  {
    String fclQuery = "BEGIN LMS_WEB_PKG_GRP_UW.alterAllocationMode(?,?);END;";
    Connection conn = new DBConnector().getDatabaseConn();
    CallableStatement cst = null;
    try
    {
      cst = conn.prepareCall(fclQuery);
      cst.setBigDecimal(1, (BigDecimal)this.session.getAttribute("CRAMTRANCODE"));
      if (this.allocMode.getValue() == null) {
        cst.setString(2, null);
      } else {
        cst.setString(2, this.allocMode.getValue().toString());
      }
      cst.execute();
      
      ADFUtils.findIterator("findCreditToAllocIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.crdtAllocLOV);
      
      cst.close();
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
  }
  
  public String AllocateCredits()
  {
    String fclQuery = "BEGIN LMS_WEB_PKG_GRP_UW.knock_off_transactions(?,?,?,?,?,?,?);END;";
    Connection conn = new DBConnector().getDatabaseConn();
    CallableStatement cst = null;
    try
    {
      int rowCount = 0;
      int DebitCount = 0;
      boolean Value = false;
      String AllocationType = (String)this.session.getAttribute("allocationType");
      if (AllocationType == null) {
        AllocationType = "ND";
      }
      if (AllocationType.equalsIgnoreCase("ND"))
      {
        fclQuery = "BEGIN LMS_WEB_PKG_GRP_UW.knock_off_transactions(?,?,?,?,?,?,?);END;";
        
        rowCount = this.dbtAllocLOV.getRowCount();
        if (rowCount == 0) {
          return null;
        }
        cst = conn.prepareCall(fclQuery);
        for (int i = 0; i < rowCount; i++)
        {
          this.dbtAllocLOV.setRowIndex(i);
          JUCtrlValueBinding nodeBinding = (JUCtrlValueBinding)this.dbtAllocLOV.getRowData();
          if (nodeBinding != null)
          {
            Value = ((Boolean)nodeBinding.getAttribute("selected")).booleanValue();
            if (Value == true)
            {
              DebitCount++;
              cst.setBigDecimal(1, (BigDecimal)this.session.getAttribute("policyCode"));
              cst.setBigDecimal(2, (BigDecimal)this.session.getAttribute("CRAMTRANCODE"));
              cst.setString(3, (String)this.session.getAttribute("craRefNo"));
              cst.setString(4, (String)this.session.getAttribute("craAmount"));
              cst.setInt(5, DebitCount);
              cst.setBigDecimal(6, (BigDecimal)nodeBinding.getAttribute("DBA_MTRAN_CODE"));
              cst.setString(7, "Y");
              cst.execute();
            }
          }
        }
        if (DebitCount == 0)
        {
          GlobalCC.INFORMATIONREPORTING("No debit record selected");
          return null;
        }
      }
      else if (AllocationType.equalsIgnoreCase("CD"))
      {
        fclQuery = "BEGIN LMS_WEB_PKG_GRP_UW.knock_off_coin_transactions(?,?,?,?,?,?);END;";
        rowCount = this.coinsAlloc.getRowCount();
        if (rowCount == 0) {
          return null;
        }
        cst = conn.prepareCall(fclQuery);
        for (int i = 0; i < rowCount; i++)
        {
          this.coinsAlloc.setRowIndex(i);
          JUCtrlValueBinding nodeBinding = (JUCtrlValueBinding)this.coinsAlloc.getRowData();
          if (nodeBinding != null)
          {
            Value = ((Boolean)nodeBinding.getAttribute("selected")).booleanValue();
            if (Value == true)
            {
              DebitCount++;
              cst.setBigDecimal(1, (BigDecimal)this.session.getAttribute("policyCode"));
              cst.setBigDecimal(2, (BigDecimal)nodeBinding.getAttribute("pol_coin_code"));
              cst.setBigDecimal(3, (BigDecimal)this.session.getAttribute("CRAMTRANCODE"));
              cst.setString(4, (String)this.session.getAttribute("craRefNo"));
              cst.setString(5, (String)this.session.getAttribute("craAmount"));
              cst.setString(6, "Y");
              cst.execute();
            }
          }
        }
        if (DebitCount == 0)
        {
          GlobalCC.INFORMATIONREPORTING("No debit record selected");
          return null;
        }
      }
      cst.close();
      conn.close();
      
      ADFUtils.findIterator("findCreditTransIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.crdtTransLOV);
      
      ADFUtils.findIterator("findCreditToAllocIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.crdtAllocLOV);
      
      ADFUtils.findIterator("findDebitTransactionsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.dbtTransLOV);
      
      ADFUtils.findIterator("findDebitToAllocIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.dbtAllocLOV);
      
      ADFUtils.findIterator("findTransactionsSettledIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.transSettledLOV);
      
      ADFUtils.findIterator("findPolicyCommissionIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.commLOV);
      
      ADFUtils.findIterator("FindPolicyCoinsurersIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.coinsAlloc);
      
      ADFUtils.findIterator("findCoinAllocRefundsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.refundsAlloc);
      

      GlobalCC.INFORMATIONREPORTING("Allocation Sucessfully Completed.");
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
  }
  
  public String AuthoriseRefunds()
  {
    String fclQuery = "BEGIN LMS_API.process_coin_ref_posting(?);END;";
    Connection conn = new DBConnector().getDatabaseConn();
    CallableStatement cst = null;
    BigDecimal lprCode = null;
    try
    {
      RowKeySet rowKeySet = this.refundsAlloc.getSelectedRowKeys();
      if (rowKeySet == null) {
        return null;
      }
      if (!rowKeySet.iterator().hasNext())
      {
        GlobalCC.errorValueNotEntered("No Record Selected");
        return null;
      }
      Object key2 = rowKeySet.iterator().next();
      this.refundsAlloc.setRowKey(key2);
      JUCtrlValueBinding r = (JUCtrlValueBinding)this.refundsAlloc.getRowData();
      if (r == null)
      {
        GlobalCC.errorValueNotEntered("No Record Selected");
        return null;
      }
      lprCode = (BigDecimal)r.getAttribute("LPR_CODE");
      
      cst = conn.prepareCall(fclQuery);
      cst.setBigDecimal(1, lprCode);
      cst.execute();
      
      cst.close();
      conn.close();
      
      ADFUtils.findIterator("findCoinAllocRefundsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.refundsAlloc);
      
      GlobalCC.INFORMATIONREPORTING("Refund Successfully Authorised.");
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
  }
  
  public String UndoRefundsTransaction()
  {
    String fclQuery = "BEGIN LMS_WEB_PKG_GRP_UW.undo_coin_transactions(?);END;";
    Connection conn = new DBConnector().getDatabaseConn();
    CallableStatement cst = null;
    BigDecimal lprCode = null;
    try
    {
      RowKeySet rowKeySet = this.refundsAlloc.getSelectedRowKeys();
      if (rowKeySet == null) {
        return null;
      }
      if (!rowKeySet.iterator().hasNext())
      {
        GlobalCC.errorValueNotEntered("No Record Selected");
        return null;
      }
      Object key2 = rowKeySet.iterator().next();
      this.refundsAlloc.setRowKey(key2);
      JUCtrlValueBinding r = (JUCtrlValueBinding)this.refundsAlloc.getRowData();
      if (r == null)
      {
        GlobalCC.errorValueNotEntered("No Record Selected");
        return null;
      }
      lprCode = (BigDecimal)r.getAttribute("LPR_CODE");
      
      cst = conn.prepareCall(fclQuery);
      cst.setBigDecimal(1, lprCode);
      cst.execute();
      
      cst.close();
      conn.close();
      
      ADFUtils.findIterator("findCreditTransIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.crdtTransLOV);
      
      ADFUtils.findIterator("findCreditToAllocIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.crdtAllocLOV);
      
      ADFUtils.findIterator("findDebitTransactionsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.dbtTransLOV);
      
      ADFUtils.findIterator("findDebitToAllocIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.dbtAllocLOV);
      
      ADFUtils.findIterator("findTransactionsSettledIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.transSettledLOV);
      
      ADFUtils.findIterator("findPolicyCommissionIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.commLOV);
      
      ADFUtils.findIterator("FindPolicyCoinsurersIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.coinsAlloc);
      
      ADFUtils.findIterator("findCoinAllocRefundsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.refundsAlloc);
      
      GlobalCC.INFORMATIONREPORTING("Refund Successfully Reversed.");
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
  }
  
  public void GetSelectedCreditToAlloc(SelectionEvent selectionEvent)
  {
    try
    {
      RowKeySet rowKeySet = this.crdtAllocLOV.getSelectedRowKeys();
      if (rowKeySet == null) {
        return;
      }
      if (!rowKeySet.iterator().hasNext())
      {
        GlobalCC.errorValueNotEntered("No Record Selected");
        return;
      }
      Object key2 = rowKeySet.iterator().next();
      this.crdtAllocLOV.setRowKey(key2);
      JUCtrlValueBinding r = (JUCtrlValueBinding)this.crdtAllocLOV.getRowData();
      if (r == null)
      {
        GlobalCC.errorValueNotEntered("No Record Selected");
        return;
      }
      this.session.setAttribute("CRAMTRANCODE", r.getAttribute("CRA_MTRAN_CODE"));
      this.session.setAttribute("craRefNo", r.getAttribute("CRA_MTRAN_REF_NO"));
      this.session.setAttribute("craAmount", r.getAttribute("CRA_amount"));
      this.refNo.setValue(r.getAttribute("CRA_MTRAN_REF_NO"));
      this.allocMode.setValue(r.getAttribute("CRA_MTRAN_ALLOC_MODE"));
      

      ADFUtils.findIterator("findTransactionsSettledIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.transSettledLOV);
      
      ADFUtils.findIterator("findPolicyCommissionIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.commLOV);
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
  }
  
  public String AlterAllocationMode()
  {
    if (this.session.getAttribute("CRAMTRANCODE") == null)
    {
      GlobalCC.sysInformation("Select A Credit Transaction.");
      return null;
    }
    GlobalCC.showPopup("pt1:p1");
    return null;
  }
  
  public void knockoffListener(ValueChangeEvent valueChangeEvent)
  {
    if (valueChangeEvent.getOldValue() != valueChangeEvent.getNewValue())
    {
      RowKeySet rowKeySet = this.dbtAllocLOV.getSelectedRowKeys();
      if (rowKeySet == null) {
        return;
      }
      if (!rowKeySet.iterator().hasNext())
      {
        GlobalCC.errorValueNotEntered("No Record Selected");
        return;
      }
      Object key2 = rowKeySet.iterator().next();
      this.dbtAllocLOV.setRowKey(key2);
      JUCtrlValueBinding nodeBinding = (JUCtrlValueBinding)this.dbtAllocLOV.getRowData();
      if (nodeBinding == null)
      {
        GlobalCC.errorValueNotEntered("No Record Selected");
        return;
      }
      if (this.knockCbox.isSelected()) {
        nodeBinding.setAttribute("selected", Boolean.valueOf(true));
      } else {
        nodeBinding.setAttribute("selected", Boolean.valueOf(false));
      }
    }
  }
  
  public void CoinknockoffListener(ValueChangeEvent valueChangeEvent)
  {
    if (valueChangeEvent.getOldValue() != valueChangeEvent.getNewValue())
    {
      RowKeySet rowKeySet = this.coinsAlloc.getSelectedRowKeys();
      if (rowKeySet == null) {
        return;
      }
      if (!rowKeySet.iterator().hasNext())
      {
        GlobalCC.errorValueNotEntered("No Record Selected");
        return;
      }
      Object key2 = rowKeySet.iterator().next();
      this.coinsAlloc.setRowKey(key2);
      JUCtrlValueBinding nodeBinding = (JUCtrlValueBinding)this.coinsAlloc.getRowData();
      if (nodeBinding == null)
      {
        GlobalCC.errorValueNotEntered("No Record Selected");
        return;
      }
      if (this.cknockCbox.isSelected()) {
        nodeBinding.setAttribute("selected", Boolean.valueOf(true));
      } else {
        nodeBinding.setAttribute("selected", Boolean.valueOf(false));
      }
    }
  }
  
  public String UndoTransactionSettled()
  {
    try
    {
      BigDecimal TMAP_DR_MTRAN_CODE = null;
      BigDecimal TMAP_CODE = null;
      
      DCIteratorBinding dciter = ADFUtils.findIterator("findTransactionsSettledIterator");
      RowKeySet set = this.transSettledLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      while (rowKeySetIter.hasNext())
      {
        List l = (List)rowKeySetIter.next();
        Key key = (Key)l.get(0);
        dciter.setCurrentRowWithKey(key.toStringFormat(true));
        Row r = dciter.getCurrentRow();
        
        TMAP_DR_MTRAN_CODE = (BigDecimal)r.getAttribute("TMAP_DR_MTRAN_CODE");
        TMAP_CODE = (BigDecimal)r.getAttribute("tmap_code");
      }
      String updateQuery = "BEGIN LMS_WEB_PKG_GRP_UW.undo_transaction_allocation(?,?);END;";
      Connection conn = new DBConnector().getDatabaseConn();
      CallableStatement cstmt = conn.prepareCall(updateQuery);
      cstmt.setBigDecimal(1, TMAP_DR_MTRAN_CODE);
      cstmt.setBigDecimal(2, TMAP_CODE);
      
      cstmt.execute();
      cstmt.close();
      
      ADFUtils.findIterator("findTransactionsSettledIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.transSettledLOV);
      
      ADFUtils.findIterator("findPolicyCommissionIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.commLOV);
      
      ADFUtils.findIterator("findDebitTransactionsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.dbtTransLOV);
      
      GlobalCC.INFORMATIONREPORTING("Settlement Undone Successfully");
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
    return null;
  }
  
  public String AuthorisePayments()
  {
    Connection conn = null;
    try
    {
      String AgentDisplay = null;
      

      DCIteratorBinding dciter = ADFUtils.findIterator("findPolicyCommissionIterator");
      RowKeySet set = this.commLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      while (rowKeySetIter.hasNext())
      {
        List l = (List)rowKeySetIter.next();
        Key key = (Key)l.get(0);
        dciter.setCurrentRowWithKey(key.toStringFormat(true));
        Row r = dciter.getCurrentRow();
        
        AgentDisplay = (String)r.getAttribute("AGENT_DISPLAY");
      }
      String updateQuery = "BEGIN LMS_WEB_PKG_GRP_UW.auth_comm_pymts(?,?);END;";
      conn = new DBConnector().getDatabaseConn();
      CallableStatement cstmt = conn.prepareCall(updateQuery);
      cstmt.setBigDecimal(1, (BigDecimal)this.session.getAttribute("policyCode"));
      cstmt.setString(2, AgentDisplay);
      
      cstmt.execute();
      cstmt.close();
      
      ADFUtils.findIterator("findPolicyCommissionIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.commLOV);
      
      GlobalCC.INFORMATIONREPORTING("Authorisation of Payments Done Successfully");
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
  }
  
  public String SelectAll()
  {
    this.session.setAttribute("booleanSelect", "T");
    ADFUtils.findIterator("findReceiptedPoliciesIterator").executeQuery();
    AdfFacesContext.getCurrentInstance().addPartialTarget(this.policiesLOV);
    
    return null;
  }
  
  public String UnSelectAll()
  {
    this.session.setAttribute("booleanSelect", "F");
    ADFUtils.findIterator("findReceiptedPoliciesIterator").executeQuery();
    AdfFacesContext.getCurrentInstance().addPartialTarget(this.policiesLOV);
    
    return null;
  }
  
  public String ClearSearch()
  {
    try
    {
      this.session.setAttribute("RenDateFrom", null);
      this.session.setAttribute("RenDateTo", null);
      this.dateFrom.setValue(null);
      this.dateTo.setValue(null);
      
      this.session.setAttribute("agnCode", null);
      this.session.setAttribute("agnShtDesc", null);
      this.session.setAttribute("agnName", null);
      this.agentsDisplay.setValue(null);
      
      ADFUtils.findIterator("findReceiptedPoliciesIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.policiesLOV);
      
      ADFUtils.findIterator("findCommissionPaymentsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.commLOV);
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
    return null;
  }
  
  public String SearchCommissions()
  {
    try
    {
      if (this.dateFrom.getValue() == null)
      {
        GlobalCC.INFORMATIONREPORTING("Enter A Date From");
        return null;
      }
      if (this.dateTo.getValue() == null)
      {
        GlobalCC.INFORMATIONREPORTING("Enter A Date To");
        return null;
      }
      this.session.setAttribute("RenDateFrom", GlobalCC.parseDate(this.dateFrom.getValue().toString()));
      this.session.setAttribute("RenDateTo", GlobalCC.parseDate(this.dateTo.getValue().toString()));
      this.session.setAttribute("booleanSelect", "F");
      
      ADFUtils.findIterator("findReceiptedPoliciesIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.policiesLOV);
      
      ADFUtils.findIterator("findCommissionPaymentsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.commLOV);
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
    return null;
  }
  
  public void CommknockoffListener(ValueChangeEvent valueChangeEvent)
  {
    if (valueChangeEvent.getOldValue() != valueChangeEvent.getNewValue())
    {
      RowKeySet rowKeySet = this.policiesLOV.getSelectedRowKeys();
      if (rowKeySet == null) {
        return;
      }
      if (!rowKeySet.iterator().hasNext())
      {
        GlobalCC.errorValueNotEntered("No Record Selected");
        return;
      }
      Object key2 = rowKeySet.iterator().next();
      this.policiesLOV.setRowKey(key2);
      JUCtrlValueBinding nodeBinding = (JUCtrlValueBinding)this.policiesLOV.getRowData();
      if (nodeBinding == null)
      {
        GlobalCC.errorValueNotEntered("No Record Selected");
        return;
      }
      if (this.knockCbox.isSelected()) {
        nodeBinding.setAttribute("selected", Boolean.valueOf(true));
      } else {
        nodeBinding.setAttribute("selected", Boolean.valueOf(false));
      }
    }
  }
  
  public String PrepareCommPayments()
  {
    String fclQuery = "BEGIN LMS_WEB_PKG_GRP_UW.prepare_comm_payment(?,?,?,?);END;";
    Connection conn = new DBConnector().getDatabaseConn();
    CallableStatement cst = null;
    
    List ReinstInfo = new LinkedList();
    ARRAY array = null;
    try
    {
      ArrayDescriptor descriptor = ArrayDescriptor.createDescriptor("LMS_RECEIPT_COMM_TAB", conn);
      
      int rowCount = 0;
      
      boolean Value = false;
      rowCount = this.policiesLOV.getRowCount();
      if (rowCount == 0) {
        return null;
      }
      cst = conn.prepareCall(fclQuery);
      for (int i = 0; i < rowCount; i++)
      {
        this.policiesLOV.setRowIndex(i);
        JUCtrlValueBinding nodeBinding = (JUCtrlValueBinding)this.policiesLOV.getRowData();
        if (nodeBinding != null)
        {
          Value = ((Boolean)nodeBinding.getAttribute("selected")).booleanValue();
          if (Value == true)
          {
            ReceiptCommissions pn = new ReceiptCommissions();
            pn.setGRCT_CODE((BigDecimal)nodeBinding.getAttribute("grct_code"));
            pn.setTRANS_CODE(null);
            pn.setPCP_CODE((BigDecimal)nodeBinding.getAttribute("pcp_code"));
            pn.setCCL_CODE((BigDecimal)nodeBinding.getAttribute("CCL_CODE"));
            ReinstInfo.add(pn);
          }
        }
      }
      array = new ARRAY(descriptor, conn, ReinstInfo.toArray());
      cst.setArray(1, array);
      cst.setString(2, (String)this.session.getAttribute("RenDateFrom"));
      cst.setString(3, (String)this.session.getAttribute("RenDateTo"));
      cst.registerOutParameter(4, 3);
      cst.execute();
      
      this.session.setAttribute("transactionNumber", cst.getBigDecimal(4));
      cst.close();
      conn.close();
      
      ADFUtils.findIterator("findReceiptedPoliciesIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.policiesLOV);
      
      ADFUtils.findIterator("findCommissionPaymentsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.commLOV);
      
      this.commPymtMode.setValue("A");
      this.recptInstallTab.setRendered(false);
      this.commPymtTab.setRendered(true);
      
      GlobalCC.INFORMATIONREPORTING("Payment Preparation Sucessfully Completed. Proceed to Authorise....");
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
      e.printStackTrace();
    }
    return null;
  }
  
  public String AuthoriseCommPayments()
  {
    String fclQuery = "BEGIN LMS_WEB_PKG_GRP.Commauthpymt(?,?,?,?,?,?);END;";
    Connection conn = new DBConnector().getDatabaseConn();
    CallableStatement cst = null;
    try
    {
      Object key2 = this.commLOV.getSelectedRowData();
      if (key2 == null) {
        GlobalCC.errorValueNotEntered("No Record Selected");
      }
      JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
      if (r == null) {
        GlobalCC.errorValueNotEntered("No Record Selected");
      }
      //session.setAttribute("COP_CODE", r.getAttribute("COP_CODE"));
      cst = conn.prepareCall(fclQuery);
      cst.setString(1, (String)this.session.getAttribute("RenDateFrom"));
      cst.setString(2, (String)this.session.getAttribute("RenDateTo"));
      cst.setBigDecimal(3, (BigDecimal)this.session.getAttribute("transactionNumber"));
      cst.setInt(4, 27);
      cst.setBigDecimal(5, null);
      cst.setBigDecimal(6, (BigDecimal)r.getAttribute("COP_CODE"));
      cst.execute();
      cst.close();
      conn.close();
      
      ADFUtils.findIterator("findReceiptedPoliciesIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.policiesLOV);
      
      ADFUtils.findIterator("findCommissionPaymentsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.commLOV);
      
      GlobalCC.INFORMATIONREPORTING("Commission Authorised Sucessfully.");
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
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
  
  public void setProductsLOV(RichTable productsLOV)
  {
    this.productsLOV = productsLOV;
  }
  
  public RichTable getProductsLOV()
  {
    return this.productsLOV;
  }
  
  public void setProductDesc(RichInputText productDesc)
  {
    this.productDesc = productDesc;
  }
  
  public RichInputText getProductDesc()
  {
    return this.productDesc;
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
  
  public void setCrdtTransLOV(RichTable crdtTransLOV)
  {
    this.crdtTransLOV = crdtTransLOV;
  }
  
  public RichTable getCrdtTransLOV()
  {
    return this.crdtTransLOV;
  }
  
  public void setCrdtAllocLOV(RichTable crdtAllocLOV)
  {
    this.crdtAllocLOV = crdtAllocLOV;
  }
  
  public RichTable getCrdtAllocLOV()
  {
    return this.crdtAllocLOV;
  }
  
  public void setDbtTransLOV(RichTable dbtTransLOV)
  {
    this.dbtTransLOV = dbtTransLOV;
  }
  
  public RichTable getDbtTransLOV()
  {
    return this.dbtTransLOV;
  }
  
  public void setDbtAllocLOV(RichTable dbtAllocLOV)
  {
    this.dbtAllocLOV = dbtAllocLOV;
  }
  
  public RichTable getDbtAllocLOV()
  {
    return this.dbtAllocLOV;
  }
  
  public void setTransSettledLOV(RichTable transSettledLOV)
  {
    this.transSettledLOV = transSettledLOV;
  }
  
  public RichTable getTransSettledLOV()
  {
    return this.transSettledLOV;
  }
  
  public void setCommLOV(RichTable commLOV)
  {
    this.commLOV = commLOV;
  }
  
  public RichTable getCommLOV()
  {
    return this.commLOV;
  }
  
  public void setResults(RichPanelBox results)
  {
    this.results = results;
  }
  
  public RichPanelBox getResults()
  {
    return this.results;
  }
  
  public void setKnockCbox(RichSelectBooleanCheckbox knockCbox)
  {
    this.knockCbox = knockCbox;
  }
  
  public RichSelectBooleanCheckbox getKnockCbox()
  {
    return this.knockCbox;
  }
  
  public void setDateFrom(RichInputDate dateFrom)
  {
    this.dateFrom = dateFrom;
  }
  
  public RichInputDate getDateFrom()
  {
    return this.dateFrom;
  }
  
  public void setDateTo(RichInputDate dateTo)
  {
    this.dateTo = dateTo;
  }
  
  public RichInputDate getDateTo()
  {
    return this.dateTo;
  }
  
  public void setAgentsDisplay(RichInputText agentsDisplay)
  {
    this.agentsDisplay = agentsDisplay;
  }
  
  public RichInputText getAgentsDisplay()
  {
    return this.agentsDisplay;
  }
  
  public void setAgentDisplayLOV(RichTable agentDisplayLOV)
  {
    this.agentDisplayLOV = agentDisplayLOV;
  }
  
  public RichTable getAgentDisplayLOV()
  {
    return this.agentDisplayLOV;
  }
  
  public void setRefNo(RichOutputText refNo)
  {
    this.refNo = refNo;
  }
  
  public RichOutputText getRefNo()
  {
    return this.refNo;
  }
  
  public void setAllocMode(RichSelectOneChoice allocMode)
  {
    this.allocMode = allocMode;
  }
  
  public RichSelectOneChoice getAllocMode()
  {
    return this.allocMode;
  }
  
  public void DebitAllocationListener(DisclosureEvent disclosureEvent)
  {
    this.session.setAttribute("allocationType", "ND");
  }
  
  public void coinsAllocationListener(DisclosureEvent disclosureEvent)
  {
    this.session.setAttribute("allocationType", "CD");
  }
  
  public void setCknockCbox(RichSelectBooleanCheckbox cknockCbox)
  {
    this.cknockCbox = cknockCbox;
  }
  
  public RichSelectBooleanCheckbox getCknockCbox()
  {
    return this.cknockCbox;
  }
  
  public void setCoinsAlloc(RichTable coinsAlloc)
  {
    this.coinsAlloc = coinsAlloc;
  }
  
  public RichTable getCoinsAlloc()
  {
    return this.coinsAlloc;
  }
  
  public void setRefundsAlloc(RichTable refundsAlloc)
  {
    this.refundsAlloc = refundsAlloc;
  }
  
  public RichTable getRefundsAlloc()
  {
    return this.refundsAlloc;
  }
  
  public void setCommPymtMode(RichSelectOneChoice commPymtMode)
  {
    this.commPymtMode = commPymtMode;
  }
  
  public RichSelectOneChoice getCommPymtMode()
  {
    return this.commPymtMode;
  }
  
  public void commPymtModeListener(ValueChangeEvent valueChangeEvent)
  {
    if (valueChangeEvent.getOldValue() != valueChangeEvent.getNewValue())
    {
      if (this.commPymtMode.getValue() == null)
      {
        this.recptInstallTab.setRendered(false);
        this.commPymtTab.setRendered(true);
      }
      else if (this.commPymtMode.getValue().toString().equalsIgnoreCase("A"))
      {
        this.recptInstallTab.setRendered(false);
        this.commPymtTab.setRendered(true);
      }
      else if (this.commPymtMode.getValue().toString().equalsIgnoreCase("P"))
      {
        this.recptInstallTab.setRendered(true);
        this.commPymtTab.setRendered(false);
      }
      else
      {
        this.recptInstallTab.setRendered(true);
        this.commPymtTab.setRendered(false);
      }
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.recptInstallTab);
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.commPymtTab);
    }
  }
  
  public void setRecptInstallTab(RichPanelBox recptInstallTab)
  {
    this.recptInstallTab = recptInstallTab;
  }
  
  public RichPanelBox getRecptInstallTab()
  {
    return this.recptInstallTab;
  }
  
  public void setCommPymtTab(RichPanelBox commPymtTab)
  {
    this.commPymtTab = commPymtTab;
  }
  
  public RichPanelBox getCommPymtTab()
  {
    return this.commPymtTab;
  }
  
  public void setAccountDisplay(RichInputText accountDisplay)
  {
    this.accountDisplay = accountDisplay;
  }
  
  public RichInputText getAccountDisplay()
  {
    return this.accountDisplay;
  }
  
  public String selectAccount()
  {
    DCIteratorBinding dciter = ADFUtils.findIterator("findAccountTypesIterator");
    RowKeySet set = this.accountsLOV.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();
    while (rowKeySetIter.hasNext())
    {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();
      this.session.setAttribute("account_code", r.getAttribute("ACT_CODE"));
      this.accountDisplay.setValue(r.getAttribute("ACT_ACCOUNT_TYPE"));
    }
    ADFUtils.findIterator("findAgentByAccIterator").executeQuery();
    AdfFacesContext.getCurrentInstance().addPartialTarget(this.agentsLOV);
    return null;
  }
  
  public void setAccountsLOV(RichTable accountsLOV)
  {
    this.accountsLOV = accountsLOV;
  }
  
  public RichTable getAccountsLOV()
  {
    return this.accountsLOV;
  }
  
  public void setAgenDisplay(RichInputText agenDisplay)
  {
    this.agenDisplay = agenDisplay;
  }
  
  public RichInputText getAgenDisplay()
  {
    return this.agenDisplay;
  }
  
  public String accountSelection()
  {
    return null;
  }
  
  public void setAgentsLOV(RichTable agentsLOV)
  {
    this.agentsLOV = agentsLOV;
  }
  
  public RichTable getAgentsLOV()
  {
    return this.agentsLOV;
  }
  
  public String agentSelection()
  {
    DCIteratorBinding dciter = ADFUtils.findIterator("findAgentByAccIterator");
    RowKeySet set = this.agentsLOV.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();
    while (rowKeySetIter.hasNext())
    {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();
      this.session.setAttribute("agent_code", r.getAttribute("AGN_CODE"));
      this.agenDisplay.setValue(r.getAttribute("AGN_NAME"));
    }
    ADFUtils.findIterator("findAgentByAccIterator").executeQuery();
    AdfFacesContext.getCurrentInstance().addPartialTarget(this.agentsLOV);
    return null;
  }
  
  public String searchAction()
  {
    try
    {
      ADFUtils.findIterator("findCreditTransIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.crdtTransLOV);
      
      ADFUtils.findIterator("findCreditToAllocIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.crdtAllocLOV);
      
      ADFUtils.findIterator("findDebitTransactionsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.dbtTransLOV);
      
      ADFUtils.findIterator("findDebitToAllocIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.dbtAllocLOV);
      
      ADFUtils.findIterator("findTransactionsSettledIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.transSettledLOV);
      
      ADFUtils.findIterator("findPolicyCommissionIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.commLOV);
      
      this.session.setAttribute("coinsLevel", "T");
      ADFUtils.findIterator("FindPolicyCoinsurersIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.coinsAlloc);
      
      ADFUtils.findIterator("findCoinAllocRefundsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.refundsAlloc);
      
      t = 0;
      Num = Integer.valueOf(0);
      this.results.setRendered(true);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return null;
  }
  
  public void policyRadioEvent(ValueChangeEvent valueChangeEvent)
  {
    if (valueChangeEvent.getOldValue() != valueChangeEvent.getNewValue()) {
      if (this.policyRadio.isSelected())
      {
        this.polSelectionLab.setRendered(true);
        this.polGrid.setRendered(true);
        this.accGrid.setRendered(false);
        this.accLabel.setRendered(false);
        this.accSearchBtn.setRendered(false);
        this.accTypeGrid.setRendered(false);
        this.accTypeLab.setRendered(false);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.polSelectionLab);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.polGrid);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.accLabel);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.accGrid);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.accSearchBtn);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.accTypeGrid);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.accTypeLab);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.transAllocPanel);
      }
      else
      {
        this.polSelectionLab.setRendered(false);
        this.polGrid.setRendered(false);
        this.accGrid.setRendered(true);
        this.accLabel.setRendered(true);
        this.accSearchBtn.setRendered(true);
        this.accTypeGrid.setRendered(true);
        this.accTypeLab.setRendered(true);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.polSelectionLab);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.polGrid);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.accLabel);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.accGrid);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.accSearchBtn);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.accTypeGrid);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.accTypeLab);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.transAllocPanel);
      }
    }
  }
  
  public void setPolicyRadio(RichSelectBooleanRadio policyRadio)
  {
    this.policyRadio = policyRadio;
  }
  
  public RichSelectBooleanRadio getPolicyRadio()
  {
    return this.policyRadio;
  }
  
  public void setAccountRadio(RichSelectBooleanRadio accountRadio)
  {
    this.accountRadio = accountRadio;
  }
  
  public RichSelectBooleanRadio getAccountRadio()
  {
    return this.accountRadio;
  }
  
  public void accountRadioEvent(ValueChangeEvent valueChangeEvent)
  {
    if (valueChangeEvent.getOldValue() != valueChangeEvent.getNewValue()) {
      if (this.accountRadio.isSelected())
      {
        this.polSelectionLab.setRendered(false);
        this.polGrid.setRendered(false);
        this.accGrid.setRendered(true);
        this.accLabel.setRendered(true);
        this.accSearchBtn.setRendered(true);
        this.accTypeGrid.setRendered(true);
        this.accTypeLab.setRendered(true);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.polSelectionLab);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.polGrid);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.accLabel);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.accGrid);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.accSearchBtn);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.accTypeGrid);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.accTypeLab);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.transAllocPanel);
      }
      else
      {
        this.polSelectionLab.setRendered(true);
        this.polGrid.setRendered(true);
        this.accGrid.setRendered(false);
        this.accLabel.setRendered(false);
        this.accSearchBtn.setRendered(false);
        this.accTypeGrid.setRendered(false);
        this.accTypeLab.setRendered(false);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.polSelectionLab);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.polGrid);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.accLabel);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.accGrid);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.accSearchBtn);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.accTypeGrid);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.accTypeLab);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.transAllocPanel);
      }
    }
  }
  
  public void setAccTypeLab(RichOutputLabel accTypeLab)
  {
    this.accTypeLab = accTypeLab;
  }
  
  public RichOutputLabel getAccTypeLab()
  {
    return this.accTypeLab;
  }
  
  public void setAccTypeGrid(HtmlPanelGrid accTypeGrid)
  {
    this.accTypeGrid = accTypeGrid;
  }
  
  public HtmlPanelGrid getAccTypeGrid()
  {
    return this.accTypeGrid;
  }
  
  public void setAccLabel(RichOutputLabel accLabel)
  {
    this.accLabel = accLabel;
  }
  
  public RichOutputLabel getAccLabel()
  {
    return this.accLabel;
  }
  
  public void setAccGrid(HtmlPanelGrid accGrid)
  {
    this.accGrid = accGrid;
  }
  
  public HtmlPanelGrid getAccGrid()
  {
    return this.accGrid;
  }
  
  public void setAccSearchBtn(RichCommandButton accSearchBtn)
  {
    this.accSearchBtn = accSearchBtn;
  }
  
  public RichCommandButton getAccSearchBtn()
  {
    return this.accSearchBtn;
  }
  
  public void setPolSelectionLab(RichOutputLabel polSelectionLab)
  {
    this.polSelectionLab = polSelectionLab;
  }
  
  public RichOutputLabel getPolSelectionLab()
  {
    return this.polSelectionLab;
  }
  
  public void setPolGrid(HtmlPanelGrid polGrid)
  {
    this.polGrid = polGrid;
  }
  
  public HtmlPanelGrid getPolGrid()
  {
    return this.polGrid;
  }
  
  public void setTransAllocPanel(RichPanelBox transAllocPanel)
  {
    this.transAllocPanel = transAllocPanel;
  }
  
  public RichPanelBox getTransAllocPanel()
  {
    return this.transAllocPanel;
  }
  
  public void setChqTransType(RichSelectOneChoice chqTransType)
  {
    this.chqTransType = chqTransType;
  }
  
  public RichSelectOneChoice getChqTransType()
  {
    return this.chqTransType;
  }
  
  public void setChqDateFrom(RichInputDate chqDateFrom)
  {
    this.chqDateFrom = chqDateFrom;
  }
  
  public RichInputDate getChqDateFrom()
  {
    return this.chqDateFrom;
  }
  
  public void setChqDateTo(RichInputDate chqDateTo)
  {
    this.chqDateTo = chqDateTo;
  }
  
  public RichInputDate getChqDateTo()
  {
    return this.chqDateTo;
  }
  
  public String chqSearchAction()
  {
    if (this.chqTransType.getValue() == null) {
      this.session.setAttribute("chq_trans_type", null);
    } else {
      this.session.setAttribute("chq_trans_type", this.chqTransType.getValue().toString());
    }
    if (this.chqDateFrom.getValue() == null) {
      this.session.setAttribute("chq_date_from", null);
    } else {
      this.session.setAttribute("chq_date_from", GlobalCC.parseDate(this.chqDateFrom.getValue().toString()));
    }
    if (this.chqDateTo.getValue() == null) {
      this.session.setAttribute("chq_date_to", null);
    } else {
      this.session.setAttribute("chq_date_to", GlobalCC.parseDate(this.chqDateTo.getValue().toString()));
    }
    if (this.memNo.getValue() == null) {
      this.session.setAttribute("chq_mem_no", null);
    } else {
      this.session.setAttribute("chq_mem_no", this.memNo.getValue().toString());
    }
    if (this.memName.getValue() == null) {
      this.session.setAttribute("chq_mem_name", null);
    } else {
      this.session.setAttribute("chq_mem_name", this.memName.getValue().toString());
    }
    if (this.payeeName.getValue() == null) {
      this.session.setAttribute("chq_payee_name", null);
    } else {
      this.session.setAttribute("chq_payee_name", this.payeeName.getValue().toString());
    }
    if (this.clmNo.getValue() == null) {
      this.session.setAttribute("chq_clm_no", null);
    } else {
      this.session.setAttribute("chq_clm_no", this.clmNo.getValue().toString());
    }
    ADFUtils.findIterator("findChqStatusesIterator").executeQuery();
    AdfFacesContext.getCurrentInstance().addPartialTarget(this.chqStatusesLOV);
    
    return null;
  }
  
  public void setChqStatusesLOV(RichTable chqStatusesLOV)
  {
    this.chqStatusesLOV = chqStatusesLOV;
  }
  
  public RichTable getChqStatusesLOV()
  {
    return this.chqStatusesLOV;
  }
  
  public void setMemNo(RichInputText memNo)
  {
    this.memNo = memNo;
  }
  
  public RichInputText getMemNo()
  {
    return this.memNo;
  }
  
  public void setMemName(RichInputText memName)
  {
    this.memName = memName;
  }
  
  public RichInputText getMemName()
  {
    return this.memName;
  }
  
  public void setPayeeName(RichInputText payeeName)
  {
    this.payeeName = payeeName;
  }
  
  public RichInputText getPayeeName()
  {
    return this.payeeName;
  }
  
  public void setClmNo(RichInputText clmNo)
  {
    this.clmNo = clmNo;
  }
  
  public RichInputText getClmNo()
  {
    return this.clmNo;
  }
  
  public String findPoliciesSelectedchq()
  {
    DCIteratorBinding dciter = ADFUtils.findIterator("findPoliciesToAllocateIterator");
    RowKeySet set = this.policiesLOV.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();
    while (rowKeySetIter.hasNext())
    {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();
      this.policiesDesc.setValue(r.getAttribute("POL_POLICY_NO"));
      this.session.setAttribute("policyCode", r.getAttribute("POL_CODE"));
    }
    return null;
  }
  
  public String goToClaims()
  {
    GlobalCC.RedirectPage("/g_edtclm.jspx");
    return null;
  }

    public void selectCommissionRecord(SelectionEvent selectionEvent) {
        Object key2 = this.commLOV.getSelectedRowData();
        if (key2 == null) {
          GlobalCC.errorValueNotEntered("No Record Selected");
        }
        JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
        if (r == null) {
          GlobalCC.errorValueNotEntered("No Record Selected");
        }
        session.setAttribute("COP_CODE", r.getAttribute("COP_CODE"));
        //System.out.println("COP CODE===="+r.getAttribute("COP_CODE"));
    }
}
