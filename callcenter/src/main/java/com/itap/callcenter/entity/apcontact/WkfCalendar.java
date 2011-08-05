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
@Table(name = "wkf_calendar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WkfCalendar.findAll", query = "SELECT w FROM WkfCalendar w"),
    @NamedQuery(name = "WkfCalendar.findByCalendarId", query = "SELECT w FROM WkfCalendar w WHERE w.calendarId = :calendarId"),
    @NamedQuery(name = "WkfCalendar.findByCalendarName", query = "SELECT w FROM WkfCalendar w WHERE w.calendarName = :calendarName"),
    @NamedQuery(name = "WkfCalendar.findByCalendarDescription", query = "SELECT w FROM WkfCalendar w WHERE w.calendarDescription = :calendarDescription"),
    @NamedQuery(name = "WkfCalendar.findByCalendarEnable", query = "SELECT w FROM WkfCalendar w WHERE w.calendarEnable = :calendarEnable"),
    @NamedQuery(name = "WkfCalendar.findByCalendarStartDate", query = "SELECT w FROM WkfCalendar w WHERE w.calendarStartDate = :calendarStartDate"),
    @NamedQuery(name = "WkfCalendar.findByCalendarEndDate", query = "SELECT w FROM WkfCalendar w WHERE w.calendarEndDate = :calendarEndDate"),
    @NamedQuery(name = "WkfCalendar.findByCalendarUpdateDate", query = "SELECT w FROM WkfCalendar w WHERE w.calendarUpdateDate = :calendarUpdateDate")})
public class WkfCalendar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "calendar_id")
    private Integer calendarId;
    @Basic(optional = false)
    @Column(name = "calendar_name")
    private String calendarName;
    @Column(name = "calendar_description")
    private String calendarDescription;
    @Basic(optional = false)
    @Column(name = "calendar_enable")
    private int calendarEnable;
    @Basic(optional = false)
    @Column(name = "calendar_start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date calendarStartDate;
    @Basic(optional = false)
    @Column(name = "calendar_end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date calendarEndDate;
    @Basic(optional = false)
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
    public int hashCode() {
        int hash = 0;
        hash += (calendarId != null ? calendarId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WkfCalendar)) {
            return false;
        }
        WkfCalendar other = (WkfCalendar) object;
        if ((this.calendarId == null && other.calendarId != null) || (this.calendarId != null && !this.calendarId.equals(other.calendarId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itap.callcenter.entity.apcontact.WkfCalendar[ calendarId=" + calendarId + " ]";
    }
    
}
