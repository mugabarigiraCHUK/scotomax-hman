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
@Table(name = "wkf_calendar")
@XmlRootElement
public class WkfCalendar implements Serializable, DomainObject {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "calendar_id")
    private Integer calendarId;
    
    @Column(name = "calendar_name")
    private String calendarName;
    
    @Column(name = "calendar_description")
    private String calendarDescription;
    
    @Column(name = "calendar_enable")
    private int calendarEnable;
    
    @Column(name = "calendar_start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date calendarStartDate;
    
    @Column(name = "calendar_end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date calendarEndDate;
    
    @Column(name = "calendar_update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date calendarUpdateDate;

    public WkfCalendar() {
    }

    public WkfCalendar(Integer calendarId) {
        this.calendarId = calendarId;
    }

    public WkfCalendar(Integer calendarId, String calendarName, int calendarEnable, Date calendarStartDate, Date calendarEndDate, Date calendarUpdateDate) {
        this.calendarId = calendarId;
        this.calendarName = calendarName;
        this.calendarEnable = calendarEnable;
        this.calendarStartDate = calendarStartDate;
        this.calendarEndDate = calendarEndDate;
        this.calendarUpdateDate = calendarUpdateDate;
    }

    public Integer getCalendarId() {
        return calendarId;
    }

    public void setCalendarId(Integer calendarId) {
        this.calendarId = calendarId;
    }

    public String getCalendarName() {
        return calendarName;
    }

    public void setCalendarName(String calendarName) {
        this.calendarName = calendarName;
    }

    public String getCalendarDescription() {
        return calendarDescription;
    }

    public void setCalendarDescription(String calendarDescription) {
        this.calendarDescription = calendarDescription;
    }

    public int getCalendarEnable() {
        return calendarEnable;
    }

    public void setCalendarEnable(int calendarEnable) {
        this.calendarEnable = calendarEnable;
    }

    public Date getCalendarStartDate() {
        return calendarStartDate;
    }

    public void setCalendarStartDate(Date calendarStartDate) {
        this.calendarStartDate = calendarStartDate;
    }

    public Date getCalendarEndDate() {
        return calendarEndDate;
    }

    public void setCalendarEndDate(Date calendarEndDate) {
        this.calendarEndDate = calendarEndDate;
    }

    public Date getCalendarUpdateDate() {
        return calendarUpdateDate;
    }

    public void setCalendarUpdateDate(Date calendarUpdateDate) {
        this.calendarUpdateDate = calendarUpdateDate;
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
        WkfCalendar other = (WkfCalendar) o;
        return new EqualsBuilder()
                 .append(calendarId, other.calendarId)
                 .isEquals();
    }
    
    @Override
    public int hashCode() {
        return new HashCodeBuilder()
         .append(this.calendarId)
         .toHashCode();
    }
    
}
