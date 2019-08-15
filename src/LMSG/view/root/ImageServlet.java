package LMSG.view.root;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.sql.DataSource;

import LMSG.view.Base.GlobalCC;

public class ImageServlet extends HttpServlet {
    private static final String CONTENT_TYPE =
        "image/gif; charset=windows-1252";
         private native void disposeNative();
           public void dispose() { disposeNative(); }
           protected void finalize() { dispose(); }

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) {


        try {

            response.setContentType(CONTENT_TYPE);
            Context initCtx = null;
            initCtx = new InitialContext();
            String connectionString = null;
            Context envCtx = (Context)initCtx.lookup("java:comp/env");
            connectionString = (String)envCtx.lookup("conn");
            DataSource ds = (DataSource)envCtx.lookup(connectionString);
            Connection conn;
            conn = ds.getConnection();

            // conn = datahandler.getDatabaseConnection();

            CallableStatement callStmt = null;

            String hrQuery = null;

            hrQuery =
                    "SELECT ORG_RPT_LOGO FROM TQC_ORGANIZATIONS WHERE ORG_CODE= 1";
            callStmt = conn.prepareCall(hrQuery);
            //bind the variables

            ResultSet rs = callStmt.executeQuery();

            while (rs.next()) {
                byte barray[] = rs.getBytes(1);
                response.setContentType("image/gif");
                response.setContentLength(barray.length);
                response.getOutputStream().write(barray);

            }
            response.getOutputStream().flush();
            response.getOutputStream().close();
            
            rs.close();            
            callStmt.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        // copy blob to output


    }
}
