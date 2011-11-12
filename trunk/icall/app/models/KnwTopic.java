package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
import play.data.validation.*;
 
@Entity
@Table(name="knw_topic")
public class KnwTopic extends GenericModel {
 
 	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer topic_id;
    @Required
    public String topic_name;
    public String topic_description;
    @Required
    public String topic_subject;
    @Required
    public Date topic_create_date;
    public Date topic_update_date;

    @Required
    @ManyToOne
    @JoinColumn(name="agent_profile_id")
    public AgentProfile agent_profile_id;

    @Required
    @ManyToOne
    @JoinColumn(name="knw_category_id")
    public KnwCategory knw_category_id;
    
    @Required
    @ManyToOne
    @JoinColumn(name="knw_status_id")
    public KnwStatus knw_status_id;

    @OneToMany(mappedBy="knw_topic_id")
    public List<JobTicket> jobTickets;

    @OneToMany(mappedBy="knw_topic_id")
    public List<KnwSolution> knwSolutions;
    
 	public KnwTopic(Integer topic_id, 
 				String topic_name, 
 				String topic_description, 
 				String topic_subject){
 		this.topic_id = topic_id;
 		this.topic_name = topic_name;
 		this.topic_description = topic_description;
 		this.topic_subject = topic_subject;
 		this.topic_update_date = new Date();
 	}
}