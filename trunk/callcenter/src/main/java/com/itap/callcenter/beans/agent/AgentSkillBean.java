package com.itap.callcenter.beans.agent;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 
 * @author scotomax
 *
 */
public @Data abstract class AgentSkillBean implements Serializable {

	private static final long serialVersionUID = 1779210037972894454L;

	protected Integer skillId;
	protected String skillName;
	protected String skillDescription;
	protected Date skillUpdateDate;
    
	protected Integer selectedSkillId;
}
