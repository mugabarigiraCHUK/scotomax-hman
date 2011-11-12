package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
import play.data.validation.*;
 
@Entity
@Table(name="ivr_pabx")
public class IvrPabx extends GenericModel {
 
 	@Id
 	@GeneratedValue(strategy = GenerationType.AUTO)
    public Integer pabx_id;
    @Required
    public String pabx_name;
    public String pabx_description;
    @Required
    public Date pabx_update_date;

    @Required
    @ManyToOne
    @JoinColumn(name="ivr_protocol_id")
    public IvrProtocol ivr_protocol_id;
    
 	public IvrPabx(Integer pabx_id, 
 					String pabx_name, 
 					String pabx_description){
 		this.pabx_id = pabx_id;
 		this.pabx_name = pabx_name;
 		this.pabx_description = pabx_description;
 		this.pabx_update_date = new Date();
 	}
}