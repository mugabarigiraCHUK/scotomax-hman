package com.itap.callcenter.converter.ivr;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.jsf.FacesContextUtils;

import com.itap.callcenter.dao.apc.ivr.IvrCallflowDao;
import com.itap.callcenter.entity.apc.ivr.IvrCallflow;
import com.itap.callcenter.entity.apc.ivr.IvrVoiceprompt;


/**
 * 
 * @author phamon
 *
 */
@FacesConverter("ivrCallflowConverter")
public class IvrCallflowConverter implements Converter { 

	private static Logger logger = LoggerFactory.getLogger(IvrCallflowConverter.class.getPackage().getName());

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		logger.debug("value: " + value + " to " + IvrCallflow.class.getSimpleName());
		try {
			IvrCallflowDao ivrCallflowDao = (IvrCallflowDao) FacesContextUtils.getWebApplicationContext(context).getBean("ivrCallflowDaoImpl");
			return ivrCallflowDao.findById(Integer.parseInt(value));
		} catch (Exception e) {
			logger.error("The string value is empty or non-numberic.");
			return null;
		}
	}
	
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
//		logger.debug("getAsString");
//		logger.debug("value class: " + value == null ? "null" : value.getClass().getSimpleName());
		if ( value != null && value instanceof IvrCallflow )  
			return String.valueOf( ( ( IvrCallflow ) value ).getCallflowId() );
		else {
			logger.error("The object value is null or non " + IvrCallflow.class.getSimpleName());
			return null;
		}
		
	}

	
}
