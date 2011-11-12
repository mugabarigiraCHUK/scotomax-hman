package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
@Table(name="crm_business")
public class CrmBusiness extends GenericModel {
 
 	@Id
 	@GeneratedValue(strategy = GenerationType.AUTO)
    public Integer business_id;
    public String business_name;
    public String business_description;
    public Date business_update_date;

    @OneToMany(mappedBy="crm_business_id")
    public List<AgentScript> agentScripts;

    @OneToMany(mappedBy="crm_business_id")
    public List<CrmCustomer> crmCustomers;
    
 	public CrmBusiness(Integer business_id, String business_name, String business_description){
 		this.business_id = business_id;
 		this.business_name = business_name;
 		this.business_description = business_description;
 		this.business_update_date = new Date();
 	}
}