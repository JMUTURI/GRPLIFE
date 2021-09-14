package LMSG.view.Policy;

import LMSG.view.Base.LOVCC;
import LMSG.view.connect.DBConnector;
import LMSG.view.Base.GlobalCC;
import LMSG.view.Base.Settings;
import LMSG.view.Quotation.Quotations;

import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import oracle.jdbc.OracleTypes;

public class endorsementsDAO extends LOVCC {
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);

    public List<endorsements> FindEndorsements() {
                
      
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        ResultSet rst=null;
        List<endorsements> EnddorsementList = new ArrayList<endorsements>();
        try {
            String EndorsementQuery =
                "begin LMS_WEB_CURSOR_GRP.FindEndorsements(?,?);end;";

            String RenewalArea =
                (String)this.session.getAttribute("RenewalArea");
            
            if (postUnderwritingReinsurance().equals("Y")) {
                session.setAttribute("postReinsure","Y");
            }else{
              session.setAttribute("postReinsure","N");
            }
           // System.out.println("postReinsure"+postUnderwritingReinsurance());

            if (RenewalArea == null)
                EndorsementQuery =
                        "begin LMS_WEB_CURSOR_GRP.FindEndorsements(?,?);end;";
            else if (RenewalArea.equalsIgnoreCase("Y"))
                EndorsementQuery =
                        "begin LMS_WEB_CURSOR_GRP.find_renendorsements(?,?);end;";
            else {
                EndorsementQuery =
                        "begin LMS_WEB_CURSOR_GRP.FindEndorsements(?,?);end;";
            }

            cst = conn.prepareCall(EndorsementQuery);
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setBigDecimal(2,
                              (BigDecimal)this.session.getAttribute("endorsementCode"));
            cst.execute();
            rst = (ResultSet)cst.getObject(1);
            while (rst.next()) {
                endorsements myProd = new endorsements();
                myProd.setENDR_NO(rst.getString(1));
                myProd.setENDR_DURATION_TYPE(rst.getString(2));
                myProd.setENDR_STATUS(rst.getString(3));
                this.session.setAttribute("EndorsementStatus",
                                          rst.getString(3));
                myProd.setENDR_TOT_SA(rst.getBigDecimal(4));
                myProd.setENDR_TOT_PREMIUM(rst.getBigDecimal(5));
                myProd.setENDR_TYPE(rst.getString(6));
                this.session.setAttribute("endrValue", rst.getString(6));
                myProd.setENDR_PAY_METHOD(rst.getString(7));
                myProd.setENDR_EFFECTIVE_DATE(rst.getDate(8));
                myProd.setENDR_PREV_SA(rst.getBigDecimal(9));
                myProd.setENDR_PREV_PREM(rst.getBigDecimal(10));
                myProd.setAGENT_DISPLAY(rst.getString(11));
                myProd.setENDR_FREQ_OF_PAYMENT(rst.getString(12));
                myProd.setENDR_COVER_TO_DATE(rst.getDate(13));
                myProd.setENDR_ADD_REF_PREM(rst.getBigDecimal(14));
                myProd.setENDR_MALE_NRD(rst.getBigDecimal(15));
                myProd.setMASK_DISPLAY(rst.getString(16));
                myProd.setCHECK_AGENT_DISPLAY(rst.getString(17));
                myProd.setENDR_CALC_TYPE(rst.getString(18));

                this.session.setAttribute("PolCalcType", rst.getString(18));
                myProd.setENDR_ADD_REF_PERC_VARIANCE(rst.getBigDecimal(19));
                myProd.setENDR_FEMALE_NRD(rst.getBigDecimal(20));
                myProd.setENDR_COMM_RATE(rst.getBigDecimal(21));
                myProd.setENDR_CHECKOFF_RATE(rst.getBigDecimal(22));
                myProd.setENDR_NOF_MEMBERS(rst.getBigDecimal(23));
                myProd.setENDR_INST_PREM(rst.getBigDecimal(24));
                this.session.setAttribute("instPrem", rst.getBigDecimal(24));
                myProd.setENDR_COMM_AMT(rst.getBigDecimal(25));
                myProd.setENDR_PENS_TYPE(rst.getString(26));
                myProd.setENDR_SCHEME_TYPE(rst.getString(27));
                this.session.setAttribute("pensSchemeType", rst.getString(27));
                myProd.setENDR_REG_NO(rst.getString(28));
                myProd.setENDR_REG_DATE(rst.getDate(29));
                myProd.setENDR_SCHEME_TRUSTEES(rst.getString(30));
                myProd.setENDR_PENS_ESC(rst.getBigDecimal(31));
                myProd.setENDR_EARN_ESCALATION(rst.getBigDecimal(32));
                myProd.setENDR_NSSF_INCLUDE(rst.getString(33));
                myProd.setENDR_NSSF_AMOUNT(rst.getBigDecimal(34));
                myProd.setENDR_PENS_TAX_COMPLIA(rst.getString(35));
                myProd.setENDR_GUARANT_PRD(rst.getBigDecimal(36));
                myProd.setENDR_PENS_PAY_FREQ(rst.getString(37));
                myProd.setENDR_CONTRIBTN_TYPE(rst.getString(38));
                myProd.setENDR_EMPYER_CONTR_RATE(rst.getBigDecimal(39));
                myProd.setENDR_EMPYEE_CONTR_RATE(rst.getBigDecimal(40));
                myProd.setENDR_PENS_ADMIN_FEE(rst.getBigDecimal(41));
                myProd.setENDR_EMPYR_PENS_BF(rst.getBigDecimal(42));
                myProd.setENDR_EMPYE_PENS_BF(rst.getBigDecimal(43));
                myProd.setENDR_TOT_PENS_BF(rst.getBigDecimal(44));
                myProd.setENDR_PENS_COMM_RATE(rst.getBigDecimal(45));
                myProd.setENDR_FNDING_RATE(rst.getBigDecimal(46));
                myProd.setPENSTYPE(rst.getString(47));
                myProd.setCONTRIBTYPE(rst.getString(48));
                myProd.setNSSF_INCL(rst.getString(49));
                myProd.setPAYFREQ(rst.getString(50));
                myProd.setENDR_UNIT_RATE_FORMULA(rst.getString(51));
                session.setAttribute("UNIT_RATE_FORMULA",rst.getString(51));
                myProd.setENDR_VAT_RATE(rst.getBigDecimal(52));
                myProd.setENDR_OV_COMM_RATE(rst.getBigDecimal(53));
                myProd.setFCL_CALC_TYPE(rst.getString(54));
                myProd.setENDR_FCL_AMT(rst.getBigDecimal(55));
                myProd.setENDR_OVERRIDE_FCL_AMT(rst.getBigDecimal(56));
                this.session.setAttribute("FCLTotalAmt",
                                          rst.getBigDecimal(56));

                this.session.setAttribute("EndorsementStatus",
                                          rst.getString(57));
                myProd.setENDR_TA_CODE(rst.getBigDecimal(58));

                this.session.setAttribute("TaCode", rst.getBigDecimal(58));
                myProd.setTA_DESC(rst.getString(59));
                myProd.setENDR_TOT_SCHEME_SA(rst.getBigDecimal(60));
                myProd.setEMPYER(rst.getBigDecimal(61));
                myProd.setEMPYEE(rst.getBigDecimal(62));
                myProd.setTOTAL_CONTR(rst.getBigDecimal(63));
                myProd.setSERVICE_PROVIDER(rst.getString(64));
                myProd.setEndrAnnType(rst.getString(65));
                myProd.setEndrAnnOption(rst.getString(66));
                myProd.setEndrAnnAmount(rst.getBigDecimal(67));
                myProd.setEndrAnnEscalation(rst.getString(68));
                myProd.setENDR_PENS_INT_RATE(rst.getBigDecimal(69));
                if (rst.getString(70) == null)
                    myProd.setENDR_FACRE_CEDING(false);
                else if (rst.getString(70).equalsIgnoreCase("Y"))
                    myProd.setENDR_FACRE_CEDING(true);
                else {
                    myProd.setENDR_FACRE_CEDING(false);
                }
                myProd.setENDR_FACRE_RATE_TYPE(rst.getString(71));
                this.session.setAttribute("facRateType", rst.getString(71));
                myProd.setEndrANN_INVEST_RATE(rst.getBigDecimal(72));
                myProd.setEndrANN_TERMINAL_PAYOUT_RATE(rst.getBigDecimal(73));
                myProd.setEndrANN_SCHEME_LEGAL_AGE(rst.getBigDecimal(74));
                myProd.setEndrANN_ADMIN_CHARGE(rst.getBigDecimal(75));
                myProd.setEndrANN_INVEST_INTR_RATE(rst.getBigDecimal(76));
                myProd.setEndrTOT_ANN_INVESTMENTS(rst.getBigDecimal(77));
                myProd.setEndrTOT_TERMINAL_BENEFITS(rst.getBigDecimal(78));
                myProd.setENDR_PENS_VAL_FREQUENCY(rst.getString(79));
                myProd.setENDR_COINSURANCE(rst.getString(80));
                this.session.setAttribute("CoinsPolicy", rst.getString(80));
                myProd.setENDR_COINSURE_LEADER(rst.getString(81));
                this.session.setAttribute("FollowerBusiness",
                                          rst.getString(81));
                myProd.setENDR_COVER_FROM_DATE(rst.getDate(82));
                this.session.setAttribute("reinsPmasCode",
                                          rst.getBigDecimal(83));
                myProd.setENDR_REIN_PMAS_CODE(rst.getBigDecimal(83));
                myProd.setENDR_REIN_PMAS_SHT_DESC(rst.getString(84));
                myProd.setENDR_FCL_CALC_TYPE(rst.getString(85));
                myProd.setENDR_DURATION_TERM_TYPE(rst.getString(86));
                myProd.setEndr_pens_mode(rst.getString(87));
                myProd.setENDR_COIN_FAC_SHARE(rst.getBigDecimal(88));
                myProd.setEndr_mktr_agn_code(rst.getBigDecimal(89));
                myProd.setMarketer(rst.getString(90));
                myProd.setEndr_emplyr_volu_contr(rst.getBigDecimal(91));
                myProd.setEndr_emplye_volu_contr(rst.getBigDecimal(92));
                if (rst.getString(93) == null) {
                    myProd.setEndr_joint_agents(false);
                } else if (rst.getString(93).equalsIgnoreCase("Y")) {
                    myProd.setEndr_joint_agents(true);
                } else {
                    myProd.setEndr_joint_agents(false);
                }
                myProd.setEndr_agen_share(rst.getBigDecimal(94));
                myProd.setENDR_UMBRELLA_DURATION(rst.getString(95));
                myProd.setEndr_pmas_code(rst.getBigDecimal(96));
                session.setAttribute("pmasCode", rst.getBigDecimal(96));
                myProd.setEndr_pmas_sht_desc(rst.getString(97));
                session.setAttribute("pmasShtDesc", rst.getString(97));
                myProd.setTotal_coin_prem(rst.getBigDecimal(98));
                myProd.setTotal_coin_sa(rst.getBigDecimal(99));
                myProd.setENDR_LOSS_RATIO(rst.getBigDecimal(100));
                myProd.setENDR_AVG_ANB(rst.getBigDecimal(101));
                myProd.setENDR_HIST_PENS_INT_RATE(rst.getBigDecimal(102));
                myProd.setENDR_SINGLE_GROSS_RATE(rst.getString(103));
                session.setAttribute("EndorseRIAuth", rst.getString(104));
                myProd.setENDR_TOT_CLAIM_PAID(rst.getBigDecimal(105));
                myProd.setENDR_TOT_PREM_PAID(rst.getBigDecimal(106));
                session.setAttribute("SystemPoint","U");
                myProd.setEarnPrdType(rst.getString(107));
                myProd.setSBU_CODE(rst.getBigDecimal(108));
                session.setAttribute("sbuCode",rst.getBigDecimal(108));
                myProd.setSPOKE_CODE(rst.getBigDecimal(109));
                session.setAttribute("spokeCode",rst.getBigDecimal(109));
                myProd.setCOVERAGE_AREA_CODE(rst.getBigDecimal(110));
                session.setAttribute("coverageAreaCode",rst.getBigDecimal(110));
                myProd.setLOCATION_CODE(rst.getBigDecimal(111));
                session.setAttribute("locationCode",rst.getBigDecimal(111));
                myProd.setCOVERAGE_AREA(rst.getString(112));
                myProd.setLOCATION(rst.getString(113));
                EnddorsementList.add(myProd);
            }

            rst.close();
            cst.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }finally{
        GlobalCC.CloseConnections(rst, cst, conn);
        }

        return EnddorsementList;
    }

    public List<endorsements> FindFreeAdjLimits() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        ResultSet rst=null;
        List<endorsements> EnddorsementList = new ArrayList<endorsements>();
        try {
            String EndorsementQuery =
                "begin LMS_WEB_CURSOR_GRP.getFreeSchAdjLimits(?,?);end;";
            cst = conn.prepareCall(EndorsementQuery);
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setBigDecimal(2,
                              (BigDecimal)this.session.getAttribute("policyCode"));
            cst.execute();
            rst = (ResultSet)cst.getObject(1);
            while (rst.next()) {
                endorsements myProd = new endorsements();

                myProd.setFCL_ENDR_CODE(rst.getBigDecimal(1));
                myProd.setFCL_ENDR_POL_POLICY_NO(rst.getString(2));
                myProd.setFCL_ENDR_NO(rst.getString(3));
                myProd.setFCL_ENDR_TYPE(rst.getString(4));
                myProd.setFCL_ENDR_FCL_DATE(rst.getDate(5));
                myProd.setFCL_ENDR_FCL_AMT(rst.getString(6));

                EnddorsementList.add(myProd);
            }

            rst.close();
            cst.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }finally{
        GlobalCC.CloseConnections(rst, cst, conn);
        }

        return EnddorsementList;
    }

    public List<endorsements> FindPendingTransactions() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        ResultSet rst=null;
        List<endorsements> EnddorsementList = new ArrayList<endorsements>();
        try {
            String EndorsementQuery =
                "begin LMS_WEB_CURSOR_GRP.getPendingTransDtls(?,?);end;";
            cst = conn.prepareCall(EndorsementQuery);
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setBigDecimal(2,
                              (BigDecimal)this.session.getAttribute("policyCode"));
            cst.execute();
            rst = (ResultSet)cst.getObject(1);
            while (rst.next()) {
                endorsements myProd = new endorsements();

                myProd.setPT_ENDR_CODE(rst.getBigDecimal(1));
                myProd.setPT_ENDR_NO(rst.getString(2));
                myProd.setPT_ENDR_POL_POLICY_NO(rst.getString(3));
                myProd.setPT_client(rst.getString(4));
                myProd.setPT_AgentName(rst.getString(5));
                myProd.setPT_ENDR_STATUS(rst.getString(6));
                myProd.setPT_ENDR_EFFECTIVE_DATE(rst.getDate(7));
                myProd.setPT_ENDR_LTR_TRANS_NO(rst.getBigDecimal(8));
                myProd.setBTR_TRANS_TYPE(rst.getString(9));

                EnddorsementList.add(myProd);
            }

            rst.close();
            cst.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }finally{
        GlobalCC.CloseConnections(rst, cst, conn);
        }

        return EnddorsementList;
    }

    public List<endorsements> FindReuseTransactions() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        ResultSet rst=null;
        List<endorsements> EnddorsementList = new ArrayList<endorsements>();
        try {
            String EndorsementQuery =
                "begin LMS_WEB_CURSOR_GRP.reuse_policies(?,?);end;";
            cst = conn.prepareCall(EndorsementQuery);
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setBigDecimal(2,
                              (BigDecimal)this.session.getAttribute("ProductCode"));
            cst.execute();
            rst = (ResultSet)cst.getObject(1);
            while (rst.next()) {
                endorsements myProd = new endorsements();

                myProd.setPOL_CODE(rst.getBigDecimal(1));
                myProd.setPOL_POLICY_NO(rst.getString(2));
                myProd.setCLIENT(rst.getString(3));
                myProd.setPOL_INCEPTION_UWYR(rst.getString(4));
                myProd.setPOL_STATUS(rst.getString(5));

                EnddorsementList.add(myProd);
            }

            rst.close();
            cst.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        finally{
        GlobalCC.CloseConnections(rst, cst, conn);
        }
        return EnddorsementList;
    }

    public List<endorsements> FindOldTransactions() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        ResultSet rst=null;
        List<endorsements> EnddorsementList = new ArrayList<endorsements>();
        try {
            String EndorsementQuery =
                "begin LMS_WEB_CURSOR_GRP.old_transactions(?,?);end;";
            cst = conn.prepareCall(EndorsementQuery);
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setBigDecimal(2,
                              (BigDecimal)this.session.getAttribute("policyCode"));
            cst.execute();
            rst = (ResultSet)cst.getObject(1);
            while (rst.next()) {
                endorsements myProd = new endorsements();

                myProd.setENDR_CODE(rst.getBigDecimal(1));
                myProd.setENDR_LTR_TRANS_NO(rst.getString(2));
                myProd.setENDR_TYPE(rst.getString(3));
                myProd.setENDR_DATE(rst.getDate(4));
                myProd.setENDR_POL_POLICY_NO(rst.getString(5));
                myProd.setENDR_NO(rst.getString(6));
                myProd.setTRANS(rst.getString(7));

                EnddorsementList.add(myProd);
            }

            rst.close();
            cst.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }finally{
        GlobalCC.CloseConnections(rst, cst, conn);
        }
        return EnddorsementList;
    }

    public List<endorsements> FindGovernmentAuthorities() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        ResultSet rst=null;
        List<endorsements> EnddorsementList = new ArrayList<endorsements>();
        try {
            String EndorsementQuery =
                "begin LMS_WEB_CURSOR_GRP.find_govt_authorities(?,?);end;";
            cst = conn.prepareCall(EndorsementQuery);
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setBigDecimal(2,
                              (BigDecimal)this.session.getAttribute("endorsementCode"));
            cst.execute();
            rst = (ResultSet)cst.getObject(1);
            while (rst.next()) {
                endorsements myProd = new endorsements();

                myProd.setLGA_CODE(rst.getBigDecimal(1));
                myProd.setLGA_AGN_CODE(rst.getBigDecimal(2));
                myProd.setAGN_NAME(rst.getString(3));
                myProd.setLGA_REMARKS(rst.getString(4));
                myProd.setLGA_START_DATE(rst.getDate(5));
                myProd.setLGA_VAL_FREQ(rst.getString(6));

                EnddorsementList.add(myProd);
            }

            rst.close();
            cst.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }finally{
        GlobalCC.CloseConnections(rst, cst, conn);
        }
        return EnddorsementList;
    }

    public List<endorsements> FindPrevAuthTransactions() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        ResultSet rst=null;
        List<endorsements> EnddorsementList = new ArrayList<endorsements>();
        try {
            String EndorsementQuery =
                "begin LMS_WEB_CURSOR_GRP.previous_auth_transactions(?,?);end;";
            cst = conn.prepareCall(EndorsementQuery);
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setBigDecimal(2,
                              (BigDecimal)this.session.getAttribute("policyCode"));
            cst.execute();
            rst = (ResultSet)cst.getObject(1);
            while (rst.next()) {
                endorsements myProd = new endorsements();

                myProd.setENDR_CODE(rst.getBigDecimal(1));
                myProd.setENDR_LTR_TRANS_NO(rst.getString(2));
                myProd.setENDR_TYPE(rst.getString(3));
                myProd.setENDR_DATE(rst.getDate(4));
                myProd.setENDR_POL_POLICY_NO(rst.getString(5));
                myProd.setENDR_NO(rst.getString(6));
                myProd.setTRANS(rst.getString(7));

                EnddorsementList.add(myProd);
            }

            rst.close();
            cst.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }finally{
        GlobalCC.CloseConnections(rst, cst, conn);
        }
        return EnddorsementList;
    }

    public List<endorsements> FindEndorsementJointAgents() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        ResultSet rst=null;
        List<endorsements> EnddorsementList = new ArrayList<endorsements>();
        try {
            String EndorsementQuery =
                "begin LMS_WEB_CURSOR_GRP.find_joint_agents(?,?);end;";
            cst = conn.prepareCall(EndorsementQuery);
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setBigDecimal(2,
                              (BigDecimal)this.session.getAttribute("endorsementCode"));
            cst.execute();
            rst = (ResultSet)cst.getObject(1);
            while (rst.next()) {
                endorsements myProd = new endorsements();

                myProd.setJoi_code(rst.getBigDecimal(1));
                myProd.setJoi_agn_code(rst.getBigDecimal(2));
                myProd.setAgn_name(rst.getString(3));
                myProd.setJoi_sub_agent_share(rst.getBigDecimal(4));

                EnddorsementList.add(myProd);
            }

            rst.close();
            cst.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }finally{
        GlobalCC.CloseConnections(rst, cst, conn);
        }
        return EnddorsementList;
    }

    public List<endorsements> findPolicySubdivisions() {

        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        ResultSet rs=null;
        List<endorsements> myendorsements = new ArrayList<endorsements>();

        try {
            String provQuery =
                "BEGIN LMS_WEB_CURSOR_GRP.find_policy_subdivisons(?,?);END;";
            cst = conn.prepareCall(provQuery);
            cst.registerOutParameter(1, OracleTypes.CURSOR);

            cst.setBigDecimal(2,
                              (BigDecimal)session.getAttribute("endorsementCode"));

            cst.execute();
            rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {

                endorsements prov = new endorsements();

                prov.setPGSUB_CODE(rs.getBigDecimal(1));
                prov.setPGSUB_GSUB_CODE(rs.getBigDecimal(2));
                prov.setGSUB_DESC(rs.getString(3));
                prov.setPGSUB_SHT_DESC(rs.getString(4));
                prov.setPGSUB_DESC(rs.getString(5));

                myendorsements.add(prov);

            }
            rs.close();
            cst.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }finally{
        GlobalCC.CloseConnections(rs, cst, conn);
        }
        return myendorsements;
    }

    public List<endorsements> findPolicyMemberSubdivisions() {

        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        ResultSet rs=null;
        List<endorsements> myendorsements = new ArrayList<endorsements>();

        try {
            String provQuery =
                "BEGIN LMS_WEB_CURSOR_GRP.find_polmem_subdivisons(?,?,?);END;";
            cst = conn.prepareCall(provQuery);
            cst.registerOutParameter(1, OracleTypes.CURSOR);

            cst.setBigDecimal(2,
                              (BigDecimal)session.getAttribute("MemberNumber"));
            cst.setBigDecimal(3,
                              (BigDecimal)session.getAttribute("endorsementCode"));

            cst.execute();
            rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {

                endorsements prov = new endorsements();

                prov.setPGSUB_CODE(rs.getBigDecimal(1));
                prov.setPGSUB_GSUB_CODE(rs.getBigDecimal(2));
                prov.setGSUB_DESC(rs.getString(3));
                prov.setPGSUB_SHT_DESC(rs.getString(4));
                prov.setPGSUB_DESC(rs.getString(5));
                prov.setPMEMS_CODE(rs.getBigDecimal(6));


                myendorsements.add(prov);

            }
            rs.close();
            cst.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }finally{
        GlobalCC.CloseConnections(rs, cst, conn);
        }
        return myendorsements;
    }

    public List<endorsements> FindPensionTrustees() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        ResultSet rst=null;
        List<endorsements> EnddorsementList = new ArrayList<endorsements>();
        try {
            String EndorsementQuery =
                "begin LMS_WEB_CURSOR_GRP.find_pension_trustees(?,?);end;";
            cst = conn.prepareCall(EndorsementQuery);
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setBigDecimal(2,
                              (BigDecimal)session.getAttribute("endorsementCode"));
            cst.execute();
            rst = (ResultSet)cst.getObject(1);
            while (rst.next()) {
                endorsements myProd = new endorsements();

                myProd.setLPT_CODE(rst.getBigDecimal(1));
                myProd.setTRUSTEE_NAME(rst.getString(2));
                myProd.setLPT_STATUS(rst.getString(3));
                myProd.setLPT_REPRESENTATION(rst.getString(4));
                myProd.setLPT_TEL_NO(rst.getString(5));
                myProd.setLPT_PIN_NO(rst.getString(6));
                myProd.setLPT_ID_NO(rst.getString(7));
                myProd.setLPT_CERT_NO(rst.getString(8));
                myProd.setLPT_WEF_DATE(rst.getDate(9));
                myProd.setLPT_WET_DATE(rst.getDate(10));
                myProd.setLPT_REN_DATE(rst.getDate(11));
                myProd.setLPT_ADDRESS(rst.getString(12));
                myProd.setLPT_PHYSICAL_ADDR(rst.getString(13));
                myProd.setLPT_SURNAME(rst.getString(14));
                myProd.setLPT_OTHER_NAMES(rst.getString(15));
                myProd.setSTATUS(rst.getString(16));
                myProd.setLPT_REMOVED(rst.getString(17));
                myProd.setLPT_REMOVED_DATE(rst.getDate(18));
                myProd.setLPT_REMOVED_BY(rst.getString(19));
                myProd.setLPT_REMOVED_ENDR_CODE(rst.getString(20));
                myProd.setLPT_REMOVED_WEF(rst.getDate(21));
                EnddorsementList.add(myProd);
            }

            rst.close();
            cst.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }finally{
        GlobalCC.CloseConnections(rst, cst, conn);
        }

        return EnddorsementList;
    }

    public String postUnderwritingReinsurance() {
        String postUndReinsStat = "N";
        Connection conn = null;
        CallableStatement cst = null;
        String paramValue = "BEGIN lms_ord_misc.system_param_val(?,?);END;";
        conn = new DBConnector().getDatabaseConn();

        try {
            cst = conn.prepareCall(paramValue);
            cst.setString(1, "REINSURANCE_OUTSIDE_UNDERWRITING");
            cst.registerOutParameter(2,
                                     oracle.jdbc.internal.OracleTypes.VARCHAR);
            cst.execute();
            postUndReinsStat = cst.getString(2);

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }finally{
        GlobalCC.CloseConnections(null, cst, conn);
        }
        return postUndReinsStat;
    }
  public List<endorsements> FindPolicyRemarks() {
      DBConnector myConn = new DBConnector();
      Connection conn = myConn.getDatabaseConn();
      CallableStatement cst = null;
      ResultSet rst=null; 
      List<endorsements> polRemarks = new ArrayList<endorsements>();
      try {
          String policyRemarks =
              "begin LMS_WEB_CURSOR_GRP.findPolRemarks(?,?);end;";
          cst = conn.prepareCall(policyRemarks);          
          cst.setBigDecimal(1,
                            (BigDecimal)session.getAttribute("endorsementCode"));
         cst.registerOutParameter(2, OracleTypes.CURSOR);
          cst.execute();
          rst = (ResultSet)cst.getObject(2);
          while (rst.next()) {
              endorsements remarks= new endorsements();
              remarks.setPRM_CODE(rst.getBigDecimal(1));
              remarks.setPRM_REMARKS(rst.getString(2));
              remarks.setPRM_REMARK_TYPE(rst.getString(3));
              remarks.setPRM_REMARKS_BY(rst.getString(4));           
              remarks.setPRM_REMARKS_DATE(rst.getDate(5));
              
            if(rst.getString(3).equals("O"))
                remarks.setREMARKS_DESC("Observation");
            else
              remarks.setREMARKS_DESC("Recommendation");
              
              polRemarks.add(remarks);
          }

          rst.close();
          cst.close();
          conn.close();
      } catch (Exception e) {
          GlobalCC.EXCEPTIONREPORTING(conn, e);
          e.printStackTrace();
      }finally{
      GlobalCC.CloseConnections(rst, cst, conn);
      }

      return polRemarks;
  }
  public List<Settings> FindSBUDetails() {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    ResultSet rst = null;

    List<Settings> SettingsList = new ArrayList<Settings>();


    try {

      String SBUQuery = "BEGIN LMS_SETUPS_CURSOR.getSBUDetails(?);END;";
      cst = conn.prepareCall(SBUQuery);
      cst.registerOutParameter(1, OracleTypes.CURSOR);

      cst.execute();
      rst = (ResultSet)cst.getObject(1);
      while (rst.next()) {
        Settings mySettings = new Settings();
         
        mySettings.setCOVERAGE_AREA(rst.getString(1));
        mySettings.setSPOKE(rst.getString(2));
        mySettings.setSBU(rst.getString(3));
        mySettings.setCOVERAGE_AREA_CODE(rst.getBigDecimal(4));
        mySettings.setSPOKE_CODE(rst.getBigDecimal(5));
        mySettings.setSBU_CODE(rst.getBigDecimal(6));
       
        SettingsList.add(mySettings);

      }
      rst.close();
      cst.close();
      conn.close();

    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    } finally {
      GlobalCC.CloseConnections(rst, cst, conn);
    }
    return SettingsList;
  }
  public List<Settings> FindOrgLocationsDetails() {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    ResultSet rst = null;

    List<Settings> SettingsList = new ArrayList<Settings>();


    try {

      String LOCQuery = "BEGIN LMS_SETUPS_CURSOR.getOrgLocationsDetails(?);END;";
      cst = conn.prepareCall(LOCQuery);
      cst.registerOutParameter(1, OracleTypes.CURSOR);

      cst.execute();
      rst = (ResultSet)cst.getObject(1);
      while (rst.next()) {
        Settings mySettings = new Settings();
         
        mySettings.setLOCATION(rst.getString(1));
        mySettings.setORGANIZATION(rst.getString(2));
        mySettings.setLOCATION_CODE(rst.getBigDecimal(3));             
        SettingsList.add(mySettings);

      }
      rst.close();
      cst.close();
      conn.close();

    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    } finally {
      GlobalCC.CloseConnections(rst, cst, conn);
    }
    return SettingsList;
  }

}
