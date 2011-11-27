package controllers;

import play.*;
import play.mvc.*;
import play.data.validation.*;

import java.util.*;

import models.*;

public class Workflow extends Controller {
	
	public static void index() {
		calendar();
	}

	public static void calendar() {
		render("workflow/calendar.html");
	}
	
}