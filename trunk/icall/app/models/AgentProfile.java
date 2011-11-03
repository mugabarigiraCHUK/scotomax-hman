package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
@Table(name="agent_profile")
public class AgentProfile extends Model {
 
 	@Id
    public Integer agent_id;
    public String agent_fullname;
    public String agent_username;
    public String agent_password;
    public Integer agent_max_call;
    public String agent_allow_outbound;
    public Date agent_create_date;
    public Date agent_update_date;

    @ManyToOne
    public AgentProfile supervisor_id;
    @ManyToOne
    public AgentLevel agent_level_id;
    @ManyToOne
    public AgentSkill agent_skill_id;
    @ManyToOne
    public WkfStatus wkf_status_id;
    @ManyToOne
    public WkfWorkplan wkf_workplan_id;
    
 	public AgentProfile(Integer agent_id, 
 					String agent_fullname, 
 					String agent_username,
 					String agent_password,
 					Integer agent_max_call,
 					String agent_allow_outbound){
 		this.agent_id = agent_id;
 		this.agent_fullname = agent_fullname;
 		this.agent_username = agent_username;
 		this.agent_password = agent_password;
 		this.agent_max_call = agent_max_call;
 		this.agent_allow_outbound = agent_allow_outbound;
 		this.agent_update_date = new Date();
 	}
}