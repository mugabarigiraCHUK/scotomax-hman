<?php
/**
 * Class for getting list of configuration data by array object
 * @author malipen
 */
class dropdownlist {
	
	/**
	 * CBS_DEPARTMENT
	 * @param oci_connect
	 * @return array of cbs department list
	 */
	public static function cbs_department($ora_conn) {
		$list = array();
		$sql = "SELECT cbs_id, cbs_department FROM cbs_departments ORDER BY cbs_id";
		$dept_sql = oci_parse($ora_conn, $sql);
		oci_execute($dept_sql);
		while($rowtable = oci_fetch_array($dept_sql)) {
			$column = array();
			$column['CBS_ID'] = $rowtable['CBS_ID'];
			$column['CBS_DEPARTMENT'] = iconv("TIS-620","UTF-8", $rowtable['CBS_DEPARTMENT']);
			$list[$rowtable['CBS_ID']] = $column;
		}
		oci_free_statement($dept_sql);
		return $list;
	}
	
	/**
	 * COURSE
	 * @param oci_connect
	 * @return array of course list
	 */
	public static function course($ora_conn) {
		$list = array();
		$sql = "SELECT course_id, course_name FROM course ORDER BY course_id";
		$course_sql = oci_parse($ora_conn, $sql);
		oci_execute($course_sql);
		while($rowtable = oci_fetch_array($course_sql)) {
			$column = array();
			$column['COURSE_ID'] = $rowtable['COURSE_ID'];
			$column['COURSE_NAME'] = iconv("TIS-620","UTF-8", $rowtable['COURSE_NAME']);
			$list[$rowtable['COURSE_ID']] = $column;
		}
		oci_free_statement($course_sql);
		return $list;
	}

	/**
	 * DEPARTMENT
	 * @param oci_connect
	 * @return array of department list
	 */
	public static function department($ora_conn) {
		$list = array();
		$sql = "SELECT dep_id, department_name"
				." FROM department"
				." ORDER BY dep_id";
		$department_sql = oci_parse($ora_conn, $sql);
		oci_execute($department_sql);
		while($rowtable = oci_fetch_array($department_sql)) {
			$column = array();
			$column['DEP_ID'] = $rowtable['DEP_ID'];
			$column['DEPARTMENT_NAME'] = iconv("TIS-620","UTF-8", $rowtable['DEPARTMENT_NAME']);
			$list[$rowtable['DEP_ID']] = $column;
		}
		oci_free_statement($department_sql);
		return $list;
	}

	/**
	 * CLASSROOM
	 * @param oci_connect
	 * @return array of classroom list [classroom_id][room_no, max_seat, left_seat]
	 */
	public static function classroom($ora_conn) {
		$list = array();
		$sql = "SELECT classroom_id, room_no, max_seat, left_seat"
				." FROM classroom"
				." ORDER BY classroom_id";
		$classroom_sql = oci_parse($ora_conn, $sql);
		oci_execute($classroom_sql);
		while($rowtable = oci_fetch_array($classroom_sql)) {
			$column = array();
			$column['ROOM_NO'] = iconv("TIS-620","UTF-8", $rowtable['ROOM_NO']);
			$column['MAX_SEAT'] = $rowtable['MAX_SEAT'];
			$column['LEFT_SEAT'] = $rowtable['LEFT_SEAT'];
			$list[$rowtable['CLASSROOM_ID']] = $column;
		}
		oci_free_statement($classroom_sql);
		return $list;
	}

	/**
	 * TRAINERS
	 * @param oci_connect
	 * @return array of trainer list [trainer_id][firstname, lastname]
	 */
	public static function trainer($ora_conn) {
		$list = array();
		$sql = "SELECT trainer_id, firstname, lastname"
				." FROM trainer_profile"
				." ORDER BY trainer_id";
		$trainer_sql = oci_parse($ora_conn, $sql);
		oci_execute($trainer_sql);
		while($rowtable = oci_fetch_array($trainer_sql)) {
			$column = array();
			$column['FIRSTNAME'] = iconv("TIS-620","UTF-8", $rowtable['FIRSTNAME']);
			$column['LASTNAME'] = iconv("TIS-620","UTF-8", $rowtable['LASTNAME']);
			$list[$rowtable['TRAINER_ID']] = $column;
		}
		oci_free_statement($trainer_sql);
		return $list;
	}
	
}

?>