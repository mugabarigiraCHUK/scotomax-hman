<html>
    <head>
        <meta name="layout" content="main" />
        <script type="text/javascript">
	        $(function(){
	        	// Create department data.
				$('#savedialog').dialog({autoOpen: false, resizable: false, width: 400});
				$('#assigndialog').dialog({autoOpen: false, resizable: false, width: 400});
				// Update department data.
				$('#updatedialog').dialog({resizable: false, width: 400});
				// Date picker
				$('#datepicker1').datepicker({ dateFormat: 'yy-mm-dd', 
											   changeYear: true, 
											   changeMonth: true,
											   yearRange: '2000:2015' });
				$('#datepicker2').datepicker({ dateFormat: 'yy-mm-dd', 
											   changeYear: true, 
											   changeMonth: true,
											   yearRange: '2000:2015' });

				// Only numberic field
				$('.numberic').numeric({allow:"."});
	        });
	
	        var func = {
				edit: function(asid){
					$.prompt('Do you want to edit the data?',
							{ buttons: { Ok: true, Cancel: false }, 
							  focus: 1,
							  submit: function(v,m,f){
								if(v) window.location.href='edit?asid='+asid+'&search='+$('#search').val();
							  }});
				},
				delete: function(asid){
					$.prompt('Are you sure to delete the data?',
							{ buttons: { Ok: true, Cancel: false }, 
							  focus: 1,
							  submit: function(v,m,f){
								  if(v) window.location.href='delete?asid='+asid+'&search='+$('#search').val();
							  }});
				},
				create: function(){
					$('#search0').val($('#search').val());
					$('#savedialog').dialog('open');
				},
				assign: function(asid) {
					$('#search2').val($('#search').val());
					$('#asid2').val(asid);
					$('#assigndialog').dialog('open');
				}
	        };
        </script>
    </head>
    <body>
        <div id="pageBody">
       		
       			<div class="ui-widget-content">
       				<div class="ui-widget-header">Asset Management</div>
       				<div style="padding: 5px;">
       				<g:form name="assetForm" action="view" method="post">
	       				<fieldset>
	       					<legend>Search</legend>
	       					<table class="panel">
		       					<tr>
		       						<td><input type="text" id="search" name="search" placeholder="Intelligent seach" class="inputtext" size="50" /></td>
		       						<td>
		       							<input type="submit" value="Search" class="command" />
		       							<g:if test="${session.privilege=='admin' || session.privilege=='asset'}">
		       							<input type="button" value="Create" class="command" onclick="func.create()"/>
		       							</g:if>
		       						</td>
		       					</tr>
		       				</table>
	       				</fieldset>
	       			</g:form>
	       			
	       			<g:if test="${assets}">
	       			<fieldset>
	      				<legend>Result</legend>
	      				<table class="dataTable">
	       					<tr>
	       						<th>No.</th>
	       						<th>Name</th>
	       						<th>S/N number</th>
	       						<th>part number</th>
	       						<th>Prices</th>
	       						<th>Piece</th>
	       						<th>Vendor</th>
	       						<th>Brought date</th>
	       						<th>Description</th>
	       						<th>Owner</th>
	       						<th>Create date</th>
	       						<th>Last update</th>
	       						<g:if test="${session.privilege=='admin' || session.privilege=='asset'}">
		       						<th>&nbsp;</th>
		       						<th>&nbsp;</th>
		       						<th>&nbsp;</th>
	       						</g:if>
	       					</tr>
	       					<g:each status="i" in="${assets}" var="asset">
		       					<tr>
		       						<td align="center">${i+1}</td>
		       						<td>${asset.name}</td>
		       						<td align="center">${asset.snnumb}</td>
		       						<td align="center">${asset.pnnumb}</td>
		       						<td align="right">${asset.prices}</td>
		       						<td align="right">${asset.piece}</td>
		       						<td>${asset.vendor}</td>
		       						<td><g:viewDate format="yyyy-MM-dd" date="${asset.dateBrought}"/></td>
		       						<td>${asset.description}</td>
		       						<td>
		       							<g:if test="${asset.owner}">
		       								${asset.owner.firstName} ${asset.owner.familyName}
		       							</g:if>
		       						</td>
		       						<td><g:formatDate date="${asset.dateCreated}"/></td>
		       						<td><g:formatDate date="${asset.lastUpdated}"/></td>
		       						<g:if test="${session.privilege=='admin' || session.privilege=='asset'}">
			       						<td><input type="button" id="assign" value="Assign" class="command" onclick="func.assign('${asset.id}')"/></td>
			       						<td><input type="button" id="edit" value="Edit" class="command" onclick="func.edit('${asset.id}')"/></td>
			       						<td><input type="button" id="delete" value="Delete" class="command" onclick="func.delete('${asset.id}')"/></td>
		       						</g:if>
		       					</tr>
	       					</g:each>
	       					<!--
	       					<tr>
	       						<th colspan="4">&nbsp;</th>
	       						<th align="right">0</th>
	       						<th align="right">0</th>
	       						<th colspan="7">&nbsp;</th>
	       					</tr>
	       					 -->
	       				</table>
	      			</fieldset>
	       			</g:if>
	       			
       				</div>
       			</div>
       		
       			 <div id="savedialog" title="Create new Asset">
					<p>
						<g:form name="assetForm2" action="save" method="post">
							<table class="panel">
								<tr>
									<td><strong>Name</strong></td>
									<td>
										<input type="input" name="name" size="40" class="inputtext"/>
										<input type="hidden" id="search0" name="search"/>
										<br/><span style="color:red;">* Required</span>
									</td>
								</tr>
								<tr>
									<td><strong>S/N number</strong></td>
									<td><input type="input" name="snnumb" size="30" class="inputtext"/></td>
								</tr>
								<tr>
									<td><strong>Part number</strong></td>
									<td><input type="input" name="pnnumb" size="30" class="inputtext"/></td>
								</tr>
								<tr>
									<td><strong>Prices</strong></td>
									<td><input type="input" name="prices" size="30" class="inputtext numberic"/></td>
								</tr>
								<tr>
									<td><strong>Piece</strong></td>
									<td><input type="input" name="piece" size="20" class="inputtext numberic"/>
										<br/><span style="color:red;">* Required</span>
									</td>
								</tr>
								<tr>
									<td><strong>Vendor</strong></td>
									<td><textarea name="vendor" rows="5" cols="40" class="inputtext"></textarea></td>
								</tr>
								
								<tr>
									<td><strong>Brought date</strong></td>
									<td><input type="input" id="datepicker1" name="datebrought" size="20" class="inputtext"/></td>
								</tr>
								
								<tr>
									<td><strong>Description</strong></td>
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
				
				<g:if test="${asset}">
					<div id="updatedialog" title="Update asset data">
						<p>
							<g:form name="assetForm3" action="update" method="post">
								<table class="panel">
									<tr>
										<td><strong>Name</strong></td>
										<td>
											<input type="input" name="name" size="40" value="${asset.name}" class="inputtext"/>
											<input type="hidden" name="asid" value="${asset.id}"/>
											<input type="hidden" id="search1" name="search" value="${search}"/>
											<br/><span style="color:red;">* Required</span>
										</td>
									</tr>
									<tr>
										<td><strong>S/N number</strong></td>
										<td><input type="input" name="snnumb" size="30" class="inputtext" value="${asset.snnumb}"/></td>
									</tr>
									<tr>
										<td><strong>Part number</strong></td>
										<td><input type="input" name="pnnumb" size="30" class="inputtext" value="${asset.pnnumb}"/></td>
									</tr>
									<tr>
										<td><strong>Prices</strong></td>
										<td><input type="input" name="prices" size="30" class="inputtext numberic" value="${asset.prices}"/></td>
									</tr>
									<tr>
										<td><strong>Piece</strong></td>
										<td><input type="input" name="piece" size="20" class="inputtext  numberic" value="${asset.piece}"/>
											<br/><span style="color:red;">* Required</span>
										</td>
									</tr>
									
									<tr>
										<td><strong>Vendor</strong></td>
										<td><textarea name="vendor" rows="5" cols="40" class="inputtext">${asset.vendor}</textarea></td>
									</tr>
									
									<tr>
										<td><strong>Brought date</strong></td>
										<td><input type="input" id="datepicker2" name="datebrought" size="20" class="inputtext" value="${asset.dateBrought?String.format('%tF', asset.dateBrought):''}"/></td>
									</tr>
									
									<tr>
										<td><strong>Description</strong></td>
										<td><textarea name="desc" rows="5" cols="40" class="inputtext">${asset.description}</textarea></td>
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
				
				<div id="assigndialog" title="Assign asset to owner">
					<p>
						<g:form name="assetForm3" action="assignowner" method="post">
							<table class="panel">
								<tr>
									<td><strong>Staff</strong></td>
									<td>
										<select name="pid">
											<option value="-1"> - Unassign - </option>
											<g:if test="${owners}">
												<g:each in="${owners}">
													<option value="${it.id}">${it.firstName} ${it.familyName}</option>
												</g:each>
											</g:if>
										</select>
										<input type="hidden" id="asid2" name="asid" />
										<input type="hidden" id="search2" name="search" />
									</td>
									<tr>
										<td>&nbsp;</td>
										<td>
											<input type="submit" value="Save" class="command"/>
											<input type="button" value="Cancel" class="command" onclick="$('#assigndialog').dialog('close')" />
										</td>
									</tr>
								</tr>
							</table>
						</g:form>
					</p>
				</div>
						
        </div>
    </body>
</html>