package com.turnkey.Calendars;




import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.text.DateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import oracle.adf.view.rich.model.CalendarActivity;
import oracle.adf.view.rich.model.CalendarProvider;

import oracle.jdbc.OracleTypes;

import LMSG.view.Base.GlobalCC;

import LMSG.view.connect.DBConnector;

//import oracle.adfdemo.view.calendar.rich.model.Day;
//import oracle.adfdemo.view.calendar.rich.model.DemoCalendarActivity;
//import oracle.adfdemo.view.calendar.rich.model.DemoCalendarModelWrapper;
//import oracle.adfdemo.view.calendar.rich.model.DemoCalendarProvider;
//import oracle.adfdemo.view.calendar.rich.model.DemoSingleProviderCalendarModel;


/**
 * The demo model will provide sample CalendarActivities that shows:
 * <ul>
 * <li>the calendar should have a reasonable number of activities when
 * initially viewed.</li>
 * <li>Need to show: all day events; all day events that span multiple days;
 * timed events; timed events that span multiple days;
 * day/week view - conflicting events;
 * month view - enough events on a single to day to trigger overflow.</li>
 * <li>support changing timezones for testing - add a drop down to change
 * the tz.</li>
 * <li>support of multiple providers</li>
 * </ul>
 */
public class DemoCalendarModelBean {
    HttpSession session =
        (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);

    public DemoCalendarModelBean() {


        CalendarProvider provider0 =
            new DemoCalendarProvider((String)session.getAttribute("Username"),
                                     (String)session.getAttribute("Username"));
        CalendarProvider provider1 =
            new DemoCalendarProvider("Larry", "Larry");
        CalendarProvider provider2 = new DemoCalendarProvider("Ted", "Ted");

        List<CalendarProvider> providers = new ArrayList<CalendarProvider>();
        providers.add(provider0);
        providers.add(provider1);
        providers.add(provider2);

        DemoSingleProviderCalendarModel model =
            new DemoSingleProviderCalendarModel(provider0);
        _modelWrapper = new DemoCalendarModelWrapper();
        _modelWrapper.addCalendarModel(model);

        // Add regular CalendarActivities

        //_addBasicActivities(model);
        populateBasicActivities(model);
        //_addRecurringActivities(model);

        // Add all day activities
        //_addAllDayActivities(model);

        // Add multiple days activites
        //_addMultipleDaysActivities(model);

        // Add activities from different models
        /*
    // create other models
    DemoSingleProviderCalendarModel model1 = new DemoSingleProviderCalendarModel(provider1);
    _addActivitiesToModel(model1, 1);
    _modelWrapper.addCalendarModel(model1);


    DemoSingleProviderCalendarModel model2 = new DemoSingleProviderCalendarModel(provider2);
    _addActivitiesToModel(model2, 2);
    _modelWrapper.addCalendarModel(model2);
*/
    }

    // Public APIs

    public DemoCalendarModelWrapper getCalendarModel() {
        return _modelWrapper;
    }

    public int getAndIncreaseActivityIdCounter() {
        int id = _activityIdCounter;
        _activityIdCounter++;
        return id;
    }

    public int getActivityIdCounter() {
        return _activityIdCounter;
    }

    public void setActivityIdCounter(int activityIdCounter) {
        this._activityIdCounter = activityIdCounter;
    }

    // Protected methods
    // Methods to get an activity title - DemoCalendarArabicModelBean override
    // these to provide full RTL strings

    protected String getAllDayActivityTitle(String titleAddition, long numDays,
                                            Calendar endCalendar) {
        String title = "allday " + getActivityIdCounter();

        if (numDays > 1) {

            // for days > 1 we show on which day this activity ends. We subtract one day off since we
            // calculate an all day activity that ends on the 27th as being at midnight of the 27th,
            // and thus it doesn't actually show up on the 27th. It 'ends' on the 26th, just before midnight.
            // therefore the text says the 26th instead of the 27th.
            endCalendar.add(Calendar.DAY_OF_YEAR, -1);
            title =
                    title + " ends on " + DateFormat.getDateInstance(DateFormat.SHORT).format(endCalendar.getTime());
            endCalendar.add(Calendar.DAY_OF_YEAR, 1);

        }

        if (titleAddition != null)
            title = title + " " + titleAddition;
        return title;
    }


    protected String getDailyRecurringActivityTitle(int i) {
        return "time " + getActivityIdCounter() + " recurring daily " +
            (i + 1);
    }

    protected String getMonthlyRecurringActivityTitle(int i) {
        return "time " + getActivityIdCounter() + " recurring monthly " +
            (i + 1);
    }

    protected String getTimedActivityTitle(String titleAddition,
                                           Calendar startCalendar,
                                           Calendar endCalendar) {
        String title = "time " + getActivityIdCounter();


        int c1DayOfYear = startCalendar.get(Calendar.DAY_OF_YEAR);
        int c1Year = startCalendar.get(Calendar.YEAR);
        int c2DayOfYear = endCalendar.get(Calendar.DAY_OF_YEAR);
        int c2Year = endCalendar.get(Calendar.YEAR);

        if (c1DayOfYear != c2DayOfYear || c1Year != c2Year) {
            DateFormat formatter =
                DateFormat.getDateTimeInstance(DateFormat.SHORT,
                                               DateFormat.SHORT);
            title =
                    title + " ends at " + formatter.format(endCalendar.getTime()) +
                    " " +
                    endCalendar.getTimeZone().getDisplayName(true, TimeZone.SHORT);
        }

        if (titleAddition != null) {
            title = title + " " + titleAddition;
        }
        return title;
    }


    protected String getWeeklyRecurringActivityTitle(int i) {
        return "time " + getActivityIdCounter() + " recurring weekly " +
            (i + 1);
    }


    // Helper methods


    private void _addTimeActivity(DemoSingleProviderCalendarModel model,
                                  String location, String titleAddition,
                                  int startAddDays, int startHour,
                                  int startMin, int endAddDays,
                                  int endAddHours, int endAddMins) {
        _addTimeActivity(model, location, titleAddition, startAddDays,
                         startHour, startMin, endAddDays, endAddHours,
                         endAddMins, CalendarActivity.Recurring.SINGLE,
                         CalendarActivity.Reminder.OFF);
    }

    /**
     * The title will have syntax
     *  <provider Id> activity <activity Id> <type and details of activity>
     */
    private void _addTimeActivity(DemoSingleProviderCalendarModel model,
                                  String location, String titleAddition,
                                  int startAddDays, int startHour,
                                  int startMin, int endAddDays,
                                  int endAddHours, int endAddMins,
                                  CalendarActivity.Recurring recurring,
                                  CalendarActivity.Reminder reminder) {
        CalendarProvider provider = model.getProvider();
        Calendar startCalendar =
            _createCalendarFromToday(startAddDays, startHour, startMin);
        Calendar endCalendar =
            _createCalendar(startCalendar, endAddDays, endAddHours,
                            endAddMins);
        DemoCalendarActivity ca =
            new DemoCalendarActivity(provider, String.valueOf(_activityIdCounter),
                                     startCalendar.getTime(),
                                     endCalendar.getTime(),
                                     TimeZone.getDefault());
        ca.setLocation(location);

        String title =
            getTimedActivityTitle(titleAddition, startCalendar, endCalendar);

        ca.setTitle(title);

        ca.setRecurring(recurring);
        ca.setReminder(reminder);
        model.addTimeCalendarActivity(ca);
        _activityIdCounter++;
    }


    /**
     * The title will have syntax
     *  <provider Id> activity <activity Id> <type and details of activity>
     */
    private void _addAlldayActivity(DemoSingleProviderCalendarModel model,
                                    String location, String titleAddition,
                                    int startAddDays, int numDays) {

        CalendarProvider provider = model.getProvider();

        // set the start time as 1pm to make sure that start hours on all day events don't affect
        // rendering
        Calendar startCalendar = _createCalendarFromToday(startAddDays, 13, 0);

        Calendar endCalendar = _createCalendar(startCalendar, numDays, 1, 0);

        String title =
            getAllDayActivityTitle(titleAddition, numDays, endCalendar);

        DemoCalendarActivity ca =
            new DemoCalendarActivity(provider, String.valueOf(_activityIdCounter),
                                     new Day(startCalendar),
                                     new Day(endCalendar),
                                     TimeZone.getDefault());
        ca.setLocation(location);
        ca.setTitle(title);

        model.addAllDayCalendarActivity(ca);
        _activityIdCounter++;
    }

    /**
     * <p>
     * Add _numOfRegularActivities of CalendarActivities
     * The title will have syntax
     *  <provider Id> activity <activity Id> <type and details of activity>
     *
     * The method will add these types of activities:
     *  Start at today's date at 9 am current timezone.
     *  Overlapped activities
     *  A lot of time activities.
     *  </p>
     */
    private void populateBasicActivities(DemoSingleProviderCalendarModel model) {
        try {
            DBConnector datahandler = new DBConnector();
            Connection conn;
            conn = datahandler.getDatabaseConn();

            String ActivityDetails =
                "begin TQC_COMMON_CURSORS.get_cal_activities(?,?);end;";

            CallableStatement cstActivityDetails;
            cstActivityDetails = conn.prepareCall(ActivityDetails);
            cstActivityDetails.registerOutParameter(1, OracleTypes.CURSOR);
            cstActivityDetails.setString(2,
                                         (String)session.getAttribute("Username"));
            cstActivityDetails.execute();
            ResultSet rst = (ResultSet)cstActivityDetails.getObject(1);
            while (rst.next()) {
                _addTimeActivity(model, rst.getString(1), rst.getString(2),
                                 rst.getInt(3), rst.getInt(4), rst.getInt(5),
                                 rst.getInt(6), rst.getInt(7), rst.getInt(8));
            }
            conn.close();
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
    }

    public void _createNewCalActivity(String Location, String Title,
                                      String Today, String StartDate,
                                      String EndDate) {
        try {

            DBConnector datahandler = new DBConnector();
            Connection conn;
            conn = datahandler.getDatabaseConn();

            String ActivityDetails =
                "begin TQC_WEB_PKG.update_cal_activity(?,?,?,?,?,?);end;";
            CallableStatement cstActivityDetails;
            cstActivityDetails = conn.prepareCall(ActivityDetails);
            cstActivityDetails.setString(1, Location);
            cstActivityDetails.setString(2, Title);
            cstActivityDetails.setString(3, Today); //Todays Date.
            cstActivityDetails.setString(4, StartDate);
            cstActivityDetails.setString(5, EndDate);
            cstActivityDetails.setString(6,
                                         (String)session.getAttribute("Username"));
            cstActivityDetails.execute();

            CalendarProvider provider0 =
                new DemoCalendarProvider((String)session.getAttribute("Username"),
                                         (String)session.getAttribute("Username"));
            DemoSingleProviderCalendarModel model =
                new DemoSingleProviderCalendarModel(provider0);
            _modelWrapper = new DemoCalendarModelWrapper();
            _modelWrapper.addCalendarModel(model);
            populateBasicActivities(model);
          cstActivityDetails.close();
          conn.close();

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }

    }

    private void _addBasicActivities(DemoSingleProviderCalendarModel model) {
        // Create CalendarActivity for current day at 9 with an hour duration.
        _addTimeActivity(model, null, "Meeting", 0, 9, 0, 0, 1, 0);

        // Create a 2 hour overlapped activity from 9 am today activity
        _addTimeActivity(model, null, null, 0, 9, 40, 0, 2, 0);

        // Almost all day activity
        _addTimeActivity(model, null, null, 2, 0, 0, 0, 24, 0);

        // Add several time activities
        _addNumActivities(model, 8, 3);

        // activity that ends at midnight
        _addTimeActivity(model, null, "ends at midnight", 2, 23, 0, 0, 1, 0,
                         CalendarActivity.Recurring.SINGLE,
                         CalendarActivity.Reminder.OFF);

        // activity less than 24h but go across midnight
        _addTimeActivity(model, null, " spans across midnight", -7, 18, 0, 0,
                         14, 0);

    }

    // add a whole bunch of time activities

    private void _addNumActivities(DemoSingleProviderCalendarModel model,
                                   int startHour, int frequency) {
        // loop to create a lot of one hour activities starting the day before today start at 8 am
        for (int i = 1; i <= 30; i++) {
            int days = (i - 2) * frequency;
            _addTimeActivity(model, null, null, days, startHour, 0, 0, 1, 0,
                             CalendarActivity.Recurring.SINGLE,
                             CalendarActivity.Reminder.ON);
        }
    }


    private void _addRecurringActivities(DemoSingleProviderCalendarModel model) {
        DemoCalendarActivity ca = null;
        Calendar startCalendar = null;
        Calendar endCalendar = null;
        CalendarProvider provider = model.getProvider();
        int numOfRecurringActivities = 10;

        // recurring activities daily for 10 days since today date start at 3 pm
        for (int i = 0; i < numOfRecurringActivities; i++) {
            startCalendar = _createCalendarFromToday(i, 15, 0);
            endCalendar = _createCalendar(startCalendar, 0, 1, 0);
            Date startDate = startCalendar.getTime();
            Date endDate = endCalendar.getTime();
            ca =
 new DemoCalendarActivity(provider, String.valueOf(_activityIdCounter),
                          startDate, endDate, TimeZone.getDefault());
            ca.setTitle(getDailyRecurringActivityTitle(i));
            ca.setLocation("2op1176");
            ca.setRecurring(CalendarActivity.Recurring.RECURRING);
            ca.setReminder(CalendarActivity.Reminder.ON);
            model.addTimeCalendarActivity(ca);
            _activityIdCounter++;
        }

        // recurring activies weekly for 10 weeks since today date start at 4:30 pm
        for (int i = 0; i < numOfRecurringActivities; i++) {
            startCalendar = _createCalendarFromToday(i * 7, 16, 30);
            endCalendar = _createCalendar(startCalendar, 0, 1, 0);
            Date startDate = startCalendar.getTime();
            Date endDate = endCalendar.getTime();
            ca =
 new DemoCalendarActivity(provider, String.valueOf(_activityIdCounter),
                          startDate, endDate, TimeZone.getDefault());
            ca.setTitle(getWeeklyRecurringActivityTitle(i));
            ca.setRecurring(CalendarActivity.Recurring.CHANGED);

            model.addTimeCalendarActivity(ca);
            _activityIdCounter++;
        }

        // recurring activies monthly for 10 months since today date start at 6:15 pm
        for (int i = 0; i < numOfRecurringActivities; i++) {
            startCalendar = Calendar.getInstance();
            startCalendar.set(Calendar.HOUR_OF_DAY, 18);
            startCalendar.set(Calendar.MINUTE, 15);
            startCalendar.set(Calendar.SECOND, 0);
            startCalendar.set(Calendar.MILLISECOND, 0);
            // TODO unsafe calendar set, check if this will roll over the new year properly
            startCalendar.add(Calendar.MONTH, i);
            endCalendar = Calendar.getInstance();
            endCalendar.setTime(startCalendar.getTime());
            endCalendar.add(Calendar.HOUR_OF_DAY, 1);

            Date startDate = startCalendar.getTime();
            Date endDate = endCalendar.getTime();
            ca =
 new DemoCalendarActivity(provider, String.valueOf(_activityIdCounter),
                          startDate, endDate, TimeZone.getDefault());
            ca.setTitle(getMonthlyRecurringActivityTitle(i));
            model.addTimeCalendarActivity(ca);
            _activityIdCounter++;
        }


        // Add an activity that starts late in the day
        _addTimeActivity(model, null, null, 1, 22, 30, 0, 1, 0,
                         CalendarActivity.Recurring.CHANGED,
                         CalendarActivity.Reminder.OFF);

        // Add several time activities
        _addTimeActivity(model, null, null, 2, 0, 0, 6, 0, 0,
                         CalendarActivity.Recurring.RECURRING,
                         CalendarActivity.Reminder.ON);
    }


    /**
     * Add all day Activities start at 9 am
     * The title will have syntax
     *  <provider Id> activity <activity Id> <type and details of activity>
     */
    private void _addAllDayActivities(DemoSingleProviderCalendarModel model) {
        _addAlldayActivity(model, null, null, 0, 1);
        _addAlldayActivity(model, null, null, 1, 3);
    }

    /**
     * Add activities that span multiple days start at the day after today date at
     * 9 am.
     * The title will have syntax
     *  <provider Id> activity <activity Id> <type and details of activity>
     */
    private void _addMultipleDaysActivities(DemoSingleProviderCalendarModel model) {
        // add activity that lasts 3 days start at 9 am the day after today date
        _addTimeActivity(model, null, null, 1, 9, 0, 3, -3, 0);
        _addTimeActivity(model, null, null, -2, 14, 0, 2, 2, 0);

        _addTimeActivity(model, "Yosemite", null, 3, 9, 0, 2, 7, 0,
                         CalendarActivity.Recurring.SINGLE,
                         CalendarActivity.Reminder.ON);
        _addTimeActivity(model, "Europe", null, 3, 15, 0, 2, 0, 0,
                         CalendarActivity.Recurring.SINGLE,
                         CalendarActivity.Reminder.ON);
        // add a ways out to test what happens when you only have 'overflow' activity on certain day
        _addTimeActivity(model, null, null, 36, 17, 0, 5, +2, 15);

    }

    /**
     * Add Calendar activities to a model
     */
    private void _addActivitiesToModel(DemoSingleProviderCalendarModel model,
                                       int offset) {

        // Add lots of conflicting CalendarActivities
        _addBasicActivitiesConflicting(model, offset);
        _addNumActivities(model, 8 + offset, 3 + offset);
        _addAllDayActivities(model);
    }

    /**
     * Add activities for conflicting model.
     * The title will have sytax:
     *  <provider Id> activity <activity Id> <type and details of activity>
     * @param model
     */
    private void _addBasicActivitiesConflicting(DemoSingleProviderCalendarModel model,
                                                int daysAfterToday) {
        // create several conflicting actvities at daysAfterToday days
        // after today date start at 8 am
        int startHour = 8;
        int startMins = 0;

        for (int i = 1; i <= 5; i++) {
            _addTimeActivity(model, null,
                             "conflicting with activity " + String.valueOf(_activityIdCounter -
                                                                           1),
                             daysAfterToday, startHour, startMins, 0, 1, 0);

            startMins = startMins + 30;

            if (startMins == 60) {
                startMins = 0;
                startHour++;
            }
        }
    }

    // creates a calendar relative to today
    // for example if I want to create a calendar 3 days from today for 2:30pm, I'd call
    // _createCalendar(3, 14, 30);
    // that's 3 for 3 days, 14 for 2pm, and 30 for 30 minutes.

    private Calendar _createCalendarFromToday(int addDays, int hourOfDay,
                                              int minutes) {
        Calendar cal = Calendar.getInstance();
        try {
            DBConnector datahandler = new DBConnector();
            Connection conn;
            conn = datahandler.getDatabaseConn();

            String ActivityDetails =
                "begin TQC_COMMON_CURSORS.get_current_date(?,?,?,?);end;";

            CallableStatement cstActivityDetails;
            cstActivityDetails = conn.prepareCall(ActivityDetails);
            cstActivityDetails.registerOutParameter(1, OracleTypes.DATE);
            cstActivityDetails.registerOutParameter(2, OracleTypes.INTEGER);
            cstActivityDetails.registerOutParameter(3, OracleTypes.INTEGER);
            cstActivityDetails.registerOutParameter(4, OracleTypes.INTEGER);
            cstActivityDetails.execute();

            Date Today;
            Today = cstActivityDetails.getDate(1);
            cal.setTime(Today);

            cal.add(Calendar.DAY_OF_YEAR, addDays);
            cal.set(Calendar.HOUR_OF_DAY, hourOfDay);
            cal.set(Calendar.MINUTE, minutes);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);
          cstActivityDetails.close();
            conn.close();

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return cal;
    }

    // creates a calendar relative to the start calendar
    // for example if I want to create a calendar for 1 hour 15 minutes past the start, I'd call
    // _createCalendar(starCalendar, 0, 1, 15);

    private Calendar _createCalendar(Calendar startCalendar, int addDays,
                                     int addHours, int addMinutes) {
        Calendar cal = Calendar.getInstance();
        try {
            DBConnector datahandler = new DBConnector();
            Connection conn;
            conn = datahandler.getDatabaseConn();

            String ActivityDetails =
                "begin TQC_COMMON_CURSORS.get_current_date(?,?,?,?);end;";

            CallableStatement cstActivityDetails;
            cstActivityDetails = conn.prepareCall(ActivityDetails);
            cstActivityDetails.registerOutParameter(1, OracleTypes.DATE);
            cstActivityDetails.registerOutParameter(2, OracleTypes.INTEGER);
            cstActivityDetails.registerOutParameter(3, OracleTypes.INTEGER);
            cstActivityDetails.registerOutParameter(4, OracleTypes.INTEGER);
            cstActivityDetails.execute();

            Date Today;
            Today = cstActivityDetails.getDate(1);
            cal.setTime(Today);

            cal.add(Calendar.DAY_OF_YEAR, addDays);
            cal.add(Calendar.HOUR_OF_DAY, addHours);
            cal.add(Calendar.MINUTE, addMinutes);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);

            conn.close();

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }


        return cal;
    }

    // Print Calendar info to help debugging
    // TODO remove later

    private void _printCalendarFields(Calendar calendar) {
        System.out.println("=========================================");
        System.out.println("YEAR: " + calendar.get(Calendar.YEAR));
        System.out.println("MONTH: " + calendar.get(Calendar.MONTH));
        System.out.println("WEEK_OF_YEAR: " +
                           calendar.get(Calendar.WEEK_OF_YEAR));
        System.out.println("WEEK_OF_MONTH: " +
                           calendar.get(Calendar.WEEK_OF_MONTH));
        System.out.println("DATE: " + calendar.get(Calendar.DATE));
        System.out.println("DAY_OF_MONTH: " +
                           calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("DAY_OF_YEAR: " +
                           calendar.get(Calendar.DAY_OF_YEAR));
        System.out.println("DAY_OF_WEEK: " +
                           calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println("DAY_OF_WEEK_IN_MONTH: " +
                           calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));
        System.out.println("AM_PM: " + calendar.get(Calendar.AM_PM));
        System.out.println("HOUR: " + calendar.get(Calendar.HOUR));
        System.out.println("HOUR_OF_DAY: " +
                           calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println("MINUTE: " + calendar.get(Calendar.MINUTE));
        System.out.println("SECOND: " + calendar.get(Calendar.SECOND));
        System.out.println("MILLISECOND: " +
                           calendar.get(Calendar.MILLISECOND));
        System.out.println("=========================================");
    }

    private DemoCalendarModelWrapper _modelWrapper;
    private int _activityIdCounter =
        1; // This should be monotonically increasing
}

