package LMSG.view.setups;

import java.math.BigDecimal;

public class PremiumMaskItems {
    public PremiumMaskItems() {
        super();
    }
    //Premium Masks
    private BigDecimal PMAS_CODE;
    private String PMAS_SHT_DESC;
    private String PMAS_DESC;
    private String PMAS_DEFAULT;
    private String PMAS_DEFAULT_DESC;
    private String PMAS_COMMENT;
    private String type;

    public void setPMAS_CODE(BigDecimal PMAS_CODE) {
        this.PMAS_CODE = PMAS_CODE;
    }

    public BigDecimal getPMAS_CODE() {
        return PMAS_CODE;
    }

    public void setPMAS_SHT_DESC(String PMAS_SHT_DESC) {
        this.PMAS_SHT_DESC = PMAS_SHT_DESC;
    }

    public String getPMAS_SHT_DESC() {
        return PMAS_SHT_DESC;
    }

    public void setPMAS_DESC(String PMAS_DESC) {
        this.PMAS_DESC = PMAS_DESC;
    }

    public String getPMAS_DESC() {
        return PMAS_DESC;
    }

    public void setPMAS_DEFAULT(String PMAS_DEFAULT) {
        this.PMAS_DEFAULT = PMAS_DEFAULT;
    }

    public String getPMAS_DEFAULT() {
        return PMAS_DEFAULT;
    }

    public void setPMAS_DEFAULT_DESC(String PMAS_DEFAULT_DESC) {
        this.PMAS_DEFAULT_DESC = PMAS_DEFAULT_DESC;
    }

    public String getPMAS_DEFAULT_DESC() {
        return PMAS_DEFAULT_DESC;
    }

    public void setPMAS_COMMENT(String PMAS_COMMENT) {
        this.PMAS_COMMENT = PMAS_COMMENT;
    }

    public String getPMAS_COMMENT() {
        return PMAS_COMMENT;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
