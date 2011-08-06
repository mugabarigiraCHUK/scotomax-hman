/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itap.callcenter.entity.apc.agent;

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
@Table(name = "agent_seat")
@XmlRootElement
public class AgentSeat implements Serializable, DomainObject {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "seat_id", length = 11, nullable = false)
    private Integer seatId;
    
    @Column(name = "level_id", length = 11, nullable = false)
    private int levelId;
    
    @Column(name = "skill_id", length = 11, nullable = false)
    private int skillId;
    
    @Column(name = "status_id", length = 11, nullable = false)
    private int statusId;
    
    @Column(name = "seat_name", length = 50, nullable = false)
    private String seatName;
    
    @Column(name = "seat_description", length = 100, nullable = false)
    private String seatDescription;
    
    @Column(name = "seat_start_period", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date seatStartPeriod;
    
    @Column(name = "seat_end_period", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date seatEndPeriod;
    
    @Column(name = "seat_max_call", length = 11, nullable = false)
    private int seatMaxCall;
    
    @Column(name = "seat_allow_outbound", length = 11, nullable = false)
    private int seatAllowOutbound;
    
    @Column(name = "seat_create_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date seatCreateDate;
    
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
        AgentSeat other = (AgentSeat) o;
        return new EqualsBuilder()
                 .append(seatId, other.seatId)
                 .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
         .append(this.seatId)
         .toHashCode();
    }
    
}
