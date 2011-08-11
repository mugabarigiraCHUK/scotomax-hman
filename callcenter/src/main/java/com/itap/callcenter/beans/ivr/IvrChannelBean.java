package com.itap.callcenter.beans.ivr;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 
 * @author scotomax
 *
 */
public @Data abstract class IvrChannelBean implements Serializable {

	private static final long serialVersionUID = 758157026812699882L;

	protected Integer channelId;
	protected String channelName;
	protected String channelDescription;
	protected Date channelUpdateDate;
    
	protected Integer selectedChannelId;
}
