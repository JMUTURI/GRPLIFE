package LMSG.view.Base;

import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import oracle.jdbc.OracleTypes;


import LMSG.view.Policy.PolicyValues;

import LMSG.view.connect.DBConnector;


public class SettingsDAO {
  public SettingsDAO() {
  }
  HttpSession session =
    (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
  public static BigDecimal SelfCode;
  private BigDecimal SubDivCode;

  public List<Settings> FindDependantTypes() {
    String Self = null;
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    ResultSet rst = null;

    List<Settings> SettingsList = new ArrayList<Settings>();


    try {
      String polQuery = "begin LMS_WEB_CURSOR_GRP.getDependents(?);end;";
      cst = conn.prepareCall(polQuery);
      cst.registerOutParameter(1, OracleTypes.CURSOR);

      cst.execute();
      rst = (ResultSet)cst.getObject(1);
      while (rst.next()) {
        Settings mySettings = new Settings();

        mySettings.setDTY_CODE(rst.getBigDecimal(1));
        mySettings.setDTY_SHT_DESC(rst.getString(2));
        Self = rst.getString(2);
        if (Self.equalsIgnoreCase("SELF")) {
          SelfCode = rst.getBigDecimal(1);
        }
        mySettings.setDTY_DESCRIPTION(rst.getString(3));
        SettingsList.add(mySettings);

      }
      rst.close();
      cst.close();
      conn.close();
    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    } finally {
      GlobalCC.CloseConnections(rst, cst, conn);
    }
    return SettingsList;
  }

  public List<Settings> FindOccupations() {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    ResultSet rst = null;

    List<Settings> SettingsList = new ArrayList<Settings>();


    try {
      String polQuery = "begin LMS_WEB_CURSOR_GRP.grp_occupations(?);end;";
      cst = conn.prepareCall(polQuery);
      cst.registerOutParameter(1, OracleTypes.CURSOR);

      cst.execute();
      rst = (ResultSet)cst.getObject(1);
      while (rst.next()) {
        Settings mySettings = new Settings();

        mySettings.setGco_code(rst.getBigDecimal(1));
        mySettings.setGCO_DESC(rst.getString(2));

        SettingsList.add(mySettings);

      }
      rst.close();
      cst.close();
      conn.close();

    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    } finally {
      GlobalCC.CloseConnections(rst, cst, conn);
    }
    return SettingsList;
  }

  public List<Settings> FindTaxes() {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    ResultSet rst = null;

    List<Settings> SettingsList = new ArrayList<Settings>();


    try {
      String polQuery = "begin LMS_WEB_CURSOR_GRP.get_taxes(?,?);end;";
      cst = conn.prepareCall(polQuery);
      cst.registerOutParameter(1, OracleTypes.CURSOR);
      cst.setBigDecimal(2, (BigDecimal)session.getAttribute("ProductCode"));

      cst.execute();
      rst = (ResultSet)cst.getObject(1);
      while (rst.next()) {
        Settings mySettings = new Settings();

        mySettings.setTT_CODE(rst.getBigDecimal(1));
        mySettings.setTT_SHT_DESC(rst.getString(2));
        mySettings.setTT_DESC(rst.getString(3));
        mySettings.setTRT_RATE(rst.getString(4));
        mySettings.setTRT_DIVISION_FACTOR(rst.getString(5));
        mySettings.setTT_RENEWAL_ENDOS(rst.getString(6));
        mySettings.setTRT_RATE_TYPE(rst.getString(7));
        mySettings.setTRT_CODE(rst.getBigDecimal(8));
        mySettings.setCVT_DESC(rst.getString(9));

        SettingsList.add(mySettings);

      }
      rst.close();
      cst.close();
      conn.close();

    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    } finally {
      GlobalCC.CloseConnections(rst, cst, conn);
    }
    return SettingsList;
  }

  public List<Settings> FindQuoPremRateLoadings() {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    ResultSet rst = null;

    List<Settings> SettingsList = new ArrayList<Settings>();


    try {
      String polQuery =
        "begin LMS_WEB_CURSOR_GRP.getQuoPremRateLoadings(?,?);end;";
      cst = conn.prepareCall(polQuery);
      cst.registerOutParameter(1, OracleTypes.CURSOR);
      cst.setBigDecimal(2, (BigDecimal)session.getAttribute("QuoteCode"));

      cst.execute();
      rst = (ResultSet)cst.getObject(1);
      while (rst.next()) {
        Settings rateLoading = new Settings();
        rateLoading.setQoctl_code(rst.getBigDecimal(1));
        rateLoading.setQoctl_name(rst.getString(2));
        rateLoading.setQoctl_rate(rst.getBigDecimal(3));
        rateLoading.setQoctl_rate_div_factor(rst.getBigDecimal(4));
        rateLoading.setCvtDesc(rst.getString(5));
        SettingsList.add(rateLoading);
      }
      rst.close();
      cst.close();
      conn.close();

    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    } finally {
      GlobalCC.CloseConnections(rst, cst, conn);
    }
    return SettingsList;
  }

  public List<Settings> FindPureRateLoadings() {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    ResultSet rst = null;

    List<Settings> PureRateLoadList = new ArrayList<Settings>();


    try {
      String polQuery =
        "begin LMS_WEB_CURSOR_GRP.getPremRateLoadings(?,?);end;";
      cst = conn.prepareCall(polQuery);
      cst.registerOutParameter(1, OracleTypes.CURSOR);
      cst.setBigDecimal(2,
                        (BigDecimal)session.getAttribute("endorsementCode"));

      cst.execute();
      rst = (ResultSet)cst.getObject(1);
      while (rst.next()) {
        Settings rateLoading = new Settings();
        rateLoading.setPoctl_code(rst.getBigDecimal(1));
        rateLoading.setPoctl_name(rst.getString(2));
        rateLoading.setPoctl_rate(rst.getBigDecimal(3));
        rateLoading.setPoctl_rate_div_factor(rst.getBigDecimal(4));
        rateLoading.setCvtDesc(rst.getString(5));
        PureRateLoadList.add(rateLoading);
      }
      rst.close();
      cst.close();
      conn.close();

    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    } finally {
      GlobalCC.CloseConnections(rst, cst, conn);
    }
    return PureRateLoadList;
  }

  public List<Settings> FindProductCoverLoadings() {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    ResultSet rst = null;

    List<Settings> PureRateLoadList = new ArrayList<Settings>();


    try {
      String polQuery = "begin LMS_WEB_CURSOR_GRP.prodCoverLoading(?,?);end;";
      cst = conn.prepareCall(polQuery);
      cst.registerOutParameter(1, OracleTypes.CURSOR);
      cst.setBigDecimal(2, (BigDecimal)session.getAttribute("pct_code"));

      cst.execute();
      rst = (ResultSet)cst.getObject(1);
      while (rst.next()) {
        Settings rateLoading = new Settings();
        rateLoading.setPctl_code(rst.getBigDecimal(1));
        rateLoading.setPctl_name(rst.getString(2));
        rateLoading.setPctl_rate_type(rst.getString(3));
        rateLoading.setPctl_rate(rst.getBigDecimal(4));
        rateLoading.setPctl_rate_div_factor(rst.getBigDecimal(5));
        rateLoading.setPctl_load_method(rst.getString(6));
        rateLoading.setPctl_load_desc(rst.getString(7));

        PureRateLoadList.add(rateLoading);
      }
      rst.close();
      cst.close();
      conn.close();

    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    } finally {
      GlobalCC.CloseConnections(rst, cst, conn);
    }
    return PureRateLoadList;
  }


  public List<Settings> FindFacilitators() {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    ResultSet rst = null;

    List<Settings> SettingsList = new ArrayList<Settings>();


    try {
      String polQuery = "begin LMS_WEB_CURSOR_GRP.getFacilitators(?);end;";
      cst = conn.prepareCall(polQuery);
      cst.registerOutParameter(1, OracleTypes.CURSOR);

      cst.execute();
      rst = (ResultSet)cst.getObject(1);
      while (rst.next()) {
        Settings mySettings = new Settings();

        mySettings.setFAC_CODE(rst.getBigDecimal(1));
        mySettings.setFAC_NAME(rst.getString(2));
        mySettings.setFAC_POST_ADD(rst.getString(3));
        mySettings.setFAC_TOWN(rst.getString(4));
        mySettings.setFAC_COUNTRY(rst.getString(5));

        SettingsList.add(mySettings);

      }
      rst.close();
      cst.close();
      conn.close();

    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    } finally {
      GlobalCC.CloseConnections(rst, cst, conn);
    }
    return SettingsList;
  }

  public List<Settings> FindStates() {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    ResultSet rst = null;

    List<Settings> SettingsList = new ArrayList<Settings>();


    try {
      String polQuery = "begin TQC_WEB_PKG.find_states(?,?);end;";
      cst = conn.prepareCall(polQuery);
      cst.registerOutParameter(1, OracleTypes.CURSOR);
      cst.setBigDecimal(2, (BigDecimal)session.getAttribute("countryCode"));

      cst.execute();
      rst = (ResultSet)cst.getObject(1);
      while (rst.next()) {
        Settings mySettings = new Settings();


        mySettings.setSTS_CODE(rst.getBigDecimal(1));
        mySettings.setSTS_COU_CODE(rst.getBigDecimal(2));
        mySettings.setSTS_SHT_DESC(rst.getString(3));
        mySettings.setSTS_NAME(rst.getString(4));

        SettingsList.add(mySettings);

      }
      rst.close();
      cst.close();
      conn.close();

    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    } finally {
      GlobalCC.CloseConnections(rst, cst, conn);
    }
    return SettingsList;
  }

  public List<Settings> FindActivities() {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    ResultSet rst = null;

    List<Settings> SettingsList = new ArrayList<Settings>();


    try {
      String polQuery = "begin LMS_WEB_CURSOR_GRP.getActivities(?,?);end;";
      cst = conn.prepareCall(polQuery);
      cst.registerOutParameter(1, OracleTypes.CURSOR);
      cst.setBigDecimal(2,
                        (BigDecimal)session.getAttribute("FacilitatorCode"));

      cst.execute();
      rst = (ResultSet)cst.getObject(1);
      while (rst.next()) {
        Settings mySettings = new Settings();

        mySettings.setACT_CODE(rst.getBigDecimal(1));
        mySettings.setACT_ACTIVITY(rst.getString(2));
        mySettings.setFACT_CODE(rst.getBigDecimal(3));


        SettingsList.add(mySettings);

      }
      rst.close();
      cst.close();
      conn.close();

    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    } finally {
      GlobalCC.CloseConnections(rst, cst, conn);
    }
    return SettingsList;
  }

  public List<Settings> FindCoinsurers() {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    ResultSet rst = null;

    List<Settings> SettingsList = new ArrayList<Settings>();


    try {
      String polQuery = "begin LMS_WEB_CURSOR_GRP.findcoinsurers(?,?,?);end;";
      cst = conn.prepareCall(polQuery);
      cst.registerOutParameter(1, OracleTypes.CURSOR);
      String custa = (String)session.getAttribute("CurrentStatus");
      if (custa == "Q") {
        cst.setBigDecimal(2, (BigDecimal)session.getAttribute("QuoteCode"));
      } else {
        cst.setBigDecimal(2,
                          (BigDecimal)session.getAttribute("endorsementCode"));
      }
      cst.setString(3, (String)session.getAttribute("CurrentStatus"));

      cst.execute();
      rst = (ResultSet)cst.getObject(1);
      while (rst.next()) {
        Settings mySettings = new Settings();

        mySettings.setCO_agn_code(rst.getBigDecimal(1));

        mySettings.setCO_agn_name(rst.getString(2));

        SettingsList.add(mySettings);

      }
      rst.close();
      cst.close();
      conn.close();

    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
      e.printStackTrace();
    } finally {
      GlobalCC.CloseConnections(rst, cst, conn);
    }
    return SettingsList;
  }

  public List<Settings> FindSysDate() {
    //DBConnector myConn=new DBConnector();
    //Connection conn=myConn.getDatabaseConn();
    //CallableStatement cst=null;

    List<Settings> SettingsList = new ArrayList<Settings>();


    try {

      Date Now = new Date();

      Settings mySettings = new Settings();

      mySettings.setSysDate(Now);

      SettingsList.add(mySettings);


    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(null, e);
    }
    return SettingsList;
  }

  public List<Settings> FindBranches() {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    ResultSet rst = null;

    List<Settings> SettingsList = new ArrayList<Settings>();


    try {
      String branchesQuery = "BEGIN LMS_WEB_CURSOR_GRP.getBranches(?);END;";
      cst = conn.prepareCall(branchesQuery);
      cst.registerOutParameter(1, OracleTypes.CURSOR);

      cst.execute();
      rst = (ResultSet)cst.getObject(1);
      while (rst.next()) {
        Settings mySettings = new Settings();

        mySettings.setBRN_SHT_DESC(rst.getString(2));
        mySettings.setBRN_CODE(rst.getBigDecimal(1));
        mySettings.setBRN_NAME(rst.getString(3));

        SettingsList.add(mySettings);

      }
      rst.close();
      cst.close();
      conn.close();

    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    } finally {
      GlobalCC.CloseConnections(rst, cst, conn);
    }
    return SettingsList;
  }

  public List<Settings> FindAgents() {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    ResultSet rst = null;

    List<Settings> SettingsList = new ArrayList<Settings>();


    try {

      String AgentsQuery = "BEGIN LMS_WEB_CURSOR_GRP.quoAgents(?);END;";
      cst = conn.prepareCall(AgentsQuery);
      cst.registerOutParameter(1, OracleTypes.CURSOR);

      cst.execute();
      rst = (ResultSet)cst.getObject(1);
      while (rst.next()) {
        Settings mySettings = new Settings();

        mySettings.setAGN_CODE(rst.getBigDecimal(1));
        mySettings.setAGN_NAME(rst.getString(2));
        mySettings.setAGN_POSTAL_ADDRESS(rst.getString(4));
        mySettings.setAGN_SHT_DESC(rst.getString(3));
        mySettings.setAgent(rst.getString(5));

        SettingsList.add(mySettings);

      }
      rst.close();
      cst.close();
      conn.close();

    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    } finally {
      GlobalCC.CloseConnections(rst, cst, conn);
    }
    return SettingsList;
  }

  public List<Settings> FindGovtAgents() {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    ResultSet rst = null;

    List<Settings> SettingsList = new ArrayList<Settings>();


    try {

      String AgentsQuery = "BEGIN LMS_WEB_CURSOR_GRP.findGovtagents(?);END;";
      cst = conn.prepareCall(AgentsQuery);
      cst.registerOutParameter(1, OracleTypes.CURSOR);

      cst.execute();
      rst = (ResultSet)cst.getObject(1);
      while (rst.next()) {
        Settings mySettings = new Settings();

        mySettings.setSPR_CODE(rst.getBigDecimal(1));
        mySettings.setSPR_SHT_DESC(rst.getString(2));
        mySettings.setSPR_NAME(rst.getString(3));
        mySettings.setSPR_PHYSICAL_ADDRESS(rst.getString(4));
        mySettings.setSPR_POSTAL_ADDRESS(rst.getString(5));
        mySettings.setSPR_SPT_CODE(rst.getBigDecimal(6));
        mySettings.setSPT_NAME(rst.getString(7));


        SettingsList.add(mySettings);

      }
      rst.close();
      cst.close();
      conn.close();

    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    } finally {
      GlobalCC.CloseConnections(rst, cst, conn);
    }
    return SettingsList;
  }

  public List<Settings> FindMedicalFacilitators() {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    ResultSet rst = null;

    List<Settings> SettingsList = new ArrayList<Settings>();


    try {
      String polQuery = "begin LMS_WEB_CURSOR_GRP.Findfacilitators(?);end;";
      cst = conn.prepareCall(polQuery);
      cst.registerOutParameter(1, OracleTypes.CURSOR);

      cst.execute();
      rst = (ResultSet)cst.getObject(1);
      while (rst.next()) {
        Settings mySettings = new Settings();


        mySettings.setSPR_CODE(rst.getBigDecimal(1));
        mySettings.setSPR_SHT_DESC(rst.getString(2));
        mySettings.setSPR_NAME(rst.getString(3));
        mySettings.setSPR_SPT_CODE(rst.getBigDecimal(4));
        mySettings.setTWN_NAME(rst.getString(5));

        SettingsList.add(mySettings);

      }
      rst.close();
      cst.close();
      conn.close();

    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    } finally {
      GlobalCC.CloseConnections(rst, cst, conn);
    }
    return SettingsList;
  }

  public List<Settings> FindServiceProviders() {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    ResultSet rst = null;

    List<Settings> SettingsList = new ArrayList<Settings>();


    try {
      String polQuery =
        "begin LMS_WEB_CURSOR_GRP.findpensionfacilitators(?);end;";
      cst = conn.prepareCall(polQuery);
      cst.registerOutParameter(1, OracleTypes.CURSOR);

      cst.execute();
      rst = (ResultSet)cst.getObject(1);
      while (rst.next()) {
        Settings mySettings = new Settings();


        mySettings.setSPR_CODE(rst.getBigDecimal(1));
        mySettings.setSPT_NAME(rst.getString(2));
        mySettings.setSPR_NAME(rst.getString(3));

        SettingsList.add(mySettings);

      }
      rst.close();
      cst.close();
      conn.close();

    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    } finally {
      GlobalCC.CloseConnections(rst, cst, conn);
    }
    return SettingsList;
  }

  public List<Settings> FindPolicyServiceProviders() {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    ResultSet rst = null;

    List<Settings> SettingsList = new ArrayList<Settings>();


    try {
      String polQuery =
        "begin LMS_WEB_CURSOR_GRP.get_policy_service_providers(?,?);end;";
      cst = conn.prepareCall(polQuery);
      cst.registerOutParameter(1, OracleTypes.CURSOR);
      cst.setBigDecimal(2, (BigDecimal)session.getAttribute("policyCode"));

      cst.execute();
      rst = (ResultSet)cst.getObject(1);
      while (rst.next()) {
        Settings mySettings = new Settings();
        mySettings.setSPR_CODE(rst.getBigDecimal(1));
        mySettings.setSPR_NAME(rst.getString(2));
        mySettings.setSPR_PHYSICAL_ADDRESS(rst.getString(3));
        mySettings.setSPR_POSTAL_ADDRESS(rst.getString(4));
        mySettings.setSPR_PHONE(rst.getString(5));
        mySettings.setSPR_CONTACT_PERSON(rst.getString(6));
        mySettings.setSPR_CONTACT_PERSON_PHONE(rst.getString(7));
        mySettings.setSPR_WEF(rst.getDate(8));
        mySettings.setSPR_WET(rst.getDate(9));
        SettingsList.add(mySettings);
      }
      rst.close();
      cst.close();
      conn.close();

    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    } finally {
      GlobalCC.CloseConnections(rst, cst, conn);
    }
    return SettingsList;
  }


  public List<Settings> FindDeductions() {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    ResultSet rst = null;

    List<Settings> SettingsList = new ArrayList<Settings>();


    try {
      String polQuery = "begin LMS_WEB_CURSOR_GRP.finddeductions(?,?);end;";
      cst = conn.prepareCall(polQuery);
      cst.registerOutParameter(1, OracleTypes.CURSOR);
      cst.setBigDecimal(2, (BigDecimal)session.getAttribute("policyCode"));

      cst.execute();
      rst = (ResultSet)cst.getObject(1);
      while (rst.next()) {
        Settings mySettings = new Settings();


        mySettings.setDD_tt_code(rst.getBigDecimal(1));
        mySettings.setDD_tt_sht_desc(rst.getString(2));
        mySettings.setTT_DESC(rst.getString(3));
        mySettings.setDD_tt_type(rst.getString(4));
        mySettings.setDD_tt_applicable_at_prod(rst.getString(5));
        mySettings.setDD_tt_renewal_endos(rst.getString(6));
        mySettings.setDD_tt_application_level(rst.getString(7));
        mySettings.setTrt_rate(rst.getString(8));
        mySettings.setTrt_division_factor(rst.getString(9));
        mySettings.setTRT_RATE_TYPE(rst.getString(10));
        SettingsList.add(mySettings);

      }
      rst.close();
      cst.close();
      conn.close();

    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    } finally {
      GlobalCC.CloseConnections(rst, cst, conn);
    }
    return SettingsList;
  }

  public List<Settings> findCountries() {

    String query = "begin ? := tqc_clients_pkg.get_countries(); end;";
    CallableStatement cst = null;
    ResultSet rs = null;
    List<Settings> Countries = new ArrayList<Settings>();
    Connection conn = null;
    try {
      DBConnector datahandler = new DBConnector();
      conn = datahandler.getDatabaseConn();

      cst = conn.prepareCall(query);
      cst.registerOutParameter(1, OracleTypes.CURSOR); //authorization code

      cst.execute();

      rs = (ResultSet)cst.getObject(1);

      Countries = new ArrayList<Settings>();

      while (rs.next()) {
        Settings country = new Settings();

        country.setCountryCode(rs.getBigDecimal(1));
        country.setCountryShtDesc(rs.getString(2));
        country.setCountryName(rs.getString(3));
        Countries.add(country);

      }
      rs.close();
      cst.close();
      conn.close();


    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    } finally {
      GlobalCC.CloseConnections(rs, cst, conn);
    }


    return Countries;
  }

  public List<Settings> findTowns() {

    String query = "begin ? := tqc_clients_pkg.get_towns(?,?); end;";
    CallableStatement cst = null;
    Connection conn = null;
    ResultSet rs = null;
    List<Settings> Town = new ArrayList<Settings>();
    try {
      DBConnector datahandler = new DBConnector();

      conn = datahandler.getDatabaseConn();

      cst = conn.prepareCall(query);
      cst.registerOutParameter(1, OracleTypes.CURSOR); //authorization code
      cst.setBigDecimal(2, (BigDecimal)session.getAttribute("countryCode"));

      cst.setBigDecimal(3, (BigDecimal)session.getAttribute("stateCode"));
      cst.execute();

      rs = (ResultSet)cst.getObject(1);

      Town = new ArrayList<Settings>();

      while (rs.next()) {
        Settings Towns = new Settings();

        Towns.setTownCode(rs.getBigDecimal(1));
        Towns.setPostalDesc(rs.getString(2));
        Towns.setTownShtDesc(rs.getString(2));
        Towns.setTownName(rs.getString(3));
        Towns.setPostalZIPCode(rs.getString(4));
        Town.add(Towns);

      }
      rs.close();
      cst.close();
      conn.close();


    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    } finally {
      GlobalCC.CloseConnections(rs, cst, conn);
    }


    return Town;
  }

  public List<Settings> findSectors() {

    String query = "begin ? := tqc_clients_pkg.get_sectors(); end;";
    CallableStatement cst = null;
    Connection conn = null;
    ResultSet rs = null;
    List<Settings> Sectors = new ArrayList<Settings>();
    try {
      DBConnector datahandler = new DBConnector();

      conn = datahandler.getDatabaseConn();

      cst = conn.prepareCall(query);
      cst.registerOutParameter(1, OracleTypes.CURSOR); //authorization code

      cst.execute();

      rs = (ResultSet)cst.getObject(1);

      Sectors = new ArrayList<Settings>();

      while (rs.next()) {
        Settings sector = new Settings();

        sector.setSectorShtDesc(rs.getString(1));
        sector.setSectorName(rs.getString(2));
        sector.setSectorCode(rs.getBigDecimal(3));
        Sectors.add(sector);

      }

      rs.close();
      cst.close();
      conn.close();

    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    } finally {
      GlobalCC.CloseConnections(rs, cst, conn);
    }


    return Sectors;
  }

  public List<Settings> FindPayees() {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    ResultSet rst = null;

    List<Settings> SettingsList = new ArrayList<Settings>();


    try {
      String polQuery = "begin LMS_WEB_CURSOR_GRP.get_payee_org(?,?);end;";
      cst = conn.prepareCall(polQuery);
      cst.registerOutParameter(1, OracleTypes.CURSOR);
      cst.setBigDecimal(2, (BigDecimal)session.getAttribute("policyCode"));

      cst.execute();
      rst = (ResultSet)cst.getObject(1);
      while (rst.next()) {
        Settings mySettings = new Settings();

        mySettings.setPAYEE_SPR_NAME(rst.getString(1));
        mySettings.setPAYEE_SPT_CODE(rst.getBigDecimal(2));

        SettingsList.add(mySettings);

      }
      rst.close();
      cst.close();
      conn.close();

    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    } finally {
      GlobalCC.CloseConnections(rst, cst, conn);
    }
    return SettingsList;
  }

  public List<Settings> FindSystemUsers() {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    ResultSet rst = null;

    List<Settings> SettingsList = new ArrayList<Settings>();


    try {
      String polQuery = "begin TQC_WEB_PKG.get_sys_users(?,?);end;";
      cst = conn.prepareCall(polQuery);

      cst.setInt(1, (Integer)session.getAttribute("sysCode"));
      cst.registerOutParameter(2, OracleTypes.CURSOR);

      cst.execute();
      rst = (ResultSet)cst.getObject(2);
      while (rst.next()) {
        Settings mySettings = new Settings();

        mySettings.setUSR_CODE(rst.getBigDecimal(1));
        mySettings.setUSR_NAME(rst.getString(3));
        mySettings.setUSR_USERNAME(rst.getString(2));


        SettingsList.add(mySettings);

      }
      rst.close();
      cst.close();
      conn.close();

    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    } finally {
      GlobalCC.CloseConnections(rst, cst, conn);
    }
    return SettingsList;
  }

  public List<Settings> FindGroupSubdivisions() {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    ResultSet rst = null;

    List<Settings> SettingsList = new ArrayList<Settings>();

    try {
      String polQuery =
        "begin LMS_SETUPS_CURSOR.find_grp_subdivisions(?);end;";
      cst = conn.prepareCall(polQuery);

      cst.registerOutParameter(1, OracleTypes.CURSOR);

      cst.execute();
      rst = (ResultSet)cst.getObject(1);
      while (rst.next()) {
        Settings mySettings = new Settings();

        mySettings.setGSUB_CODE(rst.getBigDecimal(1));
        mySettings.setGSUB_SHT_DESC(rst.getString(2));
        mySettings.setGSUB_DESC(rst.getString(3));


        SettingsList.add(mySettings);

      }
      rst.close();
      cst.close();
      conn.close();

    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    } finally {
      GlobalCC.CloseConnections(rst, cst, conn);
    }
    return SettingsList;
  }

  public List<Settings> FindEmailDetails() {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    ResultSet rst = null;

    List<Settings> emailList = new ArrayList<Settings>();

    try {
      String polQuery = "begin LMS_SETUPS_CURSOR.getEmailDetails(?);end;";
      cst = conn.prepareCall(polQuery);

      cst.registerOutParameter(1, OracleTypes.CURSOR);

      cst.execute();
      rst = (ResultSet)cst.getObject(1);
      while (rst.next()) {
        Settings mySettings = new Settings();

        mySettings.setEmd_code(rst.getBigDecimal(1));
        mySettings.setEmd_msgt_narr(rst.getString(2));
        mySettings.setEmd_rpt_name(rst.getString(3));
        mySettings.setUSR_NAME(rst.getString(4));
        mySettings.setUsr_email(rst.getString(5));
        mySettings.setProdCode(rst.getBigDecimal(6));
        mySettings.setProdDesc(rst.getString(7));
        emailList.add(mySettings);

      }
      rst.close();
      cst.close();
      conn.close();

    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    } finally {
      GlobalCC.CloseConnections(rst, cst, conn);
    }
    return emailList;
  }

  public List<Settings> FindSBUDetails() {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    ResultSet rst = null;

    List<Settings> SettingsList = new ArrayList<Settings>();


    try {

      String SBUQuery = "BEGIN LMS_SETUPS_CURSOR.getSBUDetails(?);END;";
      cst = conn.prepareCall(SBUQuery);
      cst.registerOutParameter(1, OracleTypes.CURSOR);

      cst.execute();
      rst = (ResultSet)cst.getObject(1);
      while (rst.next()) {
        Settings mySettings = new Settings();
         
        mySettings.setCOVERAGE_AREA(rst.getString(1));
        mySettings.setSPOKE(rst.getString(2));
        mySettings.setSBU(rst.getString(3));
        mySettings.setCOVERAGE_AREA_CODE(rst.getBigDecimal(4));
        mySettings.setSPOKE_CODE(rst.getBigDecimal(5));
        mySettings.setSBU_CODE(rst.getBigDecimal(6));
       
        SettingsList.add(mySettings);

      }
      rst.close();
      cst.close();
      conn.close();

    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    } finally {
      GlobalCC.CloseConnections(rst, cst, conn);
    }
    return SettingsList;
  }
  
  public List<Settings> FindOrgLocationsDetails() {
    DBConnector myConn = new DBConnector();
    Connection conn = myConn.getDatabaseConn();
    CallableStatement cst = null;
    ResultSet rst = null;

    List<Settings> SettingsList = new ArrayList<Settings>();


    try {

      String LOCQuery = "BEGIN LMS_SETUPS_CURSOR.getOrgLocationsDetails(?);END;";
      cst = conn.prepareCall(LOCQuery);
      cst.registerOutParameter(1, OracleTypes.CURSOR);

      cst.execute();
      rst = (ResultSet)cst.getObject(1);
      while (rst.next()) {
        Settings mySettings = new Settings();
         
        mySettings.setLOCATION(rst.getString(1));
        mySettings.setORGANIZATION(rst.getString(2));
        mySettings.setLOCATION_CODE(rst.getBigDecimal(3));             
        SettingsList.add(mySettings);

      }
      rst.close();
      cst.close();
      conn.close();

    } catch (Exception e) {
      GlobalCC.EXCEPTIONREPORTING(conn, e);
    } finally {
      GlobalCC.CloseConnections(rst, cst, conn);
    }
    return SettingsList;
  }

  public void setSubDivCode(BigDecimal SubDivCode) {
    this.SubDivCode = SubDivCode;
    session.setAttribute("subdivisionCode", SubDivCode);

  }

  public BigDecimal getSubDivCode() {
    return (BigDecimal)session.getAttribute("subdivisionCode");
  }
}
