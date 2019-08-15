package LMSG.view.Calendar;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import oracle.adf.view.rich.model.CalendarActivity;
import oracle.adf.view.rich.model.CalendarModel;

public class CalendarModelBean extends CalendarModel {
    public CalendarModelBean() {
        super();
    }

    public List<CalendarActivity> getTimeActivities(Date date, Date date1,
                                                    TimeZone timeZone) {
        return Collections.emptyList();
    }

    public List<CalendarActivity> getAllDayActivities(Date date, Date date1,
                                                      TimeZone timeZone) {
        return Collections.emptyList();
    }

    public CalendarActivity getActivity(String string, String string1,
                                        Date date, Date date1,
                                        TimeZone timeZone) {
        return null;
    }
}
