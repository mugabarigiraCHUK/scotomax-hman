package manrpt

class SimpleTagLib {

	def viewDate = { attrs, body ->
		if (attrs.date) {
			out << new java.text.SimpleDateFormat(attrs.format).format(attrs.date)
		} 
	}
}
