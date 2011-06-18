<?php

class Blog extends CI_Controller {

	function index() {
		//echo 'Hello World';
		$data['title'] = "Blog Viewer Rev 1.0.0";
		$data['header'] = "Welcome to Blog Viewer";
		$data['todo'] = array('clean house','eat lunch','call mom');

		$this->load->view('blog_view', $data);
	}
	
}

?>
