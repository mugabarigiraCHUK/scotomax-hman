package com.itap.callcenter.converter.job;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.jsf.FacesContextUtils;

import com.itap.callcenter.dao.apc.job.JobStatusDao;
import com.itap.callcenter.entity.apc.job.JobStatus;

@FacesConverter("jobStatusConverter")
public class JobStatusConverter implements Converter {

	// SLF4J logger
	Logger logger = LoggerFactory.getLogger(JobStatusConverter.class);

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		try {
			logger.debug("The string value getting from faces context, " + value);
			if ( StringUtils.isNumeric(value) && Integer.parseInt(value) != -1 )  {
				JobStatusDao jobStatusDao = (JobStatusDao) FacesContextUtils.getWebApplicationContext(context).getBean("jobStatusDaoImpl");
				return jobStatusDao.findById(Integer.parseInt(value));
			} else throw new RuntimeException("The string value is empty or non-numberic.");
		} catch (Exception ex) {
			logger.warn("Failed to JSF convert string to JobStatus object, "+ex.getMessage());
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		try {
			logger.debug("The object value getting from faces context, " + value);
			if ( value != null && value instanceof JobStatus )  
				return String.valueOf( ( ( JobStatus ) value ).getStatusId() );
			else throw new RuntimeException("The object value is null or non-JobStatus.class");
		} catch (Exception ex) {
			logger.warn("Failed to JSF convert JobStatus object to string, "+ex.getMessage());
			return null;
		}
	}
}
