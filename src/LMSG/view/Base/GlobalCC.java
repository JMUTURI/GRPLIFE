package LMSG.view.Base;


import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.text.SimpleDateFormat;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.output.RichMessage;

import oracle.jdbc.OracleTypes;

import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

import LMSG.view.connect.DBConnector;

import com.bea.common.security.xacml.IOException;

import java.sql.ResultSet;

import java.text.ParseException;

import javax.faces.component.UIViewRoot;

import javax.faces.context.ExternalContext;

import oracle.adf.controller.ControllerContext;
import oracle.adf.model.DataControl;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.input.RichInputDate;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleConnection;

import org.apache.chemistry.opencmis.commons.exceptions.CmisConstraintException;
import org.apache.chemistry.opencmis.commons.exceptions.CmisContentAlreadyExistsException;
import org.apache.chemistry.opencmis.commons.exceptions.CmisObjectNotFoundException;

public class GlobalCC {
    public GlobalCC() {
        super();
    }
    public static String dialogName;
    public static final int RowsLimit = 1000;
    public static final int sysCode = 27;
    public static final String emailFrom = "";
    public static final String mailhost = "";
    public static String reportsPath =
        "C:/Documents and Settings/user/Application Data/JDeveloper/system11.1.1.1.33.54.07/DefaultDomain/Reports";

    /**
     * Error For Raising Exception
     * @param exception
     * @return
     */
    /* public static String EXCEPTIONREPORTING(Exception exception){
        exception.printStackTrace();

        String errMessage = exception.getMessage();
        if(FacesContext.getCurrentInstance() == null){

            exception.printStackTrace();

        }else{
            FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                  errMessage,
                                                                                  errMessage));
        }

        return null;
    }*/

    private static RichMessage more;
    private static RichMessage errorMsg;
    private static RichMessage errCode;
    private static RichMessage errName;
    private static RichMessage errText;
    private static RichMessage syserrCode;
    private static RichMessage sysErrMsg;
    private static RichMessage rcmdendation;
    private static RichMessage errStack;
    private static RichMessage callStack;
    private static RichMessage envirment;
    private static RichPopup errorPop;

    public static String EXCEPTIONREPORTING(Connection conn, Exception e) {
        String errorMess = e.getMessage();
        //System.out.println("GROUP EXCEPTIONS: "+ e.getMessage());
        if (errorMess == null) {
            errorMess = "Null Error Exception";
        }
        if (errorMess.startsWith("ORA")) {
            try {
                if (conn != null) {
                    conn.commit();
                    String ckQuery =
                        "begin tqc_error_manager.get_error_info(?,?,?,?,?,?,?,?,?); end;";

                    CallableStatement cst = null;

                    cst = conn.prepareCall(ckQuery);
                    cst.registerOutParameter(1, OracleTypes.INTEGER);
                    cst.registerOutParameter(2, OracleTypes.VARCHAR);
                    cst.registerOutParameter(3, OracleTypes.VARCHAR);
                    cst.registerOutParameter(4, OracleTypes.INTEGER);
                    cst.registerOutParameter(5, OracleTypes.VARCHAR);
                    cst.registerOutParameter(6, OracleTypes.VARCHAR);
                    cst.registerOutParameter(7, OracleTypes.VARCHAR);
                    cst.registerOutParameter(8, OracleTypes.VARCHAR);
                    cst.registerOutParameter(9, OracleTypes.VARCHAR);
                    cst.execute();
                    if (cst.getBigDecimal(1) == null) {
                        nonerrorPkg(errorMess);
                        ExtendedRenderKitService erkService =
                            Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                               ExtendedRenderKitService.class);
                        FacesContext context =
                            FacesContext.getCurrentInstance();
                        String cID = errorPop.getClientId(context);
                        erkService.addScript(FacesContext.getCurrentInstance(),
                                             "var hints = {autodismissNever:true}; " +
                                             "AdfPage.PAGE.findComponent('" +
                                             cID + "').show(hints);");
                    } else {
                        errorPkg(cst.getBigDecimal(1), cst.getString(2),
                                 cst.getString(3), cst.getBigDecimal(4),
                                 cst.getString(5), cst.getString(6),
                                 cst.getString(7), cst.getString(8),
                                 cst.getString(9));
                        ExtendedRenderKitService erkService =
                            Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                               ExtendedRenderKitService.class);
                        FacesContext context =
                            FacesContext.getCurrentInstance();
                        String cID = errorPop.getClientId(context);
                        erkService.addScript(FacesContext.getCurrentInstance(),
                                             "var hints = {autodismissNever:true}; " +
                                             "AdfPage.PAGE.findComponent('" +
                                             cID + "').show(hints);");
                    }

                    conn.commit();
                    conn.close();
                } else {
                    String message = errorMess;
                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                                  message,
                                                                                  message));
                }


            } catch (Exception f) {
                String message = f.getMessage();
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                              message,
                                                                              message));
            }

        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                          errorMess,
                                                                          errorMess));

        }

        return null;
    }

    /**
     * Close Active Conncections
     */
    public static void CloseConnections(ResultSet rs, CallableStatement cst,
                                        Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (Exception rse) {
            rse.printStackTrace();
        }
        try {
            if (cst != null) {
                cst.close();
            }
        } catch (Exception sse) {
            sse.printStackTrace();
        }
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception cse) {
            cse.printStackTrace();
        }
    }

    /**
     * Redirect Page
     *
     */
    public static String RedirectPage(String PageName) {
        try {
            /*FacesContext fc = FacesContext.getCurrentInstance();
          UIViewRoot viewRoot = fc.getApplication().getViewHandler().createView(fc, PageName);
          fc.setViewRoot(viewRoot);
          fc.renderResponse(); */
            PageName = PageName.replace("/", "");
            FacesContext.getCurrentInstance().getExternalContext().redirect(PageName);
        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                          e.getMessage(),
                                                                          e.getMessage()));
        }
        return null;
    }

    /**
     *
     * findCurrentDate - Find the Current Server Date.
     */
    public static String findCurrentDate() {
        String TodaysDate = null;
        DBConnector datahandler = new DBConnector();
        Connection conn = null;
        conn = datahandler.getDatabaseConn();
        CallableStatement cstActivityDetails = null;
        try {

            SimpleDateFormat sdf2 =
                new SimpleDateFormat(("dd/MM/yyyy hh:mm:ss aaa"));

            String ActivityDetails =
                "begin TQC_COMMON_CURSORS.get_current_date(?,?,?,?);end;";

            cstActivityDetails = conn.prepareCall(ActivityDetails);
            cstActivityDetails.registerOutParameter(1, OracleTypes.DATE);
            cstActivityDetails.registerOutParameter(2, OracleTypes.INTEGER);
            cstActivityDetails.registerOutParameter(3, OracleTypes.INTEGER);
            cstActivityDetails.registerOutParameter(4, OracleTypes.INTEGER);
            cstActivityDetails.execute();

            Date Today;
            Today = cstActivityDetails.getDate(1);

            TodaysDate = sdf2.format(Today);
            cstActivityDetails.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        } finally {
            GlobalCC.CloseConnections(null, cstActivityDetails, conn);
        }
        return TodaysDate;

    }

    public static String nonerrorPkg(String message) {

        errText.setMessage("<html><b>ERROR NAME:</b> </html>" + message + " ");
        sysErrMsg.setMessage("<html><b>SYSTEM ERROR MESSAGE:</b>" + message +
                             " ");
        return null;
    }

    public static String errorPkg(BigDecimal errorCode, String errNameVal,
                                  String errTextVal, BigDecimal syserrCodeVal,
                                  String sysErrMsgVal, String rcmendVal,
                                  String errStackVal, String callStackVal,
                                  String enviVal) {
        String errCodeVal = null;
        String sysErrCodeValue = null;
        if (errorCode == null) {

        } else {
            errCodeVal = errorCode.toString();
        }
        if (syserrCodeVal != null) {
            sysErrCodeValue = syserrCodeVal.toString();
        }
        errCode.setMessage("<html><b>ERROR CODE: </b> </html>" + errCodeVal +
                           " ");
        errName.setMessage("<html><b>ERROR NAME: </b> </html>" + errNameVal +
                           " ");
        errText.setMessage("<html><b>ERROR TEXT: </b> </html>" + errTextVal +
                           " ");
        syserrCode.setMessage("<html><b>SYSTEM ERROR CODE: </b> </html>" +
                              sysErrCodeValue + " ");
        sysErrMsg.setMessage("<html><b>SYSTEM ERROR MESSAGE: </b> </html>" +
                             sysErrMsgVal + " ");
        rcmdendation.setMessage("<html><b>RECOMMENDATION: </b> </html>" +
                                rcmendVal + " ");
        errStack.setMessage("<html><b>ERROR STACK:</b> </html> " +
                            errStackVal + " ");
        callStack.setMessage("<html><b>ERROR CALL STACK:</b> </html> " +
                             callStackVal + " ");
        envirment.setMessage("<html><b>ENVIRONMENT:</b> </html> " + enviVal +
                             " ");
        return null;
    }

    /**
     * Error For Raising Information to Users.
     * @param errMessage
     * @return
     */
    public static String INFORMATIONREPORTING(String errMessage) {
        if (errMessage == null) {
            return null;
        } else {
            if (FacesContext.getCurrentInstance() == null) {


            } else {
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              errMessage,
                                                                              errMessage));
            }
        }
        return null;
    }


    public void setMore(RichMessage more) {
        this.more = more;
    }

    public RichMessage getMore() {
        return more;
    }

    public void setErrorMsg(RichMessage errorMsg) {
        this.errorMsg = errorMsg;
    }

    public RichMessage getErrorMsg() {
        return errorMsg;
    }

    public void setErrCode(RichMessage errCode) {
        this.errCode = errCode;
    }

    public RichMessage getErrCode() {
        return errCode;
    }

    public void setErrName(RichMessage errName) {
        this.errName = errName;
    }

    public RichMessage getErrName() {
        return errName;
    }

    public void setErrText(RichMessage errText) {
        this.errText = errText;
    }

    public RichMessage getErrText() {
        return errText;
    }

    public void setSyserrCode(RichMessage syserrCode) {
        this.syserrCode = syserrCode;
    }

    public RichMessage getSyserrCode() {
        return syserrCode;
    }

    public void setSysErrMsg(RichMessage sysErrMsg) {
        this.sysErrMsg = sysErrMsg;
    }

    public RichMessage getSysErrMsg() {
        return sysErrMsg;
    }

    public void setRcmdendation(RichMessage rcmdendation) {
        this.rcmdendation = rcmdendation;
    }

    public RichMessage getRcmdendation() {
        return rcmdendation;
    }

    public void setErrStack(RichMessage errStack) {
        this.errStack = errStack;
    }

    public RichMessage getErrStack() {
        return errStack;
    }

    public void setCallStack(RichMessage callStack) {
        this.callStack = callStack;
    }

    public RichMessage getCallStack() {
        return callStack;
    }

    public void setEnvirment(RichMessage envirment) {
        this.envirment = envirment;
    }

    public RichMessage getEnvirment() {
        return envirment;
    }


    public void setErrorPop(RichPopup errorPop) {
        GlobalCC.errorPop = errorPop;
    }

    public RichPopup getErrorPop() {
        return errorPop;
    }

    /**
     *Function to raise error for Mandatory Values
     * @param errMessage
     * @return
     */
    public static String errorValueNotEntered(String errMessage) {
        if (FacesContext.getCurrentInstance() == null) {


        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                          errMessage,
                                                                          errMessage));
        }

        return null;
    }

    /**
     * Method For Raising A popUp from a page.
     * It takes popup id variable form tha ADF page.
     * If the page is working on a template then pass the template id and popup id seperated by semi colons.
     * E.g "hrms:elemPopUp"
     * @param popupId
     * @return
     */
    public static String showPopup(String popupId) {
        ExtendedRenderKitService erkService =
            Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                               ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
                             "var hints = {autodismissNever:false}; " +
                             "AdfPage.PAGE.findComponent('" + popupId +
                             "').show(hints);");
        return null;
    }

    /**
     * Method for hiding a popup.
     * @param popupId
     * @return
     */

    public static String hidePopup(String popupId) {
        ExtendedRenderKitService erkService =
            Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                               ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
                             "var hints = {autodismissNever:false}; " +
                             "AdfPage.PAGE.findComponent('" + popupId +
                             "').hide(hints);");
        return null;
    }

    public static String sysInformation(String errMessage) {
        if (FacesContext.getCurrentInstance() == null) {


        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          errMessage,
                                                                          errMessage));
        }

        return null;
    }

    /**
     *Function to Check for null Values
     * @param objName
     * @return
     */
    public static String checkNullValues(Object objName) {

        String objectValue = null;
        if (objName == null) {

        } else {
            objectValue = objName.toString();
        }
        return objectValue;
    }

    /**
     *Function to ParseDate
     * @param somedate
     * @return
     */
    public static String parseDate(String somedate) {

        Date date;
        date = null;
        String dateString;
        dateString = null;
        SimpleDateFormat sdf1 =
            new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MMMM/yyyy");


        try {
            date = sdf1.parse(somedate);
        } catch (Exception e) {

            try {
                date = sdf3.parse(somedate);
            } catch (ParseException f) {
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                              f.getMessage(),
                                                                              f.getMessage()));
            }

        }
        dateString = sdf2.format(date);

        return dateString;
    }

    public static java.sql.Date extractDate(RichInputDate component) {
        java.sql.Date val = null;
        try {
            val = new java.sql.Date(((Date)component.getValue()).getTime());
        } catch (Exception ex) {
            val = null;
        }
        return val;
    }

    /**
     *Function to ParseDate
     * @param somedate
     * @return
     */
    public static String parseMonthDate(String somedate) {

        Date date;
        date = null;
        String dateString;
        dateString = null;
        SimpleDateFormat sdf1 =
            new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM");


        try {
            date = sdf1.parse(somedate);
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                          e.getMessage(),
                                                                          e.getMessage()));
        }
        dateString = sdf2.format(date);

        return dateString;
    }

    public static String parseMonthYear(String somedate) {

        Date date;
        date = null;
        String dateString;
        dateString = null;
        SimpleDateFormat sdf1 =
            new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("MM/yyyy");


        try {
            date = sdf1.parse(somedate);
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                          e.getMessage(),
                                                                          e.getMessage()));
        }
        dateString = sdf2.format(date);

        return dateString;
    }

    public static String upDateParseDate(String somedate) {

        Date date;
        date = null;
        String dateString;
        dateString = null;
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MMMM/yyyy");


        try {
            date = sdf1.parse(somedate);
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                          e.getMessage(),
                                                                          e.getMessage()));
        }
        dateString = sdf2.format(date);

        return dateString;
    }

    public static String parseDateAuthFormat(String somedate) {
        String Results = "Invalid Date Format";
        try {
            if (somedate.trim().length() != 0) {
                SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
                if (somedate.trim().length() != df.toPattern().length()) {
                    Results = "Invalid Date Format";
                    System.out.println(somedate.trim().length() + "pattern" +
                                       df.toPattern().length());
                    return Results;
                }
                df.setLenient(false);
                Date ParseDate = df.parse(somedate);
                Results = df.format(ParseDate);
            } else {
                Results = "No Date";
            }
        } catch (Exception e) {
            Results = "Invalid Date Format";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                          e.getMessage(),
                                                                          e.getMessage()));


        }

        return Results;
    }

    public static Integer CheckNullExcelValues(String someValue) {
        Integer Results = 0;
        Results = someValue.trim().length();
        return Results;
    }

    public static String findSysParam(String param, BigDecimal prodCode) {
        DBConnector dbConn = new DBConnector();
        OracleConnection connect = null;
        connect = (OracleConnection)dbConn.getDatabaseConn();
        String paramValue = "N";
        OracleCallableStatement cst = null;
        try {
            String sysQuery =
                "begin LMS_ORD_MISC.System_param_val(?,?,?); end;";
            cst = (OracleCallableStatement)connect.prepareCall(sysQuery);
            cst.setString(1, param);
            cst.registerOutParameter(2, OracleTypes.VARCHAR);
            cst.setBigDecimal(3, prodCode);
            cst.execute();
            if (cst.getString(2) != null) {
                paramValue = cst.getString(2);
            }
            cst.close();
            connect.commit();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
            GlobalCC.EXCEPTIONREPORTING(connect, e);
        }
        return paramValue;
    }


    public static String getSytemParam(String paramName) {
        String paramValue = "N";
        Connection conn = null;
        CallableStatement cst = null;
        String query = "BEGIN lms_ord_misc.system_param_val(?,?);END;";
        conn = new DBConnector().getDatabaseConn();

        try {
            cst = conn.prepareCall(query);
            cst.setString(1, paramName);
            cst.registerOutParameter(2,
                                     oracle.jdbc.internal.OracleTypes.VARCHAR);
            cst.execute();
            paramValue = cst.getString(2);

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return paramValue;
    }

    public static String findProcessFlowEnabled() {
        DBConnector dbConn = new DBConnector();
        OracleConnection connect = null;
        connect = dbConn.getDatabaseConnection();
        String enabled = "N";
        OracleCallableStatement cst = null;
        try {
            String sysQuery =
                "begin LMS_GRP_MISC.System_param_val(?,?,?); end;";
            cst = (OracleCallableStatement)connect.prepareCall(sysQuery);
            cst.setString(1, "LMS_USE_PROCESS_FLOW");
            cst.registerOutParameter(2, OracleTypes.VARCHAR);
            cst.setString(3, null);
            cst.execute();
            if (cst.getString(2) != null) {
                enabled = cst.getString(2);
            }
            cst.close();
            connect.commit();
            connect.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(connect, e);
        }
        return enabled;
    }


    public static String findDMSEnabled() {

        String enabled = "N";

        Connection conn = null;
        CallableStatement cst = null;
        try {
            String sysQuery =
                "begin LMS_GRP_MISC.System_param_val(?,?,?); end;";
            conn = new DBConnector().getDatabaseConn();
            cst = conn.prepareCall(sysQuery);
            cst.setString(1, "DMS_GRP_ENABLED");
            cst.registerOutParameter(2, OracleTypes.VARCHAR);
            cst.setString(3, null);
            cst.execute();
            if (cst.getString(2) != null) {
                enabled = cst.getString(2);

            }
            cst.close();
            conn.commit();
            conn.close();
        } catch (Exception e) {
            // GlobalCC.EXCEPTIONREPORTING(connect, e);
            e.printStackTrace();
        }
        return enabled;
    }

    //anthony
    //method to handle alfresco related exceptions

    public static String alfrescoError(Exception e) {
        String message = null;
        if (e instanceof CmisContentAlreadyExistsException) {
            message = "Error adding content. Document Already Exists!";
        } else if (e instanceof CmisObjectNotFoundException) {
            message =
                    "CMIS object not found. Please check aspect or document type!";
            //CmisConstraintException
        } else if (e instanceof CmisConstraintException) {
            message =
                    "Constraint error. Type, aspect or folder cannot be created in alfresco!";
        } else { //super class Exception
            message = "Alfresco Error! " + e.getMessage();
        }
        FacesContext.getCurrentInstance().addMessage(null,
                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                      message,
                                                                      message));
        return null;
    }

    public static String viewContext(String paramString) {
        DCBindingContainer localDCBindingContainer =
            ADFUtils.getDCBindingContainer();
        Object localObject1;
        Object localObject2;
        if (localDCBindingContainer != null) {
            int i = 0;
            while (i < localDCBindingContainer.getCtrlBindingList().size()) {
                if (localDCBindingContainer.getCtrlBindingList().get(i).toString().contains("Iter")) {
                    localObject1 =
                            ADFUtils.findIterator(localDCBindingContainer.getCtrlBindingList().get(i).toString());

                    localObject2 =
                            ((DCIteratorBinding)localObject1).getDataControl();
                    ((DataControl)localObject2).release(1);
                }
                i++;
            }
        }
        FacesContext localFacesContext = FacesContext.getCurrentInstance();
        localObject1 = localFacesContext.getExternalContext();
        localObject2 = paramString + ".jspx";
        ControllerContext localControllerContext = null;
        localControllerContext = ControllerContext.getInstance();
        String str =
            localControllerContext.getGlobalViewActivityURL((String)localObject2);
        try {
            ((ExternalContext)localObject1).redirect(str);
        } catch (Exception localIOException) {
            localIOException.printStackTrace();
        }

        return null;
    }
}
