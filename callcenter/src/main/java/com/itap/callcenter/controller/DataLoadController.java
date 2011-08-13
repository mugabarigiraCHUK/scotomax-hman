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

import com.itap.callcenter.dao.apc.crm.CrmBusinessDao;
import com.itap.callcenter.dao.apc.knw.KnwTopicDao;
import com.itap.callcenter.entity.apc.crm.CrmBusiness;
import com.itap.callcenter.entity.apc.knw.KnwTopic;

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

	public void setCrmBusinessDao(CrmBusinessDao crmBusinessDao) {
		this.crmBusinessDao = crmBusinessDao;
	}
	
	public void setKnwTopicDao(KnwTopicDao knwTopicDao) {
		this.knwTopicDao = knwTopicDao;
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
	
}
