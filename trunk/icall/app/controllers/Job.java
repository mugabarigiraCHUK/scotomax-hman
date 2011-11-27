package controllers;

import play.*;
import play.mvc.*;
import play.data.validation.*;

import java.util.*;

import models.*;

public class Job extends Controller {
	
	public static void index() {
		ticket();
	}

	public static void status() {
		
	}

	public static void ticket() {
		 render("job/ticket.html");
	}
	
}