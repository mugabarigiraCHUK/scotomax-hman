package com.itap.callcenter.beans.ivr;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author scotomax
 *
 */
public abstract class IvrVoicepromptBean implements Serializable {

	private static final long serialVersionUID = 2475290870984493513L;

	protected Integer voiceId;
	protected String voiceName;
	protected String voiceDescription;
	protected String voiceFilename;
	protected Date voiceCreateDate;
	protected Date voiceUpdateDate;
    
	protected Integer selectedVoiceId;

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

	public Integer getSelectedVoiceId() {
		return selectedVoiceId;
	}

	public void setSelectedVoiceId(Integer selectedVoiceId) {
		this.selectedVoiceId = selectedVoiceId;
	}
	
	
}
