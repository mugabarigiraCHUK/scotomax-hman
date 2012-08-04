<?php include 'config/configure.php'; ?>
<?php include 'controller/department_controller.php'; ?>
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
		          <li class="active"><a href="department.php">ภาค</a></li>
		          <li><a href="cbs_dept.php">ภาคพาณิชฯ</a></li>
		          <li><a href="trainer.php">ข้อมูลผู้สอน</a></li>
		          <li><a href="courselist.php">วิชา</a></li>
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
				            <label class="control-label" for="n_dep_id">รหัสภาควิชา*</label>
				            <div class="controls">
				        	<?php if ( $dep_id ) { ?>
				              <input type="text" class="input-large disabled" id="n_dep_id" name="n_dep_id" value="<?=$dep_id?>" disabled>
				              <input type="hidden" name="dep_id" value="<?=$dep_id?>">
				            <?php } else { ?>
				              <input type="text" class="input-large" id="n_dep_id" name="n_dep_id">
							<?php } ?>		            
				            </div>
				          </div>

				          <div class="control-group">
				            <label class="control-label" for="n_department_name">ภาควิชา*</label>
				            <div class="controls">
				              <input type="text" class="input-large" id="n_department_name" name="n_department_name" value="<?=$department_name?>">
				            </div>
				          </div>
				
				          <div class="form-actions">
				          	<?php if ( $dep_id ) { ?>
					      	<button type="submit" class="btn btn-primary">ปรับปรุงข้อมูล</button> &nbsp;&nbsp;
					      	<?php } else { ?>
					      	<button type="submit" class="btn btn-primary">เพิ่มข้อมูล</button> &nbsp;&nbsp;
					      	<?php } ?>
					        <a href="department.php" class="btn btn-danger">ยกเลิก</a>
					      </div>
				
				        </fieldset>
				      </form>

	            </p>
	            <p>
	            	  
	            	<table class="table table-bordered">
				        <thead>
				          <tr>
				            <th>#</th>
				            <th>รหัสภาควิชา</th>
				            <th>ภาควิชา</th>
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
					            <td><?=$value['DEP_ID']?></td>
					            <td><?=iconv("TIS-620","UTF-8", $value['DEPARTMENT_NAME'])?></td>
					            <td><a href="department.php?dep_id=<?=$value['DEP_ID']?>" class="btn btn-small btn-info">แก้ไข</a></td>
					            <td><a href="department.php?remove_id=<?=$value['DEP_ID']?>" class="btn btn-small btn-danger" onclick="if (!confirm('คุณต้องการลบข้อมูลดังกล่าว?')) { return false; } ">ลบข้อมูล</a></td>
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
