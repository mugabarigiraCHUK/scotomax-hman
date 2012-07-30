<?php
	session_start();
	session_destroy();
	
	$error = "You loged out from system, see you next time.";
	header( "Location: ../login.php" );
?>