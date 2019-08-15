/**
 * DateBean.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.leadway.projects.payment.endpoint;

public class DateBean  implements java.io.Serializable {
    private java.lang.String[] calendarDays;

    private java.lang.String dateString;

    private com.leadway.projects.payment.endpoint.SelectItem[] dayItemList;

    private java.lang.Object[] dayList;

    private int lowerYearRange;

    private java.lang.Object[] monthList;

    private java.lang.String selectedDay;

    private java.lang.String selectedMonth;

    private java.lang.String selectedYear;

    private java.lang.Boolean[] status;

    private int upperYearRange;

    private java.lang.Object[] yearList;

    public DateBean() {
    }

    public DateBean(
           java.lang.String[] calendarDays,
           java.lang.String dateString,
           com.leadway.projects.payment.endpoint.SelectItem[] dayItemList,
           java.lang.Object[] dayList,
           int lowerYearRange,
           java.lang.Object[] monthList,
           java.lang.String selectedDay,
           java.lang.String selectedMonth,
           java.lang.String selectedYear,
           java.lang.Boolean[] status,
           int upperYearRange,
           java.lang.Object[] yearList) {
           this.calendarDays = calendarDays;
           this.dateString = dateString;
           this.dayItemList = dayItemList;
           this.dayList = dayList;
           this.lowerYearRange = lowerYearRange;
           this.monthList = monthList;
           this.selectedDay = selectedDay;
           this.selectedMonth = selectedMonth;
           this.selectedYear = selectedYear;
           this.status = status;
           this.upperYearRange = upperYearRange;
           this.yearList = yearList;
    }


    /**
     * Gets the calendarDays value for this DateBean.
     * 
     * @return calendarDays
     */
    public java.lang.String[] getCalendarDays() {
        return calendarDays;
    }


    /**
     * Sets the calendarDays value for this DateBean.
     * 
     * @param calendarDays
     */
    public void setCalendarDays(java.lang.String[] calendarDays) {
        this.calendarDays = calendarDays;
    }

    public java.lang.String getCalendarDays(int i) {
        return this.calendarDays[i];
    }

    public void setCalendarDays(int i, java.lang.String _value) {
        this.calendarDays[i] = _value;
    }


    /**
     * Gets the dateString value for this DateBean.
     * 
     * @return dateString
     */
    public java.lang.String getDateString() {
        return dateString;
    }


    /**
     * Sets the dateString value for this DateBean.
     * 
     * @param dateString
     */
    public void setDateString(java.lang.String dateString) {
        this.dateString = dateString;
    }


    /**
     * Gets the dayItemList value for this DateBean.
     * 
     * @return dayItemList
     */
    public com.leadway.projects.payment.endpoint.SelectItem[] getDayItemList() {
        return dayItemList;
    }


    /**
     * Sets the dayItemList value for this DateBean.
     * 
     * @param dayItemList
     */
    public void setDayItemList(com.leadway.projects.payment.endpoint.SelectItem[] dayItemList) {
        this.dayItemList = dayItemList;
    }

    public com.leadway.projects.payment.endpoint.SelectItem getDayItemList(int i) {
        return this.dayItemList[i];
    }

    public void setDayItemList(int i, com.leadway.projects.payment.endpoint.SelectItem _value) {
        this.dayItemList[i] = _value;
    }


    /**
     * Gets the dayList value for this DateBean.
     * 
     * @return dayList
     */
    public java.lang.Object[] getDayList() {
        return dayList;
    }


    /**
     * Sets the dayList value for this DateBean.
     * 
     * @param dayList
     */
    public void setDayList(java.lang.Object[] dayList) {
        this.dayList = dayList;
    }

    public java.lang.Object getDayList(int i) {
        return this.dayList[i];
    }

    public void setDayList(int i, java.lang.Object _value) {
        this.dayList[i] = _value;
    }


    /**
     * Gets the lowerYearRange value for this DateBean.
     * 
     * @return lowerYearRange
     */
    public int getLowerYearRange() {
        return lowerYearRange;
    }


    /**
     * Sets the lowerYearRange value for this DateBean.
     * 
     * @param lowerYearRange
     */
    public void setLowerYearRange(int lowerYearRange) {
        this.lowerYearRange = lowerYearRange;
    }


    /**
     * Gets the monthList value for this DateBean.
     * 
     * @return monthList
     */
    public java.lang.Object[] getMonthList() {
        return monthList;
    }


    /**
     * Sets the monthList value for this DateBean.
     * 
     * @param monthList
     */
    public void setMonthList(java.lang.Object[] monthList) {
        this.monthList = monthList;
    }

    public java.lang.Object getMonthList(int i) {
        return this.monthList[i];
    }

    public void setMonthList(int i, java.lang.Object _value) {
        this.monthList[i] = _value;
    }


    /**
     * Gets the selectedDay value for this DateBean.
     * 
     * @return selectedDay
     */
    public java.lang.String getSelectedDay() {
        return selectedDay;
    }


    /**
     * Sets the selectedDay value for this DateBean.
     * 
     * @param selectedDay
     */
    public void setSelectedDay(java.lang.String selectedDay) {
        this.selectedDay = selectedDay;
    }


    /**
     * Gets the selectedMonth value for this DateBean.
     * 
     * @return selectedMonth
     */
    public java.lang.String getSelectedMonth() {
        return selectedMonth;
    }


    /**
     * Sets the selectedMonth value for this DateBean.
     * 
     * @param selectedMonth
     */
    public void setSelectedMonth(java.lang.String selectedMonth) {
        this.selectedMonth = selectedMonth;
    }


    /**
     * Gets the selectedYear value for this DateBean.
     * 
     * @return selectedYear
     */
    public java.lang.String getSelectedYear() {
        return selectedYear;
    }


    /**
     * Sets the selectedYear value for this DateBean.
     * 
     * @param selectedYear
     */
    public void setSelectedYear(java.lang.String selectedYear) {
        this.selectedYear = selectedYear;
    }


    /**
     * Gets the status value for this DateBean.
     * 
     * @return status
     */
    public java.lang.Boolean[] getStatus() {
        return status;
    }


    /**
     * Sets the status value for this DateBean.
     * 
     * @param status
     */
    public void setStatus(java.lang.Boolean[] status) {
        this.status = status;
    }

    public java.lang.Boolean getStatus(int i) {
        return this.status[i];
    }

    public void setStatus(int i, java.lang.Boolean _value) {
        this.status[i] = _value;
    }


    /**
     * Gets the upperYearRange value for this DateBean.
     * 
     * @return upperYearRange
     */
    public int getUpperYearRange() {
        return upperYearRange;
    }


    /**
     * Sets the upperYearRange value for this DateBean.
     * 
     * @param upperYearRange
     */
    public void setUpperYearRange(int upperYearRange) {
        this.upperYearRange = upperYearRange;
    }


    /**
     * Gets the yearList value for this DateBean.
     * 
     * @return yearList
     */
    public java.lang.Object[] getYearList() {
        return yearList;
    }


    /**
     * Sets the yearList value for this DateBean.
     * 
     * @param yearList
     */
    public void setYearList(java.lang.Object[] yearList) {
        this.yearList = yearList;
    }

    public java.lang.Object getYearList(int i) {
        return this.yearList[i];
    }

    public void setYearList(int i, java.lang.Object _value) {
        this.yearList[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DateBean)) return false;
        DateBean other = (DateBean) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.calendarDays==null && other.getCalendarDays()==null) || 
             (this.calendarDays!=null &&
              java.util.Arrays.equals(this.calendarDays, other.getCalendarDays()))) &&
            ((this.dateString==null && other.getDateString()==null) || 
             (this.dateString!=null &&
              this.dateString.equals(other.getDateString()))) &&
            ((this.dayItemList==null && other.getDayItemList()==null) || 
             (this.dayItemList!=null &&
              java.util.Arrays.equals(this.dayItemList, other.getDayItemList()))) &&
            ((this.dayList==null && other.getDayList()==null) || 
             (this.dayList!=null &&
              java.util.Arrays.equals(this.dayList, other.getDayList()))) &&
            this.lowerYearRange == other.getLowerYearRange() &&
            ((this.monthList==null && other.getMonthList()==null) || 
             (this.monthList!=null &&
              java.util.Arrays.equals(this.monthList, other.getMonthList()))) &&
            ((this.selectedDay==null && other.getSelectedDay()==null) || 
             (this.selectedDay!=null &&
              this.selectedDay.equals(other.getSelectedDay()))) &&
            ((this.selectedMonth==null && other.getSelectedMonth()==null) || 
             (this.selectedMonth!=null &&
              this.selectedMonth.equals(other.getSelectedMonth()))) &&
            ((this.selectedYear==null && other.getSelectedYear()==null) || 
             (this.selectedYear!=null &&
              this.selectedYear.equals(other.getSelectedYear()))) &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              java.util.Arrays.equals(this.status, other.getStatus()))) &&
            this.upperYearRange == other.getUpperYearRange() &&
            ((this.yearList==null && other.getYearList()==null) || 
             (this.yearList!=null &&
              java.util.Arrays.equals(this.yearList, other.getYearList())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getCalendarDays() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCalendarDays());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCalendarDays(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDateString() != null) {
            _hashCode += getDateString().hashCode();
        }
        if (getDayItemList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDayItemList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDayItemList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDayList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDayList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDayList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += getLowerYearRange();
        if (getMonthList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMonthList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMonthList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSelectedDay() != null) {
            _hashCode += getSelectedDay().hashCode();
        }
        if (getSelectedMonth() != null) {
            _hashCode += getSelectedMonth().hashCode();
        }
        if (getSelectedYear() != null) {
            _hashCode += getSelectedYear().hashCode();
        }
        if (getStatus() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getStatus());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getStatus(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += getUpperYearRange();
        if (getYearList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getYearList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getYearList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DateBean.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "dateBean"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("calendarDays");
        elemField.setXmlName(new javax.xml.namespace.QName("", "calendarDays"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dateString");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dateString"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dayItemList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dayItemList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://endpoint.payment.projects.leadway.com/", "selectItem"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dayList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dayList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lowerYearRange");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lowerYearRange"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("monthList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "monthList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("selectedDay");
        elemField.setXmlName(new javax.xml.namespace.QName("", "selectedDay"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("selectedMonth");
        elemField.setXmlName(new javax.xml.namespace.QName("", "selectedMonth"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("selectedYear");
        elemField.setXmlName(new javax.xml.namespace.QName("", "selectedYear"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("", "status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("upperYearRange");
        elemField.setXmlName(new javax.xml.namespace.QName("", "upperYearRange"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("yearList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "yearList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
