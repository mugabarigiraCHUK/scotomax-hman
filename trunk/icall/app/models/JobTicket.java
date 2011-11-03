package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
@Table(name="job_ticket")
public class JobTicket extends Model {
 
 	@Id
    public Integer job_id;
    public Integer priority;
    public String job_name;
    public String job_description;
    public String job_voice_record_file;
    public Boolean job_alert_enable;
    public Date job_create_date;
    public Date job_update_date;
    public Date job_close_date;

    @ManyToOne
    public CrmCustomer crm_customer_id;
    @ManyToOne
    public AgentProfile agent_profile_id;
    @ManyToOne
    public AgentSeat agent_seat_id;
    @ManyToOne
    public KnwTopic knw_topic_id;
    @ManyToOne
    public KnwSolution knw_solution_id;
    @ManyToOne
    public JobStatus job_status_id;
    
 	public JobTicket(Integer job_id, 
 					Integer priority,
 					String job_name, 
 					String job_description,
 					String job_voice_record_file,
 					Boolean job_alert_enable){
 		this.job_id = job_id;
 		this.priority = priority;
 		this.job_name = job_name;
 		this.job_description = job_description;
 		this.job_voice_record_file = job_voice_record_file;
 		this.job_alert_enable = job_alert_enable;
 		this.job_update_date = new Date();
 	}
}