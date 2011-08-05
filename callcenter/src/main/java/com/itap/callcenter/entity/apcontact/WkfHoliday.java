/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itap.callcenter.entity.apcontact;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author scotomax
 */
@Entity
@Table(name = "wkf_holiday")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WkfHoliday.findAll", query = "SELECT w FROM WkfHoliday w"),
    @NamedQuery(name = "WkfHoliday.findByHolidayId", query = "SELECT w FROM WkfHoliday w WHERE w.holidayId = :holidayId"),
    @NamedQuery(name = "WkfHoliday.findByCalendarId", query = "SELECT w FROM WkfHoliday w WHERE w.calendarId = :calendarId"),
    @NamedQuery(name = "WkfHoliday.findByHolidayName", query = "SELECT w FROM WkfHoliday w WHERE w.holidayName = :holidayName"),
    @NamedQuery(name = "WkfHoliday.findByHolidayDescription", query = "SELECT w FROM WkfHoliday w WHERE w.holidayDescription = :holidayDescription"),
    @NamedQuery(name = "WkfHoliday.findByHolidayDate", query = "SELECT w FROM WkfHoliday w WHERE w.holidayDate = :holidayDate"),
    @NamedQuery(name = "WkfHoliday.findByHolidayUpdateDate", query = "SELECT w FROM WkfHoliday w WHERE w.holidayUpdateDate = :holidayUpdateDate")})
public class WkfHoliday implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "holiday_id")
    private Integer holidayId;
    @Basic(optional = false)
    @Column(name = "calendar_id")
    private int calendarId;
    @Basic(optional = false)
    @Column(name = "holiday_name")
    private String holidayName;
    @Column(name = "holiday_description")
    private String holidayDescription;
    @Basic(optional = false)
    @Column(name = "holiday_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date holidayDate;
    @Basic(optional = false)
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
    public int hashCode() {
        int hash = 0;
        hash += (holidayId != null ? holidayId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WkfHoliday)) {
            return false;
        }
        WkfHoliday other = (WkfHoliday) object;
        if ((this.holidayId == null && other.holidayId != null) || (this.holidayId != null && !this.holidayId.equals(other.holidayId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itap.callcenter.entity.apcontact.WkfHoliday[ holidayId=" + holidayId + " ]";
    }
    
}
