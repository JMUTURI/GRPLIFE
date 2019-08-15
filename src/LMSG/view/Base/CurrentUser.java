package LMSG.view.Base;

import java.math.BigDecimal;

import java.util.Date;

import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

public class CurrentUser {
  public CurrentUser() {
  }
  private BigDecimal UserCode;
  private String Username;
  private String tasks;
  private int tasksCount;
  private Date LoginDate;
  private BigDecimal currencyCode;
  private String currencySymbol;
  private int selectedCurrency;
  
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);


  public void setUserCode(BigDecimal UserCode) {
    this.UserCode = (BigDecimal)session.getAttribute("UserCode");
  }

  public BigDecimal getUserCode() {
    return (BigDecimal)session.getAttribute("UserCode");
  }

  public void setUsername(String Username) {
    this.Username = (String)session.getAttribute("Username");
  }

  public String getUsername() {
    return (String)session.getAttribute("Username");
  }

 
  public void setLoginDate(Date LoginDate) {
    this.LoginDate = (Date)session.getAttribute("LoginDate");
  }

  public Date getLoginDate() {
    return (Date)session.getAttribute("LoginDate");
  }

  public void setCurrencyCode(BigDecimal currencyCode) {
    this.currencyCode = currencyCode;
  }

  public BigDecimal getCurrencyCode() {
    return currencyCode;
  }

  public void setCurrencySymbol(String currencySymbol) {
    this.currencySymbol = currencySymbol;
  }

  public String getCurrencySymbol() {
    return currencySymbol;
  }

    public void setTasks(String tasks) {
        this.tasks = tasks;
    }

    public String getTasks() {
        return tasks;
    }

    public void setTasksCount(int tasksCount) {
        this.tasksCount = tasksCount;
    }

    public int getTasksCount() {
        return tasksCount;
    }

    public void setSelectedCurrency(int selectedCurrency) {
        this.selectedCurrency = selectedCurrency;
    }

    public int getSelectedCurrency() {
        return selectedCurrency;
    }
}
