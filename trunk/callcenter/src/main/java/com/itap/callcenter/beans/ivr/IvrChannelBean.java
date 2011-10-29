package com.itap.callcenter.beans.ivr;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author scotomax
 *
 */
public abstract class IvrChannelBean implements Serializable {

	private static final long serialVersionUID = 758157026812699882L;

	protected Integer channelId;
	protected String channelName;
	protected String channelDescription;
	protected Date channelUpdateDate;
    
	protected Integer selectedChannelId;

	public Integer getChannelId() {
		return channelId;
	}

	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getChannelDescription() {
		return channelDescription;
	}

	public void setChannelDescription(String channelDescription) {
		this.channelDescription = channelDescription;
	}

	public Date getChannelUpdateDate() {
		return channelUpdateDate;
	}

	public void setChannelUpdateDate(Date channelUpdateDate) {
		this.channelUpdateDate = channelUpdateDate;
	}

	public Integer getSelectedChannelId() {
		return selectedChannelId;
	}

	public void setSelectedChannelId(Integer selectedChannelId) {
		this.selectedChannelId = selectedChannelId;
	}
	
	
}
