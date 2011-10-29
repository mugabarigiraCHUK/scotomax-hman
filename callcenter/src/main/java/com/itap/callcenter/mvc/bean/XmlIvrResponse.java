package com.itap.callcenter.mvc.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * @author scotomax
 *
 */
@XmlRootElement(name="response")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class XmlIvrResponse implements Serializable {

	private static final long serialVersionUID = 4632733481424627141L;
	
	@XmlElement(name="params")
	private XmlIvrParams params;
	
	@XmlElement(name="status")
	private XmlIvrStatus status;

	public XmlIvrParams getParams() {
		return params;
	}

	public void setParams(XmlIvrParams params) {
		this.params = params;
	}

	public XmlIvrStatus getStatus() {
		return status;
	}

	public void setStatus(XmlIvrStatus status) {
		this.status = status;
	}
	
	
}
