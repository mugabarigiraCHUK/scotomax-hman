package manrpt

import java.text.SimpleDateFormat;

class PersonController {

    def index = { redirect(action:"view",params:params) }
	
	/**
	 * Search and list person data from database
	 */
	def view = {
		log.debug "Entering Person controller viewing..."
		try {
			if ( params.command ) {
				if (params.search) {
					def p = Person.createCriteria()
					def result = p {
						or {
							like("firstName", "%"+params.search+"%")
							like("familyName", "%"+params.search+"%")
							like("middleName", "%"+params.search+"%")
						}
						order("lastUpdated", "desc")
					}
					return [persons:result, search:params.search]
				} else {
					def p = Person.createCriteria()
					def result = p {
						order("lastUpdated", "desc")
					}
					return [persons:result]
				}
				
			} else {
				log.debug "The request not come from search."
			}
		} catch (e) {
			flash.message = e.message
			log.error "Exception: "+e.message, e
		}
	}
	
	/**
	* Forward the link to page of create new person
	*/
	def create = {
		log.debug "Entering Person controller creating..."
		render(view:"create")
	}
	
	/**
	* Save new person data into database
	*/
	def save = {
		log.debug "Entering Person controller creating..."
		try {
			// Save person information data
			def p = new Person()
			p.firstName = params.firstName
			p.familyName = params.familyName
			p.middleName = params.middleName
			p.jobTitle = params.jobTitle
			p.position = params.position
			p.hasPermit = params.hasPermit?true:false
			p.hasMarried = params.hasMarries?true:false
			p.hasConscripted = params.hasConscripted?true:false
			p.phone = params.phone
			p.mobile = params.mobile
			p.email = params.email
			p.otherContact = params.otherContact
			p.description = params.description
			if (p.validate()) {
				p.save()
				flash.message = "The person data is created successfully."
				redirect(action:"view", params:params)
			} else {
				def msg = ""
				p.errors.allErrors.each {
					if (msg) msg += ", "+it
					else msg = it
				}
				flash.message = msg
				redirect(action:"create", params:params)
			}
		} catch (e) {
			flash.message = e.message
			log.error "Exception: "+e.message, e
			redirect(action:"create", params:params)
		}
	}
	
	/**
	* Getting person data by id for data editing
	*/
	def edit = {
		log.debug "Entering Person controller editing..."
		try {
			if (params.psid) {
				// Edit person information data
				def p = Person.get(params.psid)
				if (p) {
					render(view:"edit", model:[leaders:Person.list(),
								depts:Department.list(),
								person:p,
								addrs:p.addresses,
								certs:p.certificates,
								docs:p.documents])
				} else {
					flash.message = "System could not found the staff data."
					redirect(action:"view", params:params)
				}
			} else {
				flash.message = "System could not found id of staff data."
				redirect(action:"view", params:params)
			}
		} catch (e) {
			flash.message = e.message
			log.error "Exception: "+e.message, e
			redirect(action:"view", params:params)
		}
	}
	
	/**
	* Update new revise person data into database
	*/
	def update = {
		log.debug "Entering Person controller updating..."
		try {
			if (params.psid) {
				// Update person information data
				def p = Person.get(params.psid)
				if (p) {
					p.firstName = params.firstName
					p.familyName = params.familyName
					p.middleName = params.middleName
					p.jobTitle = params.jobTitle
					p.position = params.position
					p.hasPermit = params.hasPermit?true:false
					p.hasMarried = params.hasMarried?true:false
					p.hasConscripted = params.hasConscripted?true:false
					p.phone = params.phone
					p.mobile = params.mobile
					p.email = params.email
					p.otherContact = params.otherContact
					p.description = params.description
					if (p.validate()) {
						p.save()
						flash.message = "The person data is created successfully."
						redirect(action:"view", params:params)
					} else {
						def msg = ""
						p.errors.allErrors.each {
							if (msg) msg += ", "+it
							else msg = it
						}
						flash.message = msg
						redirect(action:"edit", params:params)
					}
				} else {
					flash.message = "System could not found data for deleting."
					redirect(action:"edit", params:params)
				}
			} else {
				flash.message = "System could not found id of data."
				redirect(action:"edit", params:params)
			}
		} catch (e) {
			flash.message = e.message
			log.error "Exception: "+e.message, e
			redirect(action:"edit", params:params)
		}
	}
	
	/**
	* Delete person data from database
	*/
	def delete = {
		log.debug "Entering Person controller deleting..."
		try {
			if (params.psid) {
				// Delete person information data.
				def a = Person.get(params.psid)
				if (a) {
					a.delete()
					flash.message = "The data is deleted successfully."
				} else flash.message = "System could not found data for deleting."
			} else flash.message = "System could not found id of data."
		} catch (e) {
			flash.message = e.message
			log.error "Exception: "+e.message, e
		}
		redirect(action:"view", params:params)
	}
	
	/**
	* Save new person's address data into database
	*/
	def saveaddr = {
		log.debug "Entering Person controller address saving..."
		try {
			if (params.psid) {
				def p = Person.get(params.psid)
				if (p) {
					def a = new Address()
					a.address = params.address
					a.city = params.city
					a.postal = params.postal
					p.addToAddresses(a)
					p.save()
					flash.message = "The new address data is created successfully."
				} else flash.message = "System could not found person for data updating."
			} else flash.message = "System could not found id of person for data updating."
		} catch (e) {
			flash.message = e.message
			log.error "Exception: "+e.message, e
		}
		redirect(action:"edit", params:params)
	}
	
	/**
	* Delete person's address data from database
	*/
	def deleteaddr = {
		log.debug "Entering Person controller address deleting..."
		try {
			if (params.psid && params.addrid) {
				def a = Address.get(params.addrid)
				if (a) {
					a.delete()
					flash.message = "The address data is deleted successfully."	
				} else flash.message = "System could not found person for data deleting."
			} else flash.message = "System could not found id of person for data updating."
		} catch (e) {
			flash.message = e.message
			log.error "Exception: "+e.message, e
		}
		redirect(action:"edit", params:params)
	}
	
	/**
	* Save new person's certificate data into database
	*/
	def savecert = {
		log.debug "Entering Person controller certificate saving..."
		try {
			if (params.psid) {
				def p = Person.get(params.psid)
				if (p) {
					def c = new Certificate()
					c.name = params.name
					c.degree = params.degree
					c.value = params.value
					c.organization = params.organization
					c.description = params.description
					c.dateStart = params.dateStart?(new SimpleDateFormat("yyyy-MM-dd").parse(params.dateStart)):null
					c.dateEnd = params.dateEnd?(new SimpleDateFormat("yyyy-MM-dd").parse(params.dateEnd)):null
					p.addToCertificates(c)
					p.save()
					flash.message = "the new certificate data is created successfully."
				} else flash.message = "System could not found staff for data saving."
			} else flash.message = "System could not found id of staff for data updating."
		} catch (e) {
			flash.message = e.message
			log.error "Exception: "+e.message, e
		}
		redirect(action:"edit", params:params)
	}
	
	/**
	* Delete person's certificate data from database
	*/
	def deletecert = {
		log.debug "Entering Person controller certificate deleting..."
		try {
			if (params.psid && params.certid) {
				def c = Certificate.get(params.certid)
				if (c) {
					c.delete()
					flash.message = "The certificate data is deleted successfully."
				} else flash.message = "System could not found data for deleting."
			} else flash.message = "System could not found id of person for data deleting."
		} catch (e) {
			flash.message = e.message
			log.error "Exception: "+e.message, e
		}
		redirect(action:"edit", params:params)
	}
	
	/**
	* Update person data belong to supervisor into database
	*/
	def assignleader = {
		log.debug "Entering Person controller leader assigning..."
		try {
			if (params.psid && params.leaderid) {
				def p = Person.get(params.psid)
				if (p) {
					if (params.leaderid != "-1") {
						def lead = Person.get(params.leaderid)
						if (lead) {
							p.leader = lead
							p.save()
							flash.message = "Supervisor assigned complete."
						} else flash.message = "System could not found person for assign."
					} else {
						p.leader = null
						p.save()
						flash.message = "Supervisor assigned complete."
					}
				} else flash.message = "System could not found person for data updating."
			} else flash.message = "System could not found id of person for data updating."
		} catch (e) {
			flash.message = e.message
			log.error "Exception: "+e.message, e
		}
		redirect(action:"edit", params:params)
	}
	
	/**
	* Update person data belong to department into database
	*/
	def assigndept = {
		log.debug "Entering Person controller department assigning..."
		try {
			if (params.psid && params.deptid) {
				def p = Person.get(params.psid)
				if (p) {
					if (params.deptid != "-1") {
						def dept = Department.get(params.deptid)
						if (dept) {
							p.department = dept
							p.save()
							flash.message = "Department assigned complete."
						} else flash.message = "System could not found department for assign."
					} else {
						p.department = null
						p.save()
						flash.message = "Department assigned complete."
					}
				} else flash.message = "System could not found person for data updating."
			} else flash.message = "System could not found id of person for data updating."
		} catch (e) {
			flash.message = e.message
			log.error "Exception: "+e.message, e
		}
		redirect(action:"edit", params:params)
	}
	
	/**
	* Upload and save person's photo into database
	*/
	def uploadPhoto = {
		log.debug "Entering Person controller department assigning..."
		try {
			def f = request.getFile("file")
			if (!f.empty) {
				log.debug "File name: " + f.name
				log.debug "File type: " + f.contentType
				log.debug "File size: " + f.size
				
				def p = Person.get(params.psid)
				if (p) {
					if (f.contentType && 
						(f.contentType == 'image/gif' || 
							f.contentType == 'image/jpeg' || 
							f.contentType == 'image/png' ||
							f.contentType == 'image/bmp')) {
						
						def photo = new Photo()
						photo.name = f.originalFilename
						photo.contentType = f.contentType
						photo.picture = f.bytes
						photo.person = p
						
						if (photo.validate()) {
							photo.save()
							flash.message = "The photo data is uploaded complete."
						} else {
							def msg = ""
							photo.errors.allErrors.each {
								if (msg) msg += ", "+it
								else msg = it
							}
							flash.message = msg
						}
					} else flash.message = "The file is not content type image."
				} else flash.message = "System could not found person data for updating."
			} else {
				flash.message = "The photo file is empty."
				log.warn "The photo file is empty."
			}
		} catch (e) {
			flash.message = e.message
			log.error "Exception: "+e.message, e
		}
		redirect(action:"edit", params:params)
	}
	
	/**
	* Extract person's image to HTML
	*/
	def image = {
		log.debug "Entering image generating..."
		try {
			log.debug "image link coming with id: "+params.id
			if (params.id) {
				def photo = Photo.get(params.id)
				if (photo) {
					response.setContentType(photo.contentType)
					byte[] image = photo.picture
					response.outputStream << image
				} else log.warn "System could not found photo data of person"
			} else log.warn "System could not found id for lookup the photo data."
		} catch (e) {
			log.error "Exception: " + e.message, e
		}
	}
	
	/**
	* Upload and save a new person's file into database
	*/
	def uploadFile = {
		log.debug "Entering Person controller document uploading..."
		try {
			def f = request.getFile("file")
			if (!f.empty) {
				log.debug "File name: " + f.name
				log.debug "File type: " + f.contentType
				log.debug "File size: " + f.size
				
				def p = Person.get(params.psid)
				if (p) {
					def doc = new Document()
					doc.name = f.originalFilename
					doc.contentType = f.contentType?f.contentType:'text/plain'
					doc.file = f.bytes
					
					p.addToDocuments(doc)
					p.save()
					flash.message = "The document data is uploaded complete."
					
				} else flash.message = "System could not found person data for updating."
			} else {
				flash.message = "The document file is empty."
				log.warn "The document file is empty."
			}
		} catch (e) {
			flash.message = e.message
			log.error "Exception: "+e.message, e
		}
		redirect(action:"edit", params:params)
	}
	
	/**
	* Remove person's file from database
	*/
	def removeFile = {
		log.debug "Entering Person controller document deleting..."
		try {
			if (params.docid) {
				def doc = Document.get(params.docid)
				if (doc) {
					doc.delete()
					flash.message = "The document data is deleted complete."
				} else flash.message = "System could not found document for deleting."
			} else {
				flash.message = "System could not found id of document."
				log.warn "System could not found id of document."
			}
		} catch (e) {
			flash.message = e.message
			log.error "Exception: "+e.message, e
		}
		redirect(action:"edit", params:params)
	}
	
	/**
	* Extract a person's file to HTML
	*/
	def downloadFile = {
		log.debug "Entering File generating..."
		try {
			log.debug "File downloading come with id: "+params.id
			if (params.id) {
				def doc = Document.get(params.id)
				if (doc) {
					response.setContentType(doc.contentType)
					byte[] image = doc.file
					response.setHeader( "Content-Disposition", "attachment; filename=\"" + doc.name + "\"" )
					response.setContentLength( image.length )
					response.outputStream << image
				} else log.warn "System could not found document data of person"
			} else log.warn "System could not found id for lookup the document data."
		} catch (e) {
			log.error "Exception: " + e.message, e
		}
	}
	
	/**
	* Create/Update person's attendance data
	*/
	def saveAttendance = {
		log.debug "Entering Person controller attendance saving..."
		try {
			if (params.psid) {
				def p = Person.get(params.psid)
				if (p) {
					if (params.atteid instanceof String) {
						if ( params.atteid ) {
							def a = Attendance.get(params.atteid)
							if (a) {
								a.year = params.year
								a.sickCredit = params.sickCredit?new Long(params.sickCredit):0
								a.annualCredit = params.annualCredit?new Long(params.annualCredit):0
								a.extraCredit = params.extraCredit?new Long(params.extraCredit):0
								a.sickUsed = params.sickUsed?new Long(params.sickUsed):0
								a.annualUsed = params.annualUsed?new Long(params.annualUsed):0
								a.extraUsed = params.extraUsed?new Long(params.extraUsed):0
								a.save()
							}
						} else {
							def a = new Attendance()
							a.year = params.year
							a.sickCredit = params.sickCredit?new Long(params.sickCredit):0
							a.annualCredit = params.annualCredit?new Long(params.annualCredit):0
							a.extraCredit = params.extraCredit?new Long(params.extraCredit):0
							a.sickUsed = params.sickUsed?new Long(params.sickUsed):0
							a.annualUsed = params.annualUsed?new Long(params.annualUsed):0
							a.extraUsed = params.extraUsed?new Long(params.extraUsed):0
							a.person = p
							a.save()
						}
					} else {
						def idx = 0
						params.atteid.each { item ->
							if (item) {
								def a = Attendance.get(item)
								if (a) {
									a.year = params.year[idx]
									a.sickCredit = params.sickCredit[idx]?new Long(params.sickCredit[idx]):0
									a.annualCredit = params.annualCredit[idx]?new Long(params.annualCredit[idx]):0
									a.extraCredit = params.extraCredit[idx]?new Long(params.extraCredit[idx]):0
									a.sickUsed = params.sickUsed[idx]?new Long(params.sickUsed[idx]):0
									a.annualUsed = params.annualUsed[idx]?new Long(params.annualUsed[idx]):0
									a.extraUsed = params.extraUsed[idx]?new Long(params.extraUsed[idx]):0
									a.save()
								}
							} else {
								def a = new Attendance()
								a.year = params.year[idx]
								a.sickCredit = params.sickCredit[idx]?new Long(params.sickCredit[idx]):0
								a.annualCredit = params.annualCredit[idx]?new Long(params.annualCredit[idx]):0
								a.extraCredit = params.extraCredit[idx]?new Long(params.extraCredit[idx]):0
								a.sickUsed = params.sickUsed[idx]?new Long(params.sickUsed[idx]):0
								a.annualUsed = params.annualUsed[idx]?new Long(params.annualUsed[idx]):0
								a.extraUsed = params.extraUsed[idx]?new Long(params.extraUsed[idx]):0
								a.person = p
								a.save()
							}
							idx++
						}
					}
					flash.message = "The attendance data is updated successfully."
				} else flash.message = "System could not found person data for saving."
			} else flash.message = "System could not found id of person for data saving."
		} catch (e) {
			flash.message = e.message
			log.error "Exception: "+e.message, e
		}
		redirect(action:"edit", params:params)
	}
	
	/**
	* Delete person's attendance data
	*/
	def deleteAttendance = {
		log.debug "Entering Person controller attendance deleting..."
		try {
			if (params.atteid) {
				def a = Attendance.get(params.atteid)
				if (a) {
					a.delete()
					flash.message = "The attendance data is deleted complate"
				} else flash.message = "System could not found attendance for deleting."
			} else flash.message = "System could not found id of attendance for deleting."
		} catch (e) {
			flash.message = e.message
			log.error "Exception: "+e.message, e
		}
		redirect(action:"edit", params:params)
	}
}
