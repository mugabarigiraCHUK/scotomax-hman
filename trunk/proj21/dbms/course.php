<?php include 'config/configure.php'; ?>
<?php include 'controller/course_controller.php'; ?>
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
		          <li><a href="trainee_grade.php">นักเรียน</a></li>
		          <li><a href="class.php">ตารางเรียน</a></li>
		          <li><a href="cbs_course.php">แผนเรียนภาคพาณิชฯ</a></li>
		      	  <li><a href="course_trainer.php">แผนการสอน</a></li>
		      	  <li><a href="course_schedule.php">แผนการเรียน</a></li>
		      	  <li><a href="exam_series.php">แบบทดสอบ</a></li>
		          
		          <li class="nav-header">System</li>
		          <li><a href="department.php">ภาค</a></li>
		          <li><a href="cbs_dept.php">ภาคพาณิชฯ</a></li>
		          <li><a href="trainer.php">ข้อมูลผู้สอน</a></li>
		          <li class="active"><a href="course.php">วิชา</a></li>
		          <li><a href="classroom.php">ห้องเรียน</a></li>
		          
		
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
	            
				<h3>ข้อมูลภาควิชา</h3>
			    <p>
	            	<form class="form-horizontal" method="post">
				    	<fieldset>
						
				          <div class="control-group">
				            <label class="control-label" for="n_classroom_id">รหัสวิชา*</label>
				            <div class="controls">
				        	<?php if ( $course_id ) { ?>
				              <input type="text" class="input-large disabled" id="n_course_id" name="n_course_id" value="<?=$course_id?>" disabled>
				              <input type="hidden" name="course_id" value="<?=$course_id?>">
				            <?php } else { ?>
				              <input type="text" class="input-large" id="n_course_id" name="n_course_id">
							<?php } ?>
				            </div>
				          </div>

				          <div class="control-group">
				            <label class="control-label" for="n_course_name">วิชา*</label>
				            <div class="controls">
				              <input type="text" class="input-medium" id="n_course_name" name="n_course_name" value="<?=$course_name?>">
				            </div>
				          </div>

				          <div class="control-group">
				            <label class="control-label" for="n_course_fee">ค่าลงทะเบียน*</label>
				            <div class="controls">
				              <input type="text" class="input-small" id="n_course_fee" name="n_course_fee" value="<?=$course_fee?>">
				            </div>
				          </div>

				          <div class="control-group">
				            <label class="control-label" for="n_course_start">เริ่มเมื่อ*</label>
				            <div class="controls">
				              <div class="input-prepend">
							    <span class="add-on"><i class="icon-calendar"></i></span>
								<input class="datepick input-large" type="text" id="n_course_start" name="n_course_start" value="<?=$course_start?>">
							  </div>
				            </div>
				          </div>

				          <div class="control-group">
				            <label class="control-label" for="n_course_end">เสร็จสิ้น*</label>
				            <div class="controls">
				              <div class="input-prepend">
							    <span class="add-on"><i class="icon-calendar"></i></span>
								<input class="datepick input-large" type="text" id="n_course_end" name="n_course_end" value="<?=$course_end?>">
							  </div>
				            </div>
				          </div>
				
				          <div class="form-actions">
				          	<?php if ( $course_id ) { ?>
					      	<button type="submit" class="btn btn-primary">ปรับปรุงข้อมูล</button> &nbsp;&nbsp;
					      	<?php } else { ?>
					      	<button type="submit" class="btn btn-primary">เพิ่มข้อมูล</button> &nbsp;&nbsp;
					      	<?php } ?>
					        <a href="course.php" class="btn btn-danger">ยกเลิก</a>
					      </div>
				
				        </fieldset>
				      </form>

	            </p>
	            <p>
	            	  
	            	<table class="table table-bordered">
				        <thead>
				          <tr>
				            <th>#</th>
				            <th>รหัสวิชา</th>
				            <th>วิชา</th>
				            <th>ค่าลงทะเบียน</th>
				            <th>เริ่มเมื่อ</th>
				            <th>เสร็จสิ้น</th>
				            <th>&nbsp;</th>
				            <th>&nbsp;</th>
				          </tr>
				        </thead>
				        <?php if ( $nrows > 0 ) { ?>
				        <tbody>
				          <?php 
				          	$idx = 0;
				          	foreach ($result as $key => $value) { 
				          		$idx++;
				          ?>
					          <tr>
					            <td><?=$idx?></td>
					            <td><?=$value['COURSE_ID']?></td>
					            <td><?=iconv("TIS-620","UTF-8", $value['COURSE_NAME'])?></td>
					            <td><?=$value['COURSE_FEE']?></td>
					            <td><?=utils::oradate2text($value['COURSE_START'])?></td>
					            <td><?=utils::oradate2text($value['COURSE_END'])?></td>
					            <td><a href="course.php?course_id=<?=$value['COURSE_ID']?>" class="btn btn-small btn-info">แก้ไข</a></td>
					            <td><a href="course.php?remove_id=<?=$value['COURSE_ID']?>" class="btn btn-small btn-danger" onclick="if (!confirm('คุณต้องการลบข้อมูลดังกล่าว?')) { return false; } ">ลบข้อมูล</a></td>
					          </tr>
				          <?php } ?>
				        </tbody>
				        <?php } ?>
				      </table>
				            
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
  </body>
</html>
