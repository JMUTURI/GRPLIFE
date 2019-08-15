package LMSG.view.TableTypes;

import java.io.Serializable;

import java.math.BigDecimal;

import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class ClaimCovers implements SQLData, Serializable {
    public ClaimCovers() {
        super();
    }
    
  private BigDecimal CCVT_CODE;
    
  public String getSQLTypeName() {
      return "LMS_CLAIM_COVERTYPES_OBJ";
  }
  
  public void writeSQL(SQLOutput stream) throws SQLException {
    stream.writeBigDecimal(CCVT_CODE);
  }
  
  public void readSQL(SQLInput stream, String typeName) throws SQLException {
    this.CCVT_CODE=stream.readBigDecimal();
  }

    public void setCCVT_CODE(BigDecimal CCVT_CODE) {
        this.CCVT_CODE = CCVT_CODE;
    }

    public BigDecimal getCCVT_CODE() {
        return CCVT_CODE;
    }
}
