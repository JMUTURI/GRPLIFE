package LMSG.view.Accounts;

import LMSG.view.Base.GlobalCC;

import LMSG.view.connect.DBConnector;

import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import oracle.jdbc.internal.OracleTypes;


public class UprDAO {
    
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    public List<UprBean> findUprs() {

        List<UprBean> classes = null;
        DBConnector connection =new DBConnector();
        String query = "begin LMS_UPR_PKG.get_upr_transactions(?);end;";
        CallableStatement stmt = null;
        Connection conn = null;
        try {
            List<UprBeans> subclasses = null;
            classes = new ArrayList<UprBean>();
            conn = connection.getDatabaseConn();
            stmt = conn.prepareCall(query);
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            ResultSet rst = (ResultSet)stmt.getObject(1);

            while (rst.next()) {
                subclasses = new ArrayList<UprBeans>();
                UprBean param = new UprBean();
               // param.setUtrans_code(rst.getBigDecimal(1));
               // param.setUtrans_month(rst.getBigDecimal(3));
                param.setUtrans_year(rst.getBigDecimal(1));
                param.setType("P");
                CallableStatement stmt2 =
                    conn.prepareCall("begin LMS_UPR_PKG.get_upr_transactions_by_yr(?,?);end;");

                stmt2.setBigDecimal(2, rst.getBigDecimal(1));
                stmt2.registerOutParameter(1, OracleTypes.CURSOR);
                stmt2.execute();
                ResultSet rs = (ResultSet)stmt2.getObject(1);
                while (rs.next()) {
                    UprBeans def = new UprBeans();
                    def.setUtrans_code(rs.getBigDecimal(1));
                    def.setUtrans_month(rs.getBigDecimal(2));
                    def.setUtrans_year(rs.getBigDecimal(3));
                    def.setMonthName(getMonth(rs.getBigDecimal(3)));
                    def.setType("S");
                    subclasses.add(def);
                }
                param.setUprs(subclasses);
                classes.add(param);
                rs.close();
                stmt2.close();
            }
            rst.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
            GlobalCC.EXCEPTIONREPORTING(conn,e);
        }
        return classes;
    }
    
    public  List<UprBean> findUprSummary() {
        List<UprBean> classes = null;
        classes = new ArrayList<UprBean>();
        DBConnector connection =new DBConnector();
        String query = "begin LMS_UPR_PKG.get_upr_trans_summary(?,?);end;";
        CallableStatement stmt = null;
        Connection conn = null;
        try {
            classes = new ArrayList<UprBean>();
            conn = connection.getDatabaseConn();
            stmt = conn.prepareCall(query);
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.setBigDecimal(2, (BigDecimal)session.getAttribute("transCode"));
            stmt.execute();
            ResultSet rst = (ResultSet)stmt.getObject(1);

            while (rst.next()) {
                UprBean param = new UprBean();
                param.setUsum_code(rst.getBigDecimal(1));
                param.setUsum_utrans_code(rst.getBigDecimal(2));
                param.setUsum_scl_code(rst.getBigDecimal(3));
                param.setUsum_brn_code(rst.getBigDecimal(4));
                param.setUsum_cur_code(rst.getBigDecimal(5));
                param.setUsum_gross_prem(rst.getBigDecimal(6));
                param.setUsum_gross_comm(rst.getBigDecimal(7));
                param.setUsum_mand_prem(rst.getBigDecimal(8));
                param.setUsum_mand_comm(rst.getBigDecimal(9));
                param.setUsum_quota_prem(rst.getBigDecimal(10));
                param.setUsum_quota_comm(rst.getBigDecimal(11));
                param.setUsum_fstsup_prem(rst.getBigDecimal(12));
                param.setUsum_fstsup_comm(rst.getBigDecimal(13));
                param.setUsum_secsup_prem(rst.getBigDecimal(14));
                param.setUsum_secsup_comm(rst.getBigDecimal(15));
                param.setUsum_facre_prem(rst.getBigDecimal(16));
                param.setUsum_facre_comm(rst.getBigDecimal(17));
                param.setUsum_facob_prem(rst.getBigDecimal(18));
                param.setUsum_facob_comm(rst.getBigDecimal(19));
                param.setUsum_pool_prem(rst.getBigDecimal(20));
                param.setUsum_pool_comm(rst.getBigDecimal(21));
                param.setUsum_prev_usum_code(rst.getBigDecimal(22));
                param.setScl_desc(rst.getString(23));
                param.setBrn_name(rst.getString(24));
                param.setCur_desc(rst.getString(25));
                param.setUsum_unearned_prem(rst.getBigDecimal(26));
                param.setUsum_unearned_com(rst.getBigDecimal(27));
                classes.add(param);
            }
        } catch (Exception e) {
            e.printStackTrace();
            GlobalCC.EXCEPTIONREPORTING(conn,e);
        }
        return classes;
    }
    
    
    private String getMonth(BigDecimal monthNo) throws Exception {
        int month=monthNo.intValue();
        switch(month){
            case 1:
               return "Jan";
            case 2:
                return "Feb";
            case 3:
                return "Mar";
            case 4:
                return "Apr";
            case 5:
                return "May";
            case 6:
                return "Jun";
            case 7:
                return "Jul";
            case 8:
                return "Aug";
            case 9:
                return "Sep";
            case 10:
                return "Oct";
            case 11:
                return "Nov";
            case 12:
                return "Dec";
        default:
              throw new Exception("Invalid Month");
            
        }
    }
    
    
    public  List<UprBean> findUprDetails() {
        List<UprBean> classes = null;
        classes = new ArrayList<UprBean>();
        DBConnector connection =new DBConnector();
        String query = "begin LMS_UPR_PKG.get_upr_trans_details(?,?);end;";
        CallableStatement stmt = null;
        Connection conn = null;
        try {
            classes = new ArrayList<UprBean>();
            conn = connection.getDatabaseConn();
            stmt = conn.prepareCall(query);
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.setBigDecimal(2, (BigDecimal)session.getAttribute("transCode"));
            stmt.execute();
            ResultSet rst = (ResultSet)stmt.getObject(1);

            while (rst.next()) {
                UprBean param = new UprBean();
                param.setUp_code(rst.getBigDecimal(1));
                param.setProd_desc(rst.getString(2));
                param.setUp_pol_policy_no(rst.getString(3));
                param.setUp_unearned_mnths_days(rst.getBigDecimal(4));
                param.setCur_desc(rst.getString(5));
                param.setUp_gross_prem(rst.getBigDecimal(6));
                param.setUp_unearned_prem(rst.getBigDecimal(7));
                param.setUp_policy_cover_from(rst.getDate(8));
                param.setUp_policy_cover_to(rst.getDate(9));
                param.setUp_gross_comm(rst.getBigDecimal(10));
                param.setUp_unearned_comm(rst.getBigDecimal(11));
                param.setUp_ri_prem(rst.getBigDecimal(12));
                param.setUp_unearned_ri_prem(rst.getBigDecimal(13));
                param.setUp_ricomm(rst.getBigDecimal(14));
                param.setUp_unearned_ri_comm(rst.getBigDecimal(15));
                
                classes.add(param);
            }
        } catch (Exception e) {
            e.printStackTrace();
            GlobalCC.EXCEPTIONREPORTING(conn,e);
        }
        return classes;
    }
  public List<UprBean> findIbnr() {

        List<UprBean> classes = null;
        DBConnector connection =new DBConnector();
        String query = "begin GIS_IBNR_PKG.get_ibnr_transactions(?);end;";
        CallableStatement stmt = null;
        Connection conn = null;
        try {
            List<UprBeans> subclasses = null;
            classes = new ArrayList<UprBean>();
            conn = connection.getDatabaseConn();
            stmt = conn.prepareCall(query);
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            ResultSet rst = (ResultSet)stmt.getObject(1);

            while (rst.next()) {
                subclasses = new ArrayList<UprBeans>();
                UprBean param = new UprBean();
               // param.setUtrans_code(rst.getBigDecimal(1));
               // param.setUtrans_month(rst.getBigDecimal(3));
                param.setUtrans_year(rst.getBigDecimal(1));
                param.setType("P");
                CallableStatement stmt2 =
                    conn.prepareCall("begin GIS_IBNR_PKG.get_ibnr_transactions_by_yr(?,?);end;");

                stmt2.setBigDecimal(2, rst.getBigDecimal(1));
                stmt2.registerOutParameter(1, OracleTypes.CURSOR);
                stmt2.execute();
                ResultSet rs = (ResultSet)stmt2.getObject(1);
                while (rs.next()) {
                    UprBeans def = new UprBeans();
                    def.setUtrans_code(rs.getBigDecimal(1));
                    def.setUtrans_month(rs.getBigDecimal(2));
                    def.setUtrans_year(rs.getBigDecimal(3));
                    def.setMonthName(getMonth(rs.getBigDecimal(3)));
                    def.setType("S");
                    subclasses.add(def);
                }
                param.setUprs(subclasses);
                classes.add(param);
                rs.close();
                stmt2.close();
            }
            rst.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
            GlobalCC.EXCEPTIONREPORTING(conn,e);
        }
        return classes;
    }
    public  List<UprBean> findIbnrSummary() {
           List<UprBean> classes = null;
           classes = new ArrayList<UprBean>();
           DBConnector connection =new DBConnector();
           String query = "begin GIS_IBNR_PKG.get_ibnr_trans_summary(?,?);end;";
           CallableStatement stmt = null;
           Connection conn = null;
           try {
               classes = new ArrayList<UprBean>();
               conn = connection.getDatabaseConn();
               stmt = conn.prepareCall(query);
               stmt.registerOutParameter(1, OracleTypes.CURSOR);
               stmt.setBigDecimal(2, (BigDecimal)session.getAttribute("transCode"));
               stmt.execute();
               ResultSet rst = (ResultSet)stmt.getObject(1);

               while (rst.next()) {
                   UprBean param = new UprBean();
                   param.setIbnrCode(rst.getBigDecimal(1));
                   param.setIbnrSclCode(rst.getBigDecimal(2));
                   param.setIbnr_grs_ibnr_y1(rst.getBigDecimal(3));
                   param.setIbnr_grs_ibnr_y2(rst.getBigDecimal(4));
                   param.setIbnr_grs_ibnr_y3(rst.getBigDecimal(5));
                   param.setIbnr_grs_ibnr_tot(rst.getBigDecimal(6));
                   param.setIbnr_man_ibnr_y1(rst.getBigDecimal(7));
                   param.setIbnr_man_ibnr_y2(rst.getBigDecimal(8));
                   param.setIbnr_man_ibnr_y3(rst.getBigDecimal(9));
                  param.setIbnr_man_ibnr_tot(rst.getBigDecimal(10));
                   param.setIbnr_quota_ibnr_y1(rst.getBigDecimal(11));
                   param.setIbnr_quota_ibnr_y2(rst.getBigDecimal(12));
                   param.setIbnr_quota_ibnr_y3(rst.getBigDecimal(13));
                  param.setIbnr_quota_ibnr_tot(rst.getBigDecimal(14));
                   param.setIbnr_fstsup_ibnr_y1(rst.getBigDecimal(15));
                  param.setIbnr_fstsup_ibnr_y2(rst.getBigDecimal(16));
                   param.setIbnr_fstsup_ibnr_y3(rst.getBigDecimal(17));
                 param.setIbnr_fstsup_ibnr_tot(rst.getBigDecimal(18));            
                   
                   param.setIbnr_secsup_ibnr_y1(rst.getBigDecimal(19));
                 param.setIbnr_secsup_ibnr_y2(rst.getBigDecimal(20));
                 param.setIbnr_secsup_ibnr_y3(rst.getBigDecimal(21));
                 param.setIbnr_secsup_ibnr_tot(rst.getBigDecimal(22));
                   
                   
                   param.setIbnr_facre_ibnr_y1(rst.getBigDecimal(23));
                 param.setIbnr_facre_ibnr_y2(rst.getBigDecimal(24));
                 param.setIbnr_facre_ibnr_y3(rst.getBigDecimal(25));
                 param.setIbnr_facre_ibnr_tot(rst.getBigDecimal(26));
                  param.setIbnr_own_ibnr_y1(rst.getBigDecimal(27));
                 param.setIbnr_own_ibnr_y2(rst.getBigDecimal(28));
                 param.setIbnr_own_ibnr_y3(rst.getBigDecimal(29));
                 param.setIbnr_own_ibnr_tot(rst.getBigDecimal(30));
                  param.setIbnrbrnCode(rst.getBigDecimal(31));
                    param.setIbnrCurrRate(rst.getBigDecimal(32));
                   param.setIbnrCurrCode(rst.getBigDecimal(33));
                   param.setIbnr_prev_ibnr_code(rst.getBigDecimal(34));
                   param.setBrnName(rst.getString(35));
                   param.setCurrSymbol(rst.getString(36));
                   param.setCurrDescription(rst.getString(37));
                   param.setSclDesc(rst.getString(38));
                 param.setIbnr_pool_ibnr_y1(rst.getBigDecimal(39));
                 param.setIbnr_pool_ibnr_y2(rst.getBigDecimal(40));
                 param.setIbnr_pool_ibnr_y3(rst.getBigDecimal(41));
                 param.setIbnr_pool_ibnr_tot(rst.getBigDecimal(42));
                 param.setIbnr_facre_obibnr_y1(rst.getBigDecimal(43));
                 param.setIbnr_facre_obibnr_y2(rst.getBigDecimal(44));
                 param.setIbnr_facre_obibnr_y3(rst.getBigDecimal(45));
                 param.setIbnr_facre_obibnr_tot(rst.getBigDecimal(46));
                  classes.add(param);
               }
           } catch (Exception e) {
               e.printStackTrace();
               GlobalCC.EXCEPTIONREPORTING(conn,e);
           }
           return classes;
       }

    
}