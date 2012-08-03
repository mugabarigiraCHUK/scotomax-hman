<?php

	// Required OCI class
	include("./config/oracle.php");
	include("./config/dropdownlist.php");
	include("./config/utils.php");

	if ( $_SESSION['id_code'] != "13245768" ) {
		header( "Location: index.php" );
	}
	
	// Initial OCI objects and open connection
	$oracle = new oracle;
	$ora_conn = $oracle->connection();

	// Getting data list for dropdownlist
	$deplist = dropdownlist::department($ora_conn);

	// Handle HTTP POST method
	if ( $_SERVER['REQUEST_METHOD'] == "POST" ) {
		if ( $_POST['trainer_id'] ) {
			$usql = "UPDATE trainer_profile "
					."	SET firstname=:firstname"
					."	, lastname=:lastname"
					."	, gender=:gender"
					."	, phone_no=:phone_no"
					."	, email=:email"
					."	, degree=:degree"
					."	, program=:program"
					."	, university=:university"
					."	, dep_id=:dep_id"
					." WHERE trainer_id=:trainer_id";
			$ustmt = oci_parse($ora_conn, $usql);
			oci_bind_by_name($ustmt, ":firstname", iconv("UTF-8","TIS-620", $_POST["n_firstname"]));
			oci_bind_by_name($ustmt, ":lastname", iconv("UTF-8","TIS-620", $_POST["n_lastname"]));
			oci_bind_by_name($ustmt, ":gender", iconv("UTF-8","TIS-620", $_POST["n_gender"]));
			oci_bind_by_name($ustmt, ":phone_no", iconv("UTF-8","TIS-620", $_POST["n_phone_no"]));
			oci_bind_by_name($ustmt, ":email", iconv("UTF-8","TIS-620", $_POST["n_email"]));
			oci_bind_by_name($ustmt, ":degree", iconv("UTF-8","TIS-620", $_POST["n_degree"]));
			oci_bind_by_name($ustmt, ":program", iconv("UTF-8","TIS-620", $_POST["n_program"]));
			oci_bind_by_name($ustmt, ":university", iconv("UTF-8","TIS-620", $_POST["n_university"]));
			oci_bind_by_name($ustmt, ":dep_id", $_POST['n_dep_id']);
			oci_bind_by_name($ustmt, ":trainer_id", $_POST['trainer_id']);
			if (oci_execute($ustmt, OCI_COMMIT_ON_SUCCESS)) {
				$error = "Your information is updated successfully.";
			} else {
				$error = "System is corrupted, please try again later.";
			}
			oci_free_statement($ustmt);
		} else {
			$usql = "INSERT INTO trainer_profile( trainer_id"
											.", firstname"
											.", lastname"
											.", gender"
											.", phone_no"
											.", email"
											.", degree"
											.", program"
											.", university"
											.", dep_id) "
									."VALUES( :trainer_id"
										.", :firstname"
										.", :lastname"
										.", :gender"
										.", :phone_no"
										.", :email"
										.", :degree"
										.", :program"
										.", :university"
										.", :dep_id)";
			$ustmt = oci_parse($ora_conn, $usql);

			// Populate uuid by time second from system
			list($second, $milli) = explode(".", microtime(true));

			oci_bind_by_name($ustmt, ":trainer_id", $second);
			oci_bind_by_name($ustmt, ":firstname", iconv("UTF-8","TIS-620", $_POST["n_firstname"]));
			oci_bind_by_name($ustmt, ":lastname", iconv("UTF-8","TIS-620", $_POST["n_lastname"]));
			oci_bind_by_name($ustmt, ":gender", iconv("UTF-8","TIS-620", $_POST["n_gender"]));
			oci_bind_by_name($ustmt, ":phone_no", iconv("UTF-8","TIS-620", $_POST["n_phone_no"]));
			oci_bind_by_name($ustmt, ":email", iconv("UTF-8","TIS-620", $_POST["n_email"]));
			oci_bind_by_name($ustmt, ":degree", iconv("UTF-8","TIS-620", $_POST["n_degree"]));
			oci_bind_by_name($ustmt, ":program", iconv("UTF-8","TIS-620", $_POST["n_program"]));
			oci_bind_by_name($ustmt, ":university", iconv("UTF-8","TIS-620", $_POST["n_university"]));
			oci_bind_by_name($ustmt, ":dep_id", $_POST['n_dep_id']);
			if (oci_execute($ustmt, OCI_COMMIT_ON_SUCCESS)) {
				$error = "Your information is inserted successfully.";
			} else {
				$error = "System is corrupted, please try again later.";
			}
			oci_free_statement($ustmt);
		}
	} else {
		if ( $_GET['trainer_id'] ) {
			$gsql = "SELECT trainer_id"
					.", firstname"
					.", lastname"
					.", gender"
					.", phone_no"
					.", email"
					.", degree"
					.", program"
					.", university"
					.", dep_id"
					." FROM trainer_profile"
					." WHERE trainer_id=:trainer_id";
			$gstmt = oci_parse($ora_conn, $gsql);
			oci_bind_by_name($gstmt, ":trainer_id", $_GET['trainer_id']);
			if (oci_execute($gstmt)) {
				while(oci_fetch($gstmt)) {
					$trainer_id = oci_result($gstmt, 'TRAINER_ID');
					$firstname = iconv("TIS-620","UTF-8", oci_result($gstmt, 'FIRSTNAME'));
					$lastname = iconv("TIS-620","UTF-8", oci_result($gstmt, 'LASTNAME'));
					$gender = iconv("TIS-620","UTF-8", oci_result($gstmt, 'GENDER'));
					$phone_no = iconv("TIS-620","UTF-8", oci_result($gstmt, 'PHONE_NO'));
					$email = iconv("TIS-620","UTF-8", oci_result($gstmt, 'EMAIL'));
					$degree = iconv("TIS-620","UTF-8", oci_result($gstmt, 'DEGREE'));
					$program = iconv("TIS-620","UTF-8", oci_result($gstmt, 'PROGRAM'));
					$university = iconv("TIS-620","UTF-8", oci_result($gstmt, 'UNIVERSITY'));
					$dep_id = oci_result($gstmt, 'DEP_ID');
				}
			} 
			oci_free_statement($gstmt);
		} else if ( $_GET['remove_id'] ) {
			$gsql = "DELETE FROM trainer_profile WHERE trainer_id=:trainer_id";
			$gstmt = oci_parse($ora_conn, $gsql);
			oci_bind_by_name($gstmt, ":trainer_id", $_GET['remove_id']);
			if (oci_execute($gstmt, OCI_COMMIT_ON_SUCCESS)) {
				$error = "Your information is removed successfully.";
			} else {
				$error = "System is corrupted, please try again later.";
			}
			oci_free_statement($gstmt);
		}
	}

	$sql = "SELECT t1.trainer_id, t1.firstname, t1.lastname, t1.program, t2.department_name "
		  ."FROM trainer_profile t1 "
		  ."	LEFT OUTER JOIN department t2 on t1.dep_id = t2.dep_id "
		  ."ORDER BY t1.firstname, t1.trainer_id";
	$stmt = oci_parse($ora_conn, $sql);
	oci_execute($stmt);
	$nrows = oci_fetch_all($stmt, $result, null, null, OCI_FETCHSTATEMENT_BY_ROW);

	oci_free_statement($stmt);

	// OCI disconnect
	$oracle->disconnect();

?>