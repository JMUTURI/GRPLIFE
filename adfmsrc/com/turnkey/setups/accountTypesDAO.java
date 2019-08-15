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

public class accountTypesDAO {
    public accountTypesDAO() {
        super();
    }
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    public List<accountTypes> findAccountTypes() {
        
        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<accountTypes> SetupArray = new ArrayList<accountTypes>();
        try {
           
                String msgQuery = 
                    "begin LMS_SETUPS_CURSOR.find_account_types(?); end;";
                cst = conn.prepareCall(msgQuery);
                      
             cst.registerOutParameter(1, 
                                     OracleTypes.CURSOR);
          
            
             cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
               accountTypes set = new accountTypes();
                set.setACT_CODE(rs.getBigDecimal(1));
                set.setACT_TYPE_SHT_DESC(rs.getString(2));
                set.setACT_ACCOUNT_TYPE(rs.getString(4));
                //set.setORRP_CLASS_SPECIFIC (rs.getString(4));
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
    public List<agencies> findAgencies() {
        
        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<agencies> SetupArray = new ArrayList<agencies>();
        try {
           
            String msgQuery = 
                    "begin LMS_SETUPS_CURSOR.find_acc_agencies(?,?,?); end;";
            cst = conn.prepareCall(msgQuery);
                      
            cst.registerOutParameter(1, 
                                     OracleTypes.CURSOR);
          
            cst.setBigDecimal(2,(BigDecimal)session.getAttribute("ACT_CODE"));
            if(session.getAttribute("agnNameSearch")==null){
              cst.setString(3, null);
            }else{
              cst.setString(3, (String)session.getAttribute("agnNameSearch"));
            }
            
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
               agencies set = new agencies();
                set.setAgn_code(rs.getBigDecimal(1));
                set.setAgn_sht_desc(rs.getString(2));
                set.setAgn_name(rs.getString(3));
                set.setAgn_id_no(rs.getString(4));
                set.setAgn_phone_no(rs.getString(5));
                set.setAgn_pin_no(rs.getString(6));
                set.setAgn_comm_allowed(rs.getString(7));
                //set.setAgn_comm_allowed(rs.getString(8));
                set.setAgn_contracted(rs.getString(9));
                set.setAgn_contracted_desc(rs.getString(10));
                set.setAgn_proficiency_cert_no(rs.getString(11));
                set.setAgn_contract_date(rs.getDate(12));
                set.setAgn_date_joined(rs.getDate(13));
                set.setAgn_date_terminated(rs.getDate(14));
                set.setAgn_bank(rs.getString(15));
                set.setAgn_bank_acc_no(rs.getString("agn_bank_acc_no"));
                set.setAgn_sms_tel(rs.getString(17));
                set.setAgn_email_address(rs.getString("agn_email_address"));
                set.setAgn_reinsurer(rs.getString(19));
                set.setAgn_reinsurer_desc(rs.getString(20));
                set.setAgn_acc_no(rs.getString(21));
                set.setAgn_credit_allowed(rs.getString(22));
                set.setAgn_credit_allowed_desc(rs.getString(23));
                set.setAgn_wht_tax(rs.getString(24));
                set.setAgn_print_dbnote(rs.getString(25));
                set.setAgn_print_dbnote_desc(rs.getString(26));
                set.setAgn_status(rs.getString(27));
                set.setAgn_reg_status(rs.getString(28));
                set.setAgn_reg_status_desc(rs.getString(29));
                set.setAgn_reg_number(rs.getString(30));
                set.setAgn_comm_payable(rs.getString(31));
                set.setAgn_comm_payable_desc(rs.getString(32));
                set.setAgn_comm_pymt_mthd(rs.getString(33));
                set.setAgn_comm_pymt_mthd_desc(rs.getString(34));
                set.setAgn_postal_address(rs.getString(35));
                set.setAgn_retain_wthx(rs.getString(36));
                
                //set.setORRP_CLASS_SPECIFIC (rs.getString(4));
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
    public List<accountTypes> findBankBranches() {
        
        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<accountTypes> SetupArray = new ArrayList<accountTypes>();
        try {
           
                String msgQuery = 
                    "begin LMS_SETUPS_CURSOR.findBankBranches(?); end;";
                cst = conn.prepareCall(msgQuery);
                      
             cst.registerOutParameter(1, 
                                     OracleTypes.CURSOR);
          
            
             cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
               accountTypes set = new accountTypes();
                set.setBbrCode(rs.getBigDecimal(1));
                set.setBbrDescription(rs.getString(2));
               
               
                SetupArray.add(set);
            }
            rs.close();
            conn.close();
            

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn,e);
        }            
      
        return SetupArray;
    }
    public List<accountTypes> findCommissionRates() {
        
        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<accountTypes> SetupArray = new ArrayList<accountTypes>();
        try {
           
                String msgQuery = 
                    "begin LMS_SETUPS_CURSOR.findCommRates(?,?); end;";
                cst = conn.prepareCall(msgQuery);
                      
             cst.registerOutParameter(1, 
                                     OracleTypes.CURSOR);
          
            cst.setBigDecimal(2,(BigDecimal)session.getAttribute("ACT_CODE"));
             cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
               accountTypes set = new accountTypes();
                set.setAtrCode(rs.getBigDecimal(1));
                set.setAtrDesc(rs.getString(2));
               
               
                SetupArray.add(set);
            }
            rs.close();
            conn.close();
            

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn,e);
        }            
      
        return SetupArray;
    }
    public List<accountTypes> findBranches() {
        
        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<accountTypes> SetupArray = new ArrayList<accountTypes>();
        try {
           
                String msgQuery = 
                    "begin LMS_SETUPS_CURSOR.findBranches(?); end;";
                cst = conn.prepareCall(msgQuery);
                      
             cst.registerOutParameter(1, 
                                     OracleTypes.CURSOR);
          
            
             cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
               accountTypes set = new accountTypes();
                set.setBrnCode(rs.getBigDecimal(1));
                set.setBrnShtDesc(rs.getString(2));
                set.setBrnName(rs.getString(3));
               
                SetupArray.add(set);
            }
            rs.close();
            conn.close();
            

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn,e);
        }            
      
        return SetupArray;
    }
    public List<accountTypes> findNewAgents() {
        
        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<accountTypes> SetupArray = new ArrayList<accountTypes>();
        try {
           
                String msgQuery = 
                    "begin LMS_SETUPS_CURSOR.newAgents(?,?); end;";
                cst = conn.prepareCall(msgQuery);
                      
             cst.registerOutParameter(1, 
                                     OracleTypes.CURSOR);
            cst.setBigDecimal(2,(BigDecimal)session.getAttribute("ACT_CODE"));
            
             cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
               accountTypes set = new accountTypes();
                set.setAgnCode(rs.getBigDecimal(1));
                set.setAgnName(rs.getString(2));
                set.setAgnStatus(rs.getString(3));
               
                SetupArray.add(set);
            }
            rs.close();
            conn.close();
            

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn,e);
        }            
      
        return SetupArray;
    }
    public List<accountTypes> findContactPersons() {
        
        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<accountTypes> SetupArray = new ArrayList<accountTypes>();
        try {
           
                String msgQuery = 
                    "begin LMS_SETUPS_CURSOR.findAgencyContacts(?,?); end;";
                cst = conn.prepareCall(msgQuery);
                      
             cst.registerOutParameter(1, 
                                     OracleTypes.CURSOR);
            cst.setBigDecimal(2,(BigDecimal)session.getAttribute("AGN_CODE"));
            
             cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
               accountTypes set = new accountTypes();
                set.setLacCode(rs.getBigDecimal(1));
                set.setLacContactTitle(rs.getString(3));
                set.setLacContactPerson(rs.getString(2));
                set.setLac_telephone(rs.getString(5));
                set.setLac_sex(rs.getString(6));
                set.setLac_address(rs.getString(7));
                set.setLac_contact_name(rs.getString(8));
                set.setLac_contact_email(rs.getString(9));
               
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
