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
@Table(name = "agent_level")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AgentLevel.findAll", query = "SELECT a FROM AgentLevel a"),
    @NamedQuery(name = "AgentLevel.findByLevelId", query = "SELECT a FROM AgentLevel a WHERE a.levelId = :levelId"),
    @NamedQuery(name = "AgentLevel.findByLevelName", query = "SELECT a FROM AgentLevel a WHERE a.levelName = :levelName"),
    @NamedQuery(name = "AgentLevel.findByLevelDescription", query = "SELECT a FROM AgentLevel a WHERE a.levelDescription = :levelDescription"),
    @NamedQuery(name = "AgentLevel.findByLevelUpdateDate", query = "SELECT a FROM AgentLevel a WHERE a.levelUpdateDate = :levelUpdateDate")})
public class AgentLevel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "level_id")
    private Integer levelId;
    @Basic(optional = false)
    @Column(name = "level_name")
    private String levelName;
    @Column(name = "level_description")
    private String levelDescription;
    @Basic(optional = false)
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
    public int hashCode() {
        int hash = 0;
        hash += (levelId != null ? levelId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AgentLevel)) {
            return false;
        }
        AgentLevel other = (AgentLevel) object;
        if ((this.levelId == null && other.levelId != null) || (this.levelId != null && !this.levelId.equals(other.levelId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itap.callcenter.entity.apcontact.AgentLevel[ levelId=" + levelId + " ]";
    }
    
}
