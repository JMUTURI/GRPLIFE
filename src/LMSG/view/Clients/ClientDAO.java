package LMSG.view.Clients;

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

import java.math.BigDecimal;

public class ClientDAO extends LOVCC {
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    public List<Client> findClientOccupations() {
        
        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;
        List<Client> prpClients = new ArrayList<Client>();
        try {
            
                String proposalQuery = 
                    "begin LMS_WEB_CURSOR_GRP.grp_occupations(?); end;";
                cst = conn.prepareCall(proposalQuery);
                      
           //register out
            cst.registerOutParameter(1, 
                                     OracleTypes.CURSOR);
            cst.execute();
            ResultSet rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Client occupation = new Client();
                occupation.setOccupationCode(rs.getBigDecimal(1));
                occupation.setOccupationalDesc(rs.getString(2));
                occupation.setLifeClass(rs.getBigDecimal(3));
                prpClients.add(occupation); 
            }
            rs.close();
            cst.close();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn,e);
        }

        return prpClients;
    }
    
    public List<Client> findSimilarClients() {

        String query =
            "begin ? := tqc_clients_pkg.clients_QRY(?,?,?,?,?,?,?); end;";
        CallableStatement cst1 = null;
        List<Client> users = new ArrayList<Client>();
      DBConnector datahandler = new DBConnector();
        Connection conn = null;
        conn = datahandler.getDatabaseConn();
        try {
        
            cst1 = conn.prepareCall(query);
            cst1.registerOutParameter(1,
                                      OracleTypes.CURSOR); //authorization code

            if (ClientAddDetails.FirstName == null) {
                cst1.setString(2, null);
            } else {
                cst1.setString(2, ClientAddDetails.FirstName.toUpperCase());
            }
            if (ClientAddDetails.MiddleName == null) {
                cst1.setString(3, null);
            } else {
                cst1.setString(3, ClientAddDetails.MiddleName.toUpperCase());
            }
            if (ClientAddDetails.LastName == null) {
                cst1.setString(4, null);
            } else {
                cst1.setString(4, ClientAddDetails.LastName.toUpperCase());
            }


            cst1.setString(5, ClientAddDetails.PostalAddress);
            cst1.setString(6, null);
            cst1.setString(7, ClientAddDetails.PINNumber);
            cst1.setString(8,"SNE");
            if (ClientAddDetails.SearchCriteria == null) {

            } else {
                cst1.execute();

                ResultSet rs = (ResultSet)cst1.getObject(1);

                users = new ArrayList<Client>();
                int k;
                k = 0;
                LOVCC.clientexists = false;
                while (rs.next()) {
                    LOVCC.clientexists = true;
                    Client client = new Client();
                    client.setClientCode(rs.getBigDecimal(1));
                    client.setPINNumber(rs.getString(2));
                    client.setPostalAddress(rs.getString(3));
                    client.setTelphoneOne(rs.getString(4));
                    client.setOthernames(rs.getString(5));
                    client.setFullname(rs.getString(6));
                    client.setIdRegNumber(rs.getString(7));
                    client.setShortDescription(rs.getString(8));
                    client.setZIPCode(rs.getString(9));

                    users.add(client);
                }


            }
            cst1.close();
            conn.close();
        } catch (Exception e) {
          GlobalCC.EXCEPTIONREPORTING(conn, e);
        }


        return users;


    }
    
    public List<Client> findAllClients() {

        String query = "begin ? := lms_web_cursor_grp.get_clients(); end;";
        CallableStatement cst = null;
        List<Client> users = new ArrayList<Client>();
      DBConnector datahandler = new DBConnector();
      Connection conn = null;
      conn = datahandler.getDatabaseConn();
        try {
            cst = conn.prepareCall(query);
            cst.registerOutParameter(1, 
                                     OracleTypes.CURSOR); //authorization code
            cst.execute();

            ResultSet rs = (ResultSet)cst.getObject(1);

            users = new ArrayList<Client>();
            int k;
            k = 0;
            while (rs.next()) {
                Client client1 = new Client();
                client1.setClientCode(rs.getBigDecimal(1));
                client1.setPINNumber(rs.getString(2));
                client1.setPostalAddress(rs.getString(3));
                client1.setTelphoneOne(rs.getString(4));
                client1.setOthernames(rs.getString(5));
                client1.setFullname(rs.getString(6));
                client1.setIdRegNumber(rs.getString(7));
                client1.setShortDescription(rs.getString(8));
                client1.setZIPCode(rs.getString(9));
                
                users.add(client1);
            }
            
            rs.close();
            cst.close();
            conn.close();
            
        } catch (Exception e) {
          GlobalCC.EXCEPTIONREPORTING(conn, e);
        }


        return users;


    }
    public List<Client> findContactPersons() {

      String query = "begin  lms_setups_cursor.findContactPerson(?,?); end;";
      CallableStatement cst = null;
      List<Client> users = new ArrayList<Client>();
    DBConnector datahandler = new DBConnector();
    Connection conn = null;
    conn = datahandler.getDatabaseConn();
      try {
          cst = conn.prepareCall(query);
          cst.registerOutParameter(1, 
                                   OracleTypes.CURSOR); //authorization code
          cst.setBigDecimal(2,(BigDecimal)session.getAttribute("ClientCode"));
          cst.execute();

          ResultSet rs = (ResultSet)cst.getObject(1);

          users = new ArrayList<Client>();
          int k;
          k = 0;
          while (rs.next()) {
              Client client1 = new Client();
              client1.setPctcCode(rs.getBigDecimal(1));
              client1.setPctcName(rs.getString(2));
              client1.setPctcDob(rs.getDate(3));
              client1.setPctcPhyAddr(rs.getString(4));
              client1.setPctcPostAddr(rs.getString(5));
              client1.setPctcTel(rs.getString(6));
              client1.setPctcEmail(rs.getString(7));
              client1.setPctcWef(rs.getDate(8));
              client1.setPctcWet(rs.getDate(9));
              
              users.add(client1);
          }
          
          rs.close();
          cst.close();
          conn.close();
          
      } catch (Exception e) {
        GlobalCC.EXCEPTIONREPORTING(conn, e);
      }


      return users;


  }
  
    
    public List<Client> findProposers() {

        String proposersQuery="BEGIN LMS_WEB_CURSOR_GRP.get_grp_proposers(?);END;";
        CallableStatement cst = null;
        List<Client> users = new ArrayList<Client>();
      DBConnector datahandler = new DBConnector();
      Connection conn = null;
      conn = datahandler.getDatabaseConn();
        try {
            cst = conn.prepareCall(proposersQuery);
            
            cst.registerOutParameter(1, 
                                     OracleTypes.CURSOR); //authorization code
            cst.execute();

            ResultSet rs = (ResultSet)cst.getObject(1);

            users = new ArrayList<Client>();
            int k;
            k = 0;
            while (rs.next()) {
                Client client1 = new Client();
                client1.setCLIENT(rs.getString(2));
                client1.setPRP_CODE(rs.getBigDecimal(1));
                client1.setPRP_SHT_DESC(rs.getString(3));
                client1.setPRP_ID_REG_NO(rs.getString(4));
                client1.setPRP_DOB(rs.getString(5));
                client1.setGCO_CODE(rs.getBigDecimal(6));
                client1.setGCO_SHT_DESC(rs.getString(7));
                client1.setGCO_DESC(rs.getString(8));
                client1.setHazard(rs.getString(9));
                client1.setLC_CODE(rs.getBigDecimal(10));
                client1.setPrp_clnt_code(rs.getBigDecimal(11));
                
                users.add(client1);
            }
            
            rs.close();
            cst.close();
            conn.close();
            
        } catch (Exception e) {
          GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return users;

    }
}
