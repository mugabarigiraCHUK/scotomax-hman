package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
@Table(name="wkf_holiday")
public class WkfHoliday extends Model {
 
 	@Id
    public Integer holiday_id;
    public String holiday_name;
    public String holiday_description;
    public Date holiday_date;
    public Date holiday_update_date;

    @ManyToOne
    public WkfCalendar calendar_id;
    
 	public WkfHoliday(Integer holiday_id, 
 					String holiday_name, 
 					String holiday_description,
 					Date holiday_date){
 		this.holiday_id = holiday_id;
 		this.holiday_name = holiday_name;
 		this.holiday_description = holiday_description;
 		this.holiday_date = holiday_date;
 		this.holiday_update_date = new Date();
 	}
}