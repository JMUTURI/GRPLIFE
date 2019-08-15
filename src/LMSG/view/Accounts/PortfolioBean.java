package LMSG.view.Accounts;

import LMSG.view.Base.ADFUtils;
import LMSG.view.Base.GlobalCC;
import LMSG.view.Navigation.Links;
import LMSG.view.connect.DBConnector;
import com.Ostermiller.util.CSVParser;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.List;
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
import oracle.adf.view.rich.component.rich.layout.RichPanelBox;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.uicli.binding.JUCtrlValueBinding;
import org.apache.myfaces.trinidad.event.SelectionEvent;
import org.apache.myfaces.trinidad.model.RowKeySet;

public class PortfolioBean
{
  private RichTable treatyArrangementLOV;
  private RichInputText arrangementId;
  private RichInputText arrangementDescription;
  private RichInputText arrangementType;
  HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
  private RichTable arrangementYearLOV;
  private RichInputText yearTF;
  private RichTable treatiesLOV;
  private RichTable treatyPeriodLOV;
  private RichInputText txtPrtsFiscalYear;
  private RichInputText txtPrtsUwYear;
  private RichInputText txtPrtstrtCode;
  private RichInputText txtPrtsTaCode;
  private RichInputText txtPrtstaCode;
  private RichInputText txtPremPortfolio;
  private RichInputText txtLossPortfolio;
  private RichInputDate dateFrom;
  private RichInputDate dateTo;
  private RichSelectBooleanCheckbox selectParticipant;
  private RichTable treatySummaryLOV;
  private RichTable brhLOV;
  private RichInputText brhDisplay;
  private RichTable receiptsDAO;
  private RichTable riRecoveryDAO;
  private RichSelectBooleanRadio riCeding;
  private RichSelectBooleanRadio riRecovery;
  private RichSelectBooleanRadio coinRecovery;
  private RichPanelBox riPanel;
  private RichTable coinsuranceDAO;
  private RichInputText coinAmtTF;
  private RichInputText reinAmtTF;
  private RichSelectBooleanCheckbox riSelect;
  private RichSelectBooleanCheckbox coinSelect;
  
  public void setTreatyArrangementLOV(RichTable treatyArrangementLOV)
  {
    this.treatyArrangementLOV = treatyArrangementLOV;
  }
  
  public RichTable getTreatyArrangementLOV()
  {
    return this.treatyArrangementLOV;
  }
  
  public void setArrangementId(RichInputText arrangementId)
  {
    this.arrangementId = arrangementId;
  }
  
  public RichInputText getArrangementId()
  {
    return this.arrangementId;
  }
  
  public void setArrangementDescription(RichInputText arrangementDescription)
  {
    this.arrangementDescription = arrangementDescription;
  }
  
  public RichInputText getArrangementDescription()
  {
    return this.arrangementDescription;
  }
  
  public String selectTreatyArrangement()
  {
    Object key2 = this.treatyArrangementLOV.getSelectedRowData();
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
    this.session.setAttribute("ta_code", r.getAttribute("ta_code"));
    this.arrangementId.setValue(r.getAttribute("TA_SHT_DESC"));
    this.arrangementDescription.setValue(r.getAttribute("TA_DESC"));
    this.arrangementType.setValue(r.getAttribute("TA_TYPE"));
    AdfFacesContext.getCurrentInstance().addPartialTarget(this.arrangementId);
    AdfFacesContext.getCurrentInstance().addPartialTarget(this.arrangementDescription);
    AdfFacesContext.getCurrentInstance().addPartialTarget(this.arrangementType);
    ADFUtils.findIterator("findArrangementSetupsIterator").executeQuery();
    AdfFacesContext.getCurrentInstance().addPartialTarget(this.arrangementYearLOV);
    
    return null;
  }
  
  public void setArrangementType(RichInputText arrangementType)
  {
    this.arrangementType = arrangementType;
  }
  
  public RichInputText getArrangementType()
  {
    return this.arrangementType;
  }
  
  public String findSelectedYear()
  {
    Object key2 = this.arrangementYearLOV.getSelectedRowData();
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
    if (this.session.getAttribute("ta_code") == null) {
      GlobalCC.INFORMATIONREPORTING("Please select a treaty arrangement");
    }
    this.session.setAttribute("as_code", r.getAttribute("AS_CODE"));
    this.yearTF.setValue(r.getAttribute("AS_UWYR"));
    this.session.setAttribute("UWYear", r.getAttribute("AS_UWYR"));
    this.session.setAttribute("REI_CODE", null);
    AdfFacesContext.getCurrentInstance().addPartialTarget(this.yearTF);
    ADFUtils.findIterator("findTreatySetupsIterator").executeQuery();
    AdfFacesContext.getCurrentInstance().addPartialTarget(this.treatiesLOV);
    return null;
  }
  
  public void setArrangementYearLOV(RichTable arrangementYearLOV)
  {
    this.arrangementYearLOV = arrangementYearLOV;
  }
  
  public RichTable getArrangementYearLOV()
  {
    return this.arrangementYearLOV;
  }
  
  public void setYearTF(RichInputText yearTF)
  {
    this.yearTF = yearTF;
  }
  
  public RichInputText getYearTF()
  {
    return this.yearTF;
  }
  
  public void setTreatiesLOV(RichTable treatiesLOV)
  {
    this.treatiesLOV = treatiesLOV;
  }
  
  public RichTable getTreatiesLOV()
  {
    return this.treatiesLOV;
  }
  
  public void setTreatyPeriodLOV(RichTable treatyPeriodLOV)
  {
    this.treatyPeriodLOV = treatyPeriodLOV;
  }
  
  public RichTable getTreatyPeriodLOV()
  {
    return this.treatyPeriodLOV;
  }
  
  public void treatySelectionListener(SelectionEvent selectionEvent)
  {
    Object key2 = this.treatiesLOV.getSelectedRowData();
    if (key2 == null) {
      GlobalCC.errorValueNotEntered("No Record Selected");
    }
    JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
    if (r == null) {
      GlobalCC.errorValueNotEntered("No Record Selected");
    }
    this.session.setAttribute("REI_CODE", r.getAttribute("REI_CODE"));
    this.txtPremPortfolio.setValue(r.getAttribute("REI_PREM_PORTFOLIO"));
    AdfFacesContext.getCurrentInstance().addPartialTarget(this.txtPremPortfolio);
    this.txtLossPortfolio.setValue(r.getAttribute("REI_LOSS_PORTFOLIO"));
    AdfFacesContext.getCurrentInstance().addPartialTarget(this.txtLossPortfolio);
    ADFUtils.findIterator("findPeriodTreatySummIterator").executeQuery();
    AdfFacesContext.getCurrentInstance().addPartialTarget(this.treatyPeriodLOV);
    ADFUtils.findIterator("findPeriodTreatySummIterator").executeQuery();
    AdfFacesContext.getCurrentInstance().addPartialTarget(this.treatyPeriodLOV);
    ADFUtils.findIterator("findTreatySummaryIterator").executeQuery();
    AdfFacesContext.getCurrentInstance().addPartialTarget(this.treatySummaryLOV);
  }
  
  public void setSession(HttpSession session)
  {
    this.session = session;
  }
  
  public HttpSession getSession()
  {
    return this.session;
  }
  
  public void setTxtPrtsFiscalYear(RichInputText txtPrtsFiscalYear)
  {
    this.txtPrtsFiscalYear = txtPrtsFiscalYear;
  }
  
  public RichInputText getTxtPrtsFiscalYear()
  {
    return this.txtPrtsFiscalYear;
  }
  
  public void setTxtPrtsUwYear(RichInputText txtPrtsUwYear)
  {
    this.txtPrtsUwYear = txtPrtsUwYear;
  }
  
  public RichInputText getTxtPrtsUwYear()
  {
    return this.txtPrtsUwYear;
  }
  
  public void setTxtPrtstrtCode(RichInputText txtPrtstrtCode)
  {
    this.txtPrtstrtCode = txtPrtstrtCode;
  }
  
  public RichInputText getTxtPrtstrtCode()
  {
    return this.txtPrtstrtCode;
  }
  
  public void setTxtPrtsTaCode(RichInputText txtPrtsTaCode)
  {
    this.txtPrtsTaCode = txtPrtsTaCode;
  }
  
  public RichInputText getTxtPrtsTaCode()
  {
    return this.txtPrtsTaCode;
  }
  
  public void setTxtPrtstaCode(RichInputText txtPrtstaCode)
  {
    this.txtPrtstaCode = txtPrtstaCode;
  }
  
  public RichInputText getTxtPrtstaCode()
  {
    return this.txtPrtstaCode;
  }
  
  public void selectTreatySummaryListener(SelectionEvent selectionEvent)
  {
    if (selectionEvent.getAddedSet() != selectionEvent.getRemovedSet())
    {
      DCIteratorBinding binder = ADFUtils.findIterator("findPeriodTreatySummIterator");
      
      RowKeySet set = selectionEvent.getAddedSet();
      Iterator row = set.iterator();
      while (row.hasNext())
      {
        List data = (List)row.next();
        Key key = (Key)data.get(0);
        binder.setCurrentRowWithKey(key.toStringFormat(true));
        Row rows = binder.getCurrentRow();
        this.txtPrtsFiscalYear.setValue(rows.getAttribute("prtsFiscalYear"));
        this.txtPrtsUwYear.setValue(rows.getAttribute("prtsUwYear"));
        this.txtPrtstrtCode.setValue(rows.getAttribute("prtsTrtCode"));
        this.txtPrtsTaCode.setValue(rows.getAttribute("prtsTaCode"));
        this.txtPrtstaCode.setValue(rows.getAttribute("prtsAsCode"));
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.txtPrtsFiscalYear);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.txtPrtsUwYear);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.txtPrtstrtCode);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.txtPrtsTaCode);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.txtPrtstaCode);
      }
    }
  }
  
  public String processTreatySummaries()
  {
    if ((BigDecimal)this.session.getAttribute("ta_code") == null)
    {
      GlobalCC.INFORMATIONREPORTING("Select Treaty Arrangement to proceed");
      return null;
    }
    DBConnector connection = new DBConnector();
    String query = "begin LMS_GRP_REINSURANCE.process_prd_treaty_summary(?,?,?,?,?,?,?,?);end;";
    
    CallableStatement stmt = null;
    Connection conn = null;
    BigDecimal tacode = null;
    try
    {
      conn = connection.getDatabaseConn();
      stmt = conn.prepareCall(query);
      stmt.setBigDecimal(1, (BigDecimal)this.session.getAttribute("ta_code"));
      stmt.setString(2, (String)this.session.getAttribute("DateFrom"));
      stmt.setString(3, (String)this.session.getAttribute("DateTo"));
      if (this.txtPrtstrtCode.getValue() == null) {
        stmt.setBigDecimal(4, null);
      } else {
        stmt.setBigDecimal(4, new BigDecimal(this.txtPrtstrtCode.getValue().toString()));
      }
      if (this.txtPrtsTaCode.getValue() == null) {
        stmt.setBigDecimal(5, null);
      } else {
        stmt.setBigDecimal(5, new BigDecimal(this.txtPrtsTaCode.getValue().toString()));
      }
      if (this.txtPrtstaCode.getValue() == null) {
        stmt.setBigDecimal(6, null);
      } else {
        stmt.setBigDecimal(6, new BigDecimal(this.txtPrtstaCode.getValue().toString()));
      }
      if (this.txtPremPortfolio.getValue() == null) {
        stmt.setBigDecimal(7, null);
      } else {
        stmt.setBigDecimal(7, new BigDecimal(this.txtPremPortfolio.getValue().toString()));
      }
      if (this.txtLossPortfolio.getValue() == null) {
        stmt.setBigDecimal(8, null);
      } else {
        stmt.setBigDecimal(8, new BigDecimal(this.txtLossPortfolio.getValue().toString()));
      }
      stmt.execute();
      this.txtPrtstrtCode.setValue(null);
      








      GlobalCC.INFORMATIONREPORTING("Treaty Period authorized Successfull");
      ADFUtils.findIterator("findPeriodTreatySummIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.treatyPeriodLOV);
      ADFUtils.findIterator("findTreatySummaryIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.treatySummaryLOV);
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
  }
  
  public void setTxtPremPortfolio(RichInputText txtPremPortfolio)
  {
    this.txtPremPortfolio = txtPremPortfolio;
  }
  
  public RichInputText getTxtPremPortfolio()
  {
    return this.txtPremPortfolio;
  }
  
  public void setTxtLossPortfolio(RichInputText txtLossPortfolio)
  {
    this.txtLossPortfolio = txtLossPortfolio;
  }
  
  public RichInputText getTxtLossPortfolio()
  {
    return this.txtLossPortfolio;
  }
  
  public String searchPortfolioRecords()
  {
    if ((this.dateFrom.getValue() == null) || (this.dateTo.getValue() == null))
    {
      GlobalCC.INFORMATIONREPORTING("Please select date from and date to.");
      return null;
    }
    this.session.setAttribute("DateFrom", GlobalCC.parseDate(this.dateFrom.getValue().toString()));
    
    this.session.setAttribute("DateTo", GlobalCC.parseDate(this.dateTo.getValue().toString()));
    
    this.session.setAttribute("dateFrom", GlobalCC.parseDate(this.dateFrom.getValue().toString()));
    
    this.session.setAttribute("dateTo", GlobalCC.parseDate(this.dateTo.getValue().toString()));
    

    ADFUtils.findIterator("findPeriodTreatySummIterator").executeQuery();
    AdfFacesContext.getCurrentInstance().addPartialTarget(this.treatyPeriodLOV);
    ADFUtils.findIterator("findTreatySummaryIterator").executeQuery();
    AdfFacesContext.getCurrentInstance().addPartialTarget(this.treatySummaryLOV);
    ADFUtils.findIterator("findRecoveryPrdSummIterator").executeQuery();
    AdfFacesContext.getCurrentInstance().addPartialTarget(this.riRecoveryDAO);
    ADFUtils.findIterator("findCoinsurancePrdSummIterator").executeQuery();
    AdfFacesContext.getCurrentInstance().addPartialTarget(this.coinsuranceDAO);
    return null;
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
  
  public void setSelectParticipant(RichSelectBooleanCheckbox selectParticipant)
  {
    this.selectParticipant = selectParticipant;
  }
  
  public RichSelectBooleanCheckbox getSelectParticipant()
  {
    return this.selectParticipant;
  }
  
  public String raiseRIRequisition()
  {
    DBConnector connection = new DBConnector();
    CallableStatement stmt = null;
    Connection conn = null;
    BigDecimal tacode = null;
    int k = 0;
    conn = connection.getDatabaseConn();
    if ((BigDecimal)this.session.getAttribute("ta_code") == null)
    {
      GlobalCC.INFORMATIONREPORTING("Select Treaty Arrangement to Process");
      return null;
    }
    DCIteratorBinding dciter = ADFUtils.findIterator("findTreatySummaryIterator");
    
    RowKeySet set = this.treatySummaryLOV.getSelectedRowKeys();
    
    Iterator rowKeySetIter = set.iterator();
    try
    {
      String query = "begin LMS_GRP_REINSURANCE.processripayment(?,?,?,?,?);end;";
      while (k < this.treatySummaryLOV.getRowCount())
      {
        JUCtrlValueBinding r = (JUCtrlValueBinding)this.treatySummaryLOV.getRowData(k);
        if (r == null)
        {
          GlobalCC.errorValueNotEntered("No Record Selected");
          conn.close();
          return null;
        }
        if ((!r.getAttribute("status").equals("Paid")) && (r.getAttribute("TS_DRCR").equals("Cr")))
        {
          stmt = conn.prepareCall(query);
          stmt.setBigDecimal(1, (BigDecimal)this.session.getAttribute("ta_code"));
          
          stmt.setString(2, (String)this.session.getAttribute("DateFrom"));
          
          stmt.setString(3, (String)this.session.getAttribute("DateTo"));
          stmt.setBigDecimal(4, (BigDecimal)this.session.getAttribute("brnCode"));
          
          stmt.setBigDecimal(5, (BigDecimal)r.getAttribute("TS_CODE"));
          
          stmt.execute();
        }
        k++;
      }
      conn.close();
      ADFUtils.findIterator("findPeriodTreatySummIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.treatyPeriodLOV);
      ADFUtils.findIterator("findTreatySummaryIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.treatySummaryLOV);
      GlobalCC.INFORMATIONREPORTING("Requisition raised successfully");
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
      e.printStackTrace();
    }
    return null;
  }
  
  public void setTreatySummaryLOV(RichTable treatySummaryLOV)
  {
    this.treatySummaryLOV = treatySummaryLOV;
  }
  
  public RichTable getTreatySummaryLOV()
  {
    return this.treatySummaryLOV;
  }
  
  public String AssignBranches()
  {
    DCIteratorBinding dciter = ADFUtils.findIterator("FindBranchesIterator");
    
    RowKeySet set = this.brhLOV.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();
    while (rowKeySetIter.hasNext())
    {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();
      this.brhDisplay.setValue(r.getAttribute("BRN_NAME"));
      this.session.setAttribute("brnCode", r.getAttribute("BRN_CODE"));
      this.session.setAttribute("branchCode", r.getAttribute("BRN_CODE"));
      
      this.session.setAttribute("brnName", r.getAttribute("BRN_NAME"));
    }
    return null;
  }
  
  public void setBrhLOV(RichTable brhLOV)
  {
    this.brhLOV = brhLOV;
  }
  
  public RichTable getBrhLOV()
  {
    return this.brhLOV;
  }
  
  public void setBrhDisplay(RichInputText brhDisplay)
  {
    this.brhDisplay = brhDisplay;
  }
  
  public RichInputText getBrhDisplay()
  {
    return this.brhDisplay;
  }
  
  public String showReceiptPop()
  {
    Object key2 = this.treatySummaryLOV.getSelectedRowData();
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
    this.session.setAttribute("tsCode", r.getAttribute("TS_CODE"));
    ADFUtils.findIterator("findRIReceiptsIterator").executeQuery();
    AdfFacesContext.getCurrentInstance().addPartialTarget(this.receiptsDAO);
    GlobalCC.showPopup("lmsgroup:riReceipts");
    return null;
  }
  
  public String exitPopup()
  {
    this.session.setAttribute("tsCode", null);
    GlobalCC.hidePopup("lmsgroup:riReceipts");
    return null;
  }
  
  public void setReceiptsDAO(RichTable receiptsDAO)
  {
    this.receiptsDAO = receiptsDAO;
  }
  
  public RichTable getReceiptsDAO()
  {
    return this.receiptsDAO;
  }
  
  public void markCheckBox(SelectionEvent selectionEvent)
  {
    this.selectParticipant.setSelected(true);
    AdfFacesContext.getCurrentInstance().addPartialTarget(this.selectParticipant);
  }
  
  public void setRiRecoveryDAO(RichTable riRecoveryDAO)
  {
    this.riRecoveryDAO = riRecoveryDAO;
  }
  
  public RichTable getRiRecoveryDAO()
  {
    return this.riRecoveryDAO;
  }
  
  public void setRiCeding(RichSelectBooleanRadio riCeding)
  {
    this.riCeding = riCeding;
  }
  
  public RichSelectBooleanRadio getRiCeding()
  {
    return this.riCeding;
  }
  
  public void setRiRecovery(RichSelectBooleanRadio riRecovery)
  {
    this.riRecovery = riRecovery;
  }
  
  public RichSelectBooleanRadio getRiRecovery()
  {
    return this.riRecovery;
  }
  
  public void setCoinRecovery(RichSelectBooleanRadio coinRecovery)
  {
    this.coinRecovery = coinRecovery;
  }
  
  public RichSelectBooleanRadio getCoinRecovery()
  {
    return this.coinRecovery;
  }
  
  public String RedirectPolicyTrans()
  {
    try
    {
      Links MyLink = new Links();
      String RecoveryType = null;
      if (this.riCeding.isSelected())
      {
        RecoveryType = "riCeding";
      }
      else if (this.riRecovery.isSelected())
      {
        RecoveryType = "riRecovery";
      }
      else if (this.coinRecovery.isSelected())
      {
        RecoveryType = "coinRecovery";
      }
      else
      {
        GlobalCC.INFORMATIONREPORTING("Select A Transaction");
        return null;
      }
      this.session.setAttribute("recTrans", RecoveryType);
      GlobalCC.RedirectPage("/portfolioTrans.jspx");
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(null, e);
      e.printStackTrace();
    }
    return null;
  }
  
  public void setRiPanel(RichPanelBox riPanel)
  {
    this.riPanel = riPanel;
  }
  
  public RichPanelBox getRiPanel()
  {
    return this.riPanel;
  }
  
  public void setCoinsuranceDAO(RichTable coinsuranceDAO)
  {
    this.coinsuranceDAO = coinsuranceDAO;
  }
  
  public RichTable getCoinsuranceDAO()
  {
    return this.coinsuranceDAO;
  }
  
  public String processCoinRecovery()
  {
    Object keyCoin = this.coinsuranceDAO.getSelectedRowData();
    JUCtrlValueBinding rCoin = null;
    DBConnector connection = new DBConnector();
    String voucherNo = voucherNo();
    String query = "begin LMS_GRP_REINSURANCE.updatecoinsuranceprocessing(?,?);end;";
    
    int k = 0;
    if (this.coinsuranceDAO.getRowCount() <= 0)
    {
      GlobalCC.errorValueNotEntered("No record selected");
      return null;
    }
    while (k < this.coinsuranceDAO.getRowCount())
    {
      rCoin = (JUCtrlValueBinding)this.coinsuranceDAO.getRowData(k);
      if (((Boolean)rCoin.getAttribute("coinSelect")).equals(Boolean.valueOf(true)))
      {
        CallableStatement stmt = null;
        Connection conn = null;
        try
        {
          conn = connection.getDatabaseConn();
          stmt = conn.prepareCall(query);
          stmt.setBigDecimal(1, (BigDecimal)rCoin.getAttribute("ccrCode"));
          
          stmt.setString(2, voucherNo);
          stmt.execute();
        }
        catch (Exception e)
        {
          GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        finally
        {
          GlobalCC.CloseConnections(null, stmt, conn);
        }
      }
      k++;
    }
    generateCoinsuranceDebit(voucherNo);
    GlobalCC.INFORMATIONREPORTING("Coinsnurance debit generated");
    ADFUtils.findIterator("findCoinsurancePrdSummIterator").executeQuery();
    AdfFacesContext.getCurrentInstance().addPartialTarget(this.coinsuranceDAO);
    ADFUtils.findIterator("findTreatySummaryIterator").executeQuery();
    AdfFacesContext.getCurrentInstance().addPartialTarget(this.treatySummaryLOV);
    return null;
  }
  
  public void setCoinAmtTF(RichInputText coinAmtTF)
  {
    this.coinAmtTF = coinAmtTF;
  }
  
  public RichInputText getCoinAmtTF()
  {
    return this.coinAmtTF;
  }
  
  public void setReinAmtTF(RichInputText reinAmtTF)
  {
    this.reinAmtTF = reinAmtTF;
  }
  
  public RichInputText getReinAmtTF()
  {
    return this.reinAmtTF;
  }
  
  public void coinAmtSelection(ValueChangeEvent valueChangeEvent)
  {
    if (valueChangeEvent.getOldValue() != valueChangeEvent.getNewValue())
    {
      Object key2 = this.coinsuranceDAO.getSelectedRowData();
      BigDecimal ccrCode = null;
      if (key2 == null) {
        GlobalCC.errorValueNotEntered("No Record Selected");
      }
      JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
      if (r == null) {
        GlobalCC.errorValueNotEntered("No Record Selected");
      }
      ccrCode = (BigDecimal)r.getAttribute("ccrCode");
      

      DBConnector connection = new DBConnector();
      String query = "begin LMS_GRP_REINSURANCE.updateCoinsuranceRecovery(?,?);end;";
      
      CallableStatement stmt = null;
      Connection conn = null;
      try
      {
        conn = connection.getDatabaseConn();
        stmt = conn.prepareCall(query);
        stmt.setBigDecimal(1, ccrCode);
        stmt.setBigDecimal(2, (BigDecimal)this.coinAmtTF.getValue());
        stmt.execute();
        ADFUtils.findIterator("findCoinsurancePrdSummIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.coinsuranceDAO);
        ADFUtils.findIterator("findTreatySummaryIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.treatySummaryLOV);
      }
      catch (Exception e)
      {
        GlobalCC.EXCEPTIONREPORTING(conn, e);
      }
    }
  }
  
  public void setRiSelect(RichSelectBooleanCheckbox riSelect)
  {
    this.riSelect = riSelect;
  }
  
  public RichSelectBooleanCheckbox getRiSelect()
  {
    return this.riSelect;
  }
  
  public void setCoinSelect(RichSelectBooleanCheckbox coinSelect)
  {
    this.coinSelect = coinSelect;
  }
  
  public RichSelectBooleanCheckbox getCoinSelect()
  {
    return this.coinSelect;
  }
  
  public String voucherNo()
  {
    String voucherNo = null;
    DBConnector connection = new DBConnector();
    String query = "select lms_api.trans_voucher ('COIN') from dual";
    CallableStatement stmt = null;
    Connection conn = null;
    ResultSet rs = null;
    try
    {
      conn = connection.getDatabaseConn();
      stmt = conn.prepareCall(query);
      rs = stmt.executeQuery();
      while (rs.next()) {
        voucherNo = rs.getString(1);
      }
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
      e.printStackTrace();
    }
    finally
    {
      GlobalCC.CloseConnections(rs, stmt, conn);
    }
    return voucherNo;
  }
  
  public void generateCoinsuranceDebit(String voucherNo)
  {
    DBConnector connection = new DBConnector();
    String query = "begin LMS_GRP_REINSURANCE.process_prd_coin_summary(?,?,?);end;";
    CallableStatement stmt = null;
    Connection conn = null;
    try
    {
      conn = connection.getDatabaseConn();
      stmt = conn.prepareCall(query);
      stmt.setString(1, (String)this.session.getAttribute("DateFrom"));
      stmt.setString(2, (String)this.session.getAttribute("DateTo"));
      stmt.setString(3, voucherNo);
      stmt.execute();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
      e.printStackTrace();
    }
    finally
    {
      GlobalCC.CloseConnections(null, stmt, conn);
    }
  }
  
  public String processReinRecovery()
  {
    Object keyCoin = this.riRecoveryDAO.getSelectedRowData();
    JUCtrlValueBinding rCoin = null;
    DBConnector connection = new DBConnector();
    String voucherNo = riVoucherNo();
    String query = "begin LMS_GRP_REINSURANCE.updateReinsuranceprocessing(?,?,?,?,?);end;";
    
    int k = 0;
    if (this.riRecoveryDAO.getRowCount() <= 0)
    {
      GlobalCC.errorValueNotEntered("No record selected");
      return null;
    }
    while (k < this.riRecoveryDAO.getRowCount())
    {
      rCoin = (JUCtrlValueBinding)this.riRecoveryDAO.getRowData(k);
      if (((Boolean)rCoin.getAttribute("riSelect")).equals(Boolean.valueOf(true)))
      {
        CallableStatement stmt = null;
        Connection conn = null;
        try
        {
          conn = connection.getDatabaseConn();
          stmt = conn.prepareCall(query);
          stmt.setString(1, (String)rCoin.getAttribute("refNo"));
          
          stmt.setString(2, voucherNo);
          stmt.setString(3, (String)rCoin.getAttribute("coverDesc"));
          stmt.setString(4, (String)this.session.getAttribute("DateFrom"));
          stmt.setString(5, (String)this.session.getAttribute("DateTo"));
          stmt.execute();
        }
        catch (Exception e)
        {
          GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        finally
        {
          GlobalCC.CloseConnections(null, stmt, conn);
        }
      }
      k++;
    }
    generateReinsuranceDebit(voucherNo);
    GlobalCC.INFORMATIONREPORTING("Treaty Period authorized Successfull");
    ADFUtils.findIterator("findRecoveryPrdSummIterator").executeQuery();
    AdfFacesContext.getCurrentInstance().addPartialTarget(this.treatyPeriodLOV);
    ADFUtils.findIterator("findTreatySummaryIterator").executeQuery();
    AdfFacesContext.getCurrentInstance().addPartialTarget(this.treatySummaryLOV);
    return null;
  }
  
  public String riVoucherNo()
  {
    String voucherNo = null;
    DBConnector connection = new DBConnector();
    String query = "select lms_api.trans_voucher ('REIN') from dual";
    CallableStatement stmt = null;
    Connection conn = null;
    ResultSet rs = null;
    try
    {
      conn = connection.getDatabaseConn();
      stmt = conn.prepareCall(query);
      rs = stmt.executeQuery();
      while (rs.next()) {
        voucherNo = rs.getString(1);
      }
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
      e.printStackTrace();
    }
    finally
    {
      GlobalCC.CloseConnections(rs, stmt, conn);
    }
    return voucherNo;
  }
  
  public void generateReinsuranceDebit(String voucherNo)
  {
    DBConnector connection = new DBConnector();
    String query = "begin LMS_GRP_REINSURANCE.process_prd_reco_summary(?,?,?,?);end;";
    CallableStatement stmt = null;
    Connection conn = null;
    try
    {
      conn = connection.getDatabaseConn();
      stmt = conn.prepareCall(query);
      stmt.setBigDecimal(1, (BigDecimal)this.session.getAttribute("ta_code"));
      stmt.setString(2, (String)this.session.getAttribute("DateFrom"));
      stmt.setString(3, (String)this.session.getAttribute("DateTo"));
      stmt.setString(4, voucherNo);
      stmt.execute();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
      e.printStackTrace();
    }
    finally
    {
      GlobalCC.CloseConnections(null, stmt, conn);
    }
  }
  
  public void voucherSelection(SelectionEvent selectionEvent)
  {
    if (selectionEvent.getAddedSet() != selectionEvent.getRemovedSet())
    {
      Object key2 = this.treatySummaryLOV.getSelectedRowData();
      BigDecimal ccrCode = null;
      if (key2 == null) {
        GlobalCC.errorValueNotEntered("No Record Selected");
      }
      JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
      if (r == null) {
        GlobalCC.errorValueNotEntered("No Record Selected");
      }
      this.session.setAttribute("voucherNo", r.getAttribute("TS_VOUCHER_NO"));
    }
  }
  
  public void importExcelData(InputStream csvFile)
  {
    String[][] csvvalues = (String[][])null;
    try
    {
      csvvalues = CSVParser.parse(new InputStreamReader(csvFile));
      
      System.out.println("Array length is " + csvvalues.length);
      for (int i = 1; i < csvvalues.length; i++)
      {
        String Result = GlobalCC.parseDateAuthFormat(csvvalues[i][3]);
        if (Result.equalsIgnoreCase("Invalid Date Format"))
        {
          GlobalCC.errorValueNotEntered("Invalid Date Format " + csvvalues[i][3] + ". The Valid Date Format is DD-MMM-YYYY");
          
          return;
        }
        BigDecimal amtAllocate = new BigDecimal(csvvalues[i][2]);
        allocateValues((String)this.session.getAttribute("recTrans"), csvvalues[i][0], csvvalues[i][1], amtAllocate, csvvalues[i][3]);
      }
      ADFUtils.findIterator("findTreatySummaryIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.treatySummaryLOV);
      GlobalCC.INFORMATIONREPORTING("Allocation successfully done");
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
  }
  
  public void allocateValues(String type, String debitNote, String claimNo, BigDecimal amountAllocated, String dateReceived)
  {
    DBConnector connection = new DBConnector();
    String query = "begin LMS_GRP_REINSURANCE.updateclaimrecoveryalloc(?,?,?,?,?);end;";
    CallableStatement stmt = null;
    Connection conn = null;
    try
    {
      conn = connection.getDatabaseConn();
      stmt = conn.prepareCall(query);
      stmt.setString(1, type);
      stmt.setString(2, debitNote);
      stmt.setString(3, claimNo);
      stmt.setBigDecimal(4, amountAllocated);
      stmt.setString(5, dateReceived);
      stmt.execute();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
      e.printStackTrace();
    }
    finally
    {
      GlobalCC.CloseConnections(null, stmt, conn);
    }
  }
  
  public void reinAmtSelection(ValueChangeEvent valueChangeEvent)
  {
    if (valueChangeEvent.getOldValue() != valueChangeEvent.getNewValue())
    {
      Object key2 = this.riRecoveryDAO.getSelectedRowData();
      String claimNo = null;
      String coverDesc = null;
      if (key2 == null) {
        GlobalCC.errorValueNotEntered("No Record Selected");
      }
      JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
      if (r == null) {
        GlobalCC.errorValueNotEntered("No Record Selected");
      }
      claimNo = (String)r.getAttribute("refNo");
      coverDesc = (String)r.getAttribute("coverDesc");
      
      DBConnector connection = new DBConnector();
      String query = "begin LMS_GRP_REINSURANCE.updatereinsurancerecovery(?,?,?,?,?);end;";
      
      CallableStatement stmt = null;
      Connection conn = null;
      try
      {
        conn = connection.getDatabaseConn();
        stmt = conn.prepareCall(query);
        stmt.setString(1, claimNo);
        stmt.setBigDecimal(2, (BigDecimal)this.reinAmtTF.getValue());
        stmt.setString(3, coverDesc);
        stmt.setString(4, (String)this.session.getAttribute("DateFrom"));
        stmt.setString(5, (String)this.session.getAttribute("DateTo"));
        stmt.execute();
        ADFUtils.findIterator("findRecoveryPrdSummIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.riRecoveryDAO);
        ADFUtils.findIterator("findTreatySummaryIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.treatySummaryLOV);
      }
      catch (Exception e)
      {
        GlobalCC.EXCEPTIONREPORTING(conn, e);
      }
    }
  }
}
