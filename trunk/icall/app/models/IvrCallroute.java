package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
import play.data.validation.*;

@Entity
@Table(name="ivr_callroute")
public class IvrCallroute extends GenericModel {
 
 	@Id
 	@GeneratedValue(strategy = GenerationType.AUTO)
    public Integer callroute_id;
    @Required
    public String callroute_name;
    public String callroute_description;
    public String callroute_caller;
    public String callroute_called;
    @Required
    public Date callroute_create_date;
    public Date callroute_update_date;

    @Required
    @ManyToOne
    @JoinColumn(name="ivr_callflow_id")
    public IvrCallflow ivr_callflow_id;
    
 	public IvrCallroute(Integer callroute_id, 
 					String callroute_name, 
 					String callroute_description,
 					String callroute_caller,
 					String callroute_called){
 		this.callroute_id = callroute_id;
 		this.callroute_name = callroute_name;
 		this.callroute_description = callroute_description;
 		this.callroute_caller = callroute_caller;
 		this.callroute_called = callroute_called;
 		this.callroute_update_date = new Date();
 	}
}