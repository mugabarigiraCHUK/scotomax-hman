package com.itap.rest.client.bean;

import java.io.Serializable;
import java.util.List;

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
@XmlRootElement(name="params")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class XmlIvrParams implements Serializable {

	private static final long serialVersionUID = 5278284522427680789L;
	
	@XmlElement
	private List<XmlIvrParam> param;

	public List<XmlIvrParam> getParam() {
		return param;
	}

	public void setParam(List<XmlIvrParam> param) {
		this.param = param;
	}
	
}
