package com.itap.callcenter.beans.agent;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 
 * @author scotomax
 * 
 */
public @Data abstract class AgentLevelBean implements Serializable {

	private static final long serialVersionUID = -6896019269463523754L;

	protected Integer levelId;
	protected String levelName;
	protected String levelDescription;
	protected Date levelUpdateDate;

	protected Integer selectedLevelId;
}
