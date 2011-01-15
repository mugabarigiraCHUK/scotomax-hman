package manrpt

class AccountController {

    def index = { redirect(action:"view", params:params) }
	
	def view = {
		log.debug "Entering view Account data list process..."
		
		try {
			
			if (params.search) {
				def c = Account.createCriteria()
				def result = c {
					or {
						like("username", "%"+params.search+"%")
						like("fullname", "%"+params.search+"%")
					}
					order("lastAccessed", "desc")
				}
				return [accounts:result, search:params.search]
			} else {
				def c = Account.createCriteria()
				def result = c {
					order("lastAccessed", "desc")
				}
				return [accounts:result, search:params.search]
			}
		} catch (e) {
			flash.message = e.message
			log.error "Exception: "+e.message, e
			return [search:params.search]
		}
	}
	
	def save = {
		log.debug "Entering save Account process..."
		
		try {
		
			if ( !params.username ) {
				flash.message = "Enter username please!"
			} else if ( !params.password ) {
				flash.message = "Enter password please!"
			} else if ( params.password != params.confirm ) {
				flash.message = "Password is not match!"
			} else {
				def a = new Account()
				a.username = params.username
				a.password = params.password.encodeAsMD5()
				a.fullname = params.fullname
				a.isadmin = params.isadmin?true:false
			
				if (a.validate()) {
					a.save()
					flash.message = "Data is saved successfully."
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
			log.error "Exception: "+e.message, e
		}
		redirect(action:"view", params:params)
	}
	
	def update = {
		log.debug "Entering save Account process..."
		
		try {
			if ( params.acctid ) {
				log.debug "Entering update Account data process..."
				
				def a = Account.get(params.acctid)
				if ( !a ) {
					flash.message = "System could not found the account."
				} else {
					a.username = params.username
					a.fullname = params.fullname
					a.isadmin = params.isadmin?true:false
					if (a.validate()) {
						a.save()
						flash.message = "Data is updated successfully."
					} else {
						def msg = ""
						a.errors.allErrors.each {
							if (msg) msg += ", "+it
							else msg = it
						}
						flash.message = msg
					}
				}
			} else {
				flash.message = "System could not found id for data updating."
			}
		} catch (e) {
			flash.message = e.message
			log.error "Exception: "+e.message, e
		}
		redirect(action:"view", params:params)
	}
	
	def edit = {
		log.debug "Entering edit Account process..."
		
		try {
			def a = Account.get(params.acctid)
			if (!a) {
				flash.message = "System could not found the account data."
				render(view:"view", model:[search:params.search])
			} else {
				render(view:"view", model:[account:a, search:params.search])
			}
		} catch (e) {
			flash.message = e.message
			log.error "Exception: "+e.message, e
			render(view:"view", model:[search:params.search])
		}
	}
	
	def changepwd = {
		log.debug "Entering update password of Account process..."
		
		try {
			def a = Account.get(params.acctid)
			if (!a) {
				flash.message = "System could not found the account."
			} else if ( !params.password ) {
				flash.message = "Please enter the new password."
			} else if ( params.password != params.confirm ) {
				flash.message = "The passwords are not matching."
			} else {
				a.password = params.password.encodeAsMD5()
				a.save()
				flash.message = "Password is updated successfully."
			}
		} catch (e) {
			flash.message = e.message
			log.error "Exception: "+e.message, e
		}
		redirect(action:"view", params:params)
	}
	
	def delete = {
		log.debug "Entering delete Account process..."
		
		try {
			def a = Account.get(params.acctid)
			if (!a) {
				flash.message = "System could not found the account."
			} else {
				a.delete()
				flash.message = "Account is deleted successfully."
			}
		} catch (e) {
			flash.message = e.message
			log.error "Exception: "+e.message, e
		}
		redirect(action:"view", params:params)
	}
	
	def login = {
		log.debug "Entering login process..."
		
		if ( !params.uname ) {
			flash.message = "Please enter your username!"	
		} else if ( !params.passwd ) {
			flash.message = "Please enter your password!"
		} else {
			if ( params.uname == "grails" && params.passwd == "grails" ) {
				session["username"] = "Grails"
				session["security_token"] = "grails".encodeAsMD5()
				session["isadmin"] = 'admin'
				flash.message = "Login successfully."
				render(view:"../index")
			} else {
				try {
					def a = Account.findByUsername(params.uname)
					if (a) {
						if (a.password == params.passwd.encodeAsMD5()) {
							session["username"] = a.username
							session["security_token"] = a.username.encodeAsMD5()
							session["isadmin"] = a.isadmin?'admin':'user'
							a.lastAccessed = new Date()
							a.save()
							flash.message = "Login successfully."
							render(view:"../index")
						} else {
							flash.message = "Your username and password is incorrect."
						}
					} else {
						flash.message = "System not found the authorize account."
					}
				} catch (e) {
					flash.message = e.message
					log.error "Exception: "+e.message, e
				}
			}
		}
		render(view:"../index")
	}
	
	def logout = {
		log.debug "Entering logout process..."
		
		if ( session.security_token ) {
			session.username = null
			session.security_token = null
			session.page = null
			session.isadmin = null
			log.debug "Removing all user sessions holding..."
		}
		flash.message = "Logout successfully"
		render(view:"../index")
	}
}
