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
@Table(name = "ivr_voiceprompt")
@XmlRootElement
public class IvrVoiceprompt implements Serializable, DomainObject {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "voice_id", length = 11, nullable = false)
    @NotNull
    private Integer voiceId;
    
    @Column(name = "voice_name", length = 50, nullable = false)
    @NotNull
    private String voiceName;
    
    @Column(name = "voice_description", length = 100)
    private String voiceDescription;
    
    @Column(name = "voice_filename", length = 500, nullable = false)
    @NotNull
    private String voiceFilename;
    
    @Column(name = "voice_create_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date voiceCreateDate;
    
    @Column(name = "voice_update_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date voiceUpdateDate;

    public IvrVoiceprompt() {
    }

    public IvrVoiceprompt(Integer voiceId) {
        this.voiceId = voiceId;
    }

    public IvrVoiceprompt(Integer voiceId, String voiceName, String voiceFilename, Date voiceCreateDate, Date voiceUpdateDate) {
        this.voiceId = voiceId;
        this.voiceName = voiceName;
        this.voiceFilename = voiceFilename;
        this.voiceCreateDate = voiceCreateDate;
        this.voiceUpdateDate = voiceUpdateDate;
    }

    public Integer getVoiceId() {
        return voiceId;
    }

    public void setVoiceId(Integer voiceId) {
        this.voiceId = voiceId;
    }

    public String getVoiceName() {
        return voiceName;
    }

    public void setVoiceName(String voiceName) {
        this.voiceName = voiceName;
    }

    public String getVoiceDescription() {
        return voiceDescription;
    }

    public void setVoiceDescription(String voiceDescription) {
        this.voiceDescription = voiceDescription;
    }

    public String getVoiceFilename() {
        return voiceFilename;
    }

    public void setVoiceFilename(String voiceFilename) {
        this.voiceFilename = voiceFilename;
    }

    public Date getVoiceCreateDate() {
        return voiceCreateDate;
    }

    public void setVoiceCreateDate(Date voiceCreateDate) {
        this.voiceCreateDate = voiceCreateDate;
    }

    public Date getVoiceUpdateDate() {
        return voiceUpdateDate;
    }

    public void setVoiceUpdateDate(Date voiceUpdateDate) {
        this.voiceUpdateDate = voiceUpdateDate;
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
        IvrVoiceprompt other = (IvrVoiceprompt) o;
        return new EqualsBuilder()
                 .append(voiceId, other.voiceId)
                 .isEquals();
    }
    
    @Override
    public int hashCode() {
        return new HashCodeBuilder()
         .append(this.voiceId)
         .toHashCode();
    }
    
}
