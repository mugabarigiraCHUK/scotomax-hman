/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itap.callcenter.entity.apc.ivr;

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
@Table(name = "ivr_channel")
@XmlRootElement
public class IvrChannel implements Serializable, DomainObject {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "channel_id", length = 11, nullable = false)
    private Integer channelId;
    
    @Column(name = "channel_name", length = 50, nullable = false)
    private String channelName;
    
    @Column(name = "channel_description", length = 100)
    private String channelDescription;
    
    @Column(name = "channel_update_date", nullable = false)
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
        IvrChannel other = (IvrChannel) o;
        return new EqualsBuilder()
                 .append(channelId, other.channelId)
                 .isEquals();
    }
    
    @Override
    public int hashCode() {
        return new HashCodeBuilder()
         .append(this.channelId)
         .toHashCode();
    }
    
}
