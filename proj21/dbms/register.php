<?php include 'config/configure.php'; ?>
<?php include 'controller/register_controller.php'; ?>
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
		          <li class="active"><a href="register.php">Register</a></li>
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
	            
				<h3>ลงทะเบียน</h3>
			    <p>
	            	<form class="form-horizontal" method="post">
				    	<fieldset>
				
				          <div class="control-group">
				            <label class="control-label" for="">สาขาวิชาที่ต้องการศึกษาต่อในคณะพาณิชศาสตร์และการบัญชี</label>
				            <div class="controls">
				              	<select name="cbs_id" id="cbs_id" class="input-large">
								<?php //--> selection list of CBS Department
									if ( isset($deptlist) ) { 
										foreach ($deptlist as $key => $value) {
								?>
						          			<option value="<?=$key?>"><?=$value?></option>
								<?php 
										}
									} 
								?>
							    </select>
				            </div>
				          </div>
				
				          <div class="control-group">
				            <label class="control-label" for="">วิชาที่ต้องการลงทะเบียนเรียน</label>
				            <div class="controls">
								<select name="course_id" id="course_id" class="input-large">
								<?php //--> selection list of course
									if ( isset($courselist) ) { 
										foreach ($courselist as $key => $value) {
								?>
						          			<option value="<?=$key?>"><?=$value?></option>
								<?php 
										}
									} 
								?>
							    </select>
				            </div>
				           </div>
				
				          <div class="form-actions">
				            <button type="submit" class="btn btn-primary">ลงทะเบียน</button> &nbsp;&nbsp;
				            <button type="reset" class="btn btn-primary">ยกเลิก</button>
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
			
		});
	</script>
  </body>
</html>
