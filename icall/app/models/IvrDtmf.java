package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
import play.data.validation.*;
 
@Entity
@Table(name="ivr_dtmf")
public class IvrDtmf extends GenericModel {
 
 	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer dtmf_id;
    @Required
    public String dtmf_name;
    public String dtmf_description;
    @Required
    public String dtmf_digit;
    @Required
    public Date dtmf_create_date;
    public Date dtmf_update_date;

    @Required
    @ManyToOne
    @JoinColumn(name="ivr_callflow_id")
    public IvrCallflow ivr_callflow_id;

    @Required
    @ManyToOne
    @JoinColumn(name="ivr_action_id")
    public IvrAction ivr_action_id;
    
 	public IvrDtmf(Integer dtmf_id, 
 					String dtmf_name, 
 					String dtmf_description,
 					String dtmf_digit){
 		this.dtmf_id = dtmf_id;
 		this.dtmf_name = dtmf_name;
 		this.dtmf_description = dtmf_description;
 		this.dtmf_digit = dtmf_digit;
 		this.dtmf_update_date = new Date();
 	}
}