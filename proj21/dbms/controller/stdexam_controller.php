<?php

	// Required OCI class
	include("./config/oracle.php");

	if ( ! isset( $_SESSION['id_code'] ) ) {
		header( "Location: signup.php" );
	}

	
	// Initial OCI objects and open connection
	$oracle = new oracle;
	$ora_conn = $oracle->connection();

	if ( $_POST['std_exam'] ) {
		$yourscore = 0;
		$numb = 1;

		$right = $_POST['right'.$numb];
		//echo " right -> ".$right."<br/>";
		while ( isset( $right ) ) {
			if ( $right == $_POST['ans'.$numb] ) {
				$yourscore++;
			}
			$numb++;
			$right = $_POST['right'.$numb];
			//echo " right -> ".$right."<br/>";
		}
		//echo " yourscore -> ".$yourscore."<br/>";

		// Keeping score
		$test = $_POST['test'];
		$exam_no = $_POST['exam_no'];
		$course_id = $_POST['course_id'];
		if ( $test == 'Pre-test' ) {
			$usql = "UPDATE trainee_grade"
					." SET pretest_score=:pretest_score"
					." WHERE exam_no=:exam_no"
					." AND course_id=:course_id"
					." AND id_code=:id_code";
			$ustmt = oci_parse($ora_conn, $usql);
			
			oci_bind_by_name($ustmt, ":pretest_score", $yourscore);
			oci_bind_by_name($ustmt, ":exam_no", $exam_no);
			oci_bind_by_name($ustmt, ":course_id", $course_id);
			oci_bind_by_name($ustmt, ":id_code", $_SESSION['id_code']);

			if (oci_execute($ustmt, OCI_COMMIT_ON_SUCCESS)) {
				$error = "ข้อมูลของคุณถูกเพิ่มเข้าในระบบเรียบร้อยแล้ว";
			} else {
				$error = "ระบบทำงานผิดพลาด กรุณาลองใหม่อีกครั้งและตรวจสอบข้อมูลให้ถูกต้อง";
			}
			oci_free_statement($ustmt);
		} else {
			$usql = "UPDATE trainee_grade"
					." SET posttest_score=:posttest_score"
					." WHERE exam_no=:exam_no"
					." AND course_id=:course_id"
					." AND id_code=:id_code";
			$ustmt = oci_parse($ora_conn, $usql);
			
			oci_bind_by_name($ustmt, ":posttest_score", $yourscore);
			oci_bind_by_name($ustmt, ":exam_no", $exam_no);
			oci_bind_by_name($ustmt, ":course_id", $course_id);
			oci_bind_by_name($ustmt, ":id_code", $_SESSION['id_code']);

			if (oci_execute($ustmt, OCI_COMMIT_ON_SUCCESS)) {
				$error = "ข้อมูลของคุณถูกเพิ่มเข้าในระบบเรียบร้อยแล้ว";
			} else {
				$error = "ระบบทำงานผิดพลาด กรุณาลองใหม่อีกครั้งและตรวจสอบข้อมูลให้ถูกต้อง";
			}
			oci_free_statement($ustmt);
		}
	}

	if ( $_POST['exam_no'] ) {
		// Find all questions of exam
		$exam_no = $_POST['exam_no'];
		$sql = "SELECT item, question, ans1, ans2, ans3, ans4, ans "
				." FROM exam WHERE exam_no=:exam_no";
		$stmt = oci_parse($ora_conn, $sql);
		oci_bind_by_name($stmt, ":exam_no", $exam_no);
		oci_execute($stmt);
		$nrows = oci_fetch_all($stmt, $exlist, null, null, OCI_FETCHSTATEMENT_BY_ROW);
		oci_free_statement($stmt);
		// Find course - exam information by trainee
		$sql = "SELECT t1.exam_no, t1.id_code, t1.course_id"
			." FROM trainee_grade t1"
			." 	INNER JOIN exam_series t2 ON t1.exam_no = t2.exam_no"
			." 	INNER JOIN course t3 ON t1.course_id = t3.course_id"
			." WHERE t1.id_code=:id_code AND t1.exam_no=:exam_no ";
		$stmt = oci_parse($ora_conn, $sql);
		oci_bind_by_name($stmt, ":id_code", $_SESSION['id_code']);
		oci_bind_by_name($stmt, ":exam_no", $exam_no);
		oci_execute($stmt);
		while($rowtable = oci_fetch_array($stmt)) {
			$exam_no = $rowtable['EXAM_NO'];
			$id_code = $rowtable['ID_CODE'];
			$course_id = $rowtable['COURSE_ID'];
		}
		oci_free_statement($stmt);	
	} 

	$examlist = array();
	$gsql = "SELECT t2.exam_no, t2.exam_description, t3.course_name"
			." FROM trainee_grade t1"
			." 	INNER JOIN exam_series t2 ON t1.exam_no = t2.exam_no"
			." 	INNER JOIN course t3 ON t1.course_id = t3.course_id"
			." WHERE t1.id_code=:id_code"
			." ORDER BY t3.course_id DESC";
	$gstmt = oci_parse($ora_conn, $gsql);
	oci_bind_by_name($gstmt, ":id_code", $_SESSION['id_code']);
	oci_execute($gstmt);
	while($rowtable = oci_fetch_array($gstmt)) {
		$column = array();
		$column['EXAM_NO'] = $rowtable['EXAM_NO'];
		$column['EXAM_DESCRIPTION'] = iconv("TIS-620","UTF-8", $rowtable['EXAM_DESCRIPTION']);
		$column['COURSE_NAME'] = iconv("TIS-620","UTF-8", $rowtable['COURSE_NAME']);
		$examlist[$rowtable['EXAM_NO']] = $column;
	}

	oci_free_statement($gstmt);	

	// OCI disconnect
	$oracle->disconnect();
	
?>