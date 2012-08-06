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
		          <li class="active"><a href="courselist.php">เปิดสอน</a></li>
		      	  <li><a href="exam_series.php">แบบทดสอบ</a></li>
		          
		          <li class="nav-header">System</li>
		          <li><a href="department.php">ภาควิชา</a></li>
		          <li><a href="cbs_dept.php">ภาควิชาพาณิชฯ</a></li>
		          <li><a href="trainer.php">ข้อมูลผู้สอน</a></li>
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
	            	<form id="form1" class="form-horizontal" method="post">
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
				          	<input type="submit" name="course" value="ปรับปรุงข้อมูล" class="btn btn-primary" />&nbsp;&nbsp;
					      	<?php } else { ?>
					      	<input type="submit" name="course" value="เพิ่มข้อมูล" class="btn btn-primary" />&nbsp;&nbsp;
					      	<?php } ?>
					        <a href="courselist.php" class="btn btn-danger">ยกเลิก</a>
					      </div>
				
				        </fieldset>
				      </form>

	            </p>
	            
	            <?php if ( isset( $course_id ) ) { ?>
	            <!-- ############################## Tab menus #################################### -->
	            <p>
	            	  <div class="tabbable" style="margin-bottom: 18px;">
				        <ul class="nav nav-tabs">
				          <li class="active"><a href="#tab1" data-toggle="tab">ห้องเรียน</a></li>
				          <li><a href="#tab2" data-toggle="tab">ตารางเรียน</a></li>
				          <li><a href="#tab3" data-toggle="tab">ผู้สอน</a></li>
				          <li><a href="#tab4" data-toggle="tab">ภาควิชาพาณิชฯ</a></li>
				        </ul>
				        <div class="tab-content" style="padding-bottom: 9px; border-bottom: 1px solid #ddd;">
				          <div class="tab-pane active" id="tab1">
				            <p>
				            	<form id="form2" method="POST" action="course.php">
				            	  <table class="table table-bordered">
							        <thead>
							          <tr>
							            <th>#</th>
							            <th>รหัสห้อง</th>
							            <th>เลขที่ห้อง</th>
							            <th>ที่นั่งทั้งหมด</th>
							          </tr>
							        </thead>
							        <tbody>
							        <?php 
							        	if ( $classrooms ) {
							        		foreach ( $classrooms as $key => $value ) {
							        ?>
							          <tr>
							            <td><input type="checkbox" name="classroom_id[]" value="<?=$key?>" <?php if ($selectedClass[$key]) printf('checked'); ?>/></td>
							            <td><?=$key?></td>
							            <td><?=$value['ROOM_NO']?></td>
							            <td><?=$value['MAX_SEAT']?></td>
							          </tr>
							         <?php
							         		}
							         	}
							         ?>
							        </tbody>
							        <tfoot>
							        	<tr>
							        		<td colspan="4">
							        			<input type="submit" name="class" value="ปรับปรุงข้อมูล" class="btn btn-small btn-info"/>
							        			<input type="hidden" name="course_id" value="<?=$course_id?>" />
							        		</td>
							        	</tr>
							        </tfoot>
							      </table>
							   	</form>
				            </p>
				          </div>
				          <div class="tab-pane" id="tab2">
				            <p>
				              <form id="form3" method="POST" action="course.php">
				            	<table class="table table-bordered">
							        <thead>
							          <tr>
							            <th>#</th>
							            <th>วันที่</th>
							            <th>เริ่มเวลา</th>
							            <th>เลิกเวลา</th>
							            <th>จำนวนชั่วโมง</th>
							            <th>&nbsp;</th>
							          </tr>
							        </thead>
							        <tbody>
							        <?php
							        	if ( $schedules ) {
							        		$idx = 0;
							        		foreach ( $schedules as $key => $value ) {
							        			$idx++;
							        ?>
							          <tr>
							            <td><?=$idx?></td>
							            <td><?=$value['DAY']?></td>
							            <td><?=$value['BEGIN_TIME']?></td>
							            <td><?=$value['END_TIME']?></td>
							            <td><?=$value['HOURS']?></td>
							            <td><a href="course.php?course_id=<?=$course_id?>&reschedule_id=<?=$key?>" 
							            	   class="btn btn-small btn-danger" 
							            	   onclick="if (!confirm('คุณต้องการลบข้อมูลดังกล่าว?')) { return false; } ">ลบข้อมูล</a></td>
							          </tr>
							        <?php
							        		} 
							        	}
							        ?>
							          <tr>
							          	<td>&nbsp;</td>
							            <td>
							            	<div class="input-prepend">
											    <span class="add-on"><i class="icon-calendar"></i></span>
												<input class="datepick input-medium" type="text" id="day" name="day">
											</div>
							            </td>
							            <td>
							            	<input type="text" class="input-mini" name="begin_time" />
							            </td>
							            <td>
							            	<input type="text" class="input-mini" name="end_time" />
							            </td>
							            <td>&nbsp;</td>
							            <td>
							            	<input type="submit" name="schedule" value="เพิ่ม" class="btn btn-small btn-info" />
							            	<input type="hidden" name="course_id" value="<?=$course_id?>" />
							            </td>
							          </tr>

							        </tbody>
							      </table>
							    </form>
				            </p>
				          </div>
				          <div class="tab-pane" id="tab3">
				            <p>
				            	<form id="form3" method="POST" action="course.php">
				            	  <table class="table table-bordered">
							        <thead>
							          <tr>
							            <th>#</th>
							            <th>รหัสผู้สอน</th>
							            <th>ชื่อผู้สอน</th>
							          </tr>
							        </thead>
							        <tbody>
							        <?php 
							        	if ( $trainers ) {
							        		foreach ( $trainers as $key => $value ) {
							        ?>
							          <tr>
							            <td><input type="checkbox" name="trainer_id[]" value="<?=$key?>" <?php if ($selectedTrainer[$key]) printf('checked'); ?>/></td>
							            <td><?=$key?></td>
							            <td><?=$value['FIRSTNAME']?> <?=$value['LASTNAME']?></td>
							          </tr>
							         <?php
							         		}
							         	}
							         ?>
							        </tbody>
							        <tfoot>
							        	<tr>
							        		<td colspan="3">
							        			<input type="submit" name="trainer" value="ปรับปรุงข้อมูล" class="btn btn-small btn-info" />
							        			<input type="hidden" name="course_id" value="<?=$course_id?>" />
							        		</td>
							        	</tr>
							        </tfoot>
							      </table>
							   	</form>
				            </p>
				          </div>
				          <div class="tab-pane" id="tab4">
				            <p>
				            	<form id="form4" method="POST" action="course.php">
				            	  <table class="table table-bordered">
							        <thead>
							          <tr>
							            <th>#</th>
							            <th>รหัสวิชาภาคพาณิชฯ</th>
							            <th>ชื่อวิชาภาคพาณิชฯ</th>
							          </tr>
							        </thead>
							        <tbody>
							        <?php 
							        	if ( $cbsdeps ) {
							        		foreach ( $cbsdeps as $key => $value ) {
							        ?>
							          <tr>
							            <td><input type="checkbox" name="cbs_id[]" value="<?=$key?>" <?php if ($selectedCbs[$key]) printf('checked'); ?>/></td>
							            <td><?=$key?></td>
							            <td><?=$value['CBS_DEPARTMENT']?></td>
							          </tr>
							         <?php
							         		}
							         	}
							         ?>
							        </tbody>
							        <tfoot>
							        	<tr>
							        		<td colspan="3">
							        			<input type="submit" name="cbs" value="ปรับปรุงข้อมูล" class="btn btn-small btn-info" />
							        			<input type="hidden" name="course_id" value="<?=$course_id?>" />
							        		</td>
							        	</tr>
							        </tfoot>
							      </table>
							   	</form>
				            </p>
				          </div>

				        </div>
				      </div> 
	            </p>
	        	
	            <?php } ?>

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
