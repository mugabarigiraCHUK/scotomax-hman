<?php

	// Required OCI class
	include("./config/oracle.php");

	if ( $_SESSION['id_code'] != "13245768" ) {
		header( "Location: index.php" );
	}
	
	// Initial OCI objects and open connection
	$oracle = new oracle;
	$ora_conn = $oracle->connection();

	// Handle HTTP POST method
	if ( $_SERVER['REQUEST_METHOD'] == "POST" ) {
		if ( $_POST['cbs_id'] ) {
			$usql = "UPDATE cbs_departments SET cbs_department=:cbs_department WHERE cbs_id=:cbs_id";
			$ustmt = oci_parse($ora_conn, $usql);
			oci_bind_by_name($ustmt, ":cbs_department", iconv("UTF-8","TIS-620", $_POST["n_cbs_department"]));
			oci_bind_by_name($ustmt, ":cbs_id", $_POST['cbs_id']);
			if (oci_execute($ustmt, OCI_COMMIT_ON_SUCCESS)) {
				$error = "Your information is updated successfully.";
			} else {
				$error = "System is corrupted, please try again later.";
			}
			oci_free_statement($ustmt);
		} else {
			$usql = "INSERT INTO cbs_departments( cbs_id, cbs_department) VALUES( :cbs_id, :cbs_department)";
			$ustmt = oci_parse($ora_conn, $usql);
			oci_bind_by_name($ustmt, ":cbs_id", $_POST['n_cbs_id']);
			oci_bind_by_name($ustmt, ":cbs_department", iconv("UTF-8","TIS-620", $_POST["n_cbs_department"]));
			if (oci_execute($ustmt, OCI_COMMIT_ON_SUCCESS)) {
				$error = "Your information is inserted successfully.";
			} else {
				$error = "System is corrupted, please try again later.";
			}
			oci_free_statement($ustmt);
		}
	} else {
		if ( $_GET['cbs_id'] ) {
			$gsql = "SELECT cbs_id, cbs_department FROM cbs_departments WHERE cbs_id=:cbs_id";
			$gstmt = oci_parse($ora_conn, $gsql);
			oci_bind_by_name($gstmt, ":cbs_id", $_GET['cbs_id']);
			if (oci_execute($gstmt)) {
				while(oci_fetch($gstmt)) {
					$cbs_id = oci_result($gstmt, 'CBS_ID');
					$cbs_department = iconv("TIS-620","UTF-8", oci_result($gstmt, 'CBS_DEPARTMENT'));
				}
			} 
			oci_free_statement($gstmt);
		} else if ( $_GET['remove_id'] ) {
			$gsql = "DELETE FROM cbs_departments WHERE cbs_id=:cbs_id";
			$gstmt = oci_parse($ora_conn, $gsql);
			oci_bind_by_name($gstmt, ":cbs_id", $_GET['remove_id']);
			if (oci_execute($gstmt, OCI_COMMIT_ON_SUCCESS)) {
				$error = "Your information is removed successfully.";
			} else {
				$error = "System is corrupted, please try again later.";
			}
			oci_free_statement($gstmt);
		}
	}

	$sql = "SELECT cbs_id, cbs_department FROM cbs_departments ORDER BY cbs_id";
	$stmt = oci_parse($ora_conn, $sql);
	oci_execute($stmt);
	$nrows = oci_fetch_all($stmt, $result, null, null, OCI_FETCHSTATEMENT_BY_ROW);

	oci_free_statement($stmt);

	// OCI disconnect
	$oracle->disconnect();
?>