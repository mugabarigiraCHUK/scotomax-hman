<?php

	// Required OCI class
	include("./config/oracle.php");

	if ( $_SESSION['id_code'] != "13245768" ) {
		header( "Location: index.php" );
	}

	if ( $_GET['exam_no'] ) {
		$exam_no = $_GET['exam_no'];
	} else {
		$exam_no = $_POST['exam_no'];
	}

	if ( $exam_no ) {
		// Initial OCI objects and open connection
		$oracle = new oracle;
		$ora_conn = $oracle->connection();

		// Handle HTTP POST method
		if ( $_SERVER['REQUEST_METHOD'] == "POST" ) {
			$usql = "INSERT INTO exam( item, question, ans1, ans2, ans3, ans4, ans, exam_no)"
					." VALUES( :item, :question, :ans1, :ans2, :ans3, :ans4, :ans, :exam_no)";
			$ustmt = oci_parse($ora_conn, $usql);
			oci_bind_by_name($ustmt, ":item", $_POST['item']);
			oci_bind_by_name($ustmt, ":question", iconv("UTF-8","TIS-620", $_POST["question"]));
			oci_bind_by_name($ustmt, ":ans1", iconv("UTF-8","TIS-620", $_POST["ans1"]));
			oci_bind_by_name($ustmt, ":ans2", iconv("UTF-8","TIS-620", $_POST["ans2"]));
			oci_bind_by_name($ustmt, ":ans3", iconv("UTF-8","TIS-620", $_POST["ans3"]));
			oci_bind_by_name($ustmt, ":ans4", iconv("UTF-8","TIS-620", $_POST["ans4"]));
			oci_bind_by_name($ustmt, ":ans", $_POST['ans']);
			oci_bind_by_name($ustmt, ":exam_no", $exam_no);

			if (oci_execute($ustmt, OCI_COMMIT_ON_SUCCESS)) {
				$error = "ข้อมูลของคุณถูกเพิ่มเข้าในระบบเรียบร้อยแล้ว";
			} else {
				$error = "ระบบทำงานผิดพลาด กรุณาลองใหม่อีกครั้งและตรวจสอบข้อมูลให้ถูกต้อง";
			}
			oci_free_statement($ustmt);
		} else if ( $_GET["remove_id"] ) {
			$gsql = "DELETE FROM exam WHERE item=:item";
			$gstmt = oci_parse($ora_conn, $gsql);
			oci_bind_by_name($gstmt, ":item", $_GET['remove_id']);
			if (oci_execute($gstmt, OCI_COMMIT_ON_SUCCESS)) {
				$error = "ข้อมูลของคุณถูกลบออกจากระบบเรียบร้อยแล้ว";
			} else {
				$error = "ระบบทำงานผิดพลาด กรุณาลองใหม่อีกครั้งและตรวจสอบข้อมูลให้ถูกต้อง";
			}
			oci_free_statement($gstmt);
		}

		$gsql = "SELECT t1.full_score, t1.exam_description, t2.course_name"
				." FROM exam_series t1"
				." 	LEFT OUTER JOIN course t2 ON t1.course_id = t2.course_id"
				." WHERE t1.exam_no=:exam_no";
		$gstmt = oci_parse($ora_conn, $gsql);
		oci_bind_by_name($gstmt, ":exam_no", $exam_no);
		if (oci_execute($gstmt)) {
			while(oci_fetch($gstmt)) {
				$full_score = oci_result($gstmt, 'FULL_SCORE');
				$exam_desc = iconv("TIS-620","UTF-8", oci_result($gstmt, 'EXAM_DESCRIPTION'));
				$course_name = iconv("TIS-620","UTF-8", oci_result($gstmt, 'COURSE_NAME'));
			}
		} 
		oci_free_statement($gstmt);

		$sql = "SELECT item, question, ans1, ans2, ans3, ans4, ans "
				." FROM exam WHERE exam_no=:exam_no";
		$stmt = oci_parse($ora_conn, $sql);
		oci_bind_by_name($stmt, ":exam_no", $exam_no);
		oci_execute($stmt);
		$nrows = oci_fetch_all($stmt, $result, null, null, OCI_FETCHSTATEMENT_BY_ROW);

		oci_free_statement($stmt);

		// OCI disconnect
		$oracle->disconnect();
	} else {
		header( "Location: series.php" );
	}
	
	
?>