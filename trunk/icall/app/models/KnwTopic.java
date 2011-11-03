package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
@Table(name="knw_topic")
public class KnwTopic extends Model {
 
 	@Id
    public Integer topic_id;
    public String topic_name;
    public String topic_description;
    public String topic_subject;
    public Date topic_create_date;
    public Date topic_update_date;

    @ManyToOne
    public AgentProfile agent_profile_id;
    @ManyToOne
    public KnwCategory knw_category_id;
    @ManyToOne
    public KnwStatus knw_status_id;
    
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