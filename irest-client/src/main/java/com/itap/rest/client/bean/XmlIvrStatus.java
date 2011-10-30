package com.itap.rest.client.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * @author scotomax
 *
 */
@XmlRootElement(name="status")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class XmlIvrStatus implements Serializable {

	private static final long serialVersionUID = -9130172926414801271L;

	@XmlAttribute(name="code")
	private String responseCode;
	
	@XmlAttribute(name="desc")
	private String responseDesc;

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseDesc() {
		return responseDesc;
	}

	public void setResponseDesc(String responseDesc) {
		this.responseDesc = responseDesc;
	}
	
}
