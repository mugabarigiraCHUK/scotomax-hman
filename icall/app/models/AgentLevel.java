package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
@Table(name="agent_level")
public class AgentLevel extends GenericModel {
 
 	@Id
 	@GeneratedValue(strategy = GenerationType.AUTO)
    public Integer level_id;
    public String level_name;
    public String level_description;
    public Date level_update_date;

    @OneToMany(mappedBy="agent_level_id")
    public List<AgentProfile> agentProfile;

    @OneToMany(mappedBy="agent_level_id")
    public List<AgentSeat> agentSeats;
    
 	public AgentLevel(Integer level_id, 
 					String level_name, 
 					String level_description){
 		this.level_id = level_id;
 		this.level_name = level_name;
 		this.level_description = level_description;
 		this.level_update_date = new Date();
 	}
}