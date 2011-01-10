package manrpt

class Certificate {

	String name
	String degree
	String value
	String organization
	String description
	
	Date dateStart
	Date dateEnd
	
	static belongsTo = [person:Person]
	
    static constraints = {
		name(size:1..255, blank:false)
		degree(size:1..255, blank:false)
		value(size:1..255, nullable:true)
		organization(size:1..255, blank:false)
		description(size:1..1024, nullable:true)
		dateStart(nullable:false)
		dateEnd(nullable:true)
    }
}
