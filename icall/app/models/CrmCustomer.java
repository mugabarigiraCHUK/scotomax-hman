package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
import play.data.validation.*;
 
@Entity
@Table(name="crm_customer")
public class CrmCustomer extends GenericModel {
 
 	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer customer_id;
    @Required
    public String customer_fullname;
    @Required
    public Integer customer_gender;
    public String customer_address;
    public Date customer_birthday;
    public String customer_phone;
    public String customer_email;
    @Required
    public Date customer_create_date;
    public Date customer_update_date;

    @Required
    @ManyToOne
    @JoinColumn(name="crm_business_id")
    public CrmBusiness crm_business_id;

    @Required
    @ManyToOne
    @JoinColumn(name="crm_status_id")
    public CrmStatus crm_status_id;

    @OneToMany(mappedBy="crm_customer_id")
    public List<JobTicket> jobTickets;

 	public CrmCustomer(Integer customer_id, 
 					String customer_fullname, 
 					Integer customer_gender,
 					String customer_address,
 					Date customer_birthday,
 					String customer_phone,
 					String customer_email){
 		this.customer_id = customer_id;
 		this.customer_fullname = customer_fullname;
 		this.customer_gender = customer_gender;
 		this.customer_address = customer_address;
 		this.customer_birthday = customer_birthday;
 		this.customer_phone = customer_phone;
 		this.customer_email = customer_email;
 		this.customer_update_date = new Date();
 	}
}