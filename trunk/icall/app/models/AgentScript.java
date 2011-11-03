package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
@Table(name="agent_script")
public class AgentScript extends Model {
 
 	@Id
    public Integer script_id;
    public String script_name;
    public String script_description;
    public Integer script_step;
    public String script_message;
    public Date script_create_date;
    public Date script_update_date;

    @ManyToOne
    public CrmBusiness crm_business_id;
    @ManyToOne
    public KnwTopic knw_topic_id;
    
 	public AgentScript(Integer script_id, 
 					String script_name, 
 					String script_description,
 					String script_step,
 					String script_message){
 		this.script_id = script_id;
 		this.script_name = script_name;
 		this.script_description = script_description;
 		this.script_step = script_step;
 		this.script_message = script_message;
 		this.script_update_date = new Date();
 	}
}