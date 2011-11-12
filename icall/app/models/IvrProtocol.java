package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
@Table(name="ivr_protocol")
public class IvrProtocol extends GenericModel {
 
 	@Id
 	@GeneratedValue(strategy = GenerationType.AUTO)
    public Integer protocol_id;
    public String protocol_name;
    public String protocol_description;
    public Date protocol_update_date;

    @OneToMany(mappedBy="ivr_protocol_id")
    public List<IvrPabx> ivrPabxs;
    
 	public IvrProtocol(Integer protocol_id, String protocol_name, String protocol_description){
 		this.protocol_id = protocol_id;
 		this.protocol_name = protocol_name;
 		this.protocol_description = protocol_description;
 		this.protocol_update_date = new Date();
 	}
}