package LMSG.view.dms;


import LMSG.view.Base.GlobalCC;
import LMSG.view.Base.LOVCC;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

import java.math.BigDecimal;

import java.net.HttpURLConnection;
import java.net.URL;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

public class IEDMSDocsDao extends LOVCC {
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);

    public DocumentDTO[] getPolicyDocuments() {
        DMSUtils utils = new DMSUtils();
        ArrayList<String> policyMetadata = new ArrayList();
        policyMetadata = utils.getPolicyMetadata();
        String policyId = policyMetadata.get(0);
        DocumentDTO[] documents = new DocumentDTO[0];
        String allDocs = (String)session.getAttribute("getAllDocs");
        URL url = null;
        //System.out.println("I AM HERE....."+utils.findDmsUrl() + "/" + "getGroupNBDocsByPolicyEndoseNo?policyNo=" +
        //policyId + "&endorseNo=" + policyMetadata.get(1));
        try {
            if (allDocs != null && allDocs.equalsIgnoreCase("Y")) {
                url =
new URL(utils.findDmsUrl() + "/" + "getGroupNBDocsByPolicyNo?policyNo=" +
        policyId);
            } else {

                url =
new URL(utils.findDmsUrl() + "/" + "getGroupNBDocsByPolicyEndoseNo?policyNo=" +
        policyId + "&endorseNo=" + policyMetadata.get(1));

            }
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
                        gson.fromJson((output).toString(), DocumentDTO[].class);
            }
            conn.disconnect();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return documents;
    }

    public List<AlfrescoCommentItem> getDocumentComments() {
        AlfrescoComment comment = new AlfrescoComment();
        String docId = (String)this.session.getAttribute("dcmDocId");
        String[] ids = docId.split(";");
        if (ids.length > 1) {
            docId = ids[0];
        }
        //System.out.println("Doc comments id " + docId);
        List<AlfrescoCommentItem> commentItems = new ArrayList();
        DMSUtils utils = new DMSUtils();
        String link = utils.findDmsApi() + "/";
        try {
            String urls = link + "login?u=admin&pw=pioneer!123$";

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
            URL url =
                new URL(link + "node/workspace/SpacesStore/" + docId + "/comments?alf_ticket=" +
                        ticket);


            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " +
                                           conn.getResponseCode() + "  " +
                                           conn.getResponseMessage());
            }
            BufferedReader br =
                new BufferedReader(new InputStreamReader(conn.getInputStream()));


            StringBuilder json = new StringBuilder();
            //System.out.println("Output from Server .... \n");
            String output;
            while ((output = br.readLine()) != null) {
                json.append(output);
            }
            Gson gson = new GsonBuilder().create();
            comment =
                    (AlfrescoComment)gson.fromJson(json.toString(), AlfrescoComment.class);

            commentItems = comment.getItems();
            conn.disconnect();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return commentItems;
    }

    public DocumentDTO[] getClaimsDocs() {
        String claimNo = (String)this.session.getAttribute("ClaimNo");
        DocumentDTO[] documents = new DocumentDTO[0];
        DMSUtils utils = new DMSUtils();
        ArrayList<String> claimMetadata = new ArrayList<String>();
        claimMetadata = utils.getClaimMetadata();
        if (claimNo != null) {
            try {
                URL url =
                    new URL(utils.findDmsUrl() + "/" + "getGroupClaimDocsByClaimNo?claimNo=" +
                            claimNo);
                HttpURLConnection conn =
                    (HttpURLConnection)url.openConnection();
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
                    System.out.println(output);
                    Gson gson = new GsonBuilder().create();
                    documents =
                            gson.fromJson((output).toString(), DocumentDTO[].class);
                }
                conn.disconnect();
            } catch (Exception e) {
                GlobalCC.EXCEPTIONREPORTING(null, e);
            }
        }
        return documents;
    }

    public DocumentDTO[] getQuotationDocs() {
        DMSUtils utils = new DMSUtils();
        ArrayList<String> quoMetadata = new ArrayList();
        quoMetadata = utils.getQuotMetadata();
        String quoNo = (String)quoMetadata.get(0);
        DocumentDTO[] documents = new DocumentDTO[0];
        String link = utils.findDmsUrl() + "/";
        try {
            URL url =
                new URL(link + "getGroupQuotationDocsByQuoteNo?quoteCode=" +
                        quoNo);
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
                        gson.fromJson((output).toString(), DocumentDTO[].class);
            }
            conn.disconnect();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return documents;
    }

    public DocumentDTO[] getCommissionDocs() {
        DMSUtils utils = new DMSUtils();
        ArrayList<String> quoMetadata = new ArrayList();
        quoMetadata = utils.getQuotMetadata();
        BigDecimal agnCode = (BigDecimal)this.session.getAttribute("agnCode");
        //System.out.println("AGENT NAME " + agnCode);
        String link = utils.findDmsUrl() + "/";
        DocumentDTO[] documents = new DocumentDTO[0];
        try {
            URL url =
                new URL(link + "getGroupCommissionDocsByTransNo?transCode=" +
                        agnCode.toString());
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " +
                                           conn.getResponseCode());
            }
            BufferedReader br =
                new BufferedReader(new InputStreamReader(conn.getInputStream()));


            // System.out.println("Output from Server .... \n");
            String output;
            while ((output = br.readLine()) != null) {
                System.out.println(output);
                Gson gson = new GsonBuilder().create();
                documents =
                        gson.fromJson((output).toString(), DocumentDTO[].class);
            }
            conn.disconnect();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
            e.printStackTrace();
        }
        return documents;
    }

    public DocumentDTO[] getMedicalDocs() {
        DMSUtils utils = new DMSUtils();
        ArrayList<String> medMetadata = new ArrayList();
        DocumentDTO[] documents = new DocumentDTO[0];
        String link = utils.findDmsUrl() + "/";
        String facilitator = "";
        try {
            BigDecimal facilitatorCode =
                (BigDecimal)this.session.getAttribute("FacilitatorCode");
            // System.out.println("Facilitator Code " + facilitatorCode);
            if (facilitatorCode != null) {
                facilitator = facilitatorCode.toString();
            }

            URL url =
                new URL(link + "getGroupMedicalDocsByTransNo?transNo=" + facilitator);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " +
                                           conn.getResponseCode());
            }
            BufferedReader br =
                new BufferedReader(new InputStreamReader(conn.getInputStream()));


            // System.out.println("Output from Server .... \n");
            String output;
            while ((output = br.readLine()) != null) {
                //System.out.println(output);
                Gson gson = new GsonBuilder().create();
                documents =
                        gson.fromJson((output).toString(), DocumentDTO[].class);
            }
            conn.disconnect();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
            e.printStackTrace();
        }
        return documents;
    }

    public DocumentDTO[] getCompanyDocs() {
        DMSUtils utils = new DMSUtils();
        ArrayList<String> medMetadata = new ArrayList();
        DocumentDTO[] documents = new DocumentDTO[0];
        String link = utils.findDmsUrl() + "/";
        try {
            URL url =
                new URL(link + "getCompanyDocsBycompanyCode?companyCode=1");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " +
                                           conn.getResponseCode());
            }
            BufferedReader br =
                new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String output;
            while ((output = br.readLine()) != null) {
                //System.out.println(output);
                Gson gson = new GsonBuilder().create();
                documents =
                        gson.fromJson((output).toString(), DocumentDTO[].class);
            }
            conn.disconnect();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
            e.printStackTrace();
        }
        return documents;
    }

    public DocumentDTO[] getValuationDocuments() {
        DMSUtils utils = new DMSUtils();
        String year = (String)this.session.getAttribute("UWYear");
        DocumentDTO[] documents = new DocumentDTO[0];
        ArrayList<String> policyMetadata = new ArrayList();
        policyMetadata = utils.getPolicyMetadata();
        String link = utils.findDmsUrl() + "/";
        if (year == null) {
            year = Integer.toString(Calendar.getInstance().get(Calendar.YEAR));
        }
        try {
            URL url =
                new URL(link + "getGroupPensionDocsByPolicyNo?policyNo=" +
                        policyMetadata.get(0) + "&year=" + year);
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
                System.out.println(output);
                Gson gson = new GsonBuilder().create();
                documents =
                        gson.fromJson((output).toString(), DocumentDTO[].class);
            }
            conn.disconnect();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
            e.printStackTrace();
        }
        return documents;
    }

    public DocumentDTO[] getMemberDocuments() {
        DMSUtils utils = new DMSUtils();
        DocumentDTO[] documents = new DocumentDTO[0];
        String link = utils.findDmsUrl() + "/";

        try {
            //System.out.println("Member Link=="+link + "getGroupNBDMemberDocsByNo?memberNo=" + utils.findMemberNo());
            URL url =
                new URL(link + "getGroupNBDMemberDocsByNo?memberNo=" + utils.findMemberNo());

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
                        gson.fromJson((output).toString(), DocumentDTO[].class);
            }
            conn.disconnect();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
            e.printStackTrace();
        }
        return documents;
    }

    public DocumentDTO[] getPaymentDocuments() {
        DMSUtils utils = new DMSUtils();
        DocumentDTO[] documents = new DocumentDTO[0];
        String link =
            utils.findDmsUrl() + "/getFMSPaymentDocs?chequeNo=" + utils.findCheques() +
            "&bankName=" + utils.findBanks();
        System.out.println("Link " + link);

        try {
            URL url = new URL(link);
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
                        gson.fromJson((output).toString(), DocumentDTO[].class);
            }
            conn.disconnect();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
            e.printStackTrace();
        }
        return documents;
    }

}
