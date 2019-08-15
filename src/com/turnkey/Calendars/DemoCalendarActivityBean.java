package com.turnkey.Calendars;

import com.turnkey.Calendars.DemoCalendarActivity;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;

import oracle.adf.view.rich.model.CalendarActivity;

import com.turnkey.Calendars.Day;
import com.turnkey.Calendars.DemoCalendarActivity;


public class DemoCalendarActivityBean {
    public DemoCalendarActivityBean(DemoCalendarActivity activity,
                                    TimeZone tz) {
        _tz = tz;
        _activity = activity;

        if (CalendarActivity.TimeType.ALLDAY.equals(_activity.getTimeType())) {
            _allDay = true;
        } else {
            _allDay = false;
        }

    }

    public boolean isAllDay() {
        return _allDay;
    }


    public void setAllDay(boolean allDay) {
        _allDay = allDay;
    }

    public boolean isRecurring() {
        if (_activity.getRecurring() == CalendarActivity.Recurring.RECURRING) {
            return true;
        }

        return false;
    }

    public boolean isReminder() {
        if (_activity.getReminder() == CalendarActivity.Reminder.ON) {
            return true;
        }

        return false;
    }

    public void setReminder(boolean reminder) {
        _activity.setReminder(reminder ? CalendarActivity.Reminder.ON :
                              CalendarActivity.Reminder.OFF);
    }

    public void setFrom(Date from) {
        _activity.setStartDay(new Day(from, _tz));
        _activity.setStart(from);
    }

    public Date getFrom() {

        return _activity.getStartDate(_tz);
    }

    public Date getTo() {

        return _activity.getEndDate(_tz);
    }

    public void setTo(Date to) {
        // We want the 'to' to be the following day midnight, so add one day here.
        Day toDay = new Day(to, _tz);
        Calendar cal = toDay.createCalendar(_tz, null);
        cal.add(Calendar.DAY_OF_YEAR, 1);
        toDay.updateCalendar(cal);
        _activity.setEndDay(toDay);
        _activity.setEnd(to);
    }


    public void setRecurring(boolean isRecurring) {
        if (isRecurring) {
            _activity.setRecurring(CalendarActivity.Recurring.RECURRING);
        } else {
            if (_activity.getRecurring() ==
                CalendarActivity.Recurring.RECURRING) {
                _activity.setRecurring(CalendarActivity.Recurring.CHANGED);
            } else {
                _activity.setRecurring(CalendarActivity.Recurring.SINGLE);
            }
        }
    }

    public String getTitle() {
        return _activity.getTitle();
    }

    public String getProviderId() {
        return _activity.getProvider().getId();
    }

    public String getId() {
        return _activity.getId();
    }

    public String getLocation() {
        return _activity.getLocation();
    }

    public Map<String, Object> getCustomAttributes() {
        return _activity.getCustomAttributes();
    }


    public void setTitle(String title) {
        _activity.setTitle(title);
    }

    public void setLocation(String location) {
        _activity.setLocation(location);
    }


    public void setActivity(DemoCalendarActivity activity) {
        _activity = activity;
    }

    public DemoCalendarActivity getActivity() {
        return _activity;
    }


    protected DemoCalendarActivity _activity = null;
    private boolean _allDay = false;
    private TimeZone _tz;

}

