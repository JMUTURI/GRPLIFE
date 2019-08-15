package LMSG.view.Policy;

import java.math.BigDecimal;

import java.sql.CallableStatement;

import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.rich.component.rich.data.RichTree;
import oracle.adf.view.rich.component.rich.input.RichInputNumberSpinbox;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanCheckbox;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanRadio;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;

import oracle.adf.view.rich.component.rich.layout.RichPanelBox;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.layout.RichShowDetailItem;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;

import oracle.adf.view.rich.component.rich.nav.RichCommandLink;
import oracle.adf.view.rich.component.rich.output.RichOutputLabel;

import oracle.adf.view.rich.component.rich.output.RichOutputText;

import oracle.adf.view.rich.render.ClientEvent;

import org.apache.myfaces.trinidad.event.DisclosureEvent;
import org.apache.myfaces.trinidad.event.SelectionEvent;

import LMSG.view.connect.DBConnector;

import java.sql.Connection;

import java.sql.SQLException;

import java.text.SimpleDateFormat;

import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import oracle.adf.model.binding.DCIteratorBinding;

import oracle.adf.view.rich.component.rich.data.RichTable;

import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.Key;
import oracle.jbo.Row;

import oracle.jbo.uicli.binding.JUCtrlHierNodeBinding;

import oracle.jbo.uicli.binding.JUCtrlValueBinding;

import oracle.jdbc.internal.OracleTypes;

import org.apache.myfaces.trinidad.model.RowKeySet;

import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

import LMSG.view.Base.ADFUtils;

import LMSG.view.Base.GlobalCC;
import LMSG.view.Base.LOVCC;

import LMSG.view.BPM.wfEngine;
import LMSG.view.BPM.workflowProcessing;

import LMSG.view.Base.Rendering;
import LMSG.view.TableTypes.MemberBeneficiaries;
import LMSG.view.TableTypes.MemberReinstatements;

import com.Ostermiller.util.CSVParser;

import java.io.InputStream;
import java.io.InputStreamReader;

import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import javax.faces.model.SelectItem;

import oracle.adf.view.rich.component.rich.input.RichSelectItem;

import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;

import LMSG.view.Correspondents.CorrespondenceManipulation;

import LMSG.view.ecm.EcmUtil;

import java.text.DecimalFormat;

import org.alfresco.cmis.client.AlfrescoDocument;

import org.apache.chemistry.opencmis.client.api.Document;
import org.apache.chemistry.opencmis.client.api.Session;
import org.apache.myfaces.trinidad.model.CollectionModel;
import org.apache.myfaces.trinidad.model.RowKeySetImpl;
import org.apache.myfaces.trinidad.render.CoreRenderer;

public class underwritingPolicy extends LOVCC {
    private RichTable productsLOV;
    private RichInputText productDisplay;
    private RichInputText contraPolicyNoDisplay;
    private RichTable contraPoliciesLOV;
    private RichInputDate policyEffectiveDateDisplay;
    private RichInputText docRefNoDisplay;
    private RichTable proposersLOV;
    private RichInputText proposerDisplay;
    private RichInputText branchesDisplay;
    private RichTable branchesLOV;
    private RichSelectOneChoice frequencyOfPayment;
    private RichSelectOneChoice calculationType;
    private RichSelectOneChoice aboveRetireAge;
    private RichSelectOneChoice dependentsCovered;
    private RichSelectOneChoice durationType;
    private RichSelectOneChoice groupLifeRider;
    private RichSelectOneChoice schemeeTypeDisplay;
    private RichInputText regNumberDisplay;
    private RichSelectOneChoice taxComplianceDisplay;
    private RichInputText policyNUmberDisplay;
    private RichCommandButton generatePolicyNumber;
    private RichSelectOneChoice savingsRiderDisplay;
    private RichSelectOneChoice paymentMethodDisplay;
    private RichInputText agentsLOV;
    private RichTable agentDisplayLOV;
    private RichInputText agentsDisplay;
    private RichInputText checkOffDisplay;
    private RichTable checkOffAgentsDisplay;
    private RichTable masksLOV;
    private RichInputText maskDisplay;
    private RichInputNumberSpinbox commissionRateDisplay;
    private RichTable policyCoverTypesLOV;
    private RichInputText newRiderAmountDisplay;
    private RichSelectBooleanRadio membersRiders;
    private RichSelectBooleanRadio memwithoutRiders;
    private RichSelectBooleanRadio membersWithRiders;
    private RichTable taxesLOV;
    private RichTable policyProvisionsLOV;
    private RichTable policyCoverProvisions;
    private RichTable coverTypeProvisions;
    private RichTable polCvtProvisions;
    private RichInputText categIDDisplay;
    private RichInputText categDescriptionDisplay;
    private RichInputText categPeriodDisplay;
    private RichTable policyCategoriesLOV;
    private String saveEdit = "Y";

    private RichInputText limitAmountDisplay;
    private RichSelectOneChoice dependentTypeDisplay;
    private RichTable dependentTypesLOV;
    private RichInputText maxTypeDisplay;
    private RichTable policyDependentLimitsLOV;
    private RichTable documentsLOV;
    private RichInputText documentNameDisplay;
    private RichSelectOneChoice documentSubmitted;
    private RichInputDate documentDateDisplay;
    private RichInputText documentNoDisplay;
    private RichTable groupPolicyDocsLOV;
    private RichInputText arrangementDisplay;
    private RichInputText undProdDisplay;
    private RichTable treatyArrangementsLOV;
    private RichSelectOneChoice osLoanCalculation;
    private RichTable policyMembersLOV;
    private RichTable policyMemberCoversLOV;
    private RichCommandButton makeReadyBtn;
    private RichCommandButton authoriseBtn;
    private RichSelectOneChoice dpdCoverType;
    private RichTable dpdsCoverTypesLOV;
    private RichTable dpdCategoryLOV;
    private RichOutputText dpdCatDescDisp;
    private RichCommandButton recomputePremium;
    private RichSelectOneChoice fclCalcType;
    private RichInputText computedFCL;
    private RichInputText overrideFCL;
    private RichTable memRiTreatyDtlsLOV;
    private RichTable riTrtDtlsLOV;
    private RichTable policyMembers;
    private RichTable policyPremiumsLOV;
    private RichInputText policyNumberDisplay;
    private RichTable policyReceiptsLOV;
    private RichTable polRecptsInslmntsLOV;
    private RichInputText coverDescDisplay;
    private RichTable productCoverTypesLOV;
    private RichInputText overridePremDisplay;
    private RichSelectOneChoice loadingTypeSelect;
    private RichInputText discLoadRateDisplay;
    private RichInputText sumAssuredDisplay;
    private RichInputText recptPremAmtDisp;
    private RichInputText recptPensAmtDisp;
    private RichInputText recptGrossAmtDisplay;
    private RichInputText toPolNoDisplay;
    private RichTable transferPoliciesLOV;
    private RichInputText newPremAllocDisp;
    private RichInputText newPensionAlloc;
    private RichInputText newTotalAllocation;
    private RichPanelBox basicDetailsTab;
    private RichPanelBox policyDetailsTab;
    private RichPanelBox agentPolicyPayTab;
    private RichPanelBox coverTypeTab;
    private RichPanelBox polDocsTab;
    private RichPanelBox taxesTab;
    private RichPanelBox provisionsTab;
    private RichPanelBox membersTab;


    //public static int PageRender = 0;
    private RichCommandButton nextButton;
    private RichCommandButton prevButton;
    private RichCommandButton finishButton;
    private RichPanelBox catLimitTabs;
    private RichTable importedMembers;
    private RichPanelGroupLayout membersImport;
    private RichPanelBox singleMember;

    // public static String UW;
    private RichCommandButton genPolNo;
    private RichCommandButton checkoffButton;
    private RichOutputLabel saLabel;
    private RichTable allTaxesLOV;
    private RichInputText taxRate;
    private RichInputText taxAmt;
    private RichInputText applLevel;
    private RichOutputText taxSel;
    private RichInputText memNo;
    private RichInputText memSurname;
    private RichInputText memOtherNames;
    private RichInputText idNo;
    private RichInputText yeat;
    private RichInputDate memdob;
    private RichInputText quotememANB;
    private RichInputText weight;
    private RichInputText height;
    private RichInputText depTypeDesc;
    private RichInputText categoryDesc;
    private RichInputText sysPres;
    private RichInputText diaPres;
    private RichInputText occupationDesc;
    private RichSelectOneChoice memSex;
    private RichInputDate memloanDate;
    private RichInputNumberSpinbox origloanAmt;
    private RichInputText origRepayPeriod;
    private RichInputText loanInt;
    private RichInputNumberSpinbox savingAmt;
    private RichInputNumberSpinbox annualEarnings;
    private RichInputNumberSpinbox monthlyEarnings;
    private RichInputText memEarnprds;
    private RichInputDate joinDate;
    private RichInputText yrsOfService;
    private RichInputText futYearSrv;
    private RichInputText totSrvYears;
    private RichSelectOneChoice memcontrType;
    private RichInputText empeContr;
    private RichInputText emprContr;
    private RichInputText empeBF;
    private RichInputText emprBF;
    private RichInputText totalPen;
    private RichSelectBooleanCheckbox grpLifeRider;
    private RichCommandButton addMember;

    private RichInputText pinNo;
    private RichInputText addrss;

    protected String MemGrpLifeRider;
    protected String ANBMem;
    private RichCommandButton anotherMem2;
    private RichTable memcategoryLOV;
    private RichTable memoccupationLOV;
    private RichOutputText coinsurerLabel;
    private RichInputNumberSpinbox coShare;
    private RichInputNumberSpinbox coServFee;
    private RichSelectOneChoice coLeadFollow;
    private RichInputNumberSpinbox leaderShare;
    private RichTable polCoinsurersLOV;
    private RichTable coinsurersLOV;


    protected static BigDecimal coinsurerAgent;
    public static BigDecimal coinsurerCode;
    private RichSelectBooleanCheckbox coinsCbox;
    private RichPanelBox coinsureTab;
    private RichSelectOneChoice pensionType;
    private RichInputText guaranteePrdDisplay;
    private RichInputText pensEscDisplay;
    private RichSelectOneChoice pensPayFrequency;
    private RichSelectOneChoice earnPrdType;
    private RichInputText rmaleDisplay;
    private RichInputText rfemaleDisplay;
    private RichInputText pensAdminDisplay;
    private RichInputText totEmpyeeContr;
    private RichInputText totEmpyerContr;
    private RichSelectOneChoice contrType;
    private RichInputText empyerContrRate;
    private RichInputText empyeeContrRate;
    private RichInputText fundingRate;
    private RichInputText pensCommRate;
    private RichInputText empyerVolContr;
    private RichInputText emplyeeVolContr;
    private RichInputText empyerPensBF;
    private RichInputText empyeePensBF;
    private RichInputText totPensBF;
    private RichInputText pensInterestRate;
    private RichInputText penEarnEsc;
    private RichPanelBox pensionsTab;
    private RichInputText arrangementDisplay1;
    private RichTable treatyArrangementsLOV1;
    private HtmlPanelGrid reinsurancePanel;
    private RichOutputLabel avANBLabel;
    private RichInputText avANB;
    private RichTable trtPart;
    private RichTable polCatLOV;
    private RichTable usersLOV;
    private RichInputDate pensWEF;
    private RichInputText pensEarnings;
    private RichInputText pensTotalContri;
    private RichInputDate pensWET;
    private RichInputText pensEmprContr;
    private RichInputText pensAnnFund;
    private RichInputText pensAdminFee;
    private RichInputText pensEmpeContri;
    private RichInputText pensIntRate;
    private RichInputText pensAnnFac;
    private RichInputText empeVolContr;
    private RichInputText pensAnnum;
    private RichInputText pensEMV;
    private RichInputText pensEmprEMV;
    private RichInputText pensEmpeEMV;
    private RichSelectOneChoice unitRateOption;
    private RichInputNumberSpinbox VAT;
    private RichInputNumberSpinbox ovrCommRate;
    private RichCommandLink assignCreation;
    private RichOutputText endrSA;
    private RichInputText endrSA2;
    private RichSelectOneChoice endrFclType;
    private RichInputText endrFCLAmt;
    private RichInputText endrOvrFCLAmt;
    private RichInputText djMemNo;
    private RichInputText djSurname;
    private RichInputText djOtherNames;
    private RichSelectOneChoice djSex;
    private RichInputText djIDNo;
    private RichInputDate djDOB;
    private RichTable depTypeLOV2;
    private RichTable memDependantsLOV;
    private RichInputDate wetDate;
    private RichOutputText memCoverDisplay;
    private RichInputText memHeight;
    private RichInputText memWeight;
    private RichInputText memSysPr;
    private RichInputText memDiaPr;
    private RichInputText weightlding;
    private RichInputText memBPressLoading;
    private RichSelectOneChoice memLoadType;
    private RichInputText memloadRate;
    private RichInputText memloadDivFac;
    private RichInputText inputRate;
    private RichSelectOneChoice covOffered;
    private RichOutputText memCoverTypeDisplay;
    private RichInputText memEarningAmt;
    private RichInputText memEarningPeriod;
    private RichInputText memOrigLnAmt;
    private RichInputText memLoanAmt;
    private RichInputText memLoanInt;
    private RichInputDate memLoanIssDate;
    private RichInputText memSavingAmt;
    private RichInputText premium2;
    private RichInputText commAmt2;
    private RichSelectBooleanCheckbox overrideMedicals;
    private RichSelectOneChoice polCoinsuranceBusiness;
    private RichSelectOneChoice polCoinLeaderFollower;
    private RichInputText coinLeaderShare;
    private RichInputText addCoinsurerDisplay;
    private RichTable avaibaleCoinsurersLOV;
    private RichInputText sharePercentageDisplay;
    private RichInputText adminFeeDisplay;
    private RichTable studentsLOV;
    private RichInputText unitRate;
    private RichSelectOneChoice unitRateDivFactor;
    private RichSelectOneChoice followerLeaderBusiness;
    private RichOutputLabel followBusinessLabel;
    private RichSelectOneChoice laFollowerBusiness;
    private RichSelectOneChoice annuityPymtStructure;
    private RichSelectOneChoice annEscalation;
    private RichSelectOneChoice annOption;
    private RichInputText annuityAmount;
    private RichInputText pastLiability;
    private RichInputText futureLiability;
    private RichInputText totalLiability;
    private RichTree categoryTree;
    private RichSelectOneChoice durationTermType;
    private RichPanelBox schoolFeesTab;
    private RichTable classTermLimitsLOV;
    private RichInputText classTermDisplay;
    private RichInputText termFeeDisplay;
    private RichTable classesCategoriesLOV;
    private RichTable productProvisionsLOV;
    private RichSelectBooleanCheckbox provisionsCbox;
    private RichTable policyProvisionsTable;
    private RichTable classesLOV;
    private RichTable fucPlacement;
    private RichTable reinCompaniesTab;
    private RichInputNumberSpinbox facCode;
    private RichInputNumberSpinbox facAgnCode;
    private RichInputText facAgnName;
    private RichSelectOneChoice facRateAmt;
    private RichOutputLabel facAmntLabel;
    private RichInputNumberSpinbox facAmount;
    private RichOutputLabel facRatetLabel;
    private RichInputNumberSpinbox facRate;
    private RichInputNumberSpinbox facPremRate;
    private RichInputNumberSpinbox facDivFactor;
    private RichInputNumberSpinbox facCommRate;
    private RichPanelGroupLayout facPlacDetails;
    private RichShowDetailItem facTab;
    private RichOutputText coverDescLabel;
    private RichOutputText totalSALabel;
    private RichOutputText grossRetLabel;
    private RichInputNumberSpinbox excessAmount;
    private RichInputText studentNames;
    private RichInputText studentSurname;
    private RichInputText studentMemNo;
    private RichInputDate studentDOB;
    private RichSelectOneChoice studentClass;
    private RichSelectOneChoice studentSex;
    private RichSelectBooleanCheckbox facultativeCbox;
    private RichShowDetailItem schemeFacTab;
    private RichTable schemefucPrcpts;
    private RichCommandButton arrangementButton;
    private RichInputText totalSA;
    private RichInputText totRet;
    private RichInputText totExcess;
    private RichSelectOneChoice rateType;
    private RichTable annDependantsLOV;
    private RichSelectBooleanCheckbox reuseCbox;
    private RichInputText reuseDesc;
    private RichTable reuseTable;
    private HtmlPanelGrid reusePanel;
    private RichSelectOneChoice annPymtStructure;
    private RichInputText benInvestRate;
    private RichInputText termPayoutRate;
    private RichInputText annAdminCharge;
    private RichInputText schemeLegalAge;
    private RichOutputLabel mainCoverLabel;
    private RichSelectOneChoice mainCover;
    private RichOutputLabel percMainCvtLabel;
    private RichInputText percMainCvt;
    private RichSelectOneChoice productCoverDropBox;
    private RichOutputLabel prdTypeLabel;
    private RichTable reinMaskTable;
    private RichInputText reinMaskDesc;
    private RichSelectBooleanCheckbox premProvCbox;
    private RichOutputLabel premProvLabel;
    private RichOutputText dpdCatDescDisp1;
    private RichTable annPartialPayments;
    private RichInputDate regDate;
    private RichSelectOneChoice pensionMode;
    private RichInputNumberSpinbox ownFacShare;
    private RichOutputLabel weTLabel;
    private RichSelectBooleanCheckbox ldrCombined;
    private RichOutputLabel ldrCombinedLabel;
    private RichTable marketerLOV;
    private RichInputText marketerDisplay;
    private RichInputText benNames;
    private RichInputText benSurname;
    private RichInputText benMemNo;
    private RichInputDate benDOB;
    private RichInputText benShare;
    private RichInputText benTerShare;
    private RichInputText divFactor;
    private RichSelectOneChoice discChoice;
    private RichInputText discRateDisplay;
    private RichInputText discDivFactor;
    private RichInputText agencyDesc;
    private RichInputText rsaPin;
    private RichInputText studentSharePct;
    private RichTable agencyTable;
    private RichTable polMemberExceptions;
    private RichTable quoMemberExceptions;
    private RichSelectBooleanCheckbox jointAgent;
    private RichOutputLabel agentShareLabel;
    private RichInputNumberSpinbox agentShare;
    private RichInputText accessGrpDisplay;
    private RichTable accessGrpTable;
    private RichInputText accessGrpDisplay1;
    private RichTable accessGrpTable1;
    private RichTable memberSDivTable;
    private RichSelectBooleanCheckbox umbrellaCbox;
    private RichSelectOneChoice umbrellaDurationType;
    private RichOutputLabel umbrellaDurationLabel;
    private RichSelectOneChoice rateSelection;
    private RichInputText maskDesc;
    private RichCommandButton maskButton;
    private RichInputNumberSpinbox coverRate;
    private RichInputNumberSpinbox coverRateDivFactor;
    private RichTable maskTable;
    private RichInputText catMaskDesc;
    private RichTable catMaskTable;
    private RichInputText minAmountDisplay;
    private RichCommandButton premMaskBut;
    private RichSelectBooleanCheckbox unitRateSelectBox;
    private RichInputText unitRateDisplay;
    private RichSelectOneChoice unitRateDivisionFactor;
    private RichInputText totClaimPaid;
    private RichInputText totPremPaid;
    private RichInputText lossDurationPeriod;
    private RichInputText ageLoadFactor;
    private RichOutputLabel discLoadRateDisplayLab;
    private RichOutputLabel divFactorLab;
    private RichOutputLabel ageLoadFactorLab;
    private RichPanelGroupLayout coversPanel;
    private RichPanelBox coversPanelBox;
    private RichSelectOneChoice ben_type;
    private RichInputText refPolicyNo;
    private RichInputText refPremDisplay;
    private RichInputText refPensDisplay;
    private RichInputText refTotalDisplay;
    private RichSelectBooleanCheckbox load_discount_chk;
    private List<SelectItem> coverList;
    private RichSelectOneChoice coverListSelect;
    private RichSelectOneChoice loadingSelect;
    private RichInputText loadRateTF;
    private RichInputText loadRateDivTF;
    private RichSelectOneChoice discountingSelect;
    private RichInputText discountRateTF;
    private RichInputText discountDivFactorTF;
    private RichInputText memNo_search;
    private RichInputText memNameSearch;
    private RichInputText pensHistIntRate;
    private RichSelectOneChoice cvrLoadType;
    private RichInputText cvrLoadRate;
    private RichInputText cvrLoadDivFactor;
    private RichSelectOneChoice currSymbolCombo;
    private RichSelectOneChoice currRateType;
    private RichInputText currRate;
    private HtmlPanelGrid currencyPG;
    private RichOutputLabel currRateLab;
    private RichTable aboveFclLOV;
    private RichInputText bmiRate;
    private RichTable memClassesLOV;
    private RichTable occupationLOV;
    private RichTable memProvisionLOV;
    private RichTable memberProvision;
    private RichTable memberProvisionLOV;
    private RichTable prodPlanLOV;
    private RichInputText planTF;
    private RichInputText loanInstallmentAmt;
    private RichSelectOneChoice loanInstRepayFreq;
    private RichInputText postponePeriod;
    private RichOutputLabel postponeLab;
    private RichTable transfersTable;
    private RichInputText itNarrReasons;
    private RichInputText srchMemNo;
    private RichInputText srchMemName;
    private RichTable jointMemTable;
    private RichInputText assigneeName;
    private RichInputText assigneePhyAddr;
    private RichInputText aboveANBRate;
    private RichInputText exceptionRemarks;
    private RichTable aalLOV;
    private RichSelectOneChoice polCoverTypeSel;
    private RichOutputLabel cvtExcessLab;
    private RichInputText benIdNo;
    private RichInputText benRelationType;
    private RichInputText benComments;
    private RichTable relationTypeLOV;
    private RichInputDate polSignDate;
    
    private RichTable jMemLOV;
    private RichInputText jMemNo;
    private RichInputText jMemSurname;
    private RichInputText jMemOtherNames;
    private RichInputText jMemSex;
    private RichInputText jMemIDNo;
    private RichInputText jMemDOB;
    
    private RichSelectOneChoice builtin;
    private RichSelectOneChoice accelerator;
    private RichInputNumberSpinbox catRate;
    private RichInputNumberSpinbox catRateDivFac;
    private RichCommandButton catMaskButton;
    private RichSelectOneChoice catSelectRate;
    private RichInputText djPinNo;
    private RichInputText djAddress;
    private RichInputText dependantPinNo;
    private RichInputText dependantAddress;

    public underwritingPolicy() {
    }
    private RichInputText sbuOneDisplay;
    private RichTable SBUOneLOV;
    private RichTable SBUOneLOV1;
    private RichInputText locOneDisplay;
    private RichTable locOneLOV;
  
    
    public void setStudentsLOV(RichTable studentsLOV) {
        this.studentsLOV = studentsLOV;
    }

    public RichTable getStudentsLOV() {
        return studentsLOV;
    }

    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);

    public String GetAssignee() {
        try {
            // Render Popup
            System.out.println("enter popup");
            ExtendedRenderKitService erkService =
                Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                   ExtendedRenderKitService.class);
            erkService.addScript(FacesContext.getCurrentInstance(),
                                 "var hints = {autodismissNever:false}; " +
                                 "AdfPage.PAGE.findComponent('" +
                                 "lmsgroup:users" + "').show(hints);");

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String AssignTask() {

        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findTicketAssigneeIterator");
            RowKeySet set = usersLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            //System.out.println(1);
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();
                //clientsDisplay.setValue(r.getAttribute("CLIENT"));

                //LOVCC.TaskAssigneeID=(BigDecimal)r.getAttribute("taskUserID");
                //LOVCC.TaskAssignee = (String)r.getAttribute("taskUserShtDesc");
                session.setAttribute("TaskAssigneeID",
                                     r.getAttribute("taskUserID"));
                session.setAttribute("TaskAssignee",
                                     r.getAttribute("taskUserShtDesc"));


            }
            workflowProcessing bpm = new workflowProcessing();
            String Assign = (String)session.getAttribute("CreateUWClient");
            if (Assign.equalsIgnoreCase("Y")) {
                bpm.CreateWorkflowInstance();
                GlobalCC.RedirectPage("/lmsmain.jspx");
            }

            String Taske = (String)session.getAttribute("TaskID");
            BigDecimal Trans =
                (BigDecimal)session.getAttribute("transactionNumber");
            Integer PageRender1 =
                (Integer)session.getAttribute("uwPageRender");
            if (Taske == null && PageRender1 == 0) {
                bpm.CreateWorkflowInstance();
                CreateTransactions();

                basicDetailsTab.setRendered(false);
                policyDetailsTab.setRendered(true);
                agentPolicyPayTab.setRendered(false);
                coverTypeTab.setRendered(false);
                polDocsTab.setRendered(false);
                taxesTab.setRendered(false);
                provisionsTab.setRendered(false);
                membersTab.setRendered(false);
                catLimitTabs.setRendered(false);
                pensionsTab.setRendered(false);

                nextButton.setRendered(true);
                prevButton.setRendered(true);
                finishButton.setRendered(false);
                PageRender1++;
                session.setAttribute("uwPageRender", PageRender1);


            } else if (Taske != null && PageRender1 == 0 && Trans == null) {
                //do nothing
                CreateTransactions();

                basicDetailsTab.setRendered(false);
                policyDetailsTab.setRendered(true);
                agentPolicyPayTab.setRendered(false);
                coverTypeTab.setRendered(false);
                polDocsTab.setRendered(false);
                taxesTab.setRendered(false);
                provisionsTab.setRendered(false);
                membersTab.setRendered(false);
                catLimitTabs.setRendered(false);
                pensionsTab.setRendered(false);

                nextButton.setRendered(true);
                prevButton.setRendered(true);
                finishButton.setRendered(false);
                PageRender1++;
                session.setAttribute("uwPageRender", PageRender1);
            } else {
                bpm.CompleteTask();
                String Message =
                    "Current Task Complete. The Next Task " + (String)session.getAttribute("TaskActivityName") +
                    " has been Successfully assigned to " +
                    (String)session.getAttribute("TaskAssignee");
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));
                session.setAttribute("TaskID", null);
                return null;
            }

            //GlobalCC.RedirectPage("/g_quotone.jspx");
            System.out.println("Success");

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return null;
    }

    public String CreateClient() {
        String Rights = null;
        try {
            session.setAttribute("ProcessAreaShtDesc", "DENTR");
            session.setAttribute("ProcessSubAShtDesc", "CLNT");
            session.setAttribute("module", "P");
            workflowProcessing wf = new workflowProcessing();
            Rights = wf.CheckUserRights();

            if (Rights.equalsIgnoreCase("N")) {
                session.setAttribute("CreateUWClient", "Y");
                //LOVCC.ClientExists = "No";
                session.setAttribute("ClientExists", "No");
                ADFUtils.findIterator("findTicketAssigneeIterator").executeQuery();
                String TaskAss = (String)session.getAttribute("TaskAssignee");
                if (TaskAss == null) {
                    GetAssignee();
                    return null;
                } else {
                    workflowProcessing bpm = new workflowProcessing();
                    bpm.CreateWorkflowInstance();
                    session.setAttribute("TaskID", null);
                    String Message =
                        "The Task " + (String)session.getAttribute("TaskActivityName") +
                        " has been Successfully assigned to " +
                        (String)session.getAttribute("TaskAssignee");
                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                  Message,
                                                                                  Message));
                    return null;
                }


            } else {
                //LOVCC.ClientExists = "No";
                session.setAttribute("ClientExists", "No");
                workflowProcessing bpm = new workflowProcessing();
                bpm.CreateWorkflowInstance();
                GlobalCC.RedirectPage("/createClient.jspx");
            }

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String AssignClientCreation() {
        try {
            //LOVCC.ClientExists = "No";
            session.setAttribute("ClientExists", "No");
            session.setAttribute("CreateUWClient", "Y");
            ADFUtils.findIterator("findTicketAssigneeIterator").executeQuery();
            GetAssignee();


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String RenderImportMembers() {

        membersImport.setRendered(false);
        basicDetailsTab.setRendered(false);
        policyDetailsTab.setRendered(false);
        agentPolicyPayTab.setRendered(false);
        coverTypeTab.setRendered(false);
        polDocsTab.setRendered(false);
        taxesTab.setRendered(false);
        provisionsTab.setRendered(false);
        membersTab.setRendered(false);
        catLimitTabs.setRendered(false);
        membersImport.setRendered(true);
        singleMember.setRendered(false);
        //UW = "U";
        session.setAttribute("SystemPoint", "U");


        nextButton.setRendered(false);
        prevButton.setRendered(false);
        finishButton.setRendered(false);

        return null;
    }

    public String RenderSingleMembers() {

        membersImport.setRendered(false);
        basicDetailsTab.setRendered(false);
        policyDetailsTab.setRendered(false);
        agentPolicyPayTab.setRendered(false);
        coverTypeTab.setRendered(false);
        polDocsTab.setRendered(false);
        taxesTab.setRendered(false);
        provisionsTab.setRendered(false);
        membersTab.setRendered(false);
        catLimitTabs.setRendered(false);
        membersImport.setRendered(false);
        singleMember.setRendered(true);

        nextButton.setRendered(false);
        prevButton.setRendered(false);
        finishButton.setRendered(false);


        return null;
    }

    public String BackToMembers() {

        RefreshComponents();
        ADFUtils.findIterator("FindPolicyMembersIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(policyMembers);
        //AdfFacesContext.getCurrentInstance().addPartialTarget(memberCoversLOV);
        //ShowAddMembers();
        membersImport.setRendered(false);
        basicDetailsTab.setRendered(false);
        policyDetailsTab.setRendered(false);
        agentPolicyPayTab.setRendered(false);
        coverTypeTab.setRendered(false);
        polDocsTab.setRendered(false);
        taxesTab.setRendered(false);
        provisionsTab.setRendered(false);
        membersTab.setRendered(true);
        catLimitTabs.setRendered(false);
        membersImport.setRendered(false);
        singleMember.setRendered(false);

        nextButton.setRendered(false);
        prevButton.setRendered(true);
        finishButton.setRendered(true);
        session.setAttribute("MemberNumber", null);
        session.setAttribute("MemberNumber1", null);
        return null;
    }

    public String CreatePolicyProcessFlow() {
        String Result = "F";
        try {
            /*
           * Begin BPM Transaction. This will depend on new parameter if enabled
           * Also certain validations should be done to eliminate common errors, such as datasource...
           */
            String Value = null;

            workflowProcessing ProcessFlow = new workflowProcessing();
            Value = ProcessFlow.CheckBPMParameter("QUOTATIONS_BPM");
            //If Y, Use Process Flow...
            if (Value.equalsIgnoreCase("Y")) {

                ProcessFlow.FindProcessDetails();

                if (session.getAttribute("ProcessBPMDef") == null) {
                    GlobalCC.sysInformation("Theres is no Process Flow Defined for this Module. Cannot Proceed");
                    return Result;
                }

                //Confirm User has the rights.
                String Rights = null;
                Rights = ProcessFlow.CheckUserRights();
                if (Rights.equalsIgnoreCase("Y")) {
                    //Continue...
                } else {
                    //Assign the Task to Another User with Rights. Determines if there Any Users who can be Assigned.
                    //ADFUtils.findIterator("findTicketAssigneeIterator").executeQuery();
                    //String TaskAss = (String)session.getAttribute("TaskAssignee");
                    //if (TaskAss==null){
                    //Allow the User to Select A User to Assign the Task. i.e Render Popup.
                    //GetAssignee();
                    GlobalCC.sysInformation("you do not have the rights to perform this Transaction.");
                    return Result;
                    //}else{

                    //System Defaults a User to Perform the Task...
                    /*ProcessFlow.CreateWorkflowInstance();
                  if(session.getAttribute("workflowID")==null){
                      GlobalCC.sysInformation("There was a Problem Encountered when initializing the Process Flow" +
                              "Engine. Please Contact your Administrator.");
                      return Result;
                  }else{
                  session.setAttribute("TaskID", null);
                  GlobalCC.sysInformation("The Task " + (String)session.getAttribute("TaskActivityName") +  " has been Successfully assigned to " + (String)session.getAttribute("TaskAssignee"));
                  Result = "R";
                  return Result;
                  }*/
                }
                //Start BPM Process..
                session.setAttribute("TaskID", null);
                session.setAttribute("workflowID", null);

                ProcessFlow.CreateWorkflowInstance();
                if (session.getAttribute("workflowID") == null) {
                    GlobalCC.sysInformation("There was a Problem Encountered when initializing the Process Flow" +
                                            "Engine. Please Contact your Administrator.");
                    return Result;
                }
                Result = "S";

            } else {
                GlobalCC.sysInformation("Process Flow Functionality has been disabled. Please Contact Your Administrator");
                Result = "F";
                return Result;
            }
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
            e.printStackTrace();
        }
        return Result;
    }

    public String ValidateUserAccessForPolicy() {
        Connection conn = null;
        String Access = "N";
        try {
            String query =
                "begin ?:= LMS_WEB_PKG_GRP_UW.validate_user_access(?,?,?); end;";

            DBConnector datahandler = new DBConnector();

            conn = datahandler.getDatabaseConn();

            CallableStatement cst = null;
            cst = conn.prepareCall(query);
            cst.registerOutParameter(1, OracleTypes.VARCHAR);
            cst.setBigDecimal(2, (BigDecimal)session.getAttribute("UserCode"));
            if (session.getAttribute("lpagCode") == null) {
                cst.setBigDecimal(3,
                                  (BigDecimal)session.getAttribute("DeftlpagCode"));
            } else {
                cst.setBigDecimal(3,
                                  (BigDecimal)session.getAttribute("lpagCode"));
            }
            cst.setBigDecimal(4,
                              (BigDecimal)session.getAttribute("policyCode"));
            cst.execute();
            Access = cst.getString(1);
            cst.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return Access;
    }
    //Next command

    public String CmdNext() {
        String GrpRider = null;
        String CalcType = null;
        String prodType = (String)this.session.getAttribute("productType");
        Integer PageRender1 = (Integer)session.getAttribute("uwPageRender");
        Rendering render=new Rendering();
        if (PageRender1 == 4) {
            PageRender1 = 5;
            session.setAttribute("uwPageRender", PageRender1);
        }

        if (groupLifeRider.getValue() == null) {
            GrpRider = null;
        } else {
            GrpRider = groupLifeRider.getValue().toString();
        }

        if (calculationType.getValue() == null) {
            CalcType = null;
        } else {
            CalcType = calculationType.getValue().toString();
        }
        PageRender1 = (Integer)session.getAttribute("uwPageRender");

        System.out.println("Page render " + PageRender1 + "Group Rider " +
                           GrpRider);

        switch (PageRender1) {
        case 0:

            if (undProdDisplay.getValue() == null) {
                String Message = "Select A Product";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));
                return null;

            }

            if (policyEffectiveDateDisplay.getValue() == null) {
                String Message = "Select An Effective Date";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));
                return null;

            }

            if (umbrellaCbox.isSelected()) {
                session.setAttribute("umbrellaCover", "Y");
                durationType.setValue("O");
                session.setAttribute("policyDurationType", "O");
                durationType.setDisabled(true);
            } else {
                session.setAttribute("umbrellaCover", "N");
                durationType.setValue(null);
                session.setAttribute("policyDurationType", null);
                durationType.setDisabled(false);
            }

            String Access = ValidateUserAccessForPolicy();
            if (Access == null) {
                GlobalCC.errorValueNotEntered("You do not have rights to the Selected Access Group. Cannot Proceed.");
                return null;
            } else if (Access.equalsIgnoreCase("N")) {
                GlobalCC.errorValueNotEntered("You do not have rights to the Selected Access Group. Cannot Proceed.");
                return null;
            } else {
                //Do nothing....
            }
            if (reuseCbox.isSelected()) {
                //Continue...
                String Val = CreateTransactions();
                if (Val == null) {
                    return null;
                } else if (Val.equalsIgnoreCase("Failure")) {
                    return null;
                } else {

                }
            } else {
                String Val = CreateTransactions();
                if (Val == null) {
                    return null;
                } else if (Val.equalsIgnoreCase("Failure")) {
                    return null;
                } else {

                }
            }

            //LOVCC.ProcessShtDesc = "UWNB";
            //LOVCC.ProcessAreaShtDesc = "ACCS";
            //LOVCC.ProcessSubAShtDesc = "ACCS";
            session.setAttribute("ProcessShtDesc", "UWNB");
            session.setAttribute("ProcessAreaShtDesc", "ACCS");
            session.setAttribute("ProcessSubAShtDesc", "ACCS");

            session.setAttribute("ClientExists", "Yes");
            String ProcessResult = CreatePolicyProcessFlow();
            if (ProcessResult == null) {
                return null;
            } else if (ProcessResult.equalsIgnoreCase("F")) {
                return null;
            } else {
                //Continue...
            }

            if (reuseCbox.isSelected()) {
                if (session.getAttribute("reusePolCode") == null) {
                    GlobalCC.sysInformation("Select A Contra Policy...");
                    return null;
                }
                String PolSuccess = reusePolicyNoGeneration();
                if (PolSuccess == null) {
                    return null;
                } else if (PolSuccess.equalsIgnoreCase("F")) {
                    return null;
                } else {
                    //Continue with Policy.
                    String Return = ComputePremium();
                    if (Return == null) {
                        return null;
                    } else if (Return.equalsIgnoreCase("F")) {
                        return null;
                    }
                }
            }

            basicDetailsTab.setRendered(false);
            policyDetailsTab.setRendered(true);
            agentPolicyPayTab.setRendered(false);
            coverTypeTab.setRendered(false);
            polDocsTab.setRendered(false);
            taxesTab.setRendered(false);
            provisionsTab.setRendered(false);
            membersTab.setRendered(false);
            catLimitTabs.setRendered(false);
            pensionsTab.setRendered(false);
            schoolFeesTab.setRendered(false);

            nextButton.setRendered(true);
            prevButton.setRendered(true);
            finishButton.setRendered(false);

            break;
        case 1:
            if (proposerDisplay.getValue() == null) {
                String Message = "Select A Client";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));
                return null;

            }
            if (branchesDisplay.getValue() == null) {
                String Message = "Select A Branch";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));
                return null;

            }

            if (frequencyOfPayment.getValue() == null) {
                String Message = "Select A Frequency of Cover";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));
                return null;

            }

            if (calculationType.getValue() == null) {
                String Message = "Select A Calculation Type";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));
                return null;

            }
            if (durationType.getValue() == null) {
                String Message = "Select A Duration Type";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));
                return null;

            }
            if (policyNUmberDisplay.getValue() == null) {
                String Message = "Generate A Policy Number";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));
                return null;

            }

            String Typ = (String)session.getAttribute("productType");
            if (Typ.equalsIgnoreCase("PENS")) {
                if (schemeeTypeDisplay.getValue() == null) {
                    GlobalCC.INFORMATIONREPORTING("Select A Scheme Type");
                    return null;

                }
                if (regNumberDisplay.getValue() == null &&
                    schemeeTypeDisplay.getValue().toString().equalsIgnoreCase("R")) {
                    GlobalCC.INFORMATIONREPORTING("Enter A Registration Number");
                    return null;

                }


            } else {
                //other validations here.
            }
            CreateNbEndorsement();

            //disables the premium mask button  for the pension products if it lacks group life rider
            if (GrpRider.equals("N") && prodType.equals("PENS")) {
                premMaskBut.setDisabled(true);
                maskDisplay.setValue(null);
                session.setAttribute("pmasCode", null);
            } else {
                premMaskBut.setDisabled(false);
            }
            basicDetailsTab.setRendered(false);
            policyDetailsTab.setRendered(false);
            agentPolicyPayTab.setRendered(true);
            coverTypeTab.setRendered(false);
            polDocsTab.setRendered(false);
            taxesTab.setRendered(false);
            provisionsTab.setRendered(false);
            membersTab.setRendered(false);
            catLimitTabs.setRendered(false);
            pensionsTab.setRendered(false);
            schoolFeesTab.setRendered(false);
            break;

        case 2:

            if (paymentMethodDisplay.getValue() == null) {
                String Message = "Select A Payment Method";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));
                return null;

            }

            if (agentsDisplay.getValue() == null) {
                String Message = "Select An Agent";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));
                return null;

            }

            if ((maskDisplay.getValue() == null) &&
                !(unitRateOption.getValue().toString().equalsIgnoreCase("RATE"))) {
                String Message = "Select A Premium Mask";
                if (!(GrpRider.equals("N") && prodType.equals("PENS"))) {
                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                  Message,
                                                                                  Message));
                    return null;
                }

            }
            /*if(commissionRateDisplay.getValue()==null){
          String Message = "Enter a Commission Rate";
          FacesContext.getCurrentInstance().addMessage(null,
                                                       new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                        Message,
                                                                        Message));
          return null;

        }*/
            String endrPay = (String)session.getAttribute("endrPayMethd");
            if (endrPay != "") {
                if (endrPay.equalsIgnoreCase("K")) {
                    if (checkOffDisplay.getValue() == null) {
                        String Message = "Select a Check off Institution";
                        FacesContext.getCurrentInstance().addMessage(null,
                                                                     new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                      Message,
                                                                                      Message));
                        return null;

                    }

                }
            }

            Typ = (String)session.getAttribute("productType");
            if (Typ.equalsIgnoreCase("PENS") || Typ.equalsIgnoreCase("ANN") ||
                Typ.equalsIgnoreCase("GRAT")) {
                basicDetailsTab.setRendered(false);
                policyDetailsTab.setRendered(false);
                agentPolicyPayTab.setRendered(false);
                coverTypeTab.setRendered(false);
                polDocsTab.setRendered(false);
                taxesTab.setRendered(false);
                provisionsTab.setRendered(false);
                membersTab.setRendered(false);
                catLimitTabs.setRendered(false);
                pensionsTab.setRendered(true);
                schoolFeesTab.setRendered(false);
                PageRender1 = 8;
                session.setAttribute("uwPageRender", PageRender1);
            } else {

                ShowPolicyCovers();
                basicDetailsTab.setRendered(false);
                policyDetailsTab.setRendered(false);
                agentPolicyPayTab.setRendered(false);
                taxesTab.setRendered(false);
                provisionsTab.setRendered(false);
                coverTypeTab.setRendered(true);
                polDocsTab.setRendered(false);
                provisionsTab.setRendered(false);
                membersTab.setRendered(false);
                catLimitTabs.setRendered(false);
                pensionsTab.setRendered(false);
                schoolFeesTab.setRendered(false);
            }
            break;
        case 3:

            String Covers = (String)session.getAttribute("coversAvail");
            if (Covers.equalsIgnoreCase("N")) {
                //Check for Pension Product...
                String ProductTyp1 =
                    (String)session.getAttribute("productType");
                if (ProductTyp1.equalsIgnoreCase("PENS")) {

                } else {
                    GlobalCC.sysInformation("Select Atleast One Main Cover");
                    return null;
                }
            }

            session.setAttribute("PCT_CODE", null);
            session.setAttribute("CVT_CODE", null);
            productCoverDropBox.setValue(null);

            PopulateTaxes();
            //ShowPolicyTaxes();

            basicDetailsTab.setRendered(false);
            policyDetailsTab.setRendered(false);
            agentPolicyPayTab.setRendered(false);
            taxesTab.setRendered(true);
            provisionsTab.setRendered(false);
            coverTypeTab.setRendered(false);
            polDocsTab.setRendered(false);
            provisionsTab.setRendered(false);
            membersTab.setRendered(false);
            catLimitTabs.setRendered(false);
            pensionsTab.setRendered(false);
            schoolFeesTab.setRendered(false);
            break;
        case 4:

            ShowPolicyProvisions();

            basicDetailsTab.setRendered(false);
            policyDetailsTab.setRendered(false);
            agentPolicyPayTab.setRendered(false);
            taxesTab.setRendered(false);
            provisionsTab.setRendered(true);
            coverTypeTab.setRendered(false);
            polDocsTab.setRendered(false);
            provisionsTab.setRendered(false);
            membersTab.setRendered(false);
            catLimitTabs.setRendered(false);
            pensionsTab.setRendered(false);
            schoolFeesTab.setRendered(false);
            break;
        case 5:
            Typ = (String)session.getAttribute("productType");
            //System.out.println("Where is love to be found");
            if ((Typ.equalsIgnoreCase("PENS") &&
                 GrpRider.equalsIgnoreCase("N")) ||
                Typ.equalsIgnoreCase("ANN") || Typ.equalsIgnoreCase("GRAT")) {

                ShowMembers();
                basicDetailsTab.setRendered(false);
                policyDetailsTab.setRendered(false);
                agentPolicyPayTab.setRendered(false);
                taxesTab.setRendered(false);
                provisionsTab.setRendered(false);
                coverTypeTab.setRendered(false);
                polDocsTab.setRendered(false);
                provisionsTab.setRendered(false);
                membersTab.setRendered(true);
                pensionsTab.setRendered(false);
                schoolFeesTab.setRendered(false);
                if(render.isMickVisible()){
                catLimitTabs.setRendered(true); 
                membersTab.setRendered(false);
                nextButton.setRendered(true);
                prevButton.setRendered(true);
                finishButton.setRendered(false);
                }else{
                  nextButton.setRendered(false);
                  prevButton.setRendered(true);
                  finishButton.setRendered(true);
                  PageRender1 = 7;
                }
                
                
                session.setAttribute("uwPageRender", PageRender1);
                

            } else {
                basicDetailsTab.setRendered(false);
                policyDetailsTab.setRendered(false);
                agentPolicyPayTab.setRendered(false);
                taxesTab.setRendered(false);
                provisionsTab.setRendered(false);
                coverTypeTab.setRendered(false);
                polDocsTab.setRendered(false);
                provisionsTab.setRendered(false);
                membersTab.setRendered(false);
                catLimitTabs.setRendered(true);
                pensionsTab.setRendered(false);
                if (Typ.equalsIgnoreCase("EDUC")) {
                    schoolFeesTab.setRendered(true);
                } else {
                    schoolFeesTab.setRendered(false);
                }
                String Value = Validate_Policy_Product();
                if (Value == null || Value == "F") {
                    prdTypeLabel.setValue("[Months]");
                } else {
                    prdTypeLabel.setValue(Value);
                }

                nextButton.setRendered(true);
                prevButton.setRendered(true);
                finishButton.setRendered(false);
            }

            break;
        case 6:
            String ProductTyp =
                (String)this.session.getAttribute("productType");
            String catExist = ValidateCategories();
            if ((ProductTyp.equals("LOAN") || ProductTyp.equals("EARN") ||
                 ProductTyp.equals("FUNE")) && CalcType.equals("D")) {
                if (catExist.equals("N")) {
                    GlobalCC.INFORMATIONREPORTING("Please add categories");
                    return null;
                }
            }
            basicDetailsTab.setRendered(false);
            policyDetailsTab.setRendered(false);
            agentPolicyPayTab.setRendered(false);
            taxesTab.setRendered(false);
            provisionsTab.setRendered(false);
            coverTypeTab.setRendered(false);
            polDocsTab.setRendered(true);
            provisionsTab.setRendered(false);
            membersTab.setRendered(false);
            catLimitTabs.setRendered(false);
            pensionsTab.setRendered(false);
            schoolFeesTab.setRendered(false);

            if (CalcType.equalsIgnoreCase("A")) {
                nextButton.setRendered(false);
                prevButton.setRendered(true);
                finishButton.setRendered(true);
            } else {
                nextButton.setRendered(true);
                prevButton.setRendered(true);
                finishButton.setRendered(false);
            }
            break;
        case 7:
            ShowMembers();
            basicDetailsTab.setRendered(false);
            policyDetailsTab.setRendered(false);
            agentPolicyPayTab.setRendered(false);
            taxesTab.setRendered(false);
            provisionsTab.setRendered(false);
            coverTypeTab.setRendered(false);
            polDocsTab.setRendered(false);
            provisionsTab.setRendered(false);
            membersTab.setRendered(true);
            pensionsTab.setRendered(false);
            schoolFeesTab.setRendered(false);

            nextButton.setRendered(false);
            prevButton.setRendered(true);
            finishButton.setRendered(true);
            break;
        case 9:
            String Results = Update_Earn_Pensions();
            if (Results.equalsIgnoreCase("F")) {
                return null;
            }
            Typ = (String)session.getAttribute("productType");
            if ((Typ.equalsIgnoreCase("PENS") &&
                 GrpRider.equalsIgnoreCase("N")) ||
                Typ.equalsIgnoreCase("ANN") || Typ.equalsIgnoreCase("GRAT")) {
                PopulateTaxes();
                //ShowPolicyTaxes();

                basicDetailsTab.setRendered(false);
                policyDetailsTab.setRendered(false);
                agentPolicyPayTab.setRendered(false);
                taxesTab.setRendered(true);
                provisionsTab.setRendered(false);
                coverTypeTab.setRendered(false);
                polDocsTab.setRendered(false);
                provisionsTab.setRendered(false);
                membersTab.setRendered(false);
                catLimitTabs.setRendered(false);
                pensionsTab.setRendered(false);
                schoolFeesTab.setRendered(false);
                PageRender1 = 3;
                session.setAttribute("uwPageRender", PageRender1);
                break;

            } else {

                ShowPolicyCovers();
                basicDetailsTab.setRendered(false);
                policyDetailsTab.setRendered(false);
                agentPolicyPayTab.setRendered(false);
                taxesTab.setRendered(false);
                provisionsTab.setRendered(false);
                coverTypeTab.setRendered(true);
                polDocsTab.setRendered(false);
                provisionsTab.setRendered(false);
                membersTab.setRendered(false);
                catLimitTabs.setRendered(false);
                pensionsTab.setRendered(false);
                schoolFeesTab.setRendered(false);
                PageRender1 = 2;
                session.setAttribute("uwPageRender", PageRender1);

            }

            break;

        }
        PageRender1 = (Integer)session.getAttribute("uwPageRender");
        if (PageRender1 == 7) {
            PageRender1++;
            session.setAttribute("uwPageRender", PageRender1);
        } else {
            if (PageRender1 == 3) {
                PageRender1 = PageRender1 + 2;
                session.setAttribute("uwPageRender", PageRender1);
            } else {
                PageRender1++;
                session.setAttribute("uwPageRender", PageRender1);
            }
        }

        return null;
    }

    public String CmdPrev() {
        String GrpRider = null;
        String CalcType = null;
        if (groupLifeRider.getValue() == null) {
            GrpRider = null;
        } else {
            GrpRider = groupLifeRider.getValue().toString();
        }
        Integer PageRender1 = (Integer)session.getAttribute("uwPageRender");
        if (PageRender1 == 0) {
            //do nothing
        } else if (PageRender1 == 6) {
            PageRender1 = PageRender1 - 2;
            session.setAttribute("uwPageRender", PageRender1);
        } else {
            PageRender1 = PageRender1 - 1;
            session.setAttribute("uwPageRender", PageRender1);
        }

        if (calculationType.getValue() == null) {
            CalcType = null;
        } else {
            CalcType = calculationType.getValue().toString();
        }
        PageRender1 = (Integer)session.getAttribute("uwPageRender");
        switch (PageRender1) {
        case 0:
            basicDetailsTab.setRendered(true);
            policyDetailsTab.setRendered(false);
            agentPolicyPayTab.setRendered(false);
            coverTypeTab.setRendered(false);
            polDocsTab.setRendered(false);
            taxesTab.setRendered(false);
            provisionsTab.setRendered(false);
            membersTab.setRendered(false);
            catLimitTabs.setRendered(false);
            pensionsTab.setRendered(false);
            schoolFeesTab.setRendered(false);

            nextButton.setRendered(true);
            prevButton.setRendered(false);
            finishButton.setRendered(false);

            break;
        case 1:
            basicDetailsTab.setRendered(false);
            policyDetailsTab.setRendered(true);
            agentPolicyPayTab.setRendered(false);
            coverTypeTab.setRendered(false);
            polDocsTab.setRendered(false);
            taxesTab.setRendered(false);
            provisionsTab.setRendered(false);
            membersTab.setRendered(false);
            catLimitTabs.setRendered(false);
            pensionsTab.setRendered(false);
            schoolFeesTab.setRendered(false);
            break;
        case 2:
            basicDetailsTab.setRendered(false);
            policyDetailsTab.setRendered(false);
            agentPolicyPayTab.setRendered(true);
            taxesTab.setRendered(false);
            provisionsTab.setRendered(false);
            coverTypeTab.setRendered(false);
            polDocsTab.setRendered(false);
            provisionsTab.setRendered(false);
            membersTab.setRendered(false);
            catLimitTabs.setRendered(false);
            pensionsTab.setRendered(false);
            schoolFeesTab.setRendered(false);
            break;
        case 3:
            String Typ = (String)session.getAttribute("productType");
            if ((Typ.equalsIgnoreCase("PENS") &&
                 GrpRider.equalsIgnoreCase("N")) ||
                Typ.equalsIgnoreCase("ANN") || Typ.equalsIgnoreCase("GRAT")) {
                basicDetailsTab.setRendered(false);
                policyDetailsTab.setRendered(false);
                agentPolicyPayTab.setRendered(false);
                coverTypeTab.setRendered(false);
                polDocsTab.setRendered(false);
                taxesTab.setRendered(false);
                provisionsTab.setRendered(false);
                membersTab.setRendered(false);
                catLimitTabs.setRendered(false);
                pensionsTab.setRendered(true);
                schoolFeesTab.setRendered(false);

            } else {
                basicDetailsTab.setRendered(false);
                policyDetailsTab.setRendered(false);
                agentPolicyPayTab.setRendered(false);
                taxesTab.setRendered(false);
                provisionsTab.setRendered(false);
                coverTypeTab.setRendered(true);
                polDocsTab.setRendered(false);
                provisionsTab.setRendered(false);
                membersTab.setRendered(false);
                catLimitTabs.setRendered(false);
                pensionsTab.setRendered(false);
                schoolFeesTab.setRendered(false);

            }

            break;
        case 4:
            basicDetailsTab.setRendered(false);
            policyDetailsTab.setRendered(false);
            agentPolicyPayTab.setRendered(false);
            taxesTab.setRendered(true);
            provisionsTab.setRendered(false);
            coverTypeTab.setRendered(false);
            polDocsTab.setRendered(false);
            provisionsTab.setRendered(false);
            membersTab.setRendered(false);
            catLimitTabs.setRendered(false);
            pensionsTab.setRendered(false);
            schoolFeesTab.setRendered(false);
            // PageRender = 5;
            break;
        case 5:
            basicDetailsTab.setRendered(false);
            policyDetailsTab.setRendered(false);
            agentPolicyPayTab.setRendered(false);
            taxesTab.setRendered(false);
            provisionsTab.setRendered(true);
            coverTypeTab.setRendered(false);
            polDocsTab.setRendered(false);
            provisionsTab.setRendered(false);
            membersTab.setRendered(false);
            catLimitTabs.setRendered(false);
            pensionsTab.setRendered(false);
            schoolFeesTab.setRendered(false);
            break;
        case 6:
            basicDetailsTab.setRendered(false);
            policyDetailsTab.setRendered(false);
            agentPolicyPayTab.setRendered(false);
            taxesTab.setRendered(false);
            provisionsTab.setRendered(false);
            coverTypeTab.setRendered(false);
            polDocsTab.setRendered(false);
            provisionsTab.setRendered(false);
            membersTab.setRendered(false);
            catLimitTabs.setRendered(true);
            pensionsTab.setRendered(false);
            String Type2 = (String)session.getAttribute("productType");
            if (Type2.equalsIgnoreCase("EDUC")) {
                schoolFeesTab.setRendered(true);
            } else {
                schoolFeesTab.setRendered(false);
            }

            nextButton.setRendered(true);
            prevButton.setRendered(true);
            finishButton.setRendered(false);
            break;
        case 7:
            Typ = (String)session.getAttribute("productType");
            if ((Typ.equalsIgnoreCase("PENS") &&
                 GrpRider.equalsIgnoreCase("N")) ||
                Typ.equalsIgnoreCase("ANN") || Typ.equalsIgnoreCase("GRAT")) {
                basicDetailsTab.setRendered(false);
                policyDetailsTab.setRendered(false);
                agentPolicyPayTab.setRendered(false);
                taxesTab.setRendered(true);
                provisionsTab.setRendered(false);
                coverTypeTab.setRendered(false);
                polDocsTab.setRendered(false);
                provisionsTab.setRendered(false);
                membersTab.setRendered(false);
                catLimitTabs.setRendered(false);
                pensionsTab.setRendered(false);
                schoolFeesTab.setRendered(false);
                PageRender1 = 4;
                session.setAttribute("uwPageRender", PageRender1);

                nextButton.setRendered(true);
                prevButton.setRendered(true);
                finishButton.setRendered(false);

            } else {
                basicDetailsTab.setRendered(false);
                policyDetailsTab.setRendered(false);
                agentPolicyPayTab.setRendered(false);
                taxesTab.setRendered(false);
                provisionsTab.setRendered(false);
                coverTypeTab.setRendered(false);
                polDocsTab.setRendered(true);
                provisionsTab.setRendered(false);
                membersTab.setRendered(false);
                catLimitTabs.setRendered(false);
                pensionsTab.setRendered(false);
                schoolFeesTab.setRendered(false);

                if (CalcType.equalsIgnoreCase("A")) {
                    nextButton.setRendered(false);
                    prevButton.setRendered(true);
                    finishButton.setRendered(true);
                } else {
                    nextButton.setRendered(true);
                    prevButton.setRendered(true);
                    finishButton.setRendered(false);
                }
            }


            break;

        case 8:
            basicDetailsTab.setRendered(false);
            policyDetailsTab.setRendered(false);
            agentPolicyPayTab.setRendered(false);
            taxesTab.setRendered(false);
            provisionsTab.setRendered(false);
            coverTypeTab.setRendered(false);
            polDocsTab.setRendered(false);
            provisionsTab.setRendered(false);
            membersTab.setRendered(true);
            catLimitTabs.setRendered(false);
            schoolFeesTab.setRendered(false);
            pensionsTab.setRendered(false);

            nextButton.setRendered(true);
            prevButton.setRendered(true);
            finishButton.setRendered(false);
            break;
        case 9:
            basicDetailsTab.setRendered(false);
            policyDetailsTab.setRendered(false);
            agentPolicyPayTab.setRendered(false);
            coverTypeTab.setRendered(false);
            polDocsTab.setRendered(false);
            taxesTab.setRendered(false);
            provisionsTab.setRendered(false);
            membersTab.setRendered(false);
            catLimitTabs.setRendered(false);
            pensionsTab.setRendered(true);
            schoolFeesTab.setRendered(false);
            PageRender1 = 3;
            session.setAttribute("uwPageRender", PageRender1);

        }

        return null;
    }

    public String Validate_Policy_Product() {
        Connection conn = null;
        String Value = "F";
        CallableStatement stmt = null;
        try {
            conn = new DBConnector().getDatabaseConn();
            String dobQuery =
                "begin ? := LMS_WEB_PKG_GRP_UW.product_earn_type(?,?); end;";

            stmt = conn.prepareCall(dobQuery);
            stmt.registerOutParameter(1, OracleTypes.VARCHAR);
            stmt.setBigDecimal(2,
                               (BigDecimal)session.getAttribute("policyCode"));
            stmt.setString(3, "P");
            stmt.execute();

            Value = stmt.getString(1);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(null, stmt, conn);
        }
        return Value;
    }

    public String ValidateCategories() {
        Connection conn = null;
        String Value = "N";
        try {
            conn = new DBConnector().getDatabaseConn();
            String dobQuery =
                "begin ? := LMS_WEB_PKG_GRP_UW.validate_category(?,?); end;";
            CallableStatement stmt = null;
            stmt = conn.prepareCall(dobQuery);
            stmt.registerOutParameter(1, 12);
            stmt.setBigDecimal(2,
                               (BigDecimal)this.session.getAttribute("policyCode"));
            stmt.setString(3, "P");
            stmt.execute();

            Value = stmt.getString(1);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return Value;
    }

    public String AttachProducts() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findProductsIterator");
        RowKeySet set = productsLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
            undProdDisplay.setValue(r.getAttribute("prodDesc"));
            session.setAttribute("ProductCode", r.getAttribute("prodCode"));
            session.setAttribute("productType", r.getAttribute("prodType"));
            session.setAttribute("depCovered",
                                 r.getAttribute("PROD_DEPENDT_COVERED2"));
        }
        return null;
    }

    public String AttachAccessGroups() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findAccessGroupsIterator");
        RowKeySet set = accessGrpTable.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            accessGrpDisplay.setValue(r.getAttribute("LPAG_DESC"));
            accessGrpDisplay1.setValue(r.getAttribute("LPAG_DESC"));
            session.setAttribute("lpagCode", r.getAttribute("LPAG_CODE"));
            session.setAttribute("lpagDesc", r.getAttribute("LPAG_DESC"));

        }
        return null;
    }

    public String AttachAccessGroups1() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findAccessGroupsIterator");
        RowKeySet set = accessGrpTable1.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            accessGrpDisplay1.setValue(r.getAttribute("LPAG_DESC"));
            session.setAttribute("catlpagCode", r.getAttribute("LPAG_CODE"));

        }
        return null;
    }

    public void setProductsLOV(RichTable productsLOV) {
        this.productsLOV = productsLOV;
    }

    public RichTable getProductsLOV() {
        return productsLOV;
    }

    public void setProductDisplay(RichInputText productDisplay) {
        this.productDisplay = productDisplay;
    }

    public RichInputText getProductDisplay() {
        return productDisplay;
    }

    public void setContraPolicyNoDisplay(RichInputText contraPolicyNoDisplay) {
        this.contraPolicyNoDisplay = contraPolicyNoDisplay;
    }

    public RichInputText getContraPolicyNoDisplay() {
        return contraPolicyNoDisplay;
    }

    public void setContraPoliciesLOV(RichTable contraPoliciesLOV) {
        this.contraPoliciesLOV = contraPoliciesLOV;
    }

    public RichTable getContraPoliciesLOV() {
        return contraPoliciesLOV;
    }

    public String AttachContraPolicies() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("ContraPoliciesIterator");
        RowKeySet set = contraPoliciesLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
            contraPolicyNoDisplay.setValue(r.getAttribute("POL_POLICY_NO"));


        }
        return null;
    }

    public void setPolicyEffectiveDateDisplay(RichInputDate policyEffectiveDateDisplay) {
        this.policyEffectiveDateDisplay = policyEffectiveDateDisplay;
    }

    public RichInputDate getPolicyEffectiveDateDisplay() {
        return policyEffectiveDateDisplay;
    }

    public void setDocRefNoDisplay(RichInputText docRefNoDisplay) {
        this.docRefNoDisplay = docRefNoDisplay;
    }

    public RichInputText getDocRefNoDisplay() {
        return docRefNoDisplay;
    }

    public String CreateTransactions() {
        String ReturnValue = "Failure";
        CallableStatement cstmt = null;
        BigDecimal Produ = (BigDecimal)session.getAttribute("ProductCode");
        if (Produ == null) {

            GlobalCC.sysInformation("Select Product");
            return ReturnValue;
        }
        BigDecimal prposr = (BigDecimal)session.getAttribute("prpCode");
        if (prposr == null) {
            GlobalCC.sysInformation("Select A Client");
            return ReturnValue;
        }

        String transactionsQuery =
            "BEGIN LMS_WEB_PKG_GRP.create_new_trans(?,?,?,?,?);END;";
        Connection conn = new DBConnector().getDatabaseConn();
        try {
            cstmt = conn.prepareCall(transactionsQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("ProductCode"));
            cstmt.setString(2, "NB");
            cstmt.setString(3, "U");
            if (docRefNoDisplay.getValue() == null) {
                cstmt.setString(4, null);
            } else {
                cstmt.setString(4, docRefNoDisplay.getValue().toString());
            }
            cstmt.registerOutParameter(5, OracleTypes.INTEGER);
            if (policyEffectiveDateDisplay.getValue() == null) {
                session.setAttribute("policyEffectiveDate", null);

            } else {
                session.setAttribute("policyEffectiveDate",
                                     GlobalCC.parseDate(policyEffectiveDateDisplay.getValue().toString()));

            }
            cstmt.execute();
            session.setAttribute("transactionNumber", cstmt.getBigDecimal(5));
            conn.close();
            ReturnValue = "Success";
        }

        catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        } finally {
            GlobalCC.CloseConnections(null, cstmt, conn);
        }
        return ReturnValue;
    }

    public void setProposersLOV(RichTable proposersLOV) {
        this.proposersLOV = proposersLOV;
    }

    public RichTable getProposersLOV() {
        return proposersLOV;
    }

    public void setProposerDisplay(RichInputText proposerDisplay) {
        this.proposerDisplay = proposerDisplay;
    }

    public RichInputText getProposerDisplay() {
        return proposerDisplay;
    }

    public String AttachProposers() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findProposersIterator");
        RowKeySet set = proposersLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
            proposerDisplay.setValue(r.getAttribute("CLIENT"));
            //LOVCC.prpCode=(BigDecimal)r.getAttribute("PRP_CODE");
            session.setAttribute("prpCode", r.getAttribute("PRP_CODE"));
            //LOVCC.OccupationCode=(BigDecimal)r.getAttribute("GCO_CODE");
            session.setAttribute("OccupationCode", r.getAttribute("GCO_CODE"));
            session.setAttribute("ClientCode",
                                 r.getAttribute("prp_clnt_code"));

        }
        return null;
    }

    public void setBranchesDisplay(RichInputText branchesDisplay) {
        this.branchesDisplay = branchesDisplay;
    }

    public RichInputText getBranchesDisplay() {
        return branchesDisplay;
    }

    public void setBranchesLOV(RichTable branchesLOV) {
        this.branchesLOV = branchesLOV;
    }

    public RichTable getBranchesLOV() {
        return branchesLOV;
    }

    public String AttachBranches() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findBranchesIterator");
        RowKeySet set = branchesLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
            branchesDisplay.setValue(r.getAttribute("BRN_NAME"));
            //LOVCC.branchCode=(BigDecimal)r.getAttribute("BRN_CODE");
            session.setAttribute("branchCode", r.getAttribute("BRN_CODE"));


        }
        return null;
    }


  public String AssignSBUundwrt() {
         DCIteratorBinding dciter =
             ADFUtils.findIterator("FindSBUDetailsIterator");
         RowKeySet set = this.SBUOneLOV1.getSelectedRowKeys();
         Iterator rowKeySetIter = set.iterator();

         while (rowKeySetIter.hasNext()) {
             List l = (List)rowKeySetIter.next();
             Key key = (Key)l.get(0);
             dciter.setCurrentRowWithKey(key.toStringFormat(true));
             Row r = dciter.getCurrentRow();

             this.session.setAttribute("coverageAreaCode", r.getAttribute("COVERAGE_AREA_CODE"));
             //this.session.setAttribute("COVERAGE_AREA", r.getAttribute("COVERAGE_AREA"));
             this.session.setAttribute("spokeCode", r.getAttribute("SPOKE_CODE"));
             //this.session.setAttribute("spoke", r.getAttribute("SPOKE"));
             this.session.setAttribute("sbuCode", r.getAttribute("SBU_CODE"));
             //this.session.setAttribute("sbuName", r.getAttribute("SBU"));
            
             this.sbuOneDisplay.setValue(r.getAttribute("COVERAGE_AREA"));
         }

         return null;
     }
  public String AssignLocUndwrt() {
         DCIteratorBinding dciter =
             ADFUtils.findIterator("FindOrgLocationsDetailsIterator");
         RowKeySet set = this.locOneLOV.getSelectedRowKeys();
         Iterator rowKeySetIter = set.iterator();

         while (rowKeySetIter.hasNext()) {
             List l = (List)rowKeySetIter.next();
             Key key = (Key)l.get(0);
             dciter.setCurrentRowWithKey(key.toStringFormat(true));
             Row r = dciter.getCurrentRow();

              //this.session.setAttribute("location", r.getAttribute("LOCATION"));
             this.session.setAttribute("locationCode", r.getAttribute("LOCATION_CODE"));
             //this.session.setAttribute("organization", r.getAttribute("ORGANIZATION"));
        
             this.locOneDisplay.setValue(r.getAttribute("LOCATION"));
         }

         return null;
     }

    public void GetFrequencyOfPayment(ValueChangeEvent valueChangeEvent) {
        //LOVCC.frequencyOfPayment=frequencyOfPayment.getValue().toString();
        session.setAttribute("frequencyOfPayment",
                             frequencyOfPayment.getValue().toString());
    }

    public void setFrequencyOfPayment(RichSelectOneChoice frequencyOfPayment) {
        this.frequencyOfPayment = frequencyOfPayment;
    }

    public RichSelectOneChoice getFrequencyOfPayment() {
        return frequencyOfPayment;
    }

    public void GetCalcType(ValueChangeEvent valueChangeEvent) {
        if (calculationType.getValue() == null) {
            //LOVCC.calculationType = null;
            session.setAttribute("calculationType", null);
        } else {
            //LOVCC.calculationType=calculationType.getValue().toString();
            session.setAttribute("calculationType",
                                 calculationType.getValue().toString());
        }
        String CalcType = (String)session.getAttribute("calculationType");
        if (CalcType.equalsIgnoreCase("A")) {
            saLabel.setRendered(true);
            sumAssuredDisplay.setRendered(true);
            reinsurancePanel.setRendered(true);
            avANBLabel.setRendered(true);
            avANB.setRendered(true);
        } else {
            saLabel.setRendered(false);
            sumAssuredDisplay.setRendered(false);
            reinsurancePanel.setRendered(false);
            avANBLabel.setRendered(true);
            avANB.setRendered(true);
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(saLabel);
        AdfFacesContext.getCurrentInstance().addPartialTarget(sumAssuredDisplay);
        AdfFacesContext.getCurrentInstance().addPartialTarget(reinsurancePanel);
        AdfFacesContext.getCurrentInstance().addPartialTarget(avANBLabel);
        AdfFacesContext.getCurrentInstance().addPartialTarget(avANB);
    }

    public void setCalculationType(RichSelectOneChoice calculationType) {
        this.calculationType = calculationType;
    }

    public RichSelectOneChoice getCalculationType() {
        return calculationType;
    }

    public void GetAboveRetireAge(ValueChangeEvent valueChangeEvent) {
        if (aboveRetireAge.getValue() == null) {
            //LOVCC.retirementAge=null;
            session.setAttribute("retirementAge", null);
        } else {
            //LOVCC.retirementAge=aboveRetireAge.getValue().toString();
            session.setAttribute("retirementAge",
                                 aboveRetireAge.getValue().toString());
        }

    }

    public void setAboveRetireAge(RichSelectOneChoice aboveRetireAge) {
        this.aboveRetireAge = aboveRetireAge;
    }

    public RichSelectOneChoice getAboveRetireAge() {
        return aboveRetireAge;
    }

    public void GetDependentsCovered(ValueChangeEvent valueChangeEvent) {
        if (dependentsCovered.getValue() == null) {
            session.setAttribute("depCovered", null);
        } else {
            session.setAttribute("depCovered",
                                 dependentsCovered.getValue().toString());
        }

    }

    public void setDependentsCovered(RichSelectOneChoice dependentsCovered) {
        this.dependentsCovered = dependentsCovered;
    }

    public RichSelectOneChoice getDependentsCovered() {
        return dependentsCovered;
    }

    public void GetDurationType(ValueChangeEvent valueChangeEvent) {
        weTLabel.setRendered(false);
        wetDate.setRendered(false);
        session.setAttribute("newWETDate", null);
        wetDate.setValue(null);

        if (durationType.getValue() == null) {
            session.setAttribute("policyDurationType", null);
        } else {
            session.setAttribute("policyDurationType",
                                 durationType.getValue().toString());

            String Type2 = (String)session.getAttribute("productType");
            if (Type2 == null) {
                //do nothing...
            } else if (Type2.equalsIgnoreCase("EDUC")) {

                if (durationType.getValue().toString().equalsIgnoreCase("A")) {
                    durationTermType.setValue("ALL");
                    durationTermType.setDisabled(true);
                } else {
                    durationTermType.setValue(null);
                    durationTermType.setDisabled(false);
                }
            } else {
                //do nothing...
            }

            if (durationType.getValue().toString().equalsIgnoreCase("C")) {
                //Render Popup
                weTLabel.setRendered(true);
                wetDate.setRendered(true);
                wetDate.setValue(null);
            }
        }
    }

    public void setDurationType(RichSelectOneChoice durationType) {
        this.durationType = durationType;
    }

    public RichSelectOneChoice getDurationType() {
        return durationType;
    }

    public void setGroupLifeRider(RichSelectOneChoice groupLifeRider) {
        this.groupLifeRider = groupLifeRider;
    }

    public RichSelectOneChoice getGroupLifeRider() {
        return groupLifeRider;
    }

    public void GetGroupLifeRider(ValueChangeEvent valueChangeEvent) {
        if (groupLifeRider.getValue() == null) {
            //LOVCC.groupLifeRider="N";
            session.setAttribute("groupLifeRider", "N");
        }
        {
            //LOVCC.groupLifeRider=groupLifeRider.getValue().toString();
            session.setAttribute("groupLifeRider",
                                 groupLifeRider.getValue().toString());
        }

    }

    public void setSchemeeTypeDisplay(RichSelectOneChoice schemeeTypeDisplay) {
        this.schemeeTypeDisplay = schemeeTypeDisplay;
    }

    public RichSelectOneChoice getSchemeeTypeDisplay() {
        return schemeeTypeDisplay;
    }

    public void GetSchemeType(ValueChangeEvent valueChangeEvent) {
        if (schemeeTypeDisplay.getValue() == null) {
            //LOVCC.pensSchemeType=null;
            session.setAttribute("pensSchemeType", null);
        } else {
            //LOVCC.pensSchemeType=schemeeTypeDisplay.getValue().toString();
            session.setAttribute("pensSchemeType",
                                 schemeeTypeDisplay.getValue().toString());

            if (schemeeTypeDisplay.getValue().toString().equalsIgnoreCase("R")) {
                //Do Nothing.
            } else {
                regNumberDisplay.setValue(null);
                regDate.setValue(null);
            }
        }

    }

    public void setRegNumberDisplay(RichInputText regNumberDisplay) {
        this.regNumberDisplay = regNumberDisplay;
    }

    public RichInputText getRegNumberDisplay() {
        return regNumberDisplay;
    }

    public void setTaxComplianceDisplay(RichSelectOneChoice taxComplianceDisplay) {
        this.taxComplianceDisplay = taxComplianceDisplay;
    }

    public RichSelectOneChoice getTaxComplianceDisplay() {
        return taxComplianceDisplay;
    }

    public void GetTaxCompliance(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
    }

    public void setPolicyNUmberDisplay(RichInputText policyNUmberDisplay) {
        this.policyNUmberDisplay = policyNUmberDisplay;
    }

    public RichInputText getPolicyNUmberDisplay() {
        return policyNUmberDisplay;
    }

    public void setGeneratePolicyNumber(RichCommandButton generatePolicyNumber) {
        this.generatePolicyNumber = generatePolicyNumber;
    }

    public RichCommandButton getGeneratePolicyNumber() {
        return generatePolicyNumber;
    }

    public String reusePolicyNoGeneration() {
        String Result = "F";
        String generateQuery =
            "BEGIN LMS_WEB_PKG_GRP.createPolicyRecord(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);END;";
        Connection conn = new DBConnector().getDatabaseConn();
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall(generateQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("ProductCode")); //v_prod_code NUMBER,
            System.out.println(session.getAttribute("ProductCode"));
            cstmt.setString(2,
                            (String)session.getAttribute("policyEffectiveDate")); //v_effective_date DATE,
            System.out.println(session.getAttribute("policyEffectiveDate"));
            cstmt.setBigDecimal(3,
                                (BigDecimal)session.getAttribute("prpCode")); //v_prp_code NUMBER,
            System.out.println(session.getAttribute("prpCode"));
            cstmt.setBigDecimal(4, null); //v_bra_code NUMBER,
            cstmt.setString(5, null); //v_freq_of_payment VARCHAR2,
            cstmt.setString(6, null); //v_pol_covers VARCHAR2,
            cstmt.setString(7, null); //v_grp_life_rider VARCHAR2,
            cstmt.setString(8, null); //v_calc_type VARCHAR2,
            cstmt.setString(9, null); //v_duration_type VARCHAR2,
            cstmt.setString(10, null); //v_scheme_type VARCHAR2,
            cstmt.setString(11, null); //v_registration_no VARCHAR2,
            cstmt.setString(12, "Y"); //v_reuse_policy_no VARCHAR2,
            cstmt.setString(13, null); //v_savings_rider VARCHAR2,
            cstmt.setString(14, null); //v_os_loan_calc            VARCHAR2,
            cstmt.registerOutParameter(15,
                                       OracleTypes.INTEGER); //v_pol_code OUT NUMBER,
            cstmt.registerOutParameter(16,
                                       OracleTypes.VARCHAR); //v_pol_policy_no OUT VARCHAR2
            cstmt.setString(17, null);
            cstmt.setString(18, null);
            cstmt.setBigDecimal(19,
                                (BigDecimal)session.getAttribute("reusePolCode")); //v_reuse_pol_code NUMBER DEFAULT NULL,
            cstmt.setBigDecimal(20,
                                (BigDecimal)session.getAttribute("transactionNumber")); //v_reuse_pol_code NUMBER DEFAULT NULL,
            cstmt.registerOutParameter(21,
                                       OracleTypes.DECIMAL); //v_pol_code OUT NUMBER,

            cstmt.execute();
            //LOVCC.policyCode=cstmt.getBigDecimal(15);
            session.setAttribute("policyCode", cstmt.getBigDecimal(15));
            //LOVCC.policyNumber=cstmt.getString(16);
            session.setAttribute("policyNumber", cstmt.getString(16));

            if (reuseCbox.isSelected()) {
                session.setAttribute("endorsementCode",
                                     cstmt.getBigDecimal(21));
            }
            Result = "S";

            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(null, cstmt, conn);
        }
        return Result;
    }

    public String PolicyNumberGeneration() {
        String generateQuery =
            "BEGIN LMS_WEB_PKG_GRP.createpolicyrecord(?,?,?,?,?,?,?,?,?,?,?,?,?," +
            "?,?,?,?,?,?,?,?,?,?,?,?,?,?);END;";
        Connection conn = new DBConnector().getDatabaseConn();
        CallableStatement cstmt = null;
        try {
            String Umbrella = (String)session.getAttribute("umbrellaCover");
            if (Umbrella == null) {
                //do nothing...
            } else if (Umbrella.equalsIgnoreCase("Y")) {
                if (umbrellaDurationType.getValue() == null) {
                    GlobalCC.INFORMATIONREPORTING("Select An Umbrella Duration Type.");
                    return null;
                }
            }

            cstmt = conn.prepareCall(generateQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("ProductCode")); //v_prod_code NUMBER,
            System.out.println(session.getAttribute("ProductCode"));
            cstmt.setString(2,
                            (String)session.getAttribute("policyEffectiveDate")); //v_effective_date DATE,
            System.out.println(session.getAttribute("policyEffectiveDate"));
            cstmt.setBigDecimal(3,
                                (BigDecimal)session.getAttribute("prpCode")); //v_prp_code NUMBER,
            System.out.println(session.getAttribute("prpCode"));
            cstmt.setBigDecimal(4,
                                (BigDecimal)session.getAttribute("branchCode")); //v_bra_code NUMBER,
            //System.out.println(LOVCC.branchCode);
            if (session.getAttribute("frequencyOfPayment") == null) {
                session.setAttribute("frequencyOfPayment", "A");
            }
            cstmt.setString(5,
                            (String)session.getAttribute("frequencyOfPayment")); //v_freq_of_payment VARCHAR2,
            cstmt.setString(6,
                            (String)session.getAttribute("depCovered")); //v_pol_covers VARCHAR2,
            cstmt.setString(7,
                            (String)session.getAttribute("groupLifeRider")); //v_grp_life_rider VARCHAR2,
            if (session.getAttribute("calculationType") == null) {
                session.setAttribute("calculationType", "D");
            }
            cstmt.setString(8,
                            (String)session.getAttribute("calculationType")); //v_calc_type VARCHAR2,
            cstmt.setString(9, null); //v_duration_type VARCHAR2,
            if (session.getAttribute("pensSchemeType") == null) {
                session.setAttribute("pensSchemeType", "R");
            }
            cstmt.setString(10,
                            (String)session.getAttribute("pensSchemeType")); //v_scheme_type VARCHAR2,
            if (regNumberDisplay.getValue() == null) {
                cstmt.setString(11, null);
            } else {
                cstmt.setString(11,
                                regNumberDisplay.getValue().toString()); //v_registration_no VARCHAR2,
            }

            cstmt.setString(12, null); //v_reuse_policy_no VARCHAR2,
            cstmt.setString(13,
                            (String)session.getAttribute("savingsRider")); //v_savings_rider VARCHAR2,
            cstmt.setString(14,
                            (String)session.getAttribute("OSLoanCalculation")); //v_os_loan_calc            VARCHAR2,
            cstmt.registerOutParameter(15,
                                       OracleTypes.INTEGER); //v_pol_code OUT NUMBER,
            cstmt.registerOutParameter(16,
                                       OracleTypes.VARCHAR); //v_pol_policy_no OUT VARCHAR2
            cstmt.setString(17, null);
            cstmt.setString(18, null);
            cstmt.setBigDecimal(19,
                                null); //v_reuse_pol_code NUMBER DEFAULT NULL,
            cstmt.setBigDecimal(20,
                                null); //v_reuse_pol_code NUMBER DEFAULT NULL,
            cstmt.registerOutParameter(21,
                                       OracleTypes.DECIMAL); //v_pol_code OUT NUMBER,
            if (session.getAttribute("lpagCode") == null) {
                session.setAttribute("lpagCode",
                                     session.getAttribute("DeftlpagCode"));
                session.setAttribute("lpagDesc",
                                     session.getAttribute("DeftlpagDesc"));
            } else {
                //proceed.
            }
            cstmt.setBigDecimal(22,
                                (BigDecimal)session.getAttribute("lpagCode"));
            if (umbrellaCbox.isSelected()) {
                cstmt.setString(23, "Y");
            } else {
                cstmt.setString(23, "N");
            }
            if (assigneeName.getValue() == null) {
                cstmt.setString(24, null);
            } else {
                cstmt.setString(24, assigneeName.getValue().toString());
            }
            if (assigneePhyAddr.getValue() == null) {
                cstmt.setString(25, null);
            } else {
                cstmt.setString(25, assigneePhyAddr.getValue().toString());
            }
            if (earnPrdType.getValue() != null) {
                cstmt.setString(26, earnPrdType.getValue().toString());
            } else {
                cstmt.setString(26, "A");
            }
        
            String Date = GlobalCC.checkNullValues(polSignDate.getValue());
            if (Date == null) {
                cstmt.setString(27, null);
            } else {
                if (Date.contains(":")) {
                    Date = GlobalCC.parseDate(Date);
                    cstmt.setString(27, Date);
                } else {
                    Date = GlobalCC.upDateParseDate(Date);
                    cstmt.setString(27, Date);
                }
            }

            cstmt.execute();

            session.setAttribute("policyCode", cstmt.getBigDecimal(15));
            session.setAttribute("policyNumber", cstmt.getString(16));
            policyNUmberDisplay.setValue(cstmt.getString(16));

            genPolNo.setDisabled(true);
            AdfFacesContext.getCurrentInstance().addPartialTarget(genPolNo);
            CreateNbEndorsement();
            conn.close();
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        } finally {
            GlobalCC.CloseConnections(null, cstmt, conn);
        }
        return null;
    }

    public String ShowAddCategories() {
        session.setAttribute("classTermLimCode", null);

        classTermDisplay.setValue(null);
        termFeeDisplay.setValue(null);
        ExtendedRenderKitService erkService =
            Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                               ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
                             "var hints = {autodismissNever:false}; " +
                             "AdfPage.PAGE.findComponent('" +
                             "lmsgroup:addClassesPopup" + "').show(hints);");
        return null;
    }

    public String EditCategoryClasses() {
        RowKeySet rowKeySet = classTermLimitsLOV.getSelectedRowKeys();
        if (!rowKeySet.iterator().hasNext()) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
            //return null;
        }

        Object key2 = rowKeySet.iterator().next();
        classTermLimitsLOV.setRowKey(key2);

        JUCtrlValueBinding r =
            (JUCtrlValueBinding)classTermLimitsLOV.getRowData();

        if (r == null) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
            //return null;
        }
        session.setAttribute("classTermLimCode", r.getAttribute("ctlCode"));
        termFeeDisplay.setValue(r.getAttribute("ctlFee"));
        classTermDisplay.setValue(r.getAttribute("categDesc"));

        ExtendedRenderKitService erkService =
            Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                               ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
                             "var hints = {autodismissNever:false}; " +
                             "AdfPage.PAGE.findComponent('" +
                             "lmsgroup:addClassesPopup" + "').show(hints);");
        return null;
    }

    public String AssignClassesCategories() {
        RowKeySet rowKeySet = classesCategoriesLOV.getSelectedRowKeys();
        if (!rowKeySet.iterator().hasNext()) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
            //return null;
        }

        Object key2 = rowKeySet.iterator().next();
        classesCategoriesLOV.setRowKey(key2);

        JUCtrlValueBinding r =
            (JUCtrlValueBinding)classesCategoriesLOV.getRowData();

        if (r == null) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
            //return null;
        }
        classTermDisplay.setValue(r.getAttribute("catDesc"));

        session.setAttribute("classCatCode", r.getAttribute("lcaCode"));

        ExtendedRenderKitService erkService =
            Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                               ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
                             "var hints = {autodismissNever:false}; " +
                             "AdfPage.PAGE.findComponent('" +
                             "lmsgroup:addClassesPopup" + "').show(hints);");
        return null;
    }

    public String SaveClassTermLimits() {
        String updateQuery =
            "BEGIN LMS_WEB_PKG_GRP.updateClassTermLimits(?,?,?,?,?);END;";
        Connection conn = null;
        CallableStatement cstmt = null;
        try {
            conn = new DBConnector().getDatabaseConn();
            cstmt = conn.prepareCall(updateQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("classTermLimCode"));
            cstmt.setBigDecimal(2,
                                (BigDecimal)session.getAttribute("endorsementCode"));
            cstmt.setBigDecimal(3,
                                (BigDecimal)session.getAttribute("classCatCode"));
            cstmt.setString(4, termFeeDisplay.getValue().toString());
            cstmt.setString(5, "P");
            // cstmt.setString(5, minClaimablePeriod.getValue().toString());

            cstmt.execute();
            conn.close();

            GlobalCC.INFORMATIONREPORTING("Record saved Successfully.");

            session.setAttribute("classTermLimCode", null);
            ADFUtils.findIterator("FindPolicyClassTermsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(classTermLimitsLOV);
            GlobalCC.hidePopup("lmsgroup:addClassesPopup");
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        } finally {
            GlobalCC.CloseConnections(null, cstmt, conn);
        }
        return null;
    }

    public String DeleteCategoryClasses() {
        RowKeySet rowKeySet = classTermLimitsLOV.getSelectedRowKeys();
        if (!rowKeySet.iterator().hasNext()) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
            //return null;
        }

        Object key2 = rowKeySet.iterator().next();
        classTermLimitsLOV.setRowKey(key2);

        JUCtrlValueBinding r =
            (JUCtrlValueBinding)classTermLimitsLOV.getRowData();

        if (r == null) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
            //return null;
        }
        session.setAttribute("classTermLimCode", r.getAttribute("ctlCode"));

        String authQuery =
            "BEGIN LMS_WEB_PKG_GRP.deleteClasstermLimits(?,?);END;";
        Connection conn = new DBConnector().getDatabaseConn();
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall(authQuery);

            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("classTermLimCode"));
            cstmt.setString(2, "P");
            cstmt.execute();
            conn.close();
            String Message = "Record deleted successfully.";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));


            session.setAttribute("classTermLimCode", null);
            ADFUtils.findIterator("FindPolicyClassTermsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(classTermLimitsLOV);
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        } finally {
            GlobalCC.CloseConnections(null, cstmt, conn);
        }
        return null;
    }

    public void setSavingsRiderDisplay(RichSelectOneChoice savingsRiderDisplay) {
        this.savingsRiderDisplay = savingsRiderDisplay;
    }

    public RichSelectOneChoice getSavingsRiderDisplay() {
        return savingsRiderDisplay;
    }

    public void GetSavingsRider(ValueChangeEvent valueChangeEvent) {
        if (savingsRiderDisplay.getValue() == null) {
            //LOVCC.savingsRider=null;
            session.setAttribute("savingsRider", null);
        } else {
            //LOVCC.savingsRider=savingsRiderDisplay.getValue().toString();
            session.setAttribute("savingsRider",
                                 savingsRiderDisplay.getValue().toString());
        }

    }

    public String CreateNbEndorsement() {
        String Success = "F";
        String nbQuery =
            "BEGIN LMS_WEB_PKG_GRP.createNBEndorsement(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);END;";
        Connection conn = new DBConnector().getDatabaseConn();
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall(nbQuery);
            if (reuseCbox.isSelected()) {
                cstmt.setString(1, "Y"); //v_reuse_policy VARCHAR2,
            } else {
                cstmt.setString(1, "N"); //v_reuse_policy VARCHAR2,
            }
            cstmt.setBigDecimal(2,
                                (BigDecimal)session.getAttribute("transactionNumber")); //v_trans_no NUMBER,
            cstmt.setBigDecimal(3,
                                (BigDecimal)session.getAttribute("policyCode")); //v_pol_code NUMBER,
            if (session.getAttribute("policyDurationType") == null) {
                session.setAttribute("policyDurationType", "A");
            }
            cstmt.setString(4,
                            (String)session.getAttribute("policyDurationType")); //v_duration_type VARCHAR2,
            cstmt.setBigDecimal(5,
                                (BigDecimal)session.getAttribute("reusePolCode")); //v_reuse_pol_code NUMBER DEFAULT NULL,
            cstmt.registerOutParameter(6,
                                       OracleTypes.INTEGER); //v_endr_code OUT NUMBER)*/
            if (durationTermType.getValue() == null) {
                cstmt.setString(7, null);
            } else {
                cstmt.setString(7, durationTermType.getValue().toString());
            }
            cstmt.setString(8, (String)session.getAttribute("newWETDate"));
            if (coinsCbox.isSelected()) {
                cstmt.setString(9, "Y");
            } else {
                cstmt.setString(9, "N");
            }
            cstmt.setString(10, null);
            if (umbrellaDurationType.getValue() == null) {
                cstmt.setString(11, null);
            } else {
                cstmt.setString(11,
                                umbrellaDurationType.getValue().toString());
            }

            if (totClaimPaid.getValue() == null) {
                cstmt.setBigDecimal(12, null);
            } else {
                BigDecimal claimPaid =
                    new BigDecimal(totClaimPaid.getValue().toString());
                cstmt.setBigDecimal(12, claimPaid);
            }
            if (totPremPaid.getValue() == null) {
                cstmt.setBigDecimal(13, null);
            } else {
                BigDecimal premPaid =
                    new BigDecimal(totPremPaid.getValue().toString());
                cstmt.setBigDecimal(13, premPaid);
            }
            if (lossDurationPeriod.getValue() == null) {
                cstmt.setBigDecimal(14, null);
            } else {
                BigDecimal lossDuration =
                    new BigDecimal(lossDurationPeriod.getValue().toString());
                cstmt.setBigDecimal(14, lossDuration);
            }
            cstmt.setBigDecimal(15,
                                (BigDecimal)session.getAttribute("pplCode"));
          cstmt.setBigDecimal(16,
                             (BigDecimal)this.session.getAttribute("sbuCode"));
          cstmt.setBigDecimal(17,
                            (BigDecimal)this.session.getAttribute("spokeCode"));
          cstmt.setBigDecimal(18,
                            (BigDecimal)this.session.getAttribute("coverageAreaCode"));
          cstmt.setBigDecimal(19,
                            (BigDecimal)this.session.getAttribute("locationCode"));

            cstmt.execute();
            //LOVCC.endorsementCode=cstmt.getBigDecimal(6);
            session.setAttribute("endorsementCode", cstmt.getBigDecimal(6));
            if (reuseCbox.isSelected()) {
                session.setAttribute("policyCode",
                                     session.getAttribute("reusePolCode"));
            }

            conn.close();

            workflowProcessing bpm = new workflowProcessing();
            bpm.UpdateWorkflowAttributes();

            Success = "S";
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
            ex.printStackTrace();
        } finally {
            GlobalCC.CloseConnections(null, cstmt, conn);
        }


        return Success;
    }

    public String findReusePolicy() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindReuseTransactionsIterator");
        RowKeySet set = reuseTable.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            session.setAttribute("reusePolCode", r.getAttribute("POL_CODE"));

            reuseDesc.setValue(r.getAttribute("POL_POLICY_NO"));

        }
        return null;
    }

    public void reuseListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if (valueChangeEvent.getOldValue() != valueChangeEvent.getNewValue()) {
            if (reuseCbox.isSelected()) {
                reusePanel.setRendered(true);
            } else {
                reusePanel.setRendered(false);
            }
            session.setAttribute("reusePolCode", null);
            reuseDesc.setValue(null);
        }
    }

    public void setPaymentMethodDisplay(RichSelectOneChoice paymentMethodDisplay) {
        this.paymentMethodDisplay = paymentMethodDisplay;
    }

    public RichSelectOneChoice getPaymentMethodDisplay() {
        return paymentMethodDisplay;
    }

    public void GetPaymentMethod(ValueChangeEvent valueChangeEvent) {
        if (paymentMethodDisplay.getValue() == null) {
            //LOVCC.endrPayMethd=null;
            session.setAttribute("endrPayMethd", null);
        } else {
            //LOVCC.endrPayMethd=paymentMethodDisplay.getValue().toString();
            session.setAttribute("endrPayMethd",
                                 paymentMethodDisplay.getValue().toString());
        }

        String endrPay = (String)session.getAttribute("endrPayMethd");
        if (endrPay.equalsIgnoreCase("K")) {
            checkOffDisplay.setValue(null);
            checkoffButton.setDisabled(false);
            //LOVCC.checkOffAgentCode = null;
            //LOVCC.checkOffCommission = null;
            session.setAttribute("checkOffAgentCode", null);
            session.setAttribute("checkOffCommission", null);

        } else {
            checkOffDisplay.setValue(null);
            checkoffButton.setDisabled(true);
            session.setAttribute("checkOffAgentCode", null);
            session.setAttribute("checkOffCommission", null);
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(checkOffDisplay);
        AdfFacesContext.getCurrentInstance().addPartialTarget(checkoffButton);

    }

    public void setAgentsLOV(RichInputText agentsLOV) {
        this.agentsLOV = agentsLOV;
    }

    public RichInputText getAgentsLOV() {
        return agentsLOV;
    }

    public void setAgentDisplayLOV(RichTable agentDisplayLOV) {
        this.agentDisplayLOV = agentDisplayLOV;
    }

    public RichTable getAgentDisplayLOV() {
        return agentDisplayLOV;
    }

    public void setAgentsDisplay(RichInputText agentsDisplay) {
        this.agentsDisplay = agentsDisplay;
    }

    public RichInputText getAgentsDisplay() {
        return agentsDisplay;
    }

    public String AttachAgents() {
        DCIteratorBinding dciter = ADFUtils.findIterator("FindAgentsIterator");
        RowKeySet set = agentDisplayLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            session.setAttribute("agnCode",
                                 r.getAttribute("AGN_CODE")); //LOVCC.agnCode=(BigDecimal)r.getAttribute("AGN_CODE");
            session.setAttribute("agnShtDesc",
                                 r.getAttribute("AGN_SHT_DESC")); //LOVCC.agnShtDesc=(String)r.getAttribute("AGN_SHT_DESC");
            session.setAttribute("agnName",
                                 r.getAttribute("AGN_NAME")); //LOVCC.agnName=(String)r.getAttribute("AGN_NAME");
            agentsDisplay.setValue(r.getAttribute("AGN_NAME"));

        }
        return null;
    }

    public String AttachMarketers() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindMarketersIterator");
        RowKeySet set = this.marketerLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            session.setAttribute("mktCode", r.getAttribute("AGN_CODE"));
            session.setAttribute("mktShtDesc", r.getAttribute("AGN_SHT_DESC"));
            session.setAttribute("mktName", r.getAttribute("AGN_NAME"));
            marketerDisplay.setValue(r.getAttribute("AGN_NAME"));
        }

        return null;
    }

    public void setCheckOffDisplay(RichInputText checkOffDisplay) {
        this.checkOffDisplay = checkOffDisplay;
    }

    public RichInputText getCheckOffDisplay() {
        return checkOffDisplay;
    }

    public String AttachCheckOffAgents() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindCheckOffAgentsIterator");
        RowKeySet set = checkOffAgentsDisplay.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();


            checkOffDisplay.setValue(r.getAttribute("AGN_NAME"));
            //LOVCC.checkOffAgentCode=(BigDecimal)r.getAttribute("AGN_CODE");
            //LOVCC.checkOffCommission=(BigDecimal)r.getAttribute("AGN_AGENT_COMMISSION");
            session.setAttribute("checkOffAgentCode",
                                 r.getAttribute("AGN_CODE"));
            session.setAttribute("checkOffCommission",
                                 r.getAttribute("AGN_AGENT_COMMISSION"));
        }
        return null;
    }

    public void setCheckOffAgentsDisplay(RichTable checkOffAgentsDisplay) {
        this.checkOffAgentsDisplay = checkOffAgentsDisplay;
    }

    public RichTable getCheckOffAgentsDisplay() {
        return checkOffAgentsDisplay;
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

    public String AttachPremiumMasks() {
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
            session.setAttribute("pmasShtDesc",
                                 r.getAttribute("PMAS_SHT_DESC"));

            session.setAttribute("categoryMaskCode",
                                 r.getAttribute("PMAS_CODE"));
            catMaskDesc.setValue(r.getAttribute("PMAS_SHT_DESC"));


        }
        return null;
    }

    public void setCommissionRateDisplay(RichInputNumberSpinbox commissionRateDisplay) {
        this.commissionRateDisplay = commissionRateDisplay;
    }

    public RichInputNumberSpinbox getCommissionRateDisplay() {
        return commissionRateDisplay;
    }

    public String ShowPolicyCovers() {
        String updateQuery =
            "BEGIN LMS_WEB_PKG_GRP.updateNBEndorsement(?,?,?,?,?,?,?,?,?,?,?,?);END;";
        String populateCovers =
            "BEGIN LMS_WEB_PKG_GRP.populate_policy_cover_types(?,?,?);END;";
        Connection conn = new DBConnector().getDatabaseConn();
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall(updateQuery);
            CallableStatement cstCovers = conn.prepareCall(populateCovers);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("endorsementCode")); //v_endr_code NUMBER,
            cstmt.setString(2,
                            (String)session.getAttribute("endrPayMethd")); //v_pymt_mthd VARCHAR2,
            cstmt.setBigDecimal(3,
                                (BigDecimal)session.getAttribute("pmasCode")); //v_pmas_code NUMBER,
            cstmt.setBigDecimal(4,
                                (BigDecimal)session.getAttribute("agnCode")); //v_agn_code NUMBER,
            if (commissionRateDisplay.getValue() == null) {
                cstmt.setString(5, null); //v_cOMM_RATE number,

            } else {
                cstmt.setDouble(5,
                                Double.parseDouble(commissionRateDisplay.getValue().toString())); //v_cOMM_RATE number,

            }
            cstmt.setBigDecimal(6,
                                (BigDecimal)session.getAttribute("checkOffAgentCode")); //v_chkoff_agn_code NUMBER,
            cstmt.setBigDecimal(7,
                                (BigDecimal)session.getAttribute("checkOffAgentCode")); //v_chk_comm NUMBER
            if (unitRateOption.getValue() == null) {
                cstmt.setString(8, null); //v_cOMM_RATE number,

            } else {
                cstmt.setString(8,
                                unitRateOption.getValue().toString()); //v_cOMM_RATE number,

            }
            if (VAT.getValue() == null) {
                cstmt.setString(9, null); //v_cOMM_RATE number,

            } else {
                cstmt.setDouble(9,
                                Double.parseDouble(VAT.getValue().toString())); //v_cOMM_RATE number,

            }
            if (ovrCommRate.getValue() == null) {
                cstmt.setString(10, null); //v_cOMM_RATE number,

            } else {
                cstmt.setDouble(10,
                                Double.parseDouble(ovrCommRate.getValue().toString())); //v_cOMM_RATE number,

            }
            cstmt.setBigDecimal(11,
                                (BigDecimal)this.session.getAttribute("mktCode"));
            cstmt.setString(12,
                            (String)this.session.getAttribute("mktShtDesc"));
            cstmt.execute();
            cstmt.close();

            cstCovers.setBigDecimal(1,
                                    (BigDecimal)session.getAttribute("ProductCode"));
            cstCovers.setBigDecimal(2,
                                    (BigDecimal)session.getAttribute("policyCode"));
            cstCovers.setBigDecimal(3,
                                    (BigDecimal)session.getAttribute("endorsementCode"));
            //cstCovers.execute();
            //QuotDAO.policyCode=LOVCC.policyCode;
            //GlobalCC.RedirectPage("/undcovers.jspx");
            cstCovers.close();
            getCurrencyDetails();

            String JointAgents =
                "BEGIN LMS_WEB_PKG_GRP.update_joint_agent_share(?,?,?);END;";
            CallableStatement cstAgents = conn.prepareCall(JointAgents);
            cstAgents.setBigDecimal(1,
                                    (BigDecimal)session.getAttribute("endorsementCode"));
            if (jointAgent.isSelected()) {
                cstAgents.setString(2, "Y");
                if (agentShare.getValue() == null) {
                    cstAgents.setString(3, null);
                } else {
                    cstAgents.setString(3, agentShare.getValue().toString());
                }
            } else {
                cstAgents.setString(2, "N");
                cstAgents.setString(3, null);
            }
            cstAgents.execute();
            cstAgents.close();
            conn.close();

        } catch (NullPointerException ex) {
            //LOVCC.checkOffAgentCode=new BigDecimal(0);
            //LOVCC.checkOffCommission=null;
            session.setAttribute("checkOffAgentCode", 0);
            session.setAttribute("checkOffCommission", null);
            commissionRateDisplay.setValue("0");
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        } finally {
            GlobalCC.CloseConnections(null, cstmt, conn);
        }
        return null;
    }

    public void setPolicyCoverTypesLOV(RichTable policyCoverTypesLOV) {
        this.policyCoverTypesLOV = policyCoverTypesLOV;
    }

    public RichTable getPolicyCoverTypesLOV() {
        return policyCoverTypesLOV;
    }

    public String DeletePolicyCoverType() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindCoverTypesIterator");
        RowKeySet set = policyCoverTypesLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            //LOVCC.pcvtCode=(BigDecimal)r.getAttribute("PCVT_CODE");
            session.setAttribute("pcvtCode", r.getAttribute("PCVT_CODE"));


        }
        String coverDeleteQuery =
            "BEGIN LMS_WEB_PKG_GRP.delete_policy_cover_type(?,?,?);END;";
        Connection conn = new DBConnector().getDatabaseConn();
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall(coverDeleteQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("endorsementCode"));
            cstmt.setBigDecimal(2,
                                (BigDecimal)session.getAttribute("policyCode"));
            cstmt.setBigDecimal(3,
                                (BigDecimal)session.getAttribute("pcvtCode"));
            cstmt.execute();
            ADFUtils.findIterator("FindCoverTypesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(policyCoverTypesLOV);
            conn.close();
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        } finally {
            GlobalCC.CloseConnections(null, cstmt, conn);
        }
        return null;
    }

    public void CoverRateListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if (valueChangeEvent.getOldValue() != valueChangeEvent.getNewValue()) {
            if (rateSelection.getValue() == null) {

                session.setAttribute("coverMaskCode",
                                     (BigDecimal)session.getAttribute("pmasCode"));
                maskDesc.setValue((String)session.getAttribute("pmasShtDesc"));

                maskButton.setDisabled(true);
                coverRate.setDisabled(true);
                coverRate.setValue(null);
                coverRateDivFactor.setDisabled(true);
                coverRateDivFactor.setValue(null);
            } else if (rateSelection.getValue().toString().equalsIgnoreCase("M")) {

                session.setAttribute("coverMaskCode",
                                     (BigDecimal)session.getAttribute("pmasCode"));
                maskDesc.setValue((String)session.getAttribute("pmasShtDesc"));

                maskButton.setDisabled(true);
                coverRate.setDisabled(true);
                coverRate.setValue(null);
                coverRateDivFactor.setDisabled(true);
                coverRateDivFactor.setValue(null);
            } else if (rateSelection.getValue().toString().equalsIgnoreCase("S")) {

                session.setAttribute("coverMaskCode", null);
                maskDesc.setValue(null);
                maskButton.setDisabled(false);
                coverRate.setDisabled(true);
                coverRate.setValue(null);
                coverRateDivFactor.setDisabled(true);
                coverRateDivFactor.setValue(null);
            } else if (rateSelection.getValue().toString().equalsIgnoreCase("C")) {

                session.setAttribute("coverMaskCode", null);
                maskDesc.setValue(null);
                maskButton.setDisabled(true);
                coverRate.setDisabled(false);
                coverRate.setValue(null);
                coverRateDivFactor.setDisabled(false);
                coverRateDivFactor.setValue(null);
            }
            AdfFacesContext.getCurrentInstance().addPartialTarget(maskDesc);
            AdfFacesContext.getCurrentInstance().addPartialTarget(maskButton);
            AdfFacesContext.getCurrentInstance().addPartialTarget(coverRate);
            AdfFacesContext.getCurrentInstance().addPartialTarget(coverRateDivFactor);
        }
    }

    public String UpdateFuneralCash() {
        String mainRider = "";
        String dependents = "";
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindCoverTypesIterator");
        RowKeySet set = policyCoverTypesLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            //LOVCC.pcvtCode=(BigDecimal)r.getAttribute("PCVT_CODE");
            session.setAttribute("pcvtCode", r.getAttribute("PCVT_CODE"));
            mainRider = (String)r.getAttribute("PCVT_MAIN_RIDER");
            dependents = (String)r.getAttribute("CVT_DEPEND_DISP");
            if (!((mainRider.equalsIgnoreCase("R")))) {
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                              null,
                                                                              "Only allowed for Riders, where cover Sum Assured is uniform for all members.."));
            } else if (dependents.equalsIgnoreCase("D") ||
                       dependents.equalsIgnoreCase("A")) {
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                              null,
                                                                              "This product covers dependants. Please use the update on the dependant limits page."));
            }

        }
        return null;
    }

    public void setNewRiderAmountDisplay(RichInputText newRiderAmountDisplay) {
        this.newRiderAmountDisplay = newRiderAmountDisplay;
    }

    public RichInputText getNewRiderAmountDisplay() {
        return newRiderAmountDisplay;
    }

    public void GetMembersToUpdate(ValueChangeEvent valueChangeEvent) {
        //LOVCC.membersToUpdate=membersRiders.getValue().toString();
        session.setAttribute("membersToUpdate",
                             membersRiders.getValue().toString());
    }

    public String UpdateFuneralRiders() {
        BigDecimal pcaCode = null;

        DCIteratorBinding dciter =
            ADFUtils.findIterator("findCategoryIterator");
        RowKeySet set = policyCategoriesLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            pcaCode = (BigDecimal)r.getAttribute("lcaCode");

        }

        Double newRiderAmount = null;
        String updateQuery =
            "BEGIN LMS_WEB_PKG_GRP.updatememberfuneralriders(?,?,?,?,?);END;";
        Connection conn = null;
        CallableStatement cstmt = null;
        try {
            conn = new DBConnector().getDatabaseConn();
            cstmt = conn.prepareCall(updateQuery);
            if (newRiderAmountDisplay.getValue() == null) {
                String Message = "Enter A New Rider Amount ";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));
                return null;
            } else {
                newRiderAmount =
                        Double.parseDouble(newRiderAmountDisplay.getValue().toString());
            }

            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("endorsementCode"));
            cstmt.setBigDecimal(2, pcaCode);
            cstmt.setString(3,
                            (String)session.getAttribute("membersToUpdate"));
            cstmt.setDouble(4, newRiderAmount);
            cstmt.setBigDecimal(5,
                                (BigDecimal)session.getAttribute("policyCode"));
            cstmt.execute();

            String Message = "Members Updated";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));

            newRiderAmountDisplay.setValue(null);

            ADFUtils.findIterator("FindCoverTypesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(policyCoverTypesLOV);
            conn.close();
        }

        catch (Exception ex) {
            newRiderAmountDisplay.setValue(null);
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        } finally {
            GlobalCC.CloseConnections(null, cstmt, conn);
        }
        return null;
    }

    public void setMembersRiders(RichSelectBooleanRadio membersRiders) {
        this.membersRiders = membersRiders;
    }

    public RichSelectBooleanRadio getMembersRiders() {
        return membersRiders;
    }

    public void setMemwithoutRiders(RichSelectBooleanRadio memwithoutRiders) {
        this.memwithoutRiders = memwithoutRiders;
    }

    public RichSelectBooleanRadio getMemwithoutRiders() {
        return memwithoutRiders;
    }

    public void setMembersWithRiders(RichSelectBooleanRadio membersWithRiders) {
        this.membersWithRiders = membersWithRiders;
    }

    public RichSelectBooleanRadio getMembersWithRiders() {
        return membersWithRiders;
    }

    public void GetMemsWithRiders(ValueChangeEvent valueChangeEvent) {
        if (membersWithRiders.getValue() == null) {
            //do nothing
        } else {
            //LOVCC.membersToUpdate=membersWithRiders.getValue().toString();
            session.setAttribute("membersToUpdate",
                                 membersWithRiders.getValue().toString());
        }

    }

    public void GetMemsWithoutRiders(ValueChangeEvent valueChangeEvent) {
        if (memwithoutRiders.getValue() == null) {
            //do nothing
        } else {
            //LOVCC.membersToUpdate=memwithoutRiders.getValue().toString();
            session.setAttribute("membersToUpdate",
                                 memwithoutRiders.getValue().toString());
        }

    }

    public void setTaxesLOV(RichTable taxesLOV) {
        this.taxesLOV = taxesLOV;
    }

    public RichTable getTaxesLOV() {
        return taxesLOV;
    }

    public String DeletePolicyTaxes() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindPolicyTaxesIterator");
        RowKeySet set = taxesLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            //LOVCC.ptxCode=(BigDecimal)r.getAttribute("PTX_CODE");
            session.setAttribute("ptxCode", r.getAttribute("PTX_CODE"));


        }
        String taxesDeleteQuery =
            "BEGIN LMS_WEB_PKG_GRP.delete_taxes(?,?);END;";
        Connection conn = new DBConnector().getDatabaseConn();
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall(taxesDeleteQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("ptxCode"));
            cstmt.setString(2, "P");
            cstmt.execute();
            ADFUtils.findIterator("FindPolicyTaxesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(taxesLOV);
            conn.close();
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        } finally {
            GlobalCC.CloseConnections(null, cstmt, conn);
        }
        return null;
    }

    public String ShowPolicyTaxes() {
        String populateTaxes =
            "BEGIN LMS_WEB_PKG_GRP.populate_taxes(?,?,?);END;";
        Connection conn = new DBConnector().getDatabaseConn();
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall(populateTaxes);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("policyCode"));
            cstmt.setString(2, "P");
            cstmt.setBigDecimal(3,
                                (BigDecimal)session.getAttribute("endorsementCode"));

            cstmt.execute();
            conn.close();
            //GlobalCC.RedirectPage("/undwrtax.jspx");
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        } finally {
            GlobalCC.CloseConnections(null, cstmt, conn);
        }
        return null;
    }

    public String ShowPolicyProvisions() {
        String populateQuery =
            "BEGIN LMS_WEB_PKG_GRP.populateProvisions(?,?,?,?);END;";
        Connection conn = new DBConnector().getDatabaseConn();
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall(populateQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("ProductCode"));
            cstmt.setBigDecimal(2,
                                (BigDecimal)session.getAttribute("policyCode"));
            cstmt.setString(3, "P");
            cstmt.setBigDecimal(4,
                                (BigDecimal)session.getAttribute("endorsementCode"));
            cstmt.execute();
            conn.close();
            //GlobalCC.RedirectPage("/undwrpro.jspx");
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        } finally {
            GlobalCC.CloseConnections(null, cstmt, conn);
        }
        return null;
    }

    public void setPolicyProvisionsLOV(RichTable policyProvisionsLOV) {
        this.policyProvisionsLOV = policyProvisionsLOV;
    }

    public RichTable getPolicyProvisionsLOV() {
        return policyProvisionsLOV;
    }

    public String DeletePolicyProvisions() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindProdProvisionIterator");
        RowKeySet set = policyProvisionsLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            //LOVCC.polpCode=(BigDecimal)r.getAttribute("PPROV_PROD_CODE");
            session.setAttribute("polpCode",
                                 r.getAttribute("PPROV_PROD_CODE"));


        }
        String taxesDeleteQuery =
            "BEGIN LMS_WEB_PKG_GRP.deletePolicyProvision(?);END;";
        Connection conn = new DBConnector().getDatabaseConn();
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall(taxesDeleteQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("polpCode"));
            cstmt.execute();
            ADFUtils.findIterator("FindProdProvisionIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(policyProvisionsLOV);
            conn.close();
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        } finally {
            GlobalCC.CloseConnections(null, cstmt, conn);
        }
        return null;

    }

    public void setPolicyCoverProvisions(RichTable policyCoverProvisions) {
        this.policyCoverProvisions = policyCoverProvisions;
    }

    public RichTable getPolicyCoverProvisions() {
        return policyCoverProvisions;
    }

    public void GetSelectedCoverType(SelectionEvent selectionEvent) {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindCoverTypesIterator");
        RowKeySet set = selectionEvent.getAddedSet();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            //LOVCC.CoverTypeCode=(BigDecimal)r.getAttribute("PCVT_CVT_CODE");
            session.setAttribute("CoverTypeCode",
                                 r.getAttribute("PCVT_CVT_CODE"));


        }
    }

    public String SaveCoverProvision() {
        String provDesc = "";
        String provEditable = "";
        String provShtDesc = "";
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindProdProvision1Iterator");
        RowKeySet set = coverTypeProvisions.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            //LOVCC.pprovCode=(BigDecimal)r.getAttribute("PPROV_CODE");
            session.setAttribute("pprovCode", r.getAttribute("PPROV_CODE"));
            provDesc = (String)r.getAttribute("PROV_DESC");
            provEditable = (String)r.getAttribute("PPROV_EDITABLE");
            provShtDesc = (String)r.getAttribute("PROV_SHT_DESC");
        }
        String saveQuery =
            "BEGIN LMS_WEB_PKG_GRP.saveCoverProvision(?,?,?,?,?,?);END;";
        Connection conn = new DBConnector().getDatabaseConn();
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall(saveQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("endorsementCode"));
            cstmt.setBigDecimal(2,
                                (BigDecimal)session.getAttribute("CoverTypeCode"));
            cstmt.setString(3, provShtDesc);
            cstmt.setString(4, provDesc);
            cstmt.setString(5, provEditable);
            cstmt.execute();
            conn.close();
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        } finally {
            GlobalCC.CloseConnections(null, cstmt, conn);
        }
        return null;
    }

    public void setCoverTypeProvisions(RichTable coverTypeProvisions) {
        this.coverTypeProvisions = coverTypeProvisions;
    }

    public RichTable getCoverTypeProvisions() {
        return coverTypeProvisions;
    }

    public void setPolCvtProvisions(RichTable polCvtProvisions) {
        this.polCvtProvisions = polCvtProvisions;
    }

    public RichTable getPolCvtProvisions() {
        return polCvtProvisions;
    }

    public String DeletePolCvtProvision() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindProdProvision2Iterator");
        RowKeySet set = polCvtProvisions.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            //LOVCC.pcpCode=(BigDecimal)r.getAttribute("PPROV_CODE");
            session.setAttribute("pcpCode", r.getAttribute("PPROV_CODE"));

        }
        String deleteQuery =
            "BEGIN LMS_WEB_PKG_GRP.deletecoverprovision(?);END;";
        Connection conn = new DBConnector().getDatabaseConn();
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall(deleteQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("pcpCode"));
            cstmt.execute();
            ADFUtils.findIterator("FindProdProvision2Iterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(polCvtProvisions);
            conn.close();
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        } finally {
            GlobalCC.CloseConnections(null, cstmt, conn);
        }

        return null;
    }

    public void setCategIDDisplay(RichInputText categIDDisplay) {
        this.categIDDisplay = categIDDisplay;
    }

    public RichInputText getCategIDDisplay() {
        return categIDDisplay;
    }

    public void setCategDescriptionDisplay(RichInputText categDescriptionDisplay) {
        this.categDescriptionDisplay = categDescriptionDisplay;
    }

    public RichInputText getCategDescriptionDisplay() {
        return categDescriptionDisplay;
    }

    public void setCategPeriodDisplay(RichInputText categPeriodDisplay) {
        this.categPeriodDisplay = categPeriodDisplay;
    }

    public RichInputText getCategPeriodDisplay() {
        return categPeriodDisplay;
    }

    public String SchoolClassSelected() {
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findSchClassesIterator");
            RowKeySet set = classesLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            //System.out.println(1);
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();
                session.setAttribute("schCode", r.getAttribute("SCH_CODE"));
                categIDDisplay.setValue(r.getAttribute("SCH_SHT_DESC"));
                categDescriptionDisplay.setValue(r.getAttribute("SCH_DESC"));
                categPeriodDisplay.setValue(r.getAttribute("SLVL_TERM_DURATION"));
            }


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String SavePolicyCategory() {
        Rendering render = new Rendering();
        String SaveQuery =
            "BEGIN LMS_WEB_PKG_GRP.add_category(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);END;";
        Connection conn = new DBConnector().getDatabaseConn();
        CallableStatement cstmt = null;
        try {
            if (categIDDisplay.getValue() == null) {
                GlobalCC.INFORMATIONREPORTING("Enter a Category Description");
                return null;
            }
            if (categDescriptionDisplay.getValue() == null) {
                GlobalCC.INFORMATIONREPORTING("Enter a Category ID");
                return null;
            }
            if (render.isEarningsproduct()) {
                if (categPeriodDisplay.getValue() == null) {
                    GlobalCC.INFORMATIONREPORTING("Enter a Category Period");
                    return null;
                }
            } else {
                categPeriodDisplay.setValue(1);
            }
            cstmt = conn.prepareCall(SaveQuery);

            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("pcaCode"));
            cstmt.setBigDecimal(2, null);
            if (categIDDisplay.getValue() == null) {
                cstmt.setString(3, null);
            } else {
                cstmt.setString(3, categIDDisplay.getValue().toString());
            }
            if (categDescriptionDisplay.getValue() == null) {
                cstmt.setString(4, null);
            } else {
                cstmt.setString(4,
                                categDescriptionDisplay.getValue().toString());
            }
            if (categPeriodDisplay.getValue() == null) {
                cstmt.setString(5, null);
            } else {
                cstmt.setString(5, categPeriodDisplay.getValue().toString());
            }
            cstmt.setString(6, "P");
            cstmt.setBigDecimal(7,
                                (BigDecimal)session.getAttribute("endorsementCode"));
            cstmt.setBigDecimal(8,
                                (BigDecimal)session.getAttribute("schCode"));
            cstmt.setString(9, null);
            cstmt.setString(10, null);
            cstmt.setBigDecimal(11,
                                (BigDecimal)session.getAttribute("categoryMaskCode"));
            if (session.getAttribute("catlpagCode") == null) {
                cstmt.setBigDecimal(12,
                                    (BigDecimal)session.getAttribute("lpagCode"));
            } else {
                cstmt.setBigDecimal(12,
                                    (BigDecimal)session.getAttribute("catlpagCode"));
            }
            if (catSelectRate.getValue() == null) {
                cstmt.setString(13, null);
            } else {
                cstmt.setString(13,
                                catSelectRate.getValue().toString());
            }
            if (catRate.getValue() == null) {
                cstmt.setString(14, null);
            } else {
                cstmt.setString(14,
                                catRate.getValue().toString());
            }
            if (catRateDivFac.getValue() == null) {
                cstmt.setString(15, null);
            } else {
                cstmt.setString(15,
                                catRateDivFac.getValue().toString());
            }

            cstmt.execute();

            if (session.getAttribute("pcaCode") == null) {
                session.setAttribute("pcaCode", null);
                categIDDisplay.setValue(null);
                categDescriptionDisplay.setValue(null);
                categPeriodDisplay.setValue(null);
            }

            //dpdCatDescDisp.setValue(categDescriptionDisplay.getValue().toString());
            ///AdfFacesContext.getCurrentInstance().addPartialTarget(dpdCatDescDisp);

            ADFUtils.findIterator("findCategoryIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(categoryTree);
            conn.close();
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        } finally {
            GlobalCC.CloseConnections(null, cstmt, conn);
        }
        return null;
    }

    public void setPolicyCategoriesLOV(RichTable policyCategoriesLOV) {
        this.policyCategoriesLOV = policyCategoriesLOV;
    }

    public RichTable getPolicyCategoriesLOV() {
        return policyCategoriesLOV;
    }

    public String DeletePolicyCategory() {
        String deleteQuery = "BEGIN LMS_WEB_PKG_GRP.delete_category(?,?);END;";

        Connection conn = new DBConnector().getDatabaseConn();
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall(deleteQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("pcaCode"));
            cstmt.setString(2, "P");
            cstmt.execute();
            session.setAttribute("pcaCode", null);
            session.setAttribute("schCode", null);
            categIDDisplay.setValue(null);
            categDescriptionDisplay.setValue(null);
            categPeriodDisplay.setValue(null);
            conn.close();
            ADFUtils.findIterator("findCategoryIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(categoryTree);
            ADFUtils.findIterator("FindDependentsLimitsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(policyDependentLimitsLOV);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(null, cstmt, conn);
        }
        return null;
    }

    public String AttachCategories() {
        saveEdit = "N";
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findCategoryIterator");
        RowKeySet set = policyCategoriesLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            //LOVCC.pcaCode=(BigDecimal)r.getAttribute("lcaCode");
            session.setAttribute("pcaCode", r.getAttribute("lcaCode"));
            categIDDisplay.setValue(r.getAttribute("catShtDesc"));
            categDescriptionDisplay.setValue(r.getAttribute("catDesc"));
            categPeriodDisplay.setValue(r.getAttribute("catPeriod"));

        }
        return null;
    }

    public String ShowPolicyCategories() {
        try {
            GlobalCC.RedirectPage("/undcateg.jspx");
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(null, ex);
        }
        return null;
    }

    public void GetSelectedCategory(SelectionEvent selectionEvent) {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findCategoryIterator");
        RowKeySet set = selectionEvent.getAddedSet();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            //LOVCC.pcaCode=(BigDecimal)r.getAttribute("lcaCode");
            session.setAttribute("pcaCode", r.getAttribute("lcaCode"));


        }
    }

    public void setLimitAmountDisplay(RichInputText limitAmountDisplay) {
        this.limitAmountDisplay = limitAmountDisplay;
    }

    public RichInputText getLimitAmountDisplay() {
        return limitAmountDisplay;
    }

    public void setDependentTypeDisplay(RichSelectOneChoice dependentTypeDisplay) {
        this.dependentTypeDisplay = dependentTypeDisplay;
    }

    public RichSelectOneChoice getDependentTypeDisplay() {
        return dependentTypeDisplay;
    }

    public String SaveDependentLimit() {

        String updateQuery =
            "BEGIN LMS_WEB_PKG_GRP.updatedependentlimits(?,?,?,?,?,?,?,?,?,?,?);END;";
        Connection conn = new DBConnector().getDatabaseConn();
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall(updateQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("pdlCode"));
            cstmt.setBigDecimal(2, null);
            cstmt.setBigDecimal(3,
                                (BigDecimal)session.getAttribute("dtyCode"));
            if (maxTypeDisplay.getValue() == null) {
                cstmt.setBigDecimal(4, null);
            } else {
                cstmt.setBigDecimal(4,
                                    new BigDecimal(maxTypeDisplay.getValue().toString()));
            }
            if (limitAmountDisplay.getValue() == null) {
                cstmt.setString(5, null);
            } else {
                cstmt.setDouble(5,
                                Double.parseDouble(limitAmountDisplay.getValue().toString()));
            }
            cstmt.setBigDecimal(6,
                                (BigDecimal)session.getAttribute("pcvtCode"));
            cstmt.setBigDecimal(7,
                                (BigDecimal)session.getAttribute("CoverTypeCode"));
            cstmt.setBigDecimal(8,
                                (BigDecimal)session.getAttribute("endorsementCode"));
            cstmt.setBigDecimal(9,
                                (BigDecimal)session.getAttribute("pcaCode"));
            cstmt.setString(10, "P");
            if (minAmountDisplay.getValue() == null) {
                cstmt.setString(11, null);
            } else {
                cstmt.setDouble(11,
                                Double.parseDouble(minAmountDisplay.getValue().toString()));
            }
            cstmt.execute();

            session.setAttribute("pdlCode", null);
            ADFUtils.findIterator("FindDependentsLimitsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(policyDependentLimitsLOV);
            GlobalCC.hidePopup("lmsgroup:poldepdetails");
            conn.close();
        } catch (Exception ex) {
            session.setAttribute("pdlCode", null);
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        } finally {
            GlobalCC.CloseConnections(null, cstmt, conn);
        }
        return null;
    }

    public String AttachDependentTypes() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindDependentsIterator");
        RowKeySet set = dependentTypesLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            //LOVCC.dtyCode=(BigDecimal)r.getAttribute("DTY_CODE");
            session.setAttribute("dtyCode", r.getAttribute("DTY_CODE"));

            dependentTypeDisplay.setValue(r.getAttribute("DTY_DESCRIPTION"));

            //LOVCC.maxType=(BigDecimal)r.getAttribute("PCD_MAX_NO_ALLOWED");
            session.setAttribute("maxType",
                                 r.getAttribute("PCD_MAX_NO_ALLOWED"));

        }
        return null;
    }

    public void setDependentTypesLOV(RichTable dependentTypesLOV) {
        this.dependentTypesLOV = dependentTypesLOV;
    }

    public RichTable getDependentTypesLOV() {
        return dependentTypesLOV;
    }

    public void setMaxTypeDisplay(RichInputText maxTypeDisplay) {
        this.maxTypeDisplay = maxTypeDisplay;
    }

    public RichInputText getMaxTypeDisplay() {
        return maxTypeDisplay;
    }

    public void setPolicyDependentLimitsLOV(RichTable policyDependentLimitsLOV) {
        this.policyDependentLimitsLOV = policyDependentLimitsLOV;
    }

    public RichTable getPolicyDependentLimitsLOV() {
        return policyDependentLimitsLOV;
    }

    public String DeletePolicyDependentLimits() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindDependentsLimitsIterator");
        RowKeySet set = policyDependentLimitsLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            //LOVCC.pdlCode=(BigDecimal)r.getAttribute("QDL_CODE");
            session.setAttribute("pdlCode", r.getAttribute("QDL_CODE"));

        }
        String deleteQuery =
            "BEGIN LMS_WEB_PKG_GRP.delete_dpd_limit(?,?);END;";
        Connection conn = new DBConnector().getDatabaseConn();
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall(deleteQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("pdlCode"));
            cstmt.setString(2, "P");
            cstmt.execute();

            ADFUtils.findIterator("FindDependentsLimitsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(policyDependentLimitsLOV);
            conn.close();
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        } finally {
            GlobalCC.CloseConnections(null, cstmt, conn);
        }
        return null;
    }

    public String ShowPolicyDocuments() {
        try {
            GlobalCC.RedirectPage("/undwrdoc.jspx");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void setDocumentsLOV(RichTable documentsLOV) {
        this.documentsLOV = documentsLOV;
    }

    public RichTable getDocumentsLOV() {
        return documentsLOV;
    }

    public String AttachDocuments() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindOccupationIterator");
        RowKeySet set = documentsLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            //LOVCC.rdCode=(BigDecimal)r.getAttribute("RD_CODE");
            session.setAttribute("rdCode", r.getAttribute("RD_CODE"));
            documentNameDisplay.setValue(r.getAttribute("RD_DESC"));
            //LOVCC.rdShtDesc=(String)r.getAttribute("RD_SHT_DESC");
            session.setAttribute("rdShtDesc", r.getAttribute("RD_SHT_DESC"));
            //LOVCC.gpdCode = null;
            session.setAttribute("gpdCode", null);
            documentSubmitted.setValue("N");
            documentDateDisplay.setValue(null);
            documentNoDisplay.setValue(null);

            // Render Popup
            ExtendedRenderKitService erkService =
                Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                   ExtendedRenderKitService.class);
            erkService.addScript(FacesContext.getCurrentInstance(),
                                 "var hints = {autodismissNever:false}; " +
                                 "AdfPage.PAGE.findComponent('" +
                                 "lmsgroup:poldocs" + "').show(hints);");
        }
        return null;
    }

    public void setDocumentNameDisplay(RichInputText documentNameDisplay) {
        this.documentNameDisplay = documentNameDisplay;
    }

    public RichInputText getDocumentNameDisplay() {
        return documentNameDisplay;
    }

    public void setDocumentSubmitted(RichSelectOneChoice documentSubmitted) {
        this.documentSubmitted = documentSubmitted;
    }

    public RichSelectOneChoice getDocumentSubmitted() {
        return documentSubmitted;
    }

    public void GetDocumentSubmission(ValueChangeEvent valueChangeEvent) {
        if (documentSubmitted.getValue() == null) {
            //LOVCC.documentSubmission="N";
            session.setAttribute("documentSubmission", null);
        } else {
            //LOVCC.documentSubmission=documentSubmitted.getValue().toString();
            session.setAttribute("documentSubmission",
                                 documentSubmitted.getValue().toString());
        }

    }

    public void setDocumentDateDisplay(RichInputDate documentDateDisplay) {
        this.documentDateDisplay = documentDateDisplay;
    }

    public RichInputDate getDocumentDateDisplay() {
        return documentDateDisplay;
    }

    public void setDocumentNoDisplay(RichInputText documentNoDisplay) {
        this.documentNoDisplay = documentNoDisplay;
    }

    public RichInputText getDocumentNoDisplay() {
        return documentNoDisplay;
    }

    public String SavePolicyDocuments() {
        String saveQuery =
            "BEGIN LMS_WEB_PKG_GRP.add_policy_document(?,?,?,?,?,?,?);END;";
        Connection conn = new DBConnector().getDatabaseConn();
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall(saveQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("gpdCode"));
            cstmt.setBigDecimal(2, (BigDecimal)session.getAttribute("rdCode"));
            cstmt.setString(3, (String)session.getAttribute("rdShtDesc"));
            cstmt.setString(4,
                            (String)session.getAttribute("documentSubmission"));
            if (documentDateDisplay.getValue() == null) {
                cstmt.setString(5, null);
            } else {
                cstmt.setString(5,
                                LOVCC.parseDate(documentDateDisplay.getValue().toString()));
            }
            if (documentNoDisplay.getValue() == null) {
                cstmt.setString(6, null);
            } else {
                cstmt.setString(6, documentNoDisplay.getValue().toString());
            }

            cstmt.setBigDecimal(7,
                                (BigDecimal)session.getAttribute("endorsementCode"));
            cstmt.execute();
            //LOVCC.gpdCode = null;
            session.setAttribute("gpdCode", null);
            ADFUtils.findIterator("FindPolicyDocsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(groupPolicyDocsLOV);
            conn.close();
        } catch (Exception ex) {
            //LOVCC.gpdCode = null;
            session.setAttribute("gpdCode", null);
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        } finally {
            GlobalCC.CloseConnections(null, cstmt, conn);
        }
        return null;
    }

    public void setGroupPolicyDocsLOV(RichTable groupPolicyDocsLOV) {
        this.groupPolicyDocsLOV = groupPolicyDocsLOV;
    }

    public RichTable getGroupPolicyDocsLOV() {
        return groupPolicyDocsLOV;
    }

    public String DeletePolicyDocuments() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindPolicyDocsIterator");
        RowKeySet set = groupPolicyDocsLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            //LOVCC.gpdCode=(BigDecimal)r.getAttribute("GPD_CODE");
            session.setAttribute("gpdCode", r.getAttribute("GPD_CODE"));

        }
        String deleteQuery = "BEGIN LMS_WEB_PKG_GRP.deleteDocument(?);END;";
        Connection conn = new DBConnector().getDatabaseConn();
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall(deleteQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("gpdCode"));
            cstmt.execute();
            ADFUtils.findIterator("FindPolicyDocsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(groupPolicyDocsLOV);
            conn.close();
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        } finally {
            GlobalCC.CloseConnections(null, cstmt, conn);
        }
        return null;
    }

    public String ShowMembers() {
        try {
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public String AddMember() {
        try {
            GlobalCC.RedirectPage("/g_members.jspx");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public String DeleteSchedule() {
        // Add event code here...
        return null;
    }

    public void setArrangementDisplay(RichInputText arrangementDisplay) {
        this.arrangementDisplay = arrangementDisplay;
    }

    public RichInputText getArrangementDisplay() {
        return arrangementDisplay;
    }

    public void setUndProdDisplay(RichInputText undProdDisplay) {
        this.undProdDisplay = undProdDisplay;
    }

    public RichInputText getUndProdDisplay() {
        return undProdDisplay;
    }

    public void setTreatyArrangementsLOV(RichTable treatyArrangementsLOV) {
        this.treatyArrangementsLOV = treatyArrangementsLOV;
    }

    public RichTable getTreatyArrangementsLOV() {
        return treatyArrangementsLOV;
    }

    public String AttachTreaty() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findRITreatiesIterator");
        RowKeySet set = treatyArrangementsLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            //LOVCC.TaCode=(BigDecimal)r.getAttribute("TA_CODE");
            session.setAttribute("TaCode", r.getAttribute("TA_CODE"));
            arrangementDisplay.setValue(r.getAttribute("TA_DESC"));

        }
        return null;
    }

    public String AttachReinsuranceMask() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findPremiumMaskIterator");
        RowKeySet set = reinMaskTable.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            session.setAttribute("reinsPmasCode", r.getAttribute("PMAS_CODE"));
            reinMaskDesc.setValue(r.getAttribute("PMAS_SHT_DESC"));

        }
        return null;
    }

    public String DocumentsDipatched() {
        Connection conn = new DBConnector().getDatabaseConn();
        CallableStatement cst3 = null;
        try {

            String Taske = (String)session.getAttribute("TaskID");
            String CurSta = (String)session.getAttribute("CurrentStatus");
            if (CurSta.equalsIgnoreCase("P")) {
                //LOVCC.ProcessShtDesc = "UWNB";
                //LOVCC.ProcessAreaShtDesc = "NBUW";
                //LOVCC.ProcessSubAShtDesc = "NBUW";
                session.setAttribute("ProcessShtDesc", "UWNB");
                session.setAttribute("ProcessAreaShtDesc", "NBUW");
                session.setAttribute("ProcessSubAShtDesc", "NBUW");
            } else {
                //LOVCC.ProcessShtDesc = "UW" + LOVCC.Endorsement;
                //LOVCC.ProcessAreaShtDesc = LOVCC.Endorsement + "UW";
                //LOVCC.ProcessSubAShtDesc = LOVCC.Endorsement + "UW";
                session.setAttribute("ProcessShtDesc",
                                     "UW" + session.getAttribute("Endorsement"));
                session.setAttribute("ProcessAreaShtDesc",
                                     session.getAttribute("Endorsement") +
                                     "UW");
                session.setAttribute("ProcessSubAShtDesc",
                                     session.getAttribute("Endorsement") +
                                     "UW");
            }
            if (Taske != null) {
                workflowProcessing wf = new workflowProcessing();
                String MyTask = null;

                String Complete =
                    "BEGIN TQC_WEB_PKG.check_task_completion(?,?,?,?);END;";
                cst3 = conn.prepareCall(Complete);
                cst3.setString(1, "UDISP");
                cst3.setString(2, (String)session.getAttribute("TaskID"));
                cst3.setInt(3, (Integer)session.getAttribute("sysCode"));
                cst3.registerOutParameter(4, oracle.jdbc.OracleTypes.VARCHAR);
                cst3.execute();

                MyTask = cst3.getString(4);
                conn.close();

                determinePerformReinsure();
                if (MyTask.equalsIgnoreCase("Y")) {
                    // wf.CompleteTask();
                    wf.CompleteTask();
                    String Messager2 = "Documents Successfully Dispatched.";
                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                  Messager2,
                                                                                  Messager2));
                } else {
                    String Message =
                        "the Task Selected Does not Correspond to the Activity being Performed. Cannot Complete please " +
                        session.getAttribute("TaskActivityName");
                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                  Message,
                                                                                  Message));
                    return null;
                }
            } else {
                String Message = "No Task Selected";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));
                return null;
            }

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(null, cst3, conn);
        }
        return null;
    }

    public String ComputePremium() {
        Connection conn = new DBConnector().getDatabaseConn();
        CallableStatement cst3 = null;
        try {

            session.setAttribute("srchMemName", null);
            session.setAttribute("srchMemNo", null);

            //Confirm that the current user can complete this task.
            session.setAttribute("Authorised", "N");
            workflowProcessing bpm = new workflowProcessing();
            String Rights = null;
            //LOVCC.ProcessShtDesc = "UWNB";
            //LOVCC.ProcessAreaShtDesc = "DENTR";
            //LOVCC.ProcessSubAShtDesc = "POLD";
            session.setAttribute("ProcessShtDesc", "UWNB");
            session.setAttribute("ProcessAreaShtDesc", "DENTR");
            session.setAttribute("ProcessSubAShtDesc", "POLD");

            Rights = bpm.CheckUserRights();
            if (Rights.equalsIgnoreCase("N")) {
                String Message =
                    "You do not have rights to Complete this Task.";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));
                return null;

            }

            //confirm that there is someone to perform the next task before completing
            String NextUser = null;
            //LOVCC.ProcessShtDesc = "UWNB";
            //LOVCC.ProcessAreaShtDesc = "NBUW";
            //LOVCC.ProcessSubAShtDesc = "NBUW";
            //LOVCC.TaskAssignee = null;
            session.setAttribute("ProcessShtDesc", "UWNB");
            session.setAttribute("ProcessAreaShtDesc", "NBUW");
            session.setAttribute("ProcessSubAShtDesc", "NBUW");
            session.setAttribute("TaskAssignee", null);

            session.setAttribute("NextTaskAssignee", "N");
            ADFUtils.findIterator("findTicketAssigneeIterator").executeQuery();
            NextUser = (String)session.getAttribute("NextTaskAssignee");
            String TaskAss = (String)session.getAttribute("TaskAssignee");
            if (TaskAss == null && NextUser.equalsIgnoreCase("N")) {
                String Message =
                    "There is no User to Assign the Next Task. Consult the Administrator.";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));
                return null;

            }
            String Taske = (String)session.getAttribute("TaskID");
            if (Taske == null) {
                String Message = "No Task Selected";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));
                return null;

            }


            //Con

            workflowProcessing wf = new workflowProcessing();
            Taske = (String)session.getAttribute("TaskID");
            if (Taske != null) {

                String MyTask = null;

                String Complete =
                    "BEGIN TQC_WEB_PKG.check_task_completion(?,?,?,?);END;";
                cst3 = conn.prepareCall(Complete);
                cst3.setString(1, "NBDE");
                cst3.setString(2, (String)session.getAttribute("TaskID"));
                cst3.setInt(3, (Integer)session.getAttribute("sysCode"));
                cst3.registerOutParameter(4, oracle.jdbc.OracleTypes.VARCHAR);
                cst3.execute();

                MyTask = cst3.getString(4);
                conn.close();
                if (MyTask.equalsIgnoreCase("N")) {
                    String Message =
                        "the Task Selected Does not Correspond to the Activity being Performed. Cannot Complete please " +
                        session.getAttribute("TaskActivityName");
                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                  Message,
                                                                                  Message));
                    return null;

                } else {
                    Rights = bpm.CheckUserRights();
                    if (Rights.equalsIgnoreCase("N")) {
                        ADFUtils.findIterator("findTicketAssigneeIterator").executeQuery();
                        TaskAss = (String)session.getAttribute("TaskAssignee");
                        if (TaskAss == null) {
                            GetAssignee();
                            return null;
                        } else {
                            wf.CompleteTask();
                            String Message =
                                "Current Task Complete. The Next Task " +
                                (String)session.getAttribute("TaskActivityName") +
                                " has been Successfully assigned to " +
                                (String)session.getAttribute("TaskAssignee");
                            FacesContext.getCurrentInstance().addMessage(null,
                                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                          Message,
                                                                                          Message));
                            session.setAttribute("TaskID", null);
                            return null;
                        }

                    } else {
                        wf.CompleteTask();
                        session.setAttribute("pcaCode", null);
                        session.setAttribute("editComponents", "N");
                        GlobalCC.RedirectPage("/g_undwrt.jspx");
                        return null;
                    }
                }

            }


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        } finally {
            GlobalCC.CloseConnections(null, cst3, conn);
        }
        return null;
    }

    public String updatePolDocDms() {
        String docid = (String)session.getAttribute("docId");
        EcmUtil ecmUtil = new EcmUtil();
        if (docid != null) {
            Session ecmSession = ecmUtil.Authentification();
            if (ecmSession == null) {

            } else {

                Document document = (Document)ecmSession.getObject(docid);
                AlfrescoDocument alfDoc = (AlfrescoDocument)document;
                String aspectname = "P:tqlms:tqordPolicyDocument";
                alfDoc.addAspect(aspectname);
                Map<String, Object> properties = new HashMap<String, Object>();

                properties.put("tqlms:policynumber",
                               session.getAttribute("dmsPolNo"));
                properties.put("tqlms:clientname",
                               session.getAttribute("polClient"));
                alfDoc.updateProperties(properties);
            }

            //add success message
            //update table
        }
        return null;
    }

    public String ComputeAggregatePremium() {

        String computePremium =
            "BEGIN LMS_WEB_PKG_GRP.compute_group_premium(?,?);END;";
        Connection conn = new DBConnector().getDatabaseConn();
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall(computePremium);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("policyCode"));
            cstmt.setBigDecimal(2,
                                (BigDecimal)session.getAttribute("endorsementCode"));

            cstmt.execute();
            conn.close();
            //LOVCC.Authorised = "N";
            session.setAttribute("Authorised", "N");
            session.setAttribute("editComponents", "N");
            GlobalCC.RedirectPage("/g_undwrt.jspx");
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        } finally {
            GlobalCC.CloseConnections(null, cstmt, conn);
        }

        return null;
    }

    public String CompleteReinsurance() {
        //String computePremium="BEGIN LMS_WEB_PKG_GRP_UW.reinsure(?,?,?);END;";
        Connection conn = null;
        CallableStatement cst3 = null;
        CorrespondenceManipulation mail = new CorrespondenceManipulation();
        try {
          
            conn = new DBConnector().getDatabaseConn();

            //Confirm that the current user can complete this task.
            workflowProcessing bpm = new workflowProcessing();
            String Rights = null;
            if (endrSA.getValue() == null) {
                session.setAttribute("SumAssured", "0");
            } else {
                session.setAttribute("SumAssured",
                                     endrSA.getValue().toString());
            }
            session.setAttribute("DebitCredit", "C");
            //session.setAttribute("riMedicals", "Y");
            String Cursta = (String)session.getAttribute("CurrentStatus");
            if (Cursta.equalsIgnoreCase("P")) {
                //LOVCC.ProcessShtDesc = "UWNB";
                //LOVCC.ProcessAreaShtDesc = "NBUW";
                //LOVCC.ProcessSubAShtDesc = "NBUW";
                session.setAttribute("ProcessShtDesc", "UWNB");
                session.setAttribute("ProcessAreaShtDesc", "NBUW");
                session.setAttribute("ProcessSubAShtDesc", "NBUW");
            } else {
                //LOVCC.ProcessShtDesc = "UW" + LOVCC.Endorsement;
                //LOVCC.ProcessAreaShtDesc = LOVCC.Endorsement + "UW";
                //LOVCC.ProcessSubAShtDesc = LOVCC.Endorsement + "UW";
                session.setAttribute("ProcessShtDesc",
                                     "UW" + session.getAttribute("Endorsement"));
                session.setAttribute("ProcessAreaShtDesc",
                                     session.getAttribute("Endorsement") +
                                     "UW");
                session.setAttribute("ProcessSubAShtDesc",
                                     session.getAttribute("Endorsement") +
                                     "UW");
            }

            Rights = bpm.CheckUserRights();
            if (Rights.equalsIgnoreCase("N")) {
                String Message =
                    "You do not have rights to Complete this Task.";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));
                return null;

            }

            //confirm that there is someone to perform the next task before completing
            String NextUser = null;
            Cursta = (String)session.getAttribute("CurrentStatus");
            if (Cursta.equalsIgnoreCase("P")) {
                //LOVCC.ProcessShtDesc = "UWNB";
                //LOVCC.ProcessAreaShtDesc = "NBUW";
                //LOVCC.ProcessSubAShtDesc = "NBAU";
                session.setAttribute("ProcessShtDesc", "UWNB");
                session.setAttribute("ProcessAreaShtDesc", "NBUW");
                session.setAttribute("ProcessSubAShtDesc", "NBAU");
            } else {
                //LOVCC.ProcessShtDesc = "UW" + LOVCC.Endorsement;
                //LOVCC.ProcessAreaShtDesc = LOVCC.Endorsement + "UW";
                //LOVCC.ProcessSubAShtDesc = LOVCC.Endorsement + "AU";
                session.setAttribute("ProcessShtDesc",
                                     "UW" + session.getAttribute("Endorsement"));
                session.setAttribute("ProcessAreaShtDesc",
                                     session.getAttribute("Endorsement") +
                                     "UW");
                session.setAttribute("ProcessSubAShtDesc",
                                     session.getAttribute("Endorsement") +
                                     "AU");
            }
            //LOVCC.TaskAssignee = null;
            session.setAttribute("TaskAssignee", null);
            session.setAttribute("NextTaskAssignee", "N");
            ADFUtils.findIterator("findTicketAssigneeIterator").executeQuery();
            NextUser = (String)session.getAttribute("NextTaskAssignee");
            String TaskAss = (String)session.getAttribute("TaskAssignee");
            if (TaskAss == null) {
                TaskAss = (String)session.getAttribute("Username");
                session.setAttribute("TaskAssignee", TaskAss);
            }
            if (TaskAss == null && NextUser.equalsIgnoreCase("N")) {
                String Message =
                    "There is no User to Assign the Next Task. Consult the Administrator.";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));
                return null;

            }
            String Taske = (String)session.getAttribute("TaskID");
            System.out.println("Tasks " + Taske);
            if (Taske == null) {
                String Message = "No Task Selected";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));
                return null;

            }

            String MyTask = null;

            String Complete =
                "BEGIN TQC_WEB_PKG.check_task_completion(?,?,?,?);END;";
            cst3 = conn.prepareCall(Complete);
            if (postUnderwritingReinsurance().equalsIgnoreCase("N")) {
                cst3.setString(1, "UREIN");
            } else {
                cst3.setString(1, "UREIN1");
            }
            cst3.setString(2, (String)session.getAttribute("TaskID"));
            cst3.setInt(3, (Integer)session.getAttribute("sysCode"));
            cst3.registerOutParameter(4, oracle.jdbc.OracleTypes.VARCHAR);
            cst3.execute();

            MyTask = cst3.getString(4);
            conn.close();
            Cursta = (String)session.getAttribute("CurrentStatus");
            if (MyTask.equalsIgnoreCase("N") && Cursta.equalsIgnoreCase("P")) {
                String Message =
                    "the Task Selected Does not Correspond to the Activity being Performed. Cannot Complete please " +
                    session.getAttribute("TaskActivityName");
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));
                return null;
            }


            /* if (!LOVCC.CurrentStatus.equalsIgnoreCase("P")) {
                String Message = "Reinsurance Done Successfully";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));
                return null;

            } */

            workflowProcessing wf = new workflowProcessing();
            Rights = bpm.CheckUserRights();
            if (Rights.equalsIgnoreCase("Y")) {
                wf.CompleteTask();
                String Message = "Reinsurance Successfully Done";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));

            } else {
                TaskAss = (String)session.getAttribute("TaskAssignee");
                if (TaskAss == null) {
                    GetAssignee();
                    return null;
                } else {
                    wf.CompleteTask();
                    String Message =
                        "Current Task Complete. The Next Task " + (String)session.getAttribute("TaskActivityName") +
                        " has been Successfully assigned to " +
                        (String)session.getAttribute("TaskAssignee");
                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                  Message,
                                                                                  Message));
                    session.setAttribute("TaskID", null);
                    return null;
                }
            }
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        } finally {
            mail.emailReport("REIN");
            GlobalCC.CloseConnections(null, cst3, conn);
        }


        return null;
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
            cst.registerOutParameter(2, OracleTypes.VARCHAR);
            cst.execute();
            postUndReinsStat = cst.getString(2);

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return postUndReinsStat;
    }


    public String ComputePremiumForRI() {
        String computePremium =
            "BEGIN LMS_WEB_PKG_GRP_UW.reinsure(?,?,?,?);END;";
        Connection conn = null;
        CallableStatement cstmt = null;
        try {
            workflowProcessing bpm = new workflowProcessing();
            Rendering render = new Rendering();
            conn = new DBConnector().getDatabaseConn();

            cstmt = conn.prepareCall(computePremium);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("endorsementCode"));
            cstmt.setBigDecimal(2,
                                (BigDecimal)session.getAttribute("transactionNumber"));
            cstmt.setBigDecimal(3, (BigDecimal)session.getAttribute("TaCode"));
            cstmt.setBigDecimal(4, null);
            cstmt.execute();

            ADFUtils.findIterator("FindRiDetailsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(riTrtDtlsLOV);

            ADFUtils.findIterator("FindRiTrtDetailsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(riTrtDtlsLOV);

            ADFUtils.findIterator("findSchemeFacrePlacementsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(schemefucPrcpts);

            ADFUtils.findIterator("findTotalMemberRiExcessIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(totalSA);
            AdfFacesContext.getCurrentInstance().addPartialTarget(totRet);
            AdfFacesContext.getCurrentInstance().addPartialTarget(totExcess);

            ADFUtils.findIterator("FindAALMemIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(aalLOV);
            String Message = "Reinsurance Done Successfully";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
            conn.close();

            /*if (session.getAttribute("riMedicals") != null) {
                if (session.getAttribute("riMedicals").equals("Y")) {
                    String Cursta =
                        (String)session.getAttribute("CurrentStatus");
                    if (Cursta.equalsIgnoreCase("P")) {
                        //LOVCC.ProcessShtDesc = "UWNB";
                        //LOVCC.ProcessAreaShtDesc = "NBUW";
                        //LOVCC.ProcessSubAShtDesc = "NBUW";
                        session.setAttribute("ProcessShtDesc", "UWNB");
                        session.setAttribute("ProcessAreaShtDesc", "NBUW");
                        session.setAttribute("ProcessSubAShtDesc", "NBUW");
                    } else {
                        //LOVCC.ProcessShtDesc = "UW" + LOVCC.Endorsement;
                        //LOVCC.ProcessAreaShtDesc = LOVCC.Endorsement + "UW";
                        //LOVCC.ProcessSubAShtDesc = LOVCC.Endorsement + "UW";
                        session.setAttribute("ProcessShtDesc",
                                             "UW" + session.getAttribute("Endorsement"));
                        session.setAttribute("ProcessAreaShtDesc",
                                             session.getAttribute("Endorsement") +
                                             "UW");
                        session.setAttribute("ProcessSubAShtDesc",
                                             session.getAttribute("Endorsement") +
                                             "UW");
                    }
                    if (!render.isRimedTask() && render.isExpressVisible()) {
                        workflowProcessing wf = new workflowProcessing();
                        String Rights = bpm.CheckUserRights();

                        if (Rights.equalsIgnoreCase("N")) {
                            Message =
                                    "You do not have rights to Complete this Task.";
                            FacesContext.getCurrentInstance().addMessage(null,
                                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                          Message,
                                                                                          Message));
                            return null;

                        }
                        System.out.println("Checking the task!");
                        wf.CompleteTask();
                    }
                }
            }*/

        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        } finally {
            GlobalCC.CloseConnections(null, cstmt, conn);
        }

        return null;
    }

    public String AuthoriseRI() {
        String computePremium =
            "BEGIN LMS_GRP_WEB_PKG.Auth_reinsure(?,?);END;";
        Connection conn = null;
        CallableStatement cstmt = null;
        try {
            conn = new DBConnector().getDatabaseConn();

            cstmt = conn.prepareCall(computePremium);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("endorsementCode"));
            cstmt.setBigDecimal(2,
                                (BigDecimal)session.getAttribute("transactionNumber"));
            cstmt.execute();

            ADFUtils.findIterator("FindRiDetailsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(riTrtDtlsLOV);

            ADFUtils.findIterator("FindRiTrtDetailsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(riTrtDtlsLOV);

            ADFUtils.findIterator("findSchemeFacrePlacementsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(schemefucPrcpts);

            session.setAttribute("EndorseRIAuth", "Y");

            ADFUtils.findIterator("findTotalMemberRiExcessIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(totalSA);
            AdfFacesContext.getCurrentInstance().addPartialTarget(totRet);
            AdfFacesContext.getCurrentInstance().addPartialTarget(totExcess);

            String Message = "Reinsurance Authorised Successfully";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
            conn.close();
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        } finally {
            GlobalCC.CloseConnections(null, cstmt, conn);
        }

        return null;
    }

    public String PopulateRITreaties() {
        String computePremium =
            "BEGIN LMS_WEB_PKG_GRP_UW.pop_grp_treaties(?,?,?,?,?,?,?,?);END;";
        Connection conn = null;
        CallableStatement cstmt = null;
        try {
            conn = new DBConnector().getDatabaseConn();

            cstmt = conn.prepareCall(computePremium);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("endorsementCode"));
            cstmt.setBigDecimal(2,
                                (BigDecimal)session.getAttribute("transactionNumber"));
            cstmt.setBigDecimal(3, (BigDecimal)session.getAttribute("TaCode"));
            if (facultativeCbox.isSelected()) {
                cstmt.setString(4, "Y");
            } else {
                cstmt.setString(4, "N");
            }
            if (session.getAttribute("facRateType") == null) {
                session.setAttribute("facRateType", "PR");
                cstmt.setString(5, "PR");
            } else {
                cstmt.setString(5,
                                (String)session.getAttribute("facRateType"));
            }
            cstmt.setBigDecimal(6,
                                (BigDecimal)session.getAttribute("reinsPmasCode"));
            if (session.getAttribute("reinUnitRate") == null) {
                cstmt.setBigDecimal(7, null);
            } else {
                //cstmt.setInt(7, (Integer)session.getAttribute("reinUnitRate"));
                cstmt.setBigDecimal(7,
                                    (BigDecimal)session.getAttribute("reinUnitRate"));
            }
            if (session.getAttribute("reinUnitRateDivFac") == null) {
                cstmt.setBigDecimal(8, null);
            } else {
                cstmt.setInt(8,
                             (Integer)session.getAttribute("reinUnitRateDivFac"));
            }

            cstmt.execute();

            ADFUtils.findIterator("FindRiDetailsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(riTrtDtlsLOV);

            ADFUtils.findIterator("FindRiTrtDetailsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(riTrtDtlsLOV);

            ADFUtils.findIterator("findTotalMemberRiExcessIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(totalSA);
            AdfFacesContext.getCurrentInstance().addPartialTarget(totRet);
            AdfFacesContext.getCurrentInstance().addPartialTarget(totExcess);


            ADFUtils.findIterator("findSchemeFacrePlacementsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(schemefucPrcpts);

            String Message = "Treaties Populated Successfully";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
            conn.close();
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
            ex.printStackTrace();
        } finally {
            GlobalCC.CloseConnections(null, cstmt, conn);
        }

        return null;
    }

    public String UpdateFacreRateType() {
        String computePremium =
            "BEGIN LMS_WEB_PKG_GRP_UW.update_facre_rate_type(?,?);END;";
        Connection conn = null;
        CallableStatement cstmt = null;
        try {
            conn = new DBConnector().getDatabaseConn();

            cstmt = conn.prepareCall(computePremium);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("endorsementCode"));
            if (rateType.getValue() == null) {
                cstmt.setString(2, "PR");
            } else {
                cstmt.setString(2, rateType.getValue().toString());
            }
            cstmt.execute();

            session.setAttribute("facRateType",
                                 rateType.getValue().toString());
            ADFUtils.findIterator("findSchemeFacrePlacementsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(schemefucPrcpts);


            String Message = "Facre Rate Type Updated Successfully";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
            conn.close();
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        } finally {
            GlobalCC.CloseConnections(null, cstmt, conn);
        }

        return null;
    }

    public String UpdateFacreOwnShre() {
        String computePremium =
            "BEGIN LMS_WEB_PKG_GRP_UW.update_rein_own_fac_share(?,?);END;";
        Connection conn = null;
        CallableStatement cstmt = null;
        try {
            conn = new DBConnector().getDatabaseConn();

            cstmt = conn.prepareCall(computePremium);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("endorsementCode"));
            if (ownFacShare.getValue() == null) {
                cstmt.setString(2, null);
            } else {
                cstmt.setString(2, ownFacShare.getValue().toString());
            }
            cstmt.execute();
            cstmt.close();

            ADFUtils.findIterator("findSchemeFacrePlacementsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(schemefucPrcpts);

            GlobalCC.INFORMATIONREPORTING("Facultative Own Share Updated Successfully.");

            conn.close();
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        } finally {
            GlobalCC.CloseConnections(null, cstmt, conn);
        }

        return null;
    }

    public void setOsLoanCalculation(RichSelectOneChoice osLoanCalculation) {
        this.osLoanCalculation = osLoanCalculation;
    }

    public RichSelectOneChoice getOsLoanCalculation() {
        return osLoanCalculation;
    }

    public void GetOSLoanCalculation(ValueChangeEvent valueChangeEvent) {
        if (osLoanCalculation.getValue() == null) {
            //LOVCC.OSLoanCalculation=null;
            session.setAttribute("OSLoanCalculation", null);
        } else {
            //LOVCC.OSLoanCalculation=osLoanCalculation.getValue().toString();
            session.setAttribute("OSLoanCalculation",
                                 osLoanCalculation.getValue().toString());
        }

    }

    public void setPolicyMembersLOV(RichTable policyMembersLOV) {
        this.policyMembersLOV = policyMembersLOV;
    }

    public RichTable getPolicyMembersLOV() {
        return policyMembersLOV;
    }

    public String ShowCoverDetails() {
        try {
            GlobalCC.RedirectPage("/coverdtls.jspx");
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(null, ex);
        }
        return null;
    }

    public String ViewMemberMedicalDetails() {
        CorrespondenceManipulation mail = new CorrespondenceManipulation();
        try {
            mail.emailReport("MED");
            GlobalCC.RedirectPage("/policyMedicals.jspx");
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(null, ex);
        }
        return null;
    }

    public void GetSelectedPolicyNumber(SelectionEvent selectionEvent) {

        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindPolicyMemberAtCoversIterator");
        RowKeySet set = selectionEvent.getAddedSet();
        Iterator rowKeySetIter = set.iterator();


        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            //LOVCC.MemberNumber=(BigDecimal)r.getAttribute("POLM_CODE");
            session.setAttribute("MemberNumber", r.getAttribute("POLM_CODE"));
            session.setAttribute("MemberNumber1",
                                 r.getAttribute("POLM_MEM_CODE"));

            //LOVCC.MemberNumber=Integer.parseInt(""+polmCode);
            //System.out.println("MEMBER NUMBER"+LOVCC.MemberNumber);

            ADFUtils.findIterator("FindMemberCoverTypesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(policyMemberCoversLOV);

            ADFUtils.findIterator("findMemberPensionDtlsIterator").executeQuery();

            AdfFacesContext.getCurrentInstance().addPartialTarget(pensWEF);
            AdfFacesContext.getCurrentInstance().addPartialTarget(pensEarnings);
            AdfFacesContext.getCurrentInstance().addPartialTarget(pensTotalContri);
            AdfFacesContext.getCurrentInstance().addPartialTarget(pensEmprContr);
            AdfFacesContext.getCurrentInstance().addPartialTarget(pensAnnFund);
            AdfFacesContext.getCurrentInstance().addPartialTarget(pensAdminFee);
            AdfFacesContext.getCurrentInstance().addPartialTarget(pensEmpeContri);
            AdfFacesContext.getCurrentInstance().addPartialTarget(pensIntRate);
            AdfFacesContext.getCurrentInstance().addPartialTarget(pensAnnFac);
            AdfFacesContext.getCurrentInstance().addPartialTarget(empeVolContr);
            AdfFacesContext.getCurrentInstance().addPartialTarget(pensAnnum);
            AdfFacesContext.getCurrentInstance().addPartialTarget(pensEMV);
            AdfFacesContext.getCurrentInstance().addPartialTarget(pensEmprEMV);
            AdfFacesContext.getCurrentInstance().addPartialTarget(pensEmpeEMV);
            AdfFacesContext.getCurrentInstance().addPartialTarget(annuityAmount);
            AdfFacesContext.getCurrentInstance().addPartialTarget(pastLiability);
            AdfFacesContext.getCurrentInstance().addPartialTarget(futureLiability);
            AdfFacesContext.getCurrentInstance().addPartialTarget(totalLiability);

            ADFUtils.findIterator("FindMembersBeneficiariesCoversIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(studentsLOV);
            
            ADFUtils.findIterator("FindMembersAnnDependentsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(annDependantsLOV);

            ADFUtils.findIterator("FindMembersExceptionsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(polMemberExceptions);

            ADFUtils.findIterator("findPolicyMemberSubdivisionsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(memberSDivTable);

            ADFUtils.findIterator("findMemberProvisionsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(memberProvisionLOV);

            ADFUtils.findIterator("FindJointMembersIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(jointMemTable);

        }

    }

    public void GetSelectedPolicyNumberForRI(SelectionEvent selectionEvent) {

        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindPolicyMemberAtCoversIterator");
        RowKeySet set = selectionEvent.getAddedSet();
        Iterator rowKeySetIter = set.iterator();


        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            //LOVCC.MemberNumber=(BigDecimal)r.getAttribute("POLM_CODE");
            session.setAttribute("MemberNumber", r.getAttribute("POLM_CODE"));

            session.setAttribute("pmrid_code", null);

            ADFUtils.findIterator("FindRiDetailsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(riTrtDtlsLOV);

            ADFUtils.findIterator("FindRiTrtDetailsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(memRiTreatyDtlsLOV);

            ADFUtils.findIterator("findFulcatativePlacementsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(fucPlacement);

        }

    }

    public void setPolicyMemberCoversLOV(RichTable policyMemberCoversLOV) {
        this.policyMemberCoversLOV = policyMemberCoversLOV;
    }

    public RichTable getPolicyMemberCoversLOV() {
        return policyMemberCoversLOV;
    }

    public String DeleteMemberCovers() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindPolicyMemberAtCoversIterator");
        RowKeySet set = policyMembersLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            //LOVCC.PolmCode=(BigDecimal)r.getAttribute("POLM_CODE");
            //LOVCC.PolmMemCode=(BigDecimal)r.getAttribute("POLM_MEM_CODE");
            session.setAttribute("PolmCode", r.getAttribute("POLM_CODE"));
            session.setAttribute("PolmMemCode",
                                 r.getAttribute("POLM_MEM_CODE"));

        }
        String deleteMember =
            "BEGIN LMS_WEB_PKG_GRP.del_mem_covers(?,?,?);END;";
        Connection conn = new DBConnector().getDatabaseConn();
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall(deleteMember);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("endorsementCode"));
            cstmt.setBigDecimal(2,
                                (BigDecimal)session.getAttribute("PolmCode"));
            cstmt.setBigDecimal(3,
                                (BigDecimal)session.getAttribute("PolmMemCode"));

            cstmt.execute();

            ADFUtils.findIterator("FindPolicyMemberAtCoversIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(policyMembersLOV);
            conn.close();
            //recomputePremium.setDisabled(false);
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        } finally {
            GlobalCC.CloseConnections(null, cstmt, conn);
        }
        return null;
    }

    public String ShowRiTreaties() {
        try {
            //LOVCC.MemberNumber = null;
            session.setAttribute("MemberNumber", null);
            session.setAttribute("PMRID_CODE", null);
            session.setAttribute("pmritd_code", null);


            //ADFUtils.findIterator("FindRiDetailsIterator").executeQuery();
            //ADFUtils.findIterator("FindRiTrtDetailsIterator").executeQuery();
            GlobalCC.RedirectPage("/g_reinpl.jspx");
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(null, ex);
        }
        return null;
    }


    public String BackToPolicy() {
        try {
            session.removeAttribute("delExistMembers");
            String Val = (String)session.getAttribute("callScreen");
            if (Val == null) {
                session.setAttribute("editComponents", "N");
                GlobalCC.RedirectPage("/g_undwrt.jspx");
            } else if (Val.equalsIgnoreCase("covers")) {
                session.removeAttribute("callScreen");
                GlobalCC.RedirectPage("/coverdtls.jspx");
            } else {
                session.setAttribute("editComponents", "N");
                GlobalCC.RedirectPage("/g_undwrt.jspx");
            }
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(null, ex);
        }
        return null;
    }

    public String determinePerformReinsure() {
        Connection conn = null;
        try {
            conn = new DBConnector().getDatabaseConn();
            CallableStatement cst3 = null;
            String Complete =
                "BEGIN LMS_WEB_CURSOR_GRP.determinepostdocstransition(?,?);END;";
            cst3 = conn.prepareCall(Complete);
            cst3.setBigDecimal(1,
                               (BigDecimal)session.getAttribute("endorsementCode"));
            cst3.registerOutParameter(2, oracle.jdbc.OracleTypes.VARCHAR);
            cst3.execute();
            session.setAttribute("performRein", cst3.getString(2));
            System.out.println("NextTransition" + cst3.getString(2));
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public void setMakeReadyBtn(RichCommandButton makeReadyBtn) {
        this.makeReadyBtn = makeReadyBtn;
    }

    public RichCommandButton getMakeReadyBtn() {
        return makeReadyBtn;
    }

    public void setAuthoriseBtn(RichCommandButton authoriseBtn) {
        this.authoriseBtn = authoriseBtn;
    }

    public RichCommandButton getAuthoriseBtn() {
        return authoriseBtn;
    }

    public void setDpdCoverType(RichSelectOneChoice dpdCoverType) {
        this.dpdCoverType = dpdCoverType;
    }

    public RichSelectOneChoice getDpdCoverType() {
        return dpdCoverType;
    }

    public void setDpdsCoverTypesLOV(RichTable dpdsCoverTypesLOV) {
        this.dpdsCoverTypesLOV = dpdsCoverTypesLOV;
    }

    public RichTable getDpdsCoverTypesLOV() {
        return dpdsCoverTypesLOV;
    }

    public String AttachDependentCoverTypes() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindCoverTypesIterator");
        RowKeySet set = dpdsCoverTypesLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            //LOVCC.CoverTypeCode=(BigDecimal)r.getAttribute("PCVT_CVT_CODE");
            session.setAttribute("CoverTypeCode",
                                 r.getAttribute("PCVT_CVT_CODE"));
            //LOVCC.qcvtCode=(BigDecimal)r.getAttribute("PCVT_CVT_CODE");
            session.setAttribute("qcvtCode", r.getAttribute("PCVT_CVT_CODE"));
            //LOVCC.pcvtCode=(BigDecimal)r.getAttribute("PCVT_CODE");
            session.setAttribute("pcvtCode", r.getAttribute("PCVT_CODE"));
            dpdCoverType.setValue(r.getAttribute("PCVT_CVT_SHT_DESC"));

        }
        return null;
    }

    public void setDpdCategoryLOV(RichTable dpdCategoryLOV) {
        this.dpdCategoryLOV = dpdCategoryLOV;
    }

    public RichTable getDpdCategoryLOV() {
        return dpdCategoryLOV;
    }

    public String AssignDependentCategory() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findCategoryIterator");
        RowKeySet set = dpdCategoryLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            //LOVCC.pcaCode=(BigDecimal)r.getAttribute("lcaCode");
            session.setAttribute("pcaCode", r.getAttribute("lcaCode"));

            dpdCatDescDisp.setValue(r.getAttribute("catDesc"));
            AdfFacesContext.getCurrentInstance().addPartialTarget(dpdCatDescDisp);
        }
        return null;
    }

    public void setDpdCatDescDisp(RichOutputText dpdCatDescDisp) {
        this.dpdCatDescDisp = dpdCatDescDisp;
    }

    public RichOutputText getDpdCatDescDisp() {
        return dpdCatDescDisp;
    }

    public void GetFCLType(ValueChangeEvent valueChangeEvent) {
        if (fclCalcType.getValue() == null) {
            //LOVCC.FclCalcType=null;
            session.setAttribute("FclCalcType", null);
        } else {
            //LOVCC.FclCalcType=fclCalcType.getValue().toString();
            session.setAttribute("FclCalcType",
                                 fclCalcType.getValue().toString());
        }
    }

    public String ShowFCL() {

        try {
            if (endrFCLAmt.getValue() == null) {
                computedFCL.setValue(null);
            } else {
                computedFCL.setValue(endrFCLAmt.getValue().toString());
            }
            if (endrFclType.getValue() == null) {
                fclCalcType.setValue("T");
            } else {
                fclCalcType.setValue(endrFclType.getValue().toString());
            }

            GlobalCC.showPopup("lmsgroup:detFCL");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String DetermineFCL() {
        BigDecimal fclAmt, overideFCL = null;
        String fclQuery = "BEGIN LMS_WEB_PKG_GRP.determine_fcl(?,?,?,?);END;";
        Connection conn = null;
        CallableStatement ctsmt = null;
        try {
            if (fclCalcType.getValue() == null) {
                String message = "Select an FCL Calculation Type";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                              message,
                                                                              message));
                return null;
            }
            DBConnector myConn = new DBConnector();
            conn = myConn.getDatabaseConn();
            ctsmt = conn.prepareCall(fclQuery);
            ctsmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("endorsementCode"));
            ctsmt.setString(2, (String)session.getAttribute("FclCalcType"));
            ctsmt.registerOutParameter(3, OracleTypes.INTEGER);
            ctsmt.registerOutParameter(4, OracleTypes.INTEGER);
            ctsmt.execute();
            fclAmt = ctsmt.getBigDecimal(3);
            overideFCL = ctsmt.getBigDecimal(4);
            computedFCL.setValue(fclAmt);
            overrideFCL.setValue(overideFCL);
            //endrFclType.setValue(session.getAttribute("FclCalcType"));
            endrFCLAmt.setValue(fclAmt);
            endrOvrFCLAmt.setValue(overideFCL);

            ADFUtils.findIterator("FindEndorsementsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(endrFclType);
            AdfFacesContext.getCurrentInstance().addPartialTarget(endrFCLAmt);
            AdfFacesContext.getCurrentInstance().addPartialTarget(endrOvrFCLAmt);


            ADFUtils.findIterator("FindPolicyFCLMembersIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(aboveFclLOV);


            GlobalCC.INFORMATIONREPORTING("Free Cover Limit Processing Has Been Completed Successfully");
            conn.close();
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        } finally {
            GlobalCC.CloseConnections(null, ctsmt, conn);
        }
        return null;
    }


    public String CompleteFCL() {
        BigDecimal fclAmt, overideFCL = null;
        //String fclQuery="BEGIN LMS_WEB_PKG_GRP.determine_fcl(?,?,?,?);END;";
        Connection conn = null;
        CallableStatement cst3 = null;
        try {
            DBConnector myConn = new DBConnector();
            conn = myConn.getDatabaseConn();
            /* if(LOVCC.FclCalcType == null){
              String message = "Select an FCL Calculation Type";
              FacesContext.getCurrentInstance().addMessage(null,
                                                           new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                            message,
                                                                            message));
              return null;
          }
          */
            //Confirm that the current user can complete this task.
            workflowProcessing bpm = new workflowProcessing();
            String Rights = null;
            if (endrSA2.getValue() == null) {
                session.setAttribute("SumAssured", "0");
            } else {
                session.setAttribute("SumAssured",
                                     endrSA2.getValue().toString());
            }
            session.setAttribute("DebitCredit", "C");
            String Cursta = (String)session.getAttribute("CurrentStatus");
            if (Cursta.equalsIgnoreCase("P")) {
                //LOVCC.ProcessShtDesc = "UWNB";
                //LOVCC.ProcessAreaShtDesc = "NBUW";
                //LOVCC.ProcessSubAShtDesc = "NBUW";
                session.setAttribute("ProcessShtDesc", "UWNB");
                session.setAttribute("ProcessAreaShtDesc", "NBUW");
                session.setAttribute("ProcessSubAShtDesc", "NBUW");
            } else {
                //LOVCC.ProcessShtDesc = "UW" + LOVCC.Endorsement;
                //LOVCC.ProcessAreaShtDesc = LOVCC.Endorsement + "UW";
                //LOVCC.ProcessSubAShtDesc = LOVCC.Endorsement + "UW";
                session.setAttribute("ProcessShtDesc",
                                     "UW" + session.getAttribute("Endorsement"));
                session.setAttribute("ProcessAreaShtDesc",
                                     session.getAttribute("Endorsement") +
                                     "UW");
                session.setAttribute("ProcessSubAShtDesc",
                                     session.getAttribute("Endorsement") +
                                     "UW");
            }

            Rights = bpm.CheckUserRights();
            if (Rights.equalsIgnoreCase("N")) {
                String Message =
                    "You do not have rights to Complete this Task.";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));
                return null;

            }

            //confirm that there is someone to perform the next task before completing
            String NextUser = null;
            Cursta = (String)session.getAttribute("CurrentStatus");
            if (Cursta.equalsIgnoreCase("P")) {
                //LOVCC.ProcessShtDesc = "UWNB";
                //LOVCC.ProcessAreaShtDesc = "NBUW";
                //LOVCC.ProcessSubAShtDesc = "NBAU";
                session.setAttribute("ProcessShtDesc", "UWNB");
                session.setAttribute("ProcessAreaShtDesc", "NBUW");
                session.setAttribute("ProcessSubAShtDesc", "NBAU");
            } else {
                //LOVCC.ProcessShtDesc = "UW" + LOVCC.Endorsement;
                //LOVCC.ProcessAreaShtDesc = LOVCC.Endorsement + "UW";
                //LOVCC.ProcessSubAShtDesc = LOVCC.Endorsement + "AU";
                session.setAttribute("ProcessShtDesc",
                                     "UW" + session.getAttribute("Endorsement"));
                session.setAttribute("ProcessAreaShtDesc",
                                     session.getAttribute("Endorsement") +
                                     "UW");
                session.setAttribute("ProcessSubAShtDesc",
                                     session.getAttribute("Endorsement") +
                                     "AU");
            }
            session.setAttribute("TaskAssignee", null);
            //LOVCC.TaskAssignee = null;
            session.setAttribute("NextTaskAssignee", "N");
            ADFUtils.findIterator("findTicketAssigneeIterator").executeQuery();
            NextUser = (String)session.getAttribute("NextTaskAssignee");
            String TaskAss = (String)session.getAttribute("TaskAssignee");
            if (TaskAss == null && NextUser.equalsIgnoreCase("N")) {
                String Message =
                    "There is no User to Assign the Next Task. Consult the Administrator.";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));
                return null;

            }
            String Taske = (String)session.getAttribute("TaskID");
            if (Taske == null) {
                String Message = "No Task Selected";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));
                return null;

            }

            String MyTask = null;

            String Complete =
                "BEGIN TQC_WEB_PKG.check_task_completion(?,?,?);END;";
            cst3 = conn.prepareCall(Complete);
            cst3.setString(1, "UMEDI");
            cst3.setString(2, (String)session.getAttribute("TaskID"));
            cst3.registerOutParameter(3, oracle.jdbc.OracleTypes.VARCHAR);
            cst3.execute();
            conn.close();
            MyTask = cst3.getString(3);
            if (MyTask.equalsIgnoreCase("N")) {
                String Message =
                    "the Task Selected Does not Correspond to the Activity being Performed. Cannot Complete please " +
                    session.getAttribute("TaskActivityName");
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));
                return null;
            }


            workflowProcessing wf = new workflowProcessing();
            Rights = bpm.CheckUserRights();
            if (Rights.equalsIgnoreCase("Y")) {
                wf.CompleteTask();
                String Msg =
                    "Free Cover Limit Processing Has Been Completed Successfully";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Msg,
                                                                              Msg));

            } else {
                TaskAss = (String)session.getAttribute("TaskAssignee");
                if (TaskAss == null) {
                    GetAssignee();
                    return null;
                } else {
                    wf.CompleteTask();
                    String Message =
                        "Current Task Complete. The Next Task " + (String)session.getAttribute("TaskActivityName") +
                        " has been Successfully assigned to " +
                        (String)session.getAttribute("TaskAssignee");
                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                  Message,
                                                                                  Message));
                    session.setAttribute("TaskID", null);
                    return null;
                }
            }
            conn.close();
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        } finally {
            GlobalCC.CloseConnections(null, cst3, conn);
        }
        return null;
    }

    public String SendForMedicals() {
        String fclQuery =
            "BEGIN LMS_GRP_WEB_PKG.determine_medicals(?,?,?);END;";
        Connection conn = null;
        CallableStatement ctsmt = null;
        try {

            DBConnector myConn = new DBConnector();
            conn = myConn.getDatabaseConn();
            ctsmt = conn.prepareCall(fclQuery);
            ctsmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("policyCode"));
            ctsmt.setBigDecimal(2,
                                (BigDecimal)session.getAttribute("endorsementCode"));
            if (endrOvrFCLAmt.getValue() == null) {
                ctsmt.setString(3, null);
            } else {
                ctsmt.setString(3, endrOvrFCLAmt.getValue().toString());
            }


            ctsmt.execute();
            conn.close();
            GlobalCC.RedirectPage("/policyMedicals.jspx");

        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        } finally {
            GlobalCC.CloseConnections(null, ctsmt, conn);
        }
        return null;
    }

    public void setRecomputePremium(RichCommandButton recomputePremium) {
        this.recomputePremium = recomputePremium;
    }

    public RichCommandButton getRecomputePremium() {
        return recomputePremium;
    }

    public void setFclCalcType(RichSelectOneChoice fclCalcType) {
        this.fclCalcType = fclCalcType;
    }

    public RichSelectOneChoice getFclCalcType() {
        return fclCalcType;
    }

    public void setComputedFCL(RichInputText computedFCL) {
        this.computedFCL = computedFCL;
    }

    public RichInputText getComputedFCL() {
        return computedFCL;
    }

    public void setOverrideFCL(RichInputText overrideFCL) {
        this.overrideFCL = overrideFCL;
    }

    public RichInputText getOverrideFCL() {
        return overrideFCL;
    }

    public String Reinsure() {
        try {
            GlobalCC.RedirectPage("/undwrmem.jspx");
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(null, ex);
        }
        return null;
    }

    public String ClearCessions() {
        String clearQuery = "BEGIN LMS_GRP_WEB_PKG.clear_cessions(?,?);END;";

        Connection conn = new DBConnector().getDatabaseConn();
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall(clearQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("policyCode"));
            cstmt.setBigDecimal(2,
                                (BigDecimal)session.getAttribute("endorsementCode"));
            cstmt.execute();
            conn.close();
            String Message = "Cessions Successfully Cleared.";
            reinMaskDesc.setValue(null);
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));


            ADFUtils.findIterator("FindRiDetailsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(riTrtDtlsLOV);
            ADFUtils.findIterator("FindRiTrtDetailsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(memRiTreatyDtlsLOV);
            ADFUtils.findIterator("findFulcatativePlacementsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(fucPlacement);
            ADFUtils.findIterator("findTotalMemberRiExcessIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(totalSA);
            AdfFacesContext.getCurrentInstance().addPartialTarget(totRet);
            AdfFacesContext.getCurrentInstance().addPartialTarget(totExcess);
            AdfFacesContext.getCurrentInstance().addPartialTarget(reinMaskDesc);
            session.setAttribute("reinsPmasCode", null);
            session.setAttribute("reinUnitRate", null);
            session.setAttribute("reinUnitRateDivFac", null);


        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        } finally {
            GlobalCC.CloseConnections(null, cstmt, conn);
        }
        return null;
    }

    public void setMemRiTreatyDtlsLOV(RichTable memRiTreatyDtlsLOV) {
        this.memRiTreatyDtlsLOV = memRiTreatyDtlsLOV;
    }

    public RichTable getMemRiTreatyDtlsLOV() {
        return memRiTreatyDtlsLOV;
    }

    public void setRiTrtDtlsLOV(RichTable riTrtDtlsLOV) {
        this.riTrtDtlsLOV = riTrtDtlsLOV;
    }

    public RichTable getRiTrtDtlsLOV() {
        return riTrtDtlsLOV;
    }

    public String ImportTemplate() {
        try {
            GlobalCC.RedirectPage("/FileUpload.jspx");
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(null, ex);
        }
        return null;
    }

    public void ImportTemplate(ActionEvent actionEvent) {
        // Add event code here...
    }

    public String DeletePolicyMembers() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindPolicyMembersIterator");
        RowKeySet set = policyMembers.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            //LOVCC.PolmCode=(BigDecimal)r.getAttribute("POLM_CODE");
            ///LOVCC.PolmMemCode=(BigDecimal)r.getAttribute("MEM_CODE");
            session.setAttribute("PolmCode", r.getAttribute("POLM_CODE"));
            session.setAttribute("PolmMemCode", r.getAttribute("MEM_CODE"));

        }
        String deleteMember =
            "BEGIN LMS_WEB_PKG_GRP.del_mem_covers(?,?,?);END;";
        Connection conn = new DBConnector().getDatabaseConn();
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall(deleteMember);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("endorsementCode"));
            cstmt.setBigDecimal(2,
                                (BigDecimal)session.getAttribute("PolmCode"));
            cstmt.setBigDecimal(3,
                                (BigDecimal)session.getAttribute("PolmMemCode"));

            cstmt.execute();
            conn.close();
            ADFUtils.findIterator("FindPolicyMembersIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(policyMembers);
            //recomputePremium.setDisabled(false);
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        } finally {
            GlobalCC.CloseConnections(null, cstmt, conn);
        }
        return null;
    }

    public String DelNBSchedule() {
        Connection conn = null;
        CallableStatement cstmt = null;
        try {
            String deleteMember =
                "BEGIN LMS_WEB_PKG_GRP.del_nb_schedule(?,?);END;";
            conn = new DBConnector().getDatabaseConn();
            cstmt = conn.prepareCall(deleteMember);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("policyCode"));
            cstmt.setBigDecimal(2,
                                (BigDecimal)session.getAttribute("endorsementCode"));
            cstmt.execute();
            cstmt.close();
            conn.close();

            ADFUtils.findIterator("FindPolicyMembersIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(policyMembers);
            GlobalCC.INFORMATIONREPORTING("Member Schedule Deleted.");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(null, cstmt, conn);
        }
        return null;
    }

    public void setPolicyMembers(RichTable policyMembers) {
        this.policyMembers = policyMembers;
    }

    public RichTable getPolicyMembers() {
        return policyMembers;
    }

    public void setPolicyPremiumsLOV(RichTable policyPremiumsLOV) {
        this.policyPremiumsLOV = policyPremiumsLOV;
    }

    public RichTable getPolicyPremiumsLOV() {
        return policyPremiumsLOV;
    }

    public void setPolicyNumberDisplay(RichInputText policyNumberDisplay) {
        this.policyNumberDisplay = policyNumberDisplay;
    }

    public RichInputText getPolicyNumberDisplay() {
        return policyNumberDisplay;
    }

    public void setPolicyReceiptsLOV(RichTable policyReceiptsLOV) {
        this.policyReceiptsLOV = policyReceiptsLOV;
    }

    public RichTable getPolicyReceiptsLOV() {
        return policyReceiptsLOV;
    }

    public void setPolRecptsInslmntsLOV(RichTable polRecptsInslmntsLOV) {
        this.polRecptsInslmntsLOV = polRecptsInslmntsLOV;
    }

    public RichTable getPolRecptsInslmntsLOV() {
        return polRecptsInslmntsLOV;
    }

    public void setCoverDescDisplay(RichInputText coverDescDisplay) {
        this.coverDescDisplay = coverDescDisplay;
    }

    public RichInputText getCoverDescDisplay() {
        return coverDescDisplay;
    }

    public void setProductCoverTypesLOV(RichTable productCoverTypesLOV) {
        this.productCoverTypesLOV = productCoverTypesLOV;
    }

    public RichTable getProductCoverTypesLOV() {
        return productCoverTypesLOV;
    }

    public void setOverridePremDisplay(RichInputText overridePremDisplay) {
        this.overridePremDisplay = overridePremDisplay;
    }

    public RichInputText getOverridePremDisplay() {
        return overridePremDisplay;
    }

    public void setLoadingTypeSelect(RichSelectOneChoice loadingTypeSelect) {
        this.loadingTypeSelect = loadingTypeSelect;
    }

    public RichSelectOneChoice getLoadingTypeSelect() {
        return loadingTypeSelect;
    }

    public void setDiscLoadRateDisplay(RichInputText discLoadRateDisplay) {
        this.discLoadRateDisplay = discLoadRateDisplay;
    }

    public RichInputText getDiscLoadRateDisplay() {
        return discLoadRateDisplay;
    }

    public void setSumAssuredDisplay(RichInputText sumAssuredDisplay) {
        this.sumAssuredDisplay = sumAssuredDisplay;
    }

    public RichInputText getSumAssuredDisplay() {
        return sumAssuredDisplay;
    }

    public String AssignCategoryPremiumMask() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findPremiumMaskIterator");
        RowKeySet set = catMaskTable.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            session.setAttribute("categoryMaskCode",
                                 r.getAttribute("PMAS_CODE"));
            catMaskDesc.setValue(r.getAttribute("PMAS_SHT_DESC"));

            AdfFacesContext.getCurrentInstance().addPartialTarget(catMaskDesc);
            GlobalCC.hidePopup("lmsgroup:popup11");

        }
        return null;
    }

    public String AssignCoverPremiumMask() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findPremiumMaskIterator");
        RowKeySet set = maskTable.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            session.setAttribute("coverMaskCode", r.getAttribute("PMAS_CODE"));
            maskDesc.setValue(r.getAttribute("PMAS_SHT_DESC"));

            AdfFacesContext.getCurrentInstance().addPartialTarget(maskDesc);
            GlobalCC.hidePopup("lmsgroup:popup10");
        }
        return null;
    }

    public String SaveProductCoverTypes() {

        String saveQuery =
            "BEGIN LMS_WEB_PKG_GRP.populate_policy_cover_types(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);END;";
        Connection conn = new DBConnector().getDatabaseConn();
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall(saveQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("CVT_CODE"));
            cstmt.setBigDecimal(2,
                                (BigDecimal)session.getAttribute("policyCode"));
            cstmt.setBigDecimal(3,
                                (BigDecimal)session.getAttribute("endorsementCode"));
            if (loadingTypeSelect.getValue() == null) {
                cstmt.setString(4, null);
            } else {
                cstmt.setString(4, loadingTypeSelect.getValue().toString());
            }

            if (overridePremDisplay.getValue() == null) {
                cstmt.setString(5, null);
            } else {
                cstmt.setBigDecimal(5,
                                    new BigDecimal(overridePremDisplay.getValue().toString()));
            }
            if (discLoadRateDisplay.getValue() == null) {
                cstmt.setBigDecimal(6, null);
            } else {
                cstmt.setBigDecimal(6,
                                    new BigDecimal(discLoadRateDisplay.getValue().toString()));
            }

            if (sumAssuredDisplay.getValue() == null) {
                cstmt.setBigDecimal(7, null);
            } else {
                cstmt.setBigDecimal(7,
                                    new BigDecimal(sumAssuredDisplay.getValue().toString()));
            }

            if (avANB.getValue() == null) {
                cstmt.setBigDecimal(8, null);
            } else {
                cstmt.setString(8, avANB.getValue().toString());
            }
            cstmt.setBigDecimal(9,
                                (BigDecimal)session.getAttribute("pcvtCode"));
            cstmt.setString(10, null);
            cstmt.setString(11, null);
            if (divFactor.getValue() == null) {
                cstmt.setBigDecimal(12, null);
            } else {
                cstmt.setString(12, divFactor.getValue().toString());
            }
            if (percMainCvt.getValue() == null) {
                cstmt.setBigDecimal(13, null);
            } else {
                cstmt.setString(13, percMainCvt.getValue().toString());
            }
            if (mainCover.getValue() == null) {
                cstmt.setBigDecimal(14, null);
            } else {
                cstmt.setString(14, mainCover.getValue().toString());
            }
            if (discChoice.getValue() == null) {
                cstmt.setBigDecimal(15, null);
            } else {
                cstmt.setString(15, discChoice.getValue().toString());
            }
            if (discRateDisplay.getValue() == null) {
                cstmt.setBigDecimal(16, null);
            } else {
                cstmt.setString(16, discRateDisplay.getValue().toString());
            }
            if (discDivFactor.getValue() == null) {
                cstmt.setBigDecimal(17, null);
            } else {
                cstmt.setString(17, discDivFactor.getValue().toString());
            }
            if (rateSelection.getValue() == null) {
                cstmt.setBigDecimal(18, null);
            } else {
                cstmt.setString(18, rateSelection.getValue().toString());
            }
            cstmt.setBigDecimal(19,
                                (BigDecimal)session.getAttribute("coverMaskCode"));
            if (maskDesc.getValue() == null) {
                cstmt.setBigDecimal(20, null);
            } else {
                cstmt.setString(20, maskDesc.getValue().toString());
            }
            if (coverRate.getValue() == null) {
                cstmt.setBigDecimal(21, null);
            } else {
                cstmt.setString(21, coverRate.getValue().toString());
            }
            if (coverRateDivFactor.getValue() == null) {
                cstmt.setBigDecimal(22, null);
            } else {
                cstmt.setString(22, coverRateDivFactor.getValue().toString());
            }
            if (ageLoadFactor.getValue() == null) {
                cstmt.setBigDecimal(23, null);
            } else {
                cstmt.setString(23, ageLoadFactor.getValue().toString());
            }
            if(builtin.getValue()==null){
              cstmt.setString(24,null);
            }else{
              cstmt.setString(24,builtin.getValue().toString());
            }
            if(accelerator.getValue()==null){
              cstmt.setString(25,null);
            }else{
              cstmt.setString(25,accelerator.getValue().toString());
            }

            cstmt.execute();
            conn.close();

            session.setAttribute("pcvtCode", null);

            ADFUtils.findIterator("FindCoverTypesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(policyCoverTypesLOV);
        } catch (Exception ex) {
            //LOVCC.pcvtCode = null;
            session.setAttribute("pcvtCode", null);
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        } finally {
            GlobalCC.CloseConnections(null, cstmt, conn);
        }
        return null;
    }

    public String AttachProductCoverType() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindProductCoversIterator");
        RowKeySet set = productCoverTypesLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            //LOVCC.CVT_CODE=(BigDecimal)r.getAttribute("cvt_code");
            //LOVCC.PCT_CODE=(BigDecimal)r.getAttribute("pct_code");
            session.setAttribute("CVT_CODE", r.getAttribute("cvt_code"));
            session.setAttribute("PCT_CODE", r.getAttribute("pct_code"));
            LOVCC.RefundFormular =
                    (String)r.getAttribute("pct_refund_formular");
            LOVCC.CoverFormular = (String)r.getAttribute("pct_formular");
            coverDescDisplay.setValue(r.getAttribute("cvt_desc"));
            AdfFacesContext.getCurrentInstance().addPartialTarget(coverDescDisplay);
        }
        return null;
    }

    public void setRecptPremAmtDisp(RichInputText recptPremAmtDisp) {
        this.recptPremAmtDisp = recptPremAmtDisp;
    }

    public RichInputText getRecptPremAmtDisp() {
        return recptPremAmtDisp;
    }

    public void setRecptPensAmtDisp(RichInputText recptPensAmtDisp) {
        this.recptPensAmtDisp = recptPensAmtDisp;
    }

    public RichInputText getRecptPensAmtDisp() {
        return recptPensAmtDisp;
    }

    public void setRecptGrossAmtDisplay(RichInputText recptGrossAmtDisplay) {
        this.recptGrossAmtDisplay = recptGrossAmtDisplay;
    }

    public RichInputText getRecptGrossAmtDisplay() {
        return recptGrossAmtDisplay;
    }

    public void setToPolNoDisplay(RichInputText toPolNoDisplay) {
        this.toPolNoDisplay = toPolNoDisplay;
    }

    public RichInputText getToPolNoDisplay() {
        return toPolNoDisplay;
    }

    public String AttachTransferPolicies() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindPolicyPremiumsIterator");
        RowKeySet set = transferPoliciesLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
            //LOVCC.PolicyCodeTo = (BigDecimal)r.getAttribute("POL_CODE");
            session.setAttribute("PolicyCodeTo", r.getAttribute("POL_CODE"));
            toPolNoDisplay.setValue(r.getAttribute("POL_POLICY_NO"));
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(toPolNoDisplay);
        GlobalCC.hidePopup("lmsgroup:transferPopup");
        return null;
    }

    public String CancelTransferPolicies() {
        GlobalCC.hidePopup("lmsgroup:transferPopup");
        return null;
    }

    public void setTransferPoliciesLOV(RichTable transferPoliciesLOV) {
        this.transferPoliciesLOV = transferPoliciesLOV;
    }

    public RichTable getTransferPoliciesLOV() {
        return transferPoliciesLOV;
    }

    public void setNewPremAllocDisp(RichInputText newPremAllocDisp) {
        this.newPremAllocDisp = newPremAllocDisp;
    }

    public RichInputText getNewPremAllocDisp() {
        return newPremAllocDisp;
    }

    public void setNewPensionAlloc(RichInputText newPensionAlloc) {
        this.newPensionAlloc = newPensionAlloc;
    }

    public RichInputText getNewPensionAlloc() {
        return newPensionAlloc;
    }

    public void setNewTotalAllocation(RichInputText newTotalAllocation) {
        this.newTotalAllocation = newTotalAllocation;
    }

    public RichInputText getNewTotalAllocation() {
        return newTotalAllocation;
    }

    public String AddTransfer() {

        newPremAllocDisp.setValue(null);
        newPensionAlloc.setValue(null);
        newTotalAllocation.setValue(null);
        session.setAttribute("PolicyCodeTo", null);
        toPolNoDisplay.setValue(null);


        if (session.getAttribute("GrctCode") == null) {
            GlobalCC.INFORMATIONREPORTING("Select A Receipt.");
            return null;
        } else {
            GlobalCC.showPopup("lmsgroup:p1");
        }
        return null;
    }

    public String LogTransfer() {
        String transferQuery =
            "BEGIN LMS_WEB_PKG_GRP.log_transfer(?,?,?,?,?,?,?,?);END;";
        Connection conn = new DBConnector().getDatabaseConn();
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall(transferQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("policyCode"));
            cstmt.setBigDecimal(2,
                                (BigDecimal)session.getAttribute("PolicyCodeTo")); //LOVCC.PolicyCodeTo);
            if (newPremAllocDisp.getValue() == null) {
                cstmt.setBigDecimal(3, null);
            } else {
                cstmt.setBigDecimal(3,
                                    new BigDecimal(newPremAllocDisp.getValue().toString()));
            }
            if (newPensionAlloc.getValue() == null) {
                cstmt.setBigDecimal(4, null);
            } else {
                cstmt.setBigDecimal(4,
                                    new BigDecimal(newPensionAlloc.getValue().toString()));
            }

            if (newTotalAllocation.getValue() == null) {
                cstmt.setBigDecimal(5, null);
            } else {
                cstmt.setBigDecimal(5,
                                    new BigDecimal(newTotalAllocation.getValue().toString()));
            }
            cstmt.setBigDecimal(6,
                                (BigDecimal)session.getAttribute("GrctCode"));
            cstmt.registerOutParameter(7, OracleTypes.INTEGER);
            cstmt.setString(8, itNarrReasons.getValue().toString());
            cstmt.execute();
            cstmt.close();

            //LOVCC.TransferCode = cstmt.getBigDecimal(6);

            ADFUtils.findIterator("FindReceiptTransfersIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(transfersTable);

            GlobalCC.hidePopup("lmsgroup:p1");
            GlobalCC.INFORMATIONREPORTING("Record Successfully Saved.");
            conn.close();
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
            ex.printStackTrace();
        } finally {
            GlobalCC.CloseConnections(null, cstmt, conn);
        }
        return null;
    }


    public String AuthoriseTransfer() {
        String authTransfer = "BEGIN LMS_WEB_PKG_GRP.auth_transfer(?);END;";
        Connection conn = new DBConnector().getDatabaseConn();
        CallableStatement cstmt = null;
        try {
            RowKeySet rowKeySet = transfersTable.getSelectedRowKeys();
            if (rowKeySet == null) {
                return null;
            }
            if (!rowKeySet.iterator().hasNext()) //no selection
            {
                GlobalCC.errorValueNotEntered("No Record Selected");
                return null;
            }
            Object key2 = rowKeySet.iterator().next();
            transfersTable.setRowKey(key2);
            JUCtrlValueBinding r =
                (JUCtrlValueBinding)transfersTable.getRowData();
            if (r == null) {
                GlobalCC.errorValueNotEntered("No Record Selected");
                return null;
            }

            cstmt = conn.prepareCall(authTransfer);
            cstmt.setBigDecimal(1,
                                (BigDecimal)r.getAttribute("GGTRAN_DTLS_TRAN_CODE"));
            cstmt.execute();
            cstmt.close();
            GlobalCC.INFORMATIONREPORTING("Record Successfully Authorised.");
            ADFUtils.findIterator("FindReceiptTransfersIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(transfersTable);
            conn.close();
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        } finally {
            GlobalCC.CloseConnections(null, cstmt, conn);
        }
        return null;
    }

    public String DeleteTransfer() {
        String authTransfer = "BEGIN LMS_WEB_PKG_GRP.delete_transfer(?);END;";
        Connection conn = new DBConnector().getDatabaseConn();
        CallableStatement cstmt = null;
        try {
            RowKeySet rowKeySet = transfersTable.getSelectedRowKeys();
            if (rowKeySet == null) {
                return null;
            }
            if (!rowKeySet.iterator().hasNext()) //no selection
            {
                GlobalCC.errorValueNotEntered("No Record Selected");
                return null;
            }
            Object key2 = rowKeySet.iterator().next();
            transfersTable.setRowKey(key2);
            JUCtrlValueBinding r =
                (JUCtrlValueBinding)transfersTable.getRowData();
            if (r == null) {
                GlobalCC.errorValueNotEntered("No Record Selected");
                return null;
            }

            cstmt = conn.prepareCall(authTransfer);
            cstmt.setBigDecimal(1,
                                (BigDecimal)r.getAttribute("GGTRAN_DTLS_TRAN_CODE"));
            cstmt.execute();
            cstmt.close();
            GlobalCC.INFORMATIONREPORTING("Record Successfully Deleted.");
            ADFUtils.findIterator("FindReceiptTransfersIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(transfersTable);
            conn.close();
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        } finally {
            GlobalCC.CloseConnections(null, cstmt, conn);
        }
        return null;
    }

    public void setBasicDetailsTab(RichPanelBox basicDetailsTab) {
        this.basicDetailsTab = basicDetailsTab;
    }

    public RichPanelBox getBasicDetailsTab() {
        return basicDetailsTab;
    }

    public void setPolicyDetailsTab(RichPanelBox policyDetailsTab) {
        this.policyDetailsTab = policyDetailsTab;
    }

    public RichPanelBox getPolicyDetailsTab() {
        return policyDetailsTab;
    }

    public void setAgentPolicyPayTab(RichPanelBox agentPolicyPayTab) {
        this.agentPolicyPayTab = agentPolicyPayTab;
    }

    public RichPanelBox getAgentPolicyPayTab() {
        return agentPolicyPayTab;
    }

    public void coverTypeListener(SelectionEvent selectionEvent) {
        // Add event code here...
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindProductCoversIterator");
        RowKeySet set = selectionEvent.getAddedSet();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            //LOVCC.CVT_CODE=(BigDecimal)r.getAttribute("cvt_code");
            //LOVCC.PCT_CODE=(BigDecimal)r.getAttribute("pct_code");
            session.setAttribute("CVT_CODE", r.getAttribute("cvt_code"));
            session.setAttribute("PCT_CODE", r.getAttribute("pct_code"));
            LOVCC.RefundFormular =
                    (String)r.getAttribute("pct_refund_formular");
            LOVCC.CoverFormular = (String)r.getAttribute("pct_formular");
            coverDescDisplay.setValue(r.getAttribute("cvt_desc"));
            AdfFacesContext.getCurrentInstance().addPartialTarget(coverDescDisplay);
        }
    }

    public String findCoversSel() {

        try {
            // Add event code here...
            DCIteratorBinding dciter =
                ADFUtils.findIterator("FindProductCoversIterator");
            RowKeySet set = productCoverTypesLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                session.setAttribute("CVT_CODE", r.getAttribute("cvt_code"));
                session.setAttribute("PCT_CODE", r.getAttribute("pct_code"));
                LOVCC.RefundFormular =
                        (String)r.getAttribute("pct_refund_formular");
                LOVCC.CoverFormular = (String)r.getAttribute("pct_formular");
                coverDescDisplay.setValue(r.getAttribute("cvt_desc"));

                session.setAttribute("pcvtCode", null);

                overridePremDisplay.setValue(null);
                sumAssuredDisplay.setValue(null);
                discLoadRateDisplay.setValue(null);
                loadingTypeSelect.setValue("N");
                avANB.setValue(null);
                String CmainCover = (String)r.getAttribute("cvt_main_cover");
                if (CmainCover == null) {
                    percMainCvtLabel.setRendered(false);
                    percMainCvt.setRendered(false);
                    mainCoverLabel.setRendered(false);
                    mainCover.setRendered(false);
                    percMainCvt.setValue(null);
                    mainCover.setValue(null);
                } else if (CmainCover.equalsIgnoreCase("M")) {
                    percMainCvtLabel.setRendered(false);
                    percMainCvt.setRendered(false);
                    mainCoverLabel.setRendered(false);
                    mainCover.setRendered(false);
                    percMainCvt.setValue(null);
                    mainCover.setValue(null);
                } else {
                    percMainCvtLabel.setRendered(true);
                    percMainCvt.setRendered(true);
                    mainCoverLabel.setRendered(true);
                    mainCover.setRendered(true);
                    percMainCvt.setValue(r.getAttribute("pct_main_sa_perc"));
                    mainCover.setValue(r.getAttribute("cvt_main_cover"));
                }

                AdfFacesContext.getCurrentInstance().addPartialTarget(coverDescDisplay);
                AdfFacesContext.getCurrentInstance().addPartialTarget(sumAssuredDisplay);
                AdfFacesContext.getCurrentInstance().addPartialTarget(overridePremDisplay);
                AdfFacesContext.getCurrentInstance().addPartialTarget(discLoadRateDisplay);
                AdfFacesContext.getCurrentInstance().addPartialTarget(loadingTypeSelect);


                // Render Popup
                ExtendedRenderKitService erkService =
                    Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                       ExtendedRenderKitService.class);
                erkService.addScript(FacesContext.getCurrentInstance(),
                                     "var hints = {autodismissNever:false}; " +
                                     "AdfPage.PAGE.findComponent('" +
                                     "lmsgroup:polcvrdtls" +
                                     "').show(hints);");
            }

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return null;
    }

    public void setCoverTypeTab(RichPanelBox coverTypeTab) {
        this.coverTypeTab = coverTypeTab;
    }

    public RichPanelBox getCoverTypeTab() {
        return coverTypeTab;
    }

    public void categoryListener(SelectionEvent selectionEvent) {
        // Add event code here...
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findCategoryIterator");
        RowKeySet set = selectionEvent.getAddedSet();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            //LOVCC.pcaCode=(BigDecimal)r.getAttribute("lcaCode");
            session.setAttribute("pcaCode", r.getAttribute("lcaCode"));

            dpdCatDescDisp.setValue(r.getAttribute("catDesc"));
            AdfFacesContext.getCurrentInstance().addPartialTarget(dpdCatDescDisp);
        }
    }

    public void CategoryTreeListener(SelectionEvent selectionEvent) {
        // Add event code here...
        if (selectionEvent.getAddedSet() != selectionEvent.getRemovedSet()) {
            RowKeySet keys = selectionEvent.getAddedSet();
            if (keys != null && keys.getSize() > 0) {
                for (Object treeRowKey : keys) {
                    categoryTree.setRowKey(treeRowKey);
                    JUCtrlHierNodeBinding nd =
                        (JUCtrlHierNodeBinding)categoryTree.getRowData();

                    session.setAttribute("pcaCode",
                                         nd.getRow().getAttribute("lcaCode"));
                    categIDDisplay.setValue(nd.getRow().getAttribute("catShtDesc"));
                    categDescriptionDisplay.setValue(nd.getRow().getAttribute("catDesc"));
                    categPeriodDisplay.setValue(nd.getRow().getAttribute("catPeriod"));
                    dpdCatDescDisp.setValue(nd.getRow().getAttribute("catDesc"));
                    session.setAttribute("schCode",
                                         nd.getRow().getAttribute("pca_sch_code"));

                    accessGrpDisplay1.setValue(nd.getRow().getAttribute("lpag_desc"));
                    session.setAttribute("catlpagCode",
                                         nd.getRow().getAttribute("pca_lpag_code"));

                    session.setAttribute("categoryMaskCode",
                                         nd.getRow().getAttribute("pmas_code"));
                    catMaskDesc.setValue(nd.getRow().getAttribute("pmas_sht_desc"));
                    
                    catSelectRate.setValue(nd.getRow().getAttribute("PCA_USE_CVR_RATE"));
                    if(nd.getRow().getAttribute("PCA_USE_CVR_RATE") == null){
                        session.setAttribute("categoryMaskCode",
                                             nd.getRow().getAttribute("pmas_code"));
                        catMaskDesc.setValue(nd.getRow().getAttribute("pmas_sht_desc"));
                        catMaskButton.setDisabled(true);
                        catRate.setDisabled(true);
                        catRate.setValue(nd.getRow().getAttribute("PCA_RATE"));
                        catRateDivFac.setDisabled(true);
                        catSelectRate.setValue("M");
                        catRateDivFac.setValue(nd.getRow().getAttribute("PCA_RATE_DIV_FACT"));
                    }else if(nd.getRow().getAttribute("PCA_USE_CVR_RATE").equals("M")){
                        session.setAttribute("categoryMaskCode",
                                             nd.getRow().getAttribute("pmas_code"));
                        catMaskDesc.setValue(nd.getRow().getAttribute("pmas_sht_desc"));
                        catMaskButton.setDisabled(true);
                        catRate.setDisabled(true);
                        catRate.setValue(nd.getRow().getAttribute("PCA_RATE"));
                        catRateDivFac.setDisabled(true);
                        catRateDivFac.setValue(nd.getRow().getAttribute("PCA_RATE_DIV_FACT"));
                    }else if(nd.getRow().getAttribute("PCA_USE_CVR_RATE").equals("S")){
                        session.setAttribute("categoryMaskCode",
                                             nd.getRow().getAttribute("pmas_code"));
                        catMaskDesc.setValue(nd.getRow().getAttribute("pmas_sht_desc"));
                        catMaskButton.setDisabled(false);
                        catRate.setDisabled(true);
                        catRate.setValue(nd.getRow().getAttribute("PCA_RATE"));
                        catRateDivFac.setDisabled(true);
                        catRateDivFac.setValue(nd.getRow().getAttribute("PCA_RATE_DIV_FACT"));
                    }else{
                        session.setAttribute("categoryMaskCode",
                                             nd.getRow().getAttribute("pmas_code"));
                        catMaskDesc.setValue(nd.getRow().getAttribute("pmas_sht_desc"));
                        catMaskButton.setDisabled(true);
                        catRate.setDisabled(false);
                        catRate.setValue(nd.getRow().getAttribute("PCA_RATE"));
                        catRateDivFac.setDisabled(false);
                        catRateDivFac.setValue(nd.getRow().getAttribute("PCA_RATE_DIV_FACT"));
                    }
                    

                    ADFUtils.findIterator("FindDependentsLimitsIterator").executeQuery();
                    AdfFacesContext.getCurrentInstance().addPartialTarget(policyDependentLimitsLOV);

                }
            }
        }
    }
    
    public void CategoryRateListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if (valueChangeEvent.getOldValue() != valueChangeEvent.getNewValue()) {
            if (catSelectRate.getValue() == null) {

                session.setAttribute("categoryMaskCode",
                                     (BigDecimal)session.getAttribute("pmasCode"));
                catMaskDesc.setValue((String)session.getAttribute("pmasShtDesc"));

                catMaskButton.setDisabled(true);
                catRate.setDisabled(true);
                catRate.setValue(null);
                catRateDivFac.setDisabled(true);
                catRateDivFac.setValue(null);
            } else if (catSelectRate.getValue().toString().equalsIgnoreCase("M")) {

                session.setAttribute("categoryMaskCode",
                                     (BigDecimal)session.getAttribute("pmasCode"));
                catMaskDesc.setValue((String)session.getAttribute("pmasShtDesc"));

                catMaskButton.setDisabled(true);
                catRate.setDisabled(true);
                catRate.setValue(null);
                catRateDivFac.setDisabled(true);
                catRateDivFac.setValue(null);
            } else if (catSelectRate.getValue().toString().equalsIgnoreCase("S")) {

                session.setAttribute("categoryMaskCode", null);
                
                catMaskDesc.setValue(null);
                catMaskButton.setDisabled(false);
                catRate.setDisabled(true);
                catRate.setValue(null);
                catRateDivFac.setDisabled(true);
                catRateDivFac.setValue(null);
            } else if (catSelectRate.getValue().toString().equalsIgnoreCase("C")) {

                session.setAttribute("categoryMaskCode", null);
                catMaskDesc.setValue(null);
                catMaskButton.setDisabled(true);
                catRate.setDisabled(false);
                catRate.setValue(null);
                catRateDivFac.setDisabled(false);
                catRateDivFac.setValue(null);
            }
            AdfFacesContext.getCurrentInstance().addPartialTarget(catMaskDesc);
            AdfFacesContext.getCurrentInstance().addPartialTarget(catMaskButton);
            AdfFacesContext.getCurrentInstance().addPartialTarget(catRate);
            AdfFacesContext.getCurrentInstance().addPartialTarget(catRateDivFac);
        }
    }

    public String AddPolicyCategory() {
        session.setAttribute("pcaCode", null);
        session.setAttribute("schCode", null);
        categIDDisplay.setValue(null);
        categDescriptionDisplay.setValue(null);
        categPeriodDisplay.setValue(null);
        accessGrpDisplay1.setValue(session.getAttribute("lpagDesc"));
        session.setAttribute("catlpagCode", session.getAttribute("lpagCode"));
        session.setAttribute("categoryMaskCode",
                             session.getAttribute("pmasCode"));
        catMaskDesc.setValue(session.getAttribute("pmasShtDesc"));
        
        catSelectRate.setValue("M");
        catMaskButton.setDisabled(true);
        catRate.setDisabled(true);
        catRate.setValue(null);
        catRateDivFac.setDisabled(true);
        catRateDivFac.setValue(null);
        
        ADFUtils.findIterator("FindDependentsLimitsIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(policyDependentLimitsLOV);
        return null;
    }


    public void coverTypesListener(SelectionEvent selectionEvent) {
        // Add event code here...
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindCoverTypesIterator");
        RowKeySet set = selectionEvent.getAddedSet();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            //LOVCC.CoverTypeCode=(BigDecimal)r.getAttribute("PCVT_CVT_CODE");
            session.setAttribute("CoverTypeCode",
                                 r.getAttribute("PCVT_CVT_CODE"));
            //LOVCC.qcvtCode=(BigDecimal)r.getAttribute("PCVT_CVT_CODE");
            session.setAttribute("qcvtCode", r.getAttribute("PCVT_CVT_CODE"));
            //LOVCC.pcvtCode=(BigDecimal)r.getAttribute("PCVT_CODE");
            session.setAttribute("pcvtCode", r.getAttribute("PCVT_CODE"));
            dpdCoverType.setValue(r.getAttribute("PCVT_CVT_SHT_DESC"));

        }
    }

    public String findcoverTypesSel() {
        try {

            DCIteratorBinding dciter =
                ADFUtils.findIterator("FindCoverTypesIterator");
            RowKeySet set = dpdsCoverTypesLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            //System.out.println(1);
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                //LOVCC.CoverTypeCode=(BigDecimal)r.getAttribute("PCVT_CVT_CODE");
                session.setAttribute("CoverTypeCode",
                                     r.getAttribute("PCVT_CVT_CODE"));
                //LOVCC.qcvtCode=(BigDecimal)r.getAttribute("PCVT_CVT_CODE");
                session.setAttribute("qcvtCode",
                                     r.getAttribute("PCVT_CVT_CODE"));
                //LOVCC.pcvtCode=(BigDecimal)r.getAttribute("PCVT_CODE");
                session.setAttribute("pcvtCode", r.getAttribute("PCVT_CODE"));
                //dpdCoverType.setValue(r.getAttribute("PCVT_CVT_SHT_DESC"));
                //LOVCC.pdlCode = null;
                //LOVCC.pcaCode = null;
                session.setAttribute("pdlCode", null);
                session.setAttribute("pcaCode", null);

                // Render Popup
                ExtendedRenderKitService erkService =
                    Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                       ExtendedRenderKitService.class);
                erkService.addScript(FacesContext.getCurrentInstance(),
                                     "var hints = {autodismissNever:false}; " +
                                     "AdfPage.PAGE.findComponent('" +
                                     "lmsgroup:polcats" + "').show(hints);");

            }

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String findcoverTypesSel1() {
        try {

            DCIteratorBinding dciter =
                ADFUtils.findIterator("FindCoverTypesIterator");
            RowKeySet set = dpdsCoverTypesLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();


                session.setAttribute("CoverTypeCode",
                                     r.getAttribute("PCVT_CVT_CODE"));
                session.setAttribute("qcvtCode",
                                     r.getAttribute("PCVT_CVT_CODE"));
                session.setAttribute("pcvtCode", r.getAttribute("PCVT_CODE"));
                //dpdCoverType.setValue(r.getAttribute("PCVT_CVT_SHT_DESC"));
                session.setAttribute("pdlCode", null);

                // Render Popup
                ExtendedRenderKitService erkService =
                    Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                       ExtendedRenderKitService.class);
                erkService.addScript(FacesContext.getCurrentInstance(),
                                     "var hints = {autodismissNever:false}; " +
                                     "AdfPage.PAGE.findComponent('" +
                                     "lmsgroup:poldepstypes" +
                                     "').show(hints);");

            }

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String findCategSel() {

        try {

            // Add event code here...
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findCategoryIterator");
            RowKeySet set = polCatLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            //System.out.println(1);
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                //LOVCC.pcaCode=(BigDecimal)r.getAttribute("lcaCode");
                session.setAttribute("pcaCode", r.getAttribute("lcaCode"));

                dpdCatDescDisp.setValue(r.getAttribute("catDesc"));
                AdfFacesContext.getCurrentInstance().addPartialTarget(dpdCatDescDisp);

                // Render Popup
                ExtendedRenderKitService erkService =
                    Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                       ExtendedRenderKitService.class);
                erkService.addScript(FacesContext.getCurrentInstance(),
                                     "var hints = {autodismissNever:false}; " +
                                     "AdfPage.PAGE.findComponent('" +
                                     "lmsgroup:poldepstypes" +
                                     "').show(hints);");
            }

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return null;
    }

    public void depsListener(SelectionEvent selectionEvent) {
        // Add event code here...
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindDependentsIterator");
        RowKeySet set = selectionEvent.getAddedSet();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            //LOVCC.dtyCode=(BigDecimal)r.getAttribute("DTY_CODE");
            session.setAttribute("dtyCode", r.getAttribute("DTY_CODE"));
            dependentTypeDisplay.setValue(r.getAttribute("DTY_DESCRIPTION"));


            //LOVCC.maxType=(BigDecimal)r.getAttribute("PCD_MAX_NO_ALLOWED");
            session.setAttribute("maxType",
                                 r.getAttribute("PCD_MAX_NO_ALLOWED"));
            maxTypeDisplay.setValue(r.getAttribute("PCD_MAX_NO_ALLOWED"));

        }
    }

    public String findDepsSel() {

        try {

            // Add event code here...
            DCIteratorBinding dciter =
                ADFUtils.findIterator("FindDependentsIterator");
            RowKeySet set = dependentTypesLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            //System.out.println(1);
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                //LOVCC.dtyCode=(BigDecimal)r.getAttribute("DTY_CODE");
                session.setAttribute("dtyCode", r.getAttribute("DTY_CODE"));
                dependentTypeDisplay.setValue(r.getAttribute("DTY_DESCRIPTION"));

                session.setAttribute("maxType",
                                     r.getAttribute("PCD_MAX_NO_ALLOWED"));
                maxTypeDisplay.setValue(r.getAttribute("PCD_MAX_NO_ALLOWED"));
                //LOVCC.maxType=(BigDecimal)r.getAttribute("PCD_MAX_NO_ALLOWED");
                limitAmountDisplay.setValue(null);
                //maxTypeDisplay.setValue(LOVCC.maxType);

                AdfFacesContext.getCurrentInstance().addPartialTarget(dependentTypeDisplay);
                AdfFacesContext.getCurrentInstance().addPartialTarget(limitAmountDisplay);
                AdfFacesContext.getCurrentInstance().addPartialTarget(maxTypeDisplay);

                // Render Popup
                ExtendedRenderKitService erkService =
                    Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                       ExtendedRenderKitService.class);
                erkService.addScript(FacesContext.getCurrentInstance(),
                                     "var hints = {autodismissNever:false}; " +
                                     "AdfPage.PAGE.findComponent('" +
                                     "lmsgroup:poldepdetails" +
                                     "').show(hints);");
            }

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return null;
    }

    public void taxesListener(SelectionEvent selectionEvent) {
        // Add event code here...
        String Rate = null;
        DCIteratorBinding dciter = ADFUtils.findIterator("FindTaxesIterator");
        RowKeySet set = selectionEvent.getAddedSet();

        Iterator rowKeySetIter = set.iterator();

        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));


            Row r = dciter.getCurrentRow();
            //LOVCC.TaxesCode=(BigDecimal)r.getAttribute("TT_CODE");
            session.setAttribute("TaxesCode", r.getAttribute("TT_CODE"));
            Rate = (String)r.getAttribute("TRT_RATE");
            //LOVCC.TaxRateType =  (String)r.getAttribute("TRT_RATE_TYPE");
            //LOVCC.TaxRenewalEndr = (String)r.getAttribute("TT_RENEWAL_ENDOS");
            session.setAttribute("TaxRateType",
                                 r.getAttribute("TRT_RATE_TYPE"));
            session.setAttribute("TaxRenewalEndr",
                                 r.getAttribute("TT_RENEWAL_ENDOS"));
            taxRate.setValue(Rate);
            taxSel.setValue(r.getAttribute("TT_DESC"));
            //LOVCC.TaxShtDesc = (String)r.getAttribute("TT_SHT_DESC");
            //LOVCC.TaxTRTCode = (BigDecimal)r.getAttribute("TRT_CODE");
            session.setAttribute("TaxShtDesc", r.getAttribute("TT_SHT_DESC"));
            session.setAttribute("TaxTRTCode", r.getAttribute("TRT_CODE"));

            applLevel.setValue(null);
            taxRate.setValue(null);
            taxAmt.setValue(null);

            AdfFacesContext.getCurrentInstance().addPartialTarget(applLevel);
            AdfFacesContext.getCurrentInstance().addPartialTarget(taxRate);
            AdfFacesContext.getCurrentInstance().addPartialTarget(taxAmt);


        }
    }

    public String findTaxSel() {

        try {

            // Add event code here...
            String Rate = null;
            DCIteratorBinding dciter =
                ADFUtils.findIterator("FindTaxesIterator");
            RowKeySet set = allTaxesLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));


                Row r = dciter.getCurrentRow();
                //LOVCC.TaxesCode=(BigDecimal)r.getAttribute("TT_CODE");
                session.setAttribute("TaxesCode", r.getAttribute("TT_CODE"));
                Rate = (String)r.getAttribute("TRT_RATE");
                //LOVCC.TaxRateType =  (String)r.getAttribute("TRT_RATE_TYPE");
                //LOVCC.TaxRenewalEndr = (String)r.getAttribute("TT_RENEWAL_ENDOS");
                session.setAttribute("TaxRateType",
                                     r.getAttribute("TRT_RATE_TYPE"));
                session.setAttribute("TaxRenewalEndr",
                                     r.getAttribute("TT_RENEWAL_ENDOS"));
                taxRate.setValue(Rate);
                taxSel.setValue(r.getAttribute("TT_DESC"));
                //LOVCC.TaxShtDesc = (String)r.getAttribute("TT_SHT_DESC");
                //LOVCC.TaxTRTCode = (BigDecimal)r.getAttribute("TRT_CODE");
                session.setAttribute("TaxShtDesc",
                                     r.getAttribute("TT_SHT_DESC"));
                session.setAttribute("TaxTRTCode", r.getAttribute("TRT_CODE"));
                //LOVCC.ptxCode = null;
                session.setAttribute("ptxCode", null);

                applLevel.setValue(null);
                //taxRate.setValue(null);
                taxAmt.setValue(null);

                AdfFacesContext.getCurrentInstance().addPartialTarget(applLevel);
                AdfFacesContext.getCurrentInstance().addPartialTarget(taxRate);
                AdfFacesContext.getCurrentInstance().addPartialTarget(taxAmt);

                // Render Popup
                ExtendedRenderKitService erkService =
                    Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                       ExtendedRenderKitService.class);
                erkService.addScript(FacesContext.getCurrentInstance(),
                                     "var hints = {autodismissNever:false}; " +
                                     "AdfPage.PAGE.findComponent('" +
                                     "lmsgroup:poltaxes" + "').show(hints);");


            }

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return null;
    }

    public String PopulateTaxes() {
        String populateTaxes =
            "BEGIN LMS_WEB_PKG_GRP.populate_taxes(?,?,?);END;";
        Connection conn = new DBConnector().getDatabaseConn();
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall(populateTaxes);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("policyCode"));
            cstmt.setString(2, "P");
            cstmt.setBigDecimal(3,
                                (BigDecimal)session.getAttribute("endorsementCode"));
            cstmt.execute();
            conn.close();
            ADFUtils.findIterator("FindPolicyTaxesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(taxesLOV);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(null, cstmt, conn);
        }
        return null;
    }

    public String SavePolicyTaxes() {

        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;

        try {

            String AddTax =
                "begin LMS_WEB_PKG_GRP.save_quotation_taxes(?,?,?,?,?,?,?,?,?,?,?,?,?,?);end;";
            cst = conn.prepareCall(AddTax);

            cst.setBigDecimal(1, null);
            if (taxRate.getValue() == null) {
                cst.setBigDecimal(2, null);
            } else {
                cst.setString(2, taxRate.getValue().toString());
            }
            if (taxAmt.getValue() == null) {
                cst.setBigDecimal(3, null);
            } else {
                cst.setString(3, taxAmt.getValue().toString());
            }
            cst.setString(4, (String)session.getAttribute("TaxRateType"));
            if (taxSel.getValue() == null) {
                cst.setString(5, null);
            } else {
                cst.setString(5, taxSel.getValue().toString());
            }
            cst.setString(6, (String)session.getAttribute("QuotationNo"));
            cst.setString(7, (String)session.getAttribute("TaxRenewalEndr"));
            cst.setBigDecimal(8,
                              (BigDecimal)session.getAttribute("TaxesCode"));
            cst.setString(9, (String)session.getAttribute("TaxShtDesc"));
            cst.setBigDecimal(10,
                              (BigDecimal)session.getAttribute("policyCode"));
            cst.setBigDecimal(11,
                              (BigDecimal)session.getAttribute("TaxTRTCode"));
            cst.setString(12, "P");
            cst.setBigDecimal(13,
                              (BigDecimal)session.getAttribute("endorsementCode"));
            cst.setBigDecimal(14, (BigDecimal)session.getAttribute("ptxCode"));


            cst.execute();
            conn.close();
            ADFUtils.findIterator("FindPolicyTaxesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(taxesLOV);


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
        return null;
    }

    public String SavePolicyMember() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;


        try {
            String polQuery =
                "begin LMS_WEB_PKG_GRP.add_member(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?" +
                ",?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?" +
                ",?,?,?,?,?,?,?,?,?);end;";
            cst = conn.prepareCall(polQuery);

            cst.registerOutParameter(1, oracle.jdbc.OracleTypes.DECIMAL);
            cst.setString(2, "P");
            cst.setBigDecimal(3,
                              (BigDecimal)session.getAttribute("endorsementCode"));
            cst.setBigDecimal(4,
                              (BigDecimal)session.getAttribute("policyCode"));
            cst.setBigDecimal(5,
                              (BigDecimal)session.getAttribute("ProductCode"));
            if (quotememANB.getValue() == null) {
                cst.setBigDecimal(6, null);
            } else {
                cst.setString(6, quotememANB.getValue().toString());
            }
            if (memNo.getValue() == null) {
                cst.setString(7, null);
            } else {
                cst.setString(7, memNo.getValue().toString());
            }
            if (memSurname.getValue() == null) {
                cst.setString(8, null);
            } else {
                cst.setString(8, memSurname.getValue().toString());
            }
            if (memloanDate.getValue() == null) {
                cst.setString(9, null);
            } else {
                cst.setString(9,
                              GlobalCC.parseDate(memloanDate.getValue().toString()));
            }
            if (origloanAmt.getValue() == null) {
                cst.setBigDecimal(10, null);
            } else {
                cst.setString(10, origloanAmt.getValue().toString());
            }
            if (loanInt.getValue() == null) {
                cst.setBigDecimal(11, null);
            } else {
                cst.setString(11, loanInt.getValue().toString());
            }
            if (origRepayPeriod.getValue() == null) {
                cst.setBigDecimal(12, null);
            } else {
                cst.setString(12, origRepayPeriod.getValue().toString());
            }
            cst.setString(13, null);
            cst.setDate(14, null); //confirm value?
            if (savingAmt.getValue() == null) {
                cst.setBigDecimal(15, null);
            } else {
                cst.setString(15, savingAmt.getValue().toString());
            }
            if (emprBF.getValue() == null) {
                cst.setBigDecimal(16, null);
            } else {
                cst.setString(16, emprBF.getValue().toString());
            }
            if (empeBF.getValue() == null) {
                cst.setBigDecimal(17, null);
            } else {
                cst.setString(17, empeBF.getValue().toString());
            }
            if (memcontrType.getValue() == null) {
                cst.setString(18, null);
            } else {
                cst.setString(18, memcontrType.getValue().toString());
            }
            if (memcontrType.getValue() == null) {
                cst.setString(19, null);
            } else {
                cst.setString(19, memcontrType.getValue().toString());
            }
            if (empeContr.getValue() == null) {
                cst.setString(20, null);
            } else {
                cst.setString(20, empeContr.getValue().toString());
            }
            if (emprContr.getValue() == null) {
                cst.setString(21, null);
            } else {
                cst.setString(21, emprContr.getValue().toString());
            }
            if (monthlyEarnings.getValue() == null) {
                cst.setString(22, null);
            } else {
                cst.setString(22, monthlyEarnings.getValue().toString());
            }
            if (memEarnprds.getValue() == null) {
                cst.setString(23, null);
            } else {
                cst.setString(23, memEarnprds.getValue().toString());
            }
            cst.setString(24, MemGrpLifeRider);
            cst.setBigDecimal(25,
                              (BigDecimal)session.getAttribute("prpCode")); //scheme ID?
            cst.setInt(26, 1000);
            cst.setString(27, "Self");
            if (memOtherNames.getValue() == null) {
                cst.setString(28, null);
            } else {
                cst.setString(28, memOtherNames.getValue().toString());
            }
            //cst.setString(29, null); //address
            if (addrss.getValue() == null){
                  cst.setString(29, null);
              } else{
                  cst.setString(29, (String)addrss.getValue());
              }
            cst.setString(30, null); //telephone
            if (joinDate.getValue() == null) {
                cst.setString(31, null);
            } else {
                cst.setString(31,
                              GlobalCC.parseDate(joinDate.getValue().toString()));
            }

            if (idNo.getValue() == null) {
                cst.setString(32, null);
            } else {
                cst.setString(32, idNo.getValue().toString());
            }
            if (memdob.getValue() == null) {
                cst.setString(33, null);
            } else {
                if (memdob.getValue().toString().contains(":")) {
                    cst.setString(33,
                                  GlobalCC.parseDate(memdob.getValue().toString()));
                } else {
                    cst.setString(33,
                                  GlobalCC.upDateParseDate(memdob.getValue().toString()));
                }
            }
            cst.setDate(34, null); //employment Date?
            if (memSex.getValue() == null) {
                cst.setString(35, null);
            } else {
                cst.setString(35, memSex.getValue().toString());
            }
            cst.setBigDecimal(36, null); //pdl Code?
            cst.setBigDecimal(37, null); //lc Code?
            if (weight.getValue() == null) {
                cst.setString(38, null);
            } else {
                cst.setString(38, weight.getValue().toString());
            }
            if (height.getValue() == null) {
                cst.setString(39, null);
            } else {
                cst.setString(39, height.getValue().toString());
            }
            cst.setBigDecimal(40,
                              (BigDecimal)session.getAttribute("OccupationCode"));
            if (sysPres.getValue() == null) {
                cst.setString(41, null);
            } else {
                cst.setString(41, sysPres.getValue().toString());
            }
            if (diaPres.getValue() == null) {
                cst.setString(42, null);
            } else {
                cst.setString(42, diaPres.getValue().toString());
            }
            cst.setBigDecimal(43, null); //cmi code?
            cst.setString(44, null); //diability death rate?
            cst.setBigDecimal(45, null); //age at diability death?
            cst.setBigDecimal(46,
                              (BigDecimal)session.getAttribute("PolicyCategory"));
            cst.setBigDecimal(47, null); //basic Salary
            cst.setBigDecimal(48, null); //house allowance
            cst.setBigDecimal(49, null); //transport allowance
            cst.setBigDecimal(50, null); //other allowances
            cst.setBigDecimal(51, null); //annual earnings
            if (loanInstallmentAmt.getValue() == null) {
                cst.setString(52, null); //annual earnings
            } else {
                cst.setString(52,
                              (String)loanInstallmentAmt.getValue()); //annual earnings
            }
            if (loanInstRepayFreq.getValue() == null) {
                cst.setString(53, null); //annual earnings
            } else {
                cst.setString(53,
                              (String)loanInstRepayFreq.getValue()); //annual earnings
            }
            if (pinNo.getValue() == null){
                     cst.setString(54, null);
             } else{
                 cst.setString(54, (String)pinNo.getValue());
             }
            
            cst.execute();
            //BigDecimal No = new BigDecimal(cst.getInt(1));
            //LOVCC.MemberNumber = No;
            session.setAttribute("MemberNumber", cst.getBigDecimal(1));
            session.setAttribute("MemberNumber1", cst.getBigDecimal(1));
            cst.close();

            //RefreshComponents();
            addMember.setDisabled(true);
            //anotherMem.setDisabled(false);
            String Message = "Member Added";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));


            //addMember.setDisabled(true);

            //ADFUtils.findIterator("FindMemberDependantsIterator").executeQuery();
            //AdfFacesContext.getCurrentInstance().addPartialTarget(memDependantsLOV);
            /*
         ADFUtils.findIterator("FindJointMembersIterator").executeQuery();
         AdfFacesContext.getCurrentInstance().addPartialTarget(jointMemLOV);
        */
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
            e.printStackTrace();
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
        return null;
    }

    public String saveDependants() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;

        BigDecimal Memb = (BigDecimal)session.getAttribute("MemberNumber");
        if (Memb == null) {

            String Message = "Save Main Member First";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));

            return null;
        }


        try {
            String polQuery =
                "begin LMS_WEB_PKG_GRP.createDependents(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);end;";
            cst = conn.prepareCall(polQuery);

            if (djMemNo.getValue() == null) {
                cst.setBigDecimal(1, null);
            } else {
                cst.setString(1, djMemNo.getValue().toString());
            }
            if (djSurname.getValue() == null) {
                cst.setBigDecimal(2, null);
            } else {
                cst.setString(2, djSurname.getValue().toString());
            }
            if (djOtherNames.getValue() == null) {
                cst.setBigDecimal(3, null);
            } else {
                cst.setString(3, djOtherNames.getValue().toString());
            }
            cst.setBigDecimal(4,
                              (BigDecimal)session.getAttribute("DepTypeCode"));
            if (djSex.getValue() == null) {
                cst.setBigDecimal(5, null);
            } else {
                cst.setString(5, djSex.getValue().toString());
            }
            if (djDOB.getValue() == null) {
                cst.setString(6, null);
            } else {
                cst.setString(6,
                              GlobalCC.parseDate(djDOB.getValue().toString()));
            }

            cst.setString(7, (String)session.getAttribute("DepTypeDesc"));
            if (djIDNo.getValue() == null) {
                cst.setBigDecimal(8, null);
            } else {
                cst.setString(8, djIDNo.getValue().toString());
            }
            cst.setString(9, (String)session.getAttribute("CurrentStatus"));
            cst.setBigDecimal(10,
                              (BigDecimal)session.getAttribute("MemberNumber"));
            cst.setBigDecimal(11, (BigDecimal)session.getAttribute("prpCode"));
            cst.setBigDecimal(12,
                              (BigDecimal)session.getAttribute("PolicyCategory"));
            cst.setBigDecimal(13,
                              (BigDecimal)session.getAttribute("ProductCode"));
            cst.setBigDecimal(14,
                              (BigDecimal)session.getAttribute("endorsementCode"));
            if(djAddress.getValue()==null){
              cst.setString(15,null);
            }else{
              cst.setString(15, djAddress.getValue().toString());
            }
            if(djPinNo.getValue()==null){
              cst.setString(16,null);
            }else{
              cst.setString(16,djPinNo.getValue().toString());
            }
            cst.execute();
            cst.close();
            conn.close();
            djMemNo.setValue(null);
            djSurname.setValue(null);
            djOtherNames.setValue(null);
            djSex.setValue(null);
            djDOB.setValue(null);
            djIDNo.setValue(null);

            AdfFacesContext.getCurrentInstance().addPartialTarget(djMemNo);
            AdfFacesContext.getCurrentInstance().addPartialTarget(djSurname);
            AdfFacesContext.getCurrentInstance().addPartialTarget(djOtherNames);
            AdfFacesContext.getCurrentInstance().addPartialTarget(djSex);
            AdfFacesContext.getCurrentInstance().addPartialTarget(djDOB);
            AdfFacesContext.getCurrentInstance().addPartialTarget(djIDNo);

            ADFUtils.findIterator("FindMemberDependantsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(memDependantsLOV);


            String Message = "Dependant Added";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));


        } catch (Exception e) {

            djMemNo.setValue(null);
            djSurname.setValue(null);
            djOtherNames.setValue(null);
            djSex.setValue(null);
            djDOB.setValue(null);
            djIDNo.setValue(null);

            AdfFacesContext.getCurrentInstance().addPartialTarget(djMemNo);
            AdfFacesContext.getCurrentInstance().addPartialTarget(djSurname);
            AdfFacesContext.getCurrentInstance().addPartialTarget(djOtherNames);
            AdfFacesContext.getCurrentInstance().addPartialTarget(djSex);
            AdfFacesContext.getCurrentInstance().addPartialTarget(djDOB);
            AdfFacesContext.getCurrentInstance().addPartialTarget(djIDNo);

            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
        return null;
    }

    public void dependants1Listener(SelectionEvent selectionEvent) {

    }

    public String findDependantsSelected() {
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("FindDependantTypesIterator");
            RowKeySet set = depTypeLOV2.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            //System.out.println(1);
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                //categoryDesc.setValue(r.getAttribute("catDesc"));
                //LOVCC.PolicyCategory=(BigDecimal)r.getAttribute("lcaCode");
                //memEarnprds.setValue(r.getAttribute("catPeriod"));

                session.setAttribute("DepTypeCode",
                                     r.getAttribute("DTY_CODE"));
                session.setAttribute("DepTypeDesc",
                                     r.getAttribute("DTY_SHT_DESC"));
                if (memNo.getValue() == null) {
                    djMemNo.setValue(null);
                } else {
                    djMemNo.setValue(null);
                    //djMemNo.setValue(memNo.getValue().toString());
                }
                djSurname.setValue(null);
                djOtherNames.setValue(null);
                djSex.setValue(null);
                djDOB.setValue(null);
                djIDNo.setValue(null);
                djMemNo.setDisabled(false);

                // Render Popup
                ExtendedRenderKitService erkService =
                    Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                       ExtendedRenderKitService.class);
                erkService.addScript(FacesContext.getCurrentInstance(),
                                     "var hints = {autodismissNever:false}; " +
                                     "AdfPage.PAGE.findComponent('" +
                                     "lmsgroup:popup7" + "').show(hints);");
            }
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return null;
    }

    public String DeleteDependantsSelected() {
        Connection conn = null;
        CallableStatement cst = null;
        try {
            DBConnector myConn = new DBConnector();
            conn = myConn.getDatabaseConn();

            BigDecimal Code = null;


            DCIteratorBinding dciter =
                ADFUtils.findIterator("FindMemberDependantsIterator");
            RowKeySet set = memDependantsLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                Code = (BigDecimal)r.getAttribute("POLM_CODE");
                String polQuery =
                    "begin LMS_WEB_PKG_GRP.delete_pol_member(?,?);end;";
                cst = conn.prepareCall(polQuery);
                cst.setBigDecimal(1,
                                  (BigDecimal)session.getAttribute("endorsementCode"));
                cst.setBigDecimal(2, Code);
                cst.execute();
                cst.close();
                conn.close();
                ADFUtils.findIterator("FindMemberDependantsIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(memDependantsLOV);


            }


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }

        return null;
    }

    public String RefreshComponents() {

        memNo.setValue(null);
        memSurname.setValue(null);
        memloanDate.setValue(null);
        origloanAmt.setValue(null);
        loanInt.setValue(null);
        origRepayPeriod.setValue(null);
        savingAmt.setValue(null);
        emprBF.setValue(null);
        empeBF.setValue(null);
        memcontrType.setValue(null);
        empeContr.setValue(null);
        emprContr.setValue(null);
        //memEarnings.setValue(null);
        memEarnprds.setValue(null);
        occupationDesc.setValue(null);

        memOtherNames.setValue(null);
        joinDate.setValue(null);
        idNo.setValue(null);
        //dob.setValue(null);
        memSex.setValue(null);
        weight.setValue(null);
        height.setValue(null);
        sysPres.setValue(null);
        diaPres.setValue(null);
        categoryDesc.setValue(null);
        yeat.setValue(null);
        session.setAttribute("MemberNumber", null);
        session.setAttribute("MemberNumber1", null);
        AdfFacesContext.getCurrentInstance().addPartialTarget(memNo);
        AdfFacesContext.getCurrentInstance().addPartialTarget(memSurname);
        AdfFacesContext.getCurrentInstance().addPartialTarget(memloanDate);
        AdfFacesContext.getCurrentInstance().addPartialTarget(origloanAmt);
        AdfFacesContext.getCurrentInstance().addPartialTarget(loanInt);
        AdfFacesContext.getCurrentInstance().addPartialTarget(origRepayPeriod);
        AdfFacesContext.getCurrentInstance().addPartialTarget(savingAmt);
        AdfFacesContext.getCurrentInstance().addPartialTarget(emprBF);
        AdfFacesContext.getCurrentInstance().addPartialTarget(empeBF);
        AdfFacesContext.getCurrentInstance().addPartialTarget(memcontrType);
        AdfFacesContext.getCurrentInstance().addPartialTarget(empeContr);
        AdfFacesContext.getCurrentInstance().addPartialTarget(emprContr);
        AdfFacesContext.getCurrentInstance().addPartialTarget(occupationDesc);
        AdfFacesContext.getCurrentInstance().addPartialTarget(memEarnprds);
        AdfFacesContext.getCurrentInstance().addPartialTarget(memOtherNames);
        AdfFacesContext.getCurrentInstance().addPartialTarget(joinDate);
        AdfFacesContext.getCurrentInstance().addPartialTarget(idNo);
        AdfFacesContext.getCurrentInstance().addPartialTarget(memSex);
        AdfFacesContext.getCurrentInstance().addPartialTarget(weight);
        AdfFacesContext.getCurrentInstance().addPartialTarget(height);
        AdfFacesContext.getCurrentInstance().addPartialTarget(sysPres);
        AdfFacesContext.getCurrentInstance().addPartialTarget(diaPres);
        AdfFacesContext.getCurrentInstance().addPartialTarget(categoryDesc);

        addMember.setDisabled(false);
        AdfFacesContext.getCurrentInstance().addPartialTarget(addMember);

        ADFUtils.findIterator("FindMemberDependantsIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(memDependantsLOV);
        ADFUtils.findIterator("FindJointMembersIterator").executeQuery();
        ADFUtils.findIterator("FindMembersBeneficiariesCoversIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(studentsLOV);
        NewMember();

        //ADFUtils.findIterator("FindMemberDependantsIterator").executeQuery();
        //AdfFacesContext.getCurrentInstance().addPartialTarget(memDependantsLOV);

        return null;
    }

    public void dobListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        Connection conn = new DBConnector().getDatabaseConn();
        String DateString = null;
        String ANBString = null;
        SimpleDateFormat sdf1 =
            new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MMM/yyyy");

        try {
            java.util.Date DOB = new java.util.Date();
            RichInputText ANB = new RichInputText();
            //System.out.println("value" + this.getDob().toString());


            if (memdob.getValue() == null) {

            } else {
                DOB = sdf1.parse(memdob.getValue().toString());
                //DateString = memdob.getValue().toString();
                DateString = sdf2.format(DOB);


                // System.out.println("To Date" + DateString);
                String dobQuery =
                    "begin ? := LMS_WEB_PKG_GRP_UW.get_dflt_anb(?,?,?); end;";
                CallableStatement stmt = null;
                stmt = conn.prepareCall(dobQuery);
                stmt.registerOutParameter(1, OracleTypes.VARCHAR);
                stmt.setBigDecimal(2,
                                   (BigDecimal)session.getAttribute("endorsementCode"));
                stmt.setString(3, DateString);
                stmt.registerOutParameter(4, OracleTypes.VARCHAR);
                stmt.executeQuery();
                quotememANB.setValue(stmt.getString(1));
                ANBMem = stmt.getString(1);
                yeat.setValue(stmt.getString(4));

                AdfFacesContext.getCurrentInstance().addPartialTarget(quotememANB);
                AdfFacesContext.getCurrentInstance().addPartialTarget(yeat);

            }
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }


    }

    public void annEarningsListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        // Add event code here...
        String AnnualEarn = null;
        Connection conn = new DBConnector().getDatabaseConn();
        CallableStatement cstmt = null;
        if (annualEarnings.getValue() == null) {
            //do nothing
        } else {
            try {
                AnnualEarn = annualEarnings.getValue().toString();

                String query =
                    "begin ? := LMS_WEB_PKG_GRP.mem_monthly_earnings(?); end;";

                cstmt = conn.prepareCall(query);
                cstmt.registerOutParameter(1,
                                           oracle.jdbc.OracleTypes.DECIMAL); //authorization code

                cstmt.setString(2, AnnualEarn);
                cstmt.execute();

                //int Result;
                //Result = cstmt.getBigDecimal(1);
                //MemMonthEarnings = Result;
                monthlyEarnings.setValue(cstmt.getBigDecimal(1));
                AdfFacesContext.getCurrentInstance().addPartialTarget(monthlyEarnings);
                conn.close();
            } catch (Exception e) {
                GlobalCC.EXCEPTIONREPORTING(conn, e);
            } finally {
                GlobalCC.CloseConnections(null, cstmt, conn);
            }
        }
    }

    public void monthEarningsListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        String MonthlyEarn = null;
        Connection conn = new DBConnector().getDatabaseConn();
        CallableStatement cstmt = null;
        if (monthlyEarnings.getValue() == null) {
            //do nothing
        } else {
            try {
                MonthlyEarn = monthlyEarnings.getValue().toString();

                String query =
                    "begin ? := LMS_WEB_PKG_GRP.FUNC_MEM_ANN_EARNINGS(?); end;";

                cstmt = conn.prepareCall(query);
                cstmt.registerOutParameter(1,
                                           oracle.jdbc.OracleTypes.DECIMAL); //authorization code

                cstmt.setString(2, MonthlyEarn);
                cstmt.execute();

                int Result;
                //Result = cstmt.getBigDecimal(1);
                //MemAnnualEarnings = Result;
                annualEarnings.setValue(cstmt.getBigDecimal(1));
                AdfFacesContext.getCurrentInstance().addPartialTarget(annualEarnings);
                conn.close();
            } catch (Exception e) {
                GlobalCC.EXCEPTIONREPORTING(conn, e);
            } finally {
                GlobalCC.CloseConnections(null, cstmt, conn);
            }
        }
    }

    public String NewMember() {
        memdob.setValue(null);
        quotememANB.setValue(null);
        //LOVCC.MemberNumber = null;
        session.setAttribute("MemberNumber", null);
        monthlyEarnings.setValue(null);
        annualEarnings.setValue(null);

        AdfFacesContext.getCurrentInstance().addPartialTarget(memdob);
        AdfFacesContext.getCurrentInstance().addPartialTarget(quotememANB);
        AdfFacesContext.getCurrentInstance().addPartialTarget(monthlyEarnings);
        AdfFacesContext.getCurrentInstance().addPartialTarget(annualEarnings);

        return null;
    }

    public String findPolicyCategorySelected() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findCategoryIterator");
        RowKeySet set = memcategoryLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            categoryDesc.setValue(r.getAttribute("catDesc"));
            //LOVCC.PolicyCategory=(BigDecimal)r.getAttribute("lcaCode");
            session.setAttribute("PolicyCategory", r.getAttribute("lcaCode"));
            memEarnprds.setValue(r.getAttribute("catPeriod"));
        }

        return null;
    }

    public String findOccupationSelected() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindOccupationsIterator");
        RowKeySet set = memoccupationLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            occupationDesc.setValue(r.getAttribute("GCO_DESC"));
            //LOVCC.OccupationCode=(BigDecimal)r.getAttribute("gco_code");
            session.setAttribute("OccupationCode", r.getAttribute("gco_code"));

        }

        return null;
    }

    public void ANBDateListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if (valueChangeEvent.getOldValue() != valueChangeEvent.getNewValue()) {
            String ANB = null;
            Integer Value = 0;

            if (quotememANB.getValue() == null) {

            } else {
                Connection conn = new DBConnector().getDatabaseConn();
                try {

                    ANB = quotememANB.getValue().toString();
                    Value = Integer.parseInt(ANB);
                    String dobQuery =
                        "begin ? := LMS_WEB_PKG_GRP_UW.get_dflt_dob(?,?,?,?); end;";
                    CallableStatement stmt = null;
                    stmt = conn.prepareCall(dobQuery);
                    stmt.registerOutParameter(1, OracleTypes.DATE);
                    stmt.setInt(2, Value);
                    stmt.setBigDecimal(3,
                                       (BigDecimal)session.getAttribute("endorsementCode"));
                    stmt.setString(4, "P");
                    stmt.registerOutParameter(5, OracleTypes.VARCHAR);
                    stmt.execute();
                    memdob.setValue(stmt.getDate(1));
                    yeat.setValue(stmt.getString(5));

                } catch (SQLException e) {
                    GlobalCC.EXCEPTIONREPORTING(conn, e);
                }
            }
            AdfFacesContext.getCurrentInstance().addPartialTarget(memdob);
            AdfFacesContext.getCurrentInstance().addPartialTarget(yeat);
        }
    }

    public void YearChangeListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if (valueChangeEvent.getOldValue() != valueChangeEvent.getNewValue()) {
            String Year = null;
            Integer Value = 0;

            if (yeat.getValue() == null) {

            } else {
                Connection conn = new DBConnector().getDatabaseConn();
                try {

                    Year = yeat.getValue().toString();
                    Value = Integer.parseInt(Year);
                    String dobQuery =
                        "begin ? := LMS_WEB_PKG_GRP_UW.get_dflt_dob_and_anb(?,?,?,?); end;";
                    CallableStatement stmt = null;
                    stmt = conn.prepareCall(dobQuery);
                    stmt.registerOutParameter(1, OracleTypes.DATE);
                    stmt.setInt(2, Value);
                    stmt.setBigDecimal(3,
                                       (BigDecimal)session.getAttribute("endorsementCode"));
                    stmt.setString(4, "P");
                    stmt.registerOutParameter(5, OracleTypes.VARCHAR);
                    stmt.execute();
                    memdob.setValue(stmt.getDate(1));
                    quotememANB.setValue(stmt.getString(5));

                } catch (SQLException e) {
                    GlobalCC.EXCEPTIONREPORTING(conn, e);
                }
            }
            AdfFacesContext.getCurrentInstance().addPartialTarget(memdob);
            AdfFacesContext.getCurrentInstance().addPartialTarget(quotememANB);
        }
    }

    public void setPolDocsTab(RichPanelBox polDocsTab) {
        this.polDocsTab = polDocsTab;
    }

    public RichPanelBox getPolDocsTab() {
        return polDocsTab;
    }

    public void setTaxesTab(RichPanelBox taxesTab) {
        this.taxesTab = taxesTab;
    }

    public RichPanelBox getTaxesTab() {
        return taxesTab;
    }

    public void setProvisionsTab(RichPanelBox provisionsTab) {
        this.provisionsTab = provisionsTab;
    }

    public RichPanelBox getProvisionsTab() {
        return provisionsTab;
    }

    public void setMembersTab(RichPanelBox membersTab) {
        this.membersTab = membersTab;
    }

    public RichPanelBox getMembersTab() {
        return membersTab;
    }

    public void setNextButton(RichCommandButton nextButton) {
        this.nextButton = nextButton;
    }

    public RichCommandButton getNextButton() {
        return nextButton;
    }

    public void setPrevButton(RichCommandButton prevButton) {
        this.prevButton = prevButton;
    }

    public RichCommandButton getPrevButton() {
        return prevButton;
    }

    public void setFinishButton(RichCommandButton finishButton) {
        this.finishButton = finishButton;
    }

    public RichCommandButton getFinishButton() {
        return finishButton;
    }

    public void setCatLimitTabs(RichPanelBox catLimitTabs) {
        this.catLimitTabs = catLimitTabs;
    }

    public RichPanelBox getCatLimitTabs() {
        return catLimitTabs;
    }

    public void setImportedMembers(RichTable importedMembers) {
        this.importedMembers = importedMembers;
    }

    public RichTable getImportedMembers() {
        return importedMembers;
    }

    public void setMembersImport(RichPanelGroupLayout membersImport) {
        this.membersImport = membersImport;
    }

    public RichPanelGroupLayout getMembersImport() {
        return membersImport;
    }

    public void setSingleMember(RichPanelBox singleMember) {
        this.singleMember = singleMember;
    }

    public RichPanelBox getSingleMember() {
        return singleMember;
    }

    public void setGenPolNo(RichCommandButton genPolNo) {
        this.genPolNo = genPolNo;
    }

    public RichCommandButton getGenPolNo() {
        return genPolNo;
    }

    public void setCheckoffButton(RichCommandButton checkoffButton) {
        this.checkoffButton = checkoffButton;
    }

    public RichCommandButton getCheckoffButton() {
        return checkoffButton;
    }

    public void setSaLabel(RichOutputLabel saLabel) {
        this.saLabel = saLabel;
    }

    public RichOutputLabel getSaLabel() {
        return saLabel;
    }

    public void setAllTaxesLOV(RichTable allTaxesLOV) {
        this.allTaxesLOV = allTaxesLOV;
    }

    public RichTable getAllTaxesLOV() {
        return allTaxesLOV;
    }

    public void setTaxRate(RichInputText taxRate) {
        this.taxRate = taxRate;
    }

    public RichInputText getTaxRate() {
        return taxRate;
    }

    public void setTaxAmt(RichInputText taxAmt) {
        this.taxAmt = taxAmt;
    }

    public RichInputText getTaxAmt() {
        return taxAmt;
    }

    public void setApplLevel(RichInputText applLevel) {
        this.applLevel = applLevel;
    }

    public RichInputText getApplLevel() {
        return applLevel;
    }

    public void setTaxSel(RichOutputText taxSel) {
        this.taxSel = taxSel;
    }

    public RichOutputText getTaxSel() {
        return taxSel;
    }

    public void setMemNo(RichInputText memNo) {
        this.memNo = memNo;
    }

    public RichInputText getMemNo() {
        return memNo;
    }

    public void setMemSurname(RichInputText memSurname) {
        this.memSurname = memSurname;
    }

    public RichInputText getMemSurname() {
        return memSurname;
    }

    public void setMemOtherNames(RichInputText memOtherNames) {
        this.memOtherNames = memOtherNames;
    }

    public RichInputText getMemOtherNames() {
        return memOtherNames;
    }

    public void setIdNo(RichInputText idNo) {
        this.idNo = idNo;
    }

    public RichInputText getIdNo() {
        return idNo;
    }

    public void setYeat(RichInputText yeat) {
        this.yeat = yeat;
    }

    public RichInputText getYeat() {
        return yeat;
    }

    public void setMemdob(RichInputDate memdob) {
        this.memdob = memdob;
    }

    public RichInputDate getMemdob() {
        return memdob;
    }

    public void setQuotememANB(RichInputText quotememANB) {
        this.quotememANB = quotememANB;
    }

    public RichInputText getQuotememANB() {
        return quotememANB;
    }

    public void setWeight(RichInputText weight) {
        this.weight = weight;
    }

    public RichInputText getWeight() {
        return weight;
    }

    public void setHeight(RichInputText height) {
        this.height = height;
    }

    public RichInputText getHeight() {
        return height;
    }

    public void setDepTypeDesc(RichInputText depTypeDesc) {
        this.depTypeDesc = depTypeDesc;
    }

    public RichInputText getDepTypeDesc() {
        return depTypeDesc;
    }

    public void setCategoryDesc(RichInputText categoryDesc) {
        this.categoryDesc = categoryDesc;
    }

    public RichInputText getCategoryDesc() {
        return categoryDesc;
    }

    public void setSysPres(RichInputText sysPres) {
        this.sysPres = sysPres;
    }

    public RichInputText getSysPres() {
        return sysPres;
    }

    public void setDiaPres(RichInputText diaPres) {
        this.diaPres = diaPres;
    }

    public RichInputText getDiaPres() {
        return diaPres;
    }

    public void setOccupationDesc(RichInputText occupationDesc) {
        this.occupationDesc = occupationDesc;
    }

    public RichInputText getOccupationDesc() {
        return occupationDesc;
    }

    public void setMemSex(RichSelectOneChoice memSex) {
        this.memSex = memSex;
    }

    public RichSelectOneChoice getMemSex() {
        return memSex;
    }

    public void setMemloanDate(RichInputDate memloanDate) {
        this.memloanDate = memloanDate;
    }

    public RichInputDate getMemloanDate() {
        return memloanDate;
    }

    public void setOrigloanAmt(RichInputNumberSpinbox origloanAmt) {
        this.origloanAmt = origloanAmt;
    }

    public RichInputNumberSpinbox getOrigloanAmt() {
        return origloanAmt;
    }

    public void setOrigRepayPeriod(RichInputText origRepayPeriod) {
        this.origRepayPeriod = origRepayPeriod;
    }

    public RichInputText getOrigRepayPeriod() {
        return origRepayPeriod;
    }

    public void setLoanInt(RichInputText loanInt) {
        this.loanInt = loanInt;
    }

    public RichInputText getLoanInt() {
        return loanInt;
    }

    public void setSavingAmt(RichInputNumberSpinbox savingAmt) {
        this.savingAmt = savingAmt;
    }

    public RichInputNumberSpinbox getSavingAmt() {
        return savingAmt;
    }

    public void setAnnualEarnings(RichInputNumberSpinbox annualEarnings) {
        this.annualEarnings = annualEarnings;
    }

    public RichInputNumberSpinbox getAnnualEarnings() {
        return annualEarnings;
    }

    public void setMonthlyEarnings(RichInputNumberSpinbox monthlyEarnings) {
        this.monthlyEarnings = monthlyEarnings;
    }

    public RichInputNumberSpinbox getMonthlyEarnings() {
        return monthlyEarnings;
    }

    public void setMemEarnprds(RichInputText memEarnprds) {
        this.memEarnprds = memEarnprds;
    }

    public RichInputText getMemEarnprds() {
        return memEarnprds;
    }

    public void setJoinDate(RichInputDate joinDate) {
        this.joinDate = joinDate;
    }

    public RichInputDate getJoinDate() {
        return joinDate;
    }

    public void setYrsOfService(RichInputText yrsOfService) {
        this.yrsOfService = yrsOfService;
    }

    public RichInputText getYrsOfService() {
        return yrsOfService;
    }

    public void setFutYearSrv(RichInputText futYearSrv) {
        this.futYearSrv = futYearSrv;
    }

    public RichInputText getFutYearSrv() {
        return futYearSrv;
    }

    public void setTotSrvYears(RichInputText totSrvYears) {
        this.totSrvYears = totSrvYears;
    }

    public RichInputText getTotSrvYears() {
        return totSrvYears;
    }

    public void setMemcontrType(RichSelectOneChoice memcontrType) {
        this.memcontrType = memcontrType;
    }

    public RichSelectOneChoice getMemcontrType() {
        return memcontrType;
    }

    public void setEmpeContr(RichInputText empeContr) {
        this.empeContr = empeContr;
    }

    public RichInputText getEmpeContr() {
        return empeContr;
    }

    public void setEmprContr(RichInputText emprContr) {
        this.emprContr = emprContr;
    }

    public RichInputText getEmprContr() {
        return emprContr;
    }

    public void setEmpeBF(RichInputText empeBF) {
        this.empeBF = empeBF;
    }

    public RichInputText getEmpeBF() {
        return empeBF;
    }

    public void setEmprBF(RichInputText emprBF) {
        this.emprBF = emprBF;
    }

    public RichInputText getEmprBF() {
        return emprBF;
    }

    public void setTotalPen(RichInputText totalPen) {
        this.totalPen = totalPen;
    }

    public RichInputText getTotalPen() {
        return totalPen;
    }

    public void setGrpLifeRider(RichSelectBooleanCheckbox grpLifeRider) {
        this.grpLifeRider = grpLifeRider;
    }

    public RichSelectBooleanCheckbox getGrpLifeRider() {
        return grpLifeRider;
    }

    public void setAddMember(RichCommandButton addMember) {
        this.addMember = addMember;
    }

    public RichCommandButton getAddMember() {
        return addMember;
    }

    public void setAnotherMem2(RichCommandButton anotherMem2) {
        this.anotherMem2 = anotherMem2;
    }

    public RichCommandButton getAnotherMem2() {
        return anotherMem2;
    }

    public void setMemcategoryLOV(RichTable memcategoryLOV) {
        this.memcategoryLOV = memcategoryLOV;
    }

    public RichTable getMemcategoryLOV() {
        return memcategoryLOV;
    }

    public void setMemoccupationLOV(RichTable memoccupationLOV) {
        this.memoccupationLOV = memoccupationLOV;
    }

    public RichTable getMemoccupationLOV() {
        return memoccupationLOV;
    }

    public void setCoinsurerLabel(RichOutputText coinsurerLabel) {
        this.coinsurerLabel = coinsurerLabel;
    }

    public RichOutputText getCoinsurerLabel() {
        return coinsurerLabel;
    }

    public void setCoShare(RichInputNumberSpinbox coShare) {
        this.coShare = coShare;
    }

    public RichInputNumberSpinbox getCoShare() {
        return coShare;
    }

    public void setCoServFee(RichInputNumberSpinbox coServFee) {
        this.coServFee = coServFee;
    }

    public RichInputNumberSpinbox getCoServFee() {
        return coServFee;
    }

    public void setCoLeadFollow(RichSelectOneChoice coLeadFollow) {
        this.coLeadFollow = coLeadFollow;
    }

    public RichSelectOneChoice getCoLeadFollow() {
        return coLeadFollow;
    }

    public void setLeaderShare(RichInputNumberSpinbox leaderShare) {
        this.leaderShare = leaderShare;
    }

    public RichInputNumberSpinbox getLeaderShare() {
        return leaderShare;
    }

    public void setPolCoinsurersLOV(RichTable polCoinsurersLOV) {
        this.polCoinsurersLOV = polCoinsurersLOV;
    }

    public RichTable getPolCoinsurersLOV() {
        return polCoinsurersLOV;
    }

    public void setCoinsurersLOV(RichTable coinsurersLOV) {
        this.coinsurersLOV = coinsurersLOV;
    }

    public RichTable getCoinsurersLOV() {
        return coinsurersLOV;
    }

    public String findCoinsurersSel() {


        try {
            // Add event code here...
            DCIteratorBinding dciter =
                ADFUtils.findIterator("FindCoinsurersIterator");
            RowKeySet set = coinsurersLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                coinsurerAgent = (BigDecimal)r.getAttribute("CO_agn_code");
                coinsurerCode = null;
                //coverLabel.setValue(r.getAttribute("cvt_desc"));
                coinsurerLabel.setValue(r.getAttribute("CO_agn_name"));
                coShare.setValue(null);
                coServFee.setValue(null);

                AdfFacesContext.getCurrentInstance().addPartialTarget(coinsurerLabel);
                AdfFacesContext.getCurrentInstance().addPartialTarget(coShare);
                AdfFacesContext.getCurrentInstance().addPartialTarget(coServFee);

                // Render Popup
                System.out.println("enter popup");
                ExtendedRenderKitService erkService =
                    Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                       ExtendedRenderKitService.class);
                erkService.addScript(FacesContext.getCurrentInstance(),
                                     "var hints = {autodismissNever:false}; " +
                                     "AdfPage.PAGE.findComponent('" +
                                     "lmsgroup:p33" + "').show(hints);");
                //prodCoverDisplay.setValue(new String((String)r.getAttribute("cvt_desc")));
                //categPeriodDisplay.setValue(new String((String)r.getAttribute("catPeriod")));


            }


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return null;
    }

    public String EditCoinsurersSel() {
        String followerBus = (String)session.getAttribute("FollowerBusiness");

        try {
            // Add event code here...
            DCIteratorBinding dciter =
                ADFUtils.findIterator("FindPolicyCoinsurersIterator");
            RowKeySet set = polCoinsurersLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();
                session.setAttribute("pol_coin_code",
                                     r.getAttribute("pol_coin_code"));
                session.setAttribute("coin_agn_code",
                                     r.getAttribute("pol_coin_agn_code"));
                coinsurerCode = (BigDecimal)r.getAttribute("pol_coin_code");
                coinsurerAgent =
                        (BigDecimal)r.getAttribute("pol_coin_agn_code");
                //coverLabel.setValue(r.getAttribute("cvt_desc"));
                addCoinsurerDisplay.setValue(r.getAttribute("coinsurer_display"));
                sharePercentageDisplay.setValue(r.getAttribute("POL_COIN_SHARE_PCT"));
                adminFeeDisplay.setValue(r.getAttribute("pol_coin_admin_fee"));
                if (followerBus.equalsIgnoreCase("F")) {
                    laFollowerBusiness.setValue(r.getAttribute("POL_COIN_FOLLOWER"));
                    AdfFacesContext.getCurrentInstance().addPartialTarget(laFollowerBusiness);
                }

                AdfFacesContext.getCurrentInstance().addPartialTarget(addCoinsurerDisplay);
                AdfFacesContext.getCurrentInstance().addPartialTarget(sharePercentageDisplay);
                AdfFacesContext.getCurrentInstance().addPartialTarget(adminFeeDisplay);

                // Render Popup
                System.out.println("enter popup");
                ExtendedRenderKitService erkService =
                    Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                       ExtendedRenderKitService.class);
                erkService.addScript(FacesContext.getCurrentInstance(),
                                     "var hints = {autodismissNever:false}; " +
                                     "AdfPage.PAGE.findComponent('" +
                                     "lmsgroup:addCoinsurerPopup" +
                                     "').show(hints);");
                //prodCoverDisplay.setValue(new String((String)r.getAttribute("cvt_desc")));
                //categPeriodDisplay.setValue(new String((String)r.getAttribute("catPeriod")));


            }


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return null;
    }

    public String SaveCoinsurer() {

        if (coShare.getValue() == null) {

            String Message = "Enter a Share Percentage";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
            return null;

        }

        String computeQuery =
            "BEGIN LMS_WEB_PKG_GRP.updatepolicycoinsurers(?,?,?,?,?,?,?);END;";
        Connection conn = new DBConnector().getDatabaseConn();
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall(computeQuery);
            cstmt.setBigDecimal(1, coinsurerCode); //v_quo_code NUMBER,
            cstmt.setBigDecimal(2,
                                (BigDecimal)session.getAttribute("endorsementCode"));
            cstmt.setBigDecimal(3,
                                (BigDecimal)session.getAttribute("policyCode"));
            cstmt.setBigDecimal(4, coinsurerAgent);
            cstmt.setString(5, coShare.getValue().toString());
            if (coServFee.getValue() == null) {
                cstmt.setBigDecimal(6, null);
            } else {
                cstmt.setString(6, coServFee.getValue().toString());
            }
            if (followerLeaderBusiness.getValue() == null) {
                cstmt.setString(7, null);
            } else {
                cstmt.setString(7,
                                followerLeaderBusiness.getValue().toString());
            }
            cstmt.execute();
            conn.close();
            String Message = "Coinsurer Saved";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));

            ADFUtils.findIterator("FindPolicyCoinsurersIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(polCoinsurersLOV);

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }

        return null;
    }

    public String DeleteCoinsurer() {
        BigDecimal CoinsurerCode = null;

        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindPolicyCoinsurersIterator");
        RowKeySet set = polCoinsurersLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            CoinsurerCode = (BigDecimal)r.getAttribute("pol_coin_code");


        }
        String deleteQuery =
            "BEGIN LMS_WEB_PKG_GRP.deletepolicycoinsurer(?);END;";
        Connection conn = new DBConnector().getDatabaseConn();
        try {
            CallableStatement cstmt = conn.prepareCall(deleteQuery);
            cstmt.setBigDecimal(1, CoinsurerCode);
            cstmt.execute();

            ADFUtils.findIterator("FindPolicyCoinsurersIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(polCoinsurersLOV);
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);

        }
        return null;
    }

    public void coinsuranceListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if (coinsCbox.isSelected()) {
            coinsureTab.setRendered(true);
            //GlobalCC.sysInformation(" Please Generate a Policy Number before Commencing with Coinsurance.");
        } else {
            coinsureTab.setRendered(false);
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(coinsureTab);
    }

    public String SaveCoinsurerShare() {

        if (leaderShare.getValue() == null) {

            String Message = "Enter a Share Percentage";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
            return null;

        }

        if (coLeadFollow.getValue() == null) {

            String Message = "Select A Leader / Follower";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
            return null;

        }


        String computeQuery =
            "BEGIN LMS_WEB_PKG_GRP.update_leader_share(?,?,?,?,?,?);END;";
        Connection conn = new DBConnector().getDatabaseConn();
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall(computeQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("endorsementCode")); //v_quo_code NUMBER,
            cstmt.setString(2, leaderShare.getValue().toString());
            cstmt.setString(3, coLeadFollow.getValue().toString());
            cstmt.setString(4, (String)session.getAttribute("CurrentStatus"));
            if (premProvCbox.isSelected()) {
                cstmt.setString(5, "Y");
            } else {
                cstmt.setString(5, "N");
            }
            if (ldrCombined.isSelected()) {
                cstmt.setString(6, "Y");
            } else {
                cstmt.setString(6, "N");
            }

            cstmt.execute();
            conn.close();
            String Message = "Coinsurer Share Saved";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));


            //ADFUtils.findIterator("findQuoteCoinsurersIterator").executeQuery();
            //AdfFacesContext.getCurrentInstance().addPartialTarget(quoteCoinsurersLOV);

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }

        return null;
    }

    public void pensionTypeListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if (pensionType.getValue() == null) {

        } else {
            if (pensionType.getValue().toString().equalsIgnoreCase("DB")) {

                totEmpyeeContr.setValue(null);
                //totEmpyeeContr.setDisabled(true);
                totEmpyerContr.setValue(null);
                //totEmpyerContr.setDisabled(true);
                contrType.setValue(null);
                //contrType.setDisabled(true);
                empyerContrRate.setValue(null);
                //empyerContrRate.setDisabled(true);
                empyeeContrRate.setValue(null);
                //empyeeContrRate.setDisabled(true);
                empyerVolContr.setValue(null);
                //empyerVolContr.setDisabled(true);
                emplyeeVolContr.setValue(null);
                //emplyeeVolContr.setDisabled(true);
                fundingRate.setValue(null);
                fundingRate.setDisabled(false);
                pensEscDisplay.setValue(null);
                pensEscDisplay.setDisabled(false);
                penEarnEsc.setValue(null);
                penEarnEsc.setDisabled(false);

            } else {

                totEmpyeeContr.setValue(null);
                totEmpyeeContr.setDisabled(false);
                totEmpyerContr.setValue(null);
                totEmpyerContr.setDisabled(false);
                contrType.setValue(null);
                contrType.setDisabled(false);
                empyerContrRate.setValue(null);
                empyerContrRate.setDisabled(false);
                empyeeContrRate.setValue(null);
                empyeeContrRate.setDisabled(false);
                empyerVolContr.setValue(null);
                empyerVolContr.setDisabled(false);
                emplyeeVolContr.setValue(null);
                emplyeeVolContr.setDisabled(false);
                fundingRate.setValue(null);
                fundingRate.setDisabled(true);
                pensEscDisplay.setValue(null);
                pensEscDisplay.setDisabled(true);
                penEarnEsc.setValue(null);
                penEarnEsc.setDisabled(true);

            }

        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(totEmpyeeContr);
        AdfFacesContext.getCurrentInstance().addPartialTarget(totEmpyerContr);
        AdfFacesContext.getCurrentInstance().addPartialTarget(contrType);
        AdfFacesContext.getCurrentInstance().addPartialTarget(empyerContrRate);
        AdfFacesContext.getCurrentInstance().addPartialTarget(empyeeContrRate);
        AdfFacesContext.getCurrentInstance().addPartialTarget(empyerVolContr);
        AdfFacesContext.getCurrentInstance().addPartialTarget(emplyeeVolContr);
        AdfFacesContext.getCurrentInstance().addPartialTarget(fundingRate);
        AdfFacesContext.getCurrentInstance().addPartialTarget(pensEscDisplay);
        AdfFacesContext.getCurrentInstance().addPartialTarget(penEarnEsc);
    }

    public String Update_Earn_Pensions() {
        String Results = "F";
        String prodType = (String)this.session.getAttribute("productType");
        String updateQuery =
            "BEGIN LMS_WEB_PKG_GRP.updatenbendorsement(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);END;";
        Connection conn = new DBConnector().getDatabaseConn();
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall(updateQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)this.session.getAttribute("endorsementCode"));
            if (this.paymentMethodDisplay.getValue() == null)
                cstmt.setBigDecimal(2, null);
            else {
                cstmt.setString(2,
                                this.paymentMethodDisplay.getValue().toString());
            }
            cstmt.setBigDecimal(3, null);
            cstmt.setBigDecimal(4,
                                (BigDecimal)this.session.getAttribute("agnCode"));
            cstmt.setBigDecimal(5, null);
            cstmt.setString(6, null);
            cstmt.setBigDecimal(7, null);
            cstmt.setString(8, null);
            if (this.VAT.getValue() == null) {
                cstmt.setString(9, null);
            } else {
                cstmt.setDouble(9,
                                Double.parseDouble(this.VAT.getValue().toString()));
            }

            if (this.ovrCommRate.getValue() == null) {
                cstmt.setString(10, null);
            } else {
                cstmt.setDouble(10,
                                Double.parseDouble(this.ovrCommRate.getValue().toString()));
            }

            cstmt.setBigDecimal(11,
                                (BigDecimal)this.session.getAttribute("mktCode"));
            cstmt.setString(12,
                            (String)this.session.getAttribute("mktShtDesc"));
            cstmt.setString(13, null);
            if (this.pensionType.getValue() == null) {
                cstmt.setString(14, null);
            } else {
                cstmt.setString(14, this.pensionType.getValue().toString());
            }

            if (this.schemeeTypeDisplay.getValue() == null) {
                cstmt.setString(15, null);
            } else {
                cstmt.setString(15,
                                this.schemeeTypeDisplay.getValue().toString());
            }

            if (this.regNumberDisplay.getValue() == null) {
                cstmt.setString(16, null);
            } else {
                cstmt.setString(16,
                                this.regNumberDisplay.getValue().toString());
            }

            if (this.regDate.getValue() == null) {
                cstmt.setString(17, null);
            } else if (this.regDate.getValue().toString().contains(":"))
                cstmt.setString(17,
                                LMSG.view.Base.GlobalCC.parseDate(this.regDate.getValue().toString()));
            else {
                cstmt.setString(17,
                                LMSG.view.Base.GlobalCC.upDateParseDate(this.regDate.getValue().toString()));
            }

            if (this.taxComplianceDisplay.getValue() == null) {
                cstmt.setString(18, null);
            } else {
                cstmt.setString(18,
                                this.taxComplianceDisplay.getValue().toString());
            }

            if (this.guaranteePrdDisplay.getValue() == null) {
                cstmt.setString(19, null);
            } else {
                cstmt.setString(19,
                                this.guaranteePrdDisplay.getValue().toString());
            }

            if (this.pensEscDisplay.getValue() == null) {
                cstmt.setString(20, null);
            } else {
                cstmt.setString(20, this.pensEscDisplay.getValue().toString());
            }

            if (this.pensPayFrequency.getValue() == null) {
                cstmt.setString(21, null);
            } else {
                cstmt.setString(21,
                                this.pensPayFrequency.getValue().toString());
            }

            if (this.rmaleDisplay.getValue() == null) {
                cstmt.setString(22, null);
            } else {
                cstmt.setString(22, this.rmaleDisplay.getValue().toString());
            }

            if (this.rfemaleDisplay.getValue() == null) {
                cstmt.setString(23, null);
            } else {
                cstmt.setString(23, this.rfemaleDisplay.getValue().toString());
            }

            if (this.pensAdminDisplay.getValue() == null) {
                cstmt.setString(24, null);
            } else {
                cstmt.setString(24,
                                this.pensAdminDisplay.getValue().toString());
            }

            if (this.totEmpyeeContr.getValue() == null) {
                cstmt.setString(25, null);
            } else {
                cstmt.setString(25, this.totEmpyeeContr.getValue().toString());
            }

            if (this.totEmpyerContr.getValue() == null) {
                cstmt.setString(26, null);
            } else {
                cstmt.setString(26, this.totEmpyerContr.getValue().toString());
            }

            if (this.contrType.getValue() == null) {
                cstmt.setString(27, null);
            } else {
                cstmt.setString(27, this.contrType.getValue().toString());
            }

            if (this.empyerContrRate.getValue() == null) {
                cstmt.setString(28, null);
            } else {
                cstmt.setString(28,
                                this.empyerContrRate.getValue().toString());
            }

            if (this.empyeeContrRate.getValue() == null) {
                cstmt.setString(29, null);
            } else {
                cstmt.setString(29,
                                this.empyeeContrRate.getValue().toString());
            }

            if (this.fundingRate.getValue() == null) {
                cstmt.setString(30, null);
            } else {
                cstmt.setString(30, this.fundingRate.getValue().toString());
            }

            if (this.pensCommRate.getValue() == null) {
                cstmt.setString(31, null);
            } else {
                cstmt.setString(31, this.pensCommRate.getValue().toString());
            }

            if (this.emplyeeVolContr.getValue() == null) {
                cstmt.setString(32, null);
            } else {
                cstmt.setString(32,
                                this.emplyeeVolContr.getValue().toString());
            }

            if (this.empyeePensBF.getValue() == null) {
                cstmt.setString(33, null);
            } else {
                cstmt.setString(33, this.empyeePensBF.getValue().toString());
            }

            if (this.empyerPensBF.getValue() == null) {
                cstmt.setString(34, null);
            } else {
                cstmt.setString(34, this.empyerPensBF.getValue().toString());
            }

            if (this.totPensBF.getValue() == null) {
                cstmt.setString(35, null);
            } else {
                cstmt.setString(35, this.totPensBF.getValue().toString());
            }

            if (this.pensInterestRate.getValue() == null) {
                cstmt.setString(36, null);
            } else {
                cstmt.setString(36,
                                this.pensInterestRate.getValue().toString());
            }

            if (this.penEarnEsc.getValue() == null) {
                cstmt.setString(37, null);
            } else {
                cstmt.setString(37, this.penEarnEsc.getValue().toString());
            }

            if (this.annuityPymtStructure.getValue() == null) {
                cstmt.setString(38, null);
            } else {
                cstmt.setString(38,
                                this.annuityPymtStructure.getValue().toString());
            }

            if (this.annOption.getValue() == null) {
                cstmt.setString(39, null);
            } else {
                cstmt.setString(39, this.annOption.getValue().toString());
            }

            if (this.annEscalation.getValue() == null) {
                cstmt.setString(40, null);
            } else {
                cstmt.setString(40, this.annEscalation.getValue().toString());
            }

            if (this.durationTermType.getValue() == null) {
                cstmt.setString(41, null);
            } else {
                cstmt.setString(41,
                                this.durationTermType.getValue().toString());
            }

            cstmt.setString(42, null);
            if (this.termPayoutRate.getValue() == null) {
                cstmt.setString(43, null);
            } else {
                cstmt.setString(43, this.termPayoutRate.getValue().toString());
            }

            if (this.schemeLegalAge.getValue() == null) {
                cstmt.setString(44, null);
            } else {
                cstmt.setString(44, this.schemeLegalAge.getValue().toString());
            }

            if (this.annAdminCharge.getValue() == null) {
                cstmt.setString(45, null);
            } else {
                cstmt.setString(45, this.annAdminCharge.getValue().toString());
            }

            if (this.benInvestRate.getValue() == null) {
                cstmt.setString(46, null);
            } else {
                cstmt.setString(46, this.benInvestRate.getValue().toString());
            }

            if (this.pensionMode.getValue() == null) {
                cstmt.setString(47, null);
            } else {
                cstmt.setString(47, this.pensionMode.getValue().toString());
            }

            if (this.empyerVolContr.getValue() == null) {
                cstmt.setString(48, null);
            } else {
                cstmt.setString(48, this.empyerVolContr.getValue().toString());
            }
            if (this.pensHistIntRate.getValue() == null) {
                cstmt.setString(49, null);
            } else {
                cstmt.setString(49,
                                this.pensHistIntRate.getValue().toString());
            }

            cstmt.execute();
            conn.close();
            String message = null;
            if (prodType.equalsIgnoreCase("PENS")) {
                message = "Pension Details Saved";
            } else if (prodType.equalsIgnoreCase("ANN")) {
                message = "Annuity Details Saved";
            } else if (prodType.equalsIgnoreCase("GRAT")) {
                message = "Gratuity Details Saved";
            }
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          message,
                                                                          message));

            Results = "S";
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }

        return Results;
    }

    public void glifeListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if (grpLifeRider.isSelected()) {
            MemGrpLifeRider = "Y";
        } else {
            MemGrpLifeRider = "N";
        }
    }

    public String EditPolicyCoverType() {

        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("FindCoverTypesIterator");
            RowKeySet set = policyCoverTypesLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            //System.out.println(1);
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                session.setAttribute("CoverTypeCode",
                                     r.getAttribute("PCVT_CVT_CODE"));
                session.setAttribute("pcvtCode", r.getAttribute("PCVT_CODE"));
                coverDescDisplay.setValue(r.getAttribute("PCVT_CVT_SHT_DESC"));
                overridePremDisplay.setValue(r.getAttribute("PCVT_BUT_CHARGE_PREMIUM"));
                sumAssuredDisplay.setValue(r.getAttribute("PCVT_SA"));
                loadingTypeSelect.setValue(r.getAttribute("PCVT_LOAD_DISC"));
                discLoadRateDisplay.setValue(r.getAttribute("PCVT_DISC_LOAD_RATE"));
                avANB.setValue(r.getAttribute("PCVT_AVG_ANB"));
                session.setAttribute("PCT_CODE",
                                     r.getAttribute("PCVT_PCT_CODE"));
                session.setAttribute("CVT_CODE",
                                     r.getAttribute("PCVT_CVT_CODE"));
                discChoice.setValue(r.getAttribute("PCVT_DISC"));
                discRateDisplay.setValue(r.getAttribute("PCVT_DISC_RATE"));
                discDivFactor.setValue(r.getAttribute("PCVT_DISC_DIV_FACT"));
                divFactor.setValue(r.getAttribute("PCVT_DISC_LOAD_DIV_FACT"));
                builtin.setValue(r.getAttribute("pcvtPctInbuilt"));
                accelerator.setValue(r.getAttribute("pcvtAccelerator"));

                productCoverDropBox.setDisabled(true);

                session.setAttribute("coverMaskCode",
                                     r.getAttribute("pcvt_pmas_code"));
                rateSelection.setValue(r.getAttribute("pcvt_use_cvr_rate"));
                if (r.getAttribute("pcvt_use_cvr_rate") == null) {

                    maskButton.setDisabled(true);
                    coverRate.setDisabled(true);
                    coverRateDivFactor.setDisabled(true);
                } else {
                    String Val = (String)r.getAttribute("pcvt_use_cvr_rate");
                    if (Val.equalsIgnoreCase("M")) {

                        maskButton.setDisabled(true);
                        coverRate.setDisabled(true);
                        coverRateDivFactor.setDisabled(true);
                    } else if (Val.equalsIgnoreCase("S")) {

                        maskButton.setDisabled(false);
                        coverRate.setDisabled(true);
                        coverRateDivFactor.setDisabled(true);
                    } else if (Val.equalsIgnoreCase("C")) {

                        maskButton.setDisabled(true);
                        coverRate.setDisabled(false);
                        coverRateDivFactor.setDisabled(false);
                    }
                }
                maskDesc.setValue(r.getAttribute("pcvt_pmas_sht_desc"));
                coverRate.setValue(r.getAttribute("pcvt_rate"));
                coverRateDivFactor.setValue(r.getAttribute("pcvt_rate_div_fact"));
               
                // Render Popup
                GlobalCC.showPopup("lmsgroup:polcvrdtls");
            }

        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(null, ex);
        }
        return null;
    }

    public String EditTaxesSelected() {
        try {

            DCIteratorBinding dciter =
                ADFUtils.findIterator("FindPolicyTaxesIterator");
            RowKeySet set = taxesLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            //System.out.println(1);
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                //LOVCC.ptxCode=(BigDecimal)r.getAttribute("PTX_CODE");
                session.setAttribute("ptxCode", r.getAttribute("PTX_CODE"));
                taxSel.setValue(r.getAttribute("TAX_DISPLAY"));
                applLevel.setValue(r.getAttribute("PTX_APPL_LEVEL"));
                taxRate.setValue(r.getAttribute("PTX_RATE"));
                taxAmt.setValue(r.getAttribute("PTX_TAX_AMT"));

                // Render Popup
                ExtendedRenderKitService erkService =
                    Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                       ExtendedRenderKitService.class);
                erkService.addScript(FacesContext.getCurrentInstance(),
                                     "var hints = {autodismissNever:false}; " +
                                     "AdfPage.PAGE.findComponent('" +
                                     "lmsgroup:poltaxes" + "').show(hints);");


            }

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String editPolicyCategory() {

        try {

            DCIteratorBinding dciter =
                ADFUtils.findIterator("findCategoryIterator");
            RowKeySet set = policyCategoriesLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                //LOVCC.pcaCode=(BigDecimal)r.getAttribute("lcaCode");
                session.setAttribute("pcaCode", r.getAttribute("lcaCode"));
                categIDDisplay.setValue(r.getAttribute("catShtDesc"));
                categDescriptionDisplay.setValue(r.getAttribute("catDesc"));
                categPeriodDisplay.setValue(r.getAttribute("catPeriod"));

                // Render Popup
                ExtendedRenderKitService erkService =
                    Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                       ExtendedRenderKitService.class);
                erkService.addScript(FacesContext.getCurrentInstance(),
                                     "var hints = {autodismissNever:false}; " +
                                     "AdfPage.PAGE.findComponent('" +
                                     "lmsgroup:polCategPopup" +
                                     "').show(hints);");


            }
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return null;
    }

    public String EditDependantLimit() {

        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("FindDependentsLimitsIterator");
            RowKeySet set = policyDependentLimitsLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            //System.out.println(1);
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                session.setAttribute("pdlCode", r.getAttribute("QDL_CODE"));
                session.setAttribute("pcvtCode",
                                     r.getAttribute("QDL_PCVT_CODE"));
                session.setAttribute("dtyCode",
                                     r.getAttribute("QDL_DTY_CODE"));
                session.setAttribute("CoverTypeCode",
                                     r.getAttribute("CVT_CODE"));
                session.setAttribute("qcvtcvtCode",
                                     r.getAttribute("CVT_CODE"));
                dpdCatDescDisp.setValue(r.getAttribute("PCA_CATEG_DESC"));
                limitAmountDisplay.setValue(r.getAttribute("QDL_LIMIT_AMT"));
                maxTypeDisplay.setValue(r.getAttribute("QDL_MAX_TYPE_ALLOWED"));
                minAmountDisplay.setValue(r.getAttribute("QDL_MIN_AMT"));

                //Render Popup
                GlobalCC.showPopup("lmsgroup:poldepdetails");
            }
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }


        return null;
    }

    public String EditPolicyDocuments() {

        try {

            DCIteratorBinding dciter =
                ADFUtils.findIterator("FindPolicyDocsIterator");
            RowKeySet set = groupPolicyDocsLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            //System.out.println(1);
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                //LOVCC.gpdCode=(BigDecimal)r.getAttribute("GPD_CODE");
                session.setAttribute("gpdCode", r.getAttribute("GPD_CODE"));
                documentSubmitted.setValue(r.getAttribute("DOCUMENT_SUBMITTED"));
                documentDateDisplay.setValue(r.getAttribute("dateGiven"));
                documentNoDisplay.setValue(r.getAttribute("GPD_DOC_NO"));

                //Render Popup
                ExtendedRenderKitService erkService =
                    Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                       ExtendedRenderKitService.class);
                erkService.addScript(FacesContext.getCurrentInstance(),
                                     "var hints = {autodismissNever:false}; " +
                                     "AdfPage.PAGE.findComponent('" +
                                     "lmsgroup:poldocs" + "').show(hints);");

            }
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return null;
    }

    public String EditMemberDetailssel() {

        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("FindPolicyMemberAtCoversIterator");
            RowKeySet set = policyMembersLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            //System.out.println(1);
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                //LOVCC.MemberNumber=(BigDecimal)r.getAttribute("POLM_CODE");
                session.setAttribute("MemberNumber",
                                     r.getAttribute("POLM_CODE"));
                memCoverDisplay.setValue(r.getAttribute("MEMBER_DISPLAY"));
                memHeight.setValue(r.getAttribute("POLM_HEIGHT"));
                memWeight.setValue(r.getAttribute("POLM_WEIGHT"));
                memSysPr.setValue(r.getAttribute("POLM_SYSTOLIC_PR"));
                memDiaPr.setValue(r.getAttribute("POLM_DIASTOLIC_PR"));
                //weightlding.setValue(r.getAttribute("MemName"));
                //memBPressLoading.setValue(r.getAttribute("MemName"));
                memLoadType.setValue(r.getAttribute("POLM_LOADING_TYPE"));
                memloadRate.setValue(r.getAttribute("POLM_LOADING_RATE"));
                memloadDivFac.setValue(r.getAttribute("POLM_LOADING_DIV_FACT"));
                covOffered.setValue(r.getAttribute("POLM_COVER_OFFERED"));


                // Render Popup
                GlobalCC.showPopup("lmsgroup:memotherdetails");
            }
        } catch (Exception e)

        {
            GlobalCC.EXCEPTIONREPORTING(null, e);

        }

        return null;
    }

    public String saveMemberOtherDetails() {
        Connection conn = null;
        try {
            String deleteQuery =
                "BEGIN LMS_WEB_PKG_GRP_UW.update_pol_mem_dtls(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);END;";
            conn = new DBConnector().getDatabaseConn();
            CallableStatement cstmt = conn.prepareCall(deleteQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("MemberNumber"));
            if (memHeight.getValue() == null) {
                cstmt.setString(2, null);
            } else {
                cstmt.setString(2, memHeight.getValue().toString());
            }
            if (memWeight.getValue() == null) {
                cstmt.setString(3, null);
            } else {
                cstmt.setString(3, memWeight.getValue().toString());
            }
            if (memSysPr.getValue() == null) {
                cstmt.setString(4, null);
            } else {
                cstmt.setString(4, memSysPr.getValue().toString());
            }
            if (memDiaPr.getValue() == null) {
                cstmt.setString(5, null);
            } else {
                cstmt.setString(5, memDiaPr.getValue().toString());
            }
            cstmt.setString(6, null);
            cstmt.setString(7, null);
            if (memLoadType.getValue() == null) {
                cstmt.setString(8, null);
            } else {
                cstmt.setString(8, memLoadType.getValue().toString());
            }

            if (memloadRate.getValue() == null) {
                cstmt.setString(9, null);
            } else {
                cstmt.setString(9, memloadRate.getValue().toString());
            }

            if (memloadDivFac.getValue() == null) {
                cstmt.setString(10, null);
            } else {
                cstmt.setString(10, memloadDivFac.getValue().toString());
            }
            if (covOffered.getValue() == null) {
                cstmt.setString(11, null);
            } else {
                cstmt.setString(11, covOffered.getValue().toString());
            }
            cstmt.setBigDecimal(12,
                                (BigDecimal)session.getAttribute("endorsementCode"));
            if (bmiRate.getValue() == null) {
                cstmt.setString(13, null);
            } else {
                cstmt.setString(13, bmiRate.getValue().toString());
            }
            cstmt.setString(14, null);

            if (postponePeriod.getValue() == null) {
                cstmt.setString(15, null);
            } else {
                cstmt.setString(15, (String)postponePeriod.getValue());
            }

            cstmt.execute();
            conn.close();
            ADFUtils.findIterator("FindPolicyMemberAtCoversIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(policyMembersLOV);

            ADFUtils.findIterator("FindMemberCoverTypesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(policyMemberCoversLOV);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);

        }
        return null;
    }

    public String EditMemberCoversSel() {

        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("FindMemberCoverTypesIterator");
            RowKeySet set = policyMemberCoversLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            //System.out.println(1);
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                //LOVCC.MemberNumber=(BigDecimal)r.getAttribute("QMEM_CODE");
                session.setAttribute("memcoverID", r.getAttribute("PCM_CODE"));
                session.setAttribute("memCoverTypeCode",
                                     r.getAttribute("PCM_PCVT_CODE"));

                memCoverTypeDisplay.setValue(r.getAttribute("CVT_DESC"));
                memEarningAmt.setValue(r.getAttribute("PCM_EARNINGS"));
                inputRate.setValue(r.getAttribute("PCM_RATE"));
                memEarningPeriod.setValue(r.getAttribute("PCM_MULT_EARNINGS_PRD"));
                cvrLoadType.setValue(r.getAttribute("PCM_LOADING_TYPE"));
                cvrLoadRate.setValue(r.getAttribute("PCM_LOADING_RATE"));
                cvrLoadDivFactor.setValue(r.getAttribute("PCM_LOADING_DIV_FACTOR"));

                // Render Popup
                ExtendedRenderKitService erkService =
                    Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                       ExtendedRenderKitService.class);
                erkService.addScript(FacesContext.getCurrentInstance(),
                                     "var hints = {autodismissNever:false}; " +
                                     "AdfPage.PAGE.findComponent('" +
                                     "lmsgroup:coverdtlsPopups" +
                                     "').show(hints);");

            }
        } catch (Exception e)

        {
            GlobalCC.EXCEPTIONREPORTING(null, e);

        }
        return null;
    }

    public String UpdateMemberCoverDetails() {
        Connection conn = null;
        try {
            String deleteQuery =
                "BEGIN LMS_WEB_PKG_GRP_UW.update_member_quot_pol_covers(?,?,?,?,?,?,?,?,?,?,?,?,?,?);END;";
            conn = new DBConnector().getDatabaseConn();
            CallableStatement cstmt = conn.prepareCall(deleteQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("memcoverID"));
            cstmt.setString(2, "P");
            if (memEarningAmt.getValue() == null) {
                cstmt.setString(3, null);
            } else {
                cstmt.setString(3, memEarningAmt.getValue().toString());
            }
            if (memEarningPeriod.getValue() == null) {
                cstmt.setString(4, null);
            } else {
                cstmt.setString(4, memEarningPeriod.getValue().toString());
            }
            cstmt.setString(5, null);
            cstmt.setString(6, null);
            cstmt.setString(7, null);
            cstmt.setString(8, null);
            cstmt.setString(9, null);
            cstmt.setBigDecimal(10,
                                (BigDecimal)session.getAttribute("endorsementCode"));
            cstmt.setBigDecimal(11,
                                (BigDecimal)session.getAttribute("memCoverTypeCode"));

            if (cvrLoadType.getValue() == null) {
                cstmt.setString(12, null);
            } else {
                cstmt.setString(12, cvrLoadType.getValue().toString());
            }
            if (cvrLoadRate.getValue() == null) {
                cstmt.setString(13, null);
            } else {
                cstmt.setString(13, cvrLoadRate.getValue().toString());
            }
            if (cvrLoadDivFactor.getValue() == null) {
                cstmt.setString(14, null);
            } else {
                cstmt.setString(14, cvrLoadDivFactor.getValue().toString());
            }
           /* if (inputRate.getValue() == null) {
                cstmt.setString(15, null);
            } else {
                cstmt.setString(15, inputRate.getValue().toString());
            }*/
            cstmt.execute();
            conn.close();
            ADFUtils.findIterator("FindMemberCoverTypesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(policyMemberCoversLOV);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);

        }
        return null;
    }

    public void setCoinsureTab(RichPanelBox coinsureTab) {
        this.coinsureTab = coinsureTab;
    }

    public RichPanelBox getCoinsureTab() {
        return coinsureTab;
    }

    public void setCoinsCbox(RichSelectBooleanCheckbox coinsCbox) {
        this.coinsCbox = coinsCbox;
    }

    public RichSelectBooleanCheckbox getCoinsCbox() {
        return coinsCbox;
    }

    public void setPensionType(RichSelectOneChoice pensionType) {
        this.pensionType = pensionType;
    }

    public RichSelectOneChoice getPensionType() {
        return pensionType;
    }

    public void setGuaranteePrdDisplay(RichInputText guaranteePrdDisplay) {
        this.guaranteePrdDisplay = guaranteePrdDisplay;
    }

    public RichInputText getGuaranteePrdDisplay() {
        return guaranteePrdDisplay;
    }

    public void setPensEscDisplay(RichInputText pensEscDisplay) {
        this.pensEscDisplay = pensEscDisplay;
    }

    public RichInputText getPensEscDisplay() {
        return pensEscDisplay;
    }

    public void setPensPayFrequency(RichSelectOneChoice pensPayFrequency) {
        this.pensPayFrequency = pensPayFrequency;
    }

    public RichSelectOneChoice getPensPayFrequency() {
        return pensPayFrequency;
    }

    public void setRmaleDisplay(RichInputText rmaleDisplay) {
        this.rmaleDisplay = rmaleDisplay;
    }

    public RichInputText getRmaleDisplay() {
        return rmaleDisplay;
    }

    public void setRfemaleDisplay(RichInputText rfemaleDisplay) {
        this.rfemaleDisplay = rfemaleDisplay;
    }

    public RichInputText getRfemaleDisplay() {
        return rfemaleDisplay;
    }

    public void setPensAdminDisplay(RichInputText pensAdminDisplay) {
        this.pensAdminDisplay = pensAdminDisplay;
    }

    public RichInputText getPensAdminDisplay() {
        return pensAdminDisplay;
    }

    public void setTotEmpyeeContr(RichInputText totEmpyeeContr) {
        this.totEmpyeeContr = totEmpyeeContr;
    }

    public RichInputText getTotEmpyeeContr() {
        return totEmpyeeContr;
    }

    public void setTotEmpyerContr(RichInputText totEmpyerContr) {
        this.totEmpyerContr = totEmpyerContr;
    }

    public RichInputText getTotEmpyerContr() {
        return totEmpyerContr;
    }

    public void setContrType(RichSelectOneChoice contrType) {
        this.contrType = contrType;
    }

    public RichSelectOneChoice getContrType() {
        return contrType;
    }

    public void setEmpyerContrRate(RichInputText empyerContrRate) {
        this.empyerContrRate = empyerContrRate;
    }

    public RichInputText getEmpyerContrRate() {
        return empyerContrRate;
    }

    public void setEmpyeeContrRate(RichInputText empyeeContrRate) {
        this.empyeeContrRate = empyeeContrRate;
    }

    public RichInputText getEmpyeeContrRate() {
        return empyeeContrRate;
    }

    public void setFundingRate(RichInputText fundingRate) {
        this.fundingRate = fundingRate;
    }

    public RichInputText getFundingRate() {
        return fundingRate;
    }

    public void setPensCommRate(RichInputText pensCommRate) {
        this.pensCommRate = pensCommRate;
    }

    public RichInputText getPensCommRate() {
        return pensCommRate;
    }

    public void setEmpyerVolContr(RichInputText empyerVolContr) {
        this.empyerVolContr = empyerVolContr;
    }

    public RichInputText getEmpyerVolContr() {
        return empyerVolContr;
    }

    public void setEmplyeeVolContr(RichInputText emplyeeVolContr) {
        this.emplyeeVolContr = emplyeeVolContr;
    }

    public RichInputText getEmplyeeVolContr() {
        return emplyeeVolContr;
    }

    public void setEmpyerPensBF(RichInputText empyerPensBF) {
        this.empyerPensBF = empyerPensBF;
    }

    public RichInputText getEmpyerPensBF() {
        return empyerPensBF;
    }

    public void setEmpyeePensBF(RichInputText empyeePensBF) {
        this.empyeePensBF = empyeePensBF;
    }

    public RichInputText getEmpyeePensBF() {
        return empyeePensBF;
    }

    public void setTotPensBF(RichInputText totPensBF) {
        this.totPensBF = totPensBF;
    }

    public RichInputText getTotPensBF() {
        return totPensBF;
    }

    public void setPensInterestRate(RichInputText pensInterestRate) {
        this.pensInterestRate = pensInterestRate;
    }

    public RichInputText getPensInterestRate() {
        return pensInterestRate;
    }

    public void setPenEarnEsc(RichInputText penEarnEsc) {
        this.penEarnEsc = penEarnEsc;
    }

    public RichInputText getPenEarnEsc() {
        return penEarnEsc;
    }

    public void setPensionsTab(RichPanelBox pensionsTab) {
        this.pensionsTab = pensionsTab;
    }

    public RichPanelBox getPensionsTab() {
        return pensionsTab;
    }

    public void setArrangementDisplay1(RichInputText arrangementDisplay1) {
        this.arrangementDisplay1 = arrangementDisplay1;
    }

    public RichInputText getArrangementDisplay1() {
        return arrangementDisplay1;
    }

    public void setTreatyArrangementsLOV1(RichTable treatyArrangementsLOV1) {
        this.treatyArrangementsLOV1 = treatyArrangementsLOV1;
    }

    public RichTable getTreatyArrangementsLOV1() {
        return treatyArrangementsLOV1;
    }

    public void setReinsurancePanel(HtmlPanelGrid reinsurancePanel) {
        this.reinsurancePanel = reinsurancePanel;
    }

    public HtmlPanelGrid getReinsurancePanel() {
        return reinsurancePanel;
    }

    public void setAvANBLabel(RichOutputLabel avANBLabel) {
        this.avANBLabel = avANBLabel;
    }

    public RichOutputLabel getAvANBLabel() {
        return avANBLabel;
    }

    public void setAvANB(RichInputText avANB) {
        this.avANB = avANB;
    }

    public RichInputText getAvANB() {
        return avANB;
    }

    public void facultativeListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        //String object = valueChangeEvent.getOldValue().toString();
        if (facultativeCbox.isSelected()) {
            ADFUtils.findIterator("findSchemeFacrePlacementsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(schemefucPrcpts);

            ADFUtils.findIterator("findFulcatativePlacementsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(fucPlacement);

            schemeFacTab.setDisabled(false);
            facTab.setDisabled(false);
            //arrangementButton.setDisabled(true);
            //arrangementDisplay.setValue(null);
            //session.setAttribute("TaCode", null);
        } else {
            schemeFacTab.setDisabled(true);
            facTab.setDisabled(true);
            //arrangementButton.setDisabled(false);
        }

    }

    public void reinsListener(SelectionEvent selectionEvent) {
        BigDecimal Excess = new BigDecimal("0");

        // Add event code here...
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindRiDetailsIterator");
        RowKeySet set = selectionEvent.getAddedSet();
        Iterator rowKeySetIter = set.iterator();


        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            //LOVCC.pmrid_code=(BigDecimal)r.getAttribute("PMRID_CODE");
            session.setAttribute("pmrid_code", r.getAttribute("PMRID_CODE"));
            Excess = (BigDecimal)r.getAttribute("PMRID_EXCESS_AMT");
            //session.setAttribute("pmritd_code", r.getAttribute("PMRITD_CODE"));

            ADFUtils.findIterator("FindRiTrtDetailsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(memRiTreatyDtlsLOV);

            ADFUtils.findIterator("FindRiTrtCessionsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(trtPart);

            ADFUtils.findIterator("findFulcatativePlacementsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(fucPlacement);

            /*BigDecimal Zero = new BigDecimal("0");
          String FacPlacements = (String)session.getAttribute("facPlacements");
            if(Excess == null){
              facTab.setDisabled(true);
            }else if(!Excess.equals(Zero)){
              facTab.setDisabled(false);
            }else if(Excess.equals(Zero) && FacPlacements.equalsIgnoreCase("Y")){
              facTab.setDisabled(false);
            }else{
              facTab.setDisabled(true);
            }*/

        }
    }

    public void cessionListener(SelectionEvent selectionEvent) {
        // Add event code here...
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindRiTrtDetailsIterator");
        RowKeySet set = selectionEvent.getAddedSet();
        Iterator rowKeySetIter = set.iterator();


        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            session.setAttribute("pmritd_code", r.getAttribute("PMRITD_CODE"));

            //ADFUtils.findIterator("FindRiTrtDetailsIterator").executeQuery();
            //AdfFacesContext.getCurrentInstance().addPartialTarget(memRiTreatyDtlsLOV);

            ADFUtils.findIterator("FindRiTrtCessionsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(trtPart);


        }
    }

    public String newFac() {
        GlobalCC.showPopup("lmsgroup:facPlac");
        facCode.setValue(null);
        facRateAmt.setValue(null);
        facAmount.setValue(null);
        facRate.setValue(null);
        facPremRate.setValue(null);
        facDivFactor.setValue(null);
        facCommRate.setValue(null);
        session.setAttribute("SchemeFac", "N");
        session.setAttribute("cvtCode", null);
        return null;
    }

    public String newSchemeFac() {
        GlobalCC.showPopup("lmsgroup:facPlac");
        facCode.setValue(null);
        facRateAmt.setValue(null);
        facAmount.setValue(null);
        facRate.setValue(null);
        facPremRate.setValue(null);
        facDivFactor.setValue(null);
        facCommRate.setValue(null);
        session.setAttribute("SchemeFac", "Y");
        return null;
    }

    public String newSelectReinCompany() {
        if (session.getAttribute("pmrid_code") == null &&
            session.getAttribute("SchemeFac") == "N") {
            GlobalCC.errorValueNotEntered("Select A Member's Cover Type Details");
            return null;
        }
        ADFUtils.findIterator("findRiCompaniesIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(reinCompaniesTab);
        GlobalCC.showPopup("lmsgroup:ricomppop");

        return null;
    }

    public String selectReinCompany() {
        try {
            RowKeySet rowKeySet = reinCompaniesTab.getSelectedRowKeys();
            if (rowKeySet == null) {
                return null;
            }
            if (!rowKeySet.iterator().hasNext()) //no selection
            {
                GlobalCC.errorValueNotEntered("No Record Selected");
                return null;
            }
            Object key2 = rowKeySet.iterator().next();
            reinCompaniesTab.setRowKey(key2);
            JUCtrlValueBinding r =
                (JUCtrlValueBinding)reinCompaniesTab.getRowData();
            if (r == null) {
                GlobalCC.errorValueNotEntered("No Record Selected");
                return null;
            }

            facAgnCode.setValue(r.getAttribute("agnCode"));
            facAgnName.setValue(r.getAttribute("agnName"));
            GlobalCC.hidePopup("lmsgroup:ricomppop");
            AdfFacesContext.getCurrentInstance().addPartialTarget(facAgnCode);
            AdfFacesContext.getCurrentInstance().addPartialTarget(facAgnName);

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String cancelSelectReinCompany() {
        GlobalCC.hidePopup("lmsgroup:ricomppop");
        return null;
    }

    public void facAmountRateSelected(ValueChangeEvent evt) {
        if (evt.getNewValue() != evt.getOldValue() &&
            evt.getNewValue() != null) {
            String facRateAmtVal = facRateAmt.getValue().toString();
            if (facRateAmtVal.equalsIgnoreCase("A")) {
                facAmntLabel.setVisible(true);
                facAmount.setVisible(true);
                facRatetLabel.setVisible(false);
                facRate.setVisible(false);
            } else if (facRateAmtVal.equalsIgnoreCase("R")) {
                facAmntLabel.setVisible(false);
                facAmount.setVisible(false);
                facRatetLabel.setVisible(true);
                facRate.setVisible(true);
            }
            AdfFacesContext.getCurrentInstance().addPartialTarget(facPlacDetails);
        }
    }

    public String editFac() {
        RowKeySet rowKeySet = fucPlacement.getSelectedRowKeys();
        if (rowKeySet == null) {
            return null;
        }
        if (!rowKeySet.iterator().hasNext()) //no selection
        {
            GlobalCC.errorValueNotEntered("No Record Selected");
            return null;
        }
        Object key2 = rowKeySet.iterator().next();
        fucPlacement.setRowKey(key2);
        JUCtrlValueBinding nodeBinding =
            (JUCtrlValueBinding)fucPlacement.getRowData();
        if (nodeBinding == null) {
            GlobalCC.errorValueNotEntered("No Record Selected");
            return null;
        }
        try {
            GlobalCC.showPopup("lmsgroup:facPlac");
            facCode.setValue(nodeBinding.getAttribute("gfcCode"));
            facRateAmt.setValue(nodeBinding.getAttribute("gfcAmtOrRate"));
            facAmount.setValue(nodeBinding.getAttribute("gfcAmt"));
            facRate.setValue(nodeBinding.getAttribute("gfcRate"));
            facPremRate.setValue(nodeBinding.getAttribute("gfcPremRate"));
            facDivFactor.setValue(nodeBinding.getAttribute("gfcPremDivFactor"));
            facCommRate.setValue(nodeBinding.getAttribute("gfcCommRate"));
            facAgnCode.setValue(nodeBinding.getAttribute("gfcAgnCode"));
            facAgnName.setValue(nodeBinding.getAttribute("gfcAgnDesc"));
            AdfFacesContext.getCurrentInstance().addPartialTarget(facPlacDetails);
        } catch (Exception e) {
            e.printStackTrace();
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return null;
    }

    public String editSchemeFac() {
        session.setAttribute("SchemeFac", "Y");
        RowKeySet rowKeySet = schemefucPrcpts.getSelectedRowKeys();
        if (rowKeySet == null) {
            return null;
        }
        if (!rowKeySet.iterator().hasNext()) //no selection
        {
            GlobalCC.errorValueNotEntered("No Record Selected");
            return null;
        }
        Object key2 = rowKeySet.iterator().next();
        schemefucPrcpts.setRowKey(key2);
        JUCtrlValueBinding nodeBinding =
            (JUCtrlValueBinding)schemefucPrcpts.getRowData();
        if (nodeBinding == null) {
            GlobalCC.errorValueNotEntered("No Record Selected");
            return null;
        }
        try {
            GlobalCC.showPopup("lmsgroup:facPlac");
            facCode.setValue(nodeBinding.getAttribute("gfcCode"));
            facRateAmt.setValue(nodeBinding.getAttribute("gfcAmtOrRate"));
            session.setAttribute("rateAmt",
                                 nodeBinding.getAttribute("gfcAmtOrRate"));
            facAmount.setValue(nodeBinding.getAttribute("gfcAmt"));
            facRate.setValue(nodeBinding.getAttribute("gfcRate"));
            facPremRate.setValue(nodeBinding.getAttribute("gfcPremRate"));
            facDivFactor.setValue(nodeBinding.getAttribute("gfcPremDivFactor"));
            facCommRate.setValue(nodeBinding.getAttribute("gfcCommRate"));
            facAgnCode.setValue(nodeBinding.getAttribute("gfcAgnCode"));
            facAgnName.setValue(nodeBinding.getAttribute("gfcAgnDesc"));
            AdfFacesContext.getCurrentInstance().addPartialTarget(facPlacDetails);
        } catch (Exception e) {
            e.printStackTrace();
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return null;
    }

    public String saveFac() {
        String idVal = null;
        String rateAmtVal = null;
        String amtVal = null;
        String rateVal = null;
        String premRateVal = null;
        String divVal = null;
        String commVal = null;
        String reinVal = null;
        idVal = GlobalCC.checkNullValues(facCode.getValue());
        rateAmtVal = GlobalCC.checkNullValues(facRateAmt.getValue());
        amtVal = GlobalCC.checkNullValues(facAmount.getValue());
        rateVal = GlobalCC.checkNullValues(facRate.getValue());
        premRateVal = GlobalCC.checkNullValues(facPremRate.getValue());
        divVal = GlobalCC.checkNullValues(facDivFactor.getValue());
        commVal = GlobalCC.checkNullValues(facCommRate.getValue());
        reinVal = GlobalCC.checkNullValues(facAgnCode.getValue());
        BigDecimal pmridCodeVal =
            (BigDecimal)session.getAttribute("pmrid_code");
        BigDecimal transNoVal =
            (BigDecimal)session.getAttribute("transactionNumber");

        if (transNoVal == null) {
            GlobalCC.errorValueNotEntered("Error Value Missing: Transaction No");
            return null;
        }

        if (session.getAttribute("rateAmt") == null) {
            //continue...
        } else {
            String Value = (String)session.getAttribute("rateAmt");
            if (!rateAmtVal.equalsIgnoreCase(Value)) {
                if (rateAmtVal.equalsIgnoreCase("A")) {
                    GlobalCC.sysInformation("A Rate has already been used for previous Reinsurers. You cannot select an Amount");
                } else {
                    GlobalCC.sysInformation("An Amount has already been used for previous Reinsurers. You cannot select a Rate");
                }

                return null;
            }
        }
        DBConnector datahandler = null;
        datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;

        try {

            String reinQuery =
                "begin LMS_WEB_PKG_GRP_UW.UpdateSchemeFacre(?,?,?,?,?,?,?,?,?,?,?); end;";

            if (session.getAttribute("SchemeFac") == "N") {
                if (pmridCodeVal == null) {
                    GlobalCC.errorValueNotEntered("Error Value Missing: Member Reinsure Cover Details");
                    return null;
                }
                reinQuery =
                        "begin LMS_WEB_PKG_GRP_UW.UpdateFacre(?,?,?,?,?,?,?,?,?,?,?); end;";
            } else {
                reinQuery =
                        "begin LMS_WEB_PKG_GRP_UW.UpdateSchemeFacre(?,?,?,?,?,?,?,?,?,?,?); end;";
            }

            String RateTypeVal = (String)session.getAttribute("facRateType");
            if (RateTypeVal == null) {
                GlobalCC.INFORMATIONREPORTING("Select A Rate Type");
                return null;
            } else if (RateTypeVal.equalsIgnoreCase("CR") &&
                       facPremRate.getValue() == null) {
                GlobalCC.INFORMATIONREPORTING("Enter A Premium Rate");
                return null;
            }

            cst = conn.prepareCall(reinQuery);
            cst.setString(1, idVal);
            if (session.getAttribute("SchemeFac") == "N") {
                cst.setBigDecimal(2, pmridCodeVal);
            } else {
                cst.setBigDecimal(2,
                                  (BigDecimal)session.getAttribute("endorsementCode"));
            }
            cst.setBigDecimal(3, transNoVal);
            cst.setString(4, rateAmtVal);
            cst.setString(5, amtVal);
            cst.setString(6, rateVal);
            cst.setString(7, premRateVal);
            cst.setString(8, divVal);
            cst.setString(9, commVal);
            cst.setString(10, reinVal);
            cst.setBigDecimal(11, (BigDecimal)session.getAttribute("cvtCode"));
            cst.execute();
            cst.close();
            conn.commit();
            conn.close();
            // session.setAttribute("poridsCode", null);
            // session.setAttribute("pcvtCode", null);
            GlobalCC.sysInformation("Record Successfully Saved");
            GlobalCC.hidePopup("lmsgroup:facPlac");

            ADFUtils.findIterator("FindRiDetailsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(riTrtDtlsLOV);

            ADFUtils.findIterator("FindRiTrtDetailsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(memRiTreatyDtlsLOV);

            ADFUtils.findIterator("FindRiTrtCessionsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(trtPart);

            ADFUtils.findIterator("findFulcatativePlacementsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(fucPlacement);

            ADFUtils.findIterator("findSchemeFacrePlacementsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(schemefucPrcpts);


        } catch (Exception e) {
            e.printStackTrace();
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }

        return null;
    }

    public String deleteFacPlacement() {
        RowKeySet rowKeySet = fucPlacement.getSelectedRowKeys();
        if (rowKeySet == null) {
            return null;
        }
        if (!rowKeySet.iterator().hasNext()) //no selection
        {
            GlobalCC.errorValueNotEntered("No Record Selected");
            return null;
        }
        Object key2 = rowKeySet.iterator().next();
        fucPlacement.setRowKey(key2);
        JUCtrlValueBinding r = (JUCtrlValueBinding)fucPlacement.getRowData();
        if (r == null) {
            GlobalCC.errorValueNotEntered("No Record Selected");
            return null;
        }
        DBConnector datahandler = null;
        datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();
        CallableStatement cst = null;

        try {
            String reinQuery = "begin LMS_WEB_PKG_GRP_UW.DeleteFacre(?); end;";
            cst = conn.prepareCall(reinQuery);
            cst.setBigDecimal(1, (BigDecimal)r.getAttribute("gfcCode"));
            cst.execute();
            cst.close();
            conn.commit();
            conn.close();
            // session.setAttribute("poridsCode", null);
            // session.setAttribute("pcvtCode", null);
            ADFUtils.findIterator("FindRiDetailsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(riTrtDtlsLOV);

            ADFUtils.findIterator("FindRiTrtDetailsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(memRiTreatyDtlsLOV);

            ADFUtils.findIterator("FindRiTrtCessionsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(trtPart);

            ADFUtils.findIterator("findFulcatativePlacementsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(fucPlacement);


        } catch (Exception e) {
            e.printStackTrace();
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public String deleteSchemeFacPlacement() {
        RowKeySet rowKeySet = schemefucPrcpts.getSelectedRowKeys();
        if (rowKeySet == null) {
            return null;
        }
        if (!rowKeySet.iterator().hasNext()) //no selection
        {
            GlobalCC.errorValueNotEntered("No Record Selected");
            return null;
        }
        Object key2 = rowKeySet.iterator().next();
        schemefucPrcpts.setRowKey(key2);
        JUCtrlValueBinding r =
            (JUCtrlValueBinding)schemefucPrcpts.getRowData();
        if (r == null) {
            GlobalCC.errorValueNotEntered("No Record Selected");
            return null;
        }
        DBConnector datahandler = null;
        datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();
        CallableStatement cst = null;

        try {
            String reinQuery =
                "begin LMS_WEB_PKG_GRP_UW.DeleteSchemeFacre(?,?); end;";
            cst = conn.prepareCall(reinQuery);
            cst.setBigDecimal(1, (BigDecimal)r.getAttribute("gfcCode"));
            cst.setBigDecimal(2,
                              (BigDecimal)session.getAttribute("endorsementCode"));
            cst.execute();
            cst.close();
            conn.commit();
            conn.close();
            // session.setAttribute("poridsCode", null);
            // session.setAttribute("pcvtCode", null);
            ADFUtils.findIterator("FindRiDetailsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(riTrtDtlsLOV);

            ADFUtils.findIterator("FindRiTrtDetailsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(memRiTreatyDtlsLOV);

            ADFUtils.findIterator("FindRiTrtCessionsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(trtPart);

            ADFUtils.findIterator("findFulcatativePlacementsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(fucPlacement);

            ADFUtils.findIterator("findSchemeFacrePlacementsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(schemefucPrcpts);


        } catch (Exception e) {
            e.printStackTrace();
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public String editMemberRIDetails() {
        RowKeySet rowKeySet = riTrtDtlsLOV.getSelectedRowKeys();
        if (rowKeySet == null) {
            return null;
        }
        if (!rowKeySet.iterator().hasNext()) //no selection
        {
            GlobalCC.errorValueNotEntered("No Record Selected");
            return null;
        }
        Object key2 = rowKeySet.iterator().next();
        riTrtDtlsLOV.setRowKey(key2);
        JUCtrlValueBinding nodeBinding =
            (JUCtrlValueBinding)riTrtDtlsLOV.getRowData();
        if (nodeBinding == null) {
            GlobalCC.errorValueNotEntered("No Record Selected");
            return null;
        }
        try {
            GlobalCC.showPopup("lmsgroup:memExcess");
            coverDescLabel.setValue(nodeBinding.getAttribute("COVER_DISPLAY"));
            totalSALabel.setValue(nodeBinding.getAttribute("PMRID_TOT_SA"));
            grossRetLabel.setValue(nodeBinding.getAttribute("PMRID_GROSS_RETENTION"));
            excessAmount.setValue(nodeBinding.getAttribute("PMRID_EXCESS_AMT"));

            BigDecimal TotalSA = null;
            BigDecimal GrossRetention = null;
            BigDecimal Zero = new BigDecimal("0");
            BigDecimal Result = null;
            BigDecimal Excess = null;

            if (nodeBinding.getAttribute("PMRID_EXCESS_AMT") == null) {
                Excess = new BigDecimal("0");
            } else {
                Excess =
                        (BigDecimal)nodeBinding.getAttribute("PMRID_EXCESS_AMT");
            }

            if (Excess.equals(Zero)) {
                if (nodeBinding.getAttribute("PMRID_TOT_SA") == null) {
                    TotalSA = Zero;
                } else {
                    TotalSA =
                            (BigDecimal)nodeBinding.getAttribute("PMRID_TOT_SA");
                }
                if (nodeBinding.getAttribute("PMRID_GROSS_RETENTION") ==
                    null) {
                    GrossRetention = Zero;
                } else {
                    GrossRetention =
                            (BigDecimal)nodeBinding.getAttribute("PMRID_GROSS_RETENTION");
                }
                Result = TotalSA.subtract(GrossRetention);
                excessAmount.setValue(Result);
            } else {
                //DO NOTHING...
            }
        } catch (Exception e) {
            e.printStackTrace();
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return null;
    }

    public String saveMemberRIDetails() {

        BigDecimal pmridCodeVal =
            (BigDecimal)session.getAttribute("pmrid_code");
        if (pmridCodeVal == null) {
            GlobalCC.errorValueNotEntered("Error Value Missing: Member Reinsure Cover Details");
            return null;
        }

        DBConnector datahandler = null;
        datahandler = new DBConnector();
        Connection conn;
        conn = datahandler.getDatabaseConn();

        CallableStatement cst = null;

        try {
            String reinQuery =
                "begin LMS_WEB_PKG_GRP.update_member_ri_details(?,?); end;";

            cst = conn.prepareCall(reinQuery);
            cst.setBigDecimal(1, pmridCodeVal);
            if (excessAmount.getValue() == null) {
                cst.setString(2, null);
            } else {
                cst.setString(2, excessAmount.getValue().toString());
            }

            cst.execute();
            cst.close();
            conn.commit();
            conn.close();
            // session.setAttribute("poridsCode", null);
            // session.setAttribute("pcvtCode", null);
            GlobalCC.sysInformation("Record Successfully Saved");
            GlobalCC.hidePopup("lmsgroup:memExcess");

            ADFUtils.findIterator("FindRiDetailsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(riTrtDtlsLOV);

        } catch (Exception e) {
            e.printStackTrace();
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }

        return null;
    }


    public void setTrtPart(RichTable trtPart) {
        this.trtPart = trtPart;
    }

    public RichTable getTrtPart() {
        return trtPart;
    }

    public void setPolCatLOV(RichTable polCatLOV) {
        this.polCatLOV = polCatLOV;
    }

    public RichTable getPolCatLOV() {
        return polCatLOV;
    }

    public void setUsersLOV(RichTable usersLOV) {
        this.usersLOV = usersLOV;
    }

    public RichTable getUsersLOV() {
        return usersLOV;
    }

    public void setPensWEF(RichInputDate pensWEF) {
        this.pensWEF = pensWEF;
    }

    public RichInputDate getPensWEF() {
        return pensWEF;
    }

    public void setPensEarnings(RichInputText pensEarnings) {
        this.pensEarnings = pensEarnings;
    }

    public RichInputText getPensEarnings() {
        return pensEarnings;
    }

    public void setPensTotalContri(RichInputText pensTotalContri) {
        this.pensTotalContri = pensTotalContri;
    }

    public RichInputText getPensTotalContri() {
        return pensTotalContri;
    }

    public void setPensWET(RichInputDate pensWET) {
        this.pensWET = pensWET;
    }

    public RichInputDate getPensWET() {
        return pensWET;
    }

    public void setPensEmprContr(RichInputText pensEmprContr) {
        this.pensEmprContr = pensEmprContr;
    }

    public RichInputText getPensEmprContr() {
        return pensEmprContr;
    }

    public void setPensAnnFund(RichInputText pensAnnFund) {
        this.pensAnnFund = pensAnnFund;
    }

    public RichInputText getPensAnnFund() {
        return pensAnnFund;
    }

    public void setPensAdminFee(RichInputText pensAdminFee) {
        this.pensAdminFee = pensAdminFee;
    }

    public RichInputText getPensAdminFee() {
        return pensAdminFee;
    }

    public void setPensEmpeContri(RichInputText pensEmpeContri) {
        this.pensEmpeContri = pensEmpeContri;
    }

    public RichInputText getPensEmpeContri() {
        return pensEmpeContri;
    }

    public void setPensIntRate(RichInputText pensIntRate) {
        this.pensIntRate = pensIntRate;
    }

    public RichInputText getPensIntRate() {
        return pensIntRate;
    }

    public void setPensAnnFac(RichInputText pensAnnFac) {
        this.pensAnnFac = pensAnnFac;
    }

    public RichInputText getPensAnnFac() {
        return pensAnnFac;
    }

    public void setEmpeVolContr(RichInputText empeVolContr) {
        this.empeVolContr = empeVolContr;
    }

    public RichInputText getEmpeVolContr() {
        return empeVolContr;
    }

    public void setPensAnnum(RichInputText pensAnnum) {
        this.pensAnnum = pensAnnum;
    }

    public RichInputText getPensAnnum() {
        return pensAnnum;
    }

    public void setPensEMV(RichInputText pensEMV) {
        this.pensEMV = pensEMV;
    }

    public RichInputText getPensEMV() {
        return pensEMV;
    }

    public void setPensEmprEMV(RichInputText pensEmprEMV) {
        this.pensEmprEMV = pensEmprEMV;
    }

    public RichInputText getPensEmprEMV() {
        return pensEmprEMV;
    }

    public void setPensEmpeEMV(RichInputText pensEmpeEMV) {
        this.pensEmpeEMV = pensEmpeEMV;
    }

    public RichInputText getPensEmpeEMV() {
        return pensEmpeEMV;
    }

    public void setUnitRateOption(RichSelectOneChoice unitRateOption) {
        this.unitRateOption = unitRateOption;
    }

    public RichSelectOneChoice getUnitRateOption() {
        return unitRateOption;
    }

    public void setVAT(RichInputNumberSpinbox VAT) {
        this.VAT = VAT;
    }

    public RichInputNumberSpinbox getVAT() {
        return VAT;
    }

    public void setOvrCommRate(RichInputNumberSpinbox ovrCommRate) {
        this.ovrCommRate = ovrCommRate;
    }

    public RichInputNumberSpinbox getOvrCommRate() {
        return ovrCommRate;
    }

    public void setAssignCreation(RichCommandLink assignCreation) {
        this.assignCreation = assignCreation;
    }

    public RichCommandLink getAssignCreation() {
        return assignCreation;
    }

    public void setEndrSA(RichOutputText endrSA) {
        this.endrSA = endrSA;
    }

    public RichOutputText getEndrSA() {
        return endrSA;
    }

    public void setEndrSA2(RichInputText endrSA2) {
        this.endrSA2 = endrSA2;
    }

    public RichInputText getEndrSA2() {
        return endrSA2;
    }

    public void setEndrFclType(RichSelectOneChoice endrFclType) {
        this.endrFclType = endrFclType;
    }

    public RichSelectOneChoice getEndrFclType() {
        return endrFclType;
    }

    public void setEndrFCLAmt(RichInputText endrFCLAmt) {
        this.endrFCLAmt = endrFCLAmt;
    }

    public RichInputText getEndrFCLAmt() {
        return endrFCLAmt;
    }

    public void setEndrOvrFCLAmt(RichInputText endrOvrFCLAmt) {
        this.endrOvrFCLAmt = endrOvrFCLAmt;
    }

    public RichInputText getEndrOvrFCLAmt() {
        return endrOvrFCLAmt;
    }

    public void ovrFCLAmtListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if (endrOvrFCLAmt.getValue() == null) {
            //do Nothing
        } else {
            DBConnector datahandler = null;
            datahandler = new DBConnector();
            Connection conn;
            conn = datahandler.getDatabaseConn();
            CallableStatement cst = null;
            BigDecimal FCL =
                new BigDecimal(endrOvrFCLAmt.getValue().toString());
            session.setAttribute("FCLTotalAmt", FCL);


            try {
                String reinQuery =
                    "begin LMS_WEB_PKG_GRP.updateOverrideFCL(?,?); end;";

                cst = conn.prepareCall(reinQuery);
                cst.setBigDecimal(1,
                                  (BigDecimal)session.getAttribute("endorsementCode"));
                cst.setString(2, endrOvrFCLAmt.getValue().toString());
                cst.execute();
                cst.close();
                conn.commit();
                conn.close();

                endrOvrFCLAmt.setReadOnly(true);
                ADFUtils.findIterator("FindEndorsementsIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.endrOvrFCLAmt);

            } catch (Exception e) {
                e.printStackTrace();
                GlobalCC.EXCEPTIONREPORTING(conn, e);
            }
        }
    }

    public void setDjMemNo(RichInputText djMemNo) {
        this.djMemNo = djMemNo;
    }

    public RichInputText getDjMemNo() {
        return djMemNo;
    }

    public void setDjSurname(RichInputText djSurname) {
        this.djSurname = djSurname;
    }

    public RichInputText getDjSurname() {
        return djSurname;
    }

    public void setDjOtherNames(RichInputText djOtherNames) {
        this.djOtherNames = djOtherNames;
    }

    public RichInputText getDjOtherNames() {
        return djOtherNames;
    }

    public void setDjSex(RichSelectOneChoice djSex) {
        this.djSex = djSex;
    }

    public RichSelectOneChoice getDjSex() {
        return djSex;
    }

    public void setDjIDNo(RichInputText djIDNo) {
        this.djIDNo = djIDNo;
    }

    public RichInputText getDjIDNo() {
        return djIDNo;
    }

    public void setDjDOB(RichInputDate djDOB) {
        this.djDOB = djDOB;
    }

    public RichInputDate getDjDOB() {
        return djDOB;
    }

    public void setDepTypeLOV2(RichTable depTypeLOV2) {
        this.depTypeLOV2 = depTypeLOV2;
    }

    public RichTable getDepTypeLOV2() {
        return depTypeLOV2;
    }

    public void setMemDependantsLOV(RichTable memDependantsLOV) {
        this.memDependantsLOV = memDependantsLOV;
    }

    public RichTable getMemDependantsLOV() {
        return memDependantsLOV;
    }

    public void durationTypeListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        try {
            if (durationType.getValue() == null) {
                session.setAttribute("policyDurationType", null);
            } else {
                session.setAttribute("policyDurationType",
                                     durationType.getValue().toString());
                if (durationType.getValue().toString().equalsIgnoreCase("C")) {
                    wetDate.setValue(null);
                    //Render Popup
                    ExtendedRenderKitService erkService =
                        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                           ExtendedRenderKitService.class);
                    erkService.addScript(FacesContext.getCurrentInstance(),
                                         "var hints = {autodismissNever:false}; " +
                                         "AdfPage.PAGE.findComponent('" +
                                         "lmsgroup:duraPopup" +
                                         "').show(hints);");

                } else {
                    saveDurationType(durationType.getValue().toString());
                }
            }
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
    }

    public String saveDurationType(String DType) {
        Connection conn = null;
        try {
            String deleteQuery =
                "BEGIN LMS_WEB_PKG_GRP_UW.endorsement_duration_change(?,?,?);END;";
            conn = new DBConnector().getDatabaseConn();
            CallableStatement cstmt = conn.prepareCall(deleteQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("endorsementCode"));
            if (DType.equalsIgnoreCase("C")) {
                cstmt.setString(2,
                                GlobalCC.parseDate(wetDate.getValue().toString()));
            } else {
                cstmt.setString(2, null);
            }
            cstmt.setString(3, DType);
            cstmt.execute();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);

        }
        return null;
    }

    public String saveWETDate() {
        try {
            if (wetDate.getValue() == null) {
                String Message = "Select A WET Date";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));

                return null;
            } else {
                saveDurationType("C");
            }

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public void setWetDate(RichInputDate wetDate) {
        this.wetDate = wetDate;
    }

    public RichInputDate getWetDate() {
        return wetDate;
    }

    public void setMemCoverDisplay(RichOutputText memCoverDisplay) {
        this.memCoverDisplay = memCoverDisplay;
    }

    public RichOutputText getMemCoverDisplay() {
        return memCoverDisplay;
    }

    public void setMemHeight(RichInputText memHeight) {
        this.memHeight = memHeight;
    }

    public RichInputText getMemHeight() {
        return memHeight;
    }

    public void setMemWeight(RichInputText memWeight) {
        this.memWeight = memWeight;
    }

    public RichInputText getMemWeight() {
        return memWeight;
    }

    public void setMemSysPr(RichInputText memSysPr) {
        this.memSysPr = memSysPr;
    }

    public RichInputText getMemSysPr() {
        return memSysPr;
    }

    public void setMemDiaPr(RichInputText memDiaPr) {
        this.memDiaPr = memDiaPr;
    }

    public RichInputText getMemDiaPr() {
        return memDiaPr;
    }

    public void setWeightlding(RichInputText weightlding) {
        this.weightlding = weightlding;
    }

    public RichInputText getWeightlding() {
        return weightlding;
    }

    public void setMemBPressLoading(RichInputText memBPressLoading) {
        this.memBPressLoading = memBPressLoading;
    }

    public RichInputText getMemBPressLoading() {
        return memBPressLoading;
    }

    public void setMemLoadType(RichSelectOneChoice memLoadType) {
        this.memLoadType = memLoadType;
    }

    public RichSelectOneChoice getMemLoadType() {
        return memLoadType;
    }

    public void setMemloadRate(RichInputText memloadRate) {
        this.memloadRate = memloadRate;
    }

    public RichInputText getMemloadRate() {
        return memloadRate;
    }

    public void setMemloadDivFac(RichInputText memloadDivFac) {
        this.memloadDivFac = memloadDivFac;
    }

    public RichInputText getMemloadDivFac() {
        return memloadDivFac;
    }

    public void setCovOffered(RichSelectOneChoice covOffered) {
        this.covOffered = covOffered;
    }

    public RichSelectOneChoice getCovOffered() {
        return covOffered;
    }

    public void setMemCoverTypeDisplay(RichOutputText memCoverTypeDisplay) {
        this.memCoverTypeDisplay = memCoverTypeDisplay;
    }

    public RichOutputText getMemCoverTypeDisplay() {
        return memCoverTypeDisplay;
    }

    public void setMemEarningAmt(RichInputText memEarningAmt) {
        this.memEarningAmt = memEarningAmt;
    }

    public RichInputText getMemEarningAmt() {
        return memEarningAmt;
    }

    public void setMemEarningPeriod(RichInputText memEarningPeriod) {
        this.memEarningPeriod = memEarningPeriod;
    }

    public RichInputText getMemEarningPeriod() {
        return memEarningPeriod;
    }

    public void setMemOrigLnAmt(RichInputText memOrigLnAmt) {
        this.memOrigLnAmt = memOrigLnAmt;
    }

    public RichInputText getMemOrigLnAmt() {
        return memOrigLnAmt;
    }

    public void setMemLoanAmt(RichInputText memLoanAmt) {
        this.memLoanAmt = memLoanAmt;
    }

    public RichInputText getMemLoanAmt() {
        return memLoanAmt;
    }

    public void setMemLoanInt(RichInputText memLoanInt) {
        this.memLoanInt = memLoanInt;
    }

    public RichInputText getMemLoanInt() {
        return memLoanInt;
    }

    public void setMemLoanIssDate(RichInputDate memLoanIssDate) {
        this.memLoanIssDate = memLoanIssDate;
    }

    public RichInputDate getMemLoanIssDate() {
        return memLoanIssDate;
    }

    public void setMemSavingAmt(RichInputText memSavingAmt) {
        this.memSavingAmt = memSavingAmt;
    }

    public RichInputText getMemSavingAmt() {
        return memSavingAmt;
    }

    public void pensTypeListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if (pensionType.getValue() == null) {

        } else {
            if (pensionType.getValue().toString().equalsIgnoreCase("DB")) {

                pensEscDisplay.setValue(null);
                pensEscDisplay.setDisabled(false);
                penEarnEsc.setValue(null);
                penEarnEsc.setDisabled(false);

            } else {

                pensEscDisplay.setValue(null);
                pensEscDisplay.setDisabled(true);
                penEarnEsc.setValue(null);
                penEarnEsc.setDisabled(true);

            }

        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(pensEscDisplay);
        AdfFacesContext.getCurrentInstance().addPartialTarget(penEarnEsc);
    }

    public String subCompute() {
        Connection conn = null;
        try {
            conn = new DBConnector().getDatabaseConn();
            String PopulateQuery =
                "BEGIN LMS_WEB_PKG_GRP.compute_dtlgrp_premium(?,?,?);END;";
            String RenewalArea = (String)session.getAttribute("RenewalArea");
            if (RenewalArea == null) {
                PopulateQuery =
                        "BEGIN LMS_WEB_PKG_GRP.compute_dtlgrp_premium(?,?,?);END;";
            } else if (RenewalArea.equalsIgnoreCase("Y")) {
                PopulateQuery =
                        "BEGIN LMS_WEB_PKG_GRP.compute_ren_dtlgrp_premium(?,?,?);END;";
            } else {
                PopulateQuery =
                        "BEGIN LMS_WEB_PKG_GRP.compute_dtlgrp_premium(?,?,?);END;";
            }
            CallableStatement cstmt = null;

            cstmt = conn.prepareCall(PopulateQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("endorsementCode"));
            cstmt.setBigDecimal(2,
                                (BigDecimal)session.getAttribute("transactionNumber"));
            cstmt.setBigDecimal(3, (BigDecimal)session.getAttribute("TaCode"));
            cstmt.execute();
            //cstmt.execute();

            ADFUtils.findIterator("FindEndorsementsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(endrSA2);
            AdfFacesContext.getCurrentInstance().addPartialTarget(premium2);
            AdfFacesContext.getCurrentInstance().addPartialTarget(commAmt2);

            ADFUtils.findIterator("FindPolicyMemberAtCoversIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(policyMembersLOV);

            ADFUtils.findIterator("FindMemberCoverTypesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(policyMemberCoversLOV);
            ADFUtils.findIterator("findMemberPensionDtlsIterator").executeQuery();


            GlobalCC.INFORMATIONREPORTING("Premium Computed Successfully");
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public void setPremium2(RichInputText premium2) {
        this.premium2 = premium2;
    }

    public RichInputText getPremium2() {
        return premium2;
    }

    public void setCommAmt2(RichInputText commAmt2) {
        this.commAmt2 = commAmt2;
    }

    public RichInputText getCommAmt2() {
        return commAmt2;
    }

    public void setOverrideMedicals(RichSelectBooleanCheckbox overrideMedicals) {
        this.overrideMedicals = overrideMedicals;
    }

    public RichSelectBooleanCheckbox getOverrideMedicals() {
        return overrideMedicals;
    }

    public String EffectCoinsurance() {
        Connection conn = null;
        try {
            if (polCoinsuranceBusiness.getValue() == null) {
                GlobalCC.sysInformation("Select A Coinsurance Option.");
                return null;
            } else if (polCoinsuranceBusiness.getValue().toString().equalsIgnoreCase("Y")) {
                if (polCoinLeaderFollower.getValue() == null) {
                    GlobalCC.sysInformation("Select A Leader or Follower Option");
                    return null;
                }
                if (coinLeaderShare.getValue() == null &&
                    polCoinLeaderFollower.getValue().toString().equalsIgnoreCase("F")) {
                    GlobalCC.sysInformation("Enter the Leader Share");
                    return null;
                }
            }

            String coinsuranceQuery =
                "BEGIN LMS_GRP_MISC.mark_policy_coinsurance(?,?,?,?); END;";
            conn = new DBConnector().getDatabaseConn();
            CallableStatement cstmt;

            cstmt = conn.prepareCall(coinsuranceQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("endorsementCode"));
            cstmt.setString(2, polCoinsuranceBusiness.getValue().toString());
            if (polCoinLeaderFollower.getValue() == null) {
                cstmt.setString(3, null);
            } else {
                cstmt.setString(3,
                                polCoinLeaderFollower.getValue().toString());
            }
            if (coinLeaderShare.getValue() == null) {
                cstmt.setString(4, null);
            } else {
                cstmt.setString(4, coinLeaderShare.getValue().toString());
            }
            //cstmt.setBigDecimal(4,new BigDecimal(coinLeaderShare.getValue().toString()));
            cstmt.execute();
            conn.close();
            String Message = "Policy marked as coinsurance Successfully";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
            ADFUtils.findIterator("FindPolicyCoinsurersIterator").executeQuery();
            //AdfFacesContext.getCurrentInstance().addPartialTarget(leaderShare);
            ADFUtils.findIterator("FindPoliciesIterator").executeQuery();
            ADFUtils.findIterator("FindEndorsementsIterator").executeQuery();
            //AdfFacesContext.getCurrentInstance().addPartialTarget(coLeadFollow);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);

        }
        return null;
    }

    public void setPolCoinsuranceBusiness(RichSelectOneChoice polCoinsuranceBusiness) {
        this.polCoinsuranceBusiness = polCoinsuranceBusiness;
    }

    public RichSelectOneChoice getPolCoinsuranceBusiness() {
        return polCoinsuranceBusiness;
    }

    public void setPolCoinLeaderFollower(RichSelectOneChoice polCoinLeaderFollower) {
        this.polCoinLeaderFollower = polCoinLeaderFollower;
    }

    public RichSelectOneChoice getPolCoinLeaderFollower() {
        return polCoinLeaderFollower;
    }

    public void setCoinLeaderShare(RichInputText coinLeaderShare) {
        this.coinLeaderShare = coinLeaderShare;
    }

    public RichInputText getCoinLeaderShare() {
        return coinLeaderShare;
    }

    public String AddCoinsurer() {
        //Render Popup
        ExtendedRenderKitService erkService =
            Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                               ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
                             "var hints = {autodismissNever:false}; " +
                             "AdfPage.PAGE.findComponent('" +
                             "lmsgroup:addCoinsurerPopup" + "').show(hints);");
        return null;
    }

    public void setAddCoinsurerDisplay(RichInputText addCoinsurerDisplay) {
        this.addCoinsurerDisplay = addCoinsurerDisplay;
    }

    public RichInputText getAddCoinsurerDisplay() {
        return addCoinsurerDisplay;
    }

    public void setAvaibaleCoinsurersLOV(RichTable avaibaleCoinsurersLOV) {
        this.avaibaleCoinsurersLOV = avaibaleCoinsurersLOV;
    }

    public RichTable getAvaibaleCoinsurersLOV() {
        return avaibaleCoinsurersLOV;
    }

    public void setSharePercentageDisplay(RichInputText sharePercentageDisplay) {
        this.sharePercentageDisplay = sharePercentageDisplay;
    }

    public RichInputText getSharePercentageDisplay() {
        return sharePercentageDisplay;
    }

    public void setAdminFeeDisplay(RichInputText adminFeeDisplay) {
        this.adminFeeDisplay = adminFeeDisplay;
    }

    public RichInputText getAdminFeeDisplay() {
        return adminFeeDisplay;
    }

    public String GetSelectedCoinsurer() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindCoinsurersIterator");
        RowKeySet set = avaibaleCoinsurersLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();


        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            session.setAttribute("coin_agn_code",
                                 r.getAttribute("CO_agn_code"));
            addCoinsurerDisplay.setValue(r.getAttribute("CO_agn_name"));
            System.out.println("upendo " +
                               (BigDecimal)session.getAttribute("coin_agn_code"));
            //ADFUtils.findIterator("FindRiTrtDetailsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(addCoinsurerDisplay);

            ExtendedRenderKitService erkService =
                Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                   ExtendedRenderKitService.class);
            erkService.addScript(FacesContext.getCurrentInstance(),
                                 "var hints = {autodismissNever:false}; " +
                                 "AdfPage.PAGE.findComponent('" +
                                 "lmsgroup:coinsurersPopup" +
                                 "').hide(hints);");

        }
        return null;
    }

    public String SaveAddedCoinsurer() {
        if (sharePercentageDisplay.getValue() == null) {

            String Message = "Enter a Share Percentage";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
            return null;

        }

        String computeQuery =
            "BEGIN LMS_WEB_PKG_GRP.updatepolicycoinsurers(?,?,?,?,?,?,?);END;";
        Connection conn = new DBConnector().getDatabaseConn();
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall(computeQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("pol_coin_code")); //v_quo_code NUMBER,
            cstmt.setBigDecimal(2,
                                (BigDecimal)session.getAttribute("endorsementCode"));
            cstmt.setBigDecimal(3,
                                (BigDecimal)session.getAttribute("policyCode"));
            cstmt.setBigDecimal(4,
                                (BigDecimal)session.getAttribute("coin_agn_code"));
            cstmt.setString(5, sharePercentageDisplay.getValue().toString());
            if (adminFeeDisplay.getValue() == null) {
                cstmt.setBigDecimal(6, null);
            } else {
                cstmt.setString(6, adminFeeDisplay.getValue().toString());
            }
            if (laFollowerBusiness.getValue() == null) {
                cstmt.setString(7, null);
            } else {
                cstmt.setString(7, laFollowerBusiness.getValue().toString());
            }
            cstmt.execute();
            conn.close();
            String Message = "Coinsurer Saved";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));

            ADFUtils.findIterator("FindPolicyCoinsurersIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(polCoinsurersLOV);

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }


        return null;
    }

    public String ApportionMemberCovers() {
        String effectCoinsuranceQuery =
            "BEGIN LMS_GRP_MISC.effect_coinsurance(?);END;";
        Connection conn = new DBConnector().getDatabaseConn();
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall(effectCoinsuranceQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("endorsementCode"));
            cstmt.execute();
            cstmt.close();
            String Message = "Member Covers Apportioned Successfully";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public String AddNewCoinsurer() {
        session.setAttribute("pol_coin_code", null);
        addCoinsurerDisplay.setValue(null);
        sharePercentageDisplay.setValue(null);
        adminFeeDisplay.setValue(null);
        ExtendedRenderKitService erkService =
            Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                               ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
                             "var hints = {autodismissNever:false}; " +
                             "AdfPage.PAGE.findComponent('" +
                             "lmsgroup:addCoinsurerPopup" + "').show(hints);");
        return null;
    }

    

    public String Addbeneficiary() {
        this.benNames.setValue(null);
        this.benSurname.setValue(null);
        this.benMemNo.setValue(null);
        this.benDOB.setValue(null);
        this.benShare.setValue(null);
        this.benTerShare.setValue(null);
        this.session.setAttribute("action", "A");
        LMSG.view.Base.GlobalCC.showPopup("lmsgroup:beneficiaryPop");
        this.session.setAttribute("pabCode", null);
        return null;
    }

    public String EditBeneficiary() {
        try {
            RowKeySet rowKeySet = this.annDependantsLOV.getSelectedRowKeys();
            if (rowKeySet == null) {
                return null;
            }
            if (!rowKeySet.iterator().hasNext()) {
                LMSG.view.Base.GlobalCC.errorValueNotEntered("No Record Selected");
                return null;
            }
            Object key2 = rowKeySet.iterator().next();
            this.annDependantsLOV.setRowKey(key2);
            JUCtrlValueBinding nodeBinding =
                (JUCtrlValueBinding)this.annDependantsLOV.getRowData();

            if (nodeBinding == null) {
                GlobalCC.errorValueNotEntered("No Record Selected");
                return null;
            }

            GlobalCC.showPopup("lmsgroup:beneficiaryPop");
            this.session.setAttribute("action", "E");

            this.session.setAttribute("pabCode",
                                      nodeBinding.getAttribute("pabNUmber"));

            this.benNames.setValue(nodeBinding.getAttribute("pabOTHERNAMES"));
            this.benSurname.setValue(nodeBinding.getAttribute("pabSURNAME"));
            this.benMemNo.setValue(nodeBinding.getAttribute("pabMemberNumber"));
            this.benDOB.setValue(nodeBinding.getAttribute("pabDOB"));
            this.benShare.setValue(nodeBinding.getAttribute("pabBEN_PCT"));
            this.benTerShare.setValue(nodeBinding.getAttribute("pab_term_ben_pct"));
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String DeleteBeneficiary() {
        try {
            RowKeySet rowKeySet = this.annDependantsLOV.getSelectedRowKeys();
            if (rowKeySet == null) {
                return null;
            }
            if (!rowKeySet.iterator().hasNext()) {
                LMSG.view.Base.GlobalCC.errorValueNotEntered("No Record Selected");
                return null;
            }
            Object key2 = rowKeySet.iterator().next();
            this.annDependantsLOV.setRowKey(key2);
            JUCtrlValueBinding nodeBinding =
                (JUCtrlValueBinding)this.annDependantsLOV.getRowData();

            if (nodeBinding == null) {
                GlobalCC.errorValueNotEntered("No Record Selected");
                return null;
            }

            this.session.setAttribute("action", "D");

            this.session.setAttribute("pabCode",
                                      nodeBinding.getAttribute("pabNUmber"));

            this.benNames.setValue(nodeBinding.getAttribute("pabOTHERNAMES"));
            this.benSurname.setValue(nodeBinding.getAttribute("pabSURNAME"));
            this.benMemNo.setValue(nodeBinding.getAttribute("pabMemberNumber"));
            this.benDOB.setValue(nodeBinding.getAttribute("pabDOB"));
            this.benShare.setValue(nodeBinding.getAttribute("pabBEN_PCT"));
            this.benTerShare.setValue(nodeBinding.getAttribute("pab_term_ben_pct"));

            SaveBeneficiary();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String SaveBeneficiary() {
        Connection conn = null;
        try {
            BigDecimal MemberCode =
                (BigDecimal)this.session.getAttribute("MemberNumber");
            if (MemberCode == null) {
                GlobalCC.errorValueNotEntered("Select A Parent");
                return null;
            }

            DBConnector datahandler = null;
            datahandler = new DBConnector();

            conn = datahandler.getDatabaseConn();

            CallableStatement cst = null;

            String reinQuery =
                "begin LMS_WEB_PKG_GRP_UW.save_beneficiary(?,?,?,?,?,?,?,?,?,?); end;";

            cst = conn.prepareCall(reinQuery);
            cst.setString(1, (String)this.session.getAttribute("action"));
            cst.setBigDecimal(2,
                              (BigDecimal)this.session.getAttribute("pabCode"));
            if (this.benMemNo.getValue() == null)
                cst.setString(3, null);
            else {
                cst.setString(3, this.benMemNo.getValue().toString());
            }
            if (this.benSurname.getValue() == null)
                cst.setString(4, null);
            else {
                cst.setString(4, this.benSurname.getValue().toString());
            }
            if (this.benNames.getValue() == null)
                cst.setString(5, null);
            else {
                cst.setString(5, this.benNames.getValue().toString());
            }
            if (this.benDOB.getValue() == null) {
                cst.setString(6, null);
            } else if (this.benDOB.getValue().toString().contains(":"))
                cst.setString(6,
                              LMSG.view.Base.GlobalCC.parseDate(this.benDOB.getValue().toString()));
            else {
                cst.setString(6,
                              LMSG.view.Base.GlobalCC.upDateParseDate(this.benDOB.getValue().toString()));
            }

            if (this.benShare.getValue() == null)
                cst.setString(7, null);
            else {
                cst.setString(7, this.benShare.getValue().toString());
            }
            if (this.benTerShare.getValue() == null)
                cst.setString(8, null);
            else {
                cst.setString(8, this.benTerShare.getValue().toString());
            }
            cst.setBigDecimal(9,
                              (BigDecimal)this.session.getAttribute("MemberNumber"));
            cst.setBigDecimal(10,
                              (BigDecimal)this.session.getAttribute("endorsementCode"));

            cst.execute();
            cst.close();
            conn.commit();
            conn.close();

            GlobalCC.sysInformation("Record Successfully Saved");
            GlobalCC.hidePopup("lmsgroup:beneficiaryPop");

            ADFUtils.findIterator("FindMembersAnnDependentsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.annDependantsLOV);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }

        return null;
    }

    public String AddStudent() {

        studentNames.setValue(null);
        studentSurname.setValue(null);
        studentMemNo.setValue(null);
        studentDOB.setValue(null);
        studentClass.setValue(null);
        studentSex.setValue(null);
        session.setAttribute("gagnCode", null);

        AdfFacesContext.getCurrentInstance().addPartialTarget(studentClass);
        session.setAttribute("action", "A");
        GlobalCC.showPopup("lmsgroup:studentDetails");
        return null;
    }
    
    /*public void beneficiaryNumberChanged(ValueChangeEvent valueChangeEvent){
          
    }*/

    public String EditStudent() {
        try {
            RowKeySet rowKeySet = studentsLOV.getSelectedRowKeys();
            if (rowKeySet == null) {
                return null;
            }
            if (!rowKeySet.iterator().hasNext()) //no selection
            {
                GlobalCC.errorValueNotEntered("No Record Selected");
                return null;
            }
            Object key2 = rowKeySet.iterator().next();
            studentsLOV.setRowKey(key2);
            JUCtrlValueBinding nodeBinding =
                (JUCtrlValueBinding)studentsLOV.getRowData();
            if (nodeBinding == null) {
                GlobalCC.errorValueNotEntered("No Record Selected");
                return null;
            }
            
            GlobalCC.showPopup("lmsgroup:studentDetails");
            session.setAttribute("action", "E");
            
            session.setAttribute("studentBenCode",
                                 nodeBinding.getAttribute("qmemBenCode"));
            
            studentNames.setValue(nodeBinding.getAttribute("qmemBenOtherNames"));
            studentSurname.setValue(nodeBinding.getAttribute("qmemBenSurname"));
            studentMemNo.setValue(nodeBinding.getAttribute("qmemBenMemNo"));
            session.setAttribute("memNo",nodeBinding.getAttribute("qmemBenMemNo"));
            studentClass.setValue(nodeBinding.getAttribute("qmemBenClass"));
            studentSex.setValue(nodeBinding.getAttribute("qmem_ben_sex"));
            studentSharePct.setValue(nodeBinding.getAttribute("pmem_share_pct"));
            rsaPin.setValue(nodeBinding.getAttribute("pmem_rsa_pin"));
            agencyDesc.setValue(nodeBinding.getAttribute("spr_name"));
            studentDOB.setValue(nodeBinding.getAttribute("pmem_dob"));
            benIdNo.setValue(nodeBinding.getAttribute("pmem_id_no"));
            benRelationType.setValue(nodeBinding.getAttribute("pmem_ret_desc"));
            benComments.setValue(nodeBinding.getAttribute("pmem_comments"));
            session.setAttribute("gagnCode",
                                 nodeBinding.getAttribute("spr_code"));

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String findGovtAgencySelected() {
        try {
            RowKeySet rowKeySet = agencyTable.getSelectedRowKeys();
            if (!rowKeySet.iterator().hasNext()) {
                //GlobalCC.errorValueNotEntered("Error: No Record Selected");
                //return null;
            }

            Object key2 = rowKeySet.iterator().next();
            agencyTable.setRowKey(key2);

            JUCtrlValueBinding r =
                (JUCtrlValueBinding)agencyTable.getRowData();
            if (r == null) {
                //GlobalCC.errorValueNotEntered("Error: No Record Selected");
                //return null;
            }

            session.setAttribute("gagnCode", r.getAttribute("SPR_CODE"));
            agencyDesc.setValue(r.getAttribute("SPR_NAME"));
            AdfFacesContext.getCurrentInstance().addPartialTarget(agencyDesc);

            GlobalCC.hidePopup("lmsgroup:p5");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public void processCSVForBeneficiaries(InputStream csvFile) {
        // Parse the data, using http://ostermiller.org/utils/download.html
        boolean addBatch = false;
        String[][] csvvalues = null;
        BigDecimal RatesTemplate = null;
        try {
            List rows = new ArrayList();
            int numberOfColumns;

            Connection conn;
            conn = new DBConnector().getDatabaseConn();

            CallableStatement cst = null;
            CallableStatement inst = null;
            CallableStatement seq = null;
            String seleSeq = "SELECT LMS_LRID_CODE_SEQ.NEXTVAL FROM DUAL";
            seq = conn.prepareCall(seleSeq);
            ResultSet rs = seq.executeQuery();
            while (rs.next()) {
                RatesTemplate = rs.getBigDecimal(1);
            }
            String insertQuery =
                "INSERT INTO LMS_RATES_IMPORT_TRANS VALUES (?,?,?,?)";
            inst = conn.prepareCall(insertQuery);

            List ReinstInfo = new LinkedList();
            ARRAY array = null;

            ArrayDescriptor descriptor =
                ArrayDescriptor.createDescriptor("LMS_MEMBER_BENEFICIARY_TAB",
                                                 conn);

            cst =
    conn.prepareCall("BEGIN LMS_IMPORT_MEM_DATA.import_beneficiary_data(?,?,?);end;");

            //register out
            csvvalues = CSVParser.parse(new InputStreamReader(csvFile));

            rows = new ArrayList();

            numberOfColumns = 0;

            for (int i = 0; i < csvvalues.length; i++) {
                Map tablerow = new HashMap();
                for (int j = 0; j < csvvalues[i].length; j++) {

                    if (j > numberOfColumns) {
                        numberOfColumns = j;
                    }

                    tablerow.put("cell" + (j + 1), csvvalues[i][j]);
                    if (i == 0) {
                        if (j == 0) {

                            inst.setBigDecimal(1, RatesTemplate);
                            Date now = new Date();
                            inst.setString(2, LOVCC.parseDate(now.toString()));
                            inst.setString(3,
                                           (String)session.getAttribute("Username"));
                            inst.setString(4, null);
                            //inst.setBigDecimal(5,(BigDecimal)session.getAttribute("policyCode"));

                            inst.execute();
                        }
                    }
                    if (i >= 1) {

                        MemberBeneficiaries pn = new MemberBeneficiaries();
                        pn.setLMIB_CODE(null);
                        pn.setLMIB_LMIT_CODE(RatesTemplate);
                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][0]) ==
                            0) { //Member No.
                            pn.setLMIB_MEM_NO(null);
                        } else {
                            pn.setLMIB_MEM_NO((String)csvvalues[i][0]);
                        }
                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][1]) ==
                            0) { //Main Member No.
                            pn.setLMIB_MAIN_MEM_NO(null);
                        } else {
                            pn.setLMIB_MAIN_MEM_NO((String)csvvalues[i][1]);
                        }
                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][2]) ==
                            0) { //Member Surname.
                            pn.setLMIB_MEM_SURNAME(null);
                        } else {
                            pn.setLMIB_MEM_SURNAME((String)csvvalues[i][2]);
                        }
                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][3]) ==
                            0) { //Member Other Names.
                            pn.setLMIB_MEM_OTHERNAMES(null);
                        } else {
                            pn.setLMIB_MEM_OTHERNAMES((String)csvvalues[i][3]);
                        }
                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][4]) ==
                            0) { //Member DOB.
                            pn.setLMIB_MEM_DOB(null);
                        } else {
                            java.sql.Date DOB = null;
                            SimpleDateFormat sdf1 =
                                new SimpleDateFormat("dd-MMM-yyyy");
                            Date DOBUtil = sdf1.parse(csvvalues[i][4]);
                            DOB =
    new java.sql.Date(((java.util.Date)DOBUtil).getTime());
                            pn.setLMIB_MEM_DOB(DOB);
                        }
                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][5]) ==
                            0) { //Member DOB.
                            pn.setLMIB_MEM_SEX(null);
                        } else {
                            pn.setLMIB_MEM_SEX((String)csvvalues[i][5]);
                        }
                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][6]) ==
                            0) { //Member DOB.
                            pn.setLMIB_ID_NO(null);
                        } else {
                            pn.setLMIB_ID_NO((String)csvvalues[i][6]);
                        }
                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][7]) ==
                            0) { //Member DOB.
                            pn.setLMIB_RET_DESC(null);
                        } else {
                            pn.setLMIB_RET_DESC((String)csvvalues[i][7]);
                        }
                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][8]) ==
                            0) { //Member DOB.
                            pn.setLMIB_COMMENTS(null);
                        } else {
                            pn.setLMIB_COMMENTS((String)csvvalues[i][8]);
                        }
                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][9]) ==
                            0) {
                            pn.setLMIB_SHARE(null);
                        } else {
                            pn.setLMIB_SHARE(new BigDecimal(csvvalues[i][9].toString()));
                        }

                        ReinstInfo.add(pn);
                        addBatch = true;

                    }

                    //System.out.println("cell" + (j + 1));
                    //System.out.println(csvvalues[i][j]);
                    // System.out.println("Another");
                    //k++;
                    break;
                } // for cells
                rows.add(tablerow);

            } // for rows

            if (addBatch == true) {
                array = new ARRAY(descriptor, conn, ReinstInfo.toArray());

                cst.setArray(1, array);
                cst.setBigDecimal(2,
                                  (BigDecimal)session.getAttribute("endorsementCode"));
                cst.setBigDecimal(3,
                                  (BigDecimal)session.getAttribute("policyCode"));
                cst.execute();
                cst.close();


                ADFUtils.findIterator("FindMembersBeneficiariesCoversIterator").executeQuery();
                //AdfFacesContext.getCurrentInstance().addPartialTarget(studentsLOV);

                GlobalCC.INFORMATIONREPORTING("Members Successfully Imported.");
            }

            conn.close();

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

    }
    
    public String SaveStudent() {
           Connection conn = null;
           try {
                           
           BigDecimal MemberCode = (BigDecimal)session.getAttribute("MemberNumber");
           if (MemberCode == null) {
               GlobalCC.errorValueNotEntered("Select A Parent");
               return null;
           }
           if(studentNames.getValue() == null){
               GlobalCC.errorValueNotEntered("Enter Beneficiary names");
               return null;
           }
           if(studentSurname.getValue() == null){
               GlobalCC.errorValueNotEntered("Enter Surnames");
               return null;
           }
           if(ben_type.getValue() == null){
               GlobalCC.errorValueNotEntered("Select a beneficiary type");
               return null;
           }
           if(studentMemNo.getValue() == null) {
               GlobalCC.errorValueNotEntered("Provide Beneficiary No");
               return null;
           }
           if(studentDOB.getValue() == null){
               GlobalCC.errorValueNotEntered("Provide Date of birth");
               return null;
           }
           if(studentSex.getValue() == null){
               GlobalCC.errorValueNotEntered("Provide the beneficiary sex");
               return null;
           }
           if(studentSharePct.getValue() == null){
               GlobalCC.errorValueNotEntered("Provide the beneficiary share percent");
               return null;
           }            
           if(benRelationType.getValue() == null) {
               GlobalCC.errorValueNotEntered("Provide Relation Type");
               return null;
           }
    
           DBConnector datahandler = null;
           datahandler = new DBConnector();
    
           conn = datahandler.getDatabaseConn();
    
           CallableStatement cst = null;
    
           String reinQuery =
               "begin LMS_WEB_PKG_GRP_UW.save_student_dtls(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); end;";
    
           cst = conn.prepareCall(reinQuery);
           cst.setString(1, (String)session.getAttribute("action"));
           cst.setBigDecimal(2,
                             (BigDecimal)session.getAttribute("studentBenCode"));
           cst.setBigDecimal(3,
                             (BigDecimal)session.getAttribute("MemberNumber"));
           if (studentSurname.getValue() == null) {
               cst.setString(4, null);
           } else {
               cst.setString(4, studentSurname.getValue().toString());
           }
           if (studentNames.getValue() == null) {
               cst.setString(5, null);
           } else {
               cst.setString(5, studentNames.getValue().toString());
           }
           cst.setBigDecimal(6,
                             (BigDecimal)session.getAttribute("endorsementCode"));
           if (studentSex.getValue() == null) {
               cst.setString(7, null);
           } else {
               cst.setString(7, studentSex.getValue().toString());
           }
           if (studentMemNo.getValue() == null) {
               cst.setString(8, null);
           } else {
               cst.setString(8, studentMemNo.getValue().toString());
           }
           cst.setString(9, (String)session.getAttribute("CategoryShtDesc"));
           if (studentSharePct.getValue() == null) {
               cst.setString(10, null);
           } else {
               cst.setString(10, studentSharePct.getValue().toString());
           }
           cst.setBigDecimal(11,
                             (BigDecimal)session.getAttribute("gagnCode"));
           if (rsaPin.getValue() == null) {
               cst.setString(12, null);
           } else {
               cst.setString(12, rsaPin.getValue().toString());
           }
           if (studentDOB.getValue() == null) {
               cst.setString(13, null);
           } else {
               if (studentDOB.getValue().toString().contains(":")) {
                   cst.setString(13,
                                 GlobalCC.parseDate(studentDOB.getValue().toString()));
               } else {
                   cst.setString(13,
                                 GlobalCC.upDateParseDate(studentDOB.getValue().toString()));
               }
           }
           if (ben_type.getValue() == null) {
               cst.setString(14, null);
           } else {
               cst.setString(14, ben_type.getValue().toString());
           }
           if (benIdNo.getValue() == null) {
               cst.setString(15, null);
    
           } else {
               cst.setString(15, benIdNo.getValue().toString());
           }
           if (benRelationType.getValue() == null) {
               cst.setString(16, null);
           } else {
               cst.setString(16, benRelationType.getValue().toString());
           }
           if (benComments.getValue() == null) {
               cst.setString(17, null);
           } else {
               cst.setString(17, benComments.getValue().toString());
           }
           cst.execute();
           cst.close();
           conn.commit();
           conn.close();
           // session.setAttribute("poridsCode", null);
           // session.setAttribute("pcvtCode", null);
           GlobalCC.sysInformation("Record Successfully Saved");
           GlobalCC.hidePopup("lmsgroup:studentDetails");   
           GlobalCC.hidePopup("lmsgroup:popup4");
               
           System.out.println("Member Edit. Passed member number is "+studentMemNo.getValue());
    
           ADFUtils.findIterator("FindMembersBeneficiariesCoversIterator").executeQuery();           
           AdfFacesContext.getCurrentInstance().addPartialTarget(studentsLOV);
    
       } catch (Exception e) {
           GlobalCC.EXCEPTIONREPORTING(conn, e);
           e.printStackTrace();
       }
    
       return null;
    }
    public String SaveStudentII() {
        Connection conn = null;
        try {
            
            BigDecimal MemberCode =
                (BigDecimal)session.getAttribute("PolmCode");
            if (MemberCode == null) {
                GlobalCC.errorValueNotEntered("Select A Parent");
                return null;
            }
            if(studentNames.getValue() == null){
                GlobalCC.errorValueNotEntered("Enter Beneficiary names");
                return null;
            }
            if(studentSurname.getValue() == null){
                GlobalCC.errorValueNotEntered("Enter Surnames");
                return null;
            }
            if(ben_type.getValue() == null){
                GlobalCC.errorValueNotEntered("Select a beneficiary type");
                return null;
            }
            if(studentMemNo.getValue() == null) {
                GlobalCC.errorValueNotEntered("Provide Beneficiary No");
                return null;
            }
            if(studentDOB.getValue() == null){
                GlobalCC.errorValueNotEntered("Provide Date of birth");
                return null;
            }
            if(studentSex.getValue() == null){
                GlobalCC.errorValueNotEntered("Provide the beneficiary sex");
                return null;
            }
            if(studentSharePct.getValue() == null){
                GlobalCC.errorValueNotEntered("Provide the beneficiary share percent");
                return null;
            }            
            if(benRelationType.getValue() == null) {
                GlobalCC.errorValueNotEntered("Provide Relation Type");
                return null;
            }
            /*
            BigDecimal MemberCode =
                (BigDecimal)session.getAttribute("PolmCode");
            if (MemberCode == null) {
                GlobalCC.errorValueNotEntered("Select A Parent");
                return null;
            }
            */
            
            DBConnector datahandler = null;
            datahandler = new DBConnector();

            conn = datahandler.getDatabaseConn();

            CallableStatement cst = null;

            String reinQuery =
                "begin LMS_WEB_PKG_GRP_UW.save_student_dtls(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); end;";

            cst = conn.prepareCall(reinQuery);
            cst.setString(1, (String)session.getAttribute("action"));
            cst.setBigDecimal(2,
                              (BigDecimal)session.getAttribute("studentBenCode"));
            cst.setBigDecimal(3, (BigDecimal)session.getAttribute("PolmCode"));
            if (studentSurname.getValue() == null) {
                cst.setString(4, null);
            } else {
                cst.setString(4, studentSurname.getValue().toString());
            }
            if (studentNames.getValue() == null) {
                cst.setString(5, null);
            } else {
                cst.setString(5, studentNames.getValue().toString());
            }
            cst.setBigDecimal(6,
                              (BigDecimal)session.getAttribute("endorsementCode"));
            if (studentSex.getValue() == null) {
                cst.setString(7, null);
            } else {
                cst.setString(7, studentSex.getValue().toString());
            }
            if (studentMemNo.getValue() == null) {
                cst.setString(8, null);
            } else {
                cst.setString(8, studentMemNo.getValue().toString());
            }
            cst.setString(9, (String)session.getAttribute("CategoryShtDesc"));
            if (studentSharePct.getValue() == null) {
                cst.setString(10, null);
            } else {
                cst.setString(10, studentSharePct.getValue().toString());
            }
            cst.setBigDecimal(11,
                              (BigDecimal)session.getAttribute("gagnCode"));
            if (rsaPin.getValue() == null) {
                cst.setString(12, null);
            } else {
                cst.setString(12, rsaPin.getValue().toString());
            }
            if (studentDOB.getValue() == null) {
                cst.setString(13, null);
            } else {
                if (studentDOB.getValue().toString().contains(":")) {
                    cst.setString(13,
                                  GlobalCC.parseDate(studentDOB.getValue().toString()));
                } else {
                    cst.setString(13,
                                  GlobalCC.upDateParseDate(studentDOB.getValue().toString()));
                }
            }
            if (ben_type.getValue() == null) {
                cst.setString(14, null);
            } else {
                cst.setString(14, ben_type.getValue().toString());
            }
            if (benIdNo.getValue() == null) {
                cst.setString(15, null);

            } else {
                cst.setString(15, benIdNo.getValue().toString());
            }
            if (benRelationType.getValue() == null) {
                cst.setString(16, null);
            } else {
                cst.setString(16, benRelationType.getValue().toString());
            }
            if (benComments.getValue() == null) {
                cst.setString(17, null);
            } else {
                cst.setString(17, benComments.getValue().toString());
            }
            cst.execute();
            cst.close();
            conn.commit();
            conn.close();
            // session.setAttribute("poridsCode", null);
            // session.setAttribute("pcvtCode", null);
            GlobalCC.sysInformation("Record Successfully Saved");
            GlobalCC.hidePopup("lmsgroup:studentDetails");

            ADFUtils.findIterator("FindMembersBeneficiariesCoversIIIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(studentsLOV);

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }

        return null;
    }

    public String DeleteStudent() {
        Connection conn = null;
        try {
            RowKeySet rowKeySet = studentsLOV.getSelectedRowKeys();
            if (rowKeySet == null) {
                return null;
            }
            if (!rowKeySet.iterator().hasNext()) //no selection
            {
                GlobalCC.errorValueNotEntered("No Record Selected");
                return null;
            }
            Object key2 = rowKeySet.iterator().next();
            studentsLOV.setRowKey(key2);
            JUCtrlValueBinding r =
                (JUCtrlValueBinding)studentsLOV.getRowData();
            if (r == null) {
                GlobalCC.errorValueNotEntered("No Record Selected");
                return null;
            }
            session.setAttribute("action", "D");
            DBConnector datahandler = null;
            datahandler = new DBConnector();

            conn = datahandler.getDatabaseConn();
            CallableStatement cst = null;

            String reinQuery =
                "begin LMS_WEB_PKG_GRP_UW.save_student_dtls(?,?,?,?,?,?,?,?,?); end;";

            cst = conn.prepareCall(reinQuery);
            cst.setString(1, (String)session.getAttribute("action"));
            cst.setBigDecimal(2, (BigDecimal)r.getAttribute("qmemBenCode"));
            cst.setBigDecimal(3,
                              (BigDecimal)session.getAttribute("MemberNumber"));
            if (studentSurname.getValue() == null) {
                cst.setString(4, null);
            } else {
                cst.setString(4, studentSurname.getValue().toString());
            }
            if (studentNames.getValue() == null) {
                cst.setString(5, null);
            } else {
                cst.setString(5, studentNames.getValue().toString());
            }
            cst.setBigDecimal(6,
                              (BigDecimal)session.getAttribute("endorsementCode"));
            if (studentSex.getValue() == null) {
                cst.setString(7, null);
            } else {
                cst.setString(7, studentSex.getValue().toString());
            }
            if (studentMemNo.getValue() == null) {
                cst.setString(8, null);
            } else {
                cst.setString(8, studentMemNo.getValue().toString());
            }
            cst.setString(9, (String)session.getAttribute("CategoryShtDesc"));

            cst.execute();
            cst.close();
            conn.commit();
            conn.close();

            ADFUtils.findIterator("FindMembersBeneficiariesCoversIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(studentsLOV);
            
            String Message = "Beneficiary Deleted.";
            FacesContext.getCurrentInstance().addMessage(null, 
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                          Message, 
                                                                          Message));
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }
    
    public String DeleteStudentII() {
        Connection conn = null;
        try {
            RowKeySet rowKeySet = studentsLOV.getSelectedRowKeys();
            if (rowKeySet == null) {
                return null;
            }
            if (!rowKeySet.iterator().hasNext()) //no selection
            {
                GlobalCC.errorValueNotEntered("No Record Selected");
                return null;
            }
            Object key2 = rowKeySet.iterator().next();
            studentsLOV.setRowKey(key2);
            JUCtrlValueBinding r =
                (JUCtrlValueBinding)studentsLOV.getRowData();
            if (r == null) {
                GlobalCC.errorValueNotEntered("No Record Selected");
                return null;
            }
            session.setAttribute("action", "D");
            DBConnector datahandler = null;
            datahandler = new DBConnector();

            conn = datahandler.getDatabaseConn();
            CallableStatement cst = null;

            String reinQuery =
                "begin LMS_WEB_PKG_GRP_UW.save_student_dtls(?,?,?,?,?,?,?,?,?); end;";

            cst = conn.prepareCall(reinQuery);
            cst.setString(1, (String)session.getAttribute("action"));
            cst.setBigDecimal(2, (BigDecimal)r.getAttribute("qmemBenCode"));
            cst.setBigDecimal(3,
                              (BigDecimal)session.getAttribute("MemberNumber"));
            if (studentSurname.getValue() == null) {
                cst.setString(4, null);
            } else {
                cst.setString(4, studentSurname.getValue().toString());
            }
            if (studentNames.getValue() == null) {
                cst.setString(5, null);
            } else {
                cst.setString(5, studentNames.getValue().toString());
            }
            cst.setBigDecimal(6,
                              (BigDecimal)session.getAttribute("endorsementCode"));
            if (studentSex.getValue() == null) {
                cst.setString(7, null);
            } else {
                cst.setString(7, studentSex.getValue().toString());
            }
            if (studentMemNo.getValue() == null) {
                cst.setString(8, null);
            } else {
                cst.setString(8, studentMemNo.getValue().toString());
            }
            cst.setString(9, (String)session.getAttribute("CategoryShtDesc"));

            cst.execute();
            cst.close();
            conn.commit();
            conn.close();

            ADFUtils.findIterator("FindMembersBeneficiariesCoversIIIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(studentsLOV);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }
    

    public void ShowRatePopup(ValueChangeEvent valueChangeEvent) {
        if (unitRateOption.getValue() == null) {

        } else {
            if (unitRateOption.getValue().toString().equalsIgnoreCase("RATE")) {
                unitRate.setValue(null);
                ExtendedRenderKitService erkService =
                    Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                       ExtendedRenderKitService.class);
                erkService.addScript(FacesContext.getCurrentInstance(),
                                     "var hints = {autodismissNever:false}; " +
                                     "AdfPage.PAGE.findComponent('" +
                                     "lmsgroup:unitRatePopup" +
                                     "').show(hints);");
            }
        }
    }

    public void setUnitRate(RichInputText unitRate) {
        this.unitRate = unitRate;
    }

    public RichInputText getUnitRate() {
        return unitRate;
    }

    public String SaveUnitRate() {
        if (unitRate.getValue() == null) {
            String Message = "Enter Unit Rate";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
            return null;
        }
        if (unitRateDivFactor.getValue() == null) {
            String Message = "Select Unit Rate Division Factor";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
            return null;
        }
        String effectCoinsuranceQuery =
            "BEGIN LMS_GRP_WEB_PKG.updateUnitRate(?,?,?);END;";
        Connection conn = new DBConnector().getDatabaseConn();
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall(effectCoinsuranceQuery);
            cstmt.setString(1, unitRate.getValue().toString());
            cstmt.setBigDecimal(2,
                                (BigDecimal)session.getAttribute("endorsementCode"));
            cstmt.setString(3, unitRateDivFactor.getValue().toString());
            cstmt.execute();
            cstmt.close();

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public void setUnitRateDivFactor(RichSelectOneChoice unitRateDivFactor) {
        this.unitRateDivFactor = unitRateDivFactor;
    }

    public RichSelectOneChoice getUnitRateDivFactor() {
        return unitRateDivFactor;
    }

    public void setFollowerLeaderBusiness(RichSelectOneChoice followerLeaderBusiness) {
        this.followerLeaderBusiness = followerLeaderBusiness;
    }

    public RichSelectOneChoice getFollowerLeaderBusiness() {
        return followerLeaderBusiness;
    }

    public void coinsFollowerBusiness(ValueChangeEvent valueChangeEvent) {
        if (coLeadFollow.getValue() != null) {
            if (coLeadFollow.getValue().toString().equalsIgnoreCase("L")) {
                session.setAttribute("FollowerBusiness", "L");
                premProvCbox.setRendered(false);
                premProvLabel.setRendered(false);
                premProvCbox.setSelected(false);
                ldrCombined.setRendered(true);
                ldrCombinedLabel.setRendered(true);
            } else {
                session.setAttribute("FollowerBusiness", "F");
                premProvCbox.setRendered(true);
                premProvLabel.setRendered(true);
                premProvCbox.setSelected(false);
                ldrCombined.setRendered(false);
                ldrCombinedLabel.setRendered(false);
            }
        }
    }


    public void setFollowBusinessLabel(RichOutputLabel followBusinessLabel) {
        this.followBusinessLabel = followBusinessLabel;
    }

    public RichOutputLabel getFollowBusinessLabel() {
        return followBusinessLabel;
    }

    public void setLaFollowerBusiness(RichSelectOneChoice laFollowerBusiness) {
        this.laFollowerBusiness = laFollowerBusiness;
    }

    public RichSelectOneChoice getLaFollowerBusiness() {
        return laFollowerBusiness;
    }

    public void setAnnuityPymtStructure(RichSelectOneChoice annuityPymtStructure) {
        this.annuityPymtStructure = annuityPymtStructure;
    }

    public RichSelectOneChoice getAnnuityPymtStructure() {
        return annuityPymtStructure;
    }

    public void setAnnEscalation(RichSelectOneChoice annEscalation) {
        this.annEscalation = annEscalation;
    }

    public RichSelectOneChoice getAnnEscalation() {
        return annEscalation;
    }

    public void setAnnOption(RichSelectOneChoice annOption) {
        this.annOption = annOption;
    }

    public RichSelectOneChoice getAnnOption() {
        return annOption;
    }

    public void setAnnuityAmount(RichInputText annuityAmount) {
        this.annuityAmount = annuityAmount;
    }

    public RichInputText getAnnuityAmount() {
        return annuityAmount;
    }

    public void setPastLiability(RichInputText pastLiability) {
        this.pastLiability = pastLiability;
    }

    public RichInputText getPastLiability() {
        return pastLiability;
    }

    public void setFutureLiability(RichInputText futureLiability) {
        this.futureLiability = futureLiability;
    }

    public RichInputText getFutureLiability() {
        return futureLiability;
    }

    public void setTotalLiability(RichInputText totalLiability) {
        this.totalLiability = totalLiability;
    }

    public RichInputText getTotalLiability() {
        return totalLiability;
    }

    public void setCategoryTree(RichTree categoryTree) {
        this.categoryTree = categoryTree;
    }

    public RichTree getCategoryTree() {
        return categoryTree;
    }

    public void setDurationTermType(RichSelectOneChoice durationTermType) {
        this.durationTermType = durationTermType;
    }

    public RichSelectOneChoice getDurationTermType() {
        return durationTermType;
    }

    public void setSchoolFeesTab(RichPanelBox schoolFeesTab) {
        this.schoolFeesTab = schoolFeesTab;
    }

    public RichPanelBox getSchoolFeesTab() {
        return schoolFeesTab;
    }

    public void setClassTermLimitsLOV(RichTable classTermLimitsLOV) {
        this.classTermLimitsLOV = classTermLimitsLOV;
    }

    public RichTable getClassTermLimitsLOV() {
        return classTermLimitsLOV;
    }

    public void setClassTermDisplay(RichInputText classTermDisplay) {
        this.classTermDisplay = classTermDisplay;
    }

    public RichInputText getClassTermDisplay() {
        return classTermDisplay;
    }

    public void setTermFeeDisplay(RichInputText termFeeDisplay) {
        this.termFeeDisplay = termFeeDisplay;
    }

    public RichInputText getTermFeeDisplay() {
        return termFeeDisplay;
    }

    public void setClassesCategoriesLOV(RichTable classesCategoriesLOV) {
        this.classesCategoriesLOV = classesCategoriesLOV;
    }

    public RichTable getClassesCategoriesLOV() {
        return classesCategoriesLOV;
    }

    public void setProductProvisionsLOV(RichTable productProvisionsLOV) {
        this.productProvisionsLOV = productProvisionsLOV;
    }

    public RichTable getProductProvisionsLOV() {
        return productProvisionsLOV;
    }

    public void setProvisionsCbox(RichSelectBooleanCheckbox provisionsCbox) {
        this.provisionsCbox = provisionsCbox;
    }

    public RichSelectBooleanCheckbox getProvisionsCbox() {
        return provisionsCbox;
    }

    public void ProvisionsListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        String Old = null;
        String New = null;
        Boolean SelectValue;

        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findProductProvisionsIterator");
            RowKeySet set = productProvisionsLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));


                Row r = dciter.getCurrentRow();
                SelectValue = (Boolean)r.getAttribute("selected");
                if (SelectValue == false) {
                    r.setAttribute("selected", true);
                } else {
                    r.setAttribute("selected", false);
                }
                Old = valueChangeEvent.getOldValue().toString();
                New = valueChangeEvent.getNewValue().toString();
            }

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
    }

    public String SavePolicyProvisions() {
        try {
            Boolean Accept;

            String query =
                "begin LMS_WEB_PKG_GRP.updatePolicyProvisions(?,?,?,?,?,?); end;";

            DBConnector datahandler = new DBConnector();
            Connection conn;
            conn = datahandler.getDatabaseConn();

            CallableStatement cst = null;
            cst = conn.prepareCall(query);

            DCIteratorBinding dciter =
                ADFUtils.findIterator("findProductProvisionsIterator");
            int rowCount = productProvisionsLOV.getRowCount();
            for (int i = 0; i < rowCount; i++) {
                productProvisionsLOV.setRowIndex(i);
                List l = (List)productProvisionsLOV.getRowKey();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();
                Accept = (Boolean)r.getAttribute("selected");
                if (Accept == true) {

                    cst.setBigDecimal(1, null);
                    cst.setBigDecimal(2,
                                      (BigDecimal)session.getAttribute("endorsementCode"));
                    cst.setString(3, (String)r.getAttribute("PROV_DESC"));
                    cst.setBigDecimal(4,
                                      (BigDecimal)r.getAttribute("PPROV_CODE"));
                    cst.setString(5, (String)r.getAttribute("PROV_SHT_DESC"));
                    cst.setString(6, (String)r.getAttribute("PPROV_EDITABLE"));

                    cst.execute();
                } else {
                    //do nothing.
                }


            }
            ADFUtils.findIterator("FindPolicyProvisionsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(policyProvisionsTable);
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return null;
    }

    public String DeletePolicyProvision() {
        try {
            BigDecimal SelectValue = null;

            String query =
                "begin LMS_WEB_PKG_GRP.delete_policy_provisions(?); end;";

            DBConnector datahandler = new DBConnector();
            Connection conn;
            conn = datahandler.getDatabaseConn();

            CallableStatement cst = null;
            cst = conn.prepareCall(query);

            DCIteratorBinding dciter =
                ADFUtils.findIterator("FindPolicyProvisionsIterator");
            RowKeySet set = policyProvisionsTable.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));


                Row r = dciter.getCurrentRow();
                SelectValue = (BigDecimal)r.getAttribute("polpCode");
                cst.setBigDecimal(1, SelectValue);
                cst.execute();

            }
            ADFUtils.findIterator("FindPolicyProvisionsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(policyProvisionsTable);
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public void setPolicyProvisionsTable(RichTable policyProvisionsTable) {
        this.policyProvisionsTable = policyProvisionsTable;
    }

    public RichTable getPolicyProvisionsTable() {
        return policyProvisionsTable;
    }

    public void setClassesLOV(RichTable classesLOV) {
        this.classesLOV = classesLOV;
    }

    public RichTable getClassesLOV() {
        return classesLOV;
    }

    public void setFucPlacement(RichTable fucPlacement) {
        this.fucPlacement = fucPlacement;
    }

    public RichTable getFucPlacement() {
        return fucPlacement;
    }

    public void setReinCompaniesTab(RichTable reinCompaniesTab) {
        this.reinCompaniesTab = reinCompaniesTab;
    }

    public RichTable getReinCompaniesTab() {
        return reinCompaniesTab;
    }

    public void setFacCode(RichInputNumberSpinbox facCode) {
        this.facCode = facCode;
    }

    public RichInputNumberSpinbox getFacCode() {
        return facCode;
    }

    public void setFacAgnCode(RichInputNumberSpinbox facAgnCode) {
        this.facAgnCode = facAgnCode;
    }

    public RichInputNumberSpinbox getFacAgnCode() {
        return facAgnCode;
    }

    public void setFacAgnName(RichInputText facAgnName) {
        this.facAgnName = facAgnName;
    }

    public RichInputText getFacAgnName() {
        return facAgnName;
    }

    public void setFacRateAmt(RichSelectOneChoice facRateAmt) {
        this.facRateAmt = facRateAmt;
    }

    public RichSelectOneChoice getFacRateAmt() {
        return facRateAmt;
    }

    public void setFacAmntLabel(RichOutputLabel facAmntLabel) {
        this.facAmntLabel = facAmntLabel;
    }

    public RichOutputLabel getFacAmntLabel() {
        return facAmntLabel;
    }

    public void setFacAmount(RichInputNumberSpinbox facAmount) {
        this.facAmount = facAmount;
    }

    public RichInputNumberSpinbox getFacAmount() {
        return facAmount;
    }

    public void setFacRatetLabel(RichOutputLabel facRatetLabel) {
        this.facRatetLabel = facRatetLabel;
    }

    public RichOutputLabel getFacRatetLabel() {
        return facRatetLabel;
    }

    public void setFacRate(RichInputNumberSpinbox facRate) {
        this.facRate = facRate;
    }

    public RichInputNumberSpinbox getFacRate() {
        return facRate;
    }

    public void setFacPremRate(RichInputNumberSpinbox facPremRate) {
        this.facPremRate = facPremRate;
    }
    public RichInputText getInputRate() {
        return inputRate;
    }

    public void setInputRate(RichInputText inputRate) {
        this.inputRate = inputRate;
    }

    public RichInputNumberSpinbox getFacPremRate() {
        return facPremRate;
    }

    public void setFacDivFactor(RichInputNumberSpinbox facDivFactor) {
        this.facDivFactor = facDivFactor;
    }

    public RichInputNumberSpinbox getFacDivFactor() {
        return facDivFactor;
    }

    public void setFacCommRate(RichInputNumberSpinbox facCommRate) {
        this.facCommRate = facCommRate;
    }

    public RichInputNumberSpinbox getFacCommRate() {
        return facCommRate;
    }

    public void setFacPlacDetails(RichPanelGroupLayout facPlacDetails) {
        this.facPlacDetails = facPlacDetails;
    }

    public RichPanelGroupLayout getFacPlacDetails() {
        return facPlacDetails;
    }

    public void setFacTab(RichShowDetailItem facTab) {
        this.facTab = facTab;
    }

    public RichShowDetailItem getFacTab() {
        return facTab;
    }

    public void setCoverDescLabel(RichOutputText coverDescLabel) {
        this.coverDescLabel = coverDescLabel;
    }

    public RichOutputText getCoverDescLabel() {
        return coverDescLabel;
    }

    public void setTotalSALabel(RichOutputText totalSALabel) {
        this.totalSALabel = totalSALabel;
    }

    public RichOutputText getTotalSALabel() {
        return totalSALabel;
    }

    public void setGrossRetLabel(RichOutputText grossRetLabel) {
        this.grossRetLabel = grossRetLabel;
    }

    public RichOutputText getGrossRetLabel() {
        return grossRetLabel;
    }

    public void setExcessAmount(RichInputNumberSpinbox excessAmount) {
        this.excessAmount = excessAmount;
    }

    public RichInputNumberSpinbox getExcessAmount() {
        return excessAmount;
    }

    public void setStudentNames(RichInputText studentNames) {
        this.studentNames = studentNames;
    }

    public RichInputText getStudentNames() {
        return studentNames;
    }

    public void setStudentSurname(RichInputText studentSurname) {
        this.studentSurname = studentSurname;
    }

    public RichInputText getStudentSurname() {
        return studentSurname;
    }

    public void setStudentMemNo(RichInputText studentMemNo) {
        this.studentMemNo = studentMemNo;
    }

    public RichInputText getStudentMemNo() {
        return studentMemNo;
    }

    public void setStudentDOB(RichInputDate studentDOB) {
        this.studentDOB = studentDOB;
    }

    public RichInputDate getStudentDOB() {
        return studentDOB;
    }

    public void setStudentClass(RichSelectOneChoice studentClass) {
        this.studentClass = studentClass;
    }

    public RichSelectOneChoice getStudentClass() {
        return studentClass;
    }

    public void setStudentSex(RichSelectOneChoice studentSex) {
        this.studentSex = studentSex;
    }

    public RichSelectOneChoice getStudentSex() {
        return studentSex;
    }


    public void setFacultativeCbox(RichSelectBooleanCheckbox facultativeCbox) {
        this.facultativeCbox = facultativeCbox;
    }

    public RichSelectBooleanCheckbox getFacultativeCbox() {
        return facultativeCbox;
    }

    public void setSchemeFacTab(RichShowDetailItem schemeFacTab) {
        this.schemeFacTab = schemeFacTab;
    }

    public RichShowDetailItem getSchemeFacTab() {
        return schemeFacTab;
    }

    public void setSchemefucPrcpts(RichTable schemefucPrcpts) {
        this.schemefucPrcpts = schemefucPrcpts;
    }

    public RichTable getSchemefucPrcpts() {
        return schemefucPrcpts;
    }

    public void setArrangementButton(RichCommandButton arrangementButton) {
        this.arrangementButton = arrangementButton;
    }

    public RichCommandButton getArrangementButton() {
        return arrangementButton;
    }

    public void setTotalSA(RichInputText totalSA) {
        this.totalSA = totalSA;
    }

    public RichInputText getTotalSA() {
        return totalSA;
    }

    public void setTotRet(RichInputText totRet) {
        this.totRet = totRet;
    }

    public RichInputText getTotRet() {
        return totRet;
    }

    public void setTotExcess(RichInputText totExcess) {
        this.totExcess = totExcess;
    }

    public RichInputText getTotExcess() {
        return totExcess;
    }

    public void setRateType(RichSelectOneChoice rateType) {
        this.rateType = rateType;
    }

    public RichSelectOneChoice getRateType() {
        return rateType;
    }

    public void setAnnDependantsLOV(RichTable annDependantsLOV) {
        this.annDependantsLOV = annDependantsLOV;
    }

    public RichTable getAnnDependantsLOV() {
        return annDependantsLOV;
    }

    public void setReuseCbox(RichSelectBooleanCheckbox reuseCbox) {
        this.reuseCbox = reuseCbox;
    }

    public RichSelectBooleanCheckbox getReuseCbox() {
        return reuseCbox;
    }

    public void setReuseDesc(RichInputText reuseDesc) {
        this.reuseDesc = reuseDesc;
    }

    public RichInputText getReuseDesc() {
        return reuseDesc;
    }

    public void setReuseTable(RichTable reuseTable) {
        this.reuseTable = reuseTable;
    }

    public RichTable getReuseTable() {
        return reuseTable;
    }

    public void setReusePanel(HtmlPanelGrid reusePanel) {
        this.reusePanel = reusePanel;
    }

    public HtmlPanelGrid getReusePanel() {
        return reusePanel;
    }

    public void coverDetailsListener(DisclosureEvent disclosureEvent) {
        // Add event code here...
        try {
            // srchMemNo.setValue(null);
            // srchMemName.setValue(null);
            session.setAttribute("covdetails","Y");
            session.setAttribute("srchMemName", null);
            session.setAttribute("srchMemNo", null);
            GlobalCC.RedirectPage("/coverdtls.jspx");
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(null, ex);
            ex.printStackTrace();
        }
    }

    public void reinsuranceListener(DisclosureEvent disclosureEvent) {
        // Add event code here...
        try {
            String AllowReinMask = "N";
            //Confirm User has Access To Reinsurance..
            String query =
                "begin ?:= TQC_INTERFACES_PKG.check_user_rights(?,?,?,?,?); end;";

            DBConnector datahandler = new DBConnector();
            Connection conn;
            conn = datahandler.getDatabaseConn();

            CallableStatement cst = null;
            cst = conn.prepareCall(query);
            cst.registerOutParameter(1, OracleTypes.VARCHAR);
            cst.setString(2, (String)session.getAttribute("Username"));
            cst.setInt(3, 27);
            cst.setString(4, "UWRI");
            cst.setString(5, "ACCS");
            cst.setString(6, "ACCS");
            cst.execute();

            String Access = cst.getString(1);
            if (Access.equalsIgnoreCase("N")) {
                GlobalCC.INFORMATIONREPORTING("You do not have Right to Access the Reinsurance Module");
                return;
            }

            cst.registerOutParameter(1, OracleTypes.VARCHAR);
            cst.setString(2, (String)session.getAttribute("Username"));
            cst.setInt(3, 27);
            cst.setString(4, "UWRI");
            cst.setString(5, "RIUW");
            cst.setString(6, "RIUWP");
            cst.execute();

            session.setAttribute("RIProcessing", cst.getString(1));
            cst.close();

            String paramQuery =
                "BEGIN LMS_ORD_MISC.system_param_val(?,?);END;";
            CallableStatement cstParam = conn.prepareCall(paramQuery);
            cstParam.setString(1, "ALLOW_DIFF_MASK_FOR_REINSURANCE");
            cstParam.registerOutParameter(2, OracleTypes.VARCHAR);
            cstParam.execute();
            AllowReinMask = (String)cstParam.getObject(2);
            if (AllowReinMask == null) {
                session.setAttribute("AllowReinMask", "N");
            } else {
                session.setAttribute("AllowReinMask", cstParam.getString(2));
            }


            conn.close();

            //LOVCC.MemberNumber = null;
            session.setAttribute("MemberNumber", null);
            session.setAttribute("PMRID_CODE", null);
            session.setAttribute("pmritd_code", null);

            String Value = postUnderwritingReinsurance();
            if (Value == null) {
                Value = "N";
            }

            session.setAttribute("RIAfterAuth", Value);


            //ADFUtils.findIterator("FindRiDetailsIterator").executeQuery();
            //ADFUtils.findIterator("FindRiTrtDetailsIterator").executeQuery();
            GlobalCC.RedirectPage("/g_reinpl.jspx");
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(null, ex);
        }
    }

    public void setAnnPymtStructure(RichSelectOneChoice annPymtStructure) {
        this.annPymtStructure = annPymtStructure;
    }

    public RichSelectOneChoice getAnnPymtStructure() {
        return annPymtStructure;
    }

    public void setBenInvestRate(RichInputText benInvestRate) {
        this.benInvestRate = benInvestRate;
    }

    public RichInputText getBenInvestRate() {
        return benInvestRate;
    }

    public void setTermPayoutRate(RichInputText termPayoutRate) {
        this.termPayoutRate = termPayoutRate;
    }

    public RichInputText getTermPayoutRate() {
        return termPayoutRate;
    }

    public void setAnnAdminCharge(RichInputText annAdminCharge) {
        this.annAdminCharge = annAdminCharge;
    }

    public RichInputText getAnnAdminCharge() {
        return annAdminCharge;
    }

    public void setSchemeLegalAge(RichInputText schemeLegalAge) {
        this.schemeLegalAge = schemeLegalAge;
    }

    public RichInputText getSchemeLegalAge() {
        return schemeLegalAge;
    }

    public void setMainCoverLabel(RichOutputLabel mainCoverLabel) {
        this.mainCoverLabel = mainCoverLabel;
    }

    public RichOutputLabel getMainCoverLabel() {
        return mainCoverLabel;
    }

    public void setMainCover(RichSelectOneChoice mainCover) {
        this.mainCover = mainCover;
    }

    public RichSelectOneChoice getMainCover() {
        return mainCover;
    }

    public void setPercMainCvtLabel(RichOutputLabel percMainCvtLabel) {
        this.percMainCvtLabel = percMainCvtLabel;
    }

    public RichOutputLabel getPercMainCvtLabel() {
        return percMainCvtLabel;
    }

    public void setPercMainCvt(RichInputText percMainCvt) {
        this.percMainCvt = percMainCvt;
    }

    public RichInputText getPercMainCvt() {
        return percMainCvt;
    }

    public String AddProductCoverType() {

        productCoverDropBox.setDisabled(false);
        productCoverDropBox.setValue(null);
        session.setAttribute("PCT_CODE", null);
        session.setAttribute("CVT_CODE", null);
        session.setAttribute("pcvtCode", null);
        loadingTypeSelect.setValue("N");
        discLoadRateDisplay.setValue(null);
        divFactor.setValue(null);
        discChoice.setValue("N");
        discRateDisplay.setValue(null);
        discDivFactor.setValue(null);

        session.setAttribute("coverMaskCode",
                             session.getAttribute("pmasCode"));
        rateSelection.setValue("M");
        maskDesc.setValue(session.getAttribute("pmasShtDesc"));
        maskButton.setDisabled(true);
        coverRate.setDisabled(true);
        coverRate.setValue(null);
        coverRateDivFactor.setDisabled(true);
        coverRateDivFactor.setValue(null);

        GlobalCC.showPopup("lmsgroup:polcvrdtls");
        return null;
    }

    public void ProductCoverTypeListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...

        if (valueChangeEvent.getNewValue() != null) {

            if (valueChangeEvent.getOldValue() !=
                valueChangeEvent.getNewValue()) {
                DCIteratorBinding dciter =
                    ADFUtils.findIterator("FindProductCoversIterator");
                Row r =
                    dciter.getRowAtRangeIndex((Integer)valueChangeEvent.getNewValue());

                populatePremMasks((BigDecimal)r.getAttribute("pct_code"),
                                  (BigDecimal)r.getAttribute("cvt_code"));
                if (productCoverDropBox.getValue() != null) {


                    session.setAttribute("PCT_CODE",
                                         r.getAttribute("pct_code"));
                    session.setAttribute("CVT_CODE",
                                         r.getAttribute("cvt_code"));

                    LOVCC.RefundFormular =
                            (String)r.getAttribute("pct_refund_formular");
                    LOVCC.CoverFormular =
                            (String)r.getAttribute("pct_formular");
                    coverDescDisplay.setValue(r.getAttribute("cvt_desc"));

                    session.setAttribute("pcvtCode", null);

                    overridePremDisplay.setValue(null);
                    sumAssuredDisplay.setValue(null);
                    discLoadRateDisplay.setValue(null);
                    loadingTypeSelect.setValue("N");
                    avANB.setValue(null);

                    String CmainCover =
                        (String)r.getAttribute("cvt_main_cover");
                    if (CmainCover == null) {
                        percMainCvtLabel.setRendered(false);
                        percMainCvt.setRendered(false);
                        mainCoverLabel.setRendered(false);
                        mainCover.setRendered(false);
                        percMainCvt.setValue(null);
                        mainCover.setValue(null);
                    } else if (CmainCover.equalsIgnoreCase("M")) {
                        percMainCvtLabel.setRendered(false);
                        percMainCvt.setRendered(false);
                        mainCoverLabel.setRendered(false);
                        mainCover.setRendered(false);
                        percMainCvt.setValue(null);
                        mainCover.setValue(null);
                    } else if (CmainCover.equalsIgnoreCase("R")) {
                        percMainCvtLabel.setRendered(false);
                        percMainCvt.setRendered(false);
                        mainCoverLabel.setRendered(false);
                        mainCover.setRendered(false);
                        percMainCvt.setValue(null);
                        mainCover.setValue(r.getAttribute("cvt_main_cover"));
                    } else {
                        if (CmainCover.equalsIgnoreCase("RL")) {
                            percMainCvtLabel.setValue("Multiple of Loan Repayment");
                        } else {
                            percMainCvtLabel.setValue("% of  Main/Yr Earn");
                        }
                        percMainCvtLabel.setRendered(true);
                        percMainCvt.setRendered(true);
                        mainCoverLabel.setRendered(true);
                        mainCover.setRendered(true);
                        percMainCvt.setValue(r.getAttribute("pct_main_sa_perc"));
                        mainCover.setValue(r.getAttribute("cvt_main_cover"));
                    }
                   this.builtin.setValue(r.getAttribute("pctInbuilt"));
                   this.accelerator.setValue(r.getAttribute("pctAccelerator"));
                  
                    AdfFacesContext.getCurrentInstance().addPartialTarget(coverDescDisplay);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(sumAssuredDisplay);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(overridePremDisplay);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(discLoadRateDisplay);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(loadingTypeSelect);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(mainCover);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(builtin);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(mainCover);
                }

            }
        }
    }

    public void populatePremMasks(BigDecimal pctCode, BigDecimal cvtCode) {
        Connection conn = null;
        try {
            conn = new DBConnector().getDatabaseConn();

            String query =
                "begin LMS_WEB_PKG_GRP.getDefaultMask(?,?,?,?,?); end;";

            CallableStatement cstmt = conn.prepareCall(query);
            cstmt.setBigDecimal(1, cvtCode);
            cstmt.setBigDecimal(2, pctCode);
            cstmt.registerOutParameter(3, oracle.jdbc.OracleTypes.NUMBER);
            cstmt.registerOutParameter(4, oracle.jdbc.OracleTypes.VARCHAR);
            cstmt.registerOutParameter(5, oracle.jdbc.OracleTypes.VARCHAR);
            cstmt.execute();

            if (cstmt.getBigDecimal(3) != null) {
                this.session.setAttribute("pmasCode", cstmt.getBigDecimal(3));
                session.setAttribute("coverMaskCode", cstmt.getBigDecimal(3));
            }
            if (cstmt.getString(4) != null) {
                this.session.setAttribute("pmasShtDesc", cstmt.getString(4));
                maskDisplay.setValue(cstmt.getString(4));
                maskDesc.setValue(cstmt.getString(4));
            }
            if (cstmt.getString(5) != null) {
                rateSelection.setValue(cstmt.getString(5));
            }
            conn.close();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.rateSelection);
            AdfFacesContext.getCurrentInstance().addPartialTarget(maskDesc);
            AdfFacesContext.getCurrentInstance().addPartialTarget(maskDisplay);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
    }

    public String AddDependantLimit() {
        try {
            String prodType = (String)session.getAttribute("productType");
            if (prodType == null) {

            } else if (prodType.equalsIgnoreCase("LOAN")) {

            } else {
                if (session.getAttribute("pcaCode") == null) {
                    GlobalCC.INFORMATIONREPORTING("Select A Category");
                    return null;
                }
            }

            dpdCoverType.setValue(null);
            dependentTypeDisplay.setValue(null);
            maxTypeDisplay.setValue(null);
            minAmountDisplay.setValue(null);

            session.setAttribute("dtyCode", null);
            session.setAttribute("maxType", null);
            session.setAttribute("CoverTypeCode", null);
            session.setAttribute("qcvtCode", null);
            session.setAttribute("pcvtCode", null);
            session.setAttribute("pdlCode", null);

            GlobalCC.showPopup("lmsgroup:poldepdetails");

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public void PolicyCoverTypeListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if (valueChangeEvent.getNewValue() != null) {

            if (valueChangeEvent.getOldValue() !=
                valueChangeEvent.getNewValue()) {
                if (dpdCoverType.getValue() != null) {

                    DCIteratorBinding dciter =
                        ADFUtils.findIterator("FindCoverTypesIter");
                    Row r =
                        dciter.getRowAtRangeIndex((Integer)valueChangeEvent.getNewValue());

                    session.setAttribute("CoverTypeCode",
                                         r.getAttribute("PCVT_CVT_CODE"));
                    session.setAttribute("qcvtcvtCode",
                                         r.getAttribute("PCVT_CVT_CODE"));
                    session.setAttribute("pcvtCode",
                                         r.getAttribute("PCVT_CODE"));
                    session.setAttribute("pdlCode", null);

                    dependentTypeDisplay.setValue(null);
                    ADFUtils.findIterator("FindDependentsIterator").executeQuery();
                    AdfFacesContext.getCurrentInstance().addPartialTarget(dependentTypeDisplay);

                }
            }
        }
    }

    public void CoverTypeDependantListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if (valueChangeEvent.getNewValue() != null) {

            if (valueChangeEvent.getOldValue() !=
                valueChangeEvent.getNewValue()) {
                if (dependentTypeDisplay.getValue() != null) {

                    DCIteratorBinding dciter =
                        ADFUtils.findIterator("FindDependentsIterator");
                    Row r =
                        dciter.getRowAtRangeIndex((Integer)valueChangeEvent.getNewValue());

                    session.setAttribute("dtyCode",
                                         r.getAttribute("DTY_CODE"));
                    session.setAttribute("maxType",
                                         r.getAttribute("PCD_MAX_NO_ALLOWED"));
                    maxTypeDisplay.setValue(r.getAttribute("PCD_MAX_NO_ALLOWED"));
                    limitAmountDisplay.setValue(r.getAttribute("PCD_MAX_SUM_ASSURED"));
                    minAmountDisplay.setValue(r.getAttribute("PCD_MIN_SUM_ASSURED"));
                    //limitAmountDisplay.setValue(null);

                    AdfFacesContext.getCurrentInstance().addPartialTarget(dependentTypeDisplay);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(limitAmountDisplay);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(maxTypeDisplay);

                }
            }
        }
    }

    public void setProductCoverDropBox(RichSelectOneChoice productCoverDropBox) {
        this.productCoverDropBox = productCoverDropBox;
    }

    public RichSelectOneChoice getProductCoverDropBox() {
        return productCoverDropBox;
    }

    public void setPrdTypeLabel(RichOutputLabel prdTypeLabel) {
        this.prdTypeLabel = prdTypeLabel;
    }

    public RichOutputLabel getPrdTypeLabel() {
        return prdTypeLabel;
    }

    public void setReinMaskTable(RichTable reinMaskTable) {
        this.reinMaskTable = reinMaskTable;
    }

    public RichTable getReinMaskTable() {
        return reinMaskTable;
    }

    public void setReinMaskDesc(RichInputText reinMaskDesc) {
        this.reinMaskDesc = reinMaskDesc;
    }

    public RichInputText getReinMaskDesc() {
        return reinMaskDesc;
    }

    public void setPremProvCbox(RichSelectBooleanCheckbox premProvCbox) {
        this.premProvCbox = premProvCbox;
    }

    public RichSelectBooleanCheckbox getPremProvCbox() {
        return premProvCbox;
    }

    public void setPremProvLabel(RichOutputLabel premProvLabel) {
        this.premProvLabel = premProvLabel;
    }

    public RichOutputLabel getPremProvLabel() {
        return premProvLabel;
    }

    public void setDpdCatDescDisp1(RichOutputText dpdCatDescDisp1) {
        this.dpdCatDescDisp1 = dpdCatDescDisp1;
    }

    public RichOutputText getDpdCatDescDisp1() {
        return dpdCatDescDisp1;
    }

    public void memberDependantListener(SelectionEvent selectionEvent) {
        // Add event code here...
        if (selectionEvent.getAddedSet() != selectionEvent.getRemovedSet()) {
            RowKeySet keys = selectionEvent.getAddedSet();
            if (keys != null && keys.getSize() > 0) {
                for (Object treeRowKey : keys) {
                    annDependantsLOV.setRowKey(treeRowKey);
                    JUCtrlHierNodeBinding nd =
                        (JUCtrlHierNodeBinding)annDependantsLOV.getRowData();

                    session.setAttribute("pabCode",
                                         nd.getRow().getAttribute("pabNUmber"));

                    ADFUtils.findIterator("FindMembersAnnDependentPaymentsIterator").executeQuery();
                    AdfFacesContext.getCurrentInstance().addPartialTarget(annPartialPayments);

                }
            }
        }
    }

    public void setAnnPartialPayments(RichTable annPartialPayments) {
        this.annPartialPayments = annPartialPayments;
    }

    public RichTable getAnnPartialPayments() {
        return annPartialPayments;
    }

    public void setRegDate(RichInputDate regDate) {
        this.regDate = regDate;
    }

    public RichInputDate getRegDate() {
        return regDate;
    }

    public void setPensionMode(RichSelectOneChoice pensionMode) {
        this.pensionMode = pensionMode;
    }

    public RichSelectOneChoice getPensionMode() {
        return pensionMode;
    }

    public void setOwnFacShare(RichInputNumberSpinbox ownFacShare) {
        this.ownFacShare = ownFacShare;
    }

    public RichInputNumberSpinbox getOwnFacShare() {
        return ownFacShare;
    }

    public void setWeTLabel(RichOutputLabel weTLabel) {
        this.weTLabel = weTLabel;
    }

    public RichOutputLabel getWeTLabel() {
        return weTLabel;
    }

    public void newWETListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if (valueChangeEvent.getNewValue() != valueChangeEvent.getOldValue()) {
            if (wetDate.getValue() == null) {
                session.setAttribute("newWETDate", null);
            } else {
                session.setAttribute("newWETDate",
                                     GlobalCC.parseDate(wetDate.getValue().toString()));
            }
        }

    }

    public void setLdrCombined(RichSelectBooleanCheckbox ldrCombined) {
        this.ldrCombined = ldrCombined;
    }

    public RichSelectBooleanCheckbox getLdrCombined() {
        return ldrCombined;
    }

    public void setLdrCombinedLabel(RichOutputLabel ldrCombinedLabel) {
        this.ldrCombinedLabel = ldrCombinedLabel;
    }

    public RichOutputLabel getLdrCombinedLabel() {
        return ldrCombinedLabel;
    }

    public void setMarketerLOV(RichTable marketerLOV) {
        this.marketerLOV = marketerLOV;
    }

    public RichTable getMarketerLOV() {
        return this.marketerLOV;
    }

    public void setMarketerDisplay(RichInputText marketerDisplay) {
        this.marketerDisplay = marketerDisplay;
    }

    public RichInputText getMarketerDisplay() {
        return this.marketerDisplay;
    }

    public void setBenNames(RichInputText benNames) {
        this.benNames = benNames;
    }

    public RichInputText getBenNames() {
        return this.benNames;
    }

    public void setBenSurname(RichInputText benSurname) {
        this.benSurname = benSurname;
    }

    public RichInputText getBenSurname() {
        return this.benSurname;
    }

    public void setBenMemNo(RichInputText benMemNo) {
        this.benMemNo = benMemNo;
    }

    public RichInputText getBenMemNo() {
        return this.benMemNo;
    }

    public void setBenDOB(RichInputDate benDOB) {
        this.benDOB = benDOB;
    }

    public RichInputDate getBenDOB() {
        return this.benDOB;
    }

    public void setBenShare(RichInputText benShare) {
        this.benShare = benShare;
    }

    public RichInputText getBenShare() {
        return this.benShare;
    }

    public void setBenTerShare(RichInputText benTerShare) {
        this.benTerShare = benTerShare;
    }

    public RichInputText getBenTerShare() {
        return this.benTerShare;
    }

    public void setDivFactor(RichInputText divFactor) {
        this.divFactor = divFactor;
    }

    public RichInputText getDivFactor() {
        return divFactor;
    }

    public void setDiscChoice(RichSelectOneChoice discChoice) {
        this.discChoice = discChoice;
    }

    public RichSelectOneChoice getDiscChoice() {
        return discChoice;
    }

    public void setDiscRateDisplay(RichInputText discRateDisplay) {
        this.discRateDisplay = discRateDisplay;
    }

    public RichInputText getDiscRateDisplay() {
        return discRateDisplay;
    }

    public void setDiscDivFactor(RichInputText discDivFactor) {
        this.discDivFactor = discDivFactor;
    }

    public RichInputText getDiscDivFactor() {
        return discDivFactor;
    }

    public void setAgencyDesc(RichInputText agencyDesc) {
        this.agencyDesc = agencyDesc;
    }

    public RichInputText getAgencyDesc() {
        return agencyDesc;
    }

    public void setRsaPin(RichInputText rsaPin) {
        this.rsaPin = rsaPin;
    }

    public RichInputText getRsaPin() {
        return rsaPin;
    }

    public void setStudentSharePct(RichInputText studentSharePct) {
        this.studentSharePct = studentSharePct;
    }

    public RichInputText getStudentSharePct() {
        return studentSharePct;
    }

    public void setAgencyTable(RichTable agencyTable) {
        this.agencyTable = agencyTable;
    }

    public RichTable getAgencyTable() {
        return agencyTable;
    }

    public void setPolMemberExceptions(RichTable polMemberExceptions) {
        this.polMemberExceptions = polMemberExceptions;
    }

    public RichTable getPolMemberExceptions() {
        return polMemberExceptions;
    }

    public void setQuoMemberExceptions(RichTable quoMemberExceptions) {
        this.quoMemberExceptions = quoMemberExceptions;
    }

    public RichTable getQuoMemberExceptions() {
        return quoMemberExceptions;
    }

    public void JointAgentsListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if (valueChangeEvent.getOldValue() != valueChangeEvent.getNewValue()) {

            if (jointAgent.isSelected()) {
                agentShareLabel.setRendered(true);
                agentShare.setRendered(true);
            } else {
                agentShareLabel.setRendered(false);
                agentShare.setRendered(false);
            }
            AdfFacesContext.getCurrentInstance().addPartialTarget(agentShareLabel);
            AdfFacesContext.getCurrentInstance().addPartialTarget(agentShare);
        }
    }

    public void setJointAgent(RichSelectBooleanCheckbox jointAgent) {
        this.jointAgent = jointAgent;
    }

    public RichSelectBooleanCheckbox getJointAgent() {
        return jointAgent;
    }

    public void setAgentShareLabel(RichOutputLabel agentShareLabel) {
        this.agentShareLabel = agentShareLabel;
    }

    public RichOutputLabel getAgentShareLabel() {
        return agentShareLabel;
    }

    public void setAgentShare(RichInputNumberSpinbox agentShare) {
        this.agentShare = agentShare;
    }

    public RichInputNumberSpinbox getAgentShare() {
        return agentShare;
    }

    public void setAccessGrpDisplay(RichInputText accessGrpDisplay) {
        this.accessGrpDisplay = accessGrpDisplay;
    }

    public RichInputText getAccessGrpDisplay() {
        return accessGrpDisplay;
    }

    public void setAccessGrpTable(RichTable accessGrpTable) {
        this.accessGrpTable = accessGrpTable;
    }

    public RichTable getAccessGrpTable() {
        return accessGrpTable;
    }

    public void setAccessGrpDisplay1(RichInputText accessGrpDisplay1) {
        this.accessGrpDisplay1 = accessGrpDisplay1;
    }

    public RichInputText getAccessGrpDisplay1() {
        return accessGrpDisplay1;
    }

    public void setAccessGrpTable1(RichTable accessGrpTable1) {
        this.accessGrpTable1 = accessGrpTable1;
    }

    public RichTable getAccessGrpTable1() {
        return accessGrpTable1;
    }

    public void setMemberSDivTable(RichTable memberSDivTable) {
        this.memberSDivTable = memberSDivTable;
    }

    public RichTable getMemberSDivTable() {
        return memberSDivTable;
    }

    public void setUmbrellaCbox(RichSelectBooleanCheckbox umbrellaCbox) {
        this.umbrellaCbox = umbrellaCbox;
    }

    public RichSelectBooleanCheckbox getUmbrellaCbox() {
        return umbrellaCbox;
    }

    public void setUmbrellaDurationType(RichSelectOneChoice umbrellaDurationType) {
        this.umbrellaDurationType = umbrellaDurationType;
    }

    public RichSelectOneChoice getUmbrellaDurationType() {
        return umbrellaDurationType;
    }

    public void setUmbrellaDurationLabel(RichOutputLabel umbrellaDurationLabel) {
        this.umbrellaDurationLabel = umbrellaDurationLabel;
    }

    public RichOutputLabel getUmbrellaDurationLabel() {
        return umbrellaDurationLabel;
    }

    public void setRateSelection(RichSelectOneChoice rateSelection) {
        this.rateSelection = rateSelection;
    }

    public RichSelectOneChoice getRateSelection() {
        return rateSelection;
    }

    public void setMaskDesc(RichInputText maskDesc) {
        this.maskDesc = maskDesc;
    }

    public RichInputText getMaskDesc() {
        return maskDesc;
    }

    public void setMaskButton(RichCommandButton maskButton) {
        this.maskButton = maskButton;
    }

    public RichCommandButton getMaskButton() {
        return maskButton;
    }

    public void setCoverRate(RichInputNumberSpinbox coverRate) {
        this.coverRate = coverRate;
    }

    public RichInputNumberSpinbox getCoverRate() {
        return coverRate;
    }

    public void setCoverRateDivFactor(RichInputNumberSpinbox coverRateDivFactor) {
        this.coverRateDivFactor = coverRateDivFactor;
    }

    public RichInputNumberSpinbox getCoverRateDivFactor() {
        return coverRateDivFactor;
    }

    public void setMaskTable(RichTable maskTable) {
        this.maskTable = maskTable;
    }

    public RichTable getMaskTable() {
        return maskTable;
    }

    public void setCatMaskDesc(RichInputText catMaskDesc) {
        this.catMaskDesc = catMaskDesc;
    }

    public RichInputText getCatMaskDesc() {
        return catMaskDesc;
    }

    public void setCatMaskTable(RichTable catMaskTable) {
        this.catMaskTable = catMaskTable;
    }

    public RichTable getCatMaskTable() {
        return catMaskTable;
    }

    public void setMinAmountDisplay(RichInputText minAmountDisplay) {
        this.minAmountDisplay = minAmountDisplay;
    }

    public RichInputText getMinAmountDisplay() {
        return minAmountDisplay;
    }

    public void setPremMaskBut(RichCommandButton premMaskBut) {
        this.premMaskBut = premMaskBut;
    }

    public RichCommandButton getPremMaskBut() {
        return premMaskBut;
    }

    public void totalAllocationListener(ValueChangeEvent valueChangeEvent) {
        String query =
            "begin ? := LMS_WEB_PKG_GRP_UW.get_total_allocations(?,?); end;";
        Connection conn = null;
        CallableStatement stmt = null;
        BigDecimal value;
        try {
            conn = new DBConnector().getDatabaseConn();
            stmt = conn.prepareCall(query);
            stmt.registerOutParameter(1, OracleTypes.VARCHAR);
            if (newPremAllocDisp.getValue() == null &&
                newPensionAlloc.getValue() == null) {
                stmt.setString(2, null);
                stmt.setString(3, null);
                newPremAllocDisp.setValue(0);
                newPensionAlloc.setValue(0);
            } else if (newPremAllocDisp.getValue() != null &&
                       newPensionAlloc.getValue() == null) {
                stmt.setString(2, (String)newPremAllocDisp.getValue());
                stmt.setString(3, null);
                newPensionAlloc.setValue(0);
            } else if (newPremAllocDisp.getValue() != null &&
                       newPensionAlloc.getValue() != null) {
                stmt.setString(2, (String)newPremAllocDisp.getValue());
                stmt.setString(3, (String)newPensionAlloc.getValue());
            } else {
                stmt.setString(2, null);
                stmt.setString(3, (String)newPensionAlloc.getValue());
                newPremAllocDisp.setValue(0);
            }
            stmt.execute();
            value = stmt.getBigDecimal(1);
            //System.out.println("Value "+value);newTotalAllocation
            newTotalAllocation.setValue(value);
            AdfFacesContext.getCurrentInstance().addPartialTarget(newPremAllocDisp);
            AdfFacesContext.getCurrentInstance().addPartialTarget(newPensionAlloc);
            AdfFacesContext.getCurrentInstance().addPartialTarget(newTotalAllocation);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(null, stmt, conn);
        }

    }

    public void unitRateListener(ValueChangeEvent valueChangeEvent) {
        if (unitRateSelectBox.isSelected()) {
            //System.out.println("here...");
            GlobalCC.showPopup("lmsgroup:unitRatesPopup");
        } else {

        }

    }

    public void getLossRatio() {
        String updateQuery =
            "BEGIN LMS_WEB_PKG_GRP.update_loss_ratio(?,?,?,?);END;";
        Connection conn = new DBConnector().getDatabaseConn();
        CallableStatement cstmt = null;

        try {
            cstmt = conn.prepareCall(updateQuery);
            cstmt.setString(1, "P");
            cstmt.setBigDecimal(2,
                                (BigDecimal)this.session.getAttribute("QuoteCode"));
            if (totClaimPaid.getValue() == null) {
                cstmt.setBigDecimal(3, null);
            } else {
                BigDecimal totalClaim =
                    new BigDecimal(totClaimPaid.getValue().toString());
                cstmt.setBigDecimal(3, totalClaim);
            }
            if (totPremPaid.getValue() == null) {
                cstmt.setString(4, null);
            } else {
                BigDecimal totalPrem =
                    new BigDecimal(totPremPaid.getValue().toString());
                cstmt.setBigDecimal(4, totalPrem);
            }
            cstmt.execute();
            cstmt.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
    }


    public void setUnitRateSelectBox(RichSelectBooleanCheckbox unitRateSelectBox) {
        this.unitRateSelectBox = unitRateSelectBox;
    }

    public RichSelectBooleanCheckbox getUnitRateSelectBox() {
        return unitRateSelectBox;
    }

    public void setUnitRateDisplay(RichInputText unitRateDisplay) {
        this.unitRateDisplay = unitRateDisplay;
    }

    public RichInputText getUnitRateDisplay() {
        return unitRateDisplay;
    }

    public void setUnitRateDivisionFactor(RichSelectOneChoice unitRateDivisionFactor) {
        this.unitRateDivisionFactor = unitRateDivisionFactor;
    }

    public RichSelectOneChoice getUnitRateDivisionFactor() {
        return unitRateDivisionFactor;
    }

    public void saveReinUnitRate(ActionEvent actionEvent) {
        int divFactor = 1;
        String divisor = (String)unitRateDivisionFactor.getValue();
        try {
            session.setAttribute("reinsPmasCode", null);
            if (unitRateDisplay.getValue() == null) {
                GlobalCC.INFORMATIONREPORTING("Unit Rate Cannot be null");
            } else {
                BigDecimal reinRate =
                    new BigDecimal((String)unitRateDisplay.getValue());
                session.setAttribute("reinUnitRate", reinRate);
            }

            if (divisor == null) {
                GlobalCC.INFORMATIONREPORTING("Select Division Factor");
            } else {
                if (divisor.equals("Per Mille")) {
                    divFactor = 1000;
                } else if (divisor.equals("Percent")) {
                    divFactor = 100;
                }
                session.setAttribute("reinUnitRateDivFac", divFactor);

            }
        } catch (Exception ex) {
            GlobalCC.INFORMATIONREPORTING("Ensure you haveinputed a number");
        }

    }

    public void setTotClaimPaid(RichInputText totClaimPaid) {
        this.totClaimPaid = totClaimPaid;
    }

    public RichInputText getTotClaimPaid() {
        return totClaimPaid;
    }

    public void setTotPremPaid(RichInputText totPremPaid) {
        this.totPremPaid = totPremPaid;
    }

    public RichInputText getTotPremPaid() {
        return totPremPaid;
    }

    public void setLossDurationPeriod(RichInputText lossDurationPeriod) {
        this.lossDurationPeriod = lossDurationPeriod;
    }

    public RichInputText getLossDurationPeriod() {
        return lossDurationPeriod;
    }

    public void setAgeLoadFactor(RichInputText ageLoadFactor) {
        this.ageLoadFactor = ageLoadFactor;
    }

    public RichInputText getAgeLoadFactor() {
        return ageLoadFactor;
    }

    public void setDiscLoadRateDisplayLab(RichOutputLabel discLoadRateDisplayLab) {
        this.discLoadRateDisplayLab = discLoadRateDisplayLab;
    }

    public RichOutputLabel getDiscLoadRateDisplayLab() {
        return discLoadRateDisplayLab;
    }

    public void setDivFactorLab(RichOutputLabel divFactorLab) {
        this.divFactorLab = divFactorLab;
    }

    public RichOutputLabel getDivFactorLab() {
        return divFactorLab;
    }

    public void setAgeLoadFactorLab(RichOutputLabel ageLoadFactorLab) {
        this.ageLoadFactorLab = ageLoadFactorLab;
    }

    public RichOutputLabel getAgeLoadFactorLab() {
        return ageLoadFactorLab;
    }

    public void loadingTypeSelectListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if (valueChangeEvent.getNewValue() != valueChangeEvent.getOldValue()) {
            if (loadingTypeSelect.getValue() != null) {
                if (loadingTypeSelect.getValue().toString().equalsIgnoreCase("A")) {
                    discLoadRateDisplayLab.setRendered(false);
                    discLoadRateDisplay.setRendered(false);
                    divFactorLab.setRendered(false);
                    divFactor.setRendered(false);
                    ageLoadFactorLab.setRendered(true);
                    ageLoadFactor.setRendered(true);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(this.coversPanelBox);
                } else {
                    discLoadRateDisplayLab.setRendered(true);
                    discLoadRateDisplay.setRendered(true);
                    divFactorLab.setRendered(true);
                    divFactor.setRendered(true);
                    ageLoadFactorLab.setRendered(false);
                    ageLoadFactor.setRendered(false);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(this.coversPanelBox);
                }
            }
        }
    }

    public void setCoversPanel(RichPanelGroupLayout coversPanel) {
        this.coversPanel = coversPanel;
    }

    public RichPanelGroupLayout getCoversPanel() {
        return coversPanel;
    }

    public void setCoversPanelBox(RichPanelBox coversPanelBox) {
        this.coversPanelBox = coversPanelBox;
    }

    public RichPanelBox getCoversPanelBox() {
        return coversPanelBox;
    }

    public void setBen_type(RichSelectOneChoice ben_type) {
        this.ben_type = ben_type;
    }

    public RichSelectOneChoice getBen_type() {
        return ben_type;
    }

    public void setRefPolicyNo(RichInputText refPolicyNo) {
        this.refPolicyNo = refPolicyNo;
    }

    public RichInputText getRefPolicyNo() {
        return refPolicyNo;
    }

    public void setRefPremDisplay(RichInputText refPremDisplay) {
        this.refPremDisplay = refPremDisplay;
    }

    public RichInputText getRefPremDisplay() {
        return refPremDisplay;
    }

    public void setRefPensDisplay(RichInputText refPensDisplay) {
        this.refPensDisplay = refPensDisplay;
    }

    public RichInputText getRefPensDisplay() {
        return refPensDisplay;
    }

    public void setRefTotalDisplay(RichInputText refTotalDisplay) {
        this.refTotalDisplay = refTotalDisplay;
    }

    public RichInputText getRefTotalDisplay() {
        return refTotalDisplay;
    }

    public String authoriseRefund() {
        // Add event code here...
        String authRefund =
            "BEGIN LMS_WEB_PKG_GRP.auth_refund(?,?,?,?,?,?,?,?);END;";
        Connection conn = new DBConnector().getDatabaseConn();
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall(authRefund);
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("GrctCode"));
            cstmt.setBigDecimal(2,
                                (BigDecimal)session.getAttribute("policycode"));
            cstmt.setString(3, (String)session.getAttribute("Username"));
            if (refTotalDisplay.getValue() == null) {
                cstmt.setString(4, null);
            } else {
                cstmt.setString(4, refTotalDisplay.getValue().toString());
            }
            if (newTotalAllocation.getValue() == null) {
                cstmt.setString(5, null);
            } else {
                cstmt.setString(5, newTotalAllocation.getValue().toString());
            }
            if (newPremAllocDisp.getValue() == null) {
                cstmt.setString(6, null);
            } else {
                cstmt.setString(6, newPremAllocDisp.getValue().toString());
            }
            if (newPensionAlloc.getValue() == null) {
                cstmt.setString(7, null);
            } else {
                cstmt.setString(7, newPensionAlloc.getValue().toString());
            }

            cstmt.execute();
            conn.close();

        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        } finally {
            GlobalCC.CloseConnections(null, cstmt, conn);
        }
        return null;
    }

    public void load_discount_listener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if (valueChangeEvent.getNewValue() != valueChangeEvent.getOldValue()) {
            if (load_discount_chk.isSelected()) {
                GlobalCC.showPopup("lmsgroup:loadDiscountPopup");
            } else {
                GlobalCC.hidePopup("lmsgroup:loadDiscountPopup");
            }
        }
    }

    public void setLoad_discount_chk(RichSelectBooleanCheckbox load_discount_chk) {
        this.load_discount_chk = load_discount_chk;
    }

    public RichSelectBooleanCheckbox getLoad_discount_chk() {
        return load_discount_chk;
    }

    public void setCoverList(List<SelectItem> coverList) {
        this.coverList = coverList;
    }

    public List<SelectItem> getCoverList() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        coverList = new ArrayList<SelectItem>();
        try {
            String polQuery =
                "begin LMS_WEB_CURSOR_GRP.findpolicycovertypes(?,?);end;";
            cst = conn.prepareCall(polQuery);
            cst.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            cst.setBigDecimal(2,
                              (BigDecimal)session.getAttribute("endorsementCode"));
            cst.execute();
            ResultSet rst = (ResultSet)cst.getObject(1);
            while (rst.next()) {
                coverList.add(new SelectItem(rst.getBigDecimal(14),
                                             rst.getString(1)));
            }
            rst.close();
            cst.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return coverList;
    }


    public String saveRILoading() {
        // Add event code here...
        String loadDisc =
            "BEGIN LMS_GRP_WEB_PKG.update_ri_load_disc(?,?,?,?);END;";
        Connection conn = new DBConnector().getDatabaseConn();
        CallableStatement cstmt = null;


        try {
            cstmt = conn.prepareCall(loadDisc);
            cstmt.setString(1, coverListSelect.getValue().toString());
            System.out.println("loading ....." +
                               loadingSelect.getValue().toString());

            if (loadingSelect.getValue().toString().equalsIgnoreCase("L")) {
                cstmt.setString(2, loadingSelect.getValue().toString());
                if (loadRateTF.getValue() == null) {
                    GlobalCC.INFORMATIONREPORTING("Please provide the loading rate");
                } else {
                    cstmt.setString(3, loadRateTF.getValue().toString());
                }
                if (loadRateDivTF.getValue() == null) {
                    GlobalCC.INFORMATIONREPORTING("Please provide the loading rate division Factor");
                } else {
                    cstmt.setString(4, loadRateDivTF.getValue().toString());
                }

            } else if (discountingSelect.getValue().toString().equalsIgnoreCase("D")) {
                cstmt.setString(2, discountingSelect.getValue().toString());
                if (discountRateTF.getValue() == null) {
                    GlobalCC.INFORMATIONREPORTING("Please provide the discounting rate");
                } else {
                    cstmt.setString(3, discountRateTF.getValue().toString());
                }
                if (discountDivFactorTF.getValue() == null) {
                    GlobalCC.INFORMATIONREPORTING("Please provide the discounting rate division Factor");
                } else {
                    cstmt.setString(4,
                                    discountDivFactorTF.getValue().toString());
                }
            } else {
                cstmt.setString(2, loadingSelect.getValue().toString());
                cstmt.setString(3, null);
                cstmt.setString(4, null);
            }

            cstmt.execute();
            conn.close();

        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
            ex.printStackTrace();
        } finally {
            GlobalCC.CloseConnections(null, cstmt, conn);
        }
        return null;
    }

    public void setCoverListSelect(RichSelectOneChoice coverListSelect) {
        this.coverListSelect = coverListSelect;
    }

    public RichSelectOneChoice getCoverListSelect() {
        return coverListSelect;
    }

    public void setLoadingSelect(RichSelectOneChoice loadingSelect) {
        this.loadingSelect = loadingSelect;
    }

    public RichSelectOneChoice getLoadingSelect() {
        return loadingSelect;
    }

    public void setLoadRateTF(RichInputText loadRateTF) {
        this.loadRateTF = loadRateTF;
    }

    public RichInputText getLoadRateTF() {
        return loadRateTF;
    }

    public void setLoadRateDivTF(RichInputText loadRateDivTF) {
        this.loadRateDivTF = loadRateDivTF;
    }

    public RichInputText getLoadRateDivTF() {
        return loadRateDivTF;
    }

    public void setDiscountingSelect(RichSelectOneChoice discountingSelect) {
        this.discountingSelect = discountingSelect;
    }

    public RichSelectOneChoice getDiscountingSelect() {
        return discountingSelect;
    }

    public void setDiscountRateTF(RichInputText discountRateTF) {
        this.discountRateTF = discountRateTF;
    }

    public RichInputText getDiscountRateTF() {
        return discountRateTF;
    }

    public void setDiscountDivFactorTF(RichInputText discountDivFactorTF) {
        this.discountDivFactorTF = discountDivFactorTF;
    }

    public RichInputText getDiscountDivFactorTF() {
        return discountDivFactorTF;
    }

    public void setMemNo_search(RichInputText memNo_search) {
        this.memNo_search = memNo_search;
    }

    public RichInputText getMemNo_search() {
        return memNo_search;
    }

    public void setMemNameSearch(RichInputText memNameSearch) {
        this.memNameSearch = memNameSearch;
    }

    public RichInputText getMemNameSearch() {
        return memNameSearch;
    }

    public void memNoSearchEvent(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if (valueChangeEvent.getNewValue() != valueChangeEvent.getOldValue())
            session.setAttribute("memNoSearch",
                                 memNo_search.getValue().toString());
    }

    public String memSearchAction() {
        // Add event code here...
        try {
            if (memNo_search.getValue() == null) {
                session.setAttribute("memNoSearch", null);
            } else {
                session.setAttribute("memNoSearch",
                                     memNo_search.getValue().toString());
            }
            if (memNo_search.getValue() == null) {
                session.setAttribute("memNameSearch", null);
            } else {
                session.setAttribute("memNameSearch",
                                     memNo_search.getValue().toString());
            }


            ADFUtils.findIterator("FindPolicyMemberAtCoversIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(policyMembersLOV);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
            e.printStackTrace();
        }

        return null;
    }

    public void memNameSeach(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        session.setAttribute("memNameSearch",
                             memNo_search.getValue().toString());

    }

    public void setPensHistIntRate(RichInputText pensHistIntRate) {
        this.pensHistIntRate = pensHistIntRate;
    }

    public RichInputText getPensHistIntRate() {
        return pensHistIntRate;
    }

    public void setCvrLoadType(RichSelectOneChoice cvrLoadType) {
        this.cvrLoadType = cvrLoadType;
    }

    public RichSelectOneChoice getCvrLoadType() {
        return cvrLoadType;
    }

    public void setCvrLoadRate(RichInputText cvrLoadRate) {
        this.cvrLoadRate = cvrLoadRate;
    }

    public RichInputText getCvrLoadRate() {
        return cvrLoadRate;
    }

    public void setCvrLoadDivFactor(RichInputText cvrLoadDivFactor) {
        this.cvrLoadDivFactor = cvrLoadDivFactor;
    }

    public RichInputText getCvrLoadDivFactor() {
        return cvrLoadDivFactor;
    }

    public void setCurrSymbolCombo(RichSelectOneChoice currSymbolCombo) {
        this.currSymbolCombo = currSymbolCombo;
    }

    public RichSelectOneChoice getCurrSymbolCombo() {
        return currSymbolCombo;
    }

    public void setCurrRateType(RichSelectOneChoice currRateType) {
        this.currRateType = currRateType;
    }

    public RichSelectOneChoice getCurrRateType() {
        return currRateType;
    }

    public void setCurrRate(RichInputText currRate) {
        this.currRate = currRate;
    }

    public RichInputText getCurrRate() {
        return currRate;
    }

    public void setCurrencyPG(HtmlPanelGrid currencyPG) {
        this.currencyPG = currencyPG;
    }

    public HtmlPanelGrid getCurrencyPG() {
        return currencyPG;
    }

    public void currRateTypeListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if (valueChangeEvent.getNewValue() != valueChangeEvent.getOldValue()) {
            if (currRateType.getValue() != null) {
                if (currRateType.getValue().equals("Y")) {
                    currRateLab.setRendered(true);
                    currRate.setRendered(true);

                } else {
                    currRateLab.setRendered(false);
                    currRate.setRendered(false);
                }

            }
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.currRateLab);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.currRate);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.currencyPG);


    }

    public void getCurrencyDetails() {
        String updateQuery =
            "BEGIN LMS_WEB_PKG_GRP.savePolicyCurrencyDetails(?,?,?,?);END;";
        Connection conn = new DBConnector().getDatabaseConn();
        CallableStatement cstmt = null;
        String currencySymb =
            (String)this.session.getAttribute("baseCurrSymb");

        if (currSymbolCombo.getValue() == null) {
            GlobalCC.sysInformation("Please Choose a currency Symbol");
        } else {
            Row row =
                ADFUtils.findIterator("findOrgCurrenciesIterator").getRowAtRangeIndex(new Integer(currSymbolCombo.getValue().toString()));
            currencySymb = (String)row.getAttribute("cur_symbol");

        }
        System.out.println("currencySymb=" + currencySymb);

        try {
            cstmt = conn.prepareCall(updateQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)this.session.getAttribute("endorsementCode"));
            cstmt.setString(2, currencySymb);
            cstmt.setString(3, currRateType.getValue().toString());
            if (currRate.getValue() == null) {
                cstmt.setString(4, null);
            } else {
                cstmt.setString(4, currRate.getValue().toString());
            }


            cstmt.execute();
            cstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
    }

    public void setCurrRateLab(RichOutputLabel currRateLab) {
        this.currRateLab = currRateLab;
    }

    public RichOutputLabel getCurrRateLab() {
        return currRateLab;
    }

    public void setAboveFclLOV(RichTable aboveFclLOV) {
        this.aboveFclLOV = aboveFclLOV;
    }

    public RichTable getAboveFclLOV() {
        return aboveFclLOV;
    }

    public void handleFCLOvrClick(ClientEvent clientEvent) {
        // Add event code here....
        endrOvrFCLAmt.setReadOnly(false);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.endrOvrFCLAmt);
        //System.out.println("Here testing events...");
    }

    public void setBmiRate(RichInputText bmiRate) {
        this.bmiRate = bmiRate;
    }

    public RichInputText getBmiRate() {
        return bmiRate;
    }

    public String selectCategory() {
        // Add event code here...
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findOccupationCategoryIterator");
            RowKeySet set = memClassesLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            //System.out.println(1);
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();
                categIDDisplay.setValue(r.getAttribute("gocCategory"));
                categDescriptionDisplay.setValue(r.getAttribute("gocCategory"));
                categPeriodDisplay.setValue(r.getAttribute("gocClass"));
            }


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public void setMemClassesLOV(RichTable memClassesLOV) {
        this.memClassesLOV = memClassesLOV;
    }

    public RichTable getMemClassesLOV() {
        return memClassesLOV;
    }

    public void setOccupationLOV(RichTable occupationLOV) {
        this.occupationLOV = occupationLOV;
    }

    public RichTable getOccupationLOV() {
        return occupationLOV;
    }

    public String addMemberProvision() {
        // Add event code here...
        // Add event code here...
        Connection conn = null;
        String prodBudget =
            "BEGIN LMS_WEB_PKG_GRP.addMemberProvision(?,?,?,?);END;";
        try {
            conn = new DBConnector().getDatabaseConn();
            CallableStatement cstmt = conn.prepareCall(prodBudget);
            Object key2 = memProvisionLOV.getSelectedRowData();
            if (key2 == null) {
                GlobalCC.errorValueNotEntered("No Record Selected");
                return null;
            }
            JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
            if (r == null) {
                GlobalCC.errorValueNotEntered("No Record Selected");
                return null;
            }
            if (session.getAttribute("MemberNumber") == null) {
                GlobalCC.errorValueNotEntered("No Member Selected");
            }
            cstmt.setBigDecimal(1,
                                (BigDecimal)session.getAttribute("endorsementCode"));
            cstmt.setBigDecimal(2,
                                (BigDecimal)session.getAttribute("policyCode"));
            cstmt.setBigDecimal(3, (BigDecimal)r.getAttribute("PPROV_CODE"));
            cstmt.setBigDecimal(4,
                                (BigDecimal)session.getAttribute("MemberNumber"));

            GlobalCC.INFORMATIONREPORTING("Member Provisions successfully added");
            cstmt.execute();
            conn.close();
            ADFUtils.findIterator("findMemberProvisionsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(memberProvisionLOV);
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        }
        return null;
    }

    public void setMemProvisionLOV(RichTable memProvisionLOV) {
        this.memProvisionLOV = memProvisionLOV;
    }

    public RichTable getMemProvisionLOV() {
        return memProvisionLOV;
    }

    public void setMemberProvision(RichTable memberProvision) {
        this.memberProvision = memberProvision;
    }

    public RichTable getMemberProvision() {
        return memberProvision;
    }

    public void setMemberProvisionLOV(RichTable memberProvisionLOV) {
        this.memberProvisionLOV = memberProvisionLOV;
    }

    public RichTable getMemberProvisionLOV() {
        return memberProvisionLOV;
    }

    public String deleteMemberProvision() {
        // Add event code here...
        Connection conn = null;
        String prodBudget = "BEGIN LMS_WEB_PKG_GRP.deleteProvision(?);END;";
        try {
            conn = new DBConnector().getDatabaseConn();
            CallableStatement cstmt = conn.prepareCall(prodBudget);
            Object key2 = memberProvisionLOV.getSelectedRowData();
            if (key2 == null) {
                GlobalCC.errorValueNotEntered("No Record Selected");
                return null;
            }
            JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
            if (r == null) {
                GlobalCC.errorValueNotEntered("No Record Selected");
                return null;
            }
            cstmt.setBigDecimal(1, (BigDecimal)r.getAttribute("mempCode"));
            GlobalCC.INFORMATIONREPORTING("Member Provisions deleted successfully");
            cstmt.execute();
            conn.close();
            ADFUtils.findIterator("findMemberProvisionsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(memberProvisionLOV);
        } catch (Exception ex) {
            ex.printStackTrace();
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        }
        return null;
    }

    public String prodPlanTF() {
        // Add event code here...
        return null;
    }

    public void setProdPlanLOV(RichTable prodPlanLOV) {
        this.prodPlanLOV = prodPlanLOV;
    }

    public RichTable getProdPlanLOV() {
        return prodPlanLOV;
    }

    public String selectProductPlan() {
        // Add event code here...
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findProductPlansIterator");
            RowKeySet set = this.prodPlanLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();
                planTF.setValue(r.getAttribute("pplDesc"));
                session.setAttribute("pplCode", r.getAttribute("pplCode"));

            }
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.planTF);
        } catch (Exception e) {

            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public void setPlanTF(RichInputText planTF) {
        this.planTF = planTF;
    }

    public RichInputText getPlanTF() {
        return planTF;
    }

    public void setLoanInstallmentAmt(RichInputText loanInstallmentAmt) {
        this.loanInstallmentAmt = loanInstallmentAmt;
    }

    public RichInputText getLoanInstallmentAmt() {
        return loanInstallmentAmt;
    }

    public void setLoanInstRepayFreq(RichSelectOneChoice loanInstRepayFreq) {
        this.loanInstRepayFreq = loanInstRepayFreq;
    }

    public RichSelectOneChoice getLoanInstRepayFreq() {
        return loanInstRepayFreq;
    }

    public void setPostponePeriod(RichInputText postponePeriod) {
        this.postponePeriod = postponePeriod;
    }

    public RichInputText getPostponePeriod() {
        return postponePeriod;
    }

    public void setPostponeLab(RichOutputLabel postponeLab) {
        this.postponeLab = postponeLab;
    }

    public RichOutputLabel getPostponeLab() {
        return postponeLab;
    }

    public void coverOfferedListener(ValueChangeEvent evt) {
        // Add event code here...
        if (evt.getNewValue() != evt.getOldValue()) {
            if (covOffered.getValue() != null) {
                if (covOffered.getValue().equals("P")) {
                    postponeLab.setVisible(true);
                    postponePeriod.setVisible(true);
                } else {
                    postponeLab.setVisible(false);
                    postponePeriod.setVisible(false);
                }
            }
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.postponeLab);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.postponePeriod);
    }

    public void setTransfersTable(RichTable transfersTable) {
        this.transfersTable = transfersTable;
    }

    public RichTable getTransfersTable() {
        return transfersTable;
    }

    public void heightChangeListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        double bmi_rate, weight, height;
        DecimalFormat df = new DecimalFormat("#.0000");
        if (memHeight.getValue() != null && memWeight.getValue() != null) {
            weight = Double.parseDouble(memWeight.getValue().toString());
            height = Double.parseDouble(memHeight.getValue().toString());
            bmi_rate = weight / (Math.pow(height, 2));
            bmiRate.setValue(df.format(bmi_rate));
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.bmiRate);
        }
    }

    public void weightChangeListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        double bmi_rate, weight, height;
        DecimalFormat df = new DecimalFormat("#.0000");
        if (memHeight.getValue() != null && memWeight.getValue() != null) {
            weight = Double.parseDouble(memWeight.getValue().toString());
            height = Double.parseDouble(memHeight.getValue().toString());
            bmi_rate = weight / (Math.pow(height, 2));
            bmiRate.setValue(df.format(bmi_rate));
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.bmiRate);
        }
    }

    public void setItNarrReasons(RichInputText itNarrReasons) {
        this.itNarrReasons = itNarrReasons;
    }

    public RichInputText getItNarrReasons() {
        return itNarrReasons;
    }

    public String deleteCoverType() {
        // Add event code here...
        Connection conn = null;
        String deleteBudget = "BEGIN LMS_WEB_PKG_GRP.declinecover(?);END;";
        try {
            conn = new DBConnector().getDatabaseConn();
            CallableStatement cstmt = conn.prepareCall(deleteBudget);

            Object key2 = polMemberExceptions.getSelectedRowData();
            if (key2 == null) {
                GlobalCC.errorValueNotEntered("No Record Selected");
                return null;
            }
            JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
            if (r == null) {
                GlobalCC.errorValueNotEntered("No Record Selected");
                return null;
            }
            cstmt.setBigDecimal(1, (BigDecimal)r.getAttribute("POLME_CODE"));
            cstmt.execute();
            conn.close();
            ADFUtils.findIterator("FindMembersExceptionsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(polMemberExceptions);
            GlobalCC.INFORMATIONREPORTING("Cover Type Removed successfully");
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        }
        return null;
    }

    public String authoriseMemException() {
        // Add event code here...
        Connection conn = null;
        String deleteBudget =
            "BEGIN LMS_WEB_PKG_GRP.authoriseMemExceptions(?,?);END;";
        try {
            conn = new DBConnector().getDatabaseConn();
            CallableStatement cstmt = conn.prepareCall(deleteBudget);

            Object key2 = polMemberExceptions.getSelectedRowData();
            if (key2 == null) {
                GlobalCC.errorValueNotEntered("No Record Selected");
                return null;
            }
            JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
            if (r == null) {
                GlobalCC.errorValueNotEntered("No Record Selected");
                return null;
            }
            cstmt.setBigDecimal(1, (BigDecimal)r.getAttribute("POLME_CODE"));
            cstmt.setString(2, exceptionRemarks.getValue().toString());
            cstmt.execute();
            conn.close();
            ADFUtils.findIterator("FindMembersExceptionsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(polMemberExceptions);
            GlobalCC.INFORMATIONREPORTING("Exception Authorised successfully");
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        }
        return null;
    }

    public void setSrchMemNo(RichInputText srchMemNo) {
        this.srchMemNo = srchMemNo;
    }

    public RichInputText getSrchMemNo() {
        return srchMemNo;
    }

    public void setSrchMemName(RichInputText srchMemName) {
        this.srchMemName = srchMemName;
    }

    public RichInputText getSrchMemName() {
        return srchMemName;
    }

    public String SearchMembers() {
        try {
            if (srchMemName.getValue() == null) {
                session.setAttribute("srchMemName", null);
            } else {
                session.setAttribute("srchMemName",
                                     srchMemName.getValue().toString());
            }

            if (srchMemNo.getValue() == null) {
                session.setAttribute("srchMemNo", null);
            } else {
                session.setAttribute("srchMemNo",
                                     srchMemNo.getValue().toString());
            }
            ADFUtils.findIterator("FindPolicyMembersIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.policyMembers);

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return null;
    }

    public String ClearSearchMembers() {
        try {
            session.setAttribute("srchMemName", null);
            session.setAttribute("srchMemNo", null);
            srchMemNo.setValue(null);
            srchMemName.setValue(null);

            ADFUtils.findIterator("FindPolicyMembersIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.policyMembers);

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return null;
    }

    public String SearchMembersII() {
        try {
            if (srchMemName.getValue() == null) {
                session.setAttribute("srchMemName", null);
            } else {
                session.setAttribute("srchMemName",
                                     srchMemName.getValue().toString());
            }

            if (srchMemNo.getValue() == null) {
                session.setAttribute("srchMemNo", null);
            } else {
                session.setAttribute("srchMemNo",
                                     srchMemNo.getValue().toString());
            }
            ADFUtils.findIterator("FindPolicyMemberAtCoversIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.policyMembersLOV);

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return null;
    }

    public String ClearSearchMembersII() {
        try {
            session.setAttribute("srchMemName", null);
            session.setAttribute("srchMemNo", null);
            srchMemNo.setValue(null);
            srchMemName.setValue(null);

            ADFUtils.findIterator("FindPolicyMemberAtCoversIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.policyMembersLOV);

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return null;
    }

    public String AlterMemberCovers() {
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("FindPolicyMembersIterator");
            RowKeySet set = policyMembers.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            //System.out.println(1);
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();
                session.setAttribute("endrValue", "NB");
                session.setAttribute("PolmCode", r.getAttribute("POLM_CODE"));
                session.setAttribute("PolmMemCode",
                                     r.getAttribute("MEM_CODE"));
                GlobalCC.RedirectPage("/pmember_alter.jspx");
            }
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(null, ex);
        }
        return null;
    }

    public void setJointMemTable(RichTable jointMemTable) {
        this.jointMemTable = jointMemTable;
    }

    public RichTable getJointMemTable() {
        return jointMemTable;
    }

    public void setAssigneeName(RichInputText assigneeName) {
        this.assigneeName = assigneeName;
    }

    public RichInputText getAssigneeName() {
        return assigneeName;
    }

    public void setAssigneePhyAddr(RichInputText assigneePhyAddr) {
        this.assigneePhyAddr = assigneePhyAddr;
    }

    public RichInputText getAssigneePhyAddr() {
        return assigneePhyAddr;
    }

    public void coverLoadingListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
    }

    public void setAboveANBRate(RichInputText aboveANBRate) {
        this.aboveANBRate = aboveANBRate;
    }

    public RichInputText getAboveANBRate() {
        return aboveANBRate;
    }

    public void setExceptionRemarks(RichInputText exceptionRemarks) {
        this.exceptionRemarks = exceptionRemarks;
    }

    public RichInputText getExceptionRemarks() {
        return exceptionRemarks;
    }

    public void setAalLOV(RichTable aalLOV) {
        this.aalLOV = aalLOV;
    }

    public RichTable getAalLOV() {
        return aalLOV;
    }

    public String completeRiMed() {
        // Add event code here...
        Connection conn = null;
        workflowProcessing wf = new workflowProcessing();
        String Cursta = (String)session.getAttribute("CurrentStatus");
        if (Cursta.equalsIgnoreCase("P")) {
            //LOVCC.ProcessShtDesc = "UWNB";
            //LOVCC.ProcessAreaShtDesc = "NBUW";
            //LOVCC.ProcessSubAShtDesc = "NBUW";
            session.setAttribute("ProcessShtDesc", "UWNB");
            session.setAttribute("ProcessAreaShtDesc", "NBUW");
            session.setAttribute("ProcessSubAShtDesc", "NBUW");
        } else {
            //LOVCC.ProcessShtDesc = "UW" + LOVCC.Endorsement;
            //LOVCC.ProcessAreaShtDesc = LOVCC.Endorsement + "UW";
            //LOVCC.ProcessSubAShtDesc = LOVCC.Endorsement + "UW";
            session.setAttribute("ProcessShtDesc",
                                 "UW" + session.getAttribute("Endorsement"));
            session.setAttribute("ProcessAreaShtDesc",
                                 session.getAttribute("Endorsement") + "UW");
            session.setAttribute("ProcessSubAShtDesc",
                                 session.getAttribute("Endorsement") + "UW");
        }
        session.setAttribute("TaskAssignee", null);
        session.setAttribute("NextTaskAssignee", "N");
        ADFUtils.findIterator("findTicketAssigneeIterator").executeQuery();
        String NextUser = (String)session.getAttribute("NextTaskAssignee");
        String TaskAss = (String)session.getAttribute("TaskAssignee");
        if (TaskAss == null) {
            TaskAss = (String)session.getAttribute("Username");
            session.setAttribute("TaskAssignee", TaskAss);
        }
        
        System.out.println("Task assignee at RI Med " + TaskAss);
        if (TaskAss == null && NextUser.equalsIgnoreCase("N")) {
            String Message =
                "There is no User to Assign the Next Task. Consult the Administrator.";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
            return null;

        }
        String Taske = (String)session.getAttribute("TaskID");
        System.out.println("Tasks " + Taske);
        determinePerformReinsure();
        if (Taske == null) {
            String Message = "No Task Selected";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
            return null;

        }
        try {
            conn = new DBConnector().getDatabaseConn();
            String MyTask = null;
            CallableStatement cst3 = null;
            String Complete =
                "BEGIN TQC_WEB_PKG.check_task_completion(?,?,?,?);END;";
            cst3 = conn.prepareCall(Complete);
            cst3.setString(1, "RIMED");
            cst3.setString(2, (String)session.getAttribute("TaskID"));
            cst3.setInt(3, (Integer)session.getAttribute("sysCode"));
            cst3.registerOutParameter(4, oracle.jdbc.OracleTypes.VARCHAR);
            cst3.execute();
            MyTask = cst3.getString(4);
            if (MyTask.equalsIgnoreCase("N")) {
                String Message =
                    "the Task Selected Does not Correspond to the Activity being Performed. Cannot Complete please " +
                    session.getAttribute("TaskActivityName");
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));
                return null;
            }
            System.out.println("Completing RI med");
            session.setAttribute("RIMed","RiMedSet");
            wf.CompleteTask();
            GlobalCC.INFORMATIONREPORTING("Re-insurance medicals received successfully");


        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        }
        return null;
    }

    public void setPolCoverTypeSel(RichSelectOneChoice polCoverTypeSel) {
        this.polCoverTypeSel = polCoverTypeSel;
    }

    public RichSelectOneChoice getPolCoverTypeSel() {
        return polCoverTypeSel;
    }

    public void setCvtExcessLab(RichOutputLabel cvtExcessLab) {
        this.cvtExcessLab = cvtExcessLab;
    }

    public RichOutputLabel getCvtExcessLab() {
        return cvtExcessLab;
    }

    public void coverChangeListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        Connection conn = null;
        DBConnector db = new DBConnector();
        BigDecimal cvtCode = null;
        //System.out.println("here="+polCoverTypeSel.getValue());
        if (valueChangeEvent.getNewValue() != valueChangeEvent.getOldValue()) {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("FindCoverTypesIterator");

            if (polCoverTypeSel.getValue() != null) {
                Row r =
                    dciter.getRowAtRangeIndex(((Integer)valueChangeEvent.getNewValue()).intValue());

                cvtCode = (BigDecimal)r.getAttribute("PCVT_CVT_CODE");
            }

            try {
                conn = db.getDatabaseConn();
                String sql =
                    "begin ? := LMS_WEB_PKG_GRP.getCoverFacreCeding(?,?); end;";
                CallableStatement cst = conn.prepareCall(sql);
                cst.registerOutParameter(1, OracleTypes.NUMBER);
                cst.setBigDecimal(2,
                                  (BigDecimal)session.getAttribute("endorsementCode"));
                cst.setBigDecimal(3, cvtCode);
                session.setAttribute("cvtCode", cvtCode);
                cst.execute();
                cvtExcessLab.setValue(cst.getBigDecimal(1));
                cst.close();
                conn.close();
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.cvtExcessLab);
            } catch (Exception ex) {
                GlobalCC.EXCEPTIONREPORTING(conn, ex);
            }
        }

    }

    public void setBenIdNo(RichInputText benIdNo) {
        this.benIdNo = benIdNo;
    }

    public RichInputText getBenIdNo() {
        return benIdNo;
    }

    public void setBenRelationType(RichInputText benRelationType) {
        this.benRelationType = benRelationType;
    }

    public RichInputText getBenRelationType() {
        return benRelationType;
    }

    public void setBenComments(RichInputText benComments) {
        this.benComments = benComments;
    }

    public RichInputText getBenComments() {
        return benComments;
    }

    public String showBeneficiaryPopup() {
        // Add event code here...
        studentNames.setValue(null);
        studentSurname.setValue(null);
        ben_type.setValue(null);
        studentMemNo.setValue(null);
        studentDOB.setValue(null);
        benIdNo.setValue(null);
        benRelationType.setValue(null);
        benComments.setValue(null);
        session.setAttribute("action", "A");
        GlobalCC.showPopup("lmsgroup:popup4");
        return null;
    }

    public String showRelationTypePop() {
        // Add event code here...
        GlobalCC.showPopup("lmsgroup:relation_type");
        return null;
    }

    public String addRelationType() {
        // Add event code here...
        Object key2 = relationTypeLOV.getSelectedRowData();
        if (key2 == null) {
            GlobalCC.errorValueNotEntered("No Record Selected");
            return null;
        }
        JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
        if (r == null) {
            GlobalCC.errorValueNotEntered("No Record Selected");
            return null;
        }
        benRelationType.setValue(r.getAttribute("retDesc"));
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.benRelationType);
        GlobalCC.hidePopup("lmsgroup:relation_type");
        return null;
    }

    public void setRelationTypeLOV(RichTable relationTypeLOV) {
        this.relationTypeLOV = relationTypeLOV;
    }

    public RichTable getRelationTypeLOV() {
        return relationTypeLOV;
    }

    public void setPolSignDate(RichInputDate polSignDate) {
        this.polSignDate = polSignDate;
    }

    public RichInputDate getPolSignDate() {
        return polSignDate;
    }

    public void dateChanged(ValueChangeEvent evt) {
        if (evt.getNewValue() != evt.getOldValue()) {
            RichInputDate myInput = (RichInputDate)evt.getComponent();
            Connection conn = null;
            DBConnector MyDB = new DBConnector();
            conn = MyDB.getDatabaseConn();
            CallableStatement lgcallStmt = null;
            System.out.println("Val changed!");
            String clmprocessiong =
                "begin LMS_WEB_PKG_GRP.updatePoldocDate(?,?); end;";
            try {
                lgcallStmt = conn.prepareCall(clmprocessiong);
                lgcallStmt.setBigDecimal(1,
                                         (BigDecimal)session.getAttribute("QuoteCode"));

                String Date = GlobalCC.checkNullValues(evt.getNewValue());
                if (Date == null) {
                    lgcallStmt.setString(2, null);
                } else {
                    if (Date.contains(":")) {
                        Date = GlobalCC.parseDate(Date);
                        lgcallStmt.setString(2, Date);
                    } else {
                        Date = GlobalCC.upDateParseDate(Date);
                        lgcallStmt.setString(2, Date);
                    }
                }
                lgcallStmt.execute();
                lgcallStmt.close();
                conn.close();

            } catch (Exception e) {
                GlobalCC.EXCEPTIONREPORTING(conn, e);
            }
        }
    }

    public void setEarnPrdType(RichSelectOneChoice earnPrdType) {
        this.earnPrdType = earnPrdType;
    }

    public RichSelectOneChoice getEarnPrdType() {
        return earnPrdType;
    }

    public void setPinNo(RichInputText pinNo) {
        this.pinNo = pinNo;
    }

    public RichInputText getPinNo() {
        return pinNo;
    }

    public void setAddrss(RichInputText addrss) {
        this.addrss = addrss;
    }

    public RichInputText getAddrss() {
        return addrss;
    }
    
    public void setJMemLOV(RichTable jMemLOV) {
        this.jMemLOV = jMemLOV;
    }

    public RichTable getJMemLOV() {
        return jMemLOV;
    }

    public void setJMemNo(RichInputText jMemNo) {
        this.jMemNo = jMemNo;
    }

    public RichInputText getJMemNo() {
        return jMemNo;
    }

    public void setJMemSurname(RichInputText jMemSurname) {
        this.jMemSurname = jMemSurname;
    }

    public RichInputText getJMemSurname() {
        return jMemSurname;
    }

    
    public void setJMemSex(RichInputText jMemSex) {
        this.jMemSex = jMemSex;
    }

    public RichInputText getJMemSex() {
        return jMemSex;
    }

    public void setJMemIDNo(RichInputText jMemIDNo) {
        this.jMemIDNo = jMemIDNo;
    }

    public RichInputText getJMemIDNo() {
        return jMemIDNo;
    }

    public void setJMemDOB(RichInputText jMemDOB) {
        this.jMemDOB = jMemDOB;
    }

    public RichInputText getJMemDOB() {
        return jMemDOB;
    }
    
    public void setJMemOtherNames(RichInputText jMemOtherNames) {
        this.jMemOtherNames = jMemOtherNames;
    }

    public RichInputText getJMemOtherNames() {
        return jMemOtherNames;
    }
    
    public String SaveJointMember() {
        DBConnector myConn=new DBConnector();
       Connection conn=myConn.getDatabaseConn();
       CallableStatement cst=null;

      BigDecimal Memb = (BigDecimal)session.getAttribute("MemberNumber");
      if (Memb == null) {
        String Message = "Save Main Member First";
        GlobalCC.INFORMATIONREPORTING(Message);
        return null;
      }

      try {
         String polQuery="begin LMS_WEB_PKG_GRP.createpoljointmember(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?" +
                                                                   ",?,?,?,?);end;";
         cst=conn.prepareCall(polQuery);
         
         if(jMemSurname.getValue()==null){
           cst.setBigDecimal(1, null);
         }else{
           cst.setString(1, jMemSurname.getValue().toString());
         }
         if(jMemOtherNames.getValue()==null){
           cst.setBigDecimal(2, null);
         }else{
           cst.setString(2, jMemOtherNames.getValue().toString());
         }
         if(jMemIDNo.getValue()==null){
           cst.setBigDecimal(3, null);
         }else{
           cst.setString(3, jMemIDNo.getValue().toString());
         }
         if (jMemDOB.getValue()==null){
           cst.setString(4, null);
         }else{
           cst.setString(4, GlobalCC.parseDate(jMemDOB.getValue().toString()));
         }
        
         if(jMemNo.getValue()==null){
           cst.setBigDecimal(5, null);
         }else{
           cst.setString(5, jMemNo.getValue().toString());
         }
         if(jMemSex.getValue()==null){
           cst.setBigDecimal(6, null);
         }else{
           cst.setString(6, jMemSex.getValue().toString());
         }
         cst.setString(7, null);
         cst.setString(8, null);
         cst.setString(9, null);
         cst.setString(10, null);
         cst.setString(11, null);
         cst.setString(12, null);
         cst.setString(13, null);
         cst.setString(14, null);
         cst.setString(15, null);
         cst.setString(16, null);
         cst.setString(17, null);
         cst.setString(18, null);
         cst.setBigDecimal(19, (BigDecimal)session.getAttribute("MemberNumber"));
         cst.setBigDecimal(20, (BigDecimal)session.getAttribute("PolicyCategory"));
         cst.setBigDecimal(21, (BigDecimal)session.getAttribute("prpCode"));
         cst.setBigDecimal(22,(BigDecimal)session.getAttribute("endorsementCode")); 
         cst.setBigDecimal(23,(BigDecimal)session.getAttribute("OccupationCode"));
         cst.setString(24, "N");
         cst.execute(); 
         cst.close();
           conn.close();

          //System.out.println("JOINT MEMBER ADDED. ABOUT TO CALL FINDJOINTMEMBER ITERATOR.");
         ADFUtils.findIterator("FindJointMembersIterator").executeQuery();    
         AdfFacesContext.getCurrentInstance().addPartialTarget(jMemLOV);
         
         String Message = "Joint Member Added";
         FacesContext.getCurrentInstance().addMessage(null, 
                                                      new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                       Message, 
                                                                       Message));

       }
       catch(Exception e) {
         GlobalCC.EXCEPTIONREPORTING(conn, e);
         e.printStackTrace();
       }
       return null;
     }


    public void setBuiltin(RichSelectOneChoice builtin) {
        this.builtin = builtin;
    }

    public RichSelectOneChoice getBuiltin() {
        return builtin;
    }

    public void setAccelerator(RichSelectOneChoice accelerator) {
        this.accelerator = accelerator;
    }

    public RichSelectOneChoice getAccelerator() {
        return accelerator;
    }



  public void setSbuOneDisplay(RichInputText sbuOneDisplay) {
    this.sbuOneDisplay = sbuOneDisplay;
  }

  public RichInputText getSbuOneDisplay() {
    return sbuOneDisplay;
  }

  public void setSBUOneLOV(RichTable SBUOneLOV) {
    this.SBUOneLOV = SBUOneLOV;
  }

  public RichTable getSBUOneLOV() {
    return SBUOneLOV;
  }

  public void setLocOneDisplay(RichInputText locOneDisplay) {
    this.locOneDisplay = locOneDisplay;
  }

  public RichInputText getLocOneDisplay() {
    return locOneDisplay;
  }

  public void setLocOneLOV(RichTable locOneLOV) {
    this.locOneLOV = locOneLOV;
  }

  public RichTable getLocOneLOV() {
    return locOneLOV;
  }


  public void setSBUOneLOV1(RichTable SBUOneLOV1) {
    this.SBUOneLOV1 = SBUOneLOV1;
  }

  public RichTable getSBUOneLOV1() {
    return SBUOneLOV1;
  }

    public void setCatRate(RichInputNumberSpinbox catRate) {
        this.catRate = catRate;
    }

    public RichInputNumberSpinbox getCatRate() {
        return catRate;
    }

    public void setCatRateDivFac(RichInputNumberSpinbox catRateDivFac) {
        this.catRateDivFac = catRateDivFac;
    }

    public RichInputNumberSpinbox getCatRateDivFac() {
        return catRateDivFac;
    }

    public void setCatMaskButton(RichCommandButton catMaskButton) {
        this.catMaskButton = catMaskButton;
    }

    public RichCommandButton getCatMaskButton() {
        return catMaskButton;
    }

    public void setCatSelectRate(RichSelectOneChoice catSelectRate) {
        this.catSelectRate = catSelectRate;
    }

    public RichSelectOneChoice getCatSelectRate() {
        return catSelectRate;
    }

    public void setDjPinNo(RichInputText djPinNo) {
        this.djPinNo = djPinNo;
    }

    public RichInputText getDjPinNo() {
        return djPinNo;
    }

    public void setDjAddress(RichInputText djAddress) {
        this.djAddress = djAddress;
    }

    public RichInputText getDjAddress() {
        return djAddress;
    }

    public void setDependantPinNo(RichInputText dependantPinNo) {
        this.dependantPinNo = dependantPinNo;
    }

    public RichInputText getDependantPinNo() {
        return dependantPinNo;
    }

    public void setDependantAddress(RichInputText dependantAddress) {
        this.dependantAddress = dependantAddress;
    }

    public RichInputText getDependantAddress() {
        return dependantAddress;
    }
}
