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
public class KnwSolutionBean implements Serializable {

	private static final long serialVersionUID = -4987873455228794034L;
	
	private Integer solutionId;
    private Integer topicId;
    private Integer agentProfileId;
    private Integer supervisorId;
    private Integer statusId;
    private String solutionName;
    private String solutionDescription;
    private Date solutionCreateDate;
    private Date solutionUpdateDate;
	
	private Integer selectedSolutionId;
	private List<SelectItem> selectItemSolutionList;
	public Integer getSolutionId() {
		return solutionId;
	}
	public void setSolutionId(Integer solutionId) {
		this.solutionId = solutionId;
	}
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
	public Integer getSupervisorId() {
		return supervisorId;
	}
	public void setSupervisorId(Integer supervisorId) {
		this.supervisorId = supervisorId;
	}
	public Integer getStatusId() {
		return statusId;
	}
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}
	public String getSolutionName() {
		return solutionName;
	}
	public void setSolutionName(String solutionName) {
		this.solutionName = solutionName;
	}
	public String getSolutionDescription() {
		return solutionDescription;
	}
	public void setSolutionDescription(String solutionDescription) {
		this.solutionDescription = solutionDescription;
	}
	public Date getSolutionCreateDate() {
		return solutionCreateDate;
	}
	public void setSolutionCreateDate(Date solutionCreateDate) {
		this.solutionCreateDate = solutionCreateDate;
	}
	public Date getSolutionUpdateDate() {
		return solutionUpdateDate;
	}
	public void setSolutionUpdateDate(Date solutionUpdateDate) {
		this.solutionUpdateDate = solutionUpdateDate;
	}
	public Integer getSelectedSolutionId() {
		return selectedSolutionId;
	}
	public void setSelectedSolutionId(Integer selectedSolutionId) {
		this.selectedSolutionId = selectedSolutionId;
	}
	public List<SelectItem> getSelectItemSolutionList() {
		return selectItemSolutionList;
	}
	public void setSelectItemSolutionList(List<SelectItem> selectItemSolutionList) {
		this.selectItemSolutionList = selectItemSolutionList;
	}
	
}
