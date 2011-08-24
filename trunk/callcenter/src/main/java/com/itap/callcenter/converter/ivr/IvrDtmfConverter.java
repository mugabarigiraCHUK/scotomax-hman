package com.itap.callcenter.converter.ivr;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.jsf.FacesContextUtils;

import com.itap.callcenter.dao.apc.ivr.IvrDtmfDao;
import com.itap.callcenter.entity.apc.ivr.IvrDtmf;

/**
 * 
 * @author phamon
 *
 */
@FacesConverter("ivrDtmfConverter")
public class IvrDtmfConverter implements Converter { 

	private static Logger logger = LoggerFactory.getLogger(IvrDtmfConverter.class.getPackage().getName());

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		logger.debug("value: " + value + " to " + IvrDtmfConverter.class.getSimpleName());
		try {
			IvrDtmfDao ivrDtmfDao = (IvrDtmfDao) FacesContextUtils.getWebApplicationContext(context).getBean("ivrDtmfDaoImpl");
			return ivrDtmfDao.findById(Integer.parseInt(value));
		} catch (Exception e) {
			logger.error("The string value is empty or non-numberic.");
			return null;
		}
	}
	
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		logger.debug("getAsString");
		if ( value != null && value instanceof IvrDtmf )  
			return String.valueOf( ( ( IvrDtmf ) value ).getDtmfId() );
		else {
			logger.error("The object value is null or non " + IvrDtmf.class.getSimpleName());
			return null;
		}
		
	}

	
}
