package LMSG.view.QuotationProcessing;

//import com.sun.mail.imap.Rights;
import LMSG.view.BPM.ProcessDMSTicket;
import LMSG.view.BPM.workflowProcessing;

import LMSG.view.Base.ADFUtils;

import LMSG.view.Base.GlobalCC;

import LMSG.view.Base.LOVCC;

import LMSG.view.Base.Rendering;
import LMSG.view.connect.DBConnector;

import java.io.PrintStream;

import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import java.io.File;

import javax.faces.event.ValueChangeEvent;

import javax.servlet.http.HttpSession;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichDialog;
import oracle.adf.view.rich.component.rich.data.RichColumn;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.data.RichTree;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputFile;
import oracle.adf.view.rich.component.rich.input.RichInputNumberSpinbox;
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

import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.FileOutputStream;

import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.uicli.binding.JUCtrlHierNodeBinding;

import oracle.jdbc.OracleTypes;

import org.apache.myfaces.trinidad.event.DisclosureEvent;
import org.apache.myfaces.trinidad.event.SelectionEvent;
import org.apache.myfaces.trinidad.model.RowKeySet;
import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

import LMSG.view.Correspondents.CorrespondenceManipulation;

import LMSG.view.ecm.EcmProps;
import LMSG.view.ecm.EcmTrans;
import LMSG.view.ecm.EcmUtil;

import java.io.FileNotFoundException;

import java.sql.PreparedStatement;

import java.text.SimpleDateFormat;

import java.util.Date;

import java.util.Map;

import javax.servlet.ServletContext;

import javax.servlet.http.HttpServletRequest;

import oracle.jbo.uicli.binding.JUCtrlValueBinding;

import oracle.jdbc.OracleConnection;

import org.apache.chemistry.opencmis.client.api.CmisObject;
import org.apache.myfaces.trinidad.model.UploadedFile;

import org.alfresco.cmis.client.AlfrescoDocument;

import org.apache.chemistry.opencmis.client.api.Document;
import org.apache.chemistry.opencmis.client.api.Folder;
import org.apache.chemistry.opencmis.client.api.FolderType;
import org.apache.chemistry.opencmis.client.api.Session;
import org.apache.chemistry.opencmis.client.api.ObjectId;
import org.apache.chemistry.opencmis.commons.exceptions.CmisConnectionException;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.ArrayList;

import org.apache.chemistry.opencmis.commons.exceptions.CmisContentAlreadyExistsException;
import org.apache.chemistry.opencmis.commons.exceptions.CmisObjectNotFoundException;


public class viewQuotations extends LOVCC {
  private RichInputText compFCL;
  private RichInputText coverSADisplay;
  private RichInputText coverButChargePremium;
  private RichSelectOneChoice discLoadChoice;
  private RichInputText discLoadRateDisplay;
  private RichTable prodCoversLOV;
  private RichTable coverTypesLOV;
  private RichOutputText coverLabel;
  private RichInputText edcoverButChargePremium;
  private RichSelectOneChoice eddiscLoadChoice;
  private RichInputText eddiscLoadRateDisplay;
  private RichOutputText edCoverlabel;
  private RichTable allTaxesLOV;
  private RichOutputText taxSel;
  private RichSelectOneChoice applLevel;
  private RichInputText taxRate;
  private RichInputText taxAmt;
  private RichTable quotationTaxes;
  private RichInputText categIDDisplay;
  private RichInputText categDescDisplay;
  private RichInputText categPeriodDisplay;
  private RichTable categoryLOV;

  protected static int Edit;
  private RichTable productProvisionsLOV;
  private RichSelectBooleanCheckbox provisionsCbox;
  private RichTable coverTypeProvisions;
  private RichTable dependentTypesLOV;
  private RichTable dependentCoverTypes;
  private RichInputText dependentCategory;
  private RichInputText dependentType;
  private RichInputText dpdLimitAmount;
  private RichInputText maxType;
  private RichInputText dpdMonthlyIncome;
  private RichTable quotationDependentsLOV;
  private RichOutputText coverDescLabel;
  private RichOutputText depTypesLabel;
  private RichInputText edLimitAmt;
  private RichInputText edMaxNo;
  private RichTable quotMembersLOV;
  private RichOutputText oldANBDisp;
  private RichInputText newANBDisplay;
  private RichInputText sumAssuredDisplay;
  private RichTable agentsLOV;
  private RichInputText conProductDisplay;
  private RichTable covProvLOV;
  private RichSelectOneChoice calcType;
  private RichSelectOneChoice freqPay;
  private RichSelectOneChoice fclType;
  private RichOutputText edtaxSel;
  private RichSelectOneChoice edapplLevel;
  private RichInputText edtaxRate;
  private RichInputText edtaxAmt;
  private RichInputText avANB;
  private RichInputText quotePrem;
  private RichInputText noofMembers;
  private RichInputDate coverToDate;
  private RichTable allAgentsLOV;
  private RichTable usersLOV;
  private RichInputText ticketRemarks;
  private RichTable exceptionsLOV;
  private RichInputText ovrFCLAmt;
  private RichTable quotPremMaskLOV;
  private RichInputText maskDisplay;
  private RichSelectOneChoice quotationDurationType;
  private RichInputDate wetDate;
  private RichSelectOneChoice agentsAuth;
  private RichSelectOneChoice agentAssignTo;
  private RichOutputText agentsDispl;
  private RichSelectOneChoice edAssignTo;
  private RichSelectOneChoice edAuthorised;
  private RichOutputText addAgentsDispl;
  private RichInputText dtyDesc;
  private RichInputText avMemberEarnings;
  private RichOutputLabel depTypeLabel;
  private RichOutputLabel avMemEarnlabel;
  private HtmlPanelGrid depTypeDtls;
  private RichTable allDepsLOV;
  private RichOutputLabel saLabel;
  private RichOutputLabel avANBLabel;
  private RichInputText maleRtAge;
  private RichInputText femaleRtAge;
  private RichInputText cvrCategory;
  private RichOutputLabel cvrCategorylabel;
  private RichInputText cvrMultipleEarningsPeriod;
  private RichOutputLabel multiEarnsPeriodlbl;
  private RichInputText totalMem;
  private RichOutputLabel totalMemLabel;
  private RichTable depLimitCategoryLOV;
  private RichSelectOneChoice unitRateOption;
  private RichInputDate effectiveDate;
  private RichSelectOneChoice fclCalcType;
  private RichInputText computedFCL;
  private RichInputText overrideFCL;
  private RichInputText divFactor;
  private RichInputText unitRateDisplay;
  private RichSelectOneChoice unitRateDivFactor;
  private RichSelectOneChoice paymentMethod;
  private RichOutputLabel mainCoverLabel;
  private RichSelectOneChoice mainCover;
  private RichOutputLabel percMainCvtLabel;
  private RichInputText percMainCvt;
  private RichOutputLabel loanAmtLabel;
  private RichInputText cvrLoanAmt;
  private RichOutputLabel loanRepyLabel;
  private RichInputText cvrLoanPrd;
  private RichOutputLabel loanIntLabel;
  private RichInputText cvrLoanInt;
  private RichOutputLabel savingsAmtLabel;
  private RichInputText cvrSavingsAmt;
  private RichInputText categoryFees;
  private RichInputText categoryStudents;
  private RichTable classesLOV;
  private RichInputText discDivFactor;
  private RichInputText discRateDisplay;
  private RichSelectOneChoice discChoice;
  private RichTree categoryTree;
  private RichSelectOneChoice rateSelection;
  private RichInputText maskDesc;
  private RichCommandButton maskButton;
  private RichInputNumberSpinbox coverRate;
  private RichInputNumberSpinbox coverRateDivFactor;
  private RichInputText catMaskDesc;
  private RichTable maskTable;
  private RichTable catMaskTable;
  private RichSelectOneChoice categoryDrop;
  private RichSelectOneRadio categoryRadio;
  private RichInputDate txtWefDate;
  private RichInputDate txtWetDate;
  private RichTable claimExpLOV;
  private RichInputText dpdMinAmount;
  private RichOutputLabel prdTypeLabel2;
  private RichInputText totalMemEarning;
  private RichOutputLabel totalMemEarninglbl;
  private RichOutputLabel avCoverPerMemLabel;
  private RichInputText avCoverPerMem;
  private RichInputText totLoanAmt;
  private RichOutputLabel totLoanAmtLabel;
  private HtmlPanelGrid multiprdPanel;
  private RichOutputLabel edtAgnShareLab;
  private RichInputText edtAgnShareTF;
  private RichOutputLabel addAgnShareLab;
  private RichInputText addAgnShareTF;
  private RichOutputLabel totMemEarningLab;
  private RichInputText totMemEarnings;
  private RichCommandButton attachAgentsDtls;
  private RichSelectOneChoice getLeader_follower;
  private RichOutputLabel leader_followerLab;
  private RichOutputLabel edtleader_followerLab;
  private RichSelectOneChoice editLeader_followerCmb;
  private RichColumn agnShareCol;
  private RichColumn agnLdrFolCol;
  HttpSession session =
    (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
  private RichOutputLabel ageLoadFactorLab;
  private RichInputText ageLoadFactor;
  private RichOutputLabel discLoadRateDisplayLab;
  private RichOutputLabel divFactorLab;
  private RichPanelBox coversPanel;
  private RichTable premLoadingsLOV;
  private RichInputText loadNameTF;
  private RichInputText loadRateTF;
  private RichInputText loadRateDivFact;
  private RichColumn groupSingleRate;
  private RichSelectOneChoice grpSingleRateComboo;
  private RichTable catClassLOV;
  private RichSelectOneChoice discountCvrTypeSel;
  private RichSelectOneChoice discountTypesSel;
  private RichInputText discountRate;
  private RichInputText discountReasons;
  private RichSelectOneChoice discountApplyLevel;
  private RichSelectOneChoice remarksType;
  private RichInputText remarks;
  private RichTable quotationRemarksLOV;
  private HtmlPanelGrid aggCategoryPanel;
  private RichTable aggregateCatLOV;
  private RichOutputText provID;
  private RichInputText provDesc;
  private RichOutputLabel avgLabAggregate;
  private RichInputText limInput;
  private RichInputText srchMemNo;
  private RichInputText srchMemName;
  private RichSelectOneChoice earnPrd;
  private RichInputText totPremPaid;
  private RichInputText totClaimPaid;
  private RichInputText clmExpRate;
  private RichInputText tenderPeriodTF;
  private RichInputText memberNo;
  private RichInputText memSurname;
  private RichInputText memOtherNames;
  private RichSelectOneChoice memSex;
  private RichInputDate memDob;
  private RichInputText assigneeName;
  private RichInputText sbuOneDisplay;

  private RichInputText assigneePhyAddr;
  private RichOutputLabel aggQuotePlanLbl;
  private RichInputText aggQuotePlan;
  private RichShowDetailItem dmsDocTab;
  private RichInputFile dmsFileToUpload;
  private RichSelectOneChoice lmsDocType;
  private RichTable dmsDocTable;
  private RichInlineFrame docViewer;
  private RichTable fcclPlanTab;
  private RichInputText locOneDisplay;
  private RichSelectOneChoice overPlan;
  private HtmlPanelGrid fclOkCancel;
  private HtmlPanelGrid perPlanOkCancel;
  private RichSelectOneChoice builtIn;
  private RichSelectOneChoice accelerator;
  private RichTable locOneLOV;
  private RichTable SBUOneLOV;
    private RichInputText tcktAsignee;
    private RichTable ticketsUserLOV;

    public String ShowCovers() {
    try {
      GlobalCC.RedirectPage("/quocovers.jspx");
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
    return null;
  }

  public String AssignPremMask() {
    DCIteratorBinding dciter =
      ADFUtils.findIterator("findPremiumMask1Iterator");
    RowKeySet set = this.quotPremMaskLOV.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();
    //System.out.println(1);
    while (rowKeySetIter.hasNext()) {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();
      this.maskDisplay.setValue(r.getAttribute("PMAS_SHT_DESC"));
      this.catMaskDesc.setValue(r.getAttribute("PMAS_SHT_DESC"));
      //LOVCC.pmasCode=(BigDecimal)r.getAttribute("PMAS_CODE");
      this.session.setAttribute("pmasCode", r.getAttribute("PMAS_CODE"));
    }
    AdfFacesContext.getCurrentInstance().addPartialTarget(maskDisplay);
    AdfFacesContext.getCurrentInstance().addPartialTarget(catMaskDesc);
    GlobalCC.hidePopup("lmsgroup:maskPopup");

    return null;
  }

  public String GetAssignee() {
    try {
      // Render Popup
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
        //clientsDisplay.setValue(r.getAttribute("CLIENT"));

        //LOVCC.TaskAssigneeID=(BigDecimal)r.getAttribute("taskUserID");
        //LOVCC.TaskAssignee = (String)r.getAttribute("taskUserShtDesc");

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

  public String UpdateMembersToCover() {
    Connection conn = null;
    String PopulateQuery =
      "BEGIN LMS_WEB_PKG_GRP.update_quo_members_to_cover(?);END;";
    try {
      conn = new DBConnector().getDatabaseConn();
      CallableStatement cstmt = null;
      cstmt = conn.prepareCall(PopulateQuery);
      cstmt.setBigDecimal(1,
                          (BigDecimal)this.session.getAttribute("QuoteCode"));
      cstmt.execute();
      cstmt.close();
      conn.close();

      GlobalCC.sysInformation("Members Successfully Updated.");
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
  }

  public String computeQuotationPrem() {
    String computeQuery = null;
    Connection conn = null;
    try {
      conn = new DBConnector().getDatabaseConn();

      if (this.calcType.getValue().toString().equalsIgnoreCase("A"))
        computeQuery = "BEGIN LMS_WEB_PKG_GRP.compute_agg_quot_prem(?);END;";
      else {
        computeQuery = "BEGIN LMS_WEB_PKG_GRP.compute_qout_premium(?);END;";
      }

      CallableStatement cstmt = null;

      cstmt = conn.prepareCall(computeQuery);
      cstmt.setBigDecimal(1,
                          (BigDecimal)this.session.getAttribute("QuoteCode")); //v_quo_code NUMBER,
      cstmt.execute();
      conn.close();
      this.session.setAttribute("qcvtCode", null); //LOVCC.qcvtCode = null;
      ADFUtils.findIterator("findQuoteCoverTypesIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.coverTypesLOV);

      ADFUtils.findIterator("findQuotation1Iterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.sumAssuredDisplay);

      ADFUtils.findIterator("findQuotationTaxesIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.quotationTaxes);

      AdfFacesContext.getCurrentInstance().addPartialTarget(this.quotePrem);
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.noofMembers);
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.coverToDate);

      String Message = "Premium Successfully Computed";
      FacesContext.getCurrentInstance().addMessage(null,
                                                   new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                    Message,
                                                                    Message));
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
  }

  public String computeQuotationPremII() {
    String computeQuery = null;
    Connection conn = null;
    try {
      conn = new DBConnector().getDatabaseConn();

      computeQuery = "BEGIN LMS_WEB_PKG_GRP.compute_qout_premium(?);END;";

      CallableStatement cstmt = null;

      cstmt = conn.prepareCall(computeQuery);
      cstmt.setBigDecimal(1,
                          (BigDecimal)this.session.getAttribute("QuoteCode"));
      cstmt.execute();

      ADFUtils.findIterator("findMemberPensionDtlsIterator").executeQuery();
      conn.close();

      GlobalCC.sysInformation("Premium Successfully Computed");
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
  }

  public String AuthoriseException() {
    Connection conn = null;

    BigDecimal Except = null;

    DCIteratorBinding dciter =
      ADFUtils.findIterator("findQuoteExceptionsIterator");
    RowKeySet set = this.exceptionsLOV.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();

    while (rowKeySetIter.hasNext()) {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();

      Except = (BigDecimal)r.getAttribute("QEXC_CODE");
    }

    String coverDeleteQuery =
      "BEGIN LMS_GRP_WEB_EXCEPTIONS.authorize_exception(?,?,?,?);END;";
    conn = new DBConnector().getDatabaseConn();
    CallableStatement cstmt = null;
    try {
      cstmt = conn.prepareCall(coverDeleteQuery);
      cstmt.setString(1, (String)this.session.getAttribute("Username"));
      cstmt.setBigDecimal(2, Except);
      cstmt.setInt(3, 27);
      cstmt.setBigDecimal(4,
                          (BigDecimal)this.session.getAttribute("QuoteCode"));
      cstmt.execute();
      conn.close();
      ADFUtils.findIterator("findQuoteExceptionsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.exceptionsLOV);
    } catch (Exception ex) {
      GlobalCC.EXCEPTIONREPORTING(conn, ex);
    }
    return null;
  }

  public String DetermineFCL() {
    Connection conn = null;
    try {
      if (this.calcType.getValue().toString().equalsIgnoreCase("A")) {
        ExtendedRenderKitService erkService =
          (ExtendedRenderKitService)Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                                       ExtendedRenderKitService.class);

        erkService.addScript(FacesContext.getCurrentInstance(),
                             "var hints = {autodismissNever:false}; AdfPage.PAGE.findComponent('lmsgroup:detFCL').show(hints);");

        return null;
      }

      String fclQuery = "BEGIN LMS_WEB_PKG_GRP.determine_fcl(?,?,?);END;";
      conn = new DBConnector().getDatabaseConn();
      CallableStatement cstDetFCL = null;

      cstDetFCL = conn.prepareCall(fclQuery);
      if (this.fclType.getValue() == null)
        cstDetFCL.setString(1, null);
      else {
        cstDetFCL.setString(1, this.fclType.getValue().toString());
      }
      cstDetFCL.setBigDecimal(2,
                              (BigDecimal)this.session.getAttribute("QuoteCode"));
      cstDetFCL.setBigDecimal(3,
                              (BigDecimal)this.session.getAttribute("ProductCode"));
      cstDetFCL.execute();
      conn.close();
      ADFUtils.findIterator("findQuotation1Iterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.compFCL);

      String Message = "FCL Successfully Computed";
      FacesContext.getCurrentInstance().addMessage(null,
                                                   new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                    Message,
                                                                    Message));
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
  }

  public String UpdateQuotationDetails() {
    try {
      String Type = null;
      if (this.calcType.getValue() != null) {
        Type = this.calcType.getValue().toString();
      }

      String todayString = null;
      if (this.effectiveDate.getValue().toString().contains(":"))
        todayString =
            GlobalCC.parseDate(this.effectiveDate.getValue().toString());
      else {
        todayString =
            GlobalCC.upDateParseDate(this.effectiveDate.getValue().toString());
        session.setAttribute("dmsQuoDate", todayString);
      }
      String fclQuery =
        "BEGIN LMS_WEB_PKG_GRP.update_calc_types(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);END;";
      Connection conn = new DBConnector().getDatabaseConn();
      CallableStatement cstDetFCL = null;

      cstDetFCL = conn.prepareCall(fclQuery);
      cstDetFCL.setString(1, "Q");
      cstDetFCL.setString(2, Type);
      if (this.freqPay.getValue() == null)
        cstDetFCL.setString(3, null);
      else {
        cstDetFCL.setString(3, this.freqPay.getValue().toString());
      }
      if (this.fclType.getValue() == null)
        cstDetFCL.setString(4, null);
      else {
        cstDetFCL.setString(4, this.fclType.getValue().toString());
      }
      cstDetFCL.setBigDecimal(5,
                              (BigDecimal)this.session.getAttribute("QuoteCode"));
      if (this.ovrFCLAmt.getValue() == null)
        cstDetFCL.setString(6, null);
      else {
        cstDetFCL.setString(6, this.ovrFCLAmt.getValue().toString());
      }
      cstDetFCL.setBigDecimal(7,
                              (BigDecimal)this.session.getAttribute("pmasCode"));
      if (this.maskDisplay.getValue() == null)
        cstDetFCL.setString(8, null);
      else {
        cstDetFCL.setString(8, this.maskDisplay.getValue().toString());
      }
      if (this.maleRtAge.getValue() == null)
        cstDetFCL.setString(9, null);
      else {
        cstDetFCL.setString(9, this.maleRtAge.getValue().toString());
      }
      if (this.femaleRtAge.getValue() == null)
        cstDetFCL.setString(10, null);
      else {
        cstDetFCL.setString(10, this.femaleRtAge.getValue().toString());
      }
      cstDetFCL.setString(11, null);
      cstDetFCL.setString(12, null);
      cstDetFCL.setString(13, null);
      if (this.unitRateOption.getValue() == null)
        cstDetFCL.setString(14, null);
      else {
        cstDetFCL.setString(14, this.unitRateOption.getValue().toString());
      }
      if (this.effectiveDate.getValue() == null)
        cstDetFCL.setString(15, null);
      else {
        cstDetFCL.setString(15, todayString);
      }
      cstDetFCL.setString(16, null);
      cstDetFCL.setString(17, null);
      cstDetFCL.setString(18, null);
      if (this.paymentMethod.getValue() == null)
        cstDetFCL.setString(19, null);
      else {
        cstDetFCL.setString(19, this.paymentMethod.getValue().toString());
      }
      cstDetFCL.setString(20, null);
      cstDetFCL.setString(21, null);
      cstDetFCL.setString(22, null);
      cstDetFCL.setString(23, null);
      cstDetFCL.setString(24, null);
      if (grpSingleRateComboo.getValue() == null) {
        cstDetFCL.setString(25, null);
      } else {
        cstDetFCL.setString(25, (String)grpSingleRateComboo.getValue());
      }
      if (earnPrd.getValue() == null) {
        cstDetFCL.setString(26, null);
      } else {
        cstDetFCL.setString(26, earnPrd.getValue().toString());
      }

      if (totPremPaid.getValue() == null) {
        cstDetFCL.setString(27, null);
      } else {
        cstDetFCL.setString(27, totPremPaid.getValue().toString());
      }
      if (totClaimPaid.getValue() == null) {
        cstDetFCL.setString(28, null);
      } else {
        cstDetFCL.setString(28, totClaimPaid.getValue().toString());
      }

      //clmExpRate
      if (clmExpRate.getValue() == null) {
        cstDetFCL.setString(29, null);
      } else {
        cstDetFCL.setString(29, clmExpRate.getValue().toString());
      }
      //TENDER PERIOD
      if (tenderPeriodTF.getValue() == null) {
        cstDetFCL.setString(30, null);
      } else {
        cstDetFCL.setString(30, tenderPeriodTF.getValue().toString());
      }
      if (assigneeName.getValue() == null) {
        cstDetFCL.setString(31, null);
      } else {
        cstDetFCL.setString(31, assigneeName.getValue().toString());
      }
      if (assigneePhyAddr.getValue() == null) {
        cstDetFCL.setString(32, null);
      } else {
        cstDetFCL.setString(32, assigneePhyAddr.getValue().toString());
      }
      cstDetFCL.setBigDecimal(33,null);
      cstDetFCL.setBigDecimal(34, (BigDecimal)this.session.getAttribute("sbuCode"));
      cstDetFCL.setBigDecimal(35, (BigDecimal)this.session.getAttribute("spokeCode"));
      cstDetFCL.setBigDecimal(36, (BigDecimal)this.session.getAttribute("coverageAreaCode"));
      cstDetFCL.setBigDecimal(37, (BigDecimal)this.session.getAttribute("locationCode")); 


      cstDetFCL.execute();
      conn.close();
      this.session.setAttribute("QuotCalcType", Type);
      session.setAttribute("qcvtCode", null);
      ADFUtils.findIterator("findQuotation1Iterator").executeQuery();
      //AdfFacesContext.getCurrentInstance().addPartialTarget(compFCL);
      ADFUtils.findIterator("findQuoteCoverTypesIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.coverTypesLOV);
      ADFUtils.findIterator("findQuoteMembersIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.quotMembersLOV);

      String Message = "Quotation Successfully Updated";
      FacesContext.getCurrentInstance().addMessage(null,
                                                   new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                    Message,
                                                                    Message));
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(null, e);
      e.printStackTrace();
    }
    return null;
  }

  public void setCompFCL(RichInputText compFCL) {
    this.compFCL = compFCL;
  }

  public RichInputText getCompFCL() {
    return this.compFCL;
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

  public void setDiscLoadChoice(RichSelectOneChoice discLoadChoice) {
    this.discLoadChoice = discLoadChoice;
  }

  public RichSelectOneChoice getDiscLoadChoice() {
    return this.discLoadChoice;
  }

  public void setDiscLoadRateDisplay(RichInputText discLoadRateDisplay) {
    this.discLoadRateDisplay = discLoadRateDisplay;
  }

  public RichInputText getDiscLoadRateDisplay() {
    return this.discLoadRateDisplay;
  }

  public void setProdCoversLOV(RichTable prodCoversLOV) {
    this.prodCoversLOV = prodCoversLOV;
  }

  public RichTable getProdCoversLOV() {
    return this.prodCoversLOV;
  }

  public void coversListener(SelectionEvent selectionEvent) {
    // Add event code here...
    DCIteratorBinding dciter =
      ADFUtils.findIterator("findProductCovers1Iterator");
    RowKeySet set = selectionEvent.getAddedSet();
    Iterator rowKeySetIter = set.iterator();

    //System.out.println(1);
    while (rowKeySetIter.hasNext()) {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();

      //LOVCC.CVT_CODE=(BigDecimal)r.getAttribute("cvt_code");
      session.setAttribute("CVT_CODE", r.getAttribute("cvt_code"));
      coverLabel.setValue(r.getAttribute("cvt_desc"));
      coverButChargePremium.setValue(null);
      discLoadChoice.setValue(null);
      discLoadRateDisplay.setValue(null);

      AdfFacesContext.getCurrentInstance().addPartialTarget(coverButChargePremium);
      AdfFacesContext.getCurrentInstance().addPartialTarget(discLoadChoice);
      AdfFacesContext.getCurrentInstance().addPartialTarget(discLoadRateDisplay);
      //prodCoverDisplay.setValue(new String((String)r.getAttribute("cvt_desc")));
      //categPeriodDisplay.setValue(new String((String)r.getAttribute("catPeriod")));
    }

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
      stmt.registerOutParameter(1, OracleTypes.VARCHAR);
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

  public BigDecimal getMaxSa(BigDecimal pctCodeInput) {
    String maxsastr = "begin ? := LMS_WEB_CURSOR_GRP.getMaxSa(?); end;";
    BigDecimal pctcode;
    pctcode = pctCodeInput;
    BigDecimal maxSa;
    maxSa = new BigDecimal(0);

    try {
      DBConnector myConn = new DBConnector();
      Connection conn = myConn.getDatabaseConn();
      CallableStatement cstmt = null;
      cstmt = conn.prepareCall(maxsastr);
      cstmt.registerOutParameter(1, OracleTypes.NUMBER);
      cstmt.setBigDecimal(2, pctcode);
      cstmt.execute();
      maxSa = cstmt.getBigDecimal(1);
      conn.close();
    } catch (Exception e) {
      e.printStackTrace();
    }


    return maxSa;
  }

  public String findCoversSel() {
    Rendering render = new Rendering();
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
        //LOVCC.CVT_CODE=(BigDecimal)r.getAttribute("cvt_code");
        this.session.setAttribute("CVT_CODE", r.getAttribute("cvt_code"));
        //LOVCC.qcvtCode = null;

        this.session.setAttribute("qcvtCode", null);
        this.coverLabel.setValue(r.getAttribute("cvt_desc"));
        this.coverButChargePremium.setValue(null);
        this.discLoadChoice.setValue("N");
        this.discLoadRateDisplay.setValue(null);
        this.divFactor.setValue(null);
        this.avANB.setValue(null);
        this.avMemberEarnings.setValue(null);
        this.dtyDesc.setValue(null);
        this.cvrMultipleEarningsPeriod.setValue(null);
        this.totalMem.setValue(null);
        this.cvrCategory.setValue(null);
        this.discChoice.setValue("N");
        this.discRateDisplay.setValue(null);
        this.discDivFactor.setValue(null);
        this.coverSADisplay.setValue(null);
        this.totalMemEarning.setValue(null);
        this.mainCover.setValue(r.getAttribute("cvt_main_cover"));
        this.percMainCvt.setValue(r.getAttribute("pct_main_sa_perc"));
        session.setAttribute("covShtDesc", r.getAttribute("cvt_sht_desc"));

        //reset all MICK rendered controls on edit cover screen
        if (render.isMickVisible()) {
          this.totLoanAmtLabel.setValue("Total Original Loan Amount");
          this.totLoanAmt.setDisabled(false);
          this.loanRepyLabel.setValue("Loan Repayment Period(Months)");
          this.cvrLoanPrd.setDisabled(false);
          this.loanIntLabel.setValue("Loan Interest");
          this.cvrLoanInt.setDisabled(false);


          this.totalMemEarninglbl.setValue("Total Member Earnings");
          this.totalMemEarning.setDisabled(false);
          this.multiEarnsPeriodlbl.setValue("Multiple Earnings Period");
          this.cvrMultipleEarningsPeriod.setDisabled(false);
          this.cvrMultipleEarningsPeriod.setValue("");
          this.prdTypeLabel2.setValue("[Years]");
          BigDecimal pctCodeVal = (BigDecimal)r.getAttribute("pct_code");
          this.limInput.setValue(getMaxSa(pctCodeVal));

        }

        String CmainCover = (String)r.getAttribute("cvt_main_cover");
        session.setAttribute("pcovType",
                             (String)r.getAttribute("cvt_main_cover"));
        if (CmainCover.equalsIgnoreCase("RL"))
          this.percMainCvtLabel.setValue("Multiple of Loan Repayment");
        else {
          this.percMainCvtLabel.setValue("% of  Main/Yr Earn");
        }

        this.session.setAttribute("coverMaskCode",
                                  (BigDecimal)this.session.getAttribute("pmasCode"));
        this.maskDesc.setValue((String)this.session.getAttribute("pmasShtDesc"));

        this.maskButton.setDisabled(true);
        this.coverRate.setDisabled(true);
        this.coverRate.setValue(null);
        this.coverRateDivFactor.setDisabled(true);
        this.coverRateDivFactor.setValue(null);

        String ProductType = (String)this.session.getAttribute("productType");
        if (this.calcType.getValue().toString().equalsIgnoreCase("A")) {

          this.avANBLabel.setRendered(true);
          this.avANB.setRendered(true);
          this.saLabel.setRendered(true);
          this.coverSADisplay.setRendered(true);
          this.depTypeLabel.setRendered(true);
          this.depTypeDtls.setRendered(true);
          this.totalMem.setRendered(true);
          this.totalMemLabel.setRendered(true);
          this.avgLabAggregate.setRendered(true);
          this.avANBLabel.setRendered(false);
          this.aggQuotePlanLbl.setRendered(true);
          this.aggQuotePlan.setRendered(true);
          this.aggQuotePlan.setValue((String)session.getAttribute("DefaultAggrPlan"));

          if (ProductType.equalsIgnoreCase("EARN")) {
            this.avMemberEarnings.setRendered(true);
            this.avMemEarnlabel.setRendered(true);
            this.cvrMultipleEarningsPeriod.setRendered(true);
            this.multiEarnsPeriodlbl.setRendered(true);
            this.totalMemEarninglbl.setRendered(true);
            this.totalMemEarning.setRendered(true);
            this.cvrCategory.setRendered(true);
            this.cvrCategorylabel.setRendered(true);
            String Value = Validate_Quote_Product();
            if ((Value == null)) {
              this.prdTypeLabel2.setValue("[Months]");
            } else if (Value.equalsIgnoreCase("F")) {
              this.prdTypeLabel2.setValue("[Months]");
            } else {
              this.prdTypeLabel2.setValue(Value);
            }
            this.prdTypeLabel2.setRendered(true);

            this.totLoanAmtLabel.setRendered(false);
            this.totLoanAmt.setRendered(false);
            this.cvrCategory.setRendered(true);
            this.cvrCategorylabel.setRendered(true);
            this.totalMemEarninglbl.setRendered(true);
            this.totalMemEarning.setRendered(true);
            this.avCoverPerMemLabel.setRendered(false);
            this.avCoverPerMem.setRendered(false);
            this.multiprdPanel.setRendered(true);
            this.aggCategoryPanel.setRendered(true);
            /* if(!CmainCover.equals("M")){
              this.avMemberEarnings.setRendered(false);
              this.avMemEarnlabel.setRendered(false);
              this.totalMem.setRendered(false);
              this.totalMemLabel.setRendered(false);
              this.totalMemEarninglbl.setRendered(false);
              this.totalMemEarning.setRendered(false);
             // this.multiprdPanel.setRendered(false);
            }*/


            //Render MICK controls for EARNINGS PRODUCTS
            if (render.isMickVisible()) {
              String cover = session.getAttribute("pcovType").toString();
              String covsht = session.getAttribute("covShtDesc").toString();

              if (cover.equalsIgnoreCase("R") ||
                  covsht.equalsIgnoreCase("FCG")) {
                this.totalMemEarninglbl.setValue("");
                this.totalMemEarning.setDisabled(true);
                this.multiEarnsPeriodlbl.setValue("");
                this.cvrMultipleEarningsPeriod.setDisabled(true);
                this.cvrMultipleEarningsPeriod.setValue("1");
                this.prdTypeLabel2.setValue("");
                avMemEarnlabel.setValue("average cover per member");
                //coversPanel
              } else {
                avMemEarnlabel.setValue("average Earnings per member");
              }
            }

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
            this.avCoverPerMemLabel.setRendered(false);
            this.avCoverPerMem.setRendered(false);
            this.multiprdPanel.setRendered(false);
            this.aggCategoryPanel.setRendered(false);

            //Render MICK controls for LOANS PRODUCTS
            if (render.isMickVisible()) {
              //check if the cover type is funeral
              String covsht = session.getAttribute("covShtDesc").toString();
              String cover = session.getAttribute("pcovType").toString();
              if (cover.equalsIgnoreCase("R") ||
                  covsht.equalsIgnoreCase("FCG")) {
                this.totLoanAmtLabel.setValue("");
                this.totLoanAmt.setDisabled(true);
                this.loanRepyLabel.setValue("");
                this.cvrLoanPrd.setDisabled(true);
                this.loanIntLabel.setValue("");
                this.cvrLoanInt.setDisabled(true);
                this.cvrLoanInt.setValue("1");
                this.loanAmtLabel.setValue("Av. Cover Per Member");
                //coversPanel
              } else {
                loanAmtLabel.setValue("Original Loan Amount Per member\n");
              }
              this.aggCategoryPanel.setRendered(true);
              this.cvrCategorylabel.setRendered(true);
              // this.cvrCategory.setValue("DEFAULT");

              this.cvrCategory.setRendered(true);
            }


          } else if (ProductType.equalsIgnoreCase("FUNE")) {
            this.totLoanAmtLabel.setRendered(false);
            this.totLoanAmt.setRendered(false);
            this.avCoverPerMemLabel.setRendered(true);
            this.avCoverPerMem.setRendered(true);
            this.cvrCategory.setRendered(true);
            this.cvrCategorylabel.setRendered(true);
            this.multiprdPanel.setRendered(false);
            this.aggCategoryPanel.setRendered(true);
          }
        } else {
          this.totLoanAmtLabel.setRendered(false);
          this.totLoanAmt.setRendered(false);
          this.avANBLabel.setRendered(true);
          this.avANB.setRendered(true);
          this.saLabel.setRendered(false);
          this.coverSADisplay.setRendered(false);
          this.depTypeLabel.setRendered(false);
          this.depTypeDtls.setRendered(false);
          this.avMemberEarnings.setRendered(false);
          this.avMemEarnlabel.setRendered(false);
          this.cvrMultipleEarningsPeriod.setRendered(false);
          this.prdTypeLabel2.setRendered(false);
          this.totalMemEarninglbl.setRendered(false);
          this.totalMemEarning.setRendered(false);
          this.totalMem.setRendered(false);
          this.cvrCategory.setRendered(false);
          this.totalMemLabel.setRendered(false);
          this.multiEarnsPeriodlbl.setRendered(false);
          this.cvrCategorylabel.setRendered(false);
          this.loanAmtLabel.setRendered(false);
          this.cvrLoanAmt.setRendered(false);
          this.loanRepyLabel.setRendered(false);
          this.cvrLoanPrd.setRendered(false);
          this.loanIntLabel.setRendered(false);
          this.cvrLoanInt.setRendered(false);
          this.savingsAmtLabel.setRendered(false);
          this.cvrSavingsAmt.setRendered(false);
          this.multiprdPanel.setRendered(false);
          this.aggCategoryPanel.setRendered(false);
          this.avgLabAggregate.setRendered(false);
          this.avANBLabel.setRendered(true);
          this.aggQuotePlanLbl.setRendered(false);
          this.aggQuotePlan.setRendered(false);
          this.aggQuotePlan.setValue(null);
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
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.avgLabAggregate);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.aggQuotePlan);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.aggQuotePlanLbl);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.builtIn);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.accelerator);

        if (render.isMickVisible()) {
          AdfFacesContext.getCurrentInstance().addPartialTarget(this.coversPanel);
        }
        // Render Popup
        GlobalCC.showPopup("lmsgroup:cvrdtls");
      }

    } catch (Exception e) {
      e.printStackTrace();
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }

    return null;
  }

  public String findCoversProvSel() {

    try {

      // Add event code here...
      DCIteratorBinding dciter =
        ADFUtils.findIterator("findQuoteCoverTypesIterator");
      RowKeySet set = covProvLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();

      //System.out.println(1);
      while (rowKeySetIter.hasNext()) {
        List l = (List)rowKeySetIter.next();
        Key key = (Key)l.get(0);
        dciter.setCurrentRowWithKey(key.toStringFormat(true));
        Row r = dciter.getCurrentRow();

        //LOVCC.qcvtCode=(BigDecimal)r.getAttribute("QCVT_CODE");
        session.setAttribute("qcvtCode", r.getAttribute("QCVT_CODE"));
        session.setAttribute("qcvtcvtCode", r.getAttribute("QCVT_CVT_CODE"));
        //LOVCC.qcvtcvtCode=(BigDecimal)r.getAttribute("QCVT_CVT_CODE");

        //ADFUtils.findIterator("findProdDependentsIterator").executeQuery();
        //AdfFacesContext.getCurrentInstance().addPartialTarget(dependentTypesLOV);

      }

      // Render Popup
      ExtendedRenderKitService erkService =
        Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                           ExtendedRenderKitService.class);
      erkService.addScript(FacesContext.getCurrentInstance(),
                           "var hints = {autodismissNever:false}; " +
                           "AdfPage.PAGE.findComponent('" +
                           "lmsgroup:provisionspopup" + "').show(hints);");

    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }

    return null;
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
        cstmt.setBigDecimal(4, null);
      else {
        cstmt.setString(4, this.discLoadChoice.getValue().toString());
      }

      if (this.discLoadRateDisplay.getValue() == null)
        cstmt.setBigDecimal(5, null);
      else {

        BigDecimal rateVal =
          String.valueOf(this.discLoadRateDisplay.getValue()).equalsIgnoreCase("") ?
          new BigDecimal(0) :
          new BigDecimal(String.valueOf(this.discLoadRateDisplay.getValue()));
        cstmt.setBigDecimal(5, rateVal);
      }

      if (this.coverButChargePremium.getValue() == null)
        cstmt.setBigDecimal(6, null);
      else {
        cstmt.setBigDecimal(6,
                            new BigDecimal(this.coverButChargePremium.getValue().toString()));
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
        cstmt.setString(11, this.avMemberEarnings.getValue().toString());
      }

      if (this.cvrMultipleEarningsPeriod.getValue() == null)
        cstmt.setBigDecimal(12, null);
      else {
        cstmt.setString(12,
                        this.cvrMultipleEarningsPeriod.getValue().toString());
      }

      if (this.totalMem.getValue() == null)
        cstmt.setBigDecimal(13, null);
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
        cstmt.setString(23, this.discRateDisplay.getValue().toString());
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
        cstmt.setString(29, this.coverRateDivFactor.getValue().toString());
      }
      if (this.totalMemEarning.getValue() == null)
        cstmt.setBigDecimal(30, null);
      else {
        cstmt.setString(30, this.totalMemEarning.getValue().toString());
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

      if (this.limInput.getValue() == null) {
        cstmt.setBigDecimal(34, null);
      } else {
        cstmt.setString(34, this.limInput.getValue().toString());
      }

      if (this.aggQuotePlan.getValue() == null) {
        cstmt.setBigDecimal(35, null);
      } else {
        cstmt.setString(35, this.aggQuotePlan.getValue().toString());
      }
      if (this.accelerator.getValue() == null) {
        cstmt.setString(36, null);
      } else {
        cstmt.setString(36, this.accelerator.getValue().toString());
      }
      if (this.builtIn.getValue() == null) {
        cstmt.setString(37, null);
      } else {
        cstmt.setString(37, this.builtIn.getValue().toString());
      }
      cstmt.execute();
      conn.close();

      this.session.setAttribute("qcvtCode", null);
      this.session.setAttribute("dtyCode", null);
      System.out.println("Procedure Executed");

      ADFUtils.findIterator("findQuoteCoverTypesIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.coverTypesLOV);

      this.coverButChargePremium.setValue(null);
      this.discLoadChoice.setValue(null);
      this.discLoadRateDisplay.setValue(null);
      this.divFactor.setValue(null);

      AdfFacesContext.getCurrentInstance().addPartialTarget(this.coverButChargePremium);
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.discLoadChoice);
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.discLoadRateDisplay);
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.divFactor);
      GlobalCC.sysInformation("Cover Type Saved Successfully..");
      GlobalCC.hidePopup("lmsgroup:cvrdtls");
    } catch (Exception e) {
      //GlobalCC.EXCEPTIONREPORTING(conn, e);
      e.printStackTrace();
    }
    return null;
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
      this.session.setAttribute("qcvtCode", null);
      ADFUtils.findIterator("findQuoteCoverTypesIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.coverTypesLOV);
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
  }

  public String editQuotationCoverType() {

    Rendering render = new Rendering();
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
      this.session.setAttribute("CVT_CODE", r.getAttribute("QCVT_CVT_CODE"));
      this.coverLabel.setValue(r.getAttribute("cover_display"));
      this.coverButChargePremium.setValue(r.getAttribute("quoButChargePrem2"));
      this.discLoadChoice.setValue(r.getAttribute("QCVT_LOAD_DISC"));
      this.discLoadRateDisplay.setValue(r.getAttribute("discLoadRate"));
      this.avANB.setValue(r.getAttribute("quoAvganb"));
      this.coverSADisplay.setValue(r.getAttribute("quoQcvtSa"));
      this.dtyDesc.setValue(r.getAttribute("QCVT_DTY_DESCRIPTION"));
      this.session.setAttribute("dtyCode", r.getAttribute("QCVT_DTY_CODE"));
      this.avMemberEarnings.setValue(r.getAttribute("QCVT_AVG_EARN_PER_MEM"));
      this.cvrMultipleEarningsPeriod.setValue(r.getAttribute("QCVT_MULT_EARNINGS_PRD"));
      this.totalMem.setValue(r.getAttribute("quoMembers"));
      this.cvrCategory.setValue(r.getAttribute("QCVT_STAFF_DESC"));
      this.divFactor.setValue(r.getAttribute("QCVT_DISC_LOAD_DIV_FACT"));
      this.mainCover.setValue(r.getAttribute("QCVT_MAIN_COVER"));
      this.totalMemEarning.setValue(r.getAttribute("QCVT_TOT_MEMBER_EARNINGS"));
      this.totLoanAmt.setValue(r.getAttribute("QCVT_TOT_ORIG_LOAN_AMT"));
      this.avCoverPerMem.setValue(r.getAttribute("QCVT_AV_CVR_PER_MEMBER"));
      this.limInput.setValue(r.getAttribute("QCVT_LIMIT"));

      String CmainCover = (String)r.getAttribute("QCVT_MAIN_COVER");
      if (CmainCover.equalsIgnoreCase("RL"))
        this.percMainCvtLabel.setValue("Multiple of Loan Repayment");
      else {
        this.percMainCvtLabel.setValue("% of  Main/Yr Earn");
      }

      this.percMainCvt.setValue(r.getAttribute("QCVT_MAIN_SA_PERC"));
      this.cvrLoanAmt.setValue(r.getAttribute("QCVT_LOANAMT_PER_MEM"));
      this.cvrLoanPrd.setValue(r.getAttribute("QCVT_LOAN_RPYMT_PRD"));
      this.cvrLoanInt.setValue(r.getAttribute("QCVT_LOANINT_PER_MEM"));
      this.cvrSavingsAmt.setValue(r.getAttribute("QCVT_SAVINGS_PER_MEM"));
      this.discChoice.setValue(r.getAttribute("QCVT_DISC"));
      this.discRateDisplay.setValue(r.getAttribute("QCVT_DISC_RATE"));
      this.discDivFactor.setValue(r.getAttribute("QCVT_DISC_DIV_FACT"));
      this.aggQuotePlan.setValue(r.getAttribute("QCVT_AGG_PLAN"));
      this.builtIn.setValue(r.getAttribute("qcvtPctInbuilt"));
      this.accelerator.setValue(r.getAttribute("qcvtAccelerator"));

      session.setAttribute("pcovType",
                           (String)r.getAttribute("QCVT_MAIN_COVER"));
      session.setAttribute("covShtDesc", r.getAttribute("quocvtShtDesc"));

      //reset all MICK rendered controls on edit cover screen
      if (render.isMickVisible()) {
        this.totLoanAmtLabel.setValue("Total Original Loan Amount");
        this.totLoanAmt.setDisabled(false);
        this.loanRepyLabel.setValue("Loan Repayment Period(Months)");
        this.cvrLoanPrd.setDisabled(false);
        this.loanIntLabel.setValue("Loan Interest");
        this.cvrLoanInt.setDisabled(false);

        this.totalMemEarninglbl.setValue("Total Member Earnings");
        this.totalMemEarning.setDisabled(false);
        this.multiEarnsPeriodlbl.setValue("Multiple Earnings Period");
        this.cvrMultipleEarningsPeriod.setDisabled(false);
        //this.cvrMultipleEarningsPeriod.setValue("");
        //this.prdTypeLabel2.setValue("[Years]");
        if (CmainCover.equalsIgnoreCase("R")) {
          avMemEarnlabel.setValue("average cover per member");
        } else {
          avMemEarnlabel.setValue("Av. Earnings Per Member");
        }
      }

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

      String ProductType = (String)this.session.getAttribute("productType");

      if (this.calcType.getValue().toString().equalsIgnoreCase("A")) {
        this.avANBLabel.setRendered(true);
        this.avANB.setRendered(true);
        this.saLabel.setRendered(true);
        this.coverSADisplay.setRendered(true);
        this.depTypeLabel.setRendered(true);
        this.depTypeDtls.setRendered(true);
        this.totalMem.setRendered(true);
        this.totalMemLabel.setRendered(true);
        this.avgLabAggregate.setRendered(true);
        this.avANBLabel.setRendered(false);
        this.aggQuotePlanLbl.setRendered(true);
        this.aggQuotePlan.setRendered(true);

        if (ProductType.equalsIgnoreCase("EARN")) {
          this.avMemberEarnings.setRendered(true);
          this.avMemEarnlabel.setRendered(true);
          this.cvrMultipleEarningsPeriod.setRendered(true);
          this.multiEarnsPeriodlbl.setRendered(true);

          String Value = Validate_Quote_Product();
          if ((Value == null) || (Value == "F"))
            this.prdTypeLabel2.setValue("[Months]");
          else {
            this.prdTypeLabel2.setValue(Value);
          }
          this.prdTypeLabel2.setRendered(true);

          this.cvrCategory.setRendered(true);
          this.cvrCategorylabel.setRendered(true);
          this.totalMemEarninglbl.setRendered(true);
          this.totalMemEarning.setRendered(true);
          this.totLoanAmtLabel.setRendered(false);
          this.totLoanAmt.setRendered(false);
          this.avCoverPerMemLabel.setRendered(false);
          this.avCoverPerMem.setRendered(false);
          this.multiprdPanel.setRendered(true);
          this.aggCategoryPanel.setRendered(true);

          //Render MICK controls for EARNINGS PRODUCTS
          if (render.isMickVisible()) {
            String cover = session.getAttribute("pcovType").toString();
            String covsht = session.getAttribute("covShtDesc").toString();

            if (cover.equalsIgnoreCase("R") ||
                covsht.equalsIgnoreCase("FCG")) {
              this.totalMemEarninglbl.setValue("");
              this.totalMemEarning.setDisabled(true);
              this.multiEarnsPeriodlbl.setValue("");
              this.cvrMultipleEarningsPeriod.setDisabled(true);
              this.cvrMultipleEarningsPeriod.setValue("1");
              this.prdTypeLabel2.setValue("");
              //coversPanel
            }

          }


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
          this.avCoverPerMemLabel.setRendered(false);
          this.avCoverPerMem.setRendered(false);
          this.multiprdPanel.setRendered(false);
          this.aggCategoryPanel.setRendered(false);

          //Render MICK controls for LOANS PRODUCTS
          if (render.isMickVisible()) {

            String covsht = session.getAttribute("covShtDesc").toString();
            String cover = session.getAttribute("pcovType").toString();

            if (cover.equalsIgnoreCase("R") ||
                covsht.equalsIgnoreCase("FCG")) {
              this.totLoanAmtLabel.setValue("");
              this.totLoanAmt.setDisabled(true);
              this.loanRepyLabel.setValue("");
              this.cvrLoanPrd.setDisabled(true);
              this.loanIntLabel.setValue("");
              this.cvrLoanInt.setDisabled(true);
              this.cvrLoanInt.setValue("1");
              this.loanAmtLabel.setValue("Av. Cover Per Member");
              //coversPanel
            } else {
              loanAmtLabel.setValue("Original Loan Amount Per member\n");
            }


            this.aggCategoryPanel.setRendered(true);
            this.cvrCategorylabel.setRendered(true);
            // this.cvrCategory.setValue("DEFAULT");
            this.cvrCategory.setRendered(true);
          }

        } else if (ProductType.equalsIgnoreCase("FUNE")) {
          this.totLoanAmtLabel.setRendered(false);
          this.totLoanAmt.setRendered(false);
          this.avCoverPerMemLabel.setRendered(true);
          this.avCoverPerMem.setRendered(true);
          this.cvrCategory.setRendered(true);
          this.cvrCategorylabel.setRendered(true);
          this.multiprdPanel.setRendered(false);
          this.aggCategoryPanel.setRendered(true);
        }
      } else {
        this.avANBLabel.setRendered(true);
        this.avANB.setRendered(true);
        this.saLabel.setRendered(false);
        this.coverSADisplay.setRendered(false);
        this.depTypeLabel.setRendered(false);
        this.depTypeDtls.setRendered(false);
        this.avMemberEarnings.setRendered(false);
        this.avMemEarnlabel.setRendered(false);
        this.cvrMultipleEarningsPeriod.setRendered(false);
        this.totalMemEarninglbl.setRendered(false);
        this.totalMemEarning.setRendered(false);
        this.prdTypeLabel2.setRendered(false);
        this.totalMem.setRendered(false);
        this.cvrCategory.setRendered(false);
        this.totalMemLabel.setRendered(false);
        this.multiEarnsPeriodlbl.setRendered(false);
        this.cvrCategorylabel.setRendered(false);
        this.loanAmtLabel.setRendered(false);
        this.cvrLoanAmt.setRendered(false);
        this.loanRepyLabel.setRendered(false);
        this.cvrLoanPrd.setRendered(false);
        this.loanIntLabel.setRendered(false);
        this.cvrLoanInt.setRendered(false);
        this.savingsAmtLabel.setRendered(false);
        this.cvrSavingsAmt.setRendered(false);
        this.multiprdPanel.setRendered(false);
        this.aggCategoryPanel.setRendered(false);
        this.avgLabAggregate.setRendered(false);
        this.avANBLabel.setRendered(true);
        this.aggQuotePlanLbl.setRendered(false);
        this.aggQuotePlan.setRendered(false);
        this.aggQuotePlan.setValue(null);
      }

      GlobalCC.showPopup("lmsgroup:cvrdtls");
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

      this.session.setAttribute("TaxShtDesc", r.getAttribute("TT_SHT_DESC"));
      this.session.setAttribute("TaxTRTCode", r.getAttribute("TRT_CODE"));

      this.applLevel.setValue(null);
      this.taxRate.setValue(null);
      this.taxAmt.setValue(null);

      AdfFacesContext.getCurrentInstance().addPartialTarget(this.applLevel);
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.taxRate);
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.taxAmt);
    }
  }

  public String findTaxesSelected() {
    String Rate = null;
    try {
      DCIteratorBinding dciter = ADFUtils.findIterator("FindTaxesIterator");
      RowKeySet set = this.allTaxesLOV.getSelectedRowKeys();
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

        this.session.setAttribute("TaxShtDesc", r.getAttribute("TT_SHT_DESC"));
        this.session.setAttribute("TaxTRTCode", r.getAttribute("TRT_CODE"));

        this.applLevel.setValue(null);
        this.taxRate.setValue(null);
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

  public String PopulateTaxes() {
    String populateTaxes = "BEGIN LMS_WEB_PKG_GRP.populate_taxes(?);END;";
    Connection conn = new DBConnector().getDatabaseConn();
    try {
      CallableStatement cstmt = conn.prepareCall(populateTaxes);
      cstmt.setBigDecimal(1,
                          (BigDecimal)this.session.getAttribute("QuoteCode"));
      cstmt.execute();
      conn.close();
      ADFUtils.findIterator("findQuotationTaxesIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.quotationTaxes);
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
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
      cst.setString(7, (String)this.session.getAttribute("TaxRenewalEndr"));
      cst.setBigDecimal(8, (BigDecimal)this.session.getAttribute("TaxesCode"));
      cst.setString(9, (String)this.session.getAttribute("TaxShtDesc"));
      cst.setBigDecimal(10,
                        (BigDecimal)this.session.getAttribute("QuoteCode"));
      cst.setBigDecimal(11,
                        (BigDecimal)this.session.getAttribute("TaxTRTCode"));
      cst.setString(12, "Q");
      cst.setBigDecimal(13, null);
      cst.setBigDecimal(14, (BigDecimal)this.session.getAttribute("taxCode"));

      cst.execute();
      conn.close();

      this.session.setAttribute("taxCode", null);

      ADFUtils.findIterator("findQuotationTaxesIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.quotationTaxes);
    } catch (Exception e) {
      this.session.setAttribute("taxCode", null);
      FacesContext.getCurrentInstance().addMessage(null,
                                                   new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                    e.getMessage(),
                                                                    e.getMessage()));
    }

    return null;
  }

  public String DeleteTaxes() {
    BigDecimal TaxCode = null;
    String deleteQuery = "BEGIN LMS_WEB_PKG_GRP.delete_taxes(?);END;";
    DCIteratorBinding dciter =
      ADFUtils.findIterator("findQuotationTaxesIterator");
    RowKeySet set = this.quotationTaxes.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();

    while (rowKeySetIter.hasNext()) {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();

      TaxCode = (BigDecimal)r.getAttribute("qtax_code");
    }

    Connection conn = new DBConnector().getDatabaseConn();
    try {
      CallableStatement cstmt = conn.prepareCall(deleteQuery);
      cstmt.setBigDecimal(1, TaxCode);
      cstmt.execute();
      conn.close();
      ADFUtils.findIterator("findQuotationTaxesIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.quotationTaxes);
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
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
        this.session.setAttribute("schCode", r.getAttribute("SCH_CODE"));
        this.categIDDisplay.setValue(r.getAttribute("SCH_SHT_DESC"));
        this.categDescDisplay.setValue(r.getAttribute("SCH_DESC"));
        this.categPeriodDisplay.setValue(r.getAttribute("SLVL_TERM_DURATION"));

        AdfFacesContext.getCurrentInstance().addPartialTarget(this.categIDDisplay);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.categDescDisplay);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.categPeriodDisplay);
      }
      GlobalCC.hidePopup("lmsgroup:p6");
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
    return null;
  }

  public String SaveQuotCategories() {
    Rendering render = new Rendering();
    Connection conn = new DBConnector().getDatabaseConn();

    this.session.setAttribute("categoryMaskCode",
                              this.session.getAttribute("pmasCode"));
    this.catMaskDesc.setValue(this.session.getAttribute("pmasShtDesc"));

    if (this.categDescDisplay.getValue() == null) {
      String Message = "Enter a Category Description";
      FacesContext.getCurrentInstance().addMessage(null,
                                                   new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                    Message,
                                                                    Message));

      return null;
    }
    if (this.categIDDisplay.getValue() == null) {
      String Message = "Enter a Category ID";
      FacesContext.getCurrentInstance().addMessage(null,
                                                   new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                    Message,
                                                                    Message));

      return null;
    }
    if (render.isEarningsproduct()) {
      if (this.categPeriodDisplay.getValue() == null) {
        String Message = "Enter a Category Period";
        FacesContext.getCurrentInstance().addMessage(null,
                                                     new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                      Message,
                                                                      Message));

        return null;
      }
    } else {
      this.categPeriodDisplay.setValue(1);
    }

    String updateQuery =
      "BEGIN LMS_WEB_PKG_GRP.add_category(?,?,?,?,?,?,?,?,?,?,?);END;";

    try {
      CallableStatement cstmt = conn.prepareCall(updateQuery);
      cstmt.setBigDecimal(1, (BigDecimal)this.session.getAttribute("LCACode"));
      cstmt.setBigDecimal(2,
                          (BigDecimal)this.session.getAttribute("QuoteCode"));
      if (this.categIDDisplay.getValue() == null)
        cstmt.setString(3, null);
      else {
        cstmt.setString(3, this.categIDDisplay.getValue().toString());
      }
      if (this.categDescDisplay.getValue() == null)
        cstmt.setString(4, null);
      else {
        cstmt.setString(4, this.categDescDisplay.getValue().toString());
      }
      if (this.categPeriodDisplay.getValue() == null)
        cstmt.setString(5, null);
      else {
        cstmt.setString(5, this.categPeriodDisplay.getValue().toString());
      }
      cstmt.setString(6, null);
      cstmt.setString(7, null);
      cstmt.setBigDecimal(8, (BigDecimal)this.session.getAttribute("schCode"));
      if (this.categoryFees.getValue() == null)
        cstmt.setString(9, null);
      else {
        cstmt.setString(9, this.categoryFees.getValue().toString());
      }
      if (this.categoryStudents.getValue() == null)
        cstmt.setString(10, null);
      else {
        cstmt.setString(10, this.categoryStudents.getValue().toString());
      }
      cstmt.setBigDecimal(11,
                          (BigDecimal)this.session.getAttribute("categoryMaskCode"));

      cstmt.execute();
      conn.close();

      this.session.setAttribute("LCACode", null);
      this.categIDDisplay.setValue(null);
      this.categDescDisplay.setValue(null);
      this.categPeriodDisplay.setValue(null);
      this.categoryFees.setValue(null);
      this.categoryStudents.setValue(null);


      ADFUtils.findIterator("findQuoteCategoriesIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.categoryLOV);
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.categoryTree);
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.categoryDrop);
    } catch (Exception e) {
      this.session.setAttribute("LCACode", null);
      this.categIDDisplay.setValue(null);
      this.categDescDisplay.setValue(null);
      this.categPeriodDisplay.setValue(null);
      this.categoryFees.setValue(null);
      this.categoryStudents.setValue(null);

      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }

    return null;
  }

  public String DeleteCategory() {
    BigDecimal LCACode = null;
    DCIteratorBinding dciter =
      ADFUtils.findIterator("findQuoteCategoriesIterator");
    RowKeySet set = this.categoryLOV.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();

    while (rowKeySetIter.hasNext()) {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();

      LCACode = (BigDecimal)r.getAttribute("lcaCode");
    }

    String deleteQuery = "BEGIN LMS_WEB_PKG_GRP.deleteCategory(?);END;";
    Connection conn = new DBConnector().getDatabaseConn();
    CallableStatement cstmt = null;
    try {
      cstmt = conn.prepareCall(deleteQuery);

      cstmt.setBigDecimal(1, LCACode);
      cstmt.execute();
      conn.close();
      ADFUtils.findIterator("findQuoteCategoriesIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.categoryLOV);
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
  }

  public String editQuotationCategory() {
    DCIteratorBinding dciter =
      ADFUtils.findIterator("findQuoteCategoriesIterator");
    RowKeySet set = this.categoryLOV.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();

    while (rowKeySetIter.hasNext()) {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();

      this.session.setAttribute("LCACode", r.getAttribute("lcaCode"));
      this.categIDDisplay.setValue(r.getAttribute("catShtDesc"));
      this.categDescDisplay.setValue(r.getAttribute("catDesc"));
      this.categPeriodDisplay.setValue(r.getAttribute("catPeriod"));
      this.categoryFees.setValue(r.getAttribute("CTL_FEE_AMOUNT"));
      this.categoryStudents.setValue(r.getAttribute("CTL_AV_STUDENTS"));

      this.session.setAttribute("categoryMaskCode",
                                r.getAttribute("lca_pmas_code"));
      this.catMaskDesc.setValue(r.getAttribute("pmas_sht_desc"));

      GlobalCC.showPopup("lmsgroup:addCategory");
    }

    return null;
  }

  public String AddQuotationCategory() {
    Edit = 0;
    this.categIDDisplay.setValue(null);
    this.categDescDisplay.setValue(null);
    this.categPeriodDisplay.setValue(null);
    this.categoryFees.setValue(null);
    this.categoryStudents.setValue(null);
    this.session.setAttribute("categoryMaskCode",
                              this.session.getAttribute("pmasCode"));
    this.catMaskDesc.setValue(this.session.getAttribute("pmasShtDesc"));

    AdfFacesContext.getCurrentInstance().addPartialTarget(this.catMaskDesc);
    AdfFacesContext.getCurrentInstance().addPartialTarget(this.categPeriodDisplay);
    AdfFacesContext.getCurrentInstance().addPartialTarget(this.categDescDisplay);
    AdfFacesContext.getCurrentInstance().addPartialTarget(this.categPeriodDisplay);

    GlobalCC.showPopup("lmsgroup:addCategory");
    return null;
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
    }
  }

  public String findDepLimitCategorysel() {
    try {
      DCIteratorBinding dciter =
        ADFUtils.findIterator("findQuoteCategoriesIterator");
      RowKeySet set = this.depLimitCategoryLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();

      while (rowKeySetIter.hasNext()) {
        List l = (List)rowKeySetIter.next();
        Key key = (Key)l.get(0);
        dciter.setCurrentRowWithKey(key.toStringFormat(true));
        Row r = dciter.getCurrentRow();

        this.session.setAttribute("LCACode", r.getAttribute("lcaCode"));

        ADFUtils.findIterator("findProductCoverDependantsIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.dependentTypesLOV);

        GlobalCC.showPopup("lmsgroup:addDependent");
      }
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

        this.session.setAttribute("qcvtCode", r.getAttribute("QCVT_CODE"));
        this.session.setAttribute("qcvtcvtCode",
                                  r.getAttribute("QCVT_CVT_CODE"));

        ADFUtils.findIterator("findProductCoverDependantsIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.dependentTypesLOV);

        GlobalCC.showPopup("lmsgroup:addDependent");
      }

    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }

    return null;
  }

  public void ProvisionsListener(ValueChangeEvent valueChangeEvent) {
    if (this.provisionsCbox.isSelected())
      SaveSelectedProvision();
  }

  public String EditCoverProvision() {

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

        session.setAttribute("qpprCode", r.getAttribute("qpprCode"));
        provID.setValue(r.getAttribute("quotProvshtDesc"));
        provDesc.setValue(r.getAttribute("quotProvDesc"));

        GlobalCC.showPopup("lmsgroup:editProvPopup");
      }
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
    return null;
  }

  public String DeleteCoverProvision() {
    BigDecimal PRCode = null;

    DCIteratorBinding dciter =
      ADFUtils.findIterator("findQuoteProvisionsIterator");
    RowKeySet set = this.coverTypeProvisions.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();

    while (rowKeySetIter.hasNext()) {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();

      PRCode = (BigDecimal)r.getAttribute("qpprCode");
    }

    String deleteQuery =
      "BEGIN LMS_WEB_PKG_GRP.deleteCoverProvision(?,?);END;";
    Connection conn = new DBConnector().getDatabaseConn();
    try {
      CallableStatement cstmt = conn.prepareCall(deleteQuery);
      cstmt.setBigDecimal(1, PRCode);
      cstmt.setString(2, "Q");
      cstmt.execute();
      conn.close();
      ADFUtils.findIterator("findQuoteProvisionsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.coverTypeProvisions);
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

  public String SaveEditedProvision() {
    Connection conn = null;

    try {
      String SaveQuery =
        "BEGIN LMS_WEB_PKG_GRP.updateProvisions(?,?,?,?,?,?,?);END;";
      conn = new DBConnector().getDatabaseConn();

      CallableStatement cstmt = conn.prepareCall(SaveQuery);
      cstmt.setBigDecimal(1, null);
      cstmt.setBigDecimal(2, null);
      cstmt.setBigDecimal(3, null);
      if (provDesc.getValue() == null) {
        cstmt.setString(4, null);
      } else {
        cstmt.setString(4, provDesc.getValue().toString());
      }
      cstmt.setString(5, null);
      cstmt.setBigDecimal(6, (BigDecimal)session.getAttribute("qpprCode"));
      cstmt.setString(7, null);

      cstmt.execute();
      cstmt.close();
      conn.close();
      GlobalCC.INFORMATIONREPORTING("Provision Successfully Editted.");
      ADFUtils.findIterator("findQuoteProvisionsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.coverTypeProvisions);
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
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

        this.session.setAttribute("pprov_Code", r.getAttribute("PPROV_CODE"));
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

      cstmt.setBigDecimal(6, null);
      cstmt.execute();
      cstmt.close();
      conn.close();
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }

    return null;
  }

  public void dependantsListener(SelectionEvent selectionEvent) {
    DCIteratorBinding dciter =
      ADFUtils.findIterator("findProductCoverDependantsIterator");
    RowKeySet set = selectionEvent.getAddedSet();
    Iterator rowKeySetIter = set.iterator();

    while (rowKeySetIter.hasNext()) {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();

      this.session.setAttribute("dtyCode", r.getAttribute("DTY_CODE"));
      this.dependentType.setValue(r.getAttribute("DTY_DESCRIPTION"));

      this.session.setAttribute("maxTypeNo", r.getAttribute("max_allowed"));
      this.dpdLimitAmount.setValue(null);
      this.maxType.setValue(r.getAttribute("max_allowed"));

      AdfFacesContext.getCurrentInstance().addPartialTarget(this.dpdLimitAmount);
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.maxType);
    }
  }

  public String FindDepsSel() {
    try {
      DCIteratorBinding dciter =
        ADFUtils.findIterator("findProductCoverDependantsIterator");
      RowKeySet set = this.dependentTypesLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();

      while (rowKeySetIter.hasNext()) {
        List l = (List)rowKeySetIter.next();
        Key key = (Key)l.get(0);
        dciter.setCurrentRowWithKey(key.toStringFormat(true));
        Row r = dciter.getCurrentRow();

        this.session.setAttribute("dtyCode", r.getAttribute("DTY_CODE"));
        this.dependentType.setValue(r.getAttribute("DTY_DESCRIPTION"));
        this.session.setAttribute("maxTypeNo", r.getAttribute("max_allowed"));
        this.dpdLimitAmount.setValue(r.getAttribute("pcd_max_sum_assured"));
        this.maxType.setValue(r.getAttribute("max_allowed"));
        this.dpdMinAmount.setValue(r.getAttribute("PCD_MIN_SUM_ASSURED"));

        AdfFacesContext.getCurrentInstance().addPartialTarget(this.dpdLimitAmount);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.maxType);

        GlobalCC.showPopup("lmsgroup:depend");
      }

    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }

    return null;
  }

  public String SaveDependentType() {
    if (this.dpdLimitAmount.getValue() == null) {
      String Message = "Enter a Limit Amount";
      FacesContext.getCurrentInstance().addMessage(null,
                                                   new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                    Message,
                                                                    Message));
    }

    String saveQuery =
      "BEGIN LMS_WEB_PKG_GRP.save_quotation_dependents(?,?,?,?,?,?,?,?,?,?,?);END;";
    Connection conn = new DBConnector().getDatabaseConn();
    try {
      CallableStatement cstmt = conn.prepareCall(saveQuery);
      cstmt.setBigDecimal(1, (BigDecimal)this.session.getAttribute("dtyCode"));
      cstmt.setBigDecimal(2, null);
      if (this.maxType.getValue() == null)
        cstmt.setBigDecimal(3, null);
      else {
        cstmt.setString(3, this.maxType.getValue().toString());
      }
      cstmt.setBigDecimal(4, (BigDecimal)this.session.getAttribute("qdlCode"));
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
      this.session.setAttribute("qcvtCode", null);
      ADFUtils.findIterator("findQuoteDependantLimitsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.quotationDependentsLOV);
    } catch (Exception e) {
      this.session.setAttribute("qcvtCode", null);
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }

    return null;
  }

  public String DeleteDependentLimit() {
    BigDecimal qdlCode = null;

    DCIteratorBinding dciter =
      ADFUtils.findIterator("findQuoteDependantLimitsIterator");
    RowKeySet set = this.quotationDependentsLOV.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();

    while (rowKeySetIter.hasNext()) {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();

      qdlCode = (BigDecimal)r.getAttribute("QDL_CODE");
    }
    String deleteQuery = "BEGIN LMS_WEB_PKG_GRP.delete_dpd_limit(?,?);END;";
    Connection conn = new DBConnector().getDatabaseConn();
    try {
      CallableStatement cstmt = conn.prepareCall(deleteQuery);
      cstmt.setBigDecimal(1, qdlCode);
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

  public String AuthoriseQuotation() {
    CorrespondenceManipulation email = new CorrespondenceManipulation();
    String authQuery = "BEGIN LMS_WEB_PKG_GRP.authorize_quot(?);END;";
    try {
      Connection conn = new DBConnector().getDatabaseConn();
      CallableStatement cstmt = null;

      if (this.sumAssuredDisplay.getValue() != null) {
        this.session.setAttribute("SumAssured",
                                  this.sumAssuredDisplay.getValue().toString());
        this.session.setAttribute("DebitCredit", "C");
      }

      String Rights = null;

      this.session.setAttribute("ProcessShtDesc", "QUOT");
      this.session.setAttribute("ProcessAreaShtDesc", "QUW");
      this.session.setAttribute("ProcessSubAShtDesc", "QUWA");
      workflowProcessing wf = new workflowProcessing();
      Rights = wf.CheckUserRights();

      if (Rights.equalsIgnoreCase("N")) {
        String Message = "You do not have rights to Perform this Task.";
        FacesContext.getCurrentInstance().addMessage(null,
                                                     new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                      Message,
                                                                      Message));

        return null;
      }

      String NextUser = null;

      this.session.setAttribute("ProcessShtDesc", "QUOT");
      this.session.setAttribute("ProcessAreaShtDesc", "QDISP");
      this.session.setAttribute("ProcessSubAShtDesc", "QDISP");
      this.session.setAttribute("TaskAssignee", null);
      this.session.setAttribute("NextTaskAssignee", "N");
      ADFUtils.findIterator("findTicketAssigneeIterator").executeQuery();
      NextUser = (String)this.session.getAttribute("NextTaskAssignee");
      String TaskAss = (String)this.session.getAttribute("TaskAssignee");
      if (TaskAss == null) {
        TaskAss = (String)session.getAttribute("Username");
        session.setAttribute("TaskAssignee", TaskAss);
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
        cst3.setString(1, "AQUOT");
        cst3.setString(2, (String)this.session.getAttribute("TaskID"));
        cst3.setInt(3,
                    ((Integer)this.session.getAttribute("sysCode")).intValue());
        cst3.registerOutParameter(4, 12);
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

      }

      cstmt = conn.prepareCall(authQuery);
      cstmt.setBigDecimal(1,
                          (BigDecimal)this.session.getAttribute("QuoteCode"));
      cstmt.execute();
      conn.close();

      this.session.setAttribute("transType", "VQ");
      ADFUtils.findIterator("findQuotation1Iterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.sumAssuredDisplay);

      Taske = (String)this.session.getAttribute("TaskID");
      if (Taske != null) {
        this.session.setAttribute("ProcessShtDesc", "QUOT");
        this.session.setAttribute("ProcessAreaShtDesc", "QDISP");
        this.session.setAttribute("ProcessSubAShtDesc", "QDISP");
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

        String Message = "Quotation Successfully Authorised";
        FacesContext.getCurrentInstance().addMessage(null,
                                                     new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                      Message,
                                                                      Message));

        return null;
      }

      System.out.println("Success");
      FacesContext.getCurrentInstance().addMessage(null,
                                                   new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                    "Quotation Successfully Authorised",
                                                                    "Quotation Successfully Authorised"));
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
    email.emailReport("QUOAUTH");
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
      this.dependentType.setValue(r.getAttribute("DTY_DESCRIPTION"));
      this.maxType.setValue(r.getAttribute("QDL_MAX_TYPE_ALLOWED"));
      this.dpdLimitAmount.setValue(r.getAttribute("QDL_LIMIT_AMT"));
      this.dpdMinAmount.setValue(r.getAttribute("QDL_MIN_AMT"));

      GlobalCC.showPopup("lmsgroup:depend");
    }

    return null;
  }

  public String EditTaxesSelected() {
    try {
      DCIteratorBinding dciter =
        ADFUtils.findIterator("findQuotationTaxesIterator");
      RowKeySet set = this.quotationTaxes.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();

      while (rowKeySetIter.hasNext()) {
        List l = (List)rowKeySetIter.next();
        Key key = (Key)l.get(0);
        dciter.setCurrentRowWithKey(key.toStringFormat(true));
        Row r = dciter.getCurrentRow();

        this.session.setAttribute("taxCode", r.getAttribute("qtax_code"));
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

  public String EditMemberANB() {
    DCIteratorBinding dciter =
      ADFUtils.findIterator("findQuoteMembersIterator");
    RowKeySet set = this.quotMembersLOV.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();

    while (rowKeySetIter.hasNext()) {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();

      this.session.setAttribute("qmemCode", r.getAttribute("QMEM_CODE"));
      memberNo.setValue(r.getAttribute("quoMemNo"));
      memSurname.setValue(r.getAttribute("memSurname"));
      memOtherNames.setValue(r.getAttribute("memOtherNames"));
      memSex.setValue(r.getAttribute("memSex"));
      // memDob.setValue(r.getAttribute("memDOB"));

      ExtendedRenderKitService erkService =
        (ExtendedRenderKitService)Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                                     ExtendedRenderKitService.class);

      erkService.addScript(FacesContext.getCurrentInstance(),
                           "var hints = {autodismissNever:false}; AdfPage.PAGE.findComponent('lmsgroup:alterANBPopup').show(hints);");
    }

    return null;
  }

  public String AlterMemberANB() {
    String UpdateANBQuery =
      "BEGIN LMS_WEB_PKG_GRP.alterQuotmember(?,?,?,?,?,?);END;";

    Connection conn = new DBConnector().getDatabaseConn();
    try {
      CallableStatement cstmt = conn.prepareCall(UpdateANBQuery);

      cstmt.setBigDecimal(1,
                          (BigDecimal)this.session.getAttribute("qmemCode"));
      if (memberNo.getValue() == null) {
        cstmt.setString(2, null);
      } else {
        cstmt.setString(2, memberNo.getValue().toString());
      }
      if (memSurname.getValue() == null) {
        cstmt.setString(3, null);
      } else {
        cstmt.setString(3, memSurname.getValue().toString());
      }
      if (memOtherNames.getValue() == null) {
        cstmt.setString(4, null);
      } else {
        cstmt.setString(4, memOtherNames.getValue().toString());
      }
      if (memSex.getValue() == null) {
        cstmt.setString(5, null);
      } else {
        cstmt.setString(5, memSex.getValue().toString());
      }
      if (memDob.getValue() == null) {
        cstmt.setString(6, null);
      } else {
        System.out.println("Date=" + memDob.getValue());
        cstmt.setString(6, GlobalCC.parseDate(memDob.getValue().toString()));
      }
      cstmt.execute();
      conn.close();
      ADFUtils.findIterator("findQuoteMembersIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.quotMembersLOV);
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
      e.printStackTrace();
    }
    return null;
  }

  public String MakeReady() {
    try {
      Connection conn = new DBConnector().getDatabaseConn();

      String Rights = null;

      this.session.setAttribute("ProcessShtDesc", "QUOT");
      this.session.setAttribute("ProcessAreaShtDesc", "QUW");
      this.session.setAttribute("ProcessSubAShtDesc", "QUWP");
      workflowProcessing wf = new workflowProcessing();
      Rights = wf.CheckUserRights();

      if (Rights.equalsIgnoreCase("N")) {
        String Message = "You do not have rights to Perform this Task.";
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
        cst3.setString(1, "UQUOT");
        cst3.setString(2, (String)this.session.getAttribute("TaskID"));
        cst3.setBigDecimal(3, new BigDecimal(27));
        cst3.registerOutParameter(4, 12);
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

      }

      String UpdateANBQuery = "BEGIN LMS_WEB_PKG_GRP.make_quot_ready(?);END;";
      CallableStatement cstmt = conn.prepareCall(UpdateANBQuery);
      cstmt.setBigDecimal(1,
                          (BigDecimal)this.session.getAttribute("QuoteCode"));
      cstmt.execute();
      conn.close();
      ADFUtils.findIterator("findQuoteCoverTypesIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.coverTypesLOV);

      ADFUtils.findIterator("findQuoteAgenciesIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.allAgentsLOV);

      ADFUtils.findIterator("findQuotation1Iterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.sumAssuredDisplay);

      if (this.sumAssuredDisplay.getValue() != null) {
        this.session.setAttribute("SumAssured",
                                  this.sumAssuredDisplay.getValue().toString());
        this.session.setAttribute("DebitCredit", "D");
      } else {
        this.session.setAttribute("SumAssured", "0");
        this.session.setAttribute("DebitCredit", "D");
      }

      String NextUser = null;

      this.session.setAttribute("ProcessShtDesc", "QUOT");
      this.session.setAttribute("ProcessAreaShtDesc", "QUW");
      this.session.setAttribute("ProcessSubAShtDesc", "QUWA");
      this.session.setAttribute("TaskAssignee", null);
      this.session.setAttribute("NextTaskAssignee", "N");
      ADFUtils.findIterator("findTicketAssigneeIterator").executeQuery();
      NextUser = (String)this.session.getAttribute("NextTaskAssignee");
      String TaskAss = (String)this.session.getAttribute("TaskAssignee");
      if (TaskAss == null) {
        TaskAss = (String)session.getAttribute("Username");
        session.setAttribute("TaskAssignee", TaskAss);
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

      AdfFacesContext.getCurrentInstance().addPartialTarget(this.quotePrem);
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.noofMembers);
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.coverToDate);

      Taske = (String)this.session.getAttribute("TaskID");
      if (Taske != null) {
        this.session.setAttribute("ProcessShtDesc", "QUOT");
        this.session.setAttribute("ProcessAreaShtDesc", "QUW");
        this.session.setAttribute("ProcessSubAShtDesc", "QUWA");
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

        String Message = "Transaction Made Ready";
        FacesContext.getCurrentInstance().addMessage(null,
                                                     new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                      Message,
                                                                      Message));

        return null;
      }

      String Message = "Transaction Made Ready";
      FacesContext.getCurrentInstance().addMessage(null,
                                                   new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                    Message,
                                                                    Message));
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
    return null;
  }

  public String DeleteQuotMember() {
    BigDecimal qmemCode = null;
    BigDecimal dtyCode = null;
    Connection conn = null;
    try {
      String DeleteMemberQuery =
        "BEGIN LMS_WEB_PKG_GRP.delete_quot_member(?,?,?,?);END;";
      conn = new DBConnector().getDatabaseConn();
      DCIteratorBinding dciter =
        ADFUtils.findIterator("findQuoteMembersIterator");
      RowKeySet set = this.quotMembersLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();

      while (rowKeySetIter.hasNext()) {
        List l = (List)rowKeySetIter.next();
        Key key = (Key)l.get(0);
        dciter.setCurrentRowWithKey(key.toStringFormat(true));
        Row r = dciter.getCurrentRow();

        qmemCode = (BigDecimal)r.getAttribute("QMEM_MEM_CODE");
        dtyCode = (BigDecimal)r.getAttribute("QMEM_DTY_CODE");

        CallableStatement cstmt = conn.prepareCall(DeleteMemberQuery);
        cstmt.setBigDecimal(1,
                            (BigDecimal)this.session.getAttribute("QuoteCode"));
        cstmt.setBigDecimal(2, qmemCode);
        System.out.println(qmemCode);
        cstmt.setString(3, "D");
        cstmt.setBigDecimal(4, dtyCode);
        System.out.println(dtyCode);
        cstmt.execute();
      }

      conn.close();
      ADFUtils.findIterator("findQuoteMembersIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.quotMembersLOV);
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
  }

  public String goToMembers() {
    try {
      GlobalCC.RedirectPage("/g_qmembers.jspx");
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
    return null;
  }

  public String goEditMembers() {


    try {
      DCIteratorBinding dciter =
        ADFUtils.findIterator("findQuoteMembersIterator");
      RowKeySet set = this.quotMembersLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();

      while (rowKeySetIter.hasNext()) {
        List l = (List)rowKeySetIter.next();
        Key key = (Key)l.get(0);
        dciter.setCurrentRowWithKey(key.toStringFormat(true));
        Row r = dciter.getCurrentRow();

        //qmemCode = (BigDecimal)r.getAttribute("QMEM_MEM_CODE");
        //dtyCode = (BigDecimal)r.getAttribute("QMEM_DTY_CODE");
      }

      GlobalCC.RedirectPage("/qmember_alter.jspx");
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
    return null;
  }

  public String findAgentSel() {
    try {
      String agnName = null;
      // String jointAgn = (String)this.session.getAttribute("JointAgents");
      if (checkAssignedAgents() > 1) {
        this.leader_followerLab.setRendered(true);
        this.getLeader_follower.setRendered(true);
        this.addAgnShareLab.setRendered(true);
        this.addAgnShareTF.setRendered(true);
        this.agnLdrFolCol.setRendered(true);
        this.agnShareCol.setRendered(true);
      }

      DCIteratorBinding dciter = ADFUtils.findIterator("FindAgentsIterator");

      RowKeySet set = this.agentsLOV.getSelectedRowKeys();

      Iterator rowKeySetIter = set.iterator();

      while (rowKeySetIter.hasNext()) {
        List l = (List)rowKeySetIter.next();
        Key key = (Key)l.get(0);
        dciter.setCurrentRowWithKey(key.toStringFormat(true));
        Row r = dciter.getCurrentRow();

        this.session.setAttribute("agnShtDesc",
                                  r.getAttribute("AGN_SHT_DESC"));
        this.session.setAttribute("agnCode", r.getAttribute("AGN_CODE"));
        this.session.setAttribute("agnName", r.getAttribute("AGN_NAME"));
        agnName = (String)r.getAttribute("AGN_NAME");
        this.addAgentsDispl.setValue(agnName);
        this.agentsAuth.setValue("N");
        this.agentAssignTo.setValue("N");

        ExtendedRenderKitService erkService =
          (ExtendedRenderKitService)Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                                       ExtendedRenderKitService.class);

        erkService.addScript(FacesContext.getCurrentInstance(),
                             "var hints = {autodismissNever:false}; AdfPage.PAGE.findComponent('lmsgroup:addAgen').show(hints);");
      }

    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(null, e);
      e.printStackTrace();
    }
    return null;
  }

  public String AttachAgent() {
    Connection conn = null;
    String insertQuery =
      "BEGIN LMS_WEB_PKG_GRP.attachAgents(?,?,?,?,?,?,?,?);END;";
    try {
      conn = new DBConnector().getDatabaseConn();
      CallableStatement cstmt = conn.prepareCall(insertQuery);
      cstmt.setBigDecimal(1, (BigDecimal)this.session.getAttribute("agnCode"));

      cstmt.setBigDecimal(2,
                          (BigDecimal)this.session.getAttribute("QuoteCode"));

      cstmt.setString(3, (String)this.session.getAttribute("agnName"));
      cstmt.setString(4, (String)this.session.getAttribute("agnShtDesc"));
      if (this.agentsAuth.getValue() == null)
        cstmt.setString(5, "N");
      else {
        cstmt.setString(5, this.agentsAuth.getValue().toString());
      }
      if (this.agentAssignTo.getValue() == null)
        cstmt.setString(6, "N");
      else {
        cstmt.setString(6, this.agentAssignTo.getValue().toString());
      }
      if (this.getLeader_follower.getValue() == null) {
        cstmt.setString(7, null);
      } else {
        cstmt.setString(7, (String)this.getLeader_follower.getValue());
      }
      if (this.addAgnShareTF.getValue() == null) {
        cstmt.setString(8, null);
      } else {
        cstmt.setString(8, (String)this.addAgnShareTF.getValue());
      }
      cstmt.execute();
      conn.close();

      ADFUtils.findIterator("findQuoteAgenciesIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.allAgentsLOV);

      this.session.setAttribute("agnShtDesc", null);
      this.session.setAttribute("agnName", null);
      this.session.setAttribute("agnCode", null);
    } catch (Exception e) {
      this.session.setAttribute("agnShtDesc", null);
      this.session.setAttribute("agnName", null);
      this.session.setAttribute("agnCode", null);
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
  }

  public String EditAgent() {
    try {
      DCIteratorBinding dciter =
        ADFUtils.findIterator("findQuoteAgenciesIterator");

      RowKeySet set = this.allAgentsLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();

      while (rowKeySetIter.hasNext()) {
        List l = (List)rowKeySetIter.next();
        Key key = (Key)l.get(0);
        dciter.setCurrentRowWithKey(key.toStringFormat(true));
        Row r = dciter.getCurrentRow();

        this.session.setAttribute("quaCode", r.getAttribute("qua_code"));
        this.agentsDispl.setValue(r.getAttribute("qua_agn_name"));
        this.edAssignTo.setValue(r.getAttribute("qua_agn_asgn"));
        this.edAuthorised.setValue(r.getAttribute("qua_authorized"));

        if (checkAssignedAgents() > 1) {
          this.edtleader_followerLab.setRendered(true);
          this.editLeader_followerCmb.setRendered(true);
          this.edtAgnShareLab.setRendered(true);
          this.edtAgnShareTF.setRendered(true);
          this.agnLdrFolCol.setRendered(true);
          this.agnShareCol.setRendered(true);
        }

        ExtendedRenderKitService erkService =
          (ExtendedRenderKitService)Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                                       ExtendedRenderKitService.class);

        erkService.addScript(FacesContext.getCurrentInstance(),
                             "var hints = {autodismissNever:false}; AdfPage.PAGE.findComponent('lmsgroup:editAgen').show(hints);");
      }

    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
    return null;
  }

  public int checkAssignedAgents() {
    String agnCountQuery =
      "BEGIN LMS_WEB_PKG_GRP.get_nof_quo_agents(?,?);END;";
    int agnCount = 0;
    try {
      Connection conn = new DBConnector().getDatabaseConn();
      CallableStatement cstmt = null;
      cstmt = conn.prepareCall(agnCountQuery);
      cstmt.registerOutParameter(1, 2);
      cstmt.setBigDecimal(2,
                          (BigDecimal)this.session.getAttribute("QuoteCode"));
      cstmt.execute();
      agnCount = cstmt.getBigDecimal(1).intValue();
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
    return agnCount;
  }

  public String UpdateAgent() {
    Connection conn = null;

    String insertQuery =
      "BEGIN LMS_WEB_PKG_GRP.update_attached_agent(?,?,?,?,?,?);END;";
    try {
      conn = new DBConnector().getDatabaseConn();
      CallableStatement cstmt = conn.prepareCall(insertQuery);
      cstmt.setBigDecimal(1,
                          (BigDecimal)this.session.getAttribute("QuoteCode"));

      cstmt.setBigDecimal(2, (BigDecimal)this.session.getAttribute("quaCode"));

      if (this.edAssignTo.getValue() == null)
        cstmt.setString(3, "N");
      else {
        cstmt.setString(3, this.edAssignTo.getValue().toString());
      }
      if (this.edAuthorised.getValue() == null)
        cstmt.setString(4, "N");
      else {
        cstmt.setString(4, this.edAuthorised.getValue().toString());
      }
      if (this.editLeader_followerCmb.getValue() == null) {
        cstmt.setString(5, null);
      } else
        cstmt.setString(5, (String)this.editLeader_followerCmb.getValue());
      if (this.edtAgnShareTF.getValue() == null) {
        cstmt.setString(6, null);
      } else {
        cstmt.setString(6, (String)this.edtAgnShareTF.getValue());
      }

      cstmt.execute();
      conn.close();
      ADFUtils.findIterator("findQuoteAgenciesIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.allAgentsLOV);

      this.session.setAttribute("quaCode", null);
    } catch (Exception e) {
      this.session.setAttribute("quaCode", null);
      e.printStackTrace();
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
  }

  public String DeleteAgent() {
    Connection conn = null;
    try {
      DCIteratorBinding dciter =
        ADFUtils.findIterator("findQuoteAgenciesIterator");
      RowKeySet set = this.allAgentsLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();

      while (rowKeySetIter.hasNext()) {
        List l = (List)rowKeySetIter.next();
        Key key = (Key)l.get(0);
        dciter.setCurrentRowWithKey(key.toStringFormat(true));
        Row r = dciter.getCurrentRow();
        this.session.setAttribute("quaCode", r.getAttribute("qua_code"));
      }

      String insertQuery =
        "BEGIN LMS_WEB_PKG_GRP.del_attached_agent(?,?);END;";

      conn = new DBConnector().getDatabaseConn();
      CallableStatement cstmt = conn.prepareCall(insertQuery);
      cstmt.setBigDecimal(1,
                          (BigDecimal)this.session.getAttribute("QuoteCode"));
      cstmt.setBigDecimal(2, (BigDecimal)this.session.getAttribute("quaCode"));
      cstmt.execute();
      conn.close();
      ADFUtils.findIterator("findQuoteAgenciesIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.allAgentsLOV);
      this.session.setAttribute("quaCode", null);
    } catch (Exception e) {
      this.session.setAttribute("quaCode", null);
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
  }

  public String ImportTemplate() {
    try {
      this.session.setAttribute("templateTranSeq", Integer.valueOf(0));
      this.session.setAttribute("SystemPoint", "Q");
      this.session.setAttribute("TotalMembers", new BigDecimal("0"));
      this.session.setAttribute("ValidMembers", new BigDecimal("0"));
      this.session.setAttribute("InValidMembers", new BigDecimal("0"));
      GlobalCC.RedirectPage("/qmembersimport.jspx");
    } catch (Exception ex) {
      GlobalCC.EXCEPTIONREPORTING(null, ex);
    }
    return null;
  }

  public String sendSMS() {
    this.session.setAttribute("sysModule", "Q");
    this.session.setAttribute("msgType", "SMS");

    FacesContext context = FacesContext.getCurrentInstance();

    ViewHandler viewHandler = context.getApplication().getViewHandler();

    GlobalCC.dialogName = "/sms.jspx";
    UIViewRoot dialog = viewHandler.createView(context, GlobalCC.dialogName);

    HashMap properties = new HashMap();
    properties.put("width", Integer.valueOf(600));
    properties.put("height", Integer.valueOf(800));

    AdfFacesContext afContext = AdfFacesContext.getCurrentInstance();

    afContext.launchDialog(dialog, null, null, true, properties);

    return null;
  }

  public String sendEmail() {
    this.session.setAttribute("sysModule", "Q");
    this.session.setAttribute("msgType", "EMAIL");

    FacesContext context = FacesContext.getCurrentInstance();

    ViewHandler viewHandler = context.getApplication().getViewHandler();

    GlobalCC.dialogName = "/email.jspx";
    UIViewRoot dialog = viewHandler.createView(context, GlobalCC.dialogName);

    HashMap properties = new HashMap();
    properties.put("width", Integer.valueOf(600));
    properties.put("height", Integer.valueOf(800));

    AdfFacesContext afContext = AdfFacesContext.getCurrentInstance();

    afContext.launchDialog(dialog, null, null, true, properties);

    return null;
  }

  public String SearchMembers() {
    try {
      if (srchMemName.getValue() == null) {
        session.setAttribute("srchMemName", null);
      } else {
        session.setAttribute("srchMemName", srchMemName.getValue().toString());
      }

      if (srchMemNo.getValue() == null) {
        session.setAttribute("srchMemNo", null);
      } else {
        session.setAttribute("srchMemNo", srchMemNo.getValue().toString());
      }
      ADFUtils.findIterator("findQuoteMembersIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.quotMembersLOV);

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

      ADFUtils.findIterator("findQuoteMembersIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.quotMembersLOV);

    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }

    return null;
  }


  public void setCoverTypesLOV(RichTable coverTypesLOV) {
    this.coverTypesLOV = coverTypesLOV;
  }

  public RichTable getCoverTypesLOV() {
    return this.coverTypesLOV;
  }

  public void setCoverLabel(RichOutputText coverLabel) {
    this.coverLabel = coverLabel;
  }

  public RichOutputText getCoverLabel() {
    return this.coverLabel;
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

  public void setEdCoverlabel(RichOutputText edCoverlabel) {
    this.edCoverlabel = edCoverlabel;
  }

  public RichOutputText getEdCoverlabel() {
    return this.edCoverlabel;
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

  public void setApplLevel(RichSelectOneChoice applLevel) {
    this.applLevel = applLevel;
  }

  public RichSelectOneChoice getApplLevel() {
    return this.applLevel;
  }

  public void setTaxRate(RichInputText taxRate) {
    this.taxRate = taxRate;
  }

  public RichInputText getTaxRate() {
    return this.taxRate;
  }

  public void setTaxAmt(RichInputText taxAmt) {
    this.taxAmt = taxAmt;
  }

  public RichInputText getTaxAmt() {
    return this.taxAmt;
  }

  public void setQuotationTaxes(RichTable quotationTaxes) {
    this.quotationTaxes = quotationTaxes;
  }

  public RichTable getQuotationTaxes() {
    return this.quotationTaxes;
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

  public void setProductProvisionsLOV(RichTable productProvisionsLOV) {
    this.productProvisionsLOV = productProvisionsLOV;
  }

  public RichTable getProductProvisionsLOV() {
    return this.productProvisionsLOV;
  }

  public void setProvisionsCbox(RichSelectBooleanCheckbox provisionsCbox) {
    this.provisionsCbox = provisionsCbox;
  }

  public RichSelectBooleanCheckbox getProvisionsCbox() {
    return this.provisionsCbox;
  }

  public void setCoverTypeProvisions(RichTable coverTypeProvisions) {
    this.coverTypeProvisions = coverTypeProvisions;
  }

  public RichTable getCoverTypeProvisions() {
    return this.coverTypeProvisions;
  }

  public void setDependentTypesLOV(RichTable dependentTypesLOV) {
    this.dependentTypesLOV = dependentTypesLOV;
  }

  public RichTable getDependentTypesLOV() {
    return this.dependentTypesLOV;
  }

  public void setDependentCoverTypes(RichTable dependentCoverTypes) {
    this.dependentCoverTypes = dependentCoverTypes;
  }

  public RichTable getDependentCoverTypes() {
    return this.dependentCoverTypes;
  }

  public void setDependentCategory(RichInputText dependentCategory) {
    this.dependentCategory = dependentCategory;
  }

  public RichInputText getDependentCategory() {
    return this.dependentCategory;
  }

  public void setDependentType(RichInputText dependentType) {
    this.dependentType = dependentType;
  }

  public RichInputText getDependentType() {
    return this.dependentType;
  }

  public void setDpdLimitAmount(RichInputText dpdLimitAmount) {
    this.dpdLimitAmount = dpdLimitAmount;
  }

  public RichInputText getDpdLimitAmount() {
    return this.dpdLimitAmount;
  }

  public void setMaxType(RichInputText maxType) {
    this.maxType = maxType;
  }

  public RichInputText getMaxType() {
    return this.maxType;
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

  public void setQuotMembersLOV(RichTable quotMembersLOV) {
    this.quotMembersLOV = quotMembersLOV;
  }

  public RichTable getQuotMembersLOV() {
    return this.quotMembersLOV;
  }

  public void setOldANBDisp(RichOutputText oldANBDisp) {
    this.oldANBDisp = oldANBDisp;
  }

  public RichOutputText getOldANBDisp() {
    return this.oldANBDisp;
  }

  public void setNewANBDisplay(RichInputText newANBDisplay) {
    this.newANBDisplay = newANBDisplay;
  }

  public RichInputText getNewANBDisplay() {
    return this.newANBDisplay;
  }

  public void setSumAssuredDisplay(RichInputText sumAssuredDisplay) {
    this.sumAssuredDisplay = sumAssuredDisplay;
  }

  public RichInputText getSumAssuredDisplay() {
    return this.sumAssuredDisplay;
  }

  public void setAgentsLOV(RichTable agentsLOV) {
    this.agentsLOV = agentsLOV;
  }

  public RichTable getAgentsLOV() {
    return this.agentsLOV;
  }

  public void setConProductDisplay(RichInputText conProductDisplay) {
    this.conProductDisplay = conProductDisplay;
  }

  public RichInputText getConProductDisplay() {
    return this.conProductDisplay;
  }

  public void setCovProvLOV(RichTable covProvLOV) {
    this.covProvLOV = covProvLOV;
  }

  public RichTable getCovProvLOV() {
    return this.covProvLOV;
  }

  public void setCalcType(RichSelectOneChoice calcType) {
    this.calcType = calcType;
  }

  public RichSelectOneChoice getCalcType() {
    return this.calcType;
  }

  public void setFreqPay(RichSelectOneChoice freqPay) {
    this.freqPay = freqPay;
  }

  public RichSelectOneChoice getFreqPay() {
    return this.freqPay;
  }

  public void setFclType(RichSelectOneChoice fclType) {
    this.fclType = fclType;
  }

  public RichSelectOneChoice getFclType() {
    return this.fclType;
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

  public void setAvANB(RichInputText avANB) {
    this.avANB = avANB;
  }

  public RichInputText getAvANB() {
    return this.avANB;
  }

  public void setQuotePrem(RichInputText quotePrem) {
    this.quotePrem = quotePrem;
  }

  public RichInputText getQuotePrem() {
    return this.quotePrem;
  }

  public void setNoofMembers(RichInputText noofMembers) {
    this.noofMembers = noofMembers;
  }

  public RichInputText getNoofMembers() {
    return this.noofMembers;
  }

  public void setCoverToDate(RichInputDate coverToDate) {
    this.coverToDate = coverToDate;
  }

  public RichInputDate getCoverToDate() {
    return this.coverToDate;
  }

  public void setAllAgentsLOV(RichTable allAgentsLOV) {
    this.allAgentsLOV = allAgentsLOV;
  }

  public RichTable getAllAgentsLOV() {
    return this.allAgentsLOV;
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

  public void setExceptionsLOV(RichTable exceptionsLOV) {
    this.exceptionsLOV = exceptionsLOV;
  }

  public RichTable getExceptionsLOV() {
    return this.exceptionsLOV;
  }

  public void setOvrFCLAmt(RichInputText ovrFCLAmt) {
    this.ovrFCLAmt = ovrFCLAmt;
  }

  public RichInputText getOvrFCLAmt() {
    return this.ovrFCLAmt;
  }

  public void setQuotPremMaskLOV(RichTable quotPremMaskLOV) {
    this.quotPremMaskLOV = quotPremMaskLOV;
  }

  public RichTable getQuotPremMaskLOV() {
    return this.quotPremMaskLOV;
  }

  public void setMaskDisplay(RichInputText maskDisplay) {
    this.maskDisplay = maskDisplay;
  }

  public RichInputText getMaskDisplay() {
    return this.maskDisplay;
  }

  public void durationTypeListener(ValueChangeEvent valueChangeEvent) {
    Connection conn = null;
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
      GlobalCC.EXCEPTIONREPORTING(conn, e);
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
      ADFUtils.findIterator("findQuotation1Iterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.coverToDate);
      ADFUtils.findIterator("findQuoteCoverTypesIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.coverTypesLOV);
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
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
    }
    return null;
  }

  public String EditAllDepTypesAvailable() {
    Connection conn = null;
    try {
      ADFUtils.findIterator("FindDependantTypesIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.allDepsLOV);

      ExtendedRenderKitService erkService =
        (ExtendedRenderKitService)Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                                     ExtendedRenderKitService.class);

      erkService.addScript(FacesContext.getCurrentInstance(),
                           "var hints = {autodismissNever:false}; AdfPage.PAGE.findComponent('lmsgroup:p4').show(hints);");
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
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

        this.session.setAttribute("dtyCode", r.getAttribute("DTY_CODE"));
        this.dtyDesc.setValue(r.getAttribute("DTY_DESCRIPTION"));

        AdfFacesContext.getCurrentInstance().addPartialTarget(this.dtyDesc);
        GlobalCC.hidePopup("lmsgroup:p4");
        /*System.out.println("enter popup");
        ExtendedRenderKitService erkService = (ExtendedRenderKitService)Service.getService(FacesContext.getCurrentInstance().getRenderKit(), ExtendedRenderKitService.class);

        erkService.addScript(FacesContext.getCurrentInstance(), "var hints = {autodismissNever:false}; AdfPage.PAGE.findComponent('lmsgroup:cvrdtls').show(hints);");*/
      }

    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }

    return null;
  }

  public String DetermineAggreagateFCL() {
    //manual overriding per plan for MICK
    if (String.valueOf(session.getAttribute("overPerPlan")).equalsIgnoreCase("Y")) {
      session.setAttribute("overPerPlan", null);
      int rows = 0;

      while (rows < fcclPlanTab.getRowCount()) {
        String fclQuery =
          "BEGIN LMS_WEB_PKG_GRP.determine_per_plan_fcl(?,?,?);END;";
        Connection conn = null;
        DBConnector myConn = new DBConnector();
        conn = myConn.getDatabaseConn();
        JUCtrlValueBinding r =
          (JUCtrlValueBinding)fcclPlanTab.getRowData(rows);
        if (r == null) {
          GlobalCC.errorValueNotEntered("No Records to Update");
          return null;
        }

        session.setAttribute("fclqcvt_code", r.getAttribute("QCVT_CODEFCL"));
        session.setAttribute("qcvtFcl", r.getAttribute("QCVT_FCL_AMTFCL"));
        session.setAttribute("qcvtOvrdFcl",
                             r.getAttribute("QCVT_OVERRIDE_FCL_AMTFCL"));
        rows++;
        try {

          CallableStatement ctsmt = conn.prepareCall(fclQuery);
          ctsmt.setBigDecimal(1,
                              (BigDecimal)this.session.getAttribute("fclqcvt_code"));
          ctsmt.setString(2, (String)this.session.getAttribute("qcvtFcl"));
          ctsmt.setString(3, (String)this.session.getAttribute("qcvtOvrdFcl"));
          ctsmt.execute();
          conn.commit();
          conn.close();

        } catch (Exception ex) {
          GlobalCC.EXCEPTIONREPORTING(conn, ex);
        }
      }
      fcclPlanTab.setVisible(false);
      AdfFacesContext.getCurrentInstance().addPartialTarget(fcclPlanTab);
      overPlan.setValue("N");
      GlobalCC.INFORMATIONREPORTING("FCL Determined Successfully!");
      ADFUtils.findIterator("findQuoteCoverTypesIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(coverTypesLOV);
      return null;
    } else {
      String fclQuery =
        "BEGIN LMS_WEB_PKG_GRP.determine_agg_fcl(?,?,?,?,?);END;";
      Connection conn = null;
      try {
        DBConnector myConn = new DBConnector();
        conn = myConn.getDatabaseConn();
        CallableStatement ctsmt = conn.prepareCall(fclQuery);

        if (this.fclCalcType.getValue() == null) {
          GlobalCC.INFORMATIONREPORTING("Select an FCL Calculation Type");
          return null;
        }

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

          ctsmt.setBigDecimal(1,
                              (BigDecimal)this.session.getAttribute("qcvtCode"));
          ctsmt.setString(2, this.fclCalcType.getValue().toString());
          ctsmt.setBigDecimal(3,
                              (BigDecimal)this.session.getAttribute("ProductCode"));
          ctsmt.setString(4, "Q");
          if (overrideFCL.getValue() == null) {
            ctsmt.setString(5, null);
          } else {
            ctsmt.setString(5, overrideFCL.getValue().toString());
          }

          ctsmt.execute();
        }

        this.session.setAttribute("qcvtCode", null);
        ADFUtils.findIterator("findQuoteCoverTypesIterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.coverTypesLOV);

        ADFUtils.findIterator("findQuotation1Iterator").executeQuery();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.compFCL);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.ovrFCLAmt);

        GlobalCC.INFORMATIONREPORTING("Free Cover Limit Processing Has Been Completed Successfully");
        ctsmt.close();
        conn.close();
      } catch (Exception ex) {
        GlobalCC.EXCEPTIONREPORTING(conn, ex);
      }
      return null;
    }
  }

  public void setQuotationDurationType(RichSelectOneChoice quotationDurationType) {
    this.quotationDurationType = quotationDurationType;
  }

  public RichSelectOneChoice getQuotationDurationType() {
    return this.quotationDurationType;
  }

  public void setWetDate(RichInputDate wetDate) {
    this.wetDate = wetDate;
  }

  public RichInputDate getWetDate() {
    return this.wetDate;
  }

  public void setAgentsAuth(RichSelectOneChoice agentsAuth) {
    this.agentsAuth = agentsAuth;
  }

  public RichSelectOneChoice getAgentsAuth() {
    return this.agentsAuth;
  }

  public void setAgentAssignTo(RichSelectOneChoice agentAssignTo) {
    this.agentAssignTo = agentAssignTo;
  }

  public RichSelectOneChoice getAgentAssignTo() {
    return this.agentAssignTo;
  }

  public void setAgentsDispl(RichOutputText agentsDispl) {
    this.agentsDispl = agentsDispl;
  }

  public RichOutputText getAgentsDispl() {
    return this.agentsDispl;
  }

  public void setEdAssignTo(RichSelectOneChoice edAssignTo) {
    this.edAssignTo = edAssignTo;
  }

  public RichSelectOneChoice getEdAssignTo() {
    return this.edAssignTo;
  }

  public void setEdAuthorised(RichSelectOneChoice edAuthorised) {
    this.edAuthorised = edAuthorised;
  }

  public RichSelectOneChoice getEdAuthorised() {
    return this.edAuthorised;
  }

  public void setAddAgentsDispl(RichOutputText addAgentsDispl) {
    this.addAgentsDispl = addAgentsDispl;
  }

  public RichOutputText getAddAgentsDispl() {
    return this.addAgentsDispl;
  }

  public void setDtyDesc(RichInputText dtyDesc) {
    this.dtyDesc = dtyDesc;
  }

  public RichInputText getDtyDesc() {
    return this.dtyDesc;
  }

  public void setAvMemberEarnings(RichInputText avMemberEarnings) {
    this.avMemberEarnings = avMemberEarnings;
  }

  public RichInputText getAvMemberEarnings() {
    return this.avMemberEarnings;
  }

  public void setDepTypeLabel(RichOutputLabel depTypeLabel) {
    this.depTypeLabel = depTypeLabel;
  }

  public RichOutputLabel getDepTypeLabel() {
    return this.depTypeLabel;
  }

  public void setAvMemEarnlabel(RichOutputLabel avMemEarnlabel) {
    this.avMemEarnlabel = avMemEarnlabel;
  }

  public RichOutputLabel getAvMemEarnlabel() {
    return this.avMemEarnlabel;
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

  public void setSaLabel(RichOutputLabel saLabel) {
    this.saLabel = saLabel;
  }

  public RichOutputLabel getSaLabel() {
    return this.saLabel;
  }

  public void setAvANBLabel(RichOutputLabel avANBLabel) {
    this.avANBLabel = avANBLabel;
  }

  public RichOutputLabel getAvANBLabel() {
    return this.avANBLabel;
  }

  public void setMaleRtAge(RichInputText maleRtAge) {
    this.maleRtAge = maleRtAge;
  }

  public RichInputText getMaleRtAge() {
    return this.maleRtAge;
  }

  public void setFemaleRtAge(RichInputText femaleRtAge) {
    this.femaleRtAge = femaleRtAge;
  }

  public RichInputText getFemaleRtAge() {
    return this.femaleRtAge;
  }

  public void setCvrCategory(RichInputText cvrCategory) {
    this.cvrCategory = cvrCategory;
  }

  public RichInputText getCvrCategory() {
    return this.cvrCategory;
  }

  public void setCvrCategorylabel(RichOutputLabel cvrCategorylabel) {
    this.cvrCategorylabel = cvrCategorylabel;
  }

  public RichOutputLabel getCvrCategorylabel() {
    return this.cvrCategorylabel;
  }

  public void setCvrMultipleEarningsPeriod(RichInputText cvrMultipleEarningsPeriod) {
    this.cvrMultipleEarningsPeriod = cvrMultipleEarningsPeriod;
  }

  public RichInputText getCvrMultipleEarningsPeriod() {
    return this.cvrMultipleEarningsPeriod;
  }

  public void setMultiEarnsPeriodlbl(RichOutputLabel multiEarnsPeriodlbl) {
    this.multiEarnsPeriodlbl = multiEarnsPeriodlbl;
  }

  public RichOutputLabel getMultiEarnsPeriodlbl() {
    return this.multiEarnsPeriodlbl;
  }

  public void setTotalMem(RichInputText totalMem) {
    this.totalMem = totalMem;
  }

  public RichInputText getTotalMem() {
    return this.totalMem;
  }

  public void setTotalMemLabel(RichOutputLabel totalMemLabel) {
    this.totalMemLabel = totalMemLabel;
  }

  public RichOutputLabel getTotalMemLabel() {
    return this.totalMemLabel;
  }

  public void setDepLimitCategoryLOV(RichTable depLimitCategoryLOV) {
    this.depLimitCategoryLOV = depLimitCategoryLOV;
  }

  public RichTable getDepLimitCategoryLOV() {
    return this.depLimitCategoryLOV;
  }

  public void setUnitRateOption(RichSelectOneChoice unitRateOption) {
    this.unitRateOption = unitRateOption;
  }

  public RichSelectOneChoice getUnitRateOption() {
    return this.unitRateOption;
  }

  public void setEffectiveDate(RichInputDate effectiveDate) {
    this.effectiveDate = effectiveDate;
  }

  public RichInputDate getEffectiveDate() {
    return this.effectiveDate;
  }

  public void setFclCalcType(RichSelectOneChoice fclCalcType) {
    this.fclCalcType = fclCalcType;
  }

  public RichSelectOneChoice getFclCalcType() {
    return this.fclCalcType;
  }

  public void setComputedFCL(RichInputText computedFCL) {
    this.computedFCL = computedFCL;
  }

  public RichInputText getComputedFCL() {
    return this.computedFCL;
  }

  public void setOverrideFCL(RichInputText overrideFCL) {
    this.overrideFCL = overrideFCL;
  }

  public RichInputText getOverrideFCL() {
    return this.overrideFCL;
  }

  public void setDivFactor(RichInputText divFactor) {
    this.divFactor = divFactor;
  }

  public RichInputText getDivFactor() {
    return this.divFactor;
  }

  public void unitRateOptionListener(ValueChangeEvent valueChangeEvent) {
    if ((this.unitRateOption.getValue() != null) &&
        (this.unitRateOption.getValue().toString().equalsIgnoreCase("RATE"))) {
      this.unitRateDisplay.setValue(null);
      this.unitRateDivFactor.setValue(null);
      session.setAttribute("UNIT_RATE_FORMULA", null);
      ExtendedRenderKitService erkService =
        (ExtendedRenderKitService)Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                                                     ExtendedRenderKitService.class);

      erkService.addScript(FacesContext.getCurrentInstance(),
                           "var hints = {autodismissNever:false}; AdfPage.PAGE.findComponent('lmsgroup:unitRatesPopup').show(hints);");
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

  public String SaveUnitRate() {
    Connection conn = null;

    if (this.unitRateDisplay.getValue() == null) {
      String Message = "Please Key In a unit Rate";
      FacesContext.getCurrentInstance().addMessage(null,
                                                   new FacesMessage(FacesMessage.SEVERITY_INFO,
                                                                    Message,
                                                                    Message));

      return null;
    }
    if (this.unitRateDivFactor.getValue() == null) {
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
      cstmt.setString(1, this.unitRateDisplay.getValue().toString());
      cstmt.setBigDecimal(2,
                          (BigDecimal)this.session.getAttribute("QuoteCode"));
      cstmt.setString(3, this.unitRateDivFactor.getValue().toString());
      cstmt.setString(4, "Q");

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

  public void setPaymentMethod(RichSelectOneChoice paymentMethod) {
    this.paymentMethod = paymentMethod;
  }

  public RichSelectOneChoice getPaymentMethod() {
    return this.paymentMethod;
  }

  public void CoverDetailsListener(DisclosureEvent disclosureEvent) {
    try {
      this.session.setAttribute("MemberNumber", null);
      session.setAttribute("covdetails","Y");
      GlobalCC.RedirectPage("/qmemcovers.jspx");
    } catch (Exception ex) {
      GlobalCC.EXCEPTIONREPORTING(null, ex);
    }
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

  public void setClassesLOV(RichTable classesLOV) {
    this.classesLOV = classesLOV;
  }

  public RichTable getClassesLOV() {
    return this.classesLOV;
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

  public void setCategoryTree(RichTree categoryTree) {
    this.categoryTree = categoryTree;
  }

  public RichTree getCategoryTree() {
    return this.categoryTree;
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
          this.dependentCategory.setValue(nd.getRow().getAttribute("catDesc"));

          ADFUtils.findIterator("findQuoteDependantLimitsIterator").executeQuery();
          AdfFacesContext.getCurrentInstance().addPartialTarget(this.quotationDependentsLOV);
        }
    }
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

  public void setMaskButton(RichCommandButton maskButton) {
    this.maskButton = maskButton;
  }

  public RichCommandButton getMaskButton() {
    return this.maskButton;
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

      this.session.setAttribute("coverMaskCode", r.getAttribute("PMAS_CODE"));
      this.maskDesc.setValue(r.getAttribute("PMAS_SHT_DESC"));

      AdfFacesContext.getCurrentInstance().addPartialTarget(this.maskDesc);
      GlobalCC.hidePopup("lmsgroup:p8");
    }
    return null;
  }

  public void setCatMaskDesc(RichInputText catMaskDesc) {
    this.catMaskDesc = catMaskDesc;
  }

  public RichInputText getCatMaskDesc() {
    return this.catMaskDesc;
  }

  public void setMaskTable(RichTable maskTable) {
    this.maskTable = maskTable;
  }

  public RichTable getMaskTable() {
    return this.maskTable;
  }

  public void setCatMaskTable(RichTable catMaskTable) {
    this.catMaskTable = catMaskTable;
  }

  public RichTable getCatMaskTable() {
    return this.catMaskTable;
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

      AdfFacesContext.getCurrentInstance().addPartialTarget(this.catMaskDesc);
      GlobalCC.hidePopup("lmsgroup:popup1");
    }

    return null;
  }

  public void ReportsCategoryListener(ValueChangeEvent valueChangeEvent) {
    if (valueChangeEvent.getOldValue() != valueChangeEvent.getNewValue()) {
      if (this.categoryRadio.getValue() == null) {
        this.categoryDrop.setDisabled(true);
        this.session.setAttribute("rptLCACode", null);
      } else {
        String Value = this.categoryRadio.getValue().toString();
        if (Value.equalsIgnoreCase("A")) {
          this.categoryDrop.setDisabled(true);
          this.session.setAttribute("rptLCACode", null);
        } else {
          this.categoryDrop.setDisabled(false);
          this.session.setAttribute("rptLCACode", null);
        }
      }
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.categoryDrop);
    }
  }

  public void avMemEarningsListener(ValueChangeEvent valueChangeEvent) {
    String avg_mem_earning = null;
    Connection conn = null;
    //System.out.println("Tot Earn="+this.totalMemEarning.getValue()+" tot mem="+totalMem.getValue());
    if ((this.totalMemEarning.getValue() != null) &&
        (this.totalMem.getValue() != null)) {
      try {
        conn = new DBConnector().getDatabaseConn();
        String query =
          "begin ? := LMS_WEB_PKG_GRP_UW.avg_mem_earnings(?,?); end;";

        CallableStatement cstmt = conn.prepareCall(query);

        cstmt.registerOutParameter(1, OracleTypes.DOUBLE);

        cstmt.setString(2, this.totalMemEarning.getValue().toString());
        if (this.totalMem.getValue() == null) {
          cstmt.setString(3, null);
        } else {
          cstmt.setString(3, this.totalMem.getValue().toString());
        }
        cstmt.execute();

        double Result = cstmt.getDouble(1);
        this.avMemberEarnings.setValue(Result);
        // System.out.println("Average Earn "+Result);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.avMemberEarnings);
        conn.close();
      } catch (Exception e) {
        GlobalCC.EXCEPTIONREPORTING(conn, e);
        e.printStackTrace();
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
        if (this.totalMem.getValue() == null) {
          cstmt.setString(3, null);
        } else {
          cstmt.setString(3, this.totalMem.getValue().toString());
        }
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

  public void setCategoryDrop(RichSelectOneChoice categoryDrop) {
    this.categoryDrop = categoryDrop;
  }

  public RichSelectOneChoice getCategoryDrop() {
    return this.categoryDrop;
  }

  public void setCategoryRadio(RichSelectOneRadio categoryRadio) {
    this.categoryRadio = categoryRadio;
  }

  public RichSelectOneRadio getCategoryRadio() {
    return this.categoryRadio;
  }

  public void setTxtWefDate(RichInputDate txtWefDate) {
    this.txtWefDate = txtWefDate;
  }

  public RichInputDate getTxtWefDate() {
    return this.txtWefDate;
  }

  public void setTxtWetDate(RichInputDate txtWetDate) {
    this.txtWetDate = txtWetDate;
  }

  public RichInputDate getTxtWetDate() {
    return this.txtWetDate;
  }

  public String viewClaimExperience() {
    if (this.txtWefDate.getValue() == null)
      this.session.setAttribute("wef", null);
    else {
      this.session.setAttribute("wef",
                                GlobalCC.parseDate(this.txtWefDate.getValue().toString()));
    }

    if (this.txtWetDate.getValue() == null)
      this.session.setAttribute("wet", null);
    else {
      this.session.setAttribute("wet",
                                GlobalCC.parseDate(this.txtWetDate.getValue().toString()));
    }

    ADFUtils.findIterator("findClientClaimExpIterator").executeQuery();
    AdfFacesContext.getCurrentInstance().addPartialTarget(this.claimExpLOV);

    return null;
  }

  public void setClaimExpLOV(RichTable claimExpLOV) {
    this.claimExpLOV = claimExpLOV;
  }

  public RichTable getClaimExpLOV() {
    return this.claimExpLOV;
  }

  public void setDpdMinAmount(RichInputText dpdMinAmount) {
    this.dpdMinAmount = dpdMinAmount;
  }

  public RichInputText getDpdMinAmount() {
    return this.dpdMinAmount;
  }

  public void setPrdTypeLabel2(RichOutputLabel prdTypeLabel2) {
    this.prdTypeLabel2 = prdTypeLabel2;
  }

  public RichOutputLabel getPrdTypeLabel2() {
    return this.prdTypeLabel2;
  }

  public void setTotalMemEarning(RichInputText totalMemEarning) {
    this.totalMemEarning = totalMemEarning;
  }

  public RichInputText getTotalMemEarning() {
    return this.totalMemEarning;
  }

  public void setTotalMemEarninglbl(RichOutputLabel totalMemEarninglbl) {
    this.totalMemEarninglbl = totalMemEarninglbl;
  }

  public RichOutputLabel getTotalMemEarninglbl() {
    return this.totalMemEarninglbl;
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

  public void setTotLoanAmt(RichInputText totLoanAmt) {
    this.totLoanAmt = totLoanAmt;
  }

  public RichInputText getTotLoanAmt() {
    return this.totLoanAmt;
  }

  public void setTotLoanAmtLabel(RichOutputLabel totLoanAmtLabel) {
    this.totLoanAmtLabel = totLoanAmtLabel;
  }

  public RichOutputLabel getTotLoanAmtLabel() {
    return this.totLoanAmtLabel;
  }

  public void setMultiprdPanel(HtmlPanelGrid multiprdPanel) {
    this.multiprdPanel = multiprdPanel;
  }

  public HtmlPanelGrid getMultiprdPanel() {
    return this.multiprdPanel;
  }

  public void setEdtAgnShareLab(RichOutputLabel edtAgnShareLab) {
    this.edtAgnShareLab = edtAgnShareLab;
  }

  public RichOutputLabel getEdtAgnShareLab() {
    return this.edtAgnShareLab;
  }

  public void setEdtAgnShareTF(RichInputText edtAgnShareTF) {
    this.edtAgnShareTF = edtAgnShareTF;
  }

  public RichInputText getEdtAgnShareTF() {
    return this.edtAgnShareTF;
  }

  public void setAddAgnShareLab(RichOutputLabel addAgnShareLab) {
    this.addAgnShareLab = addAgnShareLab;
  }

  public RichOutputLabel getAddAgnShareLab() {
    return this.addAgnShareLab;
  }

  public void setAddAgnShareTF(RichInputText addAgnShareTF) {
    this.addAgnShareTF = addAgnShareTF;
  }

  public RichInputText getAddAgnShareTF() {
    return this.addAgnShareTF;
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


  public void setAttachAgentsDtls(RichCommandButton attachAgentsDtls) {
    this.attachAgentsDtls = attachAgentsDtls;
  }

  public RichCommandButton getAttachAgentsDtls() {
    return this.attachAgentsDtls;
  }

  public void setGetLeader_follower(RichSelectOneChoice getLeader_follower) {
    this.getLeader_follower = getLeader_follower;
  }

  public RichSelectOneChoice getGetLeader_follower() {
    return this.getLeader_follower;
  }

  public void setLeader_followerLab(RichOutputLabel leader_followerLab) {
    this.leader_followerLab = leader_followerLab;
  }

  public RichOutputLabel getLeader_followerLab() {
    return this.leader_followerLab;
  }

  public void setEdtleader_followerLab(RichOutputLabel edtleader_followerLab) {
    this.edtleader_followerLab = edtleader_followerLab;
  }

  public RichOutputLabel getEdtleader_followerLab() {
    return this.edtleader_followerLab;
  }

  public void setEditLeader_followerCmb(RichSelectOneChoice editLeader_followerCmb) {
    this.editLeader_followerCmb = editLeader_followerCmb;
  }

  public RichSelectOneChoice getEditLeader_followerCmb() {
    return this.editLeader_followerCmb;
  }

  public void setAgnShareCol(RichColumn agnShareCol) {
    this.agnShareCol = agnShareCol;
  }

  public RichColumn getAgnShareCol() {
    return this.agnShareCol;
  }

  public void setAgnLdrFolCol(RichColumn agnLdrFolCol) {
    this.agnLdrFolCol = agnLdrFolCol;
  }

  public RichColumn getAgnLdrFolCol() {
    return this.agnLdrFolCol;
  }

  public void setAgeLoadFactorLab(RichOutputLabel ageLoadFactorLab) {
    this.ageLoadFactorLab = ageLoadFactorLab;
  }

  public RichOutputLabel getAgeLoadFactorLab() {
    return ageLoadFactorLab;
  }

  public void setAgeLoadFactor(RichInputText ageLoadFactor) {
    this.ageLoadFactor = ageLoadFactor;
  }

  public RichInputText getAgeLoadFactor() {
    return ageLoadFactor;
  }

  public void discLoadChoiceListener(ValueChangeEvent valueChangeEvent) {
    // Add event code here...
    if (valueChangeEvent.getNewValue() != valueChangeEvent.getOldValue()) {
      if (discLoadChoice.getValue() != null) {
        if (discLoadChoice.getValue().toString().equalsIgnoreCase("A")) {
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

        }else if(discLoadChoice.getValue().toString().equalsIgnoreCase("N")){
        
          divFactor.setValue("");
          System.out.println("discLoadChoice===="+discLoadChoice.getValue().toString());
          AdfFacesContext.getCurrentInstance().addPartialTarget(this.divFactor);
        }
        
        else {
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

  public void setCoversPanel(RichPanelBox coversPanel) {
    this.coversPanel = coversPanel;
  }

  public RichPanelBox getCoversPanel() {
    return coversPanel;
  }

  public void setPremLoadingsLOV(RichTable premLoadingsLOV) {
    this.premLoadingsLOV = premLoadingsLOV;
  }

  public RichTable getPremLoadingsLOV() {
    return premLoadingsLOV;
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

  public String updateQuoPremLoadings() {
    // Add event code here...
    DCIteratorBinding dciter =
      ADFUtils.findIterator("FindQuoPremRateLoadingsIterator");
    RowKeySet set = premLoadingsLOV.getSelectedRowKeys();
    Iterator rowKeySetIter = set.iterator();

    while (rowKeySetIter.hasNext()) {
      List l = (List)rowKeySetIter.next();
      Key key = (Key)l.get(0);
      dciter.setCurrentRowWithKey(key.toStringFormat(true));
      Row r = dciter.getCurrentRow();
      session.setAttribute("qoctl_code", r.getAttribute("qoctl_code"));
      loadNameTF.setValue(r.getAttribute("qoctl_name"));
      loadRateTF.setValue(r.getAttribute("qoctl_rate"));
      loadRateDivFact.setValue(r.getAttribute("qoctl_rate_div_factor"));
    }
    GlobalCC.showPopup("lmsgroup:polPremLoadings");

    return null;
  }

  public String savePremLoadings() {
    // Add event code here...
    BigDecimal poctlCode = (BigDecimal)session.getAttribute("qoctl_code");
    Connection conn = null;

    try {
      DBConnector MyDB = new DBConnector();
      conn = MyDB.getDatabaseConn();
      CallableStatement cst =
        conn.prepareCall("BEGIN lms_web_pkg_grp.updateQuoPremRateLoadings(?,?,?);END;");
      cst.setBigDecimal(1, poctlCode);
      cst.setString(2, (String)loadRateTF.getValue());
      cst.setString(3, (String)loadRateDivFact.getValue());
      cst.execute();
      cst.close();
      conn.close();

      ADFUtils.findIterator("FindQuoPremRateLoadingsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.premLoadingsLOV);

    } catch (Exception Ex) {
      GlobalCC.EXCEPTIONREPORTING(conn, Ex);
      Ex.printStackTrace();

    }
    return null;
  }

  public void setGroupSingleRate(RichColumn groupSingleRate) {
    this.groupSingleRate = groupSingleRate;
  }

  public RichColumn getGroupSingleRate() {
    return groupSingleRate;
  }

  public void setGrpSingleRateComboo(RichSelectOneChoice grpSingleRateComboo) {
    this.grpSingleRateComboo = grpSingleRateComboo;
  }

  public RichSelectOneChoice getGrpSingleRateComboo() {
    return grpSingleRateComboo;
  }

  public String occupationSelected() {
    // Add event code here...
    try {
      DCIteratorBinding dciter =
        ADFUtils.findIterator("findOccupationCategoryIterator");
      RowKeySet set = this.catClassLOV.getSelectedRowKeys();
      Iterator rowKeySetIter = set.iterator();

      while (rowKeySetIter.hasNext()) {
        List l = (List)rowKeySetIter.next();
        Key key = (Key)l.get(0);
        dciter.setCurrentRowWithKey(key.toStringFormat(true));
        Row r = dciter.getCurrentRow();
        this.categIDDisplay.setValue(r.getAttribute("gocCategory"));
        this.categDescDisplay.setValue(r.getAttribute("gocCategory"));
        this.categPeriodDisplay.setValue(r.getAttribute("gocClass"));

        AdfFacesContext.getCurrentInstance().addPartialTarget(this.categIDDisplay);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.categDescDisplay);
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.categPeriodDisplay);
      }
      GlobalCC.hidePopup("lmsgroup:p10");
      //GlobalCC.showPopup("lmsgroup:addCategory");
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
    return null;
  }

  public void setCatClassLOV(RichTable catClassLOV) {
    this.catClassLOV = catClassLOV;
  }

  public RichTable getCatClassLOV() {
    return catClassLOV;
  }

  public void populateDependentTypes(BigDecimal pctCode, BigDecimal cvtCode) {
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

      String query = "begin LMS_WEB_PKG_GRP.getDefaultMask(?,?,?,?,?); end;";

      CallableStatement cstmt = conn.prepareCall(query);
      cstmt.setBigDecimal(1, cvtCode);
      cstmt.setBigDecimal(2, pctCode);
      cstmt.registerOutParameter(3, OracleTypes.NUMBER);
      cstmt.registerOutParameter(4, OracleTypes.VARCHAR);
      cstmt.registerOutParameter(5, OracleTypes.VARCHAR);
      cstmt.execute();

      if (cstmt.getBigDecimal(3) != null) {
        this.session.setAttribute("pmasCode", cstmt.getBigDecimal(3));
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


  public RichInputText getCompFCL1() {
    return compFCL;
  }

  public RichInputText getCoverSADisplay1() {
    return coverSADisplay;
  }

  public RichInputText getCoverButChargePremium1() {
    return coverButChargePremium;
  }

  public RichSelectOneChoice getDiscLoadChoice1() {
    return discLoadChoice;
  }

  public RichInputText getDiscLoadRateDisplay1() {
    return discLoadRateDisplay;
  }

  public RichTable getProdCoversLOV1() {
    return prodCoversLOV;
  }

  public RichTable getCoverTypesLOV1() {
    return coverTypesLOV;
  }

  public RichOutputText getCoverLabel1() {
    return coverLabel;
  }

  public RichInputText getEdcoverButChargePremium1() {
    return edcoverButChargePremium;
  }

  public RichSelectOneChoice getEddiscLoadChoice1() {
    return eddiscLoadChoice;
  }

  public RichInputText getEddiscLoadRateDisplay1() {
    return eddiscLoadRateDisplay;
  }

  public RichOutputText getEdCoverlabel1() {
    return edCoverlabel;
  }

  public RichTable getAllTaxesLOV1() {
    return allTaxesLOV;
  }

  public RichOutputText getTaxSel1() {
    return taxSel;
  }

  public RichSelectOneChoice getApplLevel1() {
    return applLevel;
  }

  public RichInputText getTaxRate1() {
    return taxRate;
  }

  public RichInputText getTaxAmt1() {
    return taxAmt;
  }

  public RichTable getQuotationTaxes1() {
    return quotationTaxes;
  }

  public RichInputText getCategIDDisplay1() {
    return categIDDisplay;
  }

  public RichInputText getCategDescDisplay1() {
    return categDescDisplay;
  }

  public RichInputText getCategPeriodDisplay1() {
    return categPeriodDisplay;
  }

  public RichTable getCategoryLOV1() {
    return categoryLOV;
  }

  public static void setEdit(int Edit) {
    viewQuotations.Edit = Edit;
  }

  public static int getEdit() {
    return Edit;
  }

  public RichTable getProductProvisionsLOV1() {
    return productProvisionsLOV;
  }

  public RichSelectBooleanCheckbox getProvisionsCbox1() {
    return provisionsCbox;
  }

  public RichTable getCoverTypeProvisions1() {
    return coverTypeProvisions;
  }

  public RichTable getDependentTypesLOV1() {
    return dependentTypesLOV;
  }

  public RichTable getDependentCoverTypes1() {
    return dependentCoverTypes;
  }

  public RichInputText getDependentCategory1() {
    return dependentCategory;
  }

  public RichInputText getDependentType1() {
    return dependentType;
  }

  public RichInputText getDpdLimitAmount1() {
    return dpdLimitAmount;
  }

  public RichInputText getMaxType1() {
    return maxType;
  }

  public RichInputText getDpdMonthlyIncome1() {
    return dpdMonthlyIncome;
  }

  public RichTable getQuotationDependentsLOV1() {
    return quotationDependentsLOV;
  }

  public RichOutputText getCoverDescLabel1() {
    return coverDescLabel;
  }

  public RichOutputText getDepTypesLabel1() {
    return depTypesLabel;
  }

  public RichInputText getEdLimitAmt1() {
    return edLimitAmt;
  }

  public RichInputText getEdMaxNo1() {
    return edMaxNo;
  }

  public RichTable getQuotMembersLOV1() {
    return quotMembersLOV;
  }

  public RichOutputText getOldANBDisp1() {
    return oldANBDisp;
  }

  public RichInputText getNewANBDisplay1() {
    return newANBDisplay;
  }

  public RichInputText getSumAssuredDisplay1() {
    return sumAssuredDisplay;
  }

  public RichTable getAgentsLOV1() {
    return agentsLOV;
  }

  public RichInputText getConProductDisplay1() {
    return conProductDisplay;
  }

  public RichTable getCovProvLOV1() {
    return covProvLOV;
  }

  public RichSelectOneChoice getCalcType1() {
    return calcType;
  }

  public RichSelectOneChoice getFreqPay1() {
    return freqPay;
  }

  public RichSelectOneChoice getFclType1() {
    return fclType;
  }

  public RichOutputText getEdtaxSel1() {
    return edtaxSel;
  }

  public RichSelectOneChoice getEdapplLevel1() {
    return edapplLevel;
  }

  public RichInputText getEdtaxRate1() {
    return edtaxRate;
  }

  public RichInputText getEdtaxAmt1() {
    return edtaxAmt;
  }

  public RichInputText getAvANB1() {
    return avANB;
  }

  public RichInputText getQuotePrem1() {
    return quotePrem;
  }

  public RichInputText getNoofMembers1() {
    return noofMembers;
  }

  public RichInputDate getCoverToDate1() {
    return coverToDate;
  }

  public RichTable getAllAgentsLOV1() {
    return allAgentsLOV;
  }

  public RichTable getUsersLOV1() {
    return usersLOV;
  }

  public RichInputText getTicketRemarks1() {
    return ticketRemarks;
  }

  public RichTable getExceptionsLOV1() {
    return exceptionsLOV;
  }

  public RichInputText getOvrFCLAmt1() {
    return ovrFCLAmt;
  }

  public RichTable getQuotPremMaskLOV1() {
    return quotPremMaskLOV;
  }

  public RichInputText getMaskDisplay1() {
    return maskDisplay;
  }

  public RichSelectOneChoice getQuotationDurationType1() {
    return quotationDurationType;
  }

  public RichInputDate getWetDate1() {
    return wetDate;
  }

  public RichSelectOneChoice getAgentsAuth1() {
    return agentsAuth;
  }

  public RichSelectOneChoice getAgentAssignTo1() {
    return agentAssignTo;
  }

  public RichOutputText getAgentsDispl1() {
    return agentsDispl;
  }

  public RichSelectOneChoice getEdAssignTo1() {
    return edAssignTo;
  }

  public RichSelectOneChoice getEdAuthorised1() {
    return edAuthorised;
  }

  public RichOutputText getAddAgentsDispl1() {
    return addAgentsDispl;
  }

  public RichInputText getDtyDesc1() {
    return dtyDesc;
  }

  public RichInputText getAvMemberEarnings1() {
    return avMemberEarnings;
  }

  public RichOutputLabel getDepTypeLabel1() {
    return depTypeLabel;
  }

  public RichOutputLabel getAvMemEarnlabel1() {
    return avMemEarnlabel;
  }

  public HtmlPanelGrid getDepTypeDtls1() {
    return depTypeDtls;
  }

  public RichTable getAllDepsLOV1() {
    return allDepsLOV;
  }

  public RichOutputLabel getSaLabel1() {
    return saLabel;
  }

  public RichOutputLabel getAvANBLabel1() {
    return avANBLabel;
  }

  public RichInputText getMaleRtAge1() {
    return maleRtAge;
  }

  public RichInputText getFemaleRtAge1() {
    return femaleRtAge;
  }

  public RichInputText getCvrCategory1() {
    return cvrCategory;
  }

  public RichOutputLabel getCvrCategorylabel1() {
    return cvrCategorylabel;
  }

  public RichInputText getCvrMultipleEarningsPeriod1() {
    return cvrMultipleEarningsPeriod;
  }

  public RichOutputLabel getMultiEarnsPeriodlbl1() {
    return multiEarnsPeriodlbl;
  }

  public RichInputText getTotalMem1() {
    return totalMem;
  }

  public RichOutputLabel getTotalMemLabel1() {
    return totalMemLabel;
  }

  public RichTable getDepLimitCategoryLOV1() {
    return depLimitCategoryLOV;
  }

  public RichSelectOneChoice getUnitRateOption1() {
    return unitRateOption;
  }

  public RichInputDate getEffectiveDate1() {
    return effectiveDate;
  }

  public RichSelectOneChoice getFclCalcType1() {
    return fclCalcType;
  }

  public RichInputText getComputedFCL1() {
    return computedFCL;
  }

  public RichInputText getOverrideFCL1() {
    return overrideFCL;
  }

  public RichInputText getDivFactor1() {
    return divFactor;
  }

  public RichInputText getUnitRateDisplay1() {
    return unitRateDisplay;
  }

  public RichSelectOneChoice getUnitRateDivFactor1() {
    return unitRateDivFactor;
  }

  public RichSelectOneChoice getPaymentMethod1() {
    return paymentMethod;
  }

  public RichOutputLabel getMainCoverLabel1() {
    return mainCoverLabel;
  }

  public RichSelectOneChoice getMainCover1() {
    return mainCover;
  }

  public RichOutputLabel getPercMainCvtLabel1() {
    return percMainCvtLabel;
  }

  public RichInputText getPercMainCvt1() {
    return percMainCvt;
  }

  public RichOutputLabel getLoanAmtLabel1() {
    return loanAmtLabel;
  }

  public RichInputText getCvrLoanAmt1() {
    return cvrLoanAmt;
  }

  public RichOutputLabel getLoanRepyLabel1() {
    return loanRepyLabel;
  }

  public RichInputText getCvrLoanPrd1() {
    return cvrLoanPrd;
  }

  public RichOutputLabel getLoanIntLabel1() {
    return loanIntLabel;
  }

  public RichInputText getCvrLoanInt1() {
    return cvrLoanInt;
  }

  public RichOutputLabel getSavingsAmtLabel1() {
    return savingsAmtLabel;
  }

  public RichInputText getCvrSavingsAmt1() {
    return cvrSavingsAmt;
  }

  public RichInputText getCategoryFees1() {
    return categoryFees;
  }

  public RichInputText getCategoryStudents1() {
    return categoryStudents;
  }

  public RichTable getClassesLOV1() {
    return classesLOV;
  }

  public RichInputText getDiscDivFactor1() {
    return discDivFactor;
  }

  public RichInputText getDiscRateDisplay1() {
    return discRateDisplay;
  }

  public RichSelectOneChoice getDiscChoice1() {
    return discChoice;
  }

  public RichTree getCategoryTree1() {
    return categoryTree;
  }

  public RichSelectOneChoice getRateSelection1() {
    return rateSelection;
  }

  public RichInputText getMaskDesc1() {
    return maskDesc;
  }

  public RichCommandButton getMaskButton1() {
    return maskButton;
  }

  public RichInputNumberSpinbox getCoverRate1() {
    return coverRate;
  }

  public RichInputNumberSpinbox getCoverRateDivFactor1() {
    return coverRateDivFactor;
  }

  public RichInputText getCatMaskDesc1() {
    return catMaskDesc;
  }

  public RichTable getMaskTable1() {
    return maskTable;
  }

  public RichTable getCatMaskTable1() {
    return catMaskTable;
  }

  public RichSelectOneChoice getCategoryDrop1() {
    return categoryDrop;
  }

  public RichSelectOneRadio getCategoryRadio1() {
    return categoryRadio;
  }

  public RichInputDate getTxtWefDate1() {
    return txtWefDate;
  }

  public RichInputDate getTxtWetDate1() {
    return txtWetDate;
  }

  public RichTable getClaimExpLOV1() {
    return claimExpLOV;
  }

  public RichInputText getDpdMinAmount1() {
    return dpdMinAmount;
  }

  public RichOutputLabel getPrdTypeLabel21() {
    return prdTypeLabel2;
  }

  public RichInputText getTotalMemEarning1() {
    return totalMemEarning;
  }

  public RichOutputLabel getTotalMemEarninglbl1() {
    return totalMemEarninglbl;
  }

  public RichOutputLabel getAvCoverPerMemLabel1() {
    return avCoverPerMemLabel;
  }

  public RichInputText getAvCoverPerMem1() {
    return avCoverPerMem;
  }

  public RichInputText getTotLoanAmt1() {
    return totLoanAmt;
  }

  public RichOutputLabel getTotLoanAmtLabel1() {
    return totLoanAmtLabel;
  }

  public HtmlPanelGrid getMultiprdPanel1() {
    return multiprdPanel;
  }

  public RichOutputLabel getEdtAgnShareLab1() {
    return edtAgnShareLab;
  }

  public RichInputText getEdtAgnShareTF1() {
    return edtAgnShareTF;
  }

  public RichOutputLabel getAddAgnShareLab1() {
    return addAgnShareLab;
  }

  public RichInputText getAddAgnShareTF1() {
    return addAgnShareTF;
  }

  public RichOutputLabel getTotMemEarningLab1() {
    return totMemEarningLab;
  }

  public RichInputText getTotMemEarnings1() {
    return totMemEarnings;
  }

  public RichCommandButton getAttachAgentsDtls1() {
    return attachAgentsDtls;
  }

  public RichSelectOneChoice getGetLeader_follower1() {
    return getLeader_follower;
  }

  public RichOutputLabel getLeader_followerLab1() {
    return leader_followerLab;
  }

  public RichOutputLabel getEdtleader_followerLab1() {
    return edtleader_followerLab;
  }

  public RichSelectOneChoice getEditLeader_followerCmb1() {
    return editLeader_followerCmb;
  }

  public RichColumn getAgnShareCol1() {
    return agnShareCol;
  }

  public RichColumn getAgnLdrFolCol1() {
    return agnLdrFolCol;
  }

  public void setSession(HttpSession session) {
    this.session = session;
  }

  public HttpSession getSession() {
    return session;
  }

  public void setDiscountCvrTypeSel(RichSelectOneChoice discountCvrTypeSel) {
    this.discountCvrTypeSel = discountCvrTypeSel;
  }

  public RichSelectOneChoice getDiscountCvrTypeSel() {
    return discountCvrTypeSel;
  }

  public void setDiscountTypesSel(RichSelectOneChoice discountTypesSel) {
    this.discountTypesSel = discountTypesSel;
  }

  public RichSelectOneChoice getDiscountTypesSel() {
    return discountTypesSel;
  }

  public void setDiscountRate(RichInputText discountRate) {
    this.discountRate = discountRate;
  }

  public RichInputText getDiscountRate() {
    return discountRate;
  }

  public void setDiscountReasons(RichInputText discountReasons) {
    this.discountReasons = discountReasons;
  }

  public RichInputText getDiscountReasons() {
    return discountReasons;
  }

  public void setDiscountApplyLevel(RichSelectOneChoice discountApplyLevel) {
    this.discountApplyLevel = discountApplyLevel;
  }

  public RichSelectOneChoice getDiscountApplyLevel() {
    return discountApplyLevel;
  }

  public String showRemarksPopup() {
    // Add event code here...
    session.setAttribute("qrmCode", null);
    remarks.setValue(null);
    GlobalCC.showPopup("lmsgroup:p11");

    return null;
  }

  public void setRemarksType(RichSelectOneChoice remarksType) {
    this.remarksType = remarksType;
  }

  public RichSelectOneChoice getRemarksType() {
    return remarksType;
  }

  public void setRemarks(RichInputText remarks) {
    this.remarks = remarks;
  }

  public RichInputText getRemarks() {
    return remarks;
  }

  public String addEditRemarks() {
    // Add event code here...

    String saveQuery =
      "BEGIN LMS_WEB_PKG_GRP.addEditQuotRemarks(?,?,?,?);END;";
    Connection conn = new DBConnector().getDatabaseConn();
    if (remarks.getValue() == null) {
      GlobalCC.INFORMATIONREPORTING("Please add remarks....");
      return null;
    }
    try {
      CallableStatement cstmt = conn.prepareCall(saveQuery);
      cstmt.setBigDecimal(1, (BigDecimal)this.session.getAttribute("qrmCode"));
      cstmt.setString(2, remarksType.getValue().toString());
      cstmt.setString(3, remarks.getValue().toString());
      cstmt.setBigDecimal(4,
                          (BigDecimal)this.session.getAttribute("QuoteCode"));
      cstmt.execute();
      conn.close();
      ADFUtils.findIterator("findQuoteRemarksIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.quotationRemarksLOV);
      GlobalCC.INFORMATIONREPORTING("Remarks successfully saved");
      GlobalCC.hidePopup("lmsgroup:p11");
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    }
    return null;
  }

  public String editRemarks() {
    // Add event code here...
    Object key2 = quotationRemarksLOV.getSelectedRowData();
    if (key2 == null) {
      GlobalCC.errorValueNotEntered("No Record Selected");
      return null;
    }
    JUCtrlValueBinding r = (JUCtrlValueBinding)key2;
    if (r == null) {
      GlobalCC.errorValueNotEntered("No Record Selected");
      return null;
    }
    session.setAttribute("qrmCode", r.getAttribute("qrmCode"));
    remarks.setValue(r.getAttribute("qrmRemarks"));
    GlobalCC.showPopup("lmsgroup:p11");
    return null;
  }

  public void setQuotationRemarksLOV(RichTable quotationRemarksLOV) {
    this.quotationRemarksLOV = quotationRemarksLOV;
  }

  public RichTable getQuotationRemarksLOV() {
    return quotationRemarksLOV;
  }

  public String deleteQuotRemarks() {
    // Add event code here...
    Connection conn = null;

    String addQuery = "BEGIN LMS_WEB_PKG_GRP.deleteQuoRemarks(?);END;";
    Object key2 = quotationRemarksLOV.getSelectedRowData();
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
      cstmt.setBigDecimal(1, (BigDecimal)r.getAttribute("qrmCode"));
      cstmt.execute();
      conn.close();
      ADFUtils.findIterator("findQuoteRemarksIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(this.quotationRemarksLOV);
      GlobalCC.INFORMATIONREPORTING("Quotation Remarks Plan deleted Successfully");

    } catch (Exception ex) {
      GlobalCC.EXCEPTIONREPORTING(conn, ex);
    }
    return null;
  }

  public String showDependentPopup() {
    // Add event code here...
    this.session.setAttribute("qdlCode", null);
    GlobalCC.showPopup("lmsgroup:getCovers");
    return null;
  }

  public void setAggCategoryPanel(HtmlPanelGrid aggCategoryPanel) {
    this.aggCategoryPanel = aggCategoryPanel;
  }

  public HtmlPanelGrid getAggCategoryPanel() {
    return aggCategoryPanel;
  }

  public void setAggregateCatLOV(RichTable aggregateCatLOV) {
    this.aggregateCatLOV = aggregateCatLOV;
  }

  public RichTable getAggregateCatLOV() {
    return aggregateCatLOV;
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

  public void setProvID(RichOutputText provID) {
    this.provID = provID;
  }

  public RichOutputText getProvID() {
    return provID;
  }

  public void setProvDesc(RichInputText provDesc) {
    this.provDesc = provDesc;
  }

  public RichInputText getProvDesc() {
    return provDesc;
  }

  public void setAvgLabAggregate(RichOutputLabel avgLabAggregate) {
    this.avgLabAggregate = avgLabAggregate;
  }

  public RichOutputLabel getAvgLabAggregate() {
    return avgLabAggregate;
  }

  public void setLimInput(RichInputText limInput) {
    this.limInput = limInput;
  }

  public RichInputText getLimInput() {
    return limInput;
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
    // Add event code here..
    String avg_mem_loan = null;
    Connection conn = null;
    //System.out.println("total Loan="+totLoanAmt.getValue()+" total Mem"+totalMem.getValue()+" override prem="+coverButChargePremium.getValue());

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
        cstmt.setString(3, this.totalMem.getValue().toString());
        cstmt.execute();

        Double Result = cstmt.getDouble(1);
        System.out.println("Result" + Result);
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
    System.out.println("Cover Loan=" + cvrLoanAmt.getValue() + " total Mem=" +
                       totalMem.getValue());
    if ((this.cvrLoanAmt.getValue() != null) &&
        (this.totalMem.getValue() != null)) {
      try {
        conn = new DBConnector().getDatabaseConn();
        avg_mem_loan = this.cvrLoanAmt.getValue().toString();

        String query =
          "begin ? := LMS_WEB_PKG_GRP_UW.tot_mem_earnings(?,?); end;";

        CallableStatement cstmt = conn.prepareCall(query);

        cstmt.registerOutParameter(1, OracleTypes.DOUBLE);

        cstmt.setString(2, avg_mem_loan);
        cstmt.setString(3, this.totalMem.getValue().toString());
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

  public void setEarnPrd(RichSelectOneChoice earnPrd) {
    this.earnPrd = earnPrd;
  }

  public RichSelectOneChoice getEarnPrd() {
    return earnPrd;
  }

  public void setTotPremPaid(RichInputText totPremPaid) {
    this.totPremPaid = totPremPaid;
  }

  public RichInputText getTotPremPaid() {
    return totPremPaid;
  }

  public void setTotClaimPaid(RichInputText totClaimPaid) {
    this.totClaimPaid = totClaimPaid;
  }

  public RichInputText getTotClaimPaid() {
    return totClaimPaid;
  }

  public void setClmExpRate(RichInputText clmExpRate) {
    this.clmExpRate = clmExpRate;
  }

  public RichInputText getClmExpRate() {
    return clmExpRate;
  }

  public void setTenderPeriodTF(RichInputText tenderPeriodTF) {
    this.tenderPeriodTF = tenderPeriodTF;
  }

  public RichInputText getTenderPeriodTF() {
    return tenderPeriodTF;
  }

  public void setMemberNo(RichInputText memberNo) {
    this.memberNo = memberNo;
  }

  public RichInputText getMemberNo() {
    return memberNo;
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

  public void setMemSex(RichSelectOneChoice memSex) {
    this.memSex = memSex;
  }

  public RichSelectOneChoice getMemSex() {
    return memSex;
  }

  public void setMemDob(RichInputDate memDob) {
    this.memDob = memDob;
  }

  public RichInputDate getMemDob() {
    return memDob;
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

  public String completeDataEntry() {
    // Add event code here...
    Connection conn = null;
    workflowProcessing wf = new workflowProcessing();
    session.setAttribute("ProcessShtDesc", "QUOT");
    try {
      conn = new DBConnector().getDatabaseConn();
      String MyTask = null;
      CallableStatement cst3 = null;
      String Complete =
        "BEGIN TQC_WEB_PKG.check_task_completion(?,?,?,?);END;";
      cst3 = conn.prepareCall(Complete);
      cst3.setString(1, "QDTE");
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
      GlobalCC.INFORMATIONREPORTING("Data entry completed successfully");
      wf.CompleteTask();

    } catch (Exception ex) {
      GlobalCC.EXCEPTIONREPORTING(conn, ex);
    }
    return null;
  }

  public void setDmsDocTab(RichShowDetailItem dmsDocTab) {
    this.dmsDocTab = dmsDocTab;
  }

  public RichShowDetailItem getDmsDocTab() {
    return dmsDocTab;
  }

  public String upLoadDocToDms() {
    FacesContext context = FacesContext.getCurrentInstance();

    ServletContext sc =
      (ServletContext)context.getExternalContext().getContext();
    UploadedFile newFile = (UploadedFile)dmsFileToUpload.getValue();

    if (session.getAttribute("rdCode") == null) {
      GlobalCC.errorValueNotEntered("Please select the document type being uploaded");
      return null;
    }

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
      inputStream.close();
      out.flush();
      out.close();

      String aspect = "D:tqlms:tqlmsgrpDocumentType, P:tqlms:grpdocumentData";

      String clientName = (String)session.getAttribute("quoClient");
      Session ecmSession = ecmUtil.Authentification();

      if (ecmSession == null) {
        GlobalCC.errorValueNotEntered("Please Check alfresco connection : Can't Connect to alfresco!!");
        return null;
      }

      String policyNo = String.valueOf(session.getAttribute("dmsQuoNo"));
      String policyNo2 = String.valueOf(session.getAttribute("dmsQuoNo"));
      String quoDate = String.valueOf(session.getAttribute("dmsQuoDate"));

      policyNo = policyNo.replace("/", "_");
      boolean checkLms = ecmUtil.checkDir(ecmSession, "/TQLMSGRP");
      if (checkLms == false) {
        ecmUtil.createDirInRootFolder(ecmSession, "TQLMSGRP");
      }
      String filePath = "/TQLMSGRP/QUOT";
      boolean check = ecmUtil.checkDir(ecmSession, filePath);
      if (check == false) {
        CmisObject objectLms = ecmSession.getObjectByPath("/TQLMSGRP");
        Folder folderLms = (Folder)objectLms;
        String fpath = "QUOT";
        ecmUtil.createDir(ecmSession, folderLms, fpath);
      }

      filePath = filePath + "/" + policyNo;
      boolean check1 = ecmUtil.checkDir(ecmSession, filePath);
      if (check1 == false) {
        CmisObject objectPolAuth =
          ecmSession.getObjectByPath("/TQLMSGRP/QUOT");
        Folder folderLms = (Folder)objectPolAuth;
        String fpath = policyNo;
        ecmUtil.createDir(ecmSession, folderLms, fpath);
      }
      CmisObject object = ecmSession.getObjectByPath(filePath);
      Folder folder = (Folder)object;
      fileName = filePath + "/" + fileName;

      List<EcmProps> properties = new ArrayList<EcmProps>();
      properties.add(new EcmProps("tqlms:quotationno", policyNo2));
      properties.add(new EcmProps("tqlms:orgclientname", clientName));
      properties.add(new EcmProps("tqlms:grpdate", null));
      properties.add(new EcmProps("tqlms:grpdoccode", rdCode.toString()));

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
      ADFUtils.findIterator("findQuotationDocsIterator").executeQuery();
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
    }

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
      String aspect = "tqlms:grpdocumentData";
      //String aspect = "tqlms:tqordPolicyDocument";
      String clientName = (String)session.getAttribute("quoClient");
      Session ecmSession = ecmUtil.Authentification();

      if (ecmSession == null) {
        GlobalCC.errorValueNotEntered("Please Check alfresco connection : Can't Connect to alfresco!!");
        return null;
      }

      String policyNo = String.valueOf(session.getAttribute("dmsQuoNo"));
      String policyNo2 = String.valueOf(session.getAttribute("dmsQuoNo"));
      String quoDate = String.valueOf(session.getAttribute("dmsQuoDate"));

      policyNo = policyNo.replace("/", "_");
      boolean checkLms = ecmUtil.checkDir(ecmSession, "/TQLMSGRP");
      if (checkLms == false) {
        ecmUtil.createDirInRootFolder(ecmSession, "TQLMSGRP");

      }
      String filePath = "/TQLMSGRP/QUOT";
      boolean check = ecmUtil.checkDir(ecmSession, filePath);
      if (check == false) {
        CmisObject objectLms = ecmSession.getObjectByPath("/TQLMSGRP");
        Folder folderLms = (Folder)objectLms;
        String fpath = "QUOT";
        ecmUtil.createDir(ecmSession, folderLms, fpath);
      }

      filePath = filePath + "/" + policyNo;
      boolean check1 = ecmUtil.checkDir(ecmSession, filePath);
      if (check1 == false) {
        CmisObject objectPolAuth =
          ecmSession.getObjectByPath("/TQLMSGRP/QUOT");
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
      ecmUtil.updateMetadata(docCov, aspect, "tqlms:quotationno", policyNo2);
      ecmUtil.updateMetadata(docCov, aspect, "tqlms:orgclientname",
                             clientName);
      ecmUtil.updateMetadata(docCov, aspect, "tqlms:grpdate", quoDate);
      ecmUtil.updateMetadata(docCov, aspect, "tqlms:grpdoccode",
                             rdCode.toString());
      inputStream.close();
      out.flush();
      out.close();

      dmsFileToUpload.setValue(null);
      AdfFacesContext.getCurrentInstance().addPartialTarget(dmsFileToUpload);
      ADFUtils.findIterator("findQuotationDocsIterator").executeQuery();
      AdfFacesContext.getCurrentInstance().addPartialTarget(dmsDocTable);
      AdfFacesContext.getCurrentInstance().addPartialTarget(dmsDocTab);

      GlobalCC.hidePopup("lmsgroup:dmsUpdPop");
      GlobalCC.sysInformation("Record Saved Successfully!");

    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  public void setDmsFileToUpload(RichInputFile dmsFileToUpload) {
    this.dmsFileToUpload = dmsFileToUpload;
  }

  public RichInputFile getDmsFileToUpload() {
    return dmsFileToUpload;
  }

  public String newDmsDoc() {
    session.setAttribute("docType", "POLDOC");

    //populatPolicyDocs();

    ADFUtils.findIterator("FindOccupation1Iterator").executeQuery();
    AdfFacesContext.getCurrentInstance().addPartialTarget(lmsDocType);

    GlobalCC.showPopup("lmsgroup:dmsUpdPop");

    return null;
  }

  public String refreshDms() {
    ADFUtils.findIterator("findQuotationDocsIterator").executeQuery();
    AdfFacesContext.getCurrentInstance().addPartialTarget(dmsDocTab);
    AdfFacesContext.getCurrentInstance().addPartialTarget(dmsDocTable);
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
        System.out.println("Value changed " +
                           lmsDocType.getValue().toString());
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

  public void setDmsDocTable(RichTable dmsDocTable) {
    this.dmsDocTable = dmsDocTable;
  }

  public RichTable getDmsDocTable() {
    return dmsDocTable;
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
      byte[] bytes = new byte[1024];

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

        System.out.println("The display path " +
                           String.valueOf(session.getAttribute("toPrint")));

        ExtendedRenderKitService erkService =
          Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                             ExtendedRenderKitService.class);
        erkService.addScript(FacesContext.getCurrentInstance(),
                             "var hints = {autodismissNever:false}; " +
                             "AdfPage.PAGE.findComponent('" +
                             "lmsgroup:viewdoc" + "').show(hints);");
        AdfFacesContext.getCurrentInstance().addPartialTarget(docViewer);
        //GlobalCC.showPopup("lmsgroup:viewdoc");
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return null;
  }

  public String updateQuoteDocDms() {
    String docid = (String)session.getAttribute("docId");
    EcmUtil ecmUtil = new EcmUtil();
    if (docid != null) {
      Session ecmSession = ecmUtil.Authentification();
      if (ecmSession == null) {

      } else {

        Document document = (Document)ecmSession.getObject(docid);
        AlfrescoDocument alfDoc = (AlfrescoDocument)document;
        String aspectname = "P:tqlms:grpdocumentData";
        alfDoc.addAspect(aspectname);
        Map<String, Object> properties = new HashMap<String, Object>();

        properties.put("tqlms:quotationno", session.getAttribute("dmsQuoNo"));
        properties.put("tqlms:orgclientname",
                       session.getAttribute("quoClient"));
        System.out.println("DMS Date " +
                           String.valueOf(session.getAttribute("dmsQuoDate")));
        properties.put("tqlms:grpdate", null);
        //session.getAttribute("dmsQuoDate"));
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
        ADFUtils.findIterator("findQuotationDocsIterator").executeQuery();
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

  public void setFcclPlanTab(RichTable fcclPlanTab) {
    this.fcclPlanTab = fcclPlanTab;
  }

  public RichTable getFcclPlanTab() {
    return fcclPlanTab;
  }

  public void setOverPlan(RichSelectOneChoice overPlan) {
    this.overPlan = overPlan;
  }

  public RichSelectOneChoice getOverPlan() {
    return overPlan;
  }

  public void overrideType(ValueChangeEvent valueChangeEvent) {
    // Add event code here...
    if (String.valueOf(overPlan.getValue()).equalsIgnoreCase("Y")) {
      session.setAttribute("overPerPlan", "Y");
      fcclPlanTab.setVisible(true);
      AdfFacesContext.getCurrentInstance().addPartialTarget(fcclPlanTab);
    } else {
      session.setAttribute("overPerPlan", "N");
      fcclPlanTab.setVisible(false);
      AdfFacesContext.getCurrentInstance().addPartialTarget(fcclPlanTab);
    }
  }

  //AdfFacesContext.getCurrentInstance().addPartialTarget(coverTypesLOV);

  public String AssignSBUQuote() {
    DCIteratorBinding dciter = ADFUtils.findIterator("FindSBUDetailsIterator");
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

  public void setFclOkCancel(HtmlPanelGrid fclOkCancel) {
    this.fclOkCancel = fclOkCancel;
  }

  public HtmlPanelGrid getFclOkCancel() {
    return fclOkCancel;
  }

  public void setPerPlanOkCancel(HtmlPanelGrid perPlanOkCancel) {
    this.perPlanOkCancel = perPlanOkCancel;
  }

  public HtmlPanelGrid getPerPlanOkCancel() {
    return perPlanOkCancel;
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

  public void setSbuOneDisplay(RichInputText sbuOneDisplay) {
    this.sbuOneDisplay = sbuOneDisplay;
  }

  public RichInputText getSbuOneDisplay() {
    return sbuOneDisplay;
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

  public void setSBUOneLOV(RichTable SBUOneLOV) {
    this.SBUOneLOV = SBUOneLOV;
  }

  public RichTable getSBUOneLOV() {
    return SBUOneLOV;
  }

    public String ticketAssignee() {
            // Add event code here...
            Connection conn = new DBConnector().getDatabaseConn();
            CallableStatement cst3 = null;
            CorrespondenceManipulation mail=new CorrespondenceManipulation();
            try {
              Object key2 = ticketsUserLOV.getSelectedRowData();
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
                if (tcktAsignee.getValue() == null) {

                } else {
                    Remarks = tcktAsignee.getValue().toString();
                }
                //wfEngine wf = new wfEngine();
                //wf.AssignTask((String)session.getAttribute("TaskID"), user.getValue().toString());

                String Complete = "BEGIN TQC_WEB_PKG.reassign_task(?,?,?);END;";
                cst3 = conn.prepareCall(Complete);
                cst3.setString(1, (String)session.getAttribute("TaskID"));
                cst3.setString(2,(String)r.getAttribute("USR_USERNAME"));
                cst3.setString(3, Remarks);
                cst3.execute();
                cst3.close();
                conn.close();
                GlobalCC.INFORMATIONREPORTING(session.getAttribute("TaskActivityName")+" Ticket Successfully assigned to "+r.getAttribute("USR_NAME"));
                GlobalCC.hidePopup("lmsgroup:p14");
              mail.ticketAlert((String)session.getAttribute("Username"), (String)r.getAttribute("USR_USERNAME"), (String)session.getAttribute("TaskActivityName"), Remarks);
            }catch(Exception ex){
              GlobalCC.EXCEPTIONREPORTING(conn, ex);
            }

            return null;
    }

    public void setTcktAsignee(RichInputText tcktAsignee) {
        this.tcktAsignee = tcktAsignee;
    }

    public RichInputText getTcktAsignee() {
        return tcktAsignee;
    }

    public void setTicketsUserLOV(RichTable ticketsUserLOV) {
        this.ticketsUserLOV = ticketsUserLOV;
    }

    public RichTable getTicketsUserLOV() {
        return ticketsUserLOV;
    }
}
