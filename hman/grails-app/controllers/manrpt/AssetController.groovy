package manrpt

import java.text.SimpleDateFormat;

class AssetController {

    def index = { redirect(action:"view", params:params) }
	
	def view = {
		log.debug "Entering Asset data viewing..."	
		try {
			if (params.search) {
				def a = Asset.createCriteria()
				def result = a {
					or {
						like("name", "%"+params.search+"%")
						like("snnumb", "%"+params.search+"%")
						like("pnnumb", "%"+params.search+"%")
						like("vendor", "%"+params.search+"%")
					}
					order("lastUpdated", "desc")
				}
				return [assets:result, owners:Person.list(), search:params.search]
			} else {
				def a = Asset.createCriteria()
				def result =  a {
					order("lastUpdated", "desc")
				}
				return [assets:result, owners:Person.list(), search:params.search]
			}
		} catch (e) {
			flash.message = e.message
			log.error "Exception: " + e.message, e
		}
	}
	
	def save = {
		log.debug "Entering Asset data saving..."
		try {
			def a = new Asset()
			a.name = params.name
			a.snnumb = params.snnumb
			a.pnnumb = params.pnnumb
			a.prices = params.prices?new Long(params.prices):0
			a.piece = params.piece?Integer.parseInt(params.piece):0
			a.vendor = params.vendor
			a.dateBrought = params.datebrought?(new SimpleDateFormat("yyyy-MM-dd").parse(params.datebrought)):null
			a.description = params.desc
			if (a.validate()) {
				a.save()
				flash.message = "Create new asset data successfully."
			} else {
				def msg = ""
				a.errors.allErrors.each {
					if (msg) msg += ", "+it
					else msg = it
				}
				flash.message = msg
			}
		} catch (e) {
			flash.message = e.message
			log.error "Exception: " + e.message, e
		}
		redirect(action:"view", params:params)
	}
	
	def edit = {
		log.debug "Entering Asset data editing..."
		try {
			def a = Asset.get(params.asid)
			if (a) {
				render(view:"view", model:[asset:a, search:params.search])
			} else {
				flash.message = "System could not found the data for editing."
				render(view:"view", model:[search:params.search])
			}
		} catch (e) {
			flash.message = e.message
			log.error "Exception: " + e.message, e
		}
	}
	
	def update = {
		log.debug "Entering Asset data updating..."
		try {
			def a = Asset.get(params.asid)
			if (!a) {
				flash.message = "System could not found the data for updating."
			} else {
				a.name = params.name
				a.snnumb = params.snnumb
				a.pnnumb = params.pnnumb
				a.prices = params.prices?new Long(params.prices):0
				a.piece = params.piece?Integer.parseInt(params.piece):0
				a.vendor = params.vendor
				a.dateBrought = params.datebrought?(new SimpleDateFormat("yyyy-MM-dd").parse(params.datebrought)):null
				a.description = params.desc
				if (a.validate()) {
					a.save()
					flash.message = "Create new asset data successfully."
				} else {
					def msg = ""
					a.errors.allErrors.each {
						if (msg) msg += ", "+it
						else msg = it
					}
					flash.message = msg
				}
			}
		} catch (e) {
			flash.message = e.message
			log.error "Exception: " + e.message, e
		}
		redirect(action:"view", params:params)
	}
	
	def delete = {
		log.debug "Entering Asset data deleting..."
		try {
			def a = Asset.get(params.asid)
			if (!a) {
				flash.message = "System could not found the data for updating."
			} else {
				a.delete()
				flash.message = "The asset data is deleted successfully."
			}
		} catch (e) {
			flash.message = e.message
			log.error "Exception: " + e.message, e
		}
		redirect(action:"view", params:params)
	}
	
	def assignowner = {
		try {
			def a = Asset.get(params.asid)
			if (!a) {
				flash.message = "System could not found the data for updating."
			} else {
				if ( params.pid != "-1" ) {
					def p = Person.get(params.pid)
					if (p) {
						a.owner = p
						a.save()
						flash.message = "The asset data is assigned successfully."
					} else {
						flash.message = "System could not found person data to assign owner"
					}
				} else {
					a.owner = null
					a.save()
					flash.message = "The asset data is assigned successfully."
				}
			}
		} catch (e) {
			flash.message = e.message
			log.error "Exception: " + e.message, e
		}
		redirect(action:"view", params:params)
	}
	
}
