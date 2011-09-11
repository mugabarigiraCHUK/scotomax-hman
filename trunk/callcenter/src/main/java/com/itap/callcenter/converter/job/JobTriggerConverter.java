package com.itap.callcenter.converter.job;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.jsf.FacesContextUtils;

import com.itap.callcenter.dao.apc.job.JobTriggerDao;
import com.itap.callcenter.entity.apc.job.JobTrigger;

/**
 * 
 * @author phamon
 *
 */
@FacesConverter("jobTriggerConverter")
public class JobTriggerConverter  implements Converter { 

	private static Logger logger = LoggerFactory.getLogger(JobTriggerConverter.class.getPackage().getName());

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		logger.debug("value: " + value + " to " + JobTrigger.class.getSimpleName());
		try {
			JobTriggerDao jobTriggerDao = (JobTriggerDao) FacesContextUtils.getWebApplicationContext(context).getBean("jobTriggerDaoImpl");
			return jobTriggerDao.findById(Integer.parseInt(value));
		} catch (Exception e) {
			logger.error("The string value is empty or non-numberic.");
			return null;
		}
	}
	
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if ( value != null && value instanceof JobTrigger )  
			return String.valueOf( ( ( JobTrigger ) value ).getTriggerId() );
		else {
			logger.error("The object value is null or non " + JobTrigger.class.getSimpleName());
			return null;
		}
		
	}
	
}