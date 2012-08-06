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
		if ( $_POST['classroom_id'] ) {
			$usql = "UPDATE classroom"
					." SET room_no=:room_no, max_seat=:max_seat, left_seat=:left_seat"
					." WHERE classroom_id=:classroom_id";
			$ustmt = oci_parse($ora_conn, $usql);
			oci_bind_by_name($ustmt, ":room_no", iconv("UTF-8","TIS-620", $_POST["n_room_no"]));
			oci_bind_by_name($ustmt, ":max_seat", $_POST['n_max_seat']);
			oci_bind_by_name($ustmt, ":left_seat", $_POST['n_left_seat']);
			oci_bind_by_name($ustmt, ":classroom_id", $_POST['classroom_id']);
			if (oci_execute($ustmt, OCI_COMMIT_ON_SUCCESS)) {
				$error = "Your information is updated successfully.";
			} else {
				$error = "System is corrupted, please try again later.";
			}
			oci_free_statement($ustmt);
		} else {
			$usql = "INSERT INTO classroom( classroom_id, room_no, max_seat, left_seat)"
					." VALUES( :classroom_id, :room_no, :max_seat, :left_seat)";
			$ustmt = oci_parse($ora_conn, $usql);
			oci_bind_by_name($ustmt, ":classroom_id", $_POST['n_classroom_id']);
			oci_bind_by_name($ustmt, ":room_no", iconv("UTF-8","TIS-620", $_POST["n_room_no"]));
			oci_bind_by_name($ustmt, ":max_seat", $_POST['n_max_seat']);
			oci_bind_by_name($ustmt, ":left_seat", $_POST['n_left_seat']);
			if (oci_execute($ustmt, OCI_COMMIT_ON_SUCCESS)) {
				$error = "Your information is inserted successfully.";
			} else {
				$error = "System is corrupted, please try again later.";
			}
			oci_free_statement($ustmt);
		}
	} else {
		if ( $_GET['classroom_id'] ) {
			$gsql = "SELECT classroom_id, room_no, max_seat, left_seat FROM classroom WHERE classroom_id=:classroom_id";
			$gstmt = oci_parse($ora_conn, $gsql);
			oci_bind_by_name($gstmt, ":classroom_id", $_GET['classroom_id']);
			if (oci_execute($gstmt)) {
				while(oci_fetch($gstmt)) {
					$classroom_id = oci_result($gstmt, 'CLASSROOM_ID');
					$room_no = iconv("TIS-620","UTF-8", oci_result($gstmt, 'ROOM_NO'));
					$max_seat = oci_result($gstmt, 'MAX_SEAT');
					$left_seat = oci_result($gstmt, 'LEFT_SEAT');
				}
			} 
			oci_free_statement($gstmt);
		} else if ( $_GET['remove_id'] ) {
			$gsql = "DELETE FROM classroom WHERE classroom_id=:classroom_id";
			$gstmt = oci_parse($ora_conn, $gsql);
			oci_bind_by_name($gstmt, ":classroom_id", $_GET['remove_id']);
			if (oci_execute($gstmt, OCI_COMMIT_ON_SUCCESS)) {
				$error = "Your information is removed successfully.";
			} else {
				$error = "System is corrupted, please try again later.";
			}
			oci_free_statement($gstmt);
		}
	}

	$sql = "SELECT classroom_id, room_no, max_seat, left_seat FROM classroom ORDER BY classroom_id";
	$stmt = oci_parse($ora_conn, $sql);
	oci_execute($stmt);
	$nrows = oci_fetch_all($stmt, $result, null, null, OCI_FETCHSTATEMENT_BY_ROW);

	oci_free_statement($stmt);
	
	// OCI disconnect
	$oracle->disconnect();

?>