package com.itap.callcenter.beans.agent;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author scotomax
 * 
 */
public abstract class AgentLevelBean implements Serializable {

	private static final long serialVersionUID = -6896019269463523754L;

	protected Integer levelId;
	protected String levelName;
	protected String levelDescription;
	protected Date levelUpdateDate;

	protected Integer selectedLevelId;

	public Integer getLevelId() {
		return levelId;
	}

	public void setLevelId(Integer levelId) {
		this.levelId = levelId;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public String getLevelDescription() {
		return levelDescription;
	}

	public void setLevelDescription(String levelDescription) {
		this.levelDescription = levelDescription;
	}

	public Date getLevelUpdateDate() {
		return levelUpdateDate;
	}

	public void setLevelUpdateDate(Date levelUpdateDate) {
		this.levelUpdateDate = levelUpdateDate;
	}

	public Integer getSelectedLevelId() {
		return selectedLevelId;
	}

	public void setSelectedLevelId(Integer selectedLevelId) {
		this.selectedLevelId = selectedLevelId;
	}
	
	
}
