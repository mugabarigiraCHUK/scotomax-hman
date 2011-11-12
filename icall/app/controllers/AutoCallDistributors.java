package controllers;

import play.*;
import play.mvc.*;
import play.data.validation.*;

import java.util.*;

import models.*;

public class AutoCallDistributors extends Controller {

    public static void index() {
        render("AutoCallDistributors/route.html");
    }

    public static void condition() {
    	render("AutoCallDistributors/condition.html");
    }

    public static void route() {
    	index();
    }

}