package com.itap.rest.client.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import lombok.Data;

@XmlRootElement(name="param")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public @Data class XmlIvrParam implements Serializable {

	private static final long serialVersionUID = 1399205333293875965L;
	
	@XmlAttribute(name="name")
	private String name;
	
	@XmlAttribute(name="value")
	private String value;
	
}
