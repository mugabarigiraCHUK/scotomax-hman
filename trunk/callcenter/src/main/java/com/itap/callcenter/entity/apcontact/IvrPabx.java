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
@Table(name = "ivr_pabx")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IvrPabx.findAll", query = "SELECT i FROM IvrPabx i"),
    @NamedQuery(name = "IvrPabx.findByPabxId", query = "SELECT i FROM IvrPabx i WHERE i.pabxId = :pabxId"),
    @NamedQuery(name = "IvrPabx.findByProtocolId", query = "SELECT i FROM IvrPabx i WHERE i.protocolId = :protocolId"),
    @NamedQuery(name = "IvrPabx.findByPabxName", query = "SELECT i FROM IvrPabx i WHERE i.pabxName = :pabxName"),
    @NamedQuery(name = "IvrPabx.findByPabxDescription", query = "SELECT i FROM IvrPabx i WHERE i.pabxDescription = :pabxDescription"),
    @NamedQuery(name = "IvrPabx.findByPabxUpdateDate", query = "SELECT i FROM IvrPabx i WHERE i.pabxUpdateDate = :pabxUpdateDate")})
public class IvrPabx implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pabx_id")
    private Integer pabxId;
    @Basic(optional = false)
    @Column(name = "protocol_id")
    private int protocolId;
    @Basic(optional = false)
    @Column(name = "pabx_name")
    private String pabxName;
    @Column(name = "pabx_description")
    private String pabxDescription;
    @Basic(optional = false)
    @Column(name = "pabx_update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pabxUpdateDate;

    public IvrPabx() {
    }

    public IvrPabx(Integer pabxId) {
        this.pabxId = pabxId;
    }

    public IvrPabx(Integer pabxId, int protocolId, String pabxName, Date pabxUpdateDate) {
        this.pabxId = pabxId;
        this.protocolId = protocolId;
        this.pabxName = pabxName;
        this.pabxUpdateDate = pabxUpdateDate;
    }

    public Integer getPabxId() {
        return pabxId;
    }

    public void setPabxId(Integer pabxId) {
        this.pabxId = pabxId;
    }

    public int getProtocolId() {
        return protocolId;
    }

    public void setProtocolId(int protocolId) {
        this.protocolId = protocolId;
    }

    public String getPabxName() {
        return pabxName;
    }

    public void setPabxName(String pabxName) {
        this.pabxName = pabxName;
    }

    public String getPabxDescription() {
        return pabxDescription;
    }

    public void setPabxDescription(String pabxDescription) {
        this.pabxDescription = pabxDescription;
    }

    public Date getPabxUpdateDate() {
        return pabxUpdateDate;
    }

    public void setPabxUpdateDate(Date pabxUpdateDate) {
        this.pabxUpdateDate = pabxUpdateDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pabxId != null ? pabxId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IvrPabx)) {
            return false;
        }
        IvrPabx other = (IvrPabx) object;
        if ((this.pabxId == null && other.pabxId != null) || (this.pabxId != null && !this.pabxId.equals(other.pabxId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itap.callcenter.entity.apcontact.IvrPabx[ pabxId=" + pabxId + " ]";
    }
    
}
