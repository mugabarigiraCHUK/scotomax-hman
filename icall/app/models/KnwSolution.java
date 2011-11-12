package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
import play.data.validation.*;
 
@Entity
@Table(name="knw_solution")
public class KnwSolution extends GenericModel {
 
 	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer solution_id;
    @Required
    public String solution_name;
    public String solution_description;
    @Required
    public Date solution_create_date;
    public Date solution_update_date;

    @Required
    @ManyToOne
    @JoinColumn(name="knw_topic_id")
    public KnwTopic knw_topic_id;

    @Required
    @ManyToOne
    @JoinColumn(name="agent_profile_id")
    public AgentProfile agent_profile_id;

    @ManyToOne
    @JoinColumn(name="agent_profile_supervisor_id")
    public AgentProfile agent_profile_supervisor_id;
    
    @Required
    @ManyToOne
    @JoinColumn(name="knw_status_id")
    public KnwStatus knw_status_id;

    @OneToMany(mappedBy="knw_solution_id")
    public List<JobTicket> jobTickets;
    
 	public KnwSolution(Integer solution_id, String solution_name, String solution_description){
 		this.solution_id = solution_id;
 		this.solution_name = solution_name;
 		this.solution_description = solution_description;
 		this.solution_update_date = new Date();
 	}
}