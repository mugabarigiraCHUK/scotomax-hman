<?php

	// Required OCI class
	include("./config/oracle.php");
	include("./config/dropdownlist.php");
	
	// Initial OCI objects and open connection
	$oracle = new OciHandle;
	$ora_conn = $oracle->connection();
	
	// Dropdownlist
	$deptlist = Dropdownlist::cbs_department($ora_conn);
	$courselist = Dropdownlist::course($ora_conn);
	
	if ( isset( $_SERVER['REQUEST_METHOD'] ) ) {
		
		// Handle HTTP POST method
		if ( $_SERVER['REQUEST_METHOD'] == "POST" ) {
			// TODO
			
		}
	}
	
	// OCI disconnect
	$oracle->disconnect();
?>