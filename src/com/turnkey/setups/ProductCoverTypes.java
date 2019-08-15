package com.turnkey.setups;

import java.math.BigDecimal;

public class ProductCoverTypes {
    public ProductCoverTypes() {
        super();
    }
    
  private BigDecimal PCT_CODE;
  private BigDecimal PCT_CVT_CODE;
  private String PCT_CVT_SHT_DESC;
  private String PCT_CVT_DESC; 
  private String type;

    public void setPCT_CODE(BigDecimal PCT_CODE) {
        this.PCT_CODE = PCT_CODE;
    }

    public BigDecimal getPCT_CODE() {
        return PCT_CODE;
    }

    public void setPCT_CVT_CODE(BigDecimal PCT_CVT_CODE) {
        this.PCT_CVT_CODE = PCT_CVT_CODE;
    }

    public BigDecimal getPCT_CVT_CODE() {
        return PCT_CVT_CODE;
    }

    public void setPCT_CVT_SHT_DESC(String PCT_CVT_SHT_DESC) {
        this.PCT_CVT_SHT_DESC = PCT_CVT_SHT_DESC;
    }

    public String getPCT_CVT_SHT_DESC() {
        return PCT_CVT_SHT_DESC;
    }

    public void setPCT_CVT_DESC(String PCT_CVT_DESC) {
        this.PCT_CVT_DESC = PCT_CVT_DESC;
    }

    public String getPCT_CVT_DESC() {
        return PCT_CVT_DESC;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
