package LMSG.view.Accounts;

import LMSG.view.Base.GlobalCC;
import LMSG.view.Base.LOVCC;
import LMSG.view.connect.DBConnector;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class AccountDAO
  extends LOVCC
{
  HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
  
  public List<Account> findCreditTrans()
  {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    ResultSet rst = null;
    
    List<Account> PolicyList = new ArrayList();
    try
    {
      String polQuery = "begin LMS_WEB_CURSOR_GRP.find_credit_trans(?,?,?);end;";
      
      cst = conn.prepareCall(polQuery);
      cst.registerOutParameter(1, -10);
      cst.setBigDecimal(2, (BigDecimal)this.session.getAttribute("policyCode"));
      
      cst.setBigDecimal(3, (BigDecimal)this.session.getAttribute("agent_code"));
      

      cst.execute();
      rst = (ResultSet)cst.getObject(1);
      while (rst.next())
      {
        Account myProd = new Account();
        
        myProd.setMTRAN_REF_NO(rst.getString(1));
        myProd.setMTRAN_DATE(rst.getDate(2));
        myProd.setMTRAN_DC(rst.getString(3));
        myProd.setMTRAN_AMOUNT(rst.getString(4));
        myProd.setMTRAN_COMMISSION(rst.getString(5));
        myProd.setMTRAN_COMM_PAID(rst.getString(6));
        myProd.setMTRAN_COMM_PAYABLE(rst.getString(7));
        myProd.setMTRAN_BALANCE(rst.getString(8));
        myProd.setMTRAN_CODE(rst.getBigDecimal(9));
        myProd.setAmount(rst.getString(10));
        myProd.setMTRAN_TRAN_TYPE(rst.getString(11));
        myProd.setMTRAN_POL_POLCY_NO(rst.getString(15));
        
        PolicyList.add(myProd);
      }
      rst.close();
      cst.close();
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
      e.printStackTrace();
    }
    finally
    {
      GlobalCC.CloseConnections(rst, cst, conn);
    }
    return PolicyList;
  }
  
  public List<Account> findReceiptedPolicies()
  {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    ResultSet rst = null;
    
    List<Account> PolicyList = new ArrayList();
    try
    {
      String polQuery = "begin LMS_WEB_CURSOR_GRP.find_receipted_policies(?,?,?,?,?);end;";
      
      cst = conn.prepareCall(polQuery);
      cst.registerOutParameter(1, -10);
      cst.setBigDecimal(2, (BigDecimal)this.session.getAttribute("policyCode"));
      
      cst.setString(3, (String)this.session.getAttribute("RenDateFrom"));
      cst.setString(4, (String)this.session.getAttribute("RenDateTo"));
      cst.setBigDecimal(5, (BigDecimal)this.session.getAttribute("agnCode"));
      cst.execute();
      rst = (ResultSet)cst.getObject(1);
      while (rst.next())
      {
        Account myProd = new Account();
        

        myProd.setPol_code(rst.getBigDecimal(1));
        myProd.setPol_policy_no(rst.getString(2));
        myProd.setInst_no(rst.getString(3));
        myProd.setOpr_receipt_date(rst.getDate(4));
        myProd.setInst_amt(rst.getBigDecimal(5));
        myProd.setComm_rate(rst.getBigDecimal(6));
        myProd.setComm_amt(rst.getBigDecimal(7));
        myProd.setWhdtax_rate(rst.getBigDecimal(8));
        myProd.setWhdtax_amt(rst.getBigDecimal(9));
        myProd.setTot_comm_display(rst.getBigDecimal(10));
        myProd.setDrcr(rst.getString(11));
        myProd.setOpr_receipt_no(rst.getString(12));
        myProd.setGrct_code(rst.getBigDecimal(13));
        myProd.setPcp_code(rst.getBigDecimal(14));
        myProd.setAGN_NAME(rst.getString(15));
        String booleanSelect = (String)this.session.getAttribute("booleanSelect");
        if (booleanSelect == null) {
          myProd.setSelected(false);
        } else if (booleanSelect.equalsIgnoreCase("T")) {
          myProd.setSelected(true);
        } else {
          myProd.setSelected(false);
        }
        myProd.setCCL_CODE(rst.getBigDecimal(16));
        

        PolicyList.add(myProd);
      }
      rst.close();
      cst.close();
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
      e.printStackTrace();
    }
    finally
    {
      GlobalCC.CloseConnections(rst, cst, conn);
    }
    return PolicyList;
  }
  
  public List<Account> findCommissionPayments()
  {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    ResultSet rst = null;
    
    List<Account> PolicyList = new ArrayList();
    try
    {
      String polQuery = "begin LMS_WEB_CURSOR_GRP.find_comm_payments(?,?,?,?,?);end;";
      
      cst = conn.prepareCall(polQuery);
      cst.registerOutParameter(1, -10);
      
      cst.setBigDecimal(2, null);
      cst.setString(3, (String)this.session.getAttribute("RenDateFrom"));
      cst.setString(4, (String)this.session.getAttribute("RenDateTo"));
      cst.setBigDecimal(5, (BigDecimal)this.session.getAttribute("agnCode"));
      
      cst.execute();
      rst = (ResultSet)cst.getObject(1);
      while (rst.next())
      {
        Account myProd = new Account();
        

        myProd.setCOP_CODE(rst.getBigDecimal(1));
        myProd.setAGN_NAME(rst.getString(2));
        myProd.setCOP_AGN_UNIT_MGR(rst.getString(3));
        myProd.setBRN_NAME(rst.getString(4));
        myProd.setCOP_COMM_AMT(rst.getBigDecimal(5));
        myProd.setCOP_WHDTAX_AMT(rst.getBigDecimal(6));
        myProd.setCOP_OVRIDE_COMM_AMT(rst.getBigDecimal(7));
        myProd.setCOP_OVRIDE_WHDTAX_AMT(rst.getBigDecimal(8));
        myProd.setCOP_ADVANCE_PYMT(rst.getBigDecimal(9));
        myProd.setCOP_DEDUCTIONS(rst.getBigDecimal(10));
        myProd.setCOP_BONUS_AMT(rst.getBigDecimal(11));
        myProd.setCOP_BONUS_WHDTAX_AMT(rst.getBigDecimal(12));
        myProd.setTOTAL_AMT_DISPLAY(rst.getBigDecimal(13));
        myProd.setCOP_DRCR(rst.getString(14));
        String booleanSelect = (String)this.session.getAttribute("booleanSelect");
        if (booleanSelect == null) {
          myProd.setSelected(false);
        } else if (booleanSelect.equalsIgnoreCase("T")) {
          myProd.setSelected(true);
        } else {
          myProd.setSelected(false);
        }
        PolicyList.add(myProd);
      }
      rst.close();
      cst.close();
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    finally
    {
      GlobalCC.CloseConnections(rst, cst, conn);
    }
    return PolicyList;
  }
  
  public List<Account> findCreditToAlloc()
  {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    ResultSet rst = null;
    
    List<Account> PolicyList = new ArrayList();
    try
    {
      String polQuery = "begin LMS_WEB_CURSOR_GRP.find_credits_to_alloc(?,?,?);end;";
      
      cst = conn.prepareCall(polQuery);
      cst.registerOutParameter(1, -10);
      cst.setBigDecimal(2, (BigDecimal)this.session.getAttribute("policyCode"));
      
      cst.setBigDecimal(3, (BigDecimal)this.session.getAttribute("agent_code"));
      

      cst.execute();
      rst = (ResultSet)cst.getObject(1);
      int i = 0;
      while (rst.next())
      {
        Account myProd = new Account();
        
        myProd.setCRA_MTRAN_REF_NO(rst.getString(1));
        myProd.setCRA_MTRAN_DATE(rst.getDate(2));
        myProd.setCRA_MTRAN_DC(rst.getString(3));
        myProd.setCRA_MTRAN_AMOUNT(rst.getString(4));
        myProd.setCRA_MTRAN_COMMISSION(rst.getString(5));
        myProd.setCRA_MTRAN_COMM_PAID(rst.getString(6));
        myProd.setCRA_MTRAN_COMM_PAYABLE(rst.getString(7));
        myProd.setCRA_MTRAN_BALANCE(rst.getString(8));
        myProd.setCRA_MTRAN_CODE(rst.getBigDecimal(9));
        if (i == 0) {
          this.session.setAttribute("CRAMTRANCODE", rst.getBigDecimal(9));
        }
        i++;
        myProd.setCRA_amount(rst.getString(10));
        myProd.setCRA_MTRAN_TRAN_TYPE(rst.getString(11));
        myProd.setCRA_MTRAN_ALLOC_MODE(rst.getString(12));
        if (rst.getString(12) == null) {
          myProd.setCRA_MTRAN_ALLOC_MODE_DESC("Manual");
        } else if (rst.getString(12).equalsIgnoreCase("C")) {
          myProd.setCRA_MTRAN_ALLOC_MODE_DESC("Automatic");
        } else {
          myProd.setCRA_MTRAN_ALLOC_MODE_DESC("Manual");
        }
        PolicyList.add(myProd);
      }
      rst.close();
      cst.close();
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
      e.printStackTrace();
    }
    finally
    {
      GlobalCC.CloseConnections(rst, cst, conn);
    }
    return PolicyList;
  }
  
  public List<Account> findCreditReceipts()
  {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    ResultSet rst = null;
    
    List<Account> PolicyList = new ArrayList();
    try
    {
      String polQuery = "begin LMS_WEB_CURSOR_GRP.find_credits_receipts(?,?);end;";
      
      cst = conn.prepareCall(polQuery);
      cst.registerOutParameter(1, -10);
      cst.setBigDecimal(2, (BigDecimal)this.session.getAttribute("policyCode"));
      

      cst.execute();
      rst = (ResultSet)cst.getObject(1);
      int i = 0;
      while (rst.next())
      {
        Account myProd = new Account();
        
        myProd.setCRA_MTRAN_REF_NO(rst.getString(1));
        myProd.setCRA_MTRAN_DATE(rst.getDate(2));
        myProd.setCRA_MTRAN_DC(rst.getString(3));
        myProd.setCRA_MTRAN_AMOUNT(rst.getString(4));
        myProd.setCRA_MTRAN_COMMISSION(rst.getString(5));
        myProd.setCRA_MTRAN_COMM_PAID(rst.getString(6));
        myProd.setCRA_MTRAN_COMM_PAYABLE(rst.getString(7));
        myProd.setCRA_MTRAN_BALANCE(rst.getString(8));
        myProd.setCRA_MTRAN_CODE(rst.getBigDecimal(9));
        myProd.setCRA_amount(rst.getString(10));
        myProd.setCRA_MTRAN_TRAN_TYPE(rst.getString(11));
        myProd.setCRA_MTRAN_ALLOC_MODE(rst.getString(12));
        if (rst.getString(12) == null) {
          myProd.setCRA_MTRAN_ALLOC_MODE_DESC("Manual");
        } else if (rst.getString(12).equalsIgnoreCase("C")) {
          myProd.setCRA_MTRAN_ALLOC_MODE_DESC("Automatic");
        } else {
          myProd.setCRA_MTRAN_ALLOC_MODE_DESC("Manual");
        }
        myProd.setMtran_rcpt_reserve_amt(rst.getBigDecimal(13));
        myProd.setMtran_lms_receipt_pk(rst.getBigDecimal(14));
        
        PolicyList.add(myProd);
      }
      rst.close();
      cst.close();
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    finally
    {
      GlobalCC.CloseConnections(rst, cst, conn);
    }
    return PolicyList;
  }
  
  public List<Account> findDebitTransactions()
  {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    ResultSet rst = null;
    
    List<Account> PolicyList = new ArrayList();
    try
    {
      String polQuery = "begin LMS_WEB_CURSOR_GRP.find_debit_transactions(?,?,?);end;";
      
      cst = conn.prepareCall(polQuery);
      cst.registerOutParameter(1, -10);
      cst.setBigDecimal(2, (BigDecimal)this.session.getAttribute("policyCode"));
      
      cst.setBigDecimal(3, (BigDecimal)this.session.getAttribute("agent_code"));
      

      cst.execute();
      rst = (ResultSet)cst.getObject(1);
      while (rst.next())
      {
        Account myProd = new Account();
        

        myProd.setDBT_MTRAN_REF_NO(rst.getString(1));
        myProd.setDBT_MTRAN_DATE(rst.getDate(2));
        myProd.setDBT_MTRAN_DC(rst.getString(3));
        myProd.setDBT_GROSS_AMOUNT(rst.getString(4));
        myProd.setDBT_NET_AMOUNT(rst.getString(5));
        myProd.setDBT_MTRAN_SETTLED_AMT(rst.getString(6));
        myProd.setDBT_MTRAN_BALANCE(rst.getString(7));
        myProd.setDBT_MTRAN_COMMISSION(rst.getString(8));
        myProd.setDBT_MTRAN_COMM_PAID(rst.getString(9));
        myProd.setDBT_MTRAN_COMM_PAYABLE(rst.getString(10));
        myProd.setDBT_MTRAN_CODE(rst.getBigDecimal(11));
        myProd.setDBT_amount(rst.getString(12));
        myProd.setDBT_MTRAN_TRAN_TYPE(rst.getString(13));
        myProd.setMTRAN_POL_POLCY_NO(rst.getString(14));
        
        PolicyList.add(myProd);
      }
      rst.close();
      cst.close();
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
      e.printStackTrace();
    }
    finally
    {
      GlobalCC.CloseConnections(rst, cst, conn);
    }
    return PolicyList;
  }
  
  public List<Account> findDebitToAlloc()
  {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    ResultSet rst = null;
    
    List<Account> PolicyList = new ArrayList();
    try
    {
      String polQuery = "begin LMS_WEB_CURSOR_GRP.find_debit_allocations(?,?,?);end;";
      
      cst = conn.prepareCall(polQuery);
      cst.registerOutParameter(1, -10);
      cst.setBigDecimal(2, (BigDecimal)this.session.getAttribute("policyCode"));
      
      cst.setBigDecimal(3, (BigDecimal)this.session.getAttribute("agent_code"));
      

      cst.execute();
      rst = (ResultSet)cst.getObject(1);
      while (rst.next())
      {
        Account myProd = new Account();
        

        myProd.setDBA_MTRAN_REF_NO(rst.getString(1));
        myProd.setDBA_MTRAN_DATE(rst.getDate(2));
        myProd.setDBA_MTRAN_DC(rst.getString(3));
        myProd.setDBA_GROSS_AMOUNT(rst.getString(4));
        myProd.setDBA_NET_AMOUNT(rst.getString(5));
        myProd.setDBA_MTRAN_SETTLED_AMT(rst.getString(6));
        myProd.setDBA_MTRAN_BALANCE(rst.getString(7));
        myProd.setDBA_MTRAN_COMMISSION(rst.getString(8));
        myProd.setDBA_MTRAN_COMM_PAID(rst.getString(9));
        myProd.setDBA_MTRAN_COMM_PAYABLE(rst.getString(10));
        myProd.setDBA_MTRAN_CODE(rst.getBigDecimal(11));
        myProd.setDBA_amount(rst.getString(12));
        myProd.setDBA_MTRAN_TRAN_TYPE(rst.getString(13));
        myProd.setMTRAN_POL_POLCY_NO(rst.getString(14));
        myProd.setSelected(false);
        
        PolicyList.add(myProd);
      }
      rst.close();
      cst.close();
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
      e.printStackTrace();
    }
    finally
    {
      GlobalCC.CloseConnections(rst, cst, conn);
    }
    return PolicyList;
  }
  
  public List<Account> findTransactionsSettled()
  {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    ResultSet rst = null;
    
    List<Account> PolicyList = new ArrayList();
    try
    {
      String polQuery = "begin LMS_WEB_CURSOR_GRP.find_settled_trans(?,?);end;";
      
      cst = conn.prepareCall(polQuery);
      cst.registerOutParameter(1, -10);
      cst.setBigDecimal(2, (BigDecimal)this.session.getAttribute("CRAMTRANCODE"));
      

      cst.execute();
      rst = (ResultSet)cst.getObject(1);
      while (rst.next())
      {
        Account myProd = new Account();
        
        myProd.setTMAP_DR_MTRAN_REF_NO(rst.getString(1));
        myProd.setTmap_code(rst.getBigDecimal(2));
        myProd.setTMAP_AMOUNT(rst.getString(3));
        myProd.setTMAP_DR_MTRAN_CODE(rst.getBigDecimal(4));
        

        PolicyList.add(myProd);
      }
      rst.close();
      cst.close();
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
      e.printStackTrace();
    }
    finally
    {
      GlobalCC.CloseConnections(rst, cst, conn);
    }
    return PolicyList;
  }
  
  public List<Account> findPolicyCommission()
  {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    ResultSet rst = null;
    
    List<Account> PolicyList = new ArrayList();
    try
    {
      String polQuery = "begin LMS_WEB_CURSOR_GRP.find_policy_comm(?,?,?);end;";
      
      cst = conn.prepareCall(polQuery);
      cst.registerOutParameter(1, -10);
      cst.setBigDecimal(2, (BigDecimal)this.session.getAttribute("policyCode"));
      
      cst.setBigDecimal(3, (BigDecimal)this.session.getAttribute("agent_code"));
      

      cst.execute();
      rst = (ResultSet)cst.getObject(1);
      while (rst.next())
      {
        Account myProd = new Account();
        

        myProd.setPCP_CODE(rst.getBigDecimal(1));
        myProd.setAGENT_DISPLAY(rst.getString(2));
        myProd.setPCP_AGN_UNIT_MGR(rst.getString(3));
        myProd.setBRANCH_DISPLAY(rst.getString(4));
        myProd.setPCP_COMM_AMT(rst.getString(5));
        myProd.setPCP_WHDTAX_AMT(rst.getString(6));
        myProd.setPCP_OVRIDE_COMM_AMT(rst.getString(7));
        myProd.setPCP_OVRIDE_WHDTAX_AMT(rst.getString(8));
        myProd.setPCP_NET_COMM(rst.getString(9));
        myProd.setPCP_PAID(rst.getString(10));
        myProd.setPCP_POL_POLICY_NO(rst.getString(11));
        

        PolicyList.add(myProd);
      }
      rst.close();
      cst.close();
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
      e.printStackTrace();
    }
    finally
    {
      GlobalCC.CloseConnections(rst, cst, conn);
    }
    return PolicyList;
  }
  
  public List<Account> findCoinAllocRefunds()
  {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    ResultSet rst = null;
    
    List<Account> PolicyList = new ArrayList();
    try
    {
      String polQuery = "begin LMS_WEB_CURSOR_GRP.alloc_refund_dtls(?,?,?);end;";
      
      cst = conn.prepareCall(polQuery);
      cst.registerOutParameter(1, -10);
      cst.setBigDecimal(2, (BigDecimal)this.session.getAttribute("policyCode"));
      
      cst.setBigDecimal(3, (BigDecimal)this.session.getAttribute("agent_code"));
      

      cst.execute();
      rst = (ResultSet)cst.getObject(1);
      while (rst.next())
      {
        Account myProd = new Account();
        
        myProd.setLPR_CODE(rst.getBigDecimal(1));
        myProd.setLPR_AMOUNT_TO_PAY(rst.getBigDecimal(2));
        myProd.setLPR_RAISED_BY(rst.getString(3));
        myProd.setLPR_DATE_DONE(rst.getDate(4));
        myProd.setLPR_PAID(rst.getString(5));
        myProd.setLPR_VOUCHER_NO(rst.getString(6));
        myProd.setLPR_AUTHORISED_BY(rst.getString(7));
        myProd.setLPR_AUTHORISED_DATE(rst.getDate(8));
        myProd.setAGN_CODE(rst.getBigDecimal(9));
        myProd.setAGN_NAME(rst.getString(10));
        

        PolicyList.add(myProd);
      }
      rst.close();
      cst.close();
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
      e.printStackTrace();
    }
    finally
    {
      GlobalCC.CloseConnections(rst, cst, conn);
    }
    return PolicyList;
  }
  
  public List<Account> findPoliciesToAllocate()
  {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    ResultSet rst = null;
    
    List<Account> PolicyList = new ArrayList();
    try
    {
      String polQuery = "begin LMS_WEB_CURSOR_GRP.find_alloc_policies(?);end;";
      
      cst = conn.prepareCall(polQuery);
      cst.registerOutParameter(1, -10);
      
      cst.execute();
      rst = (ResultSet)cst.getObject(1);
      while (rst.next())
      {
        Account myProd = new Account();
        

        myProd.setPOL_CODE(rst.getBigDecimal(1));
        myProd.setPOL_POLICY_NO(rst.getString(2));
        myProd.setPRP_NAME(rst.getString(3));
        myProd.setENDR_COINSURANCE(rst.getString(4));
        
        PolicyList.add(myProd);
      }
      rst.close();
      cst.close();
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    finally
    {
      GlobalCC.CloseConnections(rst, cst, conn);
    }
    return PolicyList;
  }
  
  public List<Account> findDistributionCriteria()
  {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    ResultSet rst = null;
    
    List<Account> PolicyList = new ArrayList();
    try
    {
      String polQuery = "begin LMS_WEB_CURSOR_GRP.get_pens_endr(?,?);end;";
      
      cst = conn.prepareCall(polQuery);
      cst.registerOutParameter(1, -10);
      cst.setBigDecimal(2, (BigDecimal)this.session.getAttribute("policyCode"));
      

      cst.execute();
      rst = (ResultSet)cst.getObject(1);
      while (rst.next())
      {
        Account myProd = new Account();
        
        myProd.setDIS_ENDR_CODE(rst.getBigDecimal(2));
        myProd.setDIS_ENDR_NO(rst.getString(1));
        myProd.setDIS_ENDR_TRANS_TYPE(rst.getString(3));
        

        PolicyList.add(myProd);
      }
      rst.close();
      cst.close();
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    finally
    {
      GlobalCC.CloseConnections(rst, cst, conn);
    }
    return PolicyList;
  }
  
  public List<Account> findPremiumMemberCovers()
  {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    ResultSet rst = null;
    
    List<Account> PolicyList = new ArrayList();
    try
    {
      String polQuery = "begin LMS_WEB_CURSOR_GRP.getPremMemberCovers(?,?,?);end;";
      
      cst = conn.prepareCall(polQuery);
      cst.registerOutParameter(1, -10);
      cst.setBigDecimal(2, (BigDecimal)this.session.getAttribute("policyCode"));
      
      cst.setBigDecimal(3, (BigDecimal)this.session.getAttribute("GrctCode"));
      
      cst.execute();
      rst = (ResultSet)cst.getObject(1);
      while (rst.next())
      {
        Account myProd = new Account();
        

        myProd.setPCM_ENDR_CODE(rst.getBigDecimal(1));
        myProd.setPCM_POLM_CODE(rst.getBigDecimal(2));
        myProd.setMEM_NO(rst.getString(3));
        myProd.setMEMBER_DISPLAY(rst.getString(4));
        myProd.setPCM_EARNINGS(rst.getBigDecimal(5));
        myProd.setPCM_PREMIUM(rst.getBigDecimal(6));
        myProd.setPCM_ALLOCATED_PREMIUM(rst.getBigDecimal(7));
        myProd.setPCM_PAID_AMOUNT(rst.getBigDecimal(8));
        
        PolicyList.add(myProd);
      }
      rst.close();
      cst.close();
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    finally
    {
      GlobalCC.CloseConnections(rst, cst, conn);
    }
    return PolicyList;
  }
  
  public List<Account> findPremiumMemberCovers_All()
  {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    ResultSet rst = null;
    
    List<Account> PolicyList = new ArrayList();
    try
    {
      String polQuery = "begin LMS_WEB_CURSOR_GRP.getpremmembercovers_all(?,?,?);end;";
      
      cst = conn.prepareCall(polQuery);
      cst.registerOutParameter(1, -10);
      cst.setBigDecimal(2, (BigDecimal)this.session.getAttribute("policyCode"));
      
      cst.setBigDecimal(3, (BigDecimal)this.session.getAttribute("GrctCode"));
      
      cst.execute();
      rst = (ResultSet)cst.getObject(1);
      while (rst.next())
      {
        Account myProd = new Account();
        

        myProd.setPCM_ENDR_CODE(rst.getBigDecimal(1));
        myProd.setPCM_POLM_CODE(rst.getBigDecimal(2));
        myProd.setMEM_NO(rst.getString(3));
        myProd.setMEMBER_DISPLAY(rst.getString(4));
        myProd.setPCM_EARNINGS(rst.getBigDecimal(5));
        myProd.setPCM_PREMIUM(rst.getBigDecimal(6));
        myProd.setPCM_ALLOCATED_PREMIUM(rst.getBigDecimal(7));
        myProd.setPCM_PAID_AMOUNT(rst.getBigDecimal(8));
        
        PolicyList.add(myProd);
      }
      rst.close();
      cst.close();
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    finally
    {
      GlobalCC.CloseConnections(rst, cst, conn);
    }
    return PolicyList;
  }
  
  public List<Account> findAllocPremiumMemberCovers()
  {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    ResultSet rst = null;
    
    List<Account> PolicyList = new ArrayList();
    try
    {
      String polQuery = "begin LMS_WEB_CURSOR_GRP.getallocPremMemCvrs(?,?,?);end;";
      
      cst = conn.prepareCall(polQuery);
      cst.registerOutParameter(1, -10);
      cst.setBigDecimal(2, (BigDecimal)this.session.getAttribute("policyCode"));
      
      cst.setBigDecimal(3, (BigDecimal)this.session.getAttribute("GrctCode"));
      
      cst.execute();
      rst = (ResultSet)cst.getObject(1);
      while (rst.next())
      {
        Account myProd = new Account();
        

        myProd.setPCM_CODE(rst.getBigDecimal(1));
        myProd.setMEM_NO(rst.getString(2));
        myProd.setMEMBER_DISPLAY(rst.getString(3));
        myProd.setPCM_EARNINGS(rst.getBigDecimal(4));
        myProd.setPCM_PREMIUM(rst.getBigDecimal(5));
        myProd.setPCM_ALLOCATED_PREMIUM(rst.getBigDecimal(6));
        myProd.setPCM_PAID_AMOUNT(rst.getBigDecimal(7));
        
        PolicyList.add(myProd);
      }
      rst.close();
      cst.close();
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    finally
    {
      GlobalCC.CloseConnections(rst, cst, conn);
    }
    return PolicyList;
  }
  
  public List<Account> findImportPremiumMemberCovers()
  {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    ResultSet rst = null;
    
    List<Account> PolicyList = new ArrayList();
    try
    {
      String polQuery = "begin LMS_WEB_CURSOR_GRP.get_imp_mem_prem_sch(?,?);end;";
      
      cst = conn.prepareCall(polQuery);
      cst.registerOutParameter(1, -10);
      cst.setInt(2, ((Integer)this.session.getAttribute("receiptTemplateSeq")).intValue());
      
      cst.execute();
      rst = (ResultSet)cst.getObject(1);
      while (rst.next())
      {
        Account myProd = new Account();
        

        myProd.setMIP_CODE(rst.getBigDecimal(1));
        myProd.setPCM_ENDR_CODE(rst.getBigDecimal(2));
        myProd.setPCM_POLM_CODE(rst.getBigDecimal(3));
        myProd.setMIP_PCM_EARNINGS(rst.getBigDecimal(4));
        myProd.setMIP_PCM_PREMIUM(rst.getBigDecimal(5));
        myProd.setMIP_PCM_ALLOCATED_AMT(rst.getBigDecimal(6));
        myProd.setMIP_BATCH_NO(rst.getString(7));
        myProd.setMIP_MEM_NO(rst.getString(8));
        myProd.setMIP_MEMBER_NAME(rst.getString(9));
        
        PolicyList.add(myProd);
      }
      rst.close();
      cst.close();
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    finally
    {
      GlobalCC.CloseConnections(rst, cst, conn);
    }
    return PolicyList;
  }
  
  public List<Account> findPensionAllocations()
  {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    ResultSet rst = null;
    
    List<Account> PolicyList = new ArrayList();
    try
    {
      String polQuery = "begin LMS_WEB_CURSOR_GRP.FindPensionAllocations(?,?,?,?,?,?);end;";
      
      cst = conn.prepareCall(polQuery);
      cst.registerOutParameter(1, -10);
      cst.setBigDecimal(2, (BigDecimal)this.session.getAttribute("policyCode"));
      
      cst.setString(3, LOVCC.Allocated);
      cst.setBigDecimal(4, (BigDecimal)this.session.getAttribute("GrctCode"));
      cst.setBigDecimal(5, (BigDecimal)this.session.getAttribute("PNDP_CODE"));
      
      cst.setBigDecimal(6, (BigDecimal)this.session.getAttribute("endorsementCode"));
      


      cst.execute();
      rst = (ResultSet)cst.getObject(1);
      while (rst.next())
      {
        Account myProd = new Account();
        
        myProd.setMEM_NO_DISPLAY(rst.getString(1));
        myProd.setPEN_MEMBER_DISPLAY(rst.getString(2));
        myProd.setEmpyr_reg_transfer(rst.getBigDecimal(3));
        myProd.setEmpyr_unreg_transfer(rst.getBigDecimal(4));
        myProd.setEmpye_reg_transfer(rst.getBigDecimal(5));
        myProd.setEmpye_unreg_transfer(rst.getBigDecimal(6));
        myProd.setV_paid_er_amt(rst.getString(7));
        myProd.setV_paid_ee_amt(rst.getString(8));
        myProd.setV_paid_ee_vol_amt(rst.getString(9));
        myProd.setV_paid_er_vol_amt(rst.getString(10));
        myProd.setALLOCATED_AMOUNT(rst.getString(11));
        

        myProd.setPAID_AMOUNT(rst.getString(12));
        myProd.setPMPNS_EARNINGS(rst.getString(13));
        myProd.setPMPNS_EMPLOYER_CONTR(rst.getString(14));
        myProd.setPMPNS_EMPLOYEE_CONTR(rst.getString(15));
        myProd.setPMPNS_CODE(rst.getBigDecimal(16));
        myProd.setPNDP_CODE2(rst.getString(17));
        myProd.setV_empyr_loan_repay(null);
        myProd.setV_empye_loan_repay(null);
        
        PolicyList.add(myProd);
      }
      rst.close();
      cst.close();
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    finally
    {
      GlobalCC.CloseConnections(rst, cst, conn);
    }
    return PolicyList;
  }
  
  public List<Account> findImportedPensionAllocations()
  {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    ResultSet rst = null;
    
    List<Account> PolicyList = new ArrayList();
    try
    {
      String polQuery = "begin LMS_WEB_CURSOR_GRP.get_exported_pens_dtls(?,?);end;";
      
      cst = conn.prepareCall(polQuery);
      cst.registerOutParameter(1, -10);
      cst.setInt(2, ((Integer)this.session.getAttribute("receiptTemplateSeq")).intValue());
      

      cst.execute();
      rst = (ResultSet)cst.getObject(1);
      while (rst.next())
      {
        Account myProd = new Account();
        
        myProd.setMEM_NO_DISPLAY(rst.getString(1));
        myProd.setPEN_MEMBER_DISPLAY(rst.getString(2));
        myProd.setV_paid_er_bf_amt(rst.getString(3));
        myProd.setV_paid_ee_bf_amt(rst.getString(4));
        myProd.setV_paid_er_amt(rst.getString(7));
        myProd.setV_paid_ee_amt(rst.getString(8));
        myProd.setV_paid_ee_vol_amt(rst.getString(10));
        myProd.setV_paid_er_vol_amt(rst.getString(9));
        myProd.setALLOCATED_AMOUNT(rst.getString(9));
        myProd.setPAID_AMOUNT(rst.getString(10));
        myProd.setPMPNS_EARNINGS(rst.getString(11));
        myProd.setPMPNS_EMPLOYER_CONTR(rst.getString(14));
        myProd.setPMPNS_EMPLOYEE_CONTR(rst.getString(15));
        myProd.setEmyr_reg_amount(rst.getBigDecimal(18));
        myProd.setEmye_reg_amount(rst.getBigDecimal(19));
        myProd.setEmyr_unreg_amount(rst.getBigDecimal(20));
        myProd.setEmye_unreg_amount(rst.getBigDecimal(21));
        
        PolicyList.add(myProd);
      }
      rst.close();
      cst.close();
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    finally
    {
      GlobalCC.CloseConnections(rst, cst, conn);
    }
    return PolicyList;
  }
  
  public List<Account> findLoadedBalances()
  {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    ResultSet rst = null;
    
    List<Account> PolicyList = new ArrayList();
    try
    {
      String polQuery = "begin LMS_WEB_CURSOR_GRP.find_loaded_bal(?);end;";
      
      cst = conn.prepareCall(polQuery);
      cst.registerOutParameter(1, -10);
      
      cst.execute();
      rst = (ResultSet)cst.getObject(1);
      while (rst.next())
      {
        Account myProd = new Account();
        

        myProd.setPOLICY_NO(rst.getString(1));
        myProd.setAMOUNT(rst.getBigDecimal(2));
        myProd.setLOADED(rst.getString(3));
        myProd.setLOADED_DESC(rst.getString(4));
        myProd.setLOAD_REMARKS(rst.getString(5));
        myProd.setLOAD_BY(rst.getString(6));
        myProd.setLOAD_DATE(rst.getDate(7));
        myProd.setBAL_DATE(rst.getDate(8));
        myProd.setGBL_CODE(rst.getBigDecimal(9));
        myProd.setGBL_DRCR(rst.getString(10));
        myProd.setPROD_CODE(rst.getBigDecimal(11));
        myProd.setPROD_DESC(rst.getString(12));
        myProd.setBRN_CODE(rst.getBigDecimal(13));
        myProd.setBRN_NAME(rst.getString(14));
        myProd.setPRP_CODE(rst.getBigDecimal(15));
        myProd.setCLIENT(rst.getString(16));
        myProd.setGBL_FREQ_OF_PAY(rst.getString(17));
        myProd.setGBL_DURATION_TYPE(rst.getString(18));
        myProd.setGBL_EFFECTIVE_DATE(rst.getDate(19));
        myProd.setAGN_CODE(rst.getBigDecimal(20));
        myProd.setAGN_NAME(rst.getString(21));
        

        PolicyList.add(myProd);
      }
      rst.close();
      cst.close();
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    finally
    {
      GlobalCC.CloseConnections(rst, cst, conn);
    }
    return PolicyList;
  }
  
  public List<Account> findPoliciesToLoad()
  {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    ResultSet rst = null;
    
    List<Account> PolicyList = new ArrayList();
    try
    {
      String polQuery = "begin LMS_WEB_CURSOR_GRP.find_policies_to_load(?);end;";
      
      cst = conn.prepareCall(polQuery);
      cst.registerOutParameter(1, -10);
      
      cst.execute();
      rst = (ResultSet)cst.getObject(1);
      while (rst.next())
      {
        Account myProd = new Account();
        

        myProd.setLGPL_SN(rst.getBigDecimal(1));
        myProd.setLGPL_CLIENT(rst.getString(2));
        myProd.setLGPL_NO_MEM(rst.getBigDecimal(3));
        myProd.setLGPL_SHARE(rst.getString(4));
        myProd.setLGPL_COMMENC_DT(rst.getDate(5));
        myProd.setLGPL_RENEW_DT(rst.getDate(6));
        myProd.setLGPL_NEXT_REN_DT(rst.getDate(7));
        myProd.setLGPL_RATES(rst.getString(8));
        myProd.setLGPL_TOT_SA(rst.getBigDecimal(9));
        myProd.setLGPL_TOT_PREM(rst.getBigDecimal(10));
        myProd.setLGPL_TOT_PREM_PAID(rst.getBigDecimal(11));
        myProd.setLGPL_OUTS_PREM(rst.getBigDecimal(12));
        myProd.setLGPL_PROD_NAME(rst.getString(13));
        myProd.setLGPL_AGENT_NAME(rst.getString(14));
        myProd.setLGPL_AGENT(rst.getString(15));
        myProd.setLGPL_POL_NO(rst.getString(16));
        myProd.setLGPL_BRANCH(rst.getString(17));
        myProd.setLGPL_AOI(rst.getString(18));
        myProd.setLGPL_COMM_RATE(rst.getString(19));
        myProd.setLGPL_OV_COMM_RATE(rst.getString(20));
        myProd.setLGPL_VAT_RATE(rst.getString(21));
        myProd.setLGPL_DURATION(rst.getString(22));
        myProd.setLGPL_FREQ_OF_PAY(rst.getString(23));
        myProd.setLGPL_POL_CATEGORY(rst.getString(24));
        myProd.setLGPL_MULTI_EARNINGS(rst.getBigDecimal(25));
        myProd.setLGPL_FCL(rst.getBigDecimal(26));
        myProd.setLGPL_CODE(rst.getBigDecimal(27));
        myProd.setLGPL_REMARKS(rst.getString(28));
        
        PolicyList.add(myProd);
      }
      rst.close();
      cst.close();
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    finally
    {
      GlobalCC.CloseConnections(rst, cst, conn);
    }
    return PolicyList;
  }
  
  public List<Account> findPolMembersToLoad()
  {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    ResultSet rst = null;
    
    List<Account> PolicyList = new ArrayList();
    try
    {
      String polQuery = "begin LMS_WEB_CURSOR_GRP.find_polmem_to_load(?,?);end;";
      
      cst = conn.prepareCall(polQuery);
      cst.registerOutParameter(1, -10);
      cst.setString(2, (String)this.session.getAttribute("policyNumber"));
      
      cst.execute();
      rst = (ResultSet)cst.getObject(1);
      while (rst.next())
      {
        Account myProd = new Account();
        
        myProd.setLGMD_SN(rst.getBigDecimal(1));
        myProd.setLGMD_SURNAME(rst.getString(2));
        myProd.setLGMD_DOB(rst.getDate(3));
        myProd.setLGMD_ANB(rst.getBigDecimal(4));
        myProd.setLGMD_CATEGORY(rst.getString(5));
        myProd.setLGMD_EARNINGS_PRD(rst.getBigDecimal(6));
        myProd.setLGMD_OCCUPATION(rst.getString(7));
        myProd.setLGMD_BASIC(rst.getString(8));
        myProd.setLGMD_HOUSING(rst.getString(9));
        myProd.setLGMD_TRANSPORT(rst.getString(10));
        myProd.setLGMD_MONTH_SAL(rst.getString(11));
        myProd.setLGMD_TOT_EMUL(rst.getBigDecimal(12));
        myProd.setLGMD_SA(rst.getBigDecimal(13));
        myProd.setLGMD_PREM(rst.getBigDecimal(14));
        myProd.setLGMD_PREM_RATE(rst.getBigDecimal(15));
        myProd.setLGMD_POL_NO(rst.getString(16));
        myProd.setLGMD_DOJ(rst.getDate(17));
        myProd.setLGMD_COVER_FROM_DATE(rst.getDate(18));
        myProd.setLGMD_EMYR_BAL_BF(rst.getBigDecimal(19));
        myProd.setLGMD_EMYE_BAL_BF(rst.getBigDecimal(20));
        myProd.setLGMD_EMPYR_CONTRI(rst.getBigDecimal(21));
        myProd.setLGMD_EMYE_CONTRI(rst.getBigDecimal(22));
        myProd.setLGMD_ORIG_LOAN_AMT(rst.getBigDecimal(23));
        myProd.setLGMD_LOAN_ISSUE_DATE(rst.getDate(24));
        myProd.setLGMD_ORIG_LN_PRD(rst.getBigDecimal(25));
        myProd.setLGMD_LOAN_INT(rst.getBigDecimal(26));
        
        PolicyList.add(myProd);
      }
      rst.close();
      cst.close();
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    finally
    {
      GlobalCC.CloseConnections(rst, cst, conn);
    }
    return PolicyList;
  }
  
  public List<Account> findPolToLoad()
  {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    ResultSet rst = null;
    
    List<Account> PolicyList = new ArrayList();
    try
    {
      String polQuery = "begin LMS_WEB_CURSOR_GRP.find_pol_to_load(?);end;";
      
      cst = conn.prepareCall(polQuery);
      cst.registerOutParameter(1, -10);
      cst.execute();
      rst = (ResultSet)cst.getObject(1);
      while (rst.next())
      {
        Account polData = new Account();
        polData.setLGPL_SN(rst.getBigDecimal(1));
        polData.setLGPL_CLIENT(rst.getString(2));
        polData.setLGPL_NO_MEM(rst.getBigDecimal(3));
        polData.setLGPL_SHARE(rst.getString(4));
        polData.setLGPL_COMMENC_DT(rst.getDate(5));
        polData.setLGPL_RENEW_DT(rst.getDate(6));
        polData.setLGPL_NEXT_REN_DT(rst.getDate(7));
        polData.setLGPL_RATES(rst.getString(8));
        polData.setLGPL_TOT_SA(rst.getBigDecimal(9));
        polData.setLGPL_TOT_PREM(rst.getBigDecimal(10));
        polData.setLGPL_TOT_PREM_PAID(rst.getBigDecimal(11));
        polData.setLGPL_OUTS_PREM(rst.getBigDecimal(12));
        polData.setLGPL_PROD_NAME(rst.getString(13));
        polData.setLGPL_AGENT_NAME(rst.getString(14));
        polData.setLGPL_AGENT(rst.getString(15));
        polData.setLGPL_POL_NO(rst.getString(16));
        polData.setLGPL_BRANCH(rst.getString(17));
        polData.setLGPL_AOI(rst.getString(18));
        polData.setLGPL_COMM_RATE(rst.getString(19));
        polData.setLGPL_OV_COMM_RATE(rst.getString(20));
        polData.setLGPL_VAT_RATE(rst.getString(21));
        polData.setLGPL_DURATION(rst.getString(22));
        polData.setLGPL_FREQ_OF_PAY(rst.getString(23));
        polData.setLGPL_POL_CATEGORY(rst.getString(24));
        polData.setLGPL_MULTI_EARNINGS(rst.getBigDecimal(25));
        polData.setLGPL_FCL(rst.getBigDecimal(26));
        polData.setLGPL_PENS_COMM_RATE(rst.getString(27));
        polData.setLGPL_PENS_PAYMENT_FREQ(rst.getString(28));
        polData.setLGPL_REGISTERED(rst.getString(29));
        polData.setLGPL_REG_NO(rst.getString(30));
        polData.setLGPL_PENS_TYPE(rst.getString(31));
        polData.setLGPL_CONTRI_TYPE(rst.getString(32));
        polData.setLGPL_EMYE_CONTRI(rst.getBigDecimal(33));
        polData.setLGPL_EMYR_CONTRI(rst.getBigDecimal(34));
        polData.setLGPL_MALE_NRD(rst.getString(35));
        polData.setLGPL_FEMALE_NRD(rst.getString(36));
        polData.setLGPL_GRNTD_PRD(rst.getString(37));
        polData.setLGPL_EARNINGS_ESC(rst.getString(38));
        

        PolicyList.add(polData);
      }
      rst.close();
      cst.close();
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
      e.printStackTrace();
    }
    finally
    {
      GlobalCC.CloseConnections(rst, cst, conn);
    }
    return PolicyList;
  }
  
  public List<Account> findPolCoinsToLoad()
  {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    ResultSet rst = null;
    
    List<Account> PolicyList = new ArrayList();
    try
    {
      String polQuery = "begin LMS_WEB_CURSOR_GRP.find_polcoins_to_load(?,?);end;";
      
      cst = conn.prepareCall(polQuery);
      cst.registerOutParameter(1, -10);
      cst.setString(2, (String)this.session.getAttribute("policyNumber"));
      
      cst.execute();
      rst = (ResultSet)cst.getObject(1);
      while (rst.next())
      {
        Account myProd = new Account();
        

        myProd.setLGCA_COINSURER(rst.getString(1));
        myProd.setLGCA_COIN_SHARE(rst.getString(2));
        myProd.setLGCA_POL_NO(rst.getString(3));
        myProd.setLGCA_AGN_CODE(rst.getBigDecimal(4));
        myProd.setLGCA_CODE(rst.getBigDecimal(5));
        

        PolicyList.add(myProd);
      }
      rst.close();
      cst.close();
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    finally
    {
      GlobalCC.CloseConnections(rst, cst, conn);
    }
    return PolicyList;
  }
  
  public List<Account> findPolRidersToLoad()
  {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    ResultSet rst = null;
    
    List<Account> PolicyList = new ArrayList();
    try
    {
      String polQuery = "begin LMS_WEB_CURSOR_GRP.find_polriders_to_load(?,?);end;";
      
      cst = conn.prepareCall(polQuery);
      cst.registerOutParameter(1, -10);
      cst.setString(2, (String)this.session.getAttribute("policyNumber"));
      
      cst.execute();
      rst = (ResultSet)cst.getObject(1);
      while (rst.next())
      {
        Account myProd = new Account();
        

        myProd.setLGRA_POL_NO(rst.getString(1));
        myProd.setLGRA_MEM_NO(rst.getString(2));
        myProd.setLGRA_SA(rst.getBigDecimal(3));
        myProd.setLGRA_BEN_CODE(rst.getString(4));
        myProd.setLGRA_BEN_TYPE(rst.getString(5));
        myProd.setLGRA_BEN_SA(rst.getBigDecimal(6));
        myProd.setLGRA_BEN_RATE(rst.getBigDecimal(7));
        myProd.setLGRA_BEN_PREM(rst.getBigDecimal(8));
        
        PolicyList.add(myProd);
      }
      rst.close();
      cst.close();
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
      e.printStackTrace();
    }
    return PolicyList;
  }
  
  public List<Account> findPolClientToLoad()
  {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    ResultSet rst = null;
    
    List<Account> PolicyList = new ArrayList();
    try
    {
      String polQuery = "begin LMS_WEB_CURSOR_GRP.getLoadedClients(?);end;";
      
      cst = conn.prepareCall(polQuery);
      cst.registerOutParameter(1, -10);
      cst.execute();
      rst = (ResultSet)cst.getObject(1);
      while (rst.next())
      {
        Account myProd = new Account();
        myProd.setLGCD_BANK_BRANCH(rst.getString(1));
        myProd.setLGCD_SN(rst.getBigDecimal(2));
        myProd.setLGCD_CLIENT_BANK_NAME(rst.getString(3));
        myProd.setLGCD_OCCUPATION(rst.getString(4));
        myProd.setLGCD_CLIENT_FAX(rst.getString(5));
        myProd.setLGCD_AGENT_TEL(rst.getString(6));
        myProd.setLGCD_CLIENT_TEL(rst.getString(7));
        myProd.setLGCD_CLIENT_COUNTRY(rst.getString(8));
        myProd.setLGCD_CLIENT_TOWN(rst.getString(9));
        myProd.setLGCD_AGENT_ADDRESS(rst.getString(10));
        myProd.setLGCD_CLIENT_ADDRESS(rst.getString(11));
        myProd.setLGCD_NAME(rst.getString(12));
        myProd.setLGCD_CLIENT_ID(rst.getString(13));
        myProd.setLGCD_ACC_NO(rst.getString(14));
        

        PolicyList.add(myProd);
      }
      rst.close();
      cst.close();
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    finally
    {
      GlobalCC.CloseConnections(rst, cst, conn);
    }
    return PolicyList;
  }
  
  public List<Account> findPolCoinsurersToLoad()
  {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    ResultSet rst = null;
    
    List<Account> PolicyList = new ArrayList();
    try
    {
      String polQuery = "begin LMS_WEB_CURSOR_GRP.getLoadedCoinsurersData(?);end;";
      
      cst = conn.prepareCall(polQuery);
      cst.registerOutParameter(1, -10);
      cst.execute();
      rst = (ResultSet)cst.getObject(1);
      while (rst.next())
      {
        Account myProd = new Account();
        
        myProd.setLGCA_SCHEME(rst.getString(1));
        myProd.setLGCA_CO_SHARE(rst.getString(2));
        myProd.setLGCA_COINSURER(rst.getString(3));
        myProd.setLGCA_COIN_SHARE(rst.getString(4));
        myProd.setLGCA_POL_NO(rst.getString(4));
        PolicyList.add(myProd);
      }
      rst.close();
      cst.close();
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    finally
    {
      GlobalCC.CloseConnections(rst, cst, conn);
    }
    return PolicyList;
  }
  
  public List<Account> findAccountTypes()
  {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    ResultSet rst = null;
    
    List<Account> accountTypes = new ArrayList();
    try
    {
      String accQuery = "begin LMS_WEB_CURSOR_GRP.getAccountTypes(?);end;";
      
      cst = conn.prepareCall(accQuery);
      cst.registerOutParameter(1, -10);
      cst.execute();
      rst = (ResultSet)cst.getObject(1);
      while (rst.next())
      {
        Account accType = new Account();
        accType.setACT_CODE(rst.getBigDecimal(1));
        accType.setACT_ACCOUNT_TYPE(rst.getString(2));
        accountTypes.add(accType);
      }
      rst.close();
      cst.close();
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    finally
    {
      GlobalCC.CloseConnections(rst, cst, conn);
    }
    return accountTypes;
  }
  
  public List<Account> findAgentByAcc()
  {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    ResultSet rst = null;
    
    List<Account> agentsList = new ArrayList();
    try
    {
      String accQuery = "begin LMS_WEB_CURSOR_GRP.getAgentsByAccount(?,?);end;";
      
      cst = conn.prepareCall(accQuery);
      cst.registerOutParameter(1, -10);
      cst.setBigDecimal(2, (BigDecimal)this.session.getAttribute("account_code"));
      
      cst.execute();
      rst = (ResultSet)cst.getObject(1);
      while (rst.next())
      {
        Account agnAcc = new Account();
        agnAcc.setAGN_CODE(rst.getBigDecimal(1));
        agnAcc.setAGN_NAME(rst.getString(2));
        agentsList.add(agnAcc);
      }
      rst.close();
      cst.close();
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    finally
    {
      GlobalCC.CloseConnections(rst, cst, conn);
    }
    return agentsList;
  }
  
  public List<Account> findChqStatuses()
  {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    ResultSet rst = null;
    
    List<Account> chequeList = new ArrayList();
    try
    {
      String chequeQuery = "begin LMS_WEB_CURSOR_GRP.findChequeStatuses(?,?,?,?,?,?,?,?,?);end;";
      
      cst = conn.prepareCall(chequeQuery);
      cst.registerOutParameter(1, -10);
      cst.setString(2, (String)this.session.getAttribute("chq_date_from"));
      cst.setString(3, (String)this.session.getAttribute("chq_date_to"));
      cst.setString(4, (String)this.session.getAttribute("chq_trans_type"));
      cst.setString(5, (String)this.session.getAttribute("chq_mem_no"));
      cst.setString(6, (String)this.session.getAttribute("chq_mem_name"));
      cst.setString(7, (String)this.session.getAttribute("chq_payee_name"));
      cst.setString(8, (String)this.session.getAttribute("chq_clm_no"));
      cst.setBigDecimal(9, (BigDecimal)this.session.getAttribute("policyCode"));
      cst.execute();
      rst = (ResultSet)cst.getObject(1);
      while (rst.next())
      {
        Account chkStatus = new Account();
        chkStatus.setCqrRefNo(rst.getString(1));
        chkStatus.setCqrNarrative(rst.getString(2));
        chkStatus.setCqrFmsRemarks(rst.getString(3));
        chkStatus.setCqrAmount(rst.getBigDecimal(4));
        chkStatus.setCrqPayee(rst.getString(5));
        chkStatus.setCqrChqNo(rst.getString(6));
        chkStatus.setCqrChequeDate(rst.getDate(7));
        chkStatus.setCqrPmtVchno(rst.getString(8));
        chkStatus.setCstDescription(rst.getString(9));
        chkStatus.setPolicy_no(rst.getString(10));
        chkStatus.setClient(rst.getString(11));
        chkStatus.setCpvDateAuth(rst.getDate(12));
        chkStatus.setCqrChqDispactDate(rst.getDate(13));
        chkStatus.setTotalChequeAmt(rst.getBigDecimal(14));  
        chequeList.add(chkStatus);
      }
      rst.close();
      cst.close();
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    finally
    {
      GlobalCC.CloseConnections(rst, cst, conn);
    }
    return chequeList;
  }
  
  public List<Account> findPeriodTreatySumm()
  {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    ResultSet rst = null;
    
    List<Account> treatySummList = new ArrayList();
    try
    {
      String query = "begin LMS_WEB_CURSOR_GRP.getPeriodTreatySumm(?,?,?,?);end;";
      
      cst = conn.prepareCall(query);
      cst.registerOutParameter(1, -10);
      cst.setBigDecimal(2, (BigDecimal)this.session.getAttribute("ta_code"));
      cst.setString(3, (String)this.session.getAttribute("DateFrom"));
      cst.setString(4, (String)this.session.getAttribute("DateTo"));
      cst.execute();
      rst = (ResultSet)cst.getObject(1);
      while (rst.next())
      {
        Account treatySumm = new Account();
        treatySumm.setPrtsCode(rst.getBigDecimal(1));
        treatySumm.setPrtsUwYear(rst.getBigDecimal(2));
        treatySumm.setPrtsFiscalYear(rst.getBigDecimal(3));
        treatySumm.setPrtsFiscalMonth(rst.getBigDecimal(4));
        treatySumm.setProdDesc(rst.getString(5));
        treatySumm.setPrtsCededPremium(rst.getBigDecimal(6));
        treatySumm.setPrtsReinComm(rst.getBigDecimal(7));
        treatySumm.setPrtsPremTax(rst.getBigDecimal(8));
        treatySumm.setPrtsReinPRemTax(rst.getBigDecimal(9));
        treatySumm.setPrtsClaimsIncurred(rst.getBigDecimal(10));
        treatySumm.setPrtsClaimsPaid(rst.getBigDecimal(11));
        treatySumm.setPrtsTrtCode(rst.getBigDecimal(12));
        treatySumm.setPrtsTaCode(rst.getBigDecimal(13));
        treatySumm.setPrtsAsCode(rst.getBigDecimal(14));
        treatySumm.setAGN_NAME(rst.getString(15));
        treatySumm.setRefNo(rst.getString(16));
        treatySummList.add(treatySumm);
      }
      rst.close();
      cst.close();
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
      e.printStackTrace();
    }
    finally
    {
      GlobalCC.CloseConnections(rst, cst, conn);
    }
    return treatySummList;
  }
  
  public List<Account> findTreatySummary()
  {
    DBConnector myConn = new DBConnector();
    String query = "begin LMS_WEB_CURSOR_GRP.get_portfolio_treaty_summary(?,?,?);end;";
    
    CallableStatement stmt = null;
    Connection conn = null;
    BigDecimal tacode = null;
    ResultSet rst = null;
    List<Account> trarrangements = new ArrayList();
    try
    {
      if (this.session.getAttribute("ta_code") != null) {
        tacode = (BigDecimal)this.session.getAttribute("ta_code");
      } else {
        tacode = null;
      }
      conn = myConn.getDatabaseConn();
      stmt = conn.prepareCall(query);
      stmt.setBigDecimal(1, tacode);
      stmt.registerOutParameter(2, -10);
      
      stmt.setString(3, (String)this.session.getAttribute("recTrans"));
      stmt.execute();
      rst = (ResultSet)stmt.getObject(2);
      while (rst.next())
      {
        Account tr = new Account();
        tr.setTS_CODE(rst.getBigDecimal(1));
        tr.setTS_REI_CODE(rst.getBigDecimal(2));
        tr.setTS_TRT_CODE(rst.getBigDecimal(3));
        tr.setTS_TA_CODE(rst.getBigDecimal(4));
        tr.setTS_UW_YEAR(rst.getBigDecimal(5));
        tr.setTS_TRAN_DATE(rst.getDate(6));
        tr.setTS_CUMM_CEDED_PREMIUM(rst.getBigDecimal(7));
        tr.setTS_CUMM_CEDED_CLAIMS(rst.getBigDecimal(8));
        tr.setTS_CUMM_CLAIMS_PAID(rst.getBigDecimal(9));
        tr.setTS_CUMM_PREM_TAX(rst.getBigDecimal(10));
        tr.setTS_CUMM_REIN_PREM_TAX(rst.getBigDecimal(11));
        tr.setTS_ENTRY_CLAIM_AMT(rst.getBigDecimal(12));
        tr.setTS_ENTRY_PREM_AMT(rst.getBigDecimal(13));
        tr.setTS_ENTRY_PORTFOLIO_LOSS(rst.getBigDecimal(14));
        tr.setTS_WITHDRAWAL_PREM_AMT(rst.getBigDecimal(15));
        tr.setTS_WITHDRAWAL_CLAIM_AMT(rst.getBigDecimal(16));
        tr.setTS_WITHDRAWAL_PROFIT_LOSS(rst.getBigDecimal(17));
        tr.setTS_MGT_EXPENSE_AMT(rst.getBigDecimal(18));
        tr.setTS_CUMM_REIN_COMM(rst.getBigDecimal(19));
        tr.setTS_FISCAL_YEAR(rst.getBigDecimal(20));
        tr.setTS_TRS_CODE(rst.getBigDecimal(21));
        tr.setTS_TRS_SHT_DESC(rst.getString(22));
        tr.setTS_AS_CODE(rst.getBigDecimal(23));
        tr.setTS_INTEREST_TAX(rst.getBigDecimal(24));
        tr.setTS_INTEREST(rst.getBigDecimal(25));
        tr.setTS_PROFIT_COMM(rst.getBigDecimal(26));
        tr.setINCOME(rst.getBigDecimal(27));
        tr.setOUTGO(rst.getBigDecimal(28));
        tr.setPROFIT_LOSS(rst.getBigDecimal(29));
        tr.setAGN_NAME(rst.getString(30));
        tr.setTS_AMT_PAID(rst.getBigDecimal(31));
        tr.setStatus(rst.getString(32));
        tr.setTS_DRCR_NO(rst.getString(33));
        tr.setTS_DRCR(rst.getString(34));
        tr.setTS_VOUCHER_NO(rst.getString(35));
        tr.setPayRi(false);
        trarrangements.add(tr);
      }
      rst.close();
      stmt.close();
      conn.close();
    }
    catch (SQLException e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
      e.printStackTrace();
    }
    finally
    {
      GlobalCC.CloseConnections(rst, stmt, conn);
    }
    return trarrangements;
  }
  
  public List<Account> findTaxPayments()
  {
    DBConnector myConn = new DBConnector();
    String query = "begin LMS_WEB_CURSOR_GRP.findtaxpayments(?,?,?,?,?,?,?);end;";
    
    CallableStatement stmt = null;
    Connection conn = null;
    ResultSet rst = null;
    List<Account> taxPaymentList = new ArrayList();
    try
    {
      conn = myConn.getDatabaseConn();
      stmt = conn.prepareCall(query);
      stmt.registerOutParameter(1, -10);
      
      stmt.setString(2, (String)this.session.getAttribute("taxType"));
      stmt.setBigDecimal(3, (BigDecimal)this.session.getAttribute("brnCode"));
      stmt.setString(4, (String)this.session.getAttribute("DateFrom"));
      stmt.setString(5, (String)this.session.getAttribute("DateTo"));
      stmt.setString(6, (String)this.session.getAttribute("consolidateBranch"));
      
      stmt.setBigDecimal(7, (BigDecimal)this.session.getAttribute("TaxesCode"));
      
      stmt.execute();
      rst = (ResultSet)stmt.getObject(1);
      while (rst.next())
      {
        Account txp = new Account();
        txp.setGrct_code(rst.getBigDecimal(1));
        txp.setPOL_POLICY_NO(rst.getString(2));
        txp.setCLIENT(rst.getString(3));
        txp.setBRN_NAME(rst.getString(4));
        txp.setLmpMonth(rst.getString(5));
        txp.setLmpMonthNo(rst.getBigDecimal(6));
        txp.setPndpTotAmt(rst.getBigDecimal(7));
        txp.setPndpAdminFee(rst.getBigDecimal(8));
        txp.setPndpVateAmt(rst.getBigDecimal(9));
        txp.setAgnName(rst.getString(10));
        txp.setPayTaxes(false);
        taxPaymentList.add(txp);
      }
      rst.close();
      stmt.close();
      conn.close();
    }
    catch (SQLException e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
      e.printStackTrace();
    }
    finally
    {
      GlobalCC.CloseConnections(rst, stmt, conn);
    }
    return taxPaymentList;
  }
  
  public List<Account> findTaxTypes()
  {
    DBConnector myConn = new DBConnector();
    String query = "begin LMS_WEB_CURSOR_GRP.findTaxType(?);end;";
    CallableStatement stmt = null;
    Connection conn = null;
    ResultSet rst = null;
    List<Account> taxTypeList = new ArrayList();
    try
    {
      conn = myConn.getDatabaseConn();
      stmt = conn.prepareCall(query);
      stmt.registerOutParameter(1, -10);
      
      stmt.execute();
      rst = (ResultSet)stmt.getObject(1);
      while (rst.next())
      {
        Account txType = new Account();
        txType.setTt_code(rst.getBigDecimal(1));
        txType.setTt_sht_desc(rst.getString(2));
        txType.setTt_desc(rst.getString(3));
        txType.setTt_type(rst.getString(4));
        txType.setTt_type_desc(rst.getString(5));
        taxTypeList.add(txType);
      }
      rst.close();
      stmt.close();
      conn.close();
    }
    catch (SQLException e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
      e.printStackTrace();
    }
    finally
    {
      GlobalCC.CloseConnections(rst, stmt, conn);
    }
    return taxTypeList;
  }
  
  public List<Account> findRIReceipts()
  {
    DBConnector myConn = new DBConnector();
    String query = "begin LMS_WEB_CURSOR_GRP.findRiReceipts(?,?);end;";
    CallableStatement stmt = null;
    Connection conn = null;
    ResultSet rst = null;
    List<Account> riReceiptsList = new ArrayList();
    try
    {
      conn = myConn.getDatabaseConn();
      stmt = conn.prepareCall(query);
      stmt.registerOutParameter(1, -10);
      
      stmt.setBigDecimal(2, (BigDecimal)this.session.getAttribute("tsCode"));
      stmt.execute();
      rst = (ResultSet)stmt.getObject(1);
      while (rst.next())
      {
        Account riReceipt = new Account();
        riReceipt.setGtopReceiptNo(rst.getString(1));
        riReceipt.setGtopAmount(rst.getBigDecimal(2));
        riReceipt.setGtopReceiptDate(rst.getDate(3));
        riReceipt.setGtopDoneBy(rst.getString(4));
        riReceipt.setGtopDrCr(rst.getString(5));
        riReceiptsList.add(riReceipt);
      }
      rst.close();
      stmt.close();
      conn.close();
    }
    catch (SQLException e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
      e.printStackTrace();
    }
    finally
    {
      GlobalCC.CloseConnections(rst, stmt, conn);
    }
    return riReceiptsList;
  }
  
  public List<Account> findRecoveryPrdSumm()
  {
    DBConnector myConn = new DBConnector();
    String query = "begin LMS_WEB_CURSOR_GRP.getClaimRIRecoveries(?,?,?,?);end;";
    
    CallableStatement cst = null;
    Connection conn = null;
    ResultSet rst = null;
    List<Account> recoveryList = new ArrayList();
    try
    {
      conn = myConn.getDatabaseConn();
      cst = conn.prepareCall(query);
      cst.registerOutParameter(1, -10);
      
      cst.setBigDecimal(2, (BigDecimal)this.session.getAttribute("ta_code"));
      cst.setString(3, (String)this.session.getAttribute("DateFrom"));
      cst.setString(4, (String)this.session.getAttribute("DateTo"));
      cst.execute();
      rst = (ResultSet)cst.getObject(1);
      while (rst.next())
      {
        Account recovery = new Account();
        recovery.setCrctdCode(rst.getBigDecimal(1));
        recovery.setRefNo(rst.getString(2));
        recovery.setMemNo(rst.getString(3));
        recovery.setMemName(rst.getString(4));
        recovery.setClient(rst.getString(5));
        recovery.setAmtPaid(rst.getBigDecimal(6));
        recovery.setAmtPayable(rst.getBigDecimal(7));
        recovery.setCausDesc(rst.getString(8));
        recovery.setCoverDesc(rst.getString(9));
        recovery.setAgnName(rst.getString(10));
        recovery.setRiPeriod(rst.getString(11));
        recovery.setRiSelect(false);
        recoveryList.add(recovery);
      }
      rst.close();
      cst.close();
      conn.close();
    }
    catch (SQLException e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
      e.printStackTrace();
    }
    finally
    {
      GlobalCC.CloseConnections(rst, cst, conn);
    }
    return recoveryList;
  }
  
  public List<Account> findCoinsurancePrdSumm()
  {
    DBConnector myConn = new DBConnector();
    String query = "begin LMS_WEB_CURSOR_GRP.getClaimCoinRecoveries(?,?,?);end;";
    
    CallableStatement cst = null;
    Connection conn = null;
    ResultSet rst = null;
    List<Account> coinRecoveryList = new ArrayList();
    try
    {
      conn = myConn.getDatabaseConn();
      cst = conn.prepareCall(query);
      cst.registerOutParameter(1, -10);
      
      cst.setString(2, (String)this.session.getAttribute("DateFrom"));
      cst.setString(3, (String)this.session.getAttribute("DateTo"));
      cst.execute();
      rst = (ResultSet)cst.getObject(1);
      while (rst.next())
      {
        Account coinsurance = new Account();
        coinsurance.setCcrCode(rst.getBigDecimal(1));
        coinsurance.setCoinRefNo(rst.getString(2));
        coinsurance.setCoinMemNo(rst.getString(3));
        coinsurance.setCoinMemName(rst.getString(4));
        coinsurance.setCoinClient(rst.getString(5));
        coinsurance.setCoinAmtPaid(rst.getBigDecimal(6));
        coinsurance.setCoinAmtPayable(rst.getBigDecimal(7));
        coinsurance.setCoinCausDesc(rst.getString(8));
        coinsurance.setCoinCoverDesc(rst.getString(9));
        coinsurance.setCoinAgnName(rst.getString(10));
        coinsurance.setCoinPeriod(rst.getString(11));
        coinsurance.setCoinSelect(false);
        coinRecoveryList.add(coinsurance);
      }
      rst.close();
      cst.close();
      conn.close();
    }
    catch (SQLException e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
      e.printStackTrace();
    }
    finally
    {
      GlobalCC.CloseConnections(rst, cst, conn);
    }
    return coinRecoveryList;
  }
}
