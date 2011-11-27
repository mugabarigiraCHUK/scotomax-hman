package controllers;

import play.*;
import play.mvc.*;
import play.data.validation.*;

import java.util.*;

import models.*;

public class Ivr extends Controller {
	
	public static void index() {
		callflow();
	}

	public static void callflow() {
		render("ivr/callflow.html");
	}
	
}