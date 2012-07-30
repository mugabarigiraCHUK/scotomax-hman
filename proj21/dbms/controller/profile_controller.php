<?php

	// Required OCI class
	include("./config/oracle.php");
	include("./config/dropdownlist.php");
	include("./config/utils.php");
	
	// Initial OCI objects and open connection
	$oracle = new oracle;
	$ora_conn = $oracle->connection();
	
	// Dropdownlist
	$deptlist = dropdownlist::cbs_department($ora_conn);
	$courselist = dropdownlist::course($ora_conn);
	
	/*
	if ( isset( $_SERVER['REQUEST_METHOD'] ) ) {
		// Handle HTTP POST method
		if ( $_SERVER['REQUEST_METHOD'] == "POST" ) {
			
			if ( $_POST['changepwd'] ) {

			} else {

			}
		}
	}
	*/

	if ( isset( $_SESSION['id_code'] ) ) {
		// SQL
		$sql = "select id_code"
				.", firstname"
				.", lastname"
				.", pic"
				.", title"
				.", to_char(birthdate, 'dd MM yyyy') as birthdate"
				.", address"
				.", province"
				.", phone_no"
				.", email"
				.", institute_name"
				.", edu_level"
				.", gpa"
				.", id_number"
				.", to_char(registered_date, 'dd MM yyyy') as registered_date"
				." from std_profile"
				." where id_code = :id_code";
		// SQL statement
		$stmt = oci_parse($ora_conn, $sql);
		oci_bind_by_name($stmt, ":id_code", $_SESSION['id_code']);
		// SQL execution
		oci_execute($stmt);
		while(oci_fetch($stmt)) {
			$id_code = oci_result($stmt, 'ID_CODE');
			$id_number = oci_result($stmt, 'ID_NUMBER');
			$firstname = iconv("TIS-620","UTF-8", oci_result($stmt, 'FIRSTNAME'));
			$lastname = iconv("TIS-620","UTF-8", oci_result($stmt, 'LASTNAME'));
			$pic = iconv("TIS-620","UTF-8", oci_result($stmt, 'PIC'));
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
	} else {
		$error = "You have unauthorize access on this page.";
		header( "Location: signup.php" );
	}
	
	// OCI disconnect
	$oracle->disconnect();
?>