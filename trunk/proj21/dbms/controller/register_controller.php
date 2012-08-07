<?php

	// Required OCI class
	include("./config/oracle.php");
	include("./config/dropdownlist.php");
	include("./domain/coursedom.php");
	include("./domain/schedule.php");
	include("./config/utils.php");
	
	// Initial OCI objects and open connection
	$oracle = new oracle;
	$ora_conn = $oracle->connection();
	
	// Dropdownlist
	$courselist = Dropdownlist::course($ora_conn);
	
	if ( $_GET['course_id'] ) {
		$course_id = $_GET['course_id'];
	} else if ( $_POST['course_id'] ) {
		$course_id = $_POST['course_id'];
	}

	// Handle HTTP POST method
	if ( $_SERVER['REQUEST_METHOD'] == "POST" ) {
		// TODO
		if ( $_POST['course'] ) {
			if ( ! $_POST['exam_no'] ) {
				$error = "คุณจำเป็นต้องเลือกแบบทดสอบด้วยครับ.";
			} else {
				$id_code = $_SESSION['id_code'];
				$exam_no = $_POST['exam_no'];

				$usql = "INSERT INTO trainee_grade( id_code"
						.", course_id"
						.", exam_no)"
						." VALUES( :id_code"
						.", :course_id"
						.", :exam_no)";
				$ustmt = oci_parse($ora_conn, $usql);
				oci_bind_by_name($ustmt, ":id_code", $id_code);
				oci_bind_by_name($ustmt, ":course_id", $course_id);
				oci_bind_by_name($ustmt, ":exam_no", $exam_no);

				if (oci_execute($ustmt, OCI_COMMIT_ON_SUCCESS)) {
					$error = "Your information is inserted successfully.";
				} else {
					$error = "System is corrupted, please try again later.";
				}
				oci_free_statement($ustmt);
			}
		} 
	}
	

	if ( $course_id ) {

		$csql = "SELECT course_id"
				.", course_name"
				.", course_fee"
				.", TO_CHAR(course_start, 'dd MM yyyy') as course_start"
				.", TO_CHAR(course_end, 'dd MM yyyy') as course_end"
				." FROM course"
				." WHERE course_id=:course_id"
				." ORDER BY course_id DESC";
		$cstmt = oci_parse($ora_conn, $csql);
		oci_bind_by_name($cstmt, ":course_id", $course_id);

		if ( oci_execute($cstmt) ) {
			while( oci_fetch($cstmt) ) {

				$course_name = iconv("TIS-620","UTF-8", oci_result($cstmt, 'COURSE_NAME'));
				$course_fee = oci_result($cstmt, 'COURSE_FEE');

				$date_start = oci_result($cstmt, 'COURSE_START');
				$course_start = utils::oradate2text($date_start);
				
				$date_end = oci_result($cstmt, 'COURSE_END');
				$course_end = utils::oradate2text($date_end);

				$classelist = coursedom::selectedClass($ora_conn, $course_id);
				$schedulelist = schedule::findall($ora_conn, $course_id);
				$cbslist = coursedom::selectedCbs($ora_conn, $course_id);
				$trainerlist = coursedom::selectedTrainer($ora_conn, $course_id);
				$examlist = coursedom::selectedExam($ora_conn, $course_id);
			}
		} 
		oci_free_statement($cstmt);
	}
	
	// OCI disconnect
	$oracle->disconnect();
?>