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

import com.itap.callcenter.beans.agent.AgentLevelBean;
import com.itap.callcenter.dao.apc.agent.AgentLevelDao;
import com.itap.callcenter.entity.apc.agent.AgentLevel;

/**
 * 
 * @author scotomax
 *
 */
@ViewScoped
@ManagedBean(name = "agentLevelController")
public class AgentLevelController extends AgentLevelBean {

	private static final long serialVersionUID = 1202002905915328706L;
	// SLF4J
	Logger logger = LoggerFactory.getLogger(AgentLevelController.class);
	// Agent level DAO.
	@ManagedProperty(value="#{agentLevelDaoImpl}")
	AgentLevelDao agentLevelDao;
	
	public void setAgentLevelDao(AgentLevelDao agentLevelDao) {
		this.agentLevelDao = agentLevelDao;
	}
	
	/**
	 * Create Agent level entity data insert into database.
	 */
	public void create() {
		logger.debug("Entering Agent level creation method...");
		try {
			AgentLevel entry = new AgentLevel();
			entry.setLevelId(levelId);
			entry.setLevelName(levelName);
			entry.setLevelDescription(levelDescription);
			entry.setLevelUpdateDate(new Date());
			agentLevelDao.save(entry);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "The data been created successfully.", "Information"));
		} catch (Exception ex) {
			logger.error("Failed to insert the data into db, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed to insert the data into db, Cause: "+ex.getMessage(), "Information"));
		}
	}
	
	/**
	 * Update Agent level entity data update into database.
	 */
	public void update() {
		logger.debug("Entering Agent level update method...");
		try {
			AgentLevel entry = new AgentLevel();
			entry.setLevelId(levelId);
			entry.setLevelName(levelName);
			entry.setLevelDescription(levelDescription);
			entry.setLevelUpdateDate(new Date());
			agentLevelDao.update(entry);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "The data been updated successfully.", "Information"));
		} catch (Exception ex) {
			logger.error("Failed to update the data into db, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed to update the data into db, Cause: "+ex.getMessage(), "Information"));
		}
	}
	
	/**
	 * Fetch Agent level entity data from database.
	 */
	public void edit() {
		logger.debug("Entering Agent level edit method...");
		if ( selectedLevelId == null || selectedLevelId.intValue() == -1 ) {
			levelId = null;
			levelName = null;
			levelDescription = null;
			levelUpdateDate = null;
		} else {
			try {
				AgentLevel entry = agentLevelDao.findById(selectedLevelId);
				levelId = entry.getLevelId();
				levelName = entry.getLevelName();
				levelDescription = entry.getLevelDescription();
				levelUpdateDate = entry.getLevelUpdateDate();
				selectedLevelId = -1;
			} catch (Exception ex) {
				logger.error("Failed to fetch the element data from db, Cause: "+ex.getMessage(), ex);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Failed to fetch the element data from db, Cause: "+ex.getMessage(), "Information"));
			}
		}
	}
	
	/**
	 * Delete Agent level entity data from database.
	 */
	public void delete() {
		logger.debug("Entering Agent level delete method...");
		try {
			if ( selectedLevelId != null ) {
				agentLevelDao.deleteById(selectedLevelId);
				selectedLevelId = -1;
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "The data been deleted successfully.", "Information"));
			}
		} catch (Exception ex) {
			logger.error("Failed to delete the data, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed to delete the data, Cause: "+ex.getMessage(), "Information"));
		}
	}
	
	/**
	 * Fetch list of all Agent level entity data from database.
	 */
	public List<AgentLevel> getAgentLevelList() {
		logger.debug("Entering Agent level getting list of all entity method...");
		List<AgentLevel> rsList = null;
		try {
			rsList = agentLevelDao.findAll();
		} catch ( Exception ex ) {
			logger.error("Failed to load the data, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed to load the data, Cause: "+ex.getMessage(), "Information"));
		}
		return rsList;
	}
}
