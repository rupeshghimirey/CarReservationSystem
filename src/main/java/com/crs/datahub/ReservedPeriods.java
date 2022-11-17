package com.crs.datahub;

import java.sql.Date;

public class ReservedPeriods {
    Date startDate;
    Date endDate;

    public ReservedPeriods(Date startDate, Date endDate) {
        setEndDate(endDate);
        setStartDate(startDate);
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public long getTotalReservedDays() {
        var date1 = this.startDate.toLocalDate();
        var date2 = this.endDate.toLocalDate();
        return date1.datesUntil(date2).count() + 1;
    }

    @Override
    public String toString() {

        return "From " + getStartDate().toString() + " to " + getEndDate().toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReservedPeriods that = (ReservedPeriods) o;

        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        return endDate != null ? endDate.equals(that.endDate) : that.endDate == null;
    }

    @Override
    public int hashCode() {
        int result = startDate != null ? startDate.hashCode() : 0;
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        return result;
    }
}
