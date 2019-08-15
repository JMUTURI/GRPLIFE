package LMSG.view.TableTypes;

import java.io.Serializable;

import java.math.BigDecimal;

import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class SchoolClasses implements SQLData, Serializable {
    public SchoolClasses() {
        super();
    }
  private BigDecimal SCH_CODE;
  private BigDecimal SCH_FEES;
  private BigDecimal SCH_DURATION;
  private BigDecimal SCH_AV_STUDENTS;
  
  public String getSQLTypeName() {
      return "LMS_CLASSES_LOADING";
  }
  
  public void readSQL(SQLInput stream, String typeName) throws SQLException {
    this.SCH_CODE=stream.readBigDecimal();
    this.SCH_FEES=stream.readBigDecimal();
    this.SCH_DURATION=stream.readBigDecimal();
    this.SCH_AV_STUDENTS=stream.readBigDecimal();
  }
  
  public void writeSQL(SQLOutput stream) throws SQLException {
    stream.writeBigDecimal(SCH_CODE);
    stream.writeBigDecimal(SCH_FEES);
    stream.writeBigDecimal(SCH_DURATION);
    stream.writeBigDecimal(SCH_AV_STUDENTS);
  }

    public void setSCH_CODE(BigDecimal SCH_CODE) {
        this.SCH_CODE = SCH_CODE;
    }

    public BigDecimal getSCH_CODE() {
        return SCH_CODE;
    }

    public void setSCH_FEES(BigDecimal SCH_FEES) {
        this.SCH_FEES = SCH_FEES;
    }

    public BigDecimal getSCH_FEES() {
        return SCH_FEES;
    }

    public void setSCH_DURATION(BigDecimal SCH_DURATION) {
        this.SCH_DURATION = SCH_DURATION;
    }

    public BigDecimal getSCH_DURATION() {
        return SCH_DURATION;
    }

    public void setSCH_AV_STUDENTS(BigDecimal SCH_AV_STUDENTS) {
        this.SCH_AV_STUDENTS = SCH_AV_STUDENTS;
    }

    public BigDecimal getSCH_AV_STUDENTS() {
        return SCH_AV_STUDENTS;
    }
}
