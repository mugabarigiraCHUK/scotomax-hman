<?php include 'config/configure.php'; ?>
<?php include 'controller/trainer_controller.php'; ?>
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
		          <li><a href="trainee.php">นักเรียน</a></li>
		          <li><a href="courselist.php">เปิดสอน</a></li>
		      	  <li><a href="series.php">แบบทดสอบ</a></li>
		          
		          <li class="nav-header">System</li>
		          <li><a href="department.php">ภาควิชา</a></li>
		          <li><a href="cbs_dept.php">ภาควิชาพาณิชฯ</a></li>
		          <li class="active"><a href="trainer.php">ข้อมูลผู้สอน</a></li>
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
	            
				<h3>ข้อมูลส่วนตัว</h3>
			    <p>
	            	<form class="form-horizontal" method="post">
				    	<fieldset>
				
				          <div class="control-group">
				            <label class="control-label" for="n_firstname">ชื่อ*</label>
				            <div class="controls">
				              <input type="text" class="input-large" id="n_firstname" name="n_firstname" value="<?=$firstname?>">
				            </div>
				          </div>
				
				          <div class="control-group">
				            <label class="control-label" for="n_lastname">นามสกุล*</label>
				            <div class="controls">
				              <input type="text" class="input-large" id="n_lastname" name="n_lastname" value="<?=$lastname?>">
				            </div>
				          </div>
				
						  <div class="control-group">
				            <label class="control-label" for="n_gender">เพศ*</label>
				            <div class="controls">
				              <input type="text" class="input-medium" id="n_gender" name="n_gender" value="<?=$gender?>">
				            </div>
				          </div>

				          <div class="control-group">
				            <label class="control-label" for="n_phone_no">โทรศัพท์*</label>
				            <div class="controls">
				              <input type="text" class="input-medium" id="n_phone_no" name="n_phone_no" value="<?=$phone_no?>">
				            </div>
				          </div>

				          <div class="control-group">
				            <label class="control-label" for="n_email">E-mail*</label>
				            <div class="controls">
				              <input type="text" class="input-large" id="n_email" name="n_email" value="<?=$email?>">
				            </div>
				          </div>

				          <div class="control-group">
				            <label class="control-label" for="n_degree">ระดับการศึกษา</label>
				            <div class="controls">
				              <input type="text" class="input-large" id="n_degree" name="n_degree" value="<?=$degree?>">
				            </div>
				          </div>

				          <div class="control-group">
				            <label class="control-label" for="n_program">สาขาศึกษา</label>
				            <div class="controls">
				              <input type="text" class="input-large" id="n_program" name="n_program" value="<?=$program?>">
				            </div>
				          </div>

				          <div class="control-group">
				            <label class="control-label" for="n_university">สถาบันศึกษา</label>
				            <div class="controls">
				              <input type="text" class="input-large" id="n_university" name="n_university" value="<?=$university?>">
				            </div>
				          </div>

						  <div class="control-group">
				            <label class="control-label" for="n_dep_id">ภาควิชา</label>
				            <div class="controls">
				              	<select name="n_dep_id" id="n_dep_id" class="input-large">
				              		<option value=""> - โปรดเลือก - </option>
				              	<?php 
				              		if ( isset($deplist) ) {
				              			foreach ($deplist as $key => $value) { 
				              				if ( $key == $dep_id ) { 
				              					echo '<option value="'.$key.'" selected>'.$value['DEPARTMENT_NAME'].'</option>';
				              				} else {
				              					echo '<option value="'.$key.'">'.$value['DEPARTMENT_NAME'].'</option>';
				              				}
							    		}
							    	}
							    ?>
							    </select>
				            </div>
				          </div>
				
				          <div class="form-actions">
				          	<?php if ( $trainer_id ) { ?>
				          	<input type="hidden" id="trainer_id" name="trainer_id" value="<?=$trainer_id?>" />
					      	<button type="submit" class="btn btn-primary">ปรับปรุงข้อมูล</button> &nbsp;&nbsp;
					      	<?php } else { ?>
					      	<button type="submit" class="btn btn-primary">เพิ่มข้อมูล</button> &nbsp;&nbsp;
					      	<?php } ?>
					        <a href="trainer.php" class="btn btn-danger">ยกเลิก</a>
					      </div>
				
				        </fieldset>
				      </form>

	            </p>
	            <p>
	            	  
	            	<table class="table table-bordered">
				        <thead>
				          <tr>
				            <th>#</th>
				            <th>รหัส</th>
				            <th>ชื่อ</th>
				            <th>สกุล</th>
				            <th>สาขาวิชา</th>
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
					            <td><?=$value['TRAINER_ID']?></td>
					            <td><?=iconv("TIS-620","UTF-8", $value['FIRSTNAME'])?></td>
					            <td><?=iconv("TIS-620","UTF-8", $value['LASTNAME'])?></td>
					            <td><?=iconv("TIS-620","UTF-8", $value['PROGRAM'])?></td>
					            <td><?=iconv("TIS-620","UTF-8", $value['DEPARTMENT_NAME'])?></td>
					            <td><a href="trainer.php?trainer_id=<?=$value['TRAINER_ID']?>" class="btn btn-small btn-info">แก้ไข</a></td>
					            <td><a href="trainer.php?remove_id=<?=$value['TRAINER_ID']?>" class="btn btn-small btn-danger" onclick="if (!confirm('คุณต้องการลบข้อมูลดังกล่าว?')) { return false; } ">ลบข้อมูล</a></td>
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
