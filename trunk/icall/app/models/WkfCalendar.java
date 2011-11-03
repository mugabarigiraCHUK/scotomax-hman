package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
@Table(name="wkf_calendar")
public class WkfCalendar extends Model {
 
 	@Id
    public Integer calendar_id;
    public String calendar_name;
    public String calendar_description;
    public Boolean calendar_enable;
    public Date calendar_start_date;
    public Date calendar_end_date;
    public Date calendar_update_date;
    
 	public WkfCalendar(Integer calendar_id, 
 					String calendar_name, 
 					String calendar_description,
 					Boolean calendar_enable,
 					Date calendar_start_date,
 					Date calendar_end_date){
 		this.calendar_id = calendar_id;
 		this.calendar_name = calendar_name;
 		this.calendar_description = calendar_description;
 		this.calendar_enable = calendar_enable;
 		this.calendar_start_date = calendar_start_date;
 		this.calendar_end_date = calendar_end_date;
 		this.calendar_update_date = new Date();
 	}
}