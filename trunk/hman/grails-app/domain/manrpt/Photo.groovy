package manrpt

class Photo {

	String name
	String contentType
	byte[] picture
	
	static belongsTo = [person:Person]
	
    static constraints = {
		name(size:1..128, blank:false)
		contentType(size:1..128, blank:false)
		picture(size:0..5000000, nullable:false)
		person(unique:true, nullable:false)
    }
}
