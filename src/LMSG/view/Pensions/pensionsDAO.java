package LMSG.view.Pensions;

import LMSG.view.Base.GlobalCC;
import LMSG.view.Base.LOVCC;
import LMSG.view.connect.DBConnector;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import oracle.jdbc.OracleTypes;

public class pensionsDAO
  extends LOVCC
{
  HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
  
  public List<pension> FindPensionTransactions()
  {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    List<pension> PensionList = new ArrayList();
    try
    {
      String polQuery = "begin LMS_WEB_CURSOR_GRP.getpensiontrans(?,?);end;";
      cst = conn.prepareCall(polQuery);
      cst.registerOutParameter(1, -10);
      cst.setBigDecimal(2, (BigDecimal)this.session.getAttribute("ProductCode"));
      
      cst.execute();
      ResultSet rst = (ResultSet)cst.getObject(1);
      while (rst.next())
      {
        pension myProd = new pension();
        

        myProd.setPOL_POLICY_NO(rst.getString(1));
        myProd.setCLIENT(rst.getString(2));
        myProd.setPOL_CODE(rst.getBigDecimal(3));
        myProd.setPOL_INCEPTION_UWYR(rst.getString(4));
        myProd.setPOL_STATUS(rst.getString(5));
        myProd.setPOL_PAID_TO_DATE(rst.getDate(6));
        myProd.setPOL_CURRENT_ENDR_CODE(rst.getBigDecimal(7));
        



        PensionList.add(myProd);
      }
      rst.close();
      cst.close();
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return PensionList;
  }
  
  public List<pension> FindPensionBalancesSummary()
  {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    List<pension> PensionList = new ArrayList();
    try
    {
      String polQuery = "begin LMS_WEB_CURSOR_GRP.findpensionbalances(?,?,?);end;";
      cst = conn.prepareCall(polQuery);
      cst.setBigDecimal(1, (BigDecimal)this.session.getAttribute("policyCode"));
      cst.registerOutParameter(2, -10);
      cst.setString(3, null);
      

      cst.execute();
      ResultSet rst = (ResultSet)cst.getObject(2);
      while (rst.next())
      {
        pension myProd = new pension();
        
        myProd.setPNBAL_YEAR(rst.getString(1));
        myProd.setPNBAL_VALUA_DATE(rst.getDate(2));
        myProd.setPNBAL_INTEREST_RATE(rst.getString(3));
        myProd.setSTATUS(rst.getString(4));
        myProd.setVALUE_DATE(rst.getDate(5));
        myProd.setPNBAL_PERIOD(rst.getString(23));
        myProd.setPNBAL_AUTHORISED_BY(rst.getString(24));
        myProd.setPNBAL_AUTHORISED_DATE(rst.getDate(25));
        
        PensionList.add(myProd);
      }
      rst.close();
      cst.close();
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return PensionList;
  }
  
  public List<pension> FindPensionBalancesPeriods()
  {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    List<pension> PensionList = new ArrayList();
    try
    {
      String polQuery = "begin LMS_WEB_CURSOR_GRP.findpensionbalancePeriods(?,?,?,?,?);end;";
      cst = conn.prepareCall(polQuery);
      cst.setBigDecimal(1, (BigDecimal)this.session.getAttribute("policyCode"));
      cst.registerOutParameter(2, -10);
      cst.setString(3, (String)this.session.getAttribute("UWYear"));
      cst.setString(4, null);
      cst.setString(5, null);
      

      cst.execute();
      ResultSet rst = (ResultSet)cst.getObject(2);
      while (rst.next())
      {
        pension myProd = new pension();
        
        myProd.setPNBAL_YEAR(rst.getString(1));
        myProd.setPNBAL_VALUA_DATE(rst.getDate(2));
        myProd.setPNBAL_INTEREST_RATE(rst.getString(3));
        myProd.setSTATUS(rst.getString(4));
        myProd.setVALUE_DATE(rst.getDate(5));
        myProd.setPNBAL_PERIOD(rst.getString(23));
        myProd.setPNBAL_AUTHORISED_BY(rst.getString(24));
        myProd.setPNBAL_AUTHORISED_DATE(rst.getDate(25));
        myProd.setPNBALP_WEF(rst.getDate(26));
        myProd.setPNBALP_WET(rst.getDate(27));
        myProd.setPNBALP_CODE(rst.getBigDecimal(28));
        myProd.setPNBALP_LPNT_CODE(rst.getBigDecimal(29));
        myProd.setLPNT_DESC(rst.getString(30));
        
        PensionList.add(myProd);
      }
      rst.close();
      cst.close();
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return PensionList;
  }
  
  public List<pension> FindPensionBalancesPeriodSummary()
  {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    List<pension> PensionList = new ArrayList();
    try
    {
      String polQuery = "begin LMS_WEB_CURSOR_GRP.findpensionbalancePeriods(?,?,?,?,?);end;";
      cst = conn.prepareCall(polQuery);
      cst.setBigDecimal(1, (BigDecimal)this.session.getAttribute("policyCode"));
      cst.registerOutParameter(2, -10);
      cst.setString(3, (String)this.session.getAttribute("UWYear"));
      cst.setString(4, (String)this.session.getAttribute("WEFDate"));
      cst.setString(5, (String)this.session.getAttribute("WETDate"));
      

      cst.execute();
      ResultSet rst = (ResultSet)cst.getObject(2);
      while (rst.next())
      {
        pension myProd = new pension();
        
        myProd.setPNBAL_YEAR(rst.getString(1));
        myProd.setPNBAL_VALUA_DATE(rst.getDate(2));
        myProd.setPNBAL_INTEREST_RATE(rst.getString(3));
        myProd.setSTATUS(rst.getString(4));
        myProd.setVALUE_DATE(rst.getDate(5));
        myProd.setPNBAL_PERIOD(rst.getString(23));
        myProd.setPNBAL_AUTHORISED_BY(rst.getString(24));
        myProd.setPNBAL_AUTHORISED_DATE(rst.getDate(25));
        myProd.setPNBALP_WEF(rst.getDate(26));
        myProd.setPNBALP_WET(rst.getDate(27));
        myProd.setPNBAL_EMPYR_BAL_BF(rst.getBigDecimal(6));
        myProd.setPNBAL_EMPYR_AMT(rst.getBigDecimal(7));
        myProd.setPNBAL_EMPYR_VOL_AMT(rst.getBigDecimal(8));
        myProd.setPNBAL_EMPYR_WITH_AMT(rst.getBigDecimal(9));
        myProd.setPNBAL_EMPYR_CNTRI_INCOME(rst.getBigDecimal(10));
        myProd.setPNBAL_EMPYR_BAL_INCOME(rst.getBigDecimal(11));
        myProd.setPNBAL_EMPYR_BAL_CF(rst.getBigDecimal(12));
        myProd.setPNBAL_EMPYE_BAL_BF(rst.getBigDecimal(13));
        myProd.setPNBAL_EMPYE_AMT(rst.getBigDecimal(14));
        myProd.setPNBAL_EMPYE_VOL_AMT(rst.getBigDecimal(15));
        myProd.setPNBAL_EMPYE_WITH_AMT(rst.getBigDecimal(16));
        myProd.setPNBAL_EMPYE_CNTRI_INCOME(rst.getBigDecimal(17));
        myProd.setPNBAL_EMPYE_BAL_INCOME(rst.getBigDecimal(18));
        myProd.setPNBAL_EMPYE_BAL_CF(rst.getBigDecimal(19));
        myProd.setPNBAL_TOT_AMT(rst.getBigDecimal(20));
        myProd.setWITHDRAWAL_TOT(rst.getBigDecimal(21));
        myProd.setPNBAL_TOT_BAL_CF(rst.getBigDecimal(22));
        myProd.setPNBALP_CODE(rst.getBigDecimal(28));
        myProd.setPNBALP_ERND_EMPYR_BAL_INC(rst.getBigDecimal(31));
        myProd.setPNBALP_ERND_EMPYE_BAL_INC(rst.getBigDecimal(32));
        myProd.setPNBALP_ERND_EMPYR_CONTRI_INC(rst.getBigDecimal(33));
        myProd.setPNBALP_ERND_EMPYE_CONTRI_INC(rst.getBigDecimal(34));
        
        PensionList.add(myProd);
      }
      rst.close();
      cst.close();
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return PensionList;
  }
  
  public List<pension> FindPensionBalances()
  {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    List<pension> PensionList = new ArrayList();
    try
    {
      String polQuery = "begin LMS_WEB_CURSOR_GRP.findpensionbalances(?,?,?,?);end;";
      cst = conn.prepareCall(polQuery);
      cst.setBigDecimal(1, (BigDecimal)this.session.getAttribute("policyCode"));
      cst.registerOutParameter(2, -10);
      
      cst.setString(3, (String)this.session.getAttribute("UWYear"));
      cst.setString(4, (String)this.session.getAttribute("ValuationPeriod"));
      

      cst.execute();
      int i = 0;
      ResultSet rst = (ResultSet)cst.getObject(2);
      while (rst.next())
      {
        pension myProd = new pension();
        if (i == 0)
        {
          myProd.setPNBAL_EMPYR_BAL_BF(rst.getBigDecimal(6));
          myProd.setPNBAL_EMPYR_AMT(rst.getBigDecimal(7));
          myProd.setPNBAL_EMPYR_VOL_AMT(rst.getBigDecimal(8));
          myProd.setPNBAL_EMPYR_WITH_AMT(rst.getBigDecimal(9));
          myProd.setPNBAL_EMPYR_CNTRI_INCOME(rst.getBigDecimal(10));
          myProd.setPNBAL_EMPYR_BAL_INCOME(rst.getBigDecimal(11));
          myProd.setPNBAL_EMPYR_BAL_CF(rst.getBigDecimal(12));
          myProd.setPNBAL_EMPYE_BAL_BF(rst.getBigDecimal(13));
          myProd.setPNBAL_EMPYE_AMT(rst.getBigDecimal(14));
          myProd.setPNBAL_EMPYE_VOL_AMT(rst.getBigDecimal(15));
          myProd.setPNBAL_EMPYE_WITH_AMT(rst.getBigDecimal(16));
          myProd.setPNBAL_EMPYE_CNTRI_INCOME(rst.getBigDecimal(17));
          myProd.setPNBAL_EMPYE_BAL_INCOME(rst.getBigDecimal(18));
          myProd.setPNBAL_EMPYE_BAL_CF(rst.getBigDecimal(19));
          myProd.setPNBAL_TOT_AMT(rst.getBigDecimal(20));
          myProd.setWITHDRAWAL_TOT(rst.getBigDecimal(21));
          myProd.setPNBAL_TOT_BAL_CF(rst.getBigDecimal(22));
          myProd.setPNBAL_SCHEME_FUND_BF(rst.getBigDecimal(35));
          myProd.setPNBAL_TOTAL_DEDUCTIONS(rst.getBigDecimal(36));
          myProd.setPNBAL_SCHEME_FUND(rst.getBigDecimal(37));
          myProd.setPNBAL_EMPYR_RETIRE_HELD(rst.getBigDecimal(38));
          myProd.setPNBAL_TOTAL_FUND_BAL(rst.getBigDecimal(39));
        }
        i++;
        
        PensionList.add(myProd);
      }
      rst.close();
      cst.close();
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return PensionList;
  }
  
  public List<pension> FindPensionDeductions()
  {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    List<pension> PensionList = new ArrayList();
    try
    {
      String polQuery = "begin LMS_WEB_CURSOR_GRP.findpensiondeductions(?,?);end;";
      cst = conn.prepareCall(polQuery);
      cst.setBigDecimal(1, (BigDecimal)this.session.getAttribute("policyCode"));
      cst.registerOutParameter(2, -10);
      
      cst.execute();
      ResultSet rst = (ResultSet)cst.getObject(2);
      while (rst.next())
      {
        pension myProd = new pension();
        
        myProd.setPDED_TT_SHT_DESC(rst.getString(1));
        myProd.setPDED_DATE(rst.getDate(2));
        myProd.setPDED_YEAR(rst.getString(3));
        myProd.setPDED_MONTH(rst.getString(4));
        myProd.setPDED_TAXABLE_AMT(rst.getString(5));
        myProd.setPDED_RATE(rst.getString(6));
        myProd.setPDED_TAX_AMT(rst.getString(7));
        myProd.setPDED_AUTHORIZED(rst.getString(8));
        myProd.setAUTHORISED(rst.getString(9));
        myProd.setTT_DESC(rst.getString(10));
        myProd.setSEL_PDED_CODE(rst.getBigDecimal(11));
        myProd.setPDED_DEDCT_TAX(rst.getString(12));
        myProd.setPDED_DEDCT_LOST_INT(rst.getString(13));
        myProd.setPDED_EST_ACTUAL(rst.getString(14));
        myProd.setPDED_RT_AMT_TYPE(rst.getString(15));
        myProd.setPDED_NET_AMOUNT(rst.getBigDecimal(16));
        
        PensionList.add(myProd);
      }
      rst.close();
      cst.close();
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return PensionList;
  }
  
  public List<pension> AuthorisedPensionDeductions()
  {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    List<pension> PensionList = new ArrayList();
    try
    {
      String polQuery = "begin LMS_WEB_CURSOR_GRP.authorisedpensiondeductions(?,?);end;";
      cst = conn.prepareCall(polQuery);
      cst.setBigDecimal(1, (BigDecimal)this.session.getAttribute("policyCode"));
      cst.registerOutParameter(2, -10);
      

      cst.execute();
      ResultSet rst = (ResultSet)cst.getObject(2);
      while (rst.next())
      {
        pension myProd = new pension();
        
        myProd.setAUTH_PDED_TT_SHT_DESC(rst.getString(1));
        myProd.setAUTH_PDED_DATE(rst.getDate(2));
        myProd.setAUTH_PDED_YEAR(rst.getString(3));
        myProd.setAUTH_PDED_MONTH(rst.getString(4));
        myProd.setAUTH_PDED_TAXABLE_AMT(rst.getString(5));
        myProd.setAUTH_PDED_RATE(rst.getString(6));
        myProd.setAUTH_PDED_TAX_AMT(rst.getString(7));
        myProd.setAUTH_PDED_AUTHORIZED(rst.getString(8));
        myProd.setAUTH_AUTHORISED(rst.getString(9));
        myProd.setAUTH_TT_DESC(rst.getString(10));
        myProd.setAUTH_SEL_PDED_CODE(rst.getBigDecimal(11));
        myProd.setPDED_DEDCT_TAX(rst.getString(12));
        myProd.setPDED_DEDCT_LOST_INT(rst.getString(13));
        myProd.setPDED_EST_ACTUAL(rst.getString(14));
        myProd.setPDED_RT_AMT_TYPE(rst.getString(15));
        myProd.setPDED_NET_AMOUNT(rst.getBigDecimal(16));
        
        PensionList.add(myProd);
      }
      rst.close();
      cst.close();
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return PensionList;
  }
  
  public List<pension> FindPensionDeposits()
  {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    List<pension> PensionList = new ArrayList();
    try
    {
      String polQuery = "begin LMS_WEB_CURSOR_GRP.findpensiondeposits(?,?);end;";
      cst = conn.prepareCall(polQuery);
      cst.setBigDecimal(1, (BigDecimal)this.session.getAttribute("policyCode"));
      cst.registerOutParameter(2, -10);
      

      cst.execute();
      ResultSet rst = (ResultSet)cst.getObject(2);
      while (rst.next())
      {
        pension myProd = new pension();
        
        myProd.setPNDP_CODE(rst.getBigDecimal(1));
        myProd.setPNDP_DATE(rst.getDate(2));
        myProd.setPNDP_MNTH(rst.getString(3));
        myProd.setPNDP_YEAR(rst.getString(4));
        myProd.setPNDP_AMOUNT(rst.getString(5));
        myProd.setPNDP_WTHDL_RATE(rst.getString(6));
        myProd.setPNDP_EMPYR_AMT(rst.getString(7));
        myProd.setPNDP_EMPYE_AMT(rst.getString(8));
        myProd.setPNDP_EMPYE_VOL_AMT(rst.getString(9));
        myProd.setPNDP_EMPYR_VOL_AMT(rst.getString(10));
        myProd.setPNDP_TOT_AMT(rst.getString(11));
        myProd.setPNDP_REG_AMT(rst.getString(12));
        myProd.setPNDP_NON_REG_AMT(rst.getString(13));
        myProd.setPNDP_STATUS(rst.getString(14));
        myProd.setPNDP_CHQ_RCPT_NO(rst.getString(15));
        myProd.setPNDP_PAYEE(rst.getString(16));
        myProd.setPNDP_GRCT_CODE(rst.getBigDecimal(17));
        myProd.setPNDP_AMT_RATE(rst.getString(18));
        myProd.setPNDP_TAX_AMT(rst.getBigDecimal(19));
        
        PensionList.add(myProd);
      }
      rst.close();
      cst.close();
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return PensionList;
  }
  
  public List<pension> FindMembersPensionDeposits()
  {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    List<pension> PensionList = new ArrayList();
    try
    {
      String polQuery = "begin LMS_WEB_CURSOR_GRP.findmempensiondeposits(?,?,?);end;";
      cst = conn.prepareCall(polQuery);
      cst.setBigDecimal(1, (BigDecimal)this.session.getAttribute("policyCode"));
      cst.setBigDecimal(2, (BigDecimal)this.session.getAttribute("PNDP_CODE"));
      cst.registerOutParameter(3, -10);
      

      cst.execute();
      ResultSet rst = (ResultSet)cst.getObject(3);
      while (rst.next())
      {
        pension myProd = new pension();
        myProd.setPNMDP_CODE(rst.getBigDecimal(1));
        myProd.setPNMDP_POLM_CODE(rst.getBigDecimal(2));
        myProd.setMEM_NO_DISPLAY(rst.getString(3));
        myProd.setMEM_NAME(rst.getString(4));
        myProd.setPNMDP_EMPYR_AMT(rst.getString(5));
        myProd.setPNMDP_EMPYE_AMT(rst.getString(6));
        myProd.setPNMDP_EMPYE_VOL_AMT(rst.getString(7));
        myProd.setPNMDP_EMPYR_VOL_AMT(rst.getString(8));
        myProd.setPNMDP_TOT_AMT(rst.getString(9));
        myProd.setPNMDP_REG_AMT(rst.getString(10));
        myProd.setPNMDP_NON_REG_AMT(rst.getString(11));
        myProd.setPNMDP_EMPYR_REG_AMT(rst.getBigDecimal(12));
        myProd.setPNMDP_EMPYE_REG_AMT(rst.getBigDecimal(13));
        myProd.setPNMDP_EMPYR_NON_REG_AMT(rst.getBigDecimal(14));
        myProd.setPNMDP_EMPYE_NON_REG_AMT(rst.getBigDecimal(15));
        


        PensionList.add(myProd);
      }
      rst.close();
      cst.close();
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return PensionList;
  }
  
  public List<pension> FindPensionDepositInterest()
  {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    List<pension> PensionList = new ArrayList();
    try
    {
      String polQuery = "begin LMS_WEB_CURSOR_GRP.find_valua_intr_distr(?,?,?,?);end;";
      cst = conn.prepareCall(polQuery);
      cst.registerOutParameter(1, -10);
      cst.setBigDecimal(2, (BigDecimal)this.session.getAttribute("policyCode"));
      cst.setString(3, (String)this.session.getAttribute("UWYear"));
      cst.setString(4, (String)this.session.getAttribute("ValuationPeriod"));
      


      cst.execute();
      ResultSet rst = (ResultSet)cst.getObject(1);
      while (rst.next())
      {
        pension myProd = new pension();
        
        myProd.setPNDPI_CODE(rst.getBigDecimal(1));
        myProd.setPNDPI_APP_INTR(rst.getBigDecimal(2));
        myProd.setPNDPI_CF_INTR_AMT(rst.getBigDecimal(3));
        myProd.setPNDPI_PRINCIPAL(rst.getBigDecimal(4));
        myProd.setPNDPI_TOT_AMT(rst.getBigDecimal(5));
        myProd.setPNDPI_WEF(rst.getDate(6));
        myProd.setPNDPI_WET(rst.getDate(7));
        myProd.setPNDP_CHQ_RCPT_NO(rst.getString(8));
        myProd.setPNDPI_EMPYR_AMT(rst.getBigDecimal(9));
        myProd.setPNDPI_EMPYE_AMT(rst.getBigDecimal(10));
        
        PensionList.add(myProd);
      }
      rst.close();
      cst.close();
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return PensionList;
  }
  
  public List<pension> FindPensionDepositsByReceipt()
  {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    List<pension> PensionList = new ArrayList();
    try
    {
      String polQuery = "begin LMS_WEB_CURSOR_GRP.findpensiondepositsforcpt(?,?,?);end;";
      cst = conn.prepareCall(polQuery);
      cst.setBigDecimal(1, (BigDecimal)this.session.getAttribute("policyCode"));
      cst.setBigDecimal(2, (BigDecimal)this.session.getAttribute("GrctCode"));
      cst.registerOutParameter(3, -10);
      

      cst.execute();
      ResultSet rst = (ResultSet)cst.getObject(3);
      int i = 0;
      while (rst.next())
      {
        pension myProd = new pension();
        
        myProd.setPNDP_CODE(rst.getBigDecimal(1));
        if (i == 0)
        {
          this.session.setAttribute("PNDP_CODE", rst.getBigDecimal(1));
          i++;
        }
        myProd.setPNDP_DATE(rst.getDate(2));
        myProd.setPNDP_MNTH(rst.getString(3));
        myProd.setPNDP_YEAR(rst.getString(4));
        myProd.setPNDP_AMOUNT(rst.getString(5));
        myProd.setPNDP_WTHDL_RATE(rst.getString(6));
        myProd.setPNDP_EMPYR_AMT(rst.getString(7));
        myProd.setPNDP_EMPYE_AMT(rst.getString(8));
        myProd.setPNDP_EMPYE_VOL_AMT(rst.getString(9));
        myProd.setPNDP_EMPYR_VOL_AMT(rst.getString(10));
        myProd.setPNDP_TOT_AMT(rst.getString(11));
        myProd.setPNDP_REG_AMT(rst.getString(12));
        myProd.setPNDP_NON_REG_AMT(rst.getString(13));
        myProd.setPNDP_STATUS(rst.getString(14));
        myProd.setPNDP_CHQ_RCPT_NO(rst.getString(15));
        
        PensionList.add(myProd);
      }
      rst.close();
      cst.close();
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return PensionList;
  }
  
  public List<pension> distributeToMembers()
  {
    List<pension> PensionList = new ArrayList();
    Connection conn = null;
    try
    {
      String populateTaxes = "BEGIN LMS_WEB_CURSOR_GRP.distributePensWith(?,?,?);END;";
      
      conn = new DBConnector().getDatabaseConn();
      
      CallableStatement cstmt = conn.prepareCall(populateTaxes);
      cstmt.setBigDecimal(1, (BigDecimal)this.session.getAttribute("PNDP_CODE"));
      cstmt.setBigDecimal(2, (BigDecimal)this.session.getAttribute("policyCode"));
      cstmt.registerOutParameter(3, -10);
      cstmt.execute();
      ResultSet rs = (ResultSet)cstmt.getObject(3);
      while (rs.next())
      {
        pension myProd = new pension();
        myProd.setMemberNumber(rs.getString(1));
        myProd.setMEM_NAME(rs.getString(2));
        myProd.setPaidErAmount(rs.getBigDecimal(5));
        myProd.setPaidEeAmount(rs.getBigDecimal(6));
        myProd.setPaidErVolAmt(rs.getBigDecimal(7));
        myProd.setPaidEeVolAmt(rs.getBigDecimal(8));
        myProd.setAllocatedAmount(rs.getBigDecimal(9));
        myProd.setEarnings(rs.getBigDecimal(11));
        myProd.setPmpnsEmpyrContr(rs.getBigDecimal(12));
        myProd.setPmpnsEmpyeContr(rs.getBigDecimal(13));
        myProd.setPmpns_code(rs.getBigDecimal(14));
        myProd.setEmyr_reg_amount(rs.getBigDecimal(16));
        myProd.setEmye_reg_amount(rs.getBigDecimal(17));
        myProd.setEmyr_unreg_amount(rs.getBigDecimal(18));
        myProd.setEmye_unreg_amount(rs.getBigDecimal(19));
        PensionList.add(myProd);
      }
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return PensionList;
  }
  
  public List<pension> valuation_refunds()
  {
    List<pension> RefundList = new ArrayList();
    Connection conn = null;
    try
    {
      String revaluationRefund = "BEGIN LMS_WEB_CURSOR_GRP.PolRevaluationVouchers(?,?);END;";
      
      conn = new DBConnector().getDatabaseConn();
      
      CallableStatement cstmt = conn.prepareCall(revaluationRefund);
      cstmt.registerOutParameter(1, -10);
      cstmt.setBigDecimal(2, (BigDecimal)this.session.getAttribute("policyCode"));
      cstmt.execute();
      ResultSet rs = (ResultSet)cstmt.getObject(1);
      while (rs.next())
      {
        pension refunds = new pension();
        refunds.setPPV_VOUCHER_NO(rs.getBigDecimal(1));
        refunds.setPPV_DATE(rs.getDate(2));
        refunds.setPPV_AMOUNT(rs.getBigDecimal(3));
        refunds.setPPV_PAYEE(rs.getString(4));
        refunds.setPPV_RAISE_BY(rs.getString(5));
        refunds.setPPV_STATUS(rs.getString(6));
        refunds.setPPV_SOURCE(rs.getString(7));
        refunds.setPPV_CHEQUE_NO(rs.getString(8));
        refunds.setPPV_CHEQUE_DATE(rs.getDate(9));
        RefundList.add(refunds);
      }
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
      e.printStackTrace();
    }
    return RefundList;
  }
  public List<pension> findPensionMembers()
  {
    List<pension> memList = new ArrayList<pension>();
    Connection conn = null;
    try
    {
      String revaluationRefund = "BEGIN LMS_API_PKG.getpensionmembers(?,?,?,?,?,?,?);END;";
      
      conn = new DBConnector().getDatabaseConn();
      
      CallableStatement cstmt = conn.prepareCall(revaluationRefund);
      cstmt.registerOutParameter(1, OracleTypes.CURSOR);
      cstmt.setBigDecimal(2, (BigDecimal)this.session.getAttribute("policyCode"));
      cstmt.setString(3, (String)this.session.getAttribute("UWYear"));
      cstmt.setString(4,(String)session.getAttribute("memNameSearch"));
      cstmt.setString(5, (String)session.getAttribute("memNoSearch"));
      cstmt.setString(6, (String)session.getAttribute("memTelePhoneSearch"));
      cstmt.setString(7, (String)session.getAttribute("memIdNoSearch"));
      
      cstmt.execute();
      ResultSet rs = (ResultSet)cstmt.getObject(1);
      while (rs.next())
      {
        pension pension = new pension();
        pension.setPolmCode(rs.getBigDecimal(1));  
        pension.setMemNo(rs.getString(2));
        pension.setMemName(rs.getString(3));
          
        memList.add(pension);
      }
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
      e.printStackTrace();
    }
    return memList;
  }
  public List<pension> findPensionMembersDetails()
  {
    List<pension> memList = new ArrayList<pension>();
    Connection conn = null;
    try
    {
      String revaluationRefund = "BEGIN LMS_API_PKG.findpensionmembers(?,?);END;";
      
      conn = new DBConnector().getDatabaseConn();
      
      CallableStatement cstmt = conn.prepareCall(revaluationRefund);
      cstmt.registerOutParameter(1, OracleTypes.CURSOR);
      cstmt.setBigDecimal(2, (BigDecimal)this.session.getAttribute("PolmCode"));
      cstmt.execute();
      ResultSet rs = (ResultSet)cstmt.getObject(1);
      while (rs.next())
      {
        pension pension = new pension();
        pension.setMemNo(rs.getString(1));
        pension.setMemName(rs.getString(2));
        pension.setMemSex(rs.getString(3));  
        pension.setMemDob(rs.getDate(4));  
        pension.setMemIdNo(rs.getString(5));  
        pension.setMemPin(rs.getString(6));
        pension.setMemTelephone(rs.getString(7));
        pension.setMemEmail(rs.getString(8));  
        memList.add(pension);
      }
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
      e.printStackTrace();
    }
    return memList;
  }
  public List<pension> findPensionMemberStatement()
  {
    List<pension> memStatementList = new ArrayList<pension>();
    Connection conn = null;
    try
    {
      String revaluationRefund = "BEGIN LMS_API_PKG.findmembalancetrans(?,?,?);END;";
      
      conn = new DBConnector().getDatabaseConn();
      
      CallableStatement cstmt = conn.prepareCall(revaluationRefund);
      cstmt.registerOutParameter(1, OracleTypes.CURSOR);
      cstmt.setBigDecimal(2, (BigDecimal)this.session.getAttribute("PolmCode"));
      cstmt.setString(3,(String)session.getAttribute("UWYear"));
      cstmt.execute();
      ResultSet rs = (ResultSet)cstmt.getObject(1);
      while (rs.next())
      {
        pension pension = new pension();
        pension.setTransDate(rs.getDate(1));
        pension.setTransType(rs.getString(2));
        pension.setReceiptNo(rs.getString(3));  
        pension.setReferenceNo(rs.getString(4)); 
        pension.setEmpyeBalBf(rs.getBigDecimal(5));  
        pension.setEmpyeRegBalBf(rs.getBigDecimal(6));  
        pension.setEmpyeNonRegBalBf(rs.getBigDecimal(7));
        pension.setEmpyrBalBf(rs.getBigDecimal(8));
        pension.setEmpyrRegBalBf(rs.getBigDecimal(9));  
        pension.setEmpyrNonRegBalBf(rs.getBigDecimal(10));  
        pension.setTotal(rs.getBigDecimal(11));  
        memStatementList.add(pension);
      }
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
      e.printStackTrace();
    }
    return memStatementList;
  }
  public List<pension> findPensionMemberWithdrawal()
  {
    List<pension> memWithdrawalList = new ArrayList<pension>();
    Connection conn = null;
    try
    {
      String revaluationRefund = "BEGIN LMS_API_PKG.findmemwithdrawals(?,?);END;";
      
      conn = new DBConnector().getDatabaseConn();
      
      CallableStatement cstmt = conn.prepareCall(revaluationRefund);
      cstmt.registerOutParameter(1, OracleTypes.CURSOR);
      cstmt.setBigDecimal(2, (BigDecimal)this.session.getAttribute("PolmCode"));
      cstmt.execute();
      ResultSet rs = (ResultSet)cstmt.getObject(1);
      while (rs.next())
      {
        pension pension = new pension();
        pension.setTransDate(rs.getDate(1));
        pension.setTransType(rs.getString(2));
        pension.setReceiptNo(rs.getString(3));  
        pension.setReferenceNo(rs.getString(4)); 
        pension.setEmpyeBalBf(rs.getBigDecimal(5));  
        pension.setEmpyeRegBalBf(rs.getBigDecimal(6));  
        pension.setEmpyeNonRegBalBf(rs.getBigDecimal(7));
        pension.setEmpyrBalBf(rs.getBigDecimal(8));
        pension.setEmpyrRegBalBf(rs.getBigDecimal(9));  
        pension.setEmpyrNonRegBalBf(rs.getBigDecimal(10));  
        pension.setTotal(rs.getBigDecimal(11));  
        memWithdrawalList.add(pension);
      }
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
      e.printStackTrace();
    }
    return memWithdrawalList;
  }
}
