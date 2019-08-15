package LMSG.view.dms;

import LMSG.view.Base.ADFUtils;
import LMSG.view.Base.GlobalCC;
import LMSG.view.connect.DBConnector;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;

import java.math.BigDecimal;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputFile;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.input.RichTextEditor;
import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.output.RichInlineFrame;
import oracle.adf.view.rich.component.rich.output.RichOutputLabel;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.DialogEvent;

import oracle.jbo.uicli.binding.JUCtrlValueBinding;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.io.IOUtils;
import org.apache.myfaces.trinidad.model.UploadedFile;
import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

import sun.misc.BASE64Decoder;

public class DocIEdmsBack {
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    private RichTable personalDocTbl;
    private RichInputFile upFile;
    private UploadedFile uploadedFile;
    private String filename;
    private String filetype;
    private RichInlineFrame docFrame;
    private RichTable policyDocsTbl;
    private RichInputFile uwUpFile;
    private RichSelectOneChoice txtDocType;
    private List<SelectItem> docTypes = new ArrayList();
    private RichTable claimsDocsTbl;
    private RichTable quoteDocsTbl;
    private RichInlineFrame docFrame2;
    private RichInlineFrame docFrame3;
    private RichTable policyClaimsDocsTbl;
    private RichInlineFrame docFrame4;
    private RichTable agentDocsTbl;
    private RichInlineFrame docFrame5;
    private RichTable commentTbl;
    private RichInputText txtComment;
    private RichInputFile upFile3;
    private RichInputFile upfile6;
    private RichTable sprDocsTbl;
    private RichInputText txtSprCode;
    private RichTable sprTable;
    private RichInlineFrame docFrame8;
    private RichTable quotationDocTbl;
    private RichTable commissionDocTbl;
    private RichTable medicalDocTbl;
    private HtmlPanelGrid polDocumentPG;
    private RichTable companyDocTbl;
    private RichTable valuationDocTbl;
    private static final HashMap<String, String> mimeTypes;
    private RichPanelFormLayout remarksPanel;
    private RichTextEditor commentRTF;
    private RichCommandButton saveCommentBtn;
    private RichCommandButton cancelCommentBtn;
    private RichCommandButton addComment;
    private RichTable memDocTbl;
    private RichSelectOneChoice claimTypeSelect;
    private RichOutputLabel claimTypeLB;
    private RichTable paymentDocTbl;

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

    private <T, E> T getKeyByValue(Map<T, E> map, E value) {
        for (Map.Entry<T, E> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public void uploadUwDocs(ValueChangeEvent valueChangeEvent) {
        if (valueChangeEvent.getNewValue() != valueChangeEvent.getOldValue()) {
            if (this.txtDocType.getValue() == null) {
                String Message = "Select Document Type to Continue....";
                GlobalCC.INFORMATIONREPORTING(Message);
                return;
            }
            UploadedFile _file = (UploadedFile)valueChangeEvent.getNewValue();
            DMSUtils utils = new DMSUtils();
            this.uploadedFile = _file;
            this.filename = _file.getFilename();
            this.filetype = _file.getContentType();
            try {
                if (this.session.getAttribute("ModuleCode").equals("UND")) {
                    uploadUWDocs(_file.getInputStream(), this.filename,
                                 (String)this.txtDocType.getValue());
                    ADFUtils.findIterator("policyDocumentsIterator").executeQuery();
                    AdfFacesContext.getCurrentInstance().addPartialTarget(this.policyDocsTbl);
                } else if (this.session.getAttribute("ModuleCode").equals("CLM")) {
                    if (this.txtDocType.getValue().equals("PAYMENT VOUCHER")) {
                        if (session.getAttribute("voucherNumber") == null) {
                            GlobalCC.INFORMATIONREPORTING("Please select a voucher first before uploading the document");
                        } else {
                            if (claimTypeSelect.getValue() == null) {
                                GlobalCC.INFORMATIONREPORTING("Please select claim type to proceed...");
                            }
                            uploadClaimDocs(_file.getInputStream(),
                                            this.filename,
                                            (String)this.txtDocType.getValue());
                        }
                    } else {
                        session.setAttribute("voucherNumber", null);
                        uploadClaimDocs(_file.getInputStream(), this.filename,
                                        (String)this.txtDocType.getValue());
                    }
                    ADFUtils.findIterator("claimsDocsIterator").executeQuery();
                    AdfFacesContext.getCurrentInstance().addPartialTarget(this.policyClaimsDocsTbl);
                } else if (this.session.getAttribute("ModuleCode").equals("QUO")) {
                    uploadQuotationDocs(_file.getInputStream(), this.filename,
                                        (String)this.txtDocType.getValue());

                    ADFUtils.findIterator("quotationDocsIterator").executeQuery();
                    AdfFacesContext.getCurrentInstance().addPartialTarget(this.quotationDocTbl);
                } else if (this.session.getAttribute("ModuleCode").equals("COMM")) {
                    String commVoucher = utils.findCommissionVoucher();
                    if (this.txtDocType.getValue().equals("PAYMENT VOUCHER")) {
                        if (commVoucher == null) {
                            GlobalCC.INFORMATIONREPORTING("Please select the payment before uploading the voucher");
                        } else {
                            uploadCommissionDocs(_file.getInputStream(),
                                                 this.filename,
                                                 (String)this.txtDocType.getValue());
                        }
                    } else {
                        uploadCommissionDocs(_file.getInputStream(),
                                             this.filename,
                                             (String)this.txtDocType.getValue());
                    }


                    ADFUtils.findIterator("commissionDocsIterator").executeQuery();
                    AdfFacesContext.getCurrentInstance().addPartialTarget(this.commissionDocTbl);
                } else if (this.session.getAttribute("ModuleCode").equals("MED")) {
                    String medVoucher = utils.findMedicalVoucher();
                    if (this.txtDocType.getValue().equals("PAYMENT VOUCHER")) {
                        if (medVoucher == null) {
                            GlobalCC.INFORMATIONREPORTING("Please select the payment before uploading the voucher");
                        } else {
                            uploadMedicalDocs(_file.getInputStream(),
                                              this.filename,
                                              (String)this.txtDocType.getValue());
                        }
                    } else {
                        uploadMedicalDocs(_file.getInputStream(),
                                          this.filename,
                                          (String)this.txtDocType.getValue());
                    }
                    ADFUtils.findIterator("medicalDocsIterator").executeQuery();
                    AdfFacesContext.getCurrentInstance().addPartialTarget(this.medicalDocTbl);
                } else if (this.session.getAttribute("ModuleCode").equals("VAL")) {
                    uploadPensionDocs(_file.getInputStream(), this.filename,
                                      (String)this.txtDocType.getValue());
                    ADFUtils.findIterator("valuationDocumentsIterator").executeQuery();
                    AdfFacesContext.getCurrentInstance().addPartialTarget(this.valuationDocTbl);

                } else if (this.session.getAttribute("ModuleCode").equals("MEM")) {
                    if (utils.findMemberNo() != null) {
                        uploadMemDocs(_file.getInputStream(), this.filename,
                                      (String)this.txtDocType.getValue());
                        ADFUtils.findIterator("memberDocumentsIterator").executeQuery();
                        AdfFacesContext.getCurrentInstance().addPartialTarget(this.memDocTbl);
                    } else {
                        GlobalCC.INFORMATIONREPORTING("You have not selected any member , please select to proceed");
                    }
                }
            } catch (Exception e) {
                GlobalCC.EXCEPTIONREPORTING(null, e);
                e.printStackTrace();
            }
        }
        claimTypeLB.setVisible(false);
        claimTypeSelect.setVisible(false);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.claimTypeLB);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.claimTypeSelect);
    }

    private void uploadUWDocs(InputStream inputStream, String filename,
                              String docType) throws MalformedURLException,
                                                     IOException {
        DMSUtils utils = new DMSUtils();
        String link = utils.findDmsUrl() + "/";
        String query = link + "uploadGroupNBDocs";

        ArrayList<String> policyMetadata = new ArrayList();
        policyMetadata = utils.getPolicyMetadata();
        String clientName = (String)policyMetadata.get(2);
        String policyId = (String)policyMetadata.get(0);
        String endorsementNo = (String)policyMetadata.get(1);
        byte[] bytes = IOUtils.toByteArray(inputStream);
        byte[] result = Base64.encodeBase64(bytes);
        UploadDocumentDTO uploadDocument = new UploadDocumentDTO();
        uploadDocument.setClientName(clientName);
        uploadDocument.setPolicyNo(policyId);
        uploadDocument.setEndorsementNo(endorsementNo);
        uploadDocument.setDocType(docType);
        uploadDocument.setDocData(new String(result));
        uploadDocument.setUserName(session.getAttribute("Username").toString());
        uploadDocument.setOriginalFileName(filename);
        Gson gson = new Gson();
        String json = gson.toJson(uploadDocument);
        URL url = new URL(query);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setConnectTimeout(5000);
        conn.setRequestProperty("Content-Type",
                                "application/json; charset=UTF-8");

        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestMethod("POST");

        OutputStream os = conn.getOutputStream();
        os.write(json.getBytes("UTF-8"));
        os.close();


        InputStream in = new BufferedInputStream(conn.getInputStream());
        String results = IOUtils.toString(in, "UTF-8");
        System.out.println("Result " + results);


        in.close();
        conn.disconnect();
    }

    private void uploadMemDocs(InputStream inputStream, String filename,
                               String docType) throws MalformedURLException,
                                                      IOException {
        DMSUtils utils = new DMSUtils();
        String link = utils.findDmsUrl() + "/";
        String query = link + "uploadGroupNBDocs";

        ArrayList<String> policyMetadata = new ArrayList();
        policyMetadata = utils.getPolicyMetadata();
        String clientName = (String)policyMetadata.get(2);
        String policyId = (String)policyMetadata.get(0);
        String endorsementNo = (String)policyMetadata.get(1);
        String memberNo = utils.findMemberNo();
        byte[] bytes = IOUtils.toByteArray(inputStream);
        byte[] result = Base64.encodeBase64(bytes);
        UploadDocumentDTO uploadDocument = new UploadDocumentDTO();
        uploadDocument.setClientName(clientName);
        uploadDocument.setPolicyNo(policyId);
        uploadDocument.setEndorsementNo(endorsementNo);
        uploadDocument.setDocType(docType);
        uploadDocument.setDocData(new String(result));
        uploadDocument.setUserName(session.getAttribute("Username").toString());
        uploadDocument.setOriginalFileName(filename);
        uploadDocument.setMemberNo(memberNo);
        Gson gson = new Gson();
        String json = gson.toJson(uploadDocument);
        URL url = new URL(query);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setConnectTimeout(5000);
        conn.setRequestProperty("Content-Type",
                                "application/json; charset=UTF-8");

        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestMethod("POST");

        OutputStream os = conn.getOutputStream();
        os.write(json.getBytes("UTF-8"));
        os.close();


        InputStream in = new BufferedInputStream(conn.getInputStream());
        String results = IOUtils.toString(in, "UTF-8");
        System.out.println("Result " + results);


        in.close();
        conn.disconnect();
    }


    public String viewUwDocs() {
        Object key2 = this.policyDocsTbl.getSelectedRowData();
        JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
        if (r == null) {
            GlobalCC.errorValueNotEntered("No Record Selected");
            return null;
        }
        String id = (String)r.getAttribute("id");
        this.session.setAttribute("dcmDocId", r.getAttribute("id"));
        System.out.println(id);
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
            System.out.println("Url " + urlss);
            String finalUrl = urlss + "/web/viewer.html?";
            System.out.println(finalUrl);
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
                GlobalCC.showPopup("groupTemplate:p300");
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

    public String viewCompanyDocs() {
        Object key2 = this.companyDocTbl.getSelectedRowData();
        JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
        if (r == null) {
            GlobalCC.errorValueNotEntered("No Record Selected");
            return null;
        }
        String id = (String)r.getAttribute("id");
        this.session.setAttribute("dcmDocId", r.getAttribute("id"));
        System.out.println(id);
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


            System.out.println("Url " + urlss);
            String finalUrl = urlss + "/web/viewer.html?";
            String filename = (String)r.getAttribute("actualName");
            ListDocByte docByte = getClientDocuments(finalId);
            this.session.setAttribute("docDocType", docByte.getDocMimetype());
            this.session.setAttribute("docBase24String",
                                      docByte.getByteData());

            finalUrl = finalUrl + "file=" + urlss + "/docServlet";
            this.session.setAttribute("toPrint", finalUrl);
            GlobalCC.showPopup("groupTemplate:p300");
        } catch (Exception e) {
        }
        return null;
    }

    public void setPersonalDocTbl(RichTable personalDocTbl) {
        this.personalDocTbl = personalDocTbl;
    }

    public RichTable getPersonalDocTbl() {
        return this.personalDocTbl;
    }

    public void setUpFile(RichInputFile upFile) {
        this.upFile = upFile;
    }

    public RichInputFile getUpFile() {
        return this.upFile;
    }

    public void uploadClaimDocs(ValueChangeEvent valueChangeEvent) {
        if (valueChangeEvent.getNewValue() != valueChangeEvent.getOldValue()) {
            if (this.txtDocType.getValue() == null) {
                String Message = "Select Document Type to Continue....";
                GlobalCC.INFORMATIONREPORTING(Message);
                return;
            }
            UploadedFile _file = (UploadedFile)valueChangeEvent.getNewValue();
            this.uploadedFile = _file;
            this.filename = _file.getFilename();
            this.filetype = _file.getContentType();
            try {
                uploadClaimDocs(_file.getInputStream(), this.filename,
                                (String)this.txtDocType.getValue());

                ADFUtils.findIterator("claimsDocsIterator").executeQuery();
                new IEDMSDocsDao().getClaimsDocs();
                AdfFacesContext.getCurrentInstance().addPartialTarget(this.claimsDocsTbl);
            } catch (Exception e) {
                GlobalCC.EXCEPTIONREPORTING(null, e);
            }
        }
    }

    private void uploadClaimDocs(InputStream inputStream, String filename,
                                 String docType) throws MalformedURLException,
                                                        IOException {

        DMSUtils utils = new DMSUtils();
        String query = utils.findDmsUrl() + "/" + "uploadGroupClaimsDocs";

        ArrayList<String> claimMetadata = new ArrayList();
        claimMetadata = utils.getClaimMetadata();
        String policyId = (String)claimMetadata.get(0);
        String memNo = (String)claimMetadata.get(1).trim();
        String clientName = (String)claimMetadata.get(2).trim();
        String memberName = (String)claimMetadata.get(3).trim();
        BigDecimal vch = (BigDecimal)session.getAttribute("voucherNumber");
        String voucherNo = "";
        String claimType = claimTypeSelect.getValue().toString();
        if (session.getAttribute("voucherNumber") != null) {
            voucherNo = vch.toString();
        }
        byte[] bytes = IOUtils.toByteArray(inputStream);
        byte[] result = Base64.encodeBase64(bytes);
        UploadDocumentDTO uploadDocument = new UploadDocumentDTO();
        uploadDocument.setClaimNo((String)this.session.getAttribute("ClaimNo"));
        uploadDocument.setClientName(clientName);
        uploadDocument.setPolicyNo(policyId);
        uploadDocument.setMemberNo(memNo);
        uploadDocument.setMemberName(memberName);
        uploadDocument.setDocType(docType);
        uploadDocument.setDocData(new String(result));
        uploadDocument.setUserName(session.getAttribute("Username").toString());
        uploadDocument.setVoucherNo(voucherNo);
        uploadDocument.setOriginalFileName(filename);
        uploadDocument.setClaimType(claimType);
        Gson gson = new Gson();
        String json = gson.toJson(uploadDocument);
        System.out.println("json=="+json);
        
        URL url = new URL(query);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setConnectTimeout(5000);
        conn.setRequestProperty("Content-Type",
                                "application/json; charset=UTF-8");

        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestMethod("POST");

        OutputStream os = conn.getOutputStream();
        os.write(json.getBytes("UTF-8"));
        os.close();


        InputStream in = new BufferedInputStream(conn.getInputStream());
        String results = IOUtils.toString(in, "UTF-8");
        System.out.println("Result " + results);


        in.close();
        conn.disconnect();
    }

    private void uploadQuotationDocs(InputStream inputStream, String filename,
                                     String docType) throws MalformedURLException,
                                                            IOException {
        DMSUtils utils = new DMSUtils();

        String query = utils.findDmsUrl() + "/" + "uploadGroupQuoteDocs";
        ArrayList<String> quotMetadata = new ArrayList();
        quotMetadata = utils.getQuotMetadata();
        System.out.println("Array " + quotMetadata.toString());
        String quoNo = (String)quotMetadata.get(0);
        String clientName = (String)quotMetadata.get(1);
        byte[] bytes = IOUtils.toByteArray(inputStream);
        byte[] result = Base64.encodeBase64(bytes);
        UploadDocumentDTO uploadDocument = new UploadDocumentDTO();
        uploadDocument.setQuoteCode(quoNo);
        uploadDocument.setClientName(clientName);
        uploadDocument.setDocType(docType);
        uploadDocument.setDocData(new String(result));
        uploadDocument.setUserName(session.getAttribute("Username").toString());
        uploadDocument.setOriginalFileName(filename);
        Gson gson = new Gson();
        String json = gson.toJson(uploadDocument);
        URL url = new URL(query);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setConnectTimeout(5000);
        conn.setRequestProperty("Content-Type",
                                "application/json; charset=UTF-8");

        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestMethod("POST");

        OutputStream os = conn.getOutputStream();
        os.write(json.getBytes("UTF-8"));
        os.close();


        InputStream in = new BufferedInputStream(conn.getInputStream());
        String results = IOUtils.toString(in, "UTF-8");
        System.out.println("Result " + results);


        in.close();
        conn.disconnect();
    }

    private void uploadCommissionDocs(InputStream inputStream, String filename,
                                      String docType) throws MalformedURLException,
                                                             IOException {
        try {
            DMSUtils utils = new DMSUtils();
            String agentName = (String)this.session.getAttribute("agnName");
            String query =
                utils.findDmsUrl() + "/" + "uploadGroupCommissionDocs";
            byte[] bytes = IOUtils.toByteArray(inputStream);
            byte[] result = Base64.encodeBase64(bytes);
            BigDecimal agnCode =
                (BigDecimal)this.session.getAttribute("agnCode");
            UploadDocumentDTO uploadDocument = new UploadDocumentDTO();
            uploadDocument.setTransCode(agnCode.toString());
            uploadDocument.setAgentNo((String)this.session.getAttribute("agnShtDesc"));
            uploadDocument.setAgentName(agentName.trim());
            uploadDocument.setDocType(docType.trim());
            uploadDocument.setDocData(new String(result));
            uploadDocument.setUserName(session.getAttribute("Username").toString());
            uploadDocument.setVoucherNo(utils.findCommissionVoucher());
            uploadDocument.setOriginalFileName(filename);
            Gson gson = new Gson();
            String json = gson.toJson(uploadDocument);
            URL url = new URL(query);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setRequestProperty("Content-Type",
                                    "application/json; charset=UTF-8");

            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST");

            OutputStream os = conn.getOutputStream();
            os.write(json.getBytes("UTF-8"));
            os.close();


            InputStream in = new BufferedInputStream(conn.getInputStream());
            String results = IOUtils.toString(in, "UTF-8");
            System.out.println("Result " + results);


            in.close();
            conn.disconnect();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void uploadMedicalDocs(InputStream inputStream, String filename,
                                   String docType) throws MalformedURLException,
                                                          IOException {
        try {
            DMSUtils utils = new DMSUtils();
            String query = utils.findDmsUrl() + "/" + "uploadGroupMedicalDocs";
            //System.out.println("The Voucher no is "+utils.findMedicalVoucher());
            byte[] bytes = IOUtils.toByteArray(inputStream);
            byte[] result = Base64.encodeBase64(bytes);
            ArrayList<String> medMetadata = new ArrayList();
            medMetadata = utils.getMedicalMetadata();             
            BigDecimal facilitatorCode =utils.findFacilitatorCode();
            UploadDocumentDTO uploadDocument = new UploadDocumentDTO();
            uploadDocument.setTransNo(facilitatorCode.toString());
            uploadDocument.setProviderNo(facilitatorCode.toString());
            uploadDocument.setProviderName(medMetadata.get(1));
            uploadDocument.setDocType(docType);
            uploadDocument.setDocData(new String(result));
            uploadDocument.setUserName(session.getAttribute("Username").toString());
            uploadDocument.setVoucherNo(utils.findMedicalVoucher());
            uploadDocument.setOriginalFileName(filename);
            Gson gson = new Gson();
            String json = gson.toJson(uploadDocument);
            URL url = new URL(query);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setRequestProperty("Content-Type",
                                    "application/json; charset=UTF-8");

            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST");

            OutputStream os = conn.getOutputStream();
            os.write(json.getBytes("UTF-8"));
            os.close();


            InputStream in = new BufferedInputStream(conn.getInputStream());
            String results = IOUtils.toString(in, "UTF-8");
            System.out.println("Result " + results);


            in.close();
            conn.disconnect();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void uploadPensionDocs(InputStream inputStream, String filename,
                                   String docType) throws MalformedURLException,
                                                          IOException {
        DMSUtils utils = new DMSUtils();
        String query = utils.findDmsUrl() + "/" + "uploadGroupPensionDocs";

        ArrayList<String> policyMetadata = new ArrayList();
        policyMetadata = utils.getPolicyMetadata();
        String clientName = (String)policyMetadata.get(2);
        String policyId = (String)policyMetadata.get(0);
        String endorsementNo = (String)policyMetadata.get(1);
        String uwYear = (String)session.getAttribute("UWYear");
        if (uwYear == null) {
            uwYear =
                    Integer.toString(Calendar.getInstance().get(Calendar.YEAR));
        }
        byte[] bytes = IOUtils.toByteArray(inputStream);
        byte[] result = Base64.encodeBase64(bytes);
        UploadDocumentDTO uploadDocument = new UploadDocumentDTO();
        uploadDocument.setPolicyNo(policyId);
        uploadDocument.setYear(uwYear.toString());
        uploadDocument.setClientName(clientName);
        uploadDocument.setDocType(docType);
        uploadDocument.setDocData(new String(result));
        uploadDocument.setUserName(session.getAttribute("Username").toString());
        System.out.println("Original Document name is " + filename);
        uploadDocument.setOriginalFileName(filename);
        Gson gson = new Gson();
        String json = gson.toJson(uploadDocument);
        URL url = new URL(query);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setConnectTimeout(5000);
        conn.setRequestProperty("Content-Type",
                                "application/json; charset=UTF-8");
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestMethod("POST");

        OutputStream os = conn.getOutputStream();
        os.write(json.getBytes("UTF-8"));
        os.close();


        InputStream in = new BufferedInputStream(conn.getInputStream());
        String results = IOUtils.toString(in, "UTF-8");
        System.out.println("Result " + results);


        in.close();
        conn.disconnect();
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
                GlobalCC.showPopup("groupTemplate:p300");
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

    public String viewQuotDocs() {
        Object key2 = this.quotationDocTbl.getSelectedRowData();
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


            // System.out.println("Url " + urlss);
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
                GlobalCC.showPopup("groupTemplate:p300");
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

    public String viewCommissionDocs() {
        Object key2 = this.commissionDocTbl.getSelectedRowData();
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
                GlobalCC.showPopup("groupTemplate:p300");
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

    public String viewMedicalDocs() {
        Object key2 = this.medicalDocTbl.getSelectedRowData();
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
                GlobalCC.showPopup("groupTemplate:p300");
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

    public String viewValuationDocs() {
        Object key2 = this.valuationDocTbl.getSelectedRowData();
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
                GlobalCC.showPopup("groupTemplate:p300");
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

    public String viewMemberDocs() {
        Object key2 = this.memDocTbl.getSelectedRowData();
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
                GlobalCC.showPopup("groupTemplate:p300");
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

    public void setUploadedFile(UploadedFile uploadedFile) {
        this.uploadedFile = uploadedFile;
    }

    public UploadedFile getUploadedFile() {
        return this.uploadedFile;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return this.filename;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }

    public String getFiletype() {
        return this.filetype;
    }

    public String nextDocument() {
        Object key2 = this.personalDocTbl.getSelectedRowData();
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


            // System.out.println("Url " + urlss);
            String finalUrl = urlss + "/web/viewer.html?";
            ListDocByte docByte = getClientDocuments(finalId);
            this.session.setAttribute("docDocType", docByte.getDocMimetype());
            this.session.setAttribute("docBase24String",
                                      docByte.getByteData());

            finalUrl = finalUrl + "file=" + urlss + "/docServlet";
            this.session.setAttribute("toPrint", finalUrl);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.docFrame);
        } catch (Exception e) {
        }
        return null;
    }

    public String nextSprDocument() {
        Object key2 = this.sprDocsTbl.getSelectedRowData();
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
            ListDocByte docByte = getClientDocuments(finalId);
            this.session.setAttribute("docDocType", docByte.getDocMimetype());
            this.session.setAttribute("docBase24String",
                                      docByte.getByteData());

            finalUrl = finalUrl + "file=" + urlss + "/docServlet";
            this.session.setAttribute("toPrint", finalUrl);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.docFrame8);
        } catch (Exception e) {
        }
        return null;
    }

    public String nextPolicyDocument() {
        Object key2 = this.policyDocsTbl.getSelectedRowData();
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
            ListDocByte docByte = getClientDocuments(finalId);
            this.session.setAttribute("docDocType", docByte.getDocMimetype());
            this.session.setAttribute("docBase24String",
                                      docByte.getByteData());

            finalUrl = finalUrl + "file=" + urlss + "/docServlet";
            this.session.setAttribute("toPrint", finalUrl);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.docFrame2);
        } catch (Exception e) {
        }
        return null;
    }

    public String nextPolicyClaimDocument() {
        Object key2 = this.policyDocsTbl.getSelectedRowData();
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


            // System.out.println("Url " + urlss);
            String finalUrl = urlss + "/web/viewer.html?";
            ListDocByte docByte = getClientDocuments(finalId);
            this.session.setAttribute("docDocType", docByte.getDocMimetype());
            this.session.setAttribute("docBase24String",
                                      docByte.getByteData());

            finalUrl = finalUrl + "file=" + urlss + "/docServlet";
            this.session.setAttribute("toPrint", finalUrl);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.docFrame4);
        } catch (Exception e) {
        }
        return null;
    }

    public String nextAgentDocument() {
        Object key2 = this.agentDocsTbl.getSelectedRowData();
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
            ListDocByte docByte = getClientDocuments(finalId);
            this.session.setAttribute("docDocType", docByte.getDocMimetype());
            this.session.setAttribute("docBase24String",
                                      docByte.getByteData());

            finalUrl = finalUrl + "file=" + urlss + "/docServlet";
            this.session.setAttribute("toPrint", finalUrl);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.docFrame5);
        } catch (Exception e) {
        }
        return null;
    }

    public String nexQuotDocument() {
        Object key2 = this.quoteDocsTbl.getSelectedRowData();
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
            ListDocByte docByte = getClientDocuments(finalId);
            this.session.setAttribute("docDocType", docByte.getDocMimetype());
            this.session.setAttribute("docBase24String",
                                      docByte.getByteData());

            finalUrl = finalUrl + "file=" + urlss + "/docServlet";
            this.session.setAttribute("toPrint", finalUrl);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.docFrame2);
        } catch (Exception e) {
        }
        return null;
    }

    public void setDocTypes(List<SelectItem> docTypes) {
        this.docTypes = docTypes;
    }

    public List<SelectItem> getDocTypes() {
        if (this.docTypes != null) {
            this.docTypes.clear();
        }
        DBConnector connection = new DBConnector();
        Connection conn = null;
        CallableStatement stmt = null;
        ResultSet rst = null;
        try {
            // System.out.println("code " +
            //     this.session.getAttribute("ModuleCode"));

            conn = connection.getDatabaseConnection();
            stmt =
conn.prepareCall("begin TQ_LMS.DMS_DOCUMENTS.get_doc_types(?,?);end;");

            stmt.registerOutParameter(1, -10);
            stmt.setObject(2, this.session.getAttribute("ModuleCode"));
            stmt.execute();
            rst = (ResultSet)stmt.getObject(1);
            while (rst.next()) {
                this.docTypes.add(new SelectItem(rst.getString(1),
                                                 rst.getString(2)));
            }
            rst.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            GlobalCC.EXCEPTIONREPORTING(conn, ex);
            ex.printStackTrace();
        } finally {
            DbUtils.closeQuietly(conn, stmt, rst);
        }
        return this.docTypes;
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

    public void setDocFrame(RichInlineFrame docFrame) {
        this.docFrame = docFrame;
    }

    public RichInlineFrame getDocFrame() {
        return this.docFrame;
    }

    public String viewAllDocs() {
        this.session.setAttribute("getAllDocs", "Y");
        ADFUtils.findIterator("policyDocumentsIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.policyDocsTbl);
        return null;
    }

    public void setPolicyDocsTbl(RichTable policyDocsTbl) {
        this.policyDocsTbl = policyDocsTbl;
    }

    public RichTable getPolicyDocsTbl() {
        return this.policyDocsTbl;
    }

    public void setUwUpFile(RichInputFile uwUpFile) {
        this.uwUpFile = uwUpFile;
    }

    public RichInputFile getUwUpFile() {
        return this.uwUpFile;
    }

    public void setTxtDocType(RichSelectOneChoice txtDocType) {
        this.txtDocType = txtDocType;
    }

    public RichSelectOneChoice getTxtDocType() {
        return this.txtDocType;
    }

    public void setClaimsDocsTbl(RichTable claimsDocsTbl) {
        this.claimsDocsTbl = claimsDocsTbl;
    }

    public RichTable getClaimsDocsTbl() {
        return this.claimsDocsTbl;
    }

    public void setQuoteDocsTbl(RichTable quoteDocsTbl) {
        this.quoteDocsTbl = quoteDocsTbl;
    }

    public RichTable getQuoteDocsTbl() {
        return this.quoteDocsTbl;
    }

    public String addDocument() {
        this.session.setAttribute("ModuleCode", Integer.valueOf(5));
        this.txtDocType.setValue(null);
        GlobalCC.showPopup("groupTemplate:p39");
        return null;
    }

    public String addClaimsDocument() {
        this.session.setAttribute("ModuleCode", "CLM");
        this.claimTypeLB.setVisible(true);
        this.claimTypeSelect.setVisible(true);
        this.txtDocType.setValue(null);
        GlobalCC.showPopup("groupTemplate:p39");
        return null;
    }

    public String addUWDocument() {
        this.session.setAttribute("ModuleCode", "UND");
        this.txtDocType.setValue(null);
        GlobalCC.showPopup("groupTemplate:p39");
        return null;
    }

    public String addQuotDocument() {
        this.session.setAttribute("ModuleCode", "QUO");
        this.txtDocType.setValue(null);
        GlobalCC.showPopup("groupTemplate:p39");
        return null;
    }

    public String addCommDocument() {
        this.session.setAttribute("ModuleCode", "COMM");
        this.txtDocType.setValue(null);
        GlobalCC.showPopup("groupTemplate:p39");
        return null;
    }

    public String addMedDocument() {
        this.session.setAttribute("ModuleCode", "MED");
        this.txtDocType.setValue(null);
        GlobalCC.showPopup("groupTemplate:p39");
        return null;
    }

    public String addValuationDocument() {
        this.session.setAttribute("ModuleCode", "VAL");
        this.txtDocType.setValue(null);
        GlobalCC.showPopup("groupTemplate:p39");
        return null;
    }

    public String addMemberDocument() {
        this.session.setAttribute("ModuleCode", "MEM");
        this.txtDocType.setValue(null);
        GlobalCC.showPopup("groupTemplate:p39");
        return null;
    }

    public void setDocFrame2(RichInlineFrame docFrame2) {
        this.docFrame2 = docFrame2;
    }

    public RichInlineFrame getDocFrame2() {
        return this.docFrame2;
    }

    public void setDocFrame3(RichInlineFrame docFrame3) {
        this.docFrame3 = docFrame3;
    }

    public RichInlineFrame getDocFrame3() {
        return this.docFrame3;
    }

    public void setPolicyClaimsDocsTbl(RichTable policyClaimsDocsTbl) {
        this.policyClaimsDocsTbl = policyClaimsDocsTbl;
    }

    public RichTable getPolicyClaimsDocsTbl() {
        return this.policyClaimsDocsTbl;
    }

    public void setDocFrame4(RichInlineFrame docFrame4) {
        this.docFrame4 = docFrame4;
    }

    public RichInlineFrame getDocFrame4() {
        return this.docFrame4;
    }

    public void setAgentDocsTbl(RichTable agentDocsTbl) {
        this.agentDocsTbl = agentDocsTbl;
    }

    public RichTable getAgentDocsTbl() {
        return this.agentDocsTbl;
    }

    public void setDocFrame5(RichInlineFrame docFrame5) {
        this.docFrame5 = docFrame5;
    }

    public RichInlineFrame getDocFrame5() {
        return this.docFrame5;
    }

    public String viewAgencyComments() {
        Object key2 = this.agentDocsTbl.getSelectedRowData();
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
                             "var hints = {autodismissNever:false}; AdfPage.PAGE.findComponent('generalTemplate:commentPop').show(hints);");


        return null;
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

    public String viewPolicyComments() {
        Object key2 = this.policyDocsTbl.getSelectedRowData();
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

    public String viewClientComments() {
        Object key2 = this.personalDocTbl.getSelectedRowData();
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

    public String viewQuotationComments() {
        Object key2 = this.quotationDocTbl.getSelectedRowData();
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

    public String viewCommComments() {
        Object key2 = this.commissionDocTbl.getSelectedRowData();
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

    public String viewMedComments() {
        Object key2 = this.medicalDocTbl.getSelectedRowData();
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

    public String viewCompanyDocComments() {
        Object key2 = this.companyDocTbl.getSelectedRowData();
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

    public String viewValuationComments() {
        Object key2 = this.valuationDocTbl.getSelectedRowData();
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

    public String viewMemberComments() {
        Object key2 = this.memDocTbl.getSelectedRowData();
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
        return this.commentTbl;
    }

    public void setTxtComment(RichInputText txtComment) {
        this.txtComment = txtComment;
    }

    public RichInputText getTxtComment() {
        return this.txtComment;
    }

    public void saveDocComment(DialogEvent dialogEvent) {
        if (this.txtComment.getValue() == null) {
            GlobalCC.INFORMATIONREPORTING("Enter Document comment to continue");
            return;
        }
        String docId = (String)this.session.getAttribute("dcmDocId");
        String user = session.getAttribute("Username").toString();
        // System.out.println("Doc id " + docId);
        DMSUtils utils = new DMSUtils();
        String pass = utils.findUserPassword();

        String link = utils.findDmsApi() + "/";
        try {
            String urls = link + "login?u=" + user + "&pw=" + pass;
            System.out.println(urls);
            URL urll = new URL(urls);
            HttpURLConnection conns = (HttpURLConnection)urll.openConnection();
            conns.setRequestMethod("GET");
            conns.setRequestProperty("Accept", "application/json");
            if (conns.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " +
                                           conns.getResponseCode());
            }
            BufferedReader brs =
                new BufferedReader(new InputStreamReader(conns.getInputStream()));


            int count = 0;
            String ticket = "";
            String outputs;
            while ((outputs = brs.readLine()) != null) {
                if (count == 1) {
                    Matcher m =
                        Pattern.compile(".*<ticket>(.*)<\\/ticket>.*").matcher(outputs);

                    m.matches();
                    ticket = m.group(1);
                }
                count++;
            }
            System.out.println(ticket);

            URL url =
                new URL(link + "node/workspace/SpacesStore/" + docId + "/comments?alf_ticket=" +
                        ticket);


            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setRequestProperty("Content-Type",
                                    "application/json; charset=UTF-8");

            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST");
            DocComments comment = new DocComments();
            comment.setContent((String)this.txtComment.getValue());
            Gson gson = new Gson();
            String json = gson.toJson(comment);
            OutputStream os = conn.getOutputStream();
            os.write(json.getBytes("UTF-8"));
            os.close();


            InputStream in = new BufferedInputStream(conn.getInputStream());
            String results = IOUtils.toString(in, "UTF-8");


            in.close();
            conn.disconnect();
            ADFUtils.findIterator("documentCommentsIterator").executeQuery();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.commentTbl);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
    }

    public String addDocPop() {
        this.txtComment.setValue(null);
        ExtendedRenderKitService erkService =
            (ExtendedRenderKitService)Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                                         ExtendedRenderKitService.class);


        erkService.addScript(FacesContext.getCurrentInstance(),
                             "var hints = {autodismissNever:false}; AdfPage.PAGE.findComponent('groupTemplate:pcomment').show(hints);");


        return null;
    }

    public void addComponent(UIComponent parentUIComponent,
                             UIComponent childUIComponent) {
        parentUIComponent.getChildren().add(childUIComponent);
        AdfFacesContext.getCurrentInstance().addPartialTarget(parentUIComponent);
    }

    public void createInputTextComponent() {

        RichInputText richInputText = new RichInputText();
        richInputText.setId("rit1");
        richInputText.setLabel("Name");
        richInputText.setValue("Testing DMS Remarks");
        richInputText.setReadOnly(true);
        richInputText.setContentStyle("font-weight:bold;color:green");
        addComponent(getRemarksPanel(), richInputText);
    }

    public void setUpFile3(RichInputFile upFile3) {
        this.upFile3 = upFile3;
    }

    public RichInputFile getUpFile3() {
        return this.upFile3;
    }

    public void setUpfile6(RichInputFile upfile6) {
        this.upfile6 = upfile6;
    }

    public RichInputFile getUpfile6() {
        return this.upfile6;
    }

    public void setSprDocsTbl(RichTable sprDocsTbl) {
        this.sprDocsTbl = sprDocsTbl;
    }

    public RichTable getSprDocsTbl() {
        return this.sprDocsTbl;
    }

    public void setTxtSprCode(RichInputText txtSprCode) {
        this.txtSprCode = txtSprCode;
    }

    public RichInputText getTxtSprCode() {
        return this.txtSprCode;
    }

    public void setSprTable(RichTable sprTable) {
        this.sprTable = sprTable;
    }

    public RichTable getSprTable() {
        return this.sprTable;
    }

    public void setDocFrame8(RichInlineFrame docFrame8) {
        this.docFrame8 = docFrame8;
    }

    public RichInlineFrame getDocFrame8() {
        return this.docFrame8;
    }

    public void setQuotationDocTbl(RichTable quotationDocTbl) {
        this.quotationDocTbl = quotationDocTbl;
    }

    public RichTable getQuotationDocTbl() {
        return this.quotationDocTbl;
    }

    public void setCommissionDocTbl(RichTable commissionDocTbl) {
        this.commissionDocTbl = commissionDocTbl;
    }

    public RichTable getCommissionDocTbl() {
        return this.commissionDocTbl;
    }

    public void setMedicalDocTbl(RichTable medicalDocTbl) {
        this.medicalDocTbl = medicalDocTbl;
    }

    public RichTable getMedicalDocTbl() {
        return medicalDocTbl;
    }

    public void setPolDocumentPG(HtmlPanelGrid polDocumentPG) {
        this.polDocumentPG = polDocumentPG;
    }

    public HtmlPanelGrid getPolDocumentPG() {
        return polDocumentPG;
    }

    public void setCompanyDocTbl(RichTable companyDocTbl) {
        this.companyDocTbl = companyDocTbl;
    }

    public RichTable getCompanyDocTbl() {
        return companyDocTbl;
    }

    public void setValuationDocTbl(RichTable valuationDocTbl) {
        this.valuationDocTbl = valuationDocTbl;
    }

    public RichTable getValuationDocTbl() {
        return valuationDocTbl;
    }

    public void setRemarksPanel(RichPanelFormLayout remarksPanel) {
        this.remarksPanel = remarksPanel;
    }

    public RichPanelFormLayout getRemarksPanel() {
        return remarksPanel;
    }

    public void setCommentRTF(RichTextEditor commentRTF) {
        this.commentRTF = commentRTF;
    }

    public RichTextEditor getCommentRTF() {
        return commentRTF;
    }

    public void setSaveCommentBtn(RichCommandButton saveCommentBtn) {
        this.saveCommentBtn = saveCommentBtn;
    }

    public RichCommandButton getSaveCommentBtn() {
        return saveCommentBtn;
    }

    public void setCancelCommentBtn(RichCommandButton cancelCommentBtn) {
        this.cancelCommentBtn = cancelCommentBtn;
    }

    public RichCommandButton getCancelCommentBtn() {
        return cancelCommentBtn;
    }

    public String showCommentPanel() {
        // Add event code here...
        commentRTF.setVisible(true);
        saveCommentBtn.setVisible(true);
        cancelCommentBtn.setVisible(true);
        addComment.setVisible(false);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.commentRTF);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.saveCommentBtn);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.cancelCommentBtn);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.addComment);
        return null;
    }

    public void setAddComment(RichCommandButton addComment) {
        this.addComment = addComment;
    }

    public RichCommandButton getAddComment() {
        return addComment;
    }

    public void setMemDocTbl(RichTable memDocTbl) {
        this.memDocTbl = memDocTbl;
    }

    public RichTable getMemDocTbl() {
        return memDocTbl;
    }

    public String saveDocumentRemarks() {

        if (commentRTF.getValue() == null) {
            GlobalCC.INFORMATIONREPORTING("Enter Document comment to continue");
        }
        String commentContent =
            commentRTF.getValue().toString().replaceAll("(?s)<[^>]*>(\\s*<[^>]*>)*",
                                                        " ").trim();

        String docId = (String)this.session.getAttribute("dcmDocId");
        String user = session.getAttribute("Username").toString();
        // System.out.println("Doc id " + docId);
        DMSUtils utils = new DMSUtils();
        String pass = utils.findUserPassword();

        String link = utils.findDmsApi() + "/";
        try {
            String urls = link + "login?u=" + user + "&pw=" + pass;
            System.out.println(urls);
            URL urll = new URL(urls);
            HttpURLConnection conns = (HttpURLConnection)urll.openConnection();
            conns.setRequestMethod("GET");
            conns.setRequestProperty("Accept", "application/json");
            if (conns.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " +
                                           conns.getResponseCode());
            }
            BufferedReader brs =
                new BufferedReader(new InputStreamReader(conns.getInputStream()));


            int count = 0;
            String ticket = "";
            String outputs;
            while ((outputs = brs.readLine()) != null) {
                if (count == 1) {
                    Matcher m =
                        Pattern.compile(".*<ticket>(.*)<\\/ticket>.*").matcher(outputs);

                    m.matches();
                    ticket = m.group(1);
                }
                count++;
            }
            System.out.println(ticket);

            URL url =
                new URL(link + "node/workspace/SpacesStore/" + docId + "/comments?alf_ticket=" +
                        ticket);


            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setRequestProperty("Content-Type",
                                    "application/json; charset=UTF-8");

            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST");
            DocComments comment = new DocComments();
            //System.out.println("My comment is " + commentContent + "1234");
            comment.setContent(commentContent);
            Gson gson = new Gson();
            String json = gson.toJson(comment);
            OutputStream os = conn.getOutputStream();
            os.write(json.getBytes("UTF-8"));
            os.close();


            InputStream in = new BufferedInputStream(conn.getInputStream());
            String results = IOUtils.toString(in, "UTF-8");


            in.close();
            conn.disconnect();

            commentRTF.setVisible(false);
            saveCommentBtn.setVisible(false);
            cancelCommentBtn.setVisible(false);
            addComment.setVisible(true);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.commentRTF);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.saveCommentBtn);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.cancelCommentBtn);
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.addComment);
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
            e.printStackTrace();
        }
        return null;
    }

    public String cancelRemarks() {
        // Add event code here...
        commentRTF.setVisible(false);
        saveCommentBtn.setVisible(false);
        cancelCommentBtn.setVisible(false);
        addComment.setVisible(true);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.commentRTF);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.saveCommentBtn);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.cancelCommentBtn);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.addComment);
        return null;
    }

    public void setClaimTypeSelect(RichSelectOneChoice claimTypeSelect) {
        this.claimTypeSelect = claimTypeSelect;
    }

    public RichSelectOneChoice getClaimTypeSelect() {
        return claimTypeSelect;
    }

    public void setClaimTypeLB(RichOutputLabel claimTypeLB) {
        this.claimTypeLB = claimTypeLB;
    }

    public RichOutputLabel getClaimTypeLB() {
        return claimTypeLB;
    }

    public void setPaymentDocTbl(RichTable paymentDocTbl) {
        this.paymentDocTbl = paymentDocTbl;
    }

    public RichTable getPaymentDocTbl() {
        return paymentDocTbl;
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
                GlobalCC.showPopup("groupTemplate:p300");
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
    public String viewPaymentComments() {
        Object key2 = this.paymentDocTbl.getSelectedRowData();
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
}
