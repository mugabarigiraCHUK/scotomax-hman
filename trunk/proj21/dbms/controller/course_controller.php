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

	// Handle HTTP POST method
	if ( $_SERVER['REQUEST_METHOD'] == "POST" ) {
		if ( $_POST['course_id'] ) {
			$usql = "UPDATE course"
					." SET course_name=:course_name, course_fee=:course_fee, course_start=:course_start, course_end=:course_end"
					." WHERE course_id=:course_id";
			$ustmt = oci_parse($ora_conn, $usql);
			oci_bind_by_name($ustmt, ":course_name", iconv("UTF-8","TIS-620", $_POST["n_course_name"]));
			oci_bind_by_name($ustmt, ":course_fee", $_POST['n_course_fee']);
			oci_bind_by_name($ustmt, ":course_start", $_POST['n_course_start']);
			oci_bind_by_name($ustmt, ":course_end", $_POST['n_course_end']);
			oci_bind_by_name($ustmt, ":course_id", $_POST['course_id']);
			if (oci_execute($ustmt, OCI_COMMIT_ON_SUCCESS)) {
				$error = "Your information is updated successfully.";
			} else {
				$error = "System is corrupted, please try again later.";
			}
			oci_free_statement($ustmt);
		} else {
			$usql = "INSERT INTO course( course_id, course_name, course_fee, course_start, course_end)"
					." VALUES( :course_id, :course_name, :course_fee, :course_start, :course_end)";
			$ustmt = oci_parse($ora_conn, $usql);
			oci_bind_by_name($ustmt, ":course_id", $_POST['n_course_id']);
			oci_bind_by_name($ustmt, ":course_name", iconv("UTF-8","TIS-620", $_POST["n_course_name"]));
			oci_bind_by_name($ustmt, ":course_fee", $_POST['n_course_fee']);
			oci_bind_by_name($ustmt, ":course_start", $_POST['n_course_start']);
			oci_bind_by_name($ustmt, ":course_end", $_POST['n_course_end']);
			if (oci_execute($ustmt, OCI_COMMIT_ON_SUCCESS)) {
				$error = "Your information is inserted successfully.";
			} else {
				$error = "System is corrupted, please try again later.";
			}
			oci_free_statement($ustmt);
		}
	} else {
		if ( $_GET['course_id'] ) {
			$gsql = "SELECT course_id, course_name, course_fee, course_start, course_end FROM course WHERE course_id=:course_id";
			$gstmt = oci_parse($ora_conn, $gsql);
			oci_bind_by_name($gstmt, ":course_id", $_GET['course_id']);
			if (oci_execute($gstmt)) {
				while(oci_fetch($gstmt)) {
					$course_id = oci_result($gstmt, 'COURSE_ID');
					$course_name = iconv("TIS-620","UTF-8", oci_result($gstmt, 'COURSE_NAME'));
					$course_fee = oci_result($gstmt, 'COURSE_FEE');
					$course_start = oci_result($gstmt, 'COURSE_START');
					$course_end = oci_result($gstmt, 'COURSE_END');
				}
			} 
			oci_free_statement($gstmt);
		} else if ( $_GET['remove_id'] ) {
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
	}

	$sql = "SELECT course_id, course_name, course_fee, course_start, course_end FROM course ORDER BY course_id";
	$stmt = oci_parse($ora_conn, $sql);
	oci_execute($stmt);
	$nrows = oci_fetch_all($stmt, $result, null, null, OCI_FETCHSTATEMENT_BY_ROW);

	oci_free_statement($stmt);

	// OCI disconnect
	$oracle->disconnect();
?>