package com.turnkey.setups;

import java.math.BigDecimal;

public class SchoolClassItems {
    public SchoolClassItems() {
        super();
    }
    
  private BigDecimal SCH_CODE;
  private String SCH_SHT_DESC;
  private String SCH_DESC;
  private BigDecimal SCH_PERIOD;
  private BigDecimal SCH_LEVEL;
  private String type;

    public void setSCH_CODE(BigDecimal SCH_CODE) {
        this.SCH_CODE = SCH_CODE;
    }

    public BigDecimal getSCH_CODE() {
        return SCH_CODE;
    }

    public void setSCH_SHT_DESC(String SCH_SHT_DESC) {
        this.SCH_SHT_DESC = SCH_SHT_DESC;
    }

    public String getSCH_SHT_DESC() {
        return SCH_SHT_DESC;
    }

    public void setSCH_DESC(String SCH_DESC) {
        this.SCH_DESC = SCH_DESC;
    }

    public String getSCH_DESC() {
        return SCH_DESC;
    }

    public void setSCH_PERIOD(BigDecimal SCH_PERIOD) {
        this.SCH_PERIOD = SCH_PERIOD;
    }

    public BigDecimal getSCH_PERIOD() {
        return SCH_PERIOD;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setSCH_LEVEL(BigDecimal SCH_LEVEL) {
        this.SCH_LEVEL = SCH_LEVEL;
    }

    public BigDecimal getSCH_LEVEL() {
        return SCH_LEVEL;
    }
}
