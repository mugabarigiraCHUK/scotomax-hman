package controllers;

import play.*;
import play.mvc.*;
import play.data.validation.*;

import java.util.*;

import models.*;

public class Customer extends Controller {
	
	public static void index() {
		customer();
	}

	public static void customer() {
		render("customer/customer.html");
	}
	
}