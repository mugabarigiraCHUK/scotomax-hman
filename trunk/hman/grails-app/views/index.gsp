<html>
    <head>
        <meta name="layout" content="main" />
        <script type="text/javascript">
        	$(function(){
				$('#uname').focus();
            });
        </script>
    </head>
    <body>
        <div id="pageBody">
        	<div class="ui-widget-content">
       			<div class="ui-widget-header">Welcome to Resource Management</div>
       			<div style="padding: 5px;">
       			<g:if test="${session.security_token}">
       				<fieldset>
       					<legend>Information</legend>
       					Bha Bha Bha Bha.....
       				</fieldset>
       			</g:if>
       			<g:else>
       				<fieldset>
       					<legend>Authenticate</legend>
       					<g:form name="login" controller="account" action="login" method="post"> 
       						<table class="panel">
       							<tr>
       								<td>Username</td>
       								<td><input type="text" id="uname" name="uname" class="inputtext" /></td>
       							</tr>
       							<tr>
       								<td>Password</td>
       								<td><input type="password" id="passwd" name="passwd" class="inputtext" /></td>
       							</tr>
       							<tr>
       								<td></td>
       								<td><input type="submit" value="Login" class="command"/></td>
       							</tr>
       						</table>
       					</g:form>
       				</fieldset>
       			</g:else>
       			</div>
       		</div>
        </div>
    </body>
</html>
