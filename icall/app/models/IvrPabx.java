package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
@Table(name="ivr_pabx")
public class IvrPabx extends Model {
 
 	@Id
    public Integer pabx_id;
    public String pabx_name;
    public String pabx_description;
    public Date pabx_update_date;

    @ManyToOne
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