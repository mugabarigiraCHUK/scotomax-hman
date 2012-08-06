<?php include 'config/configure.php'; ?>
<?php include 'controller/exam_controller.php'; ?>
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
	            
				<h3>ข้อสอบวิชา</h3>
			    <p>
	            	<form id="form1" class="form-horizontal" method="post">
				    	<fieldset>
						
				          <div class="control-group">
				            <label class="control-label">แบบทดสอบ</label>
				            <div class="controls">
				        		<input type="text" class="input-large disabled" value="<?=$exam_no?>" disabled>
				            </div>
				          </div>

				          <div class="control-group">
				          	<label class="control-label">วิชา</label>
				          	<div class="controls">
				          		<input type="text" class="input-large disabled" value="<?=$course_name?>" disabled>
				          	</div>
				          </div>

				          <div class="control-group">
				            <label class="control-label">คะแนนเต็ม</label>
				            <div class="controls">
				              	<input type="text" class="input-small disabled" value="<?=$full_score?>" disabled>
				            </div>
				          </div>

				          <div class="control-group">
				            <label class="control-label">รายละเอียด</label>
				            <div class="controls">
				              <?=$exam_desc?>
				            </div>
				          </div>

				          <div class="form-actions">
					        <a href="series.php" class="btn btn-success">กลับ</a>
					        <a data-toggle="modal" href="#exammodal" class="btn btn-small btn-info">เพิ่มข้อสอบ</a>
					      </div>
				
				        </fieldset>
				    </form>

	            </p>
	            <p>
	            	  
	            	<table class="table table-bordered">
				        <thead>
				          <tr>
				            <th>#</th>
				            <th>&nbsp;</th>
				            <th>คำถาม</th>
				            <th>คำตอบ</th>
				            <th>ข้อที่ถูก</th>
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
				          	  	<td rowspan="4"><?=$idx?></td>
				          	  	<td rowspan="4">
				          	  		<a href="exam.php?exam_no=<?=$exam_no?>&remove_id=<?=$value['ITEM']?>" class="btn btn-small btn-danger" onclick="if (!confirm('คุณต้องการลบข้อมูลดังกล่าว?')) { return false; } ">ลบข้อมูล</a>
				          	  	</td>
				          	  	<td rowspan="4">
				          	  		<?=iconv("TIS-620","UTF-8", $value['QUESTION'])?>
				          	  	</td>
				          	  	<td><?=iconv("TIS-620","UTF-8", $value['ANS1'])?></td>
				          	  	<td><input class="disabled" type="checkbox" name="ans" disabled <?php if ( $value['ANS'] == 1 ) printf('checked'); ?>/></td>
				          	  </tr>
					          <tr>
					            <td><?=iconv("TIS-620","UTF-8", $value['ANS2'])?></td>
					            <td><input class="disabled" type="checkbox" name="ans" disabled <?php if ( $value['ANS'] == 2 ) printf('checked'); ?>/></td>
					          </tr>
					          <tr>
					            <td><?=iconv("TIS-620","UTF-8", $value['ANS3'])?></td>
					            <td><input class="disabled" type="checkbox" name="ans" disabled <?php if ( $value['ANS'] == 3 ) printf('checked'); ?>/></td>
					          </tr>
					          <tr>
					            <td><?=iconv("TIS-620","UTF-8", $value['ANS4'])?></td>
					            <td><input class="disabled" type="checkbox" name="ans" disabled <?php if ( $value['ANS'] == 4 ) printf('checked'); ?>/></td>
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

    <!-- ######################## Model for exam series creation #########################  -->
    <div id="exammodal" class="modal hide fade">
      	
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h3>ข้อสอบ</h3>
        </div>

        <div class="modal-body">

			<form id="form2" class="form-horizontal" method="post">
		    	<fieldset>
				
		          <div class="control-group">
		            <label class="control-label" for="item">ข้อสอบข้อที่*</label>
		            <div class="controls">
		        		<input type="text" class="input-mini" id="item" name="item" />
		        		<input type="hidden" id="exam_no" name="exam_no" value="<?=$exam_no?>" />
		            </div>
		          </div>

		          <div class="control-group">
		            <label class="control-label" for="question">คำถาม*</label>
		            <div class="controls">
		        		<input type="text" class="input-xlarge" id="question" name="question" />
		            </div>
		          </div>

		          <div class="control-group">
		            <label class="control-label" for="ans1">คำตอบที่ 1</label>
		            <div class="controls">
		            	<div class="input-prepend">
		        			<span class="add-on"><input type="radio" id="ans-1" name="ans" value="1" checked/></span>
		        			<input type="text" class="input-xlarge" id="ans1" name="ans1" />
		        		</div>
		            </div>
		          </div>

		          <div class="control-group">
		            <label class="control-label" for="ans2">คำตอบที่ 2</label>
		            <div class="controls">
		            	<div class="input-prepend">
		        			<span class="add-on"><input type="radio" id="ans-2" name="ans" value="2"/></span>
		        			<input type="text" class="input-xlarge" id="ans2" name="ans2" />
		        		</div>
		            </div>
		          </div>

		          <div class="control-group">
		            <label class="control-label" for="ans3">คำตอบที่ 3</label>
		            <div class="controls">
		        		<div class="input-prepend">
		        			<span class="add-on"><input type="radio" id="ans-3" name="ans" value="3"/></span>
		        			<input type="text" class="input-xlarge" id="ans3" name="ans3" />
		        		</div>
		            </div>
		          </div>

		          <div class="control-group">
		            <label class="control-label" for="ans4">คำตอบที่ 4</label>
		            <div class="controls">
		        		<div class="input-prepend">
		        			<span class="add-on"><input type="radio" id="ans-4" name="ans" value="4"/></span>
		        			<input type="text" class="input-xlarge" id="ans4" name="ans4" />
		        		</div>
		            </div>
		          </div>
		
		        </fieldset>
		    </form>

        </div>

        <div class="modal-footer">
          <a href="#" class="btn" data-dismiss="modal" >ปิด</a>
          <a href="#" id="cmdsubmit" class="btn btn-primary">เพิ่มข้อสอบ</a>
        </div>
    	
    </div>

    <?php include 'layout/javascript.php'; ?>
    <script type="text/javascript">
    	$(function(){

    		$("#cmdsubmit").click(function(){
    			$("#form2").submit();
    		});

    	});
    </script>
  </body>
</html>
