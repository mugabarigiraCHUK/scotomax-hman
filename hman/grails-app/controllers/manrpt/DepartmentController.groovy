package manrpt

class DepartmentController {

    def index = { redirect(action:"view",params:params) }
	
	def view = {
		log.debug "Entering Department management process..."
		
		try {
			if (params.search) {
				def d = Department.createCriteria();
				def result = d {
					like("name", "%"+params.search+"%")
					order("lastUpdated", "desc")
				}
				return [depts:result, search:params.search]
			} else {
				def d = Department.createCriteria();
				def result = d {
					order("lastUpdated", "desc")
				}
				return [depts:result, search:params.search]
			}
		} catch (e) {
			flash.message = e.message
			log.error "Exception: "+e.message, e
			return [search:params.search]
		}
	}
	
	def save = {
		log.debug "Entering Department saving..."
		try {
			def d = new Department()
			d.name = params.name
			d.description = params.desc
			if (d.validate()) {
				d.save()
				flash.message = "Create new department successfully."
			} else {
				def msg = ""
				d.errors.allErrors.each {
					if (msg) msg += ", "+it
					else msg = it
				}
				flash.message = msg
			}
		} catch (e) {
			flash.message = e.message
			log.error "Exception: "+e.message, e
		}
		redirect(action:"view", params:params)
	}
	
	def edit = {
		log.debug "Entering Department editing..."
		try {
			def d = Department.get(params.deptid)
			if (d) {
				render(view:"view", model:[dept:d, search:params.search])
			} else {
				flash.message = "System could not found the data for editing."
				render(view:"view", model:[search:params.search])
			}
		} catch (e) {
			flash.message = e.message
			log.error "Exception: "+e.message, e
			render(view:"view", model:[search:params.search])
		}
	}
	
	def update = {
		log.debug "Entering Department updating..."
		try {
			def d = Department.get(params.deptid)
			if (d) {
				d.name = params.name
				d.description = params.desc
				if (d.validate()) {
					d.save()
					flash.message = "The department data updated successfully."
				} else {
					def msg = ""
					d.errors.allErrors.each {
						if (msg) msg += ", "+it
						else msg = it
					}
					flash.message = msg
				}
			} else {
				flash.message = "System could not found the data for updating."
			}
		} catch (e) {
			flash.message = e.message
			log.error "Exception: "+e.message, e
		}
		redirect(action:"view", params:params)
	}
	
	def delete = {
		log.debug "Entering Department deleting..."
		try {
			def d = Department.get(params.deptid)
			if (d) {
				d.delete()
				flash.message = "The data deleted successfully."
			} else {
				flash.message = "System could not found the data for deleting."
			}
		} catch (e) {
			flash.message = e.message
			log.error "Exception: "+e.message, e
		}
		redirect(action:"view", params:params)
	}
	
	def organize = {
		log.debug "Entering Department organisation process..."
		try {
			
		} catch (e) {
			flash.message = e.message
			log.error "Exception: "+e.message, e
		}
	}
}
