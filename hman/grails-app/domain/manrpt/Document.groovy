package manrpt

import java.util.Date;

class Document {

	String name
	String contentType
	byte[] file
	
	Date dateCreated
	Date lastUpdated
	
	static belongsTo = [person:Person]
	
    static constraints = {
		name(size:1..128, blank:false)
		contentType(size:1..128, blank:false)
		file(size:0..5000000, nullable:false)
    }
	
	def beforeInsert() {
		dateCreated = new Date()
	}
	
	def beforeUpdate() {
		lastUpdated = new Date()
	}
}
