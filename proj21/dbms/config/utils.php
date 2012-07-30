<?php
/**
 * Class for contain all utility functions
 * @author malipen
 */
class utils {

	// Full text of month Thai regional.
	private static $monthmap = array("มกราคม", "กุมภาพันธ์", "มีนาคม", "เมษายน", "พฤษภาคม", "มิถุนายน", "กรกฎาคม", "สิงหาคม", "กันยายน", "ตุลาคม", "พฤศจิกายน", "ธันวาคม");
	// shot text of month Thai regional
	private static $monmap = array("ม.ค.", "ก.พ.", "มี.ค.", "เม.ย.", "พ.ค.", "มิ.ย.", "ก.ค.", "ส.ค.", "ก.ย.", "ต.ย.", "พ.ย.", "ธ.ค.");
	// Regional months
	private static $rmonths = array("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");

	/**
	 * Convert date object represent by text (Thai regional).
	 *
	 * @param date
	 * @return text in date format "dd MM yy"
	 */
	public static function date2text($expdate) {
		if ( $expdate ) {
			$arr = explode(" ", date("d n Y", $expdate));
			if ( count($arr) == 3 ) {
				$idx = $arr[1] - 1;
				//$mm = self::$monthmap;
				return $arr[0]." ".self::$monthmap[$idx]." ".$arr[2];
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	/**
	 * Convert date from Oracle represent by text (Thai regional).
	 *
	 * @param date "dd MM yyyy"
	 * @return text in date format "dd MM yy"
	 */
	public static function oradate2text($expdate) {
		if ( $expdate ) {
			$arr = explode(" ", $expdate);
			if ( count($arr) == 3 ) {
				return $arr[0]." ".self::$monthmap[($arr[1] - 1)]." ".$arr[2];
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	/**
	 * Convert text of date to date object.
	 *
	 * @param text in date format "dd MM yy"
	 * @return date represent text
	 */
	public static function text2date($exptxt) {

		$dd = 0;
		$mm = 0;
		$yy = 0;
		
		$arr = explode(" ", $exptxt);
		if ( count($arr) == 3 ) {
			// day
			$dd = $arr[0];
			
			// month
			$cmonth = count(self::$monthmap);
			for($i = 0; $i < $cmonth; $i++) {
			    if ( self::$monthmap[$i] == $arr[1] ) {
			    	$mm = self::$rmonths[$i];
			    }
			}
			
			// year
			$yy = $arr[2];

			return strtotime($dd." ".$mm." ".$yy);
		} else {
			return null;
		}
	}
}

?>