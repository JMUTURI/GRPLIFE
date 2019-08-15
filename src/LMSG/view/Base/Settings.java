package LMSG.view.Base;

import java.math.BigDecimal;

import java.util.Date;

public class Settings {
  public Settings() {
  }

  public static Date toDay = new Date();

  //Dependants
  private BigDecimal DTY_CODE;
  private String DTY_SHT_DESC;
  private String DTY_DESCRIPTION;

  private String trt_rate;
  private String trt_division_factor;

  private String CVT_DESC;

  //Occupations
  private BigDecimal Gco_code;
  private String GCO_DESC;

  private BigDecimal GSUB_CODE;
  private String GSUB_SHT_DESC;
  private String GSUB_DESC;

  //Activities
  private BigDecimal ACT_CODE;
  private String ACT_ACTIVITY;
  private BigDecimal FACT_CODE;


  //Taxes
  private BigDecimal TT_CODE;
  private String TT_SHT_DESC;
  private String TT_DESC;
  private String TRT_RATE;
  private String TRT_DIVISION_FACTOR;
  private String TT_RENEWAL_ENDOS;
  private String TRT_RATE_TYPE;
  private BigDecimal TRT_CODE;

  //System Dste
  private Date SysDate;

  //Facilitators
  private BigDecimal FAC_CODE;
  private String FAC_NAME;
  private String FAC_POST_ADD;
  private String FAC_TOWN;
  private String FAC_COUNTRY;

  //Branches
  private BigDecimal BRN_CODE;
  private String BRN_SHT_DESC;
  private String BRN_NAME;

  //Agent Details
  private BigDecimal AGN_CODE;
  private String AGN_NAME;
  private String AGN_SHT_DESC;
  private String AGN_POSTAL_ADDRESS;
  private String Agent;

  //Coinsurer Details
  private BigDecimal CO_agn_code;
  private String CO_agn_name;

  //Medical Facilitators

  private BigDecimal SPR_CODE;
  private String SPR_SHT_DESC;
  private String SPR_NAME;
  private BigDecimal SPR_SPT_CODE;
  private String TWN_NAME;

  //Deductions
  private BigDecimal DD_tt_code;
  private String DD_tt_sht_desc;
  private String DD_tt_type;
  private String DD_tt_applicable_at_prod;
  private String DD_tt_renewal_endos;
  private String DD_tt_application_level;

  //clients
  private BigDecimal CountryCode;
  private String CountryShtDesc;
  private String CountryName;
  private BigDecimal TownCode;
  private String postalDesc;
  private String TownShtDesc;
  private String TownName;
  private String PostalZIPCode;
  private String SectorShtDesc;
  private String SectorName;
  private BigDecimal SectorCode;

  //Payee Service Providers
  private String PAYEE_SPR_NAME;
  private BigDecimal PAYEE_SPT_CODE;

  //Users
  private BigDecimal USR_CODE;
  private String USR_NAME;
  private String USR_USERNAME;

  //states
  private BigDecimal STS_CODE;
  private BigDecimal STS_COU_CODE;
  private String STS_SHT_DESC;
  private String STS_NAME;


  private String SPR_PHYSICAL_ADDRESS;
  private String SPR_POSTAL_ADDRESS;
  private String SPT_NAME;
  private String SPR_PHONE;
  private String SPR_CONTACT_PERSON;
  private String SPR_CONTACT_PERSON_PHONE;
  private Date SPR_WEF;
  private Date SPR_WET;

  //Premium rate loadings
  private BigDecimal poctl_code, poctl_rate, poctl_rate_div_factor;
  private String cvtDesc, poctl_name, qoctl_name;
  //Quotation premium rate loadings
  private BigDecimal qoctl_code, qoctl_rate, qoctl_rate_div_factor;
  private BigDecimal pctl_code, pctl_rate, pctl_rate_div_factor;
  private String pctl_name, pctl_rate_type;
  private String pctl_load_method, pctl_load_desc;
  private BigDecimal emd_code;
  private String emd_msgt_narr, emd_rpt_name, usr_email;

  //SBU and Location
  private BigDecimal SBU_CODE;
  private String SBU;
  private BigDecimal SPOKE_CODE;
  private String SPOKE;
  private BigDecimal COVERAGE_AREA_CODE;
  private String COVERAGE_AREA;
  private BigDecimal LOCATION_CODE;
  private String LOCATION;
  private String ORGANIZATION;
  private BigDecimal prodCode;
  private String prodDesc;



  public void setDTY_CODE(BigDecimal DTY_CODE) {
    this.DTY_CODE = DTY_CODE;
  }

  public BigDecimal getDTY_CODE() {
    return DTY_CODE;
  }

  public void setDTY_SHT_DESC(String DTY_SHT_DESC) {
    this.DTY_SHT_DESC = DTY_SHT_DESC;
  }

  public String getDTY_SHT_DESC() {
    return DTY_SHT_DESC;
  }

  public void setDTY_DESCRIPTION(String DTY_DESCRIPTION) {
    this.DTY_DESCRIPTION = DTY_DESCRIPTION;
  }

  public String getDTY_DESCRIPTION() {
    return DTY_DESCRIPTION;
  }

  public void setGco_code(BigDecimal Gco_code) {
    this.Gco_code = Gco_code;
  }

  public BigDecimal getGco_code() {
    return Gco_code;
  }

  public void setGCO_DESC(String GCO_DESC) {
    this.GCO_DESC = GCO_DESC;
  }

  public String getGCO_DESC() {
    return GCO_DESC;
  }

  public void setTT_CODE(BigDecimal TT_CODE) {
    this.TT_CODE = TT_CODE;
  }

  public BigDecimal getTT_CODE() {
    return TT_CODE;
  }

  public void setTT_SHT_DESC(String TT_SHT_DESC) {
    this.TT_SHT_DESC = TT_SHT_DESC;
  }

  public String getTT_SHT_DESC() {
    return TT_SHT_DESC;
  }

  public void setTT_DESC(String TT_DESC) {
    this.TT_DESC = TT_DESC;
  }

  public String getTT_DESC() {
    return TT_DESC;
  }

  public void setTRT_RATE(String TRT_RATE) {
    this.TRT_RATE = TRT_RATE;
  }

  public String getTRT_RATE() {
    return TRT_RATE;
  }

  public void setTRT_DIVISION_FACTOR(String TRT_DIVISION_FACTOR) {
    this.TRT_DIVISION_FACTOR = TRT_DIVISION_FACTOR;
  }

  public String getTRT_DIVISION_FACTOR() {
    return TRT_DIVISION_FACTOR;
  }

  public void setTT_RENEWAL_ENDOS(String TT_RENEWAL_ENDOS) {
    this.TT_RENEWAL_ENDOS = TT_RENEWAL_ENDOS;
  }

  public String getTT_RENEWAL_ENDOS() {
    return TT_RENEWAL_ENDOS;
  }

  public void setTRT_RATE_TYPE(String TRT_RATE_TYPE) {
    this.TRT_RATE_TYPE = TRT_RATE_TYPE;
  }

  public String getTRT_RATE_TYPE() {
    return TRT_RATE_TYPE;
  }

  public void setTRT_CODE(BigDecimal TRT_CODE) {
    this.TRT_CODE = TRT_CODE;
  }

  public BigDecimal getTRT_CODE() {
    return TRT_CODE;
  }

  public void setSysDate(Date SysDate) {
    this.SysDate = SysDate;
  }

  public Date getSysDate() {
    return SysDate;
  }

  public void setFAC_CODE(BigDecimal FAC_CODE) {
    this.FAC_CODE = FAC_CODE;
  }

  public BigDecimal getFAC_CODE() {
    return FAC_CODE;
  }

  public void setFAC_NAME(String FAC_NAME) {
    this.FAC_NAME = FAC_NAME;
  }

  public String getFAC_NAME() {
    return FAC_NAME;
  }

  public void setFAC_POST_ADD(String FAC_POST_ADD) {
    this.FAC_POST_ADD = FAC_POST_ADD;
  }

  public String getFAC_POST_ADD() {
    return FAC_POST_ADD;
  }

  public void setFAC_TOWN(String FAC_TOWN) {
    this.FAC_TOWN = FAC_TOWN;
  }

  public String getFAC_TOWN() {
    return FAC_TOWN;
  }

  public void setFAC_COUNTRY(String FAC_COUNTRY) {
    this.FAC_COUNTRY = FAC_COUNTRY;
  }

  public String getFAC_COUNTRY() {
    return FAC_COUNTRY;
  }

  public void setACT_CODE(BigDecimal ACT_CODE) {
    this.ACT_CODE = ACT_CODE;
  }

  public BigDecimal getACT_CODE() {
    return ACT_CODE;
  }

  public void setACT_ACTIVITY(String ACT_ACTIVITY) {
    this.ACT_ACTIVITY = ACT_ACTIVITY;
  }

  public String getACT_ACTIVITY() {
    return ACT_ACTIVITY;
  }

  public void setFACT_CODE(BigDecimal FACT_CODE) {
    this.FACT_CODE = FACT_CODE;
  }

  public BigDecimal getFACT_CODE() {
    return FACT_CODE;
  }

  public void setBRN_CODE(BigDecimal BRN_CODE) {
    this.BRN_CODE = BRN_CODE;
  }

  public BigDecimal getBRN_CODE() {
    return BRN_CODE;
  }

  public void setBRN_SHT_DESC(String BRN_SHT_DESC) {
    this.BRN_SHT_DESC = BRN_SHT_DESC;
  }

  public String getBRN_SHT_DESC() {
    return BRN_SHT_DESC;
  }

  public void setBRN_NAME(String BRN_NAME) {
    this.BRN_NAME = BRN_NAME;
  }

  public String getBRN_NAME() {
    return BRN_NAME;
  }

  public void setAGN_CODE(BigDecimal AGN_CODE) {
    this.AGN_CODE = AGN_CODE;
  }

  public BigDecimal getAGN_CODE() {
    return AGN_CODE;
  }

  public void setAGN_NAME(String AGN_NAME) {
    this.AGN_NAME = AGN_NAME;
  }

  public String getAGN_NAME() {
    return AGN_NAME;
  }

  public void setAGN_SHT_DESC(String AGN_SHT_DESC) {
    this.AGN_SHT_DESC = AGN_SHT_DESC;
  }

  public String getAGN_SHT_DESC() {
    return AGN_SHT_DESC;
  }

  public void setAGN_POSTAL_ADDRESS(String AGN_POSTAL_ADDRESS) {
    this.AGN_POSTAL_ADDRESS = AGN_POSTAL_ADDRESS;
  }

  public String getAGN_POSTAL_ADDRESS() {
    return AGN_POSTAL_ADDRESS;
  }

  public void setAgent(String Agent) {
    this.Agent = Agent;
  }

  public String getAgent() {
    return Agent;
  }

  public void setCO_agn_code(BigDecimal CO_agn_code) {
    this.CO_agn_code = CO_agn_code;
  }

  public BigDecimal getCO_agn_code() {
    return CO_agn_code;
  }

  public void setCO_agn_name(String CO_agn_name) {
    this.CO_agn_name = CO_agn_name;
  }

  public String getCO_agn_name() {
    return CO_agn_name;
  }

  public void setSPR_CODE(BigDecimal SPR_CODE) {
    this.SPR_CODE = SPR_CODE;
  }

  public BigDecimal getSPR_CODE() {
    return SPR_CODE;
  }

  public void setSPR_SHT_DESC(String SPR_SHT_DESC) {
    this.SPR_SHT_DESC = SPR_SHT_DESC;
  }

  public String getSPR_SHT_DESC() {
    return SPR_SHT_DESC;
  }

  public void setSPR_NAME(String SPR_NAME) {
    this.SPR_NAME = SPR_NAME;
  }

  public String getSPR_NAME() {
    return SPR_NAME;
  }

  public void setSPR_SPT_CODE(BigDecimal SPR_SPT_CODE) {
    this.SPR_SPT_CODE = SPR_SPT_CODE;
  }

  public BigDecimal getSPR_SPT_CODE() {
    return SPR_SPT_CODE;
  }

  public void setTWN_NAME(String TWN_NAME) {
    this.TWN_NAME = TWN_NAME;
  }

  public String getTWN_NAME() {
    return TWN_NAME;
  }

  public void setToDay(Date toDay) {
    Settings.toDay = toDay;
  }

  public Date getToDay() {
    return toDay;
  }

  public void setDD_tt_code(BigDecimal DD_tt_code) {
    this.DD_tt_code = DD_tt_code;
  }

  public BigDecimal getDD_tt_code() {
    return DD_tt_code;
  }

  public void setDD_tt_sht_desc(String DD_tt_sht_desc) {
    this.DD_tt_sht_desc = DD_tt_sht_desc;
  }

  public String getDD_tt_sht_desc() {
    return DD_tt_sht_desc;
  }

  public void setDD_tt_type(String DD_tt_type) {
    this.DD_tt_type = DD_tt_type;
  }

  public String getDD_tt_type() {
    return DD_tt_type;
  }

  public void setDD_tt_applicable_at_prod(String DD_tt_applicable_at_prod) {
    this.DD_tt_applicable_at_prod = DD_tt_applicable_at_prod;
  }

  public String getDD_tt_applicable_at_prod() {
    return DD_tt_applicable_at_prod;
  }

  public void setDD_tt_renewal_endos(String DD_tt_renewal_endos) {
    this.DD_tt_renewal_endos = DD_tt_renewal_endos;
  }

  public String getDD_tt_renewal_endos() {
    return DD_tt_renewal_endos;
  }

  public void setDD_tt_application_level(String DD_tt_application_level) {
    this.DD_tt_application_level = DD_tt_application_level;
  }

  public String getDD_tt_application_level() {
    return DD_tt_application_level;
  }

  public void setCountryCode(BigDecimal CountryCode) {
    this.CountryCode = CountryCode;
  }

  public BigDecimal getCountryCode() {
    return CountryCode;
  }

  public void setCountryShtDesc(String CountryShtDesc) {
    this.CountryShtDesc = CountryShtDesc;
  }

  public String getCountryShtDesc() {
    return CountryShtDesc;
  }

  public void setCountryName(String CountryName) {
    this.CountryName = CountryName;
  }

  public String getCountryName() {
    return CountryName;
  }

  public void setTownCode(BigDecimal TownCode) {
    this.TownCode = TownCode;
  }

  public BigDecimal getTownCode() {
    return TownCode;
  }

  public void setPostalDesc(String postalDesc) {
    this.postalDesc = postalDesc;
  }

  public String getPostalDesc() {
    return postalDesc;
  }

  public void setTownShtDesc(String TownShtDesc) {
    this.TownShtDesc = TownShtDesc;
  }

  public String getTownShtDesc() {
    return TownShtDesc;
  }

  public void setTownName(String TownName) {
    this.TownName = TownName;
  }

  public String getTownName() {
    return TownName;
  }

  public void setPostalZIPCode(String PostalZIPCode) {
    this.PostalZIPCode = PostalZIPCode;
  }

  public String getPostalZIPCode() {
    return PostalZIPCode;
  }

  public void setSectorShtDesc(String SectorShtDesc) {
    this.SectorShtDesc = SectorShtDesc;
  }

  public String getSectorShtDesc() {
    return SectorShtDesc;
  }

  public void setSectorName(String SectorName) {
    this.SectorName = SectorName;
  }

  public String getSectorName() {
    return SectorName;
  }

  public void setSectorCode(BigDecimal SectorCode) {
    this.SectorCode = SectorCode;
  }

  public BigDecimal getSectorCode() {
    return SectorCode;
  }

  public void setPAYEE_SPT_CODE(BigDecimal PAYEE_SPT_CODE) {
    this.PAYEE_SPT_CODE = PAYEE_SPT_CODE;
  }

  public BigDecimal getPAYEE_SPT_CODE() {
    return PAYEE_SPT_CODE;
  }

  public void setPAYEE_SPR_NAME(String PAYEE_SPR_NAME) {
    this.PAYEE_SPR_NAME = PAYEE_SPR_NAME;
  }

  public String getPAYEE_SPR_NAME() {
    return PAYEE_SPR_NAME;
  }

  public void setUSR_CODE(BigDecimal USR_CODE) {
    this.USR_CODE = USR_CODE;
  }

  public BigDecimal getUSR_CODE() {
    return USR_CODE;
  }

  public void setUSR_NAME(String USR_NAME) {
    this.USR_NAME = USR_NAME;
  }

  public String getUSR_NAME() {
    return USR_NAME;
  }

  public void setUSR_USERNAME(String USR_USERNAME) {
    this.USR_USERNAME = USR_USERNAME;
  }

  public String getUSR_USERNAME() {
    return USR_USERNAME;
  }

  public void setSTS_CODE(BigDecimal STS_CODE) {
    this.STS_CODE = STS_CODE;
  }

  public BigDecimal getSTS_CODE() {
    return STS_CODE;
  }

  public void setSTS_COU_CODE(BigDecimal STS_COU_CODE) {
    this.STS_COU_CODE = STS_COU_CODE;
  }

  public BigDecimal getSTS_COU_CODE() {
    return STS_COU_CODE;
  }

  public void setSTS_SHT_DESC(String STS_SHT_DESC) {
    this.STS_SHT_DESC = STS_SHT_DESC;
  }

  public String getSTS_SHT_DESC() {
    return STS_SHT_DESC;
  }

  public void setSTS_NAME(String STS_NAME) {
    this.STS_NAME = STS_NAME;
  }

  public String getSTS_NAME() {
    return STS_NAME;
  }

  public void setSPR_PHYSICAL_ADDRESS(String SPR_PHYSICAL_ADDRESS) {
    this.SPR_PHYSICAL_ADDRESS = SPR_PHYSICAL_ADDRESS;
  }

  public String getSPR_PHYSICAL_ADDRESS() {
    return SPR_PHYSICAL_ADDRESS;
  }

  public void setSPR_POSTAL_ADDRESS(String SPR_POSTAL_ADDRESS) {
    this.SPR_POSTAL_ADDRESS = SPR_POSTAL_ADDRESS;
  }

  public String getSPR_POSTAL_ADDRESS() {
    return SPR_POSTAL_ADDRESS;
  }

  public void setSPT_NAME(String SPT_NAME) {
    this.SPT_NAME = SPT_NAME;
  }

  public String getSPT_NAME() {
    return SPT_NAME;
  }

  public void setTrt_division_factor(String trt_division_factor) {
    this.trt_division_factor = trt_division_factor;
  }

  public String getTrt_division_factor() {
    return trt_division_factor;
  }

  public void setTrt_rate(String trt_rate) {
    this.trt_rate = trt_rate;
  }

  public String getTrt_rate() {
    return trt_rate;
  }

  public void setGSUB_CODE(BigDecimal GSUB_CODE) {
    this.GSUB_CODE = GSUB_CODE;
  }

  public BigDecimal getGSUB_CODE() {
    return GSUB_CODE;
  }

  public void setGSUB_SHT_DESC(String GSUB_SHT_DESC) {
    this.GSUB_SHT_DESC = GSUB_SHT_DESC;
  }

  public String getGSUB_SHT_DESC() {
    return GSUB_SHT_DESC;
  }

  public void setGSUB_DESC(String GSUB_DESC) {
    this.GSUB_DESC = GSUB_DESC;
  }

  public String getGSUB_DESC() {
    return GSUB_DESC;
  }

  public void setCVT_DESC(String CVT_DESC) {
    this.CVT_DESC = CVT_DESC;
  }

  public String getCVT_DESC() {
    return CVT_DESC;
  }

  public void setSPR_PHONE(String SPR_PHONE) {
    this.SPR_PHONE = SPR_PHONE;
  }

  public String getSPR_PHONE() {
    return SPR_PHONE;
  }

  public void setSPR_CONTACT_PERSON(String SPR_CONTACT_PERSON) {
    this.SPR_CONTACT_PERSON = SPR_CONTACT_PERSON;
  }

  public String getSPR_CONTACT_PERSON() {
    return SPR_CONTACT_PERSON;
  }

  public void setSPR_CONTACT_PERSON_PHONE(String SPR_CONTACT_PERSON_PHONE) {
    this.SPR_CONTACT_PERSON_PHONE = SPR_CONTACT_PERSON_PHONE;
  }

  public String getSPR_CONTACT_PERSON_PHONE() {
    return SPR_CONTACT_PERSON_PHONE;
  }

  public void setSPR_WEF(Date SPR_WEF) {
    this.SPR_WEF = SPR_WEF;
  }

  public Date getSPR_WEF() {
    return SPR_WEF;
  }

  public void setSPR_WET(Date SPR_WET) {
    this.SPR_WET = SPR_WET;
  }

  public Date getSPR_WET() {
    return SPR_WET;
  }

  public void setPoctl_code(BigDecimal poctl_code) {
    this.poctl_code = poctl_code;
  }

  public BigDecimal getPoctl_code() {
    return poctl_code;
  }

  public void setPoctl_rate(BigDecimal poctl_rate) {
    this.poctl_rate = poctl_rate;
  }

  public BigDecimal getPoctl_rate() {
    return poctl_rate;
  }

  public void setPoctl_rate_div_factor(BigDecimal poctl_rate_div_factor) {
    this.poctl_rate_div_factor = poctl_rate_div_factor;
  }

  public BigDecimal getPoctl_rate_div_factor() {
    return poctl_rate_div_factor;
  }

  public void setCvtDesc(String cvtDesc) {
    this.cvtDesc = cvtDesc;
  }

  public String getCvtDesc() {
    return cvtDesc;
  }

  public void setPoctl_name(String poctl_name) {
    this.poctl_name = poctl_name;
  }

  public String getPoctl_name() {
    return poctl_name;
  }

  public void setQoctl_code(BigDecimal qoctl_code) {
    this.qoctl_code = qoctl_code;
  }

  public BigDecimal getQoctl_code() {
    return qoctl_code;
  }

  public void setQoctl_rate(BigDecimal qoctl_rate) {
    this.qoctl_rate = qoctl_rate;
  }

  public BigDecimal getQoctl_rate() {
    return qoctl_rate;
  }

  public void setQoctl_rate_div_factor(BigDecimal qoctl_rate_div_factor) {
    this.qoctl_rate_div_factor = qoctl_rate_div_factor;
  }

  public BigDecimal getQoctl_rate_div_factor() {
    return qoctl_rate_div_factor;
  }

  public void setQoctl_name(String qoctl_name) {
    this.qoctl_name = qoctl_name;
  }

  public String getQoctl_name() {
    return qoctl_name;
  }

  public void setPctl_code(BigDecimal pctl_code) {
    this.pctl_code = pctl_code;
  }

  public BigDecimal getPctl_code() {
    return pctl_code;
  }

  public void setPctl_rate(BigDecimal pctl_rate) {
    this.pctl_rate = pctl_rate;
  }

  public BigDecimal getPctl_rate() {
    return pctl_rate;
  }

  public void setPctl_rate_div_factor(BigDecimal pctl_rate_div_factor) {
    this.pctl_rate_div_factor = pctl_rate_div_factor;
  }

  public BigDecimal getPctl_rate_div_factor() {
    return pctl_rate_div_factor;
  }

  public void setPctl_name(String pctl_name) {
    this.pctl_name = pctl_name;
  }

  public String getPctl_name() {
    return pctl_name;
  }

  public void setPctl_rate_type(String pctl_rate_type) {
    this.pctl_rate_type = pctl_rate_type;
  }

  public String getPctl_rate_type() {
    return pctl_rate_type;
  }

  public void setPctl_load_method(String pctl_load_method) {
    this.pctl_load_method = pctl_load_method;
  }

  public String getPctl_load_method() {
    return pctl_load_method;
  }

  public void setPctl_load_desc(String pctl_load_desc) {
    this.pctl_load_desc = pctl_load_desc;
  }

  public String getPctl_load_desc() {
    return pctl_load_desc;
  }

  public void setEmd_code(BigDecimal emd_code) {
    this.emd_code = emd_code;
  }

  public BigDecimal getEmd_code() {
    return emd_code;
  }

  public void setEmd_msgt_narr(String emd_msgt_narr) {
    this.emd_msgt_narr = emd_msgt_narr;
  }

  public String getEmd_msgt_narr() {
    return emd_msgt_narr;
  }

  public void setEmd_rpt_name(String emd_rpt_name) {
    this.emd_rpt_name = emd_rpt_name;
  }

  public String getEmd_rpt_name() {
    return emd_rpt_name;
  }

  public void setUsr_email(String usr_email) {
    this.usr_email = usr_email;
  }

  public String getUsr_email() {
    return usr_email;
  }

  public void setSBU_CODE(BigDecimal SBU_CODE) {
    this.SBU_CODE = SBU_CODE;
  }

  public BigDecimal getUSB_CODE() {
    return SBU_CODE;
  }

  public void setSBU(String SBU) {
    this.SBU = SBU;
  }

  public String getUSB() {
    return SBU;
  }

  public void setCOVERAGE_AREA_CODE(BigDecimal COVERAGE_AREA_CODE) {
    this.COVERAGE_AREA_CODE = COVERAGE_AREA_CODE;
  }

  public String getCOVERAGE_AREA() {
    return COVERAGE_AREA;
  }

   public void setSPOKE_CODE(BigDecimal SPOKE_CODE) {
     this.SPOKE_CODE=SPOKE_CODE;
  }

  public void setSPOKE(String SPOKE) {
    this.SPOKE=SPOKE;
  }

 public void setCOVERAGE_AREA(String COVERAGE_AREA) {
   this.COVERAGE_AREA=COVERAGE_AREA;
  }

  public void setLOCATION_CODE(BigDecimal LOCATION_CODE) {
    this.LOCATION_CODE = LOCATION_CODE;
  }

  public BigDecimal getLOCATION_CODE() {
    return LOCATION_CODE;
  }

  public void setLOCATION(String LOCATION) {
    this.LOCATION = LOCATION;
  }

  public String getLOCATION() {
    return LOCATION;
  }

  public void setORGANIZATION(String ORGANIZATION) {
    this.ORGANIZATION = ORGANIZATION;
  }

  public String getORGANIZATION() {
    return ORGANIZATION;
  }

    public void setProdCode(BigDecimal prodCode) {
        this.prodCode = prodCode;
    }

    public BigDecimal getProdCode() {
        return prodCode;
    }

    public void setProdDesc(String prodDesc) {
        this.prodDesc = prodDesc;
    }

    public String getProdDesc() {
        return prodDesc;
    }
}
