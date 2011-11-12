package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
@Table(name="knw_status")
public class KnwStatus extends GenericModel {
 
 	@Id
 	@GeneratedValue(strategy = GenerationType.AUTO)
    public Integer status_id;
    public String status_name;
    public String status_description;
    public Date status_update_date;

    @OneToMany(mappedBy="knw_status_id")
    public List<KnwTopic> knwTopics;

    @OneToMany(mappedBy="knw_status_id")
    public List<KnwSolution> knwSolutions;
    
 	public KnwStatus(Integer status_id, String status_name, String status_description){
 		this.status_id = status_id;
 		this.status_name = status_name;
 		this.status_description = status_description;
 		this.status_update_date = new Date();
 	}
}