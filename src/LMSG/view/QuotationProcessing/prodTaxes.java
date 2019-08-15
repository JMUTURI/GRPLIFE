package LMSG.view.QuotationProcessing;

import java.math.BigDecimal;

public class prodTaxes {
  public prodTaxes() 
  {
      
  }
  private BigDecimal TT_CODE,TRT_RATE,TRT_DIVISION_FACTOR,TRT_CODE;
  private String TT_SHT_DESC, TT_DESC,TT_RENEWAL_ENDOS,TRT_RATE_TYPE;

  public void setTT_CODE(BigDecimal TT_CODE) {
    this.TT_CODE = TT_CODE;
  }

  public BigDecimal getTT_CODE() {
    return TT_CODE;
  }

  public void setTRT_RATE(BigDecimal TRT_RATE) {
    this.TRT_RATE = TRT_RATE;
  }

  public BigDecimal getTRT_RATE() {
    return TRT_RATE;
  }

  public void setTRT_DIVISION_FACTOR(BigDecimal TRT_DIVISION_FACTOR) {
    this.TRT_DIVISION_FACTOR = TRT_DIVISION_FACTOR;
  }

  public BigDecimal getTRT_DIVISION_FACTOR() {
    return TRT_DIVISION_FACTOR;
  }

  public void setTRT_CODE(BigDecimal TRT_CODE) {
    this.TRT_CODE = TRT_CODE;
  }

  public BigDecimal getTRT_CODE() {
    return TRT_CODE;
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
}
