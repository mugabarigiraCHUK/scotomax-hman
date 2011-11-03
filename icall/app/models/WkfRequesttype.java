package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
@Table(name="wkf_requesttype")
public class WkfRequesttype extends Model {
 
 	@Id
    public Integer requesttype_id;
    public String requesttype_name;
    public String requesttype_description;
    public Date requesttype_update_date;
    
 	public WkfRequesttype(Integer requesttype_id, String requesttype_name, String requesttype_description){
 		this.requesttype_id = requesttype_id;
 		this.requesttype_name = requesttype_name;
 		this.requesttype_description = requesttype_description;
 		this.requesttype_update_date = new Date();
 	}
}