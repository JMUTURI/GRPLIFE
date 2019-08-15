package LMSG.view.QuotationProcessing;

import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import oracle.jdbc.internal.OracleTypes;


import LMSG.view.connect.DBConnector;

import LMSG.view.connect.DBConnector;

public class memberDependentsDAO {
  public memberDependentsDAO() {
  }
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
  public List<memberDependents> findMemberDependents() {
     DBConnector myConn=new DBConnector();
    Connection conn=myConn.getDatabaseConn();
    CallableStatement cst=null;
   
    List<memberDependents> MemberDependents=new ArrayList<memberDependents>();
    try {
      String DpdQuery="begin LMS_WEB_CURSOR_GRP.get_quot_member_dependents(?,?);end;";
   
      cst=conn.prepareCall(DpdQuery);
      cst.registerOutParameter(1,OracleTypes.CURSOR);
     cst.setBigDecimal(2,(BigDecimal)session.getAttribute("QuoteCode"));
    
      cst.execute();
      
      /*cst1=conn.prepareCall(pmasQuery);
      cst1.setInt(1,Quotation.quotationCode);
      cst1.registerOutParameter(2,OracleTypes.VARCHAR);*/
      ResultSet rs=(ResultSet)cst.getObject(1);
  //      String rs1=cst1.getString(1);
      
      while (rs.next()) {
        memberDependents existQout=new memberDependents();
         existQout.setMEM_CODE(rs.getBigDecimal(1));
        existQout.setMEM_MAIN_MEM_CODE(rs.getBigDecimal(6));
        existQout.setMEM_NO(rs.getString(3));
        existQout.setMEM_SURNAME(rs.getString(8));
       existQout.setMEM_OTHER_NAMES(rs.getString(7));
        existQout.setMEM_SEX(rs.getString(3));
        existQout.setMEM_DTY_CODE(rs.getBigDecimal(9));
        existQout.setMEM_DTY_SHT_DESC(rs.getString(10));
        existQout.setMEM_PRP_CODE(rs.getBigDecimal(11));
        existQout.setMEM_IDENTITY_NO(rs.getBigDecimal(12));
        existQout.setMEM_DOB(rs.getDate(13));
        existQout.setMEM_SACCO_JOIN_DATE(rs.getDate(14));
        existQout.setMEM_TELEPHONE(rs.getString(15));
        existQout.setMEM_ADDRESS(rs.getString(16));
        existQout.setMEM_EMPLOYMENT_DATE(rs.getDate(17));
        existQout.setMEM_PRP_SHT_DESC(rs.getString(18));
        existQout.setMEM_DTY_NO(rs.getString(19));
        existQout.setMEM_SCHEDULE_NO(rs.getString(20));
        existQout.setMEM_CURRENT_SCH_NO(rs.getString(21));
        existQout.setMEM_PDL_CODE(rs.getBigDecimal(22));
        //existQout.setQuoStatus(rs.getString(17));
        
        MemberDependents.add(existQout);
      }
      
        
        //existQuotation.add(existQout);
      
      rs.close();
      cst.close();
        conn.close();   
     
      
    }
    catch(Exception e) {
      e.printStackTrace();
    }
    return MemberDependents;
  }
}
