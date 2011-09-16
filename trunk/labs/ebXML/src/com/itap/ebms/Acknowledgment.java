package com.itap.ebms;

import java.io.Serializable;

public class Acknowledgment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7671563314930844351L;

	String ack_id;
	String ack_version;
	String ack_actor;
	String ack_mustUnderstand;
	String timestamp;
	String refToMessageId;
	String from;
	
	public Acknowledgment() {
		super();
	}
	
	public Acknowledgment(String ack_id, 
			String ack_version, 
			String ack_actor,
			String ack_mustUnderstand, 
			String timestamp, 
			String refToMessageId,
			String from) {
		super();
		this.ack_id = ack_id;
		this.ack_version = ack_version;
		this.ack_actor = ack_actor;
		this.ack_mustUnderstand = ack_mustUnderstand;
		this.timestamp = timestamp;
		this.refToMessageId = refToMessageId;
		this.from = from;
	}
	
	public String getAck_id() {
		return ack_id;
	}
	public void setAck_id(String ack_id) {
		this.ack_id = ack_id;
	}
	public String getAck_version() {
		return ack_version;
	}
	public void setAck_version(String ack_version) {
		this.ack_version = ack_version;
	}
	public String getAck_actor() {
		return ack_actor;
	}
	public void setAck_actor(String ack_actor) {
		this.ack_actor = ack_actor;
	}
	public String getAck_mustUnderstand() {
		return ack_mustUnderstand;
	}
	public void setAck_mustUnderstand(String ack_mustUnderstand) {
		this.ack_mustUnderstand = ack_mustUnderstand;
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
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	
}
