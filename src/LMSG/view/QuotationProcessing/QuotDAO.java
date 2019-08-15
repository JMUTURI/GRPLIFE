package LMSG.view.QuotationProcessing;

import java.math.BigDecimal;

import java.text.SimpleDateFormat;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

//import oracle.security.crypto.core.math.BigInt;

public class QuotDAO {
  public QuotDAO() {
  }
  //public static BigDecimal endrCode, policyCode;
  //public static String policyNumber;
  //,,brnCode,prpCode,prodCode,pmasCode,qcvtCode,provCode,lcaCode,dtyCode,qdlCode,qmemCode,gcoCode,agnCode,ttCode,trtCode,trtRate,taxCode,maxTypeNo,qcvtcvtCode,pprov_Code,qcprCode;
  //public static String fclCalcType,dpdsCovered,ContrType,savider,memGender,pensionType,grpRider,quoCalcTypeM,agnName,agnShtDesc,quoType,paymentFrequency,durType,trtRateType,ttShtDesc,ttRenewalEndos,policyNumber;
  //public static Integer memberANB;
  //public static Double ;
  
  public static String parseDate(String somedate) {
      Date date;
      date = null;
      String dateString;
      dateString = null;
      SimpleDateFormat sdf1 =
          new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
      SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MMMM/yyyy");


      try {
          date = sdf1.parse(somedate);
      } catch (Exception e) {
          FacesContext.getCurrentInstance().addMessage(null,
                                                       new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                        e.getMessage(),
                                                                        e.getMessage()));
      }
      dateString = sdf2.format(date);

      return dateString;
  }
  public static Date parseStringDate(String somDate)
  {
    Date date;
    date = null;
    String dateString;
    dateString = null;
    SimpleDateFormat sdf1 =
        new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
    //SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MMMM/yyyy");


    try {
        date = sdf1.parse(somDate);
    } catch (Exception e) {
        FacesContext.getCurrentInstance().addMessage(null,
                                                     new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                      e.getMessage(),
                                                                      e.getMessage()));
    }
    return date;
  }
}
