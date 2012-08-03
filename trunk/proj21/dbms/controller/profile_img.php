<?php

	// Required OCI class
	include("../config/oracle.php");
	
	

	if ( $_SERVER['REQUEST_METHOD'] == "POST" ) {

		if ( $_FILES['file'] ) {
			// Initial OCI objects and open connection
			$oracle = new oracle;
			$ora_conn = $oracle->connection();

			/*
			 * Uploading profile image
			 */
			$name = $_FILES['file']['name'];
			$tmp_name = $_FILES['file']['tmp_name'];
			$type = $_FILES['file']['type'];
			$size = $_FILES['file']['size'];

			// get the width & height of the file (we don't need the other stuff) 
			//list($width, $height, $typeb, $attr) = getimagesize($tmp_name);

			// if your server has magic quotes turned off, add slashes manually 
			//if(!get_magic_quotes_gpc()){ 
			//	$name = addslashes($name); 
			//}

			// open up the file and extract the data/content from it 
			$extract = fopen($tmp_name, 'r'); 
			$content = fread($extract, $size); 
			//$content = addslashes($content); 
			fclose($extract);

			// Oracle LOB description
			$blob = oci_new_descriptor($ora_conn, OCI_D_LOB);
			// DML for upload binary into LOB
			$pstmt = oci_parse($ora_conn, "UPDATE std_profile "
											."SET pic_name=:pic_name, "
											."	pic_size=:pic_size, "
											."	pic_type=:pic_type, "
											."	pic_content=:pic_content "
											."WHERE id_code=:id_code");
			// Bind parameter
			oci_bind_by_name($pstmt, ':pic_name', $name);
			oci_bind_by_name($pstmt, ':pic_size', $size);
			oci_bind_by_name($pstmt, ':pic_type', $type);
			oci_bind_by_name($pstmt, ':id_code', $_SESSION['id_code']);
			// Stream binary into Oracle LOB
			oci_bind_by_name($pstmt, ':pic_content', $blob, -1, OCI_B_BLOB);
			//$blob->writeTemporary($tmp_name);
			$blob->save($content);
			// Oracle DML execution
			oci_execute($pstmt, OCI_DEFAULT);
			oci_commit($ora_conn); 
			// Free all concern resources
			$blob->close();
			oci_free_descriptor($blob);
			oci_free_statement($pstmt);

			// OCI disconnect
			$oracle->disconnect();

			echo "OK";
		} else {
			echo "Not found HTTP file parameter";
		}
	} else {
		echo "URL is only support HTTP POST";
	}

?>