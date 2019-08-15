package com.turnkey.Calendars;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;

import oracle.adf.view.rich.model.CalendarActivity;
import oracle.adf.view.rich.model.CalendarModel;
import oracle.adf.view.rich.model.CalendarProvider;


/**
 *   TODO synchronization
 * This wraps DemoSingleProviderCalendarModel instances
 */
public class DemoCalendarModelWrapper extends CalendarModel {
    public DemoCalendarModelWrapper() {
    }

    /* Start CalendarModel APIs */


    @Override
    public CalendarProvider getProvider(String id) {
        for (CalendarProvider provider : _providers) {
            if (id.equals(provider.getId()))
                return provider;
        }

        return null;
    }

    @Override
    public List<CalendarProvider> getProviders() {
        return _providers;
    }

    /**
     * Return all the TimeCalendarActivities within the specified range.
     * @return
     */
    @Override
    public synchronized List<CalendarActivity> getTimeActivities(Date rangeStart,
                                                                 Date rangeEnd,
                                                                 TimeZone timeZone) {
        List<CalendarActivity> all = new ArrayList<CalendarActivity>();

        for (DemoSingleProviderCalendarModel model : _models.values()) {
            List<CalendarActivity> activities =
                model.getTimeActivities(rangeStart, rangeEnd, timeZone);
            all.addAll(activities);
        }

        // sort
        Collections.sort(all,
                         new DemoSingleProviderCalendarModel.CalendarActivityComparator());

        return all;

    }

    /**
     * Return the AllDayCalendarActivities within the specified range.
     * @return
     */
    @Override
    public synchronized List<CalendarActivity> getAllDayActivities(Date rangeStart,
                                                                   Date rangeEnd,
                                                                   TimeZone timeZone) {

        List<CalendarActivity> all = new ArrayList<CalendarActivity>();

        for (DemoSingleProviderCalendarModel model : _models.values()) {
            List<CalendarActivity> activities =
                model.getAllDayActivities(rangeStart, rangeEnd, timeZone);
            all.addAll(activities);
        }

        // sort
        Collections.sort(all,
                         new DemoSingleProviderCalendarModel.CalendarActivityComparator());

        return all;
    }

    /**
     * Return a particular activty
     * @param providerId
     * @param activityId
     * @return
     */
    @Override
    public synchronized CalendarActivity getActivity(String providerId,
                                                     String activityId,
                                                     Date rangeStart,
                                                     Date rangeEnd,
                                                     TimeZone timeZone) {
        DemoSingleProviderCalendarModel model = _models.get(providerId);

        if (model != null) {
            return model.getActivity(providerId, activityId, rangeStart,
                                     rangeEnd, timeZone);
        }

        return null;
    }


    /* End CalendarModel APIs */

    /* Start DemoSingleProviderCalendarModel APIs */


    /**
     * Remove an AllDay activity fromt the master list
     * @param activity
     */
    public void removeAllDayCalendarActivity(CalendarActivity activity) {
        String providerId = activity.getProvider().getId();
        DemoSingleProviderCalendarModel model = _models.get(providerId);

        if (model != null) {
            model.removeAllDayCalendarActivity(activity);
        }
    }

    /**
     * Remove time activity from master list
     * @param activity
     */
    public void removeTimeCalendarActivity(CalendarActivity activity) {
        String providerId = activity.getProvider().getId();
        DemoSingleProviderCalendarModel model = _models.get(providerId);

        if (model != null) {
            model.removeTimeCalendarActivity(activity);
        }
    }

    /**
     * Add activity to the model.
     * @param activity
     */
    public void addTimeCalendarActivity(DemoCalendarActivity activity) {
        String providerId = activity.getProvider().getId();
        DemoSingleProviderCalendarModel model = _models.get(providerId);

        if (model != null) {
            model.addTimeCalendarActivity(activity);
        }
    }

    /**
     * Add activity to the model.
     * @param activity
     */
    public void addAllDayCalendarActivity(DemoCalendarActivity activity) {
        String providerId = activity.getProvider().getId();
        DemoSingleProviderCalendarModel model = _models.get(providerId);

        if (model != null) {
            model.addAllDayCalendarActivity(activity);
        }
    }

    /**
     * Add another CalendarModel to be included.
     * Get the Time and AllDay activities and store them.
     * @param model
     */
    public void addCalendarModel(DemoSingleProviderCalendarModel model) {
        CalendarProvider provider = model.getProvider();
        _providers.add(provider);
        _models.put(provider.getId(), model);
    }


    private List<CalendarProvider> _providers =
        new ArrayList<CalendarProvider>();
    private Map<String, DemoSingleProviderCalendarModel> _models =
        new ConcurrentHashMap<String, DemoSingleProviderCalendarModel>();

}
