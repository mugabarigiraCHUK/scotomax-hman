<?php include 'config/configure.php'; ?>
<?php include 'controller/cbs_controller.php'; ?>
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
		          <li><a href="trainee.php">นักเรียน</a></li>
		          <li><a href="courselist.php">เปิดสอน</a></li>
		      	  <li><a href="series.php">แบบทดสอบ</a></li>
		          
		          <li class="nav-header">System</li>
		          <li><a href="department.php">ภาควิชา</a></li>
		          <li class="active"><a href="cbs_dept.php">ภาควิชาพาณิชฯ</a></li>
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
	            	<form class="form-horizontal" method="post">
				    	<fieldset>
						
				          <div class="control-group">
				            <label class="control-label" for="n_cbs_id">รหัสภาคพาณิชยศาสตร์การบัญชี*</label>
				            <div class="controls">
				        	<?php if ( $cbs_id ) { ?>
				              <input type="text" class="input-large disabled" id="n_cbs_id" name="n_cbs_id" value="<?=$cbs_id?>" disabled>
				              <input type="hidden" name="cbs_id" value="<?=$cbs_id?>">
				            <?php } else { ?>
				              <input type="text" class="input-large" id="n_cbs_id" name="n_cbs_id">
							<?php } ?>		            
				            </div>
				          </div>

				          <div class="control-group">
				            <label class="control-label" for="n_cbs_department">ภาคพาณิชยศาสตร์การบัญชีวิชา*</label>
				            <div class="controls">
				              <input type="text" class="input-large" id="n_cbs_department" name="n_cbs_department" value="<?=$cbs_department?>">
				            </div>
				          </div>
				
				          <div class="form-actions">
				          	<?php if ( $cbs_id ) { ?>
					      	<button type="submit" class="btn btn-primary">ปรับปรุงข้อมูล</button> &nbsp;&nbsp;
					      	<?php } else { ?>
					      	<button type="submit" class="btn btn-primary">เพิ่มข้อมูล</button> &nbsp;&nbsp;
					      	<?php } ?>
					        <a href="cbs_dept.php" class="btn btn-danger">ยกเลิก</a>
					      </div>
				
				        </fieldset>
				      </form>

	            </p>
	            <p>
	            	  
	            	<table class="table table-bordered">
				        <thead>
				          <tr>
				            <th>#</th>
				            <th>รหัสพาณิชยศาสตร์การบัญชี </th>
				            <th>ภาคพาณิชยศาสตร์การบัญชีวิชา</th>
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
					            <td><?=$value['CBS_ID']?></td>
					            <td><?=iconv("TIS-620","UTF-8", $value['CBS_DEPARTMENT'])?></td>
					            <td><a href="cbs_dept.php?cbs_id=<?=$value['CBS_ID']?>" class="btn btn-small btn-info">แก้ไข</a></td>
					            <td><a href="cbs_dept.php?remove_id=<?=$value['CBS_ID']?>" class="btn btn-small btn-danger" onclick="if (!confirm('คุณต้องการลบข้อมูลดังกล่าว?')) { return false; } ">ลบข้อมูล</a></td>
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
