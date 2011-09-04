package com.itap.callcenter.converter.ivr;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.jsf.FacesContextUtils;

import com.itap.callcenter.dao.apc.ivr.IvrCallrouteDao;
import com.itap.callcenter.entity.apc.ivr.IvrCallroute;


/**
 * 
 * @author phamon
 *
 */
@FacesConverter("ivrCallrouteConverter")
public class IvrCallrouteConverter  implements Converter { 

	private static Logger logger = LoggerFactory.getLogger(IvrCallrouteConverter.class.getPackage().getName());

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		logger.debug("value: " + value + " to " + IvrCallroute.class.getSimpleName());
		try {
			IvrCallrouteDao ivrCallrouteDao = (IvrCallrouteDao) FacesContextUtils.getWebApplicationContext(context).getBean("ivrCallrouteDaoImpl");
			return ivrCallrouteDao.findById(Integer.parseInt(value));
		} catch (Exception e) {
			logger.error("The string value is empty or non-numberic.");
			return null;
		}
	}
	
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if ( value != null && value instanceof IvrCallroute )  
			return String.valueOf( ( ( IvrCallroute ) value ).getCallrouteId() );
		else {
			logger.error("The object value is null or non " + IvrCallroute.class.getSimpleName());
			return null;
		}
		
	}



}
