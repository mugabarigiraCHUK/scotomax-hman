package controllers;

import play.*;
import play.mvc.*;
import play.data.validation.*;

import java.util.*;

import models.*;

public class Agent extends Controller {
	
	public static void index() {
		profile();
	}

	public static void level() {
		
	}

	public static void profile() {
		render("agent/profile.html");
	}

}