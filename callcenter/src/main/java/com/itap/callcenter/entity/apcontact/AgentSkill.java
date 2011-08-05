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
@Table(name = "agent_skill")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AgentSkill.findAll", query = "SELECT a FROM AgentSkill a"),
    @NamedQuery(name = "AgentSkill.findBySkillId", query = "SELECT a FROM AgentSkill a WHERE a.skillId = :skillId"),
    @NamedQuery(name = "AgentSkill.findBySkillName", query = "SELECT a FROM AgentSkill a WHERE a.skillName = :skillName"),
    @NamedQuery(name = "AgentSkill.findBySkillDescription", query = "SELECT a FROM AgentSkill a WHERE a.skillDescription = :skillDescription"),
    @NamedQuery(name = "AgentSkill.findBySkillUpdateDate", query = "SELECT a FROM AgentSkill a WHERE a.skillUpdateDate = :skillUpdateDate")})
public class AgentSkill implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "skill_id")
    private Integer skillId;
    @Basic(optional = false)
    @Column(name = "skill_name")
    private String skillName;
    @Column(name = "skill_description")
    private String skillDescription;
    @Basic(optional = false)
    @Column(name = "skill_update_date")
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
    public int hashCode() {
        int hash = 0;
        hash += (skillId != null ? skillId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AgentSkill)) {
            return false;
        }
        AgentSkill other = (AgentSkill) object;
        if ((this.skillId == null && other.skillId != null) || (this.skillId != null && !this.skillId.equals(other.skillId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itap.callcenter.entity.apcontact.AgentSkill[ skillId=" + skillId + " ]";
    }
    
}
