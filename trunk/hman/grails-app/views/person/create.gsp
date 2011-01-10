<html>
    <head>
        <meta name="layout" content="main" />
        <script type="text/javascript">
        	$(function(){
				// Tabs
				
            });
        </script>
    </head>
    <body>
        <div id="pageBody">
       		
       			<div class="ui-widget-content">
       				<div class="ui-widget-header">Create human resource</div>
       				<div style="padding: 5px;">
       					<g:form name="personForm" action="save" method="post">
       						<fieldset>
	       						<legend>Information</legend>
	       						<table class="panel">
			       					<tr>
			       						<td>First name</td>
			       						<td><input type="text" name="firstName" value="${params.firstName}" size="40" class="inputtext"/>
			       							<br/><span style="color:red;">* Required</span>	
			       						</td>
			       						<td>Family name</td>
			       						<td><input type="text" name="familyName" value="${params.familyName}" size="40" class="inputtext"/></td>
			       					</tr>
			       					<tr>
			       						<td>Middle name</td>
			       						<td><input type="text" name="middleName" value="${params.middleName}" size="40" class="inputtext"/></td>
			       						<td></td>
			       						<td></td>
			       					</tr>
			       					<tr>
			       						<td>Job Title</td>
			       						<td><input type="text" name="jobTitle" value="${params.jobTitle}" size="35" class="inputtext"/></td>
			       						<td>Position</td>
			       						<td><input type="text" name="position" value="${params.position}" size="30" class="inputtext"/>
			       							<br/><span style="color:red;">* Required</span>
			       						</td>
			       					</tr>
			       					
			       					<tr>
			       						<td>Work permit</td>
			       						<td><input type="checkbox" name="hasPermit" ${params.hasPermit?'checked':''}/> Passed</td>
			       						<td></td>
			       						<td></td>
			       					</tr>
			       					<tr>
			       						<td>Status</td>
			       						<td><input type="checkbox" name="hasMarried" ${params.hasMarried?'checked':''}/> Married</td>
			       						<td></td>
			       						<td></td>
			       					</tr>
			       					<tr>
			       						<td>Conscripted</td>
			       						<td><input type="checkbox" name="hasConscripted" ${params.hasConscripted?'checked':''}/> Passed</td>
			       						<td></td>
			       						<td></td>
			       					</tr>
			       					<tr>
			       						<td>Phone</td>
			       						<td><input type="text" name="phone" value="${params.phone}" size="25" class="inputtext"/></td>
			       						<td>Mobile</td>
			       						<td><input type="text" name="mobile" value="${params.mobile}" size="25" class="inputtext"/></td>
			       					</tr>
			       					<tr>
			       						<td>E-mail</td>
			       						<td><input type="text" name="email" value="${params.email}" size="40" class="inputtext"/></td>
			       						<td></td>
			       						<td></td>
			       					</tr>
			       					<tr>
										<td>Other contact</td>
										<td><textarea name="otherContact" rows="5" cols="40" class="inputtext">${params.otherContact}</textarea></td>
										<td></td>
			       						<td></td>
									</tr>
									<tr>
										<td>Description</td>
										<td><textarea name="description" rows="5" cols="40" class="inputtext">${params.description}</textarea></td>
										<td></td>
			       						<td></td>
									</tr>
			       					<tr>
			       						<td></td>
			       						<td>
			       							<input type="submit" name="save" value="Save" class="command"/>
			       							<input type="submit" name="cancel" value="Cancel" class="command"/>
			       						</td>
			       						<td></td>
			       						<td></td>
			       					</tr>
			       				</table>
	       					</fieldset>
       					</g:form>
       					
       				</div>
       				
       			</div>
       		
        </div>
    </body>
</html>