package com.itap.callcenter.converter.agent;

import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itap.callcenter.dao.apc.agent.AgentProfileDao;
import com.itap.callcenter.entity.apc.agent.AgentProfile;

@FacesConverter("agentProfileConverter")
public class AgentProfileConverter implements Converter {

	// SLF4J logger
	Logger logger = LoggerFactory.getLogger(AgentProfileConverter.class);
	// Agent Profile DAO
	@ManagedProperty(value="#{agentProfileDaoImpl}")
	AgentProfileDao agentProfileDao;
	
	public void setAgentProfileDao(AgentProfileDao agentProfileDao) {
		this.agentProfileDao = agentProfileDao;
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		try {
			logger.debug("The string value getting from faces context, " + value);
			if ( StringUtils.isNumeric(value) && Integer.parseInt(value) != -1 )  
				return agentProfileDao.findById(Integer.parseInt(value));
			else throw new RuntimeException("The string value is empty or non-numberic.");
		} catch (Exception ex) {
			logger.warn("Failed to JSF convert string to AgentProfile object, "+ex.getMessage());
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		try {
			logger.debug("The object value getting from faces context, " + value);
			if ( value != null && value instanceof AgentProfile )  
				return String.valueOf( ( ( AgentProfile ) value ).getAgentId() );
			else throw new RuntimeException("The object value is null or non-AgentProfile.class");
		} catch (Exception ex) {
			logger.warn("Failed to JSF convert AgentProfile object to string, "+ex.getMessage());
			return null;
		}
	}
}
