package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
@Table(name="wkf_request")
public class WkfRequest extends Model {
 
 	@Id
    public Integer request_id;
    public String request_name;
    public String request_description;
    public Date request_start_date;
    public Date request_end_date;
    public Date request_create_date;
    public Date request_update_date;

    @ManyToOne
    public AgentProfile agent_profile_id;
    @ManyToOne
    public AgentProfile agent_profile_supervisor_id;
    @ManyToOne
    public WkfStatus wkf_status_id;
    @ManyToOne
    public WkfRequesttype wkf_requesttype_id;
    
 	public WkfRequest(Integer request_id, 
 					String request_name, 
 					String request_description,
 					Date request_start_date,
 					Date request_end_date){
 		this.request_id = request_id;
 		this.request_name = request_name;
 		this.request_description = request_description;
 		this.request_start_date = request_start_date;
 		this.request_end_date = request_end_date;
 		this.request_update_date = new Date();
 	}
}