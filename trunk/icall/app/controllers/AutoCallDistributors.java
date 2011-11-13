package controllers;

import play.*;
import play.mvc.*;
import play.data.validation.*;

import java.util.*;

import models.*;

public class AutoCallDistributors extends Controller {

    public static void index() {
    	flash.success("You entered into ACD route management page successfully.");
        List routes = AcdRoute.find("order by route_id desc").fetch();
        render("AutoCallDistributors/route.html", routes);
    }

    public static void condition() {
    	flash.success("You entered into ACD condition management page successfully.");
        List conditions = AcdCondition.find("order by condition_id desc").fetch();
    	render("AutoCallDistributors/condition.html", conditions);
    }

    public static void route() {
    	index();
    }

}