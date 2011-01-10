<html>
    <head>
        <meta name="layout" content="main" />
        <script type="text/javascript">
        	$(function(){
            	// Create account data dialog
        		$("#savedialog").dialog({ autoOpen: false, resizable: false, width: 400, height: 'auto' });
				// Update password
        		$("#pwddialog").dialog({ autoOpen: false, resizable: false, height: 'auto' });
        		// Edit account data dialog
        		$('#updatedialog').dialog({width: 400, resizable: false, height: 'auto'});

        		$('#confirm1').blur(function(){
					if ($(this).val() != $('#password1').val()) {
						$('#cfmlabel1').text('The password is not matching.');
						$('#password1').focus();
					} else {
						$('#cfmlabel1').text('');
					}
            	});

        		$('#confirm2').blur(function(){
        			if ($(this).val() != $('#password2').val()) {
						$('#cfmlabel2').text('The password is not matching.');
						$('#password2').focus();
					} else {
						$('#cfmlabel2').text('');
					}
            	});
            });

        	var func = {
					edit: function(acctid){
						$.prompt('Do you want to edit the data?',
								{ buttons: { Ok: true, Cancel: false }, 
								  focus: 1,
								  submit: function(v,m,f){
									if(v) window.location.href='edit?acctid='+acctid+'&search='+$('#search').val();
								  }});
					},
					delete: function(acctid){
						$.prompt('Are you sure to delete the data?',
								{ buttons: { Ok: true, Cancel: false }, 
								  focus: 1,
								  submit: function(v,m,f){
									  if(v) window.location.href='delete?acctid='+acctid+'&search='+$('#search').val();
								  }});
					},
					create: function(){
						$('#search0').val($('#search').val());
						$("#savedialog").dialog('open');
					},
					chpasswd: function(acctid){
						$('#acctid2').val(acctid);
						$('#search2').val($('#search').val());
						$("#pwddialog").dialog('open');
					}
                };
        </script>
    </head>
    <body>
        <div id="pageBody">
       		<div class="ui-widget-content">
       			<div class="ui-widget-header">Account Management</div>
       			<div style="padding: 5px;">
       			<g:form name="acctForm1" action="view" method="post">
       				<fieldset>
       					<legend>Search</legend>
       					<table class="panel">
	       					<tr>
	       						<td><input type="text" id="search" name="search" placeholder="Intelligent seach" class="inputtext" size="50" value="${search}" /></td>
	       						<td>
	       							<input type="submit" value="Search" class="command" />
	       							<input type="button" value="Create" class="command" onclick="func.create()" />
	       						</td>
	       					</tr>
	       				</table>
       				</fieldset>
       			</g:form>
       			
       			<g:if test="${accounts}">
       			<fieldset>
      				<legend>Result</legend>
      				<table class="dataTable">
       					<tr>
       						<th>No.</th>
       						<th>Username</th>
       						<th>Full name</th>
       						<th>Is Admin</th>
       						<th>Password</th>
       						<th>Last access</th>
       						<th>Create date</th>
       						<th>Last update</th>
       						<th>&nbsp;</th>
       						<th>&nbsp;</th>
       					</tr>
       					<g:each status="i" in="${accounts}" var="acct">
	       					<tr>
	       						<td align="center">${i+1}.</td>
	       						<td>${acct.username}</td>
	       						<td>${acct.fullname}</td>
	       						<td align="center"><input type="checkbox" ${acct.isadmin?'checked=checked':''} disabled/></td>
	       						<td><input type="button" id="chpasswd" value="change" class="command" onclick="func.chpasswd('${acct.id}')"/></td>
	       						<td><g:formatDate date="${acct.lastAccessed}"/></td>
	       						<td><g:formatDate date="${acct.dateCreated}"/></td>
	       						<td><g:formatDate date="${acct.lastUpdated}"/></td>
	       						<td><input type="button" id="edit" value="Edit" class="command" onclick="func.edit('${acct.id}')"/></td>
	       						<td><input type="button" id="delete" value="Delete" class="command" onclick="func.delete('${acct.id}')"/></td>
	       					</tr>
       					</g:each>
       					
       					
       				</table>
      			</fieldset>
       			</g:if>
       			
       			</div>
       		</div>
        </div>
        
        <div id="savedialog" title="Create new account">
			<p>
			<g:form name="acctForm2" action="save" method="post">
				<table class="panel">
	       			<tr>
	       				<td>Full name</td>
	       				<td>
	       					<input type="text" id="fullname" name="fullname" size="40" class="inputtext" />
	       					<input type="hidden" id="acctid0" name="acctid" />
							<input type="hidden" id="search0" name="search" />
							<br/><span style="color:red;">* Required</span>
	       				</td>
	       			</tr>
	       			<tr>
	       				<td>User name</td>
	       				<td><input type="text" name="username" size="25" class="inputtext" />
	       					<br/><span style="color:red;">* Required</span>
	       				</td>
	       			</tr>
	       			<tr>
	       				<td>Password</td>
	       				<td><input type="password" id="password1" name="password" size="25" class="inputtext" />
	       					<br/><span style="color:red;">* Required</span>
	       				</td>
	       			</tr>
	       			<tr>
	       				<td>Confirm</td>
	       				<td><input type="password" id="confirm1" name="confirm" size="25" class="inputtext" /><br/>
	       					<span id="cfmlabel1" style="color: red;"></span>
	       					<br/><span style="color:red;">* Required</span>
	       				</td>
	       			</tr>
	       			<tr>
	       				<td>Is Admin</td>
	       				<td><input type="checkbox" name="isadmin" value="1" />
	       					<br/><span style="color:red;">* Required</span>
	       				</td>
	       			</tr>
	       			<tr>
	       				<td></td>
	       				<td>
	       					<input type="submit" value="Save" class="command" />
	       					<input type="button" value="Cancel" class="command" onclick="$('#savedialog').dialog('close')" />
	       				</td>
	       			</tr>
	       		</table>
			</g:form>
			</p>
		</div>
		
		<g:if test="${account}">

			<div id="updatedialog" title="Update account data">
				<p>
				<g:form name="acctForm3" action="update" method="post">
					<table class="panel">
		       			<tr>
		       				<td>Full name</td>
		       				<td>
		       					<input type="text" id="fullname" name="fullname" size="40" class="inputtext" value="${account.fullname}" />
		       					<input type="hidden" id="acctid1" name="acctid" value="${account.id}" />
							    <input type="hidden" id="search1" name="search" value="${search}"/>
							    <br/><span style="color:red;">* Required</span>
		       				</td>
		       			</tr>
		       			<tr>
		       				<td>User name</td>
		       				<td><input type="text" name="username" size="25" class="inputtext" value="${account.username}" />
		       					<br/><span style="color:red;">* Required</span>
		       				</td>
		       			</tr>
		       			<tr>
		       				<td>Is Admin</td>
		       				<td><input type="checkbox" name="isadmin" value="1" ${account.isadmin?'checked=checked':''} /></td>
		       			</tr>
		       			<tr>
		       				<td></td>
		       				<td>
		       					<input type="submit" value="Save" class="command" />
		       					<input type="button" value="Cancel" class="command" onclick="$('#savedialog').dialog('close')" />
		       				</td>
		       			</tr>
		       		</table>
				</g:form>
				</p>
			</div>
		</g:if>
		
		<div id="pwddialog" title="Change password">
			<p>
			<g:form name="acctForm4" action="changepwd" method="post">
				<table class="panel">
	       			<tr>
	       				<td>Password</td>
	       				<td><input type="password" id="password2" name="password" size="25" class="inputtext" />
							<input type="hidden" id="acctid2" name="acctid" />
							<input type="hidden" id="search2" name="search"/>	   
					    </td>
	       			</tr>
	       			<tr>
	       				<td>Confirm</td>
	       				<td><input type="password" id="confirm2" name="confirm" size="25" class="inputtext" /><br/>
	       					<span id="cfmlabel2" style="color: red;"></span>
	       				</td>
	       			</tr>
	       			<tr>
	       				<td></td>
	       				<td>
	       					<input type="submit" value="Save" class="command" />
	       					<input type="button" value="Cancel" class="command" onclick="$('#pwddialog').dialog('close')" />
	       				</td>
	       			</tr>
	       		</table>
			</g:form>
			</p>
		</div>
        
    </body>
</html>