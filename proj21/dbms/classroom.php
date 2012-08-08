<?php include 'config/configure.php'; ?>
<?php include 'controller/classroom_controller.php'; ?>
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
		          <li><a href="cbs_dept.php">ภาควิชาพาณิชฯ</a></li>
		          <li><a href="trainer.php">ข้อมูลผู้สอน</a></li>
		          <li class="active"><a href="classroom.php">ห้องเรียน</a></li>
		          
		
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
				            <label class="control-label" for="n_classroom_id">รหัสห้องเรียน*</label>
				            <div class="controls">
				        	<?php if ( $classroom_id ) { ?>
				              <input type="text" class="input-large disabled" id="n_classroom_id" name="n_classroom_id" value="<?=$classroom_id?>" disabled>
				              <input type="hidden" name="classroom_id" value="<?=$classroom_id?>">
				            <?php } else { ?>
				              <input type="text" class="input-large" id="n_classroom_id" name="n_classroom_id">
							<?php } ?>		            
				            </div>
				          </div>

				          <div class="control-group">
				            <label class="control-label" for="n_room_no">ห้องเรียนเลขที่*</label>
				            <div class="controls">
				              <input type="text" class="input-medium" id="n_room_no" name="n_room_no" value="<?=$room_no?>">
				            </div>
				          </div>

				          <div class="control-group">
				            <label class="control-label" for="n_max_seat">จำนวนที่นั้งทั้งหมด*</label>
				            <div class="controls">
				              <input type="text" class="input-small" id="n_max_seat" name="n_max_seat" value="<?=$max_seat?>">
				            </div>
				          </div>

				          <div class="control-group">
				            <label class="control-label" for="n_left_seat">จำนวนที่นั่งคงเหลือ*</label>
				            <div class="controls">
				              <input type="text" class="input-small" id="n_left_seat" name="n_left_seat" value="<?=$left_seat?>">
				            </div>
				          </div>
				
				          <div class="form-actions">
				          	<?php if ( $classroom_id ) { ?>
					      	<button type="submit" class="btn btn-primary">ปรับปรุงข้อมูล</button> &nbsp;&nbsp;
					      	<?php } else { ?>
					      	<button type="submit" class="btn btn-primary">เพิ่มข้อมูล</button> &nbsp;&nbsp;
					      	<?php } ?>
					        <a href="classroom.php" class="btn btn-danger">ยกเลิก</a>
					      </div>
				
				        </fieldset>
				      </form>

	            </p>
	            <p>
	            	  
	            	<table class="table table-bordered">
				        <thead>
				          <tr>
				            <th>#</th>
				            <th>รหัสห้องเรียน</th>
				            <th>ห้องเรียนเลขที่</th>
				            <th>จำนวนที่นั้ง</th>
				            <th>ที่นั่งเหลือว่าง</th>
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
					            <td><?=$value['CLASSROOM_ID']?></td>
					            <td><?=iconv("TIS-620","UTF-8", $value['ROOM_NO'])?></td>
					            <td><?=$value['MAX_SEAT']?></td>
					            <td><?=$value['LEFT_SEAT']?></td>
					            <td><a href="classroom.php?classroom_id=<?=$value['CLASSROOM_ID']?>" class="btn btn-small btn-info">แก้ไข</a></td>
					            <td><a href="classroom.php?remove_id=<?=$value['CLASSROOM_ID']?>" class="btn btn-small btn-danger" onclick="if (!confirm('คุณต้องการลบข้อมูลดังกล่าว?')) { return false; } ">ลบข้อมูล</a></td>
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
