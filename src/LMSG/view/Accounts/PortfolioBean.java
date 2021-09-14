package LMSG.view.Accounts;

import LMSG.view.Base.ADFUtils;
import LMSG.view.Base.GlobalCC;
import LMSG.view.Navigation.Links;
import LMSG.view.connect.DBConnector;
import LMSG.view.dms.DMSUtils;
import LMSG.view.dms.DocIEdmsBack;
import LMSG.view.dms.ListDocByte;

import com.Ostermiller.util.CSVParser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;

import java.math.BigDecimal;

import java.net.HttpURLConnection;
import java.net.URL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputFile;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanCheckbox;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanRadio;
import oracle.adf.view.rich.component.rich.layout.RichPanelBox;
import oracle.adf.view.rich.component.rich.output.RichInlineFrame;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.jbo.uicli.binding.JUCtrlValueBinding;

import oracle.jdbc.OracleTypes;

import org.apache.myfaces.trinidad.event.SelectionEvent;
import org.apache.myfaces.trinidad.model.RowKeySet;
import org.apache.myfaces.trinidad.model.RowKeySetImpl;
import org.apache.myfaces.trinidad.model.CollectionModel;


import org.apache.myfaces.trinidad.model.UploadedFile;
import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;
import org.apache.myfaces.trinidad.model.UploadedFile;


import sun.misc.BASE64Decoder;

public class PortfolioBean {
    private RichTable treatyArrangementLOV;
    private RichInputText arrangementId;
    private RichInputText arrangementDescription;
    private RichInputText arrangementType;
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    private RichTable arrangementYearLOV;
    private RichInputText yearTF;
    private RichTable treatiesLOV;
    private RichTable treatyPeriodLOV;
    private RichInputText txtPrtsFiscalYear;
    private RichInputText txtPrtsUwYear;
    private RichInputText txtPrtstrtCode;
    private RichInputText txtPrtsTaCode;
    private RichInputText txtPrtstaCode;
    private RichInputText txtPremPortfolio;
    private RichInputText txtLossPortfolio;
    private RichInputDate dateFrom;
    private RichInputDate dateTo;
    private RichInputDate periodDateFrom;
    private RichInputDate periodDateTo;
    private RichSelectBooleanCheckbox selectParticipant;
    private RichTable treatySummaryLOV;
    private RichTable brhLOV;
    private RichInputText brhDisplay;
    private RichTable receiptsDAO;
    private RichTable riRecoveryDAO;
    private RichSelectBooleanRadio riCeding;
    private RichSelectBooleanRadio riRecovery;
    private RichSelectBooleanRadio coinRecovery;
    private RichPanelBox riPanel;
    private RichTable coinsuranceDAO;
    private RichInputText coinAmtTF;
    private RichInputText reinAmtTF;
    private RichSelectBooleanCheckbox riSelect;
    private RichSelectBooleanCheckbox coinSelect;
    private RichTable policyClaimsDocsTbl;
    private RichTable commentTbl;
    private RichInlineFrame docFrame2;
    private RichInlineFrame docFrame3;
    private RichTable paymentDocTbl;
    private UploadedFile uploadedFile;
    private String filename;
    private long filesize;
    private String filecontents;
    private String filetype;
    private RichInputFile reinsuranceFileUpload;
    private static final HashMap<String, String> mimeTypes;
    private RichSelectBooleanCheckbox riSelectChk;
    private RichSelectBooleanCheckbox claimDocumentsSelect;
    private RichSelectBooleanCheckbox coinsuranceSelect;
    static {
        mimeTypes = new HashMap<String, String>() {
                {
                    put(".bmp", "image/bmp");
                    put(".doc", "application/msword");
                    put(".docm",
                        "application/vnd.ms-word.document.macroEnabled.12");
                    put(".docx",
                        "application/vnd.openxmlformats-officedocument.wordprocessingml.document");
                    put(".htm", "text/html");
                    put(".html", "text/html");
                    put(".jpb", "application/octet-stream");
                    put(".jpe", "image/jpeg");
                    put(".jpeg", "image/jpeg");
                    put(".jpg", "image/jpeg");
                    put(".pdf", "application/pdf");
                    put(".ppt", "application/vnd.ms-powerpoint");
                    put(".pptx",
                        "application/vnd.openxmlformats-officedocument.presentationml.presentation");
                    put(".xhtml", "application/xhtml+xml");
                    put(".xls", "application/vnd.ms-excel");
                    put(".xlsx",
                        "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
                    put(".png", "image/png");
                    put(".xlsb",
                        "application/vnd.ms-excel.sheet.binary.macroEnabled.12");

                }
            };
    }

    public void setTreatyArrangementLOV(RichTable treatyArrangementLOV) {
        this.treatyArrangementLOV = treatyArrangementLOV;
    }

    public RichTable getTreatyArrangementLOV() {
        return this.treatyArrangementLOV;
    }

    public void setArrangementId(RichInputText arrangementId) {
        this.arrangementId = arrangementId;
    }

    public RichInputText getArrangementId() {
        return this.arrangementId;
    }

    public void setArrangementDescription(RichInputText arrangementDescription) {
        this.arrangementDescription = arrangementDescription;
    }

    public RichInputText getArrangementDescription() {
        return this.arrangementDescription;
    }

    public String selectTreatyArrangement() {
        Object key2 = this.treatyArrangementLOV.getSelectedRowData();
        if (key2 == null) {
            GlobalCC.errorValueNotEntered("No Record Selected");
            return null;
        }
        JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
        if (r == null) {
            GlobalCC.errorValueNotEntered("No Record Selected");
            return null;
        }
        this.session.setAttribute("ta_code", r.getAttribute("ta_code"));
        this.arrangementId.setValue(r.getAttribute("TA_SHT_DESC"));
        this.arrangementDescription.setValue(r.getAttribute("TA_DESC"));
        this.arrangementType.setValue(r.getAttribute("TA_TYPE"));
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.arrangementId);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.arrangementDescription);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.arrangementType);
        ADFUtils.findIterator("findArrangementSetupsIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.arrangementYearLOV);

        return null;
    }

    public void setArrangementType(RichInputText arrangementType) {
        this.arrangementType = arrangementType;
    }

    public RichInputText getArrangementType() {
        return this.arrangementType;
    }

    public String findSelectedYear() {
        Object key2 = this.arrangementYearLOV.getSelectedRowData();
        if (key2 == null) {
            GlobalCC.errorValueNotEntered("No Record Selected");
            return null;
        }
        JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
        if (r == null) {
            GlobalCC.errorValueNotEntered("No Record Selected");
            return null;
        }
        if (this.session.getAttribute("ta_code") == null) {
            GlobalCC.INFORMATIONREPORTING("Please select a treaty arrangement");
        }
        this.session.setAttribute("as_code", r.getAttribute("AS_CODE"));
        this.yearTF.setValue(r.getAttribute("AS_UWYR"));
        this.session.setAttribute("UWYear", r.getAttribute("AS_UWYR"));
        this.session.setAttribute("REI_CODE", null);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.yearTF);
        ADFUtils.findIterator("findTreatySetupsIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.treatiesLOV);
        return null;
    }

    public void setArrangementYearLOV(RichTable arrangementYearLOV) {
        this.arrangementYearLOV = arrangementYearLOV;
    }

    public RichTable getArrangementYearLOV() {
        return this.arrangementYearLOV;
    }

    public void setYearTF(RichInputText yearTF) {
        this.yearTF = yearTF;
    }

    public RichInputText getYearTF() {
        return this.yearTF;
    }

    public void setTreatiesLOV(RichTable treatiesLOV) {
        this.treatiesLOV = treatiesLOV;
    }

    public RichTable getTreatiesLOV() {
        return this.treatiesLOV;
    }

    public void setTreatyPeriodLOV(RichTable treatyPeriodLOV) {
        this.treatyPeriodLOV = treatyPeriodLOV;
    }

    public RichTable getTreatyPeriodLOV() {
        return this.treatyPeriodLOV;
    }

    public void treatySelectionListener(SelectionEvent selectionEvent) {
        Object key2 = this.treatiesLOV.getSelectedRowData();
        if (key2 == null) {
            GlobalCC.errorValueNotEntered("No Record Selected");
        }
        JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
        if (r == null) {
            GlobalCC.errorValueNotEntered("No Record Selected");
        }
        this.session.setAttribute("REI_CODE", r.getAttribute("REI_CODE"));
        this.txtPremPortfolio.setValue(r.getAttribute("REI_PREM_PORTFOLIO"));
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.txtPremPortfolio);
        this.txtLossPortfolio.setValue(r.getAttribute("REI_LOSS_PORTFOLIO"));
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.txtLossPortfolio);
        ADFUtils.findIterator("findPeriodTreatySummIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.treatyPeriodLOV);
        ADFUtils.findIterator("findPeriodTreatySummIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.treatyPeriodLOV);
        ADFUtils.findIterator("findTreatySummaryIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.treatySummaryLOV);
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public HttpSession getSession() {
        return this.session;
    }

    public void setTxtPrtsFiscalYear(RichInputText txtPrtsFiscalYear) {
        this.txtPrtsFiscalYear = txtPrtsFiscalYear;
    }

    public RichInputText getTxtPrtsFiscalYear() {
        return this.txtPrtsFiscalYear;
    }

    public void setTxtPrtsUwYear(RichInputText txtPrtsUwYear) {
        this.txtPrtsUwYear = txtPrtsUwYear;
    }

    public RichInputText getTxtPrtsUwYear() {
        return this.txtPrtsUwYear;
    }

    public void setTxtPrtstrtCode(RichInputText txtPrtstrtCode) {
        this.txtPrtstrtCode = txtPrtstrtCode;
    }

    public RichInputText getTxtPrtstrtCode() {
        return this.txtPrtstrtCode;
    }

    public void setTxtPrtsTaCode(RichInputText txtPrtsTaCode) {
        this.txtPrtsTaCode = txtPrtsTaCode;
    }

    public RichInputText getTxtPrtsTaCode() {
        return this.txtPrtsTaCode;
    }

    public void setTxtPrtstaCode(RichInputText txtPrtstaCode) {
        this.txtPrtstaCode = txtPrtstaCode;
    }

    public RichInputText getTxtPrtstaCode() {
        return this.txtPrtstaCode;
    }

    public void selectTreatySummaryListener(SelectionEvent selectionEvent) {
        if (selectionEvent.getAddedSet() != selectionEvent.getRemovedSet()) {
            DCIteratorBinding binder =
                ADFUtils.findIterator("findPeriodTreatySummIterator");

            RowKeySet set = selectionEvent.getAddedSet();
            Iterator row = set.iterator();
            while (row.hasNext()) {
                List data = (List)row.next();
                Key key = (Key)data.get(0);
                binder.setCurrentRowWithKey(key.toStringFormat(true));
                Row rows = binder.getCurrentRow();
                this.txtPrtsFiscalYear.setValue(rows.getAttribute("prtsFiscalYear"));
                this.txtPrtsUwYear.setValue(rows.getAttribute("prtsUwYear"));
                this.txtPrtstrtCode.setValue(rows.getAttribute("prtsTrtCode"));
                this.txtPrtsTaCode.setValue(rows.getAttribute("prtsTaCode"));
                this.txtPrtstaCode.setValue(rows.getAttribute("prtsAsCode"));
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.txtPrtsFiscalYear);
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.txtPrtsUwYear);
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.txtPrtstrtCode);
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.txtPrtsTaCode);
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.txtPrtstaCode);
            }
        }
    }

    public String processTreatySummaries() {
        if ((BigDecimal)this.session.getAttribute("ta_code") == null) {
            GlobalCC.INFORMATIONREPORTING("Select Treaty Arrangement to proceed");
            return null;
        }
        DBConnector connection = new DBConnector();
        String query =
            "begin LMS_GRP_REINSURANCE.process_prd_treaty_summary(?,?,?,?,?,?,?,?);end;";

        CallableStatement stmt = null;
        Connection conn = null;
        BigDecimal tacode = null;
        try {
            conn = connection.getDatabaseConn();
            stmt = conn.prepareCall(query);
            stmt.setBigDecimal(1,
                               (BigDecimal)this.session.getAttribute("ta_code"));
            stmt.setString(2, (String)this.session.getAttribute("DateFrom"));
            stmt.setString(3, (String)this.session.getAttribute("DateTo"));
            if (this.txtPrtstrtCode.getValue() == null) {
                stmt.setBigDecimal(4, null);
            } else {
                stmt.setBigDecimal(4,
                                   new BigDecimal(this.txtPrtstrtCode.getValue().toString()));
            }
            if (this.txtPrtsTaCode.getValue() == null) {
                stmt.setBigDecimal(5, null);
            } else {
                stmt.setBigDecimal(5,
                                   new BigDecimal(this.txtPrtsTaCode.getValue().toString()));
            }
            if (this.txtPrtstaCode.getValue() == null) {
                stmt.setBigDecimal(6, null);
            } else {
                stmt.setBigDecimal(6,
                                   new BigDecimal(this.txtPrtstaCode.getValue().toString()));
            }
            if (this.txtPremPortfolio.getValue() == null) {
                stmt.setBigDecimal(7, null);
            } else {
                stmt.setBigDecimal(7,
                                   new BigDecimal(this.txtPremPortfolio.getValue().toString()));
            }
            if (this.txtLossPortfolio.getValue() == null) {
                stmt.setBigDecimal(8, null);
            } else {
                stmt.setBigDecimal(8,
                                   new BigDecimal(this.txtLossPortfolio.getValue().toString()));
            }
            stmt.execute();
            this.txtPrtstrtCode.setValue(null);


            GlobalCC.INFORMATIONREPORTING("Treaty Period authorized Successfull");
            ADFUtils.findIterator("findPeriodTreatySummIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.treatyPeriodLOV);
            ADFUtils.findIterator("findTreatySummaryIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.treatySummaryLOV);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
        return null;
    }

    public void setTxtPremPortfolio(RichInputText txtPremPortfolio) {
        this.txtPremPortfolio = txtPremPortfolio;
    }

    public RichInputText getTxtPremPortfolio() {
        return this.txtPremPortfolio;
    }

    public void setTxtLossPortfolio(RichInputText txtLossPortfolio) {
        this.txtLossPortfolio = txtLossPortfolio;
    }

    public RichInputText getTxtLossPortfolio() {
        return this.txtLossPortfolio;
    }

    public String searchPortfolioRecords() {
        if ((this.dateFrom.getValue() == null) ||
            (this.dateTo.getValue() == null)) {
            GlobalCC.INFORMATIONREPORTING("Please select date from and date to.");
            return null;
        }
        this.session.setAttribute("DateFrom",
                                  GlobalCC.parseDate(this.dateFrom.getValue().toString()));

        this.session.setAttribute("DateTo",
                                  GlobalCC.parseDate(this.dateTo.getValue().toString()));

        this.session.setAttribute("dateFrom",
                                  GlobalCC.parseDate(this.dateFrom.getValue().toString()));

        this.session.setAttribute("dateTo",
                                  GlobalCC.parseDate(this.dateTo.getValue().toString()));

        if (this.periodDateFrom.getValue() != null) {
            this.session.setAttribute("periodFrom",
                                      GlobalCC.parseDate(this.periodDateFrom.getValue().toString()));
        } else {
            this.session.setAttribute("periodFrom", null);
        }

        if (this.periodDateTo.getValue() != null) {
            this.session.setAttribute("periodTo",
                                      GlobalCC.parseDate(this.periodDateTo.getValue().toString()));
        } else {
            this.session.setAttribute("periodTo", null);
        }

        ADFUtils.findIterator("findPeriodTreatySummIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.treatyPeriodLOV);
        ADFUtils.findIterator("findTreatySummaryIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.treatySummaryLOV);
        ADFUtils.findIterator("findRecoveryPrdSummIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.riRecoveryDAO);
        ADFUtils.findIterator("findCoinsurancePrdSummIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.coinsuranceDAO);
        //refreshDocumentComponents();
        //AdfFacesContext.getCurrentInstance().addPartialTarget(this.policyClaimsDocsTbl);

        return null;
    }

    private void refreshDocumentComponents() {
        //        ADFUtils.findIterator("EducateOrgDictionaryView2Iterator").executeQuery();
        //        ADFUtils.findIterator("EducateOrgAvailDictionaryView1Iterator").executeQuery();
        System.out.println("Refreshing dms documents iterator...");
        DCIteratorBinding availIter =
            ADFUtils.findIterator("claimsDocsIterator");
        // availIter.executeQuery(); // doesn't work
        availIter.getViewObject().executeQuery();

        DCIteratorBinding availIter1 =
            ADFUtils.findIterator("paymentDocumentsIterator");
        // availIter.executeQuery(); // doesn't work
        availIter1.getViewObject().executeQuery();

    }

    public void setDateFrom(RichInputDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public RichInputDate getDateFrom() {
        return this.dateFrom;
    }

    public void setDateTo(RichInputDate dateTo) {
        this.dateTo = dateTo;
    }

    public RichInputDate getDateTo() {
        return this.dateTo;
    }

    public void setSelectParticipant(RichSelectBooleanCheckbox selectParticipant) {
        this.selectParticipant = selectParticipant;
    }

    public RichSelectBooleanCheckbox getSelectParticipant() {
        return this.selectParticipant;
    }

    public String raiseRIRequisition() {
        DBConnector connection = new DBConnector();
        CallableStatement stmt = null;
        Connection conn = null;
        BigDecimal tacode = null;
        int k = 0;
        conn = connection.getDatabaseConn();
        if ((BigDecimal)this.session.getAttribute("ta_code") == null) {
            GlobalCC.INFORMATIONREPORTING("Select Treaty Arrangement to Process");
            return null;
        }
        DCIteratorBinding dciter =
            ADFUtils.findIterator("findTreatySummaryIterator");

        RowKeySet set = this.treatySummaryLOV.getSelectedRowKeys();

        Iterator rowKeySetIter = set.iterator();
        try {
            String query =
                "begin LMS_GRP_REINSURANCE.processripayment(?,?,?,?,?);end;";
            while (k < this.treatySummaryLOV.getRowCount()) {
                JUCtrlValueBinding r =
                    (JUCtrlValueBinding)this.treatySummaryLOV.getRowData(k);
                if (r == null) {
                    GlobalCC.errorValueNotEntered("No Record Selected");
                    conn.close();
                    return null;
                }
                if ((!r.getAttribute("status").equals("Paid")) &&
                    (r.getAttribute("TS_DRCR").equals("Cr"))) {
                    stmt = conn.prepareCall(query);
                    stmt.setBigDecimal(1,
                                       (BigDecimal)this.session.getAttribute("ta_code"));

                    stmt.setString(2,
                                   (String)this.session.getAttribute("DateFrom"));

                    stmt.setString(3,
                                   (String)this.session.getAttribute("DateTo"));
                    stmt.setBigDecimal(4,
                                       (BigDecimal)this.session.getAttribute("brnCode"));

                    stmt.setBigDecimal(5,
                                       (BigDecimal)r.getAttribute("TS_CODE"));

                    stmt.execute();
                }
                k++;
            }
            conn.close();
            ADFUtils.findIterator("findPeriodTreatySummIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.treatyPeriodLOV);
            ADFUtils.findIterator("findTreatySummaryIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.treatySummaryLOV);
            GlobalCC.INFORMATIONREPORTING("Requisition raised successfully");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
            e.printStackTrace();
        }
        return null;
    }

    public void setTreatySummaryLOV(RichTable treatySummaryLOV) {
        this.treatySummaryLOV = treatySummaryLOV;
    }

    public RichTable getTreatySummaryLOV() {
        return this.treatySummaryLOV;
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

    public void setBrhLOV(RichTable brhLOV) {
        this.brhLOV = brhLOV;
    }

    public RichTable getBrhLOV() {
        return this.brhLOV;
    }

    public void setBrhDisplay(RichInputText brhDisplay) {
        this.brhDisplay = brhDisplay;
    }

    public RichInputText getBrhDisplay() {
        return this.brhDisplay;
    }

    public String showReceiptPop() {
        Object key2 = this.treatySummaryLOV.getSelectedRowData();
        if (key2 == null) {
            GlobalCC.errorValueNotEntered("No Record Selected");
            return null;
        }
        JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
        if (r == null) {
            GlobalCC.errorValueNotEntered("No Record Selected");
            return null;
        }
        this.session.setAttribute("tsCode", r.getAttribute("TS_CODE"));
        ADFUtils.findIterator("findRIReceiptsIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.receiptsDAO);
        GlobalCC.showPopup("lmsgroup:riReceipts");
        return null;
    }

    public String exitPopup() {
        this.session.setAttribute("tsCode", null);
        GlobalCC.hidePopup("lmsgroup:riReceipts");
        return null;
    }

    public void setReceiptsDAO(RichTable receiptsDAO) {
        this.receiptsDAO = receiptsDAO;
    }

    public RichTable getReceiptsDAO() {
        return this.receiptsDAO;
    }

    public void markCheckBox(SelectionEvent selectionEvent) {
        this.selectParticipant.setSelected(true);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.selectParticipant);
    }

    public void setRiRecoveryDAO(RichTable riRecoveryDAO) {
        this.riRecoveryDAO = riRecoveryDAO;
    }

    public RichTable getRiRecoveryDAO() {
        return this.riRecoveryDAO;
    }

    public void setRiCeding(RichSelectBooleanRadio riCeding) {
        this.riCeding = riCeding;
    }

    public RichSelectBooleanRadio getRiCeding() {
        return this.riCeding;
    }

    public void setRiRecovery(RichSelectBooleanRadio riRecovery) {
        this.riRecovery = riRecovery;
    }

    public RichSelectBooleanRadio getRiRecovery() {
        return this.riRecovery;
    }

    public void setCoinRecovery(RichSelectBooleanRadio coinRecovery) {
        this.coinRecovery = coinRecovery;
    }

    public RichSelectBooleanRadio getCoinRecovery() {
        return this.coinRecovery;
    }

    public String RedirectPolicyTrans() {
        try {
            Links MyLink = new Links();
            String RecoveryType = null;
            if (this.riCeding.isSelected()) {
                RecoveryType = "riCeding";
            } else if (this.riRecovery.isSelected()) {
                RecoveryType = "riRecovery";
            } else if (this.coinRecovery.isSelected()) {
                RecoveryType = "coinRecovery";
            } else {
                GlobalCC.INFORMATIONREPORTING("Select A Transaction");
                return null;
            }
            this.session.setAttribute("recTrans", RecoveryType);
            GlobalCC.RedirectPage("/portfolioTrans.jspx");
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
            e.printStackTrace();
        }
        return null;
    }

    public void setRiPanel(RichPanelBox riPanel) {
        this.riPanel = riPanel;
    }

    public RichPanelBox getRiPanel() {
        return this.riPanel;
    }

    public void setCoinsuranceDAO(RichTable coinsuranceDAO) {
        this.coinsuranceDAO = coinsuranceDAO;
    }

    public RichTable getCoinsuranceDAO() {
        return this.coinsuranceDAO;
    }

    public String processCoinRecovery() {
        int count = coinsuranceDAO.getRowCount();
        DBConnector connection = new DBConnector();
        String voucherNo = voucherNo();
        String query =
            "begin LMS_GRP_REINSURANCE.updatecoinsuranceprocessing(?,?);end;";

        for (int i = 0; i < count; i++) {
            JUCtrlValueBinding nodeBinding =
                (JUCtrlValueBinding)coinsuranceDAO.getRowData(i);
            if (nodeBinding.getAttribute("coinSelect").equals(true)) {
                System.out.println("ccvt_code " +
                                   nodeBinding.getAttribute("ccvtCode"));
                CallableStatement stmt = null;
                Connection conn = null;
                try {
                    conn = connection.getDatabaseConn();
                    stmt = conn.prepareCall(query);
                    stmt.setBigDecimal(1,
                                       (BigDecimal)nodeBinding.getAttribute("ccvtCode"));

                    stmt.setString(2, voucherNo);
                    stmt.execute();
                } catch (Exception e) {
                    GlobalCC.EXCEPTIONREPORTING(conn, e);
                } finally {
                    GlobalCC.CloseConnections(null, stmt, conn);
                }
            }

        }

        generateCoinsuranceDebit(voucherNo);
        //GlobalCC.INFORMATIONREPORTING("Coinsnurance debit generated");
        ADFUtils.findIterator("findCoinsurancePrdSummIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.coinsuranceDAO);
        ADFUtils.findIterator("findTreatySummaryIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.treatySummaryLOV);
        return null;
    }

    public void setCoinAmtTF(RichInputText coinAmtTF) {
        this.coinAmtTF = coinAmtTF;
    }

    public RichInputText getCoinAmtTF() {
        return this.coinAmtTF;
    }

    public void setReinAmtTF(RichInputText reinAmtTF) {
        this.reinAmtTF = reinAmtTF;
    }

    public RichInputText getReinAmtTF() {
        return this.reinAmtTF;
    }

    public void coinAmtSelection(ValueChangeEvent valueChangeEvent) {
        if (valueChangeEvent.getOldValue() != valueChangeEvent.getNewValue()) {
            Object key2 = this.coinsuranceDAO.getSelectedRowData();
            BigDecimal ccrCode = null;
            if (key2 == null) {
                GlobalCC.errorValueNotEntered("No Record Selected");
            }
            JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
            if (r == null) {
                GlobalCC.errorValueNotEntered("No Record Selected");
            }
            ccrCode = (BigDecimal)r.getAttribute("ccrCode");


            DBConnector connection = new DBConnector();
            String query =
                "begin LMS_GRP_REINSURANCE.updateCoinsuranceRecovery(?,?,?);end;";

            CallableStatement stmt = null;
            Connection conn = null;
            try {
                conn = connection.getDatabaseConn();
                stmt = conn.prepareCall(query);
                stmt.setString(1, (String)r.getAttribute("coinRefNo"));
                stmt.setBigDecimal(2, (BigDecimal)this.coinAmtTF.getValue());
                stmt.setBigDecimal(3, (BigDecimal)r.getAttribute("ccvtCode"));
                stmt.execute();
                ADFUtils.findIterator("findCoinsurancePrdSummIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.coinsuranceDAO);
                ADFUtils.findIterator("findTreatySummaryIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.treatySummaryLOV);
            } catch (Exception e) {
                GlobalCC.EXCEPTIONREPORTING(conn, e);
            }
        }
    }

    public void setRiSelect(RichSelectBooleanCheckbox riSelect) {
        this.riSelect = riSelect;
    }

    public RichSelectBooleanCheckbox getRiSelect() {
        return this.riSelect;
    }

    public void setCoinSelect(RichSelectBooleanCheckbox coinSelect) {
        this.coinSelect = coinSelect;
    }

    public RichSelectBooleanCheckbox getCoinSelect() {
        return this.coinSelect;
    }

    public String voucherNo() {
        String voucherNo = null;
        DBConnector connection = new DBConnector();
        String query = "select lms_api.trans_voucher ('COIN') from dual";
        CallableStatement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = connection.getDatabaseConn();
            stmt = conn.prepareCall(query);
            rs = stmt.executeQuery();
            while (rs.next()) {
                voucherNo = rs.getString(1);
            }
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
            e.printStackTrace();
        } finally {
            GlobalCC.CloseConnections(rs, stmt, conn);
        }
        return voucherNo;
    }

    public void generateCoinsuranceDebit(String voucherNo) {
        DBConnector connection = new DBConnector();
        String query =
            "begin LMS_GRP_REINSURANCE.process_prd_coin_summary(?,?,?);end;";
        CallableStatement stmt = null;
        Connection conn = null;
        try {
            conn = connection.getDatabaseConn();
            stmt = conn.prepareCall(query);
            stmt.setString(1, (String)this.session.getAttribute("DateFrom"));
            stmt.setString(2, (String)this.session.getAttribute("DateTo"));
            stmt.setString(3, voucherNo);
            stmt.execute();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
            e.printStackTrace();
        } finally {
            GlobalCC.CloseConnections(null, stmt, conn);
        }
    }

    public String processReinRecovery() {
        int count = riRecoveryDAO.getRowCount();
        DBConnector connection = new DBConnector();
        String voucherNo = riVoucherNo();
        String query =
            "begin LMS_GRP_REINSURANCE.updateReinsuranceprocessing(?,?,?);end;";

        for (int i = 0; i < count; i++) {
            JUCtrlValueBinding nodeBinding =
                (JUCtrlValueBinding)riRecoveryDAO.getRowData(i);
            if (nodeBinding.getAttribute("riSelect").equals(true)) {
              CallableStatement stmt = null;
              Connection conn = null;
              try {
                  conn = connection.getDatabaseConn();
                  stmt = conn.prepareCall(query);
                  stmt.setString(1, (String)nodeBinding.getAttribute("refNo"));

                  stmt.setString(2, voucherNo);
                  stmt.setBigDecimal(3,
                                     (BigDecimal)nodeBinding.getAttribute("ccvtCode"));
                  stmt.execute();
              } catch (Exception e) {
                  GlobalCC.EXCEPTIONREPORTING(conn, e);
              } finally {
                  GlobalCC.CloseConnections(null, stmt, conn);
              }
            }
        }
        generateReinsuranceDebit(voucherNo);
        GlobalCC.INFORMATIONREPORTING("Treaty Period authorized Successfull");
        ADFUtils.findIterator("findRecoveryPrdSummIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.treatyPeriodLOV);
        ADFUtils.findIterator("findTreatySummaryIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.treatySummaryLOV);
        return null;
    }

    public String riVoucherNo() {
        String voucherNo = null;
        DBConnector connection = new DBConnector();
        String query = "select lms_api.trans_voucher ('REIN') from dual";
        CallableStatement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = connection.getDatabaseConn();
            stmt = conn.prepareCall(query);
            rs = stmt.executeQuery();
            while (rs.next()) {
                voucherNo = rs.getString(1);
            }
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
            e.printStackTrace();
        } finally {
            GlobalCC.CloseConnections(rs, stmt, conn);
        }
        return voucherNo;
    }

    public void generateReinsuranceDebit(String voucherNo) {
        DBConnector connection = new DBConnector();
        String query =
            "begin LMS_GRP_REINSURANCE.process_prd_reco_summary(?,?,?,?);end;";
        CallableStatement stmt = null;
        Connection conn = null;
        try {
            conn = connection.getDatabaseConn();
            stmt = conn.prepareCall(query);
            stmt.setBigDecimal(1,
                               (BigDecimal)this.session.getAttribute("ta_code"));
            stmt.setString(2, (String)this.session.getAttribute("DateFrom"));
            stmt.setString(3, (String)this.session.getAttribute("DateTo"));
            stmt.setString(4, voucherNo);
            stmt.execute();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
            e.printStackTrace();
        } finally {
            GlobalCC.CloseConnections(null, stmt, conn);
        }
    }

    public void voucherSelection(SelectionEvent selectionEvent) {
        if (selectionEvent.getAddedSet() != selectionEvent.getRemovedSet()) {
            Object key2 = this.treatySummaryLOV.getSelectedRowData();
            BigDecimal ccrCode = null;
            if (key2 == null) {
                GlobalCC.errorValueNotEntered("No Record Selected");
            }
            JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
            if (r == null) {
                GlobalCC.errorValueNotEntered("No Record Selected");
            }
            this.session.setAttribute("voucherNo",
                                      r.getAttribute("TS_VOUCHER_NO"));
           this.session.setAttribute("drcrNo", r.getAttribute("TS_DRCR_NO"));                           
        }
    }

    public void importExcelData(InputStream csvFile) {
        String[][] csvvalues = (String[][])null;
        try {
            csvvalues = CSVParser.parse(new InputStreamReader(csvFile));

            System.out.println("Array length is " + csvvalues.length);
            for (int i = 1; i < csvvalues.length; i++) {
                String Result = GlobalCC.parseDateAuthFormat(csvvalues[i][3]);
                if (Result.equalsIgnoreCase("Invalid Date Format")) {
                    GlobalCC.errorValueNotEntered("Invalid Date Format " +
                                                  csvvalues[i][3] +
                                                  ". The Valid Date Format is DD-MMM-YYYY");

                    return;
                }
                BigDecimal amtAllocate = new BigDecimal(csvvalues[i][2]);
                allocateValues((String)this.session.getAttribute("recTrans"),
                               csvvalues[i][0], csvvalues[i][1], amtAllocate,
                               csvvalues[i][3]);
            }
            ADFUtils.findIterator("findTreatySummaryIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.treatySummaryLOV);
            GlobalCC.INFORMATIONREPORTING("Allocation successfully done");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void allocateValues(String type, String debitNote, String claimNo,
                               BigDecimal amountAllocated,
                               String dateReceived) {
        DBConnector connection = new DBConnector();
        String query =
            "begin LMS_GRP_REINSURANCE.updateclaimrecoveryalloc(?,?,?,?,?);end;";
        CallableStatement stmt = null;
        Connection conn = null;
        try {
            conn = connection.getDatabaseConn();
            stmt = conn.prepareCall(query);
            stmt.setString(1, type);
            stmt.setString(2, debitNote);
            stmt.setString(3, claimNo);
            stmt.setBigDecimal(4, amountAllocated);
            stmt.setString(5, dateReceived);
            stmt.execute();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
            e.printStackTrace();
        } finally {
            GlobalCC.CloseConnections(null, stmt, conn);
        }
    }

    public void reinAmtSelection(ValueChangeEvent valueChangeEvent) {
        if (valueChangeEvent.getOldValue() != valueChangeEvent.getNewValue()) {
            Object key2 = this.riRecoveryDAO.getSelectedRowData();
            String claimNo = null;
            String coverDesc = null;
            BigDecimal ccvtCode = null;

            if (key2 == null) {
                GlobalCC.errorValueNotEntered("No Record Selected");
            }
            JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
            if (r == null) {
                GlobalCC.errorValueNotEntered("No Record Selected");
            }
            claimNo = (String)r.getAttribute("refNo");
            coverDesc = (String)r.getAttribute("coverDesc");
            ccvtCode = (BigDecimal)r.getAttribute("ccvtCode");

            DBConnector connection = new DBConnector();
            String query =
                "begin LMS_GRP_REINSURANCE.updatereinsurancerecovery(?,?,?);end;";

            CallableStatement stmt = null;
            Connection conn = null;
            try {
                conn = connection.getDatabaseConn();
                stmt = conn.prepareCall(query);
                stmt.setString(1, claimNo);
                stmt.setBigDecimal(2, (BigDecimal)this.reinAmtTF.getValue());
                stmt.setBigDecimal(3, ccvtCode);
                stmt.execute();
                ADFUtils.findIterator("findRecoveryPrdSummIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.riRecoveryDAO);
                ADFUtils.findIterator("findTreatySummaryIterator").executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.treatySummaryLOV);
            } catch (Exception e) {
                GlobalCC.EXCEPTIONREPORTING(conn, e);
            }
        }
    }

    public void recoverySelectionListener(SelectionEvent selectionEvent) {
        // Add event code here...
        try {
            Object key2 = this.riRecoveryDAO.getSelectedRowData();
            String claimNo = null;
            String coverDesc = null;
            if (key2 == null) {
                GlobalCC.errorValueNotEntered("No Record Selected");
            }
            JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
            if (r == null) {
                GlobalCC.errorValueNotEntered("No Record Selected");
            }
            System.out.println("The claim number is......" +
                               r.getAttribute("refNo"));
            session.setAttribute("ClaimNo", r.getAttribute("refNo"));

            refreshDocumentComponents();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.policyClaimsDocsTbl);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.paymentDocTbl);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void setPolicyClaimsDocsTbl(RichTable policyClaimsDocsTbl) {
        this.policyClaimsDocsTbl = policyClaimsDocsTbl;
    }

    public RichTable getPolicyClaimsDocsTbl() {
        return this.policyClaimsDocsTbl;
    }

    public String viewUwClaimDocs() {
        Object key2 = this.policyClaimsDocsTbl.getSelectedRowData();
        JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
        if (r == null) {
            GlobalCC.errorValueNotEntered("No Record Selected");
            return null;
        }
        String id = (String)r.getAttribute("id");
        this.session.setAttribute("dcmDocId", r.getAttribute("id"));
        //System.out.println(id);
        String[] ids = id.split(";");
        String finalId = "";
        if (ids.length > 1) {
            finalId = ids[0];
        } else {
            finalId = id;
        }
        try {
            ServletContext servletContext =
                (ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext();


            HttpServletRequest request =
                (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();

            String urlss =
                request.getScheme() + "://" + request.getServerName() + ":" +
                request.getServerPort() + servletContext.getContextPath();


            //System.out.println("Url " + urlss);
            String finalUrl = urlss + "/web/viewer.html?";
            String filename = (String)r.getAttribute("actualName");
            ListDocByte docByte = getClientDocuments(finalId);
            this.session.setAttribute("docDocType", docByte.getDocMimetype());
            this.session.setAttribute("docBase24String",
                                      docByte.getByteData());

            if ("image/jpeg".equalsIgnoreCase(docByte.getDocMimetype()) ||
                "image/png".equalsIgnoreCase(docByte.getDocMimetype()) ||
                "application/pdf".equalsIgnoreCase(docByte.getDocMimetype()) ||
                "application/msword".equalsIgnoreCase(docByte.getDocMimetype()) ||
                "application/vnd.ms-excel".equalsIgnoreCase(docByte.getDocMimetype())) {

                finalUrl = finalUrl + "file=" + urlss + "/docServlet";
                session.setAttribute("toPrint", finalUrl);
                //createInputTextComponent();
                GlobalCC.showPopup("lmsgroup:p300");
            } else {
                String extension =
                    getKeyByValue(mimeTypes, docByte.getDocMimetype());
                HttpServletResponse response =
                    (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
                byte[] decodeResult =
                    new BASE64Decoder().decodeBuffer(docByte.getByteData());
                response.setContentType(docByte.getDocMimetype());
                response.setContentLength(decodeResult.length);
                response.setHeader("Content-disposition",
                                   "attachment; filename=\"" + filename +
                                   extension + "\"");
                response.getOutputStream().write(decodeResult);
                response.getOutputStream().flush();
                response.getOutputStream().close();
            }
        } catch (Exception e) {
        }
        return null;
    }

    private <T, E> T getKeyByValue(Map<T, E> map, E value) {
        for (Map.Entry<T, E> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public ListDocByte getClientDocuments(String docId) {
        ListDocByte documents = null;
        DMSUtils utils = new DMSUtils();

        String documentPath =
            utils.findDmsUrl() + "/" + "getGroupDocsBydocId?docId=" + docId;
        try {
            URL url = new URL(documentPath);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " +
                                           conn.getResponseCode());
            }
            BufferedReader br =
                new BufferedReader(new InputStreamReader(conn.getInputStream()));


            //System.out.println("Output from Server .... \n");
            String output;
            while ((output = br.readLine()) != null) {
                //System.out.println(output);
                Gson gson = new GsonBuilder().create();
                documents =
                        (ListDocByte)gson.fromJson(output.toString(), ListDocByte.class);
            }
            conn.disconnect();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return documents;
    }

    public String viewClaimComments() {
        Object key2 = this.policyClaimsDocsTbl.getSelectedRowData();
        JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
        if (r == null) {
            GlobalCC.errorValueNotEntered("No Record Selected");
            return null;
        }
        String id = (String)r.getAttribute("id");


        String[] ids = id.split(";");
        String finalId = "";
        if (ids.length > 1) {
            finalId = ids[0];
        } else {
            finalId = id;
        }
        this.session.setAttribute("dcmDocId", finalId);
        ADFUtils.findIterator("documentCommentsIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.commentTbl);
        ExtendedRenderKitService erkService =
            (ExtendedRenderKitService)Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                                         ExtendedRenderKitService.class);


        erkService.addScript(FacesContext.getCurrentInstance(),
                             "var hints = {autodismissNever:false}; AdfPage.PAGE.findComponent('groupTemplate:commentPop').show(hints);");


        return null;
    }

    public void setCommentTbl(RichTable commentTbl) {
        this.commentTbl = commentTbl;
    }

    public RichTable getCommentTbl() {
        return commentTbl;
    }

    public String downloadClaimDocuments() {
        DocIEdmsBack iedmsBack = new DocIEdmsBack();
        // Add event code here...
        Object key2 = this.policyClaimsDocsTbl.getSelectedRowData();
        JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
        if (r == null) {
            GlobalCC.errorValueNotEntered("No Record Selected");
            return null;
        }
        try {
            iedmsBack.downloadDmsDocs((String)r.getAttribute("id"),
                                      (String)r.getAttribute("actualName"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void setDocFrame2(RichInlineFrame docFrame2) {
        this.docFrame2 = docFrame2;
    }

    public RichInlineFrame getDocFrame2() {
        return docFrame2;
    }

    public void setDocFrame3(RichInlineFrame docFrame3) {
        this.docFrame3 = docFrame3;
    }

    public RichInlineFrame getDocFrame3() {
        return docFrame3;
    }

    public String showCommentPanel() {
        // Add event code here...
        // commentRTF.setVisible(true);
        // saveCommentBtn.setVisible(true);
        //cancelCommentBtn.setVisible(true);
        //addComment.setVisible(false);
        // AdfFacesContext.getCurrentInstance().addPartialTarget(this.commentRTF);
        // AdfFacesContext.getCurrentInstance().addPartialTarget(this.saveCommentBtn);
        // AdfFacesContext.getCurrentInstance().addPartialTarget(this.cancelCommentBtn);
        //AdfFacesContext.getCurrentInstance().addPartialTarget(this.addComment);
        return null;
    }

    public String viewPaymentDocs() {
        Object key2 = this.paymentDocTbl.getSelectedRowData();
        JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
        if (r == null) {
            GlobalCC.errorValueNotEntered("No Record Selected");
            return null;
        }
        String id = (String)r.getAttribute("id");
        this.session.setAttribute("dcmDocId", r.getAttribute("id"));
        //System.out.println(id);
        String[] ids = id.split(";");
        String finalId = "";
        if (ids.length > 1) {
            finalId = ids[0];
        } else {
            finalId = id;
        }
        try {
            ServletContext servletContext =
                (ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext();


            HttpServletRequest request =
                (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();

            String urlss =
                request.getScheme() + "://" + request.getServerName() + ":" +
                request.getServerPort() + servletContext.getContextPath();


            //System.out.println("Url " + urlss);
            String finalUrl = urlss + "/web/viewer.html?";
            String filename = (String)r.getAttribute("actualName");
            ListDocByte docByte = getClientDocuments(finalId);
            this.session.setAttribute("docDocType", docByte.getDocMimetype());
            this.session.setAttribute("docBase24String",
                                      docByte.getByteData());

            if ("image/jpeg".equalsIgnoreCase(docByte.getDocMimetype()) ||
                "image/png".equalsIgnoreCase(docByte.getDocMimetype()) ||
                "application/pdf".equalsIgnoreCase(docByte.getDocMimetype()) ||
                "application/msword".equalsIgnoreCase(docByte.getDocMimetype()) ||
                "application/vnd.ms-excel".equalsIgnoreCase(docByte.getDocMimetype())) {

                finalUrl = finalUrl + "file=" + urlss + "/docServlet";
                session.setAttribute("toPrint", finalUrl);
                GlobalCC.showPopup("lmsgroup:p300");
            } else {
                String extension =
                    getKeyByValue(mimeTypes, docByte.getDocMimetype());
                HttpServletResponse response =
                    (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
                byte[] decodeResult =
                    new BASE64Decoder().decodeBuffer(docByte.getByteData());
                response.setContentType(docByte.getDocMimetype());
                response.setContentLength(decodeResult.length);
                response.setHeader("Content-disposition",
                                   "attachment; filename=\"" + filename +
                                   extension + "\"");
                response.getOutputStream().write(decodeResult);
                response.getOutputStream().flush();
                response.getOutputStream().close();
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void setPaymentDocTbl(RichTable paymentDocTbl) {
        this.paymentDocTbl = paymentDocTbl;
    }

    public RichTable getPaymentDocTbl() {
        return paymentDocTbl;
    }

    public String downloadPaymentDocuments() {
        // Add event code here...
        DocIEdmsBack iedmsBack = new DocIEdmsBack();
        Object key2 = this.paymentDocTbl.getSelectedRowData();
        JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
        if (r == null) {
            GlobalCC.errorValueNotEntered("No Record Selected");
            return null;
        }
        String id = (String)r.getAttribute("id");
        String actualName = (String)r.getAttribute("actualName");
        System.out.println(id + "===========" + actualName);
        try {
            iedmsBack.downloadDmsDocs(id, actualName);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public String downClaimDocuments() {
        HashMap<String, String> map = new HashMap<String, String>();
        FacesContext context = FacesContext.getCurrentInstance();
        ServletContext sc =
            (ServletContext)context.getExternalContext().getContext();

        int count = policyClaimsDocsTbl.getRowCount();
        // System.out.println("count=====" + count);
        for (int i = 0; i < count; i++) {
            JUCtrlValueBinding nodeBinding =
                (JUCtrlValueBinding)policyClaimsDocsTbl.getRowData(i);
            if (nodeBinding.getAttribute("selectDoc").equals(true)) {
                map.put(nodeBinding.getAttribute("id").toString(),
                        nodeBinding.getAttribute("actualName").toString());
            }
        }

        int paymentCount = paymentDocTbl.getRowCount();
        for (int i = 0; i < paymentCount; i++) {
            JUCtrlValueBinding nodeBinding =
                (JUCtrlValueBinding)paymentDocTbl.getRowData(i);
            if (nodeBinding.getAttribute("selectFinanceDoc").equals(true)) {
                map.put(nodeBinding.getAttribute("id").toString(),
                        nodeBinding.getAttribute("actualName").toString());
            }
        }

        if (map.size() != 0) {
            try {
                DMSUtils utils = new DMSUtils();
                ArrayList<String> claimMetadata = new ArrayList();
                claimMetadata = utils.getClaimMetadata();
                String claimNo =
                    this.session.getAttribute("ClaimNo").toString().replaceAll("/",
                                                                               "");
                String policyId =
                    (String)claimMetadata.get(0).toString().replaceAll("/",
                                                                       "");
                String memNo =
                    (String)claimMetadata.get(1).trim().toString().replaceAll("/",
                                                                              "").replaceAll("'",
                                                                                             "");
                String clientName =
                    (String)claimMetadata.get(2).trim().toString().replaceAll("/",
                                                                              "").replaceAll("'",
                                                                                             "");
                String memberName =
                    (String)claimMetadata.get(3).trim().toString().replaceAll("/",
                                                                              "").replaceAll("'",
                                                                                             "");
                String zipFolderName =
                    memNo + "-" + claimNo + "-" + memberName + ".zip";
                System.out.println("The folder name is " + zipFolderName);
                //String zipFolderName = "testdownload.zip";
                String outFilename =
                    sc.getRealPath("/Reports/" + zipFolderName);
                ZipOutputStream zout =
                    new ZipOutputStream(new FileOutputStream(outFilename));
                ZipEntry zipEntry = null;

                for (Map.Entry m : map.entrySet()) {
                    ListDocByte docByte =
                        getClientDocuments(m.getKey().toString());
                    String filename = m.getValue().toString();

                    byte[] decodeResult =
                        new BASE64Decoder().decodeBuffer(docByte.getByteData());
                    zipEntry = new ZipEntry(filename);
                    zout.putNextEntry(zipEntry);
                    zout.write(decodeResult);
                }
                zout.closeEntry();
                zout.flush();
                zout.close();

                HttpServletResponse response =
                    (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
                File file = new File(outFilename);
                if (!file.exists()) {
                    System.out.println("file not found");
                }
                response.setContentType("APPLICATION/OCTET-STREAM");
                response.setHeader("Content-Disposition",
                                   "attachment; filename=\"" + zipFolderName +
                                   "\"");

                OutputStream out = response.getOutputStream();
                FileInputStream in = new FileInputStream(file);
                byte[] buffer = new byte[4096];
                int length;
                while ((length = in.read(buffer)) > 0) {
                    out.write(buffer, 0, length);
                }
                in.close();
                out.flush();
                file.delete();
                return null;
            } catch (Exception ex) {
                ex.printStackTrace();

            }
        } else {
            GlobalCC.INFORMATIONREPORTING("You have not selected any document .....kindly select to download...");
        }

        return null;
    }

    public void coinsuranceRecovery(SelectionEvent selectionEvent) {
        // Add event code here...
        try {
            Object key2 = this.coinsuranceDAO.getSelectedRowData();
            String claimNo = null;
            String coverDesc = null;
            if (key2 == null) {
                GlobalCC.errorValueNotEntered("No Record Selected");
            }
            JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
            if (r == null) {
                GlobalCC.errorValueNotEntered("No Record Selected");
            }
            System.out.println("The claim number is......" +
                               r.getAttribute("coinRefNo"));
            session.setAttribute("ClaimNo", r.getAttribute("coinRefNo"));

            refreshDocumentComponents();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.policyClaimsDocsTbl);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.paymentDocTbl);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public String selectAllRIRecovery() {
        // Add event code here...
        return null;
    }

    public String unselectAllRIRecoveries() {
        // Add event code here...
        return null;
    }

    public void setRiSelectChk(RichSelectBooleanCheckbox riSelectChk) {
        this.riSelectChk = riSelectChk;
    }

    public RichSelectBooleanCheckbox getRiSelectChk() {
        return riSelectChk;
    }

    public void selectAllRiColumns(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        int count = riRecoveryDAO.getRowCount();
        boolean isSelected = riSelectChk.isSelected();
        System.out.println("Ri checkbox " + isSelected + "  count==" + count);
        if (isSelected) {
            for (int i = 0; i < count; i++) {
                JUCtrlValueBinding nodeBinding =
                    (JUCtrlValueBinding)riRecoveryDAO.getRowData(i);
                nodeBinding.setAttribute("riSelect", true);
            }
        } else {
            for (int i = 0; i < count; i++) {
                JUCtrlValueBinding nodeBinding =
                    (JUCtrlValueBinding)riRecoveryDAO.getRowData(i);
                nodeBinding.setAttribute("riSelect", false);
            }
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.riRecoveryDAO);

    }

    public void setClaimDocumentsSelect(RichSelectBooleanCheckbox claimDocumentsSelect) {
        this.claimDocumentsSelect = claimDocumentsSelect;
    }

    public RichSelectBooleanCheckbox getClaimDocumentsSelect() {
        return claimDocumentsSelect;
    }

    public void selectClaimDocListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        boolean isSelected = claimDocumentsSelect.isSelected();
        String docSelected = "N";
        if (isSelected) {
            docSelected = "Y";
        }
        refreshDocumentComponents_claims(docSelected);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.policyClaimsDocsTbl);
    }

    private void refreshDocumentComponents_claims(String selectAll) {
        System.out.println("The select value is " + selectAll);
        session.setAttribute("selectAllDocs", selectAll);

        DCIteratorBinding availIter =
            ADFUtils.findIterator("claimsDocsIterator");
        // availIter.executeQuery(); // doesn't work
        availIter.getViewObject().executeQuery();

        DCIteratorBinding availIter1 =
            ADFUtils.findIterator("paymentDocumentsIterator");
        // availIter.executeQuery(); // doesn't work
        availIter1.getViewObject().executeQuery();

    }

    public void setCoinsuranceSelect(RichSelectBooleanCheckbox coinsuranceSelect) {
        this.coinsuranceSelect = coinsuranceSelect;
    }

    public RichSelectBooleanCheckbox getCoinsuranceSelect() {
        return coinsuranceSelect;
    }

    public void coinsuranceSelectListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        int count = coinsuranceDAO.getRowCount();
        boolean isSelected = coinsuranceSelect.isSelected();
        System.out.println("Coinsurance checkbox " + isSelected + "  count==" +
                           count);
        if (isSelected) {
            for (int i = 0; i < count; i++) {
                JUCtrlValueBinding nodeBinding =
                    (JUCtrlValueBinding)coinsuranceDAO.getRowData(i);
                nodeBinding.setAttribute("coinSelect", true);
            }
        } else {
            for (int i = 0; i < count; i++) {
                JUCtrlValueBinding nodeBinding =
                    (JUCtrlValueBinding)coinsuranceDAO.getRowData(i);
                nodeBinding.setAttribute("coinSelect", false);
            }
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.coinsuranceDAO);
    }

    public String selectAllClaimDocs() {
        int count = policyClaimsDocsTbl.getRowCount();
        // System.out.println("count=====" + count);
        for (int i = 0; i < count; i++) {
            JUCtrlValueBinding nodeBinding =
                (JUCtrlValueBinding)policyClaimsDocsTbl.getRowData(i);
            nodeBinding.setAttribute("selectDoc", true);
        }

        int paymentCount = paymentDocTbl.getRowCount();
        for (int i = 0; i < paymentCount; i++) {
            JUCtrlValueBinding nodeBinding =
                (JUCtrlValueBinding)paymentDocTbl.getRowData(i);
            nodeBinding.setAttribute("selectFinanceDoc", true);
        }

        AdfFacesContext.getCurrentInstance().addPartialTarget(this.policyClaimsDocsTbl);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.paymentDocTbl);

        return null;
    }

    public String unselectAllClaimDocs() {
        // Add event code here...
        int count = policyClaimsDocsTbl.getRowCount();
        for (int i = 0; i < count; i++) {
            JUCtrlValueBinding nodeBinding =
                (JUCtrlValueBinding)policyClaimsDocsTbl.getRowData(i);
            nodeBinding.setAttribute("selectDoc", false);
        }

        int paymentCount = paymentDocTbl.getRowCount();
        for (int i = 0; i < paymentCount; i++) {
            JUCtrlValueBinding nodeBinding =
                (JUCtrlValueBinding)paymentDocTbl.getRowData(i);
            nodeBinding.setAttribute("selectFinanceDoc", false);
        }

        AdfFacesContext.getCurrentInstance().addPartialTarget(this.policyClaimsDocsTbl);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.paymentDocTbl);
        return null;
    }

    public void setPeriodDateFrom(RichInputDate periodDateFrom) {
        this.periodDateFrom = periodDateFrom;
    }

    public RichInputDate getPeriodDateFrom() {
        return periodDateFrom;
    }

    public void setPeriodDateTo(RichInputDate periodDateTo) {
        this.periodDateTo = periodDateTo;
    }

    public RichInputDate getPeriodDateTo() {
        return periodDateTo;
    }

    public String exportRIData() {
        try {
            // Add event code here...
            String header =
                "CLAIM NUMBER,PERIOD,MEMBER NUMBER,MEMBER NAME,CLIENT NAME,AMOUNT PAID,AMOUNT RECOVERABLE,CAUSATION,COVER DESCRIPTION";
            String csvData = header + "\n";
            AccountDAO accDAO = new AccountDAO();
            List<Account> recoveryData = accDAO.findRecoveryPrdSumm();
            for (int i = 0; i < recoveryData.size(); i++) {
                //System.out.println(" I am here...."+recoveryData.get(i).getRefNo());
                csvData =
                        csvData + "" + recoveryData.get(i).getRefNo() + "," + recoveryData.get(i).getRiPeriod() +
                        "," + recoveryData.get(i).getMemNo() + "," +
                        recoveryData.get(i).getMemName() + "," +
                        recoveryData.get(i).getClient() + "," +
                        recoveryData.get(i).getAmtPaid().toString() + "," +
                        recoveryData.get(i).getAmtPayable().toString() + "," +
                        recoveryData.get(i).getCausDesc() + "," +
                        recoveryData.get(i).getCoverDesc() + "\n";
            }

            byte barray[] = csvData.getBytes();


            //Print.
            HttpServletResponse response =
                (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();

            ServletOutputStream servletOutputStream;
            response.reset();
            response.resetBuffer();
            servletOutputStream = response.getOutputStream();
            BufferedOutputStream bufferedOutputStream =
                new BufferedOutputStream(servletOutputStream);

            String output = "Reinsurance_Recoveries.csv";
            response.setContentType("application/octet-stream");
            response.setHeader("Content-disposition",
                               "attachment; filename=" + output + "");


            response.setContentLength(barray.length);

            bufferedOutputStream.write(barray, 0, barray.length);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();

            response.reset();
            response.resetBuffer();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void fileChangeForReinsuranceRecovery(ValueChangeEvent valueChangeEvent) {
        if (valueChangeEvent.getNewValue() != valueChangeEvent.getOldValue()) {
            UploadedFile _file = (UploadedFile)valueChangeEvent.getNewValue();
            this.uploadedFile = _file;
            this.filename = _file.getFilename();
            this.filesize = _file.getLength();
            this.filetype = _file.getContentType();
            System.out.println("File type =====" + this.filetype);
            try {
                importReinsuranceData(this.uploadedFile.getInputStream());
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                              null,
                                                                              e.getMessage()));
            }
        }
    }

    public void importReinsuranceData(InputStream csvFile) {
        String[][] csvvalues = (String[][])null;
        try {
            csvvalues = CSVParser.parse(new InputStreamReader(csvFile));

            //System.out.println("Array length is " + csvvalues.length);
            for (int i = 1; i < csvvalues.length; i++) {
                String claimNo = csvvalues[i][0];
                BigDecimal riAmount = new BigDecimal(csvvalues[i][6]);
                BigDecimal ccvtCode =
                    findCcvt_code(csvvalues[i][0].trim(), csvvalues[i][8].trim());
                System.out.println(claimNo + "===" + riAmount + "===" +
                                   ccvtCode);
                saveRiDetails(claimNo, riAmount, ccvtCode);
            }
            ADFUtils.findIterator("findRecoveryPrdSummIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.riRecoveryDAO);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public BigDecimal findCcvt_code(String claimNumber,
                                    String coverDescription) {
        Connection conn = null;
        BigDecimal ccvt_code = null;
        try {
            DBConnector datahandler = new DBConnector();

            conn = datahandler.getDatabaseConn();
            CallableStatement callStmt1;

            String query =
                "begin ? := LMS_GRP_REINSURANCE.getCcvtCode(?,?); end;";
            callStmt1 = conn.prepareCall(query);
            //register out
            callStmt1.registerOutParameter(1,
                                           OracleTypes.NUMBER); //Base Currency Symbol
            callStmt1.setString(2, claimNumber);
            callStmt1.setString(3, coverDescription);
            callStmt1.execute();
            ccvt_code = callStmt1.getBigDecimal(1);

            conn.commit();
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }

        return ccvt_code;
    }

    public void saveRiDetails(String claimNo, BigDecimal riAmount,
                              BigDecimal ccvtCode) {
        DBConnector connection = new DBConnector();
        String query =
            "begin LMS_GRP_REINSURANCE.updatereinsurancerecovery(?,?,?);end;";

        CallableStatement stmt = null;
        Connection conn = null;
        try {
            conn = connection.getDatabaseConn();
            stmt = conn.prepareCall(query);
            stmt.setString(1, claimNo);
            stmt.setBigDecimal(2, riAmount);
            stmt.setBigDecimal(3, ccvtCode);
            stmt.execute();
            GlobalCC.CloseConnections(null, stmt, conn);
        } catch (Exception ex) {
            ex.printStackTrace();
            GlobalCC.CloseConnections(null, stmt, conn);
        }
    }

    public void setReinsuranceFileUpload(RichInputFile reinsuranceFileUpload) {
        this.reinsuranceFileUpload = reinsuranceFileUpload;
    }

    public RichInputFile getReinsuranceFileUpload() {
        return reinsuranceFileUpload;
    }

    public String exportCoinData() {
        try {
            // Add event code here...
            String header =
                "CLAIM NUMBER,PERIOD,MEMBER NUMBER,MEMBER NAME,CLIENT NAME,AMOUNT PAID,AMOUNT RECOVERABLE,CAUSATION,COVER DESCRIPTION";
            String csvData = header + "\n";
            AccountDAO accDAO = new AccountDAO();
            List<Account> recoveryData = accDAO.findCoinsurancePrdSumm();
            for (int i = 0; i < recoveryData.size(); i++) {
                //System.out.println(" I am here...."+recoveryData.get(i).getRefNo());
                csvData =
                        csvData + "" + recoveryData.get(i).getCoinRefNo() + "," +
                        recoveryData.get(i).getCoinPeriod() + "," +
                        recoveryData.get(i).getCoinMemNo() + "," +
                        recoveryData.get(i).getCoinMemName() + "," +
                        recoveryData.get(i).getCoinClient() + "," +
                        recoveryData.get(i).getCoinAmtPaid().toString() + "," +
                        recoveryData.get(i).getCoinAmtPayable().toString() +
                        "," + recoveryData.get(i).getCoinCausDesc() + "," +
                        recoveryData.get(i).getCoinCoverDesc() + "\n";
            }

            byte barray[] = csvData.getBytes();


            //Print.
            HttpServletResponse response =
                (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();

            ServletOutputStream servletOutputStream;
            response.reset();
            response.resetBuffer();
            servletOutputStream = response.getOutputStream();
            BufferedOutputStream bufferedOutputStream =
                new BufferedOutputStream(servletOutputStream);

            String output = "coinsurance_Recoveries.csv";
            response.setContentType("application/octet-stream");
            response.setHeader("Content-disposition",
                               "attachment; filename=" + output + "");


            response.setContentLength(barray.length);

            bufferedOutputStream.write(barray, 0, barray.length);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();

            response.reset();
            response.resetBuffer();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void fileChangeForCoinsuranceRecovery(ValueChangeEvent valueChangeEvent) {
        if (valueChangeEvent.getNewValue() != valueChangeEvent.getOldValue()) {
            UploadedFile _file = (UploadedFile)valueChangeEvent.getNewValue();
            this.uploadedFile = _file;
            this.filename = _file.getFilename();
            this.filesize = _file.getLength();
            this.filetype = _file.getContentType();
            System.out.println("File type =====" + this.filetype);
            try {
                importCoinsuranceData(this.uploadedFile.getInputStream());
            } catch (Exception e) {
                e.printStackTrace();
                FacesContext.getCurrentInstance().addMessage(null,
                                                             new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                              null,
                                                                              e.getMessage()));
            }
        }
    }

    public void importCoinsuranceData(InputStream csvFile) {
        String[][] csvvalues = (String[][])null;
        try {
            csvvalues = CSVParser.parse(new InputStreamReader(csvFile));

            //System.out.println("Array length is " + csvvalues.length);
            for (int i = 1; i < csvvalues.length; i++) {
                String claimNo = csvvalues[i][0];
                BigDecimal riAmount = new BigDecimal(csvvalues[i][6]);
                BigDecimal ccvtCode =
                    findCcvt_code(csvvalues[i][0].trim(), csvvalues[i][8].trim());
                System.out.println(claimNo + "===" + riAmount + "===" +
                                   ccvtCode);
                saveCoinDetails(claimNo, riAmount, ccvtCode);
            }
            ADFUtils.findIterator("findCoinsurancePrdSummIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.coinsuranceDAO);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void saveCoinDetails(String claimNumber, BigDecimal amount,
                                BigDecimal ccvtCode) {
        DBConnector connection = new DBConnector();
        String query =
            "begin LMS_GRP_REINSURANCE.updateCoinsuranceRecovery(?,?,?);end;";

        CallableStatement stmt = null;
        Connection conn = null;
        try {
            conn = connection.getDatabaseConn();
            stmt = conn.prepareCall(query);
            stmt.setString(1, claimNumber);
            stmt.setBigDecimal(2, amount);
            stmt.setBigDecimal(3, ccvtCode);
            stmt.execute();
            ADFUtils.findIterator("findCoinsurancePrdSummIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.coinsuranceDAO);
            ADFUtils.findIterator("findTreatySummaryIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.treatySummaryLOV);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(conn, e);
        }
    }

    public void selectClaimDocsListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if (valueChangeEvent.getOldValue() != valueChangeEvent.getNewValue()) {
            JUCtrlValueBinding nodeBinding =
                (JUCtrlValueBinding)policyClaimsDocsTbl.getRowData();
            System.out.println("HERE....." + valueChangeEvent.getNewValue());
            if (valueChangeEvent.getNewValue().equals(true)) {
                nodeBinding.setAttribute("selectDoc", true);
            } else {
                nodeBinding.setAttribute("selectDoc", false);
            }
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.policyClaimsDocsTbl);
        }
    }

    public void selectFinanceDocuments(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if (valueChangeEvent.getOldValue() != valueChangeEvent.getNewValue()) {
            JUCtrlValueBinding nodeBinding =
                (JUCtrlValueBinding)paymentDocTbl.getRowData();
            System.out.println("HERE....." + valueChangeEvent.getNewValue());
            if (valueChangeEvent.getNewValue().equals(true)) {
                nodeBinding.setAttribute("selectFinanceDoc", true);
            } else {
                nodeBinding.setAttribute("selectFinanceDoc", false);
            }
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.paymentDocTbl);
        }
    }


    public void selectRIRecord(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if (valueChangeEvent.getOldValue() != valueChangeEvent.getNewValue()) {
            JUCtrlValueBinding nodeBinding =
                (JUCtrlValueBinding)riRecoveryDAO.getRowData();
            System.out.println("HERE....." + valueChangeEvent.getNewValue());
            if (valueChangeEvent.getNewValue().equals(true)) {
                nodeBinding.setAttribute("riSelect", true);
            } else {
                nodeBinding.setAttribute("riSelect", false);
            }
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.riRecoveryDAO);
        }
    }

    public void selectCoinRecord(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if (valueChangeEvent.getOldValue() != valueChangeEvent.getNewValue()) {
            JUCtrlValueBinding nodeBinding =
                (JUCtrlValueBinding)coinsuranceDAO.getRowData();
            System.out.println("HERE....." + valueChangeEvent.getNewValue());
            if (valueChangeEvent.getNewValue().equals(true)) {
                nodeBinding.setAttribute("coinSelect", true);
            } else {
                nodeBinding.setAttribute("coinSelect", false);
            }
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.coinsuranceDAO);
        }
    }
}
