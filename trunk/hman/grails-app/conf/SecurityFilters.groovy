class SecurityFilters {
	
	def filters = {
		all(controller:'*', action:'*') {
			before = {
				if (params.page) session['page'] = params.page
				if ( !session.security_token ) {
					if (params.action != "login" && params.action != "logout") {
						redirect(controller:'account', action:'login')
					}
				} else {
					if ( params.controller == "person" && params.action != "view" ) {
						if (session.privilege != "admin") {
							redirect(controller:'person', action:'view')
						}
					} else if (params.controller == "asset" && params.action != "view") {
						if (session.privilege != "admin") {
							redirect(controller:'asset', action:'view')
						}
					} else if (params.controller == "department" && params.action != "view") {
						if (session.privilege != "admin") {
							redirect(controller:'department', action:'view')
						}
					} else if (params.controller == "account" && params.action != "view") {
						if (session.privilege != "admin") {
							redirect(controller:'account', action:'view')
						}
					}
				}
			}
		}
	}
}
