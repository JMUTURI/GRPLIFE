package com.turnkey.setups;

import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import oracle.jdbc.OracleTypes;

import LMSG.view.Base.GlobalCC;

import LMSG.view.connect.DBConnector;

public class ProductSetupDAO {
    public ProductSetupDAO() {
        super();
    }
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    public List<ProductSetup> findGroupProducts() {
        
        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<ProductSetup> SetupArray = new ArrayList<ProductSetup>();
        try {
           
                String msgQuery = 
                    "begin LMS_SETUPS_CURSOR.findGroupProducts(?); end;";
                cst = conn.prepareCall(msgQuery);
                      
             cst.registerOutParameter(1, 
                                     OracleTypes.CURSOR);
             cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                ProductSetup set = new ProductSetup();
                set.setPROD_CODE(rs.getBigDecimal(1));
                set.setPROD_SHT_DESC(rs.getString(2));
                set.setPROD_MIN_AGE_LIMIT_YRS(rs.getBigDecimal(3));
                set.setPROD_MIN_TERM_YRS(rs.getBigDecimal(4));
                set.setPROD_POL_CODE_FIX(rs.getString(5));
                set.setPROD_REIN_MAX_PRD_DAYS(rs.getBigDecimal(6));
                set.setPROD_DEFAULT_DOB(rs.getDate(7));
                set.setPROD_DEPENDT_COVERED(rs.getString(8));
                set.setPROD_DEBIT_ACC_NO(rs.getString(9));
                set.setPROD_EXPECTED_SCH_RECPT_DAY(rs.getString(10));
                set.setPROD_EXTENTION_ALLOWED(rs.getString(11));
                set.setPROD_SCH_ADJ_PERIOD(rs.getBigDecimal(12));
                set.setPROD_MAX_EXT_PERIOD(rs.getBigDecimal(13));
                set.setPROD_GL_CONTROL_CODE(rs.getString(14));
                set.setPROD_LOAN_GRACE_PRD(rs.getString(15));
                set.setPROD_DESC(rs.getString(16));
                set.setPROD_PAY_GRATUITY(rs.getString(17));
                set.setPROD_ANNUITY_ALLOWED(rs.getString(18));
                set.setPROD_PROP_CODE_FIX(rs.getString(19));
                set.setPROD_LOAN_PRODUCT(rs.getString(20));
                set.setPROD_REFUND_COMM(rs.getString(21));
                set.setPROD_UNIT_RATE_APPLICABLE(rs.getString(22));
                set.setPROD_GEN_POL_NO(rs.getString(23));
                set.setPROD_RENEWAL_ALLOWED(rs.getString(24));
                set.setPROD_PROFIT_SHARE_RATE_PERC(rs.getBigDecimal(25));
                set.setPROD_ADD_REF_PREM_PERC(rs.getBigDecimal(26));
                set.setPROD_MAX_AGE_LIMIT_YRS(rs.getBigDecimal(27));
                set.setPROD_CLM_CODE_FIX(rs.getString(28));
                set.setPROD_CANC_NOTICE_DAYS(rs.getString(29));
                set.setPROD_SAVINGS_COVERED(rs.getString(30));
                set.setPROD_REFUND_ALLOWED(rs.getString(31));
                set.setPROD_PARTIAL_CANCEL_ALLOWED(rs.getString(32));
                set.setPROD_APPLICABLE_LAPSE_TYPE(rs.getString(33));
                set.setPROD_MINIMUM_FCL_MEMBERS(rs.getBigDecimal(34));
                set.setPROD_FCL_FACTOR1(rs.getBigDecimal(35));
                set.setPROD_FCL_FACTOR2(rs.getBigDecimal(36));
                set.setPROD_GRP_RATES_MIN(rs.getBigDecimal(37));
                set.setPROD_EMP_FUND_PAY_PRD(rs.getBigDecimal(38));
                set.setPROD_TYPE(rs.getString(39));
                set.setPROD_MAX_TERM_YRS(rs.getBigDecimal(40));
                set.setPROD_OPEN_COVER(rs.getString(41));
                set.setPROD_XOL_SETUP(rs.getString(42));
                set.setPROD_OS_LOAN_CALC(rs.getString(43));
                set.setPROD_INITIAL_SCH_ENDRSE(rs.getString(44));
                set.setPROD_CLAIM_EXPIRY_PRD(rs.getBigDecimal(45));
                set.setPROD_MIN_EARNINGS_PRD(rs.getBigDecimal(46));
                set.setPROD_FCL_MAX_AMT(rs.getBigDecimal(47));
                set.setPROD_REMARKS(rs.getString(48));
                set.setPROD_EMV_CALCULATION_TYPE(rs.getString(49));
                set.setPROD_VAL_INTR_CALC_MODE(rs.getString(50));
                set.setPROD_EXC_NOT_AGE(rs.getString(76));
                set.setPROD_EXC_NOT_SA(rs.getString(77));
                set.setPROD_WEF(rs.getDate(78));
                set.setPROD_STATUS(rs.getString(79));
                set.setWeeklyIndemnity(rs.getString(80));
                set.setPROD_EARNING_PRD_TYPE(rs.getString(81));
                set.setPROD_FCL_CALC_TYPE(rs.getString(82));
                set.setPROD_PENS_TYPE(rs.getString(83));
                set.setPROD_PENS_CONTRI_LIMIT(rs.getString(84));
                set.setPROD_LOAN_GUARD(rs.getString(85));
                set.setPROD_QUO_EXPIRY_PRD(rs.getBigDecimal(86));
                set.setPROD_FMS_RECEIPTING(rs.getString(87));
                set.setPROD_FCL_SA_FORMULA(rs.getString(88));
                set.setPROD_RATE_TYPE(rs.getString(89));
                set.setPROD_MED_GRACE_PERIOD(rs.getBigDecimal(90));
              
                
                SetupArray.add(set);
            }
            rs.close();
            conn.close();

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn,e);
        }            
      
        return SetupArray;
    }
    public List<ProductSetup> findGroupDeathAcceptable() {
        
        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<ProductSetup> SetupArray = new ArrayList<ProductSetup>();
        try {
           
                String msgQuery = 
                    "begin LMS_SETUPS_CURSOR.findGroupDeathAcceptable(?,?); end;";
                cst = conn.prepareCall(msgQuery);
                      
             cst.registerOutParameter(1, 
                                     OracleTypes.CURSOR);
            cst.setBigDecimal(2,(BigDecimal)session.getAttribute("PRODCode"));
             cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                ProductSetup set = new ProductSetup();
                set.setPDA_CODE(rs.getBigDecimal(1));
                set.setPDA_GRP_TOT_NO(rs.getBigDecimal(2));
                set.setLMS_PROD_DEATH_ACCEPTABLE(rs.getBigDecimal(3));
               
                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn,e);
        }            
      
        return SetupArray;
    }
    public List<ProductSetup> findGroupPremiumFractions() {
        
        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<ProductSetup> SetupArray = new ArrayList<ProductSetup>();
        try {
           
                String msgQuery = 
                    "begin LMS_SETUPS_CURSOR.findGroupProducts(?,?); end;";
                cst = conn.prepareCall(msgQuery);
                      
             cst.registerOutParameter(1, 
                                     OracleTypes.CURSOR);
            cst.setBigDecimal(2,(BigDecimal)session.getAttribute("PRODCode"));
             cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                ProductSetup set = new ProductSetup();
                set.setPROD_MNTH_TO_QTR_FCTOR(rs.getBigDecimal(51));
                set.setPROD_MNTH_TO_S_ANNL_FCTOR(rs.getBigDecimal(52));
                //set.setLMS_PROD_DEATH_ACCEPTABLE(rs.getBigDecimal(53));
                set.setPROD_MNTH_TO_ANNL_FCTOR(rs.getBigDecimal(53));
                set.setPROD_YR_TO_MONTH_RATE(rs.getBigDecimal(54));
                set.setPROD_YR_TO_S_ANNL_RATE(rs.getBigDecimal(55));
                set.setPROD_YR_TO_QUATER_RATE(rs.getBigDecimal(56));
                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn,e);
        }            
      
        return SetupArray;
    }
    public List<ProductSetup> findGroupScheduleReports() {
        
        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<ProductSetup> SetupArray = new ArrayList<ProductSetup>();
        try {
           
                String msgQuery = 
                    "begin LMS_SETUPS_CURSOR.findGroupProducts(?,?); end;";
                cst = conn.prepareCall(msgQuery);
                      
             cst.registerOutParameter(1, 
                                     OracleTypes.CURSOR);
            cst.setBigDecimal(2,(BigDecimal)session.getAttribute("PRODCode"));
             cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                ProductSetup set = new ProductSetup();
                set.setPROD_QUO_COSTING_SCH_RPT(rs.getString(57));
                set.setPROD_QUO_SAVINGS_SCH_RPT(rs.getString(58));
                set.setPROD_QUO_FE_SCH_RPT(rs.getString(59)); 
                set.setPROD_QUO_AGGR_DTLS_RPT(rs.getString(60));
                set.setPROD_UW_COSTING_SCH_RPT(rs.getString(61));
                set.setPROD_UW_SAVING_SCH_RPT(rs.getString(62));
                set.setPROD_UW_FE_SCH_RPT(rs.getString(63));
                set.setPROD_UW_REFUND_SCH_RPT(rs.getString(64));
                set.setPROD_POL_COSTING_SCH_RPT(rs.getString(65));
                set.setPROD_POL_SAVING_SCH_RPT(rs.getString(66));
                set.setPROD_POL_FE_SCH_RPT(rs.getString(67));
                set.setPROD_REN_COSTING_SCH_RPT(rs.getString(68));
                set.setPROD_REN_SAVING_SCH_RPT(rs.getString(69));
                set.setPROD_REN_FE_SCH_RPT(rs.getString(70));
                set.setPROD_QUO_AGGR_LETT(rs.getString(91));
                
                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn,e);
        }            
      
        return SetupArray;
    }
    public List<ProductSetup> findLapsation() {
        
        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<ProductSetup> SetupArray = new ArrayList<ProductSetup>();
        try {
           
                String msgQuery = 
                    "begin LMS_SETUPS_CURSOR.findGroupProducts(?,?); end;";
                cst = conn.prepareCall(msgQuery);
                      
             cst.registerOutParameter(1, 
                                     OracleTypes.CURSOR);
            cst.setBigDecimal(2,(BigDecimal)session.getAttribute("PRODCode"));
             cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                ProductSetup set = new ProductSetup();
                set.setPROD_MONTHLY_LAPSE_PRD(rs.getString(71));
                //set.setPROD_MONTHLY_LAPSE_PRD(rs.getString(72));
                set.setPROD_QUARTER_LAPSE_PRD(rs.getString(72));
                set.setPROD_SEMI_A_LAPSE_PRD(rs.getString(73));
                set.setPROD_ANNUALLY_LAPSE_PRD(rs.getString(74));
                set.setPROD_LAPSE_PRD_DAYS(rs.getString(75));
               
                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn,e);
        }            
      
        return SetupArray;
    }
    public List<ProductSetup> findPolicyDocuments() {
        
        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<ProductSetup> SetupArray = new ArrayList<ProductSetup>();
        try {
           
                String msgQuery = 
                    "begin LMS_SETUPS_CURSOR.findPolicyDocuments(?,?); end;";
                cst = conn.prepareCall(msgQuery);
                      
             cst.registerOutParameter(1, 
                                     OracleTypes.CURSOR);
            cst.setBigDecimal(2,(BigDecimal)session.getAttribute("PRODCode"));
             cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                ProductSetup set = new ProductSetup();
                set.setPSPD_TYPE(rs.getString(1));
                //set.setPROD_MONTHLY_LAPSE_PRD(rs.getString(72));
                set.setPSPD_DOC_NAME(rs.getString(2));
                set.setPSPD_CODE(rs.getBigDecimal(3));
                set.setPSPD_TYPE_DESC(rs.getString(4));
                
               
                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn,e);
        }            
      
        return SetupArray;
    }
    public List<ProductSetup> findProductExceptions() {
        
        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<ProductSetup> SetupArray = new ArrayList<ProductSetup>();
        try {
           
                String msgQuery = 
                    "begin LMS_SETUPS_CURSOR.findGroupProducts(?,?); end;";
                cst = conn.prepareCall(msgQuery);
                      
             cst.registerOutParameter(1, 
                                     OracleTypes.CURSOR);
            cst.setBigDecimal(2,(BigDecimal)session.getAttribute("PRODCode"));
             cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                ProductSetup set = new ProductSetup();
                set.setPROD_EXC_NOT_AGE(rs.getString(76));
                set.setPROD_EXC_NOT_SA(rs.getString(77));
                //set.setLMS_PROD_DEATH_ACCEPTABLE(rs.getBigDecimal(3));
               
                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn,e);
        }            
      
        return SetupArray;
    }
}
