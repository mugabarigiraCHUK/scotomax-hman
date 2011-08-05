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
@Table(name = "ivr_voiceprompt")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IvrVoiceprompt.findAll", query = "SELECT i FROM IvrVoiceprompt i"),
    @NamedQuery(name = "IvrVoiceprompt.findByVoiceId", query = "SELECT i FROM IvrVoiceprompt i WHERE i.voiceId = :voiceId"),
    @NamedQuery(name = "IvrVoiceprompt.findByVoiceName", query = "SELECT i FROM IvrVoiceprompt i WHERE i.voiceName = :voiceName"),
    @NamedQuery(name = "IvrVoiceprompt.findByVoiceDescription", query = "SELECT i FROM IvrVoiceprompt i WHERE i.voiceDescription = :voiceDescription"),
    @NamedQuery(name = "IvrVoiceprompt.findByVoiceFilename", query = "SELECT i FROM IvrVoiceprompt i WHERE i.voiceFilename = :voiceFilename"),
    @NamedQuery(name = "IvrVoiceprompt.findByVoiceCreateDate", query = "SELECT i FROM IvrVoiceprompt i WHERE i.voiceCreateDate = :voiceCreateDate"),
    @NamedQuery(name = "IvrVoiceprompt.findByVoiceUpdateDate", query = "SELECT i FROM IvrVoiceprompt i WHERE i.voiceUpdateDate = :voiceUpdateDate")})
public class IvrVoiceprompt implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "voice_id")
    private Integer voiceId;
    @Basic(optional = false)
    @Column(name = "voice_name")
    private String voiceName;
    @Column(name = "voice_description")
    private String voiceDescription;
    @Basic(optional = false)
    @Column(name = "voice_filename")
    private String voiceFilename;
    @Basic(optional = false)
    @Column(name = "voice_create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date voiceCreateDate;
    @Basic(optional = false)
    @Column(name = "voice_update_date")
    @Temporal(TemporalType.TIMESTAMP)
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
    public int hashCode() {
        int hash = 0;
        hash += (voiceId != null ? voiceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IvrVoiceprompt)) {
            return false;
        }
        IvrVoiceprompt other = (IvrVoiceprompt) object;
        if ((this.voiceId == null && other.voiceId != null) || (this.voiceId != null && !this.voiceId.equals(other.voiceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itap.callcenter.entity.apcontact.IvrVoiceprompt[ voiceId=" + voiceId + " ]";
    }
    
}
