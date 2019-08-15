package LMSG.view.Medicals;

import java.math.BigDecimal;

import java.util.Date;

public class medical {
    //Medical Groups
    private String CMI_CODE;
    private String CMI_PRP_CODE;
    private String CMI_ID_NO;
    private String MTG_SHT_DESC;
    private String MTG_DESC;
    private BigDecimal POLM_MED_TOT_SA;
    
    private BigDecimal SPR_CODE;
    private boolean selected;
    private String Client;
    
   private String MedicalTestDescription;
   private BigDecimal MTLCode;
   private BigDecimal MTLFees;
    
    private BigDecimal POLM_CODE;
    private BigDecimal MEM_CODE;
    private String MEM_NO;
    private String MEM_NAME;
    
    //Existing Policies
    private String PROPOSAL_NO;
    private String POLICY_NO;
    private BigDecimal TOT_SA;
    
    //Client Medicals
    private BigDecimal CML_CODE;
    private BigDecimal CML_LIMIT_AMT;
    private Date CML_REQUEST_DATE;
    private String SPR_NAME;
    private String CML_CLAIM_AMT;
    private String CML_PAYABLE_AMT;
    private String CML_RECEIVED;
    private Date CML_DATE_RECEIVED;
    private Date CML_INVCE_DATE;
    private String CML_INVCE_NO;
    private String CML_CHEQUE_NO;
    private Date CML_CHEQUE_DATE;
    private String CML_MED_LOADING;
    private Date CML_RESULT_DATE;
    private String POL_PROPOSAL_NO;
    private String CML_REMARKS;
    private String MTL_DESC;
    
    //Facilitators View
    
    private String FC_SPR_NAME;
    private String FC_LIMIT_AMT;
    private String FC_CLAIM_AMT;
    private String FC_PAYABLE_AMT;
    
    //UW Decisions
    private BigDecimal PUD_CODE;
    private String UD_DESC;
    
    //Member UW Decisions
    private BigDecimal MEM_PUD_CODE;
    private String MEM_UD_DESC;
    
    //Payments Query
    
    private BigDecimal SearchCode;
    private String SearchDesc;
    
    //Medical Payments
    private BigDecimal MP_CML_CODE;
    private String MP_CML_ID_NO;
    private String MP_PROPOSAL_NO;
    private String MP_MED_TEST_DISPLAY;
    private String MP_CML_RECEIVED;
    private String MP_CML_PAYABLE_AMT;
    private String MP_CML_PAID;
    private String MP_FACILITATOR_DISPLAY;
    private String MP_CML_RAISED_BY;
    private String MP_CLIENT;
    
    //Facilitator Payments
    private String FP_facilitator_display;
    private String FP_branch_display;
    private String FP_fpmt_amount;
    private String FP_fpmt_vat_rate;
    private String FP_fpmt_vat_amt;
    private String FP_fpmt_net_amount;
    private String FP_fpmt_pymt_type;
    
    private BigDecimal pol_code; 
    private String pol_policy_no; 
    private BigDecimal pol_current_endr_code;
    private String prodDesc;
    private String curSymbol;
    private BigDecimal curCode;
    
    private String medDetails;
    private String memName;
    private BigDecimal FPMT_CODE;
    
    //med report vars
    private BigDecimal medqCode;
    private String medqDesc;
    

    public void setCMI_CODE(String CMI_CODE) {
        this.CMI_CODE = CMI_CODE;
    }

    public String getCMI_CODE() {
        return CMI_CODE;
    }

    public void setCMI_PRP_CODE(String CMI_PRP_CODE) {
        this.CMI_PRP_CODE = CMI_PRP_CODE;
    }

    public String getCMI_PRP_CODE() {
        return CMI_PRP_CODE;
    }

    public void setCMI_ID_NO(String CMI_ID_NO) {
        this.CMI_ID_NO = CMI_ID_NO;
    }

    public String getCMI_ID_NO() {
        return CMI_ID_NO;
    }

    public void setPROPOSAL_NO(String PROPOSAL_NO) {
        this.PROPOSAL_NO = PROPOSAL_NO;
    }

    public String getPROPOSAL_NO() {
        return PROPOSAL_NO;
    }

    public void setPOLICY_NO(String POLICY_NO) {
        this.POLICY_NO = POLICY_NO;
    }

    public String getPOLICY_NO() {
        return POLICY_NO;
    }

    public void setTOT_SA(BigDecimal TOT_SA) {
        this.TOT_SA = TOT_SA;
    }

    public BigDecimal getTOT_SA() {
        return TOT_SA;
    }

    public void setCML_CODE(BigDecimal CML_CODE) {
        this.CML_CODE = CML_CODE;
    }

    public BigDecimal getCML_CODE() {
        return CML_CODE;
    }

    public void setCML_LIMIT_AMT(BigDecimal CML_LIMIT_AMT) {
        this.CML_LIMIT_AMT = CML_LIMIT_AMT;
    }

    public BigDecimal getCML_LIMIT_AMT() {
        return CML_LIMIT_AMT;
    }

    public void setCML_REQUEST_DATE(Date CML_REQUEST_DATE) {
        this.CML_REQUEST_DATE = CML_REQUEST_DATE;
    }

    public Date getCML_REQUEST_DATE() {
        return CML_REQUEST_DATE;
    }

    public void setSPR_NAME(String SPR_NAME) {
        this.SPR_NAME = SPR_NAME;
    }

    public String getSPR_NAME() {
        return SPR_NAME;
    }

    public void setCML_CLAIM_AMT(String CML_CLAIM_AMT) {
        this.CML_CLAIM_AMT = CML_CLAIM_AMT;
    }

    public String getCML_CLAIM_AMT() {
        return CML_CLAIM_AMT;
    }

    public void setCML_PAYABLE_AMT(String CML_PAYABLE_AMT) {
        this.CML_PAYABLE_AMT = CML_PAYABLE_AMT;
    }

    public String getCML_PAYABLE_AMT() {
        return CML_PAYABLE_AMT;
    }

    public void setCML_RECEIVED(String CML_RECEIVED) {
        this.CML_RECEIVED = CML_RECEIVED;
    }

    public String getCML_RECEIVED() {
        return CML_RECEIVED;
    }

    public void setCML_DATE_RECEIVED(Date CML_DATE_RECEIVED) {
        this.CML_DATE_RECEIVED = CML_DATE_RECEIVED;
    }

    public Date getCML_DATE_RECEIVED() {
        return CML_DATE_RECEIVED;
    }

    public void setCML_INVCE_DATE(Date CML_INVCE_DATE) {
        this.CML_INVCE_DATE = CML_INVCE_DATE;
    }

    public Date getCML_INVCE_DATE() {
        return CML_INVCE_DATE;
    }

    public void setCML_INVCE_NO(String CML_INVCE_NO) {
        this.CML_INVCE_NO = CML_INVCE_NO;
    }

    public String getCML_INVCE_NO() {
        return CML_INVCE_NO;
    }

    public void setCML_CHEQUE_NO(String CML_CHEQUE_NO) {
        this.CML_CHEQUE_NO = CML_CHEQUE_NO;
    }

    public String getCML_CHEQUE_NO() {
        return CML_CHEQUE_NO;
    }

    public void setCML_CHEQUE_DATE(Date CML_CHEQUE_DATE) {
        this.CML_CHEQUE_DATE = CML_CHEQUE_DATE;
    }

    public Date getCML_CHEQUE_DATE() {
        return CML_CHEQUE_DATE;
    }

    public void setCML_MED_LOADING(String CML_MED_LOADING) {
        this.CML_MED_LOADING = CML_MED_LOADING;
    }

    public String getCML_MED_LOADING() {
        return CML_MED_LOADING;
    }

    public void setPOL_PROPOSAL_NO(String POL_PROPOSAL_NO) {
        this.POL_PROPOSAL_NO = POL_PROPOSAL_NO;
    }

    public String getPOL_PROPOSAL_NO() {
        return POL_PROPOSAL_NO;
    }

    public void setCML_REMARKS(String CML_REMARKS) {
        this.CML_REMARKS = CML_REMARKS;
    }

    public String getCML_REMARKS() {
        return CML_REMARKS;
    }

    public void setFC_SPR_NAME(String FC_SPR_NAME) {
        this.FC_SPR_NAME = FC_SPR_NAME;
    }

    public String getFC_SPR_NAME() {
        return FC_SPR_NAME;
    }

    public void setFC_LIMIT_AMT(String FC_LIMIT_AMT) {
        this.FC_LIMIT_AMT = FC_LIMIT_AMT;
    }

    public String getFC_LIMIT_AMT() {
        return FC_LIMIT_AMT;
    }

    public void setFC_CLAIM_AMT(String FC_CLAIM_AMT) {
        this.FC_CLAIM_AMT = FC_CLAIM_AMT;
    }

    public String getFC_CLAIM_AMT() {
        return FC_CLAIM_AMT;
    }

    public void setFC_PAYABLE_AMT(String FC_PAYABLE_AMT) {
        this.FC_PAYABLE_AMT = FC_PAYABLE_AMT;
    }

    public String getFC_PAYABLE_AMT() {
        return FC_PAYABLE_AMT;
    }

    public void setPUD_CODE(BigDecimal PUD_CODE) {
        this.PUD_CODE = PUD_CODE;
    }

    public BigDecimal getPUD_CODE() {
        return PUD_CODE;
    }

    public void setUD_DESC(String UD_DESC) {
        this.UD_DESC = UD_DESC;
    }

    public String getUD_DESC() {
        return UD_DESC;
    }

    public void setMTG_SHT_DESC(String MTG_SHT_DESC) {
        this.MTG_SHT_DESC = MTG_SHT_DESC;
    }

    public String getMTG_SHT_DESC() {
        return MTG_SHT_DESC;
    }

    public void setMTG_DESC(String MTG_DESC) {
        this.MTG_DESC = MTG_DESC;
    }

    public String getMTG_DESC() {
        return MTG_DESC;
    }

    public void setPOLM_MED_TOT_SA(BigDecimal POLM_MED_TOT_SA) {
        this.POLM_MED_TOT_SA = POLM_MED_TOT_SA;
    }

    public BigDecimal getPOLM_MED_TOT_SA() {
        return POLM_MED_TOT_SA;
    }

    public void setMTL_DESC(String MTL_DESC) {
        this.MTL_DESC = MTL_DESC;
    }

    public String getMTL_DESC() {
        return MTL_DESC;
    }

    public void setSearchCode(BigDecimal SearchCode) {
        this.SearchCode = SearchCode;
    }

    public BigDecimal getSearchCode() {
        return SearchCode;
    }

    public void setSearchDesc(String SearchDesc) {
        this.SearchDesc = SearchDesc;
    }

    public String getSearchDesc() {
        return SearchDesc;
    }

    public void setMP_CML_CODE(BigDecimal MP_CML_CODE) {
        this.MP_CML_CODE = MP_CML_CODE;
    }

    public BigDecimal getMP_CML_CODE() {
        return MP_CML_CODE;
    }

    public void setMP_CML_ID_NO(String MP_CML_ID_NO) {
        this.MP_CML_ID_NO = MP_CML_ID_NO;
    }

    public String getMP_CML_ID_NO() {
        return MP_CML_ID_NO;
    }

    public void setMP_PROPOSAL_NO(String MP_PROPOSAL_NO) {
        this.MP_PROPOSAL_NO = MP_PROPOSAL_NO;
    }

    public String getMP_PROPOSAL_NO() {
        return MP_PROPOSAL_NO;
    }

    public void setMP_MED_TEST_DISPLAY(String MP_MED_TEST_DISPLAY) {
        this.MP_MED_TEST_DISPLAY = MP_MED_TEST_DISPLAY;
    }

    public String getMP_MED_TEST_DISPLAY() {
        return MP_MED_TEST_DISPLAY;
    }

    public void setMP_CML_RECEIVED(String MP_CML_RECEIVED) {
        this.MP_CML_RECEIVED = MP_CML_RECEIVED;
    }

    public String getMP_CML_RECEIVED() {
        return MP_CML_RECEIVED;
    }

    public void setMP_CML_PAYABLE_AMT(String MP_CML_PAYABLE_AMT) {
        this.MP_CML_PAYABLE_AMT = MP_CML_PAYABLE_AMT;
    }

    public String getMP_CML_PAYABLE_AMT() {
        return MP_CML_PAYABLE_AMT;
    }

    public void setMP_CML_PAID(String MP_CML_PAID) {
        this.MP_CML_PAID = MP_CML_PAID;
    }

    public String getMP_CML_PAID() {
        return MP_CML_PAID;
    }

    public void setMP_FACILITATOR_DISPLAY(String MP_FACILITATOR_DISPLAY) {
        this.MP_FACILITATOR_DISPLAY = MP_FACILITATOR_DISPLAY;
    }

    public String getMP_FACILITATOR_DISPLAY() {
        return MP_FACILITATOR_DISPLAY;
    }

    public void setMP_CML_RAISED_BY(String MP_CML_RAISED_BY) {
        this.MP_CML_RAISED_BY = MP_CML_RAISED_BY;
    }

    public String getMP_CML_RAISED_BY() {
        return MP_CML_RAISED_BY;
    }

    public void setMP_CLIENT(String MP_CLIENT) {
        this.MP_CLIENT = MP_CLIENT;
    }

    public String getMP_CLIENT() {
        return MP_CLIENT;
    }

    public void setFP_facilitator_display(String FP_facilitator_display) {
        this.FP_facilitator_display = FP_facilitator_display;
    }

    public String getFP_facilitator_display() {
        return FP_facilitator_display;
    }

    public void setFP_branch_display(String FP_branch_display) {
        this.FP_branch_display = FP_branch_display;
    }

    public String getFP_branch_display() {
        return FP_branch_display;
    }

    public void setFP_fpmt_amount(String FP_fpmt_amount) {
        this.FP_fpmt_amount = FP_fpmt_amount;
    }

    public String getFP_fpmt_amount() {
        return FP_fpmt_amount;
    }

    public void setFP_fpmt_vat_rate(String FP_fpmt_vat_rate) {
        this.FP_fpmt_vat_rate = FP_fpmt_vat_rate;
    }

    public String getFP_fpmt_vat_rate() {
        return FP_fpmt_vat_rate;
    }

    public void setFP_fpmt_vat_amt(String FP_fpmt_vat_amt) {
        this.FP_fpmt_vat_amt = FP_fpmt_vat_amt;
    }

    public String getFP_fpmt_vat_amt() {
        return FP_fpmt_vat_amt;
    }

    public void setFP_fpmt_net_amount(String FP_fpmt_net_amount) {
        this.FP_fpmt_net_amount = FP_fpmt_net_amount;
    }

    public String getFP_fpmt_net_amount() {
        return FP_fpmt_net_amount;
    }

    public void setFP_fpmt_pymt_type(String FP_fpmt_pymt_type) {
        this.FP_fpmt_pymt_type = FP_fpmt_pymt_type;
    }

    public String getFP_fpmt_pymt_type() {
        return FP_fpmt_pymt_type;
    }

    public void setMEM_PUD_CODE(BigDecimal MEM_PUD_CODE) {
        this.MEM_PUD_CODE = MEM_PUD_CODE;
    }

    public BigDecimal getMEM_PUD_CODE() {
        return MEM_PUD_CODE;
    }

    public void setMEM_UD_DESC(String MEM_UD_DESC) {
        this.MEM_UD_DESC = MEM_UD_DESC;
    }

    public String getMEM_UD_DESC() {
        return MEM_UD_DESC;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean getSelected() {
        return selected;
    }

    public void setSPR_CODE(BigDecimal SPR_CODE) {
        this.SPR_CODE = SPR_CODE;
    }

    public BigDecimal getSPR_CODE() {
        return SPR_CODE;
    }

    public void setPOLM_CODE(BigDecimal POLM_CODE) {
        this.POLM_CODE = POLM_CODE;
    }

    public BigDecimal getPOLM_CODE() {
        return POLM_CODE;
    }

    public void setMEM_CODE(BigDecimal MEM_CODE) {
        this.MEM_CODE = MEM_CODE;
    }

    public BigDecimal getMEM_CODE() {
        return MEM_CODE;
    }

    public void setMEM_NO(String MEM_NO) {
        this.MEM_NO = MEM_NO;
    }

    public String getMEM_NO() {
        return MEM_NO;
    }

    public void setMEM_NAME(String MEM_NAME) {
        this.MEM_NAME = MEM_NAME;
    }

    public String getMEM_NAME() {
        return MEM_NAME;
    }

    public void setPol_code(BigDecimal pol_code) {
        this.pol_code = pol_code;
    }

    public BigDecimal getPol_code() {
        return pol_code;
    }

    public void setPol_policy_no(String pol_policy_no) {
        this.pol_policy_no = pol_policy_no;
    }

    public String getPol_policy_no() {
        return pol_policy_no;
    }

    public void setPol_current_endr_code(BigDecimal pol_current_endr_code) {
        this.pol_current_endr_code = pol_current_endr_code;
    }

    public BigDecimal getPol_current_endr_code() {
        return pol_current_endr_code;
    }

    public void setClient(String Client) {
        this.Client = Client;
    }

    public String getClient() {
        return Client;
    }

    public void setMedicalTestDescription(String MedicalTestDescription) {
        this.MedicalTestDescription = MedicalTestDescription;
    }

    public String getMedicalTestDescription() {
        return MedicalTestDescription;
    }

    public void setMTLCode(BigDecimal MTLCode) {
        this.MTLCode = MTLCode;
    }

    public BigDecimal getMTLCode() {
        return MTLCode;
    }

    public void setMTLFees(BigDecimal MTLFees) {
        this.MTLFees = MTLFees;
    }

    public BigDecimal getMTLFees() {
        return MTLFees;
    }

    public void setCML_RESULT_DATE(Date CML_RESULT_DATE) {
        this.CML_RESULT_DATE = CML_RESULT_DATE;
    }

    public Date getCML_RESULT_DATE() {
        return CML_RESULT_DATE;
    }

    public void setMedDetails(String medDetails) {
        this.medDetails = medDetails;
    }

    public String getMedDetails() {
        return medDetails;
    }


    public void setMedqCode(BigDecimal medqCode) {
        this.medqCode = medqCode;
    }

    public BigDecimal getMedqCode() {
        return medqCode;
    }

    public void setMedqDesc(String medqDesc) {
        this.medqDesc = medqDesc;
    }

    public String getMedqDesc() {
        return medqDesc;
    }

    public void setMemName(String memName) {
        this.memName = memName;
    }

    public String getMemName() {
        return memName;
    }
    public void setProdDesc(String prodDesc) {
        this.prodDesc = prodDesc;
    }

    public String getProdDesc() {
        return prodDesc;
    }

    public void setCurSymbol(String curSymbol) {
        this.curSymbol = curSymbol;
    }

    public String getCurSymbol() {
        return curSymbol;
    }

    public void setCurCode(BigDecimal curCode) {
        this.curCode = curCode;
    }

    public BigDecimal getCurCode() {
        return curCode;
    }


    public void setFPMT_CODE(BigDecimal FPMT_CODE) {
        this.FPMT_CODE = FPMT_CODE;
    }

    public BigDecimal getFPMT_CODE() {
        return FPMT_CODE;
    }
}
