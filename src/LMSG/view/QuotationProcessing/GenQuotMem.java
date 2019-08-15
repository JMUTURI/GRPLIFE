package LMSG.view.QuotationProcessing;

import LMSG.view.Base.GlobalCC;

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

import java.util.Date;

public class GenQuotMem {
  public GenQuotMem() {
  }
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
  public List<QuotMembers> findMembers()
  {
     DBConnector myConn=new DBConnector();
    Connection conn=myConn.getDatabaseConn();
    String membersQuery="BEGIN LMS_WEB_CURSOR_GRP.quotationMembers(?,?);end;";
    List<QuotMembers> QuotationMembers=new ArrayList<QuotMembers>();
   
    try
    {
      CallableStatement cst=conn.prepareCall(membersQuery);
      cst.registerOutParameter(1,OracleTypes.CURSOR);
      cst.setBigDecimal(2,(BigDecimal)session.getAttribute("QuoteCode"));
      cst.execute();
      ResultSet rs=(ResultSet)cst.getObject(1);
      while(rs.next())
      {
        QuotMembers member=new QuotMembers();
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
    public List<QuotMembers> findMemberBeneficiaries()
    {
       DBConnector myConn=new DBConnector();
      Connection conn=myConn.getDatabaseConn();
      String membersQuery="BEGIN LMS_WEB_CURSOR_GRP.findMemberStudents(?,?);end;";
      List<QuotMembers> QuotationMembers=new ArrayList<QuotMembers>();
     
      try
      {
        CallableStatement cst=conn.prepareCall(membersQuery);
        cst.registerOutParameter(1,OracleTypes.CURSOR);
        cst.setBigDecimal(2,(BigDecimal)session.getAttribute("quoteMemMemCode"));
        cst.execute();
        ResultSet rs=(ResultSet)cst.getObject(1);
        while(rs.next())
        {
          QuotMembers member=new QuotMembers();
          member.setQmemBenCode(rs.getBigDecimal(1));
          member.setQmemBenMainMemCode(rs.getBigDecimal(2));
          member.setQmemBenSurname(rs.getString(3));
          member.setQmemBenOtherNames(rs.getString(4));
          member.setQmemBenClass(rs.getString(5));
          member.setQmemBenTerm(rs.getString(6));
          member.setQmemBenMemNo(rs.getString(7));
          member.setClassDisplay(rs.getString(8));
          member.setBenTerm(rs.getString(9));
          member.setFeeDisplay(rs.getBigDecimal(10));
          member.setQmem_ben_sex(rs.getString(11));
          
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
  public List<QuotMembers> findMemberDependents()
  {
     DBConnector myConn=new DBConnector();
    Connection conn=myConn.getDatabaseConn();
    String membersQuery="BEGIN LMS_WEB_CURSOR_GRP.getBeneficiaryDetails(?,?);end;";
    List<QuotMembers> QuotationMembers=new ArrayList<QuotMembers>();
   
    try
    {
      CallableStatement cst=conn.prepareCall(membersQuery);
      cst.registerOutParameter(1,OracleTypes.CURSOR);
      cst.setBigDecimal(2,(BigDecimal)session.getAttribute("quoteMemMemCode"));
      cst.execute();
      ResultSet rs=(ResultSet)cst.getObject(1);
      while(rs.next())
      {
        QuotMembers member=new QuotMembers();
        member.setQabCode(rs.getBigDecimal(1));
        member.setQabSurname(rs.getString(2));
        member.setQabOtherNames(rs.getString(3));
        member.setQab_dob(rs.getDate(4));
        member.setQabAnb(rs.getString(5));
        member.setQabSharePct(rs.getString(6));
        member.setQab_ben_terminal_amt(rs.getBigDecimal(7));
        member.setQab_ann_purchase_amt(rs.getBigDecimal(8));
        member.setQab_number(rs.getString(9));
        
        
        QuotationMembers.add(member);
      }
        conn.close();    
    }
    catch(Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return QuotationMembers;
  }
  
  public List<QuotMembers> findDependentsAnnuityPayments()
  {
     DBConnector myConn=new DBConnector();
    Connection conn=myConn.getDatabaseConn();
    String membersQuery="BEGIN LMS_WEB_CURSOR_GRP.find_quo_ann_dep_partpymts(?,?);end;";
    List<QuotMembers> QuotationMembers=new ArrayList<QuotMembers>();
   
    try
    {
      CallableStatement cst=conn.prepareCall(membersQuery);
      cst.registerOutParameter(1,OracleTypes.CURSOR);
      cst.setBigDecimal(2,(BigDecimal)session.getAttribute("qabCode"));
      cst.execute();
      ResultSet rs=(ResultSet)cst.getObject(1);
      while(rs.next())
      {
        QuotMembers member=new QuotMembers();
        
        member.setQABP_CODE(rs.getBigDecimal(1));
        member.setQABP_NO(rs.getBigDecimal(2));
        member.setQABP_DATE_DUE(rs.getDate(3));
        member.setQABP_AMOUNT(rs.getBigDecimal(4));
        member.setQABP_PAID(rs.getString(5));
        member.setQABP_PAID_DESC(rs.getString(6));
        member.setQABP_PAID_DATE(rs.getDate(7));
        member.setQABP_VOUCHER_NO(rs.getBigDecimal(8));
        
        
        QuotationMembers.add(member);
      }
        conn.close();    
    }
    catch(Exception e)
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return QuotationMembers;
  }
}
