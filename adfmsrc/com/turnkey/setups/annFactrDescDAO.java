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

public class annFactrDescDAO {
    public annFactrDescDAO() {
        super();
    }
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    public List<annuityFacDesc> findAnnuityFactorsDescription() {
        
        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<annuityFacDesc> SetupArray = new ArrayList<annuityFacDesc>();
        try {
           
                String msgQuery = 
                    "begin LMS_SETUPS_CURSOR.findAnnuityDesc(?,?); end;";
                cst = conn.prepareCall(msgQuery);
                      
             cst.registerOutParameter(1, 
                                     OracleTypes.CURSOR);
          
            cst.setBigDecimal(2,(BigDecimal)session.getAttribute("ProductCode"));
             cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
               annuityFacDesc set = new annuityFacDesc();
                set.setANNFD_CODE(rs.getBigDecimal(1));
                set.setANNFD_DESC(rs.getString(2));
                set.setANNFD_INT_RATE(rs.getBigDecimal(3));
                set.setANNFD_PROD_CODE(rs.getBigDecimal(4));
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
    public List<annuityFacDesc> findAnnuityFactors() {
        
        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<annuityFacDesc> SetupArray = new ArrayList<annuityFacDesc>();
        try {
           
                String msgQuery = 
                    "begin LMS_SETUPS_CURSOR.findAnnuityFactors(?,?); end;";
                cst = conn.prepareCall(msgQuery);
                      
             cst.registerOutParameter(1, 
                                     OracleTypes.CURSOR);
          
            cst.setBigDecimal(2,(BigDecimal)session.getAttribute("ANNFD_CODE"));
             cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
               annuityFacDesc set = new annuityFacDesc();
                set.setANNF_CODE(rs.getBigDecimal(1));
                set.setANNF_ANNFD_CODE(rs.getBigDecimal(2));
                set.setANNF_RETIRE_AGE(rs.getBigDecimal(3));
                set.setANNF_GUAR_PRD(rs.getBigDecimal(4));
                set.setANNF_MALE_RATE(rs.getBigDecimal(5));
                set.setANNF_FEMALE_RATE(rs.getBigDecimal(6));
                set.setANNF_WEF(rs.getDate(7));
                set.setANNF_WET(rs.getDate(8));
                SetupArray.add(set);
            }
            rs.close();
            conn.close();
            

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn,e);
        }            
      
        return SetupArray;
    }
    public List<annuityFacDesc> findAnnuityTypes() {
        
        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<annuityFacDesc> SetupArray = new ArrayList<annuityFacDesc>();
        try {
           
                String msgQuery = 
                    "begin LMS_SETUPS_CURSOR.findAnnuityTypes(?,?); end;";
                cst = conn.prepareCall(msgQuery);
                      
             cst.registerOutParameter(1, 
                                     OracleTypes.CURSOR);
          
            cst.setBigDecimal(2,(BigDecimal)session.getAttribute("ProductCode"));
             cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
               annuityFacDesc set = new annuityFacDesc();
                set.setAtyCode(rs.getBigDecimal(1));
                set.setProdDescription(rs.getString(2));
                set.setAtyOption(rs.getString(3));
                set.setAtyGuaranteePeriod(rs.getBigDecimal(4));
                set.setAtyType(rs.getString(5));
                set.setATY_RETIREMENT_AGE(rs.getString(6));
               
                SetupArray.add(set);
            }
            rs.close();
            conn.close();
            

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn,e);
        }            
      
        return SetupArray;
    }
    public List<annuityFacDesc> findAnnuityTypesRates() {
        
        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<annuityFacDesc> SetupArray = new ArrayList<annuityFacDesc>();
        try {
           
                String msgQuery = 
                    "begin LMS_SETUPS_CURSOR.findAnnuityRatesByType(?,?); end;";
                cst = conn.prepareCall(msgQuery);
                      
             cst.registerOutParameter(1, 
                                     OracleTypes.CURSOR);
          
            cst.setBigDecimal(2,(BigDecimal)session.getAttribute("ATY_CODE"));
             cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
               annuityFacDesc set = new annuityFacDesc();
                set.setAnntrCode(rs.getBigDecimal(1));
                set.setAnnAtycode(rs.getBigDecimal(2));
                set.setAnntrAnb(rs.getBigDecimal(3));
                set.setAnntrRate(rs.getBigDecimal(4));
                set.setAnntrGender(rs.getString(5));
                set.setAnntrGenderDesc(rs.getString(6));
               
               
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
