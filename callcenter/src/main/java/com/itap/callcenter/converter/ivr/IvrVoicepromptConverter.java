package com.itap.callcenter.converter.ivr;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.jsf.FacesContextUtils;

import com.itap.callcenter.dao.apc.ivr.IvrVoicepromptDao;
import com.itap.callcenter.entity.apc.ivr.IvrVoiceprompt;

/**
 * 
 * @author phamon
 *
 */
@FacesConverter("ivrVoicepromptConverter")
public class IvrVoicepromptConverter implements Converter { 

	private static Logger logger = LoggerFactory.getLogger(IvrVoicepromptConverter.class.getPackage().getName());

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		logger.debug("value: " + value + " to " + IvrVoiceprompt.class.getSimpleName());
		try {
			IvrVoicepromptDao ivrVoicepromptDao = (IvrVoicepromptDao) FacesContextUtils.getWebApplicationContext(context).getBean("ivrVoicepromptDaoImpl");
			return ivrVoicepromptDao.findById(Integer.parseInt(value));
		} catch (Exception e) {
			logger.error("The string value is empty or non-numberic.");
			return null;
		}
	}
	
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		logger.debug("getAsString");
		if ( value != null && value instanceof IvrVoiceprompt )  
			return String.valueOf( ( ( IvrVoiceprompt ) value ).getVoiceId() );
		else {
			logger.error("The object value is null or non " + IvrVoiceprompt.class.getSimpleName());
			return null;
		}
		
	}

	
}
