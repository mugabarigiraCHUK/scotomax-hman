package com.itap.callcenter.beans.knw;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

/**
 * 
 * @author sevenG.oo7
 *
 */
public class KnwTopicBean implements Serializable {

	private static final long serialVersionUID = -6242972333575438561L;
	
	protected Integer topicId;
	protected Integer agentProfileId;
	protected Integer categoryId;
	protected Integer statusId;
	protected String topicName;
	protected String topicDescription;
	protected String topicSubject;
	protected Date topicCreateDate;
	protected Date topicUpdateDate;
	
	protected Integer selectedTopicId;
	protected List<SelectItem> selectItemTopicList;
	public Integer getTopicId() {
		return topicId;
	}
	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}
	public Integer getAgentProfileId() {
		return agentProfileId;
	}
	public void setAgentProfileId(Integer agentProfileId) {
		this.agentProfileId = agentProfileId;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public Integer getStatusId() {
		return statusId;
	}
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	public String getTopicDescription() {
		return topicDescription;
	}
	public void setTopicDescription(String topicDescription) {
		this.topicDescription = topicDescription;
	}
	public String getTopicSubject() {
		return topicSubject;
	}
	public void setTopicSubject(String topicSubject) {
		this.topicSubject = topicSubject;
	}
	public Date getTopicCreateDate() {
		return topicCreateDate;
	}
	public void setTopicCreateDate(Date topicCreateDate) {
		this.topicCreateDate = topicCreateDate;
	}
	public Date getTopicUpdateDate() {
		return topicUpdateDate;
	}
	public void setTopicUpdateDate(Date topicUpdateDate) {
		this.topicUpdateDate = topicUpdateDate;
	}
	public Integer getSelectedTopicId() {
		return selectedTopicId;
	}
	public void setSelectedTopicId(Integer selectedTopicId) {
		this.selectedTopicId = selectedTopicId;
	}
	public List<SelectItem> getSelectItemTopicList() {
		return selectItemTopicList;
	}
	public void setSelectItemTopicList(List<SelectItem> selectItemTopicList) {
		this.selectItemTopicList = selectItemTopicList;
	}
	
}
