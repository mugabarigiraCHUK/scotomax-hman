package manrpt

class Person {

	String firstName
	String familyName
	String middleName
	String jobTitle
	String position
	Boolean hasPermit
	Boolean hasMarried
	Boolean hasConscripted
	String phone
	String mobile
	String email
	String otherContact
	String description
	
	Date dateCreated
	Date lastUpdated

	Person leader
	Department department
	
	static hasOne = [photo:Photo]
	static hasMany = [addresses:Address, 
					  certificates:Certificate,
					  documents:Document,
					  attendances:Attendance]
	
    static constraints = {
		firstName(size:1..100, blank:false)
		familyName(size:1..100, nullable:true)
		middleName(size:1..100, nullable:true)
		jobTitle(size:1..200, nullable:true)
		position(size:1..200, blank:false)
		hasPermit(nullable:true)
		hasMarried(nullable:true)
		hasConscripted(nullable:true)
		phone(size:1..200, nullable:true)
		mobile(size:1..200, nullable:true)
		email(email:true, nullable:true)
		otherContact(size:1..1024, nullable:true)
		description(size:1..1024, nullable:true)
		leader(nullable:true)
		department(nullable:true)
		photo(nullable:true)
	}
	
	def beforeInsert() {
		dateCreated = new Date()
	}
	
	def beforeUpdate() {
		lastUpdated = new Date()
	}
}
