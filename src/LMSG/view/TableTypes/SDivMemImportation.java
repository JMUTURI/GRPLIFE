package LMSG.view.TableTypes;

import java.io.Serializable;

import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class SDivMemImportation implements SQLData, Serializable {
    public SDivMemImportation() {
        super();
    }
    
  private Integer LMIS_LMIT_CODE;
  private Integer LMIS_LMID_CODE;
  private Integer LMIS_GSUB_CODE;     
  private String LMIS_GSUB_SHT_DESC;
  private String SDPARAMETER_VALS;
  
  public String getSQLTypeName() {
      return "LMS_GRP_MEM_SDIV_IMPORT";
  }
  
  public void readSQL(SQLInput stream, String typeName) throws SQLException {
    this.LMIS_LMIT_CODE=stream.readInt();
    this.LMIS_LMID_CODE=stream.readInt();
    this.LMIS_GSUB_CODE=stream.readInt();
    this.LMIS_GSUB_SHT_DESC=stream.readString();
    this.SDPARAMETER_VALS=stream.readString();
    
  }
  
  public void writeSQL(SQLOutput stream) throws SQLException {
    stream.writeInt(LMIS_LMIT_CODE);
    stream.writeInt(LMIS_LMID_CODE);
    stream.writeInt(LMIS_GSUB_CODE);
    stream.writeString(LMIS_GSUB_SHT_DESC);
    stream.writeString(SDPARAMETER_VALS);
  }

    public void setLMIS_LMIT_CODE(Integer LMIS_LMIT_CODE) {
        this.LMIS_LMIT_CODE = LMIS_LMIT_CODE;
    }

    public Integer getLMIS_LMIT_CODE() {
        return LMIS_LMIT_CODE;
    }

    public void setSDPARAMETER_VALS(String SDPARAMETER_VALS) {
        this.SDPARAMETER_VALS = SDPARAMETER_VALS;
    }

    public String getSDPARAMETER_VALS() {
        return SDPARAMETER_VALS;
    }

    public void setLMIS_LMID_CODE(Integer LMIS_LMID_CODE) {
        this.LMIS_LMID_CODE = LMIS_LMID_CODE;
    }

    public Integer getLMIS_LMID_CODE() {
        return LMIS_LMID_CODE;
    }

    public void setLMIS_GSUB_CODE(Integer LMIS_GSUB_CODE) {
        this.LMIS_GSUB_CODE = LMIS_GSUB_CODE;
    }

    public Integer getLMIS_GSUB_CODE() {
        return LMIS_GSUB_CODE;
    }

    public void setLMIS_GSUB_SHT_DESC(String LMIS_GSUB_SHT_DESC) {
        this.LMIS_GSUB_SHT_DESC = LMIS_GSUB_SHT_DESC;
    }

    public String getLMIS_GSUB_SHT_DESC() {
        return LMIS_GSUB_SHT_DESC;
    }
}
