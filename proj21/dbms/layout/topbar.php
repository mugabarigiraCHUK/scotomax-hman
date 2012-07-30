<div class="navbar navbar-fixed-top">
  <div class="navbar-inner">
    <div class="container-fluid">
      <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </a>
      <a class="brand" href="/dbms"><strong>Training Center</strong></a>

	 <?php
		if ( $_SESSION['username'] ) {
	 ?>
	
			<div class="btn-group pull-right">
		        <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
		          <i class="icon-user"></i> <?=$_SESSION['username']?>
		          <span class="caret"></span>
		        </a>
		        <ul class="dropdown-menu">
		          <?php if ( $_SESSION["id_code"] == "13245768" ) { ?>
		            <li><a href="admin.php">Admin</a></li>
		          <?php } else { ?>
		            <li><a href="profile.php">Profile</a></li>
				  <?php } ?>		        
		          <li class="divider"></li>
		          <li><a href="controller/signout_controller.php">ออกจากระบบ</a></li>
		        </ul>
		      </div>
		
	<?php
		} else {
	?>
	
			<div class="btn-group pull-right">
		        <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
		          <i class="icon-user"></i> ผู้เข้าเยิ่ยม
		          <span class="caret"></span>
		        </a>    
				<ul class="dropdown-menu">
		          <li><a href="login.php">เข้าระบบ</a></li>
				  <li><a href="signup.php">สมัครสมาชิก</a></li>
		        </ul>
		    </div>
		
	<?php
		}
	 ?>
      
      <div class="nav-collapse">
        <ul class="nav">
          <li class="active"><a href="#">เปิดสอนหลักสูตรต่างๆ เพื่อเตรียมความพร้อม</a></li>
        </ul>
      </div><!--/.nav-collapse -->

    </div>
  </div>
</div>