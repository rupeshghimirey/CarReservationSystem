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
}
