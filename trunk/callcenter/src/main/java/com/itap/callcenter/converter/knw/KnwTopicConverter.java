package com.itap.callcenter.converter.knw;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.jsf.FacesContextUtils;

import com.itap.callcenter.dao.apc.knw.KnwTopicDao;
import com.itap.callcenter.entity.apc.knw.KnwTopic;

/**
 * 
 * @author scotomax
 *
 */
@FacesConverter("knwTopicConverter")
public class KnwTopicConverter implements Converter {

	// SLF4J logger
	Logger logger = LoggerFactory.getLogger(KnwTopicConverter.class);

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		try {
			logger.debug("The string value getting from faces context, " + value);
			if ( StringUtils.isNumeric(value) && Integer.parseInt(value) != -1 )  {
				KnwTopicDao knwTopicDao = (KnwTopicDao) FacesContextUtils.getWebApplicationContext(context).getBean("knwTopicDaoImpl");
				return knwTopicDao.findById(Integer.parseInt(value));
			} else throw new RuntimeException("The string value is empty or non-numberic.");
		} catch (Exception ex) {
			logger.warn("Failed to JSF convert string to KnwTopic object, "+ex.getMessage());
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		try {
			logger.debug("The object value getting from faces context, " + value);
			if ( value != null && value instanceof KnwTopic )  
				return String.valueOf( ( ( KnwTopic ) value ).getTopicId() );
			else throw new RuntimeException("The object value is null or non-KnwTopic.class");
		} catch (Exception ex) {
			logger.warn("Failed to JSF convert KnwTopic object to string, "+ex.getMessage());
			return null;
		}
	}
}
