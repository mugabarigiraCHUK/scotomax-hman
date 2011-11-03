package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
@Table(name="ivr_callroute")
public class IvrCallroute extends Model {
 
 	@Id
    public Integer callroute_id;
    public String callroute_name;
    public String callroute_description;
    public String callroute_caller;
    public String callroute_called;
    public Date callroute_create_date;
    public Date callroute_update_date;

    @ManyToOne
    public IvrCallflow ivr_callflow_id;
    
 	public IvrCallroute(Integer callroute_id, 
 					String callroute_name, 
 					String callroute_description,
 					String callroute_calller,
 					String callroute_called){
 		this.callroute_id = callroute_id;
 		this.callroute_name = callroute_name;
 		this.callroute_description = callroute_description;
 		this.callroute_caller = callroute_caller;
 		this.callroute_called = callroute_called;
 		this.callroute_update_date = new Date();
 	}
}