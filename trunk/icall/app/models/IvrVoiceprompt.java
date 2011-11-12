package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
@Table(name="ivr_voiceprompt")
public class IvrVoiceprompt extends GenericModel {
 
 	@Id
 	@GeneratedValue(strategy = GenerationType.AUTO)
    public Integer voice_id;
    public String voice_name;
    public String voice_description;
    public String voice_filename;
    public String voice_format;
    public Date voice_create_date;
    public Date voice_update_date;

    @OneToMany(mappedBy="ivr_voiceprompt_id")
    public List<IvrCallflow> ivrCallflows;
    
 	public IvrVoiceprompt(Integer voice_id, 
 						String voice_name, 
 						String voice_description,
 						String voice_filename,
 						String voice_format){
 		this.voice_id = voice_id;
 		this.voice_name = voice_name;
 		this.voice_description = voice_description;
 		this.voice_filename = voice_filename;
 		this.voice_format = voice_format;
 		this.voice_update_date = new Date();
 	}
}