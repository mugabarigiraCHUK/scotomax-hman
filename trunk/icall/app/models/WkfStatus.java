package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
@Table(name="wkf_status")
public class WkfStatus extends GenericModel {
 
 	@Id
 	@GeneratedValue(strategy = GenerationType.AUTO)
    public Integer status_id;
    public String status_name;
    public String status_description;
    public Date status_update_date;

    @OneToMany(mappedBy="wkf_status_id")
    public List<AgentProfile> agentProfiles;

    @OneToMany(mappedBy="wkf_status_id")
    public List<WkfRequest> wkfRequests;
    
 	public WkfStatus(Integer status_id, String status_name, String status_description){
 		this.status_id = status_id;
 		this.status_name = status_name;
 		this.status_description = status_description;
 		this.status_update_date = new Date();
 	}
}