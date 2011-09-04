package com.itap.callcenter.converter.ivr;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.jsf.FacesContextUtils;

import com.itap.callcenter.dao.apc.ivr.IvrChannelDao;
import com.itap.callcenter.entity.apc.ivr.IvrChannel;


/**
 * 
 * @author phamon
 *
 */
@FacesConverter("ivrChannelConverter")
public class IvrChannelConverter  implements Converter { 

	private static Logger logger = LoggerFactory.getLogger(IvrChannelConverter.class.getPackage().getName());

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		logger.debug("value: " + value + " to " + IvrChannel.class.getSimpleName());
		try {
			IvrChannelDao ivrChannelDao = (IvrChannelDao) FacesContextUtils.getWebApplicationContext(context).getBean("ivrChannelDaoImpl");
			return ivrChannelDao.findById(Integer.parseInt(value));
		} catch (Exception e) {
			logger.error("The string value is empty or non-numberic.");
			return null;
		}
	}
	
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if ( value != null && value instanceof IvrChannel )  
			return String.valueOf( ( ( IvrChannel ) value ).getChannelId() );
		else {
			logger.error("The object value is null or non " + IvrChannel.class.getSimpleName());
			return null;
		}
		
	}
	
}
