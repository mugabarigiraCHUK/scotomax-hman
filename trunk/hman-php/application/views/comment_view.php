<html>
	<header>
		<title><?=$title?></title>
	</header>
	<body>
		<h3><?=$header?></h3>
		<p>
			<?php if ($query->num_rows() > 0): ?>
			
				<?php foreach($query->result() as $row): ?>
				
					<p><?=$row->body?></p>
					<p><?=$row->author?></p>
					<hr>

				<?php endforeach; ?>

			<?php endif; ?>

			<p><?=anchor('blog','Back to Blog');?></p>

			<?=form_open('blog/comment_insert');?>

				<?=form_hidden('entry_id', $this->uri->segment(3));?>
				<p><textarea name="body" row="10"></textarea></p>
				<p><input type="text" name="author" /></p>
				<p><input type="submit" value="Submit comment" /></p>

			</form>
		</p>
	</body>
</html>