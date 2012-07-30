<?php

	// Required OCI class
	include("./config/oracle.php");
	include("./config/utils.php");

	if ( $_SESSION['id_code'] != "13245768" ) {
		header( "Location: index.php" );
	}
	
	// Initial OCI objects and open connection
	$oracle = new oracle;
	$ora_conn = $oracle->connection();

?>