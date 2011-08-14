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

import com.itap.callcenter.beans.agent.AgentStatusBean;
import com.itap.callcenter.dao.apc.agent.AgentStatusDao;
import com.itap.callcenter.entity.apc.agent.AgentStatus;

/**
 * 
 * @author scotomax
 *
 */
@ViewScoped
@ManagedBean(name="agentStatusController")
public class AgentStatusController extends AgentStatusBean {

	private static final long serialVersionUID = -3684652437886208299L;

	// SLF4J Logger
	private static Logger logger = LoggerFactory.getLogger(AgentStatusController.class);
	
	// Agent status DAO
	@ManagedProperty(value = "#{agentStatusDaoImpl}")
	AgentStatusDao agentStatusDao;

	public void setAgentStatusDao(AgentStatusDao agentStatusDao) {
		this.agentStatusDao = agentStatusDao;
	}
	
	/**
	 * Create Agent status entity data insert into database.
	 */
	public void create() {
		logger.debug("Entering Agent Status creation method...");
		try {
			AgentStatus entry = new AgentStatus();
			entry.setStatusId(statusId);
			entry.setStatusName(statusName);
			entry.setStatusDescription(statusDescription);
			entry.setStatusUpdateDate(new Date());
			agentStatusDao.save(entry);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("The data been created successfully."));
		} catch (Exception ex) {
			logger.error("Failed to insert the data into db, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to insert the data into db, Cause: "+ex.getMessage()));
		}
	}
	
	/**
	 * Update Agent status entity data update into database.
	 */
	public void update() {
		logger.debug("Entering Agent Status update method...");
		try {
			AgentStatus entry = new AgentStatus();
			entry.setStatusId(statusId);
			entry.setStatusName(statusName);
			entry.setStatusDescription(statusDescription);
			entry.setStatusUpdateDate(new Date());
			agentStatusDao.update(entry);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("The data been updated successfully."));
		} catch (Exception ex) {
			logger.error("Failed to update the data into db, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to update the data into db, Cause: "+ex.getMessage()));
		}
	}
	
	/**
	 * Fetch Agent status entity data from database.
	 */
	public void edit() {
		logger.debug("Entering Agent Status edit method...");
		if ( selectedStatusId == null || selectedStatusId.intValue() == -1 ) {
			statusId = null;
			statusName = null;
			statusDescription = null;
			statusUpdateDate = null;
		} else {
			try {
				AgentStatus entry = agentStatusDao.findById(selectedStatusId);
				statusId = entry.getStatusId();
				statusName = entry.getStatusName();
				statusDescription = entry.getStatusDescription();
				statusUpdateDate = entry.getStatusUpdateDate();
				selectedStatusId = -1;
			} catch (Exception ex) {
				logger.error("Failed to fetch the element data from db, Cause: "+ex.getMessage(), ex);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to fetch the element data from db, Cause: "+ex.getMessage()));
			}
		}
	}
	
	/**
	 * Delete Agent status entity data from database.
	 */
	public void delete() {
		logger.debug("Entering Agent Status delete method...");
		try {
			if ( selectedStatusId != null ) {
				agentStatusDao.deleteById(selectedStatusId);
				selectedStatusId = -1;
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("The data been deleted successfully."));
			}
		} catch (Exception ex) {
			logger.error("Failed to delete the data, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to delete the data, Cause: "+ex.getMessage()));
		}
	}
	
	/**
	 * Fetch list of all Agent status entity data from database.
	 */
	public List<AgentStatus> getAgentStatusList() {
		logger.debug("Entering Agent Status getting list of all entity method...");
		List<AgentStatus> rsList = null;
		try {
			rsList = agentStatusDao.findAll();
		} catch ( Exception ex ) {
			logger.error("Failed to load the data, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to load the data, Cause: "+ex.getMessage()));
		}
		return rsList;
	}
}
