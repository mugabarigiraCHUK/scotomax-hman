package com.itap.callcenter.beans.ivr;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 
 * @author scotomax
 *
 */
public @Data abstract class IvrVoicepromptBean implements Serializable {

	private static final long serialVersionUID = 2475290870984493513L;

	protected Integer voiceId;
	protected String voiceName;
	protected String voiceDescription;
	protected String voiceFilename;
	protected Date voiceCreateDate;
	protected Date voiceUpdateDate;
    
	protected Integer selectedVoiceId;
}
