<?php

	// Required OCI class
	include("./config/oracle.php");
	include("./config/dropdownlist.php");

	if ( $_SESSION['id_code'] != "13245768" ) {
		header( "Location: index.php" );
	}
	
	// Initial OCI objects and open connection
	$oracle = new oracle;
	$ora_conn = $oracle->connection();

	// Handle HTTP POST method
	if ( $_SERVER['REQUEST_METHOD'] == "POST" ) {
		if ( $_POST['exam_no'] ) {
			$usql = "UPDATE exam_series"
					." SET full_score=:full_score"
					.", exam_description=:exam_description"
					.", course_id=:course_id"
					." WHERE exam_no=:exam_no";
			$ustmt = oci_parse($ora_conn, $usql);
			oci_bind_by_name($ustmt, ":full_score", $_POST['n_full_score']);
			oci_bind_by_name($ustmt, ":exam_description", iconv("UTF-8","TIS-620", $_POST["n_exam_desc"]));
			oci_bind_by_name($ustmt, ":course_id", $_POST['n_course_id']);
			oci_bind_by_name($ustmt, ":exam_no", $_POST['exam_no']);

			if (oci_execute($ustmt, OCI_COMMIT_ON_SUCCESS)) {
				$error = "ข้อมูลของคุณถูกปรับปรุงเรียบร้อยแล้ว";
			} else {
				$error = "ระบบทำงานผิดพลาด กรุณาลองใหม่อีกครั้งและตรวจสอบข้อมูลให้ถูกต้อง";
			}
			oci_free_statement($ustmt);
		} else {
			$usql = "INSERT INTO exam_series( exam_no, full_score, exam_description, course_id)"
					." VALUES( :exam_no, :full_score, :exam_description, :course_id)";
			$ustmt = oci_parse($ora_conn, $usql);
			oci_bind_by_name($ustmt, ":exam_no", $_POST['n_exam_no']);
			oci_bind_by_name($ustmt, ":full_score", $_POST['n_full_score']);
			oci_bind_by_name($ustmt, ":exam_description", iconv("UTF-8","TIS-620", $_POST["n_exam_desc"]));
			oci_bind_by_name($ustmt, ":course_id", $_POST['n_course_id']);

			if (oci_execute($ustmt, OCI_COMMIT_ON_SUCCESS)) {
				$error = "ข้อมูลของคุณถูกเพิ่มเข้าในระบบเรียบร้อยแล้ว";
			} else {
				$error = "ระบบทำงานผิดพลาด กรุณาลองใหม่อีกครั้งและตรวจสอบข้อมูลให้ถูกต้อง";
			}
			oci_free_statement($ustmt);
		}
	} else {
		if ( $_GET['exam_no'] ) {
			$gsql = "SELECT exam_no, full_score, exam_description, course_id"
					." FROM exam_series"
					." WHERE exam_no=:exam_no";
			$gstmt = oci_parse($ora_conn, $gsql);
			oci_bind_by_name($gstmt, ":exam_no", $_GET['exam_no']);
			if (oci_execute($gstmt)) {
				while(oci_fetch($gstmt)) {
					$exam_no = oci_result($gstmt, 'EXAM_NO');
					$full_score = oci_result($gstmt, 'FULL_SCORE');
					$exam_desc = iconv("TIS-620","UTF-8", oci_result($gstmt, 'EXAM_DESCRIPTION'));
					$course_id = oci_result($gstmt, 'COURSE_ID');
				}
			} 
			oci_free_statement($gstmt);
		} else if ( $_GET['remove_id'] ) {
			$gsql = "DELETE FROM exam_series WHERE exam_no=:exam_no";
			$gstmt = oci_parse($ora_conn, $gsql);
			oci_bind_by_name($gstmt, ":exam_no", $_GET['remove_id']);
			if (oci_execute($gstmt, OCI_COMMIT_ON_SUCCESS)) {
				$error = "ข้อมูลของคุณถูกลบออกจากระบบเรียบร้อยแล้ว";
			} else {
				$error = "ระบบทำงานผิดพลาด กรุณาลองใหม่อีกครั้งและตรวจสอบข้อมูลให้ถูกต้อง";
			}
			oci_free_statement($gstmt);
		}
	}

	$sql = "SELECT t1.exam_no, t1.full_score, t1.exam_description, t2.course_name"
			." FROM exam_series t1"
			."	LEFT OUTER JOIN course t2 ON t1.course_id=t2.course_id"
			." ORDER BY t2.course_id, t1.exam_no";
	$stmt = oci_parse($ora_conn, $sql);
	oci_execute($stmt);
	$nrows = oci_fetch_all($stmt, $result, null, null, OCI_FETCHSTATEMENT_BY_ROW);

	oci_free_statement($stmt);

	// Dropdownlist
	$courses = dropdownlist::course($ora_conn);
	//echo " --> ".count($courses)."</br>";

	// OCI disconnect
	$oracle->disconnect();
?>