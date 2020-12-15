package LMSG.view.Claims;

import LMSG.view.Base.GlobalCC;
import LMSG.view.Base.LOVCC;
import LMSG.view.connect.DBConnector;

import java.io.PrintStream;

import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import oracle.jdbc.OracleTypes;

public class ClaimsDAO extends LOVCC {
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    private BigDecimal deathDisabilityCode;

    public List<Claim> FindMembersByTransactions() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        List<Claim> ClaimList = new ArrayList();
        ResultSet rst = null;
        try {
            String polQuery =
                "begin LMS_WEB_CURSOR_GRP.findpolicymembersbyTrans(?,?,?,?,?,?);end;";
            cst = conn.prepareCall(polQuery);
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setBigDecimal(2,
                              (BigDecimal)this.session.getAttribute("policyCode"));
            cst.setString(3,
                          (String)this.session.getAttribute("ClaimTransactionType"));
            cst.setString(4, (String)this.session.getAttribute("srchMemNo"));
            cst.setString(5, (String)this.session.getAttribute("srchMemName"));
            cst.setInt(6, 1000);

            cst.execute();
            rst = (ResultSet)cst.getObject(1);
            int i = 0;
            this.session.setAttribute("limitExceeded", "N");
            while (rst.next()) {
                Claim myClaims = new Claim();


                myClaims.setPOLM_CODE(rst.getBigDecimal(1));
                myClaims.setPolm_mem_no(rst.getString(2));
                myClaims.setClient(rst.getString(3));
                myClaims.setMEM_CODE(rst.getBigDecimal(10));

                i++;
                if (i >= 1000) {
                    this.session.setAttribute("limitExceeded", "Y");
                }
                ClaimList.add(myClaims);
            }
            rst.close();
            cst.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(rst, cst, conn);
        }
        return ClaimList;
    }

    public List<Claim> FindExgratiaMembersByTransactions() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        List<Claim> ClaimList = new ArrayList();
        ResultSet rst = null;
        try {
            String polQuery =
                "begin LMS_WEB_CURSOR_GRP.findexgr_policymembersbytrans(?,?,?);end;";
            cst = conn.prepareCall(polQuery);
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setBigDecimal(2,
                              (BigDecimal)this.session.getAttribute("policyCode"));
            cst.setString(3,
                          (String)this.session.getAttribute("ClaimTransactionType"));

            cst.execute();
            rst = (ResultSet)cst.getObject(1);
            while (rst.next()) {
                Claim myClaims = new Claim();


                myClaims.setPOLM_CODE(rst.getBigDecimal(1));
                myClaims.setMEM_CODE(rst.getBigDecimal(2));
                myClaims.setPolm_mem_no(rst.getString(3));
                myClaims.setMEM_SURNAME(rst.getString(4));
                myClaims.setMEM_OTHER_NAMES(rst.getString(5));
                myClaims.setMEM_IDENTITY_NO(rst.getString(6));
                myClaims.setMEM_DOB(rst.getDate(7));
                myClaims.setMEM_SEX(rst.getString(8));
                myClaims.setMEM_SCHEDULE_JOIN_DATE(rst.getDate(9));

                ClaimList.add(myClaims);
            }
            rst.close();
            cst.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(rst, cst, conn);
        }
        return ClaimList;
    }

    public List<Claim> findPendingClaimTransactions() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();

        CallableStatement cst = null;
        List<Claim> claims = new ArrayList();
        ResultSet rs = null;
        try {
            String clmVoucherQuery =
                "begin LMS_WEB_CURSOR_GRP.find_pending_clm_trans(?,?,?,?,?); end;";

            cst = conn.prepareCall(clmVoucherQuery);


            cst.registerOutParameter(1, OracleTypes.CURSOR);


            cst.setBigDecimal(2,
                              (BigDecimal)this.session.getAttribute("policyCode"));
            cst.setBigDecimal(3,
                              (BigDecimal)this.session.getAttribute("PolmCode"));
            cst.setString(4,
                          (String)this.session.getAttribute("ClaimTransactionType"));
            cst.setBigDecimal(5,
                              (BigDecimal)this.session.getAttribute("CPVoucher"));


            cst.execute();
            rs = (ResultSet)cst.getObject(1);
            this.session.setAttribute("pendingClaim", "N");
            while (rs.next()) {
                Claim claim = new Claim();

                claim.setLTR_CLM_NO(rs.getString(1));
                claim.setLTR_TRANS_NO(rs.getBigDecimal(2));
                claim.setMEMBERNAME(rs.getString(3));
                claim.setLTR_BTR_TRANS_CODE(rs.getString(4));
                claim.setLTR_EFFECTIVE_DATE(rs.getDate(5));
                this.session.setAttribute("pendingClaim", "Y");
                claims.add(claim);
            }
            rs.close();
            cst.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(rs, cst, conn);
        }
        return claims;
    }

    public List<Claim> FindCausationCauses() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        List<Claim> ClaimList = new ArrayList();
        ResultSet rst = null;
        try {
            String polQuery =
                "begin LMS_WEB_CURSOR_GRP.getcausations_causes(?,?);end;";
            cst = conn.prepareCall(polQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setBigDecimal(2,
                              (BigDecimal)this.session.getAttribute("CausationCode"));

            cst.execute();
            rst = (ResultSet)cst.getObject(1);
            while (rst.next()) {
                Claim myClaims = new Claim();

                myClaims.setCSC_CODE(rst.getBigDecimal(1));
                myClaims.setDDC_CODE(rst.getBigDecimal(2));
                myClaims.setDDC_SHT_DESC(rst.getString(3));
                myClaims.setDDC_DESC(rst.getString(4));

                ClaimList.add(myClaims);
            }
            rst.close();
            cst.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(rst, cst, conn);
        }
        return ClaimList;
    }

    public List<Claim> FindCausations() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        List<Claim> ClaimList = new ArrayList();
        ResultSet rst = null;
        try {
            String polQuery =
                "begin LMS_WEB_CURSOR_GRP.getcausations(?,?);end;";
            cst = conn.prepareCall(polQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            BigDecimal Prod =
                (BigDecimal)this.session.getAttribute("ProductCode");
            if (Prod == null) {
                cst.setString(2, null);
            } else {
                cst.setBigDecimal(2,
                                  (BigDecimal)this.session.getAttribute("ProductCode"));
            }
            cst.execute();
            rst = (ResultSet)cst.getObject(1);
            while (rst.next()) {
                Claim myClaims = new Claim();

                myClaims.setCAUS_CODE(rst.getBigDecimal(1));
                myClaims.setCAUS_SHT_DESC(rst.getString(2));
                myClaims.setCAUS_DESC(rst.getString(3));
                myClaims.setCAUS_TYPE(rst.getString(4));

                ClaimList.add(myClaims);
            }
            rst.close();
            cst.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(rst, cst, conn);
        }
        return ClaimList;
    }

    public List<Claim> FindClaimFacilitators() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        List<Claim> ClaimList = new ArrayList();
        ResultSet rst = null;
        try {
            String polQuery =
                "begin LMS_WEB_CURSOR_GRP.getClaimActivities(?,?);end;";
            cst = conn.prepareCall(polQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setString(2, (String)this.session.getAttribute("ClaimNo"));

            cst.execute();
            rst = (ResultSet)cst.getObject(1);
            while (rst.next()) {
                Claim myClaims = new Claim();

                myClaims.setCFA_CODE(rst.getBigDecimal(1));
                myClaims.setACT_ACTIVITY(rst.getString(2));
                myClaims.setCFA_FEE(rst.getString(3));
                myClaims.setCFA_PAY_DATE(rst.getString(4));
                myClaims.setCFA_REMARKS(rst.getString(5));
                myClaims.setCFA_PAID(rst.getString(6));

                ClaimList.add(myClaims);
            }
            rst.close();
            cst.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(rst, cst, conn);
        }
        return ClaimList;
    }

    public List<Claim> FindClaimDocuments() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        List<Claim> ClaimList = new ArrayList();
        ResultSet rst = null;
        try {
            String polQuery =
                "begin LMS_WEB_CURSOR_GRP.getclaim_docs(?,?);end;";
            cst = conn.prepareCall(polQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setString(2, (String)this.session.getAttribute("ClaimNo"));

            cst.execute();
            rst = (ResultSet)cst.getObject(1);
            while (rst.next()) {
                Claim myClaims = new Claim();


                myClaims.setRD_DESC(rst.getString(1));
                myClaims.setMCD_RD_SHT_DESC(rst.getString(2));
                myClaims.setMCD_IS_DOC_SUBMITTED(rst.getString(3));
                String Doc = rst.getString(3);
                if (Doc.equalsIgnoreCase("N")) {
                    this.session.setAttribute("DocSubmitted",
                                              rst.getString(3));
                }
                myClaims.setMCD_DATE_GIVEN1(rst.getDate(4));
                myClaims.setMCD_DOC_NO(rst.getString(5));
                myClaims.setMCD_CODE(rst.getBigDecimal(6));

                ClaimList.add(myClaims);
            }
            rst.close();
            cst.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(rst, cst, conn);
        }
        return ClaimList;
    }

    public List<Claim> FindMaturityDocuments() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        List<Claim> ClaimList = new ArrayList();
        ResultSet rst = null;
        try {
            String polQuery =
                "begin LMS_WEB_CURSOR_GRP.getmaturity_docs(?,?,?);end;";
            cst = conn.prepareCall(polQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setString(2, (String)this.session.getAttribute("ClaimNo"));
            cst.setBigDecimal(3,
                              (BigDecimal)this.session.getAttribute("pcyCode"));

            cst.execute();
            rst = (ResultSet)cst.getObject(1);
            while (rst.next()) {
                Claim myClaims = new Claim();

                myClaims.setRD_DESC(rst.getString(1));
                myClaims.setMCD_RD_SHT_DESC(rst.getString(2));
                myClaims.setMCD_IS_DOC_SUBMITTED(rst.getString(3));
                String Doc = rst.getString(3);
                if (Doc.equalsIgnoreCase("N")) {
                    this.session.setAttribute("DocSubmitted",
                                              rst.getString(3));
                }
                myClaims.setMCD_DATE_GIVEN1(rst.getDate(4));
                myClaims.setMCD_DOC_NO(rst.getString(5));
                myClaims.setMCD_CODE(rst.getBigDecimal(6));
                ClaimList.add(myClaims);
            }
            rst.close();
            cst.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(rst, cst, conn);
        }
        return ClaimList;
    }

    public List<Claim> FindClaimTreatyCessions() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        List<Claim> ClaimList = new ArrayList();
        ResultSet rst = null;
        try {
            String polQuery =
                "begin LMS_WEB_CURSOR_GRP.getclm_trt_cessions(?,?);end;";
            cst = conn.prepareCall(polQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setString(2, (String)this.session.getAttribute("ClaimNo"));

            cst.execute();
            rst = (ResultSet)cst.getObject(1);
            while (rst.next()) {
                Claim myClaims = new Claim();

                myClaims.setCTRTC_CODE(rst.getBigDecimal(1));
                myClaims.setREI_TRT_SHT_DESC(rst.getString(2));
                myClaims.setCTRTC_RATE(rst.getString(3));


                ClaimList.add(myClaims);
            }
            rst.close();
            cst.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(rst, cst, conn);
        }
        return ClaimList;
    }

    public List<Claim> FindClaimRITreatyCessions() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        List<Claim> ClaimList = new ArrayList();
        ResultSet rst = null;
        try {
            String polQuery =
                "begin LMS_WEB_CURSOR_GRP.getclm_ritrt_cessions(?,?);end;";
            cst = conn.prepareCall(polQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setString(2, (String)this.session.getAttribute("ClaimNo"));

            cst.execute();
            rst = (ResultSet)cst.getObject(1);
            while (rst.next()) {
                Claim myClaims = new Claim();

                myClaims.setCTRCC_CODE(rst.getBigDecimal(1));
                myClaims.setCTRCC_AGN_NAME(rst.getString(2));
                myClaims.setCTRCC_REI_TRT_SHT_DESC(rst.getString(3));
                myClaims.setCTRCC_CEDE_RATE(rst.getString(4));


                ClaimList.add(myClaims);
            }
            rst.close();
            cst.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(rst, cst, conn);
        }
        return ClaimList;
    }

    public List<Claim> FindClaimTransactions() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        List<Claim> ClaimList = new ArrayList();
        ResultSet rst = null;
        try {
            String polQuery =
                "begin LMS_WEB_CURSOR_GRP.getclaimsbypol(?,?,?,?,?,?,?);end;";
            cst = conn.prepareCall(polQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setBigDecimal(2,
                              (BigDecimal)this.session.getAttribute("ProductCode"));
            cst.setString(3, (String)this.session.getAttribute("claimStatus"));
            cst.setBigDecimal(4,
                              (BigDecimal)this.session.getAttribute("policyCode"));
            cst.setString(5, (String)this.session.getAttribute("ClaimSearch"));
            cst.setString(6, (String)this.session.getAttribute("memNoSearch"));
            cst.setString(7,
                          (String)this.session.getAttribute("memNameSearch"));
            cst.execute();
            rst = (ResultSet)cst.getObject(1);
            while (rst.next()) {
                Claim myClaims = new Claim();

                myClaims.setLTR_CLM_NO(rst.getString(1));
                myClaims.setLTR_CLIENT(rst.getString(2));
                myClaims.setLTR_POL_POLICY_NO(rst.getString(3));
                myClaims.setLTR_MEMBER_DISP(rst.getString(4));
                myClaims.setLTR_TRANS_NO(rst.getBigDecimal(5));
                myClaims.setLTR_BTR_TRANS_CODE(rst.getString(6));
                this.session.setAttribute("LTR_BTR_TRANS_CODE",
                                          rst.getString(6));
                myClaims.setLTR_MEM_NO(rst.getString(7));
                myClaims.setLTR_MEM_CODE(rst.getBigDecimal(8));
                myClaims.setLTR_CLM_CAUS_TYPE(rst.getString(9));
                myClaims.setLTR_POLM_CODE(rst.getBigDecimal(10));
                myClaims.setPOL_CODE(rst.getBigDecimal(12));
                myClaims.setPRP_CODE(rst.getBigDecimal(13));
                myClaims.setPRP_CLNT_CODE(rst.getBigDecimal(14));
                myClaims.setCLM_BATCH_NO(rst.getBigDecimal(15));
                myClaims.setAGN_NAME(rst.getString(16));

                System.out.println("myBatchNo is " + rst.getBigDecimal(12));
                ClaimList.add(myClaims);
            }
            rst.close();
            cst.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(rst, cst, conn);
        }
        return ClaimList;
    }

    public List<Claim> FindClaimForReopenContra() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        List<Claim> ClaimList = new ArrayList();
        ResultSet rst = null;
        try {
            String polQuery =
                "begin LMS_WEB_CURSOR_GRP.getreopen_cntra_clms(?,?);end;";
            cst = conn.prepareCall(polQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            BigDecimal Prod =
                (BigDecimal)this.session.getAttribute("ProductCode");
            if (Prod == null) {
                cst.setString(2, null);
            } else {
                cst.setBigDecimal(2,
                                  (BigDecimal)this.session.getAttribute("ProductCode"));
            }
            cst.execute();
            rst = (ResultSet)cst.getObject(1);
            while (rst.next()) {
                Claim myClaims = new Claim();

                myClaims.setRC_CLM_NO(rst.getString(1));
                myClaims.setRC_POL_POLICY_NO(rst.getString(2));
                myClaims.setRC_MEM_DISPL(rst.getString(3));
                myClaims.setRC_POL_CODE(rst.getBigDecimal(4));
                myClaims.setRC_CLM_POLM_CODE(rst.getBigDecimal(5));
                myClaims.setRC_CLM_MEM_CODE(rst.getBigDecimal(6));


                ClaimList.add(myClaims);
            }
            rst.close();
            cst.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(rst, cst, conn);
        }
        return ClaimList;
    }

    public List<Claim> FindClaimTransForReopenContra() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        List<Claim> ClaimList = new ArrayList();
        ResultSet rst = null;
        try {
            String polQuery =
                "begin LMS_WEB_CURSOR_GRP.getreopen_cntra_trans(?,?);end;";
            cst = conn.prepareCall(polQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setString(2, (String)this.session.getAttribute("ClaimNo"));

            cst.execute();
            rst = (ResultSet)cst.getObject(1);
            while (rst.next()) {
                Claim myClaims = new Claim();

                myClaims.setCPV_VOUCHER_NO(rst.getBigDecimal(1));
                myClaims.setCPV_AMOUNT(rst.getBigDecimal(2));
                myClaims.setCPV_PAYEE(rst.getString(3));
                myClaims.setCPV_DRCR_NO(rst.getString(4));


                ClaimList.add(myClaims);
            }
            rst.close();
            cst.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(rst, cst, conn);
        }
        return ClaimList;
    }

    public List<Claim> FindClaimCoverTypes() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        List<Claim> ClaimList = new ArrayList();
        ResultSet rst = null;
        try {
            String polQuery =
                "begin LMS_WEB_CURSOR_GRP.getclaim_covrtypes(?,?,?);end;";
            cst = conn.prepareCall(polQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setString(2, (String)this.session.getAttribute("ClaimNo"));
            cst.setBigDecimal(3,
                              (BigDecimal)this.session.getAttribute("CoverTypeCode"));

            cst.execute();
            rst = (ResultSet)cst.getObject(1);
            this.session.setAttribute("VoucherDecision", "No");
            while (rst.next()) {
                Claim myClaims = new Claim();

                myClaims.setCCVT_CODE(rst.getBigDecimal(1));
                myClaims.setCVT_DESC(rst.getString(2));
                myClaims.setCCVT_MULT_EARNINGS_PRD(rst.getString(3));
                myClaims.setCCVT_EARNINGS(rst.getBigDecimal(4));
                myClaims.setCCVT_SA(rst.getBigDecimal(5));
                myClaims.setCCVT_PAYABLE_AMT(rst.getBigDecimal(6));
                myClaims.setCCVT_AMT_CLAIMED(rst.getBigDecimal(7));
                myClaims.setCCVT_AMT_TO_BE_PAID(rst.getBigDecimal(8));
                myClaims.setCCVT_BUT_PAY_AMT(rst.getBigDecimal(9));
                myClaims.setCCVT_PAID_AMT(rst.getBigDecimal(10));
                myClaims.setCCVT_REMARKS(rst.getString(11));
                myClaims.setCCVT_PAID(rst.getString(12));
                myClaims.setCCVT_PAYEE(rst.getString(13));
                myClaims.setCCVT_PAY_ORGANIZATION(rst.getString(14));
                myClaims.setSelected(Boolean.valueOf(false));
                if (rst.getString(15).equalsIgnoreCase("Y")) {
                    myClaims.setCLM_PAY_TOT_COINS_AMT(rst.getString(15));
                    myClaims.setCLM_PAY_TOT_COINS_DISP("Yes");
                } else {
                    myClaims.setCLM_PAY_TOT_COINS_AMT(rst.getString(15));
                    myClaims.setCLM_PAY_TOT_COINS_DISP("No");
                }
                if (rst.getString(12) != null) {
                    if (rst.getString(12).equalsIgnoreCase("N")) {
                        this.session.setAttribute("VoucherDecision", "Yes");
                    }
                }
                myClaims.setCcvt_saving_amt(rst.getBigDecimal(16));
                myClaims.setCcvt_original_loan_amt(rst.getBigDecimal(17));
                myClaims.setCcvt_orig_loan_repayment_prd(rst.getBigDecimal(18));
                myClaims.setCcvt_pct_code(rst.getBigDecimal(19));
                myClaims.setCCVT_PAY_INST(rst.getBigDecimal(20));
                myClaims.setCCVT_INT_SAVING_AMT(rst.getBigDecimal(21));
                myClaims.setCCVT_CVT_OCC_BEN(rst.getString(22));
                myClaims.setCCVT_OCC_BEN_RATE(rst.getBigDecimal(23));

                ClaimList.add(myClaims);
            }
            rst.close();
            cst.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(rst, cst, conn);
        }
        return ClaimList;
    }

    public List<Claim> FindMultiClaimCoverTypes() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        List<Claim> ClaimList = new ArrayList();
        ResultSet rst = null;
        try {
            String polQuery =
                "begin LMS_WEB_CURSOR_GRP.getmulticlaim_covrtypes(?,?,?);end;";
            cst = conn.prepareCall(polQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setBigDecimal(2,
                              (BigDecimal)this.session.getAttribute("clmbatchNo"));
            cst.setString(3,
                          (String)this.session.getAttribute("multiple_claims"));
            cst.execute();
            rst = (ResultSet)cst.getObject(1);
            this.session.setAttribute("VoucherDecision", "No");
            while (rst.next()) {
                Claim myClaims = new Claim();

                myClaims.setCCVT_CODE(rst.getBigDecimal(1));
                myClaims.setCVT_DESC(rst.getString(2));
                myClaims.setCCVT_MULT_EARNINGS_PRD(rst.getString(3));
                myClaims.setCCVT_EARNINGS(rst.getBigDecimal(4));
                myClaims.setCCVT_SA(rst.getBigDecimal(5));
                myClaims.setCCVT_PAYABLE_AMT(rst.getBigDecimal(6));
                myClaims.setCCVT_AMT_CLAIMED(rst.getBigDecimal(7));
                myClaims.setCCVT_AMT_TO_BE_PAID(rst.getBigDecimal(8));
                myClaims.setCCVT_BUT_PAY_AMT(rst.getBigDecimal(9));
                myClaims.setCCVT_PAID_AMT(rst.getBigDecimal(10));
                myClaims.setCCVT_REMARKS(rst.getString(11));
                myClaims.setCCVT_PAID(rst.getString(12));
                myClaims.setCCVT_PAYEE(rst.getString(13));
                myClaims.setCCVT_PAY_ORGANIZATION(rst.getString(14));
                myClaims.setSelected(Boolean.valueOf(false));
                if (rst.getString(15).equalsIgnoreCase("Y")) {
                    myClaims.setCLM_PAY_TOT_COINS_AMT(rst.getString(15));
                    myClaims.setCLM_PAY_TOT_COINS_DISP("Yes");
                } else {
                    myClaims.setCLM_PAY_TOT_COINS_AMT(rst.getString(15));
                    myClaims.setCLM_PAY_TOT_COINS_DISP("No");
                }
                if (rst.getString(12) != null) {
                    if (rst.getString(12).equalsIgnoreCase("N")) {
                        this.session.setAttribute("VoucherDecision", "Yes");
                    }
                }
                myClaims.setCcvt_saving_amt(rst.getBigDecimal(16));
                myClaims.setCcvt_original_loan_amt(rst.getBigDecimal(17));
                myClaims.setCcvt_orig_loan_repayment_prd(rst.getBigDecimal(18));
                myClaims.setCcvt_pct_code(rst.getBigDecimal(19));

                ClaimList.add(myClaims);
            }
            rst.close();
            cst.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(rst, cst, conn);
        }
        return ClaimList;
    }

    public List<Claim> FindClaimCoinsuranceRecoveries() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        List<Claim> ClaimList = new ArrayList();
        ResultSet rst = null;
        try {
            String polQuery =
                "begin LMS_WEB_CURSOR_GRP.getclaimCoinPymnts(?,?);end;";
            cst = conn.prepareCall(polQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setString(2, (String)this.session.getAttribute("ClaimNo"));

            cst.execute();
            rst = (ResultSet)cst.getObject(1);
            while (rst.next()) {
                Claim myClaims = new Claim();

                myClaims.setAGN_NAME(rst.getString(1));
                myClaims.setCCR_CODE(rst.getBigDecimal(2));
                myClaims.setCCR_POLM_CODE(rst.getBigDecimal(3));
                myClaims.setCCR_PCOIN_SHARE_PCT(rst.getBigDecimal(4));
                myClaims.setCCR_PCOIN_AGN_CODE(rst.getBigDecimal(5));
                myClaims.setCCR_CLM_AMT_TO_PAY(rst.getBigDecimal(6));
                myClaims.setCCR_AMT_PAID(rst.getBigDecimal(7));
                myClaims.setCCR_BALANCE(rst.getBigDecimal(8));
                myClaims.setCCR_AUTHORISED(rst.getString(9));
                myClaims.setCCR_AUTHORISED_BY(rst.getString(10));
                myClaims.setCCR_PREPARED_BY(rst.getString(11));
                myClaims.setCCR_PAID(rst.getString(12));


                ClaimList.add(myClaims);
            }
            rst.close();
            cst.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(rst, cst, conn);
        }
        return ClaimList;
    }

    public List<Claim> FindClaims() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        String todayString = null;
        CallableStatement cst = null;
        List<Claim> ClaimList = new ArrayList();
        ResultSet rst = null;
        try {
            String polQuery = "begin LMS_WEB_CURSOR_GRP.getclaims(?,?,?);end;";
            cst = conn.prepareCall(polQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setString(2, (String)this.session.getAttribute("ClaimNo"));

            cst.setBigDecimal(3,
                              (BigDecimal)this.session.getAttribute("MemberNumber"));


            cst.execute();
            rst = (ResultSet)cst.getObject(1);
            while (rst.next()) {
                Claim myClaims = new Claim();

                myClaims.setCLM_NO(rst.getString(1));
                this.session.setAttribute("dmsClmNo", rst.getString(1));
                myClaims.setCLM_STATUS(rst.getString(2));
                myClaims.setCLM_MEM_NO(rst.getString(3));
                this.session.setAttribute("dmsClmMemNo", rst.getString(3));
                myClaims.setCLM_MEMBER_DISPLAY(rst.getString(4));
                this.session.setAttribute("dmsClmMem", rst.getString(4));
                myClaims.setCLM_DEATH_DISABILITY_AGE(rst.getString(5));
                myClaims.setCLM_DATE_CLAIM_REPORTED(rst.getDate(6));
                if (rst.getDate(6).toString().contains(":")) {
                    todayString =
                            GlobalCC.parseDate(rst.getDate(6).toString());
                } else {
                    todayString =
                            GlobalCC.upDateParseDate(rst.getDate(6).toString());
                    this.session.setAttribute("dmsQuoDate", todayString);
                }
                this.session.setAttribute("dmsClmDate", todayString);
                myClaims.setCLM_DATE_DEATH_ACCIDENT(rst.getDate(7));
                myClaims.setCLM_CAUS_DESC(rst.getString(8));
                myClaims.setCLM_CAUS_TYPE(rst.getString(9));
                myClaims.setCLM_CLM_DDC_CODE(rst.getBigDecimal(10));
                session.setAttribute("CLM_DDC_CODE", rst.getBigDecimal(10));
                myClaims.setCLM_DDC_DESC(rst.getString(11));
                myClaims.setCLM_RESERVE_AMT(rst.getBigDecimal(12));
                myClaims.setCLM_RETENTION_PCT(rst.getBigDecimal(13));
                myClaims.setCLM_REMARKS(rst.getString(14));
                myClaims.setCLM_AMT_CLAIMED(rst.getBigDecimal(15));
                myClaims.setCLM_AMT_TO_PAY(rst.getBigDecimal(16));
                myClaims.setCLM_PAID_AMT(rst.getBigDecimal(17));
                myClaims.setCLM_RI_TOT_AMT(rst.getBigDecimal(18));
                myClaims.setCLM_PENS_AMT_TO_PAY(rst.getBigDecimal(19));
                myClaims.setCLM_PENS_PAID_AMT(rst.getBigDecimal(20));
                myClaims.setCLM_WITHIN_SYSTEM(rst.getString(21));
                myClaims.setCLM_DATE(rst.getDate(22));
                myClaims.setCLM_GROSS_RET_AMT(rst.getBigDecimal(23));
                myClaims.setCLM_RETETION_AMT(rst.getBigDecimal(24));
                myClaims.setCLM_RECOVERY_AMT(rst.getBigDecimal(25));
                myClaims.setCLM_RECOVERED_AMT(rst.getBigDecimal(26));
                myClaims.setCLM_OUTSTAND_PREM(rst.getBigDecimal(27));
                myClaims.setCAUS_CODE(rst.getBigDecimal(28));
                this.session.setAttribute("CauseCode", rst.getBigDecimal(28));
                this.session.setAttribute("CausationCode",
                                          rst.getBigDecimal(28));
                this.session.setAttribute("CoinsPolicy", rst.getString(29));
                myClaims.setCLM_EXGRATIA(rst.getString(30));
                this.session.setAttribute("exgratiaClaim", rst.getString(30));
                myClaims.setCLM_EXGRATIA_REMARKS(rst.getString(31));
                this.session.setAttribute("ProductCode",
                                          rst.getBigDecimal(32));
                this.session.setAttribute("allCovers", "Y");
                myClaims.setClm_death_location(rst.getString(33));
                this.session.setAttribute("prpCode", rst.getBigDecimal(34));
                myClaims.setCLM_PAY_INSTALMNTS(rst.getString(35));
                this.session.setAttribute("payInstalment", rst.getString(35));
                myClaims.setCLM_NOF_INST(rst.getBigDecimal(36));
                myClaims.setCLM_INST_PAY_FREQ(rst.getString(37));
                myClaims.setCLM_LOAN_ISSUE_DATE(rst.getDate(38));
                myClaims.setCLM_LOAN_INST_AMT(rst.getBigDecimal(39));
                myClaims.setCLM_HOSP_DAYS(rst.getBigDecimal(40));
                myClaims.setDOB(rst.getDate(41));
                myClaims.setPOLM_DATE_JOINED(rst.getDate(42));
                myClaims.setPMPNS_DATE_EMPLOYED(rst.getDate(43));
                myClaims.setKRAPIN(rst.getString(44));
                myClaims.setPMPNS_OVERRIDE_TAX_EXEMPT(rst.getBigDecimal(45));
                ClaimList.add(myClaims);
                //System.out.println("Causation code "+session.getAttribute("CausationCode"));
            }
            rst.close();
            cst.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
            e.printStackTrace();
        } finally {
            GlobalCC.CloseConnections(rst, cst, conn);
        }
        return ClaimList;
    }

    public List<Claim> FindMultiClaims() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();

        CallableStatement cst = null;
        List<Claim> ClaimList = new ArrayList();
        ResultSet rst = null;
        try {
            String polQuery =
                "begin LMS_WEB_CURSOR_GRP.getmulticlaims(?,?);end;";
            cst = conn.prepareCall(polQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);

            cst.setBigDecimal(2,
                              (BigDecimal)this.session.getAttribute("clmbatchNo"));


            cst.execute();
            rst = (ResultSet)cst.getObject(1);
            while (rst.next()) {
                Claim myClaims = new Claim();

                myClaims.setCLM_NO(rst.getString(1));
                myClaims.setCLM_STATUS(rst.getString(2));
                myClaims.setCLM_MEM_NO(rst.getString(3));
                myClaims.setCLM_MEMBER_DISPLAY(rst.getString(4));
                myClaims.setCLM_DEATH_DISABILITY_AGE(rst.getString(5));
                myClaims.setCLM_DATE_CLAIM_REPORTED(rst.getDate(6));
                myClaims.setCLM_DATE_DEATH_ACCIDENT(rst.getDate(7));
                myClaims.setCLM_CAUS_DESC(rst.getString(8));
                myClaims.setCLM_CAUS_TYPE(rst.getString(9));
                myClaims.setCLM_CLM_DDC_CODE(rst.getBigDecimal(10));
                myClaims.setCLM_DDC_DESC(rst.getString(11));
                myClaims.setCLM_RESERVE_AMT(rst.getBigDecimal(12));
                myClaims.setCLM_RETENTION_PCT(rst.getBigDecimal(13));
                myClaims.setCLM_REMARKS(rst.getString(14));
                myClaims.setCLM_AMT_CLAIMED(rst.getBigDecimal(15));
                myClaims.setCLM_AMT_TO_PAY(rst.getBigDecimal(16));
                myClaims.setCLM_PAID_AMT(rst.getBigDecimal(17));
                myClaims.setCLM_RI_TOT_AMT(rst.getBigDecimal(18));
                myClaims.setCLM_PENS_AMT_TO_PAY(rst.getBigDecimal(19));
                myClaims.setCLM_PENS_PAID_AMT(rst.getBigDecimal(20));
                myClaims.setCLM_WITHIN_SYSTEM(rst.getString(21));
                myClaims.setCLM_DATE(rst.getDate(22));
                myClaims.setCLM_GROSS_RET_AMT(rst.getBigDecimal(23));
                myClaims.setCLM_RETETION_AMT(rst.getBigDecimal(24));
                myClaims.setCLM_RECOVERY_AMT(rst.getBigDecimal(25));
                myClaims.setCLM_RECOVERED_AMT(rst.getBigDecimal(26));
                myClaims.setCLM_OUTSTAND_PREM(rst.getBigDecimal(27));
                myClaims.setCAUS_CODE(rst.getBigDecimal(28));
                this.session.setAttribute("CauseCode", rst.getBigDecimal(28));
                this.session.setAttribute("CoinsPolicy", rst.getString(29));
                myClaims.setCLM_EXGRATIA(rst.getString(30));
                this.session.setAttribute("exgratiaClaim", rst.getString(30));
                myClaims.setCLM_EXGRATIA_REMARKS(rst.getString(31));
                this.session.setAttribute("ProductCode",
                                          rst.getBigDecimal(32));
                this.session.setAttribute("allCovers", "Y");
                myClaims.setClm_death_location(rst.getString(33));
                this.session.setAttribute("prpCode", rst.getBigDecimal(34));
                myClaims.setSelected(Boolean.valueOf(false));


                ClaimList.add(myClaims);
            }
            rst.close();
            cst.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
            e.printStackTrace();
        } finally {
            GlobalCC.CloseConnections(rst, cst, conn);
        }
        return ClaimList;
    }

    public List<Claim> FindPensionMaturities() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();

        CallableStatement cst = null;
        List<Claim> ClaimList = new ArrayList();
        ResultSet rst = null;
        try {
            String polQuery =
                "begin LMS_WEB_CURSOR_GRP.find_pension_maturities(?,?);end;";
            cst = conn.prepareCall(polQuery);

            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setBigDecimal(2,
                              (BigDecimal)this.session.getAttribute("PolmCode"));


            cst.execute();
            rst = (ResultSet)cst.getObject(1);
            while (rst.next()) {
                Claim myClaims = new Claim();


                myClaims.setPCY_CODE(rst.getBigDecimal(1));
                myClaims.setPCY_PAY_DATE(rst.getDate(2));
                myClaims.setPCY_POL_CODE(rst.getBigDecimal(3));
                myClaims.setPCY_POL_POLICY_NO(rst.getString(4));
                myClaims.setPCY_CLM_NO(rst.getString(5));
                myClaims.setPCY_PAID(rst.getString(6));
                myClaims.setPCY_PAYEE(rst.getString(7));
                myClaims.setPCY_AMOUNT(rst.getBigDecimal(8));
                myClaims.setPCY_VOUCHER_NO(rst.getString(9));
                myClaims.setPCY_POLM_CODE(rst.getBigDecimal(10));
                myClaims.setMEMBERNAME(rst.getString(11));
                myClaims.setSelected(Boolean.valueOf(false));

                ClaimList.add(myClaims);
            }
            rst.close();
            cst.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(rst, cst, conn);
        }
        return ClaimList;
    }

    public List<Claim> findClaimVouchers() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();

        CallableStatement cst = null;
        List<Claim> claims = new ArrayList();
        ResultSet rs = null;
        try {
            String clmVoucherQuery =
                "begin LMS_WEB_CURSOR_GRP.get_clm_vouchers(?,?,?); end;";

            cst = conn.prepareCall(clmVoucherQuery);


            cst.registerOutParameter(1, OracleTypes.CURSOR);


            cst.setString(2, (String)this.session.getAttribute("ClaimNo"));
            cst.setBigDecimal(3,
                              (BigDecimal)this.session.getAttribute("pcyCode"));

            cst.execute();
            rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Claim claim = new Claim();
                claim.setCpvVouvherNo(rs.getBigDecimal(1));
                claim.setCpvDate(rs.getDate(2));
                claim.setCpvAmount(rs.getBigDecimal(3));
                claim.setCpvPayee(rs.getString(4));
                claim.setCpvTransType(rs.getString(5));
                claim.setCpvLoanAmt(rs.getBigDecimal(6));
                claim.setCpvPremAmt(rs.getBigDecimal(7));
                claim.setCpvStatus(rs.getString(8));
                claim.setCpvPenaltyAmt(rs.getBigDecimal(9));
                claim.setCpvSarAmt(rs.getBigDecimal(10));
                claim.setCpvBoSpreadAmt(rs.getBigDecimal(11));

                claim.setBankAccNo("");
                claim.setBankBranchCode(null);
                claim.setBeneficiaryCode(null);
                claim.setCPV_DISP_STATUS_DISP(rs.getString(12));
                claim.setCPV_DISCHARGE_STATUS(rs.getString(13));
                claim.setCpv_authorised(rs.getString(14));
                if (rs.getString(14) != null) {
                    if (rs.getString(14).equalsIgnoreCase("N")) {
                        this.session.setAttribute("VoucherDecision", "AV");
                    }
                }
                claim.setCpv_ltr_btr_trans_code(rs.getString(15));
                claim.setCpv_payment_mode(rs.getString(16));
                claim.setCpv_bbr_acc_no(rs.getString(17));

                claim.setCPV_PAYEE_TEL(rs.getString(18));
                claim.setBBR_BRANCH_NAME(rs.getString(19));
                claims.add(claim);
            }
            rs.close();
            cst.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(rs, cst, conn);
        }
        return claims;
    }

    public List<Claim> findClaimSubVouchers() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();

        CallableStatement cst = null;
        List<Claim> claims = new ArrayList();
        ResultSet rs = null;
        try {
            String clmVoucherQuery =
                "begin LMS_WEB_CURSOR_GRP.get_clm_sub_vouchers(?,?,?); end;";

            cst = conn.prepareCall(clmVoucherQuery);


            cst.registerOutParameter(1, OracleTypes.CURSOR);


            cst.setString(2, (String)this.session.getAttribute("ClaimNo"));
            cst.setBigDecimal(3,
                              (BigDecimal)this.session.getAttribute("voucherNumber"));

            cst.execute();
            rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Claim claim = new Claim();
                claim.setCpvVouvherNo(rs.getBigDecimal(1));
                claim.setCpvDate(rs.getDate(2));
                claim.setCpvAmount(rs.getBigDecimal(3));
                claim.setCpvPayee(rs.getString(4));
                claim.setCpvTransType(rs.getString(5));
                claim.setCpvLoanAmt(rs.getBigDecimal(6));
                claim.setCpvPremAmt(rs.getBigDecimal(7));
                claim.setCpvStatus(rs.getString(8));
                claim.setCpvPenaltyAmt(rs.getBigDecimal(9));
                claim.setCpvSarAmt(rs.getBigDecimal(10));
                claim.setCpvBoSpreadAmt(rs.getBigDecimal(11));

                claim.setBankAccNo("");
                claim.setBankBranchCode(null);
                claim.setBeneficiaryCode(null);
                claim.setCPV_DISP_STATUS_DISP(rs.getString(12));
                claim.setCPV_DISCHARGE_STATUS(rs.getString(13));
                claim.setCpv_authorised(rs.getString(14));
                claim.setCpv_ltr_btr_trans_code(rs.getString(15));
                claim.setCpv_payment_mode(rs.getString(16));
                claim.setCpv_bbr_acc_no(rs.getString(17));

                claims.add(claim);
            }
            rs.close();
            cst.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(rs, cst, conn);
        }
        return claims;
    }

    public List<Claim> findMultipleClaimVouchers() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();

        CallableStatement cst = null;
        List<Claim> claims = new ArrayList();
        ResultSet rs = null;
        try {
            String clmVoucherQuery =
                "begin LMS_WEB_CURSOR_GRP.get_multi_clm_vouchers(?,?,?,?); end;";

            cst = conn.prepareCall(clmVoucherQuery);


            cst.registerOutParameter(1, OracleTypes.CURSOR);


            cst.setString(2, (String)this.session.getAttribute("ClaimNo"));
            cst.setBigDecimal(3,
                              (BigDecimal)this.session.getAttribute("clmbatchNo"));
            cst.setBigDecimal(4,
                              (BigDecimal)this.session.getAttribute("pcyCode"));

            cst.execute();
            rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Claim claim = new Claim();
                claim.setCpvVouvherNo(rs.getBigDecimal(1));
                claim.setCpvDate(rs.getDate(2));
                claim.setCpvAmount(rs.getBigDecimal(3));
                claim.setCpvPayee(rs.getString(4));
                claim.setCpvTransType(rs.getString(5));
                claim.setCpvLoanAmt(rs.getBigDecimal(6));
                claim.setCpvPremAmt(rs.getBigDecimal(7));
                claim.setCpvStatus(rs.getString(8));
                claim.setCpvPenaltyAmt(rs.getBigDecimal(9));
                claim.setCpvSarAmt(rs.getBigDecimal(10));
                claim.setCpvBoSpreadAmt(rs.getBigDecimal(11));

                claim.setBankAccNo("");
                claim.setBankBranchCode(null);
                claim.setBeneficiaryCode(null);
                claim.setCPV_DISP_STATUS_DISP(rs.getString(12));
                claim.setCPV_DISCHARGE_STATUS(rs.getString(13));
                claim.setCpv_authorised(rs.getString(14));
                if (rs.getString(14) != null) {
                    if (rs.getString(14).equalsIgnoreCase("N")) {
                        this.session.setAttribute("VoucherDecision", "AV");
                    }
                }
                claim.setCpv_ltr_btr_trans_code(rs.getString(15));

                claims.add(claim);
            }
            rs.close();
            cst.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(rs, cst, conn);
        }
        return claims;
    }

    public List<Claim> findClaimVouchDtls() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();

        CallableStatement cst = null;
        List<Claim> claims = new ArrayList();
        ResultSet rs = null;
        try {
            String clmVoucherQuery =
                "begin LMS_WEB_CURSOR_GRP.Clmvchrdtls(?,?,?); end;";

            cst = conn.prepareCall(clmVoucherQuery);


            cst.registerOutParameter(1, OracleTypes.CURSOR);


            cst.setString(2, (String)this.session.getAttribute("ClaimNo"));
            cst.setBigDecimal(3, null);

            cst.execute();
            rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Claim claim = new Claim();
                claim.setCvtDesc(rs.getString(1));
                claim.setCpvdDate(rs.getDate(2));
                claim.setCpvdAmount(rs.getBigDecimal(3));
                claim.setCpvVouvherNo(rs.getBigDecimal(4));
                claim.setCpvDate(rs.getDate(5));
                claim.setCpvPayee(rs.getString(6));
                claim.setCpvAccNo(rs.getString(7));
                claim.setCpvMftProvider(rs.getString(8));

                claims.add(claim);
            }
            rs.close();
            cst.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(rs, cst, conn);
        }
        return claims;
    }

    public List<Claim> findMultipleClaimVouchDtls() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();

        CallableStatement cst = null;
        List<Claim> claims = new ArrayList();
        ResultSet rs = null;
        try {
            String clmVoucherQuery =
                "begin LMS_WEB_CURSOR_GRP.MultiClmvchrdtls(?,?,?,?); end;";

            cst = conn.prepareCall(clmVoucherQuery);


            cst.registerOutParameter(1, OracleTypes.CURSOR);


            cst.setString(2, (String)this.session.getAttribute("ClaimNo"));
            cst.setBigDecimal(3, null);
            cst.setBigDecimal(4,
                              (BigDecimal)this.session.getAttribute("clmbatchNo"));

            cst.execute();
            rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Claim claim = new Claim();
                claim.setCvtDesc(rs.getString(1));
                claim.setCpvdDate(rs.getDate(2));
                claim.setCpvdAmount(rs.getBigDecimal(3));
                claim.setCpvVouvherNo(rs.getBigDecimal(4));
                claim.setCpvDate(rs.getDate(5));
                claim.setCpvPayee(rs.getString(6));

                claims.add(claim);
            }
            rs.close();
            cst.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(rs, cst, conn);
        }
        return claims;
    }

    public List<Claim> findProductTaxes() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();

        CallableStatement cst = null;
        List<Claim> claims = new ArrayList();
        ResultSet rs = null;
        try {
            String clmVoucherQuery =
                "begin LMS_WEB_CURSOR_GRP.find_product_taxes(?,?); end;";

            cst = conn.prepareCall(clmVoucherQuery);


            cst.registerOutParameter(1, OracleTypes.CURSOR);


            cst.setBigDecimal(2,
                              (BigDecimal)this.session.getAttribute("ProductCode"));

            cst.execute();
            rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Claim claim = new Claim();

                claim.setTT_CODE(rs.getBigDecimal(1));
                claim.setTT_SHT_DESC(rs.getString(2));
                claim.setTT_DESC(rs.getString(3));
                claim.setTRT_RATE_TYPE(rs.getString(4));

                claims.add(claim);
            }
            rs.close();
            cst.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(rs, cst, conn);
        }
        return claims;
    }

    public List<Claim> findPensionTaxes() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();

        CallableStatement cst = null;
        List<Claim> claims = new ArrayList();
        ResultSet rs = null;
        try {
            String clmVoucherQuery =
                "begin LMS_WEB_CURSOR_GRP.get_pension_clm_taxes(?,?); end;";

            cst = conn.prepareCall(clmVoucherQuery);


            cst.setBigDecimal(1,
                              (BigDecimal)this.session.getAttribute("PolmCode"));
            cst.registerOutParameter(2, OracleTypes.CURSOR);


            cst.execute();
            rs = (ResultSet)cst.getObject(2);
            while (rs.next()) {
                Claim claim = new Claim();

                claim.setPPTX_CODE(rs.getBigDecimal(1));
                claim.setTT_DESC(rs.getString(2));
                claim.setPPTX_RATE(rs.getBigDecimal(3));
                claim.setPPTX_TAX_AMT(rs.getBigDecimal(4));
                claim.setPPTX_TT_CODE(rs.getBigDecimal(5));
                claim.setPPTX_RATE_TYPE(rs.getString(6));

                claims.add(claim);
            }
            rs.close();
            cst.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(rs, cst, conn);
        }
        return claims;
    }

    public List<Claim> findClaimExceptions() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();

        CallableStatement cst = null;
        List<Claim> claims = new ArrayList();
        ResultSet rs = null;
        try {
            String clmVoucherQuery =
                "begin LMS_WEB_CURSOR_GRP.get_claims_exceptions(?,?); end;";

            cst = conn.prepareCall(clmVoucherQuery);


            cst.registerOutParameter(1, OracleTypes.CURSOR);


            cst.setString(2, (String)this.session.getAttribute("ClaimNo"));

            cst.execute();
            rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Claim claim = new Claim();


                claim.setQEXC_CODE(rs.getBigDecimal(1));
                claim.setQEXC_POL_QUOT_CODE(rs.getBigDecimal(2));
                claim.setQEXC_AUTHORISED(rs.getString(3));
                claim.setQEXC_DESC(rs.getString(4));
                claim.setAGN_NAME(rs.getString(5));
                claim.setCCVT_DESC(rs.getString(6));
                claims.add(claim);
            }
            rs.close();
            cst.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(rs, cst, conn);
        }
        return claims;
    }

    public List<Claim> findClaimVchrtrtRI() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();

        CallableStatement cst = null;
        List<Claim> claims = new ArrayList();
        ResultSet rs = null;
        try {
            String clmVoucherQuery =
                "begin LMS_WEB_CURSOR_GRP.ClmvchrtrtRI(?,?,?); end;";

            cst = conn.prepareCall(clmVoucherQuery);


            cst.registerOutParameter(1, OracleTypes.CURSOR);


            cst.setString(2, (String)this.session.getAttribute("ClaimNo"));
            cst.setBigDecimal(3,
                              (BigDecimal)this.session.getAttribute("voucherNumber"));

            cst.execute();
            rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Claim claim = new Claim();
                claim.setReiTrtShtDesc(rs.getString(1));
                claim.setCvtDesc(rs.getString(2));
                claim.setCoritdCessionRate(rs.getBigDecimal(3));
                claim.setCoritdAmount(rs.getBigDecimal(4));
                claims.add(claim);
            }
            rs.close();
            cst.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(rs, cst, conn);
        }
        return claims;
    }

    public List<Claim> findClaimVchrpartRI() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();

        CallableStatement cst = null;
        List<Claim> claims = new ArrayList();
        ResultSet rs = null;
        try {
            String clmVoucherQuery =
                "begin LMS_WEB_CURSOR_GRP.ClmvchrpartRI(?,?,?); end;";

            cst = conn.prepareCall(clmVoucherQuery);


            cst.registerOutParameter(1, OracleTypes.CURSOR);


            cst.setString(2, (String)this.session.getAttribute("ClaimNo"));
            cst.setBigDecimal(3,
                              (BigDecimal)this.session.getAttribute("voucherNumber"));

            cst.execute();
            rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Claim claim = new Claim();
                claim.setCoriptAgenShtDesc(rs.getString(1));
                claim.setCvtDesc(rs.getString(2));
                claim.setCoriptCessionRate(rs.getBigDecimal(3));
                claim.setCoriptAmount(rs.getBigDecimal(4));
                claims.add(claim);
            }
            rs.close();
            cst.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(rs, cst, conn);
        }
        return claims;
    }

    public List<Claim> FindClaimPensionDetails() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        List<Claim> ClaimList = new ArrayList();
        ResultSet rs = null;
        try {
            String polQuery =
                "begin LMS_WEB_CURSOR_GRP.get_pens_clm_dtls(?,?);end;";
            cst = conn.prepareCall(polQuery);

            cst.setBigDecimal(1,
                              (BigDecimal)this.session.getAttribute("PolmCode"));
            cst.registerOutParameter(2, OracleTypes.CURSOR);


            cst.execute();
            ResultSet rst = (ResultSet)cst.getObject(2);
            while (rst.next()) {
                Claim myClaims = new Claim();

                myClaims.setPMPNS_EMPYR_PENS_BF(rst.getBigDecimal(1));
                myClaims.setPMPNS_EMPYE_PENS_BF(rst.getBigDecimal(2));
                myClaims.setPMPNS_TOT_PENS_BF(rst.getBigDecimal(3));
                myClaims.setPMPNS_EARNINGS(rst.getBigDecimal(4));
                myClaims.setPMPNS_EMPLOYEE_CONTR(rst.getBigDecimal(5));
                myClaims.setPMPNS_EMPLOYER_CONTR(rst.getBigDecimal(6));
                myClaims.setPMPNS_EMPLYE_VOLU_CONTR(rst.getBigDecimal(7));
                myClaims.setPMPNS_TOTAL_CONTR(rst.getBigDecimal(8));
                myClaims.setPMPNS_NET_ANNUAL_FUND(rst.getBigDecimal(9));
                myClaims.setPMPNS_COMP_INT_RATE(rst.getBigDecimal(10));
                myClaims.setPMPNS_ANNTY_FAC_RATE(rst.getBigDecimal(11));
                myClaims.setPMPNS_PENS_ANNUM(rst.getBigDecimal(12));
                myClaims.setPMPNS_EST_MAT_VAL(rst.getBigDecimal(13));
                myClaims.setPMPNS_DATE_JOINED(rst.getDate(14));
                myClaims.setPMPNS_EMPYR_BAL_BF(rst.getBigDecimal(15));
                myClaims.setPMPNS_EMPYE_BAL_BF(rst.getBigDecimal(16));
                myClaims.setPMPNS_VOL_BF(rst.getBigDecimal(17));
                myClaims.setPMPNS_WET_DATE(rst.getDate(18));
                myClaims.setPMPNS_SERVICE_YRS(rst.getString(19));
                myClaims.setPMPNS_EMPYR_YR_TOT_CONTR(rst.getBigDecimal(20));
                myClaims.setPMPNS_EMPYE_YR_TOT_CONTR(rst.getBigDecimal(21));
                myClaims.setPMPNS_PENS_INTEREST_PCT(rst.getBigDecimal(22));
                myClaims.setPMPNS_EMPYR_CUR_YR_INCOME(rst.getBigDecimal(23));
                myClaims.setPMPNS_EMPYE_CUR_YR_INCOME(rst.getBigDecimal(24));
                myClaims.setPMPNS_VESTING_PCT(rst.getBigDecimal(25));
                myClaims.setPMPNS_EMPYR_PENS_FUND(rst.getBigDecimal(26));
                myClaims.setPMPNS_GROSS_PAYABLE(rst.getBigDecimal(27));
                myClaims.setPMPNS_EMPYR_RETIRE_HELD(rst.getBigDecimal(28));
                myClaims.setPMPNS_TAX_EXEMPT(rst.getString(29));
                myClaims.setPMPNS_TAXABLE_AMT(rst.getBigDecimal(30));
                myClaims.setPMPNS_TAX_PAYABLE(rst.getBigDecimal(31));
                myClaims.setPMPNS_NET_PAYABLE(rst.getBigDecimal(32));
                myClaims.setPMPNS_PAYEE(rst.getString(33));
                if (rst.getString(33) == null) {
                    this.session.setAttribute("pensionPayee", "N");
                } else if ((rst.getString(33).equalsIgnoreCase("PFA")) ||
                           (rst.getString(33).equalsIgnoreCase("RSA"))) {
                    this.session.setAttribute("pensionPayee", "Y");
                } else {
                    this.session.setAttribute("pensionPayee", "N");
                }
                myClaims.setPMPNS_RFUND_AMOUNT(rst.getBigDecimal(34));
                myClaims.setPMPNS_RFUND_INTERST_RATE(rst.getString(35));
                myClaims.setPMPNS_RFUND_INTERST_AMT(rst.getBigDecimal(36));
                myClaims.setPMPNS_RFUND_TAX_EXEMPT(rst.getBigDecimal(37));
                myClaims.setPMPNS_RFUND_TAXABLE_AMT(rst.getBigDecimal(38));
                myClaims.setPMPNS_RFUND_NET_PAYABLE(rst.getBigDecimal(39));
                myClaims.setPMPNS_CODE(rst.getBigDecimal(40));
                this.session.setAttribute("PMPNS_CODE", rst.getBigDecimal(40));
                myClaims.setPMPNS_WEF_DATE(rst.getDate(41));
                myClaims.setPMPNS_PAYEE_NAME(rst.getString(42));
                myClaims.setPMPNS_PAYEE_PIN(rst.getString(43));
                myClaims.setPMPNS_ANN_PAY_FREQ(rst.getString(44));
                myClaims.setPMPNS_EMPYR_RETIRE_HELD_PCT(rst.getBigDecimal(45));


                ClaimList.add(myClaims);
            }
            rst.close();
            cst.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(rs, cst, conn);
        }
        return ClaimList;
    }

    public List<Claim> findClaimDisabilityLosses() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();

        CallableStatement cst = null;
        List<Claim> claims = new ArrayList();
        ResultSet rs = null;
        try {
            String clmVoucherQuery =
                "begin LMS_WEB_CURSOR_GRP.getCausationDisabilityLosses(?,?,?); end;";

            cst = conn.prepareCall(clmVoucherQuery);


            cst.registerOutParameter(1, OracleTypes.CURSOR);

            cst.setBigDecimal(2,
                              (BigDecimal)this.session.getAttribute("CauseCode"));
            cst.setString(3, (String)this.session.getAttribute("ClaimNo"));
            cst.execute();
            rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Claim claim = new Claim();
                claim.setLdlCode(rs.getBigDecimal(1));
                claim.setLdlPercentPayable(rs.getBigDecimal(2));
                claim.setClosePolicy(rs.getString(3));
                claim.setClosePolicyDesc(rs.getString(4));
                claim.setLdlDesc(rs.getString(5));
                claim.setLdlWeeklyIndemnity(rs.getString(6));
                claims.add(claim);
            }
            rs.close();
            cst.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(rs, cst, conn);
        }
        return claims;
    }

    public List<Claim> findMemberDisabilityLosses() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();

        CallableStatement cst = null;
        List<Claim> claims = new ArrayList();
        ResultSet rs = null;
        try {
            String clmVoucherQuery =
                "begin LMS_WEB_CURSOR_GRP.getClaimDisabilityLosses(?,?); end;";

            cst = conn.prepareCall(clmVoucherQuery);


            cst.registerOutParameter(1, OracleTypes.CURSOR);

            cst.setString(2, (String)this.session.getAttribute("ClaimNo"));

            cst.execute();
            rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Claim claim = new Claim();
                claim.setCdlCode(rs.getBigDecimal(1));
                claim.setLdldesc(rs.getString(2));
                claim.setCDL_PERC_PAYABLE(rs.getBigDecimal(3));
                claim.setCDL_NOF_LOSS_DAYS(rs.getString(4));
                claim.setCdlClmAmt(rs.getBigDecimal(5));
                claim.setCDL_LDL_CODE(rs.getBigDecimal(6));
                claims.add(claim);
            }
            rs.close();
            cst.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(rs, cst, conn);
        }
        return claims;
    }

    public List<Claim> findClaimBeneficaryPayments() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();

        CallableStatement cst = null;
        List<Claim> claims = new ArrayList();
        ResultSet rs = null;
        try {
            String clmVoucherQuery =
                "begin LMS_WEB_CURSOR_GRP.find_clm_Beneficary_pymts(?,?); end;";

            cst = conn.prepareCall(clmVoucherQuery);


            cst.registerOutParameter(1, OracleTypes.CURSOR);

            cst.setString(2, (String)this.session.getAttribute("ClaimNo"));

            cst.execute();
            rs = (ResultSet)cst.getObject(1);
            this.session.setAttribute("VoucherDecision", "No");
            while (rs.next()) {
                Claim claim = new Claim();

                claim.setBPY_CODE(rs.getBigDecimal(1));
                claim.setBPY_NAME(rs.getString(2));
                claim.setBPY_AMOUNT(rs.getBigDecimal(3));
                claim.setBPY_PAY_DATE(rs.getDate(4));
                claim.setBPY_PAID(rs.getString(5));
                claim.setBPY_PAID_DISPLAY(rs.getString(6));
                claim.setBPY_PAY_TERM(rs.getString(7));
                claim.setBPY_CLASS(rs.getString(8));
                claim.setBPY_VOUCHER_NO(rs.getString(9));
                if (rs.getString(9) == null) {
                    this.session.setAttribute("VoucherDecision", "Yes");
                }
                claims.add(claim);
            }
            rs.close();
            cst.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(rs, cst, conn);
        }
        return claims;
    }

    public List<Claim> findClaimAnnBeneficaryPayments() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();

        CallableStatement cst = null;
        List<Claim> claims = new ArrayList();
        ResultSet rs = null;
        try {
            String clmVoucherQuery =
                "begin LMS_WEB_CURSOR_GRP.find_clm_ann_beneficary_pymts(?,?); end;";

            cst = conn.prepareCall(clmVoucherQuery);


            cst.registerOutParameter(1, OracleTypes.CURSOR);

            cst.setString(2, (String)this.session.getAttribute("ClaimNo"));

            cst.execute();
            rs = (ResultSet)cst.getObject(1);
            this.session.setAttribute("VoucherDecision", "No");
            while (rs.next()) {
                Claim claim = new Claim();

                claim.setPABP_CODE(rs.getBigDecimal(1));
                claim.setPABP_NO(rs.getString(2));
                claim.setPAB_SURNAME(rs.getString(3));
                claim.setPAB_OTHERNAMES(rs.getString(4));
                claim.setPABP_DATE_DUE(rs.getDate(5));
                claim.setPABP_AMOUNT(rs.getBigDecimal(6));
                claim.setPABP_PAID(rs.getString(7));
                claim.setPABP_PAID_DATE(rs.getDate(8));
                claim.setPABP_VOUCHER_NO(rs.getString(9));
                if (rs.getString(9) == null) {
                    this.session.setAttribute("VoucherDecision", "Yes");
                }
                claims.add(claim);
            }
            rs.close();
            cst.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(rs, cst, conn);
        }
        return claims;
    }

    public List<Claim> FindClaimAuthorisation() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        List ClaimAuthList = new ArrayList();
        ResultSet rst = null;
        try {
            String clmAuthQuery =
                "begin LMS_WEB_CURSOR_GRP.get_clms_auth(?,?);end;";
            cst = conn.prepareCall(clmAuthQuery);
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setBigDecimal(2,
                              (BigDecimal)this.session.getAttribute("productCode"));
            cst.execute();
            rst = (ResultSet)cst.getObject(1);
            while (rst.next()) {
                Claim myClaims = new Claim();
                myClaims.setLTR_CLM_NO(rst.getString(1));
                myClaims.setMEM_NO_DISP(rst.getString(2));
                myClaims.setMEM_NAME_DISP(rst.getString(3));
                myClaims.setLTR_TRANS_NO(rst.getBigDecimal(4));
                myClaims.setLTR_POL_POLICY_NO(rst.getString(5));
                myClaims.setLTR_DONE_BY(rst.getString(6));
                myClaims.setLTR_POL_CODE(rst.getBigDecimal(7));
                myClaims.setLTR_MEM_CODE(rst.getBigDecimal(8));
                ClaimAuthList.add(myClaims);
            }
            rst.close();
            cst.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(rst, cst, conn);
        }
        return ClaimAuthList;
    }

    public List<Claim> FindVchrAuthorised() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        List authorisedVchr = new ArrayList();
        ResultSet rst = null;
        try {
            String clmAuthQuery =
                "begin LMS_WEB_CURSOR_GRP.get_vouchers_authorised(?,?);end;";
            cst = conn.prepareCall(clmAuthQuery);
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setString(2, (String)this.session.getAttribute("ClaimNo"));
            cst.execute();
            rst = (ResultSet)cst.getObject(1);
            while (rst.next()) {
                Claim voucherAuthorised = new Claim();
                voucherAuthorised.setCPV_VOUCHER_NO(rst.getBigDecimal(1));
                voucherAuthorised.setCPV_DATE(rst.getDate(2));
                authorisedVchr.add(voucherAuthorised);
            }
            rst.close();
            cst.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(rst, cst, conn);
        }
        return authorisedVchr;
    }

    public List<Claim> FindMultipleClaimsMem() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        List authorisedVchr = new ArrayList();
        ResultSet rst = null;
        try {
            String clmAuthQuery =
                "begin LMS_WEB_CURSOR_GRP.get_multiple_claims_mem(?,?);end;";
            cst = conn.prepareCall(clmAuthQuery);
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setBigDecimal(2,
                              (BigDecimal)this.session.getAttribute("policyCode"));
            cst.execute();
            rst = (ResultSet)cst.getObject(1);
            while (rst.next()) {
                Claim voucherAuthorised = new Claim();

                voucherAuthorised.setMCLM_CODE(rst.getBigDecimal(1));
                voucherAuthorised.setMEMBERNAME(rst.getString(2));
                voucherAuthorised.setDDC_DESC(rst.getString(3));
                voucherAuthorised.setMCLM_DATE_DEATH_ACCIDENT(rst.getDate(4));
                voucherAuthorised.setMCLM_DATE_CLAIM_REPORTED(rst.getDate(5));
                authorisedVchr.add(voucherAuthorised);
            }
            rst.close();
            cst.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(rst, cst, conn);
        }
        return authorisedVchr;
    }

    public List<Claim> FindClientBankDetails() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        List authorisedVchr = new ArrayList();
        ResultSet rst = null;
        try {
            String clmAuthQuery =
                "begin LMS_WEB_CURSOR_GRP.getClientBank2(?,?);end;";
            cst = conn.prepareCall(clmAuthQuery);
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setString(2,
                          (String)this.session.getAttribute("BankSearchString"));
            cst.execute();
            rst = (ResultSet)cst.getObject(1);
            int cnt = 1;
            while (rst.next()) {
                Claim voucherAuthorised = new Claim();
                voucherAuthorised.setBBR_CODE(rst.getBigDecimal(1));
                voucherAuthorised.setBBR_BRANCH_NAME(rst.getString(2));
                System.out.println("Record Search=" + cnt);
                cnt++;
                authorisedVchr.add(voucherAuthorised);
            }
            rst.close();
            cst.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(rst, cst, conn);
        }
        return authorisedVchr;
    }

    public List<Claim> FindClaimInstDetails() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        List clmInst = new ArrayList();
        ResultSet rst = null;
        try {
            String clmAuthQuery =
                "begin LMS_WEB_CURSOR_GRP.findClmInstalment(?,?);end;";
            cst = conn.prepareCall(clmAuthQuery);
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setString(2, (String)this.session.getAttribute("ClaimNo"));
            cst.execute();
            rst = (ResultSet)cst.getObject(1);
            while (rst.next()) {
                Claim claimInstal = new Claim();
                claimInstal.setCipgCode(rst.getBigDecimal(1));
                claimInstal.setCipgAmount(rst.getBigDecimal(2));
                claimInstal.setCipgPaid(rst.getString(3));
                claimInstal.setCipgVoucherNo(rst.getBigDecimal(4));
                claimInstal.setCipgPayDate(rst.getString(5));
                claimInstal.setCipgInstPayFreq(rst.getString(6));
                clmInst.add(claimInstal);
            }
            rst.close();
            cst.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(rst, cst, conn);
        }
        return clmInst;
    }

    public List<Claim> FindClaimRemarks() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        List<Claim> polRemarks = new ArrayList();
        try {
            String policyRemarks =
                "begin LMS_WEB_CURSOR_GRP.findclaimremarks(?,?);end;";

            cst = conn.prepareCall(policyRemarks);
            cst.setString(1,
                          String.valueOf(this.session.getAttribute("ClaimNo")));

            cst.registerOutParameter(2, OracleTypes.CURSOR);
            cst.execute();
            ResultSet rst = (ResultSet)cst.getObject(2);
            while (rst.next()) {
                Claim remarks = new Claim();
                remarks.setCRM_CODE(rst.getBigDecimal(1));
                remarks.setCRM_REMARKS(rst.getString(2));
                remarks.setCRM_REMARK_TYPE(rst.getString(3));
                remarks.setCRM_REMARKS_BY(rst.getString(4));
                remarks.setCRM_REMARKS_DATE(rst.getDate(5));
                if (rst.getString(3).equals("O")) {
                    remarks.setREMARKS_DESC("Observation");
                } else {
                    remarks.setREMARKS_DESC("Recommendation");
                }
                polRemarks.add(remarks);
            }
            rst.close();
            cst.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
            e.printStackTrace();
        }
        return polRemarks;
    }

    public void setDeathDisabilityCode(BigDecimal deathDisabilityCode) {
        this.deathDisabilityCode = deathDisabilityCode;
    }

    public BigDecimal getDeathDisabilityCode() {
        return (BigDecimal)this.session.getAttribute("LDL_CODE");
    }

    public List<Claim> findMobileProviders() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();

        CallableStatement cst = null;
        List<Claim> claims = new ArrayList();
        ResultSet rs = null;
        try {
            String clmVoucherQuery =
                "begin LMS_WEB_CURSOR_GRP.getProviderData(?); end;";

            cst = conn.prepareCall(clmVoucherQuery);


            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.execute();
            rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Claim claim = new Claim();
                claim.setMPT_CODE(rs.getBigDecimal(1));
                claim.setMPT_SHT_DESC(rs.getString(2));
                claim.setMPT_DESC(rs.getString(3));
                claim.setMPT_MIN_AMT_ALLOWED(rs.getBigDecimal(4));
                claim.setMPT_MAX_AMT_ALLOWED(rs.getBigDecimal(5));
                claims.add(claim);
            }
            rs.close();
            cst.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(rs, cst, conn);
        }
        return claims;
    }

    public List<Claim> findPartialWithdrawal() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();

        CallableStatement cst = null;
        List<Claim> claims = new ArrayList();
        ResultSet rs = null;
        try {
            String partialWithdrawal =
                "begin LMS_WEB_CURSOR_GRP.getpwithdrawaldetails(?,?); end;";

            cst = conn.prepareCall(partialWithdrawal);


            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.setString(2,
                          String.valueOf(this.session.getAttribute("ClaimNo")));
            cst.execute();
            rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Claim claim = new Claim();
                claim.setGPW_CODE(rs.getBigDecimal(1));
                claim.setGPW_EMPYR_BAL_BF(rs.getBigDecimal(2));
                claim.setGPW_EMPYR_AMT(rs.getBigDecimal(3));
                claim.setGPW_EMPYR_INT(rs.getBigDecimal(4));
                claim.setGPW_EMPYR_CF(rs.getBigDecimal(5));
                claim.setGPW_EMPYR_WITHDRAWABLE_AMT(rs.getBigDecimal(6));
                claim.setGPW_EMPYE_BAL_BF(rs.getBigDecimal(7));
                claim.setGPW_EMPYE_AMT(rs.getBigDecimal(8));
                claim.setGPW_EMPYE_INT(rs.getBigDecimal(9));
                claim.setGPW_EMPYE_CF(rs.getBigDecimal(10));
                claim.setGPW_EMPYE_WITHDRAWABLE_AMT(rs.getBigDecimal(11));
                claim.setTOTAL_BAL_BF(rs.getBigDecimal(12));
                claim.setTOTAL_AMOUNT(rs.getBigDecimal(13));
                claim.setTOTAL_INT(rs.getBigDecimal(14));
                claim.setTOTAL_BAL_CF(rs.getBigDecimal(15));
                claim.setTOTAL_WITHDRAWABLE_AMT(rs.getBigDecimal(16));
                claim.setGPW_WITH_APPLIED_ON(rs.getString(17));
                claim.setGPW_TAX_EXEMP_AMT(rs.getBigDecimal(18));
                claim.setGPW_AMT_APPLIED(rs.getBigDecimal(19));
                claim.setGPW_YRS_OF_SERV(rs.getBigDecimal(20));
                claim.setGPW_TAX_AMOUNT(rs.getBigDecimal(21));
                claim.setGPW_OVERRIDE_TAX_AMT(rs.getBigDecimal(22));
                claim.setNET_PAYABLE(rs.getBigDecimal(23));
                claim.setGPW_EMPYE_REG_WITH_AMT(rs.getBigDecimal(24));
                claim.setGPW_EMPYE_UNREG_WITH_AMT(rs.getBigDecimal(25));
                claim.setGPW_EMPYR_REG_WITH_AMT(rs.getBigDecimal(26));
                claim.setGPW_EMPYR_UNREG_WITH_AMT(rs.getBigDecimal(27));
                claims.add(claim);
            }
            rs.close();
            cst.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(rs, cst, conn);
        }
        return claims;
    }

    public List<Claim> getPendingClaimBooking() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();

        CallableStatement cst = null;
        List<Claim> pendingClaimBooking = new ArrayList();
        ResultSet rs = null;
        try {
            String query =
                "begin LMS_WEB_CURSOR_GRP.findclaimbooking(?); end;";

            cst = conn.prepareCall(query);
            cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.execute();
            rs = (ResultSet)cst.getObject(1);
            while (rs.next()) {
                Claim claim = new Claim();
                claim.setCmb_code(rs.getBigDecimal(1));
                claim.setCmb_date(rs.getDate(2));
                claim.setCmb_date_death_accident(rs.getDate(3));
                claim.setCmb_date_claim_reported(rs.getDate(4));
                claim.setPol_policy_no(rs.getString(5));
                claim.setPrp_surname(rs.getString(6));
                claim.setMem_surname(rs.getString(7));
                claim.setCmb_booked_by(rs.getString(8));
                claim.setPOL_CODE(rs.getBigDecimal(9));
                claim.setCmb_processed(rs.getString(10));
                pendingClaimBooking.add(claim);
            }
            rs.close();
            cst.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(rs, cst, conn);
        }

        return pendingClaimBooking;
    }
  public List<Claim> getPendingClaimBookingDtls() {
      DBConnector myConn = new DBConnector();
      Connection conn = myConn.getDatabaseConn();

      CallableStatement cst = null;
      List<Claim> pendingClaimBooking = new ArrayList<Claim>();
      ResultSet rs = null;
      try {
          String query =
              "begin LMS_CLAIM_BOOKING.findclaimbooking(?,?); end;";

          cst = conn.prepareCall(query);
          cst.registerOutParameter(1, OracleTypes.CURSOR);
          cst.setBigDecimal(2, (BigDecimal)session.getAttribute("cmbCode"));
          cst.execute();
          rs = (ResultSet)cst.getObject(1);
          while (rs.next()) {
              Claim claim = new Claim();
             claim.setMEM_NO_DISP(rs.getString(1));
             claim.setMEM_NAME_DISP(rs.getString(2));
             claim.setMEM_DOB(rs.getDate(3));
             claim.setMEM_IDENTITY_NO(rs.getString(4));
             claim.setCMB_DEATH_DISABILITY_AGE(rs.getInt(5));
             claim.setCAUS_DESC(rs.getString(6));
             claim.setDDC_DESC(rs.getString(7));
             claim.setCMB_DATE(rs.getDate(8));
             claim.setCMB_DATE_DEATH_ACCIDENT(rs.getDate(9));
             claim.setCMB_DATE_CLAIM_REPORTED(rs.getDate(10));
             claim.setCMB_BOOKED_BY(rs.getString(11));
             claim.setCMB_EXGRATIA(rs.getString(12));
             claim.setCMB_DEATH_LOCATION(rs.getString(13));
             claim.setCMB_EXGRATIA_REMARKS(rs.getString(14));
             claim.setCMB_REINSURANCE_SHARE(rs.getBigDecimal(15));
             claim.setCMB_COINSURANCE_SHARE(rs.getBigDecimal(16));
             claim.setCMB_RETENTION_SHARE(rs.getBigDecimal(17));
             claim.setCMB_TOT_REINSURANCE_AMT(rs.getBigDecimal(18));
             claim.setCMB_TOT_COINSURANCE_AMT(rs.getBigDecimal(19));
             claim.setCMB_RETENTION_AMT(rs.getBigDecimal(20));
             claim.setCMB_RESERVE_AMT(rs.getBigDecimal(21));
              pendingClaimBooking.add(claim);
          }
          rs.close();
          cst.close();
          conn.close();
      } catch (Exception e) {
          GlobalCC.EXCEPTIONREPORTING(conn, e);
      } finally {
          GlobalCC.CloseConnections(rs, cst, conn);
      }

      return pendingClaimBooking;
  }
  public List<Claim> getClaimBookingCovers() {
      DBConnector myConn = new DBConnector();
      Connection conn = myConn.getDatabaseConn();

      CallableStatement cst = null;
      List<Claim> bookingCovers = new ArrayList<Claim>();
      ResultSet rs = null;
      try {
          String query =
              "begin LMS_CLAIM_BOOKING.findbookingcovers(?,?); end;";

          cst = conn.prepareCall(query);
          cst.registerOutParameter(1, OracleTypes.CURSOR);
          cst.setBigDecimal(2,(BigDecimal)session.getAttribute("cmbCode"));
          cst.execute();
          rs = (ResultSet)cst.getObject(1);
          while (rs.next()) {
              Claim claim = new Claim();
              claim.setBookCoverCheck(true);
              claim.setCBVT_CODE(rs.getBigDecimal(1));
              claim.setCVT_DESC(rs.getString(2));
              claim.setCBVT_SA(rs.getBigDecimal(3));
              claim.setCBVT_RESERVE_AMT(rs.getBigDecimal(4));
              claim.setCBVT_EARNINGS(rs.getBigDecimal(5));
              claim.setCBVT_MULT_EARNINGS_PRD(rs.getBigDecimal(6));
              claim.setCBVT_ACCELERATOR(rs.getString(7));
              claim.setCBVT_ORIGINAL_LOAN_AMT(rs.getBigDecimal(8));
              claim.setCBVT_ORIG_LOAN_REPAYMENT_PRD(rs.getBigDecimal(9));
              claim.setCBVT_SAVING_AMT(rs.getBigDecimal(10));
              
              bookingCovers.add(claim);
          }
          rs.close();
          cst.close();
          conn.close();
      } catch (Exception e) {
      e.printStackTrace();
          GlobalCC.EXCEPTIONREPORTING(conn, e);
      } finally {
          GlobalCC.CloseConnections(rs, cst, conn);
      }

      return bookingCovers;
  }
  public List<Claim> getRiRecoverableAmt() {
      DBConnector myConn = new DBConnector();
      Connection conn = myConn.getDatabaseConn();

      CallableStatement cst = null;
      List<Claim> riRecoverableList = new ArrayList<Claim>();
      ResultSet rs = null;
      try {
          String query =
              "begin LMS_CLAIM_BOOKING.getrirecoverableamt(?,?); end;";

          cst = conn.prepareCall(query);
          cst.registerOutParameter(1, OracleTypes.CURSOR);
          cst.setBigDecimal(2,(BigDecimal)session.getAttribute("cmbCode"));
          cst.execute();
          rs = (ResultSet)cst.getObject(1);
          while (rs.next()) {
              Claim claim = new Claim();
              claim.setAgnName(rs.getString(1));
              claim.setRiGlAccount(rs.getString(2));
              claim.setRecoverableAmt(rs.getBigDecimal(3));
              riRecoverableList.add(claim);
          }
          rs.close();
          cst.close();
          conn.close();
      } catch (Exception e) {
      e.printStackTrace();
          GlobalCC.EXCEPTIONREPORTING(conn, e);
      } finally {
          GlobalCC.CloseConnections(rs, cst, conn);
      }

      return riRecoverableList;
  }
}
