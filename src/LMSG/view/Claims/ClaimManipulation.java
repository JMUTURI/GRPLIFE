package LMSG.view.Claims;

import LMSG.view.BPM.ProcessDMSTicket;
import LMSG.view.BPM.workflowProcessing;
import LMSG.view.Base.ADFUtils;
import LMSG.view.Base.GlobalCC;
import LMSG.view.Base.LOVCC;
import LMSG.view.Correspondents.CorrespondenceManipulation;
import LMSG.view.TableTypes.AnnuityPayments;
import LMSG.view.TableTypes.ClaimCovers;
import LMSG.view.connect.DBConnector;
import LMSG.view.ecm.EcmProps;
import LMSG.view.ecm.EcmTrans;
import LMSG.view.ecm.EcmUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.data.RichColumn;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputFile;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanCheckbox;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanRadio;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.input.RichSelectOneRadio;
import oracle.adf.view.rich.component.rich.layout.RichPanelBox;
import oracle.adf.view.rich.component.rich.layout.RichShowDetailItem;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.output.RichInlineFrame;
import oracle.adf.view.rich.component.rich.output.RichOutputLabel;
import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;
import oracle.jbo.uicli.binding.JUCtrlValueBinding;

import oracle.jdbc.OracleConnection;

import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;

import org.alfresco.cmis.client.AlfrescoDocument;

import org.apache.chemistry.opencmis.client.api.CmisObject;
import org.apache.chemistry.opencmis.client.api.Document;
import org.apache.chemistry.opencmis.client.api.Folder;
import org.apache.chemistry.opencmis.client.api.Session;
import org.apache.chemistry.opencmis.commons.data.ContentStream;
import org.apache.myfaces.trinidad.event.SelectionEvent;
import org.apache.myfaces.trinidad.model.RowKeySet;
import org.apache.myfaces.trinidad.model.UploadedFile;
import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

import oracle.jdbc.OracleTypes;

public class ClaimManipulation extends LOVCC {
    private RichTable productsLOV;
    private RichInputText productDesc;
    private RichTable policiesLOV;
    private RichInputText policiesDesc;
    private RichSelectOneChoice transType;
    private RichTable claimsLOV;
    private RichInputText claimsDesc;
    private RichTable membersLOV;
    private RichInputText membersDesc;
    private RichTable causationsLOV;
    private RichInputText causationDesc;
    private RichInputDate lossDate;
    private RichInputDate reportDate;
    private RichInputText causeCodeDesc;
    private RichTable causeCodeLOV;
    private RichTable coversLOV;
    private RichSelectOneChoice docSelectOption;
    private RichInputText amtClaimed;
    private RichInputText butPay;
    private RichInputText remarks;
    private RichSelectOneChoice payee;
    private RichInputText reserveAmt;
    private RichInputText clmAmountClaimed;
    private RichInputText amtToPay;
    private RichInputText memNo;
    private RichTable claimLOV;
    private RichInputText claimDesc;
    private RichInputText editPolNo;
    private RichInputText editTransNo;
    private RichTable facilitatorLOV;
    private RichInputText facilitatorDesc;
    private RichTable activitiesLOV;
    private RichInputText actfeeDesc;
    private RichInputDate actPayDate;
    private RichInputText actRemarks;
    private RichOutputText actName;
    private RichTable docsLOV;
    private RichInputText enClaimDesc;
    private RichCommandButton enClaimButton;
    private RichOutputLabel enClaimLabel;
    private RichOutputLabel enPolicyLabel;
    private RichCommandButton enPolicyButton;
    private RichOutputLabel enMemberNo;
    private RichCommandButton enMemberButton;
    private RichOutputLabel enTransLabel;
    private RichInputText enTransDesc;
    private RichCommandButton enTransButton;
    private RichTable rcClaimsLOV;
    private RichTable rcClaimTransLOV;
    private HtmlPanelGrid policyPanel;
    private HtmlPanelGrid claimPanel;
    private HtmlPanelGrid transPanel;
    private HtmlPanelGrid memberPanel;
    private RichTable claimVouchers;
    private RichTable voucherDetails;
    private RichTable groupLifeRI;
    private RichTable participantsRI;
    private RichOutputLabel fmSLabel;
    private RichSelectBooleanCheckbox fmSCheck;
    private RichSelectBooleanCheckbox claimCbox;
    private RichSelectOneChoice pensionPayee;
    private RichInputText pensToPay;
    private RichInputText taxPayable;
    private RichInputText taxable;
    private RichInputText netPay;
    private RichTable payeesLOV;
    private RichTable payees2LOV;
    private RichOutputText docDesc;
    private RichSelectOneChoice submitted;
    private RichInputDate dateSubmitted;
    private RichInputText docNo;
    private RichSelectBooleanCheckbox raiseRequisition;
    private RichSelectBooleanCheckbox totalCoinsAmt;
    private RichInputDate effDate;
    private RichTable usersLOV;
    private RichInputText ticketRemarks;
    private RichOutputText voucherLabel;
    private RichOutputText payeeLabel;
    private RichSelectOneChoice dispStatus;
    private RichTable resultsLOV;
    private RichPanelBox myTickets;
    private RichTable exceptionLOV;
    private RichInputText pensIntRate;
    private RichSelectOneChoice minimumInformationProvided;
    private RichInputText exGratiaMemNo;
    private RichInputText exgratiaSurname;
    private RichInputText exgratiaOtherNames;
    private RichInputDate exgratiaDateOfBirth;
    private RichSelectOneChoice exgratiaGender;
    private RichInputText exgratiaEarnings;
    private RichInputText exgratiaPeriod;
    private RichSelectBooleanCheckbox xgratiaTransaction;
    private RichInputText xgratiaMemberID;
    private RichInputText exGratiaEmpyerContr;
    private RichInputText exGratiaEmpyeeContirbution;
    private RichInputText exGratiaVolEmpyerContr;
    private RichInputText exGratiaVolEmpyeeContr;
    private RichInputDate dateOfJoining;
    private RichTable claimsCausationsCauseLOV;
    private RichInputText causationCauseDesc;
    private RichInputText lossDescription;
    private RichTable lossesLOV;
    private RichInputText disabilityDays;
    private RichPanelBox weeklyIndemnityClaims;
    private RichTable weekIndemnityLosses;
    private RichInputText clmExpAmount;
    private RichInputText clmPercPayable;
    private RichTable beneficaryPayments;
    private RichInputText feesAmount;
    private RichSelectOneChoice beneficaryPaid;
    private RichPanelBox mainClaimsTab;
    private RichPanelBox editClaimsTab;
    private RichInputText age;
    private RichInputDate dateReported;
    private RichInputDate deathDate;
    private RichInputText retention;
    private RichOutputText coverDesc;
    private RichInputText updRemarks;
    private RichSelectOneRadio payeeRadio;
    private RichPanelBox entPayee;
    private RichPanelBox selPayee;
    private RichInputText payeeDesc;
    private RichTable pendingTransactions;
    private RichPanelBox myPendingTrans;
    private RichCommandButton nextButton;
    private RichSelectOneChoice disabilitySelect;
    private RichOutputLabel noDaysLabel;
    private RichOutputLabel invoiceLabel;
    private RichSelectOneChoice claimStatus;
    private RichInputText studentNames;
    private RichInputText studentSurname;
    private RichInputText studentMemNo;
    private RichInputDate studentDOB;
    private RichSelectOneChoice studentSex;
    private RichTable studentsLOV;
    private RichInputText studentType;
    private RichInputText studentSharePct;
    private RichInputText pensPayeeName;
    private RichInputText pensPayeePIN;
    private RichSelectOneChoice paymentFreq;
    private RichTable pensMaturities;
    private RichPanelBox pensionsTab;
    private RichTable vouchersTable;
    private RichTable matDocuments;
    private RichTable taxTable;
    private RichInputText taxDesc;
    private RichInputText taxRate;
    private RichInputText taxAmount;
    private RichTable pensionTaxTable;
    private RichTable agencyTable;
    private RichInputText agencyDesc;
    private RichInputText rsaPin;
    private RichTable annuitiesTable;
    private RichTable claimRecoveries;
    private RichOutputLabel exgratiaCommLbl;
    private RichInputText exgratiaRemarks;
    private RichTable exgratiaMembers;
    private RichSelectBooleanRadio addExMem;
    private RichSelectBooleanRadio editExMem;
    private RichCommandButton xgratiaButton;
    private RichSelectOneChoice cvrSelection;
    private RichInputText xgratiaSA;
    private RichInputText xgratiaEarningsAmt;
    private RichInputText xgratiaEarningsPrd;
    private RichInputText deathLocation;
    private RichInputText retireHeldPct;
    private RichTable multipleMemLOV;
    private RichTable mutipleClaimsLOV;
    private RichSelectBooleanCheckbox claimsCheckBox;
    private RichSelectOneChoice paymentModeCombo;
    private RichTable clientBankLOV;
    private RichInputText bankName;
    private RichInputText bankAccountNo;
    private RichCommandButton addEFTDetails;
    private RichSelectOneChoice paymentMode;
    private RichInputText clientACCNo;
    private RichInputText bank_display;
    private RichInputText clm_pymnt_inst;
    private RichInputText actualSavingsTF;
    private RichOutputLabel payInstLab;
    private RichOutputLabel actualSavLab;
    private RichOutputLabel occBenLab;
    private RichInputText occBenTF;
    private RichSelectOneChoice clmPayInst;
    private RichInputText clmInstNo;
    private RichSelectOneChoice clm_pay_freq;
    private RichTable instLOV;
    private RichTable requiredDocsLOV;
    private RichTable clmReqDoc;
    private RichInputText docName;
    private RichSelectOneChoice docSubmitted;
    private RichInputDate docDateSubmitted;
    private RichInputText documentNo;
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    protected static BigDecimal[][] ClaimCoverTypeCode = new BigDecimal[20][2];
    protected static String[] ClaimCoverType = new String[20];
    protected static int t = 0;
    private static Integer Num = Integer.valueOf(0);
    private RichInputText srchMemName;
    private RichInputText srchMemNo;
    private RichShowDetailItem dmsDocTab;
    private RichTable dmsDocTable;
    private RichInputFile dmsFileToUpload;
    private RichSelectOneChoice lmsDocType;
    private RichInlineFrame viewPop;
    private RichInputText daysHospitalized;
    private RichInlineFrame docViewer;
    private RichInputText pensButPayAmt;
    private RichSelectOneChoice remarksType;
    private RichInputText remarksTextArea;
    private RichTable remarksLOV;
    private RichTable ticketsUserLOV;
    private RichInputText tcktAsignee;
    private RichColumn accColumn;
    private RichInputText vchrAccNo;
    private RichInputText provSubType;
    private RichInputText mobileNumber;
    private RichSelectOneChoice idType;
    private RichInputText passIdNo;
    private RichColumn providersLOV;
    private RichTable providersTableLOV;
    private RichOutputLabel clmPercPayableLabel;
    private RichInputText bankBrnchSearch;
    private RichSelectOneChoice cvtPayable;
    private RichInputText memNoSearch;
    private RichInputText memNameSearch;
    private RichInputText claimSearch;
    private RichTable medTestsTable;
    private RichTable medReqLOV;
    private RichInputText facDesc;
    private RichInputDate reqDate;
    private RichInputText invAmt;
    private RichInputDate cheqDate;
    private RichSelectOneChoice checkedDesc;
    private RichInputDate invDate;
    private RichInputText invNo;
    private RichInputText medremarks;
    private RichInputDate resultDate;
    private RichInputDate schemeJoinDate;
    private RichInputDate employmentDate;
    private RichInputDate dateOfBirth;
    private RichInputText kraPinNo;
    private RichInputText overrideTax;
    private RichOutputLabel transferToLB;
    private RichInputText transferToTF;
    private RichSelectOneChoice transferLockedBen;
    private RichSelectOneChoice withAppliedOn;
    private RichInputText withOverrideTaxAmt;
    private RichCommandButton computeWithdrawalAmt;
    private RichInputText withdrawalAmt;
    private RichInputText withdrawalTaxExemptAmt;
    private RichInputText withdrawalTaxAmt;
    private RichInputText withdrawalNetPayable;
    private RichInputText withEmpyrRegAmt;
    private RichInputText withEmplyrUnregAmt;
    private RichInputText withEmpyeRegAmt;
    private RichInputText withEmpyeUnregAmt;
    private RichInputText payeeTF;
    private RichTable claimBookingLOV;
    private RichTable bookingCoverTypeLOV;
    private RichTable reinsuranceBookingLOV;

    public String findProductSelected() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findProductsIterator");


        RowKeySet set = this.productsLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            this.productDesc.setValue(r.getAttribute("prodDesc"));
            this.session.setAttribute("productType",
                                      r.getAttribute("prodType"));

            this.session.setAttribute("ProductCode",
                                      r.getAttribute("prodCode"));

            this.session.setAttribute("endorsementCode", null);
            ADFUtils.findIterator("FindPoliciesIterator").executeQuery();

            this.policiesDesc.setValue(null);

            this.session.setAttribute("policyCode", null);
            String TransType =
                (String)this.session.getAttribute("ClaimTransactionType");
            if (TransType == "RO") {
                this.enClaimDesc.setValue(null);

                this.session.setAttribute("ClaimNo", null);
                this.session.setAttribute("PolicyMemCode", null);
                this.session.setAttribute("policyCode", null);

                this.session.setAttribute("MemberNumber", null);

                this.session.setAttribute("CPVoucher", null);
                this.enTransDesc.setValue(null);

                ADFUtils.findIterator("FindClaimForReopenContraIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.rcClaimsLOV);
            } else if (TransType == "CO") {
                this.enClaimDesc.setValue(null);

                this.session.setAttribute("ClaimNo", null);
                this.session.setAttribute("PolicyMemCode", null);
                this.session.setAttribute("policyCode", null);

                this.session.setAttribute("MemberNumber", null);

                this.session.setAttribute("CPVoucher", null);
                this.enTransDesc.setValue(null);

                ADFUtils.findIterator("FindClaimForReopenContraIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.rcClaimsLOV);
            } else {
                ADFUtils.findIterator("FindPoliciesIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.policiesLOV);

                Integer EditC =
                    (Integer)this.session.getAttribute("EditClaim");
                if (EditC.intValue() == 1) {
                    ADFUtils.findIterator("FindClaimTransactionsIterator").executeQuery();
                    AdfFacesContext.getCurrentInstance().addPartialTarget(this.claimLOV);
                }
            }
        }
        if (this.causationsLOV != null) {
            ADFUtils.findIterator("FindCausationsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.causationsLOV);
        }
        return null;
    }

    public String findClaimReopenSelected() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindClaimForReopenContraIterator");


        RowKeySet set = this.rcClaimsLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            this.enClaimDesc.setValue(r.getAttribute("RC_CLM_NO"));
            this.session.setAttribute("ClaimNo", r.getAttribute("RC_CLM_NO"));
            this.session.setAttribute("PolicyMemCode",
                                      r.getAttribute("RC_CLM_POLM_CODE"));


            this.session.setAttribute("MemberNumber",
                                      r.getAttribute("RC_CLM_MEM_CODE"));


            this.session.setAttribute("policyCode",
                                      r.getAttribute("RC_POL_CODE"));


            this.session.setAttribute("CPVoucher", null);
            this.enTransDesc.setValue(null);

            ADFUtils.findIterator("FindClaimTransForReopenContraIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.rcClaimTransLOV);
        }
        return null;
    }

    public String findClaimTransReopenSelected() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindClaimTransForReopenContraIterator");


        RowKeySet set = this.rcClaimTransLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            this.enTransDesc.setValue(r.getAttribute("CPV_VOUCHER_NO"));

            this.session.setAttribute("CPVoucher",
                                      r.getAttribute("CPV_VOUCHER_NO"));
        }
        return null;
    }

    public String findFacilitatorSelected() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindFacilitatorsIterator");


        RowKeySet set = this.facilitatorLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
            this.session.setAttribute("FacilitatorCode",
                                      r.getAttribute("FAC_CODE"));
            this.facDesc.setValue(r.getAttribute("FAC_NAME"));
            ExtendedRenderKitService erkService =
                (ExtendedRenderKitService)Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                                             ExtendedRenderKitService.class);


            erkService.addScript(FacesContext.getCurrentInstance(),
                                 "var hints = {autodismissNever:false}; AdfPage.PAGE.findComponent('lmsgroup:medpopup').show(hints);");
        }
        return null;
    }

    public String findClaimSelected() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindClaimTransactionsIterator");


        RowKeySet set = this.claimLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            this.claimDesc.setValue(r.getAttribute("LTR_CLM_NO"));

            this.session.setAttribute("ClaimNo", r.getAttribute("LTR_CLM_NO"));
            this.session.setAttribute("ClaimTransNo",
                                      r.getAttribute("LTR_TRANS_NO"));


            this.session.setAttribute("MemberNumber",
                                      r.getAttribute("LTR_MEM_CODE"));


            this.session.setAttribute("CausationType",
                                      r.getAttribute("LTR_CLM_CAUS_TYPE"));


            this.session.setAttribute("PolmCode",
                                      r.getAttribute("LTR_POLM_CODE"));
            if (this.policiesDesc.getValue() == null) {
                this.policiesDesc.setValue(r.getAttribute("LTR_POL_POLICY_NO"));

                this.session.setAttribute("policyCode",
                                          r.getAttribute("POL_CODE"));

                this.session.setAttribute("policyNumber",
                                          r.getAttribute("LTR_POL_POLICY_NO"));


                this.session.setAttribute("prpCode",
                                          r.getAttribute("PRP_CODE"));

                this.session.setAttribute("ClientCode",
                                          r.getAttribute("PRP_CLNT_CODE"));
            }
            this.session.setAttribute("clmbatchNo",
                                      r.getAttribute("CLM_BATCH_NO"));

            this.session.setAttribute("policyCode",
                                      r.getAttribute("POL_CODE"));
        }
        return null;
    }

    public String SearchMembers() {
        try {
            if (this.srchMemName.getValue() == null) {
                this.session.setAttribute("srchMemName", null);
            } else {
                this.session.setAttribute("srchMemName",
                                          this.srchMemName.getValue().toString());
            }
            if (this.srchMemNo.getValue() == null) {
                this.session.setAttribute("srchMemNo", null);
            } else {
                this.session.setAttribute("srchMemNo",
                                          this.srchMemNo.getValue().toString());
            }
            ADFUtils.findIterator("FindMembersByTransactionsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.membersLOV);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String ClearSearchMembers() {
        try {
            this.session.setAttribute("srchMemName", null);
            this.session.setAttribute("srchMemNo", null);
            this.srchMemNo.setValue(null);
            this.srchMemName.setValue(null);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.srchMemNo);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.srchMemName);

            ADFUtils.findIterator("FindMembersByTransactionsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.membersLOV);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String findMembersSelected() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindMembersByTransactionsIterator");


        RowKeySet set = this.membersLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
            this.membersDesc.setValue(r.getAttribute("client"));

            this.session.setAttribute("PolicyMemCode",
                                      r.getAttribute("POLM_CODE"));

            this.session.setAttribute("PolmCode", r.getAttribute("POLM_CODE"));
            this.session.setAttribute("MemberNumber",
                                      r.getAttribute("MEM_CODE"));
        }
        return null;
    }

    public String findPoliciesSelected() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindPoliciesIterator");


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

            this.session.setAttribute("policyNumber",
                                      r.getAttribute("POL_POLICY_NO"));


            this.session.setAttribute("prpCode", r.getAttribute("prp_code"));
            this.session.setAttribute("ClientCode",
                                      r.getAttribute("prp_clnt_code"));


            Integer EditC = (Integer)this.session.getAttribute("EditClaim");
            if (EditC.intValue() == 0) {
                this.session.setAttribute("PolicyMemCode", null);

                this.session.setAttribute("MemberNumber", null);
                this.membersDesc.setValue(null);

                ADFUtils.findIterator("FindMembersByTransactionsIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.membersLOV);
            } else {
                this.session.setAttribute("ClaimNo", null);
                this.session.setAttribute("ClaimTransNo", null);

                this.session.setAttribute("MemberNumber", null);
            }
        }
        return null;
    }

    public String findMultiPoliciesSelected() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindPoliciesIterator");


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

            this.session.setAttribute("policyNumber",
                                      r.getAttribute("POL_POLICY_NO"));


            this.session.setAttribute("prpCode", r.getAttribute("prp_code"));
            this.session.setAttribute("ClientCode",
                                      r.getAttribute("prp_clnt_code"));


            Integer EditC = (Integer)this.session.getAttribute("EditClaim");
            if (EditC.intValue() == 0) {
                this.session.setAttribute("PolicyMemCode", null);

                this.session.setAttribute("MemberNumber", null);
                this.membersDesc.setValue(null);

                ADFUtils.findIterator("FindMembersByTransactionsIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.membersLOV);

                ADFUtils.findIterator("FindMultipleClaimsMemIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.multipleMemLOV);
            } else {
                this.session.setAttribute("ClaimNo", null);
                this.session.setAttribute("ClaimTransNo", null);

                this.session.setAttribute("MemberNumber", null);

                this.editPolNo.setValue(null);
                this.editTransNo.setValue(null);

                ADFUtils.findIterator("FindClaimTransactionsIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.claimLOV);
            }
        }
        return null;
    }

    public String findCausationsSelected() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindCausationsIterator");


        RowKeySet set = this.causationsLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            this.causationDesc.setValue(r.getAttribute("CAUS_DESC"));

            this.session.setAttribute("CausationCode",
                                      r.getAttribute("CAUS_CODE"));

            this.session.setAttribute("CausationShtDesc",
                                      r.getAttribute("CAUS_SHT_DESC"));


            this.session.setAttribute("CausationType",
                                      r.getAttribute("CAUS_TYPE"));


            this.causeCodeDesc.setValue(null);

            this.session.setAttribute("CauseCode", null);

            ADFUtils.findIterator("FindCausationCausesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.causeCodeLOV);
        }
        return null;
    }

    public String findCausationCodeSelected() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindCausationCausesIterator");


        RowKeySet set = this.causeCodeLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            this.causeCodeDesc.setValue(r.getAttribute("DDC_DESC"));

            this.session.setAttribute("CauseCode", r.getAttribute("DDC_CODE"));
        }
        return null;
    }

    public String SearchClaim() {
        try {
            String Claim = (String)this.session.getAttribute("ClaimNo");
            BigDecimal batchNo =
                (BigDecimal)this.session.getAttribute("clmbatchNo");
            if (Claim == null) {
                String Message = "Select a Claim";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                              Message,
                                                                              Message));


                return null;
            }
            ADFUtils.findIterator("findTicketDetailsByUserIterator").executeQuery();
            String Tasks = (String)this.session.getAttribute("ModuleTickets");
            //System.out.println("TESTING ======" + Tasks);
            if (batchNo != null) {
                System.out.println("BatchNo " + batchNo);
                GlobalCC.RedirectPage("/g_multiclaims.jspx");
            } else if (Tasks.equalsIgnoreCase("Y")) {
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.resultsLOV);
                this.myTickets.setRendered(true);
            } else {
                GlobalCC.RedirectPage("/g_claims.jspx");
            }
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
            e.printStackTrace();
        }
        return null;
    }

    public String SaveNewClaim() {
        if (this.transType.getValue() == null) {
            GlobalCC.INFORMATIONREPORTING("Select a Transaction Type");
            return null;
        }
        String TransType =
            (String)this.session.getAttribute("ClaimTransactionType");
        if (TransType.equalsIgnoreCase("RO")) {
            SaveReopenClaim();
            return null;
        }
        if (TransType.equalsIgnoreCase("CO")) {
            SaveContraClaim();
            return null;
        }
        this.session.setAttribute("ClaimProcessTrans", "Other");

        BigDecimal Pol = (BigDecimal)this.session.getAttribute("policyCode");
        if (Pol == null) {
            GlobalCC.INFORMATIONREPORTING("Select a policy");
            return null;
        }
        BigDecimal PolicyMem =
            (BigDecimal)this.session.getAttribute("PolicyMemCode");
        if (PolicyMem == null) {
            GlobalCC.INFORMATIONREPORTING("Select a policy Member");
            return null;
        }
        if (this.minimumInformationProvided.getValue() == null) {
            GlobalCC.INFORMATIONREPORTING("Specify if minimal information has been provided or not");
            return null;
        }
        if ((this.minimumInformationProvided.getValue().toString().equalsIgnoreCase("N")) &&
            (this.lossDate.getValue() == null)) {
            GlobalCC.INFORMATIONREPORTING("Enter a Loss Date");
            return null;
        }
        if (this.reportDate.getValue() == null) {
            GlobalCC.INFORMATIONREPORTING("Enter a Report Date");
            return null;
        }
        if (this.minimumInformationProvided.getValue().toString().equalsIgnoreCase("N")) {
            BigDecimal Cause =
                (BigDecimal)this.session.getAttribute("CauseCode");
            if (Cause == null) {
                GlobalCC.INFORMATIONREPORTING("select a Causation Cause");
                return null;
            }
        } else {
            BigDecimal Cause =
                (BigDecimal)this.session.getAttribute("CauseCode");
            if ((Cause != null) && (this.lossDate.getValue() != null)) {
                GlobalCC.INFORMATIONREPORTING("Invalid Option for Minimum Information Provided Field. You Have provided the Causation Cause and/or Loss Date ");
                return null;
            }
        }
        if ((this.xgratiaTransaction.isSelected()) &&
            (this.exgratiaRemarks.getValue() == null)) {
            GlobalCC.INFORMATIONREPORTING("Enter an Exgratia Comment.");
            return null;
        }
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        try {
            ADFUtils.findIterator("findPendingClaimTransactionsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.pendingTransactions);

            String pendingTrans =
                (String)this.session.getAttribute("pendingClaim");
            if (pendingTrans.equalsIgnoreCase("Y")) {
                GlobalCC.sysInformation("The Member Selected has another unfinished Claim Transaction");
                this.myPendingTrans.setRendered(true);
                this.nextButton.setDisabled(true);
                return null;
            }
            String Rights = null;
            this.session.setAttribute("ProcessShtDesc", "CLMS");
            this.session.setAttribute("ProcessAreaShtDesc", "ACCS");
            this.session.setAttribute("ProcessSubAShtDesc", "ACCS");
            workflowProcessing wf = new workflowProcessing();
            Rights = wf.CheckUserRights();
            if (Rights.equalsIgnoreCase("N")) {
                String Message =
                    "You do not have rights to Perform this Task.";


                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));


                return null;
            }
            String NextUser = null;
            this.session.setAttribute("ProcessShtDesc", "CLMS");
            this.session.setAttribute("ProcessAreaShtDesc", "ACCS");
            this.session.setAttribute("ProcessSubAShtDesc", "ACCS");
            this.session.setAttribute("TaskAssignee", null);
            this.session.setAttribute("NextTaskAssignee", "N");
            ADFUtils.findIterator("findTicketAssigneeIterator").executeQuery();
            NextUser = (String)this.session.getAttribute("NextTaskAssignee");
            String TaskAss = (String)this.session.getAttribute("TaskAssignee");
            if ((TaskAss == null) && (NextUser.equalsIgnoreCase("N"))) {
                String Message =
                    "There is no User to Assign the Next Task. Consult the Administrator.";


                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));


                return null;
            }
            String Taske = (String)this.session.getAttribute("TaskID");
            if (Taske == null) {
                String Message = "No Task Selected";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));


                return null;
            }
            Taske = (String)this.session.getAttribute("TaskID");
            String Complete;
            if (Taske != null) {
                String MyTask = null;
                CallableStatement cst3 = null;
                Complete =
                        "BEGIN TQC_WEB_PKG.check_task_completion(?,?,?,?);END;";


                cst3 = conn.prepareCall(Complete);
                cst3.setString(1, "CLMINPUT");
                cst3.setString(2, (String)this.session.getAttribute("TaskID"));
                cst3.setInt(3,
                            ((Integer)this.session.getAttribute("sysCode")).intValue());

                cst3.registerOutParameter(4, 12);
                cst3.execute();
                MyTask = cst3.getString(4);
                cst3.close();
                if (MyTask.equalsIgnoreCase("N")) {
                    String Message =
                        "the Task Selected Does not Correspond to the Activity being Performed. Cannot Complete please " +
                        this.session.getAttribute("TaskActivityName");


                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                  Message,
                                                                                  Message));


                    return null;
                }
            }
            String AddClaim =
                "begin LMS_WEB_CLAIMS_PKG.CREATE_NEW_CLAIM(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);end;";


            cst = conn.prepareCall(AddClaim);
            cst.setBigDecimal(1,
                              (BigDecimal)this.session.getAttribute("PolicyMemCode"));
            if (this.lossDate.getValue() == null) {
                cst.setString(2, null);
            } else {
                cst.setString(2,
                              GlobalCC.parseDate(this.lossDate.getValue().toString()));
            }
            if (this.reportDate.getValue() == null) {
                cst.setString(3, null);
            } else {
                cst.setString(3,
                              GlobalCC.parseDate(this.reportDate.getValue().toString()));
            }
            cst.setBigDecimal(4,
                              (BigDecimal)this.session.getAttribute("policyCode"));


            cst.setBigDecimal(5,
                              (BigDecimal)this.session.getAttribute("CausationCode"));


            cst.setString(6,
                          (String)this.session.getAttribute("CausationShtDesc"));

            cst.setString(7,
                          (String)this.session.getAttribute("CausationType"));

            cst.setString(8,
                          (String)this.session.getAttribute("ClaimTransactionType"));


            cst.setString(9, (String)this.session.getAttribute("Username"));
            cst.setBigDecimal(10,
                              (BigDecimal)this.session.getAttribute("CauseCode"));


            cst.registerOutParameter(11, 12);
            cst.registerOutParameter(12, 3);
            cst.setString(13,
                          this.minimumInformationProvided.getValue().toString());
            if (this.xgratiaTransaction.isSelected()) {
                cst.setString(14, "Y");
            } else {
                cst.setString(14, "N");
            }
            if (this.exgratiaRemarks.getValue() == null) {
                cst.setString(15, "N");
            } else {
                cst.setString(15, this.exgratiaRemarks.getValue().toString());
            }
            if (this.deathLocation.getValue() == null) {
                cst.setString(16, null);
            } else {
                cst.setString(16, this.deathLocation.getValue().toString());
            }
            cst.execute();

            this.session.setAttribute("ClaimNo", cst.getString(11));
            this.session.setAttribute("ClaimTransNo", cst.getBigDecimal(12));
            this.session.setAttribute("CoverTypeCode", null);
            cst.close();
            conn.close();

            this.session.setAttribute("ProcessShtDesc", "CLMS");
            this.session.setAttribute("ProcessAreaShtDesc", "ACCS");
            this.session.setAttribute("ProcessSubAShtDesc", "ACCS");
            Rights = wf.CheckUserRights();
            if (Rights.equalsIgnoreCase("N")) {
                this.session.setAttribute("TaskAssignee", null);
                ADFUtils.findIterator("findTicketAssigneeIterator").executeQuery();
                TaskAss = (String)this.session.getAttribute("TaskAssignee");
                if (TaskAss == null) {
                    GetAssignee();
                    return null;
                }
                this.session.setAttribute("TicketRemarks", null);
                wf.CompleteTask();
                GlobalCC.INFORMATIONREPORTING("Current Task Complete. The Next Task " +
                                              (String)this.session.getAttribute("TaskActivityName") +
                                              " has been Successfully assigned to " +
                                              (String)this.session.getAttribute("TaskAssignee"));


                this.session.setAttribute("TaskID", null);
                return null;
            }
            wf.CompleteTask();
            GlobalCC.RedirectPage("/g_claims.jspx");
            return null;
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
        return null;
    }

    public String GetAssignee() {
        try {
            System.out.println("enter popup");
            ExtendedRenderKitService erkService =
                (ExtendedRenderKitService)Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                                             ExtendedRenderKitService.class);


            erkService.addScript(FacesContext.getCurrentInstance(),
                                 "var hints = {autodismissNever:false}; AdfPage.PAGE.findComponent('pt1:users').show(hints);");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String AssignTask() {
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
                    (this.ticketRemarks.getValue().toString().equalsIgnoreCase("Add Remark..."))) {
                    this.session.setAttribute("TicketRemarks", null);
                } else {
                    this.session.setAttribute("TicketRemarks",
                                              this.ticketRemarks.getValue().toString());
                }
            }
            workflowProcessing bpm = new workflowProcessing();
            bpm.CompleteTask();

            String CurrUser = (String)this.session.getAttribute("Username");
            String TaskAss = (String)this.session.getAttribute("TaskAssignee");
            if (!TaskAss.equalsIgnoreCase(CurrUser)) {
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
            String Message = "You have Successfully Completed this Task.";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));


            return null;
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String CompleteChequeDispatch() {
        Connection conn = null;
        CallableStatement cst3 = null;
        try {
            conn = new DBConnector().getDatabaseConn();

            workflowProcessing bpm = new workflowProcessing();
            String Rights = null;
            this.session.setAttribute("ProcessShtDesc", "CLMS");
            this.session.setAttribute("ProcessAreaShtDesc", "ACCS");
            this.session.setAttribute("ProcessSubAShtDesc", "ACCS");

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
            String NextUser = null;
            this.session.setAttribute("ProcessShtDesc", "CLMS");
            this.session.setAttribute("ProcessAreaShtDesc", "ACCS");
            this.session.setAttribute("ProcessSubAShtDesc", "ACCS");

            this.session.setAttribute("TaskAssignee", null);
            this.session.setAttribute("NextTaskAssignee", "N");
            ADFUtils.findIterator("findTicketAssigneeIterator").executeQuery();
            NextUser = (String)this.session.getAttribute("NextTaskAssignee");
            String TaskAss = (String)this.session.getAttribute("TaskAssignee");
            if ((TaskAss == null) && (NextUser.equalsIgnoreCase("N"))) {
                String Message =
                    "There is no User to Assign the Next Task. Consult the Administrator.";


                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));


                return null;
            }
            String Taske = (String)this.session.getAttribute("TaskID");
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
            cst3.setString(1, "CLMDISP");
            cst3.setString(2, (String)this.session.getAttribute("TaskID"));
            cst3.setInt(3, 27);
            cst3.registerOutParameter(4, 12);
            cst3.execute();

            MyTask = cst3.getString(4);
            cst3.close();
            conn.close();
            if (MyTask.equalsIgnoreCase("N")) {
                String Message =
                    "the Task Selected Does not Correspond to the Activity being Performed. Cannot Complete please " +
                    this.session.getAttribute("TaskActivityName");


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
                String Message = "Dispatch Successfully Done";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));
            } else {
                TaskAss = (String)this.session.getAttribute("TaskAssignee");
                String str5;
                if (TaskAss == null) {
                    GetAssignee();
                    return null;
                }
                wf.CompleteTask();
                String Message =
                    "Current Task Complete. The Next Task " + (String)this.session.getAttribute("TaskActivityName") +
                    " has been Successfully assigned to " +
                    (String)this.session.getAttribute("TaskAssignee");


                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));


                this.session.setAttribute("TaskID", null);
                return null;
            }
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        } finally {
            GlobalCC.CloseConnections(null, cst3, conn);
        }
        return null;
    }

    public String CompleteAcknowlegmentDispatch() {
        Connection conn = null;
        CallableStatement cst3 = null;
        try {
            conn = new DBConnector().getDatabaseConn();

            workflowProcessing bpm = new workflowProcessing();
            String Rights = null;
            this.session.setAttribute("ProcessShtDesc", "CLMS");
            this.session.setAttribute("ProcessAreaShtDesc", "ACCS");
            this.session.setAttribute("ProcessSubAShtDesc", "ACCS");

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
            String NextUser = null;
            this.session.setAttribute("ProcessShtDesc", "CLMS");
            this.session.setAttribute("ProcessAreaShtDesc", "ACCS");
            this.session.setAttribute("ProcessSubAShtDesc", "ACCS");

            this.session.setAttribute("TaskAssignee", null);
            this.session.setAttribute("NextTaskAssignee", "N");
            ADFUtils.findIterator("findTicketAssigneeIterator").executeQuery();
            NextUser = (String)this.session.getAttribute("NextTaskAssignee");
            String TaskAss = (String)this.session.getAttribute("TaskAssignee");
            if ((TaskAss == null) && (NextUser.equalsIgnoreCase("N"))) {
                String Message =
                    "There is no User to Assign the Next Task. Consult the Administrator.";


                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));


                return null;
            }
            String Taske = (String)this.session.getAttribute("TaskID");
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
            cst3.setString(1, "CLMACKDISP");
            cst3.setString(2, (String)this.session.getAttribute("TaskID"));
            cst3.setInt(3,
                        ((Integer)this.session.getAttribute("sysCode")).intValue());

            cst3.registerOutParameter(4, 12);
            cst3.execute();

            MyTask = cst3.getString(4);
            cst3.close();
            conn.close();
            if (MyTask.equalsIgnoreCase("N")) {
                String Message =
                    "the Task Selected Does not Correspond to the Activity being Performed. Cannot Complete please " +
                    this.session.getAttribute("TaskActivityName");


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
                String Message = "Dispatch Successfully Done";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));
            } else {
                TaskAss = (String)this.session.getAttribute("TaskAssignee");
                String str5;
                if (TaskAss == null) {
                    GetAssignee();
                    return null;
                }
                wf.CompleteTask();
                String Message =
                    "Current Task Complete. The Next Task " + (String)this.session.getAttribute("TaskActivityName") +
                    " has been Successfully assigned to " +
                    (String)this.session.getAttribute("TaskAssignee");


                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));


                this.session.setAttribute("TaskID", null);
                return null;
            }
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        } finally {
            GlobalCC.CloseConnections(null, cst3, conn);
        }
        return null;
    }

    public String CompleteDocumentReceipt() {
        Connection conn = null;
        CallableStatement cst3 = null;
        try {
            conn = new DBConnector().getDatabaseConn();

            workflowProcessing bpm = new workflowProcessing();
            String Rights = null;
            this.session.setAttribute("ProcessShtDesc", "CLMS");
            this.session.setAttribute("ProcessAreaShtDesc", "ACCS");
            this.session.setAttribute("ProcessSubAShtDesc", "ACCS");

            Rights = bpm.CheckUserRights();
            if (Rights.equalsIgnoreCase("N")) {
                GlobalCC.INFORMATIONREPORTING("You do not have rights to Complete this Task.");
                return null;
            }
            String NextUser = null;
            this.session.setAttribute("ProcessShtDesc", "CLMS");
            this.session.setAttribute("ProcessAreaShtDesc", "VCHR");
            this.session.setAttribute("ProcessSubAShtDesc", "CLMR");

            this.session.setAttribute("TaskAssignee", null);
            this.session.setAttribute("NextTaskAssignee", "N");
            ADFUtils.findIterator("findTicketAssigneeIterator").executeQuery();
            NextUser = (String)this.session.getAttribute("NextTaskAssignee");
            String TaskAss = (String)this.session.getAttribute("TaskAssignee");
            if ((this.session.getAttribute("Username") != null) &&
                (TaskAss == null)) {
                this.session.setAttribute("TaskAssignee",
                                          this.session.getAttribute("Username"));

                TaskAss = (String)this.session.getAttribute("Username");
            }
            if ((TaskAss == null) && (NextUser.equalsIgnoreCase("N"))) {
                GlobalCC.INFORMATIONREPORTING("There is no User to Assign the Next Task. Consult the Administrator.");
                return null;
            }
            String Taske = (String)this.session.getAttribute("TaskID");
            if (Taske == null) {
                GlobalCC.INFORMATIONREPORTING("No Task Selected");
                return null;
            }
            String MyTask = null;

            String Complete =
                "BEGIN TQC_WEB_PKG.check_task_completion(?,?,?,?);END;";


            cst3 = conn.prepareCall(Complete);
            cst3.setString(1, "CLMWAIT");
            cst3.setString(2, (String)this.session.getAttribute("TaskID"));
            cst3.setInt(3,
                        ((Integer)this.session.getAttribute("sysCode")).intValue());

            cst3.registerOutParameter(4, 12);
            cst3.execute();

            MyTask = cst3.getString(4);
            cst3.close();
            if (MyTask.equalsIgnoreCase("N")) {
                GlobalCC.INFORMATIONREPORTING("the Task Selected Does not Correspond to the Activity being Performed. Cannot Complete please " +
                                              this.session.getAttribute("TaskActivityName"));

                return null;
            }
            String SubmitQuery =
                "BEGIN LMS_WEB_CLAIMS_PKG.validate_clm_docs_submited(?,?);END;";


            CallableStatement cstQuery = conn.prepareCall(SubmitQuery);
            cstQuery.setString(1,
                               (String)this.session.getAttribute("ClaimNo"));

            cstQuery.registerOutParameter(2, 12);
            cstQuery.execute();

            String Submitted = cstQuery.getString(2);
            String str5;
            if (Submitted == null) {
                GlobalCC.errorValueNotEntered("Error Determining If all Documents have been submitted");
                return null;
            }
            if (Submitted.equalsIgnoreCase("N")) {
                GlobalCC.INFORMATIONREPORTING("Please Ensure all Documents have been submitted before Proceeding");
                return null;
            }
            cstQuery.close();
            conn.close();

            workflowProcessing wf = new workflowProcessing();
            Rights = bpm.CheckUserRights();
            if (Rights.equalsIgnoreCase("Y")) {
                wf.CompleteTask();
                GlobalCC.INFORMATIONREPORTING("All Documents Successfully Recieved.");
            } else {
                TaskAss = (String)this.session.getAttribute("TaskAssignee");
                String str6;
                if (TaskAss == null) {
                    GetAssignee();
                    return null;
                }
                wf.CompleteTask();
                GlobalCC.INFORMATIONREPORTING("Current Task Complete. The Next Task " +
                                              (String)this.session.getAttribute("TaskActivityName") +
                                              " has been Successfully assigned to " +
                                              (String)this.session.getAttribute("TaskAssignee"));


                this.session.setAttribute("TaskID", null);
                return null;
            }
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        } finally {
            GlobalCC.CloseConnections(null, cst3, conn);
        }
        return null;
    }

    public String AddClaimCover() {
        this.session.setAttribute("CoverTypeCode", null);
        this.session.setAttribute("PCT_CODE", null);
        this.cvrSelection.setDisabled(false);
        this.coverDesc.setValue(null);
        this.amtClaimed.setValue(null);
        this.butPay.setValue(null);
        this.remarks.setValue(null);
        this.payee.setValue(null);
        this.xgratiaSA.setValue(null);
        this.xgratiaEarningsAmt.setValue(null);
        this.xgratiaEarningsPrd.setValue(null);

        GlobalCC.showPopup("lmsgroup:editCover");

        return null;
    }

    public String editClaimCover() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindClaimCoverTypesIterator");


        RowKeySet set = this.coversLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        BigDecimal intendedSavings = null;
        BigDecimal clmInst = null;
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
            intendedSavings =
                    (BigDecimal)r.getAttribute("CCVT_INT_SAVING_AMT");


            clmInst = (BigDecimal)r.getAttribute("CCVT_PAY_INST");

            this.session.setAttribute("CoverTypeCode",
                                      r.getAttribute("CCVT_CODE"));

            this.session.setAttribute("PCT_CODE",
                                      r.getAttribute("ccvt_pct_code"));

            this.cvrSelection.setDisabled(true);
            this.coverDesc.setValue(r.getAttribute("CVT_DESC"));
            this.amtClaimed.setValue(r.getAttribute("CCVT_AMT_TO_BE_PAID"));
            this.butPay.setValue(r.getAttribute("CCVT_BUT_PAY_AMT"));
            this.remarks.setValue(r.getAttribute("CCVT_REMARKS"));
            this.payee.setValue(r.getAttribute("CCVT_PAYEE"));

            this.clm_pymnt_inst.setValue(r.getAttribute("CCVT_PAY_INST"));

            this.actualSavingsTF.setValue(r.getAttribute("CCVT_INT_SAVING_AMT"));

            String Value = (String)r.getAttribute("CLM_PAY_TOT_COINS_AMT");
            String occBen = (String)r.getAttribute("CCVT_CVT_OCC_BEN");

            this.occBenTF.setValue(r.getAttribute("CCVT_OCC_BEN_RATE"));
            if (Value.equalsIgnoreCase("Y")) {
                this.totalCoinsAmt.setSelected(true);
            } else {
                this.totalCoinsAmt.setSelected(false);
            }
            String Exgratia =
                (String)this.session.getAttribute("exgratiaClaim");
            if (Exgratia == null) {
                this.xgratiaSA.setValue(null);
                this.xgratiaEarningsAmt.setValue(null);
                this.xgratiaEarningsPrd.setValue(null);
            } else if (Exgratia.equalsIgnoreCase("Y")) {
                this.xgratiaSA.setValue(r.getAttribute("CCVT_SA"));
                this.xgratiaEarningsAmt.setValue(r.getAttribute("CCVT_EARNINGS"));
                this.xgratiaEarningsPrd.setValue(r.getAttribute("CCVT_MULT_EARNINGS_PRD"));
            } else {
                this.xgratiaSA.setValue(null);
                this.xgratiaEarningsAmt.setValue(null);
                this.xgratiaEarningsPrd.setValue(null);
            }
            if (occBen != null) {
                if (occBen.equalsIgnoreCase("Y")) {
                    this.occBenLab.setRendered(true);
                    this.occBenTF.setRendered(true);
                } else {
                    this.occBenLab.setRendered(false);
                    this.occBenTF.setRendered(false);
                }
            }
            GlobalCC.showPopup("lmsgroup:editCover");
        }
        return null;
    }

    public String DeleteClaimCover() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("FindClaimCoverTypesIterator");


            RowKeySet set = this.coversLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                String UpdateClaim =
                    "begin LMS_WEB_PKG_GRP.del_claim_cvr_details(?);end;";


                cst = conn.prepareCall(UpdateClaim);
                cst.setBigDecimal(1, (BigDecimal)r.getAttribute("CCVT_CODE"));
                cst.execute();
                cst.close();
                conn.close();

                ADFUtils.findIterator("FindClaimCoverTypesIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.coversLOV);
            }
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
        return null;
    }

    public String UpdateClaimCoverDetails() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        try {
            String str1;
            if (this.payee.getValue() == null) {
                String Message1 = "Select a Payee";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message1,
                                                                              Message1));


                return null;
            }
            if (this.payee.getValue().toString().equalsIgnoreCase("O")) {
                editOtherPayee2();
                return null;
            }
            String UpdateClaim =
                "begin LMS_WEB_PKG_GRP.update_claim_cvr_details(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);end;";


            cst = conn.prepareCall(UpdateClaim);

            cst.setBigDecimal(1,
                              (BigDecimal)this.session.getAttribute("CoverTypeCode"));
            if (this.amtClaimed.getValue() == null) {
                cst.setBigDecimal(2, null);
            } else {
                cst.setString(2, this.amtClaimed.getValue().toString());
            }
            if (this.butPay.getValue() == null) {
                cst.setBigDecimal(3, null);
            } else {
                cst.setString(3, this.butPay.getValue().toString());
            }
            if (this.remarks.getValue() == null) {
                cst.setString(4, null);
            } else {
                cst.setString(4, this.remarks.getValue().toString());
            }
            if (this.payee.getValue() == null) {
                cst.setString(5, null);
            } else {
                cst.setString(5, this.payee.getValue().toString());
            }
            cst.setString(6, null);
            if (this.totalCoinsAmt.isSelected()) {
                cst.setString(7, "Y");
            } else {
                cst.setString(7, "N");
            }
            cst.setString(8, (String)this.session.getAttribute("ClaimNo"));
            cst.setBigDecimal(9,
                              (BigDecimal)this.session.getAttribute("PCT_CODE"));
            if (this.xgratiaSA.getValue() == null) {
                cst.setString(10, null);
            } else {
                cst.setString(10, this.xgratiaSA.getValue().toString());
            }
            if (this.xgratiaEarningsAmt.getValue() == null) {
                cst.setString(11, null);
            } else {
                cst.setString(11,
                              this.xgratiaEarningsAmt.getValue().toString());
            }
            if (this.xgratiaEarningsPrd.getValue() == null) {
                cst.setString(12, null);
            } else {
                cst.setString(12,
                              this.xgratiaEarningsPrd.getValue().toString());
            }
            if (this.clm_pymnt_inst.getValue() == null) {
                cst.setString(13, null);
            } else {
                cst.setString(13, this.clm_pymnt_inst.getValue().toString());
            }
            if (this.actualSavingsTF.getValue() == null) {
                cst.setString(14, null);
            } else {
                cst.setString(14, this.actualSavingsTF.getValue().toString());
            }
            if (this.occBenTF.getValue() == null) {
                cst.setString(15, null);
            } else {
                cst.setString(15, this.occBenTF.getValue().toString());
            }
            if (this.cvtPayable.getValue() == null) {
                cst.setString(16, "Y");
            } else {
                cst.setString(16, this.cvtPayable.getValue().toString());
            }
            cst.execute();
            cst.close();
            this.session.setAttribute("CoverTypeCode", null);

            GlobalCC.INFORMATIONREPORTING("Cover Successfully Updated");

            GlobalCC.hidePopup("lmsgroup:editCover");
            ADFUtils.findIterator("FindClaimCoverTypesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.coversLOV);

            ADFUtils.findIterator("FindClaimsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.reserveAmt);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.clmAmountClaimed);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.amtToPay);

            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
        return null;
    }

    public void ProductCoverTypeListener(ValueChangeEvent valueChangeEvent) {
        if ((valueChangeEvent.getNewValue() != null) &&
            (valueChangeEvent.getOldValue() !=
             valueChangeEvent.getNewValue())) {
            if (this.cvrSelection.getValue() != null) {
                DCIteratorBinding dciter =
                    ADFUtils.findIterator("FindProductCoversIter");


                Row r =
                    dciter.getRowAtRangeIndex(((Integer)valueChangeEvent.getNewValue()).intValue());


                this.session.setAttribute("PCT_CODE",
                                          r.getAttribute("pct_code"));
            }
        }
    }

    public String ShowBeneficiaries() {
        this.session.setAttribute("benModule", "C");
        ADFUtils.findIterator("FindMembersBeneficiariesIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.studentsLOV);

        GlobalCC.showPopup("lmsgroup:beneficiaries");
        return null;
    }

    public String AddStudent() {
        this.studentNames.setValue(null);
        this.studentSurname.setValue(null);
        this.studentMemNo.setValue(null);
        this.studentDOB.setValue(null);
        this.studentSex.setValue(null);
        this.rsaPin.setValue(null);
        this.agencyDesc.setValue(null);
        this.session.setAttribute("gagnCode", null);
        this.session.setAttribute("action", "A");
        GlobalCC.showPopup("lmsgroup:studentDetails");
        return null;
    }

    public String EditStudent() {
        try {
            RowKeySet rowKeySet = this.studentsLOV.getSelectedRowKeys();
            if (rowKeySet == null) {
                return null;
            }
            if (!rowKeySet.iterator().hasNext()) {
                GlobalCC.errorValueNotEntered("No Record Selected");
                return null;
            }
            Object key2 = rowKeySet.iterator().next();
            this.studentsLOV.setRowKey(key2);
            JUCtrlValueBinding nodeBinding =
                (JUCtrlValueBinding)this.studentsLOV.getRowData();
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
            this.studentSex.setValue(nodeBinding.getAttribute("qmem_ben_sex"));
            this.studentSharePct.setValue(nodeBinding.getAttribute("pmem_share_pct"));
            this.rsaPin.setValue(nodeBinding.getAttribute("pmem_share_pct"));
            this.agencyDesc.setValue(nodeBinding.getAttribute("pmem_share_pct"));
            this.session.setAttribute("gagnCode",
                                      nodeBinding.getAttribute("pmem_share_pct"));
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String findGovtAgencySelected() {
        try {
            RowKeySet rowKeySet = this.agencyTable.getSelectedRowKeys();
            if (!rowKeySet.iterator().hasNext()) {
                GlobalCC.errorValueNotEntered("Error: No Record Selected");
            }
            Object key2 = rowKeySet.iterator().next();
            this.agencyTable.setRowKey(key2);

            JUCtrlValueBinding r =
                (JUCtrlValueBinding)this.agencyTable.getRowData();
            if (r == null) {
                GlobalCC.errorValueNotEntered("Error: No Record Selected");
            }
            this.session.setAttribute("gagnCode", r.getAttribute("SPR_CODE"));
            this.agencyDesc.setValue(r.getAttribute("SPR_NAME"));
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.agencyDesc);

            GlobalCC.hidePopup("lmsgroup:p5");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String SaveStudent() {
        Connection conn = null;
        CallableStatement cst = null;
        try {
            BigDecimal MemberCode =
                (BigDecimal)this.session.getAttribute("MemberNumber");
            String str1;
            if (MemberCode == null) {
                GlobalCC.errorValueNotEntered("Select A Parent");
                return null;
            }
            if (this.studentSharePct.getValue() == null) {
                GlobalCC.INFORMATIONREPORTING("Enter a Share Percentage");
                return null;
            }
            DBConnector datahandler = null;
            datahandler = new DBConnector();

            conn = datahandler.getDatabaseConn();

            String reinQuery =
                "begin LMS_WEB_PKG_GRP_UW.save_beneficiary_dtls(?,?,?,?,?,?,?,?,?,?,?,?); end;";


            cst = conn.prepareCall(reinQuery);
            cst.setString(1, (String)this.session.getAttribute("action"));
            cst.setBigDecimal(2,
                              (BigDecimal)this.session.getAttribute("studentBenCode"));


            cst.setBigDecimal(3,
                              (BigDecimal)this.session.getAttribute("MemberNumber"));
            if (this.studentSurname.getValue() == null) {
                cst.setString(4, null);
            } else {
                cst.setString(4, this.studentSurname.getValue().toString());
            }
            if (this.studentNames.getValue() == null) {
                cst.setString(5, null);
            } else {
                cst.setString(5, this.studentNames.getValue().toString());
            }
            cst.setBigDecimal(6,
                              (BigDecimal)this.session.getAttribute("endorsementCode"));
            if (this.studentSex.getValue() == null) {
                cst.setString(7, null);
            } else {
                cst.setString(7, this.studentSex.getValue().toString());
            }
            if (this.studentMemNo.getValue() == null) {
                cst.setString(8, null);
            } else {
                cst.setString(8, this.studentMemNo.getValue().toString());
            }
            cst.setBigDecimal(9,
                              (BigDecimal)this.session.getAttribute("policyCode"));
            if (this.studentSharePct.getValue() == null) {
                cst.setString(10, null);
            } else {
                cst.setString(10, this.studentSharePct.getValue().toString());
            }
            cst.setBigDecimal(11,
                              (BigDecimal)this.session.getAttribute("gagnCode"));
            if (this.rsaPin.getValue() == null) {
                cst.setString(12, null);
            } else {
                cst.setString(12, this.rsaPin.getValue().toString());
            }
            cst.execute();
            cst.close();
            conn.close();

            GlobalCC.sysInformation("Record Successfully Saved");
            GlobalCC.hidePopup("lmsgroup:studentDetails");

            ADFUtils.findIterator("FindMembersBeneficiariesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.studentsLOV);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
        return null;
    }

    public String DeleteStudent() {
        Connection conn = null;
        CallableStatement cst = null;
        try {
            RowKeySet rowKeySet = this.studentsLOV.getSelectedRowKeys();
            String str1;
            if (rowKeySet == null) {
                return null;
            }
            if (!rowKeySet.iterator().hasNext()) {
                GlobalCC.errorValueNotEntered("No Record Selected");
                return null;
            }
            Object key2 = rowKeySet.iterator().next();
            this.studentsLOV.setRowKey(key2);
            JUCtrlValueBinding r =
                (JUCtrlValueBinding)this.studentsLOV.getRowData();
            if (r == null) {
                GlobalCC.errorValueNotEntered("No Record Selected");
                return null;
            }
            this.session.setAttribute("action", "D");
            DBConnector datahandler = null;
            datahandler = new DBConnector();

            conn = datahandler.getDatabaseConn();
            String reinQuerys =
                "begin LMS_WEB_PKG_GRP_UW.save_beneficiary_dtls(?,?,?,?,?,?,?,?,?,?,?,?); end;";

            cst = conn.prepareCall(reinQuerys);
            cst.setString(1, (String)this.session.getAttribute("action"));
            String action = (String)this.session.getAttribute("action");
            cst.setBigDecimal(2,
                              (BigDecimal)this.session.getAttribute("studentBenCode"));


            cst.setBigDecimal(3,
                              (BigDecimal)this.session.getAttribute("MemberNumber"));

            BigDecimal benMem =
                (BigDecimal)this.session.getAttribute("studentBenCode");

            System.out.println("benMe==" + benMem);
            System.out.println("action==" + action);
            if (this.studentSurname.getValue() == null) {
                cst.setString(4, null);
            } else {
                cst.setString(4, this.studentSurname.getValue().toString());
            }
            if (this.studentNames.getValue() == null) {
                cst.setString(5, null);
            } else {
                cst.setString(5, this.studentNames.getValue().toString());
            }
            cst.setBigDecimal(6,
                              (BigDecimal)this.session.getAttribute("endorsementCode"));
            if (this.studentSex.getValue() == null) {
                cst.setString(7, null);
            } else {
                cst.setString(7, this.studentSex.getValue().toString());
            }
            if (this.studentMemNo.getValue() == null) {
                cst.setString(8, null);
            } else {
                cst.setString(8, this.studentMemNo.getValue().toString());
            }
            cst.setBigDecimal(9,
                              (BigDecimal)this.session.getAttribute("policyCode"));
            if (this.studentSharePct.getValue() == null) {
                cst.setString(10, null);
            } else {
                cst.setString(10, this.studentSharePct.getValue().toString());
            }
            cst.setBigDecimal(11,
                              (BigDecimal)this.session.getAttribute("gagnCode"));
            if (this.rsaPin.getValue() == null) {
                cst.setString(12, null);
            } else {
                cst.setString(12, this.rsaPin.getValue().toString());
            }
            cst.execute();
            cst.close();
            conn.close();
            GlobalCC.INFORMATIONREPORTING("Beneficiary Deleted Successfully");
            ADFUtils.findIterator("FindMembersBeneficiariesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.studentsLOV);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
        return null;
    }

    public String ProcessClaim() {
        Connection conn = null;
        CallableStatement cst = null;
        try {
            boolean MakeCall = false;
            DBConnector db = new DBConnector();
            conn = db.getDatabaseConn();

            cst =
conn.prepareCall("begin LMS_WEB_CLAIMS_PKG.PROCESS_CLAIM(?,?);end;");


            int rowCount = 0;
            boolean Value = false;
            rowCount = this.coversLOV.getRowCount();
            if (rowCount == 0) {
                return null;
            }
            for (int i = 0; i < rowCount; i++) {
                this.coversLOV.setRowIndex(i);
                JUCtrlValueBinding nodeBinding =
                    (JUCtrlValueBinding)this.coversLOV.getRowData();
                if (nodeBinding != null) {
                    Value =
                            ((Boolean)nodeBinding.getAttribute("selected")).booleanValue();
                    if (Value == true) {
                        MakeCall = true;
                        cst.setString(1,
                                      (String)this.session.getAttribute("ClaimNo"));


                        cst.setBigDecimal(2,
                                          (BigDecimal)nodeBinding.getAttribute("CCVT_CODE"));


                        cst.execute();
                    }
                }
            }
            cst.close();
            conn.close();

            GlobalCC.INFORMATIONREPORTING("Claim Processing Complete");
            this.session.setAttribute("CoverTypeCode", null);
            ADFUtils.findIterator("FindClaimCoverTypesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.coversLOV);

            ADFUtils.findIterator("FindClaimsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.reserveAmt);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.clmAmountClaimed);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.amtToPay);

            ADFUtils.findIterator("findClaimBeneficaryPaymentsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.beneficaryPayments);

            ADFUtils.findIterator("FindClaimCoinsuranceRecoveriesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.claimRecoveries);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
        return null;
    }

    public String ProcessEducationClaim() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        String PayCoin = null;
        CallableStatement cst = null;
        try {
            if ((this.totalCoinsAmt.isRendered()) &&
                (this.totalCoinsAmt.isSelected())) {
                PayCoin = "Y";
            } else {
                PayCoin = "N";
            }
            String AddClaim =
                "begin LMS_WEB_CLAIMS_PKG.PROCESS_CLAIM(?,?,?);end;";


            cst = conn.prepareCall(AddClaim);

            cst.setString(1, (String)this.session.getAttribute("ClaimNo"));
            cst.setBigDecimal(2, null);
            cst.setString(3, PayCoin);
            cst.execute();
            cst.close();

            GlobalCC.INFORMATIONREPORTING("Claim Processing Complete");

            ADFUtils.findIterator("FindClaimCoverTypesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.coversLOV);

            ADFUtils.findIterator("FindClaimsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.reserveAmt);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.clmAmountClaimed);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.amtToPay);

            ADFUtils.findIterator("findClaimBeneficaryPaymentsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.beneficaryPayments);

            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
        return null;
    }

    public String SaveBeneficiaryPayments() {
        Connection conn = null;
        CallableStatement cst = null;
        try {
            BigDecimal BenPayment = null;

            String Query =
                "begin LMS_WEB_CLAIMS_PKG.Update_Beneficiary_pymts(?,?,?); end;";


            DBConnector datahandler = new DBConnector();

            conn = datahandler.getDatabaseConn();
            cst = conn.prepareCall(Query);

            DCIteratorBinding dciter =
                ADFUtils.findIterator("findClaimBeneficaryPaymentsIterator");


            int rowCount = this.beneficaryPayments.getRowCount();
            for (int i = 0; i < rowCount; i++) {
                this.beneficaryPayments.setRowIndex(i);
                List l = (List)this.beneficaryPayments.getRowKey();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                BenPayment = (BigDecimal)r.getAttribute("BPY_CODE");

                cst.setBigDecimal(1, BenPayment);
                if (this.feesAmount.getValue() == null) {
                    cst.setBigDecimal(2, null);
                } else {
                    cst.setString(2, this.feesAmount.getValue().toString());
                }
                if (this.beneficaryPaid.getValue() == null) {
                    cst.setBigDecimal(3, null);
                } else {
                    cst.setString(3,
                                  this.beneficaryPaid.getValue().toString());
                }
                cst.execute();
            }
            cst.close();
            conn.close();
            GlobalCC.INFORMATIONREPORTING("Beneficiary Payments Successfully Saved");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
            e.printStackTrace();
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
        return null;
    }

    public String PayBeneficiaryAnnInstallment() {
        Connection conn = null;
        CallableStatement cst = null;
        String Query =
            "begin LMS_WEB_CLAIMS_PKG.process_benef_ann_instlmnt(?,?,?,?,?,?); end;";
        try {
            DBConnector datahandler = new DBConnector();

            conn = datahandler.getDatabaseConn();

            String Rights = null;
            this.session.setAttribute("ProcessShtDesc", "CLMS");
            this.session.setAttribute("ProcessAreaShtDesc", "VCHR");
            this.session.setAttribute("ProcessSubAShtDesc", "CLMR");
            workflowProcessing wf = new workflowProcessing();
            Rights = wf.CheckUserRights();
            if (Rights.equalsIgnoreCase("N")) {
                String Message =
                    "You do not have rights to Perform this Task.";


                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));


                return null;
            }
            String NextUser = null;
            this.session.setAttribute("ProcessShtDesc", "CLMS");
            this.session.setAttribute("ProcessAreaShtDesc", "VCHR");
            this.session.setAttribute("ProcessSubAShtDesc", "CLMR");
            this.session.setAttribute("TaskAssignee", null);
            this.session.setAttribute("NextTaskAssignee", "N");
            ADFUtils.findIterator("findTicketAssigneeIterator").executeQuery();
            NextUser = (String)this.session.getAttribute("NextTaskAssignee");
            String TaskAss = (String)this.session.getAttribute("TaskAssignee");
            if ((TaskAss == null) && (NextUser.equalsIgnoreCase("N"))) {
                String Message =
                    "There is no User to Assign the Next Task. Consult the Administrator.";


                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));


                return null;
            }
            String Taske = (String)this.session.getAttribute("TaskID");
            if (Taske == null) {
                String Message = "No Task Selected";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));


                return null;
            }
            Taske = (String)this.session.getAttribute("TaskID");
            if (Taske != null) {
                String MyTask = null;
                CallableStatement cst3 = null;
                String Complete =
                    "BEGIN TQC_WEB_PKG.check_task_completion(?,?,?,?);END;";


                cst3 = conn.prepareCall(Complete);
                cst3.setString(1, "CLMVCHR");
                cst3.setString(2, (String)this.session.getAttribute("TaskID"));
                cst3.setInt(3,
                            ((Integer)this.session.getAttribute("sysCode")).intValue());

                cst3.registerOutParameter(4, 12);
                cst3.execute();
                MyTask = cst3.getString(4);
                cst3.close();
                if (MyTask.equalsIgnoreCase("N")) {
                    String Message =
                        "the Task Selected Does not Correspond to the Activity being Performed. Cannot Complete please " +
                        this.session.getAttribute("TaskActivityName");


                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                  Message,
                                                                                  Message));


                    return null;
                }
            }
            cst = conn.prepareCall(Query);

            int i = 0;

            DCIteratorBinding dciter =
                ADFUtils.findIterator("findClaimAnnBeneficaryPaymentsIterator");


            RowKeySet set = this.annuitiesTable.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();
            Row r;
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                r = dciter.getCurrentRow();

                cst.setString(1, (String)this.session.getAttribute("ClaimNo"));
                cst.setBigDecimal(2, (BigDecimal)r.getAttribute("PABP_CODE"));
                cst.setBigDecimal(3,
                                  (BigDecimal)this.session.getAttribute("policyCode"));


                cst.setBigDecimal(4,
                                  (BigDecimal)this.session.getAttribute("ClaimTransNo"));


                cst.setBigDecimal(5, null);
                cst.setBigDecimal(6, null);
                cst.execute();
                i++;
            }
            cst.close();
            conn.close();
            this.session.setAttribute("ProcessAreaShtDesc", "VCHR");
            this.session.setAttribute("ProcessSubAShtDesc", "CLMR");
            Rights = wf.CheckUserRights();
            String str5;
            if (Rights.equalsIgnoreCase("N")) {
                this.session.setAttribute("TaskAssignee", null);
                ADFUtils.findIterator("findTicketAssigneeIterator").executeQuery();
                TaskAss = (String)this.session.getAttribute("TaskAssignee");
                if (TaskAss == null) {
                    GetAssignee();
                    return null;
                }
                this.session.setAttribute("TicketRemarks", null);
                wf.CompleteTask();
                String Message =
                    "Current Task Complete. The Next Task " + (String)this.session.getAttribute("TaskActivityName") +
                    " has been Successfully assigned to " +
                    (String)this.session.getAttribute("TaskAssignee");


                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));


                this.session.setAttribute("TaskID", null);
                return null;
            }
            wf.CompleteTask();
            if (i > 0) {
                GlobalCC.RedirectPage("/g_clmpym.jspx");
            }
            ADFUtils.findIterator("findClaimAnnBeneficaryPaymentsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.annuitiesTable);

            String Message = "Voucher Processing Completed";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));


            return null;
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
        return null;
    }

    public String PayBeneficiaryInstallment() {
        Connection conn = null;
        CallableStatement cst = null;
        String Query =
            "begin LMS_WEB_CLAIMS_PKG.PROCESS_BENEF_PAY_INSTLMNT(?,?,?,?,?,?); end;";
        try {
            DBConnector datahandler = new DBConnector();

            conn = datahandler.getDatabaseConn();

            String Rights = null;
            this.session.setAttribute("ProcessShtDesc", "CLMS");
            this.session.setAttribute("ProcessAreaShtDesc", "VCHR");
            this.session.setAttribute("ProcessSubAShtDesc", "CLMR");
            workflowProcessing wf = new workflowProcessing();
            Rights = wf.CheckUserRights();
            if (Rights.equalsIgnoreCase("N")) {
                String Message =
                    "You do not have rights to Perform this Task.";


                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));


                return null;
            }
            String NextUser = null;
            this.session.setAttribute("ProcessShtDesc", "CLMS");
            this.session.setAttribute("ProcessAreaShtDesc", "VCHR");
            this.session.setAttribute("ProcessSubAShtDesc", "CLMR");
            this.session.setAttribute("TaskAssignee", null);
            this.session.setAttribute("NextTaskAssignee", "N");
            ADFUtils.findIterator("findTicketAssigneeIterator").executeQuery();
            NextUser = (String)this.session.getAttribute("NextTaskAssignee");
            String TaskAss = (String)this.session.getAttribute("TaskAssignee");
            if ((TaskAss == null) && (NextUser.equalsIgnoreCase("N"))) {
                String Message =
                    "There is no User to Assign the Next Task. Consult the Administrator.";


                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));


                return null;
            }
            String Taske = (String)this.session.getAttribute("TaskID");
            if (Taske == null) {
                String Message = "No Task Selected";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));


                return null;
            }
            Taske = (String)this.session.getAttribute("TaskID");
            if (Taske != null) {
                String MyTask = null;
                CallableStatement cst3 = null;
                String Complete =
                    "BEGIN TQC_WEB_PKG.check_task_completion(?,?,?,?);END;";


                cst3 = conn.prepareCall(Complete);
                cst3.setString(1, "CLMVCHR");
                cst3.setString(2, (String)this.session.getAttribute("TaskID"));
                cst3.setInt(3,
                            ((Integer)this.session.getAttribute("sysCode")).intValue());

                cst3.registerOutParameter(4, 12);
                cst3.execute();
                MyTask = cst3.getString(4);
                cst3.close();
                if (MyTask.equalsIgnoreCase("N")) {
                    String Message =
                        "the Task Selected Does not Correspond to the Activity being Performed. Cannot Complete please " +
                        this.session.getAttribute("TaskActivityName");


                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                  Message,
                                                                                  Message));


                    return null;
                }
            }
            cst = conn.prepareCall(Query);

            int i = 0;

            DCIteratorBinding dciter =
                ADFUtils.findIterator("findClaimBeneficaryPaymentsIterator");


            RowKeySet set = this.beneficaryPayments.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();
            Row r;
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                r = dciter.getCurrentRow();

                cst.setString(1, (String)this.session.getAttribute("ClaimNo"));
                cst.setBigDecimal(2, (BigDecimal)r.getAttribute("BPY_CODE"));
                cst.setBigDecimal(3,
                                  (BigDecimal)this.session.getAttribute("policyCode"));


                cst.setBigDecimal(4,
                                  (BigDecimal)this.session.getAttribute("ClaimTransNo"));


                cst.setBigDecimal(5, null);
                cst.setBigDecimal(6, null);
                cst.execute();
                i++;
            }
            cst.close();
            conn.close();
            this.session.setAttribute("ProcessAreaShtDesc", "VCHR");
            this.session.setAttribute("ProcessSubAShtDesc", "CLMR");
            Rights = wf.CheckUserRights();
            String str5;
            if (Rights.equalsIgnoreCase("N")) {
                this.session.setAttribute("TaskAssignee", null);
                ADFUtils.findIterator("findTicketAssigneeIterator").executeQuery();
                TaskAss = (String)this.session.getAttribute("TaskAssignee");
                if (TaskAss == null) {
                    GetAssignee();
                    return null;
                }
                this.session.setAttribute("TicketRemarks", null);
                wf.CompleteTask();
                String Message =
                    "Current Task Complete. The Next Task " + (String)this.session.getAttribute("TaskActivityName") +
                    " has been Successfully assigned to " +
                    (String)this.session.getAttribute("TaskAssignee");


                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));


                this.session.setAttribute("TaskID", null);
                return null;
            }
            wf.CompleteTask();
            if (i > 0) {
                GlobalCC.RedirectPage("/g_clmpym.jspx");
            }
            String Message = "Voucher Processing Completed";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));


            return null;
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
        return null;
    }

    public String ProcessPensionAnnuities() {
        Connection conn = null;
        CallableStatement cst = null;
        try {
            boolean MakeCall = false;
            DBConnector db = new DBConnector();
            conn = db.getDatabaseConn();

            List ReinstInfo = new LinkedList();
            ARRAY array = null;

            ArrayDescriptor descriptor =
                ArrayDescriptor.createDescriptor("LMS_PENSION_MATURITY_PYMT_TAB",
                                                 conn);


            cst =
conn.prepareCall("BEGIN LMS_WEB_CLAIMS_PKG.PROCESS_ANN_PAY_INSTLMNT(?);end;");


            int rowCount = 0;
            boolean Value = false;
            rowCount = this.pensMaturities.getRowCount();
            if (rowCount == 0) {
                return null;
            }
            for (int i = 0; i < rowCount; i++) {
                this.pensMaturities.setRowIndex(i);
                JUCtrlValueBinding nodeBinding =
                    (JUCtrlValueBinding)this.pensMaturities.getRowData();
                if (nodeBinding != null) {
                    Value =
                            ((Boolean)nodeBinding.getAttribute("selected")).booleanValue();
                    if (Value == true) {
                        MakeCall = true;

                        AnnuityPayments pn = new AnnuityPayments();

                        pn.setCLAIM_NO((String)nodeBinding.getAttribute("PCY_CLM_NO"));
                        pn.setPCY_CODE((BigDecimal)nodeBinding.getAttribute("PCY_CODE"));
                        pn.setPOL_CODE((BigDecimal)nodeBinding.getAttribute("PCY_POL_CODE"));
                        pn.setTRANS_NO((BigDecimal)this.session.getAttribute("ClaimTransNo"));
                        pn.setPMPNS_CODE(null);
                        pn.setPMPNS_TAX_PAYABLE(null);

                        ReinstInfo.add(pn);
                    }
                }
            }
            if (MakeCall == true) {
                array = new ARRAY(descriptor, conn, ReinstInfo.toArray());

                cst.setArray(1, array);
                cst.execute();
                cst.close();
                conn.close();
                ADFUtils.findIterator("findClaimVouchersIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.vouchersTable);

                ADFUtils.findIterator("FindPensionMaturitiesIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.pensMaturities);

                GlobalCC.INFORMATIONREPORTING("Maturities Successfully Processed.");
            }
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
        return null;
    }

    public String findTicket2Selected() {
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findTicketDetailsByUserIterator");


            RowKeySet set = this.resultsLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));

                Row r = dciter.getCurrentRow();

                this.session.setAttribute("TaskID",
                                          r.getAttribute("TCKT_CDE"));


                this.session.setAttribute("taskselName",
                                          r.getAttribute("TCKT_NAME"));


                this.session.setAttribute("TaskActivityName",
                                          r.getAttribute("TCKT_NAME"));


                this.session.setAttribute("taskselAssignee",
                                          r.getAttribute("TCKT_TO"));


                this.session.setAttribute("taskselDueDate",
                                          r.getAttribute("TCKT_DUE_DATE"));


                this.session.setAttribute("taskselID",
                                          r.getAttribute("TCKT_CDE"));


                this.session.setAttribute("taskselCreateDate",
                                          r.getAttribute("TCKT_DATE"));


                GlobalCC.RedirectPage("/wfProcessing.jspx");
            }
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String AddRow() {
        BigDecimal Code = null;
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("FindClaimCoverTypesIterator");


            RowKeySet set = this.coversLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));

                Row r = dciter.getCurrentRow();

                Code = (BigDecimal)r.getAttribute("CCVT_CODE");

                ClaimCoverTypeCode[t][0] = Code;
                System.out.println(ClaimCoverTypeCode[t][0]);

                ClaimCoverType[t] = "Y";

                t += 1;
                Integer localInteger1 = Num;
                Integer localInteger2 =
                    ClaimManipulation.Num = Integer.valueOf(Num.intValue() +
                                                            1);


                this.session.setAttribute("ClaimCoverTypeCount", Num);
            }
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String RemoveRow() {
        BigDecimal Code = null;
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("FindClaimCoverTypesIterator");


            RowKeySet set = this.coversLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));

                Row r = dciter.getCurrentRow();

                Code = (BigDecimal)r.getAttribute("CCVT_CODE");
                System.out.println(Code);

                int m = 0;
                while (m < t) {
                    System.out.println(ClaimCoverTypeCode[m][0]);
                    if (ClaimCoverTypeCode[m][0].equals(Code)) {
                        ClaimCoverType[m] = "N";
                    }
                    m++;
                }
                Num = Integer.valueOf(Num.intValue() - 1);
                this.session.setAttribute("ClaimCoverTypeCount", Num);
            }
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String PopulateDocuments() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        try {
            String AddClaim =
                "begin LMS_WEB_CLAIMS_PKG.pop_claim_rqrd_docs(?,?);end;";


            cst = conn.prepareCall(AddClaim);
            cst.setString(1, (String)this.session.getAttribute("ClaimNo"));
            cst.setString(2,
                          (String)this.session.getAttribute("CausationType"));


            cst.execute();
            cst.close();

            GlobalCC.INFORMATIONREPORTING("Documents Populated");

            ADFUtils.findIterator("FindClaimDocumentsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.docsLOV);

            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
        return null;
    }

    public String SaveReopenClaim() {
        String Claim = (String)this.session.getAttribute("ClaimNo");
        if (Claim == null) {
            String Message = "Select a Claim No.";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));


            return null;
        }
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        try {
            String AddClaim =
                "begin LMS_WEB_CLAIMS_PKG.reopen_claim(?,?,?,?,?,?,?);end;";


            cst = conn.prepareCall(AddClaim);
            cst.setBigDecimal(1,
                              (BigDecimal)this.session.getAttribute("PolicyMemCode"));


            cst.setBigDecimal(2,
                              (BigDecimal)this.session.getAttribute("MemberNumber"));


            cst.setBigDecimal(3,
                              (BigDecimal)this.session.getAttribute("policyCode"));


            cst.setString(4,
                          (String)this.session.getAttribute("ClaimTransactionType"));


            cst.setString(5, (String)this.session.getAttribute("ClaimNo"));
            cst.setString(6, null);
            cst.registerOutParameter(7, 3);

            cst.execute();
            this.session.setAttribute("ClaimTransNo", cst.getBigDecimal(7));
            cst.close();
            conn.close();
            GlobalCC.RedirectPage("/g_claims.jspx");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
        return null;
    }

    public String SaveContraClaim() {
        String Claim = (String)this.session.getAttribute("ClaimNo");
        if (Claim == null) {
            String Message = "Select a Claim No.";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));


            return null;
        }
        BigDecimal CPVouc = (BigDecimal)this.session.getAttribute("CPVoucher");
        if (CPVouc == null) {
            String Message = "Select a Transaction";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));


            return null;
        }
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        try {
            ADFUtils.findIterator("findPendingClaimTransactionsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.pendingTransactions);

            String pendingTrans =
                (String)this.session.getAttribute("pendingClaim");
            if (pendingTrans.equalsIgnoreCase("Y")) {
                GlobalCC.sysInformation("The Member Selected has another unfinished Claim Transaction");
                this.myPendingTrans.setRendered(true);
                this.nextButton.setDisabled(true);
                return null;
            }
            this.session.setAttribute("ClaimProcessTrans", "CO");

            String Rights = null;
            this.session.setAttribute("ProcessShtDesc", "CLMS");
            this.session.setAttribute("ProcessAreaShtDesc", "ACCS");
            this.session.setAttribute("ProcessSubAShtDesc", "ACCS");
            workflowProcessing wf = new workflowProcessing();
            Rights = wf.CheckUserRights();
            if (Rights.equalsIgnoreCase("N")) {
                String Message =
                    "You do not have rights to Perform this Task.";


                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));


                return null;
            }
            String NextUser = null;
            this.session.setAttribute("ProcessShtDesc", "CLMS");
            this.session.setAttribute("ProcessAreaShtDesc", "ACCS");
            this.session.setAttribute("ProcessSubAShtDesc", "ACCS");
            this.session.setAttribute("TaskAssignee", null);
            this.session.setAttribute("NextTaskAssignee", "N");
            ADFUtils.findIterator("findTicketAssigneeIterator").executeQuery();
            NextUser = (String)this.session.getAttribute("NextTaskAssignee");
            String TaskAss = (String)this.session.getAttribute("TaskAssignee");
            if ((TaskAss == null) && (NextUser.equalsIgnoreCase("N"))) {
                String Message =
                    "There is no User to Assign the Next Task. Consult the Administrator.";


                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));


                return null;
            }
            String Taske = (String)this.session.getAttribute("TaskID");
            if (Taske == null) {
                String Message = "No Task Selected";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));


                return null;
            }
            Taske = (String)this.session.getAttribute("TaskID");
            String Complete;
            if (Taske != null) {
                String MyTask = null;
                CallableStatement cst3 = null;
                Complete =
                        "BEGIN TQC_WEB_PKG.check_task_completion(?,?,?,?);END;";


                cst3 = conn.prepareCall(Complete);
                cst3.setString(1, "CLMINPUT");
                cst3.setString(2, (String)this.session.getAttribute("TaskID"));
                cst3.setInt(3,
                            ((Integer)this.session.getAttribute("sysCode")).intValue());

                cst3.registerOutParameter(4, 12);
                cst3.execute();
                MyTask = cst3.getString(4);
                cst3.close();
                if (MyTask.equalsIgnoreCase("N")) {
                    String Message =
                        "the Task Selected Does not Correspond to the Activity being Performed. Cannot Complete please " +
                        this.session.getAttribute("TaskActivityName");


                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                  Message,
                                                                                  Message));


                    return null;
                }
            }
            String AddClaim =
                "begin LMS_WEB_CLAIMS_PKG.CREATE_PAYMENT_CONTRA(?,?,?,?,?,?,?,?,?);end;";


            cst = conn.prepareCall(AddClaim);
            cst.setBigDecimal(1,
                              (BigDecimal)this.session.getAttribute("CPVoucher"));


            cst.setBigDecimal(2,
                              (BigDecimal)this.session.getAttribute("policyCode"));


            cst.setBigDecimal(3,
                              (BigDecimal)this.session.getAttribute("PolicyMemCode"));


            cst.setString(4, (String)this.session.getAttribute("ClaimNo"));
            cst.setString(5,
                          (String)this.session.getAttribute("ClaimTransactionType"));


            cst.setBigDecimal(6,
                              (BigDecimal)this.session.getAttribute("CPVoucher"));


            cst.setString(7, null);
            cst.registerOutParameter(8, 3);
            if (this.fmSCheck.isSelected()) {
                cst.setString(9, "Y");
            } else {
                cst.setString(9, "N");
            }
            cst.execute();
            this.session.setAttribute("ClaimTransNo", cst.getBigDecimal(8));
            cst.close();
            conn.close();

            this.session.setAttribute("ProcessShtDesc", "CLMS");
            this.session.setAttribute("ProcessAreaShtDesc", "ACCS");
            this.session.setAttribute("ProcessSubAShtDesc", "ACCS");
            Rights = wf.CheckUserRights();
            if (Rights.equalsIgnoreCase("N")) {
                this.session.setAttribute("TaskAssignee", null);
                ADFUtils.findIterator("findTicketAssigneeIterator").executeQuery();
                TaskAss = (String)this.session.getAttribute("TaskAssignee");
                if (TaskAss == null) {
                    GetAssignee();
                    return null;
                }
                this.session.setAttribute("TicketRemarks", null);
                wf.CompleteTask();
                GlobalCC.INFORMATIONREPORTING("Current Task Complete. The Next Task " +
                                              (String)this.session.getAttribute("TaskActivityName") +
                                              " has been Successfully assigned to " +
                                              (String)this.session.getAttribute("TaskAssignee"));


                this.session.setAttribute("TaskID", null);
                return null;
            }
            wf.CompleteTask();
            GlobalCC.RedirectPage("/g_claims.jspx");
            return null;
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
        return null;
    }

    public String authorizeVoucher() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        CallableStatement mySt = null;
        String TransCode = null;
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findClaimVouchersIterator");

            Object key2 = this.claimVouchers.getSelectedRowData();
            if (key2 == null) {
                GlobalCC.errorValueNotEntered("No Record Selected");
                return null;
            }
            JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
            if (r == null) {
                GlobalCC.errorValueNotEntered("No Record Selected");
                return null;
            }
            BigDecimal voucherAmt = (BigDecimal)r.getAttribute("cpvAmount");
            session.setAttribute("DebitCredit", "C");
            session.setAttribute("SumAssured", voucherAmt.toString());

            String authorizeVoucher =
                "begin LMS_WEB_PKG_CLM.Clmauthvchr(?,?); end;";

            String Rights = null;
            this.session.setAttribute("ProcessShtDesc", "CLMS");
            this.session.setAttribute("ProcessAreaShtDesc", "VCHR");
            this.session.setAttribute("ProcessSubAShtDesc", "CLMA");
            workflowProcessing wf = new workflowProcessing();
            Rights = wf.CheckUserRights();
            if (Rights.equalsIgnoreCase("N")) {
                String Message =
                    "You do not have rights to Perform this Task.";


                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));


                return null;
            }
            String NextUser = null;
            this.session.setAttribute("ProcessShtDesc", "CLMS");
            this.session.setAttribute("ProcessAreaShtDesc", "VCHR");
            this.session.setAttribute("ProcessSubAShtDesc", "CLMR");
            this.session.setAttribute("TaskAssignee", null);
            this.session.setAttribute("NextTaskAssignee", "N");
            ADFUtils.findIterator("findTicketAssigneeIterator").executeQuery();
            NextUser = (String)this.session.getAttribute("NextTaskAssignee");
            String TaskAss = (String)this.session.getAttribute("TaskAssignee");
            if (TaskAss == null) {
                TaskAss = (String)this.session.getAttribute("Username");
                this.session.setAttribute("TaskAssignee",
                                          this.session.getAttribute("Username"));
            }
            if ((TaskAss == null) && (NextUser.equalsIgnoreCase("N"))) {
                String Message =
                    "There is no User to Assign the Next Task. Consult the Administrator.";


                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));


                return null;
            }
            String Taske = (String)this.session.getAttribute("TaskID");
            if (Taske == null) {
                String Message = "No Task Selected";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));


                return null;
            }
            Taske = (String)this.session.getAttribute("TaskID");
            if (Taske != null) {
                String MyTask = null;
                CallableStatement cst3 = null;
                String Complete =
                    "BEGIN TQC_WEB_PKG.check_task_completion(?,?,?,?);END;";


                cst3 = conn.prepareCall(Complete);
                cst3.setString(1, "CLMAUTH");
                cst3.setString(2, (String)this.session.getAttribute("TaskID"));
                cst3.setInt(3,
                            ((Integer)this.session.getAttribute("sysCode")).intValue());

                cst3.registerOutParameter(4, 12);
                cst3.execute();
                MyTask = cst3.getString(4);
                cst3.close();
                if (MyTask.equalsIgnoreCase("N")) {
                    String Message =
                        "the Task Selected Does not Correspond to the Activity being Performed. Cannot Complete please " +
                        this.session.getAttribute("TaskActivityName");


                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                  Message,
                                                                                  Message));


                    return null;
                }
            }
            cst = conn.prepareCall(authorizeVoucher);
            this.session.setAttribute("voucherNumber", null);
            RowKeySet set = this.claimVouchers.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            conn.prepareCall(authorizeVoucher);
            Key key;
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));

                Row r1 = dciter.getCurrentRow();
                TransCode = (String)r.getAttribute("cpv_ltr_btr_trans_code");


                this.session.setAttribute("voucherNumber",
                                          r1.getAttribute("cpvVouvherNo"));


                cst.setBigDecimal(1,
                                  (BigDecimal)this.session.getAttribute("voucherNumber"));


                cst.setInt(2, 27);

                cst.execute();
            }
            if (this.session.getAttribute("voucherNumber") == null) {
                GlobalCC.INFORMATIONREPORTING("Select A Voucher");
                return null;
            }
            cst.close();
            conn.commit();

            String authorizeAnnuities =
                "begin LMS_WEB_CLAIMS_PKG.update_ann_voucher_status(?); end;";


            mySt = conn.prepareCall(authorizeAnnuities);
            mySt.setBigDecimal(1,
                               (BigDecimal)this.session.getAttribute("voucherNumber"));


            mySt.execute();
            mySt.close();

            conn.close();

            ADFUtils.findIterator("findClaimVouchersIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.voucherDetails);
            ADFUtils.findIterator("findClaimVouchDtlsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.claimVouchers);
            ADFUtils.findIterator("findClaimVchrpartRIIterator").executeQuery();
            ADFUtils.findIterator("findClaimVchrtrtRIIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.groupLifeRI);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.participantsRI);

            String prodTy = (String)this.session.getAttribute("productType");
            if (prodTy == null) {
                this.session.setAttribute("VoucherDecision", "No");
            } else if (prodTy.equalsIgnoreCase("EDUC")) {
                ADFUtils.findIterator("findClaimBeneficaryPaymentsIterator").executeQuery();
            } else if (prodTy.equalsIgnoreCase("ANN")) {
                ADFUtils.findIterator("findClaimAnnBeneficaryPaymentsIterator").executeQuery();
            } else if (prodTy.equalsIgnoreCase("EARN")) {
                ADFUtils.findIterator("FindClaimCoverTypesIterator").executeQuery();
                ADFUtils.findIterator("findClaimVouchersIterator").executeQuery();
                if ((TransCode != null) &&
                    (TransCode.equalsIgnoreCase("CO"))) {
                    this.session.setAttribute("VoucherDecision", "No");
                }
            } else {
                this.session.setAttribute("VoucherDecision", "No");
            }
            if ((this.session.getAttribute("payInstalment") != null) &&
                (this.session.getAttribute("payInstalment").equals("Y"))) {
                if (getUnpaidInstallment() != 0) {
                    this.session.setAttribute("VoucherDecision", "Yes");
                } else {
                    this.session.setAttribute("VoucherDecision", "No");
                }
            }
            System.out.println("Transition State is " + transitionState());
            this.session.setAttribute("VoucherDecision", transitionState());


            this.session.setAttribute("ProcessAreaShtDesc", "VCHR");
            this.session.setAttribute("ProcessSubAShtDesc", "CLMR");
            Rights = wf.CheckUserRights();
            String str6;
            if (Rights.equalsIgnoreCase("N")) {
                this.session.setAttribute("TaskAssignee", null);
                ADFUtils.findIterator("findTicketAssigneeIterator").executeQuery();
                TaskAss = (String)this.session.getAttribute("TaskAssignee");
                if (TaskAss == null) {
                    GetAssignee();
                    return null;
                }
                this.session.setAttribute("TicketRemarks", null);
                wf.CompleteTask();
                String Message =
                    "Current Task Complete. The Next Task " + (String)this.session.getAttribute("TaskActivityName") +
                    " has been Successfully assigned to " +
                    (String)this.session.getAttribute("TaskAssignee");


                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));


                this.session.setAttribute("TaskID", null);
                return null;
            }
            wf.CompleteTask();

            String Message = "Voucher Authorisation Completed";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));


            return null;
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
        return null;
    }

    public int unauthorisedVoucher() {
        int vchrCount = 0;
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        try {
            String sql =
                "begin ? := LMS_WEB_CLAIMS_PKG.getunauthorisedvouchers(?);end;";


            cst = conn.prepareCall(sql);
            cst.registerOutParameter(1, 4);
            cst.setString(2, (String)this.session.getAttribute("ClaimNo"));
            cst.execute();
            vchrCount = cst.getInt(1);
            cst.close();
            conn.close();
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
            ex.printStackTrace();
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
        return vchrCount;
    }

    public String transitionState() {
        String state = "No";
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        try {
            String sql =
                "begin ? := LMS_WEB_CLAIMS_PKG.getTransitionState(?);end;";


            cst = conn.prepareCall(sql);
            cst.registerOutParameter(1, 12);
            cst.setString(2, (String)this.session.getAttribute("ClaimNo"));
            cst.execute();
            state = cst.getString(1);
            cst.close();
            conn.close();
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
            ex.printStackTrace();
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
        return state;
    }

    public String EditVoucher() {
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findClaimVouchersIterator");


            RowKeySet set = this.claimVouchers.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();
            if (!rowKeySetIter.hasNext()) {
                GlobalCC.INFORMATIONREPORTING("Please select a voucher to proceed");
                return null;
            }
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));

                Row r = dciter.getCurrentRow();

                this.session.setAttribute("voucherNumber",
                                          r.getAttribute("cpvVouvherNo"));


                this.voucherLabel.setValue(r.getAttribute("cpvVouvherNo"));
                this.payeeTF.setValue(r.getAttribute("cpvPayee"));
                this.dispStatus.setValue(r.getAttribute("CPV_DISCHARGE_STATUS"));
                System.out.println("Dispatch Status is " +
                                   r.getAttribute("CPV_DISCHARGE_STATUS"));
                this.vchrAccNo.setValue(r.getAttribute("cpv_bbr_acc_no"));
                this.session.setAttribute("payMode",
                                          r.getAttribute("cpv_payment_mode"));
            }
            ExtendedRenderKitService erkService =
                (ExtendedRenderKitService)Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                                             ExtendedRenderKitService.class);


            erkService.addScript(FacesContext.getCurrentInstance(),
                                 "var hints = {autodismissNever:false}; AdfPage.PAGE.findComponent('lmsgroup:p1').show(hints);");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String MakeReady() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        try {
            String Rights = null;
            this.session.setAttribute("ProcessShtDesc", "CLMS");
            this.session.setAttribute("ProcessAreaShtDesc", "VCHR");
            this.session.setAttribute("ProcessSubAShtDesc", "CLMR");
            workflowProcessing wf = new workflowProcessing();
            Rights = wf.CheckUserRights();
            if (Rights.equalsIgnoreCase("N")) {
                String Message =
                    "You do not have rights to Perform this Task.";


                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));


                return null;
            }
            String NextUser = null;
            this.session.setAttribute("ProcessShtDesc", "CLMS");
            this.session.setAttribute("ProcessAreaShtDesc", "VCHR");
            this.session.setAttribute("ProcessSubAShtDesc", "CLMR");
            this.session.setAttribute("TaskAssignee", null);
            this.session.setAttribute("NextTaskAssignee", "N");
            ADFUtils.findIterator("findTicketAssigneeIterator").executeQuery();
            NextUser = (String)this.session.getAttribute("NextTaskAssignee");
            String TaskAss = (String)this.session.getAttribute("TaskAssignee");
            if (TaskAss == null) {
                TaskAss = (String)this.session.getAttribute("Username");
                this.session.setAttribute("TaskAssignee",
                                          this.session.getAttribute("Username"));
            }
            if ((TaskAss == null) && (NextUser.equalsIgnoreCase("N"))) {
                String Message =
                    "There is no User to Assign the Next Task. Consult the Administrator.";


                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));


                return null;
            }
            String Taske = (String)this.session.getAttribute("TaskID");
            if (Taske == null) {
                String Message = "No Task Selected";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));


                return null;
            }
            Taske = (String)this.session.getAttribute("TaskID");
            if (Taske != null) {
                String MyTask = null;
                CallableStatement cst3 = null;
                String Complete =
                    "BEGIN TQC_WEB_PKG.check_task_completion(?,?,?,?);END;";


                cst3 = conn.prepareCall(Complete);
                cst3.setString(1, "CLMMR");
                cst3.setString(2, (String)this.session.getAttribute("TaskID"));
                cst3.setInt(3,
                            ((Integer)this.session.getAttribute("sysCode")).intValue());

                cst3.registerOutParameter(4, 12);
                cst3.execute();
                MyTask = cst3.getString(4);
                cst3.close();
                if (MyTask.equalsIgnoreCase("N")) {
                    String Message =
                        "the Task Selected Does not Correspond to the Activity being Performed. Cannot Complete please " +
                        this.session.getAttribute("TaskActivityName");


                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                  Message,
                                                                                  Message));


                    return null;
                }
            }
            this.session.setAttribute("voucherNumber", null);
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findClaimVouchersIterator");


            RowKeySet set = this.claimVouchers.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();
            Row r;
            String Status;
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));

                r = dciter.getCurrentRow();

                this.session.setAttribute("voucherNumber",
                                          r.getAttribute("cpvVouvherNo"));


                Status = (String)r.getAttribute("CPV_DISCHARGE_STATUS");
                if (Status == null) {
                    GlobalCC.sysInformation("Enter A Dispatch Status");
                    return null;
                }
                if (String.valueOf(r.getAttribute("cpv_payment_mode")).equalsIgnoreCase("MFT")) {
                    String clntStr = (String)r.getAttribute("cpv_bbr_acc_no");
                    if (clntStr == null) {
                        GlobalCC.sysInformation("Please enter client phone/acc number for MFT Payment mode");
                        return null;
                    }
                }
                if (Status.equalsIgnoreCase("REJ")) {
                    this.session.setAttribute("ClientAccept", "Reject");
                } else {
                    this.session.setAttribute("ClientAccept", "Accept");
                }
                String AddClaim =
                    "begin LMS_WEB_CLAIMS_PKG.make_voucher_ready(?);end;";


                cst = conn.prepareCall(AddClaim);
                cst.setBigDecimal(1,
                                  (BigDecimal)this.session.getAttribute("voucherNumber"));


                cst.execute();
                cst.close();
            }
            if (this.session.getAttribute("voucherNumber") == null) {
                GlobalCC.INFORMATIONREPORTING("Select A Voucher.");
                return null;
            }
            ADFUtils.findIterator("findClaimVouchersIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.claimVouchers);

            conn.close();
            this.session.setAttribute("ProcessAreaShtDesc", "VCHR");
            this.session.setAttribute("ProcessSubAShtDesc", "CLMR");
            Rights = wf.CheckUserRights();
            if (Rights.equalsIgnoreCase("N")) {
                this.session.setAttribute("TaskAssignee", null);
                ADFUtils.findIterator("findTicketAssigneeIterator").executeQuery();
                TaskAss = (String)this.session.getAttribute("TaskAssignee");
                if (TaskAss == null) {
                    GetAssignee();
                    return null;
                }
                this.session.setAttribute("TicketRemarks", null);
                wf.CompleteTask();
                String Message =
                    "Current Task Complete. The Next Task " + (String)this.session.getAttribute("TaskActivityName") +
                    " has been Successfully assigned to " +
                    (String)this.session.getAttribute("TaskAssignee");


                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));


                this.session.setAttribute("TaskID", null);
                return null;
            }
            wf.CompleteTask();

            String Message = "Voucher Made Ready";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));


            return null;
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
        return null;
    }

    public String UpdateVoucherStatus() {
        CallableStatement cst = null;
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        try {
            if (this.dispStatus.getValue() == null) {
                String Message = "Select a Dispatch Status";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));
            }
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findClaimVouchersIterator");


            RowKeySet set = this.claimVouchers.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));

                Row r = dciter.getCurrentRow();

                this.session.setAttribute("voucherNumber",
                                          r.getAttribute("cpvVouvherNo"));


                String AddClaim =
                    "begin LMS_WEB_CLAIMS_PKG.update_voucher_status(?,?,?);end;";


                cst = conn.prepareCall(AddClaim);
                cst.setBigDecimal(1,
                                  (BigDecimal)this.session.getAttribute("voucherNumber"));


                cst.setString(2, this.dispStatus.getValue().toString());
                cst.setString(3, (String)payeeTF.getValue());

                if (this.vchrAccNo.getValue() != null) {
                    this.session.setAttribute("clientAccNo",
                                              this.vchrAccNo.getValue().toString());
                }
                if (String.valueOf(this.session.getAttribute("payMode")).equalsIgnoreCase("MFT")) {
                    updatePayMethodMFT();
                }
                cst.execute();
                cst.close();
            }
            ADFUtils.findIterator("findClaimVouchersIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.claimVouchers);

            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
            e.printStackTrace();
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
        return null;
    }

    public String UpdateClientFeedBack() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        try {
            String Rights = null;
            this.session.setAttribute("ProcessShtDesc", "CLMS");
            this.session.setAttribute("ProcessAreaShtDesc", "VCHR");
            this.session.setAttribute("ProcessSubAShtDesc", "CLMR");
            workflowProcessing wf = new workflowProcessing();
            Rights = wf.CheckUserRights();
            if (Rights.equalsIgnoreCase("N")) {
                String Message =
                    "You do not have rights to Perform this Task.";


                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));


                return null;
            }
            String NextUser = null;
            this.session.setAttribute("ProcessShtDesc", "CLMS");
            this.session.setAttribute("ProcessAreaShtDesc", "VCHR");
            this.session.setAttribute("ProcessSubAShtDesc", "CLMR");
            this.session.setAttribute("TaskAssignee", null);
            this.session.setAttribute("NextTaskAssignee", "N");
            ADFUtils.findIterator("findTicketAssigneeIterator").executeQuery();
            NextUser = (String)this.session.getAttribute("NextTaskAssignee");
            String TaskAss = (String)this.session.getAttribute("TaskAssignee");
            if (TaskAss == null) {
                TaskAss = (String)this.session.getAttribute("Username");
                this.session.setAttribute("TaskAssignee",
                                          this.session.getAttribute("Username"));
            }
            if ((TaskAss == null) && (NextUser.equalsIgnoreCase("N"))) {
                String Message =
                    "There is no User to Assign the Next Task. Consult the Administrator.";


                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));


                return null;
            }
            String Taske = (String)this.session.getAttribute("TaskID");
            if (Taske == null) {
                String Message = "No Task Selected";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));


                return null;
            }
            Taske = (String)this.session.getAttribute("TaskID");
            if (Taske != null) {
                String MyTask = null;
                CallableStatement cst3 = null;
                String Complete =
                    "BEGIN TQC_WEB_PKG.check_task_completion(?,?,?,?);END;";


                cst3 = conn.prepareCall(Complete);
                cst3.setString(1, "CLMFDK");
                cst3.setString(2, (String)this.session.getAttribute("TaskID"));
                cst3.setInt(3,
                            ((Integer)this.session.getAttribute("sysCode")).intValue());

                cst3.registerOutParameter(4, 12);
                cst3.execute();
                MyTask = cst3.getString(4);
                cst3.close();
                if (MyTask.equalsIgnoreCase("N")) {
                    String Message =
                        "the Task Selected Does not Correspond to the Activity being Performed. Cannot Complete please " +
                        this.session.getAttribute("TaskActivityName");


                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                  Message,
                                                                                  Message));


                    return null;
                }
            }
            String Status = null;

            DCIteratorBinding dciter =
                ADFUtils.findIterator("findClaimVouchersIterator");


            RowKeySet set = this.claimVouchers.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();
            Row r;
            String AddClaim;
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));

                r = dciter.getCurrentRow();

                this.session.setAttribute("voucherNumber",
                                          r.getAttribute("cpvVouvherNo"));


                Status = (String)r.getAttribute("CPV_DISCHARGE_STATUS");
                if (Status == null) {
                    this.session.setAttribute("ClientAccept", "Accept");
                } else if (Status.equalsIgnoreCase("REJ")) {
                    this.session.setAttribute("ClientAccept", "Reject");
                } else {
                    this.session.setAttribute("ClientAccept", "Accept");
                }
                AddClaim =
                        "begin LMS_WEB_CLAIMS_PKG.update_client_feedback(?);end;";


                cst = conn.prepareCall(AddClaim);
                cst.setBigDecimal(1,
                                  (BigDecimal)this.session.getAttribute("voucherNumber"));


                cst.execute();
                cst.close();
            }
            this.session.setAttribute("ProcessAreaShtDesc", "VCHR");
            this.session.setAttribute("ProcessSubAShtDesc", "CLMR");
            Rights = wf.CheckUserRights();
            if (Rights.equalsIgnoreCase("N")) {
                this.session.setAttribute("TaskAssignee", null);
                ADFUtils.findIterator("findTicketAssigneeIterator").executeQuery();
                TaskAss = (String)this.session.getAttribute("TaskAssignee");
                if (TaskAss == null) {
                    GetAssignee();
                    return null;
                }
                this.session.setAttribute("TicketRemarks", null);
                wf.CompleteTask();
                String Message =
                    "Current Task Complete. The Next Task " + (String)this.session.getAttribute("TaskActivityName") +
                    " has been Successfully assigned to " +
                    (String)this.session.getAttribute("TaskAssignee");


                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));


                this.session.setAttribute("TaskID", null);
                return null;
            }
            wf.CompleteTask();

            String Message = "Client FeedBack Captured.";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));


            return null;
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
        return null;
    }

    public String ReturnToLandingScreen() {
        try {
            GlobalCC.RedirectPage("/g_claims.jspx");
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                          e.getMessage(),
                                                                          e.getMessage()));
        }
        return null;
    }

    public String ViewPaymentVouchers() {
        try {
            GlobalCC.RedirectPage("/g_clmpym.jspx");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String AuthoriseClaim() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        CorrespondenceManipulation mail = new CorrespondenceManipulation();
        try {
            String AddClaim =
                "begin LMS_WEB_CLAIMS_PKG.CLOSE_AUTH_CLAIM(?,?);end;";


            cst = conn.prepareCall(AddClaim);
            cst.setString(1, (String)this.session.getAttribute("ClaimNo"));
            cst.setBigDecimal(2,
                              (BigDecimal)this.session.getAttribute("ClaimTransNo"));


            cst.execute();
            cst.close();
            conn.close();

            ADFUtils.findIterator("FindClaimsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.claimStatus);

            GlobalCC.INFORMATIONREPORTING("Claim Authorised");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
        mail.emailReport("CLMAUTH");
        return null;
    }

    public String PopulateRIParticipants() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        try {
            String AddClaim =
                "begin LMS_WEB_CLAIMS_PKG.POP_RI_PARTICIPANTS(?);end;";


            cst = conn.prepareCall(AddClaim);
            cst.setString(1, (String)this.session.getAttribute("ClaimNo"));

            cst.execute();
            cst.close();
            conn.close();

            String Message = "Reinsurance Participants Populated";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
        return null;
    }

    public String ProcessClaimVoucher() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        boolean MakeCall = false;
        CallableStatement cst = null;
        try {
            String Rights = null;
            this.session.setAttribute("ProcessShtDesc", "CLMS");
            this.session.setAttribute("ProcessAreaShtDesc", "VCHR");
            this.session.setAttribute("ProcessSubAShtDesc", "CLMR");
            workflowProcessing wf = new workflowProcessing();
            Rights = wf.CheckUserRights();
            if (Rights.equalsIgnoreCase("N")) {
                String Message =
                    "You do not have rights to Perform this Task.";


                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));


                return null;
            }
            String NextUser = null;
            this.session.setAttribute("ProcessShtDesc", "CLMS");
            this.session.setAttribute("ProcessAreaShtDesc", "VCHR");
            this.session.setAttribute("ProcessSubAShtDesc", "CLMR");
            this.session.setAttribute("TaskAssignee", null);
            this.session.setAttribute("NextTaskAssignee", "N");
            ADFUtils.findIterator("findTicketAssigneeIterator").executeQuery();
            NextUser = (String)this.session.getAttribute("NextTaskAssignee");
            String TaskAss = (String)this.session.getAttribute("TaskAssignee");
            if (TaskAss == null) {
                TaskAss = (String)this.session.getAttribute("Username");
                this.session.setAttribute("TaskAssignee",
                                          this.session.getAttribute("Username"));
            }
            if ((TaskAss == null) && (NextUser.equalsIgnoreCase("N"))) {
                String Message =
                    "There is no User to Assign the Next Task. Consult the Administrator.";


                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));


                return null;
            }
            String Taske = (String)this.session.getAttribute("TaskID");
            if (Taske == null) {
                String Message = "No Task Selected";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));


                return null;
            }
            Taske = (String)this.session.getAttribute("TaskID");
            if (Taske != null) {
                String MyTask = null;
                CallableStatement cst3 = null;
                String Complete =
                    "BEGIN TQC_WEB_PKG.check_task_completion(?,?,?,?);END;";


                cst3 = conn.prepareCall(Complete);
                cst3.setString(1, "CLMVCHR");
                cst3.setString(2, (String)this.session.getAttribute("TaskID"));
                cst3.setInt(3,
                            ((Integer)this.session.getAttribute("sysCode")).intValue());

                cst3.registerOutParameter(4, 12);
                cst3.execute();
                MyTask = cst3.getString(4);
                cst3.close();
                if (MyTask.equalsIgnoreCase("N")) {
                    String Message =
                        "the Task Selected Does not Correspond to the Activity being Performed. Cannot Complete please " +
                        this.session.getAttribute("TaskActivityName");


                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                  Message,
                                                                                  Message));


                    return null;
                }
            }
            Object ReinstInfo = new LinkedList();
            ARRAY array = null;

            ArrayDescriptor descriptor =
                ArrayDescriptor.createDescriptor("LMS_CLAIM_COVERTYPES_TAB",
                                                 conn);


            int rowCount = 0;
            boolean Value = false;
            rowCount = this.coversLOV.getRowCount();
            if (rowCount == 0) {
                return null;
            }
            ClaimCovers pn;
            for (int i = 0; i < rowCount; i++) {
                this.coversLOV.setRowIndex(i);
                JUCtrlValueBinding nodeBinding =
                    (JUCtrlValueBinding)this.coversLOV.getRowData();
                if (nodeBinding != null) {
                    Value =
                            ((Boolean)nodeBinding.getAttribute("selected")).booleanValue();
                    if (Value == true) {
                        MakeCall = true;

                        pn = new ClaimCovers();
                        pn.setCCVT_CODE((BigDecimal)nodeBinding.getAttribute("CCVT_CODE"));

                        ((List)ReinstInfo).add(pn);
                    }
                }
            }
            if (MakeCall == true) {
                array =
                        new ARRAY(descriptor, conn, ((List)ReinstInfo).toArray());


                String AddClaim =
                    "begin LMS_WEB_CLAIMS_PKG.PROCESS_VOUCHERS(?,?,?,?,?,?);end;";


                cst = conn.prepareCall(AddClaim);

                cst.setString(1, (String)this.session.getAttribute("ClaimNo"));
                if (this.memNo.getValue() == null) {
                    cst.setString(2, null);
                } else {
                    cst.setString(2, this.memNo.getValue().toString());
                }
                cst.setBigDecimal(3,
                                  (BigDecimal)this.session.getAttribute("ClaimTransNo"));


                cst.setString(4,
                              (String)this.session.getAttribute("Username"));


                cst.setArray(5, array);

                cst.setBigDecimal(6,
                                  (BigDecimal)this.session.getAttribute("MemberNumber"));


                cst.execute();
                cst.close();
                conn.close();
            } else {
                GlobalCC.sysInformation("Select A Cover Type");
                return null;
            }
            String AddClaim;
            ADFUtils.findIterator("FindClaimCoverTypesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.coversLOV);

            ADFUtils.findIterator("FindClaimsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.reserveAmt);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.clmAmountClaimed);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.amtToPay);
            ADFUtils.findIterator("FindClaimCoinsuranceRecoveriesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.claimRecoveries);

            this.session.setAttribute("ProcessAreaShtDesc", "VCHR");
            this.session.setAttribute("ProcessSubAShtDesc", "CLMR");
            Rights = wf.CheckUserRights();
            String str6;
            if (Rights.equalsIgnoreCase("N")) {
                this.session.setAttribute("TaskAssignee", null);
                ADFUtils.findIterator("findTicketAssigneeIterator").executeQuery();
                TaskAss = (String)this.session.getAttribute("TaskAssignee");
                if (TaskAss == null) {
                    GetAssignee();
                    return null;
                }
                this.session.setAttribute("TicketRemarks", null);
                wf.CompleteTask();
                String Message =
                    "Current Task Complete. The Next Task " + (String)this.session.getAttribute("TaskActivityName") +
                    " has been Successfully assigned to " +
                    (String)this.session.getAttribute("TaskAssignee");


                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));


                this.session.setAttribute("TaskID", null);
                return null;
            }
            wf.CompleteTask();

            String Message = "Voucher Processing Completed";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));


            return null;
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
        return null;
    }

    public String ProcessClaimException() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        BigDecimal Code = null;
        CallableStatement cst = null;
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findClaimExceptionsIterator");


            RowKeySet set = this.exceptionLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));

                Row r = dciter.getCurrentRow();

                Code = (BigDecimal)r.getAttribute("QEXC_CODE");

                String AddClaim =
                    "begin LMS_GRP_WEB_EXCEPTIONS.authorize_exception(?,?,?,?);end;";


                cst = conn.prepareCall(AddClaim);

                cst.setString(1,
                              (String)this.session.getAttribute("Username"));

                cst.setBigDecimal(2, Code);
                cst.setInt(3, 27);
                cst.setString(4, null);

                cst.execute();
                cst.close();
            }
            ADFUtils.findIterator("findClaimExceptionsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.exceptionLOV);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
        return null;
    }

    public void setProductsLOV(RichTable productsLOV) {
        this.productsLOV = productsLOV;
    }

    public RichTable getProductsLOV() {
        return this.productsLOV;
    }

    public void setProductDesc(RichInputText productDesc) {
        this.productDesc = productDesc;
    }

    public RichInputText getProductDesc() {
        return this.productDesc;
    }

    public void setPoliciesLOV(RichTable policiesLOV) {
        this.policiesLOV = policiesLOV;
    }

    public RichTable getPoliciesLOV() {
        return this.policiesLOV;
    }

    public void setPoliciesDesc(RichInputText policiesDesc) {
        this.policiesDesc = policiesDesc;
    }

    public RichInputText getPoliciesDesc() {
        return this.policiesDesc;
    }

    public void transactionListener(ValueChangeEvent valueChangeEvent) {
        if (valueChangeEvent.getOldValue() != valueChangeEvent.getNewValue()) {
            if (this.transType.getValue() == null) {
                this.session.setAttribute("ClaimTransactionType", null);
            } else {
                this.session.setAttribute("ClaimTransactionType",
                                          this.transType.getValue().toString());


                this.session.setAttribute("ClaimNo", null);
                this.session.setAttribute("PolicyMemCode", null);

                this.session.setAttribute("MemberNumber", null);

                this.session.setAttribute("policyCode", null);

                this.enClaimDesc.setValue(null);
                this.enTransDesc.setValue(null);

                this.session.setAttribute("CPVoucher", null);
                String TransType =
                    (String)this.session.getAttribute("ClaimTransactionType");
                if (TransType.equalsIgnoreCase("RO")) {
                    this.enClaimDesc.setRendered(true);
                    this.enClaimButton.setRendered(true);
                    this.enClaimLabel.setRendered(true);

                    this.enTransDesc.setRendered(false);
                    this.enTransButton.setRendered(false);
                    this.enTransLabel.setRendered(false);
                    this.fmSLabel.setRendered(false);
                    this.fmSCheck.setRendered(false);
                    this.membersDesc.setRendered(false);
                    this.enMemberButton.setRendered(false);
                    this.enMemberNo.setRendered(false);

                    this.policiesDesc.setRendered(false);
                    this.enPolicyButton.setRendered(false);
                    this.enPolicyLabel.setRendered(false);

                    this.membersDesc.setRendered(false);
                    this.enMemberButton.setRendered(false);
                    this.enMemberNo.setRendered(false);

                    this.policyPanel.setRendered(false);
                    this.claimPanel.setRendered(true);
                    this.transPanel.setRendered(false);
                    this.memberPanel.setRendered(false);
                } else if (TransType.equalsIgnoreCase("CO")) {
                    this.enClaimDesc.setRendered(true);
                    this.enClaimButton.setRendered(true);
                    this.enClaimLabel.setRendered(true);

                    this.enTransDesc.setRendered(true);
                    this.enTransButton.setRendered(true);
                    this.enTransLabel.setRendered(true);
                    this.fmSLabel.setRendered(true);
                    this.fmSCheck.setRendered(true);
                    this.policiesDesc.setRendered(false);
                    this.enPolicyButton.setRendered(false);
                    this.enPolicyLabel.setRendered(false);

                    this.policyPanel.setRendered(false);
                    this.claimPanel.setRendered(true);
                    this.transPanel.setRendered(true);
                    this.memberPanel.setRendered(false);

                    this.membersDesc.setRendered(false);
                    this.enMemberButton.setRendered(false);
                    this.enMemberNo.setRendered(false);
                } else {
                    this.enClaimDesc.setRendered(false);
                    this.enClaimButton.setRendered(false);
                    this.enClaimLabel.setRendered(false);

                    this.enTransDesc.setRendered(false);
                    this.enTransButton.setRendered(false);
                    this.enTransLabel.setRendered(false);
                    this.fmSLabel.setRendered(false);
                    this.fmSCheck.setRendered(false);
                    this.policiesDesc.setRendered(true);
                    this.enPolicyButton.setRendered(true);
                    this.enPolicyLabel.setRendered(true);

                    this.policyPanel.setRendered(true);
                    this.claimPanel.setRendered(false);
                    this.transPanel.setRendered(false);
                    this.memberPanel.setRendered(true);

                    this.membersDesc.setRendered(true);
                    this.enMemberButton.setRendered(true);
                    this.enMemberNo.setRendered(true);
                }
            }
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.enClaimDesc);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.enClaimButton);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.enClaimLabel);

            AdfFacesContext.getCurrentInstance().addPartialTarget(this.enTransDesc);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.enTransButton);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.enTransLabel);

            AdfFacesContext.getCurrentInstance().addPartialTarget(this.policiesDesc);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.enPolicyButton);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.enPolicyLabel);

            AdfFacesContext.getCurrentInstance().addPartialTarget(this.membersDesc);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.enMemberButton);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.enMemberNo);

            AdfFacesContext.getCurrentInstance().addPartialTarget(this.policyPanel);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.claimPanel);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.transPanel);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.memberPanel);
        }
    }

    public String ComputePensionAmt() {
        Connection conn = null;
        CallableStatement cst = null;
        try {
            DBConnector myConn = new DBConnector();
            conn = myConn.getDatabaseConn();

            String AddClaim =
                "begin LMS_WEB_CLAIMS_PKG.compute_pens_amt(?,?,?,?,?,?,?,?,?,?);end;";


            cst = conn.prepareCall(AddClaim);
            cst.setString(1, (String)this.session.getAttribute("ClaimNo"));
            cst.setBigDecimal(2,
                              (BigDecimal)this.session.getAttribute("PolmCode"));

            cst.setBigDecimal(3,
                              (BigDecimal)this.session.getAttribute("PMPNS_CODE"));


            cst.setString(4,
                          (String)this.session.getAttribute("ClaimTransactionType"));


            cst.setBigDecimal(5,
                              (BigDecimal)this.session.getAttribute("policyCode"));
            if (this.effDate.getValue() == null) {
                cst.setString(6, null);
            } else if (this.effDate.getValue().toString().contains(":")) {
                cst.setString(6,
                              GlobalCC.parseDate(this.effDate.getValue().toString()));
            } else {
                cst.setString(6,
                              GlobalCC.upDateParseDate(this.effDate.getValue().toString()));
            }
            if (this.pensIntRate.getValue() == null) {
                cst.setString(7, null);
            } else {
                cst.setString(7, this.pensIntRate.getValue().toString());
            }
            if (this.paymentFreq.getValue() == null) {
                cst.setString(8, null);
            } else {
                cst.setString(8, this.paymentFreq.getValue().toString());
            }
            if (this.retireHeldPct.getValue() == null) {
                cst.setString(9, null);
            } else {
                cst.setString(9, this.retireHeldPct.getValue().toString());
            }
            if (this.overrideTax.getValue() == null) {
                cst.setString(10, null);
            } else {
                cst.setString(10, this.overrideTax.getValue().toString());
            }
            cst.execute();
            cst.close();
            conn.close();

            ADFUtils.findIterator("FindClaimsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.pensToPay);

            ADFUtils.findIterator("FindPensionMaturitiesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.pensMaturities);

            ADFUtils.findIterator("FindClaimPensionDetailsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.taxPayable);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.taxable);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.netPay);

            ADFUtils.findIterator("findPensionTaxesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.pensionTaxTable);

            String Message = "Computation Successfully Completed";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
            e.printStackTrace();
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
        return null;
    }

    public String CreatePensionVoucher() {
        Connection conn = null;
        CallableStatement cst = null;
        try {
            String str1;
            String alert = "";
            if (this.pensionPayee.getValue() == null) {
                alert = "Select a Payee";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              alert,
                                                                              alert));


                return null;
            }
            if ((this.pensionPayee.getValue().toString().equalsIgnoreCase("PFA")) &&
                (this.pensPayeeName.getValue() == null)) {
                GlobalCC.sysInformation("Enter A Payee Name");
                return null;
            }
            if (this.pensionPayee.getValue().toString().equalsIgnoreCase("RSA")) {
                if (this.pensPayeeName.getValue() == null) {
                    GlobalCC.sysInformation("Enter A Payee Name");
                    return null;
                }
                if (this.pensPayeePIN.getValue() == null) {
                    GlobalCC.sysInformation("Enter A Payee PIN");
                    return null;
                }
            }
            if (this.pensionPayee.getValue().toString().equalsIgnoreCase("O")) {
                editOtherPayee();
                return null;
            }
            if (transferLockedBen.getValue().equals("Y")) {
                if (transferToTF.getValue() == null) {
                    GlobalCC.INFORMATIONREPORTING("Please enter the company you are transfering to");
                }
            }
            DBConnector myConn = new DBConnector();
            conn = myConn.getDatabaseConn();

            String Rights = null;
            this.session.setAttribute("ProcessShtDesc", "CLMS");
            this.session.setAttribute("ProcessAreaShtDesc", "ACCS");
            this.session.setAttribute("ProcessSubAShtDesc", "ACCS");
            workflowProcessing wf = new workflowProcessing();
            Rights = wf.CheckUserRights();
            if (Rights.equalsIgnoreCase("N")) {
                alert = "You do not have rights to Perform this Task.";


                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              alert,
                                                                              alert));


                return null;
            }
            String NextUser = null;
            this.session.setAttribute("ProcessShtDesc", "CLMS");
            this.session.setAttribute("ProcessAreaShtDesc", "ACCS");
            this.session.setAttribute("ProcessSubAShtDesc", "ACCS");
            this.session.setAttribute("TaskAssignee", null);
            this.session.setAttribute("NextTaskAssignee", "N");
            ADFUtils.findIterator("findTicketAssigneeIterator").executeQuery();
            NextUser = (String)this.session.getAttribute("NextTaskAssignee");
            String TaskAss = (String)this.session.getAttribute("TaskAssignee");
            if ((TaskAss == null) && (NextUser.equalsIgnoreCase("N"))) {
                alert =
                        "There is no User to Assign the Next Task. Consult the Administrator.";


                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              alert,
                                                                              alert));


                return null;
            }
            String Taske = (String)this.session.getAttribute("TaskID");
            if (Taske == null) {
                String Message = "No Task Selected";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));


                return null;
            }
            Taske = (String)this.session.getAttribute("TaskID");
            String str5;
            if (Taske != null) {
                String MyTask = null;
                CallableStatement cst3 = null;
                String Complete =
                    "BEGIN TQC_WEB_PKG.check_task_completion(?,?,?,?);END;";


                cst3 = conn.prepareCall(Complete);
                cst3.setString(1, "CLMVCHR");
                cst3.setString(2, (String)this.session.getAttribute("TaskID"));
                cst3.setInt(3,
                            ((Integer)this.session.getAttribute("sysCode")).intValue());

                cst3.registerOutParameter(4, 12);
                cst3.execute();
                MyTask = cst3.getString(4);
                cst3.close();
                if (MyTask.equalsIgnoreCase("N")) {
                    alert =
                            "the Task Selected Does not Correspond to the Activity being Performed. Cannot Complete please " +
                            this.session.getAttribute("TaskActivityName");


                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                  alert,
                                                                                  alert));

                    return null;
                }
            }
            String AddClaim =
                "begin LMS_WEB_CLAIMS_PKG.create_voucher(?,?,?,?,?,?,?,?,?,?,?,?,?);end;";


            cst = conn.prepareCall(AddClaim);
            cst.setBigDecimal(1,
                              (BigDecimal)this.session.getAttribute("policyCode"));


            cst.setString(2, (String)this.session.getAttribute("ClaimNo"));
            cst.setString(3, this.pensionPayee.getValue().toString());
            if (this.pensToPay.getValue() == null) {
                cst.setString(4, null);
                if (this.pensButPayAmt.getValue() != null) {
                    cst.setString(4, this.pensButPayAmt.getValue().toString());
                } else {
                    cst.setString(4, null);
                }
            } else if (this.pensButPayAmt.getValue() != null) {
                cst.setString(4, this.pensButPayAmt.getValue().toString());
            } else {
                cst.setString(4, this.pensToPay.getValue().toString());
            }
            cst.setBigDecimal(5,
                              (BigDecimal)this.session.getAttribute("MemberNumber"));


            cst.setBigDecimal(6,
                              (BigDecimal)this.session.getAttribute("PolmCode"));

            cst.setBigDecimal(7,
                              (BigDecimal)this.session.getAttribute("PMPNS_CODE"));
            if (this.taxPayable.getValue() == null) {
                cst.setString(8, null);
            } else {
                cst.setString(8, this.taxPayable.getValue().toString());
            }
            cst.setBigDecimal(9,
                              (BigDecimal)this.session.getAttribute("ClaimTransNo"));
            if (this.pensPayeeName.getValue() == null) {
                cst.setString(10, null);
            } else {
                cst.setString(10, this.pensPayeeName.getValue().toString());
            }
            if (this.pensPayeePIN.getValue() == null) {
                cst.setString(11, null);
            } else {
                cst.setString(11, this.pensPayeePIN.getValue().toString());
            }
            if (this.transferLockedBen.getValue() == null) {
                cst.setString(12, null);
            } else {
                cst.setString(12,
                              this.transferLockedBen.getValue().toString());
            }
            if (this.transferToTF.getValue() == null) {
                cst.setString(13, null);
            } else {
                cst.setString(13, this.transferToTF.getValue().toString());
            }
            cst.execute();
            cst.close();
            conn.close();

            this.session.setAttribute("ProcessAreaShtDesc", "ACCS");
            this.session.setAttribute("ProcessSubAShtDesc", "ACCS");
            Rights = wf.CheckUserRights();
            if (Rights.equalsIgnoreCase("N")) {
                this.session.setAttribute("TaskAssignee", null);
                ADFUtils.findIterator("findTicketAssigneeIterator").executeQuery();
                TaskAss = (String)this.session.getAttribute("TaskAssignee");
                if (TaskAss == null) {
                    GetAssignee();
                    return null;
                }
                this.session.setAttribute("TicketRemarks", null);
                wf.CompleteTask();
                String Message =
                    "Current Task Complete. The Next Task " + (String)this.session.getAttribute("TaskActivityName") +
                    " has been Successfully assigned to " +
                    (String)this.session.getAttribute("TaskAssignee");


                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));


                this.session.setAttribute("TaskID", null);
                return null;
            }
            wf.CompleteTask();

            String Message = "Voucher Successfully Created";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));


            return null;
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
        return null;
    }

    public String editOtherPayee() {
        ADFUtils.findIterator("FindPayeesIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.payeesLOV);

        ExtendedRenderKitService erkService =
            (ExtendedRenderKitService)Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                                         ExtendedRenderKitService.class);


        erkService.addScript(FacesContext.getCurrentInstance(),
                             "var hints = {autodismissNever:false}; AdfPage.PAGE.findComponent('lmsgroup:p2').show(hints);");


        return null;
    }

    public String editOtherPayee2() {
        ADFUtils.findIterator("FindPayeesIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.payees2LOV);

        ExtendedRenderKitService erkService =
            (ExtendedRenderKitService)Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                                         ExtendedRenderKitService.class);


        erkService.addScript(FacesContext.getCurrentInstance(),
                             "var hints = {autodismissNever:false}; AdfPage.PAGE.findComponent('lmsgroup:popup1').show(hints);");


        return null;
    }

    public String SaveOtherPayee() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        BigDecimal SPR_CODE = null;
        String SPR_NAME = null;
        String Message = "";
        CallableStatement cst = null;
        String authorizeVoucher =
            "begin LMS_WEB_CLAIMS_PKG.save_pens_clm_payee(?,?,?); end;";
        try {
            cst = conn.prepareCall(authorizeVoucher);
            DCIteratorBinding dciter =
                ADFUtils.findIterator("FindPayeesIterator");


            RowKeySet set = this.payeesLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            conn.prepareCall(authorizeVoucher);
            Row r;
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));

                r = dciter.getCurrentRow();
                SPR_CODE = (BigDecimal)r.getAttribute("PAYEE_SPT_CODE");
                SPR_NAME = (String)r.getAttribute("PAYEE_SPR_NAME");
            }
            cst.setString(1, (String)this.session.getAttribute("ClaimNo"));
            cst.setBigDecimal(2, SPR_CODE);
            cst.setString(3, SPR_NAME);

            cst.execute();
            cst.close();

            String Rights = null;
            this.session.setAttribute("ProcessShtDesc", "CLMS");
            this.session.setAttribute("ProcessAreaShtDesc", "ACCS");
            this.session.setAttribute("ProcessSubAShtDesc", "ACCS");
            workflowProcessing wf = new workflowProcessing();
            Rights = wf.CheckUserRights();
            if (Rights.equalsIgnoreCase("N")) {
                GlobalCC.INFORMATIONREPORTING("You do not have rights to Perform this Task.");

                return null;
            }
            String NextUser = null;
            this.session.setAttribute("ProcessShtDesc", "CLMS");
            this.session.setAttribute("ProcessAreaShtDesc", "ACCS");
            this.session.setAttribute("ProcessSubAShtDesc", "ACCS");
            this.session.setAttribute("TaskAssignee", null);
            this.session.setAttribute("NextTaskAssignee", "N");
            ADFUtils.findIterator("findTicketAssigneeIterator").executeQuery();
            NextUser = (String)this.session.getAttribute("NextTaskAssignee");
            String TaskAss = (String)this.session.getAttribute("TaskAssignee");
            if ((TaskAss == null) && (NextUser.equalsIgnoreCase("N"))) {
                GlobalCC.INFORMATIONREPORTING("There is no User to Assign the Next Task. Consult the Administrator.");

                return null;
            }
            String Taske = (String)this.session.getAttribute("TaskID");
            if (Taske == null) {
                GlobalCC.INFORMATIONREPORTING("No Task Selected");

                return null;
            }
            Taske = (String)this.session.getAttribute("TaskID");
            String str3;
            if (Taske != null) {
                String MyTask = null;
                CallableStatement cst3 = null;
                String Complete =
                    "BEGIN TQC_WEB_PKG.check_task_completion(?,?,?,?);END;";


                cst3 = conn.prepareCall(Complete);
                cst3.setString(1, "AQUOT");
                cst3.setString(2, (String)this.session.getAttribute("TaskID"));
                cst3.setInt(3,
                            ((Integer)this.session.getAttribute("sysCode")).intValue());

                cst3.registerOutParameter(4, 12);
                cst3.execute();
                MyTask = cst3.getString(4);
                cst3.close();
                if (MyTask.equalsIgnoreCase("N")) {
                    Message =
                            "the Task Selected Does not Correspond to the Activity being Performed. Cannot Complete please " +
                            this.session.getAttribute("TaskActivityName");


                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                  Message,
                                                                                  Message));


                    return null;
                }
            }
            String AddClaim =
                "begin LMS_WEB_CLAIMS_PKG.create_voucher(?,?,?,?,?,?,?,?,?);end;";


            CallableStatement cst1 = conn.prepareCall(AddClaim);
            cst1.setBigDecimal(1,
                               (BigDecimal)this.session.getAttribute("policyCode"));


            cst1.setString(2, (String)this.session.getAttribute("ClaimNo"));
            cst1.setString(3, this.pensionPayee.getValue().toString());
            if (this.pensToPay.getValue() == null) {
                cst1.setString(4, null);
            } else {
                cst1.setString(4, this.pensToPay.getValue().toString());
            }
            cst1.setBigDecimal(5,
                               (BigDecimal)this.session.getAttribute("MemberNumber"));


            cst1.setBigDecimal(6,
                               (BigDecimal)this.session.getAttribute("PolmCode"));


            cst1.setBigDecimal(7,
                               (BigDecimal)this.session.getAttribute("PMPNS_CODE"));
            if (this.taxPayable.getValue() == null) {
                cst1.setString(8, null);
            } else {
                cst1.setString(8, this.taxPayable.getValue().toString());
            }
            cst1.setBigDecimal(9,
                               (BigDecimal)this.session.getAttribute("ClaimTransNo"));


            cst1.execute();
            cst1.close();
            conn.close();

            this.session.setAttribute("ProcessAreaShtDesc", "ACCS");
            this.session.setAttribute("ProcessSubAShtDesc", "ACCS");
            Rights = wf.CheckUserRights();
            if (Rights.equalsIgnoreCase("N")) {
                this.session.setAttribute("TaskAssignee", null);
                ADFUtils.findIterator("findTicketAssigneeIterator").executeQuery();
                TaskAss = (String)this.session.getAttribute("TaskAssignee");
                if (TaskAss == null) {
                    GetAssignee();
                    return null;
                }
                this.session.setAttribute("TicketRemarks", null);
                wf.CompleteTask();
                Message =
                        "Current Task Complete. The Next Task " + (String)this.session.getAttribute("TaskActivityName") +
                        " has been Successfully assigned to " +
                        (String)this.session.getAttribute("TaskAssignee");


                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));


                this.session.setAttribute("TaskID", null);
                return null;
            }
            wf.CompleteTask();
            Message = "Voucher Successfully Created";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));


            return null;
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
        return null;
    }

    public String SaveOtherPayee2() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        String SPR_NAME = null;
        CallableStatement cst = null;
        try {
            String Value = this.payeeRadio.getValue().toString();
            if (Value.equalsIgnoreCase("E")) {
                if (this.payeeDesc.getValue() == null) {
                    GlobalCC.sysInformation("Enter A Payee Name");
                    return null;
                }
                SPR_NAME = this.payeeDesc.getValue().toString();
            } else {
                DCIteratorBinding dciter =
                    ADFUtils.findIterator("FindPayeesIterator");


                RowKeySet set = this.payees2LOV.getSelectedRowKeys();
                Iterator rowKeySetIter = set.iterator();
                while (rowKeySetIter.hasNext()) {
                    List l = (List)rowKeySetIter.next();
                    Key key = (Key)l.get(0);
                    dciter.setCurrentRowWithKey(key.toStringFormat(true));

                    Row r = dciter.getCurrentRow();
                    SPR_NAME = (String)r.getAttribute("PAYEE_SPR_NAME");
                }
            }
            String UpdateClaim =
                "begin LMS_WEB_PKG_GRP.update_claim_cvr_details(?,?,?,?,?,?,?,?);end;";


            cst = conn.prepareCall(UpdateClaim);

            cst.setBigDecimal(1,
                              (BigDecimal)this.session.getAttribute("CoverTypeCode"));
            if (this.amtClaimed.getValue() == null) {
                cst.setBigDecimal(2, null);
            } else {
                cst.setString(2, this.amtClaimed.getValue().toString());
            }
            if (this.butPay.getValue() == null) {
                cst.setBigDecimal(3, null);
            } else {
                cst.setString(3, this.butPay.getValue().toString());
            }
            if (this.remarks.getValue() == null) {
                cst.setString(4, null);
            } else {
                cst.setString(4, this.remarks.getValue().toString());
            }
            if (this.payee.getValue() == null) {
                cst.setString(5, null);
            } else {
                cst.setString(5, this.payee.getValue().toString());
            }
            cst.setString(6, SPR_NAME);
            if (this.totalCoinsAmt.isSelected()) {
                cst.setString(7, "Y");
            } else {
                cst.setString(7, "N");
            }
            cst.setString(8, (String)this.session.getAttribute("ClaimNo"));
            cst.execute();
            cst.close();

            this.session.setAttribute("CoverTypeCode", null);

            String Message = "Cover Updated";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));


            ADFUtils.findIterator("FindClaimCoverTypesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.coversLOV);

            ADFUtils.findIterator("FindClaimsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.reserveAmt);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.clmAmountClaimed);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.amtToPay);
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
        return null;
    }

    public String editMatDocuments() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindMaturityDocumentsIterator");


        RowKeySet set = this.matDocuments.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            this.session.setAttribute("MCD_CODE", r.getAttribute("MCD_CODE"));
            this.docDesc.setValue(r.getAttribute("RD_DESC"));
            this.submitted.setValue(r.getAttribute("MCD_IS_DOC_SUBMITTED"));
            this.dateSubmitted.setValue(r.getAttribute("MCD_DATE_GIVEN"));
            this.docNo.setValue(r.getAttribute("MCD_DOC_NO"));

            ExtendedRenderKitService erkService =
                (ExtendedRenderKitService)Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                                             ExtendedRenderKitService.class);


            erkService.addScript(FacesContext.getCurrentInstance(),
                                 "var hints = {autodismissNever:false}; AdfPage.PAGE.findComponent('lmsgroup:p3').show(hints);");
        }
        return null;
    }

    public String editRequiredDocuments() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindClaimDocumentsIterator");


        RowKeySet set = this.docsLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            this.session.setAttribute("MCD_CODE", r.getAttribute("MCD_CODE"));
            this.docDesc.setValue(r.getAttribute("RD_DESC"));
            this.submitted.setValue(r.getAttribute("MCD_IS_DOC_SUBMITTED"));
            this.dateSubmitted.setValue(r.getAttribute("MCD_DATE_GIVEN"));
            this.docNo.setValue(r.getAttribute("MCD_DOC_NO"));

            ExtendedRenderKitService erkService =
                (ExtendedRenderKitService)Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                                             ExtendedRenderKitService.class);


            erkService.addScript(FacesContext.getCurrentInstance(),
                                 "var hints = {autodismissNever:false}; AdfPage.PAGE.findComponent('lmsgroup:p3').show(hints);");
        }
        return null;
    }

    public String SaveDocumentDetails() {
        Connection conn = null;
        CallableStatement cst = null;
        try {
            DBConnector myConn = new DBConnector();
            conn = myConn.getDatabaseConn();

            String AddClaim =
                "begin LMS_WEB_CLAIMS_PKG.update_doc_dtls(?,?,?,?);end;";
            if ((this.submitted.getValue().equals("Y")) &&
                (this.docNo.getValue() == null)) {
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                              "Error saving Document",
                                                                              "Please provide the document number"));
            } else {
                cst = conn.prepareCall(AddClaim);
                cst.setBigDecimal(1,
                                  (BigDecimal)this.session.getAttribute("MCD_CODE"));
                if (this.submitted.getValue() == null) {
                    cst.setString(2, null);
                } else {
                    cst.setString(2, this.submitted.getValue().toString());
                }
                if (this.dateSubmitted.getValue() == null) {
                    cst.setString(3, null);
                } else {
                    cst.setString(3,
                                  GlobalCC.parseDate(this.dateSubmitted.getValue().toString()));
                }
                if (this.docNo.getValue() == null) {
                    cst.setString(4, null);
                } else {
                    cst.setString(4, this.docNo.getValue().toString());
                }
                cst.execute();
                cst.close();
                conn.close();

                ADFUtils.findIterator("FindClaimDocumentsIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.docsLOV);

                ADFUtils.findIterator("FindMaturityDocumentsIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.matDocuments);

                String Message = "Document Successfully Updated";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));
            }
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
        return null;
    }

    public void setTransType(RichSelectOneChoice transType) {
        this.transType = transType;
    }

    public RichSelectOneChoice getTransType() {
        return this.transType;
    }

    public void setClaimsLOV(RichTable claimsLOV) {
        this.claimsLOV = claimsLOV;
    }

    public RichTable getClaimsLOV() {
        return this.claimsLOV;
    }

    public void setClaimsDesc(RichInputText claimsDesc) {
        this.claimsDesc = claimsDesc;
    }

    public RichInputText getClaimsDesc() {
        return this.claimsDesc;
    }

    public void setMembersLOV(RichTable membersLOV) {
        this.membersLOV = membersLOV;
    }

    public RichTable getMembersLOV() {
        return this.membersLOV;
    }

    public void setMembersDesc(RichInputText membersDesc) {
        this.membersDesc = membersDesc;
    }

    public RichInputText getMembersDesc() {
        return this.membersDesc;
    }

    public void setCausationsLOV(RichTable causationsLOV) {
        this.causationsLOV = causationsLOV;
    }

    public RichTable getCausationsLOV() {
        return this.causationsLOV;
    }

    public void setCausationDesc(RichInputText causationDesc) {
        this.causationDesc = causationDesc;
    }

    public RichInputText getCausationDesc() {
        return this.causationDesc;
    }

    public void setLossDate(RichInputDate lossDate) {
        this.lossDate = lossDate;
    }

    public RichInputDate getLossDate() {
        return this.lossDate;
    }

    public void setReportDate(RichInputDate reportDate) {
        this.reportDate = reportDate;
    }

    public RichInputDate getReportDate() {
        return this.reportDate;
    }

    public void setCauseCodeDesc(RichInputText causeCodeDesc) {
        this.causeCodeDesc = causeCodeDesc;
    }

    public RichInputText getCauseCodeDesc() {
        return this.causeCodeDesc;
    }

    public void setCauseCodeLOV(RichTable causeCodeLOV) {
        this.causeCodeLOV = causeCodeLOV;
    }

    public RichTable getCauseCodeLOV() {
        return this.causeCodeLOV;
    }

    public void setCoversLOV(RichTable coversLOV) {
        this.coversLOV = coversLOV;
    }

    public RichTable getCoversLOV() {
        return this.coversLOV;
    }

    public void setAmtClaimed(RichInputText amtClaimed) {
        this.amtClaimed = amtClaimed;
    }

    public RichInputText getAmtClaimed() {
        return this.amtClaimed;
    }

    public void setButPay(RichInputText butPay) {
        this.butPay = butPay;
    }

    public RichInputText getButPay() {
        return this.butPay;
    }

    public void setRemarks(RichInputText remarks) {
        this.remarks = remarks;
    }

    public RichInputText getRemarks() {
        return this.remarks;
    }

    public void setPayee(RichSelectOneChoice payee) {
        this.payee = payee;
    }

    public RichSelectOneChoice getPayee() {
        return this.payee;
    }

    public void setReserveAmt(RichInputText reserveAmt) {
        this.reserveAmt = reserveAmt;
    }

    public RichInputText getReserveAmt() {
        return this.reserveAmt;
    }

    public void setClmAmountClaimed(RichInputText clmAmountClaimed) {
        this.clmAmountClaimed = clmAmountClaimed;
    }

    public RichInputText getClmAmountClaimed() {
        return this.clmAmountClaimed;
    }

    public void setAmtToPay(RichInputText amtToPay) {
        this.amtToPay = amtToPay;
    }

    public RichInputText getAmtToPay() {
        return this.amtToPay;
    }

    public void setMemNo(RichInputText memNo) {
        this.memNo = memNo;
    }

    public RichInputText getMemNo() {
        return this.memNo;
    }

    public void setClaimLOV(RichTable claimLOV) {
        this.claimLOV = claimLOV;
    }

    public RichTable getClaimLOV() {
        return this.claimLOV;
    }

    public void setClaimDesc(RichInputText claimDesc) {
        this.claimDesc = claimDesc;
    }

    public RichInputText getClaimDesc() {
        return this.claimDesc;
    }

    public void setEditPolNo(RichInputText editPolNo) {
        this.editPolNo = editPolNo;
    }

    public RichInputText getEditPolNo() {
        return this.editPolNo;
    }

    public void setEditTransNo(RichInputText editTransNo) {
        this.editTransNo = editTransNo;
    }

    public RichInputText getEditTransNo() {
        return this.editTransNo;
    }

    public void setFacilitatorLOV(RichTable facilitatorLOV) {
        this.facilitatorLOV = facilitatorLOV;
    }

    public RichTable getFacilitatorLOV() {
        return this.facilitatorLOV;
    }

    public void setFacilitatorDesc(RichInputText facilitatorDesc) {
        this.facilitatorDesc = facilitatorDesc;
    }

    public RichInputText getFacilitatorDesc() {
        return this.facilitatorDesc;
    }

    public void setActivitiesLOV(RichTable activitiesLOV) {
        this.activitiesLOV = activitiesLOV;
    }

    public RichTable getActivitiesLOV() {
        return this.activitiesLOV;
    }

    public void activityListener(SelectionEvent selectionEvent) {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindActivitiesIterator");


        RowKeySet set = selectionEvent.getAddedSet();
        Iterator rowKeySetIter = set.iterator();
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));

            Row r = dciter.getCurrentRow();

            this.session.setAttribute("ActivityCode",
                                      r.getAttribute("ACT_CODE"));

            this.actName.setValue(r.getAttribute("ACT_ACTIVITY"));
            this.actfeeDesc.setValue(null);
            this.actRemarks.setValue(null);
        }
    }

    public String sendSMS() {
        this.session.setAttribute("sysModule", "C");
        this.session.setAttribute("msgType", "SMS");

        FacesContext context = FacesContext.getCurrentInstance();

        ViewHandler viewHandler = context.getApplication().getViewHandler();
        GlobalCC.dialogName = "/sms.jspx";
        UIViewRoot dialog =
            viewHandler.createView(context, GlobalCC.dialogName);


        HashMap properties = new HashMap();
        properties.put("width", Integer.valueOf(600));
        properties.put("height", Integer.valueOf(800));

        AdfFacesContext afContext = AdfFacesContext.getCurrentInstance();

        afContext.launchDialog(dialog, null, null, true, properties);

        return null;
    }

    public String sendEmail() {
        this.session.setAttribute("sysModule", "C");
        this.session.setAttribute("msgType", "EMAIL");

        FacesContext context = FacesContext.getCurrentInstance();

        ViewHandler viewHandler = context.getApplication().getViewHandler();
        GlobalCC.dialogName = "/email.jspx";
        UIViewRoot dialog =
            viewHandler.createView(context, GlobalCC.dialogName);


        HashMap properties = new HashMap();
        properties.put("width", Integer.valueOf(600));
        properties.put("height", Integer.valueOf(800));

        AdfFacesContext afContext = AdfFacesContext.getCurrentInstance();

        afContext.launchDialog(dialog, null, null, true, properties);

        return null;
    }

    public void setActfeeDesc(RichInputText actfeeDesc) {
        this.actfeeDesc = actfeeDesc;
    }

    public RichInputText getActfeeDesc() {
        return this.actfeeDesc;
    }

    public void setActPayDate(RichInputDate actPayDate) {
        this.actPayDate = actPayDate;
    }

    public RichInputDate getActPayDate() {
        return this.actPayDate;
    }

    public void setActRemarks(RichInputText actRemarks) {
        this.actRemarks = actRemarks;
    }

    public RichInputText getActRemarks() {
        return this.actRemarks;
    }

    public void setActName(RichOutputText actName) {
        this.actName = actName;
    }

    public RichOutputText getActName() {
        return this.actName;
    }

    public void setDocsLOV(RichTable docsLOV) {
        this.docsLOV = docsLOV;
    }

    public RichTable getDocsLOV() {
        return this.docsLOV;
    }

    public void setEnClaimDesc(RichInputText enClaimDesc) {
        this.enClaimDesc = enClaimDesc;
    }

    public RichInputText getEnClaimDesc() {
        return this.enClaimDesc;
    }

    public void setEnClaimButton(RichCommandButton enClaimButton) {
        this.enClaimButton = enClaimButton;
    }

    public RichCommandButton getEnClaimButton() {
        return this.enClaimButton;
    }

    public void setEnClaimLabel(RichOutputLabel enClaimLabel) {
        this.enClaimLabel = enClaimLabel;
    }

    public RichOutputLabel getEnClaimLabel() {
        return this.enClaimLabel;
    }

    public void setEnPolicyLabel(RichOutputLabel enPolicyLabel) {
        this.enPolicyLabel = enPolicyLabel;
    }

    public RichOutputLabel getEnPolicyLabel() {
        return this.enPolicyLabel;
    }

    public void setEnPolicyButton(RichCommandButton enPolicyButton) {
        this.enPolicyButton = enPolicyButton;
    }

    public RichCommandButton getEnPolicyButton() {
        return this.enPolicyButton;
    }

    public void setEnMemberNo(RichOutputLabel enMemberNo) {
        this.enMemberNo = enMemberNo;
    }

    public RichOutputLabel getEnMemberNo() {
        return this.enMemberNo;
    }

    public void setEnMemberButton(RichCommandButton enMemberButton) {
        this.enMemberButton = enMemberButton;
    }

    public RichCommandButton getEnMemberButton() {
        return this.enMemberButton;
    }

    public void setEnTransLabel(RichOutputLabel enTransLabel) {
        this.enTransLabel = enTransLabel;
    }

    public RichOutputLabel getEnTransLabel() {
        return this.enTransLabel;
    }

    public void setEnTransDesc(RichInputText enTransDesc) {
        this.enTransDesc = enTransDesc;
    }

    public RichInputText getEnTransDesc() {
        return this.enTransDesc;
    }

    public void setEnTransButton(RichCommandButton enTransButton) {
        this.enTransButton = enTransButton;
    }

    public RichCommandButton getEnTransButton() {
        return this.enTransButton;
    }

    public void setRcClaimsLOV(RichTable rcClaimsLOV) {
        this.rcClaimsLOV = rcClaimsLOV;
    }

    public RichTable getRcClaimsLOV() {
        return this.rcClaimsLOV;
    }

    public void setRcClaimTransLOV(RichTable rcClaimTransLOV) {
        this.rcClaimTransLOV = rcClaimTransLOV;
    }

    public RichTable getRcClaimTransLOV() {
        return this.rcClaimTransLOV;
    }

    public void setPolicyPanel(HtmlPanelGrid policyPanel) {
        this.policyPanel = policyPanel;
    }

    public HtmlPanelGrid getPolicyPanel() {
        return this.policyPanel;
    }

    public void setClaimPanel(HtmlPanelGrid claimPanel) {
        this.claimPanel = claimPanel;
    }

    public HtmlPanelGrid getClaimPanel() {
        return this.claimPanel;
    }

    public void setTransPanel(HtmlPanelGrid transPanel) {
        this.transPanel = transPanel;
    }

    public HtmlPanelGrid getTransPanel() {
        return this.transPanel;
    }

    public void setMemberPanel(HtmlPanelGrid memberPanel) {
        this.memberPanel = memberPanel;
    }

    public HtmlPanelGrid getMemberPanel() {
        return this.memberPanel;
    }

    public void setClaimVouchers(RichTable claimVouchers) {
        this.claimVouchers = claimVouchers;
    }

    public RichTable getClaimVouchers() {
        return this.claimVouchers;
    }

    public void setVoucherDetails(RichTable voucherDetails) {
        this.voucherDetails = voucherDetails;
    }

    public RichTable getVoucherDetails() {
        return this.voucherDetails;
    }

    public void setGroupLifeRI(RichTable groupLifeRI) {
        this.groupLifeRI = groupLifeRI;
    }

    public RichTable getGroupLifeRI() {
        return this.groupLifeRI;
    }

    public void setParticipantsRI(RichTable participantsRI) {
        this.participantsRI = participantsRI;
    }

    public RichTable getParticipantsRI() {
        return this.participantsRI;
    }

    public void setFmSLabel(RichOutputLabel fmSLabel) {
        this.fmSLabel = fmSLabel;
    }

    public RichOutputLabel getFmSLabel() {
        return this.fmSLabel;
    }

    public void setFmSCheck(RichSelectBooleanCheckbox fmSCheck) {
        this.fmSCheck = fmSCheck;
    }

    public RichSelectBooleanCheckbox getFmSCheck() {
        return this.fmSCheck;
    }

    public void coverTypeListener(ValueChangeEvent valueChangeEvent) {
        if (valueChangeEvent.getOldValue() != valueChangeEvent.getNewValue()) {
            RowKeySet rowKeySet = this.coversLOV.getSelectedRowKeys();
            if (rowKeySet == null) {
                return;
            }
            if (!rowKeySet.iterator().hasNext()) {
                GlobalCC.errorValueNotEntered("No Record Selected");
                return;
            }
            Object key2 = rowKeySet.iterator().next();
            this.coversLOV.setRowKey(key2);
            JUCtrlValueBinding nodeBinding =
                (JUCtrlValueBinding)this.coversLOV.getRowData();
            if (nodeBinding == null) {
                GlobalCC.errorValueNotEntered("No Record Selected");
                return;
            }
            if (this.claimCbox.isSelected()) {
                nodeBinding.setAttribute("selected", Boolean.valueOf(true));
            } else {
                nodeBinding.setAttribute("selected", Boolean.valueOf(false));
            }
        }
    }

    public void setClaimCbox(RichSelectBooleanCheckbox claimCbox) {
        this.claimCbox = claimCbox;
    }

    public RichSelectBooleanCheckbox getClaimCbox() {
        return this.claimCbox;
    }

    public void setPensionPayee(RichSelectOneChoice pensionPayee) {
        this.pensionPayee = pensionPayee;
    }

    public RichSelectOneChoice getPensionPayee() {
        return this.pensionPayee;
    }

    public void setPensToPay(RichInputText pensToPay) {
        this.pensToPay = pensToPay;
    }

    public RichInputText getPensToPay() {
        return this.pensToPay;
    }

    public void setTaxPayable(RichInputText taxPayable) {
        this.taxPayable = taxPayable;
    }

    public RichInputText getTaxPayable() {
        return this.taxPayable;
    }

    public void setTaxable(RichInputText taxable) {
        this.taxable = taxable;
    }

    public RichInputText getTaxable() {
        return this.taxable;
    }

    public void setNetPay(RichInputText netPay) {
        this.netPay = netPay;
    }

    public RichInputText getNetPay() {
        return this.netPay;
    }

    public void setPayeesLOV(RichTable payeesLOV) {
        this.payeesLOV = payeesLOV;
    }

    public RichTable getPayeesLOV() {
        return this.payeesLOV;
    }

    public void setPayees2LOV(RichTable payees2LOV) {
        this.payees2LOV = payees2LOV;
    }

    public RichTable getPayees2LOV() {
        return this.payees2LOV;
    }

    public void setDocDesc(RichOutputText docDesc) {
        this.docDesc = docDesc;
    }

    public RichOutputText getDocDesc() {
        return this.docDesc;
    }

    public void setSubmitted(RichSelectOneChoice submitted) {
        this.submitted = submitted;
    }

    public RichSelectOneChoice getSubmitted() {
        return this.submitted;
    }

    public void setDateSubmitted(RichInputDate dateSubmitted) {
        this.dateSubmitted = dateSubmitted;
    }

    public RichInputDate getDateSubmitted() {
        return this.dateSubmitted;
    }

    public void setDocNo(RichInputText docNo) {
        this.docNo = docNo;
    }

    public RichInputText getDocNo() {
        return this.docNo;
    }

    public void setRaiseRequisition(RichSelectBooleanCheckbox raiseRequisition) {
        this.raiseRequisition = raiseRequisition;
    }

    public RichSelectBooleanCheckbox getRaiseRequisition() {
        return this.raiseRequisition;
    }

    public void setTotalCoinsAmt(RichSelectBooleanCheckbox totalCoinsAmt) {
        this.totalCoinsAmt = totalCoinsAmt;
    }

    public RichSelectBooleanCheckbox getTotalCoinsAmt() {
        return this.totalCoinsAmt;
    }

    public void setEffDate(RichInputDate effDate) {
        this.effDate = effDate;
    }

    public RichInputDate getEffDate() {
        return this.effDate;
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

    public void setVoucherLabel(RichOutputText voucherLabel) {
        this.voucherLabel = voucherLabel;
    }

    public RichOutputText getVoucherLabel() {
        return this.voucherLabel;
    }

    public void setPayeeLabel(RichOutputText payeeLabel) {
        this.payeeLabel = payeeLabel;
    }

    public RichOutputText getPayeeLabel() {
        return this.payeeLabel;
    }

    public void setDispStatus(RichSelectOneChoice dispStatus) {
        this.dispStatus = dispStatus;
    }

    public RichSelectOneChoice getDispStatus() {
        return this.dispStatus;
    }

    public void setResultsLOV(RichTable resultsLOV) {
        this.resultsLOV = resultsLOV;
    }

    public RichTable getResultsLOV() {
        return this.resultsLOV;
    }

    public void setMyTickets(RichPanelBox myTickets) {
        this.myTickets = myTickets;
    }

    public RichPanelBox getMyTickets() {
        return this.myTickets;
    }

    public void setExceptionLOV(RichTable exceptionLOV) {
        this.exceptionLOV = exceptionLOV;
    }

    public RichTable getExceptionLOV() {
        return this.exceptionLOV;
    }

    public void setPensIntRate(RichInputText pensIntRate) {
        this.pensIntRate = pensIntRate;
    }

    public RichInputText getPensIntRate() {
        return this.pensIntRate;
    }

    public void setMinimumInformationProvided(RichSelectOneChoice minimumInformationProvided) {
        this.minimumInformationProvided = minimumInformationProvided;
    }

    public RichSelectOneChoice getMinimumInformationProvided() {
        return this.minimumInformationProvided;
    }

    public void minimalInforListener(ValueChangeEvent valueChangeEvent) {
        if ((valueChangeEvent.getOldValue() !=
             valueChangeEvent.getNewValue()) &&
            (this.minimumInformationProvided.getValue() == null)) {
            GlobalCC.INFORMATIONREPORTING("Please specify whether minimal information has been specified");
        }
    }

    public void setExGratiaMemNo(RichInputText exGratiaMemNo) {
        this.exGratiaMemNo = exGratiaMemNo;
    }

    public RichInputText getExGratiaMemNo() {
        return this.exGratiaMemNo;
    }

    public void setExgratiaSurname(RichInputText exgratiaSurname) {
        this.exgratiaSurname = exgratiaSurname;
    }

    public RichInputText getExgratiaSurname() {
        return this.exgratiaSurname;
    }

    public void setExgratiaOtherNames(RichInputText exgratiaOtherNames) {
        this.exgratiaOtherNames = exgratiaOtherNames;
    }

    public RichInputText getExgratiaOtherNames() {
        return this.exgratiaOtherNames;
    }

    public void setExgratiaDateOfBirth(RichInputDate exgratiaDateOfBirth) {
        this.exgratiaDateOfBirth = exgratiaDateOfBirth;
    }

    public RichInputDate getExgratiaDateOfBirth() {
        return this.exgratiaDateOfBirth;
    }

    public void setExgratiaGender(RichSelectOneChoice exgratiaGender) {
        this.exgratiaGender = exgratiaGender;
    }

    public RichSelectOneChoice getExgratiaGender() {
        return this.exgratiaGender;
    }

    public void setExgratiaEarnings(RichInputText exgratiaEarnings) {
        this.exgratiaEarnings = exgratiaEarnings;
    }

    public RichInputText getExgratiaEarnings() {
        return this.exgratiaEarnings;
    }

    public void setExgratiaPeriod(RichInputText exgratiaPeriod) {
        this.exgratiaPeriod = exgratiaPeriod;
    }

    public RichInputText getExgratiaPeriod() {
        return this.exgratiaPeriod;
    }

    public String MemberLOVSelection() {
        if (this.xgratiaTransaction.isSelected()) {
            this.exGratiaMemNo.setValue(null);
            this.exgratiaSurname.setValue(null);
            this.exgratiaOtherNames.setValue(null);
            this.xgratiaMemberID.setValue(null);
            this.exgratiaDateOfBirth.setValue(null);
            this.exgratiaGender.setValue("M");
            this.session.setAttribute("PolicyMemCode", null);
            this.session.setAttribute("PolmCode", null);
            this.session.setAttribute("MemberNumber", null);
            this.membersDesc.setValue(null);
            this.dateOfJoining.setValue(null);
            GlobalCC.showPopup("pt1:ExgratiaPopup");
        } else {
            this.session.setAttribute("PolicyMemCode", null);
            this.session.setAttribute("PolmCode", null);
            this.session.setAttribute("MemberNumber", null);
            this.membersDesc.setValue(null);
            GlobalCC.showPopup("pt1:claims");
        }
        ADFUtils.findIterator("FindExgratiaMembersByTransactionsIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.exgratiaMembers);
        return null;
    }

    public void xGratiaClaimListener(ValueChangeEvent valueChangeEvent) {
        if (valueChangeEvent.getOldValue() != valueChangeEvent.getNewValue()) {
            if (this.xgratiaTransaction.isSelected()) {
                this.exgratiaCommLbl.setRendered(true);
                this.exgratiaRemarks.setRendered(true);
            } else {
                this.exgratiaCommLbl.setRendered(false);
                this.exgratiaRemarks.setRendered(false);
            }
            this.exgratiaRemarks.setValue(null);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.exgratiaCommLbl);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.exgratiaRemarks);
        }
    }

    public void xGratiaMembersListener(ValueChangeEvent valueChangeEvent) {
        if (valueChangeEvent.getOldValue() != valueChangeEvent.getNewValue()) {
            if (this.editExMem.isSelected()) {
                this.xgratiaButton.setDisabled(false);
            } else {
                this.xgratiaButton.setDisabled(true);
            }
            this.exGratiaMemNo.setValue(null);
            this.exgratiaSurname.setValue(null);
            this.exgratiaOtherNames.setValue(null);
            this.xgratiaMemberID.setValue(null);
            this.exgratiaDateOfBirth.setValue(null);
            this.exgratiaGender.setValue("M");
            this.session.setAttribute("PolicyMemCode", null);
            this.session.setAttribute("PolmCode", null);
            this.session.setAttribute("MemberNumber", null);
            this.dateOfJoining.setValue(null);

            AdfFacesContext.getCurrentInstance().addPartialTarget(this.exGratiaMemNo);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.exgratiaSurname);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.exgratiaOtherNames);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.xgratiaMemberID);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.exgratiaDateOfBirth);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.exgratiaGender);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.dateOfJoining);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.xgratiaButton);
        }
    }

    public void setXgratiaTransaction(RichSelectBooleanCheckbox xgratiaTransaction) {
        this.xgratiaTransaction = xgratiaTransaction;
    }

    public RichSelectBooleanCheckbox getXgratiaTransaction() {
        return this.xgratiaTransaction;
    }

    public String CreateXgratiaMember() {
        if (this.editExMem.isSelected()) {
            if (this.session.getAttribute("PolmCode") == null) {
                GlobalCC.INFORMATIONREPORTING("Select A Member");
                return null;
            }
        } else {
            this.session.setAttribute("PolicyMemCode", null);
            this.session.setAttribute("PolmCode", null);
            this.session.setAttribute("MemberNumber", null);
        }
        if (this.transType.getValue() == null) {
            GlobalCC.INFORMATIONREPORTING("Select A Transaction Type");
            return null;
        }
        if (this.exGratiaMemNo.getValue() == null) {
            GlobalCC.INFORMATIONREPORTING("Please specify the member number");
            return null;
        }
        if (this.exgratiaSurname.getValue() == null) {
            GlobalCC.INFORMATIONREPORTING("Please specify the member surname");
            return null;
        }
        if (this.exgratiaOtherNames.getValue() == null) {
            GlobalCC.INFORMATIONREPORTING("Please specify the member other names");
            return null;
        }
        if (this.exgratiaDateOfBirth.getValue() == null) {
            GlobalCC.INFORMATIONREPORTING("Please specify the member date of birth");
            return null;
        }
        if (this.exgratiaGender.getValue() == null) {
            GlobalCC.INFORMATIONREPORTING("Please specify the member gender");
            return null;
        }
        if (this.dateOfJoining.getValue() == null) {
            GlobalCC.INFORMATIONREPORTING("Please specify a Date of Joining.");
            return null;
        }
        BigDecimal Pol = (BigDecimal)this.session.getAttribute("policyCode");
        if (Pol == null) {
            GlobalCC.INFORMATIONREPORTING("Please specify the policy");
        }
        Connection conn = null;
        CallableStatement cst = null;
        String createQuery =
            "BEGIN LMS_WEB_CLAIMS_PKG.create_xgratia_mem(?,?,?,?,?,?,?,?,?,?,?);END;";
        try {
            DBConnector myConn = new DBConnector();
            conn = myConn.getDatabaseConn();

            cst = conn.prepareCall(createQuery);

            cst.setString(1, this.exGratiaMemNo.getValue().toString());
            cst.setString(2, this.exgratiaSurname.getValue().toString());
            cst.setString(3, this.exgratiaOtherNames.getValue().toString());
            if (this.xgratiaMemberID.getValue() == null) {
                cst.setString(4, null);
            } else {
                cst.setString(4, this.xgratiaMemberID.getValue().toString());
            }
            cst.setString(5, this.exgratiaGender.getValue().toString());
            if (this.exgratiaDateOfBirth.getValue().toString().contains(":")) {
                cst.setString(6,
                              GlobalCC.parseDate(this.exgratiaDateOfBirth.getValue().toString()));
            } else {
                cst.setString(6,
                              GlobalCC.upDateParseDate(this.exgratiaDateOfBirth.getValue().toString()));
            }
            cst.setBigDecimal(7, Pol);
            if (this.dateOfJoining.getValue() == null) {
                cst.setString(8, null);
            } else if (this.dateOfJoining.getValue().toString().contains(":")) {
                cst.setString(8,
                              GlobalCC.parseDate(this.dateOfJoining.getValue().toString()));
            } else {
                cst.setString(8,
                              GlobalCC.upDateParseDate(this.dateOfJoining.getValue().toString()));
            }
            cst.setString(9, this.transType.getValue().toString());
            if (this.editExMem.isSelected()) {
                cst.setBigDecimal(10,
                                  (BigDecimal)this.session.getAttribute("PolmCode"));
            } else {
                cst.registerOutParameter(10, 3);
            }
            cst.registerOutParameter(11, 3);

            cst.execute();
            if (!this.editExMem.isSelected()) {
                this.session.setAttribute("PolicyMemCode",
                                          cst.getBigDecimal(10));

                this.session.setAttribute("PolmCode", cst.getBigDecimal(10));
                this.session.setAttribute("MemberNumber",
                                          cst.getBigDecimal(11));
            }
            this.membersDesc.setValue(this.exGratiaMemNo.getValue().toString());

            AdfFacesContext.getCurrentInstance().addPartialTarget(this.membersDesc);

            cst.close();
            conn.close();
            GlobalCC.INFORMATIONREPORTING("Exgratia Member Successfully Created");
            GlobalCC.hidePopup("pt1:ExgratiaPopup");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
        return null;
    }

    public void setXgratiaMemberID(RichInputText xgratiaMemberID) {
        this.xgratiaMemberID = xgratiaMemberID;
    }

    public RichInputText getXgratiaMemberID() {
        return this.xgratiaMemberID;
    }

    public void setExGratiaEmpyerContr(RichInputText exGratiaEmpyerContr) {
        this.exGratiaEmpyerContr = exGratiaEmpyerContr;
    }

    public RichInputText getExGratiaEmpyerContr() {
        return this.exGratiaEmpyerContr;
    }

    public void setExGratiaEmpyeeContirbution(RichInputText exGratiaEmpyeeContirbution) {
        this.exGratiaEmpyeeContirbution = exGratiaEmpyeeContirbution;
    }

    public RichInputText getExGratiaEmpyeeContirbution() {
        return this.exGratiaEmpyeeContirbution;
    }

    public void setExGratiaVolEmpyerContr(RichInputText exGratiaVolEmpyerContr) {
        this.exGratiaVolEmpyerContr = exGratiaVolEmpyerContr;
    }

    public RichInputText getExGratiaVolEmpyerContr() {
        return this.exGratiaVolEmpyerContr;
    }

    public void setExGratiaVolEmpyeeContr(RichInputText exGratiaVolEmpyeeContr) {
        this.exGratiaVolEmpyeeContr = exGratiaVolEmpyeeContr;
    }

    public RichInputText getExGratiaVolEmpyeeContr() {
        return this.exGratiaVolEmpyeeContr;
    }

    public void setDateOfJoining(RichInputDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public RichInputDate getDateOfJoining() {
        return this.dateOfJoining;
    }

    public void setClaimsCausationsCauseLOV(RichTable claimsCausationsCauseLOV) {
        this.claimsCausationsCauseLOV = claimsCausationsCauseLOV;
    }

    public RichTable getClaimsCausationsCauseLOV() {
        return this.claimsCausationsCauseLOV;
    }

    public String AssignCausationCause() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindCausationCausesIterator");


        RowKeySet set = this.claimsCausationsCauseLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            this.session.setAttribute("CSC_CODE", r.getAttribute("CSC_CODE"));
            this.session.setAttribute("CLM_DDC_CODE",
                                      r.getAttribute("DDC_CODE"));

            this.causationCauseDesc.setValue(r.getAttribute("DDC_DESC"));
        }
        return null;
    }

    public void setCausationCauseDesc(RichInputText causationCauseDesc) {
        this.causationCauseDesc = causationCauseDesc;
    }

    public RichInputText getCausationCauseDesc() {
        return this.causationCauseDesc;
    }

    public String EditClaimDetails() {
        try {
            ADFUtils.findIterator("FindClaimsIterator").executeQuery();
            this.editClaimsTab.setRendered(true);
            this.mainClaimsTab.setRendered(false);
            this.pensionsTab.setRendered(false);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String ViewMaturityDetails() {
        try {
            this.editClaimsTab.setRendered(false);
            this.mainClaimsTab.setRendered(false);
            this.pensionsTab.setRendered(true);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String ShowClaimDetails() {
        try {
            ADFUtils.findIterator("FindClaimsIterator").executeQuery();
            this.editClaimsTab.setRendered(false);
            this.mainClaimsTab.setRendered(true);
            this.pensionsTab.setRendered(false);
            this.session.removeAttribute("pcyCode");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String UpdateClaimDetails() {
        Connection conn = null;
        CallableStatement cst = null;
        String updateQuery =
            "BEGIN LMS_WEB_CLAIMS_PKG.update_clm_details(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);END;";
        try {
            DBConnector myConn = new DBConnector();
            conn = myConn.getDatabaseConn();

            cst = conn.prepareCall(updateQuery);
            cst.setString(1, (String)this.session.getAttribute("ClaimNo"));
            cst.setString(2, GlobalCC.checkNullValues(this.age.getValue()));
            if (this.dateReported.getValue() == null) {
                cst.setString(3, null);
            } else if (this.dateReported.getValue().toString().contains(":")) {
                cst.setString(3,
                              GlobalCC.parseDate(this.dateReported.getValue().toString()));
            } else {
                cst.setString(3,
                              GlobalCC.upDateParseDate(this.dateReported.getValue().toString()));
            }
            if (this.deathDate.getValue() == null) {
                cst.setString(4, null);
            } else if (this.deathDate.getValue().toString().contains(":")) {
                cst.setString(4,
                              GlobalCC.parseDate(this.deathDate.getValue().toString()));
            } else {
                cst.setString(4,
                              GlobalCC.upDateParseDate(this.deathDate.getValue().toString()));
            }
            cst.setBigDecimal(5,
                              (BigDecimal)this.session.getAttribute("CausationCode"));

            cst.setBigDecimal(6,
                              (BigDecimal)this.session.getAttribute("CLM_DDC_CODE"));

            cst.setString(7,
                          GlobalCC.checkNullValues(this.retention.getValue()));

            cst.setString(8,
                          GlobalCC.checkNullValues(this.updRemarks.getValue()));


            cst.setString(9,
                          GlobalCC.checkNullValues(this.clmPayInst.getValue()));
            if (this.clmInstNo.getValue() == null) {
                cst.setString(10, null);
            } else {
                cst.setBigDecimal(10,
                                  new BigDecimal(this.clmInstNo.getValue().toString().trim()));
            }
            cst.setString(11,
                          GlobalCC.checkNullValues(this.clm_pay_freq.getValue()));

            cst.setString(12,
                          GlobalCC.checkNullValues(this.daysHospitalized.getValue()));

            if (this.employmentDate.getValue() == null) {
                cst.setString(13, null);
            } else if (this.employmentDate.getValue().toString().contains(":")) {
                cst.setString(13,
                              GlobalCC.parseDate(this.employmentDate.getValue().toString()));
            } else {
                cst.setString(13,
                              GlobalCC.upDateParseDate(this.employmentDate.getValue().toString()));
            }
            if (this.schemeJoinDate.getValue() == null) {
                cst.setString(14, null);
            } else if (this.schemeJoinDate.getValue().toString().contains(":")) {
                cst.setString(14,
                              GlobalCC.parseDate(this.schemeJoinDate.getValue().toString()));
            } else {
                cst.setString(14,
                              GlobalCC.upDateParseDate(this.schemeJoinDate.getValue().toString()));
            }
            if (this.dateOfBirth.getValue() == null) {
                cst.setString(15, null);
            } else if (this.dateOfBirth.getValue().toString().contains(":")) {
                cst.setString(15,
                              GlobalCC.parseDate(this.dateOfBirth.getValue().toString()));
            } else {
                cst.setString(15,
                              GlobalCC.upDateParseDate(this.dateOfBirth.getValue().toString()));
            }
            if (this.kraPinNo.getValue() == null) {
                cst.setString(16, null);
            } else {
                cst.setString(16, this.kraPinNo.getValue().toString().trim());
            }

            cst.execute();
            cst.close();
            conn.close();
            ShowClaimDetails();
            this.session.setAttribute("CoverTypeCode", null);
            ADFUtils.findIterator("FindClaimCoverTypesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.coversLOV);
            GlobalCC.INFORMATIONREPORTING("Claim Details Successfully Saved");
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
            ex.printStackTrace();
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
        return null;
    }

    public void payeeListener(ValueChangeEvent valueChangeEvent) {
        if ((valueChangeEvent.getOldValue() !=
             valueChangeEvent.getNewValue()) &&
            (this.payeeRadio.getValue() != null)) {
            String Value = this.payeeRadio.getValue().toString();
            if (Value.equalsIgnoreCase("E")) {
                this.entPayee.setRendered(true);
                this.selPayee.setRendered(false);
            } else {
                this.entPayee.setRendered(false);
                this.selPayee.setRendered(true);
            }
        }
    }

    public void setLossDescription(RichInputText lossDescription) {
        this.lossDescription = lossDescription;
    }

    public RichInputText getLossDescription() {
        return this.lossDescription;
    }

    public void setLossesLOV(RichTable lossesLOV) {
        this.lossesLOV = lossesLOV;
    }

    public RichTable getLossesLOV() {
        return this.lossesLOV;
    }

    public String AssignDisabilityLosses() {
        RowKeySet rowKeySet = this.lossesLOV.getSelectedRowKeys();
        Object key2 = rowKeySet.iterator().next();
        this.lossesLOV.setRowKey(key2);
        JUCtrlValueBinding r = (JUCtrlValueBinding)this.lossesLOV.getRowData();

        this.session.setAttribute("LDL_CODE", r.getAttribute("ldlCode"));
        this.session.setAttribute("WeeklyIndemnity",
                                  r.getAttribute("ldlWeeklyIndemnity"));


        ExtendedRenderKitService erkService =
            (ExtendedRenderKitService)Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                                         ExtendedRenderKitService.class);


        erkService.addScript(FacesContext.getCurrentInstance(),
                             "var hints = {autodismissNever:false}; AdfPage.PAGE.findComponent('pt1:disabilityLossesPopup').show(hints);");


        return null;
    }

    public void setDisabilityDays(RichInputText disabilityDays) {
        this.disabilityDays = disabilityDays;
    }

    public RichInputText getDisabilityDays() {
        return this.disabilityDays;
    }

    public String SaveDisabilityLoss() {
        String wklIndemnity =
            (String)this.session.getAttribute("WeeklyIndemnity");
        if (wklIndemnity == null) {
            wklIndemnity = "N";
        }
        if (this.session.getAttribute("LDL_CODE") == null) {
            GlobalCC.INFORMATIONREPORTING("Select A Disability");
            return null;
        }
        if ((wklIndemnity.equalsIgnoreCase("Y")) &&
            (this.disabilityDays.getValue() == null)) {
            GlobalCC.INFORMATIONREPORTING("Enter Number Of Days The Member Suffered The Disability Loss");
            return null;
        }
        Connection conn = null;
        CallableStatement cst = null;
        String updateQuery =
            "BEGIN LMS_WEB_CLAIMS_PKG.populate_disability_loss(?,?,?,?,?,?,?);END;";
        try {
            DBConnector myConn = new DBConnector();
            conn = myConn.getDatabaseConn();

            cst = conn.prepareCall(updateQuery);
            cst.setBigDecimal(1,
                              (BigDecimal)this.session.getAttribute("LDL_CODE"));

            cst.setString(2, (String)this.session.getAttribute("ClaimNo"));
            cst.setBigDecimal(3,
                              (BigDecimal)this.session.getAttribute("policyCode"));
            if (this.disabilityDays.getValue() == null) {
                cst.setString(4, null);
            } else {
                cst.setString(4, this.disabilityDays.getValue().toString());
            }
            if (this.clmExpAmount.getValue() == null) {
                cst.setString(5, null);
            } else {
                cst.setString(5, this.clmExpAmount.getValue().toString());
            }
            cst.setBigDecimal(6,
                              (BigDecimal)this.session.getAttribute("CDL_CODE"));
            if (this.clmPercPayable.getValue() == null) {
                cst.setString(7, null);
            } else {
                cst.setString(7, this.clmPercPayable.getValue().toString());
            }
            cst.execute();
            cst.close();
            conn.close();
            ADFUtils.findIterator("findMemberDisabilityLossesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.weekIndemnityLosses);

            ADFUtils.findIterator("findClaimDisabilityLossesIter").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.disabilitySelect);
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
        return null;
    }

    public void setWeeklyIndemnityClaims(RichPanelBox weeklyIndemnityClaims) {
        this.weeklyIndemnityClaims = weeklyIndemnityClaims;
    }

    public RichPanelBox getWeeklyIndemnityClaims() {
        return this.weeklyIndemnityClaims;
    }

    public String AddDisabilityLoss() {
        this.clmExpAmount.setValue(null);
        this.clmPercPayable.setValue(null);
        this.disabilityDays.setValue(null);
        this.disabilitySelect.setValue(null);
        this.session.setAttribute("CDL_CODE", null);
        this.session.setAttribute("LDL_CODE", null);

        GlobalCC.showPopup("lmsgroup:disabilityLossesPopup");
        return null;
    }

    public String EditDisabilityLosses() {
        RowKeySet rowKeySet = this.weekIndemnityLosses.getSelectedRowKeys();
        Object key2 = rowKeySet.iterator().next();
        this.weekIndemnityLosses.setRowKey(key2);
        JUCtrlValueBinding r =
            (JUCtrlValueBinding)this.weekIndemnityLosses.getRowData();
        if (r.getAttribute("cdlCode") == null) {
            GlobalCC.INFORMATIONREPORTING("Select A Disability Loss");
            return null;
        }
        this.session.setAttribute("CDL_CODE", r.getAttribute("cdlCode"));
        this.session.setAttribute("LDL_CODE", r.getAttribute("CDL_LDL_CODE"));

        this.disabilityDays.setValue(r.getAttribute("CDL_NOF_LOSS_DAYS"));
        this.clmExpAmount.setValue(r.getAttribute("cdlClmAmt"));
        this.clmPercPayable.setValue(r.getAttribute("CDL_PERC_PAYABLE"));

        ADFUtils.findIterator("findClaimDisabilityLossesIter").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.disabilitySelect);

        GlobalCC.showPopup("lmsgroup:disabilityLossesPopup");
        return null;
    }

    public String DeleteDisabilityLosses() {
        Connection conn = null;
        CallableStatement cst = null;
        String updateQuery =
            "BEGIN LMS_WEB_CLAIMS_PKG.delete_disability_loss(?);END;";
        try {
            RowKeySet rowKeySet =
                this.weekIndemnityLosses.getSelectedRowKeys();

            Object key2 = rowKeySet.iterator().next();
            this.weekIndemnityLosses.setRowKey(key2);
            JUCtrlValueBinding r =
                (JUCtrlValueBinding)this.weekIndemnityLosses.getRowData();
            if (r.getAttribute("cdlCode") == null) {
                GlobalCC.INFORMATIONREPORTING("Select A Disability Loss");
                return null;
            }
            this.session.setAttribute("CDL_CODE", r.getAttribute("cdlCode"));

            DBConnector myConn = new DBConnector();
            conn = myConn.getDatabaseConn();

            cst = conn.prepareCall(updateQuery);
            cst.setBigDecimal(1,
                              (BigDecimal)this.session.getAttribute("CDL_CODE"));

            cst.execute();
            cst.close();
            conn.close();

            GlobalCC.INFORMATIONREPORTING("Loss Deleted Successfully");
            this.session.setAttribute("CDL_CODE", null);

            ADFUtils.findIterator("findMemberDisabilityLossesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.weekIndemnityLosses);

            ADFUtils.findIterator("findClaimDisabilityLossesIter").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.disabilitySelect);
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
        return null;
    }

    public void setWeekIndemnityLosses(RichTable weekIndemnityLosses) {
        this.weekIndemnityLosses = weekIndemnityLosses;
    }

    public RichTable getWeekIndemnityLosses() {
        return this.weekIndemnityLosses;
    }

    public String gotToLandingScreen() {
        Connection conn = null;
        String updateQuery =
            "BEGIN LMS_WEB_CLAIMS_PKG.create_tpd_covers(?);END;";


        CallableStatement cst = null;
        try {
            DBConnector myConn = new DBConnector();
            conn = myConn.getDatabaseConn();

            cst = conn.prepareCall(updateQuery);
            cst.setString(1, (String)this.session.getAttribute("ClaimNo"));
            cst.execute();
            cst.close();
            conn.close();

            GlobalCC.RedirectPage("/g_claims.jspx");
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
        return null;
    }

    public String ShowPolicyTickets() {
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findPendingClaimTransactionsIterator");


            RowKeySet set = this.pendingTransactions.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));

                Row r = dciter.getCurrentRow();
                this.session.setAttribute("ClaimNo",
                                          r.getAttribute("LTR_CLM_NO"));


                ADFUtils.findIterator("findTicketDetailsByUserIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.resultsLOV);

                System.out.println("enter popup");
                ExtendedRenderKitService erkService =
                    (ExtendedRenderKitService)Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                                                 ExtendedRenderKitService.class);


                erkService.addScript(FacesContext.getCurrentInstance(),
                                     "var hints = {autodismissNever:false}; AdfPage.PAGE.findComponent('pt1:p1').show(hints);");
            }
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String DeletePendingClaimSelected() {
        String ClaimNo = null;
        String TransCode = null;
        BigDecimal TransNo = null;
        Connection conn = null;
        CallableStatement cst1 = null;

        DCIteratorBinding dciter =
            ADFUtils.findIterator("findPendingClaimTransactionsIterator");


        RowKeySet set = this.pendingTransactions.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
            ClaimNo = (String)r.getAttribute("LTR_CLM_NO");
            TransCode = (String)r.getAttribute("LTR_BTR_TRANS_CODE");
            TransNo = (BigDecimal)r.getAttribute("LTR_TRANS_NO");
            try {
                DBConnector myConn = new DBConnector();
                conn = myConn.getDatabaseConn();
                if (TransCode.equalsIgnoreCase("CO")) {
                    String PendingTrans =
                        "begin LMS_WEB_CLAIMS_PKG.delete_pend_pymnt_contra(?);end;";


                    cst1 = conn.prepareCall(PendingTrans);
                    cst1.setBigDecimal(1, TransNo);
                    cst1.execute();
                } else {
                    String PendingTrans =
                        "begin LMS_WEB_CLAIMS_PKG.delete_pending_clm_trans(?,?,?);end;";


                    cst1 = conn.prepareCall(PendingTrans);
                    cst1.setString(1, ClaimNo);
                    cst1.setString(2, TransCode);
                    cst1.setBigDecimal(3, TransNo);
                    cst1.execute();
                }
                GlobalCC.sysInformation("Claim Transaction Deleted");

                CancelClaimTransaction();

                cst1.close();
                conn.close();
            } catch (Exception e) {
                GlobalCC.EXCEPTIONREPORTING(conn, e);
            } finally {
                GlobalCC.CloseConnections(null, cst1, conn);
            }
        }
        return null;
    }

    public String CancelClaimTransaction() {
        this.myPendingTrans.setRendered(false);
        this.nextButton.setDisabled(false);
        this.session.removeAttribute("ClaimNo");

        return null;
    }

    public void setClmExpAmount(RichInputText clmExpAmount) {
        this.clmExpAmount = clmExpAmount;
    }

    public RichInputText getClmExpAmount() {
        return this.clmExpAmount;
    }

    public void setClmPercPayable(RichInputText clmPercPayable) {
        this.clmPercPayable = clmPercPayable;
    }

    public RichInputText getClmPercPayable() {
        return this.clmPercPayable;
    }

    public void setBeneficaryPayments(RichTable beneficaryPayments) {
        this.beneficaryPayments = beneficaryPayments;
    }

    public RichTable getBeneficaryPayments() {
        return this.beneficaryPayments;
    }

    public void setFeesAmount(RichInputText feesAmount) {
        this.feesAmount = feesAmount;
    }

    public RichInputText getFeesAmount() {
        return this.feesAmount;
    }

    public void setBeneficaryPaid(RichSelectOneChoice beneficaryPaid) {
        this.beneficaryPaid = beneficaryPaid;
    }

    public RichSelectOneChoice getBeneficaryPaid() {
        return this.beneficaryPaid;
    }

    public void setMainClaimsTab(RichPanelBox mainClaimsTab) {
        this.mainClaimsTab = mainClaimsTab;
    }

    public RichPanelBox getMainClaimsTab() {
        return this.mainClaimsTab;
    }

    public void setEditClaimsTab(RichPanelBox editClaimsTab) {
        this.editClaimsTab = editClaimsTab;
    }

    public RichPanelBox getEditClaimsTab() {
        return this.editClaimsTab;
    }

    public void setAge(RichInputText age) {
        this.age = age;
    }

    public RichInputText getAge() {
        return this.age;
    }

    public void setDateReported(RichInputDate dateReported) {
        this.dateReported = dateReported;
    }

    public RichInputDate getDateReported() {
        return this.dateReported;
    }

    public void setDeathDate(RichInputDate deathDate) {
        this.deathDate = deathDate;
    }

    public RichInputDate getDeathDate() {
        return this.deathDate;
    }

    public void setRetention(RichInputText retention) {
        this.retention = retention;
    }

    public RichInputText getRetention() {
        return this.retention;
    }

    public void setCoverDesc(RichOutputText coverDesc) {
        this.coverDesc = coverDesc;
    }

    public RichOutputText getCoverDesc() {
        return this.coverDesc;
    }

    public void setUpdRemarks(RichInputText updRemarks) {
        this.updRemarks = updRemarks;
    }

    public RichInputText getUpdRemarks() {
        return this.updRemarks;
    }

    public void setPayeeRadio(RichSelectOneRadio payeeRadio) {
        this.payeeRadio = payeeRadio;
    }

    public RichSelectOneRadio getPayeeRadio() {
        return this.payeeRadio;
    }

    public void setEntPayee(RichPanelBox entPayee) {
        this.entPayee = entPayee;
    }

    public RichPanelBox getEntPayee() {
        return this.entPayee;
    }

    public void setSelPayee(RichPanelBox selPayee) {
        this.selPayee = selPayee;
    }

    public RichPanelBox getSelPayee() {
        return this.selPayee;
    }

    public void setPayeeDesc(RichInputText payeeDesc) {
        this.payeeDesc = payeeDesc;
    }

    public RichInputText getPayeeDesc() {
        return this.payeeDesc;
    }

    public void setPendingTransactions(RichTable pendingTransactions) {
        this.pendingTransactions = pendingTransactions;
    }

    public RichTable getPendingTransactions() {
        return this.pendingTransactions;
    }

    public void setMyPendingTrans(RichPanelBox myPendingTrans) {
        this.myPendingTrans = myPendingTrans;
    }

    public RichPanelBox getMyPendingTrans() {
        return this.myPendingTrans;
    }

    public void setNextButton(RichCommandButton nextButton) {
        this.nextButton = nextButton;
    }

    public RichCommandButton getNextButton() {
        return this.nextButton;
    }

    public void setDisabilitySelect(RichSelectOneChoice disabilitySelect) {
        this.disabilitySelect = disabilitySelect;
    }

    public RichSelectOneChoice getDisabilitySelect() {
        return this.disabilitySelect;
    }

    public void disabilityLossListener(ValueChangeEvent valueChangeEvent) {
        if ((valueChangeEvent.getNewValue() != null) &&
            (valueChangeEvent.getNewValue() !=
             valueChangeEvent.getOldValue())) {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findClaimDisabilityLossesIter");


            Row r =
                dciter.getRowAtRangeIndex(((Integer)valueChangeEvent.getNewValue()).intValue());


            this.session.setAttribute("LDL_CODE", r.getAttribute("ldlCode"));
            this.session.setAttribute("WeeklyIndemnity",
                                      r.getAttribute("ldlWeeklyIndemnity"));


            String WeeklyDem =
                (String)this.session.getAttribute("WeeklyIndemnity");
            if (WeeklyDem == null) {
                this.noDaysLabel.setRendered(false);
                this.disabilityDays.setRendered(false);
                this.disabilityDays.setValue(null);
                this.clmPercPayableLabel.setRendered(true);
                this.clmPercPayable.setRendered(true);
                this.clmPercPayable.setValue(r.getAttribute("CDL_PERC_PAYABLE"));
            } else if (WeeklyDem.equalsIgnoreCase("Y")) {
                this.noDaysLabel.setRendered(true);
                this.disabilityDays.setRendered(true);
                this.disabilityDays.setValue(r.getAttribute("CDL_NOF_LOSS_DAYS"));
                this.clmPercPayableLabel.setRendered(false);
                this.clmPercPayable.setRendered(false);
                this.clmPercPayable.setValue(null);
            } else if (WeeklyDem.equalsIgnoreCase("N")) {
                this.noDaysLabel.setRendered(false);
                this.disabilityDays.setRendered(false);
                this.disabilityDays.setValue(null);
                this.clmPercPayableLabel.setRendered(true);
                this.clmPercPayable.setRendered(true);
                this.clmPercPayable.setValue(r.getAttribute("CDL_PERC_PAYABLE"));
            } else {
                this.noDaysLabel.setRendered(false);
                this.disabilityDays.setRendered(false);
                this.disabilityDays.setValue(null);
            }
            this.clmExpAmount.setValue(null);
        }
    }

    public void setNoDaysLabel(RichOutputLabel noDaysLabel) {
        this.noDaysLabel = noDaysLabel;
    }

    public RichOutputLabel getNoDaysLabel() {
        return this.noDaysLabel;
    }

    public void setInvoiceLabel(RichOutputLabel invoiceLabel) {
        this.invoiceLabel = invoiceLabel;
    }

    public RichOutputLabel getInvoiceLabel() {
        return this.invoiceLabel;
    }

    public void setClaimStatus(RichSelectOneChoice claimStatus) {
        this.claimStatus = claimStatus;
    }

    public RichSelectOneChoice getClaimStatus() {
        return this.claimStatus;
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

    public void setStudentSex(RichSelectOneChoice studentSex) {
        this.studentSex = studentSex;
    }

    public RichSelectOneChoice getStudentSex() {
        return this.studentSex;
    }

    public void setStudentsLOV(RichTable studentsLOV) {
        this.studentsLOV = studentsLOV;
    }

    public RichTable getStudentsLOV() {
        return this.studentsLOV;
    }

    public void setStudentType(RichInputText studentType) {
        this.studentType = studentType;
    }

    public RichInputText getStudentType() {
        return this.studentType;
    }

    public void setStudentSharePct(RichInputText studentSharePct) {
        this.studentSharePct = studentSharePct;
    }

    public RichInputText getStudentSharePct() {
        return this.studentSharePct;
    }

    public void setPensPayeeName(RichInputText pensPayeeName) {
        this.pensPayeeName = pensPayeeName;
    }

    public RichInputText getPensPayeeName() {
        return this.pensPayeeName;
    }

    public void setPensPayeePIN(RichInputText pensPayeePIN) {
        this.pensPayeePIN = pensPayeePIN;
    }

    public RichInputText getPensPayeePIN() {
        return this.pensPayeePIN;
    }

    public void pensionPayeeListener(ValueChangeEvent valueChangeEvent) {
        if (valueChangeEvent.getNewValue() != valueChangeEvent.getOldValue()) {
            if (this.pensionPayee.getValue() == null) {
                this.pensPayeeName.setDisabled(true);
                this.pensPayeePIN.setDisabled(true);
                this.session.setAttribute("pensionPayee", "N");
            } else if (this.pensionPayee.getValue().toString().equalsIgnoreCase("PFA")) {
                this.pensPayeeName.setDisabled(false);
                this.pensPayeePIN.setDisabled(false);
                this.session.setAttribute("pensionPayee", "Y");
            } else if (this.pensionPayee.getValue().toString().equalsIgnoreCase("RSA")) {
                this.pensPayeeName.setDisabled(false);
                this.pensPayeePIN.setDisabled(false);
                this.session.setAttribute("pensionPayee", "Y");
            } else {
                this.pensPayeeName.setDisabled(true);
                this.pensPayeePIN.setDisabled(true);
                this.session.setAttribute("pensionPayee", "N");
            }
        }
    }

    public void setPaymentFreq(RichSelectOneChoice paymentFreq) {
        this.paymentFreq = paymentFreq;
    }

    public RichSelectOneChoice getPaymentFreq() {
        return this.paymentFreq;
    }

    public void setPensMaturities(RichTable pensMaturities) {
        this.pensMaturities = pensMaturities;
    }

    public RichTable getPensMaturities() {
        return this.pensMaturities;
    }

    public void setPensionsTab(RichPanelBox pensionsTab) {
        this.pensionsTab = pensionsTab;
    }

    public RichPanelBox getPensionsTab() {
        return this.pensionsTab;
    }

    public void setVouchersTable(RichTable vouchersTable) {
        this.vouchersTable = vouchersTable;
    }

    public RichTable getVouchersTable() {
        return this.vouchersTable;
    }

    public void setMatDocuments(RichTable matDocuments) {
        this.matDocuments = matDocuments;
    }

    public RichTable getMatDocuments() {
        return this.matDocuments;
    }

    public void MaturityListener(SelectionEvent selectionEvent) {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindPensionMaturitiesIterator");


        RowKeySet set = selectionEvent.getAddedSet();
        Iterator rowKeySetIter = set.iterator();
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));

            Row r = dciter.getCurrentRow();

            this.session.setAttribute("pcyCode", r.getAttribute("PCY_CODE"));
        }
        ADFUtils.findIterator("findClaimVouchersIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.vouchersTable);

        ADFUtils.findIterator("FindMaturityDocumentsIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.matDocuments);
    }

    public String findTaxSelected() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findProductTaxesIterator");


        RowKeySet set = this.taxTable.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            this.taxDesc.setValue(r.getAttribute("TT_DESC"));

            this.session.setAttribute("ttCode", r.getAttribute("TT_CODE"));
            this.session.setAttribute("trtRateType",
                                      r.getAttribute("TRT_RATE_TYPE"));
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.taxDesc);
        GlobalCC.hidePopup("lmsgroup:p4");

        return null;
    }

    public String AddTax() {
        this.taxDesc.setValue(null);
        this.taxRate.setValue(null);
        this.taxAmount.setValue(null);
        this.session.setAttribute("ttCode", null);
        this.session.setAttribute("trtRateType", null);
        this.session.setAttribute("pptxCode", null);
        this.session.setAttribute("action", "A");

        GlobalCC.showPopup("lmsgroup:p1");
        return null;
    }

    public String EditTax() {
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findPensionTaxesIterator");


            RowKeySet set = this.pensionTaxTable.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                this.taxDesc.setValue(r.getAttribute("TT_DESC"));
                this.taxRate.setValue(r.getAttribute("PPTX_RATE"));
                this.taxAmount.setValue(r.getAttribute("PPTX_TAX_AMT"));
                this.session.setAttribute("ttCode",
                                          r.getAttribute("PPTX_TT_CODE"));

                this.session.setAttribute("trtRateType",
                                          r.getAttribute("PPTX_RATE_TYPE"));


                this.session.setAttribute("pptxCode",
                                          r.getAttribute("PPTX_CODE"));
            }
            this.session.setAttribute("action", "E");
            GlobalCC.showPopup("lmsgroup:p1");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String DeleteTax() {
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findPensionTaxesIterator");


            RowKeySet set = this.pensionTaxTable.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                this.taxDesc.setValue(r.getAttribute("TT_DESC"));
                this.taxRate.setValue(r.getAttribute("PPTX_RATE"));
                this.taxAmount.setValue(r.getAttribute("PPTX_TAX_AMT"));
                this.session.setAttribute("ttCode",
                                          r.getAttribute("PPTX_TT_CODE"));

                this.session.setAttribute("trtRateType",
                                          r.getAttribute("PPTX_RATE_TYPE"));


                this.session.setAttribute("pptxCode",
                                          r.getAttribute("PPTX_CODE"));
            }
            this.session.setAttribute("action", "D");
            SaveTax();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String SaveTax() {
        Connection conn = null;
        CallableStatement cst = null;
        try {
            DBConnector MyConn = new DBConnector();
            conn = MyConn.getDatabaseConn();

            String updateQuery =
                "BEGIN LMS_WEB_PKG_GRP_UW.save_pension_tax(?,?,?,?,?,?,?,?);END;";


            cst = conn.prepareCall(updateQuery);
            cst.setString(1, (String)this.session.getAttribute("action"));
            cst.setBigDecimal(2,
                              (BigDecimal)this.session.getAttribute("pptxCode"));

            cst.setBigDecimal(3,
                              (BigDecimal)this.session.getAttribute("ttCode"));

            cst.setString(4, (String)this.session.getAttribute("trtRateType"));
            cst.setBigDecimal(5,
                              (BigDecimal)this.session.getAttribute("policyCode"));


            cst.setBigDecimal(6,
                              (BigDecimal)this.session.getAttribute("PolmCode"));
            if (this.taxRate.getValue() == null) {
                cst.setString(7, null);
            } else {
                cst.setString(7, this.taxRate.getValue().toString());
            }
            if (this.taxAmount.getValue() == null) {
                cst.setString(8, null);
            } else {
                cst.setString(8, this.taxAmount.getValue().toString());
            }
            cst.execute();
            conn.close();

            ADFUtils.findIterator("findPensionTaxesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.pensionTaxTable);

            GlobalCC.INFORMATIONREPORTING("Transaction Successfully Completed.");
            GlobalCC.hidePopup("lmsgroup:p1");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
        return null;
    }

    public void setTaxTable(RichTable taxTable) {
        this.taxTable = taxTable;
    }

    public RichTable getTaxTable() {
        return this.taxTable;
    }

    public void setTaxDesc(RichInputText taxDesc) {
        this.taxDesc = taxDesc;
    }

    public RichInputText getTaxDesc() {
        return this.taxDesc;
    }

    public void setTaxRate(RichInputText taxRate) {
        this.taxRate = taxRate;
    }

    public RichInputText getTaxRate() {
        return this.taxRate;
    }

    public void setTaxAmount(RichInputText taxAmount) {
        this.taxAmount = taxAmount;
    }

    public RichInputText getTaxAmount() {
        return this.taxAmount;
    }

    public void setPensionTaxTable(RichTable pensionTaxTable) {
        this.pensionTaxTable = pensionTaxTable;
    }

    public RichTable getPensionTaxTable() {
        return this.pensionTaxTable;
    }

    public void setAgencyTable(RichTable agencyTable) {
        this.agencyTable = agencyTable;
    }

    public RichTable getAgencyTable() {
        return this.agencyTable;
    }

    public void setAgencyDesc(RichInputText agencyDesc) {
        this.agencyDesc = agencyDesc;
    }

    public RichInputText getAgencyDesc() {
        return this.agencyDesc;
    }

    public void setRsaPin(RichInputText rsaPin) {
        this.rsaPin = rsaPin;
    }

    public RichInputText getRsaPin() {
        return this.rsaPin;
    }

    public void setAnnuitiesTable(RichTable annuitiesTable) {
        this.annuitiesTable = annuitiesTable;
    }

    public RichTable getAnnuitiesTable() {
        return this.annuitiesTable;
    }

    public void setClaimRecoveries(RichTable claimRecoveries) {
        this.claimRecoveries = claimRecoveries;
    }

    public RichTable getClaimRecoveries() {
        return this.claimRecoveries;
    }

    public void VoucherListener(SelectionEvent selectionEvent) {
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findClaimVouchersIterator");


            RowKeySet set = this.claimVouchers.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));

                Row r = dciter.getCurrentRow();
                this.session.setAttribute("voucherNumber",
                                          r.getAttribute("cpvVouvherNo"));
            }
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
    }

    public void MultiVoucherListener(SelectionEvent selectionEvent) {
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findMultipleClaimVouchersIterator");


            RowKeySet set = this.claimVouchers.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));

                Row r = dciter.getCurrentRow();
                this.session.setAttribute("voucherNumber",
                                          r.getAttribute("cpvVouvherNo"));
            }
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
    }

    public void setExgratiaCommLbl(RichOutputLabel exgratiaCommLbl) {
        this.exgratiaCommLbl = exgratiaCommLbl;
    }

    public RichOutputLabel getExgratiaCommLbl() {
        return this.exgratiaCommLbl;
    }

    public void setExgratiaRemarks(RichInputText exgratiaRemarks) {
        this.exgratiaRemarks = exgratiaRemarks;
    }

    public RichInputText getExgratiaRemarks() {
        return this.exgratiaRemarks;
    }

    public String CancelExgratiaSelection() {
        GlobalCC.hidePopup("pt1:p2");

        return null;
    }

    public String ExgratiaMemberSelected() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindExgratiaMembersByTransactionsIterator");


        RowKeySet set = this.exgratiaMembers.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            this.exGratiaMemNo.setValue(r.getAttribute("polm_mem_no"));
            this.exgratiaSurname.setValue(r.getAttribute("MEM_SURNAME"));
            this.exgratiaOtherNames.setValue(r.getAttribute("MEM_OTHER_NAMES"));
            this.xgratiaMemberID.setValue(r.getAttribute("MEM_IDENTITY_NO"));
            this.exgratiaDateOfBirth.setValue(r.getAttribute("MEM_DOB"));
            this.exgratiaGender.setValue(r.getAttribute("MEM_SEX"));

            this.session.setAttribute("PolicyMemCode",
                                      r.getAttribute("POLM_CODE"));

            this.session.setAttribute("PolmCode", r.getAttribute("POLM_CODE"));
            this.session.setAttribute("MemberNumber",
                                      r.getAttribute("MEM_CODE"));

            this.dateOfJoining.setValue(r.getAttribute("MEM_SCHEDULE_JOIN_DATE"));

            AdfFacesContext.getCurrentInstance().addPartialTarget(this.exGratiaMemNo);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.exgratiaSurname);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.exgratiaOtherNames);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.xgratiaMemberID);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.exgratiaDateOfBirth);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.exgratiaGender);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.dateOfJoining);

            GlobalCC.hidePopup("pt1:p2");
        }
        return null;
    }

    public void setExgratiaMembers(RichTable exgratiaMembers) {
        this.exgratiaMembers = exgratiaMembers;
    }

    public RichTable getExgratiaMembers() {
        return this.exgratiaMembers;
    }

    public void setAddExMem(RichSelectBooleanRadio addExMem) {
        this.addExMem = addExMem;
    }

    public RichSelectBooleanRadio getAddExMem() {
        return this.addExMem;
    }

    public void setEditExMem(RichSelectBooleanRadio editExMem) {
        this.editExMem = editExMem;
    }

    public RichSelectBooleanRadio getEditExMem() {
        return this.editExMem;
    }

    public void setXgratiaButton(RichCommandButton xgratiaButton) {
        this.xgratiaButton = xgratiaButton;
    }

    public RichCommandButton getXgratiaButton() {
        return this.xgratiaButton;
    }

    public void setCvrSelection(RichSelectOneChoice cvrSelection) {
        this.cvrSelection = cvrSelection;
    }

    public RichSelectOneChoice getCvrSelection() {
        return this.cvrSelection;
    }

    public void setXgratiaSA(RichInputText xgratiaSA) {
        this.xgratiaSA = xgratiaSA;
    }

    public RichInputText getXgratiaSA() {
        return this.xgratiaSA;
    }

    public void setXgratiaEarningsAmt(RichInputText xgratiaEarningsAmt) {
        this.xgratiaEarningsAmt = xgratiaEarningsAmt;
    }

    public RichInputText getXgratiaEarningsAmt() {
        return this.xgratiaEarningsAmt;
    }

    public void setXgratiaEarningsPrd(RichInputText xgratiaEarningsPrd) {
        this.xgratiaEarningsPrd = xgratiaEarningsPrd;
    }

    public RichInputText getXgratiaEarningsPrd() {
        return this.xgratiaEarningsPrd;
    }

    public void setDeathLocation(RichInputText deathLocation) {
        this.deathLocation = deathLocation;
    }

    public RichInputText getDeathLocation() {
        return this.deathLocation;
    }

    public void setRetireHeldPct(RichInputText retireHeldPct) {
        this.retireHeldPct = retireHeldPct;
    }

    public RichInputText getRetireHeldPct() {
        return this.retireHeldPct;
    }

    public String addMemberDetails() {
        if (this.transType.getValue() == null) {
            GlobalCC.INFORMATIONREPORTING("Select a Transaction Type");
            return null;
        }
        String TransType =
            (String)this.session.getAttribute("ClaimTransactionType");
        if (TransType.equalsIgnoreCase("RO")) {
            SaveReopenClaim();
            return null;
        }
        if (TransType.equalsIgnoreCase("CO")) {
            SaveContraClaim();
            return null;
        }
        this.session.setAttribute("ClaimProcessTrans", "Other");

        BigDecimal Pol = (BigDecimal)this.session.getAttribute("policyCode");
        if (Pol == null) {
            GlobalCC.INFORMATIONREPORTING("Select a policy");
            return null;
        }
        BigDecimal PolicyMem =
            (BigDecimal)this.session.getAttribute("PolicyMemCode");
        if (PolicyMem == null) {
            GlobalCC.INFORMATIONREPORTING("Select a policy Member");
            return null;
        }
        if (this.minimumInformationProvided.getValue() == null) {
            GlobalCC.INFORMATIONREPORTING("Specify if minimal information has been provided or not");
            return null;
        }
        if ((this.minimumInformationProvided.getValue().toString().equalsIgnoreCase("N")) &&
            (this.lossDate.getValue() == null)) {
            GlobalCC.INFORMATIONREPORTING("Enter a Loss Date");
            return null;
        }
        if (this.reportDate.getValue() == null) {
            GlobalCC.INFORMATIONREPORTING("Enter a Report Date");
            return null;
        }
        if (this.minimumInformationProvided.getValue().toString().equalsIgnoreCase("N")) {
            BigDecimal Cause =
                (BigDecimal)this.session.getAttribute("CauseCode");
            if (Cause == null) {
                GlobalCC.INFORMATIONREPORTING("select a Causation Cause");
                return null;
            }
        } else {
            BigDecimal Cause =
                (BigDecimal)this.session.getAttribute("CauseCode");
            if ((Cause != null) && (this.lossDate.getValue() != null)) {
                GlobalCC.INFORMATIONREPORTING("Invalid Option for Minimum Information Provided Field. You Have provided the Causation Cause and/or Loss Date ");
                return null;
            }
        }
        if ((this.xgratiaTransaction.isSelected()) &&
            (this.exgratiaRemarks.getValue() == null)) {
            GlobalCC.INFORMATIONREPORTING("Enter an Exgratia Comment.");
            return null;
        }
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        try {
            String AddClaim =
                "begin LMS_WEB_CLAIMS_PKG.ADD_MULTIPLE_CLAIMS(?,?,?,?,?,?,?,?,?,?,?,?);end;";


            cst = conn.prepareCall(AddClaim);
            cst.setBigDecimal(1,
                              (BigDecimal)this.session.getAttribute("PolicyMemCode"));
            if (this.lossDate.getValue() == null) {
                cst.setString(2, null);
            } else {
                cst.setString(2,
                              GlobalCC.parseDate(this.lossDate.getValue().toString()));
            }
            if (this.reportDate.getValue() == null) {
                cst.setString(3, null);
            } else {
                cst.setString(3,
                              GlobalCC.parseDate(this.reportDate.getValue().toString()));
            }
            cst.setBigDecimal(4,
                              (BigDecimal)this.session.getAttribute("policyCode"));


            cst.setBigDecimal(5,
                              (BigDecimal)this.session.getAttribute("CausationCode"));


            cst.setString(6,
                          (String)this.session.getAttribute("CausationShtDesc"));

            cst.setString(7,
                          (String)this.session.getAttribute("CausationType"));

            cst.setBigDecimal(8,
                              (BigDecimal)this.session.getAttribute("CauseCode"));


            cst.setString(9,
                          this.minimumInformationProvided.getValue().toString());
            if (this.xgratiaTransaction.isSelected()) {
                cst.setString(10, "Y");
            } else {
                cst.setString(10, "N");
            }
            if (this.exgratiaRemarks.getValue() == null) {
                cst.setString(11, "N");
            } else {
                cst.setString(11, this.exgratiaRemarks.getValue().toString());
            }
            if (this.deathLocation.getValue() == null) {
                cst.setString(12, null);
            } else {
                cst.setString(12, this.deathLocation.getValue().toString());
            }
            cst.execute();
            cst.close();
            conn.close();

            GlobalCC.INFORMATIONREPORTING("Member added successfully");
            ADFUtils.findIterator("FindMultipleClaimsMemIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.multipleMemLOV);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
        return null;
    }

    public void setMultipleMemLOV(RichTable multipleMemLOV) {
        this.multipleMemLOV = multipleMemLOV;
    }

    public RichTable getMultipleMemLOV() {
        return this.multipleMemLOV;
    }

    public String createNewMultiClaim() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        try {
            ADFUtils.findIterator("findPendingClaimTransactionsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.pendingTransactions);

            String pendingTrans =
                (String)this.session.getAttribute("pendingClaim");
            if (pendingTrans.equalsIgnoreCase("Y")) {
                GlobalCC.sysInformation("The Member Selected has another unfinished Claim Transaction");
                this.myPendingTrans.setRendered(true);
                this.nextButton.setDisabled(true);
                return null;
            }
            String AddClaim =
                "begin LMS_WEB_CLAIMS_PKG.CREATE_NEW_MULTI_CLAIM(?,?,?,?,?,?,?,?,?);end;";


            cst = conn.prepareCall(AddClaim);
            cst.setBigDecimal(1,
                              (BigDecimal)this.session.getAttribute("policyCode"));


            cst.setString(2,
                          (String)this.session.getAttribute("ClaimTransactionType"));


            cst.setString(3, (String)this.session.getAttribute("Username"));
            cst.registerOutParameter(4, 12);
            cst.registerOutParameter(5, 3);
            cst.registerOutParameter(6, 3);
            cst.setString(7,
                          this.minimumInformationProvided.getValue().toString());
            if (this.xgratiaTransaction.isSelected()) {
                cst.setString(8, "Y");
            } else {
                cst.setString(8, "N");
            }
            if (this.exgratiaRemarks.getValue() == null) {
                cst.setString(9, "N");
            } else {
                cst.setString(9, this.exgratiaRemarks.getValue().toString());
            }
            cst.execute();

            this.session.setAttribute("clmbatchNo", cst.getBigDecimal(6));

            cst.close();
            conn.close();

            GlobalCC.RedirectPage("/g_multiclaims.jspx");
            return null;
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
            e.printStackTrace();
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
        return null;
    }

    public void setClaimNo(SelectionEvent selectionEvent) {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindMultiClaimsIterator");


        RowKeySet set = this.mutipleClaimsLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
            this.session.setAttribute("ClaimNo", r.getAttribute("CLM_NO"));
            this.session.setAttribute("multiple_claims",
                                      r.getAttribute("CLM_NO"));


            ADFUtils.findIterator("FindMultiClaimCoverTypesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.coversLOV);

            ADFUtils.findIterator("findClaimBeneficaryPaymentsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.beneficaryPayments);

            ADFUtils.findIterator("FindClaimCoinsuranceRecoveriesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.claimRecoveries);

            ADFUtils.findIterator("FindClaimDocumentsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.docsLOV);
        }
    }

    public void setMutipleClaimsLOV(RichTable mutipleClaimsLOV) {
        this.mutipleClaimsLOV = mutipleClaimsLOV;
    }

    public RichTable getMutipleClaimsLOV() {
        return this.mutipleClaimsLOV;
    }

    public String processMultipleClaims() {
        Connection conn = null;
        CallableStatement cst = null;
        try {
            boolean MakeCall = false;
            DBConnector db = new DBConnector();
            conn = db.getDatabaseConn();

            cst =
conn.prepareCall("begin LMS_WEB_CLAIMS_PKG.PROCESS_MULTIPLE_CLAIM(?,?);end;");


            int rowCount = 0;
            boolean Value = false;
            rowCount = this.coversLOV.getRowCount();
            if (rowCount == 0) {
                return null;
            }
            for (int i = 0; i < rowCount; i++) {
                this.coversLOV.setRowIndex(i);
                JUCtrlValueBinding nodeBinding =
                    (JUCtrlValueBinding)this.coversLOV.getRowData();
                if (nodeBinding != null) {
                    Value =
                            ((Boolean)nodeBinding.getAttribute("selected")).booleanValue();
                    if (Value == true) {
                        MakeCall = true;
                        cst.setBigDecimal(1,
                                          (BigDecimal)this.session.getAttribute("clmbatchNo"));


                        cst.setBigDecimal(2,
                                          (BigDecimal)nodeBinding.getAttribute("CCVT_CODE"));


                        cst.execute();
                        System.out.println("CCVT_CODE=" +
                                           nodeBinding.getAttribute("CCVT_CODE"));
                    }
                }
            }
            cst.close();
            conn.close();

            GlobalCC.INFORMATIONREPORTING("Claim Processing Complete");
            ADFUtils.findIterator("FindMultiClaimCoverTypesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.coversLOV);
            ADFUtils.findIterator("findClaimBeneficaryPaymentsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.beneficaryPayments);

            ADFUtils.findIterator("FindClaimCoinsuranceRecoveriesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.claimRecoveries);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
            e.printStackTrace();
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
        return null;
    }

    public String editMultipleCover() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindMultiClaimCoverTypesIterator");


        RowKeySet set = this.coversLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            this.session.setAttribute("CoverTypeCode",
                                      r.getAttribute("CCVT_CODE"));

            this.session.setAttribute("PCT_CODE",
                                      r.getAttribute("ccvt_pct_code"));

            this.cvrSelection.setDisabled(true);
            this.coverDesc.setValue(r.getAttribute("CVT_DESC"));
            this.amtClaimed.setValue(r.getAttribute("CCVT_AMT_TO_BE_PAID"));
            this.butPay.setValue(r.getAttribute("CCVT_BUT_PAY_AMT"));
            this.remarks.setValue(r.getAttribute("CCVT_REMARKS"));
            this.payee.setValue(r.getAttribute("CCVT_PAYEE"));
            String Value = (String)r.getAttribute("CLM_PAY_TOT_COINS_AMT");
            if (Value.equalsIgnoreCase("Y")) {
                this.totalCoinsAmt.setSelected(true);
            } else {
                this.totalCoinsAmt.setSelected(false);
            }
            String Exgratia =
                (String)this.session.getAttribute("exgratiaClaim");
            if (Exgratia == null) {
                this.xgratiaSA.setValue(null);
                this.xgratiaEarningsAmt.setValue(null);
                this.xgratiaEarningsPrd.setValue(null);
            } else if (Exgratia.equalsIgnoreCase("Y")) {
                this.xgratiaSA.setValue(r.getAttribute("CCVT_SA"));
                this.xgratiaEarningsAmt.setValue(r.getAttribute("CCVT_EARNINGS"));
                this.xgratiaEarningsPrd.setValue(r.getAttribute("CCVT_MULT_EARNINGS_PRD"));
            } else {
                this.xgratiaSA.setValue(null);
                this.xgratiaEarningsAmt.setValue(null);
                this.xgratiaEarningsPrd.setValue(null);
            }
            GlobalCC.showPopup("lmsgroup:editMultiCover");
        }
        return null;
    }

    public String updateMultipleClaimsCover() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        try {
            String str1;
            if (this.payee.getValue() == null) {
                String Message1 = "Select a Payee";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message1,
                                                                              Message1));


                return null;
            }
            if (this.payee.getValue().toString().equalsIgnoreCase("O")) {
                editOtherPayee2();
                return null;
            }
            String UpdateClaim =
                "begin LMS_WEB_PKG_GRP.update_claim_cvr_details(?,?,?,?,?,?,?,?,?,?,?,?);end;";


            cst = conn.prepareCall(UpdateClaim);

            cst.setBigDecimal(1,
                              (BigDecimal)this.session.getAttribute("CoverTypeCode"));
            if (this.amtClaimed.getValue() == null) {
                cst.setBigDecimal(2, null);
            } else {
                cst.setString(2, this.amtClaimed.getValue().toString());
            }
            if (this.butPay.getValue() == null) {
                cst.setBigDecimal(3, null);
            } else {
                cst.setString(3, this.butPay.getValue().toString());
            }
            if (this.remarks.getValue() == null) {
                cst.setString(4, null);
            } else {
                cst.setString(4, this.remarks.getValue().toString());
            }
            if (this.payee.getValue() == null) {
                cst.setString(5, null);
            } else {
                cst.setString(5, this.payee.getValue().toString());
            }
            cst.setString(6, null);
            if (this.totalCoinsAmt.isSelected()) {
                cst.setString(7, "Y");
            } else {
                cst.setString(7, "N");
            }
            cst.setString(8, (String)this.session.getAttribute("ClaimNo"));
            cst.setBigDecimal(9,
                              (BigDecimal)this.session.getAttribute("PCT_CODE"));
            if (this.xgratiaSA.getValue() == null) {
                cst.setString(10, null);
            } else {
                cst.setString(10, this.xgratiaSA.getValue().toString());
            }
            if (this.xgratiaEarningsAmt.getValue() == null) {
                cst.setString(11, null);
            } else {
                cst.setString(11,
                              this.xgratiaEarningsAmt.getValue().toString());
            }
            if (this.xgratiaEarningsPrd.getValue() == null) {
                cst.setString(12, null);
            } else {
                cst.setString(12,
                              this.xgratiaEarningsPrd.getValue().toString());
            }
            cst.execute();
            cst.close();
            this.session.setAttribute("CoverTypeCode", null);

            GlobalCC.INFORMATIONREPORTING("Cover Successfully Updated");

            GlobalCC.hidePopup("lmsgroup:editMultiCover");
            ADFUtils.findIterator("FindMultiClaimCoverTypesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.coversLOV);

            ADFUtils.findIterator("FindMultiClaimsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.mutipleClaimsLOV);
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
        return null;
    }

    public String processMultiClaimsVouchers() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        boolean MakeCall = false;
        CallableStatement cst = null;
        try {
            List ReinstInfo = new LinkedList();
            ARRAY array = null;

            ArrayDescriptor descriptor =
                ArrayDescriptor.createDescriptor("LMS_CLAIM_COVERTYPES_TAB",
                                                 conn);


            int rowCount = 0;
            boolean Value = false;
            rowCount = this.coversLOV.getRowCount();
            if (rowCount == 0) {
                return null;
            }
            JUCtrlValueBinding nodeBinding;
            for (int i = 0; i < rowCount; i++) {
                this.coversLOV.setRowIndex(i);
                nodeBinding = (JUCtrlValueBinding)this.coversLOV.getRowData();
                if (nodeBinding != null) {
                    Value =
                            ((Boolean)nodeBinding.getAttribute("selected")).booleanValue();
                    if (Value == true) {
                        MakeCall = true;

                        ClaimCovers pn = new ClaimCovers();
                        pn.setCCVT_CODE((BigDecimal)nodeBinding.getAttribute("CCVT_CODE"));

                        ReinstInfo.add(pn);
                    }
                }
            }
            if (MakeCall == true) {
                array = new ARRAY(descriptor, conn, ReinstInfo.toArray());

                String AddClaim =
                    "begin LMS_WEB_CLAIMS_PKG.process_multi_vouchers(?,?,?,?);end;";


                cst = conn.prepareCall(AddClaim);

                cst.setString(1, (String)this.session.getAttribute("ClaimNo"));

                cst.setString(2,
                              (String)this.session.getAttribute("Username"));


                cst.setBigDecimal(3,
                                  (BigDecimal)this.session.getAttribute("clmbatchNo"));


                cst.setArray(4, array);
                cst.execute();
                cst.close();
                conn.close();
                GlobalCC.INFORMATIONREPORTING("Vouchers generated successfully");
            } else {
                GlobalCC.sysInformation("Select A Cover Type");
                return null;
            }
            String AddClaim;
            ADFUtils.findIterator("FindMultiClaimCoverTypesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.coversLOV);

            ADFUtils.findIterator("FindClaimCoinsuranceRecoveriesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.claimRecoveries);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
            e.printStackTrace();
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
        return null;
    }

    public String viewMultiPaymentVouch() {
        try {
            GlobalCC.RedirectPage("/g_multiclmpym.jspx");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String returnToMultipleClaimsScreen() {
        try {
            GlobalCC.RedirectPage("/g_multiclaims.jspx");
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                          e.getMessage(),
                                                                          e.getMessage()));
        }
        return null;
    }

    public String editMultipleVouchers() {
        this.session.setAttribute("voucherNumber", null);
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findMultipleClaimVouchersIterator");


            RowKeySet set = this.claimVouchers.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                this.session.setAttribute("voucherNumber",
                                          r.getAttribute("cpvVouvherNo"));


                System.out.println("voucherNumber" +
                                   this.session.getAttribute("voucherNumber"));


                this.voucherLabel.setValue(r.getAttribute("cpvVouvherNo"));
                this.payeeTF.setValue(r.getAttribute("cpvPayee"));
                this.dispStatus.setValue(r.getAttribute("CPV_DISCHARGE_STATUS"));

                ExtendedRenderKitService erkService =
                    (ExtendedRenderKitService)Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                                                 ExtendedRenderKitService.class);


                erkService.addScript(FacesContext.getCurrentInstance(),
                                     "var hints = {autodismissNever:false}; AdfPage.PAGE.findComponent('lmsgroup:p1').show(hints);");
            }
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
            e.printStackTrace();
        }
        return null;
    }

    public String UpdateMultipleVoucherStatus() {
        CallableStatement cst = null;
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        try {
            if (this.dispStatus.getValue() == null) {
                String Message = "Select a Dispatch Status";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));
            }
            String AddClaim =
                "begin LMS_WEB_CLAIMS_PKG.update_voucher_status(?,?);end;";


            cst = conn.prepareCall(AddClaim);
            cst.setBigDecimal(1,
                              (BigDecimal)this.session.getAttribute("voucherNumber"));


            cst.setString(2, this.dispStatus.getValue().toString());

            cst.execute();
            cst.close();
            ADFUtils.findIterator("findMultipleClaimVouchersIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.claimVouchers);

            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
        return null;
    }

    public String makeReadyMulti() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        try {
            this.session.setAttribute("voucherNumber", null);
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findMultipleClaimVouchersIterator");


            RowKeySet set = this.claimVouchers.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();
            Key key;
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));

                Row r = dciter.getCurrentRow();

                this.session.setAttribute("voucherNumber",
                                          r.getAttribute("cpvVouvherNo"));


                String Status = (String)r.getAttribute("CPV_DISCHARGE_STATUS");
                if (Status == null) {
                    GlobalCC.sysInformation("Enter A Dispatch Status");
                    return null;
                }
                if (Status.equalsIgnoreCase("REJ")) {
                    this.session.setAttribute("ClientAccept", "Reject");
                } else {
                    this.session.setAttribute("ClientAccept", "Accept");
                }
                String AddClaim =
                    "begin LMS_WEB_CLAIMS_PKG.make_voucher_ready(?);end;";


                cst = conn.prepareCall(AddClaim);
                cst.setBigDecimal(1,
                                  (BigDecimal)this.session.getAttribute("voucherNumber"));


                cst.execute();
                cst.close();
            }
            if (this.session.getAttribute("voucherNumber") == null) {
                GlobalCC.INFORMATIONREPORTING("Select A Voucher.");
                return null;
            }
            ADFUtils.findIterator("findMultipleClaimVouchersIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.claimVouchers);

            conn.close();

            String Message = "Voucher Made Ready";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
        return null;
    }

    public String UpdateMultipleClientFeedBack() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        String Status = null;
        try {
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findMultipleClaimVouchersIterator");


            RowKeySet set = this.claimVouchers.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));

                Row r = dciter.getCurrentRow();

                this.session.setAttribute("voucherNumber",
                                          r.getAttribute("cpvVouvherNo"));


                Status = (String)r.getAttribute("CPV_DISCHARGE_STATUS");
                String AddClaim =
                    "begin LMS_WEB_CLAIMS_PKG.update_client_feedback(?);end;";


                cst = conn.prepareCall(AddClaim);
                cst.setBigDecimal(1,
                                  (BigDecimal)this.session.getAttribute("voucherNumber"));


                cst.execute();
                cst.close();
            }
            String Message = "Client FeedBack Captured.";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
        return null;
    }

    public String authorizeMultiVoucher() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        CallableStatement mySt = null;
        String TransCode = null;
        try {
            String authorizeVoucher =
                "begin LMS_WEB_PKG_CLM.Clmauthvchr(?,?); end;";


            cst = conn.prepareCall(authorizeVoucher);
            this.session.setAttribute("voucherNumber", null);
            DCIteratorBinding dciter =
                ADFUtils.findIterator("findMultipleClaimVouchersIterator");


            RowKeySet set = this.claimVouchers.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();

            conn.prepareCall(authorizeVoucher);
            Key key;
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));

                Row r = dciter.getCurrentRow();
                TransCode = (String)r.getAttribute("cpv_ltr_btr_trans_code");

                this.session.setAttribute("voucherNumber",
                                          r.getAttribute("cpvVouvherNo"));


                cst.setBigDecimal(1,
                                  (BigDecimal)this.session.getAttribute("voucherNumber"));


                cst.setInt(2, 27);

                cst.execute();
            }
            if (this.session.getAttribute("voucherNumber") == null) {
                GlobalCC.INFORMATIONREPORTING("Select A Voucher");
                return null;
            }
            cst.close();
            conn.commit();

            String authorizeAnnuities =
                "begin LMS_WEB_CLAIMS_PKG.update_ann_voucher_status(?); end;";


            mySt = conn.prepareCall(authorizeAnnuities);
            mySt.setBigDecimal(1,
                               (BigDecimal)this.session.getAttribute("voucherNumber"));


            mySt.execute();
            mySt.close();

            conn.close();

            ADFUtils.findIterator("findMultipleClaimVouchDtlsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.voucherDetails);
            ADFUtils.findIterator("findMultipleClaimVouchersIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.claimVouchers);
            ADFUtils.findIterator("findClaimVchrpartRIIterator").executeQuery();
            ADFUtils.findIterator("findClaimVchrtrtRIIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.groupLifeRI);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.participantsRI);

            String prodTy = (String)this.session.getAttribute("productType");
            if (prodTy == null) {
                this.session.setAttribute("VoucherDecision", "No");
            } else if (prodTy.equalsIgnoreCase("EDUC")) {
                ADFUtils.findIterator("findClaimBeneficaryPaymentsIterator").executeQuery();
            } else if (prodTy.equalsIgnoreCase("ANN")) {
                ADFUtils.findIterator("findClaimAnnBeneficaryPaymentsIterator").executeQuery();
            } else if (prodTy.equalsIgnoreCase("EARN")) {
                ADFUtils.findIterator("FindClaimCoverTypesIterator").executeQuery();
                ADFUtils.findIterator("findClaimVouchersIterator").executeQuery();
                if ((TransCode != null) &&
                    (TransCode.equalsIgnoreCase("CO"))) {
                    this.session.setAttribute("VoucherDecision", "No");
                }
            } else {
                this.session.setAttribute("VoucherDecision", "No");
            }
            String Message = "Voucher Authorisation Completed";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
        return null;
    }

    public void claimsTypeListener(ValueChangeEvent valueChangeEvent) {
        try {
            if (valueChangeEvent.getOldValue() !=
                valueChangeEvent.getNewValue()) {
                RowKeySet rowKeySet =
                    this.mutipleClaimsLOV.getSelectedRowKeys();
                if (rowKeySet == null) {
                    return;
                }
                if (!rowKeySet.iterator().hasNext()) {
                    GlobalCC.errorValueNotEntered("No Record Selected");
                    return;
                }
                Object key2 = rowKeySet.iterator().next();
                this.mutipleClaimsLOV.setRowKey(key2);
                JUCtrlValueBinding nodeBinding =
                    (JUCtrlValueBinding)this.mutipleClaimsLOV.getRowData();
                if (nodeBinding == null) {
                    GlobalCC.errorValueNotEntered("No Record Selected");
                    return;
                }
                if (this.claimsCheckBox.isSelected()) {
                    nodeBinding.setAttribute("selected",
                                             Boolean.valueOf(true));
                } else {
                    nodeBinding.setAttribute("selected",
                                             Boolean.valueOf(false));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void setClaimsCheckBox(RichSelectBooleanCheckbox claimsCheckBox) {
        this.claimsCheckBox = claimsCheckBox;
    }

    public RichSelectBooleanCheckbox getClaimsCheckBox() {
        return this.claimsCheckBox;
    }

    public void determinePaymentSelected(ValueChangeEvent valueChangeEvent) {
        if (this.paymentModeCombo.getValue().toString().equalsIgnoreCase("EFT")) {
            GlobalCC.showPopup("pt1:eft_details");
        }
    }

    public void setPaymentModeCombo(RichSelectOneChoice paymentModeCombo) {
        this.paymentModeCombo = paymentModeCombo;
    }

    public RichSelectOneChoice getPaymentModeCombo() {
        return this.paymentModeCombo;
    }

    public void setClientBankLOV(RichTable clientBankLOV) {
        this.clientBankLOV = clientBankLOV;
    }

    public RichTable getClientBankLOV() {
        return this.clientBankLOV;
    }

    public void setBankName(RichInputText bankName) {
        this.bankName = bankName;
    }

    public RichInputText getBankName() {
        return this.bankName;
    }

    public void setBankAccountNo(RichInputText bankAccountNo) {
        this.bankAccountNo = bankAccountNo;
    }

    public RichInputText getBankAccountNo() {
        return this.bankAccountNo;
    }

    public String selectBankAction() {
        Connection conn = null;
        CallableStatement cst = null;
        try {
            DBConnector myConn = new DBConnector();
            conn = myConn.getDatabaseConn();
            String updatePaymentVoucher =
                "begin LMS_WEB_CLAIMS_PKG.update_voucher_pymt_method(?,?,?,?);end;";


            cst = conn.prepareCall(updatePaymentVoucher);

            DCIteratorBinding dciter =
                ADFUtils.findIterator("FindClientBankDetailsIterator");


            RowKeySet set = this.clientBankLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();
                this.bank_display.setValue(r.getAttribute("BBR_BRANCH_NAME"));

                cst.setBigDecimal(1,
                                  (BigDecimal)this.session.getAttribute("voucherNumber"));
                if (this.paymentMode.getValue() == null) {
                    GlobalCC.INFORMATIONREPORTING("Payment mode not selected");
                } else {
                    cst.setString(2, this.paymentMode.getValue().toString());
                }
                cst.setBigDecimal(3, (BigDecimal)r.getAttribute("BBR_CODE"));
                if (this.clientACCNo.getValue() == null) {
                    GlobalCC.INFORMATIONREPORTING("Client Acc No not Specified");
                } else {
                    cst.setString(4, this.clientACCNo.getValue().toString());
                }
                cst.execute();
            }
            cst.close();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
        return null;
    }

    public void setAddEFTDetails(RichCommandButton addEFTDetails) {
        this.addEFTDetails = addEFTDetails;
    }

    public RichCommandButton getAddEFTDetails() {
        return this.addEFTDetails;
    }

    public String saveEFTAction() {
        if (this.bankAccountNo.getValue() == null) {
            GlobalCC.INFORMATIONREPORTING("Please provide the account number");
        } else {
            this.session.setAttribute("client_bank_name",
                                      this.bankAccountNo.getValue());
        }
        return null;
    }

    public String populateCoverAction() {
        try {
            String selectedClaims = "";

            boolean MakeCall = false;

            int rowCount = 0;
            boolean Value = false;
            rowCount = this.mutipleClaimsLOV.getRowCount();
            if (rowCount == 0) {
                return null;
            }
            for (int i = 0; i < rowCount; i++) {
                this.mutipleClaimsLOV.setRowIndex(i);
                JUCtrlValueBinding nodeBinding =
                    (JUCtrlValueBinding)this.mutipleClaimsLOV.getRowData();
                if (nodeBinding != null) {
                    Value =
                            ((Boolean)nodeBinding.getAttribute("selected")).booleanValue();
                    if (Value == true) {
                        MakeCall = true;

                        selectedClaims =
                                selectedClaims + nodeBinding.getAttribute("CLM_NO") +
                                ",";
                    }
                }
            }
            selectedClaims =
                    selectedClaims.substring(0, selectedClaims.length() - 1);


            System.out.println("selectedClaims " + selectedClaims);

            this.session.setAttribute("multiple_claims", selectedClaims);

            ADFUtils.findIterator("FindMultiClaimCoverTypesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.coversLOV);

            ADFUtils.findIterator("findClaimBeneficaryPaymentsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.beneficaryPayments);

            ADFUtils.findIterator("FindClaimCoinsuranceRecoveriesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.claimRecoveries);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public void setPaymentMode(RichSelectOneChoice paymentMode) {
        this.paymentMode = paymentMode;
    }

    public RichSelectOneChoice getPaymentMode() {
        return this.paymentMode;
    }

    public void setClientACCNo(RichInputText clientACCNo) {
        this.clientACCNo = clientACCNo;
    }

    public RichInputText getClientACCNo() {
        return this.clientACCNo;
    }

    public String deleteMultiMember() {
        Connection conn = null;
        CallableStatement cst = null;
        try {
            DBConnector myConn = new DBConnector();
            conn = myConn.getDatabaseConn();

            DCIteratorBinding dciter =
                ADFUtils.findIterator("FindMultipleClaimsMemIterator");


            RowKeySet set = this.multipleMemLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();

                String updatePaymentVoucher =
                    "begin LMS_WEB_CLAIMS_PKG.delete_member_multi_clm(?);end;";


                cst = conn.prepareCall(updatePaymentVoucher);
                cst.setBigDecimal(1, (BigDecimal)r.getAttribute("MCLM_CODE"));
                cst.execute();
                cst.close();

                ADFUtils.findIterator("FindMultipleClaimsMemIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.multipleMemLOV);
                GlobalCC.INFORMATIONREPORTING("member removed successfully ");
            }
        } catch (Exception e) {
            e = e;
            e = e;
            GlobalCC.EXCEPTIONREPORTING(null, e);
            e.printStackTrace();
        } finally {
        }
        return null;
    }

    public String AuthoriseMultiClaim() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        try {
            String AddClaim =
                "begin LMS_WEB_CLAIMS_PKG.CLOSE_MULTI_AUTH_CLAIM(?,?);end;";


            cst = conn.prepareCall(AddClaim);
            cst.setString(1, (String)this.session.getAttribute("ClaimNo"));
            cst.setBigDecimal(2,
                              (BigDecimal)this.session.getAttribute("clmbatchNo"));


            cst.execute();
            cst.close();
            conn.close();

            ADFUtils.findIterator("FindMultiClaimsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.mutipleClaimsLOV);

            GlobalCC.INFORMATIONREPORTING("Claim Authorised");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
        return null;
    }

    public void setBank_display(RichInputText bank_display) {
        this.bank_display = bank_display;
    }

    public RichInputText getBank_display() {
        return this.bank_display;
    }

    public void setClm_pymnt_inst(RichInputText clm_pymnt_inst) {
        this.clm_pymnt_inst = clm_pymnt_inst;
    }

    public RichInputText getClm_pymnt_inst() {
        return this.clm_pymnt_inst;
    }

    public void setActualSavingsTF(RichInputText actualSavingsTF) {
        this.actualSavingsTF = actualSavingsTF;
    }

    public RichInputText getActualSavingsTF() {
        return this.actualSavingsTF;
    }

    public void setPayInstLab(RichOutputLabel payInstLab) {
        this.payInstLab = payInstLab;
    }

    public RichOutputLabel getPayInstLab() {
        return this.payInstLab;
    }

    public void setActualSavLab(RichOutputLabel actualSavLab) {
        this.actualSavLab = actualSavLab;
    }

    public RichOutputLabel getActualSavLab() {
        return this.actualSavLab;
    }

    public void setOccBenLab(RichOutputLabel occBenLab) {
        this.occBenLab = occBenLab;
    }

    public RichOutputLabel getOccBenLab() {
        return this.occBenLab;
    }

    public void setOccBenTF(RichInputText occBenTF) {
        this.occBenTF = occBenTF;
    }

    public RichInputText getOccBenTF() {
        return this.occBenTF;
    }

    public void setClmPayInst(RichSelectOneChoice clmPayInst) {
        this.clmPayInst = clmPayInst;
    }

    public RichSelectOneChoice getClmPayInst() {
        return this.clmPayInst;
    }

    public void setClmInstNo(RichInputText clmInstNo) {
        this.clmInstNo = clmInstNo;
    }

    public RichInputText getClmInstNo() {
        return this.clmInstNo;
    }

    public void setClm_pay_freq(RichSelectOneChoice clm_pay_freq) {
        this.clm_pay_freq = clm_pay_freq;
    }

    public RichSelectOneChoice getClm_pay_freq() {
        return this.clm_pay_freq;
    }

    public String payClaimInstalment() {
        Connection conn = null;
        CallableStatement cst = null;
        String Query =
            "begin LMS_WEB_CLAIMS_PKG.processClmPayInst(?,?,?,?); end;";
        try {
            DBConnector datahandler = new DBConnector();

            conn = datahandler.getDatabaseConn();

            String Rights = null;
            this.session.setAttribute("ProcessShtDesc", "CLMS");
            this.session.setAttribute("ProcessAreaShtDesc", "VCHR");
            this.session.setAttribute("ProcessSubAShtDesc", "CLMR");
            workflowProcessing wf = new workflowProcessing();
            Rights = wf.CheckUserRights();
            if (Rights.equalsIgnoreCase("N")) {
                String Message =
                    "You do not have rights to Perform this Task.";


                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));


                return null;
            }
            String NextUser = null;
            this.session.setAttribute("ProcessShtDesc", "CLMS");
            this.session.setAttribute("ProcessAreaShtDesc", "VCHR");
            this.session.setAttribute("ProcessSubAShtDesc", "CLMR");
            this.session.setAttribute("TaskAssignee", null);
            this.session.setAttribute("NextTaskAssignee", "N");
            ADFUtils.findIterator("findTicketAssigneeIterator").executeQuery();
            NextUser = (String)this.session.getAttribute("NextTaskAssignee");
            String TaskAss = (String)this.session.getAttribute("TaskAssignee");
            if ((TaskAss == null) && (NextUser.equalsIgnoreCase("N"))) {
                String Message =
                    "There is no User to Assign the Next Task. Consult the Administrator.";


                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));


                return null;
            }
            String Taske = (String)this.session.getAttribute("TaskID");
            if (Taske == null) {
                String Message = "No Task Selected";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));


                return null;
            }
            Taske = (String)this.session.getAttribute("TaskID");
            if (Taske != null) {
                String MyTask = null;
                CallableStatement cst3 = null;
                String Complete =
                    "BEGIN TQC_WEB_PKG.check_task_completion(?,?,?,?);END;";


                cst3 = conn.prepareCall(Complete);
                cst3.setString(1, "CLMVCHR");
                cst3.setString(2, (String)this.session.getAttribute("TaskID"));
                cst3.setInt(3,
                            ((Integer)this.session.getAttribute("sysCode")).intValue());

                cst3.registerOutParameter(4, 12);
                cst3.execute();
                MyTask = cst3.getString(4);
                cst3.close();
                if (MyTask.equalsIgnoreCase("N")) {
                    String Message =
                        "the Task Selected Does not Correspond to the Activity being Performed. Cannot Complete please " +
                        this.session.getAttribute("TaskActivityName");


                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                  Message,
                                                                                  Message));


                    return null;
                }
            }
            cst = conn.prepareCall(Query);

            int i = 0;

            DCIteratorBinding dciter =
                ADFUtils.findIterator("FindClaimInstDetailsIterator");


            RowKeySet set = this.instLOV.getSelectedRowKeys();
            Iterator rowKeySetIter = set.iterator();
            Row r;
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                r = dciter.getCurrentRow();

                cst.setString(1, (String)this.session.getAttribute("ClaimNo"));
                cst.setBigDecimal(2, (BigDecimal)r.getAttribute("cipgCode"));
                cst.setBigDecimal(3,
                                  (BigDecimal)this.session.getAttribute("policyCode"));


                cst.setBigDecimal(4,
                                  (BigDecimal)this.session.getAttribute("ClaimTransNo"));


                cst.execute();
                i++;
            }
            cst.close();
            conn.close();
            this.session.setAttribute("ProcessAreaShtDesc", "VCHR");
            this.session.setAttribute("ProcessSubAShtDesc", "CLMR");
            Rights = wf.CheckUserRights();
            String str5;
            if (Rights.equalsIgnoreCase("N")) {
                this.session.setAttribute("TaskAssignee", null);
                ADFUtils.findIterator("findTicketAssigneeIterator").executeQuery();
                TaskAss = (String)this.session.getAttribute("TaskAssignee");
                if (TaskAss == null) {
                    GetAssignee();
                    return null;
                }
                this.session.setAttribute("TicketRemarks", null);
                wf.CompleteTask();
                String Message =
                    "Current Task Complete. The Next Task " + (String)this.session.getAttribute("TaskActivityName") +
                    " has been Successfully assigned to " +
                    (String)this.session.getAttribute("TaskAssignee");


                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));


                this.session.setAttribute("TaskID", null);
                return null;
            }
            wf.CompleteTask();
            if (i > 0) {
                GlobalCC.RedirectPage("/g_clmpym.jspx");
            }
            String Message = "Voucher Processing Completed";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));


            return null;
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
        return null;
    }

    public void setInstLOV(RichTable instLOV) {
        this.instLOV = instLOV;
    }

    public RichTable getInstLOV() {
        return this.instLOV;
    }

    public String addRequiredDoc() {
        Connection conn = null;
        CallableStatement cst = null;
        try {
            DBConnector myConn = new DBConnector();
            conn = myConn.getDatabaseConn();

            String popReqDoc =
                "begin LMS_WEB_CLAIMS_PKG.addClmReqDocs(?,?,?,?,?,?);end;";


            cst = conn.prepareCall(popReqDoc);
            cst.setBigDecimal(1, null);
            cst.setString(2, (String)this.docName.getValue());
            cst.setString(3, (String)this.session.getAttribute("ClaimNo"));
            cst.setString(4, (String)this.docSubmitted.getValue());
            cst.setString(5,
                          GlobalCC.parseDate(this.docDateSubmitted.getValue().toString()));

            cst.setString(6, (String)this.docNo.getValue());
            cst.execute();
            cst.close();
            conn.close();

            ADFUtils.findIterator("FindClaimDocumentsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.docsLOV);
            GlobalCC.INFORMATIONREPORTING("Document added successfully ");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
            e.printStackTrace();
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
        return null;
    }

    public void setRequiredDocsLOV(RichTable requiredDocsLOV) {
        this.requiredDocsLOV = requiredDocsLOV;
    }

    public RichTable getRequiredDocsLOV() {
        return this.requiredDocsLOV;
    }

    public void setClmReqDoc(RichTable clmReqDoc) {
        this.clmReqDoc = clmReqDoc;
    }

    public RichTable getClmReqDoc() {
        return this.clmReqDoc;
    }

    public void setDocName(RichInputText docName) {
        this.docName = docName;
    }

    public RichInputText getDocName() {
        return this.docName;
    }

    public void setDocSubmitted(RichSelectOneChoice docSubmitted) {
        this.docSubmitted = docSubmitted;
    }

    public RichSelectOneChoice getDocSubmitted() {
        return this.docSubmitted;
    }

    public void setDocDateSubmitted(RichInputDate docDateSubmitted) {
        this.docDateSubmitted = docDateSubmitted;
    }

    public RichInputDate getDocDateSubmitted() {
        return this.docDateSubmitted;
    }

    public void setDocumentNo(RichInputText documentNo) {
        this.documentNo = documentNo;
    }

    public RichInputText getDocumentNo() {
        return this.documentNo;
    }

    public String showAddReqDocsPop() {
        this.docName.setValue(null);
        this.docDateSubmitted.setValue(null);
        this.documentNo.setValue(null);
        this.docSubmitted.setValue(null);
        GlobalCC.showPopup("lmsgroup:p6");
        return null;
    }

    public int getUnpaidInstallment() {
        Connection conn = null;
        CallableStatement cst = null;
        int unpaidCount = 0;
        try {
            DBConnector myConn = new DBConnector();
            conn = myConn.getDatabaseConn();

            String unpaidInstCount =
                "begin ? :=LMS_WEB_CLAIMS_PKG.getUnsettledInstalments(?); end;";

            cst = conn.prepareCall(unpaidInstCount);
            cst.registerOutParameter(1, 4);
            cst.setString(2, (String)this.session.getAttribute("ClaimNo"));
            cst.execute();
            unpaidCount = cst.getInt(1);
            cst.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
            e.printStackTrace();
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
        return unpaidCount;
    }

    public void setSrchMemName(RichInputText srchMemName) {
        this.srchMemName = srchMemName;
    }

    public RichInputText getSrchMemName() {
        return this.srchMemName;
    }

    public void setSrchMemNo(RichInputText srchMemNo) {
        this.srchMemNo = srchMemNo;
    }

    public RichInputText getSrchMemNo() {
        return this.srchMemNo;
    }

    public String test() {
        return null;
    }

    public void setDmsDocTab(RichShowDetailItem dmsDocTab) {
        this.dmsDocTab = dmsDocTab;
    }

    public RichShowDetailItem getDmsDocTab() {
        return this.dmsDocTab;
    }

    public String newDmsDoc() {
        this.session.setAttribute("docType", "POLDOC");


        ADFUtils.findIterator("FindOccupationIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.lmsDocType);

        GlobalCC.showPopup("lmsgroup:dmsUpdPop");

        return null;
    }

    public String refreshDms() {
        return null;
    }

    public void setDmsDocTable(RichTable dmsDocTable) {
        this.dmsDocTable = dmsDocTable;
    }

    public RichTable getDmsDocTable() {
        return this.dmsDocTable;
    }

    public String generateDoc() {
        this.session.setAttribute("toPrint", null);
        Object key2 = this.dmsDocTable.getSelectedRowData();
        JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
        if (r == null) {
            GlobalCC.errorValueNotEntered("No Record Selected");
            return null;
        }
        String filename = (String)r.getAttribute("actualName");
        String id = (String)r.getAttribute("id");
        EcmUtil ecmUtil = new EcmUtil();
        try {
            Session sessions = ecmUtil.Authentification();

            Document document = (Document)sessions.getObject(id);
            InputStream inputStream = document.getContentStream().getStream();
            String file = "/Reports/" + filename;
            FacesContext context = FacesContext.getCurrentInstance();
            ServletContext sc =
                (ServletContext)context.getExternalContext().getContext();

            file = sc.getRealPath(file);
            System.out.println("The file name is  " + file);
            File toPrint = new File(file);


            OutputStream out = new FileOutputStream(toPrint);
            int read = 0;
            byte[] bytes = new byte[20480];
            while ((read = inputStream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            inputStream.close();
            out.flush();
            out.close();
            if (toPrint != null) {
                HttpServletRequest request =
                    (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();

                String scheme = request.getScheme();
                String serverName = request.getServerName();
                int portNumber = request.getServerPort();
                String contextPath = request.getContextPath();
                String url =
                    scheme + "://" + serverName + ":" + portNumber + contextPath +
                    "/viewer.html";


                String pdf =
                    "?file=" + scheme + "://" + serverName + ":" + portNumber +
                    contextPath + "/Reports/" + filename;


                System.out.println("The url " + url);
                System.out.println("The url " + pdf);
                this.session.setAttribute("toPrint", url + pdf);
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.docViewer);
                GlobalCC.showPopup("lmsgroup:viewdoc");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String updateClaimDocDms() {
        String docid = (String)this.session.getAttribute("docId");
        EcmUtil ecmUtil = new EcmUtil();
        if (docid != null) {
            Session ecmSession = ecmUtil.Authentification();
            if (ecmSession != null) {
                Document document = (Document)ecmSession.getObject(docid);
                AlfrescoDocument alfDoc = (AlfrescoDocument)document;
                String aspectname = "P:tqlms:grpclaimData";
                alfDoc.addAspect(new String[] { aspectname });
                Map<String, Object> properties = new HashMap();

                properties.put("tqlms:grpclmClaimNo",
                               this.session.getAttribute("dmsClmNo"));

                properties.put("tqlms:grpclmMemberName",
                               this.session.getAttribute("dmsClmMem"));

                properties.put("tqlms:grpclmPolicyNumber",
                               this.session.getAttribute("dmsPolNo"));

                properties.put("tqlms:grpclmclientname",
                               this.session.getAttribute("polClient"));

                properties.put("tqlms:grpclmMemberNumber",
                               this.session.getAttribute("dmsClmMemNo"));

                properties.put("tqlms:grpclmdate", null);
                alfDoc.updateProperties(properties);
            }
            ProcessDMSTicket dbConn = new ProcessDMSTicket();
            OracleConnection conn = null;
            conn = dbConn.getDatabaseConnection();
            PreparedStatement stmt = null;

            String query =
                "update lms_dms_documents set dd_processed = 'Y' where dd_doc_id = ?";
            try {
                stmt = conn.prepareStatement(query);
                stmt.setString(1, docid);
                stmt.execute();
                conn.commit();
                conn.close();
                this.session.removeAttribute("dmsDocId");
                this.session.setAttribute("dmsProcess", null);
                this.session.setAttribute("dmsProcessType", "");
                ADFUtils.findIterator("findClaimDocsIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.dmsDocTable);
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.dmsDocTab);

                GlobalCC.sysInformation("Document Updated Successfully!");
            } catch (SQLException e) {
                e.printStackTrace();
                GlobalCC.EXCEPTIONREPORTING(conn, e);
            }
        }
        return null;
    }

    public void docTypeSelectionChanged(ValueChangeEvent valueChangeEvent) {
        try {
            if (valueChangeEvent.getNewValue() !=
                valueChangeEvent.getOldValue()) {
                BigDecimal rdCodeVal = new BigDecimal(0);
                System.out.print("rdCode = ");
                System.out.println(rdCodeVal);
                this.session.setAttribute("rdCode", rdCodeVal);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setDmsFileToUpload(RichInputFile dmsFileToUpload) {
        this.dmsFileToUpload = dmsFileToUpload;
    }

    public RichInputFile getDmsFileToUpload() {
        return this.dmsFileToUpload;
    }

    public String upLoadDocToDms() {
        FacesContext context = FacesContext.getCurrentInstance();

        ServletContext sc =
            (ServletContext)context.getExternalContext().getContext();

        UploadedFile newFile = (UploadedFile)this.dmsFileToUpload.getValue();
        if (this.session.getAttribute("rdCode") == null) {
            GlobalCC.errorValueNotEntered("Please select the document type being uploaded");
            return null;
        }
        BigDecimal rdCode = (BigDecimal)this.session.getAttribute("rdCode");

        EcmUtil ecmUtil = new EcmUtil();
        String fileName = newFile.getFilename();
        try {
            String file = "/Reports/" + fileName;

            file = sc.getRealPath(file);
            File toUpload = new File(file);
            InputStream inputStream = newFile.getInputStream();

            OutputStream out = new FileOutputStream(toUpload);
            int read = 0;

            byte[] bytes = new byte[1024];
            while ((read = inputStream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            inputStream.close();
            out.flush();
            out.close();

            String mimetype = newFile.getContentType();
            String aspect =
                "D:tqlms:GrpClaimDocumentType, P:tqlms:grpclaimData";

            String memName = (String)this.session.getAttribute("dmsClmMem");
            String memNo = (String)this.session.getAttribute("dmsClmMemNo");
            String clmNo = (String)this.session.getAttribute("dmsClmNo");
            String clmDate = (String)this.session.getAttribute("dmsClmDate");
            String polNo = (String)this.session.getAttribute("dmsPolNo");
            String clnName = (String)this.session.getAttribute("polClient");
            Session ecmSession = ecmUtil.Authentification();
            if (ecmSession == null) {
                GlobalCC.errorValueNotEntered("Please Check alfresco connection : Can't Connect to alfresco!!");
                return null;
            }
            String policyNo = clmNo;
            String policyNo2 = clmNo;
            policyNo = policyNo.replace("/", "_");
            boolean checkLms = ecmUtil.checkDir(ecmSession, "/TQLMSGRP");
            if (!checkLms) {
                ecmUtil.createDirInRootFolder(ecmSession, "TQLMSGRP");
            }
            String filePath = "/TQLMSGRP/CLMS";
            boolean check = ecmUtil.checkDir(ecmSession, filePath);
            if (!check) {
                CmisObject objectLms = ecmSession.getObjectByPath("/TQLMSGRP");
                Folder folderLms = (Folder)objectLms;
                String fpath = "CLMS";
                ecmUtil.createDir(ecmSession, folderLms, fpath);
            }
            filePath = filePath + "/" + policyNo;
            boolean check1 = ecmUtil.checkDir(ecmSession, filePath);
            if (!check1) {
                CmisObject objectPolAuth =
                    ecmSession.getObjectByPath("/TQLMSGRP/CLMS");

                Folder folderLms = (Folder)objectPolAuth;
                String fpath = policyNo;
                ecmUtil.createDir(ecmSession, folderLms, fpath);
            }
            CmisObject object = ecmSession.getObjectByPath(filePath);
            Folder folder = (Folder)object;

            fileName = filePath + "/" + fileName;
            List<EcmProps> properties = new ArrayList();
            properties.add(new EcmProps("tqlms:grpclmMemberName", memName));
            properties.add(new EcmProps("tqlms:grpclmClaimNo", policyNo2));
            properties.add(new EcmProps("tqlms:grpclmPolicyNumber", polNo));
            properties.add(new EcmProps("tqlms:grpclmclientname", clnName));
            properties.add(new EcmProps("tqlms:grpclmMemberNumber", memNo));
            try {
                EcmTrans.UploadFile(ecmSession, folder, toUpload.getName(),
                                    toUpload, mimetype, aspect, properties);
            } catch (Exception e) {
                GlobalCC.hidePopup("lmsgroup:dmsUpdPop");
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.dmsFileToUpload);
                e.printStackTrace();
                GlobalCC.alfrescoError(e);
                return null;
            }
            this.dmsFileToUpload.setValue(null);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.dmsFileToUpload);
            ADFUtils.findIterator("findClaimDocsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.dmsDocTable);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.dmsDocTab);

            GlobalCC.hidePopup("lmsgroup:dmsUpdPop");
            GlobalCC.sysInformation("Record Saved Successfully!");
        } catch (NullPointerException e) {
            GlobalCC.hidePopup("lmsgroup:dmsUpdPop");
            this.dmsFileToUpload.setValue(null);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.dmsFileToUpload);
        } catch (Exception e) {
            this.dmsFileToUpload.setValue(null);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.dmsFileToUpload);
            GlobalCC.hidePopup("lmsgroup:dmsUpdPop");
            e.printStackTrace();
        }
        return null;
    }

    public void setLmsDocType(RichSelectOneChoice lmsDocType) {
        this.lmsDocType = lmsDocType;
    }

    public RichSelectOneChoice getLmsDocType() {
        return this.lmsDocType;
    }

    public void setViewPop(RichInlineFrame viewPop) {
        this.viewPop = viewPop;
    }

    public RichInlineFrame getViewPop() {
        return this.viewPop;
    }

    public void setDaysHospitalized(RichInputText daysHospitalized) {
        this.daysHospitalized = daysHospitalized;
    }

    public RichInputText getDaysHospitalized() {
        return this.daysHospitalized;
    }

    public void setDocViewer(RichInlineFrame docViewer) {
        this.docViewer = docViewer;
    }

    public RichInlineFrame getDocViewer() {
        return this.docViewer;
    }

    public void setPensButPayAmt(RichInputText pensButPayAmt) {
        this.pensButPayAmt = pensButPayAmt;
    }

    public RichInputText getPensButPayAmt() {
        return this.pensButPayAmt;
    }

    public void setRemarksType(RichSelectOneChoice remarksType) {
        this.remarksType = remarksType;
    }

    public RichSelectOneChoice getRemarksType() {
        return this.remarksType;
    }

    public void setRemarksTextArea(RichInputText remarksTextArea) {
        this.remarksTextArea = remarksTextArea;
    }

    public RichInputText getRemarksTextArea() {
        return this.remarksTextArea;
    }

    public String addRemarks() {
        Connection conn = null;
        if (this.remarksTextArea.getValue() == null) {
            GlobalCC.INFORMATIONREPORTING("No remarks set.....");
            return null;
        }
        if (this.remarksType.getValue() == null) {
            GlobalCC.INFORMATIONREPORTING("Remark Type Not Set");
            return null;
        }
        try {
            DBConnector MyDB = new DBConnector();
            conn = MyDB.getDatabaseConn();
            CallableStatement cst =
                conn.prepareCall("BEGIN lms_web_pkg_grp.updateClmremarks(?,?,?,?,?,?);END;");

            cst.setString(1, (String)this.session.getAttribute("dmsClmNo"));
            cst.setBigDecimal(2,
                              (BigDecimal)this.session.getAttribute("policyCode"));

            cst.setBigDecimal(3,
                              (BigDecimal)this.session.getAttribute("endorsementCode"));

            cst.setBigDecimal(4,
                              (BigDecimal)this.session.getAttribute("crmCode"));
            cst.setString(5, (String)this.remarksType.getValue());
            cst.setString(6, (String)this.remarksTextArea.getValue());
            cst.execute();
            cst.close();
            conn.close();

            ADFUtils.findIterator("FindClaimRemarksIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.remarksLOV);
        } catch (Exception Ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, Ex);
            Ex.printStackTrace();
        }
        return null;
    }

    public String showRemarksPopup() {
        this.session.setAttribute("crmCode", null);
        this.remarksType.setValue("O");
        this.remarksTextArea.setValue(null);
        GlobalCC.showPopup("lmsgroup:remarks");
        return null;
    }

    public String editRemarks() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindClaimRemarksIterator");

        RowKeySet set = this.remarksLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();
            this.session.setAttribute("crmCode", r.getAttribute("CRM_CODE"));
            this.remarksType.setValue(r.getAttribute("CRM_REMARK_TYPE"));
            this.remarksTextArea.setValue(r.getAttribute("CRM_REMARKS"));
        }
        GlobalCC.showPopup("lmsgroup:remarks");
        return null;
    }

    public String deleteRemarks() {
        Connection conn = null;
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindClaimRemarksIterator");

        RowKeySet set = this.remarksLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        try {
            DBConnector MyDB = new DBConnector();
            conn = MyDB.getDatabaseConn();
            if (!rowKeySetIter.hasNext()) {
                GlobalCC.INFORMATIONREPORTING("No row Selected...Select a row to proceed");
                return null;
            }
            while (rowKeySetIter.hasNext()) {
                List l = (List)rowKeySetIter.next();
                Key key = (Key)l.get(0);
                dciter.setCurrentRowWithKey(key.toStringFormat(true));
                Row r = dciter.getCurrentRow();
                CallableStatement cst =
                    conn.prepareCall("BEGIN lms_web_pkg_grp.deleteClmremarks(?);END;");

                cst.setBigDecimal(1, (BigDecimal)r.getAttribute("CRM_CODE"));
                cst.execute();
                cst.close();
                conn.close();
                GlobalCC.INFORMATIONREPORTING("Remarks Deleted Successfully");
                ADFUtils.findIterator("FindClaimRemarksIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.remarksLOV);
            }
        } catch (Exception Ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, Ex);
            Ex.printStackTrace();
        }
        return null;
    }

    public void setRemarksLOV(RichTable remarksLOV) {
        this.remarksLOV = remarksLOV;
    }

    public RichTable getRemarksLOV() {
        return this.remarksLOV;
    }

    public void docDateChange(ValueChangeEvent evt) {
        if (evt.getNewValue() != evt.getOldValue()) {
            RichInputDate myInput = (RichInputDate)evt.getComponent();

            Connection conn = null;
            DBConnector MyDB = new DBConnector();
            conn = MyDB.getDatabaseConn();
            CallableStatement lgcallStmt = null;
            String clmprocessiong =
                "begin LMS_WEB_PKG_GRP.Clmdocupdate(?,?,?,?); end;";
            try {
                lgcallStmt = conn.prepareCall(clmprocessiong);
                lgcallStmt.setBigDecimal(1,
                                         new BigDecimal(myInput.getLabel()));

                lgcallStmt.setString(2, null);
                String Date = GlobalCC.checkNullValues(evt.getNewValue());
                if (Date == null) {
                    lgcallStmt.setString(3, null);
                } else if (Date.contains(":")) {
                    Date = GlobalCC.parseDate(Date);
                    lgcallStmt.setString(3, Date);
                } else {
                    Date = GlobalCC.upDateParseDate(Date);
                    lgcallStmt.setString(3, Date);
                }
                lgcallStmt.setString(4, null);
                lgcallStmt.execute();
                lgcallStmt.close();
                conn.close();
            } catch (Exception e) {
                GlobalCC.EXCEPTIONREPORTING(conn, e);
            } finally {
                GlobalCC.CloseConnections(null, lgcallStmt, conn);
            }
        }
    }

    public void docNoChange(ValueChangeEvent evt) {
        if ((evt.getNewValue() != evt.getOldValue()) &&
            (evt.getNewValue() != null)) {
            RichInputText myInput = (RichInputText)evt.getComponent();

            Connection conn = null;
            DBConnector MyDB = new DBConnector();
            conn = MyDB.getDatabaseConn();
            CallableStatement lgcallStmt = null;
            String clmprocessiong =
                "begin LMS_WEB_PKG_GRP.Clmdocupdate(?,?,?,?); end;";
            try {
                lgcallStmt = conn.prepareCall(clmprocessiong);
                lgcallStmt.setBigDecimal(1,
                                         new BigDecimal(myInput.getLabel()));

                lgcallStmt.setString(2, null);
                lgcallStmt.setString(3, null);
                lgcallStmt.setString(4, evt.getNewValue().toString());
                lgcallStmt.execute();
                lgcallStmt.close();
                conn.close();
            } catch (Exception e) {
                GlobalCC.EXCEPTIONREPORTING(conn, e);
            }
        }
    }

    public void isDocumentSubmitted(ValueChangeEvent valueChangeEvent) {
        if ((valueChangeEvent.getNewValue() !=
             valueChangeEvent.getOldValue()) &&
            (valueChangeEvent.getNewValue() != null)) {
            RichSelectOneChoice myInput =
                (RichSelectOneChoice)valueChangeEvent.getComponent();

            Connection conn = null;
            DBConnector MyDB = new DBConnector();
            conn = MyDB.getDatabaseConn();
            CallableStatement lgcallStmt = null;
            String clmprocessiong =
                "begin LMS_WEB_PKG_GRP.Clmdocupdate(?,?,?,?); end;";
            try {
                lgcallStmt = conn.prepareCall(clmprocessiong);

                lgcallStmt.setBigDecimal(1,
                                         new BigDecimal(myInput.getLabel()));

                String docSubmitted =
                    valueChangeEvent.getNewValue().toString();

                docSubmitted = docSubmitted.subSequence(0, 1).toString();
                lgcallStmt.setString(2, docSubmitted);
                lgcallStmt.setString(3, null);
                lgcallStmt.setString(4, null);
                lgcallStmt.execute();
                lgcallStmt.close();
                conn.close();
            } catch (Exception e) {
                GlobalCC.EXCEPTIONREPORTING(conn, e);
            }
        }
    }

    public void setDocSelectOption(RichSelectOneChoice docSelectOption) {
        this.docSelectOption = docSelectOption;
    }

    public RichSelectOneChoice getDocSelectOption() {
        return this.docSelectOption;
    }

    public void setTicketsUserLOV(RichTable ticketsUserLOV) {
        this.ticketsUserLOV = ticketsUserLOV;
    }

    public RichTable getTicketsUserLOV() {
        return this.ticketsUserLOV;
    }

    public void setTcktAsignee(RichInputText tcktAsignee) {
        this.tcktAsignee = tcktAsignee;
    }

    public RichInputText getTcktAsignee() {
        return this.tcktAsignee;
    }

    public String ticketAssignee() {
        Connection conn = new DBConnector().getDatabaseConn();
        CallableStatement cst3 = null;
        CorrespondenceManipulation mail = new CorrespondenceManipulation();
        String priority = (String)session.getAttribute("priorityLevel");
        try {
            Object key2 = this.ticketsUserLOV.getSelectedRowData();
            if (key2 == null) {
                GlobalCC.errorValueNotEntered("No Record Selected");
                return null;
            }
            JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
            if (r == null) {
                GlobalCC.errorValueNotEntered("No Record Selected");
                return null;
            }
            String Remarks = null;
            if (this.tcktAsignee.getValue() != null) {
                Remarks = this.tcktAsignee.getValue().toString();
            }
            String Complete =
                "BEGIN TQC_WEB_PKG.reassign_task(?,?,?,?,?);END;";
            cst3 = conn.prepareCall(Complete);
            cst3.setString(1, (String)this.session.getAttribute("TaskID"));
            cst3.setString(2, (String)r.getAttribute("USR_USERNAME"));
            cst3.setString(3, Remarks);
            cst3.setString(4, null);
            cst3.setString(5, priority);
            cst3.execute();
            cst3.close();
            conn.close();
            GlobalCC.INFORMATIONREPORTING(this.session.getAttribute("TaskActivityName") +
                                          " Ticket Successfully assigned to " +
                                          r.getAttribute("USR_NAME"));


            GlobalCC.hidePopup("lmsgroup:p14");
            mail.ticketAlert((String)this.session.getAttribute("Username"),
                             (String)r.getAttribute("USR_USERNAME"),
                             (String)this.session.getAttribute("TaskActivityName"),
                             Remarks);
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        }
        return null;
    }

    public void payMethod(ValueChangeEvent valueChangeEvent) {
        String payDetails = valueChangeEvent.getNewValue().toString();
        if (payDetails.equalsIgnoreCase("MFT")) {
            ExtendedRenderKitService erkService =
                (ExtendedRenderKitService)Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                                             ExtendedRenderKitService.class);


            erkService.addScript(FacesContext.getCurrentInstance(),
                                 "var hints = {autodismissNever:false}; AdfPage.PAGE.findComponent('lmsgroup:mftpop').show(hints);");
        }
        if ((valueChangeEvent.getNewValue() !=
             valueChangeEvent.getOldValue()) &&
            (valueChangeEvent.getNewValue() != null)) {
            RichSelectOneChoice myInput =
                (RichSelectOneChoice)valueChangeEvent.getComponent();

            Connection conn = null;
            DBConnector MyDB = new DBConnector();
            conn = MyDB.getDatabaseConn();
            CallableStatement lgcallStmt = null;
            String updatePaymentVoucher =
                "begin LMS_WEB_CLAIMS_PKG.update_voucher_pymt_method(?,?,?,?);end;";
            try {
                lgcallStmt = conn.prepareCall(updatePaymentVoucher);

                lgcallStmt.setBigDecimal(1,
                                         (BigDecimal)this.session.getAttribute("voucherNumber"));

                payDetails = valueChangeEvent.getNewValue().toString();

                System.out.println("payDetails==" + payDetails);
                lgcallStmt.setString(2, payDetails);
                lgcallStmt.setString(3, null);
                lgcallStmt.setString(4, null);
                lgcallStmt.execute();
                lgcallStmt.close();
                conn.close();
            } catch (Exception e) {
                GlobalCC.EXCEPTIONREPORTING(conn, e);
            }
        }
    }

    public String updatePayMethodMFT() {
        Connection conn = null;
        CallableStatement cst = null;
        try {
            DBConnector myConn = new DBConnector();
            conn = myConn.getDatabaseConn();


            String updatePaymentVoucher =
                "begin LMS_WEB_CLAIMS_PKG.update_voucher_pymt_method(?,?,?,?);end;";


            cst = conn.prepareCall(updatePaymentVoucher);
            cst.setBigDecimal(1,
                              (BigDecimal)this.session.getAttribute("voucherNumber"));


            System.out.println("We are there finally");
            cst.setString(2,
                          String.valueOf(this.session.getAttribute("payMode")));
            cst.setString(3, null);
            cst.setString(4,
                          String.valueOf(this.session.getAttribute("clientAccNo")));


            cst.execute();
            cst.close();
        } catch (Exception e) {
            e = e;
            GlobalCC.EXCEPTIONREPORTING(conn, e);
            e.printStackTrace();
        } finally {
        }
        return null;
    }

    public void setAccColumn(RichColumn accColumn) {
        this.accColumn = accColumn;
    }

    public RichColumn getAccColumn() {
        return this.accColumn;
    }

    public void setVchrAccNo(RichInputText vchrAccNo) {
        this.vchrAccNo = vchrAccNo;
    }

    public RichInputText getVchrAccNo() {
        return this.vchrAccNo;
    }

    public void setProvSubType(RichInputText provSubType) {
        this.provSubType = provSubType;
    }

    public RichInputText getProvSubType() {
        return this.provSubType;
    }

    public void setMobileNumber(RichInputText mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public RichInputText getMobileNumber() {
        return this.mobileNumber;
    }

    public void setIdType(RichSelectOneChoice idType) {
        this.idType = idType;
    }

    public RichSelectOneChoice getIdType() {
        return this.idType;
    }

    public void setPassIdNo(RichInputText passIdNo) {
        this.passIdNo = passIdNo;
    }

    public RichInputText getPassIdNo() {
        return this.passIdNo;
    }

    public void setProvidersTableLOV(RichTable providersTableLOV) {
        this.providersTableLOV = providersTableLOV;
    }

    public RichTable getProvidersTableLOV() {
        return this.providersTableLOV;
    }

    public String providerSelected() {
        CorrespondenceManipulation mail = new CorrespondenceManipulation();
        try {
            Object key2 = this.providersTableLOV.getSelectedRowData();
            if (key2 == null) {
                GlobalCC.errorValueNotEntered("No Record Selected");
                return null;
            }
            JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
            if (r == null) {
                GlobalCC.errorValueNotEntered("No Record Selected");
                return null;
            }
            this.session.setAttribute("mptCode", r.getAttribute("MPT_CODE"));
            this.session.setAttribute("mptDesc", r.getAttribute("MPT_DESC"));
            this.provSubType.setValue(r.getAttribute("MPT_DESC"));
            this.session.setAttribute("mftProvider",
                                      r.getAttribute("MPT_DESC"));
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.provSubType);
            GlobalCC.hidePopup("lmsgroup:mftpay_type");
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(null, ex);
        }
        return null;
    }

    public String updatePaymentDetails() {
        Connection conn = null;
        CallableStatement cst = null;
        try {
            DBConnector myConn = new DBConnector();
            conn = myConn.getDatabaseConn();

            String updatePaymentVoucher =
                "begin LMS_WEB_CLAIMS_PKG.update_voucher_mft_details(?,?,?,?,?,?);end;";


            cst = conn.prepareCall(updatePaymentVoucher);
            cst.setBigDecimal(1,
                              (BigDecimal)this.session.getAttribute("voucherNumber"));


            cst.setBigDecimal(2,
                              (BigDecimal)this.session.getAttribute("mptCode"));
            if (this.idType.getValue().toString() == null) {
                cst.setString(3, null);
            } else {
                cst.setString(3, this.idType.getValue().toString());
            }
            if (this.mobileNumber.getValue().toString() == null) {
                cst.setString(4, null);
            } else {
                cst.setString(4, this.mobileNumber.getValue().toString());
            }
            if (this.passIdNo.getValue().toString() == null) {
                cst.setString(5, null);
            } else {
                cst.setString(5, this.passIdNo.getValue().toString());
            }
            cst.setString(6,
                          String.valueOf(this.session.getAttribute("mftProvider")));

            GlobalCC.hidePopup("lmsgroup:mftpop");
            GlobalCC.sysInformation("MFT Details updated successfully!");
            cst.execute();
            cst.close();
            ADFUtils.findIterator("findClaimVouchersIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.claimVouchers);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.vchrAccNo);
        } catch (Exception e) {
            e = e;
            GlobalCC.EXCEPTIONREPORTING(conn, e);
            e.printStackTrace();
        } finally {
        }
        return null;
    }

    public void setClmPercPayableLabel(RichOutputLabel clmPercPayableLabel) {
        this.clmPercPayableLabel = clmPercPayableLabel;
    }

    public RichOutputLabel getClmPercPayableLabel() {
        return this.clmPercPayableLabel;
    }

    public String SearchBankBranch() {
        try {
            if (this.bankBrnchSearch.getValue() == null) {
                this.session.setAttribute("BankSearchString", null);
            } else {
                this.session.setAttribute("BankSearchString",
                                          this.bankBrnchSearch.getValue().toString());
            }
            ADFUtils.findIterator("FindClientBankDetailsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.clientBankLOV);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public void setBankBrnchSearch(RichInputText bankBrnchSearch) {
        this.bankBrnchSearch = bankBrnchSearch;
    }

    public RichInputText getBankBrnchSearch() {
        return this.bankBrnchSearch;
    }

    public String showPensionBeneficiary() {
        this.session.setAttribute("benModule", "C");
        ADFUtils.findIterator("FindMembersBeneficiariesIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.studentsLOV);
        GlobalCC.showPopup("lmsgroup:beneficiaries");
        return null;
    }

    public void setCvtPayable(RichSelectOneChoice cvtPayable) {
        this.cvtPayable = cvtPayable;
    }

    public RichSelectOneChoice getCvtPayable() {
        return this.cvtPayable;
    }

    public void setMemNoSearch(RichInputText memNoSearch) {
        this.memNoSearch = memNoSearch;
    }

    public RichInputText getMemNoSearch() {
        return this.memNoSearch;
    }

    public void setMemNameSearch(RichInputText memNameSearch) {
        this.memNameSearch = memNameSearch;
    }

    public RichInputText getMemNameSearch() {
        return this.memNameSearch;
    }

    public void setClaimSearch(RichInputText claimSearch) {
        this.claimSearch = claimSearch;
    }

    public RichInputText getClaimSearch() {
        return this.claimSearch;
    }

    public String findclaims() {
        this.session.setAttribute("ClaimSearch",
                                  (String)this.claimSearch.getValue());
        this.session.setAttribute("memNoSearch",
                                  (String)this.memNoSearch.getValue());
        this.session.setAttribute("memNameSearch",
                                  (String)this.memNameSearch.getValue());

        ADFUtils.findIterator("FindClaimTransactionsIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.claimLOV);
        return null;
    }

    public String goToPayments() {
        try {
            Object key2 = this.claimLOV.getSelectedRowData();
            if (key2 == null) {
                GlobalCC.errorValueNotEntered("No Record Selected");
                return null;
            }
            JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
            if (r == null) {
                GlobalCC.errorValueNotEntered("No Record Selected");
                return null;
            }
            System.out.println("Policy code " + r.getAttribute("POL_CODE") +
                               " Claim No" + r.getAttribute("LTR_CLM_NO"));

            this.session.setAttribute("policyCode",
                                      r.getAttribute("POL_CODE"));
            this.session.setAttribute("chq_clm_no",
                                      r.getAttribute("LTR_CLM_NO"));
            this.session.setAttribute("sourcePage", "claims");
            GlobalCC.RedirectPage("/chqTracking.jspx");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }

    public String SearchClaimStatus() {
        try {
            Object key2 = this.claimLOV.getSelectedRowData();
            if (key2 == null) {
                GlobalCC.errorValueNotEntered("No Record Selected");
                return null;
            }
            JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
            if (r == null) {
                GlobalCC.errorValueNotEntered("No Record Selected");
                return null;
            }
            String Claim = (String)r.getAttribute("LTR_CLM_NO");
            this.session.setAttribute("ClaimNo", r.getAttribute("LTR_CLM_NO"));
            BigDecimal batchNo =
                (BigDecimal)this.session.getAttribute("clmbatchNo");
            if (Claim == null) {
                String Message = "Select a Claim";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                              Message,
                                                                              Message));


                return null;
            }
            ADFUtils.findIterator("findTicketDetailsByUserIterator").executeQuery();
            String Tasks = (String)this.session.getAttribute("ModuleTickets");
            System.out.println("TESTING ======" + Tasks);
            if (batchNo != null) {
                System.out.println("BatchNo " + batchNo);
                GlobalCC.RedirectPage("/g_multiclaims.jspx");
            } else if (Tasks.equalsIgnoreCase("Y")) {
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.resultsLOV);
                this.myTickets.setRendered(true);
            } else {
                GlobalCC.RedirectPage("/g_claims.jspx");
            }
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
            e.printStackTrace();
        }
        return null;
    }

    public String findCausationsSelected1() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindCausationsIterator");


        RowKeySet set = this.causationsLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();

            this.causationDesc.setValue(r.getAttribute("CAUS_DESC"));

            this.session.setAttribute("CausationCode",
                                      r.getAttribute("CAUS_CODE"));

            this.session.setAttribute("CausationShtDesc",
                                      r.getAttribute("CAUS_SHT_DESC"));


            this.session.setAttribute("CausationType",
                                      r.getAttribute("CAUS_TYPE"));


            this.causationCauseDesc.setValue(null);

            this.session.setAttribute("CauseCode", null);

            ADFUtils.findIterator("FindCausationCausesIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.claimsCausationsCauseLOV);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.causationCauseDesc);
        }
        return null;
    }

    public String additionalMedicals() {
        Iterator selection =
            this.medTestsTable.getSelectedRowKeys().iterator();
        DCIteratorBinding rowiter =
            ADFUtils.findIterator("findMedTestIterator");

        RowSetIterator rsi = rowiter.getRowSetIterator();
        while (selection.hasNext()) {
            Object rowKey = selection.next();
            Row row = rsi.getCurrentRow();
            this.medTestsTable.setRowKey(rowKey);

            BigDecimal mtlCode = (BigDecimal)row.getAttribute("MTLCode");
            DBConnector datahandler = null;
            datahandler = new DBConnector();

            Connection conn = datahandler.getDatabaseConn();

            CallableStatement cst = null;
            try {
                String medicalQuery =
                    "begin LMS_WEB_PKG_GRP.Add_unreq_medicals(?,?,?,?,?,?,?); end;";

                cst = conn.prepareCall(medicalQuery);

                cst.setBigDecimal(1,
                                  (BigDecimal)this.session.getAttribute("policyCode"));

                cst.setBigDecimal(2, null);
                cst.setBigDecimal(3, mtlCode);
                cst.setBigDecimal(4, null);
                cst.setString(5, "U");
                cst.setBigDecimal(6,
                                  (BigDecimal)this.session.getAttribute("PolmCode"));

                cst.setString(7, (String)this.session.getAttribute("ClaimNo"));
                cst.execute();
                cst.close();
                conn.commit();
                conn.close();
                ADFUtils.findIterator("findMedTestIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.medTestsTable);

                ADFUtils.findIterator("FindClientMedicalsIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.medReqLOV);
            } catch (Exception e) {
                GlobalCC.EXCEPTIONREPORTING(conn, e);
            }
        }
        return null;
    }

    public String EditMedicalReq() {
        DCIteratorBinding dciter =
            ADFUtils.findIterator("FindClientMedicalsIterator");
        RowKeySet set = this.medReqLOV.getSelectedRowKeys();
        Iterator rowKeySetIter = set.iterator();
        while (rowKeySetIter.hasNext()) {
            List l = (List)rowKeySetIter.next();
            Key key = (Key)l.get(0);
            dciter.setCurrentRowWithKey(key.toStringFormat(true));
            Row r = dciter.getCurrentRow();


            this.session.setAttribute("CMLCode", r.getAttribute("CML_CODE"));
            this.facDesc.setValue(r.getAttribute("SPR_NAME"));
            this.reqDate.setValue(r.getAttribute("CML_REQUEST_DATE"));
            this.invAmt.setValue(r.getAttribute("CML_CLAIM_AMT"));
            this.cheqDate.setValue(r.getAttribute("CML_DATE_RECEIVED"));
            this.checkedDesc.setValue(r.getAttribute("CML_RECEIVED"));
            this.invDate.setValue(r.getAttribute("CML_INVCE_DATE"));
            this.invNo.setValue(r.getAttribute("CML_INVCE_NO"));
            this.medremarks.setValue(r.getAttribute("CML_REMARKS"));


            ExtendedRenderKitService erkService =
                (ExtendedRenderKitService)Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                                             ExtendedRenderKitService.class);


            erkService.addScript(FacesContext.getCurrentInstance(),
                                 "var hints = {autodismissNever:false}; AdfPage.PAGE.findComponent('lmsgroup:medpopup').show(hints);");
        }
        return null;
    }

    public String SaveMedicalRequirement() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        Boolean ReqDateChanged = Boolean.valueOf(false);
        Boolean cheqDateChanged = Boolean.valueOf(false);
        Boolean invDateChanged = Boolean.valueOf(false);
        if (this.reqDate.getValue() != null) {
            ReqDateChanged =
                    Boolean.valueOf(this.reqDate.getValue().toString().contains(":"));
        }
        if (this.cheqDate.getValue() != null) {
            cheqDateChanged =
                    Boolean.valueOf(this.cheqDate.getValue().toString().contains(":"));
        }
        if (this.invDate.getValue() != null) {
            invDateChanged =
                    Boolean.valueOf(this.invDate.getValue().toString().contains(":"));
        }
        try {
            String polQuery =
                "begin LMS_WEB_PKG_GRP.updatemedicals(?,?,?,?,?,?,?,?,?,?);end;";
            cst = conn.prepareCall(polQuery);
            if (this.reqDate.getValue() == null) {
                cst.setString(1, null);
            } else if (!ReqDateChanged.booleanValue()) {
                cst.setString(1, null);
            } else {
                cst.setString(1,
                              LOVCC.parseDate(this.reqDate.getValue().toString()));
            }
            if (this.invAmt.getValue() == null) {
                cst.setString(2, null);
            } else {
                cst.setString(2, this.invAmt.getValue().toString());
            }
            if (this.cheqDate.getValue() == null) {
                cst.setString(3, null);
            } else if (!cheqDateChanged.booleanValue()) {
                cst.setString(3, null);
            } else {
                cst.setString(3,
                              LOVCC.parseDate(this.cheqDate.getValue().toString()));
            }
            if (this.checkedDesc.getValue() == null) {
                cst.setString(4, null);
            } else {
                cst.setString(4, this.checkedDesc.getValue().toString());
            }
            if (this.invDate.getValue() == null) {
                cst.setString(5, null);
            } else if (!invDateChanged.booleanValue()) {
                cst.setString(5, null);
            } else {
                cst.setString(5,
                              LOVCC.parseDate(this.invDate.getValue().toString()));
            }
            if (this.invNo.getValue() == null) {
                cst.setString(6, null);
            } else {
                cst.setString(6, this.invNo.getValue().toString());
            }
            if (this.medremarks.getValue() == null) {
                cst.setString(7, null);
            } else {
                cst.setString(7, this.medremarks.getValue().toString());
            }
            cst.setBigDecimal(8,
                              (BigDecimal)this.session.getAttribute("CMLCode"));
            cst.setBigDecimal(9,
                              (BigDecimal)this.session.getAttribute("FacilitatorCode"));
            if (this.resultDate.getValue() == null) {
                cst.setString(10, null);
            } else {
                cst.setString(10,
                              LOVCC.parseDate(this.resultDate.getValue().toString()));
            }
            cst.execute();

            this.session.setAttribute("CMLCode", null);
            cst.close();

            String Message = "Medical Updated";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));


            ADFUtils.findIterator("FindClientMedicalsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.medReqLOV);


            GlobalCC.hidePopup("lmsgroup:medpopup");
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
            e.printStackTrace();
        }
        return null;
    }

    public String RenderFacilitators() {
        ExtendedRenderKitService erkService =
            (ExtendedRenderKitService)Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                                         ExtendedRenderKitService.class);


        erkService.addScript(FacesContext.getCurrentInstance(),
                             "var hints = {autodismissNever:false}; AdfPage.PAGE.findComponent('lmsgroup:facilitator').show(hints);");


        return null;
    }

    public void setMedTestsTable(RichTable medTestsTable) {
        this.medTestsTable = medTestsTable;
    }

    public RichTable getMedTestsTable() {
        return this.medTestsTable;
    }

    public void setMedReqLOV(RichTable medReqLOV) {
        this.medReqLOV = medReqLOV;
    }

    public RichTable getMedReqLOV() {
        return this.medReqLOV;
    }

    public void setFacDesc(RichInputText facDesc) {
        this.facDesc = facDesc;
    }

    public RichInputText getFacDesc() {
        return this.facDesc;
    }

    public void setReqDate(RichInputDate reqDate) {
        this.reqDate = reqDate;
    }

    public RichInputDate getReqDate() {
        return this.reqDate;
    }

    public void setInvAmt(RichInputText invAmt) {
        this.invAmt = invAmt;
    }

    public RichInputText getInvAmt() {
        return this.invAmt;
    }

    public void setCheqDate(RichInputDate cheqDate) {
        this.cheqDate = cheqDate;
    }

    public RichInputDate getCheqDate() {
        return this.cheqDate;
    }

    public void setCheckedDesc(RichSelectOneChoice checkedDesc) {
        this.checkedDesc = checkedDesc;
    }

    public RichSelectOneChoice getCheckedDesc() {
        return this.checkedDesc;
    }

    public void setInvDate(RichInputDate invDate) {
        this.invDate = invDate;
    }

    public RichInputDate getInvDate() {
        return this.invDate;
    }

    public void setInvNo(RichInputText invNo) {
        this.invNo = invNo;
    }

    public RichInputText getInvNo() {
        return this.invNo;
    }

    public RichInputText getRemarks1() {
        return this.remarks;
    }

    public void setResultDate(RichInputDate resultDate) {
        this.resultDate = resultDate;
    }

    public RichInputDate getResultDate() {
        return this.resultDate;
    }

    public void setMedremarks(RichInputText medremarks) {
        this.medremarks = medremarks;
    }

    public RichInputText getMedremarks() {
        return this.medremarks;
    }

    public void setSchemeJoinDate(RichInputDate schemeJoinDate) {
        this.schemeJoinDate = schemeJoinDate;
    }

    public RichInputDate getSchemeJoinDate() {
        return schemeJoinDate;
    }

    public void setEmploymentDate(RichInputDate employmentDate) {
        this.employmentDate = employmentDate;
    }

    public RichInputDate getEmploymentDate() {
        return employmentDate;
    }

    public void setDateOfBirth(RichInputDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public RichInputDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setKraPinNo(RichInputText kraPinNo) {
        this.kraPinNo = kraPinNo;
    }

    public RichInputText getKraPinNo() {
        return kraPinNo;
    }

    public void setOverrideTax(RichInputText overrideTax) {
        this.overrideTax = overrideTax;
    }

    public RichInputText getOverrideTax() {
        return overrideTax;
    }

    public void setTransferToLB(RichOutputLabel transferToLB) {
        this.transferToLB = transferToLB;
    }

    public RichOutputLabel getTransferToLB() {
        return transferToLB;
    }

    public void setTransferToTF(RichInputText transferToTF) {
        this.transferToTF = transferToTF;
    }

    public RichInputText getTransferToTF() {
        return transferToTF;
    }

    public void setTransferLockedBen(RichSelectOneChoice transferLockedBen) {
        this.transferLockedBen = transferLockedBen;
    }

    public RichSelectOneChoice getTransferLockedBen() {
        return transferLockedBen;
    }

    public void transferListener(ValueChangeEvent valueChangeEvent) {
        if (valueChangeEvent.getNewValue() != valueChangeEvent.getOldValue()) {
            if (transferLockedBen.getValue().equals("Y")) {
                transferToLB.setVisible(true);
                transferToTF.setVisible(true);
            } else {
                transferToLB.setVisible(false);
                transferToTF.setVisible(false);
            }
            //System.out.println("Heloo am here");
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.transferToLB);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.transferToTF);
    }

    public void setWithAppliedOn(RichSelectOneChoice withAppliedOn) {
        this.withAppliedOn = withAppliedOn;
    }

    public RichSelectOneChoice getWithAppliedOn() {
        return withAppliedOn;
    }

    public void setWithOverrideTaxAmt(RichInputText withOverrideTaxAmt) {
        this.withOverrideTaxAmt = withOverrideTaxAmt;
    }

    public RichInputText getWithOverrideTaxAmt() {
        return withOverrideTaxAmt;
    }

    public void setComputeWithdrawalAmt(RichCommandButton computeWithdrawalAmt) {
        this.computeWithdrawalAmt = computeWithdrawalAmt;
    }

    public RichCommandButton getComputeWithdrawalAmt() {
        return computeWithdrawalAmt;
    }

    public String calculateWithdrawalAmt() {
        DBConnector myConn = new DBConnector();
        Connection conn = myConn.getDatabaseConn();
        CallableStatement cst = null;
        BigDecimal withdrawalAmount = null;
        BigDecimal overrideTaxAmount = null;

        if (withAppliedOn.getValue() == null) {
            GlobalCC.INFORMATIONREPORTING("Please Select withdrawal applied on to proceed..");
        }
        if (withdrawalAmt.getValue() == null) {
            GlobalCC.INFORMATIONREPORTING("Please provide the withdrawal amount to proceed...");
        }

        try {
            String withdrawalQuery =
                "begin LMS_PENSIONS.computewithdrawalamount(?,?,?,?);end;";
            cst = conn.prepareCall(withdrawalQuery);
            cst.setString(1, (String)this.session.getAttribute("ClaimNo"));
            if (withdrawalAmt.getValue() == null) {
                cst.setBigDecimal(2, null);
            } else {
                withdrawalAmount =
                        new BigDecimal(withdrawalAmt.getValue().toString());
                cst.setBigDecimal(2, withdrawalAmount);
            }
            if (withOverrideTaxAmt.getValue() == null) {
                cst.setBigDecimal(3, null);
            } else {
                overrideTaxAmount =
                        new BigDecimal(withOverrideTaxAmt.getValue().toString());
                cst.setBigDecimal(3, overrideTaxAmount);
            }
            cst.setString(4, (String)withAppliedOn.getValue());
            cst.execute();
            cst.close();
            conn.close();
            ADFUtils.findIterator("findPartialWithdrawalIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.withEmpyrRegAmt);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.withEmplyrUnregAmt);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.withEmpyeRegAmt);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.withEmpyeUnregAmt);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.withdrawalNetPayable);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.withOverrideTaxAmt);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.withdrawalTaxAmt);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.withdrawalTaxExemptAmt);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.withdrawalAmt);
            GlobalCC.INFORMATIONREPORTING("Withdrawal Amount Computed Successfully");
        } catch (Exception ex) {
            ex.printStackTrace();
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
        }

        return null;
    }

    public void setWithdrawalAmt(RichInputText withdrawalAmt) {
        this.withdrawalAmt = withdrawalAmt;
    }

    public RichInputText getWithdrawalAmt() {
        return withdrawalAmt;
    }

    public void setWithdrawalTaxExemptAmt(RichInputText withdrawalTaxExemptAmt) {
        this.withdrawalTaxExemptAmt = withdrawalTaxExemptAmt;
    }

    public RichInputText getWithdrawalTaxExemptAmt() {
        return withdrawalTaxExemptAmt;
    }

    public void setWithdrawalTaxAmt(RichInputText withdrawalTaxAmt) {
        this.withdrawalTaxAmt = withdrawalTaxAmt;
    }

    public RichInputText getWithdrawalTaxAmt() {
        return withdrawalTaxAmt;
    }

    public void setWithdrawalNetPayable(RichInputText withdrawalNetPayable) {
        this.withdrawalNetPayable = withdrawalNetPayable;
    }

    public RichInputText getWithdrawalNetPayable() {
        return withdrawalNetPayable;
    }

    public void setWithEmpyrRegAmt(RichInputText withEmpyrRegAmt) {
        this.withEmpyrRegAmt = withEmpyrRegAmt;
    }

    public RichInputText getWithEmpyrRegAmt() {
        return withEmpyrRegAmt;
    }

    public void setWithEmplyrUnregAmt(RichInputText withEmplyrUnregAmt) {
        this.withEmplyrUnregAmt = withEmplyrUnregAmt;
    }

    public RichInputText getWithEmplyrUnregAmt() {
        return withEmplyrUnregAmt;
    }

    public void setWithEmpyeRegAmt(RichInputText withEmpyeRegAmt) {
        this.withEmpyeRegAmt = withEmpyeRegAmt;
    }

    public RichInputText getWithEmpyeRegAmt() {
        return withEmpyeRegAmt;
    }

    public void setWithEmpyeUnregAmt(RichInputText withEmpyeUnregAmt) {
        this.withEmpyeUnregAmt = withEmpyeUnregAmt;
    }

    public RichInputText getWithEmpyeUnregAmt() {
        return withEmpyeUnregAmt;
    }

    public String CreatePensionWithdrawalVoucher() {
        Connection conn = null;
        CallableStatement cst = null;
        try {
            String str1;
            String alert = "";
            DBConnector myConn = new DBConnector();
            conn = myConn.getDatabaseConn();

            String Rights = null;
            this.session.setAttribute("ProcessShtDesc", "CLMS");
            this.session.setAttribute("ProcessAreaShtDesc", "ACCS");
            this.session.setAttribute("ProcessSubAShtDesc", "ACCS");
            workflowProcessing wf = new workflowProcessing();
            Rights = wf.CheckUserRights();
            if (Rights.equalsIgnoreCase("N")) {
                alert = "You do not have rights to Perform this Task.";


                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              alert,
                                                                              alert));


                return null;
            }
            String NextUser = null;
            this.session.setAttribute("ProcessShtDesc", "CLMS");
            this.session.setAttribute("ProcessAreaShtDesc", "ACCS");
            this.session.setAttribute("ProcessSubAShtDesc", "ACCS");
            this.session.setAttribute("TaskAssignee", null);
            this.session.setAttribute("NextTaskAssignee", "N");
            ADFUtils.findIterator("findTicketAssigneeIterator").executeQuery();
            NextUser = (String)this.session.getAttribute("NextTaskAssignee");
            String TaskAss = (String)this.session.getAttribute("TaskAssignee");
            if ((TaskAss == null) && (NextUser.equalsIgnoreCase("N"))) {
                alert =
                        "There is no User to Assign the Next Task. Consult the Administrator.";


                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              alert,
                                                                              alert));


                return null;
            }
            String Taske = (String)this.session.getAttribute("TaskID");
            if (Taske == null) {
                String Message = "No Task Selected";
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));


                return null;
            }
            Taske = (String)this.session.getAttribute("TaskID");
            String str5;
            if (Taske != null) {
                String MyTask = null;
                CallableStatement cst3 = null;
                String Complete =
                    "BEGIN TQC_WEB_PKG.check_task_completion(?,?,?,?);END;";


                cst3 = conn.prepareCall(Complete);
                cst3.setString(1, "CLMVCHR");
                cst3.setString(2, (String)this.session.getAttribute("TaskID"));
                cst3.setInt(3,
                            ((Integer)this.session.getAttribute("sysCode")).intValue());

                cst3.registerOutParameter(4, 12);
                cst3.execute();
                MyTask = cst3.getString(4);
                cst3.close();
                if (MyTask.equalsIgnoreCase("N")) {
                    alert =
                            "the Task Selected Does not Correspond to the Activity being Performed. Cannot Complete please " +
                            this.session.getAttribute("TaskActivityName");


                    FacesContext.getCurrentInstance().addMessage(null,
                                                                 new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                                  alert,
                                                                                  alert));

                    return null;
                }
            }
            String AddClaim =
                "begin LMS_WEB_CLAIMS_PKG.create_voucher(?,?,?,?,?,?,?,?,?,?,?,?,?);end;";


            cst = conn.prepareCall(AddClaim);
            cst.setBigDecimal(1,
                              (BigDecimal)this.session.getAttribute("policyCode"));


            cst.setString(2, (String)this.session.getAttribute("ClaimNo"));
            cst.setString(3, "PM");
            if (this.withdrawalNetPayable.getValue() == null) {
                cst.setBigDecimal(4, null);
            } else {
                cst.setBigDecimal(4,
                                  (BigDecimal)withdrawalNetPayable.getValue());
            }
            cst.setBigDecimal(5,
                              (BigDecimal)this.session.getAttribute("MemberNumber"));


            cst.setBigDecimal(6,
                              (BigDecimal)this.session.getAttribute("PolmCode"));

            cst.setBigDecimal(7,
                              (BigDecimal)this.session.getAttribute("PMPNS_CODE"));
            if (this.withdrawalTaxAmt.getValue() == null) {
                cst.setBigDecimal(8, null);
            } else {
                cst.setBigDecimal(8,
                                  (BigDecimal)this.withdrawalTaxAmt.getValue());
            }
            cst.setBigDecimal(9,
                              (BigDecimal)this.session.getAttribute("ClaimTransNo"));
            cst.setString(10, null);
            cst.setString(11, null);
            cst.setString(11, null);
            cst.setString(12, null);
            cst.setString(13, null);
            cst.execute();
            cst.close();
            conn.close();

            this.session.setAttribute("ProcessAreaShtDesc", "ACCS");
            this.session.setAttribute("ProcessSubAShtDesc", "ACCS");
            Rights = wf.CheckUserRights();
            if (Rights.equalsIgnoreCase("N")) {
                this.session.setAttribute("TaskAssignee", null);
                ADFUtils.findIterator("findTicketAssigneeIterator").executeQuery();
                TaskAss = (String)this.session.getAttribute("TaskAssignee");
                if (TaskAss == null) {
                    GetAssignee();
                    return null;
                }
                this.session.setAttribute("TicketRemarks", null);
                wf.CompleteTask();
                String Message =
                    "Current Task Complete. The Next Task " + (String)this.session.getAttribute("TaskActivityName") +
                    " has been Successfully assigned to " +
                    (String)this.session.getAttribute("TaskAssignee");


                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                              Message,
                                                                              Message));


                this.session.setAttribute("TaskID", null);
                return null;
            }
            wf.CompleteTask();

            String Message = "Voucher Successfully Created";
            FacesContext.getCurrentInstance().addMessage(null,
                                                         new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                          Message,
                                                                          Message));


            return null;
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
        return null;
    }

    public void setPayeeTF(RichInputText payeeTF) {
        this.payeeTF = payeeTF;
    }

    public RichInputText getPayeeTF() {
        return payeeTF;
    }

    public String claimOpening() {
        Connection conn = null;
        CallableStatement cst = null;
        DBConnector connector = new DBConnector();
        try {
            String AddClaim =
                "begin LMS_CLAIM_BOOKING.book_new_claim(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);end;";

            conn = connector.getDatabaseConn();
            cst = conn.prepareCall(AddClaim);
            cst.setBigDecimal(1,
                              (BigDecimal)this.session.getAttribute("PolicyMemCode"));
            if (this.lossDate.getValue() == null) {
                cst.setString(2, null);
            } else {
                cst.setString(2,
                              GlobalCC.parseDate(this.lossDate.getValue().toString()));
            }
            if (this.reportDate.getValue() == null) {
                cst.setString(3, null);
            } else {
                cst.setString(3,
                              GlobalCC.parseDate(this.reportDate.getValue().toString()));
            }
            cst.setBigDecimal(4,
                              (BigDecimal)this.session.getAttribute("policyCode"));


            cst.setBigDecimal(5,
                              (BigDecimal)this.session.getAttribute("CausationCode"));


            cst.setString(6,
                          (String)this.session.getAttribute("CausationShtDesc"));

            cst.setString(7,
                          (String)this.session.getAttribute("CausationType"));

            cst.setString(8,
                          (String)this.session.getAttribute("ClaimTransactionType"));


            cst.setString(9, (String)this.session.getAttribute("Username"));
            cst.setBigDecimal(10,
                              (BigDecimal)this.session.getAttribute("CauseCode"));


            cst.registerOutParameter(11, 12);
            cst.registerOutParameter(12, 3);
            cst.setString(13,
                          this.minimumInformationProvided.getValue().toString());
            if (this.xgratiaTransaction.isSelected()) {
                cst.setString(14, "Y");
            } else {
                cst.setString(14, "N");
            }
            if (this.exgratiaRemarks.getValue() == null) {
                cst.setString(15, "N");
            } else {
                cst.setString(15, this.exgratiaRemarks.getValue().toString());
            }
            if (this.deathLocation.getValue() == null) {
                cst.setString(16, null);
            } else {
                cst.setString(16, this.deathLocation.getValue().toString());
            }
            cst.registerOutParameter(17, OracleTypes.NUMBER);
            cst.execute();
            session.setAttribute("cmbCode", cst.getBigDecimal(17));
            GlobalCC.RedirectPage("/claimBooking.jspx");
        } catch (Exception ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
            ex.printStackTrace();
            GlobalCC.CloseConnections(null, cst, conn);

        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
        return null;
    }

    public void setClaimBookingLOV(RichTable claimBookingLOV) {
        this.claimBookingLOV = claimBookingLOV;
    }

    public RichTable getClaimBookingLOV() {
        return claimBookingLOV;
    }

    public void selectClaimBookingRecord(SelectionEvent selectionEvent) {
        // Add event code here...
       Object key2 = this.claimBookingLOV.getSelectedRowData();
        if (key2 == null) {
            GlobalCC.errorValueNotEntered("No Record Selected");
        }
        JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
        if (r == null) {
            GlobalCC.errorValueNotEntered("No Record Selected");
        }
        session.setAttribute("cmbCode", r.getAttribute("cmb_code"));
    }

    public String goToBookingDetails() {
        // Add event code here...
        Object key2 = this.claimBookingLOV.getSelectedRowData();
        if (key2 == null) {
            GlobalCC.errorValueNotEntered("No Record Selected");
        }
        JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
        if (r == null) {
            GlobalCC.errorValueNotEntered("No Record Selected");
        }
        session.setAttribute("cmbCode", r.getAttribute("cmb_code"));
        session.setAttribute("policyCode", r.getAttribute("POL_CODE"));

        GlobalCC.RedirectPage("claimBooking.jspx");
        return null;
    }

    public String goToBookingTransPage() {
        // Add event code here...
        GlobalCC.RedirectPage("captureClaim.jspx");
        return null;
    }

    public void setBookingCoverTypeLOV(RichTable bookingCoverTypeLOV) {
        this.bookingCoverTypeLOV = bookingCoverTypeLOV;
    }

    public RichTable getBookingCoverTypeLOV() {
        return bookingCoverTypeLOV;
    }

    public String processClaimBooking() {
        // Add event code here...
        DCIteratorBinding dciter =
            ADFUtils.findIterator("claimBookingCoversIterator");
        ViewObject vo = dciter.getViewObject();
        Row[] selectedCovers = vo.getFilteredRows("bookCoverCheck", true);
        int count = 0;
        for (Row row : selectedCovers) {
            processBookingCovers((BigDecimal)row.getAttribute("CBVT_CODE"),
                                 (BigDecimal)row.getAttribute("CBVT_RESERVE_AMT"));
        }
        this.totalReserveAmt();

        ADFUtils.findIterator("claimBookingCoversIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.bookingCoverTypeLOV);
        
        ADFUtils.findIterator("riRecoverableAmtIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.reinsuranceBookingLOV);

        GlobalCC.INFORMATIONREPORTING("Cover processing successfull");
        return null;
    }

    public void processBookingCovers(BigDecimal cbvtCode,
                                     BigDecimal reserveAmt) {
        Connection conn = null;
        CallableStatement cst = null;
        DBConnector connector = new DBConnector();
        String sql =
            "begin LMS_CLAIM_BOOKING.processclaimbookingcovers(?,?);end;";
        try {
            conn = connector.getDatabaseConn();
            cst = conn.prepareCall(sql);
            cst.setBigDecimal(1, cbvtCode);
            cst.setBigDecimal(2, reserveAmt);
            cst.execute();
            GlobalCC.CloseConnections(null, cst, conn);
        } catch (Exception ex) {
            ex.printStackTrace();
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
            GlobalCC.CloseConnections(null, cst, conn);
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
    }

    public void totalReserveAmt() {
        Connection conn = null;
        CallableStatement cst = null;
        DBConnector connector = new DBConnector();
        String sql = "begin LMS_CLAIM_BOOKING.processclaimbooking(?);end;";
        try {
            conn = connector.getDatabaseConn();
            cst = conn.prepareCall(sql);
            cst.setBigDecimal(1, (BigDecimal)session.getAttribute("cmbCode"));
            cst.execute();
            GlobalCC.CloseConnections(null, cst, conn);
        } catch (Exception ex) {
            ex.printStackTrace();
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
            GlobalCC.CloseConnections(null, cst, conn);
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
    }

    public String deleteClaimBooking() {
      Connection conn = null;
      CallableStatement cst = null;
      DBConnector connection = new DBConnector();
        try {
            String sql = "begin lms_claim_booking.deleteclaimbooking(?);end;";
            conn = connection.getDatabaseConn();
            cst = conn.prepareCall(sql);
            cst.setBigDecimal(1,(BigDecimal)session.getAttribute("cmbCode"));
            cst.execute();
            GlobalCC.CloseConnections(null, cst, conn);
            GlobalCC.INFORMATIONREPORTING("Record deleted successfully");
        } catch (Exception ex) {
            GlobalCC.CloseConnections(null, cst, conn);
        } finally {
            GlobalCC.CloseConnections(null, cst, conn);
        }
      ADFUtils.findIterator("pendingClaimBookingIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.claimBookingLOV);
        return null;
    }

    public void setReinsuranceBookingLOV(RichTable reinsuranceBookingLOV) {
        this.reinsuranceBookingLOV = reinsuranceBookingLOV;
    }

    public RichTable getReinsuranceBookingLOV() {
        return reinsuranceBookingLOV;
    }
}
