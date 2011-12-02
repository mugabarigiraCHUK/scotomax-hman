package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
import play.data.validation.*;
 
@Entity
@Table(name="knw_status")
public class KnwStatus extends GenericModel {
 
 	@Id
// 	@GeneratedValue(strategy = GenerationType.AUTO)
    public Integer status_id;
    
    @Required
    public String status_name;
    
    public String status_description;
    
    @Required
    public Date status_update_date;

    @OneToMany(mappedBy="knw_status_id")
    public List<KnwTopic> knwTopics;

    @OneToMany(mappedBy="knw_status_id")
    public List<KnwSolution> knwSolutions;
    
 	public KnwStatus(String status_name, String status_description){
 		java.util.Random randomGenerator = new java.util.Random();
    	this.status_id = randomGenerator.nextInt(1000000000);
 		this.status_name = status_name;
 		this.status_description = status_description;
 		this.status_update_date = new Date();
 	}
}