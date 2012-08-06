<?php include 'config/configure.php'; ?>
<?php include 'controller/series_controller.php'; ?>
<!DOCTYPE html>
<html lang="en">
  <head>
	<meta charset="utf-8">
    <title>Training Center เราเปิดสอนฯ</title>
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
		          <li><a href="courselist.php">เปิดสอน</a></li>
		      	  <li class="active"><a href="series.php">แบบทดสอบ</a></li>
		          
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
	            
				<h3>แบบทดสอบ</h3>
			    <p>
	            	<form id="form1" class="form-horizontal" method="post">
				    	<fieldset>
						
				          <div class="control-group">
				            <label class="control-label" for="n_exam_no">แบบทดสอบ*</label>
				            <div class="controls">
				        	<?php if ( $exam_no ) { ?>
				              <input type="text" class="input-large disabled" id="n_exam_no" name="n_exam_no" value="<?=$exam_no?>" disabled>
				              <input type="hidden" name="exam_no" value="<?=$exam_no?>">
				            <?php } else { ?>
				              <input type="text" class="input-large" id="n_exam_no" name="n_exam_no">
							<?php } ?>		            
				            </div>
				          </div>

				          <div class="control-group">
				          	<label class="control-label" for="n_course_id">วิชา*</label>
				          	<div class="controls">
				          		<select class="input-large" id="n_course_id" name="n_course_id">
				          			<option value=""> - โปรดเลือก - </option>
				          			<?php 
					              		if ( isset($courses) ) {
					              			foreach ($courses as $key => $value) { 
					              				if ( $key == $course_id ) { 
					              					echo '<option value="'.$key.'" selected>'.$value['COURSE_NAME'].'</option>';
					              				} else {
					              					echo '<option value="'.$key.'">'.$value['COURSE_NAME'].'</option>';
					              				}
								    		}
								    	}
								    ?>
				          		</select>
				          	</div>
				          </div>

				          <div class="control-group">
				            <label class="control-label" for="n_full_score">คะแนนเต็ม*</label>
				            <div class="controls">
				              <input type="text" class="input-small" id="n_full_score" name="n_full_score" value="<?=$full_score?>">
				            </div>
				          </div>

				          <div class="control-group">
				            <label class="control-label" for="n_exam_desc">รายละเอียด</label>
				            <div class="controls">
				              <textarea class="input-xlarge" id="n_exam_desc" name="n_exam_desc" rows="3"><?=$exam_desc?></textarea>
				            </div>
				          </div>
				
				          <div class="form-actions">
				          	<?php if ( $exam_no ) { ?>
					      	<button type="submit" class="btn btn-primary">ปรับปรุงข้อมูล</button> &nbsp;&nbsp;
					      	<?php } else { ?>
					      	<button type="submit" class="btn btn-primary">เพิ่มข้อมูล</button> &nbsp;&nbsp;
					      	<?php } ?>
					        <a href="series.php" class="btn btn-danger">ยกเลิก</a>
					      </div>
				
				        </fieldset>
				    </form>

	            </p>
	            <p>
	            	  
	            	<table class="table table-bordered">
				        <thead>
				          <tr>
				            <th>#</th>
				            <th>วิชา</th>
				            <th>รหัสแบบทดสอบ</th>
				            <th>คะแนนเต็ม</th>
				            <th>&nbsp;</th>
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
					            <td><?=iconv("TIS-620","UTF-8", $value['COURSE_NAME'])?></td>
					            <td><?=$value['EXAM_NO']?></td>
					            <td><?=$value['FULL_SCORE']?></td>
					            <td><a href="exam.php?exam_no=<?=$value['EXAM_NO']?>" class="btn btn-small btn-info">แบบทดสอบ</a></td>
					            <td><a href="series.php?exam_no=<?=$value['EXAM_NO']?>" class="btn btn-small btn-info">แก้ไข</a></td>
					            <td><a href="series.php?remove_id=<?=$value['EXAM_NO']?>" class="btn btn-small btn-danger" onclick="if (!confirm('คุณต้องการลบข้อมูลดังกล่าว?')) { return false; } ">ลบข้อมูล</a></td>
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
  </body>
</html>
