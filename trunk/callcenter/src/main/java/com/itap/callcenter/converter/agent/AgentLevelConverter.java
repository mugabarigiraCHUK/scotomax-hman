package com.itap.callcenter.converter.agent;

import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itap.callcenter.dao.apc.agent.AgentLevelDao;
import com.itap.callcenter.entity.apc.agent.AgentLevel;

@FacesConverter("agentLevelConverter")
public class AgentLevelConverter implements Converter {

	// SLF4J logger
	Logger logger = LoggerFactory.getLogger(AgentLevelConverter.class);
	// Agent Level DAO
	@ManagedProperty(value="#{agentLevelDaoImpl}")
	AgentLevelDao agentLevelDao;
	
	public void setAgentLevelDao(AgentLevelDao agentLevelDao) {
		this.agentLevelDao = agentLevelDao;
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		try {
			logger.debug("The string value getting from faces context, " + value);
			if ( StringUtils.isNumeric(value) && Integer.parseInt(value) != -1 )  
				return agentLevelDao.findById(Integer.parseInt(value));
			else throw new RuntimeException("The string value is empty or non-numberic.");
		} catch (Exception ex) {
			logger.warn("Failed to JSF convert string to AgentLevel object, "+ex.getMessage());
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		try {
			logger.debug("The object value getting from faces context, " + value);
			if ( value != null && value instanceof AgentLevel )  
				return String.valueOf( ( ( AgentLevel ) value ).getLevelId() );
			else throw new RuntimeException("The object value is null or non-AgentLevel.class");
		} catch (Exception ex) {
			logger.warn("Failed to JSF convert AgentLevel object to string, "+ex.getMessage());
			return null;
		}
	}
}
