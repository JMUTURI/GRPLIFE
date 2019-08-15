package LMSG.view.QuotationProcessing;

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

import oracle.jdbc.OracleTypes;

public class agentsDAO
{
  HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
  public List<agents> FindAgents()
  {
    List<agents> AgentsList = new ArrayList<agents>();
    String AgentsQuery = "BEGIN LMS_WEB_CURSOR_GRP.quoAgents(?,?);END;";
    Connection conn = null;
    try
    {
      DBConnector myConn = new DBConnector();
      conn = myConn.getDatabaseConn();
      CallableStatement cstmt = null;
      cstmt = conn.prepareCall(AgentsQuery);
      cstmt.registerOutParameter(1,  OracleTypes.CURSOR);
      cstmt.setBigDecimal(2,(BigDecimal)session.getAttribute("branchCode"));
      cstmt.execute();
      ResultSet rs = (ResultSet)cstmt.getObject(1);
      while (rs.next())
      {
        agents quotLimits = new agents();
        quotLimits.setAGN_CODE(rs.getBigDecimal(1));

        quotLimits.setAGN_NAME(rs.getString(2));
        quotLimits.setAGN_POSTAL_ADDRESS(rs.getString(4));
        quotLimits.setAGN_SHT_DESC(rs.getString(3));
        quotLimits.setAgent(rs.getString(5));
        AgentsList.add(quotLimits);
      }
      conn.close();
    }
    catch (Exception ex)
    {
       GlobalCC.EXCEPTIONREPORTING(conn, ex);
        }
    return AgentsList;
  }

  public List<agents> FindMarketers()
  {
    List<agents> AgentsList = new ArrayList<agents>();
    String AgentsQuery = "BEGIN LMS_WEB_CURSOR_GRP.quoMarketers(?);END;";
    try
    {
      DBConnector myConn = new DBConnector();
      Connection conn = myConn.getDatabaseConn();
      CallableStatement cstmt = null;
      cstmt = conn.prepareCall(AgentsQuery);
      cstmt.registerOutParameter(1, OracleTypes.CURSOR);
      cstmt.execute();
      ResultSet rs = (ResultSet)cstmt.getObject(1);
      while (rs.next())
      {
        agents quotLimits = new agents();
        quotLimits.setAGN_CODE(rs.getBigDecimal(1));

        quotLimits.setAGN_NAME(rs.getString(2));
        quotLimits.setAGN_POSTAL_ADDRESS(rs.getString(4));
        quotLimits.setAGN_SHT_DESC(rs.getString(3));
        quotLimits.setAgent(rs.getString(5));
        AgentsList.add(quotLimits);
      }
      conn.close();
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
    return AgentsList;
  }
}