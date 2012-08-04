<?php
/**
 * Class for update data entity for course schedule.
 * @author malipen
 */
class schedule {

	/**
	 * list of schedule data on course
	 * @param oci_conn
	 * @param course_id
	 * @return array of schedule [schedule_id]:[day, begin_time, end_time, hours]
	 */
	public static function findall($ora_conn, $course_id) {
		$list = array();
		$sql = "SELECT schedule_id"
				.", day"
				.", begin_time"
				.", end_time"
				.", hours"
				." FROM course_schedule"
				." WHERE course_id=:course_id";
		$stmt = oci_parse($ora_conn, $sql);
		oci_bind_by_name($stmt, ":course_id", $course_id);
		oci_execute($stmt);
		while($rowtable = oci_fetch_array($stmt)) {
			$column = array();
			$column['DAY'] = $rowtable['DAY'];
			$column['BEGIN_TIME'] = $rowtable['BEGIN_TIME'];
			$column['END_TIME'] = $rowtable['END_TIME'];
			$column['HOURS'] = $rowtable['HOURS'];
			$list[$rowtable['SCHEDULE_ID']] = $column;
		}
		oci_free_statement($stmt);
		return $list;
	}

	/**
	 * update COURSE_SCHEDULE for mapped COURSE <-> COURSE_SCHEDULE
	 * @param oci_conn
	 * @param course_id
	 * @param array of trainer_profile id
	 */
	public static function create($ora_conn, $course_id, $day, $begin_time, $end_time, $hours) {
		// Populate uuid by time second from system
		list($second, $milli) = explode(".", microtime(true));

		$stmt = oci_parse($ora_conn, "INSERT INTO course_schedule( schedule_id"
									.", day"
									.", begin_time"
									.", end_time"
									.", hours"
									.", course_id )"
									." VALUES( :schedule_id"
									.", :day"
									.", :begin_time"
									.", :end_time"
									.", :hours"
									.", :course_id)");
		oci_bind_by_name($stmt, ":schedule_id", $second);
		oci_bind_by_name($stmt, ":day", $day);
		oci_bind_by_name($stmt, ":begin_time", $begin_time);
		oci_bind_by_name($stmt, ":end_time", $end_time);
		oci_bind_by_name($stmt, ":hours", $hours);
		oci_bind_by_name($stmt, ":course_id", $course_id);
		oci_execute($stmt, OCI_COMMIT_ON_SUCCESS);
	}

	/**
	 * Remove COURSE_SCHEDULE for unmapped COURSE <-> COURSE_SCHEDULE
	 * @param oci_conn
	 * @param course_id
	 * @param schedule_id
	 */
	public static function remove($ora_conn, $course_id, $schedule_id) {
		$stmt = oci_parse($ora_conn, "DELETE FROM course_schedule WHERE course_id=:course_id, schedule_id=:schedule_id");
		oci_bind_by_name($stmt, ":course_id", $course_id);
		oci_bind_by_name($stmt, ":schedule_id", $schedule_id);
		oci_execute($stmt, OCI_COMMIT_ON_SUCCESS);
	}

}

?>