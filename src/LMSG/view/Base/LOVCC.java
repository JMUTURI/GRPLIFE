package LMSG.view.Base;

import LMSG.view.connect.DBConnector;

import java.math.BigDecimal;

import java.text.SimpleDateFormat;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.OracleTypes;


public class LOVCC {
  public LOVCC() {
  }
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
  //WorkFlow Variables
  //protected static long id;
  //protected static String ActionName = null;
  //public static String productType;
  //public static BigDecimal ProductCode;
  //public static String ProductLapsationDays;
  //public static String CurrentStatus;
  //public static BigDecimal LCACode;
  //public static String LapseType;
  //public static BigDecimal PolicyTransCode;
  //public static String Authorised = null;
  //public static BigDecimal CMLCode;
  //public static String CMICode;
  //public static String PaymentsFlag = "F";
  //public static BigDecimal MedPolicy;
  //public static BigDecimal MedTransNo;
  //public static String MedicalScrnRender;
  
  //Policy Values
  private static String PolicyNumberSel;
  //protected static BigDecimal policyCode;
  //protected static BigDecimal endorsementCode;
  //protected static BigDecimal transactionNumber;
  //protected static BigDecimal pcvtCode;
  //protected static String PolCalcType;
  //protected static String policyNumber; 
  //protected static BigDecimal pmrid_code;
  //protected static BigDecimal pcaCode;
  //protected static String endrPayMethd;
  //protected static String policyEffectiveDate;
  //protected static String frequencyOfPayment;
  //protected static String calculationType;
  //protected static String retirementAge;
  //protected static String dependentsCovered;
  //protected static String policyDurationType;
  //protected static String groupLifeRider;
  //protected static String pensSchemeType;
  //protected static BigDecimal checkOffAgentCode;
  //protected static BigDecimal checkOffCommission;
  //protected static String membersToUpdate;
  //protected static BigDecimal polpCode;
  //protected static BigDecimal pprovCode;
  //protected static BigDecimal pcpCode;
  //protected static BigDecimal pdlCode;
  //protected static BigDecimal maxType;
  //protected static BigDecimal rdCode;
  //protected static String rdShtDesc;
  //protected static BigDecimal gpdCode;
  //protected static String documentSubmission;
  //protected static BigDecimal ptxCode;
  //protected static String savingsRider;
  //protected static String CoinsPolicy;
  
  //Quotation Variables
  private static String prpDesc;
  private static String gcoDesc;
  //private static String UserSelected;
  private static BigDecimal pmasCode;
  private static String pmasshtdesc;
  private static String brnName;
  private static String agnName;
  private static String coverageArea;
  private static String locName;
  private static String loanCalcType;
  private static String dependantNo;
  private static String beneficiaryNo;
  private static String jointMemberNo;
  //protected static BigDecimal gcoCode;
  //protected static BigDecimal prpCode;
  //protected static BigDecimal brnCode;
  //protected static BigDecimal pmasCode;
  //protected static BigDecimal agnCode;
  //protected static String agnShtDesc;
  //protected static String agnName;
  //protected static BigDecimal QuoteCode;
  //protected static BigDecimal qcvtcvtCode;
  //protected static BigDecimal qcvtCode;
  //protected static BigDecimal taxCode;
  //protected static BigDecimal pprov_Code;
  //protected static BigDecimal dtyCode;
  //protected static BigDecimal maxTypeNo;
  //protected static BigDecimal qdlCode;
  //protected static BigDecimal qmemCode;
  //protected static String fclCalcType;
  //protected static BigDecimal provCode;
  //protected static BigDecimal lcaCode;
  //protected static String dpdsCovered;
  //protected static BigDecimal memberANB;
  //protected static String memGender;
  //protected static String ContrType;
  //protected static String savider;
  //protected static String pensionType;
  //protected static String grpRider;
  //protected static String quoCalcTypeM;
  //protected static String quoType;
  //protected static String paymentFrequency;
  //protected static String durType;
  //protected static BigDecimal ttCode;
  //protected static BigDecimal trtRate;
  //protected static BigDecimal trtCode;
  //protected static String trtRateType;
  //protected static String ttRenewalEndos;
  //protected static String ttShtDesc;
  //protected static BigDecimal qcprCode;
  //protected static int CoinsurerTotal;
  //protected static String workflowID;
  //protected static String TaskID;
  //protected static String TaskActivityName;
  

  //BPM Variables
  private static String taskselName;
  private static String taskselAssignee;
  private static Date taskselDueDate;
  private static String taskselID;
  private static Date taskselCreateDate; 
  private static String TaskActivityName;
  //protected static BigDecimal ProcessID;
  //protected static String ProcessName;
  //protected static String ProcessShtDesc;
  //protected static String ProcessBPMDef;
  //protected static String ProcessAreaName;
  //protected static String ProcessAreaShtDesc;
  //protected static String ProcessSubAName;
  //protected static String ProcessSubAShtDesc;
  //protected static String ClientExists = "Yes";
  //protected static String UWStart="No";
  //protected static String Credit = "No";
  //protected static BigDecimal TaskAssigneeID;
  //protected static String TaskAssignee;

  
  

  
  //protected static String sysModule;
  //protected static String msgType;
  protected static int screenWidth;
  protected static String confirmMessage;
  //protected static BigDecimal msgTempCode;
  //protected static String msgTempShtDesc;
  //protected static String msgTempDesc;
  //protected static BigDecimal smsCode;
  protected static BigDecimal emailCode;
  //protected static BigDecimal AgentCode;
  protected static String UWYear;
  protected static BigDecimal TransactionNumber;
  protected static BigDecimal DeductionCode;
  protected static BigDecimal PDED_CODE;
  protected static BigDecimal PNDP_CODE;
  protected static String Allocated;
  //protected static BigDecimal townCode;
  //protected static BigDecimal countryCode;
  //protected static BigDecimal sectorCode;
  //protected static BigDecimal branchCode;
  //protected static String postalZIPCode;
  //protected static BigDecimal domicileCountry;
  //protected static String sectorName;
  //protected static BigDecimal occupationCode;
  //protected static String occupationDesc;
  //protected static String branchName;
  //protected static String townName;
  //protected static String countryShtDesc;
  protected static String clientName;
  protected static boolean clientexists;
  //protected static BigDecimal occupationlifeClass;
  protected static boolean enquiryMode = false;
  //protected static int ScreenPosition = 0;
  
  //Receipting
  protected static BigDecimal ReceiptTransNo;
  protected static BigDecimal GrctCode;
  //protected static int receiptTemplateSeq;
  
  //Claims
  //public static Boolean loggedIn = false;
  //  public static BigDecimal PolicyMemCode;
  //  public static BigDecimal CausationCode;
  //  public static String CausationShtDesc;
  //  public static String CausationType;
  //  public static String ClaimNo;
  //  public static BigDecimal ClaimTransNo;
  //  public static BigDecimal CauseCode;
  //   public static int EditClaim = 0;
  //  public static BigDecimal ActivityCode;
  //  public static BigDecimal CPVoucher;
  //  public static BigDecimal voucherNumber;
  //  public static int Cnt = 0;

  //protected static String infoMessage = LOVDAO.confirmMessage;
  
  //public static BigDecimal PolicyCode;
  //public static BigDecimal PolicyCategory;
  //public static BigDecimal MemberNumber;
  //public static BigDecimal DepTypeCode;
  //public static String DepTypeDesc;
  //public static BigDecimal PrpCode;
  //public static String ClaimTransactionType;
  //public static String Endorsement;
  //public static BigDecimal FacilitatorCode;
  //public static BigDecimal PolicyCoverType;
  //public static BigDecimal PolicyDependants;
  //public static String OSLoanCalculation,FclCalcType;
  //public static BigDecimal OccupationCode;
  //public static BigDecimal TaxesCode;
  //public static BigDecimal CoverTypeCode,TaCode,LC_CODE,CVT_CODE,PCT_CODE;
  //public static BigDecimal PolmCode,PolmMemCode;
  private static int templateTranSeq;
  private static String templateType;
  private static int templayeTypeInt;
  //public static Date EffectiveDate;
  public static BigDecimal FCLEndorsNo; 
  public static String CoverFromDate;
  public static Date CoverToDate;
  public static String CoverFormular,RefundFormular,LoadingType,RedirectPage;
  public static BigDecimal PolicyCodeTo,TransferCode;


  
   private static String QuotationNo;
  //public static String TaxRateType;
  //public static String TaxRenewalEndr;
  //public static String TaxShtDesc;
  //public static BigDecimal TaxTRTCode;
  
 


  
  public static int CoversSaved = 0;
  public static String parseDate(String somedate) {
      Date date;
      date = null;
      String dateString;
      dateString = null;
      SimpleDateFormat sdf1 =
          new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
      SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MMMM/yyyy");


      try {
          date = sdf1.parse(somedate);
      } catch (Exception e) {
          FacesContext.getCurrentInstance().addMessage(null,
                                                       new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                        e.getMessage(),
                                                                        e.getMessage()));
      }
      dateString = sdf2.format(date);

      return dateString;
  }

  public void setTemplateTranSeq(int templateTranSeq) {
        LOVCC.templateTranSeq = (Integer)session.getAttribute("templateTranSeq");
  }

  public int getTemplateTranSeq() {
    return (Integer)session.getAttribute("templateTranSeq");
  }

  public void setTemplateType(String templateType) {
        LOVCC.templateType = (String)session.getAttribute("templateType");
  }

  public String getTemplateType() {
    return (String)session.getAttribute("templateType");
  }

  public void setTemplayeTypeInt(int templayeTypeInt) {
        LOVCC.templayeTypeInt = (Integer)session.getAttribute("templayeTypeInt");
  }

  public int getTemplayeTypeInt() {
    return (Integer)session.getAttribute("templayeTypeInt");
  }

  public void setQuotationNo(String QuotationNumber) {
        LOVCC.QuotationNo = (String)session.getAttribute("QuotationNo");
  }

  public String getQuotationNo() {
    return (String)session.getAttribute("QuotationNo");
  }

    /* public void setMsgTempCode(BigDecimal msgTempCode) {
        LOVCC.msgTempCode = msgTempCode;
    }

    public BigDecimal getMsgTempCode() {
        return msgTempCode;
    }

    public void setMsgTempShtDesc(String msgTempShtDesc) {
        LOVCC.msgTempShtDesc = msgTempShtDesc;
    }

    public String getMsgTempShtDesc() {
        return msgTempShtDesc;
    }

   public void setMsgTempDesc(String msgTempDesc) {
        LOVCC.msgTempDesc = msgTempDesc;
    }

    public String getMsgTempDesc() {
        return msgTempDesc;
    }

    public void setSmsCode(BigDecimal smsCode) {
        LOVCC.smsCode = smsCode;
    }

    public BigDecimal getSmsCode() {
        return smsCode;
    }*/

    public void setEmailCode(BigDecimal emailCode) {
        LOVCC.emailCode = emailCode;
    }

    public BigDecimal getEmailCode() {
        return emailCode;
    }

    /*public void setAgentCode(BigDecimal AgentCode) {
        LOVCC.AgentCode = AgentCode;
    }

    public BigDecimal getAgentCode() {
        return AgentCode;
    }*/

    public void setUWYear(String UWYear) {
        LOVCC.UWYear = UWYear;
    }

    public String getUWYear() {
        return UWYear;
    }

    public void setPrpDesc(String prpDesc) {
        LOVCC.prpDesc = (String)session.getAttribute("prpDesc");
    }

    public String getPrpDesc() {
        return (String)session.getAttribute("prpDesc");
    }

    public void setGcoDesc(String gcoDesc) {
        LOVCC.gcoDesc = (String)session.getAttribute("gcoDesc");
    }

    public String getGcoDesc() {
        return (String)session.getAttribute("gcoDesc");
    }

    public void setPolicyNumberSel(String PolicyNumberSel) {
        LOVCC.PolicyNumberSel = (String)session.getAttribute("PolicyNumberSel");
    }

    public String getPolicyNumberSel() {
        return (String)session.getAttribute("PolicyNumberSel");
    }

    public void setTaskselName(String taskselName) {
        LOVCC.taskselName = (String)session.getAttribute("taskselName");
    }

    public String getTaskselName() {
        return (String)session.getAttribute("taskselName");
    }

    public void setTaskselAssignee(String taskselAssignee) {
        LOVCC.taskselAssignee = (String)session.getAttribute("taskselAssignee");
    }

    public String getTaskselAssignee() {
        return (String)session.getAttribute("taskselAssignee");
    }

    public void setTaskselDueDate(Date taskselDueDate) {
        LOVCC.taskselDueDate = (Date)session.getAttribute("taskselDueDate");
    }

    public Date getTaskselDueDate() {
        return (Date)session.getAttribute("taskselDueDate");
    }

    public void setTaskselID(String taskselID) {
        LOVCC.taskselID = (String)session.getAttribute("taskselID");
    }

    public String getTaskselID() {
        return (String)session.getAttribute("taskselID");
    }

    public void setTaskselCreateDate(Date taskselCreateDate) {
        LOVCC.taskselCreateDate = (Date)session.getAttribute("taskselCreateDate");
    }

    public Date getTaskselCreateDate() {
        return (Date)session.getAttribute("taskselCreateDate");
    }

    public void setPmasCode(BigDecimal pmasCode) {
        LOVCC.pmasCode = (BigDecimal)session.getAttribute("pmasCode");
    }

    public BigDecimal getPmasCode() {
        return (BigDecimal)session.getAttribute("pmasCode");
    }

    public void setPmasshtdesc(String pmasshtdesc) {
        LOVCC.pmasshtdesc = (String)session.getAttribute("pmasShtDesc");
    }

    public String getPmasshtdesc() {
        return (String)session.getAttribute("pmasShtDesc");
    }

    public void setBrnName(String brnName) {
        LOVCC.brnName = (String)session.getAttribute("brnName");
    }

    public String getBrnName() {
        return (String)session.getAttribute("brnName");
    }

    public void setAgnName(String agnName) {
        LOVCC.agnName = (String)session.getAttribute("agnName");
    }

    public String getAgnName() {
        return (String)session.getAttribute("agnName");
    }

    public void setTaskActivityName(String TaskActivityName) {
        LOVCC.TaskActivityName = (String)session.getAttribute("TaskActivityName");
    }

    public String getTaskActivityName() {
        return (String)session.getAttribute("TaskActivityName");
    }

    public  void setLoanCalcType(String loanCalcType) {
        LOVCC.loanCalcType = (String)session.getAttribute("loanCalcType");
    }

    public  String getLoanCalcType() {
      return (String)session.getAttribute("loanCalcType");
    }
  public String findPolMemberNo(String type) {
      
      DBConnector dbConn = new DBConnector();
      OracleConnection connect = null;
      connect = (OracleConnection)dbConn.getDatabaseConn();
      String memNo = "N";
      OracleCallableStatement cst = null;
      String sysQuery = "";
      String SystemPoint = (String)this.session.getAttribute("SystemPoint");
      //System.out.println("SystemPoint is: "+SystemPoint);
      try {
          sysQuery = "begin ? := LMS_GRP_MISC.getdependantno(?,?); end;";
          cst = (OracleCallableStatement)connect.prepareCall(sysQuery);
          cst.registerOutParameter(1, OracleTypes.VARCHAR);
          cst.setBigDecimal(2, (BigDecimal)this.session.getAttribute("MemberNumber")); //POLM MEM CODE
          System.out.println("Member Number in Session="+(BigDecimal)this.session.getAttribute("MemberNumber"));
          cst.setString(3,type);
          cst.execute();        
          
          if (cst.getString(1) != null) {
              memNo = cst.getString(1);
          }
          cst.close();
          connect.commit();
          connect.close();
          
      } catch (Exception e) {
          e.printStackTrace();
          GlobalCC.EXCEPTIONREPORTING(connect, e);
      }
      return memNo;
  }

    public void setDependantNo(String dependantNo) {
        LOVCC.dependantNo =findPolMemberNo("D");
    }

    public String getDependantNo() {
        return findPolMemberNo("D");
    }

    public  void setBeneficiaryNo(String beneficiaryNo) {
        LOVCC.beneficiaryNo = findPolMemberNo("B");
    }

    public String getBeneficiaryNo() {
            return findPolMemberNo("B");    
    }

  public void setCoverageArea(String coverageArea) {
    LOVCC.coverageArea = (String)session.getAttribute("coverageArea");
    }

  public String getCoverageArea() {
    return (String)session.getAttribute("coverageArea");
  }

  public void setLocName(String locName) {
    LOVCC.locName = (String)session.getAttribute("location");
  }

  public String getLocName() {
    return (String)session.getAttribute("location");
   
  }

    public void setJointMemberNo(String jointMemberNo) {
        LOVCC.jointMemberNo = jointMemberNo;
    }

    public String getJointMemberNo() {
        return findPolMemberNo("J");
    }

 
}
