package LMSG.view.TableTypes;

import java.io.Serializable;

import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class PolicyCoinsurers implements SQLData {
    private String LGCA_SCHEME;
    private String LGCA_CO_SHARE;
    private String LGCA_COINSURER;
    private String LGCA_COIN_SHARE;
    private String LGCA_POL_NO;
    
    
    public PolicyCoinsurers() {
        super();
    }

    public String getSQLTypeName() throws SQLException {
      return "LMS_POL_COIN_LOADING";
    }

    public void readSQL(SQLInput stream, String typeName) throws SQLException {
      this.LGCA_SCHEME=stream.readString();
      this.LGCA_CO_SHARE=stream.readString();
      this.LGCA_COINSURER=stream.readString();
      this.LGCA_COIN_SHARE=stream.readString();
      this.LGCA_POL_NO=stream.readString();
    }

    public void writeSQL(SQLOutput stream) throws SQLException {
      stream.writeString(LGCA_SCHEME);
      stream.writeString(LGCA_CO_SHARE);
      stream.writeString(LGCA_COINSURER);
      stream.writeString(LGCA_COIN_SHARE);
      stream.writeString(LGCA_POL_NO);
    }

    public void setLGCA_SCHEME(String LGCA_SCHEME) {
        this.LGCA_SCHEME = LGCA_SCHEME;
    }

    public String getLGCA_SCHEME() {
        return LGCA_SCHEME;
    }

    public void setLGCA_CO_SHARE(String LGCA_CO_SHARE) {
        this.LGCA_CO_SHARE = LGCA_CO_SHARE;
    }

    public String getLGCA_CO_SHARE() {
        return LGCA_CO_SHARE;
    }

    public void setLGCA_COINSURER(String LGCA_COINSURER) {
        this.LGCA_COINSURER = LGCA_COINSURER;
    }

    public String getLGCA_COINSURER() {
        return LGCA_COINSURER;
    }

    public void setLGCA_COIN_SHARE(String LGCA_COIN_SHARE) {
        this.LGCA_COIN_SHARE = LGCA_COIN_SHARE;
    }

    public String getLGCA_COIN_SHARE() {
        return LGCA_COIN_SHARE;
    }

    public void setLGCA_POL_NO(String LGCA_POL_NO) {
        this.LGCA_POL_NO = LGCA_POL_NO;
    }

    public String getLGCA_POL_NO() {
        return LGCA_POL_NO;
    }
}
