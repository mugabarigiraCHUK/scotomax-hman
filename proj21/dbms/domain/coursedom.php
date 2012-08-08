<?php

/**
 * Class for update data entity component course.
 * @author malipen
 */
class coursedom {

	/**
	 * update CLASS for mapped COURSE <-> CLASSROOM
	 * @param oci_conn
	 * @param course_id
	 * @param array of classroom id
	 */
	public static function classroom($ora_conn, $course_id, $classrooms) {
		$stmt = oci_parse($ora_conn, "DELETE FROM CLASS WHERE course_id=:course_id");
		oci_bind_by_name($stmt, ":course_id", $course_id);
		oci_execute($stmt, OCI_NO_AUTO_COMMIT);
		if ( $classrooms ) {
			$rowcount = count( $classrooms );
			for ($i = 0; $i < $rowcount; $i++ ) {
				$stmt = oci_parse($ora_conn, "INSERT INTO CLASS( classroom_id, course_id ) VALUES( :classroom_id, :course_id)");
				oci_bind_by_name($stmt, ":classroom_id", $classrooms[$i]);
				oci_bind_by_name($stmt, ":course_id", $course_id);
				oci_execute($stmt, OCI_NO_AUTO_COMMIT);
			}
			oci_commit($ora_conn);
		}
		oci_free_statement($stmt);
	}

	/**
	 * update CBS_COURSE for mapped COURSE <-> CBS_DEPARTMENT
	 * @param oci_conn
	 * @param course_id
	 * @param array of cbs_department id
	 */
	public static function cbscourse($ora_conn, $course_id, $cbscourses) {
		$stmt = oci_parse($ora_conn, "DELETE FROM CBS_COURSE WHERE course_id=:course_id");
		oci_bind_by_name($stmt, ":course_id", $course_id);
		oci_execute($stmt, OCI_NO_AUTO_COMMIT);
		if ( $cbscourses ) {
			$rowcount = count( $cbscourses );
			for ($i = 0; $i < $rowcount; $i++ ) {
				$stmt = oci_parse($ora_conn, "INSERT INTO CBS_COURSE( cbs_id, course_id ) VALUES( :cbs_id, :course_id)");
				oci_bind_by_name($stmt, ":cbs_id", $cbscourses[$i] );
				oci_bind_by_name($stmt, ":course_id", $course_id);
				oci_execute($stmt, OCI_NO_AUTO_COMMIT);
			}
			oci_commit($ora_conn);
		}
		oci_free_statement($stmt);
	}

	/**
	 * update COURSE_TRAINER for mapped COURSE <-> TRAINER_PROFILE
	 * @param oci_conn
	 * @param course_id
	 * @param array of trainer_profile id
	 */
	public static function coursetrainer($ora_conn, $course_id, $trainers) {
		$stmt = oci_parse($ora_conn, "DELETE FROM COURSE_TRAINER WHERE course_id=:course_id");
		oci_bind_by_name($stmt, ":course_id", $course_id);
		oci_execute($stmt, OCI_NO_AUTO_COMMIT);
		if ( $trainers ) {
			$rowcount = count( $trainers );
			for ($i = 0; $i < $rowcount; $i++ ) {
				$stmt = oci_parse($ora_conn, "INSERT INTO COURSE_TRAINER( trainer_id, course_id ) VALUES( :trainer_id, :course_id)");
				oci_bind_by_name($stmt, ":trainer_id", $trainers[$i]);
				oci_bind_by_name($stmt, ":course_id", $course_id);
				oci_execute($stmt, OCI_NO_AUTO_COMMIT);
			}
			oci_commit($ora_conn);
		}
		oci_free_statement($stmt);
	}

	/**
	 * Find all selected CLASSROOM be mapped with COURSE
	 * @param oci_conn
	 * @param course_id
	 * @return array of classroom mapped
	 */
	public static function selectedClass($ora_conn, $course_id) {
		$list = array();
		$sql = "SELECT t2.classroom_id, t2.room_no, t2.max_seat, t2.left_seat, t1.course_id"
				." FROM class t1"
				."	INNER JOIN classroom t2 ON t1.classroom_id=t2.classroom_id"
				." WHERE t1.course_id=:course_id";
		$stmt = oci_parse($ora_conn, $sql);
		oci_bind_by_name($stmt, ":course_id", $course_id);
		oci_execute($stmt);
		while($rowtable = oci_fetch_array($stmt)) {
			$column = array();
			$column['CLASSROOM'] = $rowtable['CLASSROOM_ID'];
			$column['ROOM_NO'] = $rowtable['ROOM_NO'];
			$column['MAX_SEAT'] = $rowtable['MAX_SEAT'];
			$column['LEFT_SEAT'] = $rowtable['LEFT_SEAT'];
			$column['COURSE_ID'] = $rowtable['COURSE_ID'];
			$list[$rowtable['CLASSROOM_ID']] = $rowtable['COURSE_ID'];
		}
		oci_free_statement($stmt);
		return $list;
	}

	/**
	 * Find all selected CBS_DEPARTMENT be mapped with COURSE
	 * @param oci_conn
	 * @param course_id
	 * @return array of cbs_department mapped
	 */
	public static function selectedCbs($ora_conn, $course_id) {
		$list = array();
		$sql = "SELECT t2.cbs_id, t2.cbs_department, t1.course_id"
				." FROM cbs_course t1"
				."	INNER JOIN cbs_departments t2 ON t1.cbs_id=t2.cbs_id"
				." WHERE t1.course_id=:course_id";
		$stmt = oci_parse($ora_conn, $sql);
		oci_bind_by_name($stmt, ":course_id", $course_id);
		oci_execute($stmt);
		while($rowtable = oci_fetch_array($stmt)) {
			$column = array();
			$column['CBS_ID'] = $rowtable['CBS_ID'];
			$column['CBS_DEPARTMENT'] = iconv("TIS-620","UTF-8", $rowtable['CBS_DEPARTMENT']);
			$column['COURSE_ID'] = $rowtable['COURSE_ID'];
			$list[$rowtable['CBS_ID']] = $column;
		}
		oci_free_statement($stmt);
		return $list;
	}

	/**
	 * Find all selected TRAINER be mapped with COURSE
	 * @param oci_conn
	 * @param course_id
	 * @return array of trainer_profile mapped
	 */
	public static function selectedTrainer($ora_conn, $course_id) {
		$list = array();
		$sql = "SELECT t2.trainer_id "
				.", t2.firstname "
				.", t2.lastname "
				.", t3.department_name "
				.", t1.course_id "
				."FROM course_trainer t1 "
				."	INNER JOIN trainer_profile t2 ON t1.trainer_id=t2.trainer_id "
				."	LEFT OUTER JOIN department t3 ON t2.dep_id=t3.dep_id "
				."WHERE course_id=:course_id";
		$stmt = oci_parse($ora_conn, $sql);
		oci_bind_by_name($stmt, ":course_id", $course_id);
		oci_execute($stmt);
		while($rowtable = oci_fetch_array($stmt)) {
			$column = array();
			$column['TRAINER_ID'] = $rowtable['TRAINER_ID'];
			$column['FIRSTNAME'] = iconv("TIS-620","UTF-8", $rowtable['FIRSTNAME']);
			$column['LASTNAME'] = iconv("TIS-620","UTF-8", $rowtable['LASTNAME']);
			$column['DEPARTMENT_NAME'] = iconv("TIS-620","UTF-8", $rowtable['DEPARTMENT_NAME']);
			$column['COURSE_ID'] = $rowtable['COURSE_ID'];
			$list[$rowtable['TRAINER_ID']] = $column;
		}
		oci_free_statement($stmt);
		return $list;
	}

	/**
	 * Find all selected EXAM_SERIES be mapped with COURSE
	 * @param oci_conn
	 * @param course_id
	 * @return array of exam_series mapped
	 */
	public static function selectedExam($ora_conn, $course_id) {
		$list = array();
		$sql = "SELECT exam_no "
				.", exam_description "
				.", full_score "
				.", course_id "
				."FROM exam_series "
				."WHERE course_id=:course_id";
		$stmt = oci_parse($ora_conn, $sql);
		oci_bind_by_name($stmt, ":course_id", $course_id);
		oci_execute($stmt);
		while($rowtable = oci_fetch_array($stmt)) {
			$column = array();
			$column['EXAM_NO'] = $rowtable['EXAM_NO'];
			$column['EXAM_DESCRIPTION'] = iconv("TIS-620","UTF-8", $rowtable['EXAM_DESCRIPTION']);
			$column['FULL_SCORE'] = $rowtable['FULL_SCORE'];
			$column['COURSE_ID'] = $rowtable['COURSE_ID'];
			$list[$rowtable['EXAM_NO']] = $column;
		}
		oci_free_statement($stmt);
		return $list;
	}

}

?>