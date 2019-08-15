package LMSG.view.Accounts;

import LMSG.view.Base.ADFUtils;
import LMSG.view.Base.GlobalCC;
import LMSG.view.Base.LOVCC;
import LMSG.view.connect.DBConnector;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Iterator;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpSession;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputNumberSpinbox;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanRadio;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.uicli.binding.JUCtrlValueBinding;
import org.apache.myfaces.trinidad.event.SelectionEvent;
import org.apache.myfaces.trinidad.model.RowKeySet;
import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

public class paymentProcessing
  extends LOVCC
{
  private RichTable depositsLOV;
  private RichTable memDepositsLOV;
  private RichInputText policyNumberDisplay;
  private RichTable policyPremiumsLOV;
  private RichInputText month;
  private RichInputText year;
  private RichInputText amount;
  private RichTable policyReceiptsLOV;
  private RichTable polRecptsInslmntsLOV;
  HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
  private RichTable unallocMembers;
  private RichTable selMembersLOV;
  private RichTable distLOV;
  private RichInputText policyDesc;
  private RichTable policiesLOV;
  private RichInputNumberSpinbox balanceAmount;
  private RichInputDate balanceDate;
  private RichInputText loadRemarks;
  private RichTable loadedBalances;
  private RichSelectBooleanRadio creditsCbox;
  private RichSelectBooleanRadio debitsCbox;
  private RichInputText debitPolicyNo;
  private RichInputText debitProductDesc;
  private RichTable debitProductLOV;
  private RichInputText debitClientsDesc;
  private RichTable debitClientsLOV;
  private RichInputText debitBranchDesc;
  private RichSelectOneChoice frequencyOfPayment;
  private RichSelectOneChoice durationType;
  private RichInputNumberSpinbox debitAmount;
  private RichTable branchesLOV;
  private RichInputDate effectiveDate;
  private RichInputDate debitBalDate;
  private RichInputText agencyDesc;
  private RichTable agenciesLOV;
  private RichInputText productsDesc;
  private RichTable productsLOV;
  private RichTable memberAllocationsTable;
  private RichOutputText allocAmt;
  private RichOutputText allocBalance;
  private RichInputText refPolNo;
  private RichInputText refPremDisplay;
  private RichInputText refTotalDisplay;
  private RichInputText refPensDisplay;
  private RichInputText newPremAlloc;
  private RichInputText newPensAlloc;
  private RichInputText newTotReceipt;
  private RichInputText refTotal;
  private RichInputText payee;
  private RichSelectOneChoice endrTypes;
  private RichOutputText rcptNo;
  private RichInputDate rcptDate;
  private RichInputNumberSpinbox rcptAmount;
  private RichInputNumberSpinbox rcptAllocToPens;
  private RichInputNumberSpinbox rcptAllocToPrem;
  private RichSelectOneChoice allocDecSel;
  private RichSelectOneChoice commSelect;
  
  public String AssignProducts()
  {
    DCIteratorBinding dciter = ADFUtils.findIterator("findProductsIterator");
    
    RowKeySet set = this.productsLOV.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();
    while (rowKeySetIter.hasNext())
    {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();
      
      this.productsDesc.setValue(r.getAttribute("prodDesc"));
      this.session.setAttribute("ProductCode", r.getAttribute("prodCode"));
      this.session.setAttribute("productType", r.getAttribute("prodType"));
      this.session.setAttribute("policyCode", null);
      this.policyNumberDisplay.setValue(null);
      
      ADFUtils.findIterator("FindPolicyPremiumsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.policyPremiumsLOV);
    }
    return null;
  }
  
  public String AssignPolicyPremiums()
  {
    DCIteratorBinding dciter = ADFUtils.findIterator("FindPolicyPremiumsIterator");
    
    RowKeySet set = this.policyPremiumsLOV.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();
    while (rowKeySetIter.hasNext())
    {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();
      
      this.session.setAttribute("policyCode", r.getAttribute("POL_CODE"));
      this.policyNumberDisplay.setValue(r.getAttribute("POL_POLICY_NO"));
    }
    return null;
  }
  
  public void GetSelectedReceipt(SelectionEvent selectionEvent)
  {
    try
    {
      DCIteratorBinding dciter = ADFUtils.findIterator("FindPolicyReceiptsIterator");
      
      RowKeySet set = selectionEvent.getAddedSet();
      Iterator rowKeySetIter = set.iterator();
      while (rowKeySetIter.hasNext())
      {
        List l = (List)rowKeySetIter.next();
        Key key = (Key)l.get(0);
        dciter.setCurrentRowWithKey(key.toStringFormat(true));
        Row r = dciter.getCurrentRow();
        




        this.refPremDisplay.setValue(r.getAttribute("GRCT_PREM_PYMNT_AMT"));
        this.refPensDisplay.setValue(r.getAttribute("GRCT_PENS_PYMT_AMT"));
        this.refTotalDisplay.setValue(r.getAttribute("BALANCE_AMT"));
        
        this.session.setAttribute("GrctCode", r.getAttribute("GRCT_CODE"));
        this.allocAmt.setValue(r.getAttribute("mem_alloc_amt"));
        this.allocBalance.setValue(r.getAttribute("mem_alloc_balance"));
        
        this.session.setAttribute("GrctReceiptNo", r.getAttribute("GRCT_CODE"));
        
        this.session.setAttribute("GrctPensAlloc", r.getAttribute("GRCT_PENS_ALLOCATE"));
        
        this.session.setAttribute("GrctPremAlloc", r.getAttribute("GRCT_PREM_ALLOCATE"));
        

        ADFUtils.findIterator("FindPolicyRecptInstlmntsIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.polRecptsInslmntsLOV);
        
        ADFUtils.findIterator("FindPensionDepositsByReceiptIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.depositsLOV);
        
        this.session.setAttribute("PNDP_CODE", null);
        ADFUtils.findIterator("FindMembersPensionDepositsIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.memDepositsLOV);
        
        ADFUtils.findIterator("findPremiumMemberCovers_AllIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.memberAllocationsTable);
        
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.allocAmt);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.allocBalance);
        

        AdfFacesContext.getCurrentInstance().addPartialTarget(this.refPremDisplay);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.refPensDisplay);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.refTotalDisplay);
      }
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
  }
  
  public String ShowReceipts()
  {
    Connection conn = null;
    try
    {
      if (this.policyNumberDisplay.getValue() == null)
      {
        String Message = "Select A Policy";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Message, Message));
        


        return null;
      }
      String authQuery = "BEGIN lms_web_pkg_grp_uw.prem_card_transactions(?);END;";
      
      conn = new DBConnector().getDatabaseConn();
      
      CallableStatement cstmt = conn.prepareCall(authQuery);
      cstmt.registerOutParameter(1, 3);
      cstmt.execute();
      this.session.setAttribute("ReceiptTransNo", cstmt.getBigDecimal(1));
      cstmt.close();
      conn.close();
      GlobalCC.RedirectPage("/grctpymt.jspx");
    }
    catch (Exception ex)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, ex);
    }
    return null;
  }
  
  public String BackToReceipts()
  {
    try
    {
      this.session.setAttribute("receiptTemplateSeq", Integer.valueOf(0));
      GlobalCC.RedirectPage("/grctpymt.jspx");
    }
    catch (Exception ex)
    {
      GlobalCC.EXCEPTIONREPORTING(null, ex);
    }
    return null;
  }
  
  public String PrepareAllocations()
  {
    Connection conn = null;
    try
    {
      DCIteratorBinding dciter = ADFUtils.findIterator("FindPolicyReceiptsIterator");
      
      RowKeySet set = this.policyReceiptsLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      while (rowKeySetIter.hasNext())
      {
        List l = (List)rowKeySetIter.next();
        Key key = (Key)l.get(0);
        dciter.setCurrentRowWithKey(key.toStringFormat(true));
        Row r = dciter.getCurrentRow();
        

        this.session.setAttribute("GrctCode", r.getAttribute("GRCT_CODE"));
      }
      String authQuery = "BEGIN lms_web_pkg_grp_uw.prepareRcptToPens(?,?,?,?);END;";
      
      conn = new DBConnector().getDatabaseConn();
      
      CallableStatement cstmt = conn.prepareCall(authQuery);
      cstmt.setBigDecimal(1, (BigDecimal)this.session.getAttribute("GrctCode"));
      
      cstmt.registerOutParameter(2, 12);
      cstmt.registerOutParameter(3, 12);
      cstmt.registerOutParameter(4, 4);
      cstmt.execute();
      

      this.month.setValue(cstmt.getString(2));
      this.year.setValue(cstmt.getString(3));
      this.amount.setValue(cstmt.getString(4));
      cstmt.close();
      conn.close();
      

      GlobalCC.showPopup("lmsgroup:alloc");
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
  }
  
  public String AllocateToMembers()
  {
    Connection conn = null;
    try
    {
      BigDecimal PCMCode = null;
      conn = new DBConnector().getDatabaseConn();
      DCIteratorBinding dciter = ADFUtils.findIterator("findPremiumMemberCoversIterator");
      
      RowKeySet set = this.unallocMembers.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      while (rowKeySetIter.hasNext())
      {
        List l = (List)rowKeySetIter.next();
        Key key = (Key)l.get(0);
        dciter.setCurrentRowWithKey(key.toStringFormat(true));
        Row r = dciter.getCurrentRow();
        
        PCMCode = (BigDecimal)r.getAttribute("PCM_CODE");
        
        String authQuery = "BEGIN lms_web_pkg_grp_uw.allocate_prem_to_members(?,?);END;";
        


        CallableStatement cstmt = conn.prepareCall(authQuery);
        cstmt.setBigDecimal(1, (BigDecimal)this.session.getAttribute("GrctCode"));
        
        cstmt.setBigDecimal(2, PCMCode);
        cstmt.execute();
        cstmt.close();
      }
      ADFUtils.findIterator("findPremiumMemberCoversIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.unallocMembers);
      ADFUtils.findIterator("findAllocPremiumMemberCoversIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.selMembersLOV);
      

      conn.close();
      

      ExtendedRenderKitService erkService = (ExtendedRenderKitService)Service.getService(FacesContext.getCurrentInstance().getRenderKit(), ExtendedRenderKitService.class);
      

      erkService.addScript(FacesContext.getCurrentInstance(), "var hints = {autodismissNever:false}; AdfPage.PAGE.findComponent('lmsgroup:p1').show(hints);");
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
  }
  
  public String ShowDistrCriteria()
  {
    try
    {
      ADFUtils.findIterator("findDistributionCriteriaIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.distLOV);
      

      ExtendedRenderKitService erkService = (ExtendedRenderKitService)Service.getService(FacesContext.getCurrentInstance().getRenderKit(), ExtendedRenderKitService.class);
      

      erkService.addScript(FacesContext.getCurrentInstance(), "var hints = {autodismissNever:false}; AdfPage.PAGE.findComponent('lmsgroup:distribution').show(hints);");
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
    return null;
  }
  
  public String DistributionSel()
  {
    try
    {
      DCIteratorBinding dciter = ADFUtils.findIterator("findDistributionCriteriaIterator");
      
      RowKeySet set = this.distLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      while (rowKeySetIter.hasNext())
      {
        List l = (List)rowKeySetIter.next();
        Key key = (Key)l.get(0);
        dciter.setCurrentRowWithKey(key.toStringFormat(true));
        Row r = dciter.getCurrentRow();
        
        this.session.setAttribute("endorsementCode", r.getAttribute("DIS_ENDR_CODE"));
      }
      PrepareDistrToMembers();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
    return null;
  }
  
  public String AllocatePensionsToReceipts()
  {
    Connection conn = null;
    try
    {
      String authQuery = "BEGIN lms_web_pkg_grp_uw.AllocRcptToPens(?,?,?,?);END;";
      
      conn = new DBConnector().getDatabaseConn();
      
      CallableStatement cstmt = conn.prepareCall(authQuery);
      cstmt.setBigDecimal(1, (BigDecimal)this.session.getAttribute("GrctCode"));
      if (this.month.getValue() == null) {
        cstmt.setString(2, null);
      } else {
        cstmt.setString(2, this.month.getValue().toString());
      }
      if (this.year.getValue() == null) {
        cstmt.setString(3, null);
      } else {
        cstmt.setString(3, this.year.getValue().toString());
      }
      if (this.amount.getValue() == null) {
        cstmt.setString(4, null);
      } else {
        cstmt.setString(4, this.amount.getValue().toString());
      }
      cstmt.execute();
      cstmt.close();
      
      ADFUtils.findIterator("FindPensionDepositsByReceiptIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.depositsLOV);
      
      ADFUtils.findIterator("FindMembersPensionDepositsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.memDepositsLOV);
      
      GlobalCC.INFORMATIONREPORTING("Pension Receipt Allocated succesfully.");
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
  }
  
  public String ReverseAllocations()
  {
    BigDecimal PRN_CODE = null;
    Connection conn = null;
    try
    {
      DCIteratorBinding dciter = ADFUtils.findIterator("FindPensionDepositsByReceiptIterator");
      
      RowKeySet set = this.depositsLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      while (rowKeySetIter.hasNext())
      {
        List l = (List)rowKeySetIter.next();
        Key key = (Key)l.get(0);
        dciter.setCurrentRowWithKey(key.toStringFormat(true));
        Row r = dciter.getCurrentRow();
        
        PRN_CODE = (BigDecimal)r.getAttribute("PNDP_CODE");
        
        String authQuery = "BEGIN lms_web_pkg_grp_uw.reverseAllocation(?);END;";
        
        conn = new DBConnector().getDatabaseConn();
        
        CallableStatement cstmt = conn.prepareCall(authQuery);
        cstmt.setBigDecimal(1, PRN_CODE);
        
        cstmt.execute();
        cstmt.close();
        
        GlobalCC.INFORMATIONREPORTING("Pension Receipt Allocation reversed succesfully.");
        
        ADFUtils.findIterator("FindPensionDepositsByReceiptIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.depositsLOV);
        
        ADFUtils.findIterator("FindMembersPensionDepositsIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.memDepositsLOV);
        
        conn.close();
      }
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
  }
  
  public String PrepareDistrToMembers()
  {
    BigDecimal PRN_CODE = null;
    Connection conn = null;
    try
    {
      DCIteratorBinding dciter = ADFUtils.findIterator("FindPensionDepositsByReceiptIterator");
      
      RowKeySet set = this.depositsLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      while (rowKeySetIter.hasNext())
      {
        List l = (List)rowKeySetIter.next();
        Key key = (Key)l.get(0);
        dciter.setCurrentRowWithKey(key.toStringFormat(true));
        Row r = dciter.getCurrentRow();
        
        PRN_CODE = (BigDecimal)r.getAttribute("PNDP_CODE");
        
        String authQuery = "BEGIN lms_web_pkg_grp_uw.PrepareDistrToMembers(?,?,?,?);END;";
        
        conn = new DBConnector().getDatabaseConn();
        
        CallableStatement cstmt = conn.prepareCall(authQuery);
        cstmt.setBigDecimal(1, (BigDecimal)this.session.getAttribute("policyCode"));
        
        cstmt.setBigDecimal(2, (BigDecimal)this.session.getAttribute("PNDP_CODE"));
        
        cstmt.setBigDecimal(3, (BigDecimal)this.session.getAttribute("GrctCode"));
        
        cstmt.registerOutParameter(4, 12);
        
        cstmt.execute();
        LOVCC.Allocated = cstmt.getString(4);
        cstmt.close();
        conn.close();
        GlobalCC.RedirectPage("/g_pensallocations.jspx");
      }
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
  }
  
  public String ReverseDistributions()
  {
    BigDecimal PRN_CODE = null;
    Connection conn = null;
    try
    {
      DCIteratorBinding dciter = ADFUtils.findIterator("FindPensionDepositsByReceiptIterator");
      
      RowKeySet set = this.depositsLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      while (rowKeySetIter.hasNext())
      {
        List l = (List)rowKeySetIter.next();
        Key key = (Key)l.get(0);
        dciter.setCurrentRowWithKey(key.toStringFormat(true));
        Row r = dciter.getCurrentRow();
        
        PRN_CODE = (BigDecimal)r.getAttribute("PNDP_CODE");
        
        String authQuery = "BEGIN lms_web_pkg_grp_uw.ReverseDistToMembers(?);END;";
        
        conn = new DBConnector().getDatabaseConn();
        
        CallableStatement cstmt = conn.prepareCall(authQuery);
        cstmt.setBigDecimal(1, PRN_CODE);
        
        cstmt.execute();
        cstmt.close();
        
        GlobalCC.INFORMATIONREPORTING("Pension Distribution reversed succesfully.");
        

        ADFUtils.findIterator("FindPensionDepositsByReceiptIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.depositsLOV);
        
        ADFUtils.findIterator("FindMembersPensionDepositsIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.memDepositsLOV);
        
        conn.close();
      }
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
  }
  
  public String DeleteLoadedDistribution()
  {
    String authTransfer = "BEGIN LMS_GRP_MISC.find_loaded_receipts(?,?);END;";
    

    String Process = "BEGIN LMS_GRP_MISC.Del_loaded_pension_deposit(?);END;";
    

    Connection conn = new DBConnector().getDatabaseConn();
    CallableStatement cstmt = null;
    CallableStatement cstmt2 = null;
    try
    {
      RowKeySet rowKeySet = this.depositsLOV.getSelectedRowKeys();
      String str1;
      if (rowKeySet == null) {
        return null;
      }
      if (!rowKeySet.iterator().hasNext())
      {
        GlobalCC.errorValueNotEntered("No Record Selected");
        return null;
      }
      Object key2 = rowKeySet.iterator().next();
      this.depositsLOV.setRowKey(key2);
      JUCtrlValueBinding r = (JUCtrlValueBinding)this.depositsLOV.getRowData();
      if (r == null)
      {
        GlobalCC.errorValueNotEntered("No Record Selected");
        return null;
      }
      cstmt = conn.prepareCall(authTransfer);
      cstmt.setBigDecimal(1, (BigDecimal)this.session.getAttribute("GrctCode"));
      
      cstmt.registerOutParameter(2, 12);
      cstmt.execute();
      
      String Loaded = cstmt.getString(2);
      cstmt.close();
      if (Loaded.equalsIgnoreCase("N"))
      {
        GlobalCC.INFORMATIONREPORTING("Only Receipts that were loaded can be Removed.");
        return null;
      }
      cstmt2 = conn.prepareCall(Process);
      cstmt2.setBigDecimal(1, (BigDecimal)r.getAttribute("PNDP_CODE"));
      cstmt2.execute();
      cstmt2.close();
      
      conn.close();
      

      GlobalCC.INFORMATIONREPORTING("Pension Distribution Deleted succesfully.");
      
      ADFUtils.findIterator("FindPensionDepositsByReceiptIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.depositsLOV);
      
      ADFUtils.findIterator("FindMembersPensionDepositsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.memDepositsLOV);
    }
    catch (Exception ex)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, ex);
    }
    finally
    {
      GlobalCC.CloseConnections(null, cstmt, conn);
    }
    return null;
  }
  
  public String ReprocessDistribution()
  {
    String authTransfer = "BEGIN LMS_GRP_MISC.find_loaded_receipts(?,?);END;";
    

    String Process = "BEGIN LMS_GRP_MISC.reprocess_loaded_deposit(?);END;";
    
    Connection conn = new DBConnector().getDatabaseConn();
    CallableStatement cstmt = null;
    CallableStatement cstmt2 = null;
    try
    {
      Object key2 = this.depositsLOV.getSelectedRowData();
      if (key2 == null)
      {
        GlobalCC.errorValueNotEntered("Error: No Record Selected");
        return null;
      }
      JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
      if (r == null)
      {
        GlobalCC.errorValueNotEntered("Error: No Record Selected");
        return null;
      }
      cstmt = conn.prepareCall(authTransfer);
      cstmt.setBigDecimal(1, (BigDecimal)this.session.getAttribute("GrctCode"));
      
      cstmt.registerOutParameter(2, 12);
      cstmt.execute();
      
      String Loaded = cstmt.getString(2);
      cstmt.close();
      if (Loaded.equalsIgnoreCase("N"))
      {
        GlobalCC.INFORMATIONREPORTING("Only Receipts that were loaded can be Reprocessed.");
        return null;
      }
      cstmt2 = conn.prepareCall(Process);
      cstmt2.setBigDecimal(1, (BigDecimal)r.getAttribute("PNDP_CODE"));
      cstmt2.execute();
      cstmt2.close();
      
      conn.close();
      

      GlobalCC.INFORMATIONREPORTING("Pension Distribution Reprocessed succesfully.");
      
      ADFUtils.findIterator("FindPensionDepositsByReceiptIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.depositsLOV);
      
      ADFUtils.findIterator("FindMembersPensionDepositsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.memDepositsLOV);
    }
    catch (Exception ex)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, ex);
    }
    finally
    {
      GlobalCC.CloseConnections(null, cstmt, conn);
    }
    return null;
  }
  
  public void setDepositsLOV(RichTable depositsLOV)
  {
    this.depositsLOV = depositsLOV;
  }
  
  public RichTable getDepositsLOV()
  {
    return this.depositsLOV;
  }
  
  public void setMemDepositsLOV(RichTable memDepositsLOV)
  {
    this.memDepositsLOV = memDepositsLOV;
  }
  
  public RichTable getMemDepositsLOV()
  {
    return this.memDepositsLOV;
  }
  
  public void DepositsListener(SelectionEvent selectionEvent)
  {
    Connection conn = null;
    try
    {
      DCIteratorBinding dciter = ADFUtils.findIterator("FindPensionDepositsByReceiptIterator");
      
      RowKeySet set = selectionEvent.getAddedSet();
      Iterator rowKeySetIter = set.iterator();
      while (rowKeySetIter.hasNext())
      {
        List l = (List)rowKeySetIter.next();
        Key key = (Key)l.get(0);
        dciter.setCurrentRowWithKey(key.toStringFormat(true));
        Row r = dciter.getCurrentRow();
        
        this.session.setAttribute("PNDP_CODE", r.getAttribute("PNDP_CODE"));
        
        ADFUtils.findIterator("FindMembersPensionDepositsIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.memDepositsLOV);
      }
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
  }
  
  public String AuthorisePayments()
  {
    Connection conn = null;
    try
    {
      String authQuery = "BEGIN lms_web_pkg_grp.auth_pymts(?,?,?);END;";
      conn = new DBConnector().getDatabaseConn();
      CallableStatement cstmt = conn.prepareCall(authQuery);
      
      DCIteratorBinding dciter = ADFUtils.findIterator("FindPolicyReceiptsIterator");
      
      RowKeySet set = this.policyReceiptsLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      while (rowKeySetIter.hasNext())
      {
        List l = (List)rowKeySetIter.next();
        Key key = (Key)l.get(0);
        dciter.setCurrentRowWithKey(key.toStringFormat(true));
        Row r = dciter.getCurrentRow();
        
        this.session.setAttribute("GrctCode", r.getAttribute("GRCT_CODE"));
        
        cstmt.setBigDecimal(1, (BigDecimal)this.session.getAttribute("policyCode"));
        
        cstmt.setBigDecimal(2, (BigDecimal)this.session.getAttribute("GrctCode"));
        
        cstmt.registerOutParameter(3, 3);
        cstmt.execute();
      }
      if (this.session.getAttribute("GrctCode") == null) {
        GlobalCC.errorValueNotEntered("No Receipt Selected.");
      } else {
        GlobalCC.INFORMATIONREPORTING("Receipt Authorised Successfully.");
      }
      cstmt.close();
      conn.close();
    }
    catch (Exception ex)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, ex);
    }
    return null;
  }
  
  public String ProcessReceiptPayments()
  {
    Connection conn = null;
    try
    {
      DCIteratorBinding dciter = ADFUtils.findIterator("FindPolicyReceiptsIterator");
      
      RowKeySet set = this.policyReceiptsLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      while (rowKeySetIter.hasNext())
      {
        List l = (List)rowKeySetIter.next();
        Key key = (Key)l.get(0);
        dciter.setCurrentRowWithKey(key.toStringFormat(true));
        Row r = dciter.getCurrentRow();
        

        this.session.setAttribute("GrctCode", r.getAttribute("GRCT_CODE"));
      }
      String authQuery = "BEGIN lms_web_pkg_grp.process_pymts(?,?);END;";
      conn = new DBConnector().getDatabaseConn();
      
      CallableStatement cstmt = conn.prepareCall(authQuery);
      cstmt.setBigDecimal(1, (BigDecimal)this.session.getAttribute("GrctCode"));
      
      cstmt.setBigDecimal(2, (BigDecimal)this.session.getAttribute("policyCode"));
      
      cstmt.execute();
      cstmt.close();
      
      ADFUtils.findIterator("FindPolicyRecptInstlmntsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.polRecptsInslmntsLOV);
      
      GlobalCC.INFORMATIONREPORTING("Receipts Payment Allocations Done Successfully.");
      conn.close();
    }
    catch (Exception ex)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, ex);
    }
    return null;
  }
  
  public String AllocateToPremium()
  {
    Connection conn = null;
    try
    {
      DCIteratorBinding dciter = ADFUtils.findIterator("FindPolicyReceiptsIterator");
      
      RowKeySet set = this.policyReceiptsLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      while (rowKeySetIter.hasNext())
      {
        List l = (List)rowKeySetIter.next();
        Key key = (Key)l.get(0);
        dciter.setCurrentRowWithKey(key.toStringFormat(true));
        Row r = dciter.getCurrentRow();
        

        this.session.setAttribute("GrctCode", r.getAttribute("GRCT_CODE"));
      }
      String authQuery = "BEGIN LMS_GRP_MISC.allocate_receipt_prem(?,?,?);END;";
      
      conn = new DBConnector().getDatabaseConn();
      
      CallableStatement cstmt = conn.prepareCall(authQuery);
      cstmt.setBigDecimal(1, (BigDecimal)this.session.getAttribute("GrctCode"));
      
      cstmt.setBigDecimal(2, (BigDecimal)this.session.getAttribute("ReceiptTransNo"));
      
      cstmt.setString(3, "PR");
      cstmt.execute();
      cstmt.close();
      
      ADFUtils.findIterator("FindPolicyRecptInstlmntsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.polRecptsInslmntsLOV);
      
      GlobalCC.INFORMATIONREPORTING("Allocation to Premium Done Successfully");
      conn.close();
    }
    catch (Exception ex)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, ex);
    }
    return null;
  }
  
  public String DistributePremToMembers()
  {
    Connection conn = null;
    try
    {
      String authQuery = "BEGIN lms_web_pkg_grp_uw.dist_prem_to_mem(?);END;";
      
      conn = new DBConnector().getDatabaseConn();
      CallableStatement cstmt = conn.prepareCall(authQuery);
      
      DCIteratorBinding dciter = ADFUtils.findIterator("FindPolicyReceiptsIterator");
      
      RowKeySet set = this.policyReceiptsLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      while (rowKeySetIter.hasNext())
      {
        List l = (List)rowKeySetIter.next();
        Key key = (Key)l.get(0);
        dciter.setCurrentRowWithKey(key.toStringFormat(true));
        Row r = dciter.getCurrentRow();
        
        this.session.setAttribute("GrctCode", r.getAttribute("GRCT_CODE"));
        System.out.println("GRCT CODE" + r.getAttribute("GRCT_CODE"));
        cstmt.setBigDecimal(1, (BigDecimal)this.session.getAttribute("GrctCode"));
        
        cstmt.execute();
      }
      cstmt.close();
      conn.close();
      if (this.session.getAttribute("GrctCode") == null) {
        GlobalCC.errorValueNotEntered("No receipt Selected.");
      } else {
        GlobalCC.RedirectPage("/g_allocations.jspx");
      }
    }
    catch (Exception ex)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, ex);
    }
    return null;
  }
  
  public String ProcessPremToMembers()
  {
    Connection conn = null;
    try
    {
      Integer Val = (Integer)this.session.getAttribute("receiptTemplateSeq");
      if (Val.intValue() == 0)
      {
        GlobalCC.errorValueNotEntered("Import a Member Premium Schedule First");
        return null;
      }
      String authQuery = "BEGIN lms_web_pkg_grp_uw.process_mem_prem_dist(?,?,?,?);END;";
      
      conn = new DBConnector().getDatabaseConn();
      
      CallableStatement cstmt = conn.prepareCall(authQuery);
      cstmt.setBigDecimal(1, (BigDecimal)this.session.getAttribute("GrctCode"));
      
      cstmt.setBigDecimal(2, (BigDecimal)this.session.getAttribute("policyCode"));
      
      cstmt.setInt(3, ((Integer)this.session.getAttribute("receiptTemplateSeq")).intValue());
      
      cstmt.setBigDecimal(4, (BigDecimal)this.session.getAttribute("ReceiptTransNo"));
      
      cstmt.execute();
      cstmt.close();
      GlobalCC.INFORMATIONREPORTING("Payment Processing Completed Successfully");
      conn.close();
    }
    catch (Exception ex)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, ex);
    }
    return null;
  }
  
  public String ProcessPensToMembers()
  {
    Connection conn = null;
    try
    {
      Integer Val = (Integer)this.session.getAttribute("receiptTemplateSeq");
      if (Val.intValue() == 0)
      {
        String Message = "Import a Member Premium Schedule First";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Message, Message));
        


        return null;
      }
      String authQuery = "BEGIN lms_web_pkg_grp_uw.process_pension_payments(?,?,?);END;";
      
      conn = new DBConnector().getDatabaseConn();
      
      CallableStatement cstmt = conn.prepareCall(authQuery);
      cstmt.setBigDecimal(1, (BigDecimal)this.session.getAttribute("PNDP_CODE"));
      
      cstmt.setBigDecimal(2, (BigDecimal)this.session.getAttribute("policyCode"));
      
      cstmt.setInt(3, ((Integer)this.session.getAttribute("receiptTemplateSeq")).intValue());
      
      cstmt.execute();
      cstmt.close();
      GlobalCC.INFORMATIONREPORTING("Pension Processing Completed Successfully");
      conn.close();
    }
    catch (Exception ex)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, ex);
    }
    return null;
  }
  
  public void setPolicyNumberDisplay(RichInputText policyNumberDisplay)
  {
    this.policyNumberDisplay = policyNumberDisplay;
  }
  
  public RichInputText getPolicyNumberDisplay()
  {
    return this.policyNumberDisplay;
  }
  
  public void setPolicyPremiumsLOV(RichTable policyPremiumsLOV)
  {
    this.policyPremiumsLOV = policyPremiumsLOV;
  }
  
  public RichTable getPolicyPremiumsLOV()
  {
    return this.policyPremiumsLOV;
  }
  
  public void setMonth(RichInputText month)
  {
    this.month = month;
  }
  
  public RichInputText getMonth()
  {
    return this.month;
  }
  
  public void setYear(RichInputText year)
  {
    this.year = year;
  }
  
  public RichInputText getYear()
  {
    return this.year;
  }
  
  public void setAmount(RichInputText amount)
  {
    this.amount = amount;
  }
  
  public RichInputText getAmount()
  {
    return this.amount;
  }
  
  public void setPolicyReceiptsLOV(RichTable policyReceiptsLOV)
  {
    this.policyReceiptsLOV = policyReceiptsLOV;
  }
  
  public RichTable getPolicyReceiptsLOV()
  {
    return this.policyReceiptsLOV;
  }
  
  public void setPolRecptsInslmntsLOV(RichTable polRecptsInslmntsLOV)
  {
    this.polRecptsInslmntsLOV = polRecptsInslmntsLOV;
  }
  
  public RichTable getPolRecptsInslmntsLOV()
  {
    return this.polRecptsInslmntsLOV;
  }
  
  public void setUnallocMembers(RichTable unallocMembers)
  {
    this.unallocMembers = unallocMembers;
  }
  
  public RichTable getUnallocMembers()
  {
    return this.unallocMembers;
  }
  
  public void setSelMembersLOV(RichTable selMembersLOV)
  {
    this.selMembersLOV = selMembersLOV;
  }
  
  public RichTable getSelMembersLOV()
  {
    return this.selMembersLOV;
  }
  
  public void setDistLOV(RichTable distLOV)
  {
    this.distLOV = distLOV;
  }
  
  public RichTable getDistLOV()
  {
    return this.distLOV;
  }
  
  public void setPolicyDesc(RichInputText policyDesc)
  {
    this.policyDesc = policyDesc;
  }
  
  public RichInputText getPolicyDesc()
  {
    return this.policyDesc;
  }
  
  public void setPoliciesLOV(RichTable policiesLOV)
  {
    this.policiesLOV = policiesLOV;
  }
  
  public RichTable getPoliciesLOV()
  {
    return this.policiesLOV;
  }
  
  public String findPolicySelected()
  {
    DCIteratorBinding dciter = ADFUtils.findIterator("FindPoliciesIterator");
    
    RowKeySet set = this.policiesLOV.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();
    while (rowKeySetIter.hasNext())
    {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();
      
      this.policyDesc.setValue(r.getAttribute("POL_POLICY_NO"));
    }
    GlobalCC.showPopup("lmsgroup:p1");
    return null;
  }
  
  public String findProductSelected()
  {
    DCIteratorBinding dciter = ADFUtils.findIterator("findProductsIterator");
    
    RowKeySet set = this.debitProductLOV.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();
    while (rowKeySetIter.hasNext())
    {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();
      
      this.session.setAttribute("ProductCode", r.getAttribute("prodCode"));
      this.debitProductDesc.setValue(r.getAttribute("prodDesc"));
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.debitProductDesc);
    }
    GlobalCC.hidePopup("lmsgroup:products");
    return null;
  }
  
  public String findClientsSelected()
  {
    DCIteratorBinding dciter = ADFUtils.findIterator("findProposersIterator");
    
    RowKeySet set = this.debitClientsLOV.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();
    while (rowKeySetIter.hasNext())
    {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();
      
      this.session.setAttribute("prpCode", r.getAttribute("PRP_CODE"));
      this.debitClientsDesc.setValue(r.getAttribute("CLIENT"));
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.debitClientsDesc);
    }
    GlobalCC.hidePopup("lmsgroup:clients");
    return null;
  }
  
  public String findBranchSelected()
  {
    DCIteratorBinding dciter = ADFUtils.findIterator("findBranchesIterator");
    
    RowKeySet set = this.branchesLOV.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();
    while (rowKeySetIter.hasNext())
    {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();
      
      this.session.setAttribute("branchCode", r.getAttribute("BRN_CODE"));
      this.debitBranchDesc.setValue(r.getAttribute("BRN_NAME"));
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.debitBranchDesc);
    }
    GlobalCC.hidePopup("lmsgroup:branches");
    return null;
  }
  
  public String findAgenciesSelected()
  {
    DCIteratorBinding dciter = ADFUtils.findIterator("FindAgentsIterator");
    RowKeySet set = this.agenciesLOV.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();
    while (rowKeySetIter.hasNext())
    {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();
      
      this.session.setAttribute("agnCode", r.getAttribute("AGN_CODE"));
      this.agencyDesc.setValue(r.getAttribute("AGN_NAME"));
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.agencyDesc);
    }
    GlobalCC.hidePopup("lmsgroup:agencies");
    return null;
  }
  
  public String AddLoadedBalance()
  {
    try
    {
      if ((!this.creditsCbox.isSelected()) && (!this.debitsCbox.isSelected()))
      {
        GlobalCC.sysInformation("Select if it is a Debit or Credit Transaction.");
        return null;
      }
      if (this.creditsCbox.isSelected())
      {
        this.policyDesc.setValue(null);
        this.balanceAmount.setValue(null);
        this.balanceDate.setValue(null);
        this.loadRemarks.setValue(null);
        
        this.session.setAttribute("gblCode", null);
        this.session.setAttribute("action", "A");
        GlobalCC.showPopup("lmsgroup:p1");
      }
      else
      {
        this.debitPolicyNo.setValue(null);
        this.debitProductDesc.setValue(null);
        this.session.setAttribute("ProductCode", null);
        this.debitClientsDesc.setValue(null);
        this.session.setAttribute("prpCode", null);
        this.debitBranchDesc.setValue(null);
        this.session.setAttribute("branchCode", null);
        this.frequencyOfPayment.setValue("A");
        this.durationType.setValue("A");
        this.debitAmount.setValue(null);
        this.effectiveDate.setValue(null);
        this.debitBalDate.setValue(null);
        this.session.setAttribute("agnCode", null);
        this.agencyDesc.setValue(null);
        
        this.session.setAttribute("gblCode", null);
        this.session.setAttribute("action", "A");
        GlobalCC.showPopup("lmsgroup:p3");
      }
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
    return null;
  }
  
  public String EditLoadedBalance()
  {
    try
    {
      DCIteratorBinding dciter = ADFUtils.findIterator("findLoadedBalancesIterator");
      
      RowKeySet set = this.loadedBalances.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      while (rowKeySetIter.hasNext())
      {
        List l = (List)rowKeySetIter.next();
        Key key = (Key)l.get(0);
        dciter.setCurrentRowWithKey(key.toStringFormat(true));
        Row r = dciter.getCurrentRow();
        
        String Loaded = (String)r.getAttribute("LOADED");
        if (Loaded != null) {
          if (Loaded.equalsIgnoreCase("Y"))
          {
            GlobalCC.INFORMATIONREPORTING("This record has already been loaded");
            return null;
          }
        }
        this.policyDesc.setValue(r.getAttribute("POLICY_NO"));
        this.balanceAmount.setValue(r.getAttribute("AMOUNT"));
        this.balanceDate.setValue(r.getAttribute("BAL_DATE"));
        this.loadRemarks.setValue(r.getAttribute("LOAD_REMARKS"));
        this.session.setAttribute("gblCode", r.getAttribute("GBL_CODE"));
      }
      this.session.setAttribute("action", "E");
      GlobalCC.showPopup("lmsgroup:p1");
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
    return null;
  }
  
  public String DeleteLoadedBalance()
  {
    try
    {
      DCIteratorBinding dciter = ADFUtils.findIterator("findLoadedBalancesIterator");
      
      RowKeySet set = this.loadedBalances.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      while (rowKeySetIter.hasNext())
      {
        List l = (List)rowKeySetIter.next();
        Key key = (Key)l.get(0);
        dciter.setCurrentRowWithKey(key.toStringFormat(true));
        Row r = dciter.getCurrentRow();
        
        String Loaded = (String)r.getAttribute("LOADED");
        if (Loaded != null) {
          if (Loaded.equalsIgnoreCase("Y"))
          {
            GlobalCC.INFORMATIONREPORTING("This record has already been loaded");
            return null;
          }
        }
        this.session.setAttribute("gblCode", r.getAttribute("GBL_CODE"));
      }
      this.session.setAttribute("action", "D");
      
      SaveLoadedBalance();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
    return null;
  }
  
  public String SaveLoadedBalance()
  {
    Connection conn = null;
    try
    {
      if (this.policyDesc.getValue() == null)
      {
        GlobalCC.INFORMATIONREPORTING("Select A Policy");
        return null;
      }
      String authQuery = "BEGIN lms_web_pkg_grp_uw.save_loaded_balance(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);END;";
      
      conn = new DBConnector().getDatabaseConn();
      
      CallableStatement cstmt = conn.prepareCall(authQuery);
      cstmt.setString(1, (String)this.session.getAttribute("action"));
      cstmt.setBigDecimal(2, (BigDecimal)this.session.getAttribute("gblCode"));
      
      String MyPolicy = this.policyDesc.getValue().toString();
      MyPolicy = MyPolicy.replaceAll("\\s+$", "");
      MyPolicy = MyPolicy.replaceAll("^\\s+", "");
      cstmt.setString(3, MyPolicy);
      if (this.balanceAmount.getValue() == null) {
        cstmt.setString(4, null);
      } else {
        cstmt.setString(4, this.balanceAmount.getValue().toString());
      }
      if (this.balanceDate.getValue() == null) {
        cstmt.setString(5, null);
      } else if (this.balanceDate.getValue().toString().contains(":")) {
        cstmt.setString(5, GlobalCC.parseDate(this.balanceDate.getValue().toString()));
      } else {
        cstmt.setString(5, GlobalCC.upDateParseDate(this.balanceDate.getValue().toString()));
      }
      if (this.loadRemarks.getValue() == null) {
        cstmt.setString(6, null);
      } else {
        cstmt.setString(6, this.loadRemarks.getValue().toString());
      }
      if (this.creditsCbox.isSelected()) {
        cstmt.setString(7, "C");
      } else {
        cstmt.setString(7, "D");
      }
      cstmt.setBigDecimal(8, null);
      cstmt.setBigDecimal(9, null);
      cstmt.setBigDecimal(10, null);
      cstmt.setString(11, null);
      cstmt.setString(12, null);
      cstmt.setString(13, null);
      cstmt.setBigDecimal(14, null);
      cstmt.setString(15, (String)this.endrTypes.getValue());
      cstmt.setString(16, (String)this.allocDecSel.getValue());
      cstmt.setString(17, (String)this.commSelect.getValue());
      cstmt.execute();
      cstmt.close();
      
      GlobalCC.INFORMATIONREPORTING("Loaded Balance Successfully Captured.");
      ADFUtils.findIterator("findLoadedBalancesIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.loadedBalances);
      
      GlobalCC.hidePopup("lmsgroup:p1");
      
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
  }
  
  public String SaveLoadedDebitBalance()
  {
    Connection conn = null;
    try
    {
      if (this.debitPolicyNo.getValue() == null)
      {
        GlobalCC.INFORMATIONREPORTING("Enter A Policy");
        return null;
      }
      String authQuery = "BEGIN lms_web_pkg_grp_uw.save_loaded_balance(?,?,?,?,?,?,?,?,?,?,?,?,?,?);END;";
      
      conn = new DBConnector().getDatabaseConn();
      
      CallableStatement cstmt = conn.prepareCall(authQuery);
      cstmt.setString(1, (String)this.session.getAttribute("action"));
      cstmt.setBigDecimal(2, (BigDecimal)this.session.getAttribute("gblCode"));
      
      String MyPolicy = this.debitPolicyNo.getValue().toString();
      MyPolicy = MyPolicy.replaceAll("\\s+$", "");
      MyPolicy = MyPolicy.replaceAll("^\\s+", "");
      cstmt.setString(3, MyPolicy);
      if (this.debitAmount.getValue() == null) {
        cstmt.setString(4, null);
      } else {
        cstmt.setString(4, this.debitAmount.getValue().toString());
      }
      if (this.debitBalDate.getValue() == null) {
        cstmt.setString(5, null);
      } else if (this.debitBalDate.getValue().toString().contains(":")) {
        cstmt.setString(5, GlobalCC.parseDate(this.debitBalDate.getValue().toString()));
      } else {
        cstmt.setString(5, GlobalCC.upDateParseDate(this.debitBalDate.getValue().toString()));
      }
      cstmt.setString(6, null);
      if (this.creditsCbox.isSelected()) {
        cstmt.setString(7, "C");
      } else {
        cstmt.setString(7, "D");
      }
      cstmt.setBigDecimal(8, (BigDecimal)this.session.getAttribute("ProductCode"));
      
      cstmt.setBigDecimal(9, (BigDecimal)this.session.getAttribute("prpCode"));
      
      cstmt.setBigDecimal(10, (BigDecimal)this.session.getAttribute("branchCode"));
      if (this.frequencyOfPayment.getValue() == null) {
        cstmt.setString(11, null);
      } else {
        cstmt.setString(11, this.frequencyOfPayment.getValue().toString());
      }
      if (this.durationType.getValue() == null) {
        cstmt.setString(12, null);
      } else {
        cstmt.setString(12, this.durationType.getValue().toString());
      }
      if (this.effectiveDate.getValue() == null) {
        cstmt.setString(13, null);
      } else if (this.effectiveDate.getValue().toString().contains(":")) {
        cstmt.setString(13, GlobalCC.parseDate(this.effectiveDate.getValue().toString()));
      } else {
        cstmt.setString(13, GlobalCC.upDateParseDate(this.effectiveDate.getValue().toString()));
      }
      cstmt.setBigDecimal(14, (BigDecimal)this.session.getAttribute("agnCode"));
      
      cstmt.execute();
      cstmt.close();
      
      GlobalCC.INFORMATIONREPORTING("Loaded Balance Successfully Captured.");
      ADFUtils.findIterator("findLoadedBalancesIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.loadedBalances);
      
      GlobalCC.hidePopup("lmsgroup:p3");
      
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
  }
  
  public String ProcessLoadedBalances()
  {
    Connection conn = null;
    try
    {
      String authQuery = "BEGIN TQ_LMS.Load_grp_pol_bal(?,?,?);END;";
      conn = new DBConnector().getDatabaseConn();
      
      DCIteratorBinding dciter = ADFUtils.findIterator("findLoadedBalancesIterator");
      
      RowKeySet set = this.loadedBalances.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();
      while (rowKeySetIter.hasNext())
      {
        List l = (List)rowKeySetIter.next();
        Key key = (Key)l.get(0);
        dciter.setCurrentRowWithKey(key.toStringFormat(true));
        Row r = dciter.getCurrentRow();
        
        CallableStatement cstmt = conn.prepareCall(authQuery);
        cstmt.setString(1, (String)r.getAttribute("POLICY_NO"));
        cstmt.setString(2, (String)r.getAttribute("LOADED"));
        cstmt.setString(3, (String)this.session.getAttribute("Username"));
        cstmt.execute();
        cstmt.close();
        
        GlobalCC.INFORMATIONREPORTING("Loaded Balance Successfully Processed.");
        ADFUtils.findIterator("findLoadedBalancesIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.loadedBalances);
      }
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
  }
  
  public void setBalanceAmount(RichInputNumberSpinbox balanceAmount)
  {
    this.balanceAmount = balanceAmount;
  }
  
  public RichInputNumberSpinbox getBalanceAmount()
  {
    return this.balanceAmount;
  }
  
  public void setBalanceDate(RichInputDate balanceDate)
  {
    this.balanceDate = balanceDate;
  }
  
  public RichInputDate getBalanceDate()
  {
    return this.balanceDate;
  }
  
  public void setLoadRemarks(RichInputText loadRemarks)
  {
    this.loadRemarks = loadRemarks;
  }
  
  public RichInputText getLoadRemarks()
  {
    return this.loadRemarks;
  }
  
  public void setLoadedBalances(RichTable loadedBalances)
  {
    this.loadedBalances = loadedBalances;
  }
  
  public RichTable getLoadedBalances()
  {
    return this.loadedBalances;
  }
  
  public void setCreditsCbox(RichSelectBooleanRadio creditsCbox)
  {
    this.creditsCbox = creditsCbox;
  }
  
  public RichSelectBooleanRadio getCreditsCbox()
  {
    return this.creditsCbox;
  }
  
  public void setDebitsCbox(RichSelectBooleanRadio debitsCbox)
  {
    this.debitsCbox = debitsCbox;
  }
  
  public RichSelectBooleanRadio getDebitsCbox()
  {
    return this.debitsCbox;
  }
  
  public void setDebitPolicyNo(RichInputText debitPolicyNo)
  {
    this.debitPolicyNo = debitPolicyNo;
  }
  
  public RichInputText getDebitPolicyNo()
  {
    return this.debitPolicyNo;
  }
  
  public void setDebitProductDesc(RichInputText debitProductDesc)
  {
    this.debitProductDesc = debitProductDesc;
  }
  
  public RichInputText getDebitProductDesc()
  {
    return this.debitProductDesc;
  }
  
  public void setDebitProductLOV(RichTable debitProductLOV)
  {
    this.debitProductLOV = debitProductLOV;
  }
  
  public RichTable getDebitProductLOV()
  {
    return this.debitProductLOV;
  }
  
  public void setDebitClientsDesc(RichInputText debitClientsDesc)
  {
    this.debitClientsDesc = debitClientsDesc;
  }
  
  public RichInputText getDebitClientsDesc()
  {
    return this.debitClientsDesc;
  }
  
  public void setDebitClientsLOV(RichTable debitClientsLOV)
  {
    this.debitClientsLOV = debitClientsLOV;
  }
  
  public RichTable getDebitClientsLOV()
  {
    return this.debitClientsLOV;
  }
  
  public void setDebitBranchDesc(RichInputText debitBranchDesc)
  {
    this.debitBranchDesc = debitBranchDesc;
  }
  
  public RichInputText getDebitBranchDesc()
  {
    return this.debitBranchDesc;
  }
  
  public void setFrequencyOfPayment(RichSelectOneChoice frequencyOfPayment)
  {
    this.frequencyOfPayment = frequencyOfPayment;
  }
  
  public RichSelectOneChoice getFrequencyOfPayment()
  {
    return this.frequencyOfPayment;
  }
  
  public void setDurationType(RichSelectOneChoice durationType)
  {
    this.durationType = durationType;
  }
  
  public RichSelectOneChoice getDurationType()
  {
    return this.durationType;
  }
  
  public void setDebitAmount(RichInputNumberSpinbox debitAmount)
  {
    this.debitAmount = debitAmount;
  }
  
  public RichInputNumberSpinbox getDebitAmount()
  {
    return this.debitAmount;
  }
  
  public void setBranchesLOV(RichTable branchesLOV)
  {
    this.branchesLOV = branchesLOV;
  }
  
  public RichTable getBranchesLOV()
  {
    return this.branchesLOV;
  }
  
  public void setEffectiveDate(RichInputDate effectiveDate)
  {
    this.effectiveDate = effectiveDate;
  }
  
  public RichInputDate getEffectiveDate()
  {
    return this.effectiveDate;
  }
  
  public void setDebitBalDate(RichInputDate debitBalDate)
  {
    this.debitBalDate = debitBalDate;
  }
  
  public RichInputDate getDebitBalDate()
  {
    return this.debitBalDate;
  }
  
  public void setAgencyDesc(RichInputText agencyDesc)
  {
    this.agencyDesc = agencyDesc;
  }
  
  public RichInputText getAgencyDesc()
  {
    return this.agencyDesc;
  }
  
  public void setAgenciesLOV(RichTable agenciesLOV)
  {
    this.agenciesLOV = agenciesLOV;
  }
  
  public RichTable getAgenciesLOV()
  {
    return this.agenciesLOV;
  }
  
  public void setProductsDesc(RichInputText productsDesc)
  {
    this.productsDesc = productsDesc;
  }
  
  public RichInputText getProductsDesc()
  {
    return this.productsDesc;
  }
  
  public void setProductsLOV(RichTable productsLOV)
  {
    this.productsLOV = productsLOV;
  }
  
  public RichTable getProductsLOV()
  {
    return this.productsLOV;
  }
  
  public void setMemberAllocationsTable(RichTable memberAllocationsTable)
  {
    this.memberAllocationsTable = memberAllocationsTable;
  }
  
  public RichTable getMemberAllocationsTable()
  {
    return this.memberAllocationsTable;
  }
  
  public void setAllocAmt(RichOutputText allocAmt)
  {
    this.allocAmt = allocAmt;
  }
  
  public RichOutputText getAllocAmt()
  {
    return this.allocAmt;
  }
  
  public void setAllocBalance(RichOutputText allocBalance)
  {
    this.allocBalance = allocBalance;
  }
  
  public RichOutputText getAllocBalance()
  {
    return this.allocBalance;
  }
  
  public void setRefPolNo(RichInputText refPolNo)
  {
    this.refPolNo = refPolNo;
  }
  
  public RichInputText getRefPolNo()
  {
    return this.refPolNo;
  }
  
  public void setRefPremDisplay(RichInputText refPremDisplay)
  {
    this.refPremDisplay = refPremDisplay;
  }
  
  public RichInputText getRefPremDisplay()
  {
    return this.refPremDisplay;
  }
  
  public void setRefTotalDisplay(RichInputText refTotalDisplay)
  {
    this.refTotalDisplay = refTotalDisplay;
  }
  
  public RichInputText getRefTotalDisplay()
  {
    return this.refTotalDisplay;
  }
  
  public void setRefPensDisplay(RichInputText refPensDisplay)
  {
    this.refPensDisplay = refPensDisplay;
  }
  
  public RichInputText getRefPensDisplay()
  {
    return this.refPensDisplay;
  }
  
  public void setNewPremAlloc(RichInputText newPremAlloc)
  {
    this.newPremAlloc = newPremAlloc;
  }
  
  public RichInputText getNewPremAlloc()
  {
    return this.newPremAlloc;
  }
  
  public void setNewPensAlloc(RichInputText newPensAlloc)
  {
    this.newPensAlloc = newPensAlloc;
  }
  
  public RichInputText getNewPensAlloc()
  {
    return this.newPensAlloc;
  }
  
  public void setNewTotReceipt(RichInputText newTotReceipt)
  {
    this.newTotReceipt = newTotReceipt;
  }
  
  public RichInputText getNewTotReceipt()
  {
    return this.newTotReceipt;
  }
  
  public void setRefTotal(RichInputText refTotal)
  {
    this.refTotal = refTotal;
  }
  
  public RichInputText getRefTotal()
  {
    return this.refTotal;
  }
  
  public void newPremAllocListener(ValueChangeEvent valueChangeEvent)
  {
    Double newPrem = Double.valueOf(0.0D);
    Double newPension = Double.valueOf(0.0D);
    Double totalReceipt = Double.valueOf(0.0D);
    Double totRefundable = Double.valueOf(0.0D);
    try
    {
      if (this.newPremAlloc.getValue() == "") {
        newPrem = Double.valueOf(0.0D);
      } else {
        newPrem = Double.valueOf(Double.parseDouble(this.newPremAlloc.getValue().toString()));
      }
      if (this.newPensAlloc.getValue() == "") {
        newPension = Double.valueOf(0.0D);
      } else {
        newPension = Double.valueOf(Double.parseDouble(this.newPensAlloc.getValue().toString()));
      }
      totalReceipt = Double.valueOf(newPrem.doubleValue() + newPension.doubleValue());
    }
    catch (Exception e) {}
    totRefundable = Double.valueOf(Double.parseDouble(this.refTotalDisplay.getValue().toString()) - totalReceipt.doubleValue());
    if (totRefundable.doubleValue() <= 0.0D) {
      GlobalCC.INFORMATIONREPORTING("Refundable amount cannot be less or equal to zero");
    }
    this.newTotReceipt.setValue(totalReceipt);
    this.refTotal.setValue(totRefundable);
    
    AdfFacesContext.getCurrentInstance().addPartialTarget(this.newPremAlloc);
    AdfFacesContext.getCurrentInstance().addPartialTarget(this.newPensAlloc);
    AdfFacesContext.getCurrentInstance().addPartialTarget(this.newTotReceipt);
    AdfFacesContext.getCurrentInstance().addPartialTarget(this.refTotal);
  }
  
  public void newPensionAllocListener(ValueChangeEvent valueChangeEvent)
  {
    Double newPrem = Double.valueOf(0.0D);
    Double newPension = Double.valueOf(0.0D);
    Double totalReceipt = Double.valueOf(0.0D);
    Double totRefundable = Double.valueOf(0.0D);
    try
    {
      if (this.newPremAlloc.getValue() == "") {
        newPrem = Double.valueOf(0.0D);
      } else {
        newPrem = Double.valueOf(Double.parseDouble(this.newPremAlloc.getValue().toString()));
      }
      if (this.newPensAlloc.getValue() == "") {
        newPension = Double.valueOf(0.0D);
      } else {
        newPension = Double.valueOf(Double.parseDouble(this.newPensAlloc.getValue().toString()));
      }
      totalReceipt = Double.valueOf(newPrem.doubleValue() + newPension.doubleValue());
    }
    catch (Exception e) {}
    totRefundable = Double.valueOf(Double.parseDouble(this.refTotalDisplay.getValue().toString()) - totalReceipt.doubleValue());
    if (totRefundable.doubleValue() <= 0.0D) {
      GlobalCC.INFORMATIONREPORTING("Refundable amount cannot be less or equal to zero");
    }
    this.newTotReceipt.setValue(totalReceipt);
    this.refTotal.setValue(totRefundable);
    
    AdfFacesContext.getCurrentInstance().addPartialTarget(this.newPremAlloc);
    AdfFacesContext.getCurrentInstance().addPartialTarget(this.newPensAlloc);
    AdfFacesContext.getCurrentInstance().addPartialTarget(this.newTotReceipt);
    AdfFacesContext.getCurrentInstance().addPartialTarget(this.refTotal);
  }
  
  public void setPayee(RichInputText payee)
  {
    this.payee = payee;
  }
  
  public RichInputText getPayee()
  {
    return this.payee;
  }
  
  public String authoriseRefund()
  {
    String authRefund = "BEGIN LMS_WEB_PKG_GRP.auth_refund(?,?,?,?,?,?,?,?);END;";
    
    Connection conn = new DBConnector().getDatabaseConn();
    CallableStatement cstmt = null;
    try
    {
      cstmt = conn.prepareCall(authRefund);
      cstmt.setBigDecimal(1, (BigDecimal)this.session.getAttribute("GrctCode"));
      
      cstmt.setBigDecimal(2, (BigDecimal)this.session.getAttribute("policyCode"));
      
      cstmt.setString(3, (String)this.session.getAttribute("Username"));
      if (this.refTotalDisplay.getValue() == null) {
        cstmt.setString(4, null);
      } else {
        cstmt.setString(4, this.refTotalDisplay.getValue().toString());
      }
      if (this.refTotal.getValue() == null) {
        cstmt.setString(5, null);
      } else {
        cstmt.setString(5, this.refTotal.getValue().toString());
      }
      if (this.newPremAlloc.getValue() == null) {
        cstmt.setString(6, null);
      } else {
        cstmt.setString(6, this.newPremAlloc.getValue().toString());
      }
      if (this.newPensAlloc.getValue() == null) {
        cstmt.setString(7, null);
      } else {
        cstmt.setString(7, this.newPensAlloc.getValue().toString());
      }
      if (this.payee.getValue() == null) {
        cstmt.setString(8, null);
      } else {
        cstmt.setString(8, this.payee.getValue().toString());
      }
      cstmt.execute();
      conn.close();
      ADFUtils.findIterator("FindMembersPensionDepositsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.memDepositsLOV);
      
      ADFUtils.findIterator("findPremiumMemberCovers_AllIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.memberAllocationsTable);
      
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.allocAmt);
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.allocBalance);
      

      AdfFacesContext.getCurrentInstance().addPartialTarget(this.refPremDisplay);
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.refPensDisplay);
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.refTotalDisplay);
      GlobalCC.INFORMATIONREPORTING("Refund successful");
    }
    catch (Exception ex)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, ex);
    }
    finally
    {
      GlobalCC.CloseConnections(null, cstmt, conn);
    }
    return null;
  }
  
  public String EditLoadedBalanceReceipt()
  {
    String authTransfer = "BEGIN LMS_GRP_MISC.find_loaded_receipts(?,?);END;";
    
    Connection conn = new DBConnector().getDatabaseConn();
    CallableStatement cstmt = null;
    try
    {
      RowKeySet rowKeySet = this.policyReceiptsLOV.getSelectedRowKeys();
      String str1;
      if (rowKeySet == null) {
        return null;
      }
      if (!rowKeySet.iterator().hasNext())
      {
        GlobalCC.errorValueNotEntered("No Record Selected");
        return null;
      }
      Object key2 = rowKeySet.iterator().next();
      this.policyReceiptsLOV.setRowKey(key2);
      JUCtrlValueBinding r = (JUCtrlValueBinding)this.policyReceiptsLOV.getRowData();
      if (r == null)
      {
        GlobalCC.errorValueNotEntered("No Record Selected");
        return null;
      }
      cstmt = conn.prepareCall(authTransfer);
      cstmt.setBigDecimal(1, (BigDecimal)r.getAttribute("GRCT_CODE"));
      cstmt.registerOutParameter(2, 12);
      cstmt.execute();
      
      String Loaded = cstmt.getString(2);
      cstmt.close();
      conn.close();
      if (Loaded.equalsIgnoreCase("N"))
      {
        GlobalCC.INFORMATIONREPORTING("Only Receipts that were loaded can be Editted.");
        return null;
      }
      this.session.setAttribute("GrctCode", r.getAttribute("GRCT_CODE"));
      this.rcptNo.setValue(r.getAttribute("GRCT_RECEIPT_NO"));
      
      this.rcptAmount.setValue(r.getAttribute("GRCT_AMT"));
      this.rcptAllocToPens.setValue(r.getAttribute("GRCT_PENS_PYMT_AMT"));
      this.rcptAllocToPrem.setValue(r.getAttribute("GRCT_PREM_PYMNT_AMT"));
      
      GlobalCC.showPopup("lmsgroup:edLoadedRcpt");
    }
    catch (Exception ex)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, ex);
    }
    finally
    {
      GlobalCC.CloseConnections(null, cstmt, conn);
    }
    return null;
  }
  
  public String SaveLoadedReceipt()
  {
    String transferQuery = "BEGIN LMS_GRP_MISC.Edit_loaded_receipts(?,?,?,?);END;";
    
    Connection conn = new DBConnector().getDatabaseConn();
    CallableStatement cstmt = null;
    try
    {
      String str1;
      if (this.rcptAmount.getValue() == null)
      {
        GlobalCC.INFORMATIONREPORTING("Enter A Receipt Amount");
        return null;
      }
      if ((this.rcptAllocToPens.getValue() == null) && (this.rcptAllocToPrem.getValue() == null))
      {
        GlobalCC.INFORMATIONREPORTING("Allocate the Receipt Amount either to Premium or Pension");
        return null;
      }
      cstmt = conn.prepareCall(transferQuery);
      cstmt.setBigDecimal(1, (BigDecimal)this.session.getAttribute("GrctCode"));
      if (this.rcptAmount.getValue() == null) {
        cstmt.setString(2, null);
      } else {
        cstmt.setString(2, this.rcptAmount.getValue().toString());
      }
      if (this.rcptAllocToPens.getValue() == null) {
        cstmt.setString(3, null);
      } else {
        cstmt.setString(3, this.rcptAllocToPens.getValue().toString());
      }
      if (this.rcptAllocToPrem.getValue() == null) {
        cstmt.setString(4, null);
      } else {
        cstmt.setString(4, this.rcptAllocToPrem.getValue().toString());
      }
      cstmt.execute();
      cstmt.close();
      

      ADFUtils.findIterator("FindPolicyReceiptsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.policyReceiptsLOV);
      
      GlobalCC.hidePopup("lmsgroup:edLoadedRcpt");
      GlobalCC.INFORMATIONREPORTING("Record Successfully Saved.");
      conn.close();
    }
    catch (Exception ex)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, ex);
    }
    finally
    {
      GlobalCC.CloseConnections(null, cstmt, conn);
    }
    return null;
  }
  
  public void setEndrTypes(RichSelectOneChoice endrTypes)
  {
    this.endrTypes = endrTypes;
  }
  
  public RichSelectOneChoice getEndrTypes()
  {
    return this.endrTypes;
  }
  
  public void setRcptNo(RichOutputText rcptNo)
  {
    this.rcptNo = rcptNo;
  }
  
  public RichOutputText getRcptNo()
  {
    return this.rcptNo;
  }
  
  public void setRcptDate(RichInputDate rcptDate)
  {
    this.rcptDate = rcptDate;
  }
  
  public RichInputDate getRcptDate()
  {
    return this.rcptDate;
  }
  
  public void setRcptAmount(RichInputNumberSpinbox rcptAmount)
  {
    this.rcptAmount = rcptAmount;
  }
  
  public RichInputNumberSpinbox getRcptAmount()
  {
    return this.rcptAmount;
  }
  
  public void setRcptAllocToPens(RichInputNumberSpinbox rcptAllocToPens)
  {
    this.rcptAllocToPens = rcptAllocToPens;
  }
  
  public RichInputNumberSpinbox getRcptAllocToPens()
  {
    return this.rcptAllocToPens;
  }
  
  public void setRcptAllocToPrem(RichInputNumberSpinbox rcptAllocToPrem)
  {
    this.rcptAllocToPrem = rcptAllocToPrem;
  }
  
  public RichInputNumberSpinbox getRcptAllocToPrem()
  {
    return this.rcptAllocToPrem;
  }
  
  public void setAllocDecSel(RichSelectOneChoice allocDecSel)
  {
    this.allocDecSel = allocDecSel;
  }
  
  public RichSelectOneChoice getAllocDecSel()
  {
    return this.allocDecSel;
  }
  
  public void setCommSelect(RichSelectOneChoice commSelect)
  {
    this.commSelect = commSelect;
  }
  
  public RichSelectOneChoice getCommSelect()
  {
    return this.commSelect;
  }
}
