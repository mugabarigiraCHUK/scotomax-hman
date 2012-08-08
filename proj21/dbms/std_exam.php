<?php include 'config/configure.php'; ?>
<?php include 'controller/stdexam_controller.php'; ?>
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
		          <li><a href="register.php">ลงทะเบียน</a></li>
		          <li><a href="registered.php">กำลังศึกษา</a></li>
		          <li class="active"><a href="std_exam.php">ทำแบบทดสอบ</a></li>
		
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
						<label>แบบทดสอบ</label>
  						<select size="10" id="exam_no" name="exam_no" style="width: 150px;">
  							<?php 
  								if ( $examlist ) {
  									foreach ($examlist as $key => $value) {
  										if ( $key == $exam_no ) {
  											echo '<option value="'.$key.'" rel="tooltip" title="'.$value['EXAM_DESCRIPTION'].'" selected>'.$key.' - '.$value['COURSE_NAME'].'</option>';
  										} else {
  											echo '<option value="'.$key.'" rel="tooltip" title="'.$value['EXAM_DESCRIPTION'].'">'.$key.' - '.$value['COURSE_NAME'].'</option>';
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
					<?php if ( isset( $yourscore ) ) { ?>
						<p>
							<h3>คะแนน <?=$test?> ของคุณคือ</h3>
							<h1><?=$yourscore?></h1>
						</p>
					<?php } else if ( isset( $exam_no ) ) { ?>
					<!--@Start ######### Body content editor place ########## -->
					<h3>ลงทะเบียน</h3>
				    <p>
				    	<form id="form2" method="post">
				    	<div class="control-group">
				            <label class="control-label">โปรดเลือก</label>
				            <div class="controls">
				              <label class="radio">
				                <input type="radio" name="test" id="pretest" value="Pre-test" checked/>
				                Pre-test
				              </label>
				              <label class="radio">
				                <input type="radio" name="test" id="posttest" value="Post-test"/>
				                Post-test
				              </label>
				            </div>
				        </div>
				    	<table class="table table-bordered">
					        <thead>
					          <tr>
					            <th>#</th>
					            <th>คำถาม</th>
					            <th>คำตอบ</th>
					            <th>ข้อที่ถูก</th>
					          </tr>
					        </thead>
					        <?php if ( $nrows > 0 ) { ?>
					        <tbody>
					          <?php 
					          	$idx = 0;
					          	foreach ($exlist as $key => $value) { 
					          		$idx++;
					          ?>
					          	  <tr>
					          	  	<td rowspan="4">
					          	  		<?=$idx?>
					          	  		<input type="hidden" name="right<?=$idx?>" value="<?=$value['ANS']?>" />
					          	  	</td>
					          	  	<td rowspan="4">
					          	  		<?=iconv("TIS-620","UTF-8", $value['QUESTION'])?>
					          	  	</td>
					          	  	<td><?=iconv("TIS-620","UTF-8", $value['ANS1'])?></td>
					          	  	<td><input type="radio" name="ans<?=$idx?>" value="1"/></td>
					          	  </tr>
						          <tr>
						            <td><?=iconv("TIS-620","UTF-8", $value['ANS2'])?></td>
						            <td><input type="radio" name="ans<?=$idx?>" value="2"/></td>
						          </tr>
						          <tr>
						            <td><?=iconv("TIS-620","UTF-8", $value['ANS3'])?></td>
						            <td><input type="radio" name="ans<?=$idx?>" value="3"/></td>
						          </tr>
						          <tr>
						            <td><?=iconv("TIS-620","UTF-8", $value['ANS4'])?></td>
						            <td><input type="radio" name="ans<?=$idx?>" value="4"/></td>
						          </tr>
					          <?php } ?>
					        </tbody>
					        <?php } ?>
					        <tfoot>
					        	<tr>
					        		<td colspan="3">
					        			<input type="submit" name="std_exam" value="ตรวจข้อสอบ" class="btn btn-info" />
					        			<input type="hidden" name="exam_no" value="<?=$exam_no?>" />
					        			<input type="hidden" name="course_id" value="<?=$course_id?>" />
					        		</td>
					        	</tr>
					        </tfoot>
					      </table>
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
			$("#exam_no").change(function(){
				$("#form1").submit();
			});
		});
	</script>
  </body>
</html>
