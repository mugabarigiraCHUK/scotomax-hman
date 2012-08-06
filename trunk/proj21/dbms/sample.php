<html>
	<head>
		<meta charset="utf-8">
		<title>PHP Test Suite</title>
		<link href="css/flick/jquery-ui-1.8.21.flick.css" rel="stylesheet">
	</head>
	<body>
		<p>
			<h3>Hello, Malipen</h3>
			<?php
				list($seconds, $milli) = explode(".", microtime(true));
			?>
			<p>UNIQUD : <?=$seconds?></p>
			<?php
			putenv("NLS_LANG=AMERICAN_AMERICA.TH8TISASCII");
			// Create connection to Oracle
			$conn = oci_connect("dbm", "dbmit21", "//127.0.0.1/XE");
			if ( !$conn ) {
			   	$m = oci_error();
			   	echo $m['message'], "\n";
			   	exit;
			} else {
			   	//print "Connected to Oracle MIS";
				//$stmt = oci_parse($conn, 'select sysdate as now from dual');
				$stmt = oci_parse($conn, 'select username from user_login');
				oci_execute($stmt);
				
				while(oci_fetch($stmt)) {
			?>
					<div>Time from Oracle is <?=iconv("TIS-620","UTF-8", oci_result($stmt, 'USERNAME'))?> </div>
			<?php
				}
			}
			// Close the Oracle connection
			oci_close($conn);
			?>
		</p>
		<p>
			<form method="POST" action="sample.php">
				<table border="0" cellpedding="3" cellspacing="5">
					<tr>
						<td>Date 1</td>
						<td><input type="text" class="datepick input-xlarg" id="n_course_start" name="n_course_start"/></td>
					</tr>
					<tr>
						<td>Date 2</td>
						<td><input type="text" class="datepick input-xlarg" id="n_course_end" name="n_course_end"/></td>
					</tr>
				</table>
			</form>
			<script src="js/jquery-1.7.2.min.js"></script>
			<script src="js/jquery-ui-1.8.21.flick.min.js"></script>
			<script type="text/javascript">
				$(function(){
					// Datepicker
					$(".datepick").datepicker({ dateFormat: "dd MM yy"
												, changeYear: true
												, changeMonth: true
												, yearRange: "1970:2015"
												, monthNames: ["มกราคม","กุมภาพันธ์","มีนาคม","เมษายน","พฤษภาคม","มิถุนายน","กรกฎาคม","สิงหาคม","กันยายน","ตุลาคม","พฤศจิกายน","ธันวาคม"]
												, monthNamesShort: ["ม.ค.","ก.พ.","มี.ค.","เม.ย.","พ.ค.","มิ.ย.","ก.ค.","ส.ค.","ก.ย.","ต.ย.","พ.ย.","ธ.ค."]
												, dayNames: ["อาทิตย์", "จันทร์", "อังคาร", "พุธ", "พฤหัส", "ศุกร์", "เสาร์"]
												, dayNamesMin: ["อา.", "จ.", "อ.", "พ.", "พฤ.", "ศ.", "ส."]
												, dayNamesShort: ["อา.", "จ.", "อ.", "พ.", "พฤ.", "ศ.", "ส."] });
				});
			</script>
		</p>
	</body>
</html>