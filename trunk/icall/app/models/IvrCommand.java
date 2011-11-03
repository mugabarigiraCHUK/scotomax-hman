package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
@Table(name="ivr_command")
public class IvrCommand extends Model {
 
 	@Id
    public Integer command_id;
    public String command_name;
    public String command_description;
    public Date command_create_date;
    public Date command_update_date;
    
 	public IvrCommand(Integer command_id, String command_name, String command_description){
 		this.command_id = command_id;
 		this.command_name = command_name;
 		this.command_description = command_description;
 		this.command_update_date = new Date();
 	}
}