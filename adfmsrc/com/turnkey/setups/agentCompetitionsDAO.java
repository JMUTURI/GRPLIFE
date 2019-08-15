package com.turnkey.setups;

import LMSG.view.Base.GlobalCC;
import LMSG.view.connect.DBConnector;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.OracleResultSet;
import oracle.jdbc.OracleTypes;

public class agentCompetitionsDAO {
    public agentCompetitionsDAO() {
        super();
    }
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);

    public List<agentCompetitions> findAgentCompetionRates() {
        DBConnector dbCon = new DBConnector();
        OracleConnection conn = null;
        conn = dbCon.getDatabaseConnection();
        OracleCallableStatement callStmt = null;

        List<agentCompetitions> agentCompetitionsData =
            new ArrayList<agentCompetitions>();

        String query =
            "begin LMS_SETUPS_CURSOR.agentCompetitionDtls(?,?,?,?); end;";
        // System.out.println("prodCode123=="+session.getAttribute("prodCode")+"branchCode234=="+session.getAttribute("branchCode")+"agcpCode4567"+session.getAttribute("agcpCode"));
        try {
            callStmt = (OracleCallableStatement)conn.prepareCall(query);
            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            callStmt.setBigDecimal(2,
                                   (BigDecimal)session.getAttribute("prodCode"));
            callStmt.setBigDecimal(3,
                                   (BigDecimal)session.getAttribute("branchCode"));
            callStmt.setBigDecimal(4,
                                   (BigDecimal)session.getAttribute("agcpCode"));
            callStmt.execute();
            OracleResultSet rs = (OracleResultSet)callStmt.getObject(1);

            while (rs.next()) {
                agentCompetitions agentCompetitionsDataDef =
                    new agentCompetitions();
                agentCompetitionsDataDef.setAgcpCode(rs.getBigDecimal(1));
                agentCompetitionsDataDef.setAgcpTotalPolicies(rs.getBigDecimal(2));
                agentCompetitionsDataDef.setAgcpTotalPremium(rs.getBigDecimal(3));
                agentCompetitionsDataDef.setAgcpWef(rs.getDate(4));
                agentCompetitionsDataDef.setAgcpWet(rs.getDate(5));
                agentCompetitionsDataDef.setAgcpRewardAmnt(rs.getBigDecimal(6));
                agentCompetitionsDataDef.setAgcpProdCode(rs.getBigDecimal(7));
                agentCompetitionsDataDef.setAgcpBrnCode(rs.getBigDecimal(8));
                agentCompetitionsDataDef.setAgcpCompetitionDesc(rs.getString(9));
                agentCompetitionsDataDef.setAgcpProddesc(rs.getString(10));
                if(rs.getString(11).equalsIgnoreCase("A")){
                    agentCompetitionsDataDef.setAgcpLevel("All Products");
                }else{
                    agentCompetitionsDataDef.setAgcpLevel("Specific Product");
                }
                agentCompetitionsDataDef.setAgcpPersitency(rs.getBigDecimal(12));
                agentCompetitionsDataDef.setAgcpPersitencyParam(rs.getBigDecimal(13));
                agentCompetitionsDataDef.setAgcpBrnName(rs.getString(14));
                agentCompetitionsData.add(agentCompetitionsDataDef);
                if (rs.getBigDecimal(2) != null) {
                    session.setAttribute("agcpTotalPolicies",
                                         rs.getBigDecimal(2));
                }
                if (rs.getBigDecimal(3) != null) {
                    session.setAttribute("agcpTotalPremium",
                                         rs.getBigDecimal(3));
                }
            }
            rs.close();
            callStmt.close();
            conn.commit();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return agentCompetitionsData;
    }
    public List<agentCompetitions> findAgentCompeRates() {
        DBConnector dbCon = new DBConnector();
        OracleConnection conn = null;
        conn = dbCon.getDatabaseConnection();
        OracleCallableStatement callStmt = null;

        List<agentCompetitions> agentCompetitionsData =
            new ArrayList<agentCompetitions>();

        String query =
            "begin LMS_WEB_CURSOR_SETUP.agentCompeDtls(?,?,?,?); end;";
        // System.out.println("prodCode123=="+session.getAttribute("prodCode")+"branchCode234=="+session.getAttribute("branchCode")+"agcpCode4567"+session.getAttribute("agcpCode"));
        try {
            callStmt = (OracleCallableStatement)conn.prepareCall(query);
            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            callStmt.setBigDecimal(2,
                                   (BigDecimal)session.getAttribute("prodCode"));
            callStmt.setBigDecimal(3,
                                   (BigDecimal)session.getAttribute("branchCode"));
            callStmt.setBigDecimal(4,
                                   (BigDecimal)session.getAttribute("agcpCode"));
            callStmt.execute();
            OracleResultSet rs = (OracleResultSet)callStmt.getObject(1);

            while (rs.next()) {
                agentCompetitions agentCompetitionsDataDef =
                    new agentCompetitions();
                agentCompetitionsDataDef.setAgcpCode(rs.getBigDecimal(1));
                agentCompetitionsDataDef.setAgcpTotalPolicies(rs.getBigDecimal(2));
                agentCompetitionsDataDef.setAgcpTotalPremium(rs.getBigDecimal(3));
                agentCompetitionsDataDef.setAgcpWef(rs.getDate(4));
                agentCompetitionsDataDef.setAgcpWet(rs.getDate(5));
                agentCompetitionsDataDef.setAgcpRewardAmnt(rs.getBigDecimal(6));
                agentCompetitionsDataDef.setAgcpProdCode(rs.getBigDecimal(7));
                agentCompetitionsDataDef.setAgcpBrnCode(rs.getBigDecimal(8));
                agentCompetitionsDataDef.setAgcpCompetitionDesc(rs.getString(9));
                agentCompetitionsDataDef.setAgcpProddesc(rs.getString(10));
                if(rs.getString(10) == null){
                    session.setAttribute("productDesc","All Products");
                }else{
                    session.setAttribute("productDesc",rs.getString(10));
                }
                if(rs.getString(11).equalsIgnoreCase("A")){
                    agentCompetitionsDataDef.setAgcpLevel("All Products");
                }else{
                    agentCompetitionsDataDef.setAgcpLevel("Specific Product");
                }
                agentCompetitionsDataDef.setAgcpPersitency(rs.getBigDecimal(12));
                agentCompetitionsData.add(agentCompetitionsDataDef);
                if (rs.getBigDecimal(2) != null) {
                    session.setAttribute("agcpTotalPolicies",
                                         rs.getBigDecimal(2));
                }
                if (rs.getBigDecimal(3) != null) {
                    session.setAttribute("agcpTotalPremium",
                                         rs.getBigDecimal(3));
                }
            }
            rs.close();
            callStmt.close();
            conn.commit();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return agentCompetitionsData;
    }

    public List<agentCompetitions> findAgentCompetionTrans() {
        DBConnector dbCon = new DBConnector();
        OracleConnection conn = null;
        conn = dbCon.getDatabaseConnection();
        OracleCallableStatement callStmt = null;

        List<agentCompetitions> agentCompetitionsTransData =
            new ArrayList<agentCompetitions>();

        String query =
            "begin LMS_WEB_CURSOR_SETUP.agentCompetitionTransTypes(?,?,?); end;";

        try {
            callStmt = (OracleCallableStatement)conn.prepareCall(query);
            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            callStmt.setBigDecimal(2,
                                   (BigDecimal)session.getAttribute("branchCode"));
          callStmt.setBigDecimal(3,
                                 (BigDecimal)session.getAttribute("prodCode"));
            System.out.print("branchCode1234=" +
                             session.getAttribute("branchCode")+"branchCode"+session.getAttribute("prodCode"));
            callStmt.execute();
            OracleResultSet rs = (OracleResultSet)callStmt.getObject(1);
            while (rs.next()) {
                agentCompetitions agentCompetitionsTransDataDef =
                    new agentCompetitions();
                agentCompetitionsTransDataDef.setAgcpCodeTrans(rs.getBigDecimal(1));
                /*if(rs.getBigDecimal(1)!=null){
                session.setAttribute("agcpCode", rs.getBigDecimal(1));
                }*/
                agentCompetitionsTransDataDef.setAgcpCompetitionDescTrans(rs.getString(2));
                agentCompetitionsTransData.add(agentCompetitionsTransDataDef);

            }
            rs.close();
            callStmt.close();
            conn.commit();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return agentCompetitionsTransData;
    }

    public List<agentCompetitions> findAgentCommissionReceived() {
        DBConnector dbCon = new DBConnector();
        OracleConnection conn = null;
        conn = dbCon.getDatabaseConnection();
        OracleCallableStatement callStmt = null;
        OracleCallableStatement callStmt2 = null;
        List<agentCompetitions> agentTransData =
            new ArrayList<agentCompetitions>();

        String query =
            "begin LMS_PROCESS_COMMISSIONS.Get_premiumPolicies_rcvd(?,?,?,?,?,?,?,?,?); end;";
        String query2 =
            "begin LMS_WEB_CURSOR_SETUP.agentCompetitionTransaction(?); end;";

        try {
            callStmt2 = (OracleCallableStatement)conn.prepareCall(query2);
            callStmt2.registerOutParameter(1, OracleTypes.CURSOR);
            callStmt2.execute();
            OracleResultSet rs2 = (OracleResultSet)callStmt2.getObject(1);
            while (rs2.next()) {
                //callStmt = (OracleCallableStatement)conn.prepareCall(query);
                callStmt = (OracleCallableStatement)conn.prepareCall(query);
                callStmt.registerOutParameter(1, OracleTypes.CURSOR);
               /* if (DateFrom.contains(":")) {
                    DateFrom = GlobalCC.parseDate(DateFrom);
                } else {
                    DateFrom = GlobalCC.upDateParseDate(DateFrom);
                }
                if (DateTo.contains(":")) {
                    DateTo = GlobalCC.parseDate(DateTo);
                } else {
                    DateTo = GlobalCC.upDateParseDate(DateTo);
                }*/
                callStmt.setDate(2, rs2.getDate(1));
                callStmt.setDate(3, rs2.getDate(2));
                callStmt.setBigDecimal(4,
                                       (BigDecimal)session.getAttribute("agcpTotalPremium"));
                callStmt.setBigDecimal(5,
                                       (BigDecimal)session.getAttribute("agcpTotalPolicies"));
                callStmt.setBigDecimal(6,
                                       (BigDecimal)session.getAttribute("branchCode"));
                callStmt.setBigDecimal(7,
                                       (BigDecimal)session.getAttribute("prodCode"));
                callStmt.setString(8,
                                   (String)session.getAttribute("authorizeStatus"));
                callStmt.setBigDecimal(9,
                                   (BigDecimal)session.getAttribute("agcpCode"));
                System.out.println("date from=" + rs2.getDate(1) +
                                   "date to==" + rs2.getDate(2) +
                                   "agcpTotalPremium" +
                                   session.getAttribute("agcpTotalPremium") +
                                   "agcpTotalPolicies" +
                                   session.getAttribute("agcpTotalPolicies") +
                                   "branchCode=" +
                                   session.getAttribute("branchCode") +
                                   "prodCode" +
                                   session.getAttribute("prodCode") +
                                   "authorizeStatus" +
                                   session.getAttribute("prodCode"));
                callStmt.execute();
                OracleResultSet rs = (OracleResultSet)callStmt.getObject(1);
                while (rs.next()) {
                    agentCompetitions agentTransDataDef =
                        new agentCompetitions();
                    agentTransDataDef.setAgnCodeComp(rs.getBigDecimal(1));
                    agentTransDataDef.setAgnShtDescComp(rs.getString(2));
                    agentTransDataDef.setAgnName(rs.getString(3));
                    agentTransDataDef.setAmtCollectedComp(rs.getBigDecimal(4));
                    agentTransDataDef.setPolicyCntComp(rs.getBigDecimal(5));
                    agentTransDataDef.setAgnChecked(rs.getString(6));
                    if (rs.getString(6) != null) {
                        if (rs.getString(6).toString().equalsIgnoreCase("Y")) {
                            agentTransDataDef.setSelect(true);
                        } else {
                            agentTransDataDef.setSelect(false);
                        }
                    }
                    agentTransDataDef.setPersistency(rs.getBigDecimal(7));
                    agentTransData.add(agentTransDataDef);
                }
                rs.close();
                callStmt.close();
            }
            rs2.close();
            callStmt2.close();
            conn.commit();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return agentTransData;
    }
}
