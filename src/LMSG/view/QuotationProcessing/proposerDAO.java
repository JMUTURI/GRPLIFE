package LMSG.view.QuotationProcessing;

import LMSG.view.Base.GlobalCC;

import java.sql.CallableStatement;

import java.sql.Connection;

import java.sql.ResultSet;

import java.util.ArrayList;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import oracle.jdbc.internal.OracleTypes;

import LMSG.view.connect.DBConnector;

public class proposerDAO {
  public proposerDAO() {
  }
 
  public List<proposers> findProposers() 
  {
    Connection conn=null;
    CallableStatement cstmt=null;
    conn=new DBConnector().getDatabaseConn();
    List<proposers> ProposersList=new ArrayList<proposers>();
    String proposersQuery="BEGIN LMS_WEB_CURSOR_GRP.get_grp_proposers(?);END;";
    try 
    {
      cstmt=conn.prepareCall(proposersQuery);
      cstmt.registerOutParameter(1,OracleTypes.CURSOR);
      cstmt.execute();
      ResultSet rs=(ResultSet)cstmt.getObject(1);
      while(rs.next()) 
      {
        proposers prop=new proposers();
        prop.setCLIENT(rs.getString(2));
        prop.setPRP_CODE(rs.getBigDecimal(1));
        prop.setPRP_SHT_DESC(rs.getString(3));
        prop.setPRP_ID_REG_NO(rs.getString(4));
        prop.setPRP_DOB(rs.getString(5));
        prop.setGCO_CODE(rs.getBigDecimal(6));
        prop.setGCO_SHT_DESC(rs.getString(7));
        prop.setGCO_DESC(rs.getString(8));
        prop.setHazard(rs.getString(9));
        prop.setLC_CODE(rs.getBigDecimal(10));
        prop.setPrp_clnt_code(rs.getBigDecimal(11));
        ProposersList.add(prop);
      }
      cstmt.close();
      conn.close();   
    }
    catch(Exception e) 
    {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return ProposersList;
  }
}
