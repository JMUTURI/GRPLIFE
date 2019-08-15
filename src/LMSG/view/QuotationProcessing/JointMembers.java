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

public class JointMembers {
  public JointMembers() {
  }
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
  public List<QuotMembers> findMembers()
  {
     DBConnector myConn=new DBConnector();
    Connection conn=myConn.getDatabaseConn();
    String membersQuery="BEGIN LMS_WEB_CURSOR_GRP.quotationMembers(?,?,?);end;";
    List<QuotMembers> QuotationMembers=new ArrayList<QuotMembers>();
    QuotMembers member=new QuotMembers();
    try
    {
      CallableStatement cst=conn.prepareCall(membersQuery);
      cst.registerOutParameter(1,OracleTypes.CURSOR);
      cst.setBigDecimal(2,(BigDecimal)session.getAttribute("QuoteCode"));
      cst.setString(3,"J");
      cst.execute();
      ResultSet rs=(ResultSet)cst.getObject(1);
      while(rs.next())
      {
        member.setQuoMemNo(rs.getString(1));
        member.setQuoMemName(rs.getString(2));
        member.setQuoDepMemType(rs.getString(3));
        member.setQuoMemAnb(rs.getInt(4));
        member.setQuoJointMem(rs.getString(5));
        member.setQuoOccupation(rs.getString(6));
        member.setQMEM_DTY_CODE(rs.getBigDecimal("QMEM_DTY_CODE"));
        member.setQMEM_MEM_CODE(rs.getBigDecimal("QMEM_MEM_CODE"));
        member.setQMEM_CODE(rs.getBigDecimal(18));
        member.setQMEM_BPRESS_LOADING(rs.getBigDecimal("QMEM_BPRESS_LOADING"));
        member.setQMEM_HEIGHT(rs.getBigDecimal("QMEM_HEIGHT"));
        member.setQMEM_WEIGHT(rs.getBigDecimal("QMEM_WEIGHT"));
        member.setQMEM_WEIGHT_LOADING(rs.getBigDecimal("QMEM_WEIGHT_LOADING"));
        member.setQMEM_SYSTOLIC_PR(rs.getBigDecimal("QMEM_SYSTOLIC_PR"));
        member.setQMEM_DIASTOLIC_PR(rs.getBigDecimal("QMEM_DIASTOLIC_PR"));
        member.setQMEM_LOADING_TYPE(rs.getString("QMEM_LOADING_TYPE"));
        member.setQMEM_LOADING_RATE(rs.getBigDecimal("QMEM_LOADING_RATE"));
        member.setQMEM_LOADING_DIV_FACT(rs.getBigDecimal("QMEM_LOADING_DIV_FACT"));
        member.setQMEM_TOT_SA(rs.getBigDecimal("QMEM_TOT_SA"));
        QuotationMembers.add(member);
      }
        conn.close();    
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
    return QuotationMembers;
  }
}
