<?php

	// Required OCI class
	include("./config/oracle.php");
	include("./config/dropdownlist.php");
	include("./config/utils.php");
	include("./domain/coursedom.php");
	include("./domain/schedule.php");

	if ( $_SESSION['id_code'] != "13245768" ) {
		header( "Location: index.php" );
	}
	
	// Initial OCI objects and open connection
	$oracle = new oracle;
	$ora_conn = $oracle->connection();

	// Handle HTTP POST method
	if ( $_SERVER['REQUEST_METHOD'] == "POST" ) {
		// Getting course_id from HTTP attributes.
		$course_id = $_POST['course_id'];

		if ( $_POST['course'] ) {
			if ( $course_id ) {
				$usql = "UPDATE course"
						." SET course_name=:course_name, "
						."	course_fee=:course_fee, "
						."	course_start=TO_DATE(:course_start, 'dd Mon yyyy hh24:mi:ss'), "
						."	course_end=TO_DATE(:course_end, 'dd Mon yyyy hh24:mi:ss')"
						." WHERE course_id=:course_id";
				$ustmt = oci_parse($ora_conn, $usql);
				oci_bind_by_name($ustmt, ":course_name", iconv("UTF-8","TIS-620", $_POST["n_course_name"]));
				oci_bind_by_name($ustmt, ":course_fee", $_POST['n_course_fee']);
				oci_bind_by_name($ustmt, ":course_id", $course_id);

				if ( $_POST['n_course_start'] ) {
					$n_course_start = utils::text2date($_POST["n_course_start"]);
					if ( $n_course_start ) {
						oci_bind_by_name($ustmt, ':course_start', date( "d M Y H:i:s", $n_course_start) );
					}
				}

				if ( $_POST['n_course_end'] ) {
					$n_course_end = utils::text2date($_POST["n_course_end"]);
					if ( $n_course_end ) {
						oci_bind_by_name($ustmt, ':course_end', date( "d M Y H:i:s", $n_course_end) );
					}
				}

				if (oci_execute($ustmt, OCI_COMMIT_ON_SUCCESS)) {
					$error = "Your information is updated successfully.";
				} else {
					$error = "System is corrupted, please try again later.";
				}
				oci_free_statement($ustmt);
			} else {
				$usql = "INSERT INTO course( course_id"
						.", course_name"
						.", course_fee"
						.", course_start"
						.", course_end)"
						." VALUES( :course_id"
						.", :course_name"
						.", :course_fee"
						.", TO_DATE(:course_start, 'dd Mon yyyy hh24:mi:ss')"
						.", TO_DATE(:course_end, 'dd Mon yyyy hh24:mi:ss'))";
				$ustmt = oci_parse($ora_conn, $usql);
				oci_bind_by_name($ustmt, ":course_id", $_POST['n_course_id']);
				oci_bind_by_name($ustmt, ":course_name", iconv("UTF-8","TIS-620", $_POST["n_course_name"]));
				oci_bind_by_name($ustmt, ":course_fee", $_POST['n_course_fee']);

				if ( $_POST['n_course_start'] ) {
					$n_course_start = utils::text2date($_POST["n_course_start"]);
					if ( $n_course_start ) {
						oci_bind_by_name($ustmt, ':course_start', date( "d M Y H:i:s", $n_course_start) );
					}
				}

				if ( $_POST['n_course_end'] ) {
					$n_course_end = utils::text2date($_POST["n_course_end"]);
					if ( $n_course_end ) {
						oci_bind_by_name($ustmt, ':course_end', date( "d M Y H:i:s", $n_course_end) );
					}
				}

				if (oci_execute($ustmt, OCI_COMMIT_ON_SUCCESS)) {
					$error = "Your information is inserted successfully.";
				} else {
					$error = "System is corrupted, please try again later.";
				}
				oci_free_statement($ustmt);
			}

			header( "Location: courselist.php" );

		} else if ( $_POST['class'] ) {
			/*
			 * Update classroom data entry as mapping with course
			 */
			$classrooms = array();
			if ( $_POST['classroom_id'] ) {
				if ( is_array( $_POST['classroom_id'] ) ) {
					foreach ($_POST['classroom_id'] as $key => $value) {
						$classrooms[] = $value;	
					}
				} else {
					$classrooms[] = $_POST['classroom_id'];
				}
			}
			// Update classroom mapped
			coursedom::classroom( $ora_conn, $course_id, $classrooms);
			$error = "Class room is updated successfully.";

		} else if ( $_POST['schedule'] ) {
			/*
			 * Update schedule data entry as mapping with course
			 */
			$day = $_POST['day'];
			$begin_time = $_POST['begin_time'];
			$end_time = $_POST['end_time'];

			if ( $day ) {
				if ( $begin_time && (count(explode(":", $begin_time)) == 2) ) {
					if ( $end_time && (count(explode(":", $end_time)) == 2) ) {
						schedule::create($ora_conn, $course_id, $day, $begin_time, $end_time);
						$error = "The schedule is created successfully.";
					} else {
						$error = "Your input time for end is wrong format";
					}
				} else {
					$error = "Your input time for begin is wrong format";
				}
			} else {
				$error = "Your input day is wrong format";
			}

		} else if ( $_POST['trainer'] ) {
			/*
			 * Update trainer_profile data entry as mapping with course
			 */
			$trainers = array();
			if ( $_POST['trainer_id'] ) {
				if ( is_array( $_POST['trainer_id'] ) ) {
					foreach ($_POST['trainer_id'] as $key => $value) {
						$trainers[] = $value;
					}
				} else {
					$trainers[] = $_POST['trainer_id'];
				}
			}
			// Update classroom mapped
			coursedom::coursetrainer($ora_conn, $course_id, $trainers);
			$error = "Trainer is updated successfully.";

		} else if ( $_POST['cbs'] ) {
			/*
			 * Update cbs_department data entry as mapping with course
			 */
			$cbscourses = array();
			if ( $_POST['cbs_id'] ) {
				if ( is_array( $_POST['cbs_id'] ) ) {
					foreach ($_POST['cbs_id'] as $key => $value) {
						$cbscourses[] = $value;	
					}
				} else {
					$cbscourses[] = $_POST['cbs_id'];
				}
			}
			// Update cbs department mapped
			coursedom::cbscourse( $ora_conn, $course_id, $cbscourses);
			$error = "CBS department is updated successfully.";
		}
	} else {
		$course_id = $_GET['course_id'];
		if ( $_GET['reschedule_id'] ) {
			/*
			 * Remove schedule data entry as mapping with course
			 */
			schedule::remove($ora_conn, $course_id, $_GET['reschedule_id']);
			$error = "The schedule is removed successfully.";
		}
	}

	if ( $course_id ) {

		$gsql = "SELECT course_id"
				.", course_name"
				.", course_fee"
				.", TO_CHAR(course_start, 'dd MM yyyy') as course_start"
				.", TO_CHAR(course_end, 'dd MM yyyy') as course_end"
				." FROM course"
				." WHERE course_id=:course_id";
				
		$gstmt = oci_parse($ora_conn, $gsql);
		oci_bind_by_name($gstmt, ":course_id", $course_id);
		if (oci_execute($gstmt)) {
			while(oci_fetch($gstmt)) {
				$course_id = oci_result($gstmt, 'COURSE_ID');
				$course_name = iconv("TIS-620","UTF-8", oci_result($gstmt, 'COURSE_NAME'));
				$course_fee = oci_result($gstmt, 'COURSE_FEE');

				$date_start = oci_result($gstmt, 'COURSE_START');
				if ( $date_start ) {
					$course_start = utils::oradate2text($date_start);
				}

				$date_end = oci_result($gstmt, 'COURSE_END');
				if ( $date_end ) {
					$course_end = utils::oradate2text($date_end);
				}
			}
		} 
		oci_free_statement($gstmt);

		// Dropdownlist
		$cbsdeps = dropdownlist::cbs_department($ora_conn);
		$classrooms = dropdownlist::classroom($ora_conn);
		$trainers = dropdownlist::trainer($ora_conn);
		$schedules = schedule::findall($ora_conn, $course_id);

		// Selected
		$selectedClass = coursedom::selectedClass($ora_conn, $course_id);
		$selectedCbs = coursedom::selectedCbs($ora_conn, $course_id);
		$selectedTrainer = coursedom::selectedTrainer($ora_conn, $course_id);
	}

	// OCI disconnect
	$oracle->disconnect();
?>