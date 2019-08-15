package LMSG.view.BPM;

import LMSG.view.Base.GlobalCC;
import LMSG.view.connect.DBConnector;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;

import javax.sql.DataSource;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleConnection;

public class ProcessDMSTicket {
    public ProcessDMSTicket() {
        super();
    }
  
  
   
    
  public String saveDmsDocuments2(String docID,String user,String docType,String documentName) 
  {

        Connection conn = null;
        CallableStatement cst = null;
        try {        
            conn= new DBConnector().getDatabaseConn();
            String Updatewkflw =
                "BEGIN LMS_WEB_PKG_GRP.create_dms_documents(?,?,?,?);END;";
            //CallableStatement cst = conn.prepareCall(Updatewkflw);
            cst = conn.prepareCall(Updatewkflw);
            cst.setString(1, docID);
            cst.setString(2, user);
            cst.setString(3, docType);
            cst.setString(4, documentName);
            cst.execute();
            
            cst.close();
            conn.commit();
            conn.close();

        }
        catch (SQLException e) {
          System.out.println("Threw SQL Exception!");
          e.printStackTrace();
        } 
        catch (Exception e) {
                   //GlobalCC.EXCEPTIONREPORTING(conn, e);
            System.out.println("Ticket Didnt save!");
            e.printStackTrace();
        }
        return null;
    }
  
  public String saveDmsDocuments(String docID,String user,String docType,String documentName) throws SQLException {


        OracleConnection conn = null;
        conn = this.getDatabaseConnection();

        OracleCallableStatement cst = null;
          try {        

              String Updatewkflw =
                  "BEGIN LMS_WEB_PKG_GRP.create_dms_documents(?,?,?,?) ;END;";

            cst = (OracleCallableStatement)conn.prepareCall(Updatewkflw);
              cst.setString(1, documentName);
              cst.setString(2, user);
              cst.setString(3, docType);
              cst.setString(4, docID); 
              cst.execute();
              cst.close();
              conn.close();

          }
          catch (Exception e) {
              e.printStackTrace();
                     GlobalCC.EXCEPTIONREPORTING(conn, e);
          }
          return null;
      }
    
  
    public OracleConnection getDatabaseConnection() {
        OracleConnection conn = null;
        try {
            Context initCtx = null;
            initCtx = new InitialContext();
            String connectionString = null;
            Context envCtx = (Context)initCtx.lookup("java:comp/env");
            connectionString = (String)envCtx.lookup("conn");
            DataSource ds = (DataSource)envCtx.lookup(connectionString);
            conn = (OracleConnection)ds.getConnection();
            // userVaraibleInitialization(conn);
    
        } catch (Exception e) {
            e.printStackTrace();
            // GlobalCC.EXCEPTIONREPORTING(conn, e);
    
        }
    
        return conn;
    }

}
