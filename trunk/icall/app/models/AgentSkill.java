package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
@Table(name="agent_skill")
public class AgentSkill extends GenericModel {
 
 	@Id
 	@GeneratedValue(strategy = GenerationType.AUTO)
    public Integer skill_id;
    public String skill_name;
    public String skill_description;
    public Date skill_update_date;

    @OneToMany(mappedBy="agent_skill_id")
    public List<AgentProfile> agentProfiles;

    @OneToMany(mappedBy="agent_skill_id")
    public List<AgentSeat> agentSeats;
    
 	public AgentSkill(Integer skill_id, String skill_name, String skill_description){
 		this.skill_id = skill_id;
 		this.skill_name = skill_name;
 		this.skill_description = skill_description;
 		this.skill_update_date = new Date();
 	}
}