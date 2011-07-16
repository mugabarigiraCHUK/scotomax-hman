<?php

class Blog extends CI_Controller {

	/**
	 * Construct
	 */
	public function __construct() {
		// Execute construct method on parent class		
		parent::__construct();

		$this->load->helper('url');
		$this->load->helper('form');
	}

	public function index() {
		
		//initial parameters for use in view page.
		$data['title'] = "Blog Viewer Rev 1.0.0";
		$data['header'] = "Welcome to Blog Viewer";

		//$data['todo'] = array('clean house','eat lunch','call mom');
		$data['query'] = $this->db->get('entries');

		// Load view with pass through parameters.
		$this->load->view('blog_view', $data);
	}

	public function comments() {
		//initial parameters for use in view page.
		$data['title'] = "Blog Viewer Rev 1.0.0";
		$data['header'] = "Welcome to Comment Viewer";

		$this->db->where('entry_id', $this->uri->segment(3));
		$data['query'] = $this->db->get('comments');

		// Load view with pass through parameters.
		$this->load->view('comment_view', $data);
	}

	public function comment_insert() {
		$this->db->insert('comments', $_POST);
		redirect('blog/comments/'.$_POST['entry_id']);
	}
	
}

?>
