package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
@Table(name="ivr_channel")
public class IvrChannel extends GenericModel {
 
 	@Id
 	@GeneratedValue(strategy = GenerationType.AUTO)
    public Integer channel_id;
    public String channel_name;
    public String channel_description;
    public Date channel_update_date;

    @OneToMany(mappedBy="ivr_channel_id")
    public List<IvrSchedule> ivrSchedules;
    
 	public IvrChannel(Integer channel_id, String channel_name, String channel_description){
 		this.channel_id = channel_id;
 		this.channel_name = channel_name;
 		this.channel_description = channel_description;
 		this.channel_update_date = new Date();
 	}
}