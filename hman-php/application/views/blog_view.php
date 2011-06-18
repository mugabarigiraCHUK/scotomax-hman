<html>
	<header>
		<title><?=$title?></title>
	</header>
	<body>
		<h3><?=$header?></h3>
		<p>
			
			<?php foreach($query->result() as $row): ?>
				<h3><?=$row->title?></h3>
				<p><?=$row->body?></p>
				<p><?=anchor('blog/comments/'.$row->id,'Comments');?></p>
			<?php endforeach; ?>
			
		</p>
	</body>
</html>
