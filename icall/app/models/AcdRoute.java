package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
import play.data.validation.*;
 
@Entity
@Table(name="acd_route")
public class AcdRoute extends GenericModel {
 
 	@Id
 	@GeneratedValue(strategy = GenerationType.AUTO)
    public Integer route_id;
    @Required
    public String route_name;
    public String route_description;
    public String route_caller;
    public String route_called;
    @Required
    public Date route_create_date;
    public Date route_update_date;

    @Required
    @ManyToOne
    @JoinColumn(name="acd_condition_id")
    public AcdCondition acd_condition_id;
    
 	public AcdRoute(Integer route_id, 
 				String route_name, 
 				String route_description,
 				String route_caller,
 				String route_called){
 		this.route_id = route_id;
 		this.route_name = route_name;
 		this.route_description = route_description;
 		this.route_caller = route_caller;
 		this.route_called = route_called;
 		this.route_update_date = new Date();
 	}
}