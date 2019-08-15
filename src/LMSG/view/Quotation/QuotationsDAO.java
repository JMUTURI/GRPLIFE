package LMSG.view.Quotation;

import LMSG.view.Base.GlobalCC;
import LMSG.view.Base.Rendering;
import LMSG.view.connect.DBConnector;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import oracle.jdbc.OracleTypes;

public class QuotationsDAO
{
  private String QuoteCategoryShtDesc;
  private BigDecimal CoverTypeCode;
  private BigDecimal lcaCode;
  HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);

  public List<Quotations> findQuotation()
  {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    List myQuotations = new ArrayList();
    try
    {
      String quotQuery = "begin LMS_WEB_CURSOR_GRP.get_quotations(?,?,?,?);end;";
      cst = conn.prepareCall(quotQuery);
      cst.registerOutParameter(1,OracleTypes.CURSOR);

      cst.setString(2, (String)this.session.getAttribute("transType"));
      cst.setBigDecimal(3, (BigDecimal)this.session.getAttribute("ProductCode"));
      cst.setBigDecimal(4, (BigDecimal)this.session.getAttribute("QuoteCode"));

      cst.execute();
      ResultSet rs = (ResultSet)cst.getObject(1);

      while (rs.next())
      {
        Quotations myQuot = new Quotations();
        myQuot.setClient(rs.getString(1));
        myQuot.setQuoCode(rs.getBigDecimal(2));
        myQuot.setQuoNo(rs.getString(3));
        myQuot.setQuoRevNo(rs.getBigDecimal(4));
        myQuot.setAgnName(rs.getString(5));
        myQuot.setAgnName(rs.getString(6));
        //myQuot.setQuoType(rs.getString(17));--conflicting chnged on 1 june 2015
        myQuot.setQUO_SAVINGS_RIDER(rs.getString(19));
        myQuot.setStatus(rs.getString(17));
        myQuot.setOccupation(rs.getString(46));
        myQuot.setHazard(rs.getString(47));
        myQuot.setProd_sht_desc(rs.getString(58));
        myQuot.setProd_display(rs.getString(59));
        myQuot.setBranch(rs.getString(60));
        myQuot.setUWYear(rs.getString(61));
        myQuot.setEffectDate(rs.getDate(13));
        myQuot.setFreqofPay(rs.getString(21));
        myQuot.setPROP_CODE(rs.getBigDecimal(63));
        myQuot.setAGN_CODE(rs.getBigDecimal(64));
        myQuot.setFreq_of_payment_disp(rs.getString(66));
        myQuot.setQUO_PAY_METHOD(rs.getString(72));
        myQuot.setQUO_COVER_TO_DATE(rs.getDate(22));
        myQuot.setQUO_UMBRELLA(rs.getString(86));
       
        myQuotations.add(myQuot);
      }
      rs.close();
      cst.close();
      conn.close();
    }
    catch (Exception e)
  
    {
      e.printStackTrace();
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return myQuotations;
  }

  public List<Quotations> findQuoteCoverTypes()
  {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    List myQuotations = new ArrayList();
    try
    {
      String coverTypesQuery = "begin LMS_WEB_CURSOR_GRP.quotationCoverTypes(?,?,?);end;";
      cst = conn.prepareCall(coverTypesQuery);

      cst.registerOutParameter(1,OracleTypes.CURSOR);
      cst.setBigDecimal(2, (BigDecimal)this.session.getAttribute("QuoteCode"));
      cst.setBigDecimal(3, (BigDecimal)this.session.getAttribute("qcvtCode"));

      cst.execute();

      this.session.setAttribute("coversAvail", "N");
      String OriginalPlan = null;
      int i = 1;
      ResultSet rs = (ResultSet)cst.getObject(1);
      while (rs.next())
      {
        Quotations coverType = new Quotations();

        coverType.setQuocvtShtDesc(rs.getString(1));
        coverType.setQuoQcvtSa(rs.getBigDecimal(2));
        coverType.setQuoButChargePrem(rs.getBigDecimal(3));
        coverType.setQuoButChargePrem2(rs.getString(4));
        coverType.setQCVT_PREMIUM(rs.getBigDecimal("QCVT_PREMIUM"));
        coverType.setQCVT_LOAD_DISC(rs.getString("QCVT_LOAD_DISC"));
        coverType.setQCVT_DISC_LOAD_DIV_FACT(Integer.valueOf(rs.getInt(15)));
        coverType.setQCVT_CODE(rs.getBigDecimal(16));
        coverType.setCover_display(rs.getString(17));
        coverType.setQuoMembers(Integer.valueOf(rs.getInt(5)));
        coverType.setDiscLoadRate(rs.getBigDecimal(7));
        coverType.setQuoQcvtRate(Double.valueOf(rs.getDouble(8)));
        coverType.setQuoAvganb(Double.valueOf(rs.getDouble(9)));
        coverType.setQuoQCVTwetDate(rs.getDate(10));
        coverType.setQuoQcvtAvgprd(Integer.valueOf(rs.getInt(11)));
        coverType.setQuoSaPerMember(Double.valueOf(rs.getDouble(12)));
        coverType.setQuoUnitRate(Double.valueOf(rs.getDouble(14)));
        coverType.setQCVT_CVT_CODE(rs.getBigDecimal(18));
        coverType.setQuoUseUnitRate(rs.getString(13));
        coverType.setQCVT_DTY_CODE(rs.getBigDecimal(19));
        coverType.setQCVT_DTY_DESCRIPTION(rs.getString(20));
        coverType.setQCVT_AVG_EARN_PER_MEM(rs.getString(21));
        coverType.setQCVT_STAFF_DESC(rs.getString(22));
        coverType.setQCVT_MULT_EARNINGS_PRD(rs.getString(23));
        coverType.setQCVT_FCL_AMT(rs.getString(24));
        coverType.setQCVT_OVERRIDE_FCL_AMT(rs.getString(25));
        coverType.setQCVT_MAIN_SA_PERC(rs.getBigDecimal(27));
        coverType.setQCVT_MAIN_COVER(rs.getString(28));
        coverType.setMAIN_COVER_DESC(rs.getString(29));
        if (rs.getString(26) != null)
        {
          if (rs.getString(26).equalsIgnoreCase("M")) {
            this.session.setAttribute("coversAvail", "Y");
          }
        }

        coverType.setQCVT_LOANAMT_PER_MEM(rs.getBigDecimal(30));
        coverType.setQCVT_LOAN_RPYMT_PRD(rs.getBigDecimal(31));
        coverType.setQCVT_LOANINT_PER_MEM(rs.getBigDecimal(32));
        coverType.setQCVT_SAVINGS_PER_MEM(rs.getBigDecimal(33));
        coverType.setQCVT_DISC(rs.getString(34));
        coverType.setQCVT_DISC_RATE(rs.getBigDecimal(35));
        coverType.setQCVT_DISC_DIV_FACT(rs.getBigDecimal(36));
        coverType.setQcvt_pmas_code(rs.getBigDecimal(37));
        coverType.setQcvt_pmas_sht_desc(rs.getString(38));
        coverType.setQcvt_rate_div_fact(rs.getBigDecimal(39));
        coverType.setQcvt_use_cvr_rate(rs.getString(40));
        if (rs.getString(40) == null)
          coverType.setCoverRateDesc(null);
        else if (rs.getString(40).equalsIgnoreCase("M"))
          coverType.setCoverRateDesc("Use Quote Mask");
        else if (rs.getString(40).equalsIgnoreCase("S"))
          coverType.setCoverRateDesc("Select Specific Mask");
        else if (rs.getString(40).equalsIgnoreCase("C")) {
          coverType.setCoverRateDesc("Input Rate");
        }
        coverType.setQCVT_TOT_MEMBER_EARNINGS(rs.getBigDecimal(41));
        coverType.setQCVT_TOT_ORIG_LOAN_AMT(rs.getBigDecimal(42));
        coverType.setQCVT_AV_CVR_PER_MEMBER(rs.getBigDecimal(43));
        coverType.setQcvt_load_age_fact(rs.getBigDecimal(44));
        coverType.setQCVT_LIMIT(rs.getBigDecimal(45));
        coverType.setQCVT_AGG_PLAN(rs.getString(46));
        
        if(rs.getString(28)==null){
            //Proceed.
        }else if(rs.getString(28).equalsIgnoreCase("M")){
            if(OriginalPlan == null){
                OriginalPlan = rs.getString(46);
                session.setAttribute("DefaultAggrPlan", OriginalPlan);
            }else{
                String CoverPlan = (String)rs.getString(46);
                if(CoverPlan==null){
                    
                }else if(!CoverPlan.equalsIgnoreCase(OriginalPlan)){
                    session.setAttribute("DefaultAggrPlan", null);
                }
            }
        }
        coverType.setQcvtPctInbuilt(rs.getString(47)); 
        coverType.setQcvtAccelerator(rs.getString(48));
          i++;

        myQuotations.add(coverType);
      }
      rs.close();
      cst.close();
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return myQuotations;
  }
  
  public List<Quotations> findQuoteForFcl()
  {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    List myQuotations = new ArrayList();
    try
    {
      String coverTypesQuery = "begin LMS_WEB_CURSOR_GRP.quotationcovertypesforfcl(?,?);end;";
      cst = conn.prepareCall(coverTypesQuery);

      cst.registerOutParameter(1,OracleTypes.CURSOR);
      cst.setBigDecimal(2, (BigDecimal)this.session.getAttribute("QuoteCode"));
      cst.execute();
      this.session.setAttribute("coversAvail", "N");
      String OriginalPlan = null;
      int i = 1;
      ResultSet rs = (ResultSet)cst.getObject(1);
      while (rs.next())
      {
        Quotations coverType = new Quotations();
        coverType.setQCVT_CODE(rs.getBigDecimal(16));
        coverType.setQCVT_CVT_CODE(rs.getBigDecimal(18));
        coverType.setQCVT_STAFF_DESC(rs.getString(22));
        coverType.setQCVT_FCL_AMT(rs.getString(24));
        coverType.setQCVT_OVERRIDE_FCL_AMT(rs.getString(25));
        coverType.setQCVT_LIMIT(rs.getBigDecimal(45));
        coverType.setQCVT_AGG_PLAN(rs.getString(46));
          i++;
        myQuotations.add(coverType);
      }
      rs.close();
      cst.close();
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return myQuotations;
  }
  
  public List<Quotations> findQuoteForFclNew()
  {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    List myQuotations = new ArrayList();
    try
    {
      String coverTypesQuery = "begin LMS_WEB_CURSOR_GRP.quotationcovertypesforfcl(?,?);end;";
      cst = conn.prepareCall(coverTypesQuery);

      cst.registerOutParameter(1,OracleTypes.CURSOR);
      cst.setBigDecimal(2, (BigDecimal)this.session.getAttribute("QuoteCode"));
      cst.execute();
      this.session.setAttribute("coversAvail", "N");
      String OriginalPlan = null;
      int i = 1;
      ResultSet rs = (ResultSet)cst.getObject(1);
      while (rs.next())
      {
        Quotations coverType = new Quotations();
        coverType.setQCVT_CODEFCL(rs.getBigDecimal(16));
        coverType.setQCVT_CVT_CODEFCL(rs.getBigDecimal(18));
        coverType.setQCVT_STAFF_DESCFCL(rs.getString(22));
        coverType.setQCVT_FCL_AMTFCL(rs.getString(24));
        coverType.setQCVT_OVERRIDE_FCL_AMTFCL(rs.getString(25));
        coverType.setQCVT_LIMITFCL(rs.getBigDecimal(45));
        coverType.setQCVT_AGG_PLANFCL(rs.getString(46));
          i++;
        myQuotations.add(coverType);
      }
      rs.close();
      cst.close();
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return myQuotations;
  }
  
  public List<Quotations> findQuotationTaxes()
  {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    List myQuotations = new ArrayList();
    try
    {
      String quotQuery = "begin LMS_WEB_CURSOR_GRP.quotationtaxes(?,?,?,?);end;";
      cst = conn.prepareCall(quotQuery);
      cst.registerOutParameter(1,OracleTypes.CURSOR);

      cst.setBigDecimal(2, (BigDecimal)this.session.getAttribute("QuoteCode"));
      cst.setString(3, null);
      cst.setString(4, null);

      System.out.println("Taxes Code: " + (BigDecimal)this.session.getAttribute("QuoteCode"));

      cst.execute();
      ResultSet rs = (ResultSet)cst.getObject(1);
      while (rs.next())
      {
        Quotations myQuot = new Quotations();
        System.out.println("Enter Taxes: ");
        myQuot.setQtax_code(rs.getBigDecimal(1));
        myQuot.setQtax_rate(rs.getString(2));
        myQuot.setQtax_tax_amt(rs.getBigDecimal(3));
        myQuot.setTt_desc(rs.getString(4));
        myQuot.setQtax_rate_desc(rs.getString(4));
        myQuot.setQTAX_RATE_TYPE(rs.getString(5));
        myQuot.setPtx_appl_level(rs.getString(6));        
        myQuot.setCvt_desc(rs.getString(7));     
        myQuot.setTax_plan(rs.getString(8));
        myQuot.setTaxPremium(rs.getBigDecimal(9));
        myQuot.setTaxSa(rs.getBigDecimal(10));
        myQuot.setTotaPremium(rs.getBigDecimal(11));
        myQuotations.add(myQuot);
      }

      rs.close();
      cst.close();
      conn.close();
    }
    catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return myQuotations;
  }

  public List<Quotations> findQuoteCategories()
  {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    List myQuotations = new ArrayList();
    try
    {
      String QuotCategoryQuery = "begin LMS_WEB_CURSOR_GRP.quotationCategories(?,?);END;";
      cst = conn.prepareCall(QuotCategoryQuery);
      cst.registerOutParameter(1,OracleTypes.CURSOR);
      cst.setBigDecimal(2, (BigDecimal)this.session.getAttribute("QuoteCode"));

      cst.execute();
      ResultSet rs = (ResultSet)cst.getObject(1);
      String Value = (String)this.session.getAttribute("booleanSelect");
      while (rs.next())
      {
        Quotations quotCat = new Quotations();

        quotCat.setLcaCode(rs.getBigDecimal(1));
        quotCat.setCatDesc(rs.getString(2));
        quotCat.setCatShtDesc(rs.getString(3));
        quotCat.setCatPeriod(rs.getString(4));
        quotCat.setSCH_CODE(rs.getBigDecimal(5));
        quotCat.setCTL_FEE_AMOUNT(rs.getBigDecimal(8));
        quotCat.setCTL_AV_STUDENTS(rs.getBigDecimal(9));
        quotCat.setLca_pmas_code(rs.getBigDecimal(10));
        quotCat.setPmas_sht_desc(rs.getString(11));
        if (Value == null)
          quotCat.setSelected(false);
        else if (Value.equalsIgnoreCase("T"))
          quotCat.setSelected(true);
        else {
          quotCat.setSelected(false);
        }

        myQuotations.add(quotCat);
      }

      rs.close();
      cst.close();
      conn.close();
    }
    catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return myQuotations;
  }

  public List<Quotations> findQuoteAgencies()
  {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    List myQuotations = new ArrayList();
    try
    {
      String QuotCategoryQuery = "begin LMS_WEB_CURSOR_GRP.findQuotationAgencies(?,?);END;";
      cst = conn.prepareCall(QuotCategoryQuery);
      cst.setBigDecimal(1, (BigDecimal)this.session.getAttribute("QuoteCode"));
      cst.registerOutParameter(2,OracleTypes.CURSOR);

      cst.execute();
      ResultSet rs = (ResultSet)cst.getObject(2);
      while (rs.next())
      {
        Quotations quotCat = new Quotations();
          
        quotCat.setQua_code(rs.getBigDecimal(1));
        quotCat.setQua_agn_code(rs.getBigDecimal(2));
        quotCat.setQua_agn_name(rs.getString(3));
        quotCat.setQua_agn_asgn(rs.getString(4));
        quotCat.setQua_authorized(rs.getString(5));
        quotCat.setQua_agn_leader_follower(rs.getString(6));
        quotCat.setQua_agn_share(Integer.valueOf(rs.getInt(7)));       
        myQuotations.add(quotCat);       
      }
        System.out.println("Agents"+session.getAttribute("QuotJointAgen"));
      rs.close();
      cst.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return myQuotations;
  }

  public List<Quotations> findQuoteDependantLimits()
  {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    List myQuotations = new ArrayList();
    try
    {
      String dpdLimitQuery = "BEGIN LMS_WEB_CURSOR_GRP.getQuotDpdLimits(?,?,?,?);END;";
      cst = conn.prepareCall(dpdLimitQuery);
      cst.registerOutParameter(1,OracleTypes.CURSOR);

      cst.setBigDecimal(2, (BigDecimal)this.session.getAttribute("QuoteCode"));
      cst.setString(3, null);
      cst.setBigDecimal(4, (BigDecimal)this.session.getAttribute("lcaCode"));

      cst.execute();
      ResultSet rs = (ResultSet)cst.getObject(1);
      while (rs.next())
      {
        Quotations quotLimits = new Quotations();
        quotLimits.setQDL_CODE(rs.getBigDecimal(1));
        quotLimits.setDTY_DESCRIPTION(rs.getString(3));
        quotLimits.setQDL_MAX_TYPE_ALLOWED(rs.getBigDecimal(4));
        quotLimits.setQDL_LIMIT_AMT(rs.getBigDecimal(5));
        quotLimits.setCoverDescription(rs.getString(6));
        quotLimits.setLCA_CATEG_DESC(rs.getString(7));
        quotLimits.setQDL_DTY_CODE(rs.getBigDecimal(8));
        quotLimits.setQDL_QCVT_CODE(rs.getBigDecimal(9));
        quotLimits.setQDL_MIN_AMT(rs.getBigDecimal(10));
        quotLimits.setQCVT_CVT_CODE(rs.getBigDecimal(11));
        myQuotations.add(quotLimits);
      }

      rs.close();
      cst.close();
      conn.close();
    }
    catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return myQuotations;
  }

  public List<Quotations> findQuoteProvisions()
  {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    List myQuotations = new ArrayList();
    try
    {
      String provQuery = "BEGIN LMS_WEB_CURSOR_GRP.getProdProvisions(?,?);END;";
      cst = conn.prepareCall(provQuery);
      cst.registerOutParameter(1,OracleTypes.CURSOR);

      cst.setBigDecimal(2, (BigDecimal)this.session.getAttribute("QuoteCode"));

      cst.execute();
      ResultSet rs = (ResultSet)cst.getObject(1);
      while (rs.next())
      {
        Quotations prov = new Quotations();
        prov.setQpprCode(rs.getBigDecimal(1));
        prov.setQuotProvshtDesc(rs.getString(2));
        prov.setQuotProvDesc(rs.getString(3));
        prov.setQuotProvEditable(rs.getString(4));

        myQuotations.add(prov);
      }

      rs.close();
      cst.close();
      conn.close();
    }
    catch (Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return myQuotations;
  }

  public List<Quotations> findQuoteCoinsurers()
  {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    List myQuotations = new ArrayList();
    try
    {
      String provQuery = "BEGIN LMS_WEB_CURSOR_GRP.findquotecoinsurers(?,?);END;";
      cst = conn.prepareCall(provQuery);
      cst.registerOutParameter(1,OracleTypes.CURSOR);

      cst.setBigDecimal(2, (BigDecimal)this.session.getAttribute("QuoteCode"));

      cst.execute();
      int interAmt = 0;
      int Amt = 0;
      ResultSet rs = (ResultSet)cst.getObject(1);
      while (rs.next())
      {
        Quotations prov = new Quotations();

        prov.setQCOIN_CODE(rs.getBigDecimal(1));
        prov.setQCOIN_QUO_CODE(rs.getBigDecimal(2));
        prov.setQCOIN_AGN_CODE(rs.getBigDecimal(3));
        prov.setCoinsurer_display(rs.getString(4));
        prov.setQCOIN_SHARE_PCT(rs.getString(5));
        interAmt = rs.getInt(5);
        Amt = interAmt + Amt;
        prov.setQCOIN_ADMIN_FEE(rs.getString(6));
        prov.setQCOIN_LEAD_FOLLOW(rs.getString(7));
        prov.setQCOIN_COIN_LEADER_SHARE(rs.getString(8));
        prov.setQCOIN_PREMIUM(rs.getBigDecimal(9));
        prov.setQCOIN_SRVCE_FEE(rs.getBigDecimal(10));
        prov.setQCOIN_FOLLOWER_LEADER(rs.getString(11));
        prov.setFOLLOWER_LEADER(rs.getString(12));

        myQuotations.add(prov);
      }

      this.session.setAttribute("CoinsurerTotal", Integer.valueOf(Amt));
      rs.close();
      cst.close();
      conn.close();
    }
    catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return myQuotations;
  }

  public List<Quotations> findQuoteMembers()
  {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    String membersQuery = null;
    List myQuotations = new ArrayList();
    try
    {
        //LMS_WEB_CURSOR_GRP.quotationMembers was ammended to show joint members (MICK)
        //this ammendement is to cater for cover details screen to not show joint members
        Rendering render = new Rendering();
            
      if (String.valueOf(session.getAttribute("covdetails")).equalsIgnoreCase("Y") && render.isMickVisible()){
         membersQuery = "BEGIN LMS_WEB_CURSOR_GRP.quotationMembers2(?,?,?,?,?,?);end;";
      } else {
          membersQuery = "BEGIN LMS_WEB_CURSOR_GRP.quotationMembers(?,?,?,?,?,?);end;";
      }
        
      cst = conn.prepareCall(membersQuery);
      cst.registerOutParameter(1,OracleTypes.CURSOR);

      cst.setBigDecimal(2, (BigDecimal)this.session.getAttribute("QuoteCode"));
      cst.setString(3, null);
      cst.setString(4, (String)this.session.getAttribute("srchMemNo"));
      cst.setString(5, (String)this.session.getAttribute("srchMemName"));
      cst.setInt(6, GlobalCC.RowsLimit);

      cst.execute();
      ResultSet rs = (ResultSet)cst.getObject(1);
      int i = 0;
      session.setAttribute("limitExceeded", "N");
      while (rs.next())
      {
        Quotations member = new Quotations();
          
        member.setQuoMemNo(rs.getString(1));
        member.setQuoMemName(rs.getString(2));
        member.setQuoDepMemType(rs.getString(3));
        member.setQuoMemAnb(Integer.valueOf(rs.getInt(4)));
        member.setQuoJointMem(rs.getString(5));
        session.setAttribute("jointMem", rs.getString(5));
        member.setQuoOccupation(rs.getString(6));
        member.setQMEM_DTY_CODE(rs.getBigDecimal(16));
        member.setQMEM_MEM_CODE(rs.getBigDecimal(17));
        member.setQMEM_CODE(rs.getBigDecimal(18));
        member.setQMEM_BPRESS_LOADING(rs.getBigDecimal(12));
        member.setQMEM_HEIGHT(rs.getBigDecimal(7));
        member.setQMEM_WEIGHT(rs.getBigDecimal(8));
        member.setQMEM_WEIGHT_LOADING(rs.getBigDecimal(9));
        member.setQMEM_SYSTOLIC_PR(rs.getBigDecimal(10));
        member.setQMEM_DIASTOLIC_PR(rs.getBigDecimal(11));
        member.setQMEM_LOADING_TYPE(rs.getString(13));
        member.setQMEM_LOADING_RATE(rs.getBigDecimal(14));
        member.setQMEM_LOADING_DIV_FACT(rs.getBigDecimal(15));
        member.setQMEM_TOT_SA(rs.getBigDecimal(19));
        member.setLca_categ_desc(rs.getString(20));
        member.setQMEM_BMI_RATE(rs.getBigDecimal(21));
        member.setMemSex(rs.getString(22));  
        member.setMemSurname(rs.getString(23));
        member.setMemOtherNames(rs.getString(24));  
        member.setMemDOB(rs.getDate(25));  
        i++;
          if(i >= GlobalCC.RowsLimit){
              session.setAttribute("limitExceeded", "Y");
          }
          
      myQuotations.add(member);
      }

      rs.close();
      cst.close();
      conn.close();
    }
    catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return myQuotations;
  }

  public List<Quotations> findQuoteExceptions()
  {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    List myQuotations = new ArrayList();
    try
    {
      String provQuery = "BEGIN LMS_WEB_CURSOR_GRP.get_quot_pol_exceptions(?,?);END;";
      cst = conn.prepareCall(provQuery);
      cst.registerOutParameter(1,OracleTypes.CURSOR);

      cst.setBigDecimal(2, (BigDecimal)this.session.getAttribute("QuoteCode"));

      cst.execute();
      ResultSet rs = (ResultSet)cst.getObject(1);
      while (rs.next())
      {
        Quotations prov = new Quotations();
        prov.setQEXC_CODE(rs.getBigDecimal(1));
        prov.setQEXC_POL_QUOT_CODE(rs.getBigDecimal(2));
        prov.setQEXC_AUTHORISED(rs.getString(3));
        prov.setQEXC_DESC(rs.getString(4));

        myQuotations.add(prov);
      }

      rs.close();
      cst.close();
      conn.close();
    }
    catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return myQuotations;
  }

  public List<Quotations> findAllQuotations()
  {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    List myQuotations = new ArrayList();
    try
    {
      String quotQuery = "begin LMS_WEB_CURSOR_GRP.get_all_quotes();end;";
      cst = conn.prepareCall(quotQuery);
      cst.registerOutParameter(1,OracleTypes.CURSOR);

      cst.execute();
      ResultSet rs = (ResultSet)cst.getObject(1);
      while (rs.next())
      {
        Quotations myQuot = new Quotations();

        myQuot.setENQ_quo_code(rs.getBigDecimal(1));
        myQuot.setENQ_quo_no(rs.getString(2));
        myQuot.setENQ_CLIENT(rs.getString(3));
        myQuot.setENQ_brn_name(rs.getString(4));
        myQuot.setENQ_agn_name(rs.getString(5));
        myQuot.setENQ_DATE(rs.getDate(6));
        myQuot.setENQ_STATUS(rs.getString(7));

        myQuotations.add(myQuot);
      }
      rs.close();
      cst.close();
      conn.close();
    }
    catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return myQuotations;
  }

  public List<Quotations> findQuotationsEnquiry()
  {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    List myQuotations = new ArrayList();
    try
    {
      String quotQuery = "begin LMS_WEB_CURSOR_GRP.get_quot_enquiry(?,?,?,?,?,?,?,?);end;";
      cst = conn.prepareCall(quotQuery);
      cst.registerOutParameter(1,OracleTypes.CURSOR);
      cst.setBigDecimal(2, (BigDecimal)this.session.getAttribute("brnCode"));
      cst.setBigDecimal(3, (BigDecimal)this.session.getAttribute("prpCode"));
      cst.setBigDecimal(4, (BigDecimal)this.session.getAttribute("ProductCode"));
      cst.setBigDecimal(5, (BigDecimal)this.session.getAttribute("agnCode"));
      cst.setString(6, (String)this.session.getAttribute("quoteState"));
      cst.setString(7, (String)this.session.getAttribute("quoteDateFrom"));
      cst.setString(8, (String)this.session.getAttribute("quoteDateTo"));

      cst.execute();
      ResultSet rs = (ResultSet)cst.getObject(1);
      int i = 0;
      while (rs.next())
      {
        Quotations myQuot = new Quotations();

        myQuot.setENQ_quo_code(rs.getBigDecimal(1));
        if (i == 0) {
          this.session.setAttribute("QuoteCode", rs.getBigDecimal(1));
        }
        i++;
        myQuot.setENQ_quo_no(rs.getString(2));
        myQuot.setENQ_CLIENT(rs.getString(3));
        myQuot.setENQ_brn_name(rs.getString(4));
        myQuot.setENQ_agn_name(rs.getString(5));
        myQuot.setENQ_DATE(rs.getDate(6));
        myQuot.setENQ_STATUS(rs.getString(7));
        myQuot.setSelected(false);

        myQuotations.add(myQuot);
      }
      rs.close();
      cst.close();
      conn.close();
    }
    catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return myQuotations;
  }

  public List<Quotations> findQuoteSubdivisions()
  {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    List myQuotations = new ArrayList();
    try
    {
      String provQuery = "BEGIN LMS_WEB_CURSOR_GRP.find_quote_subdivisons(?,?);END;";
      cst = conn.prepareCall(provQuery);
      cst.registerOutParameter(1,OracleTypes.CURSOR);

      cst.setBigDecimal(2, (BigDecimal)this.session.getAttribute("QuoteCode"));

      cst.execute();
      ResultSet rs = (ResultSet)cst.getObject(1);
      while (rs.next())
      {
        Quotations prov = new Quotations();

        prov.setQGSUB_CODE(rs.getBigDecimal(1));
        prov.setQGSUB_GSUB_CODE(rs.getBigDecimal(2));
        prov.setGSUB_DESC(rs.getString(3));
        prov.setQGSUB_SHT_DESC(rs.getString(4));
        prov.setQGSUB_DESC(rs.getString(5));

        myQuotations.add(prov);
      }

      rs.close();
      cst.close();
      conn.close();
    }
    catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return myQuotations;
  }

  public List<Quotations> findQuoteMemberSubdivisions()
  {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    List myQuotations = new ArrayList();
    try
    {
      String provQuery = "BEGIN LMS_WEB_CURSOR_GRP.find_quomem_subdivisons(?,?);END;";
      cst = conn.prepareCall(provQuery);
      cst.registerOutParameter(1,OracleTypes.CURSOR);

      cst.setBigDecimal(2, (BigDecimal)this.session.getAttribute("MemberNumber"));

      cst.execute();
      ResultSet rs = (ResultSet)cst.getObject(1);
      while (rs.next())
      {
        Quotations prov = new Quotations();

        prov.setQGSUB_CODE(rs.getBigDecimal(1));
        prov.setQGSUB_GSUB_CODE(rs.getBigDecimal(2));
        prov.setGSUB_DESC(rs.getString(3));
        prov.setQGSUB_SHT_DESC(rs.getString(4));
        prov.setQGSUB_DESC(rs.getString(5));
        prov.setQMEMS_CODE(rs.getBigDecimal(6));

        myQuotations.add(prov);
      }

      rs.close();
      cst.close();
      conn.close();
    }
    catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return myQuotations;
  }
  
  public List<Quotations> findQuoteRemarks()
  {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    List myQuotationsRemarks = new ArrayList();
    try
    {
      String remarksQuery = "BEGIN LMS_WEB_CURSOR_GRP.findQuotationRemarks(?,?);END;";
      cst = conn.prepareCall(remarksQuery);
      cst.registerOutParameter(1,OracleTypes.CURSOR);

      cst.setBigDecimal(2, (BigDecimal)this.session.getAttribute("QuoteCode"));

      cst.execute();
      ResultSet rs = (ResultSet)cst.getObject(1);
      while (rs.next())
      {
        Quotations remarks = new Quotations();
        remarks.setQrmCode(rs.getBigDecimal(1));
        remarks.setQrmRemarks(rs.getString(2)); 
        remarks.setQrmRemarksType(rs.getString(3));
        if(rs.getString(3).equals("O"))
         remarks.setQrmRemarksDesc("Observations");
        else if(rs.getString(3).equals("R")) 
          remarks.setQrmRemarksDesc("Recommendation");
          
         remarks.setQrmRemarksBy(rs.getString(4));
         remarks.setQrmRemarksDate(rs.getDate(5)); 
          
        myQuotationsRemarks.add(remarks);
      }

      rs.close();
      cst.close();
      conn.close();
    }
    catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
      e.printStackTrace();
    }
    return myQuotationsRemarks;
  }
  
  public List<Quotations> findDMSProcessDocs()
  {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    List myQuotationsRemarks = new ArrayList();
    try
    {
      String remarksQuery = "BEGIN LMS_SETUPS_CURSOR.getDocsToProcess(?,?);END;";
      cst = conn.prepareCall(remarksQuery);
      cst.registerOutParameter(1,OracleTypes.CURSOR);

      cst.setString(2, (String)session.getAttribute("dmsTranstype"));

      cst.execute();
      ResultSet rs = (ResultSet)cst.getObject(1);
      while (rs.next())
      {
        Quotations remarks = new Quotations();
        remarks.setDDP_CODE(rs.getBigDecimal(1));
        remarks.setDDP_NUMBER(rs.getString(2)); 
        remarks.setDDP_TRANS_TYPE(rs.getString(3));         
        myQuotationsRemarks.add(remarks);
      }

      rs.close();
      cst.close();
      conn.close();
    }
    catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
      e.printStackTrace();
    }
    return myQuotationsRemarks;
  }

  public void setQuoteCategoryShtDesc(String QuoteCategoryShtDesc) {
    this.session.setAttribute("QuoteCategoryShtDesc", QuoteCategoryShtDesc);
    this.QuoteCategoryShtDesc = QuoteCategoryShtDesc;
  }

  public String getQuoteCategoryShtDesc() {
    this.QuoteCategoryShtDesc = ((String)this.session.getAttribute("QuoteCategoryShtDesc"));
    return this.QuoteCategoryShtDesc;
  }
  public void setCoverTypeCode(BigDecimal CoverTypeCode) {
    this.CoverTypeCode = CoverTypeCode;
  }

  public BigDecimal getCoverTypeCode() {
    return (BigDecimal)this.session.getAttribute("qcvtCode");
  }

  public void setLcaCode(BigDecimal lcaCode) {
    this.session.setAttribute("rptLCACode", lcaCode);
    this.lcaCode = lcaCode;
  }

  public BigDecimal getLcaCode() {
    return (BigDecimal)this.session.getAttribute("rptLCACode");
  }
}