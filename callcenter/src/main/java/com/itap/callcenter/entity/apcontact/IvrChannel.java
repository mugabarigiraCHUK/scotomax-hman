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
@Table(name = "ivr_channel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IvrChannel.findAll", query = "SELECT i FROM IvrChannel i"),
    @NamedQuery(name = "IvrChannel.findByChannelId", query = "SELECT i FROM IvrChannel i WHERE i.channelId = :channelId"),
    @NamedQuery(name = "IvrChannel.findByChannelName", query = "SELECT i FROM IvrChannel i WHERE i.channelName = :channelName"),
    @NamedQuery(name = "IvrChannel.findByChannelDescription", query = "SELECT i FROM IvrChannel i WHERE i.channelDescription = :channelDescription"),
    @NamedQuery(name = "IvrChannel.findByChannelUpdateDate", query = "SELECT i FROM IvrChannel i WHERE i.channelUpdateDate = :channelUpdateDate")})
public class IvrChannel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "channel_id")
    private Integer channelId;
    @Basic(optional = false)
    @Column(name = "channel_name")
    private String channelName;
    @Column(name = "channel_description")
    private String channelDescription;
    @Basic(optional = false)
    @Column(name = "channel_update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date channelUpdateDate;

    public IvrChannel() {
    }

    public IvrChannel(Integer channelId) {
        this.channelId = channelId;
    }

    public IvrChannel(Integer channelId, String channelName, Date channelUpdateDate) {
        this.channelId = channelId;
        this.channelName = channelName;
        this.channelUpdateDate = channelUpdateDate;
    }

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getChannelDescription() {
        return channelDescription;
    }

    public void setChannelDescription(String channelDescription) {
        this.channelDescription = channelDescription;
    }

    public Date getChannelUpdateDate() {
        return channelUpdateDate;
    }

    public void setChannelUpdateDate(Date channelUpdateDate) {
        this.channelUpdateDate = channelUpdateDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (channelId != null ? channelId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IvrChannel)) {
            return false;
        }
        IvrChannel other = (IvrChannel) object;
        if ((this.channelId == null && other.channelId != null) || (this.channelId != null && !this.channelId.equals(other.channelId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itap.callcenter.entity.apcontact.IvrChannel[ channelId=" + channelId + " ]";
    }
    
}
