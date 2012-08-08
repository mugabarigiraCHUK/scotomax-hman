<?php

/**
 * Class for find all data entity component student register.
 * @author malipen
 */
class registerdom {

	/**
	 * Find all COURSE registered by student
	 * @param oci_connect
	 * @return array of course list
	 */
	public static function course($ora_conn, $id_code) {
		$list = array();
		$sql = "SELECT t2.course_id, t2.course_name"
				." FROM trainee_grade t1"
				."	INNER JOIN course t2 ON t1.course_id=t2.course_id"
				." WHERE t1.id_code=:id_code"
				." ORDER BY t2.course_id";
		$stmt = oci_parse($ora_conn, $sql);
		oci_bind_by_name($stmt, ":id_code", $id_code);
		oci_execute($stmt);
		while($rowtable = oci_fetch_array($stmt)) {
			$column = array();
			$column['COURSE_ID'] = $rowtable['COURSE_ID'];
			$column['COURSE_NAME'] = iconv("TIS-620","UTF-8", $rowtable['COURSE_NAME']);
			$list[$rowtable['COURSE_ID']] = $column;
		}
		oci_free_statement($stmt);
		return $list;
	}

	/**
	 * Find all COURSE been not registered by student
	 * @param oci_connect
	 * @param id_code
	 * @return array of course list
	 */
	public static function free_course($ora_conn, $id_code) {
		$list = array();
		$sql = "SELECT t1.course_id, t1.course_name"
				." FROM course t1"
				." WHERE NOT EXISTS(SELECT t2.course_id FROM trainee_grade t2"
				." 					WHERE t2.course_id=t1.course_id"
				." 						AND t2.id_code=:id_code)"
				." ORDER BY t1.course_id";
		$stmt = oci_parse($ora_conn, $sql);
		oci_bind_by_name($stmt, ":id_code", $id_code);
		oci_execute($stmt);
		while($rowtable = oci_fetch_array($stmt)) {
			$column = array();
			$column['COURSE_ID'] = $rowtable['COURSE_ID'];
			$column['COURSE_NAME'] = iconv("TIS-620","UTF-8", $rowtable['COURSE_NAME']);
			$list[$rowtable['COURSE_ID']] = $column;
		}
		oci_free_statement($stmt);
		return $list;
	}

	/**
	 * Find all selected EXAM_SERIES be mapped with COURSE by student
	 * @param oci_conn
	 * @param course_id
	 * @param id_code
	 * @return array of exam_series mapped
	 */
	public static function selectedExam($ora_conn, $course_id, $id_code) {
		$list = array();
		$sql = "SELECT t2.exam_no "
				.", t2.exam_description "
				.", t2.full_score "
				.", t2.course_id "
				.", t1.pretest_score "
				.", t1.posttest_score "
				."FROM trainee_grade t1 "
				." INNER JOIN exam_series t2 ON t1.exam_no=t2.exam_no "
				."WHERE t2.course_id=:course_id"
				."	AND t1.id_code=:id_code";
		$stmt = oci_parse($ora_conn, $sql);
		oci_bind_by_name($stmt, ":course_id", $course_id);
		oci_bind_by_name($stmt, ":id_code", $id_code);
		oci_execute($stmt);
		while($rowtable = oci_fetch_array($stmt)) {
			$column = array();
			$column['EXAM_NO'] = $rowtable['EXAM_NO'];
			$column['EXAM_DESCRIPTION'] = iconv("TIS-620","UTF-8", $rowtable['EXAM_DESCRIPTION']);
			$column['FULL_SCORE'] = $rowtable['FULL_SCORE'];
			$column['COURSE_ID'] = $rowtable['COURSE_ID'];
			$column['PRETEST_SCORE'] = $rowtable['PRETEST_SCORE'];
			$column['POSTTEST_SCORE'] = $rowtable['POSTTEST_SCORE'];
			$list[$rowtable['EXAM_NO']] = $column;
		}
		oci_free_statement($stmt);
		return $list;
	}
}

?>