package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
@Table(name="agent_profile")
public class AgentProfile extends GenericModel {
 
 	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer agent_id;
    public String agent_fullname;
    public String agent_username;
    public String agent_password;
    public Integer agent_max_call;
    public Integer agent_allow_outbound;
    public Date agent_create_date;
    public Date agent_update_date;

    @ManyToOne
    @JoinColumn(name="supervisor_id")
    public AgentProfile supervisor_id;
    
    @ManyToOne
    @JoinColumn(name="agent_level_id")
    public AgentLevel agent_level_id;
    
    @ManyToOne
    @JoinColumn(name="agent_skill_id")
    public AgentSkill agent_skill_id;
    
    @ManyToOne
    @JoinColumn(name="wkf_status_id")
    public WkfStatus wkf_status_id;
    
    @ManyToOne
    @JoinColumn(name="wkf_workplan_id")
    public WkfWorkplan wkf_workplan_id;

    @OneToMany(mappedBy="agent_profile_id")
    public List<KnwTopic> knwTopics;

    @OneToMany(mappedBy="agent_profile_id")
    public List<JobTicket> jobTickets;

    @OneToMany(mappedBy="agent_profile_id")
    public List<WkfRequest> wkfRequests;

 	public AgentProfile(Integer agent_id, 
 					String agent_fullname, 
 					String agent_username,
 					String agent_password,
 					Integer agent_max_call,
 					Integer agent_allow_outbound){
 		this.agent_id = agent_id;
 		this.agent_fullname = agent_fullname;
 		this.agent_username = agent_username;
 		this.agent_password = agent_password;
 		this.agent_max_call = agent_max_call;
 		this.agent_allow_outbound = agent_allow_outbound;
 		this.agent_update_date = new Date();
 	}
}