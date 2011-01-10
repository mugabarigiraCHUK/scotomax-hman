class SecurityFilters {
	
	def filters = {
		all(controller:'*', action:'*') {
			before = {
				if (params.page) session['page'] = params.page
				if ( !session.security_token ) {
					if (params.action != "login" && params.action != "logout") {
						redirect(controller:'account', action:'login')
					}
				}
			}
		}
	}
}
