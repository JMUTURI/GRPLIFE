package LMSG.view.Policy;

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
import LMSG.view.Base.LOVCC;

import LMSG.view.connect.DBConnector;

public class ri_detailsDAO extends LOVCC {
  public ri_detailsDAO() {
  }
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
  public List<ri_details> FindRiDetails() {
      DBConnector myConn=new DBConnector();
     Connection conn=myConn.getDatabaseConn();
     CallableStatement cst=null;
     List<ri_details> MemberList=new ArrayList<ri_details>();
    
     try {
       String polQuery="begin LMS_WEB_CURSOR_GRP.getMemRiDtls(?,?,?);end;";
       cst=conn.prepareCall(polQuery);
       cst.registerOutParameter(1,OracleTypes.CURSOR);
       cst.setBigDecimal(2,(BigDecimal)session.getAttribute("endorsementCode"));
       cst.setBigDecimal(3, (BigDecimal)session.getAttribute("MemberNumber"));
      
       cst.execute();
       ResultSet rst=(ResultSet)cst.getObject(1);
         int i =0;
       while(rst.next()){
         ri_details myMem=new ri_details();
     
           myMem.setCOVER_DISPLAY(rst.getString(1));
           myMem.setPMRID_PREV_SA(rst.getBigDecimal(2));
           myMem.setPMRID_TOT_SA(rst.getBigDecimal(3));
           myMem.setPMRID_ENDR_PREM(rst.getBigDecimal(4));
           myMem.setPMRID_GROSS_RETENTION(rst.getBigDecimal(5));
           myMem.setPMRID_NET_RETENTION(rst.getBigDecimal(6));
           myMem.setPMRID_NET_RETENTION_RATE(rst.getBigDecimal(7));
           myMem.setPMRID_EXCESS_AMT(rst.getBigDecimal(8));
           myMem.setPMRID_CODE(rst.getBigDecimal(9));
           /*if (i == 0){
               session.setAttribute("pmrid_code", rst.getBigDecimal(9)); 
               //System.out.println("Code1" + session.getAttribute("pmrid_code"));
               i++;
           }*/
              
       
         MemberList.add(myMem);
        
       }
       rst.close();
       cst.close();
         conn.close();    
       
     }
     catch(Exception e) {
       GlobalCC.EXCEPTIONREPORTING(conn, e);
     }
     return MemberList;
   }
  public List<memRiTrtDetails> FindRiTrtDetails() {
      DBConnector myConn=new DBConnector();
     Connection conn=myConn.getDatabaseConn();
     CallableStatement cst=null;
     List<memRiTrtDetails> MemberList=new ArrayList<memRiTrtDetails>();
    
     try {
       String polQuery="begin LMS_WEB_CURSOR_GRP.getMemRiTrtDtls(?,?,?);end;";
       cst=conn.prepareCall(polQuery);
       cst.registerOutParameter(1,OracleTypes.CURSOR);
       cst.setBigDecimal(2,(BigDecimal)session.getAttribute("MemberNumber"));
       cst.setBigDecimal(3,(BigDecimal)session.getAttribute("pmrid_code"));
       //System.out.println("Code1i" + session.getAttribute("pmrid_code"));
      
       cst.execute();
       ResultSet rst=(ResultSet)cst.getObject(1);
         int i = 0;
       while(rst.next()){
         memRiTrtDetails myMem=new memRiTrtDetails();
     
           myMem.setCOVER_DISPLAY(rst.getString(1));
           myMem.setREI_TRS_SHT_DESC(rst.getString(2));
           myMem.setPMRITD_PREV_TRT_SA(rst.getBigDecimal(3));
           myMem.setPMRITD_TRT_SA(rst.getBigDecimal(4));
           myMem.setPMRITD_CESSION_RATE(rst.getBigDecimal(5));
           myMem.setPMRITD_TRT_PREM(rst.getBigDecimal(6));
           myMem.setPMRITD_TRT_COMM(rst.getBigDecimal(7));
           myMem.setPMRITD_STAMP_DUTY(rst.getBigDecimal(8));
           myMem.setPMRITD_remarks(rst.getString(9));   
           myMem.setPMRITD_CODE(rst.getBigDecimal(10));
           myMem.setPMRITD_RATE(rst.getBigDecimal(11));
           myMem.setPMRITD_RATE_DIV_FACTOR(rst.getBigDecimal(12));
           if (i == 0){
           session.setAttribute("pmritd_code", rst.getBigDecimal(10));
               System.out.println(session.getAttribute("pmritd_code"));
               System.out.println("Code2" + session.getAttribute("pmritd_code"));
           i++;
           }
       
         MemberList.add(myMem);
        
       }
       rst.close();
       cst.close();
         conn.close();    
       
     }
     catch(Exception e) {
       GlobalCC.EXCEPTIONREPORTING(conn, e);
     }
     return MemberList;
   }
  
  public List<memRiTrtDetails> FindAALMem() {
      DBConnector myConn=new DBConnector();
     Connection conn=myConn.getDatabaseConn();
     CallableStatement cst=null;
     List<memRiTrtDetails> MemberList=new ArrayList<memRiTrtDetails>();
    
     try {
       String polQuery="begin LMS_WEB_CURSOR_GRP.getaalmem(?,?);end;";
       cst=conn.prepareCall(polQuery);
       cst.registerOutParameter(1,OracleTypes.CURSOR);
       cst.setBigDecimal(2,(BigDecimal)session.getAttribute("endorsementCode"));
       cst.execute();
       ResultSet rst=(ResultSet)cst.getObject(1);
         int i = 0;         
       while(rst.next()){
         memRiTrtDetails myMem=new memRiTrtDetails();
           myMem.setMemName(rst.getString(1));
           myMem.setCOVER_DISPLAY(rst.getString(2));
           myMem.setRmal_amt_reassured(rst.getBigDecimal(3));
           myMem.setRmal_tct_aal(rst.getBigDecimal(4));           
           MemberList.add(myMem); 
           i++;
       }
         if(i>0){
           session.setAttribute("riMedicals","Y");
         }else{
           session.setAttribute("riMedicals","N");
         }
       rst.close();
       cst.close();
         conn.close();    
       
     }
     catch(Exception e) {
       GlobalCC.EXCEPTIONREPORTING(conn, e);
     }
     return MemberList;
   }
  
    public List<memRiTrtDetails> FindRiTrtCessions() {
        DBConnector myConn=new DBConnector();
       Connection conn=myConn.getDatabaseConn();
       CallableStatement cst=null;
       List<memRiTrtDetails> MemberList=new ArrayList<memRiTrtDetails>();
      
       try {
         String polQuery="begin LMS_WEB_CURSOR_GRP.getmemtrtcodtls(?,?);end;";
         cst=conn.prepareCall(polQuery);
         cst.registerOutParameter(1,OracleTypes.CURSOR);
         cst.setBigDecimal(2,(BigDecimal)session.getAttribute("pmritd_code"));
           //System.out.println("Code2i" + session.getAttribute("pmritd_code"));
        
         cst.execute();
         ResultSet rst=(ResultSet)cst.getObject(1);
         while(rst.next()){
           memRiTrtDetails myMem=new memRiTrtDetails();

             myMem.setCVT_SHT_DESC(rst.getString(1));
             myMem.setGTRIC_AGN_SHT_DESC(rst.getString(2));
             myMem.setGTRIC_TRS_SHT_DESC(rst.getString(3));
             myMem.setGTRIC_TRT_SHT_DESC(rst.getString(4));
             myMem.setGTRIC_CEDE_RATE(rst.getString(5));
             myMem.setGTRIC_SI_AMT_PCUR(rst.getString(6));
             myMem.setGTRIC_PREM_AMT_PCUR(rst.getString(7));
             myMem.setGTRIC_COMM_AMT_PCUR(rst.getString(8));
             myMem.setGTRIC_STAMP_DUTY(rst.getString(9));  
             myMem.setGTRIC_RPREM_TAX_PCUR(rst.getString(10));
             myMem.setGTRIC_PREM_TAX_PCUR(rst.getString(11));
             myMem.setGTRIC_UWYR(rst.getString(12));
             myMem.setGTRIC_REFUND_PREM(rst.getString(13));
         
           MemberList.add(myMem);
          
         }
         rst.close();
         cst.close();
           conn.close();    
         
       }
       catch(Exception e) {
         GlobalCC.EXCEPTIONREPORTING(conn, e);
       }
       return MemberList;
     }
    
  public List<memRiTrtDetails> findFulcatativePlacements() {
      DBConnector datahandler = null;
      datahandler = new DBConnector();
      Connection conn;
      conn = datahandler.getDatabaseConn();

      CallableStatement cst = null;
      List<memRiTrtDetails> reinCvtDtls = new ArrayList<memRiTrtDetails>();
      try {
          String reinsQuery = "begin LMS_WEB_CURSOR_GRP.FindFacultativePlacement(?,?); end;";
          cst = conn.prepareCall(reinsQuery);

          //register out
          cst.registerOutParameter(1, OracleTypes.CURSOR);

          cst.setBigDecimal(2,
                            (BigDecimal)session.getAttribute("pmrid_code"));

          cst.execute();
          ResultSet rs = (ResultSet)cst.getObject(1);
          session.setAttribute("facPlacements", "N");
          while (rs.next()) {
              memRiTrtDetails rein = new memRiTrtDetails();
              rein.setGfcCode(rs.getBigDecimal(1));
              rein.setGfcAgnDesc(rs.getString(2));
              rein.setGfcAmtOrRate(rs.getString(3));
              rein.setGfcAmt(rs.getBigDecimal(4));
              rein.setGfcRate(rs.getBigDecimal(5));
              rein.setGfcExcessRate(rs.getBigDecimal(6));
              rein.setGfcPremRate(rs.getBigDecimal(7));
              rein.setGfcPremDivFactor(rs.getBigDecimal(8));
              rein.setGfcPremAmt(rs.getBigDecimal(9));
              rein.setGfcCommRate(rs.getBigDecimal(10));
              rein.setGfcCommAmt(rs.getBigDecimal(11));
              rein.setGfcWef(rs.getDate(12));
              rein.setGfcAgnCode(rs.getBigDecimal(13));
              rein.setCvtCode(rs.getBigDecimal(14));
              rein.setCvtDesc(rs.getString(15));
              session.setAttribute("facPlacements", "Y");
              reinCvtDtls.add(rein);
          }
          rs.close();
          conn.commit();
          conn.close();
      } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
      }

      return reinCvtDtls;

  }
  
  public List<memRiTrtDetails> findSchemeFacrePlacements() {
      DBConnector datahandler = null;
      datahandler = new DBConnector();
      Connection conn;
      conn = datahandler.getDatabaseConn();

      CallableStatement cst = null;
      List<memRiTrtDetails> reinCvtDtls = new ArrayList<memRiTrtDetails>();
      try {
          String reinsQuery = "begin LMS_WEB_CURSOR_GRP.FindSchemeFacultativePlcmts(?,?); end;";
          cst = conn.prepareCall(reinsQuery);

          //register out
          cst.registerOutParameter(1, OracleTypes.CURSOR);

          cst.setBigDecimal(2,
                            (BigDecimal)session.getAttribute("endorsementCode"));

          cst.execute();
          ResultSet rs = (ResultSet)cst.getObject(1);
          int i = 0;
          while (rs.next()) {
              memRiTrtDetails rein = new memRiTrtDetails();
              rein.setGfcCode(rs.getBigDecimal(1));
              rein.setGfcAgnDesc(rs.getString(2));
              rein.setGfcAmtOrRate(rs.getString(3));
              if(i==0){
                session.setAttribute("rateAmt", rs.getString(3));
                i++;
              }
              rein.setGfcAmt(rs.getBigDecimal(4));
              rein.setGfcRate(rs.getBigDecimal(5));
              rein.setGfcExcessRate(rs.getBigDecimal(6));
              rein.setGfcPremRate(rs.getBigDecimal(7));
              rein.setGfcPremDivFactor(rs.getBigDecimal(8));
              rein.setGfcPremAmt(rs.getBigDecimal(9));
              rein.setGfcCommRate(rs.getBigDecimal(10));
              rein.setGfcCommAmt(rs.getBigDecimal(11));
              rein.setGfcWef(rs.getDate(12));
              rein.setGfcAgnCode(rs.getBigDecimal(13));
              rein.setCvtCode(rs.getBigDecimal(14));
              rein.setCvtDesc(rs.getString(15));
              reinCvtDtls.add(rein);
          }
          if(i==0){
            session.setAttribute("rateAmt", null);
          }
          rs.close();
          cst.close();
          conn.close();
      } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
      }

      return reinCvtDtls;

  }
  
  public List<memRiTrtDetails> findRiCompanies() {
      DBConnector datahandler = null;
      datahandler = new DBConnector();
      Connection conn;
      conn = datahandler.getDatabaseConn();

      CallableStatement cst = null;
      List<memRiTrtDetails> reinCvtDtls = new ArrayList<memRiTrtDetails>();
      try {
          String reinsQuery = "begin LMS_WEB_CURSOR_GRP.RI_campanies(?,?); end;";
          cst = conn.prepareCall(reinsQuery);

          //register out
          cst.registerOutParameter(1, OracleTypes.CURSOR);

          cst.setBigDecimal(2, (BigDecimal)session.getAttribute("pmrid_code"));

          cst.execute();
          ResultSet rs = (ResultSet)cst.getObject(1);
          while (rs.next()) {
              memRiTrtDetails rein = new memRiTrtDetails();
              rein.setAgnShtDesc(rs.getString(1));
              rein.setAgnName(rs.getString(2));
              rein.setAgnCode(rs.getBigDecimal(3));
              reinCvtDtls.add(rein);
          }
          rs.close();
          conn.commit();
          conn.close();
      } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
      }

      return reinCvtDtls;

  }
  
  public List<memRiTrtDetails> findTotalMemberRiExcess() {
      DBConnector datahandler = null;
      datahandler = new DBConnector();
      Connection conn;
      conn = datahandler.getDatabaseConn();

      CallableStatement cst = null;
      List<memRiTrtDetails> reinCvtDtls = new ArrayList<memRiTrtDetails>();
      try {
          String reinsQuery = "begin LMS_WEB_CURSOR_GRP.getReinsureExcesses(?,?); end;";
          cst = conn.prepareCall(reinsQuery);

          //register out
          cst.registerOutParameter(1, OracleTypes.CURSOR);

          cst.setBigDecimal(2, (BigDecimal)session.getAttribute("endorsementCode"));

          cst.execute();
          ResultSet rs = (ResultSet)cst.getObject(1);
          while (rs.next()) {
              memRiTrtDetails rein = new memRiTrtDetails();

              rein.setTot_sa(rs.getBigDecimal(1));
              rein.setTot_ret(rs.getBigDecimal(2));
              rein.setTot_excess(rs.getBigDecimal(3));
              reinCvtDtls.add(rein);
          }
          rs.close();
          conn.commit();
          conn.close();
      } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
      }

      return reinCvtDtls;

  }
}
