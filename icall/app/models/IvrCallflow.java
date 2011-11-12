package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
@Table(name="ivr_callflow")
public class IvrCallflow extends GenericModel {
 
 	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer callflow_id;
    public String callflow_name;
    public String callflow_description;
    public Integer callflow_timeout;
    public Integer callflow_next_id;
    public Integer callflow_voice_repeat_enable;
    public Date callflow_create_date;
    public Date callflow_update_date;

    @ManyToOne
    @JoinColumn(name="ivr_voiceprompt_id")
    public IvrVoiceprompt ivr_voiceprompt_id;

    @OneToMany(mappedBy="ivr_callflow_id")
    public List<IvrCallroute> ivrCallroutes;

    @OneToMany(mappedBy="ivr_callflow_id")
    public List<IvrDtmf> ivrDtmfs;

    @OneToMany(mappedBy="ivr_callflow_id")
    public List<IvrSchedule> ivrSchedules;
    
 	public IvrCallflow(Integer callflow_id, 
 					String callflow_name, 
 					String callflow_description,
 					Integer callflow_timeout,
 					Integer callflow_next_id,
 					Integer callflow_voice_repeat_enable){
 		this.callflow_id = callflow_id;
 		this.callflow_name = callflow_name;
 		this.callflow_description = callflow_description;
 		this.callflow_timeout = callflow_timeout;
 		this.callflow_next_id = callflow_next_id;
 		this.callflow_voice_repeat_enable = callflow_voice_repeat_enable;
 		this.callflow_update_date = new Date();
 	}
}