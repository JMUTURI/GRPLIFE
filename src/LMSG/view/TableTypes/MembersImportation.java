package LMSG.view.TableTypes;

import java.io.Serializable;

import java.math.BigDecimal;

import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class MembersImportation implements SQLData, Serializable {
    public MembersImportation() {
        super();
    }
    
  private Integer LMID_LMIT_CODE;
  private String PARAMETER_VALS;
    
  public String getSQLTypeName() {
      return "LMS_GRP_MEM_IMPORT";
  }
  
  public void readSQL(SQLInput stream, String typeName) throws SQLException {
    this.LMID_LMIT_CODE=stream.readInt();
    this.PARAMETER_VALS=stream.readString();
    
  }
  
  public void writeSQL(SQLOutput stream) throws SQLException {
    stream.writeInt(LMID_LMIT_CODE);
    stream.writeString(PARAMETER_VALS);
  }

    public void setLMID_LMIT_CODE(Integer LMID_LMIT_CODE) {
        this.LMID_LMIT_CODE = LMID_LMIT_CODE;
    }

    public Integer getLMID_LMIT_CODE() {
        return LMID_LMIT_CODE;
    }


    public void setPARAMETER_VALS(String PARAMETER_VALS) {
        this.PARAMETER_VALS = PARAMETER_VALS;
    }

    public String getPARAMETER_VALS() {
        return PARAMETER_VALS;
    }
}
