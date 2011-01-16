package manrpt

class Account {

	String username
	String password
	String fullname
	Boolean isadmin
	Boolean isasset
	Date lastAccessed
	
	Date dateCreated
	Date lastUpdated
	
    static constraints = {
		username(size:1..32, blank:false, unique:true)
		password(size:6..32, blank:false)
		fullname(size:1..255, nullable:true)
		isadmin(nullable:false)
		isasset(nullable:false)
		lastAccessed(nullable:true)
    }
	
	def beforeInsert() {
		dateCreated = new Date()
	}
	
	def beforeUpdate() {
		lastUpdated = new Date()
	}
}
