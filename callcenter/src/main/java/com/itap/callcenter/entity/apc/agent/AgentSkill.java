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
@Table(name = "agent_skill")
@XmlRootElement
public class AgentSkill implements Serializable, DomainObject {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "skill_id", length = 11, nullable = false)
    private Integer skillId;
    
    @Column(name = "skill_name", length = 50, nullable = false)
    private String skillName;
    
    @Column(name = "skill_description", length = 100, nullable = false)
    private String skillDescription;
    
    @Column(name = "skill_update_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date skillUpdateDate;

    public AgentSkill() {
    }

    public AgentSkill(Integer skillId) {
        this.skillId = skillId;
    }

    public AgentSkill(Integer skillId, String skillName, Date skillUpdateDate) {
        this.skillId = skillId;
        this.skillName = skillName;
        this.skillUpdateDate = skillUpdateDate;
    }

    public Integer getSkillId() {
        return skillId;
    }

    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillDescription() {
        return skillDescription;
    }

    public void setSkillDescription(String skillDescription) {
        this.skillDescription = skillDescription;
    }

    public Date getSkillUpdateDate() {
        return skillUpdateDate;
    }

    public void setSkillUpdateDate(Date skillUpdateDate) {
        this.skillUpdateDate = skillUpdateDate;
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
        AgentSkill other = (AgentSkill) o;
        return new EqualsBuilder()
                 .append(skillId, other.skillId)
                 .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
         .append(this.skillId)
         .toHashCode();
    }
    
}
