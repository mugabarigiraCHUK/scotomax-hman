package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
import play.data.validation.*;
 
@Entity
@Table(name="wkf_calendar")
public class WkfCalendar extends GenericModel {
 
 	@Id
 	@GeneratedValue(strategy = GenerationType.AUTO)
    public Integer calendar_id;
    @Required
    public String calendar_name;
    public String calendar_description;
    @Required
    public Integer calendar_enable;
    @Required
    public Date calendar_start_date;
    @Required
    public Date calendar_end_date;
    public Date calendar_update_date;

    @OneToMany(mappedBy="calendar_id")
    public List<WkfHoliday> wkfHolidays;

    @OneToMany(mappedBy="wkf_calendar_id")
    public List<WkfWorkplan> wkfWorkplans;
    
 	public WkfCalendar(Integer calendar_id, 
 					String calendar_name, 
 					String calendar_description,
 					Integer calendar_enable,
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