package LMSG.view.Policy;

import LMSG.view.Base.GlobalCC;

import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import oracle.jdbc.internal.OracleTypes;

import LMSG.view.Base.LOVCC;

import LMSG.view.QuotationProcessing.QuotDAO;

import LMSG.view.connect.DBConnector;

public class policyMembersDAO extends LOVCC {
  public policyMembersDAO() {
  }
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
  public List<policyMembers> FindPolicyMembers() 
  {
      DBConnector myConn=new DBConnector();
      Connection conn=myConn.getDatabaseConn();
      CallableStatement cstmt=null;
    List<policyMembers> PolicyList=new ArrayList<policyMembers>();
    String updateQuery="BEGIN Lms_Endorsements_Members_Proc.query_uw_qry(?,?,?);end;";
    
    try 
    {
       String RenewalArea = (String)session.getAttribute("RenewalArea");
       if(RenewalArea==null){
         updateQuery="BEGIN Lms_Endorsements_Members_Proc.query_uw_qry(?,?,?);end;";
       }else if(RenewalArea.equalsIgnoreCase("Y")){
         updateQuery="BEGIN Lms_Endorsements_Members_Proc.Ren_query_uw_qry(?,?,?);end;";
       }else{
         updateQuery="BEGIN Lms_Endorsements_Members_Proc.query_uw_qry(?,?,?);end;";
       }
        
      cstmt=conn.prepareCall(updateQuery);
      cstmt.registerOutParameter(1,OracleTypes.CURSOR);
      cstmt.setBigDecimal(2, (BigDecimal)session.getAttribute("policyCode"));
      cstmt.setBigDecimal(3, (BigDecimal)session.getAttribute("endorsementCode"));
      cstmt.execute();
     
      ResultSet rs=(ResultSet)cstmt.getObject(1);
        int i = 0;
        int rows=0;
      while(rs.next())
      {
        policyMembers member=new policyMembers();
        member.setPOLM_CODE(rs.getBigDecimal(1));
        if(i == 0){
          //LOVCC.MemberNumber=rs.getBigDecimal(1);
            session.setAttribute("MemberNumber", rs.getBigDecimal(1));
          i++;
        }
        member.setPOLM_POL_CODE(rs.getBigDecimal(2));
        member.setPOLM_MEM_CODE(rs.getBigDecimal(3));
        member.setPOLM_DTY_CODE(rs.getBigDecimal(4));
        member.setPOLM_JOINT_MEMBERS(rs.getString(5));
        member.setPOLM_PRINCIPAL_MEM_CODE(rs.getBigDecimal(6));
        member.setPOLM_MEM_NO(rs.getString(7));
        member.setPOLM_DTY_SHT_DESC(rs.getString(8));
        member.setPOLM_MREQ_MTG_CODE(rs.getBigDecimal(9));
        member.setMEMBER_DISPLAY(rs.getString(10));
        member.setPOLM_TOT_SA(rs.getBigDecimal(11));
        member.setPOLM_LOADING_TYPE(rs.getString(12));
        member.setPOLM_LOADING_RATE(rs.getBigDecimal(13));
        member.setPOLM_LOADING_DIV_FACT(rs.getBigDecimal(14));
        member.setPOLM_WEIGHT_LOADING(rs.getBigDecimal(15));
        member.setPOLM_BPRESS_LOADING(rs.getBigDecimal(16));
        member.setPOLM_WEIGHT(rs.getBigDecimal(17));
        member.setPOLM_HEIGHT(rs.getBigDecimal(18));
        member.setPOLM_SYSTOLIC_PR(rs.getBigDecimal(19));
        member.setPOLM_DIASTOLIC_PR(rs.getBigDecimal(20));
        member.setPOLM_ANB(rs.getBigDecimal(21));
        member.setPOLM_COVER_OFFERED(rs.getString(22));
        member.setCATEGORY(rs.getString(24));  
        PolicyList.add(member);
          
        rows++;
          
      }
        if(rows==100){
          GlobalCC.INFORMATIONREPORTING("More rows exist please refine your search");
        }
      
        conn.close();    
    }
    catch(Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return PolicyList;
    
  }
  
  public List<policyMembers> FindPolicyMemberAtCovers() 
  {
      DBConnector myConn=new DBConnector();
      Connection conn=myConn.getDatabaseConn();
      CallableStatement cstmt=null;
    List<policyMembers> PolicyList=new ArrayList<policyMembers>();
    String updateQuery="BEGIN Lms_Endorsements_Members_Proc.query_uw_qry_cvrs(?,?,?,?,?,?);end;";
    
    try 
    {
       String RenewalArea = (String)session.getAttribute("RenewalArea");
       if(RenewalArea==null){
         updateQuery="BEGIN Lms_Endorsements_Members_Proc.query_uw_qry_cvrs(?,?,?,?,?,?);end;";
       }else if(RenewalArea.equalsIgnoreCase("Y")){
         updateQuery="BEGIN Lms_Endorsements_Members_Proc.Ren_query_uw_qry(?,?,?,?,?,?);end;";
       }else{
         updateQuery="BEGIN Lms_Endorsements_Members_Proc.query_uw_qry_cvrs(?,?,?,?,?,?);end;";
       }
        
      cstmt=conn.prepareCall(updateQuery);
      cstmt.registerOutParameter(1,OracleTypes.CURSOR);
      cstmt.setBigDecimal(2, (BigDecimal)session.getAttribute("policyCode"));
      cstmt.setBigDecimal(3, (BigDecimal)session.getAttribute("endorsementCode"));
      cstmt.setString(4,(String)session.getAttribute("srchMemNo"));
      cstmt.setString(5,(String)session.getAttribute("srchMemName"));
      cstmt.setInt(6, GlobalCC.RowsLimit);
      cstmt.execute();
     
      ResultSet rs=(ResultSet)cstmt.getObject(1);
        int i = 0;
        int rows=0;

        session.setAttribute("limitExceeded", "N");
      while(rs.next())
      {
        policyMembers member=new policyMembers();
        member.setPOLM_CODE(rs.getBigDecimal(1));
        if(i == 0){
          //LOVCC.MemberNumber=rs.getBigDecimal(1);
            session.setAttribute("MemberNumber", rs.getBigDecimal(1));
          i++;
        }
        member.setPOLM_POL_CODE(rs.getBigDecimal(2));
        member.setPOLM_MEM_CODE(rs.getBigDecimal(3));
        member.setPOLM_DTY_CODE(rs.getBigDecimal(4));
        member.setPOLM_JOINT_MEMBERS(rs.getString(5));
        member.setPOLM_PRINCIPAL_MEM_CODE(rs.getBigDecimal(6));
        member.setPOLM_MEM_NO(rs.getString(7));
        member.setPOLM_DTY_SHT_DESC(rs.getString(8));
        member.setPOLM_MREQ_MTG_CODE(rs.getBigDecimal(9));
        member.setMEMBER_DISPLAY(rs.getString(10));
        member.setPOLM_TOT_SA(rs.getBigDecimal(11));
        member.setPOLM_LOADING_TYPE(rs.getString(12));
        member.setPOLM_LOADING_RATE(rs.getBigDecimal(13));
        member.setPOLM_LOADING_DIV_FACT(rs.getBigDecimal(14));
        member.setPOLM_WEIGHT_LOADING(rs.getBigDecimal(15));
        member.setPOLM_BPRESS_LOADING(rs.getBigDecimal(16));
        member.setPOLM_WEIGHT(rs.getBigDecimal(17));
        member.setPOLM_HEIGHT(rs.getBigDecimal(18));
        member.setPOLM_SYSTOLIC_PR(rs.getBigDecimal(19));
        member.setPOLM_DIASTOLIC_PR(rs.getBigDecimal(20));
        member.setPOLM_ANB(rs.getBigDecimal(21));
        member.setPOLM_COVER_OFFERED(rs.getString(22));
        member.setPOLM_BMI_RATE(rs.getBigDecimal(23));
        member.setCATEGORY(rs.getString(24));
        PolicyList.add(member);
          rows++;
          
          if(rows>=GlobalCC.RowsLimit){
              session.setAttribute("limitExceeded", "Y");
          }
      }

      
        conn.close();    
    }
    catch(Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return PolicyList;
    
  }
  
}
