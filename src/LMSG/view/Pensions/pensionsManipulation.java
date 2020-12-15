package LMSG.view.Pensions;

import LMSG.view.Base.ADFUtils;
import LMSG.view.Base.GlobalCC;
import LMSG.view.connect.DBConnector;

import java.io.PrintStream;

import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import javax.servlet.http.HttpSession;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputNumberSpinbox;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanCheckbox;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.layout.RichPanelBox;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.output.RichOutputLabel;
import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.uicli.binding.JUCtrlValueBinding;

import org.apache.myfaces.trinidad.event.SelectionEvent;
import org.apache.myfaces.trinidad.model.RowKeySet;
import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

public class pensionsManipulation {
    private RichPanelBox searchTab;
    private RichPanelBox detailsTab;
    private RichTable productsLOV;
    private RichInputText productsDesc;
    private RichInputText policiesDesc;
    private RichTable policiesLOV;
    private RichInputText pensYear;
    private RichInputText pensValDate;
    private RichInputText pensIntRate;
    private RichInputText pensStatus;
    private RichInputDate pensValDateinput;
    private RichInputText emprBF;
    private RichInputText emprContr;
    private RichInputText emprVol;
    private RichInputText emprWithdrawal;
    private RichInputText emprDepInt;
    private RichInputText emprdepintearn;
    private RichInputText emprCF;
    private RichInputText empeBF;
    private RichInputText empeContr;
    private RichInputText empeVol;
    private RichInputText empewithdrawal;
    private RichInputText empedepint;
    private RichInputText empeintearnings;
    private RichInputText empeCF;
    private RichInputText totalAmt;
    private RichInputText totalwithdrawal;
    private RichInputText totalCF;
    private RichTable balancesLOV;
    private RichOutputText edYear;
    private RichInputText edIntRate;
    private RichInputDate edValDate;
    private RichSelectOneChoice transType;
    private RichTable deductionsLOV;
    private RichOutputText dedLabel;
    private RichInputDate dedDate;
    private RichInputText dedSchVal;
    private RichInputText dedRate;
    private RichInputText dedTaxAmt;
    private RichTable allDeductionsLOV;
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    private RichInputText receiptNumber;
    private RichInputDate withDate;
    private RichInputText withAmount;
    private RichInputText withRate;
    private RichTable pensWithdrawal;
    private RichOutputLabel withPayee;
    private RichInputText pensPayee;
    private RichTable memPensionDeposits;
    private RichTable allocatedDeposits;
    private RichTable interestTable;
    private RichTable balancesPeriodsLOV;
    private RichInputText pensYearp;
    private RichInputText pensValDatep;
    private RichInputText pensIntRatep;
    private RichInputText pensStatusp;
    private RichInputDate pensValDateinputp;
    private RichInputText emprBFP;
    private RichInputText emprContrP;
    private RichInputText emprVolP;
    private RichInputText emprWithdrawalP;
    private RichInputText emprDepIntP;
    private RichInputText emprdepintearnP;
    private RichInputText emprCFP;
    private RichInputText empeBFP;
    private RichInputText empeContrP;
    private RichInputText empeVolP;
    private RichInputText empewithdrawalP;
    private RichInputText empedepintP;
    private RichInputText empeintearningsP;
    private RichInputText empeCFP;
    private RichInputText totalAmtP;
    private RichInputText totalwithdrawalP;
    private RichInputText totalCFP;
    private RichOutputText prdYear;
    private RichInputDate prdWEF;
    private RichInputDate prdWET;
    private RichInputNumberSpinbox prdInt;
    private RichTable rateTables;
    private RichInputText tablesDesc;
    private RichPanelBox withdrawalTab;
    private RichSelectOneChoice amountRateDrop;
    private RichOutputLabel rateLabel;
    private RichOutputLabel amountLabel;
    private RichInputText empyrErndDepInt;
    private RichInputText empyrErndBalInt;
    private RichInputText empyeErndBalInt;
    private RichInputText empyedepintearnP;
    private RichInputText schemeFundBF;
    private RichInputText deductions;
    private RichInputText schemeFund;
    private RichInputText retireHeldFund;
    private RichInputText totalFundValue;
    private RichTable authDeductions;
    private RichCommandButton revalButton;
    private RichOutputLabel bankNameLabel;
    private RichInputText bankNameTF;
    private RichInputText bankAccountNo;
    private RichOutputLabel bankAccNoLab;
    private RichSelectOneChoice paymentMode;
    private RichTable clientBankLOV;
    private RichOutputLabel bankNameLab;
    private RichCommandButton bankDetailsBut;
    private RichPanelBox pensWithdrawalTab;
    private RichSelectBooleanCheckbox knockCbox;
    private RichTable revalRefLOV;
    private RichSelectBooleanCheckbox offSystem;
    private RichSelectOneChoice deductTaxAmt;
    private RichSelectOneChoice deductLostInt;
    private RichSelectOneChoice deductRateOrAmt;
    private RichSelectOneChoice deductEstOrAct;
    private RichInputText bankDetailsTF;
    private RichTable pensionMemberDAO;
    private RichInputText pensionMemNo;
    private RichInputText pensionMemName;
    private RichSelectOneChoice pensionMemSex;
    private RichInputDate pensionMemDob;
    private RichInputText pensionMemIdNo;
    private RichInputText pensionMemPinNo;
    private RichInputText pensionPhoneNumber;
    private RichInputText pensionEmailAddress;
    private RichTable pensionTransactionsDAO;
    private RichTable memWithdrawalDAO;
    private RichInputText memNameSearch;
    private RichInputText memNoSearch;
    private RichInputText memTelePhoneSearch;
    private RichInputText memIdNoSearch;
    private RichTable relationDAO;
    private RichInputText relationTypeTF;
    private RichInputText memSurname;
    private RichInputText memSurnameTF;
    private RichInputText memOtherNameTF;
    private RichInputDate memDobTF;
    private RichSelectOneChoice memGender;
    private RichInputText memIdNumberTF;
    private RichInputText memShareTF;


    public String CmdNext() {
        if (this.transType.getValue() == null) {
            GlobalCC.INFORMATIONREPORTING("Select A Transaction Type");
            return null;
        }
        if (this.policiesDesc.getValue() == null) {
            GlobalCC.INFORMATIONREPORTING("Select A Policy");
            return null;
        }
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        try {
            String Result = ValidateUserRights();
            if (Result.equalsIgnoreCase("F")) {
                return null;
            }
            String polQuery =
                "begin LMS_WEB_PKG_GRP_UW.createtransaction(?,?,?);end;";

            cst = conn.prepareCall(polQuery);
            cst.registerOutParameter(1, 4);
            cst.setString(2, this.transType.getValue().toString());
            cst.setString(3, "P");
            cst.execute();

            this.session.setAttribute("searchTab", "false");
            this.session.setAttribute("detailsTab", "true");
            this.session.setAttribute("withdrawalTab", "false");


            this.session.setAttribute("transactionNumber",
                                      cst.getBigDecimal(1));
            this.session.setAttribute("pensTransType",
                                      this.transType.getValue().toString());


            this.session.setAttribute("UWYear", null);
            cst.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public String ValidateUserRights() {
        String Process = "GLPNS";
        String ProcessArea = "GLVAL";
        String ProcessSubArea = "ACCS";
        String Result = "F";

        DBConnector datahandler = new DBConnector();
        Connection conn = null;
        try {
            conn = datahandler.getDatabaseConn();
            String query =
                "begin ?:= TQC_INTERFACES_PKG.check_user_rights(?,?,?,?,?); end;";


            CallableStatement cst = null;
            cst = conn.prepareCall(query);
            cst.registerOutParameter(1, 12);
            cst.setString(2, (String)this.session.getAttribute("Username"));
            cst.setInt(3, 27);
            cst.setString(4, Process);
            cst.setString(5, ProcessArea);
            cst.setString(6, ProcessSubArea);
            cst.execute();

            String Access = cst.getString(1);
            if (Access.equalsIgnoreCase("N")) {
                GlobalCC.INFORMATIONREPORTING("You do not have Right to Access the Valuation Module");
                return Result;
            }
            Result = "S";
            cst.close();


            Process = "GLPNS";
            ProcessArea = "GLVAL";
            ProcessSubArea = "VLPR";


            CallableStatement cst1 = null;
            cst1 = conn.prepareCall(query);
            cst1.registerOutParameter(1, 12);
            cst1.setString(2, (String)this.session.getAttribute("Username"));
            cst1.setInt(3, 27);
            cst1.setString(4, Process);
            cst1.setString(5, ProcessArea);
            cst1.setString(6, ProcessSubArea);
            cst1.execute();

            String Processing = cst1.getString(1);
            if (Processing.equalsIgnoreCase("N")) {
                this.session.setAttribute("ProcessingButtons", "false");
            } else {
                this.session.setAttribute("ProcessingButtons", "true");
            }
            cst1.close();


            Process = "GLPNS";
            ProcessArea = "GLVAL";
            ProcessSubArea = "VLRE";

            CallableStatement cst2 = null;
            cst2 = conn.prepareCall(query);
            cst2.registerOutParameter(1, 12);
            cst2.setString(2, (String)this.session.getAttribute("Username"));
            cst2.setInt(3, 27);
            cst2.setString(4, Process);
            cst2.setString(5, ProcessArea);
            cst2.setString(6, ProcessSubArea);
            cst2.execute();

            String Reval = cst2.getString(1);
            if (Reval.equalsIgnoreCase("N")) {
                this.revalButton.setDisabled(true);
            } else {
                this.revalButton.setDisabled(false);
            }
            cst2.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return Result;
    }

    public String findProductsSelected() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findProductsByTypeIterator");

        RowKeySet set = this.productsLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
            this.productsDesc.setValue(r.getAttribute("prodDesc"));

            this.session.setAttribute("ProductCode",
                                      r.getAttribute("prodCode"));

            this.policiesDesc.setValue(null);


            this.session.setAttribute("policyCode", null);
            this.session.setAttribute("endorsementCode", null);

            ADFUtils.findIterator("FindPensionTransactionsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.policiesLOV);
        }
        return null;
    }

    public String findPoliciesSelected() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindPensionTransactionsIterator");

        RowKeySet set = this.policiesLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
            this.policiesDesc.setValue(r.getAttribute("POL_POLICY_NO"));


            this.session.setAttribute("policyCode",
                                      r.getAttribute("POL_CODE"));
            this.session.setAttribute("endorsementCode",
                                      r.getAttribute("POL_CURRENT_ENDR_CODE"));

            this.session.setAttribute("productType", "PENS");
        }
        return null;
    }

    public String findDeductionsSelected() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindDeductionsIterator");

        RowKeySet set = this.deductionsLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
            this.dedLabel.setValue(r.getAttribute("DD_tt_sht_desc"));
            this.dedRate.setValue(r.getAttribute("trt_rate"));
            this.dedTaxAmt.setValue(null);
            this.dedDate.setValue(null);

            this.session.setAttribute("ttCode", r.getAttribute("DD_tt_code"));
            this.session.setAttribute("pdedCode", null);
            this.session.setAttribute("taxType", r.getAttribute("DD_tt_type"));
            GlobalCC.showPopup("lmsgroup:deduction");
        }
        return null;
    }

    public String PopulatePensionBalances() {
        return null;
    }

    public void setSearchTab(RichPanelBox searchTab) {
        this.searchTab = searchTab;
    }

    public RichPanelBox getSearchTab() {
        return this.searchTab;
    }

    public void setDetailsTab(RichPanelBox detailsTab) {
        this.detailsTab = detailsTab;
    }

    public RichPanelBox getDetailsTab() {
        return this.detailsTab;
    }

    public void setProductsLOV(RichTable productsLOV) {
        this.productsLOV = productsLOV;
    }

    public RichTable getProductsLOV() {
        return this.productsLOV;
    }

    public void setProductsDesc(RichInputText productsDesc) {
        this.productsDesc = productsDesc;
    }

    public RichInputText getProductsDesc() {
        return this.productsDesc;
    }

    public void setPoliciesDesc(RichInputText policiesDesc) {
        this.policiesDesc = policiesDesc;
    }

    public RichInputText getPoliciesDesc() {
        return this.policiesDesc;
    }

    public void setPoliciesLOV(RichTable policiesLOV) {
        this.policiesLOV = policiesLOV;
    }

    public RichTable getPoliciesLOV() {
        return this.policiesLOV;
    }

    public void setPensYear(RichInputText pensYear) {
        this.pensYear = pensYear;
    }

    public RichInputText getPensYear() {
        return this.pensYear;
    }

    public void setPensValDate(RichInputText pensValDate) {
        this.pensValDate = pensValDate;
    }

    public RichInputText getPensValDate() {
        return this.pensValDate;
    }

    public void setPensIntRate(RichInputText pensIntRate) {
        this.pensIntRate = pensIntRate;
    }

    public RichInputText getPensIntRate() {
        return this.pensIntRate;
    }

    public void setPensStatus(RichInputText pensStatus) {
        this.pensStatus = pensStatus;
    }

    public RichInputText getPensStatus() {
        return this.pensStatus;
    }

    public void setPensValDateinput(RichInputDate pensValDateinput) {
        this.pensValDateinput = pensValDateinput;
    }

    public RichInputDate getPensValDateinput() {
        return this.pensValDateinput;
    }

    public void balancesListener(SelectionEvent selectionEvent) {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindPensionBalancesSummaryIterator");

        RowKeySet set = selectionEvent.getAddedSet();
        Iterator rowKeySetIter = set.iterator();
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();


            this.session.setAttribute("UWYear", r.getAttribute("PNBAL_YEAR"));
            this.session.setAttribute("ValuationPeriod",
                                      r.getAttribute("PNBAL_PERIOD"));


            ADFUtils.findIterator("FindPensionBalancesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.emprBF);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.emprContr);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.emprVol);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.emprWithdrawal);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.emprDepInt);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.emprdepintearn);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.emprCF);


            AdfFacesContext.getCurrentInstance().addPartialTarget(this.empeBF);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.empeContr);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.empeVol);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.empewithdrawal);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.empedepint);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.empeintearnings);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.empeCF);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.totalAmt);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.totalwithdrawal);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.totalCF);

            AdfFacesContext.getCurrentInstance().addPartialTarget(this.schemeFundBF);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.deductions);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.schemeFund);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.retireHeldFund);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.totalFundValue);


            ADFUtils.findIterator("FindPensionBalancesPeriodsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.balancesPeriodsLOV);

            ADFUtils.findIterator("FindPensionDepositInterestIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.interestTable);


            ADFUtils.findIterator("FindPensionBalancesPeriodSummaryIterator").executeQuery();

            ADFUtils.findIterator("valuation_refundsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.revalRefLOV);
        }
    }

    public void balancesPeriodsListener(SelectionEvent selectionEvent) {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindPensionBalancesPeriodsIterator");

        RowKeySet set = selectionEvent.getAddedSet();
        Iterator rowKeySetIter = set.iterator();
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            this.session.setAttribute("UWYear", r.getAttribute("PNBAL_YEAR"));
            this.session.setAttribute("pnbalpCode",
                                      r.getAttribute("PNBALP_CODE"));


            this.prdWEF.setValue(r.getAttribute("PNBALP_WEF"));
            this.prdWET.setValue(r.getAttribute("PNBALP_WET"));
            this.session.setAttribute("WEFDate",
                                      GlobalCC.upDateParseDate(this.prdWEF.getValue().toString()));

            this.session.setAttribute("WETDate",
                                      GlobalCC.upDateParseDate(this.prdWET.getValue().toString()));


            ADFUtils.findIterator("FindPensionBalancesPeriodSummaryIterator").executeQuery();


            ADFUtils.findIterator("FindPensionDepositInterestIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.interestTable);
        }
    }

    public String AddPeriodicValuation() {
        if (this.session.getAttribute("UWYear") == null) {
            GlobalCC.sysInformation("Select A Valuation Year");
            return null;
        }
        this.prdInt.setValue(null);
        this.prdWEF.setValue(null);
        this.prdWET.setValue(null);
        this.prdYear.setValue(this.session.getAttribute("UWYear"));
        this.session.setAttribute("action", "A");
        this.session.setAttribute("pnbalpCode", null);


        ExtendedRenderKitService erkService =
            (ExtendedRenderKitService)Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                                         ExtendedRenderKitService.class);


        erkService.addScript(FacesContext.getCurrentInstance(),
                             "var hints = {autodismissNever:false}; AdfPage.PAGE.findComponent('lmsgroup:periodicVal').show(hints);");


        return null;
    }

    public String EditPeriodicValuation() {
        try {
            String Authorised = null;
            String revaluedStatus = getRevaluedStatus();

            DCIteratorBinding dciter =
                ADFUtils.findIterator("FindPensionBalancesPeriodsIterator");

            RowKeySet set = this.balancesPeriodsLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                Authorised = (String)r.getAttribute("STATUS");
                System.out.println("revaluedStatus " + revaluedStatus);
                if ((Authorised.equalsIgnoreCase("Authorised")) &&
                    (revaluedStatus.equalsIgnoreCase("N"))) {
                    GlobalCC.sysInformation("You cannot make changes to an Authorised Valuation");
                    return null;
                }
                this.prdInt.setValue(r.getAttribute("PNBAL_INTEREST_RATE"));
                this.prdWEF.setValue(r.getAttribute("PNBALP_WEF"));
                this.prdWET.setValue(r.getAttribute("PNBALP_WET"));
                this.prdYear.setValue(r.getAttribute("PNBAL_YEAR"));
                this.session.setAttribute("pnbalpCode",
                                          r.getAttribute("PNBALP_CODE"));

                this.tablesDesc.setValue(r.getAttribute("LPNT_DESC"));
                this.session.setAttribute("lpnt_code",
                                          r.getAttribute("PNBALP_LPNT_CODE"));

                this.session.setAttribute("action", "E");


                ExtendedRenderKitService erkService =
                    (ExtendedRenderKitService)Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                                                 ExtendedRenderKitService.class);


                erkService.addScript(FacesContext.getCurrentInstance(),
                                     "var hints = {autodismissNever:false}; AdfPage.PAGE.findComponent('lmsgroup:periodicVal').show(hints);");
            }
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String DeletePeriodicValuation() {
        try {
            String Authorised = null;

            DCIteratorBinding dciter =
                ADFUtils.findIterator("FindPensionBalancesPeriodsIterator");

            RowKeySet set = this.balancesPeriodsLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                Authorised = (String)r.getAttribute("STATUS");
                if ((Authorised.equalsIgnoreCase("Authorised")) &&
                    (getRevaluedStatus().equals("N"))) {
                    GlobalCC.sysInformation("You cannot make changes to an Authorised Valuation");
                    return null;
                }
                this.session.setAttribute("pnbalpCode",
                                          r.getAttribute("PNBALP_CODE"));

                this.session.setAttribute("action", "D");

                SavePeriodicValuation();
            }
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String ReEvaluateYear() {
        Connection conn = null;
        try {
            String Query =
                "BEGIN LMS_WEB_PKG_GRP_UW.ReEvaluatePensionYear(?,?);END;";


            conn = new DBConnector().getDatabaseConn();
            CallableStatement cstmt = conn.prepareCall(Query);
            cstmt.setBigDecimal(1,
                                (BigDecimal)this.session.getAttribute("policyCode"));

            cstmt.setString(2, (String)this.session.getAttribute("UWYear"));
            cstmt.execute();
            cstmt.close();

            RefeshBalances();

            GlobalCC.sysInformation("ReValuation Successfully Completed.");

            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public String getRevaluedStatus() {
        String revalueStatus = "N";
        Connection conn = null;
        try {
            String Query =
                "begin ? := LMS_WEB_PKG_GRP_UW.get_pens_rev_status(?,?); end;";


            conn = new DBConnector().getDatabaseConn();
            CallableStatement cstmt = conn.prepareCall(Query);
            cstmt.registerOutParameter(1, 12);
            cstmt.setString(2, (String)this.session.getAttribute("UWYear"));
            cstmt.setBigDecimal(3,
                                (BigDecimal)this.session.getAttribute("policyCode"));

            cstmt.execute();
            revalueStatus = cstmt.getString(1);
            cstmt.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return revalueStatus;
    }

    public String SavePeriodicValuation() {
        Connection conn = null;
        try {
            String prdWEFString = null;
            String prdWETString = null;
            String Act = (String)this.session.getAttribute("action");
            if (Act != "D") {
                if (this.prdWEF.getValue() == null) {
                    GlobalCC.sysInformation("Enter A WEF Date");
                    return null;
                }
                if (this.prdWET.getValue() == null) {
                    GlobalCC.sysInformation("Enter A WET Date");
                    return null;
                }
                if (this.session.getAttribute("lpnt_code") == null) {
                    GlobalCC.sysInformation("Select A Rate Table.");
                    return null;
                }
                if (this.prdWEF.getValue().toString().contains(":")) {
                    prdWEFString =
                            GlobalCC.parseDate(this.prdWEF.getValue().toString());
                } else {
                    prdWEFString =
                            GlobalCC.upDateParseDate(this.prdWEF.getValue().toString());
                }
                if (this.prdWET.getValue().toString().contains(":")) {
                    prdWETString =
                            GlobalCC.parseDate(this.prdWET.getValue().toString());
                } else {
                    prdWETString =
                            GlobalCC.upDateParseDate(this.prdWET.getValue().toString());
                }
            }
            String populateTaxes =
                "BEGIN LMS_WEB_PKG_GRP_UW.updatepensionbalancePeriods(?,?,?,?,?,?,?,?,?);END;";


            conn = new DBConnector().getDatabaseConn();

            CallableStatement cstmt = conn.prepareCall(populateTaxes);
            cstmt.setString(1, (String)this.session.getAttribute("action"));
            cstmt.setBigDecimal(2,
                                (BigDecimal)this.session.getAttribute("pnbalpCode"));

            cstmt.setBigDecimal(3,
                                (BigDecimal)this.session.getAttribute("policyCode"));

            cstmt.setString(4, (String)this.session.getAttribute("UWYear"));
            if (this.prdInt.getValue() == null) {
                cstmt.setBigDecimal(5, null);
            } else {
                cstmt.setString(5, this.prdInt.getValue().toString());
            }
            cstmt.setString(6, prdWEFString);
            cstmt.setString(7, prdWETString);
            cstmt.setBigDecimal(8,
                                (BigDecimal)this.session.getAttribute("lpnt_code"));

            cstmt.setString(9, getRevaluedStatus());

            cstmt.execute();
            conn.close();

            ADFUtils.findIterator("FindPensionBalancesPeriodsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.balancesPeriodsLOV);

            ADFUtils.findIterator("FindPensionBalancesPeriodSummaryIterator").executeQuery();

            RefeshBalances();

            GlobalCC.hidePopup("lmsgroup:periodicVal");
            GlobalCC.sysInformation("Valuation Period Successfully Saved.");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
            e.printStackTrace();
        }
        return null;
    }

    public String RateTableSelected() {
        try {
            RowKeySet rowKeySet = this.rateTables.getSelectedRowKeys();
            if (!rowKeySet.iterator().hasNext()) {
                GlobalCC.errorValueNotEntered("Error: No Record Selected");
            }
            Object key2 = rowKeySet.iterator().next();
            this.rateTables.setRowKey(key2);

            JUCtrlValueBinding r =
                (JUCtrlValueBinding)this.rateTables.getRowData();
            if (r == null) {
                GlobalCC.errorValueNotEntered("Error: No Record Selected");
            }
            this.tablesDesc.setValue(r.getAttribute("LPNT_DESC"));
            this.session.setAttribute("lpnt_code",
                                      r.getAttribute("LPNT_CODE"));

            ExtendedRenderKitService erkService =
                (ExtendedRenderKitService)Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                                             ExtendedRenderKitService.class);


            erkService.addScript(FacesContext.getCurrentInstance(),
                                 "var hints = {autodismissNever:false}; AdfPage.PAGE.findComponent('lmsgroup:periodicVal').show(hints);");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String editPensionBalancesSel() {
        try {
            String Authorised = null;

            DCIteratorBinding dciter =
                ADFUtils.findIterator("FindPensionBalancesSummaryIterator");

            RowKeySet set = this.balancesLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                Authorised = (String)r.getAttribute("STATUS");
                if (Authorised.equalsIgnoreCase("Authorised")) {
                    String messages =
                        "You cannot make changes to an Authorised Valuation";

                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                  messages,
                                                                                  messages));


                    return null;
                }
                this.edYear.setValue(r.getAttribute("PNBAL_YEAR"));
                this.edIntRate.setValue(r.getAttribute("PNBAL_INTEREST_RATE"));
                this.edValDate.setValue(r.getAttribute("PNBAL_VALUA_DATE"));
            }
            ExtendedRenderKitService erkService =
                (ExtendedRenderKitService)Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                                             ExtendedRenderKitService.class);


            erkService.addScript(FacesContext.getCurrentInstance(),
                                 "var hints = {autodismissNever:false}; AdfPage.PAGE.findComponent('lmsgroup:valuation').show(hints);");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String editDeductions() {
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("FindPensionDeductionsIterator");

            RowKeySet set = this.allDeductionsLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                this.dedLabel.setValue(r.getAttribute("TT_DESC"));
                this.dedDate.setValue(r.getAttribute("PDED_DATE"));
                this.dedRate.setValue(r.getAttribute("PDED_RATE"));
                this.dedTaxAmt.setValue(r.getAttribute("PDED_TAX_AMT"));
                this.deductTaxAmt.setValue(r.getAttribute("PDED_DEDCT_TAX"));
                this.deductLostInt.setValue(r.getAttribute("PDED_DEDCT_LOST_INT"));
                this.deductEstOrAct.setValue(r.getAttribute("PDED_EST_ACTUAL"));
                this.deductRateOrAmt.setValue(r.getAttribute("PDED_RT_AMT_TYPE"));
                String RateAmt = (String)r.getAttribute("PDED_RT_AMT_TYPE");
                if (RateAmt == null) {
                    this.dedTaxAmt.setValue(null);
                } else if (RateAmt.equalsIgnoreCase("A")) {
                    this.dedRate.setValue(null);
                } else {
                    this.dedTaxAmt.setValue(null);
                }
                this.session.setAttribute("pdedCode",
                                          r.getAttribute("SEL_PDED_CODE"));
            }
            ExtendedRenderKitService erkService =
                (ExtendedRenderKitService)Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                                             ExtendedRenderKitService.class);


            erkService.addScript(FacesContext.getCurrentInstance(),
                                 "var hints = {autodismissNever:false}; AdfPage.PAGE.findComponent('lmsgroup:deduction').show(hints);");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String DeleteDeductions() {
        BigDecimal pdedCode = null;
        Connection conn = null;
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("FindPensionDeductionsIterator");

            RowKeySet set = this.allDeductionsLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                pdedCode = (BigDecimal)r.getAttribute("SEL_PDED_CODE");

                String populateTaxes =
                    "BEGIN LMS_WEB_PKG_GRP.deletedeductions(?);END;";


                conn = new DBConnector().getDatabaseConn();

                CallableStatement cstmt = conn.prepareCall(populateTaxes);
                cstmt.setBigDecimal(1, pdedCode);
                cstmt.execute();
                cstmt.close();
                conn.close();
            }
            ADFUtils.findIterator("FindPensionDeductionsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.allDeductionsLOV);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String SavePensionBalances() {
        Connection conn = null;
        try {
            String todayString = null;
            if (this.edValDate.getValue().toString().contains(":")) {
                todayString =
                        GlobalCC.parseDate(this.edValDate.getValue().toString());
            } else {
                todayString =
                        GlobalCC.upDateParseDate(this.edValDate.getValue().toString());
            }
            String populateTaxes =
                "BEGIN LMS_WEB_PKG_GRP_UW.updatePensionBalances(?,?,?,?,?);END;";


            conn = new DBConnector().getDatabaseConn();

            CallableStatement cstmt = conn.prepareCall(populateTaxes);
            cstmt.setBigDecimal(1,
                                (BigDecimal)this.session.getAttribute("policyCode"));

            cstmt.setString(2, (String)this.session.getAttribute("UWYear"));
            if (this.edIntRate.getValue() == null) {
                cstmt.setBigDecimal(3, null);
            } else {
                cstmt.setString(3, this.edIntRate.getValue().toString());
            }
            if (this.edValDate.getValue() == null) {
                cstmt.setBigDecimal(4, null);
            } else {
                cstmt.setString(4, todayString);
            }
            cstmt.setString(5,
                            (String)this.session.getAttribute("ValuationPeriod"));


            cstmt.execute();
            conn.close();

            ADFUtils.findIterator("FindPensionBalancesSummaryIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.balancesLOV);

            ADFUtils.findIterator("FindPensionDepositInterestIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.interestTable);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public String RefeshBalances() {
        try {
            ADFUtils.findIterator("FindPensionBalancesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.emprBF);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.emprContr);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.emprVol);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.emprWithdrawal);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.emprDepInt);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.emprdepintearn);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.emprCF);


            AdfFacesContext.getCurrentInstance().addPartialTarget(this.empeBF);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.empeContr);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.empeVol);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.empewithdrawal);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.empedepint);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.empeintearnings);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.empeCF);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.totalAmt);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.totalwithdrawal);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.totalCF);

            AdfFacesContext.getCurrentInstance().addPartialTarget(this.schemeFundBF);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.deductions);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.schemeFund);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.retireHeldFund);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.totalFundValue);


            ADFUtils.findIterator("FindPensionDepositInterestIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.interestTable);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String ShowReceipts() {
        Connection conn = null;
        try {
            String authQuery =
                "BEGIN lms_web_pkg_grp_uw.prem_card_transactions(?);END;";

            conn = new DBConnector().getDatabaseConn();

            CallableStatement cstmt = conn.prepareCall(authQuery);
            cstmt.registerOutParameter(1, 3);
            cstmt.execute();
            this.session.setAttribute("ReceiptTransNo",
                                      cstmt.getBigDecimal(1));
            cstmt.close();
            conn.close();
            this.session.setAttribute("recptsThruVal", "Y");
            GlobalCC.RedirectPage("/grctpymt.jspx");
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        }
        return null;
    }

    public String BackToValuation() {
        try {
            this.session.setAttribute("searchTab", "false");
            this.session.setAttribute("detailsTab", "true");
            this.session.setAttribute("withdrawalTab", "false");
            GlobalCC.RedirectPage("/pensionValuation.jspx");
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(null, ex);
        }
        return null;
    }

    public String ProcessPensionBalances() {
        String InterestRate = null;
        String ValuationPeriod = null;
        String ValuationYear = null;
        Connection conn = null;
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("FindPensionBalancesSummaryIterator");

            RowKeySet set = this.balancesLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                ValuationYear = (String)r.getAttribute("PNBAL_YEAR");
                ValuationPeriod = (String)r.getAttribute("PNBAL_PERIOD");
                InterestRate = (String)r.getAttribute("PNBAL_INTEREST_RATE");
                this.edValDate.setValue(r.getAttribute("PNBAL_VALUA_DATE"));
            }
            String todayString;
            if (this.edValDate.getValue() == null) {
                todayString = null;
            } else {
                todayString =
                        GlobalCC.upDateParseDate(this.edValDate.getValue().toString());
            }
            String populateTaxes =
                "BEGIN LMS_WEB_PKG_GRP_UW.process_annual_valuation(?,?,?,?,?);END;";


            conn = new DBConnector().getDatabaseConn();

            CallableStatement cstmt = conn.prepareCall(populateTaxes);
            cstmt.setBigDecimal(1,
                                (BigDecimal)this.session.getAttribute("policyCode"));

            cstmt.setString(2, ValuationYear);
            cstmt.setString(3, todayString);
            cstmt.setString(4, InterestRate);
            cstmt.setString(5, ValuationPeriod);

            cstmt.execute();
            conn.close();

            RefeshBalances();
            GlobalCC.sysInformation("Valuation Successfully Processed");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public String ProcessPeriodBalances() {
        Connection conn = null;
        try {
            if (this.session.getAttribute("pnbalpCode") == null) {
                GlobalCC.sysInformation("Select A Valuation Period");
                return null;
            }
            String populateTaxes =
                "BEGIN LMS_WEB_PKG_GRP_UW.process_periodic_valuation(?,?);END;";

            conn = new DBConnector().getDatabaseConn();
            CallableStatement cstmt = conn.prepareCall(populateTaxes);
            cstmt.setBigDecimal(1,
                                (BigDecimal)this.session.getAttribute("policyCode"));

            cstmt.setBigDecimal(2,
                                (BigDecimal)this.session.getAttribute("pnbalpCode"));

            cstmt.execute();
            cstmt.close();
            ADFUtils.findIterator("FindPensionBalancesPeriodSummaryIterator").executeQuery();

            this.session.setAttribute("pnbalpCode", null);
            ADFUtils.findIterator("FindPensionBalancesPeriodsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.balancesPeriodsLOV);


            GlobalCC.sysInformation("Valuation Successfully Processed");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public String AuthorisePensionBalances() {
        Date ValuationDate = null;
        String ValuationPeriod = null;
        String ValuationYear = null;

        Connection conn = null;
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("FindPensionBalancesSummaryIterator");

            RowKeySet set = this.balancesLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                ValuationYear = (String)r.getAttribute("PNBAL_YEAR");
                ValuationDate = (Date)r.getAttribute("PNBAL_VALUA_DATE");
                ValuationPeriod = (String)r.getAttribute("PNBAL_PERIOD");
                this.edValDate.setValue(r.getAttribute("PNBAL_VALUA_DATE"));
            }
            String todayString;
            if (this.edValDate.getValue() == null) {
                todayString = null;
            } else {
                todayString =
                        GlobalCC.upDateParseDate(this.edValDate.getValue().toString());
            }
            String populateTaxes =
                "BEGIN LMS_WEB_PKG_GRP_UW.auth_annual_valuation(?,?,?,?);END;";


            conn = new DBConnector().getDatabaseConn();

            CallableStatement cstmt = conn.prepareCall(populateTaxes);
            cstmt.setBigDecimal(1,
                                (BigDecimal)this.session.getAttribute("policyCode"));

            cstmt.setString(2, ValuationYear);
            cstmt.setBigDecimal(3,
                                (BigDecimal)this.session.getAttribute("transactionNumber"));

            cstmt.setString(4, ValuationPeriod);

            cstmt.execute();
            conn.close();

            ADFUtils.findIterator("FindPensionBalancesSummaryIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.balancesLOV);

            ADFUtils.findIterator("FindPensionDepositInterestIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.interestTable);

            String messages = "Valuation Authorised";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          messages,
                                                                          messages));
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public String AuthorisePeriodPensionBalances() {
        Connection conn = null;
        try {
            if (this.session.getAttribute("pnbalpCode") == null) {
                GlobalCC.sysInformation("Select A Valuation Period");
                return null;
            }
            String populateTaxes =
                "BEGIN LMS_WEB_PKG_GRP_UW.auth_periodic_valuation(?,?,?);END;";


            conn = new DBConnector().getDatabaseConn();

            CallableStatement cstmt = conn.prepareCall(populateTaxes);
            cstmt.setBigDecimal(1,
                                (BigDecimal)this.session.getAttribute("policyCode"));

            cstmt.setBigDecimal(2,
                                (BigDecimal)this.session.getAttribute("pnbalpCode"));

            cstmt.setBigDecimal(3,
                                (BigDecimal)this.session.getAttribute("transactionNumber"));


            cstmt.execute();
            cstmt.close();
            conn.close();

            ADFUtils.findIterator("FindPensionBalancesPeriodSummaryIterator").executeQuery();

            this.session.setAttribute("pnbalpCode", null);
            ADFUtils.findIterator("FindPensionBalancesPeriodsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.balancesPeriodsLOV);

            ADFUtils.findIterator("FindPensionBalancesSummaryIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.balancesLOV);

            ADFUtils.findIterator("FindPensionDepositInterestIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.interestTable);

            RefeshBalances();

            GlobalCC.sysInformation("Valuation Authorised");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public String SaveDeductions() {
        String RateAmount = null;
        String Rate = null;
        String Amt = null;
        if (this.dedDate.getValue() == null) {
            String messages = "Select A Date";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          messages,
                                                                          messages));


            return null;
        }
        System.out.println("TaxType=" + this.session.getAttribute("taxType"));
        if ((!this.session.getAttribute("taxType").equals("SRG")) &&
            (this.dedTaxAmt.getValue() == null) &&
            (this.dedRate.getValue() == null)) {
            String messages = "Enter A Tax Amount or a Tax Rate";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          messages,
                                                                          messages));


            return null;
        }
        if (this.deductRateOrAmt.getValue() == null) {
            RateAmount = "R";
        } else {
            RateAmount = this.deductRateOrAmt.getValue().toString();
        }
        if (GlobalCC.checkNullValues(this.dedTaxAmt.getValue()) == null) {
            Amt = "N";
        } else {
            String Value = this.dedTaxAmt.getValue().toString();
            if (Value.isEmpty() == true) {
                Amt = "N";
            } else {
                Amt = "Y";
            }
        }
        if (GlobalCC.checkNullValues(this.dedRate.getValue()) == null) {
            Rate = "N";
        } else {
            String Value1 = this.dedRate.getValue().toString();
            if (Value1.isEmpty() == true) {
                Rate = "N";
            } else {
                Rate = "Y";
            }
        }
        if ((RateAmount.equalsIgnoreCase("R")) &&
            (Amt.equalsIgnoreCase("Y"))) {
            GlobalCC.INFORMATIONREPORTING("You have selected Rate. You cannot Input an Amount. " +
                                          this.dedTaxAmt.getValue().toString());

            return null;
        }
        if ((RateAmount.equalsIgnoreCase("A")) &&
            (Rate.equalsIgnoreCase("Y"))) {
            GlobalCC.INFORMATIONREPORTING("You have selected Amount. You cannot Input an Rate.");
            return null;
        }
        Connection conn = null;
        try {
            String populateTaxes =
                "BEGIN LMS_WEB_PKG_GRP.updatepensiondeductions(?,?,?,?,?,?,?,?,?,?,?);END;";


            conn = new DBConnector().getDatabaseConn();

            CallableStatement cstmt = conn.prepareCall(populateTaxes);
            cstmt.setBigDecimal(1,
                                (BigDecimal)this.session.getAttribute("pdedCode"));

            cstmt.setBigDecimal(2,
                                (BigDecimal)this.session.getAttribute("policyCode"));

            cstmt.setBigDecimal(3,
                                (BigDecimal)this.session.getAttribute("ttCode"));
            if (this.dedRate.getValue() == null) {
                cstmt.setString(4, null);
            } else {
                cstmt.setString(4, this.dedRate.getValue().toString());
            }
            if (this.dedTaxAmt.getValue() == null) {
                cstmt.setString(5, null);
            } else {
                cstmt.setString(5, this.dedTaxAmt.getValue().toString());
            }
            if (this.dedDate.getValue().toString().contains(":")) {
                cstmt.setString(6,
                                GlobalCC.parseDate(this.dedDate.getValue().toString()));
            } else {
                cstmt.setString(6,
                                GlobalCC.upDateParseDate(this.dedDate.getValue().toString()));
            }
            cstmt.setString(7, null);
            if (this.deductTaxAmt.getValue() == null) {
                cstmt.setString(8, null);
            } else {
                cstmt.setString(8, this.deductTaxAmt.getValue().toString());
            }
            if (this.deductLostInt.getValue() == null) {
                cstmt.setString(9, null);
            } else {
                cstmt.setString(9, this.deductLostInt.getValue().toString());
            }
            if (this.deductEstOrAct.getValue() == null) {
                cstmt.setString(10, null);
            } else {
                cstmt.setString(10, this.deductEstOrAct.getValue().toString());
            }
            if (this.deductRateOrAmt.getValue() == null) {
                cstmt.setString(11, null);
            } else {
                cstmt.setString(11,
                                this.deductRateOrAmt.getValue().toString());
            }
            cstmt.execute();
            conn.close();

            ADFUtils.findIterator("FindPensionDeductionsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.allDeductionsLOV);
            GlobalCC.hidePopup("lmsgroup:deduction");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public String AddDeduction() {
        this.deductTaxAmt.setValue("N");
        this.deductLostInt.setValue("N");
        this.deductEstOrAct.setValue("A");
        this.deductRateOrAmt.setValue("R");
        this.session.setAttribute("pdedCode", null);
        ADFUtils.findIterator("FindDeductionsIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.deductionsLOV);

        GlobalCC.showPopup("lmsgroup:p1");
        return null;
    }

    public String PopulatePolicyDeductions() {
        Connection conn = null;
        try {
            String populateTaxes =
                "BEGIN LMS_WEB_PKG_GRP.populate_pensiondeductions(?,?);END;";


            conn = new DBConnector().getDatabaseConn();

            CallableStatement cstmt = conn.prepareCall(populateTaxes);
            cstmt.setBigDecimal(1,
                                (BigDecimal)this.session.getAttribute("policyCode"));

            cstmt.setString(2, (String)this.session.getAttribute("UWYear"));

            cstmt.execute();
            cstmt.close();
            conn.close();

            ADFUtils.findIterator("FindPensionDeductionsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.allDeductionsLOV);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public String ComputeDeductions() {
        Connection conn = null;
        try {
            String populateTaxes =
                "BEGIN LMS_WEB_PKG_GRP.computedeductions(?);END;";


            conn = new DBConnector().getDatabaseConn();

            CallableStatement cstmt = conn.prepareCall(populateTaxes);
            cstmt.setBigDecimal(1,
                                (BigDecimal)this.session.getAttribute("policyCode"));

            cstmt.execute();
            conn.close();

            ADFUtils.findIterator("FindPensionDeductionsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.allDeductionsLOV);

            ADFUtils.findIterator("AuthorisedPensionDeductionsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.authDeductions);


            String messages = "Deductions Computed";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          messages,
                                                                          messages));
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public String AuthoriseDeductions() {
        Connection conn = null;
        try {
            String populateTaxes =
                "BEGIN LMS_WEB_PKG_GRP.authorizedeductions(?,?);END;";

            conn = new DBConnector().getDatabaseConn();
            CallableStatement cstmt = conn.prepareCall(populateTaxes);

            DCIteratorBinding dciter =
                ADFUtils.findIterator("FindPensionDeductionsIterator");

            RowKeySet set = this.allDeductionsLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();


                cstmt.setBigDecimal(1,
                                    (BigDecimal)this.session.getAttribute("policyCode"));

                cstmt.setBigDecimal(2,
                                    (BigDecimal)r.getAttribute("SEL_PDED_CODE"));

                cstmt.execute();
            }
            ADFUtils.findIterator("FindPensionDeductionsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.allDeductionsLOV);

            ADFUtils.findIterator("AuthorisedPensionDeductionsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.authDeductions);

            RefeshBalances();
            cstmt.close();
            conn.close();

            GlobalCC.INFORMATIONREPORTING("Deductions Authorised");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public void setEmprBF(RichInputText emprBF) {
        this.emprBF = emprBF;
    }

    public RichInputText getEmprBF() {
        return this.emprBF;
    }

    public void setEmprContr(RichInputText emprContr) {
        this.emprContr = emprContr;
    }

    public RichInputText getEmprContr() {
        return this.emprContr;
    }

    public void setEmprVol(RichInputText emprVol) {
        this.emprVol = emprVol;
    }

    public RichInputText getEmprVol() {
        return this.emprVol;
    }

    public void setEmprWithdrawal(RichInputText emprWithdrawal) {
        this.emprWithdrawal = emprWithdrawal;
    }

    public RichInputText getEmprWithdrawal() {
        return this.emprWithdrawal;
    }

    public void setEmprDepInt(RichInputText emprDepInt) {
        this.emprDepInt = emprDepInt;
    }

    public RichInputText getEmprDepInt() {
        return this.emprDepInt;
    }

    public void setEmprdepintearn(RichInputText emprdepintearn) {
        this.emprdepintearn = emprdepintearn;
    }

    public RichInputText getEmprdepintearn() {
        return this.emprdepintearn;
    }

    public void setEmprCF(RichInputText emprCF) {
        this.emprCF = emprCF;
    }

    public RichInputText getEmprCF() {
        return this.emprCF;
    }

    public void setEmpeBF(RichInputText empeBF) {
        this.empeBF = empeBF;
    }

    public RichInputText getEmpeBF() {
        return this.empeBF;
    }

    public void setEmpeContr(RichInputText empeContr) {
        this.empeContr = empeContr;
    }

    public RichInputText getEmpeContr() {
        return this.empeContr;
    }

    public void setEmpeVol(RichInputText empeVol) {
        this.empeVol = empeVol;
    }

    public RichInputText getEmpeVol() {
        return this.empeVol;
    }

    public void setEmpewithdrawal(RichInputText empewithdrawal) {
        this.empewithdrawal = empewithdrawal;
    }

    public RichInputText getEmpewithdrawal() {
        return this.empewithdrawal;
    }

    public void setEmpedepint(RichInputText empedepint) {
        this.empedepint = empedepint;
    }

    public RichInputText getEmpedepint() {
        return this.empedepint;
    }

    public void setEmpeintearnings(RichInputText empeintearnings) {
        this.empeintearnings = empeintearnings;
    }

    public RichInputText getEmpeintearnings() {
        return this.empeintearnings;
    }

    public void setEmpeCF(RichInputText empeCF) {
        this.empeCF = empeCF;
    }

    public RichInputText getEmpeCF() {
        return this.empeCF;
    }

    public void setTotalAmt(RichInputText totalAmt) {
        this.totalAmt = totalAmt;
    }

    public RichInputText getTotalAmt() {
        return this.totalAmt;
    }

    public void setTotalwithdrawal(RichInputText totalwithdrawal) {
        this.totalwithdrawal = totalwithdrawal;
    }

    public RichInputText getTotalwithdrawal() {
        return this.totalwithdrawal;
    }

    public void setTotalCF(RichInputText totalCF) {
        this.totalCF = totalCF;
    }

    public RichInputText getTotalCF() {
        return this.totalCF;
    }

    public void setBalancesLOV(RichTable balancesLOV) {
        this.balancesLOV = balancesLOV;
    }

    public RichTable getBalancesLOV() {
        return this.balancesLOV;
    }

    public void setEdYear(RichOutputText edYear) {
        this.edYear = edYear;
    }

    public RichOutputText getEdYear() {
        return this.edYear;
    }

    public void setEdIntRate(RichInputText edIntRate) {
        this.edIntRate = edIntRate;
    }

    public RichInputText getEdIntRate() {
        return this.edIntRate;
    }

    public void setEdValDate(RichInputDate edValDate) {
        this.edValDate = edValDate;
    }

    public RichInputDate getEdValDate() {
        return this.edValDate;
    }

    public void setTransType(RichSelectOneChoice transType) {
        this.transType = transType;
    }

    public RichSelectOneChoice getTransType() {
        return this.transType;
    }

    public void setDeductionsLOV(RichTable deductionsLOV) {
        this.deductionsLOV = deductionsLOV;
    }

    public RichTable getDeductionsLOV() {
        return this.deductionsLOV;
    }

    public void setDedLabel(RichOutputText dedLabel) {
        this.dedLabel = dedLabel;
    }

    public RichOutputText getDedLabel() {
        return this.dedLabel;
    }

    public void setDedDate(RichInputDate dedDate) {
        this.dedDate = dedDate;
    }

    public RichInputDate getDedDate() {
        return this.dedDate;
    }

    public void setDedSchVal(RichInputText dedSchVal) {
        this.dedSchVal = dedSchVal;
    }

    public RichInputText getDedSchVal() {
        return this.dedSchVal;
    }

    public void setDedRate(RichInputText dedRate) {
        this.dedRate = dedRate;
    }

    public RichInputText getDedRate() {
        return this.dedRate;
    }

    public void setDedTaxAmt(RichInputText dedTaxAmt) {
        this.dedTaxAmt = dedTaxAmt;
    }

    public RichInputText getDedTaxAmt() {
        return this.dedTaxAmt;
    }

    public void setAllDeductionsLOV(RichTable allDeductionsLOV) {
        this.allDeductionsLOV = allDeductionsLOV;
    }

    public RichTable getAllDeductionsLOV() {
        return this.allDeductionsLOV;
    }

    public String AddWithdrawalAmount() {
        this.session.setAttribute("PNDP_CODE", null);
        this.session.setAttribute("withdrawalReceipt", null);
        this.receiptNumber.setValue(null);
        this.withDate.setValue(null);
        this.withAmount.setValue(null);
        this.withRate.setValue(null);

        ExtendedRenderKitService erkService =
            (ExtendedRenderKitService)Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                                         ExtendedRenderKitService.class);


        erkService.addScript(FacesContext.getCurrentInstance(),
                             "var hints = {autodismissNever:false}; AdfPage.PAGE.findComponent('lmsgroup:pensionsDepositsPopup').show(hints);");


        return null;
    }

    public String EditPensionWithdrawal() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindPensionDepositsIterator");

        RowKeySet set = this.pensWithdrawal.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            this.session.setAttribute("PNDP_CODE",
                                      r.getAttribute("PNDP_CODE"));
            this.receiptNumber.setValue(r.getAttribute("PNDP_CHQ_RCPT_NO"));
            this.amountRateDrop.setValue(r.getAttribute("PNDP_AMT_RATE"));

            this.withDate.setValue(r.getAttribute("PNDP_DATE"));
            String AmtRate = (String)r.getAttribute("PNDP_AMT_RATE");
            if (AmtRate == null) {
                this.amountRateDrop.setValue("A");
                this.amountLabel.setRendered(true);
                this.withAmount.setRendered(true);
                this.rateLabel.setRendered(false);
                this.withRate.setRendered(false);
                this.withRate.setValue(null);
                this.withAmount.setValue(r.getAttribute("PNDP_AMOUNT"));
            } else if (AmtRate.equalsIgnoreCase("A")) {
                this.amountLabel.setRendered(true);
                this.withAmount.setRendered(true);
                this.rateLabel.setRendered(false);
                this.withRate.setRendered(false);
                this.withRate.setValue(null);
                this.withAmount.setValue(r.getAttribute("PNDP_AMOUNT"));
            } else if (AmtRate.equalsIgnoreCase("R")) {
                this.amountLabel.setRendered(false);
                this.withAmount.setRendered(false);
                this.rateLabel.setRendered(true);
                this.withRate.setRendered(true);
                this.withAmount.setValue(null);
                this.withRate.setValue(r.getAttribute("PNDP_WTHDL_RATE"));
            }
            this.session.setAttribute("withdrawalReceipt",
                                      r.getAttribute("PNDP_GRCT_CODE"));
        }
        ExtendedRenderKitService erkService =
            (ExtendedRenderKitService)Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                                         ExtendedRenderKitService.class);


        erkService.addScript(FacesContext.getCurrentInstance(),
                             "var hints = {autodismissNever:false}; AdfPage.PAGE.findComponent('lmsgroup:pensionsDepositsPopup').show(hints);");


        return null;
    }

    public String DeletePensWithdrawal() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindPensionDepositsIterator");

        RowKeySet set = this.pensWithdrawal.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
            this.session.setAttribute("PNDP_CODE",
                                      r.getAttribute("PNDP_CODE"));
        }
        String populateTaxes =
            "BEGIN LMS_WEB_PKG_GRP_PENS.deletePensionDeposit(?);END;";

        Connection conn = null;
        try {
            conn = new DBConnector().getDatabaseConn();

            CallableStatement cstmt = conn.prepareCall(populateTaxes);
            cstmt.setBigDecimal(1,
                                (BigDecimal)this.session.getAttribute("PNDP_CODE"));

            cstmt.execute();
            conn.close();
            this.session.setAttribute("PNDP_CODE", null);
            this.pensPayee.setValue(null);
            ADFUtils.findIterator("FindPensionDepositsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.pensWithdrawal);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.pensPayee);
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        }
        return null;
    }

    public void setReceiptNumber(RichInputText receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public RichInputText getReceiptNumber() {
        return this.receiptNumber;
    }

    public void setWithDate(RichInputDate withDate) {
        this.withDate = withDate;
    }

    public RichInputDate getWithDate() {
        return this.withDate;
    }

    public void setWithAmount(RichInputText withAmount) {
        this.withAmount = withAmount;
    }

    public RichInputText getWithAmount() {
        return this.withAmount;
    }

    public void setWithRate(RichInputText withRate) {
        this.withRate = withRate;
    }

    public RichInputText getWithRate() {
        return this.withRate;
    }

    public String SaveWithdrawalAmount() {
        Connection conn = null;
        try {
            if (this.withDate.getValue() == null) {
                GlobalCC.sysInformation("Enter Withdrawal Date");

                return null;
            }
            if (this.amountRateDrop.getValue() == null) {
                GlobalCC.sysInformation("Select if the Deposit is an Amount or Rate");

                return null;
            }
            DBConnector myConn = new DBConnector();
            conn = myConn.getDatabaseConn();
            CallableStatement cst = null;


            String polQuery =
                "begin LMS_WEB_PKG_GRP_PENS.createPensionDeposits(?,?,?,?,?,?,?,?,?,?,?);end;";

            cst = conn.prepareCall(polQuery);
            cst.setBigDecimal(1,
                              (BigDecimal)this.session.getAttribute("policyCode"));
            if (this.withAmount.getValue() == null) {
                cst.setString(2, null);
            } else {
                cst.setString(2, this.withAmount.getValue().toString());
            }
            cst.setBigDecimal(3,
                              (BigDecimal)this.session.getAttribute("withdrawalReceipt"));
            if (this.withRate.getValue() == null) {
                cst.setString(4, null);
            } else {
                cst.setString(4, this.withRate.getValue().toString());
            }
            if (this.withDate.getValue().toString().contains(":")) {
                cst.setString(5,
                              GlobalCC.parseDate(this.withDate.getValue().toString()));
            } else {
                cst.setString(5,
                              GlobalCC.upDateParseDate(this.withDate.getValue().toString()));
            }
            cst.setBigDecimal(6,
                              (BigDecimal)this.session.getAttribute("PNDP_CODE"));
            if (this.pensPayee.getValue() == null) {
                cst.setString(7, null);
            } else {
                cst.setString(7, this.pensPayee.getValue().toString());
            }
            if (this.amountRateDrop.getValue() == null) {
                cst.setString(8, null);
            } else {
                cst.setString(8, this.amountRateDrop.getValue().toString());
            }
            if (this.paymentMode.getValue() == null) {
                cst.setString(9, null);
            } else {
                cst.setString(9, null);
            }
            cst.setBigDecimal(10,
                              (BigDecimal)this.session.getAttribute("client_bank_code"));
            if (this.bankAccountNo.getValue() == null) {
                cst.setString(11, null);
            } else {
                cst.setString(11, this.bankAccountNo.getValue().toString());
            }
            cst.execute();

            cst.close();
            conn.close();
            GlobalCC.sysInformation("Withdrawal Record Saved Successfully");

            this.session.setAttribute("PNDP_CODE", null);

            ADFUtils.findIterator("FindPensionDepositsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.pensWithdrawal);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.pensPayee);
            GlobalCC.hidePopup("lmsgroup:pensionsDepositsPopup");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public void setPensWithdrawal(RichTable pensWithdrawal) {
        this.pensWithdrawal = pensWithdrawal;
    }

    public RichTable getPensWithdrawal() {
        return this.pensWithdrawal;
    }

    public void setWithPayee(RichOutputLabel withPayee) {
        this.withPayee = withPayee;
    }

    public RichOutputLabel getWithPayee() {
        return this.withPayee;
    }

    public String ComputeWithAmount() {
        Connection conn = null;
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("FindPensionDepositsIterator");

            RowKeySet set = this.pensWithdrawal.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();
                this.session.setAttribute("PNDP_CODE",
                                          r.getAttribute("PNDP_CODE"));
            }
            String populateTaxes =
                "BEGIN LMS_WEB_PKG_GRP_PENS.computePensWithdrawal(?,?);END;";


            conn = new DBConnector().getDatabaseConn();

            CallableStatement cstmt = conn.prepareCall(populateTaxes);
            cstmt.setBigDecimal(1,
                                (BigDecimal)this.session.getAttribute("policyCode"));

            cstmt.setBigDecimal(2,
                                (BigDecimal)this.session.getAttribute("PNDP_CODE"));

            cstmt.execute();
            conn.close();

            ADFUtils.findIterator("FindPensionDepositsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.pensWithdrawal);

            String messages = "Withdrawal Amount Computed Successfully";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          messages,
                                                                          messages));
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public void setPensPayee(RichInputText pensPayee) {
        this.pensPayee = pensPayee;
    }

    public RichInputText getPensPayee() {
        return this.pensPayee;
    }

    public String AuthoriseWithdrawal() {
        Connection conn = null;
        String withinSystem = "Y";
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("FindPensionDepositsIterator");

            RowKeySet set = this.pensWithdrawal.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();
                this.session.setAttribute("PNDP_CODE",
                                          r.getAttribute("PNDP_CODE"));
            }
            if (this.offSystem.getValue() != null) {
                if (this.offSystem.isSelected()) {
                    withinSystem = "N";
                } else {
                    withinSystem = "Y";
                }
            }
            String populateTaxes =
                "BEGIN LMS_WEB_PKG_GRP_PENS.authorisePensWithdrawal(?,?,?,?);END;";


            conn = new DBConnector().getDatabaseConn();

            CallableStatement cstmt = conn.prepareCall(populateTaxes);
            cstmt.setBigDecimal(1,
                                (BigDecimal)this.session.getAttribute("policyCode"));

            cstmt.setBigDecimal(2,
                                (BigDecimal)this.session.getAttribute("PNDP_CODE"));

            cstmt.setString(3, (String)this.pensPayee.getValue());
            cstmt.setString(4, withinSystem);
            cstmt.execute();
            conn.close();

            ADFUtils.findIterator("FindPensionDepositsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.pensWithdrawal);

            String messages = "Withdrawal Amount Authorised";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          messages,
                                                                          messages));
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public void depositsListener(SelectionEvent selectionEvent) {
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("FindPensionDepositsIterator");

            RowKeySet set = this.pensWithdrawal.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();
                this.session.setAttribute("PNDP_CODE",
                                          r.getAttribute("PNDP_CODE"));
                this.pensPayee.setValue(r.getAttribute("PNDP_PAYEE"));
            }
            ADFUtils.findIterator("FindMembersPensionDepositsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.memPensionDeposits);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
    }

    public void setMemPensionDeposits(RichTable memPensionDeposits) {
        this.memPensionDeposits = memPensionDeposits;
    }

    public RichTable getMemPensionDeposits() {
        return this.memPensionDeposits;
    }

    public String DistributeToMembers() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindPensionDepositsIterator");

        RowKeySet set = this.pensWithdrawal.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
            this.session.setAttribute("PNDP_CODE",
                                      r.getAttribute("PNDP_CODE"));
            this.session.setAttribute("GrctCode",
                                      r.getAttribute("PNDP_GRCT_CODE"));

            ADFUtils.findIterator("distributeToMembersIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.allocatedDeposits);


            this.session.setAttribute("searchTab", "false");
            this.session.setAttribute("detailsTab", "false");
            this.session.setAttribute("withdrawalTab", "true");
        }
        return null;
    }

    public String BackToDetails() {
        this.session.setAttribute("receiptTemplateSeq", Integer.valueOf(0));


        this.session.setAttribute("searchTab", "false");
        this.session.setAttribute("detailsTab", "true");
        this.session.setAttribute("withdrawalTab", "false");

        ADFUtils.findIterator("FindMembersPensionDepositsIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.memPensionDeposits);

        return null;
    }

    public void setAllocatedDeposits(RichTable allocatedDeposits) {
        this.allocatedDeposits = allocatedDeposits;
    }

    public RichTable getAllocatedDeposits() {
        return this.allocatedDeposits;
    }

    public String ProcessWithdrawal() {
        Connection conn = null;
        try {
            Integer Value =
                (Integer)this.session.getAttribute("receiptTemplateSeq");
            if (Value.intValue() == 0) {
                GlobalCC.sysInformation("Import a Member Premium Schedule First");
                return null;
            }
            String authQuery =
                "BEGIN lms_web_pkg_grp_uw.process_pension_payments(?,?,?);END;";

            conn = new DBConnector().getDatabaseConn();

            CallableStatement cstmt = conn.prepareCall(authQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)this.session.getAttribute("PNDP_CODE"));

            cstmt.setBigDecimal(2,
                                (BigDecimal)this.session.getAttribute("policyCode"));

            cstmt.setInt(3,
                         ((Integer)this.session.getAttribute("receiptTemplateSeq")).intValue());

            cstmt.execute();
            cstmt.close();

            GlobalCC.sysInformation("Pension Processing Completed Successfully");

            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public void setInterestTable(RichTable interestTable) {
        this.interestTable = interestTable;
    }

    public RichTable getInterestTable() {
        return this.interestTable;
    }

    public void setBalancesPeriodsLOV(RichTable balancesPeriodsLOV) {
        this.balancesPeriodsLOV = balancesPeriodsLOV;
    }

    public RichTable getBalancesPeriodsLOV() {
        return this.balancesPeriodsLOV;
    }

    public void setPensYearp(RichInputText pensYearp) {
        this.pensYearp = pensYearp;
    }

    public RichInputText getPensYearp() {
        return this.pensYearp;
    }

    public void setPensValDatep(RichInputText pensValDatep) {
        this.pensValDatep = pensValDatep;
    }

    public RichInputText getPensValDatep() {
        return this.pensValDatep;
    }

    public void setPensIntRatep(RichInputText pensIntRatep) {
        this.pensIntRatep = pensIntRatep;
    }

    public RichInputText getPensIntRatep() {
        return this.pensIntRatep;
    }

    public void setPensStatusp(RichInputText pensStatusp) {
        this.pensStatusp = pensStatusp;
    }

    public RichInputText getPensStatusp() {
        return this.pensStatusp;
    }

    public void setPensValDateinputp(RichInputDate pensValDateinputp) {
        this.pensValDateinputp = pensValDateinputp;
    }

    public RichInputDate getPensValDateinputp() {
        return this.pensValDateinputp;
    }

    public void setEmprBFP(RichInputText emprBFP) {
        this.emprBFP = emprBFP;
    }

    public RichInputText getEmprBFP() {
        return this.emprBFP;
    }

    public void setEmprContrP(RichInputText emprContrP) {
        this.emprContrP = emprContrP;
    }

    public RichInputText getEmprContrP() {
        return this.emprContrP;
    }

    public void setEmprVolP(RichInputText emprVolP) {
        this.emprVolP = emprVolP;
    }

    public RichInputText getEmprVolP() {
        return this.emprVolP;
    }

    public void setEmprWithdrawalP(RichInputText emprWithdrawalP) {
        this.emprWithdrawalP = emprWithdrawalP;
    }

    public RichInputText getEmprWithdrawalP() {
        return this.emprWithdrawalP;
    }

    public void setEmprDepIntP(RichInputText emprDepIntP) {
        this.emprDepIntP = emprDepIntP;
    }

    public RichInputText getEmprDepIntP() {
        return this.emprDepIntP;
    }

    public void setEmprdepintearnP(RichInputText emprdepintearnP) {
        this.emprdepintearnP = emprdepintearnP;
    }

    public RichInputText getEmprdepintearnP() {
        return this.emprdepintearnP;
    }

    public void setEmprCFP(RichInputText emprCFP) {
        this.emprCFP = emprCFP;
    }

    public RichInputText getEmprCFP() {
        return this.emprCFP;
    }

    public void setEmpeBFP(RichInputText empeBFP) {
        this.empeBFP = empeBFP;
    }

    public RichInputText getEmpeBFP() {
        return this.empeBFP;
    }

    public void setEmpeContrP(RichInputText empeContrP) {
        this.empeContrP = empeContrP;
    }

    public RichInputText getEmpeContrP() {
        return this.empeContrP;
    }

    public void setEmpeVolP(RichInputText empeVolP) {
        this.empeVolP = empeVolP;
    }

    public RichInputText getEmpeVolP() {
        return this.empeVolP;
    }

    public void setEmpewithdrawalP(RichInputText empewithdrawalP) {
        this.empewithdrawalP = empewithdrawalP;
    }

    public RichInputText getEmpewithdrawalP() {
        return this.empewithdrawalP;
    }

    public void setEmpedepintP(RichInputText empedepintP) {
        this.empedepintP = empedepintP;
    }

    public RichInputText getEmpedepintP() {
        return this.empedepintP;
    }

    public void setEmpeintearningsP(RichInputText empeintearningsP) {
        this.empeintearningsP = empeintearningsP;
    }

    public RichInputText getEmpeintearningsP() {
        return this.empeintearningsP;
    }

    public void setEmpeCFP(RichInputText empeCFP) {
        this.empeCFP = empeCFP;
    }

    public RichInputText getEmpeCFP() {
        return this.empeCFP;
    }

    public void setTotalAmtP(RichInputText totalAmtP) {
        this.totalAmtP = totalAmtP;
    }

    public RichInputText getTotalAmtP() {
        return this.totalAmtP;
    }

    public void setTotalwithdrawalP(RichInputText totalwithdrawalP) {
        this.totalwithdrawalP = totalwithdrawalP;
    }

    public RichInputText getTotalwithdrawalP() {
        return this.totalwithdrawalP;
    }

    public void setTotalCFP(RichInputText totalCFP) {
        this.totalCFP = totalCFP;
    }

    public RichInputText getTotalCFP() {
        return this.totalCFP;
    }

    public void setPrdYear(RichOutputText prdYear) {
        this.prdYear = prdYear;
    }

    public RichOutputText getPrdYear() {
        return this.prdYear;
    }

    public void setPrdWEF(RichInputDate prdWEF) {
        this.prdWEF = prdWEF;
    }

    public RichInputDate getPrdWEF() {
        return this.prdWEF;
    }

    public void setPrdWET(RichInputDate prdWET) {
        this.prdWET = prdWET;
    }

    public RichInputDate getPrdWET() {
        return this.prdWET;
    }

    public void setPrdInt(RichInputNumberSpinbox prdInt) {
        this.prdInt = prdInt;
    }

    public RichInputNumberSpinbox getPrdInt() {
        return this.prdInt;
    }

    public void setRateTables(RichTable rateTables) {
        this.rateTables = rateTables;
    }

    public RichTable getRateTables() {
        return this.rateTables;
    }

    public void setTablesDesc(RichInputText tablesDesc) {
        this.tablesDesc = tablesDesc;
    }

    public RichInputText getTablesDesc() {
        return this.tablesDesc;
    }

    public void setWithdrawalTab(RichPanelBox withdrawalTab) {
        this.withdrawalTab = withdrawalTab;
    }

    public RichPanelBox getWithdrawalTab() {
        return this.withdrawalTab;
    }

    public void amountRateListener(ValueChangeEvent valueChangeEvent) {
        if (valueChangeEvent.getOldValue() != valueChangeEvent.getNewValue()) {
            if (this.amountRateDrop.getValue() == null) {
                this.amountLabel.setRendered(true);
                this.withAmount.setRendered(true);
                this.rateLabel.setRendered(false);
                this.withRate.setRendered(false);
                this.withAmount.setValue(null);
                this.withRate.setValue(null);
                this.amountRateDrop.setValue("A");
            } else if (this.amountRateDrop.getValue().toString().equalsIgnoreCase("A")) {
                this.amountLabel.setRendered(true);
                this.withAmount.setRendered(true);
                this.rateLabel.setRendered(false);
                this.withRate.setRendered(false);
                this.withAmount.setValue(null);
                this.withRate.setValue(null);
            } else if (this.amountRateDrop.getValue().toString().equalsIgnoreCase("R")) {
                this.amountLabel.setRendered(false);
                this.withAmount.setRendered(false);
                this.rateLabel.setRendered(true);
                this.withRate.setRendered(true);
                this.withAmount.setValue(null);
                this.withRate.setValue(null);
            }
        }
    }

    public void setAmountRateDrop(RichSelectOneChoice amountRateDrop) {
        this.amountRateDrop = amountRateDrop;
    }

    public RichSelectOneChoice getAmountRateDrop() {
        return this.amountRateDrop;
    }

    public void setRateLabel(RichOutputLabel rateLabel) {
        this.rateLabel = rateLabel;
    }

    public RichOutputLabel getRateLabel() {
        return this.rateLabel;
    }

    public void setAmountLabel(RichOutputLabel amountLabel) {
        this.amountLabel = amountLabel;
    }

    public RichOutputLabel getAmountLabel() {
        return this.amountLabel;
    }

    public void setEmpyrErndDepInt(RichInputText empyrErndDepInt) {
        this.empyrErndDepInt = empyrErndDepInt;
    }

    public RichInputText getEmpyrErndDepInt() {
        return this.empyrErndDepInt;
    }

    public void setEmpyrErndBalInt(RichInputText empyrErndBalInt) {
        this.empyrErndBalInt = empyrErndBalInt;
    }

    public RichInputText getEmpyrErndBalInt() {
        return this.empyrErndBalInt;
    }

    public void setEmpyeErndBalInt(RichInputText empyeErndBalInt) {
        this.empyeErndBalInt = empyeErndBalInt;
    }

    public RichInputText getEmpyeErndBalInt() {
        return this.empyeErndBalInt;
    }

    public void setEmpyedepintearnP(RichInputText empyedepintearnP) {
        this.empyedepintearnP = empyedepintearnP;
    }

    public RichInputText getEmpyedepintearnP() {
        return this.empyedepintearnP;
    }

    public void setSchemeFundBF(RichInputText schemeFundBF) {
        this.schemeFundBF = schemeFundBF;
    }

    public RichInputText getSchemeFundBF() {
        return this.schemeFundBF;
    }

    public void setDeductions(RichInputText deductions) {
        this.deductions = deductions;
    }

    public RichInputText getDeductions() {
        return this.deductions;
    }

    public void setSchemeFund(RichInputText schemeFund) {
        this.schemeFund = schemeFund;
    }

    public RichInputText getSchemeFund() {
        return this.schemeFund;
    }

    public void setRetireHeldFund(RichInputText retireHeldFund) {
        this.retireHeldFund = retireHeldFund;
    }

    public RichInputText getRetireHeldFund() {
        return this.retireHeldFund;
    }

    public void setTotalFundValue(RichInputText totalFundValue) {
        this.totalFundValue = totalFundValue;
    }

    public RichInputText getTotalFundValue() {
        return this.totalFundValue;
    }

    public void setAuthDeductions(RichTable authDeductions) {
        this.authDeductions = authDeductions;
    }

    public RichTable getAuthDeductions() {
        return this.authDeductions;
    }

    public void setRevalButton(RichCommandButton revalButton) {
        this.revalButton = revalButton;
    }

    public RichCommandButton getRevalButton() {
        return this.revalButton;
    }

    public String contraValuation() {
        return null;
    }

    public void setBankNameLabel(RichOutputLabel bankNameLabel) {
        this.bankNameLabel = bankNameLabel;
    }

    public RichOutputLabel getBankNameLabel() {
        return this.bankNameLabel;
    }

    public void setBankNameTF(RichInputText bankNameTF) {
        this.bankNameTF = bankNameTF;
    }

    public RichInputText getBankNameTF() {
        return this.bankNameTF;
    }

    public void setBankAccountNo(RichInputText bankAccountNo) {
        this.bankAccountNo = bankAccountNo;
    }

    public RichInputText getBankAccountNo() {
        return this.bankAccountNo;
    }

    public void setBankAccNoLab(RichOutputLabel bankAccNoLab) {
        this.bankAccNoLab = bankAccNoLab;
    }

    public RichOutputLabel getBankAccNoLab() {
        return this.bankAccNoLab;
    }

    public void paymentModeSelectAction(ValueChangeEvent valueChangeEvent) {
        if (valueChangeEvent.getOldValue() != valueChangeEvent.getNewValue()) {
            if (this.paymentMode.getValue().toString().equalsIgnoreCase("EFT")) {
                this.bankNameLab.setRendered(true);
                this.bankNameTF.setRendered(true);
                this.bankAccNoLab.setRendered(true);
                this.bankAccountNo.setRendered(true);
                this.bankDetailsBut.setRendered(true);

                AdfFacesContext.getCurrentInstance().addPartialTarget(this.pensWithdrawalTab);
            } else {
                this.bankNameLab.setRendered(false);
                this.bankNameTF.setRendered(false);
                this.bankAccNoLab.setRendered(false);
                this.bankAccountNo.setRendered(false);
                this.bankDetailsBut.setRendered(false);

                AdfFacesContext.getCurrentInstance().addPartialTarget(this.pensWithdrawalTab);
            }
        }
    }

    public void setPaymentMode(RichSelectOneChoice paymentMode) {
        this.paymentMode = paymentMode;
    }

    public RichSelectOneChoice getPaymentMode() {
        return this.paymentMode;
    }

    public String selectBank() {
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("FindClientBankDetailsIterator");

            RowKeySet set = this.clientBankLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();
                this.session.setAttribute("client_bank_code",
                                          r.getAttribute("BBR_CODE"));

                this.bankNameTF.setValue(r.getAttribute("BBR_BRANCH_NAME"));
                System.out.println("Branch Name" +
                                   r.getAttribute("BBR_BRANCH_NAME"));


                GlobalCC.showPopup("lmsgroup:pensionsDepositsPopup");
            }
        } catch (Exception e) {
            e = e;
            GlobalCC.EXCEPTIONREPORTING(null, e);
        } finally {
        }
        return null;
    }

    public void setClientBankLOV(RichTable clientBankLOV) {
        this.clientBankLOV = clientBankLOV;
    }

    public RichTable getClientBankLOV() {
        return this.clientBankLOV;
    }

    public void setBankNameLab(RichOutputLabel bankNameLab) {
        this.bankNameLab = bankNameLab;
    }

    public RichOutputLabel getBankNameLab() {
        return this.bankNameLab;
    }

    public void setBankDetailsBut(RichCommandButton bankDetailsBut) {
        this.bankDetailsBut = bankDetailsBut;
    }

    public RichCommandButton getBankDetailsBut() {
        return this.bankDetailsBut;
    }

    public void setPensWithdrawalTab(RichPanelBox pensWithdrawalTab) {
        this.pensWithdrawalTab = pensWithdrawalTab;
    }

    public RichPanelBox getPensWithdrawalTab() {
        return this.pensWithdrawalTab;
    }

    public String findProductsSelectedII() {
        return null;
    }

    public String ClearSearch() {
        return null;
    }

    public String SearchResults() {
        return null;
    }

    public String SelectAll() {
        return null;
    }

    public String UnSelectAll() {
        return null;
    }

    public String PrepareEmassValuations() {
        return null;
    }

    public String AuthoriseEmassValuations() {
        return null;
    }

    public void ValuationListener(ValueChangeEvent valueChangeEvent) {
    }

    public void setKnockCbox(RichSelectBooleanCheckbox knockCbox) {
        this.knockCbox = knockCbox;
    }

    public RichSelectBooleanCheckbox getKnockCbox() {
        return this.knockCbox;
    }

    public void setRevalRefLOV(RichTable revalRefLOV) {
        this.revalRefLOV = revalRefLOV;
    }

    public RichTable getRevalRefLOV() {
        return this.revalRefLOV;
    }

    public String authRefund() {
        Connection conn = null;
        try {
            conn = new DBConnector().getDatabaseConn();
            String authQuery =
                "BEGIN LMS_WEB_PKG_GRP.Authorise_Revaluation_Refund(?,?,?);END;";

            CallableStatement cstmt = conn.prepareCall(authQuery);
            DCIteratorBinding dciter =
                ADFUtils.findIterator("valuation_refundsIterator");

            RowKeySet set = this.revalRefLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();
                cstmt.setBigDecimal(1,
                                    (BigDecimal)this.session.getAttribute("policyCode"));

                cstmt.setBigDecimal(2,
                                    (BigDecimal)r.getAttribute("PPV_VOUCHER_NO"));

                cstmt.setString(3,
                                (String)this.session.getAttribute("UWYear"));
            }
            cstmt.execute();
            cstmt.close();
            conn.close();
            ADFUtils.findIterator("valuation_refundsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.revalRefLOV);
            GlobalCC.sysInformation("Vouchers successfully authorised...");
        } catch (Exception e) {
            e = e;
            GlobalCC.EXCEPTIONREPORTING(conn, e);
            e.printStackTrace();
        } finally {
        }
        return null;
    }

    public String reverseDeduction() {
        Connection conn = null;
        try {
            conn = new DBConnector().getDatabaseConn();
            String authQuery =
                "BEGIN LMS_WEB_PKG_GRP.reversedeductions(?,?);END;";

            CallableStatement cstmt = conn.prepareCall(authQuery);
            DCIteratorBinding dciter =
                ADFUtils.findIterator("AuthorisedPensionDeductionsIterator");

            RowKeySet set = this.authDeductions.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();
                cstmt.setBigDecimal(1,
                                    (BigDecimal)r.getAttribute("AUTH_SEL_PDED_CODE"));

                cstmt.setString(2,
                                (String)this.session.getAttribute("Username"));
            }
            cstmt.execute();
            cstmt.close();
            conn.close();
            ADFUtils.findIterator("AuthorisedPensionDeductionsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.authDeductions);
            GlobalCC.sysInformation("Vouchers successfully authorised...");
        } catch (Exception e) {
            e = e;
            GlobalCC.EXCEPTIONREPORTING(conn, e);
            e.printStackTrace();
        } finally {
        }
        return null;
    }

    public void setOffSystem(RichSelectBooleanCheckbox offSystem) {
        this.offSystem = offSystem;
    }

    public RichSelectBooleanCheckbox getOffSystem() {
        return this.offSystem;
    }

    public void setDeductTaxAmt(RichSelectOneChoice deductTaxAmt) {
        this.deductTaxAmt = deductTaxAmt;
    }

    public RichSelectOneChoice getDeductTaxAmt() {
        return this.deductTaxAmt;
    }

    public void setDeductLostInt(RichSelectOneChoice deductLostInt) {
        this.deductLostInt = deductLostInt;
    }

    public RichSelectOneChoice getDeductLostInt() {
        return this.deductLostInt;
    }

    public void setDeductRateOrAmt(RichSelectOneChoice deductRateOrAmt) {
        this.deductRateOrAmt = deductRateOrAmt;
    }

    public RichSelectOneChoice getDeductRateOrAmt() {
        return this.deductRateOrAmt;
    }

    public void setDeductEstOrAct(RichSelectOneChoice deductEstOrAct) {
        this.deductEstOrAct = deductEstOrAct;
    }

    public RichSelectOneChoice getDeductEstOrAct() {
        return this.deductEstOrAct;
    }

    public String searchBankDetails() {
        if (bankDetailsTF.getValue() != null) {
            session.setAttribute("BankSearchString",
                                 bankDetailsTF.getValue().toString());
        }
        ADFUtils.findIterator("FindClientBankDetailsIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.clientBankLOV);
        GlobalCC.showPopup("lmsgroup:pensionsDepositsPopup");
        return null;
    }

    public void setBankDetailsTF(RichInputText bankDetailsTF) {
        this.bankDetailsTF = bankDetailsTF;
    }

    public RichInputText getBankDetailsTF() {
        return bankDetailsTF;
    }

    public String launchBankPopup() {
        // Add event code here...
        GlobalCC.showPopup("lmsgroup:bank_details");
        return null;
    }

    public String memberBalanceRedirect() {
        // Add event code here...
        System.out.println("Year selected is" +
                           session.getAttribute("UWYear"));
        System.out.println("Policy code is " +
                           this.session.getAttribute("policyCode"));
        GlobalCC.RedirectPage("/memberbalances.jspx");

        return null;
    }

    public void pensionMemListener(SelectionEvent selectionEvent) {
        // Add event code here...
        Object key2 = this.pensionMemberDAO.getSelectedRowData();
        if (key2 == null) {
            GlobalCC.errorValueNotEntered("No Record Selected");
        }
        JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
        if (r == null) {
            GlobalCC.errorValueNotEntered("No Record Selected");
        }
        session.setAttribute("PolmCode", r.getAttribute("polmCode"));
        ADFUtils.findIterator("findPensionMembersDetailsIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.pensionMemNo);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.pensionMemName);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.pensionMemSex);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.pensionMemDob);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.pensionMemIdNo);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.pensionMemPinNo);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.pensionPhoneNumber);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.pensionEmailAddress);

        ADFUtils.findIterator("findPensionMemberStatementIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.pensionTransactionsDAO);

        ADFUtils.findIterator("findPensionMemberWithdrawalIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.memWithdrawalDAO);


    }

    public void setPensionMemberDAO(RichTable pensionMemberDAO) {
        this.pensionMemberDAO = pensionMemberDAO;
    }

    public RichTable getPensionMemberDAO() {
        return pensionMemberDAO;
    }

    public void setPensionMemNo(RichInputText pensionMemNo) {
        this.pensionMemNo = pensionMemNo;
    }

    public RichInputText getPensionMemNo() {
        return pensionMemNo;
    }

    public void setPensionMemName(RichInputText pensionMemName) {
        this.pensionMemName = pensionMemName;
    }

    public RichInputText getPensionMemName() {
        return pensionMemName;
    }

    public void setPensionMemSex(RichSelectOneChoice pensionMemSex) {
        this.pensionMemSex = pensionMemSex;
    }

    public RichSelectOneChoice getPensionMemSex() {
        return pensionMemSex;
    }

    public void setPensionMemDob(RichInputDate pensionMemDob) {
        this.pensionMemDob = pensionMemDob;
    }

    public RichInputDate getPensionMemDob() {
        return pensionMemDob;
    }

    public void setPensionMemIdNo(RichInputText pensionMemIdNo) {
        this.pensionMemIdNo = pensionMemIdNo;
    }

    public RichInputText getPensionMemIdNo() {
        return pensionMemIdNo;
    }

    public void setPensionMemPinNo(RichInputText pensionMemPinNo) {
        this.pensionMemPinNo = pensionMemPinNo;
    }

    public RichInputText getPensionMemPinNo() {
        return pensionMemPinNo;
    }

    public void setPensionPhoneNumber(RichInputText pensionPhoneNumber) {
        this.pensionPhoneNumber = pensionPhoneNumber;
    }

    public RichInputText getPensionPhoneNumber() {
        return pensionPhoneNumber;
    }

    public void setPensionEmailAddress(RichInputText pensionEmailAddress) {
        this.pensionEmailAddress = pensionEmailAddress;
    }

    public RichInputText getPensionEmailAddress() {
        return pensionEmailAddress;
    }

    public void setPensionTransactionsDAO(RichTable pensionTransactionsDAO) {
        this.pensionTransactionsDAO = pensionTransactionsDAO;
    }

    public RichTable getPensionTransactionsDAO() {
        return pensionTransactionsDAO;
    }

    public void setMemWithdrawalDAO(RichTable memWithdrawalDAO) {
        this.memWithdrawalDAO = memWithdrawalDAO;
    }

    public RichTable getMemWithdrawalDAO() {
        return memWithdrawalDAO;
    }

    public void setMemNameSearch(RichInputText memNameSearch) {
        this.memNameSearch = memNameSearch;
    }

    public RichInputText getMemNameSearch() {
        return memNameSearch;
    }

    public void setMemNoSearch(RichInputText memNoSearch) {
        this.memNoSearch = memNoSearch;
    }

    public RichInputText getMemNoSearch() {
        return memNoSearch;
    }

    public void setMemTelePhoneSearch(RichInputText memTelePhoneSearch) {
        this.memTelePhoneSearch = memTelePhoneSearch;
    }

    public RichInputText getMemTelePhoneSearch() {
        return memTelePhoneSearch;
    }

    public void setMemIdNoSearch(RichInputText memIdNoSearch) {
        this.memIdNoSearch = memIdNoSearch;
    }

    public RichInputText getMemIdNoSearch() {
        return memIdNoSearch;
    }

    public String searchPensionMember() {
        // Add event code here...
        session.setAttribute("memNameSearch", memNameSearch.getValue());
        session.setAttribute("memNoSearch", memNoSearch.getValue());
        session.setAttribute("memTelePhoneSearch", memTelePhoneSearch.getValue());
        session.setAttribute("memIdNoSearch", memIdNoSearch.getValue());
        
        ADFUtils.findIterator("findPensionMembersIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.pensionMemberDAO);
        
        return null;
    }

    public String showBeneficiaryPopup() {
        // Add event code here...
        GlobalCC.showPopup("lmsgroup:p1");
        return null;
    }

    public void setRelationDAO(RichTable relationDAO) {
        this.relationDAO = relationDAO;
    }

    public RichTable getRelationDAO() {
        return relationDAO;
    }

    public void setRelationTypeTF(RichInputText relationTypeTF) {
        this.relationTypeTF = relationTypeTF;
    }

    public RichInputText getRelationTypeTF() {
        return relationTypeTF;
    }

    public String selectRelationType() {
        // Add event code here...
        Object key2 = relationDAO.getSelectedRowData();
        if (key2 == null) {
            GlobalCC.errorValueNotEntered("No Record Selected");
            return null;
        }
        JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
        if (r == null) {
            GlobalCC.errorValueNotEntered("No Record Selected");
            return null;
        }
        relationTypeTF.setValue(r.getAttribute("retDesc"));
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.relationTypeTF);
        GlobalCC.hidePopup("lmsgroup:p2");
        return null;
    }

    public void setMemSurname(RichInputText memSurname) {
        this.memSurname = memSurname;
    }

    public RichInputText getMemSurname() {
        return memSurname;
    }

    public void setMemSurnameTF(RichInputText memSurnameTF) {
        this.memSurnameTF = memSurnameTF;
    }

    public RichInputText getMemSurnameTF() {
        return memSurnameTF;
    }

    public void setMemOtherNameTF(RichInputText memOtherNameTF) {
        this.memOtherNameTF = memOtherNameTF;
    }

    public RichInputText getMemOtherNameTF() {
        return memOtherNameTF;
    }

    public void setMemDobTF(RichInputDate memDobTF) {
        this.memDobTF = memDobTF;
    }

    public RichInputDate getMemDobTF() {
        return memDobTF;
    }

    public void setMemGender(RichSelectOneChoice memGender) {
        this.memGender = memGender;
    }

    public RichSelectOneChoice getMemGender() {
        return memGender;
    }

    public void setMemIdNumberTF(RichInputText memIdNumberTF) {
        this.memIdNumberTF = memIdNumberTF;
    }

    public RichInputText getMemIdNumberTF() {
        return memIdNumberTF;
    }

    public void setMemShareTF(RichInputText memShareTF) {
        this.memShareTF = memShareTF;
    }

    public RichInputText getMemShareTF() {
        return memShareTF;
    }

    public String saveRelationType() {
        Connection conn=null;
        conn = new DBConnector().getDatabaseConn();
        try{
        String authQuery =
            "BEGIN LMS_WEB_PKG_GRP.Authorise_Revaluation_Refund(?,?,?);END;";
            
            }catch(Exception ex)
            {
            ex.printStackTrace();
            }
        return null;
    }
}
