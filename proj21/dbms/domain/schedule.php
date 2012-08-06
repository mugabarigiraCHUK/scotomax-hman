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
				.", TO_CHAR(begin_time, 'dd MM yyyy') as day"
				.", TO_CHAR(begin_time, 'hh24:mi') as begin_time"
				.", TO_CHAR(end_time, 'hh24:mi') as end_time"
				.", hours"
				." FROM course_schedule"
				." WHERE course_id=:course_id";
		$stmt = oci_parse($ora_conn, $sql);
		oci_bind_by_name($stmt, ":course_id", $course_id);
		oci_execute($stmt);
		while($rowtable = oci_fetch_array($stmt)) {
			$column = array();
			
			$day = $rowtable['DAY'];
			$column['DAY'] = utils::oradate2text($day);

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
	public static function create($ora_conn, $course_id, $day, $begin_time, $end_time) {

		if ( $day ) {
			$n_day = utils::text2date($day);

			//echo " n_day -> ".date( "d M Y H:i:s", $n_day)."<br/>";

			list($begin_hours, $begin_minute) = explode(":", $begin_time);
			list($end_hours, $end_minute) = explode(":", $end_time);

			//echo " begin_hours -> ".$begin_hours.", minutes -> ".$begin_minute."<br/>";
			//echo " enf_hourse -> ".$end_hours.", minutes -> ".$end_minute."<br/>";

			$btime = $n_day + ( $begin_hours * 60 * 60 ) + ( $begin_minute * 60 );
			$etime = $n_day + ( $end_hours * 60 * 60 ) + ( $end_minute * 60 );

			//echo " btime -> ".date( "d M Y H:i:s", $btime)."<br/>";
			//echo " etime -> ".date( "d M Y H:i:s", $etime)."<br/>";

			$diff = $etime - $btime;
			$hours = date("H", $diff);

			//echo " hours -> ".$hours."<br/>";

			// Populate uuid by time second from system
			list($second, $milli) = explode(".", microtime(true));

			$stmt = oci_parse($ora_conn, "INSERT INTO course_schedule( schedule_id"
										.", begin_time"
										.", end_time"
										.", hours"
										.", course_id )"
										." VALUES( :schedule_id"
										.", TO_DATE(:begin_time, 'dd Mon yyyy hh24:mi:ss')"
										.", TO_DATE(:end_time, 'dd Mon yyyy hh24:mi:ss')"
										.", :hours"
										.", :course_id)");
			oci_bind_by_name($stmt, ":schedule_id", $second);
			oci_bind_by_name($stmt, ":begin_time", date( "d M Y H:i:s", $btime));
			oci_bind_by_name($stmt, ":end_time", date( "d M Y H:i:s", $etime));
			oci_bind_by_name($stmt, ":hours", $hours);
			oci_bind_by_name($stmt, ":course_id", $course_id);
			oci_execute($stmt, OCI_COMMIT_ON_SUCCESS);
		}
	}

	/**
	 * Remove COURSE_SCHEDULE for unmapped COURSE <-> COURSE_SCHEDULE
	 * @param oci_conn
	 * @param course_id
	 * @param schedule_id
	 */
	public static function remove($ora_conn, $course_id, $schedule_id) {
		$stmt = oci_parse($ora_conn, "DELETE FROM course_schedule WHERE course_id=:course_id AND schedule_id=:schedule_id");
		oci_bind_by_name($stmt, ":course_id", $course_id);
		oci_bind_by_name($stmt, ":schedule_id", $schedule_id);
		oci_execute($stmt, OCI_COMMIT_ON_SUCCESS);
	}

}

?>