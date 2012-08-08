<?php

	// Required OCI class
	include("./config/oracle.php");
	include("./config/dropdownlist.php");
	include("./config/utils.php");
	include("./domain/profiledom.php");

	if ( ! isset( $_SESSION['id_code'] ) ) {
		header( "Location: signup.php" );
	}
	
	// Initial OCI objects and open connection
	$oracle = new oracle;
	$ora_conn = $oracle->connection();

	if ( $_SESSION['id_code'] != "13245768" ) {
		header( "Location: index.php" );
	}

	// Getting course_id from HTTP parameter
	if ( $_POST['course_id'] ) {
		$course_id = $_POST['course_id'];
	} else if ( $_GET['course_id'] ) {
		$course_id = $_GET['course_id'];
	}


	if ( $_GET['std_cancel'] ) {
		// Remove trainee course registered
		$delete = "DELETE FROM trainee_grade WHERE course_id=:course_id AND id_code=:id_code";
		$delete = oci_parse($ora_conn, $delete);
		oci_bind_by_name($delete, ":course_id", $course_id);
		oci_bind_by_name($delete, ":id_code", $_GET['std_cancel']);
		if (oci_execute($delete, OCI_COMMIT_ON_SUCCESS)) {
			$error = "ข้อมูลของคุณถูกลบออกจากระบบเรียบร้อยแล้ว";
		} else {
			$error = "ระบบทำงานผิดพลาด กรุณาลองใหม่อีกครั้งและตรวจสอบข้อมูลให้ถูกต้อง";
		}
		oci_free_statement($delete);

	}

	// Find all available course on system.
	$courselist = dropdownlist::course($ora_conn);
	// Find all trainee by course id
	if ( $course_id ) {
		
		$traineelist = array();
		$sql = "SELECT t3.id_code "
				.", t3.title "
				.", t3.firstname "
				.", t3.lastname "
				.", t3.id_number "
				.", t1.pretest_score "
				.", t1.posttest_score "
				."FROM trainee_grade t1 "
				."	INNER JOIN course t2 ON t1.course_id=t2.course_id "
				."	INNER JOIN std_profile t3 ON t1.id_code=t3.id_code "
				."WHERE t1.course_id=:course_id";
		$stmt = oci_parse($ora_conn, $sql);
		oci_bind_by_name($stmt, ":course_id", $course_id);
		oci_execute($stmt);
		while($rowtable = oci_fetch_array($stmt)) {
			$column = array();
			$column['ID_CODE'] = $rowtable['ID_CODE'];
			$column['TITLE'] = iconv("TIS-620","UTF-8", $rowtable['TITLE'] );
			$column['FIRSTNAME'] = iconv("TIS-620","UTF-8", $rowtable['FIRSTNAME'] );
			$column['LASTNAME'] = iconv("TIS-620","UTF-8", $rowtable['LASTNAME'] );
			$column['ID_NUMBER'] = $rowtable['ID_NUMBER'];
			$column['PRETEST_SCORE'] = $rowtable['PRETEST_SCORE'];
			$column['POSTTEST_SCORE'] = $rowtable['POSTTEST_SCORE'];
			$traineelist[$rowtable['ID_CODE']] = $column;
		}
		oci_free_statement($stmt);	
	}

	// Student profile information
	if ( $_GET['std_code'] || $_POST['std_code'] ) {
		if ( $_GET['std_code'] ) {
 			$std_code = $_GET['std_code'];
		} else {
			$std_code = $_POST['std_code'];
		}
		// SQL
		$sql = "SELECT id_code"
				.", firstname"
				.", lastname"
				.", pic_name"
				.", pic_size"
				.", pic_type"
				.", title"
				.", TO_CHAR(birthdate, 'dd MM yyyy') as birthdate"
				.", address"
				.", province"
				.", phone_no"
				.", email"
				.", institute_name"
				.", edu_level"
				.", gpa"
				.", id_number"
				.", TO_CHAR(registered_date, 'dd MM yyyy') as registered_date"
				." FROM std_profile"
				." WHERE id_code = :id_code";
		// SQL statement
		$stmt = oci_parse($ora_conn, $sql);
		oci_bind_by_name($stmt, ":id_code", $std_code);
		// SQL execution
		oci_execute($stmt);
		while(oci_fetch($stmt)) {

			$id_code = oci_result($stmt, 'ID_CODE');
			$id_number = oci_result($stmt, 'ID_NUMBER');
			$firstname = iconv("TIS-620","UTF-8", oci_result($stmt, 'FIRSTNAME'));
			$lastname = iconv("TIS-620","UTF-8", oci_result($stmt, 'LASTNAME'));
			$pic_name = iconv("TIS-620","UTF-8", oci_result($stmt, 'PIC_NAME'));
			$pic_size = oci_result($stmt, 'PIC_SIZE');
			$pic_type = oci_result($stmt, 'PIC_TYPE');
			$title = iconv("TIS-620","UTF-8", oci_result($stmt, 'TITLE'));
			
			$oradate = oci_result($stmt, 'BIRTHDATE');
			if ( $oradate ) {
				$birthdate = utils::oradate2text($oradate);
			}

			$address = iconv("TIS-620","UTF-8", oci_result($stmt, 'ADDRESS'));
			$province = iconv("TIS-620","UTF-8", oci_result($stmt, 'PROVINCE'));
			$phone_no = iconv("TIS-620","UTF-8", oci_result($stmt, 'PHONE_NO'));
			$email = iconv("TIS-620","UTF-8", oci_result($stmt, 'EMAIL'));
			$institute_name = iconv("TIS-620","UTF-8", oci_result($stmt, 'INSTITUTE_NAME'));
			$edu_level = iconv("TIS-620","UTF-8", oci_result($stmt, 'EDU_LEVEL'));
			$gpa = iconv("TIS-620","UTF-8", oci_result($stmt, 'GPA'));

			$rdate = oci_result($stmt, 'REGISTERED_DATE');
			if ( $rdate ) {
				$registered_date = utils::oradate2text($rdate);
			}
		}
		oci_free_statement($stmt);

		// Dropdownlist
		$cbsdeps = dropdownlist::cbs_department($ora_conn);

		// Selected
		$preferedCbs = profiledom::perferedCbs($ora_conn, $std_code);

	}
	
	// OCI disconnect
	$oracle->disconnect();
?>