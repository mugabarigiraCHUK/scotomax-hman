package manrpt

class Department {

	String name
	String description
	Date dateCreated
	Date lastUpdated
	
	static hasMany = [persons:Person]
	
    static constraints = {
		name(size:1..200, blank:false)
		description(size:1..1024, nullable:true)
    }
	
	def beforeInsert() {
		dateCreated = new Date()
	}
	
	def beforeUpdate() {
		lastUpdated = new Date()
	}
}
