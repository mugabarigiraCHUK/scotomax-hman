package com.itap.callcenter.controller.agent;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itap.callcenter.beans.agent.AgentProfileBean;
import com.itap.callcenter.dao.apc.agent.AgentProfileDao;
import com.itap.callcenter.entity.apc.agent.AgentProfile;

/**
 * 
 * @author scotomax
 *
 */
@ViewScoped
@ManagedBean(name="agentProfileController")
public class AgentProfileController extends AgentProfileBean {

	private static final long serialVersionUID = -671746464263547846L;
	// SLF4J logger
	Logger logger = LoggerFactory.getLogger(AgentProfileController.class);
	// Agent Profile DAO
	@ManagedProperty(value="#{agentProfileDaoImpl}")
	AgentProfileDao agentProfileDao;
	
	public void setAgentProfileDao(AgentProfileDao agentProfileDao) {
		this.agentProfileDao = agentProfileDao;
	}
	
	/**
	 * Searching Agent Profile entity data by criteria from database.
	 */
	public void search() {
		logger.debug("Entering Agent profile searching method...");
		try {
			agentProfileList = agentProfileDao.findAll();
		} catch ( Exception ex ) {
			logger.error("Failed to fetching the data from db, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to fetching the data from db, Cause: "+ex.getMessage()));
		}
	}
	
	/**
	 * Clear Agent Profile entity data on the pages.
	 */
	public void clear() {
		logger.debug("Entering Agent profile clearing method...");
		agentId = null;
		agentFullname = null;
		agentUsername = null;
		agentPassword = null;
		agentMaxCall = null;
		agentAllowOutbound = null;
		agentCreateDate = null;
		agentUpdateDate =null;
		agentProfileList = null;
	}
	
	/**
	 * Create Agent profile entity data insert into database.
	 */
	public void create() {
		logger.debug("Entering Agent profile creation method...");
		
		logger.debug("Look -> Supervisor -> " + agentProfile);
		logger.debug("Look -> AgentSkill -> " + agentSkill);
		logger.debug("Look -> AgentLevel -> " + agentLevel);
		logger.debug("Look -> AgentStatus -> " + agentStatus);
		logger.debug("Look -> WkfWorkplan -> " + wkfWorkplan);
		
		try {
			AgentProfile entry = new AgentProfile();
			entry.setAgentId(agentId);
			entry.setAgentFullname(agentFullname);
			entry.setAgentUsername(agentUsername);
			entry.setAgentPassword(agentPassword);
			entry.setAgentMaxCall(agentMaxCall);
			entry.setAgentAllowOutbound(agentAllowOutbound);
			entry.setAgentCreateDate(new Date());
			entry.setAgentUpdateDate(new Date());
			
			entry.setSupervisor(agentProfile);
			entry.setAgentSkill(agentSkill);
			entry.setAgentLevel(agentLevel);
			entry.setAgentStatus(agentStatus);
			entry.setWorkplan(wkfWorkplan);
			
			agentProfileDao.save(entry);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("The data been created successfully."));
		} catch (Exception ex) {
			logger.error("Failed to insert the data into db, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to insert the data into db, Cause: "+ex.getMessage()));
		}
	}
	
	/**
	 * Update Agent profile entity data update into database.
	 */
	public void update() {
		logger.debug("Entering Agent profile update method...");
		
		logger.debug("Look -> Supervisor -> " + agentProfile);
		logger.debug("Look -> AgentSkill -> " + agentSkill);
		logger.debug("Look -> AgentLevel -> " + agentLevel);
		logger.debug("Look -> AgentStatus -> " + agentStatus);
		logger.debug("Look -> WkfWorkplan -> " + wkfWorkplan);
		
		try {
			AgentProfile entry = agentProfileDao.findById(agentId);
			entry.setAgentFullname(agentFullname);
			entry.setAgentUsername(agentUsername);
			entry.setAgentPassword(agentPassword);
			entry.setAgentMaxCall(agentMaxCall);
			entry.setAgentAllowOutbound(agentAllowOutbound);
			entry.setAgentUpdateDate(new Date());
			
			entry.setSupervisor(agentProfile);
			entry.setAgentSkill(agentSkill);
			entry.setAgentLevel(agentLevel);
			entry.setAgentStatus(agentStatus);
			entry.setWorkplan(wkfWorkplan);
			
			agentProfileDao.update(entry);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("The data been updated successfully."));
		} catch (Exception ex) {
			logger.error("Failed to update the data into db, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to update the data into db, Cause: "+ex.getMessage()));
		}
	}
	
	/**
	 * Fetch Agent profile entity data from database.
	 */
	public void edit() {
		logger.debug("Entering Agent profile edit method...");
		if ( selectedAgentId == null || selectedAgentId.intValue() == -1 ) {
			agentId = null;
			agentFullname = null;
			agentUsername = null;
			agentPassword = null;
			agentMaxCall = null;
			agentAllowOutbound = null;
			agentCreateDate = null;
			agentUpdateDate =null;
			
			agentProfile = null;
			agentSkill = null;
			agentLevel = null;
			agentStatus = null;
			wkfWorkplan = null;
			
		} else {
			try {
				AgentProfile entry = agentProfileDao.findById(agentId);
				agentId = entry.getAgentId();
				agentFullname = entry.getAgentFullname();
				agentUsername = entry.getAgentUsername();
				agentPassword = entry.getAgentPassword();
				agentMaxCall = entry.getAgentMaxCall();
				agentAllowOutbound = entry.getAgentAllowOutbound();
				agentCreateDate = entry.getAgentCreateDate();
				agentUpdateDate = entry.getAgentUpdateDate();
				
				agentProfile = entry.getSupervisor();
				agentSkill = entry.getAgentSkill();
				agentLevel = entry.getAgentLevel();
				agentStatus = entry.getAgentStatus();
				wkfWorkplan = entry.getWorkplan();
				
				selectedAgentId = -1;
			} catch (Exception ex) {
				logger.error("Failed to fetch the element data from db, Cause: "+ex.getMessage(), ex);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to fetch the element data from db, Cause: "+ex.getMessage()));
			}
		}
	}
	
	/**
	 * Delete Agent profile entity data from database.
	 */
	public void delete() {
		logger.debug("Entering Agent profile delete method...");
		try {
			if ( selectedAgentId != null ) {
				agentProfileDao.deleteById(selectedAgentId);
				selectedAgentId = -1;
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("The data been deleted successfully."));
			}
		} catch (Exception ex) {
			logger.error("Failed to delete the data, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to delete the data, Cause: "+ex.getMessage()));
		}
	}

}
