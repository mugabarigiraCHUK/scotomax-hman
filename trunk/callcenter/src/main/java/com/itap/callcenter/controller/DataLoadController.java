package com.itap.callcenter.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.SelectItem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itap.callcenter.dao.apc.acd.AcdConditionDao;
import com.itap.callcenter.dao.apc.agent.AgentLevelDao;
import com.itap.callcenter.dao.apc.agent.AgentProfileDao;
import com.itap.callcenter.dao.apc.agent.AgentSkillDao;
import com.itap.callcenter.dao.apc.agent.AgentStatusDao;
import com.itap.callcenter.dao.apc.crm.CrmBusinessDao;
import com.itap.callcenter.dao.apc.knw.KnwTopicDao;
import com.itap.callcenter.dao.apc.wkf.WkfWorkplanDao;
import com.itap.callcenter.entity.apc.acd.AcdCondition;
import com.itap.callcenter.entity.apc.agent.AgentLevel;
import com.itap.callcenter.entity.apc.agent.AgentProfile;
import com.itap.callcenter.entity.apc.agent.AgentSkill;
import com.itap.callcenter.entity.apc.agent.AgentStatus;
import com.itap.callcenter.entity.apc.crm.CrmBusiness;
import com.itap.callcenter.entity.apc.knw.KnwTopic;
import com.itap.callcenter.entity.apc.wkf.WkfWorkplan;

/**
 * 
 * @author scotomax
 * @param <T>
 *
 */
@ApplicationScoped
@ManagedBean(name="dataLoadController")
public class DataLoadController implements Serializable {
	
	// Instance serialize
	private static final long serialVersionUID = 711174718447964645L;
	
	// SLF4J logger
	Logger logger = LoggerFactory.getLogger(DataLoadController.class);
	
	// CRM business DAO
	@ManagedProperty(value="#{crmBusinessDaoImpl}")
	CrmBusinessDao crmBusinessDao;
	
	// Know Topic DAO
	@ManagedProperty(value="#{knwTopicDaoImpl}")
	KnwTopicDao knwTopicDao;
	
	// Agent profile (Supervisor) DAO
	@ManagedProperty(value="#{agentProfileDaoImpl}")
	AgentProfileDao agentProfileDao;
	
	// Agent Skill DAO
	@ManagedProperty(value="#{agentSkillDaoImpl}")
	AgentSkillDao agentSkillDao;
	
	// Agent Level DAO
	@ManagedProperty(value="#{agentLevelDaoImpl}")
	AgentLevelDao agentLevelDao;

	// Agent Status DAO
	@ManagedProperty(value="#{agentStatusDaoImpl}")
	AgentStatusDao agentStatusDao;
	
	// Work plan DAO
	@ManagedProperty(value="#{wkfWorkplanDaoImpl}")
	WkfWorkplanDao wkfWorkplanDao;
	
	// Acd condition DAO
	@ManagedProperty(value="#{acdConditionDaoImpl}")
	AcdConditionDao acdConditionDao;
	
	public void setCrmBusinessDao(CrmBusinessDao crmBusinessDao) {
		this.crmBusinessDao = crmBusinessDao;
	}
	
	public void setKnwTopicDao(KnwTopicDao knwTopicDao) {
		this.knwTopicDao = knwTopicDao;
	}

	public void setAgentProfileDao(AgentProfileDao agentProfileDao) {
		this.agentProfileDao = agentProfileDao;
	}

	public void setAgentSkillDao(AgentSkillDao agentSkillDao) {
		this.agentSkillDao = agentSkillDao;
	}

	public void setAgentLevelDao(AgentLevelDao agentLevelDao) {
		this.agentLevelDao = agentLevelDao;
	}

	public void setAgentStatusDao(AgentStatusDao agentStatusDao) {
		this.agentStatusDao = agentStatusDao;
	}

	public void setWkfWorkplanDao(WkfWorkplanDao wkfWorkplanDao) {
		this.wkfWorkplanDao = wkfWorkplanDao;
	}

	public void setAcdConditionDao(AcdConditionDao acdConditionDao) {
		this.acdConditionDao = acdConditionDao;
	}

	/**
	 * List of JSF select item for JSF selection list by
	 * list of CRM business entity
	 * 
	 * @return List of SelectItem.clss by <CrmBusiness, String<Label>>
	 */
	public List<SelectItem> getCrmBusinessSelectItems() {
		List<SelectItem> selectItems = new ArrayList<SelectItem>();
		try {
			List<CrmBusiness> rsList = crmBusinessDao.findAll();
			if ( rsList != null && rsList.size() > 0 ) 
				for ( CrmBusiness item : rsList ) 
					selectItems.add(new SelectItem(item, item.getBusinessName()));
		} catch (Exception ex) {
			logger.warn("Failed to load CRM business entity list, "+ex.getMessage());
		}
		return selectItems;
	}
	
	/**
	 * List of JSF select item for JSF selection list by
	 * list of know topic entity
	 * 
	 * @return List of SelectItem.clss by <KnwTopic, String<Label>>
	 */
	public List<SelectItem> getKnwTopicSelectItems() {
		List<SelectItem> selectItems = new ArrayList<SelectItem>();
		try {
			List<KnwTopic> rsList = knwTopicDao.findAll();
			if ( rsList != null && rsList.size() > 0 ) 
				for ( KnwTopic item : rsList ) 
					selectItems.add(new SelectItem(item, item.getTopicName()));
		} catch (Exception ex) {
			logger.warn("Failed to load Know Topic entity list, "+ex.getMessage());
		}
		return selectItems;
	}
	
	/**
	 * List of JSF select item for JSF selection list by
	 * list of agent profile entity
	 * 
	 * @return List of SelectItem.clss by <AgentProfile, String<Label>>
	 */
	public List<SelectItem> getAgentProfileSelectItems() {
		List<SelectItem> selectItems = new ArrayList<SelectItem>();
		try {
			List<AgentProfile> rsList = agentProfileDao.findAll();
			if ( rsList != null && rsList.size() > 0 ) 
				for ( AgentProfile item : rsList ) 
					selectItems.add(new SelectItem(item, item.getAgentFullname()));
		} catch (Exception ex) {
			logger.warn("Failed to load Agent Profile entity list, "+ex.getMessage());
		}
		return selectItems;
	}
	
	/**
	 * List of JSF select item for JSF selection list by
	 * list of agent skill entity
	 * 
	 * @return List of SelectItem.clss by <AgentSkill, String<Label>>
	 */
	public List<SelectItem> getAgentSkillSelectItems() {
		List<SelectItem> selectItems = new ArrayList<SelectItem>();
		try {
			List<AgentSkill> rsList = agentSkillDao.findAll();
			if ( rsList != null && rsList.size() > 0 ) 
				for ( AgentSkill item : rsList ) 
					selectItems.add(new SelectItem(item, item.getSkillName()));
		} catch (Exception ex) {
			logger.warn("Failed to load Agent Skill entity list, "+ex.getMessage());
		}
		return selectItems;
	}
	
	/**
	 * List of JSF select item for JSF selection list by
	 * list of agent level entity
	 * 
	 * @return List of SelectItem.clss by <AgentLevel, String<Label>>
	 */
	public List<SelectItem> getAgentLevelSelectItems() {
		List<SelectItem> selectItems = new ArrayList<SelectItem>();
		try {
			List<AgentLevel> rsList = agentLevelDao.findAll();
			if ( rsList != null && rsList.size() > 0 ) 
				for ( AgentLevel item : rsList ) 
					selectItems.add(new SelectItem(item, item.getLevelName()));
		} catch (Exception ex) {
			logger.warn("Failed to load Agent Level entity list, "+ex.getMessage());
		}
		return selectItems;
	}
	
	/**
	 * List of JSF select item for JSF selection list by
	 * list of agent status entity
	 * 
	 * @return List of SelectItem.clss by <AgentStatus, String<Label>>
	 */
	public List<SelectItem> getAgentStatusSelectItems() {
		List<SelectItem> selectItems = new ArrayList<SelectItem>();
		try {
			List<AgentStatus> rsList = agentStatusDao.findAll();
			if ( rsList != null && rsList.size() > 0 ) 
				for ( AgentStatus item : rsList ) 
					selectItems.add(new SelectItem(item, item.getStatusName()));
		} catch (Exception ex) {
			logger.warn("Failed to load Agent status entity list, "+ex.getMessage());
		}
		return selectItems;
	}
	
	/**
	 * List of JSF select item for JSF selection list by
	 * list of work plan entity
	 * 
	 * @return List of SelectItem.clss by <WkfWorkplan, String<Label>>
	 */
	public List<SelectItem> getWkfWorkplanSelectItems() {
		List<SelectItem> selectItems = new ArrayList<SelectItem>();
		try {
			List<WkfWorkplan> rsList = wkfWorkplanDao.findAll();
			if ( rsList != null && rsList.size() > 0 ) 
				for ( WkfWorkplan item : rsList ) 
					selectItems.add(new SelectItem(item, item.getWorkplanName()));
		} catch (Exception ex) {
			logger.warn("Failed to load Work plan entity list, "+ex.getMessage());
		}
		return selectItems;
	}
	
	/**
	 * List of JSF select item for JSF selection list by
	 * list of Acd condition entity
	 * 
	 * @return List of SelectItem.clss by <AcdCondition, String<Label>>
	 */
	public List<SelectItem> getAcdConditionSelectItems() {
		List<SelectItem> selectItems = new ArrayList<SelectItem>();
		try {
			List<AcdCondition> rsList = acdConditionDao.findAll();
			if ( rsList != null && rsList.size() > 0 ) 
				for ( AcdCondition item : rsList ) 
					selectItems.add(new SelectItem(item, item.getConditionName()));
		} catch (Exception ex) {
			logger.warn("Failed to load Work plan entity list, "+ex.getMessage());
		}
		return selectItems;
	}
	
}
