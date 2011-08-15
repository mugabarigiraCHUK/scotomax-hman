package com.itap.callcenter.converter.acd;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.jsf.FacesContextUtils;

import com.itap.callcenter.dao.apc.acd.AcdConditionDao;
import com.itap.callcenter.entity.apc.acd.AcdCondition;

@FacesConverter("acdConditionConverter")
public class AcdConditionConverter implements Converter {

	// SLF4J logger
	Logger logger = LoggerFactory.getLogger(AcdConditionConverter.class);

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		try {
			logger.debug("The string value getting from faces context, " + value);
			if ( StringUtils.isNumeric(value) && Integer.parseInt(value) != -1 )  {
				AcdConditionDao acdConditionDao = (AcdConditionDao) FacesContextUtils.getWebApplicationContext(context).getBean("acdConditionDaoImpl");
				return acdConditionDao.findById(Integer.parseInt(value));
			} else throw new RuntimeException("The string value is empty or non-numberic.");
		} catch (Exception ex) {
			logger.warn("Failed to JSF convert string to AcdCondition object, "+ex.getMessage());
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		try {
			logger.debug("The object value getting from faces context, " + value);
			if ( value != null && value instanceof AcdCondition )  
				return String.valueOf( ( ( AcdCondition ) value ).getConditionId() );
			else throw new RuntimeException("The object value is null or non-AcdCondition.class");
		} catch (Exception ex) {
			logger.warn("Failed to JSF convert AcdCondition object to string, "+ex.getMessage());
			return null;
		}
	}
}
