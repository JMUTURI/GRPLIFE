package LMSG.view.TableTypes;

import java.io.Serializable;

import java.math.BigDecimal;

import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class ConvertCategories implements SQLData, Serializable {
    public ConvertCategories() {
        super();
    }
    
  private BigDecimal CAT_CODE;
  private String CAT_DESC;
  
  public String getSQLTypeName() {
      return "LMS_CONVERT_CATEGORIES";
  }
  
  public void readSQL(SQLInput stream, String typeName) throws SQLException {
    this.CAT_CODE=stream.readBigDecimal();
    this.CAT_DESC=stream.readString();
    
  }
  
  public void writeSQL(SQLOutput stream) throws SQLException {
    stream.writeBigDecimal(CAT_CODE);
    stream.writeString(CAT_DESC);
  }

    public void setCAT_CODE(BigDecimal CAT_CODE) {
        this.CAT_CODE = CAT_CODE;
    }

    public BigDecimal getCAT_CODE() {
        return CAT_CODE;
    }

    public void setCAT_DESC(String CAT_DESC) {
        this.CAT_DESC = CAT_DESC;
    }

    public String getCAT_DESC() {
        return CAT_DESC;
    }
}
