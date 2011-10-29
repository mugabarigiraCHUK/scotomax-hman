package com.itap.callcenter.mvc.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="param")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class XmlIvrParam implements Serializable {

	private static final long serialVersionUID = 1399205333293875965L;
	
	@XmlAttribute(name="name")
	private String name;
	
	@XmlAttribute(name="value")
	private String value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
}
