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
		          <li><a href="profile.php">ข้อมูลส่วนตัว</a></li>
		          <li class="active"><a href="register.php">ลงทะเบียน</a></li>
		          <li><a href="courserunning.php">กำลังศึกษา</a></li>
		          <li><a href="std_exam.php">ทำแบบทดสอบ</a></li>
		
				<!--@End ######### Navigation panel editor place ########## -->
		
		        </ul>
		      </div><!--/.well -->
        </div><!--/span-->

        <div class="span9">

		  	<!--//Advertisement panel -->
		  	<!-- div class="hero-unit" -->
		  	<div class="hero-unit">
		  	  <div class="row">
				<div class="span3">
					<form id="form1" class="well" method="post">
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
					<!--@notification message handle -->
					<?php include 'layout/notification.php'; ?>
					
					<?php if ( isset( $course_id ) ) { ?>
					<!--@Start ######### Body content editor place ########## -->
					<h3>ลงทะเบียน</h3>
				    <p>
				    	<form id="form1" class="form-horizontal" method="post">
				    		<fieldset>

				    			<div class="control-group">
						        	<label class="control-label">วิชา</label>
						            <div class="controls">
						            	<input type="text" class="input-large disabled" value="<?=$course_name?>" disabled/>
						            </div>
						        </div>

						        <div class="control-group">
						        	<label class="control-label">ค่าลงทะเบียน</label>
						            <div class="controls">
						            	<input type="text" class="input-small disabled" value="<?=$course_fee?>" disabled/>
						            </div>
						        </div>

						        <div class="control-group">
						            <label class="control-label">เริ่มเมื่อ</label>
						            <div class="controls">
						              <div class="input-prepend">
									    <span class="add-on"><i class="icon-calendar"></i></span>
										<input class="input-medium disabled" type="text" value="<?=$course_start?>" disabled/>
									  </div>
						            </div>
						        </div>

						        <div class="control-group">
						            <label class="control-label">เสร็จสิ้น</label>
						            <div class="controls">
						              <div class="input-prepend">
									    <span class="add-on"><i class="icon-calendar"></i></span>
										<input class="input-medium disabled" type="text" value="<?=$course_end?>" disabled/>
									  </div>
						            </div>
						        </div>

						        <div class="control-group">
						        	<label class="control-label">&nbsp;</label>
						            <div class="controls">
						            	<p>
						            	  <div class="tabbable" style="margin-bottom: 18px;">
									        <ul class="nav nav-tabs">
									          <li class="active"><a href="#tab1" data-toggle="tab">ห้องเรียน</a></li>
									          <li><a href="#tab2" data-toggle="tab">ตารางเรียน</a></li>
									          <li><a href="#tab3" data-toggle="tab">ผู้สอน</a></li>
									          <li><a href="#tab4" data-toggle="tab">ภาควิชาพาณิชฯ</a></li>
									          <li><a href="#tab5" data-toggle="tab">เลือกทดสอบ</a></li>
									        </ul>
									        <div class="tab-content" style="padding-bottom: 9px; border-bottom: 1px solid #ddd;">
									          <div class="tab-pane active" id="tab1">
									            <p>
									            	<table class="table table-bordered">
												        <thead>
												          <tr>
												            <th>รหัสห้อง</th>
												            <th>เลขที่ห้อง</th>
												            <th>ที่นั่งทั้งหมด</th>
												          </tr>
												        </thead>
												        <tbody>
												        <?php 
												        	if ( $classelist ) {
												        		foreach ( $classelist as $key => $value ) {
												        ?>
												          <tr>
												            <td><?=$key?></td>
												            <td><?=$value['ROOM_NO']?></td>
												            <td><?=$value['MAX_SEAT']?></td>
												          </tr>
												         <?php
												         		}
												         	}
												         ?>
												        </tbody>
												    </table>
									            </p>
									          </div>
									          <div class="tab-pane" id="tab2">
									            <p>
									              
									            	<table class="table table-bordered">
												        <thead>
												          <tr>
												            <th>วันที่</th>
												            <th>เริ่มเวลา</th>
												            <th>เลิกเวลา</th>
												            <th>จำนวนชั่วโมง</th>
												          </tr>
												        </thead>
												        <tbody>
												        <?php
												        	if ( $schedulelist ) {
												        		foreach ( $schedulelist as $key => $value ) {
												        ?>
												          <tr>
												            <td><?=$value['DAY']?></td>
												            <td><?=$value['BEGIN_TIME']?></td>
												            <td><?=$value['END_TIME']?></td>
												            <td><?=$value['HOURS']?></td>
												          </tr>
												        <?php
												        		} 
												        	}
												        ?>
												        </tbody>
												      </table>
									            </p>
									          </div>
									          <div class="tab-pane" id="tab3">
									            <p>
									            	  <table class="table table-bordered">
												        <thead>
												          <tr>
												            <th>รหัสผู้สอน</th>
												            <th>ชื่อผู้สอน</th>
												          </tr>
												        </thead>
												        <tbody>
												        <?php 
												        	if ( $trainerlist ) {
												        		foreach ( $trainerlist as $key => $value ) {
												        ?>
												          <tr>
												            <td><?=$key?></td>
												            <td><?=$value['FIRSTNAME']?> <?=$value['LASTNAME']?></td>
												          </tr>
												         <?php
												         		}
												         	}
												         ?>
												        </tbody>
												      </table>
									            </p>
									          </div>
									          <div class="tab-pane" id="tab4">
									            <p>
									            	<table class="table table-bordered">
												        <thead>
												          <tr>
												            <th>รหัสวิชาภาคพาณิชฯ</th>
												            <th>ชื่อวิชาภาคพาณิชฯ</th>
												          </tr>
												        </thead>
												        <tbody>
												        <?php 
												        	if ( $cbslist ) {
												        		foreach ( $cbslist as $key => $value ) {
												        ?>
												          <tr>
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
									          <div class="tab-pane" id="tab5">
									            <p>
									            	<table class="table table-bordered">
												        <thead>
												          <tr>
												          	<th>เลือก</th>
												            <th>รหัสแบบทดสอบ</th>
												            <th>คะแนนเต็ม</th>
												          </tr>
												        </thead>
												        <tbody>
												        <?php 
												        	if ( $examlist ) {
												        		foreach ( $examlist as $key => $value ) {
												        ?>
												          <tr>
												            <td><input type="radio" name="exam_no" value="<?=$key?>" /></td>
												            <td><?=$value['EXAM_NO']?></td>
												            <td><?=$value['FULL_SCORE']?></td>
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
						            </div>
						        </div>
						
						        <div class="form-actions">
						        	<input type="submit" name="course" value="ลงทะเบียน" class="btn btn-primary" />
							    	<input type="hidden" name="course_id" value="<?=$course_id?>" />  	
							    </div>

				    		</fieldset>
				    	</form>

		            </p>
		            <?php } ?>
          			<!--@End ######### Body content editor place ########## -->
          		</div>
          	  </div>
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
			$("#course_id").change(function(){
				$("#form1").submit();
			});
		});
	</script>
  </body>
</html>
