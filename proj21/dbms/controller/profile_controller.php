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
	
	if ( isset( $_SERVER['REQUEST_METHOD'] ) ) {
		// Handle HTTP POST method
		if ( $_SERVER['REQUEST_METHOD'] == "POST" ) {
			
			if ( $_POST['changepwd'] ) {

				$pstmt = oci_parse($ora_conn, "UPDATE user_login SET passwd=:passwd WHERE id_code=:id_code");
				oci_bind_by_name($pstmt, ':passwd', iconv("UTF-8","TIS-620", $_POST["password"]));
				oci_bind_by_name($pstmt, ':id_code', $_SESSION['id_code']);
				// Oracle DML execution
				if (oci_execute($pstmt, OCI_COMMIT_ON_SUCCESS)) {
					$error = "รหัสผ่านของคุณถูกเปลี่ยนแปลงเรียบร้อย";
				} else {
					$error = "ระบบทำงานผิดพลาด กรุณาลองใหม่อีกครั้งและตรวจสอบข้อมูลให้ถูกต้อง";
				}
				oci_free_statement($pstmt);

			} else if ( $_POST['cbs'] ) {
				/*
				 * Update cbs_department data entry as mapping with course
				 */
				$cbs_ids = array();
				if ( $_POST['cbs_id'] ) {
					if ( is_array( $_POST['cbs_id'] ) ) {
						foreach ($_POST['cbs_id'] as $key => $value) {
							$cbs_ids[] = $value;	
						}
					} else {
						$cbs_ids[] = $_POST['cbs_id'];
					}
				}
				// Update cbs department mapped
				profiledom::profile_cbs( $ora_conn, $_SESSION['id_code'], $cbs_ids);
				$error = "ข้อมูลภาควิชาพาณิชฯ ถูกปรับปรุงเรียบร้อย";
			} else {
				// Update profile
				// OCI DML validate user authentication
				$pstmt = oci_parse($ora_conn, "UPDATE std_profile SET"
						."  firstname=:firstname"
						.", lastname=:lastname"
						.", title=:title"
						.", birthdate=TO_DATE(:birthdate, 'dd Mon yyyy hh24:mi:ss')"
						.", address=:address"
						.", province=:province"
						.", phone_no=:phone_no"
						.", email=:email"
						.", institute_name=:institute_name"
						.", edu_level=:edu_level"
						.", gpa=:gpa"
						.", id_number=:id_number"
						." WHERE id_code=:id_code");

				// Binding parameter into DML
				oci_bind_by_name($pstmt, ':id_code', $_SESSION['id_code']);

				oci_bind_by_name($pstmt, ':firstname', iconv("UTF-8","TIS-620", $_POST["firstname"]));
				oci_bind_by_name($pstmt, ':lastname', iconv("UTF-8","TIS-620", $_POST["lastname"]));
				oci_bind_by_name($pstmt, ':title', iconv("UTF-8","TIS-620", $_POST["title"]));

				if ( $_POST['birthdate'] ) {
					$bdate = utils::text2date($_POST["birthdate"]);
					if ( $bdate ) {
						oci_bind_by_name($pstmt, ':birthdate', date( "d M Y H:i:s", $bdate) );
					}
				}
				
				oci_bind_by_name($pstmt, ':address', iconv("UTF-8","TIS-620", $_POST["address"]));
				oci_bind_by_name($pstmt, ':province', iconv("UTF-8","TIS-620", $_POST["province"]));
				oci_bind_by_name($pstmt, ':phone_no', iconv("UTF-8","TIS-620", $_POST["phone_no"]));
				oci_bind_by_name($pstmt, ':email', iconv("UTF-8","TIS-620", $_POST["email"]));
				oci_bind_by_name($pstmt, ':institute_name', iconv("UTF-8","TIS-620", $_POST["institute_name"]));
				oci_bind_by_name($pstmt, ':edu_level', iconv("UTF-8","TIS-620", $_POST["edu_level"]));
				oci_bind_by_name($pstmt, ':gpa', iconv("UTF-8","TIS-620", $_POST["gpa"]));
				oci_bind_by_name($pstmt, ':id_number', iconv("UTF-8","TIS-620", $_POST["id_number"]));

				// Oracle DML execution
				if (oci_execute($pstmt, OCI_COMMIT_ON_SUCCESS)) {
					$error = "ข้อมูลของคุณถูกปรับปรุงเรียบร้อยแล้ว";
				} else {
					$error = "ระบบทำงานผิดพลาด กรุณาลองใหม่อีกครั้งและตรวจสอบข้อมูลให้ถูกต้อง";
				}
				oci_free_statement($pstmt);
			}
		}
	}
	
	if ( isset( $_SESSION['id_code'] ) ) {
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
		oci_bind_by_name($stmt, ":id_code", $_SESSION['id_code']);
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
		$preferedCbs = profiledom::perferedCbs($ora_conn, $_SESSION['id_code']);

	}
	
	// OCI disconnect
	$oracle->disconnect();
?>