package com.turnkey.setups;

import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.Connection;


import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import javax.servlet.http.HttpSession;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.data.RichColumn;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.data.RichTree;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputNumberSpinbox;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanCheckbox;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.input.RichSelectOneRadio;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.output.RichOutputLabel;
import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.Key;
import oracle.jbo.Row;

import oracle.jbo.uicli.binding.JUCtrlHierNodeBinding;
import oracle.jbo.uicli.binding.JUCtrlValueBinding;

import oracle.jdbc.OracleTypes;

import org.apache.myfaces.trinidad.event.SelectionEvent;
import org.apache.myfaces.trinidad.model.RowKeySet;

import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

import LMSG.view.Base.ADFUtils;

import LMSG.view.Base.GlobalCC;

import LMSG.view.Base.LOVCC;

import LMSG.view.connect.DBConnector;

import java.util.Date;

import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.layout.RichPanelBox;

import oracle.jdbc.OracleCallableStatement;


public class otherSetupsManip {
    private RichTable lifeClassLOV;
    private RichTable occupationsLOV;
    private RichInputText id;
    private RichInputText desc;
    private RichSelectOneChoice hazardous;
    private RichSelectOneChoice ovProdCode;
    private RichInputText occId;
    private RichInputText occDesc;
    private RichSelectOneChoice occHazardous;
    private RichTable riRatesLOV;
    private RichTable groupLOV;
    private RichInputText classId;
    private RichInputText anbFrom;
    private RichInputText anbTo;
    private RichInputText rate;
    private RichInputText divFac;
    private RichSelectOneChoice rateType;
    private RichInputDate wef;
    private RichInputDate wet;
    private RichTable riRatesDescLOV;
    private RichInputDate rtWef;
    private RichInputDate rtWet;
    private RichInputText lapsedTermTo;
    private RichInputText lapsedTermFrm;
    private RichInputText polTermTo;
    private RichInputText polTermFrm;
    private RichColumn arrangementsSetUpLov;
    private RichTable arrangementSetupsLOV;
    private RichInputText treatyShtDesc;
    private RichInputText treatyDesc;
    private RichSelectOneChoice treatyType;
    private RichTable treatyArrangmentsLOV;
    private RichInputText arragementYear;
    private RichTable treatyProductsLOV;
    private RichTable treatyProdCoverTypesLOV;
    private RichCommandButton credShtDesc;
    private RichInputText credGroup;
    private RichInputText crdShtDesc;
    private RichTable creditGroupsLOV;
    private RichTable creditCriterionLOV;
    private RichInputText creditCriteria;
    private RichSelectOneRadio clientAgentOption;
    private RichInputText interMediary;
    private RichTable intermediaryLOV;
    private RichTable intermedCredGroupLOV;
    private RichInputText interMedCrditGroup;
    private RichTable creditGroupsActionLOV;
    private RichInputText creditActionGroup;
    private RichSelectOneChoice creditDays;
    private RichSelectOneChoice creditAction;
    private RichSelectOneChoice creditWaiver;
    private RichTable creditGroupActionsLOV;
    private RichInputText coverID;
    private RichInputText coverDescription;
    private RichSelectOneChoice mainCover;
    private RichInputText maximumAge;
    private RichInputText multiplier;
    private RichInputText divisionFactor;
    private RichSelectOneChoice cvtReadFrom;
    private RichSelectOneChoice cvtRateType;
    private RichInputText cvtReportName;
    private RichInputText cvtRemarks;
    private RichSelectOneChoice paRatesFreqOfPymt;
    private RichTable coverTypesLOV;
    private RichSelectOneChoice durationType;
    private RichTable coverTypesClassLOV;
    private RichTable coverTypesProductsLOV;
    private RichTable productCoverTypesLOV;
    private RichInputText coverTypeDesc;
    private RichTable prodCoversLOV;
    private RichInputText maxAssureds;
    private RichInputText covermaximumAge;
    private RichSelectOneChoice coverFormula;
    private RichSelectOneChoice coverRefundFormula;
    private RichInputText coverMainSAPerc;
    private RichInputText coverMaximumSA;
    private RichSelectOneChoice coverRatesDependOnLifeClass;
    private RichSelectOneChoice coverAccelerator;
    private RichSelectOneChoice coverMandatory;
    private RichSelectOneChoice coverGroupSingle;
    private RichSelectOneChoice coverInbuilt;
    private RichTree productTree;
    private RichInputText prodShtDesc;
    private RichPanelGroupLayout prOD_CODE;
    private RichPanelGroupLayout prodPanGrp;
    private RichInputText productDesc;
    private RichSelectOneChoice prodType;
    private RichInputText prodMinAgeLimit;
    private RichSelectOneChoice payGratuity;
    private RichInputText prodMaxAgeLimit;
    private RichInputText prodMinTermYrs;
    private RichSelectOneChoice annuityAllowed;
    private RichInputText claimPrefixCode;
    private RichSelectOneChoice openCover;
    private RichInputText polPrefixCode;
    private RichInputText proposalPrefix;
    private RichInputText cancellationNotice;
    private RichSelectOneChoice xolAllowed;
    private RichInputText reinsMaxPeriod;
    private RichSelectOneChoice loanProduct;
    private RichSelectOneChoice savingsCovered;
    private RichSelectOneChoice osLoanCalc;
    private RichInputDate defaultDOB;
    private RichSelectOneChoice refundCommission;
    private RichSelectOneChoice refundAllowed;
    private RichSelectOneChoice initialScheEndorse;
    private RichSelectOneChoice productCovers;
    private RichSelectOneChoice partialCancellationAllowed;
    private RichInputText claimExpiryPeriod;
    private RichInputText productDebitAccNo;
    private RichSelectOneChoice unitRateApplicable;
    private RichSelectOneChoice applicableLapseType;
    private RichInputText prodMinEarningsPeriod;
    private RichInputText expectedScheduleReceptDay;
    private RichSelectOneChoice autoGeneratePolicyNo;
    private RichOutputLabel minimumFCLMembers;
    private RichInputText minimumFCLAmount;
    private RichSelectOneChoice extensionAllowed;
    private RichInputText renewalAllowed;
    private RichInputText fctFactor1;
    private RichInputText scheduleAdjustmentPeriod;
    private RichInputText profitShareRate;
    private RichInputText fclFactor2;
    private RichInputText minFCLMembers;
    private RichInputText maximumFCLAmount;
    private RichSelectOneChoice extAllowed;
    private RichSelectOneChoice renAllowed;
    private RichInputText maximumExtensionPrd;
    private RichInputText addRefPremRate;
    private RichInputText groupMinimumMembers;
    private RichInputText prodGLControlCode;
    private RichInputText empPensionPrdPay;
    private RichSelectOneChoice allowGracePeriod;
    private RichSelectOneChoice emvCalculationType;
    private RichSelectOneChoice valuationIntrCalc;
    private RichTable deathAcceptableLOV;
    private RichInputText deathTotalNo;
    private RichInputText deathAcceptableNo;
    private RichInputText quarterlyRate;
    private RichTable premiumFractionsLOV;
    private RichTable annualPremiumFractionsLOV;
    private RichInputText monthlyToAnnRate;
    private RichInputText semiToMonthlyRate;
    private RichInputText annualToMonthlyRate;
    private RichInputText annToMonthlyRate;
    private RichInputText semiToAnnualRate;
    private RichInputText annualToQuarterlyRate;
    private RichTable scheduleReportsLOV;
    private RichInputText quotationCosting;
    private RichInputText quotationSavings;
    private RichInputText quotationFuneral;
    private RichInputText aggregateCosting;
    private RichInputText uwCosting;
    private RichInputText uwSavings;
    private RichInputText uwFuneral;
    private RichInputText uwRefund;
    private RichInputText polCosting;
    private RichInputText polSavings;
    private RichInputText policyFuneral;
    private RichInputText renewalCosting;
    private RichInputText renewalSavings;
    private RichInputText renewalFuneral;
    private RichInputText monthlyLapsationPeriod;
    private RichInputText quarterlyLapsationPeriod;
    private RichInputText semiAnnualLapsationPeriod;
    private RichInputText annualLapsationPeriod;
    private RichInputText checkOffLapsation;
    private RichTable productLapsationDaysLOV;
    private RichSelectOneChoice documentType;
    private RichInputText documentName;
    private RichTable productPolDocsLOV;
    private RichInputText exceptionsNotificationAge;
    private RichInputText exceptionsNotificationSA;
    private RichTable productExceptionsLOV;
    private RichInputText exgratiaMemberID;
    private RichInputText prodMaxTermLimit;
    private RichInputText productRemarks;
    private RichTable addCoverTypesLOV;
    private RichInputText addCoverDescription;
    private RichInputText retentionLimit;
    private RichInputText multiLifeRetentionLimit;
    private RichInputText amountOverLimitToCede;
    private RichSelectOneChoice reducingBalance;
    private RichTable treatySetupsLOV;
    private RichInputText trsShtDesc;
    private RichTable treatiesLOV;
    private RichInputText trsTrtShtDesc;
    private RichInputDate periodFrom;
    private RichInputDate periodTo;
    private RichInputText interestOnPremiumResv;
    private RichInputText profitCommission;
    private RichInputText managementFeeRate;
    private RichInputText cashLoss;
    private RichSelectOneChoice accounts;
    private RichInputText companyReinsCode;
    private RichInputText premiumPortfolio;
    private RichInputText claimPortfolio;
    private RichInputText quakeLimit;
    private RichInputText commissionRate;
    private RichInputText currency;
    private RichInputText premiumReserve;
    private RichInputText periodLossCarriedForward;
    private RichInputText siStartFrom;
    private RichInputText generalConditions;
    private RichInputText exclusions;
    private RichInputText information;
    private RichInputText wording;
    private RichInputText warranty;
    private RichTable participantsLOV;
    private RichInputText participantID;
    private RichTable reinsurersLOV;
    private RichInputText participantName;
    private RichInputText companyRate;
    private RichSelectOneChoice premTaxChargeable;
    private RichInputText glAccountCode;
    private RichTable treatyCoverTypesTabProdLOV;
    private RichTable treatyCoverTypesTabSetupsLOV;
    private RichTable arrangementCoverTypesLOV;
    private RichInputText arrCoverType;
    private RichTable arrangeCoversLOV;
    private RichSelectOneChoice cedeType;
    private RichInputText cedeRate;
    private RichSelectOneChoice arrRateType;
    private RichInputText arrRateName;
    private RichTable ordReinRatesLOV;
    private RichInputText atctLimit;
    private RichTable commissionRatesLOV;
    private RichInputText yearFrom;
    private RichInputText yearTo;
    private RichInputText arrcommissionRate;
    private RichSelectOneChoice commissionDivFact;
    private RichInputDate wefDate;
    private RichInputDate wetDate;
    private RichInputText treatyProdDisplay;
    private RichTable treatyProdsLOV;
    private RichSelectOneChoice defaultTreatyProd;
    private RichInputDate defaultDOBMon;
    private RichSelectOneChoice productStatus;
    private RichInputDate prodWefDate;
    private RichInputText weeklyIndemnityLimit;
    private RichTree treatiesTree;
    private RichTree treatyProductTree;
    private RichOutputText productLabel;
    private RichTable prodProvisions;
    private RichTable provisionsLOV;
    private RichSelectOneChoice provDefault;
    private RichSelectOneChoice provAllow;
    private RichInputText provDesc;
    private RichInputText nprovShtDesc;
    private RichInputText nprovDesc;
    private RichSelectOneChoice nprovType;
    private RichSelectOneChoice nprovClause;
    private RichTable allProvisionsLOV;
    private RichTable glAccountsLOV;
    private RichSelectOneChoice fclType;
    private RichSelectOneChoice prdEarningsType;
    private RichInputText treatyProductDesc;
    private RichInputText arrangementDesc;
    private RichSelectOneChoice saDependLimit;
    private RichSelectOneChoice payBen;
    private RichSelectOneChoice pensType;
    private RichSelectOneChoice pensionMode;
    private RichInputText pensContriLimit;
    private RichSelectOneChoice loanGuard;
    private RichInputText quoteExpiryPeriod;
    private RichSelectOneChoice receiptingMode;
    private RichOutputText cloneYear;
    private RichInputText newYear;
    private HtmlPanelGrid confirmPanel;
    private HtmlPanelGrid clonePanel;
    private RichOutputText cloneProduct;
    private RichInputText newProdID;
    private RichInputText newProdDesc;
    private RichSelectOneChoice newProdType;
    private RichInputText newPolProdPrefix;
    private RichInputText newPropProdPrefix;
    private RichInputText newClaimProdPrefix;
    private RichSelectBooleanCheckbox chkProdCovers;
    private RichSelectBooleanCheckbox chkProdCoverDeps;
    private RichOutputLabel coverMainPercLbl;
    private RichSelectOneChoice fclSAFormula;
    private RichInputText exp_period;
    private RichInputText expTLR;
    private RichSelectOneChoice thirteenthMonth;
    private RichSelectOneChoice loadAvgAge;
    private RichSelectOneChoice rateTypeCombo;
    private RichInputText errorMarginTF;
    private RichInputText profitMarginTF;
    private RichInputText mngtExpenseTF;
    private RichInputText phcfTF;
    private RichInputText adrRateTF;
    private RichInputText adrRateDivFactor;
    private RichInputText medicalCost;
    private RichInputText stampDuty;
    private RichInputText pureCommRate;
    private RichInputText maxInstPayable;
    private RichInputText waitingPrd;
    private RichInputText retireAge;
    private RichSelectOneChoice rateTypeCB;
    private RichInputText prodLoadingNameTF;
    private RichInputText loadingRateTF;
    private RichInputText loadingRateDivFactTF;
    private RichTable prodCoverLoadingLOV;
    private RichSelectOneChoice fixedSA;
    private RichInputText fixed_sa_amt;
    private RichColumn getLoadingDetails;
    private RichCommandButton getLoadingDetailsBut;
    private RichTable loadingLOV;
    private RichInputText loadingName;
    private RichTable loadingsLOV;
    private RichInputText categoryTF;
    private RichInputText classTF;
    private RichTable occupationCategory;
    private RichTable occupationCategoryLOV;
    private RichSelectOneChoice rateTypeSelect;
    private RichInputText limYrFrom;
    private RichInputText limYrTo;
    private RichInputText limPercPayable;
    private RichInputText limWaitingPeriod;
    private RichTable provisionLimitsLOV;
    private RichInputText provisionDescTF;
    private RichTable provisions1LOV;
    private RichSelectOneChoice prodProvDefault;
    private RichSelectOneChoice prodProvisionEditable;
    private RichSelectOneChoice prodProvAutoPopulate;
    private RichTable productProvisionLOV;
    private RichTable sysUsersLOV;
    private RichInputText emailReportName;
    private RichInputText emailReportTemp;
    private RichInputText emailReportUser;
    private RichTable emailDetailsLOV;
    private RichInputNumberSpinbox cratCode;
    private RichInputNumberSpinbox cratAtCode;
    private RichInputNumberSpinbox cratRate;
    private RichInputNumberSpinbox cratDivFactor;
    private RichInputNumberSpinbox cratYrNoFrom;
    private RichInputNumberSpinbox cratYrNoTo;
    private RichInputNumberSpinbox cratTermFrom;
    private RichInputNumberSpinbox cratTermTo;
    private RichInputDate cratWefDate;
    private RichInputDate cratWetDate;
    private RichInputNumberSpinbox cratRangeFrom;
    private RichInputNumberSpinbox cratRangeTo;
    private RichTable accountsLOV;
    private RichTable ovcommRatesTab;
    private RichSelectOneChoice occupationalBen;
    private RichTable productLOV;
    private RichTable branchLOV;
    private RichInputText budgProdDesc;
    private RichInputText budgBranchDesc;
    private RichInputText budgetName;
    private RichInputText budgetDesc;
    private RichInputText budgetUW_YR;
    private RichInputDate budgetEffDate;
    private RichTable budgetTypeLOV;
    private RichCommandButton deleteBudgetTypes;
    private RichInputText renJanBudget;
    private RichInputText nbJanBudget;
    private RichInputText renFebBudget;
    private RichInputText nbFebBudget;
    private RichInputText renMarBudget;
    private RichInputText nbMarBudget;
    private RichInputText renAprBudget;
    private RichInputText nbAprBudget;
    private RichInputText nbMayBudget;
    private RichInputText renMayBudget;
    private RichInputText renJunBudget;
    private RichInputText nbJunBudget;
    private RichInputText renJulBudget;
    private RichInputText nbJulBudget;
    private RichInputText renAugBudget;
    private RichInputText nbAugBudget;
    private RichInputText renSepBudget;
    private RichInputText nbSepBudget;
    private RichInputText renOctBudget;
    private RichInputText nbOctBudget;
    private RichInputText renNovBudget;
    private RichInputText nbNovBudget;
    private RichInputText renDecBudget;
    private RichInputText nbDecBudget;
    private RichTable prodBudgetLOV;
    private RichTable budgetNamesLOV;
    private RichInputText budgetNameTF;
    private RichInputText medGracePeriod;
    private RichInputText planShtDesc;
    private RichInputText planDescription;
    private RichTable productPlanLOV;
    private RichSelectOneChoice emailRecepients;
    private RichOutputText emailusrnameLab;
    private HtmlPanelGrid emailusrnamePG;
    private HtmlPanelGrid emailPG;
    private HtmlPanelGrid emailAddressPG;
    private RichInputText emailAddressTF;
    private RichOutputLabel emailAddrLab;
    private RichSelectOneChoice emailAt;
    private RichInputText aggQuoLett;
    private RichTable masksLOV;
    private RichInputText maskDisplay;
    private RichInputText aal;
    private RichInputText notificationPeriod;
    private RichInputText prodDescTF;
    private RichPanelBox commPnl;
    private HtmlPanelGrid commGrid;
    private RichPopup commPopup;
    private RichTable currencyLOV;
    private RichInputText currencyTF;
    private RichInputText brokerName;
    private RichTable brokersLOV;

    public otherSetupsManip() {
        super();
    }
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);

    public void LifeClassListener(SelectionEvent selectionEvent) {
        // Add event code here...
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findLifeClassesIterator");
            RowKeySet set = selectionEvent.getAddedSet();
            Iterator rowKeySetIter = set.iterator();

            //System.out.println(1);
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();


                session.setAttribute("lcCode", r.getAttribute("LC_CODE"));
                session.setAttribute("gcoCode", null);

                ADFUtils.findIterator("findGroupOccupationsIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(occupationsLOV);


            }


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
    }

    public String AddLifeClasses() {
        try {

            id.setValue(null);
            desc.setValue(null);
            hazardous.setValue(null);
            session.setAttribute("lcCode", null);


            // Render Popup
            ExtendedRenderKitService erkService =
                Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                   ExtendedRenderKitService.class);
            erkService.addScript(FacesContext.getCurrentInstance(),
                                 "var hints = {autodismissNever:false}; " +
                                 "AdfPage.PAGE.findComponent('" +
                                 "lmsgroup:lifeClass" + "').show(hints);");

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String EditLifeClasses() {

        DCIteratorBinding dciter =
            ADFUtils.findIterator("findLifeClassesIterator");
        RowKeySet set = lifeClassLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            session.setAttribute("lcCode", r.getAttribute("LC_CODE"));

            id.setValue(r.getAttribute("LC_SHT_DESC"));
            desc.setValue(r.getAttribute("LC_DESC"));
            hazardous.setValue(r.getAttribute("LC_HAZARDOUS"));

            // Render Popup
            ExtendedRenderKitService erkService =
                Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                   ExtendedRenderKitService.class);
            erkService.addScript(FacesContext.getCurrentInstance(),
                                 "var hints = {autodismissNever:false}; " +
                                 "AdfPage.PAGE.findComponent('" +
                                 "lmsgroup:lifeClass" + "').show(hints);");

        }


        return null;
    }

    public String SaveLifeClasses() {
        try {

            if (id.getValue() == null) {
                String Message = "Enter an Id.";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));
                return null;
            }

            if (desc.getValue() == null) {
                String Message = "Enter A Description";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));
                return null;
            }

            String authQuery =
                "BEGIN LMS_SETUPS_PKG.updateLifeClasses(?,?,?,?);END;";
            Connection conn = new DBConnector().getDatabaseConn();

            CallableStatement cstmt = conn.prepareCall(authQuery);
            cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("lcCode"));
            if (id.getValue() == null) {
                cstmt.setString(2, null);
            } else {
                cstmt.setString(2, id.getValue().toString());
            }
            if (desc.getValue() == null) {
                cstmt.setString(3, null);
            } else {
                cstmt.setString(3, desc.getValue().toString());
            }
            if (hazardous.getValue() == null) {
                cstmt.setString(4, null);
            } else {
                cstmt.setString(4, hazardous.getValue().toString());
            }

            cstmt.execute();
            conn.close();

            String Message = "Life Class Saved succesfully.";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));

            session.setAttribute("lcCode", null);
            ADFUtils.findIterator("findLifeClassesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(lifeClassLOV);

        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(null, ex);
        }
        return null;
    }

    public String DeleteLifeClasses() {
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findLifeClassesIterator");
            RowKeySet set = lifeClassLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            //System.out.println(1);
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                session.setAttribute("lcCode", r.getAttribute("LC_CODE"));

                String authQuery =
                    "BEGIN LMS_SETUPS_PKG.deleteLifeClasses(?);END;";
                Connection conn = new DBConnector().getDatabaseConn();

                CallableStatement cstmt = conn.prepareCall(authQuery);
                cstmt.setBigDecimal(1,
                                    (BigDecimal)session.getAttribute("lcCode"));

                cstmt.execute();
                conn.close();

            }
            session.setAttribute("lcCode", null);
            ADFUtils.findIterator("findLifeClassesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(lifeClassLOV);

        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(null, ex);
        }
        return null;
    }

    public String AddOccupation() {
        try {

            occId.setValue(null);
            occDesc.setValue(null);
            occHazardous.setValue(null);
            session.setAttribute("gcoCode", null);


            // Render Popup
            ExtendedRenderKitService erkService =
                Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                   ExtendedRenderKitService.class);
            erkService.addScript(FacesContext.getCurrentInstance(),
                                 "var hints = {autodismissNever:false}; " +
                                 "AdfPage.PAGE.findComponent('" +
                                 "lmsgroup:occupation" + "').show(hints);");

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String EditOccupation() {

        DCIteratorBinding dciter =
            ADFUtils.findIterator("findGroupOccupationsIterator");
        RowKeySet set = occupationsLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            session.setAttribute("gcoCode", r.getAttribute("LC_CODE"));

            occId.setValue(r.getAttribute("LC_SHT_DESC"));
            occDesc.setValue(r.getAttribute("LC_DESC"));
            occHazardous.setValue(r.getAttribute("LC_HAZARDOUS"));

            // Render Popup
            ExtendedRenderKitService erkService =
                Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                   ExtendedRenderKitService.class);
            erkService.addScript(FacesContext.getCurrentInstance(),
                                 "var hints = {autodismissNever:false}; " +
                                 "AdfPage.PAGE.findComponent('" +
                                 "lmsgroup:occupation" + "').show(hints);");

        }


        return null;
    }

    public String SaveOccupation() {
        try {

            if (occId.getValue() == null) {
                String Message = "Enter an Id.";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));
                return null;
            }

            if (occDesc.getValue() == null) {
                String Message = "Enter A Description";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));
                return null;
            }

            String authQuery =
                "BEGIN LMS_SETUPS_PKG.updateOccupations(?,?,?,?,?);END;";
            Connection conn = new DBConnector().getDatabaseConn();

            CallableStatement cstmt = conn.prepareCall(authQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("gcoCode"));
            if (occId.getValue() == null) {
                cstmt.setString(2, null);
            } else {
                cstmt.setString(2, occId.getValue().toString());
            }
            if (occDesc.getValue() == null) {
                cstmt.setString(3, null);
            } else {
                cstmt.setString(3, occDesc.getValue().toString());
            }
            if (occHazardous.getValue() == null) {
                cstmt.setString(4, null);
            } else {
                cstmt.setString(4, occHazardous.getValue().toString());
            }
            cstmt.setBigDecimal(5, (BigDecimal)session.getAttribute("lcCode"));
            cstmt.execute();
            conn.close();

            String Message = "Occupation Saved succesfully.";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));

            session.setAttribute("gcoCode", null);
            ADFUtils.findIterator("findGroupOccupationsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(occupationsLOV);

        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(null, ex);
        }
        return null;
    }

    public String DeleteOccupation() {
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findGroupOccupationsIterator");
            RowKeySet set = occupationsLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            //System.out.println(1);
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                session.setAttribute("gcoCode", r.getAttribute("LC_CODE"));

                String authQuery =
                    "BEGIN LMS_SETUPS_PKG.deleteOccupations(?);END;";
                Connection conn = new DBConnector().getDatabaseConn();

                CallableStatement cstmt = conn.prepareCall(authQuery);
                cstmt.setBigDecimal(1,
                                    (BigDecimal)session.getAttribute("gcoCode"));

                cstmt.execute();
                conn.close();

            }
            session.setAttribute("gcoCode", null);
            ADFUtils.findIterator("findGroupOccupationsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(occupationsLOV);

        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(null, ex);
        }
        return null;
    }

    public void RIRatesListener(SelectionEvent selectionEvent) {
        // Add event code here...
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findRIRatesDescriptionIterator");
            RowKeySet set = selectionEvent.getAddedSet();
            Iterator rowKeySetIter = set.iterator();

            //System.out.println(1);
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();


                session.setAttribute("orrpCode", r.getAttribute("ORRP_CODE"));
                session.setAttribute("orrtCode", null);

                ADFUtils.findIterator("findRIRatesIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(riRatesLOV);


            }


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
    }

    public String findGroupSelected() {
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findLifeClassesIterator");
            RowKeySet set = groupLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            //System.out.println(1);
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();


                session.setAttribute("lcCode", r.getAttribute("LC_CODE"));
                classId.setValue(r.getAttribute("LC_DESC"));
                ADFUtils.findIterator("findRIRatesIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(riRatesLOV);

            }

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String AddRIRateDesc() {
        try {

            id.setValue(null);
            desc.setValue(null);
            session.setAttribute("orrpCode", null);


            // Render Popup
            ExtendedRenderKitService erkService =
                Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                   ExtendedRenderKitService.class);
            erkService.addScript(FacesContext.getCurrentInstance(),
                                 "var hints = {autodismissNever:false}; " +
                                 "AdfPage.PAGE.findComponent('" +
                                 "lmsgroup:rirate" + "').show(hints);");

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String EditRIRateDesc() {

        DCIteratorBinding dciter =
            ADFUtils.findIterator("findRIRatesDescriptionIterator");
        RowKeySet set = riRatesDescLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            session.setAttribute("orrpCode", r.getAttribute("ORRP_CODE"));

            id.setValue(r.getAttribute("ORRP_SHT_DESC"));
            desc.setValue(r.getAttribute("ORRP_DESC"));

            // Render Popup
            ExtendedRenderKitService erkService =
                Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                   ExtendedRenderKitService.class);
            erkService.addScript(FacesContext.getCurrentInstance(),
                                 "var hints = {autodismissNever:false}; " +
                                 "AdfPage.PAGE.findComponent('" +
                                 "lmsgroup:rirate" + "').show(hints);");

        }


        return null;
    }

    public String SaveRIRateDesc() {
        Connection conn = null;
        try {

            if (id.getValue() == null) {
                String Message = "Enter an Id.";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));
                return null;
            }

            if (desc.getValue() == null) {
                String Message = "Enter A Description";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));
                return null;
            }

            String authQuery =
                "BEGIN LMS_SETUPS_PKG.updateRIRateDesc(?,?,?,?);END;";
            conn = new DBConnector().getDatabaseConn();

            CallableStatement cstmt = conn.prepareCall(authQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("orrpCode"));
            if (id.getValue() == null) {
                cstmt.setString(2, null);
            } else {
                cstmt.setString(2, id.getValue().toString());
            }
            if (desc.getValue() == null) {
                cstmt.setString(3, null);
            } else {
                cstmt.setString(3, desc.getValue().toString());
            }
            cstmt.setString(4, (String)session.getAttribute("classSpecific"));
            cstmt.execute();
            conn.close();

            String Message = "Rate Description Saved succesfully.";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));

            session.setAttribute("orrpCode", null);
            ADFUtils.findIterator("findRIRatesDescriptionIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(riRatesDescLOV);

        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        }
        return null;
    }

    public String DeleteRIRateDesc() {
        Connection conn = null;
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findRIRatesDescriptionIterator");
            RowKeySet set = riRatesDescLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            //System.out.println(1);
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                session.setAttribute("orrpCode", r.getAttribute("ORRP_CODE"));

                String authQuery =
                    "BEGIN LMS_SETUPS_PKG.deleteRIRateDesc(?);END;";
                conn = new DBConnector().getDatabaseConn();

                CallableStatement cstmt = conn.prepareCall(authQuery);
                cstmt.setBigDecimal(1,
                                    (BigDecimal)session.getAttribute("orrpCode"));

                cstmt.execute();
                conn.close();

            }
            session.setAttribute("orrpCode", null);
            ADFUtils.findIterator("findRIRatesDescriptionIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(riRatesDescLOV);

        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        }
        return null;
    }

    public String AddRIRates() {
        try {

            anbFrom.setValue(null);
            anbTo.setValue(null);
            rate.setValue(null);
            divFac.setValue(null);
            rateType.setValue(null);
            wet.setValue(null);
            session.setAttribute("orrtCode", null);


            // Render Popup
            ExtendedRenderKitService erkService =
                Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                   ExtendedRenderKitService.class);
            erkService.addScript(FacesContext.getCurrentInstance(),
                                 "var hints = {autodismissNever:false}; " +
                                 "AdfPage.PAGE.findComponent('" +
                                 "lmsgroup:rirat" + "').show(hints);");

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String EditRIRates() {

        DCIteratorBinding dciter =
            ADFUtils.findIterator("findRIRatesIterator");
        RowKeySet set = riRatesDescLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            session.setAttribute("orrtCode", r.getAttribute("ORRT_CODE"));

            anbFrom.setValue(r.getAttribute("ORRT_ANB_FROM"));
            anbTo.setValue(r.getAttribute("ORRT_ANB_TO"));
            rate.setValue(r.getAttribute("ORRT_RATE"));
            divFac.setValue(r.getAttribute("ORRT_DIVISION_FACTOR"));
            rateType.setValue(r.getAttribute("ORRT_RATE_TYPE"));
            wef.setValue(r.getAttribute("ORRT_WEF"));
            wet.setValue(r.getAttribute("ORRT_WET"));

            // Render Popup
            ExtendedRenderKitService erkService =
                Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                   ExtendedRenderKitService.class);
            erkService.addScript(FacesContext.getCurrentInstance(),
                                 "var hints = {autodismissNever:false}; " +
                                 "AdfPage.PAGE.findComponent('" +
                                 "lmsgroup:rirat" + "').show(hints);");

        }


        return null;
    }

    public String SaveRIRates() {
        try {

            if (anbFrom.getValue() == null) {
                String Message = "Enter a ANB From.";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));
                return null;
            }

            if (anbTo.getValue() == null) {
                String Message = "Enter A ANB To";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));
                return null;
            }
            if (rate.getValue() == null) {
                String Message = "Enter A Rate";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));
                return null;
            }
            Boolean WEFDateChanged = false;
            Boolean WETDateChanged = false;

            if (wef.getValue() == null) {
            } else {
                WEFDateChanged = wef.getValue().toString().contains(":");
            }

            if (wet.getValue() == null) {
            } else {
                WETDateChanged = wet.getValue().toString().contains(":");
            }

            String authQuery =
                "BEGIN LMS_SETUPS_PKG.updateRIRates(?,?,?,?,?,?,?,?,?,?);END;";
            Connection conn = new DBConnector().getDatabaseConn();

            CallableStatement cstmt = conn.prepareCall(authQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("orrtCode"));
            if (anbFrom.getValue() == null) {
                cstmt.setString(2, null);
            } else {
                cstmt.setString(2, anbFrom.getValue().toString());
            }
            if (anbTo.getValue() == null) {
                cstmt.setString(3, null);
            } else {
                cstmt.setString(3, anbTo.getValue().toString());
            }
            if (rate.getValue() == null) {
                cstmt.setString(4, null);
            } else {
                cstmt.setString(4, rate.getValue().toString());
            }
            if (divFac.getValue() == null) {
                cstmt.setString(5, null);
            } else {
                cstmt.setString(5, divFac.getValue().toString());
            }
            if (rateType.getValue() == null) {
                cstmt.setString(6, null);
            } else {
                cstmt.setString(6, rateType.getValue().toString());
            }
            if (wef.getValue() == null) {
                cstmt.setString(7, null);
            } else {
                if (WEFDateChanged == false) {
                    cstmt.setString(7, null);
                } else {
                    cstmt.setString(7,
                                    LOVCC.parseDate(wef.getValue().toString()));
                }
            }
            if (wet.getValue() == null) {
                cstmt.setString(8, null);
            } else {
                if (WETDateChanged == false) {
                    cstmt.setString(8, null);
                } else {
                    cstmt.setString(8,
                                    LOVCC.parseDate(wet.getValue().toString()));
                }
            }
            cstmt.setBigDecimal(9,
                                (BigDecimal)session.getAttribute("orrpCode"));
            cstmt.setBigDecimal(10,
                                (BigDecimal)session.getAttribute("lcCode"));
            cstmt.execute();
            conn.close();

            String Message = "RI Rate Saved succesfully.";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));

            session.setAttribute("orrtCode", null);
            ADFUtils.findIterator("findRIRatesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(riRatesLOV);

        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(null, ex);
        }
        return null;
    }

    public String DeleteRIRates() {
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findRIRatesIterator");
            RowKeySet set = riRatesLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            //System.out.println(1);
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                session.setAttribute("orrtCode", r.getAttribute("ORRT_CODE"));

                String authQuery =
                    "BEGIN LMS_SETUPS_PKG.deleteRIRates(?);END;";
                Connection conn = new DBConnector().getDatabaseConn();

                CallableStatement cstmt = conn.prepareCall(authQuery);
                cstmt.setBigDecimal(1,
                                    (BigDecimal)session.getAttribute("orrtCode"));

                cstmt.execute();
                conn.close();

            }
            session.setAttribute("orrtCode", null);
            ADFUtils.findIterator("findRIRatesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(riRatesLOV);

        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(null, ex);
        }
        return null;
    }

    public void RIOSRatesListener(SelectionEvent selectionEvent) {
        // Add event code here...
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findOSRIRatesDescIterator");
            RowKeySet set = selectionEvent.getAddedSet();
            Iterator rowKeySetIter = set.iterator();

            //System.out.println(1);
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();


                session.setAttribute("riosCode", r.getAttribute("RIOS_CODE"));
                session.setAttribute("riotCode", null);

                ADFUtils.findIterator("findOSRIRatesIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(riRatesLOV);


            }


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
    }

    public String AddRIOSRateDesc() {
        try {

            id.setValue(null);
            desc.setValue(null);
            wef.setValue(null);
            wet.setValue(null);
            session.setAttribute("riosCode", null);


            // Render Popup
            ExtendedRenderKitService erkService =
                Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                   ExtendedRenderKitService.class);
            erkService.addScript(FacesContext.getCurrentInstance(),
                                 "var hints = {autodismissNever:false}; " +
                                 "AdfPage.PAGE.findComponent('" +
                                 "lmsgroup:osRate" + "').show(hints);");

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String EditRIOSRateDesc() {

        DCIteratorBinding dciter =
            ADFUtils.findIterator("findOSRIRatesDescIterator");
        RowKeySet set = riRatesDescLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            session.setAttribute("riosCode", r.getAttribute("RIOS_CODE"));

            id.setValue(r.getAttribute("RIOS_SHT_DESC"));
            desc.setValue(r.getAttribute("RIOS_DESC"));
            wef.setValue(r.getAttribute("RIOS_WEF"));
            wet.setValue(r.getAttribute("RIOS_WET"));

            // Render Popup
            ExtendedRenderKitService erkService =
                Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                   ExtendedRenderKitService.class);
            erkService.addScript(FacesContext.getCurrentInstance(),
                                 "var hints = {autodismissNever:false}; " +
                                 "AdfPage.PAGE.findComponent('" +
                                 "lmsgroup:osRate" + "').show(hints);");

        }


        return null;
    }

    public String SaveRIOSRateDesc() {
        Connection conn = null;
        try {

            if (id.getValue() == null) {
                String Message = "Enter an Id.";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));
                return null;
            }

            if (desc.getValue() == null) {
                String Message = "Enter A Description";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));
                return null;
            }
            Boolean WEFDateChanged = false;
            Boolean WETDateChanged = false;

            if (wef.getValue() == null) {
            } else {
                WEFDateChanged = wef.getValue().toString().contains(":");
            }

            if (wet.getValue() == null) {
            } else {
                WETDateChanged = wet.getValue().toString().contains(":");
            }

            String authQuery =
                "BEGIN LMS_SETUPS_PKG.updateReducingRateDesc(?,?,?,?,?);END;";
            conn = new DBConnector().getDatabaseConn();

            CallableStatement cstmt = conn.prepareCall(authQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("riosCode"));
            if (id.getValue() == null) {
                cstmt.setString(2, null);
            } else {
                cstmt.setString(2, id.getValue().toString());
            }
            if (desc.getValue() == null) {
                cstmt.setString(3, null);
            } else {
                cstmt.setString(3, desc.getValue().toString());
            }
            if (wef.getValue() == null) {
                cstmt.setString(4, null);
            } else {
                if (WEFDateChanged == false) {
                    cstmt.setString(4, null);
                } else {
                    cstmt.setString(4,
                                    LOVCC.parseDate(wef.getValue().toString()));
                }
            }
            if (wet.getValue() == null) {
                cstmt.setString(5, null);
            } else {
                if (WETDateChanged == false) {
                    cstmt.setString(5, null);
                } else {
                    cstmt.setString(5,
                                    LOVCC.parseDate(wet.getValue().toString()));
                }
            }
            cstmt.execute();
            conn.close();

            String Message = "Reducing Rate Description Saved succesfully.";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));

            session.setAttribute("riosCode", null);
            ADFUtils.findIterator("findOSRIRatesDescIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(riRatesDescLOV);

        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        }
        return null;
    }

    public String DeleteRIOSRateDesc() {
        Connection conn = null;
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findOSRIRatesDescIterator");
            RowKeySet set = riRatesDescLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            //System.out.println(1);
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                session.setAttribute("riosCode", r.getAttribute("RIOS_CODE"));

                String authQuery =
                    "BEGIN LMS_SETUPS_PKG.deleteReducingRateDesc(?);END;";
                conn = new DBConnector().getDatabaseConn();

                CallableStatement cstmt = conn.prepareCall(authQuery);
                cstmt.setBigDecimal(1,
                                    (BigDecimal)session.getAttribute("riosCode"));

                cstmt.execute();
                conn.close();

            }
            session.setAttribute("riosCode", null);
            ADFUtils.findIterator("findOSRIRatesDescIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(riRatesDescLOV);

        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        }
        return null;
    }

    public String AddRIOSRates() {
        try {

            polTermFrm.setValue(null);
            polTermTo.setValue(null);
            lapsedTermFrm.setValue(null);
            lapsedTermTo.setValue(null);
            rate.setValue(null);
            divFac.setValue(null);
            session.setAttribute("riotCode", null);


            // Render Popup
            ExtendedRenderKitService erkService =
                Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                   ExtendedRenderKitService.class);
            erkService.addScript(FacesContext.getCurrentInstance(),
                                 "var hints = {autodismissNever:false}; " +
                                 "AdfPage.PAGE.findComponent('" +
                                 "lmsgroup:osRate2" + "').show(hints);");

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String EditRIOSRates() {

        DCIteratorBinding dciter =
            ADFUtils.findIterator("findOSRIRatesIterator");
        RowKeySet set = riRatesLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            session.setAttribute("riotCode", r.getAttribute("RIOT_CODE"));

            polTermFrm.setValue(r.getAttribute("RIOT_POLICY_TERM"));
            polTermTo.setValue(r.getAttribute("RIOT_POLICY_TERM_TO"));
            lapsedTermFrm.setValue(r.getAttribute("RIOT_LAPSED_TERM"));
            lapsedTermTo.setValue(r.getAttribute("RIOT_LAPSED_TERM_TO"));
            rate.setValue(r.getAttribute("RIOT_RATE"));
            divFac.setValue(r.getAttribute("RIOT_DIVISION_FACTOR"));


            // Render Popup
            ExtendedRenderKitService erkService =
                Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                   ExtendedRenderKitService.class);
            erkService.addScript(FacesContext.getCurrentInstance(),
                                 "var hints = {autodismissNever:false}; " +
                                 "AdfPage.PAGE.findComponent('" +
                                 "lmsgroup:osRate2" + "').show(hints);");

        }


        return null;
    }

    public String SaveRIOSRates() {
        Connection conn = null;
        try {

            if (polTermFrm.getValue() == null) {
                String Message = "Enter an Policy Term From.";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));
                return null;
            }

            if (polTermTo.getValue() == null) {
                String Message = "Enter A Policy Term To";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));
                return null;
            }


            String authQuery =
                "BEGIN LMS_SETUPS_PKG.updateRIBalanceRates(?,?,?,?,?,?,?,?);END;";
            conn = new DBConnector().getDatabaseConn();

            CallableStatement cstmt = conn.prepareCall(authQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("riotCode"));
            if (polTermFrm.getValue() == null) {
                cstmt.setString(2, null);
            } else {
                cstmt.setString(2, polTermFrm.getValue().toString());
            }
            if (polTermTo.getValue() == null) {
                cstmt.setString(3, null);
            } else {
                cstmt.setString(3, polTermTo.getValue().toString());
            }
            if (lapsedTermFrm.getValue() == null) {
                cstmt.setString(4, null);
            } else {
                cstmt.setString(4, lapsedTermFrm.getValue().toString());
            }
            if (lapsedTermTo.getValue() == null) {
                cstmt.setString(5, null);
            } else {
                cstmt.setString(5, lapsedTermTo.getValue().toString());
            }
            if (rate.getValue() == null) {
                cstmt.setString(6, null);
            } else {
                cstmt.setString(6, rate.getValue().toString());

            }
            if (divFac.getValue() == null) {
                cstmt.setString(7, null);
            } else {
                cstmt.setString(7, divFac.getValue().toString());
            }
            cstmt.setBigDecimal(8,
                                (BigDecimal)session.getAttribute("riosCode"));
            cstmt.execute();
            conn.close();

            String Message = "Reducing Rate Saved succesfully.";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));

            session.setAttribute("riotCode", null);
            ADFUtils.findIterator("findOSRIRatesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(riRatesLOV);

        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        }
        return null;
    }

    public String DeleteRIOSRates() {
        Connection conn = null;
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findOSRIRatesIterator");
            RowKeySet set = riRatesLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            //System.out.println(1);
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                session.setAttribute("riotCode", r.getAttribute("RIOT_CODE"));

                String authQuery =
                    "BEGIN LMS_SETUPS_PKG.deleteRIBalanceRates(?);END;";
                conn = new DBConnector().getDatabaseConn();

                CallableStatement cstmt = conn.prepareCall(authQuery);
                cstmt.setBigDecimal(1,
                                    (BigDecimal)session.getAttribute("riotCode"));

                cstmt.execute();
                conn.close();

            }
            session.setAttribute("riotCode", null);
            ADFUtils.findIterator("findOSRIRatesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(riRatesLOV);

        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        }
        return null;
    }

    public void ArrangementsSetupsTreeListener(SelectionEvent selectionEvent) {
        // Add event code here...
        if (selectionEvent.getAddedSet() != selectionEvent.getRemovedSet()) {
            RowKeySet keys = selectionEvent.getAddedSet();
            if (keys != null && keys.getSize() > 0) {
                for (Object treeRowKey : keys) {
                    treatiesTree.setRowKey(treeRowKey);
                    JUCtrlHierNodeBinding nd =
                        (JUCtrlHierNodeBinding)treatiesTree.getRowData();

                    session.setAttribute("ta_code",
                                         nd.getRow().getAttribute("ta_code"));
                    session.setAttribute("ta_sht_desc",
                                         nd.getRow().getAttribute("TA_SHT_DESC"));
                    session.setAttribute("ta_type",
                                         nd.getRow().getAttribute("TA_TYPE"));
                    productLabel.setValue(null);
                    defaultTreatyProd.setValue(null);
                    treatyShtDesc.setValue(nd.getRow().getAttribute("TA_SHT_DESC"));
                    treatyDesc.setValue(nd.getRow().getAttribute("TA_DESC"));
                    treatyType.setValue(null);
                    treatyType.setValue(nd.getRow().getAttribute("TA_TYPE"));

                    ADFUtils.findIterator("findArrangementSetupsIterator").executeQuery();
                    AdfFacesContext.getCurrentInstance().addPartialTarget(arrangementSetupsLOV);
                }
            }
        }
    }

    public void ArrangementsSetupsListener(SelectionEvent selectionEvent) {
        // Add event code here...
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findTreatyArrangementsIterator");
            RowKeySet set = selectionEvent.getAddedSet();
            Iterator rowKeySetIter = set.iterator();

            //System.out.println(1);
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();


                session.setAttribute("ta_code", r.getAttribute("ta_code"));
                session.setAttribute("ta_sht_desc",
                                     r.getAttribute("TA_SHT_DESC"));
                session.setAttribute("ta_type", r.getAttribute("TA_TYPE"));
                System.out.println("ta_code   " + r.getAttribute("ta_code"));
                //session.setAttribute("gcoCode", null);

                ADFUtils.findIterator("findArrangementSetupsIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(arrangementSetupsLOV);


            }


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
    }

    public void setLifeClassLOV(RichTable lifeClassLOV) {
        this.lifeClassLOV = lifeClassLOV;
    }

    public RichTable getLifeClassLOV() {
        return lifeClassLOV;
    }

    public void setOccupationsLOV(RichTable occupationsLOV) {
        this.occupationsLOV = occupationsLOV;
    }

    public RichTable getOccupationsLOV() {
        return occupationsLOV;
    }

    public void setId(RichInputText id) {
        this.id = id;
    }

    public RichInputText getId() {
        return id;
    }

    public void setDesc(RichInputText desc) {
        this.desc = desc;
    }

    public RichInputText getDesc() {
        return desc;
    }

    public void setHazardous(RichSelectOneChoice hazardous) {
        this.hazardous = hazardous;
    }

    public RichSelectOneChoice getHazardous() {
        return hazardous;
    }

    public void setOccId(RichInputText occId) {
        this.occId = occId;
    }

    public RichInputText getOccId() {
        return occId;
    }

    public void setOccDesc(RichInputText occDesc) {
        this.occDesc = occDesc;
    }

    public RichInputText getOccDesc() {
        return occDesc;
    }

    public void setOccHazardous(RichSelectOneChoice occHazardous) {
        this.occHazardous = occHazardous;
    }

    public RichSelectOneChoice getOccHazardous() {
        return occHazardous;
    }

    public void setRiRatesLOV(RichTable riRatesLOV) {
        this.riRatesLOV = riRatesLOV;
    }

    public RichTable getRiRatesLOV() {
        return riRatesLOV;
    }

    public void setGroupLOV(RichTable groupLOV) {
        this.groupLOV = groupLOV;
    }

    public RichTable getGroupLOV() {
        return groupLOV;
    }

    public void setClassId(RichInputText classId) {
        this.classId = classId;
    }

    public RichInputText getClassId() {
        return classId;
    }

    public void setAnbFrom(RichInputText anbFrom) {
        this.anbFrom = anbFrom;
    }

    public RichInputText getAnbFrom() {
        return anbFrom;
    }

    public void setAnbTo(RichInputText anbTo) {
        this.anbTo = anbTo;
    }

    public RichInputText getAnbTo() {
        return anbTo;
    }

    public void setRate(RichInputText rate) {
        this.rate = rate;
    }

    public RichInputText getRate() {
        return rate;
    }

    public void setDivFac(RichInputText divFac) {
        this.divFac = divFac;
    }

    public RichInputText getDivFac() {
        return divFac;
    }

    public void setRateType(RichSelectOneChoice rateType) {
        this.rateType = rateType;
    }

    public RichSelectOneChoice getRateType() {
        return rateType;
    }

    public void setWef(RichInputDate wef) {
        this.wef = wef;
    }

    public RichInputDate getWef() {
        return wef;
    }

    public void setWet(RichInputDate wet) {
        this.wet = wet;
    }

    public RichInputDate getWet() {
        return wet;
    }

    public void setRiRatesDescLOV(RichTable riRatesDescLOV) {
        this.riRatesDescLOV = riRatesDescLOV;
    }

    public RichTable getRiRatesDescLOV() {
        return riRatesDescLOV;
    }

    public void setRtWef(RichInputDate rtWef) {
        this.rtWef = rtWef;
    }

    public RichInputDate getRtWef() {
        return rtWef;
    }

    public void setRtWet(RichInputDate rtWet) {
        this.rtWet = rtWet;
    }

    public RichInputDate getRtWet() {
        return rtWet;
    }

    public void setLapsedTermTo(RichInputText lapsedTermTo) {
        this.lapsedTermTo = lapsedTermTo;
    }

    public RichInputText getLapsedTermTo() {
        return lapsedTermTo;
    }

    public void setLapsedTermFrm(RichInputText lapsedTermFrm) {
        this.lapsedTermFrm = lapsedTermFrm;
    }

    public RichInputText getLapsedTermFrm() {
        return lapsedTermFrm;
    }

    public void setPolTermTo(RichInputText polTermTo) {
        this.polTermTo = polTermTo;
    }

    public RichInputText getPolTermTo() {
        return polTermTo;
    }

    public void setPolTermFrm(RichInputText polTermFrm) {
        this.polTermFrm = polTermFrm;
    }

    public RichInputText getPolTermFrm() {
        return polTermFrm;
    }

    public void setArrangementsSetUpLov(RichColumn arrangementsSetUpLov) {
        this.arrangementsSetUpLov = arrangementsSetUpLov;
    }

    public RichColumn getArrangementsSetUpLov() {
        return arrangementsSetUpLov;
    }

    public void setArrangementSetupsLOV(RichTable arrangementSetupsLOV) {
        this.arrangementSetupsLOV = arrangementSetupsLOV;
    }

    public RichTable getArrangementSetupsLOV() {
        return arrangementSetupsLOV;
    }

    public String AddTreaty() {
        Connection conn = null;
        try {

            if (treatyShtDesc.getValue() == null) {
                String Message = "Enter treaty ID.";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));
                return null;
            }

            if (treatyDesc.getValue() == null) {
                String Message = "Enter Treaty Description";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));
                return null;
            }
            if (currencyTF.getValue() == null) {
                GlobalCC.INFORMATIONREPORTING("Please select a currency to proceed");
                return null;
            }


            String authQuery =
                "BEGIN LMS_SETUPS_PKG.updateTreatyArrangementSetups(?,?,?,?,?);END;";
            conn = new DBConnector().getDatabaseConn();

            CallableStatement cstmt = conn.prepareCall(authQuery);
            if ((BigDecimal)session.getAttribute("ta_code") == null) {
                cstmt.setBigDecimal(1, null);
            } else {
                cstmt.setBigDecimal(1,
                                    (BigDecimal)session.getAttribute("ta_code"));
            }
            cstmt.setString(2, treatyShtDesc.getValue().toString());
            cstmt.setString(3, treatyDesc.getValue().toString());
            cstmt.setString(4, treatyType.getValue().toString());
            cstmt.setString(5, this.currencyTF.getValue().toString());
            cstmt.execute();
            conn.close();

            String Message = "Treaty Saved succesfully.";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));


            ADFUtils.findIterator("findTreatyArrangementsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(treatiesTree);

        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        }
        return null;
    }

    public String ClearTreaty() {
        try {
            session.setAttribute("ta_code", null);
            treatyShtDesc.setValue(null);
            treatyDesc.setValue(null);
            treatyType.setValue("U");

            // Render Popup
            ExtendedRenderKitService erkService =
                Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                   ExtendedRenderKitService.class);
            erkService.addScript(FacesContext.getCurrentInstance(),
                                 "var hints = {autodismissNever:false}; " +
                                 "AdfPage.PAGE.findComponent('" +
                                 "lmsgroup:TreatyDetails" + "').show(hints);");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public void setTreatyShtDesc(RichInputText treatyShtDesc) {
        this.treatyShtDesc = treatyShtDesc;
    }

    public RichInputText getTreatyShtDesc() {
        return treatyShtDesc;
    }

    public void setTreatyDesc(RichInputText treatyDesc) {
        this.treatyDesc = treatyDesc;
    }

    public RichInputText getTreatyDesc() {
        return treatyDesc;
    }

    public void setTreatyType(RichSelectOneChoice treatyType) {
        this.treatyType = treatyType;
    }

    public RichSelectOneChoice getTreatyType() {
        return treatyType;
    }

    public void setTreatyArrangmentsLOV(RichTable treatyArrangmentsLOV) {
        this.treatyArrangmentsLOV = treatyArrangmentsLOV;
    }

    public RichTable getTreatyArrangmentsLOV() {
        return treatyArrangmentsLOV;
    }

    public String updateTreaty() {

        try {

            DCIteratorBinding dciter =
                ADFUtils.findIterator("findTreatyArrangementsIterator");
            RowKeySet set = treatyArrangmentsLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();


            //System.out.println(1);
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();


                session.setAttribute("ta_code", r.getAttribute("ta_code"));
                System.out.println("ta_code   " + r.getAttribute("ta_code"));
                treatyShtDesc.setValue(r.getAttribute("TA_SHT_DESC"));
                treatyDesc.setValue(r.getAttribute("TA_DESC"));
                treatyType.setValue(r.getAttribute("TA_TYPE"));
                //session.setAttribute("gcoCode", null);


            }

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String DeleteTreaty() {
        Connection conn = null;
        try {

            String deleteQuery =
                "BEGIN LMS_SETUPS_PKG.deleteTreatyArrangement(?);END;";
            conn = new DBConnector().getDatabaseConn();

            CallableStatement cstmt = conn.prepareCall(deleteQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("ta_code"));
            cstmt.execute();
            cstmt.close();
            String Message = "Treaty Deleted succesfully.";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));


            ADFUtils.findIterator("findTreatyArrangementsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(treatiesTree);

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public void setArragementYear(RichInputText arragementYear) {
        this.arragementYear = arragementYear;
    }

    public RichInputText getArragementYear() {
        return arragementYear;
    }

    public String AddArrangement() {
        Connection conn = null;
        try {
            if (arragementYear.getValue() == null) {
                String Message = "Enter underwriting year.";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));
                return null;
            }

            String authQuery =
                "BEGIN LMS_SETUPS_PKG.updateArrangementSetups(?,?,?);END;";
            conn = new DBConnector().getDatabaseConn();

            CallableStatement cstmt = conn.prepareCall(authQuery);
            cstmt.setBigDecimal(1, null);
            cstmt.setBigDecimal(3,
                                (BigDecimal)session.getAttribute("ta_code"));
            cstmt.setBigDecimal(2,
                                new BigDecimal(arragementYear.getValue().toString()));
            cstmt.execute();
            cstmt.close();
            String Message = "Underwriting Year Added succesfully.";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));


            ADFUtils.findIterator("findArrangementSetupsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(arrangementSetupsLOV);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public String deleteArrangementSetup() {
        Connection conn = null;
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findArrangementSetupsIterator");
            RowKeySet set = arrangementSetupsLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();


            //System.out.println(1);
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();
                session.setAttribute("as_code", r.getAttribute("AS_CODE"));
                System.out.println("as_code   " + r.getAttribute("AS_CODE"));


                //session.setAttribute("gcoCode", null);


            }
            String deleteQuery =
                "BEGIN LMS_SETUPS_PKG.deleteArrangementSetup(?);END;";
            conn = new DBConnector().getDatabaseConn();

            CallableStatement cstmt = conn.prepareCall(deleteQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("as_code"));
            cstmt.execute();
            cstmt.close();
            String Message = "Arrangement Deleted succesfully.";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));


            ADFUtils.findIterator("findArrangementSetupsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(arrangementSetupsLOV);

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public String CloneProduct() {

        if (session.getAttribute("PRODCode") == null) {
            GlobalCC.INFORMATIONREPORTING("Select A Product.");
            return null;
        }

        newProdID.setValue(null);
        newProdDesc.setValue(null);
        newPolProdPrefix.setValue(null);
        newPropProdPrefix.setValue(null);
        newClaimProdPrefix.setValue(null);
        chkProdCovers.setSelected(true);
        chkProdCoverDeps.setSelected(true);

        clonePanel.setRendered(true);
        confirmPanel.setRendered(false);

        GlobalCC.showPopup("lmsgroup:clonepopup");
        return null;
    }

    public String ValidateCloneProductDetails() {

        if (newProdID.getValue() == null) {
            GlobalCC.INFORMATIONREPORTING("Enter A Product ID");
            return null;
        }

        if (newProdDesc.getValue() == null) {
            GlobalCC.INFORMATIONREPORTING("Enter A Product Description");
            return null;
        }

        if (newPolProdPrefix.getValue() == null) {
            GlobalCC.INFORMATIONREPORTING("Enter A Product Policy Prefix");
            return null;
        }

        if (newPropProdPrefix.getValue() == null) {
            GlobalCC.INFORMATIONREPORTING("Enter A Product Proposal Prefix");
            return null;
        }

        if (newClaimProdPrefix.getValue() == null) {
            GlobalCC.INFORMATIONREPORTING("Enter A Product Claim Prefix");
            return null;
        }

        if (newProdType.getValue() == null) {
            GlobalCC.INFORMATIONREPORTING("Select A Product Type");
            return null;
        }
        confirmPanel.setRendered(true);
        clonePanel.setRendered(false);
        AdfFacesContext.getCurrentInstance().addPartialTarget(confirmPanel);
        AdfFacesContext.getCurrentInstance().addPartialTarget(clonePanel);
        return null;
    }

    public String ProceedToCloneProduct() {
        Connection conn = null;
        try {
            String deleteQuery =
                "BEGIN LMS_SETUPS_PKG.replicateProduct(?,?,?,?,?,?,?,?,?);END;";
            conn = new DBConnector().getDatabaseConn();

            CallableStatement cstmt = conn.prepareCall(deleteQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("PRODCode"));
            if (newProdID.getValue() == null) {
                cstmt.setString(2, null);
            } else {
                cstmt.setString(2, newProdID.getValue().toString());
            }
            if (newProdDesc.getValue() == null) {
                cstmt.setString(3, null);
            } else {
                cstmt.setString(3, newProdDesc.getValue().toString());
            }
            if (newProdType.getValue() == null) {
                cstmt.setString(4, null);
            } else {
                cstmt.setString(4, newProdType.getValue().toString());
            }
            if (newPolProdPrefix.getValue() == null) {
                cstmt.setString(5, null);
            } else {
                cstmt.setString(5, newPolProdPrefix.getValue().toString());
            }
            if (newPropProdPrefix.getValue() == null) {
                cstmt.setString(6, null);
            } else {
                cstmt.setString(6, newPropProdPrefix.getValue().toString());
            }
            if (newClaimProdPrefix.getValue() == null) {
                cstmt.setString(7, null);
            } else {
                cstmt.setString(7, newClaimProdPrefix.getValue().toString());
            }
            if (chkProdCovers.isSelected()) {
                cstmt.setString(8, "Y");
            } else {
                cstmt.setString(8, "N");
            }
            if (chkProdCoverDeps.isSelected()) {
                cstmt.setString(9, "Y");
            } else {
                cstmt.setString(9, "N");
            }

            cstmt.execute();
            cstmt.close();

            GlobalCC.hidePopup("lmsgroup:clonepopup");

            ADFUtils.findIterator("findGroupProductsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(productTree);

            CreateNewProduct();
            GlobalCC.INFORMATIONREPORTING("Product Successully Cloned");

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public String CloneYear() {

        if (session.getAttribute("uw_yr") == null) {
            GlobalCC.INFORMATIONREPORTING("Select An Underwriting Year");
            return null;
        }
        cloneYear.setValue(session.getAttribute("uw_yr"));
        newYear.setValue(null);
        clonePanel.setRendered(true);
        confirmPanel.setRendered(false);

        GlobalCC.showPopup("lmsgroup:clonepopup");
        return null;
    }

    public String ValidateCloneDetails() {

        if (cloneYear.getValue() == null) {
            GlobalCC.INFORMATIONREPORTING("No Year to Clone Selected");
            return null;
        }

        if (newYear.getValue() == null) {
            GlobalCC.INFORMATIONREPORTING("Enter a New Year Description");
            return null;
        }
        confirmPanel.setRendered(true);
        clonePanel.setRendered(false);
        AdfFacesContext.getCurrentInstance().addPartialTarget(confirmPanel);
        AdfFacesContext.getCurrentInstance().addPartialTarget(clonePanel);
        return null;
    }

    public String CancelValidate() {

        clonePanel.setRendered(true);
        confirmPanel.setRendered(false);
        AdfFacesContext.getCurrentInstance().addPartialTarget(confirmPanel);
        AdfFacesContext.getCurrentInstance().addPartialTarget(clonePanel);
        return null;
    }

    public String ProceedToCloneYear() {
        Connection conn = null;
        try {
            String deleteQuery =
                "BEGIN LMS_SETUPS_PKG.replicateTrtyarrangement(?,?);END;";
            conn = new DBConnector().getDatabaseConn();

            CallableStatement cstmt = conn.prepareCall(deleteQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("as_code"));
            if (newYear.getValue() == null) {
                cstmt.setString(2, null);
            } else {
                cstmt.setString(2, newYear.getValue().toString());
            }

            cstmt.execute();
            cstmt.close();

            GlobalCC.hidePopup("lmsgroup:clonepopup");

            ADFUtils.findIterator("findArrangementSetupsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(arrangementSetupsLOV);

            GlobalCC.INFORMATIONREPORTING("UW Year Successully Cloned");

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public void ArrangementYears(SelectionEvent selectionEvent) {
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findArrangementSetupsIterator");
            RowKeySet set = selectionEvent.getAddedSet();
            Iterator rowKeySetIter = set.iterator();

            //System.out.println(1);
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();


                session.setAttribute("as_code", r.getAttribute("AS_CODE"));
                session.setAttribute("uw_yr", r.getAttribute("AS_UWYR"));
                System.out.println("as_code   " + r.getAttribute("AS_CODE"));
                productLabel.setValue(null);
                defaultTreatyProd.setValue(null);
                //session.setAttribute("gcoCode", null);

                session.setAttribute("trpd_code", null);
                session.setAttribute("ProductCode", null);
                treatyProductDesc.setValue(null);
                session.setAttribute("REI_CODE", null);
                arrangementDesc.setValue(null);

                ADFUtils.findIterator("findArrangementSetups1Iterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(treatyProductTree);

                session.setAttribute("TCT_CODE", null);
                ADFUtils.findIterator("findTreatyProdCoverTypesIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(treatyProdCoverTypesLOV);

                session.setAttribute("trsCode", null);
                ADFUtils.findIterator("findTreatySetupsIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(treatySetupsLOV);


                session.setAttribute("TCT_CODE", null);

                ADFUtils.findIterator("findArrangementCoverTypesCommRatesIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(commissionRatesLOV);

                ADFUtils.findIterator("findArrangementCoverTypesIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(arrangementCoverTypesLOV);


            }


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
    }

    public void setTreatyProductsLOV(RichTable treatyProductsLOV) {
        this.treatyProductsLOV = treatyProductsLOV;
    }

    public RichTable getTreatyProductsLOV() {
        return treatyProductsLOV;
    }

    public void TreatyProductsListener(SelectionEvent selectionEvent) {
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findArrangementSetups1Iterator");
            RowKeySet set = selectionEvent.getAddedSet();
            Iterator rowKeySetIter = set.iterator();

            //System.out.println(1);
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();


                session.setAttribute("trpd_code", r.getAttribute("TPRD_CODE"));
                System.out.println("trpd_code   " +
                                   r.getAttribute("TPRD_CODE"));
                session.setAttribute("ProductCode",
                                     r.getAttribute("TPRD_PROD_CODE"));
                //session.setAttribute("gcoCode", null);

                ADFUtils.findIterator("findTreatyProdCoverTypesIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(treatyProdCoverTypesLOV);


            }


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
    }

    public void setTreatyProdCoverTypesLOV(RichTable treatyProdCoverTypesLOV) {
        this.treatyProdCoverTypesLOV = treatyProdCoverTypesLOV;
    }

    public RichTable getTreatyProdCoverTypesLOV() {
        return treatyProdCoverTypesLOV;
    }

    public void setCredShtDesc(RichCommandButton credShtDesc) {
        this.credShtDesc = credShtDesc;
    }

    public RichCommandButton getCredShtDesc() {
        return credShtDesc;
    }

    public void setCredGroup(RichInputText credGroup) {
        this.credGroup = credGroup;
    }

    public RichInputText getCredGroup() {
        return credGroup;
    }

    public void setCrdShtDesc(RichInputText crdShtDesc) {
        this.crdShtDesc = crdShtDesc;
    }

    public RichInputText getCrdShtDesc() {
        return crdShtDesc;
    }

    public String AddCreditGroup() {
        if (crdShtDesc.getValue() == null) {
            String errMsg = "Enter The Group Short Description";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          errMsg,
                                                                          errMsg));
            return null;
        }
        if (credGroup.getValue() == null) {
            String errMsg = "Enter The Group  Description";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          errMsg,
                                                                          errMsg));
            return null;
        }
        String authQuery =
            "BEGIN LMS_SETUPS_PKG.add_intermed_group(?,?,?);END;";
        Connection conn = null;
        try {
            conn = new DBConnector().getDatabaseConn();

            CallableStatement cstmt = conn.prepareCall(authQuery);
            //cstmt.setBigDecimal(1,(BigDecimal)session.getAttribute("INGR_CODE"));
            cstmt.setString(1, crdShtDesc.getValue().toString());
            cstmt.setString(2, credGroup.getValue().toString());
            cstmt.setBigDecimal(3,
                                (BigDecimal)session.getAttribute("INGR_CODE"));
            cstmt.execute();
            cstmt.close();
            String Message = "Credit Group Saved Successfully.";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));


            ADFUtils.findIterator("findInterMedGroupsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(creditGroupsLOV);
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(null, ex);
        }
        return null;
    }

    public void setCreditGroupsLOV(RichTable creditGroupsLOV) {
        this.creditGroupsLOV = creditGroupsLOV;
    }

    public RichTable getCreditGroupsLOV() {
        return creditGroupsLOV;
    }

    public String EditCreditGroups() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findInterMedGroupsIterator");
        RowKeySet set = creditGroupsLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            session.setAttribute("INGR_CODE", r.getAttribute("INGR_CODE"));
            crdShtDesc.setValue(r.getAttribute("INGR_SHT_DESC"));
            credGroup.setValue(r.getAttribute("INGR_DESC"));


            // Render Popup
            ExtendedRenderKitService erkService =
                Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                   ExtendedRenderKitService.class);
            erkService.addScript(FacesContext.getCurrentInstance(),
                                 "var hints = {autodismissNever:false}; " +
                                 "AdfPage.PAGE.findComponent('" +
                                 "lmsgroup:creditCriterionPopup" +
                                 "').show(hints);");

        }
        return null;
    }

    public String deleteGroupCriterion() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findInterMedGroupsIterator");
        RowKeySet set = creditGroupsLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            session.setAttribute("INGR_CODE", r.getAttribute("INGR_CODE"));


        }
        String authQuery =
            "BEGIN LMS_SETUPS_PKG.delete_inter_med_group(?);END;";
        Connection conn = null;
        try {
            conn = new DBConnector().getDatabaseConn();

            CallableStatement cstmt = conn.prepareCall(authQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("INGR_CODE"));
            cstmt.execute();
            cstmt.close();
            String Message = "Credit Group Deleted Successfully.";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));


            ADFUtils.findIterator("findInterMedGroupsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(creditGroupsLOV);
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        }
        return null;
    }

    public void CreditGroupsListener(SelectionEvent selectionEvent) {
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findInterMedGroupsIterator");
            RowKeySet set = selectionEvent.getAddedSet();
            Iterator rowKeySetIter = set.iterator();

            //System.out.println(1);
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();


                session.setAttribute("INGR_CODE", r.getAttribute("INGR_CODE"));
                // System.out.println("trpd_code   "+r.getAttribute("TPRD_CODE"));
                //session.setAttribute("gcoCode", null);

                ADFUtils.findIterator("findCreditCriterionIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(creditCriterionLOV);


            }


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
    }

    public void setCreditCriterionLOV(RichTable creditCriterionLOV) {
        this.creditCriterionLOV = creditCriterionLOV;
    }

    public RichTable getCreditCriterionLOV() {
        return creditCriterionLOV;
    }

    public void setCreditCriteria(RichInputText creditCriteria) {
        this.creditCriteria = creditCriteria;
    }

    public RichInputText getCreditCriteria() {
        return creditCriteria;
    }

    public String SaveCriteria() {
        if (creditCriteria.getValue() == null) {
            String errMsg = "Enter The Credit Criteria";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          errMsg,
                                                                          errMsg));
            return null;
        }

        String authQuery =
            "BEGIN LMS_SETUPS_PKG.update_credit_criterion(?,?,?);END;";
        Connection conn = null;
        try {
            conn = new DBConnector().getDatabaseConn();

            CallableStatement cstmt = conn.prepareCall(authQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("CCR_CCR_CODE"));
            cstmt.setString(2, creditCriteria.getValue().toString());
            //cstmt.setString(2,credGroup.getValue().toString());
            cstmt.setBigDecimal(3,
                                (BigDecimal)session.getAttribute("INGR_CODE"));
            cstmt.execute();
            cstmt.close();
            String Message = "Credit Criteria Saved Successfully.";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));


            ADFUtils.findIterator("findCreditCriterionIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(creditCriterionLOV);
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(null, ex);
        }
        return null;
    }

    public String EditCriteria() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findCreditCriterionIterator");
        RowKeySet set = creditCriterionLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            session.setAttribute("INGR_CODE", r.getAttribute("CCR_INGR_CODE"));
            session.setAttribute("CCR_CCR_CODE", r.getAttribute("CCR_CODE"));
            //creditCriteria.setValue(r.getAttribute("INGR_SHT_DESC"));
            creditCriteria.setValue(r.getAttribute("CCR_DESCRIPTION"));


            // Render Popup
            ExtendedRenderKitService erkService =
                Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                   ExtendedRenderKitService.class);
            erkService.addScript(FacesContext.getCurrentInstance(),
                                 "var hints = {autodismissNever:false}; " +
                                 "AdfPage.PAGE.findComponent('" +
                                 "lmsgroup:criterionPopup" +
                                 "').show(hints);");

        }
        return null;
    }

    public String DeleteCriteria() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findCreditCriterionIterator");
        RowKeySet set = creditCriterionLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            session.setAttribute("INGR_CODE", r.getAttribute("CCR_INGR_CODE"));
            session.setAttribute("CCR_CCR_CODE", r.getAttribute("CCR_CODE"));
            //creditCriteria.setValue(r.getAttribute("INGR_SHT_DESC"));
            creditCriteria.setValue(r.getAttribute("CCR_DESCRIPTION"));


        }
        String authQuery =
            "BEGIN LMS_SETUPS_PKG.delete_credit_criterion(?);END;";
        Connection conn = null;
        try {
            conn = new DBConnector().getDatabaseConn();

            CallableStatement cstmt = conn.prepareCall(authQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("CCR_CCR_CODE"));
            cstmt.execute();
            cstmt.close();
            String Message = "Credit Criteria Deleted Successfully.";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));


            ADFUtils.findIterator("findCreditCriterionIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(creditCriterionLOV);
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        }
        return null;
    }

    public void intermediaryOption(ValueChangeEvent valueChangeEvent) {
        session.setAttribute("ClientOption",
                             clientAgentOption.getValue().toString());
    }

    public void setClientAgentOption(RichSelectOneRadio clientAgentOption) {
        this.clientAgentOption = clientAgentOption;
    }

    public RichSelectOneRadio getClientAgentOption() {
        return clientAgentOption;
    }

    public String AssignIntermediary() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findIntermediaryIterator");
        RowKeySet set = intermediaryLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            //session.setAttribute("INGR_CODE", r.getAttribute("CCR_INGR_CODE"));
            session.setAttribute("CLIENT_CODE", r.getAttribute("prpCode"));
            //creditCriteria.setValue(r.getAttribute("INGR_SHT_DESC"));
            interMediary.setValue(r.getAttribute("client"));


        }
        return null;
    }

    public void setInterMediary(RichInputText interMediary) {
        this.interMediary = interMediary;
    }

    public RichInputText getInterMediary() {
        return interMediary;
    }

    public void setIntermediaryLOV(RichTable intermediaryLOV) {
        this.intermediaryLOV = intermediaryLOV;
    }

    public RichTable getIntermediaryLOV() {
        return intermediaryLOV;
    }

    public void setIntermedCredGroupLOV(RichTable intermedCredGroupLOV) {
        this.intermedCredGroupLOV = intermedCredGroupLOV;
    }

    public RichTable getIntermedCredGroupLOV() {
        return intermedCredGroupLOV;
    }

    public String AssignCreditGroup() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findInterMedGroupsIterator");
        RowKeySet set = intermedCredGroupLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            session.setAttribute("INGR_CODE", r.getAttribute("INGR_CODE"));

            interMedCrditGroup.setValue(r.getAttribute("INGR_DESC"));


        }

        return null;
    }

    public void setInterMedCrditGroup(RichInputText interMedCrditGroup) {
        this.interMedCrditGroup = interMedCrditGroup;
    }

    public RichInputText getInterMedCrditGroup() {
        return interMedCrditGroup;
    }

    public String AssignInterMediaryGroup() {
        String authQuery =
            "BEGIN LMS_SETUPS_PKG.assign_credit_groupings(?,?,?,?);END;";
        Connection conn = null;
        try {
            conn = new DBConnector().getDatabaseConn();

            CallableStatement cstmt = conn.prepareCall(authQuery);
            //cstmt.setBigDecimal(1,(BigDecimal)session.getAttribute("INGR_CODE"));
            cstmt.setString(1, (String)session.getAttribute("ClientOption"));
            cstmt.setBigDecimal(2,
                                (BigDecimal)session.getAttribute("INGR_CODE"));
            cstmt.setBigDecimal(3,
                                (BigDecimal)session.getAttribute("CLIENT_CODE"));
            cstmt.setBigDecimal(4,
                                (BigDecimal)session.getAttribute("CLGR_CODE"));
            ;

            cstmt.execute();
            cstmt.close();
            String Message = "Credit Group Saved Successfully.";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));


        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        }
        return null;
    }

    public String AssignCreditAction() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findInterMedGroupsIterator");
        RowKeySet set = creditGroupsActionLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            session.setAttribute("INGR_CODE", r.getAttribute("INGR_CODE"));

            creditActionGroup.setValue(r.getAttribute("INGR_DESC"));
            //render popup
            ExtendedRenderKitService erkService =
                Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                   ExtendedRenderKitService.class);
            erkService.addScript(FacesContext.getCurrentInstance(),
                                 "var hints = {autodismissNever:false}; " +
                                 "AdfPage.PAGE.findComponent('" +
                                 "lmsgroup:AddCreditActions" +
                                 "').show(hints);");


        }

        return null;
    }

    public void setCreditGroupsActionLOV(RichTable creditGroupsActionLOV) {
        this.creditGroupsActionLOV = creditGroupsActionLOV;
    }

    public RichTable getCreditGroupsActionLOV() {
        return creditGroupsActionLOV;
    }

    public void setCreditActionGroup(RichInputText creditActionGroup) {
        this.creditActionGroup = creditActionGroup;
    }

    public RichInputText getCreditActionGroup() {
        return creditActionGroup;
    }

    public void CreateCreditActions() {
        String CreateQuery =
            "BEGIN LMS_SETUPS_PKG.updateCreditActions(?,?,?,?,?);END;";
        Connection conn = null;
        try {
            conn = new DBConnector().getDatabaseConn();

            CallableStatement cstmt = conn.prepareCall(CreateQuery);
            //cstmt.setBigDecimal(1,(BigDecimal)session.getAttribute("INGR_CODE"));
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("CRA_CRA_CODE"));
            cstmt.setString(2, creditDays.getValue().toString());
            cstmt.setString(3, creditAction.getValue().toString());
            cstmt.setString(4, creditWaiver.getValue().toString());
            cstmt.setBigDecimal(5,
                                (BigDecimal)session.getAttribute("INGR_CODE"));
            cstmt.execute();
            cstmt.close();
            String Message = "Credit Action Saved Successfully.";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));

            ADFUtils.findIterator("findCreditActionsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(creditGroupActionsLOV);

        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        }
        // return null;
    }

    public void setCreditDays(RichSelectOneChoice creditDays) {
        this.creditDays = creditDays;
    }

    public RichSelectOneChoice getCreditDays() {
        return creditDays;
    }

    public void setCreditAction(RichSelectOneChoice creditAction) {
        this.creditAction = creditAction;
    }

    public RichSelectOneChoice getCreditAction() {
        return creditAction;
    }

    public void setCreditWaiver(RichSelectOneChoice creditWaiver) {
        this.creditWaiver = creditWaiver;
    }

    public RichSelectOneChoice getCreditWaiver() {
        return creditWaiver;
    }

    public void setCreditGroupActionsLOV(RichTable creditGroupActionsLOV) {
        this.creditGroupActionsLOV = creditGroupActionsLOV;
    }

    public RichTable getCreditGroupActionsLOV() {
        return creditGroupActionsLOV;
    }

    public String EditCreditAction() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findCreditActionsIterator");
        RowKeySet set = creditGroupActionsLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            session.setAttribute("CRA_CRA_CODE", r.getAttribute("craCode"));
            creditDays.setValue(r.getAttribute("CRA_CREDIT_DAYS"));
            creditAction.setValue(r.getAttribute("CRA_ACTION"));
            creditWaiver.setValue(r.getAttribute("CRA_WAIVER"));
            creditActionGroup.setValue(r.getAttribute("CRA_INGR_DESC"));
            session.setAttribute("INGR_CODE", r.getAttribute("CRA_INGR_CODE"));
            //render popup
            ExtendedRenderKitService erkService =
                Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                   ExtendedRenderKitService.class);
            erkService.addScript(FacesContext.getCurrentInstance(),
                                 "var hints = {autodismissNever:false}; " +
                                 "AdfPage.PAGE.findComponent('" +
                                 "lmsgroup:AddCreditActions" +
                                 "').show(hints);");


        }
        return null;
    }

    public String DeleteCreditAction() {
        String deleteQuery = "BEGIN LMS_SETUPS_PKG.deleteCreditAction(?);END;";
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findCreditActionsIterator");
        RowKeySet set = creditGroupActionsLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            session.setAttribute("CRA_CRA_CODE", r.getAttribute("craCode"));


        }
        Connection conn = null;
        try {
            conn = new DBConnector().getDatabaseConn();

            CallableStatement cstmt = conn.prepareCall(deleteQuery);
            //cstmt.setBigDecimal(1,(BigDecimal)session.getAttribute("INGR_CODE"));
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("CRA_CRA_CODE"));

            cstmt.execute();
            cstmt.close();
            String Message = "Credit Action Deleted Successfully.";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));

            ADFUtils.findIterator("findCreditActionsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(creditGroupActionsLOV);

        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        }
        return null;
    }

    public String ReinitializeVariables() {
        session.setAttribute("CRA_CRA_CODE", null);
        session.setAttribute("PCT_CODE", null);

        coverTypeDesc.setValue(null);
        maxAssureds.setValue(null);
        covermaximumAge.setValue(null);
        coverFormula.setValue(null);
        coverRefundFormula.setValue(null);
        coverMainSAPerc.setValue(null);
        coverMaximumSA.setValue(null);
        coverRatesDependOnLifeClass.setValue(null);
        coverAccelerator.setValue(null);
        coverMandatory.setValue(null);
        coverGroupSingle.setValue(null);
        coverInbuilt.setValue(null);
        coverMainPercLbl.setRendered(false);
        coverMainSAPerc.setRendered(false);


        //render popup
        GlobalCC.showPopup("lmsgroup:AddProductCover");
        return null;
    }

    public void setCoverID(RichInputText coverID) {
        this.coverID = coverID;
    }

    public RichInputText getCoverID() {
        return coverID;
    }

    public void setCoverDescription(RichInputText coverDescription) {
        this.coverDescription = coverDescription;
    }

    public RichInputText getCoverDescription() {
        return coverDescription;
    }

    public void setMainCover(RichSelectOneChoice mainCover) {
        this.mainCover = mainCover;
    }

    public RichSelectOneChoice getMainCover() {
        return mainCover;
    }

    public void setMaximumAge(RichInputText maximumAge) {
        this.maximumAge = maximumAge;
    }

    public RichInputText getMaximumAge() {
        return maximumAge;
    }

    public void setMultiplier(RichInputText multiplier) {
        this.multiplier = multiplier;
    }

    public RichInputText getMultiplier() {
        return multiplier;
    }

    public void setDivisionFactor(RichInputText divisionFactor) {
        this.divisionFactor = divisionFactor;
    }

    public RichInputText getDivisionFactor() {
        return divisionFactor;
    }

    public void setCvtReadFrom(RichSelectOneChoice cvtReadFrom) {
        this.cvtReadFrom = cvtReadFrom;
    }

    public RichSelectOneChoice getCvtReadFrom() {
        return cvtReadFrom;
    }

    public void setCvtRateType(RichSelectOneChoice cvtRateType) {
        this.cvtRateType = cvtRateType;
    }

    public RichSelectOneChoice getCvtRateType() {
        return cvtRateType;
    }

    public void setCvtReportName(RichInputText cvtReportName) {
        this.cvtReportName = cvtReportName;
    }

    public RichInputText getCvtReportName() {
        return cvtReportName;
    }

    public void setCvtRemarks(RichInputText cvtRemarks) {
        this.cvtRemarks = cvtRemarks;
    }

    public RichInputText getCvtRemarks() {
        return cvtRemarks;
    }

    public void setPaRatesFreqOfPymt(RichSelectOneChoice paRatesFreqOfPymt) {
        this.paRatesFreqOfPymt = paRatesFreqOfPymt;
    }

    public RichSelectOneChoice getPaRatesFreqOfPymt() {
        return paRatesFreqOfPymt;
    }

    public String CreateCoverType() {
        if (coverID.getValue() == null) {
            String errMsg = "Enter The Cover Short Description";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          errMsg,
                                                                          errMsg));
            return null;
        }
        if (coverDescription.getValue() == null) {
            String errMsg = "Enter The Cover  Description";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          errMsg,
                                                                          errMsg));
            return null;
        }
        String CreateQuery =
            "BEGIN LMS_SETUPS_PKG.updateCoverTypes(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);END;";
        Connection conn = null;
        try {
            conn = new DBConnector().getDatabaseConn();

            CallableStatement cstmt = conn.prepareCall(CreateQuery);
            //cstmt.setBigDecimal(1,(BigDecimal)session.getAttribute("INGR_CODE"));
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("CVT_CODE"));
            cstmt.setString(2, coverID.getValue().toString());
            cstmt.setString(3, coverDescription.getValue().toString());
            cstmt.setString(4, mainCover.getValue().toString());
            cstmt.setString(5, durationType.getValue().toString());
            if (maximumAge.getValue() == null) {
                cstmt.setString(6, null);
            } else {
                cstmt.setString(6, maximumAge.getValue().toString());
            }
            if (multiplier.getValue() == null) {
                cstmt.setBigDecimal(7, new BigDecimal(1));

            } else {
                cstmt.setBigDecimal(7,
                                    new BigDecimal(multiplier.getValue().toString()));
            }
            if (divisionFactor.getValue() == null) {
                cstmt.setBigDecimal(8, new BigDecimal(1));

            } else {
                cstmt.setBigDecimal(8,
                                    new BigDecimal(divisionFactor.getValue().toString())); //v_cvt_mult_div_fact
            }
            if (cvtReadFrom.getValue() == null) {
                cstmt.setString(9, null);
            } else {
                cstmt.setString(9,
                                cvtReadFrom.getValue().toString()); //v_cvt_read_from
            }
            if (cvtRateType.getValue() == null) {
                cstmt.setString(10, null); //v_cvt_rate_type
            } else {
                cstmt.setString(10,
                                cvtRateType.getValue().toString()); //v_cvt_rate_type
            }

            if (cvtReportName.getValue() == null) {
                cstmt.setString(11, null); //v_cvt_report_name
            } else {
                cstmt.setString(11,
                                cvtReportName.getValue().toString()); //v_cvt_report_name
            }
            if (cvtRemarks.getValue() == null) {
                cstmt.setString(12, null); //v_cvt_remarks
            } else {
                cstmt.setString(12,
                                cvtRemarks.getValue().toString()); //v_cvt_remarks
            }
            if (paRatesFreqOfPymt.getValue() == null) {
                cstmt.setString(13, null); //v_CVT_RATES_FREQ_OF_PYMT
            } else {
                cstmt.setString(13,
                                paRatesFreqOfPymt.getValue().toString()); //v_CVT_RATES_FREQ_OF_PYMT
            }
            if (payBen.getValue() == null) {
                cstmt.setString(14, null); //v_CVT_RATES_FREQ_OF_PYMT
            } else {
                cstmt.setString(14,
                                payBen.getValue().toString()); //v_CVT_RATES_FREQ_OF_PYMT
            }
            if (maxInstPayable.getValue() == null) {
                cstmt.setString(15, null); //v_cvt_max installment
            } else {
                cstmt.setString(15, maxInstPayable.getValue().toString());
            }
            if (waitingPrd.getValue() == null) {
                cstmt.setString(16, null);

            } else {
                cstmt.setString(16, waitingPrd.getValue().toString());
            }
            if (retireAge.getValue() == null) {
                cstmt.setString(17, null);
            } else {
                cstmt.setString(17, retireAge.getValue().toString());
            }

            if (fixedSA.getValue() == null) {
                cstmt.setString(18, null);
            } else {
                cstmt.setString(18, fixedSA.getValue().toString());
            }
            if (fixed_sa_amt.getValue() == null) {
                cstmt.setString(19, null);
            } else {
                cstmt.setString(19, fixed_sa_amt.getValue().toString());
            }
            if (occupationalBen.getValue() == null) {
                cstmt.setString(20, null);
            } else {
                cstmt.setString(20, occupationalBen.getValue().toString());
            }
            if (notificationPeriod.getValue() == null) {
                cstmt.setString(21, null);
            } else {
                cstmt.setString(21, notificationPeriod.getValue().toString());
            }

            cstmt.execute();
            cstmt.close();
            String Message = "Cover Type Saved Successfully.";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));

            ADFUtils.findIterator("findCpverTypesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(coverTypesLOV);
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
            ex.printStackTrace();
        }
        return null;
    }

    public void setCoverTypesLOV(RichTable coverTypesLOV) {
        this.coverTypesLOV = coverTypesLOV;
    }

    public RichTable getCoverTypesLOV() {
        return coverTypesLOV;
    }

    public String EditCoverTypes() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findCpverTypesIterator");
        RowKeySet set = coverTypesLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            session.setAttribute("CVT_CODE", r.getAttribute("CVT_CODE"));
            coverID.setValue(r.getAttribute("CVT_SHT_DESC"));
            coverDescription.setValue(r.getAttribute("CVT_DESCRIPTION"));
            mainCover.setValue(r.getAttribute("CVT_MAIN_COVER"));
            durationType.setValue(r.getAttribute("CVT_DURATION_TYPE"));
            //multiplier.setValue(new BigDecimal((BigDecimal)r.getAttribute("CVT_MULTIPLIER")));
            //divisionFactor.setValue(new BigDecimal((BigDecimal)r.getAttribute("CVT_MULT_DIV_FACT")));
            cvtReadFrom.setValue(r.getAttribute("CVT_READ_FROM"));
            cvtRateType.setValue(r.getAttribute("CVT_RATE_TYPE"));
            if (r.getAttribute("CVT_REPORT_NAME") == null) {
                cvtReportName.setValue(null);
            } else {
                cvtReportName.setValue(r.getAttribute("CVT_REPORT_NAME"));
            }
            if (r.getAttribute("CVT_REMARKS") == null) {
                cvtRemarks.setValue(null);
            } else {
                cvtRemarks.setValue(r.getAttribute("CVT_REMARKS"));
            }
            payBen.setValue(r.getAttribute("CVT_PAY_BEN"));
            paRatesFreqOfPymt.setValue(r.getAttribute("CVT_RATES_FREQ_OF_PYMT"));
            maxInstPayable.setValue(r.getAttribute("CVT_MAX_INST_NO"));
            waitingPrd.setValue(r.getAttribute("CVT_WAITING_PRD"));
            fixedSA.setValue(r.getAttribute("CVT_FIXED_SA"));
            fixed_sa_amt.setValue(r.getAttribute("CVT_FIXED_SA_AMT"));
            notificationPeriod.setValue(r.getAttribute("CVT_NOTIFICATION_PRD"));
            //session.setAttribute("INGR_CODE", r.getAttribute("CRA_INGR_CODE"));
            //render popup
            ExtendedRenderKitService erkService =
                Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                   ExtendedRenderKitService.class);
            erkService.addScript(FacesContext.getCurrentInstance(),
                                 "var hints = {autodismissNever:false}; " +
                                 "AdfPage.PAGE.findComponent('" +
                                 "lmsgroup:CoverTypesPopup" +
                                 "').show(hints);");


        }
        return null;
    }

    public void setDurationType(RichSelectOneChoice durationType) {
        this.durationType = durationType;
    }

    public RichSelectOneChoice getDurationType() {
        return durationType;
    }

    public String DeleteCoverType() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findCpverTypesIterator");
        RowKeySet set = coverTypesLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            session.setAttribute("CVT_CODE", r.getAttribute("CVT_CODE"));
        }
        String DeleteQuery = "BEGIN LMS_SETUPS_PKG.deleteCoverType(?);END;";
        Connection conn = null;
        try {
            conn = new DBConnector().getDatabaseConn();

            CallableStatement cstmt = conn.prepareCall(DeleteQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("CVT_CODE"));
            cstmt.execute();
            cstmt.close();

            ADFUtils.findIterator("findCpverTypesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(coverTypesLOV);
            GlobalCC.INFORMATIONREPORTING("Cover Type Deleted Successfully.");

        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(null, ex);
        }
        return null;
    }

    public void setCoverTypesClassLOV(RichTable coverTypesClassLOV) {
        this.coverTypesClassLOV = coverTypesClassLOV;
    }

    public RichTable getCoverTypesClassLOV() {
        return coverTypesClassLOV;
    }

    public void CoverTypesClassListener(SelectionEvent selectionEvent) {
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findClassesofBusinessIterator");
            RowKeySet set = selectionEvent.getAddedSet();
            Iterator rowKeySetIter = set.iterator();

            System.out.println(1);
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();


                session.setAttribute("ClaCode", r.getAttribute("CLA_CODE"));
                //session.setAttribute("gcoCode", null);

                ADFUtils.findIterator("findProductsIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(coverTypesProductsLOV);


            }


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
    }

    public void setCoverTypesProductsLOV(RichTable coverTypesProductsLOV) {
        this.coverTypesProductsLOV = coverTypesProductsLOV;
    }

    public RichTable getCoverTypesProductsLOV() {
        return coverTypesProductsLOV;
    }

    public void CoverTypesProductsListener(SelectionEvent selectionEvent) {
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findProductsIterator");
            RowKeySet set = selectionEvent.getAddedSet();
            Iterator rowKeySetIter = set.iterator();

            System.out.println(1);
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();


                session.setAttribute("ProductCode",
                                     r.getAttribute("PROD_CODE"));
                //session.setAttribute("gcoCode", null);

                ADFUtils.findIterator("findProdCoverTypesIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(productCoverTypesLOV);


            }


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
    }

    public void CoverTypesProductsListenerII(SelectionEvent selectionEvent) {
        try {

            if (selectionEvent.getAddedSet() !=
                selectionEvent.getRemovedSet()) {
                RowKeySet keys = selectionEvent.getAddedSet();
                if (keys != null && keys.getSize() > 0) {
                    for (Object treeRowKey : keys) {
                        productTree.setRowKey(treeRowKey);
                        JUCtrlHierNodeBinding nd =
                            (JUCtrlHierNodeBinding)productTree.getRowData();


                        session.setAttribute("ProductCode",
                                             nd.getRow().getAttribute("PROD_CODE"));

                        ADFUtils.findIterator("findProdCoverTypesIterator").executeQuery();
                        AdfFacesContext.getCurrentInstance().addPartialTarget(productCoverTypesLOV);


                    }

                }
            }
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
    }


    public void setProductCoverTypesLOV(RichTable productCoverTypesLOV) {
        this.productCoverTypesLOV = productCoverTypesLOV;
    }

    public RichTable getProductCoverTypesLOV() {
        return productCoverTypesLOV;
    }

    public void setCoverTypeDesc(RichInputText coverTypeDesc) {
        this.coverTypeDesc = coverTypeDesc;
    }

    public RichInputText getCoverTypeDesc() {
        return coverTypeDesc;
    }

    public String AssignProductCoverType() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findCoverTypesLOVIterator");
        RowKeySet set = prodCoversLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            session.setAttribute("CVT_CODE", r.getAttribute("CVT_CODE"));
            coverTypeDesc.setValue(r.getAttribute("CVT_DESCRIPTION"));
            session.setAttribute("CVT_SHT_DESC",
                                 r.getAttribute("CVT_SHT_DESC"));

            String MainCover = (String)r.getAttribute("CVT_MAIN_COVER");
            if (MainCover.equalsIgnoreCase("RM") ||
                MainCover.equalsIgnoreCase("RA")) {
                coverMainPercLbl.setRendered(true);
                coverMainPercLbl.setValue("% of  Main/Yr Earn");
                coverMainSAPerc.setRendered(true);
            } else if (MainCover.equalsIgnoreCase("RL")) {
                coverMainPercLbl.setRendered(true);
                coverMainPercLbl.setValue("Multiple of Loan Repayment");
                coverMainSAPerc.setRendered(true);
            } else {
                coverMainPercLbl.setRendered(false);
                coverMainSAPerc.setRendered(false);
            }
        }
        GlobalCC.showPopup("lmsgroup:AddProductCover");
        return null;
    }

    public void setProdCoversLOV(RichTable prodCoversLOV) {
        this.prodCoversLOV = prodCoversLOV;
    }

    public RichTable getProdCoversLOV() {
        return prodCoversLOV;
    }

    public void setMaxAssureds(RichInputText maxAssureds) {
        this.maxAssureds = maxAssureds;
    }

    public RichInputText getMaxAssureds() {
        return maxAssureds;
    }

    public void setCovermaximumAge(RichInputText covermaximumAge) {
        this.covermaximumAge = covermaximumAge;
    }

    public RichInputText getCovermaximumAge() {
        return covermaximumAge;
    }

    public void setCoverFormula(RichSelectOneChoice coverFormula) {
        this.coverFormula = coverFormula;
    }

    public RichSelectOneChoice getCoverFormula() {
        return coverFormula;
    }

    public void setCoverRefundFormula(RichSelectOneChoice coverRefundFormula) {
        this.coverRefundFormula = coverRefundFormula;
    }

    public RichSelectOneChoice getCoverRefundFormula() {
        return coverRefundFormula;
    }

    public void setCoverMainSAPerc(RichInputText coverMainSAPerc) {
        this.coverMainSAPerc = coverMainSAPerc;
    }

    public RichInputText getCoverMainSAPerc() {
        return coverMainSAPerc;
    }

    public void setCoverMaximumSA(RichInputText coverMaximumSA) {
        this.coverMaximumSA = coverMaximumSA;
    }

    public RichInputText getCoverMaximumSA() {
        return coverMaximumSA;
    }

    public void setCoverRatesDependOnLifeClass(RichSelectOneChoice coverRatesDependOnLifeClass) {
        this.coverRatesDependOnLifeClass = coverRatesDependOnLifeClass;
    }

    public RichSelectOneChoice getCoverRatesDependOnLifeClass() {
        return coverRatesDependOnLifeClass;
    }

    public void setCoverAccelerator(RichSelectOneChoice coverAccelerator) {
        this.coverAccelerator = coverAccelerator;
    }

    public RichSelectOneChoice getCoverAccelerator() {
        return coverAccelerator;
    }

    public void setCoverMandatory(RichSelectOneChoice coverMandatory) {
        this.coverMandatory = coverMandatory;
    }

    public RichSelectOneChoice getCoverMandatory() {
        return coverMandatory;
    }

    public void setCoverGroupSingle(RichSelectOneChoice coverGroupSingle) {
        this.coverGroupSingle = coverGroupSingle;
    }

    public RichSelectOneChoice getCoverGroupSingle() {
        return coverGroupSingle;
    }

    public String SaveProductCoverType() {
        // Add event code here...
        return null;
    }

    public String SaveProductCover() {
        String SaveQuery =
            "BEGIN LMS_SETUPS_PKG.updateProductCover(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);END;";
        Connection conn = null;
        if (coverMandatory.getValue() == null) {
            String Message = "Specify if the cover is mandatory or not";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
        }
        if (covermaximumAge.getValue() == null) {
            String Message = "Specify if the cover is maximum age";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
        }
        if (coverFormula.getValue() == null) {
            String Message = "Specify the cover Formula";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
        }
        if (coverRefundFormula.getValue() == null) {
            String Message = "Specify the cover Refund Formula";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
        }
        if (coverGroupSingle.getValue() == null) {
            String Message =
                "Specify the whether the cover depends on Group Or Single Rates";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
        }
        try {
            conn = new DBConnector().getDatabaseConn();

            CallableStatement cstmt = conn.prepareCall(SaveQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("PCT_CODE"));
            cstmt.setBigDecimal(2,
                                (BigDecimal)session.getAttribute("CVT_CODE")); //v_cvt_code NUMBER
            cstmt.setString(3,
                            (String)session.getAttribute("CVT_SHT_DESC")); //v_cvt_sht_desc VARCHAR2,
            if (maxAssureds.getValue() == null) {
                cstmt.setBigDecimal(4, null); //v_max_assureds NUMBER
            } else {
                cstmt.setBigDecimal(4,
                                    new BigDecimal(maxAssureds.getValue().toString()));
            }
            cstmt.setBigDecimal(5,
                                (BigDecimal)session.getAttribute("ProductCode")); //v_prod_code NUMBER,
            cstmt.setBigDecimal(6,
                                new BigDecimal(covermaximumAge.getValue().toString())); //v_max_age NUMBER,
            cstmt.setString(7,
                            coverMandatory.getValue().toString()); //v_mandatory VARCHAR2,
            cstmt.setString(8,
                            coverFormula.getValue().toString()); //v_formula VARCHAR2,
            cstmt.setString(9,
                            coverRefundFormula.getValue().toString()); //v_refund_formula VARCHAR2
            if (coverMainSAPerc.getValue() == null) {
                cstmt.setString(10, null); //v_PCT_MAIN_SA_PERC NUMBER
            } else {
                cstmt.setString(10,
                                coverMainSAPerc.getValue().toString()); //v_PCT_MAIN_SA_PERC NUMBER
            }
            if (coverMaximumSA.getValue() == null) {
                cstmt.setString(11, null); //v_max_sa NUMBER,
            } else {
                cstmt.setString(11,
                                coverMaximumSA.getValue().toString()); //v_max_sa NUMBER,
            }
            if (coverRatesDependOnLifeClass.getValue() == null) {
                cstmt.setString(12, null); //v_PCT_RATE_DEPEND_ON_CLASS
            } else {
                cstmt.setString(12,
                                coverRatesDependOnLifeClass.getValue().toString()); //v_PCT_RATE_DEPEND_ON_CLASS
            }
            if (coverInbuilt.getValue() == null) {
                cstmt.setString(13, null); //v_PCT_INBUILT VARCHAR2
            } else {
                cstmt.setString(13,
                                coverInbuilt.getValue().toString()); //v_PCT_INBUILT VARCHAR2
            }
            if (coverAccelerator.getValue() == null) {
                cstmt.setString(14, null); //v_PCT_ACCELERATOR VARCHAR2,
            } else {
                cstmt.setString(14,
                                coverAccelerator.getValue().toString()); //v_PCT_ACCELERATOR VARCHAR2,
            }

            cstmt.setString(15,
                            coverGroupSingle.getValue().toString()); // v_PCT_GRP_OR_SINGLE_RATES VARCHAR2
            if (saDependLimit.getValue() == null) {
                cstmt.setString(16, "N"); //v_PCT_ACCELERATOR VARCHAR2,
            } else {
                cstmt.setString(16,
                                saDependLimit.getValue().toString()); //v_PCT_ACCELERATOR VARCHAR2,
            }
            if (thirteenthMonth.getValue() == null) {
                cstmt.setString(17, "N"); //v_PCT_ACCELERATOR VARCHAR2,
            } else {
                cstmt.setString(17,
                                thirteenthMonth.getValue().toString()); //v_PCT_ACCELERATOR VARCHAR2,
            }

            cstmt.setString(18, "N");
            /*if(loadAvgAge.getValue()==null) {
              cstmt.setString(18,"N");//v_PCT_ACCELERATOR VARCHAR2,
          }
          else {
              cstmt.setString(18,loadAvgAge.getValue().toString());//v_PCT_ACCELERATOR VARCHAR2,
          }*/

            if (errorMarginTF.getValue() == null) {
                cstmt.setString(19, null); //v_PCT_ACCELERATOR VARCHAR2,
            } else {
                cstmt.setString(19,
                                errorMarginTF.getValue().toString()); //v_PCT_ACCELERATOR VARCHAR2,
            }
            if (profitMarginTF.getValue() == null) {
                cstmt.setString(20, null); //v_PCT_ACCELERATOR VARCHAR2,
            } else {
                cstmt.setString(20,
                                profitMarginTF.getValue().toString()); //v_PCT_ACCELERATOR VARCHAR2,
            }

            if (mngtExpenseTF.getValue() == null) {
                cstmt.setString(21, null); //v_PCT_ACCELERATOR VARCHAR2,
            } else {
                cstmt.setString(21,
                                mngtExpenseTF.getValue().toString()); //v_PCT_ACCELERATOR VARCHAR2,
            }

            if (phcfTF.getValue() == null) {
                cstmt.setString(22, null); //v_PCT_ACCELERATOR VARCHAR2,
            } else {
                cstmt.setString(22,
                                phcfTF.getValue().toString()); //v_PCT_ACCELERATOR VARCHAR2,
            }
            if (adrRateTF.getValue() == null) {
                cstmt.setString(23, null); //v_PCT_ACCELERATOR VARCHAR2,
            } else {
                cstmt.setString(23,
                                adrRateTF.getValue().toString()); //v_PCT_ACCELERATOR VARCHAR2,
            }
            if (adrRateDivFactor.getValue() == null) {
                cstmt.setString(24, null); //v_PCT_ACCELERATOR VARCHAR2,
            } else {
                cstmt.setString(24,
                                adrRateDivFactor.getValue().toString()); //v_PCT_ACCELERATOR VARCHAR2,
            }
            if (medicalCost.getValue() == null) {
                cstmt.setString(25, null); //v_PCT_ACCELERATOR VARCHAR2,
            } else {
                cstmt.setString(25,
                                medicalCost.getValue().toString()); //v_PCT_ACCELERATOR VARCHAR2,
            }
            if (stampDuty.getValue() == null) {
                cstmt.setString(26, null); //v_PCT_ACCELERATOR VARCHAR2,
            } else {
                cstmt.setString(26,
                                stampDuty.getValue().toString()); //v_PCT_ACCELERATOR VARCHAR2,
            }
            if (pureCommRate.getValue() == null) {
                cstmt.setString(27, null); //v_PCT_ACCELERATOR VARCHAR2,
            } else {
                cstmt.setString(27,
                                pureCommRate.getValue().toString()); //v_PCT_ACCELERATOR VARCHAR2,
            }
            cstmt.setBigDecimal(28,
                                (BigDecimal)session.getAttribute("pmasCode"));

            cstmt.execute();
            cstmt.close();
            GlobalCC.INFORMATIONREPORTING("Cover Type Attached To Product Successfully.");
            ADFUtils.findIterator("findProdCoverTypesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(productCoverTypesLOV);
            GlobalCC.hidePopup("lmsgroup:AddProductCover");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
            e.printStackTrace();
        }
        return null;
    }

    public void setCoverInbuilt(RichSelectOneChoice coverInbuilt) {
        this.coverInbuilt = coverInbuilt;
    }

    public RichSelectOneChoice getCoverInbuilt() {
        return coverInbuilt;
    }

    public String UpdateProductCoverTypes() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findProdCoverTypesIterator");
        RowKeySet set = productCoverTypesLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            session.setAttribute("PCT_CODE", r.getAttribute("PCT_CODE"));
            coverTypeDesc.setValue(r.getAttribute("PCT_CVT_DESC"));
            maxAssureds.setValue(r.getAttribute("PCT_MAX_ASSUREDS"));
            covermaximumAge.setValue(r.getAttribute("PCT_MAX_AGE"));
            coverFormula.setValue(r.getAttribute("PCT_FORMULAR"));
            coverRefundFormula.setValue(r.getAttribute("PCT_REFUND_FORMULAR"));
            coverMaximumSA.setValue(r.getAttribute("PCT_MAX_SA"));
            saDependLimit.setValue(r.getAttribute("PCT_SA_DEPEND_ON_LIMIT"));
            if (r.getAttribute("PCT_RATE_DEPEND_ON_CLASS") == null) {
                coverRatesDependOnLifeClass.setValue(null);
            } else {
                coverRatesDependOnLifeClass.setValue(r.getAttribute("PCT_RATE_DEPEND_ON_CLASS"));
            }
            if (r.getAttribute("PCT_ACCELERATOR") == null) {
                coverAccelerator.setValue(null);
            } else {
                coverAccelerator.setValue(r.getAttribute("PCT_ACCELERATOR"));
            }

            coverMandatory.setValue(r.getAttribute("PCT_MANDATORY"));
            coverGroupSingle.setValue(r.getAttribute("PCT_GRP_OR_SINGLE_RATES"));

            coverInbuilt.setValue(r.getAttribute("PCT_INBUILT"));
            session.setAttribute("CVT_CODE", r.getAttribute("PCT_CVT_CODE"));
            session.setAttribute("CVT_SHT_DESC",
                                 r.getAttribute("PCT_CVT_SHT_DESC"));

            String MainCover = (String)r.getAttribute("CVT_MAIN_COVER");
            if (MainCover.equalsIgnoreCase("RM") ||
                MainCover.equalsIgnoreCase("RA")) {
                coverMainPercLbl.setRendered(true);
                coverMainPercLbl.setValue("% of  Main/Yr Earn");
                coverMainSAPerc.setRendered(true);
            } else if (MainCover.equalsIgnoreCase("RL")) {
                coverMainPercLbl.setRendered(true);
                coverMainPercLbl.setValue("Multiple of Loan Repayment");
                coverMainSAPerc.setRendered(true);
            } else {
                coverMainPercLbl.setRendered(false);
                coverMainSAPerc.setRendered(false);
            }
            coverMainSAPerc.setValue(r.getAttribute("PCT_MAIN_SA_PERC"));
            errorMarginTF.setValue(r.getAttribute("PCT_EM"));
            profitMarginTF.setValue(r.getAttribute("PCT_PROFIT_MARGIN"));
            mngtExpenseTF.setValue(r.getAttribute("PCT_MNGT_EXPENSES"));
            phcfTF.setValue(r.getAttribute("PCT_PHCF")); //PCT_MED_COST PCT_STAMP_DUTY PCT_ADR_RATE_DIV_FACT
            medicalCost.setValue(r.getAttribute("PCT_MED_COST"));
            stampDuty.setValue(r.getAttribute("PCT_STAMP_DUTY"));
            pureCommRate.setValue(r.getAttribute("PCT_COMM_RATE"));
            adrRateTF.setValue(r.getAttribute("PCT_ADR_RATE"));
            adrRateDivFactor.setValue(r.getAttribute("PCT_ADR_RATE_DIV_FACT"));
            maskDisplay.setValue(r.getAttribute("PMAS_SHT_DESC"));
        }

        GlobalCC.showPopup("lmsgroup:AddProductCover");
        return null;
    }

    public String DeleteProductCoverType() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findProdCoverTypesIterator");
        RowKeySet set = productCoverTypesLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            session.setAttribute("PCT_CODE", r.getAttribute("PCT_CODE"));
        }
        Connection conn = null;
        String DeleteQuery = "BEGIN LMS_SETUPS_PKG.deleteProductCover(?);END;";
        try {
            conn = new DBConnector().getDatabaseConn();

            CallableStatement cstmt = conn.prepareCall(DeleteQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("PCT_CODE"));
            cstmt.execute();
            cstmt.close();
            String Message = "Product Cover Type Deleted Successfully.";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
            ADFUtils.findIterator("findProdCoverTypesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(productCoverTypesLOV);
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        }

        return null;
    }


    public void productSelected(SelectionEvent selectionEvent) {

        RowKeySet keys = selectionEvent.getAddedSet();
        if (keys != null && keys.getSize() > 0) {
            for (Object treeRowKey : keys) {
                productTree.setRowKey(treeRowKey);
                JUCtrlHierNodeBinding nd =
                    (JUCtrlHierNodeBinding)productTree.getRowData();

                session.setAttribute("PRODCode",
                                     nd.getRow().getAttribute("PROD_CODE"));
                session.setAttribute("ProductCode",
                                     nd.getRow().getAttribute("PROD_CODE"));
                session.setAttribute("productType",
                                     nd.getRow().getAttribute("PROD_TYPE"));
                prodShtDesc.setValue(nd.getRow().getAttribute("PROD_SHT_DESC"));
                productDesc.setValue(nd.getRow().getAttribute("PROD_DESC"));
                cloneProduct.setValue(nd.getRow().getAttribute("PROD_DESC"));
                prodType.setValue(nd.getRow().getAttribute("PROD_TYPE"));
                newProdType.setValue(nd.getRow().getAttribute("PROD_TYPE"));
                prodMinAgeLimit.setValue(nd.getRow().getAttribute("PROD_MIN_AGE_LIMIT_YRS"));
                payGratuity.setValue(nd.getRow().getAttribute("PROD_PAY_GRATUITY"));
                prodMaxAgeLimit.setValue(nd.getRow().getAttribute("PROD_MAX_AGE_LIMIT_YRS"));
                prodMinTermYrs.setValue(nd.getRow().getAttribute("PROD_MIN_TERM_YRS"));
                prodMaxTermLimit.setValue(nd.getRow().getAttribute("PROD_MAX_TERM_YRS"));
                annuityAllowed.setValue(nd.getRow().getAttribute("PROD_ANNUITY_ALLOWED"));
                claimPrefixCode.setValue(nd.getRow().getAttribute("PROD_CLM_CODE_FIX"));
                openCover.setValue(nd.getRow().getAttribute("PROD_OPEN_COVER"));
                polPrefixCode.setValue(nd.getRow().getAttribute("PROD_POL_CODE_FIX"));
                proposalPrefix.setValue(nd.getRow().getAttribute("PROD_PROP_CODE_FIX"));
                cancellationNotice.setValue(nd.getRow().getAttribute("PROD_CANC_NOTICE_DAYS"));
                xolAllowed.setValue(nd.getRow().getAttribute("PROD_XOL_SETUP"));
                reinsMaxPeriod.setValue(nd.getRow().getAttribute("PROD_REIN_MAX_PRD_DAYS"));
                loanProduct.setValue(nd.getRow().getAttribute("PROD_LOAN_PRODUCT"));
                savingsCovered.setValue(nd.getRow().getAttribute("PROD_SAVINGS_COVERED"));
                osLoanCalc.setValue(nd.getRow().getAttribute("PROD_OS_LOAN_CALC"));
                defaultDOBMon.setValue(nd.getRow().getAttribute("PROD_DEFAULT_DOB"));
                refundCommission.setValue(nd.getRow().getAttribute("PROD_REFUND_COMM"));
                refundAllowed.setValue(nd.getRow().getAttribute("PROD_REFUND_ALLOWED"));
                initialScheEndorse.setValue(nd.getRow().getAttribute("PROD_INITIAL_SCH_ENDRSE"));
                System.out.println(nd.getRow().getAttribute("PROD_DEPENDT_COVERED"));
                productCovers.setValue(nd.getRow().getAttribute("PROD_DEPENDT_COVERED"));
                partialCancellationAllowed.setValue(nd.getRow().getAttribute("PROD_PARTIAL_CANCEL_ALLOWED"));
                claimExpiryPeriod.setValue(nd.getRow().getAttribute("PROD_CLAIM_EXPIRY_PRD"));
                productDebitAccNo.setValue(nd.getRow().getAttribute("PROD_DEBIT_ACC_NO"));
                unitRateApplicable.setValue(nd.getRow().getAttribute("PROD_UNIT_RATE_APPLICABLE"));
                applicableLapseType.setValue(nd.getRow().getAttribute("PROD_APPLICABLE_LAPSE_TYPE"));
                prodMinEarningsPeriod.setValue(nd.getRow().getAttribute("PROD_MIN_EARNINGS_PRD"));
                expectedScheduleReceptDay.setValue(nd.getRow().getAttribute("PROD_EXPECTED_SCH_RECPT_DAY"));
                autoGeneratePolicyNo.setValue(nd.getRow().getAttribute("PROD_GEN_POL_NO"));
                minFCLMembers.setValue(nd.getRow().getAttribute("PROD_MINIMUM_FCL_MEMBERS"));
                maximumFCLAmount.setValue(nd.getRow().getAttribute("PROD_FCL_MAX_AMT"));
                extAllowed.setValue(nd.getRow().getAttribute("PROD_EXTENTION_ALLOWED"));
                renAllowed.setValue(nd.getRow().getAttribute("PROD_RENEWAL_ALLOWED"));
                fctFactor1.setValue(nd.getRow().getAttribute("PROD_FCL_FACTOR1"));
                scheduleAdjustmentPeriod.setValue(nd.getRow().getAttribute("PROD_SCH_ADJ_PERIOD"));
                profitShareRate.setValue(nd.getRow().getAttribute("PROD_PROFIT_SHARE_RATE_PERC"));
                fclFactor2.setValue(nd.getRow().getAttribute("PROD_FCL_FACTOR2"));
                maximumExtensionPrd.setValue(nd.getRow().getAttribute("PROD_MAX_EXT_PERIOD"));
                addRefPremRate.setValue(nd.getRow().getAttribute("PROD_ADD_REF_PREM_PERC"));
                groupMinimumMembers.setValue(nd.getRow().getAttribute("PROD_GRP_RATES_MIN"));
                prodGLControlCode.setValue(nd.getRow().getAttribute("PROD_GL_CONTROL_CODE"));
                empPensionPrdPay.setValue(nd.getRow().getAttribute("PROD_EMP_FUND_PAY_PRD"));
                allowGracePeriod.setValue(nd.getRow().getAttribute("PROD_LOAN_GRACE_PRD"));
                emvCalculationType.setValue(nd.getRow().getAttribute("PROD_EMV_CALCULATION_TYPE"));
                valuationIntrCalc.setValue(nd.getRow().getAttribute("PROD_VAL_INTR_CALC_MODE"));
                prodWefDate.setValue(nd.getRow().getAttribute("PROD_WEF"));
                productStatus.setValue(nd.getRow().getAttribute("PROD_STATUS"));
                exceptionsNotificationAge.setValue(nd.getRow().getAttribute("PROD_EXC_NOT_AGE"));
                exceptionsNotificationSA.setValue(nd.getRow().getAttribute("PROD_EXC_NOT_SA"));
                prdEarningsType.setValue(nd.getRow().getAttribute("PROD_EARNING_PRD_TYPE"));
                fclType.setValue(nd.getRow().getAttribute("PROD_FCL_CALC_TYPE"));
                pensType.setValue(nd.getRow().getAttribute("PROD_PENS_TYPE"));
                pensContriLimit.setValue(nd.getRow().getAttribute("PROD_PENS_CONTRI_LIMIT"));
                loanGuard.setValue(nd.getRow().getAttribute("PROD_LOAN_GUARD"));
                quoteExpiryPeriod.setValue(nd.getRow().getAttribute("PROD_QUO_EXPIRY_PRD"));
                receiptingMode.setValue(nd.getRow().getAttribute("PROD_FMS_RECEIPTING"));
                fclSAFormula.setValue(nd.getRow().getAttribute("PROD_FCL_SA_FORMULA"));
                rateTypeCombo.setValue(nd.getRow().getAttribute("PROD_RATE_TYPE"));
                medGracePeriod.setValue(nd.getRow().getAttribute("PROD_MED_GRACE_PERIOD"));

            }

            AdfFacesContext.getCurrentInstance().addPartialTarget(prodPanGrp);
            ADFUtils.findIterator("findGroupDeathAcceptableIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(deathAcceptableLOV);

            ADFUtils.findIterator("findGroupPremiumFractionsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(premiumFractionsLOV);

            ADFUtils.findIterator("findGroupPremiumFractionsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(annualPremiumFractionsLOV);

            ADFUtils.findIterator("findPolicyDocumentsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(productPolDocsLOV);

            ADFUtils.findIterator("findLapsationIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(productLapsationDaysLOV);

            ADFUtils.findIterator("findProductPlansIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(productPlanLOV);

            ADFUtils.findIterator("findGroupScheduleReportsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(scheduleReportsLOV);

            //ADFUtils.findIterator("findProductExceptionsIterator").executeQuery();
            //AdfFacesContext.getCurrentInstance().addPartialTarget(productExceptionsLOV);
        }

    }

    public void setProductTree(RichTree productTree) {
        this.productTree = productTree;
    }

    public RichTree getProductTree() {
        return productTree;
    }

    public void setProdShtDesc(RichInputText prodShtDesc) {
        this.prodShtDesc = prodShtDesc;
    }

    public RichInputText getProdShtDesc() {
        return prodShtDesc;
    }

    public void setPrOD_CODE(RichPanelGroupLayout prOD_CODE) {
        this.prOD_CODE = prOD_CODE;
    }

    public RichPanelGroupLayout getPrOD_CODE() {
        return prOD_CODE;
    }

    public void setProdPanGrp(RichPanelGroupLayout prodPanGrp) {
        this.prodPanGrp = prodPanGrp;
    }

    public RichPanelGroupLayout getProdPanGrp() {
        return prodPanGrp;
    }

    public void setProductDesc(RichInputText productDesc) {
        this.productDesc = productDesc;
    }

    public RichInputText getProductDesc() {
        return productDesc;
    }

    public void setProdType(RichSelectOneChoice prodType) {
        this.prodType = prodType;
    }

    public RichSelectOneChoice getProdType() {
        return prodType;
    }

    public void setProdMinAgeLimit(RichInputText prodMinAgeLimit) {
        this.prodMinAgeLimit = prodMinAgeLimit;
    }

    public RichInputText getProdMinAgeLimit() {
        return prodMinAgeLimit;
    }

    public void setPayGratuity(RichSelectOneChoice payGratuity) {
        this.payGratuity = payGratuity;
    }

    public RichSelectOneChoice getPayGratuity() {
        return payGratuity;
    }

    public void setProdMaxAgeLimit(RichInputText prodMaxAgeLimit) {
        this.prodMaxAgeLimit = prodMaxAgeLimit;
    }

    public RichInputText getProdMaxAgeLimit() {
        return prodMaxAgeLimit;
    }

    public void setProdMinTermYrs(RichInputText prodMinTermYrs) {
        this.prodMinTermYrs = prodMinTermYrs;
    }

    public RichInputText getProdMinTermYrs() {
        return prodMinTermYrs;
    }

    public void setAnnuityAllowed(RichSelectOneChoice annuityAllowed) {
        this.annuityAllowed = annuityAllowed;
    }

    public RichSelectOneChoice getAnnuityAllowed() {
        return annuityAllowed;
    }

    public void setClaimPrefixCode(RichInputText claimPrefixCode) {
        this.claimPrefixCode = claimPrefixCode;
    }

    public RichInputText getClaimPrefixCode() {
        return claimPrefixCode;
    }

    public void setOpenCover(RichSelectOneChoice openCover) {
        this.openCover = openCover;
    }

    public RichSelectOneChoice getOpenCover() {
        return openCover;
    }

    public void setPolPrefixCode(RichInputText polPrefixCode) {
        this.polPrefixCode = polPrefixCode;
    }

    public RichInputText getPolPrefixCode() {
        return polPrefixCode;
    }

    public void setProposalPrefix(RichInputText proposalPrefix) {
        this.proposalPrefix = proposalPrefix;
    }

    public RichInputText getProposalPrefix() {
        return proposalPrefix;
    }

    public void setCancellationNotice(RichInputText cancellationNotice) {
        this.cancellationNotice = cancellationNotice;
    }

    public RichInputText getCancellationNotice() {
        return cancellationNotice;
    }

    public void setXolAllowed(RichSelectOneChoice xolAllowed) {
        this.xolAllowed = xolAllowed;
    }

    public RichSelectOneChoice getXolAllowed() {
        return xolAllowed;
    }

    public void setReinsMaxPeriod(RichInputText reinsMaxPeriod) {
        this.reinsMaxPeriod = reinsMaxPeriod;
    }

    public RichInputText getReinsMaxPeriod() {
        return reinsMaxPeriod;
    }

    public void setLoanProduct(RichSelectOneChoice loanProduct) {
        this.loanProduct = loanProduct;
    }

    public RichSelectOneChoice getLoanProduct() {
        return loanProduct;
    }

    public void setSavingsCovered(RichSelectOneChoice savingsCovered) {
        this.savingsCovered = savingsCovered;
    }

    public RichSelectOneChoice getSavingsCovered() {
        return savingsCovered;
    }

    public void setOsLoanCalc(RichSelectOneChoice osLoanCalc) {
        this.osLoanCalc = osLoanCalc;
    }

    public RichSelectOneChoice getOsLoanCalc() {
        return osLoanCalc;
    }

    public void setDefaultDOB(RichInputDate defaultDOB) {
        this.defaultDOB = defaultDOB;
    }

    public RichInputDate getDefaultDOB() {
        return defaultDOB;
    }

    public void setRefundCommission(RichSelectOneChoice refundCommission) {
        this.refundCommission = refundCommission;
    }

    public RichSelectOneChoice getRefundCommission() {
        return refundCommission;
    }

    public void setRefundAllowed(RichSelectOneChoice refundAllowed) {
        this.refundAllowed = refundAllowed;
    }

    public RichSelectOneChoice getRefundAllowed() {
        return refundAllowed;
    }

    public void setInitialScheEndorse(RichSelectOneChoice initialScheEndorse) {
        this.initialScheEndorse = initialScheEndorse;
    }

    public RichSelectOneChoice getInitialScheEndorse() {
        return initialScheEndorse;
    }

    public void setProductCovers(RichSelectOneChoice productCovers) {
        this.productCovers = productCovers;
    }

    public RichSelectOneChoice getProductCovers() {
        return productCovers;
    }

    public void setPartialCancellationAllowed(RichSelectOneChoice partialCancellationAllowed) {
        this.partialCancellationAllowed = partialCancellationAllowed;
    }

    public RichSelectOneChoice getPartialCancellationAllowed() {
        return partialCancellationAllowed;
    }

    public void setClaimExpiryPeriod(RichInputText claimExpiryPeriod) {
        this.claimExpiryPeriod = claimExpiryPeriod;
    }

    public RichInputText getClaimExpiryPeriod() {
        return claimExpiryPeriod;
    }

    public void setProductDebitAccNo(RichInputText productDebitAccNo) {
        this.productDebitAccNo = productDebitAccNo;
    }

    public RichInputText getProductDebitAccNo() {
        return productDebitAccNo;
    }

    public void setUnitRateApplicable(RichSelectOneChoice unitRateApplicable) {
        this.unitRateApplicable = unitRateApplicable;
    }

    public RichSelectOneChoice getUnitRateApplicable() {
        return unitRateApplicable;
    }

    public void setApplicableLapseType(RichSelectOneChoice applicableLapseType) {
        this.applicableLapseType = applicableLapseType;
    }

    public RichSelectOneChoice getApplicableLapseType() {
        return applicableLapseType;
    }

    public void setProdMinEarningsPeriod(RichInputText prodMinEarningsPeriod) {
        this.prodMinEarningsPeriod = prodMinEarningsPeriod;
    }

    public RichInputText getProdMinEarningsPeriod() {
        return prodMinEarningsPeriod;
    }

    public void setExpectedScheduleReceptDay(RichInputText expectedScheduleReceptDay) {
        this.expectedScheduleReceptDay = expectedScheduleReceptDay;
    }

    public RichInputText getExpectedScheduleReceptDay() {
        return expectedScheduleReceptDay;
    }

    public void setAutoGeneratePolicyNo(RichSelectOneChoice autoGeneratePolicyNo) {
        this.autoGeneratePolicyNo = autoGeneratePolicyNo;
    }

    public RichSelectOneChoice getAutoGeneratePolicyNo() {
        return autoGeneratePolicyNo;
    }

    public void setMinimumFCLMembers(RichOutputLabel minimumFCLMembers) {
        this.minimumFCLMembers = minimumFCLMembers;
    }

    public RichOutputLabel getMinimumFCLMembers() {
        return minimumFCLMembers;
    }

    public void setMinimumFCLAmount(RichInputText minimumFCLAmount) {
        this.minimumFCLAmount = minimumFCLAmount;
    }

    public RichInputText getMinimumFCLAmount() {
        return minimumFCLAmount;
    }

    public void setExtensionAllowed(RichSelectOneChoice extensionAllowed) {
        this.extensionAllowed = extensionAllowed;
    }

    public RichSelectOneChoice getExtensionAllowed() {
        return extensionAllowed;
    }

    public void setRenewalAllowed(RichInputText renewalAllowed) {
        this.renewalAllowed = renewalAllowed;
    }

    public RichInputText getRenewalAllowed() {
        return renewalAllowed;
    }

    public void setFctFactor1(RichInputText fctFactor1) {
        this.fctFactor1 = fctFactor1;
    }

    public RichInputText getFctFactor1() {
        return fctFactor1;
    }

    public void setScheduleAdjustmentPeriod(RichInputText scheduleAdjustmentPeriod) {
        this.scheduleAdjustmentPeriod = scheduleAdjustmentPeriod;
    }

    public RichInputText getScheduleAdjustmentPeriod() {
        return scheduleAdjustmentPeriod;
    }

    public void setProfitShareRate(RichInputText profitShareRate) {
        this.profitShareRate = profitShareRate;
    }

    public RichInputText getProfitShareRate() {
        return profitShareRate;
    }

    public void setFclFactor2(RichInputText fclFactor2) {
        this.fclFactor2 = fclFactor2;
    }

    public RichInputText getFclFactor2() {
        return fclFactor2;
    }

    public void setMinFCLMembers(RichInputText minFCLMembers) {
        this.minFCLMembers = minFCLMembers;
    }

    public RichInputText getMinFCLMembers() {
        return minFCLMembers;
    }

    public void setMaximumFCLAmount(RichInputText maximumFCLAmount) {
        this.maximumFCLAmount = maximumFCLAmount;
    }

    public RichInputText getMaximumFCLAmount() {
        return maximumFCLAmount;
    }

    public void setExtAllowed(RichSelectOneChoice extAllowed) {
        this.extAllowed = extAllowed;
    }

    public RichSelectOneChoice getExtAllowed() {
        return extAllowed;
    }

    public void setRenAllowed(RichSelectOneChoice renAllowed) {
        this.renAllowed = renAllowed;
    }

    public RichSelectOneChoice getRenAllowed() {
        return renAllowed;
    }

    public void setMaximumExtensionPrd(RichInputText maximumExtensionPrd) {
        this.maximumExtensionPrd = maximumExtensionPrd;
    }

    public RichInputText getMaximumExtensionPrd() {
        return maximumExtensionPrd;
    }

    public void setAddRefPremRate(RichInputText addRefPremRate) {
        this.addRefPremRate = addRefPremRate;
    }

    public RichInputText getAddRefPremRate() {
        return addRefPremRate;
    }

    public void setGroupMinimumMembers(RichInputText groupMinimumMembers) {
        this.groupMinimumMembers = groupMinimumMembers;
    }

    public RichInputText getGroupMinimumMembers() {
        return groupMinimumMembers;
    }

    public void setProdGLControlCode(RichInputText prodGLControlCode) {
        this.prodGLControlCode = prodGLControlCode;
    }

    public RichInputText getProdGLControlCode() {
        return prodGLControlCode;
    }

    public void setEmpPensionPrdPay(RichInputText empPensionPrdPay) {
        this.empPensionPrdPay = empPensionPrdPay;
    }

    public RichInputText getEmpPensionPrdPay() {
        return empPensionPrdPay;
    }

    public void setAllowGracePeriod(RichSelectOneChoice allowGracePeriod) {
        this.allowGracePeriod = allowGracePeriod;
    }

    public RichSelectOneChoice getAllowGracePeriod() {
        return allowGracePeriod;
    }

    public void setEmvCalculationType(RichSelectOneChoice emvCalculationType) {
        this.emvCalculationType = emvCalculationType;
    }

    public RichSelectOneChoice getEmvCalculationType() {
        return emvCalculationType;
    }

    public void setValuationIntrCalc(RichSelectOneChoice valuationIntrCalc) {
        this.valuationIntrCalc = valuationIntrCalc;
    }

    public RichSelectOneChoice getValuationIntrCalc() {
        return valuationIntrCalc;
    }

    public void setDeathAcceptableLOV(RichTable deathAcceptableLOV) {
        this.deathAcceptableLOV = deathAcceptableLOV;
    }

    public RichTable getDeathAcceptableLOV() {
        return deathAcceptableLOV;
    }

    public void setDeathTotalNo(RichInputText deathTotalNo) {
        this.deathTotalNo = deathTotalNo;
    }

    public RichInputText getDeathTotalNo() {
        return deathTotalNo;
    }

    public void setDeathAcceptableNo(RichInputText deathAcceptableNo) {
        this.deathAcceptableNo = deathAcceptableNo;
    }

    public RichInputText getDeathAcceptableNo() {
        return deathAcceptableNo;
    }

    public String SaveDeathAcceptable() {
        String saveQuery =
            "BEGIN LMS_SETUPS_PKG.updateDeathAccepatble(?,?,?,?);END;";
        if (deathTotalNo.getValue() == null) {
            String errMsg = "Enter The Group Total Number";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          errMsg,
                                                                          errMsg));
        }
        if (deathAcceptableNo.getValue() == null) {
            String errMsg = "Enter The Death Acceptable No";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          errMsg,
                                                                          errMsg));
        }
        Connection conn = null;
        try {
            conn = new DBConnector().getDatabaseConn();

            CallableStatement cstmt = conn.prepareCall(saveQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("PDA_CODE"));
            cstmt.setBigDecimal(2,
                                new BigDecimal(deathTotalNo.getValue().toString()));
            cstmt.setBigDecimal(3,
                                new BigDecimal(deathAcceptableNo.getValue().toString()));
            cstmt.setBigDecimal(4,
                                (BigDecimal)session.getAttribute("PRODCode"));
            cstmt.execute();
            cstmt.close();
            String Message = "Death Acceptable Details Saved Successfully.";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
            ADFUtils.findIterator("findGroupDeathAcceptableIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(deathAcceptableLOV);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public String DeleteDeathAcceptableNo() {
        String Result = "F";
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findGroupDeathAcceptableIterator");
        RowKeySet set = deathAcceptableLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            session.setAttribute("PDA_CODE", r.getAttribute("PDA_CODE"));
        }
        String DeleteQuery =
            "BEGIN LMS_SETUPS_PKG.deleteDeathAcceptable(?);END;";

        Connection conn = null;
        try {
            conn = new DBConnector().getDatabaseConn();

            CallableStatement cstmt = conn.prepareCall(DeleteQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("PDA_CODE"));
            cstmt.execute();
            cstmt.close();
            String Message = "Death Acceptable Detail Deleted Successfully.";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
            ADFUtils.findIterator("findGroupDeathAcceptableIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(deathAcceptableLOV);
            GlobalCC.INFORMATIONREPORTING("Record Successfully Deleted");
            Result = "S";
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        }
        return Result;
    }

    public String EditDeathAcceptable() {
        // Add event code here...
        return null;
    }

    public void setQuarterlyRate(RichInputText quarterlyRate) {
        this.quarterlyRate = quarterlyRate;
    }

    public RichInputText getQuarterlyRate() {
        return quarterlyRate;
    }

    public void setPremiumFractionsLOV(RichTable premiumFractionsLOV) {
        this.premiumFractionsLOV = premiumFractionsLOV;
    }

    public RichTable getPremiumFractionsLOV() {
        return premiumFractionsLOV;
    }

    public void setAnnualPremiumFractionsLOV(RichTable annualPremiumFractionsLOV) {
        this.annualPremiumFractionsLOV = annualPremiumFractionsLOV;
    }

    public RichTable getAnnualPremiumFractionsLOV() {
        return annualPremiumFractionsLOV;
    }

    public void setMonthlyToAnnRate(RichInputText monthlyToAnnRate) {
        this.monthlyToAnnRate = monthlyToAnnRate;
    }

    public RichInputText getMonthlyToAnnRate() {
        return monthlyToAnnRate;
    }

    public void setSemiToMonthlyRate(RichInputText semiToMonthlyRate) {
        this.semiToMonthlyRate = semiToMonthlyRate;
    }

    public RichInputText getSemiToMonthlyRate() {
        return semiToMonthlyRate;
    }

    public void setAnnualToMonthlyRate(RichInputText annualToMonthlyRate) {
        this.annualToMonthlyRate = annualToMonthlyRate;
    }

    public RichInputText getAnnualToMonthlyRate() {
        return annualToMonthlyRate;
    }

    public String UpdateMonthlyPreFractions() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findGroupPremiumFractionsIterator");
        RowKeySet set = premiumFractionsLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            //session.setAttribute("CVT_CODE", r.getAttribute("CVT_CODE"));
            monthlyToAnnRate.setValue(r.getAttribute("PROD_MNTH_TO_ANNL_FCTOR"));
            semiToMonthlyRate.setValue(r.getAttribute("PROD_MNTH_TO_S_ANNL_FCTOR"));
            annualToMonthlyRate.setValue(r.getAttribute("PROD_MNTH_TO_QTR_FCTOR"));
            //session.setAttribute("CVT_SHT_DESC",r.getAttribute("CVT_SHT_DESC"));

        }
        ExtendedRenderKitService erkService =
            Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                               ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
                             "var hints = {autodismissNever:false}; " +
                             "AdfPage.PAGE.findComponent('" +
                             "lmsgroup:MonthlyPremiumFractionsPopup" +
                             "').show(hints);");
        return null;

    }

    public void setAnnToMonthlyRate(RichInputText annToMonthlyRate) {
        this.annToMonthlyRate = annToMonthlyRate;
    }

    public RichInputText getAnnToMonthlyRate() {
        return annToMonthlyRate;
    }

    public void setSemiToAnnualRate(RichInputText semiToAnnualRate) {
        this.semiToAnnualRate = semiToAnnualRate;
    }

    public RichInputText getSemiToAnnualRate() {
        return semiToAnnualRate;
    }

    public void setAnnualToQuarterlyRate(RichInputText annualToQuarterlyRate) {
        this.annualToQuarterlyRate = annualToQuarterlyRate;
    }

    public RichInputText getAnnualToQuarterlyRate() {
        return annualToQuarterlyRate;
    }

    public String UpdateAnnualPreFractions() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findGroupPremiumFractionsIterator");
        RowKeySet set = annualPremiumFractionsLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            //session.setAttribute("CVT_CODE", r.getAttribute("CVT_CODE"));
            annToMonthlyRate.setValue(r.getAttribute("PROD_YR_TO_MONTH_RATE"));
            semiToAnnualRate.setValue(r.getAttribute("PROD_YR_TO_QUATER_RATE"));
            annualToQuarterlyRate.setValue(r.getAttribute("PROD_YR_TO_S_ANNL_RATE"));
            //session.setAttribute("CVT_SHT_DESC",r.getAttribute("CVT_SHT_DESC"));

        }
        ExtendedRenderKitService erkService =
            Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                               ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
                             "var hints = {autodismissNever:false}; " +
                             "AdfPage.PAGE.findComponent('" +
                             "lmsgroup:UpdateAnnualPremiumFractionsPopup" +
                             "').show(hints);");
        return null;
    }

    public void setScheduleReportsLOV(RichTable scheduleReportsLOV) {
        this.scheduleReportsLOV = scheduleReportsLOV;
    }

    public RichTable getScheduleReportsLOV() {
        return scheduleReportsLOV;
    }

    public void setQuotationCosting(RichInputText quotationCosting) {
        this.quotationCosting = quotationCosting;
    }

    public RichInputText getQuotationCosting() {
        return quotationCosting;
    }

    public void setQuotationSavings(RichInputText quotationSavings) {
        this.quotationSavings = quotationSavings;
    }

    public RichInputText getQuotationSavings() {
        return quotationSavings;
    }

    public void setQuotationFuneral(RichInputText quotationFuneral) {
        this.quotationFuneral = quotationFuneral;
    }

    public RichInputText getQuotationFuneral() {
        return quotationFuneral;
    }

    public void setAggregateCosting(RichInputText aggregateCosting) {
        this.aggregateCosting = aggregateCosting;
    }

    public RichInputText getAggregateCosting() {
        return aggregateCosting;
    }

    public void setUwCosting(RichInputText uwCosting) {
        this.uwCosting = uwCosting;
    }

    public RichInputText getUwCosting() {
        return uwCosting;
    }

    public void setUwSavings(RichInputText uwSavings) {
        this.uwSavings = uwSavings;
    }

    public RichInputText getUwSavings() {
        return uwSavings;
    }

    public void setUwFuneral(RichInputText uwFuneral) {
        this.uwFuneral = uwFuneral;
    }

    public RichInputText getUwFuneral() {
        return uwFuneral;
    }

    public void setUwRefund(RichInputText uwRefund) {
        this.uwRefund = uwRefund;
    }

    public RichInputText getUwRefund() {
        return uwRefund;
    }

    public void setPolCosting(RichInputText polCosting) {
        this.polCosting = polCosting;
    }

    public RichInputText getPolCosting() {
        return polCosting;
    }

    public void setPolSavings(RichInputText polSavings) {
        this.polSavings = polSavings;
    }

    public RichInputText getPolSavings() {
        return polSavings;
    }

    public void setPolicyFuneral(RichInputText policyFuneral) {
        this.policyFuneral = policyFuneral;
    }

    public RichInputText getPolicyFuneral() {
        return policyFuneral;
    }

    public void setRenewalCosting(RichInputText renewalCosting) {
        this.renewalCosting = renewalCosting;
    }

    public RichInputText getRenewalCosting() {
        return renewalCosting;
    }

    public void setRenewalSavings(RichInputText renewalSavings) {
        this.renewalSavings = renewalSavings;
    }

    public RichInputText getRenewalSavings() {
        return renewalSavings;
    }

    public void setRenewalFuneral(RichInputText renewalFuneral) {
        this.renewalFuneral = renewalFuneral;
    }

    public RichInputText getRenewalFuneral() {
        return renewalFuneral;
    }

    public String SaveMonthlyFractions() {
        Connection conn = null;
        String addQuery =
            "BEGIN LMS_SETUPS_PKG.update_annual_prem_fractions(?,?,?,?);END;";

        try {
            conn = new DBConnector().getDatabaseConn();

            CallableStatement cstmt = conn.prepareCall(addQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("PRODCode"));
            if (annToMonthlyRate.getValue() == null) {
                cstmt.setString(2, null);
            } else {
                cstmt.setString(2, annToMonthlyRate.getValue().toString());
            }
            if (semiToAnnualRate.getValue() == null) {
                cstmt.setString(3, null);
            } else {
                cstmt.setString(3, semiToAnnualRate.getValue().toString());
            }
            if (annualToQuarterlyRate.getValue() == null) {
                cstmt.setString(4, null);
            } else {
                cstmt.setString(4,
                                annualToQuarterlyRate.getValue().toString());
            }


            cstmt.execute();
            conn.close();
            String Message = "Premium Fractions updated succesfully.";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));


            ADFUtils.findIterator("findGroupPremiumFractionsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(premiumFractionsLOV);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public String UpdateScheduleReports() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findGroupScheduleReportsIterator");
        RowKeySet set = scheduleReportsLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            //session.setAttribute("CVT_CODE", r.getAttribute("CVT_CODE"));
            if (r.getAttribute("PROD_QUO_COSTING_SCH_RPT") == null) {
                quotationCosting.setValue(null);

            } else {
                quotationCosting.setValue(r.getAttribute("PROD_QUO_COSTING_SCH_RPT"));
            }
            if (r.getAttribute("PROD_QUO_SAVINGS_SCH_RPT") == null) {
                quotationSavings.setValue(null);
            } else {
                quotationSavings.setValue(r.getAttribute("PROD_QUO_SAVINGS_SCH_RPT"));
            }
            if (r.getAttribute("PROD_QUO_FE_SCH_RPT") == null) {
                quotationFuneral.setValue(null);
            } else {
                quotationFuneral.setValue(r.getAttribute("PROD_QUO_FE_SCH_RPT"));
            }
            if (r.getAttribute("PROD_QUO_AGGR_DTLS_RPT") == null) {
                aggregateCosting.setValue(null);
            } else {
                aggregateCosting.setValue(r.getAttribute("PROD_QUO_AGGR_DTLS_RPT"));
            }
            if (r.getAttribute("PROD_UW_COSTING_SCH_RPT") == null) {
                uwCosting.setValue(null);
            } else {
                uwCosting.setValue(r.getAttribute("PROD_UW_COSTING_SCH_RPT"));
            }
            if (r.getAttribute("PROD_UW_SAVING_SCH_RPT") == null) {
                uwSavings.setValue(null);
            } else {
                uwSavings.setValue(r.getAttribute("PROD_UW_SAVING_SCH_RPT"));
            }
            if (r.getAttribute("PROD_UW_FE_SCH_RPT") == null) {
                uwFuneral.setValue(null);
            } else {
                uwFuneral.setValue(r.getAttribute("PROD_UW_FE_SCH_RPT"));
            }
            if (r.getAttribute("PROD_UW_REFUND_SCH_RPT") == null) {
                uwRefund.setValue(null);
            } else {
                uwRefund.setValue(r.getAttribute("PROD_UW_REFUND_SCH_RPT"));
            }
            if (r.getAttribute("PROD_POL_COSTING_SCH_RPT") == null) {
                polCosting.setValue(null);
            } else {
                polCosting.setValue(r.getAttribute("PROD_POL_COSTING_SCH_RPT"));
            }
            if (r.getAttribute("PROD_POL_SAVING_SCH_RPT") == null) {
                polSavings.setValue(null);
            } else {
                polSavings.setValue(r.getAttribute("PROD_POL_SAVING_SCH_RPT"));
            }
            if (r.getAttribute("PROD_POL_FE_SCH_RPT") == null) {
                policyFuneral.setValue(null);
            } else {
                policyFuneral.setValue(r.getAttribute("PROD_POL_FE_SCH_RPT"));
            }
            if (r.getAttribute("PROD_REN_COSTING_SCH_RPT") == null) {
                renewalCosting.setValue(null);
            } else {
                renewalCosting.setValue(r.getAttribute("PROD_REN_COSTING_SCH_RPT"));
            }
            if (r.getAttribute("PROD_REN_SAVING_SCH_RPT") == null) {
                renewalSavings.setValue(null);
            } else {
                renewalSavings.setValue(r.getAttribute("PROD_REN_SAVING_SCH_RPT"));
            }
            if (r.getAttribute("PROD_REN_FE_SCH_RPT") == null) {
                renewalFuneral.setValue(null);
            } else {
                renewalFuneral.setValue(r.getAttribute("PROD_REN_FE_SCH_RPT"));
            }
            if (r.getAttribute("PROD_QUO_AGGR_LETT") == null) {
                aggQuoLett.setValue(null);
            } else {
                aggQuoLett.setValue(r.getAttribute("PROD_QUO_AGGR_LETT"));
            }

            //session.setAttribute("CVT_SHT_DESC",r.getAttribute("CVT_SHT_DESC"));

        }
        ExtendedRenderKitService erkService =
            Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                               ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
                             "var hints = {autodismissNever:false}; " +
                             "AdfPage.PAGE.findComponent('" +
                             "lmsgroup:ScheduleReportsPopup" +
                             "').show(hints);");
        return null;

    }

    public String SaveScheduleReports() {
        Connection conn = null;
        String scheduleQuery =
            "BEGIN LMS_SETUPS_PKG.updateScheduleReports(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);END;";
        try {
            conn = new DBConnector().getDatabaseConn();
            CallableStatement cstmt = conn.prepareCall(scheduleQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("PRODCode"));
            if (quotationSavings.getValue() == null) {
                cstmt.setString(2, null);
            } else {
                cstmt.setString(2, quotationSavings.getValue().toString());
            }
            if (quotationCosting.getValue() == null) {
                cstmt.setString(3, null);
            } else {
                cstmt.setString(3, quotationCosting.getValue().toString());
            }
            if (quotationFuneral.getValue() == null) {
                cstmt.setString(4, null);
            } else {
                cstmt.setString(4, quotationFuneral.getValue().toString());
            }
            if (aggregateCosting.getValue() == null) {
                cstmt.setString(5, null);
            } else {
                cstmt.setString(5, aggregateCosting.getValue().toString());
            }
            if (uwCosting.getValue() == null) {
                cstmt.setString(6, null);
            } else {
                cstmt.setString(6, uwCosting.getValue().toString());
            }
            if (uwSavings.getValue() == null) {
                cstmt.setString(7, null);
            } else {
                cstmt.setString(7, uwSavings.getValue().toString());
            }
            if (uwRefund.getValue() == null) {
                cstmt.setString(8, null);
            } else {
                cstmt.setString(8, uwRefund.getValue().toString());
            }
            if (uwFuneral.getValue() == null) {
                cstmt.setString(9, null);
            } else {
                cstmt.setString(9, uwFuneral.getValue().toString());
            }
            if (polCosting.getValue() == null) {
                cstmt.setString(10, null);
            } else {
                cstmt.setString(10, polCosting.getValue().toString());
            }
            if (polSavings.getValue() == null) {
                cstmt.setString(11, null);
            } else {
                cstmt.setString(11, polSavings.getValue().toString());
            }
            if (policyFuneral.getValue() == null) {
                cstmt.setString(12, null);
            } else {
                cstmt.setString(12, policyFuneral.getValue().toString());
            }
            if (renewalCosting.getValue() == null) {
                cstmt.setString(13, null);
            } else {
                cstmt.setString(13, renewalCosting.getValue().toString());
            }
            if (renewalSavings.getValue() == null) {
                cstmt.setString(14, null);
            } else {
                cstmt.setString(14, renewalSavings.getValue().toString());
            }
            if (renewalFuneral.getValue() == null) {
                cstmt.setString(15, null);
            } else {
                cstmt.setString(15, renewalFuneral.getValue().toString());
            }
            if (aggQuoLett.getValue() == null) {
                cstmt.setString(16, null);
            } else {
                cstmt.setString(16, aggQuoLett.getValue().toString());
            }
            cstmt.execute();
            cstmt.close();
            String Message = "Product Schedule Reports  Saved Successfully.";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
            ADFUtils.findIterator("findGroupScheduleReportsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(scheduleReportsLOV);
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
            ex.printStackTrace();
        }
        return null;
    }

    public String UpdateProductLapsationDays() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findLapsationIterator");
        RowKeySet set = productLapsationDaysLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            //session.setAttribute("CVT_CODE", r.getAttribute("CVT_CODE"));
            if (r.getAttribute("PROD_MONTHLY_LAPSE_PRD") == null) {
                monthlyLapsationPeriod.setValue(null);

            } else {
                monthlyLapsationPeriod.setValue(r.getAttribute("PROD_MONTHLY_LAPSE_PRD"));
            }
            if (r.getAttribute("PROD_QUARTER_LAPSE_PRD") == null) {
                quarterlyLapsationPeriod.setValue(null);
            } else {
                quarterlyLapsationPeriod.setValue(r.getAttribute("PROD_QUARTER_LAPSE_PRD"));
            }
            if (r.getAttribute("PROD_SEMI_A_LAPSE_PRD") == null) {
                semiAnnualLapsationPeriod.setValue(null);
            } else {
                semiAnnualLapsationPeriod.setValue(r.getAttribute("PROD_SEMI_A_LAPSE_PRD"));
            }
            if (r.getAttribute("PROD_ANNUALLY_LAPSE_PRD") == null) {
                annualLapsationPeriod.setValue(null);
            } else {
                annualLapsationPeriod.setValue(r.getAttribute("PROD_ANNUALLY_LAPSE_PRD"));
            }
            if (r.getAttribute("PROD_LAPSE_PRD_DAYS") == null) {
                checkOffLapsation.setValue(null);
            } else {
                checkOffLapsation.setValue(r.getAttribute("PROD_LAPSE_PRD_DAYS"));
            }


            //session.setAttribute("CVT_SHT_DESC",r.getAttribute("CVT_SHT_DESC"));

        }
        ExtendedRenderKitService erkService =
            Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                               ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
                             "var hints = {autodismissNever:false}; " +
                             "AdfPage.PAGE.findComponent('" +
                             "lmsgroup:LapsationPopup" + "').show(hints);");
        return null;

    }

    public void setMonthlyLapsationPeriod(RichInputText monthlyLapsationPeriod) {
        this.monthlyLapsationPeriod = monthlyLapsationPeriod;
    }

    public RichInputText getMonthlyLapsationPeriod() {
        return monthlyLapsationPeriod;
    }

    public void setQuarterlyLapsationPeriod(RichInputText quarterlyLapsationPeriod) {
        this.quarterlyLapsationPeriod = quarterlyLapsationPeriod;
    }

    public RichInputText getQuarterlyLapsationPeriod() {
        return quarterlyLapsationPeriod;
    }

    public void setSemiAnnualLapsationPeriod(RichInputText semiAnnualLapsationPeriod) {
        this.semiAnnualLapsationPeriod = semiAnnualLapsationPeriod;
    }

    public RichInputText getSemiAnnualLapsationPeriod() {
        return semiAnnualLapsationPeriod;
    }

    public void setAnnualLapsationPeriod(RichInputText annualLapsationPeriod) {
        this.annualLapsationPeriod = annualLapsationPeriod;
    }

    public RichInputText getAnnualLapsationPeriod() {
        return annualLapsationPeriod;
    }

    public void setCheckOffLapsation(RichInputText checkOffLapsation) {
        this.checkOffLapsation = checkOffLapsation;
    }

    public RichInputText getCheckOffLapsation() {
        return checkOffLapsation;
    }

    public String UpdateProductLapsationdays() {
        Connection conn = null;
        String scheduleQuery =
            "BEGIN LMS_SETUPS_PKG.updateProductLapsationdays(?,?,?,?,?,?);END;";
        try {
            conn = new DBConnector().getDatabaseConn();
            CallableStatement cstmt = conn.prepareCall(scheduleQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("PRODCode"));
            if (monthlyLapsationPeriod.getValue() == null) {
                cstmt.setString(2, null);
            } else {
                cstmt.setString(2,
                                monthlyLapsationPeriod.getValue().toString());
            }
            if (quarterlyLapsationPeriod.getValue() == null) {
                cstmt.setString(3, null);
            } else {
                cstmt.setString(3,
                                quarterlyLapsationPeriod.getValue().toString());
            }
            if (semiAnnualLapsationPeriod.getValue() == null) {
                cstmt.setString(4, null);
            } else {
                cstmt.setString(4,
                                semiAnnualLapsationPeriod.getValue().toString());
            }
            if (annualLapsationPeriod.getValue() == null) {
                cstmt.setString(5, null);
            } else {
                cstmt.setString(5,
                                annualLapsationPeriod.getValue().toString());
            }
            if (checkOffLapsation.getValue() == null) {
                cstmt.setString(6, null);
            } else {
                cstmt.setString(6, checkOffLapsation.getValue().toString());
            }

            cstmt.execute();
            cstmt.close();
            String Message = "Product Lapsation  Saved Successfully.";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
            ADFUtils.findIterator("findLapsationIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(productLapsationDaysLOV);
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        }
        return null;

    }

    public void setProductLapsationDaysLOV(RichTable productLapsationDaysLOV) {
        this.productLapsationDaysLOV = productLapsationDaysLOV;
    }

    public RichTable getProductLapsationDaysLOV() {
        return productLapsationDaysLOV;
    }

    public void setDocumentType(RichSelectOneChoice documentType) {
        this.documentType = documentType;
    }

    public RichSelectOneChoice getDocumentType() {
        return documentType;
    }

    public void setDocumentName(RichInputText documentName) {
        this.documentName = documentName;
    }

    public RichInputText getDocumentName() {
        return documentName;
    }

    public String SavePolicyDocuments() {
        Connection conn = null;
        String saveQuery =
            "BEGIN LMS_SETUPS_PKG.updatePolicyDocuments(?,?,?,?);END;";
        if (documentName.getValue() == null) {
            GlobalCC.INFORMATIONREPORTING("Specify the document name");
            return null;
        }
        if (documentType.getValue() == null) {
            GlobalCC.INFORMATIONREPORTING("Specify the policy duration type");
            return null;
        }
        try {
            conn = new DBConnector().getDatabaseConn();
            CallableStatement cstmt = conn.prepareCall(saveQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("PSPD_CODE"));
            cstmt.setBigDecimal(2,
                                (BigDecimal)session.getAttribute("PRODCode"));
            cstmt.setString(3, documentType.getValue().toString());
            cstmt.setString(4, documentName.getValue().toString());
            cstmt.execute();
            cstmt.close();
            GlobalCC.INFORMATIONREPORTING("Product Policy Document  Saved Successfully.");

            ADFUtils.findIterator("findPolicyDocumentsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(productPolDocsLOV);
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        }
        return null;
    }

    public void setProductPolDocsLOV(RichTable productPolDocsLOV) {
        this.productPolDocsLOV = productPolDocsLOV;
    }

    public RichTable getProductPolDocsLOV() {
        return productPolDocsLOV;
    }

    public String UpdatePolicyDocuments() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findPolicyDocumentsIterator");
        RowKeySet set = productPolDocsLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            session.setAttribute("PSPD_CODE", r.getAttribute("PSPD_CODE"));

            if (r.getAttribute("PSPD_TYPE") == null) {
                documentType.setValue(null);

            } else {
                documentType.setValue(r.getAttribute("PSPD_TYPE"));
            }
            if (r.getAttribute("PSPD_DOC_NAME") == null) {
                documentName.setValue(null);
            } else {
                documentName.setValue(r.getAttribute("PSPD_DOC_NAME"));
            }


            //session.setAttribute("CVT_SHT_DESC",r.getAttribute("CVT_SHT_DESC"));

        }
        ExtendedRenderKitService erkService =
            Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                               ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
                             "var hints = {autodismissNever:false}; " +
                             "AdfPage.PAGE.findComponent('" +
                             "lmsgroup:PolDocsPopup" + "').show(hints);");
        return null;
        // return null;
    }

    public String deletePolicyDocument() {
        String Result = "F";
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findPolicyDocumentsIterator");
        RowKeySet set = productPolDocsLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            session.setAttribute("PSPD_CODE", r.getAttribute("PSPD_CODE"));


        }
        String saveQuery = "BEGIN LMS_SETUPS_PKG.deletePolicyDocument(?);END;";
        Connection conn = null;
        try {
            conn = new DBConnector().getDatabaseConn();
            CallableStatement cstmt = conn.prepareCall(saveQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("PSPD_CODE"));

            cstmt.execute();
            cstmt.close();
            String Message = "Product Policy Document  Deleted Successfully.";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
            ADFUtils.findIterator("findPolicyDocumentsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(productPolDocsLOV);
            GlobalCC.INFORMATIONREPORTING("Record Successfully Deleted");
            Result = "S";
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        }
        return Result;
    }

    public String EditProductExceptions() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findProductExceptionsIterator");
        RowKeySet set = productExceptionsLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            //session.setAttribute("CVT_CODE", r.getAttribute("CVT_CODE"));
            if (r.getAttribute("PROD_EXC_NOT_AGE") == null) {
                exceptionsNotificationAge.setValue(null);

            } else {
                exceptionsNotificationAge.setValue(r.getAttribute("PROD_EXC_NOT_AGE"));
            }
            if (r.getAttribute("PROD_EXC_NOT_SA") == null) {
                exceptionsNotificationSA.setValue(null);
            } else {
                exceptionsNotificationSA.setValue(r.getAttribute("PROD_EXC_NOT_SA"));
            }


            //session.setAttribute("CVT_SHT_DESC",r.getAttribute("CVT_SHT_DESC"));

        }
        ExtendedRenderKitService erkService =
            Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                               ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
                             "var hints = {autodismissNever:false}; " +
                             "AdfPage.PAGE.findComponent('" +
                             "lmsgroup:ExceptionsPopup" + "').show(hints);");
        return null;

    }

    public void setExceptionsNotificationAge(RichInputText exceptionsNotificationAge) {
        this.exceptionsNotificationAge = exceptionsNotificationAge;
    }

    public RichInputText getExceptionsNotificationAge() {
        return exceptionsNotificationAge;
    }

    public void setExceptionsNotificationSA(RichInputText exceptionsNotificationSA) {
        this.exceptionsNotificationSA = exceptionsNotificationSA;
    }

    public RichInputText getExceptionsNotificationSA() {
        return exceptionsNotificationSA;
    }

    public String SaveProductExceptions() {
        String saveQuery =
            "BEGIN LMS_SETUPS_PKG.updateProductExceptions(?,?,?);END;";
        if (exceptionsNotificationAge.getValue() == null) {
            String Message = "Specify the Exception Notification Age";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
        }
        if (exceptionsNotificationSA.getValue() == null) {
            String Message = "Specify the Exception Notification Sum Assured";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
        }
        Connection conn = null;
        try {
            conn = new DBConnector().getDatabaseConn();
            CallableStatement cstmt = conn.prepareCall(saveQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("PRODCode"));
            cstmt.setString(2,
                            exceptionsNotificationAge.getValue().toString());
            cstmt.setString(3, exceptionsNotificationSA.getValue().toString());
            cstmt.execute();
            cstmt.close();
            String Message = "Product Exceptions Saved Successfully.";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
            ADFUtils.findIterator("findGroupProductsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(productTree);
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        }
        return null;
    }

    public void setProductExceptionsLOV(RichTable productExceptionsLOV) {
        this.productExceptionsLOV = productExceptionsLOV;
    }

    public RichTable getProductExceptionsLOV() {
        return productExceptionsLOV;
    }

    public String CreateNewProduct() {
        //adding=true;
        session.setAttribute("PRODCode", null);
        prodShtDesc.setValue(null);
        productDesc.setValue(null);
        prodType.setValue(null);
        session.setAttribute("productType", null);
        prodMinAgeLimit.setValue(null);
        payGratuity.setValue(null);
        prodMaxAgeLimit.setValue(null);
        prodMinTermYrs.setValue(null);
        prodMinTermYrs.setValue(null);
        annuityAllowed.setValue(null);
        claimPrefixCode.setValue(null);
        openCover.setValue(null);
        polPrefixCode.setValue(null);
        proposalPrefix.setValue(null);
        cancellationNotice.setValue(null);
        xolAllowed.setValue(null);
        reinsMaxPeriod.setValue(null);
        loanProduct.setValue(null);
        savingsCovered.setValue(null);
        osLoanCalc.setValue(null);
        defaultDOBMon.setValue(null);
        refundCommission.setValue(null);
        refundAllowed.setValue(null);
        initialScheEndorse.setValue(null);
        productCovers.setValue(null);
        partialCancellationAllowed.setValue(null);
        claimExpiryPeriod.setValue(null);
        productDebitAccNo.setValue(null);
        unitRateApplicable.setValue(null);
        applicableLapseType.setValue(null);
        prodMinEarningsPeriod.setValue(null);
        expectedScheduleReceptDay.setValue(null);
        autoGeneratePolicyNo.setValue(null);
        //  minimumFCLMembers.setValue(null);
        ///        minimumFCLAmount.setValue(null);
        //        extensionAllowed.setValue(null);
        //  renewalAllowed.setValue(null);
        fctFactor1.setValue(null);
        scheduleAdjustmentPeriod.setValue(null);
        profitShareRate.setValue(null);
        fclFactor2.setValue(null);
        minFCLMembers.setValue(null);
        maximumFCLAmount.setValue(null);
        extAllowed.setValue(null);
        renAllowed.setValue(null);
        maximumExtensionPrd.setValue(null);
        addRefPremRate.setValue(null);
        groupMinimumMembers.setValue(null);
        prodGLControlCode.setValue(null);
        empPensionPrdPay.setValue(null);
        allowGracePeriod.setValue(null);
        emvCalculationType.setValue(null);
        valuationIntrCalc.setValue(null);
        prodWefDate.setValue(null);
        productStatus.setValue(null);
        loanGuard.setValue("N");
        quoteExpiryPeriod.setValue(null);
        receiptingMode.setValue("D");
        fclSAFormula.setValue("T");
        return null;
    }

    public String SaveProducts() {
        Connection conn = null;
        String wetDate = null;
        //session.setAttribute("PRODCode",null);
        if (prodShtDesc.getValue() == null) {
            String Message = "Specify the Product Short Desc";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
        }
        if (productDesc.getValue() == null) {
            String Message = "Specify the Product Description";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
        }
        if (prodType.getValue() == null) {
            String Message = "Specify the Product Type";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
        }
        if (prodMinAgeLimit.getValue() == null) {
            String Message = "Specify the Product Minimum Age Limit";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
        }
        if (prodMaxAgeLimit.getValue() == null) {
            String Message = "Specify the Product Maximum Age Limit";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
        }
        if (prodMinTermYrs.getValue() == null) {
            String Message = "Specify the Product Minimum Term";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
        }
        if (claimPrefixCode.getValue() == null) {
            String Message = "Specify the Product Claim Prefix Code";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
        }
        if (proposalPrefix.getValue() == null) {
            String Message = "Specify the Product Proposal Prefix Code";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
        }
        if (cancellationNotice.getValue() == null) {
            String Message = "Specify the Product Cancellation Notice Days";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
        }
        if (reinsMaxPeriod.getValue() == null) {
            String Message = "Specify the Product Reinsurance Maximum Period";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
        }
        if (loanProduct.getValue() == null) {
            String Message = "Specify the if the product is a loan product";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
        }
        /*if(prodType.getValue().toString().equalsIgnoreCase("LOAN"))
        {
            if(savingsCovered.getValue()==null) {
                String Message="Specify if savings are covered";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));
            }
            if(osLoanCalc.getValue()==null) {
                String Message="Specify the outstanding loan calculation method";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));
            }
            if(allowGracePeriod.getValue()==null) {
                String Message="Specify if product allows grace period at underwriting";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));
            }
        }*/
        /*else if(prodType.getValue().toString().equalsIgnoreCase("PENS")) {
            if(payGratuity.getValue()==null) {
                String Message="Specify if the product pays gratuity";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));
            }
            if(annuityAllowed.getValue()==null) {
                String Message="Specify if the product allows annuity";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));
            }
            if(emvCalculationType.getValue()==null) {
                String Message="Specify the product EMV Calculation mode";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));
            }
            if(valuationIntrCalc.getValue()==null) {
                String Message="Specify the valuation interest calculation mode";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));
            }
        else if (prodType.getValue().toString().equalsIgnoreCase("EARN")) {
                String Message="Specify the product minimum earnings period";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));
            }
        }*/
        if (openCover.getValue() == null) {
            String Message = "Specify if the product allows open covers";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
        }
        if (defaultDOBMon.getValue() == null) {
            String Message = "Specify if the product default date of birth";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
        }
        if (refundAllowed.getValue() == null) {
            String Message = "Specify if the product allows refund of premium";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
        }
        if (initialScheEndorse.getValue() == null) {
            String Message =
                "Specify the product initial schedule endorsement";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
        }
        if (productCovers.getValue() == null) {
            String Message = "Specify the dependents the product covers";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
        }
        if (partialCancellationAllowed.getValue() == null) {
            String Message =
                "Specify if the product allows partial cancellation";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
        }
        if (claimExpiryPeriod.getValue() == null) {
            String Message = "Specify the product claim expiry period";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
        }
        if (applicableLapseType.getValue() == null) {
            String Message = "Specify the product applicable lapse type";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
        }
        if (expectedScheduleReceptDay.getValue() == null) {
            String Message =
                "Specify if the product expected schedule receipt day";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
        }
        if (autoGeneratePolicyNo.getValue() == null) {
            String Message =
                "Specify if the product allows policy number auto generation";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
        }
        if (minFCLMembers.getValue() == null) {
            String Message = "Specify the product minimum fcl members";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
        }
        if (maximumFCLAmount.getValue() == null) {
            String Message = "Specify the product maximum fcl amount";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
        }
        if (extAllowed.getValue() == null) {
            String Message =
                "Specify if the product allows extension of cover";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
        }
        if (renAllowed.getValue() == null) {
            String Message = "Specify if the product allows renewals";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
        }
        String SaveQuery =
            "BEGIN LMS_SETUPS_PKG.updateProducts(?,?,?,?,?,?,?,?,?,?," +
            "?,?,?,?,?,?,?,?,?,?," + "?,?,?,?,?,?,?,?,?,?," +
            "?,?,?,?,?,?,?,?,?,?," +
            "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);END;";
        try {
            conn = new DBConnector().getDatabaseConn();
            CallableStatement cstmt = conn.prepareCall(SaveQuery);

            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("PRODCode")); //v_prod_code NUMBER DEFAULT NULL,
            if (prodShtDesc.getValue() == null) {
                cstmt.setString(2, null); //v_prod_sht_desc VARCHAR2
            } else {
                cstmt.setString(2,
                                prodShtDesc.getValue().toString()); //v_prod_sht_desc VARCHAR2
            }
            if (productDesc.getValue() == null) {
                cstmt.setString(3, null); //v_prod_desc VARCHAR2,
            } else {
                cstmt.setString(3,
                                productDesc.getValue().toString()); //v_prod_desc VARCHAR2,
            }
            if (prodType.getValue() == null) {
                cstmt.setString(4, null);
            } else {
                cstmt.setString(4, prodType.getValue().toString());
            }
            if (polPrefixCode.getValue() == null) {
                cstmt.setString(5, null); //v_prod_pol_code_fix VARCHAR2
            } else {
                cstmt.setString(5,
                                polPrefixCode.getValue().toString()); //v_prod_pol_code_fix VARCHAR2
            }
            if (claimPrefixCode.getValue() == null) {
                cstmt.setString(6, null); //v_prod_clm_code_fix VARCHAR2,
            } else {
                cstmt.setString(6,
                                claimPrefixCode.getValue().toString()); //v_prod_clm_code_fix VARCHAR2,
            }

            cstmt.setString(7, "1"); //v_PROD_LAPSE_PRD_DAYS number,
            if (reinsMaxPeriod.getValue() == null) {
                cstmt.setString(8, null); //v_PROD_REIN_MAX_PRD_DAYS number,
            } else {
                cstmt.setString(8,
                                reinsMaxPeriod.getValue().toString()); //v_PROD_REIN_MAX_PRD_DAYS number,
            }
            if (prodMinAgeLimit.getValue() == null) {
                cstmt.setString(9, null); //v_PROD_MIN_AGE_LIMIT_YRS NUMBER,
            } else {
                cstmt.setString(9,
                                prodMinAgeLimit.getValue().toString()); //v_PROD_MIN_AGE_LIMIT_YRS NUMBER,
            }
            if (prodMaxAgeLimit.getValue() == null) {
                cstmt.setString(10, null); //v_PROD_MAX_AGE_LIMIT_YRS NUMBER,
            } else {
                cstmt.setString(10,
                                prodMaxAgeLimit.getValue().toString()); //v_PROD_MAX_AGE_LIMIT_YRS NUMBER,
            }
            if (cancellationNotice.getValue() == null) {
                cstmt.setString(11, null); //v_PROD_CANC_NOTICE_DAYS NUMBER,
            } else {
                cstmt.setString(11,
                                cancellationNotice.getValue().toString()); //v_PROD_CANC_NOTICE_DAYS NUMBER,
            }
            if (prodMinTermYrs.getValue() == null) {
                cstmt.setString(12, null); //v_PROD_MIN_TERM_YRS NUMBER,
            } else {
                cstmt.setString(12,
                                prodMinTermYrs.getValue().toString()); //v_PROD_MIN_TERM_YRS NUMBER,
            }
            if (prodMaxTermLimit.getValue() == null) {
                cstmt.setString(13, null); //v_PROD_MAX_TERM_YRS number,
            } else {
                cstmt.setString(13,
                                prodMaxTermLimit.getValue().toString()); //v_PROD_MAX_TERM_YRS number,
            }

            if (annuityAllowed.getValue() == null) {
                cstmt.setString(14, null);
            } else {
                cstmt.setString(14,
                                annuityAllowed.getValue().toString()); //v_annuity_allowed VARCHAR2,
            }
            if (openCover.getValue() == null) {
                cstmt.setString(15, null); //v_PROD_OPEN_COVER VARCHAR2,
            } else {
                cstmt.setString(15,
                                openCover.getValue().toString()); //v_PROD_OPEN_COVER VARCHAR2,
            }
            if (xolAllowed.getValue() == null) {
                cstmt.setString(16, null); //v_PROD_XOL_SETUP VARCHAR2,
            } else {
                cstmt.setString(16,
                                xolAllowed.getValue().toString()); //v_PROD_XOL_SETUP VARCHAR2,
            }
            if (loanProduct.getValue() == null) {
                cstmt.setString(17, null); //v_PROD_LOAN_PRODUCT VARCHAR2,
            } else {
                cstmt.setString(17,
                                loanProduct.getValue().toString()); //v_PROD_LOAN_PRODUCT VARCHAR2,
            }

            if (savingsCovered.getValue() == null) {
                cstmt.setString(18, null);
            } else {
                cstmt.setString(18,
                                savingsCovered.getValue().toString()); //v_PROD_SAVINGS_COVERED VARCHAR2,
            }
            if (osLoanCalc.getValue() == null) {
                cstmt.setString(19, null);
            } else {
                cstmt.setString(19,
                                osLoanCalc.getValue().toString()); //v_PROD_OS_LOAN_CALC VARCHAR2,
            }
            /*if((BigDecimal)session.getAttribute("PRODCode")==null) {
               cstmt.setString(20,defaultDOBMon.getValue().toString());//v_PROD_DEFAULT_DOB DATE
           }
           else {
               String MyDate = GlobalCC.parseMonthDate(defaultDOBMon.getValue().toString());
               cstmt.setString(20,MyDate);//v_PROD_DEFAULT_DOB DATE
           }*/
            if (defaultDOBMon.getValue() == null) {
                cstmt.setString(20, null); //v_PROD_DEFAULT_DOB DATE,
            } else {

                String MyDate =
                    GlobalCC.parseMonthDate(defaultDOBMon.getValue().toString());
                cstmt.setString(20, MyDate); //v_PROD_DEFAULT_DOB DATE,
            }
            if (refundCommission.getValue() == null) {
                cstmt.setString(21, null); //V_PROD_REFUND_COMM VARCHAR2,
            } else {
                cstmt.setString(21,
                                refundCommission.getValue().toString()); //V_PROD_REFUND_COMM VARCHAR2,
            }
            if (refundAllowed.getValue() == null) {
                cstmt.setString(22, null); //v_PROD_REFUND_ALLOWED VARCHAR2,
            } else {
                cstmt.setString(22,
                                refundAllowed.getValue().toString()); //v_PROD_REFUND_ALLOWED VARCHAR2,
            }
            if (initialScheEndorse.getValue() == null) {
                cstmt.setString(23,
                                null); //v_PROD_INITIAL_SCH_ENDRSE VARCHAR2,
            } else {
                cstmt.setString(23,
                                initialScheEndorse.getValue().toString()); //v_PROD_INITIAL_SCH_ENDRSE VARCHAR2,
            }
            if (productCovers.getValue() == null) {
                cstmt.setString(24, null); //v_PROD_DEPENDT_COVERED VARCHAR2,
            } else {
                cstmt.setString(24,
                                productCovers.getValue().toString()); //v_PROD_DEPENDT_COVERED VARCHAR2,
            }
            if (partialCancellationAllowed.getValue() == null) {
                cstmt.setString(25,
                                null); //v_PROD_PARTIAL_CANCEL_ALLOWED VARCHAR2,
            } else {
                cstmt.setString(25,
                                partialCancellationAllowed.getValue().toString()); //v_PROD_PARTIAL_CANCEL_ALLOWED VARCHAR2,
            }
            if (claimExpiryPeriod.getValue() == null) {
                cstmt.setString(26, null); //v_PROD_CLAIM_EXPIRY_PRD VARCHAR2,
            } else {
                cstmt.setString(26,
                                claimExpiryPeriod.getValue().toString()); //v_PROD_CLAIM_EXPIRY_PRD VARCHAR2,
            }

            if (productDebitAccNo.getValue() == null) {
                cstmt.setString(27, null);
            } else {
                cstmt.setString(27,
                                productDebitAccNo.getValue().toString()); //v_PROD_DEBIT_ACC_NO VARCHAR2,
            }
            if (unitRateApplicable.getValue() == null) {
                cstmt.setString(28,
                                null); //v_PROD_UNIT_RATE_APPLICABLE VARCHAR2,
            } else {
                cstmt.setString(28,
                                unitRateApplicable.getValue().toString()); //v_PROD_UNIT_RATE_APPLICABLE VARCHAR2,
            }
            if (applicableLapseType.getValue() == null) {
                cstmt.setString(29,
                                null); //v_PROD_APPLICABLE_LAPSE_TYPE VARCHAR2,
            } else {
                cstmt.setString(29,
                                applicableLapseType.getValue().toString()); //v_PROD_APPLICABLE_LAPSE_TYPE VARCHAR2,
            }

            if (prodMinEarningsPeriod.getValue() == null) {
                cstmt.setString(30, null);
            } else {
                cstmt.setString(30,
                                prodMinEarningsPeriod.getValue().toString()); //v_PROD_MIN_EARNINGS_PRD VARCHAR2,
            }

            if (expectedScheduleReceptDay.getValue() == null) {
                cstmt.setString(31,
                                null); //v_PROD_EXPECTED_SCH_RECPT_DAY VARCHAR2,
            } else {
                cstmt.setString(31,
                                expectedScheduleReceptDay.getValue().toString()); //v_PROD_EXPECTED_SCH_RECPT_DAY VARCHAR2,
            }
            if (autoGeneratePolicyNo.getValue() == null) {
                cstmt.setString(32, null); //v_PROD_GEN_POL_NO VARCHAR2,
            } else {
                cstmt.setString(32,
                                autoGeneratePolicyNo.getValue().toString()); //v_PROD_GEN_POL_NO VARCHAR2,
            }
            if (minFCLMembers.getValue() == null) {
                cstmt.setString(33,
                                null); //v_PROD_MINIMUM_FCL_MEMBERS VARCHAR2,
            } else {
                cstmt.setString(33,
                                minFCLMembers.getValue().toString()); //v_PROD_MINIMUM_FCL_MEMBERS VARCHAR2,
            }
            if (maximumFCLAmount.getValue() == null) {
                cstmt.setString(34, null); //v_PROD_FCL_MAX_AMT VARCHAR2,
            } else {
                cstmt.setString(34,
                                maximumFCLAmount.getValue().toString()); //v_PROD_FCL_MAX_AMT VARCHAR2,
            }
            if (extAllowed.getValue() == null) {
                cstmt.setString(35, null); //v_PROD_EXTENTION_ALLOWED VARCHAR2,
            } else {
                cstmt.setString(35,
                                extAllowed.getValue().toString()); //v_PROD_EXTENTION_ALLOWED VARCHAR2,
            }
            if (renAllowed.getValue() == null) {
                cstmt.setString(36, null); //v_PROD_RENEWAL_ALLOWED VARCHAR2,
            } else {
                cstmt.setString(36,
                                renAllowed.getValue().toString()); //v_PROD_RENEWAL_ALLOWED VARCHAR2,
            }
            if (fctFactor1.getValue() == null) {
                cstmt.setString(37, null); //v_PROD_FCL_FACTOR1 VARCHAR2,
            } else {
                cstmt.setString(37,
                                fctFactor1.getValue().toString()); //v_PROD_FCL_FACTOR1 VARCHAR2,
            }
            if (scheduleAdjustmentPeriod.getValue() == null) {
                cstmt.setString(38, null); //v_PROD_FCL_FACTOR1 VARCHAR2,
            } else {
                cstmt.setString(38,
                                scheduleAdjustmentPeriod.getValue().toString()); //v_PROD_FCL_FACTOR1 VARCHAR2,
            }
            if (profitShareRate.getValue() == null) {
                cstmt.setString(39, null);
            } else {
                cstmt.setString(39,
                                profitShareRate.getValue().toString()); //v_PROD_PROFIT_SHARE_RATE_PERC NUMBER,
            }

            if (fclFactor2.getValue() == null) {
                cstmt.setString(40, null);
            } else {
                cstmt.setString(40,
                                fclFactor2.getValue().toString()); //v_PROD_PROFIT_SHARE_RATE_PERC NUMBER,
            }
            if (maximumExtensionPrd.getValue() == null) {
                cstmt.setString(41, null); //v_PROD_MAX_EXT_PERIOD NUMBER,
            } else {
                cstmt.setString(41,
                                maximumExtensionPrd.getValue().toString()); //v_PROD_MAX_EXT_PERIOD NUMBER,
            }

            if (addRefPremRate.getValue() == null) {
                cstmt.setString(42, null);
            } else {
                cstmt.setString(42,
                                addRefPremRate.getValue().toString()); //v_PROD_ADD_REF_PREM_PERC NUMBER,
            }
            if (groupMinimumMembers.getValue() == null) {
                cstmt.setString(43, null);
            } else {
                cstmt.setString(43,
                                groupMinimumMembers.getValue().toString()); //v_PROD_GRP_RATES_MIN NUMBER,
            }

            if (prodGLControlCode.getValue() == null) {
                cstmt.setString(44, null);
            } else {
                cstmt.setString(44,
                                prodGLControlCode.getValue().toString()); //v_PROD_GL_CONTROL_CODE VARCHAR2,
            }
            if (empPensionPrdPay.getValue() == null) {
                cstmt.setString(45, null);
            } else {
                cstmt.setString(45,
                                empPensionPrdPay.getValue().toString()); //v_PROD_EMP_FUND_PAY_PRD NUMBER,
            }

            if (allowGracePeriod.getValue() == null) {
                cstmt.setString(46, null);
            } else {
                cstmt.setString(46,
                                allowGracePeriod.getValue().toString()); //v_PROD_LOAN_GRACE_PRD VARCHAR2,
            }
            if (emvCalculationType.getValue() == null) {
                cstmt.setString(47, null);
            } else {
                cstmt.setString(47,
                                emvCalculationType.getValue().toString()); //v_PROD_EMV_CALCULATION_TYPE VARCHAR2,
            }
            if (valuationIntrCalc.getValue() == null) {
                cstmt.setString(48, null);
            } else {
                cstmt.setString(48,
                                valuationIntrCalc.getValue().toString()); //v_PROD_VAL_INTR_CALC_MODE VARCHAR2,
            }
            if (productRemarks.getValue() == null) {
                cstmt.setString(49, null);
            } else {
                cstmt.setString(49,
                                productRemarks.getValue().toString()); //v_PROD_REMARKS VARCHAR2
            }
            if (prodWefDate.getValue() == null) {
                cstmt.setString(50, null);
            } else {
                if (prodWefDate.getValue().toString().contains(":")) {
                    wetDate =
                            GlobalCC.parseDate(prodWefDate.getValue().toString());
                } else {
                    wetDate =
                            GlobalCC.upDateParseDate(prodWefDate.getValue().toString());
                }
                cstmt.setString(50,
                                wetDate); //v_PROD_VAL_INTR_CALC_MODE VARCHAR2,
            }
            if (productStatus.getValue() == null) {
                cstmt.setString(51, null);
            } else {
                cstmt.setString(51,
                                productStatus.getValue().toString()); //v_PROD_REMARKS VARCHAR2
            }
            if (weeklyIndemnityLimit.getValue() == null) {
                cstmt.setString(52, null);
            } else {
                cstmt.setString(52,
                                weeklyIndemnityLimit.getValue().toString()); //v_PROD_REMARKS VARCHAR2
            }
            if (prdEarningsType.getValue() == null) {
                cstmt.setString(53, null);
            } else {
                cstmt.setString(53, prdEarningsType.getValue().toString());
            }
            if (fclType.getValue() == null) {
                cstmt.setString(54, null);
            } else {
                cstmt.setString(54, fclType.getValue().toString());
            }
            if (pensType.getValue() == null) {
                cstmt.setString(55, null);
            } else {
                cstmt.setString(55, pensType.getValue().toString());
            }
            if (pensContriLimit.getValue() == null) {
                cstmt.setString(56, null);
            } else {
                cstmt.setString(56, pensContriLimit.getValue().toString());
            }
            if (loanGuard.getValue() == null) {
                cstmt.setString(57, "N");
            } else {
                cstmt.setString(57, loanGuard.getValue().toString());
            }
            if (this.quoteExpiryPeriod.getValue() == null) {
                cstmt.setString(58, null);
            } else {
                cstmt.setString(58,
                                this.quoteExpiryPeriod.getValue().toString());
            }
            if (receiptingMode.getValue() == null) {
                cstmt.setString(59, "D");
            } else {
                cstmt.setString(59, receiptingMode.getValue().toString());
            }
            if (fclSAFormula.getValue() == null) {
                cstmt.setString(60, "T");
            } else {
                cstmt.setString(60, fclSAFormula.getValue().toString());
            }
            if (rateTypeCombo.getValue() == null) {
                cstmt.setString(61, "G");
            } else {
                cstmt.setString(61, rateTypeCombo.getValue().toString());
            }
            if (medGracePeriod.getValue() == null) {
                cstmt.setString(62, null);
            } else {
                cstmt.setString(62, medGracePeriod.getValue().toString());
            }


            cstmt.execute();
            cstmt.close();
            GlobalCC.INFORMATIONREPORTING("Product Successfully Saved");

            ADFUtils.findIterator("findGroupProductsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(productTree);
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
            ex.printStackTrace();
        }
        return null;
    }

    public void setExgratiaMemberID(RichInputText exgratiaMemberID) {
        this.exgratiaMemberID = exgratiaMemberID;
    }

    public RichInputText getExgratiaMemberID() {
        return exgratiaMemberID;
    }

    public void setProdMaxTermLimit(RichInputText prodMaxTermLimit) {
        this.prodMaxTermLimit = prodMaxTermLimit;
    }

    public RichInputText getProdMaxTermLimit() {
        return prodMaxTermLimit;
    }

    public void setProductRemarks(RichInputText productRemarks) {
        this.productRemarks = productRemarks;
    }

    public RichInputText getProductRemarks() {
        return productRemarks;
    }

    public void DeleteListener(ActionEvent actionEvent) {
        // Add event code here...
        String DeletePosition = actionEvent.getComponent().getId();
        if (DeletePosition == null) {
            return;
        } else {
            session.setAttribute("delAction", DeletePosition);
            GlobalCC.showPopup("lmsgroup:confirmDel");
        }
    }

    public String DeleteObject() {
        try {
            String Value = (String)session.getAttribute("delAction");
            String Result = "F";
            if (Value == null) {

            } else if (Value.equalsIgnoreCase("delProduct")) {
                //Delete The Product...
                Result = DeleteProduct();
            } else if (Value.equalsIgnoreCase("delDeathAcceptNo")) {
                //Delete Death Acceptable No...
                Result = DeleteDeathAcceptableNo();
            } else if (Value.equalsIgnoreCase("delPolicyDocument")) {
                //Deletes Policy Document...
                Result = deletePolicyDocument();
            }
            if (Result == null) {
                return null;
            } else if (Result.equalsIgnoreCase("F")) {
                return null;
            } else {
                GlobalCC.hidePopup("lmsgroup:confirmDel");
            }
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String DeleteProduct() {
        Connection conn = null;
        String SaveQuery = "BEGIN LMS_SETUPS_PKG.DELETE_PRODUCT(?);END;";
        String Result = "F";
        try {
            conn = new DBConnector().getDatabaseConn();
            CallableStatement cstmt = conn.prepareCall(SaveQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("PRODCode")); //v_prod_code NUMBER DEFAULT NULL,
            cstmt.execute();
            cstmt.close();
            String Message = "Product Successfully Deleted";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
            ADFUtils.findIterator("findGroupProductsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(productTree);
            GlobalCC.INFORMATIONREPORTING("Record Successfully Deleted");
            Result = "S";
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        }
        return Result;
    }

    public String AddTreatyProductCoverType() {
        session.setAttribute("TCT_CODE", null);
        session.setAttribute("CVT_CODE", null);
        session.setAttribute("PCT_CODE", null);
        session.setAttribute("CVT_SHT_DESC", null);

        addCoverDescription.setValue(null);
        retentionLimit.setValue(null);
        multiLifeRetentionLimit.setValue(null);
        amountOverLimitToCede.setValue(null);
        reducingBalance.setValue(null);

        GlobalCC.showPopup("lmsgroup:AddTreatyProdCoverPopup");


        return null;
    }

    public void setAddCoverTypesLOV(RichTable addCoverTypesLOV) {
        this.addCoverTypesLOV = addCoverTypesLOV;
    }

    public RichTable getAddCoverTypesLOV() {
        return addCoverTypesLOV;
    }

    public String AssignAdditionCoverTypes() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findProductCoverTypesLOVIterator");
        RowKeySet set = addCoverTypesLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            session.setAttribute("CVT_CODE", r.getAttribute("ADD_CVT_CODE"));
            session.setAttribute("PCT_CODE", r.getAttribute("ADD_PCT_CODE"));
            session.setAttribute("CVT_SHT_DESC",
                                 r.getAttribute("ADD_CVT_SHT_DESC"));
            addCoverDescription.setValue(r.getAttribute("ADD_CVT_DESC"));


            //session.setAttribute("CVT_SHT_DESC",r.getAttribute("CVT_SHT_DESC"));

        }
        ExtendedRenderKitService erkService =
            Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                               ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
                             "var hints = {autodismissNever:false}; " +
                             "AdfPage.PAGE.findComponent('" +
                             "lmsgroup:AddTreatyProdCoverPopup" +
                             "').show(hints);");
        return null;

    }

    public void setAddCoverDescription(RichInputText addCoverDescription) {
        this.addCoverDescription = addCoverDescription;
    }

    public RichInputText getAddCoverDescription() {
        return addCoverDescription;
    }

    public void setRetentionLimit(RichInputText retentionLimit) {
        this.retentionLimit = retentionLimit;
    }

    public RichInputText getRetentionLimit() {
        return retentionLimit;
    }

    public void setMultiLifeRetentionLimit(RichInputText multiLifeRetentionLimit) {
        this.multiLifeRetentionLimit = multiLifeRetentionLimit;
    }

    public RichInputText getMultiLifeRetentionLimit() {
        return multiLifeRetentionLimit;
    }

    public void setAmountOverLimitToCede(RichInputText amountOverLimitToCede) {
        this.amountOverLimitToCede = amountOverLimitToCede;
    }

    public RichInputText getAmountOverLimitToCede() {
        return amountOverLimitToCede;
    }

    public void setReducingBalance(RichSelectOneChoice reducingBalance) {
        this.reducingBalance = reducingBalance;
    }

    public RichSelectOneChoice getReducingBalance() {
        return reducingBalance;
    }

    public String SaveTreatyProductCoverType() {
        String saveQuery =
            "BEGIN LMS_SETUPS_PKG.update_treaty_prod_covers(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);END;";
        String errmsg = null;
       
        try {
            if (reducingBalance.getValue() == null) {
                GlobalCC.INFORMATIONREPORTING("Please choose a reducing balance option");
                return null;
            }
          
            Connection conn = new DBConnector().getDatabaseConn();
            CallableStatement cstmt = conn.prepareCall(saveQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("TCT_CODE")); //v_tct_code
            cstmt.setBigDecimal(2,
                                (BigDecimal)session.getAttribute("trpd_code"));
            cstmt.setBigDecimal(3,
                                (BigDecimal)session.getAttribute("ta_code"));
            cstmt.setString(4, (String)session.getAttribute("ta_sht_desc"));
            cstmt.setBigDecimal(5,
                                (BigDecimal)session.getAttribute("ProductCode"));
            cstmt.setBigDecimal(6,
                                (BigDecimal)session.getAttribute("as_code"));
            cstmt.setString(7, "RN");
            cstmt.setString(8, reducingBalance.getValue().toString());
            cstmt.setBigDecimal(9, null);
            cstmt.setBigDecimal(10,
                                (BigDecimal)session.getAttribute("PCT_CODE"));
            cstmt.setBigDecimal(11,
                                (BigDecimal)session.getAttribute("CVT_CODE"));
            cstmt.setString(12, (String)session.getAttribute("CVT_SHT_DESC"));
            if (retentionLimit.getValue() == null) {
                cstmt.setBigDecimal(13, null);
            } else {
                cstmt.setBigDecimal(13,
                                    new BigDecimal(retentionLimit.getValue().toString()));
            }

            if (amountOverLimitToCede.getValue() == null) {
                cstmt.setBigDecimal(14, null);
            } else {
                cstmt.setBigDecimal(14,
                                    new BigDecimal(amountOverLimitToCede.getValue().toString()));
            }

            cstmt.setString(15, null);
            cstmt.setString(16, null);
            if (multiLifeRetentionLimit.getValue() == null) {
                cstmt.setBigDecimal(17, null);
            } else {
                cstmt.setBigDecimal(17,
                                    new BigDecimal(multiLifeRetentionLimit.getValue().toString()));
            }
            cstmt.registerOutParameter(18, OracleTypes.VARCHAR);

            if (aal.getValue() == null) {
                cstmt.setString(19, null);
            } else {
                cstmt.setString(19, aal.getValue().toString());
            }
            cstmt.execute();
            errmsg = cstmt.getString(18);
            cstmt.close();
            session.setAttribute("TCT_CODE", null);
            ADFUtils.findIterator("findTreatyProdCoverTypesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(treatyProdCoverTypesLOV);

            String Message = "Product Cover Type Successfully Saved";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          errmsg,
                                                                          errmsg));
            ex.printStackTrace();
        }
        return null;
    }

    public String ShowCoverTypesPopup() {
        ExtendedRenderKitService erkService =
            Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                               ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
                             "var hints = {autodismissNever:false}; " +
                             "AdfPage.PAGE.findComponent('" +
                             "lmsgroup:treatyProdCvPopup" + "').show(hints);");
        return null;
    }

    public String EditProductCoverTypes() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findTreatyProdCoverTypesIterator");
        RowKeySet set = treatyProdCoverTypesLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            session.setAttribute("CVT_CODE", r.getAttribute("TCT_CVT_CODE"));
            session.setAttribute("TCT_CODE", r.getAttribute("TCT_CODE"));
            session.setAttribute("CVT_SHT_DESC",
                                 r.getAttribute("TCT_CVT_SHT_DESC"));
            addCoverDescription.setValue(r.getAttribute("CVT_DESC"));
            session.setAttribute("PCT_CODE", r.getAttribute("TCT_PCT_CODE"));
            if (r.getAttribute("TCT_RETENTION_LIMIT") == null) {
                retentionLimit.setValue(null);
            } else {
                retentionLimit.setValue(r.getAttribute("TCT_RETENTION_LIMIT"));
            }
            if (r.getAttribute("TCT_OVER_LIMIT_TOCEDE") == null) {
                amountOverLimitToCede.setValue(null);
            } else {
                amountOverLimitToCede.setValue(r.getAttribute("TCT_OVER_LIMIT_TOCEDE"));
            }
            if (r.getAttribute("TCT_MULTI_LIFE_RETN_LIMT") == null) {
                multiLifeRetentionLimit.setValue(null);
            } else {
                multiLifeRetentionLimit.setValue(r.getAttribute("TCT_MULTI_LIFE_RETN_LIMT"));
            }
            aal.setValue(r.getAttribute("TCT_AAL"));
            System.out.println(r.getAttribute("TCT_REDUCE_BAL"));
            reducingBalance.setValue(r.getAttribute("TCT_REDUCE_BAL"));
            //session.setAttribute("CVT_SHT_DESC",r.getAttribute("CVT_SHT_DESC"));

        }
        ExtendedRenderKitService erkService =
            Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                               ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
                             "var hints = {autodismissNever:false}; " +
                             "AdfPage.PAGE.findComponent('" +
                             "lmsgroup:AddTreatyProdCoverPopup" +
                             "').show(hints);");
        return null;
    }

    public String DeleteTreatyProductCoverType() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findTreatyProdCoverTypesIterator");
        RowKeySet set = treatyProdCoverTypesLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();


            session.setAttribute("TCT_CODE", r.getAttribute("TCT_CODE"));


        }
        String saveQuery = "BEGIN LMS_SETUPS_PKG.deletetreatyprodcvt(?);END;";
        Connection conn = null;
        try {
            conn = new DBConnector().getDatabaseConn();
            CallableStatement cstmt = conn.prepareCall(saveQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("TCT_CODE")); //v_tct_code
            cstmt.execute();
            cstmt.close();
            String Message = "Product Cover Type Successfully Deleted";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
            ADFUtils.findIterator("findTreatyProdCoverTypesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(treatyProdCoverTypesLOV);
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        }
        return null;
    }

    public void setTreatySetupsLOV(RichTable treatySetupsLOV) {
        this.treatySetupsLOV = treatySetupsLOV;
    }

    public RichTable getTreatySetupsLOV() {
        return treatySetupsLOV;
    }

    public void setTrsShtDesc(RichInputText trsShtDesc) {
        this.trsShtDesc = trsShtDesc;
    }

    public RichInputText getTrsShtDesc() {
        return trsShtDesc;
    }

    public void setTreatiesLOV(RichTable treatiesLOV) {
        this.treatiesLOV = treatiesLOV;
    }

    public RichTable getTreatiesLOV() {
        return treatiesLOV;
    }

    public String AssignTreatyLOV() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findTreatyLOVIterator");
        RowKeySet set = treatiesLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();


            session.setAttribute("TRS_CODE", r.getAttribute("TRS_CODE"));
            session.setAttribute("TRT_CODE", r.getAttribute("TRS_TRT_CODE"));

            trsShtDesc.setValue(r.getAttribute("TRS_SHT_DESC"));
            trsTrtShtDesc.setValue(r.getAttribute("TRS_TRT_SHT_DESC"));

        }
        ExtendedRenderKitService erkService =
            Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                               ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
                             "var hints = {autodismissNever:false}; " +
                             "AdfPage.PAGE.findComponent('" +
                             "lmsgroup:TreatySetup" + "').show(hints);");
        return null;
    }

    public void setTrsTrtShtDesc(RichInputText trsTrtShtDesc) {
        this.trsTrtShtDesc = trsTrtShtDesc;
    }

    public RichInputText getTrsTrtShtDesc() {
        return trsTrtShtDesc;
    }

    public void setPeriodFrom(RichInputDate periodFrom) {
        this.periodFrom = periodFrom;
    }

    public RichInputDate getPeriodFrom() {
        return periodFrom;
    }

    public void setPeriodTo(RichInputDate periodTo) {
        this.periodTo = periodTo;
    }

    public RichInputDate getPeriodTo() {
        return periodTo;
    }

    public void setInterestOnPremiumResv(RichInputText interestOnPremiumResv) {
        this.interestOnPremiumResv = interestOnPremiumResv;
    }

    public RichInputText getInterestOnPremiumResv() {
        return interestOnPremiumResv;
    }

    public void setProfitCommission(RichInputText profitCommission) {
        this.profitCommission = profitCommission;
    }

    public RichInputText getProfitCommission() {
        return profitCommission;
    }

    public void setManagementFeeRate(RichInputText managementFeeRate) {
        this.managementFeeRate = managementFeeRate;
    }

    public RichInputText getManagementFeeRate() {
        return managementFeeRate;
    }

    public void setCashLoss(RichInputText cashLoss) {
        this.cashLoss = cashLoss;
    }

    public RichInputText getCashLoss() {
        return cashLoss;
    }

    public void setAccounts(RichSelectOneChoice accounts) {
        this.accounts = accounts;
    }

    public RichSelectOneChoice getAccounts() {
        return accounts;
    }

    public void setCompanyReinsCode(RichInputText companyReinsCode) {
        this.companyReinsCode = companyReinsCode;
    }

    public RichInputText getCompanyReinsCode() {
        return companyReinsCode;
    }

    public void setPremiumPortfolio(RichInputText premiumPortfolio) {
        this.premiumPortfolio = premiumPortfolio;
    }

    public RichInputText getPremiumPortfolio() {
        return premiumPortfolio;
    }

    public void setClaimPortfolio(RichInputText claimPortfolio) {
        this.claimPortfolio = claimPortfolio;
    }

    public RichInputText getClaimPortfolio() {
        return claimPortfolio;
    }

    public void setQuakeLimit(RichInputText quakeLimit) {
        this.quakeLimit = quakeLimit;
    }

    public RichInputText getQuakeLimit() {
        return quakeLimit;
    }

    public void setCommissionRate(RichInputText commissionRate) {
        this.commissionRate = commissionRate;
    }

    public RichInputText getCommissionRate() {
        return commissionRate;
    }

    public void setCurrency(RichInputText currency) {
        this.currency = currency;
    }

    public RichInputText getCurrency() {
        return currency;
    }

    public void setPremiumReserve(RichInputText premiumReserve) {
        this.premiumReserve = premiumReserve;
    }

    public RichInputText getPremiumReserve() {
        return premiumReserve;
    }

    public void setPeriodLossCarriedForward(RichInputText periodLossCarriedForward) {
        this.periodLossCarriedForward = periodLossCarriedForward;
    }

    public RichInputText getPeriodLossCarriedForward() {
        return periodLossCarriedForward;
    }

    public void setSiStartFrom(RichInputText siStartFrom) {
        this.siStartFrom = siStartFrom;
    }

    public RichInputText getSiStartFrom() {
        return siStartFrom;
    }

    public void setGeneralConditions(RichInputText generalConditions) {
        this.generalConditions = generalConditions;
    }

    public RichInputText getGeneralConditions() {
        return generalConditions;
    }

    public void setExclusions(RichInputText exclusions) {
        this.exclusions = exclusions;
    }

    public RichInputText getExclusions() {
        return exclusions;
    }

    public void setInformation(RichInputText information) {
        this.information = information;
    }

    public RichInputText getInformation() {
        return information;
    }

    public void setWording(RichInputText wording) {
        this.wording = wording;
    }

    public RichInputText getWording() {
        return wording;
    }

    public void setWarranty(RichInputText warranty) {
        this.warranty = warranty;
    }

    public RichInputText getWarranty() {
        return warranty;
    }

    public String SaveTreatySetup() {
        /*
*/
        String SaveQuery =
            "BEGIN LMS_SETUPS_PKG.update_arrgmntreatysetups(?,?,?,?,?,?,?,?,?,?,?,?" +
            ");END;";
        Connection conn;
        conn = null;
        try {
            conn = new DBConnector().getDatabaseConn();
            CallableStatement cstmt = conn.prepareCall(SaveQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("REI_CODE"));
            cstmt.setBigDecimal(2,
                                (BigDecimal)session.getAttribute("TRT_CODE"));
            if (trsShtDesc.getValue() == null) {
                cstmt.setString(3, null);
            } else {
                cstmt.setString(3, trsShtDesc.getValue().toString());
            }
            cstmt.setBigDecimal(4, (BigDecimal)session.getAttribute("uw_yr"));
            cstmt.setBigDecimal(5,
                                (BigDecimal)session.getAttribute("as_code"));
            cstmt.setBigDecimal(6,
                                (BigDecimal)session.getAttribute("ta_code"));
            if (periodFrom.getValue() == null) {
                cstmt.setString(7, null);
            } else {
                if (periodFrom.getValue().toString().contains(":")) {
                    cstmt.setString(7,
                                    GlobalCC.parseDate(periodFrom.getValue().toString())); //v_wef_dt lms_treaty_setups.rei_wef_dt%TYPE,
                } else {
                    cstmt.setString(7,
                                    GlobalCC.upDateParseDate(periodFrom.getValue().toString())); //v_wef_dt lms_treaty_setups.rei_wef_dt%TYPE,
                }
            }
            if (periodTo.getValue() == null) {
                cstmt.setString(8, null);
            } else {
                if (periodFrom.getValue().toString().contains(":")) {
                    cstmt.setString(8,
                                    GlobalCC.parseDate(periodTo.getValue().toString())); //v_wef_dt lms_treaty_setups.rei_wef_dt%TYPE,
                } else {
                    cstmt.setString(8,
                                    GlobalCC.upDateParseDate(periodTo.getValue().toString())); //v_wef_dt lms_treaty_setups.rei_wef_dt%TYPE,
                }
            }
            cstmt.setBigDecimal(9,
                                (BigDecimal)session.getAttribute("TRS_CODE"));
            cstmt.setString(10, "L");
            if (commissionRate.getValue() == null) {
                cstmt.setBigDecimal(11, null);
            } else {
                cstmt.setString(11, commissionRate.getValue().toString());
            }
            if (accounts.getValue() == null) {
                cstmt.setBigDecimal(12, null);
            } else {
                cstmt.setString(12, accounts.getValue().toString());
            }
            //cstmt.setString(13,null);
            //cstmt.setString(14,null);
            /* if(quakeLimit.getValue()==null) {
                   cstmt.setString(15,null);
               }
               else {
                   cstmt.setString(15,quakeLimit.getValue().toString());
               }*/
            cstmt.execute();
            cstmt.close();
            String Message = "Treaty setup Successfully Saved";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
            ADFUtils.findIterator("findTreatySetupsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(treatySetupsLOV);
        } catch (Exception ex) {
            //ex.printStackTrace();
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        }
        return null;
    }

    public String DeleteTreatySetup() {
        Connection conn = null;
        BigDecimal REICode = null;
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findTreatySetupsIterator");
            RowKeySet set = treatySetupsLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            //System.out.println(1);
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                REICode = (BigDecimal)r.getAttribute("REI_CODE");

                String authQuery =
                    "BEGIN LMS_SETUPS_PKG.delete_treaty_arrange_setups(?);END;";
                conn = new DBConnector().getDatabaseConn();

                CallableStatement cstmt = conn.prepareCall(authQuery);
                cstmt.setBigDecimal(1, REICode);

                cstmt.execute();
                conn.close();

            }
            ADFUtils.findIterator("findTreatySetupsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(treatySetupsLOV);
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        }
        return null;
    }

    public String AddTreatySetup() {
        session.setAttribute("REI_CODE", null);

        trsShtDesc.setValue(null);
        trsTrtShtDesc.setValue(null);
        commissionRate.setValue(null);
        quakeLimit.setValue(null);
        profitCommission.setValue(null);
        periodFrom.setValue(null);
        periodTo.setValue(null);
        interestOnPremiumResv.setValue(null);
        profitCommission.setValue(null);
        managementFeeRate.setValue(null);
        cashLoss.setValue(null);
        accounts.setValue(null);
        companyReinsCode.setValue(null);
        premiumPortfolio.setValue(null);
        claimPortfolio.setValue(null);
        quakeLimit.setValue(null);
        commissionRate.setValue(null);
        currency.setValue(null);
        premiumReserve.setValue(null);
        periodLossCarriedForward.setValue(null);
        siStartFrom.setValue(null);
        generalConditions.setValue(null);
        exclusions.setValue(null);
        information.setValue(null);
        wording.setValue(null);
        warranty.setValue(null);
        ExtendedRenderKitService erkService =
            Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                               ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
                             "var hints = {autodismissNever:false}; " +
                             "AdfPage.PAGE.findComponent('" +
                             "lmsgroup:TreatySetup" + "').show(hints);");
        return null;
    }

    public String EditTreatySetup() {

        RowKeySet rowKeySet = treatySetupsLOV.getSelectedRowKeys();
        if (!rowKeySet.iterator().hasNext()) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
            return null;
        }

        Object key2 = rowKeySet.iterator().next();
        treatySetupsLOV.setRowKey(key2);

        JUCtrlValueBinding r =
            (JUCtrlValueBinding)treatySetupsLOV.getRowData();

        if (r == null) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
            return null;
        }


        session.setAttribute("TRS_CODE", r.getAttribute("REI_TRS_CODE"));
        session.setAttribute("TRT_CODE", r.getAttribute("REI_TRT_CODE"));
        trsShtDesc.setValue(r.getAttribute("REI_TRS_SHT_DESC"));
        trsTrtShtDesc.setValue(r.getAttribute("REI_TRT_SHT_DESC"));
        if (r.getAttribute("REI_COMM_RATE") == null) {
            commissionRate.setValue(null);
        } else {
            commissionRate.setValue(r.getAttribute("REI_COMM_RATE"));
        }
        if (r.getAttribute("REI_QUAKE_LIMIT") == null) {
            quakeLimit.setValue(null);
        } else {
            quakeLimit.setValue(r.getAttribute("REI_QUAKE_LIMIT"));
        }
        if (r.getAttribute("REI_PROFIT_COMM") == null) {
            profitCommission.setValue(null);
        } else {
            profitCommission.setValue(r.getAttribute("REI_PROFIT_COMM"));
        }
        periodFrom.setValue(r.getAttribute("REI_WEF_DT"));
        periodTo.setValue(r.getAttribute("REI_WET_DT"));
        interestOnPremiumResv.setValue(r.getAttribute("REI_PREM_RESV_INT"));
        profitCommission.setValue(r.getAttribute("REI_PROFIT_COMM"));
        managementFeeRate.setValue(r.getAttribute("REI_MGT_FEE"));
        cashLoss.setValue(r.getAttribute("REI_CASH_LOSS"));
        accounts.setValue(r.getAttribute("REI_ACCOUNTS"));
        companyReinsCode.setValue(r.getAttribute("REI_AOFREINS_CODE"));
        premiumPortfolio.setValue(r.getAttribute("REI_PREM_PORTFOLIO"));
        claimPortfolio.setValue(r.getAttribute("REI_LOSS_PORTFOLIO"));
        quakeLimit.setValue(r.getAttribute("REI_QUAKE_LIMIT"));
        commissionRate.setValue(r.getAttribute("REI_COMM_RATE"));
        currency.setValue(r.getAttribute("CUR_DESCN"));
        premiumReserve.setValue(r.getAttribute("REI_PREM_PORTFOLIO"));
        periodLossCarriedForward.setValue(r.getAttribute("REI_PRD_LOSSES_CARRIED_FRD"));
        siStartFrom.setValue(r.getAttribute("REI_SI_START_FROM"));
        generalConditions.setValue(r.getAttribute("REI_GEN_CONDITIONS"));
        exclusions.setValue(r.getAttribute("REI_EXCLUSIONS"));
        information.setValue(r.getAttribute("REI_INFORMATION"));
        wording.setValue(r.getAttribute("REI_WORDING"));
        warranty.setValue(r.getAttribute("REI_WARRANTY"));

        ExtendedRenderKitService erkService =
            Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                               ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
                             "var hints = {autodismissNever:false}; " +
                             "AdfPage.PAGE.findComponent('" +
                             "lmsgroup:TreatySetup" + "').show(hints);");
        return null;
    }

    public void setParticipantsLOV(RichTable participantsLOV) {
        this.participantsLOV = participantsLOV;
    }

    public RichTable getParticipantsLOV() {
        return participantsLOV;
    }

    public String AddTreatyParticipants() {
        ExtendedRenderKitService erkService =
            Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                               ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
                             "var hints = {autodismissNever:false}; " +
                             "AdfPage.PAGE.findComponent('" +
                             "lmsgroup:AddParticispantPopup" +
                             "').show(hints);");
        return null;
    }

    public void setParticipantID(RichInputText participantID) {
        this.participantID = participantID;
    }

    public RichInputText getParticipantID() {
        return participantID;
    }

    public String AssignReinsurer() {
        RowKeySet rowKeySet = reinsurersLOV.getSelectedRowKeys();
        if (!rowKeySet.iterator().hasNext()) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
            return null;
        }

        Object key2 = rowKeySet.iterator().next();
        reinsurersLOV.setRowKey(key2);

        JUCtrlValueBinding r = (JUCtrlValueBinding)reinsurersLOV.getRowData();

        if (r == null) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
            return null;
        }


        session.setAttribute("AGEN_CODE", r.getAttribute("AGEN_CODE"));
        participantID.setValue(r.getAttribute("AGEN_SHT_DESC"));
        participantName.setValue(r.getAttribute("AGEN_NAME"));


        ExtendedRenderKitService erkService =
            Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                               ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
                             "var hints = {autodismissNever:false}; " +
                             "AdfPage.PAGE.findComponent('" +
                             "lmsgroup:AddParticispantPopup" +
                             "').show(hints);");
        return null;
    }

    public void setReinsurersLOV(RichTable reinsurersLOV) {
        this.reinsurersLOV = reinsurersLOV;
    }

    public RichTable getReinsurersLOV() {
        return reinsurersLOV;
    }

    public void setParticipantName(RichInputText participantName) {
        this.participantName = participantName;
    }

    public RichInputText getParticipantName() {
        return participantName;
    }

    public void setCompanyRate(RichInputText companyRate) {
        this.companyRate = companyRate;
    }

    public RichInputText getCompanyRate() {
        return companyRate;
    }

    public void setPremTaxChargeable(RichSelectOneChoice premTaxChargeable) {
        this.premTaxChargeable = premTaxChargeable;
    }

    public RichSelectOneChoice getPremTaxChargeable() {
        return premTaxChargeable;
    }

    public void setGlAccountCode(RichInputText glAccountCode) {
        this.glAccountCode = glAccountCode;
    }

    public RichInputText getGlAccountCode() {
        return glAccountCode;
    }

    public String SaveParticipant() {
        String saveQuery =
            "BEGIN LMS_SETUPS_PKG.update_treaty_participants(?,?,?,?,?,?,?,?,?);END;";
        Connection conn = null;
        try {
            conn = new DBConnector().getDatabaseConn();
            CallableStatement cstmt = conn.prepareCall(saveQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("AGEN_CODE"));
            cstmt.setString(2, participantID.getValue().toString());
            cstmt.setBigDecimal(3,
                                (BigDecimal)session.getAttribute("REI_CODE"));
            cstmt.setBigDecimal(4, (BigDecimal)session.getAttribute("uw_yr"));
            if (companyRate.getValue() == null) {
                cstmt.setString(5, null);
            }

            else {
                cstmt.setString(5, companyRate.getValue().toString());
            }
            if (premTaxChargeable.getValue() == null) {
                cstmt.setString(6, null);
            } else {
                cstmt.setString(6, premTaxChargeable.getValue().toString());
            }
            cstmt.setBigDecimal(7,
                                (BigDecimal)session.getAttribute("TRS_CODE"));
            cstmt.setString(8, null);
            if (glAccountCode.getValue() == null) {
                cstmt.setString(9, null);
            } else {
                cstmt.setString(9, glAccountCode.getValue().toString());
            }
            cstmt.execute();
            cstmt.close();
            String Message = "Treaty Participant Successfully Saved";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
            ADFUtils.findIterator("findTreatyParticipantsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(participantsLOV);
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        }
        return null;
    }

    public String EditTreatyParticipant() {
        RowKeySet rowKeySet = participantsLOV.getSelectedRowKeys();
        if (!rowKeySet.iterator().hasNext()) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
            return null;
        }

        Object key2 = rowKeySet.iterator().next();
        participantsLOV.setRowKey(key2);

        JUCtrlValueBinding r =
            (JUCtrlValueBinding)participantsLOV.getRowData();

        if (r == null) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
            return null;
        }


        session.setAttribute("AGEN_CODE", r.getAttribute("trpa_agen_code"));
        session.setAttribute("REI_CODE", r.getAttribute("trpa_rei_code"));
        session.setAttribute("uw_yr", r.getAttribute("trpa_uw_year"));
        participantID.setValue(r.getAttribute("trpa_agen_sht_desc"));
        participantName.setValue(r.getAttribute("agn_name"));
        if (r.getAttribute("trpa_comp_rate") == null) {
            companyRate.setValue(null);
        } else {
            companyRate.setValue(r.getAttribute("trpa_comp_rate"));
        }
        if (r.getAttribute("trpa_rei_prem_taxable") == null) {
            premTaxChargeable.setValue(null);
        } else {
            premTaxChargeable.setValue(r.getAttribute("trpa_rei_prem_taxable"));
        }
        if (r.getAttribute("trpa_gl_ctrl_account") == null) {
            glAccountCode.setValue(null);
        } else {
            glAccountCode.setValue(r.getAttribute("trpa_gl_ctrl_account"));
        }


        ExtendedRenderKitService erkService =
            Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                               ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
                             "var hints = {autodismissNever:false}; " +
                             "AdfPage.PAGE.findComponent('" +
                             "lmsgroup:AddParticispantPopup" +
                             "').show(hints);");
        return null;
    }

    public String DeleteTreatyParticipant() {

        RowKeySet rowKeySet = participantsLOV.getSelectedRowKeys();
        if (!rowKeySet.iterator().hasNext()) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
            return null;
        }

        Object key2 = rowKeySet.iterator().next();
        participantsLOV.setRowKey(key2);

        JUCtrlValueBinding r =
            (JUCtrlValueBinding)participantsLOV.getRowData();

        if (r == null) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
            return null;
        }

        session.setAttribute("AGEN_CODE", r.getAttribute("trpa_agen_code"));
        session.setAttribute("REI_CODE", r.getAttribute("trpa_rei_code"));
        session.setAttribute("uw_yr", r.getAttribute("trpa_uw_year"));
        String saveQuery =
            "BEGIN LMS_SETUPS_PKG.delete_treaty_participants(?,?,?);END;";
        Connection conn = null;
        try {
            conn = new DBConnector().getDatabaseConn();
            CallableStatement cstmt = conn.prepareCall(saveQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("AGEN_CODE"));
            cstmt.setBigDecimal(2,
                                (BigDecimal)session.getAttribute("REI_CODE"));
            cstmt.setBigDecimal(3, (BigDecimal)session.getAttribute("uw_yr"));
            cstmt.execute();
            cstmt.close();
            String Message = "Treaty Participant Successfully Deleted";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
            ADFUtils.findIterator("findTreatyParticipantsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(participantsLOV);
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        }


        return null;
    }

    public void TreatyParticipantsListener(SelectionEvent selectionEvent) {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findTreatySetupsIterator");
        RowKeySet set = treatySetupsLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            session.setAttribute("REI_CODE", r.getAttribute("REI_CODE"));
            ADFUtils.findIterator("findTreatyParticipantsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(participantsLOV);
            ADFUtils.findIterator("findTreatyParticipantsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(reinsurersLOV);
            ADFUtils.findIterator("findArrangementCoverTypesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(arrangementCoverTypesLOV);
        }
    }

    public String AssignGlCode() {
        try {
            RowKeySet rowKeySet = glAccountsLOV.getSelectedRowKeys();
            if (!rowKeySet.iterator().hasNext()) {
                GlobalCC.errorValueNotEntered("Error: No Record Selected");
                //return null;
            }

            Object key2 = rowKeySet.iterator().next();
            glAccountsLOV.setRowKey(key2);

            JUCtrlValueBinding r =
                (JUCtrlValueBinding)glAccountsLOV.getRowData();

            if (r == null) {
                GlobalCC.errorValueNotEntered("Error: No Record Selected");
                //return null;
            }
            glAccountCode.setValue(r.getAttribute("accNumber"));
            AdfFacesContext.getCurrentInstance().addPartialTarget(glAccountCode);

            GlobalCC.hidePopup("lmsgroup:glAccountsPopup");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public void setTreatyCoverTypesTabProdLOV(RichTable treatyCoverTypesTabProdLOV) {
        this.treatyCoverTypesTabProdLOV = treatyCoverTypesTabProdLOV;
    }

    public RichTable getTreatyCoverTypesTabProdLOV() {
        return treatyCoverTypesTabProdLOV;
    }

    public void setTreatyCoverTypesTabSetupsLOV(RichTable treatyCoverTypesTabSetupsLOV) {
        this.treatyCoverTypesTabSetupsLOV = treatyCoverTypesTabSetupsLOV;
    }

    public RichTable getTreatyCoverTypesTabSetupsLOV() {
        return treatyCoverTypesTabSetupsLOV;
    }

    public void setArrangementCoverTypesLOV(RichTable arrangementCoverTypesLOV) {
        this.arrangementCoverTypesLOV = arrangementCoverTypesLOV;
    }

    public RichTable getArrangementCoverTypesLOV() {
        return arrangementCoverTypesLOV;
    }

    public String AddArrangementCoverType() {
        session.setAttribute("ATCT_CODE", null);
        session.setAttribute("ORRP_CODE", null);
        session.setAttribute("ORRP_CLASS_SPECIFIC", null);

        arrCoverType.setValue(null);
        cedeType.setValue(null);
        cedeRate.setValue(null);
        arrRateType.setValue(null);
        arrRateName.setValue(null);
        atctLimit.setValue(null);

        GlobalCC.showPopup("lmsgroup:ArrangementCoverType");

        return null;
    }

    public void setArrCoverType(RichInputText arrCoverType) {
        this.arrCoverType = arrCoverType;
    }

    public RichInputText getArrCoverType() {
        return arrCoverType;
    }

    public void setArrangeCoversLOV(RichTable arrangeCoversLOV) {
        this.arrangeCoversLOV = arrangeCoversLOV;
    }

    public RichTable getArrangeCoversLOV() {
        return arrangeCoversLOV;
    }

    public String AssignArrangementCoverType() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findArrangementCoverTypesLOVIterator");
        RowKeySet set = arrangeCoversLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();


            session.setAttribute("TCT_CODE", r.getAttribute("TCT_CODE"));
            session.setAttribute("TCT_CVT_CODE",
                                 r.getAttribute("TCT_CVT_CODE"));
            session.setAttribute("TCT_CVT_SHT_DESC",
                                 r.getAttribute("TCT_CVT_SHT_DESC"));
            session.setAttribute("TCT_PCT_CODE",
                                 r.getAttribute("TCT_PCT_CODE"));
            arrCoverType.setValue(r.getAttribute("CVT_DESC"));


        }
        ExtendedRenderKitService erkService =
            Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                               ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
                             "var hints = {autodismissNever:false}; " +
                             "AdfPage.PAGE.findComponent('" +
                             "lmsgroup:ArrangementCoverType" +
                             "').show(hints);");
        return null;
    }

    public void setCedeType(RichSelectOneChoice cedeType) {
        this.cedeType = cedeType;
    }

    public RichSelectOneChoice getCedeType() {
        return cedeType;
    }

    public void setCedeRate(RichInputText cedeRate) {
        this.cedeRate = cedeRate;
    }

    public RichInputText getCedeRate() {
        return cedeRate;
    }

    public void setArrRateType(RichSelectOneChoice arrRateType) {
        this.arrRateType = arrRateType;
    }

    public RichSelectOneChoice getArrRateType() {
        return arrRateType;
    }

    public void setArrRateName(RichInputText arrRateName) {
        this.arrRateName = arrRateName;
    }

    public RichInputText getArrRateName() {
        return arrRateName;
    }

    public String AssignOrdReinRates() {
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findOrdReinRatesLOVIterator");
            RowKeySet set = ordReinRatesLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            //System.out.println(1);
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();


                session.setAttribute("ORRP_CODE", r.getAttribute("ORRP_CODE"));
                arrRateName.setValue(r.getAttribute("ORRP_DESC"));
                session.setAttribute("ORRP_CLASS_SPECIFIC",
                                     r.getAttribute("ORRP_CLASS_SPECIFIC"));
                AdfFacesContext.getCurrentInstance().addPartialTarget(arrRateName);
            }
            GlobalCC.hidePopup("lmsgroup:arrRatesPopup");

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String CancelRateName() {
        GlobalCC.hidePopup("lmsgroup:arrRatesPopup");
        return null;
    }

    public void setOrdReinRatesLOV(RichTable ordReinRatesLOV) {
        this.ordReinRatesLOV = ordReinRatesLOV;
    }

    public RichTable getOrdReinRatesLOV() {
        return ordReinRatesLOV;
    }

    public void setAtctLimit(RichInputText atctLimit) {
        this.atctLimit = atctLimit;
    }

    public RichInputText getAtctLimit() {
        return atctLimit;
    }

    public String SaveArrangementCoverType() {
        String saveQuery =
            "BEGIN LMS_SETUPS_PKG.updt_treaty_arrgmtcovertypes(?,?,?,?,?,?,?,?,?,?" +
            ",?,?,?,?,?,?,?,?,?,?);END;";
        Connection conn = null;
        try {
            conn = new DBConnector().getDatabaseConn();
            CallableStatement cstmt = conn.prepareCall(saveQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("ATCT_CODE"));
            cstmt.setBigDecimal(2,
                                (BigDecimal)session.getAttribute("TCT_CODE"));
            cstmt.setBigDecimal(3,
                                (BigDecimal)session.getAttribute("trpd_code"));
            cstmt.setBigDecimal(4,
                                (BigDecimal)session.getAttribute("ta_code"));
            cstmt.setString(5, (String)session.getAttribute("ta_sht_desc"));
            cstmt.setBigDecimal(6,
                                (BigDecimal)session.getAttribute("REI_CODE"));
            cstmt.setBigDecimal(7,
                                (BigDecimal)session.getAttribute("TCT_PCT_CODE"));
            cstmt.setBigDecimal(8,
                                (BigDecimal)session.getAttribute("TCT_CVT_CODE"));
            cstmt.setString(9,
                            (String)session.getAttribute("TCT_CVT_SHT_DESC"));
            cstmt.setBigDecimal(10,
                                (BigDecimal)session.getAttribute("as_code"));
            cstmt.setBigDecimal(11,
                                (BigDecimal)session.getAttribute("ProductCode"));
            if (cedeType.getValue() == null) {
                cstmt.setString(12, null);
            } else {
                cstmt.setString(12, cedeType.getValue().toString());
            }
            if (cedeRate.getValue() == null) {
                cstmt.setString(13, null);
            } else {
                cstmt.setString(13, cedeRate.getValue().toString());
            }
            if (arrRateType.getValue() == null) {
                cstmt.setString(14, null);
            } else {
                cstmt.setString(14, arrRateType.getValue().toString());
            }
            cstmt.setString(15, null);
            if (atctLimit.getValue() == null) {
                cstmt.setString(16, null);
            } else {
                cstmt.setString(16, atctLimit.getValue().toString());
            }
            cstmt.setBigDecimal(17,
                                (BigDecimal)session.getAttribute("ORRP_CODE"));
            cstmt.setString(18, null);
            cstmt.setString(19,
                            (String)session.getAttribute("ORRP_CLASS_SPECIFIC"));
            cstmt.setString(20, null);
            cstmt.execute();
            cstmt.close();
            String Message =
                "Cover Type Successfully Added To Arrangement Treaty";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
            ADFUtils.findIterator("findArrangementCoverTypesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(arrangementCoverTypesLOV);
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        }
        return null;
    }

    public String showTreatyProducts() {
        ADFUtils.findIterator("findArrangementSetups1Iterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(treatyCoverTypesTabProdLOV);

        GlobalCC.showPopup("lmsgroup:p1");
        return null;
    }

    public String showTreatyCoverTypes() {
        ADFUtils.findIterator("findTreatySetupsIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(treatyCoverTypesTabSetupsLOV);

        GlobalCC.showPopup("lmsgroup:p2");
        return null;
    }

    public String findTreatyCoverTypesSelected() {
        try {
            RowKeySet rowKeySet =
                treatyCoverTypesTabSetupsLOV.getSelectedRowKeys();
            Object key2 = rowKeySet.iterator().next();
            treatyCoverTypesTabSetupsLOV.setRowKey(key2);
            JUCtrlValueBinding r =
                (JUCtrlValueBinding)treatyCoverTypesTabSetupsLOV.getRowData();

            session.setAttribute("REI_CODE", r.getAttribute("REI_CODE"));
            arrangementDesc.setValue(r.getAttribute("REI_TRT_SHT_DESC"));

            ADFUtils.findIterator("findArrangementCoverTypesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(arrangementCoverTypesLOV);

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }


    public String findTreatyProductsSelected() {

        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findArrangementSetups1Iterator");
            RowKeySet set = treatyCoverTypesTabProdLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            //System.out.println(1);
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();


                session.setAttribute("trpd_code", r.getAttribute("TPRD_CODE"));
                session.setAttribute("ProductCode",
                                     r.getAttribute("TPRD_PROD_CODE"));
                treatyProductDesc.setValue(r.getAttribute("PRODUCT_DISPLAY"));

                ADFUtils.findIterator("findArrangementCoverTypesIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(arrangementCoverTypesLOV);

            }
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String EditArrangementCoverType() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findArrangementCoverTypesIterator");
        RowKeySet set = arrangementCoverTypesLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();


            session.setAttribute("ATCT_CODE", r.getAttribute("atct_code"));
            session.setAttribute("TCT_CODE", r.getAttribute("atct_tct_code"));
            session.setAttribute("TCT_PCT_CODE",
                                 r.getAttribute("atct_pct_code"));
            session.setAttribute("CVT_CODE", r.getAttribute("atct_cvt_code"));
            session.setAttribute("TCT_CVT_SHT_DESC",
                                 r.getAttribute("atct_cvt_sht_desc"));
            arrCoverType.setValue(r.getAttribute("cvt_desc"));
            cedeType.setValue(r.getAttribute("atct_cede_type"));
            cedeRate.setValue(r.getAttribute("atct_cede_rate"));
            arrRateType.setValue(r.getAttribute("atct_rate_type"));
            arrRateName.setValue(r.getAttribute("orrp_desc"));
            //session.setAttribute("ORRP_CLASS_SPECIFIC",r.getAttribute("ORRP_CLASS_SPECIFIC "));


            session.setAttribute("ORRP_CODE",
                                 r.getAttribute("atct_orrp_code"));
            session.setAttribute("ORRP_CLASS_SPECIFIC",
                                 r.getAttribute("atct_class_specific"));
            atctLimit.setValue(r.getAttribute("atct_limit"));

        }
        ExtendedRenderKitService erkService =
            Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                               ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
                             "var hints = {autodismissNever:false}; " +
                             "AdfPage.PAGE.findComponent('" +
                             "lmsgroup:ArrangementCoverType" +
                             "').show(hints);");
        return null;
    }

    public String DeleteArrCoverType() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findArrangementCoverTypesIterator");
        RowKeySet set = arrangementCoverTypesLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        String saveQuery =
            "BEGIN LMS_SETUPS_PKG.delete_treaty_arrgmtcovertypes(?);END;";
        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();


            session.setAttribute("ATCT_CODE", r.getAttribute("atct_code"));
        }
        Connection conn = null;
        try {
            conn = new DBConnector().getDatabaseConn();
            CallableStatement cstmt = conn.prepareCall(saveQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("ATCT_CODE"));
            cstmt.execute();
            cstmt.close();
            String Message =
                "Cover Type Successfully Deleted from Arrangement Treaty";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
            ADFUtils.findIterator("findArrangementCoverTypesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(arrangementCoverTypesLOV);
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        }
        return null;
    }

    public void ArrCoverTypesListener(SelectionEvent selectionEvent) {
        if (selectionEvent.getAddedSet() != selectionEvent.getRemovedSet()) {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findArrangementCoverTypesIterator");
            RowKeySet set = arrangementCoverTypesLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            //System.out.println(1);
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();


                session.setAttribute("ATCT_CODE", r.getAttribute("atct_code"));
                session.setAttribute("TCT_PCT_CODE",
                                     r.getAttribute("atct_pct_code"));
            }

            ADFUtils.findIterator("findArrangementCoverTypesCommRatesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(commissionRatesLOV);
        }
    }


    public void arrangmtCoverTypesSelected(SelectionEvent evt) {

        if (evt.getAddedSet() != evt.getRemovedSet()) {
            RowKeySet rowKeySet =
                arrangementCoverTypesLOV.getSelectedRowKeys();
            Object key2 = rowKeySet.iterator().next();
            arrangementCoverTypesLOV.setRowKey(key2);
            JUCtrlValueBinding r =
                (JUCtrlValueBinding)arrangementCoverTypesLOV.getRowData();

            session.setAttribute("ATCT_CODE", r.getAttribute("atct_code"));

            ADFUtils.findIterator("findArrangementCoverTypesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(commissionRatesLOV);


        }
    }

    public void setCommissionRatesLOV(RichTable commissionRatesLOV) {
        this.commissionRatesLOV = commissionRatesLOV;
    }

    public RichTable getCommissionRatesLOV() {
        return commissionRatesLOV;
    }

    public void setYearFrom(RichInputText yearFrom) {
        this.yearFrom = yearFrom;
    }

    public RichInputText getYearFrom() {
        return yearFrom;
    }

    public void setYearTo(RichInputText yearTo) {
        this.yearTo = yearTo;
    }

    public RichInputText getYearTo() {
        return yearTo;
    }

    public void setArrcommissionRate(RichInputText arrcommissionRate) {
        this.arrcommissionRate = arrcommissionRate;
    }

    public RichInputText getArrcommissionRate() {
        return arrcommissionRate;
    }

    public void setCommissionDivFact(RichSelectOneChoice commissionDivFact) {
        this.commissionDivFact = commissionDivFact;
    }

    public RichSelectOneChoice getCommissionDivFact() {
        return commissionDivFact;
    }

    public void setWefDate(RichInputDate wefDate) {
        this.wefDate = wefDate;
    }

    public RichInputDate getWefDate() {
        return wefDate;
    }

    public void setWetDate(RichInputDate wetDate) {
        this.wetDate = wetDate;
    }

    public RichInputDate getWetDate() {
        return wetDate;
    }

    public String SaveCommissionrates() {
        String wefStDate = null;
        String wetStDate = null;
        String saveQuery =
            "BEGIN LMS_SETUPS_PKG.updt_treaty_arrgmtcommrates(?,?,?,?,?,?,?,?,?);END;";
        Connection conn = null;
        try {
            conn = new DBConnector().getDatabaseConn();
            CallableStatement cstmt = conn.prepareCall(saveQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("TACR_CODE"));
            cstmt.setBigDecimal(2,
                                (BigDecimal)session.getAttribute("ATCT_CODE"));
            cstmt.setBigDecimal(3,
                                (BigDecimal)session.getAttribute("TCT_PCT_CODE"));
            if (yearFrom.getValue() == null) {
                cstmt.setString(4, null);
            } else {
                cstmt.setString(4, yearFrom.getValue().toString());
            }
            if (yearTo.getValue() == null) {
                cstmt.setString(5, null);
            } else {
                cstmt.setString(5, yearTo.getValue().toString());
            }
            if (arrcommissionRate.getValue() == null) {
                cstmt.setString(6, null);
            } else {
                cstmt.setString(6, arrcommissionRate.getValue().toString());
            }
            if (commissionDivFact.getValue() == null) {
                cstmt.setString(7, null);
            } else {
                cstmt.setString(7, commissionDivFact.getValue().toString());
            }
            if (wefDate.getValue() == null) {
                cstmt.setString(8, null);
            } else {
                if (wefDate.getValue().toString().contains(":")) {
                    wefStDate =
                            GlobalCC.parseDate(wefDate.getValue().toString());
                } else {
                    wefStDate =
                            GlobalCC.upDateParseDate(wefDate.getValue().toString());
                }
                cstmt.setString(8, wefStDate);
            }
            if (wetDate.getValue() == null) {
                cstmt.setString(9, null);
            } else {
                if (wetDate.getValue().toString().contains(":")) {
                    wetStDate =
                            GlobalCC.parseDate(wetDate.getValue().toString());
                } else {
                    wetStDate =
                            GlobalCC.upDateParseDate(wetDate.getValue().toString());
                }
                cstmt.setString(9, wetStDate);
            }

            cstmt.execute();
            cstmt.close();
            String Message = "Commission Rates successfully Added";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
            ADFUtils.findIterator("findArrangementCoverTypesCommRatesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(commissionRatesLOV);
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        }
        return null;
    }

    public String AddCommissionRates() {
        session.setAttribute("TACR_CODE", null);

        yearFrom.setValue(null);
        yearTo.setValue(null);
        arrcommissionRate.setValue(null);
        commissionDivFact.setValue("100");
        wefDate.setValue(null);
        wetDate.setValue(null);

        ExtendedRenderKitService erkService =
            Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                               ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
                             "var hints = {autodismissNever:false}; " +
                             "AdfPage.PAGE.findComponent('" +
                             "lmsgroup:CommissionRatesPopup" +
                             "').show(hints);");
        return null;
    }

    public String EditCommissionrates() {
        try {
            RowKeySet rowKeySet = commissionRatesLOV.getSelectedRowKeys();
            Object key2 = rowKeySet.iterator().next();
            commissionRatesLOV.setRowKey(key2);
            JUCtrlValueBinding r =
                (JUCtrlValueBinding)commissionRatesLOV.getRowData();


            session.setAttribute("TACR_CODE", r.getAttribute("tacr_code"));
            session.setAttribute("ATCT_CODE",
                                 r.getAttribute("tacr_atct_code"));
            if (r.getAttribute("tacr_yr_from") == null) {
                yearFrom.setValue(null);
            } else {
                yearFrom.setValue(r.getAttribute("tacr_yr_from"));
            }
            if (r.getAttribute("tacr_yr_to") == null) {
                yearTo.setValue(null);
            } else {
                yearTo.setValue(r.getAttribute("tacr_yr_to"));
            }
            session.setAttribute("TCT_PCT_CODE",
                                 r.getAttribute("tacr_pct_code"));
            if (r.getAttribute("tacr_comm_rate") == null) {
                arrcommissionRate.setValue(null);
            } else {
                arrcommissionRate.setValue(r.getAttribute("tacr_comm_rate"));
            }
            if (r.getAttribute("tacr_comm_div_factr") == null) {
                commissionDivFact.setValue(null);
            } else {
                commissionDivFact.setValue(r.getAttribute("tacr_comm_div_factr"));
            }
            if (r.getAttribute("tacr_wef") == null) {
                wefDate.setValue(null);
            } else {
                wefDate.setValue(r.getAttribute("tacr_wef"));
            }
            if (r.getAttribute("tacr_wet") == null) {
                wetDate.setValue(null);
            } else {
                wetDate.setValue(r.getAttribute("tacr_wet"));
            }

            ExtendedRenderKitService erkService =
                Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                   ExtendedRenderKitService.class);
            erkService.addScript(FacesContext.getCurrentInstance(),
                                 "var hints = {autodismissNever:false}; " +
                                 "AdfPage.PAGE.findComponent('" +
                                 "lmsgroup:CommissionRatesPopup" +
                                 "').show(hints);");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String DeleteCommissionrates() {

        String saveQuery =
            "BEGIN LMS_SETUPS_PKG.delete_treaty_arrgmtcommrates(?);END;";
        //System.out.println(1);
        RowKeySet rowKeySet = commissionRatesLOV.getSelectedRowKeys();
        Object key2 = rowKeySet.iterator().next();
        commissionRatesLOV.setRowKey(key2);
        JUCtrlValueBinding r =
            (JUCtrlValueBinding)commissionRatesLOV.getRowData();


        session.setAttribute("TACR_CODE", r.getAttribute("tacr_code"));
        session.setAttribute("TACR_CODE", r.getAttribute("tacr_code"));

        Connection conn = null;
        try {
            conn = new DBConnector().getDatabaseConn();
            CallableStatement cstmt = conn.prepareCall(saveQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("TACR_CODE"));
            cstmt.execute();
            cstmt.close();
            String Message =
                "Commission rates Successfully Deleted from Arrangement Treaty";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
            ADFUtils.findIterator("findArrangementCoverTypesCommRatesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(commissionRatesLOV);
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        }
        return null;
    }

    public String DeleteTreatyProduct() {
        Connection conn = null;
        try {

            String addQuery =
                "BEGIN LMS_SETUPS_PKG.delete_treaty_product(?);END;";

            conn = new DBConnector().getDatabaseConn();

            CallableStatement cstmt = conn.prepareCall(addQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("trpd_code"));


            cstmt.execute();
            conn.close();
            String Message = "Treaty Product Deleted succesfully.";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));

            session.setAttribute("trpd_code", null);
            treatyProductDesc.setValue(null);
            ADFUtils.findIterator("findArrangementSetups1Iterator").executeQuery();
            //AdfFacesContext.getCurrentInstance().addPartialTarget(treatyProductsLOV);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public String EditTreatyProduct() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findArrangementSetups1Iterator");
        RowKeySet set = treatyProductsLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            session.setAttribute("trpd_code", r.getAttribute("TPRD_CODE"));

            treatyProdDisplay.setValue(r.getAttribute("PRODUCT_DISPLAY"));
            defaultTreatyProd.setValue(r.getAttribute("TRPD_DEFAULT_TRTY"));

            // Render Popup
            ExtendedRenderKitService erkService =
                Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                   ExtendedRenderKitService.class);
            erkService.addScript(FacesContext.getCurrentInstance(),
                                 "var hints = {autodismissNever:false}; " +
                                 "AdfPage.PAGE.findComponent('" +
                                 "lmsgroup:ClassOfBusinessProductsPopup" +
                                 "').show(hints);");

        }
        return null;
    }

    public void setTreatyProdDisplay(RichInputText treatyProdDisplay) {
        this.treatyProdDisplay = treatyProdDisplay;
    }

    public RichInputText getTreatyProdDisplay() {
        return treatyProdDisplay;
    }

    public void setTreatyProdsLOV(RichTable treatyProdsLOV) {
        this.treatyProdsLOV = treatyProdsLOV;
    }

    public RichTable getTreatyProdsLOV() {
        return treatyProdsLOV;
    }


    public void setDefaultTreatyProd(RichSelectOneChoice defaultTreatyProd) {
        this.defaultTreatyProd = defaultTreatyProd;
    }

    public RichSelectOneChoice getDefaultTreatyProd() {
        return defaultTreatyProd;
    }

    public String AddTreatyProduct() {
        treatyProdDisplay.setValue(null);
        defaultTreatyProd.setValue(null);
        session.setAttribute("trpd_code", null);
        treatyProductDesc.setValue(null);
        ExtendedRenderKitService erkService =
            Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                               ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
                             "var hints = {autodismissNever:false}; " +
                             "AdfPage.PAGE.findComponent('" +
                             "lmsgroup:ClassOfBusinessProductsPopup" +
                             "').show(hints);");
        return null;
    }

    public String AssignTreatyProduct() {
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findProductsIterator");
            RowKeySet set = treatyProdsLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            //System.out.println(1);
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                session.setAttribute("PROD_CODE", r.getAttribute("PROD_CODE"));
                AddTreatyProd();
            }


        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(null, ex);
        }
        return null;
    }

    public String UpdateTreatyProd() {
        Connection conn = null;
        String addQuery =
            "BEGIN LMS_SETUPS_PKG.add_treaty_products(?,?,?,?,?,?,?,?);END;";
        try {
            conn = new DBConnector().getDatabaseConn();

            CallableStatement cstmt = conn.prepareCall(addQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("trpd_code"));
            cstmt.setBigDecimal(2,
                                (BigDecimal)session.getAttribute("ta_code"));
            cstmt.setString(3, (String)session.getAttribute("ta_sht_desc"));
            if (defaultTreatyProd.getValue() == null) {
                cstmt.setString(4, "N");
            } else {
                cstmt.setString(4, defaultTreatyProd.getValue().toString());
            }
            cstmt.setString(5, (String)session.getAttribute("ta_type"));
            cstmt.setBigDecimal(6, (BigDecimal)session.getAttribute("uw_yr"));
            cstmt.setBigDecimal(7,
                                (BigDecimal)session.getAttribute("PROD_CODE"));
            cstmt.setBigDecimal(8,
                                (BigDecimal)session.getAttribute("as_code"));


            cstmt.execute();
            conn.close();
            GlobalCC.INFORMATIONREPORTING("Treaty Product Saved succesfully.");

            session.setAttribute("trpd_code", null);
            treatyProductDesc.setValue(null);
            ADFUtils.findIterator("findArrangementSetups1Iterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(treatyProductTree);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;

    }


    public String AddTreatyProd() {
        Connection conn = null;
        String addQuery =
            "BEGIN LMS_SETUPS_PKG.add_treaty_products(?,?,?,?,?,?,?,?);END;";
        try {
            conn = new DBConnector().getDatabaseConn();

            CallableStatement cstmt = conn.prepareCall(addQuery);
            cstmt.setBigDecimal(1, null);
            cstmt.setBigDecimal(2,
                                (BigDecimal)session.getAttribute("ta_code"));
            cstmt.setString(3, (String)session.getAttribute("ta_sht_desc"));
            if (defaultTreatyProd.getValue() == null) {
                cstmt.setString(4, "N");
            } else {
                cstmt.setString(4, defaultTreatyProd.getValue().toString());
            }
            cstmt.setString(5, (String)session.getAttribute("ta_type"));
            cstmt.setBigDecimal(6, (BigDecimal)session.getAttribute("uw_yr"));
            cstmt.setBigDecimal(7,
                                (BigDecimal)session.getAttribute("PROD_CODE"));
            cstmt.setBigDecimal(8,
                                (BigDecimal)session.getAttribute("as_code"));


            cstmt.execute();
            conn.close();
            GlobalCC.INFORMATIONREPORTING("Treaty Product Saved succesfully.");

            session.setAttribute("trpd_code", null);
            treatyProductDesc.setValue(null);
            ADFUtils.findIterator("findArrangementSetups1Iterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(treatyProductTree);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;

    }

    public String SavePremiumFractions() {
        Connection conn = null;
        String addQuery =
            "BEGIN LMS_SETUPS_PKG.update_monthly_prem_fractions(?,?,?,?);END;";

        try {
            conn = new DBConnector().getDatabaseConn();

            CallableStatement cstmt = conn.prepareCall(addQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("PRODCode"));
            if (monthlyToAnnRate.getValue() == null) {
                cstmt.setString(2, null);
            } else {
                cstmt.setString(2, monthlyToAnnRate.getValue().toString());
            }
            if (semiToMonthlyRate.getValue() == null) {
                cstmt.setString(3, null);
            } else {
                cstmt.setString(3, semiToMonthlyRate.getValue().toString());
            }
            if (annualToMonthlyRate.getValue() == null) {
                cstmt.setString(4, null);
            } else {
                cstmt.setString(4, annualToMonthlyRate.getValue().toString());
            }


            cstmt.execute();
            conn.close();
            String Message = "Premium Fractions updated succesfully.";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));


            ADFUtils.findIterator("findGroupPremiumFractionsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(premiumFractionsLOV);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public String AddProductPoldocs() {

        documentType.setValue(null);
        documentName.setValue(null);
        session.setAttribute("PSPD_CODE", null);

        ExtendedRenderKitService erkService =
            Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                               ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
                             "var hints = {autodismissNever:false}; " +
                             "AdfPage.PAGE.findComponent('" +
                             "lmsgroup:PolDocsPopup" + "').show(hints);");
        return null;
    }

    public String AddCoverTypes() {
        session.setAttribute("CVT_CODE", null);
        coverID.setValue(null);
        coverDescription.setValue(null);
        mainCover.setValue(null);
        maximumAge.setValue(null);
        durationType.setValue(null);
        multiplier.setValue(null);
        divisionFactor.setValue(null);
        cvtReadFrom.setValue(null);
        cvtRateType.setValue(null);
        cvtReportName.setValue(null);
        cvtRemarks.setValue(null);
        paRatesFreqOfPymt.setValue(null);
        ExtendedRenderKitService erkService =
            Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                               ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
                             "var hints = {autodismissNever:false}; " +
                             "AdfPage.PAGE.findComponent('" +
                             "lmsgroup:CoverTypesPopup" + "').show(hints);");
        return null;
    }

    public void setDefaultDOBMon(RichInputDate defaultDOBMon) {
        this.defaultDOBMon = defaultDOBMon;
    }

    public RichInputDate getDefaultDOBMon() {
        return defaultDOBMon;
    }

    public void setProductStatus(RichSelectOneChoice productStatus) {
        this.productStatus = productStatus;
    }

    public RichSelectOneChoice getProductStatus() {
        return productStatus;
    }

    public void setProdWefDate(RichInputDate prodWefDate) {
        this.prodWefDate = prodWefDate;
    }

    public RichInputDate getProdWefDate() {
        return prodWefDate;
    }

    public void setWeeklyIndemnityLimit(RichInputText weeklyIndemnityLimit) {
        this.weeklyIndemnityLimit = weeklyIndemnityLimit;
    }

    public RichInputText getWeeklyIndemnityLimit() {
        return weeklyIndemnityLimit;
    }

    public void setTreatiesTree(RichTree treatiesTree) {
        this.treatiesTree = treatiesTree;
    }

    public RichTree getTreatiesTree() {
        return treatiesTree;
    }

    public void treatyProductsListener(SelectionEvent selectionEvent) {
        // Add event code here...
        if (selectionEvent.getAddedSet() != selectionEvent.getRemovedSet()) {
            RowKeySet keys = selectionEvent.getAddedSet();
            if (keys != null && keys.getSize() > 0) {
                for (Object treeRowKey : keys) {
                    treatyProductTree.setRowKey(treeRowKey);
                    JUCtrlHierNodeBinding nd =
                        (JUCtrlHierNodeBinding)treatyProductTree.getRowData();

                    session.setAttribute("trpd_code",
                                         nd.getRow().getAttribute("TPRD_CODE"));
                    System.out.println("trpd_code" +
                                       nd.getRow().getAttribute("TPRD_CODE"));
                    session.setAttribute("ProductCode",
                                         nd.getRow().getAttribute("TPRD_PROD_CODE"));
                    productLabel.setValue(nd.getRow().getAttribute("PRODUCT_DISPLAY"));
                    defaultTreatyProd.setValue(nd.getRow().getAttribute("TRPD_DEFAULT_TRTY"));

                    ADFUtils.findIterator("findTreatyProdCoverTypesIterator").executeQuery();
                    AdfFacesContext.getCurrentInstance().addPartialTarget(treatyProdCoverTypesLOV);

                }
            }
        }
    }

    public void setTreatyProductTree(RichTree treatyProductTree) {
        this.treatyProductTree = treatyProductTree;
    }

    public RichTree getTreatyProductTree() {
        return treatyProductTree;
    }

    public void setProductLabel(RichOutputText productLabel) {
        this.productLabel = productLabel;
    }

    public RichOutputText getProductLabel() {
        return productLabel;
    }

    public void productListener1(SelectionEvent selectionEvent) {
        // Add event code here...
        // Add event code here...
        if (selectionEvent.getAddedSet() != selectionEvent.getRemovedSet()) {
            RowKeySet keys = selectionEvent.getAddedSet();
            if (keys != null && keys.getSize() > 0) {
                for (Object treeRowKey : keys) {
                    productTree.setRowKey(treeRowKey);
                    JUCtrlHierNodeBinding nd =
                        (JUCtrlHierNodeBinding)productTree.getRowData();

                    session.setAttribute("ProductCode",
                                         nd.getRow().getAttribute("PROD_CODE"));
                    session.setAttribute("pctCode", null);
                    ADFUtils.findIterator("findProdCoverTypesIterator").executeQuery();
                    AdfFacesContext.getCurrentInstance().addPartialTarget(coverTypesLOV);
                    coverTypeDesc.setValue(null);

                    ADFUtils.findIterator("findProdCoverProvisionsIterator").executeQuery();
                    AdfFacesContext.getCurrentInstance().addPartialTarget(prodProvisions);

                    ADFUtils.findIterator("findProvisionsIterator").executeQuery();
                    AdfFacesContext.getCurrentInstance().addPartialTarget(provisionsLOV);

                    ADFUtils.findIterator("findProductProvisionsIterator").executeQuery();
                    AdfFacesContext.getCurrentInstance().addPartialTarget(productProvisionLOV);


                }
            }
        }
    }

    public void setProdProvisions(RichTable prodProvisions) {
        this.prodProvisions = prodProvisions;
    }

    public RichTable getProdProvisions() {
        return prodProvisions;
    }

    public String findProductCoverTypes() {

        DCIteratorBinding dciter =
            ADFUtils.findIterator("findProdCoverTypesIterator");
        RowKeySet set = coverTypesLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            session.setAttribute("pctCode", r.getAttribute("PCT_CODE"));
            coverTypeDesc.setValue(r.getAttribute("PCT_CVT_DESC"));

            ADFUtils.findIterator("findProvisionsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(provisionsLOV);

            ADFUtils.findIterator("findProdCoverProvisionsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(prodProvisions);

        }
        return null;
    }

    public String EditProvisionSelected() {
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findProdCoverProvisionsIterator");
            RowKeySet set = prodProvisions.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            //System.out.println(1);
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                session.setAttribute("provCode",
                                     r.getAttribute("PCPR_PROV_CODE"));
                session.setAttribute("pcprCode", r.getAttribute("PCPR_CODE"));
                session.setAttribute("action", "E");

                provDesc.setValue(r.getAttribute("PROV_DESC"));
                provAllow.setValue(r.getAttribute("PCPR_DEFAULT"));
                provDefault.setValue(r.getAttribute("PCPR_EDIT_ALLOW"));

                //Render Popup
                ExtendedRenderKitService erkService =
                    Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                       ExtendedRenderKitService.class);
                erkService.addScript(FacesContext.getCurrentInstance(),
                                     "var hints = {autodismissNever:false}; " +
                                     "AdfPage.PAGE.findComponent('" +
                                     "lmsgroup:p3" + "').show(hints);");

            }
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String DeleteProvisionSelected() {
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findProdCoverProvisionsIterator");
            RowKeySet set = prodProvisions.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            //System.out.println(1);
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                session.setAttribute("provCode",
                                     r.getAttribute("PCPR_PROV_CODE"));
                session.setAttribute("pcprCode", r.getAttribute("PCPR_CODE"));
                session.setAttribute("action", "D");

                SaveProductProvision();

            }
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String findProvisionSelected() {

        DCIteratorBinding dciter =
            ADFUtils.findIterator("findProvisionsIterator");
        RowKeySet set = provisionsLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            session.setAttribute("provCode", r.getAttribute("PROV_CODE"));
            provDesc.setValue(r.getAttribute("PROV_DESC"));
            session.setAttribute("action", "A");

            //Render Popup
            ExtendedRenderKitService erkService =
                Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                   ExtendedRenderKitService.class);
            erkService.addScript(FacesContext.getCurrentInstance(),
                                 "var hints = {autodismissNever:false}; " +
                                 "AdfPage.PAGE.findComponent('" +
                                 "lmsgroup:p3" + "').show(hints);");

        }
        return null;
    }

    public String findProvisionSelected1() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findProvisionsIterator");
        RowKeySet set = provisionsLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            session.setAttribute("provCode", r.getAttribute("PROV_CODE"));
            provisionDescTF.setValue(r.getAttribute("PROV_DESC"));
            GlobalCC.showPopup("lmsgroup:p6");

        }
        return null;
    }

    public String SaveProductProvision() {
        Connection conn = null;
        String addQuery =
            "BEGIN LMS_SETUPS_PKG.save_prod_cvr_provisions(?,?,?,?,?,?);END;";
        try {
            conn = new DBConnector().getDatabaseConn();

            CallableStatement cstmt = conn.prepareCall(addQuery);
            cstmt.setString(1, (String)session.getAttribute("action"));
            cstmt.setBigDecimal(2,
                                (BigDecimal)session.getAttribute("pcprCode"));
            cstmt.setBigDecimal(3,
                                (BigDecimal)session.getAttribute("provCode"));
            cstmt.setBigDecimal(4,
                                (BigDecimal)session.getAttribute("pctCode"));
            if (provDefault.getValue() == null) {
                cstmt.setString(5, null);
            } else {
                cstmt.setString(5, provDefault.getValue().toString());
            }
            if (provAllow.getValue() == null) {
                cstmt.setString(6, null);
            } else {
                cstmt.setString(6, provAllow.getValue().toString());
            }
            cstmt.execute();

            ADFUtils.findIterator("findProdCoverProvisionsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(prodProvisions);
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public String AddProvision() {
        try {
            nprovShtDesc.setValue(null);
            nprovDesc.setValue(null);
            nprovType.setValue(null);
            nprovClause.setValue(null);
            session.setAttribute("action", "A");
            session.setAttribute("nprovCode", null);

            //Render Popup
            ExtendedRenderKitService erkService =
                Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                   ExtendedRenderKitService.class);
            erkService.addScript(FacesContext.getCurrentInstance(),
                                 "var hints = {autodismissNever:false}; " +
                                 "AdfPage.PAGE.findComponent('" +
                                 "lmsgroup:p4" + "').show(hints);");


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String EditProvision() {
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findProvisionsIterator");
            RowKeySet set = allProvisionsLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            //System.out.println(1);
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                session.setAttribute("nprovCode", r.getAttribute("PROV_CODE"));
                provDesc.setValue(r.getAttribute("PROV_DESC"));
                nprovShtDesc.setValue(r.getAttribute("PROV_SHT_DESC"));
                nprovDesc.setValue(r.getAttribute("PROV_DESC"));
                nprovType.setValue(r.getAttribute("PROV_TYPE"));
                nprovClause.setValue(r.getAttribute("PROV_HIV_CLAUSE"));
                session.setAttribute("action", "E");

                //Render Popup
                ExtendedRenderKitService erkService =
                    Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                       ExtendedRenderKitService.class);
                erkService.addScript(FacesContext.getCurrentInstance(),
                                     "var hints = {autodismissNever:false}; " +
                                     "AdfPage.PAGE.findComponent('" +
                                     "lmsgroup:p4" + "').show(hints);");

            }
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String DeleteProvision() {
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findProvisionsIterator");
            RowKeySet set = allProvisionsLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            //System.out.println(1);
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                session.setAttribute("nprovCode", r.getAttribute("PROV_CODE"));

                session.setAttribute("action", "D");
                SaveProvision();

            }
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String SaveProvision() {
        Connection conn = null;
        String addQuery =
            "BEGIN LMS_SETUPS_PKG.save_provisions(?,?,?,?,?,?);END;";
        try {
            conn = new DBConnector().getDatabaseConn();

            CallableStatement cstmt = conn.prepareCall(addQuery);
            cstmt.setString(1, (String)session.getAttribute("action"));
            cstmt.setBigDecimal(2,
                                (BigDecimal)session.getAttribute("nprovCode"));
            if (nprovShtDesc.getValue() == null) {
                cstmt.setString(3, null);
            } else {
                cstmt.setString(3, nprovShtDesc.getValue().toString());
            }
            if (nprovDesc.getValue() == null) {
                cstmt.setString(4, null);
            } else {
                cstmt.setString(4, nprovDesc.getValue().toString());
            }
            if (nprovType.getValue() == null) {
                cstmt.setString(5, null);
            } else {
                cstmt.setString(5, nprovType.getValue().toString());
            }
            if (nprovClause.getValue() == null) {
                cstmt.setString(6, null);
            } else {
                cstmt.setString(6, nprovClause.getValue().toString());
            }
            cstmt.execute();
            session.setAttribute("nprovCode", null);
            ADFUtils.findIterator("findProvisionsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(allProvisionsLOV);
            AdfFacesContext.getCurrentInstance().addPartialTarget(provisionsLOV);
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public void setProvisionsLOV(RichTable provisionsLOV) {
        this.provisionsLOV = provisionsLOV;
    }

    public RichTable getProvisionsLOV() {
        return provisionsLOV;
    }

    public void setProvDefault(RichSelectOneChoice provDefault) {
        this.provDefault = provDefault;
    }

    public RichSelectOneChoice getProvDefault() {
        return provDefault;
    }

    public void setProvAllow(RichSelectOneChoice provAllow) {
        this.provAllow = provAllow;
    }

    public RichSelectOneChoice getProvAllow() {
        return provAllow;
    }

    public void setProvDesc(RichInputText provDesc) {
        this.provDesc = provDesc;
    }

    public RichInputText getProvDesc() {
        return provDesc;
    }

    public void setNprovShtDesc(RichInputText nprovShtDesc) {
        this.nprovShtDesc = nprovShtDesc;
    }

    public RichInputText getNprovShtDesc() {
        return nprovShtDesc;
    }

    public void setNprovDesc(RichInputText nprovDesc) {
        this.nprovDesc = nprovDesc;
    }

    public RichInputText getNprovDesc() {
        return nprovDesc;
    }

    public void setNprovType(RichSelectOneChoice nprovType) {
        this.nprovType = nprovType;
    }

    public RichSelectOneChoice getNprovType() {
        return nprovType;
    }

    public void setNprovClause(RichSelectOneChoice nprovClause) {
        this.nprovClause = nprovClause;
    }

    public RichSelectOneChoice getNprovClause() {
        return nprovClause;
    }

    public void setAllProvisionsLOV(RichTable allProvisionsLOV) {
        this.allProvisionsLOV = allProvisionsLOV;
    }

    public RichTable getAllProvisionsLOV() {
        return allProvisionsLOV;
    }

    public void setGlAccountsLOV(RichTable glAccountsLOV) {
        this.glAccountsLOV = glAccountsLOV;
    }

    public RichTable getGlAccountsLOV() {
        return glAccountsLOV;
    }

    public void setFclType(RichSelectOneChoice fclType) {
        this.fclType = fclType;
    }

    public RichSelectOneChoice getFclType() {
        return fclType;
    }

    public void setPrdEarningsType(RichSelectOneChoice prdEarningsType) {
        this.prdEarningsType = prdEarningsType;
    }

    public RichSelectOneChoice getPrdEarningsType() {
        return prdEarningsType;
    }

    public void setTreatyProductDesc(RichInputText treatyProductDesc) {
        this.treatyProductDesc = treatyProductDesc;
    }

    public RichInputText getTreatyProductDesc() {
        return treatyProductDesc;
    }

    public void setArrangementDesc(RichInputText arrangementDesc) {
        this.arrangementDesc = arrangementDesc;
    }

    public RichInputText getArrangementDesc() {
        return arrangementDesc;
    }

    public void setSaDependLimit(RichSelectOneChoice saDependLimit) {
        this.saDependLimit = saDependLimit;
    }

    public RichSelectOneChoice getSaDependLimit() {
        return saDependLimit;
    }

    public void setPayBen(RichSelectOneChoice payBen) {
        this.payBen = payBen;
    }

    public RichSelectOneChoice getPayBen() {
        return payBen;
    }

    public void setPensType(RichSelectOneChoice pensType) {
        this.pensType = pensType;
    }

    public RichSelectOneChoice getPensType() {
        return pensType;
    }

    public void setPensionMode(RichSelectOneChoice pensionMode) {
        this.pensionMode = pensionMode;
    }

    public RichSelectOneChoice getPensionMode() {
        return pensionMode;
    }

    public void setPensContriLimit(RichInputText pensContriLimit) {
        this.pensContriLimit = pensContriLimit;
    }

    public RichInputText getPensContriLimit() {
        return pensContriLimit;
    }

    public void setLoanGuard(RichSelectOneChoice loanGuard) {
        this.loanGuard = loanGuard;
    }

    public RichSelectOneChoice getLoanGuard() {
        return loanGuard;
    }

    public void productTypeListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if (valueChangeEvent.getOldValue() != valueChangeEvent.getNewValue()) {
            if (prodType.getValue() == null) {
                session.setAttribute("productType", null);
            } else {
                session.setAttribute("productType",
                                     prodType.getValue().toString());
            }

        }
    }

    public void setQuoteExpiryPeriod(RichInputText quoteExpiryPeriod) {
        this.quoteExpiryPeriod = quoteExpiryPeriod;
    }

    public RichInputText getQuoteExpiryPeriod() {
        return this.quoteExpiryPeriod;
    }

    public void setReceiptingMode(RichSelectOneChoice receiptingMode) {
        this.receiptingMode = receiptingMode;
    }

    public RichSelectOneChoice getReceiptingMode() {
        return receiptingMode;
    }

    public void setCloneYear(RichOutputText cloneYear) {
        this.cloneYear = cloneYear;
    }

    public RichOutputText getCloneYear() {
        return cloneYear;
    }

    public void setNewYear(RichInputText newYear) {
        this.newYear = newYear;
    }

    public RichInputText getNewYear() {
        return newYear;
    }

    public void setConfirmPanel(HtmlPanelGrid confirmPanel) {
        this.confirmPanel = confirmPanel;
    }

    public HtmlPanelGrid getConfirmPanel() {
        return confirmPanel;
    }

    public void setClonePanel(HtmlPanelGrid clonePanel) {
        this.clonePanel = clonePanel;
    }

    public HtmlPanelGrid getClonePanel() {
        return clonePanel;
    }

    public void setCloneProduct(RichOutputText cloneProduct) {
        this.cloneProduct = cloneProduct;
    }

    public RichOutputText getCloneProduct() {
        return cloneProduct;
    }

    public void setNewProdID(RichInputText newProdID) {
        this.newProdID = newProdID;
    }

    public RichInputText getNewProdID() {
        return newProdID;
    }

    public void setNewProdDesc(RichInputText newProdDesc) {
        this.newProdDesc = newProdDesc;
    }

    public RichInputText getNewProdDesc() {
        return newProdDesc;
    }

    public void setNewProdType(RichSelectOneChoice newProdType) {
        this.newProdType = newProdType;
    }

    public RichSelectOneChoice getNewProdType() {
        return newProdType;
    }

    public void setNewPolProdPrefix(RichInputText newPolProdPrefix) {
        this.newPolProdPrefix = newPolProdPrefix;
    }

    public RichInputText getNewPolProdPrefix() {
        return newPolProdPrefix;
    }

    public void setNewPropProdPrefix(RichInputText newPropProdPrefix) {
        this.newPropProdPrefix = newPropProdPrefix;
    }

    public RichInputText getNewPropProdPrefix() {
        return newPropProdPrefix;
    }

    public void setNewClaimProdPrefix(RichInputText newClaimProdPrefix) {
        this.newClaimProdPrefix = newClaimProdPrefix;
    }

    public RichInputText getNewClaimProdPrefix() {
        return newClaimProdPrefix;
    }

    public void setChkProdCovers(RichSelectBooleanCheckbox chkProdCovers) {
        this.chkProdCovers = chkProdCovers;
    }

    public RichSelectBooleanCheckbox getChkProdCovers() {
        return chkProdCovers;
    }

    public void setChkProdCoverDeps(RichSelectBooleanCheckbox chkProdCoverDeps) {
        this.chkProdCoverDeps = chkProdCoverDeps;
    }

    public RichSelectBooleanCheckbox getChkProdCoverDeps() {
        return chkProdCoverDeps;
    }

    public void setCoverMainPercLbl(RichOutputLabel coverMainPercLbl) {
        this.coverMainPercLbl = coverMainPercLbl;
    }

    public RichOutputLabel getCoverMainPercLbl() {
        return coverMainPercLbl;
    }

    public void setFclSAFormula(RichSelectOneChoice fclSAFormula) {
        this.fclSAFormula = fclSAFormula;
    }

    public RichSelectOneChoice getFclSAFormula() {
        return fclSAFormula;
    }

    public String saveExperienceSettings() {
        String saveQuery =
            "BEGIN LMS_SETUPS_PKG.updateProductExperienceDetails(?,?,?);END;";
        if (exp_period.getValue() == null) {
            String Message = "Specify the experience period";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
        }
        if (expTLR.getValue() == null) {
            String Message = "Specify the experience Target Loss Ratio";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
        }
        Connection conn = null;
        try {
            BigDecimal expPeriod =
                new BigDecimal(exp_period.getValue().toString());
            BigDecimal experienceTLR =
                new BigDecimal(expTLR.getValue().toString());
            conn = new DBConnector().getDatabaseConn();
            CallableStatement cstmt = conn.prepareCall(saveQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("PRODCode"));
            cstmt.setBigDecimal(2, expPeriod);
            cstmt.setBigDecimal(3, experienceTLR);
            cstmt.execute();
            cstmt.close();
            String Message = "Product Experience Rate Settings";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
            ADFUtils.findIterator("findGroupProductsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(productTree);
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
            ex.printStackTrace();
        }
        return null;
    }

    public void setExp_period(RichInputText exp_period) {
        this.exp_period = exp_period;
    }

    public RichInputText getExp_period() {
        return exp_period;
    }

    public void setExpTLR(RichInputText expTLR) {
        this.expTLR = expTLR;
    }

    public RichInputText getExpTLR() {
        return expTLR;
    }

    public void setThirteenthMonth(RichSelectOneChoice thirteenthMonth) {
        this.thirteenthMonth = thirteenthMonth;
    }

    public RichSelectOneChoice getThirteenthMonth() {
        return thirteenthMonth;
    }

    public void setLoadAvgAge(RichSelectOneChoice loadAvgAge) {
        this.loadAvgAge = loadAvgAge;
    }

    public RichSelectOneChoice getLoadAvgAge() {
        return loadAvgAge;
    }

    public void setRateTypeCombo(RichSelectOneChoice rateTypeCombo) {
        this.rateTypeCombo = rateTypeCombo;
    }

    public RichSelectOneChoice getRateTypeCombo() {
        return rateTypeCombo;
    }

    public RichInputText getQuoteExpiryPeriod1() {
        return quoteExpiryPeriod;
    }

    public void setErrorMarginTF(RichInputText errorMarginTF) {
        this.errorMarginTF = errorMarginTF;
    }

    public RichInputText getErrorMarginTF() {
        return errorMarginTF;
    }

    public void setProfitMarginTF(RichInputText profitMarginTF) {
        this.profitMarginTF = profitMarginTF;
    }

    public RichInputText getProfitMarginTF() {
        return profitMarginTF;
    }

    public void setMngtExpenseTF(RichInputText mngtExpenseTF) {
        this.mngtExpenseTF = mngtExpenseTF;
    }

    public RichInputText getMngtExpenseTF() {
        return mngtExpenseTF;
    }

    public void setPhcfTF(RichInputText phcfTF) {
        this.phcfTF = phcfTF;
    }

    public RichInputText getPhcfTF() {
        return phcfTF;
    }

    public void setAdrRateTF(RichInputText adrRateTF) {
        this.adrRateTF = adrRateTF;
    }

    public RichInputText getAdrRateTF() {
        return adrRateTF;
    }

    public void setAdrRateDivFactor(RichInputText adrRateDivFactor) {
        this.adrRateDivFactor = adrRateDivFactor;
    }

    public RichInputText getAdrRateDivFactor() {
        return adrRateDivFactor;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public HttpSession getSession() {
        return session;
    }

    public void setMedicalCost(RichInputText medicalCost) {
        this.medicalCost = medicalCost;
    }

    public RichInputText getMedicalCost() {
        return medicalCost;
    }

    public void setStampDuty(RichInputText stampDuty) {
        this.stampDuty = stampDuty;
    }

    public RichInputText getStampDuty() {
        return stampDuty;
    }

    public void setPureCommRate(RichInputText pureCommRate) {
        this.pureCommRate = pureCommRate;
    }

    public RichInputText getPureCommRate() {
        return pureCommRate;
    }

    public void setMaxInstPayable(RichInputText maxInstPayable) {
        this.maxInstPayable = maxInstPayable;
    }

    public RichInputText getMaxInstPayable() {
        return maxInstPayable;
    }

    public void setWaitingPrd(RichInputText waitingPrd) {
        this.waitingPrd = waitingPrd;
    }

    public RichInputText getWaitingPrd() {
        return waitingPrd;
    }

    public void setRetireAge(RichInputText retireAge) {
        this.retireAge = retireAge;
    }

    public RichInputText getRetireAge() {
        return retireAge;
    }

    public void setRateTypeCB(RichSelectOneChoice rateTypeCB) {
        this.rateTypeCB = rateTypeCB;
    }

    public RichSelectOneChoice getRateTypeCB() {
        return rateTypeCB;
    }

    public void setProdLoadingNameTF(RichInputText prodLoadingNameTF) {
        this.prodLoadingNameTF = prodLoadingNameTF;
    }

    public RichInputText getProdLoadingNameTF() {
        return prodLoadingNameTF;
    }

    public void setLoadingRateTF(RichInputText loadingRateTF) {
        this.loadingRateTF = loadingRateTF;
    }

    public RichInputText getLoadingRateTF() {
        return loadingRateTF;
    }

    public void setLoadingRateDivFactTF(RichInputText loadingRateDivFactTF) {
        this.loadingRateDivFactTF = loadingRateDivFactTF;
    }

    public RichInputText getLoadingRateDivFactTF() {
        return loadingRateDivFactTF;
    }

    public String updateProdLoading() {
        // Add event code here...
        Connection conn = null;
        String addQuery =
            "BEGIN LMS_SETUPS_PKG.saveProductCoverLoadings(?,?,?,?,?,?,?);END;";
        try {
            conn = new DBConnector().getDatabaseConn();
            if (prodLoadingNameTF.getValue() == null) {
                GlobalCC.INFORMATIONREPORTING("Loading Name cannot be null");
            }

            CallableStatement cstmt = conn.prepareCall(addQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("pctl_code"));
            cstmt.setString(2, (String)prodLoadingNameTF.getValue());
            cstmt.setString(3, (String)rateTypeCB.getValue());
            cstmt.setString(4, (String)loadingRateTF.getValue());
            cstmt.setString(5, (String)loadingRateDivFactTF.getValue());
            cstmt.setBigDecimal(6,
                                (BigDecimal)session.getAttribute("pct_code"));
            cstmt.setString(7, (String)rateTypeSelect.getValue());


            cstmt.execute();
            ADFUtils.findIterator("FindProductCoverLoadingsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(prodCoverLoadingLOV);
            conn.close();
            GlobalCC.INFORMATIONREPORTING("Product loadings saved successfully");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public void productCoverListener(SelectionEvent selectionEvent) {
        // Add event code here...
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findProdCoverTypesIterator");
            RowKeySet set = productCoverTypesLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            //System.out.println(1);
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();
                session.setAttribute("pct_code", r.getAttribute("PCT_CODE"));
                ADFUtils.findIterator("FindProductCoverLoadingsIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(prodCoverLoadingLOV);
            }
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
    }

    public void setProdCoverLoadingLOV(RichTable prodCoverLoadingLOV) {
        this.prodCoverLoadingLOV = prodCoverLoadingLOV;
    }

    public RichTable getProdCoverLoadingLOV() {
        return prodCoverLoadingLOV;
    }

    public String editProdCoverLoading() {
        // Add event code here...
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("FindProductCoverLoadingsIterator");
            RowKeySet set = prodCoverLoadingLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            //System.out.println(1);
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();
                session.setAttribute("pctl_code", r.getAttribute("pctl_code"));
                prodLoadingNameTF.setValue(r.getAttribute("pctl_name"));
                rateTypeCB.setValue(r.getAttribute("pctl_rate_type"));
                loadingRateTF.setValue(r.getAttribute("pctl_rate"));
                loadingRateDivFactTF.setValue(r.getAttribute("pctl_rate_div_factor"));
                GlobalCC.showPopup("lmsgroup:p1");
            }
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String deleteProdCvrLoadings() {
        // Add event code here...
        Connection conn = null;
        String addQuery =
            "BEGIN LMS_SETUPS_PKG.deleteProductCoverLoadings(?);END;";
        try {
            conn = new DBConnector().getDatabaseConn();

            CallableStatement cstmt = conn.prepareCall(addQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("pctl_code"));

            cstmt.execute();
            ADFUtils.findIterator("FindProductCoverLoadingsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(prodCoverLoadingLOV);
            conn.close();
            GlobalCC.INFORMATIONREPORTING("Product loadings deleted successfully");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public String addProdCoverLoading() {
        // Add event code here...
        session.setAttribute("pctl_code", null);
        prodLoadingNameTF.setValue(null);
        rateTypeCB.setValue(null);
        loadingRateTF.setValue(null);
        loadingRateDivFactTF.setValue(null);
        GlobalCC.showPopup("lmsgroup:p1");
        return null;
    }

    public void setFixedSA(RichSelectOneChoice fixedSA) {
        this.fixedSA = fixedSA;
    }

    public RichSelectOneChoice getFixedSA() {
        return fixedSA;
    }

    public void setFixed_sa_amt(RichInputText fixed_sa_amt) {
        this.fixed_sa_amt = fixed_sa_amt;
    }

    public RichInputText getFixed_sa_amt() {
        return fixed_sa_amt;
    }

    public void fixedSaListener(ValueChangeEvent valueChangeEvent) {
        if (valueChangeEvent.getNewValue() != valueChangeEvent.getOldValue()) {
            if (fixedSA.getValue() != null) {
                if (fixedSA.getValue().equals("Y")) {
                    fixed_sa_amt.setRendered(true);

                } else {
                    fixed_sa_amt.setRendered(false);

                }
            }
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(fixed_sa_amt);
        // Add event code here...
    }

    public void setGetLoadingDetails(RichColumn getLoadingDetails) {
        this.getLoadingDetails = getLoadingDetails;
    }

    public RichColumn getGetLoadingDetails() {
        return getLoadingDetails;
    }

    public void setGetLoadingDetailsBut(RichCommandButton getLoadingDetailsBut) {
        this.getLoadingDetailsBut = getLoadingDetailsBut;
    }

    public RichCommandButton getGetLoadingDetailsBut() {
        return getLoadingDetailsBut;
    }

    public void setLoadingLOV(RichTable loadingLOV) {
        this.loadingLOV = loadingLOV;
    }

    public RichTable getLoadingLOV() {
        return loadingLOV;
    }

    public void setLoadingName(RichInputText loadingName) {
        this.loadingName = loadingName;
    }

    public RichInputText getLoadingName() {
        return loadingName;
    }

    public void setLoadingsLOV(RichTable loadingsLOV) {
        this.loadingsLOV = loadingsLOV;
    }

    public RichTable getLoadingsLOV() {
        return loadingsLOV;
    }

    public void getOccupationCode(SelectionEvent selectionEvent) {

        // Add event code here...
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findGroupOccupationsIterator");
            RowKeySet set = occupationsLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            //System.out.println(1);
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();
                session.setAttribute("gcoCode", r.getAttribute("LC_CODE"));
                ADFUtils.findIterator("findGroupOccupationsCategoriesIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(occupationCategoryLOV);
            }
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
    }

    public String addSetupCategories() {
        // Add event code here...
        Connection conn = null;
        String addQuery =
            "BEGIN LMS_SETUPS_PKG.createOccupationCategory(?,?,?,?);END;";
        try {
            conn = new DBConnector().getDatabaseConn();
            if (categoryTF.getValue() == null) {
                GlobalCC.INFORMATIONREPORTING("Please set Category");
            }
            if (classTF.getValue() == null) {
                GlobalCC.INFORMATIONREPORTING("Please set Class");
            }

            CallableStatement cstmt = conn.prepareCall(addQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("gocCode"));
            cstmt.setBigDecimal(2,
                                (BigDecimal)session.getAttribute("gcoCode"));
            cstmt.setString(3, (String)categoryTF.getValue());
            cstmt.setString(4, (String)classTF.getValue());
            cstmt.execute();
            ADFUtils.findIterator("findGroupOccupationsCategoriesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(occupationCategoryLOV);
            conn.close();
            GlobalCC.INFORMATIONREPORTING("Occupation Category saved successfully");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }

        return null;
    }

    public void setCategoryTF(RichInputText categoryTF) {
        this.categoryTF = categoryTF;
    }

    public RichInputText getCategoryTF() {
        return categoryTF;
    }

    public void setClassTF(RichInputText classTF) {
        this.classTF = classTF;
    }

    public RichInputText getClassTF() {
        return classTF;
    }

    public void setOccupationCategory(RichTable occupationCategory) {
        this.occupationCategory = occupationCategory;
    }

    public RichTable getOccupationCategory() {
        return occupationCategory;
    }

    public void setOccupationCategoryLOV(RichTable occupationCategoryLOV) {
        this.occupationCategoryLOV = occupationCategoryLOV;
    }

    public RichTable getOccupationCategoryLOV() {
        return occupationCategoryLOV;
    }

    public String editOccupationCat() {
        // Add event code here...
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findGroupOccupationsCategoriesIterator");
            RowKeySet set = occupationCategoryLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            //System.out.println(1);
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();
                session.setAttribute("gocCode", r.getAttribute("GOC_CODE"));
                categoryTF.setValue(r.getAttribute("GOC_CATEGORY"));
                classTF.setValue(r.getAttribute("GOC_CLASS"));
                GlobalCC.showPopup("lmsgroup:p1");
            }
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }


    public String addOccupationCat() {
        // Add event code here...
        session.setAttribute("gocCode", null);
        categoryTF.setValue(null);
        classTF.setValue(null);
        GlobalCC.showPopup("lmsgroup:p1");
        return null;
    }

    public String deleteOccupationCat() {
        // Add event code here...
        Connection conn = null;
        String addQuery =
            "BEGIN LMS_SETUPS_PKG.deleteOccupationCategory(?);END;";
        try {
            conn = new DBConnector().getDatabaseConn();


            CallableStatement cstmt = conn.prepareCall(addQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("gocCode"));

            cstmt.execute();
            ADFUtils.findIterator("findGroupOccupationsCategoriesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(occupationCategoryLOV);
            conn.close();
            GlobalCC.INFORMATIONREPORTING("Occupation Category saved successfully");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public void rateTypeChangeListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if (valueChangeEvent.getOldValue() != valueChangeEvent.getNewValue()) {
            if (rateTypeSelect.getValue() != null) {

                if (rateTypeSelect.getValue().toString().compareTo("T") == 0) {
                    loadingRateTF.setDisabled(true);
                    loadingRateDivFactTF.setDisabled(true);
                } else {
                    loadingRateTF.setDisabled(false);
                    loadingRateDivFactTF.setDisabled(false);
                }

                AdfFacesContext.getCurrentInstance().addPartialTarget(loadingRateTF);
                AdfFacesContext.getCurrentInstance().addPartialTarget(loadingRateDivFactTF);

            }

        }
    }

    public void setRateTypeSelect(RichSelectOneChoice rateTypeSelect) {
        this.rateTypeSelect = rateTypeSelect;
    }

    public RichSelectOneChoice getRateTypeSelect() {
        return rateTypeSelect;
    }

    public void setProvisionCode(SelectionEvent selectionEvent) {
        // Add event code here...
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findProvisionsIterator");
            RowKeySet set = allProvisionsLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            //System.out.println(1);
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                session.setAttribute("nprovCode", r.getAttribute("PROV_CODE"));
                ADFUtils.findIterator("findProvisionsLimitIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(provisionLimitsLOV);

            }
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

    }

    public String addProvLimit() {
        // Add event code here...
        session.setAttribute("action", "A");
        limYrFrom.setValue(null);
        limYrTo.setValue(null);
        limPercPayable.setValue(null);
        GlobalCC.showPopup("lmsgroup:p5");
        return null;
    }

    public void setLimYrFrom(RichInputText limYrFrom) {
        this.limYrFrom = limYrFrom;
    }

    public RichInputText getLimYrFrom() {
        return limYrFrom;
    }

    public void setLimYrTo(RichInputText limYrTo) {
        this.limYrTo = limYrTo;
    }

    public RichInputText getLimYrTo() {
        return limYrTo;
    }

    public void setLimPercPayable(RichInputText limPercPayable) {
        this.limPercPayable = limPercPayable;
    }

    public RichInputText getLimPercPayable() {
        return limPercPayable;
    }

    public String add_edit_prov_limits() {
        // Add event code here...
        Connection conn = null;
        String addQuery =
            "BEGIN LMS_SETUPS_PKG.save_provision_limits(?,?,?,?,?,?,?);END;";
        try {
            conn = new DBConnector().getDatabaseConn();
            if (limYrFrom.getValue() == null) {
                GlobalCC.INFORMATIONREPORTING("Please set Year From");
            }
            if (limYrTo.getValue() == null) {
                GlobalCC.INFORMATIONREPORTING("Please set Year To");
            }
            if (limPercPayable.getValue() == null) {
                GlobalCC.INFORMATIONREPORTING("Please set Percentage Payable");
            }
            if (limWaitingPeriod.getValue() == null) {
                GlobalCC.INFORMATIONREPORTING("Please set Waiting Period");
            }

            CallableStatement cstmt = conn.prepareCall(addQuery);
            cstmt.setString(1, (String)session.getAttribute("action"));
            cstmt.setBigDecimal(2,
                                (BigDecimal)session.getAttribute("provlCode"));
            cstmt.setBigDecimal(3,
                                (BigDecimal)session.getAttribute("nprovCode"));
            cstmt.setString(4, (String)limYrFrom.getValue());
            cstmt.setString(5, (String)limYrTo.getValue());
            cstmt.setString(6, (String)limPercPayable.getValue());
            cstmt.setString(7, (String)limWaitingPeriod.getValue());
            cstmt.execute();
            conn.close();
            ADFUtils.findIterator("findProvisionsLimitIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(provisionLimitsLOV);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public void setLimWaitingPeriod(RichInputText limWaitingPeriod) {
        this.limWaitingPeriod = limWaitingPeriod;
    }

    public RichInputText getLimWaitingPeriod() {
        return limWaitingPeriod;
    }

    public void setProvisionLimitsLOV(RichTable provisionLimitsLOV) {
        this.provisionLimitsLOV = provisionLimitsLOV;
    }

    public RichTable getProvisionLimitsLOV() {
        return provisionLimitsLOV;
    }

    public String editProvLimit() {
        // Add event code here...
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findProvisionsLimitIterator");
            RowKeySet set = provisionLimitsLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            //System.out.println(1);
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();
                limYrFrom.setValue(r.getAttribute("provl_from"));
                limYrTo.setValue(r.getAttribute("provl_to"));
                limPercPayable.setValue(r.getAttribute("provl_perc_payable"));
                limWaitingPeriod.setValue(r.getAttribute("provl_waiting_prd"));
                session.setAttribute("provlCode",
                                     r.getAttribute("provl_code"));
                session.setAttribute("action", "E");
                AdfFacesContext.getCurrentInstance().addPartialTarget(limYrFrom);
                AdfFacesContext.getCurrentInstance().addPartialTarget(limYrTo);
                AdfFacesContext.getCurrentInstance().addPartialTarget(limPercPayable);
                AdfFacesContext.getCurrentInstance().addPartialTarget(limWaitingPeriod);
                GlobalCC.showPopup("lmsgroup:p5");

            }
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String deleteProvLimit() {
        // Add event code here...
        Connection conn = null;
        String addQuery =
            "BEGIN LMS_SETUPS_PKG.save_provision_limits(?,?,?,?,?,?,?);END;";

        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findProvisionsLimitIterator");
            RowKeySet set = provisionLimitsLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();
            //System.out.println(1);
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();
                session.setAttribute("provlCode",
                                     r.getAttribute("provl_code"));
                session.setAttribute("action", "D");

            }
            conn = new DBConnector().getDatabaseConn();

            CallableStatement cstmt = conn.prepareCall(addQuery);
            cstmt.setString(1, (String)session.getAttribute("action"));
            cstmt.setBigDecimal(2,
                                (BigDecimal)session.getAttribute("provlCode"));
            cstmt.setBigDecimal(3,
                                (BigDecimal)session.getAttribute("nprovCode"));
            cstmt.setString(4, (String)limYrFrom.getValue());
            cstmt.setString(5, (String)limYrTo.getValue());
            cstmt.setString(6, (String)limPercPayable.getValue());
            cstmt.setString(7, (String)limWaitingPeriod.getValue());
            cstmt.execute();
            conn.close();
            ADFUtils.findIterator("findProvisionsLimitIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(provisionLimitsLOV);

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public String getProductProv() {
        // Add event code here...

        return null;
    }

    public void setProvisionDescTF(RichInputText provisionDescTF) {
        this.provisionDescTF = provisionDescTF;
    }

    public RichInputText getProvisionDescTF() {
        return provisionDescTF;
    }

    public void setProvisions1LOV(RichTable provisions1LOV) {
        this.provisions1LOV = provisions1LOV;
    }

    public RichTable getProvisions1LOV() {
        return provisions1LOV;
    }

    public String addProdProvision() {
        // Add event code here...
        Connection conn = null;
        String addQuery =
            "BEGIN LMS_SETUPS_PKG.addProdProvisions(?,?,?,?,?,?,?);END;";

        try {
            conn = new DBConnector().getDatabaseConn();

            CallableStatement cstmt = conn.prepareCall(addQuery);
            cstmt.setString(1, (String)session.getAttribute("action"));
            cstmt.setBigDecimal(2,
                                (BigDecimal)session.getAttribute("pprovCode"));
            cstmt.setBigDecimal(3,
                                (BigDecimal)session.getAttribute("provCode"));
            cstmt.setBigDecimal(4,
                                (BigDecimal)session.getAttribute("ProductCode"));
            cstmt.setString(5, (String)prodProvDefault.getValue());
            cstmt.setString(6, (String)prodProvisionEditable.getValue());
            cstmt.setString(7, (String)prodProvAutoPopulate.getValue());
            cstmt.execute();
            conn.close();
            ADFUtils.findIterator("findProductProvisionsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(productProvisionLOV);

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }

        return null;
    }

    public void setProdProvDefault(RichSelectOneChoice prodProvDefault) {
        this.prodProvDefault = prodProvDefault;
    }

    public RichSelectOneChoice getProdProvDefault() {
        return prodProvDefault;
    }

    public void setProdProvisionEditable(RichSelectOneChoice prodProvisionEditable) {
        this.prodProvisionEditable = prodProvisionEditable;
    }

    public RichSelectOneChoice getProdProvisionEditable() {
        return prodProvisionEditable;
    }

    public void setProdProvAutoPopulate(RichSelectOneChoice prodProvAutoPopulate) {
        this.prodProvAutoPopulate = prodProvAutoPopulate;
    }

    public RichSelectOneChoice getProdProvAutoPopulate() {
        return prodProvAutoPopulate;
    }

    public void setProductProvisionLOV(RichTable productProvisionLOV) {
        this.productProvisionLOV = productProvisionLOV;
    }

    public RichTable getProductProvisionLOV() {
        return productProvisionLOV;
    }

    public String editProductProv() {
        // Add event code here...
        Connection conn = null;
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findProductProvisionsIterator");
            RowKeySet set = productProvisionLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();
            //System.out.println(1);
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();
                prodProvDefault.setValue(r.getAttribute("pprov_default"));
                prodProvisionEditable.setValue(r.getAttribute("pprov_editable"));
                prodProvAutoPopulate.setValue(r.getAttribute("pprov_auto_populate"));
                session.setAttribute("pprovCode",
                                     r.getAttribute("pprov_code"));
                session.setAttribute("action", "E");
                GlobalCC.showPopup("lmsgroup:p6");
            }
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public String addProductProv() {
        // Add event code here...
        prodProvDefault.setValue(null);
        prodProvisionEditable.setValue(null);
        prodProvAutoPopulate.setValue(null);
        session.setAttribute("action", "A");
        GlobalCC.showPopup("lmsgroup:p6");
        return null;
    }

    public String deleteProductProvision() {
        Connection conn = null;
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findProductProvisionsIterator");
            RowKeySet set = productProvisionLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();
            //System.out.println(1);
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();
                prodProvDefault.setValue(r.getAttribute("pprov_default"));
                prodProvisionEditable.setValue(r.getAttribute("pprov_editable"));
                prodProvAutoPopulate.setValue(r.getAttribute("pprov_auto_populate"));
                session.setAttribute("pprovCode",
                                     r.getAttribute("pprov_code"));
                session.setAttribute("action", "D");
                addProdProvision();
            }
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public void setSysUsersLOV(RichTable sysUsersLOV) {
        this.sysUsersLOV = sysUsersLOV;
    }

    public RichTable getSysUsersLOV() {
        return sysUsersLOV;
    }

    public void setEmailReportName(RichInputText emailReportName) {
        this.emailReportName = emailReportName;
    }

    public RichInputText getEmailReportName() {
        return emailReportName;
    }

    public void setEmailReportTemp(RichInputText emailReportTemp) {
        this.emailReportTemp = emailReportTemp;
    }

    public RichInputText getEmailReportTemp() {
        return emailReportTemp;
    }

    public void setEmailReportUser(RichInputText emailReportUser) {
        this.emailReportUser = emailReportUser;
    }

    public RichInputText getEmailReportUser() {
        return emailReportUser;
    }

    public String getSelectedUser() {
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("FindSystemUsersIterator");
            RowKeySet set = sysUsersLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();
            //System.out.println(1);
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();
                session.setAttribute("emailUsr", r.getAttribute("USR_CODE"));
                emailReportUser.setValue(r.getAttribute("USR_NAME"));
                // GlobalCC.showPopup("lmsgroup:p1");
                GlobalCC.hidePopup("lmsgroup:p2");
            }
            AdfFacesContext.getCurrentInstance().addPartialTarget(emailReportUser);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return null;
    }

    public String saveEmailDetails() {
        // Add event code here...
        Connection conn = null;
        if (emailRecepients.getValue() == null) {
            GlobalCC.INFORMATIONREPORTING("Email Recepient Missing");
        }
        String addQuery =
            "BEGIN LMS_WEB_PKG_GRP.addUpdateEmail(?,?,?,?,?,?,?,?);END;";

        try {
            conn = new DBConnector().getDatabaseConn();

            CallableStatement cstmt = conn.prepareCall(addQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("emdCode"));
            cstmt.setBigDecimal(2,
                                (BigDecimal)session.getAttribute("emailUsr"));
            cstmt.setString(3, emailReportTemp.getValue().toString().trim());
            cstmt.setString(4, (String)emailReportName.getValue());
            cstmt.setString(5, (String)emailRecepients.getValue());
            cstmt.setString(6, (String)emailAt.getValue());
            cstmt.setString(7, (String)emailAddressTF.getValue());
            cstmt.setBigDecimal(8,
                                (BigDecimal)session.getAttribute("ProductCode"));
            cstmt.execute();
            conn.close();
            ADFUtils.findIterator("FindEmailDetailsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(emailDetailsLOV);
            GlobalCC.INFORMATIONREPORTING("Details Saved Successfully");

            GlobalCC.hidePopup("lmsgroup:p1");

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public void setEmailDetailsLOV(RichTable emailDetailsLOV) {
        this.emailDetailsLOV = emailDetailsLOV;
    }

    public RichTable getEmailDetailsLOV() {
        return emailDetailsLOV;
    }

    public String deleteEmailDetails() {
        // Add event code here..
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("FindEmailDetailsIterator");
            RowKeySet set = emailDetailsLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();
            //System.out.println(1);
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();
                session.setAttribute("emdCode", r.getAttribute("emd_code"));
            }


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        System.out.println(" Emd Code:" + session.getAttribute("emdCode"));
        deleteSelectedEmailDetails();
        return null;
    }

    public String recepientEmail() {
        // Add event code here...
        session.setAttribute("emdCode", null);
        emailReportName.setValue(null);
        emailReportTemp.setValue(null);
        GlobalCC.showPopup("lmsgroup:p1");
        return null;
    }

    public void deleteSelectedEmailDetails() {
        Connection conn = null;
        String deleteEmails =
            "BEGIN LMS_WEB_PKG_GRP.deleteEmailDetails(?);END;";
        try {
            conn = new DBConnector().getDatabaseConn();

            CallableStatement cstmt = conn.prepareCall(deleteEmails);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("emdCode"));
            cstmt.execute();
            conn.close();
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);

        }
        ADFUtils.findIterator("FindEmailDetailsIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(emailDetailsLOV);
        GlobalCC.INFORMATIONREPORTING("Details Deleted Successfully");
    }

    public String editEmailDetails() {
        // Add event code here...
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("FindEmailDetailsIterator");
            RowKeySet set = emailDetailsLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();
            //System.out.println(1);
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();
                emailReportName.setValue(r.getAttribute("emd_rpt_name"));
                emailReportTemp.setValue(r.getAttribute("emd_msgt_narr"));
                prodDescTF.setValue(r.getAttribute("prodDesc"));
                session.setAttribute("ProductCode",
                                     r.getAttribute("prodCode"));
                session.setAttribute("emdCode", r.getAttribute("emd_code"));
            }
            GlobalCC.showPopup("lmsgroup:p1");

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public void setCratCode(RichInputNumberSpinbox cratCode) {
        this.cratCode = cratCode;
    }

    public RichInputNumberSpinbox getCratCode() {
        return cratCode;
    }

    public void setCratAtCode(RichInputNumberSpinbox cratAtCode) {
        this.cratAtCode = cratAtCode;
    }

    public RichInputNumberSpinbox getCratAtCode() {
        return cratAtCode;
    }

    public void setCratRate(RichInputNumberSpinbox cratRate) {
        this.cratRate = cratRate;
    }

    public RichInputNumberSpinbox getCratRate() {
        return cratRate;
    }

    public void setCratDivFactor(RichInputNumberSpinbox cratDivFactor) {
        this.cratDivFactor = cratDivFactor;
    }

    public RichInputNumberSpinbox getCratDivFactor() {
        return cratDivFactor;
    }

    public void setCratYrNoFrom(RichInputNumberSpinbox cratYrNoFrom) {
        this.cratYrNoFrom = cratYrNoFrom;
    }

    public RichInputNumberSpinbox getCratYrNoFrom() {
        return cratYrNoFrom;
    }

    public void setCratYrNoTo(RichInputNumberSpinbox cratYrNoTo) {
        this.cratYrNoTo = cratYrNoTo;
    }

    public RichInputNumberSpinbox getCratYrNoTo() {
        return cratYrNoTo;
    }

    public void setCratTermFrom(RichInputNumberSpinbox cratTermFrom) {
        this.cratTermFrom = cratTermFrom;
    }

    public RichInputNumberSpinbox getCratTermFrom() {
        return cratTermFrom;
    }

    public void setCratTermTo(RichInputNumberSpinbox cratTermTo) {
        this.cratTermTo = cratTermTo;
    }

    public RichInputNumberSpinbox getCratTermTo() {
        return cratTermTo;
    }

    public void setCratWefDate(RichInputDate cratWefDate) {
        this.cratWefDate = cratWefDate;
    }

    public RichInputDate getCratWefDate() {
        return cratWefDate;
    }

    public void setCratWetDate(RichInputDate cratWetDate) {
        this.cratWetDate = cratWetDate;
    }

    public RichInputDate getCratWetDate() {
        return cratWetDate;
    }

    public void setCratRangeFrom(RichInputNumberSpinbox cratRangeFrom) {
        this.cratRangeFrom = cratRangeFrom;
    }

    public RichInputNumberSpinbox getCratRangeFrom() {
        return cratRangeFrom;
    }

    public void setCratRangeTo(RichInputNumberSpinbox cratRangeTo) {
        this.cratRangeTo = cratRangeTo;
    }

    public RichInputNumberSpinbox getCratRangeTo() {
        return cratRangeTo;
    }

    public void selectedProduct(ValueChangeEvent evt) {
        if (evt.getNewValue() != evt.getOldValue()) {
            if (evt.getNewValue() != null) {
                Row row =
                    ADFUtils.findIterator("findProductsIterator").getRowAtRangeIndex(new Integer(evt.getNewValue().toString()));
                session.setAttribute("ovProdCode",
                                     row.getAttribute("productCode"));
                ovProdCode.setValue(row.getAttribute("productCode"));

                ADFUtils.findIterator("findOverrideCommRatesIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(ovcommRatesTab);
            } else {
                session.setAttribute("ovProdCode", null);
                ovProdCode.setValue(null);

                ADFUtils.findIterator("findOverrideCommRatesIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(ovcommRatesTab);
            }
        }
    }

    public String saveOverrideCommRate() {
        // Add event code here...
        Connection conn = null;
        if (session.getAttribute("actCode") == null) {
            GlobalCC.INFORMATIONREPORTING("Please select an account type");
        }
        if (session.getAttribute("ovProdCode") == null) {
            GlobalCC.INFORMATIONREPORTING("Error Value Missing: You Must Select Product Type");
        }
        if (cratRate.getValue() == null) {
            GlobalCC.INFORMATIONREPORTING("Rate cannot be null");
        }
        if (cratDivFactor.getValue() == null) {
            GlobalCC.INFORMATIONREPORTING("Please Provide the rate division Factor");
        }
        if (cratYrNoFrom.getValue() == null) {
            GlobalCC.INFORMATIONREPORTING("Please Provide Year Number From");
        }
        if (cratYrNoTo.getValue() == null) {
            GlobalCC.INFORMATIONREPORTING("Please Provide Year Number To");
        }
        if (cratTermFrom.getValue() == null) {
            GlobalCC.INFORMATIONREPORTING("Please Provide Term From");
        }
        try {
            conn = new DBConnector().getDatabaseConn();
            String query = null;
            query =
                    "begin LMS_SETUPS_PKG.update_ov_comm_rates(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); end;";

            CallableStatement callStmt = null;
            callStmt = (CallableStatement)conn.prepareCall(query);
            //bind the variables

            callStmt.setBigDecimal(1,
                                   (BigDecimal)session.getAttribute("cratCode"));
            callStmt.setBigDecimal(2,
                                   (BigDecimal)session.getAttribute("actCode"));
            callStmt.setBigDecimal(3, (BigDecimal)cratRate.getValue());
            callStmt.setBigDecimal(4, (BigDecimal)cratDivFactor.getValue());

            callStmt.setString(5,
                               GlobalCC.parseDate(cratWefDate.getValue().toString()));
            if (cratWetDate.getValue() == null) {
                callStmt.setString(6, null);
            } else {
                callStmt.setString(6,
                                   GlobalCC.parseDate(cratWetDate.getValue().toString()));
            }


            callStmt.setBigDecimal(7, (BigDecimal)cratRangeFrom.getValue());
            callStmt.setBigDecimal(8, (BigDecimal)cratRangeTo.getValue());
            callStmt.setBigDecimal(9, (BigDecimal)cratYrNoFrom.getValue());
            callStmt.setBigDecimal(10, (BigDecimal)cratYrNoTo.getValue());
            callStmt.setBigDecimal(11, (BigDecimal)cratTermFrom.getValue());
            callStmt.setBigDecimal(12, (BigDecimal)cratTermTo.getValue());
            callStmt.registerOutParameter(13, OracleTypes.VARCHAR);
            callStmt.setString(14, null);
            String cratProdVal;
            cratProdVal =
                    GlobalCC.checkNullValues(session.getAttribute("ovProdCode"));
            //callStmt.setInt(15, session.getAttribute("ovProdCode"));
            callStmt.setString(15, cratProdVal);
            callStmt.execute();
            String errMessage = null;
            errMessage = callStmt.getString(13);

            callStmt.close();
            conn.commit();
            conn.close();
            GlobalCC.INFORMATIONREPORTING("Override commission saved sucessfully");
            cratCode.setValue(null);
                        cratRate.setValue(null);
                        cratWefDate.setValue(null);
                        cratWetDate.setValue(null);
                        cratAtCode.setValue(null);
                        cratDivFactor.setValue(null);
                        cratRangeFrom.setValue(null);
                        cratRangeTo.setValue(null);
                        cratYrNoFrom.setValue(null);
                        cratYrNoTo.setValue(null);
                        cratTermFrom.setValue(null);
                        cratTermTo.setValue(null);
                        
                        AdfFacesContext.getCurrentInstance().addPartialTarget(cratCode);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(cratRate);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(cratWefDate);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(cratWetDate);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(cratAtCode);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(cratDivFactor);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(cratRangeFrom);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(cratRangeTo);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(cratYrNoFrom);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(cratYrNoTo);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(cratTermFrom);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(cratTermTo);

                        AdfFacesContext.getCurrentInstance().addPartialTarget(commGrid);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(commPnl);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(commPopup);
            ADFUtils.findIterator("findOverrideCommRatesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(ovcommRatesTab);
            GlobalCC.hidePopup("lmsgroup:commRatePopUp");

            if (errMessage != null) {
                GlobalCC.errorValueNotEntered(errMessage);
                return null;
            }
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
            ex.printStackTrace();
        }
        return null;
    }

    public void setAccountsLOV(RichTable accountsLOV) {
        this.accountsLOV = accountsLOV;
    }

    public RichTable getAccountsLOV() {
        return accountsLOV;
    }

    public void accountTypeListener(SelectionEvent selectionEvent) {
        // Add event code here...
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findAccountTypesIterator");
            RowKeySet set = accountsLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();
            //System.out.println(1);
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();
                session.setAttribute("actCode", r.getAttribute("ACT_CODE"));
            }
            ADFUtils.findIterator("findOverrideCommRatesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(ovcommRatesTab);

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
    }

    public String addOvrComm() {
        // Add event code here...
        if (session.getAttribute("actCode") == null) {
            GlobalCC.errorValueNotEntered("Error: Select Account Type");
            return null;
        }
        cratCode.setValue(null);
        //cratAtCode.setValue(session.getAttribute("actCode"));
        session.setAttribute("cratCode", null);
        cratRate.setValue(null);
        cratWefDate.setValue(null);
        cratWetDate.setValue(null);
        cratDivFactor.setValue(null);
        cratRangeFrom.setValue(null);
        cratRangeTo.setValue(null);
        cratYrNoFrom.setValue(null);
        cratYrNoTo.setValue(null);
        cratTermFrom.setValue(null);
        cratTermTo.setValue(null);
        AdfFacesContext.getCurrentInstance().addPartialTarget(cratCode);
        AdfFacesContext.getCurrentInstance().addPartialTarget(cratRate);
        AdfFacesContext.getCurrentInstance().addPartialTarget(cratWefDate);
        AdfFacesContext.getCurrentInstance().addPartialTarget(cratWetDate);
        AdfFacesContext.getCurrentInstance().addPartialTarget(cratAtCode);
        AdfFacesContext.getCurrentInstance().addPartialTarget(cratDivFactor);
        AdfFacesContext.getCurrentInstance().addPartialTarget(cratRangeFrom);
        AdfFacesContext.getCurrentInstance().addPartialTarget(cratRangeTo);
        AdfFacesContext.getCurrentInstance().addPartialTarget(cratYrNoFrom);
        AdfFacesContext.getCurrentInstance().addPartialTarget(cratYrNoTo);
        AdfFacesContext.getCurrentInstance().addPartialTarget(cratTermFrom);
        AdfFacesContext.getCurrentInstance().addPartialTarget(cratTermTo);
        //   AdfFacesContext.getCurrentInstance().addPartialTarget(cratAppliedOn);

        AdfFacesContext.getCurrentInstance().addPartialTarget(commGrid);
        AdfFacesContext.getCurrentInstance().addPartialTarget(commPnl);
        AdfFacesContext.getCurrentInstance().addPartialTarget(commPopup);

        GlobalCC.showPopup("lmsgroup:commRatePopUp");


        return null;
    }

    public void setOvcommRatesTab(RichTable ovcommRatesTab) {
        this.ovcommRatesTab = ovcommRatesTab;
    }

    public RichTable getOvcommRatesTab() {
        return ovcommRatesTab;
    }

    public String editOvrRates() {
        // Add event code here...
        Object key2 = ovcommRatesTab.getSelectedRowData();
        if (key2 == null) {
            GlobalCC.errorValueNotEntered("No Record Selected");
            return null;
        }
        JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
        if (r == null) {
            GlobalCC.errorValueNotEntered("No Record Selected");
            return null;
        }

        session.setAttribute("cratCode", r.getAttribute("cratCode"));
        cratRate.setValue(r.getAttribute("cratRate"));
        cratWefDate.setValue(r.getAttribute("cratWefDate"));
        cratWetDate.setValue(r.getAttribute("cratWetDate"));
        cratAtCode.setValue(session.getAttribute("actCode"));
        cratDivFactor.setValue(r.getAttribute("cratDivFactor"));
        cratRangeFrom.setValue(r.getAttribute("cratRangeFrom"));
        cratRangeTo.setValue(r.getAttribute("cratRangeTo"));
        cratYrNoFrom.setValue(r.getAttribute("cratYrNoFrom"));
        cratYrNoTo.setValue(r.getAttribute("cratYrNoTo"));
        cratTermFrom.setValue(r.getAttribute("cratTermFrom"));
        cratTermTo.setValue(r.getAttribute("cratTermTo"));

        AdfFacesContext.getCurrentInstance().addPartialTarget(cratCode);
        AdfFacesContext.getCurrentInstance().addPartialTarget(cratRate);
        AdfFacesContext.getCurrentInstance().addPartialTarget(cratWefDate);
        AdfFacesContext.getCurrentInstance().addPartialTarget(cratWetDate);
        AdfFacesContext.getCurrentInstance().addPartialTarget(cratAtCode);
        AdfFacesContext.getCurrentInstance().addPartialTarget(cratDivFactor);
        AdfFacesContext.getCurrentInstance().addPartialTarget(cratRangeFrom);
        AdfFacesContext.getCurrentInstance().addPartialTarget(cratRangeTo);
        AdfFacesContext.getCurrentInstance().addPartialTarget(cratYrNoFrom);
        AdfFacesContext.getCurrentInstance().addPartialTarget(cratYrNoTo);
        AdfFacesContext.getCurrentInstance().addPartialTarget(cratTermFrom);
        AdfFacesContext.getCurrentInstance().addPartialTarget(cratTermTo);

        AdfFacesContext.getCurrentInstance().addPartialTarget(commGrid);
        AdfFacesContext.getCurrentInstance().addPartialTarget(commPnl);
        AdfFacesContext.getCurrentInstance().addPartialTarget(commPopup);

        GlobalCC.showPopup("lmsgroup:commRatePopUp");
        return null;
    }
    public String deleteAction(){
            try{
              String Value = (String)session.getAttribute("delAction");
              String Result = "F";
                
              if(Value == null){
                  
              }else {
                //Delete The override rate...
                Result = deleteOvrComm();
              }
                
                if (Result == null){
                  return null;
                }else if(Result.equalsIgnoreCase("F")){
                  return null;
                }else{
                    GlobalCC.hidePopup("lmsgroup:confirmDel");
                }

              
            }catch(Exception e){
                GlobalCC.EXCEPTIONREPORTING(null, e);
            }
            return null;
        }
    public String deleteOvrComm() {
        // Add event code here...
        Connection conn = null;
        String Result = "F";

        Object key2 = ovcommRatesTab.getSelectedRowData();
       
        if (key2 == null) {
            GlobalCC.errorValueNotEntered("No Record Selected");
            return null;
        }
        JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
        if (r == null) {
            GlobalCC.errorValueNotEntered("No Record Selected");
            return null;
        }
        try {
            String key3=null;
           
            conn = new DBConnector().getDatabaseConn();
            String query = null;
            query =
                    "begin LMS_SETUPS_PKG.deleteOvCommRates(?); end;";

            conn=new DBConnector().getDatabaseConn();
             
             CallableStatement cstmt=conn.prepareCall(query);    
             cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("cratCode"));
            
             cstmt.execute();
             conn.commit();
             conn.close();
            
            ADFUtils.findIterator("findOverrideCommRatesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(ovcommRatesTab);
            GlobalCC.INFORMATIONREPORTING("Record Successfully Deleted");
            Result = "S";                

        } catch (Exception Ex) {
            Result = "F";
            GlobalCC.EXCEPTIONREPORTING(conn, Ex);
        }
        return Result;
    }

    public void setOccupationalBen(RichSelectOneChoice occupationalBen) {
        this.occupationalBen = occupationalBen;
    }

    public RichSelectOneChoice getOccupationalBen() {
        return occupationalBen;
    }

    public String getSelectedBranch() {
        // Add event code here...
        try {
            Object key2 = branchLOV.getSelectedRowData();
            if (key2 == null) {
                GlobalCC.errorValueNotEntered("No Record Selected");
                return null;
            }
            JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
            if (r == null) {
                GlobalCC.errorValueNotEntered("No Record Selected");
                return null;
            }
            budgBranchDesc.setValue(r.getAttribute("BRN_NAME"));
            session.setAttribute("brnCode", r.getAttribute("BRN_CODE"));
            session.setAttribute("pbgtCode", null);
            renJanBudget.setValue(null);
            renFebBudget.setValue(null);
            renMarBudget.setValue(null);
            renAprBudget.setValue(null);
            renMayBudget.setValue(null);
            renJunBudget.setValue(null);
            renJulBudget.setValue(null);
            renAugBudget.setValue(null);
            renSepBudget.setValue(null);
            renOctBudget.setValue(null);
            renNovBudget.setValue(null);
            renDecBudget.setValue(null);

            nbJanBudget.setValue(null);
            nbFebBudget.setValue(null);
            nbMarBudget.setValue(null);
            nbAprBudget.setValue(null);
            nbMayBudget.setValue(null);
            nbJunBudget.setValue(null);
            nbJulBudget.setValue(null);
            nbAugBudget.setValue(null);
            nbSepBudget.setValue(null);
            nbOctBudget.setValue(null);
            nbNovBudget.setValue(null);
            nbDecBudget.setValue(null);

            AdfFacesContext.getCurrentInstance().addPartialTarget(renJanBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(renFebBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(renMarBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(renJanBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(renFebBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(renMarBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(renAprBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(renMayBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(renJunBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(renJulBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(renAugBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(renSepBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(renOctBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(renNovBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(renDecBudget);

            AdfFacesContext.getCurrentInstance().addPartialTarget(nbJanBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(nbFebBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(nbMarBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(nbAprBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(nbMayBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(nbJunBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(nbJulBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(nbAugBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(nbSepBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(nbOctBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(nbNovBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(nbDecBudget);
            ADFUtils.findIterator("findProdBudgetTypesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(budgetNamesLOV);
        } catch (Exception Ex) {
            GlobalCC.EXCEPTIONREPORTING(null, Ex);
        }
        return null;
    }

    public void getSelectedProduct(ValueChangeEvent evt) {
        //      System.out.println(evt.getOldValue()+ " "+evt.getNewValue());
        if (evt.getNewValue() != evt.getOldValue()) {
            if (evt.getNewValue() != null) {
                Row row =
                    ADFUtils.findIterator("findProductsIterator").getRowAtRangeIndex(new Integer(evt.getNewValue().toString()));
                session.setAttribute("ovProdCode",
                                     row.getAttribute("productCode"));
                ovProdCode.setValue(row.getAttribute("productCode"));

                ADFUtils.findIterator("findOverrideCommRatesIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(ovcommRatesTab);

            } else {
                session.setAttribute("ovProdCode", null);
                ovProdCode.setValue(null);

                ADFUtils.findIterator("findOverrideCommRatesIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(ovcommRatesTab);
            }
        }
    }

    public String getSelectedProduct() {
        // Add event code here...
        try {
            Object key2 = productLOV.getSelectedRowData();
            if (key2 == null) {
                GlobalCC.errorValueNotEntered("No Record Selected");
                return null;
            }
            JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
            if (r == null) {
                GlobalCC.errorValueNotEntered("No Record Selected");
                return null;
            }
            budgProdDesc.setValue(r.getAttribute("prodDesc"));
            session.setAttribute("prodCode", r.getAttribute("prodCode"));
            session.setAttribute("pbgtCode", null);
            renJanBudget.setValue(null);
            renFebBudget.setValue(null);
            renMarBudget.setValue(null);
            renAprBudget.setValue(null);
            renMayBudget.setValue(null);
            renJunBudget.setValue(null);
            renJulBudget.setValue(null);
            renAugBudget.setValue(null);
            renSepBudget.setValue(null);
            renOctBudget.setValue(null);
            renNovBudget.setValue(null);
            renDecBudget.setValue(null);

            nbJanBudget.setValue(null);
            nbFebBudget.setValue(null);
            nbMarBudget.setValue(null);
            nbAprBudget.setValue(null);
            nbMayBudget.setValue(null);
            nbJunBudget.setValue(null);
            nbJulBudget.setValue(null);
            nbAugBudget.setValue(null);
            nbSepBudget.setValue(null);
            nbOctBudget.setValue(null);
            nbNovBudget.setValue(null);
            nbDecBudget.setValue(null);

            AdfFacesContext.getCurrentInstance().addPartialTarget(renJanBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(renFebBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(renMarBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(renAprBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(renMayBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(renJunBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(renJulBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(renAugBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(renSepBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(renOctBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(renNovBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(renDecBudget);

            AdfFacesContext.getCurrentInstance().addPartialTarget(nbJanBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(nbFebBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(nbMarBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(nbAprBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(nbMayBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(nbJunBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(nbJulBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(nbAugBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(nbSepBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(nbOctBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(nbNovBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(nbDecBudget);

            ADFUtils.findIterator("findProdBudgetTypesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(budgetNamesLOV);
        } catch (Exception Ex) {
            GlobalCC.EXCEPTIONREPORTING(null, Ex);
        }
        return null;
    }

    public void setProductLOV(RichTable productLOV) {
        this.productLOV = productLOV;
    }

    public RichTable getProductLOV() {
        return productLOV;
    }

    public void setBranchLOV(RichTable branchLOV) {
        this.branchLOV = branchLOV;
    }

    public RichTable getBranchLOV() {
        return branchLOV;
    }

    public void setBudgProdDesc(RichInputText budgProdDesc) {
        this.budgProdDesc = budgProdDesc;
    }

    public RichInputText getBudgProdDesc() {
        return budgProdDesc;
    }

    public void setBudgBranchDesc(RichInputText budgBranchDesc) {
        this.budgBranchDesc = budgBranchDesc;
    }

    public RichInputText getBudgBranchDesc() {
        return budgBranchDesc;
    }

    public String showBudgetPopup() {
        // Add event code here...
        session.setAttribute("btsCode", null);
        GlobalCC.showPopup("lmsgroup:p3");
        return null;
    }

    public String showEditPopup() {
        //
        try {
            Object key2 = budgetTypeLOV.getSelectedRowData();
            if (key2 == null) {
                GlobalCC.errorValueNotEntered("No Record Selected");
                return null;
            }
            JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
            if (r == null) {
                GlobalCC.errorValueNotEntered("No Record Selected");
                return null;
            }
            session.setAttribute("btsCode", r.getAttribute("btsCode"));
            budgetName.setValue(r.getAttribute("btsName"));
            budgetDesc.setValue(r.getAttribute("btsDesc"));
            budgetUW_YR.setValue(r.getAttribute("btsUwYr"));

            GlobalCC.showPopup("lmsgroup:p3");
        } catch (Exception Ex) {
            GlobalCC.EXCEPTIONREPORTING(null, Ex);
        }
        return null;
    }


    public void setBudgetName(RichInputText budgetName) {
        this.budgetName = budgetName;
    }

    public RichInputText getBudgetName() {
        return budgetName;
    }

    public void setBudgetDesc(RichInputText budgetDesc) {
        this.budgetDesc = budgetDesc;
    }

    public RichInputText getBudgetDesc() {
        return budgetDesc;
    }

    public void setBudgetUW_YR(RichInputText budgetUW_YR) {
        this.budgetUW_YR = budgetUW_YR;
    }

    public RichInputText getBudgetUW_YR() {
        return budgetUW_YR;
    }

    public void setBudgetEffDate(RichInputDate budgetEffDate) {
        this.budgetEffDate = budgetEffDate;
    }

    public RichInputDate getBudgetEffDate() {
        return budgetEffDate;
    }

    public String addEditBudgetTypes() {
        // Add event code here...
        Connection conn = null;
        String budget =
            "BEGIN LMS_SETUPS_PKG.updateBudgetTypes(?,?,?,?,?);END;";
        if (budgetName.getValue() == null) {
            GlobalCC.INFORMATIONREPORTING("Please enter budget name");
        }
        if (budgetDesc.getValue() == null) {
            GlobalCC.INFORMATIONREPORTING("Please enter budget description");
        }
        if (budgetUW_YR.getValue() == null) {
            GlobalCC.INFORMATIONREPORTING("Please enter the underwriting year");
        }
        if (budgetEffDate.getValue() == null) {
            GlobalCC.INFORMATIONREPORTING("Please provide Budget Effective date ");
        }
        try {
            conn = new DBConnector().getDatabaseConn();

            CallableStatement cstmt = conn.prepareCall(budget);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("btsCode"));
            cstmt.setString(2, (String)budgetName.getValue());
            cstmt.setString(3, (String)budgetDesc.getValue());
            cstmt.setString(4, (String)budgetUW_YR.getValue());
            if (budgetEffDate.getValue() == null) {
                cstmt.setString(5, null);
            }
            cstmt.setString(5,
                            GlobalCC.parseDate(budgetEffDate.getValue().toString()));
            cstmt.execute();
            conn.close();
            ADFUtils.findIterator("findBudgetTypesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(budgetTypeLOV);
            GlobalCC.INFORMATIONREPORTING("Budget Types Successfully saved");
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);

        }
        return null;
    }

    public void setBudgetTypeLOV(RichTable budgetTypeLOV) {
        this.budgetTypeLOV = budgetTypeLOV;
    }

    public RichTable getBudgetTypeLOV() {
        return budgetTypeLOV;
    }

    public void setDeleteBudgetTypes(RichCommandButton deleteBudgetTypes) {
        this.deleteBudgetTypes = deleteBudgetTypes;
    }

    public RichCommandButton getDeleteBudgetTypes() {
        return deleteBudgetTypes;
    }

    public String deleteBudgetAction() {
        // Add event code here...
        Connection conn = null;
        String deleteBudget = "BEGIN LMS_SETUPS_PKG.deleteBudgetTypes(?);END;";
        try {
            conn = new DBConnector().getDatabaseConn();
            CallableStatement cstmt = conn.prepareCall(deleteBudget);

            Object key2 = budgetTypeLOV.getSelectedRowData();
            if (key2 == null) {
                GlobalCC.errorValueNotEntered("No Record Selected");
                return null;
            }
            JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
            if (r == null) {
                GlobalCC.errorValueNotEntered("No Record Selected");
                return null;
            }
            cstmt.setBigDecimal(1, (BigDecimal)r.getAttribute("btsCode"));
            cstmt.execute();
            conn.close();
            ADFUtils.findIterator("findBudgetTypesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(budgetTypeLOV);
            GlobalCC.INFORMATIONREPORTING("Budget Types Successfully deleted");
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        }
        return null;
    }
    
    public String cancelOverrideCommRate() {
        int one=1;        
        cratCode.setValue(null);
        cratRate.setValue(null);
        cratWefDate.setValue(null);
        cratWetDate.setValue(null);
        cratAtCode.setValue(null);
        cratDivFactor.setValue(null);
        cratRangeFrom.setValue(null);
        cratRangeTo.setValue(null);
        cratYrNoFrom.setValue(null);
        cratYrNoTo.setValue(null);
        cratTermFrom.setValue(null);
        cratTermTo.setValue(null);
       
        AdfFacesContext.getCurrentInstance().addPartialTarget(cratCode);
        AdfFacesContext.getCurrentInstance().addPartialTarget(cratRate);
        AdfFacesContext.getCurrentInstance().addPartialTarget(cratWefDate);
        AdfFacesContext.getCurrentInstance().addPartialTarget(cratWetDate);
        AdfFacesContext.getCurrentInstance().addPartialTarget(cratAtCode);
        AdfFacesContext.getCurrentInstance().addPartialTarget(cratDivFactor);
        AdfFacesContext.getCurrentInstance().addPartialTarget(cratRangeFrom);
        AdfFacesContext.getCurrentInstance().addPartialTarget(cratRangeTo);
        AdfFacesContext.getCurrentInstance().addPartialTarget(cratYrNoFrom);
        AdfFacesContext.getCurrentInstance().addPartialTarget(cratYrNoTo);
        AdfFacesContext.getCurrentInstance().addPartialTarget(cratTermFrom);
        AdfFacesContext.getCurrentInstance().addPartialTarget(cratTermTo);
        
        AdfFacesContext.getCurrentInstance().addPartialTarget(commGrid);
        AdfFacesContext.getCurrentInstance().addPartialTarget(commPnl);
        AdfFacesContext.getCurrentInstance().addPartialTarget(commPopup);
         
        GlobalCC.hidePopup("demoTemplate:commRatePopUp");
        return null;
    }

    public void setRenJanBudget(RichInputText renJanBudget) {
        this.renJanBudget = renJanBudget;
    }

    public RichInputText getRenJanBudget() {
        return renJanBudget;
    }

    public void setNbJanBudget(RichInputText nbJanBudget) {
        this.nbJanBudget = nbJanBudget;
    }

    public RichInputText getNbJanBudget() {
        return nbJanBudget;
    }

    public void setRenFebBudget(RichInputText renFebBudget) {
        this.renFebBudget = renFebBudget;
    }

    public RichInputText getRenFebBudget() {
        return renFebBudget;
    }

    public void setNbFebBudget(RichInputText nbFebBudget) {
        this.nbFebBudget = nbFebBudget;
    }

    public RichInputText getNbFebBudget() {
        return nbFebBudget;
    }

    public void setRenMarBudget(RichInputText renMarBudget) {
        this.renMarBudget = renMarBudget;
    }

    public RichInputText getRenMarBudget() {
        return renMarBudget;
    }

    public void setNbMarBudget(RichInputText nbMarBudget) {
        this.nbMarBudget = nbMarBudget;
    }

    public RichInputText getNbMarBudget() {
        return nbMarBudget;
    }

    public void setRenAprBudget(RichInputText renAprBudget) {
        this.renAprBudget = renAprBudget;
    }

    public RichInputText getRenAprBudget() {
        return renAprBudget;
    }

    public void setNbAprBudget(RichInputText nbAprBudget) {
        this.nbAprBudget = nbAprBudget;
    }

    public RichInputText getNbAprBudget() {
        return nbAprBudget;
    }

    public void setNbMayBudget(RichInputText nbMayBudget) {
        this.nbMayBudget = nbMayBudget;
    }

    public RichInputText getNbMayBudget() {
        return nbMayBudget;
    }

    public void setRenMayBudget(RichInputText renMayBudget) {
        this.renMayBudget = renMayBudget;
    }

    public RichInputText getRenMayBudget() {
        return renMayBudget;
    }

    public void setRenJunBudget(RichInputText renJunBudget) {
        this.renJunBudget = renJunBudget;
    }

    public RichInputText getRenJunBudget() {
        return renJunBudget;
    }

    public void setNbJunBudget(RichInputText nbJunBudget) {
        this.nbJunBudget = nbJunBudget;
    }

    public RichInputText getNbJunBudget() {
        return nbJunBudget;
    }

    public void setRenJulBudget(RichInputText renJulBudget) {
        this.renJulBudget = renJulBudget;
    }

    public RichInputText getRenJulBudget() {
        return renJulBudget;
    }

    public void setNbJulBudget(RichInputText nbJulBudget) {
        this.nbJulBudget = nbJulBudget;
    }

    public RichInputText getNbJulBudget() {
        return nbJulBudget;
    }

    public void setRenAugBudget(RichInputText renAugBudget) {
        this.renAugBudget = renAugBudget;
    }

    public RichInputText getRenAugBudget() {
        return renAugBudget;
    }

    public void setNbAugBudget(RichInputText nbAugBudget) {
        this.nbAugBudget = nbAugBudget;
    }

    public RichInputText getNbAugBudget() {
        return nbAugBudget;
    }

    public void setRenSepBudget(RichInputText renSepBudget) {
        this.renSepBudget = renSepBudget;
    }

    public RichInputText getRenSepBudget() {
        return renSepBudget;
    }

    public void setNbSepBudget(RichInputText nbSepBudget) {
        this.nbSepBudget = nbSepBudget;
    }

    public RichInputText getNbSepBudget() {
        return nbSepBudget;
    }

    public void setRenOctBudget(RichInputText renOctBudget) {
        this.renOctBudget = renOctBudget;
    }

    public RichInputText getRenOctBudget() {
        return renOctBudget;
    }

    public void setNbOctBudget(RichInputText nbOctBudget) {
        this.nbOctBudget = nbOctBudget;
    }

    public RichInputText getNbOctBudget() {
        return nbOctBudget;
    }

    public void setRenNovBudget(RichInputText renNovBudget) {
        this.renNovBudget = renNovBudget;
    }

    public RichInputText getRenNovBudget() {
        return renNovBudget;
    }

    public void setNbNovBudget(RichInputText nbNovBudget) {
        this.nbNovBudget = nbNovBudget;
    }

    public RichInputText getNbNovBudget() {
        return nbNovBudget;
    }

    public void setRenDecBudget(RichInputText renDecBudget) {
        this.renDecBudget = renDecBudget;
    }

    public RichInputText getRenDecBudget() {
        return renDecBudget;
    }

    public void setNbDecBudget(RichInputText nbDecBudget) {
        this.nbDecBudget = nbDecBudget;
    }

    public RichInputText getNbDecBudget() {
        return nbDecBudget;
    }

    public void setProdBudgetLOV(RichTable prodBudgetLOV) {
        this.prodBudgetLOV = prodBudgetLOV;
    }

    public RichTable getProdBudgetLOV() {
        return prodBudgetLOV;
    }

    public String addProdBudget() {
        // Add event code here...
        Connection conn = null;
        String prodBudget =
            "BEGIN LMS_SETUPS_PKG.updateProductBudgets(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);END;";
        try {
            conn = new DBConnector().getDatabaseConn();
            CallableStatement cstmt = conn.prepareCall(prodBudget);
            Object key2 = prodBudgetLOV.getSelectedRowData();
            if (key2 == null) {
                GlobalCC.errorValueNotEntered("No Record Selected");
                return null;
            }
            JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
            if (r == null) {
                GlobalCC.errorValueNotEntered("No Record Selected");
                return null;
            }
            if (r.getAttribute("btsCode") == null) {
                GlobalCC.INFORMATIONREPORTING("Select Budget to Proceed");
            }
            if (session.getAttribute("prodCode") == null) {
                GlobalCC.INFORMATIONREPORTING("Product not selected...please select a product");
            }
            if (session.getAttribute("brnCode") == null) {
                GlobalCC.INFORMATIONREPORTING("Branch not selected...please select a Branch");
            }
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("prodCode"));
            cstmt.setBigDecimal(2,
                                (BigDecimal)session.getAttribute("brnCode"));
            cstmt.setBigDecimal(3, (BigDecimal)r.getAttribute("btsCode"));
            cstmt.setBigDecimal(4,
                                (BigDecimal)session.getAttribute("pbgtCode"));
            if (renJanBudget.getValue() == null) {
                cstmt.setString(5, null);
            } else {
                cstmt.setString(5, (String)renJanBudget.getValue());
            }
            if (renFebBudget.getValue() == null) {
                cstmt.setString(6, null);
            } else {
                cstmt.setString(6, (String)renFebBudget.getValue());
            }
            if (renMarBudget.getValue() == null) {
                cstmt.setString(7, null);
            } else {
                cstmt.setString(7, (String)renMarBudget.getValue());
            }
            if (renAprBudget.getValue() == null) {
                cstmt.setString(8, null);
            } else {
                cstmt.setString(8, (String)renAprBudget.getValue());
            }
            if (renMayBudget.getValue() == null) {
                cstmt.setString(9, null);
            } else {
                cstmt.setString(9, (String)renMayBudget.getValue());
            }

            if (renJunBudget.getValue() == null) {
                cstmt.setString(10, null);
            } else {
                cstmt.setString(10, (String)renJunBudget.getValue());
            }
            if (renJulBudget.getValue() == null) {
                cstmt.setString(11, null);
            } else {
                cstmt.setString(11, (String)renJulBudget.getValue());
            }
            if (renAugBudget.getValue() == null) {
                cstmt.setString(12, null);
            } else {
                cstmt.setString(12, (String)renAugBudget.getValue());
            }
            if (renSepBudget.getValue() == null) {
                cstmt.setString(13, null);
            } else {
                cstmt.setString(13, (String)renSepBudget.getValue());
            }
            if (renOctBudget.getValue() == null) {
                cstmt.setString(14, null);
            } else {
                cstmt.setString(14, (String)renOctBudget.getValue());
            }
            if (renNovBudget.getValue() == null) {
                cstmt.setString(15, null);
            } else {
                cstmt.setString(15, (String)renNovBudget.getValue());
            }
            if (renDecBudget.getValue() == null) {
                cstmt.setString(16, null);
            } else {
                cstmt.setString(16, (String)renDecBudget.getValue());
            }

            if (nbJanBudget.getValue() == null) {
                cstmt.setString(17, null);
            } else {
                cstmt.setString(17, (String)nbJanBudget.getValue());
            }
            if (nbFebBudget.getValue() == null) {
                cstmt.setString(18, null);
            } else {
                cstmt.setString(18, (String)nbFebBudget.getValue());
            }
            if (nbMarBudget.getValue() == null) {
                cstmt.setString(19, null);
            } else {
                cstmt.setString(19, (String)nbMarBudget.getValue());
            }
            if (nbAprBudget.getValue() == null) {
                cstmt.setString(20, null);
            } else {
                cstmt.setString(20, (String)nbAprBudget.getValue());
            }
            if (nbMayBudget.getValue() == null) {
                cstmt.setString(21, null);
            } else {
                cstmt.setString(21, (String)nbMayBudget.getValue());
            }
            if (nbJunBudget.getValue() == null) {
                cstmt.setString(22, null);
            } else {
                cstmt.setString(22, (String)nbJunBudget.getValue());
            }
            if (nbJulBudget.getValue() == null) {
                cstmt.setString(23, null);
            } else {
                cstmt.setString(23, (String)nbJulBudget.getValue());
            }
            if (nbAugBudget.getValue() == null) {
                cstmt.setString(24, null);
            } else {
                cstmt.setString(24, (String)nbAugBudget.getValue());
            }
            if (nbSepBudget.getValue() == null) {
                cstmt.setString(25, null);
            } else {
                cstmt.setString(25, (String)nbSepBudget.getValue());
            }
            if (nbOctBudget.getValue() == null) {
                cstmt.setString(26, null);
            } else {
                cstmt.setString(26, (String)nbOctBudget.getValue());
            }

            if (nbNovBudget.getValue() == null) {
                cstmt.setString(27, null);
            } else {
                cstmt.setString(27, (String)nbNovBudget.getValue());
            }
            if (nbDecBudget.getValue() == null) {
                cstmt.setString(28, null);
            } else {
                cstmt.setString(28, (String)nbDecBudget.getValue());
            }

            GlobalCC.INFORMATIONREPORTING("Product budget saved successfully");
            cstmt.execute();
            conn.close();

            ADFUtils.findIterator("findProdBudgetTypesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(budgetNamesLOV);
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        }


        return null;
    }

    public void setBudgetNamesLOV(RichTable budgetNamesLOV) {
        this.budgetNamesLOV = budgetNamesLOV;
    }

    public RichTable getBudgetNamesLOV() {
        return budgetNamesLOV;
    }

    public void populateBudgetMonths(SelectionEvent selectionEvent) {
        // Add event code here...
        Object key2 = budgetNamesLOV.getSelectedRowData();
        if (key2 == null) {
            GlobalCC.errorValueNotEntered("No Record Selected");
        }
        JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
        if (r == null) {
            GlobalCC.errorValueNotEntered("No Record Selected");
        }
        session.setAttribute("pbgtCode", r.getAttribute("pbgtCode"));
        renJanBudget.setValue(r.getAttribute("pbgtJanRenAmt"));
        renFebBudget.setValue(r.getAttribute("pbgtFebRenAmt"));
        renMarBudget.setValue(r.getAttribute("pbgtMarRenAmt"));
        renAprBudget.setValue(r.getAttribute("pbgtAprRenAmt"));
        renMayBudget.setValue(r.getAttribute("pbgtMayRenAmt"));
        renJunBudget.setValue(r.getAttribute("pbgtJunRenAmt"));
        renJulBudget.setValue(r.getAttribute("pbgtJulRenAmt"));
        renAugBudget.setValue(r.getAttribute("pbgtAugRenAmt"));
        renSepBudget.setValue(r.getAttribute("pbgtSepRenAmt"));
        renOctBudget.setValue(r.getAttribute("pbgtOctRenAmt"));
        renNovBudget.setValue(r.getAttribute("pbgtNovRenAmt"));
        renDecBudget.setValue(r.getAttribute("pbgtDecRenAmt"));

        nbJanBudget.setValue(r.getAttribute("pbgtJanNBAmt"));
        nbFebBudget.setValue(r.getAttribute("pbgtFebNBAmt"));
        nbMarBudget.setValue(r.getAttribute("pbgtMarNBAmt"));
        nbAprBudget.setValue(r.getAttribute("pbgtAprNBAmt"));
        nbMayBudget.setValue(r.getAttribute("pbgtMayNBAmt"));
        nbJunBudget.setValue(r.getAttribute("pbgtJunNBAmt"));
        nbJulBudget.setValue(r.getAttribute("pbgtJulNBAmt"));
        nbAugBudget.setValue(r.getAttribute("pbgtAugNBAmt"));
        nbSepBudget.setValue(r.getAttribute("pbgtSepNBAmt"));
        nbOctBudget.setValue(r.getAttribute("pbgtOctNBAmt"));
        nbNovBudget.setValue(r.getAttribute("pbgtNovNBAmt"));
        nbDecBudget.setValue(r.getAttribute("pbgtDecNBAmt"));

        AdfFacesContext.getCurrentInstance().addPartialTarget(renJanBudget);
        AdfFacesContext.getCurrentInstance().addPartialTarget(renFebBudget);
        AdfFacesContext.getCurrentInstance().addPartialTarget(renMarBudget);
        AdfFacesContext.getCurrentInstance().addPartialTarget(renAprBudget);
        AdfFacesContext.getCurrentInstance().addPartialTarget(renMayBudget);
        AdfFacesContext.getCurrentInstance().addPartialTarget(renJunBudget);
        AdfFacesContext.getCurrentInstance().addPartialTarget(renJulBudget);
        AdfFacesContext.getCurrentInstance().addPartialTarget(renAugBudget);
        AdfFacesContext.getCurrentInstance().addPartialTarget(renSepBudget);
        AdfFacesContext.getCurrentInstance().addPartialTarget(renOctBudget);
        AdfFacesContext.getCurrentInstance().addPartialTarget(renNovBudget);
        AdfFacesContext.getCurrentInstance().addPartialTarget(renDecBudget);

        AdfFacesContext.getCurrentInstance().addPartialTarget(nbJanBudget);
        AdfFacesContext.getCurrentInstance().addPartialTarget(nbFebBudget);
        AdfFacesContext.getCurrentInstance().addPartialTarget(nbMarBudget);
        AdfFacesContext.getCurrentInstance().addPartialTarget(nbAprBudget);
        AdfFacesContext.getCurrentInstance().addPartialTarget(nbMayBudget);
        AdfFacesContext.getCurrentInstance().addPartialTarget(nbJunBudget);
        AdfFacesContext.getCurrentInstance().addPartialTarget(nbJulBudget);
        AdfFacesContext.getCurrentInstance().addPartialTarget(nbAugBudget);
        AdfFacesContext.getCurrentInstance().addPartialTarget(nbSepBudget);
        AdfFacesContext.getCurrentInstance().addPartialTarget(nbOctBudget);
        AdfFacesContext.getCurrentInstance().addPartialTarget(nbNovBudget);
        AdfFacesContext.getCurrentInstance().addPartialTarget(nbDecBudget);


    }


    public String selectBudgetType() {
        // Add event code here...
        Object key2 = prodBudgetLOV.getSelectedRowData();
        if (key2 == null) {
            GlobalCC.errorValueNotEntered("No Record Selected");
            return null;
        }
        JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
        if (r == null) {
            GlobalCC.errorValueNotEntered("No Record Selected");
            return null;
        }
        session.setAttribute("btsCode", r.getAttribute("btsCode"));
        budgetNameTF.setValue(r.getAttribute("btsName"));
        renJanBudget.setValue(null);
        renFebBudget.setValue(null);
        renMarBudget.setValue(null);
        renAprBudget.setValue(null);
        renMayBudget.setValue(null);
        renJunBudget.setValue(null);
        renJulBudget.setValue(null);
        renAugBudget.setValue(null);
        renSepBudget.setValue(null);
        renOctBudget.setValue(null);
        renNovBudget.setValue(null);
        renDecBudget.setValue(null);

        nbJanBudget.setValue(null);
        nbFebBudget.setValue(null);
        nbMarBudget.setValue(null);
        nbAprBudget.setValue(null);
        nbMayBudget.setValue(null);
        nbJunBudget.setValue(null);
        nbJulBudget.setValue(null);
        nbAugBudget.setValue(null);
        nbSepBudget.setValue(null);
        nbOctBudget.setValue(null);
        nbNovBudget.setValue(null);
        nbDecBudget.setValue(null);

        AdfFacesContext.getCurrentInstance().addPartialTarget(renJanBudget);
        AdfFacesContext.getCurrentInstance().addPartialTarget(renFebBudget);
        AdfFacesContext.getCurrentInstance().addPartialTarget(renMarBudget);
        AdfFacesContext.getCurrentInstance().addPartialTarget(renAprBudget);
        AdfFacesContext.getCurrentInstance().addPartialTarget(renMayBudget);
        AdfFacesContext.getCurrentInstance().addPartialTarget(renJunBudget);
        AdfFacesContext.getCurrentInstance().addPartialTarget(renJulBudget);
        AdfFacesContext.getCurrentInstance().addPartialTarget(renAugBudget);
        AdfFacesContext.getCurrentInstance().addPartialTarget(renSepBudget);
        AdfFacesContext.getCurrentInstance().addPartialTarget(renOctBudget);
        AdfFacesContext.getCurrentInstance().addPartialTarget(renNovBudget);
        AdfFacesContext.getCurrentInstance().addPartialTarget(renDecBudget);

        AdfFacesContext.getCurrentInstance().addPartialTarget(nbJanBudget);
        AdfFacesContext.getCurrentInstance().addPartialTarget(nbFebBudget);
        AdfFacesContext.getCurrentInstance().addPartialTarget(nbMarBudget);
        AdfFacesContext.getCurrentInstance().addPartialTarget(nbAprBudget);
        AdfFacesContext.getCurrentInstance().addPartialTarget(nbMayBudget);
        AdfFacesContext.getCurrentInstance().addPartialTarget(nbJunBudget);
        AdfFacesContext.getCurrentInstance().addPartialTarget(nbJulBudget);
        AdfFacesContext.getCurrentInstance().addPartialTarget(nbAugBudget);
        AdfFacesContext.getCurrentInstance().addPartialTarget(nbSepBudget);
        AdfFacesContext.getCurrentInstance().addPartialTarget(nbOctBudget);
        AdfFacesContext.getCurrentInstance().addPartialTarget(nbNovBudget);
        AdfFacesContext.getCurrentInstance().addPartialTarget(nbDecBudget);

        ADFUtils.findIterator("findProdBudgetTypesIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(budgetNamesLOV);
        return null;
    }

    public void setBudgetNameTF(RichInputText budgetNameTF) {
        this.budgetNameTF = budgetNameTF;
    }

    public RichInputText getBudgetNameTF() {
        return budgetNameTF;
    }

    public String deleteProdBudget() {
        // Add event code here...
        Connection conn = null;
        String deleteProdBudget =
            "BEGIN LMS_SETUPS_PKG.deleteProductBudgets(?);END;";
        ;

        try {
            conn = new DBConnector().getDatabaseConn();
            CallableStatement cstmt = conn.prepareCall(deleteProdBudget);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("pbgtCode"));
            cstmt.execute();
            conn.close();
            renJanBudget.setValue(null);
            renFebBudget.setValue(null);
            renMarBudget.setValue(null);
            renAprBudget.setValue(null);
            renMayBudget.setValue(null);
            renJunBudget.setValue(null);
            renJulBudget.setValue(null);
            renAugBudget.setValue(null);
            renSepBudget.setValue(null);
            renOctBudget.setValue(null);
            renNovBudget.setValue(null);
            renDecBudget.setValue(null);

            nbJanBudget.setValue(null);
            nbFebBudget.setValue(null);
            nbMarBudget.setValue(null);
            nbAprBudget.setValue(null);
            nbMayBudget.setValue(null);
            nbJunBudget.setValue(null);
            nbJulBudget.setValue(null);
            nbAugBudget.setValue(null);
            nbSepBudget.setValue(null);
            nbOctBudget.setValue(null);
            nbNovBudget.setValue(null);
            nbDecBudget.setValue(null);

            AdfFacesContext.getCurrentInstance().addPartialTarget(renJanBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(renFebBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(renMarBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(renAprBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(renMayBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(renJunBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(renJulBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(renAugBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(renSepBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(renOctBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(renNovBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(renDecBudget);

            AdfFacesContext.getCurrentInstance().addPartialTarget(nbJanBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(nbFebBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(nbMarBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(nbAprBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(nbMayBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(nbJunBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(nbJulBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(nbAugBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(nbSepBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(nbOctBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(nbNovBudget);
            AdfFacesContext.getCurrentInstance().addPartialTarget(nbDecBudget);

            ADFUtils.findIterator("findProdBudgetTypesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(budgetNamesLOV);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }

        return null;
    }

    public void setMedGracePeriod(RichInputText medGracePeriod) {
        this.medGracePeriod = medGracePeriod;
    }

    public RichInputText getMedGracePeriod() {
        return medGracePeriod;
    }

    public void setPlanShtDesc(RichInputText planShtDesc) {
        this.planShtDesc = planShtDesc;
    }

    public RichInputText getPlanShtDesc() {
        return planShtDesc;
    }

    public void setPlanDescription(RichInputText planDescription) {
        this.planDescription = planDescription;
    }

    public RichInputText getPlanDescription() {
        return planDescription;
    }

    public String showPlanPopup() {
        // Add event code here...
        planShtDesc.setValue(null);
        planDescription.setValue(null);
        GlobalCC.showPopup("lmsgroup:p1");
        return null;
    }

    public String updateProdPlans() {
        // Add event code here...
        Object key2 = productPlanLOV.getSelectedRowData();
        if (key2 == null) {
            GlobalCC.errorValueNotEntered("No Record Selected");
            return null;
        }
        JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
        if (r == null) {
            GlobalCC.errorValueNotEntered("No Record Selected");
            return null;
        }
        planDescription.setValue(r.getAttribute("pplDesc"));
        session.setAttribute("pplCode", r.getAttribute("pplCode"));
        GlobalCC.showPopup("lmsgroup:p1");
        return null;
    }

    public String deleteProdPlan() {
        // Add event code here...
        Connection conn = null;

        String addQuery = "BEGIN LMS_WEB_PKG_GRP.deletePlans(?);END;";
        Object key2 = productPlanLOV.getSelectedRowData();
        if (key2 == null) {
            GlobalCC.errorValueNotEntered("No Record Selected");
            return null;
        }
        JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
        if (r == null) {
            GlobalCC.errorValueNotEntered("No Record Selected");
            return null;
        }


        try {
            conn = new DBConnector().getDatabaseConn();

            CallableStatement cstmt = conn.prepareCall(addQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("pplCode"));
            cstmt.execute();
            conn.close();
            planDescription.setValue(r.getAttribute("pplDesc"));
            session.setAttribute("pplCode", r.getAttribute("pplCode"));
            ADFUtils.findIterator("findProductPlansIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(productPlanLOV);
            GlobalCC.INFORMATIONREPORTING("Product Plan deleted Successfully");

        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        }
        return null;
    }

    public String savePlan() {
        // Add event code here...
        Connection conn = null;

        String addQuery = "BEGIN LMS_WEB_PKG_GRP.addEditPlans(?,?,?,?);END;";

        try {
            conn = new DBConnector().getDatabaseConn();

            CallableStatement cstmt = conn.prepareCall(addQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("pplCode"));
            cstmt.setString(2, (String)planShtDesc.getValue());
            cstmt.setString(3, (String)planDescription.getValue());
            cstmt.setBigDecimal(4,
                                (BigDecimal)session.getAttribute("PRODCode"));
            cstmt.execute();
            conn.close();
            GlobalCC.INFORMATIONREPORTING("Product Plan Successfully saved");

            ADFUtils.findIterator("findProductPlansIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(productPlanLOV);

        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        }

        return null;
    }

    public void setProductPlanLOV(RichTable productPlanLOV) {
        this.productPlanLOV = productPlanLOV;
    }

    public RichTable getProductPlanLOV() {
        return productPlanLOV;
    }

    public void setEmailRecepients(RichSelectOneChoice emailRecepients) {
        this.emailRecepients = emailRecepients;
    }

    public RichSelectOneChoice getEmailRecepients() {
        return emailRecepients;
    }

    public void emailRecepientListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if (valueChangeEvent.getNewValue() != valueChangeEvent.getOldValue()) {
            if (emailRecepients.getValue() != null) {
                if (emailRecepients.getValue().equals("U")) {
                    emailusrnameLab.setRendered(true);
                    emailusrnamePG.setRendered(true);
                    emailAddrLab.setRendered(false);
                    emailAddressTF.setRendered(false);
                } else if (emailRecepients.getValue().equals("CE")) {
                    emailusrnameLab.setRendered(false);
                    emailusrnamePG.setRendered(false);
                    emailAddrLab.setRendered(true);
                    emailAddressTF.setRendered(true);

                } else {
                    emailusrnameLab.setRendered(false);
                    emailusrnamePG.setRendered(false);
                    emailAddrLab.setRendered(false);
                    emailAddressTF.setRendered(false);
                }

            }
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(emailusrnameLab);
        AdfFacesContext.getCurrentInstance().addPartialTarget(emailusrnamePG);
        AdfFacesContext.getCurrentInstance().addPartialTarget(emailPG);
        AdfFacesContext.getCurrentInstance().addPartialTarget(emailAddrLab);
        AdfFacesContext.getCurrentInstance().addPartialTarget(emailAddressTF);

    }

    public void setEmailusrnameLab(RichOutputText emailusrnameLab) {
        this.emailusrnameLab = emailusrnameLab;
    }

    public RichOutputText getEmailusrnameLab() {
        return emailusrnameLab;
    }

    public void setEmailusrnamePG(HtmlPanelGrid emailusrnamePG) {
        this.emailusrnamePG = emailusrnamePG;
    }

    public HtmlPanelGrid getEmailusrnamePG() {
        return emailusrnamePG;
    }

    public void setEmailPG(HtmlPanelGrid emailPG) {
        this.emailPG = emailPG;
    }

    public HtmlPanelGrid getEmailPG() {
        return emailPG;
    }

    public void setEmailAddressPG(HtmlPanelGrid emailAddressPG) {
        this.emailAddressPG = emailAddressPG;
    }

    public HtmlPanelGrid getEmailAddressPG() {
        return emailAddressPG;
    }

    public void setEmailAddressTF(RichInputText emailAddressTF) {
        this.emailAddressTF = emailAddressTF;
    }

    public RichInputText getEmailAddressTF() {
        return emailAddressTF;
    }

    public void setEmailAddrLab(RichOutputLabel emailAddrLab) {
        this.emailAddrLab = emailAddrLab;
    }

    public RichOutputLabel getEmailAddrLab() {
        return emailAddrLab;
    }

    public void setEmailAt(RichSelectOneChoice emailAt) {
        this.emailAt = emailAt;
    }

    public RichSelectOneChoice getEmailAt() {
        return emailAt;
    }

    public void setAggQuoLett(RichInputText aggQuoLett) {
        this.aggQuoLett = aggQuoLett;
    }

    public RichInputText getAggQuoLett() {
        return aggQuoLett;
    }

    public String selectPremMask() {
        // Add event code here...
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findPremiumMaskIterator");
        RowKeySet set = masksLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
            maskDisplay.setValue(r.getAttribute("PMAS_SHT_DESC"));
            //LOVCC.pmasCode=(BigDecimal)r.getAttribute("PMAS_CODE");
            session.setAttribute("pmasCode", r.getAttribute("PMAS_CODE"));
            AdfFacesContext.getCurrentInstance().addPartialTarget(maskDisplay);
            GlobalCC.hidePopup("lmsgroup:p2");
        }
        return null;
    }

    public void setMasksLOV(RichTable masksLOV) {
        this.masksLOV = masksLOV;
    }

    public RichTable getMasksLOV() {
        return masksLOV;
    }

    public void setMaskDisplay(RichInputText maskDisplay) {
        this.maskDisplay = maskDisplay;
    }

    public RichInputText getMaskDisplay() {
        return maskDisplay;
    }

    public void setAal(RichInputText aal) {
        this.aal = aal;
    }

    public RichInputText getAal() {
        return aal;
    }

    public void setNotificationPeriod(RichInputText notificationPeriod) {
        this.notificationPeriod = notificationPeriod;
    }

    public RichInputText getNotificationPeriod() {
        return notificationPeriod;
    }

    public String selectRptProduct() {
        // Add event code here...
        Object key2 = productLOV.getSelectedRowData();
        if (key2 == null) {
            GlobalCC.errorValueNotEntered("No Record Selected");
            return null;
        }
        JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
        if (r == null) {
            GlobalCC.errorValueNotEntered("No Record Selected");
            return null;
        }
        session.setAttribute("ProductCode", r.getAttribute("prodCode"));
        prodDescTF.setValue(r.getAttribute("prodDesc"));
        AdfFacesContext.getCurrentInstance().addPartialTarget(prodDescTF);
        GlobalCC.hidePopup("lmsgroup:p3");

        return null;
    }

    public void setProdDescTF(RichInputText prodDescTF) {
        this.prodDescTF = prodDescTF;
    }

    public RichInputText getProdDescTF() {
        return prodDescTF;
    }

    public void setOvProdCode(RichSelectOneChoice ovProdCode) {
        this.ovProdCode = ovProdCode;
    }

    public RichSelectOneChoice getOvProdCode() {
        return ovProdCode;
    }

    public void setCommPnl(RichPanelBox commPnl) {
        this.commPnl = commPnl;
    }

    public RichPanelBox getCommPnl() {
        return commPnl;
    }

    public void setCommGrid(HtmlPanelGrid commGrid) {
        this.commGrid = commGrid;
    }

    public HtmlPanelGrid getCommGrid() {
        return commGrid;
    }

    public void setCommPopup(RichPopup commPopup) {
        this.commPopup = commPopup;
    }

    public RichPopup getCommPopup() {
        return commPopup;
    }
    public String selectCurrency() {
        // Add event code here...
        // Add event code here...
        Object key2 = currencyLOV.getSelectedRowData();
        if (key2 == null) {
            GlobalCC.errorValueNotEntered("No Record Selected");
            return null;
        }
        JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
        if (r == null) {
            GlobalCC.errorValueNotEntered("No Record Selected");
            return null;
        }
        currencyTF.setValue(r.getAttribute("cur_symbol"));
        //System.out.println("Symbol="+r.getAttribute("cur_symbol"));
        session.setAttribute("cur_symbol", r.getAttribute("cur_symbol"));
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.currencyTF);
        GlobalCC.hidePopup("lmsgroup:Currencies");
        return null;
    }
    public void setCurrencyLOV(RichTable currencyLOV) {
        this.currencyLOV = currencyLOV;
    }

    public RichTable getCurrencyLOV() {
        return currencyLOV;
    }

    public void setCurrencyTF(RichInputText currencyTF) {
        this.currencyTF = currencyTF;
    }

    public RichInputText getCurrencyTF() {
        return currencyTF;
    }

    public void setBrokerName(RichInputText brokerName) {
        this.brokerName = brokerName;
    }

    public RichInputText getBrokerName() {
        return brokerName;
    }

    public void setBrokersLOV(RichTable brokersLOV) {
        this.brokersLOV = brokersLOV;
    }

    public RichTable getBrokersLOV() {
        return brokersLOV;
    }

    public String cancelBrokerPopup() {
        // Add event code here...
        GlobalCC.hidePopup("lmsgroup:p3");
        return null;
    }

    public String selectBroker() {
        // Add event code here...
        Object key2 = brokersLOV.getSelectedRowData();
        if (key2 == null) {
            GlobalCC.errorValueNotEntered("No Record Selected");
            return null;
        }
        JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
        if (r == null) {
            GlobalCC.errorValueNotEntered("No Record Selected");
            return null;
        }
        
        return null;
    }
}

