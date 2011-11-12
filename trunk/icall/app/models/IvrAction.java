package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
@Table(name="ivr_action")
public class IvrAction extends GenericModel {
 
 	@Id
 	@GeneratedValue(strategy = GenerationType.AUTO)
    public Integer action_id;
    public String action_name;
    public String action_description;
    public String action_script;
    public String action_parameter;
    public Date action_create_date;
    public Date action_update_date;

    @ManyToOne
    @JoinColumn(name="ivr_command_id")
    public IvrCommand ivr_command_id;

    @OneToMany(mappedBy="ivr_action_id")
    public List<IvrDtmf> ivrDtmfs;
    
 	public IvrAction(Integer action_id, 
 					String action_name, 
 					String action_description,
 					String action_script,
 					String action_parameter){
 		this.action_id = action_id;
 		this.action_name = action_name;
 		this.action_description = action_description;
 		this.action_script = action_script;
 		this.action_parameter = action_parameter;
 		this.action_update_date = new Date();
 	}
}