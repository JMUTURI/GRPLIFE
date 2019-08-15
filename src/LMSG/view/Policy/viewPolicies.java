package LMSG.view.Policy;

import LMSG.view.BPM.ProcessDMSTicket;

import java.io.IOException;

import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.ResultSet;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.FacesContext;

import javax.faces.event.ValueChangeEvent;

import javax.servlet.http.HttpSession;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.data.RichTree;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputFile;
import oracle.adf.view.rich.component.rich.input.RichInputText;

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

import LMSG.view.ecm.EcmProps;
import LMSG.view.ecm.EcmTrans;
import LMSG.view.ecm.EcmUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import java.util.Map;

import javax.faces.event.ActionEvent;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import oracle.adf.view.rich.component.rich.input.RichInputNumberSpinbox;

import oracle.jbo.uicli.binding.JUCtrlHierNodeBinding;

import org.alfresco.cmis.client.AlfrescoDocument;

import org.apache.chemistry.opencmis.client.api.CmisObject;
import org.apache.chemistry.opencmis.client.api.Document;
import org.apache.chemistry.opencmis.client.api.Folder;
import org.apache.chemistry.opencmis.client.api.Session;
import org.apache.myfaces.trinidad.model.CollectionModel;
import org.apache.myfaces.trinidad.model.RowKeySetImpl;
import org.apache.myfaces.trinidad.model.UploadedFile;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;


public class viewPolicies extends LOVCC {
  private RichInputText productDesc;
  private RichTable productsLOV;
  private RichInputText policiesDesc;
  private RichTable policiesLOV;
  private RichPanelBox searchResults;
  private RichTable transactions;
  private RichInputText coverDesc;
  private RichInputText categoryDesc;
  private RichTable coverLOV;
  private RichTable categoryLOV;
  private RichInputText depsDesc;
  private RichTable depsLOV;
  private RichInputText maxTypeNo;
  private RichInputText limitAmt;
  private RichTable allTaxesLOV;
  private RichInputText taxRate;
  private RichInputText taxAmt;
  private RichInputText catID;
  private RichInputText catDesc;
  private RichInputText catPeriod;
  private RichTable policyTaxes;
  private RichTable policyCategories;
  private RichInputText depTypeSel;
  private RichOutputText taxSel;
  private RichShowDetailItem alterMemTab;
  private RichInputText edcatID;
  private RichInputText edcatDesc;
  private RichInputText edcatPeriod;
  private RichTable dpdsCoverTypesLOV;
  private RichTable policyCategoriesLOV;
  private RichTable dependentTypesLOV;
  private RichInputText dpdCatDescDisp;
  private RichInputText dpdCoverType;
  private RichInputText dependentTypeDisplay;
  private RichInputText limitAmountDisplay;
  private RichInputText maxTypeDisplay;
  private RichTable policyDependentLimitsLOV;
  private RichTable documentsLOV;
  private RichInputText documentNameDisplay;
  private RichSelectOneChoice documentSubmitted;
  private RichInputDate documentDateDisplay;
  private RichInputText documentNoDisplay;
  private RichTable groupPolicyDocsLOV;
  private RichInputText applLevel;
  private RichSelectOneChoice durationType;
  private RichInputText yrFrom;
  private RichInputText yrTo;
  private RichInputText entitlement;
  private RichTable vestingLOV;
  private RichTable policyCategoriesforChange;
  private RichPanelBox myTickets;
  private RichTable resultsLOV;
  private RichSelectOneChoice endorseType;
  private RichTable memDependantsLOV;
  private RichInputDate effectiveDate;
  private RichTable consultantLOV;
  private RichInputText consultDesc;
  private RichInputText clientDesc;
  private RichTable clientLOV;
  private RichInputText classDesc;
  private RichInputText feeAmount;
  private RichTable classesLOV;
  private RichTable policyClassTermLimitsLOV;
  private RichTable studentsLOV;
  private RichInputText unitRateDisplay;
  private RichSelectOneChoice unitRateDivisionFactor;
  private RichTree categoryTree;
  private RichTable educClasses;
  private RichSelectOneChoice dpdCoverType1;
  private RichOutputText dpdCatDescDisp1;
  private RichSelectOneChoice dependentTypeDisplay1;
  private RichTable schedulesTable;
  private RichInputText schedulesDesc;
  private RichTable scheduleMembers;
  private RichInputText agencyDesc;
  private RichTable agencyTable;
  private RichInputText govtRemarks;
  private RichTable govtAuthoritiesTable;
  private RichInputDate valuationDate;
  private RichSelectOneChoice valuationFreq;
  private RichInputText receiptsDesc;
  private RichTable receiptsLOV;
  private RichInputNumberSpinbox receiptTotAmt;
  private RichInputNumberSpinbox receiptResvAmt;
  private RichInputNumberSpinbox receiptsTransAmt;
  private RichTable firstReceiptsTbl;
  private RichInputNumberSpinbox receiptBalAmt;
  private RichInputText categoryStudents;
  private RichInputText accessGrpDisplay;
  private RichTable accessGrpTable;
  private RichInputText catMaskDesc;
  private RichTable catMaskTable;
  private RichInputText minAmountDisplay;
  private RichInputText trusteeSurname;
  private RichInputText trusteeOtherNames;
  private RichSelectOneChoice trusteeStatus;
  private RichInputText trusteeTelNo;
  private RichInputText trusteePinNo;
  private RichInputText trusteeIdNo;
  private RichInputText trusteeCertNo;
  private RichInputText trusteeAddr;
  private RichInputDate trusteeRenDate;
  private RichInputDate trusteeWEF;
  private RichInputDate trusteeWET;
  private RichTable trusteesTable;
  private RichTable serviceProviderLOV;
  private RichTable polfacilitatorsLOV;
  private RichSelectOneChoice trusteeRepresentation;
  private RichInputText trusteePhyAddr;
  private RichInputText remarksTextArea;
  private RichCommandButton saveRemarks;
  private RichInputText remarksCode;
  private RichTable premLoadingsLOV;
  private RichInputText loadNameTF;
  private RichInputText loadRateTF;
  private RichInputText loadRateDivFact;
  private RichTable occClassesLOV;
  private RichTable occupationLOV;
  private RichInputFile dmsFileToUpload;
  private RichShowDetailItem dmsDocTab;
  private RichTable dmsDocTable;
  private RichSelectOneChoice lmsDocType;
  private RichInlineFrame docViewer;
  private RichSelectOneChoice remarksType;
  private RichTable remarksLOV;
  private RichSelectOneChoice removedLpt;
    private RichSelectOneChoice catSelectRate;
    private RichInputNumberSpinbox catRate;
    private RichInputNumberSpinbox catRateDivFac;
    private RichCommandButton catMaskButton;

    public viewPolicies() {
  }
  HttpSession session =
    (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);

  public String findProductSelected() {
    DCIteratorBinding dciter = ADFUtils.findIterator("findProductsIterator");
    RowKeySet set = productsLOV.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();

    //System.out.println(1);
    while (rowKeySetIter.hasNext()) {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();

      productDesc.setValue(r.getAttribute("prodDesc"));
      session.setAttribute("productType", null);
      session.setAttribute("endorsementCode", null);
      session.setAttribute("ProductCode", r.getAttribute("prodCode"));
      policiesDesc.setValue(null);
      clientDesc.setValue(null);

      //LOVCC.productType=(String)r.getAttribute("prodType");
      session.setAttribute("productType", r.getAttribute("prodType"));
      session.setAttribute("productType", r.getAttribute("prodType"));

      session.setAttribute("endorsementCode", null);
      session.setAttribute("policyCode", null);
      session.setAttribute("transactionNumber", null);
      //LOVCC.PrpCode=null;
      session.setAttribute("prpCode", null);
      session.setAttribute("clientPRPCode", null);

      ADFUtils.findIterator("FindPolicyTransactionsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(policiesLOV);
      searchResults.setRendered(false);

    }

    return null;
  }

  public String findPoliciesSelected() {
    DCIteratorBinding dciter =
      ADFUtils.findIterator("FindPolicyTransactionsIterator");
    RowKeySet set = policiesLOV.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();

    //System.out.println(1);
    while (rowKeySetIter.hasNext()) {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();
      policiesDesc.setValue(r.getAttribute("LTR_POL_POLICY_NO"));
      //LOVCC.policyNumber = (String)r.getAttribute("LTR_POL_POLICY_NO");
      session.setAttribute("policyNumber",
                           r.getAttribute("LTR_POL_POLICY_NO"));
      session.setAttribute("endorsementCode", r.getAttribute("LTR_ENDR_CODE"));
      session.setAttribute("policyCode", r.getAttribute("LTR_POL_CODE"));
      session.setAttribute("transactionNumber",
                           r.getAttribute("LTR_TRANS_NO"));
      //LOVCC.PrpCode=(BigDecimal)r.getAttribute("prp_code");
      session.setAttribute("prpCode", r.getAttribute("prp_code"));
      session.setAttribute("AgentCode", r.getAttribute("LTR_AGN_CODE"));
      searchResults.setRendered(false);
      myTickets.setRendered(false);

    }

    return null;
  }

  public String findClientsSelected() {
    DCIteratorBinding dciter = ADFUtils.findIterator("findProposersIterator");
    RowKeySet set = clientLOV.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();

    //System.out.println(1);
    while (rowKeySetIter.hasNext()) {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();
      clientDesc.setValue(r.getAttribute("CLIENT"));

      session.setAttribute("clientPRPCode", r.getAttribute("PRP_CODE"));
      searchResults.setRendered(false);
      myTickets.setRendered(false);
      policiesDesc.setValue(null);
      session.setAttribute("endorsementCode", null);
      session.setAttribute("policyCode", null);
      session.setAttribute("transactionNumber", null);
      //LOVCC.PrpCode=null;
      session.setAttribute("prpCode", null);

      ADFUtils.findIterator("FindPolicyTransactionsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(policiesLOV);

    }

    return null;
  }

  public String findCoverSelected() {
    DCIteratorBinding dciter = ADFUtils.findIterator("FindCoverTypesIterator");
    RowKeySet set = coverLOV.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();

    //System.out.println(1);
    while (rowKeySetIter.hasNext()) {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();

      coverDesc.setValue(r.getAttribute("PCVT_CVT_SHT_DESC"));
      //LOVCC.PolicyCoverType=(BigDecimal)r.getAttribute("PCVT_CODE");
      session.setAttribute("PolicyCoverType", r.getAttribute("PCVT_CODE"));


    }

    return null;
  }

  public String findCategorySelected() {
    DCIteratorBinding dciter =
      ADFUtils.findIterator("FindPolicyCategoriesIterator");
    RowKeySet set = categoryLOV.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();

    //System.out.println(1);
    while (rowKeySetIter.hasNext()) {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();

      categoryDesc.setValue(r.getAttribute("PCA_SHT_DESC"));
      //LOVCC.PolicyCategory=(BigDecimal)r.getAttribute("PCA_CODE");
      session.setAttribute("PolicyCategory", r.getAttribute("PCA_CODE"));
      maxTypeNo.setValue(null);
      //depsDesc.setValue(null);
      //LOVCC.PolicyDependants=null;
      session.setAttribute("PolicyDependants", null);
      ADFUtils.findIterator("FindPolicyDependantTypesIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(depsLOV);


    }

    return null;
  }

  public String findDependantsSelected() {
    DCIteratorBinding dciter =
      ADFUtils.findIterator("FindPolicyDependantTypesIterator");
    RowKeySet set = depsLOV.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();

    //System.out.println(1);
    while (rowKeySetIter.hasNext()) {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();

      depsDesc.setValue(r.getAttribute("DTY_DESCRIPTION"));
      //LOVCC.PolicyDependants=(BigDecimal)r.getAttribute("DTY_CODE");
      session.setAttribute("PolicyDependants", r.getAttribute("DTY_CODE"));
      maxTypeNo.setValue(r.getAttribute("PCD_MAX_NO_ALLOWED"));


    }

    return null;
  }

  public String findTaxesSelected() {
    String Rate = null;
    DCIteratorBinding dciter = ADFUtils.findIterator("FindTaxesIterator");
    RowKeySet set = allTaxesLOV.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();

    //System.out.println(1);
    while (rowKeySetIter.hasNext()) {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();


      //LOVCC.TaxesCode=(BigDecimal)r.getAttribute("TT_CODE");
      session.setAttribute("TaxesCode", r.getAttribute("TT_CODE"));
      Rate = (String)r.getAttribute("TRT_RATE");
      taxRate.setValue(Rate);
    }

    return null;
  }

  public String AttachConsultantSelected() {
    Connection conn = null;
    try {

      DBConnector myConn = new DBConnector();
      conn = myConn.getDatabaseConn();
      CallableStatement cst = null;

      BigDecimal Rate = null;
      DCIteratorBinding dciter =
        ADFUtils.findIterator("FindMedicalFacilitatorsIterator");
      RowKeySet set = consultantLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();

      //System.out.println(1);
      while (rowKeySetIter.hasNext()) {
        List l = (List)rowKeySetIter.next();
        Key key = (Key)l.get(0);
        dciter.setCurrentRowWithKey(key.toStringFormat(true));
        Row r = dciter.getCurrentRow();


        Rate = (BigDecimal)r.getAttribute("SPR_CODE");
        consultDesc.setValue(r.getAttribute("SPR_NAME"));

        String polQuery =
          "begin LMS_WEB_PKG_GRP_UW.update_medical_consultant(?,?);end;";
        cst = conn.prepareCall(polQuery);

        cst.setBigDecimal(1,
                          (BigDecimal)session.getAttribute("endorsementCode"));
        cst.setBigDecimal(2, Rate);

        cst.execute();
        cst.close();
        conn.close();
      }
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
  }

  public String ValidateUserAccessForPolicy(BigDecimal PolicyCode) {
    Connection conn = null;
    String Access = "N";
    try {
      String query =
        "begin ?:= LMS_WEB_PKG_GRP_UW.validate_user_access(?,?,?); end;";

      DBConnector datahandler = new DBConnector();

      conn = datahandler.getDatabaseConn();

      CallableStatement cst = null;
      cst = conn.prepareCall(query);
      cst.registerOutParameter(1, oracle.jdbc.internal.OracleTypes.VARCHAR);
      cst.setBigDecimal(2, (BigDecimal)session.getAttribute("UserCode"));
      cst.setString(3, null);
      cst.setBigDecimal(4, PolicyCode);
      cst.execute();
      Access = cst.getString(1);
      cst.close();
      conn.close();

    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return Access;
  }

  public String SearchPolicies() {
    try {
      if (productDesc.getValue() == null) {
        GlobalCC.INFORMATIONREPORTING("Select a Product");
        return null;
      }

      if (policiesDesc.getValue() == null) {
        ADFUtils.findIterator("FindPolicyTransactionsIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(transactions);

        searchResults.setRendered(true);
        myTickets.setRendered(false);
        return null;

      }
      //Check Access for Policy....
      String Access =
        ValidateUserAccessForPolicy((BigDecimal)session.getAttribute("policyCode"));
      if (Access == null) {
        GlobalCC.errorValueNotEntered("You do not have rights to the Selected Policy. Cannot Proceed.");
        return null;
      } else if (Access.equalsIgnoreCase("N")) {
        GlobalCC.errorValueNotEntered("You do not have rights to the Selected Policy. Cannot Proceed.");
        return null;
      } else {
        //Do nothing....
      }

      String Authorised = (String)session.getAttribute("Authorised");
      //System.out.println("Authorised..."+Authorised);
      if (Authorised == null) {
        ADFUtils.findIterator("findTicketDetailsByUserIterator").executeQuery();

        String Tasks = (String)session.getAttribute("ModuleTickets");
        if (Tasks.equalsIgnoreCase("Y")) {

          AdfFacesContext.getCurrentInstance().addPartialTarget(resultsLOV);
          myTickets.setRendered(true);
        } else {

          session.setAttribute("editComponents", "N");
          GlobalCC.RedirectPage("/g_undwrt.jspx");
        }

      } else if (Authorised.equalsIgnoreCase("Y")) {
        session.setAttribute("editComponents", "N");
        GlobalCC.RedirectPage("/g_undwrt.jspx");
      } else {
        ADFUtils.findIterator("findTicketDetailsByUserIterator").executeQuery();

        String Tasks = (String)session.getAttribute("ModuleTickets");
        System.out.println("Tasks=" + Tasks);
        if (Tasks.equalsIgnoreCase("Y")) {

          AdfFacesContext.getCurrentInstance().addPartialTarget(resultsLOV);
          myTickets.setRendered(true);
        } else {
          AdfFacesContext.getCurrentInstance().addPartialTarget(resultsLOV);
          myTickets.setRendered(true);
        }
      }
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(null, e);
      e.printStackTrace();
    }
    return null;
  }

  public String findTicket2Selected() {
    try {

      DCIteratorBinding dciter =
        ADFUtils.findIterator("findTicketDetailsByUserIterator");
      RowKeySet set = resultsLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();

      while (rowKeySetIter.hasNext()) {
        List l = (List)rowKeySetIter.next();
        Key key = (Key)l.get(0);
        dciter.setCurrentRowWithKey(key.toStringFormat(true));


        Row r = dciter.getCurrentRow();

        //LOVCC.TaskID = (String)r.getAttribute("TCKT_CDE");
        session.setAttribute("TaskID", r.getAttribute("TCKT_CDE"));
        //taskselName= (String)r.getAttribute("TCKT_NAME");
        session.setAttribute("taskselName", r.getAttribute("TCKT_NAME"));
        session.setAttribute("TaskActivityName", r.getAttribute("TCKT_NAME"));
        //taskselAssignee= (String)r.getAttribute("TCKT_TO");
        session.setAttribute("taskselAssignee", r.getAttribute("TCKT_TO"));
        //taskselDueDate=(Date)r.getAttribute("TCKT_DUE_DATE");
        session.setAttribute("taskselDueDate",
                             r.getAttribute("TCKT_DUE_DATE"));
        //taskselID=(String)r.getAttribute("TCKT_CDE");
        session.setAttribute("taskselID", r.getAttribute("TCKT_CDE"));
        //taskselCreateDate=(Date)r.getAttribute("TCKT_DATE");
        session.setAttribute("taskselCreateDate", r.getAttribute("TCKT_DATE"));

        GlobalCC.RedirectPage("/wfProcessing.jspx");

      }

    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
    return null;
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

  public String SaveCategory() {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;


    try {
      String polQuery =
        "begin LMS_WEB_PKG_GRP.add_category(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);end;";
      cst = conn.prepareCall(polQuery);

      cst.setBigDecimal(1, (BigDecimal)session.getAttribute("pcaCode"));
      cst.setBigDecimal(2, (BigDecimal)session.getAttribute("policyCode"));
      if (catID.getValue() == null) {
        cst.setString(3, null);
      } else {
        cst.setString(3, catID.getValue().toString());
      }
      if (catDesc.getValue() == null) {
        cst.setString(4, null);
      } else {
        cst.setString(4, catDesc.getValue().toString());
      }
      if (catPeriod.getValue() == null) {
        cst.setString(5, "1");
      } else {
        cst.setString(5, catPeriod.getValue().toString());
      }
      cst.setString(6, "P");
      cst.setBigDecimal(7,
                        (BigDecimal)session.getAttribute("endorsementCode"));
      cst.setBigDecimal(8, (BigDecimal)session.getAttribute("schCode"));
      cst.setString(9, null);
      cst.setString(10, null);
      cst.setBigDecimal(11,
                        (BigDecimal)session.getAttribute("categoryMaskCode"));
      cst.setBigDecimal(12, (BigDecimal)session.getAttribute("catlpagCode"));
        if (catSelectRate.getValue() == null) {
            cst.setString(13, null);
        } else {
            cst.setString(13,
                            catSelectRate.getValue().toString());
        }
        if (catRate.getValue() == null) {
            cst.setString(14, null);
        } else {
            cst.setString(14,
                            catRate.getValue().toString());
        }
        if (catRateDivFac.getValue() == null) {
            cst.setString(15, null);
        } else {
            cst.setString(15,
                            catRateDivFac.getValue().toString());
        }
      cst.execute();
      cst.close();
      conn.close();


      ADFUtils.findIterator("FindPolicyCategoriesIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(policyCategories);
      AdfFacesContext.getCurrentInstance().addPartialTarget(categoryTree);


    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
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

      session.setAttribute("categoryMaskCode", r.getAttribute("PMAS_CODE"));
      catMaskDesc.setValue(r.getAttribute("PMAS_SHT_DESC"));

      AdfFacesContext.getCurrentInstance().addPartialTarget(catMaskDesc);
      GlobalCC.hidePopup("lmsgroup:popup7");

    }
    return null;
  }

  public String SaveVestingScale() {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;


    try {
      String polQuery =
        "begin LMS_WEB_PKG_GRP.updatepolpensvestingscale(?,?,?,?,?,?);end;";
      cst = conn.prepareCall(polQuery);

      cst.setBigDecimal(1, (BigDecimal)session.getAttribute("VestingScaleID"));
      cst.setBigDecimal(2, (BigDecimal)session.getAttribute("policyCode"));
      cst.setBigDecimal(3,
                        (BigDecimal)session.getAttribute("endorsementCode"));
      if (yrFrom.getValue() == null) {
        cst.setString(4, null);
      } else {
        cst.setString(4, yrFrom.getValue().toString());
      }
      if (yrTo.getValue() == null) {
        cst.setString(5, null);
      } else {
        cst.setString(5, yrTo.getValue().toString());
      }
      if (entitlement.getValue() == null) {
        cst.setString(6, null);
      } else {
        cst.setString(6, entitlement.getValue().toString());
      }
      cst.execute();
      cst.close();
      conn.close();

      catID.setValue(null);
      catDesc.setValue(null);
      entitlement.setValue(null);
      session.setAttribute("VestingScaleID", null);

      ADFUtils.findIterator("FindVestingScalesIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(vestingLOV);


    } catch (Exception e) {
      catID.setValue(null);
      catDesc.setValue(null);
      entitlement.setValue(null);
      session.setAttribute("VestingScaleID", null);
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
  }

  public String PopulateTaxes() {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;


    try {
      String polQuery = "begin LMS_WEB_PKG_GRP.populate_taxes(?,?,?);end;";
      cst = conn.prepareCall(polQuery);

      cst.setBigDecimal(1, (BigDecimal)session.getAttribute("policyCode"));
      cst.setString(2, "P");
      cst.setBigDecimal(3,
                        (BigDecimal)session.getAttribute("endorsementCode"));
      cst.execute();
      cst.close();
      conn.close();
      String Message = "Taxes Populated";
      FacesContext.getCurrentInstance().addMessage(null,
                                                   new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                    Message,
                                                                    Message));
      ADFUtils.findIterator("FindPolicyTaxesIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(policyTaxes);

    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
  }

  public String DeleteCategory() {

    BigDecimal CategoryCode = null;

    DCIteratorBinding dciter =
      ADFUtils.findIterator("FindPolicyCategoriesIterator");
    RowKeySet set = policyCategories.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();

    //System.out.println(1);
    while (rowKeySetIter.hasNext()) {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();

      CategoryCode = (BigDecimal)r.getAttribute("PCA_CODE");


    }
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;

    try {
      String polQuery = "begin LMS_WEB_PKG_GRP.delete_category(?,?);end;";
      cst = conn.prepareCall(polQuery);

      cst.setBigDecimal(1, CategoryCode);
      cst.setString(2, "P");

      cst.execute();
      cst.close();
      conn.close();
      String Message = "Category Removed";
      FacesContext.getCurrentInstance().addMessage(null,
                                                   new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                    Message,
                                                                    Message));

      ADFUtils.findIterator("FindPolicyCategoriesIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(policyCategories);

    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }

    return null;
  }

  public String AddCategory() {

    session.setAttribute("pcaCode", null);
    catID.setValue(null);
    catDesc.setValue(null);
    catPeriod.setValue(null);

    session.setAttribute("catlpagCode", session.getAttribute("DeftlpagCode"));
    accessGrpDisplay.setValue(session.getAttribute("DeftlpagDesc"));

    session.setAttribute("categoryMaskCode", session.getAttribute("pmasCode"));
    catMaskDesc.setValue(session.getAttribute("pmasShtDesc"));
    
      catSelectRate.setValue("M");
      catMaskButton.setDisabled(true);
      catRate.setDisabled(true);
      catRate.setValue(null);
      catRateDivFac.setDisabled(true);
      catRateDivFac.setValue(null);

    GlobalCC.showPopup("lmsgroup:addCat");
    return null;
  }

  public String EditCategory() {

    DCIteratorBinding dciter =
      ADFUtils.findIterator("FindPolicyCategoriesIterator");
    RowKeySet set = policyCategories.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();

    //System.out.println(1);
    while (rowKeySetIter.hasNext()) {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();

      //LOVCC.pcaCode=(BigDecimal)r.getAttribute("PCA_CODE");
      session.setAttribute("pcaCode", r.getAttribute("PCA_CODE"));
      catID.setValue(r.getAttribute("PCA_SHT_DESC"));
      catDesc.setValue(r.getAttribute("PCA_CATEG_DESC"));
      catPeriod.setValue(r.getAttribute("PCA_PERIOD"));

      session.setAttribute("catlpagCode", r.getAttribute("pca_lpag_code"));
      accessGrpDisplay.setValue(r.getAttribute("lpag_desc"));

      //session.setAttribute("categoryMaskCode", r.getAttribute("pmas_code"));
      //catMaskDesc.setValue(r.getAttribute("pmas_sht_desc"));
      
      catSelectRate.setValue(r.getAttribute("PCA_USE_CVR_RATE"));
      if(r.getAttribute("PCA_USE_CVR_RATE") == null){
            session.setAttribute("categoryMaskCode",
                                 r.getAttribute("pmas_code"));
            catMaskDesc.setValue(r.getAttribute("pmas_sht_desc"));
            catMaskButton.setDisabled(true);
            catRate.setDisabled(true);
            catRate.setValue(r.getAttribute("PCA_RATE"));
            catRateDivFac.setDisabled(true);
            catSelectRate.setValue("M");
            catRateDivFac.setValue(r.getAttribute("PCA_RATE_DIV_FACT"));
        }else if(r.getAttribute("PCA_USE_CVR_RATE").equals("M")){
            session.setAttribute("categoryMaskCode",
                                 r.getAttribute("pmas_code"));
            catMaskDesc.setValue(r.getAttribute("pmas_sht_desc"));
            catMaskButton.setDisabled(true);
            catRate.setDisabled(true);
            catRate.setValue(r.getAttribute("PCA_RATE"));
            catRateDivFac.setDisabled(true);
            catRateDivFac.setValue(r.getAttribute("PCA_RATE_DIV_FACT"));
        }else if(r.getAttribute("PCA_USE_CVR_RATE").equals("S")){
            session.setAttribute("categoryMaskCode",
                                 r.getAttribute("pmas_code"));
            catMaskDesc.setValue(r.getAttribute("pmas_sht_desc"));
            catMaskButton.setDisabled(false);
            catRate.setDisabled(true);
            catRate.setValue(r.getAttribute("PCA_RATE"));
            catRateDivFac.setDisabled(true);
            catRateDivFac.setValue(r.getAttribute("PCA_RATE_DIV_FACT"));
        }else{
            session.setAttribute("categoryMaskCode",
                                 r.getAttribute("pmas_code"));
            catMaskDesc.setValue(r.getAttribute("pmas_sht_desc"));
            catMaskButton.setDisabled(true);
            catRate.setDisabled(false);
            catRate.setValue(r.getAttribute("PCA_RATE"));
            catRateDivFac.setDisabled(false);
            catRateDivFac.setValue(r.getAttribute("PCA_RATE_DIV_FACT"));
        }

      // Render Popup
      GlobalCC.showPopup("lmsgroup:addCat");
    }


    return null;
  }

  public String AddVestingScale() {

    session.setAttribute("VestingScaleID", null);
    yrFrom.setValue(null);
    yrTo.setValue(null);
    entitlement.setValue(null);

    // Render Popup
    GlobalCC.showPopup("lmsgroup:p3");

    return null;
  }

  public String EditVestingScale() {
    try {
      DCIteratorBinding dciter =
        ADFUtils.findIterator("FindVestingScalesIterator");
      RowKeySet set = vestingLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();

      //System.out.println(1);
      while (rowKeySetIter.hasNext()) {
        List l = (List)rowKeySetIter.next();
        Key key = (Key)l.get(0);
        dciter.setCurrentRowWithKey(key.toStringFormat(true));
        Row r = dciter.getCurrentRow();

        session.setAttribute("VestingScaleID", r.getAttribute("ppvs_code"));
        yrFrom.setValue(r.getAttribute("ppvs_yrs_from"));
        yrTo.setValue(r.getAttribute("ppvs_yrs_to"));
        entitlement.setValue(r.getAttribute("ppvs_pct_entitle"));

        // Render Popup
        GlobalCC.showPopup("lmsgroup:p3");

      }
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
    return null;
  }

  public String AddMember() {

    try {
      session.setAttribute("MemberNumber", null);
      GlobalCC.RedirectPage("/g_pmembers.jspx");
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }

    return null;

  }

  public String EditMember() {

    try {
      GlobalCC.RedirectPage("/g_pmembers.jspx");
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }

    return null;

  }

  public String ImportMember() {

    try {

      if (endorseType.getValue() == null) {

        //do nothing
        //underwritingPolicy.UW = "U";
        session.setAttribute("SystemPoint", "U");
        session.setAttribute("templateTranSeq", 0);
        session.setAttribute("TotalMembers", new BigDecimal("0"));
        session.setAttribute("ValidMembers", new BigDecimal("0"));
        session.setAttribute("InValidMembers", new BigDecimal("0"));
        session.removeAttribute("callScreen");
        GlobalCC.RedirectPage("/pimport.jspx");
      } else if (endorseType.getValue().toString().equalsIgnoreCase("RP")) {
        //Continue with Process...
        session.setAttribute("SystemPoint", "U");
        session.setAttribute("TotalMembers", new BigDecimal("0"));
        session.setAttribute("ValidMembers", new BigDecimal("0"));
        session.setAttribute("InValidMembers", new BigDecimal("0"));
        session.setAttribute("templateTranSeq", 0);
        GlobalCC.RedirectPage("/refund_import.jspx");

      } else if (endorseType.getValue().toString().equalsIgnoreCase("CLR")) {
        //Continue with Process...
        session.setAttribute("SystemPoint", "U");
        session.setAttribute("TotalMembers", new BigDecimal("0"));
        session.setAttribute("ValidMembers", new BigDecimal("0"));
        session.setAttribute("InValidMembers", new BigDecimal("0"));
        session.setAttribute("templateTranSeq", 0);
        GlobalCC.RedirectPage("/Loan_Import.jspx");

      } else {
        //underwritingPolicy.UW = "U";
        session.setAttribute("SystemPoint", "U");
        session.setAttribute("templateTranSeq", 0);
        session.setAttribute("TotalMembers", new BigDecimal("0"));
        session.setAttribute("ValidMembers", new BigDecimal("0"));
        session.setAttribute("InValidMembers", new BigDecimal("0"));
        session.removeAttribute("callScreen");
        GlobalCC.RedirectPage("/pimport.jspx");
      }


    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }

    return null;

  }

  public String ImportMemberFromCovers() {

    try {
      session.setAttribute("callScreen", "covers");
      //underwritingPolicy.UW = "U";
      session.setAttribute("SystemPoint", "U");
      session.setAttribute("TotalMembers", new BigDecimal("0"));
      session.setAttribute("ValidMembers", new BigDecimal("0"));
      session.setAttribute("InValidMembers", new BigDecimal("0"));
      session.setAttribute("templateTranSeq", 0);
      GlobalCC.RedirectPage("/pimport.jspx");
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }

    return null;

  }

  public String ImportMemberForRefund() {

    try {
      session.setAttribute("TotalMembers", new BigDecimal("0"));
      session.setAttribute("ValidMembers", new BigDecimal("0"));
      session.setAttribute("InValidMembers", new BigDecimal("0"));
      session.setAttribute("templateTranSeq", 0);
      GlobalCC.RedirectPage("/refund_import.jspx");
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }

    return null;

  }

  public String MembersToReinstate() {

    try {
      GlobalCC.RedirectPage("/memberReinst.jspx");
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }

    return null;

  }

  public String Return() {

    try {
      //LOVCC.MemberNumber = 0;
      //LOVCC.PolicyCategory = null;
      //LOVCC.OccupationCode = null;
      session.setAttribute("MemberNumber", null);
      session.setAttribute("MemberNumber1", null);
      session.setAttribute("editComponents", "N");
      GlobalCC.RedirectPage("/g_undwrt.jspx");
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }

    return null;

  }

  public String DeleteTax() {

    BigDecimal TaxCode = null;

    DCIteratorBinding dciter =
      ADFUtils.findIterator("FindPolicyTaxesIterator");
    RowKeySet set = policyTaxes.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();

    //System.out.println(1);
    while (rowKeySetIter.hasNext()) {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();

      TaxCode = (BigDecimal)r.getAttribute("PTX_CODE");


    }
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;

    try {
      String polQuery = "begin LMS_WEB_PKG_GRP.delete_taxes(?,?);end;";
      cst = conn.prepareCall(polQuery);

      cst.setBigDecimal(1, TaxCode);
      cst.setString(2, "P");

      cst.execute();
      cst.close();
      conn.close();
      String Message = "Tax Removed";
      FacesContext.getCurrentInstance().addMessage(null,
                                                   new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                    Message,
                                                                    Message));

      ADFUtils.findIterator("FindPolicyTaxesIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(policyTaxes);

    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }

    return null;
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
        session.setAttribute("CoverTypeCode", r.getAttribute("PCVT_CVT_CODE"));
        //LOVCC.qcvtCode=(BigDecimal)r.getAttribute("PCVT_CVT_CODE");
        session.setAttribute("qcvtCode", r.getAttribute("PCVT_CVT_CODE"));
        //LOVCC.pcvtCode=(BigDecimal)r.getAttribute("PCVT_CODE");
        session.setAttribute("pcvtCode", r.getAttribute("PCVT_CODE"));
        dpdCoverType.setValue(r.getAttribute("PCVT_CVT_SHT_DESC"));
        //LOVCC.pdlCode = null;
        session.setAttribute("pdlCode", null);


        // Render Popup
        ExtendedRenderKitService erkService =
          Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                             ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
                             "var hints = {autodismissNever:false}; " +
                             "AdfPage.PAGE.findComponent('" + "lmsgroup:p2" +
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
      DCIteratorBinding dciter = ADFUtils.findIterator("findCategoryIterator");
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

        dpdCatDescDisp.setValue(r.getAttribute("catDesc"));
        AdfFacesContext.getCurrentInstance().addPartialTarget(dpdCatDescDisp);

        // Render Popup
        ExtendedRenderKitService erkService =
          Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                             ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
                             "var hints = {autodismissNever:false}; " +
                             "AdfPage.PAGE.findComponent('" +
                             "lmsgroup:lddepstypes" + "').show(hints);");
      }

    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }

    return null;
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

        //LOVCC.maxType=(BigDecimal)r.getAttribute("PCD_MAX_NO_ALLOWED");
        session.setAttribute("maxType", r.getAttribute("PCD_MAX_NO_ALLOWED"));
        limitAmountDisplay.setValue(null);
        maxTypeDisplay.setValue(r.getAttribute("PCD_MAX_NO_ALLOWED"));

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
                             "lmsgroup:lddepdetails" + "').show(hints);");
      }

    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }

    return null;
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
    String deleteQuery = "BEGIN LMS_WEB_PKG_GRP.delete_dpd_limit(?,?);END;";
    Connection conn = new DBConnector().getDatabaseConn();
    CallableStatement cstmt = null;
    try {
      cstmt = conn.prepareCall(deleteQuery);
      cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("pdlCode"));
      cstmt.setString(2, "P");
      cstmt.execute();
      conn.close();
      ADFUtils.findIterator("FindDependentsLimitsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(policyDependentLimitsLOV);
    } catch (Exception ex) {
      GlobalCC.EXCEPTIONREPORTING(null, ex);
    }
    return null;
  }

  public String DeletePolicyVestingScale() {
    BigDecimal vestingID = null;
    Connection conn = null;
    try {
      DCIteratorBinding dciter =
        ADFUtils.findIterator("FindVestingScalesIterator");
      RowKeySet set = vestingLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();

      //System.out.println(1);
      while (rowKeySetIter.hasNext()) {
        List l = (List)rowKeySetIter.next();
        Key key = (Key)l.get(0);
        dciter.setCurrentRowWithKey(key.toStringFormat(true));
        Row r = dciter.getCurrentRow();

        vestingID = (BigDecimal)r.getAttribute("ppvs_code");

      }
      String deleteQuery = "BEGIN LMS_WEB_PKG_GRP.deletevestingscale(?);END;";
      conn = new DBConnector().getDatabaseConn();
      CallableStatement cstmt = null;

      cstmt = conn.prepareCall(deleteQuery);
      cstmt.setBigDecimal(1, vestingID);
      cstmt.execute();
      cstmt.close();
      conn.close();
      ADFUtils.findIterator("FindVestingScalesIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(vestingLOV);
    } catch (Exception ex) {
      GlobalCC.EXCEPTIONREPORTING(conn, ex);
    }
    return null;
  }

  public void setProductDesc(RichInputText productDesc) {
    this.productDesc = productDesc;
  }

  public RichInputText getProductDesc() {
    return productDesc;
  }

  public void setProductsLOV(RichTable productsLOV) {
    this.productsLOV = productsLOV;
  }

  public RichTable getProductsLOV() {
    return productsLOV;
  }

  public void setPoliciesDesc(RichInputText policiesDesc) {
    this.policiesDesc = policiesDesc;
  }

  public RichInputText getPoliciesDesc() {
    return policiesDesc;
  }

  public void setPoliciesLOV(RichTable policiesLOV) {
    this.policiesLOV = policiesLOV;
  }

  public RichTable getPoliciesLOV() {
    return policiesLOV;
  }

  public void setSearchResults(RichPanelBox searchResults) {
    this.searchResults = searchResults;
  }

  public RichPanelBox getSearchResults() {
    return searchResults;
  }

  public String TransactionListener() {
    // Add event code here...
    DCIteratorBinding dciter =
      ADFUtils.findIterator("FindPolicyTransactionsIterator");
    RowKeySet set = transactions.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();

    //System.out.println(1);
    while (rowKeySetIter.hasNext()) {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();

      session.setAttribute("endorsementCode", r.getAttribute("LTR_ENDR_CODE"));
      session.setAttribute("policyCode", r.getAttribute("LTR_POL_CODE"));
      session.setAttribute("policyCode", r.getAttribute("LTR_POL_CODE"));
      session.setAttribute("transactionNumber",
                           r.getAttribute("LTR_TRANS_NO"));

      //LOVCC.PrpCode=(BigDecimal)r.getAttribute("prp_code");
      session.setAttribute("prpCode", r.getAttribute("prp_code"));

      try {
        session.setAttribute("editComponents", "N");
        GlobalCC.RedirectPage("/g_undwrt.jspx");
      } catch (Exception e) {
        GlobalCC.EXCEPTIONREPORTING(null, e);
      }


    }

    return null;
  }

  public String AttachDocuments() {
    DCIteratorBinding dciter = ADFUtils.findIterator("FindOccupationIterator");
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
                           "lmsgroup:ldpoldocs" + "').show(hints);");
    }
    return null;
  }

  public String SavePolicyDocuments() {
    String saveQuery =
      "BEGIN LMS_WEB_PKG_GRP.add_policy_document(?,?,?,?,?,?,?);END;";
    Connection conn = new DBConnector().getDatabaseConn();
    try {
      CallableStatement cstmt = conn.prepareCall(saveQuery);
      cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("GPD_CODE"));
      cstmt.setBigDecimal(2, (BigDecimal)session.getAttribute("rdCode"));
      cstmt.setString(3, (String)session.getAttribute("rdShtDesc"));
      cstmt.setString(4, (String)session.getAttribute("documentSubmission"));
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
      conn.close();
      ADFUtils.findIterator("FindPolicyDocsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(groupPolicyDocsLOV);
    } catch (Exception ex) {
      GlobalCC.EXCEPTIONREPORTING(conn, ex);
    }
    return null;
  }

  public String DeletePolicyDocuments() {
    DCIteratorBinding dciter = ADFUtils.findIterator("FindPolicyDocsIterator");
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
      cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("gpdCode"));
      cstmt.execute();
      conn.close();
      ADFUtils.findIterator("FindPolicyDocsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(groupPolicyDocsLOV);
    } catch (Exception ex) {
      GlobalCC.EXCEPTIONREPORTING(conn, ex);
    }
    return null;
  }

  public String SavePolicyTaxes() {

    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();

    try {

      String AddTax =
        "begin LMS_WEB_PKG_GRP.save_quotation_taxes(?,?,?,?,?,?,?,?,?,?,?,?,?,?);end;";
      CallableStatement cst = conn.prepareCall(AddTax);

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
      cst.setBigDecimal(8, (BigDecimal)session.getAttribute("TaxesCode"));
      cst.setString(9, (String)session.getAttribute("TaxShtDesc"));
      cst.setBigDecimal(10, (BigDecimal)session.getAttribute("policyCode"));
      cst.setBigDecimal(11, (BigDecimal)session.getAttribute("TaxTRTCode"));
      cst.setString(12, "P");
      cst.setBigDecimal(13,
                        (BigDecimal)session.getAttribute("endorsementCode"));
      cst.setBigDecimal(14, (BigDecimal)session.getAttribute("ptxCode"));


      cst.execute();
      conn.close();
      //LOVCC.ptxCode = null;
      session.setAttribute("ptxCode", null);

      ADFUtils.findIterator("FindPolicyTaxesIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(policyTaxes);


    } catch (Exception e) {
      //LOVCC.ptxCode = null;
      session.setAttribute("ptxCode", null);
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }


    return null;
  }

  public String ShowMemberDetails() {

    return null;
  }

  public void setTransactions(RichTable transactions) {
    this.transactions = transactions;
  }

  public RichTable getTransactions() {
    return transactions;
  }

  public void setCoverDesc(RichInputText coverDesc) {
    this.coverDesc = coverDesc;
  }

  public RichInputText getCoverDesc() {
    return coverDesc;
  }

  public void setCategoryDesc(RichInputText categoryDesc) {
    this.categoryDesc = categoryDesc;
  }

  public RichInputText getCategoryDesc() {
    return categoryDesc;
  }

  public void setCoverLOV(RichTable coverLOV) {
    this.coverLOV = coverLOV;
  }

  public RichTable getCoverLOV() {
    return coverLOV;
  }

  public void setCategoryLOV(RichTable categoryLOV) {
    this.categoryLOV = categoryLOV;
  }

  public RichTable getCategoryLOV() {
    return categoryLOV;
  }

  public void setDepsDesc(RichInputText depsDesc) {
    this.depsDesc = depsDesc;
  }

  public RichInputText getDepsDesc() {
    return depsDesc;
  }

  public void setDepsLOV(RichTable depsLOV) {
    this.depsLOV = depsLOV;
  }

  public RichTable getDepsLOV() {
    return depsLOV;
  }

  public void setMaxTypeNo(RichInputText maxTypeNo) {
    this.maxTypeNo = maxTypeNo;
  }

  public RichInputText getMaxTypeNo() {
    return maxTypeNo;
  }

  public void setLimitAmt(RichInputText limitAmt) {
    this.limitAmt = limitAmt;
  }

  public RichInputText getLimitAmt() {
    return limitAmt;
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
      taxRate.setValue(Rate);
      taxSel.setValue(r.getAttribute("TT_DESC"));


    }
  }

  public void setCatID(RichInputText catID) {
    this.catID = catID;
  }

  public RichInputText getCatID() {
    return catID;
  }

  public void setCatDesc(RichInputText catDesc) {
    this.catDesc = catDesc;
  }

  public RichInputText getCatDesc() {
    return catDesc;
  }

  public void setCatPeriod(RichInputText catPeriod) {
    this.catPeriod = catPeriod;
  }

  public RichInputText getCatPeriod() {
    return catPeriod;
  }

  public void setPolicyTaxes(RichTable policyTaxes) {
    this.policyTaxes = policyTaxes;
  }

  public RichTable getPolicyTaxes() {
    return policyTaxes;
  }

  public void setPolicyCategories(RichTable policyCategories) {
    this.policyCategories = policyCategories;
  }

  public RichTable getPolicyCategories() {
    return policyCategories;
  }

  public void DependantsListener(SelectionEvent selectionEvent) {
    // Add event code here...
    DCIteratorBinding dciter =
      ADFUtils.findIterator("FindPolicyDependantTypesIterator");
    RowKeySet set = selectionEvent.getAddedSet();
    Iterator rowKeySetIter = set.iterator();

    while (rowKeySetIter.hasNext()) {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));


      Row r = dciter.getCurrentRow();
      depTypeSel.setValue(r.getAttribute("DTY_DESCRIPTION"));
      //LOVCC.PolicyDependants=(BigDecimal)r.getAttribute("DTY_CODE");
      session.setAttribute("PolicyDependants", r.getAttribute("DTY_CODE"));
      maxTypeNo.setValue(r.getAttribute("PCD_MAX_NO_ALLOWED"));


    }
  }

  public String SaveDependentLimit() {

    String updateQuery =
      "BEGIN LMS_WEB_PKG_GRP.updatedependentlimits(?,?,?,?,?,?,?,?,?,?);END;";
    Connection conn = new DBConnector().getDatabaseConn();
    try {
      CallableStatement cstmt = conn.prepareCall(updateQuery);
      cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("pdlCode"));
      cstmt.setBigDecimal(2, null);
      cstmt.setBigDecimal(3, (BigDecimal)session.getAttribute("dtyCode"));
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

      cstmt.setBigDecimal(6, (BigDecimal)session.getAttribute("pcvtCode"));
      cstmt.setBigDecimal(7,
                          (BigDecimal)session.getAttribute("CoverTypeCode"));
      cstmt.setBigDecimal(8,
                          (BigDecimal)session.getAttribute("endorsementCode"));
      cstmt.setBigDecimal(9, (BigDecimal)session.getAttribute("pcaCode"));
      cstmt.setString(10, "P");
      cstmt.execute();
      conn.close();
      //LOVCC.pdlCode = null;
      session.setAttribute("pdlCode", null);
      ADFUtils.findIterator("FindDependentsLimitsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(policyDependentLimitsLOV);
    } catch (Exception ex) {
      //LOVCC.pdlCode = null;
      session.setAttribute("pdlCode", null);
      GlobalCC.EXCEPTIONREPORTING(conn, ex);
    }
    return null;
  }

  public String DeleteMemberOnEndorsement() {
    Connection conn = null;
    try {
      String deleteMember =
        "BEGIN LMS_WEB_PKG_GRP_UW.delete_member_for_refund(?,?,?,?);END;";
      conn = new DBConnector().getDatabaseConn();
      CallableStatement cstmt = conn.prepareCall(deleteMember);
      cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("policyCode"));
      cstmt.setBigDecimal(2,
                          (BigDecimal)session.getAttribute("endorsementCode"));
      cstmt.setBigDecimal(3, (BigDecimal)session.getAttribute("PolmCode"));
      cstmt.setBigDecimal(4, (BigDecimal)session.getAttribute("PolmMemCode"));

      cstmt.execute();
      conn.close();
      //ADFUtils.findIterator("FindPolicyMembersIterator").executeQuery();
      //AdfFacesContext.getCurrentInstance().addPartialTarget(policyMembersLOV);

    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
  }

  public String findTaxSel() {

    try {

      // Add event code here...
      String Rate = null;
      DCIteratorBinding dciter = ADFUtils.findIterator("FindTaxesIterator");
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
        session.setAttribute("TaxRateType", r.getAttribute("TRT_RATE_TYPE"));
        session.setAttribute("TaxRenewalEndr",
                             r.getAttribute("TT_RENEWAL_ENDOS"));
        taxRate.setValue(Rate);
        taxSel.setValue(r.getAttribute("TT_DESC"));
        //LOVCC.TaxShtDesc = (String)r.getAttribute("TT_SHT_DESC");
        //LOVCC.TaxTRTCode = (BigDecimal)r.getAttribute("TRT_CODE");
        session.setAttribute("TaxShtDesc", r.getAttribute("TT_SHT_DESC"));
        session.setAttribute("TaxTRTCode", r.getAttribute("TRT_CODE"));
        //LOVCC.ptxCode = null;
        session.setAttribute("ptxCode", null);

        applLevel.setValue(null);
        taxRate.setValue(null);
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
                             "lmsgroup:poltaxes1" + "').show(hints);");


      }

    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }

    return null;
  }

  public String EditTaxesSelected() {
    try {

      DCIteratorBinding dciter =
        ADFUtils.findIterator("FindPolicyTaxesIterator");
      RowKeySet set = policyTaxes.getSelectedRowKeys();
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
                             "lmsgroup:poltaxes1" + "').show(hints);");


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
        session.setAttribute("pcvtCode", r.getAttribute("QDL_PCVT_CODE"));

        session.setAttribute("dtyCode", r.getAttribute("QDL_DTY_CODE"));

        session.setAttribute("qcvtcvtCode", r.getAttribute("CVT_CODE"));
        dpdCatDescDisp.setValue(r.getAttribute("PCA_CATEG_DESC"));
        dpdCoverType.setValue(r.getAttribute("cvt_desc"));
        dependentTypeDisplay.setValue(r.getAttribute("DTY_DESCRIPTION"));
        limitAmountDisplay.setValue(r.getAttribute("QDL_LIMIT_AMT"));
        maxTypeDisplay.setValue(r.getAttribute("QDL_MAX_TYPE_ALLOWED"));
        minAmountDisplay.setValue(r.getAttribute("QDL_MIN_AMT"));

        GlobalCC.showPopup("lmsgroup:poldepdetails");

      }
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }


    return null;
  }

  public String sendSMS() {
    session.setAttribute("sysModule", "U");
    session.setAttribute("msgType", "SMS");

    //Width and height are getting printed properly

    FacesContext context = FacesContext.getCurrentInstance();
    // Create the dialog UIViewRoot

    ViewHandler viewHandler = context.getApplication().getViewHandler();
    GlobalCC.dialogName = "/sms.jspx";
    UIViewRoot dialog = viewHandler.createView(context, GlobalCC.dialogName);

    HashMap properties = new HashMap();
    properties.put("width", 600);
    properties.put("height", 800);

    AdfFacesContext afContext = AdfFacesContext.getCurrentInstance();

    afContext.launchDialog(dialog, null,
        // not launched from any component
        null, // no particular parameters
        true, //show in dialog
        properties);
    return null;
  }

  public String sendEmail() {
    session.setAttribute("sysModule", "U");
    session.setAttribute("msgType", "EMAIL");

    //Width and height are getting printed properly

    FacesContext context = FacesContext.getCurrentInstance();
    // Create the dialog UIViewRoot

    ViewHandler viewHandler = context.getApplication().getViewHandler();
    GlobalCC.dialogName = "/email.jspx";
    UIViewRoot dialog = viewHandler.createView(context, GlobalCC.dialogName);

    HashMap properties = new HashMap();
    properties.put("width", 600);
    properties.put("height", 800);

    AdfFacesContext afContext = AdfFacesContext.getCurrentInstance();

    afContext.launchDialog(dialog, null,
        // not launched from any component
        null, // no particular parameters
        true, //show in dialog
        properties);
    return null;
  }

  public String findCategoriesforChange() {

    try {
      // Render Popup
      ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                           ExtendedRenderKitService.class);
      erkService.addScript(FacesContext.getCurrentInstance(),
                           "var hints = {autodismissNever:false}; " +
                           "AdfPage.PAGE.findComponent('" + "lmsgroup:p5" +
                           "').show(hints);");

    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }

    return null;
  }

  public void setDepTypeSel(RichInputText depTypeSel) {
    this.depTypeSel = depTypeSel;
  }

  public RichInputText getDepTypeSel() {
    return depTypeSel;
  }

  public void setTaxSel(RichOutputText taxSel) {
    this.taxSel = taxSel;
  }

  public RichOutputText getTaxSel() {
    return taxSel;
  }

  public void setAlterMemTab(RichShowDetailItem alterMemTab) {
    this.alterMemTab = alterMemTab;
  }

  public RichShowDetailItem getAlterMemTab() {
    return alterMemTab;
  }

  public void setEdcatID(RichInputText edcatID) {
    this.edcatID = edcatID;
  }

  public RichInputText getEdcatID() {
    return edcatID;
  }

  public void setEdcatDesc(RichInputText edcatDesc) {
    this.edcatDesc = edcatDesc;
  }

  public RichInputText getEdcatDesc() {
    return edcatDesc;
  }

  public void setEdcatPeriod(RichInputText edcatPeriod) {
    this.edcatPeriod = edcatPeriod;
  }

  public RichInputText getEdcatPeriod() {
    return edcatPeriod;
  }

  public void setDpdsCoverTypesLOV(RichTable dpdsCoverTypesLOV) {
    this.dpdsCoverTypesLOV = dpdsCoverTypesLOV;
  }

  public RichTable getDpdsCoverTypesLOV() {
    return dpdsCoverTypesLOV;
  }

  public void setPolicyCategoriesLOV(RichTable policyCategoriesLOV) {
    this.policyCategoriesLOV = policyCategoriesLOV;
  }

  public RichTable getPolicyCategoriesLOV() {
    return policyCategoriesLOV;
  }

  public void setDependentTypesLOV(RichTable dependentTypesLOV) {
    this.dependentTypesLOV = dependentTypesLOV;
  }

  public RichTable getDependentTypesLOV() {
    return dependentTypesLOV;
  }

  public void setDpdCatDescDisp(RichInputText dpdCatDescDisp) {
    this.dpdCatDescDisp = dpdCatDescDisp;
  }

  public RichInputText getDpdCatDescDisp() {
    return dpdCatDescDisp;
  }

  public void setDpdCoverType(RichInputText dpdCoverType) {
    this.dpdCoverType = dpdCoverType;
  }

  public RichInputText getDpdCoverType() {
    return dpdCoverType;
  }

  public void setDependentTypeDisplay(RichInputText dependentTypeDisplay) {
    this.dependentTypeDisplay = dependentTypeDisplay;
  }

  public RichInputText getDependentTypeDisplay() {
    return dependentTypeDisplay;
  }

  public void setLimitAmountDisplay(RichInputText limitAmountDisplay) {
    this.limitAmountDisplay = limitAmountDisplay;
  }

  public RichInputText getLimitAmountDisplay() {
    return limitAmountDisplay;
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

  public void setDocumentsLOV(RichTable documentsLOV) {
    this.documentsLOV = documentsLOV;
  }

  public RichTable getDocumentsLOV() {
    return documentsLOV;
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

  public void setGroupPolicyDocsLOV(RichTable groupPolicyDocsLOV) {
    this.groupPolicyDocsLOV = groupPolicyDocsLOV;
  }

  public RichTable getGroupPolicyDocsLOV() {
    return groupPolicyDocsLOV;
  }

  public void setApplLevel(RichInputText applLevel) {
    this.applLevel = applLevel;
  }

  public RichInputText getApplLevel() {
    return applLevel;
  }

  public void setDurationType(RichSelectOneChoice durationType) {
    this.durationType = durationType;
  }

  public RichSelectOneChoice getDurationType() {
    return durationType;
  }

  public void setYrFrom(RichInputText yrFrom) {
    this.yrFrom = yrFrom;
  }

  public RichInputText getYrFrom() {
    return yrFrom;
  }

  public void setYrTo(RichInputText yrTo) {
    this.yrTo = yrTo;
  }

  public RichInputText getYrTo() {
    return yrTo;
  }

  public void setEntitlement(RichInputText entitlement) {
    this.entitlement = entitlement;
  }

  public RichInputText getEntitlement() {
    return entitlement;
  }

  public void setVestingLOV(RichTable vestingLOV) {
    this.vestingLOV = vestingLOV;
  }

  public RichTable getVestingLOV() {
    return vestingLOV;
  }

  public void setMyTickets(RichPanelBox myTickets) {
    this.myTickets = myTickets;
  }

  public RichPanelBox getMyTickets() {
    return myTickets;
  }

  public void setResultsLOV(RichTable resultsLOV) {
    this.resultsLOV = resultsLOV;
  }

  public RichTable getResultsLOV() {
    return resultsLOV;
  }

  public void setEndorseType(RichSelectOneChoice endorseType) {
    this.endorseType = endorseType;
  }

  public RichSelectOneChoice getEndorseType() {
    return endorseType;
  }

  public void setMemDependantsLOV(RichTable memDependantsLOV) {
    this.memDependantsLOV = memDependantsLOV;
  }

  public RichTable getMemDependantsLOV() {
    return memDependantsLOV;
  }

  public void setEffectiveDate(RichInputDate effectiveDate) {
    this.effectiveDate = effectiveDate;
  }

  public RichInputDate getEffectiveDate() {
    return effectiveDate;
  }

  public void setConsultantLOV(RichTable consultantLOV) {
    this.consultantLOV = consultantLOV;
  }

  public RichTable getConsultantLOV() {
    return consultantLOV;
  }

  public void setConsultDesc(RichInputText consultDesc) {
    this.consultDesc = consultDesc;
  }

  public RichInputText getConsultDesc() {
    return consultDesc;
  }

  public void setClientDesc(RichInputText clientDesc) {
    this.clientDesc = clientDesc;
  }

  public RichInputText getClientDesc() {
    return clientDesc;
  }

  public void setClientLOV(RichTable clientLOV) {
    this.clientLOV = clientLOV;
  }

  public RichTable getClientLOV() {
    return clientLOV;
  }

  public void searchListener(SelectionEvent selectionEvent) {
    // Add event code here...
    try {
      DCIteratorBinding dciter =
        ADFUtils.findIterator("FindPolicyTransactionsIterator");
      RowKeySet set = transactions.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();

      //System.out.println(1);
      while (rowKeySetIter.hasNext()) {
        List l = (List)rowKeySetIter.next();
        Key key = (Key)l.get(0);
        dciter.setCurrentRowWithKey(key.toStringFormat(true));
        Row r = dciter.getCurrentRow();
        session.setAttribute("policyNumber",
                             r.getAttribute("LTR_POL_POLICY_NO"));
        session.setAttribute("endorsementCode",
                             r.getAttribute("LTR_ENDR_CODE"));
        session.setAttribute("policyCode", r.getAttribute("LTR_POL_CODE"));
        session.setAttribute("transactionNumber",
                             r.getAttribute("LTR_TRANS_NO"));

        session.setAttribute("prpCode", r.getAttribute("prp_code"));
        session.setAttribute("AgentCode", r.getAttribute("LTR_AGN_CODE"));

      }

      //Check Access for Policy....
      String Access =
        ValidateUserAccessForPolicy((BigDecimal)session.getAttribute("policyCode"));
      if (Access == null) {
        GlobalCC.errorValueNotEntered("You do not have rights to the Selected Policy. Cannot Proceed.");
        return;
      } else if (Access.equalsIgnoreCase("N")) {
        GlobalCC.errorValueNotEntered("You do not have rights to the Selected Policy. Cannot Proceed.");
        return;
      } else {
        //Do nothing....
      }

      ADFUtils.findIterator("findTicketDetailsByUserIterator").executeQuery();
      String Tasks = (String)session.getAttribute("ModuleTickets");
      if (Tasks.equalsIgnoreCase("Y")) {
        AdfFacesContext.getCurrentInstance().addPartialTarget(resultsLOV);
        myTickets.setRendered(true);
      } else {
        myTickets.setRendered(false);
      }

    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
  }

  public String ViewPolicyDetails() {
    try {
      session.setAttribute("editComponents", "N");
      GlobalCC.RedirectPage("/g_undwrt.jspx");
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
    return null;
  }

  public String AddClassLimit() {
    session.setAttribute("PCTL_CODE", null);
    feeAmount.setValue(null);

    if (session.getAttribute("pcaCode") == null) {
      GlobalCC.INFORMATIONREPORTING("Select A Class");
      return null;
    }
    // Render Popup
    ExtendedRenderKitService erkService =
      Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                         ExtendedRenderKitService.class);
    erkService.addScript(FacesContext.getCurrentInstance(),
                         "var hints = {autodismissNever:false}; " +
                         "AdfPage.PAGE.findComponent('" +
                         "lmsgroup:policyClassTermLimits" + "').show(hints);");
    return null;
  }

  public String DeleteClassTermLimit() {
    RowKeySet rowKeySet = policyClassTermLimitsLOV.getSelectedRowKeys();
    if (!rowKeySet.iterator().hasNext()) {
      GlobalCC.errorValueNotEntered("Error: No Record Selected");
      //return null;
    }

    Object key2 = rowKeySet.iterator().next();
    policyClassTermLimitsLOV.setRowKey(key2);

    JUCtrlValueBinding r =
      (JUCtrlValueBinding)policyClassTermLimitsLOV.getRowData();

    if (r == null) {
      GlobalCC.errorValueNotEntered("Error: No Record Selected");
      //return null;
    }
    session.setAttribute("PCTL_CODE", r.getAttribute("ctlCode"));
    String authQuery = "BEGIN LMS_WEB_PKG_GRP.deleteClasstermLimits(?,?);END;";
    Connection conn = new DBConnector().getDatabaseConn();
    try {
      CallableStatement cstmt = conn.prepareCall(authQuery);
      //System.out.println((BigDecimal)session.getAttribute("PCTL_CODE"));
      cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("PCTL_CODE"));
      cstmt.setString(2, "P");
      cstmt.execute();
      conn.close();
      String Message = "Class Term Limit deleted successfully.";
      FacesContext.getCurrentInstance().addMessage(null,
                                                   new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                    Message,
                                                                    Message));


      session.setAttribute("PCTL_CODE", null);
      ADFUtils.findIterator("findPolicyClassTermLimitsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(policyClassTermLimitsLOV);
    } catch (Exception ex) {
      GlobalCC.EXCEPTIONREPORTING(conn, ex);
    }
    return null;
  }

  public String EditClassTermLimit() {
    RowKeySet rowKeySet = policyClassTermLimitsLOV.getSelectedRowKeys();
    if (!rowKeySet.iterator().hasNext()) {
      GlobalCC.errorValueNotEntered("Error: No Record Selected");
      //return null;
    }

    Object key2 = rowKeySet.iterator().next();
    policyClassTermLimitsLOV.setRowKey(key2);

    JUCtrlValueBinding r =
      (JUCtrlValueBinding)policyClassTermLimitsLOV.getRowData();

    if (r == null) {
      GlobalCC.errorValueNotEntered("Error: No Record Selected");
      //return null;
    }
    session.setAttribute("PCTL_CODE", r.getAttribute("ctlCode"));
    classDesc.setValue(r.getAttribute("categDesc"));
    feeAmount.setValue(r.getAttribute("ctlFee"));
    // Render Popup
    ExtendedRenderKitService erkService =
      Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                         ExtendedRenderKitService.class);
    erkService.addScript(FacesContext.getCurrentInstance(),
                         "var hints = {autodismissNever:false}; " +
                         "AdfPage.PAGE.findComponent('" +
                         "lmsgroup:policyClassTermLimits" + "').show(hints);");
    return null;
  }

  public void setClassDesc(RichInputText classDesc) {
    this.classDesc = classDesc;
  }

  public RichInputText getClassDesc() {
    return classDesc;
  }

  public void setFeeAmount(RichInputText feeAmount) {
    this.feeAmount = feeAmount;
  }

  public RichInputText getFeeAmount() {
    return feeAmount;
  }

  public String SavePolicyClassTermLimit() {
    String updateQuery =
      "BEGIN LMS_WEB_PKG_GRP.updateClassTermLimits(?,?,?,?,?);END;";
    Connection conn = null;
    if (feeAmount.getValue() == null) {
      GlobalCC.sysInformation("Enter A Fee Amount.");
      return null;
    }
    try {
      conn = new DBConnector().getDatabaseConn();
      CallableStatement cstmt = conn.prepareCall(updateQuery);
      cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("PCTL_CODE"));
      cstmt.setBigDecimal(2,
                          (BigDecimal)session.getAttribute("endorsementCode"));
      cstmt.setBigDecimal(3, (BigDecimal)session.getAttribute("pcaCode"));
      cstmt.setString(4, feeAmount.getValue().toString());
      cstmt.setString(5, "P");

      cstmt.execute();
      conn.close();

      GlobalCC.sysInformation("Class Term Limit  saved Successfully.");
      session.setAttribute("PCTL_CODE", null);

      GlobalCC.hidePopup("lmsgroup:policyClassTermLimits");

      ADFUtils.findIterator("findPolicyClassTermLimitsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(policyClassTermLimitsLOV);
    } catch (Exception ex) {
      GlobalCC.EXCEPTIONREPORTING(conn, ex);
    }
    return null;
  }

  public String AssignClassCategories() {
    RowKeySet rowKeySet = classesLOV.getSelectedRowKeys();
    if (!rowKeySet.iterator().hasNext()) {
      GlobalCC.errorValueNotEntered("Error: No Record Selected");
      //return null;
    }

    Object key2 = rowKeySet.iterator().next();
    classesLOV.setRowKey(key2);

    JUCtrlValueBinding r = (JUCtrlValueBinding)classesLOV.getRowData();

    if (r == null) {
      GlobalCC.errorValueNotEntered("Error: No Record Selected");
      //return null;
    }
    session.setAttribute("pcaCode", r.getAttribute("PCA_CODE"));
    classDesc.setValue(r.getAttribute("catDesc"));

    GlobalCC.hidePopup("lmsgroup:classesPopup");
    ExtendedRenderKitService erkService =
      Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                         ExtendedRenderKitService.class);
    erkService.addScript(FacesContext.getCurrentInstance(),
                         "var hints = {autodismissNever:false}; " +
                         "AdfPage.PAGE.findComponent('" +
                         "lmsgroup:policyClassTermLimits" + "').show(hints);");
    return null;
  }

  public void setClassesLOV(RichTable classesLOV) {
    this.classesLOV = classesLOV;
  }

  public RichTable getClassesLOV() {
    return classesLOV;
  }

  public void setPolicyClassTermLimitsLOV(RichTable policyClassTermLimitsLOV) {
    this.policyClassTermLimitsLOV = policyClassTermLimitsLOV;
  }

  public RichTable getPolicyClassTermLimitsLOV() {
    return policyClassTermLimitsLOV;
  }

  public void setStudentsLOV(RichTable studentsLOV) {
    this.studentsLOV = studentsLOV;
  }

  public RichTable getStudentsLOV() {
    return studentsLOV;
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

  public String SaveUnitRate() {
    Connection conn = null;

    if (unitRateDisplay.getValue() == null) {
      String Message = "Please Key In a unit Rate";
      FacesContext.getCurrentInstance().addMessage(null,
                                                   new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                    Message,
                                                                    Message));

      return null;
    }
    if (unitRateDivisionFactor.getValue() == null) {
      String Message = "Please select  a unit Rate divisionn factor";
      FacesContext.getCurrentInstance().addMessage(null,
                                                   new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                    Message,
                                                                    Message));

      return null;
    }
    String updateQuery = "BEGIN LMS_GRP_WEB_PKG.updateUnitRate(?,?,?,?);END;";

    try {
      conn = new DBConnector().getDatabaseConn();
      CallableStatement cstmt = conn.prepareCall(updateQuery);
      cstmt.setString(1, unitRateDisplay.getValue().toString());
      cstmt.setBigDecimal(2,
                          (BigDecimal)session.getAttribute("endorsementCode"));
      cstmt.setString(3, unitRateDivisionFactor.getValue().toString());
      cstmt.setString(4, "P");
      // cstmt.setString(5, minClaimablePeriod.getValue().toString());

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
  }

  /* public void unitRateOptionListener(ValueChangeEvent valueChangeEvent) {
        if(unitRateOption.getValue()!=null) {
            if(unitRateOption.getValue().toString().equalsIgnoreCase("RATE")) {
                unitRateDisplay.setValue(null);
                unitRateDivFactor.setValue(null);
                ExtendedRenderKitService erkService =
                Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                ExtendedRenderKitService.class);
                erkService.addScript(FacesContext.getCurrentInstance(),
                "var hints = {autodismissNever:false}; " +
                "AdfPage.PAGE.findComponent('" + "lmsgroup:unitRatesPopup" +
                "').show(hints);");
            }
        }
    }*/

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

  public void policyCategoryListener(SelectionEvent selectionEvent) {
    // Add event code here...
    RowKeySet rowKeySet = policyCategories.getSelectedRowKeys();
    if (!rowKeySet.iterator().hasNext()) {
      GlobalCC.errorValueNotEntered("Error: No Record Selected");
      //return null;
    }

    Object key2 = rowKeySet.iterator().next();
    policyCategories.setRowKey(key2);

    JUCtrlValueBinding r = (JUCtrlValueBinding)policyCategories.getRowData();
    if (r == null) {
      GlobalCC.errorValueNotEntered("Error: No Record Selected");
      //return null;
    }

    session.setAttribute("pcaCode", r.getAttribute("PCA_CODE"));
    classDesc.setValue(r.getAttribute("PCA_CATEG_DESC"));

    ADFUtils.findIterator("findPolicyClassTermLimitsIterator").executeQuery();
    AdfFacesContext.getCurrentInstance().addPartialTarget(policyClassTermLimitsLOV);
  }

  public void PolicyCategoryTreeListener(SelectionEvent selectionEvent) {
    // Add event code here...
    // Add event code here...
    if (selectionEvent.getAddedSet() != selectionEvent.getRemovedSet()) {
      RowKeySet keys = selectionEvent.getAddedSet();
      if (keys != null && keys.getSize() > 0) {
        for (Object treeRowKey : keys) {
          categoryTree.setRowKey(treeRowKey);
          JUCtrlHierNodeBinding nd =
            (JUCtrlHierNodeBinding)categoryTree.getRowData();

          session.setAttribute("pcaCode",
                               nd.getRow().getAttribute("PCA_CODE"));
          dpdCatDescDisp1.setValue(nd.getRow().getAttribute("PCA_CATEG_DESC"));

          ADFUtils.findIterator("FindDependentsLimitsIterator").executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(policyDependentLimitsLOV);

        }
      }
    }
  }

  public String SchoolClassSelected() {
    try {
      DCIteratorBinding dciter =
        ADFUtils.findIterator("findSchClassesIterator");
      RowKeySet set = educClasses.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();

      //System.out.println(1);
      while (rowKeySetIter.hasNext()) {
        List l = (List)rowKeySetIter.next();
        Key key = (Key)l.get(0);
        dciter.setCurrentRowWithKey(key.toStringFormat(true));
        Row r = dciter.getCurrentRow();
        session.setAttribute("schCode", r.getAttribute("SCH_CODE"));
        catID.setValue(r.getAttribute("SCH_SHT_DESC"));
        catDesc.setValue(r.getAttribute("SCH_DESC"));
        catPeriod.setValue(r.getAttribute("SLVL_TERM_DURATION"));
        AdfFacesContext.getCurrentInstance().addPartialTarget(catID);
        AdfFacesContext.getCurrentInstance().addPartialTarget(catDesc);
        AdfFacesContext.getCurrentInstance().addPartialTarget(catPeriod);
      }

      GlobalCC.hidePopup("lmsgroup:p8");
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
    return null;
  }

  public void PolicyCoverTypeListener(ValueChangeEvent valueChangeEvent) {
    // Add event code here...
    if (valueChangeEvent.getNewValue() != null) {

      if (valueChangeEvent.getOldValue() != valueChangeEvent.getNewValue()) {
        if (dpdCoverType1.getValue() != null) {

          DCIteratorBinding dciter =
            ADFUtils.findIterator("FindCoverTypesIterator");
          Row r =
            dciter.getRowAtRangeIndex((Integer)valueChangeEvent.getNewValue());

          session.setAttribute("CoverTypeCode",
                               r.getAttribute("PCVT_CVT_CODE"));
          session.setAttribute("qcvtcvtCode", r.getAttribute("PCVT_CVT_CODE"));
          session.setAttribute("pcvtCode", r.getAttribute("PCVT_CODE"));
          session.setAttribute("pdlCode", null);

          dependentTypeDisplay1.setValue(null);
          ADFUtils.findIterator("FindDependentsIterator").executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(dependentTypeDisplay1);

        }
      }
    }
  }

  public void CoverTypeDependantListener(ValueChangeEvent valueChangeEvent) {
    // Add event code here...
    if (valueChangeEvent.getNewValue() != null) {

      if (valueChangeEvent.getOldValue() != valueChangeEvent.getNewValue()) {
        if (dependentTypeDisplay1.getValue() != null) {

          DCIteratorBinding dciter =
            ADFUtils.findIterator("FindDependentsIterator");
          Row r =
            dciter.getRowAtRangeIndex((Integer)valueChangeEvent.getNewValue());

          session.setAttribute("dtyCode", r.getAttribute("DTY_CODE"));
          session.setAttribute("maxType",
                               r.getAttribute("PCD_MAX_NO_ALLOWED"));
          maxTypeDisplay.setValue(r.getAttribute("PCD_MAX_NO_ALLOWED"));
          limitAmountDisplay.setValue(r.getAttribute("PCD_MAX_SUM_ASSURED"));
          minAmountDisplay.setValue(r.getAttribute("PCD_MIN_SUM_ASSURED"));
          //limitAmountDisplay.setValue(null);

          AdfFacesContext.getCurrentInstance().addPartialTarget(dependentTypeDisplay1);
          AdfFacesContext.getCurrentInstance().addPartialTarget(limitAmountDisplay);
          AdfFacesContext.getCurrentInstance().addPartialTarget(maxTypeDisplay);

        }
      }
    }
  }

  public String AddDependantLimit() {
    try {

      if (session.getAttribute("pcaCode") == null) {
        GlobalCC.INFORMATIONREPORTING("Select A Category");
        return null;
      }
      dpdCoverType1.setValue(null);
      dependentTypeDisplay1.setValue(null);
      maxTypeDisplay.setValue(null);
      limitAmountDisplay.setValue(null);
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

  public String SaveDependentLimit1() {

    String updateQuery =
      "BEGIN LMS_WEB_PKG_GRP.updatedependentlimits(?,?,?,?,?,?,?,?,?,?,?);END;";
    Connection conn = new DBConnector().getDatabaseConn();
    try {
      CallableStatement cstmt = conn.prepareCall(updateQuery);
      cstmt.setBigDecimal(1, (BigDecimal)session.getAttribute("pdlCode"));
      cstmt.setBigDecimal(2, null);
      cstmt.setBigDecimal(3, (BigDecimal)session.getAttribute("dtyCode"));
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
      cstmt.setBigDecimal(6, (BigDecimal)session.getAttribute("pcvtCode"));
      cstmt.setBigDecimal(7,
                          (BigDecimal)session.getAttribute("CoverTypeCode"));
      cstmt.setBigDecimal(8,
                          (BigDecimal)session.getAttribute("endorsementCode"));
      cstmt.setBigDecimal(9, (BigDecimal)session.getAttribute("pcaCode"));
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
      GlobalCC.EXCEPTIONREPORTING(conn, ex);
    }
    return null;
  }

  public String findScheduleSelected() {
    String Rate = null;
    DCIteratorBinding dciter =
      ADFUtils.findIterator("FindPolicySchedulesIterator");
    RowKeySet set = schedulesTable.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();

    //System.out.println(1);
    while (rowKeySetIter.hasNext()) {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();


      //LOVCC.TaxesCode=(BigDecimal)r.getAttribute("TT_CODE");
      session.setAttribute("scheduleNo",
                           r.getAttribute("ENDR_MEM_CURRENT_SCH_NO"));
      schedulesDesc.setValue(r.getAttribute("ENDR_MEM_CURRENT_SCH_NO"));
    }
    ADFUtils.findIterator("findScheduleMembersIterator").executeQuery();
    AdfFacesContext.getCurrentInstance().addPartialTarget(scheduleMembers);

    return null;
  }

  public String DeleteScheduleMembers() {
    Connection conn = null;
    try {
      RowKeySet rowKeySet = scheduleMembers.getSelectedRowKeys();

      if (!rowKeySet.iterator().hasNext()) {
        GlobalCC.errorValueNotEntered("No Record Selected");
        return null;
      }
      Iterator rksIter = rowKeySet.iterator();
      while (rksIter.hasNext()) {
        Object key2 = rksIter.next();
        scheduleMembers.setRowKey(key2);
        JUCtrlValueBinding r =
          (JUCtrlValueBinding)scheduleMembers.getRowData();
        if (r == null) {
          GlobalCC.errorValueNotEntered("No Record Selected");
          return null;
        }
        System.out.println("MemCoddeII " + r.getAttribute("POLM_MEM_NO"));
        session.setAttribute("PolmCode", r.getAttribute("POLM_CODE"));
        session.setAttribute("PolmMemCode", r.getAttribute("POLM_MEM_CODE"));


        String endorseType = (String)session.getAttribute("endrValue");
        if (endorseType == null) {
          //do nothing
        } else if (endorseType.equalsIgnoreCase("NB") ||
                   endorseType.equalsIgnoreCase("AP") ||
                   endorseType.equalsIgnoreCase("RN")) {
          String deleteMember =
            "BEGIN lms_web_pkg_grp_uw.delete_schedule(?,?,?,?);END;";
          conn = new DBConnector().getDatabaseConn();
          CallableStatement cstmt = conn.prepareCall(deleteMember);

          cstmt.setBigDecimal(1,
                              (BigDecimal)session.getAttribute("policyCode"));
          cstmt.setBigDecimal(2, (BigDecimal)session.getAttribute("PolmCode"));
          cstmt.setBigDecimal(3,
                              (BigDecimal)session.getAttribute("PolmMemCode"));
          cstmt.setBigDecimal(4,
                              (BigDecimal)session.getAttribute("endorsementCode"));

          cstmt.execute();
          conn.close();
        } else {
          DeleteMemberOnEndorsement();
        }

      }
      ADFUtils.findIterator("findScheduleMembersIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(scheduleMembers);
      GlobalCC.sysInformation("Members Successfully Deleted.");
    } catch (Exception e) {
      ADFUtils.findIterator("findScheduleMembersIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(scheduleMembers);
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }

    return null;
  }

  public void setCategoryTree(RichTree categoryTree) {
    this.categoryTree = categoryTree;
  }

  public RichTree getCategoryTree() {
    return categoryTree;
  }

  public void setEducClasses(RichTable educClasses) {
    this.educClasses = educClasses;
  }

  public RichTable getEducClasses() {
    return educClasses;
  }

  public void setDpdCoverType1(RichSelectOneChoice dpdCoverType1) {
    this.dpdCoverType1 = dpdCoverType1;
  }

  public RichSelectOneChoice getDpdCoverType1() {
    return dpdCoverType1;
  }

  public void setDpdCatDescDisp1(RichOutputText dpdCatDescDisp1) {
    this.dpdCatDescDisp1 = dpdCatDescDisp1;
  }

  public RichOutputText getDpdCatDescDisp1() {
    return dpdCatDescDisp1;
  }

  public void setDependentTypeDisplay1(RichSelectOneChoice dependentTypeDisplay1) {
    this.dependentTypeDisplay1 = dependentTypeDisplay1;
  }

  public RichSelectOneChoice getDependentTypeDisplay1() {
    return dependentTypeDisplay1;
  }

  public void setSchedulesTable(RichTable schedulesTable) {
    this.schedulesTable = schedulesTable;
  }

  public RichTable getSchedulesTable() {
    return schedulesTable;
  }

  public void setSchedulesDesc(RichInputText schedulesDesc) {
    this.schedulesDesc = schedulesDesc;
  }

  public RichInputText getSchedulesDesc() {
    return schedulesDesc;
  }

  public void setScheduleMembers(RichTable scheduleMembers) {
    this.scheduleMembers = scheduleMembers;
  }

  public RichTable getScheduleMembers() {
    return scheduleMembers;
  }

  public void setAgencyDesc(RichInputText agencyDesc) {
    this.agencyDesc = agencyDesc;
  }

  public RichInputText getAgencyDesc() {
    return agencyDesc;
  }

  public void setAgencyTable(RichTable agencyTable) {
    this.agencyTable = agencyTable;
  }

  public RichTable getAgencyTable() {
    return agencyTable;
  }

  public String findGovtAgencySelected() {
    try {
      RowKeySet rowKeySet = agencyTable.getSelectedRowKeys();
      if (!rowKeySet.iterator().hasNext()) {
        GlobalCC.errorValueNotEntered("Error: No Record Selected");
        //return null;
      }

      Object key2 = rowKeySet.iterator().next();
      agencyTable.setRowKey(key2);

      JUCtrlValueBinding r = (JUCtrlValueBinding)agencyTable.getRowData();
      if (r == null) {
        GlobalCC.errorValueNotEntered("Error: No Record Selected");
        //return null;
      }

      session.setAttribute("gagnCode", r.getAttribute("SPR_CODE"));
      agencyDesc.setValue(r.getAttribute("SPR_NAME"));
      AdfFacesContext.getCurrentInstance().addPartialTarget(agencyDesc);

      GlobalCC.hidePopup("lmsgroup:govtAgncies");
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
    return null;
  }

  public String AddGovtAuthority() {

    session.setAttribute("gagnCode", null);
    session.setAttribute("govtAuthCode", null);
    session.setAttribute("action", "A");
    agencyDesc.setValue(null);
    govtRemarks.setValue(null);
    valuationDate.setValue(null);
    valuationFreq.setValue(null);
    GlobalCC.showPopup("lmsgroup:govtAuth");

    return null;
  }

  public String EditGovtAuthority() {
    try {
      RowKeySet rowKeySet = govtAuthoritiesTable.getSelectedRowKeys();
      if (!rowKeySet.iterator().hasNext()) {
        GlobalCC.errorValueNotEntered("Error: No Record Selected");
        //return null;
      }

      Object key2 = rowKeySet.iterator().next();
      govtAuthoritiesTable.setRowKey(key2);

      JUCtrlValueBinding r =
        (JUCtrlValueBinding)govtAuthoritiesTable.getRowData();
      if (r == null) {
        GlobalCC.errorValueNotEntered("Error: No Record Selected");
        //return null;
      }


      session.setAttribute("govtAuthCode", r.getAttribute("LGA_CODE"));
      session.setAttribute("gagnCode", r.getAttribute("LGA_AGN_CODE"));
      agencyDesc.setValue(r.getAttribute("AGN_NAME"));
      govtRemarks.setValue(r.getAttribute("LGA_REMARKS"));
      valuationDate.setValue(r.getAttribute("LGA_START_DATE"));
      valuationFreq.setValue(r.getAttribute("LGA_VAL_FREQ"));
      session.setAttribute("action", "E");
      AdfFacesContext.getCurrentInstance().addPartialTarget(agencyDesc);
      AdfFacesContext.getCurrentInstance().addPartialTarget(valuationFreq);

      GlobalCC.showPopup("lmsgroup:govtAuth");
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
    return null;
  }

  public String DeleteGovtAuthority() {
    try {
      RowKeySet rowKeySet = govtAuthoritiesTable.getSelectedRowKeys();
      if (!rowKeySet.iterator().hasNext()) {
        GlobalCC.errorValueNotEntered("Error: No Record Selected");
        //return null;
      }

      Object key2 = rowKeySet.iterator().next();
      govtAuthoritiesTable.setRowKey(key2);

      JUCtrlValueBinding r =
        (JUCtrlValueBinding)govtAuthoritiesTable.getRowData();
      if (r == null) {
        GlobalCC.errorValueNotEntered("Error: No Record Selected");
        //return null;
      }


      session.setAttribute("govtAuthCode", r.getAttribute("LGA_CODE"));
      session.setAttribute("gagnCode", r.getAttribute("LGA_AGN_CODE"));
      agencyDesc.setValue(r.getAttribute("AGN_NAME"));
      govtRemarks.setValue(r.getAttribute("LGA_REMARKS"));
      valuationDate.setValue(r.getAttribute("LGA_START_DATE"));
      valuationFreq.setValue(r.getAttribute("LGA_VAL_FREQ"));
      session.setAttribute("action", "D");
      //AdfFacesContext.getCurrentInstance().addPartialTarget(agencyDesc);
      SaveGovtAuthority();

    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
    return null;
  }

  public String SaveGovtAuthority() {
    Connection conn = null;
    try {
      DBConnector MyDB = new DBConnector();
      conn = MyDB.getDatabaseConn();
      CallableStatement cst =
        conn.prepareCall("BEGIN lms_web_pkg_grp_uw.save_govt_authority(?,?,?,?,?,?,?,?);END;");
      cst.setString(1, (String)session.getAttribute("action"));
      cst.setBigDecimal(2, (BigDecimal)session.getAttribute("govtAuthCode"));
      cst.setBigDecimal(3, (BigDecimal)session.getAttribute("policyCode"));
      cst.setBigDecimal(4,
                        (BigDecimal)session.getAttribute("endorsementCode"));
      cst.setBigDecimal(5, (BigDecimal)session.getAttribute("gagnCode"));
      if (govtRemarks.getValue() == null) {
        cst.setString(6, null);
      } else {
        cst.setString(6, govtRemarks.getValue().toString());
      }
      if (valuationDate.getValue() == null) {
        cst.setString(7, null);
      } else {
        if (valuationDate.getValue().toString().contains(":")) {
          cst.setString(7,
                        GlobalCC.parseDate(valuationDate.getValue().toString()));
        } else {
          cst.setString(7,
                        GlobalCC.upDateParseDate(valuationDate.getValue().toString()));
        }

      }
      if (valuationFreq.getValue() == null) {
        cst.setString(8, null);
      } else {
        cst.setString(8, valuationFreq.getValue().toString());
      }
      cst.execute();
      cst.close();
      conn.close();

      GlobalCC.INFORMATIONREPORTING("Transaction Completed Successfully");

      ADFUtils.findIterator("FindGovernmentAuthoritiesIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(govtAuthoritiesTable);

    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
  }

  public void setGovtRemarks(RichInputText govtRemarks) {
    this.govtRemarks = govtRemarks;
  }

  public RichInputText getGovtRemarks() {
    return govtRemarks;
  }

  public void setGovtAuthoritiesTable(RichTable govtAuthoritiesTable) {
    this.govtAuthoritiesTable = govtAuthoritiesTable;
  }

  public RichTable getGovtAuthoritiesTable() {
    return govtAuthoritiesTable;
  }

  public void setValuationDate(RichInputDate valuationDate) {
    this.valuationDate = valuationDate;
  }

  public RichInputDate getValuationDate() {
    return valuationDate;
  }

  public void setValuationFreq(RichSelectOneChoice valuationFreq) {
    this.valuationFreq = valuationFreq;
  }

  public RichSelectOneChoice getValuationFreq() {
    return valuationFreq;
  }

  public String AddFirstReceipt() {
    this.session.setAttribute("gfrtCode", null);
    this.session.setAttribute("GrctCode", null);
    this.receiptsDesc.setValue(null);
    this.receiptTotAmt.setValue(null);
    this.receiptResvAmt.setValue(null);
    this.receiptsTransAmt.setValue(null);
    this.receiptBalAmt.setValue(null);
    this.session.setAttribute("action", "A");

    ADFUtils.findIterator("findCreditReceiptsIterator").executeQuery();
    AdfFacesContext.getCurrentInstance().addPartialTarget(receiptsLOV);

    GlobalCC.showPopup("lmsgroup:p9");

    return null;
  }

  public String EditFirstReceipt() {
    try {
      DCIteratorBinding dciter =
        ADFUtils.findIterator("FindPolicyFirstReceiptsIterator");

      RowKeySet set = this.firstReceiptsTbl.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();

      while (rowKeySetIter.hasNext()) {
        List l = (List)rowKeySetIter.next();
        Key key = (Key)l.get(0);
        dciter.setCurrentRowWithKey(key.toStringFormat(true));
        Row r = dciter.getCurrentRow();

        this.session.setAttribute("gfrtCode", r.getAttribute("GFRT_CODE"));
        this.session.setAttribute("GrctCode", r.getAttribute("GRCT_CODE"));
        this.receiptsDesc.setValue(r.getAttribute("GRCT_RECEIPT_NO"));
        this.receiptTotAmt.setValue(r.getAttribute("MTRAN_AMOUNT"));
        this.receiptBalAmt.setValue(r.getAttribute("MTRAN_BALANCE"));
        this.receiptResvAmt.setValue(r.getAttribute("MTRAN_RCPT_RESERVE_AMT"));
        this.receiptsTransAmt.setValue(r.getAttribute("GFRT_AMT"));
        this.session.setAttribute("action", "E");
        GlobalCC.showPopup("lmsgroup:p9");
      }
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
    return null;
  }

  public String DeleteFirstReceipt() {
    try {
      DCIteratorBinding dciter =
        ADFUtils.findIterator("FindPolicyFirstReceiptsIterator");

      RowKeySet set = this.firstReceiptsTbl.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();

      while (rowKeySetIter.hasNext()) {
        List l = (List)rowKeySetIter.next();
        Key key = (Key)l.get(0);
        dciter.setCurrentRowWithKey(key.toStringFormat(true));
        Row r = dciter.getCurrentRow();

        this.session.setAttribute("gfrtCode", r.getAttribute("GFRT_CODE"));
        this.session.setAttribute("GrctCode", r.getAttribute("GRCT_CODE"));
        this.receiptsDesc.setValue(r.getAttribute("GRCT_RECEIPT_NO"));
        this.receiptTotAmt.setValue(r.getAttribute("MTRAN_AMOUNT"));
        this.receiptBalAmt.setValue(r.getAttribute("MTRAN_BALANCE"));
        this.receiptResvAmt.setValue(r.getAttribute("MTRAN_RCPT_RESERVE_AMT"));
        this.receiptsTransAmt.setValue(r.getAttribute("GFRT_AMT"));

        this.session.setAttribute("action", "D");
        SaveFirstReceipt();
      }
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
    return null;
  }

  public String findReceiptSelected() {
    DCIteratorBinding dciter =
      ADFUtils.findIterator("findCreditReceiptsIterator");

    RowKeySet set = this.receiptsLOV.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();

    while (rowKeySetIter.hasNext()) {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();

      this.session.setAttribute("GrctCode",
                                r.getAttribute("mtran_lms_receipt_pk"));
      this.receiptsDesc.setValue(r.getAttribute("CRA_MTRAN_REF_NO"));
      this.receiptTotAmt.setValue(r.getAttribute("CRA_MTRAN_AMOUNT"));
      this.receiptResvAmt.setValue(r.getAttribute("mtran_rcpt_reserve_amt"));
      this.receiptBalAmt.setValue(r.getAttribute("CRA_MTRAN_BALANCE"));

      AdfFacesContext.getCurrentInstance().addPartialTarget(this.receiptsDesc);
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.receiptTotAmt);
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.receiptResvAmt);
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.receiptBalAmt);
    }
    GlobalCC.hidePopup("lmsgroup:p10");

    return null;
  }

  public String SaveFirstReceipt() {
    Connection conn = null;
    try {
      DBConnector MyConn = new DBConnector();
      conn = MyConn.getDatabaseConn();

      CallableStatement cst =
        conn.prepareCall("BEGIN lms_web_pkg_grp_uw.save_first_receipt(?,?,?,?,?,?);END;");

      cst.setString(1, (String)this.session.getAttribute("action"));
      cst.setBigDecimal(2, (BigDecimal)this.session.getAttribute("gfrtCode"));
      if (this.receiptsTransAmt.getValue() == null)
        cst.setString(3, null);
      else {
        cst.setString(3, this.receiptsTransAmt.getValue().toString());
      }
      cst.setBigDecimal(4,
                        (BigDecimal)this.session.getAttribute("policyCode"));
      cst.setBigDecimal(5,
                        (BigDecimal)this.session.getAttribute("endorsementCode"));
      cst.setBigDecimal(6, (BigDecimal)this.session.getAttribute("GrctCode"));
      cst.execute();

      cst.close();
      conn.close();

      GlobalCC.INFORMATIONREPORTING("Transaction Successfully Completed.");

      ADFUtils.findIterator("FindPolicyFirstReceiptsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.firstReceiptsTbl);
      GlobalCC.hidePopup("lmsgroup:p9");
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
  }

  public void setReceiptsDesc(RichInputText receiptsDesc) {
    this.receiptsDesc = receiptsDesc;
  }

  public RichInputText getReceiptsDesc() {
    return this.receiptsDesc;
  }

  public void setReceiptsLOV(RichTable receiptsLOV) {
    this.receiptsLOV = receiptsLOV;
  }

  public RichTable getReceiptsLOV() {
    return this.receiptsLOV;
  }

  public void setReceiptTotAmt(RichInputNumberSpinbox receiptTotAmt) {
    this.receiptTotAmt = receiptTotAmt;
  }

  public RichInputNumberSpinbox getReceiptTotAmt() {
    return this.receiptTotAmt;
  }

  public void setReceiptResvAmt(RichInputNumberSpinbox receiptResvAmt) {
    this.receiptResvAmt = receiptResvAmt;
  }

  public RichInputNumberSpinbox getReceiptResvAmt() {
    return this.receiptResvAmt;
  }

  public void setReceiptsTransAmt(RichInputNumberSpinbox receiptsTransAmt) {
    this.receiptsTransAmt = receiptsTransAmt;
  }

  public RichInputNumberSpinbox getReceiptsTransAmt() {
    return this.receiptsTransAmt;
  }

  public void setFirstReceiptsTbl(RichTable firstReceiptsTbl) {
    this.firstReceiptsTbl = firstReceiptsTbl;
  }

  public RichTable getFirstReceiptsTbl() {
    return this.firstReceiptsTbl;
  }

  public void setReceiptBalAmt(RichInputNumberSpinbox receiptBalAmt) {
    this.receiptBalAmt = receiptBalAmt;
  }

  public RichInputNumberSpinbox getReceiptBalAmt() {
    return this.receiptBalAmt;
  }

  public void setCategoryStudents(RichInputText categoryStudents) {
    this.categoryStudents = categoryStudents;
  }

  public RichInputText getCategoryStudents() {
    return categoryStudents;
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
      session.setAttribute("catlpagCode", r.getAttribute("LPAG_CODE"));

      AdfFacesContext.getCurrentInstance().addPartialTarget(accessGrpDisplay);
      GlobalCC.hidePopup("lmsgroup:popup9");

    }
    return null;
  }

  public RichTable getAccessGrpTable() {
    return accessGrpTable;
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

  public void setTrusteeSurname(RichInputText trusteeSurname) {
    this.trusteeSurname = trusteeSurname;
  }

  public RichInputText getTrusteeSurname() {
    return trusteeSurname;
  }

  public void setTrusteeOtherNames(RichInputText trusteeOtherNames) {
    this.trusteeOtherNames = trusteeOtherNames;
  }

  public RichInputText getTrusteeOtherNames() {
    return trusteeOtherNames;
  }

  public void setTrusteeStatus(RichSelectOneChoice trusteeStatus) {
    this.trusteeStatus = trusteeStatus;
  }

  public RichSelectOneChoice getTrusteeStatus() {
    return trusteeStatus;
  }


  public void setTrusteeTelNo(RichInputText trusteeTelNo) {
    this.trusteeTelNo = trusteeTelNo;
  }

  public RichInputText getTrusteeTelNo() {
    return trusteeTelNo;
  }

  public void setTrusteePinNo(RichInputText trusteePinNo) {
    this.trusteePinNo = trusteePinNo;
  }

  public RichInputText getTrusteePinNo() {
    return trusteePinNo;
  }

  public void setTrusteeIdNo(RichInputText trusteeIdNo) {
    this.trusteeIdNo = trusteeIdNo;
  }

  public RichInputText getTrusteeIdNo() {
    return trusteeIdNo;
  }

  public void setTrusteeCertNo(RichInputText trusteeCertNo) {
    this.trusteeCertNo = trusteeCertNo;
  }

  public RichInputText getTrusteeCertNo() {
    return trusteeCertNo;
  }

  public void setTrusteeAddr(RichInputText trusteeAddr) {
    this.trusteeAddr = trusteeAddr;
  }

  public RichInputText getTrusteeAddr() {
    return trusteeAddr;
  }

  public void setTrusteeRenDate(RichInputDate trusteeRenDate) {
    this.trusteeRenDate = trusteeRenDate;
  }

  public RichInputDate getTrusteeRenDate() {
    return trusteeRenDate;
  }

  public void setTrusteeWEF(RichInputDate trusteeWEF) {
    this.trusteeWEF = trusteeWEF;
  }

  public RichInputDate getTrusteeWEF() {
    return trusteeWEF;
  }

  public void setTrusteeWET(RichInputDate trusteeWET) {
    this.trusteeWET = trusteeWET;
  }

  public RichInputDate getTrusteeWET() {
    return trusteeWET;
  }

  public String saveTrusteeDetails() {
    // Add event code here...
    if (session.getAttribute("trusteeCode") == null) {
      session.setAttribute("action", "A");
    }
    add_update_trustees();
    GlobalCC.hidePopup("lmsgroup:trustee_popup");
    return null;
  }

  public void setTrusteesTable(RichTable trusteesTable) {
    this.trusteesTable = trusteesTable;
  }

  public RichTable getTrusteesTable() {
    return trusteesTable;
  }

  public String editTrusteesDetails() {
    // Add event code here...
    DCIteratorBinding dciter =
      ADFUtils.findIterator("FindPensionTrusteesIterator");
    RowKeySet set = trusteesTable.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
    try {

      while (rowKeySetIter.hasNext()) {
        List l = (List)rowKeySetIter.next();
        Key key = (Key)l.get(0);
        dciter.setCurrentRowWithKey(key.toStringFormat(true));
        Row r = dciter.getCurrentRow();
        session.setAttribute("trusteeCode", r.getAttribute("LPT_CODE"));
        session.setAttribute("action", "E");
        trusteeSurname.setValue(r.getAttribute("LPT_SURNAME"));
        trusteeOtherNames.setValue(r.getAttribute("LPT_OTHER_NAMES"));
        trusteeStatus.setValue(r.getAttribute("STATUS"));
        trusteeRepresentation.setValue(r.getAttribute("LPT_REPRESENTATION"));
        trusteeTelNo.setValue(r.getAttribute("LPT_TEL_NO"));
        trusteePinNo.setValue(r.getAttribute("LPT_PIN_NO"));
        trusteeIdNo.setValue(r.getAttribute("LPT_ID_NO"));
        trusteeCertNo.setValue(r.getAttribute("LPT_CERT_NO"));
        trusteeAddr.setValue(r.getAttribute("LPT_ADDRESS"));
        //System.out.println(dateFormat.format(r.getAttribute("LPT_REN_DATE")));
        if (r.getAttribute("LPT_WEF_DATE") == null) {
          trusteeWEF.setValue(null);
        } else {
          trusteeWEF.setValue(dateFormat.format(r.getAttribute("LPT_WEF_DATE")));
        }

        if (r.getAttribute("LPT_REN_DATE") == null) {
          trusteeRenDate.setValue(null);
        } else {

          trusteeRenDate.setValue(dateFormat.format(r.getAttribute("LPT_REN_DATE")));
        }

        if (r.getAttribute("LPT_WET_DATE") == null) {
          trusteeWET.setValue(null);
        } else {
          trusteeWET.setValue(dateFormat.format(r.getAttribute("LPT_WET_DATE")));
        }

        trusteePhyAddr.setValue(r.getAttribute("LPT_PHYSICAL_ADDR"));
//        removedLpt.setValue(r.getAttribute("LPT_REMOVED"));
        AdfFacesContext.getCurrentInstance().addPartialTarget(trusteeSurname);
        AdfFacesContext.getCurrentInstance().addPartialTarget(trusteeStatus);
        AdfFacesContext.getCurrentInstance().addPartialTarget(trusteeRepresentation);
        AdfFacesContext.getCurrentInstance().addPartialTarget(trusteeTelNo);
        AdfFacesContext.getCurrentInstance().addPartialTarget(trusteePinNo);
        AdfFacesContext.getCurrentInstance().addPartialTarget(trusteeIdNo);
        AdfFacesContext.getCurrentInstance().addPartialTarget(trusteeCertNo);
        AdfFacesContext.getCurrentInstance().addPartialTarget(trusteeAddr);
        AdfFacesContext.getCurrentInstance().addPartialTarget(trusteeRenDate);
        AdfFacesContext.getCurrentInstance().addPartialTarget(trusteeWEF);
        AdfFacesContext.getCurrentInstance().addPartialTarget(trusteeWET);
        AdfFacesContext.getCurrentInstance().addPartialTarget(trusteePhyAddr);
        AdfFacesContext.getCurrentInstance().addPartialTarget(trusteeOtherNames);
       // AdfFacesContext.getCurrentInstance().addPartialTarget(removedLpt);
      }
      GlobalCC.showPopup("lmsgroup:trustee_popup");
    } catch (Exception Ex) {
      Ex.printStackTrace();
      GlobalCC.EXCEPTIONREPORTING(null, Ex);
    }

    //GlobalCC.hidePopup("lmsgroup:trustee_popup");
    return null;
  }

  public String getMemberStatus(String mem_title) {
    if (mem_title.equals("Chair")) {
      return "C";
    } else if (mem_title.equals("Trust")) {
      return "T";
    } else {
      return "M";
    }

  }

  public void add_update_trustees() {
    Connection conn = null;
    // session.setAttribute("action", "A");
    try {
      DBConnector MyDB = new DBConnector();
      conn = MyDB.getDatabaseConn();
      CallableStatement cst =
        conn.prepareCall("BEGIN lms_web_pkg_grp.update_pension_trustees(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);END;");
      cst.setString(1, (String)session.getAttribute("action"));
      if (trusteeStatus.getValue() == null) {
        cst.setString(2, null);
      } else {
        cst.setString(2, trusteeStatus.getValue().toString());
      }
      cst.setBigDecimal(3,
                        (BigDecimal)session.getAttribute("endorsementCode"));

      if (trusteeRepresentation.getValue() == null) {
        cst.setString(4, null);
      } else {
        cst.setString(4, trusteeRepresentation.getValue().toString());
      }
      if (trusteeTelNo.getValue() == null) {
        cst.setString(5, null);
      } else {
        cst.setString(5, trusteeTelNo.getValue().toString());
      }
      if (trusteePinNo.getValue() == null) {
        cst.setString(6, null);
      } else {
        cst.setString(6, trusteePinNo.getValue().toString());
      }

      if (trusteeIdNo.getValue() == null) {
        cst.setString(7, null);
      } else {
        cst.setString(7, trusteeIdNo.getValue().toString());
      }
      if (trusteeCertNo.getValue() == null) {
        cst.setString(8, null);
      } else {
        cst.setString(8, trusteeCertNo.getValue().toString());
      }
      if (trusteeWEF.getValue() == null) {
        cst.setString(9, null);
      } else {
        cst.setString(9, GlobalCC.parseDate(trusteeWEF.getValue().toString()));
      }
      if (trusteeWET.getValue() == null) {
        cst.setString(10, null);
      } else {
        cst.setString(10,
                      GlobalCC.parseDate(trusteeWET.getValue().toString()));
      }
      if (trusteeRenDate.getValue() == null) {
        cst.setString(11, null);
      } else {
        cst.setString(11,
                      GlobalCC.parseDate(trusteeRenDate.getValue().toString()));
      }
      if (trusteeAddr.getValue() == null) {
        cst.setString(12, null);
      } else {
        cst.setString(12, trusteeAddr.getValue().toString());
      }
      if (trusteeSurname.getValue() == null) {
        cst.setString(13, null);
      } else {
        cst.setString(13, trusteeSurname.getValue().toString());
      }
      if (trusteeOtherNames.getValue() == null) {
        cst.setString(14, null);
      } else {
        cst.setString(14, trusteeOtherNames.getValue().toString());
      }
      cst.setBigDecimal(15, (BigDecimal)session.getAttribute("trusteeCode"));
      if (trusteePhyAddr.getValue() == null) {
        cst.setString(16, null);
      } else {
        cst.setString(16, trusteePhyAddr.getValue().toString());
      }
     


      cst.execute();
      cst.close();
      conn.close();

      ADFUtils.findIterator("FindPensionTrusteesIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.trusteesTable);

    } catch (Exception Ex) {
      GlobalCC.EXCEPTIONREPORTING(conn, Ex);
      Ex.printStackTrace();

    }
  }


  public String deleteTrusteeAction() {
    // Add event code here...
    DCIteratorBinding dciter =
      ADFUtils.findIterator("FindPensionTrusteesIterator");
    RowKeySet set = trusteesTable.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();

    while (rowKeySetIter.hasNext()) {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();
      session.setAttribute("trusteeCode", r.getAttribute("LPT_CODE"));
      session.setAttribute("action", "D");
    }
    add_update_trustees();
    GlobalCC.INFORMATIONREPORTING("Record deleted successfully");

    return null;
  }

  public String addServiceProvider() {
    DCIteratorBinding dciter =
      ADFUtils.findIterator("FindServiceProvidersIterator");
    RowKeySet set = serviceProviderLOV.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();

    while (rowKeySetIter.hasNext()) {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();
      session.setAttribute("providerCode", r.getAttribute("SPR_CODE"));

      add_delete_service_provider("A");
      GlobalCC.INFORMATIONREPORTING("Record successfully saved");
    }
    return null;
  }

  public void add_delete_service_provider(String Action) {
    Connection conn = null;
    // session.setAttribute("action", "A");
    try {
      DBConnector MyDB = new DBConnector();
      conn = MyDB.getDatabaseConn();
      CallableStatement cst =
        conn.prepareCall("BEGIN lms_web_pkg_grp.attach_service_provider(?,?,?);END;");

      cst.setString(1, Action);
      cst.setBigDecimal(2, (BigDecimal)session.getAttribute("policyCode"));
      cst.setBigDecimal(3, (BigDecimal)session.getAttribute("providerCode"));
      cst.execute();
      cst.close();
      conn.close();

      ADFUtils.findIterator("FindPolicyServiceProvidersIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.polfacilitatorsLOV);

    } catch (Exception Ex) {
      GlobalCC.EXCEPTIONREPORTING(conn, Ex);
      Ex.printStackTrace();

    }
  }

  public void setServiceProviderLOV(RichTable serviceProviderLOV) {
    this.serviceProviderLOV = serviceProviderLOV;
  }

  public RichTable getServiceProviderLOV() {
    return serviceProviderLOV;
  }

  public void setPolfacilitatorsLOV(RichTable polfacilitatorsLOV) {
    this.polfacilitatorsLOV = polfacilitatorsLOV;
  }

  public RichTable getPolfacilitatorsLOV() {
    return polfacilitatorsLOV;
  }

  public String deleteServiceProvider() {
    DCIteratorBinding dciter =
      ADFUtils.findIterator("FindPolicyServiceProvidersIterator");
    RowKeySet set = polfacilitatorsLOV.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();

    while (rowKeySetIter.hasNext()) {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();
      session.setAttribute("providerCode", r.getAttribute("SPR_CODE"));

      add_delete_service_provider("D");
      GlobalCC.INFORMATIONREPORTING("Record deleted successfully");
    }
    return null;
  }

  public String addTrusteesDetails() {
    // Add event code here...
    session.setAttribute("trusteeCode", null);
    trusteeSurname.setValue(null);
    trusteeOtherNames.setValue(null);
    trusteeStatus.setValue(null);
    trusteeRepresentation.setValue(null);
    trusteeTelNo.setValue(null);
    trusteePinNo.setValue(null);
    trusteeIdNo.setValue(null);
    trusteeCertNo.setValue(null);
    trusteeAddr.setValue(null);
    trusteeRenDate.setValue(null);
    trusteeWEF.setValue(null);
    trusteeWET.setValue(null);

    GlobalCC.showPopup("lmsgroup:trustee_popup");
    return null;
  }

  public void setTrusteeRepresentation(RichSelectOneChoice trusteeRepresentation) {
    this.trusteeRepresentation = trusteeRepresentation;
  }

  public RichSelectOneChoice getTrusteeRepresentation() {
    return trusteeRepresentation;
  }

  public void setTrusteePhyAddr(RichInputText trusteePhyAddr) {
    this.trusteePhyAddr = trusteePhyAddr;
  }

  public RichInputText getTrusteePhyAddr() {
    return trusteePhyAddr;
  }

  public void setRemarksTextArea(RichInputText remarksTextArea) {
    this.remarksTextArea = remarksTextArea;
  }

  public RichInputText getRemarksTextArea() {
    return remarksTextArea;
  }

  public void setSaveRemarks(RichCommandButton saveRemarks) {
    this.saveRemarks = saveRemarks;
  }

  public RichCommandButton getSaveRemarks() {
    return saveRemarks;
  }

  public String addRemarks() {
    Connection conn = null;
    if (remarksTextArea.getValue() == null) {
      GlobalCC.INFORMATIONREPORTING("No remarks set.....");
      return null;
    }
    if (remarksType.getValue() == null) {
      GlobalCC.INFORMATIONREPORTING("Remark Type Not Set");
      return null;
    }

    try {
      DBConnector MyDB = new DBConnector();
      conn = MyDB.getDatabaseConn();
      CallableStatement cst =
        conn.prepareCall("BEGIN lms_web_pkg_grp.UpdatePolRemarks(?,?,?,?,?);END;");
      cst.setBigDecimal(1, (BigDecimal)session.getAttribute("policyCode"));
      cst.setBigDecimal(2,
                        (BigDecimal)session.getAttribute("endorsementCode"));
      cst.setBigDecimal(3, (BigDecimal)session.getAttribute("prmCode"));
      cst.setString(4, (String)remarksType.getValue());
      cst.setString(5, (String)remarksTextArea.getValue());
      cst.execute();
      cst.close();
      conn.close();

      ADFUtils.findIterator("FindPolicyRemarksIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.remarksLOV);


    } catch (Exception Ex) {
      GlobalCC.EXCEPTIONREPORTING(conn, Ex);
      Ex.printStackTrace();

    }

    return null;
  }

  public String deleteRemarks() {
    // Add event code here...

    Connection conn = null;
    DCIteratorBinding dciter =
      ADFUtils.findIterator("FindPolicyRemarksIterator");
    RowKeySet set = remarksLOV.getSelectedRowKeys();
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
          conn.prepareCall("BEGIN lms_web_pkg_grp.deleteRemarks(?);END;");
        cst.setBigDecimal(1, (BigDecimal)r.getAttribute("PRM_CODE"));
        cst.execute();
        cst.close();
        conn.close();
        GlobalCC.INFORMATIONREPORTING("Remarks Deleted Successfully");
        ADFUtils.findIterator("FindPolicyRemarksIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.remarksLOV);

      }

    } catch (Exception Ex) {
      GlobalCC.EXCEPTIONREPORTING(conn, Ex);
      Ex.printStackTrace();

    }
    return null;
  }

  public void setRemarksCode(RichInputText remarksCode) {
    this.remarksCode = remarksCode;
  }

  public RichInputText getRemarksCode() {
    return remarksCode;
  }

  public void setPremLoadingsLOV(RichTable premLoadingsLOV) {
    this.premLoadingsLOV = premLoadingsLOV;
  }

  public RichTable getPremLoadingsLOV() {
    return premLoadingsLOV;
  }

  public String updateRateLoading() {
    // Add event code here...
    DCIteratorBinding dciter =
      ADFUtils.findIterator("FindPureRateLoadingsIterator");
    RowKeySet set = premLoadingsLOV.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();

    while (rowKeySetIter.hasNext()) {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();
      session.setAttribute("poctl_code", r.getAttribute("poctl_code"));
      loadNameTF.setValue(r.getAttribute("poctl_name"));
      loadRateTF.setValue(r.getAttribute("poctl_rate"));
      loadRateDivFact.setValue(r.getAttribute("poctl_rate_div_factor"));

    }

    GlobalCC.showPopup("lmsgroup:polPremLoadings");

    return null;
  }

  public String savePremLoadings() {
    // Add event code here...
    BigDecimal poctlCode = (BigDecimal)session.getAttribute("poctl_code");
    Connection conn = null;

    try {
      DBConnector MyDB = new DBConnector();
      conn = MyDB.getDatabaseConn();
      CallableStatement cst =
        conn.prepareCall("BEGIN lms_web_pkg_grp.updatePremRateLoadings(?,?,?);END;");
      cst.setBigDecimal(1, poctlCode);
      cst.setString(2, (String)loadRateTF.getValue());
      cst.setString(3, (String)loadRateDivFact.getValue());
      cst.execute();
      cst.close();
      conn.close();

      ADFUtils.findIterator("FindPureRateLoadingsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.premLoadingsLOV);

    } catch (Exception Ex) {
      GlobalCC.EXCEPTIONREPORTING(conn, Ex);
      Ex.printStackTrace();

    }
    return null;
  }

  public void setLoadNameTF(RichInputText loadNameTF) {
    this.loadNameTF = loadNameTF;
  }

  public RichInputText getLoadNameTF() {
    return loadNameTF;
  }

  public void setLoadRateTF(RichInputText loadRateTF) {
    this.loadRateTF = loadRateTF;
  }

  public RichInputText getLoadRateTF() {
    return loadRateTF;
  }

  public void setLoadRateDivFact(RichInputText loadRateDivFact) {
    this.loadRateDivFact = loadRateDivFact;
  }

  public RichInputText getLoadRateDivFact() {
    return loadRateDivFact;
  }

  public String popRequiredPolDocs() {
    // Add event code here...
    Connection conn = null;

    try {
      DBConnector MyDB = new DBConnector();
      conn = MyDB.getDatabaseConn();
      CallableStatement cst =
        conn.prepareCall("BEGIN lms_web_pkg_grp.popRequiredPolDocuments(?,?);END;");
      cst.setBigDecimal(1, (BigDecimal)session.getAttribute("policyCode"));
      cst.setBigDecimal(2,
                        (BigDecimal)session.getAttribute("endorsementCode"));
      cst.execute();
      cst.close();
      conn.close();

      ADFUtils.findIterator("FindPolicyDocsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.groupPolicyDocsLOV);

    } catch (Exception Ex) {
      GlobalCC.EXCEPTIONREPORTING(conn, Ex);
      Ex.printStackTrace();

    }
    return null;
  }

  public String editPopulatedDocs() {
    // Add event code here...
    DCIteratorBinding dciter = ADFUtils.findIterator("FindPolicyDocsIterator");
    RowKeySet set = groupPolicyDocsLOV.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();

    //System.out.println(1);
    while (rowKeySetIter.hasNext()) {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();

      //LOVCC.rdCode=(BigDecimal)r.getAttribute("RD_CODE");
      documentNameDisplay.setValue(r.getAttribute("DOCUMENT_DISPLAY"));
      session.setAttribute("GPD_CODE", r.getAttribute("GPD_CODE"));
      //LOVCC.rdShtDesc=(String)r.getAttribute("RD_SHT_DESC");

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
                           "lmsgroup:ldpoldocs" + "').show(hints);");
    }
    return null;
  }

  public void setPolicyCategoriesforChange(RichTable policyCategoriesforChange) {
    this.policyCategoriesforChange = policyCategoriesforChange;
  }

  public RichTable getPolicyCategoriesforChange() {
    return policyCategoriesforChange;
  }

  public void setOccupationLOV(RichTable occupationLOV) {
    this.occupationLOV = occupationLOV;
  }

  public RichTable getOccupationLOV() {
    return occupationLOV;
  }

  public String selectOccupationClass() {
    try {
      DCIteratorBinding dciter =
        ADFUtils.findIterator("findOccupationCategoryIterator");
      RowKeySet set = occupationLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();

      //System.out.println(1);
      while (rowKeySetIter.hasNext()) {
        List l = (List)rowKeySetIter.next();
        Key key = (Key)l.get(0);
        dciter.setCurrentRowWithKey(key.toStringFormat(true));
        Row r = dciter.getCurrentRow();
        catID.setValue(r.getAttribute("gocCategory"));
        catDesc.setValue(r.getAttribute("gocCategory"));
        catPeriod.setValue(r.getAttribute("gocClass"));
        AdfFacesContext.getCurrentInstance().addPartialTarget(catID);
        AdfFacesContext.getCurrentInstance().addPartialTarget(catDesc);
        AdfFacesContext.getCurrentInstance().addPartialTarget(catPeriod);
      }
      GlobalCC.showPopup("lmsgroup:addCat");

    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
    return null;
  }

  public void selectAll(ActionEvent actionEvent) {
    // Add event code here...
    RowKeySet rks = new RowKeySetImpl();

    CollectionModel model = (CollectionModel)scheduleMembers.getValue();

    int rowcount = model.getRowCount();

    for (int i = 0; i < rowcount; i++) {
      model.setRowIndex(i);
      Object key = model.getRowKey();
      rks.add(key);
    }

    scheduleMembers.setSelectedRowKeys(rks);

  }

  public void setDmsFileToUpload(RichInputFile dmsFileToUpload) {
    this.dmsFileToUpload = dmsFileToUpload;
  }

  public RichInputFile getDmsFileToUpload() {
    return dmsFileToUpload;
  }

  public void setDmsDocTab(RichShowDetailItem dmsDocTab) {
    this.dmsDocTab = dmsDocTab;
  }

  public RichShowDetailItem getDmsDocTab() {
    return dmsDocTab;
  }

  public String newDmsDoc() {
    session.setAttribute("docType", "POLDOC");

    //populatPolicyDocs();
    ADFUtils.findIterator("FindOccupationIterator").executeQuery();
    AdfFacesContext.getCurrentInstance().addPartialTarget(lmsDocType);

    GlobalCC.showPopup("lmsgroup:dmsUpdPop");

    return null;
  }

  public String refreshDms() {
    ADFUtils.findIterator("findUWDocsIterator").executeQuery();
    AdfFacesContext.getCurrentInstance().addPartialTarget(dmsDocTab);
    AdfFacesContext.getCurrentInstance().addPartialTarget(dmsDocTable);
    return null;
  }

  public String generateDoc() {

    Object key2 = dmsDocTable.getSelectedRowData();
    JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
    if (r == null) {
      GlobalCC.errorValueNotEntered("No Record Selected");
      return null;
    }
    String filename = (String)r.getAttribute("actualName");
    String id = (String)r.getAttribute("id");
    System.out.println("Doc Id " + id + " file name " + filename);

    EcmUtil ecmUtil = new EcmUtil();
    try {
      org.apache.chemistry.opencmis.client.api.Session sessions =
        ecmUtil.Authentification();
      Document document = (Document)sessions.getObject(id);
      InputStream inputStream = document.getContentStream().getStream();
      String file = "/Reports/" + filename;
      FacesContext context = FacesContext.getCurrentInstance();
      ServletContext sc =
        (ServletContext)context.getExternalContext().getContext();
      file = sc.getRealPath(file);
      System.out.println("");
      File toPrint = new File(file);
      OutputStream out;
      out = new FileOutputStream(toPrint);
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
        session.setAttribute("toPrint", url + pdf);
        AdfFacesContext.getCurrentInstance().addPartialTarget(docViewer);
        GlobalCC.showPopup("lmsgroup:viewdoc");
        // session.setAttribute("toPrint", null);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return null;
  }

  public void setDmsDocTable(RichTable dmsDocTable) {
    this.dmsDocTable = dmsDocTable;
  }

  public RichTable getDmsDocTable() {
    return dmsDocTable;
  }

  public String upLoadDocToDms() {
    FacesContext context = FacesContext.getCurrentInstance();

    ServletContext sc =
      (ServletContext)context.getExternalContext().getContext();
    UploadedFile newFile = (UploadedFile)dmsFileToUpload.getValue();

    if (session.getAttribute("rdCode") == null) {
      GlobalCC.errorValueNotEntered("Please select the document type being uploaded");
      return null;
    } else {

      BigDecimal rdCode = (BigDecimal)session.getAttribute("rdCode");

      EcmUtil ecmUtil = new EcmUtil();
      String fileName = newFile.getFilename();
      InputStream inputStream;
      try {
        String file = "/Reports/" + fileName;

        file = sc.getRealPath(file);
        File toUpload = new File(file);
        inputStream = newFile.getInputStream();
        OutputStream out;

        out = new FileOutputStream(toUpload);
        int read = 0;
        byte[] bytes = new byte[1024];

        while ((read = inputStream.read(bytes)) != -1) {
          out.write(bytes, 0, read);
        }
        //File file = new File(name);
        String mimetype = newFile.getContentType();

        String aspect =
          "D:tqlms:tqlmsDocumentType, P:tqlms:tqordPolicyDocument";
        ;
        String clientName = (String)session.getAttribute("polClient");
        Session ecmSession = ecmUtil.Authentification();

        if (ecmSession == null) {
          GlobalCC.errorValueNotEntered("Please Check alfresco connection : Can't Connect to alfresco!!");
          return null;
        }

        String policyNo = String.valueOf(session.getAttribute("dmsPolNo"));
        String policyNo2 = String.valueOf(session.getAttribute("dmsPolNo"));
        policyNo = policyNo.replace("/", "_");
        boolean checkLms = ecmUtil.checkDir(ecmSession, "/TQLMSGRP");
        if (checkLms == false) {
          ecmUtil.createDirInRootFolder(ecmSession, "TQLMSGRP");

        }
        String filePath = "/TQLMSGRP/UW";
        boolean check = ecmUtil.checkDir(ecmSession, filePath);
        if (check == false) {
          CmisObject objectLms = ecmSession.getObjectByPath("/TQLMSGRP");
          Folder folderLms = (Folder)objectLms;
          String fpath = "UW";
          ecmUtil.createDir(ecmSession, folderLms, fpath);
        }

        filePath = filePath + "/" + policyNo;
        boolean check1 = ecmUtil.checkDir(ecmSession, filePath);
        if (check1 == false) {
          CmisObject objectPolAuth =
            ecmSession.getObjectByPath("/TQLMSGRP/UW");
          Folder folderLms = (Folder)objectPolAuth;
          String fpath = policyNo;
          ecmUtil.createDir(ecmSession, folderLms, fpath);
        }
        CmisObject object = ecmSession.getObjectByPath(filePath);
        Folder folder = (Folder)object;

        inputStream.close();
        out.flush();
        out.close();

        List<EcmProps> properties = new ArrayList<EcmProps>();
        properties.add(new EcmProps("tqlms:policynumber", policyNo2));
        properties.add(new EcmProps("tqlms:clientname", clientName));
        properties.add(new EcmProps("tqlms:prdcode", rdCode.toString()));

        try {
          EcmTrans.UploadFile(ecmSession, folder, toUpload.getName(), toUpload,
                              mimetype, aspect, properties);
        } catch (Exception e) {
          GlobalCC.hidePopup("lmsgroup:dmsUpdPop");
          AdfFacesContext.getCurrentInstance().addPartialTarget(dmsFileToUpload);
          GlobalCC.alfrescoError(e);
          return null;
        }

        dmsFileToUpload.setValue(null);
        AdfFacesContext.getCurrentInstance().addPartialTarget(dmsFileToUpload);
        ADFUtils.findIterator("findUWDocsIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(dmsDocTable);
        AdfFacesContext.getCurrentInstance().addPartialTarget(dmsDocTab);

        GlobalCC.hidePopup("lmsgroup:dmsUpdPop");
        GlobalCC.sysInformation("Record Saved Successfully!");

      } catch (NullPointerException e) {
        GlobalCC.hidePopup("lmsgroup:dmsUpdPop");
        dmsFileToUpload.setValue(null);
        AdfFacesContext.getCurrentInstance().addPartialTarget(dmsFileToUpload);
      } catch (IOException e) {
        dmsFileToUpload.setValue(null);
        AdfFacesContext.getCurrentInstance().addPartialTarget(dmsFileToUpload);
        GlobalCC.hidePopup("lmsgroup:dmsUpdPop");
        e.printStackTrace();
      } catch (Exception e) {
        dmsFileToUpload.setValue(null);
        AdfFacesContext.getCurrentInstance().addPartialTarget(dmsFileToUpload);
        GlobalCC.hidePopup("lmsgroup:dmsUpdPop");
        e.printStackTrace();
      }
    }

    return null;
  }


  public String upLoadDocToDms2() {
    FacesContext context = FacesContext.getCurrentInstance();

    ServletContext sc =
      (ServletContext)context.getExternalContext().getContext();
    UploadedFile newFile = (UploadedFile)dmsFileToUpload.getValue();

    if (session.getAttribute("rdCode") == null) {
      GlobalCC.errorValueNotEntered("Please select the document type being uploaded");
      return null;
    } else {

      BigDecimal rdCode = (BigDecimal)session.getAttribute("rdCode");

      EcmUtil ecmUtil = new EcmUtil();
      String fileName = newFile.getFilename();
      InputStream inputStream;
      try {
        String file = "/Reports/" + fileName;

        file = sc.getRealPath(file);
        File toUpload = new File(file);
        inputStream = newFile.getInputStream();
        OutputStream out;

        out = new FileOutputStream(toUpload);
        int read = 0;
        byte[] bytes = new byte[1024];

        while ((read = inputStream.read(bytes)) != -1) {
          out.write(bytes, 0, read);
        }
        //File file = new File(name);
        String mimetype = newFile.getContentType();
        String aspect = "tqlms:tqordPolicyDocument";
        String clientName = (String)session.getAttribute("polClient");
        Session ecmSession = ecmUtil.Authentification();

        if (ecmSession == null) {
          GlobalCC.errorValueNotEntered("Please Check alfresco connection : Can't Connect to alfresco!!");
          return null;
        }

        String policyNo = String.valueOf(session.getAttribute("dmsPolNo"));
        String policyNo2 = String.valueOf(session.getAttribute("dmsPolNo"));
        policyNo = policyNo.replace("/", "_");
        boolean checkLms = ecmUtil.checkDir(ecmSession, "/TQLMSGRP");
        if (checkLms == false) {
          ecmUtil.createDirInRootFolder(ecmSession, "TQLMSGRP");

        }
        String filePath = "/TQLMSGRP/UW";
        boolean check = ecmUtil.checkDir(ecmSession, filePath);
        if (check == false) {
          CmisObject objectLms = ecmSession.getObjectByPath("/TQLMSGRP");
          Folder folderLms = (Folder)objectLms;
          String fpath = "UW";
          ecmUtil.createDir(ecmSession, folderLms, fpath);
        }

        filePath = filePath + "/" + policyNo;
        boolean check1 = ecmUtil.checkDir(ecmSession, filePath);
        if (check1 == false) {
          CmisObject objectPolAuth =
            ecmSession.getObjectByPath("/TQLMSGRP/UW");
          Folder folderLms = (Folder)objectPolAuth;
          String fpath = policyNo;
          ecmUtil.createDir(ecmSession, folderLms, fpath);
        }
        CmisObject object = ecmSession.getObjectByPath(filePath);
        Folder folder = (Folder)object;
        ecmUtil.upLoadFile(ecmSession, folder, fileName, mimetype, toUpload);
        fileName = filePath + "/" + fileName;
        Document docCov =
          ecmUtil.addAnAspectToDocument(aspect, fileName, ecmSession);
        //ecmUtil.updateMetadata(docCov, aspect, "tqgib:systemcode", "LMS");
        ecmUtil.updateMetadata(docCov, aspect, "tqlms:policynumber",
                               policyNo2);
        ecmUtil.updateMetadata(docCov, aspect, "tqlms:clientname", clientName);
        ecmUtil.updateMetadata(docCov, aspect, "tqlms:prdcode",
                               rdCode.toString());
        inputStream.close();
        out.flush();
        out.close();

        dmsFileToUpload.setValue(null);
        AdfFacesContext.getCurrentInstance().addPartialTarget(dmsFileToUpload);
        ADFUtils.findIterator("findUWDocsIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(dmsDocTable);
        AdfFacesContext.getCurrentInstance().addPartialTarget(dmsDocTab);

        GlobalCC.hidePopup("lmsgroup:dmsUpdPop");
        GlobalCC.sysInformation("Record Saved Successfully!");

      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    return null;
  }


  public void setLmsDocType(RichSelectOneChoice lmsDocType) {
    this.lmsDocType = lmsDocType;
  }

  public RichSelectOneChoice getLmsDocType() {
    return lmsDocType;
  }

  public void docTypeSelectionChanged(ValueChangeEvent valueChangeEvent) {
    try {
      if (valueChangeEvent.getNewValue() != valueChangeEvent.getOldValue()) {
        //System.out.println("Value changed " + valueChangeEvent.getNewValue().toString());
        //Row row = ADFUtils.findIterator("FindOccupation1Iterator").getRowAtRangeIndex(new Integer(valueChangeEvent.getNewValue().toString()));
        //BigDecimal rdCodeVal = (BigDecimal)row.getAttribute("rdCode");
        BigDecimal rdCodeVal = new BigDecimal(0);
        System.out.print("rdCode = ");
        System.out.println(rdCodeVal);

        session.setAttribute("rdCode", rdCodeVal);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
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

        properties.put("tqlms:policynumber", session.getAttribute("dmsPolNo"));
        properties.put("tqlms:clientname", session.getAttribute("polClient"));
        alfDoc.updateProperties(properties);
      }

      //add success message
      //update table
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
        session.removeAttribute("dmsDocId");
        session.setAttribute("dmsProcess", null);
        session.setAttribute("dmsProcessType", "");
        ADFUtils.findIterator("findUWDocsIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(dmsDocTable);
        AdfFacesContext.getCurrentInstance().addPartialTarget(dmsDocTab);

        GlobalCC.sysInformation("Document Updated Successfully!");
      } catch (SQLException e) {
        e.printStackTrace();
        GlobalCC.EXCEPTIONREPORTING(conn, e);
      }
    }
    return null;
  }

  public void setDocViewer(RichInlineFrame docViewer) {
    this.docViewer = docViewer;
  }

  public RichInlineFrame getDocViewer() {
    return docViewer;
  }

  public String toMedicals() {
    GlobalCC.RedirectPage("policyMedicals.jspx");
    return null;
  }

  public void setRemarksType(RichSelectOneChoice remarksType) {
    this.remarksType = remarksType;
  }

  public RichSelectOneChoice getRemarksType() {
    return remarksType;
  }

  public String showRemarksPopup() {
    // Add event code here...
    remarksType.setValue("O");
    remarksTextArea.setValue(null);
    GlobalCC.showPopup("lmsgroup:remarks");
    return null;
  }

  public String editRemarks() {
    // Add event code here...
    DCIteratorBinding dciter =
      ADFUtils.findIterator("FindPolicyRemarksIterator");
    RowKeySet set = remarksLOV.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();

    while (rowKeySetIter.hasNext()) {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();
      session.setAttribute("prmCode", r.getAttribute("PRM_CODE"));
      remarksType.setValue(r.getAttribute("PRM_REMARK_TYPE"));
      remarksTextArea.setValue(r.getAttribute("PRM_REMARKS"));
    }
    GlobalCC.showPopup("lmsgroup:remarks");

    return null;
  }

  public void setRemarksLOV(RichTable remarksLOV) {
    this.remarksLOV = remarksLOV;
  }

  public RichTable getRemarksLOV() {
    return remarksLOV;
  }

  public void setRemovedLpt(RichSelectOneChoice removedLpt) {
    this.removedLpt = removedLpt;
  }

  public RichSelectOneChoice getRemovedLpt() {
    return removedLpt;
  }

    public void setCatSelectRate(RichSelectOneChoice catSelectRate) {
        this.catSelectRate = catSelectRate;
    }

    public RichSelectOneChoice getCatSelectRate() {
        return catSelectRate;
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
}
