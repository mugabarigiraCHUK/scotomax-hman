package com.itap.callcenter.controller.agent;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itap.callcenter.beans.agent.AgentScriptBean;
import com.itap.callcenter.dao.apc.agent.AgentScriptDao;
import com.itap.callcenter.entity.apc.agent.AgentScript;

/**
 * 
 * @author scotomax
 *
 */
@ViewScoped
@ManagedBean(name="agentScriptController")
public class AgentScriptController extends AgentScriptBean {

	private static final long serialVersionUID = 7614460902104253267L;
	// SLF4J logger
	Logger logger = LoggerFactory.getLogger(AgentScriptController.class);
	// Agent Script DAO
	@ManagedProperty(value="#{agentScriptDaoImpl}")
	AgentScriptDao agentScriptDao;
	
	public void setAgentScriptDao(AgentScriptDao agentScriptDao) {
		this.agentScriptDao = agentScriptDao;
	}
	
	/**
	 * Searching Agent script entity data by criteria from database.
	 */
	public void search() {
		logger.debug("Entering Agent script searching method...");
		try {
			if ( isBusinessAndTopicSelected() ) 
				agentScripts = agentScriptDao.findAllByCrmBusinessAndKnwTopic(business, topic);
			else logger.warn("System could not found business and topic objects are selected!");
		} catch ( Exception ex ) {
			logger.error("Failed to fetching the data from db, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to fetching the data from db, Cause: "+ex.getMessage()));
		}
	}
	
	/**
	 * Clear Agent script entity data on the pages.
	 */
	public void clear() {
		logger.debug("Entering Agent script clearing method...");
		scriptId = null;
		scriptName = null;
		scriptDescription = null;
		scriptStep = null;
		scriptMessage = null;
		scriptCreateDate = null;
		scriptUpdateDate =null;
		agentScripts = null;
	}
	
	/**
	 * Create Agent script entity data insert into database.
	 */
	public void create() {
		logger.debug("Entering Agent script creation method...");
		
		logger.debug("Look -> CrmBusiness -> " + business);
		logger.debug("Look -> KnwTopic -> " + topic);
		
		try {
			if ( isBusinessAndTopicSelected() ) {
				AgentScript entry = new AgentScript();
				entry.setScriptId(scriptId);
				entry.setScriptName(scriptName);
				entry.setScriptDescription(scriptDescription);
				entry.setScriptStep(scriptStep);
				entry.setScriptMessage(scriptMessage);
				entry.setScriptCreateDate(new Date());
				entry.setScriptUpdateDate(new Date());
				
				entry.setBusiness(business);
				entry.setTopic(topic);
				
				agentScriptDao.save(entry);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("The data been created successfully."));
			} else {
				logger.warn("System could not found business and topic are selected..");
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Please select business and topic data."));
			}
		} catch (Exception ex) {
			logger.error("Failed to insert the data into db, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to insert the data into db, Cause: "+ex.getMessage()));
		}
	}
	
	/**
	 * Update Agent script entity data update into database.
	 */
	public void update() {
		logger.debug("Entering Agent script update method...");
		try {
			AgentScript entry = agentScriptDao.findById(scriptId);
			entry.setScriptName(scriptName);
			entry.setScriptDescription(scriptDescription);
			entry.setScriptStep(scriptStep);
			entry.setScriptMessage(scriptMessage);
			entry.setScriptUpdateDate(new Date());
			agentScriptDao.update(entry);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("The data been updated successfully."));
		} catch (Exception ex) {
			logger.error("Failed to update the data into db, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to update the data into db, Cause: "+ex.getMessage()));
		}
	}
	
	/**
	 * Fetch Agent script entity data from database.
	 */
	public void edit() {
		logger.debug("Entering Agent script edit method...");
		if ( isBusinessAndTopicSelected() ) {
			if ( selectedScriptId == null || selectedScriptId.intValue() == -1 ) {
				scriptId = null;
				scriptName = null;
				scriptDescription = null;
				scriptStep = null;
				scriptMessage = null;
				scriptCreateDate = null;
				scriptUpdateDate = null;
				
			} else {
				try {
					AgentScript entry = agentScriptDao.findById(selectedScriptId);
					scriptId = entry.getScriptId();
					scriptName = entry.getScriptName();
					scriptDescription = entry.getScriptDescription();
					scriptStep = entry.getScriptStep();
					scriptMessage = entry.getScriptMessage();
					scriptCreateDate = entry.getScriptCreateDate();
					scriptUpdateDate = entry.getScriptUpdateDate();
					selectedScriptId = -1;
				} catch (Exception ex) {
					logger.error("Failed to fetch the element data from db, Cause: "+ex.getMessage(), ex);
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to fetch the element data from db, Cause: "+ex.getMessage()));
				}
			}
		} else {
			logger.warn("System could not found business and topic are selected..");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Please select business and topic data."));
		}
	}
	
	/**
	 * Delete Agent script entity data from database.
	 */
	public void delete() {
		logger.debug("Entering Agent script delete method...");
		try {
			if ( selectedScriptId != null ) {
				agentScriptDao.deleteById(selectedScriptId);
				selectedScriptId = -1;
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("The data been deleted successfully."));
			}
		} catch (Exception ex) {
			logger.error("Failed to delete the data, Cause: "+ex.getMessage(), ex);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to delete the data, Cause: "+ex.getMessage()));
		}
	}
	
	/**
	 * Validate business and topic objects are selected
	 * @return true when business object and topic object are selected, otherwise is false
	 */
	public boolean isBusinessAndTopicSelected() {
		if ( business != null 
				&& business.getBusinessId() != null
				&& topic != null
				&& topic.getTopicId() != null ) {
			return true;
		} else return false;
	}
}
