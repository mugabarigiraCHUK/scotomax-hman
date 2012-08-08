<?php

	// Required OCI class
	include("./config/oracle.php");
	include("./config/dropdownlist.php");
	include("./config/utils.php");
	
	// Initial OCI objects and open connection
	$oracle = new oracle();
	$ora_conn = $oracle->connection();
	
	if ( isset( $_SERVER['REQUEST_METHOD'] ) ) {
		
		// Handle HTTP POST method
		if ( $_SERVER['REQUEST_METHOD'] == "POST" ) {

			$uvalid_stmt = oci_parse($ora_conn, "SELECT username FROM user_login WHERE username=:username");
			oci_bind_by_name($uvalid_stmt, ':username', iconv("UTF-8","TIS-620", $_POST["username"]));

			oci_execute($uvalid_stmt);
			//$nrows = oci_fetch_all($uvalid_stmt, $result, null, null, OCI_FETCHSTATEMENT_BY_ROW);
			$nrows = oci_fetch_all($uvalid_stmt, $result);

			if ( $nrows > 0 ) {
				$error = $result[0][0]." มีอยู่ในระบบแล้ว, กรุณาใช้ชื่ออื่น";

			} else {
			
				// Populate uuid by time second from system
				list($second, $milli) = explode(".", microtime(true));

				// OCI DML for register username
				$user_stmt = oci_parse($ora_conn, "INSERT INTO user_login(id_code, username, passwd, last_login)"
						." VALUES(:id_code, :username, :passwd, sysdate)");

				// Binding parameter into DML
				oci_bind_by_name($user_stmt, ':id_code', $second);
				oci_bind_by_name($user_stmt, ':username', iconv("UTF-8","TIS-620", $_POST["username"]));
				oci_bind_by_name($user_stmt, ':passwd', iconv("UTF-8","TIS-620", $_POST["password"]));

				if (oci_execute($user_stmt, OCI_NO_AUTO_COMMIT)) {
					
					// OCI DML validate user authentication
					$profile_stmt = oci_parse($ora_conn, "INSERT INTO std_profile( id_code"
							.", firstname"
							.", lastname"
							.", title"
							.", birthdate"
							.", address"
							.", province"
							.", phone_no"
							.", email"
							.", institute_name"
							.", edu_level"
							.", gpa"
							.", id_number"
							.", registered_date)"
							."	VALUES( :id_code"
							.", :firstname"
							.", :lastname"
							.", :title"
							.", TO_DATE(:birthdate, 'dd Mon yyyy hh24:mi:ss')"
							.", :address"
							.", :province"
							.", :phone_no"
							.", :email"
							.", :institute_name"
							.", :edu_level"
							.", :gpa"
							.", :id_number"
							.", SYSDATE)");

					// Binding parameter into DML
					oci_bind_by_name($profile_stmt, ':id_code', $second);
					oci_bind_by_name($profile_stmt, ':firstname', iconv("UTF-8","TIS-620", $_POST["firstname"]));
					oci_bind_by_name($profile_stmt, ':lastname', iconv("UTF-8","TIS-620", $_POST["lastname"]));
					oci_bind_by_name($profile_stmt, ':title', iconv("UTF-8","TIS-620", $_POST["title"]));

					if ( $_POST['birthdate'] ) {
						$bdate = utils::text2date($_POST["birthdate"]);
						if ( $bdate ) {
							oci_bind_by_name($profile_stmt, ':birthdate', date( "d M Y H:i:s", $bdate) );
						}
					}
					
					oci_bind_by_name($profile_stmt, ':address', iconv("UTF-8","TIS-620", $_POST["address"]));
					oci_bind_by_name($profile_stmt, ':province', iconv("UTF-8","TIS-620", $_POST["province"]));
					oci_bind_by_name($profile_stmt, ':phone_no', iconv("UTF-8","TIS-620", $_POST["phone_no"]));
					oci_bind_by_name($profile_stmt, ':email', iconv("UTF-8","TIS-620", $_POST["email"]));
					oci_bind_by_name($profile_stmt, ':institute_name', iconv("UTF-8","TIS-620", $_POST["institute_name"]));
					oci_bind_by_name($profile_stmt, ':edu_level', iconv("UTF-8","TIS-620", $_POST["edu_level"]));
					oci_bind_by_name($profile_stmt, ':gpa', iconv("UTF-8","TIS-620", $_POST["gpa"]));
					oci_bind_by_name($profile_stmt, ':id_number', iconv("UTF-8","TIS-620", $_POST["id_number"]));

					// Oracle DML execution
					if (oci_execute($profile_stmt, OCI_COMMIT_ON_SUCCESS)) {

						// Keep user information on HTTP session
						$_SESSION['id_code'] = $second;
						$_SESSION['username'] = $_POST["username"];
						
						header( "Location: profile.php" );
					} else {
						$ora_err = oci_error($ora_conn);
						if ($ora_err) {
							$error = "ระบบทำงานผิดพลาดในการลงทะเบียนของคุณ กรุณาลองใหม่ภายหลัง, error: ".$ora_err;
						} else {
							$error = "ระบบทำงานผิดพลาดในการลงทะเบียนของคุณ กรุณาลองใหม่ภายหลัง";
						}
					}

					oci_free_statement($profile_stmt);

				} else { 
					$ora_err = oci_error($ora_conn);
					if ($ora_err) {
						$error = "ระบบทำงานผิดพลาดในการลงทะเบียนของคุณ กรุณาลองใหม่ภายหลัง, error: ".$ora_err;
					} else {
						$error = "ระบบทำงานผิดพลาดในการลงทะเบียนของคุณ กรุณาลองใหม่ภายหลัง";
					}
				}

				oci_free_statement($user_stmt);
			}

			oci_free_statement($uvalid_stmt);
		}
	}
	
	// OCI disconnect
	$oracle->disconnect();
?>