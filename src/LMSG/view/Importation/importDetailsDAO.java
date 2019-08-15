package LMSG.view.Importation;

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

import LMSG.view.Base.GlobalCC;

public class importDetailsDAO {
  public importDetailsDAO() {
  }
    
    
        HttpSession session =
            (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
      public List<importDetails> FindImportedDate()
      {
        List<importDetails> DetailsList=new ArrayList<importDetails>();
        Connection conn=null;
        ResultSet rs = null;
        CallableStatement cstmt=null;
        try {
          conn=new DBConnector().getDatabaseConn();
         
          String ImportQuery="BEGIN LMS_WEB_CURSOR_GRP.FimdImportDetails(?,?);END;";
          cstmt=conn.prepareCall(ImportQuery);
          cstmt.registerOutParameter(1,OracleTypes.CURSOR);
          cstmt.setInt(2,(Integer)session.getAttribute("templateTranSeq"));
          cstmt.execute();
          rs=(ResultSet)cstmt.getObject(1);
          while(rs.next())
          {
            importDetails details=new importDetails();
            details.setLMID_CODE(rs.getBigDecimal(1));
            details.setLMID_LMIT_CODE(rs.getBigDecimal(2));
            details.setLMID_MEM_NO(rs.getString(3));
            details.setLMID_MEM_NO(rs.getString(4));
            details.setLMID_MEM_SURNAME(rs.getString(5));
            details.setLMID_MEM_OTHERNAMES(rs.getString(6));
            details.setLMID_MEM_DOB(rs.getDate(7));
            details.setLMID_MEM_ANB(rs.getBigDecimal(8));
            details.setLMID_MEM_SEX(rs.getString(9));
            details.setLMID_DEP_TYPE(rs.getString(10));
            details.setLMID_ID_NO(rs.getString(11));
            details.setLMID_MEM_CATEGORY(rs.getString(12));
            details.setLMID_EARNINGS(rs.getBigDecimal(13));
            details.setLMID_MULT_EARNINGS_PRD(rs.getBigDecimal(14));
            details.setLMID_ORIGINAL_LOAN_AMT(rs.getBigDecimal(15));
            details.setLMID_LOAN_ISSUE_DATE(rs.getDate(16));
            details.setLMID_ORIG_LOAN_REPAYMENT_PRD(rs.getString(17));
            details.setLMID_SAVING_AMT(rs.getBigDecimal(18));
            details.setLMID_LOAN_INT(rs.getBigDecimal(19));
            details.setLMID_VOL_CONT(rs.getBigDecimal(20));
            details.setLMID_EMPLYE_VOLU_CONTR(rs.getBigDecimal(21));
            details.setLMID_EMPLYR_VOLU_CONTR(rs.getBigDecimal(22));
            details.setLIMD_DATE_JOINED(rs.getDate(23));
            details.setLMID_EMPLYE_SINGLE_PREM(rs.getBigDecimal(24));
            details.setLMID_EMPLYR_SINGLE_PREM(rs.getBigDecimal(25));

          DetailsList.add(details);
          }
            conn.close();
        }
        catch(Exception e) 
        {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }finally{
           GlobalCC.CloseConnections(rs, cstmt, conn);
        }
      return DetailsList;
      }
        public List<importDetails> FindExportMemberDetails()
        {
          Connection conn=null;
          List<importDetails> DetailsList=new ArrayList<importDetails>();
          String exportQuery="BEGIN LMS_WEB_CURSOR_GRP.exported_to_excel(?,?);END;";
          CallableStatement cstmt=null;
          ResultSet rs = null;
          try {
            conn=new DBConnector().getDatabaseConn();
           
            cstmt=conn.prepareCall(exportQuery);
            cstmt.registerOutParameter(1,OracleTypes.CURSOR);
            cstmt.setBigDecimal(2, (BigDecimal)session.getAttribute("policyCode"));
            cstmt.execute();
             rs=(ResultSet)cstmt.getObject(1);
            while(rs.next())
            {
              importDetails details=new importDetails();
              details.setLMID_CODE(rs.getBigDecimal(1));
              details.setLMID_LMIT_CODE(rs.getBigDecimal(2));
              details.setLMID_MEM_NO(rs.getString(3));
              details.setLMID_MEM_NO(rs.getString(4));
              details.setLMID_MEM_SURNAME(rs.getString(5));
              details.setLMID_MEM_OTHERNAMES(rs.getString(6));
              details.setLMID_MEM_DOB(rs.getDate(7));
              details.setLMID_MEM_ANB(rs.getBigDecimal(8));
              details.setLMID_MEM_SEX(rs.getString(9));
              details.setLMID_DEP_TYPE(rs.getString(10));
              details.setLMID_ID_NO(rs.getString(11));
              details.setLMID_MEM_CATEGORY(rs.getString(12));
              details.setLMID_EARNINGS(rs.getBigDecimal(13));
              details.setLMID_MULT_EARNINGS_PRD(rs.getBigDecimal(14));
              details.setLMID_ORIGINAL_LOAN_AMT(rs.getBigDecimal(15));
              details.setLMID_LOAN_ISSUE_DATE(rs.getDate(16));
              details.setLMID_ORIG_LOAN_REPAYMENT_PRD(rs.getString(17));
              details.setLMID_SAVING_AMT(rs.getBigDecimal(18));
              details.setLMID_LOAN_INT(rs.getBigDecimal(19));
              details.setLMID_VOL_CONT(rs.getBigDecimal(20));
              details.setLMID_EMPLYE_VOLU_CONTR(rs.getBigDecimal(21));
              details.setLMID_EMPLYR_VOLU_CONTR(rs.getBigDecimal(22));
              details.setLIMD_DATE_JOINED(rs.getDate(23));
              details.setLMID_EMPLYE_SINGLE_PREM(rs.getBigDecimal(24));
              details.setLMID_EMPLYR_SINGLE_PREM(rs.getBigDecimal(25));
              details.setLMID_GRP_LIFE_RIDER(rs.getString(28));
              DetailsList.add(details);
            }
              conn.close();
          }
          catch(Exception e) 
          {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
          }finally{
           GlobalCC.CloseConnections(rs, cstmt, conn);
        }
        return DetailsList;
        }
      
    }
