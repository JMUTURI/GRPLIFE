package LMSG.view.TableTypes;

import java.io.Serializable;

import java.math.BigDecimal;

import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class memberRiders implements SQLData, Serializable {
    public memberRiders() {
        super();
    }
    
  private String LGRA_POL_NO;
  private String LGRA_MEM_NO;
  private BigDecimal LGRA_SA;
  private String LGRA_BEN_CODE;
  private String LGRA_BEN_TYPE;
  private BigDecimal LGRA_BEN_SA;
  private BigDecimal LGRA_BEN_RATE;
  private BigDecimal LGRA_BEN_PREM;
    
  public String getSQLTypeName() {
      return "LMS_POL_MEM_RIDER_LOADING";
  }
  
  public void readSQL(SQLInput stream, String typeName) throws SQLException {
    this.LGRA_POL_NO=stream.readString();
    this.LGRA_MEM_NO=stream.readString();
    this.LGRA_SA=stream.readBigDecimal();
    this.LGRA_BEN_CODE=stream.readString();
    this.LGRA_BEN_TYPE=stream.readString();
    this.LGRA_BEN_SA=stream.readBigDecimal();
    this.LGRA_BEN_RATE=stream.readBigDecimal();
    this.LGRA_BEN_PREM=stream.readBigDecimal();
  }
  
  public void writeSQL(SQLOutput stream) throws SQLException {
    stream.writeString(LGRA_POL_NO);
    stream.writeString(LGRA_MEM_NO);
    stream.writeBigDecimal(LGRA_SA);
    stream.writeString(LGRA_BEN_CODE);
    stream.writeString(LGRA_BEN_TYPE);
    stream.writeBigDecimal(LGRA_BEN_SA);
    stream.writeBigDecimal(LGRA_BEN_RATE);
    stream.writeBigDecimal(LGRA_BEN_PREM);

  }

    public void setLGRA_POL_NO(String LGRA_POL_NO) {
        this.LGRA_POL_NO = LGRA_POL_NO;
    }

    public String getLGRA_POL_NO() {
        return LGRA_POL_NO;
    }

    public void setLGRA_MEM_NO(String LGRA_MEM_NO) {
        this.LGRA_MEM_NO = LGRA_MEM_NO;
    }

    public String getLGRA_MEM_NO() {
        return LGRA_MEM_NO;
    }

    public void setLGRA_SA(BigDecimal LGRA_SA) {
        this.LGRA_SA = LGRA_SA;
    }

    public BigDecimal getLGRA_SA() {
        return LGRA_SA;
    }

    public void setLGRA_BEN_CODE(String LGRA_BEN_CODE) {
        this.LGRA_BEN_CODE = LGRA_BEN_CODE;
    }

    public String getLGRA_BEN_CODE() {
        return LGRA_BEN_CODE;
    }

    public void setLGRA_BEN_TYPE(String LGRA_BEN_TYPE) {
        this.LGRA_BEN_TYPE = LGRA_BEN_TYPE;
    }

    public String getLGRA_BEN_TYPE() {
        return LGRA_BEN_TYPE;
    }

    public void setLGRA_BEN_SA(BigDecimal LGRA_BEN_SA) {
        this.LGRA_BEN_SA = LGRA_BEN_SA;
    }

    public BigDecimal getLGRA_BEN_SA() {
        return LGRA_BEN_SA;
    }

    public void setLGRA_BEN_RATE(BigDecimal LGRA_BEN_RATE) {
        this.LGRA_BEN_RATE = LGRA_BEN_RATE;
    }

    public BigDecimal getLGRA_BEN_RATE() {
        return LGRA_BEN_RATE;
    }

    public void setLGRA_BEN_PREM(BigDecimal LGRA_BEN_PREM) {
        this.LGRA_BEN_PREM = LGRA_BEN_PREM;
    }

    public BigDecimal getLGRA_BEN_PREM() {
        return LGRA_BEN_PREM;
    }
}
