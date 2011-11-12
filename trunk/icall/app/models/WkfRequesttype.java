package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
import play.data.validation.*;
 
@Entity
@Table(name="wkf_requesttype")
public class WkfRequesttype extends GenericModel {
 
 	@Id
 	@GeneratedValue(strategy = GenerationType.AUTO)
    public Integer requesttype_id;
    @Required
    public String requesttype_name;
    public String requesttype_description;
    @Required
    public Date requesttype_update_date;

    @OneToMany(mappedBy="wkf_requesttype_id")
    public List<WkfRequest> wkfRequests;
    
 	public WkfRequesttype(Integer requesttype_id, String requesttype_name, String requesttype_description){
 		this.requesttype_id = requesttype_id;
 		this.requesttype_name = requesttype_name;
 		this.requesttype_description = requesttype_description;
 		this.requesttype_update_date = new Date();
 	}
}