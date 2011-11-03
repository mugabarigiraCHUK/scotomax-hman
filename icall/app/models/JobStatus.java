package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
@Table(name="job_status")
public class JobStatus extends Model {
 
 	@Id
    public Integer status_id;
    public String status_name;
    public String status_description;
    public Date status_update_date;
    
 	public JobStatus(Integer status_id, String status_name, String status_description){
 		this.status_id = status_id;
 		this.status_name = status_name;
 		this.status_description = status_description;
 		this.status_update_date = new Date();
 	}
}