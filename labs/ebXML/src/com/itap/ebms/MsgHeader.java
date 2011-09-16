package com.itap.ebms;

import java.io.Serializable;

public class MsgHeader implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -632086669125355540L;
	
	String toPartyId;
	String toRole;
	String fromPartyId;
	String fromRole;
	String idCPA;
	String idConversation;
	String services;
	String action;
	String messageId;
	String timestamp;
	String refToMessageId;
	String timeToLive;
	String ackRequest;
	
	public MsgHeader() {
		super();
	}

	public MsgHeader(String toPartyId, 
			String toRole, 
			String fromPartyId,
			String fromRole, 
			String idCPA, 
			String idConversation,
			String services, 
			String action, 
			String messageId, 
			String timestamp,
			String refToMessageId, 
			String timeToLive, 
			String ackRequest) {
		super();
		this.toPartyId = toPartyId;
		this.toRole = toRole;
		this.fromPartyId = fromPartyId;
		this.fromRole = fromRole;
		this.idCPA = idCPA;
		this.idConversation = idConversation;
		this.services = services;
		this.action = action;
		this.messageId = messageId;
		this.timestamp = timestamp;
		this.refToMessageId = refToMessageId;
		this.timeToLive = timeToLive;
		this.ackRequest = ackRequest;
	}

	public String getToPartyId() {
		return toPartyId;
	}

	public void setToPartyId(String toPartyId) {
		this.toPartyId = toPartyId;
	}

	public String getToRole() {
		return toRole;
	}

	public void setToRole(String toRole) {
		this.toRole = toRole;
	}

	public String getFromPartyId() {
		return fromPartyId;
	}

	public void setFromPartyId(String fromPartyId) {
		this.fromPartyId = fromPartyId;
	}

	public String getFromRole() {
		return fromRole;
	}

	public void setFromRole(String fromRole) {
		this.fromRole = fromRole;
	}

	public String getIdCPA() {
		return idCPA;
	}

	public void setIdCPA(String idCPA) {
		this.idCPA = idCPA;
	}

	public String getIdConversation() {
		return idConversation;
	}

	public void setIdConversation(String idConversation) {
		this.idConversation = idConversation;
	}

	public String getServices() {
		return services;
	}

	public void setServices(String services) {
		this.services = services;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getRefToMessageId() {
		return refToMessageId;
	}

	public void setRefToMessageId(String refToMessageId) {
		this.refToMessageId = refToMessageId;
	}

	public String getTimeToLive() {
		return timeToLive;
	}

	public void setTimeToLive(String timeToLive) {
		this.timeToLive = timeToLive;
	}

	public String getAckRequest() {
		return ackRequest;
	}

	public void setAckRequest(String ackRequest) {
		this.ackRequest = ackRequest;
	}
	
}
