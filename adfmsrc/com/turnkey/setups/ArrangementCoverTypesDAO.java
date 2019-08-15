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

public class ArrangementCoverTypesDAO {
    public ArrangementCoverTypesDAO() {
        super();
    }
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    public List<ArrangementCoverTypes> findArrangementCoverTypes() {
        
        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<ArrangementCoverTypes> SetupArray = new ArrayList<ArrangementCoverTypes>();
        try {
           
                String msgQuery = 
                    "begin LMS_SETUPS_CURSOR.treatyarrgmtcovertypes(?,?,?,?); end;";
                cst = conn.prepareCall(msgQuery);
                      
             cst.registerOutParameter(1, 
                                     OracleTypes.CURSOR);
            
            cst.setBigDecimal(2,(BigDecimal)session.getAttribute("ProductCode"));
            cst.setBigDecimal(3,(BigDecimal)session.getAttribute("trpd_code"));
            cst.setBigDecimal(4,(BigDecimal)session.getAttribute("REI_CODE"));
            
             cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
               ArrangementCoverTypes set = new ArrangementCoverTypes();
                set.setAtct_code(rs.getBigDecimal(1));
                set.setAtct_tct_code(rs.getBigDecimal(2));
                set.setAtct_tprd_code(rs.getBigDecimal(3));
                set.setAtct_ta_code(rs.getBigDecimal(4));
                set.setAtct_ta_sht_desc(rs.getString(5));
                set.setAtct_rei_code(rs.getBigDecimal(6));
                set.setAtct_pct_code(rs.getBigDecimal(7));
                set.setAtct_cvt_code(rs.getBigDecimal(8));
                set.setAtct_cvt_sht_desc(rs.getString(9));
                set.setAtct_as_code(rs.getBigDecimal(10));
                set.setAtct_prod_code(rs.getBigDecimal(11));
                set.setAtct_cede_type(rs.getString(23));
                set.setAtct_cede_rate(rs.getBigDecimal(13));
                set.setAtct_rate_type(rs.getString(24));
                set.setAtct_limit(rs.getString(16));
                set.setAtct_orrp_code(rs.getBigDecimal(17));
                set.setAtct_rate_div_fact(rs.getBigDecimal(18));
                set.setAtct_class_specific(rs.getString(19));
                set.setAtct_comm_rate(rs.getBigDecimal(20));
                set.setCvt_desc(rs.getString(21));
                set.setOrrp_desc(rs.getString(22));
                set.setRatetype_desc(rs.getString(14));
                set.setCede_type_desc(rs.getString(12));
                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn,e);
        }            
      
        return SetupArray;
    }
    public List<ArrangementCoverTypes> findArrangementCoverTypesLOV() {
        
        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<ArrangementCoverTypes> SetupArray = new ArrayList<ArrangementCoverTypes>();
        try {
           
                String msgQuery = 
                    "begin LMS_SETUPS_CURSOR.findTreatyArrageCoverTypes(?,?,?,?); end;";
                cst = conn.prepareCall(msgQuery);
                      
             cst.registerOutParameter(1, 
                                     OracleTypes.CURSOR);
            
            cst.setBigDecimal(2,(BigDecimal)session.getAttribute("trpd_code"));
            cst.setBigDecimal(3,(BigDecimal)session.getAttribute("as_code"));
            cst.setBigDecimal(4,(BigDecimal)session.getAttribute("REI_CODE"));
            
             cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
               ArrangementCoverTypes set = new ArrangementCoverTypes();
                set.setTCT_CODE(rs.getBigDecimal(1));
                set.setTCT_CVT_CODE(rs.getBigDecimal(2));
                set.setTCT_CVT_SHT_DESC(rs.getString(3));
                set.setCVT_DESC(rs.getString(4));
                set.setTCT_PCT_CODE(rs.getBigDecimal(5));
               
                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn,e);
        }            
      
        return SetupArray;
    }
    public List<ArrangementCoverTypes> findOrdReinRatesLOV() {
        
        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<ArrangementCoverTypes> SetupArray = new ArrayList<ArrangementCoverTypes>();
        try {
           
                String msgQuery = 
                    "begin LMS_SETUPS_CURSOR.findOrdReinRates(?); end;";
                cst = conn.prepareCall(msgQuery);
                      
             cst.registerOutParameter(1, 
                                     OracleTypes.CURSOR);
          
            
             cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
               ArrangementCoverTypes set = new ArrangementCoverTypes();
                set.setORRP_CODE(rs.getBigDecimal(1));
                set.setORRP_SHT_DESC(rs.getString(2));
                set.setORRP_DESC(rs.getString(3));
                set.setORRP_CLASS_SPECIFIC (rs.getString(4));
                //set.setTCT_PCT_CODE(rs.getBigDecimal(5));
               
                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn,e);
        }            
      
        return SetupArray;
    }
    public List<ArrangementCoverTypes> findArrangementCoverTypesCommRates() {
        
        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<ArrangementCoverTypes> SetupArray = new ArrayList<ArrangementCoverTypes>();
        try {
           
                String msgQuery = 
                    "begin LMS_SETUPS_CURSOR.treatyarrgmtcommrates(?,?); end;";
                cst = conn.prepareCall(msgQuery);
                      
             cst.registerOutParameter(1, 
                                     OracleTypes.CURSOR);
            
            cst.setBigDecimal(2,(BigDecimal)session.getAttribute("ATCT_CODE"));
           
            
             cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
               ArrangementCoverTypes set = new ArrangementCoverTypes();
                set.setTacr_code(rs.getBigDecimal(1));
                set.setTacr_atct_code(rs.getBigDecimal(2));
                set.setTacr_pct_code(rs.getBigDecimal(3));
                set.setTacr_yr_from(rs.getString(4));
                set.setTacr_yr_to(rs.getString(5));
                set.setTacr_comm_rate(rs.getBigDecimal(6));
                set.setTacr_comm_div_factr(rs.getBigDecimal(7));
                set.setTacr_wef(rs.getDate(8));
                set.setTacr_wet(rs.getDate(9));
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
