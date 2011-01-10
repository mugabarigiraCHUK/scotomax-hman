<html>
    <head>
        <meta name="layout" content="main" />
        <script type="text/javascript">
        $(function(){
        	// onLoad function
			
        });

        var func = {
			edit: function(psid){
				$.prompt('Do you want to edit the data?',
						{ buttons: { Ok: true, Cancel: false }, 
						  focus: 1,
						  submit: function(v,m,f){
							if(v) window.location.href='edit?psid='+psid+'&search='+$('#search').val();
						  }});
			},
			delete: function(psid){
				$.prompt('Are you sure to delete the data?',
						{ buttons: { Ok: true, Cancel: false }, 
						  focus: 1,
						  submit: function(v,m,f){
							  if(v) window.location.href='delete?psid='+psid+'&search='+$('#search').val();
						  }});
			},
			create: function(){
				window.location.href='create?search='+$('#search').val();
			},
			view: function(psid){
				window.location.href='person?psid='+psid+'&search='+$('#search').val();
			}
        };
        </script>
    </head>
    <body>
        <div id="pageBody">
       		
       			<div class="ui-widget-content">
       				<div class="ui-widget-header">Resource Management</div>
       				<div style="padding: 5px;">
       				<g:form name="personForm" action="view" method="post">
	       				<fieldset>
	       					<legend>Search</legend>
	       					<table class="panel">
	       						<tr>
	       							<td><input type="text" name="search" size="50" value="${search}" placeholder="Intelligent search" class="inputtext"/></td>
	       							<td>
	       								<input type="submit" name="cmdSearch" value="Search" class="command" />
	       								<g:if test="${session.isadmin=='admin'}">
		       							<input type="button" name="cmdCreate" value="Create" onclick="func.create()" class="command" />
		       							</g:if>
		       							<input type="hidden" name="command" value="search"/>
	       							</td>
	       						</tr>
		       				</table>
	       				</fieldset>
	       			</g:form>
	       			<g:if test="${persons}">
	       			<fieldset>
	      				<legend>Result</legend>
	      				<table class="dataTable">
	       					<tr>
	       						<th>No.</th>
	       						<th>First name</th>
	       						<th>Family name</th>
	       						<th>Middle name</th>
	       						<th>Job Title</th>
	       						<th>Position</th>
	       						<th>Created date</th>
	       						<th>Last updated</th>
	       						<g:if test="${session.isadmin=='admin'}">
	       						<th>&nbsp;</th>
	       						<th>&nbsp;</th>
	       						</g:if>
	       						<g:else>
	       						<th>&nbsp;</th>
	       						</g:else>
	       					</tr>
	       					<g:each status="i" in="${persons}" var="ps">
	       					<tr>
	       						<td align="center">${i+1}.</td>
	       						<td>${ps.firstName}</td>
	       						<td>${ps.familyName}</td>
	       						<td>${ps.middleName}</td>
	       						<td>${ps.jobTitle}</td>
	       						<td>${ps.position}</td>
	       						<td><g:formatDate date="${ps.dateCreated}"/></td>
	       						<td><g:formatDate date="${ps.lastUpdated}"/></td>
	       						<g:if test="${session.isadmin=='admin'}">
	       						<td><input type="button" id="edit" value="Edit" class="command" onclick="func.edit('${ps.id}')"/></td>
	       						<td><input type="button" id="delete" value="Delete" class="command" onclick="func.delete('${ps.id}')"/></td>
	       						</g:if>
	       						<g:else>
	       						<td><input type="button" id="view" value="view" class="command" onclick="func.view('${ps.id}')"/></td>
	       						</g:else>
	       					</tr>
	       					</g:each>
	       				</table>
	      			</fieldset>
	       			</g:if>
       				</div>
       			</div>
       		
        </div>
    </body>
</html>