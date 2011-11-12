package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
import play.data.validation.*;
 
@Entity
@Table(name="agent_script")
public class AgentScript extends GenericModel {
 
 	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer script_id;
    @Required
    public String script_name;
    public String script_description;
    @Required 
    public Integer script_step;
    public String script_message;
    @Required
    public Date script_create_date;
    public Date script_update_date;

    @Required
    @ManyToOne
    @JoinColumn(name="crm_business_id")
    public CrmBusiness crm_business_id;
    
    @Required
    @ManyToOne
    @JoinColumn(name="knw_topic_id")
    public KnwTopic knw_topic_id;
    
 	public AgentScript(Integer script_id, 
 					String script_name, 
 					String script_description,
 					Integer script_step,
 					String script_message){
 		this.script_id = script_id;
 		this.script_name = script_name;
 		this.script_description = script_description;
 		this.script_step = script_step;
 		this.script_message = script_message;
 		this.script_update_date = new Date();
 	}
}