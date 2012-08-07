<?php

/**
 * Class for update data entify component profile.
 * @author malipen
 */
class profiledom {

	/**
	 * update CBS_PREFERED for mapped STD_PROFILE <-> CBS_DEPARTMENT
	 * @param oci_conn
	 * @param id_code
	 * @param array of cbs_department id
	 */
	public static function profile_cbs($ora_conn, $id_code, $cbs_ids) {
		$stmt = oci_parse($ora_conn, "DELETE FROM CBS_PREFERED WHERE id_code=:id_code");
		oci_bind_by_name($stmt, ":id_code", $id_code);
		oci_execute($stmt, OCI_NO_AUTO_COMMIT);
		if ( $cbs_ids ) {
			$rowcount = count( $cbs_ids );
			for ($i = 0; $i < $rowcount; $i++ ) {
				$stmt = oci_parse($ora_conn, "INSERT INTO CBS_PREFERED( id_code, cbs_id ) VALUES( :id_code, :cbs_id)");
				oci_bind_by_name($stmt, ":id_code", $id_code);
				oci_bind_by_name($stmt, ":cbs_id", $cbs_ids[$i] );
				oci_execute($stmt, OCI_NO_AUTO_COMMIT);
			}
			oci_commit($ora_conn);
		}
		oci_free_statement($stmt);
	}

	/**
	 * Find all prefered CBS_DEPARTMENT be mapped with STD_PROFILE
	 * @param oci_conn
	 * @param id_code
	 * @return array of cbs_id mapped
	 */
	public static function perferedCbs($ora_conn, $id_code) {
		$list = array();
		$stmt = oci_parse($ora_conn, "SELECT cbs_id, id_code FROM cbs_prefered WHERE id_code=:id_code");
		oci_bind_by_name($stmt, ":id_code", $id_code);
		oci_execute($stmt);
		while($rowtable = oci_fetch_array($stmt)) {
			$list[$rowtable['CBS_ID']] = $rowtable['ID_CODE'];
		}
		oci_free_statement($stmt);
		return $list;
	}
}

?>