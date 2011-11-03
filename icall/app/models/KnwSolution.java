package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
@Table(name="knw_solution")
public class KnwSolution extends Model {
 
 	@Id
    public Integer solution_id;
    public String solution_name;
    public String solution_description;
    public Date solution_create_date;
    public Date solution_update_date;

    @ManyToOne
    public KnwTopic knw_topic_id;
    @ManyToOne
    public AgentProfile agent_profile_id;
    @ManyToOne
    public AgentProfile agent_profile_supervisor_id;
    @ManyToOne
    public KnwStatus knw_status_id;
    
 	public KnwSolution(Integer solution_id, String solution_name, String solution_description){
 		this.solution_id = solution_id;
 		this.solution_name = solution_name;
 		this.solution_description = solution_description;
 		this.solution_update_date = new Date();
 	}
}