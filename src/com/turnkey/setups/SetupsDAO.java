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

import LMSG.view.setups.PremiumMaskItems;

public class SetupsDAO {
    public SetupsDAO() {
        super();
    }

  private BigDecimal ClassSchLevel;
  private String currSymbol;
  
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);


    public List<Setup> findClassesofBusiness() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.find_classes_of_business(?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();
                set.setCLA_CODE(rs.getBigDecimal(1));
                set.setCLA_SHT_DESC(rs.getString(2));
                set.setCLA_DESC(rs.getString(3));
                set.setCLA_TYPE(rs.getString(4));
                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findSequenceTypes() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.find_sequence_types(?,?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setBigDecimal(2, (BigDecimal)session.getAttribute("ClaCode"));
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();

                set.setLST_CODE(rs.getBigDecimal(1));
                set.setLST_SHT_DESC(rs.getString(2));
                set.setLST_DESC(rs.getString(3));
                set.setLST_TYPE(rs.getString(4));
                set.setLST_TYPE_DESC(rs.getString(5));
                set.setLST_SEQ_NO_LEN(rs.getString(6));
                set.setLST_SEPARATOR(rs.getString(7));
                set.setLST_WEF(rs.getDate(8));
                set.setLST_WET(rs.getDate(9));
                set.setLST_TEXT(rs.getString(10));
                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findSequenceTemplates() {

        DBConnector datahandler = new DBConnector();
        Connection conn = null;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.find_sequence_templates(?,?,?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setBigDecimal(2, (BigDecimal)session.getAttribute("LstCode"));
            cst.setBigDecimal(3, (BigDecimal)session.getAttribute("ClaCode"));
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();


                set.setLNT_CODE(rs.getBigDecimal(1));
                set.setLNT_ORDER(rs.getString(2));
                set.setLNT_ITEM_ID(rs.getString(3));

                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findProductSeqTemplates() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.find_sequence_products(?,?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setBigDecimal(2, (BigDecimal)session.getAttribute("LstCode"));
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();


                set.setPST_CODE(rs.getBigDecimal(1));
                set.setPROD_CODE(rs.getBigDecimal(2));
                set.setPROD_SHT_DESC(rs.getString(3));
                set.setPROD_DESC(rs.getString(4));

                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findProducts() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.find_products(?,?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setBigDecimal(2, (BigDecimal)session.getAttribute("ClaCode"));
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();

                set.setPROD_CODE(rs.getBigDecimal(1));
                set.setPROD_DESC(rs.getString(2));
                set.setPROD_SHT_DESC(rs.getString(3));
                set.setPROD_TYPE(rs.getString(4));
                set.setProductCode(rs.getBigDecimal(1));
                set.setProductName(rs.getString(2));
                set.setPROD_COMM_CVR_PARAM(null);

                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findAllProducts() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.find_all_products(?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();

                set.setPROD_CODE(rs.getBigDecimal(1));
                set.setPROD_DESC(rs.getString(2));
                set.setPROD_SHT_DESC(rs.getString(3));
                set.setPROD_TYPE(rs.getString(4));

                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findAllProductsAndMasks() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<PremiumMaskItems> PremMaskItems = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.find_all_products(?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                PremMaskItems = new ArrayList<PremiumMaskItems>();
                Setup set = new Setup();

                set.setPROD_CODE(rs.getBigDecimal(1));
                set.setPROD_DESC(rs.getString(2));
                set.setPROD_SHT_DESC(rs.getString(3));
                set.setPROD_TYPE(rs.getString(4));
                set.setType("P");
                CallableStatement stmt2 =
                    conn.prepareCall("begin LMS_SETUPS_CURSOR.find_premium_masks(?,?); end;");
                stmt2.registerOutParameter(1, OracleTypes.CURSOR);
                stmt2.setBigDecimal(2, rs.getBigDecimal(1));
                stmt2.execute();
                ResultSet rst = (ResultSet)stmt2.getObject(1);
                while (rst.next()) {
                    PremiumMaskItems set1 = new PremiumMaskItems();
                    set1.setPMAS_CODE(rst.getBigDecimal(1));
                    set1.setPMAS_SHT_DESC(rst.getString(2));
                    set1.setPMAS_DESC(rst.getString(3));
                    set1.setPMAS_DEFAULT(rst.getString(4));
                    set1.setPMAS_DEFAULT_DESC(rst.getString(5));
                    set1.setPMAS_COMMENT(rst.getString(6));
                    set1.setType("S");
                    PremMaskItems.add(set1);
                }
                set.setPremiumMaskItem(PremMaskItems);
                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findAllProductsAndSchClasses() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<SchoolClassItems> SchClassItems = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.find_all_products(?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                SchClassItems = new ArrayList<SchoolClassItems>();
                Setup set = new Setup();

                set.setPROD_CODE(rs.getBigDecimal(1));
                set.setPROD_DESC(rs.getString(2));
                set.setPROD_SHT_DESC(rs.getString(3));
                set.setPROD_TYPE(rs.getString(4));
                set.setType("P");

                CallableStatement stmt2 =
                    conn.prepareCall("begin LMS_WEB_CURSOR_GRP.findProdSchoolClasses(?,?); end;");
                stmt2.registerOutParameter(1, OracleTypes.CURSOR);
                stmt2.setBigDecimal(2, rs.getBigDecimal(1));
                stmt2.execute();
                ResultSet rst = (ResultSet)stmt2.getObject(1);
                while (rst.next()) {
                    SchoolClassItems set1 = new SchoolClassItems();

                    set1.setSCH_CODE(rst.getBigDecimal(1));
                    set1.setSCH_SHT_DESC(rst.getString(2));
                    set1.setSCH_DESC(rst.getString(3));
                    set1.setSCH_PERIOD(rst.getBigDecimal(4));
                    set1.setSCH_LEVEL(rst.getBigDecimal(5));
                    set1.setType("S");
                    SchClassItems.add(set1);
                }
                set.setSchClassItem(SchClassItems);
                SetupArray.add(set);
            }
            rs.close();
            conn.close();

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findAllProductsAndCoverTypes() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<ProductCoverTypes> ProductCoverTypesItems = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.find_all_products(?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                ProductCoverTypesItems = new ArrayList<ProductCoverTypes>();
                Setup set = new Setup();

                set.setPROD_CODE(rs.getBigDecimal(1));
                set.setPROD_DESC(rs.getString(2));
                set.setPROD_SHT_DESC(rs.getString(3));
                set.setPROD_TYPE(rs.getString(4));
                set.setType("P");

                CallableStatement stmt2 =
                    conn.prepareCall("begin LMS_SETUPS_CURSOR.find_prod_covers(?,?); end;");
                stmt2.registerOutParameter(1, OracleTypes.CURSOR);
                stmt2.setBigDecimal(2, rs.getBigDecimal(1));
                stmt2.execute();
                ResultSet rst = (ResultSet)stmt2.getObject(1);
                while (rst.next()) {
                    ProductCoverTypes set1 = new ProductCoverTypes();

                    set1.setPCT_CODE(rst.getBigDecimal(1));
                    set1.setPCT_CVT_CODE(rst.getBigDecimal(2));
                    set1.setPCT_CVT_DESC(rst.getString(3));
                    set1.setPCT_CVT_SHT_DESC(rst.getString(4));
                    set1.setType("S");
                    ProductCoverTypesItems.add(set1);
                }
                set.setPctItem(ProductCoverTypesItems);
                SetupArray.add(set);
            }
            rs.close();
            conn.close();

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findSchClasses() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_WEB_CURSOR_GRP.findProdSchoolClasses(?,?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setBigDecimal(2,
                              (BigDecimal)session.getAttribute("ProductCode"));

            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();


                set.setSCH_CODE(rs.getBigDecimal(1));
                set.setSCH_SHT_DESC(rs.getString(2));
                set.setSCH_DESC(rs.getString(3));
                set.setSCH_PERIOD(rs.getBigDecimal(4));
                set.setSCH_LEVEL(rs.getBigDecimal(5));
                set.setSLVL_TERM_DURATION(rs.getBigDecimal(6));

                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findQuotePolClasses() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_WEB_CURSOR_GRP.findQuotePolschoolclasses(?,?,?,?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setBigDecimal(2,
                              (BigDecimal)session.getAttribute("ProductCode"));
            String custa = (String)session.getAttribute("CurrentStatus");
            if (custa.equalsIgnoreCase("Q")) {
                cst.setBigDecimal(3,
                                  (BigDecimal)session.getAttribute("QuoteCode")); //Quotation Code
                cst.setString(4, "Q");
            } else {
                cst.setBigDecimal(3,
                                  (BigDecimal)session.getAttribute("endorsementCode"));
                cst.setString(4, "P");
            }
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();
                set.setSCH_CODE(rs.getBigDecimal(1));
                set.setSCH_SHT_DESC(rs.getString(2));
                set.setSCH_DESC(rs.getString(3));
                set.setSCH_PERIOD(rs.getBigDecimal(4));
                set.setSCH_LEVEL(rs.getBigDecimal(5));
                set.setSLVL_TERM_DURATION(rs.getBigDecimal(6));
                set.setSCH_FEES(null);
                set.setSCH_AV_STUDENTS(null);
                set.setSelected(false);

                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findSchoolLevels() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_WEB_CURSOR_GRP.find_school_levels(?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();

                set.setSLVL_CODE(rs.getBigDecimal(1));
                set.setSLVL_SHT_DESC(rs.getString(2));
                set.setSLVL_DESC(rs.getString(3));
                set.setSLVL_PERIOD(rs.getString(4));
                set.setSLVL_NO_TERMS(rs.getBigDecimal(5));
                set.setSLVL_TERM_DURATION(rs.getBigDecimal(6));

                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findAccountTypes() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.find_acc_types(?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();

                set.setACT_CODE(rs.getBigDecimal(1));
                set.setACT_TYPE_SHT_DESC(rs.getString(2));
                set.setACT_TYPE_ID(rs.getString(3));
                set.setACT_ACCOUNT_TYPE(rs.getString(4));


                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findAccountRates() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.find_acc_rates(?,?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setBigDecimal(2, (BigDecimal)session.getAttribute("ActCode"));
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();

                set.setATR_CODE(rs.getBigDecimal(1));
                set.setATR_ACT_CODE(rs.getBigDecimal(2));
                set.setATR_SHT_DESC(rs.getString(3));
                set.setATR_DESC(rs.getString(4));
                set.setATR_WEF(rs.getDate(5));
                set.setATR_WET(rs.getDate(6));
                set.setATR_TYPE(rs.getString(7));
                set.setATR_TYPE_DESC(rs.getString(8));


                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findCommissionRates() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.find_comm_rates(?,?,?,?,?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setBigDecimal(2, (BigDecimal)session.getAttribute("ActCode"));
            cst.setBigDecimal(3,
                              (BigDecimal)session.getAttribute("ProductCode"));
            cst.setBigDecimal(4, (BigDecimal)session.getAttribute("AtrCode"));
            cst.setBigDecimal(5, (BigDecimal)session.getAttribute("pctCode"));
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();

                set.setCRAT_CODE(rs.getBigDecimal(1));
                set.setCRAT_AT_CODE(rs.getBigDecimal(2));
                set.setCRAT_AT_SHT_DESC(rs.getString(3));
                set.setCRAT_PROD_CODE(rs.getString(4));
                set.setCRAT_RANGE_FROM(rs.getString(5));
                set.setCRAT_RANGE_TO(rs.getString(6));
                set.setCRAT_RATE(rs.getString(7));
                set.setCRAT_RATE_DESC(rs.getString(8));
                set.setCRAT_DIVISION_FACTOR(rs.getString(9));
                set.setCRAT_PAY_FREQ(rs.getString(10));
                set.setCRAT_RATE_TYPE(rs.getString(11));
                set.setCRAT_TERM_FROM(rs.getString(12));
                set.setCRAT_TERM_TO(rs.getString(13));
                set.setCRAT_YR_NO_FROM(rs.getString(14));
                set.setCRAT_YR_NO_TO(rs.getString(15));
                set.setCRAT_WEF_DATE(rs.getDate(16));
                set.setCRAT_WET_DATE(rs.getDate(17));
                set.setCRAT_PCT_CODE(rs.getBigDecimal(18));
                set.setCRAT_ATR_CODE(rs.getBigDecimal(19));
                set.setCRAT_ANB_FROM(rs.getString(20));
                set.setCRAT_ANB_TO(rs.getString(21));
                set.setCRAT_MATURITY_AGE(rs.getString(22));

                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findPensionCommissionRates() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.find_pens_comm_rates(?,?,?,?,?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setBigDecimal(2, (BigDecimal)session.getAttribute("ActCode"));
            cst.setBigDecimal(3,
                              (BigDecimal)session.getAttribute("ProductCode"));
            cst.setBigDecimal(4, (BigDecimal)session.getAttribute("AtrCode"));
            cst.setBigDecimal(5, (BigDecimal)session.getAttribute("pctCode"));
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();

                set.setCRAT_CODE(rs.getBigDecimal(1));
                set.setCRAT_AT_CODE(rs.getBigDecimal(2));
                set.setCRAT_AT_SHT_DESC(rs.getString(3));
                set.setCRAT_PROD_CODE(rs.getString(4));
                set.setCRAT_RANGE_FROM(rs.getString(5));
                set.setCRAT_RANGE_TO(rs.getString(6));
                set.setCRAT_RATE(rs.getString(7));
                set.setCRAT_RATE_DESC(rs.getString(8));
                set.setCRAT_DIVISION_FACTOR(rs.getString(9));
                set.setCRAT_PAY_FREQ(rs.getString(10));
                set.setCRAT_RATE_TYPE(rs.getString(11));
                set.setCRAT_TERM_FROM(rs.getString(12));
                set.setCRAT_TERM_TO(rs.getString(13));
                set.setCRAT_YR_NO_FROM(rs.getString(14));
                set.setCRAT_YR_NO_TO(rs.getString(15));
                set.setCRAT_WEF_DATE(rs.getDate(16));
                set.setCRAT_WET_DATE(rs.getDate(17));
                set.setCRAT_PCT_CODE(rs.getBigDecimal(18));
                set.setCRAT_ATR_CODE(rs.getBigDecimal(19));
                set.setCRAT_ANB_FROM(rs.getString(20));
                set.setCRAT_ANB_TO(rs.getString(21));
                set.setCRAT_MATURITY_AGE(rs.getString(22));


                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findCommissionAnnualisation() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.find_comm_annualisation(?,?,?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setBigDecimal(2, (BigDecimal)session.getAttribute("ActCode"));
            cst.setBigDecimal(3,
                              (BigDecimal)session.getAttribute("ProductCode"));
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();

                set.setACR_CODE(rs.getBigDecimal(1));
                set.setACR_PROD_CODE(rs.getBigDecimal(2));
                set.setACR_ACT_CODE(rs.getBigDecimal(3));
                set.setACR_ANN_RATE(rs.getString(4));
                set.setACR_ANN_BAL_RATE(rs.getString(5));
                set.setACR_ANN_ANNUALISATION_DURATION(rs.getString(6));
                set.setACR_ANN_BAL_PYMT_MNTH(rs.getString(7));
                set.setACR_WEF_DATE(rs.getDate(8));
                set.setACR_WET_DATE(rs.getDate(9));


                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findClawBackRates() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.find_clawback_rates(?,?,?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setBigDecimal(2, (BigDecimal)session.getAttribute("ActCode"));
            cst.setBigDecimal(3,
                              (BigDecimal)session.getAttribute("ProductCode"));
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();


                set.setCCLR_CODE(rs.getBigDecimal(1));
                set.setCCLR_PROD_CODE(rs.getBigDecimal(2));
                set.setCCLR_ACT_CODE(rs.getBigDecimal(3));
                set.setCCLR_MNTH_FROM(rs.getString(4));
                set.setCCLR_MNTH_TO(rs.getString(5));
                set.setCCLR_CLAWBCK_RATE(rs.getString(6));
                set.setCCLR_CLAWBCK_RATE_TYPE(rs.getString(7));
                set.setCCLR_CLAWBCK_DIV_FACT(rs.getString(8));
                set.setCCLR_WEF_DATE(rs.getDate(9));
                set.setCCLR_WET_DATE(rs.getDate(10));


                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findinterfacePayElements() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.find_interface_pay_elements(?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();


                set.setCPE_CODE(rs.getBigDecimal(1));
                set.setCPE_PAY_ELEMENT(rs.getString(2));
                set.setCPE_CR(rs.getString(3));
                set.setCPE_DR(rs.getString(4));
                set.setCPE_WEF(rs.getDate(5));
                set.setCPE_WET(rs.getDate(6));
                set.setCPE_RATE(rs.getString(7));


                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findAgentBonusRates() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.find_agent_bonus_rates(?,?,?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setBigDecimal(2, (BigDecimal)session.getAttribute("ActCode"));
            cst.setBigDecimal(3, (BigDecimal)session.getAttribute("ClaCode"));
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();


                set.setBRAT_CODE(rs.getBigDecimal(1));
                set.setBRAT_CLA_CODE(rs.getBigDecimal(2));
                set.setBRAT_ACT_CODE(rs.getBigDecimal(3));
                set.setBRAT_PERSISTENCY_FROM(rs.getString(4));
                set.setBRAT_PERSISTENCY_TO(rs.getString(5));
                set.setBRAT_MNTH_FROM(rs.getString(6));
                set.setBRAT_MNTH_TO(rs.getString(7));
                set.setBRAT_CALC_PERIOD(rs.getString(8));
                set.setBRAT_BONUS_RATE(rs.getString(9));
                set.setBRAT_BONUS_RATE_TYPE(rs.getString(10));
                set.setBRAT_BONUS_DIV_FACT(rs.getString(11));
                set.setBRAT_WEF_DATE(rs.getDate(12));
                set.setBRAT_WET_DATE(rs.getDate(13));


                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findAgentRecoveryRates() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.find_agent_recovery_rates(?,?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setBigDecimal(2, (BigDecimal)session.getAttribute("ActCode"));
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();


                set.setAPR_CODE(rs.getBigDecimal(1));
                set.setAPR_ACT_CODE(rs.getBigDecimal(2));
                set.setAPR_INTEREST_RATE(rs.getString(3));
                set.setAPR_INTEREST_DIV_FAC(rs.getString(4));
                set.setAPR_COMM_RECVRY_PECT(rs.getString(5));
                set.setAPR_COMM_RECVRY_DIV_FAC(rs.getString(6));
                set.setAPR_MIN_ADV_ALLOWED(rs.getString(7));
                set.setAPR_COMM_PAYBLE_PECT(rs.getString(8));
                set.setAPR_COMM_PAYBLE_DIV_FAC(rs.getString(9));
                set.setAPR_ADV_CALC_RANGE_FROM(rs.getString(10));
                set.setAPR_ADV_CALC_RANGE_TO(rs.getString(11));
                set.setAPR_AVER_SUM_GROSS_COMM(rs.getString(12));
                set.setAPR_GROSS_COMM_PERIOD(rs.getString(13));
                set.setWEF(rs.getDate(14));
                set.setWET(rs.getDate(15));


                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findCommissionAllowances() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.find_agent_comm_allowances(?,?,?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setBigDecimal(2, (BigDecimal)session.getAttribute("ActCode"));
            cst.setBigDecimal(3, (BigDecimal)session.getAttribute("ClaCode"));
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();

                set.setCAL_CODE(rs.getBigDecimal(1));
                set.setCAL_ACT_CODE(rs.getBigDecimal(2));
                set.setCAL_CLA_CODE(rs.getBigDecimal(3));
                set.setCAL_ALLOWANCE_TYPE(rs.getString(4));
                set.setCAL_ALLOWANCE_RATE(rs.getString(5));
                set.setCAL_ALLOWANCE_DIV_FAC(rs.getString(6));
                set.setCAL_COMP_FREQ(rs.getString(7));
                set.setCAL_WEF(rs.getDate(8));
                set.setCAL_WET(rs.getDate(9));
                set.setCAL_RANGE_FROM(rs.getString(10));
                set.setCAL_RANGE_TO(rs.getString(11));
                set.setCAL_DESC(rs.getString(12));


                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findPremiumMasks() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {
            String msgQuery =
                "begin LMS_SETUPS_CURSOR.find_premium_masks(?,?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setBigDecimal(2,
                              (BigDecimal)session.getAttribute("ProductCode"));
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();

                set.setPMAS_CODE(rs.getBigDecimal(1));
                set.setPMAS_SHT_DESC(rs.getString(2));
                set.setPMAS_DESC(rs.getString(3));
                set.setPMAS_DEFAULT(rs.getString(4));
                set.setPMAS_DEFAULT_DESC(rs.getString(5));
                set.setPMAS_COMMENT(rs.getString(6));
                set.setPMAS_RATE_TYPE(rs.getString(7));

                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findParameters() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.find_parameters(?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();

                set.setPARAM_CODE(rs.getBigDecimal(1));
                set.setPARAM_NAME(rs.getString(2));
                set.setPARAM_VALUE(rs.getString(3));
                set.setPARAM_DESC(rs.getString(4));
                set.setPARAM_VALUE2(rs.getString(5));
                set.setPARAM_PROD_SPECIFIC(rs.getString(6));

                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }
    
    public List<Setup> findProductParameters() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.find_prod_parameters(?,?,?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setBigDecimal(2,
                              (BigDecimal)session.getAttribute("ProductCode"));
            cst.setBigDecimal(3,
                              (BigDecimal)session.getAttribute("parameterCode"));
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();

                set.setLPP_CODE(rs.getBigDecimal(1));
                set.setLPP_NAME(rs.getString(2));
                set.setLPP_VALUE(rs.getString(3));

                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findFCLFactors() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.find_fcl_factors(?,?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setBigDecimal(2,
                              (BigDecimal)session.getAttribute("ProductCode"));
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();

                set.setFCL_CODE(rs.getBigDecimal(1));
                set.setFCL_LIVES_FROM(rs.getString(2));
                set.setFCL_LIVE_TO(rs.getString(3));
                set.setFCL_FCL_FACTOR(rs.getString(4));
                set.setFCL_LIMIT(rs.getString(5));
                set.setFCL_WEF(rs.getDate(6));
                set.setFCL_WET(rs.getDate(7));

                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findBusinessTransactions() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.find_business_trans(?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();

                set.setBTR_TRANS_CODE(rs.getString(1));
                set.setBTR_TRANS_TYPE(rs.getString(2));
                set.setBTR_DEBIT_CODE(rs.getString(3));
                set.setBTR_CREDIT_CODE(rs.getString(4));
                set.setBTR_CLM_UW(rs.getString(5));

                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findTaxTypes() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.find_tax_types(?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();


                set.setTT_CODE(rs.getBigDecimal(1));
                set.setTT_SHT_DESC(rs.getString(2));
                set.setTT_DESC(rs.getString(3));
                set.setTT_TYPE(rs.getString(4));
                set.setTT_TYPE_DESC(rs.getString(5));
                set.setTT_APPLICABLE_AT_PROD(rs.getString(6));
                set.setTT_APPLICABLE_DESC(rs.getString(7));
                set.setTT_RENEWAL_ENDOS(rs.getString(8));
                set.setTT_RENEWAL_ENDOS_DESC(rs.getString(9));
                set.setTT_APPLICATION_LEVEL(rs.getString(10));
                set.setTT_APPLICATION_LEVEL_DESC(rs.getString(11));
                set.setTT_REFUND_ON_CANC(rs.getString(12));
                set.setTT_REFUND_ON_CANC_DESC(rs.getString(13));
                set.setTT_ACC_NO(rs.getString(14));
                set.setTT_CONTRA_ACC(rs.getString(15));
                set.setExciseDuty(rs.getString(16));
                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findTaxTypesbyAppLevel() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.find_tax_types_by_app_lvl(?,?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setString(2, (String)session.getAttribute("taxtypeAppl"));
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();


                set.setTT_CODE(rs.getBigDecimal(1));
                set.setTT_SHT_DESC(rs.getString(2));
                set.setTT_DESC(rs.getString(3));
                set.setTT_TYPE(rs.getString(4));
                set.setTT_TYPE_DESC(rs.getString(5));
                set.setTT_APPLICABLE_AT_PROD(rs.getString(6));
                set.setTT_APPLICABLE_DESC(rs.getString(7));
                set.setTT_RENEWAL_ENDOS(rs.getString(8));
                set.setTT_RENEWAL_ENDOS_DESC(rs.getString(9));
                set.setTT_APPLICATION_LEVEL(rs.getString(10));
                set.setTT_APPLICATION_LEVEL_DESC(rs.getString(11));
                set.setTT_REFUND_ON_CANC(rs.getString(12));
                set.setTT_REFUND_ON_CANC_DESC(rs.getString(13));
                set.setTT_ACC_NO(rs.getString(14));
                set.setTT_CONTRA_ACC(rs.getString(15));

                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findTaxRates() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.find_tax_rates(?,?,?,?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setBigDecimal(2,
                              (BigDecimal)session.getAttribute("ProductCode"));
            cst.setBigDecimal(3, (BigDecimal)session.getAttribute("ttCode"));
            cst.setBigDecimal(4, (BigDecimal)session.getAttribute("pctCode"));

            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();


                set.setTRT_CODE(rs.getBigDecimal(1));
                set.setTRT_RANGE_FROM(rs.getString(2));
                set.setTRT_RANGE_TO(rs.getString(3));
                set.setTRT_AGE_FROM(rs.getString(4));
                set.setTRT_AGE_TO(rs.getString(5));
                set.setTRT_RATE(rs.getString(6));
                set.setTRT_DIVISION_FACTOR(rs.getString(7));
                set.setTRT_RATE_TYPE(rs.getString(8));
                set.setTRT_RATE_TYPE_DESC(rs.getString(9));
                set.setTRT_APPLIED_TO(rs.getString(10));
                set.setTRT_APPLIED_TO_DESC(rs.getString(11));
                set.setTRT_APPLICATION_FREQ(rs.getString(12));
                set.setTRT_APPLICATION_FREQ_DESC(rs.getString(13));
                set.setTRT_TAX_DURATION(rs.getString(14));
                set.setCVT_DESC(rs.getString(15));
                set.setTRT_WEF_DATE(rs.getDate(16));
                set.setTRT_WET_DATE(rs.getDate(17));
                set.setTRT_YRS_OF_SERVICE_FROM(rs.getBigDecimal(18));
                set.setTRT_YRS_OF_SERVICE_TO(rs.getBigDecimal(19));
                set.setTRT_CAUS_CODE(rs.getBigDecimal(20));
                set.setCAUS_DESC(rs.getString(21));
                set.setTRT_APPLICABLE_AT_CAUS(rs.getString(22));
                set.setTRT_APPLIED_ON(rs.getString(23));
                set.setTRT_APPLIED_ON_DESC(rs.getString(24));

                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findMedicalTests() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.find_medtests_limits(?,?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setBigDecimal(2,(BigDecimal)session.getAttribute("currCode"));
            cst.execute();
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);           
            while (rs.next()) {
                Setup set = new Setup();

                set.setMTL_CODE(rs.getBigDecimal(1));
                set.setMTL_DESC(rs.getString(2));
                set.setMTL_FEES(rs.getString(3));
                set.setMTL_WEF(rs.getDate(4));
                set.setMTL_WET(rs.getDate(5));
                set.setMTL_VALIDITY_PRD(rs.getString(6));
                set.setMTL_SHT_DESC(rs.getString(7));


                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findFacilitators() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.find_facilitators(?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();

                set.setSPR_CODE(rs.getBigDecimal(1));
                set.setSPR_SHT_DESC(rs.getString(2));
                set.setSPR_NAME(rs.getString(3));
                set.setSPR_SPT_CODE(rs.getBigDecimal(4));
                set.setTWN_NAME(rs.getString(5));

                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findFacilitatorTests() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.find_facil_tests_limits(?,?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setBigDecimal(2, (BigDecimal)session.getAttribute("sprCode"));
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();

                set.setFTL_CODE(rs.getBigDecimal(1));
                set.setMEDICAL_DISPLAY(rs.getString(2));
                set.setFTL_FEES(rs.getString(3));
                set.setFTL_WEF(rs.getDate(4));
                set.setFTL_WET(rs.getDate(5));
                set.setFTL_VALIDITY_PRD(rs.getString(6));

                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findLifeClasses() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.find_life_classes(?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();

                set.setLC_CODE(rs.getBigDecimal(1));
                set.setLC_DESC(rs.getString(2));
                set.setLC_HAZARDOUS(rs.getString(3));
                set.setLC_SHT_DESC(rs.getString(4));
                set.setLC_HAZAROUS_DESC(rs.getString(5));


                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findProductDependants() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.find_product_dependants(?,?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setBigDecimal(2,
                              (BigDecimal)session.getAttribute("ProductCode"));
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();

                set.setPCD_CODE(rs.getBigDecimal(1));
                set.setPCD_DTY_DESCRIPTION(rs.getString(2));
                set.setPCD_PROD_DESC(rs.getString(3));
                set.setPCD_PCT_CODE(rs.getBigDecimal(4));
                set.setDTY_CODE(rs.getBigDecimal(5));
                set.setDTY_SHT_DESC(rs.getString(6));
                set.setPCD_CVT_CODE(rs.getBigDecimal(7));
                set.setPCD_CVT_SHT_DESC(rs.getString(8));


                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findPremiumRateTerms() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.find_prem_rate_terms(?,?,?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setBigDecimal(2, (BigDecimal)session.getAttribute("pmasCode"));
            cst.setBigDecimal(3, (BigDecimal)session.getAttribute("pcdCode"));
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            int i = 0;
            while (rs.next()) {
                Setup set = new Setup();

                set.setGRPT_CODE(rs.getBigDecimal(1));
                if (i == 0) {
                    session.setAttribute("grptCode", rs.getBigDecimal(1));
                }
                set.setGRPT_TERM_FROM(rs.getString(2));
                set.setGRPT_TERM_TO(rs.getString(3));

                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findPremiumInterestRates() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.find_prem_int_rates(?,?,?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setBigDecimal(2, (BigDecimal)session.getAttribute("pmasCode"));
            cst.setBigDecimal(3, (BigDecimal)session.getAttribute("pcdCode"));
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            int i = 0;
            while (rs.next()) {
                Setup set = new Setup();

                set.setGPIR_CODE(rs.getBigDecimal(1));
                if (i == 0) {
                    session.setAttribute("gpirCode", rs.getBigDecimal(1));
                }
                set.setGPIR_RATE_FROM(rs.getString(2));
                set.setGPIR_RATE_TO(rs.getString(3));

                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findPremiumRates() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.find_premium_rates(?,?,?,?,?,?,?,?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setBigDecimal(2, (BigDecimal)session.getAttribute("pmasCode"));
            cst.setBigDecimal(3, (BigDecimal)session.getAttribute("pcdCode"));
            cst.setBigDecimal(4, (BigDecimal)session.getAttribute("lcCode"));
            cst.setBigDecimal(5, (BigDecimal)session.getAttribute("grptCode"));
            cst.setBigDecimal(6, (BigDecimal)session.getAttribute("gpirCode"));
            cst.setString(7, (String)session.getAttribute("GroupRates"));
            cst.setBigDecimal(8, (BigDecimal)session.getAttribute("schCode"));
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();


                set.setGPR_CODE(rs.getBigDecimal(1));
                set.setGPR_ANB_FROM(rs.getString(2));
                set.setGPR_ANB_TO(rs.getString(3));
                set.setGPR_RANGE_FROM(rs.getString(4));
                set.setGPR_RANGE_TO(rs.getString(5));
                set.setGPR_RATE(rs.getString(6));
                set.setGPR_ANNUAL_RATE(rs.getString(7));
                set.setGPR_SINGLE_RATE(rs.getString(8));
                set.setGPR_RATE_DESC(rs.getString(9));
                set.setGPR_DIVISION_FACTOR(rs.getString(10));
                set.setGPR_RATE_TYPE(rs.getString(11));
                set.setGPR_RATE_TYPE_DESC(rs.getString(12));
                set.setGPR_PRORATED_FULL(rs.getString(13));
                set.setGPR_MULTIPLIER_RATE(rs.getString(14));
                set.setGPR_MULTIPLIER_RATE_DESC(rs.getString(15));
                set.setGPR_MULTPLIER_DIV_FACT(rs.getString(16));
                set.setGPR_CONSTANT(rs.getString(17));
                set.setGPR_CONSTANT_DIV_FACT(rs.getString(18));
                set.setGPR_NORMAL_REFUND(rs.getString(19));
                set.setGPR_NORMAL_REFUND_DESC(rs.getString(20));
                set.setGPR_WEF(rs.getDate(21));
                set.setGPR_WET(rs.getDate(22));
                set.setGPR_SEX(rs.getString(23));

                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findMedTestGroups() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.find_medtest_grps(?,?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setBigDecimal(2,(BigDecimal) session.getAttribute("currCode"));
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();

                set.setMTG_CODE(rs.getBigDecimal(1));
                set.setMTG_SHT_DESC(rs.getString(2));
                set.setMTG_DESC(rs.getString(3));
                set.setMTG_WEF(rs.getDate(4));
                set.setMTG_WET(rs.getDate(5));


                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findMedTestGroupTests() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.find_medgrp_tests(?,?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setBigDecimal(2, (BigDecimal)session.getAttribute("mtgCode"));
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();

                set.setMGIT_CODE(rs.getBigDecimal(1));
                set.setMGIT_MTL_CODE(rs.getBigDecimal(2));
                set.setMTL_DESC(rs.getString(3));

                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findTreatyTypes() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.find_treaty_types(?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();

                set.setTRT_CODE(rs.getBigDecimal(1));
                set.setTRT_SHT_DESC(rs.getString(2));
                set.setTRT_DESC(rs.getString(3));
                set.setTRT_LEVEL(rs.getString(4));


                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findTreatyTypeGroups() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.find_treaty_type_grp(?,?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setBigDecimal(2, (BigDecimal)session.getAttribute("trtCode"));
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();

                set.setTRTG_CODE(rs.getBigDecimal(1));
                set.setTRTG_SHT_DESC(rs.getString(2));
                set.setTRTG_DESC(rs.getString(3));

                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findTreatyTypesAndGroups() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<TreatyGroupItems> TrtyGroupItems = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.find_treaty_types(?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                TrtyGroupItems = new ArrayList<TreatyGroupItems>();
                Setup set = new Setup();
                set.setTRT_CODE(rs.getBigDecimal(1));
                set.setTRT_SHT_DESC(rs.getString(2));
                set.setTRT_DESC(rs.getString(3));
                set.setTRT_LEVEL(rs.getString(4));
                set.setType("P");

                CallableStatement stmt2 =
                    conn.prepareCall("begin LMS_SETUPS_CURSOR.find_treaty_type_grp(?,?); end;");
                stmt2.registerOutParameter(1, OracleTypes.CURSOR);
                stmt2.setBigDecimal(2, rs.getBigDecimal(1));
                stmt2.execute();
                ResultSet rst = (ResultSet)stmt2.getObject(1);
                while (rst.next()) {
                    TreatyGroupItems set1 = new TreatyGroupItems();
                    set1.setTRTG_CODE(rst.getBigDecimal(1));
                    set1.setTRTG_SHT_DESC(rst.getString(2));
                    set1.setTRTG_DESC(rst.getString(3));
                    set1.setType("S");
                    TrtyGroupItems.add(set1);
                }
                set.setTreatyGroupItem(TrtyGroupItems);
                SetupArray.add(set);
                stmt2.close();
            }
            rs.close();
            cst.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }

        return SetupArray;
    }

    public List<Setup> findTreaties() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.find_treaties(?,?,?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setBigDecimal(2, (BigDecimal)session.getAttribute("trtCode"));
            cst.setBigDecimal(3, (BigDecimal)session.getAttribute("trtgCode"));
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();

                set.setTRS_CODE(rs.getBigDecimal(1));
                set.setTRS_SHT_DESC(rs.getString(2));
                set.setTRS_NAME(rs.getString(3));
                set.setTRS_TRTG_SHT_DESC(rs.getString(4));

                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findMedicalANB() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery = "begin LMS_SETUPS_CURSOR.find_med_anb(?,?,?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setBigDecimal(2,(BigDecimal)session.getAttribute("ProductCode"));
            cst.setBigDecimal(3,(BigDecimal)session.getAttribute("currCode"));
            
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();

                set.setMANB_CODE(rs.getBigDecimal(1));
                set.setMANB_ANB_FROM(rs.getString(2));
                set.setMANB_ANB_TO(rs.getString(3));
                set.setMANB_WEF(rs.getDate(4));
                set.setMANB_WET(rs.getDate(5));

                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findMedRequirements() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.find_med_req(?,?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setBigDecimal(2, (BigDecimal)session.getAttribute("manbCode"));
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();


                set.setMREQ_CODE(rs.getBigDecimal(1));
                set.setMREQ_RANGE_FROM(rs.getString(2));
                set.setMREQ_RANGE_TO(rs.getString(3));
                set.setMREQ_MTG_DESC(rs.getString(4));
                set.setMREQ_WEF(rs.getDate(5));
                set.setMREQ_WET(rs.getDate(6));


                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findRenMedicalRatings() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.find_ren_med_ratings(?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();


                set.setGFM_CODE(rs.getBigDecimal(1));
                set.setGFM_ANB_FROM(rs.getString(2));
                set.setGFM_ANB_TO(rs.getString(3));
                set.setGFM_LAST_MEDICAL_DURATION(rs.getString(4));
                set.setGMF_INCREASE_SA_LAST_MED_PERC(rs.getString(5));
                set.setGFM_INCREASE_TYPE(rs.getString(6));
                set.setGFM_INCREASE_MULT_DIV_FACT(rs.getString(7));


                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findGroupOccupations() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.find_grp_occupations(?,?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setBigDecimal(2, (BigDecimal)session.getAttribute("lcCode"));
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();

                set.setLC_CODE(rs.getBigDecimal(1));
                set.setLC_SHT_DESC(rs.getString(2));
                set.setLC_DESC(rs.getString(3));
                set.setLC_HAZARDOUS(rs.getString(4));
                set.setLC_HAZAROUS_DESC(rs.getString(5));

                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findGroupOccupationsCategories() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String occCategory =
                "begin LMS_SETUPS_CURSOR.getOccupationCategories(?,?); end;";
            cst = conn.prepareCall(occCategory);
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setBigDecimal(2, (BigDecimal)session.getAttribute("gcoCode"));
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();
                set.setGOC_CODE(rs.getBigDecimal(1));
                set.setGOC_CATEGORY(rs.getString(2));
                set.setGOC_CLASS(rs.getBigDecimal(3));
                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findRIRatesDescription() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.find_rein_rate_desc(?,?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setString(2, (String)session.getAttribute("classSpecific"));
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();

                set.setORRP_CODE(rs.getBigDecimal(1));
                set.setORRP_SHT_DESC(rs.getString(2));
                set.setORRP_DESC(rs.getString(3));

                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findRIRates() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.find_rein_rates(?,?,?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setBigDecimal(2, (BigDecimal)session.getAttribute("orrpCode"));
            cst.setBigDecimal(3, (BigDecimal)session.getAttribute("lcCode"));
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();

                set.setORRT_CODE(rs.getBigDecimal(1));
                set.setORRT_ANB_FROM(rs.getString(2));
                set.setORRT_ANB_TO(rs.getString(3));
                set.setORRT_RATE(rs.getString(4));
                set.setORRT_DIVISION_FACTOR(rs.getString(5));
                set.setORRT_RATE_TYPE(rs.getString(6));
                set.setORRT_RATE_TYPE_DESC(rs.getString(7));
                set.setORRT_WEF(rs.getDate(8));
                set.setORRT_WET(rs.getDate(9));


                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findOSRIRatesDesc() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.find_os_rein_ratedesc(?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();


                set.setRIOS_CODE(rs.getBigDecimal(1));
                set.setRIOS_SHT_DESC(rs.getString(2));
                set.setRIOS_DESC(rs.getString(3));
                set.setRIOS_WEF(rs.getDate(4));
                set.setRIOS_WET(rs.getDate(5));


                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findOSRIRates() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.find_os_rein_rates(?,?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setBigDecimal(2, (BigDecimal)session.getAttribute("riosCode"));
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();

                set.setRIOT_CODE(rs.getBigDecimal(1));
                set.setRIOT_POLICY_TERM(rs.getString(2));
                set.setRIOT_POLICY_TERM_TO(rs.getString(3));
                set.setRIOT_LAPSED_TERM(rs.getString(4));
                set.setRIOT_LAPSED_TERM_TO(rs.getString(5));
                set.setRIOT_RATE(rs.getString(6));
                set.setRIOT_DIVISION_FACTOR(rs.getString(7));


                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findTreatyProducts() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery = "begin LMS_SETUPS_CURSOR.find_products(?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);

            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();

                set.setPROD_CODE(rs.getBigDecimal(1));
                set.setPROD_DESC(rs.getString(2));
                set.setPROD_SHT_DESC(rs.getString(3));
                set.setPROD_TYPE(rs.getString(4));

                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findInterMedGroups() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.find_intermed_grps(?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);

            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();

                set.setINGR_CODE(rs.getBigDecimal(1));
                set.setINGR_SHT_DESC(rs.getString(2));
                set.setINGR_DESC(rs.getString(3));


                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findCreditCriterion() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.find_credit_criterion(?,?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setBigDecimal(2,
                              (BigDecimal)session.getAttribute("INGR_CODE"));
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();

                set.setCCR_CODE(rs.getBigDecimal(1));
                set.setCCR_DESCRIPTION(rs.getString(2));
                set.setCCR_INGR_CODE(rs.getBigDecimal(3));


                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findIntermediary() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.find_intermediaries(?,?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setString(2, (String)session.getAttribute("ClientOption"));
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();

                set.setPrpCode(rs.getBigDecimal(1));
                set.setClient(rs.getString(2));
                //set.setCCR_INGR_CODE(rs.getBigDecimal(3));


                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findCreditActions() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.find_credit_actions(?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            //cst.setString(2,(String)session.getAttribute("ClientOption"));
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();

                set.setCraCode(rs.getBigDecimal(1));
                set.setCRA_CREDIT_DAYS(rs.getString(2));
                set.setCRA_ACTION(rs.getString(3));
                set.setCRA_INGR_CODE(rs.getBigDecimal(4));
                set.setCRA_INGR_DESC(rs.getString(6));
                set.setCRA_WAIVER(rs.getString(5));
                //set.setCCR_INGR_CODE(rs.getBigDecimal(3));


                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findProvisions() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.find_provisions(?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            //cst.setString(2,(String)session.getAttribute("ClientOption"));
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();

                set.setPROV_CODE(rs.getBigDecimal(1));
                set.setPROV_SHT_DESC(rs.getString(2));
                set.setPROV_DESC(rs.getString(3));
                set.setPROV_TYPE(rs.getString(4));
                set.setPROV_HIV_CLAUSE(rs.getString(5));
                set.setPROV_HIV_CLAUSE_DESC(rs.getString(6));


                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findProductProvisions() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.findProductProvisions(?,?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setBigDecimal(2,
                              (BigDecimal)session.getAttribute("ProductCode"));
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();
                set.setPprov_code(rs.getBigDecimal(1));
                set.setPprov_default(rs.getString(2));
                set.setPprov_editable(rs.getString(3));
                set.setPprov_auto_populate(rs.getString(4));
                set.setPROV_DESC(rs.getString(5));
                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findProdCoverProvisions() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.find_prod_cvr_provisions(?,?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setBigDecimal(2, (BigDecimal)session.getAttribute("pctCode"));
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();

                set.setPCPR_DEFAULT(rs.getString(1));
                set.setPCPR_EDIT_ALLOW(rs.getString(2));
                set.setPCPR_CODE(rs.getBigDecimal(3));
                set.setPCPR_PROV_CODE(rs.getBigDecimal(4));
                set.setPROV_DESC(rs.getString(5));


                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findProvisionsLimit() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.getProvisionsLimit(?,?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setBigDecimal(2,
                              (BigDecimal)session.getAttribute("nprovCode"));
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();

                set.setProvl_code(rs.getBigDecimal(1));
                set.setProvl_from(rs.getBigDecimal(2));
                set.setProvl_to(rs.getBigDecimal(3));
                set.setProvl_perc_payable(rs.getBigDecimal(4));
                set.setProvl_waiting_prd(rs.getBigDecimal(5));
                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findCpverTypes() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.find_cover_types(?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            //cst.setString(2,(String)session.getAttribute("ClientOption"));
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();

                set.setCVT_CODE(rs.getBigDecimal(1));
                set.setCVT_SHT_DESC(rs.getString(2));
                set.setCVT_DESCRIPTION(rs.getString(3));
                set.setCVT_MAIN_COVER(rs.getString(4));
                set.setCVT_MAIN_COVER_DESC(rs.getString(5));
                set.setCVT_DURATION_TYPE(rs.getString(6));
                set.setCVT_DURATION_TYPE_DESC(rs.getString(7));
                set.setCVT_MAX_AGE(rs.getBigDecimal(8));
                set.setCVT_MULTIPLIER(rs.getBigDecimal(9));
                set.setCVT_MULT_DIV_FACT(rs.getBigDecimal(10));
                set.setCVT_READ_FROM(rs.getString(11));
                set.setCVT_READ_FROM_DESC(rs.getString(12));
                set.setCVT_RATE_TYPE(rs.getString(13));
                set.setCVT_RATE_TYPE_DESC(rs.getString(14));
                set.setCVT_REPORT_NAME(rs.getString(15));
                set.setCVT_REMARKS(rs.getString(16));
                set.setCVT_RATES_FREQ_OF_PYMT(rs.getString(17));
                set.setCVT_RATES_FREQ_OF_PYMT_DESC(rs.getString(18));
                set.setCVT_PAY_BEN(rs.getString(19));
                set.setCVT_PAY_BEN_DESC(rs.getString(20));
                set.setCVT_MAX_INST_NO(rs.getBigDecimal(21));
                set.setCVT_WAITING_PRD(rs.getBigDecimal(22));
                set.setCVT_RETIRE_AGE(rs.getBigDecimal(23));
                set.setCVT_FIXED_SA(rs.getString(24));
                set.setCVT_FIXED_SA_AMT(rs.getBigDecimal(25));
                set.setCVT_NOTIFICATION_PRD(rs.getBigDecimal(26));

                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findProdCoverTypes() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.find_prod_covers(?,?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setBigDecimal(2,
                              (BigDecimal)session.getAttribute("ProductCode"));
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();

                set.setPCT_CODE(rs.getBigDecimal(1));
                set.setPCT_CVT_CODE(rs.getBigDecimal(2));
                set.setPCT_CVT_DESC(rs.getString(3));
                set.setPCT_CVT_SHT_DESC(rs.getString(4));
                set.setPCT_PROD_CODE(rs.getBigDecimal(6));
                set.setPCT_FORMULAR(rs.getString(5));
                set.setPCT_FORMULAR_DESC(rs.getString(7));
                set.setPCT_REFUND_FORMULAR(rs.getString(8));
                set.setPCT_REFUND_FORMULAR_DESC(rs.getString(9));
                set.setPCT_MAIN_SA_PERC(rs.getBigDecimal(10));
                set.setPCT_MAX_CLM_AMT(rs.getBigDecimal(11));
                set.setPCT_MAX_ASSUREDS(rs.getBigDecimal(12));
                set.setPCT_MAX_AGE(rs.getBigDecimal(13));
                set.setPCT_MAX_SA(rs.getBigDecimal(14));
                set.setPCT_RATE_DEPEND_ON_CLASS(rs.getString(15));
                set.setPCT_RATE_DEPEND_ON_CLASS_DESC(rs.getString(16));
                set.setPCT_INBUILT(rs.getString(17));
                set.setPCT_INBUILT_DESC(rs.getString(18));
                set.setPCT_GRP_OR_SINGLE_RATES(rs.getString(19));
                set.setPCT_GRP_OR_SINGLE_RATES_DESC(rs.getString(20));
                set.setPCT_MANDATORY(rs.getString(21));
                set.setPCT_MANDATORY_DESC(rs.getString(22));
                set.setPCT_ACCELERATOR(rs.getString(23));
                set.setPCT_ACCELERATOR_DESC(rs.getString(24));
                set.setPCT_SA_DEPEND_ON_LIMIT(rs.getString(26));
                set.setPCT_SA_DEPEND_ON_LIMIT_DESC(rs.getString(27));
                set.setCVT_MAIN_COVER(rs.getString(28));
                set.setPCT_THIRTEEN_MONTH(rs.getString(29));
                set.setPCT_EM(rs.getBigDecimal(30));
                set.setPCT_PROFIT_MARGIN(rs.getBigDecimal(31));
                set.setPCT_MNGT_EXPENSES(rs.getBigDecimal(32));
                set.setPCT_PHCF(rs.getBigDecimal(33));
                set.setPCT_ADR_RATE(rs.getBigDecimal(34));
                set.setPCT_ADR_RATE_DIV_FACT(rs.getBigDecimal(35));
                set.setPCT_MED_COST(rs.getBigDecimal(36));
                set.setPCT_STAMP_DUTY(rs.getBigDecimal(37));
                set.setPCT_COMM_RATE(rs.getBigDecimal(38));
                set.setPMAS_SHT_DESC(rs.getString(39));
                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findCoverTypesLOV() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.populate_cover_lov(?,?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setBigDecimal(2,
                              (BigDecimal)session.getAttribute("ProductCode"));
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();

                set.setCVT_CODE(rs.getBigDecimal(1));
                set.setCVT_SHT_DESC(rs.getString(2));
                set.setCVT_DESCRIPTION(rs.getString(3));
                set.setCVT_MAIN_COVER(rs.getString(4));


                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findProductCoverTypesLOV() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.findTreatyProdCovers(?,?,?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setBigDecimal(2,
                              (BigDecimal)session.getAttribute("ProductCode"));
            cst.setBigDecimal(3,
                              (BigDecimal)session.getAttribute("trpd_code"));
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();

                set.setADD_PCT_CODE(rs.getBigDecimal(1));
                set.setADD_CVT_CODE(rs.getBigDecimal(2));
                set.setADD_CVT_SHT_DESC(rs.getString(3));
                set.setADD_CVT_DESC(rs.getString(4));

                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findAccessGroups() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.find_access_grps(?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();

                set.setLPAG_CODE(rs.getBigDecimal(1));
                set.setLPAG_SHT_DESC(rs.getString(2));
                set.setLPAG_DESC(rs.getString(3));
                set.setLPAG_TYPE(rs.getString(4));

                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findPolicyAccessGroups() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.find_policy_access_grps(?,?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setBigDecimal(2, (BigDecimal)session.getAttribute("lpagCode"));
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();

                set.setPOL_CODE(rs.getBigDecimal(1));
                set.setPOL_POLICY_NO(rs.getString(2));
                set.setCLIENT(rs.getString(3));
                set.setBRN_NAME(rs.getString(4));
                set.setPROD_DESC(rs.getString(5));
                set.setLPAG_DESC(rs.getString(6));

                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findAccessGroupsForPolicy() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.find_access_grpsfor_policy(?,?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setBigDecimal(2,
                              (BigDecimal)session.getAttribute("lpagPolicyCode"));
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();

                set.setPOL_CODE(rs.getBigDecimal(1));
                set.setPOL_POLICY_NO(rs.getString(2));
                set.setCLIENT(rs.getString(3));
                set.setBRN_NAME(rs.getString(4));
                set.setPROD_DESC(rs.getString(5));
                set.setLPAG_DESC(rs.getString(6));

                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findUserAccessGroups() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.find_access_grp_users(?,?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setBigDecimal(2, (BigDecimal)session.getAttribute("lpagCode"));
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();

                set.setAGU_CODE(rs.getBigDecimal(1));
                set.setAGU_LPAG_CODE(rs.getBigDecimal(2));
                set.setAGU_USR_CODE(rs.getBigDecimal(3));
                set.setUSR_USERNAME(rs.getString(4));
                set.setUSR_NAME(rs.getString(5));

                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findImportTemplateProducts() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> SetupArray = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.find_product_imp_table(?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();

                set.setPROD_CODE(rs.getBigDecimal(1));
                set.setPROD_SHT_DESC(rs.getString(2));
                set.setPROD_DESC(rs.getString(3));
                set.setLPIT_TABLE_NAME(rs.getString(4));
                set.setPROD_TYPE(rs.getString(5));
                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return SetupArray;
    }

    public List<Setup> findImportLoadingTemplate() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> loadingTemp = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.get_loadings_temp(?,?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);

            cst.setBigDecimal(2, (BigDecimal)session.getAttribute("pctCode"));

            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();
                set.setPCTL_CODE(rs.getBigDecimal(1));
                set.setPCTL_NAME(rs.getString(2));
                loadingTemp.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return loadingTemp;
    }

    public List<Setup> findImportLoadingRates() {

        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Setup> loadingTemp = new ArrayList<Setup>();
        try {

            String msgQuery =
                "begin LMS_SETUPS_CURSOR.getLoadings(?,?,?,?,?,?,?,?); end;";
            cst = conn.prepareCall(msgQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);

            cst.setBigDecimal(2, (BigDecimal)session.getAttribute("pctCode"));
            cst.setBigDecimal(3, (BigDecimal)session.getAttribute("pmasCode"));
            cst.setBigDecimal(4, (BigDecimal)session.getAttribute("pcdCode"));
            cst.setBigDecimal(5, (BigDecimal)session.getAttribute("lcCode"));
            cst.setBigDecimal(6, (BigDecimal)session.getAttribute("dtyCode"));
            cst.setBigDecimal(7,
                              (BigDecimal)session.getAttribute("pctl_code"));
            cst.setString(8, (String)session.getAttribute("grp_single_rate"));

            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Setup set = new Setup();
                set.setGLR_ANB_FROM(rs.getBigDecimal(1));
                set.setGLR_ANB_TO(rs.getBigDecimal(2));
                set.setGLR_SEX(rs.getString(3));
                set.setGLR_CLASS(rs.getBigDecimal(4));
                set.setGLR_RANGE_FROM(rs.getBigDecimal(5));
                set.setGLR_RANGE_TO(rs.getBigDecimal(6));
                set.setGLR_RATE(rs.getBigDecimal(7));
                set.setGLR_DIV_FACT(rs.getBigDecimal(8));
                set.setGLR_WEF(rs.getDate(9));
                set.setGLR_WET(rs.getDate(10));
                loadingTemp.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return loadingTemp;
    }
  public List<Setup> findOrgCurrencies() {

      DBConnector datahandler = new DBConnector();
      Connection conn;
      conn = datahandler.getDatabaseConn();

      CallableStatement cst = null;
      List<Setup> orgCurrencies= new ArrayList<Setup>();
      try {

          String msgQuery =
              "begin LMS_SETUPS_CURSOR.getOrgCurrencies(?,?); end;";
          cst = conn.prepareCall(msgQuery);

          cst.registerOutParameter(1, OracleTypes.CURSOR);
          cst.setBigDecimal(2,(BigDecimal)session.getAttribute("OrganizationCode"));
          cst.execute();
          ResultSet rs = (ResultSet)cst.getObject(1);
          while (rs.next()) {
              Setup set = new Setup();
              set.setCur_code(rs.getBigDecimal(1));
              set.setCur_symbol(rs.getString(2));
              this.setCurrSymbol(rs.getString(2));
              set.setCur_desc(rs.getString(4));
              orgCurrencies.add(set);
          }
          rs.close();
          conn.close();


      } catch (Exception e) {
          GlobalCC.EXCEPTIONREPORTING(null, e);
      }

      return orgCurrencies;
  }
  public List<Setup> findOverrideCommRates() {
    DBConnector datahandler = new DBConnector();
    Connection conn;
    conn = datahandler.getDatabaseConn();
    
      String query = "begin LMS_SETUPS_CURSOR.OV_comm_rates(?,?,?,?,?); end;";
      List<Setup> commRatesData = new ArrayList<Setup>();

      try {
          CallableStatement callStmt = null;
          callStmt = conn.prepareCall(query);
          callStmt.registerOutParameter(1, OracleTypes.CURSOR);
          callStmt.setBigDecimal(2,
                                 (BigDecimal)session.getAttribute("actCode"));
          callStmt.setBigDecimal(3, null);
          callStmt.setString(4, (String)session.getAttribute("OverrideAppliedOn"));
          callStmt.setBigDecimal(5, (BigDecimal)session.getAttribute("ovProdCode"));
          callStmt.execute();
          ResultSet rs2 =(ResultSet) callStmt.getObject(1);

          while (rs2.next()) {
              Setup commRatesDef = new Setup();
              commRatesDef.setCratCode(rs2.getBigDecimal(1));
              commRatesDef.setCratRate(rs2.getBigDecimal(2));
              commRatesDef.setCratDivFactor(rs2.getBigDecimal(3));
              commRatesDef.setCratWefDate(rs2.getDate(4));
              commRatesDef.setCratWetDate(rs2.getDate(5));
              commRatesDef.setCratRangeFrom(rs2.getBigDecimal(6));
              commRatesDef.setCratRangeTo(rs2.getBigDecimal(7));
              commRatesDef.setCratYrNoFrom(rs2.getBigDecimal(8));
              commRatesDef.setCratYrNoTo(rs2.getBigDecimal(9));
              commRatesDef.setCratTermFrom(rs2.getBigDecimal(10));
              commRatesDef.setCratTermTo(rs2.getBigDecimal(11));
              commRatesDef.setCratAppliedOn(rs2.getString(12));
              commRatesData.add(commRatesDef);

          }
          rs2.close();
          callStmt.close();
          conn.commit();
          conn.close();
      } catch (Exception e) {
          e.printStackTrace();
          GlobalCC.EXCEPTIONREPORTING(conn, e);
      }
      return commRatesData;
  }

  public List<Setup> findOtherOverrideCommRates() {
    DBConnector datahandler = new DBConnector();
    Connection conn;
    conn = datahandler.getDatabaseConn();
      String query =
          "begin LMS_WEB_CURSOR_SETUP.other_override_comm_rates(?,?,?); end;";
      List<Setup> commRatesData = new ArrayList<Setup>();

      try {
          CallableStatement callStmt = null;
          callStmt = conn.prepareCall(query);
          callStmt.registerOutParameter(1, OracleTypes.CURSOR);
          callStmt.setBigDecimal(2,
                                 (BigDecimal)session.getAttribute("actCode"));
          callStmt.setBigDecimal(3, null);
          callStmt.execute();
          ResultSet rs2 = (ResultSet)callStmt.getObject(1);

          while (rs2.next()) {
              Setup commRatesDef = new Setup();
              commRatesDef.setOocrCode(rs2.getBigDecimal(1));
              commRatesDef.setOocrRate(rs2.getBigDecimal(2));
              commRatesDef.setOocrRateDesc(rs2.getString(3));
              commRatesDef.setOocrDivFactor(rs2.getBigDecimal(4));
              commRatesDef.setOocrAtCode(rs2.getBigDecimal(5));
              commRatesDef.setOocrApplAtCode(rs2.getBigDecimal(6));
              commRatesDef.setOocrYrNoFrom(rs2.getBigDecimal(7));
              commRatesDef.setOocrYrNoTo(rs2.getBigDecimal(8));
              commRatesDef.setOocrClaCode(rs2.getBigDecimal(9));
              commRatesDef.setOocrWefDate(rs2.getDate(10));
              commRatesDef.setOocrWetDate(rs2.getDate(11));
              commRatesDef.setOocrApplAtName(rs2.getString(12));
              commRatesData.add(commRatesDef);

          }
          rs2.close();
          callStmt.close();
          conn.commit();
          conn.close();
      } catch (Exception e) {
          e.printStackTrace();
          GlobalCC.EXCEPTIONREPORTING(conn, e);
      }
      return commRatesData;
  }
  public List<Setup> findBudgetTypes() {

      DBConnector datahandler = new DBConnector();
      Connection conn;
      conn = datahandler.getDatabaseConn();

      CallableStatement cst = null;
      List<Setup> budgets= new ArrayList<Setup>();
      try {

          String msgQuery =
              "begin LMS_SETUPS_CURSOR.findBudgetTypes(?); end;";
          cst = conn.prepareCall(msgQuery);

          cst.registerOutParameter(1, OracleTypes.CURSOR);

          cst.execute();
          ResultSet rs = (ResultSet)cst.getObject(1);
          while (rs.next()) {
              Setup set = new Setup();
              set.setBtsCode(rs.getBigDecimal(1));
              set.setBtsName(rs.getString(2));
              set.setBtsDesc(rs.getString(3));
              set.setBtsUwYr(rs.getBigDecimal(4));
              set.setBtsPolEffDate(rs.getDate(5));
              budgets.add(set);
          }
          rs.close();
          conn.close();


      } catch (Exception e) {
          GlobalCC.EXCEPTIONREPORTING(null, e);
      }

      return budgets;
  }
  public List<Setup> findProdBudgetTypes() {

      DBConnector datahandler = new DBConnector();
      Connection conn;
      conn = datahandler.getDatabaseConn();

      CallableStatement cst = null;
      List<Setup> budgets= new ArrayList<Setup>();
      try {

          String msgQuery =
              "begin LMS_SETUPS_CURSOR.findProdBudget(?,?,?,?); end;";
          cst = conn.prepareCall(msgQuery);

          cst.registerOutParameter(1, OracleTypes.CURSOR);
          cst.setBigDecimal(2,(BigDecimal) session.getAttribute("prodCode"));
          cst.setBigDecimal(3,(BigDecimal) session.getAttribute("brnCode"));
          cst.setBigDecimal(4,(BigDecimal) session.getAttribute("btsCode"));
          cst.execute();
          ResultSet rs = (ResultSet)cst.getObject(1);
          while (rs.next()) {
              Setup set = new Setup();
              set.setPbgtCode(rs.getBigDecimal(1));
              set.setPbgtJanRenAmt(rs.getBigDecimal(2));
              set.setPbgtFebRenAmt(rs.getBigDecimal(3));
              set.setPbgtMarRenAmt(rs.getBigDecimal(4));
              set.setPbgtAprRenAmt(rs.getBigDecimal(5));
              set.setPbgtMayRenAmt(rs.getBigDecimal(6));
              set.setPbgtJunRenAmt(rs.getBigDecimal(7));
              set.setPbgtJulRenAmt(rs.getBigDecimal(8));
              set.setPbgtAugRenAmt(rs.getBigDecimal(9));
              set.setPbgtSepRenAmt(rs.getBigDecimal(10));
              set.setPbgtOctRenAmt(rs.getBigDecimal(11));
              set.setPbgtNovRenAmt(rs.getBigDecimal(12));
              set.setPbgtDecRenAmt(rs.getBigDecimal(13));
              set.setPbgtJanNBAmt(rs.getBigDecimal(14));
              set.setPbgtFebNBAmt(rs.getBigDecimal(15));
              set.setPbgtMarNBAmt(rs.getBigDecimal(16));
              set.setPbgtAprNBAmt(rs.getBigDecimal(17));
              set.setPbgtMayNBAmt(rs.getBigDecimal(18));
              set.setPbgtJunNBAmt(rs.getBigDecimal(19));
              set.setPbgtJulNBAmt(rs.getBigDecimal(20));
              set.setPbgtAugNBAmt(rs.getBigDecimal(21));
              set.setPbgtSepNBAmt(rs.getBigDecimal(22));
              set.setPbgtOctNBAmt(rs.getBigDecimal(23));
              set.setPbgtNovNBAmt(rs.getBigDecimal(24));
              set.setPbgtDecNBAmt(rs.getBigDecimal(25));
              set.setBtsName(rs.getString(26));
              budgets.add(set);
          }
          rs.close();
          conn.close();


      } catch (Exception e) {
          GlobalCC.EXCEPTIONREPORTING(null, e);
      }

      return budgets;
  }
  public List<Setup> findOccupationCategory() {

      DBConnector datahandler = new DBConnector();
      Connection conn;
      conn = datahandler.getDatabaseConn();

      CallableStatement cst = null;
      List<Setup> occCate= new ArrayList<Setup>();
      try {

          String msgQuery =
              "begin LMS_WEB_CURSOR_GRP.getClassOccupationCategory(?); end;";
          cst = conn.prepareCall(msgQuery);

          cst.registerOutParameter(1, OracleTypes.CURSOR);

          cst.execute();
          ResultSet rs = (ResultSet)cst.getObject(1);
          while (rs.next()) {
              Setup set = new Setup();
              set.setGcoDesc(rs.getString(1));
              set.setGocCategory(rs.getString(2));
              set.setGocClass(rs.getBigDecimal(3));
              set.setGcoShtDesc(rs.getString(4));
              occCate.add(set);
          }
          rs.close();
          conn.close();


      } catch (Exception e) {
          GlobalCC.EXCEPTIONREPORTING(null, e);
      }

      return occCate;
  }
  public List<Setup> findProductPlans() {

      DBConnector datahandler = new DBConnector();
      Connection conn;
      conn = datahandler.getDatabaseConn();

      CallableStatement cst = null;
      List<Setup> prodPlans= new ArrayList<Setup>();
      try {

          String msgQuery =
              "begin LMS_WEB_CURSOR_GRP.getProductPlans(?,?); end;";
          cst = conn.prepareCall(msgQuery);

          cst.registerOutParameter(1, OracleTypes.CURSOR);
          cst.setBigDecimal(2,(BigDecimal) session.getAttribute("ProductCode"));
          cst.execute();
          ResultSet rs = (ResultSet)cst.getObject(1);
          while (rs.next()) {
              Setup set = new Setup();
              set.setPplCode(rs.getBigDecimal(1));
              set.setPplDesc(rs.getString(2));
              prodPlans.add(set);
          }
          rs.close();
          conn.close();


      } catch (Exception e) {
          e.printStackTrace();
          GlobalCC.EXCEPTIONREPORTING(null, e);
      }

      return prodPlans;
  }


    public void setClassSchLevel(BigDecimal ClassSchLevel) {
        this.ClassSchLevel = ClassSchLevel;
        session.setAttribute("ClassSchLevel", ClassSchLevel);
    }

    public BigDecimal getClassSchLevel() {
        ClassSchLevel = (BigDecimal)session.getAttribute("ClassSchLevel");
        return ClassSchLevel;
    }

    public void setCurrSymbol(String currSymbol) {
        this.currSymbol =currSymbol; 
       session.setAttribute("currSymbol",currSymbol);
    }

    public String getCurrSymbol() {      
        return (String)session.getAttribute("currSymbol");
    }
    

    
}
