<?php include 'config/configure.php'; ?>
<?php include 'controller/login_controller.php'; ?>
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
					<!-- // No authorize for navigation -->
		        </ul>
		      </div><!--/.well -->
        </div><!--/span-->

        <div class="span9">

		  	<!--//Advertisement panel -->
		  	<div class="hero-unit">
		  		<!--@notification message handle -->
				<?php include 'layout/notification.php'; ?>

				<!--@Start ######### Body content editor place ########## -->
            	<h3>เข้าสู่ระบบ</h3>
				<form class="form-horizontal" method="post">
			    	<fieldset>
			          
					 <div class="control-group">
			            <label class="control-label" for="username">ชื่อผู้ใช้</label>
			            <div class="controls">
			              <input type="text" class="input-xlarge" id="username" name="username">
			            </div>
			          </div>
			
			          <div class="control-group">
			            <label class="control-label" for="password">รหัสผ่าน</label>
			            <div class="controls">
			              <input type="password" class="input-xlarge" id="password" name="password">
			            </div>
			          </div>
			
			          <div class="form-actions">
			            <button type="submit" class="btn btn-primary">เข้าระบบ</button>
			          </div>
			
			        </fieldset>
			      </form>

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
