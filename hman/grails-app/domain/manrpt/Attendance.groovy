package manrpt

import java.util.Date;

class Attendance {

	String year
	Integer sickCredit
	Integer annualCredit
	Integer extraCredit
	Integer sickUsed
	Integer annualUsed
	Integer extraUsed
	
	Date dateCreated
	Date lastUpdated
	
	static belongsTo = [person:Person]
	
    static constraints = {
    	year(size:1..10, blank:false)
	}
	
	def beforeInsert() {
		dateCreated = new Date()
	}
	
	def beforeUpdate() {
		lastUpdated = new Date()
	}
}
