package LMSG.view.ecm;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import org.apache.chemistry.opencmis.client.api.CmisObject;
import org.apache.chemistry.opencmis.client.api.Document;
import org.apache.chemistry.opencmis.client.api.ItemIterable;
import org.apache.chemistry.opencmis.client.api.OperationContext;
import org.apache.chemistry.opencmis.client.api.Session;
import org.apache.chemistry.opencmis.commons.enums.IncludeRelationships;
import org.apache.chemistry.opencmis.client.api.QueryResult;
import org.apache.chemistry.opencmis.commons.data.PropertyData;

public class EcmUtilDAO {
    public EcmUtilDAO() {
        super();
    }

    HttpSession sessions =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    EcmUtil ecmUtil = null;

    public List<EcmBean> findCommAgnDocs() {
        List<EcmBean> ecm = new ArrayList<EcmBean>();
        Session session = null;
        try {
            session = ecmUtil.Authentification();
            session.getDefaultContext().setCacheEnabled(false);
            OperationContext context = session.createOperationContext();
            context.setCacheEnabled(false);
            context.setIncludeAllowableActions(true);
            context.setIncludeRelationships(IncludeRelationships.BOTH);

            String agnName = (String)sessions.getAttribute("ecmAgnName");
            String query =
                "SELECT doc.*, iptc.* from cmis:document AS doc JOIN tqgib:documentData " +
                "AS iptc ON doc.cmis:objectId = iptc.cmis:objectId where iptc.tqgib:clientname ='" +
                agnName + "'";

            ItemIterable<QueryResult> q = session.query(query, false, context);

            // Did it work?
            System.out.println("***results from query " + query);

            for (QueryResult qr : q) {
                CmisObject item =
                    session.getObject(session.createObjectId((qr.getPropertyByQueryName("iptc.cmis:objectId").getFirstValue().toString())),
                                      context);
                if (item instanceof Document) {

                    EcmBean ecmbean = new EcmBean();
                    ecmbean.setComDocName(ecmUtil.removeExtension(item.getName()));
                    ecmbean.setComDocActualName(item.getName());
                    ecmbean.setComDocModifiedBy(item.getLastModifiedBy());
                    ecmbean.setComDocDateCreated(new SimpleDateFormat("dd/MM/yyyy").format(item.getCreationDate().getTime()));
                    ecmbean.setComDocVersionLabel(((Document)item).getVersionLabel());
                    ecmbean.setComDocId(item.getId());
                    ecmbean.setComDocMimeType(((Document)item).getContentStreamMimeType());
                    ecm.add(ecmbean);

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
          
        }
        return ecm;
    }

  public List<EcmBean> findClaimDocs() {
      List<EcmBean> ecm = new ArrayList<EcmBean>();
      Session session = null;
      try {
          ecmUtil = new EcmUtil();
          session = ecmUtil.Authentification();
          session.getDefaultContext().setCacheEnabled(false);
          OperationContext context = session.createOperationContext();
          context.setCacheEnabled(false);
          context.setIncludeAllowableActions(true);
          context.setIncludeRelationships(IncludeRelationships.BOTH);

          String claimNo = (String)sessions.getAttribute("dmsClmNo");
          
          String query =
            "SELECT iptc.* from tqlms:grpclaimData " + "AS iptc where iptc.tqlms:grpclmClaimNo ='" +
            claimNo + "'";
          
          ItemIterable<QueryResult> q = session.query(query, false, context);

          // Did it work?
          System.out.println("***results from query " + query);

          for (QueryResult qr : q) {
              CmisObject item =
                  session.getObject(session.createObjectId((qr.getPropertyByQueryName("iptc.cmis:objectId").getFirstValue().toString())),
                                    context);
              if (item instanceof Document) {
                EcmBean ecmbean = new EcmBean();
                ecmbean.setName(ecmUtil.removeExtension(item.getName()));
                ecmbean.setActualName(item.getName());
                ecmbean.setModifiedBy(item.getLastModifiedBy());
                ecmbean.setDateCreated(new SimpleDateFormat("dd/MM/yyyy").format(item.getCreationDate().getTime()));
                ecmbean.setVersionLabel(((Document)item).getVersionLabel());
                ecmbean.setId(item.getId());
                ecmbean.setMimeType(((Document)item).getContentStreamMimeType());
                ecm.add(ecmbean);
              }

          }

      } catch (Exception e) {
          e.printStackTrace();
      } finally {

      }
      return ecm;
  }
    
    public List<EcmBean> findEnquireDocs() {
        List<EcmBean> ecm = new ArrayList<EcmBean>();
        Session session = null;
        try {
            ecmUtil = new EcmUtil();
            session = ecmUtil.Authentification();
            session.getDefaultContext().setCacheEnabled(false);
            OperationContext context = session.createOperationContext();
            context.setIncludeAllowableActions(true);
            context.setCacheEnabled(false);
            context.setIncludeRelationships(IncludeRelationships.BOTH);


            String polNo = (String)sessions.getAttribute("ecmPolNo");
            //            polNo = polNo.replace("/", "_");
            //            String query =
            //                "SELECT doc.*, iptc.* from cmis:document AS doc JOIN custom:NBGLPolicyDocument" +
            //                " AS iptc ON doc.cmis:objectId = iptc.cmis:objectId where iptc.custom:NBGLPDPolicyNumber ='" +
            //                polNo + "'";


            String query =
                "SELECT iptc.* from tqlms:tqordPolicyDocument" + " AS iptc where iptc.tqlms:policynumber ='" +
                polNo + "'";


            String clientId = (String)sessions.getAttribute("clientCode");
            String query2 =
                "SELECT doc.*, iptc.* from cmis:document AS doc JOIN tqgib:clientsDocs   AS iptc ON doc.cmis:objectId = iptc.cmis:objectId where iptc.tqgib:ClientID ='" +
                clientId + "'";


            ItemIterable<QueryResult> q = session.query(query, false, context);

            // Did it work?
            System.out.println("***results from query " + query);

            for (QueryResult qr : q) {
                CmisObject item =
                    session.getObject(session.createObjectId((qr.getPropertyByQueryName("iptc.cmis:objectId").getFirstValue().toString())),
                                      context);
                if (item instanceof Document) {
                    EcmBean ecmbean = new EcmBean();
                    ecmbean.setName(ecmUtil.removeExtension(item.getName()));
                    ecmbean.setActualName(item.getName());
                    ecmbean.setModifiedBy(item.getLastModifiedBy());
                    ecmbean.setDateCreated(new SimpleDateFormat("dd/MM/yyyy").format(item.getCreationDate().getTime()));
                    ecmbean.setVersionLabel(((Document)item).getVersionLabel());
                    ecmbean.setId(item.getId());
                    ecmbean.setMimeType(((Document)item).getContentStreamMimeType());
                    ecm.add(ecmbean);

                }

            }

            ItemIterable<QueryResult> q2 =
                session.query(query2, false, context);

            // Did it work?
            System.out.println("***results from query " + query2);

            for (QueryResult qr : q2) {
                CmisObject item =
                    session.getObject(session.createObjectId((qr.getPropertyByQueryName("iptc.cmis:objectId").getFirstValue().toString())),
                                      context);
                if (item instanceof Document) {
                    if (item.equals(null)) {

                    } else {
                        EcmBean ecmbean = new EcmBean();
                        ecmbean.setName(ecmUtil.removeExtension(item.getName()));
                        ecmbean.setActualName(item.getName());
                        ecmbean.setModifiedBy(item.getLastModifiedBy());
                        ecmbean.setDateCreated(new SimpleDateFormat("dd/MM/yyyy").format(item.getCreationDate().getTime()));
                        ecmbean.setVersionLabel(((Document)item).getVersionLabel());
                        ecmbean.setId(item.getId());
                        ecmbean.setMimeType(((Document)item).getContentStreamMimeType());
                        ecm.add(ecmbean);
                    }

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return ecm;
    }

    public List<EcmBean> findQuoteDocs() {
        List<EcmBean> ecm = new ArrayList<EcmBean>();
        Session session = null;
        String policyNo = (String)sessions.getAttribute("dmsQuoNo");
        //        String policyNo2 = null;
        //        if(policyNo == null){
        //
        //        }
        //        else{
        //        policyNo2 = policyNo.replace("/", "_");
        //        }
        try {
            ecmUtil = new EcmUtil();
            session = ecmUtil.Authentification();
            session.getDefaultContext().setCacheEnabled(false);
            OperationContext context = session.createOperationContext();
            context.setIncludeAllowableActions(true);
            context.setCacheEnabled(false);
            context.setIncludeRelationships(IncludeRelationships.BOTH);

            String query =
                "SELECT iptc.* from tqlms:tqordPolicyDocument " + "AS iptc where iptc.tqlms:policynumber ='" +
                policyNo + "'";

            //            String query =
            //                "SELECT doc.*, iptc.* from cmis:document AS doc JOIN custom:NBGLPolicyDocument " +
            //                "AS iptc ON doc.cmis:objectId = iptc.cmis:objectId where iptc.custom:NBGLPDPolicyNumber ='" +
            //                policyNo + "'";


            String clientId = (String)sessions.getAttribute("clientCode");
            String query2 =
                "SELECT doc.*, iptc.* from cmis:document AS doc JOIN tqgib:clientsDocs   AS iptc ON doc.cmis:objectId = iptc.cmis:objectId where iptc.tqgib:ClientID ='" +
                clientId + "'";


            ItemIterable<QueryResult> q = session.query(query, false, context);

            // Did it work?
            System.out.println("***results from query " + query);

            for (QueryResult qr : q) {
                CmisObject item =
                    session.getObject(session.createObjectId((qr.getPropertyByQueryName("iptc.cmis:objectId").getFirstValue().toString())),
                                      context);
                if (item instanceof Document) {
                    if (item.equals(null)) {

                    } else {
                        EcmBean ecmbean = new EcmBean();
                        ecmbean.setName(ecmUtil.removeExtension(item.getName()));
                        ecmbean.setActualName(item.getName());
                        ecmbean.setModifiedBy(item.getLastModifiedBy());
                        ecmbean.setDateCreated(new SimpleDateFormat("dd/MM/yyyy").format(item.getCreationDate().getTime()));
                        ecmbean.setVersionLabel(((Document)item).getVersionLabel());
                        ecmbean.setId(item.getId());
                        ecmbean.setMimeType(((Document)item).getContentStreamMimeType());
                        ecm.add(ecmbean);
                    }

                }

            }

            ItemIterable<QueryResult> q2 =
                session.query(query2, false, context);

            // Did it work?
            System.out.println("***results from query " + query2);

            for (QueryResult qr : q2) {
                CmisObject item =
                    session.getObject(session.createObjectId((qr.getPropertyByQueryName("iptc.cmis:objectId").getFirstValue().toString())),
                                      context);
                if (item instanceof Document) {
                    if (item.equals(null)) {

                    } else {
                        EcmBean ecmbean = new EcmBean();
                        ecmbean.setName(ecmUtil.removeExtension(item.getName()));
                        ecmbean.setActualName(item.getName());
                        ecmbean.setModifiedBy(item.getLastModifiedBy());
                        ecmbean.setDateCreated(new SimpleDateFormat("dd/MM/yyyy").format(item.getCreationDate().getTime()));
                        ecmbean.setVersionLabel(((Document)item).getVersionLabel());
                        ecmbean.setId(item.getId());
                        ecmbean.setMimeType(((Document)item).getContentStreamMimeType());
                        ecm.add(ecmbean);
                    }

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return ecm;
    }

    public List<EcmBean> findQuotationDocs() {
      List<EcmBean> ecm = new ArrayList<EcmBean>();
      Session session = null;
      String policyNo = (String)sessions.getAttribute("dmsQuoNo");
      //        String policyNo2 = null;
      //        if(policyNo == null){
      //
      //        }
      //        else{
      //        policyNo2 = policyNo.replace("/", "_");
      //        }
      try {
          ecmUtil = new EcmUtil();
          session = ecmUtil.Authentification();
          session.getDefaultContext().setCacheEnabled(false);
          OperationContext context = session.createOperationContext();
          context.setIncludeAllowableActions(true);
          context.setCacheEnabled(false);
          context.setIncludeRelationships(IncludeRelationships.BOTH);

          String query =
              "SELECT iptc.* from tqlms:grpdocumentData " + "AS iptc where iptc.tqlms:quotationno ='" +
              policyNo + "'";

          ItemIterable<QueryResult> q = session.query(query, false, context);

          // Did it work?
          System.out.println("***results from query " + query);

          for (QueryResult qr : q) {
              CmisObject item =
                  session.getObject(session.createObjectId((qr.getPropertyByQueryName("iptc.cmis:objectId").getFirstValue().toString())),
                                    context);
              if (item instanceof Document) {
                  if (item.equals(null)) {

                  } else {
                      EcmBean ecmbean = new EcmBean();
                      ecmbean.setName(ecmUtil.removeExtension(item.getName()));
                      ecmbean.setActualName(item.getName());
                      ecmbean.setModifiedBy(item.getLastModifiedBy());
                      ecmbean.setDateCreated(new SimpleDateFormat("dd/MM/yyyy").format(item.getCreationDate().getTime()));
                      ecmbean.setVersionLabel(((Document)item).getVersionLabel());
                      ecmbean.setId(item.getId());
                      ecmbean.setMimeType(((Document)item).getContentStreamMimeType());
                      ecm.add(ecmbean);
                  }

              }

          }

      } catch (Exception e) {
          e.printStackTrace();
      } finally {

      }
      return ecm;
    }

  public List<EcmBean> findUWDocs() {
    List<EcmBean> ecm = new ArrayList<EcmBean>();
    Session session = null;
    String policyNo = (String)sessions.getAttribute("dmsPolNo");

    try {
        ecmUtil = new EcmUtil();
        session = ecmUtil.Authentification();
        session.getDefaultContext().setCacheEnabled(false);
        OperationContext context = session.createOperationContext();
        context.setIncludeAllowableActions(true);
        context.setCacheEnabled(false);
        context.setIncludeRelationships(IncludeRelationships.BOTH);

        String query =
            "SELECT iptc.* from tqlms:tqordPolicyDocument " + "AS iptc where iptc.tqlms:policynumber ='" +
            policyNo + "'";
     
        ItemIterable<QueryResult> q = session.query(query, false, context);

        System.out.println("***results from query " + query);

        for (QueryResult qr : q) {
            CmisObject item =
                session.getObject(session.createObjectId((qr.getPropertyByQueryName("iptc.cmis:objectId").getFirstValue().toString())),
                                  context);
            if (item instanceof Document) {
                if (item.equals(null)) {

                } else {
                    EcmBean ecmbean = new EcmBean();
                    ecmbean.setName(ecmUtil.removeExtension(item.getName()));
                    ecmbean.setActualName(item.getName());
                    ecmbean.setModifiedBy(item.getLastModifiedBy());
                    ecmbean.setDateCreated(new SimpleDateFormat("dd/MM/yyyy").format(item.getCreationDate().getTime()));
                    ecmbean.setVersionLabel(((Document)item).getVersionLabel());
                    ecmbean.setId(item.getId());
                    ecmbean.setMimeType(((Document)item).getContentStreamMimeType());
                    ecm.add(ecmbean);
                }

            }

        }

       

    } catch (Exception e) {
        e.printStackTrace();
    } finally {
            //session.clear
        session.clear();     
    }
    return ecm;
  }

    public List<EcmBean> findPolClaimsDocs() {
        List<EcmBean> ecm = new ArrayList<EcmBean>();
        Session session = null;
        String policyNo = (String)sessions.getAttribute("ecmPolNo");
        try {
            ecmUtil = new EcmUtil();
            session = ecmUtil.Authentification();
            session.getDefaultContext().setCacheEnabled(false);
            OperationContext context = session.createOperationContext();
            context.setIncludeAllowableActions(true);
            context.setCacheEnabled(false);
            context.setIncludeRelationships(IncludeRelationships.BOTH);

       
            String query =
                "SELECT iptc.* from tqlms:tqordClaimDocument " + "AS iptc where iptc.tqlms:cpolicynumber ='" +
                policyNo + "'";

            ItemIterable<QueryResult> q = session.query(query, false, context);

            // Did it work?
            System.out.println("***results from query " + query);

            for (QueryResult qr : q) {
                CmisObject item =
                    session.getObject(session.createObjectId((qr.getPropertyByQueryName("iptc.cmis:objectId").getFirstValue().toString())),
                                      context);
                if (item instanceof Document) {
                    if (item.equals(null)) {

                    } else {
                        EcmBean ecmbean = new EcmBean();
                        ecmbean.setName(ecmUtil.removeExtension(item.getName()));
                        ecmbean.setActualName(item.getName());
                        ecmbean.setModifiedBy(item.getLastModifiedBy());
                        ecmbean.setDateCreated(new SimpleDateFormat("dd/MM/yyyy").format(item.getCreationDate().getTime()));
                        ecmbean.setVersionLabel(((Document)item).getVersionLabel());
                        ecmbean.setId(item.getId());
                        ecmbean.setMimeType(((Document)item).getContentStreamMimeType());
                        ecm.add(ecmbean);
                    }

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return ecm;
    }
    
    public List<EcmBean> findMedDocs() {
      List<EcmBean> ecm = new ArrayList<EcmBean>();
      Session session = null;
      String policyNo = (String)sessions.getAttribute("dmsPolNo");
      String memberno = (String)sessions.getAttribute("dmsMemNo");
    
      try {
          ecmUtil = new EcmUtil();
          session = ecmUtil.Authentification();
          session.getDefaultContext().setCacheEnabled(false);
          OperationContext context = session.createOperationContext();
          context.setIncludeAllowableActions(true);
          context.setCacheEnabled(false);
          context.setIncludeRelationships(IncludeRelationships.BOTH);

     
          String query =
              "SELECT iptc.* from tqlms:medicalreportData " + "AS iptc where iptc.tqlms:grpPolicyNumber ='" +
              policyNo + "' and iptc.tqlms:grpMemberNumber ='" + memberno + "'";

          ItemIterable<QueryResult> q = session.query(query, false, context);

          // Did it work?
          System.out.println("***results from query " + query);

          for (QueryResult qr : q) {
              CmisObject item =
                  session.getObject(session.createObjectId((qr.getPropertyByQueryName("iptc.cmis:objectId").getFirstValue().toString())),
                                    context);
              if (item instanceof Document) {
                  if (item.equals(null)) {

                  } else {
                      EcmBean ecmbean = new EcmBean();
                      ecmbean.setName(ecmUtil.removeExtension(item.getName()));
                      ecmbean.setActualName(item.getName());
                      ecmbean.setModifiedBy(item.getLastModifiedBy());
                      ecmbean.setDateCreated(new SimpleDateFormat("dd/MM/yyyy").format(item.getCreationDate().getTime()));
                      ecmbean.setVersionLabel(((Document)item).getVersionLabel());
                      ecmbean.setId(item.getId());
                      ecmbean.setMimeType(((Document)item).getContentStreamMimeType());
                      ecm.add(ecmbean);
                  }

              }

          }

      } catch (Exception e) {
          e.printStackTrace();
      } finally {

      }
      return ecm;
  }
}
