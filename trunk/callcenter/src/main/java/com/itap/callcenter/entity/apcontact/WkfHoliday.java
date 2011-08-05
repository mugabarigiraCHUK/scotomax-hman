/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itap.callcenter.entity.apcontact;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.itap.callcenter.entity.DomainObject;

/**
 *
 * @author scotomax
 */
@Entity
@Table(name = "wkf_holiday")
@XmlRootElement
public class WkfHoliday implements Serializable, DomainObject {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "holiday_id")
    private Integer holidayId;
    
    @Column(name = "calendar_id")
    private int calendarId;
    
    @Column(name = "holiday_name")
    private String holidayName;
    
    @Column(name = "holiday_description")
    private String holidayDescription;
    
    @Column(name = "holiday_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date holidayDate;
    
    @Column(name = "holiday_update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date holidayUpdateDate;

    public WkfHoliday() {
    }

    public WkfHoliday(Integer holidayId) {
        this.holidayId = holidayId;
    }

    public WkfHoliday(Integer holidayId, int calendarId, String holidayName, Date holidayDate, Date holidayUpdateDate) {
        this.holidayId = holidayId;
        this.calendarId = calendarId;
        this.holidayName = holidayName;
        this.holidayDate = holidayDate;
        this.holidayUpdateDate = holidayUpdateDate;
    }

    public Integer getHolidayId() {
        return holidayId;
    }

    public void setHolidayId(Integer holidayId) {
        this.holidayId = holidayId;
    }

    public int getCalendarId() {
        return calendarId;
    }

    public void setCalendarId(int calendarId) {
        this.calendarId = calendarId;
    }

    public String getHolidayName() {
        return holidayName;
    }

    public void setHolidayName(String holidayName) {
        this.holidayName = holidayName;
    }

    public String getHolidayDescription() {
        return holidayDescription;
    }

    public void setHolidayDescription(String holidayDescription) {
        this.holidayDescription = holidayDescription;
    }

    public Date getHolidayDate() {
        return holidayDate;
    }

    public void setHolidayDate(Date holidayDate) {
        this.holidayDate = holidayDate;
    }

    public Date getHolidayUpdateDate() {
        return holidayUpdateDate;
    }

    public void setHolidayUpdateDate(Date holidayUpdateDate) {
        this.holidayUpdateDate = holidayUpdateDate;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) { return false; }
        if (o == this) { return true; }
        if (o.getClass() != getClass()) {
            return false;
        }
        WkfHoliday other = (WkfHoliday) o;
        return new EqualsBuilder()
                 .append(holidayId, other.holidayId)
                 .isEquals();
    }
    
    @Override
    public int hashCode() {
        return new HashCodeBuilder()
         .append(this.holidayId)
         .toHashCode();
    }
    
}
