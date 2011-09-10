package com.itap.callcenter.controller.agent;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itap.callcenter.beans.agent.AgentSkillBean;
import com.itap.callcenter.dao.apc.agent.AgentSkillDao;
import com.itap.callcenter.entity.apc.agent.AgentSkill;

/**
 * 
 * @author scotomax
 *
 */
@ViewScoped
@ManagedBean(name="agentSkillController")
public class AgentSkillController extends AgentSkillBean {

	private static final long serialVersionUID = -5238471494141993642L;
	//SLF4J logger
	Logger logger = LoggerFactory.getLogger(AgentSkillController.class);
	// Agent Skill DAO
	@ManagedProperty(value="#{agentSkillDaoImpl}")
	AgentSkillDao agentSkillDao;
	
	public void setAgentSkillDao(AgentSkillDao agentSkillDao) {
		this.agentSkillDao = agentSkillDao;
	}
	
	/**
	 * Create Agent skill entity data insert into database.
	 */
	public void create() {
		logger.debug("Entering Agent skill creation method...");
		try {
			AgentSkill entry = new AgentSkill();
			entry.setSkillId(skillId);
			entry.setSkillName(skillName);
			entry.setSkillDescription(skillDescription);
			entry.setSkillUpdateDate(new Date());
			agentSkillDao.save(entry);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "The data been created successfully.", "Information"));
		} catch (Exception ex) {
			logger.error("Failed to insert the data into db, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed to insert the data into db, Cause: "+ex.getMessage(), "Information"));
		}
	}
	
	/**
	 * Update Agent skill entity data update into database.
	 */
	public void update() {
		logger.debug("Entering Agent skill update method...");
		try {
			AgentSkill entry = new AgentSkill();
			entry.setSkillId(skillId);
			entry.setSkillName(skillName);
			entry.setSkillDescription(skillDescription);
			entry.setSkillUpdateDate(new Date());
			agentSkillDao.update(entry);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "The data been updated successfully.", "Information"));
		} catch (Exception ex) {
			logger.error("Failed to update the data into db, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed to update the data into db, Cause: "+ex.getMessage(), "Information"));
		}
	}
	
	/**
	 * Fetch Agent skill entity data from database.
	 */
	public void edit() {
		logger.debug("Entering Agent skill edit method...");
		if ( selectedSkillId == null || selectedSkillId.intValue() == -1 ) {
			skillId = null;
			skillName = null;
			skillDescription = null;
			skillUpdateDate = null;
		} else {
			try {
				AgentSkill entry = agentSkillDao.findById(selectedSkillId);
				skillId = entry.getSkillId();
				skillName = entry.getSkillName();
				skillDescription = entry.getSkillDescription();
				skillUpdateDate = entry.getSkillUpdateDate();
				selectedSkillId = -1;
			} catch (Exception ex) {
				logger.error("Failed to fetch the element data from db, Cause: "+ex.getMessage(), ex);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed to fetch the element data from db, Cause: "+ex.getMessage(), "Information"));
			}
		}
	}
	
	/**
	 * Delete Agent skill entity data from database.
	 */
	public void delete() {
		logger.debug("Entering Agent skill delete method...");
		try {
			if ( selectedSkillId != null ) {
				agentSkillDao.deleteById(selectedSkillId);
				selectedSkillId = -1;
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "The data been deleted successfully.", "Information"));
			}
		} catch (Exception ex) {
			logger.error("Failed to delete the data, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed to delete the data, Cause: "+ex.getMessage(), "Information"));
		}
	}
	
	/**
	 * Fetch list of all Agent skill entity data from database.
	 */
	public List<AgentSkill> getAgentSkillList() {
		logger.debug("Entering Agent skill getting list of all entity method...");
		List<AgentSkill> rsList = null;
		try {
			rsList = agentSkillDao.findAll();
		} catch ( Exception ex ) {
			logger.error("Failed to load the data, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed to load the data, Cause: "+ex.getMessage(), "Information"));
		}
		return rsList;
	}
}
