<?php

class Home extends CI_Controller {

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
		$this->load->view('home_view');
	}

}

?>
