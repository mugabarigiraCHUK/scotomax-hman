<html>
    <head>
        <meta name="layout" content="main" />
        <script type="text/javascript">
        	$(function(){
				// Tabs
				$('#tabs').tabs();
				// Dialog
				$('#mkAddrDialog').dialog({autoOpen: false, resizable: false, width: 400});
				$('#mkCertDialog').dialog({autoOpen: false, resizable: false, width: 400});
				$('#saveDeptDialog').dialog({autoOpen: false, resizable: false, width: 400});
				$('#saveLeaderDialog').dialog({autoOpen: false, resizable: false, width: 400});
				$('#savePhotoDialog').dialog({autoOpen: false, resizable: false, width: 400});
				$('#uploadFileDialog').dialog({autoOpen: false, resizable: false, width: 400});
				// Date picker
				$('#datepicker1').datepicker({ dateFormat: 'yy-mm-dd', changeYear: true, changeMonth: true });
				$('#datepicker2').datepicker({ dateFormat: 'yy-mm-dd', changeYear: true, changeMonth: true });
				$('#birthdate').datepicker({ dateFormat: 'yy-mm-dd', changeYear: true, changeMonth: true });
				// Only numberic field
				$('.numberic').numeric({allow:"."});
            });

            func = {
				back: function(){
					window.location.href='view?search=${search}';
				},
				rmAddr: function(addrid) {
					$.prompt('Do you want to delete the address data?',
							{ buttons: { Ok: true, Cancel: false }, 
							  focus: 1,
							  submit: function(v,m,f){
								if(v) window.location.href='deleteaddr?addrid='+addrid+'&psid='+$('#psid').val();
							  }});
				},
				mkAddr: function() {
					$('#mkAddrDialog').dialog('open');
				},
				rmCert: function(certid) {
					$.prompt('Do you want to delete the certificate data?',
							{ buttons: { Ok: true, Cancel: false }, 
							  focus: 1,
							  submit: function(v,m,f){
								if(v) window.location.href='deletecert?certid='+certid+'&psid='+$('#psid').val();
							  }});
				},
				mkCert: function() {
					$('#mkCertDialog').dialog('open');
				},
				mkPhoto: function() {
					$('#savePhotoDialog').dialog('open');
				},
				mkDept: function() {
					$('#saveDeptDialog').dialog('open');
				},
				mkLeader: function() {
					$('#saveLeaderDialog').dialog('open');
				},
				mkDoc: function() {
					$('#uploadFileDialog').dialog('open');
				},
				rmDoc: function(docid) {
					$.prompt('Do you want to delete the document data?',
							{ buttons: { Ok: true, Cancel: false }, 
							  focus: 1,
							  submit: function(v,m,f){
								if(v) window.location.href='removeFile?docid='+docid+'&psid='+$('#psid').val();
							  }});
				},
				deleteAtte: function(atteid) {
					$.prompt('Do you want to delete the attendace data?',
							{ buttons: { Ok: true, Cancel: false }, 
							  focus: 1,
							  submit: function(v,m,f){
								if(v) window.location.href='deleteAttendance?atteid='+atteid+'&psid='+$('#psid').val();
							  }});
				}
            };
        </script>
    </head>
    <body>
        <div id="pageBody">
       		
       			<div class="ui-widget-content">
       				<div class="ui-widget-header">Edit human resource</div>
       				<div style="padding: 5px;">
       					<g:form name="personForm" action="update" method="post">
       						<fieldset>
	       						<legend>Information</legend>
	       						<table class="panel">
			       					<tr>
			       						<td><strong>First name</strong></td>
			       						<td>
			       							<input type="text" name="firstName" value="${person.firstName}" size="40" class="inputtext"/>
			       							<input type="hidden" id="psid" name="psid" value="${person.id}"/>
			       							<br/><span style="color:red;">* Required</span>
			       						</td>
			       						<td><strong>Family name</strong></td>
			       						<td><input type="text" name="familyName" value="${person.familyName}" size="40" class="inputtext"/></td>
			       					</tr>
			       					<tr>
			       						<td><strong>Middle name</strong></td>
			       						<td><input type="text" name="middleName" value="${person.middleName}" size="40" class="inputtext"/></td>
			       						<td></td>
			       						<td></td>
			       					</tr>
			       					<tr>
			       						<td><strong>Gender</strong></td>
			       						<td><input type="text" name="gender" value="${person.gender}" size="20" class="inputtext"/></td>
			       						<td><strong>Birth date</strong></td>
			       						<td><input type="text" id="birthdate" name="birthdate" value="${person.birthdate}" size="30" class="inputtext"/></td>
			       					</tr>
			       					<tr>
			       						<td><strong>Job Title</strong></td>
			       						<td><input type="text" name="jobTitle" value="${person.jobTitle}" size="35" class="inputtext"/></td>
			       						<td><strong>Position</strong></td>
			       						<td><select name="position">
			       								<option value="Employee" ${person.position=='Employee'?'selected':''}>Employee</option>
			       								<option value="Contract" ${person.position=='Contract'?'selected':''}>Contract</option>
			       								<option value="Trainee" ${person.position=='Trainee'?'selected':''}>Trainee</option>
			       								<option value="Candidate" ${person.position=='Candidate'?'selected':''}>Candidate</option>
			       							</select>
			       						</td>
			       					</tr>
			       					<tr>
			       						<td><strong>Work permit</strong></td>
			       						<td><input type="checkbox" name="hasPermit" ${person.hasPermit?'checked':''}/> Passed</td>
			       						<td></td>
			       						<td></td>
			       					</tr>
			       					<tr>
			       						<td><strong>Status</strong></td>
			       						<td><input type="checkbox" name="hasMarried" ${person.hasMarried?'checked':''}/> Married</td>
			       						<td></td>
			       						<td></td>
			       					</tr>
			       					<tr>
			       						<td><strong>Conscripted</strong></td>
			       						<td><input type="checkbox" name="hasConscripted" ${person.hasConscripted?'checked':''}/> Passed</td>
			       						<td></td>
			       						<td></td>
			       					</tr>
			       					<tr>
			       						<td><strong>Phone</strong></td>
			       						<td><input type="text" name="phone" value="${person.phone}" size="25" class="inputtext"/></td>
			       						<td><strong>Mobile</strong></td>
			       						<td><input type="text" name="mobile" value="${person.mobile}" size="25" class="inputtext"/></td>
			       					</tr>
			       					<tr>
			       						<td><strong>E-mail</strong></td>
			       						<td><input type="text" name="email" value="${person.email}" size="40" class="inputtext"/></td>
			       						<td></td>
			       						<td></td>
			       					</tr>
			       					<tr>
										<td><strong>Other contact</strong></td>
										<td><textarea name="otherContact" rows="5" cols="40" class="inputtext">${person.otherContact}</textarea></td>
										<td></td>
			       						<td></td>
									</tr>
									<tr>
										<td><strong>Description</strong></td>
										<td><textarea name="description" rows="5" cols="40" class="inputtext">${person.description}</textarea></td>
										<td></td>
			       						<td></td>
									</tr>
			       					<tr>
			       						<td></td>
			       						<td>
			       							<input type="submit" name="update" value="Update" class="command"/>
			       							<input type="button" name="cancel" value="Cancel" onclick="func.back()" class="command"/>
			       						</td>
			       						<td></td>
			       						<td></td>
			       					</tr>
			       				</table>
	       					</fieldset>
       					</g:form>
       					<fieldset>
	       					<legend>Advance</legend>
	       					<div id="tabs">
	       						<ul>
									<li><a href="#tabs-1">Address</a></li>
									<li><a href="#tabs-2">Certificate</a></li>
									<li><a href="#tabs-3">Photo</a></li>
									<li><a href="#tabs-4">Department</a></li>
									<li><a href="#tabs-5">Supervisor</a></li>
									<li><a href="#tabs-6">Documents</a></li>
									<li><a href="#tabs-7">Leave</a></li>
								</ul>
								<div id="tabs-1">
									<p>
										<g:form name="form1">
											<table class="panel">
												<tr>
													<td>
														<g:if test="${addrs}">
															<table class="dataTable">
										       					<tr>
										       						<th>No.</th>
										       						<th>Address</th>
										       						<th>City</th>
										       						<th>Postal</th>
										       						<th>&nbsp;</th>
										       					</tr>
										       					<g:each status="i" in="${addrs}" var="addr">
											       					<tr>
											       						<td align="center">${i+1}</td>
											       						<td>${addr.address}</td>
											       						<td>${addr.city}</td>
											       						<td>${addr.postal}</td>
											       						<td><input type="button" 
											       								   value="Delete" 
											       								   onclick="func.rmAddr('${addr.id}')" 
											       								   class="command"/></td>
											       					</tr>
										       					</g:each>
										       				</table>
									       				</g:if>
													</td>
												</tr>
												<tr>
													<td>
														<input type="button" value="Add more" onclick="func.mkAddr()" class="command"/>
													</td>
												</tr>
											</table>
										</g:form>
									</p>
								</div>
								<div id="tabs-2">
									<p>
										<g:form name="form2">
										<table class="panel">
											<tr>
												<td>
												<g:if test="${certs}"></g:if>
													<table class="dataTable">
								       					<tr>
								       						<th>No.</th>
								       						<th>Name</th>
								       						<th>Degree</th>
								       						<th>Value</th>
								       						<th>Organization</th>
								       						<th>Description</th>
								       						<th>Start</th>
								       						<th>Finish</th>
								       						<th>&nbsp;</th>
								       					</tr>
								       					<g:each status="i" in="${certs}" var="cert">
									       					<tr>
									       						<td align="center">${i+1}.</td>
									       						<td>${cert.name}</td>
									       						<td>${cert.degree}</td>
									       						<td>${cert.value}</td>
									       						<td>${cert.organization}</td>
									       						<td>${cert.description}</td>
									       						<td><g:viewDate format="yyyy-MM-dd" date="${cert.dateStart}"/></td>
									       						<td><g:viewDate format="yyyy-MM-dd" date="${cert.dateEnd}"/></td>
									       						<td><input type="button" 
									       								   value="Delete" 
									       								   onclick="func.rmCert('${cert.id}')" 
									       								   class="command"/></td>
									       					</tr>
								       					</g:each>
								       				</table>
												</td>
											</tr>
											<tr>
												<td>
													<input type="button" value="Add more" onclick="func.mkCert()" class="command"/>
												</td>
											</tr>
										</table>
										
										</g:form>
									</p>
								</div>
								<div id="tabs-3">
									<p>
										
										<table class="panel">
					       					<tr>
					       						<td><g:if test="${person.photo}">
					       								<img src="${createLink(action:'image', id:person.photo.id)}"/>
					       							</g:if>
					       						</td>
					       					</tr>
					       					<tr>
												<td>
													<input type="button" value="Upload photo" onclick="func.mkPhoto()" class="command"/>
												</td>
											</tr>
					       				</table>
										
									</p>
								</div>
								<div id="tabs-4">
									<p>
										
										<table class="panel">
					       					<tr>
					       						<td><strong>Department</strong></td>
					       						<td>
					       							<g:if test="${person.department}">
					       								${person.department.name}
					       							</g:if>
					       						</td>
					       					</tr>
					       					<tr>
												<td>
													<input type="button" value="Assign department" onclick="func.mkDept()" class="command"/>
												</td>
											</tr>
					       				</table>
										
									</p>
								</div>
								<div id="tabs-5">
									<p>
										
										<table class="panel">
					       					<tr>
					       						<td><strong>Supervisor</strong></td>
					       						<td>
					       							<g:if test="${person.leader}">
					       								${person.leader.firstName} ${person.leader.familyName}
					       							</g:if>
					       						</td>
					       					</tr>
					       					<tr>
												<td>
													<input type="button" value="Assign supervisor" onclick="func.mkLeader()" class="command"/>
												</td>
											</tr>
					       				</table>
					       				
									</p>
								</div>
								<div id="tabs-6">
									<p>
										<g:form name="form6">
											<table class="panel">
												<tr>
													<td>
														<g:if test="${docs}">
															<table class="dataTable">
										       					<tr>
										       						<th>No.</th>
										       						<th>File</th>
										       						<th>Type</th>
										       						<th>&nbsp;</th>
										       						<th>&nbsp;</th>
										       					</tr>
										       					<g:each status="i" in="${docs}" var="doc">
											       					<tr>
											       						<td align="center">${i+1}</td>
											       						<td>${doc.name}</td>
											       						<td>${doc.contentType}</td>
											       						<td><input type="button" 
											       								   id="download" 
											       								   value="Download" 
											       								   onclick="window.open('${createLink(action:'downloadFile',id:doc.id)}')" 
											       								   class="command"/></td>
											       						<td><input type="button"
											       								   value="Delete" 
											       								   onclick="func.rmDoc('${doc.id}')" 
											       								   class="command"/></td>
											       					</tr>
										       					</g:each>
										       				</table>
									       				</g:if>
													</td>
												</tr>
												<tr>
													<td>
														<input type="button" value="Upload file" onclick="func.mkDoc()" class="command"/>
													</td>
												</tr>
											</table>
										</g:form>
										
									</p>
								</div>
								<div id="tabs-7">
									<p>
										<g:form name="form7" action="saveAttendance" method="post">
											<input type="hidden" name="psid" value="${person.id}"/>
											<table class="panel">
												<tr>
													<td>
													
														<table class="dataTable">
									       					<tr>
									       						<th rowspan="2">No.</th>
									       						<th rowspan="2">Year</th>
									       						<th colspan="3">Credit</th>
									       						<th colspan="3">Used</th>
									       						<th colspan="3">remain</th>
									       						<th rowspan="2">&nbsp;</th>
									       					</tr>
									       					<tr>
									       						<th>Sick</th>
									       						<th>Vacation</th>
									       						<th>Extra</th>
									       						<th>Sick</th>
									       						<th>Vacation</th>
									       						<th>Extra</th>
									       						<th>Sick</th>
									       						<th>Vacation</th>
									       						<th>Extra</th>
									       					</tr>
									       					<g:if test="${person.attendances}">
										       					<g:each status="i" in="${person.attendances}" var="atte">
											       					<tr>
											       						<td align="center">
											       							${i+1}.
											       						</td>
											       						<td>
											       							<input type="hidden" name="year" value="${atte.year}" size="15"/>
											       							
											       							<input type="hidden" name="sickCredit" value="${atte.sickCredit}" size="15"/>
											       							<input type="hidden" name="annualCredit" value="${atte.annualCredit}" size="15"/>
											       							<input type="hidden" name="extraCredit" value="${atte.extraCredit}" size="15"/>
											       							
											       							<input type="hidden" name="atteid" value="${atte.id}" size="15"/>
											       							${atte.year}
											       						</td>
											       						<td>${atte.sickCredit}</td>
											       						<td>${atte.annualCredit}</td>
											       						<td>${atte.extraCredit}</td>
											       						
											       						<td><input type="text" name="sickUsed" value="${atte.sickUsed}" size="5" class="numberic" /></td>
											       						<td><input type="text" name="annualUsed" value="${atte.annualUsed}" size="5" class="numberic" /></td>
											       						<td><input type="text" name="extraUsed" value="${atte.extraUsed}" size="5" class="numberic" /></td>
											       						
											       						<td>${atte.sickCredit - atte.sickUsed}</td>
											       						<td>${atte.annualCredit - atte.annualUsed}</td>
											       						<td>${atte.extraCredit - atte.extraUsed}</td>
											       						
											       						<td><input type="button"" 
											       								   value="Delete"
											       								   onclick="func.deleteAtte('${atte.id}')"
											       								   class="command"/></td>
											       					</tr>
										       					</g:each>
									       					</g:if>
								       						<tr>
									       						<td align="center"></td>
									       						<td>
									       							<input type="text" name="year" size="15" />
									       							<input type="hidden" name="atteid" />
									       						</td>
									       						<td><input type="text" name="sickCredit" value="0" size="5" class="numberic" /></td>
									       						<td><input type="text" name="annualCredit" value="0" size="5" class="numberic" /></td>
									       						<td><input type="text" name="extraCredit" value="0" size="5" class="numberic" /></td>
									       						<td><input type="text" name="sickUsed" value="0" size="5" class="numberic" /></td>
									       						<td><input type="text" name="annualUsed" value="0" size="5" class="numberic" /></td>
									       						<td><input type="text" name="extraUsed" value="0" size="5" class="numberic" /></td>
									       						<td colspan="3">&nbsp;</td>
									       						<td>&nbsp;</td>
									       					</tr>
									       					<tr>
									       						<td colspan="8"><input type="submit" value="Update" class="command"/></td>
									       					</tr>
									       				</table>
									       			
													</td>
												</tr>
											</table>
										</g:form>
									</p>
								</div>
       						</div>
	       				</fieldset>
       				</div>
       				
       			</div>
       		
       		<div id="mkAddrDialog" title="Create new address information">
				<p>
					<g:form name="addrForm" action="saveaddr" method="post">
						<table class="panel">
							<tr>
								<td>Address</td>
								<td>
									<textarea name="address" rows="5" cols="40" class="inputtext"></textarea>
									<input type="hidden" id="psid1" name="psid" value="${person.id}"/>
									<br/><span style="color:red;">* Required</span>
								</td>
							</tr>
							<tr>
								<td>City</td>
								<td>
									<input type="input" name="city" size="40" class="inputtext"/>
								</td>
							</tr>
							<tr>
								<td>Postal</td>
								<td>
									<input type="input" name="postal" size="30" class="inputtext"/>
								</td>
							</tr>
							
							<tr>
								<td>&nbsp;</td>
								<td>
									<input type="submit" value="Save" class="command"/>
									<input type="button" value="Cancel" class="command" onclick="$('#mkAddrDialog').dialog('close')" />
								</td>
							</tr>
						</table>
					</g:form>
				</p>
			</div>
			
			<div id="mkCertDialog" title="Create new certificate information">
				<p>
					<g:form name="certForm" action="savecert" method="post">
						<table class="panel">
							<tr>
								<td>Name</td>
								<td>
									<input type="input" name="name" size="40" class="inputtext"/>
									<input type="hidden" id="psid2" name="psid" value="${person.id}"/>
									<br/><span style="color:red;">* Required</span>
								</td>
							</tr>
							<tr>
								<td>Degree</td>
								<td>
									<input type="input" name="degree" size="30" class="inputtext"/>
									<br/><span style="color:red;">* Required</span>
								</td>
							</tr>
							<tr>
								<td>Value</td>
								<td>
									<input type="input" name="value" size="20" class="inputtext"/>
								</td>
							</tr>
							<tr>
								<td>Organization</td>
								<td>
									<input type="input" name="organization" size="50" class="inputtext"/>
									<br/><span style="color:red;">* Required</span>
								</td>
							</tr>
							<tr>
								<td>Description</td>
								<td>
									<textarea name="description" rows="5" cols="40" class="inputtext"></textarea>
								</td>
							</tr>
							<tr>
								<td>Course started</td>
								<td>
									<input type="input" id="datepicker1" name="dateStart" size="25" class="inputtext"/>
									<br/><span style="color:red;">* Required</span>
								</td>
							</tr>
							<tr>
								<td>Course finish</td>
								<td>
									<input type="input" id="datepicker2" name="dateEnd" size="25" class="inputtext"/>
								</td>
							</tr>
							
							<tr>
								<td>&nbsp;</td>
								<td>
									<input type="submit" value="Save" class="command"/>
									<input type="button" value="Cancel" class="command" onclick="$('#mkCertDialog').dialog('close')" />
								</td>
							</tr>
						</table>
					</g:form>
				</p>
			</div>
			
			<div id="saveDeptDialog" title="Assign staff to department">
				<p>
					<g:form name="deptForm" action="assigndept" method="post">
						<table class="panel">
							<tr>
								<td>Select department</td>
								<td>
									<select id="deptid" name="deptid">
										<option value="-1"> - Unassign - </option>
										<g:if test="${depts}">
											<g:each in="${depts}">\
												<option value="${it.id}">${it.name}</option>
											</g:each>
										</g:if>
									</select>
									<input type="hidden" id="psid3" name="psid" value="${person.id}"/>
								</td>
							</tr>
							
							<tr>
								<td>&nbsp;</td>
								<td>
									<input type="submit" value="Save" class="command"/>
									<input type="button" value="Cancel" class="command" onclick="$('#saveDeptDialog').dialog('close')" />
								</td>
							</tr>
						</table>
					</g:form>
				</p>
			</div>
			
			<div id="saveLeaderDialog" title="Assign staff to Supervisor">
				<p>
					<g:form name="leaderForm" action="assignleader" method="post">
						<table class="panel">
							<tr>
								<td>Select Supervisor</td>
								<td>
									<select id="leaderid" name="leaderid">
										<g:if test="${leaders}">
											<option value="-1"> - Unassign - </option>
											<g:each in="${leaders}">
												<g:if test="${it.id != person.id}">
													<option value="${it.id}">${it.firstName} ${it.familyName}</option>
												</g:if>
											</g:each>
										</g:if>
									</select>
									<input type="hidden" id="psid4" name="psid" value="${person.id}"/>
								</td>
							</tr>
							<tr>
								<td>&nbsp;</td>
								<td>
									<input type="submit" value="Save" class="command"/>
									<input type="button" value="Cancel" class="command" onclick="$('#saveLeaderDialog').dialog('close')" />
								</td>
							</tr>
						</table>
					</g:form>
				</p>
			</div>
			
			<div id="savePhotoDialog" title="Upload staff's photo">
				<p>
					<g:form name="photoForm" action="uploadPhoto" method="post" enctype="multipart/form-data">
						<table class="panel">
							<tr>
								<td>Staff's photo'</td>
								<td>
									<input type="file" name="file"/>
									<input type="hidden" id="psid5" name="psid" value="${person.id}"/>
								</td>
							</tr>
							<tr>
								<td>&nbsp;</td>
								<td>
									<input type="submit" value="Save" class="command"/>
									<input type="button" value="Cancel" class="command" onclick="$('#savePhotoDialog').dialog('close')" />
								</td>
							</tr>
						</table>
					</g:form>
				</p>
			</div>
			
			<div id="uploadFileDialog" title="Upload staff's document">
				<p>
					<g:form name="docForm" action="uploadFile" method="post" enctype="multipart/form-data">
						<table class="panel">
							<tr>
								<td>Staff's document'</td>
								<td>
									<input type="file" name="file"/>
									<input type="hidden" id="psid5" name="psid" value="${person.id}"/>
								</td>
							</tr>
							<tr>
								<td>&nbsp;</td>
								<td>
									<input type="submit" value="Save" class="command"/>
									<input type="button" value="Cancel" class="command" onclick="$('#uploadFileDialog').dialog('close')" />
								</td>
							</tr>
						</table>
					</g:form>
				</p>
			</div>
       		
        </div>
        
    </body>
</html>