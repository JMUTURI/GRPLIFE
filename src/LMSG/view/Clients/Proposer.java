package LMSG.view.Clients;

import java.math.BigDecimal;

public class Proposer {
    public Proposer() {
        super();
    }
    //Proposer Details
    private BigDecimal PRP_CODE, GCO_CODE,  LC_CODE, prp_clnt_code; 
    private String CLIENT,PRP_SHT_DESC,PRP_ID_REG_NO,
           PRP_DOB, GCO_SHT_DESC, GCO_DESC, 
           Hazard;

    public void setPRP_CODE(BigDecimal PRP_CODE) {
        this.PRP_CODE = PRP_CODE;
    }

    public BigDecimal getPRP_CODE() {
        return PRP_CODE;
    }

    public void setGCO_CODE(BigDecimal GCO_CODE) {
        this.GCO_CODE = GCO_CODE;
    }

    public BigDecimal getGCO_CODE() {
        return GCO_CODE;
    }

    public void setLC_CODE(BigDecimal LC_CODE) {
        this.LC_CODE = LC_CODE;
    }

    public BigDecimal getLC_CODE() {
        return LC_CODE;
    }

    public void setCLIENT(String CLIENT) {
        this.CLIENT = CLIENT;
    }

    public String getCLIENT() {
        return CLIENT;
    }

    public void setPRP_SHT_DESC(String PRP_SHT_DESC) {
        this.PRP_SHT_DESC = PRP_SHT_DESC;
    }

    public String getPRP_SHT_DESC() {
        return PRP_SHT_DESC;
    }

    public void setPRP_ID_REG_NO(String PRP_ID_REG_NO) {
        this.PRP_ID_REG_NO = PRP_ID_REG_NO;
    }

    public String getPRP_ID_REG_NO() {
        return PRP_ID_REG_NO;
    }

    public void setPRP_DOB(String PRP_DOB) {
        this.PRP_DOB = PRP_DOB;
    }

    public String getPRP_DOB() {
        return PRP_DOB;
    }

    public void setGCO_SHT_DESC(String GCO_SHT_DESC) {
        this.GCO_SHT_DESC = GCO_SHT_DESC;
    }

    public String getGCO_SHT_DESC() {
        return GCO_SHT_DESC;
    }

    public void setGCO_DESC(String GCO_DESC) {
        this.GCO_DESC = GCO_DESC;
    }

    public String getGCO_DESC() {
        return GCO_DESC;
    }

    public void setHazard(String Hazard) {
        this.Hazard = Hazard;
    }

    public String getHazard() {
        return Hazard;
    }

    public void setPrp_clnt_code(BigDecimal prp_clnt_code) {
        this.prp_clnt_code = prp_clnt_code;
    }

    public BigDecimal getPrp_clnt_code() {
        return prp_clnt_code;
    }
}
