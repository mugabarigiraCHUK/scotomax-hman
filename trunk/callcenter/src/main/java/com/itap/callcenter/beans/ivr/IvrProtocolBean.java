package com.itap.callcenter.beans.ivr;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author scotomax
 *
 */
public abstract class IvrProtocolBean implements Serializable {

	private static final long serialVersionUID = -4589285573648646788L;
	
	protected Integer protocolId;
	protected String protocolName;
	protected String protocolDescription;
	protected Date protocolUpdateDate;
    
    protected Integer selectedProtocolId;

	public Integer getProtocolId() {
		return protocolId;
	}

	public void setProtocolId(Integer protocolId) {
		this.protocolId = protocolId;
	}

	public String getProtocolName() {
		return protocolName;
	}

	public void setProtocolName(String protocolName) {
		this.protocolName = protocolName;
	}

	public String getProtocolDescription() {
		return protocolDescription;
	}

	public void setProtocolDescription(String protocolDescription) {
		this.protocolDescription = protocolDescription;
	}

	public Date getProtocolUpdateDate() {
		return protocolUpdateDate;
	}

	public void setProtocolUpdateDate(Date protocolUpdateDate) {
		this.protocolUpdateDate = protocolUpdateDate;
	}

	public Integer getSelectedProtocolId() {
		return selectedProtocolId;
	}

	public void setSelectedProtocolId(Integer selectedProtocolId) {
		this.selectedProtocolId = selectedProtocolId;
	}
    
    
}
