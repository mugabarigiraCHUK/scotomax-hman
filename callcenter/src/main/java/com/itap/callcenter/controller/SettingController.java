package com.itap.callcenter.controller;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itap.callcenter.beans.SettingsBean;
import com.itap.callcenter.controller.agent.AgentProfileController;
import com.itap.callcenter.dao.apc.agent.AgentProfileDao;
import com.itap.callcenter.entity.apc.agent.AgentProfile;

/**
 * 
 * @author scotomax
 *
 */
@ViewScoped
@ManagedBean(name="settingController")
public class SettingController extends SettingsBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8809382748196620015L;

	// SLF4J logger
	Logger logger = LoggerFactory.getLogger(AgentProfileController.class);
	// Agent Profile DAO
	@ManagedProperty(value="#{agentProfileDaoImpl}")
	AgentProfileDao agentProfileDao;
	
	// User controller
	@ManagedProperty(value="#{userController}")
	UserController userController;
	
	public void setAgentProfileDao(AgentProfileDao agentProfileDao) {
		this.agentProfileDao = agentProfileDao;
	}
	
	public void setUserController(UserController userController) {
		this.userController = userController;
	}
	
	public SettingController() {
		find();
	}

	/**
	 * Searching Agent Profile entity data by criteria from database.
	 */
	public void find() {
		logger.debug("Entering Agent profile searching method...");
		try {
			AgentProfile entry = agentProfileDao.findById(userController.getUserid());
			
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
			
		} catch (Exception ex) {
			logger.error("Failed to fetch the element data from db, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed to fetch the element data from db, Cause: "+ex.getMessage(), "Information"));
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
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "The data been updated successfully.", "Information"));
		} catch (Exception ex) {
			logger.error("Failed to update the data into db, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed to update the data into db, Cause: "+ex.getMessage(), "Information"));
		}
	}
}
