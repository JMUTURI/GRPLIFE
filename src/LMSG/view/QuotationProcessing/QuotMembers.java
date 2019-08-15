package LMSG.view.QuotationProcessing;

import java.math.BigDecimal;

import java.util.Date;

public class QuotMembers {
  private String quoMemNo;
  private String quoMemName;
  private String quoDepMemType;
  private Integer quoMemAnb;
  private String quoJointMem, qab_number;
  private String quoOccupation,QMEM_LOADING_TYPE;
  private BigDecimal QMEM_DTY_CODE,QMEM_MEM_CODE,QMEM_CODE;
  private BigDecimal QMEM_HEIGHT,QMEM_WEIGHT,QMEM_WEIGHT_LOADING,
          QMEM_SYSTOLIC_PR,QMEM_DIASTOLIC_PR,QMEM_BPRESS_LOADING,
          QMEM_LOADING_RATE,QMEM_LOADING_DIV_FACT,QMEM_TOT_SA,
           qab_ann_purchase_amt, qab_ben_terminal_amt;
  
 private Date qab_dob;
  
  //member beneficiaries
  private BigDecimal qmemBenCode;
  private BigDecimal qmemBenMainMemCode;
  private String qmemBenSurname;
  private String qmemBenOtherNames;
  private String qmemBenClass;
  private String qmemBenTerm;
  private String qmemBenMemNo;
  private String classDisplay;
  private String benTerm;
  private BigDecimal feeDisplay;
  private String qmem_ben_sex;
  
  private BigDecimal QABP_CODE;
  private BigDecimal QABP_NO;
  private Date QABP_DATE_DUE;
  private BigDecimal QABP_AMOUNT;
  private String QABP_PAID; 
  private String QABP_PAID_DESC;
  private Date QABP_PAID_DATE; 
  private BigDecimal QABP_VOUCHER_NO;
  
  //member dependants for annuities
  private BigDecimal qabCode;
  private String qabMemNo;
  private String qabSurname;
  private String qabOtherNames;
  private String qabAnb;
  private String qabSharePct;
  public QuotMembers() {
  }

  public void setQuoMemNo(String quoMemNo) {
    this.quoMemNo = quoMemNo;
  }

  public String getQuoMemNo() {
    return quoMemNo;
  }

  public void setQuoMemName(String quoMemName) {
    this.quoMemName = quoMemName;
  }

  public String getQuoMemName() {
    return quoMemName;
  }

  public void setQuoDepMemType(String quoDepMemType) {
    this.quoDepMemType = quoDepMemType;
  }

  public String getQuoDepMemType() {
    return quoDepMemType;
  }

  public void setQuoMemAnb(Integer quoMemAnb) {
    this.quoMemAnb = quoMemAnb;
  }

  public Integer getQuoMemAnb() {
    return quoMemAnb;
  }

  public void setQuoJointMem(String quoJointMem) {
    this.quoJointMem = quoJointMem;
  }

  public String getQuoJointMem() {
    return quoJointMem;
  }

  public void setQuoOccupation(String quoOccupation) {
    this.quoOccupation = quoOccupation;
  }

  public String getQuoOccupation() {
    return quoOccupation;
  }

  public void setQMEM_DTY_CODE(BigDecimal QMEM_DTY_CODE) {
    this.QMEM_DTY_CODE = QMEM_DTY_CODE;
  }

  public BigDecimal getQMEM_DTY_CODE() {
    return QMEM_DTY_CODE;
  }

  public void setQMEM_MEM_CODE(BigDecimal QMEM_MEM_CODE) {
    this.QMEM_MEM_CODE = QMEM_MEM_CODE;
  }

  public BigDecimal getQMEM_MEM_CODE() {
    return QMEM_MEM_CODE;
  }

  public void setQMEM_CODE(BigDecimal QMEM_CODE) {
    this.QMEM_CODE = QMEM_CODE;
  }

  public BigDecimal getQMEM_CODE() {
    return QMEM_CODE;
  }

  public void setQMEM_LOADING_TYPE(String QMEM_LOADING_TYPE) {
    this.QMEM_LOADING_TYPE = QMEM_LOADING_TYPE;
  }

  public String getQMEM_LOADING_TYPE() {
    return QMEM_LOADING_TYPE;
  }

  public void setQMEM_HEIGHT(BigDecimal QMEM_HEIGHT) {
    this.QMEM_HEIGHT = QMEM_HEIGHT;
  }

  public BigDecimal getQMEM_HEIGHT() {
    return QMEM_HEIGHT;
  }

  public void setQMEM_WEIGHT(BigDecimal QMEM_WEIGHT) {
    this.QMEM_WEIGHT = QMEM_WEIGHT;
  }

  public BigDecimal getQMEM_WEIGHT() {
    return QMEM_WEIGHT;
  }

  public void setQMEM_WEIGHT_LOADING(BigDecimal QMEM_WEIGHT_LOADING) {
    this.QMEM_WEIGHT_LOADING = QMEM_WEIGHT_LOADING;
  }

  public BigDecimal getQMEM_WEIGHT_LOADING() {
    return QMEM_WEIGHT_LOADING;
  }

  public void setQMEM_SYSTOLIC_PR(BigDecimal QMEM_SYSTOLIC_PR) {
    this.QMEM_SYSTOLIC_PR = QMEM_SYSTOLIC_PR;
  }

  public BigDecimal getQMEM_SYSTOLIC_PR() {
    return QMEM_SYSTOLIC_PR;
  }

  public void setQMEM_DIASTOLIC_PR(BigDecimal QMEM_DIASTOLIC_PR) {
    this.QMEM_DIASTOLIC_PR = QMEM_DIASTOLIC_PR;
  }

  public BigDecimal getQMEM_DIASTOLIC_PR() {
    return QMEM_DIASTOLIC_PR;
  }

  public void setQMEM_BPRESS_LOADING(BigDecimal QMEM_BPRESS_LOADING) {
    this.QMEM_BPRESS_LOADING = QMEM_BPRESS_LOADING;
  }

  public BigDecimal getQMEM_BPRESS_LOADING() {
    return QMEM_BPRESS_LOADING;
  }

  public void setQMEM_LOADING_RATE(BigDecimal QMEM_LOADING_RATE) {
    this.QMEM_LOADING_RATE = QMEM_LOADING_RATE;
  }

  public BigDecimal getQMEM_LOADING_RATE() {
    return QMEM_LOADING_RATE;
  }

  public void setQMEM_LOADING_DIV_FACT(BigDecimal QMEM_LOADING_DIV_FACT) {
    this.QMEM_LOADING_DIV_FACT = QMEM_LOADING_DIV_FACT;
  }

  public BigDecimal getQMEM_LOADING_DIV_FACT() {
    return QMEM_LOADING_DIV_FACT;
  }

  public void setQMEM_TOT_SA(BigDecimal QMEM_TOT_SA) {
    this.QMEM_TOT_SA = QMEM_TOT_SA;
  }

  public BigDecimal getQMEM_TOT_SA() {
    return QMEM_TOT_SA;
  }

    public void setQmemBenCode(BigDecimal qmemBenCode) {
        this.qmemBenCode = qmemBenCode;
    }

    public BigDecimal getQmemBenCode() {
        return qmemBenCode;
    }

    public void setQmemBenMainMemCode(BigDecimal qmemBenMainMemCode) {
        this.qmemBenMainMemCode = qmemBenMainMemCode;
    }

    public BigDecimal getQmemBenMainMemCode() {
        return qmemBenMainMemCode;
    }

    public void setQmemBenSurname(String qmemBenSurname) {
        this.qmemBenSurname = qmemBenSurname;
    }

    public String getQmemBenSurname() {
        return qmemBenSurname;
    }

    public void setQmemBenOtherNames(String qmemBenOtherNames) {
        this.qmemBenOtherNames = qmemBenOtherNames;
    }

    public String getQmemBenOtherNames() {
        return qmemBenOtherNames;
    }

    public void setQmemBenClass(String qmemBenClass) {
        this.qmemBenClass = qmemBenClass;
    }

    public String getQmemBenClass() {
        return qmemBenClass;
    }

    public void setQmemBenTerm(String qmemBenTerm) {
        this.qmemBenTerm = qmemBenTerm;
    }

    public String getQmemBenTerm() {
        return qmemBenTerm;
    }

    public void setQmemBenMemNo(String qmemBenMemNo) {
        this.qmemBenMemNo = qmemBenMemNo;
    }

    public String getQmemBenMemNo() {
        return qmemBenMemNo;
    }

    public void setClassDisplay(String classDisplay) {
        this.classDisplay = classDisplay;
    }

    public String getClassDisplay() {
        return classDisplay;
    }

    public void setBenTerm(String benTerm) {
        this.benTerm = benTerm;
    }

    public String getBenTerm() {
        return benTerm;
    }

    public void setFeeDisplay(BigDecimal feeDisplay) {
        this.feeDisplay = feeDisplay;
    }

    public BigDecimal getFeeDisplay() {
        return feeDisplay;
    }

    public void setQmem_ben_sex(String qmem_ben_sex) {
        this.qmem_ben_sex = qmem_ben_sex;
    }

    public String getQmem_ben_sex() {
        return qmem_ben_sex;
    }

    public void setQabCode(BigDecimal qabCode) {
        this.qabCode = qabCode;
    }

    public BigDecimal getQabCode() {
        return qabCode;
    }

    public void setQabMemNo(String qabMemNo) {
        this.qabMemNo = qabMemNo;
    }

    public String getQabMemNo() {
        return qabMemNo;
    }

    public void setQabSurname(String qabSurname) {
        this.qabSurname = qabSurname;
    }

    public String getQabSurname() {
        return qabSurname;
    }

    public void setQabOtherNames(String qabOtherNames) {
        this.qabOtherNames = qabOtherNames;
    }

    public String getQabOtherNames() {
        return qabOtherNames;
    }

    public void setQabAnb(String qabAnb) {
        this.qabAnb = qabAnb;
    }

    public String getQabAnb() {
        return qabAnb;
    }

    public void setQabSharePct(String qabSharePct) {
        this.qabSharePct = qabSharePct;
    }

    public String getQabSharePct() {
        return qabSharePct;
    }

    public void setQab_ann_purchase_amt(BigDecimal qab_ann_purchase_amt) {
        this.qab_ann_purchase_amt = qab_ann_purchase_amt;
    }

    public BigDecimal getQab_ann_purchase_amt() {
        return qab_ann_purchase_amt;
    }

    public void setQab_ben_terminal_amt(BigDecimal qab_ben_terminal_amt) {
        this.qab_ben_terminal_amt = qab_ben_terminal_amt;
    }

    public BigDecimal getQab_ben_terminal_amt() {
        return qab_ben_terminal_amt;
    }

    public void setQab_dob(Date qab_dob) {
        this.qab_dob = qab_dob;
    }

    public Date getQab_dob() {
        return qab_dob;
    }

    public void setQab_number(String qab_number) {
        this.qab_number = qab_number;
    }

    public String getQab_number() {
        return qab_number;
    }

    public void setQABP_CODE(BigDecimal QABP_CODE) {
        this.QABP_CODE = QABP_CODE;
    }

    public BigDecimal getQABP_CODE() {
        return QABP_CODE;
    }

    public void setQABP_NO(BigDecimal QABP_NO) {
        this.QABP_NO = QABP_NO;
    }

    public BigDecimal getQABP_NO() {
        return QABP_NO;
    }

    public void setQABP_DATE_DUE(Date QABP_DATE_DUE) {
        this.QABP_DATE_DUE = QABP_DATE_DUE;
    }

    public Date getQABP_DATE_DUE() {
        return QABP_DATE_DUE;
    }

    public void setQABP_AMOUNT(BigDecimal QABP_AMOUNT) {
        this.QABP_AMOUNT = QABP_AMOUNT;
    }

    public BigDecimal getQABP_AMOUNT() {
        return QABP_AMOUNT;
    }

    public void setQABP_PAID(String QABP_PAID) {
        this.QABP_PAID = QABP_PAID;
    }

    public String getQABP_PAID() {
        return QABP_PAID;
    }

    public void setQABP_PAID_DESC(String QABP_PAID_DESC) {
        this.QABP_PAID_DESC = QABP_PAID_DESC;
    }

    public String getQABP_PAID_DESC() {
        return QABP_PAID_DESC;
    }

    public void setQABP_PAID_DATE(Date QABP_PAID_DATE) {
        this.QABP_PAID_DATE = QABP_PAID_DATE;
    }

    public Date getQABP_PAID_DATE() {
        return QABP_PAID_DATE;
    }

    public void setQABP_VOUCHER_NO(BigDecimal QABP_VOUCHER_NO) {
        this.QABP_VOUCHER_NO = QABP_VOUCHER_NO;
    }

    public BigDecimal getQABP_VOUCHER_NO() {
        return QABP_VOUCHER_NO;
    }
}
