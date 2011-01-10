<html>
    <head>
        <title><g:layoutTitle default="Human Resource Management" /></title>
        <link rel="shortcut icon" href="${resource(dir:'images',file:'favicon.ico')}" type="image/x-icon" />
        <!-- CSS -->
       
        <link rel="stylesheet" href="${resource(dir:'css',file:'demos.css')}" />
        <link rel="stylesheet" href="${resource(dir:'css',file:'jquery-impromptu.3.1.min.css')}" />
        <link rel="stylesheet" href="${resource(dir:'css/ui-lightness',file:'jquery-ui-1.8.7.custom.css')}" />
        
        <!-- JavaScript -->
        <g:javascript library="jquery-1.4.4.min" />
        <g:javascript library="jquery-impromptu.3.1.min" />
        <g:javascript library="jquery-ui-1.8.7.custom.min" />
        <g:javascript library="main" />
        <g:javascript library="application" />
        
        <g:layoutHead />
        
    </head>
    <body>
        
        <div id="spinner" class="spinner" style="display:none;">
            <img src="${resource(dir:'images',file:'spinner.gif')}" alt="${message(code:'spinner.alt',default:'Loading...')}" />
        </div>
        
        <g:if test="${flash.message}">
        	<script type="text/javascript">
        		$.prompt("${flash.message}", {focus: 0,});
        	</script>
        </g:if>
        
        <table class="page-layout" cellspacing="0" cellpadding="0">
        	<tr>
				<td colspan="2" class="header2">
					<table class="table_label" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td class="header1">&nbsp;</td>
							<td class="header2">HR - Resource Management</td>
							<td class="header3">&nbsp;</td>
						</tr>
					</table>
				</td>
			</tr>
        	<tr>
				<td class="menubar" colspan="2">
					<g:if test="${session.username}">
						Welcome, ${session.username} |
					</g:if>
					Moving on the perfect solution
					&nbsp;&nbsp;&nbsp;&nbsp;
				</td>
			</tr>
			<tr> 
				<td class="left-nav">
					
					<dl class="demos-nav"> 
						
						<g:if test="${session.security_token}">
							<dt>Resource</dt>
								<dd><g:link class="${session.page=='staff-nav'?'selected':''}" controller="person" action="view" params="[page:'staff-nav']">Staff</g:link></dd>
								<dd><g:link class="${session.page=='asset-nav'?'selected':''}" controller="asset" action="view" params="[page:'asset-nav']">Asset</g:link></dd>
								
								<g:if test="${session.isadmin=='admin'}">
									<dt>Administrator</dt> 
										<dd><g:link class="${session.page=='dept-nav'?'selected':''}" controller="department" action="view" params="[page:'dept-nav']">Department</g:link></dd> 
										<dd><g:link class="${session.page=='acct-nav'?'selected':''}" controller="account" action="view" params="[page:'acct-nav']">Account</g:link></dd> 
										<dd><g:link class="${session.page=='org-nav'?'selected':''}" controller="department" action="organize" params="[page:'org-nav']">Organize</g:link></dd> 
								</g:if>
								
						</g:if>
						<dt>System</dt> 
							<g:if test="${session.security_token}">
								<dd><g:link controller="account" action="logout">Logout</g:link></dd> 
							</g:if>
							<g:else>
								<dd><g:link controller="account" action="login">Login</g:link></dd> 
							</g:else>
							
					</dl>
					
				</td> 
				<td class="normal"> 
					<div class="normal"> 
						<g:layoutBody /> 
					</div>
				</td>
			</tr> 
			<tr>
				<td class="footer" colspan="2">
					Copyright (c) 2011 by scotomax-hman 
					&nbsp;&nbsp;&nbsp;&nbsp;
				</td>
			</tr>
		</table>
    </body>
</html>