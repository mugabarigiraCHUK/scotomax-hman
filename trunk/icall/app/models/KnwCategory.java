package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
@Table(name="knw_category")
public class KnwCategory extends GenericModel {
 
 	@Id
 	@GeneratedValue(strategy = GenerationType.AUTO)
    public Integer category_id;
    public String category_name;
    public String category_description;
    public Date category_create_date;
    public Date category_update_date;

    @ManyToOne
    @JoinColumn(name="parent_category_id")
    public KnwCategory knw_category_id;

    @OneToMany(mappedBy="knw_category_id")
    public List<KnwTopic> knwTopics;
    
 	public KnwCategory(Integer category_id, String category_name, String category_description){
 		this.category_id = category_id;
 		this.category_name = category_name;
 		this.category_description = category_description;
 		this.category_update_date = new Date();
 	}
}