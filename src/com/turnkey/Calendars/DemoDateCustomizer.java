package com.turnkey.Calendars;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import oracle.adf.view.rich.util.DateCustomizer;

//import oracle.adfdemo.view.calendar.rich.model.Day;

public class DemoDateCustomizer extends DateCustomizer {
    public DemoDateCustomizer() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 20);

        _targetDay = new Day(cal);
    }

    public String format(Date date, String key, Locale locale, TimeZone tz) {

        if ("af|calendar::month-grid-cell-header-misc".equals(key)) {
            Calendar cal = Calendar.getInstance(tz, locale);
            cal.setTime(date);

            int firstDayOfWeek = cal.getFirstDayOfWeek();
            int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

            if (firstDayOfWeek == dayOfWeek)
                return "Week " + cal.get(Calendar.WEEK_OF_YEAR);

            return null;


        } else if ("af|calendar::month-grid-cell-header-day-link".equals(key) ||
                   "af|calendar::week-header-day-link".equals(key) ||
                   "af|calendar::day-header-row".equals(key) ||
                   "af|calendar::list-day-of-week-column".equals(key) ||
                   "af|calendar::list-day-of-month-link".equals(key)) {

            Day day = new Day(date, tz);
            long targetMillis = _targetDay.createDate(tz).getTime();
            long dateMillis = day.createDate(tz).getTime();
            long diff = dateMillis - targetMillis;

            //24 hours * 60 minutes * 60seconds * 1000 = 86400000;
            // if days isn't a long, then the return value is an int, which can be too small. For example
            // if days is the int 28, then the return value is negative,
            // but if it's the long 28, then it's fine
            // This is demo code only, this code doesn't work quite right for daylight savings.
            long days = diff / 86400000;

            if (days > 0)
                return "+" + String.valueOf(days);

            String val = String.valueOf(days);

            if ("af|calendar::week-header-day-link".equals(key))
                val = val + "(W)";
            else if ("af|calendar::day-header-row".equals(key))
                val = val + "(D)";
            else if ("af|calendar::list-day-of-week-column".equals(key))
                val = val + "(L1)";
            else if ("af|calendar::list-day-of-month-link".equals(key))
                val = val + "(L2)";

            return val;
        }

        return null;

    }

    private Day _targetDay;
}
