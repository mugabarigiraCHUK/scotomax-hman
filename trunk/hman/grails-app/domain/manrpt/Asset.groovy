package manrpt

class Asset {

	String name
	String snnumb
	String pnnumb
	Long prices
	Integer piece
	String vendor
	Date dateBrought
	String description
	
	Person owner
	
	Date dateCreated
	Date lastUpdated
	
    static constraints = {
    	name(size:1..255)
		snnumb(unique:true, size:1..255, nullable:true)
		pnnumb(size:1..255, nullable:true)
		prices(maxSize:11, nullable:true)
		piece(maxSize:6, nullable:false)
		vendor(size:1..1024, nullable:true)
		dateBrought(nullable:true)
		description(size:1..1024, nullable:true)
		owner(nullable:true)
	}
	
	def beforeInsert() {
		dateCreated = new Date()
	}
	
	def beforeUpdate() {
		lastUpdated = new Date()
	}
}
