<?php include 'config/configure.php'; ?>
<?php include 'controller/trainee_controller.php'; ?>
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
		          <li class="active"><a href="trainee.php">นักเรียน</a></li>
		          <li><a href="courselist.php">เปิดสอน</a></li>
		      	  <li><a href="series.php">แบบทดสอบ</a></li>
		          
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
	            
				<h3>นักเรียน</h3>
			    <p>
	            	<div class="row">
						<div class="span3">
							<form id="form1" class="well" method="post" action="trainee.php">
								<label>รายวิชาที่เปิดสอน</label>
		  						<select size="10" id="course_id" name="course_id" style="width: 150px;">
		  							<?php 
		  								if ( $courselist ) {
		  									foreach ($courselist as $key => $value) {
		  										if ( $key == $course_id ) {
		  											echo '<option value="'.$key.'" selected>'.$value['COURSE_NAME'].'</option>';
		  										} else {
		  											echo '<option value="'.$key.'">'.$value['COURSE_NAME'].'</option>';
		  										}
					                		}
					                	}
					                ?>
					            </select>
							</form>
						</div>
						<div class="span9">
							<table class="table table-bordered">
						        <thead>
						          <tr>
						            <th>#</th>
						            <th>ชื่อ</th>
						            <th>บัตรประชาชน</th>
						            <th>Pre-test</th>
						            <th>Post-test</th>
						            <th>&nbsp;</th>
						            <th>&nbsp;</th>
						          </tr>
						        </thead>
						        <tbody>
						        <?php 
						        	if ( $traineelist ) {
						        		$idx = 0;
						        		foreach ( $traineelist as $key => $value ) {
						        			$idx++;
						        ?>
						          <tr>
						            <td><?=$idx?></td>
						            <td><?php echo $value['TITLE'].' '.$value['FIRSTNAME'].' '.$value['LASTNAME']; ?></td>
						            <td><?=$value['ID_NUMBER']?></td>
						            <td><?=$value['PRETEST_SCORE']?></td>
						            <td><?=$value['POSTTEST_SCORE']?></td>
						            <td><a href="trainee.php?std_code=<?=$value['ID_CODE']?>&course_id=<?=$course_id?>" 
						            	   class="btn btn-small btn-info">ข้อมูลนักเรียน</a></td>
						            <td><a href="trainee.php?std_cancel=<?=$value['ID_CODE']?>&course_id=<?=$course_id?>" 
						            	   class="btn btn-small btn-danger" 
						            	   onclick="if (!confirm('คุณต้องการลบข้อมูลดังกล่าว?')) { return false; } ">ยกเลิกลงทะเบียน</a></td>
						          </tr>
						         <?php
						         		}
						         	}
						         ?>
						        </tbody>
						    </table>
						</div>
					</div>
	            </p>
	            <?php if ( $std_code ) { ?>
	            <p>
	            	<form id="form2" class="form-horizontal" method="post" action="trainee.php">
				    	<fieldset>
						  
						  <div class="control-group">
				            <label class="control-label" >คำนำหน้าชื่อ*</label>
				            <div class="controls">
								<input type="text" class="input-large disabled" value="<?=$title?>" disabled/>
				            </div>
				          </div>
				
				          <div class="control-group">
				            <label class="control-label" for="firstname">ชื่อ*</label>
				            <div class="controls">
				              <input type="text" class="input-large disabled" value="<?=$firstname?>" disabled/>
				            </div>
				          </div>
				
				          <div class="control-group">
				            <label class="control-label" for="lastname">นามสกุล*</label>
				            <div class="controls">
				              <input type="text" class="input-large disabled" value="<?=$lastname?>" disabled/>
				            </div>
				          </div>
				
						  <div class="control-group">
				            <label class="control-label" for="id_number">เลขประจำตัวประชาชน*</label>
				            <div class="controls">
				              <input type="text" class="input-large disabled" value="<?=$id_number?>" disabled/>
				            </div>
				          </div>
				
						  <div class="control-group">
				            <label class="control-label" for="birthdate">วันเกิด*</label>
				            <div class="controls">
							  <div class="input-prepend">
							    <span class="add-on"><i class="icon-calendar"></i></span>
								<input class="input-large disabled" type="text" value="<?=$birthdate?>" disabled/>
							  </div>
				            </div>
				          </div>
				         
				          <div class="control-group">
				            <label class="control-label" for="address">ที่อยู่*</label>
				            <div class="controls">
							  <textarea class="input-xlarge disabled" id="textarea" rows="3" id="address" name="address" readonly><?=$address?></textarea>
				            </div>
				          </div>
				
						  <div class="control-group">
				            <label class="control-label" for="province">จังหวัด*</label>
				            <div class="controls">
				              <input type="text" class="input-large disabled" value="<?=$province?>" disabled/>
				            </div>
				          </div>
				
						  <div class="control-group">
				            <label class="control-label" for="phone_no">เบอร์โทรศัพท์*</label>
				            <div class="controls">
				              <input type="text" class="input-large disabled" value="<?=$phone_no?>" disabled/>
				            </div>
				          </div>
				
						  <div class="control-group">
				            <label class="control-label" for="email">อีเมล์*</label>
				            <div class="controls">
							  <div class="input-prepend">
							    <span class="add-on"><i class="icon-envelope"></i></span>
								<input class="input-xlarge disabled" type="text" value="<?=$email?>" disabled/>
							  </div>
				            </div>
				          </div>
				
						  <div class="control-group">
				            <label class="control-label" for="institute_name">ชื่อสถาบันการศึกษา</label>
				            <div class="controls">
				              <input type="text" class="input-xlarge disabled" value="<?=$institute_name?>" disabled/>
				            </div>
				          </div>
				
						  <div class="control-group">
				            <label class="control-label">ระดับการศึกษา</label>
				            <div class="controls">
				            	<input type="text" class="input-medium disabled" value="<?=$edu_level?>" disabled/>
				            </div>
				          </div>
				
				          <div class="control-group">
				            <label class="control-label" for="gpa">เกรดเฉลี่ย</label>
				            <div class="controls">
				              <input type="text" class="input-small disabled" value="<?=$gpa?>" disabled/>
				            </div>
				          </div>

				          <div class="control-group">
				            <label class="control-label" for="registered_date">ลงทะเบียนเมื่อ</label>
				            <div class="controls">
				              <input type="text" class="input-xlarge disabled" id="registered_date" name="registered_date" value="<?=$registered_date?>" disabled>
				            </div>
				          </div>
				
				        </fieldset>
				      </form>

	            </p>
	            <!-- ############################## Tab menus #################################### -->
	            <p>
            	  <div class="tabbable" style="margin-bottom: 18px;">
			        <ul class="nav nav-tabs">
			          <li class="active"><a href="#tab1" data-toggle="tab">ภาควิชาพาณิชฯ ที่ต้องการ</a></li>
			        </ul>
			        <div class="tab-content" style="padding-bottom: 9px; border-bottom: 1px solid #ddd;">
			          <div class="tab-pane active" id="tab1">
			            <p>
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
					            <td><input type="checkbox" value="<?=$key?>" class="disabled" <?php if ($preferedCbs[$key]) printf('checked'); ?> disabled/></td>
					            <td><?=$key?></td>
					            <td><?=$value['CBS_DEPARTMENT']?></td>
					          </tr>
					         <?php
					         		}
					         	}
					         ?>
					        </tbody>
					      </table>
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

    		$("#course_id").click(function(){
    			$("#form1").submit();
    		});

    	});
    </script>
  </body>
</html>
