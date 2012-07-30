<?php include 'config/configure.php'; ?>
<?php include 'controller/signup_controller.php'; ?>
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
					<!-- // No authorize for navigation -->
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
	            	<form class="form-horizontal" method="post">
	            		<fieldset>
	            			<legend>ข้อมูลระบบ</legend>

	            			  <div class="control-group">
					            <label class="control-label" for="username">ชื่อเข้าใช้*</label>
					            <div class="controls">
					              <input type="text" class="input-large" id="username" name="username" value="<?=$_POST['username']?>">
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

				    	<fieldset>
				    		<legend>ข้อมูลบุคคล</legend>

							<div class="control-group">
					            <label class="control-label" >คำนำหน้าชื่อ*</label>
					            <div class="controls">
									<select name="title" id="title" class="input-small">
						          		<option value="ดช" <?php if ('ดช'==$_POST['title']) printf('selected') ?>>ดช</option>
						          		<option value="ดญ" <?php if ('ดญ'==$_POST['title']) printf('selected') ?>>ดญ</option>
							      		<option value="นาย" <?php if ('นาย'==$_POST['title']) printf('selected') ?>>นาย</option>
							      		<option value="นางสาว" <?php if ('นางสาว'==$_POST['title']) printf('selected') ?>>นางสาว</option>
							      		<option value="นาง" <?php if ('นาง'==$_POST['title']) printf('selected') ?>>นาง</option>
							      	</select>
					            </div>
					          </div>
					
					          <div class="control-group">
					            <label class="control-label" for="firstname">ชื่อ*</label>
					            <div class="controls">
					              <input type="text" class="input-large" id="firstname" name="firstname" value="<?=$_POST['firstname']?>">
					            </div>
					          </div>
					
					          <div class="control-group">
					            <label class="control-label" for="lastname">นามสกุล*</label>
					            <div class="controls">
					              <input type="text" class="input-large" id="lastname" name="lastname" value="<?=$_POST['lastname']?>">
					            </div>
					          </div>
					
							  <div class="control-group">
					            <label class="control-label" for="id_number">เลขประจำตัวประชาชน*</label>
					            <div class="controls">
					              <input type="text" class="input-large" id="id_number" name="id_number" value="<?=$_POST['id_number']?>">
					            </div>
					          </div>
					
							  <div class="control-group">
					            <label class="control-label" for="birthdate">วันเกิด*</label>
					            <div class="controls">
								  <div class="input-prepend">
								    <span class="add-on"><i class="icon-calendar"></i></span>
									<input class="input-large birthdate" id="inputIcon" type="text" id="birthdate" name="birthdate" value="<?=$_POST['birthdate']?>">
								  </div>
					            </div>
					          </div>
					         
					          <div class="control-group">
					            <label class="control-label" for="address">ที่อยู่*</label>
					            <div class="controls">
								  <textarea class="input-xlarge" id="textarea" rows="3" id="address" name="address"><?=$_POST['address']?></textarea>
					            </div>
					          </div>
					
							  <div class="control-group">
					            <label class="control-label" for="province">จังหวัด*</label>
					            <div class="controls">
					              <input type="text" class="input-large" id="province" name="province" value="<?=$_POST['province']?>">
					            </div>
					          </div>
					
							  <div class="control-group">
					            <label class="control-label" for="phone_no">เบอร์โทรศัพท์*</label>
					            <div class="controls">
					              <input type="text" class="input-large" id="phone_no" name="phone_no" value="<?=$_POST['phone_no']?>">
					            </div>
					          </div>
					
							  <div class="control-group">
					            <label class="control-label" for="email">อีเมล์*</label>
					            <div class="controls">
								  <div class="input-prepend">
								    <span class="add-on"><i class="icon-envelope"></i></span>
									<input class="input-xlarge" id="inputIcon" type="text" id="email" name="email" value="<?=$_POST['email']?>">
								  </div>
					            </div>
					          </div>
					
							  <div class="control-group">
					            <label class="control-label" for="institute_name">ชื่อสถาบันการศึกษา</label>
					            <div class="controls">
					              <input type="text" class="input-xlarge" id="institute_name" name="institute_name" value="<?=$_POST['institute_name']?>">
					            </div>
					          </div>
					
							  <div class="control-group">
					            <label class="control-label">ระดับการศึกษา</label>
					            <div class="controls">
					              	<select name="edu_level" id="edu_level" class="input-medium">
							          <option value="มัธยมปลาย" <?php if ('มัธยมปลาย'==$_POST['edu_level']) printf('selected') ?>>มัธยมปลาย</option>
							          <option value="ปริญญาตรี" <?php if ('ปริญญาตรี'==$_POST['edu_level']) printf('selected') ?>>ปริญญาตรี</option>
								      <option value="อื่นๆ" <?php if ('อื่นๆ'==$_POST['edu_level']) printf('selected') ?>>อื่นๆ</option>
								    </select>
					            </div>
					          </div>
					
					          <div class="control-group">
					            <label class="control-label" for="gpa">เกรดเฉลี่ย</label>
					            <div class="controls">
					              <input type="text" class="input-small" id="gpa" name="gpa" value="<?=$_POST['gpa']?>">
					            </div>
					          </div>
					
					          <div class="form-actions">
					            <button type="submit" class="btn btn-primary">สมัคร</button> &nbsp;&nbsp;
					            <button type="reset" class="btn btn-danger">ยกเลิก</button>
					          </div>
		
				        </fieldset>
				      </form>

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
    <?php include 'layout/javascript.php'; ?>
	<script>
		$(function() {
			$(".birthdate").datepicker({ dateFormat: "dd MM yy"
										, changeYear: true
										, changeMonth: true
										, yearRange: "1970:2015"
										, monthNames: ["มกราคม","กุมภาพันธ์","มีนาคม","เมษายน","พฤษภาคม","มิถุนายน","กรกฎาคม","สิงหาคม","กันยายน","ตุลาคม","พฤศจิกายน","ธันวาคม"]
										, monthNamesShort: ["ม.ค.","ก.พ.","มี.ค.","เม.ย.","พ.ค.","มิ.ย.","ก.ค.","ส.ค.","ก.ย.","ต.ย.","พ.ย.","ธ.ค."]
										, dayNames: ["อาทิตย์", "จันทร์", "อังคาร", "พุธ", "พฤหัส", "ศุกร์", "เสาร์"]
										, dayNamesMin: ["อา.", "จ.", "อ.", "พ.", "พฤ.", "ศ.", "ส."]
										, dayNamesShort: ["อา.", "จ.", "อ.", "พ.", "พฤ.", "ศ.", "ส."] });
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
		});
	</script>
  </body>
</html>
