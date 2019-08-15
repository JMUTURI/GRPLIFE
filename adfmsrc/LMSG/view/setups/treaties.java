package LMSG.view.setups;

import java.math.BigDecimal;

public class treaties {
    public treaties() {
        super();
    }
    private BigDecimal TRS_CODE, TRS_TRT_CODE;
    private String TRS_SHT_DESC, TRS_TRT_SHT_DESC;

    public void setTRS_CODE(BigDecimal TRS_CODE) {
        this.TRS_CODE = TRS_CODE;
    }

    public BigDecimal getTRS_CODE() {
        return TRS_CODE;
    }

    public void setTRS_TRT_CODE(BigDecimal TRS_TRT_CODE) {
        this.TRS_TRT_CODE = TRS_TRT_CODE;
    }

    public BigDecimal getTRS_TRT_CODE() {
        return TRS_TRT_CODE;
    }

    public void setTRS_SHT_DESC(String TRS_SHT_DESC) {
        this.TRS_SHT_DESC = TRS_SHT_DESC;
    }

    public String getTRS_SHT_DESC() {
        return TRS_SHT_DESC;
    }

    public void setTRS_TRT_SHT_DESC(String TRS_TRT_SHT_DESC) {
        this.TRS_TRT_SHT_DESC = TRS_TRT_SHT_DESC;
    }

    public String getTRS_TRT_SHT_DESC() {
        return TRS_TRT_SHT_DESC;
    }
}
