package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
@Table(name="acd_condition")
public class AcdCondition extends GenericModel {
 
 	@Id
 	@GeneratedValue(strategy = GenerationType.AUTO)
    public Integer condition_id;
    public String condition_name;
    public String condition_description;
    public Date condition_update_date;

    @OneToMany(mappedBy="acd_condition_id")
    public List<AcdRoute> acdRoutes;
    
 	public AcdCondition(Integer condition_id, String condition_name, String condition_description){
 		this.condition_id = condition_id;
 		this.condition_name = condition_name;
 		this.condition_description = condition_description;
 		this.condition_update_date = new Date();
 	}
}