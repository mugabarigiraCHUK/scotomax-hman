<?php

	// Required OCI class
	include("./config/oracle.php");
	include("./domain/registerdom.php");
	include("./domain/coursedom.php");
	include("./domain/schedule.php");
	include("./config/utils.php");
	
	if ( ! isset( $_SESSION['id_code'] ) ) {
		header( "Location: signup.php" );
	}
	
	// Initial OCI objects and open connection
	$oracle = new oracle;
	$ora_conn = $oracle->connection();
	
	// Dropdownlist
	$courselist = registerdom::course($ora_conn, $_SESSION['id_code']);
	
	if ( $_GET['course_id'] ) {
		$course_id = $_GET['course_id'];
	} else if ( $_POST['course_id'] ) {
		$course_id = $_POST['course_id'];
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
				$examlist = registerdom::selectedExam($ora_conn, $course_id, $_SESSION['id_code']);
			}
		} 
		oci_free_statement($cstmt);
	}
	
	// OCI disconnect
	$oracle->disconnect();
?>