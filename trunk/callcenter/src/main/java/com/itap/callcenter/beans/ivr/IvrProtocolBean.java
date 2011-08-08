package com.itap.callcenter.beans.ivr;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 
 * @author scotomax
 *
 */
public @Data abstract class IvrProtocolBean implements Serializable {

	private static final long serialVersionUID = -4589285573648646788L;
	
	protected Integer protocolId;
	protected String protocolName;
	protected String protocolDescription;
	protected Date protocolUpdateDate;
    
    protected Integer selectedProtocolId;
}
