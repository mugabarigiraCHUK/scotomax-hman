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
@Table(name = "ivr_callroute")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IvrCallroute.findAll", query = "SELECT i FROM IvrCallroute i"),
    @NamedQuery(name = "IvrCallroute.findByCallrouteId", query = "SELECT i FROM IvrCallroute i WHERE i.callrouteId = :callrouteId"),
    @NamedQuery(name = "IvrCallroute.findByCallrouteName", query = "SELECT i FROM IvrCallroute i WHERE i.callrouteName = :callrouteName"),
    @NamedQuery(name = "IvrCallroute.findByCallrouteDescription", query = "SELECT i FROM IvrCallroute i WHERE i.callrouteDescription = :callrouteDescription"),
    @NamedQuery(name = "IvrCallroute.findByCallrouteCaller", query = "SELECT i FROM IvrCallroute i WHERE i.callrouteCaller = :callrouteCaller"),
    @NamedQuery(name = "IvrCallroute.findByCallrouteCalled", query = "SELECT i FROM IvrCallroute i WHERE i.callrouteCalled = :callrouteCalled"),
    @NamedQuery(name = "IvrCallroute.findByCallrouteCreateDate", query = "SELECT i FROM IvrCallroute i WHERE i.callrouteCreateDate = :callrouteCreateDate"),
    @NamedQuery(name = "IvrCallroute.findByCallrouteUpdateDate", query = "SELECT i FROM IvrCallroute i WHERE i.callrouteUpdateDate = :callrouteUpdateDate")})
public class IvrCallroute implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "callroute_id")
    private Integer callrouteId;
    @Basic(optional = false)
    @Column(name = "callroute_name")
    private String callrouteName;
    @Column(name = "callroute_description")
    private String callrouteDescription;
    @Column(name = "callroute_caller")
    private String callrouteCaller;
    @Column(name = "callroute_called")
    private String callrouteCalled;
    @Basic(optional = false)
    @Column(name = "callroute_create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date callrouteCreateDate;
    @Basic(optional = false)
    @Column(name = "callroute_update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date callrouteUpdateDate;

    public IvrCallroute() {
    }

    public IvrCallroute(Integer callrouteId) {
        this.callrouteId = callrouteId;
    }

    public IvrCallroute(Integer callrouteId, String callrouteName, Date callrouteCreateDate, Date callrouteUpdateDate) {
        this.callrouteId = callrouteId;
        this.callrouteName = callrouteName;
        this.callrouteCreateDate = callrouteCreateDate;
        this.callrouteUpdateDate = callrouteUpdateDate;
    }

    public Integer getCallrouteId() {
        return callrouteId;
    }

    public void setCallrouteId(Integer callrouteId) {
        this.callrouteId = callrouteId;
    }

    public String getCallrouteName() {
        return callrouteName;
    }

    public void setCallrouteName(String callrouteName) {
        this.callrouteName = callrouteName;
    }

    public String getCallrouteDescription() {
        return callrouteDescription;
    }

    public void setCallrouteDescription(String callrouteDescription) {
        this.callrouteDescription = callrouteDescription;
    }

    public String getCallrouteCaller() {
        return callrouteCaller;
    }

    public void setCallrouteCaller(String callrouteCaller) {
        this.callrouteCaller = callrouteCaller;
    }

    public String getCallrouteCalled() {
        return callrouteCalled;
    }

    public void setCallrouteCalled(String callrouteCalled) {
        this.callrouteCalled = callrouteCalled;
    }

    public Date getCallrouteCreateDate() {
        return callrouteCreateDate;
    }

    public void setCallrouteCreateDate(Date callrouteCreateDate) {
        this.callrouteCreateDate = callrouteCreateDate;
    }

    public Date getCallrouteUpdateDate() {
        return callrouteUpdateDate;
    }

    public void setCallrouteUpdateDate(Date callrouteUpdateDate) {
        this.callrouteUpdateDate = callrouteUpdateDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (callrouteId != null ? callrouteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IvrCallroute)) {
            return false;
        }
        IvrCallroute other = (IvrCallroute) object;
        if ((this.callrouteId == null && other.callrouteId != null) || (this.callrouteId != null && !this.callrouteId.equals(other.callrouteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itap.callcenter.entity.apcontact.IvrCallroute[ callrouteId=" + callrouteId + " ]";
    }
    
}
