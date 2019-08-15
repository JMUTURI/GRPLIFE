package LMSG.view.Login;


import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.output.RichOutputLabel;


import java.math.BigDecimal;

import java.net.InetAddress;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.ResultSet;

import java.util.Date;

import javax.faces.application.FacesMessage;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.layout.RichPanelBox;


import oracle.jdbc.OracleTypes;

import LMSG.view.Base.GlobalCC;


import LMSG.view.Base.ReinitializeVar;

import LMSG.view.Base.JSFUtils;

import LMSG.view.connect.DBConnector;


import LMSG.view.BPM.wfEngine;

import java.io.FileOutputStream;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.faces.component.UIViewRoot;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;

import javax.naming.directory.InitialDirContext;

import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import javax.servlet.ServletContext;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleConnection;

import oracle.jdbc.OracleResultSet;

import org.jbpm.pvm.internal.cfg.JbpmConfiguration;



/**
 * Login Class
 * Gets username and password from interface and tries to Login User
 * @author Jim Gitau
 */
public class Index {
    private String LoginMessage;
    private String login_username;
    private String login_password;

    public static String UsernameValue;
    static BigDecimal UserCode;

    static Date currentDate;
    public static Date LoginDate;

    private RichInputText password;
    private RichInputText username;
    private RichInputText pass2;
    private RichPanelBox mainLogin;
    private RichInputText newPassword;
    private RichOutputLabel confirmPassword;
    private RichOutputLabel newResetPassword;
    private RichInputText newConfirmPassword;
    private RichCommandButton resetPasswordBtn;


    public Index() {
    }

    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    
 public String UserAuthenticate() {
        /**
       * Function Variable Definition and initialization
       */
        String login_message = null;
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        if (username.getValue() == null) {
            String message = "Enter A UserName";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                          message,
                                                                          message));
            return null;

        } else {
            login_username = username.getValue().toString();
        }

        if (password.getValue() == null) {
            String message = "Enter A Password";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                          message,
                                                                          message));
            return null;

        } else {
            login_password = password.getValue().toString();
        }

        int rset = 0;

        session.setAttribute("loggedIn", false);
        session.setAttribute("sysCode", 27);
        String loginType = loginType();
        System.out.println("Login Type "+loginType);
        if (loginType.equalsIgnoreCase("LDAP")) {
            String newuser = getDomainName();
            newuser = login_username.concat(newuser);
            String ldapAdServer = null;
            try {
                CallableStatement callStmt = null;
                String query1 =
                    "begin ? := TQC_SETUPS_CURSOR.getParameter(?); end;";

                callStmt =conn.prepareCall(query1);
                callStmt.registerOutParameter(1, -10);
                callStmt.setString(2, "LDAP_SERVER");

                callStmt.execute();
                OracleResultSet rs = (OracleResultSet)callStmt.getObject(1);
                while (rs.next()) {
                    ldapAdServer = rs.getString(1);
                }
                callStmt.close();
                rs.close();

              Hashtable<String, Object> env = new Hashtable<String, Object>();
              env.put(Context.SECURITY_AUTHENTICATION, "simple");
              env.put(Context.INITIAL_CONTEXT_FACTORY,
                      "com.sun.jndi.ldap.LdapCtxFactory");
              env.put(Context.PROVIDER_URL, "ldap://"+ldapAdServer);
              DirContext ctx = new InitialDirContext(env);
              System.out.println("login_username="+login_username+" login_password"+login_password+" "+ldapAdServer);         
              ctx = ActiveDirectory.getConnection(newuser,login_password,null,ldapAdServer);
              session.setAttribute("ldapCtx", ctx);
                login_message = null;
                String jobquery =
                    "begin ? := tqc_web_pkg.ldap_authenticate(?,?,?,?,?,?); end;";
                if (conn == null) {
                    String message =
                        "Cannot connect to the server. Check your server connection";

                    GlobalCC.errorValueNotEntered(message);
                    return null;
                }
                callStmt =conn.prepareCall(jobquery);
                callStmt.setString(2, login_username.toUpperCase());
                callStmt.registerOutParameter(3, 12);
                callStmt.registerOutParameter(4, 91);

                callStmt.registerOutParameter(5, 12);

                callStmt.registerOutParameter(6, 12);

                callStmt.setInt(7, 27);
                callStmt.registerOutParameter(1, 4);

                callStmt.execute();
                rset = callStmt.getInt(1);
                login_message = callStmt.getString(3);
                Date loginDt = callStmt.getDate(4);
                BigDecimal usrCode = callStmt.getBigDecimal(5);

                JbpmConfiguration pid = null;
                wfEngine wf = new wfEngine();
                pid = wf.startWorkFlowInstance();
                wf.endWorkFlowInstance(pid);

                callStmt.close();
                conn.commit();

                if (rset == 1) {
                    //System.out.println("Here...");
                    session.setAttribute("LoginDate", loginDt);
                    session.setAttribute("Username", username.getValue());
                    session.setAttribute("UserCode", usrCode);
                    session.setAttribute("SIGN_IN_MODE", loginType);
                    session.setAttribute("sysCode", 27);
                    session.setAttribute("loggedIn", true);
                    currentDate = new Date();
                    sysParameters();
                    connectedMachine();
                    myConn.userVaraibleInitialization(conn);
                   GlobalCC.RedirectPage("/lmsmain.jspx");
                } else if (rset == 2) {

                    String message = login_message;
                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                  message,
                                                                                  message));


                } else if (rset == 5 || rset == 4) {
                    String message = login_message;
                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                  message,
                                                                                  message));
                    confirmPassword.setRendered(true);
                    newResetPassword.setRendered(true);
                    newConfirmPassword.setRendered(true);
                    newPassword.setRendered(true);
                    resetPasswordBtn.setRendered(true);


                } else //Password problem
                {
                    String message = login_message;
                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                  message,
                                                                                  message));

                    //return login_message;
                }
                conn.close();

            } catch (Exception exception) {
                GlobalCC.EXCEPTIONREPORTING(conn, exception);
                exception.printStackTrace();
            }
        } else if(loginType.equalsIgnoreCase("NORMAL")) { //Normal Login
            System.out.println("Normal Login");
            if (conn == null) {

                String message = "Error in Connection";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                              message,
                                                                              message));

                return null;
            }

            String connectionPackage =
                "begin ? := tqc_web_pkg.user_authenticate(?,?,?,?,?,?,?); end;";

            CallableStatement callStmt;

            try {
                callStmt = conn.prepareCall(connectionPackage);


                if ((login_username == null) || (login_password == null)) {
                    String message = "Enter Username / Password";
                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                  message,
                                                                                  message));
                    return null;
                } else {

                    FacesContext context = FacesContext.getCurrentInstance();
                    //HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
                    /*FacesContext context = FacesContext.getCurrentInstance();
              context.getExternalContext().getSessionMap().get("Home");
              ExternalContext ectx =
                  context.getExternalContext();*/
                    //MDSSession session = new
                    HttpSession session =
                        (HttpSession)context.getExternalContext().getSession(false);
                    HttpSession session2 =
                        (HttpSession)JSFUtils.getFacesContext().getExternalContext().getSession(true);
                    System.out.println(JSFUtils.resolveRemoteUser());
                    System.out.println(context);
                    System.out.println(JSFUtils.getFacesContext());
                    //FacesContext.getCurrentInstance().getExternalContext().getSession()
                    //FacesContext facesContext = FacesContext.getCurrentInstance();
                    //facesContext.
                    System.out.println("Session1");
                    System.out.println(session.getId());
                    System.out.println("Session2");
                    System.out.println(session2.getId());
                    System.out.println(session.isNew());

                    //bind the variables
                    callStmt.setString(2, login_username);
                    callStmt.setString(3, login_password);
                    //callStmt.setString(4,null);//password Retry
                    //callStmt.setString(5,null);//New Password1
                    //callStmt.setString(6,null);//New password2
                    callStmt.registerOutParameter(4,
                                                  OracleTypes.VARCHAR); //Error Msg
                    callStmt.registerOutParameter(5,
                                                  OracleTypes.DATE); //Last login Return Value
                    callStmt.registerOutParameter(6,
                                                  OracleTypes.INTEGER); // UserCode Return value
                    callStmt.registerOutParameter(7,
                                                  OracleTypes.VARCHAR); //UserName Return Value
                    callStmt.registerOutParameter(1,
                                                  OracleTypes.INTEGER); //Return value
                    callStmt.setInt(8,
                                    (Integer)session.getAttribute("sysCode"));
                    callStmt.execute();

                    //callStmt.execute();
                    rset = callStmt.getInt(1);
                    System.out.println("rset="+rset);
                    login_message = callStmt.getString(4);
                    LoginDate = callStmt.getDate(5);
                    UsernameValue = login_username;
                    //CurrentUser.Username = login_username;

                    UserCode = callStmt.getBigDecimal(6);
                    //CurrentUser.LoginDate = callStmt.getDate(5);
                    //CurrentUser.UserCode = callStmt.getBigDecimal(6);
                    //CurrentUser.sysCode = 27;
                    session.setAttribute("sysCode", 27);
                    currentDate = new Date();

                    session.setAttribute("Username", login_username);
                    session.setAttribute("LoginDate", callStmt.getDate(5));
                    session.setAttribute("UserCode",
                                         callStmt.getBigDecimal(6));

                    session.setAttribute("loggedIn", true);
                    myConn.userVaraibleInitialization(conn);

                    /**
               * Terminate Connection
               */
                    conn.commit();
                    conn.close();

                    JbpmConfiguration pid = null;
                    wfEngine wf = new wfEngine();
                    pid = wf.startWorkFlowInstance();
                    wf.endWorkFlowInstance(pid);

                    if (rset == 1) {
                        try {
                            sysParameters();
                            connectedMachine();
                          GlobalCC.RedirectPage("/lmsmain.jspx");
                            return null;
                        } catch (Exception e) {
                            GlobalCC.EXCEPTIONREPORTING(conn, e);
                        }
                        return null;

                    } else if (rset == 2) {
                        /**
                   * Access Denied
                   */
                        //TODO

                        String message = login_message;
                        GlobalCC.INFORMATIONREPORTING(message);

                        return null;
                    } else if (rset == 5 || rset == 4) {
                        String message = login_message;
                        FacesContext.getCurrentInstance().addMessage(null,
                                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                      message,
                                                                                      message));
                        confirmPassword.setRendered(true);
                        newResetPassword.setRendered(true);
                        newConfirmPassword.setRendered(true);
                        newPassword.setRendered(true);
                        resetPasswordBtn.setRendered(true);


                    } else //Password problem
                    {
                        String message = login_message;
                        FacesContext.getCurrentInstance().addMessage(null,
                                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                      message,
                                                                                      message));

                        //return login_message;
                    }
                }
            } catch (Exception e) {
                GlobalCC.EXCEPTIONREPORTING(conn, e);
            }
        }

        return login_message;

    }

    public void sysParameters() {
        //User Branch Number;
        findUserBranch();
        findDefaultAccessGroup();
        findParameterValues("ALLOW_GRP_PREM_RATES_ABOVE_GROUP",
                            "PremiumRatesAbove");
        findParameterValues("ACRUAL_OR_CASH_BASIS_PAYMENT", "acrualCash");
        findParameterValues("SITE_PARAM", "siteParam");
        findBaseCurrencySymbol();
        ConstructLogo();
    }

    public String ConstructLogo() {
        Connection conn = null;
        try {
            DBConnector datahandler = new DBConnector();

            conn = datahandler.getDatabaseConn();

            FacesContext context = FacesContext.getCurrentInstance();
            ServletContext sc =
                (ServletContext)context.getExternalContext().getContext();
            String path = sc.getRealPath("/images/CompanyLogo.jpg");

            FileOutputStream out = new FileOutputStream(path);

            CallableStatement callStmt = null;

            String hrQuery = null;

            hrQuery =
                    "SELECT ORG_RPT_LOGO\nFROM TQC_ORGANIZATIONS, TQC_COUNTRIES, TQC_TOWNS, TQC_SYSTEMS\nWHERE ORG_TWN_CODE = TWN_CODE\nAND ORG_COU_CODE = COU_CODE\nAND SYS_ORG_CODE = ORG_CODE\nAND SYS_SHT_DESC = 'LMS'";

            callStmt = conn.prepareCall(hrQuery);
            ResultSet rs = callStmt.executeQuery();

            while (rs.next()) {
                byte[] barray = rs.getBytes(1);
                out.write(barray);
            }
            out.close();
            rs.close();
            callStmt.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public String findParameterValues(String Parameter, String SessionName) {
        Connection conn = null;
        try {
            String PremiumRatesAbove = "Y";
            session.setAttribute(SessionName, "Y");
            String paramQuery =
                "BEGIN LMS_ORD_MISC.system_param_val(?,?);END;";
            DBConnector datahandler = new DBConnector();

            conn = datahandler.getDatabaseConn();

            CallableStatement callStmt1 = conn.prepareCall(paramQuery);
            callStmt1.setString(1, Parameter);
            callStmt1.registerOutParameter(2, OracleTypes.VARCHAR);
            callStmt1.execute();
            PremiumRatesAbove = (String)callStmt1.getObject(2);
            if (PremiumRatesAbove == null)
                session.setAttribute(SessionName, "Y");
            else {
                session.setAttribute(SessionName, PremiumRatesAbove);
            }
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public String findUserBranch() {
        Connection conn = null;
        try {
            DBConnector datahandler = new DBConnector();

            conn = datahandler.getDatabaseConn();
            CallableStatement callStmt1;

            String UserBranch =
                "begin ? := tqc_web_pkg.get_default_usr_branch(?,?); end;";
            callStmt1 = conn.prepareCall(UserBranch);
            //register out
            callStmt1.registerOutParameter(1,
                                           OracleTypes.CURSOR); //authorization code
            callStmt1.setString(2, (String)session.getAttribute("Username"));
            callStmt1.setInt(3, 27);
            callStmt1.execute();
            ResultSet rs = (ResultSet)callStmt1.getObject(1);
            while (rs.next()) {
                //CurrentUser.BranchCode = rs.getBigDecimal(1);
                //CurrentUser.BranchName = rs.getString(3);
                session.setAttribute("BranchCode", rs.getBigDecimal(1));
                session.setAttribute("BranchName", rs.getString(3));
            }
            rs.close();
            conn.commit();
            conn.close();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }

        return null;
    }

    public String findDefaultAccessGroup() {
        Connection conn = null;
        try {
            DBConnector datahandler = new DBConnector();

            conn = datahandler.getDatabaseConn();
            CallableStatement callStmt1;

            String UserBranch =
                "begin ? := LMS_WEB_PKG_GRP.default_access_group(?); end;";
            callStmt1 = conn.prepareCall(UserBranch);
            //register out
            callStmt1.registerOutParameter(1,
                                           OracleTypes.NUMBER); //authorization code
            callStmt1.registerOutParameter(2,
                                           OracleTypes.VARCHAR); //authorization code
            callStmt1.execute();

            session.setAttribute("DeftlpagCode", callStmt1.getBigDecimal(1));
            session.setAttribute("DeftlpagDesc", callStmt1.getString(2));

            conn.commit();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }

        return null;
    }

    public String findBaseCurrencySymbol() {
        Connection conn = null;
        try {
            DBConnector datahandler = new DBConnector();

            conn = datahandler.getDatabaseConn();
            CallableStatement callStmt1;

            String baseCurrSymbol =
                "begin ? := LMS_GRP_MISC.getBaseCurrencySymbol(?); end;";
            callStmt1 = conn.prepareCall(baseCurrSymbol);
            //register out
            callStmt1.registerOutParameter(1,
                                           OracleTypes.VARCHAR); //Base Currency Symbol
            callStmt1.setString(2, "LMS");
            callStmt1.execute();
            session.setAttribute("baseCurrSymb", callStmt1.getString(1));
            conn.commit();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }

        return null;
    }

    public String logOut() {
        //CurrentUser.LoginDate = null;
        //CurrentUser.UserCode = null;
        //CurrentUser.Username = null;

        HttpServletRequest request =
            (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();


        ExternalContext ectx =
            FacesContext.getCurrentInstance().getExternalContext();
        HttpServletResponse response = (HttpServletResponse)ectx.getResponse();
        HttpSession session = (HttpSession)ectx.getSession(false);
        session.invalidate();
        session = request.getSession(true);
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Cache-Control", "no-store");
        response.setDateHeader("Expires",
                               0); //Causes the proxy cache to see the page as "stale"
        response.setHeader("Pragma",
                           "no-cache"); //HTTP 1.0 backward compatibility

        //CurrentUser.UserCode = null;
        session.setAttribute("Username", null);
        session.setAttribute("UserCode", null);
        session.setAttribute("loggedIn", false);
        session.setAttribute("baseCurrSymb", null);


        ReinitializeVar Res = new ReinitializeVar();
        Res.ReinitializeVar2();


        try {
            GlobalCC.RedirectPage("/index.jspx");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }
    /**
     * sysParameters
     */
    //public void sysParameters(){
    //Manual Proposal Number;
    //manualProposal();
    // }

    /**
     * Get manual proposal Parameters
     */
    /*
    public void manualProposal(){
        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConnection();
        CallableStatement callStmt;
        try {
            callStmt = conn.prepareCall(QueryDefn.manualProposal);
            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            callStmt.execute();
            ResultSet rs = (ResultSet)callStmt.getObject(1);
            while (rs.next()) {
                GlobalCC.manualProposal = rs.getString(1);
            }
            rs.close();
            conn.close();

        } catch (Exception e) {
             GlobalCC.EXCEPTIONREPORTING(conn,e);
        }
    }
*/

    /**
     * Get the IP Address and Name of Connecting machine
     */
    public void connectedMachine() {

        try {
            HttpServletRequest request =
                (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
            if (request.getHeader("x-forwarded-for") != null) {
                //System.out.println(InetAddress.getByName(request.getHeader("x-forwarded-for")));
            }

            //System.out.println(InetAddress.getByName(request.getRemoteAddr()));

            InetAddress addr = InetAddress.getLocalHost();

            // Get hostname
            String hostname = addr.getHostName();
            //System.out.println(addr);
            //System.out.println(hostname);
            InetAddress localHost = InetAddress.getLocalHost();
            // System.out.println(localHost.getHostName());
            //System.out.println(localHost.getHostAddress());
            InetAddress localHost2 = InetAddress.getLocalHost();
            System.out.println(localHost2);
            InetAddress[] all_IPs =
                InetAddress.getAllByName(localHost2.getHostName());
            for (int i = 0; i < all_IPs.length; i++) {
                System.out.println("IP address = " + all_IPs[i]);
            }

        } catch (Exception e) {

            String message = e.getMessage();
            GlobalCC.INFORMATIONREPORTING(message);


        }
    }


    public void setPassword(RichInputText password) {
        this.password = password;
    }

    public RichInputText getPassword() {
        return password;
    }

    public void setUsername(RichInputText username) {
        this.username = username;
    }

    public RichInputText getUsername() {
        return username;
    }


    public void setLoginDate(Date LoginDate) {
        Index.LoginDate = LoginDate;
    }

    public Date getLoginDate() {
        return LoginDate;
    }

    public void setUsernameValue(String UsernameValue) {
        Index.UsernameValue = UsernameValue;
    }

    public String getUsernameValue() {
        return UsernameValue;
    }

    public void setMainLogin(RichPanelBox mainLogin) {
        this.mainLogin = mainLogin;
    }

    public RichPanelBox getMainLogin() {
        return mainLogin;
    }

    public void setPass2(RichInputText pass2) {
        this.pass2 = pass2;
    }

    public RichInputText getPass2() {
        return pass2;
    }

    public void setNewPassword(RichInputText newPassword) {
        this.newPassword = newPassword;
    }

    public RichInputText getNewPassword() {
        return newPassword;
    }

    public void setConfirmPassword(RichOutputLabel confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public RichOutputLabel getConfirmPassword() {
        return confirmPassword;
    }

    public String ResetPassword() {
        /**
         * Function Variable Definition and initialization
         */
        String login_message = null;
        if (username.getValue() == null) {
            String message = "Enter A UserName";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                          message,
                                                                          message));
            return null;

        } else {
            login_username = username.getValue().toString();
        }

        if (password.getValue() == null) {
            String message = "Enter A Password";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                          message,
                                                                          message));
            return null;

        } else {
            login_password = newConfirmPassword.getValue().toString();
        }

        int rset = 0;

        session.setAttribute("loggedIn", false);
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();

        if (conn == null) {

            String message = "Error in Connection";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                          message,
                                                                          message));

            return null;
        }

        String connectionPackage =
            "begin ? := TQC_WEB_PKG.check_user_pwd(?,?,?,?,?,?,?,?,?,?); end;";

        CallableStatement callStmt;

        try {
            callStmt = conn.prepareCall(connectionPackage);


            if ((login_username == null) || (login_password == null)) {
                String message = "Enter Username / Password";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                              message,
                                                                              message));
                return null;
            } else {

                FacesContext context = FacesContext.getCurrentInstance();
                //HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
                /*FacesContext context = FacesContext.getCurrentInstance();
                context.getExternalContext().getSessionMap().get("Home");
                ExternalContext ectx =
                    context.getExternalContext();*/
                //MDSSession session = new
                HttpSession session =
                    (HttpSession)context.getExternalContext().getSession(false);
                HttpSession session2 =
                    (HttpSession)JSFUtils.getFacesContext().getExternalContext().getSession(true);
                System.out.println(JSFUtils.resolveRemoteUser());
                System.out.println(context);
                System.out.println(JSFUtils.getFacesContext());
                //FacesContext.getCurrentInstance().getExternalContext().getSession()
                //FacesContext facesContext = FacesContext.getCurrentInstance();
                //facesContext.
                System.out.println("Session1");
                System.out.println(session.getId());
                System.out.println("Session2");
                System.out.println(session2.getId());
                System.out.println(session.isNew());

                //bind the variables
                callStmt.setString(2, login_username);
                callStmt.setString(3, login_password);
                callStmt.registerOutParameter(4,
                                              OracleTypes.VARCHAR); //Error Msg
                callStmt.registerOutParameter(5,
                                              OracleTypes.DATE); //Last login Return Value
                callStmt.registerOutParameter(6,
                                              OracleTypes.INTEGER); // UserCode Return value
                callStmt.registerOutParameter(7,
                                              OracleTypes.VARCHAR); //UserName Return Value
                //callStmt.setString(4,null);//password Retry
                callStmt.setString(8, login_password); //New Password1
                callStmt.setString(9,
                                   newConfirmPassword.getValue().toString()); //New password2
                callStmt.setString(10, "Y"); //v_new_pwd_entry
                callStmt.setInt(11, (Integer)session.getAttribute("sysCode"));
                callStmt.registerOutParameter(1,
                                              OracleTypes.INTEGER); //Return value
                callStmt.execute();

                //callStmt.execute();
                rset = callStmt.getInt(1);
                login_message = callStmt.getString(4);
                LoginDate = callStmt.getDate(5);
                UsernameValue = login_username;
                //CurrentUser.Username = login_username;

                UserCode = callStmt.getBigDecimal(6);
                //CurrentUser.LoginDate = callStmt.getDate(5);
                //CurrentUser.UserCode = callStmt.getBigDecimal(6);
                //CurrentUser.sysCode = 27;
                session.setAttribute("sysCode", 27);
                currentDate = new Date();

                session.setAttribute("Username", login_username);
                session.setAttribute("LoginDate", callStmt.getDate(5));
                session.setAttribute("UserCode", callStmt.getBigDecimal(6));

                System.out.println("rset value" + rset);

                /**
                 * Terminate Connection
                 */
                conn.commit();
                conn.close();

                JbpmConfiguration pid = null;
                wfEngine wf = new wfEngine();
                pid = wf.startWorkFlowInstance();
                wf.endWorkFlowInstance(pid);

                if (rset == 1) {
                    /**
                     * Access Allowed
                     * Launch Dialog and redirect to HomePage.
                     */

                    try {

                        /**
                         * System Parameters
                         */
                        sysParameters();
                        connectedMachine();

                        GlobalCC.RedirectPage("/lmsmain.jspx");
                    } catch (Exception e) {
                        GlobalCC.EXCEPTIONREPORTING(conn, e);
                    }
                    return null;

                } else if (rset == 2) {
                    /**
                     * Access Denied
                     */
                    //TODO
                    String message = login_message;
                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                  message,
                                                                                  message));
                    confirmPassword.setRendered(true);
                    newResetPassword.setRendered(true);
                    newConfirmPassword.setRendered(true);
                    newPassword.setRendered(true);
                    resetPasswordBtn.setRendered(true);


                } else //Password problem
                {
                    String message = login_message;
                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                  message,
                                                                                  message));

                    //return login_message;
                }
            }
        } catch (Exception e) {
            LoginMessage = e.getMessage();
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }


        return login_message;

    }

   /* public Map isLdapUserCredentialsOk(String username, String password,
                                       String loginType) {
        String newuser = getDomainName();
        newuser = username.concat(newuser);
        String ldapAdServer = null;
        OracleConnection conn = null;
        try {
            DBConnector datahandler = new DBConnector();

            conn = (OracleConnection)datahandler.getDatabaseConn();
            OracleCallableStatement callStmt = null;
            String query1 =
                "begin ? := TQC_SETUPS_CURSOR.getParameter(?); end;";

            callStmt = (OracleCallableStatement)conn.prepareCall(query1);
            callStmt.registerOutParameter(1, -10);
            callStmt.setString(2, "LDAP_SERVER");

            callStmt.execute();
            OracleResultSet rs = (OracleResultSet)callStmt.getObject(1);
            while (rs.next()) {
                ldapAdServer = rs.getString(1);
            }
            callStmt.close();
            rs.close();
            Hashtable<String, Object> env = new Hashtable();
            env.put("java.naming.security.authentication", "simple");
            env.put("java.naming.factory.initial",
                    "com.sun.jndi.ldap.LdapCtxFactory");

            env.put("java.naming.provider.url", "ldap://" + ldapAdServer);
            DirContext ctx = new InitialDirContext(env);
            String[] myUsername = newuser.split("@");


            String[] ldapDomain = null;
            if (myUsername.length > 1) {
                ldapDomain = myUsername[0].split("\\.");
            }
            ldapDomain = myUsername[0].split("\\.");
            if (ldapDomain == null) {
                SearchResult srLdapUser =
                    findAccountByAccountName(ctx, ldapAdServer, newuser);

                String fullDN = null;
                fullDN = srLdapUser.getNameInNamespace();
                ctx.close();
                ctx = null;

                env.put("java.naming.security.authentication", "simple");
                env.put("java.naming.security.principal", fullDN);
                env.put("java.naming.security.credentials", password);
            }
            Map map = new HashMap();
            String login_message = null;
            int rset = 0;
            String jobquery =
                "begin ? := tqc_web_pkg.ldap_authenticate(?,?,?,?,?,?); end;";
            if (conn == null) {
                String message =
                    "Cannot connect to the server. Check your server connection";

                GlobalCC.errorValueNotEntered(message);
                return null;
            }
            callStmt = (OracleCallableStatement)conn.prepareCall(jobquery);
            callStmt.setString(2, username.toUpperCase());
            callStmt.registerOutParameter(3, 12);
            callStmt.registerOutParameter(4, 91);

            callStmt.registerOutParameter(5, 12);

            callStmt.registerOutParameter(6, 12);

            callStmt.setInt(7, 27);
            callStmt.registerOutParameter(1, 4);

            callStmt.execute();
            rset = callStmt.getInt(1);
            map.put("rset", Integer.valueOf(rset));
            login_message = callStmt.getString(3);
            map.put("login_message", login_message);
            Date loginDt = callStmt.getDate(4);
            BigDecimal usrCode = callStmt.getBigDecimal(5);

            callStmt.close();
            conn.commit();
            if (rset == 1) {
                session.setAttribute("LoginDate", loginDt);
                session.setAttribute("Username", username.toUpperCase());
                session.setAttribute("UserCode", usrCode);
                session.setAttribute("SIGN_IN_MODE", loginType);
                HttpServletRequest request =
                    (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
                String remoteAddr = request.getRemoteAddr();
                String userAgent = request.getHeader("User-Agent");
                UserAgentParser userAgentParser =
                    new UserAgentParser(userAgent);

                String DfltBranchDiv =
                    "begin  tqc_web_pkg.check_multiple_logins(?,?,?,?); end;";
                callStmt =
                        (OracleCallableStatement)conn.prepareCall(DfltBranchDiv);
                callStmt.setString(1,
                                   (String)session.getAttribute("Username"));
                callStmt.setString(2, remoteAddr);
                callStmt.setInt(3, 0);
                callStmt.setString(4, userAgentParser.getBrowserName());
                callStmt.execute();
                session.setAttribute("hostIp", remoteAddr);
                //FacesContext.getCurrentInstance().getExternalContext().redirect("lmsmain.jspx");
                //int rset2 = 0;
                // Map maps = new HashMap();
                //  maps = checkUserSystem(username);
                // checks if user is assigned that system

            }

            return map;
        } catch (Exception exception) {
            // GlobalCC.EXCEPTIONREPORTING(conn,"Invalid Login Credentials");
            exception.printStackTrace();
        }
        return null;
    }*/
   public Map isLdapUserCredentialsOk(String username, String password) {
       
              String newuser = getDomainName();
              newuser = username.concat(newuser);
       
       
           Map map = new HashMap();
           String ldapAdServer = null;
           OracleConnection conn = null;
           try {
               
               DBConnector datahandler = new DBConnector();

               conn = datahandler.getDatabaseConnection();
               OracleCallableStatement callStmt = null;
               String query1 =
                   "begin ? := TQC_SETUPS_CURSOR.getParameter(?); end;";
               callStmt = (OracleCallableStatement)conn.prepareCall(query1);
               callStmt.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
               callStmt.setString(2, "LDAP_SERVER");

               callStmt.execute();
               OracleResultSet rs = (OracleResultSet)callStmt.getObject(1);
               while (rs.next()) {
                   session.setAttribute("LDAP_SERVER", rs.getString(1));
                   ldapAdServer = rs.getString(1);

               }
               callStmt.close();
               rs.close();
               Hashtable<String, Object> env = new Hashtable<String, Object>();
               env.put(Context.SECURITY_AUTHENTICATION, "simple");
               env.put(Context.INITIAL_CONTEXT_FACTORY,
                       "com.sun.jndi.ldap.LdapCtxFactory");
               env.put(Context.PROVIDER_URL, "ldap://"+ldapAdServer);
               DirContext ctx = new InitialDirContext(env);
                           
               ctx = ActiveDirectory.getConnection(newuser,password,null,session.getAttribute("LDAP_SERVER").toString());
               session.setAttribute("ldapCtx", ctx);
             
               //ctx = new InitialDirContext(env);
              
               String login_message = null;
               int rset = 0;
               String jobquery =
                   "begin ? := tqc_web_pkg.ldap_authenticate(?,?,?,?,?,?); end;";

               if (conn == null) {
                   String message =
                       "Cannot connect to the server. Check your server connection";
                   GlobalCC.errorValueNotEntered(message);
                   return null;
               }

               //bind the variables

               callStmt = (OracleCallableStatement)conn.prepareCall(jobquery);
               callStmt.setString(2, username.toUpperCase());
               callStmt.registerOutParameter(3, OracleTypes.VARCHAR); //Error Msg
               callStmt.registerOutParameter(4,
                                             OracleTypes.DATE); //Last login Return Value
               callStmt.registerOutParameter(5,
                                             OracleTypes.VARCHAR); // UserCode Return value
               callStmt.registerOutParameter(6,
                                             OracleTypes.VARCHAR); //UserName Return Value
               callStmt.setInt(7, GlobalCC.sysCode);
               callStmt.registerOutParameter(1,
                                             OracleTypes.INTEGER); //Return value
               callStmt.execute();
               rset = callStmt.getInt(1);
               map.put("rset", rset);
               login_message = callStmt.getString(3);
               map.put("login_message", login_message);
               
               session.setAttribute("LoginDate", callStmt.getDate(4));
               session.setAttribute("Username", username.toUpperCase());
               session.setAttribute("Password", password);
               session.setAttribute("UserCode", callStmt.getBigDecimal(5));
               session.setAttribute("SIGN_IN_MODE", loginType());
               
               callStmt.close();
               conn.commit();
               conn.close(); 
               

               
             String rsetValue=GlobalCC.checkNullValues((map.get("rset")));
             
             if(rsetValue!=null){
                 
                     rset=new Integer(map.get("rset").toString());
                 }
             
             login_message =GlobalCC.checkNullValues(map.get("login_message"));
             


             if (rset == 1) { // Access allowed
               //this.sysParameters(conn);
               //conn.commit();
               //conn.close();
               
               FacesContext fc = FacesContext.getCurrentInstance();
               UIViewRoot viewRoot = fc.getApplication().getViewHandler().createView(fc, "/home.jspx");
               fc.setViewRoot(viewRoot);
               fc.renderResponse(); 
               return null;

             } else if (rset == 2) //Access Denied
             {
               GlobalCC.errorValueNotEntered(login_message);
             } else if(rset==4)//Password problem
             {
             }

           } catch (Exception exception) {
               
               java.lang.System.out.println("Exce");
               java.lang.System.out.println(exception.toString());
               exception.printStackTrace();
             
               GlobalCC.errorValueNotEntered("Invalid Login Credentials: "+exception.getMessage());
             
              // GlobalCC.EXCEPTIONREPORTING(conn, exception);
               return map;
           }
           
           return map;

       }

    public String loginType() {


        String loginType = "NORMAL";
        OracleConnection conn = null;
        try {
            DBConnector datahandler = new DBConnector();

            conn = (OracleConnection)datahandler.getDatabaseConn();
            OracleCallableStatement callStmt = null;
            String query1 =
                "begin ? := TQC_SETUPS_CURSOR.getParameter(?); end;";
            callStmt = (OracleCallableStatement)conn.prepareCall(query1);
            callStmt.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callStmt.setString(2, "SIGN_IN_MODE");

            callStmt.execute();
            OracleResultSet rs = (OracleResultSet)callStmt.getObject(1);
            while (rs.next()) {

                loginType = rs.getString(1);

            }
            callStmt.close();


            rs.close();
            conn.close();


        } catch (Exception exception) {

            GlobalCC.EXCEPTIONREPORTING(conn, exception);
            return loginType;
        }
        return loginType;

    }

    public SearchResult findAccountByAccountName(DirContext ctx,
                                                 String ldapSearchBase,
                                                 String accountName) throws NamingException {

        String searchFilter =
            "(&(objectClass=person)(uid=" + accountName + "))";
        SearchControls searchControls = new SearchControls();
        searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);
        NamingEnumeration<SearchResult> results =
            ctx.search(ldapSearchBase, searchFilter, searchControls);
        SearchResult searchResult = null;
        if (results.hasMoreElements()) {
            searchResult = (SearchResult)results.nextElement();
            Attributes attributes = searchResult.getAttributes();

            //make sure there is not another item available, there should be only 1 match
            if (results.hasMoreElements()) {
                System.err.println("Matched multiple users for the accountName: " +
                                   accountName);
                return null;
            }

        }

        return searchResult;
    }

    public String getDomainName() {


        String domainName = null;
        OracleConnection conn = null;
        try {
            DBConnector datahandler = new DBConnector();

            conn = (OracleConnection)datahandler.getDatabaseConn();
            OracleCallableStatement callStmt = null;
            String query1 =
                "begin ? := TQC_SETUPS_CURSOR.getParameter(?); end;";
            callStmt = (OracleCallableStatement)conn.prepareCall(query1);
            callStmt.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callStmt.setString(2, "DOMAIN");

            callStmt.execute();
            OracleResultSet rs = (OracleResultSet)callStmt.getObject(1);
            while (rs.next()) {
                //   session.setAttribute("SIGN_IN_MODE", rs.getString(1));
                domainName = rs.getString(1);

            }
            callStmt.close();


            rs.close();
            conn.close();


        } catch (Exception exception) {

            GlobalCC.EXCEPTIONREPORTING(conn, exception);
            // return loginType;
        }
        return domainName;

    }

    public Map checkUserSystem(String username) {
        DBConnector datahandler = new DBConnector();
        OracleConnection conn;
        Map map = new HashMap();
        conn = (OracleConnection)datahandler.getDatabaseConn();
        int rset = 0;
        OracleCallableStatement callStmt2 = null;
        String login_message = null;
        try {
            callStmt2 =
                    (OracleCallableStatement)conn.prepareCall("begin ? := tqc_web_pkg.user_sys_authenticate(?,?,?,?,?,?); end;");

            // LDAPConnector ldap = new LDAPConnector();
            // success =ldap.userAuthenticate(login_username, login_password);
            //  if ( success!=null){
            //  if (success.equalsIgnoreCase("success")) {
            callStmt2.setString(2, username.toUpperCase());
            callStmt2.registerOutParameter(3, OracleTypes.VARCHAR); //Error Msg
            callStmt2.registerOutParameter(4,
                                           OracleTypes.DATE); //Last login Return Value
            callStmt2.registerOutParameter(5,
                                           OracleTypes.INTEGER); // UserCode Return value
            callStmt2.registerOutParameter(6,
                                           OracleTypes.VARCHAR); //UserName Return Value
            callStmt2.registerOutParameter(1,
                                           OracleTypes.INTEGER); //Return value
            callStmt2.setInt(7, GlobalCC.sysCode);
            callStmt2.execute();
            rset = callStmt2.getInt(1);
            map.put("rset", rset);
            login_message = callStmt2.getString(3);
            map.put("login_message", login_message);
            conn.commit();
            conn.close();
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            GlobalCC.EXCEPTIONREPORTING(conn, e);
            return null;
        }
    }

    public Map isUserCredentialsOk(String username, String password,
                                   String loginType) {
        DBConnector datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();
        CallableStatement callStmt = null;
        Map map = new HashMap();
        String login_message = null;
        int rset = 0;
        String jobquery =
            "begin ? := tqc_web_pkg.user_authenticate(?,?,?,?,?,?,?); end;";
        if (username.equalsIgnoreCase(password)) {
            String message = "Password Cannot Be The Same As Username";
            GlobalCC.errorValueNotEntered(message);
            return null;
        }


        if (conn == null) {
            String message =
                "Cannot connect to the server. Check your server connection";
            GlobalCC.INFORMATIONREPORTING(message);
            return null;
        }


        //bind the variables
        try {
            callStmt = (OracleCallableStatement)conn.prepareCall(jobquery);
            callStmt.setString(2, username.toUpperCase());
            callStmt.setString(3, password);
            callStmt.registerOutParameter(4, OracleTypes.VARCHAR); //Error Msg
            callStmt.registerOutParameter(5,
                                          OracleTypes.DATE); //Last login Return Value
            callStmt.registerOutParameter(6,
                                          OracleTypes.VARCHAR); // UserCode Return value
            callStmt.registerOutParameter(7,
                                          OracleTypes.VARCHAR); //UserName Return Value
            callStmt.setInt(8, GlobalCC.sysCode);
            callStmt.registerOutParameter(1,
                                          OracleTypes.INTEGER); //Return value
            callStmt.execute();
            rset = callStmt.getInt(1);
            map.put("rset", rset);

            // System.out.println("ResetXXXX="+rset);

            login_message = callStmt.getString(4);
            map.put("login_message", login_message);
            Date loginDt = callStmt.getDate(5);
            BigDecimal usrCode = callStmt.getBigDecimal(6);
            callStmt.close();
            conn.commit();
            if (rset == 1) {

                FacesContext context = FacesContext.getCurrentInstance();
                ExternalContext ectx =
                    FacesContext.getCurrentInstance().getExternalContext();
                HttpServletResponse response =
                    (HttpServletResponse)ectx.getResponse();
                HttpSession session = (HttpSession)ectx.getSession(false);
                //session.invalidate();
                session = (HttpSession)ectx.getSession(true);
                context.responseComplete();

                session.setAttribute("LoginDate", loginDt);
                session.setAttribute("Username", username.toUpperCase());
                session.setAttribute("UserCode", usrCode);
                session.setAttribute("SIGN_IN_MODE", loginType);
                HttpServletRequest request =
                    (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
                String remoteAddr = request.getRemoteAddr();
                /*String userAgent = request.getHeader("User-Agent");
                UserAgentParser userAgentParser =
                    new UserAgentParser(userAgent);

                String DfltBranchDiv =
                    "begin  tqc_web_pkg.check_multiple_logins(?,?,?,?); end;";
                callStmt =
                        (OracleCallableStatement)conn.prepareCall(DfltBranchDiv);
                callStmt.setString(1,
                                   (String)session.getAttribute("Username"));
                callStmt.setString(2, remoteAddr);
                callStmt.setInt(3, 0);
                callStmt.setString(4, userAgentParser.getBrowserName());
                callStmt.execute();
                session.setAttribute("hostIp", remoteAddr);
                //FacesContext.getCurrentInstance().getExternalContext().redirect("lmsmain.jspx");
                int rset2 = 0;
                Map maps = new HashMap();
                maps = checkUserSystem(username);*/

            }

            conn.close();
            //System.out.println("Reset="+map.get("rset"));
            return map;
            // Get the user default branch


        } catch (Exception exception) {
            exception.printStackTrace();
            GlobalCC.EXCEPTIONREPORTING(conn, exception);

            return null;
        }


    }

    public void setNewResetPassword(RichOutputLabel newResetPassword) {
        this.newResetPassword = newResetPassword;
    }

    public RichOutputLabel getNewResetPassword() {
        return newResetPassword;
    }

    public void setNewConfirmPassword(RichInputText newConfirmPassword) {
        this.newConfirmPassword = newConfirmPassword;
    }

    public RichInputText getNewConfirmPassword() {
        return newConfirmPassword;
    }

    public void setResetPasswordBtn(RichCommandButton resetPasswordBtn) {
        this.resetPasswordBtn = resetPasswordBtn;
    }

    public RichCommandButton getResetPasswordBtn() {
        return resetPasswordBtn;
    }
}

