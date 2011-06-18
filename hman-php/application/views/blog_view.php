<html>
	<header>
		<title><?=$title?></title>
	</header>
	<body>
		<h3><?=$header?></h3>
		<p>
			<ol>
				<?php foreach($todo as $item): ?>
				<li><?=$item?></li>
				<?php endforeach; ?>
			</ol>
		</p>
	</body>
</html>
