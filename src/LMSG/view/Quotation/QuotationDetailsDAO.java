package LMSG.view.Quotation;

import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import oracle.jdbc.OracleTypes;

import LMSG.view.connect.DBConnector;

import LMSG.view.Base.GlobalCC;
import LMSG.view.Base.Settings;

public class QuotationDetailsDAO {
  
  public QuotationDetailsDAO() {
  }
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
  public List<QuotationsDetails> findQuotation()
  {

    DBConnector myConn=new DBConnector();
    Connection conn=myConn.getDatabaseConn();
    CallableStatement cst=null;
    List<QuotationsDetails> quotDAO=new ArrayList<QuotationsDetails>();
    
    try {

        String quotQuery="begin LMS_WEB_CURSOR_GRP.get_quotations(?,?,?,?);end;";
        cst=conn.prepareCall(quotQuery);
        cst.registerOutParameter(1,OracleTypes.CURSOR);
        cst.setString(2,(String)session.getAttribute("transType"));
        String todayString = null;
        System.out.println();
          cst.setBigDecimal(3,(BigDecimal)session.getAttribute("ProductCode"));
         BigDecimal Quote = (BigDecimal)session.getAttribute("QuoteCode");
          if(Quote==null)
          {
            cst.setBigDecimal(4,null);
          }
          else
          {
            cst.setBigDecimal(4,(BigDecimal)session.getAttribute("QuoteCode"));
          }
          cst.execute();
          ResultSet rs=(ResultSet)cst.getObject(1);
          while(rs.next()) {

            QuotationsDetails myQuot=new QuotationsDetails();
              
            myQuot.setClient(rs.getString(1));
            session.setAttribute("quoClient",rs.getString(1));
            myQuot.setQuoCode(rs.getInt(2));
            myQuot.setQuoNo(rs.getString(3));
            session.setAttribute("dmsQuoNo",rs.getString(3));
            myQuot.setQuoRevNo(rs.getInt(4));
            myQuot.setAgnshtDesc(rs.getString(5));
            myQuot.setAgnName(rs.getString(6));
            myQuot.setQUO_DATE(rs.getDate(7));
            myQuot.setBRN_NAME(rs.getString(8));
            myQuot.setQUO_TOT_PREMIUM(rs.getBigDecimal(9));
            myQuot.setQUO_TOT_SA(rs.getBigDecimal(10));
            myQuot.setQUO_PROD_SHT_DESC(rs.getString(11));
            myQuot.setQUO_PMAS_SHT_DESC(rs.getString(12));
            myQuot.setQUO_EFFECTIVE_DATE(rs.getDate(13));
            
            if (rs.getDate(13).toString().contains(":"))
              todayString = GlobalCC.parseDate(rs.getDate(13).toString());
            else {
              todayString = GlobalCC.upDateParseDate(rs.getDate(13).toString());
                session.setAttribute("dmsQuoDate",todayString);
            }
            session.setAttribute("dmsQuoDate",todayString);
            myQuot.setQUO_DURATION_TYPE(rs.getString(14));
            myQuot.setQUO_CALC_TYPE(rs.getString(15));
            if (rs.getString(15).equalsIgnoreCase("D")){
                  myQuot.setCALC_TYPE_DESC("Detailed Mem Info ");           
            }else{
                  myQuot.setCALC_TYPE_DESC("Aggregate Mem Info ");
            }
            session.setAttribute("QuotCalcType", rs.getString(15));
            myQuot.setQUO_AVG_ANB(rs.getBigDecimal(16));
            myQuot.setQUO_STATUS(rs.getString(17));
            myQuot.setQUO_DEPENDT_COVERED(rs.getString(18));
              if(rs.getString(18).trim().equals("Self & Joint Member")) {
                session.setAttribute("depCovered","J");  
              }else if(rs.getString(18).trim().equals("Self,Joint & Dependants")){
                session.setAttribute("depCovered","A"); 
              }else{
                session.setAttribute("depCovered",rs.getString(18)); 
                  System.out.println("Dependant covered"+rs.getString(18));
              }
              
            myQuot.setQUO_SAVINGS_RIDER(rs.getString(19));
            myQuot.setQUO_TYPE(rs.getString(20));
            myQuot.setQUO_FREQ_OF_PAYMENT(rs.getString(21));
            myQuot.setQUO_COVER_TO_DATE(rs.getDate(22));
            myQuot.setQUO_FCL_AMT(rs.getBigDecimal(23));
            myQuot.setQUO_GRP_LIFE_RIDER(rs.getString(24));
            if(rs.getString(24)==null){
                  session.setAttribute("GrpLifeRider", "N");  
            }else if(rs.getString(24).equalsIgnoreCase("No")){
                  session.setAttribute("GrpLifeRider", "N");
            }else{
                session.setAttribute("GrpLifeRider", "Y");
            }  
            myQuot.setQUO_OVERRIDE_FCL_AMT(rs.getBigDecimal(25));
            myQuot.setGCO_DESC(rs.getString(46));
            myQuot.setHAZARD(rs.getString(47));
            myQuot.setQuo_avg_int(rs.getBigDecimal(48));
            myQuot.setQUO_COVER_DEPENDANTS(rs.getString(49));
            myQuot.setQUO_PENS_ADMIN_FEE(rs.getBigDecimal(26));
            myQuot.setQUO_PENS_COMM_RATE(rs.getBigDecimal(27));
            myQuot.setQUO_EMPYR_PENS_BF(rs.getBigDecimal(28));
            myQuot.setQUO_EMPYE_PENS_BF(rs.getBigDecimal(29));
            myQuot.setQUO_TOT_PENS_BF(rs.getBigDecimal(30));
            myQuot.setQUO_CONTRIBTN_TYPE(rs.getString(31));
            myQuot.setQUO_RETIRE_AGE(rs.getBigDecimal(32));
            myQuot.setQUO_EMPYER_CONTR(rs.getBigDecimal(33));
            myQuot.setQUO_EMPYEE_CONTR(rs.getBigDecimal(34));
            myQuot.setQUO_VOL_CONTR(rs.getBigDecimal(35));
            myQuot.setQUO_TOT_CONTR(rs.getBigDecimal(36));
            myQuot.setQUO_TOT_SALARIES(rs.getBigDecimal(37));
            myQuot.setQUO_EMPYER_CONTR_RATE(rs.getBigDecimal(38));
            myQuot.setQUO_EMPYEE_CONTR_RATE(rs.getBigDecimal(39));
            myQuot.setQUO_GUARANT_PRD(rs.getBigDecimal(40));
            myQuot.setQUO_EMPLOYER_VOL_CONTR(rs.getBigDecimal(41));
            myQuot.setQUO_EMPLOYEE_VOL_CONTR(rs.getBigDecimal(42));
            myQuot.setQUO_PENS_INT_RATE(rs.getBigDecimal(43));
            myQuot.setQUO_PENS_ESC(rs.getBigDecimal(44));
            myQuot.setQUO_PENS_PAY_FREQ(rs.getString(45));
            myQuot.setQUO_MALE_NRD(rs.getBigDecimal(50));
            myQuot.setQUO_FEMALE_NRD(rs.getBigDecimal(51));
            myQuot.setQUO_EARN_ESCALATION(rs.getBigDecimal(52));
            myQuot.setQUO_FNDING_RATE(rs.getBigDecimal(53));
            myQuot.setQUO_FEATURES(rs.getString(54));
            myQuot.setQUO_LETTER_OPENING_REMARKS(rs.getString(55));
            myQuot.setQUO_LETTER_CLOSING_REMARKS(rs.getString(56));
            myQuot.setQUO_CLA_SHT_DESC(rs.getString(57));
            myQuot.setQUO_FCL_CALC_TYPE(rs.getString(62));
            myQuot.setPROP_CODE(rs.getBigDecimal(63));
            myQuot.setQUO_NOF_MEMBERS(rs.getString(65));
            myQuot.setFreq_of_payment_disp(rs.getString(66));
            
            String Typ = rs.getString(31);
            if(Typ == null){
                //do nothing...
            }else if(Typ.equalsIgnoreCase("P")){
                myQuot.setEMPYE_PA(rs.getBigDecimal(39));
                myQuot.setEMYR_PA(rs.getBigDecimal(38));
            }else{
                myQuot.setEMPYE_PA(rs.getBigDecimal(39));
                myQuot.setEMYR_PA(rs.getBigDecimal(38));
            }
            myQuot.setQUO_UNIT_RATE_FORMULA(rs.getString(67));
            session.setAttribute("UNIT_RATE_FORMULA",rs.getString(67));
              
            myQuot.setAnnType(rs.getString(68));
            myQuot.setQUO_ANN_AMOUNT(rs.getBigDecimal(69));
            myQuot.setAnnOption(rs.getString(70));
            myQuot.setAnnEscalation(rs.getString(71));
            myQuot.setQUO_ANN_INVESTMENT_RATE(rs.getBigDecimal(72));
            myQuot.setQUO_ANN_TERMINAL_PAYOUT_RATE(rs.getBigDecimal(73));
            myQuot.setQUO_ANN_ADMIN_CHARGE(rs.getBigDecimal(74));
            myQuot.setQUO_ANN_INVEST_INTR_RATE(rs.getBigDecimal(75));
            myQuot.setQUO_ANN_SCHEME_LEGAL_AGE(rs.getBigDecimal(76));
            myQuot.setQUO_ANN_INVESTMENT(rs.getBigDecimal(77));
            myQuot.setQUO_ANN_TERM_BENEFITS(rs.getBigDecimal(78));
            myQuot.setQUO_PAY_METHOD(rs.getString(79));
            session.setAttribute("CoinsPolicy", rs.getString(80));  
            session.setAttribute("rptProductCode", rs.getBigDecimal(81));  
            session.setAttribute("CoinsLeadFollow", rs.getString(82)); 
            myQuot.setQuo_pens_mode(rs.getString(83));
            myQuot.setQuo_pens_type(rs.getString(84));
            myQuot.setMARKETER(rs.getString(85));
            myQuot.setQUO_UMBRELLA(rs.getString(86));
            session.setAttribute("umbrellaCover", rs.getString(86));
            if(rs.getString(86)==null){
              myQuot.setQUO_UMBRELLADESC("No");
            }else if(rs.getString(86).equalsIgnoreCase("Y")){
              myQuot.setQUO_UMBRELLADESC("Yes");
            }else{
              myQuot.setQUO_UMBRELLADESC("No");
            }
            myQuot.setQUO_UMBRELLA_DURATION(rs.getString(87));
            myQuot.setQUO_LOSS_RATIO(rs.getBigDecimal(88)); 
            myQuot.setQUO_UNIT_RATE(rs.getBigDecimal(89));
            myQuot.setQUO_HIST_PENS_INT_RATE(rs.getBigDecimal(90));
            myQuot.setQUO_CUR_SYMBOL(rs.getString(91));
            myQuot.setQUO_CURR_RATE_TYPE(rs.getString(92));
            myQuot.setQUO_CUR_RATE(rs.getBigDecimal(93));
            myQuot.setQUO_TENDER(rs.getString(94));
            myQuot.setQUO_AVG_EARNINGS(rs.getBigDecimal(95));
            myQuot.setQUO_TOT_CLAIM_PAID(rs.getBigDecimal(96));
            myQuot.setQUO_TOT_PREM_PAID(rs.getBigDecimal(97));
            myQuot.setQUO_PRD_TYPE(rs.getString(98));
            myQuot.setQUO_CLM_EXP_RATE(rs.getBigDecimal(99));
            myQuot.setQUO_PRP_CODE(rs.getBigDecimal(100));
            session.setAttribute("prpCode", rs.getBigDecimal(100));
            myQuot.setQUO_TENDER_PRD(rs.getBigDecimal(101));
            myQuot.setQUO_ASSIGNEE_NAME(rs.getString(102));
            myQuot.setQUO_ASSIGNEE_PHY_ADDR(rs.getString(103));
            myQuot.setSBU_CODE(rs.getBigDecimal(104));
            session.setAttribute("sbuCode",rs.getBigDecimal(104));
            myQuot.setSPOKE_CODE(rs.getBigDecimal(105));
            session.setAttribute("spokeCode",rs.getBigDecimal(105));
            myQuot.setCOVERAGE_AREA_CODE(rs.getBigDecimal(106));
            session.setAttribute("coverageAreaCode",rs.getBigDecimal(106));
            myQuot.setLOCATION_CODE(rs.getBigDecimal(107));
            session.setAttribute("locationCode",rs.getBigDecimal(107));
            myQuot.setCOVERAGE_AREA(rs.getString(108));
            myQuot.setLOCATION(rs.getString(109));
          
            quotDAO.add(myQuot);
          }
          rs.close();
          cst.close();
          conn.close();
    
    }
    catch(Exception e) {
              e.printStackTrace();
            GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
  return quotDAO;
}   
  
  public List<QuotationsDetails> findQuotationTaxes()
  {

    DBConnector myConn=new DBConnector();
    Connection conn=myConn.getDatabaseConn();
    CallableStatement cst=null;
    List<QuotationsDetails> quotDAO=new ArrayList<QuotationsDetails>();
    
    try {
        String quotQuery="begin LMS_WEB_CURSOR_GRP.quotationtaxes(?,?,?,?);end;";
        cst=conn.prepareCall(quotQuery);
          cst.registerOutParameter(1,OracleTypes.CURSOR);
          cst.setBigDecimal(2,(BigDecimal)session.getAttribute("QuoteCode"));
          cst.setString(3,null);
          cst.setString(4,null);
          //System.out.println("entered Procedure: " + Quotation.quotationCode);
      
          cst.execute();
          ResultSet rs=(ResultSet)cst.getObject(1);
          while(rs.next()) {

            QuotationsDetails myQuot=new QuotationsDetails();
            //System.out.println("entered Procedure");            
            myQuot.setQtax_code(rs.getBigDecimal(1));
            myQuot.setQtax_rate(rs.getString(2));
            myQuot.setQtax_tax_amt(rs.getBigDecimal(3));
            myQuot.setTt_desc(rs.getString(4));
            myQuot.setQTAX_RATE_TYPE(rs.getString(5));
            myQuot.setPtx_appl_level(rs.getString(6));
            myQuot.setCvt_desc(rs.getString(7));            
            myQuot.setTax_plan(rs.getString(8));
            quotDAO.add(myQuot);
          }
          rs.close();
          cst.close();
          conn.close();
    
    }
    catch(Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
  return quotDAO;
  }
  public List<QuotationsDetails> findClientClaimExp() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        List<QuotationsDetails> claimExp = new ArrayList<QuotationsDetails>();

        try {
            String quotQuery =
                "begin LMS_WEB_CURSOR_GRP.find_client_claimexp(?,?,?,?);end;";
            cst = conn.prepareCall(quotQuery);
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setBigDecimal(2, (BigDecimal)session.getAttribute("prpCode"));
            if (session.getAttribute("wef") == null) {
              cst.setString(3,null);
            } else {
                cst.setString(3, (String)session.getAttribute("wef"));
            }

            if (session.getAttribute("wet") == null) {
                cst.setString(4, null);
                System.out.println("testing" + session.getAttribute("wet"));
            } else {
                cst.setString(4, (String)session.getAttribute("wet"));
            }
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                QuotationsDetails clnt_clmExp = new QuotationsDetails();
                clnt_clmExp.setPROD_DESC(rs.getString(1));
                clnt_clmExp.setLTR_CLM_NO(rs.getString(2));
                clnt_clmExp.setCLIENT(rs.getString(3));
                clnt_clmExp.setLTR_POL_POLICY_NO(rs.getString(4));
                clnt_clmExp.setMEMBER_DISP(rs.getString(5));
                clnt_clmExp.setLTR_TRANS_NO(rs.getBigDecimal(6));
                clnt_clmExp.setLTR_BTR_TRANS_CODE(rs.getString(7));
                clnt_clmExp.setCLM_CAUS_TYPE(rs.getString(8));
                clnt_clmExp.setCLM_AUTHORISED(rs.getString(9));
                clnt_clmExp.setCLAIM_STATUS(rs.getString(10));
                clnt_clmExp.setAMT_CLAIMED(rs.getBigDecimal(11));
                clnt_clmExp.setAMT_TO_PAY(rs.getBigDecimal(12));
              claimExp.add(clnt_clmExp);            
            }
            rs.close();
            cst.close();
            conn.close();

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return claimExp;
    }
  
  public List<QuotationsDetails> FindSBUDetails() {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    ResultSet rst = null;

    List<QuotationsDetails> SettingsList = new ArrayList<QuotationsDetails>();


    try {

      String SBUQuery = "BEGIN LMS_SETUPS_CURSOR.getSBUDetails(?);END;";
      cst = conn.prepareCall(SBUQuery);
      cst.registerOutParameter(1, OracleTypes.CURSOR);

      cst.execute();
      rst = (ResultSet)cst.getObject(1);
      while (rst.next()) {
        QuotationsDetails mySettings = new QuotationsDetails();
         
        mySettings.setCOVERAGE_AREA(rst.getString(1));
        mySettings.setSPOKE(rst.getString(2));
        mySettings.setSBU(rst.getString(3));
        mySettings.setCOVERAGE_AREA_CODE(rst.getBigDecimal(4));
        mySettings.setSPOKE_CODE(rst.getBigDecimal(5));
        mySettings.setSBU_CODE(rst.getBigDecimal(6));
       
        SettingsList.add(mySettings);

      }
      rst.close();
      cst.close();
      conn.close();

    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    } finally {
      GlobalCC.CloseConnections(rst, cst, conn);
    }
    return SettingsList;
  }
  public List<QuotationsDetails> FindOrgLocationsDetails() {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    ResultSet rst = null;

    List<QuotationsDetails> SettingsList = new ArrayList<QuotationsDetails>();


    try {

      String LOCQuery = "BEGIN LMS_SETUPS_CURSOR.getOrgLocationsDetails(?);END;";
      cst = conn.prepareCall(LOCQuery);
      cst.registerOutParameter(1, OracleTypes.CURSOR);

      cst.execute();
      rst = (ResultSet)cst.getObject(1);
      while (rst.next()) {
        QuotationsDetails mySettings = new QuotationsDetails();
         
        mySettings.setLOCATION(rst.getString(1));
        mySettings.setORGANIZATION(rst.getString(2));
        mySettings.setLOCATION_CODE(rst.getBigDecimal(3));             
        SettingsList.add(mySettings);

      }
      rst.close();
      cst.close();
      conn.close();

    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    } finally {
      GlobalCC.CloseConnections(rst, cst, conn);
    }
    return SettingsList;
  }
}