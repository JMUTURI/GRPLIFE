package com.turnkey.Calendars;

import java.awt.Color;

import LMSG.view.Base.GlobalCC;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import oracle.adf.view.rich.component.rich.data.RichCalendar;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanCheckbox;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.datatransfer.DataFlavor;
import oracle.adf.view.rich.datatransfer.Transferable;
import oracle.adf.view.rich.dnd.CalendarDropSite;
import oracle.adf.view.rich.dnd.DnDAction;
import oracle.adf.view.rich.event.CalendarActivityDurationChangeEvent;
import oracle.adf.view.rich.event.CalendarActivityEvent;
import oracle.adf.view.rich.event.CalendarDisplayChangeEvent;
import oracle.adf.view.rich.event.CalendarEvent;
import oracle.adf.view.rich.event.DialogEvent;
import oracle.adf.view.rich.event.DropEvent;
import oracle.adf.view.rich.event.PopupFetchEvent;
import oracle.adf.view.rich.event.TriggerType;
import oracle.adf.view.rich.model.CalendarActivity;
import oracle.adf.view.rich.model.CalendarProvider;
import oracle.adf.view.rich.util.CalendarActivityRamp;
import oracle.adf.view.rich.util.DateCustomizer;
import oracle.adf.view.rich.util.InstanceStyles;


import org.apache.myfaces.trinidad.change.AttributeComponentChange;
import org.apache.myfaces.trinidad.context.RequestContext;
import org.apache.myfaces.trinidad.model.CollectionModel;
import org.apache.myfaces.trinidad.model.RowKeySet;
import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;


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
public class DemoCalendarBean {
    // TODO people can easily change the end time to be after the start time, make sure the
    // demo handles this, the dialogListener should be checking this I guess.

    // TODO remove this hard coded id
    public static final String _CALENDAR_COMPONENT_ID = "demoTemplate:cal";
    private RichInputText creOwner;
    private RichInputText creTitle;
    private RichInputText creLocation;
    private RichInputDate creFrom;
    private RichInputDate creTo;
    private RichSelectBooleanCheckbox creReminder;
    private RichSelectOneChoice crePriority;

    public DemoCalendarBean() {
    }

    public DemoCalendarModelWrapper getCalendarModel() {
        return getModelBean().getCalendarModel();
    }

    /**
     * Listener for the DisplayChangeEvent
     */
    public void displayChangeListener(CalendarDisplayChangeEvent dce) {
        System.out.println("displayChangeListener " + dce);

        String view = dce.getNewView();
        System.out.println("     displayChangeListener view = " + view);

        Date activeDay = dce.getNewActiveDay();
        System.out.println("     displayChangeListener activeDay = " +
                           activeDay);

    }

    public void activityListener(CalendarActivityEvent ae) {

        CalendarActivity activity = ae.getCalendarActivity();

        if (activity == null) {
            // no activity with that id is found in the model
            System.out.println("No activity with event " + ae.toString());
            setCurrActivity(null);
            return;
        }

        setCurrActivity(new DemoCalendarActivityBean((DemoCalendarActivity)activity,
                                                     getTimeZone()));
    }

    public void activityDurationChangeListener(CalendarActivityDurationChangeEvent ae) {
        CalendarActivity activity = ae.getCalendarActivity();

        if (activity == null) {
            // no activity with that id is found in the model
            System.out.println("No activity with event " + ae.toString());
            setCurrActivity(null);

            // Since the user has acted on an activity that couldn't be found, ppr the page so
            // that they no longer see the activity
            RequestContext adfContext = RequestContext.getCurrentInstance();
            adfContext.addPartialTarget(getCalendarComponent());
            return;
        }

        DemoCalendarActivity demoActivity = ((DemoCalendarActivity)activity);
        TimeZone tz = getTimeZone();
        demoActivity.setEndDate(ae.getNewEndDate(), tz);
        setCurrActivity(new DemoCalendarActivityBean(demoActivity, tz));
    }

    public DnDAction handleDrop(DropEvent dropEvent) {
        return _handleDrop(dropEvent, false);
    }

    public DnDAction handleDropWithPopup(DropEvent dropEvent) {
        return _handleDrop(dropEvent, true);
    }

    public DnDAction _handleDrop(DropEvent dropEvent, boolean showPopup) {
        Transferable transferable = dropEvent.getTransferable();
        CalendarDropSite dropSite = (CalendarDropSite)dropEvent.getDropSite();
        Date dropSiteDate = dropSite.getDate();
        CalendarActivity.TimeType timeType = dropSite.getTimeType();

        CalendarActivity activity =
            (CalendarActivity)transferable.getData(DataFlavor.getDataFlavor(CalendarActivity.class));

        // If we have a calendar activitity that we are moving within the same view
        if (activity != null) {
            _handleCalendarActivityDrop(dropEvent, dropSiteDate, activity,
                                        showPopup);
            return dropEvent.getProposedAction();
        }

        // See if we have a drag and drop of a row to create a new activity.
        DataFlavor<RowKeySet> rowKeySetFlavor =
            DataFlavor.getDataFlavor(RowKeySet.class, "DnDAcivityModel");
        RowKeySet rowKeySet = transferable.getData(rowKeySetFlavor);
        if (rowKeySet != null) {
            _handleRowKeyDrop(dropEvent, transferable, dropSiteDate, timeType,
                              rowKeySet, showPopup);
            return dropEvent.getProposedAction();
        }

        return DnDAction.NONE;
    }

    private void _handleCalendarActivityDrop(DropEvent dropEvent,
                                             Date dropSiteDate,
                                             CalendarActivity activity,
                                             boolean showPopup) {
        DemoCalendarActivity demoActivity = ((DemoCalendarActivity)activity);

        // If this is a timed event
        Date startDate = demoActivity.getStart();
        TimeZone tz = getTimeZone();
        Calendar startCal = Calendar.getInstance(tz);
        startCal.setTime(startDate);

        Calendar dropCal = Calendar.getInstance(tz);
        dropCal.setTime(dropSiteDate);

        int startDayOfYear = startCal.get(Calendar.DAY_OF_YEAR);
        int startHour = startCal.get(Calendar.HOUR_OF_DAY);
        int startMin = startCal.get(Calendar.MINUTE);
        int dropDayOfYear = dropCal.get(Calendar.DAY_OF_YEAR);
        int dropHour = dropCal.get(Calendar.HOUR_OF_DAY);
        int dropMin = dropCal.get(Calendar.MINUTE);

        // move the start date to the new time
        if (startDayOfYear != dropDayOfYear) {
            startCal.set(Calendar.DAY_OF_YEAR, dropDayOfYear);
            startCal.set(Calendar.YEAR, dropCal.get(Calendar.YEAR));
            startCal.set(Calendar.MONTH, dropCal.get(Calendar.MONTH));
        }

        // move this activity to the new location
        if (demoActivity.isAllDay()) {
            _proposedStartDate = startCal.getTime();

            // Get the original start day
            Day startDay = demoActivity.getStartDay();

            // Calcuate new end day by using the new start day and the original delta
            Day endDay = demoActivity.getEndDay();
            Calendar endCal = Calendar.getInstance(tz);

            startCal = Calendar.getInstance(tz);
            endDay.updateCalendar(endCal);
            startDay.updateCalendar(startCal);

            long delta =
                endCal.getTime().getTime() - startCal.getTime().getTime();
            Date endDate = new Date(_proposedStartDate.getTime() + delta);

            if (showPopup &&
                CalendarActivity.Recurring.RECURRING.equals(demoActivity.getRecurring())) {
                _proposedEndDate = endDate;
                _addOpenPopupScript(FacesContext.getCurrentInstance(),
                                    "dmoTpl:moveActivityPopup", null);
            } else {
                // update to the new start and end day
                demoActivity.setStartDay(new Day(_proposedStartDate, tz));
                demoActivity.setEndDay(new Day(endDate, tz));
            }
        } else {
            String view =
                ((RichCalendar)dropEvent.getDropComponent()).getView();

            if ((RichCalendar.VIEW_DAY.equals(view) ||
                 RichCalendar.VIEW_WEEK.equals(view)) &&
                CalendarActivity.TimeType.TIME.equals(activity.getTimeType())) {
                if (startHour != dropHour)
                    startCal.set(Calendar.HOUR_OF_DAY, dropHour);

                if (dropMin != startMin) {
                    if (dropMin == 0 && startMin >= 30)
                        startCal.add(Calendar.MINUTE, -30);
                    else if (dropMin == 30 && startMin < 30)
                        startCal.add(Calendar.MINUTE, 30);
                }
            }

            Date endDate = demoActivity.getEnd();
            long delta = endDate.getTime() - startDate.getTime();

            startDate = startCal.getTime();
            endDate = new Date(startDate.getTime() + delta);

            if (showPopup &&
                CalendarActivity.Recurring.RECURRING.equals(demoActivity.getRecurring())) {
                _proposedStartDate = startDate;
                _proposedEndDate = endDate;
                _addOpenPopupScript(FacesContext.getCurrentInstance(),
                                    "dmoTpl:moveActivityPopup", null);
            } else {
                demoActivity.setStart(startDate);
                demoActivity.setEnd(endDate);
            }
        }

        setCurrActivity(new DemoCalendarActivityBean((DemoCalendarActivity)activity,
                                                     getTimeZone()));
    }

    private void _handleRowKeyDrop(DropEvent dropEvent,
                                   Transferable transferable,
                                   Date dropSiteDate,
                                   CalendarActivity.TimeType timeType,
                                   RowKeySet rowKeySet, boolean showPopup) {
        // Get the model for the dragged component.
        CollectionModel dragModel =
            transferable.getData(CollectionModel.class);
        if (dragModel != null) {
            String view =
                ((RichCalendar)dropEvent.getDropComponent()).getView();
            boolean isAllDay =
                CalendarActivity.TimeType.ALLDAY.equals(timeType);

            Calendar dropCal = Calendar.getInstance(getTimeZone());
            dropCal.setTime(dropSiteDate);

            if (RichCalendar.VIEW_MONTH.equals(view)) {
                // default the activity to 10 am in the month view
                dropCal.add(Calendar.HOUR_OF_DAY, 10);
                dropSiteDate = dropCal.getTime();
            }

            // Set the row key for this model using the row key from the transferrable.
            Object currKey = rowKeySet.iterator().next();
            dragModel.setRowKey(currKey);

            // And now get the actual data from the dragged model.
            DnDActivityData dnDDemoData =
                (DnDActivityData)dragModel.getRowData();

            // Create a new activity with the data.
            DemoCalendarActivity newActivity =
                _createNewActivity(dropSiteDate, isAllDay ?
                                                 CalendarActivity.TimeType.ALLDAY :
                                                 CalendarActivity.TimeType.TIME);
            newActivity.setTitle(dnDDemoData.getTitle());

            if (dnDDemoData.isRecurring())
                newActivity.setRecurring(CalendarActivity.Recurring.RECURRING);

            if (showPopup) {
                _addOpenPopupScript(FacesContext.getCurrentInstance(),
                                    "dmoTpl:createDndExternalPopup", null);
            } else {
                _addActivityToModel(newActivity);
            }
        }
    }

    public void moveDnDDialogListener(DialogEvent event) {
        DialogEvent.Outcome outcome = event.getOutcome();

        if (outcome == DialogEvent.Outcome.ok) {
            DemoCalendarActivityBean activityBean = getCurrActivity();
            DemoCalendarActivity activity = activityBean.getActivity();

            if (activity.isAllDay()) {
                TimeZone tz = getTimeZone();
                activity.setStartDay(new Day(_proposedStartDate, tz));
                activity.setEndDay(new Day(_proposedEndDate, tz));
            } else {
                activity.setStart(_proposedStartDate);
                activity.setEnd(_proposedEndDate);
            }

            RichCalendar calendar = getCalendarComponent();
            RequestContext adfContext = RequestContext.getCurrentInstance();
            adfContext.addPartialTarget(calendar);
        }
    }

    public void createDnDExternalDialogListener(DialogEvent event) {
        DialogEvent.Outcome outcome = event.getOutcome();

        if (outcome == DialogEvent.Outcome.ok) {
            DemoCalendarActivityBean activityBean = getNewActivity();
            // append to model
            _addActivityToModel(activityBean.getActivity());

            // Check all day flag
            _checkAllDay(activityBean);

            RichCalendar calendar = getCalendarComponent();
            RequestContext adfContext = RequestContext.getCurrentInstance();
            adfContext.addPartialTarget(calendar);
        }
    }


    protected RichCalendar getCalendarComponent() {
        FacesContext context = FacesContext.getCurrentInstance();
        UIComponent root = context.getViewRoot();
        return (RichCalendar)root.findComponent(DemoCalendarBean._CALENDAR_COMPONENT_ID);
    }

    // This is the popupFetchListener for the create popup.
    // This will create a new activity with the information that was saved in the calendarListener,
    // which was called first.
    // The activity does not get added to the model until the user clicks ok on the popup - this
    // is done in the dialogListener.

    public void createPopupListener(PopupFetchEvent event) {

        if (_calendarEventInfo != null) {
            // TODO in some rare cases a new activity is created twice, both in createPopupListener
            // and in calendarListener. For example if I
            //   - right click the context menu,  but then don't select anything in the context menu,
            //   - then I click the calendar to create an activity
            //
            // Considered calling createNewActivity in an actionListener
            // on the commandMenuItem instead, but the actionListener isn't getting called because
            // there's a showPopupBehavior on the commandMenuItem. ShowPopupBehavior cancels
            // the event that triggers it, see
            // Bug 7438294 - showpopupbehavior: add option to not cancel event
            _createNewActivity(_calendarEventInfo.getTriggerDate(),
                               _calendarEventInfo.getTimeType());

            _calendarEventInfo = null;
        }
    }

    // Helpers

    private void _initModel() {
        if (this.isUseArabic())
            _modelBean = new DemoCalendarArabicModelBean();
        else
            _modelBean = new DemoCalendarModelBean();

        //Set<String>[] tags = _modelBean.getTags();
        List<Color> defaultOrderProviderColors =
            getDefaultOrderProviderColors();

        List<CalendarProvider> providerList =
            _modelBean.getCalendarModel().getProviders();
        _activityStyles =
                new HashMap<Set<String>, InstanceStyles>(providerList.size());

        for (int i = 0; i < providerList.size(); i++) {
            Color color =
                defaultOrderProviderColors.get(i % defaultOrderProviderColors.size());
            InstanceStyles styles =
                CalendarActivityRamp.getActivityRamp(color);
            Set<String> tags = new CopyOnWriteArraySet<String>();
            CalendarProvider provider = providerList.get(i);
            // TODO - should I be able to look this up instead of creating it?
            tags.add(provider.getId());
            _activityStyles.put(tags, styles);
            ProviderData data = new ProviderData(provider, color);
            _providerData.put(provider, data);
        }
    }


    private void _checkAllDay(DemoCalendarActivityBean activityBean) {
        // if its all day but the current activity is not then change it
        DemoCalendarActivity activity = activityBean.getActivity();
        boolean isActivityAllDay =
            CalendarActivity.TimeType.ALLDAY.equals(activity.getTimeType());

        if (activityBean.isAllDay() && !isActivityAllDay) {
            changeTimeToAllDayCalendarActivity(activity);
        }
        // else if its not all-day but the current activtiy is, then changhe it
        else if (!activityBean.isAllDay() && isActivityAllDay) {
            changeAllDayToTimeCalendarActivity(activity);
        }
    }

    public String CreateNewActivity() {
        try {
            DemoCalendarActivityBean activityBean = getNewActivity();
            // append to model
            _addActivityToModel(activityBean.getActivity());
            // Check all day flag
            _checkAllDay(activityBean);

            RichCalendar calendar = getCalendarComponent();
            RequestContext adfContext = RequestContext.getCurrentInstance();
            adfContext.addPartialTarget(calendar);

        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
        return null;
    }


    public void createDialogListener(DialogEvent event) {
        try {
            DialogEvent.Outcome outcome = event.getOutcome();

            if (outcome == DialogEvent.Outcome.ok) {
                SimpleDateFormat sdf1 =
                    new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
                SimpleDateFormat sdf2 =
                    new SimpleDateFormat(("yyyy-mm-dd hh:mm:ss"));
                SimpleDateFormat sdf3 =
                    new SimpleDateFormat(("dd/MM/yyyy hh:mm:ss aaa"));

                Date MyDate = new Date();
                //Persist to Database.
                String TodaysDate = GlobalCC.findCurrentDate();
                String Owner = null;
                if (creOwner.getValue() == null) {

                } else {
                    Owner = creOwner.getValue().toString();
                }

                String Title = null;
                if (creTitle.getValue() == null) {

                } else {
                    Title = creTitle.getValue().toString();
                }

                String Location = null;
                if (creLocation.getValue() == null) {

                } else {
                    Location = creLocation.getValue().toString();
                }

                String DateFrom = null;
                if (creFrom.getValue() == null) {

                } else {
                    MyDate = sdf1.parse(creFrom.getValue().toString());
                    DateFrom = sdf3.format(MyDate);
                }

                String DateTo = null;
                if (creTo.getValue() == null) {

                } else {
                    MyDate = sdf1.parse(creTo.getValue().toString());
                    System.out.println(sdf1.parse(creTo.getValue().toString()));
                    DateTo = sdf3.format(MyDate);
                }

                DemoCalendarModelBean NewModel = new DemoCalendarModelBean();
                NewModel._createNewCalActivity(Location, Title, TodaysDate,
                                               DateFrom, DateTo);

                /*
      DemoCalendarActivityBean activityBean = getNewActivity();
      // append to model
      _addActivityToModel(activityBean.getActivity());

      // Check all day flag
      _checkAllDay(activityBean);
      */

                RichCalendar calendar = getCalendarComponent();
                RequestContext adfContext =
                    RequestContext.getCurrentInstance();
                adfContext.addPartialTarget(calendar);
            }
        } catch (Exception e) {
            GlobalCC.EXCEPTIONREPORTING(null, e);
        }
    }

    private void _addActivityToModel(DemoCalendarActivity activity) {
        DemoCalendarModelWrapper model = getCalendarModel();

        if (CalendarActivity.TimeType.ALLDAY.equals(activity.getTimeType())) {
            model.addAllDayCalendarActivity(activity);
        } else {
            model.addTimeCalendarActivity(activity);
        }
    }


    public void editDialogListener(DialogEvent event) {
        DialogEvent.Outcome outcome = event.getOutcome();

        if (outcome == DialogEvent.Outcome.ok) {
            DemoCalendarActivityBean activityBean = getCurrActivity();
            // Check all day flag
            _checkAllDay(activityBean);

            RichCalendar calendar = getCalendarComponent();
            RequestContext adfContext = RequestContext.getCurrentInstance();
            adfContext.addPartialTarget(calendar);
        }

    }


    public void deleteListener(DialogEvent event) {
        DialogEvent.Outcome outcome = event.getOutcome();

        if (outcome == DialogEvent.Outcome.ok) {

            DemoCalendarActivityBean currActivityBean = getCurrActivity();
            DemoCalendarModelWrapper model = getCalendarModel();

            // TODO: NEED TO CHANGE THIS TO GET CALENDAR ACTVITIY FROM EVENT
            CalendarActivity activity =
                model.getActivity(currActivityBean.getProviderId(),
                                  currActivityBean.getId(), null, null,
                                  getTimeZone());
            if (CalendarActivity.TimeType.ALLDAY.equals(activity.getTimeType())) {
                model.removeAllDayCalendarActivity(activity);
            } else {
                model.removeTimeCalendarActivity(activity);
            }

            setCurrActivity(null);
            RequestContext adfContext = RequestContext.getCurrentInstance();
            adfContext.addPartialTarget(getCalendarComponent());
        }
    }


    /**
     * Listener for the CalendarEvent. This event gets sent when the user acts on free space
     * on the calendar. In the demo, we have popups for create and contextMenu. If the user
     * clicked free space, create a new activity, otherwise save off the trigger date and timeType
     * info in case the end user picks 'create' in the context menu. In that case we
     * create a new activity with the saved state in the popupFetchListener on the create popup.
     * Then if the user presses ok in the create popup, the activity is added to the model.
     * @see #createPopupListener
     */
    public void calendarListener(CalendarEvent ce) {
        CalendarActivity.TimeType timeType = ce.getTimeType();
        Date triggerDate = (Date)ce.getTriggerDate().clone();
        SimpleDateFormat sdf3 = new SimpleDateFormat(("dd/MM/yyyy hh:mm:ss"));
        System.out.println(sdf3.format(triggerDate));

        TriggerType tt = ce.getTriggerType();

        if (TriggerType.MOUSE.equals(tt)) {
            // TODO see todo in createPopupListener for some additional info
            this._createNewActivity(triggerDate, timeType);
            _calendarEventInfo = null;
        } else {
            _calendarEventInfo = new CalendarEventInfo(triggerDate, timeType);
        }
    }

    /**
     * Get the DemoCalendarModelBean to instantiate model
     * @return instance of DemoCalendarModelBean
     */
    public DemoCalendarModelBean getModelBean() {
        if (_modelBean == null)
            _initModel();
        return _modelBean;
    }

    private void _addOpenPopupScript(FacesContext context, String popupId,
                                     String alignId) {
        StringBuilder script = new StringBuilder();
        script.append("var popup = AdfPage.PAGE.findComponent('").append(popupId).append("'); ").append("if (!popup.isPopupVisible()) { ").append("var hints = {}; ");
        if (alignId != null)
            script.append("hints[AdfRichPopup.HINT_ALIGN_ID] = '").append(alignId).append("'; ");

        script.append("hints[AdfRichPopup.HINT_ALIGN] = AdfRichPopup.ALIGN_AFTER_START; ").append("popup.show(hints);}");

        ExtendedRenderKitService erks =
            Service.getService(context.getRenderKit(),
                               ExtendedRenderKitService.class);
        erks.addScript(context, script.toString());
    }

    public String getView() {
        return _view;
    }

    public void setCurrActivity(DemoCalendarActivityBean currActivity) {
        _currActivity = currActivity;
    }

    public void setNewActivity(DemoCalendarActivityBean newActivity) {
        _newActivity = newActivity;
    }

    public DemoCalendarActivityBean getCurrActivity() {
        return _currActivity;
    }

    public DemoCalendarActivityBean getNewActivity() {
        return _newActivity;
    }

    /**
     * Set time zone and refresh the calendar component
     * @param timeZone
     */
    public void setTimeZoneString(String timeZone) {
        TimeZone tz = null;

        if (timeZone != null)
            tz = TimeZone.getTimeZone(timeZone);
        else
            tz = getDefaultTimeZone();

        setTimeZone(tz);
    }

    /**
     * Return time zone info
     * @return
     */
    public String getTimeZoneString() {
        TimeZone tz = getTimeZone();
        return tz.getID();
    }


    /**
     * Set the timeZone
     * @param _timeZone
     */
    public void setTimeZone(TimeZone _timeZone) {
        this._timeZone = _timeZone;
    }

    /**
     * Get the timeZone
     * @return
     */
    public TimeZone getTimeZone() {
        return _timeZone;
    }

    // TODO - the demo shouldn't use this, it should use an iterator for the legend area

    public List<CalendarProvider> getProviders() {
        return getModelBean().getCalendarModel().getProviders();
    }

    /**
     * Change Time activity to all day.
     * @param activity
     */
    public void changeTimeToAllDayCalendarActivity(CalendarActivity activity) {
        DemoCalendarActivity ca = (DemoCalendarActivity)activity;
        ca.setTimeType(CalendarActivity.TimeType.ALLDAY);

        DemoCalendarModelWrapper model = getCalendarModel();

        model.removeTimeCalendarActivity(ca);
        model.addAllDayCalendarActivity(ca);

    }

    /**
     * change all day activity to Time Activity
     * @param activity
     */
    public void changeAllDayToTimeCalendarActivity(CalendarActivity activity) {

        DemoCalendarActivity ca = (DemoCalendarActivity)activity;
        ca.setTimeType(CalendarActivity.TimeType.TIME);

        DemoCalendarModelWrapper model = getCalendarModel();

        model.removeAllDayCalendarActivity(ca);
        model.addTimeCalendarActivity(ca);

    }


    public void providerColorChange(ValueChangeEvent vce) {
        UIComponent component = vce.getComponent();
        String providerId =
            component.getAttributes().get("providerId").toString();
        // TODO - should I be creating this every time? used to use (getModelBean().getTags()[0]
        Set<String> providerSet = new CopyOnWriteArraySet<String>();
        providerSet.add(providerId);


        Color newColor = (Color)vce.getNewValue();
        InstanceStyles styles = CalendarActivityRamp.getActivityRamp(newColor);

        _activityStyles.put(providerSet, styles);

        RequestContext adfContext = RequestContext.getCurrentInstance();
        adfContext.addPartialTarget(getCalendarComponent());

    }

    public void providerEnabledChange(ValueChangeEvent vce) {
        RequestContext adfContext = RequestContext.getCurrentInstance();
        adfContext.addPartialTarget(getCalendarComponent());

    }

    public List getColorData() {
        return _colorData;
    }


    public Map<Set<String>, InstanceStyles> getActivityStyles() {
        return _activityStyles;
    }

    /* Helpers and private members */

    // create a new activity with the triggerDate and timeType information.
    // if it is allday, then the endDate is midnight.
    // This is called from the popupFetchListener just before the create popup shows.

    private DemoCalendarActivity _createNewActivity(Date triggerDate,
                                                    CalendarActivity.TimeType timeType) {

        // Get latest activity id
        int activityId = getModelBean().getAndIncreaseActivityIdCounter();

        // if it is all day, then set the endDay to be midnight.
        TimeZone tz = getTimeZone();
        Calendar endCal = Calendar.getInstance(tz);
        endCal.setTime(triggerDate);
        boolean isAllDay = CalendarActivity.TimeType.ALLDAY.equals(timeType);
        boolean isUnknown = CalendarActivity.TimeType.UNKNOWN.equals(timeType);

        if (isAllDay || isUnknown) {
            // default is 1 day for allDay or unknown for end date
            endCal.add(Calendar.DAY_OF_YEAR, 1);
        } else {
            // default is 1 hour for timed activities for end date
            endCal.add(Calendar.HOUR_OF_DAY, 1);
        }


        // if it is not All Day, then we need to call the constructor that takes Date Objects
        // TODO fix this when we have a constructor that takes the TimeType.
        DemoCalendarActivity activity =
            new DemoCalendarActivity(getModelBean().getCalendarModel().getProviders().get(0),
                                     String.valueOf(activityId), triggerDate,
                                     endCal.getTime(), tz);


        // for this demo, if the timetype is unknown like it would be when creating an activity by
        // clicking on the List or Month view,
        // then we will set it to ALLDAY. If an app developer was dragging/dropping a calendar activity
        // from elsewhere, he'd probably copy the timeType from the activity into the new activity.
        if (isAllDay || isUnknown)
            //activity.setTimeType(CalendarActivity.TimeType.ALLDAY);
            activity.setTimeType(timeType);
        else
            activity.setTimeType(timeType);
        setNewActivity(new DemoCalendarActivityBean(activity, tz));

        return activity;
    }

    public DateCustomizer getDateCustomizer() {
        return _dateCustomizer;
    }

    public Date getProposedStartDate() {
        return _proposedStartDate;
    }

    public void setUseArabic(boolean _useArabic) {
        this._useArabic = _useArabic;
    }

    public boolean isUseArabic() {
        return _useArabic;
    }

    public Map<CalendarProvider, ProviderData> getProviderData() {
        return _providerData;
    }

    public void setCreOwner(RichInputText creOwner) {
        this.creOwner = creOwner;
    }

    public RichInputText getCreOwner() {
        return creOwner;
    }

    public void setCreTitle(RichInputText creTitle) {
        this.creTitle = creTitle;
    }

    public RichInputText getCreTitle() {
        return creTitle;
    }

    public void setCreLocation(RichInputText creLocation) {
        this.creLocation = creLocation;
    }

    public RichInputText getCreLocation() {
        return creLocation;
    }

    public void setCreFrom(RichInputDate creFrom) {
        this.creFrom = creFrom;
    }

    public RichInputDate getCreFrom() {
        return creFrom;
    }

    public void setCreTo(RichInputDate creTo) {
        this.creTo = creTo;
    }

    public RichInputDate getCreTo() {
        return creTo;
    }

    public void setCreReminder(RichSelectBooleanCheckbox creReminder) {
        this.creReminder = creReminder;
    }

    public RichSelectBooleanCheckbox getCreReminder() {
        return creReminder;
    }

    public void setCrePriority(RichSelectOneChoice crePriority) {
        this.crePriority = crePriority;
    }

    public RichSelectOneChoice getCrePriority() {
        return crePriority;
    }


    // inner class to hold the state of the CalendarEvent that we retrieve in our calendarListener
    // method. This will later be used in the actionListener for the create context menu.

    private static class CalendarEventInfo {
        public CalendarEventInfo(Date triggerDate,
                                 CalendarActivity.TimeType timeType) {
            _triggerDate = triggerDate;
            _timeType = timeType;
        }


        // we save the 'state' of a CalendarEvent if the triggerType is CONTEXT_MENU
        private Date _triggerDate;
        private CalendarActivity.TimeType _timeType;

        public Date getTriggerDate() {
            return _triggerDate;
        }

        public CalendarActivity.TimeType getTimeType() {
            return _timeType;
        }
    }

    private static TimeZone getDefaultTimeZone() {
        return TimeZone.getTimeZone("America/Los_Angeles");
    }

    public ArrayList<DnDActivityData> getDndActivitiesValues() {
        if (_dndActivitiesValues == null) {
            _dndActivitiesValues = new ArrayList<DnDActivityData>(3);
            _dndActivitiesValues.add(new DnDActivityData("New Activity",
                                                         "loc1", false));
            _dndActivitiesValues.add(new DnDActivityData("Another Activity",
                                                         "loc2", false));
            _dndActivitiesValues.add(new DnDActivityData("Some Other Activity",
                                                         "loc3", false));
            _dndActivitiesValues.add(new DnDActivityData("Recurring Acitivity",
                                                         "loc4", true));
        }
        return _dndActivitiesValues;
    }

    public SelectItem[] getPrioritySelectItems() {
        if (_prioritySelectItems == null) {
            _prioritySelectItems = new SelectItem[3];

            _prioritySelectItems[0] =
                    new SelectItem(DemoCalendarActivity.Priority.LOW, "Low",
                                   null, false);
            _prioritySelectItems[1] =
                    new SelectItem(DemoCalendarActivity.Priority.MEDIUM,
                                   "Medium", null, false);
            _prioritySelectItems[2] =
                    new SelectItem(DemoCalendarActivity.Priority.HIGH, "High",
                                   null, false);
        }

        return _prioritySelectItems;
    }

    public SelectItem[] getAccessSelectItems() {
        if (_accessSelectItems == null) {
            _accessSelectItems = new SelectItem[3];

            _accessSelectItems[0] =
                    new SelectItem(DemoCalendarActivity.Access.PRIVATE,
                                   "Private", null, false);
            _accessSelectItems[1] =
                    new SelectItem(DemoCalendarActivity.Access.CONFIDENTIAL,
                                   "Confidential", null, false);
            _accessSelectItems[2] =
                    new SelectItem(DemoCalendarActivity.Access.PUBLIC,
                                   "Public", null, false);
        }

        return _accessSelectItems;
    }

    public SelectItem[] getStatusSelectItems() {
        if (_statusSelectItems == null) {
            _statusSelectItems = new SelectItem[3];

            _statusSelectItems[0] =
                    new SelectItem(DemoCalendarActivity.Status.CANCELLED,
                                   "Cancelled", null, false);
            _statusSelectItems[1] =
                    new SelectItem(DemoCalendarActivity.Status.TENTATIVE,
                                   "Tentative", null, false);
            _statusSelectItems[2] =
                    new SelectItem(DemoCalendarActivity.Status.CONFIRMED,
                                   "Confirmed", null, false);
        }

        return _statusSelectItems;
    }


    public static class DnDActivityData {
        private String _title;
        private String _location;
        private boolean _recurring;

        DnDActivityData(String title, String location, boolean recurring) {
            this._title = title;
            this._recurring = recurring;
            this._location = location;
        }

        public String getTitle() {
            return _title;
        }

        public boolean isRecurring() {
            return _recurring;
        }

        public String getLocation() {
            return _location;
        }
    }

    /**
     * @return The default order of colors for providers
     */
    static public List<Color> getDefaultOrderProviderColors() {
        return _defaultOrderProviderColors;
    }

    private Map<CalendarProvider, ProviderData> _providerData =
        new ConcurrentHashMap<CalendarProvider, ProviderData>(3);

    public static class ProviderData {
        public ProviderData(CalendarProvider provider, Color color) {
            _provider = provider;
            _color = color;

        }

        public void setColor(Color _color) {
            this._color = _color;
        }

        public Color getColor() {
            return _color;
        }

        public boolean isEnabled() {
            return _provider.getEnabled().equals(CalendarProvider.Enabled.ENABLED);
        }

        public void setEnabled(boolean enabled) {
            if (enabled)
                _provider.setEnabled(CalendarProvider.Enabled.ENABLED);
            else
                _provider.setEnabled(CalendarProvider.Enabled.DISABLED);
        }

        private CalendarProvider _provider;
        private Color _color;
    }


    private static List<Color> _defaultOrderProviderColors;
    static {
        _defaultOrderProviderColors = new ArrayList<Color>(12);

        CalendarActivityRamp redRamp =
            CalendarActivityRamp.getActivityRamp(CalendarActivityRamp.RampKey.RED);
        CalendarActivityRamp orangeRamp =
            CalendarActivityRamp.getActivityRamp(CalendarActivityRamp.RampKey.ORANGE);
        CalendarActivityRamp blueRamp =
            CalendarActivityRamp.getActivityRamp(CalendarActivityRamp.RampKey.BLUE);
        CalendarActivityRamp greenRamp =
            CalendarActivityRamp.getActivityRamp(CalendarActivityRamp.RampKey.GREEN);
        CalendarActivityRamp goldRamp =
            CalendarActivityRamp.getActivityRamp(CalendarActivityRamp.RampKey.GOLD);
        CalendarActivityRamp tealRamp =
            CalendarActivityRamp.getActivityRamp(CalendarActivityRamp.RampKey.TEAL);
        CalendarActivityRamp lavendarRamp =
            CalendarActivityRamp.getActivityRamp(CalendarActivityRamp.RampKey.LAVENDAR);
        CalendarActivityRamp seaweedRamp =
            CalendarActivityRamp.getActivityRamp(CalendarActivityRamp.RampKey.SEAWEED);
        CalendarActivityRamp indigoRamp =
            CalendarActivityRamp.getActivityRamp(CalendarActivityRamp.RampKey.INDIGO);
        CalendarActivityRamp plumRamp =
            CalendarActivityRamp.getActivityRamp(CalendarActivityRamp.RampKey.PLUM);
        CalendarActivityRamp limeRamp =
            CalendarActivityRamp.getActivityRamp(CalendarActivityRamp.RampKey.LIME);
        CalendarActivityRamp midnightblueRamp =
            CalendarActivityRamp.getActivityRamp(CalendarActivityRamp.RampKey.MIDNIGHTBLUE);

        _defaultOrderProviderColors.add(redRamp.getRepresentativeColor());
        _defaultOrderProviderColors.add(orangeRamp.getRepresentativeColor());
        _defaultOrderProviderColors.add(blueRamp.getRepresentativeColor());
        _defaultOrderProviderColors.add(greenRamp.getRepresentativeColor());
        _defaultOrderProviderColors.add(goldRamp.getRepresentativeColor());
        _defaultOrderProviderColors.add(tealRamp.getRepresentativeColor());
        _defaultOrderProviderColors.add(lavendarRamp.getRepresentativeColor());
        _defaultOrderProviderColors.add(seaweedRamp.getRepresentativeColor());
        _defaultOrderProviderColors.add(indigoRamp.getRepresentativeColor());
        _defaultOrderProviderColors.add(plumRamp.getRepresentativeColor());
        _defaultOrderProviderColors.add(limeRamp.getRepresentativeColor());
        _defaultOrderProviderColors.add(midnightblueRamp.getRepresentativeColor());
    }

    // used to populate selectItems for status, priority, and access
    private SelectItem[] _statusSelectItems;
    private SelectItem[] _prioritySelectItems;
    private SelectItem[] _accessSelectItems;


    private static ArrayList<DnDActivityData> _dndActivitiesValues;


    private static DemoCalendarActivityBean _currActivity;
    private static DemoCalendarActivityBean _newActivity;
    private String _view = null;
    private TimeZone _timeZone = getDefaultTimeZone();
    private DemoCalendarModelBean _modelBean;
    private Map<Set<String>, InstanceStyles> _activityStyles;
    private List _colorData = CalendarActivityRamp.getRampColorKeys();

    private CalendarEventInfo _calendarEventInfo;

    private DateCustomizer _dateCustomizer = new DemoDateCustomizer();

    private Date _proposedStartDate;
    private Date _proposedEndDate;

    private boolean _useArabic = false;


    //*********************************************************************************************
    // START code used in the demo for adding a date picker where we're pushing new values
    // to the component
    //*********************************************************************************************

    public Date getActiveDayCompInstance() {
        RichCalendar calendar = getCalendarComponent();
        return calendar.getActiveDay();
    }


    public void setActiveDayCompInstance(Date activeDay) {
        // In certain situations, for example when the built in toolbar buttons are used,
        // the 'view' and/or 'activeDay' attribute is updated by the framework. However when these
        // attributes are set by the framework they are only set locally on the
        // component, and the component no longer pulls the value from the EL expression.
        // As long as a local value is set any updates to the back end are ignored.
        //
        // Therefore, in cases where you need to update these attributes you have 2 choices. In both
        // cases you need to add an attributeComponentChange for the change manager. The choices are:
        //
        //   1. to pull from the back end you have to have a displayChangeListener
        //      which nulls out the local value on the component so that the component will
        //      pull data from the back end.
        //   2. push the new value onto the component instance. The code in this method implements this
        //      strategy.

        // update the value on the component instance
        RichCalendar calendar = getCalendarComponent();
        calendar.setActiveDay(activeDay);

        // Implicitly record a change for 'activeDay' attribute
        AttributeComponentChange aa =
            new AttributeComponentChange(RichCalendar.ACTIVE_DAY_KEY.getName(),
                                         activeDay);
        RequestContext reqContext = RequestContext.getCurrentInstance();
        FacesContext context = FacesContext.getCurrentInstance();
        reqContext.getChangeManager().addComponentChange(context, calendar,
                                                         aa);
    }

    //*********************************************************************************************
    // END code used in the demo for adding a date picker where we're pushing new values
    // to the component
    //*********************************************************************************************


    //*********************************************************************************************
    // START code used in the demo for adding a date picker where we're pulling the
    // active day from the back end
    //*********************************************************************************************
    private Date _activeDay;

    public void setActiveDay(Date activeDay) {
        _activeDay = activeDay;
    }

    public Date getActiveDay() {
        return _activeDay;
    }

    public void displayChangeActiveDayListener(CalendarDisplayChangeEvent dce) {
        // In certain situations, for example when the built in toolbar buttons are used,
        // the 'view' and/or 'activeDay' attribute is updated by the framework. However when these
        // attributes are set by the framework they are only set locally on the
        // component, and the component no longer pulls the value from the EL expression.
        // As long as a local value is set any updates to the back end are ignored.
        //
        // Therefore, in cases where you need to update these attributes you have 2 choices. In both
        // cases you need to add an attributeComponentChange for the change manager. The choices are:
        //
        //   1. to pull from the back end you have to have a displayChangeListener
        //      which nulls out the local value on the component so that the component will
        //      pull data from the back end.The code in this method implements this strategy.
        //   2. push the new value onto the component instance.

        setActiveDay(dce.getNewActiveDay());

        // null out the value on the component instance
        RichCalendar calendar = getCalendarComponent();
        calendar.setActiveDay(null);

        // Implicitly record a change for 'activeDay' attribute
        AttributeComponentChange aa =
            new AttributeComponentChange(RichCalendar.ACTIVE_DAY_KEY.getName(),
                                         null);
        RequestContext reqContext = RequestContext.getCurrentInstance();
        FacesContext context = FacesContext.getCurrentInstance();
        reqContext.getChangeManager().addComponentChange(context, calendar,
                                                         aa);

    }
    //*********************************************************************************************
    // END code used in the demo for adding a date picker where we're pulling the
    // active day from the back end
    //*********************************************************************************************
}

