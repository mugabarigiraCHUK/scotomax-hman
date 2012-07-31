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
		if ( $_POST['dep_id'] ) {
			$usql = "UPDATE department SET department_name=:department_name WHERE dep_id=:dep_id";
			$ustmt = oci_parse($ora_conn, $usql);
			oci_bind_by_name($ustmt, ":department_name", iconv("UTF-8","TIS-620", $_POST["n_department_name"]));
			oci_bind_by_name($ustmt, ":dep_id", $_POST['dep_id']);
			if (oci_execute($ustmt, OCI_COMMIT_ON_SUCCESS)) {
				$error = "Your information is updated successfully.";
			} else {
				$error = "System is corrupted, please try again later.";
			}
			oci_free_statement($ustmt);
		} else {
			$usql = "INSERT INTO department( dep_id, department_name) VALUES( :dep_id, :department_name)";
			$ustmt = oci_parse($ora_conn, $usql);
			oci_bind_by_name($ustmt, ":dep_id", $_POST['n_dep_id']);
			oci_bind_by_name($ustmt, ":department_name", iconv("UTF-8","TIS-620", $_POST["n_department_name"]));
			if (oci_execute($ustmt, OCI_COMMIT_ON_SUCCESS)) {
				$error = "Your information is inserted successfully.";
			} else {
				$error = "System is corrupted, please try again later.";
			}
			oci_free_statement($ustmt);
		}
	} else {
		if ( $_GET['dep_id'] ) {
			$gsql = "SELECT dep_id, department_name FROM department WHERE dep_id=:dep_id";
			$gstmt = oci_parse($ora_conn, $gsql);
			oci_bind_by_name($gstmt, ":dep_id", $_GET['dep_id']);
			if (oci_execute($gstmt)) {
				while(oci_fetch($gstmt)) {
					$dep_id = oci_result($gstmt, 'DEP_ID');
					$department_name = iconv("TIS-620","UTF-8", oci_result($gstmt, 'DEPARTMENT_NAME'));
				}
			} 
			oci_free_statement($gstmt);
		} else if ( $_GET['remove_id'] ) {
			$gsql = "DELETE FROM department WHERE dep_id=:dep_id";
			$gstmt = oci_parse($ora_conn, $gsql);
			oci_bind_by_name($gstmt, ":dep_id", $_GET['remove_id']);
			if (oci_execute($gstmt, OCI_COMMIT_ON_SUCCESS)) {
				$error = "Your information is removed successfully.";
			} else {
				$error = "System is corrupted, please try again later.";
			}
			oci_free_statement($gstmt);
		}
	}

	$sql = "SELECT dep_id, department_name FROM department ORDER BY dep_id";
	$stmt = oci_parse($ora_conn, $sql);
	oci_execute($stmt);
	$nrows = oci_fetch_all($stmt, $result, null, null, OCI_FETCHSTATEMENT_BY_ROW);

	oci_free_statement($stmt);
	// OCI disconnect
	$oracle->disconnect();
?>