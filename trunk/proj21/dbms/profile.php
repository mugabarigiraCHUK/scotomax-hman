<?php include 'config/configure.php'; ?>
<?php include 'controller/profile_controller.php'; ?>
<!DOCTYPE html>
<html lang="en">
  <head>
	<meta charset="utf-8">
    <title>DBMS PHP Index</title>
    <?php include 'layout/header.php'; ?>
  </head>

  <body>
    <?php include 'layout/topbar.php'; ?>
    <div class="container-fluid">
      <div class="row-fluid">
	
		<!--//Navigation panel -->
        <div class="span3">
          	<div class="well sidebar-nav">
		        <ul class="nav nav-list">
			
				<!--@Start ######### Navigation panel editor place ########## -->
				
		          <li class="nav-header">Menu</li>
		          <li class="active"><a href="register.php">Profile</a></li>
		          <li><a href="register.php">Register</a></li>
		          <li><a href="courseopen.php">Course openning</a></li>
		          <li><a href="#">Course plan</a></li>
		          <li><a href="classroom.php">Class room</a></li>
		          
		          <li class="nav-header">System</li>
		          <li><a href="#">Administrator</a></li>
		          <li><a href="#">Report</a></li>
		          <li><a href="#">Logs</a></li>
		
				<!--@End ######### Navigation panel editor place ########## -->
		
		        </ul>
		      </div><!--/.well -->
        </div><!--/span-->

        <div class="span9">

		  	<!--//Advertisement panel -->
		  	<div class="hero-unit">
				<!--@notification message handle -->
				<?php include 'layout/notification.php'; ?>
				
				<!--@Start ######### Body content editor place ########## -->
	            
				<h3>ข้อมูลส่วนตัว</h3>
			    <p>
	            	<form id="form1" class="form-horizontal" method="post">
				    	<fieldset>
						  
						  <div class="control-group">
				            <label class="control-label" for="username">ชื่อเข้าใช้</label>
				            <div class="controls">
				              <input type="text" class="input-large disabled" id="username" name="username" value="<?=$_SESSION['username']?>" disabled>
				            </div>
				          </div>

				          <div class="control-group">
				            <div class="controls">
				              <a data-toggle="modal" href="#pwdmodal" class="btn btn-primary">เปลี่ยนรหัสผ่าน</a>
				            </div>
				          </div>

						  <div class="control-group">
				            <label class="control-label" >คำนำหน้าชื่อ*</label>
				            <div class="controls">
								<select name="title" id="title" class="input-small">
					          		<option value="ดช" <?php if ($title=='ดช') printf('selected'); ?>>ดช</option>
					          		<option value="ดญ" <?php if ($title=='ดญ') printf('selected'); ?>>ดญ</option>
						      		<option value="นาย" <?php if ($title=='นาย') printf('selected'); ?>>นาย</option>
						      		<option value="นางสาว" <?php if ($title=='นางสาว') printf('selected'); ?>>นางสาว</option>
						      	</select>
				            </div>
				          </div>
				
				          <div class="control-group">
				            <label class="control-label" for="firstname">ชื่อ*</label>
				            <div class="controls">
				              <input type="text" class="input-large" id="firstname" name="firstname" value="<?=$firstname?>">
				            </div>
				          </div>
				
				          <div class="control-group">
				            <label class="control-label" for="lastname">นามสกุล*</label>
				            <div class="controls">
				              <input type="text" class="input-large" id="lastname" name="lastname" value="<?=$lastname?>">
				            </div>
				          </div>
				
						  <div class="control-group">
				            <label class="control-label" for="id_number">เลขประจำตัวประชาชน*</label>
				            <div class="controls">
				              <input type="text" class="input-large" id="id_number" name="id_number" value="<?=$id_number?>">
				            </div>
				          </div>
				
						  <div class="control-group">
				            <label class="control-label" for="birthdate">วันเกิด*</label>
				            <div class="controls">
							  <div class="input-prepend">
							    <span class="add-on"><i class="icon-calendar"></i></span>
								<input class="input-large birthdate" id="inputIcon" type="text" id="birthdate" name="birthdate" value="<?=$birthdate?>">
							  </div>
				            </div>
				          </div>
				         
				          <div class="control-group">
				            <label class="control-label" for="address">ที่อยู่*</label>
				            <div class="controls">
							  <textarea class="input-xlarge" id="textarea" rows="3" id="address" name="address"><?=$address?></textarea>
				            </div>
				          </div>
				
						  <div class="control-group">
				            <label class="control-label" for="province">จังหวัด*</label>
				            <div class="controls">
				              <input type="text" class="input-large" id="province" name="province" value="<?=$province?>">
				            </div>
				          </div>
				
						  <div class="control-group">
				            <label class="control-label" for="phone_no">เบอร์โทรศัพท์*</label>
				            <div class="controls">
				              <input type="text" class="input-large" id="phone_no" name="phone_no" value="<?=$phone_no?>">
				            </div>
				          </div>
				
						  <div class="control-group">
				            <label class="control-label" for="email">อีเมล์*</label>
				            <div class="controls">
							  <div class="input-prepend">
							    <span class="add-on"><i class="icon-envelope"></i></span>
								<input class="input-xlarge" id="inputIcon" type="text" id="email" name="email" value="<?=$email?>">
							  </div>
				            </div>
				          </div>
				
						  <div class="control-group">
				            <label class="control-label" for="institute_name">ชื่อสถาบันการศึกษา</label>
				            <div class="controls">
				              <input type="text" class="input-xlarge" id="institute_name" name="institute_name" value="<?=$institute_name?>">
				            </div>
				          </div>
				
						  <div class="control-group">
				            <label class="control-label">ระดับการศึกษา</label>
				            <div class="controls">
				              	<select name="edu_level" id="edu_level" class="input-medium">
						          <option value="มัธยมปลาย" <?php if ($edu_level=='มัธยมปลาย') printf('selected')?>>มัธยมปลาย</option>
						          <option value="ปริญญาตรี" <?php if ($edu_level=='ปริญญาตรี') printf('selected')?>>ปริญญาตรี</option>
							      <option value="อื่นๆ" <?php if ($edu_level=='อื่นๆ') printf('selected')?>>อื่นๆ</option>
							    </select>
				            </div>
				          </div>
				
				          <div class="control-group">
				            <label class="control-label" for="gpa">เกรดเฉลี่ย</label>
				            <div class="controls">
				              <input type="text" class="input-small" id="gpa" name="gpa" value="<?=$gpa?>">
				            </div>
				          </div>

				          <div class="control-group">
				            <label class="control-label" for="registered_date">ลงทะเบียนเมื่อ</label>
				            <div class="controls">
				              <input type="text" class="input-xlarge disabled" id="registered_date" name="registered_date" value="<?=$registered_date?>" disabled>
				            </div>
				          </div>
				
				          <div class="form-actions">
				            <button type="submit" class="btn btn-primary">ปรับปรุงข้อมูล</button>
				          </div>
				
				        </fieldset>
				      </form>

	            </p>
	            <p>
	            	  <div class="tabbable" style="margin-bottom: 18px;">
				        <ul class="nav nav-tabs">
				          <li class="active"><a href="#tab1" data-toggle="tab">อยู่ระหว่างเรียน</a></li>
				          <li><a href="#tab2" data-toggle="tab">เรียนจบคลอสแล้ว</a></li>
				        </ul>
				        <div class="tab-content" style="padding-bottom: 9px; border-bottom: 1px solid #ddd;">
				          <div class="tab-pane active" id="tab1">
				            <p>
				            	<table class="table table-bordered">
							        <thead>
							          <tr>
							            <th>#</th>
							            <th>เลขที่คลอสเรียน</th>
							            <th>รายวิชา</th>
							            <th>อาจารย์ผู้สอน</th>
							            <th>&nbsp;</th>
							          </tr>
							        </thead>
							        <tbody>
							          <tr>
							            <td>1</td>
							            <td>A001</td>
							            <td>คณิตศาสตร์</td>
							            <td>อ.วิชา เรียนดี</td>
							            <td><a href="#" class="btn btn-small btn-info">ตารางเรียน</a></td>
							          </tr>
							          <tr>
							          	<td>2</td>
							            <td>B02</td>
							            <td>ชีววิทยา</td>
							            <td>อ.อะไร เก่งจัง</td>
							            <td><a href="#" class="btn btn-small btn-info">ตารางเรียน</a></td>
							          </tr>
							        </tbody>
							      </table>
				            </p>
				          </div>
				          <div class="tab-pane" id="tab2">
				            <p>
				            	<table class="table table-bordered">
							        <thead>
							          <tr>
							            <th>#</th>
							            <th>เลขที่คลอสเรียน</th>
							            <th>รายวิชา</th>
							            <th>อาจารย์ผู้สอน</th>
							            <th>คะแนนสอบ</th>
							          </tr>
							        </thead>
							        <tbody>
							          <tr>
							            <td>1</td>
							            <td>A001</td>
							            <td>คณิตศาสตร์</td>
							            <td>อ.วิชา เรียนดี</td>
							            <td>80</td>
							          </tr>
							          <tr>
							          	<td>2</td>
							            <td>B02</td>
							            <td>ชีววิทยา</td>
							            <td>อ.อะไร เก่งจัง</td>
							            <td>80</td>
							          </tr>
							        </tbody>
							      </table>
				            </p>
				          </div>

				        </div>
				      </div> <!-- /tabbable -->
	            </p>

          	<!--@End ######### Body content editor place ########## -->

			</div>

		  <?php include 'layout/advertise.php'; ?>
        </div><!--/span-->
      </div><!--/row-->
      <hr>
      <footer>
        <p>
			<?php include 'layout/footer.php'; ?>
		</p>
      </footer>
    </div><!--/.fluid-container-->
    <div id="pwdmodal" class="modal hide fade">
      	
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h3>เปลี่ยนแปลงรหัสผ่าน</h3>
        </div>

        <div class="modal-body">
    		<form id="form2" class="form-horizontal" method="post">
    			<fieldset>
    				<div class="control-group">
			            <label class="control-label" for="username">ชื่อเข้าใช้*</label>
			            <div class="controls">
			              <input type="text" class="input-large disabled" id="username" name="username" value="<?=$_SESSION['username']?>" disabled>
			              <input type="hidden" name="changepwd" value="true" />
			            </div>
			          </div>

			          <div class="control-group">
			            <label class="control-label" for="password">รหัสผ่าน*</label>
			            <div class="controls">
			              <input type="password" class="input-large" id="password" name="password">
			            </div>
			          </div>

			          <div class="control-group">
			            <label class="control-label" for="confirmpwd">ยืนยันรหัสผ่าน*</label>
			            <div class="controls">
			              <input type="password" class="input-large" id="confirmpwd" name="confirmpwd">
			              <div id="cfmnotify"></div>
			            </div>
			          </div>
    			</fieldset>	
    		</form>      
        </div>

        <div class="modal-footer">
          <a href="#" class="btn" data-dismiss="modal" >ปิด</a>
          <a href="#" id="cmdchange" class="btn btn-primary">บันทึก</a>
        </div>
    	
      </div>

    <?php include 'layout/javascript.php'; ?>
	<script>
		$(function() {
			// Datepicker
			$(".birthdate").datepicker({ dateFormat: "dd MM yy"
										, changeYear: true
										, changeMonth: true
										, yearRange: "1970:2015"
										, monthNames: ["มกราคม","กุมภาพันธ์","มีนาคม","เมษายน","พฤษภาคม","มิถุนายน","กรกฎาคม","สิงหาคม","กันยายน","ตุลาคม","พฤศจิกายน","ธันวาคม"]
										, monthNamesShort: ["ม.ค.","ก.พ.","มี.ค.","เม.ย.","พ.ค.","มิ.ย.","ก.ค.","ส.ค.","ก.ย.","ต.ย.","พ.ย.","ธ.ค."]
										, dayNames: ["อาทิตย์", "จันทร์", "อังคาร", "พุธ", "พฤหัส", "ศุกร์", "เสาร์"]
										, dayNamesMin: ["อา.", "จ.", "อ.", "พ.", "พฤ.", "ศ.", "ส."]
										, dayNamesShort: ["อา.", "จ.", "อ.", "พ.", "พฤ.", "ศ.", "ส."] });

			// Password and confirmation box listener
			$("#confirmpwd").blur(function(){
				var pwd = $("#password").val();
				var cfm = $(this).val();
				if ( pwd != cfm ) {
					$("#cfmnotify").text("เตือน! กรุณากรอกรหัสผ่านให้เหมือนเดิม");
					$("#cfmnotify").addClass("alert");
					$(this).val("");
					$(this).focus();
				} else {
					$("#cfmnotify").text("");
					$("#cfmnotify").removeClass("alert");
				}
			});

			// Change password event listener
			$("#cmdchange").click(function(){
				var pwd = $("#password").val();
				var cfm = $("#confirmpwd").val();
				if ( pwd != '' && cfm != '' && pwd == cfm ) {
					$("#form2").submit();
				} else {
					$("#cfmnotify").text("เตือน! กรุณากรอกรหัสผ่านให้เหมือนเดิม");
					$("#cfmnotify").addClass("alert");
					$(this).val("");
					$(this).focus();
				}
			});
		});
	</script>
  </body>
</html>
