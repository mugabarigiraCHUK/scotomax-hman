package com.itap.callcenter.beans.agent;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author scotomax
 *
 */
public abstract class AgentSkillBean implements Serializable {

	private static final long serialVersionUID = 1779210037972894454L;

	protected Integer skillId;
	protected String skillName;
	protected String skillDescription;
	protected Date skillUpdateDate;
    
	protected Integer selectedSkillId;

	public Integer getSkillId() {
		return skillId;
	}

	public void setSkillId(Integer skillId) {
		this.skillId = skillId;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public String getSkillDescription() {
		return skillDescription;
	}

	public void setSkillDescription(String skillDescription) {
		this.skillDescription = skillDescription;
	}

	public Date getSkillUpdateDate() {
		return skillUpdateDate;
	}

	public void setSkillUpdateDate(Date skillUpdateDate) {
		this.skillUpdateDate = skillUpdateDate;
	}

	public Integer getSelectedSkillId() {
		return selectedSkillId;
	}

	public void setSelectedSkillId(Integer selectedSkillId) {
		this.selectedSkillId = selectedSkillId;
	}
	
	
}
