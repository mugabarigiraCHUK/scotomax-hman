<?php
/**
 * Class for initial OCI connection and disconnect after finish work.
 * @author malipen
 */
class oracle {

	//$oci_url = "//10.211.55.4/mis";
	private $oci_url = "//127.0.0.1/XE";
	private $oci_username = "dbm";
	private $oci_password = "dbmit21";
	private $oci_conn;
	
	/**
	 * Initial OCI connection
	 * @return oci_connect
	 */
	public function connection() {
		$this->oci_conn = oci_connect( $this->oci_username, $this->oci_password, $this->oci_url);
		return $this->oci_conn;
	}
	
	/**
	 * OCI disconnect
	 * 
	 */
	public function disconnect() {
		oci_close($this->oci_conn);
	}
}

?>