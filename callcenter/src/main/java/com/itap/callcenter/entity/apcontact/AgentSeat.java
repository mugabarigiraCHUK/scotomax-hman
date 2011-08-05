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
@Table(name = "agent_seat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AgentSeat.findAll", query = "SELECT a FROM AgentSeat a"),
    @NamedQuery(name = "AgentSeat.findBySeatId", query = "SELECT a FROM AgentSeat a WHERE a.seatId = :seatId"),
    @NamedQuery(name = "AgentSeat.findByLevelId", query = "SELECT a FROM AgentSeat a WHERE a.levelId = :levelId"),
    @NamedQuery(name = "AgentSeat.findBySkillId", query = "SELECT a FROM AgentSeat a WHERE a.skillId = :skillId"),
    @NamedQuery(name = "AgentSeat.findByStatusId", query = "SELECT a FROM AgentSeat a WHERE a.statusId = :statusId"),
    @NamedQuery(name = "AgentSeat.findBySeatName", query = "SELECT a FROM AgentSeat a WHERE a.seatName = :seatName"),
    @NamedQuery(name = "AgentSeat.findBySeatDescription", query = "SELECT a FROM AgentSeat a WHERE a.seatDescription = :seatDescription"),
    @NamedQuery(name = "AgentSeat.findBySeatStartPeriod", query = "SELECT a FROM AgentSeat a WHERE a.seatStartPeriod = :seatStartPeriod"),
    @NamedQuery(name = "AgentSeat.findBySeatEndPeriod", query = "SELECT a FROM AgentSeat a WHERE a.seatEndPeriod = :seatEndPeriod"),
    @NamedQuery(name = "AgentSeat.findBySeatMaxCall", query = "SELECT a FROM AgentSeat a WHERE a.seatMaxCall = :seatMaxCall"),
    @NamedQuery(name = "AgentSeat.findBySeatAllowOutbound", query = "SELECT a FROM AgentSeat a WHERE a.seatAllowOutbound = :seatAllowOutbound"),
    @NamedQuery(name = "AgentSeat.findBySeatCreateDate", query = "SELECT a FROM AgentSeat a WHERE a.seatCreateDate = :seatCreateDate"),
    @NamedQuery(name = "AgentSeat.findBySeatUpdateDate", query = "SELECT a FROM AgentSeat a WHERE a.seatUpdateDate = :seatUpdateDate")})
public class AgentSeat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "seat_id")
    private Integer seatId;
    @Basic(optional = false)
    @Column(name = "level_id")
    private int levelId;
    @Basic(optional = false)
    @Column(name = "skill_id")
    private int skillId;
    @Basic(optional = false)
    @Column(name = "status_id")
    private int statusId;
    @Basic(optional = false)
    @Column(name = "seat_name")
    private String seatName;
    @Column(name = "seat_description")
    private String seatDescription;
    @Basic(optional = false)
    @Column(name = "seat_start_period")
    @Temporal(TemporalType.TIMESTAMP)
    private Date seatStartPeriod;
    @Basic(optional = false)
    @Column(name = "seat_end_period")
    @Temporal(TemporalType.TIMESTAMP)
    private Date seatEndPeriod;
    @Basic(optional = false)
    @Column(name = "seat_max_call")
    private int seatMaxCall;
    @Basic(optional = false)
    @Column(name = "seat_allow_outbound")
    private int seatAllowOutbound;
    @Basic(optional = false)
    @Column(name = "seat_create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date seatCreateDate;
    @Basic(optional = false)
    @Column(name = "seat_update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date seatUpdateDate;

    public AgentSeat() {
    }

    public AgentSeat(Integer seatId) {
        this.seatId = seatId;
    }

    public AgentSeat(Integer seatId, int levelId, int skillId, int statusId, String seatName, Date seatStartPeriod, Date seatEndPeriod, int seatMaxCall, int seatAllowOutbound, Date seatCreateDate, Date seatUpdateDate) {
        this.seatId = seatId;
        this.levelId = levelId;
        this.skillId = skillId;
        this.statusId = statusId;
        this.seatName = seatName;
        this.seatStartPeriod = seatStartPeriod;
        this.seatEndPeriod = seatEndPeriod;
        this.seatMaxCall = seatMaxCall;
        this.seatAllowOutbound = seatAllowOutbound;
        this.seatCreateDate = seatCreateDate;
        this.seatUpdateDate = seatUpdateDate;
    }

    public Integer getSeatId() {
        return seatId;
    }

    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getSeatName() {
        return seatName;
    }

    public void setSeatName(String seatName) {
        this.seatName = seatName;
    }

    public String getSeatDescription() {
        return seatDescription;
    }

    public void setSeatDescription(String seatDescription) {
        this.seatDescription = seatDescription;
    }

    public Date getSeatStartPeriod() {
        return seatStartPeriod;
    }

    public void setSeatStartPeriod(Date seatStartPeriod) {
        this.seatStartPeriod = seatStartPeriod;
    }

    public Date getSeatEndPeriod() {
        return seatEndPeriod;
    }

    public void setSeatEndPeriod(Date seatEndPeriod) {
        this.seatEndPeriod = seatEndPeriod;
    }

    public int getSeatMaxCall() {
        return seatMaxCall;
    }

    public void setSeatMaxCall(int seatMaxCall) {
        this.seatMaxCall = seatMaxCall;
    }

    public int getSeatAllowOutbound() {
        return seatAllowOutbound;
    }

    public void setSeatAllowOutbound(int seatAllowOutbound) {
        this.seatAllowOutbound = seatAllowOutbound;
    }

    public Date getSeatCreateDate() {
        return seatCreateDate;
    }

    public void setSeatCreateDate(Date seatCreateDate) {
        this.seatCreateDate = seatCreateDate;
    }

    public Date getSeatUpdateDate() {
        return seatUpdateDate;
    }

    public void setSeatUpdateDate(Date seatUpdateDate) {
        this.seatUpdateDate = seatUpdateDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seatId != null ? seatId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AgentSeat)) {
            return false;
        }
        AgentSeat other = (AgentSeat) object;
        if ((this.seatId == null && other.seatId != null) || (this.seatId != null && !this.seatId.equals(other.seatId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itap.callcenter.entity.apcontact.AgentSeat[ seatId=" + seatId + " ]";
    }
    
}
