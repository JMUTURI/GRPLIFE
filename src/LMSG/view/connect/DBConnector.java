package LMSG.view.connect;

import java.io.File;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.naming.Context;

import javax.naming.InitialContext;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import javax.sql.DataSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import oracle.jdbc.pool.OracleDataSource;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import LMSG.view.Base.CurrentUser;
import LMSG.view.Base.GlobalCC;
import LMSG.view.Base.LOVCC;

import oracle.jdbc.OracleConnection;

public class DBConnector {
    public DBConnector() {
        super();
    }
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    private static File file;
    private static boolean connectionFileSet = false;
    static String publicFolder;
    /**
     * Connection Variables
     */
    String jdblUrl;//= "jdbc:oracle:thin:@10.176.18.128:1521:leadway";
    String userid;//= "TQ_LMS";
    String password;// = "TQ_LMS";
    Connection conn;

    ResultSet rset;

    public Connection getDatabaseConn() {
        //File file;
/*        //file = null;
        if (connectionFileSet == false) {
            publicFolder = null;
            file = new File("Connection/Connection.xml");
            //publicFolder = getPublicFolderPath();
            //file = new File(publicFolder + "/Connection/Connection.xml");
            connectionFileSet = true;
        }
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db;


        try {

            db = dbf.newDocumentBuilder();
            Document doc;

            doc = db.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nodeLst = doc.getElementsByTagName("connection");

            for (int s = 0; s < nodeLst.getLength(); s++) {

                Node fstNode = nodeLst.item(s);

                if (fstNode.getNodeType() == Node.ELEMENT_NODE) {

                    if (s == 0) {
                        Element fstElmnt = (Element)fstNode;
                        NodeList fstNmElmntLst =
                            fstElmnt.getElementsByTagName("jdblUrl");
                        Element fstNmElmnt = (Element)fstNmElmntLst.item(0);
                        NodeList fstNm = fstNmElmnt.getChildNodes();
                        jdblUrl = (fstNm.item(0)).getNodeValue();

                        NodeList useridElmntLst =
                            fstElmnt.getElementsByTagName("userid");
                        Element useridElmnt = (Element)useridElmntLst.item(0);
                        NodeList useridNm = useridElmnt.getChildNodes();
                        userid = (useridNm.item(0)).getNodeValue();

                        NodeList passElmntLst =
                            fstElmnt.getElementsByTagName("password");
                        Element passElmnt = (Element)passElmntLst.item(0);
                        NodeList passNm = passElmnt.getChildNodes();
                        password = (passNm.item(0)).getNodeValue();

                    }
                }

            }
           try{
            OracleDataSource ds;
            ds = new OracleDataSource();
            ds.setURL(jdblUrl);
            conn = ds.getConnection(userid, password);
            userVaraibleInitialization(conn);
            


        } catch (Exception e) {
             GlobalCC.EXCEPTIONREPORTING(conn,e);
                
        }
 */ 
/*
        Class.forName("oracle.jdbc.driver.OracleDriver");
                      conn=DriverManager.getConnection(jdblUrl,userid,password)

*/
      try{
            String connectionString = null;
            Context initCtx = new InitialContext();
            Context envCtx = (Context)initCtx.lookup("java:comp/env");
            connectionString = (String)envCtx.lookup("conn");
               //DataSource ds = (DataSource)envCtx.lookup(connectionString);
            DataSource datasource = (DataSource)envCtx.lookup(connectionString);

        conn = datasource.getConnection();
        
          //System.out.println("Initialization--------------------1");          
           String curr = (String)session.getAttribute("Username");
          if(curr!=null){
            userVaraibleInitialization(conn);
          }
          
          //userVaraibleInitialization(conn);
         // System.out.println("Initialization--------------------2");
        } catch (Exception e) {
           e.printStackTrace();
            GlobalCC.EXCEPTIONREPORTING(conn,e);
                
        }

        return conn;
    }
    /**
     * Setting the username and user ID at connection time to be used at various procedures.
     * @param conn
     */
    public void userVaraibleInitialization(Connection conn) {
      String globalUserVar = "begin pkg_global_vars.set_pvar(?,?); end;";
           CallableStatement callStmt;
           try {
               callStmt = conn.prepareCall(globalUserVar);
               
                Boolean Log = (Boolean)session.getAttribute("loggedIn");
                   if (Log == true) {
               String curr = (String)session.getAttribute("Username");
                   if (curr == null) {
                   session.setAttribute("LoginDate", null);
                   session.setAttribute("UserCode", null);
                   session.setAttribute("Username", null);
                   //System.out.println("Here too");
                   //System.out.println("Here too pkg_global_varsXXXX===="+session.getAttribute("Username"));
                      GlobalCC.RedirectPage("/index.jspx");
                   } else {
                    // System.out.println("Here too pkg_global_vars");
                       callStmt.setString(1, "pkg_global_vars.pvg_username");
                       callStmt.setString(2, (String)session.getAttribute("Username"));
                       callStmt.execute();
                     //System.out.println("Here too pkg_global_vars===="+session.getAttribute("Username"));
                   }

               } else {
                // System.out.println("Here too XXXXX");
                   session.setAttribute("loggedIn", true);
                   //LOVCC.loggedIn = true;
               }
           } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn,e);
           }
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
              //System.out.println("Initialization--------------------1");
              userVaraibleInitialization(conn);
            //System.out.println("Initialization--------------------2");

          } catch (Exception e) {
              e.printStackTrace();
              GlobalCC.EXCEPTIONREPORTING(conn, e);

          }

          return conn;
      }
  
    public String getPublicFolderPath() {

        ExternalContext ectx =
            FacesContext.getCurrentInstance().getExternalContext();
        String requestPage =
            ((HttpServletRequest)ectx.getRequest()).getPathInfo();
        String requestPageOsTranslated =
            requestPage.replace('/', File.separatorChar);
        String requestPathTranslated =
            ((HttpServletRequest)ectx.getRequest()).getPathTranslated();
        int end = requestPathTranslated.indexOf(requestPageOsTranslated);
        String public_html_location = requestPathTranslated.substring(0, end);
        return public_html_location + File.separatorChar;
    }

    public static void setFile(File file) {
        DBConnector.file = file;
    }

    public static File getFile() {
        return file;
    }
}
