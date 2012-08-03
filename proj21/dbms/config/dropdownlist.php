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
		$dept_sql = oci_parse($ora_conn, "select cbs_id,cbs_department from cbs_departments");
		oci_execute($dept_sql);
		while($rowtable = oci_fetch_array($dept_sql)) {
			$list[$rowtable['CBS_ID']] = iconv("TIS-620","UTF-8", $rowtable['CBS_DEPARTMENT']);
		}
		return $list;
	}
	
	/**
	 * COURSE
	 * @param oci_connect
	 * @return array of course list
	 */
	public static function course($ora_conn) {
		$list = array();
		$course_sql = oci_parse($ora_conn, "select course_id,course_name from course");
		oci_execute($course_sql);
		while($rowtable = oci_fetch_array($course_sql)) {
			$list[$rowtable['COURSE_ID']] = iconv("TIS-620","UTF-8", $rowtable['COURSE_NAME']);
		}
		return $list;
	}

	/**
	 * DEPARTMENT
	 * @param oci_connect
	 * @return array of department list
	 */
	public static function department($ora_conn) {
		$list = array();
		$department_sql = oci_parse($ora_conn, "select dep_id, department_name from department");
		oci_execute($department_sql);
		while($rowtable = oci_fetch_array($department_sql)) {
			$list[$rowtable['DEP_ID']] = iconv("TIS-620","UTF-8", $rowtable['DEPARTMENT_NAME']);
		}
		return $list;
	}
	
}

?>