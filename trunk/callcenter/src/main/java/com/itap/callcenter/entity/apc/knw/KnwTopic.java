package com.itap.callcenter.entity.apc.knw;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import com.itap.callcenter.entity.DomainObject;

/**
*
* @author phamon
*/
@Entity
@Table(name = "knw_topic")
@XmlRootElement
public class KnwTopic implements Serializable, DomainObject {

private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "topic_id", length = 11, nullable = false)
    @NotNull
    private Integer topicId;
    
    @Column(name = "agent_id", length = 11, nullable = false)
    @NotNull
    private Integer agentId;

    @Column(name = "category_id", length = 11, nullable = false)
    @NotNull
    private Integer categoryId;
    
    @Column(name = "status_id", length = 11, nullable = false)
    @NotNull
    private Integer statusId;
    
    @Column(name = "topic_name", length = 50, nullable = false)
    @NotNull
    private String topicName;
    
    @Column(name = "topic_description", length = 100)
    private String topicDescription;
    
    @Column(name = "topic_subject", length = 100, nullable = false)
    @NotNull
    private String topicSubject;
    
    @Column(name = "topic_create_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date topicCreateDate;
    
    @Column(name = "topic_update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date topicUpdateDate;
    
    public KnwTopic () {
    }

	public Integer getTopicId() {
		return topicId;
	}

	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}

	public Integer getAgentId() {
		return agentId;
	}

	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
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
    
    
	
}
