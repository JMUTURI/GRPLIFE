package LMSG.view.Accounts;

import LMSG.view.Base.ADFUtils;

import LMSG.view.Base.GlobalCC;

import LMSG.view.Base.LOVCC;
import LMSG.view.TableTypes.PolicyClient;
import LMSG.view.TableTypes.PolicyCoinsurers;
import LMSG.view.TableTypes.memberRiders;
import LMSG.view.TableTypes.policyLoading;
import LMSG.view.TableTypes.policyMemberLoading;
import LMSG.view.connect.DBConnector;

import com.Ostermiller.util.CSVParser;

import java.io.InputStream;
import java.io.InputStreamReader;

import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.FacesContext;

import javax.faces.event.ValueChangeEvent;

import javax.servlet.http.HttpSession;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.data.RichTable;

import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputFile;
import oracle.adf.view.rich.component.rich.input.RichInputNumberSpinbox;
import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;

import oracle.adf.view.rich.component.rich.input.RichSelectOneRadio;
import oracle.adf.view.rich.component.rich.layout.RichPanelBox;

import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.output.RichOutputLabel;
import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.Key;
import oracle.jbo.Row;

import oracle.jbo.uicli.binding.JUCtrlValueBinding;

import oracle.jdbc.OracleTypes;

import oracle.sql.ARRAY;

import oracle.sql.ArrayDescriptor;

import org.apache.myfaces.trinidad.model.RowKeySet;
import org.apache.myfaces.trinidad.model.UploadedFile;
import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

public class LoadPoliciesManip {
    private RichTable proposersLOV;
    private RichInputText proposerDisplay;
    private RichTable productsLOV;
    private RichInputText undProdDisplay;
    private RichTable branchesLOV;
    private RichInputText branchesDisplay;
    private RichTable agentDisplayLOV;
    private RichInputText agentsDisplay;
    private RichTable masksLOV;
    private RichInputText maskDisplay;
    private RichInputText policyNo;
    private RichInputDate commenceDate;
    private RichInputDate renewalDate;
    private RichInputDate nextRenewalDate;
    private RichSelectOneChoice coinsurance;
    private RichInputText coinShare;
    private RichInputText noMembers;
    private RichInputText totSA;
    private RichInputText totPrem;
    private RichInputText totPremPaid;
    private RichInputText outsPrem;
    private RichInputText commRate;
    private RichInputText vatRate;
    private RichInputText fclAmount;
    private RichInputText category;
    private RichInputText multiPrd;
    private RichSelectOneChoice freqPayment;
    private RichSelectOneChoice durationType;
    private RichPanelBox policiesTab;
    private RichSelectOneRadio loadOptions;
    private RichInputText policyDesc;
    private RichTable policyLOV;
    private HtmlPanelGrid policiesPanel;
    private RichCommandButton nextButton;
    private RichCommandButton prevButton;
    private RichPanelBox membersTab;

    private UploadedFile uploadedFile;
    private String filename;
    private long filesize;
    private String filetype;

    private UploadedFile uploadedFile2;
    private String filename2;
    private long filesize2;
    private String filetype2;
    private RichInputFile upFile2;

    private RichTable membersTable;
    private RichInputFile upFile;
    private RichCommandButton loadPolicy;
    private RichCommandButton deletePolicy;
    private HtmlPanelGrid coinsurerPanel;
    private RichPanelBox coinsRiderPanel;
    private RichTable coinsurersTable;
    private RichTable ridersTable;
    private RichInputText coinsurerLabel;
    private RichTable coinsurersLOV;
    private RichInputNumberSpinbox coinsShare;
    private RichTable loadedPoliciesLOV;
    private RichInputText loadedPolDesc;
    private HtmlPanelGrid loadedPoliciesPanel;
    private HtmlPanelGrid polDetailsPanel;
    private RichOutputLabel pensRegistered;
    private RichOutputLabel pensionRegisteredLab;
    private RichSelectOneChoice pensionRegisteredCombo;
    private RichOutputLabel pensRegNoLab;
    private RichInputText pensRegNoTF;
    private RichOutputLabel pensTypeLab;
    private RichSelectOneChoice pensTypeCombo;
    private RichOutputLabel pensContriTypeLab;
    private RichSelectOneChoice pensContriTypeCombo;
    private RichOutputLabel empyeContriRate;
    private RichInputText empyeContriRateTF;
    private RichOutputLabel empyrContriRateLab;
    private RichInputText empyrContriRateTF;
    private RichOutputLabel maleRetireAgeLab;
    private RichInputText maleRetireAgeTF;
    private RichOutputLabel femaleRetireAgeLabel;
    private RichInputText femaleRetireAgeTF;
    private RichOutputLabel pensCommRateLab;
    private RichInputText pensCommRateTF;
    private RichOutputLabel pensGuaranPRDLab;
    private RichInputText pensGuaranPRDTF;
    private RichOutputLabel pensEarningEscLab;
    private RichInputText pensEarningsEscTF;
    private RichOutputLabel pensValuationYrLab;
    private RichInputText pensValuationLab;
    private RichOutputLabel pensValuationYrTF;
    private RichOutputLabel aggregatePolLab;
    private RichSelectOneChoice aggregatePolicyCombo;
    private RichOutputLabel fundBalLab;
    private RichInputText fundBalTF;
    private RichOutputLabel loanCalcLab;
    private RichSelectOneChoice loanCalcTypeCombo;
    private RichOutputLabel termLab;
    private RichSelectOneChoice termCombo;
    private RichOutputLabel annuityPaymentStructLab;
    private RichSelectOneChoice annuityPaymentStructCombo;
    private RichOutputLabel benefitInvRateLab;
    private RichInputText benefitInvRateTF;
    private RichOutputLabel payoutRateLab;
    private RichInputText payoutRateTF;
    private RichOutputLabel adminChargeLab;
    private RichInputText adminChargeTF;
    private RichOutputText schemeLegalAgeLab;
    private RichInputText schemeLegalAgeTF;
    private RichOutputLabel earningsSALab;
    private RichOutputLabel totPremLab;
    private RichOutputLabel toPremPaidLab;
    private RichOutputLabel outsPremLab;
    private RichSelectOneChoice pensPaymentFreq;
    private RichOutputLabel pensPaymentFreqLab;
    private RichOutputLabel freqPaymentLab;
    private RichOutputLabel commRateLab;
    private RichInputFile upload_policies;
    private RichTable policiesTable;
    private RichTable memDataTable;
    private RichPanelBox coinsurerTab;
    private RichPanelBox clientTab;
    private RichInputFile upClientFile;
    private RichTable loadedClientTable;
    private RichInputFile upFileCoin;


    public LoadPoliciesManip() {
        super();
    }

    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);


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

    public String AttachProducts() {
        String productType = "";
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findProductsIterator");
        RowKeySet set = productsLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
            undProdDisplay.setValue(r.getAttribute("prodshtDesc"));
            session.setAttribute("ProductCode", r.getAttribute("prodCode"));
            session.setAttribute("productType", r.getAttribute("prodType"));
            productType = (String)session.getAttribute("productType");
        }
        //System.out.println("Product Type "+productType);
        try {
            //Renders the pension product fields
            if (productType.equals("PENS")) {
                commRateLab.setRendered(false);
                commRate.setRendered(false);
                freqPaymentLab.setRendered(false);
                freqPayment.setRendered(false);
                pensCommRateLab.setRendered(true);
                pensCommRateTF.setRendered(true);
                pensPaymentFreqLab.setRendered(true);
                pensPaymentFreq.setRendered(true);
                pensionRegisteredLab.setRendered(true);
                pensionRegisteredCombo.setRendered(true);
                pensRegNoLab.setRendered(true);
                pensRegNoTF.setRendered(true);
                pensTypeLab.setRendered(true);
                pensTypeCombo.setRendered(true);
                pensContriTypeLab.setRendered(true);
                pensContriTypeCombo.setRendered(true);
                empyeContriRate.setRendered(true);
                empyeContriRateTF.setRendered(true);
                maleRetireAgeLab.setRendered(true);
                maleRetireAgeTF.setRendered(true);
                femaleRetireAgeLabel.setRendered(true);
                femaleRetireAgeTF.setRendered(true);
                pensGuaranPRDLab.setRendered(true);
                pensGuaranPRDTF.setRendered(true);
                pensEarningEscLab.setRendered(true);
                pensEarningsEscTF.setRendered(true);
                pensValuationLab.setRendered(true);
                pensValuationYrTF.setRendered(true);
                aggregatePolLab.setRendered(true);
                aggregatePolicyCombo.setRendered(true);
                fundBalLab.setRendered(true);
                fundBalTF.setRendered(true);
            } else if (productType.equalsIgnoreCase("LOAN")) {
                loanCalcLab.setRendered(true);
                loanCalcTypeCombo.setRendered(true);
            }
            //Render education product fields
            else if (productType.equalsIgnoreCase("EDUC")) {
                termLab.setRendered(true);
                termCombo.setRendered(true);
            }
            //Displays the Annuity product fields
            else if (productType.equalsIgnoreCase("ANN")) {
                maleRetireAgeLab.setRendered(true);
                maleRetireAgeTF.setRendered(true);
                pensGuaranPRDLab.setRendered(true);
                pensGuaranPRDTF.setRendered(true);
            } else if (productType.equalsIgnoreCase("EARN")) {
                commRateLab.setRendered(true);
                commRate.setRendered(true);
                freqPaymentLab.setRendered(true);
                freqPayment.setRendered(true);
                pensCommRateLab.setRendered(false);
                pensCommRateTF.setRendered(false);
                pensPaymentFreqLab.setRendered(false);
                pensPaymentFreq.setRendered(false);
                pensionRegisteredLab.setRendered(false);
                pensionRegisteredCombo.setRendered(false);
                pensRegNoLab.setRendered(false);
                pensRegNoTF.setRendered(false);
                pensTypeLab.setRendered(false);
                pensTypeCombo.setRendered(false);
                pensContriTypeLab.setRendered(false);
                pensContriTypeCombo.setRendered(false);
                empyeContriRate.setRendered(false);
                empyeContriRateTF.setRendered(false);
                maleRetireAgeLab.setRendered(false);
                maleRetireAgeTF.setRendered(false);
                femaleRetireAgeLabel.setRendered(false);
                femaleRetireAgeTF.setRendered(false);
                pensGuaranPRDLab.setRendered(false);
                pensGuaranPRDTF.setRendered(false);
                pensEarningEscLab.setRendered(false);
                pensEarningsEscTF.setRendered(false);
                pensValuationLab.setRendered(false);
                pensValuationYrTF.setRendered(false);
                aggregatePolLab.setRendered(false);
                aggregatePolicyCombo.setRendered(false);
                fundBalLab.setRendered(false);
                fundBalTF.setRendered(false);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
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
            branchesDisplay.setValue(r.getAttribute("BRN_SHT_DESC"));
            //LOVCC.branchCode=(BigDecimal)r.getAttribute("BRN_CODE");
            session.setAttribute("branchCode", r.getAttribute("BRN_CODE"));


        }
        return null;
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
            agentsDisplay.setValue(r.getAttribute("AGN_SHT_DESC"));

        }
        return null;
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


        }
        return null;
    }

    public String PopulatePolicy() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findPoliciesToLoadIterator");
        RowKeySet set = policyLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
            policyDesc.setValue(r.getAttribute("LGPL_POL_NO"));
            session.setAttribute("policyNumber",
                                 r.getAttribute("LGPL_POL_NO"));

            session.setAttribute("lgplCode", r.getAttribute("LGPL_CODE"));
            proposerDisplay.setValue(r.getAttribute("LGPL_CLIENT"));
            noMembers.setValue(r.getAttribute("LGPL_NO_MEM"));
            coinShare.setValue(r.getAttribute("LGPL_SHARE"));
            String Val = (String)r.getAttribute("LGPL_SHARE");
            if (Val == null) {
                coinsurance.setValue("N");
                coinShare.setValue("100");
                coinShare.setDisabled(true);
            } else if (!Val.equalsIgnoreCase("100")) {
                coinsurance.setValue("Y");
                coinShare.setDisabled(false);
            } else {
                coinsurance.setValue("N");
                coinShare.setDisabled(true);
            }
            commenceDate.setValue(r.getAttribute("LGPL_COMMENC_DT"));
            renewalDate.setValue(r.getAttribute("LGPL_RENEW_DT"));
            nextRenewalDate.setValue(r.getAttribute("LGPL_NEXT_REN_DT"));
            maskDisplay.setValue(r.getAttribute("LGPL_RATES"));
            totSA.setValue(r.getAttribute("LGPL_TOT_SA"));
            totPrem.setValue(r.getAttribute("LGPL_TOT_PREM"));
            totPremPaid.setValue(r.getAttribute("LGPL_TOT_PREM_PAID"));
            outsPrem.setValue(r.getAttribute("LGPL_OUTS_PREM"));
            undProdDisplay.setValue(r.getAttribute("LGPL_PROD_NAME"));
            agentsDisplay.setValue(r.getAttribute("LGPL_AGENT"));
            policyNo.setValue(r.getAttribute("LGPL_POL_NO"));
            branchesDisplay.setValue(r.getAttribute("LGPL_BRANCH"));
            commRate.setValue(r.getAttribute("LGPL_COMM_RATE"));
            vatRate.setValue(r.getAttribute("LGPL_VAT_RATE"));
            durationType.setValue(r.getAttribute("LGPL_DURATION"));
            freqPayment.setValue(r.getAttribute("LGPL_FREQ_OF_PAY"));
            category.setValue(r.getAttribute("LGPL_POL_CATEGORY"));
            multiPrd.setValue(r.getAttribute("LGPL_MULTI_EARNINGS"));
            fclAmount.setValue(r.getAttribute("LGPL_FCL"));

            loadPolicy.setDisabled(false);
            deletePolicy.setDisabled(false);

        }
        return null;
    }

    public String findPoliciesSelected() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindPolicyLoadedTransactionsIterator");
        RowKeySet set = loadedPoliciesLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();

        //System.out.println(1);
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
            loadedPolDesc.setValue(r.getAttribute("LTR_POL_POLICY_NO"));
            session.setAttribute("policyNumber",
                                 r.getAttribute("LTR_POL_POLICY_NO"));
            session.setAttribute("endorsementCode",
                                 r.getAttribute("LTR_ENDR_CODE"));
            session.setAttribute("policyCode", r.getAttribute("LTR_POL_CODE"));
            session.setAttribute("transactionNumber",
                                 r.getAttribute("LTR_TRANS_NO"));

            String Value = (String)r.getAttribute("LTR_TRANS_AUTHORISED");
            if (Value == null) {
                session.setAttribute("Authorised", "N");
            } else if (Value.equalsIgnoreCase("A")) {
                session.setAttribute("Authorised", "Y");
            } else {
                session.setAttribute("Authorised", "N");
            }
            //LOVCC.PrpCode=(BigDecimal)r.getAttribute("prp_code");
            session.setAttribute("prpCode", r.getAttribute("prp_code"));

        }

        return null;
    }

    public String ResetComponents() {
        try {
            session.setAttribute("lgplCode", null);
            proposerDisplay.setValue(null);
            noMembers.setValue(null);
            coinShare.setValue(null);
            coinsurance.setValue("N");
            coinShare.setValue("100");
            coinShare.setDisabled(true);
            commenceDate.setValue(null);
            renewalDate.setValue(null);
            nextRenewalDate.setValue(null);
            maskDisplay.setValue(null);
            totSA.setValue(null);
            totPrem.setValue(null);
            totPremPaid.setValue(null);
            outsPrem.setValue(null);
            undProdDisplay.setValue(null);
            agentsDisplay.setValue(null);
            policyNo.setValue(null);
            branchesDisplay.setValue(null);
            commRate.setValue(null);
            vatRate.setValue(null);
            durationType.setValue(null);
            freqPayment.setValue(null);
            category.setValue(null);
            multiPrd.setValue(null);
            fclAmount.setValue(null);
            policyDesc.setValue(null);

            loadPolicy.setDisabled(true);
            deletePolicy.setDisabled(true);

            loadedPolDesc.setValue(null);
            session.setAttribute("policyNumber", null);
            session.setAttribute("endorsementCode", null);
            session.setAttribute("policyCode", null);
            session.setAttribute("transactionNumber", null);
            session.setAttribute("prpCode", null);

            ADFUtils.findIterator("findPolMembersToLoad").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(membersTable);

            ADFUtils.findIterator("findPoliciesToLoadIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(policyLOV);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
            e.printStackTrace();
        }
        return null;
    }

    public String NextTransition() {
        Connection conn = null;
        CallableStatement cst = null;
        try {
            if (policiesTab.isRendered()) {

                String ActionValue = (String)session.getAttribute("action");
                if (ActionValue == null) {
                    GlobalCC.INFORMATIONREPORTING("Select A Action.");
                    return null;
                } else if (ActionValue.equalsIgnoreCase("V")) { //View the Loaded Policy...
                    BigDecimal Endorsement =
                        (BigDecimal)session.getAttribute("endorsementCode");
                    if (Endorsement == null) {
                        GlobalCC.INFORMATIONREPORTING("Select A Loaded Policy.");
                        return null;
                    }
                    session.setAttribute("loadedPolEndorsement", "Y");
                    GlobalCC.RedirectPage("/g_undwrt.jspx");
                }

                //Update Policy Data.
                String Query =
                    "begin LMS_GRP_LOAD_DATA.create_loaded_policy(?,?,?);end;";
                DBConnector MyConn = new DBConnector();
                conn = MyConn.getDatabaseConn();
                cst = conn.prepareCall(Query);

                java.sql.Date CommenceDate = null;
                if (commenceDate.getValue() == null) {

                } else {
                    CommenceDate =
                            new java.sql.Date(((java.util.Date)commenceDate.getValue()).getTime());
                }
                java.sql.Date RenewalDate = null;
                if (renewalDate.getValue() == null) {

                } else {
                    RenewalDate =
                            new java.sql.Date(((java.util.Date)renewalDate.getValue()).getTime());
                }
                java.sql.Date NextRenewalDate = null;
                if (nextRenewalDate.getValue() == null) {

                } else {
                    NextRenewalDate =
                            new java.sql.Date(((java.util.Date)nextRenewalDate.getValue()).getTime());
                }

                List ReinstInfo = new LinkedList();
                ARRAY array = null;

                ArrayDescriptor descriptor =
                    ArrayDescriptor.createDescriptor("LMS_POLICIES_LOADING_TAB",
                                                     conn);

                policyLoading pn = new policyLoading();
                if (proposerDisplay.getValue() == null) {
                    pn.setLGPL_CLIENT(null);
                } else {
                    pn.setLGPL_CLIENT(proposerDisplay.getValue().toString());
                }
                if (noMembers.getValue() == null) {
                    pn.setLGPL_NO_MEM(null);
                } else {
                    pn.setLGPL_NO_MEM(new BigDecimal(noMembers.getValue().toString()));
                }
                if (coinShare.getValue() == null) {
                    pn.setLGPL_SHARE(null);
                } else {
                    pn.setLGPL_SHARE(coinShare.getValue().toString());
                }
                pn.setLGPL_COMMENC_DT(CommenceDate);
                pn.setLGPL_RENEW_DT(RenewalDate);
                pn.setLGPL_NEXT_REN_DT(NextRenewalDate);
                if (maskDisplay.getValue() == null) {
                    pn.setLGPL_RATES(null);
                } else {
                    pn.setLGPL_RATES(maskDisplay.getValue().toString());
                }
                if (totSA.getValue() == null) {
                    pn.setLGPL_TOT_SA(null);
                } else {
                    pn.setLGPL_TOT_SA(new BigDecimal(totSA.getValue().toString()));
                }
                if (totPrem.getValue() == null) {
                    pn.setLGPL_TOT_PREM(null);
                } else {
                    pn.setLGPL_TOT_PREM(new BigDecimal(totPrem.getValue().toString()));
                }
                if (totPremPaid.getValue() == null) {
                    pn.setLGPL_TOT_PREM_PAID(null);
                } else {
                    pn.setLGPL_TOT_PREM_PAID(new BigDecimal(totPremPaid.getValue().toString()));
                }
                if (outsPrem.getValue() == null) {
                    pn.setLGPL_OUTS_PREM(null);
                } else {
                    pn.setLGPL_OUTS_PREM(new BigDecimal(outsPrem.getValue().toString()));
                }
                if (undProdDisplay.getValue() == null) {
                    pn.setLGPL_PROD_NAME(null);
                } else {
                    pn.setLGPL_PROD_NAME(undProdDisplay.getValue().toString());
                }
                if (agentsDisplay.getValue() == null) {
                    pn.setLGPL_AGENT_NAME(null);
                } else {
                    pn.setLGPL_AGENT_NAME(agentsDisplay.getValue().toString());
                }
                if (agentsDisplay.getValue() == null) {
                    pn.setLGPL_AGENT(null);
                } else {
                    pn.setLGPL_AGENT(agentsDisplay.getValue().toString());
                }
                if (policyNo.getValue() == null) {
                    pn.setLGPL_POL_NO(null);
                } else {
                    pn.setLGPL_POL_NO(policyNo.getValue().toString());
                }
                if (branchesDisplay.getValue() == null) {
                    pn.setLGPL_BRANCH(null);
                } else {
                    pn.setLGPL_BRANCH(branchesDisplay.getValue().toString());
                }
                if (commRate.getValue() == null) {
                    pn.setLGPL_COMM_RATE(null);
                } else {
                    pn.setLGPL_COMM_RATE(commRate.getValue().toString());
                }
                if (vatRate.getValue() == null) {
                    pn.setLGPL_VAT_RATE(null);
                } else {
                    pn.setLGPL_VAT_RATE(vatRate.getValue().toString());
                }
                if (durationType.getValue() == null) {
                    pn.setLGPL_DURATION(null);
                } else {
                    pn.setLGPL_DURATION(durationType.getValue().toString());
                }
                if (durationType.getValue() == null) {
                    pn.setLGPL_FREQ_OF_PAY(null);
                } else {
                    pn.setLGPL_FREQ_OF_PAY(durationType.getValue().toString());
                }
                if (freqPayment.getValue() == null) {
                    pn.setLGPL_FREQ_OF_PAY(null);
                } else {
                    pn.setLGPL_FREQ_OF_PAY(freqPayment.getValue().toString());
                }
                if (category.getValue() == null) {
                    pn.setLGPL_POL_CATEGORY(null);
                } else {
                    pn.setLGPL_POL_CATEGORY(category.getValue().toString());
                }
                if (multiPrd.getValue() == null) {
                    pn.setLGPL_MULTI_EARNINGS(null);
                } else {
                    pn.setLGPL_MULTI_EARNINGS(new BigDecimal(multiPrd.getValue().toString()));
                }
                if (fclAmount.getValue() == null) {
                    pn.setLGPL_FCL(null);
                } else {
                    pn.setLGPL_FCL(new BigDecimal(fclAmount.getValue().toString()));
                }
                if (pensCommRateTF.getValue() == null) {
                    pn.setLGPL_PENS_COMM_RATE(null);
                } else {
                    pn.setLGPL_PENS_COMM_RATE(new BigDecimal(pensCommRateTF.getValue().toString()));
                }
                if (pensPaymentFreq.getValue() == null) {
                    pn.setLGPL_PENS_PAYMENT_FREQ(null);
                } else {
                    pn.setLGPL_PENS_PAYMENT_FREQ(pensPaymentFreq.getValue().toString());
                }
                if (pensionRegisteredCombo.getValue() == null) {
                    pn.setLGPL_REGISTERED(null);
                } else {
                    pn.setLGPL_REGISTERED(pensionRegisteredCombo.getValue().toString());
                }
                if (pensRegNoTF.getValue() == null) {
                    pn.setLGPL_REG_NO(null);
                } else {
                    pn.setLGPL_REG_NO(pensRegNoTF.getValue().toString());
                }
                if (pensTypeCombo.getValue() == null) {
                    pn.setLGPL_PENS_TYPE(null);
                } else {
                    pn.setLGPL_PENS_TYPE(pensTypeCombo.getValue().toString());
                }
                if (pensContriTypeCombo.getValue() == null) {
                    pn.setLGPL_CONTRI_TYPE(null);
                } else {
                    pn.setLGPL_CONTRI_TYPE(pensContriTypeCombo.getValue().toString());
                }
                if (empyeContriRateTF.getValue() == null) {
                    pn.setLGPL_EMYE_CONTRI(null);
                } else {
                    pn.setLGPL_EMYE_CONTRI(empyeContriRateTF.getValue().toString());
                }
                if (empyrContriRateTF.getValue() == null) {
                    pn.setLGPL_EMYR_CONTRI(null);
                } else {
                    pn.setLGPL_EMYR_CONTRI(empyrContriRateTF.getValue().toString());
                }
                if (maleRetireAgeTF.getValue() == null) {
                    pn.setLGPL_MALE_NRD(null);
                } else {
                    pn.setLGPL_MALE_NRD(maleRetireAgeTF.getValue().toString());
                }
                if (femaleRetireAgeTF.getValue() == null) {
                    pn.setLGPL_FEMALE_NRD(null);
                } else {
                    pn.setLGPL_FEMALE_NRD(femaleRetireAgeTF.getValue().toString());
                }
                if (pensGuaranPRDTF.getValue() == null) {
                    pn.setLGPL_GRNTD_PRD(null);
                } else {
                    pn.setLGPL_GRNTD_PRD(pensGuaranPRDTF.getValue().toString());
                }
                if (pensEarningsEscTF.getValue() == null) {
                    pn.setLGPL_EARNINGS_ESC(null);
                } else {
                    pn.setLGPL_EARNINGS_ESC(pensEarningsEscTF.getValue().toString());
                }
                ReinstInfo.add(pn);

                array = new ARRAY(descriptor, conn, ReinstInfo.toArray());

                cst.setArray(1, array);
                cst.setString(2, (String)session.getAttribute("action"));
                String Action = (String)session.getAttribute("action");
                if (Action.equalsIgnoreCase("A")) {
                    cst.registerOutParameter(3, OracleTypes.DECIMAL);
                } else {
                    cst.setBigDecimal(3,
                                      (BigDecimal)session.getAttribute("lgplCode"));
                }

                cst.execute();
                if (Action.equalsIgnoreCase("A")) {
                    loadPolicy.setDisabled(false);
                    deletePolicy.setDisabled(false);
                    session.setAttribute("lgplCode", cst.getBigDecimal(3));
                }
                cst.close();
                conn.close();

                session.setAttribute("policyNumber",
                                     policyNo.getValue().toString());

                prevButton.setRendered(true);
                //nextButton.setText("Finish");
                membersTab.setRendered(true);
                policiesTab.setRendered(false);
                coinsRiderPanel.setRendered(false);

                ADFUtils.findIterator("findPolMembersToLoadIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(membersTable);

            } else if (membersTab.isRendered()) {
                coinsRiderPanel.setRendered(true);
                prevButton.setRendered(true);
                nextButton.setRendered(false);
                membersTab.setRendered(false);
                policiesTab.setRendered(false);

                if (coinsurance.getValue() == null) {
                    coinsurerPanel.setRendered(false);
                } else if (coinsurance.getValue().toString().equalsIgnoreCase("Y")) {
                    coinsurerPanel.setRendered(true);
                } else {
                    coinsurerPanel.setRendered(false);
                }

                if(session.getAttribute("policyNumber")!=null){
                ADFUtils.findIterator("findPolCoinsToLoadIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(coinsurersTable);
                }

                ADFUtils.findIterator("findPolRidersToLoadIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(ridersTable);
            }
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
            e.printStackTrace();
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
        return null;
    }

    public String PrevTransition() {
        try {
            if (membersTab.isRendered()) {
                prevButton.setRendered(false);
                nextButton.setText("Next");
                membersTab.setRendered(false);
                policiesTab.setRendered(true);
                coinsRiderPanel.setRendered(false);
                String Action = (String)session.getAttribute("action");
                if (Action.equalsIgnoreCase("A")) {
                    loadPolicy.setDisabled(true);
                }
            } else if (coinsRiderPanel.isRendered()) {
                prevButton.setRendered(true);
                nextButton.setRendered(true);
                membersTab.setRendered(true);
                policiesTab.setRendered(false);
                coinsRiderPanel.setRendered(false);
            }
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
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

                session.setAttribute("coAgnCode",
                                     r.getAttribute("CO_agn_code"));
                coinsurerLabel.setValue(r.getAttribute("CO_agn_name"));

                AdfFacesContext.getCurrentInstance().addPartialTarget(coinsurerLabel);

                // Hide Popup
                GlobalCC.hidePopup("lmsgroup:p2");
            }


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return null;
    }

    public String AddCoinsurer() {
        try {
            session.setAttribute("coAgnCode", null);
            session.setAttribute("lgcaCode", null);
            coinsurerLabel.setValue(null);
            coinsShare.setValue(null);
            session.setAttribute("action2", "A");
            // Show Popup
            GlobalCC.showPopup("lmsgroup:p1");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String EditCoinsurer() {
        try {
            // Add event code here...
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findPolCoinsToLoadIterator");
            RowKeySet set = coinsurersTable.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                session.setAttribute("lgcaCode", r.getAttribute("LGCA_CODE"));
                session.setAttribute("coAgnCode",
                                     r.getAttribute("LGCA_AGN_CODE"));
                coinsurerLabel.setValue(r.getAttribute("LGCA_COINSURER"));
                coinsShare.setValue(r.getAttribute("LGCA_COIN_SHARE"));
                session.setAttribute("action2", "E");

                // Show Popup
                GlobalCC.showPopup("lmsgroup:p1");
            }


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return null;
    }

    public String DeleteCoinsurer() {
        try {
            // Add event code here...
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findPolCoinsToLoadIterator");
            RowKeySet set = coinsurersTable.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                session.setAttribute("lgcaCode", r.getAttribute("LGCA_CODE"));
                session.setAttribute("coAgnCode",
                                     r.getAttribute("LGCA_AGN_CODE"));
                coinsurerLabel.setValue(r.getAttribute("LGCA_COINSURER"));
                coinsShare.setValue(r.getAttribute("LGCA_COIN_SHARE"));
                session.setAttribute("action2", "D");

                // Show Popup
                SaveCoinsurer();
            }


        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

        return null;
    }

    public String SaveCoinsurer() {
        Connection conn = null;
        CallableStatement cst = null;
        try {
            if (coinsurerLabel.getValue() == null) {
                GlobalCC.INFORMATIONREPORTING("Select A Coinsurer.");
                return null;
            }
            if (coinsShare.getValue() == null) {
                GlobalCC.INFORMATIONREPORTING("Select A Coinsurer Share.");
                return null;
            }
            String Query =
                "begin LMS_GRP_LOAD_DATA.add_loaded_coinsurer(?,?,?,?,?,?);end;";
            DBConnector MyConn = new DBConnector();
            conn = MyConn.getDatabaseConn();
            cst = conn.prepareCall(Query);
            cst.setString(1, (String)session.getAttribute("action2"));
            cst.setString(2, (String)session.getAttribute("policyNumber"));
            cst.setString(3, coinsurerLabel.getValue().toString());
            cst.setString(4, coinsShare.getValue().toString());
            cst.setBigDecimal(5,
                              (BigDecimal)session.getAttribute("coAgnCode"));
            cst.setBigDecimal(6, (BigDecimal)session.getAttribute("lgcaCode"));
            cst.execute();
            cst.close();
            conn.close();

            ADFUtils.findIterator("findPolCoinsToLoadIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(coinsurersTable);
            GlobalCC.hidePopup("lmsgroup:p1");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
        return null;
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

    public void setProductsLOV(RichTable productsLOV) {
        this.productsLOV = productsLOV;
    }

    public RichTable getProductsLOV() {
        return productsLOV;
    }

    public void setUndProdDisplay(RichInputText undProdDisplay) {
        this.undProdDisplay = undProdDisplay;
    }

    public RichInputText getUndProdDisplay() {
        return undProdDisplay;
    }

    public void setBranchesLOV(RichTable branchesLOV) {
        this.branchesLOV = branchesLOV;
    }

    public RichTable getBranchesLOV() {
        return branchesLOV;
    }

    public void setBranchesDisplay(RichInputText branchesDisplay) {
        this.branchesDisplay = branchesDisplay;
    }

    public RichInputText getBranchesDisplay() {
        return branchesDisplay;
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

    public void setPolicyNo(RichInputText policyNo) {
        this.policyNo = policyNo;
    }

    public RichInputText getPolicyNo() {
        return policyNo;
    }

    public void setCommenceDate(RichInputDate commenceDate) {
        this.commenceDate = commenceDate;
    }

    public RichInputDate getCommenceDate() {
        return commenceDate;
    }

    public void setRenewalDate(RichInputDate renewalDate) {
        this.renewalDate = renewalDate;
    }

    public RichInputDate getRenewalDate() {
        return renewalDate;
    }

    public void setNextRenewalDate(RichInputDate nextRenewalDate) {
        this.nextRenewalDate = nextRenewalDate;
    }

    public RichInputDate getNextRenewalDate() {
        return nextRenewalDate;
    }

    public void setCoinsurance(RichSelectOneChoice coinsurance) {
        this.coinsurance = coinsurance;
    }

    public RichSelectOneChoice getCoinsurance() {
        return coinsurance;
    }

    public void coinsuranceListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if (valueChangeEvent.getNewValue() != valueChangeEvent.getOldValue()) {
            if (coinsurance.getValue() == null) {
                coinShare.setValue("100");
                coinShare.setDisabled(true);
            } else if (coinsurance.getValue().toString().equalsIgnoreCase("Y")) {
                coinShare.setValue(null);
                coinShare.setDisabled(false);
            } else {
                coinShare.setValue("100");
                coinShare.setDisabled(true);
            }
        }
    }

    public void setCoinShare(RichInputText coinShare) {
        this.coinShare = coinShare;
    }

    public RichInputText getCoinShare() {
        return coinShare;
    }

    public void setNoMembers(RichInputText noMembers) {
        this.noMembers = noMembers;
    }

    public RichInputText getNoMembers() {
        return noMembers;
    }

    public void setTotSA(RichInputText totSA) {
        this.totSA = totSA;
    }

    public RichInputText getTotSA() {
        return totSA;
    }

    public void setTotPrem(RichInputText totPrem) {
        this.totPrem = totPrem;
    }

    public RichInputText getTotPrem() {
        return totPrem;
    }

    public void setTotPremPaid(RichInputText totPremPaid) {
        this.totPremPaid = totPremPaid;
    }

    public RichInputText getTotPremPaid() {
        return totPremPaid;
    }

    public void setOutsPrem(RichInputText outsPrem) {
        this.outsPrem = outsPrem;
    }

    public RichInputText getOutsPrem() {
        return outsPrem;
    }

    public void setCommRate(RichInputText commRate) {
        this.commRate = commRate;
    }

    public RichInputText getCommRate() {
        return commRate;
    }

    public void setVatRate(RichInputText vatRate) {
        this.vatRate = vatRate;
    }

    public RichInputText getVatRate() {
        return vatRate;
    }

    public void setFclAmount(RichInputText fclAmount) {
        this.fclAmount = fclAmount;
    }

    public RichInputText getFclAmount() {
        return fclAmount;
    }

    public void setCategory(RichInputText category) {
        this.category = category;
    }

    public RichInputText getCategory() {
        return category;
    }

    public void setMultiPrd(RichInputText multiPrd) {
        this.multiPrd = multiPrd;
    }

    public RichInputText getMultiPrd() {
        return multiPrd;
    }

    public void setFreqPayment(RichSelectOneChoice freqPayment) {
        this.freqPayment = freqPayment;
    }

    public RichSelectOneChoice getFreqPayment() {
        return freqPayment;
    }

    public void setDurationType(RichSelectOneChoice durationType) {
        this.durationType = durationType;
    }

    public RichSelectOneChoice getDurationType() {
        return durationType;
    }

    public void setPoliciesTab(RichPanelBox policiesTab) {
        this.policiesTab = policiesTab;
    }

    public RichPanelBox getPoliciesTab() {
        return policiesTab;
    }

    public void loadOptionListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if (valueChangeEvent.getNewValue() != valueChangeEvent.getOldValue()) {
            String Value = loadOptions.getValue().toString();
            if (Value == null) {
                session.setAttribute("action", "A");
            } else if (Value.equalsIgnoreCase("A")) {
                session.setAttribute("action", "A");
                policiesPanel.setRendered(false);
                loadedPoliciesPanel.setRendered(false);
                polDetailsPanel.setRendered(true);
                session.setAttribute("lgplCode", null);
            } else if (Value.equalsIgnoreCase("E")) {
                session.setAttribute("action", "E");
                ADFUtils.findIterator("findPoliciesToLoadIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(policyLOV);
                policiesPanel.setRendered(true);
                loadedPoliciesPanel.setRendered(false);
                polDetailsPanel.setRendered(true);
            } else if (Value.equalsIgnoreCase("L")) {
                session.setAttribute("action", "L");
                ADFUtils.findIterator("findPoliciesToLoadIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(policyLOV);
                policiesPanel.setRendered(true);
                loadedPoliciesPanel.setRendered(false);
                polDetailsPanel.setRendered(true);
            } else if (Value.equalsIgnoreCase("V")) {
                session.setAttribute("action", "V");
                ADFUtils.findIterator("FindPolicyLoadedTransactionsIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(loadedPoliciesLOV);
                policiesPanel.setRendered(false);
                loadedPoliciesPanel.setRendered(true);
                polDetailsPanel.setRendered(false);
            }
            ResetComponents();
        }
    }

    public void setLoadOptions(RichSelectOneRadio loadOptions) {
        this.loadOptions = loadOptions;
    }

    public RichSelectOneRadio getLoadOptions() {
        return loadOptions;
    }

    public void setPolicyDesc(RichInputText policyDesc) {
        this.policyDesc = policyDesc;
    }

    public RichInputText getPolicyDesc() {
        return policyDesc;
    }

    public void setPolicyLOV(RichTable policyLOV) {
        this.policyLOV = policyLOV;
    }

    public RichTable getPolicyLOV() {
        return policyLOV;
    }

    public void setPoliciesPanel(HtmlPanelGrid policiesPanel) {
        this.policiesPanel = policiesPanel;
    }

    public HtmlPanelGrid getPoliciesPanel() {
        return policiesPanel;
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

    public void setMembersTab(RichPanelBox membersTab) {
        this.membersTab = membersTab;
    }

    public RichPanelBox getMembersTab() {
        return membersTab;
    }

    public void fileChangeForMemberLoading(ValueChangeEvent valueChangeEvent) {

        if (valueChangeEvent.getNewValue() != valueChangeEvent.getOldValue()) {
            try {
                UploadedFile _file =
                    (UploadedFile)valueChangeEvent.getNewValue();
                this.uploadedFile = _file;
                this.filename = _file.getFilename();
                this.filesize = _file.getLength();
                this.filetype = _file.getContentType();

                processCSVForMembers(uploadedFile.getInputStream());
            } catch (Exception e) {
                GlobalCC.EXCEPTIONREPORTING(null, e);
            }
        }
    }

    public void fileChangeForRiderLoading(ValueChangeEvent valueChangeEvent) {

        if (valueChangeEvent.getNewValue() != valueChangeEvent.getOldValue()) {
            try {
                UploadedFile _file =
                    (UploadedFile)valueChangeEvent.getNewValue();
                this.uploadedFile2 = _file;
                this.filename2 = _file.getFilename();
                this.filesize2 = _file.getLength();
                this.filetype2 = _file.getContentType();

                processCSVForRiders(uploadedFile2.getInputStream());
            } catch (Exception e) {
                GlobalCC.EXCEPTIONREPORTING(null, e);
            }
        }
    }

    public void processCSVForMembers(InputStream csvFile) {
        // Parse the data, using http://ostermiller.org/utils/download.html
        String[][] csvvalues = null;
        Connection conn = null;
        CallableStatement cst = null;
        try {
            List rows = new ArrayList();
            int numberOfColumns;

            conn = new DBConnector().getDatabaseConn();

            SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MMM-yyyy");

            List ReinstInfo = new LinkedList();
            ARRAY array = null;

            ArrayDescriptor descriptor =
                ArrayDescriptor.createDescriptor("LMS_POLICIES_MEM_LOADING_TAB",
                                                 conn);
            //register out

            csvvalues = CSVParser.parse(new InputStreamReader(csvFile));

            rows = new ArrayList();

            numberOfColumns = 0;
            for (int i = 0; i < csvvalues.length; i++) {
                Map tablerow = new HashMap();
                policyMemberLoading pn = new policyMemberLoading();
                for (int j = 0; j < csvvalues[i].length; j++) {

                    if (j > numberOfColumns) {
                        numberOfColumns = j;
                    }

                    tablerow.put("cell" + (j + 1), csvvalues[i][j]);
                    if (i == 0) {
                        if (j == 0) {

                        }
                    }
                    if (i >= 1) {

                        java.sql.Date DOB = null;
                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][2]) ==
                            0) {

                        } else {
                            String Result =
                                GlobalCC.parseDateAuthFormat(csvvalues[i][2]);
                            if (Result.equalsIgnoreCase("Invalid Date Format")) {
                                GlobalCC.errorValueNotEntered("Invalid Date Format 1 " +
                                                              csvvalues[i][2] +
                                                              " for Member No " +
                                                              csvvalues[i][0] +
                                                              " And Member Name " +
                                                              csvvalues[i][3] +
                                                              " " +
                                                              csvvalues[i][2] +
                                                              ". The Valid Date Format is DD-MMM-YYYY");
                                return;
                            }
                            Date DOBUtil = sdf1.parse(csvvalues[i][2]);
                            DOB =
        new java.sql.Date(((java.util.Date)DOBUtil).getTime());
                        }
                        java.sql.Date DOJ = null;
                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][16]) ==
                            0) {

                        } else {
                            String Result =
                                GlobalCC.parseDateAuthFormat(csvvalues[i][16]);
                            if (Result.equalsIgnoreCase("Invalid Date Format")) {
                                GlobalCC.errorValueNotEntered("Invalid Date Format 2 " +
                                                              csvvalues[i][16] +
                                                              " for Member No " +
                                                              csvvalues[i][0] +
                                                              " And Member Name " +
                                                              csvvalues[i][3] +
                                                              " " +
                                                              csvvalues[i][2] +
                                                              ". The Valid Date Format is DD-MMM-YYYY");
                                return;
                            }
                            Date DOJUtil = sdf1.parse(csvvalues[i][16]);
                            DOJ =
        new java.sql.Date(((java.util.Date)DOJUtil).getTime());
                        }
                        java.sql.Date CoverFrom = null;
                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][17]) ==
                            0) {

                        } else {
                            String Result =
                                GlobalCC.parseDateAuthFormat(csvvalues[i][17]);
                            if (Result.equalsIgnoreCase("Invalid Date Format")) {
                                GlobalCC.errorValueNotEntered("Invalid Date Format 3" +
                                                              csvvalues[i][17] +
                                                              " for Member No " +
                                                              csvvalues[i][0] +
                                                              " And Member Name " +
                                                              csvvalues[i][3] +
                                                              " " +
                                                              csvvalues[i][2] +
                                                              ". The Valid Date Format is DD-MMM-YYYY");
                                return;
                            }
                            Date CoverFromUtil = sdf1.parse(csvvalues[i][17]);
                            CoverFrom =
                                    new java.sql.Date(((java.util.Date)CoverFromUtil).getTime());
                        }

                        java.sql.Date issueDate = null;
                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][23]) ==
                            0) {

                        } else {
                            String Result =
                                GlobalCC.parseDateAuthFormat(csvvalues[i][23]);
                            if (Result.equalsIgnoreCase("Invalid Date Format")) {
                                GlobalCC.errorValueNotEntered("Invalid Date Format 3" +
                                                              csvvalues[i][23] +
                                                              " for Member No " +
                                                              csvvalues[i][0] +
                                                              " And Member Name " +
                                                              csvvalues[i][3] +
                                                              " " +
                                                              csvvalues[i][2] +
                                                              ". The Valid Date Format is DD-MMM-YYYY");
                                return;
                            }
                            Date CoverFromUtil = sdf1.parse(csvvalues[i][23]);
                            issueDate =
                                    new java.sql.Date(((java.util.Date)CoverFromUtil).getTime());
                        }

                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][0]) ==
                            0) {
                            pn.setLGMD_SN(null);
                        } else {
                            pn.setLGMD_SN(new BigDecimal(csvvalues[i][0]));
                        }
                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][1]) ==
                            0) {
                            pn.setLGMD_SURNAME(null);
                        } else {
                            pn.setLGMD_SURNAME(csvvalues[i][1]);
                        }
                        pn.setLGMD_DOB(DOB);
                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][3]) ==
                            0) {
                            pn.setLGMD_ANB(null);
                        } else {
                            pn.setLGMD_ANB(new BigDecimal(csvvalues[i][3]));
                        }

                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][4]) ==
                            0) {
                            pn.setLGMD_CATEGORY(null);
                        } else {
                            pn.setLGMD_CATEGORY(csvvalues[i][4]);
                        }
                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][5]) ==
                            0) {
                            pn.setLGMD_EARNINGS_PRD(null);
                        } else {
                            pn.setLGMD_EARNINGS_PRD(new BigDecimal(csvvalues[i][5]));
                        }
                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][6]) ==
                            0) {
                            pn.setLGMD_OCCUPATION(null);
                        } else {
                            pn.setLGMD_OCCUPATION(csvvalues[i][6]);
                        }

                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][7]) ==
                            0) {
                            pn.setLGMD_BASIC(null);
                        } else {
                            pn.setLGMD_BASIC(csvvalues[i][7]);
                        }
                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][8]) ==
                            0) {
                            pn.setLGMD_HOUSING(null);
                        } else {
                            pn.setLGMD_HOUSING(csvvalues[i][8]);
                        }
                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][9]) ==
                            0) {
                            pn.setLGMD_TRANSPORT(null);
                        } else {
                            pn.setLGMD_TRANSPORT(csvvalues[i][9]);
                        }
                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][10]) ==
                            0) {
                            pn.setLGMD_MONTH_SAL(null);
                        } else {
                            pn.setLGMD_MONTH_SAL(csvvalues[i][10]);
                        }
                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][11]) ==
                            0) {
                            pn.setLGMD_TOT_EMUL(null);
                        } else {
                            pn.setLGMD_TOT_EMUL(new BigDecimal(csvvalues[i][11]));
                        }

                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][12]) ==
                            0) {
                            pn.setLGMD_SA(null);
                        } else {
                            pn.setLGMD_SA(new BigDecimal(csvvalues[i][12]));
                        }

                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][13]) ==
                            0) {
                            pn.setLGMD_PREM(null);
                        } else {
                            pn.setLGMD_PREM(new BigDecimal(csvvalues[i][13]));
                        }

                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][14]) ==
                            0) {
                            pn.setLGMD_PREM_RATE(null);
                        } else {
                            pn.setLGMD_PREM_RATE(new BigDecimal(csvvalues[i][14]));
                        }

                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][15]) ==
                            0) {
                            pn.setLGMD_POL_NO(null);
                        } else {
                            //System.out.println("The policy number is   "+csvvalues[i][15] );
                            pn.setLGMD_POL_NO(csvvalues[i][15]);
                        }

                        pn.setLGMD_DOJ(DOJ);
                        pn.setLGMD_COVER_FROM_DATE(CoverFrom);

                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][18]) ==
                            0) {
                            pn.setLGMD_EMYR_BAL_BF(null);
                        } else {
                            pn.setLGMD_EMYR_BAL_BF(new BigDecimal(csvvalues[i][18]));
                        }
                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][19]) ==
                            0) {
                            pn.setLGMD_EMYE_BAL_BF(null);
                        } else {
                            pn.setLGMD_EMYE_BAL_BF(new BigDecimal(csvvalues[i][19]));
                        }
                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][20]) ==
                            0) {
                            pn.setLGMD_EMPYR_CONTRI(null);
                        } else {
                            pn.setLGMD_EMPYR_CONTRI(new BigDecimal(csvvalues[i][20]));
                        }
                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][21]) ==
                            0) {
                            pn.setLGMD_EMYE_CONTRI(null);
                        } else {
                            pn.setLGMD_EMYE_CONTRI(new BigDecimal(csvvalues[i][21]));
                        }
                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][22]) ==
                            0) {
                            pn.setLGMD_ORIG_LOAN_AMT(null);
                        } else {
                            pn.setLGMD_ORIG_LOAN_AMT(new BigDecimal(csvvalues[i][22]));
                        }
                        pn.setLGMD_LOAN_ISSUE_DATE(issueDate);
                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][24]) ==
                            0) {
                            pn.setLGMD_ORIG_LN_PRD(null);
                        } else {
                            pn.setLGMD_ORIG_LN_PRD(new BigDecimal(csvvalues[i][24]));
                        }
                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][25]) ==
                            0) {
                            pn.setLGMD_LOAN_INT(null);
                        } else {
                            pn.setLGMD_LOAN_INT(new BigDecimal(csvvalues[i][25]));
                        }


                    }

                    System.out.println("cell" + (j + 1));
                    System.out.println(csvvalues[i][j]);
                    System.out.println("Another");
                    //k++;
                } // for cells
                if (i >= 0) {
                    ReinstInfo.add(pn);
                }
                rows.add(tablerow);

            } // for rows

            /* System.out.println("Array :"+ ReinstInfo.toArray());
          for(int i=0;i<ReinstInfo.toArray().length;i++){
            System.out.println("index["+i+"] Value"+ReinstInfo.toArray()[i]);
          }*/

            array = new ARRAY(descriptor, conn, ReinstInfo.toArray());

            System.out.println("Member Array " + array.dump());


            String Query =
                "begin LMS_GRP_LOAD_DATA.import_loaded_members(?,?);end;";
            cst = conn.prepareCall(Query);
            cst.setArray(1, array);
            cst.setString(2, (String)session.getAttribute("policyNumber"));
            cst.execute();
            conn.close();

            ADFUtils.findIterator("findPolMembersToLoadIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(membersTable);

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
            e.printStackTrace();
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }

    }

    public void processCSVForMembersData(InputStream csvFile) {
        // Parse the data, using http://ostermiller.org/utils/download.html
        String[][] csvvalues = null;
        Connection conn = null;
        CallableStatement cst = null;
        try {
            List rows = new ArrayList();
            int numberOfColumns;

            conn = new DBConnector().getDatabaseConn();

            SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MMM-yyyy");

            List ReinstInfo = new LinkedList();
            ARRAY array = null;

            ArrayDescriptor descriptor =
                ArrayDescriptor.createDescriptor("LMS_POLICIES_MEM_LOADING_TAB",
                                                 conn);
            //register out

            csvvalues = CSVParser.parse(new InputStreamReader(csvFile));

            rows = new ArrayList();

            numberOfColumns = 0;
            for (int i = 0; i < csvvalues.length; i++) {
                Map tablerow = new HashMap();
                policyMemberLoading pn = new policyMemberLoading();
                for (int j = 0; j < csvvalues[i].length; j++) {

                    if (j > numberOfColumns) {
                        numberOfColumns = j;
                    }

                    tablerow.put("cell" + (j + 1), csvvalues[i][j]);
                    if (i == 0) {
                        if (j == 0) {

                        }
                    }
                    if (i >= 1) {

                        java.sql.Date DOB = null;
                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][2]) ==
                            0) {

                        } else {
                            String Result =
                                GlobalCC.parseDateAuthFormat(csvvalues[i][2]);
                            if (Result.equalsIgnoreCase("Invalid Date Format")) {
                                GlobalCC.errorValueNotEntered("Invalid Date Format 1 " +
                                                              csvvalues[i][2] +
                                                              " for Member No " +
                                                              csvvalues[i][0] +
                                                              " And Member Name " +
                                                              csvvalues[i][3] +
                                                              " " +
                                                              csvvalues[i][2] +
                                                              ". The Valid Date Format is DD-MMM-YYYY");
                                return;
                            }
                            Date DOBUtil = sdf1.parse(csvvalues[i][2]);
                            DOB =
new java.sql.Date(((java.util.Date)DOBUtil).getTime());
                        }
                        java.sql.Date DOJ = null;
                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][16]) ==
                            0) {

                        } else {
                            String Result =
                                GlobalCC.parseDateAuthFormat(csvvalues[i][16]);
                            if (Result.equalsIgnoreCase("Invalid Date Format")) {
                                GlobalCC.errorValueNotEntered("Invalid Date Format 2 " +
                                                              csvvalues[i][16] +
                                                              " for Member No " +
                                                              csvvalues[i][0] +
                                                              " And Member Name " +
                                                              csvvalues[i][3] +
                                                              " " +
                                                              csvvalues[i][2] +
                                                              ". The Valid Date Format is DD-MMM-YYYY");
                                return;
                            }
                            Date DOJUtil = sdf1.parse(csvvalues[i][16]);
                            DOJ =
new java.sql.Date(((java.util.Date)DOJUtil).getTime());
                        }
                        java.sql.Date CoverFrom = null;
                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][17]) ==
                            0) {

                        } else {
                            String Result =
                                GlobalCC.parseDateAuthFormat(csvvalues[i][17]);
                            if (Result.equalsIgnoreCase("Invalid Date Format")) {
                                GlobalCC.errorValueNotEntered("Invalid Date Format 3" +
                                                              csvvalues[i][17] +
                                                              " for Member No " +
                                                              csvvalues[i][0] +
                                                              " And Member Name " +
                                                              csvvalues[i][3] +
                                                              " " +
                                                              csvvalues[i][2] +
                                                              ". The Valid Date Format is DD-MMM-YYYY");
                                return;
                            }
                            Date CoverFromUtil = sdf1.parse(csvvalues[i][17]);
                            CoverFrom =
                                    new java.sql.Date(((java.util.Date)CoverFromUtil).getTime());
                        }

                        java.sql.Date issueDate = null;
                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][23]) ==
                            0) {

                        } else {
                            String Result =
                                GlobalCC.parseDateAuthFormat(csvvalues[i][23]);
                            if (Result.equalsIgnoreCase("Invalid Date Format")) {
                                GlobalCC.errorValueNotEntered("Invalid Date Format 3" +
                                                              csvvalues[i][23] +
                                                              " for Member No " +
                                                              csvvalues[i][0] +
                                                              " And Member Name " +
                                                              csvvalues[i][3] +
                                                              " " +
                                                              csvvalues[i][2] +
                                                              ". The Valid Date Format is DD-MMM-YYYY");
                                return;
                            }
                            Date CoverFromUtil = sdf1.parse(csvvalues[i][23]);
                            issueDate =
                                    new java.sql.Date(((java.util.Date)CoverFromUtil).getTime());
                        }

                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][0]) ==
                            0) {
                            pn.setLGMD_SN(null);
                        } else {
                            pn.setLGMD_SN(new BigDecimal(csvvalues[i][0]));
                        }
                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][1]) ==
                            0) {
                            pn.setLGMD_SURNAME(null);
                        } else {
                            pn.setLGMD_SURNAME(csvvalues[i][1]);
                        }
                        pn.setLGMD_DOB(DOB);
                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][3]) ==
                            0) {
                            pn.setLGMD_ANB(null);
                        } else {
                            pn.setLGMD_ANB(new BigDecimal(csvvalues[i][3]));
                        }

                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][4]) ==
                            0) {
                            pn.setLGMD_CATEGORY(null);
                        } else {
                            pn.setLGMD_CATEGORY(csvvalues[i][4]);
                        }
                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][5]) ==
                            0) {
                            pn.setLGMD_EARNINGS_PRD(null);
                        } else {
                            pn.setLGMD_EARNINGS_PRD(new BigDecimal(csvvalues[i][5]));
                        }
                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][6]) ==
                            0) {
                            pn.setLGMD_OCCUPATION(null);
                        } else {
                            pn.setLGMD_OCCUPATION(csvvalues[i][6]);
                        }

                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][7]) ==
                            0) {
                            pn.setLGMD_BASIC(null);
                        } else {
                            pn.setLGMD_BASIC(csvvalues[i][7]);
                        }
                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][8]) ==
                            0) {
                            pn.setLGMD_HOUSING(null);
                        } else {
                            pn.setLGMD_HOUSING(csvvalues[i][8]);
                        }
                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][9]) ==
                            0) {
                            pn.setLGMD_TRANSPORT(null);
                        } else {
                            pn.setLGMD_TRANSPORT(csvvalues[i][9]);
                        }
                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][10]) ==
                            0) {
                            pn.setLGMD_MONTH_SAL(null);
                        } else {
                            pn.setLGMD_MONTH_SAL(csvvalues[i][10]);
                        }
                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][11]) ==
                            0) {
                            pn.setLGMD_TOT_EMUL(null);
                        } else {
                            pn.setLGMD_TOT_EMUL(new BigDecimal(csvvalues[i][11]));
                        }

                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][12]) ==
                            0) {
                            pn.setLGMD_SA(null);
                        } else {
                            pn.setLGMD_SA(new BigDecimal(csvvalues[i][12]));
                        }

                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][13]) ==
                            0) {
                            pn.setLGMD_PREM(null);
                        } else {
                            pn.setLGMD_PREM(new BigDecimal(csvvalues[i][13]));
                        }

                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][14]) ==
                            0) {
                            pn.setLGMD_PREM_RATE(null);
                        } else {
                            pn.setLGMD_PREM_RATE(new BigDecimal(csvvalues[i][14]));
                        }

                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][15]) ==
                            0) {
                            pn.setLGMD_POL_NO(null);
                        } else {
                            //System.out.println("The policy number is   "+csvvalues[i][15] );
                            pn.setLGMD_POL_NO(csvvalues[i][15]);
                        }

                        pn.setLGMD_DOJ(DOJ);
                        pn.setLGMD_COVER_FROM_DATE(CoverFrom);

                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][18]) ==
                            0) {
                            pn.setLGMD_EMYR_BAL_BF(null);
                        } else {
                            pn.setLGMD_EMYR_BAL_BF(new BigDecimal(csvvalues[i][18]));
                        }
                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][19]) ==
                            0) {
                            pn.setLGMD_EMYE_BAL_BF(null);
                        } else {
                            pn.setLGMD_EMYE_BAL_BF(new BigDecimal(csvvalues[i][19]));
                        }
                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][20]) ==
                            0) {
                            pn.setLGMD_EMPYR_CONTRI(null);
                        } else {
                            pn.setLGMD_EMPYR_CONTRI(new BigDecimal(csvvalues[i][20]));
                        }
                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][21]) ==
                            0) {
                            pn.setLGMD_EMYE_CONTRI(null);
                        } else {
                            pn.setLGMD_EMYE_CONTRI(new BigDecimal(csvvalues[i][21]));
                        }
                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][22]) ==
                            0) {
                            pn.setLGMD_ORIG_LOAN_AMT(null);
                        } else {
                            pn.setLGMD_ORIG_LOAN_AMT(new BigDecimal(csvvalues[i][22]));
                        }
                        pn.setLGMD_LOAN_ISSUE_DATE(issueDate);
                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][24]) ==
                            0) {
                            pn.setLGMD_ORIG_LN_PRD(null);
                        } else {
                            pn.setLGMD_ORIG_LN_PRD(new BigDecimal(csvvalues[i][24]));
                        }
                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][25]) ==
                            0) {
                            pn.setLGMD_LOAN_INT(null);
                        } else {
                            pn.setLGMD_LOAN_INT(new BigDecimal(csvvalues[i][25]));
                        }


                    }

                    System.out.println("cell" + (j + 1));
                    System.out.println(csvvalues[i][j]);
                    System.out.println("Another");
                    //k++;
                } // for cells
                if (i >= 0) {
                    ReinstInfo.add(pn);
                }
                rows.add(tablerow);

            } // for rows

            /* System.out.println("Array :"+ ReinstInfo.toArray());
          for(int i=0;i<ReinstInfo.toArray().length;i++){
            System.out.println("index["+i+"] Value"+ReinstInfo.toArray()[i]);
          }*/

            array = new ARRAY(descriptor, conn, ReinstInfo.toArray());

            System.out.println("Member Array " + array.dump());

            String Query =
                "begin LMS_GRP_LOAD_DATA.import_all_members(?);end;";
            cst = conn.prepareCall(Query);
            cst.setArray(1, array);
            cst.execute();
            conn.close();

            ADFUtils.findIterator("findPolMembersToLoadIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(memDataTable);

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
            e.printStackTrace();
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }

    }

    public void processCSVForRiders(InputStream csvFile) {
        // Parse the data, using http://ostermiller.org/utils/download.html
        String[][] csvvalues = null;
        Connection conn = null;
        CallableStatement cst = null;
        try {
            List rows = new ArrayList();
            int numberOfColumns;

            conn = new DBConnector().getDatabaseConn();

            SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MMM-yyyy");

            List ReinstInfo = new LinkedList();
            ARRAY array = null;

            ArrayDescriptor descriptor =
                ArrayDescriptor.createDescriptor("LMS_POL_MEM_RIDER_LOADING_TAB",
                                                 conn);


            //register out

            csvvalues = CSVParser.parse(new InputStreamReader(csvFile));

            rows = new ArrayList();

            numberOfColumns = 0;


            for (int i = 0; i < csvvalues.length; i++) {
                Map tablerow = new HashMap();
                memberRiders pn = new memberRiders();
                for (int j = 0; j < csvvalues[i].length; j++) {

                    if (j > numberOfColumns) {
                        numberOfColumns = j;
                    }

                    tablerow.put("cell" + (j + 1), csvvalues[i][j]);
                    if (i == 0) {
                        if (j == 0) {

                        }
                    }
                    if (i >= 1) {

                        pn.setLGRA_POL_NO((String)session.getAttribute("policyNumber"));
                        String polNo =
                            (String)session.getAttribute("policyNumber");

                        if (polNo == null) {
                            if (GlobalCC.CheckNullExcelValues(csvvalues[i][0]) ==
                                0) {
                                pn.setLGRA_POL_NO(null);
                            } else {
                                pn.setLGRA_POL_NO(csvvalues[i][0]);
                            }
                        }
                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][1]) ==
                            0) {
                            pn.setLGRA_MEM_NO(null);
                        } else {
                            pn.setLGRA_MEM_NO(csvvalues[i][1]);
                        }
                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][2]) ==
                            0) {
                            pn.setLGRA_SA(null);
                        } else {
                            pn.setLGRA_SA(new BigDecimal(csvvalues[i][2]));
                        }
                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][3]) ==
                            0) {
                            pn.setLGRA_BEN_CODE(null);
                        } else {
                            pn.setLGRA_BEN_CODE(csvvalues[i][3]);
                        }
                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][4]) ==
                            0) {
                            pn.setLGRA_BEN_TYPE(null);
                        } else {
                            pn.setLGRA_BEN_TYPE(csvvalues[i][4]);
                        }
                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][5]) ==
                            0) {
                            pn.setLGRA_BEN_SA(null);
                        } else {
                            pn.setLGRA_BEN_SA(new BigDecimal(csvvalues[i][5]));
                        }
                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][6]) ==
                            0) {
                            pn.setLGRA_BEN_RATE(null);
                        } else {
                            pn.setLGRA_BEN_RATE(new BigDecimal(csvvalues[i][6]));
                        }
                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][7]) ==
                            0) {
                            pn.setLGRA_BEN_PREM(null);
                        } else {
                            pn.setLGRA_BEN_PREM(new BigDecimal(csvvalues[i][7]));
                        }


                    }
                    //System.out.println("Array "+ReinstInfo.dump);


                    System.out.println("cell" + (j + 1));
                    System.out.println(csvvalues[i][j]);
                    System.out.println("Another");
                    //k++;
                } // for cells
                if (i >= 0) {
                    ReinstInfo.add(pn);
                }
                rows.add(tablerow);
            } // for rows

            array = new ARRAY(descriptor, conn, ReinstInfo.toArray());
            System.out.println("Array " + array.dump());

            String Query =
                "begin LMS_GRP_LOAD_DATA.import_loaded_member_riders(?,?);end;";
            cst = conn.prepareCall(Query);
            cst.setArray(1, array);
            cst.setString(2, (String)session.getAttribute("policyNumber"));
            cst.execute();
            conn.close();

            ADFUtils.findIterator("findPolRidersToLoadIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(ridersTable);

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
            e.printStackTrace();
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }

    }

    public String DeleteMembersRiders() {
        Connection conn = null;
        CallableStatement cstmt = null;
        try {
            RowKeySet rowKeySet = ridersTable.getSelectedRowKeys();

            if (!rowKeySet.iterator().hasNext()) //no selection
            {
                GlobalCC.errorValueNotEntered("No Record Selected");
                return null;
            }
            Iterator rksIter = rowKeySet.iterator();
            while (rksIter.hasNext()) {
                Object key2 = rksIter.next();
                ridersTable.setRowKey(key2);
                JUCtrlValueBinding r =
                    (JUCtrlValueBinding)ridersTable.getRowData();
                if (r == null) {
                    GlobalCC.errorValueNotEntered("No Record Selected");
                    return null;
                }

                String deleteMember =
                    "BEGIN LMS_GRP_LOAD_DATA.delete_loaded_member_riders(?,?);END;";
                conn = new DBConnector().getDatabaseConn();
                cstmt = conn.prepareCall(deleteMember);
                cstmt.setBigDecimal(1,
                                    (BigDecimal)r.getAttribute("LGRA_MEM_NO"));
                cstmt.setString(2,
                                (String)session.getAttribute("policyNumber"));

                cstmt.execute();
                conn.close();


            }
            ADFUtils.findIterator("findPolRidersToLoadIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(ridersTable);
            //recomputePremium.setDisabled(false);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(null, cstmt, conn);
        }

        return null;
    }

    public String DeleteMembers() {
        Connection conn = null;
        CallableStatement cstmt = null;
        try {
            RowKeySet rowKeySet = membersTable.getSelectedRowKeys();

            if (!rowKeySet.iterator().hasNext()) //no selection
            {
                GlobalCC.errorValueNotEntered("No Record Selected");
                return null;
            }
            Iterator rksIter = rowKeySet.iterator();
            while (rksIter.hasNext()) {
                Object key2 = rksIter.next();
                membersTable.setRowKey(key2);
                JUCtrlValueBinding r =
                    (JUCtrlValueBinding)membersTable.getRowData();
                if (r == null) {
                    GlobalCC.errorValueNotEntered("No Record Selected");
                    return null;
                }

                String deleteMember =
                    "BEGIN LMS_GRP_LOAD_DATA.delete_loaded_members(?,?);END;";
                conn = new DBConnector().getDatabaseConn();
                cstmt = conn.prepareCall(deleteMember);
                cstmt.setBigDecimal(1, (BigDecimal)r.getAttribute("LGMD_SN"));
                cstmt.setString(2,
                                (String)session.getAttribute("policyNumber"));

                cstmt.execute();
                conn.close();


            }
            ADFUtils.findIterator("findPolMembersToLoadIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(membersTable);
            //recomputePremium.setDisabled(false);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(null, cstmt, conn);
        }

        return null;
    }

    public String LoadPolicy() {
        Connection conn = null;
        CallableStatement cst = null;
        try {
            conn = new DBConnector().getDatabaseConn();

            if (session.getAttribute("policyNumber") == null) {
                GlobalCC.INFORMATIONREPORTING("Select A Policy to Load.");
                return null;
            }
            String Query =
                "BEGIN LMS_GRP_LOAD_DATA.LOAD_SPECIFIC_POLICIES(?,?,?,?,?,?,?,?);END;";
            cst = conn.prepareCall(Query);
            cst.setString(1, (String)session.getAttribute("Username"));
            cst.setString(2, "N");
            cst.setString(3, "N");
            cst.setString(4, (String)session.getAttribute("policyNumber"));
            cst.setBigDecimal(5, (BigDecimal)session.getAttribute("lgplCode"));
            cst.registerOutParameter(6, OracleTypes.DECIMAL);
            cst.registerOutParameter(7, OracleTypes.DECIMAL);
            cst.registerOutParameter(8, OracleTypes.DECIMAL);
            cst.execute();

            session.setAttribute("endorsementCode", cst.getBigDecimal(7));
            session.setAttribute("policyCode", cst.getBigDecimal(6));
            session.setAttribute("transactionNumber", cst.getBigDecimal(8));
            cst.close();
            conn.close();
            session.setAttribute("Authorised", "N");
            GlobalCC.RedirectPage("/g_undwrt.jspx");

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
        return null;
    }

    public String DeletePolicy() {
        Connection conn = null;
        CallableStatement cst = null;
        try {
            conn = new DBConnector().getDatabaseConn();

            if (session.getAttribute("policyNumber") == null) {
                GlobalCC.INFORMATIONREPORTING("Select A Policy to Load.");
                return null;
            }
            String Query =
                "BEGIN LMS_GRP_LOAD_DATA.delete_loaded_policy(?);END;";
            cst = conn.prepareCall(Query);
            cst.setString(1, (String)session.getAttribute("policyNumber"));
            cst.execute();


            cst.close();
            conn.close();
            GlobalCC.INFORMATIONREPORTING("Policy Deleted Successfully.");

            ResetComponents();

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
        return null;
    }

    public void setUploadedFile(UploadedFile uploadedFile) {
        this.uploadedFile = uploadedFile;
    }

    public UploadedFile getUploadedFile() {
        return uploadedFile;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilesize(long filesize) {
        this.filesize = filesize;
    }

    public long getFilesize() {
        return filesize;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }

    public String getFiletype() {
        return filetype;
    }

    public void setMembersTable(RichTable membersTable) {
        this.membersTable = membersTable;
    }

    public RichTable getMembersTable() {
        return membersTable;
    }

    public void setUpFile(RichInputFile upFile) {
        this.upFile = upFile;
    }

    public RichInputFile getUpFile() {
        return upFile;
    }

    public void setLoadPolicy(RichCommandButton loadPolicy) {
        this.loadPolicy = loadPolicy;
    }

    public RichCommandButton getLoadPolicy() {
        return loadPolicy;
    }

    public void setDeletePolicy(RichCommandButton deletePolicy) {
        this.deletePolicy = deletePolicy;
    }

    public RichCommandButton getDeletePolicy() {
        return deletePolicy;
    }

    public void setCoinsurerPanel(HtmlPanelGrid coinsurerPanel) {
        this.coinsurerPanel = coinsurerPanel;
    }

    public HtmlPanelGrid getCoinsurerPanel() {
        return coinsurerPanel;
    }

    public void setCoinsRiderPanel(RichPanelBox coinsRiderPanel) {
        this.coinsRiderPanel = coinsRiderPanel;
    }

    public RichPanelBox getCoinsRiderPanel() {
        return coinsRiderPanel;
    }

    public void setCoinsurersTable(RichTable coinsurersTable) {
        this.coinsurersTable = coinsurersTable;
    }

    public RichTable getCoinsurersTable() {
        return coinsurersTable;
    }

    public void setRidersTable(RichTable ridersTable) {
        this.ridersTable = ridersTable;
    }

    public RichTable getRidersTable() {
        return ridersTable;
    }

    public void setCoinsurerLabel(RichInputText coinsurerLabel) {
        this.coinsurerLabel = coinsurerLabel;
    }

    public RichInputText getCoinsurerLabel() {
        return coinsurerLabel;
    }

    public void setCoinsurersLOV(RichTable coinsurersLOV) {
        this.coinsurersLOV = coinsurersLOV;
    }

    public RichTable getCoinsurersLOV() {
        return coinsurersLOV;
    }

    public void setCoinsShare(RichInputNumberSpinbox coinsShare) {
        this.coinsShare = coinsShare;
    }

    public RichInputNumberSpinbox getCoinsShare() {
        return coinsShare;
    }

    public void setUploadedFile2(UploadedFile uploadedFile2) {
        this.uploadedFile2 = uploadedFile2;
    }

    public UploadedFile getUploadedFile2() {
        return uploadedFile2;
    }

    public void setFilename2(String filename2) {
        this.filename2 = filename2;
    }

    public String getFilename2() {
        return filename2;
    }

    public void setFilesize2(long filesize2) {
        this.filesize2 = filesize2;
    }

    public long getFilesize2() {
        return filesize2;
    }

    public void setFiletype2(String filetype2) {
        this.filetype2 = filetype2;
    }

    public String getFiletype2() {
        return filetype2;
    }

    public void setUpFile2(RichInputFile upFile2) {
        this.upFile2 = upFile2;
    }

    public RichInputFile getUpFile2() {
        return upFile2;
    }

    public void setLoadedPoliciesLOV(RichTable loadedPoliciesLOV) {
        this.loadedPoliciesLOV = loadedPoliciesLOV;
    }

    public RichTable getLoadedPoliciesLOV() {
        return loadedPoliciesLOV;
    }

    public void setLoadedPolDesc(RichInputText loadedPolDesc) {
        this.loadedPolDesc = loadedPolDesc;
    }

    public RichInputText getLoadedPolDesc() {
        return loadedPolDesc;
    }

    public void setLoadedPoliciesPanel(HtmlPanelGrid loadedPoliciesPanel) {
        this.loadedPoliciesPanel = loadedPoliciesPanel;
    }

    public HtmlPanelGrid getLoadedPoliciesPanel() {
        return loadedPoliciesPanel;
    }

    public void setPolDetailsPanel(HtmlPanelGrid polDetailsPanel) {
        this.polDetailsPanel = polDetailsPanel;
    }

    public HtmlPanelGrid getPolDetailsPanel() {
        return polDetailsPanel;
    }

    public void setPensRegistered(RichOutputLabel pensRegistered) {
        this.pensRegistered = pensRegistered;
    }

    public RichOutputLabel getPensRegistered() {
        return pensRegistered;
    }

    public void setPensionRegisteredLab(RichOutputLabel pensionRegisteredLab) {
        this.pensionRegisteredLab = pensionRegisteredLab;
    }

    public RichOutputLabel getPensionRegisteredLab() {
        return pensionRegisteredLab;
    }

    public void setPensionRegisteredCombo(RichSelectOneChoice pensionRegisteredCombo) {
        this.pensionRegisteredCombo = pensionRegisteredCombo;
    }

    public RichSelectOneChoice getPensionRegisteredCombo() {
        return pensionRegisteredCombo;
    }

    public void setPensRegNoLab(RichOutputLabel pensRegNoLab) {
        this.pensRegNoLab = pensRegNoLab;
    }

    public RichOutputLabel getPensRegNoLab() {
        return pensRegNoLab;
    }

    public void setPensRegNoTF(RichInputText pensRegNoTF) {
        this.pensRegNoTF = pensRegNoTF;
    }

    public RichInputText getPensRegNoTF() {
        return pensRegNoTF;
    }

    public void setPensTypeLab(RichOutputLabel pensTypeLab) {
        this.pensTypeLab = pensTypeLab;
    }

    public RichOutputLabel getPensTypeLab() {
        return pensTypeLab;
    }

    public void setPensTypeCombo(RichSelectOneChoice pensTypeCombo) {
        this.pensTypeCombo = pensTypeCombo;
    }

    public RichSelectOneChoice getPensTypeCombo() {
        return pensTypeCombo;
    }

    public void setPensContriTypeLab(RichOutputLabel pensContriTypeLab) {
        this.pensContriTypeLab = pensContriTypeLab;
    }

    public RichOutputLabel getPensContriTypeLab() {
        return pensContriTypeLab;
    }

    public void setPensContriTypeCombo(RichSelectOneChoice pensContriTypeCombo) {
        this.pensContriTypeCombo = pensContriTypeCombo;
    }

    public RichSelectOneChoice getPensContriTypeCombo() {
        return pensContriTypeCombo;
    }

    public void setEmpyeContriRate(RichOutputLabel empyeContriRate) {
        this.empyeContriRate = empyeContriRate;
    }

    public RichOutputLabel getEmpyeContriRate() {
        return empyeContriRate;
    }

    public void setEmpyeContriRateTF(RichInputText empyeContriRateTF) {
        this.empyeContriRateTF = empyeContriRateTF;
    }

    public RichInputText getEmpyeContriRateTF() {
        return empyeContriRateTF;
    }

    public void setEmpyrContriRateLab(RichOutputLabel empyrContriRateLab) {
        this.empyrContriRateLab = empyrContriRateLab;
    }

    public RichOutputLabel getEmpyrContriRateLab() {
        return empyrContriRateLab;
    }

    public void setEmpyrContriRateTF(RichInputText empyrContriRateTF) {
        this.empyrContriRateTF = empyrContriRateTF;
    }

    public RichInputText getEmpyrContriRateTF() {
        return empyrContriRateTF;
    }

    public void setMaleRetireAgeLab(RichOutputLabel maleRetireAgeLab) {
        this.maleRetireAgeLab = maleRetireAgeLab;
    }

    public RichOutputLabel getMaleRetireAgeLab() {
        return maleRetireAgeLab;
    }

    public void setMaleRetireAgeTF(RichInputText maleRetireAgeTF) {
        this.maleRetireAgeTF = maleRetireAgeTF;
    }

    public RichInputText getMaleRetireAgeTF() {
        return maleRetireAgeTF;
    }

    public void setFemaleRetireAgeLabel(RichOutputLabel femaleRetireAgeLabel) {
        this.femaleRetireAgeLabel = femaleRetireAgeLabel;
    }

    public RichOutputLabel getFemaleRetireAgeLabel() {
        return femaleRetireAgeLabel;
    }

    public void setFemaleRetireAgeTF(RichInputText femaleRetireAgeTF) {
        this.femaleRetireAgeTF = femaleRetireAgeTF;
    }

    public RichInputText getFemaleRetireAgeTF() {
        return femaleRetireAgeTF;
    }

    public void setPensCommRateLab(RichOutputLabel pensCommRateLab) {
        this.pensCommRateLab = pensCommRateLab;
    }

    public RichOutputLabel getPensCommRateLab() {
        return pensCommRateLab;
    }

    public void setPensCommRateTF(RichInputText pensCommRateTF) {
        this.pensCommRateTF = pensCommRateTF;
    }

    public RichInputText getPensCommRateTF() {
        return pensCommRateTF;
    }

    public void setPensGuaranPRDLab(RichOutputLabel pensGuaranPRDLab) {
        this.pensGuaranPRDLab = pensGuaranPRDLab;
    }

    public RichOutputLabel getPensGuaranPRDLab() {
        return pensGuaranPRDLab;
    }

    public void setPensGuaranPRDTF(RichInputText pensGuaranPRDTF) {
        this.pensGuaranPRDTF = pensGuaranPRDTF;
    }

    public RichInputText getPensGuaranPRDTF() {
        return pensGuaranPRDTF;
    }

    public void setPensEarningEscLab(RichOutputLabel pensEarningEscLab) {
        this.pensEarningEscLab = pensEarningEscLab;
    }

    public RichOutputLabel getPensEarningEscLab() {
        return pensEarningEscLab;
    }

    public void setPensEarningsEscTF(RichInputText pensEarningsEscTF) {
        this.pensEarningsEscTF = pensEarningsEscTF;
    }

    public RichInputText getPensEarningsEscTF() {
        return pensEarningsEscTF;
    }

    public void setPensValuationYrLab(RichOutputLabel pensValuationYrLab) {
        this.pensValuationYrLab = pensValuationYrLab;
    }

    public RichOutputLabel getPensValuationYrLab() {
        return pensValuationYrLab;
    }

    public void setPensValuationLab(RichInputText pensValuationLab) {
        this.pensValuationLab = pensValuationLab;
    }

    public RichInputText getPensValuationLab() {
        return pensValuationLab;
    }

    public void setPensValuationYrTF(RichOutputLabel pensValuationYrTF) {
        this.pensValuationYrTF = pensValuationYrTF;
    }

    public RichOutputLabel getPensValuationYrTF() {
        return pensValuationYrTF;
    }

    public void setAggregatePolLab(RichOutputLabel aggregatePolLab) {
        this.aggregatePolLab = aggregatePolLab;
    }

    public RichOutputLabel getAggregatePolLab() {
        return aggregatePolLab;
    }

    public void setAggregatePolicyCombo(RichSelectOneChoice aggregatePolicyCombo) {
        this.aggregatePolicyCombo = aggregatePolicyCombo;
    }

    public RichSelectOneChoice getAggregatePolicyCombo() {
        return aggregatePolicyCombo;
    }

    public void setFundBalLab(RichOutputLabel fundBalLab) {
        this.fundBalLab = fundBalLab;
    }

    public RichOutputLabel getFundBalLab() {
        return fundBalLab;
    }

    public void setFundBalTF(RichInputText fundBalTF) {
        this.fundBalTF = fundBalTF;
    }

    public RichInputText getFundBalTF() {
        return fundBalTF;
    }

    public void setLoanCalcLab(RichOutputLabel loanCalcLab) {
        this.loanCalcLab = loanCalcLab;
    }

    public RichOutputLabel getLoanCalcLab() {
        return loanCalcLab;
    }

    public void setLoanCalcTypeCombo(RichSelectOneChoice loanCalcTypeCombo) {
        this.loanCalcTypeCombo = loanCalcTypeCombo;
    }

    public RichSelectOneChoice getLoanCalcTypeCombo() {
        return loanCalcTypeCombo;
    }

    public void setTermLab(RichOutputLabel termLab) {
        this.termLab = termLab;
    }

    public RichOutputLabel getTermLab() {
        return termLab;
    }

    public void setTermCombo(RichSelectOneChoice termCombo) {
        this.termCombo = termCombo;
    }

    public RichSelectOneChoice getTermCombo() {
        return termCombo;
    }

    public void setAnnuityPaymentStructLab(RichOutputLabel annuityPaymentStructLab) {
        this.annuityPaymentStructLab = annuityPaymentStructLab;
    }

    public RichOutputLabel getAnnuityPaymentStructLab() {
        return annuityPaymentStructLab;
    }

    public void setAnnuityPaymentStructCombo(RichSelectOneChoice annuityPaymentStructCombo) {
        this.annuityPaymentStructCombo = annuityPaymentStructCombo;
    }

    public RichSelectOneChoice getAnnuityPaymentStructCombo() {
        return annuityPaymentStructCombo;
    }

    public void setBenefitInvRateLab(RichOutputLabel benefitInvRateLab) {
        this.benefitInvRateLab = benefitInvRateLab;
    }

    public RichOutputLabel getBenefitInvRateLab() {
        return benefitInvRateLab;
    }

    public void setBenefitInvRateTF(RichInputText benefitInvRateTF) {
        this.benefitInvRateTF = benefitInvRateTF;
    }

    public RichInputText getBenefitInvRateTF() {
        return benefitInvRateTF;
    }

    public void setPayoutRateLab(RichOutputLabel payoutRateLab) {
        this.payoutRateLab = payoutRateLab;
    }

    public RichOutputLabel getPayoutRateLab() {
        return payoutRateLab;
    }

    public void setPayoutRateTF(RichInputText payoutRateTF) {
        this.payoutRateTF = payoutRateTF;
    }

    public RichInputText getPayoutRateTF() {
        return payoutRateTF;
    }

    public void setAdminChargeLab(RichOutputLabel adminChargeLab) {
        this.adminChargeLab = adminChargeLab;
    }

    public RichOutputLabel getAdminChargeLab() {
        return adminChargeLab;
    }

    public void setAdminChargeTF(RichInputText adminChargeTF) {
        this.adminChargeTF = adminChargeTF;
    }

    public RichInputText getAdminChargeTF() {
        return adminChargeTF;
    }

    public void setSchemeLegalAgeLab(RichOutputText schemeLegalAgeLab) {
        this.schemeLegalAgeLab = schemeLegalAgeLab;
    }

    public RichOutputText getSchemeLegalAgeLab() {
        return schemeLegalAgeLab;
    }

    public void setSchemeLegalAgeTF(RichInputText schemeLegalAgeTF) {
        this.schemeLegalAgeTF = schemeLegalAgeTF;
    }

    public RichInputText getSchemeLegalAgeTF() {
        return schemeLegalAgeTF;
    }

    public void setEarningsSALab(RichOutputLabel earningsSALab) {
        this.earningsSALab = earningsSALab;
    }

    public RichOutputLabel getEarningsSALab() {
        return earningsSALab;
    }

    public void setTotPremLab(RichOutputLabel totPremLab) {
        this.totPremLab = totPremLab;
    }

    public RichOutputLabel getTotPremLab() {
        return totPremLab;
    }

    public void setToPremPaidLab(RichOutputLabel toPremPaidLab) {
        this.toPremPaidLab = toPremPaidLab;
    }

    public RichOutputLabel getToPremPaidLab() {
        return toPremPaidLab;
    }

    public void setOutsPremLab(RichOutputLabel outsPremLab) {
        this.outsPremLab = outsPremLab;
    }

    public RichOutputLabel getOutsPremLab() {
        return outsPremLab;
    }

    public void setPensPaymentFreq(RichSelectOneChoice pensPaymentFreq) {
        this.pensPaymentFreq = pensPaymentFreq;
    }

    public RichSelectOneChoice getPensPaymentFreq() {
        return pensPaymentFreq;
    }

    public void setPensPaymentFreqLab(RichOutputLabel pensPaymentFreqLab) {
        this.pensPaymentFreqLab = pensPaymentFreqLab;
    }

    public RichOutputLabel getPensPaymentFreqLab() {
        return pensPaymentFreqLab;
    }

    public void setFreqPaymentLab(RichOutputLabel freqPaymentLab) {
        this.freqPaymentLab = freqPaymentLab;
    }

    public RichOutputLabel getFreqPaymentLab() {
        return freqPaymentLab;
    }

    public void setCommRateLab(RichOutputLabel commRateLab) {
        this.commRateLab = commRateLab;
    }

    public RichOutputLabel getCommRateLab() {
        return commRateLab;
    }

    public void setUpload_policies(RichInputFile upload_policies) {
        this.upload_policies = upload_policies;
    }

    public RichInputFile getUpload_policies() {
        return upload_policies;
    }

    public void policyLoadChangeListener(ValueChangeEvent valueChangeEvent) {
        if (valueChangeEvent.getNewValue() != valueChangeEvent.getOldValue()) {
            try {
                UploadedFile _file =
                    (UploadedFile)valueChangeEvent.getNewValue();
                this.uploadedFile = _file;
                this.filename = _file.getFilename();
                this.filesize = _file.getLength();
                this.filetype = _file.getContentType();

                processCSVForPolicies(uploadedFile.getInputStream());
            } catch (Exception e) {
                GlobalCC.EXCEPTIONREPORTING(null, e);
            }
        }
    }

    public void processCSVForPolicies(InputStream csvFile) {
        // Parse the data, using http://ostermiller.org/utils/download.html
        String[][] csvvalues = null;
        Connection conn = null;
        CallableStatement cst = null;
        try {
            List rows = new ArrayList();
            int numberOfColumns;

            conn = new DBConnector().getDatabaseConn();

            SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MMM-yyyy");

            List ReinstInfo = new LinkedList();
            ARRAY array = null;

            ArrayDescriptor descriptor =
                ArrayDescriptor.createDescriptor("LMS_POLICIES_LOADING_TAB",
                                                 conn);
            //register out

            csvvalues = CSVParser.parse(new InputStreamReader(csvFile));

            rows = new ArrayList();

            

            numberOfColumns = 0;

            /*number of rows*/
            for (int i = 0; i < csvvalues.length; i++) {
                Map tablerow = new HashMap();
                policyLoading pn = new policyLoading();
                for (int j = 0; j < csvvalues[i].length; j++) {

                    if (j > numberOfColumns) {
                        numberOfColumns = j;
                    }

                    tablerow.put("cell" + (j + 1), csvvalues[i][j]);
                    if (i == 0) {
                        if (j == 0) {

                        }
                    }
                    if (i >= 1) {

                        java.sql.Date commencementDate = null;
                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][5]) ==
                            0) {

                        } else {
                            String Result =
                                GlobalCC.parseDateAuthFormat(csvvalues[i][5]);
                            if (Result.equalsIgnoreCase("Invalid Date Format")) {
                                GlobalCC.errorValueNotEntered("Invalid Date Format 1 " +
                                                              csvvalues[i][5] +
                                                              " for Member No " +
                                                              csvvalues[i][0] +
                                                              " And Member Name " +
                                                              csvvalues[i][3] +
                                                              " " +
                                                              csvvalues[i][2] +
                                                              ". The Valid Date Format is DD-MMM-YYYY");
                                return;
                            }
                            Date DOBUtil = sdf1.parse(csvvalues[i][5]);
                            commencementDate =
                                    new java.sql.Date(((java.util.Date)DOBUtil).getTime());
                        }
                        java.sql.Date renewalDate = null;
                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][6]) ==
                            0) {

                        } else {
                            String Result =
                                GlobalCC.parseDateAuthFormat(csvvalues[i][6]);
                            if (Result.equalsIgnoreCase("Invalid Date Format")) {
                                GlobalCC.errorValueNotEntered("Invalid Date Format 2 " +
                                                              csvvalues[i][6] +
                                                              " for Member No " +
                                                              csvvalues[i][0] +
                                                              " And Member Name " +
                                                              csvvalues[i][3] +
                                                              " " +
                                                              csvvalues[i][2] +
                                                              ". The Valid Date Format is DD-MMM-YYYY");
                                return;
                            }
                            Date DOJUtil = sdf1.parse(csvvalues[i][6]);
                            renewalDate =
                                    new java.sql.Date(((java.util.Date)DOJUtil).getTime());
                        }
                        java.sql.Date nextRenewalDate = null;
                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][7]) ==
                            0) {

                        } else {
                            String Result =
                                GlobalCC.parseDateAuthFormat(csvvalues[i][7]);
                            if (Result.equalsIgnoreCase("Invalid Date Format")) {
                                GlobalCC.errorValueNotEntered("Invalid Date Format 3" +
                                                              csvvalues[i][4] +
                                                              " for Member No " +
                                                              csvvalues[i][0] +
                                                              " And Member Name " +
                                                              csvvalues[i][3] +
                                                              " " +
                                                              csvvalues[i][2] +
                                                              ". The Valid Date Format is DD-MMM-YYYY");
                                return;
                            }
                            Date CoverFromUtil = sdf1.parse(csvvalues[i][7]);
                            nextRenewalDate =
                                    new java.sql.Date(((java.util.Date)CoverFromUtil).getTime());
                        }

                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][0]) ==
                            0) {
                            pn.setLGPL_SN(null);
                        } else {
                            pn.setLGPL_SN(new BigDecimal(csvvalues[i][0]));
                        }

                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][1]) ==
                            0) {
                            pn.setLGPL_CLIENT(null);
                        } else {
                            pn.setLGPL_CLIENT(csvvalues[i][1]);
                        }
                        //pn.setLGMD_DOB(DOB);
                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][2]) ==
                            0) {
                            pn.setLGPL_NO_MEM(null);
                        } else {
                            pn.setLGPL_NO_MEM(new BigDecimal(csvvalues[i][2]));
                        }
                      if (GlobalCC.CheckNullExcelValues(csvvalues[i][3]) ==
                          0) {
                          pn.setLGPL_COIN_LEADER(null);
                      } else {
                          pn.setLGPL_COIN_LEADER(csvvalues[i][3]);
                      }

                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][4]) ==
                            0) {
                            pn.setLGPL_SHARE(null);
                        } else {
                            pn.setLGPL_SHARE(csvvalues[i][4]);
                        }

                          pn.setLGPL_COMMENC_DT(commencementDate);
                          pn.setLGPL_RENEW_DT(renewalDate);
                          pn.setLGPL_NEXT_REN_DT(nextRenewalDate);

                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][8]) ==
                            0) {
                            pn.setLGPL_RATES(null);
                        } else {
                            pn.setLGPL_RATES(csvvalues[i][8]);
                        }

                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][9]) ==
                            0) {
                            pn.setLGPL_TOT_SA(null);
                        } else {
                            pn.setLGPL_TOT_SA(new BigDecimal(csvvalues[i][9]));
                        }

                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][10]) ==
                            0) {
                            pn.setLGPL_TOT_PREM(null);
                        } else {
                            pn.setLGPL_TOT_PREM(new BigDecimal(csvvalues[i][10]));
                        }

                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][11]) ==
                            0) {
                            pn.setLGPL_TOT_PREM_PAID(null);
                        } else {
                            pn.setLGPL_TOT_PREM_PAID(new BigDecimal(csvvalues[i][11]));
                        }

                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][12]) ==
                            0) {
                            pn.setLGPL_OUTS_PREM(null);
                        } else {
                            System.out.println("outstanding prem "+csvvalues[i][12]);
                            pn.setLGPL_OUTS_PREM(new BigDecimal(csvvalues[i][12]));
                        }

                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][13]) ==
                            0) {
                            pn.setLGPL_PROD_NAME(null);
                        } else {
                            pn.setLGPL_PROD_NAME(csvvalues[i][13]);
                        }

                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][14]) ==
                            0) {
                            pn.setLGPL_AGENT(null);
                        } else {
                            pn.setLGPL_AGENT(csvvalues[i][14]);
                        }

                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][15]) ==
                            0) {
                            
                            pn.setLGPL_AGENT_NAME(null);
                        } else {
                           pn.setLGPL_AGENT_NAME(csvvalues[i][15]);
                        }

                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][16]) ==
                            0) {
                            pn.setLGPL_POL_NO(null);
                        } else {
                            pn.setLGPL_POL_NO(csvvalues[i][16]);
                        }

                        // pn.setLGMD_LOAN_ISSUE_DATE(issueDate);
                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][17]) ==
                            0) {
                            pn.setLGPL_BRANCH(null);
                        } else {
                            pn.setLGPL_BRANCH(csvvalues[i][17]);
                        }

                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][18]) ==
                            0) {
                            pn.setLGPL_AOI(null);
                        } else {
                            pn.setLGPL_AOI(csvvalues[i][18]);
                        }

                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][19]) ==
                            0) {
                            pn.setLGPL_COMM_RATE(null);
                        } else {
                            pn.setLGPL_COMM_RATE(csvvalues[i][19]);
                        }

                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][20]) ==
                            0) {
                            pn.setLGPL_OV_COMM_RATE(null);
                        } else {
                            pn.setLGPL_OV_COMM_RATE(csvvalues[i][20]);
                        }

                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][21]) ==
                            0) {
                            pn.setLGPL_VAT_RATE(null);
                        } else {
                            pn.setLGPL_VAT_RATE(csvvalues[i][21]);
                        }

                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][22]) ==
                            0) {
                            pn.setLGPL_DURATION(null);
                        } else {
                            pn.setLGPL_DURATION(csvvalues[i][22]);
                        }

                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][23]) ==
                            0) {
                            pn.setLGPL_FREQ_OF_PAY(null);
                        } else {
                            pn.setLGPL_FREQ_OF_PAY(csvvalues[i][23]);
                        }

                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][24]) ==
                            0) {
                            pn.setLGPL_POL_CATEGORY(null);
                        } else {
                            pn.setLGPL_POL_CATEGORY(csvvalues[i][24]);
                        }


                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][25]) ==
                            0) {
                            pn.setLGPL_MULTI_EARNINGS(null);
                        } else {
                            pn.setLGPL_MULTI_EARNINGS(new BigDecimal(csvvalues[i][25]));
                        }

                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][26]) ==
                            0) {
                            pn.setLGPL_FCL(null);
                        } else {
                            pn.setLGPL_FCL(new BigDecimal(csvvalues[i][26]));
                        }
                        
                      if (GlobalCC.CheckNullExcelValues(csvvalues[i][27]) ==
                          0) {
                          pn.setLGPL_REGISTERED(null);
                      } else {
                          pn.setLGPL_REGISTERED(csvvalues[i][27]);
                      }
                        
                      if (GlobalCC.CheckNullExcelValues(csvvalues[i][28]) ==
                          0) {
                          pn.setLGPL_REG_NO(null);
                      } else {
                          pn.setLGPL_REG_NO(csvvalues[i][28]);
                      }                      


                      if (GlobalCC.CheckNullExcelValues(csvvalues[i][29]) ==
                          0) {
                          pn.setLGPL_PENS_TYPE(null);
                      } else {
                          pn.setLGPL_PENS_TYPE(csvvalues[i][29]);
                      }
                      if (GlobalCC.CheckNullExcelValues(csvvalues[i][30]) ==
                          0) {
                          pn.setLGPL_CONTRI_TYPE(null);
                      } else {
                          pn.setLGPL_CONTRI_TYPE(csvvalues[i][30]);
                      }
                      if (GlobalCC.CheckNullExcelValues(csvvalues[i][31]) ==
                          0) {
                          pn.setLGPL_EMYE_CONTRI(null);
                      } else {
                          pn.setLGPL_EMYE_CONTRI(csvvalues[i][31]);
                      }


                      if (GlobalCC.CheckNullExcelValues(csvvalues[i][32]) ==
                          0) {
                          pn.setLGPL_EMYR_CONTRI(null);
                      } else {
                          pn.setLGPL_EMYR_CONTRI(csvvalues[i][32]);
                      }
                      if (GlobalCC.CheckNullExcelValues(csvvalues[i][33]) ==
                          0) {
                          pn.setLGPL_MALE_NRD(null);
                      } else {
                          pn.setLGPL_MALE_NRD(csvvalues[i][33]);
                      }

                      if (GlobalCC.CheckNullExcelValues(csvvalues[i][34]) ==
                          0) {
                          pn.setLGPL_FEMALE_NRD(null);
                      } else {
                          pn.setLGPL_FEMALE_NRD(csvvalues[i][34]);
                      }

                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][35]) ==
                            0) {
                            pn.setLGPL_PENS_COMM_RATE(null);
                        } else {
                            pn.setLGPL_PENS_COMM_RATE(new BigDecimal(csvvalues[i][35]));
                        }

                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][36]) ==
                            0) {
                            pn.setLGPL_PENS_PAYMENT_FREQ(null);
                        } else {
                            pn.setLGPL_PENS_PAYMENT_FREQ(csvvalues[i][36]);
                        }
                      if (GlobalCC.CheckNullExcelValues(csvvalues[i][37]) ==
                          0) {
                          pn.setLGPL_PENS_INTR_RATE(null);
                      } else {
                          pn.setLGPL_PENS_INTR_RATE(new BigDecimal(csvvalues[i][37]));
                      }

                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][38]) ==
                            0) {
                            pn.setLGPL_GRNTD_PRD(null);
                        } else {
                            pn.setLGPL_GRNTD_PRD(csvvalues[i][38]);
                        }

                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][39]) ==
                            0) {
                            pn.setLGPL_EARNINGS_ESC(null);
                        } else {
                            pn.setLGPL_EARNINGS_ESC(csvvalues[i][39]);
                        }
                      if (GlobalCC.CheckNullExcelValues(csvvalues[i][40]) ==
                          0) {
                          pn.setLGPL_VAL_YEAR(null);
                      } else {
                          pn.setLGPL_VAL_YEAR(csvvalues[i][40]);
                      }
                      if (GlobalCC.CheckNullExcelValues(csvvalues[i][41]) ==
                          0) {
                          pn.setLGPL_AGGREGATE(null);
                      } else {
                          pn.setLGPL_AGGREGATE(csvvalues[i][41]);
                      }
                      if (GlobalCC.CheckNullExcelValues(csvvalues[i][42]) ==
                          0) {
                          pn.setLGPL_FUND_BAL(null);
                      } else {
                          pn.setLGPL_FUND_BAL(csvvalues[i][42]);
                      }
                        System.out.println("cell" + (j + 1));
                        System.out.println(csvvalues[i][j]);
                        System.out.println("Another");

                    }

                    //k++;

                } // for cells

                if (i >= 1) {
                    ReinstInfo.add(pn);
                }

                rows.add(tablerow);

            } // for rows

            array = new ARRAY(descriptor, conn, ReinstInfo.toArray());
            System.out.println("Policies Array "+array.dump());

            String Query =
                "begin LMS_GRP_LOAD_DATA.import_loaded_policies_data(?);end;";
            cst = conn.prepareCall(Query);
            cst.setArray(1, array);
            cst.execute();
            conn.close();

            ADFUtils.findIterator("findPolToLoadIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(policiesTable);

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
            e.printStackTrace();
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }

    }

    public void processCSVForClients(InputStream csvFile) {
        // Parse the data, using http://ostermiller.org/utils/download.html
        String[][] csvvalues = null;
        Connection conn = null;
        CallableStatement cst = null;
        try {
            List rows = new ArrayList();
            int numberOfColumns;

            conn = new DBConnector().getDatabaseConn();

            SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MMM-yyyy");

            List ReinstInfo = new LinkedList();
            ARRAY array = null;

            ArrayDescriptor descriptor =
                ArrayDescriptor.createDescriptor("LMS_POL_CLIENT_LOADING_TAB",
                                                 conn);
            //register out

            csvvalues = CSVParser.parse(new InputStreamReader(csvFile));

            //System.out.println("Array type "+descriptor.getOracleTypeCOLLECTION());

            rows = new ArrayList();

            numberOfColumns = 0;

            /*number of rows*/
            for (int i = 0; i < csvvalues.length; i++) {
                Map tablerow = new HashMap();
                PolicyClient pn = new PolicyClient();
                for (int j = 0; j < csvvalues[i].length; j++) {

                    if (j > numberOfColumns) {
                        numberOfColumns = j;
                    }

                    tablerow.put("cell" + (j + 1), csvvalues[i][j]);
                    if (i == 0) {
                        if (j == 0) {

                        }
                    }
                    if (i >= 1) {

                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][0]) ==
                            0) {
                            pn.setLGCD_SN(null);
                        } else {
                            pn.setLGCD_SN(new BigDecimal(csvvalues[i][0]));
                        }

                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][1]) ==
                            0) {
                            pn.setLGCD_CLIENT_ID(null);
                        } else {
                            pn.setLGCD_CLIENT_ID(csvvalues[i][1]);
                        }
                        //pn.setLGMD_DOB(DOB);
                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][2]) ==
                            0) {
                            pn.setLGCD_NAME(null);
                        } else {
                            pn.setLGCD_NAME(csvvalues[i][2]);
                            System.out.println("Client Name " +
                                               csvvalues[i][2]);
                        }

                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][3]) ==
                            0) {
                            pn.setLGCD_CLIENT_ADDRESS(null);
                        } else {
                            pn.setLGCD_CLIENT_ADDRESS(csvvalues[i][3]);
                        }

                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][4]) ==
                            0) {
                            pn.setLGCD_AGENT_ADDRESS(null);
                        } else {
                            pn.setLGCD_AGENT_ADDRESS(csvvalues[i][4]);
                        }

                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][5]) ==
                            0) {
                            pn.setLGCD_CLIENT_TOWN(null);
                        } else {
                            pn.setLGCD_CLIENT_TOWN(csvvalues[i][5]);
                        }

                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][6]) ==
                            0) {
                            pn.setLGCD_CLIENT_COUNTRY(null);
                        } else {
                            pn.setLGCD_CLIENT_COUNTRY(csvvalues[i][6]);
                        }

                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][7]) ==
                            0) {
                            pn.setLGCD_CLIENT_TEL(null);
                        } else {
                            pn.setLGCD_CLIENT_TEL(csvvalues[i][7]);
                        }

                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][8]) ==
                            0) {
                            pn.setLGCD_AGENT_TEL(null);
                        } else {
                            pn.setLGCD_AGENT_TEL(csvvalues[i][8]);
                        }

                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][9]) ==
                            0) {
                            pn.setLGCD_CLIENT_FAX(null);
                        } else {
                            pn.setLGCD_CLIENT_FAX(csvvalues[i][9]);
                        }

                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][10]) ==
                            0) {
                            pn.setLGCD_OCCUPATION(null);
                        } else {
                            pn.setLGCD_OCCUPATION(csvvalues[i][10]);
                        }

                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][11]) ==
                            0) {
                            pn.setLGCD_CLIENT_BANK_NAME(null);
                        } else {
                            pn.setLGCD_CLIENT_BANK_NAME(csvvalues[i][11]);
                        }

                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][12]) ==
                            0) {
                            pn.setLGCD_BANK_BRANCH(null);
                        } else {
                            pn.setLGCD_BANK_BRANCH(csvvalues[i][12]);
                        }

                        // pn.setLGMD_LOAN_ISSUE_DATE(issueDate);
                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][13]) ==
                            0) {
                            pn.setLGCD_ACC_NO(null);
                        } else {
                            pn.setLGCD_ACC_NO(csvvalues[i][13]);
                        }
                        // ReinstInfo.add(pn);

                        System.out.println("cell" + (j + 1));
                        System.out.println(csvvalues[i][j]);
                        System.out.println("Another");


                    }

                    //k++;

                } // for cells
                /*ArrayList arrayList=new ArrayList();
                arrayList.add(pn.getLGCD_SN());
                arrayList.add(pn.getLGCD_CLIENT_ID());*/

                if (i >= 1) {
                    ReinstInfo.add(pn);
                    //System.out.println("Client details "+pn.getLGCD_NAME());
                }

                rows.add(tablerow);

            } // for rows
            System.out.println("Test......" + ReinstInfo.get(2).toString());
            array = new ARRAY(descriptor, conn, ReinstInfo.toArray());

            System.out.println("Array dump" + array.dump());
            String Query =
                "begin LMS_GRP_LOAD_DATA.import_loaded_clients_data(?);end;";
            cst = conn.prepareCall(Query);
            cst.setArray(1, array);
            cst.execute();
            conn.close();

            ADFUtils.findIterator("findPolClientToLoadIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(loadedClientTable);

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
            e.printStackTrace();
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }

    }

    public void processCSVForCoin(InputStream csvFile) {
        // Parse the data, using http://ostermiller.org/utils/download.html
        String[][] csvvalues = null;
        Connection conn = null;
        CallableStatement cst = null;
        try {
            List rows = new ArrayList();
            int numberOfColumns;

            conn = new DBConnector().getDatabaseConn();

            SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MMM-yyyy");

            List ReinstInfo = new LinkedList();
            ARRAY array = null;

            ArrayDescriptor descriptor =
                ArrayDescriptor.createDescriptor("LMS_POL_COIN_LOADING_TAB",
                                                 conn);
            //register out

            csvvalues = CSVParser.parse(new InputStreamReader(csvFile));

            //System.out.println("Array type "+descriptor.getOracleTypeCOLLECTION());

            rows = new ArrayList();

            numberOfColumns = 0;

            /*number of rows*/
            for (int i = 0; i < csvvalues.length; i++) {
                Map tablerow = new HashMap();
                PolicyCoinsurers pn = new PolicyCoinsurers();
                for (int j = 0; j < csvvalues[i].length; j++) {

                    if (j > numberOfColumns) {
                        numberOfColumns = j;
                    }

                    tablerow.put("cell" + (j + 1), csvvalues[i][j]);
                    if (i == 0) {
                        if (j == 0) {

                        }
                    }
                    if (i >= 1) {


                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][0]) ==
                            0) {
                            pn.setLGCA_SCHEME(null);
                        } else {
                            pn.setLGCA_SCHEME(csvvalues[i][0]);
                        }
                        //pn.setLGMD_DOB(DOB);
                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][1]) ==
                            0) {
                            pn.setLGCA_CO_SHARE(null);
                        } else {
                            pn.setLGCA_CO_SHARE(csvvalues[i][1]);
                            System.out.println("Client Name " +
                                               csvvalues[i][1]);
                        }

                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][2]) ==
                            0) {
                            pn.setLGCA_COINSURER(null);
                        } else {
                            pn.setLGCA_COINSURER(csvvalues[i][2]);
                        }

                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][3]) ==
                            0) {
                            pn.setLGCA_COIN_SHARE(null);
                        } else {
                            pn.setLGCA_COIN_SHARE(csvvalues[i][3]);
                        }

                        if (GlobalCC.CheckNullExcelValues(csvvalues[i][4]) ==
                            0) {
                            pn.setLGCA_POL_NO(null);
                        } else {
                            pn.setLGCA_POL_NO(csvvalues[i][4]);
                        }

                        System.out.println("cell" + (j + 1));
                        System.out.println(csvvalues[i][j]);
                        System.out.println("Another");


                    }

                    //k++;

                } // for cells
                if (i >= 1) {
                    ReinstInfo.add(pn);
                }
                rows.add(tablerow);

            } // for rows
            System.out.println("Test......" + ReinstInfo.get(2).toString());
            array = new ARRAY(descriptor, conn, ReinstInfo.toArray());

            System.out.println("Array dump" + array.dump());
            String Query =
                "begin LMS_GRP_LOAD_DATA.import_loaded_coin_data(?);end;";
            cst = conn.prepareCall(Query);
            cst.setArray(1, array);
            cst.execute();
            conn.close();

            ADFUtils.findIterator("findPolCoinsurersToLoadIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(coinsurersTable);

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
            e.printStackTrace();
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }

    }

    public String nextAction() {
        // Add event code here...
        if (policiesTab.isRendered()) {
            policiesTab.setRendered(false);
            membersTab.setRendered(true);
            coinsRiderPanel.setRendered(false);
            coinsurerTab.setRendered(false);            

        } else if (membersTab.isRendered()) {
            policiesTab.setRendered(false);
            membersTab.setRendered(false);
            coinsRiderPanel.setRendered(true);
            coinsurerTab.setRendered(false); 
            loadPolicy.setDisabled(false);
        } else if (coinsRiderPanel.isRendered()) {
            policiesTab.setRendered(false);
            membersTab.setRendered(false);
            coinsRiderPanel.setRendered(false);
            coinsurerTab.setRendered(true);
            loadPolicy.setDisabled(false);
        } else if (coinsurerTab.isRendered()) {
            policiesTab.setRendered(false);
            membersTab.setRendered(false);
            coinsRiderPanel.setRendered(false);
            coinsurerTab.setRendered(true);
            loadPolicy.setDisabled(false);
        }

        return null;
    }

    public void setPoliciesTable(RichTable policiesTable) {
        this.policiesTable = policiesTable;
    }

    public RichTable getPoliciesTable() {
        return policiesTable;
    }

    public String previousAction() {
        // Add event code here...
        if (policiesTab.isRendered()) {
            prevButton.setDisabled(true);
            policiesTab.setRendered(false);
            membersTab.setRendered(true);
            coinsRiderPanel.setRendered(false);
            coinsurerTab.setRendered(false);
            loadPolicy.setDisabled(true);

        } else if (membersTab.isRendered()) {
            prevButton.setDisabled(false);
            policiesTab.setRendered(true);
            membersTab.setRendered(false);
            coinsRiderPanel.setRendered(false);
            coinsurerTab.setRendered(false);
           loadPolicy.setDisabled(true);
        } else if (coinsRiderPanel.isRendered()) {
            prevButton.setDisabled(false);
            policiesTab.setRendered(false);
            membersTab.setRendered(true);
            coinsRiderPanel.setRendered(false);
            coinsurerTab.setRendered(false);
            loadPolicy.setDisabled(false);
        } else if (coinsurerTab.isRendered()) {
            prevButton.setDisabled(false);
            policiesTab.setRendered(false);
            membersTab.setRendered(false);
            coinsRiderPanel.setRendered(true);
            coinsurerTab.setRendered(false);
            loadPolicy.setDisabled(false);
        }

        return null;
    }

    public void fileForMemberDataLoading(ValueChangeEvent valueChangeEvent) {

        if (valueChangeEvent.getNewValue() != valueChangeEvent.getOldValue()) {
            try {
                UploadedFile _file =
                    (UploadedFile)valueChangeEvent.getNewValue();
                this.uploadedFile = _file;
                this.filename = _file.getFilename();
                this.filesize = _file.getLength();
                this.filetype = _file.getContentType();

                processCSVForMembersData(uploadedFile.getInputStream());
            } catch (Exception e) {
                GlobalCC.EXCEPTIONREPORTING(null, e);
            }
        }
    }

    public void setMemDataTable(RichTable memDataTable) {
        this.memDataTable = memDataTable;
    }

    public RichTable getMemDataTable() {
        return memDataTable;
    }

    public void setCoinsurerTab(RichPanelBox coinsurerTab) {
        this.coinsurerTab = coinsurerTab;
    }

    public RichPanelBox getCoinsurerTab() {
        return coinsurerTab;
    }

    public void setClientTab(RichPanelBox clientTab) {
        this.clientTab = clientTab;
    }

    public RichPanelBox getClientTab() {
        return clientTab;
    }

    public void setUpClientFile(RichInputFile upClientFile) {
        this.upClientFile = upClientFile;
    }

    public RichInputFile getUpClientFile() {
        return upClientFile;
    }

    public void fileChangeForClients(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if (valueChangeEvent.getNewValue() != valueChangeEvent.getOldValue()) {
            try {
                UploadedFile _file =
                    (UploadedFile)valueChangeEvent.getNewValue();
                this.uploadedFile = _file;
                this.filename = _file.getFilename();
                this.filesize = _file.getLength();
                this.filetype = _file.getContentType();

                processCSVForClients(uploadedFile.getInputStream());
            } catch (Exception e) {
                GlobalCC.EXCEPTIONREPORTING(null, e);
            }
        }
    }

    public void setLoadedClientTable(RichTable loadedClientTable) {
        this.loadedClientTable = loadedClientTable;
    }

    public RichTable getLoadedClientTable() {
        return loadedClientTable;
    }

    public void upProcessorForCoin(ValueChangeEvent valueChangeEvent) {
        if (valueChangeEvent.getNewValue() != valueChangeEvent.getOldValue()) {
            try {
                UploadedFile _file =
                    (UploadedFile)valueChangeEvent.getNewValue();
                this.uploadedFile2 = _file;
                this.filename = _file.getFilename();
                this.filesize = _file.getLength();
                this.filetype = _file.getContentType();

                processCSVForCoin(uploadedFile2.getInputStream());
            } catch (Exception e) {
                GlobalCC.EXCEPTIONREPORTING(null, e);
            }
        }
    }

    public void setUpFileCoin(RichInputFile upFileCoin) {
        this.upFileCoin = upFileCoin;
    }

    public RichInputFile getUpFileCoin() {
        return upFileCoin;
    }

    public String loadClientsAction() {
        CallableStatement cstmt = null;
        Connection conn = null;
        String userName = (String)session.getAttribute("Username");

        String importClients =
            "BEGIN LMS_GRP_LOAD_DATA.load_imported_clients_data(?);END;";
        try {
            conn = new DBConnector().getDatabaseConn();
            cstmt = conn.prepareCall(importClients);

            cstmt.setString(1, userName);

            cstmt.execute();
            conn.close();
            GlobalCC.INFORMATIONREPORTING("Clients loaded successfully");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public String loadAllPolicies() {
      Connection conn = null;
      CallableStatement cst = null;
      try {
          conn = new DBConnector().getDatabaseConn();

          String Query =
              "BEGIN LMS_GRP_LOAD_DATA.LOAD_ALL_POLICIES(?,?,?);END;";
          cst = conn.prepareCall(Query);
          cst.setString(1, (String)session.getAttribute("Username"));
          cst.setString(2, "N");
          cst.setString(3, "Y");        
          cst.execute();
          cst.close();
          conn.close();

      } catch (Exception e) {
          GlobalCC.EXCEPTIONREPORTING(conn, e);
      } finally {
          GlobalCC.CloseConnections(null, cst, conn);
      }
        return null;
    }

    public String deleteLoadedPolicies() {
        Connection conn = null;
        CallableStatement cst = null;
        try {
            conn = new DBConnector().getDatabaseConn();

          String Query =
                "BEGIN LMS_GRP_LOAD_DATA.delete_loaded_policy(?);END;";
            cst = conn.prepareCall(Query);
            cst.setString(1, (String)session.getAttribute("policyNo"));                 
            cst.execute();
            cst.close();
            conn.close();

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
        return null;
    }

    public String deleteLoadedMembers() {
        // Add event code here...
        Connection conn = null;
        CallableStatement cstmt = null;
        try {
            RowKeySet rowKeySet = memDataTable.getSelectedRowKeys();

            if (!rowKeySet.iterator().hasNext()) //no selection
            {
                GlobalCC.errorValueNotEntered("No Record Selected");
                return null;
            }
            Iterator rksIter = rowKeySet.iterator();
            while (rksIter.hasNext()) {
                Object key2 = rksIter.next();
                memDataTable.setRowKey(key2);
                JUCtrlValueBinding r =
                    (JUCtrlValueBinding)memDataTable.getRowData();
                if (r == null) {
                    GlobalCC.errorValueNotEntered("No Record Selected");
                    return null;
                }

                String deleteMember =
                    "BEGIN LMS_GRP_LOAD_DATA.delete_loaded_members(?,?);END;";
                conn = new DBConnector().getDatabaseConn();
                cstmt = conn.prepareCall(deleteMember);
                cstmt.setBigDecimal(1, (BigDecimal)r.getAttribute("LGMD_SN"));
                cstmt.setString(2,
                                (String)session.getAttribute("policyNumber"));

                cstmt.execute();
                conn.close();


            }
            ADFUtils.findIterator("findPolMembersToLoadIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(membersTable);
            //recomputePremium.setDisabled(false);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(null, cstmt, conn);
        }
        return null;
    }
}
