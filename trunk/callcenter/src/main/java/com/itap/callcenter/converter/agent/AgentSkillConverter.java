package com.itap.callcenter.converter.agent;

import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itap.callcenter.dao.apc.agent.AgentSkillDao;
import com.itap.callcenter.entity.apc.agent.AgentSkill;

@FacesConverter("agentSkillConverter")
public class AgentSkillConverter implements Converter {

	// SLF4J logger
	Logger logger = LoggerFactory.getLogger(AgentSkillConverter.class);
	// Agent Skill DAO
	@ManagedProperty(value="#{agentSkillDaoImpl}")
	AgentSkillDao agentSkillDao;
	
	public void setAgentSkillDao(AgentSkillDao agentSkillDao) {
		this.agentSkillDao = agentSkillDao;
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		try {
			logger.debug("The string value getting from faces context, " + value);
			if ( StringUtils.isNumeric(value) && Integer.parseInt(value) != -1 )  
				return agentSkillDao.findById(Integer.parseInt(value));
			else throw new RuntimeException("The string value is empty or non-numberic.");
		} catch (Exception ex) {
			logger.warn("Failed to JSF convert string to Agent skill object, "+ex.getMessage());
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		try {
			logger.debug("The object value getting from faces context, " + value);
			if ( value != null && value instanceof AgentSkill )  
				return String.valueOf( ( ( AgentSkill ) value ).getSkillId() );
			else throw new RuntimeException("The object value is null or non-AgentSkill.class");
		} catch (Exception ex) {
			logger.warn("Failed to JSF convert Agent skill object to string, "+ex.getMessage());
			return null;
		}
	}
}
