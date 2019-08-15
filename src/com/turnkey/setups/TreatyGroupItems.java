package com.turnkey.setups;

import java.math.BigDecimal;

public class TreatyGroupItems {
    public TreatyGroupItems() {
        super();
    }
    
  private BigDecimal TRTG_CODE;
  private String TRTG_SHT_DESC;
  private String TRTG_DESC;
  private String type;

    public void setTRTG_CODE(BigDecimal TRTG_CODE) {
        this.TRTG_CODE = TRTG_CODE;
    }

    public BigDecimal getTRTG_CODE() {
        return TRTG_CODE;
    }

    public void setTRTG_SHT_DESC(String TRTG_SHT_DESC) {
        this.TRTG_SHT_DESC = TRTG_SHT_DESC;
    }

    public String getTRTG_SHT_DESC() {
        return TRTG_SHT_DESC;
    }

    public void setTRTG_DESC(String TRTG_DESC) {
        this.TRTG_DESC = TRTG_DESC;
    }

    public String getTRTG_DESC() {
        return TRTG_DESC;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
