package LMSG.view.setups;

import java.math.BigDecimal;

public class arrangementSetups {
    public arrangementSetups() {
        super();
    }
    private BigDecimal AS_UWYR;
    private BigDecimal AS_CODE;
    private BigDecimal AS_TA_CODE;
    private BigDecimal AS_RETENTION_LIMIT;

    public void setAS_UWYR(BigDecimal AS_UWYR) {
        this.AS_UWYR = AS_UWYR;
    }

    public BigDecimal getAS_UWYR() {
        return AS_UWYR;
    }

    public void setAS_CODE(BigDecimal AS_CODE) {
        this.AS_CODE = AS_CODE;
    }

    public BigDecimal getAS_CODE() {
        return AS_CODE;
    }

    public void setAS_TA_CODE(BigDecimal AS_TA_CODE) {
        this.AS_TA_CODE = AS_TA_CODE;
    }

    public BigDecimal getAS_TA_CODE() {
        return AS_TA_CODE;
    }

    public void setAS_RETENTION_LIMIT(BigDecimal AS_RETENTION_LIMIT) {
        this.AS_RETENTION_LIMIT = AS_RETENTION_LIMIT;
    }

    public BigDecimal getAS_RETENTION_LIMIT() {
        return AS_RETENTION_LIMIT;
    }
}
