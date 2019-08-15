package LMSG.view.utilities;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.internal.OracleTypes;

import LMSG.view.Base.GlobalCC;

import LMSG.view.connect.DBConnector;

public class emailDAO {
    public emailDAO() {
        super();
    }
    public List<emails> findSystems()
    {
      DBConnector connector=new DBConnector();
      Connection conn=connector.getDatabaseConn();
      List<emails> clientsList=new ArrayList<emails>();
      String systemsQuery="BEGIN TQC_EMAIL_PKG.getSystems(?);END;";
      CallableStatement cst=null;
      try 
      {
        cst=conn.prepareCall(systemsQuery);
        cst.registerOutParameter(1,OracleTypes.CURSOR);
        cst.execute();
        ResultSet rs=(ResultSet)cst.getObject(1);
        while(rs.next())
        {
          emails systems=new emails();
            systems.setSYS_CODE(rs.getBigDecimal(1));
            systems.setSYS_NAME(rs.getString(3));
            systems.setSYS_SHT_DESC(rs.getString(2));
          clientsList.add(systems);
        }
          conn.close();    
      }
      catch(Exception ex) 
      {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
      }
      return clientsList;
    }
    
    public List<emails> findEmailClients()
    {
      DBConnector connector=new DBConnector();
      Connection conn=connector.getDatabaseConn();
      List<emails> clientsList=new ArrayList<emails>();
      String clientsQuery="BEGIN TQC_EMAIL_PKG.getEmailClients(?);END;";
      CallableStatement cst=null;
      try 
      {
        cst=conn.prepareCall(clientsQuery);
        cst.registerOutParameter(1,OracleTypes.CURSOR);
        cst.execute();
        ResultSet rs=(ResultSet)cst.getObject(1);
        while(rs.next())
        {
          emails systems=new emails();
          systems.setCLNT_CODE(rs.getBigDecimal(1));
          systems.setCLNT_NAME(rs.getString(3));
          systems.setCLNT_OTHER_NAMES(rs.getString(4));
          systems.setNAME(rs.getString(5));
          systems.setCLNT_SHT_DESC(rs.getString(2));
          clientsList.add(systems);
        }
          conn.close();    
      }
      catch(Exception ex) 
      {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
      }
      return clientsList;
    }
    
    public List<emails> findSmsQuotation()
    {
      DBConnector connector=new DBConnector();
      Connection conn=connector.getDatabaseConn();
      List<emails> clientsList=new ArrayList<emails>();
      String quotationQuery="BEGIN TQC_SMS_PKG.getSmsQuotation(?);END;";
      CallableStatement cst=null;
      try 
      {
        cst=conn.prepareCall(quotationQuery);
        cst.registerOutParameter(1,OracleTypes.CURSOR);
        cst.execute();
        ResultSet rs=(ResultSet)cst.getObject(1);
        while(rs.next())
        {
          emails systems=new emails();
          systems.setQUOT_CODE(rs.getBigDecimal(1));
          systems.setQUOT_NO(rs.getString(2));
          clientsList.add(systems);
        }
          conn.close();    
      }
      catch(Exception ex) 
      {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
      }
      return clientsList;
    }
    
    public List<emails> findAgents()
    {
      DBConnector connector=new DBConnector();
      Connection conn=connector.getDatabaseConn();
      List<emails> clientsList=new ArrayList<emails>();
        String agentsQuery="BEGIN TQC_EMAIL_PKG.getEmailAgents(?);END;";
      CallableStatement cst=null;
      try 
      {
        cst=conn.prepareCall(agentsQuery);
        cst.registerOutParameter(1,OracleTypes.CURSOR);
        cst.execute();
        ResultSet rs=(ResultSet)cst.getObject(1);
        while(rs.next())
        {
          emails systems=new emails();
          systems.setAGN_CODE(rs.getBigDecimal(1));
          systems.setAGN_NAME(rs.getString(3));
          systems.setAGN_SHT_DESC(rs.getString(2));
          clientsList.add(systems);
        }
          conn.close();    
      }
      catch(Exception ex) 
      {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
      }
      return clientsList;
    }
    
    public List<emails> findSmsPolicies()
    {
      DBConnector connector=new DBConnector();
      Connection conn=connector.getDatabaseConn();
      List<emails> clientsList=new ArrayList<emails>();
      String policiesQuery="BEGIN TQC_EMAIL_PKG.getSmsPolicies(?);END;";
      CallableStatement cst=null;
      try 
      {
        cst=conn.prepareCall(policiesQuery);
        cst.registerOutParameter(1,OracleTypes.CURSOR);
        cst.execute();
        ResultSet rs=(ResultSet)cst.getObject(1);
        while(rs.next())
        {
          emails systems=new emails();
          systems.setPOL_BATCH_NO(rs.getBigDecimal(1));
          systems.setPOL_POLICY_NO(rs.getString(2));
          //systems.setSYS_SHT_DESC(rs.getString(2));
          clientsList.add(systems);
        }
          conn.close();    
      }
      catch(Exception ex) 
      {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
      }
      return clientsList;
    }
    
    public List<emails> findClaims()
    {
      DBConnector connector=new DBConnector();
      Connection conn=connector.getDatabaseConn();
      List<emails> clientsList=new ArrayList<emails>();
      String claimsQuery="BEGIN TQC_EMAIL_PKG.getEmailClaims(?);END;";
      CallableStatement cst=null;
      try 
      {
        cst=conn.prepareCall(claimsQuery);
        cst.registerOutParameter(1,OracleTypes.CURSOR);
        cst.execute();
        ResultSet rs=(ResultSet)cst.getObject(1);
        while(rs.next())
        {
          emails systems=new emails();
            //systems.setCmb_claim_no(rs.getBigDecimal(1));
            systems.setCmb_claim_no(rs.getString(1));
            //systems.setAGN_SHT_DESC(rs.getString(2));
          clientsList.add(systems);
        }
          conn.close();    
      }
      catch(Exception ex) 
      {
            GlobalCC.EXCEPTIONREPORTING(conn,ex);
      }
      return clientsList;
    }
}
