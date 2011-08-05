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
@Table(name = "ivr_protocol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IvrProtocol.findAll", query = "SELECT i FROM IvrProtocol i"),
    @NamedQuery(name = "IvrProtocol.findByProtocolId", query = "SELECT i FROM IvrProtocol i WHERE i.protocolId = :protocolId"),
    @NamedQuery(name = "IvrProtocol.findByProtocolName", query = "SELECT i FROM IvrProtocol i WHERE i.protocolName = :protocolName"),
    @NamedQuery(name = "IvrProtocol.findByProtocolDescription", query = "SELECT i FROM IvrProtocol i WHERE i.protocolDescription = :protocolDescription"),
    @NamedQuery(name = "IvrProtocol.findByProtocolUpdateDate", query = "SELECT i FROM IvrProtocol i WHERE i.protocolUpdateDate = :protocolUpdateDate")})
public class IvrProtocol implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "protocol_id")
    private Integer protocolId;
    @Basic(optional = false)
    @Column(name = "protocol_name")
    private String protocolName;
    @Column(name = "protocol_description")
    private String protocolDescription;
    @Basic(optional = false)
    @Column(name = "protocol_update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date protocolUpdateDate;

    public IvrProtocol() {
    }

    public IvrProtocol(Integer protocolId) {
        this.protocolId = protocolId;
    }

    public IvrProtocol(Integer protocolId, String protocolName, Date protocolUpdateDate) {
        this.protocolId = protocolId;
        this.protocolName = protocolName;
        this.protocolUpdateDate = protocolUpdateDate;
    }

    public Integer getProtocolId() {
        return protocolId;
    }

    public void setProtocolId(Integer protocolId) {
        this.protocolId = protocolId;
    }

    public String getProtocolName() {
        return protocolName;
    }

    public void setProtocolName(String protocolName) {
        this.protocolName = protocolName;
    }

    public String getProtocolDescription() {
        return protocolDescription;
    }

    public void setProtocolDescription(String protocolDescription) {
        this.protocolDescription = protocolDescription;
    }

    public Date getProtocolUpdateDate() {
        return protocolUpdateDate;
    }

    public void setProtocolUpdateDate(Date protocolUpdateDate) {
        this.protocolUpdateDate = protocolUpdateDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (protocolId != null ? protocolId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IvrProtocol)) {
            return false;
        }
        IvrProtocol other = (IvrProtocol) object;
        if ((this.protocolId == null && other.protocolId != null) || (this.protocolId != null && !this.protocolId.equals(other.protocolId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itap.callcenter.entity.apcontact.IvrProtocol[ protocolId=" + protocolId + " ]";
    }
    
}
