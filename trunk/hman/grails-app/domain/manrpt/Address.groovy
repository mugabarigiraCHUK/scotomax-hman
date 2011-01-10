package manrpt

class Address {

	String address
	String city
	String postal
	
	static belongsTo = [person:Person]
	
    static constraints = {
		address(size:1..1024, blank:false)
		city(size:1..255, nullable:true)
		postal(size:1..128, nullable:true)
	}
}
