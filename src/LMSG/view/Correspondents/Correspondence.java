package LMSG.view.Correspondents;

import java.math.BigDecimal;

public class Correspondence {
    public Correspondence() {
        super();
    }
    private BigDecimal msgCode;
    private String msgShtDesc;
    private String msgDesc;
    
    //message details
    private String CLIENT;
    private String AGN_NAME;
    private String CODE;
    private String VAL;


    public void setMsgCode(BigDecimal msgCode) {
        this.msgCode = msgCode;
    }

    public BigDecimal getMsgCode() {
        return msgCode;
    }

    public void setMsgShtDesc(String msgShtDesc) {
        this.msgShtDesc = msgShtDesc;
    }

    public String getMsgShtDesc() {
        return msgShtDesc;
    }

    public void setMsgDesc(String msgDesc) {
        this.msgDesc = msgDesc;
    }

    public String getMsgDesc() {
        return msgDesc;
    }

    public void setCLIENT(String CLIENT) {
        this.CLIENT = CLIENT;
    }

    public String getCLIENT() {
        return CLIENT;
    }

    public void setAGN_NAME(String AGN_NAME) {
        this.AGN_NAME = AGN_NAME;
    }

    public String getAGN_NAME() {
        return AGN_NAME;
    }

    public void setCODE(String CODE) {
        this.CODE = CODE;
    }

    public String getCODE() {
        return CODE;
    }

    public void setVAL(String VAL) {
        this.VAL = VAL;
    }

    public String getVAL() {
        return VAL;
    }
}
