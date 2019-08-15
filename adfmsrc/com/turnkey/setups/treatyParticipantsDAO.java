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

public class treatyParticipantsDAO {
    public treatyParticipantsDAO() {
        super();
    }
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    public List<TreatyParticipants> findTreatyParticipants() {
        
        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<TreatyParticipants> SetupArray = new ArrayList<TreatyParticipants>();
        try {
           
                String msgQuery = 
                    "begin LMS_SETUPS_CURSOR.treaty_participants(?,?); end;";
                cst = conn.prepareCall(msgQuery);
                      
             cst.registerOutParameter(1, 
                                     OracleTypes.CURSOR);
            cst.setBigDecimal(2,(BigDecimal)session.getAttribute("REI_CODE"));
             cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                TreatyParticipants set = new TreatyParticipants();
                set.setTrpa_agen_code(rs.getBigDecimal(1));
                set.setTrpa_agen_sht_desc(rs.getString(2));
                set.setAgn_name(rs.getString(3));
                set.setTrpa_rei_code(rs.getBigDecimal(4));
                set.setTrpa_uw_year(rs.getBigDecimal(5));
                set.setTrpa_comp_rate(rs.getBigDecimal(6));
                set.setTrpa_rei_prem_taxable(rs.getString(7));
                set.setTrpa_trs_code(rs.getBigDecimal(8));
                set.setTrpa_gl_ctrl_account(rs.getString(9));
                set.setTrpa_trs_sht_desc(rs.getString(10));
               
                SetupArray.add(set);
            }
            rs.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn,e);
        }            
      
        return SetupArray;
    }
    public List<TreatyParticipants> findReinsurers() {
        
        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<TreatyParticipants> SetupArray = new ArrayList<TreatyParticipants>();
        try {
           
                String msgQuery = 
                    "begin LMS_SETUPS_CURSOR.findReinsurers(?,?); end;";
                cst = conn.prepareCall(msgQuery);
                      
             cst.registerOutParameter(1, 
                                     OracleTypes.CURSOR);
            cst.setBigDecimal(2,(BigDecimal)session.getAttribute("REI_CODE"));
             cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                TreatyParticipants set = new TreatyParticipants();
                set.setAGEN_CODE(rs.getBigDecimal(1));
                set.setAGEN_SHT_DESC(rs.getString(2));
                set.setAGEN_NAME(rs.getString(3));
               
               
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
