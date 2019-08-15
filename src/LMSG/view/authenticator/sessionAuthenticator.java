package LMSG.view.authenticator;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import oracle.jdbc.OracleTypes;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import LMSG.view.Base.GlobalCC;

import LMSG.view.Login.Index;

import LMSG.view.connect.DBConnector;

import java.math.BigDecimal;

import java.sql.CallableStatement;

import java.sql.Connection;

import javax.faces.component.UIViewRoot;

import javax.servlet.http.HttpServletRequest;

public class sessionAuthenticator {
    public sessionAuthenticator() {
        super();
    }
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    /*public String Authenticate() {
           if (session.getAttribute("UserCode") == null) {
               String message = "Not logged In";
               FacesContext.getCurrentInstance().addMessage(null,
                                                            new FacesMessage(message));

               try {
                   GlobalCC.RedirectPage("/index.jspx");
               } catch (Exception e) {
                GlobalCC.EXCEPTIONREPORTING(null,e);
                }
           } else {

               HttpServletResponse response =
                   (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
               response.addHeader("Pragma", "no-cache");
               response.addHeader("Cache-Control", "no-cache");
               response.addHeader("Cache-Control", "must-revalidate");
               response.addHeader("Expires", "Mon, 8 Aug 2006 10:00:00 GMT");
           }
           return null;
       }*/
    
    public String Authenticate() {
        HttpServletRequest rq =
            (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
     

        //session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        if (session.getAttribute("UserCode") == null &&
            (rq.getParameter("aid") == null)) {
            String message = "Not logged In";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(message));

            try {
              FacesContext fc = FacesContext.getCurrentInstance();
              UIViewRoot viewRoot = fc.getApplication().getViewHandler().createView(fc, "/index.jspx");
              fc.setViewRoot(viewRoot);
              fc.renderResponse();
            } catch (Exception e) {
                GlobalCC.EXCEPTIONREPORTING(null, e);
            }
        } else if ((rq.getParameter("aid") != null) &&
                   session.getAttribute("UserCode") == null) {

            DBConnector datahandler = new DBConnector();
            Connection conn;
            conn = datahandler.getDatabaseConn();
            if (conn == null) {
                String message =
                    "Error Connecting to Database. Contact Your System Administrator";
                GlobalCC.errorValueNotEntered(message);
                return null;
            }
           
            try {
               
                CallableStatement callStmt = null;
                String jobquery =
                    "begin tqc_web_cursor.getUserName(?,?,?); end;";
               
              callStmt = conn.prepareCall(jobquery);
                callStmt.setBigDecimal(1,
                                       new BigDecimal(rq.getParameter("aid")));
                callStmt.registerOutParameter(2, OracleTypes.VARCHAR);
                callStmt.registerOutParameter(3, OracleTypes.DATE);
                callStmt.execute();
                session.setAttribute("Username", callStmt.getString(2));
                session.setAttribute("LoginDate", callStmt.getDate(3));
                session.setAttribute("UserCode",
                                     new BigDecimal(rq.getParameter("aid")));
                session.setAttribute("sysCode", 27);
                System.out.println(("Username"+ callStmt.getString(2)));
                
                Index ind = new Index();
                ind.sysParameters();

                callStmt.close();
                conn.close();

            } catch (Exception e) {
                e.printStackTrace();
                GlobalCC.EXCEPTIONREPORTING(conn, e);
            }

        } else {

            HttpServletResponse response =
                (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
            response.addHeader("Pragma", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
            response.addHeader("Cache-Control", "must-revalidate");
            response.addHeader("Expires", "Mon, 8 Aug 2006 10:00:00 GMT");
        }
        return null;
    }
    
    public String browseAuthenticate() {
       session.removeAttribute("Username");
       session.removeAttribute("UserCode");
          
           return null;
       }
}
