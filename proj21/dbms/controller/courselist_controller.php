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

	if ( $_GET['remove_id'] ) {
		$gsql = "DELETE FROM course WHERE course_id=:course_id";
		$gstmt = oci_parse($ora_conn, $gsql);
		oci_bind_by_name($gstmt, ":course_id", $_GET['remove_id']);
		if (oci_execute($gstmt, OCI_COMMIT_ON_SUCCESS)) {
			$error = "Your information is removed successfully.";
		} else {
			$error = "System is corrupted, please try again later.";
		}
		oci_free_statement($gstmt);
	}

	$sql = "SELECT course_id"
			.", course_name"
			.", course_fee"
			.", TO_CHAR(course_start, 'dd MM yyyy') as course_start"
			.", TO_CHAR(course_end, 'dd MM yyyy') as course_end"
			." FROM course"
			." ORDER BY course_start DESC";
	$stmt = oci_parse($ora_conn, $sql);
	oci_execute($stmt);
	$nrows = oci_fetch_all($stmt, $result, null, null, OCI_FETCHSTATEMENT_BY_ROW);

	oci_free_statement($stmt);

	// OCI disconnect
	$oracle->disconnect();

?>