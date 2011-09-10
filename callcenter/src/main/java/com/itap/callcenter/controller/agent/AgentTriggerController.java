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

import com.itap.callcenter.beans.agent.AgentTriggerBean;
import com.itap.callcenter.dao.apc.agent.AgentTriggerDao;
import com.itap.callcenter.entity.apc.agent.AgentTrigger;

/**
 * 
 * @author scotomax
 *
 */
@ViewScoped
@ManagedBean(name="agentTriggerController")
public class AgentTriggerController extends AgentTriggerBean {

	private static final long serialVersionUID = -9178175047194851446L;
	// SLF4J logger
	Logger logger = LoggerFactory.getLogger(AgentTriggerController.class);
	// Agent trigger DAO
	@ManagedProperty(value="#{agentTriggerDaoImpl}")
	AgentTriggerDao agentTriggerDao;
	
	public void setAgentTriggerDao(AgentTriggerDao agentTriggerDao) {
		this.agentTriggerDao = agentTriggerDao;
	}
	
	/**
	 * Create Agent trigger entity data insert into database.
	 */
	public void create() {
		logger.debug("Entering Agent trigger creation method...");
		try {
			AgentTrigger entry = new AgentTrigger();
			entry.setTriggerId(triggerId);
			entry.setTriggerName(triggerName);
			entry.setTriggerDescription(triggerDescription);
			entry.setTriggerCommand(triggerCommand);
			entry.setTriggerCreateDate(new Date());
			entry.setTriggerUpdateDate(new Date());
			agentTriggerDao.save(entry);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "The data been created successfully.", "Information"));
		} catch (Exception ex) {
			logger.error("Failed to insert the data into db, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed to insert the data into db, Cause: "+ex.getMessage(), "Information"));
		}
	}
	
	/**
	 * Update Agent trigger entity data update into database.
	 */
	public void update() {
		logger.debug("Entering Agent trigger update method...");
		try {
			AgentTrigger entry = agentTriggerDao.findById(triggerId);
			entry.setTriggerName(triggerName);
			entry.setTriggerDescription(triggerDescription);
			entry.setTriggerCommand(triggerCommand);
			entry.setTriggerUpdateDate(new Date());
			agentTriggerDao.update(entry);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "The data been updated successfully.", "Information"));
		} catch (Exception ex) {
			logger.error("Failed to update the data into db, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed to update the data into db, Cause: "+ex.getMessage(), "Information"));
		}
	}
	
	/**
	 * Fetch Agent trigger entity data from database.
	 */
	public void edit() {
		logger.debug("Entering Agent trigger edit method...");
		if ( selectedTriggerId == null || selectedTriggerId.intValue() == -1 ) {
			triggerId = null;
			triggerName = null;
			triggerDescription = null;
			triggerCommand = null;
			triggerCreateDate = null;
			triggerUpdateDate = null;
		} else {
			try {
				AgentTrigger entry = agentTriggerDao.findById(selectedTriggerId);
				triggerId = entry.getTriggerId();
				triggerName = entry.getTriggerName();
				triggerDescription = entry.getTriggerDescription();
				triggerCommand = entry.getTriggerCommand();
				triggerCreateDate = entry.getTriggerCreateDate();
				triggerUpdateDate = entry.getTriggerUpdateDate();
				selectedTriggerId = -1;
			} catch (Exception ex) {
				logger.error("Failed to fetch the element data from db, Cause: "+ex.getMessage(), ex);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed to fetch the element data from db, Cause: "+ex.getMessage(), "Information"));
			}
		}
	}
	
	/**
	 * Delete Agent trigger entity data from database.
	 */
	public void delete() {
		logger.debug("Entering Agent trigger delete method...");
		try {
			if ( selectedTriggerId != null ) {
				agentTriggerDao.deleteById(selectedTriggerId);
				selectedTriggerId = -1;
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "The data been deleted successfully.", "Information"));
			}
		} catch (Exception ex) {
			logger.error("Failed to delete the data, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed to delete the data, Cause: "+ex.getMessage(), "Information"));
		}
	}
	
	/**
	 * Fetch list of all Agent trigger entity data from database.
	 */
	public List<AgentTrigger> getAgentTriggerList() {
		logger.debug("Entering Agent trigger getting list of all entity method...");
		List<AgentTrigger> rsList = null;
		try {
			rsList = agentTriggerDao.findAll();
		} catch ( Exception ex ) {
			logger.error("Failed to load the data, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed to load the data, Cause: "+ex.getMessage(), "Information"));
		}
		return rsList;
	}
}
