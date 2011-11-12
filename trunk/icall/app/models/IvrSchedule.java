package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
@Table(name="ivr_schedule")
public class IvrSchedule extends GenericModel {
 
 	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer schedule_id;
    public String schedule_name;
    public String schedule_description;
    public String schedule_caller;
    public String schedule_called;
    public Date schedule_activate_time;
    public Integer schedule_retry_time;
    public Date schedule_create_date;
    public Date schedule_update_date;

    @ManyToOne
    @JoinColumn(name="ivr_channel_id")
    public IvrChannel ivr_channel_id;
    
    @ManyToOne
    @JoinColumn(name="ivr_callflow_id")
    public IvrCallflow ivr_callflow_id;
    
 	public IvrSchedule(Integer schedule_id, 
 					String schedule_name, 
 					String schedule_description,
 					String schedule_caller,
 					String schedule_called,
 					Date schedule_activate_time,
 					Integer schedule_retry_time){
 		this.schedule_id = schedule_id;
 		this.schedule_name = schedule_name;
 		this.schedule_description = schedule_description;
 		this.schedule_caller = schedule_caller;
 		this.schedule_called = schedule_called;
 		this.schedule_activate_time = schedule_activate_time;
 		this.schedule_retry_time = schedule_retry_time;
 		this.schedule_update_date = new Date();
 	}
}