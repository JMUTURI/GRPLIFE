package LMSG.view.Accounts;

import java.math.BigDecimal;

public class UprBeans {
    
    private BigDecimal utrans_code, utrans_year, utrans_month;
    private String monthName;
    private String type;

    public void setUtrans_code(BigDecimal utrans_code) {
        this.utrans_code = utrans_code;
    }

    public BigDecimal getUtrans_code() {
        return utrans_code;
    }

    public void setUtrans_year(BigDecimal utrans_year) {
        this.utrans_year = utrans_year;
    }

    public BigDecimal getUtrans_year() {
        return utrans_year;
    }

    public void setUtrans_month(BigDecimal utrans_month) {
        this.utrans_month = utrans_month;
    }

    public BigDecimal getUtrans_month() {
        return utrans_month;
    }

    public void setMonthName(String monthName) {
        this.monthName = monthName;
    }

    public String getMonthName() {
        return monthName;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}