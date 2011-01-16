<html>
    <head>
        <meta name="layout" content="main" />
        <script type="text/javascript">
        	$(function(){
				// Date picker
        		$('#birthdate').datepicker({ dateFormat: 'yy-mm-dd', 
            								 changeYear: true, 
            								 changeMonth: true,
            								 yearRange: '1976:2011' });
            });

            var func = {
				back: function(){
					window.location.href='view?search=${search}';
				}
            };
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
			       						<td><strong>First name</strong></td>
			       						<td><input type="text" name="firstName" value="${params.firstName}" size="40" class="inputtext"/>
			       							<br/><span style="color:red;">* Required</span>	
			       						</td>
			       						<td><strong>Family name</strong></td>
			       						<td><input type="text" name="familyName" value="${params.familyName}" size="40" class="inputtext"/></td>
			       					</tr>
			       					<tr>
			       						<td><strong>Middle name</strong></td>
			       						<td><input type="text" name="middleName" value="${params.middleName}" size="40" class="inputtext"/></td>
			       						<td></td>
			       						<td></td>
			       					</tr>
			       					<tr>
			       						<td><strong>Gender</strong></td>
			       						<td><input type="text" name="gender" value="${params.gender}" size="20" class="inputtext"/></td>
			       						<td><strong>Birth date</strong></td>
			       						<td><input type="text" id="birthdate" name="birthdate" value="${params.birthdate}" size="30" class="inputtext"/></td>
			       					</tr>
			       					<tr>
			       						<td><strong>Job Title</strong></td>
			       						<td><input type="text" name="jobTitle" value="${params.jobTitle}" size="35" class="inputtext"/></td>
			       						<td><strong>Position</strong></td>
			       						<td><select name="position">
			       								<option value="Employee" ${params.position=='Employee'?'selected':''}>Employee</option>
			       								<option value="Contract" ${params.position=='Contract'?'selected':''}>Contract</option>
			       								<option value="Trainee" ${params.position=='Trainee'?'selected':''}>Trainee</option>
			       								<option value="Candidate" ${params.position=='Candidate'?'selected':''}>Candidate</option>
			       							</select>
			       						</td>
			       					</tr>
			       					
			       					<tr>
			       						<td><strong>Work permit</strong></td>
			       						<td><input type="checkbox" name="hasPermit" ${params.hasPermit?'checked':''}/> Passed</td>
			       						<td></td>
			       						<td></td>
			       					</tr>
			       					<tr>
			       						<td><strong>Status</strong></td>
			       						<td><input type="checkbox" name="hasMarried" ${params.hasMarried?'checked':''}/> Married</td>
			       						<td></td>
			       						<td></td>
			       					</tr>
			       					<tr>
			       						<td><strong>Conscripted</strong></td>
			       						<td><input type="checkbox" name="hasConscripted" ${params.hasConscripted?'checked':''}/> Passed</td>
			       						<td></td>
			       						<td></td>
			       					</tr>
			       					<tr>
			       						<td><strong>Phone</strong></td>
			       						<td><input type="text" name="phone" value="${params.phone}" size="25" class="inputtext"/></td>
			       						<td><strong>Mobile</strong></td>
			       						<td><input type="text" name="mobile" value="${params.mobile}" size="25" class="inputtext"/></td>
			       					</tr>
			       					<tr>
			       						<td><strong>E-mail</strong></td>
			       						<td><input type="text" name="email" value="${params.email}" size="40" class="inputtext"/></td>
			       						<td></td>
			       						<td></td>
			       					</tr>
			       					<tr>
										<td><strong>Other contac</strong>t</td>
										<td><textarea name="otherContact" rows="5" cols="40" class="inputtext">${params.otherContact}</textarea></td>
										<td></td>
			       						<td></td>
									</tr>
									<tr>
										<td><strong>Description</strong></td>
										<td><textarea name="description" rows="5" cols="40" class="inputtext">${params.description}</textarea></td>
										<td></td>
			       						<td></td>
									</tr>
			       					<tr>
			       						<td></td>
			       						<td>
			       							<input type="submit" name="save" value="Save" class="command"/>
			       							<input type="button" name="cancel" value="Cancel" class="command" onclick="func.back()"/>
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