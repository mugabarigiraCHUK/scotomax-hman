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
import javax.validation.constraints.NotNull;
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
@Table(name = "agent_level")
@XmlRootElement
public class AgentLevel implements Serializable, DomainObject {
    
	private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "level_id", length = 11, nullable = false)
    @NotNull
    private Integer levelId;
    
    @Column(name = "level_name", length = 50, nullable = false)
    @NotNull
    private String levelName;
    
    @Column(name = "level_description", length = 100)
    private String levelDescription;
    
    @Column(name = "level_update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date levelUpdateDate;

    public AgentLevel() {
    }

    public AgentLevel(Integer levelId) {
        this.levelId = levelId;
    }

    public AgentLevel(Integer levelId, String levelName, Date levelUpdateDate) {
        this.levelId = levelId;
        this.levelName = levelName;
        this.levelUpdateDate = levelUpdateDate;
    }

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public String getLevelDescription() {
        return levelDescription;
    }

    public void setLevelDescription(String levelDescription) {
        this.levelDescription = levelDescription;
    }

    public Date getLevelUpdateDate() {
        return levelUpdateDate;
    }

    public void setLevelUpdateDate(Date levelUpdateDate) {
        this.levelUpdateDate = levelUpdateDate;
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
        AgentLevel other = (AgentLevel) o;
        return new EqualsBuilder()
                 .append(levelId, other.levelId)
                 .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
         .append(this.levelId)
         .toHashCode();
    }
    
}
