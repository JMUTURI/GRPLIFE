package LMSG.view.Policy;

import LMSG.view.Base.GlobalCC;
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

public class policiesDAO {
  HttpSession session =
    (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
  private String CategoryShtDesc;
  private BigDecimal withdrawalReceipt;
  private Integer lmitCode;

  public List<policies> FindPolicies() {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;

    List<policies> PolicyList = new ArrayList();
    try {
      String polQuery = "begin LMS_WEB_CURSOR_GRP.FindPolicies(?,?,?);end;";

      cst = conn.prepareCall(polQuery);
      cst.registerOutParameter(1, OracleTypes.CURSOR);
      cst.setBigDecimal(2,
                        (BigDecimal)this.session.getAttribute("policyCode"));

      BigDecimal Prod = (BigDecimal)this.session.getAttribute("ProductCode");
      if (Prod == null) {
        cst.setBigDecimal(3, null);
      } else {
        cst.setBigDecimal(3,
                          (BigDecimal)this.session.getAttribute("ProductCode"));
      }
      cst.execute();
      ResultSet rst = (ResultSet)cst.getObject(1);
      while (rst.next()) {
        policies myProd = new policies();
        myProd.setPOL_CODE(rst.getBigDecimal(1));
        myProd.setPOL_EFFECTIVE_DATE(rst.getDate(2));
        myProd.setUW_YEAR(rst.getBigDecimal(3));
        myProd.setCLIENT_DISPLAY(rst.getString(4));
        this.session.setAttribute("polClient", rst.getString(4));
        myProd.setPOL_FREQ_OF_PAYMENT(rst.getString(5));
        myProd.setOCCUPATION_DISPLAY(rst.getString(6));
        myProd.setHARZARD_DISPLAY(rst.getString(7));
        myProd.setPOL_PROD_SHT_DESC(rst.getString(8));
        myProd.setPOL_PROD_TYPE(rst.getString(9));
        this.session.setAttribute("prodType", rst.getString(9));
        this.session.setAttribute("productType", rst.getString(9));
        myProd.setBRANCH_DISPLAY(rst.getString(10));
        myProd.setPOL_DEPENDT_COVERED(rst.getString(11));
        this.session.setAttribute("depCovered", rst.getString(11));
        myProd.setPOL_STATUS(rst.getString(12));
        myProd.setPOL_INCEPTION_DATE(rst.getDate(13));
        myProd.setPOL_SAVINGS_RIDER(rst.getString(14));
        myProd.setPOL_PENS_CATEGORY(rst.getString(15));
        myProd.setPOL_OS_LOAN_CALC(rst.getString(16));
        myProd.setPOL_GRP_LIFE_RIDER(rst.getString(17));
        if (rst.getString(17) == null) {
          this.session.setAttribute("GrpLifeRider", "N");
        } else {
          this.session.setAttribute("GrpLifeRider", rst.getString(17));
        }
        myProd.setPOL_POLICY_NO(rst.getString(18));
        this.session.setAttribute("dmsPolNo", rst.getString(18));

        myProd.setPrp_code(rst.getBigDecimal(20));
        myProd.setPOL_COVER_FROM(rst.getDate(21));
        myProd.setPOL_COVER_TO(rst.getDate(22));
        myProd.setEXPIRY_DATE_DISPLAY(rst.getDate(23));
        myProd.setPOL_COINSURANCE(rst.getString(24));

        myProd.setPRO_DESC(rst.getString(25));
        myProd.setPol_status_disp(rst.getString(26));
        myProd.setPol_freq_of_payment_disp(rst.getString(27));
        myProd.setPol_dependt_covered_disp(rst.getString(28));
        myProd.setPol_savings_rider_disp(rst.getString(29));
        myProd.setPol_os_loan_calc_disp(rst.getString(30));
        myProd.setPol_pens_category_disp(rst.getString(31));
        myProd.setEndr_code(rst.getBigDecimal(32));
        myProd.setPrp_clnt_code(rst.getBigDecimal(33));
        myProd.setAGN_NAME(rst.getString(34));
        myProd.setPOL_RENEWAL_AREA_STATUS(rst.getString(35));
        myProd.setLPAG_CODE(rst.getBigDecimal(36));
        myProd.setLPAG_DESC(rst.getString(37));
        myProd.setPOL_UMBRELLA(rst.getString(38));
        this.session.setAttribute("umbrellaCover", rst.getString(38));
        if (rst.getString(38) == null) {
          myProd.setPOL_UMBRELLADESC("No");
        } else if (rst.getString(38).equalsIgnoreCase("Y")) {
          myProd.setPOL_UMBRELLADESC("Yes");
        } else {
          myProd.setPOL_UMBRELLADESC("No");
        }
        myProd.setPol_cur_symbol(rst.getString(39));
        myProd.setPpl_desc(rst.getString(40));
        myProd.setPOL_ASSIGNEE_NAME(rst.getString(41));
        myProd.setPOL_ASSIGNEE_PHY_ADDR(rst.getString(42));
        this.session.setAttribute("currCode", rst.getBigDecimal(44));


        PolicyList.add(myProd);
      }
      rst.close();
      cst.close();
      conn.close();
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return PolicyList;
  }

  public List<policies> FindPolicyTaxes() {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;

    List<policies> PolicyList = new ArrayList();
    try {
      String polQuery = "begin LMS_WEB_CURSOR_GRP.FindPolicyTaxes(?,?);end;";

      String RenewalArea = (String)this.session.getAttribute("RenewalArea");
      if (RenewalArea == null) {
        polQuery = "begin LMS_WEB_CURSOR_GRP.FindPolicyTaxes(?,?);end;";
      } else if (RenewalArea.equalsIgnoreCase("Y")) {
        polQuery = "begin LMS_WEB_CURSOR_GRP.find_renpolicytaxes(?,?);end;";
      } else {
        polQuery = "begin LMS_WEB_CURSOR_GRP.FindPolicyTaxes(?,?);end;";
      }
      cst = conn.prepareCall(polQuery);
      cst.registerOutParameter(1, OracleTypes.CURSOR);
      cst.setBigDecimal(2,
                        (BigDecimal)this.session.getAttribute("endorsementCode"));


      cst.execute();
      ResultSet rst = (ResultSet)cst.getObject(1);
      while (rst.next()) {
        policies myProd = new policies();

        myProd.setPTX_CODE(rst.getBigDecimal(1));
        myProd.setPTX_ENDR_CODE(rst.getBigDecimal(2));
        myProd.setPTX_ENDR_NO(rst.getString(3));
        myProd.setPTX_POL_CODE(rst.getBigDecimal(4));
        myProd.setPTX_POL_POLICY_NO(rst.getString(5));
        myProd.setPTX_RATE(rst.getBigDecimal(6));
        myProd.setPTX_TAX_AMT(rst.getBigDecimal(7));
        myProd.setPTX_APPL_LEVEL(rst.getString(8));
        myProd.setTAX_DISPLAY(rst.getString(9));
        myProd.setDESCRIPTION(rst.getString(10));

        PolicyList.add(myProd);
      }
      rst.close();
      cst.close();
      conn.close();
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return PolicyList;
  }

  public List<policies> FindPolicyCategories() {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;

    List<policies> PolicyList = new ArrayList();
    try {
      String polQuery =
        "begin LMS_WEB_CURSOR_GRP.FindPolicyCategories(?,?);end;";

      String RenewalArea = (String)this.session.getAttribute("RenewalArea");
      if (RenewalArea == null) {
        polQuery = "begin LMS_WEB_CURSOR_GRP.FindPolicyCategories(?,?);end;";
      } else if (RenewalArea.equalsIgnoreCase("Y")) {
        polQuery =
            "begin LMS_WEB_CURSOR_GRP.find_renpolicycategories(?,?);end;";
      } else {
        polQuery = "begin LMS_WEB_CURSOR_GRP.FindPolicyCategories(?,?);end;";
      }
      cst = conn.prepareCall(polQuery);
      cst.registerOutParameter(1, OracleTypes.CURSOR);
      cst.setBigDecimal(2,
                        (BigDecimal)this.session.getAttribute("endorsementCode"));


      cst.execute();
      ResultSet rst = (ResultSet)cst.getObject(1);
      while (rst.next()) {
        policies myProd = new policies();

        myProd.setPCA_CODE(rst.getBigDecimal(1));
        myProd.setPCA_SHT_DESC(rst.getString(2));
        myProd.setPCA_CATEG_DESC(rst.getString(3));
        myProd.setPCA_PERIOD(rst.getBigDecimal(4));
        myProd.setPca_lpag_code(rst.getBigDecimal(6));
        myProd.setLpag_desc(rst.getString(7));
        myProd.setPmas_code(rst.getBigDecimal(8));
        myProd.setPmas_sht_desc(rst.getString(9));
        myProd.setPCA_USE_CVR_RATE(rst.getString(10));
        myProd.setPCA_RATE(rst.getBigDecimal(11));
        myProd.setPCA_RATE_DIV_FACT(rst.getBigDecimal(12));

        PolicyList.add(myProd);
      }
      rst.close();
      cst.close();
      conn.close();
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return PolicyList;
  }

  public List<policies> FindPolicyDependantTypes() {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;

    List<policies> PolicyList = new ArrayList();
    try {
      String polQuery =
        "begin LMS_WEB_CURSOR_GRP.FindPol_dep_types(?,?,?,?);end;";

      cst = conn.prepareCall(polQuery);
      cst.registerOutParameter(1, OracleTypes.CURSOR);
      cst.setBigDecimal(2,
                        (BigDecimal)this.session.getAttribute("policyCode"));

      cst.setBigDecimal(3,
                        (BigDecimal)this.session.getAttribute("PolicyCoverType"));

      BigDecimal Prod = (BigDecimal)this.session.getAttribute("ProductCode");
      if (Prod == null) {
        cst.setString(4, null);
      } else {
        cst.setBigDecimal(4,
                          (BigDecimal)this.session.getAttribute("ProductCode"));
      }
      cst.execute();
      ResultSet rst = (ResultSet)cst.getObject(1);
      while (rst.next()) {
        policies myProd = new policies();

        myProd.setDTY_CODE(rst.getBigDecimal(1));
        myProd.setDTY_SHT_DESC(rst.getString(2));
        myProd.setDTY_DESCRIPTION(rst.getString(3));
        myProd.setPCD_MAX_NO_ALLOWED(rst.getString(4));

        PolicyList.add(myProd);
      }
      rst.close();
      cst.close();
      conn.close();
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return PolicyList;
  }

  public List<policies> FindPolicyMembers() {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;

    List<policies> PolicyList = new ArrayList();
    try {
      String polQuery =
        "begin LMS_WEB_CURSOR_GRP.FindPolicyMembers(?,?,?,?,?,?);end;";

      String RenewalArea = (String)this.session.getAttribute("RenewalArea");
      if (RenewalArea == null) {
        polQuery =
            "begin LMS_WEB_CURSOR_GRP.FindPolicyMembers(?,?,?,?,?,?);end;";
      } else if (RenewalArea.equalsIgnoreCase("Y")) {
        polQuery =
            "begin LMS_WEB_CURSOR_GRP.findrenpolicymembers(?,?,?,?,?,?);end;";
      } else {
        polQuery =
            "begin LMS_WEB_CURSOR_GRP.FindPolicyMembers(?,?,?,?,?,?);end;";
      }
      cst = conn.prepareCall(polQuery);
      cst.registerOutParameter(1, OracleTypes.CURSOR);
      cst.setBigDecimal(2,
                        (BigDecimal)this.session.getAttribute("policyCode"));

      cst.setBigDecimal(3,
                        (BigDecimal)this.session.getAttribute("endorsementCode"));

      cst.setString(4, (String)this.session.getAttribute("srchMemNo"));
      cst.setString(5, (String)this.session.getAttribute("srchMemName"));
      cst.setInt(6, 1000);
      cst.execute();
      ResultSet rst = (ResultSet)cst.getObject(1);

      int i = 0;
      this.session.setAttribute("limitExceeded", "N");
      while (rst.next()) {
        policies myProd = new policies();

        myProd.setPOLM_CODE(rst.getBigDecimal(1));
        myProd.setPOLM_MEM_NO(rst.getString(2));
        myProd.setPOLM_client(rst.getString(3));
        myProd.setPOLM_DTY_DESCRIPTION(rst.getString(4));
        myProd.setPOLM_ANB(rst.getString(5));
        myProd.setPOLM_JOINT_MEMBERS(rst.getString(6));
        myProd.setGCO_DESC(rst.getString(7));
        myProd.setPOLM_MEM_STATUS(rst.getString(8));
        myProd.setPOLM_MEM_SCHEDULE_NO(rst.getString(9));
        myProd.setMEM_CODE(rst.getBigDecimal(10));
        myProd.setMEM_SCHEDULE_JOIN_DATE(rst.getDate(11));
        myProd.setPolm_mem_renewal_date(rst.getDate(12));
        myProd.setCategDesc(rst.getString(13));
        i++;
        if (i >= 1000) {
          this.session.setAttribute("limitExceeded", "Y");
        }
        PolicyList.add(myProd);
      }
      rst.close();
      cst.close();
      conn.close();
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return PolicyList;
  }

  public List<policies> FindPolicyFCLMembers() {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;

    List<policies> fclList = new ArrayList();
    try {
      String fclQuery = "begin LMS_WEB_CURSOR_GRP.findFclMem(?,?);end;";


      cst = conn.prepareCall(fclQuery);
      cst.registerOutParameter(1, OracleTypes.CURSOR);
      cst.setBigDecimal(2,
                        (BigDecimal)this.session.getAttribute("endorsementCode"));

      cst.execute();
      ResultSet rst = (ResultSet)cst.getObject(1);
      while (rst.next()) {
        policies aboveFcl = new policies();
        aboveFcl.setPOLM_MEM_NO(rst.getString(1));
        aboveFcl.setMEMBER_DISPLAY(rst.getString(2));
        aboveFcl.setPcmSA(rst.getBigDecimal(3));
        aboveFcl.setAboveFcl(rst.getBigDecimal(4));
        aboveFcl.setPOLMA_ANB(rst.getBigDecimal(5));
        aboveFcl.setPOLM_HEIGHT(rst.getString(6));
        aboveFcl.setPOLM_WEIGHT(rst.getString(7));
        aboveFcl.setPOLM_CODE(rst.getBigDecimal(8));
        aboveFcl.setPOLM_MEM_CODE(rst.getBigDecimal(9));
        fclList.add(aboveFcl);
      }
      rst.close();
      cst.close();
      conn.close();
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return fclList;
  }

  public List<policies> FindPolicyFirstReceipts() {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;

    List<policies> PolicyList = new ArrayList();
    try {
      String polQuery =
        "begin LMS_WEB_CURSOR_GRP.find_first_receipts(?,?,?);end;";

      cst = conn.prepareCall(polQuery);
      cst.registerOutParameter(1, OracleTypes.CURSOR);
      cst.setBigDecimal(2,
                        (BigDecimal)this.session.getAttribute("policyCode"));

      cst.setBigDecimal(3,
                        (BigDecimal)this.session.getAttribute("endorsementCode"));

      cst.execute();
      ResultSet rst = (ResultSet)cst.getObject(1);
      while (rst.next()) {
        policies myProd = new policies();

        myProd.setGFRT_CODE(rst.getBigDecimal(1));
        myProd.setGFRT_DATE(rst.getDate(2));
        myProd.setGFRT_AMT(rst.getBigDecimal(3));
        myProd.setGFRT_STATUS(rst.getString(4));
        myProd.setGFRT_STATUS_DESC(rst.getString(5));
        myProd.setBTR_TRANS_TYPE(rst.getString(6));
        myProd.setENDR_DRCR_NO(rst.getString(7));
        myProd.setENDR_CODE(rst.getBigDecimal(8));
        myProd.setGRCT_RECEIPT_NO(rst.getString(9));
        myProd.setMTRAN_CODE(rst.getBigDecimal(10));
        myProd.setMTRAN_AMOUNT(rst.getBigDecimal(11));
        myProd.setMTRAN_BALANCE(rst.getBigDecimal(12));
        myProd.setMTRAN_RCPT_RESERVE_AMT(rst.getBigDecimal(13));
        myProd.setGRCT_CODE(rst.getBigDecimal(14));

        PolicyList.add(myProd);
      }
      rst.close();
      cst.close();
      conn.close();
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return PolicyList;
  }

  public List<policies> FindPolicyTransactions() {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    List<policies> PolicyList = new ArrayList();
    try {
      String polQuery =
        "begin LMS_WEB_CURSOR_GRP.PolicyTransactions(?,?,?,?);end;";

      cst = conn.prepareCall(polQuery);
      cst.registerOutParameter(1, OracleTypes.CURSOR);
      BigDecimal Prod = (BigDecimal)this.session.getAttribute("ProductCode");
      if (Prod == null) {
        cst.setString(2, null);
      } else {
        cst.setBigDecimal(2,
                          (BigDecimal)this.session.getAttribute("ProductCode"));
      }
      String Auth = (String)this.session.getAttribute("Authorised");
      if (Auth == null) {
        cst.setString(3, "N");
      } else {
        cst.setString(3, (String)this.session.getAttribute("Authorised"));
      }
      cst.setBigDecimal(4,
                        (BigDecimal)this.session.getAttribute("clientPRPCode"));


      cst.execute();
      ResultSet rst = (ResultSet)cst.getObject(1);
      while (rst.next()) {
        policies myProd = new policies();

        myProd.setLTR_Client(rst.getString(1));
        myProd.setLTR_POL_POLICY_NO(rst.getString(2));
        myProd.setLTR_TRANS_NO(rst.getBigDecimal(3));
        myProd.setLTR_BTR_TRANS_CODE(rst.getString(4));
        myProd.setLTR_ENDR_SUB_TYPE(rst.getString(5));
        myProd.setLTR_POL_CODE(rst.getBigDecimal(6));
        myProd.setLTR_ENDR_CODE(rst.getBigDecimal(7));
        myProd.setPrp_code(rst.getBigDecimal(8));
        myProd.setLTR_AGN_CODE(rst.getBigDecimal(10));
        myProd.setLTR_BUSN_TYPE(rst.getString(11));
        myProd.setLTR_TRANS_AUTHORISED(rst.getString(12));

        PolicyList.add(myProd);
      }
      rst.close();
      cst.close();
      conn.close();
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return PolicyList;
  }

  public List<policies> FindPolicyLoadedTransactions() {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    List<policies> PolicyList = new ArrayList();
    try {
      String polQuery =
        "begin LMS_WEB_CURSOR_GRP.policyLoadedtransactions(?);end;";

      cst = conn.prepareCall(polQuery);
      cst.registerOutParameter(1, OracleTypes.CURSOR);

      cst.execute();
      ResultSet rst = (ResultSet)cst.getObject(1);
      while (rst.next()) {
        policies myProd = new policies();

        myProd.setLTR_Client(rst.getString(1));
        myProd.setLTR_POL_POLICY_NO(rst.getString(2));
        myProd.setLTR_TRANS_NO(rst.getBigDecimal(3));
        myProd.setLTR_BTR_TRANS_CODE(rst.getString(4));
        myProd.setLTR_ENDR_SUB_TYPE(rst.getString(5));
        myProd.setLTR_POL_CODE(rst.getBigDecimal(6));
        myProd.setLTR_ENDR_CODE(rst.getBigDecimal(7));
        myProd.setPrp_code(rst.getBigDecimal(8));
        myProd.setLTR_AGN_CODE(rst.getBigDecimal(10));
        myProd.setLTR_BUSN_TYPE(rst.getString(11));
        myProd.setLTR_TRANS_AUTHORISED(rst.getString(12));

        PolicyList.add(myProd);
      }
      rst.close();
      cst.close();
      conn.close();
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return PolicyList;
  }

  public List<PremiumCard> FindPremiumCardDetails() {
    String premiumsQuery =
      "BEGIN LMS_WEB_CURSOR_GRP.FindPolicyDetails(?,?);END;";

    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    List<PremiumCard> PolicyList = new ArrayList();
    try {
      cst = conn.prepareCall(premiumsQuery);
      cst.registerOutParameter(1, OracleTypes.CURSOR);
      cst.setBigDecimal(2,
                        (BigDecimal)this.session.getAttribute("policyCode"));

      cst.execute();
      ResultSet rs = (ResultSet)cst.getObject(1);
      while (rs.next()) {
        PremiumCard polPrem = new PremiumCard();
        polPrem.setPOL_POLICY_NO(rs.getString(1));
        polPrem.setCLIENT(rs.getString(2));
        polPrem.setPRODUCT_DISPLAY(rs.getString(3));
        polPrem.setBRANCH_DISPLAY(rs.getString(4));
        polPrem.setPOL_EFFECTIVE_DATE(rs.getDate(5));
        polPrem.setPOL_FREQ_OF_PAYMENT(rs.getString(6));
        polPrem.setPOL_EFFECTIVE_DATE(rs.getDate(7));
        polPrem.setPRP_PIN(rs.getString(8));
        polPrem.setPRP_PAYROLL_NO(rs.getString(9));
        polPrem.setAGENT_DISPLAY(rs.getString(10));
        polPrem.setPOL_INSTLMT_PREM(rs.getBigDecimal(11));
        polPrem.setPOL_PAID_INSTLMT_NO(rs.getBigDecimal(12));
        polPrem.setOS_INSTALMENTS(rs.getBigDecimal(13));
        polPrem.setPOL_PENS_INSTLMT_PREM(rs.getBigDecimal(14));
        polPrem.setPOL_INSTLMT_PREM(rs.getBigDecimal(15));
        polPrem.setPOL_OS_INSTLMT_NO(rs.getBigDecimal(16));
        polPrem.setPOL_OS_PREM_BAL_AMT(rs.getBigDecimal(17));
        polPrem.setPREM_ALLOC(rs.getBigDecimal(18));
        polPrem.setPENS_ALLOC(rs.getBigDecimal(19));
        polPrem.setALL_ALLOC(rs.getBigDecimal(20));
        PolicyList.add(polPrem);
      }
      conn.close();
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return PolicyList;
  }

  public List<PremiumCard> FindReceiptTransfers() {
    String premiumsQuery =
      "BEGIN LMS_WEB_CURSOR_GRP.find_rcpt_transfers(?,?);END;";

    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    List<PremiumCard> PolicyList = new ArrayList();
    try {
      cst = conn.prepareCall(premiumsQuery);
      cst.registerOutParameter(1, OracleTypes.CURSOR);
      cst.setBigDecimal(2,
                        (BigDecimal)this.session.getAttribute("policyCode"));

      cst.execute();
      ResultSet rs = (ResultSet)cst.getObject(1);
      while (rs.next()) {
        PremiumCard polPrem = new PremiumCard();
        polPrem.setGGTRAN_DTLS_TRAN_CODE(rs.getBigDecimal(1));
        polPrem.setGRCT_RECEIPT_NO(rs.getString(2));
        polPrem.setGTRAN_POL_POLICY_FROM(rs.getString(3));
        polPrem.setGTRAN_POL_POLICY_TO(rs.getString(4));
        polPrem.setGTRAN_DTLS_PENS_ALLOC(rs.getBigDecimal(5));
        polPrem.setGTRAN_DTLS_PREM_ALLOC(rs.getBigDecimal(6));
        polPrem.setGTRAN_DTLS_TOT_ALLOC(rs.getBigDecimal(7));
        polPrem.setGTRAN_DTLS_STATUS(rs.getString(8));
        polPrem.setGTRAN_DTLS_REMARKS(rs.getString(9));
        PolicyList.add(polPrem);
      }
      conn.close();
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return PolicyList;
  }

  public List<PolicyPremiums> FindPolicyPremiums() {
    String premiumsQuery =
      "BEGIN LMS_WEB_CURSOR_GRP.GetPremiumPolicies(?,?);END;";

    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;

    List<PolicyPremiums> PolicyList = new ArrayList();
    try {
      cst = conn.prepareCall(premiumsQuery);
      cst.registerOutParameter(1, OracleTypes.CURSOR);
      BigDecimal Prod = (BigDecimal)this.session.getAttribute("ProductCode");
      if (Prod == null) {
        cst.setString(2, null);
      } else {
        cst.setBigDecimal(2,
                          (BigDecimal)this.session.getAttribute("ProductCode"));
      }
      cst.execute();
      ResultSet rs = (ResultSet)cst.getObject(1);
      while (rs.next()) {
        PolicyPremiums polPrem = new PolicyPremiums();
        polPrem.setPOL_POLICY_NO(rs.getString(1));
        polPrem.setClient(rs.getString(2));
        polPrem.setPOL_CODE(rs.getBigDecimal(3));
        polPrem.setPOL_INCEPTION_UWYR(rs.getString(4));
        polPrem.setPOL_STATUS(rs.getString(5));
        polPrem.setPROD_TYPE(rs.getString(6));
        PolicyList.add(polPrem);
      }
      conn.close();
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return PolicyList;
  }

  public List<PolicyReceipts> FindPolicyReceipts() {
    String premiumsQuery =
      "BEGIN LMS_WEB_CURSOR_GRP.FindPolicyReceipts(?,?,?);END;";

    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;

    List<PolicyReceipts> PolicyList = new ArrayList();
    try {
      cst = conn.prepareCall(premiumsQuery);
      cst.registerOutParameter(1, OracleTypes.CURSOR);
      cst.setBigDecimal(2,
                        (BigDecimal)this.session.getAttribute("policyCode"));


      cst.setString(3, "N");

      cst.execute();
      ResultSet rs = (ResultSet)cst.getObject(1);
      int i = 0;
      while (rs.next()) {
        PolicyReceipts polPrem = new PolicyReceipts();
        polPrem.setGRCT_CODE(rs.getBigDecimal(1));
        if (i == 0) {
          this.session.setAttribute("GrctCode", rs.getBigDecimal(1));
          this.session.setAttribute("GrctReceiptNo", rs.getString(2));
          this.session.setAttribute("GrctPensAlloc", rs.getBigDecimal(12));
          this.session.setAttribute("GrctPremAlloc", rs.getBigDecimal(11));
          i++;
        }
        polPrem.setGRCT_RECEIPT_NO(rs.getString(2));
        polPrem.setGRCT_RECEIPT_DATE(rs.getDate(3));
        polPrem.setGRCT_PAY_METHOD(rs.getString(4));
        polPrem.setGRCT_CHEQUE_NO(rs.getString(5));
        polPrem.setGRCT_AMT(rs.getBigDecimal(6));
        polPrem.setGRCT_COMM_INCLUSIVE(rs.getString(7));
        polPrem.setGRCT_GROSS_AMNT(rs.getBigDecimal(8));
        polPrem.setGRCT_PREM_PYMNT_AMT(rs.getBigDecimal(9));
        polPrem.setGRCT_PENS_PYMT_AMT(rs.getBigDecimal(10));
        polPrem.setGRCT_PREM_ALLOCATE(rs.getBigDecimal(11));
        polPrem.setGRCT_PENS_ALLOCATE(rs.getBigDecimal(12));
        polPrem.setBALANCE_AMT(rs.getBigDecimal(13));
        polPrem.setGrct_status(rs.getString(14));
        polPrem.setGrct_drcr(rs.getString(15));
        polPrem.setMem_alloc_amt(rs.getBigDecimal(16));
        polPrem.setMem_alloc_balance(rs.getBigDecimal(17));
        PolicyList.add(polPrem);
      }
      conn.close();
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return PolicyList;
  }

  public List<PolicyRecptInstlmnts> FindPolicyRecptInstlmnts() {
    String premiumsQuery =
      "BEGIN LMS_WEB_CURSOR_GRP.FindReceiptInstallments(?,?);END;";

    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;

    List<PolicyRecptInstlmnts> PolicyList = new ArrayList();
    try {
      cst = conn.prepareCall(premiumsQuery);
      cst.registerOutParameter(1, OracleTypes.CURSOR);
      cst.setBigDecimal(2, (BigDecimal)this.session.getAttribute("GrctCode"));

      cst.execute();
      ResultSet rs = (ResultSet)cst.getObject(1);
      while (rs.next()) {
        PolicyRecptInstlmnts polPrem = new PolicyRecptInstlmnts();
        polPrem.setGRCI_CODE(rs.getBigDecimal(1));
        polPrem.setGRCI_INSTLMT_NO(rs.getBigDecimal(2));
        polPrem.setGRCI_AMT(rs.getBigDecimal(3));
        polPrem.setGRCI_COMM_RATE(rs.getBigDecimal(4));
        polPrem.setGRCI_COMM_AMT(rs.getBigDecimal(5));
        polPrem.setGRCI_CHK_COMM_RATE(rs.getBigDecimal(6));
        polPrem.setGRCI_CHK_COMM_AMT(rs.getBigDecimal(7));
        polPrem.setGRCI_PREM_TAX_RATE(rs.getBigDecimal(8));
        polPrem.setGRCI_PREM_TAX_AMT(rs.getBigDecimal(9));

        PolicyList.add(polPrem);
      }
      conn.close();
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return PolicyList;
  }

  public List<policies> FindLapsedPolicies() {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;

    List<policies> PolicyList = new ArrayList();
    try {
      String polQuery =
        "begin LMS_WEB_CURSOR_GRP.lapsepoliciesquery(?,?,?,?,?);end;";

      cst = conn.prepareCall(polQuery);
      cst.registerOutParameter(1, OracleTypes.CURSOR);
      cst.setString(2,
                    (String)this.session.getAttribute("ProductLapsationDays"));

      cst.setBigDecimal(3,
                        (BigDecimal)this.session.getAttribute("ProductCode"));

      cst.setString(4, (String)this.session.getAttribute("LapseType"));
      cst.setString(5, (String)this.session.getAttribute("Username"));

      cst.execute();
      ResultSet rst = (ResultSet)cst.getObject(1);
      while (rst.next()) {
        policies myProd = new policies();

        myProd.setPL_pol_code(rst.getBigDecimal(1));
        myProd.setPL_pol_policy_no(rst.getString(2));
        myProd.setPL_client(rst.getString(9));
        myProd.setPL_brn_sht_desc(rst.getString(11));
        myProd.setPL_pol_freq_of_payment(rst.getString(16));
        myProd.setPL_pol_last_add_sched_date(rst.getDate(12));
        myProd.setPL_pol_effective_date(rst.getDate(5));
        myProd.setPL_pol_paid_to_date(rst.getDate(13));
        myProd.setPL_pol_paid_instlmt_no(rst.getString(17));
        myProd.setPL_pol_instlmt_prem(rst.getString(18));
        myProd.setPL_os_instals(rst.getString(14));
        myProd.setPL_os_prem(rst.getBigDecimal(15));

        PolicyList.add(myProd);
      }
      rst.close();
      cst.close();
      conn.close();
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return PolicyList;
  }

  public List<policies> FindContraPolicies() {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;

    List<policies> PolicyList = new ArrayList();
    try {
      String polQuery =
        "begin LMS_WEB_CURSOR_GRP.findcontratransactions(?,?);end;";

      cst = conn.prepareCall(polQuery);
      cst.registerOutParameter(1, OracleTypes.CURSOR);
      cst.setBigDecimal(2,
                        (BigDecimal)this.session.getAttribute("policyCode"));


      cst.execute();
      ResultSet rst = (ResultSet)cst.getObject(1);
      while (rst.next()) {
        policies myProd = new policies();

        myProd.setCo_ltr_trans_no(rst.getString(1));
        myProd.setCo_ltr_btr_trans_code(rst.getString(2));
        myProd.setCo_ltr_trans_date(rst.getDate(3));
        myProd.setCo_ltr_pol_policy_no(rst.getString(4));
        myProd.setCo_endr_no(rst.getString(5));
        myProd.setCo_ltr_endr_code(rst.getBigDecimal(6));
        myProd.setTrans(rst.getString(7));

        PolicyList.add(myProd);
      }
      rst.close();
      cst.close();
      conn.close();
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return PolicyList;
  }

  public List<policies> FindReinstatePolicyCandidates() {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;

    List<policies> PolicyList = new ArrayList();
    try {
      String polQuery =
        "begin LMS_WEB_CURSOR_GRP.reinstate_policies_query(?,?);end;";

      cst = conn.prepareCall(polQuery);
      cst.registerOutParameter(1, OracleTypes.CURSOR);
      cst.setBigDecimal(2,
                        (BigDecimal)this.session.getAttribute("ProductCode"));


      cst.execute();
      ResultSet rst = (ResultSet)cst.getObject(1);
      while (rst.next()) {
        policies myProd = new policies();

        myProd.setRT_pol_policy_no(rst.getString(1));
        myProd.setRT_client(rst.getString(2));
        myProd.setRT_pol_inception_uwyr(rst.getString(3));
        myProd.setRT_pol_status(rst.getString(4));
        myProd.setRT_pol_code(rst.getBigDecimal(5));
        myProd.setRT_pol_effective_date(rst.getDate(6));
        myProd.setRT_pol_calc_type(rst.getString(7));
        myProd.setPol_current_endr_code(rst.getBigDecimal(8));

        PolicyList.add(myProd);
      }
      rst.close();
      cst.close();
      conn.close();
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return PolicyList;
  }

  public List<policies> FindPolicyCoinsurers() {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;

    List<policies> PolicyList = new ArrayList();
    try {
      String polQuery =
        "begin LMS_WEB_CURSOR_GRP.findpolicycoinsurers(?,?);end;";

      String RenewalArea = (String)this.session.getAttribute("RenewalArea");
      if (RenewalArea == null) {
        polQuery = "begin LMS_WEB_CURSOR_GRP.findpolicycoinsurers(?,?,?);end;";
      } else if (RenewalArea.equalsIgnoreCase("Y")) {
        polQuery =
            "begin LMS_WEB_CURSOR_GRP.find_renpolicycoinsurers(?,?,?);end;";
      } else {
        polQuery = "begin LMS_WEB_CURSOR_GRP.findpolicycoinsurers(?,?,?);end;";
      }
      cst = conn.prepareCall(polQuery);
      cst.registerOutParameter(1, OracleTypes.CURSOR);
      String Val = (String)this.session.getAttribute("coinsLevel");
      if (Val == null) {
        cst.setBigDecimal(2,
                          (BigDecimal)this.session.getAttribute("endorsementCode"));
      } else if (Val.equalsIgnoreCase("T")) {
        cst.setBigDecimal(2,
                          (BigDecimal)this.session.getAttribute("policyCode"));
      } else {
        cst.setBigDecimal(2,
                          (BigDecimal)this.session.getAttribute("endorsementCode"));
      }
      cst.setString(3, (String)this.session.getAttribute("coinsLevel"));

      cst.execute();
      ResultSet rst = (ResultSet)cst.getObject(1);
      while (rst.next()) {
        policies myProd = new policies();

        myProd.setPol_coin_code(rst.getBigDecimal(1));
        myProd.setPol_coin_endr_code(rst.getBigDecimal(2));
        myProd.setPol_coin_agn_code(rst.getBigDecimal(3));
        myProd.setPol_coin_pol_code(rst.getBigDecimal(4));
        myProd.setCoinsurer_display(rst.getString(5));
        myProd.setPol_coin_admin_fee(rst.getBigDecimal(6));
        myProd.setPOL_COIN_SHARE_PCT(rst.getString(7));
        if (rst.getString(8) == null) {
          myProd.setPOL_COINSURE_LEADER("L");
        } else {
          myProd.setPOL_COINSURE_LEADER(rst.getString(8));
        }
        if (rst.getString(9) == null) {
          myProd.setPOL_COINSURE_LEADER_SHARE("");
        } else {
          myProd.setPOL_COINSURE_LEADER_SHARE(rst.getString(9));
        }
        myProd.setPOL_COIN_FOLLOWER(rst.getString(10));
        myProd.setPOL_COIN_FOLLOWER_DESC(rst.getString(11));
        myProd.setPOL_COIN_PREMIUM(rst.getBigDecimal(12));
        myProd.setPOL_COIN_SRVCE_FEE(rst.getBigDecimal(13));
        myProd.setENDR_COIN_FOLLOWER_SHARE(rst.getBigDecimal(14));
        if (rst.getString(11) == null) {
          myProd.setSHARE_DESC("Leader Share");
          myProd.setOWN_SHARE(rst.getBigDecimal(9));
        } else if (rst.getString(11).equalsIgnoreCase("Follower")) {
          myProd.setSHARE_DESC("Follower Share");
          myProd.setOWN_SHARE(rst.getBigDecimal(14));
        } else {
          myProd.setSHARE_DESC("Leader Share");
          myProd.setOWN_SHARE(rst.getBigDecimal(9));
        }
        if (rst.getString(15) == null) {
          myProd.setENDR_FOLLOWER_PREM_PROVIDED(false);
        } else if (rst.getString(15).toString().equalsIgnoreCase("Y")) {
          myProd.setENDR_FOLLOWER_PREM_PROVIDED(true);
        } else {
          myProd.setENDR_FOLLOWER_PREM_PROVIDED(false);
        }
        myProd.setENDR_LEADER_COMBINED(rst.getString(16));
        if (rst.getString(16) == null) {
          myProd.setENDR_LEADER_COMBINED_LBL(false);
        } else if (rst.getString(16).toString().equalsIgnoreCase("Y")) {
          myProd.setENDR_LEADER_COMBINED_LBL(true);
        } else {
          myProd.setENDR_LEADER_COMBINED_LBL(false);
        }
        myProd.setPol_coin_settled(rst.getBigDecimal(17));
        myProd.setPol_coin_comm_amt(rst.getBigDecimal(18));
        myProd.setBtr_trans_type(rst.getString(19));
        myProd.setPol_coin_balance(rst.getBigDecimal(20));
        myProd.setFully_settled(rst.getString(21));
        myProd.setSelected(false);

        PolicyList.add(myProd);
      }
      rst.close();
      cst.close();
      conn.close();
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return PolicyList;
  }

  public List<policies> FindVestingScales() {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;

    List<policies> PolicyList = new ArrayList();
    try {
      String polQuery = "begin LMS_WEB_CURSOR_GRP.findvestingscale(?,?);end;";

      cst = conn.prepareCall(polQuery);
      cst.registerOutParameter(1, OracleTypes.CURSOR);
      cst.setBigDecimal(2,
                        (BigDecimal)this.session.getAttribute("endorsementCode"));


      cst.execute();
      ResultSet rst = (ResultSet)cst.getObject(1);
      while (rst.next()) {
        policies myProd = new policies();

        myProd.setPpvs_code(rst.getBigDecimal(1));
        myProd.setPpvs_pol_code(rst.getBigDecimal(2));
        myProd.setPpvs_endr_code(rst.getBigDecimal(3));
        myProd.setPpvs_yrs_from(rst.getString(4));
        myProd.setPpvs_yrs_to(rst.getString(5));
        myProd.setPpvs_pct_entitle(rst.getString(6));

        PolicyList.add(myProd);
      }
      rst.close();
      cst.close();
      conn.close();
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return PolicyList;
  }

  public List<policies> findMemberPensionDtls() {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;

    List<policies> MemberPensions = new ArrayList();
    try {
      String DpdQuery =
        "begin LMS_WEB_CURSOR_GRP.mempolpensiondtls(?,?,?);end;";


      cst = conn.prepareCall(DpdQuery);
      cst.registerOutParameter(1, OracleTypes.CURSOR);
      cst.setBigDecimal(2,
                        (BigDecimal)this.session.getAttribute("endorsementCode"));

      cst.setBigDecimal(3,
                        (BigDecimal)this.session.getAttribute("MemberNumber"));


      cst.execute();

      ResultSet rs = (ResultSet)cst.getObject(1);
      while (rs.next()) {
        policies existQout = new policies();

        existQout.setQMPNS_WEF_DATE(rs.getDate(1));
        existQout.setQMPNS_WET_DATE(rs.getDate(2));
        existQout.setQMPNS_EARNINGS(rs.getBigDecimal(3));
        existQout.setQMPNS_EMPLOYER_CONTR(rs.getBigDecimal(4));

        existQout.setQMPNS_EMPLOYEE_CONTR(rs.getBigDecimal(5));
        existQout.setQMPNS_EMPLYE_VOLU_CONTR(rs.getBigDecimal(6));
        existQout.setQMPNS_TOTAL_CONTR(rs.getBigDecimal(7));
        existQout.setQMPNS_ADMIN_FEE_RATE(rs.getBigDecimal(8));
        existQout.setQMPNS_NET_ANNUAL_FUND(rs.getBigDecimal(9));
        existQout.setQMPNS_COMP_INT_RATE(rs.getBigDecimal(10));
        existQout.setQMPNS_ANNTY_FAC_RATE(rs.getBigDecimal(11));
        existQout.setQMPNS_PENS_ANNUM(rs.getBigDecimal(12));
        existQout.setQMPNS_EST_MAT_VAL(rs.getBigDecimal(13));
        existQout.setQMPNS_ER_EST_EMV_VAL(rs.getBigDecimal(14));
        existQout.setQMPNS_EE_EST_MAT_VAL(rs.getBigDecimal(15));
        existQout.setPMPNS_ANN_AMOUNT(rs.getBigDecimal(16));
        existQout.setPMPNS_FUTURE_LIABILITY(rs.getBigDecimal(17));
        existQout.setPMPNS_PAST_LIABILITY(rs.getBigDecimal(18));
        existQout.setPMPNS_TOTAL_LIABILITY(rs.getBigDecimal(19));
        existQout.setPMPNS_EMPYR_PENS_BF(rs.getBigDecimal(20));
        existQout.setPMPNS_EMPYE_PENS_BF(rs.getBigDecimal(21));
        existQout.setPMPNS_TOT_PENS_BF(rs.getBigDecimal(22));
        existQout.setPMPNS_ANN_PURCHASE_PRICE(rs.getBigDecimal(23));
        existQout.setPMPNS_TOTAL_TERMINAL_BEN(rs.getBigDecimal(24));
        existQout.setPMPNS_TOTAL_INVESTMENT(rs.getBigDecimal(25));
        existQout.setPMPNS_EMPLYR_REG_BAL_BF(rs.getBigDecimal(26));
        existQout.setPMPNS_EMPLYR_UNREG_BAL_BF(rs.getBigDecimal(27));
        existQout.setPMPNS_EMPLYE_REG_BAL_BF(rs.getBigDecimal(28));
        existQout.setPMPNS_EMPLYE_UNREG_BAL_BF(rs.getBigDecimal(29));
        existQout.setPMPNS_EMPLYR_REG_CONTRI_AMT(rs.getBigDecimal(30));
        existQout.setPMPNS_EMPLYR_UNREG_CONTRI_AMT(rs.getBigDecimal(31));
        existQout.setPMPNS_EMPLYE_REG_CONTRI_AMT(rs.getBigDecimal(32));
        existQout.setPMPNS_EMPLYE_UNREG_CONTRI_AMT(rs.getBigDecimal(33));
        existQout.setPMPNS_EMPLYR_LUMPSUM(rs.getBigDecimal(34));
        existQout.setPMPNS_ER_HIST_EST_EMV_VAL(rs.getBigDecimal(35));
        existQout.setPMPNS_EE_HIST_EST_EMV_VAL(rs.getBigDecimal(36));

        MemberPensions.add(existQout);
      }
      rs.close();
      cst.close();
      conn.close();
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return MemberPensions;
  }

  public List<policies> FindPolicyExceptions() {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;

    List<policies> PolicyList = new ArrayList();
    try {
      String polQuery =
        "begin LMS_WEB_CURSOR_GRP.get_quot_pol_exceptions(?,?);end;";

      cst = conn.prepareCall(polQuery);
      cst.registerOutParameter(1, OracleTypes.CURSOR);
      cst.setBigDecimal(2,
                        (BigDecimal)this.session.getAttribute("endorsementCode"));


      cst.execute();
      ResultSet rst = (ResultSet)cst.getObject(1);
      while (rst.next()) {
        policies myProd = new policies();

        myProd.setQEXC_CODE(rst.getBigDecimal(1));
        myProd.setQEXC_POL_QUOT_CODE(rst.getBigDecimal(2));
        myProd.setQEXC_AUTHORISED(rst.getString(3));
        myProd.setQEXC_DESC(rst.getString(4));

        PolicyList.add(myProd);
      }
      rst.close();
      cst.close();
      conn.close();
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return PolicyList;
  }

  public List<policies> FindPolicySchedules() {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;

    List<policies> PolicyList = new ArrayList();
    try {
      String polQuery = "begin lms_web_cursor_grp.get_sch_no(?,?);end;";
      cst = conn.prepareCall(polQuery);
      cst.setBigDecimal(1,
                        (BigDecimal)this.session.getAttribute("policyCode"));

      cst.registerOutParameter(2, OracleTypes.CURSOR);

      cst.execute();
      ResultSet rst = (ResultSet)cst.getObject(2);
      while (rst.next()) {
        policies myProd = new policies();

        myProd.setENDR_MEM_CURRENT_SCH_NO(rst.getString(1));

        PolicyList.add(myProd);
      }
      rst.close();
      cst.close();
      conn.close();
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return PolicyList;
  }

  public List<policies> findScheduleMembers() {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;

    List<policies> MemberPensions = new ArrayList();
    try {
      String DpdQuery = "begin lms_web_cursor_grp.get_refund_mems(?,?,?);end;";


      cst = conn.prepareCall(DpdQuery);
      cst.registerOutParameter(1, OracleTypes.CURSOR);
      cst.setBigDecimal(2,
                        (BigDecimal)this.session.getAttribute("endorsementCode"));

      cst.setString(3, (String)this.session.getAttribute("scheduleNo"));

      cst.execute();

      ResultSet rs = (ResultSet)cst.getObject(1);
      while (rs.next()) {
        policies existQout = new policies();

        existQout.setPOLM_CODE(rs.getBigDecimal(1));
        existQout.setPOLM_MEM_NO(rs.getString(2));
        existQout.setPOLM_MEM_CODE(rs.getBigDecimal(3));
        existQout.setPOLM_NOF_JOINT_MEMBERS(rs.getString(4));
        existQout.setMEMBER_DISPLAY(rs.getString(5));

        MemberPensions.add(existQout);
      }
      rs.close();
      cst.close();
      conn.close();
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return MemberPensions;
  }

  public List<policies> findInvalidMembers() {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;

    List<policies> MemberPensions = new ArrayList();
    try {
      String DpdQuery =
        "begin lms_web_cursor_grp.find_invalid_member_data(?,?,?,?);end;";


      cst = conn.prepareCall(DpdQuery);
      cst.registerOutParameter(1, OracleTypes.CURSOR);

      cst.setInt(2,
                 ((Integer)this.session.getAttribute("templateTranSeq")).intValue());
      cst.setString(3, (String)this.session.getAttribute("importstate"));
      cst.setInt(4, 1000);

      cst.execute();

      ResultSet rs = (ResultSet)cst.getObject(1);
      int i = 0;
      this.session.setAttribute("ImportlimitExceeded", "N");
      while (rs.next()) {
        policies existQout = new policies();


        existQout.setLMID_CODE(rs.getBigDecimal(1));
        existQout.setLMID_LMIT_CODE(rs.getBigDecimal(2));
        existQout.setLMID_MEM_NO(rs.getString(3));
        existQout.setLMID_MAIN_MEM_NO(rs.getString(4));
        existQout.setLMID_MEM_SURNAME(rs.getString(5));
        existQout.setLMID_MEM_OTHERNAMES(rs.getString(6));
        existQout.setLMID_MEM_DOB(rs.getDate(7));
        existQout.setLMID_MEM_ANB(rs.getString(8));
        existQout.setLMID_MEM_SEX(rs.getString(9));
        existQout.setLMID_DEP_TYPE(rs.getString(10));
        existQout.setLMID_ID_NO(rs.getString(11));
        existQout.setLMID_MEM_CATEGORY(rs.getString(12));
        existQout.setLMID_EARNINGS(rs.getBigDecimal(13));
        existQout.setLMID_MULT_EARNINGS_PRD(rs.getBigDecimal(14));
        existQout.setLIMD_DATE_JOINED(rs.getDate(15));
        existQout.setLMID_MEM_OCCUPATION(rs.getString(16));
        existQout.setLMID_REMARKS(rs.getString(17));
        existQout.setLMID_STATUS(rs.getString(18));

        i++;
        if (i >= 1000) {
          this.session.setAttribute("ImportlimitExceeded", "Y");
        }
        MemberPensions.add(existQout);
      }
      rs.close();
      cst.close();
      conn.close();
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return MemberPensions;
  }

  public List<policies> findRefundInvalidMembers() {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;

    List<policies> MemberPensions = new ArrayList();
    try {
      String DpdQuery =
        "begin lms_web_cursor_grp.find_refund_inv_members(?,?,?);end;";


      cst = conn.prepareCall(DpdQuery);
      cst.registerOutParameter(1, OracleTypes.CURSOR);

      cst.setInt(2,
                 ((Integer)this.session.getAttribute("templateTranSeq")).intValue());
      cst.setString(3, (String)this.session.getAttribute("importstate"));

      cst.execute();

      ResultSet rs = (ResultSet)cst.getObject(1);
      while (rs.next()) {
        policies existQout = new policies();

        existQout.setREFM_CODE(rs.getBigDecimal(1));
        existQout.setREFM_LMIT_CODE(rs.getBigDecimal(2));
        existQout.setREFM_MEM_NO(rs.getString(3));
        existQout.setREFM_MEM_SURNAME(rs.getString(4));
        existQout.setREFM_MEM_OTHER_NAMES(rs.getString(5));
        existQout.setREFM_MEM_EFFECTIVE_DATE(rs.getDate(6));
        existQout.setREFM_REMARKS(rs.getString(7));
        existQout.setREFM_STATUS(rs.getString(8));
        existQout.setREFM_ORGINAL_LOAN(rs.getBigDecimal(9));
        existQout.setREFM_LOAN_ISSUE_DATE(rs.getDate(10));

        MemberPensions.add(existQout);
      }
      rs.close();
      cst.close();
      conn.close();
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return MemberPensions;
  }

  public List<policies> findLnRepayInvalidMembers() {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;

    List<policies> MemberPensions = new ArrayList();
    try {
      String DpdQuery =
        "begin lms_web_cursor_grp.find_loan_rpymt_members(?,?,?);end;";


      cst = conn.prepareCall(DpdQuery);
      cst.registerOutParameter(1, OracleTypes.CURSOR);

      cst.setInt(2,
                 ((Integer)this.session.getAttribute("templateTranSeq")).intValue());
      cst.setString(3, (String)this.session.getAttribute("importstate"));

      cst.execute();

      ResultSet rs = (ResultSet)cst.getObject(1);
      while (rs.next()) {
        policies existQout = new policies();

        existQout.setLIRM_CODE(rs.getBigDecimal(1));
        existQout.setLIRM_LMIT_CODE(rs.getBigDecimal(2));
        existQout.setLIRM_MEM_NO(rs.getString(3));
        existQout.setLIRM_MEM_SURNAME(rs.getString(4));
        existQout.setLIRM_MEM_OTHER_NAMES(rs.getString(5));
        existQout.setLIRM_LOAN_BAL(rs.getBigDecimal(6));
        existQout.setLIRM_LOAN_RPYMT_PRD(rs.getBigDecimal(7));
        existQout.setLIRM_MEM_EFFECTIVE_DATE(rs.getDate(8));
        existQout.setLIRM_REMARKS(rs.getString(9));
        existQout.setLIRM_STATUS(rs.getString(10));

        MemberPensions.add(existQout);
      }
      rs.close();
      cst.close();
      conn.close();
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return MemberPensions;
  }

  public List<policies> findPolicyImportBatches() {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;

    List<policies> MemberPensions = new ArrayList();
    try {
      String DpdQuery =
        "begin lms_web_cursor_grp.find_pol_import_batches(?,?,?);end;";


      cst = conn.prepareCall(DpdQuery);
      cst.registerOutParameter(1, OracleTypes.CURSOR);
      String SystemPoint = (String)this.session.getAttribute("SystemPoint");
      if (SystemPoint.equalsIgnoreCase("U")) {
        cst.setBigDecimal(2,
                          (BigDecimal)this.session.getAttribute("policyCode"));
      } else {
        cst.setBigDecimal(2,
                          (BigDecimal)this.session.getAttribute("QuoteCode"));
      }
      cst.setString(3, (String)this.session.getAttribute("SystemPoint"));

      cst.execute();

      ResultSet rs = (ResultSet)cst.getObject(1);
      while (rs.next()) {
        policies existQout = new policies();

        existQout.setLMIT_CODE(Integer.valueOf(rs.getInt(1)));
        existQout.setDESCRIPTION(rs.getString(2));

        MemberPensions.add(existQout);
      }
      rs.close();
      cst.close();
      conn.close();
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return MemberPensions;
  }

  public List<policies> findDuplicatedMembers() {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;

    List<policies> MemberPensions = new ArrayList();
    try {
      String DpdQuery =
        "begin lms_web_cursor_grp.validate_dup_members(?,?,?);end;";


      cst = conn.prepareCall(DpdQuery);
      cst.registerOutParameter(1, OracleTypes.CURSOR);
      cst.setInt(2,
                 ((Integer)this.session.getAttribute("templateTranSeq")).intValue());

      cst.setBigDecimal(3,
                        (BigDecimal)this.session.getAttribute("policyCode"));


      cst.execute();

      ResultSet rs = (ResultSet)cst.getObject(1);
      while (rs.next()) {
        policies existQout = new policies();

        existQout.setLMID_MEM_NO(rs.getString(1));
        existQout.setLMID_MEM_SURNAME(rs.getString(2));
        existQout.setLMID_MEM_OTHERNAMES(rs.getString(3));
        existQout.setLMID_MEM_DOB(rs.getDate(4));
        existQout.setLMID_MEM_ANB(rs.getString(5));
        existQout.setLMID_MEM_SEX(rs.getString(6));
        existQout.setLMID_MEM_CATEGORY(rs.getString(7));
        existQout.setLMID_EARNINGS(rs.getBigDecimal(8));

        MemberPensions.add(existQout);
      }
      rs.close();
      cst.close();
      conn.close();
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return MemberPensions;
  }

  public List<policies> findQuoteDuplicatedMembers() {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;

    List<policies> MemberPensions = new ArrayList();
    try {
      String DpdQuery =
        "begin lms_web_cursor_grp.validate_quote_dup_members(?,?,?);end;";


      cst = conn.prepareCall(DpdQuery);
      cst.registerOutParameter(1, OracleTypes.CURSOR);
      cst.setInt(2,
                 ((Integer)this.session.getAttribute("templateTranSeq")).intValue());

      cst.setBigDecimal(3, (BigDecimal)this.session.getAttribute("QuoteCode"));


      cst.execute();

      ResultSet rs = (ResultSet)cst.getObject(1);
      while (rs.next()) {
        policies existQout = new policies();

        existQout.setLMID_MEM_NO(rs.getString(1));
        existQout.setLMID_MEM_SURNAME(rs.getString(2));
        existQout.setLMID_MEM_OTHERNAMES(rs.getString(3));
        existQout.setLMID_MEM_DOB(rs.getDate(4));
        existQout.setLMID_MEM_ANB(rs.getString(5));
        existQout.setLMID_MEM_SEX(rs.getString(6));
        existQout.setLMID_MEM_CATEGORY(rs.getString(7));
        existQout.setLMID_EARNINGS(rs.getBigDecimal(8));

        MemberPensions.add(existQout);
      }
      rs.close();
      cst.close();
      conn.close();
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return MemberPensions;
  }

  public List<policies> FindPolicyClassTerms() {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;

    List<policies> PolicyList = new ArrayList();
    try {
      String polQuery =
        "begin LMS_WEB_CURSOR_GRP.findPolicyClassTermLimits(?,?);end;";

      cst = conn.prepareCall(polQuery);
      cst.registerOutParameter(1, OracleTypes.CURSOR);
      cst.setBigDecimal(2,
                        (BigDecimal)this.session.getAttribute("endorsementCode"));


      cst.execute();
      ResultSet rst = (ResultSet)cst.getObject(1);
      while (rst.next()) {
        policies myProd = new policies();

        myProd.setCtlCode(rst.getBigDecimal(1));
        myProd.setCtlQuoCode(rst.getBigDecimal(2));
        myProd.setCtlLcaCode(rst.getBigDecimal(3));
        myProd.setCtlFee(rst.getBigDecimal(4));
        myProd.setCategDesc(rst.getString(5));

        PolicyList.add(myProd);
      }
      rst.close();
      cst.close();
      conn.close();
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
    return PolicyList;
  }

  public List<policies> FindPolicyProvisions() {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;

    List<policies> PolicyList = new ArrayList();
    try {
      String polQuery =
        "begin LMS_WEB_CURSOR_GRP.findPolicyProvisions(?,?);end;";

      String RenewalArea = (String)this.session.getAttribute("RenewalArea");
      if (RenewalArea == null) {
        polQuery = "begin LMS_WEB_CURSOR_GRP.findPolicyProvisions(?,?);end;";
      } else if (RenewalArea.equalsIgnoreCase("Y")) {
        polQuery =
            "begin LMS_WEB_CURSOR_GRP.find_renpolicyprovisions(?,?);end;";
      } else {
        polQuery = "begin LMS_WEB_CURSOR_GRP.findPolicyProvisions(?,?);end;";
      }
      cst = conn.prepareCall(polQuery);
      cst.registerOutParameter(1, OracleTypes.CURSOR);
      cst.setBigDecimal(2,
                        (BigDecimal)this.session.getAttribute("endorsementCode"));


      cst.execute();
      ResultSet rst = (ResultSet)cst.getObject(1);
      while (rst.next()) {
        policies myProd = new policies();

        myProd.setPolpCode(rst.getBigDecimal(1));
        myProd.setPolpPolCode(rst.getBigDecimal(2));
        myProd.setPolpPprovProvCode(rst.getBigDecimal(3));
        myProd.setPolpProvShtDesc(rst.getString(4));
        myProd.setPolpEditable(rst.getString(5));
        myProd.setPolpEditableDesc(rst.getString(6));
        myProd.setPolpEndrCode(rst.getBigDecimal(7));
        myProd.setPolpDesc(rst.getString(8));
        PolicyList.add(myProd);
      }
      rst.close();
      cst.close();
      conn.close();
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
    return PolicyList;
  }

  public List<policies> FindPolicyProposers() {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;

    List PolicyList = new ArrayList();
    try {
      String polQuery = "begin LMS_WEB_CURSOR_GRP.get_pol_details(?,?);end;";

      cst = conn.prepareCall(polQuery);
      cst.registerOutParameter(1, OracleTypes.CURSOR);
      cst.setBigDecimal(2,
                        (BigDecimal)this.session.getAttribute("ProductCode"));

      cst.execute();
      ResultSet rst = (ResultSet)cst.getObject(1);
      while (rst.next()) {
        policies clientPolicies = new policies();
        clientPolicies.setPOL_CODE(rst.getBigDecimal(1));
        clientPolicies.setPOL_POLICY_NO(rst.getString(2));
        clientPolicies.setCLIENT_DISPLAY(rst.getString(3));
        PolicyList.add(clientPolicies);
      }
      rst.close();
      cst.close();
      conn.close();
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
    return PolicyList;
  }

  public List<policies> FindPolicyMem() {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;

    List PolicyList = new ArrayList();
    try {
      String polQuery = "begin LMS_WEB_CURSOR_GRP.get_pol_members(?,?,?);end;";

      cst = conn.prepareCall(polQuery);
      cst.registerOutParameter(1, OracleTypes.CURSOR);
      cst.setBigDecimal(2,
                        (BigDecimal)this.session.getAttribute("policyCode"));

      cst.setBigDecimal(3, (BigDecimal)this.session.getAttribute("PolmCode"));

      cst.execute();
      ResultSet rst = (ResultSet)cst.getObject(1);
      while (rst.next()) {
        policies polMem = new policies();
        polMem.setPOLM_MEM_NO(rst.getString(1));
        polMem.setMEMBER_DISPLAY(rst.getString(2));
        polMem.setMEM_SURNAME(rst.getString(3));
        polMem.setMEM_OTHER_NAMES(rst.getString(4));
        polMem.setPOLM_ANB(rst.getString(5));
        polMem.setOCCUPATION_DISPLAY(rst.getString(6));
        polMem.setPOLM_DTY_DESCRIPTION(rst.getString(7));
        polMem.setPOLM_CODE(rst.getBigDecimal(8));
        polMem.setPOLM_MEM_CODE(rst.getBigDecimal(9));
        PolicyList.add(polMem);
      }
      rst.close();
      cst.close();
      conn.close();
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
    return PolicyList;
  }

  public void setCategoryShtDesc(String CategoryShtDesc) {
    this.session.setAttribute("CategoryShtDesc", CategoryShtDesc);
    this.CategoryShtDesc = CategoryShtDesc;
  }

  public String getCategoryShtDesc() {
    this.CategoryShtDesc =
        ((String)this.session.getAttribute("CategoryShtDesc"));

    return this.CategoryShtDesc;
  }

  public void setWithdrawalReceipt(BigDecimal withdrawalReceipt) {
    this.session.setAttribute("withdrawalReceipt", withdrawalReceipt);
    this.withdrawalReceipt = withdrawalReceipt;
  }

  public BigDecimal getWithdrawalReceipt() {
    this.withdrawalReceipt =
        ((BigDecimal)this.session.getAttribute("withdrawalReceipt"));

    return this.withdrawalReceipt;
  }

  public void setLmitCode(Integer lmitCode) {
    if (lmitCode == null) {
      this.lmitCode = ((Integer)this.session.getAttribute("templateTranSeq"));
    } else {
      this.session.setAttribute("templateTranSeq", lmitCode);
    }
  }

  public Integer getLmitCode() {
    return (Integer)this.session.getAttribute("templateTranSeq");
  }
}
