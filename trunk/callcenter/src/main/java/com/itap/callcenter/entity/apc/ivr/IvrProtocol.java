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
@Table(name = "ivr_protocol")
@XmlRootElement
public class IvrProtocol implements Serializable, DomainObject {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "protocol_id")
    private Integer protocolId;
    
    @Column(name = "protocol_name")
    private String protocolName;
    
    @Column(name = "protocol_description")
    private String protocolDescription;
    
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
        IvrProtocol other = (IvrProtocol) o;
        return new EqualsBuilder()
                 .append(protocolId, other.protocolId)
                 .isEquals();
    }
    
    @Override
    public int hashCode() {
        return new HashCodeBuilder()
         .append(this.protocolId)
         .toHashCode();
    }
    
}
