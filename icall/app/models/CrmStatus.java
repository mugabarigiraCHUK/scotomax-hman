package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
import play.data.validation.*;
 
@Entity
@Table(name="crm_status")
public class CrmStatus extends GenericModel {
 
 	@Id
 	@GeneratedValue(strategy = GenerationType.AUTO)
    public Integer status_id;
    @Required
    public String status_name;
    public String status_description;
    @Required
    public Date status_update_date;

    @OneToMany(mappedBy="crm_status_id")
    public List<CrmCustomer> crmCustomers;
    
 	public CrmStatus(Integer status_id, String status_name, String status_description){
 		this.status_id = status_id;
 		this.status_name = status_name;
 		this.status_description = status_description;
 		this.status_update_date = new Date();
 	}
}