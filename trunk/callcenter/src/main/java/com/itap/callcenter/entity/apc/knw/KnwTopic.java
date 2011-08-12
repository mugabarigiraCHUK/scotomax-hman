package com.itap.callcenter.entity.apc.knw;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.itap.callcenter.entity.DomainObject;
import com.itap.callcenter.entity.apc.agent.AgentProfile;

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
    
    @ManyToOne
    @JoinColumn(name = "agent_id", nullable = false)
    @NotNull
    private AgentProfile agentProfile;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    @NotNull
    private KnwCategory category;
    
    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    @NotNull
    private KnwStatus status;
    
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
	
	

	public AgentProfile getAgentProfile() {
		return agentProfile;
	}


	public void setAgentProfile(AgentProfile agentProfile) {
		this.agentProfile = agentProfile;
	}


	public KnwCategory getCategory() {
		return category;
	}


	public void setCategory(KnwCategory category) {
		this.category = category;
	}


	public KnwStatus getStatus() {
		return status;
	}


	public void setStatus(KnwStatus status) {
		this.status = status;
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
    
	@Override
    public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("topicId", topicId)
				.append("topicName", topicName)
				.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) { return false; }
        if (o == this) { return true; }
        if (o.getClass() != getClass()) {
            return false;
        }
        KnwTopic other = (KnwTopic) o;
        return new EqualsBuilder()
                 .append(topicId, other.topicId)
                 .isEquals();
    }
    
    @Override
    public int hashCode() {
        return new HashCodeBuilder()
         .append(this.topicId)
         .toHashCode();
    }
	
}
