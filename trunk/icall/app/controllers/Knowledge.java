package controllers;

import play.*;
import play.mvc.*;
import play.data.validation.*;

import java.util.*;

import models.*;

public class Knowledge extends Controller {
	
	public static void index() {
		category();
	}

	public static void category() {
		render("knowledge/category.html");
	}

	public static void solution() {
		
	}

	public static void status() {
		
	}
	
}