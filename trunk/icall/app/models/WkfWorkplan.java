package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
@Table(name="wkf_workplan")
public class WkfWorkplan extends GenericModel {
 
 	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer workplan_id;
    public String workplan_name;
    public String workplan_description;
    public Date workplan_start_date;
    public Date workplan_end_date;
    public Date workplan_start_time;
    public Date workplan_end_time;
    public Date workplan_create_date;
    public Date workplan_update_date;

    @ManyToOne
    @JoinColumn(name="wkf_calendar_id")
    public WkfCalendar wkf_calendar_id;

    @OneToMany(mappedBy="wkf_workplan_id")
    public List<AgentProfile> agentProfiles;
    
 	public WkfWorkplan(Integer workplan_id, 
 					String workplan_name, 
 					String workplan_description,
 					Date workplan_start_date,
 					Date workplan_end_date,
 					Date workplan_start_time,
 					Date workplan_end_time){
 		this.workplan_id = workplan_id;
 		this.workplan_name = workplan_name;
 		this.workplan_description = workplan_description;
 		this.workplan_start_date = workplan_start_date;
 		this.workplan_end_date = workplan_end_date;
 		this.workplan_start_time = workplan_start_time;
 		this.workplan_end_time = workplan_end_time;
 		this.workplan_update_date = new Date();
 	}
}