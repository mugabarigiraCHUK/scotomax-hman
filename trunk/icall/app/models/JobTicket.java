package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
@Table(name="job_ticket")
public class JobTicket extends GenericModel {
 
 	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer job_id;
    public Integer priority;
    public String job_name;
    public String job_description;
    public String job_voice_record_file;
    public Integer job_alert_enable;
    public Date job_create_date;
    public Date job_update_date;
    public Date job_close_date;

    @ManyToOne
    @JoinColumn(name="crm_customer_id")
    public CrmCustomer crm_customer_id;

    @ManyToOne
    @JoinColumn(name="agent_profile_id")
    public AgentProfile agent_profile_id;
    
    @ManyToOne
    @JoinColumn(name="agent_seat_id")
    public AgentSeat agent_seat_id;
    
    @ManyToOne
    @JoinColumn(name="knw_topic_id")
    public KnwTopic knw_topic_id;
    
    @ManyToOne
    @JoinColumn(name="knw_solution_id")
    public KnwSolution knw_solution_id;
    
    @ManyToOne
    @JoinColumn(name="job_status_id")
    public JobStatus job_status_id;
    
 	public JobTicket(Integer job_id, 
 					Integer priority,
 					String job_name, 
 					String job_description,
 					String job_voice_record_file,
 					Integer job_alert_enable){
 		this.job_id = job_id;
 		this.priority = priority;
 		this.job_name = job_name;
 		this.job_description = job_description;
 		this.job_voice_record_file = job_voice_record_file;
 		this.job_alert_enable = job_alert_enable;
 		this.job_update_date = new Date();
 	}
}