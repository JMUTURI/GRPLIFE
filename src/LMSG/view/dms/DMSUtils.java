package LMSG.view.dms;

import LMSG.view.Base.GlobalCC;
import LMSG.view.connect.DBConnector;

import java.io.PrintStream;

import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.util.ArrayList;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import oracle.jdbc.OracleTypes;

public class DMSUtils {
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);

    public ArrayList<String> getPolicyMetadata() {
        ArrayList<String> polMetadata = new ArrayList();
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        try {
            String policyQuest =
                "BEGIN dms_documents.getpolicymetadata(?,?,?,?,?);END;";

            cst = conn.prepareCall(policyQuest);
            cst.setBigDecimal(1,
                              (BigDecimal)this.session.getAttribute("policyCode"));

            cst.setBigDecimal(2,
                              (BigDecimal)this.session.getAttribute("endorsementCode"));

            cst.registerOutParameter(3, OracleTypes.VARCHAR);
            cst.registerOutParameter(4, OracleTypes.VARCHAR);
            cst.registerOutParameter(5, OracleTypes.VARCHAR);
            cst.execute();
            polMetadata.add(cst.getString(3));
            polMetadata.add(cst.getString(4));
            polMetadata.add(cst.getString(5));
            System.out.println("The endorsement number is "+cst.getString(4));
            cst.close();
            conn.close();
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
            ex.printStackTrace();
        }
        return polMetadata;
    }

    public ArrayList<String> getClaimMetadata() {
        ArrayList<String> claimMetadata = new ArrayList();
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        try {
            String claimQuery =
                "BEGIN dms_documents.getclaimmetadata(?,?,?,?,?,?,?);END;";

            cst = conn.prepareCall(claimQuery);
            System.out.println("**********CLAIM NO****************" +
                               this.session.getAttribute("ClaimNo"));

            cst.setString(1, (String)this.session.getAttribute("ClaimNo"));
            cst.registerOutParameter(2, OracleTypes.VARCHAR);
            cst.registerOutParameter(3, OracleTypes.VARCHAR);
            cst.registerOutParameter(4, OracleTypes.VARCHAR);
            cst.registerOutParameter(5, OracleTypes.VARCHAR);
            cst.registerOutParameter(6, OracleTypes.NUMBER);
            cst.registerOutParameter(7, OracleTypes.NUMBER);
            cst.execute();
            claimMetadata.add(cst.getString(2));
            claimMetadata.add(cst.getString(3));
            claimMetadata.add(cst.getString(4));
            claimMetadata.add(cst.getString(5));
            session.setAttribute("policyCode", cst.getBigDecimal(6));
            session.setAttribute("endorsementCode", cst.getBigDecimal(7));
            cst.close();
            conn.close();
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
            ex.printStackTrace();
        }
        return claimMetadata;
    }

    public ArrayList<String> getQuotMetadata() {
        ArrayList<String> quotationMetadata = new ArrayList();
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        try {
            String quotationQuery =
                "BEGIN dms_documents.getquotationmetadata(?,?,?);END;";

            cst = conn.prepareCall(quotationQuery);
            System.out.println("***QUOTATION CODE********" +
                               this.session.getAttribute("QuoteCode"));

            cst.setBigDecimal(1,
                              (BigDecimal)this.session.getAttribute("QuoteCode"));

            cst.registerOutParameter(2, OracleTypes.VARCHAR);
            cst.registerOutParameter(3, OracleTypes.VARCHAR);
            cst.execute();
            quotationMetadata.add(cst.getString(2));
            quotationMetadata.add(cst.getString(3));
            cst.close();
            conn.close();
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
            ex.printStackTrace();
        }
        return quotationMetadata;
    }

    public ArrayList<String> getMedicalMetadata() {
        ArrayList<String> quotationMetadata = new ArrayList();
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        try {
            String quotationQuery =
                "BEGIN dms_documents.getprovidermetadata(?,?,?);END;";

            cst = conn.prepareCall(quotationQuery);
            System.out.println("***FACILITATOR CODE********" +
                               this.session.getAttribute("FacilitatorCode"));

            cst.setBigDecimal(1,
                              (BigDecimal)this.session.getAttribute("FacilitatorCode"));

            cst.registerOutParameter(2, OracleTypes.VARCHAR);
            cst.registerOutParameter(3, OracleTypes.VARCHAR);
            cst.execute();
            quotationMetadata.add(cst.getString(2));
            quotationMetadata.add(cst.getString(3));
            cst.close();
            conn.close();
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
            ex.printStackTrace();
        }
        return quotationMetadata;
    }

    public String findDmsUrl() {
        Connection conn = null;
        String url = null;
        try {
            DBConnector datahandler = new DBConnector();

            conn = datahandler.getDatabaseConn();
            CallableStatement callStmt1;

            String query = "begin ? := DMS_DOCUMENTS.getcrmparam(?); end;";
            callStmt1 = conn.prepareCall(query);
            //register out
            callStmt1.registerOutParameter(1,
                                           OracleTypes.VARCHAR); //Base Currency Symbol
            callStmt1.setString(2, "DMS_SERVER_URL");
            callStmt1.execute();
            url = callStmt1.getString(1);

            conn.commit();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }

        return url;
    }

    public String findDmsApi() {
        Connection conn = null;
        String url = null;
        try {
            DBConnector datahandler = new DBConnector();

            conn = datahandler.getDatabaseConn();
            CallableStatement callStmt1;

            String query = "begin ? := DMS_DOCUMENTS.getcrmparam(?); end;";
            callStmt1 = conn.prepareCall(query);
            //register out
            callStmt1.registerOutParameter(1,
                                           OracleTypes.VARCHAR); //Base Currency Symbol
            callStmt1.setString(2, "DMS_API_URL");
            callStmt1.execute();
            url = callStmt1.getString(1);

            conn.commit();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }

        return url;
    }

    public String findMedicalVoucher() {
        Connection conn = null;
        String medVoucher = null;
        try {
            DBConnector datahandler = new DBConnector();

            conn = datahandler.getDatabaseConn();
            CallableStatement callStmt1;

            String query =
                "begin ? := DMS_DOCUMENTS.getgrpmedicalvoucher(?); end;";
            callStmt1 = conn.prepareCall(query);
            //register out
            callStmt1.registerOutParameter(1,
                                           OracleTypes.VARCHAR); //Base Currency Symbol
            callStmt1.setBigDecimal(2,
                                    (BigDecimal)session.getAttribute("fmptCode"));
            callStmt1.execute();
            medVoucher = callStmt1.getString(1);

            conn.commit();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }

        return medVoucher;
    }

    public String findCommissionVoucher() {
        Connection conn = null;
        String commVoucher = null;
        try {
            DBConnector datahandler = new DBConnector();

            conn = datahandler.getDatabaseConn();
            CallableStatement callStmt1;

            String query =
                "begin ? := DMS_DOCUMENTS.getcommissionvoucher(?); end;";
            callStmt1 = conn.prepareCall(query);
            //register out
            callStmt1.registerOutParameter(1,
                                           OracleTypes.VARCHAR); //Base Currency Symbol
            callStmt1.setBigDecimal(2,
                                    (BigDecimal)session.getAttribute("COP_CODE"));
            callStmt1.execute();
            commVoucher = callStmt1.getString(1);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }

        return commVoucher;
    }

    public String findUserPassword() {
        Connection conn = null;
        String password = null;
        try {
            DBConnector datahandler = new DBConnector();

            conn = datahandler.getDatabaseConn();
            CallableStatement callStmt1;

            String query = "begin ? := DMS_DOCUMENTS.getdmsdocuments(?); end;";
            callStmt1 = conn.prepareCall(query);
            //register out
            callStmt1.registerOutParameter(1, OracleTypes.VARCHAR);
            callStmt1.setString(2,
                                session.getAttribute("Username").toString());
            callStmt1.execute();
            password = callStmt1.getString(1);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }

        return password;
    }
    public String findMemberNo() {
        Connection conn = null;
        String memberNo = null;
        try {
            DBConnector datahandler = new DBConnector();

            conn = datahandler.getDatabaseConn();
            CallableStatement callStmt1;

            String query = "begin ? := DMS_DOCUMENTS.getmemberno(?); end;";
            callStmt1 = conn.prepareCall(query);
            //register out
            callStmt1.registerOutParameter(1, OracleTypes.VARCHAR);
            callStmt1.setBigDecimal(2,(BigDecimal)session.getAttribute("MemberNumber"));
            callStmt1.execute();
            memberNo = callStmt1.getString(1);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }

        return memberNo;
    }
    public String findBanks() {
        Connection conn = null;
        String bankName = null;
        try {
            DBConnector datahandler = new DBConnector();

            conn = datahandler.getDatabaseConn();
            CallableStatement callStmt1;

            String query = "begin ? := DMS_DOCUMENTS.getBanks(?); end;";
            callStmt1 = conn.prepareCall(query);
            //register out
            callStmt1.registerOutParameter(1, OracleTypes.VARCHAR);
            callStmt1.setString(2,(String)this.session.getAttribute("ClaimNo"));
            callStmt1.execute();
            bankName = callStmt1.getString(1);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }

        return bankName;
    }
    public String findCheques() {
        Connection conn = null;
        String chequeNo = null;
        try {
            DBConnector datahandler = new DBConnector();

            conn = datahandler.getDatabaseConn();
            CallableStatement callStmt1;

            String query = "begin ? := DMS_DOCUMENTS.getChequeNumbers(?); end;";
            callStmt1 = conn.prepareCall(query);
            //register out
            callStmt1.registerOutParameter(1, OracleTypes.VARCHAR);
            callStmt1.setString(2,(String)this.session.getAttribute("ClaimNo"));
            callStmt1.execute();
            chequeNo = callStmt1.getString(1);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }

        return chequeNo;
    }
    public BigDecimal findFacilitatorCode() {
        Connection conn = null;
        BigDecimal facilitatorCode = null;
        try {
            DBConnector datahandler = new DBConnector();

            conn = datahandler.getDatabaseConn();
            CallableStatement callStmt1;

            String query =
                "begin ? := DMS_DOCUMENTS.getFacilitatorCode(?); end;";
            callStmt1 = conn.prepareCall(query);
            //register out
            callStmt1.registerOutParameter(1,
                                           OracleTypes.NUMBER); //Base Currency Symbol
            callStmt1.setBigDecimal(2,
                                    (BigDecimal)session.getAttribute("fmptCode"));
            callStmt1.execute();
            facilitatorCode = callStmt1.getBigDecimal(1);

            conn.commit();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }

        return facilitatorCode;
    }

}
