package LMSG.view.QuotationProcessing;

import LMSG.view.BPM.wfEngine;
import LMSG.view.BPM.workflowProcessing;
import LMSG.view.Base.ADFUtils;
import LMSG.view.Base.GlobalCC;
import LMSG.view.Base.LOVCC;
import LMSG.view.Base.Rendering;
import LMSG.view.Correspondents.Correspondence;
import LMSG.view.TableTypes.SchoolClasses;
import LMSG.view.connect.DBConnector;

import java.io.PrintStream;

import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import javax.servlet.http.HttpSession;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichDialog;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.data.RichTree;
import oracle.adf.view.rich.component.rich.input.RichChooseDate;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputNumberSpinbox;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanCheckbox;
import oracle.adf.view.rich.component.rich.input.RichSelectManyChoice;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.layout.RichPanelBox;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.layout.RichShowDetailItem;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.output.RichOutputLabel;
import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.DialogEvent;

import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.uicli.binding.JUCtrlHierNodeBinding;
import oracle.jbo.uicli.binding.JUCtrlValueBinding;

import oracle.jdbc.OracleTypes;

import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;

import org.apache.myfaces.trinidad.component.core.layout.CorePanelPage;
import org.apache.myfaces.trinidad.event.SelectionEvent;
import org.apache.myfaces.trinidad.model.RowKeySet;
import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

import LMSG.view.Correspondents.CorrespondenceManipulation;
import LMSG.view.Quotation.Quotations;
import LMSG.view.ecm.EcmUtil;

import java.text.DecimalFormat;
import java.util.ArrayList;

//import org.apache.poi.hssf.record.formula.functions.Int;
import java.util.HashMap;
import java.util.Map;
import org.apache.chemistry.opencmis.client.api.CmisObject;
import org.apache.myfaces.trinidad.model.UploadedFile;
import org.alfresco.cmis.client.AlfrescoDocument;
import org.apache.chemistry.opencmis.client.api.Document;
import org.apache.chemistry.opencmis.client.api.Folder;
import org.apache.chemistry.opencmis.client.api.FolderType;
import org.apache.chemistry.opencmis.client.api.Session;
import org.apache.chemistry.opencmis.client.api.ObjectId;
import org.apache.chemistry.opencmis.commons.exceptions.CmisConnectionException;
import org.apache.poi.hssf.record.formula.functions.Int;


public class QuotManipulation extends LOVCC {
    private RichOutputLabel saLabel;
    private RichTable proposersLOV;
    private RichInputText clientDisplay;
    private RichTable branchesLOV;
    private RichSelectOneChoice earnPrd;
    private RichInputText branchDisplay;
    private RichInputText prodDisplay;
    private RichTable productLOV;
    private RichInputText maskDisplay;
    private RichTable quotPremMaskLOV;
    private RichSelectOneChoice savingsRider;
    private RichSelectOneChoice dependentsCovered;
    private RichSelectOneChoice durationType;
    private RichSelectOneChoice quotationType;
    private RichSelectOneChoice quoCalcType;
    private RichInputText avgANBDisplay;
    private RichInputDate quoEffectiveDate;
    private RichInputText avgIntDisplay;
    private RichInputDate quoCoverToDate;
    private RichSelectOneChoice quoFreqOfPayment;
    private RichInputText quoNoOfMemsDisplay;
    private RichInputText quoTotPremiumDisplay;
    private RichInputText sumAssuredDisplay;
    private RichInputText overrideFclDisplay;
    private RichInputText fclAmountDisplay;
    private RichSelectOneChoice dpdsCovered;
    private RichOutputLabel quoEffectDateDisplay;
    private RichInputText quoOccupationDisplay;
    private RichShowDetailItem quoPensTypeDisplay;
    private RichInputText quoEarningsDisplay;
    private RichInputText quoGuarantPrdDisplay;
    private RichInputText quoPensEscDisplay;
    private RichSelectOneChoice quoPensionEsc;
    private RichInputText quoTotalSalDisplay;
    private RichInputText quoMaleRAgeDisplay;
    private RichInputText quoFemaleRAgeDisplay;
    private RichInputText pensAdminFeeDisplay;
    private RichSelectOneChoice quoNssfInclude;
    private RichInputText nssfAmountDisplay;
    private RichInputText quoTotEmpyrContrDisp;
    private RichInputText empyeeContrDisplay;
    private RichSelectOneChoice contributionType;
    private RichInputText empyrContrDisplay;
    private RichInputText empyeContrRateDisplay;
    private RichInputText fndingRateDisplay;
    private RichInputText pensCommRateDisplay;
    private RichInputText empyrVonContrDisplay;
    private RichInputText empyeVolContrDisplay;
    private RichInputText empyrPensBFDisplay;
    private RichInputText empyePensBFDisplay;
    private RichInputText totPensBFDisplay;
    private RichInputText pensIntRateDisplay;
    private RichInputText totContrDisplayRate;
    private RichTable coverTypesLOV;
    private RichSelectOneChoice quoFCLCalcType;
    private RichInputText quoFeaturesDisplay;
    private RichInputText letterOpenDisplay;
    private RichCommandButton letterOpenRemarks;
    private RichInputText letterCloseDisplay;
    private RichInputText provIDDisplay;
    private RichInputText provDescDisplay;
    private RichInputText provEditableDisplay;
    private RichTable productProvLOV;
    private RichTable quotationsProvisionLOV;
    private RichInputText categIDDisplay;
    private RichInputText categDescDisplay;
    private RichInputText categPeriodDisplay;
    private RichTable categoryLOV;
    private RichInputText coverTypeDisplay;
    private RichInputText coverIDDisplay;
    private RichTable coverTypesDpdsLOV;
    private RichInputText relationDisplay;
    private RichInputText limitAmtDisplay;
    private RichInputText dpdMaxTypeDisplay;
    private RichTable coverDependentsLOV;
    private RichTable dependentLimits;
    private RichTable quotMembersLOV;
    private RichInputText memNoDisplay;
    private RichInputText surnameDisplay;
    private RichInputText otherNamesDisplay;
    private RichInputText yearDisplay;
    private RichInputDate memDOBDisplay;
    private RichSelectOneChoice memberGender;
    private RichInputText dpdTypeDisplay;
    private RichTable dependentsLOV;
    private RichInputText memCategoryDisplay;
    private RichTable categoryDpdLOV;
    private RichInputText idNumberDisplay;
    private RichInputText sysPressureDisplay;
    private RichInputText diasPressureDisplay;
    private RichInputText weightDisplay;
    private RichInputText heightDisplay;
    private RichInputText occupationDisplay;
    private RichTable occupationsLOV;
    private RichInputDate loanIssueDate;
    private RichInputText laonAmtDisplay;
    private RichInputText loanIntDisplay;
    private RichInputText laonRepayPrdDisplay;
    private RichInputText savingsAmountDisplay;
    private RichInputText annualEarningsDisplay;
    private RichInputText monthlyEarningsDisplay;
    private RichInputDate dateOfJoining;
    private RichInputText yearsOfService;
    private RichInputText futYearsofService;
    private RichInputText totalServiceYears;
    private RichSelectOneChoice voluContrType;
    private RichInputText empyeVolContr;
    private RichInputText empyrVolContr;
    private RichInputText empyrPensionBF;
    private RichInputText empyePensionBF;
    private RichInputText totalPensionBF;
    private RichInputText memberANBDisplay;
    private RichInputText earningsPrdDisplay;
    private RichInputText depMemNoDisplay;
    private RichInputText depSurnameDisplay;
    private RichInputText depOtherNamesDisplay;
    private RichSelectOneChoice dpdGender;
    private RichInputText depDependentTypeDisplay;
    private RichInputText depIDNoDisplay;
    private RichInputDate depDOBDisplay;
    private RichInputText jointmemNoDisplay;
    private RichInputText jointmemSurnameDisplay;
    private RichInputText jointmemothernamesDispl;
    private RichInputText jointDpdDisplay;
    private RichInputDate jointMemDOB;
    private RichInputText jointMemIDNo;
    private RichSelectOneChoice jointMemGender;
    private RichSelectOneChoice grpLifeRider1;
    private RichInputText laonIssueDate;
    private RichChooseDate memDOBDateDisplay;
    private RichInputText memDOBDisp;
    private RichSelectOneChoice quoPensionTypeDispl;
    private RichInputText quoEffectiveDateDisp;
    private RichTable agentsLOV;
    private RichInputText quotNumberDisplay;
    private RichInputText taxesDisplay;
    private RichTable taxesLOV;
    private RichInputText taxRateDisplay;
    private RichInputText taxAmtDisplay;
    private RichTable taxesTable;
    private RichTable conProductsLOV;
    private RichInputText conProductDisplay;
    private RichOutputText conProdDescDisplay;
    private RichInputText conQuotationNoDispl;
    private RichTable okQuotationsLOV;
    private RichOutputText conClientDisplay;
    private RichInputText policyNumberDisplay;
    private RichDialog policyNoGeneration;
    private RichTable clientsLOV;
    private RichInputText clientsDisplay;
    private RichInputText brhDisplay;
    private RichTable brhLOV;
    private RichInputText products;
    private RichTable productsoneLOV;
    private RichTable agentsOneLOV;
    private RichInputText agentsOneDisplay;
    private RichInputText quotNumber;
    private RichInputText occupationOneDisplay;
    private RichTable premiumMasksLOV;
    private RichInputText premMasksDisplay;
    private RichSelectOneChoice quotationCalcType;
    private RichSelectOneChoice quotationCovers;
    private RichSelectOneChoice quotationDurationType;
    private RichSelectOneChoice frequencyOfPay;
    private RichInputText quotationNumber;
    private RichInputDate quotationEffectiveDate;
    private RichSelectOneChoice groupLifeRider;
    private RichSelectOneChoice loansSavingsRider;
    private RichSelectOneChoice pensionType;
    private RichInputText guaranteePrdDisplay;
    private RichInputText pensEscDisplay;
    private RichSelectOneChoice pensPayFrequency;
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
    private RichTable quotCoverTypes;
    private RichTable quotationTaxes;
    private RichTable quotCategoriesLOV;
    private RichInputText categID;
    private RichInputText categDescription;
    private RichInputText categoryPeriod;
    private RichTable dpdCategLOV;
    private RichInputText dependentCategory;
    private RichInputText dpdLimitAmount;
    private RichInputText dependentType;
    private RichTable dependentTypesLOV;
    private RichTable dependentCoverTypes;
    private RichInputText dependentANB;
    private RichInputText dpdMonthlyIncome;
    private RichTable quotationDependentsLOV;
    private String saveEdit = "Y";
    private RichInputText provID;
    private RichInputText provisions;
    private RichSelectOneChoice provEditable;
    private RichTable productProvisionsLOV;
    private RichTable coverProvisionsLOV;
    private RichTable coverTypeProvisions;
    private RichInputText oldANBDisplay;
    private RichInputText newANBDisplay;
    private RichOutputText oldANBDisp;
    private RichTable memberCoversLOV;
    private RichTable prodCoversLOV;
    private RichInputText prodCoverDisplay;
    private RichInputText coverSADisplay;
    private RichInputText coverButChargePremium;
    private RichInputText discLoadRateDisplay;
    private RichSelectOneChoice discLoadChoice;
    private RichPanelBox searchResults;
    private RichPanelBox searchQuote;
    private RichPanelBox quoteBasicDetailsTab;
    protected static String quoteCover;
    private RichPanelBox pensionsTab;
    private RichPanelBox coverDetailsTab;
    private RichPanelBox taxesTab;
    private RichPanelBox categoryDetailsTab;
    private RichPanelBox quoteMembersTab;
    private RichPanelBox provisionsTab;
    private CorePanelPage membersUpload;
    private RichPanelBox memCovers;
    private RichCommandButton finishButton;
    private RichCommandButton computePremiumButton;
    private RichCommandButton nextButton;
    private RichCommandButton prevButton;
    private RichPanelBox memberUpload2;
    private RichPanelGroupLayout membersImport;
    private RichPanelBox singleMember;
    private RichTable allMembers;
    private RichPanelBox catLimitTabs;
    private RichTable allTaxesLOV;
    private RichOutputText taxSel;
    private RichInputText taxRate;
    private RichSelectOneChoice applLevel;
    private RichInputText taxAmt;
    private RichInputText maxType;
    private RichSelectBooleanCheckbox provisionsCbox;
    private RichInputDate dob;
    private RichInputDate memdob;
    private RichInputText quotememANB;
    private RichCommandButton anotherMem2;
    private RichTable memLimits;
    public static String ANBMem;
    protected String MemGrpLifeRider;
    private RichInputNumberSpinbox annualEarnings;
    private RichInputNumberSpinbox monthlyEarnings;
    private RichInputText penEarnEsc;
    private RichOutputLabel categoryDisplay;
    private HtmlPanelGrid categoryPanel;
    private RichSelectBooleanCheckbox grpLifeRider;
    private RichInputText memNo;
    private RichInputText memSurname;
    private RichInputText memOtherNames;
    private RichInputText idNo;
    
    private RichInputText pinNo;
    private RichInputText addrss;    
    
    private RichInputText yeat;
    private RichInputText weight;
    private RichInputText height;
    private RichInputText depTypeDesc;
    private RichInputText categoryDesc;
    private RichInputText sysPres;
    private RichInputText diaPres;
    private RichInputText occupationDesc;
    private RichSelectOneChoice memSex;
    private RichInputDate loanDate;
    private RichInputDate memloanDate;
    private RichInputNumberSpinbox origloanAmt;
    private RichInputText origRepayPeriod;
    private RichInputText loanInt;
    private RichInputNumberSpinbox savingAmt;
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
    private RichTable memcategoryLOV;
    private RichTable occupationLOV;
    private RichCommandButton addMember;
    private RichInputText djMemNo;
    private RichInputText djSurname;
    private RichInputText djOtherNames;
    private RichSelectOneChoice djSex;
    private RichInputText djIDNo;
    private RichInputDate djDOB;
    private RichTable memDependantsLOV;
    private RichTable covProvLOV;
    private RichTable coinsurerLOV;
    private RichOutputText coinsurerLabel;
    private RichInputNumberSpinbox coShare;
    private RichInputNumberSpinbox coServFee;
    protected static BigDecimal coinsurerAgent;
    protected static BigDecimal coinsurerCode;
    protected static boolean CoinsureShare = false;
    private RichTable quoteCoinsurersLOV;
    private RichSelectOneChoice coLeadFollow;
    private RichInputNumberSpinbox leaderShare;
    private RichSelectBooleanCheckbox coinsCbox;
    private RichPanelBox coinsureTab;
    private RichOutputLabel lbel;
    private RichShowDetailItem depsTab;
    private RichShowDetailItem jointTab;
    private RichInputText avANB;
    private RichOutputLabel avANBLabel;
    private RichOutputText edCoverlabel;
    private RichInputText edcoverButChargePremium;
    private RichSelectOneChoice eddiscLoadChoice;
    private RichInputText eddiscLoadRateDisplay;
    private RichOutputText edtaxSel;
    private RichSelectOneChoice edapplLevel;
    private RichInputText edtaxRate;
    private RichInputText edtaxAmt;
    private RichOutputText coverDescLabel;
    private RichOutputText depTypesLabel;
    private RichInputText edLimitAmt;
    private RichInputText edMaxNo;
    private RichOutputText cvrTypeLabel;
    private RichOutputText cvrDisp2;
    private RichTable manipulationLOV;
    private RichTable jointMemLOV;
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
    private RichTable usersLOV;
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    private RichInputText ticketRemarks;
    private RichTable depTypeLOV2;
    private RichInputDate wetDate;
    private RichOutputText memCoverDisplay;
    private RichInputText memHeight;
    private RichInputText memWeight;
    private RichInputText memSysPr;
    private RichInputText memDiaPr;
    private RichInputText weightlding;
    private RichInputText memBPressLoading;
    private RichSelectOneChoice memLoadType;
    private RichInputText memloadDivFac;
    private RichInputText memloadRate;
    private RichInputText memEarningAmt;
    private RichOutputText memCoverTypeDisplay;
    private RichInputText memEarningPeriod;
    private RichInputText memOrigLnAmt;
    private RichInputText memLoanAmt;
    private RichInputText memLoanInt;
    private RichInputDate memLoanIssDate;
    private RichInputText memSavingAmt;
    private RichOutputLabel depTypeLabel;
    private HtmlPanelGrid depTypeDtls;
    private RichTable allDepsLOV;
    private RichInputText dtyDesc;
    private RichOutputLabel avMemEarnlabel;
    private RichInputText totalMem;
    private RichInputText cvrMultipleEarningsPeriod;
    private RichInputText cvrCategory;
    private RichOutputLabel totalMemLabel;
    private RichOutputLabel multiEarnsPeriodlbl;
    private RichOutputLabel cvrCategorylabel;
    private RichInputText divFactor;
    private RichInputText pensAverageANB;
    private RichInputText pensAverageEarnings;
    private RichSelectOneChoice annEscalation;
    private RichSelectManyChoice annPaymentStructure;
    private RichSelectOneChoice annuityOption;
    private RichSelectOneChoice annPymtStructure;
    private RichSelectOneChoice durationTermType;
    private RichPanelBox schoolFeesTab;
    private RichInputText classTermDisplay;
    private RichTable classesCategoriesLOV;
    private RichInputText termFeeDisplay;
    private RichTable classTermLimitsLOV;
    private RichTable memberBeneficiariesLOV;
    private RichInputText pastLiability;
    private RichInputText futureLiability;
    private RichInputText totalLiability;
    private RichInputText annuityAmount;
    private RichInputText unitRateDisplay;
    private RichSelectOneChoice unitRateDivFactor;
    private RichTree categoryTree;
    private RichTable classesLOV;
    private RichInputText studentNames;
    private RichInputText studentSurname;
    private RichInputText studentMemNo;
    private RichInputDate studentDOB;
    private RichSelectOneChoice studentClass;
    private RichSelectOneChoice studentSex;
    private RichInputText benInvestRate;
    private RichInputText termPayoutRate;
    private RichInputText annInterestRate;
    private RichInputText annAdminCharge;
    private RichInputText schemeLegalAge;
    private RichTable anndependentsLOV;
    private RichInputText totAnnInvestment;
    private RichInputText totTerminalBenefits;
    private RichInputText schLegalAge;
    private RichInputText schAdminCharge;
    private RichInputText annuityIntrRate;
    private RichInputText annInvestRate;
    private RichInputText terminalPayoutRate;
    private RichOutputLabel mainCoverLabel;
    private RichSelectOneChoice mainCover;
    private RichOutputLabel percMainCvtLabel;
    private RichInputText percMainCvt;
    private RichSelectOneChoice productCoverDropBox;
    private RichOutputLabel prdTypeLabel;
    private RichSelectOneChoice dpdCoverType;
    private RichSelectOneChoice dependentTypeDisplay;
    private RichOutputLabel coinLeadFollowLabel;
    private RichSelectOneChoice coinLeadFollowSelect;
    private RichTable annPartialPayments;
    private RichSelectOneChoice pensionMode;
    private RichSelectOneChoice osLoanCalculation;
    private RichInputText marketerDisplay;
    private RichTable marketerLOV;
    private RichOutputLabel loanAmtLabel;
    private RichInputText cvrLoanAmt;
    private RichOutputLabel loanRepyLabel;
    private RichInputText cvrLoanPrd;
    private RichOutputLabel loanIntLabel;
    private RichInputText cvrLoanInt;
    private RichOutputLabel savingsAmtLabel;
    private RichInputText cvrSavingsAmt;
    private RichTable allClassesTable;
    private RichInputText categoryFees;
    private RichInputText categoryStudents;
    private RichSelectBooleanCheckbox classesCbox;
    private RichInputText termDuration;
    private RichInputText feesAmount;
    private RichInputText noOfStudents;
    private RichInputText discDivFactor;
    private RichInputText discRateDisplay;
    private RichSelectOneChoice discChoice;
    private RichTable quoMemberExceptions;
    private RichSelectOneChoice rateSelection;
    private RichInputText maskDesc;
    private RichTable maskTable;
    private RichInputNumberSpinbox coverRate;
    private RichInputNumberSpinbox coverRateDivFactor;
    private RichCommandButton maskButton;
    private RichInputText catMaskDesc;
    private RichTable catMaskTable;
    private RichOutputLabel weTLabel;
    private RichSelectOneChoice umbrellaDurationType;
    private RichOutputLabel umbrellaDurationLabel;
    private RichSelectOneChoice subdivision;
    private RichInputText divShortDesc;
    private RichInputText divDesc;
    private RichTable quoteDivisionsTable;
    private RichTable memberSDivTable;
    private RichInputText dpdMinAmount;
    private RichOutputLabel totMemEarningLab;
    private RichInputText totMemEarnings;
    private RichOutputLabel prdTypeLabel2;
    private RichOutputLabel totalMemEarninglbl;
    private RichInputText totalMemEarning;
    private HtmlPanelGrid multiprdPanel;
    private RichOutputLabel totLoanAmtLabel;
    private RichInputText totLoanAmt;
    private RichOutputLabel avCoverPerMemLabel;
    private RichInputText avCoverPerMem;
    private RichCommandButton premMaskBut;
    private RichInputText totClaimPaid;
    private RichInputText totPremPaid;
    private RichInputText ageLoadFactor;
    private RichOutputLabel discLoadRateDisplayLab;
    private RichOutputLabel divFactorLab;
    private RichOutputLabel ageLoadFactorLab;
    private RichPanelBox coversPanel;
    private RichInputText pensionHistIntRate;
    private RichSelectOneChoice currencySymbol;
    private RichInputText currExchangeRate;
    private RichSelectOneChoice currExchRateType;
    private RichOutputText currExchangeRateLab;
    private HtmlPanelGrid currencyGrid;
    private RichInputText avMemberEarnings;
    private RichInputText bmiRate;
    private RichTable classOccLOV;
    private RichTable productPlan;
    private RichInputText planTF;
    private RichSelectBooleanCheckbox tender;
    private RichInputText loanInstallmentAmt;
    private RichSelectOneChoice loanInstRepayFreq;
    private HtmlPanelGrid aggCatPanel;
    private RichTable aggregateCatLOV;
    private RichOutputLabel avgLabAggregate;
    private RichInputText tenderPrd;
    private HtmlPanelGrid tenderGrid;
    private RichInputNumberSpinbox tenderPrdInput;
    private RichInputText covLimitInput;
    private RichInputText srchMemNo;
    private RichInputText srchMemName;
    private RichSelectOneChoice earnPrdType;
    private RichOutputLabel tenderPeriodLab;
    private RichInputText tenderPeriodTF;
    private RichInputText totalMember;
    private RichOutputLabel aggQuotePlanLbl;
    private RichInputText aggQuotePlan;
    private RichDialog dependantDialog;
    private RichSelectOneChoice builtIn;
    private RichSelectOneChoice accelerator;
    private RichInputText sbuOneDisplay;
    private RichInputText locOneDisplay;
    private RichTable SBUOneLOV;
    private RichTable locOneLOV;
    
    private RichInputText djntMemNo;
    private RichInputText djntSurname;
    private RichInputText djntOtherNames;
    private RichSelectOneChoice djntSex;
    private RichInputText djntIDNo;
    private RichInputDate djntDOB;
    private RichInputText dpinNo;
    private RichInputText djAddress;
    private RichInputText djntPinNo;
    private RichInputText djntAddress;
    
    private RichTable currencyLOV;
    private RichInputText currencyTF;


    public void setProposersLOV(RichTable proposersLOV) {
        this.proposersLOV = proposersLOV;
    }

    public RichTable getProposersLOV() {
        return this.proposersLOV;
    }

    public String AssignProposers() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findProposersIterator");
        RowKeySet set = this.proposersLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
            this.clientDisplay.setValue(r.getAttribute("CLIENT"));
            this.session.setAttribute("prpCode", r.getAttribute("PRP_CODE"));
        }

        return null;
    }

    public void setClientDisplay(RichInputText clientDisplay) {
        this.clientDisplay = clientDisplay;
    }

    public RichInputText getClientDisplay() {
        return this.clientDisplay;
    }

    public void setBranchesLOV(RichTable branchesLOV) {
        this.branchesLOV = branchesLOV;
    }

    public RichTable getBranchesLOV() {
        return this.branchesLOV;
    }

    public void setBranchDisplay(RichInputText branchDisplay) {
        this.branchDisplay = branchDisplay;
    }

    public RichInputText getBranchDisplay() {
        return this.branchDisplay;
    }

    public String AssignBranches() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindBranchesIterator");
        RowKeySet set = this.brhLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
            this.brhDisplay.setValue(r.getAttribute("BRN_NAME"));
            this.session.setAttribute("brnCode", r.getAttribute("BRN_CODE"));
            this.session.setAttribute("branchCode",
                                      r.getAttribute("BRN_CODE"));
            this.session.setAttribute("brnName", r.getAttribute("BRN_NAME"));
        }

        return null;
    }

    public void setProdDisplay(RichInputText prodDisplay) {
        this.prodDisplay = prodDisplay;
    }

    public RichInputText getProdDisplay() {
        return this.prodDisplay;
    }

    public void setProductLOV(RichTable productLOV) {
        this.productLOV = productLOV;
    }

    public RichTable getProductLOV() {
        return this.productLOV;
    }

    public String AssignProducts() {
        DCIteratorBinding dciter = ADFUtils.findIterator("prodIterator");
        RowKeySet set = this.productLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
            this.prodDisplay.setValue(r.getAttribute("prodDesc"));
        }

        return null;
    }

    public void setMaskDisplay(RichInputText maskDisplay) {
        this.maskDisplay = maskDisplay;
    }

    public RichInputText getMaskDisplay() {
        return this.maskDisplay;
    }

    public void setQuotPremMaskLOV(RichTable quotPremMaskLOV) {
        this.quotPremMaskLOV = quotPremMaskLOV;
    }

    public RichTable getQuotPremMaskLOV() {
        return this.quotPremMaskLOV;
    }

    public String AssignPremMask() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findPremiumMaskIterator");
        RowKeySet set = this.quotPremMaskLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
            this.maskDisplay.setValue(r.getAttribute("PMAS_SHT_DESC"));
            this.session.setAttribute("pmasCode", r.getAttribute("PMAS_CODE"));
        }

        return null;
    }

    public void setSavingsRider(RichSelectOneChoice savingsRider) {
        this.savingsRider = savingsRider;
    }

    public RichSelectOneChoice getSavingsRider() {
        return this.savingsRider;
    }

    public void setDependentsCovered(RichSelectOneChoice dependentsCovered) {
        this.dependentsCovered = dependentsCovered;
    }

    public RichSelectOneChoice getDependentsCovered() {
        return this.dependentsCovered;
    }

    public void setDurationType(RichSelectOneChoice durationType) {
        this.durationType = durationType;
    }

    public RichSelectOneChoice getDurationType() {
        return this.durationType;
    }

    public void setQuotationType(RichSelectOneChoice quotationType) {
        this.quotationType = quotationType;
    }

    public RichSelectOneChoice getQuotationType() {
        return this.quotationType;
    }

    public void setQuoCalcType(RichSelectOneChoice quoCalcType) {
        this.quoCalcType = quoCalcType;
    }

    public RichSelectOneChoice getQuoCalcType() {
        return this.quoCalcType;
    }

    public void setAvgANBDisplay(RichInputText avgANBDisplay) {
        this.avgANBDisplay = avgANBDisplay;
    }

    public RichInputText getAvgANBDisplay() {
        return this.avgANBDisplay;
    }

    public void setQuoEffectiveDate(RichInputDate quoEffectiveDate) {
        this.quoEffectiveDate = quoEffectiveDate;
    }

    public RichInputDate getQuoEffectiveDate() {
        return this.quoEffectiveDate;
    }

    public void setAvgIntDisplay(RichInputText avgIntDisplay) {
        this.avgIntDisplay = avgIntDisplay;
    }

    public RichInputText getAvgIntDisplay() {
        return this.avgIntDisplay;
    }

    public void setQuoCoverToDate(RichInputDate quoCoverToDate) {
        this.quoCoverToDate = quoCoverToDate;
    }

    public RichInputDate getQuoCoverToDate() {
        return this.quoCoverToDate;
    }

    public void setQuoFreqOfPayment(RichSelectOneChoice quoFreqOfPayment) {
        this.quoFreqOfPayment = quoFreqOfPayment;
    }

    public RichSelectOneChoice getQuoFreqOfPayment() {
        return this.quoFreqOfPayment;
    }

    public void setQuoNoOfMemsDisplay(RichInputText quoNoOfMemsDisplay) {
        this.quoNoOfMemsDisplay = quoNoOfMemsDisplay;
    }

    public RichInputText getQuoNoOfMemsDisplay() {
        return this.quoNoOfMemsDisplay;
    }

    public void setQuoTotPremiumDisplay(RichInputText quoTotPremiumDisplay) {
        this.quoTotPremiumDisplay = quoTotPremiumDisplay;
    }

    public RichInputText getQuoTotPremiumDisplay() {
        return this.quoTotPremiumDisplay;
    }

    public void setSumAssuredDisplay(RichInputText sumAssuredDisplay) {
        this.sumAssuredDisplay = sumAssuredDisplay;
    }

    public RichInputText getSumAssuredDisplay() {
        return this.sumAssuredDisplay;
    }

    public void setOverrideFclDisplay(RichInputText overrideFclDisplay) {
        this.overrideFclDisplay = overrideFclDisplay;
    }

    public RichInputText getOverrideFclDisplay() {
        return this.overrideFclDisplay;
    }

    public void setFclAmountDisplay(RichInputText fclAmountDisplay) {
        this.fclAmountDisplay = fclAmountDisplay;
    }

    public RichInputText getFclAmountDisplay() {
        return this.fclAmountDisplay;
    }

    public void setDpdsCovered(RichSelectOneChoice dpdsCovered) {
        this.dpdsCovered = dpdsCovered;
    }

    public RichSelectOneChoice getDpdsCovered() {
        return this.dpdsCovered;
    }

    public void setQuoEffectDateDisplay(RichOutputLabel quoEffectDateDisplay) {
        this.quoEffectDateDisplay = quoEffectDateDisplay;
    }

    public RichOutputLabel getQuoEffectDateDisplay() {
        return this.quoEffectDateDisplay;
    }

    public void setQuoOccupationDisplay(RichInputText quoOccupationDisplay) {
        this.quoOccupationDisplay = quoOccupationDisplay;
    }

    public RichInputText getQuoOccupationDisplay() {
        return this.quoOccupationDisplay;
    }

    public void setQuoPensTypeDisplay(RichShowDetailItem quoPensTypeDisplay) {
        this.quoPensTypeDisplay = quoPensTypeDisplay;
    }

    public RichShowDetailItem getQuoPensTypeDisplay() {
        return this.quoPensTypeDisplay;
    }

    public void setQuoEarningsDisplay(RichInputText quoEarningsDisplay) {
        this.quoEarningsDisplay = quoEarningsDisplay;
    }

    public RichInputText getQuoEarningsDisplay() {
        return this.quoEarningsDisplay;
    }

    public void setQuoGuarantPrdDisplay(RichInputText quoGuarantPrdDisplay) {
        this.quoGuarantPrdDisplay = quoGuarantPrdDisplay;
    }

    public RichInputText getQuoGuarantPrdDisplay() {
        return this.quoGuarantPrdDisplay;
    }

    public void setQuoPensEscDisplay(RichInputText quoPensEscDisplay) {
        this.quoPensEscDisplay = quoPensEscDisplay;
    }

    public RichInputText getQuoPensEscDisplay() {
        return this.quoPensEscDisplay;
    }

    public void setQuoPensionEsc(RichSelectOneChoice quoPensionEsc) {
        this.quoPensionEsc = quoPensionEsc;
    }

    public RichSelectOneChoice getQuoPensionEsc() {
        return this.quoPensionEsc;
    }

    public void setQuoTotalSalDisplay(RichInputText quoTotalSalDisplay) {
        this.quoTotalSalDisplay = quoTotalSalDisplay;
    }

    public RichInputText getQuoTotalSalDisplay() {
        return this.quoTotalSalDisplay;
    }

    public void setQuoMaleRAgeDisplay(RichInputText quoMaleRAgeDisplay) {
        this.quoMaleRAgeDisplay = quoMaleRAgeDisplay;
    }

    public RichInputText getQuoMaleRAgeDisplay() {
        return this.quoMaleRAgeDisplay;
    }

    public void setQuoFemaleRAgeDisplay(RichInputText quoFemaleRAgeDisplay) {
        this.quoFemaleRAgeDisplay = quoFemaleRAgeDisplay;
    }

    public RichInputText getQuoFemaleRAgeDisplay() {
        return this.quoFemaleRAgeDisplay;
    }

    public void setPensAdminFeeDisplay(RichInputText pensAdminFeeDisplay) {
        this.pensAdminFeeDisplay = pensAdminFeeDisplay;
    }

    public RichInputText getPensAdminFeeDisplay() {
        return this.pensAdminFeeDisplay;
    }

    public void setQuoNssfInclude(RichSelectOneChoice quoNssfInclude) {
        this.quoNssfInclude = quoNssfInclude;
    }

    public RichSelectOneChoice getQuoNssfInclude() {
        return this.quoNssfInclude;
    }

    public void setNssfAmountDisplay(RichInputText nssfAmountDisplay) {
        this.nssfAmountDisplay = nssfAmountDisplay;
    }

    public RichInputText getNssfAmountDisplay() {
        return this.nssfAmountDisplay;
    }

    public void setQuoTotEmpyrContrDisp(RichInputText quoTotEmpyrContrDisp) {
        this.quoTotEmpyrContrDisp = quoTotEmpyrContrDisp;
    }

    public RichInputText getQuoTotEmpyrContrDisp() {
        return this.quoTotEmpyrContrDisp;
    }

    public void setEmpyeeContrDisplay(RichInputText empyeeContrDisplay) {
        this.empyeeContrDisplay = empyeeContrDisplay;
    }

    public RichInputText getEmpyeeContrDisplay() {
        return this.empyeeContrDisplay;
    }

    public void setContributionType(RichSelectOneChoice contributionType) {
        this.contributionType = contributionType;
    }

    public RichSelectOneChoice getContributionType() {
        return this.contributionType;
    }

    public void setEmpyrContrDisplay(RichInputText empyrContrDisplay) {
        this.empyrContrDisplay = empyrContrDisplay;
    }

    public RichInputText getEmpyrContrDisplay() {
        return this.empyrContrDisplay;
    }

    public void setEmpyeContrRateDisplay(RichInputText empyeContrRateDisplay) {
        this.empyeContrRateDisplay = empyeContrRateDisplay;
    }

    public RichInputText getEmpyeContrRateDisplay() {
        return this.empyeContrRateDisplay;
    }

    public void setFndingRateDisplay(RichInputText fndingRateDisplay) {
        this.fndingRateDisplay = fndingRateDisplay;
    }

    public RichInputText getFndingRateDisplay() {
        return this.fndingRateDisplay;
    }

    public void setPensCommRateDisplay(RichInputText pensCommRateDisplay) {
        this.pensCommRateDisplay = pensCommRateDisplay;
    }

    public RichInputText getPensCommRateDisplay() {
        return this.pensCommRateDisplay;
    }

    public void setEmpyrVonContrDisplay(RichInputText empyrVonContrDisplay) {
        this.empyrVonContrDisplay = empyrVonContrDisplay;
    }

    public RichInputText getEmpyrVonContrDisplay() {
        return this.empyrVonContrDisplay;
    }

    public void setEmpyeVolContrDisplay(RichInputText empyeVolContrDisplay) {
        this.empyeVolContrDisplay = empyeVolContrDisplay;
    }

    public RichInputText getEmpyeVolContrDisplay() {
        return this.empyeVolContrDisplay;
    }

    public void setEmpyrPensBFDisplay(RichInputText empyrPensBFDisplay) {
        this.empyrPensBFDisplay = empyrPensBFDisplay;
    }

    public RichInputText getEmpyrPensBFDisplay() {
        return this.empyrPensBFDisplay;
    }

    public void setEmpyePensBFDisplay(RichInputText empyePensBFDisplay) {
        this.empyePensBFDisplay = empyePensBFDisplay;
    }

    public RichInputText getEmpyePensBFDisplay() {
        return this.empyePensBFDisplay;
    }

    public void setTotPensBFDisplay(RichInputText totPensBFDisplay) {
        this.totPensBFDisplay = totPensBFDisplay;
    }

    public RichInputText getTotPensBFDisplay() {
        return this.totPensBFDisplay;
    }

    public void setPensIntRateDisplay(RichInputText pensIntRateDisplay) {
        this.pensIntRateDisplay = pensIntRateDisplay;
    }

    public RichInputText getPensIntRateDisplay() {
        return this.pensIntRateDisplay;
    }

    public void setTotContrDisplayRate(RichInputText totContrDisplayRate) {
        this.totContrDisplayRate = totContrDisplayRate;
    }

    public RichInputText getTotContrDisplayRate() {
        return this.totContrDisplayRate;
    }

    public String DeleteCoverType() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findQuoteCoverTypesIterator");
        RowKeySet set = this.coverTypesLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
            this.session.setAttribute("qcvtCode", r.getAttribute("QCVT_CODE"));
        }

        Connection conn = new DBConnector().getDatabaseConn();
        try {
            CallableStatement csDeleteCover =
                conn.prepareCall("BEGIN LMS_WEB_PKG_GRP.delete_quot_cover_type(?,?);END;");
            csDeleteCover.setBigDecimal(1,
                                        (BigDecimal)this.session.getAttribute("QuoteCode"));
            csDeleteCover.setBigDecimal(2,
                                        (BigDecimal)this.session.getAttribute("qcvtCode"));
            csDeleteCover.execute();
            conn.close();
            ADFUtils.findIterator("findQuoteCoverTypesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.coverTypesLOV);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public void setCoverTypesLOV(RichTable coverTypesLOV) {
        this.coverTypesLOV = coverTypesLOV;
    }

    public RichTable getCoverTypesLOV() {
        return this.coverTypesLOV;
    }

    public String DetermineFCL() {
        String fclQuery = "BEGIN LMS_WEB_PKG_GRP.determine_fcl(?,?,?);END;";
        Connection conn = new DBConnector().getDatabaseConn();
        CallableStatement cstDetFCL = null;
        try {
            cstDetFCL = conn.prepareCall(fclQuery);
            cstDetFCL.setString(1,
                                (String)this.session.getAttribute("fclCalcType"));
            cstDetFCL.setBigDecimal(2,
                                    (BigDecimal)this.session.getAttribute("ProductCode"));
            cstDetFCL.setBigDecimal(3,
                                    (BigDecimal)this.session.getAttribute("QuoteCode"));
            cstDetFCL.execute();
            conn.close();
            ADFUtils.findIterator("findQuotation1Iterator").executeQuery();

            GlobalCC.sysInformation("FCL Successfully Computed");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public void setQuoFCLCalcType(RichSelectOneChoice quoFCLCalcType) {
        this.quoFCLCalcType = quoFCLCalcType;
    }

    public RichSelectOneChoice getQuoFCLCalcType() {
        return this.quoFCLCalcType;
    }

    public void getFCLCalcType(ValueChangeEvent valueChangeEvent) {
        if (this.quoFCLCalcType.getValue() == null)
            this.session.setAttribute("fclCalcType", null);
        else
            this.session.setAttribute("fclCalcType",
                                      this.quoFCLCalcType.getValue().toString());
    }

    public void setQuoFeaturesDisplay(RichInputText quoFeaturesDisplay) {
        this.quoFeaturesDisplay = quoFeaturesDisplay;
    }

    public RichInputText getQuoFeaturesDisplay() {
        return this.quoFeaturesDisplay;
    }

    public String AttachFeatures() {
        Connection conn = new DBConnector().getDatabaseConn();
        try {
            CallableStatement rsFeature =
                conn.prepareCall("BEGIN LMS_WEB_CURSOR_GRP.attachFeatures(?,?);END;");
            rsFeature.registerOutParameter(1, -10);
            rsFeature.setBigDecimal(2,
                                    (BigDecimal)this.session.getAttribute("ProductCode"));
            rsFeature.execute();
            ResultSet rs = (ResultSet)rsFeature.getObject(1);
            while (rs.next()) {
                this.quoFeaturesDisplay.setValue(rs.getString(1));
            }
            conn.close();
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        }
        return null;
    }

    public void setLetterOpenDisplay(RichInputText letterOpenDisplay) {
        this.letterOpenDisplay = letterOpenDisplay;
    }

    public RichInputText getLetterOpenDisplay() {
        return this.letterOpenDisplay;
    }

    public String AttachLetterOpenRemarks() {
        Connection conn = new DBConnector().getDatabaseConn();
        try {
            CallableStatement rsFeature =
                conn.prepareCall("BEGIN LMS_WEB_CURSOR_GRP.attachOpenLetter(?);END;");
            rsFeature.registerOutParameter(1, -10);
            rsFeature.execute();
            ResultSet rs = (ResultSet)rsFeature.getObject(1);
            while (rs.next()) {
                this.letterOpenDisplay.setValue(rs.getString(1));
            }
            conn.close();
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        }
        return null;
    }

    public void setLetterOpenRemarks(RichCommandButton letterOpenRemarks) {
        this.letterOpenRemarks = letterOpenRemarks;
    }

    public RichCommandButton getLetterOpenRemarks() {
        return this.letterOpenRemarks;
    }

    public void setLetterCloseDisplay(RichInputText letterCloseDisplay) {
        this.letterCloseDisplay = letterCloseDisplay;
    }

    public RichInputText getLetterCloseDisplay() {
        return this.letterCloseDisplay;
    }

    public void setProvIDDisplay(RichInputText provIDDisplay) {
        this.provIDDisplay = provIDDisplay;
    }

    public RichInputText getProvIDDisplay() {
        return this.provIDDisplay;
    }

    public void setProvDescDisplay(RichInputText provDescDisplay) {
        this.provDescDisplay = provDescDisplay;
    }

    public RichInputText getProvDescDisplay() {
        return this.provDescDisplay;
    }

    public void setProvEditableDisplay(RichInputText provEditableDisplay) {
        this.provEditableDisplay = provEditableDisplay;
    }

    public RichInputText getProvEditableDisplay() {
        return this.provEditableDisplay;
    }

    public void setProductProvLOV(RichTable productProvLOV) {
        this.productProvLOV = productProvLOV;
    }

    public RichTable getProductProvLOV() {
        return this.productProvLOV;
    }

    public String AssignProductProvision() {
        Connection conn = null;
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findProductProvisionsIterator");
        RowKeySet set = this.productProvLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
            this.session.setAttribute("provCode",
                                      r.getAttribute("PPROV_CODE"));
            this.provIDDisplay.setValue(r.getAttribute("PROV_SHT_DESC"));
            this.provDescDisplay.setValue(r.getAttribute("PROV_DESC"));
            this.provEditableDisplay.setValue(r.getAttribute("PPROV_EDITABLE"));
        }

        conn = new DBConnector().getDatabaseConn();
        try {
            CallableStatement csDeleteCover =
                conn.prepareCall("BEGIN LMS_WEB_PKG_GRP.updateProvisions(?,?,?,?,?,?,?,?);END;");
            csDeleteCover.setBigDecimal(1,
                                        (BigDecimal)this.session.getAttribute("QuoteCode"));
            csDeleteCover.setBigDecimal(2,
                                        (BigDecimal)this.session.getAttribute("provCode"));
            csDeleteCover.setBigDecimal(3,
                                        (BigDecimal)this.session.getAttribute("ProductCode"));
            if (this.provIDDisplay.getValue() == null)
                csDeleteCover.setString(4, null);
            else {
                csDeleteCover.setString(4,
                                        this.provIDDisplay.getValue().toString());
            }
            if (this.provDescDisplay.getValue() == null)
                csDeleteCover.setString(5, null);
            else {
                csDeleteCover.setString(5,
                                        this.provDescDisplay.getValue().toString());
            }
            if (this.provEditableDisplay.getValue() == null)
                csDeleteCover.setString(6, null);
            else {
                csDeleteCover.setString(6,
                                        this.provEditableDisplay.getValue().toString());
            }

            csDeleteCover.setBigDecimal(7, null);
            csDeleteCover.setString(8, "Y");
            csDeleteCover.execute();
            conn.close();
            ADFUtils.findIterator("FindProvisionIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.quotationsProvisionLOV);
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        }

        return null;
    }

    public void setQuotationsProvisionLOV(RichTable quotationsProvisionLOV) {
        this.quotationsProvisionLOV = quotationsProvisionLOV;
    }

    public RichTable getQuotationsProvisionLOV() {
        return this.quotationsProvisionLOV;
    }

    public void setCategIDDisplay(RichInputText categIDDisplay) {
        this.categIDDisplay = categIDDisplay;
    }

    public RichInputText getCategIDDisplay() {
        return this.categIDDisplay;
    }

    public void setCategDescDisplay(RichInputText categDescDisplay) {
        this.categDescDisplay = categDescDisplay;
    }

    public RichInputText getCategDescDisplay() {
        return this.categDescDisplay;
    }

    public void setCategPeriodDisplay(RichInputText categPeriodDisplay) {
        this.categPeriodDisplay = categPeriodDisplay;
    }

    public RichInputText getCategPeriodDisplay() {
        return this.categPeriodDisplay;
    }

    public void setCategoryLOV(RichTable categoryLOV) {
        this.categoryLOV = categoryLOV;
    }

    public RichTable getCategoryLOV() {
        return this.categoryLOV;
    }

    public void setCoverTypeDisplay(RichInputText coverTypeDisplay) {
        this.coverTypeDisplay = coverTypeDisplay;
    }

    public RichInputText getCoverTypeDisplay() {
        return this.coverTypeDisplay;
    }

    public void setCoverIDDisplay(RichInputText coverIDDisplay) {
        this.coverIDDisplay = coverIDDisplay;
    }

    public RichInputText getCoverIDDisplay() {
        return this.coverIDDisplay;
    }

    public void setCoverTypesDpdsLOV(RichTable coverTypesDpdsLOV) {
        this.coverTypesDpdsLOV = coverTypesDpdsLOV;
    }

    public RichTable getCoverTypesDpdsLOV() {
        return this.coverTypesDpdsLOV;
    }

    public void setRelationDisplay(RichInputText relationDisplay) {
        this.relationDisplay = relationDisplay;
    }

    public RichInputText getRelationDisplay() {
        return this.relationDisplay;
    }

    public void setLimitAmtDisplay(RichInputText limitAmtDisplay) {
        this.limitAmtDisplay = limitAmtDisplay;
    }

    public RichInputText getLimitAmtDisplay() {
        return this.limitAmtDisplay;
    }

    public void setDpdMaxTypeDisplay(RichInputText dpdMaxTypeDisplay) {
        this.dpdMaxTypeDisplay = dpdMaxTypeDisplay;
    }

    public RichInputText getDpdMaxTypeDisplay() {
        return this.dpdMaxTypeDisplay;
    }

    public void setCoverDependentsLOV(RichTable coverDependentsLOV) {
        this.coverDependentsLOV = coverDependentsLOV;
    }

    public RichTable getCoverDependentsLOV() {
        return this.coverDependentsLOV;
    }

    public void setDependentLimits(RichTable dependentLimits) {
        this.dependentLimits = dependentLimits;
    }

    public RichTable getDependentLimits() {
        return this.dependentLimits;
    }

    public void setQuotMembersLOV(RichTable quotMembersLOV) {
        this.quotMembersLOV = quotMembersLOV;
    }

    public RichTable getQuotMembersLOV() {
        return this.quotMembersLOV;
    }

    public void setMemNoDisplay(RichInputText memNoDisplay) {
        this.memNoDisplay = memNoDisplay;
    }

    public RichInputText getMemNoDisplay() {
        return this.memNoDisplay;
    }

    public void setSurnameDisplay(RichInputText surnameDisplay) {
        this.surnameDisplay = surnameDisplay;
    }

    public RichInputText getSurnameDisplay() {
        return this.surnameDisplay;
    }

    public void setOtherNamesDisplay(RichInputText otherNamesDisplay) {
        this.otherNamesDisplay = otherNamesDisplay;
    }

    public RichInputText getOtherNamesDisplay() {
        return this.otherNamesDisplay;
    }

    public void setYearDisplay(RichInputText yearDisplay) {
        this.yearDisplay = yearDisplay;
    }

    public RichInputText getYearDisplay() {
        return this.yearDisplay;
    }

    public void setMemDOBDisplay(RichInputDate memDOBDisplay) {
        this.memDOBDisplay = memDOBDisplay;
    }

    public RichInputDate getMemDOBDisplay() {
        return this.memDOBDisplay;
    }

    public void setMemberGender(RichSelectOneChoice memberGender) {
        this.memberGender = memberGender;
    }

    public RichSelectOneChoice getMemberGender() {
        return this.memberGender;
    }

    public void setDpdTypeDisplay(RichInputText dpdTypeDisplay) {
        this.dpdTypeDisplay = dpdTypeDisplay;
    }

    public RichInputText getDpdTypeDisplay() {
        return this.dpdTypeDisplay;
    }

    public void setDependentsLOV(RichTable dependentsLOV) {
        this.dependentsLOV = dependentsLOV;
    }

    public RichTable getDependentsLOV() {
        return this.dependentsLOV;
    }

    public void setMemCategoryDisplay(RichInputText memCategoryDisplay) {
        this.memCategoryDisplay = memCategoryDisplay;
    }

    public RichInputText getMemCategoryDisplay() {
        return this.memCategoryDisplay;
    }

    public void setCategoryDpdLOV(RichTable categoryDpdLOV) {
        this.categoryDpdLOV = categoryDpdLOV;
    }

    public RichTable getCategoryDpdLOV() {
        return this.categoryDpdLOV;
    }

    public String AssignCategoryDpd() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findCategoryIterator");
        RowKeySet set = this.categoryDpdLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            this.session.setAttribute("lcaCode", r.getAttribute("lcaCode"));
            this.memCategoryDisplay.setValue(r.getAttribute("catDesc"));
        }

        AdfFacesContext.getCurrentInstance().addPartialTarget(this.memCategoryDisplay);
        return null;
    }

    public void setIdNumberDisplay(RichInputText idNumberDisplay) {
        this.idNumberDisplay = idNumberDisplay;
    }

    public RichInputText getIdNumberDisplay() {
        return this.idNumberDisplay;
    }

    public void setSysPressureDisplay(RichInputText sysPressureDisplay) {
        this.sysPressureDisplay = sysPressureDisplay;
    }

    public RichInputText getSysPressureDisplay() {
        return this.sysPressureDisplay;
    }

    public void setDiasPressureDisplay(RichInputText diasPressureDisplay) {
        this.diasPressureDisplay = diasPressureDisplay;
    }

    public RichInputText getDiasPressureDisplay() {
        return this.diasPressureDisplay;
    }

    public void setWeightDisplay(RichInputText weightDisplay) {
        this.weightDisplay = weightDisplay;
    }

    public RichInputText getWeightDisplay() {
        return this.weightDisplay;
    }

    public void setHeightDisplay(RichInputText heightDisplay) {
        this.heightDisplay = heightDisplay;
    }

    public RichInputText getHeightDisplay() {
        return this.heightDisplay;
    }

    public void setOccupationDisplay(RichInputText occupationDisplay) {
        this.occupationDisplay = occupationDisplay;
    }

    public RichInputText getOccupationDisplay() {
        return this.occupationDisplay;
    }

    public void setOccupationsLOV(RichTable occupationsLOV) {
        this.occupationsLOV = occupationsLOV;
    }

    public RichTable getOccupationsLOV() {
        return this.occupationsLOV;
    }

    public void setLoanIssueDate(RichInputDate loanIssueDate) {
        this.loanIssueDate = loanIssueDate;
    }

    public RichInputDate getLoanIssueDate() {
        return this.loanIssueDate;
    }

    public void setLaonAmtDisplay(RichInputText laonAmtDisplay) {
        this.laonAmtDisplay = laonAmtDisplay;
    }

    public RichInputText getLaonAmtDisplay() {
        return this.laonAmtDisplay;
    }

    public void setLoanIntDisplay(RichInputText loanIntDisplay) {
        this.loanIntDisplay = loanIntDisplay;
    }

    public RichInputText getLoanIntDisplay() {
        return this.loanIntDisplay;
    }

    public void setLaonRepayPrdDisplay(RichInputText laonRepayPrdDisplay) {
        this.laonRepayPrdDisplay = laonRepayPrdDisplay;
    }

    public RichInputText getLaonRepayPrdDisplay() {
        return this.laonRepayPrdDisplay;
    }

    public void setSavingsAmountDisplay(RichInputText savingsAmountDisplay) {
        this.savingsAmountDisplay = savingsAmountDisplay;
    }

    public RichInputText getSavingsAmountDisplay() {
        return this.savingsAmountDisplay;
    }

    public void setAnnualEarningsDisplay(RichInputText annualEarningsDisplay) {
        this.annualEarningsDisplay = annualEarningsDisplay;
    }

    public RichInputText getAnnualEarningsDisplay() {
        return this.annualEarningsDisplay;
    }

    public void setMonthlyEarningsDisplay(RichInputText monthlyEarningsDisplay) {
        this.monthlyEarningsDisplay = monthlyEarningsDisplay;
    }

    public RichInputText getMonthlyEarningsDisplay() {
        return this.monthlyEarningsDisplay;
    }

    public void setDateOfJoining(RichInputDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public RichInputDate getDateOfJoining() {
        return this.dateOfJoining;
    }

    public void setYearsOfService(RichInputText yearsOfService) {
        this.yearsOfService = yearsOfService;
    }

    public RichInputText getYearsOfService() {
        return this.yearsOfService;
    }

    public void setFutYearsofService(RichInputText futYearsofService) {
        this.futYearsofService = futYearsofService;
    }

    public RichInputText getFutYearsofService() {
        return this.futYearsofService;
    }

    public void setTotalServiceYears(RichInputText totalServiceYears) {
        this.totalServiceYears = totalServiceYears;
    }

    public RichInputText getTotalServiceYears() {
        return this.totalServiceYears;
    }

    public void setVoluContrType(RichSelectOneChoice voluContrType) {
        this.voluContrType = voluContrType;
    }

    public RichSelectOneChoice getVoluContrType() {
        return this.voluContrType;
    }

    public void setEmpyeVolContr(RichInputText empyeVolContr) {
        this.empyeVolContr = empyeVolContr;
    }

    public RichInputText getEmpyeVolContr() {
        return this.empyeVolContr;
    }

    public void setEmpyrVolContr(RichInputText empyrVolContr) {
        this.empyrVolContr = empyrVolContr;
    }

    public RichInputText getEmpyrVolContr() {
        return this.empyrVolContr;
    }

    public void setEmpyrPensionBF(RichInputText empyrPensionBF) {
        this.empyrPensionBF = empyrPensionBF;
    }

    public RichInputText getEmpyrPensionBF() {
        return this.empyrPensionBF;
    }

    public void setEmpyePensionBF(RichInputText empyePensionBF) {
        this.empyePensionBF = empyePensionBF;
    }

    public RichInputText getEmpyePensionBF() {
        return this.empyePensionBF;
    }

    public void setTotalPensionBF(RichInputText totalPensionBF) {
        this.totalPensionBF = totalPensionBF;
    }

    public RichInputText getTotalPensionBF() {
        return this.totalPensionBF;
    }

    public void setMemberANBDisplay(RichInputText memberANBDisplay) {
        this.memberANBDisplay = memberANBDisplay;
    }

    public RichInputText getMemberANBDisplay() {
        return this.memberANBDisplay;
    }

    public void setEarningsPrdDisplay(RichInputText earningsPrdDisplay) {
        this.earningsPrdDisplay = earningsPrdDisplay;
    }

    public RichInputText getEarningsPrdDisplay() {
        return this.earningsPrdDisplay;
    }

    public void setDepMemNoDisplay(RichInputText depMemNoDisplay) {
        this.depMemNoDisplay = depMemNoDisplay;
    }

    public RichInputText getDepMemNoDisplay() {
        return this.depMemNoDisplay;
    }

    public void setDepSurnameDisplay(RichInputText depSurnameDisplay) {
        this.depSurnameDisplay = depSurnameDisplay;
    }

    public RichInputText getDepSurnameDisplay() {
        return this.depSurnameDisplay;
    }

    public void setDepOtherNamesDisplay(RichInputText depOtherNamesDisplay) {
        this.depOtherNamesDisplay = depOtherNamesDisplay;
    }

    public RichInputText getDepOtherNamesDisplay() {
        return this.depOtherNamesDisplay;
    }

    public void setDpdGender(RichSelectOneChoice dpdGender) {
        this.dpdGender = dpdGender;
    }

    public RichSelectOneChoice getDpdGender() {
        return this.dpdGender;
    }

    public void setDepDependentTypeDisplay(RichInputText depDependentTypeDisplay) {
        this.depDependentTypeDisplay = depDependentTypeDisplay;
    }

    public RichInputText getDepDependentTypeDisplay() {
        return this.depDependentTypeDisplay;
    }

    public void setDepIDNoDisplay(RichInputText depIDNoDisplay) {
        this.depIDNoDisplay = depIDNoDisplay;
    }

    public RichInputText getDepIDNoDisplay() {
        return this.depIDNoDisplay;
    }

    public void setDepDOBDisplay(RichInputDate depDOBDisplay) {
        this.depDOBDisplay = depDOBDisplay;
    }

    public RichInputDate getDepDOBDisplay() {
        return this.depDOBDisplay;
    }

    public void setJointmemNoDisplay(RichInputText jointmemNoDisplay) {
        this.jointmemNoDisplay = jointmemNoDisplay;
    }

    public RichInputText getJointmemNoDisplay() {
        return this.jointmemNoDisplay;
    }

    public void setJointmemSurnameDisplay(RichInputText jointmemSurnameDisplay) {
        this.jointmemSurnameDisplay = jointmemSurnameDisplay;
    }

    public RichInputText getJointmemSurnameDisplay() {
        return this.jointmemSurnameDisplay;
    }

    public void setJointmemothernamesDispl(RichInputText jointmemothernamesDispl) {
        this.jointmemothernamesDispl = jointmemothernamesDispl;
    }

    public RichInputText getJointmemothernamesDispl() {
        return this.jointmemothernamesDispl;
    }

    public void setJointDpdDisplay(RichInputText jointDpdDisplay) {
        this.jointDpdDisplay = jointDpdDisplay;
    }

    public RichInputText getJointDpdDisplay() {
        return this.jointDpdDisplay;
    }

    public void setJointMemDOB(RichInputDate jointMemDOB) {
        this.jointMemDOB = jointMemDOB;
    }

    public RichInputDate getJointMemDOB() {
        return this.jointMemDOB;
    }

    public void setJointMemIDNo(RichInputText jointMemIDNo) {
        this.jointMemIDNo = jointMemIDNo;
    }

    public RichInputText getJointMemIDNo() {
        return this.jointMemIDNo;
    }

    public void setJointMemGender(RichSelectOneChoice jointMemGender) {
        this.jointMemGender = jointMemGender;
    }

    public RichSelectOneChoice getJointMemGender() {
        return this.jointMemGender;
    }

    public void setGrpLifeRider1(RichSelectOneChoice grpLifeRider1) {
        this.grpLifeRider1 = grpLifeRider1;
    }

    public RichSelectOneChoice getGrpLifeRider1() {
        return this.grpLifeRider1;
    }

    public void setLaonIssueDate(RichInputText laonIssueDate) {
        this.laonIssueDate = laonIssueDate;
    }

    public RichInputText getLaonIssueDate() {
        return this.laonIssueDate;
    }

    public void setMemDOBDateDisplay(RichChooseDate memDOBDateDisplay) {
        this.memDOBDateDisplay = memDOBDateDisplay;
    }

    public RichChooseDate getMemDOBDateDisplay() {
        return this.memDOBDateDisplay;
    }

    public void setMemDOBDisp(RichInputText memDOBDisp) {
        this.memDOBDisp = memDOBDisp;
    }

    public RichInputText getMemDOBDisp() {
        return this.memDOBDisp;
    }

    public String DeleteMemCoverDtls() {
        return null;
    }

    public String Return() {
        try {
            GlobalCC.RedirectPage("/gquoedt.jspx");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return null;
    }

    public String computeQuotationPrem() {
        String computeQuery = null;
        String CalcType = (String)this.session.getAttribute("calcType");
        if (CalcType.equalsIgnoreCase("A"))
            computeQuery =
                    "BEGIN LMS_WEB_PKG_GRP.compute_agg_quot_prem(?);END;";
        else {
            computeQuery =
                    "BEGIN LMS_WEB_PKG_GRP.compute_qout_premium(?);END;";
        }
        Connection conn = new DBConnector().getDatabaseConn();
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall(computeQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)this.session.getAttribute("QuoteCode"));
            cstmt.execute();
            conn.close();
            GlobalCC.sysInformation("Premium Successfully Computed");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public void setQuoPensionTypeDispl(RichSelectOneChoice quoPensionTypeDispl) {
        this.quoPensionTypeDispl = quoPensionTypeDispl;
    }

    public RichSelectOneChoice getQuoPensionTypeDispl() {
        return this.quoPensionTypeDispl;
    }

    public void setQuoEffectiveDateDisp(RichInputText quoEffectiveDateDisp) {
        this.quoEffectiveDateDisp = quoEffectiveDateDisp;
    }

    public RichInputText getQuoEffectiveDateDisp() {
        return this.quoEffectiveDateDisp;
    }

    public String AuthoriseQuotation() {
        CorrespondenceManipulation mail = new CorrespondenceManipulation();
        String authQuery = "BEGIN LMS_WEB_PKG_GRP.authorize_quot(?);END;";
        Connection conn = new DBConnector().getDatabaseConn();
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall(authQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)this.session.getAttribute("QuoteCode"));
            cstmt.execute();
            conn.close();
            ADFUtils.findIterator("findQuotation1Iterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.sumAssuredDisplay);
            GlobalCC.sysInformation("Quotation Successfully Authorised");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        mail.emailReport("QUOAUTH");
        return null;
    }

    public String AttachAgent() {
        DCIteratorBinding dciter = ADFUtils.findIterator("FindAgentsIterator");
        RowKeySet set = this.agentsLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
            this.session.setAttribute("agnCode", r.getAttribute("AGN_CODE"));
            this.session.setAttribute("agnShtDesc",
                                      r.getAttribute("AGN_SHT_DESC"));
            this.session.setAttribute("agnName", r.getAttribute("AGN_NAME"));
        }

        String insertQuery =
            "BEGIN LMS_WEB_PKG_GRP.attachAgents(?,?,?,?);END;";
        Connection conn = null;
        try {
            conn = new DBConnector().getDatabaseConn();
            CallableStatement cstmt = conn.prepareCall(insertQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)this.session.getAttribute("agnCode"));
            cstmt.setBigDecimal(2,
                                (BigDecimal)this.session.getAttribute("QuoteCode"));
            cstmt.setString(3, (String)this.session.getAttribute("agnName"));
            cstmt.setString(4,
                            (String)this.session.getAttribute("agnShtDesc"));
            cstmt.execute();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public void setAgentsLOV(RichTable agentsLOV) {
        this.agentsLOV = agentsLOV;
    }

    public RichTable getAgentsLOV() {
        return this.agentsLOV;
    }

    public void setQuotNumberDisplay(RichInputText quotNumberDisplay) {
        this.quotNumberDisplay = quotNumberDisplay;
    }

    public RichInputText getQuotNumberDisplay() {
        return this.quotNumberDisplay;
    }

    public String PopulateCoverTypes() {
        String populateQuery =
            "BEGIN LMS_WEB_PKG_GRP.populate_cover_types(?,?);END;";
        Connection conn = null;
        try {
            conn = new DBConnector().getDatabaseConn();
            CallableStatement cstmt = conn.prepareCall(populateQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)this.session.getAttribute("ProductCode"));
            cstmt.setBigDecimal(2,
                                (BigDecimal)this.session.getAttribute("QuoteCode"));
            cstmt.execute();
            conn.close();
            ADFUtils.findIterator("findQuoteCoverTypesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.coverTypesLOV);
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        }
        return null;
    }

    public void setTaxesDisplay(RichInputText taxesDisplay) {
        this.taxesDisplay = taxesDisplay;
    }

    public RichInputText getTaxesDisplay() {
        return this.taxesDisplay;
    }

    public void setTaxesLOV(RichTable taxesLOV) {
        this.taxesLOV = taxesLOV;
    }

    public RichTable getTaxesLOV() {
        return this.taxesLOV;
    }

    public void setTaxRateDisplay(RichInputText taxRateDisplay) {
        this.taxRateDisplay = taxRateDisplay;
    }

    public RichInputText getTaxRateDisplay() {
        return this.taxRateDisplay;
    }

    public void setTaxAmtDisplay(RichInputText taxAmtDisplay) {
        this.taxAmtDisplay = taxAmtDisplay;
    }

    public RichInputText getTaxAmtDisplay() {
        return this.taxAmtDisplay;
    }

    public void setTaxesTable(RichTable taxesTable) {
        this.taxesTable = taxesTable;
    }

    public RichTable getTaxesTable() {
        return this.taxesTable;
    }

    public void setConProductsLOV(RichTable conProductsLOV) {
        this.conProductsLOV = conProductsLOV;
    }

    public RichTable getConProductsLOV() {
        return this.conProductsLOV;
    }

    public void setConProductDisplay(RichInputText conProductDisplay) {
        this.conProductDisplay = conProductDisplay;
    }

    public RichInputText getConProductDisplay() {
        return this.conProductDisplay;
    }

    public void setConProdDescDisplay(RichOutputText conProdDescDisplay) {
        this.conProdDescDisplay = conProdDescDisplay;
    }

    public RichOutputText getConProdDescDisplay() {
        return this.conProdDescDisplay;
    }

    public void setConQuotationNoDispl(RichInputText conQuotationNoDispl) {
        this.conQuotationNoDispl = conQuotationNoDispl;
    }

    public RichInputText getConQuotationNoDispl() {
        return this.conQuotationNoDispl;
    }

    public void setOkQuotationsLOV(RichTable okQuotationsLOV) {
        this.okQuotationsLOV = okQuotationsLOV;
    }

    public RichTable getOkQuotationsLOV() {
        return this.okQuotationsLOV;
    }

    public void setConClientDisplay(RichOutputText conClientDisplay) {
        this.conClientDisplay = conClientDisplay;
    }

    public RichOutputText getConClientDisplay() {
        return this.conClientDisplay;
    }

    public void setPolicyNumberDisplay(RichInputText policyNumberDisplay) {
        this.policyNumberDisplay = policyNumberDisplay;
    }

    public RichInputText getPolicyNumberDisplay() {
        return this.policyNumberDisplay;
    }

    public void setPolicyNoGeneration(RichDialog policyNoGeneration) {
        this.policyNoGeneration = policyNoGeneration;
    }

    public RichDialog getPolicyNoGeneration() {
        return this.policyNoGeneration;
    }

    public String HideResults() {
        this.searchResults.setRendered(false);
        return null;
    }

    public String AssignNewClients() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findProposers2Iterator");
        RowKeySet set = this.clientsLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
            this.clientsDisplay.setValue(r.getAttribute("CLIENT"));
            this.session.setAttribute("prpCode", r.getAttribute("PRP_CODE"));
            this.session.setAttribute("gcoCode", r.getAttribute("GCO_CODE"));
            this.session.setAttribute("ClientCode",
                                      r.getAttribute("prp_clnt_code"));
            String Occupation = null;
            Occupation = (String)r.getAttribute("GCO_DESC");
            if (Occupation == null) {
                GlobalCC.sysInformation("The Selected Client does not Have an Occupation Defined");
            }
            this.occupationOneDisplay.setValue(Occupation);
        }

        return null;
    }

    public void setClientsLOV(RichTable clientsLOV) {
        this.clientsLOV = clientsLOV;
    }

    public RichTable getClientsLOV() {
        return this.clientsLOV;
    }

    public void setClientsDisplay(RichInputText clientsDisplay) {
        this.clientsDisplay = clientsDisplay;
    }

    public RichInputText getClientsDisplay() {
        return this.clientsDisplay;
    }

    public void setBrhDisplay(RichInputText brhDisplay) {
        this.brhDisplay = brhDisplay;
    }

    public RichInputText getBrhDisplay() {
        return this.brhDisplay;
    }

    public void setBrhLOV(RichTable brhLOV) {
        this.brhLOV = brhLOV;
    }

    public RichTable getBrhLOV() {
        return this.brhLOV;
    }

    public void setProducts(RichInputText products) {
        this.products = products;
    }

    public RichInputText getProducts() {
        return this.products;
    }

    public void setProductsoneLOV(RichTable productsoneLOV) {
        this.productsoneLOV = productsoneLOV;
    }

    public RichTable getProductsoneLOV() {
        return this.productsoneLOV;
    }

    public String AssignQuotAgents() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindAgents1Iterator");
        RowKeySet set = this.agentsOneLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            this.session.setAttribute("agnCode", r.getAttribute("AGN_CODE"));
            this.session.setAttribute("agnShtDesc",
                                      r.getAttribute("AGN_SHT_DESC"));
            this.session.setAttribute("agnName", r.getAttribute("AGN_NAME"));

            this.agentsOneDisplay.setValue(r.getAttribute("AGN_NAME"));
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

            this.session.setAttribute("mktCode", r.getAttribute("AGN_CODE"));
            this.session.setAttribute("mktShtDesc",
                                      r.getAttribute("AGN_SHT_DESC"));
            this.session.setAttribute("mktName", r.getAttribute("AGN_NAME"));
            this.marketerDisplay.setValue(r.getAttribute("AGN_NAME"));
        }

        return null;
    }

    public void setAgentsOneLOV(RichTable agentsOneLOV) {
        this.agentsOneLOV = agentsOneLOV;
    }

    public RichTable getAgentsOneLOV() {
        return this.agentsOneLOV;
    }

    public void setAgentsOneDisplay(RichInputText agentsOneDisplay) {
        this.agentsOneDisplay = agentsOneDisplay;
    }

    public RichInputText getAgentsOneDisplay() {
        return this.agentsOneDisplay;
    }

    public void setQuotNumber(RichInputText quotNumber) {
        this.quotNumber = quotNumber;
    }

    public RichInputText getQuotNumber() {
        return this.quotNumber;
    }

    public void setOccupationOneDisplay(RichInputText occupationOneDisplay) {
        this.occupationOneDisplay = occupationOneDisplay;
    }

    public RichInputText getOccupationOneDisplay() {
        return this.occupationOneDisplay;
    }

    public String RenderImportMembers() {
        this.quoteBasicDetailsTab.setRendered(false);
        this.pensionsTab.setRendered(false);
        this.coverDetailsTab.setRendered(false);
        this.taxesTab.setRendered(false);
        this.categoryDetailsTab.setRendered(false);
        this.quoteMembersTab.setRendered(false);
        this.provisionsTab.setRendered(false);
        this.memCovers.setRendered(false);
        this.membersImport.setRendered(true);
        this.singleMember.setRendered(false);

        this.session.setAttribute("templateTranSeq", Integer.valueOf(0));
        this.session.setAttribute("SystemPoint", "Q");

        this.prevButton.setRendered(false);
        this.nextButton.setRendered(false);
        this.finishButton.setRendered(false);
        this.computePremiumButton.setRendered(false);

        return null;
    }

    public String RenderSingleMembers() {
        this.quoteBasicDetailsTab.setRendered(false);
        this.pensionsTab.setRendered(false);
        this.coverDetailsTab.setRendered(false);
        this.taxesTab.setRendered(false);
        this.categoryDetailsTab.setRendered(false);
        this.quoteMembersTab.setRendered(false);
        this.provisionsTab.setRendered(false);
        this.memCovers.setRendered(false);
        this.membersImport.setRendered(false);
        this.singleMember.setRendered(true);

        this.prevButton.setRendered(false);
        this.nextButton.setRendered(false);
        this.finishButton.setRendered(false);
        this.computePremiumButton.setRendered(false);

        return null;
    }

    public String BackToMembers() {
        RefreshComponents();
        ADFUtils.findIterator("findQuoteMembersIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.allMembers);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.memberCoversLOV);
        this.membersImport.setRendered(false);
        this.quoteBasicDetailsTab.setRendered(false);
        this.pensionsTab.setRendered(false);
        this.coverDetailsTab.setRendered(false);
        this.taxesTab.setRendered(false);
        this.categoryDetailsTab.setRendered(false);
        this.quoteMembersTab.setRendered(true);
        this.provisionsTab.setRendered(false);
        this.memCovers.setRendered(false);
        this.singleMember.setRendered(false);

        /*this.prevButton.setRendered(true);
        this.nextButton.setRendered(true);
        this.finishButton.setRendered(false);
        this.computePremiumButton.setRendered(false);*/
        
        this.prevButton.setRendered(true);
        this.nextButton.setRendered(false);
        this.finishButton.setRendered(true);
        this.computePremiumButton.setRendered(true);
       this.session.setAttribute("MemberNumber",null);
       this.session.setAttribute("quoteMemMemCode", null);

        return null;
    }

    public String cmdNext() {
        String GrpRider = null;

        Integer RenderTab = (Integer)this.session.getAttribute("RenderTab");
        String ProductTyp = (String)this.session.getAttribute("productType");
        String grpLifeCover = (String)this.groupLifeRider.getValue();
        Integer localInteger2;
        Integer localInteger3;
        Integer localInteger4;
        Integer localInteger5;
        Rendering render=new Rendering();
        //System.out.println("Render Tab " + RenderTab.intValue());
        switch (RenderTab.intValue()) {
        case 0:
            BigDecimal Product =
                (BigDecimal)this.session.getAttribute("ProductCode");
            if (Product == null) {
                GlobalCC.sysInformation("Select A Product");
                return null;
            }

            BigDecimal test =
                (BigDecimal)this.session.getAttribute("pmasCode");
            String test1 = (String)this.session.getAttribute("pmasshtdesc");
            if (this.premMasksDisplay.getValue() == null) {
                if (ProductTyp.equals("PENS")) {
                    if (grpLifeCover.equals("Y")) {
                        GlobalCC.sysInformation("Select A Premium Mask");
                        return null;
                    }

                } else {
                    GlobalCC.sysInformation("Select A Premium Mask");
                    return null;
                }

            }

            if (this.session.getAttribute("depCovered") == null) {
                GlobalCC.sysInformation("Select A Quotation Cover");
                return null;
            }

            if (this.quotationCalcType.getValue() == null) {
                GlobalCC.sysInformation("Select A Quotation Calculation Type");
                return null;
            }

            if (this.quotationDurationType.getValue() == null) {
                GlobalCC.sysInformation("Select A Quotation Duration Type");
                return null;
            }

            if (this.frequencyOfPay.getValue() == null) {
                GlobalCC.sysInformation("Select A Frequency of Pay");
                return null;
            }

            BigDecimal brnCode =
                (BigDecimal)this.session.getAttribute("brnCode");
            if (brnCode == null) {
                GlobalCC.sysInformation("Select A Branch");
                return null;
            }
            if (agentsOneDisplay.getValue() == null) {
                GlobalCC.sysInformation("Select An agent");
                return null;
            }

            if (this.coinsCbox.isSelected()) {
                int i =
                    Integer.parseInt(this.leaderShare.getValue().toString());
                Integer Test =
                    (Integer)this.session.getAttribute("CoinsurerTotal");
                Test = Integer.valueOf(Test.intValue() + i);
                Integer Coinf = Test;

                if (Coinf.intValue() < 100) {
                    GlobalCC.sysInformation("The Total Coinsurer share is less than 100%");
                    return null;
                }

            }

            String Res = UpdateQuotations();
            System.out.println("test " + Res);
            if (Res.equalsIgnoreCase("F") && Res != null) {
                return null;
            }

            calctypeListener();

            ProductTyp = (String)this.session.getAttribute("productType");

            if ((ProductTyp.equalsIgnoreCase("PENS")) ||
                (ProductTyp.equalsIgnoreCase("ANN")) ||
                (ProductTyp.equalsIgnoreCase("GRAT"))) {
                this.quoteBasicDetailsTab.setRendered(false);
                this.pensionsTab.setRendered(true);
                this.coverDetailsTab.setRendered(false);
                this.schoolFeesTab.setRendered(false);
                this.quoteMembersTab.setRendered(false);
                this.provisionsTab.setRendered(false);
                this.categoryDetailsTab.setRendered(false);
                this.memCovers.setRendered(false);
                this.prevButton.setRendered(true);
                this.nextButton.setRendered(true);
                this.finishButton.setRendered(false);
                this.computePremiumButton.setRendered(false);
                RenderTab = Integer.valueOf(2);
                this.session.setAttribute("RenderTab", Integer.valueOf(2));
            } else {
                this.quoteBasicDetailsTab.setRendered(false);
                this.pensionsTab.setRendered(false);
                this.coverDetailsTab.setRendered(true);
                this.taxesTab.setRendered(false);
                if (ProductTyp.equalsIgnoreCase("EDUC")) {
                    this.schoolFeesTab.setRendered(false);
                }
                this.categoryDetailsTab.setRendered(false);
                this.quoteMembersTab.setRendered(false);
                this.provisionsTab.setRendered(false);
                this.categoryDetailsTab.setRendered(false);
                this.memCovers.setRendered(false);
                String CalcType =
                    (String)this.session.getAttribute("calcType");
                if ((CalcType.equalsIgnoreCase("A")) &&
                    (!ProductTyp.equalsIgnoreCase("EDUC"))) {
                    this.prevButton.setRendered(true);
                    this.nextButton.setRendered(false);
                    this.finishButton.setRendered(true);
                    this.computePremiumButton.setRendered(true);
                    RenderTab = Integer.valueOf(3);
                    this.session.setAttribute("RenderTab", Integer.valueOf(3));
                } else {
                    this.prevButton.setRendered(true);
                    this.nextButton.setRendered(true);
                    this.finishButton.setRendered(false);
                    this.computePremiumButton.setRendered(false);
                    RenderTab = Integer.valueOf(3);
                    this.session.setAttribute("RenderTab", Integer.valueOf(3));
                }
            }

            break;
        case 1:
            String Result = Update_Earn_Pensions();
            if (Result.equalsIgnoreCase("F")) {
                return null;
            }
            this.quoteBasicDetailsTab.setRendered(false);
            this.pensionsTab.setRendered(true);
            this.coverDetailsTab.setRendered(false);
            this.taxesTab.setRendered(false);
            this.categoryDetailsTab.setRendered(false);
            this.provisionsTab.setRendered(false);
            this.memCovers.setRendered(false);
            Integer localInteger1 = RenderTab;
            localInteger2 =
                    RenderTab = Integer.valueOf(RenderTab.intValue() + 1);
            this.session.setAttribute("RenderTab", RenderTab);
            break;
        case 2:
            if (this.groupLifeRider.getValue() == null)
                GrpRider = null;
            else {
                GrpRider = this.groupLifeRider.getValue().toString();
            }
            ProductTyp = (String)this.session.getAttribute("productType");
            if (ProductTyp.equalsIgnoreCase("PENS")) {
                if (this.pensionType.getValue() == null) {
                    GlobalCC.sysInformation("Select A Pension Type");
                    return null;
                }

                if (this.guaranteePrdDisplay.getValue() == null) {
                    GlobalCC.sysInformation("Enter A Guarantee Period");
                    return null;
                }

                if (this.rmaleDisplay.getValue() == null) {
                    GlobalCC.sysInformation("Enter A Male Retirement Age");
                    return null;
                }

                if (this.rfemaleDisplay.getValue() == null) {
                    GlobalCC.sysInformation("Enter A Female Retirement Age");
                    return null;
                }

            }

            if ((ProductTyp.equalsIgnoreCase("PENS")) ||
                (ProductTyp.equalsIgnoreCase("ANN")) ||
                (ProductTyp.equalsIgnoreCase("GRAT"))) {
                String Result1 = Update_Earn_Pensions();
                if (Result1.equalsIgnoreCase("F")) {
                    return null;
                }
            }
            ProductTyp = (String)this.session.getAttribute("productType");
            if (((ProductTyp.equalsIgnoreCase("PENS")) &&
                 (GrpRider.equalsIgnoreCase("N"))) ||
                (ProductTyp.equalsIgnoreCase("ANN")) ||
                (ProductTyp.equalsIgnoreCase("GRAT"))) {
                ShowTaxes();
                this.quoteBasicDetailsTab.setRendered(false);
                this.pensionsTab.setRendered(false);
                this.coverDetailsTab.setRendered(false);
                this.taxesTab.setRendered(true);
                this.categoryDetailsTab.setRendered(false);
                this.quoteMembersTab.setRendered(false);
                this.provisionsTab.setRendered(false);
                this.memCovers.setRendered(false);
                String CalcType =
                    (String)this.session.getAttribute("calcType");
                if (CalcType.equalsIgnoreCase("A")) {
                    this.prevButton.setRendered(true);
                    this.nextButton.setRendered(false);
                    this.finishButton.setRendered(true);
                    localInteger2 = RenderTab;
                    localInteger3 =
                            RenderTab = Integer.valueOf(RenderTab.intValue() +
                                                        1);
                    this.session.setAttribute("RenderTab", RenderTab);
                } else {
                    this.prevButton.setRendered(true);
                    this.nextButton.setRendered(true);
                    this.finishButton.setRendered(false);
                    this.pensAverageANB.setRendered(false);
                    this.pensAverageEarnings.setRendered(false);
                    localInteger2 = RenderTab;
                    localInteger3 =
                            RenderTab = Integer.valueOf(RenderTab.intValue() +
                                                        1);
                    this.session.setAttribute("RenderTab", RenderTab);
                }
            } else {
                ShowTaxes();
                this.quoteBasicDetailsTab.setRendered(false);
                this.pensionsTab.setRendered(false);
                this.coverDetailsTab.setRendered(true);
                this.taxesTab.setRendered(false);
                this.categoryDetailsTab.setRendered(false);
                this.quoteMembersTab.setRendered(false);
                this.provisionsTab.setRendered(false);
                this.memCovers.setRendered(false);
                String CalcType =
                    (String)this.session.getAttribute("calcType");
                if (CalcType.equalsIgnoreCase("A")) {
                    this.prevButton.setRendered(true);
                    this.nextButton.setRendered(false);
                    this.finishButton.setRendered(true);
                    this.computePremiumButton.setRendered(true);
                    localInteger2 = RenderTab;
                    localInteger3 =
                            RenderTab = Integer.valueOf(RenderTab.intValue() +
                                                        1);
                    this.session.setAttribute("RenderTab", RenderTab);
                } else {
                    this.prevButton.setRendered(true);
                    this.nextButton.setRendered(true);
                    this.finishButton.setRendered(false);
                    this.computePremiumButton.setRendered(false);
                    localInteger2 = RenderTab;
                    localInteger3 =
                            RenderTab = Integer.valueOf(RenderTab.intValue() +
                                                        1);
                    this.session.setAttribute("RenderTab", RenderTab);
                }
            }
            break;
        case 3:
            if (this.groupLifeRider.getValue() == null)
                GrpRider = null;
            else {
                GrpRider = this.groupLifeRider.getValue().toString();
            }
            ProductTyp = (String)this.session.getAttribute("productType");
            if (((ProductTyp.equalsIgnoreCase("PENS")) &&
                 (GrpRider.equalsIgnoreCase("N"))) ||
                (ProductTyp.equalsIgnoreCase("ANN")) ||
                (ProductTyp.equalsIgnoreCase("GRAT"))) {
                ShowAddMembers();
                this.quoteBasicDetailsTab.setRendered(false);
                this.pensionsTab.setRendered(false);
                this.coverDetailsTab.setRendered(false);
                this.taxesTab.setRendered(false);
                this.categoryDetailsTab.setRendered(false);
                this.quoteMembersTab.setRendered(true);
                this.provisionsTab.setRendered(false);
                this.memCovers.setRendered(false);
                if(render.isMickVisible()){
                  this.categoryDetailsTab.setRendered(true);
                  this.quoteMembersTab.setRendered(false);
                  RenderTab = Integer.valueOf(6);
                }else{
                  RenderTab = Integer.valueOf(7);
                }
                
                this.session.setAttribute("RenderTab", RenderTab);
            } else {
                String Covers =
                    (String)this.session.getAttribute("coversAvail");
                if (Covers.equalsIgnoreCase("N")) {
                    ProductTyp =
                            (String)this.session.getAttribute("productType");
                    if (!ProductTyp.equalsIgnoreCase("PENS")) {
                        GlobalCC.sysInformation("Select Atleast One Main Cover");
                        return null;
                    }
                }

                ShowTaxes();
                this.quoteBasicDetailsTab.setRendered(false);
                this.pensionsTab.setRendered(false);
                this.coverDetailsTab.setRendered(false);
                this.taxesTab.setRendered(true);
                this.categoryDetailsTab.setRendered(false);
                this.quoteMembersTab.setRendered(false);
                this.provisionsTab.setRendered(false);
                this.memCovers.setRendered(false);
                localInteger2 = RenderTab;
                localInteger3 =
                        RenderTab = Integer.valueOf(RenderTab.intValue() + 1);
                this.session.setAttribute("RenderTab", RenderTab);
            }
            break;
        case 4:
            ProductTyp = (String)this.session.getAttribute("productType");
            this.quoteBasicDetailsTab.setRendered(false);
            this.pensionsTab.setRendered(false);
            this.coverDetailsTab.setRendered(false);
            this.taxesTab.setRendered(false);
            this.categoryDetailsTab.setRendered(true);
            if (ProductTyp.equalsIgnoreCase("EDUC"));
            String Value = Validate_Quote_Product();
            if ((Value == null) || (Value == "F"))
                this.prdTypeLabel.setValue("[Months]");
            else {
                this.prdTypeLabel.setValue(Value);
            }
            this.quoteMembersTab.setRendered(false);
            this.provisionsTab.setRendered(false);
            this.memCovers.setRendered(false);
            localInteger2 = RenderTab;
            localInteger3 =
                    RenderTab = Integer.valueOf(RenderTab.intValue() + 1);
            this.session.setAttribute("RenderTab", RenderTab);

            String CalcType2 = (String)this.session.getAttribute("calcType");
            if ((CalcType2.equalsIgnoreCase("A")) &&
                (ProductTyp.equalsIgnoreCase("EDUC"))) {
                this.prevButton.setRendered(true);
                this.nextButton.setRendered(false);
                this.finishButton.setRendered(true);
                this.computePremiumButton.setRendered(true);
            } else {
                this.prevButton.setRendered(true);
                this.nextButton.setRendered(true);
                this.finishButton.setRendered(false);
                this.computePremiumButton.setRendered(false);
            }
            break;
        case 5:
           // System.out.println("Am here....");
           ProductTyp = (String)this.session.getAttribute("productType");
           String CalcType = (String)this.session.getAttribute("calcType");
           String catExist =ValidateCategories();
            if((ProductTyp.equals("LOAN")||
               ProductTyp.equals("EARN")||
               ProductTyp.equals("FUNE"))&&CalcType.equals("D")){
                if(catExist.equals("N")){
                  GlobalCC.INFORMATIONREPORTING("Please add categories");
                  return null;
                }              
            }
            ShowProvisions();            
            this.schoolFeesTab.setRendered(false);
            this.quoteBasicDetailsTab.setRendered(false);
            this.pensionsTab.setRendered(false);
            this.coverDetailsTab.setRendered(false);
            this.taxesTab.setRendered(false);
            this.categoryDetailsTab.setRendered(false);
            this.quoteMembersTab.setRendered(false);
            this.provisionsTab.setRendered(true);
            if (CalcType.equalsIgnoreCase("A")) {
                this.prevButton.setRendered(true);
                this.nextButton.setRendered(false);
                this.finishButton.setRendered(true);
                this.computePremiumButton.setRendered(true);
                localInteger4 = RenderTab;
                localInteger5 =
                        RenderTab = Integer.valueOf(RenderTab.intValue() + 1);
                this.session.setAttribute("RenderTab", RenderTab);
            } else {
                localInteger4 = RenderTab;
                localInteger5 =
                        RenderTab = Integer.valueOf(RenderTab.intValue() + 1);
                this.session.setAttribute("RenderTab", RenderTab);
            }
            break;
        case 6:
            ShowAddMembers();
            this.quoteBasicDetailsTab.setRendered(false);
            this.pensionsTab.setRendered(false);
            this.schoolFeesTab.setRendered(false);
            this.coverDetailsTab.setRendered(false);
            this.taxesTab.setRendered(false);
            this.categoryDetailsTab.setRendered(false);
            this.quoteMembersTab.setRendered(true);
            this.provisionsTab.setRendered(false);
            this.memCovers.setRendered(false);

            /*this.prevButton.setRendered(true);
            this.nextButton.setRendered(true);
            this.finishButton.setRendered(false);
            this.computePremiumButton.setRendered(false);*/
            
            this.prevButton.setRendered(true);
            this.nextButton.setRendered(false);
            this.finishButton.setRendered(true);
            this.computePremiumButton.setRendered(true);

            localInteger4 = RenderTab;
            localInteger5 =
                    RenderTab = Integer.valueOf(RenderTab.intValue() + 1);
            this.session.setAttribute("RenderTab", RenderTab);
            break;
        /*case 7:
            this.quoteBasicDetailsTab.setRendered(false);
            this.pensionsTab.setRendered(false);
            this.coverDetailsTab.setRendered(false);
            this.taxesTab.setRendered(false);
            this.categoryDetailsTab.setRendered(false);
            this.quoteMembersTab.setRendered(false);
            this.schoolFeesTab.setRendered(false);
            this.provisionsTab.setRendered(false);
            this.memCovers.setRendered(true);

            this.prevButton.setRendered(true);
            this.nextButton.setRendered(false);
            this.finishButton.setRendered(true);
            this.computePremiumButton.setRendered(true);

            localInteger4 = RenderTab;
            localInteger5 =
                    RenderTab = Integer.valueOf(RenderTab.intValue() + 1);
            this.session.setAttribute("RenderTab", RenderTab);*/
        }


        return null;
    }

    public String CmdPrev() {
        String GrpRider = null;
        Integer RenderTab = (Integer)this.session.getAttribute("RenderTab");
        String ProductTyp = null;
        ProductTyp = (String)this.session.getAttribute("productType");
        if (RenderTab.intValue() != 0) {
            if (!ProductTyp.equalsIgnoreCase("PENS")) {
                System.out.println(RenderTab);
                if (RenderTab.intValue() == 3) {
                    RenderTab = Integer.valueOf(0);
                    this.session.setAttribute("RenderTab", RenderTab);
                } else {
                    RenderTab = Integer.valueOf(RenderTab.intValue() - 1);
                    this.session.setAttribute("RenderTab", RenderTab);
                }
            } else if (ProductTyp.equalsIgnoreCase("PENS")) {
                System.out.println(RenderTab);
                if (RenderTab.intValue() == 2) {
                    RenderTab = Integer.valueOf(0);
                    this.session.setAttribute("RenderTab", RenderTab);
                } else {
                    RenderTab = Integer.valueOf(RenderTab.intValue() - 1);
                    this.session.setAttribute("RenderTab", RenderTab);
                }
            } else {
                RenderTab = Integer.valueOf(RenderTab.intValue() - 1);
                this.session.setAttribute("RenderTab", RenderTab);
            }
        }
        switch (RenderTab.intValue()) {
        case 0:
            this.quoteBasicDetailsTab.setRendered(true);
            this.pensionsTab.setRendered(false);
            this.coverDetailsTab.setRendered(false);
            this.quoteMembersTab.setRendered(false);
            this.provisionsTab.setRendered(false);
            this.categoryDetailsTab.setRendered(false);
            this.schoolFeesTab.setRendered(false);
            this.taxesTab.setRendered(false);
            this.memCovers.setRendered(false);
            this.prevButton.setRendered(false);
            this.nextButton.setRendered(true);
            this.finishButton.setRendered(false);
            this.computePremiumButton.setRendered(false);
            break;
        case 1:
            if (ProductTyp.equalsIgnoreCase("PENS")) {
                this.quoteBasicDetailsTab.setRendered(false);
                this.pensionsTab.setRendered(true);
                this.coverDetailsTab.setRendered(false);
                this.quoteMembersTab.setRendered(false);
                this.provisionsTab.setRendered(false);
                this.categoryDetailsTab.setRendered(false);
                this.memCovers.setRendered(false);
                this.prevButton.setRendered(true);
                this.nextButton.setRendered(true);
                this.finishButton.setRendered(false);
                this.computePremiumButton.setRendered(false);
            } else {
                this.quoteBasicDetailsTab.setRendered(false);
                this.pensionsTab.setRendered(false);
                this.coverDetailsTab.setRendered(true);
                this.taxesTab.setRendered(false);
                this.categoryDetailsTab.setRendered(false);
                this.schoolFeesTab.setRendered(false);
                this.quoteMembersTab.setRendered(false);
                this.provisionsTab.setRendered(false);
                this.categoryDetailsTab.setRendered(false);
                this.memCovers.setRendered(false);
                this.prevButton.setRendered(true);
                this.nextButton.setRendered(true);
                this.finishButton.setRendered(false);
                this.computePremiumButton.setRendered(false);
                RenderTab = Integer.valueOf(4);
                this.session.setAttribute("RenderTab", RenderTab);
            }
            break;
        case 2:
            this.quoteBasicDetailsTab.setRendered(false);
            this.pensionsTab.setRendered(true);
            this.coverDetailsTab.setRendered(false);
            this.taxesTab.setRendered(false);
            this.categoryDetailsTab.setRendered(false);
            this.schoolFeesTab.setRendered(false);
            this.provisionsTab.setRendered(false);
            this.memCovers.setRendered(false);

            break;
        case 3:
            this.quoteBasicDetailsTab.setRendered(false);
            this.pensionsTab.setRendered(false);
            this.coverDetailsTab.setRendered(true);
            this.taxesTab.setRendered(false);
            this.categoryDetailsTab.setRendered(false);
            this.quoteMembersTab.setRendered(false);
            this.provisionsTab.setRendered(false);

            this.memCovers.setRendered(false);

            break;
        case 4:
            this.quoteBasicDetailsTab.setRendered(false);
            this.pensionsTab.setRendered(false);
            this.coverDetailsTab.setRendered(false);
            this.taxesTab.setRendered(true);
            this.categoryDetailsTab.setRendered(false);
            this.schoolFeesTab.setRendered(false);
            this.quoteMembersTab.setRendered(false);
            this.provisionsTab.setRendered(false);
            this.memCovers.setRendered(false);

            this.prevButton.setRendered(true);
            this.nextButton.setRendered(true);
            this.finishButton.setRendered(false);
            this.computePremiumButton.setRendered(false);

            break;
        case 5:
            this.quoteBasicDetailsTab.setRendered(false);
            this.pensionsTab.setRendered(false);
            this.coverDetailsTab.setRendered(false);
            this.taxesTab.setRendered(false);
            this.categoryDetailsTab.setRendered(true);
            if (ProductTyp.equalsIgnoreCase("EDUC")) {
                this.schoolFeesTab.setRendered(true);
            }
            String Value = Validate_Quote_Product();
            if ((Value == null) || (Value == "F"))
                this.prdTypeLabel.setValue("[Months]");
            else {
                this.prdTypeLabel.setValue(Value);
            }
            this.quoteMembersTab.setRendered(false);
            this.provisionsTab.setRendered(false);
            this.memCovers.setRendered(false);

            this.prevButton.setRendered(true);
            this.nextButton.setRendered(true);
            this.finishButton.setRendered(false);
            this.computePremiumButton.setRendered(false);

            break;
        case 6:
            if (this.groupLifeRider.getValue() == null)
                GrpRider = null;
            else {
                GrpRider = this.groupLifeRider.getValue().toString();
            }

            if ((ProductTyp.equalsIgnoreCase("PENS")) &&
                (GrpRider.equalsIgnoreCase("N"))) {
                this.quoteBasicDetailsTab.setRendered(false);
                this.pensionsTab.setRendered(false);
                this.coverDetailsTab.setRendered(false);
                this.taxesTab.setRendered(true);
                this.categoryDetailsTab.setRendered(false);
                this.quoteMembersTab.setRendered(false);
                this.provisionsTab.setRendered(false);
                this.memCovers.setRendered(false);
                RenderTab = Integer.valueOf(3);
                this.session.setAttribute("RenderTab", RenderTab);
            } else {
                this.quoteBasicDetailsTab.setRendered(false);
                this.pensionsTab.setRendered(false);
                this.coverDetailsTab.setRendered(false);
                this.taxesTab.setRendered(false);
                this.categoryDetailsTab.setRendered(false);
                this.schoolFeesTab.setRendered(false);
                this.quoteMembersTab.setRendered(false);
                this.provisionsTab.setRendered(true);
                this.memCovers.setRendered(false);
            }

            break;
        case 7:
            if (this.groupLifeRider.getValue() == null)
                GrpRider = null;
            else {
                GrpRider = this.groupLifeRider.getValue().toString();
            }

            if ((ProductTyp.equalsIgnoreCase("PENS")) &&
                (GrpRider.equalsIgnoreCase("N"))) {
                this.quoteBasicDetailsTab.setRendered(false);
                this.pensionsTab.setRendered(false);
                this.coverDetailsTab.setRendered(false);
                this.schoolFeesTab.setRendered(false);
                this.taxesTab.setRendered(true);
                this.categoryDetailsTab.setRendered(false);
                this.quoteMembersTab.setRendered(false);
                this.provisionsTab.setRendered(false);
                this.memCovers.setRendered(false);
                RenderTab = Integer.valueOf(3);
                this.session.setAttribute("RenderTab", RenderTab);
            } else {
                this.quoteBasicDetailsTab.setRendered(false);
                this.pensionsTab.setRendered(false);
                this.coverDetailsTab.setRendered(false);
                this.taxesTab.setRendered(false);
                this.categoryDetailsTab.setRendered(false);
                this.schoolFeesTab.setRendered(false);
                this.quoteMembersTab.setRendered(true);
                this.provisionsTab.setRendered(false);

                this.memCovers.setRendered(false);

                this.prevButton.setRendered(true);
                this.nextButton.setRendered(true);
                this.finishButton.setRendered(false);
                this.computePremiumButton.setRendered(false);
            }
            break;
        case 8:
            this.quoteBasicDetailsTab.setRendered(false);
            this.pensionsTab.setRendered(false);
            this.coverDetailsTab.setRendered(false);
            this.taxesTab.setRendered(false);
            this.categoryDetailsTab.setRendered(false);
            this.schoolFeesTab.setRendered(false);
            this.quoteMembersTab.setRendered(true);
            this.provisionsTab.setRendered(false);
            this.memCovers.setRendered(false);

            /*this.prevButton.setRendered(true);
            this.nextButton.setRendered(true);
            this.finishButton.setRendered(false);
            this.computePremiumButton.setRendered(false);*/
            
            this.prevButton.setRendered(true);
            this.nextButton.setRendered(false);
            this.finishButton.setRendered(true);
            this.computePremiumButton.setRendered(true);

            break;
        /*case 9:
            this.quoteBasicDetailsTab.setRendered(false);
            this.pensionsTab.setRendered(false);
            this.coverDetailsTab.setRendered(false);
            this.taxesTab.setRendered(false);
            this.categoryDetailsTab.setRendered(false);
            this.quoteMembersTab.setRendered(false);
            this.provisionsTab.setRendered(false);
            this.memCovers.setRendered(true);

            this.prevButton.setRendered(true);
            this.nextButton.setRendered(false);
            this.finishButton.setRendered(true);
            this.computePremiumButton.setRendered(true);*/
        }

        return null;
    }

    public String Validate_Quote_Product() {
        Connection conn = null;
        String Value = "F";
        try {
            conn = new DBConnector().getDatabaseConn();
            String dobQuery =
                "begin ? := LMS_WEB_PKG_GRP_UW.product_earn_type(?,?); end;";
            CallableStatement stmt = null;
            stmt = conn.prepareCall(dobQuery);
            stmt.registerOutParameter(1, 12);
            stmt.setBigDecimal(2,
                               (BigDecimal)this.session.getAttribute("QuoteCode"));
            stmt.setString(3, "Q");
            stmt.execute();

            Value = stmt.getString(1);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
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
                             (BigDecimal)this.session.getAttribute("QuoteCode"));
          stmt.setString(3, "Q");
          stmt.execute();

          Value = stmt.getString(1);
          stmt.close();
          conn.close();
      } catch (Exception e) {
          GlobalCC.EXCEPTIONREPORTING(conn, e);
      }
      return Value;
  }

    public String UpdateQuotations() {
        String Result = "F";
        BigDecimal prod = (BigDecimal)this.session.getAttribute("ProductCode");
        String ProductTyp = (String)this.session.getAttribute("productType");


        if (prod == null) {
            GlobalCC.sysInformation("Select A Product");
            return null;
        }

        if (this.premMasksDisplay.getValue() == null) {
            if (!(ProductTyp.equalsIgnoreCase("PENS") &&
                  groupLifeRider.getValue().toString().equalsIgnoreCase("N"))) {
                GlobalCC.sysInformation("Select A Premium Mask");
                return null;
            }
        }

        if (this.session.getAttribute("depCovered") == null) {
            GlobalCC.sysInformation("Select A Quotation Cover");
            return null;
        }

        if (this.quotationCalcType.getValue() == null) {
            GlobalCC.sysInformation("Select A Quotation Calculation Type");
            return null;
        }

        if (this.quotationDurationType.getValue() == null) {
            GlobalCC.sysInformation("Select A Quotation Duration Type");
            return null;
        }

        if (this.frequencyOfPay.getValue() == null) {
            GlobalCC.sysInformation("Select A Frequency of Pay");
            return null;
        }

        BigDecimal Branch = (BigDecimal)this.session.getAttribute("brnCode");
        if (Branch == null) {
            GlobalCC.sysInformation("Select A Branch");
            return null;
        }

        if (this.occupationOneDisplay == null) {
            GlobalCC.sysInformation("Client Selected does not have an Occupation.");
            return null;
        }

        BigDecimal Agent = (BigDecimal)this.session.getAttribute("agnCode");
        if (Agent == null) {
            GlobalCC.sysInformation("Select An Agent");
            return null;
        }

        String v_savings_rider = null;
        String updateQuery =
            "BEGIN LMS_WEB_PKG_GRP.update_quotations(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);END;";
        Connection conn = new DBConnector().getDatabaseConn();
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall(updateQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)this.session.getAttribute("QuoteCode"));
            cstmt.setBigDecimal(2,
                                (BigDecimal)this.session.getAttribute("prpCode"));
            cstmt.setBigDecimal(3,
                                (BigDecimal)this.session.getAttribute("ProductCode"));
            cstmt.setString(4,
                            (String)this.session.getAttribute("productType"));
            cstmt.setBigDecimal(5,
                                (BigDecimal)this.session.getAttribute("pmasCode"));
            if (this.premMasksDisplay.getValue() == null)
                cstmt.setString(6, null);
            else {
                cstmt.setString(6,
                                this.premMasksDisplay.getValue().toString());
            }
            cstmt.setBigDecimal(7,
                                (BigDecimal)this.session.getAttribute("gcoCode"));
            if (this.groupLifeRider.getValue() == null) {
                String v_grp_life_rider = "N";
                cstmt.setString(8, null);
            } else {
                String v_grp_life_rider =
                    this.groupLifeRider.getValue().toString();
                cstmt.setString(8, this.groupLifeRider.getValue().toString());
            }
            if (this.quotationCalcType.getValue() == null)
                cstmt.setString(9, null);
            else {
                cstmt.setString(9,
                                this.quotationCalcType.getValue().toString());
            }
            cstmt.setString(10,
                            (String)this.session.getAttribute("depCovered"));
            if (this.quotationDurationType.getValue() == null)
                cstmt.setString(11, null);
            else {
                cstmt.setString(11,
                                this.quotationDurationType.getValue().toString());
            }

            if (this.frequencyOfPay.getValue() == null) {
                cstmt.setString(12, null);
            } else {
                cstmt.setString(12, this.frequencyOfPay.getValue().toString());
            }

            cstmt.setBigDecimal(13,
                                (BigDecimal)this.session.getAttribute("agnCode"));
            cstmt.setString(14,
                            (String)this.session.getAttribute("agnShtDesc"));
            if (this.loansSavingsRider.getValue() == null)
                v_savings_rider = "N";
            else {
                v_savings_rider = this.loansSavingsRider.getValue().toString();
            }
            cstmt.setString(15, v_savings_rider);
            if (this.unitRateOption.getValue() == null)
                cstmt.setString(16, "N");
            else {
                cstmt.setString(16, this.unitRateOption.getValue().toString());
            }
            cstmt.setBigDecimal(17,
                                (BigDecimal)this.session.getAttribute("brnCode"));
            String Prod = (String)this.session.getAttribute("productType");
            if (Prod.equalsIgnoreCase("LOAN")) {
                if (this.osLoanCalculation.getValue() == null)
                    cstmt.setString(18, null);
                else {
                    cstmt.setString(18,
                                    this.osLoanCalculation.getValue().toString());
                }
            } else if (this.durationTermType.getValue() == null) {
                cstmt.setString(18, null);
            } else {
                cstmt.setString(18,
                                this.durationTermType.getValue().toString());
            }
            cstmt.setBigDecimal(19,
                                (BigDecimal)this.session.getAttribute("mktCode"));     
          cstmt.setBigDecimal(20, (BigDecimal)this.session.getAttribute("sbuCode"));
          cstmt.setBigDecimal(21, (BigDecimal)this.session.getAttribute("spokeCode"));
          cstmt.setBigDecimal(22, (BigDecimal)this.session.getAttribute("coverageAreaCode"));
          cstmt.setBigDecimal(23, (BigDecimal)this.session.getAttribute("locationCode"));      
         
            cstmt.execute();
            cstmt.close();

            /*Updates the loss ratio based on total claims and premium captured*/
            getLossRatio();
            getCurrencyDetails();

            if (tender.isSelected()) {
                getQuotProductPlan("Y");
            } else {
                getQuotProductPlan("N");
            }

            String DurationType =
                (String)this.session.getAttribute("policyDurationType");
            if (DurationType != null) {
                if (DurationType.equalsIgnoreCase("C")) {
                    String DurationQuery =
                        "BEGIN lms_web_pkg_grp_uw.effect_quot_duration_change(?,?,?,?);END;";
                    CallableStatement cst = null;
                    cst = conn.prepareCall(DurationQuery);
                    cst.setBigDecimal(1,
                                      (BigDecimal)this.session.getAttribute("QuoteCode"));
                    cst.setString(2,
                                  (String)this.session.getAttribute("newWETDate"));
                    cst.setString(3, DurationType);
                    cst.registerOutParameter(4, 91);
                    cst.execute();
                    cst.close();
                }
            }

            String UmbrellaCover =
                (String)this.session.getAttribute("umbrellaCover");
            if (UmbrellaCover != null) {
                if (UmbrellaCover.equalsIgnoreCase("Y")) {
                    String UmbrellaQuery =
                        "BEGIN lms_web_pkg_grp_uw.effect_umbrella_quot_duration(?,?,?,?);END;";
                    CallableStatement cstU = null;
                    cstU = conn.prepareCall(UmbrellaQuery);
                    cstU.setBigDecimal(1,
                                       (BigDecimal)this.session.getAttribute("QuoteCode"));
                    cstU.setString(2,
                                   (String)this.session.getAttribute("newWETDate"));
                    cstU.setString(3,
                                   (String)this.session.getAttribute("umbrellaDurationType"));
                    cstU.registerOutParameter(4, 91);
                    cstU.execute();
                    cstU.close();
                }
            }
            conn.close();

            Result = "S";
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
            e.printStackTrace();
        }
        return Result;
    }

    public void setPremiumMasksLOV(RichTable premiumMasksLOV) {
        this.premiumMasksLOV = premiumMasksLOV;
    }

    public RichTable getPremiumMasksLOV() {
        return this.premiumMasksLOV;
    }

    public String AssignPMasksLOV() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findPremiumMask1Iterator");
        RowKeySet set = this.premiumMasksLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
            this.premMasksDisplay.setValue(r.getAttribute("PMAS_SHT_DESC"));
            this.session.setAttribute("pmasCode", r.getAttribute("PMAS_CODE"));
            this.session.setAttribute("pmasShtDesc",
                                      r.getAttribute("PMAS_SHT_DESC"));

            this.session.setAttribute("coverMaskCode",
                                      r.getAttribute("PMAS_CODE"));
            this.maskDesc.setValue(r.getAttribute("PMAS_SHT_DESC"));

            this.session.setAttribute("categoryMaskCode",
                                      r.getAttribute("PMAS_CODE"));
            this.catMaskDesc.setValue(r.getAttribute("PMAS_SHT_DESC"));
        }
        return null;
    }

    public void setPremMasksDisplay(RichInputText premMasksDisplay) {
        this.premMasksDisplay = premMasksDisplay;
    }

    public RichInputText getPremMasksDisplay() {
        return this.premMasksDisplay;
    }

    public void setQuotationCalcType(RichSelectOneChoice quotationCalcType) {
        this.quotationCalcType = quotationCalcType;
    }

    public RichSelectOneChoice getQuotationCalcType() {
        return this.quotationCalcType;
    }

    public void setQuotationCovers(RichSelectOneChoice quotationCovers) {
        this.quotationCovers = quotationCovers;
    }

    public RichSelectOneChoice getQuotationCovers() {
        return this.quotationCovers;
    }

    public void setQuotationDurationType(RichSelectOneChoice quotationDurationType) {
        this.quotationDurationType = quotationDurationType;
    }

    public RichSelectOneChoice getQuotationDurationType() {
        return this.quotationDurationType;
    }

    public void setFrequencyOfPay(RichSelectOneChoice frequencyOfPay) {
        this.frequencyOfPay = frequencyOfPay;
    }

    public RichSelectOneChoice getFrequencyOfPay() {
        return this.frequencyOfPay;
    }

    public void setQuotationNumber(RichInputText quotationNumber) {
        this.quotationNumber = quotationNumber;
    }

    public RichInputText getQuotationNumber() {
        return this.quotationNumber;
    }

    public void setQuotationEffectiveDate(RichInputDate quotationEffectiveDate) {
        this.quotationEffectiveDate = quotationEffectiveDate;
    }

    public RichInputDate getQuotationEffectiveDate() {
        return this.quotationEffectiveDate;
    }

    public void setGroupLifeRider(RichSelectOneChoice groupLifeRider) {
        this.groupLifeRider = groupLifeRider;
    }

    public RichSelectOneChoice getGroupLifeRider() {
        return this.groupLifeRider;
    }

    public void setLoansSavingsRider(RichSelectOneChoice loansSavingsRider) {
        this.loansSavingsRider = loansSavingsRider;
    }

    public RichSelectOneChoice getLoansSavingsRider() {
        return this.loansSavingsRider;
    }

    public void GetSavingsRider(ValueChangeEvent valueChangeEvent) {
        if (this.loansSavingsRider.getValue() == null) {
            this.session.setAttribute("savingsRider", null);
        } else {
            this.session.setAttribute("savingsRider",
                                      this.loansSavingsRider.getValue().toString());
        }
    }

    public void setPensionType(RichSelectOneChoice pensionType) {
        this.pensionType = pensionType;
    }

    public RichSelectOneChoice getPensionType() {
        return this.pensionType;
    }

    public String Update_Earn_Pensions() {
        String Result = "F";
        String prodType = (String)this.session.getAttribute("productType");
        String Message = null;
        String updateQuery =
            "BEGIN LMS_WEB_PKG_GRP.update_quotations(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);END;";
        Connection conn = new DBConnector().getDatabaseConn();
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall(updateQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)this.session.getAttribute("QuoteCode"));
            cstmt.setBigDecimal(2, null);
            cstmt.setBigDecimal(3,
                                (BigDecimal)this.session.getAttribute("ProductCode"));
            cstmt.setString(4, null);
            cstmt.setBigDecimal(5, null);
            cstmt.setString(6, null);
            cstmt.setBigDecimal(7, null);
            cstmt.setString(8, null);
            cstmt.setString(9, null);
            cstmt.setString(10, null);
            cstmt.setString(11, null);

            cstmt.setString(12, null);
            cstmt.setBigDecimal(13, null);
            cstmt.setString(14, null);

            cstmt.setString(15, null);
            cstmt.setString(16, null);
            cstmt.setString(17, null);
            cstmt.setString(18, null);
            cstmt.setBigDecimal(19, null);
            cstmt.setBigDecimal(20, null);                        
            cstmt.setBigDecimal(21, null);
            cstmt.setBigDecimal(22, null);                        
            cstmt.setBigDecimal(23, null);
                          
            if (this.pensionType.getValue() == null) {
                cstmt.setString(24, null);
            } else {
                cstmt.setString(24, this.pensionType.getValue().toString());
            }

            if (this.guaranteePrdDisplay.getValue() == null) {
                cstmt.setString(25, null);
            } else {
                cstmt.setString(25,
                                this.guaranteePrdDisplay.getValue().toString());
            }

            if (this.pensEscDisplay.getValue() == null) {
                cstmt.setString(26, null);
            } else {
                cstmt.setString(26, this.pensEscDisplay.getValue().toString());
            }

            if (this.pensPayFrequency.getValue() == null) {
                cstmt.setString(27, null);
            } else {
                cstmt.setString(27,
                                this.pensPayFrequency.getValue().toString());
            }

            if (this.rmaleDisplay.getValue() == null) {
                cstmt.setString(28, null);
            } else {
                cstmt.setString(28, this.rmaleDisplay.getValue().toString());
            }

            if (this.rfemaleDisplay.getValue() == null) {
                cstmt.setString(29, null);
            } else {
                cstmt.setString(29, this.rfemaleDisplay.getValue().toString());
            }

            if (this.pensAdminDisplay.getValue() == null) {
                cstmt.setString(30, null);
            } else {
                cstmt.setString(30,
                                this.pensAdminDisplay.getValue().toString());
            }

            if (this.totEmpyeeContr.getValue() == null) {
                cstmt.setString(31, null);
            } else {
                cstmt.setString(31, this.totEmpyeeContr.getValue().toString());
            }

            if (this.totEmpyerContr.getValue() == null) {
                cstmt.setString(32, null);
            } else {
                cstmt.setString(32, this.totEmpyerContr.getValue().toString());
            }

            if (this.contrType.getValue() == null) {
                cstmt.setString(33, null);
            } else {
                cstmt.setString(33, this.contrType.getValue().toString());
            }

            if (this.empyerContrRate.getValue() == null) {
                cstmt.setString(34, null);
            } else {
                cstmt.setString(34,
                                this.empyerContrRate.getValue().toString());
            }

            if (this.empyeeContrRate.getValue() == null) {
                cstmt.setString(35, null);
            } else {
                cstmt.setString(35,
                                this.empyeeContrRate.getValue().toString());
            }

            if (this.fundingRate.getValue() == null) {
                cstmt.setString(36, null);
            } else {
                cstmt.setString(36, this.fundingRate.getValue().toString());
            }

            if (this.pensCommRate.getValue() == null) {
                cstmt.setString(37, null);
            } else {
                cstmt.setString(37, this.pensCommRate.getValue().toString());
            }

            if (this.emplyeeVolContr.getValue() == null) {
                cstmt.setString(38, null);
            } else {
                cstmt.setString(38,
                                this.emplyeeVolContr.getValue().toString());
            }

            if (this.empyeePensBF.getValue() == null) {
                cstmt.setString(39, null);
            } else {
                cstmt.setString(39, this.empyeePensBF.getValue().toString());
            }

            if (this.empyerPensBF.getValue() == null) {
                cstmt.setString(40, null);
            } else {
                cstmt.setString(40, this.empyerPensBF.getValue().toString());
            }

            if (this.totPensBF.getValue() == null) {
                cstmt.setString(41, null);
            } else {
                cstmt.setString(41, this.totPensBF.getValue().toString());
            }

            if (this.totPensBF.getValue() == null) {
                cstmt.setString(42, null);
            } else {
                cstmt.setString(42, this.totPensBF.getValue().toString());
            }

            if (this.pensInterestRate.getValue() == null) {
                cstmt.setString(43, null);
            } else {
                cstmt.setString(43,
                                this.pensInterestRate.getValue().toString());
            }

            if (this.penEarnEsc.getValue() == null) {
                cstmt.setString(44, null);
            } else {
                cstmt.setString(44, this.penEarnEsc.getValue().toString());
            }

            if (this.pensAverageANB.getValue() == null) {
                cstmt.setString(45, null);
            } else {
                cstmt.setString(45, this.pensAverageANB.getValue().toString());
            }
            if (this.pensAverageEarnings.getValue() == null) {
                cstmt.setString(46, null);
            } else {
                cstmt.setString(46,
                                this.pensAverageEarnings.getValue().toString());
            }
            if (prodType.equalsIgnoreCase("ANN")) {
                if (this.annuityOption.getValue() == null) {
                    cstmt.setString(47, null);
                } else {
                    cstmt.setString(47,
                                    this.annuityOption.getValue().toString());
                }
                if (this.annEscalation.getValue() == null) {
                    cstmt.setString(48, null);
                } else {
                    cstmt.setString(48,
                                    this.annEscalation.getValue().toString());
                }
                if (this.annPymtStructure.getValue() == null) {
                    cstmt.setString(49, null);
                } else {
                    cstmt.setString(49,
                                    this.annPymtStructure.getValue().toString());
                }
                if (this.benInvestRate.getValue() == null) {
                    cstmt.setString(50, null);
                } else {
                    cstmt.setString(50,
                                    this.benInvestRate.getValue().toString());
                }
                if (this.termPayoutRate.getValue() == null) {
                    cstmt.setString(51, null);
                } else {
                    cstmt.setString(51,
                                    this.termPayoutRate.getValue().toString());
                }
                if (this.annAdminCharge.getValue() == null) {
                    cstmt.setString(52, null);
                } else {
                    cstmt.setString(52,
                                    this.annAdminCharge.getValue().toString());
                }
                if (this.annInterestRate.getValue() == null) {
                    cstmt.setString(53, null);
                } else {
                    cstmt.setString(53,
                                    this.annInterestRate.getValue().toString());
                }
                if (this.schemeLegalAge.getValue() == null) {
                    cstmt.setString(54, null);
                } else
                    cstmt.setString(54,
                                    this.schemeLegalAge.getValue().toString());
            } else {
                cstmt.setString(47, null);
                cstmt.setString(48, null);
                cstmt.setString(49, null);
                cstmt.setString(50, null);
                cstmt.setString(51, null);
                cstmt.setString(52, null);
                cstmt.setString(53, null);
                cstmt.setString(54, null);
            }
            if (this.pensionMode.getValue() == null) {
                cstmt.setString(55, null);
            } else {
                cstmt.setString(55, this.pensionMode.getValue().toString());
            }
            if (this.pensionHistIntRate.getValue() == null) {
                cstmt.setString(56, null);
            } else {
                cstmt.setString(56,
                                this.pensionHistIntRate.getValue().toString());
            }
            if(totalMember.getValue()==null){
              cstmt.setString(57, null);
            }else{
              cstmt.setString(57, totalMember.getValue().toString());
            }
            cstmt.execute();
            conn.close();
            if (prodType.equalsIgnoreCase("PENS")) {
                Message = "Pension Details Successfully Updated.";
            } else if (prodType.equalsIgnoreCase("ANN")) {
                Message = "Annuity Details Successfully Updated.";
            } else if (prodType.equalsIgnoreCase("GRAT")) {
                Message = "Gratuity Details Successfully Updated.";
            }
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));

            Result = "S";
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return Result;
    }

    public void setGuaranteePrdDisplay(RichInputText guaranteePrdDisplay) {
        this.guaranteePrdDisplay = guaranteePrdDisplay;
    }

    public RichInputText getGuaranteePrdDisplay() {
        return this.guaranteePrdDisplay;
    }

    public void setPensEscDisplay(RichInputText pensEscDisplay) {
        this.pensEscDisplay = pensEscDisplay;
    }

    public RichInputText getPensEscDisplay() {
        return this.pensEscDisplay;
    }

    public void setPensPayFrequency(RichSelectOneChoice pensPayFrequency) {
        this.pensPayFrequency = pensPayFrequency;
    }

    public RichSelectOneChoice getPensPayFrequency() {
        return this.pensPayFrequency;
    }

    public void setRmaleDisplay(RichInputText rmaleDisplay) {
        this.rmaleDisplay = rmaleDisplay;
    }

    public RichInputText getRmaleDisplay() {
        return this.rmaleDisplay;
    }

    public void setRfemaleDisplay(RichInputText rfemaleDisplay) {
        this.rfemaleDisplay = rfemaleDisplay;
    }

    public RichInputText getRfemaleDisplay() {
        return this.rfemaleDisplay;
    }

    public void setPensAdminDisplay(RichInputText pensAdminDisplay) {
        this.pensAdminDisplay = pensAdminDisplay;
    }

    public RichInputText getPensAdminDisplay() {
        return this.pensAdminDisplay;
    }

    public void setTotEmpyeeContr(RichInputText totEmpyeeContr) {
        this.totEmpyeeContr = totEmpyeeContr;
    }

    public RichInputText getTotEmpyeeContr() {
        return this.totEmpyeeContr;
    }

    public void setTotEmpyerContr(RichInputText totEmpyerContr) {
        this.totEmpyerContr = totEmpyerContr;
    }

    public RichInputText getTotEmpyerContr() {
        return this.totEmpyerContr;
    }

    public void setContrType(RichSelectOneChoice contrType) {
        this.contrType = contrType;
    }

    public RichSelectOneChoice getContrType() {
        return this.contrType;
    }

    public void setEmpyerContrRate(RichInputText empyerContrRate) {
        this.empyerContrRate = empyerContrRate;
    }

    public RichInputText getEmpyerContrRate() {
        return this.empyerContrRate;
    }

    public void setEmpyeeContrRate(RichInputText empyeeContrRate) {
        this.empyeeContrRate = empyeeContrRate;
    }

    public RichInputText getEmpyeeContrRate() {
        return this.empyeeContrRate;
    }

    public void setFundingRate(RichInputText fundingRate) {
        this.fundingRate = fundingRate;
    }

    public RichInputText getFundingRate() {
        return this.fundingRate;
    }

    public void setPensCommRate(RichInputText pensCommRate) {
        this.pensCommRate = pensCommRate;
    }

    public RichInputText getPensCommRate() {
        return this.pensCommRate;
    }

    public void setEmpyerVolContr(RichInputText empyerVolContr) {
        this.empyerVolContr = empyerVolContr;
    }

    public RichInputText getEmpyerVolContr() {
        return this.empyerVolContr;
    }

    public void setEmplyeeVolContr(RichInputText emplyeeVolContr) {
        this.emplyeeVolContr = emplyeeVolContr;
    }

    public RichInputText getEmplyeeVolContr() {
        return this.emplyeeVolContr;
    }

    public void setEmpyerPensBF(RichInputText empyerPensBF) {
        this.empyerPensBF = empyerPensBF;
    }

    public RichInputText getEmpyerPensBF() {
        return this.empyerPensBF;
    }

    public void setEmpyeePensBF(RichInputText empyeePensBF) {
        this.empyeePensBF = empyeePensBF;
    }

    public RichInputText getEmpyeePensBF() {
        return this.empyeePensBF;
    }

    public void setTotPensBF(RichInputText totPensBF) {
        this.totPensBF = totPensBF;
    }

    public RichInputText getTotPensBF() {
        return this.totPensBF;
    }

    public void setPensInterestRate(RichInputText pensInterestRate) {
        this.pensInterestRate = pensInterestRate;
    }

    public RichInputText getPensInterestRate() {
        return this.pensInterestRate;
    }

    public String DeleteQuotCoverType() {
        BigDecimal Code = null;
        Connection conn = null;
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findQuoteCoverTypesIterator");
            RowKeySet set = this.quotCoverTypes.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                Code = (BigDecimal)r.getAttribute("QCVT_CODE");
            }

            String deleteQuery =
                "BEGIN LMS_WEB_PKG_GRP.delete_quot_cover_type(?,?);END;";
            conn = new DBConnector().getDatabaseConn();

            CallableStatement cstmt = conn.prepareCall(deleteQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)this.session.getAttribute("QuoteCode"));
            cstmt.setBigDecimal(2, Code);
            cstmt.execute();
            conn.close();
            ADFUtils.findIterator("findQuoteCoverTypesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.quotCoverTypes);

            this.coverButChargePremium.setValue(null);
            this.discLoadChoice.setValue(null);
            this.discLoadRateDisplay.setValue(null);
            this.divFactor.setValue(null);
            this.session.setAttribute("qcvtCode", null);

            AdfFacesContext.getCurrentInstance().addPartialTarget(this.coverButChargePremium);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.discLoadChoice);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.discLoadRateDisplay);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public void setQuotCoverTypes(RichTable quotCoverTypes) {
        this.quotCoverTypes = quotCoverTypes;
    }

    public RichTable getQuotCoverTypes() {
        return this.quotCoverTypes;
    }

    public String DeleteTaxes() {
        Connection conn = null;
        try {
            String deleteQuery = "BEGIN LMS_WEB_PKG_GRP.delete_taxes(?);END;";
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findQuotationTaxes1Iterator");
            RowKeySet set = this.quotationTaxes.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                this.session.setAttribute("taxCode",
                                          r.getAttribute("qtax_code"));

                conn = new DBConnector().getDatabaseConn();

                CallableStatement cstmt = conn.prepareCall(deleteQuery);
                cstmt.setBigDecimal(1,
                                    (BigDecimal)this.session.getAttribute("taxCode"));
                cstmt.execute();
                conn.close();
                ADFUtils.findIterator("findQuotationTaxes1Iterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.quotationTaxes);
            }
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public void setQuotationTaxes(RichTable quotationTaxes) {
        this.quotationTaxes = quotationTaxes;
    }

    public RichTable getQuotationTaxes() {
        return this.quotationTaxes;
    }

    public String ShowTaxes() {
        String populateTaxes =
            "BEGIN LMS_WEB_PKG_GRP.populate_taxes(?,?,?);END;";
        Connection conn = new DBConnector().getDatabaseConn();
        try {
            CallableStatement cstmt = conn.prepareCall(populateTaxes);
            cstmt.setBigDecimal(1,
                                (BigDecimal)this.session.getAttribute("QuoteCode"));
            cstmt.setString(2, null);
            cstmt.setString(3, null);
            cstmt.execute();
            conn.close();
            System.out.println("Taxes populated ");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public String BackToLangingScreen() {
        try {
          this.session.setAttribute("covdetails",null);
          this.session.setAttribute("MemberNumber",null);
          this.session.setAttribute("quoteMemMemCode", null);
            GlobalCC.RedirectPage("/gquoedt.jspx");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public void setQuotCategoriesLOV(RichTable quotCategoriesLOV) {
        this.quotCategoriesLOV = quotCategoriesLOV;
    }

    public RichTable getQuotCategoriesLOV() {
        return this.quotCategoriesLOV;
    }

    public String SchoolClassSelected() {
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findSchClassesIterator");
            RowKeySet set = this.classesLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();
                this.session.setAttribute("schCode",
                                          r.getAttribute("SCH_CODE"));
                this.categID.setValue(r.getAttribute("SCH_SHT_DESC"));
                this.categDescription.setValue(r.getAttribute("SCH_DESC"));
                this.categoryPeriod.setValue(r.getAttribute("SLVL_TERM_DURATION"));
            }
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String SaveQuotCategories() {
      Connection conn = new DBConnector().getDatabaseConn();
      Rendering render=new Rendering();
        if (this.categDescription.getValue() == null) {
            GlobalCC.INFORMATIONREPORTING("Enter a Category Description");
            return null;
        }
        if (this.categID.getValue() == null) {
            GlobalCC.INFORMATIONREPORTING("Enter a Category ID");
            return null;
        }
        
        if(render.isEarningsproduct()){
        if (this.categoryPeriod.getValue() == null) {
            GlobalCC.INFORMATIONREPORTING("Enter a Category Period");
            return null;
        }
        }else{
          this.categoryPeriod.setValue(1);
        }
        String updateQuery =
            "BEGIN LMS_WEB_PKG_GRP.add_category(?,?,?,?,?,?,?,?,?,?,?);END;";
       
        try {
            CallableStatement cstmt = conn.prepareCall(updateQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)this.session.getAttribute("lcaCode"));
            cstmt.setBigDecimal(2,
                                (BigDecimal)this.session.getAttribute("QuoteCode"));
            if (this.categID.getValue() == null)
                cstmt.setString(3, null);
            else {
                cstmt.setString(3, this.categID.getValue().toString());
            }
            if (this.categDescription.getValue() == null)
                cstmt.setString(4, null);
            else {
                cstmt.setString(4,
                                this.categDescription.getValue().toString());
            }
            if (this.categoryPeriod.getValue() == null)
                cstmt.setString(5, null);
            else {
                cstmt.setString(5, this.categoryPeriod.getValue().toString());
            }
            cstmt.setString(6, null);
            cstmt.setString(7, null);
            cstmt.setBigDecimal(8,
                                (BigDecimal)this.session.getAttribute("schCode"));
            if (this.categoryFees.getValue() == null)
                cstmt.setString(9, null);
            else {
                cstmt.setString(9, this.categoryFees.getValue().toString());
            }
            if (this.categoryStudents.getValue() == null)
                cstmt.setString(10, null);
            else {
                cstmt.setString(10,
                                this.categoryStudents.getValue().toString());
            }
            cstmt.setBigDecimal(11,
                                (BigDecimal)this.session.getAttribute("categoryMaskCode"));

            cstmt.execute();
            conn.close();

            if (this.session.getAttribute("lcaCode") == null) {
                this.session.setAttribute("lcaCode", null);

                this.categID.setValue(null);
                this.categDescription.setValue(null);
                this.categoryPeriod.setValue(null);
                this.categoryFees.setValue(null);
                this.categoryStudents.setValue(null);
            }

            ADFUtils.findIterator("findQuoteCategoriesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.categoryTree);
            ADFUtils.findIterator("findCategoryIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.classesCategoriesLOV);
        } catch (Exception e) {
            this.categID.setValue(null);
            this.categDescription.setValue(null);
            this.categoryPeriod.setValue(null);
            this.categoryFees.setValue(null);
            this.categoryStudents.setValue(null);
            this.session.setAttribute("lcaCode", null);

            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }

        return null;
    }

    public void setCategID(RichInputText categID) {
        this.categID = categID;
    }

    public RichInputText getCategID() {
        return this.categID;
    }

    public void setCategDescription(RichInputText categDescription) {
        this.categDescription = categDescription;
    }

    public RichInputText getCategDescription() {
        return this.categDescription;
    }

    public void setCategoryPeriod(RichInputText categoryPeriod) {
        this.categoryPeriod = categoryPeriod;
    }

    public RichInputText getCategoryPeriod() {
        return this.categoryPeriod;
    }

    public String AddMultipleClasses() {
        this.session.setAttribute("lcaCode", null);
        this.session.setAttribute("schCode", null);
        this.categID.setValue(null);
        this.categDescription.setValue(null);
        this.categoryPeriod.setValue(null);
        ADFUtils.findIterator("findQuoteDependantLimitsIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.quotationDependentsLOV);
        ADFUtils.findIterator("findQuotePolClassesIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.allClassesTable);

        GlobalCC.showPopup("lmsgroup:availClass");

        return null;
    }

    public String SaveMultipleClasses() {
        Connection conn = null;
        try {
            boolean MakeCall = false;
            DBConnector db = new DBConnector();
            conn = db.getDatabaseConn();

            CallableStatement cst = null;
            List ReinstInfo = new LinkedList();
            ARRAY array = null;

            ArrayDescriptor descriptor =
                ArrayDescriptor.createDescriptor("LMS_CLASSES_LOADING_TAB",
                                                 conn);

            cst =
conn.prepareCall("BEGIN LMS_WEB_PKG_GRP.save_multiple_classes(?,?,?);end;");

            int rowCount = 0;
            boolean Value = false;
            rowCount = this.allClassesTable.getRowCount();
            if (rowCount == 0) {
                return null;
            }

            for (int i = 0; i < rowCount; i++) {
                this.allClassesTable.setRowIndex(i);
                JUCtrlValueBinding nodeBinding =
                    (JUCtrlValueBinding)this.allClassesTable.getRowData();

                if (nodeBinding != null) {
                    Value =
                            ((Boolean)nodeBinding.getAttribute("selected")).booleanValue();
                    if (Value == true) {
                        MakeCall = true;

                        SchoolClasses pn = new SchoolClasses();

                        pn.setSCH_CODE((BigDecimal)nodeBinding.getAttribute("SCH_CODE"));
                        if (this.feesAmount.getValue() == null)
                            pn.setSCH_FEES(null);
                        else {
                            pn.setSCH_FEES(new BigDecimal(this.feesAmount.getValue().toString()));
                        }
                        if (this.termDuration.getValue() == null)
                            pn.setSCH_DURATION(null);
                        else {
                            pn.setSCH_DURATION(new BigDecimal(this.termDuration.getValue().toString()));
                        }
                        if (this.noOfStudents.getValue() == null)
                            pn.setSCH_AV_STUDENTS(null);
                        else {
                            pn.setSCH_AV_STUDENTS(new BigDecimal(this.noOfStudents.getValue().toString()));
                        }
                        ReinstInfo.add(pn);
                    }
                }
            }

            if (MakeCall == true) {
                array = new ARRAY(descriptor, conn, ReinstInfo.toArray());

                cst.setArray(1, array);
                cst.setString(2, "Q");
                cst.setBigDecimal(3,
                                  (BigDecimal)this.session.getAttribute("QuoteCode"));
                cst.execute();
                cst.close();
                conn.close();

                ADFUtils.findIterator("findQuoteCategoriesIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.categoryTree);
                ADFUtils.findIterator("findCategoryIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.classesCategoriesLOV);
                GlobalCC.INFORMATIONREPORTING("Classes Successfully Populated.");

                GlobalCC.hidePopup("lmsgroup:availClass");
            }
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public void ClassesListener(ValueChangeEvent valueChangeEvent) {
        if (valueChangeEvent.getOldValue() != valueChangeEvent.getNewValue()) {
            RowKeySet rowKeySet = this.allClassesTable.getSelectedRowKeys();
            if (rowKeySet == null) {
                return;
            }
            if (!rowKeySet.iterator().hasNext()) {
                GlobalCC.errorValueNotEntered("No Record Selected");
                return;
            }
            Object key2 = rowKeySet.iterator().next();
            this.allClassesTable.setRowKey(key2);
            JUCtrlValueBinding nodeBinding =
                (JUCtrlValueBinding)this.allClassesTable.getRowData();

            if (nodeBinding == null) {
                GlobalCC.errorValueNotEntered("No Record Selected");
                return;
            }

            if (this.classesCbox.isSelected())
                nodeBinding.setAttribute("selected", Boolean.valueOf(true));
            else
                nodeBinding.setAttribute("selected", Boolean.valueOf(false));
        }
    }

    public String deleteQuotationCategory() {
        String deleteQuery = "BEGIN LMS_WEB_PKG_GRP.delete_category(?,?);END;";

        Connection conn = new DBConnector().getDatabaseConn();
        try {
            CallableStatement cstmt = conn.prepareCall(deleteQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)this.session.getAttribute("lcaCode"));
            cstmt.setString(2, "Q");
            cstmt.execute();
            this.session.setAttribute("lcaCode", null);
            this.session.setAttribute("schCode", null);
            this.categID.setValue(null);
            this.categDescription.setValue(null);
            this.categoryPeriod.setValue(null);
            this.categoryFees.setValue(null);
            this.categoryStudents.setValue(null);

            conn.close();
            ADFUtils.findIterator("findQuoteCategoriesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.categoryTree);
            ADFUtils.findIterator("findQuoteDependantLimitsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.quotationDependentsLOV);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public String AssignCategoryDpds() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findCategoryIterator");
        RowKeySet set = this.dpdCategLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            this.session.setAttribute("lcaCode", r.getAttribute("lcaCode"));
            this.dependentCategory.setValue(r.getAttribute("catDesc"));
        }

        return null;
    }

    public void setDpdCategLOV(RichTable dpdCategLOV) {
        this.dpdCategLOV = dpdCategLOV;
    }

    public RichTable getDpdCategLOV() {
        return this.dpdCategLOV;
    }

    public void setDependentCategory(RichInputText dependentCategory) {
        this.dependentCategory = dependentCategory;
    }

    public RichInputText getDependentCategory() {
        return this.dependentCategory;
    }

    public void setDpdLimitAmount(RichInputText dpdLimitAmount) {
        this.dpdLimitAmount = dpdLimitAmount;
    }

    public RichInputText getDpdLimitAmount() {
        return this.dpdLimitAmount;
    }

    public void setDependentType(RichInputText dependentType) {
        this.dependentType = dependentType;
    }

    public RichInputText getDependentType() {
        return this.dependentType;
    }

    public String SaveDependentType() {
        if (this.dpdLimitAmount.getValue() == null) {
            GlobalCC.INFORMATIONREPORTING("Enter a Limit Amount");
            return null;
        }

        String saveQuery =
            "BEGIN LMS_WEB_PKG_GRP.save_quotation_dependents(?,?,?,?,?,?,?,?,?,?,?);END;";
        Connection conn = new DBConnector().getDatabaseConn();
        try {
            CallableStatement cstmt = conn.prepareCall(saveQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)this.session.getAttribute("dtyCode"));
            cstmt.setBigDecimal(2, null);
            if (this.maxType.getValue() == null)
                cstmt.setBigDecimal(3, null);
            else {
                cstmt.setString(3, this.maxType.getValue().toString());
            }

            cstmt.setBigDecimal(4,
                                (BigDecimal)this.session.getAttribute("qdlCode"));
            cstmt.setBigDecimal(5,
                                (BigDecimal)this.session.getAttribute("qcvtCode"));

            cstmt.setBigDecimal(6, null);
            cstmt.setBigDecimal(7,
                                (BigDecimal)this.session.getAttribute("QuoteCode"));
            if (this.dpdLimitAmount.getValue() == null)
                cstmt.setBigDecimal(8, null);
            else {
                cstmt.setBigDecimal(8,
                                    new BigDecimal(this.dpdLimitAmount.getValue().toString()));
            }
            cstmt.setBigDecimal(9, null);
            cstmt.setBigDecimal(10,
                                (BigDecimal)this.session.getAttribute("lcaCode"));
            if (this.dpdMinAmount.getValue() == null)
                cstmt.setBigDecimal(11, null);
            else {
                cstmt.setBigDecimal(11,
                                    new BigDecimal(this.dpdMinAmount.getValue().toString()));
            }
            cstmt.execute();
            conn.close();
            ADFUtils.findIterator("findQuoteDependantLimitsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.quotationDependentsLOV);
            GlobalCC.hidePopup("lmsgroup:depend2");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }

        return null;
    }

    public void QuoteCoverTypeListener(ValueChangeEvent valueChangeEvent) {
        if (valueChangeEvent.getNewValue() != null) {
            if ((valueChangeEvent.getOldValue() !=
                 valueChangeEvent.getNewValue()) &&
                (this.dpdCoverType.getValue() != null)) {
                DCIteratorBinding dciter =
                    ADFUtils.findIterator("findQuoteCoverTypesIterator");

                Row r =
                    dciter.getRowAtRangeIndex(((Integer)valueChangeEvent.getNewValue()).intValue());

                this.session.setAttribute("qcvtCode",
                                          r.getAttribute("QCVT_CODE"));
                this.session.setAttribute("qcvtcvtCode",
                                          r.getAttribute("QCVT_CVT_CODE"));

                this.dependentTypeDisplay.setValue(null);

                ADFUtils.findIterator("FindDependentsIter").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.dependentTypeDisplay);
            }
        }
    }

    public void CoverTypeDependantListener(ValueChangeEvent valueChangeEvent) {
        if (valueChangeEvent.getNewValue() != null) {
            if ((valueChangeEvent.getOldValue() !=
                 valueChangeEvent.getNewValue()) &&
                (this.dependentTypeDisplay.getValue() != null)) {
                DCIteratorBinding dciter =
                    ADFUtils.findIterator("FindDependentsIter");

                Row r =
                    dciter.getRowAtRangeIndex(((Integer)valueChangeEvent.getNewValue()).intValue());

                this.session.setAttribute("dtyCode",
                                          r.getAttribute("DTY_CODE"));
                this.session.setAttribute("maxType",
                                          r.getAttribute("PCD_MAX_NO_ALLOWED"));
                this.maxType.setValue(r.getAttribute("PCD_MAX_NO_ALLOWED"));
                this.dpdLimitAmount.setValue(r.getAttribute("PCD_MAX_SUM_ASSURED"));
                this.dpdMinAmount.setValue(r.getAttribute("PCD_MIN_SUM_ASSURED"));

                AdfFacesContext.getCurrentInstance().addPartialTarget(this.dependentTypeDisplay);
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.dpdLimitAmount);
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.maxType);
            }
        }
    }

    public String AddDependantLimit() {
        try {
            String prodType = (String)this.session.getAttribute("productType");
            if (prodType != null) {
                if (!prodType.equalsIgnoreCase("LOAN")) {
                    if (this.session.getAttribute("lcaCode") == null) {
                        GlobalCC.INFORMATIONREPORTING("Select A Category");
                        return null;
                    }
                }
            }
            this.dpdCoverType.setValue(null);
            this.maxType.setValue(null);
            this.dpdLimitAmount.setValue(null);
            this.dpdMinAmount.setValue(null);

            this.session.setAttribute("dtyCode", null);
            this.session.setAttribute("maxType", null);
            this.session.setAttribute("CoverTypeCode", null);
            this.session.setAttribute("qcvtCode", null);
            this.session.setAttribute("qcvtcvtCode", null);
            this.session.setAttribute("qdlCode", null);

            this.dependentTypeDisplay.setValue(null);
            ADFUtils.findIterator("FindDependentsIter").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.dependentTypeDisplay);

            GlobalCC.showPopup("lmsgroup:depend2");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public void setDependentTypesLOV(RichTable dependentTypesLOV) {
        this.dependentTypesLOV = dependentTypesLOV;
    }

    public RichTable getDependentTypesLOV() {
        return this.dependentTypesLOV;
    }

    public String AssignDependentTypes() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findProdDependentsIterator");
        RowKeySet set = this.dependentTypesLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            this.session.setAttribute("dtyCode", r.getAttribute("DTY_CODE"));
            this.dependentType.setValue(r.getAttribute("DTY_DESCRIPTION"));

            this.session.setAttribute("maxTypeNo",
                                      r.getAttribute("max_allowed"));
        }

        return null;
    }

    public void setDependentCoverTypes(RichTable dependentCoverTypes) {
        this.dependentCoverTypes = dependentCoverTypes;
    }

    public RichTable getDependentCoverTypes() {
        return this.dependentCoverTypes;
    }

    public void setDependentANB(RichInputText dependentANB) {
        this.dependentANB = dependentANB;
    }

    public RichInputText getDependentANB() {
        return this.dependentANB;
    }

    public void setDpdMonthlyIncome(RichInputText dpdMonthlyIncome) {
        this.dpdMonthlyIncome = dpdMonthlyIncome;
    }

    public RichInputText getDpdMonthlyIncome() {
        return this.dpdMonthlyIncome;
    }

    public void setQuotationDependentsLOV(RichTable quotationDependentsLOV) {
        this.quotationDependentsLOV = quotationDependentsLOV;
    }

    public RichTable getQuotationDependentsLOV() {
        return this.quotationDependentsLOV;
    }

    public String DeleteDependentLimit() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findQuoteDependantLimitsIterator");
        RowKeySet set = this.quotationDependentsLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            this.session.setAttribute("qdlCode", r.getAttribute("QDL_CODE"));
        }

        String deleteQuery =
            "BEGIN LMS_WEB_PKG_GRP.delete_dpd_limit(?,?);END;";
        Connection conn = new DBConnector().getDatabaseConn();
        try {
            CallableStatement cstmt = conn.prepareCall(deleteQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)this.session.getAttribute("qdlCode"));
            cstmt.setString(2, "Q");
            cstmt.execute();
            conn.close();
            ADFUtils.findIterator("findQuoteDependantLimitsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.quotationDependentsLOV);

            this.dpdLimitAmount.setValue(null);
            this.maxType.setValue(null);

            AdfFacesContext.getCurrentInstance().addPartialTarget(this.dpdLimitAmount);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.maxType);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }

        return null;
    }

    public void setProvID(RichInputText provID) {
        this.provID = provID;
    }

    public RichInputText getProvID() {
        return this.provID;
    }

    public void setProvisions(RichInputText provisions) {
        this.provisions = provisions;
    }

    public RichInputText getProvisions() {
        return this.provisions;
    }

    public void setProvEditable(RichSelectOneChoice provEditable) {
        this.provEditable = provEditable;
    }

    public RichSelectOneChoice getProvEditable() {
        return this.provEditable;
    }

    public String AssignProvision() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findProductProvisionsIterator");
        RowKeySet set = this.productProvisionsLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            this.session.setAttribute("pprov_Code",
                                      r.getAttribute("PPROV_CODE"));
            this.provID.setValue(r.getAttribute("PROV_SHT_DESC"));
            this.provisions.setValue(r.getAttribute("PROV_DESC"));
        }

        return null;
    }

    public void setProductProvisionsLOV(RichTable productProvisionsLOV) {
        this.productProvisionsLOV = productProvisionsLOV;
    }

    public RichTable getProductProvisionsLOV() {
        return this.productProvisionsLOV;
    }

    public void setCoverProvisionsLOV(RichTable coverProvisionsLOV) {
        this.coverProvisionsLOV = coverProvisionsLOV;
    }

    public RichTable getCoverProvisionsLOV() {
        return this.coverProvisionsLOV;
    }

    public void setCoverTypeProvisions(RichTable coverTypeProvisions) {
        this.coverTypeProvisions = coverTypeProvisions;
    }

    public RichTable getCoverTypeProvisions() {
        return this.coverTypeProvisions;
    }

    public String ShowMembers() {
        try {
            GlobalCC.RedirectPage("/memcovers.jspx");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String DeleteCoverProvision() {
        Connection conn = null;
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findQuoteProvisionsIterator");
            RowKeySet set = this.coverTypeProvisions.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                this.session.setAttribute("qcprCode",
                                          r.getAttribute("qpprCode"));

                String deleteQuery =
                    "BEGIN LMS_WEB_PKG_GRP.deleteCoverProvision(?,?);END;";
                conn = new DBConnector().getDatabaseConn();

                CallableStatement cstmt = conn.prepareCall(deleteQuery);
                cstmt.setBigDecimal(1,
                                    (BigDecimal)this.session.getAttribute("qcprCode"));
                cstmt.setString(2, "Q");
                cstmt.execute();
                conn.close();
                ADFUtils.findIterator("findQuoteProvisionsIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.coverTypeProvisions);
            }
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }

        return null;
    }

    public String ShowProvisions() {
        String populateProvisions =
            "BEGIN LMS_WEB_PKG_GRP.populateProvisions(?,?,?);END;";
        Connection conn = new DBConnector().getDatabaseConn();
        try {
            CallableStatement cstmt = conn.prepareCall(populateProvisions);
            cstmt.setBigDecimal(1,
                                (BigDecimal)this.session.getAttribute("ProductCode"));
            cstmt.setBigDecimal(2,
                                (BigDecimal)this.session.getAttribute("QuoteCode"));
            cstmt.setString(3, "Q");
            cstmt.execute();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }

        return null;
    }

    public void setOldANBDisplay(RichInputText oldANBDisplay) {
        this.oldANBDisplay = oldANBDisplay;
    }

    public RichInputText getOldANBDisplay() {
        return this.oldANBDisplay;
    }

    public void setNewANBDisplay(RichInputText newANBDisplay) {
        this.newANBDisplay = newANBDisplay;
    }

    public RichInputText getNewANBDisplay() {
        return this.newANBDisplay;
    }

    public void setOldANBDisp(RichOutputText oldANBDisp) {
        this.oldANBDisp = oldANBDisp;
    }

    public RichOutputText getOldANBDisp() {
        return this.oldANBDisp;
    }

    public void setMemberCoversLOV(RichTable memberCoversLOV) {
        this.memberCoversLOV = memberCoversLOV;
    }

    public RichTable getMemberCoversLOV() {
        return this.memberCoversLOV;
    }

    public String DeleteFromAllMembers() {
        Connection conn = null;
        try {
            String DeleteMemberQuery =
                "BEGIN LMS_WEB_PKG_GRP.delete_quot_member(?,?,?,?);END;";
            conn = new DBConnector().getDatabaseConn();
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findQuoteMembersIterator");
            RowKeySet set = this.allMembers.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();
                this.session.setAttribute("qmemCode",
                                          r.getAttribute("QMEM_MEM_CODE"));
                this.session.setAttribute("dtyCode",
                                          r.getAttribute("QMEM_DTY_CODE"));
                CallableStatement cstmt = conn.prepareCall(DeleteMemberQuery);
                cstmt.setBigDecimal(1,
                                    (BigDecimal)this.session.getAttribute("QuoteCode"));
                cstmt.setBigDecimal(2,
                                    (BigDecimal)this.session.getAttribute("qmemCode"));
                cstmt.setString(3,
                                (String)this.session.getAttribute("dpdsCovered"));
                cstmt.setBigDecimal(4,
                                    (BigDecimal)this.session.getAttribute("dtyCode"));
                cstmt.execute();
            }

            conn.close();
            ADFUtils.findIterator("findQuoteMembersIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.memberCoversLOV);
            ADFUtils.findIterator("findQuoteMembersIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.allMembers);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.memberCoversLOV);
            this.session.setAttribute("quoteMemMemCode", null);
            ADFUtils.findIterator("findMemberBeneficiariesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.memberBeneficiariesLOV);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public String DeleteQuotationSchedule() {
        Connection conn = null;
        try {
            String DeleteMemberQuery =
                "BEGIN LMS_GRP_MISC.delete_quo_schedule(?,?);END;";
            conn = new DBConnector().getDatabaseConn();
            CallableStatement cstmt = conn.prepareCall(DeleteMemberQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)this.session.getAttribute("QuoteCode"));
            cstmt.setBigDecimal(2, null);
            cstmt.execute();
            ADFUtils.findIterator("findQuoteMembersIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.memberCoversLOV);
            ADFUtils.findIterator("findQuoteMembersIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.allMembers);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.memberCoversLOV);
            this.session.setAttribute("quoteMemMemCode", null);
            ADFUtils.findIterator("findMemberBeneficiariesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.memberBeneficiariesLOV);

            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public String ShowCoverDetails() {
        Connection conn = null;
        try {
            String computeQuery =
                "BEGIN LMS_WEB_PKG_GRP.compute_qout_premium(?);END;";
            conn = new DBConnector().getDatabaseConn();
            CallableStatement cstmt = null;
            cstmt = conn.prepareCall(computeQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)this.session.getAttribute("QuoteCode"));
            cstmt.execute();
            conn.close();
            GlobalCC.RedirectPage("/memcovers.jspx");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }

        return null;
    }

    public String GetAssignee() {
        try {
            this.session.setAttribute("SetAssignee", "N");
            System.out.println("enter popup");
            ExtendedRenderKitService erkService =
                (ExtendedRenderKitService)Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                                             ExtendedRenderKitService.class);

            erkService.addScript(FacesContext.getCurrentInstance(),
                                 "var hints = {autodismissNever:false}; AdfPage.PAGE.findComponent('lmsgroup:users').show(hints);");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String SetAssignee() {
        try {
            String NextUser = null;
            this.session.setAttribute("ProcessShtDesc", "QUOT");
            this.session.setAttribute("ProcessAreaShtDesc", "DENTR");
            this.session.setAttribute("ProcessSubAShtDesc", "QUOTD");
            this.session.setAttribute("NextTaskAssignee", "N");

            this.session.setAttribute("TaskAssignee", null);
            ADFUtils.findIterator("findTicketAssigneeIterator").executeQuery();
            NextUser = (String)this.session.getAttribute("NextTaskAssignee");
            NextUser = (String)this.session.getAttribute("NextTaskAssignee");
            String TaskAss = (String)this.session.getAttribute("TaskAssignee");
            if ((TaskAss == null) && (NextUser.equalsIgnoreCase("N"))) {
                String Message =
                    "There is no User to Assign this Task. Consult the Administrator.";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));

                return null;
            }

            this.session.setAttribute("NextTaskAssignee", "N");

            this.session.setAttribute("SetAssignee", "Y");
            System.out.println("enter popup");
            ExtendedRenderKitService erkService =
                (ExtendedRenderKitService)Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                                             ExtendedRenderKitService.class);

            erkService.addScript(FacesContext.getCurrentInstance(),
                                 "var hints = {autodismissNever:false}; AdfPage.PAGE.findComponent('lmsgroup:users').show(hints);");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String AssignTask() {
        Connection conn = null;
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findTicketAssigneeIterator");
            RowKeySet set = this.usersLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                this.session.setAttribute("TaskAssigneeID",
                                          r.getAttribute("taskUserID"));
                this.session.setAttribute("TaskAssignee",
                                          r.getAttribute("taskUserShtDesc"));

                this.session.setAttribute("TicketRemarks", null);
                if ((this.ticketRemarks.getValue() == null) ||
                    (this.ticketRemarks.getValue().toString().equalsIgnoreCase("Add Remark...")))
                    this.session.setAttribute("TicketRemarks", null);
                else {
                    this.session.setAttribute("TicketRemarks",
                                              this.ticketRemarks.getValue().toString());
                }

            }

            workflowProcessing bpm = new workflowProcessing();
            String Reassign = null;
            Reassign = (String)this.session.getAttribute("SetAssignee");
            if (Reassign.equalsIgnoreCase("Y")) {
                wfEngine wf = new wfEngine();
                wf.AssignTask((String)this.session.getAttribute("TaskID"),
                              (String)this.session.getAttribute("TaskAssignee"));

                conn = new DBConnector().getDatabaseConn();
                CallableStatement cst3 = null;
                String Complete =
                    "BEGIN TQC_WEB_PKG.reassign_task(?,?,?);END;";
                cst3 = conn.prepareCall(Complete);
                cst3.setString(1, (String)this.session.getAttribute("TaskID"));
                cst3.setString(2,
                               (String)this.session.getAttribute("TaskAssignee"));
                if ((this.ticketRemarks.getValue() == null) ||
                    (this.ticketRemarks.getValue().toString().equalsIgnoreCase("Add Remark...")))
                    cst3.setString(3, null);
                else {
                    cst3.setString(3,
                                   this.ticketRemarks.getValue().toString());
                }
                cst3.execute();
                conn.close();

                String Message = "Task Successfully ReAssigned.";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));

                this.session.setAttribute("TaskID", null);
                GlobalCC.RedirectPage("/lmsmain.jspx");
                return null;
            }

            bpm.CompleteTask();
            String TaskAns = (String)this.session.getAttribute("TaskAssignee");
            if (!TaskAns.equalsIgnoreCase((String)this.session.getAttribute("Username"))) {
                String Message =
                    "Current Task Complete. The Next Task " + (String)this.session.getAttribute("TaskActivityName") +
                    " has been Successfully assigned to " +
                    (String)this.session.getAttribute("TaskAssignee");
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));

                return null;
            }

            GlobalCC.RedirectPage("/gquoedt.jspx");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }

        return null;
    }

    public String ShowBackPage() {
        String Rights = null;
        String NextUser = null;
        workflowProcessing bpm = new workflowProcessing();
        try {
            session.setAttribute("srchMemName", null);
            session.setAttribute("srchMemNo", null);
            
            this.session.setAttribute("qcvtCode", null);
            String Value = bpm.CheckBPMParameter("QUOTATIONS_BPM");

            if (Value.equalsIgnoreCase("Y")) {
                this.session.setAttribute("ProcessShtDesc", "QUOT");
                this.session.setAttribute("ProcessAreaShtDesc", "DENTR");
                this.session.setAttribute("ProcessSubAShtDesc", "QUOTD");

                Rights = bpm.CheckUserRights();
                if (Rights.equalsIgnoreCase("N")) {
                    GlobalCC.sysInformation("You do not have rights to Complete this Task.");
                    return null;
                }

                this.session.setAttribute("ProcessShtDesc", "QUOT");
                this.session.setAttribute("ProcessAreaShtDesc", "QUW");
                this.session.setAttribute("ProcessSubAShtDesc", "QUWP");
                this.session.setAttribute("TaskAssignee", null);

                this.session.setAttribute("NextTaskAssignee", "N");
                ADFUtils.findIterator("findTicketAssigneeIterator").executeQuery();
                NextUser =
                        (String)this.session.getAttribute("NextTaskAssignee");
                String TaskAss =
                    (String)this.session.getAttribute("TaskAssignee");
                if ((TaskAss == null) && (NextUser.equalsIgnoreCase("N"))) {
                    GlobalCC.sysInformation("There is no User to Assign the Next Task. Consult the Administrator.");
                    return null;
                }
                String Taske = (String)this.session.getAttribute("TaskID");
                if (Taske == null) {
                    GlobalCC.sysInformation("No Task Selected");
                    return null;
                }
                Connection conn = new DBConnector().getDatabaseConn();
                String MyTask = null;
                CallableStatement cst3 = null;
                String Complete =
                    "BEGIN TQC_WEB_PKG.check_task_completion(?,?,?,?);END;";
                cst3 = conn.prepareCall(Complete);
                cst3.setString(1, "QDTE");
                cst3.setString(2, (String)this.session.getAttribute("TaskID"));
                cst3.setBigDecimal(3, new BigDecimal(27));
                cst3.registerOutParameter(4, 12);
                cst3.execute();
                MyTask = cst3.getString(4);
                conn.close();
                if (MyTask.equalsIgnoreCase("Y")) {
                    Rights = bpm.CheckUserRights();
                    if (Rights.equalsIgnoreCase("Y")) {
                        this.session.setAttribute("TicketRemarks", null);
                        bpm.CompleteTask();
                        GlobalCC.RedirectPage("/gquoedt.jspx");
                     
                    } else {
                        ADFUtils.findIterator("findTicketAssigneeIterator").executeQuery();
                        TaskAss =
                                (String)this.session.getAttribute("TaskAssignee");
                        if (TaskAss == null) {
                            GetAssignee();
                            return null;
                        }
                        bpm.CompleteTask();
                        GlobalCC.sysInformation("Current Task Complete. The Next Task " +
                                                (String)this.session.getAttribute("TaskActivityName") +
                                                " has been Successfully assigned to " +
                                                (String)this.session.getAttribute("TaskAssignee"));
                        return null;
                    }
                } else {
                    GlobalCC.sysInformation("the Task Selected Does not Correspond to the Activity being Performed. Cannot Complete");
                    return null;
                }
            } else {
                GlobalCC.RedirectPage("/gquoedt.jspx");
            }
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String ShowAddMembers() {
        try {
            LOVCC.RedirectPage = "Q";
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return null;
    }

    public void setProdCoversLOV(RichTable prodCoversLOV) {
        this.prodCoversLOV = prodCoversLOV;
    }

    public RichTable getProdCoversLOV() {
        return this.prodCoversLOV;
    }

    public String AttachProductCoverTypes() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findProductCovers1Iterator");
        RowKeySet set = this.prodCoversLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
            this.session.setAttribute("CVT_CODE", r.getAttribute("cvt_code"));
            this.prodCoverDisplay.setValue(r.getAttribute("cvt_desc"));
        }

        return null;
    }
      
    public void setProdCoverDisplay(RichInputText prodCoverDisplay) {
        this.prodCoverDisplay = prodCoverDisplay;
    }

    public RichInputText getProdCoverDisplay() {
        return this.prodCoverDisplay;
    }

    public void setCoverSADisplay(RichInputText coverSADisplay) {
        this.coverSADisplay = coverSADisplay;
    }

    public RichInputText getCoverSADisplay() {
        return this.coverSADisplay;
    }

    public void setCoverButChargePremium(RichInputText coverButChargePremium) {
        this.coverButChargePremium = coverButChargePremium;
    }

    public RichInputText getCoverButChargePremium() {
        return this.coverButChargePremium;
    }

    public void GetCoverLoadingType(ValueChangeEvent valueChangeEvent) {
        LOVCC.LoadingType = this.discLoadChoice.getValue().toString();
    }

    public void setDiscLoadRateDisplay(RichInputText discLoadRateDisplay) {
        this.discLoadRateDisplay = discLoadRateDisplay;
    }

    public RichInputText getDiscLoadRateDisplay() {
        return this.discLoadRateDisplay;
    }

    public String SaveQuotationCovers() {
        String saveQuery =
            "BEGIN LMS_WEB_PKG_GRP.populate_cover_types(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);END;";
        Connection conn = new DBConnector().getDatabaseConn();
        try {
            CallableStatement cstmt = conn.prepareCall(saveQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)this.session.getAttribute("ProductCode"));
            cstmt.setBigDecimal(2,
                                (BigDecimal)this.session.getAttribute("QuoteCode"));
            cstmt.setBigDecimal(3,
                                (BigDecimal)this.session.getAttribute("CVT_CODE"));
            if (this.discLoadChoice.getValue() == null)
                cstmt.setString(4, "N");
            else {
                cstmt.setString(4, this.discLoadChoice.getValue().toString());
            }
            if (this.discLoadRateDisplay.getValue() == null)
                cstmt.setBigDecimal(5, null);
            else {
                cstmt.setString(5,
                                this.discLoadRateDisplay.getValue().toString());
            }

            if (this.coverButChargePremium.getValue() == null)
                cstmt.setBigDecimal(6, null);
            else {
                cstmt.setString(6,
                                this.coverButChargePremium.getValue().toString());
            }

            if (this.coverSADisplay.getValue() == null)
                cstmt.setBigDecimal(7, null);
            else {
                cstmt.setString(7, this.coverSADisplay.getValue().toString());
            }

            if (this.avANB.getValue() == null)
                cstmt.setBigDecimal(8, null);
            else {
                cstmt.setString(8, this.avANB.getValue().toString());
            }

            cstmt.setBigDecimal(9,
                                (BigDecimal)this.session.getAttribute("qcvtCode"));
            cstmt.setBigDecimal(10,
                                (BigDecimal)this.session.getAttribute("dtyCode"));
            if (this.avMemberEarnings.getValue() == null)
                cstmt.setBigDecimal(11, null);
            else {
                cstmt.setString(11,
                                this.avMemberEarnings.getValue().toString());
            }

            if (this.cvrMultipleEarningsPeriod.getValue() == null)
                cstmt.setBigDecimal(12, null);
            else {
                cstmt.setString(12,
                                this.cvrMultipleEarningsPeriod.getValue().toString());
            }

            if (this.totalMem.getValue() == null){
                if(totalMember.getValue()==null){
                cstmt.setBigDecimal(13, null);
                }else{
                  cstmt.setString(13, this.totalMember.getValue().toString());
                }
            }
            else {
                cstmt.setString(13, this.totalMem.getValue().toString());
            }

            if (this.cvrCategory.getValue() == null)
                cstmt.setBigDecimal(14, null);
            else {
                cstmt.setString(14, this.cvrCategory.getValue().toString());
            }

            if (this.divFactor.getValue() == null)
                cstmt.setBigDecimal(15, null);
            else {
                cstmt.setString(15, this.divFactor.getValue().toString());
            }

            if (this.percMainCvt.getValue() == null)
                cstmt.setBigDecimal(16, null);
            else {
                cstmt.setString(16, this.percMainCvt.getValue().toString());
            }

            if (this.mainCover.getValue() == null)
                cstmt.setBigDecimal(17, null);
            else {
                cstmt.setString(17, this.mainCover.getValue().toString());
            }

            if (this.cvrLoanAmt.getValue() == null)
                cstmt.setBigDecimal(18, null);
            else {
                cstmt.setString(18, this.cvrLoanAmt.getValue().toString());
            }

            if (this.cvrLoanPrd.getValue() == null)
                cstmt.setBigDecimal(19, null);
            else {
                cstmt.setString(19, this.cvrLoanPrd.getValue().toString());
            }

            if (this.cvrLoanInt.getValue() == null)
                cstmt.setBigDecimal(20, null);
            else {
                cstmt.setString(20, this.cvrLoanInt.getValue().toString());
            }

            if (this.cvrSavingsAmt.getValue() == null)
                cstmt.setBigDecimal(21, null);
            else {
                cstmt.setString(21, this.cvrSavingsAmt.getValue().toString());
            }

            if (this.discChoice.getValue() == null)
                cstmt.setString(22, "N");
            else {
                cstmt.setString(22, this.discChoice.getValue().toString());
            }
            if (this.discRateDisplay.getValue() == null)
                cstmt.setBigDecimal(23, null);
            else {
                cstmt.setString(23,
                                this.discRateDisplay.getValue().toString());
            }
            if (this.discDivFactor.getValue() == null)
                cstmt.setBigDecimal(24, null);
            else {
                cstmt.setString(24, this.discDivFactor.getValue().toString());
            }
            if (this.rateSelection.getValue() == null)
                cstmt.setBigDecimal(25, null);
            else {
                cstmt.setString(25, this.rateSelection.getValue().toString());
            }
            cstmt.setBigDecimal(26,
                                (BigDecimal)this.session.getAttribute("coverMaskCode"));
            if (this.maskDesc.getValue() == null)
                cstmt.setBigDecimal(27, null);
            else {
                cstmt.setString(27, this.maskDesc.getValue().toString());
            }
            if (this.coverRate.getValue() == null)
                cstmt.setBigDecimal(28, null);
            else {
                cstmt.setString(28, this.coverRate.getValue().toString());
            }
            if (this.coverRateDivFactor.getValue() == null)
                cstmt.setBigDecimal(29, null);
            else {
                cstmt.setString(29,
                                this.coverRateDivFactor.getValue().toString());
            }
            if (this.totalMemEarning.getValue() == null)
                cstmt.setBigDecimal(30, null);
            else {
                cstmt.setString(30,
                                this.totalMemEarning.getValue().toString());
            }
            if (this.totLoanAmt.getValue() == null)
                cstmt.setBigDecimal(31, null);
            else {
                cstmt.setString(31, this.totLoanAmt.getValue().toString());
            }
            if (this.avCoverPerMem.getValue() == null)
                cstmt.setBigDecimal(32, null);
            else {
                cstmt.setString(32, this.avCoverPerMem.getValue().toString());
            }
            if (this.ageLoadFactor.getValue() == null) {
                cstmt.setBigDecimal(33, null);
            } else {
                cstmt.setString(33, this.ageLoadFactor.getValue().toString());
            }
            
            if (this.covLimitInput.getValue() == null) {
                cstmt.setBigDecimal(34, null);
            } else {
                cstmt.setString(34, this.covLimitInput.getValue().toString());
            }
            
            if (this.aggQuotePlan.getValue() == null) {
                cstmt.setBigDecimal(35, null);
            } else {
                cstmt.setString(35, this.aggQuotePlan.getValue().toString());
            }
            if(this.accelerator.getValue()==null){
              cstmt.setString(36, null);
            }else{
              cstmt.setString(36, this.accelerator.getValue().toString());
            }
          if(this.builtIn.getValue()==null){
            cstmt.setString(37, null);
          }else{
            cstmt.setString(37, this.builtIn.getValue().toString());
          }
            //updateRiderSA();
            cstmt.execute();
            conn.close();

            this.session.setAttribute("qcvtCode", null);
            this.session.setAttribute("dtyCode", null);

            ADFUtils.findIterator("findQuoteCoverTypesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.quotCoverTypes);

            LOVCC.CoversSaved += 1;

            this.coverButChargePremium.setValue(null);
            this.discLoadChoice.setValue(null);
            this.discLoadRateDisplay.setValue(null);
            this.divFactor.setValue(null);

            AdfFacesContext.getCurrentInstance().addPartialTarget(this.coverButChargePremium);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.discLoadChoice);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.discLoadRateDisplay);

            GlobalCC.hidePopup("lmsgroup:cvrdtl");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public void setDiscLoadChoice(RichSelectOneChoice discLoadChoice) {
        this.discLoadChoice = discLoadChoice;
    }

    public RichSelectOneChoice getDiscLoadChoice() {
        return this.discLoadChoice;
    }

    public String ShowCovers() {
        try {
            GlobalCC.RedirectPage("/quocovers.jspx");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String EditMembers() {
        return null;
    }

    public void setSearchResults(RichPanelBox searchResults) {
        this.searchResults = searchResults;
    }

    public RichPanelBox getSearchResults() {
        return this.searchResults;
    }

    public void setSearchQuote(RichPanelBox searchQuote) {
        this.searchQuote = searchQuote;
    }

    public RichPanelBox getSearchQuote() {
        return this.searchQuote;
    }

    public void setQuoteBasicDetailsTab(RichPanelBox quoteBasicDetailsTab) {
        this.quoteBasicDetailsTab = quoteBasicDetailsTab;
    }

    public RichPanelBox getQuoteBasicDetailsTab() {
        return this.quoteBasicDetailsTab;
    }

    public void setPensionsTab(RichPanelBox pensionsTab) {
        this.pensionsTab = pensionsTab;
    }

    public RichPanelBox getPensionsTab() {
        return this.pensionsTab;
    }

    public void setCoverDetailsTab(RichPanelBox coverDetailsTab) {
        this.coverDetailsTab = coverDetailsTab;
    }

    public RichPanelBox getCoverDetailsTab() {
        return this.coverDetailsTab;
    }

    public void coversListener(SelectionEvent selectionEvent) {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findProductCovers1Iterator");
        RowKeySet set = selectionEvent.getAddedSet();
        Iterator rowKeySetIter = set.iterator();

        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            this.session.setAttribute("CVT_CODE", r.getAttribute("cvt_code"));
            this.coverButChargePremium.setValue(null);
            this.discLoadChoice.setValue("N");
            this.discLoadRateDisplay.setValue(null);

            AdfFacesContext.getCurrentInstance().addPartialTarget(this.coverButChargePremium);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.discLoadChoice);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.discLoadRateDisplay);
        }
    }

    public String findTaxesSelected() {
        String Rate = null;
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("FindTaxesIterator");
            RowKeySet set = this.allTaxesLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));

                Row r = dciter.getCurrentRow();

                this.session.setAttribute("TaxesCode",
                                          r.getAttribute("TT_CODE"));
                Rate = (String)r.getAttribute("TRT_RATE");

                this.session.setAttribute("TaxRateType",
                                          r.getAttribute("TRT_RATE_TYPE"));
                this.session.setAttribute("TaxRenewalEndr",
                                          r.getAttribute("TT_RENEWAL_ENDOS"));
                this.taxRate.setValue(Rate);
                this.taxSel.setValue(r.getAttribute("TT_DESC"));

                this.session.setAttribute("TaxShtDesc",
                                          r.getAttribute("TT_SHT_DESC"));
                this.session.setAttribute("TaxTRTCode",
                                          r.getAttribute("TRT_CODE"));

                this.applLevel.setValue(null);

                this.taxAmt.setValue(null);

                AdfFacesContext.getCurrentInstance().addPartialTarget(this.applLevel);
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.taxRate);
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.taxAmt);
            }

            System.out.println("enter popup");
            ExtendedRenderKitService erkService =
                (ExtendedRenderKitService)Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                                             ExtendedRenderKitService.class);

            erkService.addScript(FacesContext.getCurrentInstance(),
                                 "var hints = {autodismissNever:false}; AdfPage.PAGE.findComponent('lmsgroup:taxes').show(hints);");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return null;
    }

    public String findCoinsurersSel() {
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("FindCoinsurersIterator");
            RowKeySet set = this.coinsurerLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                coinsurerAgent = (BigDecimal)r.getAttribute("CO_agn_code");
                coinsurerCode = null;

                this.coinsurerLabel.setValue(r.getAttribute("CO_agn_name"));
                this.coShare.setValue(null);
                this.coServFee.setValue(null);

                AdfFacesContext.getCurrentInstance().addPartialTarget(this.coinsurerLabel);
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.coShare);
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.coServFee);

                System.out.println("enter popup");
                ExtendedRenderKitService erkService =
                    (ExtendedRenderKitService)Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                                                 ExtendedRenderKitService.class);

                erkService.addScript(FacesContext.getCurrentInstance(),
                                     "var hints = {autodismissNever:false}; AdfPage.PAGE.findComponent('lmsgroup:p3').show(hints);");
            }

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return null;
    }

    public String EditCoinsurersSel() {
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findQuoteCoinsurersIterator");
            RowKeySet set = this.quoteCoinsurersLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                coinsurerCode = (BigDecimal)r.getAttribute("QCOIN_CODE");
                coinsurerAgent = (BigDecimal)r.getAttribute("QCOIN_AGN_CODE");

                this.coinsurerLabel.setValue(r.getAttribute("coinsurer_display"));
                this.coShare.setValue(r.getAttribute("QCOIN_SHARE_PCT"));
                this.coServFee.setValue(r.getAttribute("QCOIN_ADMIN_FEE"));

                AdfFacesContext.getCurrentInstance().addPartialTarget(this.coinsurerLabel);
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.coShare);
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.coServFee);

                System.out.println("enter popup");
                ExtendedRenderKitService erkService =
                    (ExtendedRenderKitService)Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                                                 ExtendedRenderKitService.class);

                erkService.addScript(FacesContext.getCurrentInstance(),
                                     "var hints = {autodismissNever:false}; AdfPage.PAGE.findComponent('lmsgroup:p3').show(hints);");
            }

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return null;
    }

    public String SaveCoinsurer() {
        if (!CoinsureShare) {
            String Message = "Save your insurer share first.";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));

            return null;
        }

        if (this.coShare.getValue() == null) {
            String Message = "Enter a Share Percentage";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));

            return null;
        }

        String computeQuery = "BEGIN LMS_WEB_PKG_GRP.updatequotecoinsurers(?,?,?,?,?,?,?);END;";
        
        Connection conn = new DBConnector().getDatabaseConn();
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall(computeQuery);
            cstmt.setBigDecimal(1, coinsurerCode);
            cstmt.setBigDecimal(2, null);
            cstmt.setBigDecimal(3,
                                (BigDecimal)this.session.getAttribute("QuoteCode"));
            cstmt.setBigDecimal(4, coinsurerAgent);
            cstmt.setString(5, this.coShare.getValue().toString());
            if (this.coServFee.getValue() == null)
                cstmt.setBigDecimal(6, null);
            else {
                cstmt.setString(6, this.coServFee.getValue().toString());
            }
            if (this.coinLeadFollowSelect.getValue() == null)
                cstmt.setBigDecimal(7, null);
            else {
                cstmt.setString(7,
                                this.coinLeadFollowSelect.getValue().toString());
            }
            cstmt.execute();
            conn.close();
            GlobalCC.INFORMATIONREPORTING("Coinsurer Saved");

            ADFUtils.findIterator("findQuoteCoinsurersIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.quoteCoinsurersLOV);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }

        return null;
    }

    public String SaveCoinsurerShare() {
        if (this.leaderShare.getValue() == null) {
            GlobalCC.INFORMATIONREPORTING("Enter a Share Percentage");
            return null;
        }

        if (this.coLeadFollow.getValue() == null) {
            GlobalCC.INFORMATIONREPORTING("Select A Leader / Follower");
            return null;
        }

        String computeQuery =
            "BEGIN LMS_WEB_PKG_GRP.update_leader_share(?,?,?,?);END;";
        Connection conn = new DBConnector().getDatabaseConn();
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall(computeQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)this.session.getAttribute("QuoteCode"));
            cstmt.setString(2, this.leaderShare.getValue().toString());
            cstmt.setString(3, this.coLeadFollow.getValue().toString());
            cstmt.setString(4,
                            (String)this.session.getAttribute("CurrentStatus"));

            cstmt.execute();
            conn.close();
            GlobalCC.INFORMATIONREPORTING("Coinsurer Share Saved");
            CoinsureShare = true;

            if (this.leaderShare.getValue().toString().equalsIgnoreCase("L")) {
                this.coinLeadFollowSelect.setRendered(false);
                this.coinLeadFollowLabel.setRendered(false);
                this.coinLeadFollowSelect.setValue("F");
            } else {
                this.coinLeadFollowSelect.setRendered(true);
                this.coinLeadFollowLabel.setRendered(true);
            }

            int i = Integer.parseInt(this.leaderShare.getValue().toString());
            Integer Test =
                (Integer)this.session.getAttribute("CoinsurerTotal");
            Test = Integer.valueOf(Test.intValue() + i);
            this.session.setAttribute("CoinsurerTotal", Test);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }

        return null;
    }

    public String DeleteCoinsurer() {
        BigDecimal CoinsurerCode = null;

        DCIteratorBinding dciter =
            ADFUtils.findIterator("findQuoteCoinsurersIterator");
        RowKeySet set = this.quoteCoinsurersLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            CoinsurerCode = (BigDecimal)r.getAttribute("QCOIN_CODE");
        }

        String deleteQuery =
            "BEGIN LMS_WEB_PKG_GRP.deletequocoinsurer(?);END;";
        Connection conn = new DBConnector().getDatabaseConn();
        try {
            CallableStatement cstmt = conn.prepareCall(deleteQuery);
            cstmt.setBigDecimal(1, CoinsurerCode);
            cstmt.execute();
            conn.close();
            ADFUtils.findIterator("findQuoteCoinsurersIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.quoteCoinsurersLOV);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }

        return null;
    }

    public String findCoversSel() {
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findProductCovers1Iterator");
            RowKeySet set = this.prodCoversLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                this.session.setAttribute("CVT_CODE",
                                          r.getAttribute("cvt_code"));
                this.cvrTypeLabel.setValue(r.getAttribute("cvt_desc"));

                this.session.setAttribute("qcvtCode", null);
                this.coverButChargePremium.setValue(null);
                this.discLoadChoice.setValue("N");
                this.discLoadRateDisplay.setValue(null);
                this.divFactor.setValue(null);
                this.avANB.setValue(null);
                this.coverSADisplay.setValue(null);
                this.avMemberEarnings.setValue(null);
                this.totalMemEarning.setValue(null);
                this.dtyDesc.setValue(null);
                this.cvrMultipleEarningsPeriod.setValue(null);
                this.totalMem.setValue(null);
                this.cvrCategory.setValue(null);
                this.discChoice.setValue("N");
                this.discRateDisplay.setValue(null);
                this.discDivFactor.setValue(null);
                String CmainCover = (String)r.getAttribute("cvt_main_cover");
                if (CmainCover == null) {
                    this.percMainCvtLabel.setRendered(false);
                    this.percMainCvt.setRendered(false);
                    this.mainCover.setRendered(false);
                    this.mainCoverLabel.setRendered(false);
                    this.percMainCvt.setValue(null);
                    this.mainCover.setValue(null);
                } else if (CmainCover.equalsIgnoreCase("M")) {
                    this.percMainCvtLabel.setRendered(false);
                    this.percMainCvt.setRendered(false);
                    this.mainCover.setRendered(false);
                    this.mainCoverLabel.setRendered(false);
                    this.percMainCvt.setValue(null);
                    this.mainCover.setValue(null);
                } else if (CmainCover.equalsIgnoreCase("M")) {
                    this.percMainCvtLabel.setRendered(false);
                    this.percMainCvt.setRendered(false);
                    this.mainCover.setRendered(false);
                    this.mainCoverLabel.setRendered(false);
                    this.percMainCvt.setValue(null);
                    this.mainCover.setValue(r.getAttribute("cvt_main_cover"));
                } else {
                    this.percMainCvtLabel.setRendered(true);
                    this.percMainCvt.setRendered(true);
                    this.mainCover.setRendered(true);
                    this.mainCoverLabel.setRendered(true);
                    this.percMainCvt.setValue(r.getAttribute("pct_main_sa_perc"));
                    this.mainCover.setValue(r.getAttribute("cvt_main_cover"));
                }

                AdfFacesContext.getCurrentInstance().addPartialTarget(this.coverButChargePremium);
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.discLoadChoice);
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.discLoadRateDisplay);

                System.out.println("enter popup");
                ExtendedRenderKitService erkService =
                    (ExtendedRenderKitService)Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                                                 ExtendedRenderKitService.class);

                erkService.addScript(FacesContext.getCurrentInstance(),
                                     "var hints = {autodismissNever:false}; AdfPage.PAGE.findComponent('lmsgroup:cvrdtl').show(hints);");
            }

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return null;
    }

    public String AddProductCoverType() {
        Rendering render = new Rendering();
        
        //cover types render
        this.totalMemEarning.setDisabled(false);
        this.cvrMultipleEarningsPeriod.setDisabled(false);
        this.avMemberEarnings.setDisabled(false);
        
        //this.totLoanAmtLabel.setValue("");
        this.totLoanAmt.setDisabled(false);
        //this.loanRepyLabel.setValue("");
        this.cvrLoanPrd.setDisabled(false);
        
        //end of covers render
        
        this.productCoverDropBox.setDisabled(false);
        this.productCoverDropBox.setValue(null);
        this.session.setAttribute("PCT_CODE", null);
        this.session.setAttribute("CVT_CODE", null);
        this.session.setAttribute("qcvtCode", null);
        this.cvrLoanAmt.setValue(null);
        this.cvrLoanPrd.setValue(null);
        this.cvrLoanInt.setValue(null);
        this.cvrSavingsAmt.setValue(null);
        this.discChoice.setValue("N");
        this.discRateDisplay.setValue(null);
        this.discDivFactor.setValue(null);
        this.discLoadChoice.setValue("N");
        this.discLoadRateDisplay.setValue(null);
        this.divFactor.setValue(null);
        if (!render.isExpressVisible()) {
            this.totalMemEarning.setValue(null);
            this.avMemberEarnings.setValue(null);
            this.totalMem.setValue(null);
            this.cvrCategory.setValue(null);
            this.cvrMultipleEarningsPeriod.setValue(null);
            this.avANB.setValue(null);
            this.coverSADisplay.setValue(null);
        }
        this.totLoanAmt.setValue(null);
        this.avCoverPerMem.setValue(null);
        this.aggQuotePlan.setValue((String)session.getAttribute("DefaultAggrPlan"));
        this.session.setAttribute("dtyCode", null);
        this.dtyDesc.setValue(null);

        this.session.setAttribute("coverMaskCode",
                                  this.session.getAttribute("pmasCode"));

        this.rateSelection.setValue("M");

        this.maskDesc.setValue(this.session.getAttribute("pmasShtDesc"));

        this.maskButton.setDisabled(true);
        this.coverRate.setDisabled(true);
        this.coverRate.setValue(null);
        this.coverRateDivFactor.setDisabled(true);
        this.coverRateDivFactor.setValue(null);

        GlobalCC.showPopup("lmsgroup:cvrdtl");
        return null;
    }

    public void ProductCoverTypeListener(ValueChangeEvent valueChangeEvent) {
        if (valueChangeEvent.getNewValue() != null) {
            if ((valueChangeEvent.getOldValue() !=
                 valueChangeEvent.getNewValue()) &&
                (this.productCoverDropBox.getValue() != null)) {
                DCIteratorBinding dciter =
                    ADFUtils.findIterator("findProductCovers1Iterator");

                Row r =
                    dciter.getRowAtRangeIndex(((Integer)valueChangeEvent.getNewValue()).intValue());

                this.session.setAttribute("CVT_CODE",
                                          r.getAttribute("cvt_code"));
                this.session.setAttribute("PCT_CODE",
                                          r.getAttribute("pct_code"));

                this.coverButChargePremium.setValue(null);
                this.discLoadChoice.setValue("N");
                this.discLoadRateDisplay.setValue(null);
                this.divFactor.setValue(null);
                this.avANB.setValue(null);
                this.coverSADisplay.setValue(null);
                this.avMemberEarnings.setValue(null);
                this.totalMemEarning.setValue(null);
                this.dtyDesc.setValue(null);
                this.cvrMultipleEarningsPeriod.setValue(null);
                this.totalMem.setValue(null);
                this.cvrCategory.setValue(null);
                String CmainCover = (String)r.getAttribute("cvt_main_cover");
				
				this.session.setAttribute("covType",r.getAttribute("cvt_main_cover"));
				this.session.setAttribute("riderCovType",r.getAttribute("cvt_sht_desc"));
       
        Rendering render = new Rendering();
        
        if(render.isMickVisible()){
            
            this.totalMemEarning.setDisabled(false);
            this.cvrMultipleEarningsPeriod.setDisabled(false);
            this.avMemberEarnings.setDisabled(false);
            
            this.cvrMultipleEarningsPeriod.setDisabled(false);
            this.avMemEarnlabel.setValue("Av. Earnings Per Member");
            this.totalMemEarninglbl.setValue("Total Member Earnings");
            this.multiEarnsPeriodlbl.setValue("Multiple Earnings Period");
            String Value = Validate_Quote_Product();
            if ((Value == null)){
              this.prdTypeLabel2.setValue("[Months]");
            }else if(Value.equalsIgnoreCase("F")){
              this.prdTypeLabel2.setValue("[Months]");
            }else {
              this.prdTypeLabel2.setValue(Value);
            }
                          
            this.totLoanAmtLabel.setValue("Total Original Loan Amount");
            this.totLoanAmt.setDisabled(false);
            this.loanAmtLabel.setValue("Original Loan Amount Per Member");
            this.loanRepyLabel.setValue("Loan Repayment Period(Months)");
            this.cvrLoanPrd.setDisabled(false);
            this.loanIntLabel.setValue("Loan Interest");
            this.cvrLoanInt.setDisabled(false);
          
            
            this.covLimitInput.setValue(getMaxSa());
            
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.coversPanel);
        }
        
                if (CmainCover == null) {
                    this.percMainCvtLabel.setRendered(false);
                    this.percMainCvt.setRendered(false);
                    this.mainCover.setRendered(false);
                    this.mainCoverLabel.setRendered(false);
                    this.percMainCvt.setValue(null);
                    this.mainCover.setValue(null);
                } else if (CmainCover.equalsIgnoreCase("M")) {
                    this.percMainCvtLabel.setRendered(false);
                    this.percMainCvt.setRendered(false);
                    this.mainCover.setRendered(false);
                    this.mainCoverLabel.setRendered(false);
                    this.percMainCvt.setValue(null);
                    this.mainCover.setValue(r.getAttribute("cvt_main_cover"));
                } else {
                    if (CmainCover.equalsIgnoreCase("RL"))
                        this.percMainCvtLabel.setValue("Multiple of Loan Repayment");
                    else {
                        this.percMainCvtLabel.setValue("% of  Main/Yr Earn");
                    }
                    this.percMainCvtLabel.setRendered(true);
                    this.percMainCvt.setRendered(true);
                    this.mainCover.setRendered(true);
                    this.mainCoverLabel.setRendered(true);
                    this.percMainCvt.setValue(r.getAttribute("pct_main_sa_perc"));
                    this.mainCover.setValue(r.getAttribute("cvt_main_cover"));
                }
                
             
              //added method to render controls for Riders
              if(render.isMickVisible()){
                  renderCovers(CmainCover);
              }
                builtIn.setValue(r.getAttribute("pctInbuilt"));
                accelerator.setValue(r.getAttribute("pctAccelerator"));
				        populateDependentTypes((BigDecimal)r.getAttribute("pct_code"),
                                       (BigDecimal)r.getAttribute("cvt_code"));

                populatePremMasks((BigDecimal)r.getAttribute("pct_code"),
                                  (BigDecimal)r.getAttribute("cvt_code"));
                
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.coverButChargePremium);
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.discLoadChoice);
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.discLoadRateDisplay);
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.mainCover);
              AdfFacesContext.getCurrentInstance().addPartialTarget(this.builtIn);
              AdfFacesContext.getCurrentInstance().addPartialTarget(this.accelerator);
            }
        }
    }
	
    public BigDecimal getMaxSa(){
        String maxsastr = "begin ? := LMS_WEB_CURSOR_GRP.getMaxSa(?); end;";
        BigDecimal pctcode;
        pctcode = (BigDecimal)this.session.getAttribute("PCT_CODE");
        BigDecimal maxSa;
        maxSa = new BigDecimal(0);
            
            try {  
                  DBConnector myConn = new DBConnector();
                  Connection conn = myConn.getDatabaseConn();
                  CallableStatement cstmt = null;
                  cstmt = conn.prepareCall(maxsastr);
                  cstmt.registerOutParameter(1, OracleTypes.NUMBER);
                  cstmt.setBigDecimal(2,pctcode);
                  cstmt.execute();
                  maxSa = cstmt.getBigDecimal(1);
                  conn.close();
            } catch(Exception e){
                e.printStackTrace();
            }
            
        
        return maxSa;
    }
    
    public String updateRiderSA(){
      String computeQuery =
          "BEGIN LMS_WEB_PKG_GRP.UpdateRiderMaxSa(?,?);END;";
      Connection conn = new DBConnector().getDatabaseConn();
      CallableStatement cstmt = null;
      
      try {
          cstmt = conn.prepareCall(computeQuery);
          
          cstmt.setBigDecimal(1,
                              (BigDecimal)this.session.getAttribute("PCT_CODE"));
          if(this.covLimitInput.getValue() == null){
            cstmt.setBigDecimal(2, null);
          }else{
            cstmt.setString(2, String.valueOf(this.covLimitInput.getValue()));
          }
          
          cstmt.execute();
          conn.close();
         
          } catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null, e);
            return null;
          }
          return null;
    }
  
    public void resetControls(){
        this.totalMemEarning.setDisabled(false);
        this.cvrMultipleEarningsPeriod.setDisabled(false);
        this.avMemberEarnings.setDisabled(false);
        String Value = Validate_Quote_Product();
        if ((Value == null)){
          this.prdTypeLabel2.setValue("[Months]");
        }else if(Value.equalsIgnoreCase("F")){
          this.prdTypeLabel2.setValue("[Months]");
        }else {
          this.prdTypeLabel2.setValue(Value);
        }
        
        this.totLoanAmtLabel.setValue("");
        this.totLoanAmt.setDisabled(false);
        this.loanRepyLabel.setValue("");
        this.cvrLoanPrd.setDisabled(false);   
    }
	
    public boolean isShowRequired(){
      String CalcType = (String)this.session.getAttribute("calcType");
      String covType = (String)session.getAttribute("covType");
      
      if(CalcType.equalsIgnoreCase("A")){
          if(covType!=null){
            if (covType.equalsIgnoreCase("R")){
                  return false;
            } else  {
                  return true;
            } 
          }else{
            return true;
          }
          
      } else {
          return true;
      }    
    }
  
	public void renderCovers(String coverDesc){
            String CalcType = (String)this.session.getAttribute("calcType");
            String ridercovType = (String)session.getAttribute("riderCovType");
            
            if(CalcType.equalsIgnoreCase("A") && (ridercovType.equalsIgnoreCase("FCG") ||  coverDesc.equalsIgnoreCase("R"))){
        
                if(session.getAttribute("productType").toString().equalsIgnoreCase("EARN")) {
                      if (coverDesc.equalsIgnoreCase("R") || coverDesc.equalsIgnoreCase("O")){
                          this.isShowRequired();
                          this.totalMemEarning.setDisabled(true);
                          this.cvrMultipleEarningsPeriod.setDisabled(true);
                          this.avMemEarnlabel.setValue("Av. Cover Per Member");
                          this.totalMemEarninglbl.setValue("");
                          this.multiEarnsPeriodlbl.setValue("");
                          this.prdTypeLabel2.setValue("");
                          this.cvrMultipleEarningsPeriod.setValue("1");
                      }  
          
              }else if (session.getAttribute("productType").toString().equalsIgnoreCase("LOAN")) {
                      if (coverDesc.equalsIgnoreCase("R") || coverDesc.equalsIgnoreCase("O")){
                        this.totLoanAmtLabel.setValue("");
                        this.totLoanAmt.setDisabled(true);
                        this.loanRepyLabel.setValue("");
                        this.cvrLoanPrd.setDisabled(true);
                        this.loanAmtLabel.setValue("Av. Cover Per Member");
                        this.loanIntLabel.setValue("");
                        this.cvrLoanInt.setDisabled(true);
                        this.cvrLoanInt.setValue("1");
                      }
          
              } else {
                  this.totalMemEarning.setDisabled(false);
                  this.cvrMultipleEarningsPeriod.setDisabled(false);
                  this.avMemberEarnings.setDisabled(false);   
                  String Value = Validate_Quote_Product();
                  if ((Value == null)){
                    this.prdTypeLabel2.setValue("[Months]");
                  }else if(Value.equalsIgnoreCase("F")){
                    this.prdTypeLabel2.setValue("[Months]");
                  }else {
                    this.prdTypeLabel2.setValue(Value);
                  }
              }
                
            }
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.coversPanel);
	
	}
	
    public String findCoverProvSel() {
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findQuoteCoverTypesIterator");
            RowKeySet set = this.covProvLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                this.session.setAttribute("qcvtCode",
                                          r.getAttribute("QCVT_CODE"));
                this.session.setAttribute("qcvtcvtCode",
                                          r.getAttribute("QCVT_CVT_CODE"));

                ADFUtils.findIterator("findProdDependentsIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.dependentTypesLOV);

                ADFUtils.findIterator("findProductProvisionsIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.productProvisionsLOV);
            }

            ExtendedRenderKitService erkService =
                (ExtendedRenderKitService)Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                                             ExtendedRenderKitService.class);

            erkService.addScript(FacesContext.getCurrentInstance(),
                                 "var hints = {autodismissNever:false}; AdfPage.PAGE.findComponent('lmsgroup:provpop').show(hints);");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return null;
    }

    public String findCategorysel() {
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findQuoteCoverTypesIterator");
            RowKeySet set = this.dependentCoverTypes.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                this.session.setAttribute("qcvtCode",
                                          r.getAttribute("QCVT_CODE"));
                this.session.setAttribute("qcvtcvtCode",
                                          r.getAttribute("QCVT_CVT_CODE"));
                this.cvrDisp2.setValue(r.getAttribute("cover_display"));

                ADFUtils.findIterator("findProdDependentsIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.dependentTypesLOV);

                ExtendedRenderKitService erkService =
                    (ExtendedRenderKitService)Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                                                 ExtendedRenderKitService.class);

                erkService.addScript(FacesContext.getCurrentInstance(),
                                     "var hints = {autodismissNever:false}; AdfPage.PAGE.findComponent('lmsgroup:AddDependent').show(hints);");
            }

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return null;
    }

    public String FindDepsSel() {
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findProdDependentsIterator");
            RowKeySet set = this.dependentTypesLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                this.session.setAttribute("dtyCode",
                                          r.getAttribute("DTY_CODE"));
                this.dependentType.setValue(r.getAttribute("DTY_DESCRIPTION"));
                this.session.setAttribute("maxTypeNo",
                                          r.getAttribute("max_allowed"));
                this.dpdLimitAmount.setValue(null);
                this.maxType.setValue(r.getAttribute("max_allowed"));
                this.session.setAttribute("qdlCode", null);
                this.session.setAttribute("qcvtcvtCode",
                                          r.getAttribute("QCVT_CVT_CODE"));
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.dpdLimitAmount);
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.maxType);

                ExtendedRenderKitService erkService =
                    (ExtendedRenderKitService)Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                                                 ExtendedRenderKitService.class);

                erkService.addScript(FacesContext.getCurrentInstance(),
                                     "var hints = {autodismissNever:false}; AdfPage.PAGE.findComponent('lmsgroup:depend2').show(hints);");
            }

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return null;
    }

    public void setTaxesTab(RichPanelBox taxesTab) {
        this.taxesTab = taxesTab;
    }

    public RichPanelBox getTaxesTab() {
        return this.taxesTab;
    }

    public void setCategoryDetailsTab(RichPanelBox categoryDetailsTab) {
        this.categoryDetailsTab = categoryDetailsTab;
    }

    public RichPanelBox getCategoryDetailsTab() {
        return this.categoryDetailsTab;
    }

    public void categoryListener(SelectionEvent selectionEvent) {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findQuoteCoverTypesIterator");
        RowKeySet set = selectionEvent.getAddedSet();
        Iterator rowKeySetIter = set.iterator();

        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            this.session.setAttribute("qcvtCode", r.getAttribute("QCVT_CODE"));
            this.session.setAttribute("qcvtcvtCode",
                                      r.getAttribute("QCVT_CVT_CODE"));

            ADFUtils.findIterator("findProdDependentsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.dependentTypesLOV);
        }
    }

    public void dependantsListener(SelectionEvent selectionEvent) {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findProdDependentsIterator");
        RowKeySet set = selectionEvent.getAddedSet();
        Iterator rowKeySetIter = set.iterator();

        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            this.session.setAttribute("dtyCode", r.getAttribute("DTY_CODE"));
            this.dependentType.setValue(r.getAttribute("DTY_DESCRIPTION"));
            this.session.setAttribute("maxTypeNo",
                                      r.getAttribute("max_allowed"));
            this.dpdLimitAmount.setValue(null);
            this.maxType.setValue(r.getAttribute("max_allowed"));

            AdfFacesContext.getCurrentInstance().addPartialTarget(this.dpdLimitAmount);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.maxType);
        }
    }

    public void setQuoteMembersTab(RichPanelBox quoteMembersTab) {
        this.quoteMembersTab = quoteMembersTab;
    }

    public RichPanelBox getQuoteMembersTab() {
        return this.quoteMembersTab;
    }

    public void setProvisionsTab(RichPanelBox provisionsTab) {
        this.provisionsTab = provisionsTab;
    }

    public RichPanelBox getProvisionsTab() {
        return this.provisionsTab;
    }

    public void provisionsListener(SelectionEvent selectionEvent) {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findProductProvisionsIterator");
        RowKeySet set = selectionEvent.getAddedSet();
        Iterator rowKeySetIter = set.iterator();

        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            this.session.setAttribute("pprov_Code",
                                      r.getAttribute("PPROV_CODE"));
            this.provID.setValue(r.getAttribute("PROV_SHT_DESC"));
            this.provisions.setValue(r.getAttribute("PROV_DESC"));
        }
    }

    public String SaveQuoteTaxes() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        try {
            String AddTax =
                "begin LMS_WEB_PKG_GRP.save_quotation_taxes(?,?,?,?,?,?,?,?,?,?,?,?,?,?);end;";
            CallableStatement cst = conn.prepareCall(AddTax);

            cst.setBigDecimal(1, null);
            if (this.taxRate.getValue() == null)
                cst.setBigDecimal(2, null);
            else {
                cst.setString(2, this.taxRate.getValue().toString());
            }
            if (this.taxAmt.getValue() == null)
                cst.setBigDecimal(3, null);
            else {
                cst.setString(3, this.taxAmt.getValue().toString());
            }
            cst.setString(4, (String)this.session.getAttribute("TaxRateType"));
            if (this.taxSel.getValue() == null)
                cst.setString(5, null);
            else {
                cst.setString(5, this.taxSel.getValue().toString());
            }
            cst.setString(6, (String)this.session.getAttribute("QuotationNo"));
            cst.setString(7,
                          (String)this.session.getAttribute("TaxRenewalEndr"));
            cst.setBigDecimal(8,
                              (BigDecimal)this.session.getAttribute("TaxesCode"));
            cst.setString(9, (String)this.session.getAttribute("TaxShtDesc"));
            cst.setBigDecimal(10,
                              (BigDecimal)this.session.getAttribute("QuoteCode"));
            cst.setBigDecimal(11,
                              (BigDecimal)this.session.getAttribute("TaxTRTCode"));
            cst.setString(12, "Q");
            cst.setBigDecimal(13, null);
            cst.setBigDecimal(14,
                              (BigDecimal)this.session.getAttribute("taxCode"));

            cst.execute();
            conn.close();

            this.session.setAttribute("taxCode", null);

            ADFUtils.findIterator("findQuotationTaxes1Iterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.quotationTaxes);
        } catch (Exception e) {
            this.session.setAttribute("taxCode", null);
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return null;
    }

    public void taxesListener(SelectionEvent selectionEvent) {
        String Rate = null;
        DCIteratorBinding dciter = ADFUtils.findIterator("FindTaxesIterator");
        RowKeySet set = selectionEvent.getAddedSet();
        Iterator rowKeySetIter = set.iterator();

        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));

            Row r = dciter.getCurrentRow();

            this.session.setAttribute("TaxesCode", r.getAttribute("TT_CODE"));
            Rate = (String)r.getAttribute("TRT_RATE");

            this.session.setAttribute("TaxRateType",
                                      r.getAttribute("TRT_RATE_TYPE"));
            this.session.setAttribute("TaxRenewalEndr",
                                      r.getAttribute("TT_RENEWAL_ENDOS"));
            this.taxRate.setValue(Rate);
            this.taxSel.setValue(r.getAttribute("TT_DESC"));

            this.session.setAttribute("TaxShtDesc",
                                      r.getAttribute("TT_SHT_DESC"));
            this.session.setAttribute("TaxTRTCode",
                                      r.getAttribute("TRT_CODE"));

            this.applLevel.setValue(null);
            this.taxRate.setValue(null);
            this.taxAmt.setValue(null);

            AdfFacesContext.getCurrentInstance().addPartialTarget(this.applLevel);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.taxRate);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.taxAmt);
        }
    }

    public void setMembersUpload(CorePanelPage membersUpload) {
        this.membersUpload = membersUpload;
    }

    public CorePanelPage getMembersUpload() {
        return this.membersUpload;
    }

    public void setMemCovers(RichPanelBox memCovers) {
        this.memCovers = memCovers;
    }

    public RichPanelBox getMemCovers() {
        return this.memCovers;
    }

    public void setFinishButton(RichCommandButton finishButton) {
        this.finishButton = finishButton;
    }

    public RichCommandButton getFinishButton() {
        return this.finishButton;
    }

    public void setComputePremiumButton(RichCommandButton computePremiumButton) {
        this.computePremiumButton = computePremiumButton;
    }

    public RichCommandButton getComputePremiumButton() {
        return this.computePremiumButton;
    }

    public void setNextButton(RichCommandButton nextButton) {
        this.nextButton = nextButton;
    }

    public RichCommandButton getNextButton() {
        return this.nextButton;
    }

    public void setPrevButton(RichCommandButton prevButton) {
        this.prevButton = prevButton;
    }

    public RichCommandButton getPrevButton() {
        return this.prevButton;
    }

    public void setmemberUpload2(RichPanelBox memberUpload2) {
        this.memberUpload2 = memberUpload2;
    }

    public RichPanelBox getmemberUpload2() {
        return this.memberUpload2;
    }

    public void setMembersImport(RichPanelGroupLayout membersImport) {
        this.membersImport = membersImport;
    }

    public RichPanelGroupLayout getMembersImport() {
        return this.membersImport;
    }

    public String doNext() {
        this.membersImport.setRendered(true);
        return null;
    }

    public void setSingleMember(RichPanelBox singleMember) {
        this.singleMember = singleMember;
    }

    public RichPanelBox getSingleMember() {
        return this.singleMember;
    }

    public void setAllMembers(RichTable allMembers) {
        this.allMembers = allMembers;
    }

    public RichTable getAllMembers() {
        return this.allMembers;
    }

    public void setCatLimitTabs(RichPanelBox catLimitTabs) {
        this.catLimitTabs = catLimitTabs;
    }

    public RichPanelBox getCatLimitTabs() {
        return this.catLimitTabs;
    }

    public void setAllTaxesLOV(RichTable allTaxesLOV) {
        this.allTaxesLOV = allTaxesLOV;
    }

    public RichTable getAllTaxesLOV() {
        return this.allTaxesLOV;
    }

    public void setTaxSel(RichOutputText taxSel) {
        this.taxSel = taxSel;
    }

    public RichOutputText getTaxSel() {
        return this.taxSel;
    }

    public void setTaxRate(RichInputText taxRate) {
        this.taxRate = taxRate;
    }

    public RichInputText getTaxRate() {
        return this.taxRate;
    }

    public void setApplLevel(RichSelectOneChoice applLevel) {
        this.applLevel = applLevel;
    }

    public RichSelectOneChoice getApplLevel() {
        return this.applLevel;
    }

    public void setTaxAmt(RichInputText taxAmt) {
        this.taxAmt = taxAmt;
    }

    public RichInputText getTaxAmt() {
        return this.taxAmt;
    }

    public void setMaxType(RichInputText maxType) {
        this.maxType = maxType;
    }

    public RichInputText getMaxType() {
        return this.maxType;
    }

    public void setProvisionsCbox(RichSelectBooleanCheckbox provisionsCbox) {
        this.provisionsCbox = provisionsCbox;
    }

    public RichSelectBooleanCheckbox getProvisionsCbox() {
        return this.provisionsCbox;
    }
    
    public String SearchMembers(){
        try{
            if(srchMemName.getValue()==null){
                session.setAttribute("srchMemName", null);
            }else{
                session.setAttribute("srchMemName", srchMemName.getValue().toString());
            }
            
            if(srchMemNo.getValue()==null){
                session.setAttribute("srchMemNo", null);
            }else{
                session.setAttribute("srchMemNo", srchMemNo.getValue().toString());
            }
            ADFUtils.findIterator("findQuoteMembersIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.allMembers);
            
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        
        return null;
    }
    
    public String ClearSearchMembers(){
        try{
            session.setAttribute("srchMemName", null);
            session.setAttribute("srchMemNo", null);
            srchMemNo.setValue(null);
            srchMemName.setValue(null);
            
            ADFUtils.findIterator("findQuoteMembersIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.allMembers);
            
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        
        return null;
    }
    
    public String SearchMembersII(){
        try{
            if(srchMemName.getValue()==null){
                session.setAttribute("srchMemName", null);
            }else{
                session.setAttribute("srchMemName", srchMemName.getValue().toString());
            }
            
            if(srchMemNo.getValue()==null){
                session.setAttribute("srchMemNo", null);
            }else{
                session.setAttribute("srchMemNo", srchMemNo.getValue().toString());
            }
            ADFUtils.findIterator("findQuoteMembersIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.memberCoversLOV);
            
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        
        return null;
    }
    
    public String ClearSearchMembersII(){
        try{
            session.setAttribute("srchMemName", null);
            session.setAttribute("srchMemNo", null);
            srchMemNo.setValue(null);
            srchMemName.setValue(null);
            
            ADFUtils.findIterator("findQuoteMembersIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.memberCoversLOV);
            
        }catch(Exception e){
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        
        return null;
    }

    public String SaveSelectedProvision() {
        String ProvCode = null;
        String ProvDesc = null;
        String Editable = null;
        Connection conn = null;
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findProductProvisionsIterator");
            RowKeySet set = this.productProvisionsLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                this.session.setAttribute("pprov_Code",
                                          r.getAttribute("PPROV_CODE"));

                ProvCode = (String)r.getAttribute("PROV_SHT_DESC");
                ProvDesc = (String)r.getAttribute("PROV_DESC");
                Editable = (String)r.getAttribute("PPROV_EDITABLE");
            }

            String SaveQuery =
                "BEGIN LMS_WEB_PKG_GRP.updateProvisions(?,?,?,?,?,?,?);END;";
            conn = new DBConnector().getDatabaseConn();

            CallableStatement cstmt = conn.prepareCall(SaveQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)this.session.getAttribute("QuoteCode"));
            cstmt.setBigDecimal(2,
                                (BigDecimal)this.session.getAttribute("pprov_Code"));
            cstmt.setBigDecimal(3,
                                (BigDecimal)this.session.getAttribute("qcvtCode"));
            cstmt.setString(7, ProvCode);
            cstmt.setString(4, ProvDesc);
            cstmt.setString(5, Editable);
            if (this.saveEdit.equalsIgnoreCase("Y")) {
                cstmt.setBigDecimal(6, null);
            }
            cstmt.execute();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }

        return null;
    }

    public String CloseProvisions() {
        ADFUtils.findIterator("findQuoteProvisionsIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.coverTypeProvisions);

        return null;
    }

    public String DeletedSelectedProvision() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findProductProvisionsIterator");
        RowKeySet set = this.productProvisionsLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            this.session.setAttribute("qcprCode", r.getAttribute("qpprCode"));
        }

        String deleteQuery =
            "BEGIN LMS_WEB_PKG_GRP.deleteCoverProvision(?,?);END;";
        Connection conn = new DBConnector().getDatabaseConn();
        try {
            CallableStatement cstmt = conn.prepareCall(deleteQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)this.session.getAttribute("qcprCode"));
            cstmt.setString(2, "Q");
            cstmt.execute();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }

        return null;
    }

    public void ProvisionsListener(ValueChangeEvent valueChangeEvent) {
        if (this.provisionsCbox.isSelected())
            SaveSelectedProvision();
    }

    public void dobListener(ValueChangeEvent valueChangeEvent) {
        Connection conn = new DBConnector().getDatabaseConn();
        String DateString = null;
        String ANBString = null;
        SimpleDateFormat sdf1 =
            new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");

        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MMM/yyyy");
        try {
            Date DOB = new Date();
            RichInputText ANB = new RichInputText();

            if (this.memdob.getValue() != null) {
                DOB = sdf1.parse(this.memdob.getValue().toString());

                DateString = sdf2.format(DOB);

                System.out.println("To Date" + DateString);
                String dobQuery =
                    "begin ? := LMS_WEB_PKG_GRP_UW.get_dflt_quot_anb(?,?,?); end;";
                CallableStatement stmt = null;
                stmt = conn.prepareCall(dobQuery);
                stmt.registerOutParameter(1, 12);
                stmt.setBigDecimal(2,
                                   (BigDecimal)this.session.getAttribute("QuoteCode"));
                stmt.setString(3, DateString);
                stmt.registerOutParameter(4, 12);
                stmt.executeQuery();
                this.quotememANB.setValue(stmt.getString(1));
                ANBMem = stmt.getString(1);
                this.yeat.setValue(stmt.getString(4));

                AdfFacesContext.getCurrentInstance().addPartialTarget(this.quotememANB);
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.yeat);
            }
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
    }
    
    public void ANBDateListener(ValueChangeEvent valueChangeEvent) {
        if (valueChangeEvent.getOldValue() != valueChangeEvent.getNewValue()) {
            String ANB = null;
            Integer Value = Integer.valueOf(0);

            if (this.quotememANB.getValue() != null) {
                Connection conn = new DBConnector().getDatabaseConn();
                try {
                    ANB = this.quotememANB.getValue().toString();
                    Value = Integer.valueOf(Integer.parseInt(ANB));
                    String dobQuery =
                        "begin ? := LMS_WEB_PKG_GRP_UW.get_dflt_dob(?,?,?,?); end;";
                    CallableStatement stmt = null;
                    stmt = conn.prepareCall(dobQuery);
                    stmt.registerOutParameter(1, 91);
                    stmt.setInt(2, Value.intValue());
                    stmt.setBigDecimal(3,
                                       (BigDecimal)this.session.getAttribute("QuoteCode"));
                    stmt.setString(4, "Q");
                    stmt.registerOutParameter(5, 12);
                    stmt.execute();
                    this.memdob.setValue(stmt.getDate(1));
                    this.yeat.setValue(stmt.getString(5));
                } catch (SQLException e) {
                    GlobalCC.EXCEPTIONREPORTING(conn, e);
                }
            }
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.memdob);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.yeat);
        }
    }

    public void YearChangeListener(ValueChangeEvent valueChangeEvent) {
        if (valueChangeEvent.getOldValue() != valueChangeEvent.getNewValue()) {
            String Year = null;
            Integer Value = Integer.valueOf(0);

            if (this.yeat.getValue() != null) {
                Connection conn = new DBConnector().getDatabaseConn();
                try {
                    Year = this.yeat.getValue().toString();
                    Value = Integer.valueOf(Integer.parseInt(Year));
                    String dobQuery =
                        "begin ? := LMS_WEB_PKG_GRP_UW.get_dflt_dob_and_anb(?,?,?,?); end;";
                    CallableStatement stmt = null;
                    stmt = conn.prepareCall(dobQuery);
                    stmt.registerOutParameter(1, 91);
                    stmt.setInt(2, Value.intValue());
                    stmt.setBigDecimal(3,
                                       (BigDecimal)this.session.getAttribute("QuoteCode"));
                    stmt.setString(4, "Q");
                    stmt.registerOutParameter(5, 12);
                    stmt.execute();
                    this.memdob.setValue(stmt.getDate(1));
                    this.quotememANB.setValue(stmt.getString(5));
                } catch (SQLException e) {
                    GlobalCC.EXCEPTIONREPORTING(conn, e);
                }
            }
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.memdob);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.quotememANB);
        }
    }

    public String NewMember() {
        this.memdob.setValue(null);
        this.quotememANB.setValue(null);

        this.session.setAttribute("MemberNumber", null);
        this.monthlyEarnings.setValue(null);
        this.annualEarnings.setValue(null);

        AdfFacesContext.getCurrentInstance().addPartialTarget(this.memdob);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.quotememANB);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.monthlyEarnings);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.annualEarnings);

        return null;
    }

    public void setMemdob(RichInputDate memdob) {
        this.memdob = memdob;
    }

    public RichInputDate getMemdob() {
        return this.memdob;
    }

    public void setQuotememANB(RichInputText quotememANB) {
        this.quotememANB = quotememANB;
    }

    public RichInputText getQuotememANB() {
        return this.quotememANB;
    }

    public void setAnotherMem2(RichCommandButton anotherMem2) {
        this.anotherMem2 = anotherMem2;
    }

    public RichCommandButton getAnotherMem2() {
        return this.anotherMem2;
    }

    public void membersListener(SelectionEvent selectionEvent) {
        String prodType = (String)this.session.getAttribute("productType");

        DCIteratorBinding dciter =
            ADFUtils.findIterator("findQuoteMembersIterator");
        RowKeySet set = selectionEvent.getAddedSet();
        Iterator rowKeySetIter = set.iterator();

        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));

            Row r = dciter.getCurrentRow();

            this.session.setAttribute("MemberNumber",
                                      r.getAttribute("QMEM_CODE"));
            this.session.setAttribute("quoteMemMemCode",
                                      r.getAttribute("QMEM_MEM_CODE"));
            //session.setAttribute("jointMem", r.getAttribute("QuoJointMem"));

            ADFUtils.findIterator("FindQuoteMemberCoversIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.memLimits);

            ADFUtils.findIterator("findMemberDependentsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.anndependentsLOV);

            ADFUtils.findIterator("FindQuoteJointMembersIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.jointMemLOV);

            ADFUtils.findIterator("FindQuoteMembersExceptionsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.quoMemberExceptions);

            ADFUtils.findIterator("findQuoteMemberSubdivisionsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.memberSDivTable);

            if (prodType.equalsIgnoreCase("EDUC")) {
                ADFUtils.findIterator("findMemberBeneficiariesIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.memberBeneficiariesLOV);
            }
            if (prodType.equalsIgnoreCase("PENS")) {
                ADFUtils.findIterator("findMemberPensionDtlsIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.pensWEF);
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.pensEarnings);
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.pensTotalContri);
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.pensEmprContr);
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.pensAnnFund);
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.pensAdminFee);
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.pensEmpeContri);
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.pensIntRate);
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.pensAnnFac);
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.empeVolContr);
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.pensAnnum);
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.pensEMV);
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.pensEmprEMV);
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.pensEmpeEMV);
            }
            if (prodType.equalsIgnoreCase("GRAT")) {
                ADFUtils.findIterator("findMemberPensionDtlsIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.pastLiability);
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.totalLiability);
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.futureLiability);
            }
            if (prodType.equalsIgnoreCase("ANN")) {
                ADFUtils.findIterator("findMemberPensionDtlsIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.annuityAmount);
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.pensWEF);
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.pensWET);
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.pensAdminFee);
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.pensIntRate);
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.pensAnnFac);

                ADFUtils.findIterator("findMemberDependentsIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.anndependentsLOV);
            }
        }
    }

    public void setMemLimits(RichTable memLimits) {
        this.memLimits = memLimits;
    }

    public RichTable getMemLimits() {
        return this.memLimits;
    }

    public void setAnnualEarnings(RichInputNumberSpinbox annualEarnings) {
        this.annualEarnings = annualEarnings;
    }

    public RichInputNumberSpinbox getAnnualEarnings() {
        return this.annualEarnings;
    }

    public void setMonthlyEarnings(RichInputNumberSpinbox monthlyEarnings) {
        this.monthlyEarnings = monthlyEarnings;
    }

    public RichInputNumberSpinbox getMonthlyEarnings() {
        return this.monthlyEarnings;
    }

    public void annEarningsListener(ValueChangeEvent valueChangeEvent) {
        String AnnualEarn = null;
        Connection conn = new DBConnector().getDatabaseConn();
        if (this.annualEarnings.getValue() != null) {
            try {
                AnnualEarn = this.annualEarnings.getValue().toString();

                String query =
                    "begin ? := LMS_WEB_PKG_GRP.mem_monthly_earnings(?); end;";

                CallableStatement cstmt = conn.prepareCall(query);

                cstmt.registerOutParameter(1, 3);

                cstmt.setString(2, AnnualEarn);
                cstmt.execute();

                this.monthlyEarnings.setValue(cstmt.getBigDecimal(1));
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.monthlyEarnings);
                conn.close();
            } catch (Exception e) {
                GlobalCC.EXCEPTIONREPORTING(conn, e);
            }
        }
    }

    public void monthEarningsListener(ValueChangeEvent valueChangeEvent) {
        String MonthlyEarn = null;
        Connection conn = new DBConnector().getDatabaseConn();
        if (this.monthlyEarnings.getValue() != null) {
            try {
                MonthlyEarn = this.monthlyEarnings.getValue().toString();

                String query =
                    "begin ? := LMS_WEB_PKG_GRP.FUNC_MEM_ANN_EARNINGS(?); end;";

                CallableStatement cstmt = conn.prepareCall(query);
                cstmt.registerOutParameter(1, 3);

                cstmt.setString(2, MonthlyEarn);
                cstmt.execute();

                this.annualEarnings.setValue(cstmt.getBigDecimal(1));
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.annualEarnings);
                conn.close();
            } catch (Exception e) {
                GlobalCC.EXCEPTIONREPORTING(conn, e);
            }
        }
    }

    public void setPenEarnEsc(RichInputText penEarnEsc) {
        this.penEarnEsc = penEarnEsc;
    }

    public RichInputText getPenEarnEsc() {
        return this.penEarnEsc;
    }

    public void pensionTypeListener(ValueChangeEvent valueChangeEvent) {
        if (this.pensionType.getValue() != null) {
            if (this.pensionType.getValue().toString().equalsIgnoreCase("DB")) {
                this.totEmpyeeContr.setValue(null);

                this.totEmpyerContr.setValue(null);

                this.contrType.setValue(null);

                this.empyerContrRate.setValue(null);

                this.empyeeContrRate.setValue(null);

                this.empyerVolContr.setValue(null);

                this.emplyeeVolContr.setValue(null);

                this.fundingRate.setValue(null);
                this.fundingRate.setDisabled(false);
                this.penEarnEsc.setValue(null);
                this.penEarnEsc.setDisabled(false);
                this.pensEscDisplay.setValue(null);
                this.pensEscDisplay.setDisabled(false);
            } else {
                this.totEmpyeeContr.setValue(null);
                this.totEmpyeeContr.setDisabled(false);
                this.totEmpyerContr.setValue(null);
                this.totEmpyerContr.setDisabled(false);
                this.contrType.setValue(null);
                this.contrType.setDisabled(false);
                this.empyerContrRate.setValue(null);
                this.empyerContrRate.setDisabled(false);
                this.empyeeContrRate.setValue(null);
                this.empyeeContrRate.setDisabled(false);
                this.empyerVolContr.setValue(null);
                this.empyerVolContr.setDisabled(false);
                this.emplyeeVolContr.setValue(null);
                this.emplyeeVolContr.setDisabled(false);
                this.fundingRate.setValue(null);
                this.fundingRate.setDisabled(true);
                this.pensEscDisplay.setValue(null);
                this.pensEscDisplay.setDisabled(true);
                this.penEarnEsc.setValue(null);
                this.penEarnEsc.setDisabled(true);
            }

        }

        AdfFacesContext.getCurrentInstance().addPartialTarget(this.totEmpyeeContr);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.totEmpyerContr);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.contrType);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.empyerContrRate);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.empyeeContrRate);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.empyerVolContr);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.emplyeeVolContr);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.fundingRate);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.pensEscDisplay);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.penEarnEsc);
    }

    public void lifeRiderListener(ValueChangeEvent valueChangeEvent) {
        if (this.groupLifeRider.getValue() != null) {
            if (this.groupLifeRider.getValue().toString().equalsIgnoreCase("Y")) {
                this.premMaskBut.setDisabled(false);
                this.categoryDisplay.setRendered(true);
                this.categoryPanel.setRendered(true);
                this.grpLifeRider.setRendered(true);
            } else {
                premMasksDisplay.setValue(null);
                this.premMaskBut.setDisabled(true);
                this.categoryDisplay.setRendered(false);
                this.categoryPanel.setRendered(false);
                this.grpLifeRider.setRendered(false);
            }
        }

        AdfFacesContext.getCurrentInstance().addPartialTarget(this.categoryDisplay);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.categoryPanel);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.grpLifeRider);
        //AdfFacesContext.getCurrentInstance().addPartialTarget(this.premMasksDisplay);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.premMaskBut);

    }

    public void setCategoryDisplay(RichOutputLabel categoryDisplay) {
        this.categoryDisplay = categoryDisplay;
    }

    public RichOutputLabel getCategoryDisplay() {
        return this.categoryDisplay;
    }

    public void setCategoryPanel(HtmlPanelGrid categoryPanel) {
        this.categoryPanel = categoryPanel;
    }

    public HtmlPanelGrid getCategoryPanel() {
        return this.categoryPanel;
    }

    public void setGrpLifeRider(RichSelectBooleanCheckbox grpLifeRider) {
        this.grpLifeRider = grpLifeRider;
    }

    public RichSelectBooleanCheckbox getGrpLifeRider() {
        return this.grpLifeRider;
    }

    public void glifeListener(ValueChangeEvent valueChangeEvent) {
        if (this.grpLifeRider.isSelected())
            this.MemGrpLifeRider = "Y";
        else
            this.MemGrpLifeRider = "N";
    }

    public String SaveQuoteMember() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        try {
            String polQuery =
                "begin LMS_WEB_PKG_GRP.add_member(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," +
                "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);end;";

            cst = conn.prepareCall(polQuery);

            cst.registerOutParameter(1, 2);
            cst.setString(2, "Q");
            cst.setBigDecimal(3, null);
            cst.setBigDecimal(4,
                              (BigDecimal)this.session.getAttribute("QuoteCode"));
            cst.setBigDecimal(5,
                              (BigDecimal)this.session.getAttribute("ProductCode"));
            if (this.quotememANB.getValue() == null)
                cst.setBigDecimal(6, null);
            else {
                cst.setString(6, this.quotememANB.getValue().toString());
            }
            if (this.memNo.getValue() == null)
                cst.setString(7, null);
            else {
                cst.setString(7, this.memNo.getValue().toString());
            }
            if (this.memSurname.getValue() == null)
                cst.setString(8, null);
            else {
                cst.setString(8, this.memSurname.getValue().toString());
            }
            if (this.memloanDate.getValue() == null)
                cst.setString(9, null);
            else {
                cst.setString(9,
                              GlobalCC.parseDate(this.memloanDate.getValue().toString()));
            }
            if (this.origloanAmt.getValue() == null)
                cst.setBigDecimal(10, null);
            else {
                cst.setString(10, this.origloanAmt.getValue().toString());
            }
            if (this.loanInt.getValue() == null)
                cst.setBigDecimal(11, null);
            else {
                cst.setString(11, this.loanInt.getValue().toString());
            }
            if (this.origRepayPeriod.getValue() == null)
                cst.setBigDecimal(12, null);
            else {
                cst.setString(12, this.origRepayPeriod.getValue().toString());
            }
            cst.setString(13, null);
            cst.setDate(14, null);
            if (this.savingAmt.getValue() == null)
                cst.setBigDecimal(15, null);
            else {
                cst.setString(15, this.savingAmt.getValue().toString());
            }
            if (this.emprBF.getValue() == null)
                cst.setBigDecimal(16, null);
            else {
                cst.setString(16, this.emprBF.getValue().toString());
            }
            if (this.empeBF.getValue() == null)
                cst.setBigDecimal(17, null);
            else {
                cst.setString(17, this.empeBF.getValue().toString());
            }
            if (this.memcontrType.getValue() == null)
                cst.setString(18, null);
            else {
                cst.setString(18, this.memcontrType.getValue().toString());
            }
            if (this.memcontrType.getValue() == null)
                cst.setString(19, null);
            else {
                cst.setString(19, this.memcontrType.getValue().toString());
            }
            if (this.empeContr.getValue() == null)
                cst.setString(20, null);
            else {
                cst.setString(20, this.empeContr.getValue().toString());
            }
            if (this.emprContr.getValue() == null)
                cst.setString(21, null);
            else {
                cst.setString(21, this.emprContr.getValue().toString());
            }
            if (this.monthlyEarnings.getValue() == null)
                cst.setString(22, null);
            else {
                cst.setString(22, this.monthlyEarnings.getValue().toString());
            }
            if (this.memEarnprds.getValue() == null)
                cst.setString(23, null);
            else {
                cst.setString(23, this.memEarnprds.getValue().toString());
            }
            cst.setString(24, this.MemGrpLifeRider);
            cst.setBigDecimal(25, null);
            cst.setInt(26, 1000);
            cst.setString(27, "Self");
            if (this.memOtherNames.getValue() == null)
                cst.setString(28, null);
            else {
                cst.setString(28, this.memOtherNames.getValue().toString());
            }
            //cst.setString(29, null);            
            if (addrss.getValue() == null){
                cst.setString(29, null);
            } else{
                cst.setString(29, (String)addrss.getValue());
            } 
            cst.setString(30, null);
            if (this.joinDate.getValue() == null)
                cst.setString(31, null);
            else {
                cst.setString(31,
                              GlobalCC.parseDate(this.joinDate.getValue().toString()));
            }

            if (this.idNo.getValue() == null)
                cst.setString(32, null);
            else {
                cst.setString(32, this.idNo.getValue().toString());
            }
            if (this.memdob.getValue() == null) {
                cst.setString(33, null);
            } else if (this.memdob.getValue().toString().contains(":"))
                cst.setString(33,
                              GlobalCC.parseDate(this.memdob.getValue().toString()));
            else {
                cst.setString(33,
                              GlobalCC.upDateParseDate(this.memdob.getValue().toString()));
            }

            cst.setDate(34, null);
            if (this.memSex.getValue() == null)
                cst.setString(35, null);
            else {
                cst.setString(35, this.memSex.getValue().toString());
            }
            cst.setBigDecimal(36, null);
            cst.setBigDecimal(37, null);
            if (this.weight.getValue() == null)
                cst.setString(38, null);
            else {
                cst.setString(38, this.weight.getValue().toString());
            }
            if (this.height.getValue() == null)
                cst.setString(39, null);
            else {
                cst.setString(39, this.height.getValue().toString());
            }
            cst.setBigDecimal(40,
                              (BigDecimal)this.session.getAttribute("OccupationCode"));
            if (this.sysPres.getValue() == null)
                cst.setString(41, null);
            else {
                cst.setString(41, this.sysPres.getValue().toString());
            }
            if (this.diaPres.getValue() == null)
                cst.setString(42, null);
            else {
                cst.setString(42, this.diaPres.getValue().toString());
            }
            cst.setBigDecimal(43, null);
            cst.setString(44, null);
            cst.setBigDecimal(45, null);
            cst.setBigDecimal(46,
                              (BigDecimal)this.session.getAttribute("PolicyCategory"));
            cst.setBigDecimal(47, null);
            cst.setBigDecimal(48, null);
            cst.setBigDecimal(49, null);
            cst.setBigDecimal(50, null);
            if (this.annualEarnings.getValue() == null)
                cst.setString(51, null);
            else {
                cst.setString(51, this.annualEarnings.getValue().toString());
            }
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
            if(pinNo.getValue() == null){
                cst.setString(54, null);
            }else{
                cst.setString(54, (String)pinNo.getValue());
            }

            cst.execute();

            this.session.setAttribute("MemberNumber", cst.getBigDecimal(1));
            this.session.setAttribute("quoteMemMemCode", cst.getBigDecimal(1));

            cst.close();
            conn.close();

            this.addMember.setDisabled(true);

            GlobalCC.INFORMATIONREPORTING("Member Added");

            ADFUtils.findIterator("FindMemberDependantsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.memDependantsLOV);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public String saveDependants() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;

        BigDecimal Memb =
            (BigDecimal)this.session.getAttribute("MemberNumber");
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

           if (this.djMemNo.getValue() == null)
                cst.setBigDecimal(1, null);
            else {
                cst.setString(1, this.djMemNo.getValue().toString());
            }
            if (this.djSurname.getValue() == null)
                cst.setBigDecimal(2, null);
            else {
                cst.setString(2, this.djSurname.getValue().toString());
            }
            if (this.djOtherNames.getValue() == null)
                cst.setBigDecimal(3, null);
            else {
                cst.setString(3, this.djOtherNames.getValue().toString());
            }
            cst.setBigDecimal(4,
                              (BigDecimal)this.session.getAttribute("DepTypeCode"));
            if (this.djSex.getValue() == null)
                cst.setBigDecimal(5, null);
            else {
                cst.setString(5, this.djSex.getValue().toString());
            }
            if (this.djDOB.getValue() == null)
                cst.setString(6, null);
            else {
                cst.setString(6,
                              GlobalCC.parseDate(this.djDOB.getValue().toString()));
            }

            cst.setString(7, (String)this.session.getAttribute("DepTypeDesc"));
            if (this.djIDNo.getValue() == null)
                cst.setBigDecimal(8, null);
            else {
                cst.setString(8, this.djIDNo.getValue().toString());
            }
            cst.setString(9,
                          (String)this.session.getAttribute("CurrentStatus"));
            cst.setBigDecimal(10,
                              (BigDecimal)this.session.getAttribute("MemberNumber"));
            cst.setBigDecimal(11,
                              (BigDecimal)this.session.getAttribute("prpCode"));
            cst.setBigDecimal(12,
                              (BigDecimal)this.session.getAttribute("PolicyCategory"));
            cst.setBigDecimal(13,
                              (BigDecimal)this.session.getAttribute("ProductCode"));
            String custa = (String)this.session.getAttribute("CurrentStatus");
            if (custa.equalsIgnoreCase("Q"))
                cst.setBigDecimal(14,
                                  (BigDecimal)this.session.getAttribute("QuoteCode"));
            else {
                cst.setBigDecimal(14,
                                  (BigDecimal)this.session.getAttribute("endorsementCode"));
            }
            if(djAddress.getValue()==null){
              cst.setString(15, null);
            }else{
              cst.setString(15, djAddress.getValue().toString());
            }
            if(dpinNo.getValue()==null){
              cst.setString(16, null);
            }else{
              cst.setString(16, dpinNo.getValue().toString());
            }
            cst.execute();
            cst.close();
            conn.close();
            this.djMemNo.setValue(null);
            this.djSurname.setValue(null);
            this.djOtherNames.setValue(null);
            this.djSex.setValue(null);
            this.djDOB.setValue(null);
            this.djIDNo.setValue(null);
            this.djAddress.setValue(null);
            this.dpinNo.setValue(null);

            AdfFacesContext.getCurrentInstance().addPartialTarget(this.djMemNo);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.djSurname);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.djOtherNames);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.djSex);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.djDOB);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.djIDNo);

            //System.out.println("Dependant Iterator Called");

            ADFUtils.findIterator("FindMemberDependantsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.memDependantsLOV);
            
            //System.out.println("Joint Iterator Called");
            
            //ADFUtils.findIterator("FindQuoteJointMembersIterator").executeQuery();
            //AdfFacesContext.getCurrentInstance().addPartialTarget(this.jointMemLOV);

            String Message = dependantDialog.getTitle()+" Added";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
        } catch (Exception e) {
            this.djMemNo.setValue(null);
            this.djSurname.setValue(null);
            this.djOtherNames.setValue(null);
            this.djSex.setValue(null);
            this.djDOB.setValue(null);
            this.djIDNo.setValue(null);

            AdfFacesContext.getCurrentInstance().addPartialTarget(this.djMemNo);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.djSurname);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.djOtherNames);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.djSex);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.djDOB);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.djIDNo);

            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                          e.getMessage(),
                                                                          e.getMessage()));
        }

        return null;
    }
    
  public String saveJointMembers() {
      DBConnector myConn = new DBConnector();
      Connection conn = myConn.getDatabaseConn();
      CallableStatement cst = null;

      BigDecimal Memb =
          (BigDecimal)this.session.getAttribute("MemberNumber");
      if (Memb == null) {
          String Message = "Save Main Member First";
          FacesContext.getCurrentInstance().addMessage(null,
                                                       new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                        Message,
                                                                        Message));

          return null;
      }

      try {
        String dtyDesc = "JOINT";
          String polQuery =
              "begin LMS_WEB_PKG_GRP.createDependents(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);end;";
          cst = conn.prepareCall(polQuery);

         if (this.djntMemNo.getValue() == null)
              cst.setBigDecimal(1, null);
          else {
              cst.setString(1, this.djntMemNo.getValue().toString());
          }
          if (this.djntSurname.getValue() == null)
              cst.setBigDecimal(2, null);
          else {
              cst.setString(2, this.djntSurname.getValue().toString());
          }
          if (this.djntOtherNames.getValue() == null)
              cst.setBigDecimal(3, null);
          else {
              cst.setString(3, this.djntOtherNames.getValue().toString());
          }
          //cst.setBigDecimal(4, (BigDecimal)this.session.getAttribute("DepTypeCode"));
          cst.setBigDecimal(4, new BigDecimal(1003));
          if (this.djntSex.getValue() == null)
              cst.setBigDecimal(5, null);
          else {
              cst.setString(5, this.djntSex.getValue().toString());
          }
          if (this.djntDOB.getValue() == null)
              cst.setString(6, null);
          else {
              cst.setString(6,
                            GlobalCC.parseDate(this.djntDOB.getValue().toString()));
          }

          //cst.setString(7, (String)this.session.getAttribute("DepTypeDesc"));
          cst.setString(7, dtyDesc);
          System.out.println("Dty Description "+dtyDesc);
          if (this.djntIDNo.getValue() == null)
              cst.setBigDecimal(8, null);
          else {
              cst.setString(8, this.djntIDNo.getValue().toString());
          }
          cst.setString(9,
                        (String)this.session.getAttribute("CurrentStatus"));
          cst.setBigDecimal(10,
                            (BigDecimal)this.session.getAttribute("MemberNumber"));
          cst.setBigDecimal(11,
                            (BigDecimal)this.session.getAttribute("prpCode"));
          cst.setBigDecimal(12,
                            (BigDecimal)this.session.getAttribute("PolicyCategory"));
          cst.setBigDecimal(13,
                            (BigDecimal)this.session.getAttribute("ProductCode"));
          String custa = (String)this.session.getAttribute("CurrentStatus");
          if (custa.equalsIgnoreCase("Q"))
              cst.setBigDecimal(14,
                                (BigDecimal)this.session.getAttribute("QuoteCode"));
          else {
              cst.setBigDecimal(14,
                                (BigDecimal)this.session.getAttribute("endorsementCode"));
          }
          if(djntPinNo.getValue()==null){
            cst.setString(15, null);
          }else{
            cst.setString(15, djntPinNo.getValue().toString());
          }
          if(djntPinNo.getValue()==null){
            cst.setString(16, null);
          }else{
            cst.setString(16, djntPinNo.getValue().toString());
          }
          cst.execute();
          cst.close();
          conn.close();
          this.djntMemNo.setValue(null);
          this.djntSurname.setValue(null);
          this.djntOtherNames.setValue(null);
          this.djntSex.setValue(null);
          this.djntDOB.setValue(null);
          this.djntIDNo.setValue(null);

          AdfFacesContext.getCurrentInstance().addPartialTarget(this.djntMemNo);
          AdfFacesContext.getCurrentInstance().addPartialTarget(this.djntSurname);
          AdfFacesContext.getCurrentInstance().addPartialTarget(this.djntOtherNames);
          AdfFacesContext.getCurrentInstance().addPartialTarget(this.djntSex);
          AdfFacesContext.getCurrentInstance().addPartialTarget(this.djntDOB);
          AdfFacesContext.getCurrentInstance().addPartialTarget(this.djntIDNo);

          //System.out.println("Dependant Iterator Called");

          //ADFUtils.findIterator("FindMemberDependantsIterator").executeQuery();
          //AdfFacesContext.getCurrentInstance().addPartialTarget(this.memDependantsLOV);
          
          //System.out.println("Joint Iterator Called");
          
          ADFUtils.findIterator("FindQuoteJointMembersIterator").executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(this.jointMemLOV);

          //String Message = dependantDialog.getTitle()+" Added";
          String Message = "Joint Member Added";
          FacesContext.getCurrentInstance().addMessage(null,
                                                       new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                        Message,
                                                                        Message));
      } catch (Exception e) {
          this.djntMemNo.setValue(null);
          this.djntSurname.setValue(null);
          this.djntOtherNames.setValue(null);
          this.djntSex.setValue(null);
          this.djntDOB.setValue(null);
          this.djntIDNo.setValue(null);

          AdfFacesContext.getCurrentInstance().addPartialTarget(this.djntMemNo);
          AdfFacesContext.getCurrentInstance().addPartialTarget(this.djntSurname);
          AdfFacesContext.getCurrentInstance().addPartialTarget(this.djntOtherNames);
          AdfFacesContext.getCurrentInstance().addPartialTarget(this.djntSex);
          AdfFacesContext.getCurrentInstance().addPartialTarget(this.djntDOB);
          AdfFacesContext.getCurrentInstance().addPartialTarget(this.djntIDNo);

          FacesContext.getCurrentInstance().addMessage(null,
                                                       new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                        e.getMessage(),
                                                                        e.getMessage()));
      }

      return null;
  }

    public String findDependantsSelected() {
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("FindDependantTypesIterator");
            RowKeySet set = this.depTypeLOV2.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();
            
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                this.session.setAttribute("DepTypeCode",
                                          r.getAttribute("DTY_CODE"));
                this.session.setAttribute("DepTypeDesc",
                                          r.getAttribute("DTY_SHT_DESC"));
               /* if(this.memNo.getValue()==null){
                  this.djMemNo.setValue(null); 
                }else{    
                  this.djMemNo.setValue(this.memNo.getValue().toString());
                  this.djMemNo.setDisabled(false);
                } */               
                this.djSurname.setValue(null);
                this.djOtherNames.setValue(null);
                this.djSex.setValue(null);
                this.djDOB.setValue(null);
                this.djIDNo.setValue(null);

                ExtendedRenderKitService erkService =
                    (ExtendedRenderKitService)Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                                                 ExtendedRenderKitService.class);
                erkService.addScript(FacesContext.getCurrentInstance(),
                                     "var hints = {autodismissNever:false}; AdfPage.PAGE.findComponent('lmsgroup:saveinfo').show(hints);");
            }

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return null;
    }

    public String DeleteDependantsSelected() {
        Connection conn = null;
        try {
            DBConnector myConn = new DBConnector();
            conn = myConn.getDatabaseConn();
            CallableStatement cst = null;
            BigDecimal Code = null;

            DCIteratorBinding dciter =
                ADFUtils.findIterator("FindMemberDependantsIterator");
            RowKeySet set = this.memDependantsLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                Code = (BigDecimal)r.getAttribute("POLM_CODE");
                String polQuery =
                    "begin LMS_WEB_PKG_GRP.delete_quot_dependent(?,?);end;";
                cst = conn.prepareCall(polQuery);
                cst.setBigDecimal(1,
                                  (BigDecimal)this.session.getAttribute("QuoteCode"));
                cst.setBigDecimal(2, Code);
                cst.execute();
                cst.close();
                conn.close();
                ADFUtils.findIterator("FindMemberDependantsIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.memDependantsLOV);
            }

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }

        return null;
    }

    public String RefreshComponents() {
        this.memNo.setValue(null);
        this.memSurname.setValue(null);
        this.memloanDate.setValue(null);
        this.origloanAmt.setValue(null);
        this.loanInt.setValue(null);
        this.origRepayPeriod.setValue(null);
        this.savingAmt.setValue(null);
        this.emprBF.setValue(null);
        this.empeBF.setValue(null);
        this.memcontrType.setValue(null);
        this.empeContr.setValue(null);
        this.emprContr.setValue(null);

        this.memEarnprds.setValue(null);
        this.occupationDesc.setValue(null);

        this.memOtherNames.setValue(null);
        this.joinDate.setValue(null);
        this.idNo.setValue(null);

        this.memSex.setValue(null);
        this.weight.setValue(null);
        this.height.setValue(null);
        this.sysPres.setValue(null);
        this.diaPres.setValue(null);
        this.categoryDesc.setValue(null);
        this.yeat.setValue(null);
        this.session.setAttribute("MemberNumber",null);
        this.session.setAttribute("quoteMemMemCode", null);
      
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.memNo);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.memSurname);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.memloanDate);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.origloanAmt);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.loanInt);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.origRepayPeriod);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.savingAmt);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.emprBF);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.empeBF);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.memcontrType);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.empeContr);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.emprContr);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.occupationDesc);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.memEarnprds);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.memOtherNames);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.joinDate);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.idNo);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.memSex);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.weight);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.height);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.sysPres);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.diaPres);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.categoryDesc);

        this.addMember.setDisabled(false);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.addMember);

        NewMember();

        ADFUtils.findIterator("FindMemberDependantsIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.memDependantsLOV);
      ADFUtils.findIterator("FindQuoteJointMembersIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.jointMemLOV);

        return null;
    }

    public String findQuoteCategorySelected() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findQuoteCategoriesIterator");
        RowKeySet set = this.memcategoryLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            this.categoryDesc.setValue(r.getAttribute("catDesc"));

            this.session.setAttribute("PolicyCategory",
                                      r.getAttribute("lcaCode"));
            this.memEarnprds.setValue(r.getAttribute("catPeriod"));
        }

        return null;
    }

    public String findOccupationSelected() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindOccupationsIterator");
        RowKeySet set = this.occupationLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            this.occupationDesc.setValue(r.getAttribute("GCO_DESC"));
            
            //System.out.println("GCO CODE"+r.getAttribute("GCO_CODE"));
            //this.session.setAttribute("gcoCode", r.getAttribute("GCO_CODE"));
            this.session.setAttribute("OccupationCode", r.getAttribute("gco_code"));
           
        }

        return null;
    }

    public void setMemNo(RichInputText memNo) {
        this.memNo = memNo;
    }

    public RichInputText getMemNo() {
        return this.memNo;
    }

    public void setMemSurname(RichInputText memSurname) {
        this.memSurname = memSurname;
    }

    public RichInputText getMemSurname() {
        return this.memSurname;
    }

    public void setMemOtherNames(RichInputText memOtherNames) {
        this.memOtherNames = memOtherNames;
    }

    public RichInputText getMemOtherNames() {
        return this.memOtherNames;
    }

    public void setIdNo(RichInputText idNo) {
        this.idNo = idNo;
    }

    public RichInputText getIdNo() {
        return this.idNo;
    }

    public void setYeat(RichInputText yeat) {
        this.yeat = yeat;
    }

    public RichInputText getYeat() {
        return this.yeat;
    }

    public void setWeight(RichInputText weight) {
        this.weight = weight;
    }

    public RichInputText getWeight() {
        return this.weight;
    }

    public void setHeight(RichInputText height) {
        this.height = height;
    }

    public RichInputText getHeight() {
        return this.height;
    }

    public void setDepTypeDesc(RichInputText depTypeDesc) {
        this.depTypeDesc = depTypeDesc;
    }

    public RichInputText getDepTypeDesc() {
        return this.depTypeDesc;
    }

    public void setCategoryDesc(RichInputText categoryDesc) {
        this.categoryDesc = categoryDesc;
    }

    public RichInputText getCategoryDesc() {
        return this.categoryDesc;
    }

    public void setSysPres(RichInputText sysPres) {
        this.sysPres = sysPres;
    }

    public RichInputText getSysPres() {
        return this.sysPres;
    }

    public void setDiaPres(RichInputText diaPres) {
        this.diaPres = diaPres;
    }

    public RichInputText getDiaPres() {
        return this.diaPres;
    }

    public void setOccupationDesc(RichInputText occupationDesc) {
        this.occupationDesc = occupationDesc;
    }

    public RichInputText getOccupationDesc() {
        return this.occupationDesc;
    }

    public void setMemSex(RichSelectOneChoice memSex) {
        this.memSex = memSex;
    }

    public RichSelectOneChoice getMemSex() {
        return this.memSex;
    }

    public void setLoanDate(RichInputDate loanDate) {
        this.loanDate = loanDate;
    }

    public RichInputDate getLoanDate() {
        return this.loanDate;
    }

    public void setMemloanDate(RichInputDate memloanDate) {
        this.memloanDate = memloanDate;
    }

    public RichInputDate getMemloanDate() {
        return this.memloanDate;
    }

    public void setOrigloanAmt(RichInputNumberSpinbox origloanAmt) {
        this.origloanAmt = origloanAmt;
    }

    public RichInputNumberSpinbox getOrigloanAmt() {
        return this.origloanAmt;
    }

    public void setOrigRepayPeriod(RichInputText origRepayPeriod) {
        this.origRepayPeriod = origRepayPeriod;
    }

    public RichInputText getOrigRepayPeriod() {
        return this.origRepayPeriod;
    }

    public void setLoanInt(RichInputText loanInt) {
        this.loanInt = loanInt;
    }

    public RichInputText getLoanInt() {
        return this.loanInt;
    }

    public void setSavingAmt(RichInputNumberSpinbox savingAmt) {
        this.savingAmt = savingAmt;
    }

    public RichInputNumberSpinbox getSavingAmt() {
        return this.savingAmt;
    }

    public void setMemEarnprds(RichInputText memEarnprds) {
        this.memEarnprds = memEarnprds;
    }

    public RichInputText getMemEarnprds() {
        return this.memEarnprds;
    }

    public void setJoinDate(RichInputDate joinDate) {
        this.joinDate = joinDate;
    }

    public RichInputDate getJoinDate() {
        return this.joinDate;
    }

    public void setYrsOfService(RichInputText yrsOfService) {
        this.yrsOfService = yrsOfService;
    }

    public RichInputText getYrsOfService() {
        return this.yrsOfService;
    }

    public void setFutYearSrv(RichInputText futYearSrv) {
        this.futYearSrv = futYearSrv;
    }

    public RichInputText getFutYearSrv() {
        return this.futYearSrv;
    }

    public void setTotSrvYears(RichInputText totSrvYears) {
        this.totSrvYears = totSrvYears;
    }

    public RichInputText getTotSrvYears() {
        return this.totSrvYears;
    }

    public void setMemcontrType(RichSelectOneChoice memcontrType) {
        this.memcontrType = memcontrType;
    }

    public RichSelectOneChoice getMemcontrType() {
        return this.memcontrType;
    }

    public void setEmpeContr(RichInputText empeContr) {
        this.empeContr = empeContr;
    }

    public RichInputText getEmpeContr() {
        return this.empeContr;
    }

    public void setEmprContr(RichInputText emprContr) {
        this.emprContr = emprContr;
    }

    public RichInputText getEmprContr() {
        return this.emprContr;
    }

    public void setEmpeBF(RichInputText empeBF) {
        this.empeBF = empeBF;
    }

    public RichInputText getEmpeBF() {
        return this.empeBF;
    }

    public void setEmprBF(RichInputText emprBF) {
        this.emprBF = emprBF;
    }

    public RichInputText getEmprBF() {
        return this.emprBF;
    }

    public void setTotalPen(RichInputText totalPen) {
        this.totalPen = totalPen;
    }

    public RichInputText getTotalPen() {
        return this.totalPen;
    }

    public void setMemcategoryLOV(RichTable memcategoryLOV) {
        this.memcategoryLOV = memcategoryLOV;
    }

    public RichTable getMemcategoryLOV() {
        return this.memcategoryLOV;
    }

    public void setOccupationLOV(RichTable occupationLOV) {
        this.occupationLOV = occupationLOV;
    }

    public RichTable getOccupationLOV() {
        return this.occupationLOV;
    }

    public void setAddMember(RichCommandButton addMember) {
        this.addMember = addMember;
    }

    public RichCommandButton getAddMember() {
        return this.addMember;
    }

    public void setDjMemNo(RichInputText djMemNo) {
        this.djMemNo = djMemNo;
    }

    public RichInputText getDjMemNo() {
        return this.djMemNo;
    }

    public void setDjSurname(RichInputText djSurname) {
        this.djSurname = djSurname;
    }

    public RichInputText getDjSurname() {
        return this.djSurname;
    }

    public void setDjOtherNames(RichInputText djOtherNames) {
        this.djOtherNames = djOtherNames;
    }

    public RichInputText getDjOtherNames() {
        return this.djOtherNames;
    }

    public void setDjSex(RichSelectOneChoice djSex) {
        this.djSex = djSex;
    }

    public RichSelectOneChoice getDjSex() {
        return this.djSex;
    }

    public void setDjIDNo(RichInputText djIDNo) {
        this.djIDNo = djIDNo;
    }

    public RichInputText getDjIDNo() {
        return this.djIDNo;
    }

    public void setDjDOB(RichInputDate djDOB) {
        this.djDOB = djDOB;
    }

    public RichInputDate getDjDOB() {
        return this.djDOB;
    }

    public void setMemDependantsLOV(RichTable memDependantsLOV) {
        this.memDependantsLOV = memDependantsLOV;
    }

    public RichTable getMemDependantsLOV() {
        return this.memDependantsLOV;
    }

    public void setCovProvLOV(RichTable covProvLOV) {
        this.covProvLOV = covProvLOV;
    }

    public RichTable getCovProvLOV() {
        return this.covProvLOV;
    }

    public void setCoinsurerLOV(RichTable coinsurerLOV) {
        this.coinsurerLOV = coinsurerLOV;
    }

    public RichTable getCoinsurerLOV() {
        return this.coinsurerLOV;
    }

    public void setCoinsurerLabel(RichOutputText coinsurerLabel) {
        this.coinsurerLabel = coinsurerLabel;
    }

    public RichOutputText getCoinsurerLabel() {
        return this.coinsurerLabel;
    }

    public void setCoShare(RichInputNumberSpinbox coShare) {
        this.coShare = coShare;
    }

    public RichInputNumberSpinbox getCoShare() {
        return this.coShare;
    }

    public void setCoServFee(RichInputNumberSpinbox coServFee) {
        this.coServFee = coServFee;
    }

    public RichInputNumberSpinbox getCoServFee() {
        return this.coServFee;
    }

    public void setQuoteCoinsurersLOV(RichTable quoteCoinsurersLOV) {
        this.quoteCoinsurersLOV = quoteCoinsurersLOV;
    }

    public RichTable getQuoteCoinsurersLOV() {
        return this.quoteCoinsurersLOV;
    }

    public void setCoLeadFollow(RichSelectOneChoice coLeadFollow) {
        this.coLeadFollow = coLeadFollow;
    }

    public RichSelectOneChoice getCoLeadFollow() {
        return this.coLeadFollow;
    }

    public void setLeaderShare(RichInputNumberSpinbox leaderShare) {
        this.leaderShare = leaderShare;
    }

    public RichInputNumberSpinbox getLeaderShare() {
        return this.leaderShare;
    }

    public void setCoinsCbox(RichSelectBooleanCheckbox coinsCbox) {
        this.coinsCbox = coinsCbox;
    }

    public RichSelectBooleanCheckbox getCoinsCbox() {
        return this.coinsCbox;
    }

    public void coinsuranceListener(ValueChangeEvent valueChangeEvent) {
        if (this.coinsCbox.isSelected())
            this.coinsureTab.setRendered(true);
        else {
            this.coinsureTab.setRendered(false);
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.coinsureTab);
    }

    public void setCoinsureTab(RichPanelBox coinsureTab) {
        this.coinsureTab = coinsureTab;
    }

    public RichPanelBox getCoinsureTab() {
        return this.coinsureTab;
    }

    public String calctypeListener() {
        if (this.quotationCalcType.getValue() == null)
            this.session.setAttribute("calcType", "D");
        else {
            this.session.setAttribute("calcType",
                                      this.quotationCalcType.getValue().toString());
        }

        String ProductType = (String)this.session.getAttribute("productType");
        String CalcType = (String)this.session.getAttribute("calcType");
        Rendering render=new Rendering();

        if (CalcType.equalsIgnoreCase("A")) {
            this.aggQuotePlanLbl.setRendered(true);
            this.aggQuotePlan.setRendered(true);
            this.saLabel.setRendered(true);
            this.coverSADisplay.setRendered(true);
            this.depTypeLabel.setRendered(true);
            this.depTypeDtls.setRendered(true);
            this.totalMemLabel.setRendered(true);
            this.totalMem.setRendered(true);
            this.avgLabAggregate.setRendered(true);
            this.aggCatPanel.setRendered(true);
            this.avANBLabel.setRendered(false);
            if (ProductType.equalsIgnoreCase("EARN")) {
                this.avMemEarnlabel.setRendered(true);
                this.avMemberEarnings.setRendered(true);

                this.multiEarnsPeriodlbl.setRendered(true);
                String Value = Validate_Quote_Product();
                if ((Value == null)){
                  this.prdTypeLabel2.setValue("[Months]");
                }else if(Value.equalsIgnoreCase("F")){
                  this.prdTypeLabel2.setValue("[Months]");
                }else {
                  this.prdTypeLabel2.setValue(Value);
                }
                /*if ((Value == null) || (Value == "F"))
                    this.prdTypeLabel2.setValue("[Months]");
                else {
                    this.prdTypeLabel2.setValue(Value);
                }*/
                this.prdTypeLabel2.setRendered(true);
                this.multiprdPanel.setRendered(true);
                this.totalMemEarninglbl.setRendered(true);
                this.totalMemEarning.setRendered(true);
                this.aggCatPanel.setRendered(true);
                this.cvrMultipleEarningsPeriod.setRendered(true);
                this.cvrCategorylabel.setRendered(true);
                this.cvrCategory.setRendered(true);
                this.totLoanAmtLabel.setRendered(false);
                this.totLoanAmt.setRendered(false);
            } else if (ProductType.equalsIgnoreCase("LOAN")) {
                this.loanAmtLabel.setRendered(true);
                this.cvrLoanAmt.setRendered(true);
                this.loanRepyLabel.setRendered(true);
                this.cvrLoanPrd.setRendered(true);
                this.loanIntLabel.setRendered(true);
                this.cvrLoanInt.setRendered(true);
                this.savingsAmtLabel.setRendered(true);
                this.cvrSavingsAmt.setRendered(true);
                this.totLoanAmtLabel.setRendered(true);
                this.totLoanAmt.setRendered(true);
                if(render.isMickVisible()){
                  this.aggCatPanel.setRendered(true);
                  this.cvrCategorylabel.setRendered(true);
                  //this.cvrCategory.setValue("DEFAULT");
                  this.cvrCategory.setRendered(true);
                  
                }else{
                  this.aggCatPanel.setRendered(false);
                  this.cvrCategorylabel.setRendered(false);
                  this.cvrCategory.setRendered(false);  
                }
                
            } else if (ProductType.equalsIgnoreCase("FUNE")) {
                this.cvrCategorylabel.setRendered(true);
                this.cvrCategory.setRendered(true);
                this.avCoverPerMemLabel.setRendered(true);
                this.avCoverPerMem.setRendered(true);
                this.aggCatPanel.setRendered(true);
            }
        } else {
            this.aggQuotePlanLbl.setRendered(false);
            this.aggQuotePlan.setRendered(false);
            this.saLabel.setRendered(false);
            this.coverSADisplay.setRendered(false);
            this.avANBLabel.setRendered(true);
            this.avANB.setRendered(true);
            this.depTypeLabel.setRendered(false);
            this.depTypeDtls.setRendered(false);
            this.avMemEarnlabel.setRendered(false);
            this.avMemberEarnings.setRendered(false);
            this.totalMemEarninglbl.setRendered(false);
            this.totalMemEarning.setRendered(false);
            this.totalMemLabel.setRendered(false);
            this.totalMem.setRendered(false);
            this.multiEarnsPeriodlbl.setRendered(false);
            this.cvrMultipleEarningsPeriod.setRendered(false);
            this.prdTypeLabel2.setRendered(false);
            this.multiprdPanel.setRendered(false);
            this.aggCatPanel.setRendered(false);
            this.cvrCategorylabel.setRendered(false);
            this.cvrCategory.setRendered(false);
            this.loanAmtLabel.setRendered(false);
            this.cvrLoanAmt.setRendered(false);
            this.loanRepyLabel.setRendered(false);
            this.cvrLoanPrd.setRendered(false);
            this.loanIntLabel.setRendered(false);
            this.cvrLoanInt.setRendered(false);
            this.savingsAmtLabel.setRendered(false);
            this.cvrSavingsAmt.setRendered(false);
            this.totLoanAmtLabel.setRendered(false);
            this.totLoanAmt.setRendered(false);
            this.avCoverPerMemLabel.setRendered(false);
            this.avCoverPerMem.setRendered(false);
            this.avgLabAggregate.setRendered(false);
            this.aggCatPanel.setRendered(false);
            this.avANBLabel.setRendered(true);
        }

        AdfFacesContext.getCurrentInstance().addPartialTarget(this.saLabel);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.coverSADisplay);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.avANBLabel);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.avANB);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.depTypeLabel);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.depTypeDtls);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.avMemEarnlabel);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.avMemberEarnings);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.totalMemLabel);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.totalMem);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.multiEarnsPeriodlbl);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.cvrMultipleEarningsPeriod);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.cvrCategorylabel);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.cvrCategory);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.totalMemEarninglbl);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.totalMemEarning);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.avgLabAggregate);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.aggQuotePlan);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.aggQuotePlanLbl);
      
        return null;
    }

    public void setSaLabel(RichOutputLabel saLabel) {
        this.saLabel = saLabel;
    }

    public RichOutputLabel getSaLabel() {
        return this.saLabel;
    }

    public void quoteCoverListener(ValueChangeEvent valueChangeEvent) {
        if (this.quotationCovers.getValue() == null) {
            this.session.setAttribute("depCovered", "S");
        } else {
            this.session.setAttribute("depCovered",
                                      this.quotationCovers.getValue().toString());
        }
        String DependantCover =
            (String)this.session.getAttribute("depCovered");
        if (DependantCover.equalsIgnoreCase("S")) {
            this.depsTab.setRendered(false);
            this.jointTab.setRendered(false);
        } else if (DependantCover.equalsIgnoreCase("D")) {
            this.depsTab.setRendered(true);
            this.jointTab.setRendered(false);
        } else if (DependantCover.equalsIgnoreCase("J")) {
            this.depsTab.setRendered(false);
            this.jointTab.setRendered(true);
        } else {
            this.depsTab.setRendered(true);
            this.jointTab.setRendered(true);
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.depsTab);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.jointTab);
    }

    public void setDepsTab(RichShowDetailItem depsTab) {
        this.depsTab = depsTab;
    }

    public RichShowDetailItem getDepsTab() {
        return this.depsTab;
    }

    public void setJointTab(RichShowDetailItem jointTab) {
        this.jointTab = jointTab;
    }

    public RichShowDetailItem getJointTab() {
        return this.jointTab;
    }

    public void setAvANB(RichInputText avANB) {
        this.avANB = avANB;
    }

    public RichInputText getAvANB() {
        return this.avANB;
    }

    public void setAvANBLabel(RichOutputLabel avANBLabel) {
        this.avANBLabel = avANBLabel;
    }

    public RichOutputLabel getAvANBLabel() {
        return this.avANBLabel;
    }

    public String editQuotationCoverType() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findQuoteCoverTypesIterator");
        RowKeySet set = this.quotCoverTypes.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        Rendering render=new Rendering();

        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            this.session.setAttribute("qcvtCode", r.getAttribute("QCVT_CODE"));
            this.session.setAttribute("CVT_CODE",
                                      r.getAttribute("QCVT_CVT_CODE"));
            this.cvrTypeLabel.setValue(r.getAttribute("cover_display"));
            this.coverButChargePremium.setValue(r.getAttribute("quoButChargePrem2"));
            this.discLoadChoice.setValue(r.getAttribute("QCVT_LOAD_DISC"));
            this.discLoadRateDisplay.setValue(r.getAttribute("discLoadRate"));
            this.divFactor.setValue(r.getAttribute("QCVT_DISC_LOAD_DIV_FACT"));
            this.avANB.setValue(r.getAttribute("quoAvganb"));
            this.coverSADisplay.setValue(r.getAttribute("quoQcvtSa"));
            this.dtyDesc.setValue(r.getAttribute("QCVT_DTY_DESCRIPTION"));
            this.session.setAttribute("dtyCode",
                                      r.getAttribute("QCVT_DTY_CODE"));
            this.avMemberEarnings.setValue(r.getAttribute("QCVT_AVG_EARN_PER_MEM"));
            this.cvrMultipleEarningsPeriod.setValue(r.getAttribute("QCVT_MULT_EARNINGS_PRD"));
            this.totalMem.setValue(r.getAttribute("quoMembers"));
            this.cvrCategory.setValue(r.getAttribute("QCVT_STAFF_DESC"));
            this.mainCover.setValue(r.getAttribute("QCVT_MAIN_COVER"));
            this.percMainCvt.setValue(r.getAttribute("QCVT_MAIN_SA_PERC"));
            this.cvrLoanAmt.setValue(r.getAttribute("QCVT_LOANAMT_PER_MEM"));
            this.cvrLoanPrd.setValue(r.getAttribute("QCVT_LOAN_RPYMT_PRD"));
            this.cvrLoanInt.setValue(r.getAttribute("QCVT_LOANINT_PER_MEM"));
            this.cvrSavingsAmt.setValue(r.getAttribute("QCVT_SAVINGS_PER_MEM"));
            this.discChoice.setValue(r.getAttribute("QCVT_DISC"));
            this.discRateDisplay.setValue(r.getAttribute("QCVT_DISC_RATE"));
            this.discDivFactor.setValue(r.getAttribute("QCVT_DISC_DIV_FACT"));
            this.totalMemEarning.setValue(r.getAttribute("QCVT_TOT_MEMBER_EARNINGS"));
            this.totLoanAmt.setValue(r.getAttribute("QCVT_TOT_ORIG_LOAN_AMT"));
            this.avCoverPerMem.setValue(r.getAttribute("QCVT_AV_CVR_PER_MEMBER"));
            this.aggQuotePlan.setValue(r.getAttribute("QCVT_AGG_PLAN"));
            this.builtIn.setValue(r.getAttribute("qcvtPctInbuilt"));
            this.accelerator.setValue(r.getAttribute("qcvtAccelerator"));
            String CalcType = (String)this.session.getAttribute("calcType");
            String ProductType =
                (String)this.session.getAttribute("productType");
            String CmainCover = (String)r.getAttribute("QCVT_MAIN_COVER");
          session.setAttribute("covType",
                               (String)r.getAttribute("QCVT_MAIN_COVER"));
          session.setAttribute("riderCovType",
                               r.getAttribute("quocvtShtDesc"));

            
          if(render.isMickVisible()){
              if(CmainCover.equalsIgnoreCase("R")){
                avMemEarnlabel.setValue("average cover per member");
              }else{
                avMemEarnlabel.setValue("Av. Earnings Per Member");
              }
          }
            if (CalcType.equalsIgnoreCase("A")) {
              this.avgLabAggregate.setRendered(true);
              this.avANBLabel.setRendered(false); 
              this.aggQuotePlanLbl.setRendered(true);
              this.aggQuotePlan.setRendered(true);
              this.aggCatPanel.setRendered(true);
                if (ProductType.equalsIgnoreCase("EARN")) {
                    this.totLoanAmtLabel.setRendered(false);
                    this.totLoanAmt.setRendered(false);
                    this.multiprdPanel.setRendered(true);
                    this.avCoverPerMemLabel.setRendered(false);
                    this.avCoverPerMem.setRendered(false);
                } else if (ProductType.equalsIgnoreCase("LOAN")) {
                    this.totLoanAmtLabel.setRendered(true);
                    this.totLoanAmt.setRendered(true);
                    this.multiprdPanel.setRendered(false);
                    this.aggCatPanel.setRendered(false);
                  if(render.isMickVisible()){
                      this.aggCatPanel.setRendered(true);
                    this.cvrCategorylabel.setRendered(true); 
                   // this.cvrCategory.setValue("DEFAULT");
                    this.cvrCategory.setRendered(true);
                  }else{
                    this.aggCatPanel.setRendered(false);
                    this.cvrCategorylabel.setRendered(false);
                    this.cvrCategory.setRendered(false);  
                     }
                    this.avCoverPerMemLabel.setRendered(false);
                    this.avCoverPerMem.setRendered(false);
                } else if (ProductType.equalsIgnoreCase("FUNE")) {
                    this.avCoverPerMemLabel.setRendered(true);
                    this.avCoverPerMem.setRendered(true);
                } else {
                    this.totLoanAmtLabel.setRendered(false);
                    this.totLoanAmt.setRendered(false);
                    this.multiprdPanel.setRendered(false);
                   // this.aggCatPanel.setRendered(false);
                    this.avCoverPerMemLabel.setRendered(false);
                    this.avCoverPerMem.setRendered(false);
                }
            } else {
                this.totLoanAmtLabel.setRendered(false);
                this.totLoanAmt.setRendered(false);
                this.multiprdPanel.setRendered(false);
                this.aggCatPanel.setRendered(false);
                this.avCoverPerMemLabel.setRendered(false);
                this.avCoverPerMem.setRendered(false);
                this.avgLabAggregate.setRendered(false);
                this.avANBLabel.setRendered(true); 
                this.aggCatPanel.setRendered(false);
                this.aggQuotePlanLbl.setRendered(false);
                this.aggQuotePlan.setRendered(false);
            }

            this.productCoverDropBox.setDisabled(true);

            this.session.setAttribute("coverMaskCode",
                                      r.getAttribute("qcvt_pmas_code"));
            this.rateSelection.setValue(r.getAttribute("qcvt_use_cvr_rate"));
            if (r.getAttribute("qcvt_use_cvr_rate") == null) {
                this.maskButton.setDisabled(true);
                this.coverRate.setDisabled(true);
                this.coverRateDivFactor.setDisabled(true);
            } else {
                String Val = (String)r.getAttribute("qcvt_use_cvr_rate");
                if (Val.equalsIgnoreCase("M")) {
                    this.maskButton.setDisabled(true);
                    this.coverRate.setDisabled(true);
                    this.coverRateDivFactor.setDisabled(true);
                } else if (Val.equalsIgnoreCase("S")) {
                    this.maskButton.setDisabled(false);
                    this.coverRate.setDisabled(true);
                    this.coverRateDivFactor.setDisabled(true);
                } else if (Val.equalsIgnoreCase("C")) {
                    this.maskButton.setDisabled(true);
                    this.coverRate.setDisabled(false);
                    this.coverRateDivFactor.setDisabled(false);
                }
            }
         
            this.maskDesc.setValue(r.getAttribute("qcvt_pmas_sht_desc"));
            this.coverRate.setValue(r.getAttribute("quoQcvtRate"));
            this.coverRateDivFactor.setValue(r.getAttribute("qcvt_rate_div_fact"));
            GlobalCC.showPopup("lmsgroup:cvrdtl");
        }

        return null;
    }

    public String EditTaxesSelected() {
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findQuotationTaxes1Iterator");
            RowKeySet set = this.quotationTaxes.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                this.session.setAttribute("taxCode",
                                          r.getAttribute("qtax_code"));
                this.taxSel.setValue(r.getAttribute("tt_desc"));

                this.applLevel.setValue(r.getAttribute("QTAX_RATE_TYPE"));
                this.taxRate.setValue(r.getAttribute("qtax_rate"));
                this.taxAmt.setValue(r.getAttribute("qtax_tax_amt"));

                ExtendedRenderKitService erkService =
                    (ExtendedRenderKitService)Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                                                 ExtendedRenderKitService.class);

                erkService.addScript(FacesContext.getCurrentInstance(),
                                     "var hints = {autodismissNever:false}; AdfPage.PAGE.findComponent('lmsgroup:taxes').show(hints);");
            }

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String EditAllDepTypesAvailable() {
        try {
            ADFUtils.findIterator("FindDependantTypesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.allDepsLOV);

            GlobalCC.showPopup("lmsgroup:p4");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String findAllDepsSel() {
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("FindDependantTypesIterator");
            RowKeySet set = this.allDepsLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                this.session.setAttribute("dtyCode",
                                          r.getAttribute("DTY_CODE"));
                this.dtyDesc.setValue(r.getAttribute("DTY_DESCRIPTION"));

                AdfFacesContext.getCurrentInstance().addPartialTarget(this.dtyDesc);
                //GlobalCC.showPopup("lmsgroup:cvrdtl");
                GlobalCC.hidePopup("lmsgroup:p4");
            }

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return null;
    }

    public String AddQuotationCategory() {
        this.session.setAttribute("lcaCode", null);
        this.session.setAttribute("schCode", null);
        this.categID.setValue(null);
        this.categDescription.setValue(null);
        this.categoryPeriod.setValue(null);
        this.categoryFees.setValue(null);
        this.categoryStudents.setValue(null);

        ADFUtils.findIterator("findQuoteDependantLimitsIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.quotationDependentsLOV);

        this.session.setAttribute("categoryMaskCode",
                                  this.session.getAttribute("pmasCode"));
        this.catMaskDesc.setValue(this.session.getAttribute("pmasShtDesc"));
        return null;
    }

    public String EditDependantLimit() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findQuoteDependantLimitsIterator");
        RowKeySet set = this.quotationDependentsLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            this.session.setAttribute("qdlCode", r.getAttribute("QDL_CODE"));
            this.coverDescLabel.setValue(r.getAttribute("coverDescription"));
            this.dependentType.setValue(r.getAttribute("DTY_DESCRIPTION"));
            this.dpdLimitAmount.setValue(r.getAttribute("QDL_LIMIT_AMT"));
            this.dpdMinAmount.setValue(r.getAttribute("QDL_MIN_AMT"));
            this.maxType.setValue(r.getAttribute("QDL_MAX_TYPE_ALLOWED"));
            this.cvrDisp2.setValue(r.getAttribute("coverDescription"));
            this.session.setAttribute("qcvtCode",
                                      r.getAttribute("QDL_QCVT_CODE"));
            this.session.setAttribute("dtyCode",
                                      r.getAttribute("QDL_DTY_CODE"));
            this.session.setAttribute("qcvtcvtCode",
                                      r.getAttribute("QCVT_CVT_CODE"));
            ExtendedRenderKitService erkService =
                (ExtendedRenderKitService)Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                                             ExtendedRenderKitService.class);

            erkService.addScript(FacesContext.getCurrentInstance(),
                                 "var hints = {autodismissNever:false}; AdfPage.PAGE.findComponent('lmsgroup:depend2').show(hints);");
        }

        return null;
    }

    public void setEdCoverlabel(RichOutputText edCoverlabel) {
        this.edCoverlabel = edCoverlabel;
    }

    public RichOutputText getEdCoverlabel() {
        return this.edCoverlabel;
    }

    public void setEdcoverButChargePremium(RichInputText edcoverButChargePremium) {
        this.edcoverButChargePremium = edcoverButChargePremium;
    }

    public RichInputText getEdcoverButChargePremium() {
        return this.edcoverButChargePremium;
    }

    public void setEddiscLoadChoice(RichSelectOneChoice eddiscLoadChoice) {
        this.eddiscLoadChoice = eddiscLoadChoice;
    }

    public RichSelectOneChoice getEddiscLoadChoice() {
        return this.eddiscLoadChoice;
    }

    public void setEddiscLoadRateDisplay(RichInputText eddiscLoadRateDisplay) {
        this.eddiscLoadRateDisplay = eddiscLoadRateDisplay;
    }

    public RichInputText getEddiscLoadRateDisplay() {
        return this.eddiscLoadRateDisplay;
    }

    public void setEdtaxSel(RichOutputText edtaxSel) {
        this.edtaxSel = edtaxSel;
    }

    public RichOutputText getEdtaxSel() {
        return this.edtaxSel;
    }

    public void setEdapplLevel(RichSelectOneChoice edapplLevel) {
        this.edapplLevel = edapplLevel;
    }

    public RichSelectOneChoice getEdapplLevel() {
        return this.edapplLevel;
    }

    public void setEdtaxRate(RichInputText edtaxRate) {
        this.edtaxRate = edtaxRate;
    }

    public RichInputText getEdtaxRate() {
        return this.edtaxRate;
    }

    public void setEdtaxAmt(RichInputText edtaxAmt) {
        this.edtaxAmt = edtaxAmt;
    }

    public RichInputText getEdtaxAmt() {
        return this.edtaxAmt;
    }

    public void setCoverDescLabel(RichOutputText coverDescLabel) {
        this.coverDescLabel = coverDescLabel;
    }

    public RichOutputText getCoverDescLabel() {
        return this.coverDescLabel;
    }

    public void setDepTypesLabel(RichOutputText depTypesLabel) {
        this.depTypesLabel = depTypesLabel;
    }

    public RichOutputText getDepTypesLabel() {
        return this.depTypesLabel;
    }

    public void setEdLimitAmt(RichInputText edLimitAmt) {
        this.edLimitAmt = edLimitAmt;
    }

    public RichInputText getEdLimitAmt() {
        return this.edLimitAmt;
    }

    public void setEdMaxNo(RichInputText edMaxNo) {
        this.edMaxNo = edMaxNo;
    }

    public RichInputText getEdMaxNo() {
        return this.edMaxNo;
    }

    public void setCvrTypeLabel(RichOutputText cvrTypeLabel) {
        this.cvrTypeLabel = cvrTypeLabel;
    }

    public RichOutputText getCvrTypeLabel() {
        return this.cvrTypeLabel;
    }

    public void setCvrDisp2(RichOutputText cvrDisp2) {
        this.cvrDisp2 = cvrDisp2;
    }

    public RichOutputText getCvrDisp2() {
        return this.cvrDisp2;
    }

    public void setManipulationLOV(RichTable manipulationLOV) {
        this.manipulationLOV = manipulationLOV;
    }

    public RichTable getManipulationLOV() {
        return this.manipulationLOV;
    }

    public void setJointMemLOV(RichTable jointMemLOV) {
        this.jointMemLOV = jointMemLOV;
    }

    public RichTable getJointMemLOV() {
        return this.jointMemLOV;
    }

    public void setPensWEF(RichInputDate pensWEF) {
        this.pensWEF = pensWEF;
    }

    public RichInputDate getPensWEF() {
        return this.pensWEF;
    }

    public void setPensEarnings(RichInputText pensEarnings) {
        this.pensEarnings = pensEarnings;
    }

    public RichInputText getPensEarnings() {
        return this.pensEarnings;
    }

    public void setPensTotalContri(RichInputText pensTotalContri) {
        this.pensTotalContri = pensTotalContri;
    }

    public RichInputText getPensTotalContri() {
        return this.pensTotalContri;
    }

    public void setPensWET(RichInputDate pensWET) {
        this.pensWET = pensWET;
    }

    public RichInputDate getPensWET() {
        return this.pensWET;
    }

    public void setPensEmprContr(RichInputText pensEmprContr) {
        this.pensEmprContr = pensEmprContr;
    }

    public RichInputText getPensEmprContr() {
        return this.pensEmprContr;
    }

    public void setPensAnnFund(RichInputText pensAnnFund) {
        this.pensAnnFund = pensAnnFund;
    }

    public RichInputText getPensAnnFund() {
        return this.pensAnnFund;
    }

    public void setPensAdminFee(RichInputText pensAdminFee) {
        this.pensAdminFee = pensAdminFee;
    }

    public RichInputText getPensAdminFee() {
        return this.pensAdminFee;
    }

    public void setPensEmpeContri(RichInputText pensEmpeContri) {
        this.pensEmpeContri = pensEmpeContri;
    }

    public RichInputText getPensEmpeContri() {
        return this.pensEmpeContri;
    }

    public void setPensIntRate(RichInputText pensIntRate) {
        this.pensIntRate = pensIntRate;
    }

    public RichInputText getPensIntRate() {
        return this.pensIntRate;
    }

    public void setPensAnnFac(RichInputText pensAnnFac) {
        this.pensAnnFac = pensAnnFac;
    }

    public RichInputText getPensAnnFac() {
        return this.pensAnnFac;
    }

    public void setEmpeVolContr(RichInputText empeVolContr) {
        this.empeVolContr = empeVolContr;
    }

    public RichInputText getEmpeVolContr() {
        return this.empeVolContr;
    }

    public void setPensAnnum(RichInputText pensAnnum) {
        this.pensAnnum = pensAnnum;
    }

    public RichInputText getPensAnnum() {
        return this.pensAnnum;
    }

    public void setPensEMV(RichInputText pensEMV) {
        this.pensEMV = pensEMV;
    }

    public RichInputText getPensEMV() {
        return this.pensEMV;
    }

    public void setPensEmprEMV(RichInputText pensEmprEMV) {
        this.pensEmprEMV = pensEmprEMV;
    }

    public RichInputText getPensEmprEMV() {
        return this.pensEmprEMV;
    }

    public void setPensEmpeEMV(RichInputText pensEmpeEMV) {
        this.pensEmpeEMV = pensEmpeEMV;
    }

    public RichInputText getPensEmpeEMV() {
        return this.pensEmpeEMV;
    }

    public void setUnitRateOption(RichSelectOneChoice unitRateOption) {
        this.unitRateOption = unitRateOption;
    }

    public RichSelectOneChoice getUnitRateOption() {
        return this.unitRateOption;
    }

    public void setUsersLOV(RichTable usersLOV) {
        this.usersLOV = usersLOV;
    }

    public RichTable getUsersLOV() {
        return this.usersLOV;
    }

    public void setTicketRemarks(RichInputText ticketRemarks) {
        this.ticketRemarks = ticketRemarks;
    }

    public RichInputText getTicketRemarks() {
        return this.ticketRemarks;
    }

    public void setDepTypeLOV2(RichTable depTypeLOV2) {
        this.depTypeLOV2 = depTypeLOV2;
    }

    public RichTable getDepTypeLOV2() {
        return this.depTypeLOV2;
    }

    public void durationTypeListener(ValueChangeEvent valueChangeEvent) {
        try {
            if (this.quotationDurationType.getValue() != null) {
                if (this.quotationDurationType.getValue().toString().equalsIgnoreCase("C")) {
                    this.wetDate.setValue(null);

                    ExtendedRenderKitService erkService =
                        (ExtendedRenderKitService)Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                                                     ExtendedRenderKitService.class);

                    erkService.addScript(FacesContext.getCurrentInstance(),
                                         "var hints = {autodismissNever:false}; AdfPage.PAGE.findComponent('lmsgroup:duraPopup').show(hints);");
                } else {
                    saveDurationType(this.quotationDurationType.getValue().toString());
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
                "BEGIN LMS_WEB_PKG_GRP_UW.effect_quot_duration_change(?,?,?,?);END;";
            conn = new DBConnector().getDatabaseConn();
            CallableStatement cstmt = conn.prepareCall(deleteQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)this.session.getAttribute("QuoteCode"));
            if (DType.equalsIgnoreCase("C"))
                cstmt.setString(2,
                                GlobalCC.parseDate(this.wetDate.getValue().toString()));
            else {
                cstmt.setString(2, null);
            }
            cstmt.setString(3, DType);
            cstmt.registerOutParameter(4, 91);
            cstmt.execute();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);

            e.printStackTrace();
        }

        return null;
    }

    public String saveWETDate() {
        Connection conn = null;
        try {
            if (this.wetDate.getValue() == null) {
                String Message = "Select A WET Date";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));

                return null;
            }
            saveDurationType("C");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
            e.printStackTrace();
        }
        return null;
    }

    public String EditMemberDetailssel() {
        Connection conn = null;
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findQuoteMembersIterator");
            RowKeySet set = this.memberCoversLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                this.session.setAttribute("MemberNumber",
                                          r.getAttribute("QMEM_CODE"));
                this.memCoverDisplay.setValue(r.getAttribute("quoMemName"));
                this.memHeight.setValue(r.getAttribute("QMEM_HEIGHT"));
                this.memWeight.setValue(r.getAttribute("QMEM_WEIGHT"));
                this.memSysPr.setValue(r.getAttribute("QMEM_SYSTOLIC_PR"));
                this.memDiaPr.setValue(r.getAttribute("QMEM_DIASTOLIC_PR"));

                this.memLoadType.setValue(r.getAttribute("QMEM_LOADING_TYPE"));
                this.memloadRate.setValue(r.getAttribute("QMEM_LOADING_RATE"));
                this.memloadDivFac.setValue(r.getAttribute("QMEM_LOADING_DIV_FACT"));

                ExtendedRenderKitService erkService =
                    (ExtendedRenderKitService)Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                                                 ExtendedRenderKitService.class);

                erkService.addScript(FacesContext.getCurrentInstance(),
                                     "var hints = {autodismissNever:false}; AdfPage.PAGE.findComponent('lmsgroup:memotherdetails').show(hints);");
            }

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }

        return null;
    }

    public String saveMemberOtherDetails() {
        Connection conn = null;
        try {
            String deleteQuery =
                "BEGIN LMS_WEB_PKG_GRP_UW.update_quot_mem_dtls(?,?,?,?,?,?,?,?,?,?,?);END;";
            conn = new DBConnector().getDatabaseConn();
            CallableStatement cstmt = conn.prepareCall(deleteQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)this.session.getAttribute("MemberNumber"));
            if (this.memHeight.getValue() == null)
                cstmt.setString(2, null);
            else {
                cstmt.setString(2, this.memHeight.getValue().toString());
            }
            if (this.memWeight.getValue() == null)
                cstmt.setString(3, null);
            else {
                cstmt.setString(3, this.memWeight.getValue().toString());
            }
            if (this.memSysPr.getValue() == null)
                cstmt.setString(4, null);
            else {
                cstmt.setString(4, this.memSysPr.getValue().toString());
            }
            if (this.memDiaPr.getValue() == null)
                cstmt.setString(5, null);
            else {
                cstmt.setString(5, this.memDiaPr.getValue().toString());
            }
            cstmt.setString(6, null);
            cstmt.setString(7, null);
            if (this.memLoadType.getValue() == null)
                cstmt.setString(8, null);
            else {
                cstmt.setString(8, this.memLoadType.getValue().toString());
            }

            if (this.memloadRate.getValue() == null)
                cstmt.setString(9, null);
            else {
                cstmt.setString(9, this.memloadRate.getValue().toString());
            }

            if (this.memloadDivFac.getValue() == null)
                cstmt.setString(10, null);
            else {
                cstmt.setString(10, this.memloadDivFac.getValue().toString());
            }
            if (this.bmiRate.getValue() == null) {
                cstmt.setString(11, null);
            } else {
                cstmt.setString(11, this.bmiRate.getValue().toString());
            }

            cstmt.execute();
            conn.close();
            ADFUtils.findIterator("findQuoteMembersIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.memberCoversLOV);

            ADFUtils.findIterator("FindQuoteMemberCoversIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.memLimits);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }

        return null;
    }

    public String DeleteQuotMemberDetails() {
        BigDecimal qmemCode = null;
        BigDecimal dtyCode = null;
        String DeleteMemberQuery =
            "BEGIN LMS_WEB_PKG_GRP.delete_quot_member(?,?,?,?);END;";
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findQuoteMembersIterator");
        RowKeySet set = this.memberCoversLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        Connection conn = null;

        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            qmemCode = (BigDecimal)r.getAttribute("QMEM_MEM_CODE");
            dtyCode = (BigDecimal)r.getAttribute("QMEM_DTY_CODE");
        }

        conn = new DBConnector().getDatabaseConn();
        try {
            CallableStatement cstmt = conn.prepareCall(DeleteMemberQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)this.session.getAttribute("QuoteCode"));
            cstmt.setBigDecimal(2, qmemCode);
            System.out.println(qmemCode);
            cstmt.setString(3, "D");
            cstmt.setBigDecimal(4, dtyCode);
            System.out.println(dtyCode);
            cstmt.execute();
            conn.close();
            ADFUtils.findIterator("findQuoteMembersIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.memberCoversLOV);

            ADFUtils.findIterator("FindQuoteMemberCoversIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.memLimits);
            this.session.setAttribute("quoteMemMemCode", null);
            ADFUtils.findIterator("findMemberBeneficiariesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.memberBeneficiariesLOV);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public String EditMemberCoversSel() {
        Connection conn = null;
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("FindQuoteMemberCoversIterator");
            RowKeySet set = this.memLimits.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                this.session.setAttribute("memcoverID",
                                          r.getAttribute("QCM_CODE"));
                this.session.setAttribute("memCoverTypeCode",
                                          r.getAttribute("QCM_QCVT_CODE"));

                this.memCoverTypeDisplay.setValue(r.getAttribute("cover_display"));
                this.memEarningAmt.setValue(r.getAttribute("QCM_EARNINGS"));
                this.memEarningPeriod.setValue(r.getAttribute("QCM_MULT_EARNINGS_PRD"));

                ExtendedRenderKitService erkService =
                    (ExtendedRenderKitService)Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                                                 ExtendedRenderKitService.class);

                erkService.addScript(FacesContext.getCurrentInstance(),
                                     "var hints = {autodismissNever:false}; AdfPage.PAGE.findComponent('lmsgroup:coverdtlsPopups').show(hints);");
            }

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }

        return null;
    }

    public String UpdateMemberCoverDetails() {
        Connection conn = null;
        try {
            String deleteQuery =
                "BEGIN LMS_WEB_PKG_GRP_UW.update_member_quot_pol_covers(?,?,?,?,?,?,?,?,?,?,?);END;";
            conn = new DBConnector().getDatabaseConn();
            CallableStatement cstmt = conn.prepareCall(deleteQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)this.session.getAttribute("memcoverID"));
            cstmt.setString(2, "Q");
            if (this.memEarningAmt.getValue() == null)
                cstmt.setString(3, null);
            else {
                cstmt.setString(3, this.memEarningAmt.getValue().toString());
            }
            if (this.memEarningPeriod.getValue() == null)
                cstmt.setString(4, null);
            else {
                cstmt.setString(4,
                                this.memEarningPeriod.getValue().toString());
            }
            cstmt.setString(5, null);
            cstmt.setString(6, null);
            cstmt.setString(7, null);
            cstmt.setString(8, null);
            cstmt.setString(9, null);
            cstmt.setBigDecimal(10,
                                (BigDecimal)this.session.getAttribute("QuoteCode"));
            cstmt.setBigDecimal(11,
                                (BigDecimal)this.session.getAttribute("memCoverTypeCode"));

            cstmt.execute();
            conn.close();
            ADFUtils.findIterator("FindQuoteMemberCoversIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.memLimits);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }

        return null;
    }

    public void setWetDate(RichInputDate wetDate) {
        this.wetDate = wetDate;
    }

    public RichInputDate getWetDate() {
        return this.wetDate;
    }

    public void setMemCoverDisplay(RichOutputText memCoverDisplay) {
        this.memCoverDisplay = memCoverDisplay;
    }

    public RichOutputText getMemCoverDisplay() {
        return this.memCoverDisplay;
    }

    public void setMemHeight(RichInputText memHeight) {
        this.memHeight = memHeight;
    }

    public RichInputText getMemHeight() {
        return this.memHeight;
    }

    public void setMemWeight(RichInputText memWeight) {
        this.memWeight = memWeight;
    }

    public RichInputText getMemWeight() {
        return this.memWeight;
    }

    public void setMemSysPr(RichInputText memSysPr) {
        this.memSysPr = memSysPr;
    }

    public RichInputText getMemSysPr() {
        return this.memSysPr;
    }

    public void setMemDiaPr(RichInputText memDiaPr) {
        this.memDiaPr = memDiaPr;
    }

    public RichInputText getMemDiaPr() {
        return this.memDiaPr;
    }

    public void setWeightlding(RichInputText weightlding) {
        this.weightlding = weightlding;
    }

    public RichInputText getWeightlding() {
        return this.weightlding;
    }

    public void setMemBPressLoading(RichInputText memBPressLoading) {
        this.memBPressLoading = memBPressLoading;
    }

    public RichInputText getMemBPressLoading() {
        return this.memBPressLoading;
    }

    public void setMemLoadType(RichSelectOneChoice memLoadType) {
        this.memLoadType = memLoadType;
    }

    public RichSelectOneChoice getMemLoadType() {
        return this.memLoadType;
    }

    public void setMemloadDivFac(RichInputText memloadDivFac) {
        this.memloadDivFac = memloadDivFac;
    }

    public RichInputText getMemloadDivFac() {
        return this.memloadDivFac;
    }

    public void setMemloadRate(RichInputText memloadRate) {
        this.memloadRate = memloadRate;
    }

    public RichInputText getMemloadRate() {
        return this.memloadRate;
    }

    public void setMemEarningAmt(RichInputText memEarningAmt) {
        this.memEarningAmt = memEarningAmt;
    }

    public RichInputText getMemEarningAmt() {
        return this.memEarningAmt;
    }

    public void setMemCoverTypeDisplay(RichOutputText memCoverTypeDisplay) {
        this.memCoverTypeDisplay = memCoverTypeDisplay;
    }

    public RichOutputText getMemCoverTypeDisplay() {
        return this.memCoverTypeDisplay;
    }

    public void setMemEarningPeriod(RichInputText memEarningPeriod) {
        this.memEarningPeriod = memEarningPeriod;
    }

    public RichInputText getMemEarningPeriod() {
        return this.memEarningPeriod;
    }

    public void setMemOrigLnAmt(RichInputText memOrigLnAmt) {
        this.memOrigLnAmt = memOrigLnAmt;
    }

    public RichInputText getMemOrigLnAmt() {
        return this.memOrigLnAmt;
    }

    public void setMemLoanAmt(RichInputText memLoanAmt) {
        this.memLoanAmt = memLoanAmt;
    }

    public RichInputText getMemLoanAmt() {
        return this.memLoanAmt;
    }

    public void setMemLoanInt(RichInputText memLoanInt) {
        this.memLoanInt = memLoanInt;
    }

    public RichInputText getMemLoanInt() {
        return this.memLoanInt;
    }

    public void setMemLoanIssDate(RichInputDate memLoanIssDate) {
        this.memLoanIssDate = memLoanIssDate;
    }

    public RichInputDate getMemLoanIssDate() {
        return this.memLoanIssDate;
    }

    public void setMemSavingAmt(RichInputText memSavingAmt) {
        this.memSavingAmt = memSavingAmt;
    }

    public RichInputText getMemSavingAmt() {
        return this.memSavingAmt;
    }

    public void setDepTypeLabel(RichOutputLabel depTypeLabel) {
        this.depTypeLabel = depTypeLabel;
    }

    public RichOutputLabel getDepTypeLabel() {
        return this.depTypeLabel;
    }

    public void setDepTypeDtls(HtmlPanelGrid depTypeDtls) {
        this.depTypeDtls = depTypeDtls;
    }

    public HtmlPanelGrid getDepTypeDtls() {
        return this.depTypeDtls;
    }

    public void setAllDepsLOV(RichTable allDepsLOV) {
        this.allDepsLOV = allDepsLOV;
    }

    public RichTable getAllDepsLOV() {
        return this.allDepsLOV;
    }

    public void setDtyDesc(RichInputText dtyDesc) {
        this.dtyDesc = dtyDesc;
    }

    public RichInputText getDtyDesc() {
        return this.dtyDesc;
    }

    public void setAvMemEarnlabel(RichOutputLabel avMemEarnlabel) {
        this.avMemEarnlabel = avMemEarnlabel;
    }

    public RichOutputLabel getAvMemEarnlabel() {
        return this.avMemEarnlabel;
    }

    public void setTotalMem(RichInputText totalMem) {
        this.totalMem = totalMem;
    }

    public RichInputText getTotalMem() {
        return this.totalMem;
    }

    public void setCvrMultipleEarningsPeriod(RichInputText cvrMultipleEarningsPeriod) {
        this.cvrMultipleEarningsPeriod = cvrMultipleEarningsPeriod;
    }

    public RichInputText getCvrMultipleEarningsPeriod() {
        return this.cvrMultipleEarningsPeriod;
    }

    public void setCvrCategory(RichInputText cvrCategory) {
        this.cvrCategory = cvrCategory;
    }

    public RichInputText getCvrCategory() {
        return this.cvrCategory;
    }

    public void setTotalMemLabel(RichOutputLabel totalMemLabel) {
        this.totalMemLabel = totalMemLabel;
    }

    public RichOutputLabel getTotalMemLabel() {
        return this.totalMemLabel;
    }

    public void setMultiEarnsPeriodlbl(RichOutputLabel multiEarnsPeriodlbl) {
        this.multiEarnsPeriodlbl = multiEarnsPeriodlbl;
    }

    public RichOutputLabel getMultiEarnsPeriodlbl() {
        return this.multiEarnsPeriodlbl;
    }

    public void setCvrCategorylabel(RichOutputLabel cvrCategorylabel) {
        this.cvrCategorylabel = cvrCategorylabel;
    }

    public RichOutputLabel getCvrCategorylabel() {
        return this.cvrCategorylabel;
    }

    public void myCategorylistener(SelectionEvent selectionEvent) {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findQuoteCategoriesIterator");
        RowKeySet set = this.quotCategoriesLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
            this.session.setAttribute("lcaCode", r.getAttribute("lcaCode"));
        }
    }

    public void CategoryTreeListener(SelectionEvent selectionEvent) {
        Iterator i$;
        if (selectionEvent.getAddedSet() != selectionEvent.getRemovedSet()) {
            RowKeySet keys = selectionEvent.getAddedSet();
            if ((keys != null) && (keys.getSize() > 0))
                for (i$ = keys.iterator(); i$.hasNext(); ) {
                    Object treeRowKey = i$.next();
                    this.categoryTree.setRowKey(treeRowKey);
                    JUCtrlHierNodeBinding nd =
                        (JUCtrlHierNodeBinding)this.categoryTree.getRowData();

                    this.session.setAttribute("lcaCode",
                                              nd.getRow().getAttribute("lcaCode"));
                    this.session.setAttribute("schCode",
                                              nd.getRow().getAttribute("SCH_CODE"));
                    this.categID.setValue(nd.getRow().getAttribute("catShtDesc"));
                    this.categDescription.setValue(nd.getRow().getAttribute("catDesc"));
                    this.categoryPeriod.setValue(nd.getRow().getAttribute("catPeriod"));
                    this.categoryFees.setValue(nd.getRow().getAttribute("CTL_FEE_AMOUNT"));
                    this.categoryStudents.setValue(nd.getRow().getAttribute("CTL_AV_STUDENTS"));

                    this.session.setAttribute("categoryMaskCode",
                                              nd.getRow().getAttribute("lca_pmas_code"));
                    this.catMaskDesc.setValue(nd.getRow().getAttribute("pmas_sht_desc"));

                    ADFUtils.findIterator("findQuoteDependantLimitsIterator").executeQuery();
                    AdfFacesContext.getCurrentInstance().addPartialTarget(this.quotationDependentsLOV);
                }
        }
    }

    public void setDivFactor(RichInputText divFactor) {
        this.divFactor = divFactor;
    }

    public RichInputText getDivFactor() {
        return this.divFactor;
    }

    public void setPensAverageANB(RichInputText pensAverageANB) {
        this.pensAverageANB = pensAverageANB;
    }

    public RichInputText getPensAverageANB() {
        return this.pensAverageANB;
    }

    public void setPensAverageEarnings(RichInputText pensAverageEarnings) {
        this.pensAverageEarnings = pensAverageEarnings;
    }

    public RichInputText getPensAverageEarnings() {
        return this.pensAverageEarnings;
    }

    public void setAnnEscalation(RichSelectOneChoice annEscalation) {
        this.annEscalation = annEscalation;
    }

    public RichSelectOneChoice getAnnEscalation() {
        return this.annEscalation;
    }

    public void setAnnPaymentStructure(RichSelectManyChoice annPaymentStructure) {
        this.annPaymentStructure = annPaymentStructure;
    }

    public RichSelectManyChoice getAnnPaymentStructure() {
        return this.annPaymentStructure;
    }

    public void setAnnuityOption(RichSelectOneChoice annuityOption) {
        this.annuityOption = annuityOption;
    }

    public RichSelectOneChoice getAnnuityOption() {
        return this.annuityOption;
    }

    public void setAnnPymtStructure(RichSelectOneChoice annPymtStructure) {
        this.annPymtStructure = annPymtStructure;
    }

    public RichSelectOneChoice getAnnPymtStructure() {
        return this.annPymtStructure;
    }

    public void setDurationTermType(RichSelectOneChoice durationTermType) {
        this.durationTermType = durationTermType;
    }

    public RichSelectOneChoice getDurationTermType() {
        return this.durationTermType;
    }

    public void setSchoolFeesTab(RichPanelBox schoolFeesTab) {
        this.schoolFeesTab = schoolFeesTab;
    }

    public RichPanelBox getSchoolFeesTab() {
        return this.schoolFeesTab;
    }

    public void setClassTermDisplay(RichInputText classTermDisplay) {
        this.classTermDisplay = classTermDisplay;
    }

    public RichInputText getClassTermDisplay() {
        return this.classTermDisplay;
    }

    public void setClassesCategoriesLOV(RichTable classesCategoriesLOV) {
        this.classesCategoriesLOV = classesCategoriesLOV;
    }

    public RichTable getClassesCategoriesLOV() {
        return this.classesCategoriesLOV;
    }

    public String AssignClassesCategories() {
        RowKeySet rowKeySet = this.classesCategoriesLOV.getSelectedRowKeys();
        if (!rowKeySet.iterator().hasNext()) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
        }

        Object key2 = rowKeySet.iterator().next();
        this.classesCategoriesLOV.setRowKey(key2);

        JUCtrlValueBinding r =
            (JUCtrlValueBinding)this.classesCategoriesLOV.getRowData();

        if (r == null) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
        }
        this.classTermDisplay.setValue(r.getAttribute("catDesc"));

        this.session.setAttribute("CTL_QUO_LCA_CODE",
                                  r.getAttribute("lcaCode"));

        ExtendedRenderKitService erkService =
            (ExtendedRenderKitService)Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                                         ExtendedRenderKitService.class);

        erkService.addScript(FacesContext.getCurrentInstance(),
                             "var hints = {autodismissNever:false}; AdfPage.PAGE.findComponent('lmsgroup:addClassesPopup').show(hints);");

        return null;
    }

    public void setTermFeeDisplay(RichInputText termFeeDisplay) {
        this.termFeeDisplay = termFeeDisplay;
    }

    public RichInputText getTermFeeDisplay() {
        return this.termFeeDisplay;
    }

    public String ShowAddCategories() {
        this.session.setAttribute("CTL_CODE", null);
        this.session.setAttribute("CTL_QUO_LCA_CODE", null);

        this.classTermDisplay.setValue(null);
        this.termFeeDisplay.setValue(null);
        ExtendedRenderKitService erkService =
            (ExtendedRenderKitService)Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                                         ExtendedRenderKitService.class);

        erkService.addScript(FacesContext.getCurrentInstance(),
                             "var hints = {autodismissNever:false}; AdfPage.PAGE.findComponent('lmsgroup:addClassesPopup').show(hints);");

        return null;
    }

    public String DeleteCategoryClasses() {
        RowKeySet rowKeySet = this.classTermLimitsLOV.getSelectedRowKeys();
        if (!rowKeySet.iterator().hasNext()) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
        }

        Object key2 = rowKeySet.iterator().next();
        this.classTermLimitsLOV.setRowKey(key2);

        JUCtrlValueBinding r =
            (JUCtrlValueBinding)this.classTermLimitsLOV.getRowData();

        if (r == null) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
        }

        this.session.setAttribute("CTL_CODE", r.getAttribute("ctlCode"));

        String authQuery =
            "BEGIN LMS_WEB_PKG_GRP.deleteClasstermLimits(?,?);END;";
        Connection conn = new DBConnector().getDatabaseConn();
        try {
            CallableStatement cstmt = conn.prepareCall(authQuery);

            cstmt.setBigDecimal(1,
                                (BigDecimal)this.session.getAttribute("CTL_CODE"));
            cstmt.setString(2, "Q");
            cstmt.execute();
            conn.close();
            String Message = "Record deleted successfully.";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));

            this.session.setAttribute("CTL_CODE", null);
            this.session.setAttribute("CTL_QUO_LCA_CODE", null);

            ADFUtils.findIterator("findClassTermLimitsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.classTermLimitsLOV);
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        }
        return null;
    }

    public String EditCategoryClasses() {
        RowKeySet rowKeySet = this.classTermLimitsLOV.getSelectedRowKeys();
        if (!rowKeySet.iterator().hasNext()) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
        }

        Object key2 = rowKeySet.iterator().next();
        this.classTermLimitsLOV.setRowKey(key2);

        JUCtrlValueBinding r =
            (JUCtrlValueBinding)this.classTermLimitsLOV.getRowData();

        if (r == null) {
            GlobalCC.errorValueNotEntered("Error: No Record Selected");
        }

        this.session.setAttribute("CTL_CODE", r.getAttribute("ctlCode"));

        this.termFeeDisplay.setValue(r.getAttribute("ctlFee"));
        this.classTermDisplay.setValue(r.getAttribute("categDesc"));
        ExtendedRenderKitService erkService =
            (ExtendedRenderKitService)Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                                         ExtendedRenderKitService.class);

        erkService.addScript(FacesContext.getCurrentInstance(),
                             "var hints = {autodismissNever:false}; AdfPage.PAGE.findComponent('lmsgroup:addClassesPopup').show(hints);");

        return null;
    }

    public void setClassTermLimitsLOV(RichTable classTermLimitsLOV) {
        this.classTermLimitsLOV = classTermLimitsLOV;
    }

    public RichTable getClassTermLimitsLOV() {
        return this.classTermLimitsLOV;
    }

    public String SaveClassTermLimits() {
        String updateQuery =
            "BEGIN LMS_WEB_PKG_GRP.updateClassTermLimits(?,?,?,?,?);END;";
        Connection conn = null;
        try {
            conn = new DBConnector().getDatabaseConn();
            CallableStatement cstmt = conn.prepareCall(updateQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)this.session.getAttribute("CTL_CODE"));
            cstmt.setBigDecimal(2,
                                (BigDecimal)this.session.getAttribute("QuoteCode"));
            cstmt.setBigDecimal(3,
                                (BigDecimal)this.session.getAttribute("CTL_QUO_LCA_CODE"));
            cstmt.setString(4, this.termFeeDisplay.getValue().toString());
            cstmt.setString(5, "Q");

            cstmt.execute();
            conn.close();

            GlobalCC.INFORMATIONREPORTING("Record saved Successfully.");

            this.session.setAttribute("CTL_CODE", null);
            this.session.setAttribute("CTL_QUO_LCA_CODE", null);

            ADFUtils.findIterator("findClassTermLimitsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.classTermLimitsLOV);
            GlobalCC.hidePopup("lmsgroup:addClassesPopup");
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        }
        return null;
    }

    public void setMemberBeneficiariesLOV(RichTable memberBeneficiariesLOV) {
        this.memberBeneficiariesLOV = memberBeneficiariesLOV;
    }

    public RichTable getMemberBeneficiariesLOV() {
        return this.memberBeneficiariesLOV;
    }

    public void setPastLiability(RichInputText pastLiability) {
        this.pastLiability = pastLiability;
    }

    public RichInputText getPastLiability() {
        return this.pastLiability;
    }

    public void setFutureLiability(RichInputText futureLiability) {
        this.futureLiability = futureLiability;
    }

    public RichInputText getFutureLiability() {
        return this.futureLiability;
    }

    public void setTotalLiability(RichInputText totalLiability) {
        this.totalLiability = totalLiability;
    }

    public RichInputText getTotalLiability() {
        return this.totalLiability;
    }

    public void setAnnuityAmount(RichInputText annuityAmount) {
        this.annuityAmount = annuityAmount;
    }

    public RichInputText getAnnuityAmount() {
        return this.annuityAmount;
    }

    public void unitRateListener(ValueChangeEvent valueChangeEvent) {
        if ((this.unitRateOption.getValue() != null) &&
            (this.unitRateOption.getValue().toString().equalsIgnoreCase("RATE"))) {
            this.unitRateDisplay.setValue(null);
            this.unitRateDivFactor.setValue(null);
            ExtendedRenderKitService erkService =
                (ExtendedRenderKitService)Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                                             ExtendedRenderKitService.class);

            erkService.addScript(FacesContext.getCurrentInstance(),
                                 "var hints = {autodismissNever:false}; AdfPage.PAGE.findComponent('lmsgroup:othersUnitRatePopup').show(hints);");
        }
    }

    public void setUnitRateDisplay(RichInputText unitRateDisplay) {
        this.unitRateDisplay = unitRateDisplay;
    }

    public RichInputText getUnitRateDisplay() {
        return this.unitRateDisplay;
    }

    public void setUnitRateDivFactor(RichSelectOneChoice unitRateDivFactor) {
        this.unitRateDivFactor = unitRateDivFactor;
    }

    public RichSelectOneChoice getUnitRateDivFactor() {
        return this.unitRateDivFactor;
    }

    public String AddStudent() {
        this.studentNames.setValue(null);
        this.studentSurname.setValue(null);
        this.studentMemNo.setValue(null);
        this.studentDOB.setValue(null);
        this.studentClass.setValue(null);
        this.studentSex.setValue(null);
        this.session.setAttribute("action", "A");
        GlobalCC.showPopup("lmsgroup:studentDetails");
        return null;
    }

    public String EditStudent() {
        try {
            RowKeySet rowKeySet =
                this.memberBeneficiariesLOV.getSelectedRowKeys();
            if (rowKeySet == null) {
                return null;
            }
            if (!rowKeySet.iterator().hasNext()) {
                GlobalCC.errorValueNotEntered("No Record Selected");
                return null;
            }
            Object key2 = rowKeySet.iterator().next();
            this.memberBeneficiariesLOV.setRowKey(key2);
            JUCtrlValueBinding nodeBinding =
                (JUCtrlValueBinding)this.memberBeneficiariesLOV.getRowData();

            if (nodeBinding == null) {
                GlobalCC.errorValueNotEntered("No Record Selected");
                return null;
            }

            GlobalCC.showPopup("lmsgroup:studentDetails");
            this.session.setAttribute("action", "E");

            this.session.setAttribute("studentBenCode",
                                      nodeBinding.getAttribute("qmemBenCode"));

            this.studentNames.setValue(nodeBinding.getAttribute("qmemBenOtherNames"));
            this.studentSurname.setValue(nodeBinding.getAttribute("qmemBenSurname"));
            this.studentMemNo.setValue(nodeBinding.getAttribute("qmemBenMemNo"));
            this.studentClass.setValue(nodeBinding.getAttribute("qmemBenClass"));
            this.studentSex.setValue(nodeBinding.getAttribute("qmem_ben_sex"));
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String SaveStudent() {
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
                "begin LMS_WEB_PKG_GRP_UW.save_quote_student_dtls(?,?,?,?,?,?,?,?,?); end;";

            cst = conn.prepareCall(reinQuery);
            cst.setString(1, (String)this.session.getAttribute("action"));
            cst.setBigDecimal(2,
                              (BigDecimal)this.session.getAttribute("studentBenCode"));
            cst.setBigDecimal(3,
                              (BigDecimal)this.session.getAttribute("MemberNumber"));
            if (this.studentSurname.getValue() == null)
                cst.setString(4, null);
            else {
                cst.setString(4, this.studentSurname.getValue().toString());
            }
            if (this.studentNames.getValue() == null)
                cst.setString(5, null);
            else {
                cst.setString(5, this.studentNames.getValue().toString());
            }
            cst.setBigDecimal(6,
                              (BigDecimal)this.session.getAttribute("QuoteCode"));
            if (this.studentSex.getValue() == null)
                cst.setString(7, null);
            else {
                cst.setString(7, this.studentSex.getValue().toString());
            }
            if (this.studentMemNo.getValue() == null)
                cst.setString(8, null);
            else {
                cst.setString(8, this.studentMemNo.getValue().toString());
            }
            cst.setString(9,
                          (String)this.session.getAttribute("QuoteCategoryShtDesc"));

            cst.execute();
            cst.close();
            conn.commit();
            conn.close();

            GlobalCC.sysInformation("Record Successfully Saved");
            GlobalCC.hidePopup("lmsgroup:studentDetails");

            ADFUtils.findIterator("findMemberBeneficiariesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.memberBeneficiariesLOV);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }

        return null;
    }

    public String DeleteStudent() {
        Connection conn = null;
        try {
            RowKeySet rowKeySet =
                this.memberBeneficiariesLOV.getSelectedRowKeys();
            if (rowKeySet == null) {
                return null;
            }
            if (!rowKeySet.iterator().hasNext()) {
                GlobalCC.errorValueNotEntered("No Record Selected");
                return null;
            }
            Object key2 = rowKeySet.iterator().next();
            this.memberBeneficiariesLOV.setRowKey(key2);
            JUCtrlValueBinding r =
                (JUCtrlValueBinding)this.memberBeneficiariesLOV.getRowData();

            if (r == null) {
                GlobalCC.errorValueNotEntered("No Record Selected");
                return null;
            }
            this.session.setAttribute("action", "D");
            DBConnector datahandler = null;
            datahandler = new DBConnector();

            conn = datahandler.getDatabaseConn();
            CallableStatement cst = null;

            String reinQuery =
                "begin LMS_WEB_PKG_GRP_UW.save_quote_student_dtls(?,?,?,?,?,?,?,?,?); end;";

            cst = conn.prepareCall(reinQuery);
            cst.setString(1, (String)this.session.getAttribute("action"));
            cst.setBigDecimal(2, (BigDecimal)r.getAttribute("qmemBenCode"));
            cst.setBigDecimal(3,
                              (BigDecimal)this.session.getAttribute("MemberNumber"));
            if (this.studentSurname.getValue() == null)
                cst.setString(4, null);
            else {
                cst.setString(4, this.studentSurname.getValue().toString());
            }
            if (this.studentNames.getValue() == null)
                cst.setString(5, null);
            else {
                cst.setString(5, this.studentNames.getValue().toString());
            }
            cst.setBigDecimal(6,
                              (BigDecimal)this.session.getAttribute("QuoteCode"));
            if (this.studentSex.getValue() == null)
                cst.setString(7, null);
            else {
                cst.setString(7, this.studentSex.getValue().toString());
            }
            if (this.studentMemNo.getValue() == null)
                cst.setString(8, null);
            else {
                cst.setString(8, this.studentMemNo.getValue().toString());
            }
            cst.setString(9,
                          (String)this.session.getAttribute("QuoteCategoryShtDesc"));

            cst.execute();
            cst.close();
            conn.commit();
            conn.close();

            ADFUtils.findIterator("findMemberBeneficiariesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.memberBeneficiariesLOV);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public String SaveUnitRate() {
        Connection conn = null;
        try {
            if (this.unitRateDisplay.getValue() == null) {
                String Message = "Please Key In a unit Rate";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));

                return null;
            }
            if (this.unitRateDivFactor.getValue() == null) {
                String Message = "Please select  a unit Rate division factor";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));

                return null;
            }
            String updateQuery =
                "BEGIN LMS_GRP_WEB_PKG.updateUnitRate(?,?,?,?);END;";
            try {
                conn = new DBConnector().getDatabaseConn();
                CallableStatement cstmt = conn.prepareCall(updateQuery);
                cstmt.setString(1, this.unitRateDisplay.getValue().toString());
                cstmt.setBigDecimal(2,
                                    (BigDecimal)this.session.getAttribute("QuoteCode"));
                cstmt.setString(3,
                                this.unitRateDivFactor.getValue().toString());
                cstmt.setString(4, new String("Q"));

                cstmt.execute();
                conn.close();

                String Message = "Record saved Successfully.";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));
            } catch (Exception ex) {
                GlobalCC.EXCEPTIONREPORTING(conn, ex);
            }
            return null;
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public void setCategoryTree(RichTree categoryTree) {
        this.categoryTree = categoryTree;
    }

    public RichTree getCategoryTree() {
        return this.categoryTree;
    }

    public void setClassesLOV(RichTable classesLOV) {
        this.classesLOV = classesLOV;
    }

    public RichTable getClassesLOV() {
        return this.classesLOV;
    }

    public void setStudentNames(RichInputText studentNames) {
        this.studentNames = studentNames;
    }

    public RichInputText getStudentNames() {
        return this.studentNames;
    }

    public void setStudentSurname(RichInputText studentSurname) {
        this.studentSurname = studentSurname;
    }

    public RichInputText getStudentSurname() {
        return this.studentSurname;
    }

    public void setStudentMemNo(RichInputText studentMemNo) {
        this.studentMemNo = studentMemNo;
    }

    public RichInputText getStudentMemNo() {
        return this.studentMemNo;
    }

    public void setStudentDOB(RichInputDate studentDOB) {
        this.studentDOB = studentDOB;
    }

    public RichInputDate getStudentDOB() {
        return this.studentDOB;
    }

    public void setStudentClass(RichSelectOneChoice studentClass) {
        this.studentClass = studentClass;
    }

    public RichSelectOneChoice getStudentClass() {
        return this.studentClass;
    }

    public void setStudentSex(RichSelectOneChoice studentSex) {
        this.studentSex = studentSex;
    }

    public RichSelectOneChoice getStudentSex() {
        return this.studentSex;
    }

    public void setBenInvestRate(RichInputText benInvestRate) {
        this.benInvestRate = benInvestRate;
    }

    public RichInputText getBenInvestRate() {
        return this.benInvestRate;
    }

    public void setTermPayoutRate(RichInputText termPayoutRate) {
        this.termPayoutRate = termPayoutRate;
    }

    public RichInputText getTermPayoutRate() {
        return this.termPayoutRate;
    }

    public void setAnnInterestRate(RichInputText annInterestRate) {
        this.annInterestRate = annInterestRate;
    }

    public RichInputText getAnnInterestRate() {
        return this.annInterestRate;
    }

    public void setAnnAdminCharge(RichInputText annAdminCharge) {
        this.annAdminCharge = annAdminCharge;
    }

    public RichInputText getAnnAdminCharge() {
        return this.annAdminCharge;
    }

    public void setSchemeLegalAge(RichInputText schemeLegalAge) {
        this.schemeLegalAge = schemeLegalAge;
    }

    public RichInputText getSchemeLegalAge() {
        return this.schemeLegalAge;
    }

    public void setAnndependentsLOV(RichTable anndependentsLOV) {
        this.anndependentsLOV = anndependentsLOV;
    }

    public RichTable getAnndependentsLOV() {
        return this.anndependentsLOV;
    }

    public void setTotAnnInvestment(RichInputText totAnnInvestment) {
        this.totAnnInvestment = totAnnInvestment;
    }

    public RichInputText getTotAnnInvestment() {
        return this.totAnnInvestment;
    }

    public void setTotTerminalBenefits(RichInputText totTerminalBenefits) {
        this.totTerminalBenefits = totTerminalBenefits;
    }

    public RichInputText getTotTerminalBenefits() {
        return this.totTerminalBenefits;
    }

    public void setSchLegalAge(RichInputText schLegalAge) {
        this.schLegalAge = schLegalAge;
    }

    public RichInputText getSchLegalAge() {
        return this.schLegalAge;
    }

    public void setSchAdminCharge(RichInputText schAdminCharge) {
        this.schAdminCharge = schAdminCharge;
    }

    public RichInputText getSchAdminCharge() {
        return this.schAdminCharge;
    }

    public void setAnnuityIntrRate(RichInputText annuityIntrRate) {
        this.annuityIntrRate = annuityIntrRate;
    }

    public RichInputText getAnnuityIntrRate() {
        return this.annuityIntrRate;
    }

    public void setAnnInvestRate(RichInputText annInvestRate) {
        this.annInvestRate = annInvestRate;
    }

    public RichInputText getAnnInvestRate() {
        return this.annInvestRate;
    }

    public void setTerminalPayoutRate(RichInputText terminalPayoutRate) {
        this.terminalPayoutRate = terminalPayoutRate;
    }

    public RichInputText getTerminalPayoutRate() {
        return this.terminalPayoutRate;
    }

    public void setMainCoverLabel(RichOutputLabel mainCoverLabel) {
        this.mainCoverLabel = mainCoverLabel;
    }

    public RichOutputLabel getMainCoverLabel() {
        return this.mainCoverLabel;
    }

    public void setMainCover(RichSelectOneChoice mainCover) {
        this.mainCover = mainCover;
    }

    public RichSelectOneChoice getMainCover() {
        return this.mainCover;
    }

    public void setPercMainCvtLabel(RichOutputLabel percMainCvtLabel) {
        this.percMainCvtLabel = percMainCvtLabel;
    }

    public RichOutputLabel getPercMainCvtLabel() {
        return this.percMainCvtLabel;
    }

    public void setPercMainCvt(RichInputText percMainCvt) {
        this.percMainCvt = percMainCvt;
    }

    public RichInputText getPercMainCvt() {
        return this.percMainCvt;
    }

    public void GetUmbrellaDurationType(ValueChangeEvent valueChangeEvent) {
        if ((valueChangeEvent.getOldValue() !=
             valueChangeEvent.getNewValue()) &&
            (this.umbrellaDurationType.getValue() != null)) {
            this.session.setAttribute("umbrellaDurationType",
                                      this.umbrellaDurationType.getValue().toString());
        }
    }

    public void GetDurationType(ValueChangeEvent valueChangeEvent) {
        String Duration = null;
        if (this.quotationDurationType.getValue() == null) {
            this.session.setAttribute("policyDurationType", null);
        } else {
            this.session.setAttribute("policyDurationType",
                                      this.quotationDurationType.getValue().toString());

            String Type2 = (String)this.session.getAttribute("productType");
            if ((Type2 != null) && (Type2.equalsIgnoreCase("EDUC"))) {
                if (this.quotationDurationType.getValue().toString().equalsIgnoreCase("A")) {
                    this.durationTermType.setValue("ALL");
                    this.durationTermType.setDisabled(true);
                } else {
                    this.durationTermType.setValue(null);
                    this.durationTermType.setDisabled(false);
                }

            }

        }

        if (this.quotationDurationType.getValue().toString().equalsIgnoreCase("C")) {
            this.weTLabel.setRendered(true);
            this.wetDate.setRendered(true);
            this.wetDate.setValue(null);
        } else {
            this.weTLabel.setRendered(false);
            this.wetDate.setRendered(false);
            this.session.setAttribute("newWETDate", null);
            this.wetDate.setValue(null);
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.weTLabel);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.wetDate);
    }

    public void newWETListener(ValueChangeEvent valueChangeEvent) {
        if (valueChangeEvent.getNewValue() != valueChangeEvent.getOldValue())
            if (this.wetDate.getValue() == null)
                this.session.setAttribute("newWETDate", null);
            else
                this.session.setAttribute("newWETDate",
                                          GlobalCC.parseDate(this.wetDate.getValue().toString()));
    }

    public void setProductCoverDropBox(RichSelectOneChoice productCoverDropBox) {
        this.productCoverDropBox = productCoverDropBox;
    }

    public RichSelectOneChoice getProductCoverDropBox() {
        return this.productCoverDropBox;
    }

    public void setPrdTypeLabel(RichOutputLabel prdTypeLabel) {
        this.prdTypeLabel = prdTypeLabel;
    }

    public RichOutputLabel getPrdTypeLabel() {
        return this.prdTypeLabel;
    }

    public void setDpdCoverType(RichSelectOneChoice dpdCoverType) {
        this.dpdCoverType = dpdCoverType;
    }

    public RichSelectOneChoice getDpdCoverType() {
        return this.dpdCoverType;
    }

    public void setDependentTypeDisplay(RichSelectOneChoice dependentTypeDisplay) {
        this.dependentTypeDisplay = dependentTypeDisplay;
    }

    public RichSelectOneChoice getDependentTypeDisplay() {
        return this.dependentTypeDisplay;
    }

    public void setCoinLeadFollowLabel(RichOutputLabel coinLeadFollowLabel) {
        this.coinLeadFollowLabel = coinLeadFollowLabel;
    }

    public RichOutputLabel getCoinLeadFollowLabel() {
        return this.coinLeadFollowLabel;
    }

    public void setCoinLeadFollowSelect(RichSelectOneChoice coinLeadFollowSelect) {
        this.coinLeadFollowSelect = coinLeadFollowSelect;
    }

    public RichSelectOneChoice getCoinLeadFollowSelect() {
        return this.coinLeadFollowSelect;
    }

    public void memberDependantListener(SelectionEvent selectionEvent) {
        Iterator i$;
        if (selectionEvent.getAddedSet() != selectionEvent.getRemovedSet()) {
            RowKeySet keys = selectionEvent.getAddedSet();
            if ((keys != null) && (keys.getSize() > 0))
                for (i$ = keys.iterator(); i$.hasNext(); ) {
                    Object treeRowKey = i$.next();
                    this.anndependentsLOV.setRowKey(treeRowKey);
                    JUCtrlHierNodeBinding nd =
                        (JUCtrlHierNodeBinding)this.anndependentsLOV.getRowData();

                    this.session.setAttribute("qabCode",
                                              nd.getRow().getAttribute("qabCode"));

                    ADFUtils.findIterator("findDependentsAnnuityPaymentsIterator").executeQuery();
                    AdfFacesContext.getCurrentInstance().addPartialTarget(this.annPartialPayments);
                }
        }
    }

    public void setAnnPartialPayments(RichTable annPartialPayments) {
        this.annPartialPayments = annPartialPayments;
    }

    public RichTable getAnnPartialPayments() {
        return this.annPartialPayments;
    }

    public void setPensionMode(RichSelectOneChoice pensionMode) {
        this.pensionMode = pensionMode;
    }

    public RichSelectOneChoice getPensionMode() {
        return this.pensionMode;
    }

    public void setOsLoanCalculation(RichSelectOneChoice osLoanCalculation) {
        this.osLoanCalculation = osLoanCalculation;
    }

    public RichSelectOneChoice getOsLoanCalculation() {
        return this.osLoanCalculation;
    }

    public void setMarketerDisplay(RichInputText marketerDisplay) {
        this.marketerDisplay = marketerDisplay;
    }

    public RichInputText getMarketerDisplay() {
        return this.marketerDisplay;
    }

    public void setMarketerLOV(RichTable marketerLOV) {
        this.marketerLOV = marketerLOV;
    }

    public RichTable getMarketerLOV() {
        return this.marketerLOV;
    }

    public void setLoanAmtLabel(RichOutputLabel loanAmtLabel) {
        this.loanAmtLabel = loanAmtLabel;
    }

    public RichOutputLabel getLoanAmtLabel() {
        return this.loanAmtLabel;
    }

    public void setCvrLoanAmt(RichInputText cvrLoanAmt) {
        this.cvrLoanAmt = cvrLoanAmt;
    }

    public RichInputText getCvrLoanAmt() {
        return this.cvrLoanAmt;
    }

    public void setLoanRepyLabel(RichOutputLabel loanRepyLabel) {
        this.loanRepyLabel = loanRepyLabel;
    }

    public RichOutputLabel getLoanRepyLabel() {
        return this.loanRepyLabel;
    }

    public void setCvrLoanPrd(RichInputText cvrLoanPrd) {
        this.cvrLoanPrd = cvrLoanPrd;
    }

    public RichInputText getCvrLoanPrd() {
        return this.cvrLoanPrd;
    }

    public void setLoanIntLabel(RichOutputLabel loanIntLabel) {
        this.loanIntLabel = loanIntLabel;
    }

    public RichOutputLabel getLoanIntLabel() {
        return this.loanIntLabel;
    }

    public void setCvrLoanInt(RichInputText cvrLoanInt) {
        this.cvrLoanInt = cvrLoanInt;
    }

    public RichInputText getCvrLoanInt() {
        return this.cvrLoanInt;
    }

    public void setSavingsAmtLabel(RichOutputLabel savingsAmtLabel) {
        this.savingsAmtLabel = savingsAmtLabel;
    }

    public RichOutputLabel getSavingsAmtLabel() {
        return this.savingsAmtLabel;
    }

    public void setCvrSavingsAmt(RichInputText cvrSavingsAmt) {
        this.cvrSavingsAmt = cvrSavingsAmt;
    }

    public RichInputText getCvrSavingsAmt() {
        return this.cvrSavingsAmt;
    }

    public void setAllClassesTable(RichTable allClassesTable) {
        this.allClassesTable = allClassesTable;
    }

    public RichTable getAllClassesTable() {
        return this.allClassesTable;
    }

    public void setCategoryFees(RichInputText categoryFees) {
        this.categoryFees = categoryFees;
    }

    public RichInputText getCategoryFees() {
        return this.categoryFees;
    }

    public void setCategoryStudents(RichInputText categoryStudents) {
        this.categoryStudents = categoryStudents;
    }

    public RichInputText getCategoryStudents() {
        return this.categoryStudents;
    }

    public void setClassesCbox(RichSelectBooleanCheckbox classesCbox) {
        this.classesCbox = classesCbox;
    }

    public RichSelectBooleanCheckbox getClassesCbox() {
        return this.classesCbox;
    }

    public void setTermDuration(RichInputText termDuration) {
        this.termDuration = termDuration;
    }

    public RichInputText getTermDuration() {
        return this.termDuration;
    }

    public void setFeesAmount(RichInputText feesAmount) {
        this.feesAmount = feesAmount;
    }

    public RichInputText getFeesAmount() {
        return this.feesAmount;
    }

    public void setNoOfStudents(RichInputText noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    public RichInputText getNoOfStudents() {
        return this.noOfStudents;
    }

    public void setDiscDivFactor(RichInputText discDivFactor) {
        this.discDivFactor = discDivFactor;
    }

    public RichInputText getDiscDivFactor() {
        return this.discDivFactor;
    }

    public void setDiscRateDisplay(RichInputText discRateDisplay) {
        this.discRateDisplay = discRateDisplay;
    }

    public RichInputText getDiscRateDisplay() {
        return this.discRateDisplay;
    }

    public void setDiscChoice(RichSelectOneChoice discChoice) {
        this.discChoice = discChoice;
    }

    public RichSelectOneChoice getDiscChoice() {
        return this.discChoice;
    }

    public void setQuoMemberExceptions(RichTable quoMemberExceptions) {
        this.quoMemberExceptions = quoMemberExceptions;
    }

    public RichTable getQuoMemberExceptions() {
        return this.quoMemberExceptions;
    }

    public void setRateSelection(RichSelectOneChoice rateSelection) {
        this.rateSelection = rateSelection;
    }

    public RichSelectOneChoice getRateSelection() {
        return this.rateSelection;
    }

    public void setMaskDesc(RichInputText maskDesc) {
        this.maskDesc = maskDesc;
    }

    public RichInputText getMaskDesc() {
        return this.maskDesc;
    }

    public void setMaskTable(RichTable maskTable) {
        this.maskTable = maskTable;
    }

    public RichTable getMaskTable() {
        return this.maskTable;
    }

    public void setCoverRate(RichInputNumberSpinbox coverRate) {
        this.coverRate = coverRate;
    }

    public RichInputNumberSpinbox getCoverRate() {
        return this.coverRate;
    }

    public void setCoverRateDivFactor(RichInputNumberSpinbox coverRateDivFactor) {
        this.coverRateDivFactor = coverRateDivFactor;
    }

    public RichInputNumberSpinbox getCoverRateDivFactor() {
        return this.coverRateDivFactor;
    }

    public void CoverRateListener(ValueChangeEvent valueChangeEvent) {
        if (valueChangeEvent.getOldValue() != valueChangeEvent.getNewValue()) {
            if (this.rateSelection.getValue() == null) {
                this.session.setAttribute("coverMaskCode",
                                          (BigDecimal)this.session.getAttribute("pmasCode"));
                this.maskDesc.setValue((String)this.session.getAttribute("pmasShtDesc"));

                this.maskButton.setDisabled(true);
                this.coverRate.setDisabled(true);
                this.coverRate.setValue(null);
                this.coverRateDivFactor.setDisabled(true);
                this.coverRateDivFactor.setValue(null);
            } else if (this.rateSelection.getValue().toString().equalsIgnoreCase("M")) {
                this.session.setAttribute("coverMaskCode",
                                          (BigDecimal)this.session.getAttribute("pmasCode"));
                this.maskDesc.setValue((String)this.session.getAttribute("pmasShtDesc"));

                this.maskButton.setDisabled(true);
                this.coverRate.setDisabled(true);
                this.coverRate.setValue(null);
                this.coverRateDivFactor.setDisabled(true);
                this.coverRateDivFactor.setValue(null);
            } else if (this.rateSelection.getValue().toString().equalsIgnoreCase("S")) {
                this.session.setAttribute("coverMaskCode", null);
                this.maskDesc.setValue(null);
                this.maskButton.setDisabled(false);
                this.coverRate.setDisabled(true);
                this.coverRate.setValue(null);
                this.coverRateDivFactor.setDisabled(true);
                this.coverRateDivFactor.setValue(null);
            } else if (this.rateSelection.getValue().toString().equalsIgnoreCase("C")) {
                this.session.setAttribute("coverMaskCode", null);
                this.maskDesc.setValue(null);
                this.maskButton.setDisabled(true);
                this.coverRate.setDisabled(false);
                this.coverRate.setValue(null);
                this.coverRateDivFactor.setDisabled(false);
                this.coverRateDivFactor.setValue(null);
            }
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.maskDesc);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.maskButton);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.coverRate);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.coverRateDivFactor);
        }
    }

    public String AssignCoverPremiumMask() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findPremiumMask1Iterator");
        RowKeySet set = this.maskTable.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            this.session.setAttribute("coverMaskCode",
                                      r.getAttribute("PMAS_CODE"));
            this.maskDesc.setValue(r.getAttribute("PMAS_SHT_DESC"));

            AdfFacesContext.getCurrentInstance().addPartialTarget(this.maskDesc);
            GlobalCC.hidePopup("lmsgroup:p8");
        }
        return null;
    }

    public String AssignCategoryPremiumMask() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findPremiumMask1Iterator");
        RowKeySet set = this.catMaskTable.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            this.session.setAttribute("categoryMaskCode",
                                      r.getAttribute("PMAS_CODE"));
            this.catMaskDesc.setValue(r.getAttribute("PMAS_SHT_DESC"));
        }

        return null;
    }

    public void setMaskButton(RichCommandButton maskButton) {
        this.maskButton = maskButton;
    }

    public RichCommandButton getMaskButton() {
        return this.maskButton;
    }

    public void setCatMaskDesc(RichInputText catMaskDesc) {
        this.catMaskDesc = catMaskDesc;
    }

    public RichInputText getCatMaskDesc() {
        return this.catMaskDesc;
    }

    public void setCatMaskTable(RichTable catMaskTable) {
        this.catMaskTable = catMaskTable;
    }

    public RichTable getCatMaskTable() {
        return this.catMaskTable;
    }

    public void setWeTLabel(RichOutputLabel weTLabel) {
        this.weTLabel = weTLabel;
    }

    public RichOutputLabel getWeTLabel() {
        return this.weTLabel;
    }

    public void setUmbrellaDurationType(RichSelectOneChoice umbrellaDurationType) {
        this.umbrellaDurationType = umbrellaDurationType;
    }

    public RichSelectOneChoice getUmbrellaDurationType() {
        return this.umbrellaDurationType;
    }

    public void setUmbrellaDurationLabel(RichOutputLabel umbrellaDurationLabel) {
        this.umbrellaDurationLabel = umbrellaDurationLabel;
    }

    public RichOutputLabel getUmbrellaDurationLabel() {
        return this.umbrellaDurationLabel;
    }

    public void setSubdivision(RichSelectOneChoice subdivision) {
        this.subdivision = subdivision;
    }

    public RichSelectOneChoice getSubdivision() {
        return this.subdivision;
    }

    public void setDivShortDesc(RichInputText divShortDesc) {
        this.divShortDesc = divShortDesc;
    }

    public RichInputText getDivShortDesc() {
        return this.divShortDesc;
    }

    public void setDivDesc(RichInputText divDesc) {
        this.divDesc = divDesc;
    }

    public RichInputText getDivDesc() {
        return this.divDesc;
    }

    public String AddSubDivision() {
        this.session.setAttribute("subdivisionCode", null);
        this.session.setAttribute("QuotedivisionCode", null);
        this.session.setAttribute("action", "A");
        this.divShortDesc.setValue(null);
        this.divDesc.setValue(null);

        GlobalCC.showPopup("lmsgroup:p9");
        return null;
    }

    public String EditSubDivision() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findQuoteSubdivisionsIterator");
        RowKeySet set = this.quoteDivisionsTable.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            this.session.setAttribute("subdivisionCode",
                                      r.getAttribute("QGSUB_GSUB_CODE"));
            this.session.setAttribute("QuotedivisionCode",
                                      r.getAttribute("QGSUB_CODE"));
            this.divShortDesc.setValue(r.getAttribute("QGSUB_SHT_DESC"));
            this.divDesc.setValue(r.getAttribute("QGSUB_DESC"));
            this.session.setAttribute("action", "E");

            GlobalCC.showPopup("lmsgroup:p9");
        }

        return null;
    }

    public String DeleteSubDivision() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findQuoteSubdivisionsIterator");
        RowKeySet set = this.quoteDivisionsTable.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            this.session.setAttribute("subdivisionCode",
                                      r.getAttribute("QGSUB_GSUB_CODE"));
            this.session.setAttribute("QuotedivisionCode",
                                      r.getAttribute("QGSUB_CODE"));
            this.divShortDesc.setValue(r.getAttribute("QGSUB_SHT_DESC"));
            this.divDesc.setValue(r.getAttribute("QGSUB_DESC"));
            this.session.setAttribute("action", "D");
            SaveSubDivision();
        }

        return null;
    }

    public String SaveSubDivision() {
        Connection conn = null;
        try {
            String Task = (String)this.session.getAttribute("action");

            if ((Task.equalsIgnoreCase("A")) || (Task.equalsIgnoreCase("E"))) {
                if (this.divShortDesc.getValue() == null) {
                    GlobalCC.INFORMATIONREPORTING("Enter A Short Description");
                    return null;
                }
                if (this.divDesc.getValue() == null) {
                    GlobalCC.INFORMATIONREPORTING("Enter A Description");
                    return null;
                }
            } else if (Task.equalsIgnoreCase("D")) {
                BigDecimal Code =
                    (BigDecimal)this.session.getAttribute("QuotedivisionCode");
                if (Code == null) {
                    GlobalCC.INFORMATIONREPORTING("Select A SubDivision");
                    return null;
                }
            }

            String deleteQuery =
                "BEGIN LMS_WEB_PKG_GRP_UW.save_quote_subdivisions(?,?,?,?,?,?);END;";
            conn = new DBConnector().getDatabaseConn();
            CallableStatement cstmt = conn.prepareCall(deleteQuery);
            cstmt.setString(1, (String)this.session.getAttribute("action"));
            cstmt.setBigDecimal(2,
                                (BigDecimal)this.session.getAttribute("QuoteCode"));
            cstmt.setBigDecimal(3,
                                (BigDecimal)this.session.getAttribute("QuotedivisionCode"));
            cstmt.setBigDecimal(4,
                                (BigDecimal)this.session.getAttribute("subdivisionCode"));
            if (this.divShortDesc.getValue() == null)
                cstmt.setString(5, null);
            else {
                cstmt.setString(5, this.divShortDesc.getValue().toString());
            }
            if (this.divDesc.getValue() == null)
                cstmt.setString(6, null);
            else {
                cstmt.setString(6, this.divDesc.getValue().toString());
            }
            cstmt.execute();
            cstmt.close();
            conn.close();

            GlobalCC.INFORMATIONREPORTING("Transaction Successfully Completed");

            ADFUtils.findIterator("findQuoteSubdivisionsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.quoteDivisionsTable);

            GlobalCC.hidePopup("lmsgroup:p9");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public void setQuoteDivisionsTable(RichTable quoteDivisionsTable) {
        this.quoteDivisionsTable = quoteDivisionsTable;
    }

    public RichTable getQuoteDivisionsTable() {
        return this.quoteDivisionsTable;
    }

    public void setMemberSDivTable(RichTable memberSDivTable) {
        this.memberSDivTable = memberSDivTable;
    }

    public RichTable getMemberSDivTable() {
        return this.memberSDivTable;
    }

    public void setDpdMinAmount(RichInputText dpdMinAmount) {
        this.dpdMinAmount = dpdMinAmount;
    }

    public RichInputText getDpdMinAmount() {
        return this.dpdMinAmount;
    }

    public void actionConfirmDelete(DialogEvent dialogEvent) {
        String confirmDelete =
            (String)this.session.getAttribute("confirmDelete");
        if (confirmDelete.compareTo("DpndLim") == 0)
            DeleteDependentLimit();
        else if (confirmDelete.compareTo("CatCls") == 0)
            DeleteCategoryClasses();
        else if (confirmDelete.compareTo("SubDiv") == 0) {
            DeleteSubDivision();
        }
        GlobalCC.hidePopup("lmsgroup:confirmDelete");
    }

    public String performDeleteDependentLimit() {
        GlobalCC.showPopup("lmsgroup:confirmDelete");
        this.session.setAttribute("confirmDelete", "DpndLim");
        return null;
    }

    public String performDeleteCategoryClasses() {
        GlobalCC.showPopup("lmsgroup:confirmDelete");
        this.session.setAttribute("confirmDelete", "CatCls");
        return null;
    }

    public String performDeleteSubDivision() {
        GlobalCC.showPopup("lmsgroup:confirmDelete");
        this.session.setAttribute("confirmDelete", "SubDiv");
        return null;
    }

    public void setTotMemEarningLab(RichOutputLabel totMemEarningLab) {
        this.totMemEarningLab = totMemEarningLab;
    }

    public RichOutputLabel getTotMemEarningLab() {
        return this.totMemEarningLab;
    }

    public void setTotMemEarnings(RichInputText totMemEarnings) {
        this.totMemEarnings = totMemEarnings;
    }

    public RichInputText getTotMemEarnings() {
        return this.totMemEarnings;
    }

    public void avMemEarningsListener(ValueChangeEvent valueChangeEvent) {
        String avg_mem_earning = null;
        Connection conn = null;
        if ((this.totalMemEarning.getValue() != null) &&
            (this.totalMem.getValue() != null)) {
            try {
                conn = new DBConnector().getDatabaseConn();
                avg_mem_earning = this.totalMemEarning.getValue().toString();

                String query =
                    "begin ? := LMS_WEB_PKG_GRP_UW.avg_mem_earnings(?,?); end;";

                CallableStatement cstmt = conn.prepareCall(query);

                cstmt.registerOutParameter(1, OracleTypes.DOUBLE);

                cstmt.setString(2, avg_mem_earning);
                cstmt.setString(3, (String)this.totalMem.getValue());
                cstmt.execute();

                Double Result = cstmt.getDouble(1);
                this.avMemberEarnings.setValue(Result);
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.avMemberEarnings);
                conn.close();
            } catch (Exception e) {
                GlobalCC.EXCEPTIONREPORTING(conn, e);
            }
        }
    }

    public void totMemEarningsListener(ValueChangeEvent valueChangeEvent) {
        String avg_mem_earning = null;
        Connection conn = null;
        if ((this.avMemberEarnings.getValue() != null) &&
            (this.totalMem.getValue() != null)) {
            try {
                conn = new DBConnector().getDatabaseConn();
                avg_mem_earning = this.avMemberEarnings.getValue().toString();

                String query =
                    "begin ? := LMS_WEB_PKG_GRP_UW.tot_mem_earnings(?,?); end;";

                CallableStatement cstmt = conn.prepareCall(query);

                cstmt.registerOutParameter(1, OracleTypes.DOUBLE);

                cstmt.setString(2, avg_mem_earning);
                cstmt.setString(3, (String)this.totalMem.getValue());
                cstmt.execute();

                double Result = cstmt.getDouble(1);

                this.totalMemEarning.setValue(Result);
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.totalMemEarning);
                conn.close();
            } catch (Exception e) {
                GlobalCC.EXCEPTIONREPORTING(conn, e);
                e.printStackTrace();
            }
        }
    }

    public void getLossRatio() {
        String updateQuery =
            "BEGIN LMS_WEB_PKG_GRP.update_loss_ratio(?,?,?,?);END;";
        Connection conn = new DBConnector().getDatabaseConn();
        CallableStatement cstmt = null;

        try {
            cstmt = conn.prepareCall(updateQuery);
            cstmt.setString(1, "Q");
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

    public void getQuotProductPlan(String tender) {
        String updateQuery =
            "BEGIN LMS_WEB_PKG_GRP.update_prod_plan(?,?,?,?,?,?);END;";
        Connection conn = new DBConnector().getDatabaseConn();
        CallableStatement cstmt = null;

        try {
            cstmt = conn.prepareCall(updateQuery);
            cstmt.setString(1, "Q");
            cstmt.setBigDecimal(2,
                                (BigDecimal)this.session.getAttribute("QuoteCode"));
            cstmt.setBigDecimal(3,
                                (BigDecimal)this.session.getAttribute("pplCode"));
            cstmt.setString(4, tender);
            if(earnPrdType.getValue()!=null){
              cstmt.setString(5, earnPrdType.getValue().toString()); 
            }else{
              cstmt.setString(5, "A"); 
            }
            if(tenderPeriodTF.getValue()==null){
              cstmt.setString(6, null); 
            }else{
              cstmt.setString(6, tenderPeriodTF.getValue().toString()); 
            }
            cstmt.execute();
            cstmt.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
    }

   /* public void getCurrencyDetails() {
        String updateQuery =
            "BEGIN LMS_WEB_PKG_GRP.saveCurrencyDetails(?,?,?,?);END;";
        Connection conn = new DBConnector().getDatabaseConn();
        CallableStatement cstmt = null;
        String currencySymb =
            (String)this.session.getAttribute("baseCurrSymb");
        if ()

        if (currencySymbol.getValue() == null) {
            GlobalCC.sysInformation("Please Choose a currency Symbol");
        } else {
            Row row =
                ADFUtils.findIterator("findOrgCurrenciesIter").getRowAtRangeIndex(new Integer(currencySymbol.getValue().toString()));
            currencySymb = (String)row.getAttribute("cur_symbol");

        }
        System.out.println("currencySymb=" + currencySymb);

        try {
            cstmt = conn.prepareCall(updateQuery);
            cstmt.setBigDecimal(1,
                                (BigDecimal)this.session.getAttribute("QuoteCode"));
            cstmt.setString(2, currencySymb);
            cstmt.setString(3, currExchRateType.getValue().toString());
            if (currExchangeRate.getValue() == null) {
                cstmt.setString(4, null);
            } else {
                cstmt.setString(4, currExchangeRate.getValue().toString());
            }


            cstmt.execute();
            cstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
    }*/
   public void getCurrencyDetails() {
       String updateQuery =
           "BEGIN LMS_WEB_PKG_GRP.saveCurrencyDetails(?,?,?,?);END;";
       Connection conn = new DBConnector().getDatabaseConn();
       CallableStatement cstmt = null;

     String currencySymb=(String)this.session.getAttribute("baseCurrSymb");
       if(this.session.getAttribute("cur_symbol")!=null){
         currencySymb=(String)this.session.getAttribute("cur_symbol");
       }
         
     if(currencySymb==null){
       GlobalCC.sysInformation("Please Choose a currency Symbol");
     }
     //System.out.println("currencySymb="+currencySymb);

       try {
           cstmt = conn.prepareCall(updateQuery);
           cstmt.setBigDecimal(1,
                               (BigDecimal)this.session.getAttribute("QuoteCode"));
           cstmt.setString(2,currencySymb);
           cstmt.setString(3,currExchRateType.getValue().toString());
           if(currExchangeRate.getValue()==null){
             cstmt.setString(4,null);
           }else{
             cstmt.setString(4,currExchangeRate.getValue().toString());
           }
           
           
           cstmt.execute();
           cstmt.close();
       } catch (Exception e) {
           e.printStackTrace();
           GlobalCC.EXCEPTIONREPORTING(conn, e);
       }
   }

    public void setPrdTypeLabel2(RichOutputLabel prdTypeLabel2) {
        this.prdTypeLabel2 = prdTypeLabel2;
    }

    public RichOutputLabel getPrdTypeLabel2() {
        return this.prdTypeLabel2;
    }

    public void setTotalMemEarninglbl(RichOutputLabel totalMemEarninglbl) {
        this.totalMemEarninglbl = totalMemEarninglbl;
    }

    public RichOutputLabel getTotalMemEarninglbl() {
        return this.totalMemEarninglbl;
    }

    public void setTotalMemEarning(RichInputText totalMemEarning) {
        this.totalMemEarning = totalMemEarning;
    }

    public RichInputText getTotalMemEarning() {
        return this.totalMemEarning;
    }

    public void setMultiprdPanel(HtmlPanelGrid multiprdPanel) {
        this.multiprdPanel = multiprdPanel;
    }

    public HtmlPanelGrid getMultiprdPanel() {
        return this.multiprdPanel;
    }

    public void setTotLoanAmtLabel(RichOutputLabel totLoanAmtLabel) {
        this.totLoanAmtLabel = totLoanAmtLabel;
    }

    public RichOutputLabel getTotLoanAmtLabel() {
        return this.totLoanAmtLabel;
    }

    public void setTotLoanAmt(RichInputText totLoanAmt) {
        this.totLoanAmt = totLoanAmt;
    }

    public RichInputText getTotLoanAmt() {
        return this.totLoanAmt;
    }

    public void setAvCoverPerMemLabel(RichOutputLabel avCoverPerMemLabel) {
        this.avCoverPerMemLabel = avCoverPerMemLabel;
    }

    public RichOutputLabel getAvCoverPerMemLabel() {
        return this.avCoverPerMemLabel;
    }

    public void setAvCoverPerMem(RichInputText avCoverPerMem) {
        this.avCoverPerMem = avCoverPerMem;
    }

    public RichInputText getAvCoverPerMem() {
        return this.avCoverPerMem;
    }

    public void setPremMaskBut(RichCommandButton premMaskBut) {
        this.premMaskBut = premMaskBut;
    }

    public RichCommandButton getPremMaskBut() {
        return premMaskBut;
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

    public void discLoadChoiceListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if (valueChangeEvent.getNewValue() != valueChangeEvent.getOldValue()) {
            if (discLoadChoice.getValue() != null) {
                if (discLoadChoice.getValue().equals("A")) {
                    discLoadRateDisplayLab.setRendered(false);
                    discLoadRateDisplay.setRendered(false);
                    divFactorLab.setRendered(false);
                    divFactor.setRendered(false);
                    ageLoadFactorLab.setRendered(true);
                    ageLoadFactor.setRendered(true);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(this.coversPanel);
                    //AdfFacesContext.getCurrentInstance().addPartialTarget(this.discLoadRateDisplay);
                    //AdfFacesContext.getCurrentInstance().addPartialTarget(this.divFactorLab);
                    //AdfFacesContext.getCurrentInstance().addPartialTarget(this.divFactor);
                    //AdfFacesContext.getCurrentInstance().addPartialTarget(this.ageLoadFactorLab);
                    // AdfFacesContext.getCurrentInstance().addPartialTarget(this.ageLoadFactor);

                } else {
                    discLoadRateDisplayLab.setRendered(true);
                    discLoadRateDisplay.setRendered(true);
                    divFactorLab.setRendered(true);
                    divFactor.setRendered(true);
                    ageLoadFactorLab.setRendered(false);
                    ageLoadFactor.setRendered(false);

                    AdfFacesContext.getCurrentInstance().addPartialTarget(this.coversPanel);
                    //AdfFacesContext.getCurrentInstance().addPartialTarget(this.discLoadRateDisplayLab);
                    //AdfFacesContext.getCurrentInstance().addPartialTarget(this.discLoadRateDisplay);
                    // AdfFacesContext.getCurrentInstance().addPartialTarget(this.divFactorLab);
                    //AdfFacesContext.getCurrentInstance().addPartialTarget(this.divFactor);
                    //AdfFacesContext.getCurrentInstance().addPartialTarget(this.ageLoadFactorLab);
                    //AdfFacesContext.getCurrentInstance().addPartialTarget(this.ageLoadFactor);
                }
            }
        }
    }

    public void setCoversPanel(RichPanelBox coversPanel) {
        this.coversPanel = coversPanel;
    }

    public RichPanelBox getCoversPanel() {
        return coversPanel;
    }

    public void setPensionHistIntRate(RichInputText pensionHistIntRate) {
        this.pensionHistIntRate = pensionHistIntRate;
    }

    public RichInputText getPensionHistIntRate() {
        return pensionHistIntRate;
    }

    public void setCurrencySymbol(RichSelectOneChoice currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    public RichSelectOneChoice getCurrencySymbol() {
        return currencySymbol;
    }

    public void setCurrExchangeRate(RichInputText currExchangeRate) {
        this.currExchangeRate = currExchangeRate;
    }

    public RichInputText getCurrExchangeRate() {
        return currExchangeRate;
    }

    public void setCurrExchRateType(RichSelectOneChoice currExchRateType) {
        this.currExchRateType = currExchRateType;
    }

    public RichSelectOneChoice getCurrExchRateType() {
        return currExchRateType;
    }

    public void setCurrExchangeRateLab(RichOutputText currExchangeRateLab) {
        this.currExchangeRateLab = currExchangeRateLab;
    }

    public RichOutputText getCurrExchangeRateLab() {
        return currExchangeRateLab;
    }

    public void currRateTypeListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if (valueChangeEvent.getOldValue() != valueChangeEvent.getNewValue()) {
            if (currExchRateType.getValue() != null) {
                if (currExchRateType.getValue().equals("Y")) {
                    currExchangeRateLab.setRendered(true);
                    currExchangeRate.setRendered(true);

                } else {
                    currExchangeRateLab.setRendered(false);
                    currExchangeRate.setRendered(false);
                }
            }


        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.currExchangeRateLab);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.currExchangeRate);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.currencyGrid);
    }

    public void setCurrencyGrid(HtmlPanelGrid currencyGrid) {
        this.currencyGrid = currencyGrid;
    }

    public HtmlPanelGrid getCurrencyGrid() {
        return currencyGrid;
    }


    public void setAvMemberEarnings(RichInputText avMemberEarnings) {
        this.avMemberEarnings = avMemberEarnings;
    }

    public RichInputText getAvMemberEarnings() {
        return avMemberEarnings;
    }

    public void setBmiRate(RichInputText bmiRate) {
        this.bmiRate = bmiRate;
    }

    public RichInputText getBmiRate() {
        return bmiRate;
    }

    public String categorySelected() {
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findOccupationCategoryIterator");
            RowKeySet set = this.classOccLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();
                this.categID.setValue(r.getAttribute("gocCategory"));
                this.categDescription.setValue(r.getAttribute("gocCategory"));
                this.categoryPeriod.setValue(r.getAttribute("gocClass"));
            }
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public void setClassOccLOV(RichTable classOccLOV) {
        this.classOccLOV = classOccLOV;
    }

    public RichTable getClassOccLOV() {
        return classOccLOV;
    }

    public void populateDependentTypes(BigDecimal pctCode,
                                       BigDecimal cvtCode) {
        Connection conn = null;
        try {
            conn = new DBConnector().getDatabaseConn();

            String query =
                "begin LMS_WEB_PKG_GRP.getDefaultDependentType(?,?,?,?); end;";

            CallableStatement cstmt = conn.prepareCall(query);
            cstmt.setBigDecimal(1, cvtCode);
            cstmt.setBigDecimal(2, pctCode);
            cstmt.registerOutParameter(3, OracleTypes.NUMBER);
            cstmt.registerOutParameter(4, OracleTypes.VARCHAR);
            cstmt.execute();
            session.setAttribute("dtyCode", cstmt.getBigDecimal(3));
            this.dtyDesc.setValue(cstmt.getString(4));
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.dtyDesc);
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
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
            cstmt.registerOutParameter(3, OracleTypes.NUMBER);
            cstmt.registerOutParameter(4, OracleTypes.VARCHAR);
            cstmt.registerOutParameter(5, OracleTypes.VARCHAR);
            cstmt.execute();

            if (cstmt.getBigDecimal(3) != null) {
                this.session.setAttribute("pmasCode", cstmt.getBigDecimal(3));
                this.session.setAttribute("coverMaskCode",
                                          cstmt.getBigDecimal(3));
            }
            if (cstmt.getString(4) != null) {
                this.session.setAttribute("pmasShtDesc", cstmt.getString(4));
                maskDesc.setValue(cstmt.getString(4));
            }
            if (cstmt.getString(5) != null) {
                rateSelection.setValue(cstmt.getString(5));
            }
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.maskDesc);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.rateSelection);
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
    }


    public String getSelectedPlan() {
        // Add event code here...
        return null;
    }

    public void setProductPlan(RichTable productPlan) {
        this.productPlan = productPlan;
    }

    public RichTable getProductPlan() {
        return productPlan;
    }

    public void setPlanTF(RichInputText planTF) {
        this.planTF = planTF;
    }

    public RichInputText getPlanTF() {
        return planTF;
    }

    public String findSelectedPlan() {
        // Add event code here...
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findProductPlansIterator");
            RowKeySet set = this.productPlan.getSelectedRowKeys();
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

    public void setTender(RichSelectBooleanCheckbox tender) {
        this.tender = tender;
    }

    public RichSelectBooleanCheckbox getTender() {
        return tender;
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

    public void setAggCatPanel(HtmlPanelGrid aggCatPanel) {
        this.aggCatPanel = aggCatPanel;
    }

    public HtmlPanelGrid getAggCatPanel() {
        return aggCatPanel;
    }

    public String aggSelectCategory() {
        // Add event code here...
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findOccupationCategoryIterator");
            RowKeySet set = this.aggregateCatLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();
                this.cvrCategory.setValue(r.getAttribute("gocCategory"));
                this.cvrMultipleEarningsPeriod.setValue(r.getAttribute("gocClass"));
            }
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.cvrCategory);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.cvrMultipleEarningsPeriod);
            GlobalCC.hidePopup("lmsgroup:p12");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public void setAggregateCatLOV(RichTable aggregateCatLOV) {
        this.aggregateCatLOV = aggregateCatLOV;
    }

    public RichTable getAggregateCatLOV() {
        return aggregateCatLOV;
    }

    public void setAvgLabAggregate(RichOutputLabel avgLabAggregate) {
        this.avgLabAggregate = avgLabAggregate;
    }

    public RichOutputLabel getAvgLabAggregate() {
        return avgLabAggregate;
    }
  public void heightChangeListener(ValueChangeEvent valueChangeEvent) {
      // Add event code here...
      double bmi_rate,weight,height;
      DecimalFormat df=new DecimalFormat("#.0000");
      if(memHeight.getValue()!=null && memWeight.getValue()!=null){
        weight=Double.parseDouble(memWeight.getValue().toString());
        height=Double.parseDouble(memHeight.getValue().toString());
        bmi_rate=weight/(Math.pow(height,2));
        bmiRate.setValue(df.format(bmi_rate));
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.bmiRate);
      }
  }

  public void weightChangeListener(ValueChangeEvent valueChangeEvent) {
      // Add event code here...
      double bmi_rate,weight,height;
      DecimalFormat df=new DecimalFormat("#.0000");
      if(memHeight.getValue()!=null && memWeight.getValue()!=null){
        weight=Double.parseDouble(memWeight.getValue().toString());
        height=Double.parseDouble(memHeight.getValue().toString());
        bmi_rate=weight/(Math.pow(height,2));
        bmiRate.setValue(df.format(bmi_rate));
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.bmiRate);
      }
  }

    public String updateMembers() {
        Connection conn = null;
        try {
            String getSelectedMember =
                "LMS_WEB_CURSOR_GRP.quotationMembers(?,?);END;";
            conn = new DBConnector().getDatabaseConn();
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findQuoteMembersIterator");
            RowKeySet set = this.allMembers.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();
                this.session.setAttribute("qmemCode",
                                          r.getAttribute("QMEM_MEM_CODE"));
                this.session.setAttribute("dtyCode",
                                          r.getAttribute("QMEM_DTY_CODE"));
                CallableStatement cstmt = conn.prepareCall(getSelectedMember);
                cstmt.setBigDecimal(1,
                                    (BigDecimal)this.session.getAttribute("QuoteCode"));
                cstmt.setBigDecimal(1,
                                    (BigDecimal)this.session.getAttribute("qmemCode"));
                cstmt.setString(3,
                                (String)this.session.getAttribute("dpdsCovered"));
                cstmt.setBigDecimal(4,
                                    (BigDecimal)this.session.getAttribute("dtyCode"));
                cstmt.execute();
            }

            conn.close();
            ADFUtils.findIterator("findQuoteMembersIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.memberCoversLOV);
            ADFUtils.findIterator("findQuoteMembersIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.allMembers);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.memberCoversLOV);
            this.session.setAttribute("quoteMemMemCode", null);
            ADFUtils.findIterator("findMemberBeneficiariesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.memberBeneficiariesLOV);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }


   
    public void setTenderPrd(RichInputText tenderPrd) {
        this.tenderPrd = tenderPrd;
    }

    public RichInputText getTenderPrd() {
        return tenderPrd;
    }

    public void setTenderGrid(HtmlPanelGrid tenderGrid) {
        this.tenderGrid = tenderGrid;
    }

    public HtmlPanelGrid getTenderGrid() {
        return tenderGrid;
    }

    public void setTenderPrdInput(RichInputNumberSpinbox tenderPrdInput) {
        this.tenderPrdInput = tenderPrdInput;
    }

    public RichInputNumberSpinbox getTenderPrdInput() {
        return tenderPrdInput;
    }

    public void tenderListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        
        System.out.println("The value has been changed!");
        
        if(tender.isSelected()){
           tenderPeriodLab.setVisible(true);
          tenderPeriodTF.setVisible(true);
        } else {
          tenderPeriodLab.setVisible(false);
          tenderPeriodTF.setVisible(false);
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(tenderPeriodLab);
      AdfFacesContext.getCurrentInstance().addPartialTarget(tenderPeriodTF);
    }

    public void setCovLimitInput(RichInputText covLimitInput) {
        this.covLimitInput = covLimitInput;
    }

    public RichInputText getCovLimitInput() {
        return covLimitInput;
    }
    
    public String deleteJointMember(){
        
        Connection conn=null;
        try{
           DBConnector myConn=new DBConnector();
           conn=myConn.getDatabaseConn();
           CallableStatement cst=null;
           BigDecimal Code = null;
           
        
        DCIteratorBinding dciter = ADFUtils.findIterator("FindQuoteJointMembersIterator");
        RowKeySet set =jointMemLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        
        while (rowKeySetIter.hasNext())
        {
         List l = (List) rowKeySetIter.next();
         Key key = (Key)l.get(0);
         dciter.setCurrentRowWithKey(key.toStringFormat(true));
         Row r = dciter.getCurrentRow();
        
         Code = (BigDecimal)r.getAttribute("j_POLM_CODE");   
            
         System.out.println("Polm Code= "+Code);
         String polQuery="begin LMS_WEB_PKG_GRP.deletequojointmember(?);end;";
         cst=conn.prepareCall(polQuery);
         cst.setBigDecimal(1,Code);
         cst.execute(); 
         cst.close();
         conn.close();
    
         ADFUtils.findIterator("FindQuoteJointMembersIterator").executeQuery();    
         AdfFacesContext.getCurrentInstance().addPartialTarget(jointMemLOV);
            
          String Message = "Joint Member Deleted.";
          FacesContext.getCurrentInstance().addMessage(null, 
                                                       new FacesMessage(FacesMessage.SEVERITY_INFO, 
                                                                        Message, 
                                                                        Message));
         
        
        }
         
           
        }catch(Exception e){
           GlobalCC.EXCEPTIONREPORTING(conn,e);
        }

        
        return null;    
    }

    public String editMemberDetails() {
        
        RowKeySet set = this.allMembers.getSelectedRowKeys();
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findQuoteMembersIterator");
        Iterator rowKeySetIter = set.iterator();
        
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
            this.session.setAttribute("quoMemNo",
                                      r.getAttribute("quoMemNo"));
			
			if (session.getAttribute("quoMemNo") == null || session.getAttribute("quoMemName") == null){
				GlobalCC.sysInformation("No member Selected. Please select a member!");
			} else {
				this.quoteBasicDetailsTab.setRendered(false);
				this.pensionsTab.setRendered(false);
				this.coverDetailsTab.setRendered(false);
				this.taxesTab.setRendered(false);
				this.categoryDetailsTab.setRendered(false);
				this.quoteMembersTab.setRendered(false);
				this.provisionsTab.setRendered(false);
				this.memCovers.setRendered(false);
				this.membersImport.setRendered(false);
				this.singleMember.setRendered(true);
				this.prevButton.setRendered(false);
				this.nextButton.setRendered(false);
				this.finishButton.setRendered(false);
				this.computePremiumButton.setRendered(false);
			}
            this.session.setAttribute("quoMemName",
                                      r.getAttribute("quoMemName"));
            this.session.setAttribute("quoDepMemType",
                                      r.getAttribute("quoDepMemType"));
              
            this.session.setAttribute("quoMemAnb",
                                      r.getAttribute("quoMemAnb"));
              
            this.session.setAttribute("quoJointMem",
                                      r.getAttribute("quoJointMem"));
              
            this.session.setAttribute("quoOccupation",
                                      r.getAttribute("quoOccupation"));
            
            this.session.setAttribute("QMEM_MEM_CODE",
                                      r.getAttribute("QMEM_MEM_CODE"));
          findQuoteMembers();
        }
        return null;
    }
    
    
  public String findQuoteMembers()
  {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    List myQuotations = new ArrayList();
    try
    {
      String membersQuery = "BEGIN LMS_WEB_CURSOR_GRP.quotationEditMembers(?,?,?);end;";
      cst = conn.prepareCall(membersQuery);
      cst.registerOutParameter(1,OracleTypes.CURSOR);
      cst.setBigDecimal(2, (BigDecimal)this.session.getAttribute("QuoteCode"));
      cst.setBigDecimal(3, (BigDecimal)this.session.getAttribute("QMEM_MEM_CODE"));

      cst.execute();
      ResultSet rs = (ResultSet)cst.getObject(1);
      while (rs.next())
      {
        memNo.setValue(rs.getString(1));
        memSurname.setValue(rs.getString(2));
        memOtherNames.setValue(rs.getString(3));
        idNo.setValue(rs.getString(4));
        quotememANB.setValue(Integer.valueOf(rs.getInt(6)));
        occupationDesc.setValue(rs.getString(8));
        //member.setQMEM_DTY_CODE(rs.getBigDecimal(18));
        //member.setQMEM_MEM_CODE(rs.getBigDecimal(19));
        //member.setQMEM_CODE(rs.getBigDecimal(20));
        //member.setQMEM_BPRESS_LOADING(rs.getBigDecimal(21));
        height.setValue(rs.getBigDecimal(9));
        weight.setValue(rs.getBigDecimal(10));
        //member.setQMEM_WEIGHT_LOADING(rs.getBigDecimal(11));
        sysPres.setValue(rs.getBigDecimal(12));
        diaPres.setValue(rs.getBigDecimal(13));
        annualEarnings.setValue(rs.getBigDecimal(21));
        categoryDesc.setValue(rs.getString(22));
        memEarnprds.setValue(rs.getBigDecimal(25));
        monthlyEarnings.setValue(rs.getBigDecimal(24));
        memdob.setValue(rs.getDate(27));
        joinDate.setValue(rs.getDate(26));
        memSex.setValue(rs.getString(28));
        //member.setQMEM_BMI_RATE(rs.getBigDecimal(23));
          
      }

      rs.close();
      cst.close();
      conn.close();
    }
    catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
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

    public void avgLoanListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        String avg_mem_loan= null;
        Connection conn = null;
        if ((this.totLoanAmt.getValue() != null) &&
            (this.totalMem.getValue() != null)) {
            try {
                conn = new DBConnector().getDatabaseConn();
                avg_mem_loan = this.totLoanAmt.getValue().toString();

                String query =
                    "begin ? := LMS_WEB_PKG_GRP_UW.avg_mem_earnings(?,?); end;";

                CallableStatement cstmt = conn.prepareCall(query);

                cstmt.registerOutParameter(1, OracleTypes.DOUBLE);

                cstmt.setString(2, avg_mem_loan);
                cstmt.setString(3, (String)this.totalMem.getValue());
                cstmt.execute();

                Double Result = cstmt.getDouble(1);
                this.cvrLoanAmt.setValue(Result);
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.cvrLoanAmt);
                conn.close();
            } catch (Exception e) {
                GlobalCC.EXCEPTIONREPORTING(conn, e);
            }
        }
    }

    public void totLoanListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        String avg_mem_loan = null;
        Connection conn = null;
        if ((this.cvrLoanAmt.getValue() != null) &&
            (this.totalMem.getValue() != null)) {
            try {
                conn = new DBConnector().getDatabaseConn();
                avg_mem_loan= this.cvrLoanAmt.getValue().toString();

                String query =
                    "begin ? := LMS_WEB_PKG_GRP_UW.tot_mem_earnings(?,?); end;";

                CallableStatement cstmt = conn.prepareCall(query);

                cstmt.registerOutParameter(1, OracleTypes.DOUBLE);

                cstmt.setString(2, avg_mem_loan);
                cstmt.setString(3, (String)this.totalMem.getValue());
                cstmt.execute();

                double Result = cstmt.getDouble(1);

                this.totLoanAmt.setValue(Result);
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.totLoanAmt);
                conn.close();
            } catch (Exception e) {
                GlobalCC.EXCEPTIONREPORTING(conn, e);
                e.printStackTrace();
            }
        }
    }

    public void setEarnPrdType(RichSelectOneChoice earnPrdType) {
        this.earnPrdType = earnPrdType;
    }

    public RichSelectOneChoice getEarnPrdType() {
        return earnPrdType;
    }

    public void setTenderPeriodLab(RichOutputLabel tenderPeriodLab) {
        this.tenderPeriodLab = tenderPeriodLab;
    }

    public RichOutputLabel getTenderPeriodLab() {
        return tenderPeriodLab;
    }

    public void setTenderPeriodTF(RichInputText tenderPeriodTF) {
        this.tenderPeriodTF = tenderPeriodTF;
    }

    public RichInputText getTenderPeriodTF() {
        return tenderPeriodTF;
    }

    public void setTotalMember(RichInputText totalMember) {
        this.totalMember = totalMember;
    }

    public RichInputText getTotalMember() {
        return totalMember;
    }

    public void setAggQuotePlanLbl(RichOutputLabel aggQuotePlanLbl) {
        this.aggQuotePlanLbl = aggQuotePlanLbl;
    }

    public RichOutputLabel getAggQuotePlanLbl() {
        return aggQuotePlanLbl;
    }

    public void setAggQuotePlan(RichInputText aggQuotePlan) {
        this.aggQuotePlan = aggQuotePlan;
    }

    public RichInputText getAggQuotePlan() {
        return aggQuotePlan;
    }

    public void setDependantDialog(RichDialog dependantDialog) {
        this.dependantDialog = dependantDialog;
    }

    public RichDialog getDependantDialog() {
        return dependantDialog;
    }

    public String showJointMemPop() {        // Add event code here...
      BigDecimal dtyCode=new BigDecimal("1003"); 
      this.session.setAttribute("DepTypeCode",dtyCode);
        dependantDialog.setTitle("Joint Member Details");
        //GlobalCC.showPopup("lmsgroup:JointPopup");
        GlobalCC.showPopup("lmsgroup:saveinfo");      
        return null;
    }

  public void setEarnPrd(RichSelectOneChoice earnPrd) {
    this.earnPrd = earnPrd;
  }

  public RichSelectOneChoice getEarnPrd() {
    return earnPrd;
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

    public void setBuiltIn(RichSelectOneChoice builtIn) {
        this.builtIn = builtIn;
    }

    public RichSelectOneChoice getBuiltIn() {
        return builtIn;
    }

    public void setAccelerator(RichSelectOneChoice accelerator) {
        this.accelerator = accelerator;
    }

    public RichSelectOneChoice getAccelerator() {
        return accelerator;
    }
  public String AssignSBUQuote() {
         DCIteratorBinding dciter =
             ADFUtils.findIterator("FindSBUDetailsIterator");
         RowKeySet set = this.SBUOneLOV.getSelectedRowKeys();
         Iterator rowKeySetIter = set.iterator();

         while (rowKeySetIter.hasNext()) {
             List l = (List)rowKeySetIter.next();
             Key key = (Key)l.get(0);
             dciter.setCurrentRowWithKey(key.toStringFormat(true));
             Row r = dciter.getCurrentRow();

           this.session.setAttribute("coverageAreaCode", r.getAttribute("COVERAGE_AREA_CODE"));
           this.session.setAttribute("coverageArea", r.getAttribute("COVERAGE_AREA"));
           this.session.setAttribute("spokeCode", r.getAttribute("SPOKE_CODE"));
           //this.session.setAttribute("spoke", r.getAttribute("SPOKE"));
           this.session.setAttribute("sbuCode", r.getAttribute("SBU_CODE"));
           //this.session.setAttribute("sbuName", r.getAttribute("SBU"));
           
           this.sbuOneDisplay.setValue(r.getAttribute("COVERAGE_AREA"));
         }

         return null;
     }
  public String AssignLocQuote() {
         DCIteratorBinding dciter =
             ADFUtils.findIterator("FindOrgLocationsDetailsIterator");
         RowKeySet set = this.locOneLOV.getSelectedRowKeys();
         Iterator rowKeySetIter = set.iterator();

         while (rowKeySetIter.hasNext()) {
             List l = (List)rowKeySetIter.next();
             Key key = (Key)l.get(0);
             dciter.setCurrentRowWithKey(key.toStringFormat(true));
             Row r = dciter.getCurrentRow();

           this.session.setAttribute("location", r.getAttribute("LOCATION"));
           this.session.setAttribute("locationCode", r.getAttribute("LOCATION_CODE"));
           //this.session.setAttribute("organization", r.getAttribute("ORGANIZATION"));
           
           this.locOneDisplay.setValue(r.getAttribute("LOCATION"));
         }

         return null;
     }

  public void setSBUOneLOV(RichTable SBUOneLOV) {
      this.SBUOneLOV = SBUOneLOV;
  }

  public RichTable getSBUOneLOV() {
      return this.SBUOneLOV;
  }
  public void setSbuOneDisplay(RichInputText sbuOneDisplay) {
    this.sbuOneDisplay = sbuOneDisplay;
  }

  public RichInputText getSbuOneDisplay() {
    return sbuOneDisplay;
  }

  public void setLocOneLOV(RichTable locOneLOV) {
    this.locOneLOV = locOneLOV;
  }

  public RichTable getLocOneLOV() {
    return locOneLOV;
  }

  public void setLocOneDisplay(RichInputText locOneDisplay) {
    this.locOneDisplay = locOneDisplay;
  }

  public RichInputText getLocOneDisplay() {
    return locOneDisplay;
  }


    public void setDjntMemNo(RichInputText djntMemNo) {
        this.djntMemNo = djntMemNo;
    }

    public RichInputText getDjntMemNo() {
        return djntMemNo;
    }

    public void setDjntSurname(RichInputText djntSurname) {
        this.djntSurname = djntSurname;
    }

    public RichInputText getDjntSurname() {
        return djntSurname;
    }

    public void setDjntOtherNames(RichInputText djntOtherNames) {
        this.djntOtherNames = djntOtherNames;
    }

    public RichInputText getDjntOtherNames() {
        return djntOtherNames;
    }

    public void setDjntSex(RichSelectOneChoice djntSex) {
        this.djntSex = djntSex;
    }

    public RichSelectOneChoice getDjntSex() {
        return djntSex;
    }

    public void setDjntIDNo(RichInputText djntIDNo) {
        this.djntIDNo = djntIDNo;
    }

    public RichInputText getDjntIDNo() {
        return djntIDNo;
    }

    public void setDjntDOB(RichInputDate djntDOB) {
        this.djntDOB = djntDOB;
    }

    public RichInputDate getDjntDOB() {
        return djntDOB;
    }

    public void setDpinNo(RichInputText dpinNo) {
        this.dpinNo = dpinNo;
    }

    public RichInputText getDpinNo() {
        return dpinNo;
    }

    public void setDjAddress(RichInputText djAddress) {
        this.djAddress = djAddress;
    }

    public RichInputText getDjAddress() {
        return djAddress;
    }

    public void setDjntPinNo(RichInputText djntPinNo) {
        this.djntPinNo = djntPinNo;
    }

    public RichInputText getDjntPinNo() {
        return djntPinNo;
    }

    public void setDjntAddress(RichInputText djntAddress) {
        this.djntAddress = djntAddress;
    }

    public RichInputText getDjntAddress() {
        return djntAddress;
    }
    public String selectCurrency() {
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
        System.out.println("Symbol="+r.getAttribute("cur_symbol"));
        session.setAttribute("cur_symbol", r.getAttribute("cur_symbol"));
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.currencyTF);
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
}
