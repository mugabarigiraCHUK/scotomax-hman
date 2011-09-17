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
@XmlRootElement(name="request")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public @Data class XmlIvrRequest implements Serializable {

	private static final long serialVersionUID = 6335280241428025529L;

	@XmlElement(name="params")
	private XmlIvrParams params;
	
}
