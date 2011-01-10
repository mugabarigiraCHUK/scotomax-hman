<html>
    <head>
        <meta name="layout" content="main" />
        <script type="text/javascript">
        	$(function(){
				// Tabs
				$('#tabs').tabs();
            });

            func = {
				back: function(){
					window.location.href='view?search=${search}';
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
			       						<td>First name</td>
			       						<td>
			       							<input type="text" name="firstName" value="${person.firstName}" size="40" class="inputtext"/>
			       							<input type="hidden" id="psid" name="psid" value="${person.id}"/>
			       							<br/><span style="color:red;">* Required</span>
			       						</td>
			       						<td>Family name</td>
			       						<td><input type="text" name="familyName" value="${person.familyName}" size="40" class="inputtext"/></td>
			       					</tr>
			       					<tr>
			       						<td>Middle name</td>
			       						<td><input type="text" name="middleName" value="${person.middleName}" size="40" class="inputtext"/></td>
			       						<td></td>
			       						<td></td>
			       					</tr>
			       					<tr>
			       						<td>Job Title</td>
			       						<td><input type="text" name="jobTitle" value="${person.jobTitle}" size="35" class="inputtext"/></td>
			       						<td>Position</td>
			       						<td><input type="text" name="position" value="${person.position}" size="30" class="inputtext"/>
			       							<br/><span style="color:red;">* Required</span>
			       						</td>
			       					</tr>
			       					<tr>
			       						<td>Work permit</td>
			       						<td><input type="checkbox" name="hasPermit" ${person.hasPermit?'checked':''}/> Passed</td>
			       						<td></td>
			       						<td></td>
			       					</tr>
			       					<tr>
			       						<td>Status</td>
			       						<td><input type="checkbox" name="hasMarried" ${person.hasMarried?'checked':''}/> Married</td>
			       						<td></td>
			       						<td></td>
			       					</tr>
			       					<tr>
			       						<td>Conscripted</td>
			       						<td><input type="checkbox" name="hasConscripted" ${person.hasConscripted?'checked':''}/> Passed</td>
			       						<td></td>
			       						<td></td>
			       					</tr>
			       					<tr>
			       						<td>Phone</td>
			       						<td><input type="text" name="phone" value="${person.phone}" size="25" class="inputtext"/></td>
			       						<td>Mobile</td>
			       						<td><input type="text" name="mobile" value="${person.mobile}" size="25" class="inputtext"/></td>
			       					</tr>
			       					<tr>
			       						<td>E-mail</td>
			       						<td><input type="text" name="email" value="${person.email}" size="40" class="inputtext"/></td>
			       						<td></td>
			       						<td></td>
			       					</tr>
			       					<tr>
										<td>Other contact</td>
										<td><textarea name="otherContact" rows="5" cols="40" class="inputtext">${person.otherContact}</textarea></td>
										<td></td>
			       						<td></td>
									</tr>
									<tr>
										<td>Description</td>
										<td><textarea name="description" rows="5" cols="40" class="inputtext">${person.description}</textarea></td>
										<td></td>
			       						<td></td>
									</tr>
			       					<tr>
			       						<td></td>
			       						<td>
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
									<li><a href="#tabs-7">Vacation</a></li>
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
										       					</tr>
										       					<g:each status="i" in="${addrs}" var="addr">
											       					<tr>
											       						<td align="center">${i+1}</td>
											       						<td>${addr.address}</td>
											       						<td>${addr.city}</td>
											       						<td>${addr.postal}</td>
											       					</tr>
										       					</g:each>
										       				</table>
									       				</g:if>
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
									       					</tr>
								       					</g:each>
								       				</table>
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
					       						<td>Photo<br/>
					       							<g:if test="${person.photo}">
					       								<img src="${createLink(action:'image', id:person.photo.id)}"/>
					       							</g:if>
					       							
					       						</td>
					       					</tr>
					       				</table>
										
									</p>
								</div>
								<div id="tabs-4">
									<p>
										
										<table class="panel">
					       					<tr>
					       						<td>Department</td>
					       						<td>
					       							<g:if test="${person.department}">
					       								${person.department.name}
					       							</g:if>
					       						</td>
					       					</tr>
					       				</table>
										
									</p>
								</div>
								<div id="tabs-5">
									<p>
										
										<table class="panel">
					       					<tr>
					       						<td>Supervisor</td>
					       						<td>
					       							<g:if test="${person.leader}">
					       								${person.leader.firstName} ${person.leader.familyName}
					       							</g:if>
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
											       					</tr>
										       					</g:each>
										       				</table>
									       				</g:if>
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
									       					</tr>
									       					<tr>
									       						<th>Sick</th>
									       						<th>Annual</th>
									       						<th>Extra</th>
									       						<th>Sick</th>
									       						<th>Annual</th>
									       						<th>Extra</th>
									       					</tr>
									       					<g:if test="${person.attendances}">
										       					<g:each status="i" in="${person.attendances}" var="atte">
											       					<tr>
											       						<td align="center">${i+1}.</td>
											       						<td>${atte.year}</td>
											       						<td>${atte.sickCredit}</td>
											       						<td>${atte.annualCredit}</td>
											       						<td>${atte.extraCredit}</td>
											       						<td>${atte.sickUsed}</td>
											       						<td>${atte.annualUsed}</td>
											       						<td>${atte.extraUsed}</td>
											       					</tr>
										       					</g:each>
									       					</g:if>
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
       		
        </div>
        
    </body>
</html>