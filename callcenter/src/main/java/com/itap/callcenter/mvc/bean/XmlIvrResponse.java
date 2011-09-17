package com.itap.callcenter.mvc.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import lombok.Data;

/**
 * 
 * @author scotomax
 *
 */
@XmlRootElement(name="response")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public @Data class XmlIvrResponse implements Serializable {

	private static final long serialVersionUID = 4632733481424627141L;
	
	@XmlElement(name="params")
	private XmlIvrParams params;
	
	@XmlElement(name="status")
	private XmlIvrStatus status;
	
}
