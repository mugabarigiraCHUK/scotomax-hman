<html>
    <head>
        <meta name="layout" content="main" />
        <script type="text/javascript">
        	$(function(){
            	// Create department data.
				$('#savedialog').dialog({autoOpen: false, resizable: false, width: 400});
				// Update department data.
				$('#updatedialog').dialog({resizable: false, width: 400});
            });

            var func = {
				edit: function(deptid){
					$.prompt('Do you want to edit the data?',
							{ buttons: { Ok: true, Cancel: false }, 
							  focus: 1,
							  submit: function(v,m,f){
								if(v) window.location.href='edit?deptid='+deptid+'&search='+$('#search').val();
							  }});
				},
				delete: function(deptid){
					$.prompt('Are you sure to delete the data?',
							{ buttons: { Ok: true, Cancel: false }, 
							  focus: 1,
							  submit: function(v,m,f){
								  if(v) window.location.href='delete?deptid='+deptid+'&search='+$('#search').val();
							  }});
				},
				create: function(){
					$('#search0').val($('#search').val());
					$('#savedialog').dialog('open');
				}
            };
        </script>
    </head>
    <body>
        <div id="pageBody">
       		
       			<div class="ui-widget-content">
       				<div class="ui-widget-header">Department Management</div>
       				<div style="padding: 5px;">
       				<g:form name="deptForm1" action="view" method="post">
	       				<fieldset>
	       					<legend>Search</legend>
	       					<table class="panel">
		       					<tr>
		       						<td><input type="text" id="search" name="search" placeholder="Intelligent seach" class="inputtext" size="50" /></td>
		       						<td>
		       							<input type="submit" value="Search" class="command" />
		       							<input type="button" value="Create" class="command" onclick="func.create()"/>
		       						</td>
		       					</tr>
		       				</table>
	       				</fieldset>
	       			</g:form>
	       			
	       			<g:if test="${depts}">
		       			<fieldset>
		      				<legend>Result</legend>
		      				<table class="dataTable">
		       					<tr>
		       						<th>No.</th>
		       						<th>Name</th>
		       						<th>Description</th>
		       						<th>Create date</th>
		       						<th>Last update</th>
		       						<th>&nbsp;</th>
		       						<th>&nbsp;</th>
		       					</tr>
		       					
		       					<g:each status="i" in="${depts}" var="dept">
			       					<tr>
			       						<td align="center">${i+1}.</td>
			       						<td>${dept.name}</td>
			       						<td style="white-space: normal">${dept.description}</td>
			       						<td><g:formatDate date="${dept.dateCreated}/></td>
			       						<td><g:formatDate date="${dept.lastUpdated}/></td>
			       						<td><input type="button" value="Edit" class="command" onclick="func.edit('${dept.id}')"/></td>
			       						<td><input type="button" value="Delete" class="command" onclick="func.delete('${dept.id}')"/></td>
			       					</tr>
		       					</g:each>
		       					
		       				</table>
		      			</fieldset>
	       			</g:if>
	       			
       				</div>
       			</div>
       		
       			 <div id="savedialog" title="Create new department">
					<p>
						<g:form name="deptForm2" action="save" method="post">
							<table class="panel">
								<tr>
									<td>Name</td>
									<td>
										<input type="input" name="name" size="40" class="inputtext"/>
										<input type="hidden" id="search0" name="search"/>
										<br/><span style="color:red;">* Required</span>
									</td>
								</tr>
								<tr>
									<td>Description</td>
									<td><textarea name="desc" rows="5" cols="40" class="inputtext"></textarea></td>
								</tr>
								<tr>
									<td>&nbsp;</td>
									<td>
										<input type="submit" value="Save" class="command"/>
										<input type="button" value="Cancel" class="command" onclick="$('#savedialog').dialog('close')" />
									</td>
								</tr>
							</table>
						</g:form>
					</p>
				</div>
				
				<g:if test="${dept}">
					<div id="updatedialog" title="Update department data">
						<p>
							<g:form name="deptForm3" action="update" method="post">
								<table class="panel">
									<tr>
										<td>Name</td>
										<td>
											<input type="input" name="name" size="40" value="${dept.name}" class="inputtext"/>
											<input type="hidden" name="deptid" value="${dept.id}"/>
											<input type="hidden" id="search1" name="search" value="${search}"/>
											<br/><span style="color:red;">* Required</span>
										</td>
									</tr>
									<tr>
										<td>Description</td>
										<td><textarea name="desc" rows="5" cols="40" class="inputtext">${dept.description}</textarea></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
										<td>
											<input type="submit" value="Save" class="command"/>
											<input type="button" value="Cancel" class="command" onclick="$('#updatedialog').dialog('close')" />
										</td>
									</tr>
								</table>
							</g:form>
						</p>
					</div>
				</g:if>
				
        </div>
    </body>
</html>