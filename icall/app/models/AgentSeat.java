package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
@Table(name="agent_seat")
public class AgentSeat extends GenericModel {
 
 	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer seat_id;
    public String seat_name;
    public String seat_description;
    public String seat_called;
    public Date seat_start_period;
    public Date seat_end_period;
    public Integer seat_max_call;
    public Integer seat_allow_outbound;
    public Date seat_create_date;
    public Date seat_update_date;

    @ManyToOne
    @JoinColumn(name="agent_level_id")
    public AgentLevel agent_level_id;

    @ManyToOne
    @JoinColumn(name="agent_skill_id")
    public AgentSkill agent_skill_id;
    
    @ManyToOne
    @JoinColumn(name="wkf_status_id")
    public WkfStatus wkf_status_id;

    @OneToMany(mappedBy="agent_seat_id")
    public List<JobTicket> jobTickets;

 	public AgentSeat(Integer seat_id, 
 					String seat_name, 
 					String seat_description,
 					String seat_called,
 					Date seat_start_period,
 					Date seat_end_period,
 					Integer seat_max_call,
 					Integer seat_allow_outbound){
 		this.seat_id = seat_id;
 		this.seat_name = seat_name;
 		this.seat_description = seat_description;
 		this.seat_called = seat_called;
 		this.seat_start_period = seat_start_period;
 		this.seat_end_period = seat_end_period;
 		this.seat_max_call = seat_max_call;
 		this.seat_allow_outbound = seat_allow_outbound;
 		this.seat_update_date = new Date();
 	}
}