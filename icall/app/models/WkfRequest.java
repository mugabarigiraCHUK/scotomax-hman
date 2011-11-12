package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
@Table(name="wkf_request")
public class WkfRequest extends GenericModel {
 
 	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer request_id;
    public String request_name;
    public String request_description;
    public Date request_start_time;
    public Date request_end_time;
    public Date request_create_date;
    public Date request_update_date;

    @ManyToOne
    @JoinColumn(name="agent_profile_id")
    public AgentProfile agent_profile_id;
    
    @ManyToOne
    @JoinColumn(name="agent_profile_supervisor_id")
    public AgentProfile agent_profile_supervisor_id;
    
    @ManyToOne
    @JoinColumn(name="wkf_status_id")
    public WkfStatus wkf_status_id;
    
    @ManyToOne
    @JoinColumn(name="wkf_requesttype_id")
    public WkfRequesttype wkf_requesttype_id;
    
 	public WkfRequest(Integer request_id, 
 					String request_name, 
 					String request_description,
 					Date request_start_time,
 					Date request_end_time){
 		this.request_id = request_id;
 		this.request_name = request_name;
 		this.request_description = request_description;
 		this.request_start_time = request_start_time;
 		this.request_end_time = request_end_time;
 		this.request_update_date = new Date();
 	}
}