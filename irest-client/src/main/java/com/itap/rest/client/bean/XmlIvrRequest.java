package com.itap.rest.client.bean;

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
@XmlRootElement(name="request")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class XmlIvrRequest implements Serializable {

	private static final long serialVersionUID = 6335280241428025529L;

	@XmlElement(name="params")
	private XmlIvrParams params;

	public XmlIvrParams getParams() {
		return params;
	}

	public void setParams(XmlIvrParams params) {
		this.params = params;
	}
	
}
