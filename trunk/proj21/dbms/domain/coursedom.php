<?php

/**
 * Class for update data entify component course.
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
	 * @return array of classroom_id mapped
	 */
	public static function selectedClass($ora_conn, $course_id) {
		$list = array();
		$stmt = oci_parse($ora_conn, "SELECT classroom_id, course_id FROM class WHERE course_id=:course_id");
		oci_bind_by_name($stmt, ":course_id", $course_id);
		oci_execute($stmt);
		while($rowtable = oci_fetch_array($stmt)) {
			$list[$rowtable['CLASSROOM_ID']] = $rowtable['COURSE_ID'];
		}
		oci_free_statement($stmt);
		return $list;
	}

	/**
	 * Find all selected CBS_DEPARTMENT be mapped with COURSE
	 * @param oci_conn
	 * @param course_id
	 * @return array of cbs_id mapped
	 */
	public static function selectedCbs($ora_conn, $course_id) {
		$list = array();
		$stmt = oci_parse($ora_conn, "SELECT cbs_id, course_id FROM cbs_course WHERE course_id=:course_id");
		oci_bind_by_name($stmt, ":course_id", $course_id);
		oci_execute($stmt);
		while($rowtable = oci_fetch_array($stmt)) {
			$list[$rowtable['CBS_ID']] = $rowtable['COURSE_ID'];
		}
		oci_free_statement($stmt);
		return $list;
	}

	/**
	 * Find all selected TRAINER be mapped with COURSE
	 * @param oci_conn
	 * @param course_id
	 * @return array of trainer_id mapped
	 */
	public static function selectedTrainer($ora_conn, $course_id) {
		$list = array();
		$stmt = oci_parse($ora_conn, "SELECT trainer_id, course_id FROM course_trainer WHERE course_id=:course_id");
		oci_bind_by_name($stmt, ":course_id", $course_id);
		oci_execute($stmt);
		while($rowtable = oci_fetch_array($stmt)) {
			$list[$rowtable['TRAINER_ID']] = $rowtable['COURSE_ID'];
		}
		oci_free_statement($stmt);
		return $list;
	}

}

?>