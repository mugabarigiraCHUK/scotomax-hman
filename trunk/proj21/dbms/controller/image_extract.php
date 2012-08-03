<?php

	// Required OCI class
	include("oracle.php");

	// Initial OCI objects and open connection
	$oracle = new oracle;
	$ora_conn = $oracle->connection();

	if ( $_GET['type'] && $_GET['id'] ) {
		if ( $_GET['type'] == 'profile' ) {
			$sql = "SELECT pic_name, pic_size, pic_type, pic_content FROM std_profile WHERE id_code=:id_code";
			$stmt = oci_parse($ora_conn, $sql);
			oci_bind_by_name($stmt, ":id_code", $_GET['id']);
			// SQL execution
			oci_execute($stmt);
			$row = oci_fetch_array($stid, OCI_ASSOC+OCI_RETURN_NULLS);
			if ( $row ) {
				$name = iconv("TIS-620","UTF-8", $row['PIC_NAME']);
				$size = $row['PIC_SIZE'];
				$type = $row['PIC_TYPE'];
				$content = $row['PIC_CONTENT']->load();
			}
		}
	}

	// give our picture the proper headers...otherwise our page will be confused 
	header("Content-Disposition: attachment; filename=$name"); 
	header("Content-length: $size"); 
	header("Content-type: $type"); 
	echo $content; 

	// OCI disconnect
	$oracle->disconnect();
?>