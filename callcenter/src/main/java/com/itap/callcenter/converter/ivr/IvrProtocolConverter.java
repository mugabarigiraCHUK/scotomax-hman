package com.itap.callcenter.converter.ivr;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.jsf.FacesContextUtils;

import com.itap.callcenter.dao.apc.ivr.IvrProtocolDao;
import com.itap.callcenter.entity.apc.ivr.IvrProtocol;


/**
 * 
 * @author phamon
 *
 */
@FacesConverter("ivrProtocolConverter")
public class IvrProtocolConverter  implements Converter { 

	private static Logger logger = LoggerFactory.getLogger(IvrProtocolConverter.class.getPackage().getName());

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		logger.debug("value: " + value + " to " + IvrProtocol.class.getSimpleName());
		try {
			IvrProtocolDao ivrProtocolDao = (IvrProtocolDao) FacesContextUtils.getWebApplicationContext(context).getBean("ivrProtocolDaoImpl");
			return ivrProtocolDao.findById(Integer.parseInt(value));
		} catch (Exception e) {
			logger.error("The string value is empty or non-numberic.");
			return null;
		}
	}
	
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if ( value != null && value instanceof IvrProtocol )  
			return String.valueOf( ( ( IvrProtocol ) value ).getProtocolId() );
		else {
			logger.error("The object value is null or non " + IvrProtocol.class.getSimpleName());
			return null;
		}
		
	}
	
}